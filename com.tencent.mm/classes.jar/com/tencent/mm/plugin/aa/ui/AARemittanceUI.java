package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.aa.model.b.g.c;
import com.tencent.mm.plugin.aa.model.b.g.e;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;

public class AARemittanceUI
  extends BaseAAPresenterActivity
{
  private String dFw;
  private String dXh;
  private Dialog jUV;
  private int jVe;
  protected ScrollView jVf;
  private WcPayKeyboard jVg;
  private TextView jVh;
  private ImageView jVi;
  private WalletFormView jVj;
  private RelativeLayout jVk;
  private TextView jVl;
  private RelativeLayout jVm;
  private TextView jVn;
  private TextView jVo;
  protected double jVp;
  private String jVq;
  private String jVr;
  private String jVs;
  private String jVt;
  private long jVu;
  private String jVv;
  private com.tencent.mm.plugin.aa.model.b.g jVw;
  private Runnable jVx;
  protected String mDesc;
  private int state;
  
  public AARemittanceUI()
  {
    AppMethodBeat.i(212988);
    this.mDesc = "";
    this.jUV = null;
    this.jVw = ((com.tencent.mm.plugin.aa.model.b.g)aq(com.tencent.mm.plugin.aa.model.b.g.class));
    this.state = 0;
    this.jVx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212966);
        if ((AARemittanceUI.m(AARemittanceUI.this) == 2) && (AARemittanceUI.this.isHandleAutoShowNormalStWcKb())) {
          AARemittanceUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(212966);
      }
    };
    AppMethodBeat.o(212988);
  }
  
  private void bmw()
  {
    AppMethodBeat.i(212991);
    if (Util.isNullOrNil(this.mDesc))
    {
      str1 = getString(2131755073);
      f.a(this.jVo, str1, 0, str1.length(), new e(new e.a()
      {
        public final void bmr()
        {
          AppMethodBeat.i(212962);
          AARemittanceUI.a(AARemittanceUI.this);
          AppMethodBeat.o(212962);
        }
      }), getContext());
      this.jVo.setVisibility(0);
      this.jVn.setVisibility(8);
      AppMethodBeat.o(212991);
      return;
    }
    String str1 = getString(2131763841);
    String str2 = getString(2131757673, new Object[] { this.mDesc, str1 });
    SpannableString localSpannableString = l.c(this, str2);
    f.a(this.jVn, str2, localSpannableString.length() - str1.length(), localSpannableString.length(), new e(new e.a()
    {
      public final void bmr()
      {
        AppMethodBeat.i(212978);
        AARemittanceUI.a(AARemittanceUI.this);
        AppMethodBeat.o(212978);
      }
    }), getContext());
    this.jVn.setVisibility(0);
    this.jVo.setVisibility(8);
    AppMethodBeat.o(212991);
  }
  
  private void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(213000);
    this.jVg.DH(paramBoolean);
    AppMethodBeat.o(213000);
  }
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(213001);
    if (paramInt == -1)
    {
      Log.i("MicroMsg.AARemittanceUI", "pay success, payMsgId: %s", new Object[] { this.dXh });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Log.i("MicroMsg.AARemittanceUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        com.tencent.mm.br.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      com.tencent.mm.plugin.aa.model.i.SB(this.jVv);
      setResult(-1);
      finish();
      this.jVw.jUm.w(this.dXh, this.jVq, this.jVt).f(new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.jVw.jUn.b(this.jVu, this.dFw, paramIntent);
      AppMethodBeat.o(213001);
      return;
    }
    hideLoading();
    AppMethodBeat.o(213001);
  }
  
  public int getLayoutId()
  {
    return 2131492905;
  }
  
  public void hideLoading()
  {
    AppMethodBeat.i(213002);
    if ((this.jUV != null) && (this.jUV.isShowing()))
    {
      this.jUV.dismiss();
      this.jUV = null;
    }
    AppMethodBeat.o(213002);
  }
  
  public void initView()
  {
    AppMethodBeat.i(212990);
    super.initView();
    this.jVf = ((ScrollView)findViewById(2131307173));
    this.jVg = ((WcPayKeyboard)findViewById(2131310544));
    this.jVh = ((TextView)findViewById(2131296311));
    this.jVi = ((ImageView)findViewById(2131296308));
    this.jVj = ((WalletFormView)findViewById(2131296310));
    this.jVk = ((RelativeLayout)findViewById(2131310214));
    this.jVl = ((TextView)findViewById(2131310217));
    this.jVm = ((RelativeLayout)findViewById(2131310212));
    final int i = getIntent().getIntExtra("amount_remind_bit", 4);
    if ((LocaleUtil.getApplicationLanguage().equals("zh_CN")) || (LocaleUtil.getApplicationLanguage().equals("zh_TW")) || (LocaleUtil.getApplicationLanguage().equals("zh_HK")))
    {
      this.jVk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(212964);
          AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.i(AARemittanceUI.this).getWidth());
          AARemittanceUI.j(AARemittanceUI.this).setVisibility(8);
          Log.d("MicroMsg.AARemittanceUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(AARemittanceUI.k(AARemittanceUI.this)) });
          AppMethodBeat.o(212964);
        }
      });
      this.jVj.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(212965);
          if (Util.isEqual(i, 0))
          {
            Log.i("MicroMsg.AARemittanceUI", "mAmountRemindBit == 0");
            AARemittanceUI.j(AARemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(212965);
            return;
          }
          long l = Double.valueOf(Util.getDouble(paramAnonymousCharSequence.toString(), 0.0D)).longValue();
          int j = 0;
          int i = 0;
          while (l != 0L)
          {
            j = (int)(l % 10L);
            l /= 10L;
            i += 1;
          }
          if (i >= i)
          {
            j = AARemittanceUI.f(AARemittanceUI.this).k(paramAnonymousCharSequence, AARemittanceUI.k(AARemittanceUI.this), j);
            if (j != 0)
            {
              AARemittanceUI.j(AARemittanceUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.aR(MMApplicationContext.getContext(), i);
              AARemittanceUI.l(AARemittanceUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)AARemittanceUI.i(AARemittanceUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              AARemittanceUI.i(AARemittanceUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(212965);
              return;
            }
            AARemittanceUI.j(AARemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(212965);
            return;
          }
          AARemittanceUI.j(AARemittanceUI.this).setVisibility(8);
          AppMethodBeat.o(212965);
        }
      });
    }
    Object localObject;
    for (;;)
    {
      this.jVg.fEW();
      this.jVg.setActionText(getString(2131755072));
      ((RelativeLayout.LayoutParams)this.jVg.getLayoutParams()).addRule(12);
      gf(false);
      setWPKeyboard(this.jVj.getContentEt(), true, false);
      this.jVj.setmContentAbnormalMoneyCheck(true);
      this.jVj.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(212963);
          AARemittanceUI.f(AARemittanceUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(212963);
        }
      });
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212985);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/AARemittanceUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          AARemittanceUI.this.jVp = Util.getDouble(AARemittanceUI.f(AARemittanceUI.this).getText(), 0.0D);
          if (!AARemittanceUI.f(AARemittanceUI.this).bql()) {
            AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(2131767474));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AARemittanceUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212985);
            return;
            if (AARemittanceUI.this.jVp < 0.01D)
            {
              AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(2131764485));
            }
            else
            {
              AARemittanceUI.this.hideWcKb();
              AARemittanceUI.g(AARemittanceUI.this);
            }
          }
        }
      };
      this.jVj.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(212986);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (AARemittanceUI.h(AARemittanceUI.this).isShown()))
          {
            Log.i("MicroMsg.AARemittanceUI", "click pay");
            this.jVJ.onClick(null);
            AppMethodBeat.o(212986);
            return true;
          }
          AppMethodBeat.o(212986);
          return true;
        }
      });
      this.jVj.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(212987);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!AARemittanceUI.f(AARemittanceUI.this).bql()) || (d < 0.01D))
          {
            AARemittanceUI.a(AARemittanceUI.this, false);
            AppMethodBeat.o(212987);
            return;
          }
          AARemittanceUI.a(AARemittanceUI.this, true);
          AppMethodBeat.o(212987);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.jVj.hib();
      this.jVn = ((TextView)findViewById(2131306869));
      this.jVo = ((TextView)findViewById(2131296537));
      bmw();
      setMMTitle("");
      hideActionbarLine();
      this.jVf.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(212984);
          if ((AARemittanceUI.c(AARemittanceUI.this).isShown()) && (AARemittanceUI.d(AARemittanceUI.this).hgP()))
          {
            AARemittanceUI.e(AARemittanceUI.this).hgN();
            AppMethodBeat.o(212984);
            return true;
          }
          AppMethodBeat.o(212984);
          return false;
        }
      });
      a.b.c(this.jVi, this.jVq);
      localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.jVq);
      String str = getString(2131763115, new Object[] { this.jVr });
      this.jVh.setText((String)localObject + str);
      localObject = (ImageView)findViewById(2131310211);
      if (!ao.isDarkMode()) {
        break;
      }
      findViewById(2131310216).setVisibility(8);
      findViewById(2131310213).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131235634);
      AppMethodBeat.o(212990);
      return;
      this.jVm.setVisibility(8);
    }
    findViewById(2131310216).setVisibility(0);
    findViewById(2131310213).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(2131235633);
    AppMethodBeat.o(212990);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(212995);
    boolean bool = this.jVg.hgR();
    AppMethodBeat.o(212995);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212999);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 233)
    {
      b(paramInt2, paramIntent);
      AppMethodBeat.o(212999);
      return;
    }
    if ((paramInt1 == 222) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      Log.i("MicroMsg.AARemittanceUI", "select chatroom：%s", new Object[] { paramIntent });
      if (!Util.isNullOrNil(paramIntent))
      {
        Intent localIntent = new Intent(getContext(), LaunchAAUI.class);
        localIntent.putExtra("enter_scene", 3);
        localIntent.putExtra("chatroom_name", paramIntent);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/aa/ui/AARemittanceUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AARemittanceUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(212999);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212989);
    super.onCreate(paramBundle);
    this.jVq = getIntent().getStringExtra("user_name");
    this.jVr = getIntent().getStringExtra("user_real_name");
    this.jVv = getIntent().getStringExtra("chatroom");
    initView();
    addSceneEndListener(2878);
    this.state = 1;
    AppMethodBeat.o(212989);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(212997);
    super.onDestroy();
    removeSceneEndListener(2878);
    AppMethodBeat.o(212997);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(212994);
    Log.i("MicroMsg.AARemittanceUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    AppMethodBeat.o(212994);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(212996);
    if ((this.jVg != null) && (this.jVg.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(212996);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(212996);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(212993);
    super.onPause();
    Log.i("MicroMsg.AARemittanceUI", "onPause()");
    if (!this.jVg.hgQ()) {
      this.state = 3;
    }
    AppMethodBeat.o(212993);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(212992);
    super.onResume();
    Log.i("MicroMsg.AARemittanceUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(212992);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(212998);
    Log.i("MicroMsg.AARemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    AppMethodBeat.o(212998);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AARemittanceUI
 * JD-Core Version:    0.7.0.1
 */