package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;

public abstract interface aa
{
  public abstract void A(q paramq);
  
  public abstract void K(float paramFloat1, float paramFloat2);
  
  public abstract void a(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void a(a parama);
  
  public abstract void a(aa.c paramc);
  
  public abstract void addTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract boolean arT();
  
  public abstract boolean arU();
  
  public abstract boolean arX();
  
  public abstract void asl();
  
  public abstract void asm();
  
  public abstract void asn();
  
  public abstract void b(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void destroy();
  
  public abstract b getAutoFillController();
  
  public abstract Context getContext();
  
  public abstract int getInputId();
  
  public abstract View getInputPanel();
  
  public abstract char getLastKeyPressed();
  
  public abstract CharSequence getText();
  
  public abstract View getView();
  
  public abstract int mV(int paramInt);
  
  public abstract void setFixed(boolean paramBoolean);
  
  public abstract void setInputId(int paramInt);
  
  public abstract void setOnKeyUpPostImeListener(aa.b paramb);
  
  public abstract void z(q paramq);
  
  public static abstract interface a
  {
    public abstract void asr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aa
 * JD-Core Version:    0.7.0.1
 */