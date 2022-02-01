package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

@a(3)
public class HoneyPayProxyUI
  extends HoneyPayBaseUI
{
  private String svk;
  private boolean swU;
  
  protected final void cFM() {}
  
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
    this.swU = getIntent().getBooleanExtra("key_is_payer", false);
    this.svk = getIntent().getStringExtra("key_card_no");
    ad.i(this.TAG, "is payer: %s", new Object[] { Boolean.valueOf(this.swU) });
    if (this.swU)
    {
      ad.i(this.TAG, "do qry payer detail");
      paramBundle = new l(this.svk);
      paramBundle.q(this);
      doSceneProgress(paramBundle, true);
      AppMethodBeat.o(64818);
      return;
    }
    paramBundle = new m(this.svk);
    paramBundle.q(this);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(64820);
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(64815);
          if (paramString.suU.Dbf != null) {
            ad.i(HoneyPayProxyUI.this.TAG, "state: %s", new Object[] { Integer.valueOf(paramString.suU.Dbf.state) });
          }
          HoneyPayProxyUI.a(HoneyPayProxyUI.this, paramString.suU);
          HoneyPayProxyUI.this.finish();
          AppMethodBeat.o(64815);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(64814);
          HoneyPayProxyUI.this.finish();
          AppMethodBeat.o(64814);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64820);
      return true;
      if ((paramn instanceof m))
      {
        paramString = (m)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64817);
            ad.i(HoneyPayProxyUI.this.TAG, "state: %s", new Object[] { Integer.valueOf(paramString.suV.DuB.state) });
            if (paramString.suV.DuB.state == 1) {
              HoneyPayProxyUI.a(HoneyPayProxyUI.this, paramString.suV);
            }
            for (;;)
            {
              HoneyPayProxyUI.this.finish();
              AppMethodBeat.o(64817);
              return;
              HoneyPayProxyUI.b(HoneyPayProxyUI.this, paramString.suV);
            }
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(64816);
            HoneyPayProxyUI.this.finish();
            AppMethodBeat.o(64816);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI
 * JD-Core Version:    0.7.0.1
 */