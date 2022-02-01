package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.ui.widget.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.r.b;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public abstract class FTSBaseVoiceSearchUI
  extends MMActivity
  implements d.a, e, r.b
{
  String query;
  ListView tJL;
  private d tJM;
  private boolean tJN = false;
  protected c tJR;
  private boolean tJS = true;
  private boolean tJT;
  private aq tJe = new aq()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111877);
      if ((paramAnonymousMessage.what == 1) && (!bu.isNullOrNil(FTSBaseVoiceSearchUI.b(FTSBaseVoiceSearchUI.this)))) {
        FTSBaseVoiceSearchUI.this.cVT();
      }
      AppMethodBeat.o(111877);
    }
  };
  
  public boolean JO(String paramString)
  {
    ae.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[] { paramString });
    hideVKB();
    if (this.tJR != null) {
      this.tJR.clearFocus();
    }
    return false;
  }
  
  public void JP(String paramString)
  {
    ae.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      if (!this.tJR.fOw())
      {
        this.tJR.fOx();
        showVKB();
      }
      cWd();
    }
    paramString = com.tencent.mm.plugin.fts.a.d.aln(paramString);
    if ((!bu.isNullOrNil(this.query)) && (this.query.equals(paramString)))
    {
      ae.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[] { this.query, paramString });
      return;
    }
    this.query = paramString;
    if (!bu.isNullOrNil(this.query))
    {
      this.tJe.removeMessages(1);
      this.tJe.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  protected abstract d a(e parame);
  
  public final void aSL()
  {
    ae.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
    finish();
  }
  
  public final void aSM()
  {
    ae.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
  }
  
  public final void aSN() {}
  
  public final void aSO() {}
  
  public void ap(int paramInt, boolean paramBoolean)
  {
    ae.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      cWj();
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
      if (paramInt > 0)
      {
        cWc();
        cWi();
      }
      else
      {
        cWa();
        cWj();
      }
    }
  }
  
  protected void cVT()
  {
    this.tJN = true;
    this.tJM.aiR(this.query);
    cWa();
  }
  
  protected void cVY() {}
  
  protected void cWa()
  {
    this.tJL.setVisibility(8);
  }
  
  protected void cWb()
  {
    this.tJL.setVisibility(8);
  }
  
  protected void cWc()
  {
    this.tJL.setVisibility(0);
  }
  
  protected void cWd()
  {
    this.tJL.setVisibility(8);
  }
  
  protected void cWg() {}
  
  protected List<View> cWh()
  {
    return null;
  }
  
  protected void cWi() {}
  
  protected void cWj() {}
  
  protected View getHeaderView()
  {
    return null;
  }
  
  public final ListView getListView()
  {
    return this.tJL;
  }
  
  public final void mN(boolean paramBoolean)
  {
    ae.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "enableLV %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tJS = paramBoolean;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131100705));
    cVY();
    this.tJR = new c();
    this.tJR.Lhk = this;
    this.tJR.tOL = false;
    this.tJL = ((ListView)findViewById(2131304446));
    if (getHeaderView() != null)
    {
      ae.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addHeaderView");
      this.tJL.addHeaderView(getHeaderView());
    }
    paramBundle = cWh();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      ae.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView %d", new Object[] { Integer.valueOf(paramBundle.size()) });
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        View localView = (View)paramBundle.next();
        this.tJL.addFooterView(localView);
      }
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
        AppMethodBeat.i(111875);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBaseVoiceSearchUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        FTSBaseVoiceSearchUI.this.tJR.clearFocus();
        FTSBaseVoiceSearchUI.this.hideVKB();
        FTSBaseVoiceSearchUI.this.cWg();
        if (!FTSBaseVoiceSearchUI.a(FTSBaseVoiceSearchUI.this)) {}
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/fts/ui/FTSBaseVoiceSearchUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(111875);
          return bool;
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111876);
        FTSBaseVoiceSearchUI.this.finish();
        AppMethodBeat.o(111876);
        return true;
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.tJR.a(this, paramMenu);
    if (!this.tJT)
    {
      this.tJR.yP(true);
      this.tJT = true;
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.tJe.removeMessages(1);
    this.tJM.finish();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.tJR.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.tJR.a(this, paramMenu);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void stopSearch()
  {
    this.tJe.removeMessages(1);
    this.tJN = false;
    this.tJM.stopSearch();
    cWd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
 * JD-Core Version:    0.7.0.1
 */