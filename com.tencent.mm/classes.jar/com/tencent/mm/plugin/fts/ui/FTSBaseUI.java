package com.tencent.mm.plugin.fts.ui;

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
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import java.util.List;

public abstract class FTSBaseUI
  extends MMSecDataActivity
  implements d.a, e, FTSEditTextView.c, FTSSearchView.b
{
  private TextView BnA;
  private MMHandler HwY = new MMHandler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      AppMethodBeat.i(111874);
      if ((paramAnonymousMessage.what == 1) && (!Util.isNullOrNil(FTSBaseUI.b(FTSBaseUI.this)))) {
        FTSBaseUI.this.fye();
      }
      AppMethodBeat.o(111874);
    }
  };
  private ListView Hyb;
  private d Hyc;
  private boolean Hyd = false;
  FTSSearchView Hye;
  private String Hyf = null;
  String query = "";
  
  protected final void B(String paramString, List<FTSSearchView.c> paramList)
  {
    this.query = paramString;
    this.Hye.getFtsEditText().V(paramString, paramList);
  }
  
  protected abstract d a(e parame);
  
  public void a(a parama, boolean paramBoolean) {}
  
  protected final void aEI(String paramString)
  {
    this.query = paramString;
    this.Hye.getFtsEditText().V(paramString, null);
  }
  
  protected void aEJ(String paramString)
  {
    if (!Util.isNullOrNil(paramString))
    {
      this.query = paramString;
      this.HwY.removeMessages(1);
      this.HwY.sendEmptyMessageDelayed(1, 300L);
      return;
    }
    eui();
  }
  
  public boolean aWU()
  {
    hideVKB();
    this.Hye.getFtsEditText().dzv.clearFocus();
    return false;
  }
  
  public void ba(int paramInt, boolean paramBoolean)
  {
    Log.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
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
      if (paramInt > 0) {
        fyo();
      } else {
        fyq();
      }
    }
  }
  
  public final TextView ePp()
  {
    return this.BnA;
  }
  
  public final void eeU() {}
  
  protected void eui()
  {
    this.query = "";
    this.HwY.removeMessages(1);
    this.Hyd = false;
    this.Hyc.eui();
    this.Hye.getFtsEditText().setHint(getHint());
    fyn();
  }
  
  public final void fq(boolean paramBoolean) {}
  
  protected void fye()
  {
    if (this.Hyc == null) {
      return;
    }
    this.Hyd = true;
    this.Hyc.awg(this.query);
    fyq();
  }
  
  protected void fyh()
  {
    this.Hye = new FTSSearchView(this);
    this.Hye.setSearchViewListener(this);
    this.Hye.getFtsEditText().setHint(getHint());
    this.Hye.getFtsEditText().jBL();
    this.Hye.getFtsEditText().setFtsEditTextListener(this);
    this.Hye.getFtsEditText().setCanDeleteTag(fyz());
    getSupportActionBar().setCustomView(this.Hye);
    this.Hyb = ((ListView)findViewById(p.d.search_result_lv));
    if (getFooterView() != null)
    {
      Log.i("MicroMsg.FTS.FTSBaseUI", "searchResultLV addFooterView");
      this.Hyb.addFooterView(getFooterView());
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
        AppMethodBeat.i(111872);
        FTSBaseUI.a(FTSBaseUI.this).getFtsEditText().dzv.clearFocus();
        FTSBaseUI.this.hideVKB();
        AppMethodBeat.o(111872);
        return false;
      }
    });
    this.BnA = ((TextView)findViewById(p.d.no_result_view));
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
  
  protected void fyk() {}
  
  protected void fyn()
  {
    this.BnA.setVisibility(8);
    this.Hyb.setVisibility(8);
  }
  
  protected void fyo()
  {
    this.BnA.setVisibility(8);
    this.Hyb.setVisibility(0);
  }
  
  protected void fyp()
  {
    this.BnA.setVisibility(0);
    this.BnA.setText(f.a(getString(p.g.search_contact_no_result_pre), getString(p.g.search_contact_no_result_post), this.query));
    this.Hyb.setVisibility(8);
  }
  
  protected void fyq()
  {
    this.BnA.setVisibility(8);
    this.Hyb.setVisibility(8);
  }
  
  protected final ListView fyy()
  {
    return this.Hyb;
  }
  
  protected boolean fyz()
  {
    return false;
  }
  
  protected View getFooterView()
  {
    return null;
  }
  
  public String getHint()
  {
    if (this.Hyf != null) {
      return this.Hyf;
    }
    return getString(p.g.app_search);
  }
  
  public final ListView getListView()
  {
    return this.Hyb;
  }
  
  public void onClickBackBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickCancelBtn(View paramView) {}
  
  public void onClickClearTextBtn(View paramView)
  {
    eui();
    this.Hye.getFtsEditText().aWT();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showMMLogo();
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(p.a.BG_0));
    fyk();
    fyh();
  }
  
  public void onDestroy()
  {
    this.HwY.removeMessages(1);
    this.Hyc.finish();
    super.onDestroy();
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    if (paramd == FTSEditTextView.d.afCj)
    {
      paramString1 = com.tencent.mm.plugin.fts.a.d.aEi(paramString1);
      if ((!Util.isNullOrNil(this.query)) && (this.query.equals(paramString1))) {
        Log.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[] { this.query, paramString1 });
      }
    }
    else
    {
      return;
    }
    aEJ(paramString1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setHint(String paramString)
  {
    this.Hyf = paramString;
    this.Hye.getFtsEditText().setHint(getHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseUI
 * JD-Core Version:    0.7.0.1
 */