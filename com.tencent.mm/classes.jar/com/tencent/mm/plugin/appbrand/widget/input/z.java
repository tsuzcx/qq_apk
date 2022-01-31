package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.q;

public abstract interface z<Input extends EditText,  extends aa>
{
  public abstract boolean adjustPositionOnFocused();
  
  public abstract <P extends View,  extends ab> P getInputPanel();
  
  public abstract int getInputPanelMarginBottom();
  
  public abstract Input getWidget();
  
  public abstract boolean hideKeyboard();
  
  public abstract boolean isAttachedTo(q paramq);
  
  public abstract void lt(int paramInt);
  
  public abstract boolean removeSelf();
  
  public abstract boolean showKeyboard(int paramInt1, int paramInt2);
  
  public abstract void updateValue(String paramString, Integer paramInteger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.z
 * JD-Core Version:    0.7.0.1
 */