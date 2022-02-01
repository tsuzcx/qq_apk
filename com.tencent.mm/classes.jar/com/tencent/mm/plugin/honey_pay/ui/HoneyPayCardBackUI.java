package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.honey_pay.a.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.dnn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayCardBackUI
  extends HoneyPayBaseUI
{
  private CdnImageView uFD;
  private WalletTextView uFE;
  private TextView uFF;
  private TextView uFG;
  private TextView uFH;
  private String uFI;
  private dnn uFJ;
  
  public int getLayoutId()
  {
    return 2131494437;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64664);
    this.uFD = ((CdnImageView)findViewById(2131300767));
    this.uFE = ((WalletTextView)findViewById(2131300771));
    this.uFF = ((TextView)findViewById(2131300772));
    this.uFG = ((TextView)findViewById(2131300768));
    this.uFH = ((TextView)findViewById(2131300770));
    this.uFE.setPrefix(ah.fRG());
    AppMethodBeat.o(64664);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64667);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      ad.i(this.TAG, "unbind success");
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(64667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64663);
    this.uFB = 2131100494;
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64661);
        HoneyPayCardBackUI.this.hideVKB();
        HoneyPayCardBackUI.this.hideTenpayKB();
        HoneyPayCardBackUI.this.finish();
        AppMethodBeat.o(64661);
        return false;
      }
    });
    addSceneEndListener(2851);
    this.uFI = getIntent().getStringExtra("key_card_no");
    initView();
    ad.i(this.TAG, "do qry card detail: %s", new Object[] { this.uFI });
    paramBundle = new k(this.uFI);
    paramBundle.t(this);
    doSceneProgress(paramBundle, true);
    AppMethodBeat.o(64663);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64665);
    super.onDestroy();
    removeSceneEndListener(2851);
    AppMethodBeat.o(64665);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(64666);
    if ((paramn instanceof k))
    {
      paramString = (k)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(64662);
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.uFr.Gxg);
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.uFr);
          AppMethodBeat.o(64662);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn) {}
      });
    }
    AppMethodBeat.o(64666);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI
 * JD-Core Version:    0.7.0.1
 */