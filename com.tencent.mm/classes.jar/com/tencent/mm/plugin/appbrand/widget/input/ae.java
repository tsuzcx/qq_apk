package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.ad;

public abstract interface ae<Input extends EditText,  extends af>
{
  public abstract boolean B(ad paramad);
  
  public abstract void Ej(int paramInt);
  
  public abstract void a(String paramString, Integer paramInteger);
  
  public abstract boolean cQD();
  
  public abstract Input cQE();
  
  public abstract boolean cQL();
  
  public abstract int cQM();
  
  public abstract boolean cQN();
  
  public abstract int getInputId();
  
  public abstract <P extends View,  extends ag> P getInputPanel();
  
  public abstract boolean r(int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ae
 * JD-Core Version:    0.7.0.1
 */