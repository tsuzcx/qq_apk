package com.tencent.mm.plugin.fts.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.widget.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n.b;

@a(19)
public abstract class FTSBaseVoiceSearchUI
  extends MMActivity
  implements d.a, e, n.b
{
  String bVk;
  ListView kAS;
  private d kAT;
  TextView kAU;
  private boolean kAV = false;
  protected b kAZ;
  private ah kAl = new FTSBaseVoiceSearchUI.3(this);
  private RelativeLayout kBa;
  private boolean kBb;
  
  public void O(int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      aWh();
      if (paramInt > 0) {
        aWe();
      }
    }
    for (;;)
    {
      if (this.kAV)
      {
        this.kAV = false;
        this.kAS.setSelection(0);
      }
      return;
      aWd();
      continue;
      if (paramInt > 0)
      {
        aWe();
        aWg();
      }
      else
      {
        aWc();
        aWh();
      }
    }
  }
  
  public final void Wl()
  {
    y.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
    finish();
  }
  
  public final void Wm()
  {
    y.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
  }
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  protected abstract d a(e parame);
  
  protected View aBq()
  {
    return null;
  }
  
  protected void aVW()
  {
    this.kAV = true;
    this.kAT.Ej(this.bVk);
    aWc();
  }
  
  protected void aWa() {}
  
  protected void aWc()
  {
    this.kAU.setVisibility(8);
    if (this.kBa != null) {
      this.kBa.setVisibility(8);
    }
    this.kAS.setVisibility(8);
  }
  
  protected void aWd()
  {
    this.kAU.setVisibility(0);
    this.kAU.setText(f.a(getString(n.g.search_contact_no_result_pre), getString(n.g.search_contact_no_result_post), com.tencent.mm.plugin.fts.a.a.d.b(this.bVk, this.bVk)).kwz);
    if (this.kBa != null) {
      this.kBa.setVisibility(8);
    }
    this.kAS.setVisibility(8);
  }
  
  protected void aWe()
  {
    this.kAU.setVisibility(8);
    if (this.kBa != null) {
      this.kBa.setVisibility(8);
    }
    this.kAS.setVisibility(0);
  }
  
  protected void aWf()
  {
    this.kAU.setVisibility(8);
    if (this.kBa != null) {
      this.kBa.setVisibility(8);
    }
    this.kAS.setVisibility(8);
  }
  
  protected void aWg() {}
  
  protected void aWh() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    czr();
    setMMTitle("");
    ta(this.mController.uMN.getResources().getColor(n.a.normal_actionbar_color));
    aWa();
    this.kAZ = new b();
    this.kAZ.weq = this;
    this.kAZ.kFw = false;
    this.kAS = ((ListView)findViewById(n.d.search_result_lv));
    if (aBq() != null)
    {
      y.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView");
      this.kAS.addFooterView(aBq());
    }
    this.kAT = a(this);
    this.kAT.kAR = this;
    this.kAS.setAdapter(this.kAT);
    this.kAS.setOnScrollListener(this.kAT);
    this.kAS.setOnItemClickListener(this.kAT);
    this.kAS.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        FTSBaseVoiceSearchUI.this.kAZ.clearFocus();
        FTSBaseVoiceSearchUI.this.XM();
        return false;
      }
    });
    this.kAU = ((TextView)findViewById(n.d.no_result_view));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        FTSBaseVoiceSearchUI.this.finish();
        return true;
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.kAZ.a(this, paramMenu);
    if (!this.kBb)
    {
      this.kAZ.nK(true);
      this.kBb = true;
    }
    return true;
  }
  
  protected void onDestroy()
  {
    this.kAl.removeMessages(1);
    this.kAT.finish();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.kAZ.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.kAZ.a(this, paramMenu);
    return true;
  }
  
  public boolean pB(String paramString)
  {
    y.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[] { paramString });
    XM();
    if (this.kAZ != null) {
      this.kAZ.clearFocus();
    }
    return false;
  }
  
  public void pC(String paramString)
  {
    y.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[] { paramString });
    if (bk.bl(paramString))
    {
      if (!this.kAZ.cIK())
      {
        this.kAZ.cIL();
        showVKB();
      }
      aWf();
    }
    paramString = com.tencent.mm.plugin.fts.a.d.DS(paramString);
    if ((!bk.bl(this.bVk)) && (this.bVk.equals(paramString)))
    {
      y.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[] { this.bVk, paramString });
      return;
    }
    this.bVk = paramString;
    if (!bk.bl(this.bVk))
    {
      this.kAl.removeMessages(1);
      this.kAl.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    this.kAl.removeMessages(1);
    this.kAV = false;
    this.kAT.stopSearch();
    aWf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI
 * JD-Core Version:    0.7.0.1
 */