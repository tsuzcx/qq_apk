package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;

public abstract interface af
{
  public abstract int Eu(int paramInt);
  
  public abstract void H(ad paramad);
  
  public abstract void I(ad paramad);
  
  public abstract void a(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void a(a parama);
  
  public abstract void a(c paramc);
  
  public abstract void addTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract void ay(float paramFloat1, float paramFloat2);
  
  public abstract void b(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void cRE();
  
  public abstract void cRF();
  
  public abstract void cRG();
  
  public abstract boolean cRj();
  
  public abstract boolean cRk();
  
  public abstract boolean cRn();
  
  public abstract void destroy();
  
  public abstract b getAutoFillController();
  
  public abstract Context getContext();
  
  public abstract int getInputId();
  
  public abstract View getInputPanel();
  
  public abstract char getLastKeyPressed();
  
  public abstract CharSequence getText();
  
  public abstract View getView();
  
  public abstract void setFixed(boolean paramBoolean);
  
  public abstract void setInputId(int paramInt);
  
  public abstract void setOnKeyUpPostImeListener(b paramb);
  
  public static abstract interface a
  {
    public abstract void dG();
  }
  
  public static abstract interface b
  {
    public abstract boolean Ek(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void cRm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.af
 * JD-Core Version:    0.7.0.1
 */