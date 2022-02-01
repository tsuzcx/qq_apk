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
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import java.util.List;

public abstract class FTSBaseUI
  extends MMSecDataActivity
  implements d.a, e, FTSEditTextView.a, a.b
{
  String query = "";
  private TextView vtJ;
  ListView xaK;
  private d xaL;
  private boolean xaM = false;
  com.tencent.mm.ui.search.a xaN;
  private String xaO = null;
  private MMHandler xad = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111874);
      if ((paramAnonymousMessage.what == 1) && (!Util.isNullOrNil(FTSBaseUI.b(FTSBaseUI.this)))) {
        FTSBaseUI.this.dPc();
      }
      AppMethodBeat.o(111874);
    }
  };
  
  protected abstract d a(e parame);
  
  public void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    if (paramb == FTSEditTextView.b.QnQ)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.ayr(paramString1);
      if ((!Util.isNullOrNil(this.query)) && (this.query.equals(paramString1))) {
        Log.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.query, paramString1 });
      }
    }
    else
    {
      return;
    }
    ayM(paramString1);
  }
  
  public boolean awE()
  {
    hideVKB();
    this.xaN.getFtsEditText().vy.clearFocus();
    return false;
  }
  
  public void ay(int paramInt, boolean paramBoolean)
  {
    Log.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (paramInt > 0) {
        dPl();
      }
    }
    for (;;)
    {
      if (this.xaM)
      {
        this.xaM = false;
        this.xaK.setSelection(0);
      }
      return;
      dPk();
      continue;
      if (paramInt > 0) {
        dPl();
      } else {
        dPj();
      }
    }
  }
  
  protected void ayM(String paramString)
  {
    if (!Util.isNullOrNil(paramString))
    {
      this.query = paramString;
      this.xad.removeMessages(1);
      this.xad.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    stopSearch();
  }
  
  protected void dPc()
  {
    if (this.xaL == null) {
      return;
    }
    this.xaM = true;
    this.xaL.auV(this.query);
    dPj();
  }
  
  protected void dPf()
  {
    this.xaN = new com.tencent.mm.ui.search.a(this);
    this.xaN.setSearchViewListener(this);
    this.xaN.getFtsEditText().setHint(getHint());
    this.xaN.getFtsEditText().gWY();
    this.xaN.getFtsEditText().setFtsEditTextListener(this);
    this.xaN.getFtsEditText().setCanDeleteTag(false);
    getSupportActionBar().setCustomView(this.xaN);
    this.xaK = ((ListView)findViewById(2131307422));
    if (getFooterView() != null)
    {
      Log.i("MicroMsg.FTS.FTSBaseUI", "searchResultLV addFooterView");
      this.xaK.addFooterView(getFooterView());
    }
    this.xaL = a(this);
    this.xaL.xaJ = this;
    this.xaK.setAdapter(this.xaL);
    this.xaK.setOnScrollListener(this.xaL);
    this.xaK.setOnItemClickListener(this.xaL);
    this.xaK.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111872);
        FTSBaseUI.a(FTSBaseUI.this).getFtsEditText().vy.clearFocus();
        FTSBaseUI.this.hideVKB();
        AppMethodBeat.o(111872);
        return false;
      }
    });
    this.vtJ = ((TextView)findViewById(2131305462));
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
  
  protected void dPh() {}
  
  protected final ListView dPi()
  {
    return this.xaK;
  }
  
  protected void dPj()
  {
    this.vtJ.setVisibility(8);
    this.xaK.setVisibility(8);
  }
  
  protected void dPk()
  {
    this.vtJ.setVisibility(0);
    this.vtJ.setText(f.a(getString(2131765056), getString(2131765055), this.query));
    this.xaK.setVisibility(8);
  }
  
  protected void dPl()
  {
    this.vtJ.setVisibility(8);
    this.xaK.setVisibility(0);
  }
  
  protected void dPm()
  {
    this.vtJ.setVisibility(8);
    this.xaK.setVisibility(8);
  }
  
  public final com.tencent.mm.ui.search.a dPn()
  {
    return this.xaN;
  }
  
  public final TextView dPo()
  {
    return this.vtJ;
  }
  
  public final void dpw() {}
  
  public final void eh(boolean paramBoolean) {}
  
  protected View getFooterView()
  {
    return null;
  }
  
  public String getHint()
  {
    if (this.xaO != null) {
      return this.xaO;
    }
    return getString(2131755972);
  }
  
  public final ListView getListView()
  {
    return this.xaK;
  }
  
  public final String getQuery()
  {
    return this.query;
  }
  
  public void onClickBackBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickCancelBtn(View paramView) {}
  
  public void onClickClearTextBtn(View paramView)
  {
    stopSearch();
    this.xaN.getFtsEditText().awD();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(2131099648));
    dPh();
    dPf();
  }
  
  public void onDestroy()
  {
    this.xad.removeMessages(1);
    this.xaL.finish();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setHint(String paramString)
  {
    this.xaO = paramString;
    this.xaN.getFtsEditText().setHint(getHint());
  }
  
  protected void stopSearch()
  {
    this.query = "";
    this.xad.removeMessages(1);
    this.xaM = false;
    this.xaL.stopSearch();
    this.xaN.getFtsEditText().setHint(getHint());
    dPm();
  }
  
  protected final void v(String paramString, List<a.c> paramList)
  {
    this.query = paramString;
    this.xaN.getFtsEditText().O(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */