package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public static final Long hrF;
  public static final Long hrG;
  public static final Long hrH;
  public static final Long hrI;
  public static final Long hrJ;
  public static final Long hrK;
  public static final Long hrL;
  public static final Long hrM;
  public static final Long hrN;
  public static long hrP;
  public String appId;
  private List<String> hrO;
  
  static
  {
    AppMethodBeat.i(136779);
    hrF = Long.valueOf(2592000000L);
    hrG = Long.valueOf(604800000L);
    hrH = Long.valueOf(259200000L);
    hrI = Long.valueOf(172800000L);
    hrJ = Long.valueOf(86400000L);
    hrK = Long.valueOf(43200000L);
    hrL = Long.valueOf(240000L);
    hrM = hrJ;
    hrN = Long.valueOf(60000L);
    hrP = 0L;
    AppMethodBeat.o(136779);
  }
  
  public f()
  {
    AppMethodBeat.i(136775);
    this.hrO = new ArrayList(10);
    AppMethodBeat.o(136775);
  }
  
  private void iV(String paramString)
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
        if (iW(str)) {
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
            iV(str);
          }
          else if (System.currentTimeMillis() - localFile.lastModified() > hrI.longValue())
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
  
  private boolean iW(String paramString)
  {
    AppMethodBeat.i(136777);
    Iterator localIterator = this.hrO.iterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.f
 * JD-Core Version:    0.7.0.1
 */