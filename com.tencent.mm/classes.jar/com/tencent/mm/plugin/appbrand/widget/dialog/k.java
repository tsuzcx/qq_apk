package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.view.View;

public abstract interface k
  extends DialogInterface
{
  public abstract void a(m paramm);
  
  public abstract boolean bjb();
  
  public abstract boolean bjc();
  
  public abstract View getContentView();
  
  public abstract int getPosition();
  
  public abstract boolean isCancelable();
  
  public abstract void onCancel();
  
  public abstract void ut(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.k
 * JD-Core Version:    0.7.0.1
 */