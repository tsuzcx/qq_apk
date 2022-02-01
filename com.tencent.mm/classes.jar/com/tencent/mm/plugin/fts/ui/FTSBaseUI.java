package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import java.util.List;

public abstract class FTSBaseUI
  extends MMActivity
  implements d.a, e, FTSEditTextView.a, a.b
{
  private TextView qHD;
  String query;
  private ap rsS = new ap()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111874);
      if ((paramAnonymousMessage.what == 1) && (!bt.isNullOrNil(FTSBaseUI.b(FTSBaseUI.this)))) {
        FTSBaseUI.this.cxN();
      }
      AppMethodBeat.o(111874);
    }
  };
  ListView rtA;
  private d rtB;
  private boolean rtC = false;
  com.tencent.mm.ui.search.a rtD;
  private String rtE = null;
  
  protected abstract d a(e parame);
  
  public void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    if (paramb == FTSEditTextView.b.Hlc)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.aaZ(paramString1);
      if ((!bt.isNullOrNil(this.query)) && (this.query.equals(paramString1))) {
        ad.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.query, paramString1 });
      }
    }
    else
    {
      return;
    }
    abu(paramString1);
  }
  
  protected void abu(String paramString)
  {
    if (!bt.isNullOrNil(paramString))
    {
      this.query = paramString;
      this.rsS.removeMessages(1);
      this.rsS.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  public final void af(int paramInt, boolean paramBoolean)
  {
    ad.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (paramInt > 0) {
        cxU();
      }
    }
    for (;;)
    {
      if (this.rtC)
      {
        this.rtC = false;
        this.rtA.setSelection(0);
      }
      return;
      cxT();
      continue;
      if (paramInt > 0) {
        cxU();
      } else {
        cxS();
      }
    }
  }
  
  public boolean bow()
  {
    hideVKB();
    this.rtD.getFtsEditText().sz.clearFocus();
    return false;
  }
  
  public final void cok() {}
  
  protected void cxN()
  {
    if (this.rtB == null) {
      return;
    }
    this.rtC = true;
    this.rtB.Zl(this.query);
    cxS();
  }
  
  protected void cxQ()
  {
    this.rtD = new com.tencent.mm.ui.search.a(this);
    this.rtD.setSearchViewListener(this);
    this.rtD.getFtsEditText().setHint(getHint());
    this.rtD.getFtsEditText().fdg();
    this.rtD.getFtsEditText().setFtsEditTextListener(this);
    this.rtD.getFtsEditText().setCanDeleteTag(false);
    getSupportActionBar().setCustomView(this.rtD);
    this.rtA = ((ListView)findViewById(2131304446));
    this.rtB = a(this);
    this.rtB.rtz = this;
    this.rtA.setAdapter(this.rtB);
    this.rtA.setOnScrollListener(this.rtB);
    this.rtA.setOnItemClickListener(this.rtB);
    this.rtA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111872);
        FTSBaseUI.a(FTSBaseUI.this).getFtsEditText().sz.clearFocus();
        FTSBaseUI.this.hideVKB();
        AppMethodBeat.o(111872);
        return false;
      }
    });
    this.qHD = ((TextView)findViewById(2131302885));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111873);
        FTSBaseUI.this.finish();
        AppMethodBeat.o(111873);
        return true;
      }
    });
  }
  
  protected void cxR() {}
  
  protected void cxS()
  {
    this.qHD.setVisibility(8);
    this.rtA.setVisibility(8);
  }
  
  protected void cxT()
  {
    this.qHD.setVisibility(0);
    TextView localTextView = this.qHD;
    String str1 = getString(2131762920);
    String str2 = getString(2131762919);
    String str3 = this.query;
    localTextView.setText(f.f(str1 + str3 + str2, str1.length(), str1.length() + str3.length()));
    this.rtA.setVisibility(8);
  }
  
  protected void cxU()
  {
    this.qHD.setVisibility(8);
    this.rtA.setVisibility(0);
  }
  
  protected void cxV()
  {
    this.qHD.setVisibility(8);
    this.rtA.setVisibility(8);
  }
  
  public String getHint()
  {
    if (this.rtE != null) {
      return this.rtE;
    }
    return getString(2131755882);
  }
  
  public final ListView getListView()
  {
    return this.rtA;
  }
  
  public final void lb(boolean paramBoolean) {}
  
  public void onClickBackBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickCancelBtn(View paramView) {}
  
  public void onClickClearTextBtn(View paramView)
  {
    stopSearch();
    this.rtD.getFtsEditText().fdj();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(ao.aD(getContext(), 2130968577));
    cxR();
    cxQ();
  }
  
  public void onDestroy()
  {
    this.rsS.removeMessages(1);
    this.rtB.finish();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setHint(String paramString)
  {
    this.rtE = paramString;
    this.rtD.getFtsEditText().setHint(getHint());
  }
  
  protected void stopSearch()
  {
    this.query = "";
    this.rsS.removeMessages(1);
    this.rtC = false;
    this.rtB.stopSearch();
    this.rtD.getFtsEditText().setHint(getHint());
    cxV();
  }
  
  protected final void t(String paramString, List<a.c> paramList)
  {
    this.query = paramString;
    this.rtD.getFtsEditText().J(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */