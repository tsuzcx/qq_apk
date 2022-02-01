package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.d.j;
import com.tencent.mm.audio.mix.i.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public static final Long duM;
  public static final Long duN;
  public static final Long duO;
  public static final Long duP;
  public static final Long duQ;
  public static final Long duR;
  public static final Long duS;
  public static final Long duT;
  public static final Long duU;
  public static long duW;
  public String appId;
  private List<String> duV;
  
  static
  {
    AppMethodBeat.i(136779);
    duM = Long.valueOf(2592000000L);
    duN = Long.valueOf(604800000L);
    duO = Long.valueOf(259200000L);
    duP = Long.valueOf(172800000L);
    duQ = Long.valueOf(86400000L);
    duR = Long.valueOf(43200000L);
    duS = Long.valueOf(240000L);
    duT = duQ;
    duU = Long.valueOf(60000L);
    duW = 0L;
    AppMethodBeat.o(136779);
  }
  
  public f()
  {
    AppMethodBeat.i(136775);
    this.duV = new ArrayList(10);
    AppMethodBeat.o(136775);
  }
  
  private void gI(String paramString)
  {
    AppMethodBeat.i(136776);
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if ((localObject == null) || (localObject.length == 0))
      {
        b.i("MicroMsg.Mix.AudioScanConvertCacheController", "none files exist");
        AppMethodBeat.o(136776);
        return;
      }
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        String str = localObject[i];
        if (gJ(str)) {
          b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is the block file, don't delete");
        }
        for (;;)
        {
          i += 1;
          break;
          str = paramString + File.separator + str;
          File localFile = new File(str);
          if (!localFile.exists())
          {
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file not exist");
          }
          else if (localFile.isDirectory())
          {
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete subFilePath:%s", new Object[] { str });
            gI(str);
          }
          else if (System.currentTimeMillis() - localFile.lastModified() > duP.longValue())
          {
            b.e("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", new Object[] { localFile.getName(), localFile.getAbsolutePath() });
            localFile.delete();
          }
        }
      }
      AppMethodBeat.o(136776);
      return;
    }
    b.i("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", new Object[] { paramString });
    AppMethodBeat.o(136776);
  }
  
  private boolean gJ(String paramString)
  {
    AppMethodBeat.i(136777);
    Iterator localIterator = this.duV.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next()))
      {
        AppMethodBeat.o(136777);
        return true;
      }
    }
    AppMethodBeat.o(136777);
    return false;
  }
  
  public final class a
    extends j
  {
    public a(String paramString)
    {
      super();
    }
    
    public final void run()
    {
      AppMethodBeat.i(136774);
      f.a(f.this);
      i.b(this);
      AppMethodBeat.o(136774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.f
 * JD-Core Version:    0.7.0.1
 */