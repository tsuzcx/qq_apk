package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;

public abstract interface ab
{
  public abstract void B(z paramz);
  
  public abstract void C(z paramz);
  
  public abstract void M(float paramFloat1, float paramFloat2);
  
  public abstract void a(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void a(a parama);
  
  public abstract void a(c paramc);
  
  public abstract void addTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract void b(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void bFA();
  
  public abstract void bFB();
  
  public abstract void bFC();
  
  public abstract boolean bFi();
  
  public abstract boolean bFj();
  
  public abstract boolean bFm();
  
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
  
  public abstract int wC(int paramInt);
  
  public static abstract interface a
  {
    public abstract void iv();
  }
  
  public static abstract interface b
  {
    public abstract boolean ws(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void bFl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ab
 * JD-Core Version:    0.7.0.1
 */