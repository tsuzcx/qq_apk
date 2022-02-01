package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.gen.KCountPickerView;
import com.tencent.kinda.gen.KCountPickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;

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
    AppMethodBeat.i(18897);
    this.mContext = paramContext;
    this.mTimesArray = new String[100];
    int i = 0;
    while (i < this.mTimesArray.length)
    {
      this.mTimesArray[i] = this.mContext.getString(2131765220, new Object[] { String.valueOf(i) });
      i += 1;
    }
    this.mSelectCreCountIndex = 0;
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setHint(2131765099);
    this.mEditText.setPadding(0, 0, 0, 0);
    this.mEditText.setTextSize(16.0F);
    paramContext = this.mEditText;
    AppMethodBeat.o(18897);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18900);
    if (this.mEditText == null)
    {
      AppMethodBeat.o(18900);
      return false;
    }
    boolean bool = this.mEditText.hasFocus();
    AppMethodBeat.o(18900);
    return bool;
  }
  
  public String getValue()
  {
    AppMethodBeat.i(18901);
    String str = this.mSelectCreCountIndex;
    AppMethodBeat.o(18901);
    return str;
  }
  
  public void setDefaultCount(int paramInt)
  {
    AppMethodBeat.i(18898);
    this.mSelectCreCountIndex = paramInt;
    String str = this.mContext.getString(2131765220, new Object[] { String.valueOf(paramInt) });
    this.mEditText.setText(str);
    AppMethodBeat.o(18898);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18899);
    if (paramBoolean)
    {
      final c localc = new c(this.mContext, this.mTimesArray);
      localc.LaQ = new c.a()
      {
        public void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(18896);
          if (paramAnonymousBoolean)
          {
            KindaCountPickerViewImpl.access$002(KindaCountPickerViewImpl.this, localc.fMM());
            KindaCountPickerViewImpl.this.mEditText.setText(paramAnonymousObject1.toString());
            KindaCountPickerViewImpl.this.mCountPickerCallback.onSelect(String.valueOf(KindaCountPickerViewImpl.this.mSelectCreCountIndex));
          }
          localc.hide();
          AppMethodBeat.o(18896);
        }
      };
      localc.afD(this.mSelectCreCountIndex);
      localc.show();
    }
    AppMethodBeat.o(18899);
  }
  
  public void setOnSelectCallback(KCountPickerViewOnSelectCallback paramKCountPickerViewOnSelectCallback)
  {
    this.mCountPickerCallback = paramKCountPickerViewOnSelectCallback;
  }
  
  public void setValue(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCountPickerViewImpl
 * JD-Core Version:    0.7.0.1
 */