package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public abstract interface n$a
  extends DialogInterface, n
{
  public abstract void setCancelable(boolean paramBoolean);
  
  public abstract void setCanceledOnTouchOutside(boolean paramBoolean);
  
  public abstract void setMessage(CharSequence paramCharSequence);
  
  public abstract void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void setTitle(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n.a
 * JD-Core Version:    0.7.0.1
 */