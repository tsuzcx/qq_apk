package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.button.MaterialButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class MaterialComponentsViewInflater
  extends AppCompatViewInflater
{
  public AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(240633);
    paramContext = new MaterialButton(paramContext, paramAttributeSet);
    AppMethodBeat.o(240633);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.theme.MaterialComponentsViewInflater
 * JD-Core Version:    0.7.0.1
 */