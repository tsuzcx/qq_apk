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
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private LinearLayout fUV;
  private TextView gUs;
  private MMFormVerifyCodeInputView jlh;
  private com.tencent.mm.ui.a mActionBarHelper;
  AppBrandIDCardUI.a mGT;
  private View mGU;
  private Button mGW;
  private hi mHk;
  private hh mHx;
  private TextView mHy;
  private MyKeyboardWindow mKeyboard;
  private TextView mjy;
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(48977);
    if ((this.mGT == null) || (this.mGT.bzV() == null))
    {
      ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48977);
      return;
    }
    if ((this.mGT.bzV().FzE == null) || (this.mGT.bzV().FzE.size() <= 0))
    {
      ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
      AppMethodBeat.o(48977);
      return;
    }
    this.fUV = ((LinearLayout)paramView.findViewById(2131296756));
    this.gUs = ((TextView)paramView.findViewById(2131296753));
    this.mjy = ((TextView)paramView.findViewById(2131296757));
    this.mHy = ((TextView)paramView.findViewById(2131296758));
    this.mGW = ((Button)paramView.findViewById(2131296742));
    this.jlh = ((MMFormVerifyCodeInputView)paramView.findViewById(2131296754));
    this.mKeyboard = ((MyKeyboardWindow)paramView.findViewById(2131296755));
    this.mGU = z.jO(getContext()).inflate(2131492921, null);
    this.mGU.setBackgroundColor(getResources().getColor(2131100705));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.mGU);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dT(getActivity()));
    this.fUV.addView(this.mGU, 0, paramView);
    this.mHk = this.mGT.bzV();
    this.mActionBarHelper.setTitle(this.mHk.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48968);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
          AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).back();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48968);
      }
    });
    this.gUs.setText(this.mHk.desc);
    this.mHx = ((hh)this.mHk.FzE.get(0));
    this.mjy.setText(((hh)this.mHk.FzE.get(0)).FzD);
    if (this.mHk.FzE.size() > 1)
    {
      this.mHy.setVisibility(0);
      this.mHy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48971);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
            AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).bzT();
          }
          paramAnonymousView = new e(AppBrandIDCardVerifyPwdFrag.this.getContext(), 1, false);
          paramAnonymousView.KJy = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(48969);
              ad.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[] { Integer.valueOf(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).FzE.size()) });
              Iterator localIterator = AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).FzE.iterator();
              while (localIterator.hasNext())
              {
                hh localhh = (hh)localIterator.next();
                if ((bt.isNullOrNil(localhh.FzC)) || (bt.isNullOrNil(localhh.FzD))) {
                  ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                } else {
                  paramAnonymous2l.c(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).FzE.indexOf(localhh), localhh.FzD);
                }
              }
              AppMethodBeat.o(48969);
            }
          };
          paramAnonymousView.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48970);
              hh localhh = (hh)AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).FzE.get(paramAnonymous2MenuItem.getItemId());
              if (localhh == null)
              {
                ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                AppMethodBeat.o(48970);
                return;
              }
              ad.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), localhh.FzC, localhh.FzD, localhh.dkR });
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this, localhh);
              AppBrandIDCardVerifyPwdFrag.c(AppBrandIDCardVerifyPwdFrag.this).setText(localhh.FzD);
              AppMethodBeat.o(48970);
            }
          };
          paramAnonymousView.cMW();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48971);
        }
      });
      this.jlh.setVisibility(0);
      this.jlh.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48974);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          h.a(AppBrandIDCardVerifyPwdFrag.this.getContext(), AppBrandIDCardVerifyPwdFrag.this.getString(2131755472) + AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this).FzD, AppBrandIDCardVerifyPwdFrag.this.getString(2131755467), AppBrandIDCardVerifyPwdFrag.this.getString(2131755835), AppBrandIDCardVerifyPwdFrag.this.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48972);
              AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).bwt();
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48974);
        }
      });
      this.jlh.addTextChangedListener(new TextWatcher()
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
      paramView = this.jlh.getContentEditText();
      if (paramView != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label570;
        }
        paramView.setShowSoftInputOnFocus(false);
      }
      label449:
      if ((this.jlh.getText() == null) || (this.jlh.getText().toString().length() <= 0)) {
        break label764;
      }
      this.mGW.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        this.mGW.setVisibility(0);
        this.mGW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48976);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
            if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).a(AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).getText().toString(), AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48976);
          }
        });
        this.mKeyboard.setXMode(0);
        this.mKeyboard.setInputEditText(this.jlh.getContentEditText());
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramView = new c();
          this.mKeyboard.setAccessibilityDelegate(paramView);
        }
        AppMethodBeat.o(48977);
        return;
        this.mHy.setVisibility(8);
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
              ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bt.n(localException) });
            }
          }
          if ((paramView.getContext() == null) || (!(paramView.getContext() instanceof MMActivity))) {
            break label449;
          }
          ((MMActivity)paramView.getContext()).hideVKB(paramView);
        }
        catch (Exception paramView)
        {
          ad.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bt.n(paramView) });
        }
      }
      break label449;
      label764:
      this.mGW.setEnabled(false);
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
    if (this.mGT != null)
    {
      this.mGT.onSwipeBack();
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