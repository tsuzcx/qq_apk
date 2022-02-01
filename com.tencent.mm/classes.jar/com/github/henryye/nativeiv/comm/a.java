package com.github.henryye.nativeiv.comm;

import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.b;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b<NativeBitmapStruct>
{
  HashMap<Integer, NativeImage> aQZ;
  private NativeImageJni jni;
  
  public a()
  {
    AppMethodBeat.i(127373);
    this.aQZ = new HashMap();
    this.jni = new NativeImageJni();
    Object localObject = this.jni;
    if (((NativeImageJni)localObject).mNativeInst != 0L)
    {
      localObject = new IllegalStateException("NativeImageJni not released last time");
      AppMethodBeat.o(127373);
      throw ((Throwable)localObject);
    }
    ((NativeImageJni)localObject).mNativeInst = ((NativeImageJni)localObject).nativeInit();
    AppMethodBeat.o(127373);
  }
  
  public final boolean a(c paramc)
  {
    return (paramc == c.aQQ) || (paramc == c.aQP);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(127375);
    Object localObject1 = this.jni;
    if (((NativeImageJni)localObject1).mNativeInst != 0L) {
      ((NativeImageJni)localObject1).nativeDestroy(((NativeImageJni)localObject1).mNativeInst);
    }
    localObject1 = new LinkedList();
    try
    {
      localIterator = this.aQZ.values().iterator();
      while (localIterator.hasNext()) {
        ((LinkedList)localObject1).push((NativeImage)localIterator.next());
      }
      this.aQZ.clear();
    }
    finally
    {
      AppMethodBeat.o(127375);
    }
    Iterator localIterator = localObject2.iterator();
    while (localIterator.hasNext()) {
      ((NativeImage)localIterator.next()).recycle();
    }
    localObject2.clear();
    AppMethodBeat.o(127375);
  }
  
  public final IBitmap<NativeBitmapStruct> ro()
  {
    AppMethodBeat.i(127374);
    NativeImage localNativeImage = new NativeImage(this.jni, this);
    AppMethodBeat.o(127374);
    return localNativeImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.a
 * JD-Core Version:    0.7.0.1
 */