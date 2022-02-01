package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;

public abstract interface aa<Input extends EditText,  extends ab>
{
  public abstract void a(String paramString, Integer paramInteger);
  
  public abstract boolean bDO();
  
  public abstract Input bDP();
  
  public abstract boolean bDS();
  
  public abstract int bDT();
  
  public abstract boolean bDU();
  
  public abstract boolean ew(int paramInt1, int paramInt2);
  
  public abstract int getInputId();
  
  public abstract <P extends View,  extends ac> P getInputPanel();
  
  public abstract boolean u(com.tencent.mm.plugin.appbrand.page.aa paramaa);
  
  public abstract void wm(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aa
 * JD-Core Version:    0.7.0.1
 */