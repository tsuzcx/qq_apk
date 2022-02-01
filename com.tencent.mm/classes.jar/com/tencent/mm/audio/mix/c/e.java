package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static final Long dcO;
  public static final Long dcP;
  public static final Long dcQ;
  public static final Long dcR;
  public static final Long dcS;
  public static final Long dcT;
  public static final Long dcU;
  public static final Long dcV;
  public static final Long dcW;
  public static long dcY;
  private List<String> dcX;
  
  static
  {
    AppMethodBeat.i(136779);
    dcO = Long.valueOf(2592000000L);
    dcP = Long.valueOf(604800000L);
    dcQ = Long.valueOf(259200000L);
    dcR = Long.valueOf(172800000L);
    dcS = Long.valueOf(86400000L);
    dcT = Long.valueOf(43200000L);
    dcU = Long.valueOf(240000L);
    dcV = dcS;
    dcW = Long.valueOf(60000L);
    dcY = 0L;
    AppMethodBeat.o(136779);
  }
  
  public e()
  {
    AppMethodBeat.i(136775);
    this.dcX = new ArrayList(10);
    AppMethodBeat.o(136775);
  }
  
  private void fN(String paramString)
  {
    AppMethodBeat.i(136776);
    Object localObject1 = new com.tencent.mm.vfs.e(paramString);
    if ((((com.tencent.mm.vfs.e)localObject1).exists()) && (((com.tencent.mm.vfs.e)localObject1).isDirectory()))
    {
      localObject1 = ((com.tencent.mm.vfs.e)localObject1).list();
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
        Object localObject2 = this.dcX.iterator();
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
          localObject2 = new com.tencent.mm.vfs.e(str);
          if (!((com.tencent.mm.vfs.e)localObject2).exists())
          {
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file not exist");
          }
          else if (((com.tencent.mm.vfs.e)localObject2).isDirectory())
          {
            b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete");
            fN(str);
          }
          else if (System.currentTimeMillis() - ((com.tencent.mm.vfs.e)localObject2).lastModified() > dcR.longValue())
          {
            b.e("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", new Object[] { ((com.tencent.mm.vfs.e)localObject2).getName(), q.B(((com.tencent.mm.vfs.e)localObject2).fOK()) });
            ((com.tencent.mm.vfs.e)localObject2).delete();
          }
        }
      }
      AppMethodBeat.o(136776);
      return;
    }
    b.i("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", new Object[] { paramString });
    AppMethodBeat.o(136776);
  }
  
  public final class a
    extends i
  {
    public a(String paramString)
    {
      super();
    }
    
    public final void run()
    {
      AppMethodBeat.i(136774);
      e.a(e.this);
      h.b(this);
      AppMethodBeat.o(136774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.e
 * JD-Core Version:    0.7.0.1
 */