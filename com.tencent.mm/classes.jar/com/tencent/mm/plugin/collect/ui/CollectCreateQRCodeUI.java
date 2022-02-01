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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class CollectCreateQRCodeUI
  extends WalletBaseUI
{
  private String mDesc = "";
  private WalletFormView nXA;
  private TextView nXB;
  
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
    this.nXA = ((WalletFormView)findViewById(2131302446));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.nXA);
    String str = getIntent().getStringExtra("key_currency_unit");
    if (!bt.isNullOrNil(str)) {
      this.nXA.getTitleTv().setText(str);
    }
    for (;;)
    {
      this.nXA.a(new TextWatcher()
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
      setEditFocusListener(this.nXA, 2, false);
      ((Button)findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64093);
          double d = bt.getDouble(CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).getText(), 0.0D);
          g.afC();
          int i = ((Integer)g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
          ad.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).aKX())
          {
            com.tencent.mm.ui.base.t.makeText(CollectCreateQRCodeUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(64093);
            return;
          }
          if (d < 0.01D)
          {
            com.tencent.mm.ui.base.t.makeText(CollectCreateQRCodeUI.this.getContext(), 2131762419, 0).show();
            AppMethodBeat.o(64093);
            return;
          }
          if (i == 8)
          {
            CollectCreateQRCodeUI.this.doSceneForceProgress(new com.tencent.mm.plugin.collect.model.n(Math.round(d * 100.0D), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), u.aqN()));
            AppMethodBeat.o(64093);
            return;
          }
          CollectCreateQRCodeUI.this.doSceneProgress(new com.tencent.mm.plugin.collect.model.t(d, "1", CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this)));
          AppMethodBeat.o(64093);
        }
      });
      this.nXB = ((TextView)findViewById(2131298450));
      this.nXB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64097);
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
                aq.n(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(186992);
                    CollectCreateQRCodeUI.this.hideVKB();
                    AppMethodBeat.o(186992);
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
              aq.n(new Runnable()
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
          AppMethodBeat.o(64097);
        }
      });
      AppMethodBeat.o(64101);
      return;
      this.nXA.getTitleTv().setText(ah.fkg());
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
        paramn.putExtra("ftf_pay_url", paramString.nUe);
        paramn.putExtra("key_error_level", paramString.nUg);
        paramn.putExtra("ftf_fixed_fee", paramString.nUf);
        paramn.putExtra("ftf_fixed_fee_type", paramString.dem);
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
        if (paramString.dcG == 0)
        {
          paramn = new Intent();
          paramn.putExtra("ftf_pay_url", paramString.nTL);
          paramn.putExtra("ftf_fixed_fee", paramString.dEb / 100.0D);
          paramn.putExtra("ftf_fixed_desc", paramString.desc);
          paramn.putExtra("key_currency_unit", paramString.nTU);
          setResult(-1, paramn);
          hideVKB();
          finish();
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.nTM == 0)
        {
          h.c(getContext(), paramString.nTK, paramString.nTN, false);
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.nTM == 1)
        {
          if ((!bt.isNullOrNil(paramString.nTO)) && (!bt.isNullOrNil(paramString.nTP))) {
            h.d(getContext(), paramString.nTK, paramString.nTN, paramString.nTP, paramString.nTO, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(64098);
                if (!bt.isNullOrNil(paramString.nTQ))
                {
                  ad.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[] { paramString.nTQ });
                  com.tencent.mm.wallet_core.ui.e.p(CollectCreateQRCodeUI.this.getContext(), paramString.nTQ, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI
 * JD-Core Version:    0.7.0.1
 */