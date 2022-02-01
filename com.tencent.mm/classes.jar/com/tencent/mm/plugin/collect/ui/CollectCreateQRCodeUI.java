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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class CollectCreateQRCodeUI
  extends WalletBaseUI
{
  private String mDesc = "";
  private WalletFormView pkW;
  private TextView pkX;
  
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
    this.pkW = ((WalletFormView)findViewById(2131302446));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.pkW);
    String str = getIntent().getStringExtra("key_currency_unit");
    if (!bu.isNullOrNil(str)) {
      this.pkW.getTitleTv().setText(str);
    }
    for (;;)
    {
      this.pkW.a(new TextWatcher()
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
      setEditFocusListener(this.pkW, 2, false);
      ((Button)findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64093);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          double d = bu.getDouble(CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).getText(), 0.0D);
          g.ajS();
          int i = ((Integer)g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
          ae.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).aVz()) {
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
              CollectCreateQRCodeUI.this.doSceneForceProgress(new com.tencent.mm.plugin.collect.model.n(Math.round(d * 100.0D), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), v.aAJ()));
            } else {
              CollectCreateQRCodeUI.this.doSceneProgress(new com.tencent.mm.plugin.collect.model.t(d, "1", CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this)));
            }
          }
        }
      });
      this.pkX = ((TextView)findViewById(2131298450));
      this.pkX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64097);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          CollectCreateQRCodeUI.this.hideTenpayKB();
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(CollectCreateQRCodeUI.this, CollectCreateQRCodeUI.this.getString(2131757453), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), "", true, 32, new h.b()new DialogInterface.OnClickListener
          {
            public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
            {
              AppMethodBeat.i(64094);
              if (!bu.isNullOrNil(paramAnonymous2CharSequence.toString()))
              {
                CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this, paramAnonymous2CharSequence.toString());
                CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
              }
              for (;;)
              {
                ar.o(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(189786);
                    CollectCreateQRCodeUI.this.hideVKB();
                    AppMethodBeat.o(189786);
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
              ar.o(new Runnable()
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
      this.pkW.getTitleTv().setText(ah.fWc());
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(64102);
    if ((paramn instanceof com.tencent.mm.plugin.collect.model.t))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.collect.model.t)paramn;
        paramn = new Intent();
        paramn.putExtra("ftf_pay_url", paramString.phy);
        paramn.putExtra("key_error_level", paramString.phA);
        paramn.putExtra("ftf_fixed_fee", paramString.phz);
        paramn.putExtra("ftf_fixed_fee_type", paramString.dog);
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
        if (paramString.dmy == 0)
        {
          paramn = new Intent();
          paramn.putExtra("ftf_pay_url", paramString.phf);
          paramn.putExtra("ftf_fixed_fee", paramString.dPq / 100.0D);
          paramn.putExtra("ftf_fixed_desc", paramString.desc);
          paramn.putExtra("key_currency_unit", paramString.pho);
          setResult(-1, paramn);
          hideVKB();
          finish();
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.phg == 0)
        {
          h.c(getContext(), paramString.phe, paramString.phh, false);
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.phg == 1)
        {
          if ((!bu.isNullOrNil(paramString.phi)) && (!bu.isNullOrNil(paramString.phj))) {
            h.e(getContext(), paramString.phe, paramString.phh, paramString.phj, paramString.phi, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(64098);
                if (!bu.isNullOrNil(paramString.phk))
                {
                  ae.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[] { paramString.phk });
                  f.p(CollectCreateQRCodeUI.this.getContext(), paramString.phk, true);
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
        ae.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[] { paramString });
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