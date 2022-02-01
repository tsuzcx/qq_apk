package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.EditText;
import com.tencent.kinda.gen.BankCardType;
import com.tencent.kinda.gen.KBankCardTypePickerView;
import com.tencent.kinda.gen.KBankCardTypePickerViewOnSelectCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.CustomOptionPickNew;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KindaBankCardTypePickerViewImpl
  extends MMKView<EditText>
  implements KBankCardTypePickerView
{
  String TAG = "KindaBankCardTypePickerViewImpl";
  private ArrayList<BankCardType> mBankCardTypeArray;
  private Context mContext;
  private EditText mEditText;
  private ArrayList<String> mFirstOptionList = null;
  private int mFirstSelectedIndex = -1;
  private KBankCardTypePickerViewOnSelectCallback mOnSelectCallback;
  private c mOptionPiker;
  private ArrayList<List<BankCardType>> mSecondOptionList = null;
  private Map<String, ArrayList<BankCardType>> mSecondOptionMap = null;
  private ArrayList<List<String>> mSecondOptionStringList = null;
  private Map<String, ArrayList<String>> mSecondOptionStringMap = null;
  private int mSecondSelectedIndex = -1;
  private BankCardType mSelectedBankCardType;
  
  public EditText createView(Context paramContext)
  {
    AppMethodBeat.i(18836);
    this.mContext = paramContext;
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setTextSize(16.0F);
    this.mContext = paramContext;
    paramContext = this.mEditText;
    AppMethodBeat.o(18836);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18840);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(18840);
    return bool;
  }
  
  public String getValue()
  {
    return this.mSelectedBankCardType.mBankType;
  }
  
  public void setBankCardType(ArrayList<BankCardType> paramArrayList)
  {
    AppMethodBeat.i(18837);
    this.mEditText.setText("");
    this.mBankCardTypeArray = paramArrayList;
    this.mFirstOptionList = new ArrayList();
    this.mSecondOptionMap = new HashMap();
    this.mSecondOptionStringMap = new HashMap();
    paramArrayList = this.mBankCardTypeArray.iterator();
    Object localObject;
    while (paramArrayList.hasNext())
    {
      localObject = (BankCardType)paramArrayList.next();
      ArrayList localArrayList;
      if (!this.mSecondOptionMap.containsKey(((BankCardType)localObject).mBankName))
      {
        this.mFirstOptionList.add(((BankCardType)localObject).mBankName);
        localArrayList = new ArrayList();
        localArrayList.add(localObject);
        this.mSecondOptionMap.put(((BankCardType)localObject).mBankName, localArrayList);
        localArrayList = new ArrayList();
        localArrayList.add(((BankCardType)localObject).mBankaccTypeName);
        this.mSecondOptionStringMap.put(((BankCardType)localObject).mBankName, localArrayList);
      }
      else
      {
        localArrayList = (ArrayList)this.mSecondOptionMap.get(((BankCardType)localObject).mBankName);
        localArrayList.add(localObject);
        this.mSecondOptionMap.put(((BankCardType)localObject).mBankName, localArrayList);
        localArrayList = (ArrayList)this.mSecondOptionStringMap.get(((BankCardType)localObject).mBankName);
        localArrayList.add(((BankCardType)localObject).mBankaccTypeName);
        this.mSecondOptionStringMap.put(((BankCardType)localObject).mBankName, localArrayList);
      }
    }
    this.mSecondOptionList = new ArrayList();
    this.mSecondOptionStringList = new ArrayList();
    paramArrayList = this.mFirstOptionList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (String)paramArrayList.next();
      this.mSecondOptionList.add(this.mSecondOptionMap.get(localObject));
      this.mSecondOptionStringList.add(this.mSecondOptionStringMap.get(localObject));
    }
    AppMethodBeat.o(18837);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18839);
    if (paramBoolean)
    {
      this.mOptionPiker = new c(this.mContext, this.mFirstOptionList, this.mSecondOptionStringList);
      this.mOptionPiker.Lxq = new c.a()
      {
        public void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(18835);
          KindaBankCardTypePickerViewImpl.this.mOptionPiker.hide();
          if (paramAnonymousBoolean)
          {
            paramAnonymousObject1 = (String)paramAnonymousObject1;
            paramAnonymousObject2 = (String)paramAnonymousObject2;
            KindaBankCardTypePickerViewImpl.this.mEditText.setText(paramAnonymousObject1 + " " + paramAnonymousObject2);
            KindaBankCardTypePickerViewImpl.access$202(KindaBankCardTypePickerViewImpl.this, KindaBankCardTypePickerViewImpl.this.mOptionPiker.fRg());
            paramAnonymousObject1 = KindaBankCardTypePickerViewImpl.this;
            paramAnonymousObject2 = KindaBankCardTypePickerViewImpl.this.mOptionPiker;
            int i = 0;
            if (paramAnonymousObject2.Lxo != null) {
              i = paramAnonymousObject2.Lxo.getValue();
            }
            KindaBankCardTypePickerViewImpl.access$302(paramAnonymousObject1, i);
            if ((KindaBankCardTypePickerViewImpl.this.mFirstSelectedIndex >= 0) && (KindaBankCardTypePickerViewImpl.this.mSecondSelectedIndex >= 0))
            {
              paramAnonymousObject1 = (BankCardType)((List)KindaBankCardTypePickerViewImpl.this.mSecondOptionList.get(KindaBankCardTypePickerViewImpl.this.mFirstSelectedIndex)).get(KindaBankCardTypePickerViewImpl.this.mSecondSelectedIndex);
              KindaBankCardTypePickerViewImpl.access$502(KindaBankCardTypePickerViewImpl.this, paramAnonymousObject1);
              KindaBankCardTypePickerViewImpl.this.mOnSelectCallback.onSelect(paramAnonymousObject1.mBankType);
            }
          }
          AppMethodBeat.o(18835);
        }
      };
      if (this.mFirstSelectedIndex >= 0)
      {
        if (this.mSecondSelectedIndex < 0) {
          break label91;
        }
        this.mOptionPiker.kr(this.mFirstSelectedIndex, this.mSecondSelectedIndex);
      }
    }
    for (;;)
    {
      this.mOptionPiker.show();
      AppMethodBeat.o(18839);
      return;
      label91:
      this.mOptionPiker.agm(this.mFirstSelectedIndex);
    }
  }
  
  public void setOnSelectCallback(KBankCardTypePickerViewOnSelectCallback paramKBankCardTypePickerViewOnSelectCallback)
  {
    this.mOnSelectCallback = paramKBankCardTypePickerViewOnSelectCallback;
  }
  
  public void setSelectedBankCardType(BankCardType paramBankCardType)
  {
    int k = 0;
    AppMethodBeat.i(18838);
    if (paramBankCardType == null)
    {
      AppMethodBeat.o(18838);
      return;
    }
    if (paramBankCardType.mIsMaintainance)
    {
      AppMethodBeat.o(18838);
      return;
    }
    if (paramBankCardType.mForbidWord.length() > 0)
    {
      AppMethodBeat.o(18838);
      return;
    }
    this.mSelectedBankCardType = paramBankCardType;
    int i = 0;
    int j = k;
    if (i < this.mFirstOptionList.size())
    {
      if (((String)this.mFirstOptionList.get(i)).equals(paramBankCardType.mBankName))
      {
        this.mFirstSelectedIndex = i;
        j = k;
      }
    }
    else
    {
      label101:
      if (j < ((List)this.mSecondOptionList.get(this.mFirstSelectedIndex)).size())
      {
        if (!((BankCardType)((List)this.mSecondOptionList.get(this.mFirstSelectedIndex)).get(j)).mBankType.equals(paramBankCardType.mBankType)) {
          break label276;
        }
        this.mSecondSelectedIndex = j;
      }
      if (this.mFirstSelectedIndex < 0) {
        break label290;
      }
    }
    label276:
    label290:
    for (paramBankCardType = (String)this.mFirstOptionList.get(this.mFirstSelectedIndex);; paramBankCardType = "")
    {
      if ((this.mFirstSelectedIndex >= 0) && (this.mSecondSelectedIndex >= 0)) {}
      for (String str = (String)((List)this.mSecondOptionStringList.get(this.mFirstSelectedIndex)).get(this.mSecondSelectedIndex);; str = "")
      {
        paramBankCardType = paramBankCardType + " " + str;
        this.mEditText.setText(paramBankCardType);
        AppMethodBeat.o(18838);
        return;
        i += 1;
        break;
        j += 1;
        break label101;
      }
    }
  }
  
  public void setValue(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaBankCardTypePickerViewImpl
 * JD-Core Version:    0.7.0.1
 */