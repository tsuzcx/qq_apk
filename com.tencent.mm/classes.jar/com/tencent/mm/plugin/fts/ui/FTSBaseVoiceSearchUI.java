package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.q.b;

@a(19)
public abstract class FTSBaseVoiceSearchUI
  extends MMActivity
  implements d.a, e, q.b
{
  ListView mWK;
  private d mWL;
  TextView mWM;
  private boolean mWN = false;
  protected com.tencent.mm.plugin.fts.ui.widget.d mWR;
  private RelativeLayout mWS;
  private boolean mWT;
  private ak mWd = new FTSBaseVoiceSearchUI.3(this);
  String query;
  
  public void W(int paramInt, boolean paramBoolean)
  {
    ab.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      bCK();
      if (paramInt > 0) {
        bCH();
      }
    }
    for (;;)
    {
      if (this.mWN)
      {
        this.mWN = false;
        this.mWK.setSelection(0);
      }
      return;
      bCG();
      continue;
      if (paramInt > 0)
      {
        bCH();
        bCJ();
      }
      else
      {
        bCF();
        bCK();
      }
    }
  }
  
  protected abstract d a(e parame);
  
  public final void apN()
  {
    ab.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
    finish();
  }
  
  public final void apO()
  {
    ab.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
  }
  
  public final void apP() {}
  
  public final void apQ() {}
  
  protected void bCD() {}
  
  protected void bCF()
  {
    this.mWM.setVisibility(8);
    if (this.mWS != null) {
      this.mWS.setVisibility(8);
    }
    this.mWK.setVisibility(8);
  }
  
  protected void bCG()
  {
    this.mWM.setVisibility(0);
    this.mWM.setText(f.a(getString(2131302982), getString(2131302981), com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mSp);
    if (this.mWS != null) {
      this.mWS.setVisibility(8);
    }
    this.mWK.setVisibility(8);
  }
  
  protected void bCH()
  {
    this.mWM.setVisibility(8);
    if (this.mWS != null) {
      this.mWS.setVisibility(8);
    }
    this.mWK.setVisibility(0);
  }
  
  protected void bCI()
  {
    this.mWM.setVisibility(8);
    if (this.mWS != null) {
      this.mWS.setVisibility(8);
    }
    this.mWK.setVisibility(8);
  }
  
  protected void bCJ() {}
  
  protected void bCK() {}
  
  protected void bCz()
  {
    this.mWN = true;
    this.mWL.Pu(this.query);
    bCF();
  }
  
  protected View getFooterView()
  {
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131690316));
    bCD();
    this.mWR = new com.tencent.mm.plugin.fts.ui.widget.d();
    this.mWR.Axg = this;
    this.mWR.ncj = false;
    this.mWK = ((ListView)findViewById(2131824324));
    if (getFooterView() != null)
    {
      ab.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView");
      this.mWK.addFooterView(getFooterView());
    }
    this.mWL = a(this);
    this.mWL.mWJ = this;
    this.mWK.setAdapter(this.mWL);
    this.mWK.setOnScrollListener(this.mWL);
    this.mWK.setOnItemClickListener(this.mWL);
    this.mWK.setOnTouchListener(new FTSBaseVoiceSearchUI.1(this));
    this.mWM = ((TextView)findViewById(2131820917));
    setBackBtn(new FTSBaseVoiceSearchUI.2(this));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.mWR.a(this, paramMenu);
    if (!this.mWT)
    {
      this.mWR.ru(true);
      this.mWT = true;
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.mWd.removeMessages(1);
    this.mWL.finish();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mWR.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.mWR.a(this, paramMenu);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean wR(String paramString)
  {
    ab.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[] { paramString });
    hideVKB();
    if (this.mWR != null) {
      this.mWR.clearFocus();
    }
    return false;
  }
  
  public void wS(String paramString)
  {
    ab.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      if (!this.mWR.dNy())
      {
        this.mWR.dNz();
        showVKB();
      }
      bCI();
    }
    paramString = com.tencent.mm.plugin.fts.a.d.Pb(paramString);
    if ((!bo.isNullOrNil(this.query)) && (this.query.equals(paramString)))
    {
      ab.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[] { this.query, paramString });
      return;
    }
    this.query = paramString;
    if (!bo.isNullOrNil(this.query))
    {
      this.mWd.removeMessages(1);
      this.mWd.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    this.mWd.removeMessages(1);
    this.mWN = false;
    this.mWL.stopSearch();
    bCI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
 * JD-Core Version:    0.7.0.1
 */