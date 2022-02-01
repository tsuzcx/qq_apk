package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class CollectCreateQRCodeUI
  extends WalletBaseUI
{
  private String mDesc = "";
  private WalletFormView oAV;
  private TextView oAW;
  
  public int getLayoutId()
  {
    return 2131493559;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64101);
    setMMTitle(2131757452);
    setBackBtn(new CollectCreateQRCodeUI.1(this));
    this.oAV = ((WalletFormView)findViewById(2131302446));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.oAV);
    String str = getIntent().getStringExtra("key_currency_unit");
    if (!bs.isNullOrNil(str)) {
      this.oAV.getTitleTv().setText(str);
    }
    for (;;)
    {
      this.oAV.a(new CollectCreateQRCodeUI.2(this));
      setEditFocusListener(this.oAV, 2, false);
      ((Button)findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64093);
          double d = bs.getDouble(CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).getText(), 0.0D);
          g.agS();
          int i = ((Integer)g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
          ac.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).aRO())
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
            CollectCreateQRCodeUI.this.doSceneForceProgress(new com.tencent.mm.plugin.collect.model.n(Math.round(d * 100.0D), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), u.axD()));
            AppMethodBeat.o(64093);
            return;
          }
          CollectCreateQRCodeUI.this.doSceneProgress(new com.tencent.mm.plugin.collect.model.t(d, "1", CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this)));
          AppMethodBeat.o(64093);
        }
      });
      this.oAW = ((TextView)findViewById(2131298450));
      this.oAW.setOnClickListener(new View.OnClickListener()
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
              if (!bs.isNullOrNil(paramAnonymous2CharSequence.toString()))
              {
                CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this, paramAnonymous2CharSequence.toString());
                CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
              }
              for (;;)
              {
                ap.n(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(207048);
                    CollectCreateQRCodeUI.this.hideVKB();
                    AppMethodBeat.o(207048);
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
              ap.n(new Runnable()
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
      this.oAV.getTitleTv().setText(ah.fAw());
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
        paramn.putExtra("ftf_pay_url", paramString.oxz);
        paramn.putExtra("key_error_level", paramString.oxB);
        paramn.putExtra("ftf_fixed_fee", paramString.oxA);
        paramn.putExtra("ftf_fixed_fee_type", paramString.dbI);
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
        if (paramString.dae == 0)
        {
          paramn = new Intent();
          paramn.putExtra("ftf_pay_url", paramString.oxg);
          paramn.putExtra("ftf_fixed_fee", paramString.dBN / 100.0D);
          paramn.putExtra("ftf_fixed_desc", paramString.desc);
          paramn.putExtra("key_currency_unit", paramString.oxp);
          setResult(-1, paramn);
          hideVKB();
          finish();
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.oxh == 0)
        {
          h.c(getContext(), paramString.oxf, paramString.oxi, false);
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.oxh == 1)
        {
          if ((!bs.isNullOrNil(paramString.oxj)) && (!bs.isNullOrNil(paramString.oxk))) {
            h.d(getContext(), paramString.oxf, paramString.oxi, paramString.oxk, paramString.oxj, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(64098);
                if (!bs.isNullOrNil(paramString.oxl))
                {
                  ac.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[] { paramString.oxl });
                  com.tencent.mm.wallet_core.ui.e.o(CollectCreateQRCodeUI.this.getContext(), paramString.oxl, true);
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
        ac.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[] { paramString });
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