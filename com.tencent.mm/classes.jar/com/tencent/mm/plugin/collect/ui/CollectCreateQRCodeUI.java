package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class CollectCreateQRCodeUI
  extends WalletBaseUI
{
  private String mDesc = "";
  private WalletFormView peq;
  private TextView per;
  
  public int getLayoutId()
  {
    return 2131493559;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64101);
    setMMTitle(2131757452);
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
    this.peq = ((WalletFormView)findViewById(2131302446));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.peq);
    String str = getIntent().getStringExtra("key_currency_unit");
    if (!bt.isNullOrNil(str)) {
      this.peq.getTitleTv().setText(str);
    }
    for (;;)
    {
      this.peq.a(new TextWatcher()
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
      setEditFocusListener(this.peq, 2, false);
      ((Button)findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64093);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          double d = bt.getDouble(CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).getText(), 0.0D);
          g.ajD();
          int i = ((Integer)g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
          ad.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).aVa()) {
            com.tencent.mm.ui.base.t.makeText(CollectCreateQRCodeUI.this.getContext(), 2131765031, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64093);
            return;
            if (d < 0.01D) {
              com.tencent.mm.ui.base.t.makeText(CollectCreateQRCodeUI.this.getContext(), 2131762419, 0).show();
            } else if (i == 8) {
              CollectCreateQRCodeUI.this.doSceneForceProgress(new com.tencent.mm.plugin.collect.model.n(Math.round(d * 100.0D), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), u.aAt()));
            } else {
              CollectCreateQRCodeUI.this.doSceneProgress(new com.tencent.mm.plugin.collect.model.t(d, "1", CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this)));
            }
          }
        }
      });
      this.per = ((TextView)findViewById(2131298450));
      this.per.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64097);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          CollectCreateQRCodeUI.this.hideTenpayKB();
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(CollectCreateQRCodeUI.this, CollectCreateQRCodeUI.this.getString(2131757453), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), "", true, 32, new h.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(64094);
              if (!bt.isNullOrNil(paramAnonymous2CharSequence.toString()))
              {
                CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this, paramAnonymous2CharSequence.toString());
                CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
              }
              for (;;)
              {
                aq.o(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(198952);
                    CollectCreateQRCodeUI.this.hideVKB();
                    AppMethodBeat.o(198952);
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
              aq.o(new Runnable()
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
      this.peq.getTitleTv().setText(ah.fRG());
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(64102);
    if ((paramn instanceof com.tencent.mm.plugin.collect.model.t))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.collect.model.t)paramn;
        paramn = new Intent();
        paramn.putExtra("ftf_pay_url", paramString.paU);
        paramn.putExtra("key_error_level", paramString.paW);
        paramn.putExtra("ftf_fixed_fee", paramString.paV);
        paramn.putExtra("ftf_fixed_fee_type", paramString.dne);
        paramn.putExtra("ftf_fixed_desc", paramString.desc);
        setResult(-1, paramn);
        hideVKB();
        finish();
        AppMethodBeat.o(64102);
        return true;
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.collect.model.n))
    {
      paramString = (com.tencent.mm.plugin.collect.model.n)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.dlw == 0)
        {
          paramn = new Intent();
          paramn.putExtra("ftf_pay_url", paramString.paB);
          paramn.putExtra("ftf_fixed_fee", paramString.dOa / 100.0D);
          paramn.putExtra("ftf_fixed_desc", paramString.desc);
          paramn.putExtra("key_currency_unit", paramString.paK);
          setResult(-1, paramn);
          hideVKB();
          finish();
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.paC == 0)
        {
          h.c(getContext(), paramString.paA, paramString.paD, false);
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.paC == 1)
        {
          if ((!bt.isNullOrNil(paramString.paE)) && (!bt.isNullOrNil(paramString.paF))) {
            h.e(getContext(), paramString.paA, paramString.paD, paramString.paF, paramString.paE, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(64098);
                if (!bt.isNullOrNil(paramString.paG))
                {
                  ad.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[] { paramString.paG });
                  com.tencent.mm.wallet_core.ui.e.o(CollectCreateQRCodeUI.this.getContext(), paramString.paG, true);
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
        ad.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[] { paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI
 * JD-Core Version:    0.7.0.1
 */