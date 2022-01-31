package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract class FTSBaseUI
  extends MMActivity
  implements d.a, e, FTSEditTextView.a, a.b
{
  ListView mWK;
  private d mWL;
  private TextView mWM;
  private boolean mWN = false;
  com.tencent.mm.plugin.fts.ui.widget.a mWO;
  private String mWP = null;
  private ak mWd = new FTSBaseUI.3(this);
  String query;
  
  protected void Pv(String paramString)
  {
    if (!bo.isNullOrNil(paramString))
    {
      this.query = paramString;
      this.mWd.removeMessages(1);
      this.mWd.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  public final void W(int paramInt, boolean paramBoolean)
  {
    ab.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
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
      if (paramInt > 0) {
        bCH();
      } else {
        bCF();
      }
    }
  }
  
  protected abstract d a(e parame);
  
  public void a(com.tencent.mm.plugin.fts.a.d.a.a parama) {}
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    if (paramb == FTSEditTextView.b.naZ)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.Pb(paramString1);
      if ((!bo.isNullOrNil(this.query)) && (this.query.equals(paramString1))) {
        ab.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.query, paramString1 });
      }
    }
    else
    {
      return;
    }
    Pv(paramString1);
  }
  
  public boolean aMm()
  {
    hideVKB();
    this.mWO.getFtsEditText().naN.clearFocus();
    return false;
  }
  
  protected void bCC()
  {
    this.mWO = new com.tencent.mm.plugin.fts.ui.widget.a(this);
    this.mWO.setSearchViewListener(this);
    this.mWO.getFtsEditText().setHint(getHint());
    this.mWO.getFtsEditText().setFtsEditTextListener(this);
    this.mWO.getFtsEditText().setCanDeleteTag(false);
    getSupportActionBar().setCustomView(this.mWO);
    this.mWK = ((ListView)findViewById(2131824324));
    this.mWL = a(this);
    this.mWL.mWJ = this;
    this.mWK.setAdapter(this.mWL);
    this.mWK.setOnScrollListener(this.mWL);
    this.mWK.setOnItemClickListener(this.mWL);
    this.mWK.setOnTouchListener(new FTSBaseUI.1(this));
    this.mWM = ((TextView)findViewById(2131820917));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(61780);
        FTSBaseUI.this.finish();
        AppMethodBeat.o(61780);
        return true;
      }
    });
  }
  
  protected void bCD() {}
  
  public final void bCE() {}
  
  protected void bCF()
  {
    this.mWM.setVisibility(8);
    this.mWK.setVisibility(8);
  }
  
  protected void bCG()
  {
    this.mWM.setVisibility(0);
    this.mWM.setText(f.a(getString(2131302982), getString(2131302981), com.tencent.mm.plugin.fts.a.a.d.b(this.query, this.query)).mSp);
    this.mWK.setVisibility(8);
  }
  
  protected void bCH()
  {
    this.mWM.setVisibility(8);
    this.mWK.setVisibility(0);
  }
  
  protected void bCI()
  {
    this.mWM.setVisibility(8);
    this.mWK.setVisibility(8);
  }
  
  protected void bCz()
  {
    if (this.mWL == null) {
      return;
    }
    this.mWN = true;
    this.mWL.Pu(this.query);
    bCF();
  }
  
  public String getHint()
  {
    if (this.mWP != null) {
      return this.mWP;
    }
    return getString(2131297065);
  }
  
  public final void hQ(boolean paramBoolean) {}
  
  protected final void m(String paramString, List<a.c> paramList)
  {
    this.query = paramString;
    this.mWO.getFtsEditText().o(paramString, paramList);
  }
  
  public void onClickBackBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickCancelBtn(View paramView) {}
  
  public void onClickClearTextBtn(View paramView)
  {
    stopSearch();
    this.mWO.getFtsEditText().bDf();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(b.m(getContext(), 2131690316));
    bCD();
    bCC();
  }
  
  public void onDestroy()
  {
    this.mWd.removeMessages(1);
    this.mWL.finish();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setHint(String paramString)
  {
    this.mWP = paramString;
    this.mWO.getFtsEditText().setHint(getHint());
  }
  
  protected void stopSearch()
  {
    this.query = "";
    this.mWd.removeMessages(1);
    this.mWN = false;
    this.mWL.stopSearch();
    this.mWO.getFtsEditText().setHint(getHint());
    bCI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */