package com.tencent.mm.compatible.util;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private static a lYU;
  
  static
  {
    AppMethodBeat.i(240848);
    lYU = new h.1();
    AppMethodBeat.o(240848);
  }
  
  public static boolean aQf()
  {
    AppMethodBeat.i(240826);
    boolean bool = lYU.aQf();
    AppMethodBeat.o(240826);
    return bool;
  }
  
  public static boolean aQg()
  {
    AppMethodBeat.i(240834);
    boolean bool = lYU.aQg();
    AppMethodBeat.o(240834);
    return bool;
  }
  
  public static boolean aQh()
  {
    AppMethodBeat.i(240838);
    boolean bool = lYU.aQh();
    AppMethodBeat.o(240838);
    return bool;
  }
  
  public static void aQi() {}
  
  public static AssetManager getAssets()
  {
    AppMethodBeat.i(240843);
    AssetManager localAssetManager = lYU.getAssets();
    AppMethodBeat.o(240843);
    return localAssetManager;
  }
  
  public static boolean loadLibrary(String paramString)
  {
    AppMethodBeat.i(240846);
    boolean bool = lYU.tryLoadLibrary(paramString);
    AppMethodBeat.o(240846);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean aQf();
    
    public abstract boolean aQg();
    
    public abstract boolean aQh();
    
    public abstract AssetManager getAssets();
    
    public abstract boolean tryLoadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.util.h
 * JD-Core Version:    0.7.0.1
 */