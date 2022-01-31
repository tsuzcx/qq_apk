package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static final Long cfd;
  public static final Long cfe;
  public static final Long cff;
  public static final Long cfh;
  public static final Long cfi;
  public static final Long cfj;
  public static final Long cfk;
  public static final Long cfl;
  public static final Long cfm;
  public static long cfo;
  private List<String> cfn;
  
  static
  {
    AppMethodBeat.i(137031);
    cfd = Long.valueOf(2592000000L);
    cfe = Long.valueOf(604800000L);
    cff = Long.valueOf(259200000L);
    cfh = Long.valueOf(172800000L);
    cfi = Long.valueOf(86400000L);
    cfj = Long.valueOf(43200000L);
    cfk = Long.valueOf(240000L);
    cfl = cfi;
    cfm = Long.valueOf(60000L);
    cfo = 0L;
    AppMethodBeat.o(137031);
  }
  
  public e()
  {
    AppMethodBeat.i(137027);
    this.cfn = new ArrayList(10);
    AppMethodBeat.o(137027);
  }
  
  private void dV(String paramString)
  {
    AppMethodBeat.i(137028);
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if ((localObject == null) || (localObject.length == 0))
      {
        b.i("MicroMsg.Mix.AudioScanConvertCacheController", "none files exist");
        AppMethodBeat.o(137028);
        return;
      }
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        String str = localObject[i];
        if (dW(str)) {
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
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete");
            dV(str);
          }
          else if (System.currentTimeMillis() - localFile.lastModified() > cfh.longValue())
          {
            b.e("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", new Object[] { localFile.getName(), localFile.getAbsolutePath() });
            localFile.delete();
          }
        }
      }
      AppMethodBeat.o(137028);
      return;
    }
    b.i("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", new Object[] { paramString });
    AppMethodBeat.o(137028);
  }
  
  private boolean dW(String paramString)
  {
    AppMethodBeat.i(137029);
    Iterator localIterator = this.cfn.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next()))
      {
        AppMethodBeat.o(137029);
        return true;
      }
    }
    AppMethodBeat.o(137029);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.e
 * JD-Core Version:    0.7.0.1
 */