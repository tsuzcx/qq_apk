package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.view.View;

public abstract interface k
  extends DialogInterface
{
  public abstract void a(m paramm);
  
  public abstract boolean aEu();
  
  public abstract boolean aEv();
  
  public abstract View getContentView();
  
  public abstract int getPosition();
  
  public abstract boolean isCancelable();
  
  public abstract void onCancel();
  
  public abstract void pi(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.k
 * JD-Core Version:    0.7.0.1
 */