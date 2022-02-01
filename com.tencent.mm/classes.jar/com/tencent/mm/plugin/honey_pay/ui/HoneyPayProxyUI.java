package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.dra;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

@a(3)
public class HoneyPayProxyUI
  extends HoneyPayBaseUI
{
  private String DKa;
  private boolean DLI;
  
  protected final void eHM() {}
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64818);
    super.onCreate(paramBundle);
    addSceneEndListener(2876);
    addSceneEndListener(2613);
    this.DLI = getIntent().getBooleanExtra("key_is_payer", false);
    this.DKa = getIntent().getStringExtra("key_card_no");
    Log.i(this.TAG, "is payer: %s", new Object[] { Boolean.valueOf(this.DLI) });
    if (this.DLI)
    {
      Log.i(this.TAG, "do qry payer detail");
      paramBundle = new l(this.DKa);
      paramBundle.u(this);
      doSceneProgress(paramBundle, true);
      AppMethodBeat.o(64818);
      return;
    }
    paramBundle = new m(this.DKa);
    paramBundle.u(this);
    doSceneProgress(paramBundle, true);
    AppMethodBeat.o(64818);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64819);
    super.onDestroy();
    removeSceneEndListener(2876);
    removeSceneEndListener(2613);
    AppMethodBeat.o(64819);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64820);
    if ((paramq instanceof l))
    {
      paramString = (l)paramq;
      paramString.a(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64815);
          if (paramString.DJL.Sra != null) {
            Log.i(HoneyPayProxyUI.this.TAG, "state: %s", new Object[] { Integer.valueOf(paramString.DJL.Sra.state) });
          }
          HoneyPayProxyUI.a(HoneyPayProxyUI.this, paramString.DJL);
          HoneyPayProxyUI.this.finish();
          AppMethodBeat.o(64815);
        }
      }).b(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64814);
          HoneyPayProxyUI.this.finish();
          AppMethodBeat.o(64814);
        }
      }).c(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64820);
      return true;
      if ((paramq instanceof m))
      {
        paramString = (m)paramq;
        paramString.a(new r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64817);
            Log.i(HoneyPayProxyUI.this.TAG, "state: %s", new Object[] { Integer.valueOf(paramString.DJM.TfN.state) });
            if (paramString.DJM.TfN.state == 1) {
              HoneyPayProxyUI.a(HoneyPayProxyUI.this, paramString.DJM);
            }
            for (;;)
            {
              HoneyPayProxyUI.this.finish();
              AppMethodBeat.o(64817);
              return;
              HoneyPayProxyUI.b(HoneyPayProxyUI.this, paramString.DJM);
            }
          }
        }).b(new r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(64816);
            HoneyPayProxyUI.this.finish();
            AppMethodBeat.o(64816);
          }
        }).c(new r.a()
        {
          public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
        });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI
 * JD-Core Version:    0.7.0.1
 */