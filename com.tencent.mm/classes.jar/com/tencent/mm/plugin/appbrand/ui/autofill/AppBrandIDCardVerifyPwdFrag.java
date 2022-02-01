package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.y;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandIDCardVerifyPwdFrag
  extends MMFragment
{
  private LinearLayout fyb;
  private MMFormVerifyCodeInputView irU;
  private TextView lEA;
  private Button lEC;
  private gx lEQ;
  AppBrandIDCardUI.a lEy;
  private View lEz;
  private gw lFd;
  private TextView lFe;
  private TextView ljT;
  private a mActionBarHelper;
  private MyKeyboardWindow mKeyboard;
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(48977);
    if ((this.lEy == null) || (this.lEy.boU() == null))
    {
      ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48977);
      return;
    }
    if ((this.lEy.boU().CBM == null) || (this.lEy.boU().CBM.size() <= 0))
    {
      ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
      AppMethodBeat.o(48977);
      return;
    }
    this.fyb = ((LinearLayout)paramView.findViewById(2131296756));
    this.lEA = ((TextView)paramView.findViewById(2131296753));
    this.ljT = ((TextView)paramView.findViewById(2131296757));
    this.lFe = ((TextView)paramView.findViewById(2131296758));
    this.lEC = ((Button)paramView.findViewById(2131296742));
    this.irU = ((MMFormVerifyCodeInputView)paramView.findViewById(2131296754));
    this.mKeyboard = ((MyKeyboardWindow)paramView.findViewById(2131296755));
    this.lEz = y.js(getContext()).inflate(2131492921, null);
    this.lEz.setBackgroundColor(getResources().getColor(2131100705));
    this.mActionBarHelper = new a(this.lEz);
    paramView = new LinearLayout.LayoutParams(-1, b.dL(getActivity()));
    this.fyb.addView(this.lEz, 0, paramView);
    this.lEQ = this.lEy.boU();
    this.mActionBarHelper.setTitle(this.lEQ.title);
    this.mActionBarHelper.e(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48968);
        if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
          AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).back();
        }
        AppMethodBeat.o(48968);
      }
    });
    this.lEA.setText(this.lEQ.desc);
    this.lFd = ((gw)this.lEQ.CBM.get(0));
    this.ljT.setText(((gw)this.lEQ.CBM.get(0)).CBL);
    if (this.lEQ.CBM.size() > 1)
    {
      this.lFe.setVisibility(0);
      this.lFe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48971);
          if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
            AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).boS();
          }
          paramAnonymousView = new e(AppBrandIDCardVerifyPwdFrag.this.getContext(), 1, false);
          paramAnonymousView.HrX = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(48969);
              ad.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[] { Integer.valueOf(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).CBM.size()) });
              Iterator localIterator = AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).CBM.iterator();
              while (localIterator.hasNext())
              {
                gw localgw = (gw)localIterator.next();
                if ((bt.isNullOrNil(localgw.CBK)) || (bt.isNullOrNil(localgw.CBL))) {
                  ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                } else {
                  paramAnonymous2l.c(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).CBM.indexOf(localgw), localgw.CBL);
                }
              }
              AppMethodBeat.o(48969);
            }
          };
          paramAnonymousView.HrY = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48970);
              gw localgw = (gw)AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).CBM.get(paramAnonymous2MenuItem.getItemId());
              if (localgw == null)
              {
                ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                AppMethodBeat.o(48970);
                return;
              }
              ad.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), localgw.CBK, localgw.CBL, localgw.dca });
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this, localgw);
              AppBrandIDCardVerifyPwdFrag.c(AppBrandIDCardVerifyPwdFrag.this).setText(localgw.CBL);
              AppMethodBeat.o(48970);
            }
          };
          paramAnonymousView.csG();
          AppMethodBeat.o(48971);
        }
      });
      this.irU.setVisibility(0);
      this.irU.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48974);
          h.a(AppBrandIDCardVerifyPwdFrag.this.getContext(), AppBrandIDCardVerifyPwdFrag.this.getString(2131755472) + AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this).CBL, AppBrandIDCardVerifyPwdFrag.this.getString(2131755467), AppBrandIDCardVerifyPwdFrag.this.getString(2131755835), AppBrandIDCardVerifyPwdFrag.this.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48972);
              AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).blz();
              ad.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
              if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
                AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).a(AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this));
              }
              AppMethodBeat.o(48972);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48973);
              AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).reset();
              AppMethodBeat.o(48973);
            }
          });
          AppMethodBeat.o(48974);
        }
      });
      this.irU.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(48975);
          if (AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).getText().toString().length() > 0)
          {
            AppBrandIDCardVerifyPwdFrag.f(AppBrandIDCardVerifyPwdFrag.this).setEnabled(true);
            AppMethodBeat.o(48975);
            return;
          }
          AppBrandIDCardVerifyPwdFrag.f(AppBrandIDCardVerifyPwdFrag.this).setEnabled(false);
          AppMethodBeat.o(48975);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      paramView = this.irU.getContentEditText();
      if (paramView != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label570;
        }
        paramView.setShowSoftInputOnFocus(false);
      }
      label449:
      if ((this.irU.getText() == null) || (this.irU.getText().toString().length() <= 0)) {
        break label764;
      }
      this.lEC.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        this.lEC.setVisibility(0);
        this.lEC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48976);
            ad.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
            if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).a(AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).getText().toString(), AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this));
            }
            AppMethodBeat.o(48976);
          }
        });
        this.mKeyboard.setXMode(0);
        this.mKeyboard.setInputEditText(this.irU.getContentEditText());
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramView = new c();
          this.mKeyboard.setAccessibilityDelegate(paramView);
        }
        AppMethodBeat.o(48977);
        return;
        this.lFe.setVisibility(8);
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
            ad.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
            try
            {
              Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
              localMethod2.setAccessible(true);
              localMethod2.invoke(paramView, new Object[] { Boolean.FALSE });
              localMethod2.setAccessible(false);
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bt.m(localException) });
            }
          }
          if ((paramView.getContext() == null) || (!(paramView.getContext() instanceof MMActivity))) {
            break label449;
          }
          ((MMActivity)paramView.getContext()).hideVKB(paramView);
        }
        catch (Exception paramView)
        {
          ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bt.m(paramView) });
        }
      }
      break label449;
      label764:
      this.lEC.setEnabled(false);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493004;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48978);
    super.onResume();
    if (isSupportNavigationSwipeBack())
    {
      getContentView().setVisibility(0);
      getSwipeBackLayout().setEnableGesture(true);
    }
    AppMethodBeat.o(48978);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48979);
    if (this.lEy != null)
    {
      this.lEy.onSwipeBack();
      getContentView().setVisibility(8);
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
    }
    AppMethodBeat.o(48979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag
 * JD-Core Version:    0.7.0.1
 */