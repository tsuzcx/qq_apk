package com.tencent.mm.aw.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  public static Bitmap a(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(130448);
    if ((paramInt2 <= 0) || (paramInt3 <= 0))
    {
      if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0))
      {
        paramc = g.aK(paramInt1, paramc.width, paramc.height);
        AppMethodBeat.o(130448);
        return paramc;
      }
      paramc = g.aat(paramInt1);
      AppMethodBeat.o(130448);
      return paramc;
    }
    paramc = g.aK(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(130448);
    return paramc;
  }
  
  public static Bitmap a(c paramc, InputStream paramInputStream, int paramInt1, int paramInt2, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(130445);
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0)) {
        paramc = g.a(paramInputStream, 0.0F, paramc.width, paramc.height);
      }
    }
    for (;;)
    {
      paramInputStream = paramc;
      if (paramBoolean1) {
        paramInputStream = g.a(paramc, paramInt1, paramInt2, false, true);
      }
      paramc = paramInputStream;
      if (paramFloat > 0.0F) {
        paramc = g.b(paramInputStream, paramFloat);
      }
      paramInputStream = paramc;
      if (paramBoolean2) {
        paramInputStream = g.aC(paramc);
      }
      AppMethodBeat.o(130445);
      return paramInputStream;
      paramc = g.decodeStream(paramInputStream);
      continue;
      paramc = g.a(paramInputStream, 0.0F, paramInt1, paramInt2);
    }
  }
  
  public static Bitmap a(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130443);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0))
      {
        paramc = g.aM(paramString, paramc.width, paramc.height);
        AppMethodBeat.o(130443);
        return paramc;
      }
      paramc = g.aQf(paramString);
      AppMethodBeat.o(130443);
      return paramc;
    }
    paramc = g.d(paramString, paramInt2, paramInt1, false);
    AppMethodBeat.o(130443);
    return paramc;
  }
  
  public static Bitmap a(c paramc, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(130446);
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0)) {
        paramc = g.decodeByteArray(paramArrayOfByte, paramc.width, paramc.height);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        paramc = g.a(g.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2), paramInt1, paramInt2, false, true);
      }
      paramArrayOfByte = paramc;
      if (paramFloat > 0.0F) {
        paramArrayOfByte = g.b(paramc, paramFloat);
      }
      paramc = paramArrayOfByte;
      if (paramBoolean2) {
        paramc = g.aC(paramArrayOfByte);
      }
      AppMethodBeat.o(130446);
      return paramc;
      paramc = g.cr(paramArrayOfByte);
      continue;
      paramc = g.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public static Bitmap b(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130444);
    BitmapFactory.Options localOptions = g.aQc(paramString);
    if ((localOptions != null) && ((localOptions.outWidth >= localOptions.outHeight * 2) || (localOptions.outWidth * 2 <= localOptions.outHeight)))
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0))
        {
          paramc = g.d(paramString, paramc.height, paramc.width, true);
          AppMethodBeat.o(130444);
          return paramc;
        }
        if ((paramc != null) && (paramc.getImageView() != null))
        {
          paramInt2 = paramc.getImageView().getMeasuredWidth();
          paramInt1 = paramc.getImageView().getMeasuredHeight();
        }
        for (;;)
        {
          paramc = g.d(paramString, paramInt1, paramInt2, true);
          AppMethodBeat.o(130444);
          return paramc;
          ad.w("MicroMsg.imageloader.ImageLoaderUtils", "crop bitmap cant not un set width or height");
          paramInt1 = 0;
          paramInt2 = 0;
        }
      }
      paramc = g.d(paramString, paramInt2, paramInt1, true);
      AppMethodBeat.o(130444);
      return paramc;
    }
    paramc = g.d(paramString, paramInt2, paramInt1, false);
    AppMethodBeat.o(130444);
    return paramc;
  }
  
  public static Bitmap c(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130447);
    if (((paramInt1 > 0) && (paramInt2 > 0)) || (paramc != null)) {}
    try
    {
      if ((paramc.width > 0) && (paramc.width > 0))
      {
        paramc = g.aN(paramString, paramc.width, paramc.height);
        AppMethodBeat.o(130447);
        return paramc;
      }
      paramc = g.aN(paramString, 0, 0);
      AppMethodBeat.o(130447);
      return paramc;
    }
    catch (IOException paramc)
    {
      ad.e("MicroMsg.imageloader.ImageLoaderUtils", "get bitmap from assert failed. :%s", new Object[] { paramc.toString() });
      AppMethodBeat.o(130447);
    }
    paramc = g.aN(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(130447);
    return paramc;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a.g.a
 * JD-Core Version:    0.7.0.1
 */