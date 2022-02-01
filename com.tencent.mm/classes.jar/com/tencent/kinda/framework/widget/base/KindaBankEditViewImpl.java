package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KBankEditView;
import com.tencent.kinda.gen.KBankEditViewOnSeletBankCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.ag.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class KindaBankEditViewImpl
  extends MMKView<EditText>
  implements KBankEditView
{
  String TAG;
  private byte _hellAccFlag_;
  private c<ag> bankEditSelectedEventIListener;
  private FontStyle fontStyle;
  private byte[] mBankLiskBuffer;
  private String mBankType;
  private byte[] mBankTypeLiskBuffer;
  private KBankEditViewOnSeletBankCallback mCallBack;
  private Context mContext;
  private EditText mEditText;
  private DynamicColor normalColor;
  
  public KindaBankEditViewImpl()
  {
    AppMethodBeat.i(18844);
    this.TAG = "KindaBank.KindaBankEditViewImpl";
    this.normalColor = new DynamicColor(-1L, 0L);
    this.fontStyle = FontStyle.REGULAR;
    this.bankEditSelectedEventIListener = new c()
    {
      public boolean callback(ag paramAnonymousag)
      {
        AppMethodBeat.i(18842);
        if ("flag_activity_close_KindaWrapBankEditActivity".equals(paramAnonymousag.dkP.dkQ)) {
          KindaBankEditViewImpl.this.bankEditSelectedEventIListener.dead();
        }
        for (;;)
        {
          AppMethodBeat.o(18842);
          return false;
          if (!"flag_activity_back_KindaWrapBankEditActivity".equals(paramAnonymousag.dkP.dkQ)) {
            break;
          }
          KindaBankEditViewImpl.this.mCallBack.onSeletBank("");
        }
        if (!bt.cC(KindaBankEditViewImpl.this.mBankTypeLiskBuffer)) {}
        for (String str = paramAnonymousag.dkP.dkQ + " " + paramAnonymousag.dkP.dkS;; str = paramAnonymousag.dkP.dkQ)
        {
          KindaBankEditViewImpl.this.mEditText.setText(str);
          if (KindaBankEditViewImpl.this.mCallBack == null) {
            break;
          }
          KindaBankEditViewImpl.access$402(KindaBankEditViewImpl.this, paramAnonymousag.dkP.dkR);
          KindaBankEditViewImpl.this.mCallBack.onSeletBank(str);
          break;
        }
      }
    };
    AppMethodBeat.o(18844);
  }
  
  public EditText createView(Context paramContext)
  {
    AppMethodBeat.i(18845);
    this.mEditText = new EditText(paramContext);
    this.mEditText.setInputType(0);
    this.mEditText.setFocusable(false);
    this.mEditText.setBackground(null);
    this.mEditText.setHint(2131765659);
    this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(aj.getContext(), 17.0F));
    this.mEditText.setPadding(0, this.mEditText.getHeight() / 2, 0, this.mEditText.getHeight() / 2);
    this.mEditText.setGravity(16);
    this.mEditText.setInputType(131072);
    this.mEditText.setSingleLine(false);
    if (ColorUtil.ifCompatKindaDarkModeDefaultColor())
    {
      this.mEditText.setHintTextColor(paramContext.getResources().getColor(2131100490));
      this.mEditText.setTextColor(paramContext.getResources().getColor(2131100711));
    }
    this.mContext = paramContext;
    ad.i(this.TAG, "BankEditSelected callback，注册监听，当前线程：" + Thread.currentThread().getId());
    paramContext = this.mEditText;
    AppMethodBeat.o(18845);
    return paramContext;
  }
  
  public boolean getFocus()
  {
    AppMethodBeat.i(18849);
    boolean bool = this.mEditText.isFocused();
    AppMethodBeat.o(18849);
    return bool;
  }
  
  public FontStyle getFontStyle()
  {
    return this.fontStyle;
  }
  
  public String getSelectedBankType()
  {
    return this.mBankType;
  }
  
  public DynamicColor getTextColor()
  {
    return this.normalColor;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(18852);
    float f = this.mEditText.getTextSize();
    AppMethodBeat.o(18852);
    return f;
  }
  
  public void setData(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18846);
    this.mBankLiskBuffer = paramITransmitKvData.getBinary("bank_list");
    this.mBankTypeLiskBuffer = paramITransmitKvData.getBinary("bank_type_list");
    AppMethodBeat.o(18846);
  }
  
  public void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(18848);
    if (paramBoolean)
    {
      this.bankEditSelectedEventIListener.alive();
      if ((this.mContext instanceof BaseFrActivity)) {
        ((BaseFrActivity)this.mContext).hideTenpayKB();
      }
      Object localObject = new Intent(this.mContext, KindaWrapBankEditActivity.class);
      ((Intent)localObject).putExtra("bank_list", this.mBankLiskBuffer);
      ((Intent)localObject).putExtra("bank_type_list", this.mBankTypeLiskBuffer);
      Context localContext = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/kinda/framework/widget/base/KindaBankEditViewImpl", "setFocus", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/kinda/framework/widget/base/KindaBankEditViewImpl", "setFocus", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(18848);
  }
  
  public void setFontStyle(FontStyle paramFontStyle)
  {
    AppMethodBeat.i(18853);
    this.fontStyle = paramFontStyle;
    if (this.fontStyle == FontStyle.BOLD)
    {
      this.mEditText.setTypeface(null, 1);
      AppMethodBeat.o(18853);
      return;
    }
    this.mEditText.setTypeface(null, 0);
    AppMethodBeat.o(18853);
  }
  
  public void setOnSeletBankCallback(KBankEditViewOnSeletBankCallback paramKBankEditViewOnSeletBankCallback)
  {
    this.mCallBack = paramKBankEditViewOnSeletBankCallback;
  }
  
  public void setSelected(String paramString)
  {
    AppMethodBeat.i(18847);
    this.mEditText.setText(paramString);
    AppMethodBeat.o(18847);
  }
  
  public void setTextColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(18850);
    if (ColorUtil.getColorByModeNoCompat(this.normalColor) != ColorUtil.getColorByMode(paramDynamicColor)) {
      this.normalColor = paramDynamicColor;
    }
    this.mEditText.setTextColor((int)ColorUtil.getColorByModeNoCompat(this.normalColor));
    AppMethodBeat.o(18850);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(18851);
    this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(aj.getContext(), paramFloat));
    AppMethodBeat.o(18851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaBankEditViewImpl
 * JD-Core Version:    0.7.0.1
 */