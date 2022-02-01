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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private LinearLayout fXb;
  private TextView gXb;
  private MMFormVerifyCodeInputView job;
  private com.tencent.mm.ui.a mActionBarHelper;
  private MyKeyboardWindow mKeyboard;
  AppBrandIDCardUI.a mLX;
  private View mLY;
  private hh mMB;
  private TextView mMC;
  private Button mMa;
  private hi mMo;
  private TextView mov;
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(48977);
    if ((this.mLX == null) || (this.mLX.bAQ() == null))
    {
      ae.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48977);
      return;
    }
    if ((this.mLX.bAQ().FSc == null) || (this.mLX.bAQ().FSc.size() <= 0))
    {
      ae.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
      AppMethodBeat.o(48977);
      return;
    }
    this.fXb = ((LinearLayout)paramView.findViewById(2131296756));
    this.gXb = ((TextView)paramView.findViewById(2131296753));
    this.mov = ((TextView)paramView.findViewById(2131296757));
    this.mMC = ((TextView)paramView.findViewById(2131296758));
    this.mMa = ((Button)paramView.findViewById(2131296742));
    this.job = ((MMFormVerifyCodeInputView)paramView.findViewById(2131296754));
    this.mKeyboard = ((MyKeyboardWindow)paramView.findViewById(2131296755));
    this.mLY = z.jV(getContext()).inflate(2131492921, null);
    this.mLY.setBackgroundColor(getResources().getColor(2131100705));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.mLY);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dX(getActivity()));
    this.fXb.addView(this.mLY, 0, paramView);
    this.mMo = this.mLX.bAQ();
    this.mActionBarHelper.setTitle(this.mMo.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48968);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
          AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).back();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48968);
      }
    });
    this.gXb.setText(this.mMo.desc);
    this.mMB = ((hh)this.mMo.FSc.get(0));
    this.mov.setText(((hh)this.mMo.FSc.get(0)).FSb);
    if (this.mMo.FSc.size() > 1)
    {
      this.mMC.setVisibility(0);
      this.mMC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48971);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
            AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).bAO();
          }
          paramAnonymousView = new e(AppBrandIDCardVerifyPwdFrag.this.getContext(), 1, false);
          paramAnonymousView.LfS = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(48969);
              ae.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[] { Integer.valueOf(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).FSc.size()) });
              Iterator localIterator = AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).FSc.iterator();
              while (localIterator.hasNext())
              {
                hh localhh = (hh)localIterator.next();
                if ((bu.isNullOrNil(localhh.FSa)) || (bu.isNullOrNil(localhh.FSb))) {
                  ae.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                } else {
                  paramAnonymous2l.d(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).FSc.indexOf(localhh), localhh.FSb);
                }
              }
              AppMethodBeat.o(48969);
            }
          };
          paramAnonymousView.LfT = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48970);
              hh localhh = (hh)AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).FSc.get(paramAnonymous2MenuItem.getItemId());
              if (localhh == null)
              {
                ae.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                AppMethodBeat.o(48970);
                return;
              }
              ae.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), localhh.FSa, localhh.FSb, localhh.dlT });
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this, localhh);
              AppBrandIDCardVerifyPwdFrag.c(AppBrandIDCardVerifyPwdFrag.this).setText(localhh.FSb);
              AppMethodBeat.o(48970);
            }
          };
          paramAnonymousView.cPF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48971);
        }
      });
      this.job.setVisibility(0);
      this.job.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48974);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          h.a(AppBrandIDCardVerifyPwdFrag.this.getContext(), AppBrandIDCardVerifyPwdFrag.this.getString(2131755472) + AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this).FSb, AppBrandIDCardVerifyPwdFrag.this.getString(2131755467), AppBrandIDCardVerifyPwdFrag.this.getString(2131755835), AppBrandIDCardVerifyPwdFrag.this.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48972);
              AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).bxk();
              ae.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
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
      this.job.addTextChangedListener(new TextWatcher()
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
      paramView = this.job.getContentEditText();
      if (paramView != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label570;
        }
        paramView.setShowSoftInputOnFocus(false);
      }
      label449:
      if ((this.job.getText() == null) || (this.job.getText().toString().length() <= 0)) {
        break label764;
      }
      this.mMa.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        this.mMa.setVisibility(0);
        this.mMa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48976);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
            if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).a(AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).getText().toString(), AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48976);
          }
        });
        this.mKeyboard.setXMode(0);
        this.mKeyboard.setInputEditText(this.job.getContentEditText());
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramView = new c();
          this.mKeyboard.setAccessibilityDelegate(paramView);
        }
        AppMethodBeat.o(48977);
        return;
        this.mMC.setVisibility(8);
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
            ae.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
            try
            {
              Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
              localMethod2.setAccessible(true);
              localMethod2.invoke(paramView, new Object[] { Boolean.FALSE });
              localMethod2.setAccessible(false);
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { bu.o(localException) });
            }
          }
          if ((paramView.getContext() == null) || (!(paramView.getContext() instanceof MMActivity))) {
            break label449;
          }
          ((MMActivity)paramView.getContext()).hideVKB(paramView);
        }
        catch (Exception paramView)
        {
          ae.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { bu.o(paramView) });
        }
      }
      break label449;
      label764:
      this.mMa.setEnabled(false);
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
    if (this.mLX != null)
    {
      this.mLX.onSwipeBack();
      getContentView().setVisibility(8);
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
    }
    AppMethodBeat.o(48979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag
 * JD-Core Version:    0.7.0.1
 */