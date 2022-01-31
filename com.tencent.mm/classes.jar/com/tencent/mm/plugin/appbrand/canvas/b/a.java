package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import org.json.JSONArray;

public abstract interface a
{
  public abstract boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg);
  
  public abstract boolean a(Path paramPath, JSONArray paramJSONArray);
  
  public abstract BasePathActionArg adQ();
  
  public abstract String getMethod();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.a
 * JD-Core Version:    0.7.0.1
 */