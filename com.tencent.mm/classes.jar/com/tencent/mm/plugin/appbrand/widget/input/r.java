package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

public final class r
  extends q
  implements a
{
  private InputConnection huw;
  
  public r(Context paramContext)
  {
    super(paramContext);
    super.setKeyListener(new r.1(this));
  }
  
  public final void arV()
  {
    ((u)getInputPanel()).setInputEditText(this);
  }
  
  public final InputConnection arY()
  {
    InputConnection localInputConnection = super.onCreateInputConnection(new EditorInfo());
    this.huw = localInputConnection;
    return localInputConnection;
  }
  
  public final void clearFocus()
  {
    asq();
  }
  
  public final View getInputPanel()
  {
    return u.cl(this);
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return null;
  }
  
  public final boolean requestFocus(int paramInt, Rect paramRect)
  {
    return a(paramInt, paramRect);
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (paramArrayOfInputFilter == null) {
      arrayOfInputFilter = new InputFilter[0];
    }
    paramArrayOfInputFilter = new InputFilter[arrayOfInputFilter.length + 1];
    while (i < arrayOfInputFilter.length)
    {
      paramArrayOfInputFilter[i] = arrayOfInputFilter[i];
      i += 1;
    }
    paramArrayOfInputFilter[i] = new InputFilter.AllCaps();
    super.setFilters(paramArrayOfInputFilter);
  }
  
  public final void setPasswordMode(boolean paramBoolean)
  {
    aso();
    int i = getInputType() | 0x2;
    if (paramBoolean) {
      i |= 0x10;
    }
    for (;;)
    {
      setInputType(i);
      super.setPasswordMode(paramBoolean);
      asp();
      return;
      i &= 0xFFFFFFEF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.r
 * JD-Core Version:    0.7.0.1
 */