package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.EditText;
import com.tencent.kinda.gen.KCardTypePickerView;
import com.tencent.kinda.gen.KCardTypePickerViewOnSelectCallback;
import com.tencent.kinda.gen.Option;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.widget.picker.b;
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
  private b mOptionPiker;
  private ArrayList<Option> mOptions;
  private int selected = -1;
  
  public EditText createView(Context paramContext)
  {
    AppMethodBeat.i(144751);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setTextSize(16.0F);
    this.mContext = paramContext;
    paramContext = this.mEditText;
    AppMethodBeat.o(144751);
    return paramContext;
  }
  
  public boolean getEnabled()
  {
    AppMethodBeat.i(144757);
    boolean bool = this.mEditText.isEnabled();
    AppMethodBeat.o(144757);
    return bool;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144755);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(144755);
    return bool;
  }
  
  public void select(int paramInt)
  {
    AppMethodBeat.i(144753);
    this.selected = paramInt;
    this.mEditText.setText(((Option)this.mOptions.get(paramInt)).mContent);
    AppMethodBeat.o(144753);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(144756);
    this.mEditText.setEnabled(paramBoolean);
    AppMethodBeat.o(144756);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144754);
    if (paramBoolean)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mOptions.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Option)localIterator.next()).mContent);
      }
      this.mOptionPiker = new b(this.mContext, localArrayList);
      this.mOptionPiker.AIW = new KindaCardTypePickerView.1(this);
      if (this.selected != -1) {
        this.mOptionPiker.Rw(this.selected);
      }
      int i = a.fromDPToPix(this.mContext, 288);
      this.mOptionPiker.Rv(i);
      this.mOptionPiker.show();
    }
    AppMethodBeat.o(144754);
  }
  
  public void setOnSelectCallback(KCardTypePickerViewOnSelectCallback paramKCardTypePickerViewOnSelectCallback)
  {
    this.mCallBack = paramKCardTypePickerViewOnSelectCallback;
  }
  
  public void setOptions(ArrayList<Option> paramArrayList)
  {
    AppMethodBeat.i(144752);
    this.mEditText.setText("");
    this.mOptions = paramArrayList;
    AppMethodBeat.o(144752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaCardTypePickerView
 * JD-Core Version:    0.7.0.1
 */