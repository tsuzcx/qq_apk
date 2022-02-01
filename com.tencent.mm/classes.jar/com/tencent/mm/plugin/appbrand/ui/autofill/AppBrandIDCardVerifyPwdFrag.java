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
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;

public class AppBrandIDCardVerifyPwdFrag
  extends MMFragment
{
  private LinearLayout gCh;
  private TextView hPW;
  private MMFormVerifyCodeInputView kmk;
  private com.tencent.mm.ui.a mActionBarHelper;
  private MyKeyboardWindow mKeyboard;
  private hv nZB;
  private hu nZO;
  private TextView nZP;
  AppBrandIDCardUI.a nZf;
  private View nZg;
  private Button nZi;
  private TextView nzh;
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(48977);
    if ((this.nZf == null) || (this.nZf.bXV() == null))
    {
      Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48977);
      return;
    }
    if ((this.nZf.bXV().KLJ == null) || (this.nZf.bXV().KLJ.size() <= 0))
    {
      Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
      AppMethodBeat.o(48977);
      return;
    }
    this.gCh = ((LinearLayout)paramView.findViewById(2131296837));
    this.hPW = ((TextView)paramView.findViewById(2131296834));
    this.nzh = ((TextView)paramView.findViewById(2131296838));
    this.nZP = ((TextView)paramView.findViewById(2131296839));
    this.nZi = ((Button)paramView.findViewById(2131296823));
    this.kmk = ((MMFormVerifyCodeInputView)paramView.findViewById(2131296835));
    this.mKeyboard = ((MyKeyboardWindow)paramView.findViewById(2131296836));
    this.nZg = aa.jQ(getContext()).inflate(2131492939, null);
    this.nZg.setBackgroundColor(getResources().getColor(2131100898));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.nZg);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.eu(getActivity()));
    this.gCh.addView(this.nZg, 0, paramView);
    this.nZB = this.nZf.bXV();
    this.mActionBarHelper.setTitle(this.nZB.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48968);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
          AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).back();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48968);
      }
    });
    this.hPW.setText(this.nZB.desc);
    this.nZO = ((hu)this.nZB.KLJ.get(0));
    this.nzh.setText(((hu)this.nZB.KLJ.get(0)).KLI);
    if (this.nZB.KLJ.size() > 1)
    {
      this.nZP.setVisibility(0);
      this.nZP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48971);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
            AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).bXT();
          }
          paramAnonymousView = new e(AppBrandIDCardVerifyPwdFrag.this.getContext(), 1, false);
          paramAnonymousView.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(48969);
              Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[] { Integer.valueOf(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).KLJ.size()) });
              Iterator localIterator = AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).KLJ.iterator();
              while (localIterator.hasNext())
              {
                hu localhu = (hu)localIterator.next();
                if ((Util.isNullOrNil(localhu.KLH)) || (Util.isNullOrNil(localhu.KLI))) {
                  Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                } else {
                  paramAnonymous2m.d(AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).KLJ.indexOf(localhu), localhu.KLI);
                }
              }
              AppMethodBeat.o(48969);
            }
          };
          paramAnonymousView.HLY = new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48970);
              hu localhu = (hu)AppBrandIDCardVerifyPwdFrag.b(AppBrandIDCardVerifyPwdFrag.this).KLJ.get(paramAnonymous2MenuItem.getItemId());
              if (localhu == null)
              {
                Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                AppMethodBeat.o(48970);
                return;
              }
              Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), localhu.KLH, localhu.KLI, localhu.dDj });
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this, localhu);
              AppBrandIDCardVerifyPwdFrag.c(AppBrandIDCardVerifyPwdFrag.this).setText(localhu.KLI);
              AppMethodBeat.o(48970);
            }
          };
          paramAnonymousView.dGm();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48971);
        }
      });
      this.kmk.setVisibility(0);
      this.kmk.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48974);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          h.a(AppBrandIDCardVerifyPwdFrag.this.getContext(), AppBrandIDCardVerifyPwdFrag.this.getString(2131755510) + AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this).KLI, AppBrandIDCardVerifyPwdFrag.this.getString(2131755505), AppBrandIDCardVerifyPwdFrag.this.getString(2131755921), AppBrandIDCardVerifyPwdFrag.this.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(48972);
              AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).bTu();
              Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
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
      this.kmk.addTextChangedListener(new TextWatcher()
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
      paramView = this.kmk.getContentEditText();
      if (paramView != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label570;
        }
        paramView.setShowSoftInputOnFocus(false);
      }
      label449:
      if ((this.kmk.getText() == null) || (this.kmk.getText().toString().length() <= 0)) {
        break label764;
      }
      this.nZi.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        this.nZi.setVisibility(0);
        this.nZi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48976);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
            if (AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this) != null) {
              AppBrandIDCardVerifyPwdFrag.a(AppBrandIDCardVerifyPwdFrag.this).a(AppBrandIDCardVerifyPwdFrag.e(AppBrandIDCardVerifyPwdFrag.this).getText().toString(), AppBrandIDCardVerifyPwdFrag.d(AppBrandIDCardVerifyPwdFrag.this));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardVerifyPwdFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48976);
          }
        });
        this.mKeyboard.setXMode(0);
        this.mKeyboard.setInputEditText(this.kmk.getContentEditText());
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramView = new d();
          this.mKeyboard.setAccessibilityDelegate(paramView);
        }
        AppMethodBeat.o(48977);
        return;
        this.nZP.setVisibility(8);
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
            Log.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
            try
            {
              Method localMethod2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[] { Boolean.TYPE });
              localMethod2.setAccessible(true);
              localMethod2.invoke(paramView, new Object[] { Boolean.FALSE });
              localMethod2.setAccessible(false);
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[] { Util.stackTraceToString(localException) });
            }
          }
          if ((paramView.getContext() == null) || (!(paramView.getContext() instanceof MMActivity))) {
            break label449;
          }
          ((MMActivity)paramView.getContext()).hideVKB(paramView);
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[] { Util.stackTraceToString(paramView) });
        }
      }
      break label449;
      label764:
      this.nZi.setEnabled(false);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493042;
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
    if (this.nZf != null)
    {
      this.nZf.onSwipeBack();
      getContentView().setVisibility(8);
      if (isSupportNavigationSwipeBack()) {
        getSwipeBackLayout().setEnableGesture(false);
      }
    }
    AppMethodBeat.o(48979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag
 * JD-Core Version:    0.7.0.1
 */