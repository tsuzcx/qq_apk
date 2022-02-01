package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.button.MaterialButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaterialComponentsViewInflater
  extends AppCompatViewInflater
{
  public AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(209935);
    paramContext = new MaterialButton(paramContext, paramAttributeSet);
    AppMethodBeat.o(209935);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.theme.MaterialComponentsViewInflater
 * JD-Core Version:    0.7.0.1
 */