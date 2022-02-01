package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
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
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;

public class CollectCreateQRCodeUI
  extends WalletBaseUI
{
  private String mDesc = "";
  private TextView xcA;
  private WalletFormView xcz;
  
  public int getLayoutId()
  {
    return a.g.collect_create_qrcode;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64101);
    setMMTitle(a.i.collect_create_qrcode_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64091);
        CollectCreateQRCodeUI.this.setResult(0);
        CollectCreateQRCodeUI.this.finish();
        AppMethodBeat.o(64091);
        return true;
      }
    });
    this.xcz = ((WalletFormView)findViewById(a.f.money_ev));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.xcz);
    String str = getIntent().getStringExtra("key_currency_unit");
    if (!Util.isNullOrNil(str)) {
      this.xcz.getTitleTv().setText(str);
    }
    for (;;)
    {
      this.xcz.a(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(64092);
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          String str = paramAnonymousEditable.toString();
          int i = str.indexOf(".");
          int j = str.length();
          if ((i >= 0) && (j - i > 2)) {
            paramAnonymousEditable.delete(i + 3, j);
          }
          AppMethodBeat.o(64092);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      setEditFocusListener(this.xcz, 2, false);
      ((Button)findViewById(a.f.next_btn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64093);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          double d = Util.getDouble(CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).getText(), 0.0D);
          h.baF();
          int i = ((Integer)h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).bZp()) {
            aa.makeText(CollectCreateQRCodeUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64093);
            return;
            if (d < 0.01D) {
              aa.makeText(CollectCreateQRCodeUI.this.getContext(), a.i.remittance_amount_lowest_limit, 0).show();
            } else if (i == 8) {
              CollectCreateQRCodeUI.this.doSceneForceProgress(new m(Math.round(d * 100.0D), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), z.bAV()));
            } else {
              CollectCreateQRCodeUI.this.doSceneProgress(new s(d, "1", CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this)));
            }
          }
        }
      });
      this.xcA = ((TextView)findViewById(a.f.collect_main_add_desc));
      this.xcA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64097);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          CollectCreateQRCodeUI.this.hideTenpayKB();
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(CollectCreateQRCodeUI.this, CollectCreateQRCodeUI.this.getString(a.i.collect_main_add_desc_title), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), "", true, 32, new k.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(64094);
              if (!Util.isNullOrNil(paramAnonymous2CharSequence.toString()))
              {
                CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this, paramAnonymous2CharSequence.toString());
                CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
              }
              for (;;)
              {
                MMHandlerThread.postToMainThreadDelayed(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(293578);
                    CollectCreateQRCodeUI.this.hideVKB();
                    AppMethodBeat.o(293578);
                  }
                }, 200L);
                AppMethodBeat.o(64094);
                return true;
                CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this, "");
                CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(64096);
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(64095);
                  CollectCreateQRCodeUI.this.hideVKB();
                  AppMethodBeat.o(64095);
                }
              }, 500L);
              AppMethodBeat.o(64096);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64097);
        }
      });
      AppMethodBeat.o(64101);
      return;
      this.xcz.getTitleTv().setText(ai.jOX());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64099);
    super.onCreate(paramBundle);
    addSceneEndListener(1335);
    initView();
    AppMethodBeat.o(64099);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64100);
    super.onDestroy();
    removeSceneEndListener(1335);
    AppMethodBeat.o(64100);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(64102);
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
        AppMethodBeat.o(64102);
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
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.wYK == 0)
        {
          k.c(getContext(), paramString.wYI, paramString.wYL, false);
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.wYK == 1)
        {
          if ((!Util.isNullOrNil(paramString.wYM)) && (!Util.isNullOrNil(paramString.wYN))) {
            k.b(getContext(), paramString.wYI, paramString.wYL, paramString.wYN, paramString.wYM, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(64098);
                if (!Util.isNullOrNil(paramString.wYO))
                {
                  Log.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[] { paramString.wYO });
                  i.p(CollectCreateQRCodeUI.this.getContext(), paramString.wYO, true);
                }
                AppMethodBeat.o(64098);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
          AppMethodBeat.o(64102);
          return true;
        }
      }
      else
      {
        Log.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(64102);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI
 * JD-Core Version:    0.7.0.1
 */