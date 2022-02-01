package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;

public abstract interface ab
{
  public abstract void A(aa paramaa);
  
  public abstract void B(aa paramaa);
  
  public abstract void M(float paramFloat1, float paramFloat2);
  
  public abstract void a(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void a(a parama);
  
  public abstract void a(c paramc);
  
  public abstract void addTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract void b(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void bEI();
  
  public abstract void bEJ();
  
  public abstract void bEK();
  
  public abstract boolean bEq();
  
  public abstract boolean bEr();
  
  public abstract boolean bEu();
  
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
  
  public abstract int wx(int paramInt);
  
  public static abstract interface a
  {
    public abstract void iv();
  }
  
  public static abstract interface b
  {
    public abstract boolean wn(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void bEt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ab
 * JD-Core Version:    0.7.0.1
 */