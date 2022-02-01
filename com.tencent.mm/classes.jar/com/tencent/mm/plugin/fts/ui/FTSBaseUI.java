package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  String query;
  private TextView rAz;
  private com.tencent.mm.sdk.platformtools.ao sBM = new com.tencent.mm.sdk.platformtools.ao()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111874);
      if ((paramAnonymousMessage.what == 1) && (!bs.isNullOrNil(FTSBaseUI.b(FTSBaseUI.this)))) {
        FTSBaseUI.this.cKZ();
      }
      AppMethodBeat.o(111874);
    }
  };
  ListView sCt;
  private d sCu;
  private boolean sCv = false;
  com.tencent.mm.ui.search.a sCw;
  private String sCx = null;
  
  protected abstract d a(e parame);
  
  public void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    if (paramb == FTSEditTextView.b.ILv)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.afR(paramString1);
      if ((!bs.isNullOrNil(this.query)) && (this.query.equals(paramString1))) {
        ac.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.query, paramString1 });
      }
    }
    else
    {
      return;
    }
    agm(paramString1);
  }
  
  protected void agm(String paramString)
  {
    if (!bs.isNullOrNil(paramString))
    {
      this.query = paramString;
      this.sBM.removeMessages(1);
      this.sBM.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  public final void ai(int paramInt, boolean paramBoolean)
  {
    ac.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
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
      if (paramInt > 0) {
        cLg();
      } else {
        cLe();
      }
    }
  }
  
  public boolean bvs()
  {
    hideVKB();
    this.sCw.getFtsEditText().ty.clearFocus();
    return false;
  }
  
  protected void cKZ()
  {
    if (this.sCu == null) {
      return;
    }
    this.sCv = true;
    this.sCu.adT(this.query);
    cLe();
  }
  
  protected void cLc()
  {
    this.sCw = new com.tencent.mm.ui.search.a(this);
    this.sCw.setSearchViewListener(this);
    this.sCw.getFtsEditText().setHint(getHint());
    this.sCw.getFtsEditText().ftb();
    this.sCw.getFtsEditText().setFtsEditTextListener(this);
    this.sCw.getFtsEditText().setCanDeleteTag(false);
    getSupportActionBar().setCustomView(this.sCw);
    this.sCt = ((ListView)findViewById(2131304446));
    this.sCu = a(this);
    this.sCu.sCs = this;
    this.sCt.setAdapter(this.sCu);
    this.sCt.setOnScrollListener(this.sCu);
    this.sCt.setOnItemClickListener(this.sCu);
    this.sCt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111872);
        FTSBaseUI.a(FTSBaseUI.this).getFtsEditText().ty.clearFocus();
        FTSBaseUI.this.hideVKB();
        AppMethodBeat.o(111872);
        return false;
      }
    });
    this.rAz = ((TextView)findViewById(2131302885));
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
  
  protected void cLd() {}
  
  protected void cLe()
  {
    this.rAz.setVisibility(8);
    this.sCt.setVisibility(8);
  }
  
  protected void cLf()
  {
    this.rAz.setVisibility(0);
    TextView localTextView = this.rAz;
    String str1 = getString(2131762920);
    String str2 = getString(2131762919);
    String str3 = this.query;
    localTextView.setText(f.f(str1 + str3 + str2, str1.length(), str1.length() + str3.length()));
    this.sCt.setVisibility(8);
  }
  
  protected void cLg()
  {
    this.rAz.setVisibility(8);
    this.sCt.setVisibility(0);
  }
  
  protected void cLh()
  {
    this.rAz.setVisibility(8);
    this.sCt.setVisibility(8);
  }
  
  public final void cxG() {}
  
  public String getHint()
  {
    if (this.sCx != null) {
      return this.sCx;
    }
    return getString(2131755882);
  }
  
  public final ListView getListView()
  {
    return this.sCt;
  }
  
  public final void lF(boolean paramBoolean) {}
  
  public void onClickBackBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickCancelBtn(View paramView) {}
  
  public void onClickClearTextBtn(View paramView)
  {
    stopSearch();
    this.sCw.getFtsEditText().fte();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(com.tencent.mm.ui.ao.aJ(getContext(), 2130968577));
    cLd();
    cLc();
  }
  
  public void onDestroy()
  {
    this.sBM.removeMessages(1);
    this.sCu.finish();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void r(String paramString, List<a.c> paramList)
  {
    this.query = paramString;
    this.sCw.getFtsEditText().F(paramString, paramList);
  }
  
  public final void setHint(String paramString)
  {
    this.sCx = paramString;
    this.sCw.getFtsEditText().setHint(getHint());
  }
  
  protected void stopSearch()
  {
    this.query = "";
    this.sBM.removeMessages(1);
    this.sCv = false;
    this.sCu.stopSearch();
    this.sCw.getFtsEditText().setHint(getHint());
    cLh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */