package com.google.android.gms.common.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class DataUtils
{
  public static void copyStringToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    AppMethodBeat.i(90143);
    if (TextUtils.isEmpty(paramString)) {
      paramCharArrayBuffer.sizeCopied = 0;
    }
    for (;;)
    {
      paramCharArrayBuffer.sizeCopied = paramString.length();
      AppMethodBeat.o(90143);
      return;
      if ((paramCharArrayBuffer.data == null) || (paramCharArrayBuffer.data.length < paramString.length())) {
        paramCharArrayBuffer.data = paramString.toCharArray();
      } else {
        paramString.getChars(0, paramString.length(), paramCharArrayBuffer.data, 0);
      }
    }
  }
  
  public static byte[] loadImageBytes(AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(90145);
    try
    {
      paramAssetManager = IOUtils.readInputStreamFully(paramAssetManager.open(paramString));
      AppMethodBeat.o(90145);
      return paramAssetManager;
    }
    catch (IOException paramAssetManager)
    {
      paramAssetManager = new RuntimeException(paramAssetManager);
      AppMethodBeat.o(90145);
      throw paramAssetManager;
    }
  }
  
  @VisibleForTesting
  public static byte[] loadImageBytes(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(90144);
    try
    {
      paramResources = IOUtils.readInputStreamFully(paramResources.openRawResource(paramInt));
      AppMethodBeat.o(90144);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      paramResources = new RuntimeException(paramResources);
      AppMethodBeat.o(90144);
      throw paramResources;
    }
  }
  
  public static byte[] loadImageBytes(Bitmap paramBitmap)
  {
    AppMethodBeat.i(90147);
    paramBitmap = loadImageBytes(paramBitmap, 100);
    AppMethodBeat.o(90147);
    return paramBitmap;
  }
  
  public static byte[] loadImageBytes(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(90148);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(90148);
    return paramBitmap;
  }
  
  public static byte[] loadImageBytes(BitmapDrawable paramBitmapDrawable)
  {
    AppMethodBeat.i(90146);
    paramBitmapDrawable = loadImageBytes(paramBitmapDrawable.getBitmap());
    AppMethodBeat.o(90146);
    return paramBitmapDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.DataUtils
 * JD-Core Version:    0.7.0.1
 */