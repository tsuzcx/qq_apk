package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import org.json.JSONArray;

public abstract interface a
  extends b, com.tencent.mm.plugin.appbrand.collector.d
{
  public abstract void a(DrawCanvasArg paramDrawCanvasArg, a parama);
  
  public abstract void a(JSONArray paramJSONArray, a parama);
  
  public abstract void adB();
  
  public abstract void adC();
  
  public abstract void b(DrawCanvasArg paramDrawCanvasArg, a parama);
  
  public abstract void b(JSONArray paramJSONArray, a parama);
  
  public abstract boolean f(Canvas paramCanvas);
  
  public abstract com.tencent.mm.plugin.appbrand.canvas.d getDrawContext();
  
  public abstract String getTraceId();
  
  public abstract void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama);
  
  public abstract void setTraceId(String paramString);
  
  public abstract void t(Runnable paramRunnable);
  
  public static abstract interface a
  {
    public abstract void a(DrawCanvasArg paramDrawCanvasArg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.a
 * JD-Core Version:    0.7.0.1
 */