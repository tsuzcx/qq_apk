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
import com.tencent.mm.plugin.fts.ui.widget.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.r.b;
import java.util.Iterator;
import java.util.List;

@a(19)
public abstract class FTSBaseVoiceSearchUI
  extends MMActivity
  implements d.a, e, r.b
{
  String query;
  private ap rsS = new ap()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111877);
      if ((paramAnonymousMessage.what == 1) && (!bt.isNullOrNil(FTSBaseVoiceSearchUI.b(FTSBaseVoiceSearchUI.this)))) {
        FTSBaseVoiceSearchUI.this.cxN();
      }
      AppMethodBeat.o(111877);
    }
  };
  ListView rtA;
  private d rtB;
  private boolean rtC = false;
  protected c rtG;
  private boolean rtH = true;
  private boolean rtI;
  
  public boolean BX(String paramString)
  {
    ad.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[] { paramString });
    hideVKB();
    if (this.rtG != null) {
      this.rtG.clearFocus();
    }
    return false;
  }
  
  public void BY(String paramString)
  {
    ad.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      if (!this.rtG.fdw())
      {
        this.rtG.fdx();
        showVKB();
      }
      cxV();
    }
    paramString = com.tencent.mm.plugin.fts.a.d.aaZ(paramString);
    if ((!bt.isNullOrNil(this.query)) && (this.query.equals(paramString)))
    {
      ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[] { this.query, paramString });
      return;
    }
    this.query = paramString;
    if (!bt.isNullOrNil(this.query))
    {
      this.rsS.removeMessages(1);
      this.rsS.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  protected abstract d a(e parame);
  
  public final void aIj()
  {
    ad.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
    finish();
  }
  
  public final void aIk()
  {
    ad.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
  }
  
  public final void aIl() {}
  
  public final void aIm() {}
  
  public void af(int paramInt, boolean paramBoolean)
  {
    ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      cxZ();
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
      if (paramInt > 0)
      {
        cxU();
        cxY();
      }
      else
      {
        cxS();
        cxZ();
      }
    }
  }
  
  protected void cxN()
  {
    this.rtC = true;
    this.rtB.Zl(this.query);
    cxS();
  }
  
  protected void cxR() {}
  
  protected void cxS()
  {
    this.rtA.setVisibility(8);
  }
  
  protected void cxT()
  {
    this.rtA.setVisibility(8);
  }
  
  protected void cxU()
  {
    this.rtA.setVisibility(0);
  }
  
  protected void cxV()
  {
    this.rtA.setVisibility(8);
  }
  
  protected void cxW() {}
  
  protected List<View> cxX()
  {
    return null;
  }
  
  protected void cxY() {}
  
  protected void cxZ() {}
  
  protected View getHeaderView()
  {
    return null;
  }
  
  public final ListView getListView()
  {
    return this.rtA;
  }
  
  public final void lA(boolean paramBoolean)
  {
    ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "enableLV %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rtH = paramBoolean;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131100705));
    cxR();
    this.rtG = new c();
    this.rtG.Htp = this;
    this.rtG.ryj = false;
    this.rtA = ((ListView)findViewById(2131304446));
    if (getHeaderView() != null)
    {
      ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addHeaderView");
      this.rtA.addHeaderView(getHeaderView());
    }
    paramBundle = cxX();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      ad.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView %d", new Object[] { Integer.valueOf(paramBundle.size()) });
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        View localView = (View)paramBundle.next();
        this.rtA.addFooterView(localView);
      }
    }
    this.rtB = a(this);
    this.rtB.rtz = this;
    this.rtA.setAdapter(this.rtB);
    this.rtA.setOnScrollListener(this.rtB);
    this.rtA.setOnItemClickListener(this.rtB);
    this.rtA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111875);
        FTSBaseVoiceSearchUI.this.rtG.clearFocus();
        FTSBaseVoiceSearchUI.this.hideVKB();
        FTSBaseVoiceSearchUI.this.cxW();
        if (!FTSBaseVoiceSearchUI.a(FTSBaseVoiceSearchUI.this))
        {
          AppMethodBeat.o(111875);
          return true;
        }
        AppMethodBeat.o(111875);
        return false;
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
    this.rtG.a(this, paramMenu);
    if (!this.rtI)
    {
      this.rtG.wH(true);
      this.rtI = true;
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.rsS.removeMessages(1);
    this.rtB.finish();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.rtG.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.rtG.a(this, paramMenu);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void stopSearch()
  {
    this.rsS.removeMessages(1);
    this.rtC = false;
    this.rtB.stopSearch();
    cxV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
 * JD-Core Version:    0.7.0.1
 */