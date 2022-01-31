package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.gen.KCountPickerView;
import com.tencent.kinda.gen.KCountPickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;

public class KindaCountPickerViewImpl
  extends MMKView
  implements KCountPickerView
{
  private Context mContext;
  private KCountPickerViewOnSelectCallback mCountPickerCallback;
  private EditText mEditText;
  private int mSelectCreCountIndex;
  private String[] mTimesArray;
  
  public View createView(Context paramContext)
  {
    AppMethodBeat.i(144760);
    this.mContext = paramContext;
    this.mTimesArray = new String[100];
    int i = 0;
    while (i < this.mTimesArray.length)
    {
      this.mTimesArray[i] = this.mContext.getString(2131305028, new Object[] { String.valueOf(i) });
      i += 1;
    }
    this.mSelectCreCountIndex = 0;
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setHint(2131304912);
    paramContext = this.mEditText;
    AppMethodBeat.o(144760);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144762);
    if (this.mEditText == null)
    {
      AppMethodBeat.o(144762);
      return false;
    }
    boolean bool = this.mEditText.hasFocus();
    AppMethodBeat.o(144762);
    return bool;
  }
  
  public String getValue()
  {
    AppMethodBeat.i(144764);
    String str = this.mEditText.getText().toString();
    AppMethodBeat.o(144764);
    return str;
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144761);
    if (paramBoolean)
    {
      b localb = new b(this.mContext, this.mTimesArray);
      localb.AIW = new KindaCountPickerViewImpl.1(this, localb);
      localb.Rw(this.mSelectCreCountIndex);
      localb.show();
    }
    AppMethodBeat.o(144761);
  }
  
  public void setOnSelectCallback(KCountPickerViewOnSelectCallback paramKCountPickerViewOnSelectCallback)
  {
    this.mCountPickerCallback = paramKCountPickerViewOnSelectCallback;
  }
  
  public void setValue(String paramString)
  {
    AppMethodBeat.i(144763);
    if (this.mEditText != null) {
      this.mEditText.setText(paramString);
    }
    AppMethodBeat.o(144763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCountPickerViewImpl
 * JD-Core Version:    0.7.0.1
 */