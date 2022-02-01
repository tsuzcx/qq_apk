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
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayCardBackUI
  extends HoneyPayBaseUI
{
  private CdnImageView svf;
  private WalletTextView svg;
  private TextView svh;
  private TextView svi;
  private TextView svj;
  private String svk;
  private dcl svl;
  
  public int getLayoutId()
  {
    return 2131494437;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64664);
    this.svf = ((CdnImageView)findViewById(2131300767));
    this.svg = ((WalletTextView)findViewById(2131300771));
    this.svh = ((TextView)findViewById(2131300772));
    this.svi = ((TextView)findViewById(2131300768));
    this.svj = ((TextView)findViewById(2131300770));
    this.svg.setPrefix(ah.fkg());
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
    this.svd = 2131100494;
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
    this.svk = getIntent().getStringExtra("key_card_no");
    initView();
    ad.i(this.TAG, "do qry card detail: %s", new Object[] { this.svk });
    paramBundle = new k(this.svk);
    paramBundle.q(this);
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
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.suT.DsY);
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.suT);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI
 * JD-Core Version:    0.7.0.1
 */