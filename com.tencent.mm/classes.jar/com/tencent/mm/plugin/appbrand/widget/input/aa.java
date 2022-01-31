package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.v;

public abstract interface aa<Input extends EditText,  extends ab>
{
  public abstract void a(String paramString, Integer paramInteger);
  
  public abstract int aQA();
  
  public abstract boolean aQB();
  
  public abstract boolean aQv();
  
  public abstract Input aQw();
  
  public abstract boolean aQz();
  
  public abstract boolean dw(int paramInt1, int paramInt2);
  
  public abstract int getInputId();
  
  public abstract <P extends View,  extends ac> P getInputPanel();
  
  public abstract boolean n(v paramv);
  
  public abstract void qo(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aa
 * JD-Core Version:    0.7.0.1
 */