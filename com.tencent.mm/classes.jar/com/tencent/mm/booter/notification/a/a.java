package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public final class a
{
  public Bitmap fJe;
  
  public static Bitmap T(String paramString1, String paramString2)
  {
    AppMethodBeat.i(20037);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(20037);
      return null;
    }
    String str = n.d(paramString2, "user_", g.getMessageDigest(paramString1.getBytes()), ".png", 1) + ".bm";
    try
    {
      paramString1 = new k(str);
      if (!paramString1.exists())
      {
        ae.w("MicroMsg.NotificationAvatar", "SmallBM get bm file not exsit:%s", new Object[] { str });
        AppMethodBeat.o(20037);
        return null;
      }
      i = (int)paramString1.length();
      if ((i <= 0) || ((i != 36864) && (i != 36880)))
      {
        ae.e("MicroMsg.NotificationAvatar", "SmallBM get bm invalid size:%d file:%s", new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(20037);
        return null;
      }
      if ((str == null) || (str.isEmpty()))
      {
        paramString1 = new FileNotFoundException("path is empty");
        AppMethodBeat.o(20037);
        throw paramString1;
      }
    }
    catch (Exception paramString2)
    {
      paramString1 = null;
      ae.e("MicroMsg.NotificationAvatar", "SmallBM get exception e:%s file:%s", new Object[] { paramString2.getMessage(), str });
      if (paramString1 == null) {}
    }
    catch (OutOfMemoryError paramString2)
    {
      for (;;)
      {
        try
        {
          int i;
          paramString1.close();
          AppMethodBeat.o(20037);
          return null;
          paramString1 = o.c(w.parseUri(str), null);
          try
          {
            paramString2 = ByteBuffer.allocateDirect(36864);
            paramString1.read(paramString2);
            paramString2.position(0);
            if (i != 36880) {
              break label488;
            }
            ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(16);
            paramString1.read(localByteBuffer);
            long l = localByteBuffer.getLong(0);
            if (l != 1L)
            {
              ae.e("MicroMsg.NotificationAvatar", "SmallBM get bm header invalid flag:%d size:%d file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), str });
              paramString1.close();
              AppMethodBeat.o(20037);
              return null;
            }
            bool = false;
            ae.d("MicroMsg.NotificationAvatar", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), str });
            paramString1.close();
            paramString1 = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
            paramString1.copyPixelsFromBuffer(paramString2);
            if (bool)
            {
              paramString2 = Bitmap.createBitmap(paramString1, 9, 9, 78, 78);
              ae.i("MicroMsg.NotificationAvatar", "recycle bitmap:%s", new Object[] { paramString1.toString() });
              paramString1.recycle();
              AppMethodBeat.o(20037);
              return paramString2;
            }
            AppMethodBeat.o(20037);
            return paramString1;
          }
          catch (OutOfMemoryError paramString2)
          {
            continue;
          }
          catch (Exception paramString2) {}
          paramString2 = paramString2;
          paramString1 = null;
          ae.e("MicroMsg.NotificationAvatar", "SmallBM get OutOfMemoryError e:%s file:%s", new Object[] { paramString2.getMessage(), str });
        }
        catch (Exception paramString1)
        {
          continue;
        }
        continue;
        label488:
        boolean bool = true;
      }
    }
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap)
  {
    AppMethodBeat.i(20036);
    if ((paramContext == null) || (paramBitmap == null))
    {
      AppMethodBeat.o(20036);
      return null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      int i = paramContext.getResources().getDimensionPixelSize(17104902) - paramContext.getResources().getDimensionPixelSize(2131166574);
      paramContext = h.a(h.a(paramBitmap, i, i, false, false), false, paramContext.getResources().getDimensionPixelSize(2131166573));
      AppMethodBeat.o(20036);
      return paramContext;
    }
    AppMethodBeat.o(20036);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.a
 * JD-Core Version:    0.7.0.1
 */