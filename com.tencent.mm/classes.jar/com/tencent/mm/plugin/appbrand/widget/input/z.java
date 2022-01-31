package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.sdk.platformtools.ak;

public final class z
  implements View.OnFocusChangeListener
{
  final ak iMP;
  boolean jnR;
  public b jnS;
  final Runnable jnT;
  
  public z(EditText paramEditText)
  {
    AppMethodBeat.i(123833);
    this.jnR = false;
    this.jnT = new z.1(this);
    this.jnR = paramEditText.isFocused();
    paramEditText.setOnFocusChangeListener(this);
    this.iMP = new ak(Looper.getMainLooper());
    AppMethodBeat.o(123833);
  }
  
  public final Editable c(Editable paramEditable)
  {
    AppMethodBeat.i(123834);
    paramEditable.setSpan(new z.2(this), 0, paramEditable.length(), 18);
    paramEditable.setSpan(new z.3(this), 0, paramEditable.length(), 18);
    AppMethodBeat.o(123834);
    return paramEditable;
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(141619);
    this.jnR = paramBoolean;
    if (!paramBoolean) {
      this.iMP.removeCallbacks(this.jnT);
    }
    AppMethodBeat.o(141619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.z
 * JD-Core Version:    0.7.0.1
 */