package com.facebook.jni;

import com.facebook.soloader.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HybridData
{
  private Destructor mDestructor;
  
  static
  {
    AppMethodBeat.i(208038);
    a.loadLibrary("fbjni");
    AppMethodBeat.o(208038);
  }
  
  public HybridData()
  {
    AppMethodBeat.i(208034);
    this.mDestructor = new Destructor(this);
    AppMethodBeat.o(208034);
  }
  
  public boolean isValid()
  {
    AppMethodBeat.i(208045);
    if (this.mDestructor.mNativePointer != 0L)
    {
      AppMethodBeat.o(208045);
      return true;
    }
    AppMethodBeat.o(208045);
    return false;
  }
  
  public void resetNative()
  {
    try
    {
      AppMethodBeat.i(208042);
      this.mDestructor.destruct();
      AppMethodBeat.o(208042);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static class Destructor
    extends DestructorThread.Destructor
  {
    private volatile long mNativePointer;
    
    Destructor(Object paramObject)
    {
      super();
    }
    
    static native void deleteNative(long paramLong);
    
    protected final void destruct()
    {
      AppMethodBeat.i(208039);
      deleteNative(this.mNativePointer);
      this.mNativePointer = 0L;
      AppMethodBeat.o(208039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.jni.HybridData
 * JD-Core Version:    0.7.0.1
 */