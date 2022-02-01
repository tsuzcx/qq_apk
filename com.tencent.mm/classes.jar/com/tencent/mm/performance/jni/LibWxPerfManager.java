package com.tencent.mm.performance.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LibWxPerfManager
{
  public static final LibWxPerfManager INSTANCE;
  private volatile boolean isLibLoaded = false;
  
  static
  {
    AppMethodBeat.i(73328);
    INSTANCE = new LibWxPerfManager();
    AppMethodBeat.o(73328);
  }
  
  public void init()
  {
    AppMethodBeat.i(73327);
    try
    {
      if (!this.isLibLoaded)
      {
        System.loadLibrary("wxperf");
        this.isLibLoaded = true;
      }
      AppMethodBeat.o(73327);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.isLibLoaded = false;
      AppMethodBeat.o(73327);
    }
  }
  
  public boolean initOk()
  {
    return this.isLibLoaded;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.LibWxPerfManager
 * JD-Core Version:    0.7.0.1
 */