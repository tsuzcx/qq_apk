package com.tencent.mm.plugin.collect.ui;

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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.o;
import com.tencent.mm.plugin.collect.model.u;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;
import com.tencent.mm.wallet_core.ui.g;

public class CollectCreateQRCodeNewUI
  extends WalletBaseUI
{
  private String mDesc;
  private TextView mMA;
  private Runnable mMK;
  private int mMr;
  protected ScrollView mMs;
  private WcPayKeyboard mMt;
  private RelativeLayout mMx;
  private TextView mMy;
  private RelativeLayout mMz;
  private int state;
  private WalletFormView tZh;
  private TextView tZi;
  private RelativeLayout tZj;
  
  public CollectCreateQRCodeNewUI()
  {
    AppMethodBeat.i(225014);
    this.mDesc = "";
    this.state = 0;
    this.mMK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271259);
        if ((CollectCreateQRCodeNewUI.m(CollectCreateQRCodeNewUI.this) == 2) && (CollectCreateQRCodeNewUI.n(CollectCreateQRCodeNewUI.this))) {
          CollectCreateQRCodeNewUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(271259);
      }
    };
    AppMethodBeat.o(225014);
  }
  
  private void bwE()
  {
    AppMethodBeat.i(225056);
    if (!Util.isNullOrNil(this.mDesc))
    {
      str = getString(a.i.collect_main_add_desc_title_simple_change);
      SpannableString localSpannableString = l.c(this, getString(a.i.collect_main_add_desc_title_changed, new Object[] { this.mDesc, str }));
      g.a(this.mMA, localSpannableString.toString(), localSpannableString.length() - str.length(), localSpannableString.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void bwz()
        {
          AppMethodBeat.i(271174);
          CollectCreateQRCodeNewUI.k(CollectCreateQRCodeNewUI.this);
          AppMethodBeat.o(271174);
        }
      }), getContext());
      this.tZi.setVisibility(8);
      this.mMA.setVisibility(0);
      AppMethodBeat.o(225056);
      return;
    }
    String str = getString(a.i.collect_main_add_desc_title);
    g.a(this.tZi, str, 0, str.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void bwz()
      {
        AppMethodBeat.i(207748);
        CollectCreateQRCodeNewUI.k(CollectCreateQRCodeNewUI.this);
        AppMethodBeat.o(207748);
      }
    }), getContext());
    this.tZi.setVisibility(0);
    this.mMA.setVisibility(8);
    AppMethodBeat.o(225056);
  }
  
  private void gR(boolean paramBoolean)
  {
    AppMethodBeat.i(225057);
    this.mMt.Ih(paramBoolean);
    AppMethodBeat.o(225057);
  }
  
  public int getLayoutId()
  {
    return a.g.collect_create_qrcode_new;
  }
  
  public void initView()
  {
    AppMethodBeat.i(225035);
    this.tZh = ((WalletFormView)findViewById(a.f.money_ev));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.tZh);
    Object localObject = getIntent().getStringExtra("key_currency_unit");
    if (!Util.isNullOrNil((String)localObject))
    {
      this.tZh.getTitleTv().setText((CharSequence)localObject);
      this.tZh.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(275046);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).bAz()) || (d < 0.01D))
          {
            CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, false);
            AppMethodBeat.o(275046);
            return;
          }
          CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, true);
          AppMethodBeat.o(275046);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.tZh.ijD();
      this.mMA = ((TextView)findViewById(a.f.collect_main_desc));
      this.tZi = ((TextView)findViewById(a.f.collect_main_add_desc));
      bwE();
      this.mMt = ((WcPayKeyboard)findViewById(a.f.wp_kb));
      this.mMt.gxi();
      this.mMt.setActionText(getString(a.i.collect_create_qrcode_gen_btn));
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(245596);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          double d = Util.getDouble(CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).getText(), 0.0D);
          com.tencent.mm.kernel.h.aHH();
          int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.CollectCreateQRCodeNewUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).bAz()) {
            CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.this.getString(a.i.wallet_balance_save_input_invalid));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245596);
            return;
            if (d < 0.01D) {
              CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.this.getString(a.i.remittance_amount_lowest_limit));
            } else if (i == 8) {
              CollectCreateQRCodeNewUI.this.doSceneForceProgress(new o(Math.round(d * 100.0D), CollectCreateQRCodeNewUI.f(CollectCreateQRCodeNewUI.this), z.bdg()));
            } else {
              CollectCreateQRCodeNewUI.this.doSceneProgress(new u(d, "1", CollectCreateQRCodeNewUI.f(CollectCreateQRCodeNewUI.this)));
            }
          }
        }
      };
      this.tZh.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(198073);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (CollectCreateQRCodeNewUI.g(CollectCreateQRCodeNewUI.this).isShown()))
          {
            Log.i("MicroMsg.CollectCreateQRCodeNewUI", "click enter");
            this.mMW.onClick(null);
            AppMethodBeat.o(198073);
            return true;
          }
          AppMethodBeat.o(198073);
          return true;
        }
      });
      ((RelativeLayout.LayoutParams)this.mMt.getLayoutParams()).addRule(12);
      gR(false);
      setWPKeyboard(this.tZh.getContentEt(), true, false);
      this.tZh.setmContentAbnormalMoneyCheck(true);
      this.tZh.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241190);
          CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(241190);
        }
      });
      this.mMx = ((RelativeLayout)findViewById(a.f.wallet_max_unit_layout));
      this.mMy = ((TextView)findViewById(a.f.wallet_max_unit_tv));
      this.mMz = ((RelativeLayout)findViewById(a.f.wallet_max_unit_container));
      this.tZj = ((RelativeLayout)findViewById(a.f.wallet_max_unit_line_container));
      final int i = getIntent().getIntExtra("amount_remind_bit", 10);
      if ((!LocaleUtil.getApplicationLanguage().equals("zh_CN")) && (!LocaleUtil.getApplicationLanguage().equals("zh_TW")) && (!LocaleUtil.getApplicationLanguage().equals("zh_HK"))) {
        break label485;
      }
      this.mMx.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(244092);
          CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.b(CollectCreateQRCodeNewUI.this).getWidth());
          CollectCreateQRCodeNewUI.c(CollectCreateQRCodeNewUI.this).setVisibility(8);
          Log.d("MicroMsg.CollectCreateQRCodeNewUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(CollectCreateQRCodeNewUI.d(CollectCreateQRCodeNewUI.this)) });
          AppMethodBeat.o(244092);
        }
      });
      this.tZh.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void f(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(270384);
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
            j = CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).k(paramAnonymousCharSequence, CollectCreateQRCodeNewUI.d(CollectCreateQRCodeNewUI.this), j);
            if (j != 0)
            {
              CollectCreateQRCodeNewUI.c(CollectCreateQRCodeNewUI.this).setVisibility(0);
              paramAnonymousCharSequence = ag.bk(MMApplicationContext.getContext(), i);
              CollectCreateQRCodeNewUI.e(CollectCreateQRCodeNewUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)CollectCreateQRCodeNewUI.b(CollectCreateQRCodeNewUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              CollectCreateQRCodeNewUI.b(CollectCreateQRCodeNewUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(270384);
              return;
            }
            CollectCreateQRCodeNewUI.c(CollectCreateQRCodeNewUI.this).setVisibility(8);
            AppMethodBeat.o(270384);
            return;
          }
          CollectCreateQRCodeNewUI.c(CollectCreateQRCodeNewUI.this).setVisibility(8);
          AppMethodBeat.o(270384);
        }
      });
    }
    for (;;)
    {
      setMMTitle(a.i.collect_create_qrcode_title);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(275040);
          CollectCreateQRCodeNewUI.this.setResult(0);
          CollectCreateQRCodeNewUI.this.finish();
          AppMethodBeat.o(275040);
          return true;
        }
      });
      this.mMs = ((ScrollView)findViewById(a.f.root_view));
      this.mMs.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(268372);
          if ((CollectCreateQRCodeNewUI.h(CollectCreateQRCodeNewUI.this).isShown()) && (CollectCreateQRCodeNewUI.i(CollectCreateQRCodeNewUI.this).iir()))
          {
            CollectCreateQRCodeNewUI.j(CollectCreateQRCodeNewUI.this).iip();
            AppMethodBeat.o(268372);
            return true;
          }
          AppMethodBeat.o(268372);
          return false;
        }
      });
      localObject = (ImageView)findViewById(a.f.wallet_max_uni_heave_line_iv);
      if (!ar.isDarkMode()) {
        break label497;
      }
      findViewById(a.f.wallet_max_unit_line_iv).setVisibility(8);
      findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line_dark);
      AppMethodBeat.o(225035);
      return;
      this.tZh.getTitleTv().setText(ah.ijb());
      break;
      label485:
      this.mMz.setVisibility(8);
    }
    label497:
    findViewById(a.f.wallet_max_unit_line_iv).setVisibility(0);
    findViewById(a.f.wallet_max_unit_dark_line_iv).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(a.e.wallet_money_amount_remind_line);
    AppMethodBeat.o(225035);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(225015);
    super.onCreate(paramBundle);
    addSceneEndListener(1335);
    initView();
    AppMethodBeat.o(225015);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(225018);
    super.onDestroy();
    removeSceneEndListener(1335);
    AppMethodBeat.o(225018);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(225061);
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
    AppMethodBeat.o(225061);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(225059);
    super.onPause();
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onPause()");
    if (!this.mMt.iis()) {
      this.state = 3;
    }
    AppMethodBeat.o(225059);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(225058);
    super.onResume();
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(225058);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(225048);
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "errType: %s ，errCode：%s, errMsg：%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof u))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (u)paramq;
        paramq = new Intent();
        paramq.putExtra("ftf_pay_url", paramString.tVJ);
        paramq.putExtra("key_error_level", paramString.tVL);
        paramq.putExtra("ftf_fixed_fee", paramString.tVK);
        paramq.putExtra("ftf_fixed_fee_type", paramString.fyc);
        paramq.putExtra("ftf_fixed_desc", paramString.desc);
        setResult(-1, paramq);
        hideVKB();
        finish();
        AppMethodBeat.o(225048);
        return true;
      }
    }
    else if ((paramq instanceof o))
    {
      paramString = (o)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.fwx == 0)
        {
          paramq = new Intent();
          paramq.putExtra("ftf_pay_url", paramString.tVp);
          paramq.putExtra("ftf_fixed_fee", paramString.gbJ / 100.0D);
          paramq.putExtra("ftf_fixed_desc", paramString.desc);
          paramq.putExtra("key_currency_unit", paramString.tVy);
          setResult(-1, paramq);
          hideVKB();
          finish();
          AppMethodBeat.o(225048);
          return true;
        }
        if (paramString.tVq == 0)
        {
          com.tencent.mm.ui.base.h.c(getContext(), paramString.tVo, paramString.tVr, false);
          AppMethodBeat.o(225048);
          return true;
        }
        if (paramString.tVq == 1)
        {
          if ((!Util.isNullOrNil(paramString.tVs)) && (!Util.isNullOrNil(paramString.tVt))) {
            com.tencent.mm.ui.base.h.c(getContext(), paramString.tVo, paramString.tVr, paramString.tVt, paramString.tVs, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(273266);
                if (!Util.isNullOrNil(paramString.tVu))
                {
                  Log.i("MicroMsg.CollectCreateQRCodeNewUI", "goto h5: %s", new Object[] { paramString.tVu });
                  g.p(CollectCreateQRCodeNewUI.this.getContext(), paramString.tVu, true);
                }
                AppMethodBeat.o(273266);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
          AppMethodBeat.o(225048);
          return true;
        }
      }
      else
      {
        Log.e("MicroMsg.CollectCreateQRCodeNewUI", "net error: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(225048);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI
 * JD-Core Version:    0.7.0.1
 */