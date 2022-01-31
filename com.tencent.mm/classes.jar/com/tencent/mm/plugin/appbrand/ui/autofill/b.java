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
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.x;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;
import java.util.LinkedList;

public final class b
  extends x
{
  private LinearLayout dtF;
  private MMFormVerifyCodeInputView fmP;
  private TextView gaI;
  AppBrandIDCardUI.a heO;
  private View heP;
  private Button heS;
  private ey hfg;
  private ex hfo;
  private TextView hfp;
  private TextView hfq;
  private com.tencent.mm.ui.b mActionBarHelper;
  private MyKeyboardWindow mKeyboard;
  
  protected final void dealContentView(View paramView)
  {
    if ((this.heO == null) || (this.heO.app() == null))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      return;
    }
    if ((this.heO.app().syD == null) || (this.heO.app().syD.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
      return;
    }
    this.dtF = ((LinearLayout)paramView.findViewById(y.g.app_brand_idcard_verify_sms_layout));
    this.gaI = ((TextView)paramView.findViewById(y.g.app_brand_idcard_verify_sms_desc));
    this.hfp = ((TextView)paramView.findViewById(y.g.app_brand_idcard_verify_sms_phone_number));
    this.hfq = ((TextView)paramView.findViewById(y.g.app_brand_idcard_verify_sms_switch_phone));
    this.heS = ((Button)paramView.findViewById(y.g.app_brand_idcard_show_confirm));
    this.fmP = ((MMFormVerifyCodeInputView)paramView.findViewById(y.g.app_brand_idcard_verify_sms_edit));
    this.mKeyboard = ((MyKeyboardWindow)paramView.findViewById(y.g.app_brand_idcard_verify_sms_input));
    this.heP = com.tencent.mm.ui.y.gt(getContext()).inflate(y.h.actionbar_custom_area, null);
    this.heP.setBackgroundColor(getResources().getColor(y.d.action_bar_color));
    this.mActionBarHelper = new com.tencent.mm.ui.b(this.heP);
    paramView = new LinearLayout.LayoutParams(-1, a.cD(getActivity()));
    this.dtF.addView(this.heP, 0, paramView);
    this.hfg = this.heO.app();
    this.mActionBarHelper.setTitle(this.hfg.title);
    this.mActionBarHelper.cxQ();
    paramView = getResources().getDrawable(y.i.actionbar_icon_light_back);
    this.mActionBarHelper.s(paramView);
    this.mActionBarHelper.d(new b.1(this));
    this.gaI.setText(this.hfg.desc);
    this.hfo = ((ex)this.hfg.syD.get(0));
    this.hfp.setText(((ex)this.hfg.syD.get(0)).syC);
    if (this.hfg.syD.size() > 1)
    {
      this.hfq.setVisibility(0);
      this.hfq.setOnClickListener(new b.2(this));
      label406:
      this.fmP.setVisibility(0);
      this.fmP.setSendSmsBtnClickListener(new b.3(this));
      this.fmP.addTextChangedListener(new b.4(this));
      paramView = this.fmP.getContentEditText();
      if (paramView != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label585;
        }
        paramView.setShowSoftInputOnFocus(false);
      }
      label469:
      if ((this.fmP.getText() == null) || (this.fmP.getText().toString().length() <= 0)) {
        break label781;
      }
      this.heS.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        this.heS.setVisibility(0);
        this.heS.setOnClickListener(new b.5(this));
        this.mKeyboard.setXMode(0);
        this.mKeyboard.setInputEditText(this.fmP.getContentEditText());
        if (Build.VERSION.SDK_INT < 14) {
          break;
        }
        paramView = new c();
        this.mKeyboard.setAccessibilityDelegate(paramView);
        return;
        this.hfq.setVisibility(8);
        break label406;
        try
        {
          label585:
          Method localMethod1 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { Boolean.TYPE });
          localMethod1.setAccessible(true);
          localMethod1.invoke(paramView, new Object[] { Boolean.valueOf(false) });
          localMethod1.setAccessible(false);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
            try
            {
              Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
              localMethod2.setAccessible(true);
              localMethod2.invoke(paramView, new Object[] { Boolean.valueOf(false) });
              localMethod2.setAccessible(false);
            }
            catch (Exception localException)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bk.j(localException) });
            }
          }
          if ((paramView.getContext() == null) || (!(paramView.getContext() instanceof MMActivity))) {
            break label469;
          }
          ((MMActivity)paramView.getContext()).hideVKB(paramView);
        }
        catch (Exception paramView)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bk.j(paramView) });
        }
      }
      break label469;
      label781:
      this.heS.setEnabled(false);
    }
  }
  
  protected final int getLayoutId()
  {
    return y.h.app_brand_idcard_verify_sms_ui;
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  public final void onResume()
  {
    super.onResume();
    if (isSupportNavigationSwipeBack())
    {
      getContentView().setVisibility(0);
      getSwipeBackLayout().setEnableGesture(true);
    }
  }
  
  public final void onSwipeBack()
  {
    if (this.heO != null)
    {
      this.heO.onSwipeBack();
      getContentView().setVisibility(8);
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.b
 * JD-Core Version:    0.7.0.1
 */