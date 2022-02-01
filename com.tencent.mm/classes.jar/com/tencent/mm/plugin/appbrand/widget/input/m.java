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
    paramCharSequence = new a(paramCharSequence);
    AppMethodBeat.o(131503);
    return paramCharSequence;
  }
  
  static final class a
    implements CharSequence
  {
    private CharSequence mbN;
    
    a(CharSequence paramCharSequence)
    {
      this.mbN = paramCharSequence;
    }
    
    public final char charAt(int paramInt)
    {
      return '●';
    }
    
    public final int length()
    {
      AppMethodBeat.i(131501);
      int i = this.mbN.length();
      AppMethodBeat.o(131501);
      return i;
    }
    
    public final CharSequence subSequence(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(131502);
      CharSequence localCharSequence = this.mbN.subSequence(paramInt1, paramInt2);
      AppMethodBeat.o(131502);
      return localCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.m
 * JD-Core Version:    0.7.0.1
 */