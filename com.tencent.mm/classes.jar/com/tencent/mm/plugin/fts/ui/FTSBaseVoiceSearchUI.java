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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  private ao sBM = new ao()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111877);
      if ((paramAnonymousMessage.what == 1) && (!bs.isNullOrNil(FTSBaseVoiceSearchUI.b(FTSBaseVoiceSearchUI.this)))) {
        FTSBaseVoiceSearchUI.this.cKZ();
      }
      AppMethodBeat.o(111877);
    }
  };
  private boolean sCA = true;
  private boolean sCB;
  ListView sCt;
  private d sCu;
  private boolean sCv = false;
  protected c sCz;
  
  public boolean Ga(String paramString)
  {
    ac.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[] { paramString });
    hideVKB();
    if (this.sCz != null) {
      this.sCz.clearFocus();
    }
    return false;
  }
  
  public void Gb(String paramString)
  {
    ac.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      if (!this.sCz.ftr())
      {
        this.sCz.fts();
        showVKB();
      }
      cLh();
    }
    paramString = com.tencent.mm.plugin.fts.a.d.afR(paramString);
    if ((!bs.isNullOrNil(this.query)) && (this.query.equals(paramString)))
    {
      ac.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[] { this.query, paramString });
      return;
    }
    this.query = paramString;
    if (!bs.isNullOrNil(this.query))
    {
      this.sBM.removeMessages(1);
      this.sBM.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  protected abstract d a(e parame);
  
  public final void aPa()
  {
    ac.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
    finish();
  }
  
  public final void aPb()
  {
    ac.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
  }
  
  public final void aPc() {}
  
  public final void aPd() {}
  
  public void ai(int paramInt, boolean paramBoolean)
  {
    ac.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      cLl();
      if (paramInt > 0) {
        cLg();
      }
    }
    for (;;)
    {
      if (this.sCv)
      {
        this.sCv = false;
        this.sCt.setSelection(0);
      }
      return;
      cLf();
      continue;
      if (paramInt > 0)
      {
        cLg();
        cLk();
      }
      else
      {
        cLe();
        cLl();
      }
    }
  }
  
  protected void cKZ()
  {
    this.sCv = true;
    this.sCu.adT(this.query);
    cLe();
  }
  
  protected void cLd() {}
  
  protected void cLe()
  {
    this.sCt.setVisibility(8);
  }
  
  protected void cLf()
  {
    this.sCt.setVisibility(8);
  }
  
  protected void cLg()
  {
    this.sCt.setVisibility(0);
  }
  
  protected void cLh()
  {
    this.sCt.setVisibility(8);
  }
  
  protected void cLi() {}
  
  protected List<View> cLj()
  {
    return null;
  }
  
  protected void cLk() {}
  
  protected void cLl() {}
  
  protected View getHeaderView()
  {
    return null;
  }
  
  public final ListView getListView()
  {
    return this.sCt;
  }
  
  public final void ms(boolean paramBoolean)
  {
    ac.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "enableLV %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.sCA = paramBoolean;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131100705));
    cLd();
    this.sCz = new c();
    this.sCz.ITM = this;
    this.sCz.sHb = false;
    this.sCt = ((ListView)findViewById(2131304446));
    if (getHeaderView() != null)
    {
      ac.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addHeaderView");
      this.sCt.addHeaderView(getHeaderView());
    }
    paramBundle = cLj();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      ac.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView %d", new Object[] { Integer.valueOf(paramBundle.size()) });
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        View localView = (View)paramBundle.next();
        this.sCt.addFooterView(localView);
      }
    }
    this.sCu = a(this);
    this.sCu.sCs = this;
    this.sCt.setAdapter(this.sCu);
    this.sCt.setOnScrollListener(this.sCu);
    this.sCt.setOnItemClickListener(this.sCu);
    this.sCt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111875);
        FTSBaseVoiceSearchUI.this.sCz.clearFocus();
        FTSBaseVoiceSearchUI.this.hideVKB();
        FTSBaseVoiceSearchUI.this.cLi();
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
    this.sCz.a(this, paramMenu);
    if (!this.sCB)
    {
      this.sCz.xO(true);
      this.sCB = true;
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.sBM.removeMessages(1);
    this.sCu.finish();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.sCz.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.sCz.a(this, paramMenu);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void stopSearch()
  {
    this.sBM.removeMessages(1);
    this.sCv = false;
    this.sCu.stopSearch();
    cLh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
 * JD-Core Version:    0.7.0.1
 */