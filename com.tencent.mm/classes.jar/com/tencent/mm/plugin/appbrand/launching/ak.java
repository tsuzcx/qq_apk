package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;

public abstract interface ak
{
  public abstract long bNF();
  
  public abstract long bNG();
  
  public abstract long bNH();
  
  public abstract Pair<WxaAttributes, Boolean> bNI();
  
  public abstract String name();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ak
 * JD-Core Version:    0.7.0.1
 */