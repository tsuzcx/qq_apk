package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;

public abstract interface ab
{
  public abstract int Ak(int paramInt);
  
  public abstract void G(ac paramac);
  
  public abstract void H(ac paramac);
  
  public abstract void Q(float paramFloat1, float paramFloat2);
  
  public abstract void a(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void a(a parama);
  
  public abstract void a(c paramc);
  
  public abstract void addTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract void b(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract boolean cbB();
  
  public abstract void cbQ();
  
  public abstract void cbR();
  
  public abstract void cbS();
  
  public abstract boolean cbx();
  
  public abstract boolean cby();
  
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
    public abstract void iE();
  }
  
  public static abstract interface b
  {
    public abstract boolean Aa(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void cbA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ab
 * JD-Core Version:    0.7.0.1
 */