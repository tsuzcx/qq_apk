package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayCardBackUI
  extends HoneyPayBaseUI
{
  private WalletTextView nHA;
  private TextView nHB;
  private TextView nHC;
  private TextView nHD;
  private String nHE;
  private ckm nHF;
  private CdnImageView nHz;
  
  public int getLayoutId()
  {
    return 2130969860;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41774);
    this.nHz = ((CdnImageView)findViewById(2131824979));
    this.nHA = ((WalletTextView)findViewById(2131824982));
    this.nHB = ((TextView)findViewById(2131824983));
    this.nHC = ((TextView)findViewById(2131824980));
    this.nHD = ((TextView)findViewById(2131824981));
    this.nHA.setPrefix(ae.dSz());
    AppMethodBeat.o(41774);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41777);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      ab.i(this.TAG, "unbind success");
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(41777);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41773);
    this.nHx = 2131690172;
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn(new HoneyPayCardBackUI.1(this));
    addSceneEndListener(2851);
    this.nHE = getIntent().getStringExtra("key_card_no");
    initView();
    ab.i(this.TAG, "do qry card detail: %s", new Object[] { this.nHE });
    paramBundle = new k(this.nHE);
    paramBundle.o(this);
    doSceneProgress(paramBundle, true);
    AppMethodBeat.o(41773);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41775);
    super.onDestroy();
    removeSceneEndListener(2851);
    AppMethodBeat.o(41775);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41776);
    if ((paramm instanceof k))
    {
      paramString = (k)paramm;
      paramString.a(new HoneyPayCardBackUI.4(this, paramString)).b(new HoneyPayCardBackUI.3(this)).c(new HoneyPayCardBackUI.2(this));
    }
    AppMethodBeat.o(41776);
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