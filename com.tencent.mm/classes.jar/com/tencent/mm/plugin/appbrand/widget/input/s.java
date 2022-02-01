package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

public final class s
  extends r
  implements a
{
  private InputConnection mEq;
  
  public s(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(136461);
    super.setKeyListener(new NumberKeyListener()
    {
      protected final char[] getAcceptedChars()
      {
        return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 46, 88, 120 };
      }
      
      public final int getInputType()
      {
        if (s.this.mFi) {}
        for (int i = 16;; i = 0) {
          return i | 0x2;
        }
      }
    });
    AppMethodBeat.o(136461);
  }
  
  public final void bAq()
  {
    AppMethodBeat.i(136468);
    if (!t.aC(this))
    {
      AppMethodBeat.o(136468);
      return;
    }
    v localv = getInputPanel();
    if (localv != null) {
      localv.setInputEditText(this);
    }
    AppMethodBeat.o(136468);
  }
  
  public final InputConnection bAt()
  {
    AppMethodBeat.i(136465);
    InputConnection localInputConnection = super.onCreateInputConnection(new EditorInfo());
    this.mEq = localInputConnection;
    AppMethodBeat.o(136465);
    return localInputConnection;
  }
  
  public final void clearFocus()
  {
    AppMethodBeat.i(136462);
    bAM();
    AppMethodBeat.o(136462);
  }
  
  public final v getInputPanel()
  {
    AppMethodBeat.i(136467);
    v localv = v.dg(this);
    AppMethodBeat.o(136467);
    return localv;
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return null;
  }
  
  public final boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(136463);
    boolean bool = a(paramInt, paramRect);
    AppMethodBeat.o(136463);
    return bool;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    AppMethodBeat.i(136464);
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
    AppMethodBeat.o(136464);
  }
  
  public final void setPasswordMode(boolean paramBoolean)
  {
    AppMethodBeat.i(136466);
    bAK();
    int i = getInputType() | 0x2;
    if (paramBoolean) {
      i |= 0x10;
    }
    for (;;)
    {
      setInputType(i);
      super.setPasswordMode(paramBoolean);
      bAL();
      AppMethodBeat.o(136466);
      return;
      i &= 0xFFFFFFEF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.s
 * JD-Core Version:    0.7.0.1
 */