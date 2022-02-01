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
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
import com.tencent.mm.ui.z;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandIDCardVerifyPwdFrag
  extends MMFragment
{
  private LinearLayout fBI;
  private TextView gAI;
  private MMFormVerifyCodeInputView iRZ;
  private TextView lJL;
  private a mActionBarHelper;
  private MyKeyboardWindow mKeyboard;
  private hb mgK;
  private ha mgX;
  private TextView mgY;
  AppBrandIDCardUI.a mgt;
  private View mgu;
  private Button mgw;
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(48977);
    if ((this.mgt == null) || (this.mgt.bvP() == null))
    {
      ac.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48977);
      return;
    }
    if ((this.mgt.bvP().DUk == null) || (this.mgt.bvP().DUk.size() <= 0))
    {
      ac.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
      AppMethodBeat.o(48977);
      return;
    }
    this.fBI = ((LinearLayout)paramView.findViewById(2131296756));
    this.gAI = ((TextView)paramView.findViewById(2131296753));
    this.lJL = ((TextView)paramView.findViewById(2131296757));
    this.mgY = ((TextView)paramView.findViewById(2131296758));
    this.mgw = ((Button)paramView.findViewById(2131296742));
    this.iRZ = ((MMFormVerifyCodeInputView)paramView.findViewById(2131296754));
    this.mKeyboard = ((MyKeyboardWindow)paramView.findViewById(2131296755));
    this.mgu = z.jD(getContext()).inflate(2131492921, null);
    this.mgu.setBackgroundColor(getResources().getColor(2131100705));
    this.mActionBarHelper = new a(this.mgu);
    paramView = new LinearLayout.LayoutParams(-1, b.dT(getActivity()));
    this.fBI.addView(this.mgu, 0, paramView);
    this.mgK = this.mgt.bvP();
    this.mActionBarHelper.setTitle(this.mgK.title);
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
    this.gAI.setText(this.mgK.desc);
    this.mgX = ((ha)this.mgK.DUk.get(0));
    this.lJL.setText(((ha)this.mgK.DUk.get(0)).DUj);
    if (this.mgK.DUk.size() > 1)
    {
      this.mgY.setVisibility(0);
      this.mgY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48971);
          if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
            AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).bvN();
          }
          paramAnonymousView = new e(AppBrandIDCardVerifyPwdFrag.this.getContext(), 1, false);
          paramAnonymousView.ISu = new n.c()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(48969);
              ac.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[] { Integer.valueOf(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).DUk.size()) });
              Iterator localIterator = AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).DUk.iterator();
              while (localIterator.hasNext())
              {
                ha localha = (ha)localIterator.next();
                if ((bs.isNullOrNil(localha.DUi)) || (bs.isNullOrNil(localha.DUj))) {
                  ac.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                } else {
                  paramAnonymous2l.c(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).DUk.indexOf(localha), localha.DUj);
                }
              }
              AppMethodBeat.o(48969);
            }
          };
          paramAnonymousView.ISv = new n.d()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48970);
              ha localha = (ha)AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).DUk.get(paramAnonymous2MenuItem.getItemId());
              if (localha == null)
              {
                ac.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                AppMethodBeat.o(48970);
                return;
              }
              ac.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), localha.DUi, localha.DUj, localha.cZz });
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this, localha);
              AppBrandIDCardVerifyPwdFrag.c(AppBrandIDCardVerifyPwdFrag.this).setText(localha.DUj);
              AppMethodBeat.o(48970);
            }
          };
          paramAnonymousView.cED();
          AppMethodBeat.o(48971);
        }
      });
      this.iRZ.setVisibility(0);
      this.iRZ.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48974);
          h.a(AppBrandIDCardVerifyPwdFrag.this.getContext(), AppBrandIDCardVerifyPwdFrag.this.getString(2131755472) + AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this).DUj, AppBrandIDCardVerifyPwdFrag.this.getString(2131755467), AppBrandIDCardVerifyPwdFrag.this.getString(2131755835), AppBrandIDCardVerifyPwdFrag.this.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48972);
              AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).bso();
              ac.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
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
      this.iRZ.addTextChangedListener(new TextWatcher()
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
      paramView = this.iRZ.getContentEditText();
      if (paramView != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label570;
        }
        paramView.setShowSoftInputOnFocus(false);
      }
      label449:
      if ((this.iRZ.getText() == null) || (this.iRZ.getText().toString().length() <= 0)) {
        break label764;
      }
      this.mgw.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        this.mgw.setVisibility(0);
        this.mgw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48976);
            ac.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
            if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).a(AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).getText().toString(), AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this));
            }
            AppMethodBeat.o(48976);
          }
        });
        this.mKeyboard.setXMode(0);
        this.mKeyboard.setInputEditText(this.iRZ.getContentEditText());
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramView = new c();
          this.mKeyboard.setAccessibilityDelegate(paramView);
        }
        AppMethodBeat.o(48977);
        return;
        this.mgY.setVisibility(8);
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
            ac.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
            try
            {
              Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
              localMethod2.setAccessible(true);
              localMethod2.invoke(paramView, new Object[] { Boolean.FALSE });
              localMethod2.setAccessible(false);
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bs.m(localException) });
            }
          }
          if ((paramView.getContext() == null) || (!(paramView.getContext() instanceof MMActivity))) {
            break label449;
          }
          ((MMActivity)paramView.getContext()).hideVKB(paramView);
        }
        catch (Exception paramView)
        {
          ac.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bs.m(paramView) });
        }
      }
      break label449;
      label764:
      this.mgw.setEnabled(false);
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
    if (this.mgt != null)
    {
      this.mgt.onSwipeBack();
      getContentView().setVisibility(8);
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
    }
    AppMethodBeat.o(48979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag
 * JD-Core Version:    0.7.0.1
 */