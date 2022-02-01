package com.tencent.mm.av.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
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
        paramc = BitmapUtil.getBitmapNative(paramInt1, paramc.width, paramc.height);
        AppMethodBeat.o(130448);
        return paramc;
      }
      paramc = BitmapUtil.getBitmapNative(paramInt1);
      AppMethodBeat.o(130448);
      return paramc;
    }
    paramc = BitmapUtil.getBitmapNative(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(130448);
    return paramc;
  }
  
  public static Bitmap a(c paramc, InputStream paramInputStream, int paramInt1, int paramInt2, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(130445);
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0)) {
        paramc = BitmapUtil.decodeStream(paramInputStream, 0.0F, paramc.width, paramc.height);
      }
    }
    for (;;)
    {
      paramInputStream = paramc;
      if (paramBoolean1) {
        paramInputStream = BitmapUtil.extractThumbNail(paramc, paramInt1, paramInt2, false, true);
      }
      paramc = paramInputStream;
      if (paramFloat > 0.0F) {
        paramc = BitmapUtil.setAlpha(paramInputStream, paramFloat);
      }
      paramInputStream = paramc;
      if (paramBoolean2) {
        paramInputStream = BitmapUtil.setGrayscale(paramc);
      }
      AppMethodBeat.o(130445);
      return paramInputStream;
      paramc = BitmapUtil.decodeStream(paramInputStream);
      continue;
      paramc = BitmapUtil.decodeStream(paramInputStream, 0.0F, paramInt1, paramInt2);
    }
  }
  
  public static Bitmap a(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130443);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0))
      {
        paramc = BitmapUtil.getBitmapNative(paramString, paramc.width, paramc.height);
        AppMethodBeat.o(130443);
        return paramc;
      }
      paramc = BitmapUtil.getBitmapNative(paramString);
      AppMethodBeat.o(130443);
      return paramc;
    }
    paramc = BitmapUtil.extractThumbNail(paramString, paramInt2, paramInt1, false);
    AppMethodBeat.o(130443);
    return paramc;
  }
  
  public static Bitmap a(c paramc, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(130446);
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0)) {
        paramc = BitmapUtil.decodeByteArray(paramArrayOfByte, paramc.width, paramc.height);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        paramc = BitmapUtil.extractThumbNail(BitmapUtil.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2), paramInt1, paramInt2, false, true);
      }
      paramArrayOfByte = paramc;
      if (paramFloat > 0.0F) {
        paramArrayOfByte = BitmapUtil.setAlpha(paramc, paramFloat);
      }
      paramc = paramArrayOfByte;
      if (paramBoolean2) {
        paramc = BitmapUtil.setGrayscale(paramArrayOfByte);
      }
      AppMethodBeat.o(130446);
      return paramc;
      paramc = BitmapUtil.decodeByteArray(paramArrayOfByte);
      continue;
      paramc = BitmapUtil.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public static Bitmap b(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130444);
    BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(paramString);
    if ((localOptions != null) && ((localOptions.outWidth >= localOptions.outHeight * 2) || (localOptions.outWidth * 2 <= localOptions.outHeight)))
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        if ((paramc != null) && (paramc.width > 0) && (paramc.width > 0))
        {
          paramc = BitmapUtil.extractThumbNail(paramString, paramc.height, paramc.width, true);
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
          paramc = BitmapUtil.extractThumbNail(paramString, paramInt1, paramInt2, true);
          AppMethodBeat.o(130444);
          return paramc;
          Log.w("MicroMsg.imageloader.ImageLoaderUtils", "crop bitmap cant not un set width or height");
          paramInt1 = 0;
          paramInt2 = 0;
        }
      }
      paramc = BitmapUtil.extractThumbNail(paramString, paramInt2, paramInt1, true);
      AppMethodBeat.o(130444);
      return paramc;
    }
    paramc = BitmapUtil.extractThumbNail(paramString, paramInt2, paramInt1, false);
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
        paramc = BitmapUtil.extractThumbNailAssets(paramString, paramc.width, paramc.height);
        AppMethodBeat.o(130447);
        return paramc;
      }
      paramc = BitmapUtil.extractThumbNailAssets(paramString, 0, 0);
      AppMethodBeat.o(130447);
      return paramc;
    }
    catch (IOException paramc)
    {
      Log.e("MicroMsg.imageloader.ImageLoaderUtils", "get bitmap from assert failed. :%s", new Object[] { paramc.toString() });
      AppMethodBeat.o(130447);
    }
    paramc = BitmapUtil.extractThumbNailAssets(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(130447);
    return paramc;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.g.a
 * JD-Core Version:    0.7.0.1
 */