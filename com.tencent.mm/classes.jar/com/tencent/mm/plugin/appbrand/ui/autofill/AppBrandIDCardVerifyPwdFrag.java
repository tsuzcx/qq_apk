package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class AppBrandIDCardVerifyPwdFrag
  extends MMFragment
{
  private LinearLayout elj;
  private MMFormVerifyCodeInputView gEj;
  private TextView hsI;
  private TextView iDg;
  private gb iQD;
  private TextView iQE;
  AppBrandIDCardUI.a iQb;
  private View iQc;
  private Button iQg;
  private gc iQu;
  private a mActionBarHelper;
  private MyKeyboardWindow mKeyboard;
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(133258);
    if ((this.iQb == null) || (this.iQb.aMF() == null))
    {
      ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(133258);
      return;
    }
    if ((this.iQb.aMF().wsl == null) || (this.iQb.aMF().wsl.size() <= 0))
    {
      ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
      AppMethodBeat.o(133258);
      return;
    }
    this.elj = ((LinearLayout)paramView.findViewById(2131821237));
    this.hsI = ((TextView)paramView.findViewById(2131821238));
    this.iDg = ((TextView)paramView.findViewById(2131821239));
    this.iQE = ((TextView)paramView.findViewById(2131821240));
    this.iQg = ((Button)paramView.findViewById(2131821233));
    this.gEj = ((MMFormVerifyCodeInputView)paramView.findViewById(2131821241));
    this.mKeyboard = ((MyKeyboardWindow)paramView.findViewById(2131821242));
    this.iQc = w.hM(getContext()).inflate(2130968613, null);
    this.iQc.setBackgroundColor(getResources().getColor(2131690316));
    this.mActionBarHelper = new a(this.iQc);
    paramView = new LinearLayout.LayoutParams(-1, b.di(getActivity()));
    this.elj.addView(this.iQc, 0, paramView);
    this.iQu = this.iQb.aMF();
    this.mActionBarHelper.setTitle(this.iQu.title);
    this.mActionBarHelper.b(new AppBrandIDCardVerifyPwdFrag.1(this));
    this.hsI.setText(this.iQu.desc);
    this.iQD = ((gb)this.iQu.wsl.get(0));
    this.iDg.setText(((gb)this.iQu.wsl.get(0)).wsk);
    if (this.iQu.wsl.size() > 1)
    {
      this.iQE.setVisibility(0);
      this.iQE.setOnClickListener(new AppBrandIDCardVerifyPwdFrag.2(this));
      this.gEj.setVisibility(0);
      this.gEj.setSendSmsBtnClickListener(new AppBrandIDCardVerifyPwdFrag.3(this));
      this.gEj.addTextChangedListener(new AppBrandIDCardVerifyPwdFrag.4(this));
      paramView = this.gEj.getContentEditText();
      if (paramView != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label570;
        }
        paramView.setShowSoftInputOnFocus(false);
      }
      label449:
      if ((this.gEj.getText() == null) || (this.gEj.getText().toString().length() <= 0)) {
        break label764;
      }
      this.iQg.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        this.iQg.setVisibility(0);
        this.iQg.setOnClickListener(new AppBrandIDCardVerifyPwdFrag.5(this));
        this.mKeyboard.setXMode(0);
        this.mKeyboard.setInputEditText(this.gEj.getContentEditText());
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramView = new c();
          this.mKeyboard.setAccessibilityDelegate(paramView);
        }
        AppMethodBeat.o(133258);
        return;
        this.iQE.setVisibility(8);
        break;
        try
        {
          label570:
          Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
          localMethod1.setAccessible(true);
          localMethod1.invoke(paramView, new Object[] { Boolean.FALSE });
          localMethod1.setAccessible(false);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          for (;;)
          {
            ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
            try
            {
              Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
              localMethod2.setAccessible(true);
              localMethod2.invoke(paramView, new Object[] { Boolean.FALSE });
              localMethod2.setAccessible(false);
            }
            catch (Exception localException)
            {
              ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bo.l(localException) });
            }
          }
          if ((paramView.getContext() == null) || (!(paramView.getContext() instanceof MMActivity))) {
            break label449;
          }
          ((MMActivity)paramView.getContext()).hideVKB(paramView);
        }
        catch (Exception paramView)
        {
          ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bo.l(paramView) });
        }
      }
      break label449;
      label764:
      this.iQg.setEnabled(false);
    }
  }
  
  public int getLayoutId()
  {
    return 2130968691;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(133259);
    super.onResume();
    if (isSupportNavigationSwipeBack())
    {
      getContentView().setVisibility(0);
      getSwipeBackLayout().setEnableGesture(true);
    }
    AppMethodBeat.o(133259);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(133260);
    if (this.iQb != null)
    {
      this.iQb.onSwipeBack();
      getContentView().setVisibility(8);
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
    }
    AppMethodBeat.o(133260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag
 * JD-Core Version:    0.7.0.1
 */