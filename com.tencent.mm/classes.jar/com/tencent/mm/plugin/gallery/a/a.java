package com.tencent.mm.plugin.gallery.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class a
{
  private static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt)
  {
    AppMethodBeat.i(111738);
    for (;;)
    {
      try
      {
        paramString = s.nv(paramString, "r").getFileDescriptor();
        if (paramString == null)
        {
          AppMethodBeat.o(111738);
          return null;
        }
        paramOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(paramString, null, paramOptions);
        i = paramOptions.outWidth;
        j = paramOptions.outHeight;
        if ((i == -1) || (j == -1))
        {
          Log.i("MicroMsg.GalleryBitmapUtil", "decode error, get invalid picture size");
          AppMethodBeat.o(111738);
          return null;
        }
        paramInt = Math.min(i, j) / paramInt;
        if (paramInt > 0) {
          continue;
        }
        paramInt = 1;
      }
      catch (Exception paramString)
      {
        int i;
        int j;
        Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", paramString, "decodeThumbnail fail!!!", new Object[0]);
        AppMethodBeat.o(111738);
        return null;
        paramInt -= 1;
        paramInt |= paramInt >> 16;
        paramInt |= paramInt >> 8;
        paramInt |= paramInt >> 4;
        paramInt |= paramInt >> 2;
        paramInt = (paramInt | paramInt >> 1) + 1;
        continue;
        paramOptions.inSampleSize = paramInt;
        paramOptions.inJustDecodeBounds = false;
        paramOptions.inMutable = true;
        paramOptions = BitmapFactory.decodeFileDescriptor(paramString, null, paramOptions);
        paramString = paramOptions;
        if (paramOptions.getWidth() * paramOptions.getHeight() < 640000) {
          continue;
        }
        paramString = Bitmap.createScaledBitmap(paramOptions, i / paramInt, j / paramInt, false);
        AppMethodBeat.o(111738);
        return paramString;
      }
      catch (Throwable paramString)
      {
        Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", paramString, "err!!", new Object[0]);
        AppMethodBeat.o(111738);
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        continue;
        if (paramInt <= 0) {
          continue;
        }
        if (paramInt <= 1073741824) {
          continue;
        }
        continue;
      }
      if (i / paramInt * (j / paramInt) < 640000) {
        continue;
      }
      paramInt *= 2;
    }
    paramString = new IllegalArgumentException("n is invalid: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(111738);
    throw paramString;
  }
  
  public static Bitmap dZ(String paramString, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(111737);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.GalleryBitmapUtil", "imgPath is invalid.");
      AppMethodBeat.o(111737);
      return null;
    }
    localOptions = new BitmapFactory.Options();
    for (;;)
    {
      try
      {
        arrayOfByte = new androidx.a.a.a(paramString).getThumbnail();
        if (arrayOfByte == null) {
          continue;
        }
        if (arrayOfByte == null)
        {
          localObject1 = localObject2;
          if (localObject1 == null) {
            continue;
          }
          Log.i("MicroMsg.GalleryBitmapUtil", "decode thumb success from exif.");
          AppMethodBeat.o(111737);
          return localObject1;
        }
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
        localObject1 = localObject2;
        if (localOptions.outWidth < paramInt) {
          continue;
        }
        localObject1 = localObject2;
        if (localOptions.outHeight < paramInt) {
          continue;
        }
        i = localOptions.outWidth;
        int j = localOptions.outHeight;
        i = Math.max(i / paramInt, j / paramInt);
        if (i > 1) {
          continue;
        }
        i = 1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        byte[] arrayOfByte;
        Object localObject1;
        Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", localFileNotFoundException, "failed to find file to read thumbnail: %s.", new Object[] { paramString });
        paramString = a(paramString, localOptions, paramInt);
        AppMethodBeat.o(111737);
        return paramString;
        int i = Integer.highestOneBit(i);
        continue;
        i /= 8;
        i *= 8;
        continue;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", localIndexOutOfBoundsException, "failed to get thumbnail from: %s.", new Object[] { paramString });
        continue;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.GalleryBitmapUtil", localException, "failed to get thumbnail from: %s.", new Object[] { paramString });
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        continue;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      localOptions.inSampleSize = i;
      localOptions.inJustDecodeBounds = false;
      localOptions.inMutable = true;
      localObject1 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    if (i <= 8) {
      if (i <= 0)
      {
        localObject1 = new IllegalArgumentException();
        AppMethodBeat.o(111737);
        throw ((Throwable)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.a
 * JD-Core Version:    0.7.0.1
 */