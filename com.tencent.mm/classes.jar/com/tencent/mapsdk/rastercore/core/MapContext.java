package com.tencent.mapsdk.rastercore.core;

import android.content.Context;

public class MapContext
{
  private static volatile Context context;
  
  public static Context getContext()
  {
    return context;
  }
  
  public static void setContext(Context paramContext)
  {
    context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.core.MapContext
 * JD-Core Version:    0.7.0.1
 */