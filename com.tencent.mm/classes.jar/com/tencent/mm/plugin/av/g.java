package com.tencent.mm.plugin.av;

import com.eclipsesource.mmv8.V8Object;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "canVideoAutoPlay", "", "getCanvas", "Lcom/eclipsesource/mmv8/V8Object;", "getElementId", "", "getFontSize", "", "getFps", "getHeight", "getId", "", "getOffsetHeight", "getOffsetTop", "getWidth", "isOnScreen", "restore", "canvasId", "save", "", "left", "", "top", "width", "height", "layout", "setHeight", "setVideo", "bottom", "webview-sdk_release"})
public abstract interface g
  extends b
{
  public abstract boolean canVideoAutoPlay();
  
  public abstract V8Object getCanvas();
  
  public abstract int getElementId();
  
  public abstract float getFontSize();
  
  public abstract int getFps();
  
  public abstract int getHeight();
  
  public abstract String getId();
  
  public abstract int getOffsetHeight();
  
  public abstract int getOffsetTop();
  
  public abstract int getWidth();
  
  public abstract boolean isOnScreen();
  
  public abstract String restore(String paramString);
  
  public abstract void save(String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, String paramString2);
  
  public abstract void setHeight(Number paramNumber);
  
  public abstract void setVideo(Number paramNumber1, Number paramNumber2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.g
 * JD-Core Version:    0.7.0.1
 */