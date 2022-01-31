package com.tencent.luggage.game.c;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.util.SparseArray;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.game.d.e.a;
import com.tencent.luggage.game.f.a.4;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.image.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

final class b$a
  implements com.github.henryye.nativeiv.a.b, a.a
{
  private boolean bAa;
  private final int bzX;
  private final int bzY;
  private com.github.henryye.nativeiv.a bzZ;
  
  public b$a(boolean paramBoolean)
  {
    AppMethodBeat.i(140339);
    this.bzX = 2048;
    this.bzY = 2048;
    this.bzZ = new com.github.henryye.nativeiv.a();
    com.github.henryye.nativeiv.a locala = this.bzZ;
    BitmapType localBitmapType = BitmapType.Native;
    com.github.henryye.nativeiv.comm.a locala1 = new com.github.henryye.nativeiv.comm.a();
    locala.auu.put(localBitmapType, locala1);
    this.bAa = paramBoolean;
    AppMethodBeat.o(140339);
  }
  
  private void a(String paramString1, e.a parama, String paramString2)
  {
    AppMethodBeat.i(140344);
    if (this.bAa) {
      com.tencent.luggage.game.d.e.uJ().a(parama, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(140344);
  }
  
  private static void fp(int paramInt)
  {
    AppMethodBeat.i(140345);
    ((com.tencent.mm.plugin.appbrand.o.a)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(807L, paramInt, 1L, false);
    AppMethodBeat.o(140345);
  }
  
  public final IBitmap a(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(140341);
    if (paramInputStream == null)
    {
      a(paramString, e.a.bAL, ah.getContext().getString(2131297133));
      fp(7);
      AppMethodBeat.o(140341);
      return null;
    }
    localb = new com.github.henryye.nativeiv.b(this.bzZ);
    localb.auA = this;
    if (localb.auz != null) {
      localb.auz.recycle();
    }
    if (paramInputStream != null) {}
    for (Object localObject1 = com.github.henryye.nativeiv.b.c.d(paramInputStream); localObject1 == null; localObject1 = null)
    {
      a(paramString, e.a.bAL, ah.getContext().getString(2131297134));
      fp(5);
      AppMethodBeat.o(140341);
      return null;
    }
    if (((com.github.henryye.nativeiv.bitmap.d)localObject1).auQ == com.github.henryye.nativeiv.bitmap.c.auO)
    {
      a(paramString, e.a.bAL, ah.getContext().getString(2131297129));
      fp(0);
      AppMethodBeat.o(140341);
      return null;
    }
    if ((((com.github.henryye.nativeiv.bitmap.d)localObject1).auR > 2048L) || (((com.github.henryye.nativeiv.bitmap.d)localObject1).auS > 2048L))
    {
      a(paramString, e.a.bAL, String.format(ah.getContext().getString(2131297135), new Object[] { Integer.valueOf(2048), Integer.valueOf(2048), Long.valueOf(((com.github.henryye.nativeiv.bitmap.d)localObject1).auR), Long.valueOf(((com.github.henryye.nativeiv.bitmap.d)localObject1).auS) }));
      fp(3);
      AppMethodBeat.o(140341);
      return null;
    }
    Object localObject3;
    Object localObject4;
    if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      ab.i("MicroMsg.MBImageHandlerRegistry", "hy: decode path:%s", new Object[] { paramString });
      localConfig = Bitmap.Config.ARGB_8888;
      localc = ((com.github.henryye.nativeiv.bitmap.d)localObject1).auQ;
      if (paramInputStream != null)
      {
        if (localb.auy == null) {
          break label520;
        }
        localObject1 = localb.auB;
        i = localb.hashCode();
        localObject3 = localb.auy;
        localObject4 = (Map)((com.github.henryye.nativeiv.a)localObject1).auv.get(i);
        if ((localObject4 == null) || (((Map)localObject4).get(localObject3) == null)) {
          break label474;
        }
        localObject1 = ((com.github.henryye.nativeiv.bitmap.b)((Map)localObject4).get(localObject3)).mt();
        label389:
        localb.auz = ((IBitmap)localObject1);
        label396:
        j = 0;
      }
    }
    for (;;)
    {
      try
      {
        localb.auz.decodeInputStream(paramInputStream, localConfig, localc);
        localObject1 = localb.auz.provide();
        if (localObject1 == null) {
          continue;
        }
        i = 1;
      }
      catch (IOException localIOException1)
      {
        c.c.printStackTrace("Ni.BitmapWrapper", localIOException1, "hy: decodeInputStream", new Object[0]);
        localb.auA.h(paramString, 1);
        j = 1;
        i = 0;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        c.c.printStackTrace("Ni.BitmapWrapper", localOutOfMemoryError1, "hy: decodeInputStream", new Object[0]);
        localb.auA.h(paramString, 2);
        j = 1;
        i = 0;
        continue;
      }
      catch (Throwable localThrowable1)
      {
        label474:
        c.c.printStackTrace("Ni.BitmapWrapper", localThrowable1, "hy: decode image exception", new Object[0]);
        label520:
        localb.auA.h(paramString, 3);
        i = 0;
        continue;
        try
        {
          j = paramInputStream.available();
          l = j;
          if ((i == 0) && (localb.auz.getType() == BitmapType.Native))
          {
            c.c.i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
            localb.auz = ((com.github.henryye.nativeiv.bitmap.b)localb.auB.auu.get(BitmapType.Legacy)).mt();
          }
        }
        catch (IOException localIOException2)
        {
          try
          {
            localb.auz.decodeInputStream(paramInputStream, localConfig, localc);
            localb.auA.d(l, localb.auz.getDecodeTime());
            if (localb.auz.getType() == BitmapType.Legacy) {
              localb.auA.h(paramString, 4);
            }
            if (localb.auz.provide() == null)
            {
              localb.auz.recycle();
              localb.auz = null;
            }
            com.tencent.magicbrush.d.e.b(paramInputStream);
            continue;
            localIOException2 = localIOException2;
            c.c.printStackTrace("Ni.BitmapWrapper", localIOException2, "", new Object[0]);
            long l = 0L;
          }
          catch (IOException localIOException3)
          {
            c.c.printStackTrace("Ni.BitmapWrapper", localIOException3, "hy: IOException when use legacy", new Object[0]);
            localb.auA.h(paramString, 1);
            continue;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            c.c.printStackTrace("Ni.BitmapWrapper", localOutOfMemoryError2, "hy: decodeInputStream", new Object[0]);
            localb.auA.h(paramString, 2);
            continue;
          }
          catch (Throwable localThrowable2)
          {
            c.c.printStackTrace("Ni.BitmapWrapper", localThrowable2, "hy: decode image exception", new Object[0]);
            localb.auA.h(paramString, 3);
            continue;
          }
        }
        Object localObject2 = null;
        continue;
      }
      if (j == 0) {
        continue;
      }
      com.tencent.magicbrush.d.e.b(paramInputStream);
      paramString = localb.auz;
      AppMethodBeat.o(140341);
      return paramString;
      ab.i("MicroMsg.MBImageHandlerRegistry", "hy: decode path:%.100s", new Object[] { paramString });
      break;
      if (((com.github.henryye.nativeiv.a)localObject1).auu.get(localObject3) != null)
      {
        localObject1 = ((com.github.henryye.nativeiv.bitmap.b)((com.github.henryye.nativeiv.a)localObject1).auu.get(localObject3)).mt();
        break label389;
      }
      localObject1 = null;
      break label389;
      localObject4 = localb.auB;
      i = localb.hashCode();
      localObject1 = (Map)((com.github.henryye.nativeiv.a)localObject4).auv.get(i);
      if (localObject1 == null) {
        continue;
      }
      localObject1 = com.github.henryye.nativeiv.a.a(localc, (Map)localObject1);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = com.github.henryye.nativeiv.a.a(localc, ((com.github.henryye.nativeiv.a)localObject4).auu);
      }
      localb.auz = ((IBitmap)localObject3);
      break label396;
      i = 0;
    }
  }
  
  public final void d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(140343);
    com.tencent.luggage.game.f.a locala = com.tencent.luggage.game.f.a.vN();
    ab.i("MicroMsg.MBNiReporter", "hy: size:%d,cost:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    com.tencent.mm.sdk.g.d.ysm.execute(new a.4(locala, paramLong1));
    locala.bCs.add(Long.valueOf(paramLong2));
    if (paramLong2 >= 1000L) {
      fp(11);
    }
    AppMethodBeat.o(140343);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140340);
    com.github.henryye.nativeiv.a locala = this.bzZ;
    int i = 0;
    while (i < locala.auv.size())
    {
      int j = locala.auv.keyAt(i);
      com.github.henryye.nativeiv.a.b((Map)locala.auv.get(j));
      i += 1;
    }
    com.github.henryye.nativeiv.a.b(locala.auu);
    AppMethodBeat.o(140340);
  }
  
  public final void h(String paramString, int paramInt)
  {
    AppMethodBeat.i(140342);
    if (paramInt == 1)
    {
      ab.e("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", new Object[] { paramString });
      a(paramString, e.a.bAL, ah.getContext().getString(2131297130));
      fp(4);
      AppMethodBeat.o(140342);
      return;
    }
    if (paramInt == 2)
    {
      ab.e("MicroMsg.MBImageHandlerRegistry", "OUTOFMEMORY path:%s", new Object[] { paramString });
      a(paramString, e.a.bAL, ah.getContext().getString(2131297131));
      fp(1);
      AppMethodBeat.o(140342);
      return;
    }
    if (paramInt == 3)
    {
      ab.e("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", new Object[] { paramString });
      a(paramString, e.a.bAL, ah.getContext().getString(2131297126));
      fp(5);
      AppMethodBeat.o(140342);
      return;
    }
    if (paramInt == 4)
    {
      ab.i("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", new Object[] { paramString });
      fp(8);
    }
    AppMethodBeat.o(140342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.c.b.a
 * JD-Core Version:    0.7.0.1
 */