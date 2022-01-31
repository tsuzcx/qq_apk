package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KBankEditView;
import com.tencent.kinda.gen.KBankEditViewOnSeletBankCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public class KindaBankEditViewImpl
  extends MMKView<EditText>
  implements KBankEditView
{
  String TAG;
  private c<ac> bankEditSelectedEventIListener;
  private byte[] mBankLiskBuffer;
  private KBankEditViewOnSeletBankCallback mCallBack;
  private Context mContext;
  private EditText mEditText;
  
  public KindaBankEditViewImpl()
  {
    AppMethodBeat.i(144718);
    this.TAG = "KindaBank.KindaBankEditViewImpl";
    this.bankEditSelectedEventIListener = new KindaBankEditViewImpl.1(this);
    AppMethodBeat.o(144718);
  }
  
  public EditText createView(Context paramContext)
  {
    AppMethodBeat.i(144719);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setHint(2131305445);
    this.mEditText.setTextSize(16.0F);
    this.mContext = paramContext;
    ab.i(this.TAG, "BankEditSelected callback，注册监听，当前线程：" + Thread.currentThread().getId());
    paramContext = this.mEditText;
    AppMethodBeat.o(144719);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(144723);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(144723);
    return bool;
  }
  
  public void setData(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144720);
    this.mBankLiskBuffer = paramITransmitKvData.getBinary("bank_list");
    AppMethodBeat.o(144720);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(144722);
    if (paramBoolean)
    {
      this.bankEditSelectedEventIListener.alive();
      if ((this.mContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)this.mContext).hideTenpayKB();
      }
      Intent localIntent = new Intent(this.mContext, KindaWrapBankEditActivity.class);
      localIntent.putExtra("bank_list", this.mBankLiskBuffer);
      this.mContext.startActivity(localIntent);
    }
    AppMethodBeat.o(144722);
  }
  
  public void setOnSeletBankCallback(KBankEditViewOnSeletBankCallback paramKBankEditViewOnSeletBankCallback)
  {
    this.mCallBack = paramKBankEditViewOnSeletBankCallback;
  }
  
  public void setSelected(String paramString)
  {
    AppMethodBeat.i(144721);
    this.mEditText.setText(paramString);
    AppMethodBeat.o(144721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaBankEditViewImpl
 * JD-Core Version:    0.7.0.1
 */