package com.tencent.mm.plugin.appbrand.jsruntime;

import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.mm.appbrand.v8.m.b;
import java.net.URL;
import java.util.ArrayList;

public abstract interface v
  extends j
{
  public static final int[] lGl = { 4, 0, 2, 1, 3 };
  
  public abstract long Nz();
  
  public abstract void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, m.b paramb);
  
  public abstract void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, m.b paramb);
  
  public abstract long getIsolatePtr();
  
  public abstract long getUVLoopPtr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.v
 * JD-Core Version:    0.7.0.1
 */