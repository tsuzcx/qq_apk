package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ITransmitKvData
{
  public static native ITransmitKvData create();
  
  public abstract ArrayList<String> allKeys();
  
  public abstract byte[] getBinary(String paramString);
  
  public abstract boolean getBool(String paramString);
  
  public abstract ArrayList<Boolean> getBoolList(String paramString);
  
  public abstract int getInt(String paramString);
  
  public abstract ArrayList<Integer> getIntList(String paramString);
  
  public abstract KJSEvent getJSEvent(String paramString);
  
  public abstract ITransmitKvData getKvData(String paramString);
  
  public abstract long getLong(String paramString);
  
  public abstract ArrayList<Long> getLongList(String paramString);
  
  public abstract String getString(String paramString);
  
  public abstract ArrayList<String> getStringList(String paramString);
  
  public abstract void putBinary(String paramString, byte[] paramArrayOfByte);
  
  public abstract void putBool(String paramString, boolean paramBoolean);
  
  public abstract void putInt(String paramString, int paramInt);
  
  public abstract void putJSEvent(String paramString, KJSEvent paramKJSEvent);
  
  public abstract void putKvData(String paramString, ITransmitKvData paramITransmitKvData);
  
  public abstract void putListBool(String paramString, ArrayList<Boolean> paramArrayList);
  
  public abstract void putListInt(String paramString, ArrayList<Integer> paramArrayList);
  
  public abstract void putListLong(String paramString, ArrayList<Long> paramArrayList);
  
  public abstract void putListString(String paramString, ArrayList<String> paramArrayList);
  
  public abstract void putLong(String paramString, long paramLong);
  
  public abstract void putString(String paramString1, String paramString2);
  
  static final class CppProxy
    extends ITransmitKvData
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135735);
      if (!ITransmitKvData.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135735);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135709);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135709);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135709);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native ArrayList<String> native_allKeys(long paramLong);
    
    private native byte[] native_getBinary(long paramLong, String paramString);
    
    private native boolean native_getBool(long paramLong, String paramString);
    
    private native ArrayList<Boolean> native_getBoolList(long paramLong, String paramString);
    
    private native int native_getInt(long paramLong, String paramString);
    
    private native ArrayList<Integer> native_getIntList(long paramLong, String paramString);
    
    private native KJSEvent native_getJSEvent(long paramLong, String paramString);
    
    private native ITransmitKvData native_getKvData(long paramLong, String paramString);
    
    private native long native_getLong(long paramLong, String paramString);
    
    private native ArrayList<Long> native_getLongList(long paramLong, String paramString);
    
    private native String native_getString(long paramLong, String paramString);
    
    private native ArrayList<String> native_getStringList(long paramLong, String paramString);
    
    private native void native_putBinary(long paramLong, String paramString, byte[] paramArrayOfByte);
    
    private native void native_putBool(long paramLong, String paramString, boolean paramBoolean);
    
    private native void native_putInt(long paramLong, String paramString, int paramInt);
    
    private native void native_putJSEvent(long paramLong, String paramString, KJSEvent paramKJSEvent);
    
    private native void native_putKvData(long paramLong, String paramString, ITransmitKvData paramITransmitKvData);
    
    private native void native_putListBool(long paramLong, String paramString, ArrayList<Boolean> paramArrayList);
    
    private native void native_putListInt(long paramLong, String paramString, ArrayList<Integer> paramArrayList);
    
    private native void native_putListLong(long paramLong, String paramString, ArrayList<Long> paramArrayList);
    
    private native void native_putListString(long paramLong, String paramString, ArrayList<String> paramArrayList);
    
    private native void native_putLong(long paramLong1, String paramString, long paramLong2);
    
    private native void native_putString(long paramLong, String paramString1, String paramString2);
    
    public final ArrayList<String> allKeys()
    {
      AppMethodBeat.i(135712);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135712);
        throw ((Throwable)localObject);
      }
      Object localObject = native_allKeys(this.nativeRef);
      AppMethodBeat.o(135712);
      return localObject;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135710);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135710);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135711);
      destroy();
      super.finalize();
      AppMethodBeat.o(135711);
    }
    
    public final byte[] getBinary(String paramString)
    {
      AppMethodBeat.i(135728);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135728);
        throw paramString;
      }
      paramString = native_getBinary(this.nativeRef, paramString);
      AppMethodBeat.o(135728);
      return paramString;
    }
    
    public final boolean getBool(String paramString)
    {
      AppMethodBeat.i(135725);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135725);
        throw paramString;
      }
      boolean bool = native_getBool(this.nativeRef, paramString);
      AppMethodBeat.o(135725);
      return bool;
    }
    
    public final ArrayList<Boolean> getBoolList(String paramString)
    {
      AppMethodBeat.i(135732);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135732);
        throw paramString;
      }
      paramString = native_getBoolList(this.nativeRef, paramString);
      AppMethodBeat.o(135732);
      return paramString;
    }
    
    public final int getInt(String paramString)
    {
      AppMethodBeat.i(135724);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135724);
        throw paramString;
      }
      int i = native_getInt(this.nativeRef, paramString);
      AppMethodBeat.o(135724);
      return i;
    }
    
    public final ArrayList<Integer> getIntList(String paramString)
    {
      AppMethodBeat.i(135731);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135731);
        throw paramString;
      }
      paramString = native_getIntList(this.nativeRef, paramString);
      AppMethodBeat.o(135731);
      return paramString;
    }
    
    public final KJSEvent getJSEvent(String paramString)
    {
      AppMethodBeat.i(135729);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135729);
        throw paramString;
      }
      paramString = native_getJSEvent(this.nativeRef, paramString);
      AppMethodBeat.o(135729);
      return paramString;
    }
    
    public final ITransmitKvData getKvData(String paramString)
    {
      AppMethodBeat.i(135730);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135730);
        throw paramString;
      }
      paramString = native_getKvData(this.nativeRef, paramString);
      AppMethodBeat.o(135730);
      return paramString;
    }
    
    public final long getLong(String paramString)
    {
      AppMethodBeat.i(135726);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135726);
        throw paramString;
      }
      long l = native_getLong(this.nativeRef, paramString);
      AppMethodBeat.o(135726);
      return l;
    }
    
    public final ArrayList<Long> getLongList(String paramString)
    {
      AppMethodBeat.i(135733);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135733);
        throw paramString;
      }
      paramString = native_getLongList(this.nativeRef, paramString);
      AppMethodBeat.o(135733);
      return paramString;
    }
    
    public final String getString(String paramString)
    {
      AppMethodBeat.i(135727);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135727);
        throw paramString;
      }
      paramString = native_getString(this.nativeRef, paramString);
      AppMethodBeat.o(135727);
      return paramString;
    }
    
    public final ArrayList<String> getStringList(String paramString)
    {
      AppMethodBeat.i(135734);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135734);
        throw paramString;
      }
      paramString = native_getStringList(this.nativeRef, paramString);
      AppMethodBeat.o(135734);
      return paramString;
    }
    
    public final void putBinary(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(135717);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135717);
        throw paramString;
      }
      native_putBinary(this.nativeRef, paramString, paramArrayOfByte);
      AppMethodBeat.o(135717);
    }
    
    public final void putBool(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(135714);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135714);
        throw paramString;
      }
      native_putBool(this.nativeRef, paramString, paramBoolean);
      AppMethodBeat.o(135714);
    }
    
    public final void putInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(135713);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135713);
        throw paramString;
      }
      native_putInt(this.nativeRef, paramString, paramInt);
      AppMethodBeat.o(135713);
    }
    
    public final void putJSEvent(String paramString, KJSEvent paramKJSEvent)
    {
      AppMethodBeat.i(135718);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135718);
        throw paramString;
      }
      native_putJSEvent(this.nativeRef, paramString, paramKJSEvent);
      AppMethodBeat.o(135718);
    }
    
    public final void putKvData(String paramString, ITransmitKvData paramITransmitKvData)
    {
      AppMethodBeat.i(135719);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135719);
        throw paramString;
      }
      native_putKvData(this.nativeRef, paramString, paramITransmitKvData);
      AppMethodBeat.o(135719);
    }
    
    public final void putListBool(String paramString, ArrayList<Boolean> paramArrayList)
    {
      AppMethodBeat.i(135721);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135721);
        throw paramString;
      }
      native_putListBool(this.nativeRef, paramString, paramArrayList);
      AppMethodBeat.o(135721);
    }
    
    public final void putListInt(String paramString, ArrayList<Integer> paramArrayList)
    {
      AppMethodBeat.i(135720);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135720);
        throw paramString;
      }
      native_putListInt(this.nativeRef, paramString, paramArrayList);
      AppMethodBeat.o(135720);
    }
    
    public final void putListLong(String paramString, ArrayList<Long> paramArrayList)
    {
      AppMethodBeat.i(135722);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135722);
        throw paramString;
      }
      native_putListLong(this.nativeRef, paramString, paramArrayList);
      AppMethodBeat.o(135722);
    }
    
    public final void putListString(String paramString, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(135723);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135723);
        throw paramString;
      }
      native_putListString(this.nativeRef, paramString, paramArrayList);
      AppMethodBeat.o(135723);
    }
    
    public final void putLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(135715);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135715);
        throw paramString;
      }
      native_putLong(this.nativeRef, paramString, paramLong);
      AppMethodBeat.o(135715);
    }
    
    public final void putString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(135716);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135716);
        throw paramString1;
      }
      native_putString(this.nativeRef, paramString1, paramString2);
      AppMethodBeat.o(135716);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.ITransmitKvData
 * JD-Core Version:    0.7.0.1
 */