package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spannable.Factory;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.plugin.appbrand.y.c;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText
  extends EditText
{
  private int gdA = 2147483647;
  private final Spannable.Factory gdB = new WAGamePanelInputEditText.3(this);
  private final y gdy = new y(this);
  private final InputFilter gdz = new WAGamePanelInputEditText.2(this);
  
  public WAGamePanelInputEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, y.c.editTextStyle);
  }
  
  public WAGamePanelInputEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setEditableFactory(new WAGamePanelInputEditText.1(this));
  }
  
  public int getMaxLength()
  {
    return this.gdA;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    paramEditorInfo.imeOptions |= 0x10000000;
    return localInputConnection;
  }
  
  public void setComposingDismissedListener(b paramb)
  {
    this.gdy.hvF = paramb;
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (this.gdz != null)
    {
      arrayOfInputFilter = paramArrayOfInputFilter;
      if (paramArrayOfInputFilter == null) {
        arrayOfInputFilter = new InputFilter[0];
      }
      paramArrayOfInputFilter = new InputFilter[arrayOfInputFilter.length + 1];
      while (i < arrayOfInputFilter.length)
      {
        paramArrayOfInputFilter[i] = arrayOfInputFilter[i];
        i += 1;
      }
      paramArrayOfInputFilter[i] = this.gdz;
      arrayOfInputFilter = paramArrayOfInputFilter;
    }
    super.setFilters(arrayOfInputFilter);
  }
  
  public void setMaxLength(int paramInt)
  {
    this.gdA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText
 * JD-Core Version:    0.7.0.1
 */