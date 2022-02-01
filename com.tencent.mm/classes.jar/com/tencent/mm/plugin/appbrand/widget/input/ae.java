package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.ad;

public abstract interface ae<Input extends EditText,  extends af>
{
  public abstract boolean A(ad paramad);
  
  public abstract void DJ(int paramInt);
  
  public abstract void a(String paramString, Integer paramInteger);
  
  public abstract boolean cob();
  
  public abstract Input coc();
  
  public abstract boolean coj();
  
  public abstract int cok();
  
  public abstract boolean col();
  
  public abstract int getInputId();
  
  public abstract <P extends View,  extends ag> P getInputPanel();
  
  public abstract boolean r(int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ae
 * JD-Core Version:    0.7.0.1
 */