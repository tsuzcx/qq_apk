package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;

public abstract interface ab
{
  public abstract void R(float paramFloat1, float paramFloat2);
  
  public abstract void a(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void a(ab.a parama);
  
  public abstract void a(ab.c paramc);
  
  public abstract boolean aQX();
  
  public abstract boolean aQY();
  
  public abstract boolean aRb();
  
  public abstract void aRq();
  
  public abstract void aRr();
  
  public abstract void aRs();
  
  public abstract void addTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract void b(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void destroy();
  
  public abstract b getAutoFillController();
  
  public abstract Context getContext();
  
  public abstract int getInputId();
  
  public abstract View getInputPanel();
  
  public abstract char getLastKeyPressed();
  
  public abstract CharSequence getText();
  
  public abstract View getView();
  
  public abstract int qz(int paramInt);
  
  public abstract void setFixed(boolean paramBoolean);
  
  public abstract void setInputId(int paramInt);
  
  public abstract void setOnKeyUpPostImeListener(ab.b paramb);
  
  public abstract void t(v paramv);
  
  public abstract void u(v paramv);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ab
 * JD-Core Version:    0.7.0.1
 */