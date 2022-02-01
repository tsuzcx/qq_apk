package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import java.util.Iterator;
import java.util.List;

@a(19)
public abstract class FTSBaseVoiceSearchUI
  extends MMSecDataActivity
  implements d.a, e, t.b
{
  private ListView BMK;
  private d BML;
  private boolean BMM = false;
  protected com.tencent.mm.plugin.fts.ui.widget.c BMQ;
  private boolean BMR = true;
  private boolean BMS;
  private MMHandler BMc = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(191878);
      if ((paramAnonymousMessage.what == 1) && (!Util.isNullOrNil(FTSBaseVoiceSearchUI.b(FTSBaseVoiceSearchUI.this)))) {
        FTSBaseVoiceSearchUI.this.erw();
      }
      AppMethodBeat.o(191878);
    }
  };
  String query;
  
  protected abstract d a(e parame);
  
  public void aC(int paramInt, boolean paramBoolean)
  {
    Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      erO();
      if (paramInt > 0) {
        erH();
      }
    }
    for (;;)
    {
      if (this.BMM)
      {
        this.BMM = false;
        this.BMK.setSelection(0);
      }
      return;
      erG();
      continue;
      if (paramInt > 0)
      {
        erH();
        erN();
      }
      else
      {
        erF();
        erO();
      }
    }
  }
  
  public boolean aat(String paramString)
  {
    Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[] { paramString });
    hideVKB();
    if (this.BMQ != null) {
      this.BMQ.clearFocus();
    }
    return false;
  }
  
  public void aau(String paramString)
  {
    Log.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      if (!this.BMQ.hYb())
      {
        this.BMQ.hYc();
        showVKB();
      }
      erI();
    }
    paramString = com.tencent.mm.plugin.fts.a.d.aHK(paramString);
    if ((!Util.isNullOrNil(this.query)) && (this.query.equals(paramString)))
    {
      Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[] { this.query, paramString });
      return;
    }
    this.query = paramString;
    if (!Util.isNullOrNil(this.query))
    {
      this.BMc.removeMessages(1);
      this.BMc.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    erx();
  }
  
  public final void bxH()
  {
    Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
    finish();
  }
  
  public final void bxI()
  {
    Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
  }
  
  public final void bxJ() {}
  
  public final void bxK() {}
  
  protected void erD() {}
  
  protected final ListView erE()
  {
    return this.BMK;
  }
  
  protected void erF()
  {
    this.BMK.setVisibility(8);
  }
  
  protected void erG()
  {
    this.BMK.setVisibility(8);
  }
  
  protected void erH()
  {
    this.BMK.setVisibility(0);
  }
  
  protected void erI()
  {
    this.BMK.setVisibility(8);
  }
  
  protected void erL() {}
  
  protected List<View> erM()
  {
    return null;
  }
  
  protected void erN() {}
  
  protected void erO() {}
  
  protected void erw()
  {
    this.BMM = true;
    this.BML.aEi(this.query);
    erF();
  }
  
  protected void erx()
  {
    this.BMc.removeMessages(1);
    this.BMM = false;
    this.BML.erx();
    erI();
  }
  
  protected View getHeaderView()
  {
    return null;
  }
  
  public final ListView getListView()
  {
    return this.BMK;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(o.a.normal_actionbar_color));
    erD();
    if (!BuildInfo.IS_ARM64)
    {
      paramBundle = WebView.c.aabm;
      com.tencent.mm.xwebutil.c.a(paramBundle, new WebView.PreInitCallback()
      {
        public final void bEj()
        {
          AppMethodBeat.i(193594);
          Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onCoreInitFailed");
          AppMethodBeat.o(193594);
        }
        
        public final void onCoreInitFinished()
        {
          AppMethodBeat.i(193592);
          Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onCoreInitFinished");
          AppMethodBeat.o(193592);
        }
      });
      Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Start To Load WebView %s", new Object[] { paramBundle.name() });
    }
    this.BMQ = new com.tencent.mm.plugin.fts.ui.widget.c();
    this.BMQ.XUl = this;
    this.BMQ.BRU = false;
    this.BMK = ((ListView)findViewById(o.d.search_result_lv));
    if (getHeaderView() != null)
    {
      Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addHeaderView");
      this.BMK.addHeaderView(getHeaderView());
    }
    paramBundle = erM();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView %d", new Object[] { Integer.valueOf(paramBundle.size()) });
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        View localView = (View)paramBundle.next();
        this.BMK.addFooterView(localView);
      }
    }
    this.BML = a(this);
    this.BML.BMJ = this;
    this.BMK.setAdapter(this.BML);
    this.BMK.setOnScrollListener(this.BML);
    this.BMK.setOnItemClickListener(this.BML);
    this.BMK.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(190685);
        FTSBaseVoiceSearchUI.this.BMQ.clearFocus();
        FTSBaseVoiceSearchUI.this.hideVKB();
        FTSBaseVoiceSearchUI.this.erL();
        if (!FTSBaseVoiceSearchUI.a(FTSBaseVoiceSearchUI.this))
        {
          AppMethodBeat.o(190685);
          return true;
        }
        AppMethodBeat.o(190685);
        return false;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(189500);
        FTSBaseVoiceSearchUI.this.finish();
        AppMethodBeat.o(189500);
        return true;
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.BMQ.a(this, paramMenu);
    if (!this.BMS)
    {
      this.BMQ.He(true);
      this.BMS = true;
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.BMc.removeMessages(1);
    this.BML.finish();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.BMQ.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.BMQ.a(this, paramMenu);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rP(boolean paramBoolean)
  {
    Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "enableLV %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.BMR = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
 * JD-Core Version:    0.7.0.1
 */