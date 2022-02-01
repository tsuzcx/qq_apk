package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import org.json.JSONArray;

public abstract interface a
  extends b, com.tencent.mm.plugin.appbrand.collector.d
{
  public abstract void S(Runnable paramRunnable);
  
  public abstract void a(DrawCanvasArg paramDrawCanvasArg, a.a parama);
  
  public abstract void a(JSONArray paramJSONArray, a.a parama);
  
  public abstract void aZL();
  
  public abstract void aZM();
  
  public abstract void b(DrawCanvasArg paramDrawCanvasArg, a.a parama);
  
  public abstract void b(JSONArray paramJSONArray, a.a parama);
  
  public abstract com.tencent.mm.plugin.appbrand.canvas.d getDrawContext();
  
  public abstract String getTraceId();
  
  public abstract boolean h(Canvas paramCanvas);
  
  public abstract void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama);
  
  public abstract void setTraceId(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.a
 * JD-Core Version:    0.7.0.1
 */