package com.tencent.mm.plugin.fts.ui;

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
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.xwebutil.c;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.WebViewKind;
import java.util.Iterator;
import java.util.List;

@a(19)
public abstract class FTSBaseVoiceSearchUI
  extends MMSecDataActivity
  implements d.a, e, s.c
{
  private MMHandler HwY = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(265612);
      if ((paramAnonymousMessage.what == 1) && (!Util.isNullOrNil(FTSBaseVoiceSearchUI.b(FTSBaseVoiceSearchUI.this)))) {
        FTSBaseVoiceSearchUI.this.fye();
      }
      AppMethodBeat.o(265612);
    }
  };
  private ListView Hyb;
  private d Hyc;
  private boolean Hyd = false;
  protected com.tencent.mm.plugin.fts.ui.widget.e Hyh;
  private boolean Hyi = true;
  private boolean Hyj;
  String query;
  
  public boolean SN(String paramString)
  {
    Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[] { paramString });
    hideVKB();
    if (this.Hyh != null) {
      this.Hyh.clearFocus();
    }
    return false;
  }
  
  public void SO(String paramString)
  {
    Log.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      if (!this.Hyh.jCL())
      {
        this.Hyh.jCM();
        showVKB();
      }
      fyn();
    }
    paramString = com.tencent.mm.plugin.fts.a.d.aEi(paramString);
    if ((!Util.isNullOrNil(this.query)) && (this.query.equals(paramString)))
    {
      Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[] { this.query, paramString });
      return;
    }
    this.query = paramString;
    if (!Util.isNullOrNil(this.query))
    {
      this.HwY.removeMessages(1);
      this.HwY.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    eui();
  }
  
  protected abstract d a(e parame);
  
  public final void bWw()
  {
    Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
    finish();
  }
  
  public final void bWx()
  {
    Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
  }
  
  public final void bWy() {}
  
  public final void bWz() {}
  
  public void ba(int paramInt, boolean paramBoolean)
  {
    Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      fyt();
      if (paramInt > 0) {
        fyo();
      }
    }
    for (;;)
    {
      if (this.Hyd)
      {
        this.Hyd = false;
        this.Hyb.setSelection(0);
      }
      return;
      fyp();
      continue;
      if (paramInt > 0)
      {
        fyo();
        fys();
      }
      else
      {
        fyq();
        fyt();
      }
    }
  }
  
  protected void eui()
  {
    this.HwY.removeMessages(1);
    this.Hyd = false;
    this.Hyc.eui();
    fyn();
  }
  
  protected void fye()
  {
    this.Hyd = true;
    this.Hyc.awg(this.query);
    fyq();
  }
  
  protected void fyk() {}
  
  protected void fyn()
  {
    this.Hyb.setVisibility(8);
  }
  
  protected void fyo()
  {
    this.Hyb.setVisibility(0);
  }
  
  protected void fyp()
  {
    this.Hyb.setVisibility(8);
  }
  
  protected void fyq()
  {
    this.Hyb.setVisibility(8);
  }
  
  protected List<View> fyr()
  {
    return null;
  }
  
  protected void fys() {}
  
  protected void fyt() {}
  
  protected void fyu() {}
  
  protected final ListView fyy()
  {
    return this.Hyb;
  }
  
  protected View getHeaderView()
  {
    return null;
  }
  
  public final ListView getListView()
  {
    return this.Hyb;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(p.a.normal_actionbar_color));
    fyk();
    if (!BuildInfo.IS_ARM64)
    {
      paramBundle = WebView.WebViewKind.aifI;
      c.a(paramBundle, new WebView.PreInitCallback()
      {
        public final void aDm()
        {
          AppMethodBeat.i(265599);
          Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onCoreInitFailed");
          AppMethodBeat.o(265599);
        }
        
        public final void onCoreInitFinished()
        {
          AppMethodBeat.i(265594);
          Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onCoreInitFinished");
          AppMethodBeat.o(265594);
        }
      });
      Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Start To Load WebView %s", new Object[] { paramBundle.name() });
    }
    this.Hyh = new com.tencent.mm.plugin.fts.ui.widget.e(this);
    this.Hyh.afKz = this;
    this.Hyh.HDD = o.fyA();
    this.Hyb = ((ListView)findViewById(p.d.search_result_lv));
    if (getHeaderView() != null)
    {
      Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addHeaderView");
      this.Hyb.addHeaderView(getHeaderView());
    }
    paramBundle = fyr();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView %d", new Object[] { Integer.valueOf(paramBundle.size()) });
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        View localView = (View)paramBundle.next();
        this.Hyb.addFooterView(localView);
      }
    }
    this.Hyc = a(this);
    this.Hyc.HxF = this;
    this.Hyb.setAdapter(this.Hyc);
    this.Hyb.setOnScrollListener(this.Hyc);
    this.Hyb.setOnItemClickListener(this.Hyc);
    this.Hyb.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(265608);
        FTSBaseVoiceSearchUI.this.Hyh.clearFocus();
        FTSBaseVoiceSearchUI.this.hideVKB();
        FTSBaseVoiceSearchUI.this.fyu();
        if (!FTSBaseVoiceSearchUI.a(FTSBaseVoiceSearchUI.this))
        {
          AppMethodBeat.o(265608);
          return true;
        }
        AppMethodBeat.o(265608);
        return false;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(265597);
        FTSBaseVoiceSearchUI.this.finish();
        AppMethodBeat.o(265597);
        return true;
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.Hyh.a(this, paramMenu);
    if (!this.Hyj)
    {
      this.Hyh.MY(true);
      this.Hyj = true;
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.HwY.removeMessages(1);
    this.Hyc.finish();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.Hyh.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.Hyh.a(this, paramMenu);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vO(boolean paramBoolean)
  {
    Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "enableLV %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Hyi = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
 * JD-Core Version:    0.7.0.1
 */