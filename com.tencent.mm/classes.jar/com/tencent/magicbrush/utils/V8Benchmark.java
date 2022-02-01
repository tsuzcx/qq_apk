package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Benchmark
{
  static
  {
    AppMethodBeat.i(140075);
    System.loadLibrary("mmv8");
    System.loadLibrary("magicbrush");
    AppMethodBeat.o(140075);
  }
  
  public static native String execute(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.utils.V8Benchmark
 * JD-Core Version:    0.7.0.1
 */