package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static final Long ddQ;
  public static final Long ddR;
  public static final Long ddS;
  public static final Long ddT;
  public static final Long ddU;
  public static final Long ddV;
  public static final Long ddW;
  public static final Long ddX;
  public static final Long ddY;
  public static long dea;
  private List<String> ddZ;
  
  static
  {
    AppMethodBeat.i(136779);
    ddQ = Long.valueOf(2592000000L);
    ddR = Long.valueOf(604800000L);
    ddS = Long.valueOf(259200000L);
    ddT = Long.valueOf(172800000L);
    ddU = Long.valueOf(86400000L);
    ddV = Long.valueOf(43200000L);
    ddW = Long.valueOf(240000L);
    ddX = ddU;
    ddY = Long.valueOf(60000L);
    dea = 0L;
    AppMethodBeat.o(136779);
  }
  
  public e()
  {
    AppMethodBeat.i(136775);
    this.ddZ = new ArrayList(10);
    AppMethodBeat.o(136775);
  }
  
  private void fT(String paramString)
  {
    AppMethodBeat.i(136776);
    Object localObject1 = new k(paramString);
    if ((((k)localObject1).exists()) && (((k)localObject1).isDirectory()))
    {
      localObject1 = ((k)localObject1).list();
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        b.i("MicroMsg.Mix.AudioScanConvertCacheController", "none files exist");
        AppMethodBeat.o(136776);
        return;
      }
      int k = localObject1.length;
      int i = 0;
      if (i < k)
      {
        String str = localObject1[i];
        Object localObject2 = this.ddZ.iterator();
        int j;
        while (((Iterator)localObject2).hasNext()) {
          if (str.contains((String)((Iterator)localObject2).next()))
          {
            j = 1;
            label122:
            if (j == 0) {
              break label145;
            }
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is the block file, don't delete");
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label122;
          label145:
          str = paramString + "/" + str;
          localObject2 = new k(str);
          if (!((k)localObject2).exists())
          {
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file not exist");
          }
          else if (((k)localObject2).isDirectory())
          {
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete");
            fT(str);
          }
          else if (System.currentTimeMillis() - ((k)localObject2).lastModified() > ddT.longValue())
          {
            b.e("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", new Object[] { ((k)localObject2).getName(), w.B(((k)localObject2).fTh()) });
            ((k)localObject2).delete();
          }
        }
      }
      AppMethodBeat.o(136776);
      return;
    }
    b.i("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", new Object[] { paramString });
    AppMethodBeat.o(136776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.e
 * JD-Core Version:    0.7.0.1
 */