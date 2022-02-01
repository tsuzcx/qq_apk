package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;

public abstract interface k
  extends DialogInterface
{
  public abstract void a(m paramm);
  
  public abstract boolean aLl();
  
  public abstract boolean aLm();
  
  public abstract View getContentView();
  
  public abstract int getPosition();
  
  public abstract boolean isCancelable();
  
  public abstract void onCancel();
  
  public abstract void pW(int paramInt);
  
  public static abstract interface a
    extends DialogInterface, k
  {
    public abstract void setCancelable(boolean paramBoolean);
    
    public abstract void setCanceledOnTouchOutside(boolean paramBoolean);
    
    public abstract void setMessage(CharSequence paramCharSequence);
    
    public abstract void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void setTitle(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.k
 * JD-Core Version:    0.7.0.1
 */