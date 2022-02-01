package com.google.android.material.textfield;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextInputEditText
  extends AppCompatEditText
{
  public TextInputEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.editTextStyle);
  }
  
  public TextInputEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private CharSequence getHintFromLayout()
  {
    AppMethodBeat.i(209677);
    Object localObject = getTextInputLayout();
    if (localObject != null)
    {
      localObject = ((TextInputLayout)localObject).getHint();
      AppMethodBeat.o(209677);
      return localObject;
    }
    AppMethodBeat.o(209677);
    return null;
  }
  
  private TextInputLayout getTextInputLayout()
  {
    AppMethodBeat.i(209672);
    for (Object localObject = getParent(); (localObject instanceof View); localObject = ((ViewParent)localObject).getParent()) {
      if ((localObject instanceof TextInputLayout))
      {
        localObject = (TextInputLayout)localObject;
        AppMethodBeat.o(209672);
        return localObject;
      }
    }
    AppMethodBeat.o(209672);
    return null;
  }
  
  public CharSequence getHint()
  {
    AppMethodBeat.i(209684);
    Object localObject = getTextInputLayout();
    if ((localObject != null) && (((TextInputLayout)localObject).dzD))
    {
      localObject = ((TextInputLayout)localObject).getHint();
      AppMethodBeat.o(209684);
      return localObject;
    }
    localObject = super.getHint();
    AppMethodBeat.o(209684);
    return localObject;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(209694);
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((localInputConnection != null) && (paramEditorInfo.hintText == null)) {
      paramEditorInfo.hintText = getHintFromLayout();
    }
    AppMethodBeat.o(209694);
    return localInputConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.textfield.TextInputEditText
 * JD-Core Version:    0.7.0.1
 */