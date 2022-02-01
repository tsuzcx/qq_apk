package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KCardTypePickerView;
import com.tencent.kinda.gen.KCardTypePickerViewOnSelectCallback;
import com.tencent.kinda.gen.Option;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;
import java.util.Iterator;

public class KindaCardTypePickerView
  extends MMKView<View>
  implements KCardTypePickerView
{
  String TAG = "KindaCardTypePickerView";
  private KCardTypePickerViewOnSelectCallback mCallBack;
  private Context mContext;
  private EditText mEditText;
  private b mOptionPiker;
  private ArrayList<Option> mOptions;
  private int selected = -1;
  
  public View createView(Context paramContext)
  {
    AppMethodBeat.i(18895);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(paramContext, 17.0F));
    this.mEditText.setPadding(0, 0, 0, 0);
    this.mContext = paramContext;
    this.mEditText.setHintTextColor(paramContext.getResources().getColor(R.color.FG_0));
    this.mEditText.setTextColor(paramContext.getResources().getColor(R.color.FG_0));
    paramContext = new LayoutWrapper(paramContext, this.mEditText);
    AppMethodBeat.o(18895);
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
      this.mOptionPiker = new b(this.mContext, localArrayList);
      this.mOptionPiker.YrN = new b.b()
      {
        public void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(18887);
          KindaCardTypePickerView.this.mOptionPiker.hide();
          if (paramAnonymousBoolean)
          {
            paramAnonymousObject1 = (String)paramAnonymousObject1;
            KindaCardTypePickerView.this.mEditText.setText(paramAnonymousObject1);
            KindaCardTypePickerView.access$202(KindaCardTypePickerView.this, KindaCardTypePickerView.this.mOptionPiker.idp());
            KindaCardTypePickerView.this.mCallBack.onSelect(KindaCardTypePickerView.this.mOptionPiker.idp());
          }
          AppMethodBeat.o(18887);
        }
      };
      if (this.selected != -1) {
        this.mOptionPiker.ayK(this.selected);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCardTypePickerView
 * JD-Core Version:    0.7.0.1
 */