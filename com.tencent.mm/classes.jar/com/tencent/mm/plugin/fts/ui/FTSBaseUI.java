package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.a;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

public abstract class FTSBaseUI
  extends MMActivity
  implements d.a, e, FTSEditTextView.a, a.a
{
  String bVk;
  ListView kAS;
  private d kAT;
  private TextView kAU;
  private boolean kAV = false;
  com.tencent.mm.plugin.fts.ui.widget.a kAW;
  private String kAX = null;
  private ah kAl = new FTSBaseUI.3(this);
  
  protected void Ek(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.bVk = paramString;
      this.kAl.removeMessages(1);
      this.kAl.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  public final void O(int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
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
      if (paramInt > 0) {
        aWe();
      } else {
        aWc();
      }
    }
  }
  
  protected abstract d a(e parame);
  
  public void a(com.tencent.mm.plugin.fts.a.d.a.a parama) {}
  
  public void a(String paramString1, String paramString2, List<a.b> paramList, FTSEditTextView.b paramb)
  {
    if (paramb == FTSEditTextView.b.kEB)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.DS(paramString1);
      if ((!bk.bl(this.bVk)) && (this.bVk.equals(paramString1))) {
        y.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.bVk, paramString1 });
      }
    }
    else
    {
      return;
    }
    Ek(paramString1);
  }
  
  protected void aVW()
  {
    this.kAV = true;
    this.kAT.Ej(this.bVk);
    aWc();
  }
  
  protected void aVZ()
  {
    this.kAW = new com.tencent.mm.plugin.fts.ui.widget.a(this);
    this.kAW.setSearchViewListener(this);
    this.kAW.getFtsEditText().setHint(getHint());
    this.kAW.getFtsEditText().setFtsEditTextListener(this);
    this.kAW.getFtsEditText().setCanDeleteTag(false);
    getSupportActionBar().setCustomView(this.kAW);
    this.kAS = ((ListView)findViewById(n.d.search_result_lv));
    this.kAT = a(this);
    this.kAT.kAR = this;
    this.kAS.setAdapter(this.kAT);
    this.kAS.setOnScrollListener(this.kAT);
    this.kAS.setOnItemClickListener(this.kAT);
    this.kAS.setOnTouchListener(new FTSBaseUI.1(this));
    this.kAU = ((TextView)findViewById(n.d.no_result_view));
    setBackBtn(new FTSBaseUI.2(this));
  }
  
  protected void aWa() {}
  
  public final void aWb() {}
  
  protected void aWc()
  {
    this.kAU.setVisibility(8);
    this.kAS.setVisibility(8);
  }
  
  protected void aWd()
  {
    this.kAU.setVisibility(0);
    this.kAU.setText(f.a(getString(n.g.search_contact_no_result_pre), getString(n.g.search_contact_no_result_post), com.tencent.mm.plugin.fts.a.a.d.b(this.bVk, this.bVk)).kwz);
    this.kAS.setVisibility(8);
  }
  
  protected void aWe()
  {
    this.kAU.setVisibility(8);
    this.kAS.setVisibility(0);
  }
  
  protected void aWf()
  {
    this.kAU.setVisibility(8);
    this.kAS.setVisibility(8);
  }
  
  public boolean apb()
  {
    XM();
    this.kAW.getFtsEditText().kEp.clearFocus();
    return false;
  }
  
  public String getHint()
  {
    if (this.kAX != null) {
      return this.kAX;
    }
    return getString(n.g.app_search);
  }
  
  public final void gn(boolean paramBoolean) {}
  
  protected final void l(String paramString, List<a.b> paramList)
  {
    this.bVk = paramString;
    this.kAW.getFtsEditText().n(paramString, paramList);
  }
  
  public void onClickBackBtn(View paramView)
  {
    finish();
  }
  
  public void onClickCancelBtn(View paramView) {}
  
  public void onClickClearTextBtn(View paramView)
  {
    stopSearch();
    this.kAW.getFtsEditText().aWy();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    czr();
    setMMTitle("");
    ta(b.i(this.mController.uMN, n.a.normal_actionbar_color));
    czo();
    aWa();
    aVZ();
  }
  
  protected void onDestroy()
  {
    this.kAl.removeMessages(1);
    this.kAT.finish();
    super.onDestroy();
  }
  
  public final void setHint(String paramString)
  {
    this.kAX = paramString;
    this.kAW.getFtsEditText().setHint(getHint());
  }
  
  protected void stopSearch()
  {
    this.bVk = "";
    this.kAl.removeMessages(1);
    this.kAV = false;
    this.kAT.stopSearch();
    this.kAW.getFtsEditText().setHint(getHint());
    aWf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */