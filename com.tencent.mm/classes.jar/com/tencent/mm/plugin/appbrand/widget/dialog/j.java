package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;

public abstract interface j
  extends DialogInterface
{
  public abstract void a(l paraml);
  
  public abstract boolean bsB();
  
  public abstract boolean bsC();
  
  public abstract View getContentView();
  
  public abstract int getPosition();
  
  public abstract boolean isCancelable();
  
  public abstract void onCancel();
  
  public abstract void xu(int paramInt);
  
  public static abstract interface a
    extends DialogInterface, j
  {
    public abstract void setCancelable(boolean paramBoolean);
    
    public abstract void setCanceledOnTouchOutside(boolean paramBoolean);
    
    public abstract void setMessage(CharSequence paramCharSequence);
    
    public abstract void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void setTitle(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.j
 * JD-Core Version:    0.7.0.1
 */