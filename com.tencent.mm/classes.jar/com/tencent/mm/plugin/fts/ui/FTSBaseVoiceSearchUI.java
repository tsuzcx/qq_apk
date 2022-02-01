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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  ListView tyU;
  private d tyV;
  private boolean tyW = false;
  private ap tyn = new ap()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111877);
      if ((paramAnonymousMessage.what == 1) && (!bt.isNullOrNil(FTSBaseVoiceSearchUI.b(FTSBaseVoiceSearchUI.this)))) {
        FTSBaseVoiceSearchUI.this.cTo();
      }
      AppMethodBeat.o(111877);
    }
  };
  protected c tza;
  private boolean tzb = true;
  private boolean tzc;
  
  public boolean Jp(String paramString)
  {
    ad.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[] { paramString });
    hideVKB();
    if (this.tza != null) {
      this.tza.clearFocus();
    }
    return false;
  }
  
  public void Jq(String paramString)
  {
    ad.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      if (!this.tza.fKf())
      {
        this.tza.fKg();
        showVKB();
      }
      cTy();
    }
    paramString = com.tencent.mm.plugin.fts.a.d.akp(paramString);
    if ((!bt.isNullOrNil(this.query)) && (this.query.equals(paramString)))
    {
      ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[] { this.query, paramString });
      return;
    }
    this.query = paramString;
    if (!bt.isNullOrNil(this.query))
    {
      this.tyn.removeMessages(1);
      this.tyn.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  protected abstract d a(e parame);
  
  public final void aSm()
  {
    ad.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
    finish();
  }
  
  public final void aSn()
  {
    ad.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
  }
  
  public final void aSo() {}
  
  public final void aSp() {}
  
  public void am(int paramInt, boolean paramBoolean)
  {
    ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      cTE();
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
      if (paramInt > 0)
      {
        cTx();
        cTD();
      }
      else
      {
        cTv();
        cTE();
      }
    }
  }
  
  protected void cTB() {}
  
  protected List<View> cTC()
  {
    return null;
  }
  
  protected void cTD() {}
  
  protected void cTE() {}
  
  protected void cTo()
  {
    this.tyW = true;
    this.tyV.ahT(this.query);
    cTv();
  }
  
  protected void cTt() {}
  
  protected void cTv()
  {
    this.tyU.setVisibility(8);
  }
  
  protected void cTw()
  {
    this.tyU.setVisibility(8);
  }
  
  protected void cTx()
  {
    this.tyU.setVisibility(0);
  }
  
  protected void cTy()
  {
    this.tyU.setVisibility(8);
  }
  
  protected View getHeaderView()
  {
    return null;
  }
  
  public final ListView getListView()
  {
    return this.tyU;
  }
  
  public final void mJ(boolean paramBoolean)
  {
    ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "enableLV %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tzb = paramBoolean;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131100705));
    cTt();
    this.tza = new c();
    this.tza.KKQ = this;
    this.tza.tDU = false;
    this.tyU = ((ListView)findViewById(2131304446));
    if (getHeaderView() != null)
    {
      ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addHeaderView");
      this.tyU.addHeaderView(getHeaderView());
    }
    paramBundle = cTC();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView %d", new Object[] { Integer.valueOf(paramBundle.size()) });
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        View localView = (View)paramBundle.next();
        this.tyU.addFooterView(localView);
      }
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
        AppMethodBeat.i(111875);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBaseVoiceSearchUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        FTSBaseVoiceSearchUI.this.tza.clearFocus();
        FTSBaseVoiceSearchUI.this.hideVKB();
        FTSBaseVoiceSearchUI.this.cTB();
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
    this.tza.a(this, paramMenu);
    if (!this.tzc)
    {
      this.tza.yC(true);
      this.tzc = true;
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.tyn.removeMessages(1);
    this.tyV.finish();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.tza.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.tza.a(this, paramMenu);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void stopSearch()
  {
    this.tyn.removeMessages(1);
    this.tyW = false;
    this.tyV.stopSearch();
    cTy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
 * JD-Core Version:    0.7.0.1
 */