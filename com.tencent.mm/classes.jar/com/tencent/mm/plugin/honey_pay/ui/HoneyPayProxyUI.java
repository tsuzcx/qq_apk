package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;

@a(3)
public class HoneyPayProxyUI
  extends HoneyPayBaseUI
{
  private String JAW;
  private boolean JCS;
  
  protected final void fPx() {}
  
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
    this.JCS = getIntent().getBooleanExtra("key_is_payer", false);
    this.JAW = getIntent().getStringExtra("key_card_no");
    Log.i(this.TAG, "is payer: %s", new Object[] { Boolean.valueOf(this.JCS) });
    if (this.JCS)
    {
      Log.i(this.TAG, "do qry payer detail");
      paramBundle = new l(this.JAW);
      paramBundle.r(this);
      doSceneProgress(paramBundle, true);
      AppMethodBeat.o(64818);
      return;
    }
    paramBundle = new m(this.JAW);
    paramBundle.r(this);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(64820);
    if ((paramp instanceof l))
    {
      paramString = (l)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(64815);
          if (paramString.JAH.Zqc != null) {
            Log.i(HoneyPayProxyUI.this.TAG, "state: %s", new Object[] { Integer.valueOf(paramString.JAH.Zqc.state) });
          }
          HoneyPayProxyUI.a(HoneyPayProxyUI.this, paramString.JAH);
          HoneyPayProxyUI.this.finish();
          AppMethodBeat.o(64815);
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(64814);
          HoneyPayProxyUI.this.finish();
          AppMethodBeat.o(64814);
        }
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
      });
    }
    for (;;)
    {
      AppMethodBeat.o(64820);
      return true;
      if ((paramp instanceof m))
      {
        paramString = (m)paramp;
        paramString.a(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(64817);
            Log.i(HoneyPayProxyUI.this.TAG, "state: %s", new Object[] { Integer.valueOf(paramString.JAI.aatf.state) });
            if (paramString.JAI.aatf.state == 1) {
              HoneyPayProxyUI.a(HoneyPayProxyUI.this, paramString.JAI);
            }
            for (;;)
            {
              HoneyPayProxyUI.this.finish();
              AppMethodBeat.o(64817);
              return;
              HoneyPayProxyUI.b(HoneyPayProxyUI.this, paramString.JAI);
            }
          }
        }).b(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(64816);
            HoneyPayProxyUI.this.finish();
            AppMethodBeat.o(64816);
          }
        }).c(new r.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI
 * JD-Core Version:    0.7.0.1
 */