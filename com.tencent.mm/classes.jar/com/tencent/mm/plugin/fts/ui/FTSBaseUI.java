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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  private TextView sCU;
  ListView tJL;
  private d tJM;
  private boolean tJN = false;
  com.tencent.mm.ui.search.a tJO;
  private String tJP = null;
  private aq tJe = new aq()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111874);
      if ((paramAnonymousMessage.what == 1) && (!bu.isNullOrNil(FTSBaseUI.b(FTSBaseUI.this)))) {
        FTSBaseUI.this.cVT();
      }
      AppMethodBeat.o(111874);
    }
  };
  
  protected abstract d a(e parame);
  
  public void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    if (paramb == FTSEditTextView.b.KYW)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.aln(paramString1);
      if ((!bu.isNullOrNil(this.query)) && (this.query.equals(paramString1))) {
        ae.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.query, paramString1 });
      }
    }
    else
    {
      return;
    }
    alI(paramString1);
  }
  
  protected void alI(String paramString)
  {
    if (!bu.isNullOrNil(paramString))
    {
      this.query = paramString;
      this.tJe.removeMessages(1);
      this.tJe.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  public void ap(int paramInt, boolean paramBoolean)
  {
    ae.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (paramInt > 0) {
        cWc();
      }
    }
    for (;;)
    {
      if (this.tJN)
      {
        this.tJN = false;
        this.tJL.setSelection(0);
      }
      return;
      cWb();
      continue;
      if (paramInt > 0) {
        cWc();
      } else {
        cWa();
      }
    }
  }
  
  public boolean bAu()
  {
    hideVKB();
    this.tJO.getFtsEditText().vr.clearFocus();
    return false;
  }
  
  public final void cGz() {}
  
  protected void cVT()
  {
    if (this.tJM == null) {
      return;
    }
    this.tJN = true;
    this.tJM.aiR(this.query);
    cWa();
  }
  
  protected void cVW()
  {
    this.tJO = new com.tencent.mm.ui.search.a(this);
    this.tJO.setSearchViewListener(this);
    this.tJO.getFtsEditText().setHint(getHint());
    this.tJO.getFtsEditText().fOg();
    this.tJO.getFtsEditText().setFtsEditTextListener(this);
    this.tJO.getFtsEditText().setCanDeleteTag(false);
    getSupportActionBar().setCustomView(this.tJO);
    this.tJL = ((ListView)findViewById(2131304446));
    if (getFooterView() != null)
    {
      ae.i("MicroMsg.FTS.FTSBaseUI", "searchResultLV addFooterView");
      this.tJL.addFooterView(getFooterView());
    }
    this.tJM = a(this);
    this.tJM.tJK = this;
    this.tJL.setAdapter(this.tJM);
    this.tJL.setOnScrollListener(this.tJM);
    this.tJL.setOnItemClickListener(this.tJM);
    this.tJL.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111872);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBaseUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        FTSBaseUI.a(FTSBaseUI.this).getFtsEditText().vr.clearFocus();
        FTSBaseUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/fts/ui/FTSBaseUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(111872);
        return false;
      }
    });
    this.sCU = ((TextView)findViewById(2131302885));
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
  
  protected void cVY() {}
  
  protected final ListView cVZ()
  {
    return this.tJL;
  }
  
  protected void cWa()
  {
    this.sCU.setVisibility(8);
    this.tJL.setVisibility(8);
  }
  
  protected void cWb()
  {
    this.sCU.setVisibility(0);
    this.sCU.setText(f.a(getString(2131762920), getString(2131762919), this.query));
    this.tJL.setVisibility(8);
  }
  
  protected void cWc()
  {
    this.sCU.setVisibility(8);
    this.tJL.setVisibility(0);
  }
  
  protected void cWd()
  {
    this.sCU.setVisibility(8);
    this.tJL.setVisibility(8);
  }
  
  public final com.tencent.mm.ui.search.a cWe()
  {
    return this.tJO;
  }
  
  public final TextView cWf()
  {
    return this.sCU;
  }
  
  protected View getFooterView()
  {
    return null;
  }
  
  public String getHint()
  {
    if (this.tJP != null) {
      return this.tJP;
    }
    return getString(2131755882);
  }
  
  public final ListView getListView()
  {
    return this.tJL;
  }
  
  public final String getQuery()
  {
    return this.query;
  }
  
  public final void mb(boolean paramBoolean) {}
  
  public void onClickBackBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickCancelBtn(View paramView) {}
  
  public void onClickClearTextBtn(View paramView)
  {
    stopSearch();
    this.tJO.getFtsEditText().fOj();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131099648));
    cVY();
    cVW();
  }
  
  public void onDestroy()
  {
    this.tJe.removeMessages(1);
    this.tJM.finish();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setHint(String paramString)
  {
    this.tJP = paramString;
    this.tJO.getFtsEditText().setHint(getHint());
  }
  
  protected void stopSearch()
  {
    this.query = "";
    this.tJe.removeMessages(1);
    this.tJN = false;
    this.tJM.stopSearch();
    this.tJO.getFtsEditText().setHint(getHint());
    cWd();
  }
  
  protected final void u(String paramString, List<a.c> paramList)
  {
    this.query = paramString;
    this.tJO.getFtsEditText().I(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */