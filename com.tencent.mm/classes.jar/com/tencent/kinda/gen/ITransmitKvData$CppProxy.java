package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

final class ITransmitKvData$CppProxy
  extends ITransmitKvData
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141233);
    if (!ITransmitKvData.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141233);
      return;
    }
  }
  
  private ITransmitKvData$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141210);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141210);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141210);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native byte[] native_getBinary(long paramLong, String paramString);
  
  private native boolean native_getBool(long paramLong, String paramString);
  
  private native ArrayList<Boolean> native_getBoolList(long paramLong, String paramString);
  
  private native int native_getInt(long paramLong, String paramString);
  
  private native ArrayList<Integer> native_getIntList(long paramLong, String paramString);
  
  private native KJSEvent native_getJSEvent(long paramLong, String paramString);
  
  private native long native_getLong(long paramLong, String paramString);
  
  private native ArrayList<Long> native_getLongList(long paramLong, String paramString);
  
  private native String native_getString(long paramLong, String paramString);
  
  private native ArrayList<String> native_getStringList(long paramLong, String paramString);
  
  private native void native_putBinary(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private native void native_putBool(long paramLong, String paramString, boolean paramBoolean);
  
  private native void native_putInt(long paramLong, String paramString, int paramInt);
  
  private native void native_putJSEvent(long paramLong, String paramString, KJSEvent paramKJSEvent);
  
  private native void native_putListBool(long paramLong, String paramString, ArrayList<Boolean> paramArrayList);
  
  private native void native_putListInt(long paramLong, String paramString, ArrayList<Integer> paramArrayList);
  
  private native void native_putListLong(long paramLong, String paramString, ArrayList<Long> paramArrayList);
  
  private native void native_putListString(long paramLong, String paramString, ArrayList<String> paramArrayList);
  
  private native void native_putLong(long paramLong1, String paramString, long paramLong2);
  
  private native void native_putString(long paramLong, String paramString1, String paramString2);
  
  public final void destroy()
  {
    AppMethodBeat.i(141211);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141211);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141212);
    destroy();
    super.finalize();
    AppMethodBeat.o(141212);
  }
  
  public final byte[] getBinary(String paramString)
  {
    AppMethodBeat.i(141227);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141227);
      throw paramString;
    }
    paramString = native_getBinary(this.nativeRef, paramString);
    AppMethodBeat.o(141227);
    return paramString;
  }
  
  public final boolean getBool(String paramString)
  {
    AppMethodBeat.i(141224);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141224);
      throw paramString;
    }
    boolean bool = native_getBool(this.nativeRef, paramString);
    AppMethodBeat.o(141224);
    return bool;
  }
  
  public final ArrayList<Boolean> getBoolList(String paramString)
  {
    AppMethodBeat.i(141230);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141230);
      throw paramString;
    }
    paramString = native_getBoolList(this.nativeRef, paramString);
    AppMethodBeat.o(141230);
    return paramString;
  }
  
  public final int getInt(String paramString)
  {
    AppMethodBeat.i(141223);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141223);
      throw paramString;
    }
    int i = native_getInt(this.nativeRef, paramString);
    AppMethodBeat.o(141223);
    return i;
  }
  
  public final ArrayList<Integer> getIntList(String paramString)
  {
    AppMethodBeat.i(141229);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141229);
      throw paramString;
    }
    paramString = native_getIntList(this.nativeRef, paramString);
    AppMethodBeat.o(141229);
    return paramString;
  }
  
  public final KJSEvent getJSEvent(String paramString)
  {
    AppMethodBeat.i(141228);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141228);
      throw paramString;
    }
    paramString = native_getJSEvent(this.nativeRef, paramString);
    AppMethodBeat.o(141228);
    return paramString;
  }
  
  public final long getLong(String paramString)
  {
    AppMethodBeat.i(141225);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141225);
      throw paramString;
    }
    long l = native_getLong(this.nativeRef, paramString);
    AppMethodBeat.o(141225);
    return l;
  }
  
  public final ArrayList<Long> getLongList(String paramString)
  {
    AppMethodBeat.i(141231);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141231);
      throw paramString;
    }
    paramString = native_getLongList(this.nativeRef, paramString);
    AppMethodBeat.o(141231);
    return paramString;
  }
  
  public final String getString(String paramString)
  {
    AppMethodBeat.i(141226);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141226);
      throw paramString;
    }
    paramString = native_getString(this.nativeRef, paramString);
    AppMethodBeat.o(141226);
    return paramString;
  }
  
  public final ArrayList<String> getStringList(String paramString)
  {
    AppMethodBeat.i(141232);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141232);
      throw paramString;
    }
    paramString = native_getStringList(this.nativeRef, paramString);
    AppMethodBeat.o(141232);
    return paramString;
  }
  
  public final void putBinary(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(141217);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141217);
      throw paramString;
    }
    native_putBinary(this.nativeRef, paramString, paramArrayOfByte);
    AppMethodBeat.o(141217);
  }
  
  public final void putBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(141214);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141214);
      throw paramString;
    }
    native_putBool(this.nativeRef, paramString, paramBoolean);
    AppMethodBeat.o(141214);
  }
  
  public final void putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(141213);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141213);
      throw paramString;
    }
    native_putInt(this.nativeRef, paramString, paramInt);
    AppMethodBeat.o(141213);
  }
  
  public final void putJSEvent(String paramString, KJSEvent paramKJSEvent)
  {
    AppMethodBeat.i(141218);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141218);
      throw paramString;
    }
    native_putJSEvent(this.nativeRef, paramString, paramKJSEvent);
    AppMethodBeat.o(141218);
  }
  
  public final void putListBool(String paramString, ArrayList<Boolean> paramArrayList)
  {
    AppMethodBeat.i(141220);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141220);
      throw paramString;
    }
    native_putListBool(this.nativeRef, paramString, paramArrayList);
    AppMethodBeat.o(141220);
  }
  
  public final void putListInt(String paramString, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(141219);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141219);
      throw paramString;
    }
    native_putListInt(this.nativeRef, paramString, paramArrayList);
    AppMethodBeat.o(141219);
  }
  
  public final void putListLong(String paramString, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(141221);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141221);
      throw paramString;
    }
    native_putListLong(this.nativeRef, paramString, paramArrayList);
    AppMethodBeat.o(141221);
  }
  
  public final void putListString(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(141222);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141222);
      throw paramString;
    }
    native_putListString(this.nativeRef, paramString, paramArrayList);
    AppMethodBeat.o(141222);
  }
  
  public final void putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(141215);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141215);
      throw paramString;
    }
    native_putLong(this.nativeRef, paramString, paramLong);
    AppMethodBeat.o(141215);
  }
  
  public final void putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141216);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString1 = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141216);
      throw paramString1;
    }
    native_putString(this.nativeRef, paramString1, paramString2);
    AppMethodBeat.o(141216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.ITransmitKvData.CppProxy
 * JD-Core Version:    0.7.0.1
 */