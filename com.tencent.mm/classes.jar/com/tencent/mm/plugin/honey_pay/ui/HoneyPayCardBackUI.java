package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.honey_pay.a.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayCardBackUI
  extends HoneyPayBaseUI
{
  private CdnImageView yjT;
  private WalletTextView yjU;
  private TextView yjV;
  private TextView yjW;
  private TextView yjX;
  private String yjY;
  private eig yjZ;
  
  public int getLayoutId()
  {
    return 2131495015;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64664);
    this.yjT = ((CdnImageView)findViewById(2131302361));
    this.yjU = ((WalletTextView)findViewById(2131302365));
    this.yjV = ((TextView)findViewById(2131302366));
    this.yjW = ((TextView)findViewById(2131302362));
    this.yjX = ((TextView)findViewById(2131302364));
    this.yjU.setPrefix(ah.hhz());
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
    this.wwG = 2131100598;
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
    this.yjY = getIntent().getStringExtra("key_card_no");
    initView();
    Log.i(this.TAG, "do qry card detail: %s", new Object[] { this.yjY });
    paramBundle = new k(this.yjY);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64666);
    if ((paramq instanceof k))
    {
      paramString = (k)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(64662);
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.yjI.LUW);
          HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, paramString.yjI);
          AppMethodBeat.o(64662);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq) {}
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