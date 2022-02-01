package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.z;

public abstract interface aa<Input extends EditText,  extends ab>
{
  public abstract void a(String paramString, Integer paramInteger);
  
  public abstract boolean bEG();
  
  public abstract Input bEH();
  
  public abstract boolean bEK();
  
  public abstract int bEL();
  
  public abstract boolean bEM();
  
  public abstract boolean ew(int paramInt1, int paramInt2);
  
  public abstract int getInputId();
  
  public abstract <P extends View,  extends ac> P getInputPanel();
  
  public abstract boolean v(z paramz);
  
  public abstract void wr(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aa
 * JD-Core Version:    0.7.0.1
 */