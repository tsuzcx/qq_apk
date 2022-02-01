package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends PasswordTransformationMethod
{
  public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    AppMethodBeat.i(131503);
    paramCharSequence = new m.a(paramCharSequence);
    AppMethodBeat.o(131503);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.m
 * JD-Core Version:    0.7.0.1
 */