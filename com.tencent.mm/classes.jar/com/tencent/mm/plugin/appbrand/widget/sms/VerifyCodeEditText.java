package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

public class VerifyCodeEditText
  extends AppCompatEditText
  implements a
{
  public VerifyCodeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VerifyCodeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final InputConnection bFn()
  {
    AppMethodBeat.i(169541);
    InputConnection localInputConnection = super.onCreateInputConnection(new EditorInfo());
    AppMethodBeat.o(169541);
    return localInputConnection;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.VerifyCodeEditText
 * JD-Core Version:    0.7.0.1
 */