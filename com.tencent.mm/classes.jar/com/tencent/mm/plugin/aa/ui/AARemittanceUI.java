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
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.aa.model.b.g.c;
import com.tencent.mm.plugin.aa.model.b.g.e;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;

public class AARemittanceUI
  extends BaseAAPresenterActivity
{
  private String fQT;
  private String fyd;
  protected String mDesc;
  private TextView mMA;
  private TextView mMB;
  protected double mMC;
  private String mMD;
  private String mME;
  private String mMF;
  private String mMG;
  private long mMH;
  private String mMI;
  private com.tencent.mm.plugin.aa.model.b.g mMJ;
  private Runnable mMK;
  private Dialog mMi;
  private int mMr;
  protected ScrollView mMs;
  private WcPayKeyboard mMt;
  private TextView mMu;
  private ImageView mMv;
  private WalletFormView mMw;
  private RelativeLayout mMx;
  private TextView mMy;
  private RelativeLayout mMz;
  private int state;
  
  public AARemittanceUI()
  {
    AppMethodBeat.i(267753);
    this.mDesc = "";
    this.mMi = null;
    this.mMJ = ((com.tencent.mm.plugin.aa.model.b.g)ap(com.tencent.mm.plugin.aa.model.b.g.class));
    this.state = 0;
    this.mMK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(228068);
        if ((AARemittanceUI.m(AARemittanceUI.this) == 2) && (AARemittanceUI.this.isHandleAutoShowNormalStWcKb())) {
          AARemittanceUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(228068);
      }
    };
    AppMethodBeat.o(267753);
  }
  
  private void bwE()
  {
    AppMethodBeat.i(267757);
    if (Util.isNullOrNil(this.mDesc))
    {
      str1 = getString(a.i.aa_remittance_ui_desc);
      com.tencent.mm.wallet_core.ui.g.a(this.mMB, str1, 0, str1.length(), new f(new f.a()
      {
        public final void bwz()
        {
          AppMethodBeat.i(224723);
          AARemittanceUI.a(AARemittanceUI.this);
          AppMethodBeat.o(224723);
        }
      }), getContext());
      this.mMB.setVisibility(0);
      this.mMA.setVisibility(8);
      AppMethodBeat.o(267757);
      return;
    }
    String str1 = getString(a.i.paylist_aa_instant_desc);
    String str2 = getString(a.i.collect_main_add_desc_title_changed, new Object[] { this.mDesc, str1 });
    SpannableString localSpannableString = l.c(this, str2);
    com.tencent.mm.wallet_core.ui.g.a(this.mMA, str2, localSpannableString.length() - str1.length(), localSpannableString.length(), new f(new f.a()
    {
      public final void bwz()
      {
        AppMethodBeat.i(277535);
        AARemittanceUI.a(AARemittanceUI.this);
        AppMethodBeat.o(277535);
      }
    }), getContext());
    this.mMA.setVisibility(0);
    this.mMB.setVisibility(8);
    AppMethodBeat.o(267757);
  }
  
  private void gR(boolean paramBoolean)
  {
    AppMethodBeat.i(267766);
    this.mMt.Ih(paramBoolean);
    AppMethodBeat.o(267766);
  }
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(267767);
    if (paramInt == -1)
    {
      Log.i("MicroMsg.AARemittanceUI", "pay success, payMsgId: %s", new Object[] { this.fQT });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Log.i("MicroMsg.AARemittanceUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        com.tencent.mm.by.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      com.tencent.mm.plugin.aa.model.i.aah(this.mMI);
      setResult(-1);
      finish();
      this.mMJ.mLz.z(this.fQT, this.mMD, this.mMG).f(new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.mMJ.mLA.b(this.mMH, this.fyd, paramIntent);
      AppMethodBeat.o(267767);
      return;
    }
    hideLoading();
    AppMethodBeat.o(267767);
  }
  
  public int getLayoutId()
  {
    return a.g.aa_remittance_ui;
  }
  
  public void hideLoading()
  {
    AppMethodBeat.i(267768);
    if ((this.mMi != null) && (this.mMi.isShowing()))
    {
      this.mMi.dismiss();
      this.mMi = null;
    }
    AppMethodBeat.o(267768);
  }
  
  public void initView()
  {
    AppMethodBeat.i(267756);
    super.initView();
    this.mMs = ((ScrollView)findViewById(a.f.root_view));
    this.mMt = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.mMu = ((TextView)findViewById(a.f.aa_remit_name));
    this.mMv = ((ImageView)findViewById(a.f.aa_remit_logo));
    this.mMw = ((WalletFormView)findViewById(a.f.aa_remit_money_et));
    this.mMx = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
    this.mMy = ((TextView)findViewById(a.f.wallet_max_unit_tv));
    this.mMz = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
    final int i = getIntent().getIntExtra("amount_remind_bit", 4);
    if ((LocaleUtil.getApplicationLanguage().equals("zh_CN")) || (LocaleUtil.getApplicationLanguage().equals("zh_TW")) || (LocaleUtil.getApplicationLanguage().equals("zh_HK")))
    {
      this.mMx.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(257137);
          AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.i(AARemittanceUI.this).getWidth());
          AARemittanceUI.j(AARemittanceUI.this).setVisibility(8);
          Log.d("MicroMsg.AARemittanceUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(AARemittanceUI.k(AARemittanceUI.this)) });
          AppMethodBeat.o(257137);
        }
      });
      this.mMw.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void f(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(268693);
          if (Util.isEqual(i, 0))
          {
            Log.i("MicroMsg.AARemittanceUI", "mAmountRemindBit == 0");
            AARemittanceUI.j(AARemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(268693);
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
              paramAnonymousCharSequence = ag.bk(MMApplicationContext.getContext(), i);
              AARemittanceUI.l(AARemittanceUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)AARemittanceUI.i(AARemittanceUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              AARemittanceUI.i(AARemittanceUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(268693);
              return;
            }
            AARemittanceUI.j(AARemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(268693);
            return;
          }
          AARemittanceUI.j(AARemittanceUI.this).setVisibility(8);
          AppMethodBeat.o(268693);
        }
      });
    }
    Object localObject;
    for (;;)
    {
      this.mMt.gxi();
      this.mMt.setActionText(getString(a.i.aa_remittance_ui_click));
      ((RelativeLayout.LayoutParams)this.mMt.getLayoutParams()).addRule(12);
      gR(false);
      setWPKeyboard(this.mMw.getContentEt(), true, false);
      this.mMw.setmContentAbnormalMoneyCheck(true);
      this.mMw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(276475);
          AARemittanceUI.f(AARemittanceUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(276475);
        }
      });
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(264117);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/AARemittanceUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          AARemittanceUI.this.mMC = Util.getDouble(AARemittanceUI.f(AARemittanceUI.this).getText(), 0.0D);
          if (!AARemittanceUI.f(AARemittanceUI.this).bAz()) {
            AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(a.i.wallet_balance_save_input_invalid));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AARemittanceUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(264117);
            return;
            if (AARemittanceUI.this.mMC < 0.01D)
            {
              AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(a.i.remittance_amount_lowest_limit));
            }
            else
            {
              AARemittanceUI.this.hideWcKb();
              AARemittanceUI.g(AARemittanceUI.this);
            }
          }
        }
      };
      this.mMw.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(278130);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (AARemittanceUI.h(AARemittanceUI.this).isShown()))
          {
            Log.i("MicroMsg.AARemittanceUI", "click pay");
            this.mMW.onClick(null);
            AppMethodBeat.o(278130);
            return true;
          }
          AppMethodBeat.o(278130);
          return true;
        }
      });
      this.mMw.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(266181);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!AARemittanceUI.f(AARemittanceUI.this).bAz()) || (d < 0.01D))
          {
            AARemittanceUI.a(AARemittanceUI.this, false);
            AppMethodBeat.o(266181);
            return;
          }
          AARemittanceUI.a(AARemittanceUI.this, true);
          AppMethodBeat.o(266181);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.mMw.ijD();
      this.mMA = ((TextView)findViewById(a.f.remittance_desc));
      this.mMB = ((TextView)findViewById(a.f.add_remittance_desc));
      bwE();
      setMMTitle("");
      hideActionbarLine();
      this.mMs.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(277754);
          if ((AARemittanceUI.c(AARemittanceUI.this).isShown()) && (AARemittanceUI.d(AARemittanceUI.this).iir()))
          {
            AARemittanceUI.e(AARemittanceUI.this).iip();
            AppMethodBeat.o(277754);
            return true;
          }
          AppMethodBeat.o(277754);
          return false;
        }
      });
      a.b.c(this.mMv, this.mMD);
      localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(this.mMD);
      String str = getString(a.i.mobile_remit_verify_name_desc2, new Object[] { this.mME });
      this.mMu.setText((String)localObject + str);
      localObject = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (!ar.isDarkMode()) {
        break;
      }
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
      AppMethodBeat.o(267756);
      return;
      this.mMz.setVisibility(8);
    }
    findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
    findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line);
    AppMethodBeat.o(267756);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(267761);
    boolean bool = this.mMt.iit();
    AppMethodBeat.o(267761);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(267765);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 233)
    {
      b(paramInt2, paramIntent);
      AppMethodBeat.o(267765);
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
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/plugin/aa/ui/AARemittanceUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/aa/ui/AARemittanceUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(267765);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(267754);
    super.onCreate(paramBundle);
    this.mMD = getIntent().getStringExtra("user_name");
    this.mME = getIntent().getStringExtra("user_real_name");
    this.mMI = getIntent().getStringExtra("chatroom");
    initView();
    addSceneEndListener(2878);
    this.state = 1;
    AppMethodBeat.o(267754);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(267763);
    super.onDestroy();
    removeSceneEndListener(2878);
    AppMethodBeat.o(267763);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(267760);
    Log.i("MicroMsg.AARemittanceUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
    AppMethodBeat.o(267760);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(267762);
    if ((this.mMt != null) && (this.mMt.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(267762);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(267762);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(267759);
    super.onPause();
    Log.i("MicroMsg.AARemittanceUI", "onPause()");
    if (!this.mMt.iis()) {
      this.state = 3;
    }
    AppMethodBeat.o(267759);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(267758);
    super.onResume();
    Log.i("MicroMsg.AARemittanceUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(267758);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(267764);
    Log.i("MicroMsg.AARemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    AppMethodBeat.o(267764);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AARemittanceUI
 * JD-Core Version:    0.7.0.1
 */