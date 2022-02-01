package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import com.bumptech.glide.c.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class j
{
  private static final char[] aOf;
  private static final char[] aOg;
  
  static
  {
    AppMethodBeat.i(77784);
    aOf = "0123456789abcdef".toCharArray();
    aOg = new char[64];
    AppMethodBeat.o(77784);
  }
  
  public static boolean aZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77774);
    if ((dw(paramInt1)) && (dw(paramInt2)))
    {
      AppMethodBeat.o(77774);
      return true;
    }
    AppMethodBeat.o(77774);
    return false;
  }
  
  public static int b(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(77783);
    if (paramObject == null) {}
    for (int i = 0;; i = paramObject.hashCode())
    {
      AppMethodBeat.o(77783);
      return i + paramInt * 31;
    }
  }
  
  public static <T> List<T> c(Collection<T> paramCollection)
  {
    AppMethodBeat.i(77779);
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    AppMethodBeat.o(77779);
    return localArrayList;
  }
  
  public static int d(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return i + paramInt * 31;
    }
  }
  
  private static boolean dw(int paramInt)
  {
    return (paramInt > 0) || (paramInt == -2147483648);
  }
  
  public static <T> Queue<T> dx(int paramInt)
  {
    AppMethodBeat.i(77778);
    ArrayDeque localArrayDeque = new ArrayDeque(paramInt);
    AppMethodBeat.o(77778);
    return localArrayDeque;
  }
  
  public static boolean g(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(77780);
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
      {
        AppMethodBeat.o(77780);
        return true;
      }
      AppMethodBeat.o(77780);
      return false;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(77780);
    return bool;
  }
  
  public static boolean h(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(77781);
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
      {
        AppMethodBeat.o(77781);
        return true;
      }
      AppMethodBeat.o(77781);
      return false;
    }
    if ((paramObject1 instanceof l))
    {
      bool = ((l)paramObject1).po();
      AppMethodBeat.o(77781);
      return bool;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(77781);
    return bool;
  }
  
  public static int hashCode(float paramFloat)
  {
    AppMethodBeat.i(77782);
    int i = Float.floatToIntBits(paramFloat);
    AppMethodBeat.o(77782);
    return i + 527;
  }
  
  public static int hashCode(int paramInt1, int paramInt2)
  {
    return paramInt2 * 31 + paramInt1;
  }
  
  public static int i(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77773);
    Bitmap.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = Bitmap.Config.ARGB_8888;
    }
    int i;
    switch (1.$SwitchMap$android$graphics$Bitmap$Config[localConfig.ordinal()])
    {
    default: 
      i = 4;
    }
    for (;;)
    {
      AppMethodBeat.o(77773);
      return i * (paramInt1 * paramInt2);
      i = 1;
      continue;
      i = 2;
      continue;
      i = 8;
    }
  }
  
  @TargetApi(19)
  public static int k(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77772);
    if (paramBitmap.isRecycled())
    {
      paramBitmap = new IllegalStateException("Cannot obtain size for recycled Bitmap: " + paramBitmap + "[" + paramBitmap.getWidth() + "x" + paramBitmap.getHeight() + "] " + paramBitmap.getConfig());
      AppMethodBeat.o(77772);
      throw paramBitmap;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        i = paramBitmap.getAllocationByteCount();
        AppMethodBeat.o(77772);
        return i;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getRowBytes();
    AppMethodBeat.o(77772);
    return i * j;
  }
  
  public static String m(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77771);
    synchronized (aOg)
    {
      char[] arrayOfChar2 = aOg;
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i] & 0xFF;
        arrayOfChar2[(i * 2)] = aOf[(j >>> 4)];
        arrayOfChar2[(i * 2 + 1)] = aOf[(j & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String(arrayOfChar2);
      AppMethodBeat.o(77771);
      return paramArrayOfByte;
    }
  }
  
  public static void qs()
  {
    AppMethodBeat.i(77775);
    if (!qt())
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("You must call this method on the main thread");
      AppMethodBeat.o(77775);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(77775);
  }
  
  public static boolean qt()
  {
    AppMethodBeat.i(77776);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(77776);
      return true;
    }
    AppMethodBeat.o(77776);
    return false;
  }
  
  public static boolean qu()
  {
    AppMethodBeat.i(77777);
    if (!qt())
    {
      AppMethodBeat.o(77777);
      return true;
    }
    AppMethodBeat.o(77777);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.h.j
 * JD-Core Version:    0.7.0.1
 */