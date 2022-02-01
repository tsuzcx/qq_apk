package com.tencent.mm.plugin.aa.ui;

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
import com.tencent.mm.plugin.aa.model.b.g;
import com.tencent.mm.plugin.aa.model.b.g.e;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.l;
import java.util.HashSet;

public class AARemittanceUI
  extends BaseAAPresenterActivity
{
  private String hCI;
  private String hWQ;
  protected String mDesc;
  private Dialog pIQ;
  private int pIZ;
  protected ScrollView pJa;
  private WcPayKeyboard pJb;
  private TextView pJc;
  private ImageView pJd;
  private WalletFormView pJe;
  private RelativeLayout pJf;
  private TextView pJg;
  private RelativeLayout pJh;
  private TextView pJi;
  private TextView pJj;
  protected double pJk;
  private String pJl;
  private String pJm;
  private String pJn;
  private String pJo;
  private long pJp;
  private String pJq;
  private g pJr;
  private Runnable pJs;
  private int state;
  
  public AARemittanceUI()
  {
    AppMethodBeat.i(268487);
    this.mDesc = "";
    this.pIQ = null;
    this.pJr = ((g)aI(g.class));
    this.state = 0;
    this.pJs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268489);
        if ((AARemittanceUI.j(AARemittanceUI.this) == 2) && (AARemittanceUI.this.isHandleAutoShowNormalStWcKb())) {
          AARemittanceUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(268489);
      }
    };
    AppMethodBeat.o(268487);
  }
  
  private void bVu()
  {
    AppMethodBeat.i(268490);
    if (Util.isNullOrNil(this.mDesc))
    {
      str1 = getString(a.i.aa_remittance_ui_desc);
      com.tencent.mm.wallet_core.ui.i.a(this.pJj, str1, 0, str1.length(), new f(new f.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268481);
          AARemittanceUI.a(AARemittanceUI.this);
          AppMethodBeat.o(268481);
        }
      }), getContext());
      this.pJj.setVisibility(0);
      this.pJi.setVisibility(8);
      AppMethodBeat.o(268490);
      return;
    }
    String str1 = getString(a.i.paylist_aa_instant_desc);
    String str2 = getString(a.i.collect_main_add_desc_title_changed, new Object[] { this.mDesc, str1 });
    SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.p.b(this, str2);
    com.tencent.mm.wallet_core.ui.i.a(this.pJi, str2, localSpannableString.length() - str1.length(), localSpannableString.length(), new f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268427);
        AARemittanceUI.a(AARemittanceUI.this);
        AppMethodBeat.o(268427);
      }
    }), getContext());
    this.pJi.setVisibility(0);
    this.pJj.setVisibility(8);
    AppMethodBeat.o(268490);
  }
  
  private void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(268496);
    this.pJb.Oi(paramBoolean);
    AppMethodBeat.o(268496);
  }
  
  public final void c(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(268583);
    if (paramInt == -1)
    {
      Log.i("MicroMsg.AARemittanceUI", "pay success, payMsgId: %s", new Object[] { this.hWQ });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        Log.i("MicroMsg.AARemittanceUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        com.tencent.mm.br.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      j.SB(this.pJq);
      setResult(-1);
      finish();
      this.pJr.pIh.C(this.hWQ, this.pJl, this.pJo).f(new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.pJr.pIi.b(this.pJp, this.hCI, paramIntent);
      AppMethodBeat.o(268583);
      return;
    }
    hideLoading();
    AppMethodBeat.o(268583);
  }
  
  public int getLayoutId()
  {
    return a.g.aa_remittance_ui;
  }
  
  public void hideLoading()
  {
    AppMethodBeat.i(268586);
    if ((this.pIQ != null) && (this.pIQ.isShowing()))
    {
      this.pIQ.dismiss();
      this.pIQ = null;
    }
    AppMethodBeat.o(268586);
  }
  
  public void initView()
  {
    AppMethodBeat.i(268551);
    super.initView();
    this.pJa = ((ScrollView)findViewById(a.f.root_view));
    this.pJb = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    this.pJc = ((TextView)findViewById(a.f.aa_remit_name));
    this.pJd = ((ImageView)findViewById(a.f.aa_remit_logo));
    this.pJe = ((WalletFormView)findViewById(a.f.aa_remit_money_et));
    this.pJf = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
    this.pJg = ((TextView)findViewById(a.f.wallet_max_unit_tv));
    this.pJh = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
    final int i = getIntent().getIntExtra("amount_remind_bit", 4);
    if ((LocaleUtil.getApplicationLanguage().equals("zh_CN")) || (LocaleUtil.getApplicationLanguage().equals("zh_TW")) || (LocaleUtil.getApplicationLanguage().equals("zh_HK")))
    {
      this.pJf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268486);
          AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.f(AARemittanceUI.this).getWidth());
          AARemittanceUI.g(AARemittanceUI.this).setVisibility(8);
          Log.d("MicroMsg.AARemittanceUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(AARemittanceUI.h(AARemittanceUI.this)) });
          AppMethodBeat.o(268486);
        }
      });
      this.pJe.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void f(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(268492);
          if (Util.isEqual(i, 0))
          {
            Log.i("MicroMsg.AARemittanceUI", "mAmountRemindBit == 0");
            AARemittanceUI.g(AARemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(268492);
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
            j = AARemittanceUI.c(AARemittanceUI.this).i(paramAnonymousCharSequence, AARemittanceUI.h(AARemittanceUI.this), j);
            if (j != 0)
            {
              AARemittanceUI.g(AARemittanceUI.this).setVisibility(0);
              paramAnonymousCharSequence = ah.bD(MMApplicationContext.getContext(), i);
              AARemittanceUI.i(AARemittanceUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)AARemittanceUI.f(AARemittanceUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              AARemittanceUI.f(AARemittanceUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(268492);
              return;
            }
            AARemittanceUI.g(AARemittanceUI.this).setVisibility(8);
            AppMethodBeat.o(268492);
            return;
          }
          AARemittanceUI.g(AARemittanceUI.this).setVisibility(8);
          AppMethodBeat.o(268492);
        }
      });
    }
    Object localObject;
    for (;;)
    {
      this.pJb.hVf();
      this.pJb.setActionText(getString(a.i.aa_remittance_ui_click));
      ((RelativeLayout.LayoutParams)this.pJb.getLayoutParams()).addRule(12);
      hH(false);
      setWPKeyboard(this.pJe.getContentEt(), true, false);
      this.pJe.setmContentAbnormalMoneyCheck(true);
      this.pJe.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268484);
          AARemittanceUI.c(AARemittanceUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(268484);
        }
      });
      localObject = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(268602);
          AARemittanceUI.this.pJk = Util.getDouble(AARemittanceUI.c(AARemittanceUI.this).getText(), 0.0D);
          if (!AARemittanceUI.c(AARemittanceUI.this).bZp())
          {
            AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(a.i.wallet_balance_save_input_invalid));
            AppMethodBeat.o(268602);
            return;
          }
          if (AARemittanceUI.this.pJk < 0.01D)
          {
            AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(a.i.remittance_amount_lowest_limit));
            AppMethodBeat.o(268602);
            return;
          }
          AARemittanceUI.this.hideWcKb();
          AARemittanceUI.d(AARemittanceUI.this);
          AppMethodBeat.o(268602);
        }
      };
      this.pJe.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(268609);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (AARemittanceUI.e(AARemittanceUI.this).isShown()))
          {
            Log.i("MicroMsg.AARemittanceUI", "click pay");
            this.pJE.onClick(null);
            AppMethodBeat.o(268609);
            return true;
          }
          AppMethodBeat.o(268609);
          return true;
        }
      });
      this.pJe.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(268614);
          paramAnonymousEditable = paramAnonymousEditable.toString();
          double d = Util.getDouble(paramAnonymousEditable, 0.0D);
          if ((!AARemittanceUI.c(AARemittanceUI.this).bZp()) || (d < 0.01D))
          {
            AARemittanceUI.a(AARemittanceUI.this, false);
            paramAnonymousEditable = com.tencent.mm.ui.component.k.aeZF;
            ((com.tencent.mm.plugin.aa.model.a)com.tencent.mm.ui.component.k.d(AARemittanceUI.this.getContext()).q(com.tencent.mm.plugin.aa.model.a.class)).setValue("REMITTANCE_AA_MONEY_EDIT_FORM_VALUE_KEY", "");
            AppMethodBeat.o(268614);
            return;
          }
          AARemittanceUI.a(AARemittanceUI.this, true);
          com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.aa.model.a)com.tencent.mm.ui.component.k.d(AARemittanceUI.this.getContext()).q(com.tencent.mm.plugin.aa.model.a.class)).setValue("REMITTANCE_AA_MONEY_EDIT_FORM_VALUE_KEY", "¥".concat(String.valueOf(paramAnonymousEditable)));
          AppMethodBeat.o(268614);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.pJe.jPD();
      this.pJi = ((TextView)findViewById(a.f.remittance_desc));
      this.pJj = ((TextView)findViewById(a.f.add_remittance_desc));
      bVu();
      setMMTitle("");
      hideActionbarLine();
      this.pJa.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(268580);
          AARemittanceUI.this.handleKeyboardTouchEvent(paramAnonymousMotionEvent);
          AppMethodBeat.o(268580);
          return false;
        }
      });
      a.b.g(this.pJd, this.pJl);
      localObject = ((b)com.tencent.mm.kernel.h.ax(b.class)).getDisplayName(this.pJl);
      String str = getString(a.i.mobile_remit_verify_name_desc2, new Object[] { this.pJm });
      this.pJc.setText((String)localObject + str);
      localObject = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (!aw.isDarkMode()) {
        break;
      }
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
      AppMethodBeat.o(268551);
      return;
      this.pJh.setVisibility(8);
    }
    findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
    findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line);
    AppMethodBeat.o(268551);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(268564);
    boolean bool = this.pJb.jOo();
    AppMethodBeat.o(268564);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(268577);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 233)
    {
      c(paramInt2, paramIntent);
      AppMethodBeat.o(268577);
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
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/aa/ui/AARemittanceUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/aa/ui/AARemittanceUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(268577);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(268544);
    super.onCreate(paramBundle);
    this.pJl = getIntent().getStringExtra("user_name");
    this.pJm = getIntent().getStringExtra("user_real_name");
    this.pJq = getIntent().getStringExtra("chatroom");
    initView();
    addSceneEndListener(2878);
    this.state = 1;
    AppMethodBeat.o(268544);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(268573);
    super.onDestroy();
    removeSceneEndListener(2878);
    AppMethodBeat.o(268573);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(268561);
    Log.i("MicroMsg.AARemittanceUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
    AppMethodBeat.o(268561);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(268567);
    if ((this.pJb != null) && (this.pJb.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(268567);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(268567);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(268555);
    super.onPause();
    Log.i("MicroMsg.AARemittanceUI", "onPause()");
    if (!this.pJb.jOn()) {
      this.state = 3;
    }
    AppMethodBeat.o(268555);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(268552);
    super.onResume();
    Log.i("MicroMsg.AARemittanceUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(268552);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(268575);
    Log.i("MicroMsg.AARemittanceUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    AppMethodBeat.o(268575);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(268545);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.aa.model.a.class);
    AppMethodBeat.o(268545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AARemittanceUI
 * JD-Core Version:    0.7.0.1
 */