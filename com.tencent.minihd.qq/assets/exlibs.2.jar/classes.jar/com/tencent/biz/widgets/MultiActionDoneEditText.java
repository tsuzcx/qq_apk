package com.tencent.biz.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class MultiActionDoneEditText
  extends EditText
{
  public MultiActionDoneEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiActionDoneEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    int i = paramEditorInfo.imeOptions & 0xFF;
    if ((i & 0x6) != 0)
    {
      paramEditorInfo.imeOptions = (i ^ paramEditorInfo.imeOptions);
      paramEditorInfo.imeOptions |= 0x6;
    }
    if ((paramEditorInfo.imeOptions & 0x40000000) != 0) {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
    }
    return localInputConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.MultiActionDoneEditText
 * JD-Core Version:    0.7.0.1
 */