package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.sdk.platformtools.ah;

public final class y
{
  final ah hcZ;
  public b hvF;
  final Runnable hvG = new y.1(this);
  private final EditText ln;
  
  public y(EditText paramEditText)
  {
    this.ln = paramEditText;
    this.hcZ = new ah(Looper.getMainLooper());
  }
  
  public final Editable c(Editable paramEditable)
  {
    paramEditable.setSpan(new y.2(this), 0, paramEditable.length(), 18);
    paramEditable.setSpan(new y.3(this), 0, paramEditable.length(), 18);
    return paramEditable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y
 * JD-Core Version:    0.7.0.1
 */