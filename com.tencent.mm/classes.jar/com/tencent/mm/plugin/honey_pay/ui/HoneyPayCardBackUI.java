package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.honey_pay.a.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ejt;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayCardBackUI
  extends HoneyPayBaseUI
{
  private CdnImageView JAR;
  private WalletTextView JAS;
  private TextView JAT;
  private TextView JAU;
  private TextView JAV;
  private String JAW;
  private fnr JAX;
  
  public int getLayoutId()
  {
    return a.g.honey_pay_card_back_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64664);
    this.JAR = ((CdnImageView)findViewById(a.f.hpcb_avatar_iv));
    this.JAS = ((WalletTextView)findViewById(a.f.hpcb_quota_remained_tv));
    this.JAT = ((TextView)findViewById(a.f.hpcb_quota_tv));
    this.JAU = ((TextView)findViewById(a.f.hpcb_card_type_name_tv));
    this.JAV = ((TextView)findViewById(a.f.hpcb_desc_tv));
    this.JAS.setPrefix(ai.jOX());
    AppMethodBeat.o(64664);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64667);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      Log.i(this.TAG, "unbind success");
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(64667);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64663);
    this.GRg = a.c.honey_pay_orange;
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
    this.JAW = getIntent().getStringExtra("key_card_no");
    initView();
    Log.i(this.TAG, "do qry card detail: %s", new Object[] { this.JAW });
    paramBundle = new k(this.JAW);
    paramBundle.r(this);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(64666);
    if ((paramp instanceof k))
    {
      paramString = (k)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(64662);
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.JAG.aaqT);
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.JAG);
          AppMethodBeat.o(64662);
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI
 * JD-Core Version:    0.7.0.1
 */