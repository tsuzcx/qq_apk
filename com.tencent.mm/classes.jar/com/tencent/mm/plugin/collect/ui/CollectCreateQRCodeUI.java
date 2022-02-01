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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.n;
import com.tencent.mm.plugin.collect.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class CollectCreateQRCodeUI
  extends WalletBaseUI
{
  private String mDesc = "";
  private WalletFormView qAh;
  private TextView qAi;
  
  public int getLayoutId()
  {
    return 2131493671;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64101);
    setMMTitle(2131757671);
    setBackBtn(new CollectCreateQRCodeUI.1(this));
    this.qAh = ((WalletFormView)findViewById(2131304847));
    com.tencent.mm.wallet_core.ui.formview.a.f(this.qAh);
    String str = getIntent().getStringExtra("key_currency_unit");
    if (!Util.isNullOrNil(str)) {
      this.qAh.getTitleTv().setText(str);
    }
    for (;;)
    {
      this.qAh.a(new CollectCreateQRCodeUI.2(this));
      setEditFocusListener(this.qAh, 2, false);
      ((Button)findViewById(2131305423)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64093);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          double d = Util.getDouble(CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).getText(), 0.0D);
          g.aAi();
          int i = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
          if (!CollectCreateQRCodeUI.a(CollectCreateQRCodeUI.this).bql()) {
            u.makeText(CollectCreateQRCodeUI.this.getContext(), 2131767474, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64093);
            return;
            if (d < 0.01D) {
              u.makeText(CollectCreateQRCodeUI.this.getContext(), 2131764485, 0).show();
            } else if (i == 8) {
              CollectCreateQRCodeUI.this.doSceneForceProgress(new n(Math.round(d * 100.0D), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), z.aUf()));
            } else {
              CollectCreateQRCodeUI.this.doSceneProgress(new t(d, "1", CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this)));
            }
          }
        }
      });
      this.qAi = ((TextView)findViewById(2131298862));
      this.qAi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64097);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          CollectCreateQRCodeUI.this.hideTenpayKB();
          com.tencent.mm.plugin.wallet_core.ui.view.a.a(CollectCreateQRCodeUI.this, CollectCreateQRCodeUI.this.getString(2131757672), CollectCreateQRCodeUI.b(CollectCreateQRCodeUI.this), "", true, 32, new h.b()new DialogInterface.OnClickListener
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
                    AppMethodBeat.i(213195);
                    CollectCreateQRCodeUI.this.hideVKB();
                    AppMethodBeat.o(213195);
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
      this.qAh.getTitleTv().setText(ah.hhz());
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64102);
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
        AppMethodBeat.o(64102);
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
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.qwp == 0)
        {
          h.c(getContext(), paramString.qwn, paramString.qwq, false);
          AppMethodBeat.o(64102);
          return true;
        }
        if (paramString.qwp == 1)
        {
          if ((!Util.isNullOrNil(paramString.qwr)) && (!Util.isNullOrNil(paramString.qws))) {
            h.c(getContext(), paramString.qwn, paramString.qwq, paramString.qws, paramString.qwr, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(64098);
                if (!Util.isNullOrNil(paramString.qwt))
                {
                  Log.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[] { paramString.qwt });
                  f.p(CollectCreateQRCodeUI.this.getContext(), paramString.qwt, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI
 * JD-Core Version:    0.7.0.1
 */