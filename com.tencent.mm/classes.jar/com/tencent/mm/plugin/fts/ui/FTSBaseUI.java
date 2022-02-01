package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import java.util.List;

public abstract class FTSBaseUI
  extends MMSecDataActivity
  implements d.a, e, FTSEditTextView.b, a.b
{
  private ListView BMK;
  private d BML;
  private boolean BMM = false;
  com.tencent.mm.ui.search.a BMN;
  private String BMO = null;
  private MMHandler BMc = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111874);
      if ((paramAnonymousMessage.what == 1) && (!Util.isNullOrNil(FTSBaseUI.b(FTSBaseUI.this)))) {
        FTSBaseUI.this.erw();
      }
      AppMethodBeat.o(111874);
    }
  };
  String query = "";
  private TextView xND;
  
  protected abstract d a(e parame);
  
  public void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    if (paramc == FTSEditTextView.c.XLV)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.aHK(paramString1);
      if ((!Util.isNullOrNil(this.query)) && (this.query.equals(paramString1))) {
        Log.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.query, paramString1 });
      }
    }
    else
    {
      return;
    }
    aIi(paramString1);
  }
  
  public void aC(int paramInt, boolean paramBoolean)
  {
    Log.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
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
      if (paramInt > 0) {
        erH();
      } else {
        erF();
      }
    }
  }
  
  public boolean aDV()
  {
    hideVKB();
    this.BMN.getFtsEditText().bGw.clearFocus();
    return false;
  }
  
  protected final void aIh(String paramString)
  {
    this.query = paramString;
    this.BMN.getFtsEditText().O(paramString, null);
  }
  
  protected void aIi(String paramString)
  {
    if (!Util.isNullOrNil(paramString))
    {
      this.query = paramString;
      this.BMc.removeMessages(1);
      this.BMc.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    erx();
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean) {}
  
  protected void erA()
  {
    this.BMN = new com.tencent.mm.ui.search.a(this);
    this.BMN.setSearchViewListener(this);
    this.BMN.getFtsEditText().setHint(getHint());
    this.BMN.getFtsEditText().hXB();
    this.BMN.getFtsEditText().setFtsEditTextListener(this);
    this.BMN.getFtsEditText().setCanDeleteTag(false);
    getSupportActionBar().setCustomView(this.BMN);
    this.BMK = ((ListView)findViewById(o.d.search_result_lv));
    if (getFooterView() != null)
    {
      Log.i("MicroMsg.FTS.FTSBaseUI", "searchResultLV addFooterView");
      this.BMK.addFooterView(getFooterView());
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
        AppMethodBeat.i(111872);
        FTSBaseUI.a(FTSBaseUI.this).getFtsEditText().bGw.clearFocus();
        FTSBaseUI.this.hideVKB();
        AppMethodBeat.o(111872);
        return false;
      }
    });
    this.xND = ((TextView)findViewById(o.d.no_result_view));
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
  
  protected void erD() {}
  
  protected final ListView erE()
  {
    return this.BMK;
  }
  
  protected void erF()
  {
    this.xND.setVisibility(8);
    this.BMK.setVisibility(8);
  }
  
  protected void erG()
  {
    this.xND.setVisibility(0);
    this.xND.setText(f.a(getString(o.g.search_contact_no_result_pre), getString(o.g.search_contact_no_result_post), this.query));
    this.BMK.setVisibility(8);
  }
  
  protected void erH()
  {
    this.xND.setVisibility(8);
    this.BMK.setVisibility(0);
  }
  
  protected void erI()
  {
    this.xND.setVisibility(8);
    this.BMK.setVisibility(8);
  }
  
  public final com.tencent.mm.ui.search.a erJ()
  {
    return this.BMN;
  }
  
  public final TextView erK()
  {
    return this.xND;
  }
  
  protected void erw()
  {
    if (this.BML == null) {
      return;
    }
    this.BMM = true;
    this.BML.aEi(this.query);
    erF();
  }
  
  protected void erx()
  {
    this.query = "";
    this.BMc.removeMessages(1);
    this.BMM = false;
    this.BML.erx();
    this.BMN.getFtsEditText().setHint(getHint());
    erI();
  }
  
  protected View getFooterView()
  {
    return null;
  }
  
  public String getHint()
  {
    if (this.BMO != null) {
      return this.BMO;
    }
    return getString(o.g.app_search);
  }
  
  public final ListView getListView()
  {
    return this.BMK;
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
    erx();
    this.BMN.getFtsEditText().aDU();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(o.a.BG_0));
    erD();
    erA();
  }
  
  public void onDestroy()
  {
    this.BMc.removeMessages(1);
    this.BML.finish();
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setHint(String paramString)
  {
    this.BMO = paramString;
    this.BMN.getFtsEditText().setHint(getHint());
  }
  
  protected final void w(String paramString, List<a.c> paramList)
  {
    this.query = paramString;
    this.BMN.getFtsEditText().O(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */