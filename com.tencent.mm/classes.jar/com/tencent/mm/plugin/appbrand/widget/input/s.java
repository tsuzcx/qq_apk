package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

public final class s
  extends r
  implements a
{
  private InputConnection jmC;
  
  public s(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(123727);
    super.setKeyListener(new s.1(this));
    AppMethodBeat.o(123727);
  }
  
  public final void aQZ()
  {
    AppMethodBeat.i(123734);
    if (!t.aw(this))
    {
      AppMethodBeat.o(123734);
      return;
    }
    v localv = getInputPanel();
    if (localv != null) {
      localv.setInputEditText(this);
    }
    AppMethodBeat.o(123734);
  }
  
  public final InputConnection aRc()
  {
    AppMethodBeat.i(123731);
    InputConnection localInputConnection = super.onCreateInputConnection(new EditorInfo());
    this.jmC = localInputConnection;
    AppMethodBeat.o(123731);
    return localInputConnection;
  }
  
  public final void clearFocus()
  {
    AppMethodBeat.i(123728);
    aRw();
    AppMethodBeat.o(123728);
  }
  
  public final v getInputPanel()
  {
    AppMethodBeat.i(155508);
    v localv = v.cO(this);
    AppMethodBeat.o(155508);
    return localv;
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return null;
  }
  
  public final boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(123729);
    boolean bool = a(paramInt, paramRect);
    AppMethodBeat.o(123729);
    return bool;
  }
  
  public final void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    AppMethodBeat.i(123730);
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
    AppMethodBeat.o(123730);
  }
  
  public final void setPasswordMode(boolean paramBoolean)
  {
    AppMethodBeat.i(123732);
    aRu();
    int i = getInputType() | 0x2;
    if (paramBoolean) {
      i |= 0x10;
    }
    for (;;)
    {
      setInputType(i);
      super.setPasswordMode(paramBoolean);
      aRv();
      AppMethodBeat.o(123732);
      return;
      i &= 0xFFFFFFEF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.s
 * JD-Core Version:    0.7.0.1
 */