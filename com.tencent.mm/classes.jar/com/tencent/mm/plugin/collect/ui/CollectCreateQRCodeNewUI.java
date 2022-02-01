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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.n;
import com.tencent.mm.plugin.collect.model.t;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;

public class CollectCreateQRCodeNewUI
  extends WalletBaseUI
{
  private int jVe;
  protected ScrollView jVf;
  private WcPayKeyboard jVg;
  private RelativeLayout jVk;
  private TextView jVl;
  private RelativeLayout jVm;
  private TextView jVn;
  private Runnable jVx;
  private String mDesc;
  private WalletFormView qAh;
  private TextView qAi;
  private RelativeLayout qAj;
  private int state;
  
  public CollectCreateQRCodeNewUI()
  {
    AppMethodBeat.i(213180);
    this.mDesc = "";
    this.state = 0;
    this.jVx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213172);
        if ((CollectCreateQRCodeNewUI.m(CollectCreateQRCodeNewUI.this) == 2) && (CollectCreateQRCodeNewUI.n(CollectCreateQRCodeNewUI.this))) {
          CollectCreateQRCodeNewUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(213172);
      }
    };
    AppMethodBeat.o(213180);
  }
  
  private void bmw()
  {
    AppMethodBeat.i(213185);
    if (!Util.isNullOrNil(this.mDesc))
    {
      str = getString(2131757674);
      SpannableString localSpannableString = l.c(this, getString(2131757673, new Object[] { this.mDesc, str }));
      f.a(this.jVn, localSpannableString.toString(), localSpannableString.length() - str.length(), localSpannableString.length(), new com.tencent.mm.wallet_core.ui.e(new e.a()
      {
        public final void bmr()
        {
          AppMethodBeat.i(213164);
          CollectCreateQRCodeNewUI.k(CollectCreateQRCodeNewUI.this);
          AppMethodBeat.o(213164);
        }
      }), getContext());
      this.qAi.setVisibility(8);
      this.jVn.setVisibility(0);
      AppMethodBeat.o(213185);
      return;
    }
    String str = getString(2131757672);
    f.a(this.qAi, str, 0, str.length(), new com.tencent.mm.wallet_core.ui.e(new e.a()
    {
      public final void bmr()
      {
        AppMethodBeat.i(213165);
        CollectCreateQRCodeNewUI.k(CollectCreateQRCodeNewUI.this);
        AppMethodBeat.o(213165);
      }
    }), getContext());
    this.qAi.setVisibility(0);
    this.jVn.setVisibility(8);
    AppMethodBeat.o(213185);
  }
  
  private void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(213186);
    this.jVg.DH(paramBoolean);
    AppMethodBeat.o(213186);
  }
  
  public int getLayoutId()
  {
    return 2131493672;
  }
  
  public void initView()
  {
    AppMethodBeat.i(213183);
    this.qAh = ((WalletFormView)findViewById(2131304847));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.qAh);
    Object localObject = getIntent().getStringExtra("key_currency_unit");
    if (!Util.isNullOrNil((String)localObject))
    {
      this.qAh.getTitleTv().setText((CharSequence)localObject);
      this.qAh.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(213173);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).bql()) || (d < 0.01D))
          {
            CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, false);
            AppMethodBeat.o(213173);
            return;
          }
          CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, true);
          AppMethodBeat.o(213173);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.qAh.hib();
      this.jVn = ((TextView)findViewById(2131298863));
      this.qAi = ((TextView)findViewById(2131298862));
      bmw();
      this.jVg = ((WcPayKeyboard)findViewById(2131310544));
      this.jVg.fEW();
      this.jVg.setActionText(getString(2131757668));
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213176);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          double d = Util.getDouble(CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).getText(), 0.0D);
          g.aAi();
          int i = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.CollectCreateQRCodeNewUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).bql()) {
            CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.this.getString(2131767474));
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213176);
            return;
            if (d < 0.01D) {
              CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.this.getString(2131764485));
            } else if (i == 8) {
              CollectCreateQRCodeNewUI.this.doSceneForceProgress(new n(Math.round(d * 100.0D), CollectCreateQRCodeNewUI.f(CollectCreateQRCodeNewUI.this), z.aUf()));
            } else {
              CollectCreateQRCodeNewUI.this.doSceneProgress(new t(d, "1", CollectCreateQRCodeNewUI.f(CollectCreateQRCodeNewUI.this)));
            }
          }
        }
      };
      this.qAh.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(213177);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (CollectCreateQRCodeNewUI.g(CollectCreateQRCodeNewUI.this).isShown()))
          {
            Log.i("MicroMsg.CollectCreateQRCodeNewUI", "click enter");
            this.jVJ.onClick(null);
            AppMethodBeat.o(213177);
            return true;
          }
          AppMethodBeat.o(213177);
          return true;
        }
      });
      ((RelativeLayout.LayoutParams)this.jVg.getLayoutParams()).addRule(12);
      gf(false);
      setWPKeyboard(this.qAh.getContentEt(), true, false);
      this.qAh.setmContentAbnormalMoneyCheck(true);
      this.qAh.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213178);
          CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(213178);
        }
      });
      this.jVk = ((RelativeLayout)findViewById(2131310214));
      this.jVl = ((TextView)findViewById(2131310217));
      this.jVm = ((RelativeLayout)findViewById(2131310212));
      this.qAj = ((RelativeLayout)findViewById(2131310215));
      final int i = getIntent().getIntExtra("amount_remind_bit", 10);
      if ((!LocaleUtil.getApplicationLanguage().equals("zh_CN")) && (!LocaleUtil.getApplicationLanguage().equals("zh_TW")) && (!LocaleUtil.getApplicationLanguage().equals("zh_HK"))) {
        break label485;
      }
      this.jVk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213174);
          CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.b(CollectCreateQRCodeNewUI.this).getWidth());
          CollectCreateQRCodeNewUI.c(CollectCreateQRCodeNewUI.this).setVisibility(8);
          Log.d("MicroMsg.CollectCreateQRCodeNewUI", "post: mMaxUnitWidth:%s", new Object[] { Integer.valueOf(CollectCreateQRCodeNewUI.d(CollectCreateQRCodeNewUI.this)) });
          AppMethodBeat.o(213174);
        }
      });
      this.qAh.setmWalletFormViewListener(new WalletFormView.c()
      {
        public final void p(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(213175);
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
              paramAnonymousCharSequence = ag.aR(MMApplicationContext.getContext(), i);
              CollectCreateQRCodeNewUI.e(CollectCreateQRCodeNewUI.this).setText(paramAnonymousCharSequence);
              paramAnonymousCharSequence = (RelativeLayout.LayoutParams)CollectCreateQRCodeNewUI.b(CollectCreateQRCodeNewUI.this).getLayoutParams();
              paramAnonymousCharSequence.leftMargin = j;
              CollectCreateQRCodeNewUI.b(CollectCreateQRCodeNewUI.this).setLayoutParams(paramAnonymousCharSequence);
              AppMethodBeat.o(213175);
              return;
            }
            CollectCreateQRCodeNewUI.c(CollectCreateQRCodeNewUI.this).setVisibility(8);
            AppMethodBeat.o(213175);
            return;
          }
          CollectCreateQRCodeNewUI.c(CollectCreateQRCodeNewUI.this).setVisibility(8);
          AppMethodBeat.o(213175);
        }
      });
    }
    for (;;)
    {
      setMMTitle(2131757671);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(213179);
          CollectCreateQRCodeNewUI.this.setResult(0);
          CollectCreateQRCodeNewUI.this.finish();
          AppMethodBeat.o(213179);
          return true;
        }
      });
      this.jVf = ((ScrollView)findViewById(2131307173));
      this.jVf.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(213163);
          if ((CollectCreateQRCodeNewUI.h(CollectCreateQRCodeNewUI.this).isShown()) && (CollectCreateQRCodeNewUI.i(CollectCreateQRCodeNewUI.this).hgP()))
          {
            CollectCreateQRCodeNewUI.j(CollectCreateQRCodeNewUI.this).hgN();
            AppMethodBeat.o(213163);
            return true;
          }
          AppMethodBeat.o(213163);
          return false;
        }
      });
      localObject = (ImageView)findViewById(2131310211);
      if (!com.tencent.mm.ui.ao.isDarkMode()) {
        break label497;
      }
      findViewById(2131310216).setVisibility(8);
      findViewById(2131310213).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(2131235634);
      AppMethodBeat.o(213183);
      return;
      this.qAh.getTitleTv().setText(ah.hhz());
      break;
      label485:
      this.jVm.setVisibility(8);
    }
    label497:
    findViewById(2131310216).setVisibility(0);
    findViewById(2131310213).setVisibility(8);
    ((ImageView)localObject).setBackgroundResource(2131235633);
    AppMethodBeat.o(213183);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213181);
    super.onCreate(paramBundle);
    addSceneEndListener(1335);
    initView();
    AppMethodBeat.o(213181);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(213182);
    super.onDestroy();
    removeSceneEndListener(1335);
    AppMethodBeat.o(213182);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(213189);
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    AppMethodBeat.o(213189);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(213188);
    super.onPause();
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onPause()");
    if (!this.jVg.hgQ()) {
      this.state = 3;
    }
    AppMethodBeat.o(213188);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(213187);
    super.onResume();
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(213187);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(213184);
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "errType: %s ，errCode：%s, errMsg：%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof t))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (t)paramq;
        paramq = new Intent();
        paramq.putExtra("ftf_pay_url", paramString.qwI);
        paramq.putExtra("key_error_level", paramString.qwK);
        paramq.putExtra("ftf_fixed_fee", paramString.qwJ);
        paramq.putExtra("ftf_fixed_fee_type", paramString.dFv);
        paramq.putExtra("ftf_fixed_desc", paramString.desc);
        setResult(-1, paramq);
        hideVKB();
        finish();
        AppMethodBeat.o(213184);
        return true;
      }
    }
    else if ((paramq instanceof n))
    {
      paramString = (n)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.dDN == 0)
        {
          paramq = new Intent();
          paramq.putExtra("ftf_pay_url", paramString.qwo);
          paramq.putExtra("ftf_fixed_fee", paramString.eht / 100.0D);
          paramq.putExtra("ftf_fixed_desc", paramString.desc);
          paramq.putExtra("key_currency_unit", paramString.qwx);
          setResult(-1, paramq);
          hideVKB();
          finish();
          AppMethodBeat.o(213184);
          return true;
        }
        if (paramString.qwp == 0)
        {
          com.tencent.mm.ui.base.h.c(getContext(), paramString.qwn, paramString.qwq, false);
          AppMethodBeat.o(213184);
          return true;
        }
        if (paramString.qwp == 1)
        {
          if ((!Util.isNullOrNil(paramString.qwr)) && (!Util.isNullOrNil(paramString.qws))) {
            com.tencent.mm.ui.base.h.c(getContext(), paramString.qwn, paramString.qwq, paramString.qws, paramString.qwr, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(213162);
                if (!Util.isNullOrNil(paramString.qwt))
                {
                  Log.i("MicroMsg.CollectCreateQRCodeNewUI", "goto h5: %s", new Object[] { paramString.qwt });
                  f.p(CollectCreateQRCodeNewUI.this.getContext(), paramString.qwt, true);
                }
                AppMethodBeat.o(213162);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
          AppMethodBeat.o(213184);
          return true;
        }
      }
      else
      {
        Log.e("MicroMsg.CollectCreateQRCodeNewUI", "net error: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(213184);
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