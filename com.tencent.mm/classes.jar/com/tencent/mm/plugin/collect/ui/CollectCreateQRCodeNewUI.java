package com.tencent.mm.plugin.collect.ui;

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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashSet;

public class CollectCreateQRCodeNewUI
  extends WalletBaseUI
{
  private String mDesc;
  protected ScrollView pJa;
  private WcPayKeyboard pJb;
  private TextView pJi;
  private Runnable pJs;
  private int state;
  private TextView xcA;
  private WalletFormView xcz;
  
  public CollectCreateQRCodeNewUI()
  {
    AppMethodBeat.i(293618);
    this.mDesc = "";
    this.state = 0;
    this.pJs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293623);
        if ((CollectCreateQRCodeNewUI.f(CollectCreateQRCodeNewUI.this) == 2) && (CollectCreateQRCodeNewUI.g(CollectCreateQRCodeNewUI.this))) {
          CollectCreateQRCodeNewUI.this.showNormalStWcKb();
        }
        AppMethodBeat.o(293623);
      }
    };
    AppMethodBeat.o(293618);
  }
  
  private void bVu()
  {
    AppMethodBeat.i(293624);
    if (!Util.isNullOrNil(this.mDesc))
    {
      str = getString(a.i.collect_main_add_desc_title_simple_change);
      SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.p.b(this, getString(a.i.collect_main_add_desc_title_changed, new Object[] { this.mDesc, str }));
      com.tencent.mm.wallet_core.ui.i.a(this.pJi, localSpannableString.toString(), localSpannableString.length() - str.length(), localSpannableString.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(293607);
          CollectCreateQRCodeNewUI.d(CollectCreateQRCodeNewUI.this);
          AppMethodBeat.o(293607);
        }
      }), getContext());
      this.xcA.setVisibility(8);
      this.pJi.setVisibility(0);
      AppMethodBeat.o(293624);
      return;
    }
    String str = getString(a.i.collect_main_add_desc_title);
    com.tencent.mm.wallet_core.ui.i.a(this.xcA, str, 0, str.length(), new com.tencent.mm.wallet_core.ui.f(new f.a()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(293616);
        CollectCreateQRCodeNewUI.d(CollectCreateQRCodeNewUI.this);
        AppMethodBeat.o(293616);
      }
    }), getContext());
    this.xcA.setVisibility(0);
    this.pJi.setVisibility(8);
    AppMethodBeat.o(293624);
  }
  
  private void hH(boolean paramBoolean)
  {
    AppMethodBeat.i(293627);
    this.pJb.Oi(paramBoolean);
    AppMethodBeat.o(293627);
  }
  
  public int getLayoutId()
  {
    return a.g.collect_create_qrcode_new;
  }
  
  public void initView()
  {
    AppMethodBeat.i(293669);
    this.xcz = ((WalletFormView)findViewById(a.f.money_ev));
    Object localObject = (EditText)findViewById(a.f.wallet_content);
    ((TextView)findViewById(a.f.wallet_title)).setTextSize(1, 56.0F);
    ((EditText)localObject).setTextSize(1, 56.0F);
    com.tencent.mm.wallet_core.ui.formview.a.f(this.xcz);
    localObject = getIntent().getStringExtra("key_currency_unit");
    if (!Util.isNullOrNil((String)localObject)) {
      this.xcz.getTitleTv().setText((CharSequence)localObject);
    }
    for (;;)
    {
      this.xcz.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(293635);
          double d = Util.getDouble(paramAnonymousEditable.toString(), 0.0D);
          if ((!CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).bZp()) || (d < 0.01D))
          {
            CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, false);
            AppMethodBeat.o(293635);
            return;
          }
          CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, true);
          AppMethodBeat.o(293635);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.xcz.jPD();
      this.pJi = ((TextView)findViewById(a.f.collect_main_desc));
      this.xcA = ((TextView)findViewById(a.f.collect_main_add_desc));
      bVu();
      this.pJb = ((WcPayKeyboard)findViewById(a.f.wp_kb));
      this.pJb.hVf();
      this.pJb.setActionText(getString(a.i.collect_create_qrcode_gen_btn));
      localObject = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(293638);
          double d = Util.getDouble(CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).getText(), 0.0D);
          com.tencent.mm.kernel.h.baF();
          int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.CollectCreateQRCodeNewUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).bZp())
          {
            CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.this.getString(a.i.wallet_balance_save_input_invalid));
            AppMethodBeat.o(293638);
            return;
          }
          if (d < 0.01D)
          {
            CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.this.getString(a.i.remittance_amount_lowest_limit));
            AppMethodBeat.o(293638);
            return;
          }
          if (i == 8)
          {
            CollectCreateQRCodeNewUI.this.doSceneForceProgress(new m(Math.round(d * 100.0D), CollectCreateQRCodeNewUI.b(CollectCreateQRCodeNewUI.this), z.bAV()));
            AppMethodBeat.o(293638);
            return;
          }
          CollectCreateQRCodeNewUI.this.doSceneProgress(new s(d, "1", CollectCreateQRCodeNewUI.b(CollectCreateQRCodeNewUI.this)));
          AppMethodBeat.o(293638);
        }
      };
      this.xcz.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(293603);
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (CollectCreateQRCodeNewUI.c(CollectCreateQRCodeNewUI.this).isShown()))
          {
            Log.i("MicroMsg.CollectCreateQRCodeNewUI", "click enter");
            this.pJE.onClick(null);
            AppMethodBeat.o(293603);
            return true;
          }
          AppMethodBeat.o(293603);
          return true;
        }
      });
      ((RelativeLayout.LayoutParams)this.pJb.getLayoutParams()).addRule(12);
      hH(false);
      setWPKeyboard(this.xcz.getContentEt(), true, false);
      this.xcz.setmContentAbnormalMoneyCheck(true);
      this.xcz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293601);
          CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this).getContentEt().requestFocus();
          AppMethodBeat.o(293601);
        }
      });
      setMMTitle(a.i.collect_create_qrcode_title);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(293602);
          CollectCreateQRCodeNewUI.this.setResult(0);
          CollectCreateQRCodeNewUI.this.finish();
          AppMethodBeat.o(293602);
          return true;
        }
      });
      this.pJa = ((ScrollView)findViewById(a.f.root_view));
      this.pJa.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(293611);
          CollectCreateQRCodeNewUI.this.handleKeyboardTouchEvent(paramAnonymousMotionEvent);
          AppMethodBeat.o(293611);
          return false;
        }
      });
      AppMethodBeat.o(293669);
      return;
      this.xcz.getTitleTv().setText(ai.jOX());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(293659);
    super.onCreate(paramBundle);
    addSceneEndListener(1335);
    initView();
    AppMethodBeat.o(293659);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(293666);
    super.onDestroy();
    removeSceneEndListener(1335);
    AppMethodBeat.o(293666);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(293683);
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onDialogDismiss()");
    MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
    AppMethodBeat.o(293683);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(293680);
    super.onPause();
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onPause()");
    if (!this.pJb.jOn()) {
      this.state = 3;
    }
    AppMethodBeat.o(293680);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(293678);
    super.onResume();
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      showNormalStWcKb();
    }
    this.state = 2;
    AppMethodBeat.o(293678);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(293674);
    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "errType: %s ，errCode：%s, errMsg：%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof s))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (s)paramp;
        paramp = new Intent();
        paramp.putExtra("ftf_pay_url", paramString.wZd);
        paramp.putExtra("key_error_level", paramString.wZf);
        paramp.putExtra("ftf_fixed_fee", paramString.wZe);
        paramp.putExtra("ftf_fixed_fee_type", paramString.hCH);
        paramp.putExtra("ftf_fixed_desc", paramString.desc);
        setResult(-1, paramp);
        hideVKB();
        finish();
        AppMethodBeat.o(293674);
        return true;
      }
    }
    else if ((paramp instanceof m))
    {
      paramString = (m)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.hAV == 0)
        {
          paramp = new Intent();
          paramp.putExtra("ftf_pay_url", paramString.wYJ);
          paramp.putExtra("ftf_fixed_fee", paramString.ihV / 100.0D);
          paramp.putExtra("ftf_fixed_desc", paramString.desc);
          paramp.putExtra("key_currency_unit", paramString.wYS);
          setResult(-1, paramp);
          hideVKB();
          finish();
          AppMethodBeat.o(293674);
          return true;
        }
        if (paramString.wYK == 0)
        {
          com.tencent.mm.ui.base.k.c(getContext(), paramString.wYI, paramString.wYL, false);
          AppMethodBeat.o(293674);
          return true;
        }
        if (paramString.wYK == 1)
        {
          if ((!Util.isNullOrNil(paramString.wYM)) && (!Util.isNullOrNil(paramString.wYN))) {
            com.tencent.mm.ui.base.k.b(getContext(), paramString.wYI, paramString.wYL, paramString.wYN, paramString.wYM, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(293613);
                if (!Util.isNullOrNil(paramString.wYO))
                {
                  Log.i("MicroMsg.CollectCreateQRCodeNewUI", "goto h5: %s", new Object[] { paramString.wYO });
                  com.tencent.mm.wallet_core.ui.i.p(CollectCreateQRCodeNewUI.this.getContext(), paramString.wYO, true);
                }
                AppMethodBeat.o(293613);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
          AppMethodBeat.o(293674);
          return true;
        }
      }
      else
      {
        Log.e("MicroMsg.CollectCreateQRCodeNewUI", "net error: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(293674);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(293663);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.collect.a.a.class);
    AppMethodBeat.o(293663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI
 * JD-Core Version:    0.7.0.1
 */