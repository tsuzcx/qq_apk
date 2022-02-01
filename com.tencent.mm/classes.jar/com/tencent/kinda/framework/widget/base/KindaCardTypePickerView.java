package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;
import com.tencent.kinda.gen.KCardTypePickerView;
import com.tencent.kinda.gen.KCardTypePickerViewOnSelectCallback;
import com.tencent.kinda.gen.Option;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.util.ArrayList;
import java.util.Iterator;

public class KindaCardTypePickerView
  extends MMKView<EditText>
  implements KCardTypePickerView
{
  String TAG = "KindaCardTypePickerView";
  private KCardTypePickerViewOnSelectCallback mCallBack;
  private Context mContext;
  private EditText mEditText;
  private c mOptionPiker;
  private ArrayList<Option> mOptions;
  private int selected = -1;
  
  public EditText createView(Context paramContext)
  {
    AppMethodBeat.i(18888);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setTextSize(16.0F);
    this.mEditText.setPadding(0, 0, 0, 0);
    this.mContext = paramContext;
    this.mEditText.setHintTextColor(paramContext.getResources().getColor(2131099732));
    this.mEditText.setTextColor(paramContext.getResources().getColor(2131099732));
    paramContext = this.mEditText;
    AppMethodBeat.o(18888);
    return paramContext;
  }
  
  public boolean getEnabled()
  {
    AppMethodBeat.i(18894);
    boolean bool = this.mEditText.isEnabled();
    AppMethodBeat.o(18894);
    return bool;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18892);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(18892);
    return bool;
  }
  
  public void select(int paramInt)
  {
    AppMethodBeat.i(18890);
    this.selected = paramInt;
    this.mEditText.setText(((Option)this.mOptions.get(paramInt)).mContent);
    AppMethodBeat.o(18890);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(18893);
    this.mEditText.setEnabled(paramBoolean);
    AppMethodBeat.o(18893);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18891);
    if (paramBoolean)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mOptions.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Option)localIterator.next()).mContent);
      }
      this.mOptionPiker = new c(this.mContext, localArrayList);
      this.mOptionPiker.Jjt = new c.a()
      {
        public void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(18887);
          KindaCardTypePickerView.this.mOptionPiker.hide();
          if (paramAnonymousBoolean)
          {
            paramAnonymousObject1 = (String)paramAnonymousObject1;
            KindaCardTypePickerView.this.mEditText.setText(paramAnonymousObject1);
            KindaCardTypePickerView.access$202(KindaCardTypePickerView.this, KindaCardTypePickerView.this.mOptionPiker.fvY());
            KindaCardTypePickerView.this.mCallBack.onSelect(KindaCardTypePickerView.this.mOptionPiker.fvY());
          }
          AppMethodBeat.o(18887);
        }
      };
      if (this.selected != -1) {
        this.mOptionPiker.adc(this.selected);
      }
      this.mOptionPiker.show();
    }
    AppMethodBeat.o(18891);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(170115);
    if (this.mEditText != null) {
      this.mEditText.setHint(paramString);
    }
    AppMethodBeat.o(170115);
  }
  
  public void setOnSelectCallback(KCardTypePickerViewOnSelectCallback paramKCardTypePickerViewOnSelectCallback)
  {
    this.mCallBack = paramKCardTypePickerViewOnSelectCallback;
  }
  
  public void setOptions(ArrayList<Option> paramArrayList)
  {
    AppMethodBeat.i(18889);
    this.mEditText.setText("");
    this.mOptions = paramArrayList;
    AppMethodBeat.o(18889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCardTypePickerView
 * JD-Core Version:    0.7.0.1
 */