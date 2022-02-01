package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
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
  String query = "";
  private TextView ssK;
  ListView tyU;
  private d tyV;
  private boolean tyW = false;
  com.tencent.mm.ui.search.a tyX;
  private String tyY = null;
  private ap tyn = new ap()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111874);
      if ((paramAnonymousMessage.what == 1) && (!bt.isNullOrNil(FTSBaseUI.b(FTSBaseUI.this)))) {
        FTSBaseUI.this.cTo();
      }
      AppMethodBeat.o(111874);
    }
  };
  
  protected abstract d a(e parame);
  
  public void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    if (paramb == FTSEditTextView.b.KCC)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.akp(paramString1);
      if ((!bt.isNullOrNil(this.query)) && (this.query.equals(paramString1))) {
        ad.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.query, paramString1 });
      }
    }
    else
    {
      return;
    }
    akK(paramString1);
  }
  
  protected void akK(String paramString)
  {
    if (!bt.isNullOrNil(paramString))
    {
      this.query = paramString;
      this.tyn.removeMessages(1);
      this.tyn.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  public void am(int paramInt, boolean paramBoolean)
  {
    ad.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (paramInt > 0) {
        cTx();
      }
    }
    for (;;)
    {
      if (this.tyW)
      {
        this.tyW = false;
        this.tyU.setSelection(0);
      }
      return;
      cTw();
      continue;
      if (paramInt > 0) {
        cTx();
      } else {
        cTv();
      }
    }
  }
  
  public boolean bzz()
  {
    hideVKB();
    this.tyX.getFtsEditText().vr.clearFocus();
    return false;
  }
  
  public final void cED() {}
  
  public final TextView cTA()
  {
    return this.ssK;
  }
  
  protected void cTo()
  {
    if (this.tyV == null) {
      return;
    }
    this.tyW = true;
    this.tyV.ahT(this.query);
    cTv();
  }
  
  protected void cTr()
  {
    this.tyX = new com.tencent.mm.ui.search.a(this);
    this.tyX.setSearchViewListener(this);
    this.tyX.getFtsEditText().setHint(getHint());
    this.tyX.getFtsEditText().fJP();
    this.tyX.getFtsEditText().setFtsEditTextListener(this);
    this.tyX.getFtsEditText().setCanDeleteTag(false);
    getSupportActionBar().setCustomView(this.tyX);
    this.tyU = ((ListView)findViewById(2131304446));
    if (getFooterView() != null)
    {
      ad.i("MicroMsg.FTS.FTSBaseUI", "searchResultLV addFooterView");
      this.tyU.addFooterView(getFooterView());
    }
    this.tyV = a(this);
    this.tyV.tyT = this;
    this.tyU.setAdapter(this.tyV);
    this.tyU.setOnScrollListener(this.tyV);
    this.tyU.setOnItemClickListener(this.tyV);
    this.tyU.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111872);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBaseUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        FTSBaseUI.a(FTSBaseUI.this).getFtsEditText().vr.clearFocus();
        FTSBaseUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/fts/ui/FTSBaseUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(111872);
        return false;
      }
    });
    this.ssK = ((TextView)findViewById(2131302885));
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
  
  protected void cTt() {}
  
  protected final ListView cTu()
  {
    return this.tyU;
  }
  
  protected void cTv()
  {
    this.ssK.setVisibility(8);
    this.tyU.setVisibility(8);
  }
  
  protected void cTw()
  {
    this.ssK.setVisibility(0);
    this.ssK.setText(f.a(getString(2131762920), getString(2131762919), this.query));
    this.tyU.setVisibility(8);
  }
  
  protected void cTx()
  {
    this.ssK.setVisibility(8);
    this.tyU.setVisibility(0);
  }
  
  protected void cTy()
  {
    this.ssK.setVisibility(8);
    this.tyU.setVisibility(8);
  }
  
  public final com.tencent.mm.ui.search.a cTz()
  {
    return this.tyX;
  }
  
  protected View getFooterView()
  {
    return null;
  }
  
  public String getHint()
  {
    if (this.tyY != null) {
      return this.tyY;
    }
    return getString(2131755882);
  }
  
  public final ListView getListView()
  {
    return this.tyU;
  }
  
  public final String getQuery()
  {
    return this.query;
  }
  
  public final void ma(boolean paramBoolean) {}
  
  public void onClickBackBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickCancelBtn(View paramView) {}
  
  public void onClickClearTextBtn(View paramView)
  {
    stopSearch();
    this.tyX.getFtsEditText().fJS();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131099648));
    cTt();
    cTr();
  }
  
  public void onDestroy()
  {
    this.tyn.removeMessages(1);
    this.tyV.finish();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setHint(String paramString)
  {
    this.tyY = paramString;
    this.tyX.getFtsEditText().setHint(getHint());
  }
  
  protected void stopSearch()
  {
    this.query = "";
    this.tyn.removeMessages(1);
    this.tyW = false;
    this.tyV.stopSearch();
    this.tyX.getFtsEditText().setHint(getHint());
    cTy();
  }
  
  protected final void t(String paramString, List<a.c> paramList)
  {
    this.query = paramString;
    this.tyX.getFtsEditText().H(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */