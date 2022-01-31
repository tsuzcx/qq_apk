package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.m.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;

public class SearchOrRecommendBizUI
  extends MMActivity
  implements BizSearchResultItemContainer.b
{
  private int ejF = 0;
  private BizSearchResultItemContainer jTk;
  private ProgressDialog jUQ = null;
  private int jUR = 0;
  private SearchViewNotRealTimeHelper jUS;
  
  public final void aWy()
  {
    AppMethodBeat.i(14053);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.jUQ = h.b(localAppCompatActivity, getString(2131298842), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(14048);
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        g.Rc().a(paramAnonymousDialogInterface.jTH);
        paramAnonymousDialogInterface.jTF.jTS = false;
        AppMethodBeat.o(14048);
      }
    });
    AppMethodBeat.o(14053);
  }
  
  public final void aWz()
  {
    AppMethodBeat.i(14054);
    if (this.jUQ != null)
    {
      this.jUQ.dismiss();
      this.jUQ = null;
    }
    AppMethodBeat.o(14054);
  }
  
  public int getLayoutId()
  {
    return 2130969271;
  }
  
  public void initView()
  {
    AppMethodBeat.i(14051);
    setMMTitle(2131298844);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(14043);
        SearchOrRecommendBizUI.this.hideVKB();
        SearchOrRecommendBizUI.this.finish();
        AppMethodBeat.o(14043);
        return true;
      }
    });
    this.jUS = ((SearchViewNotRealTimeHelper)findViewById(2131823242));
    this.jUS.setSearchColor(getResources().getColor(2131690322));
    this.jUS.setSearchHint(getString(2131298844));
    this.jUS.setSearchHintColor(getResources().getColor(2131690167));
    this.jUS.setSearchIcon(0);
    this.jUS.setShowBackIcon(false);
    this.jUS.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final void GL(String paramAnonymousString)
      {
        AppMethodBeat.i(14046);
        if (!bo.isNullOrNil(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.hideVKB();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).bJ(paramAnonymousString, 0);
          AppMethodBeat.o(14046);
          return;
        }
        h.bO(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(2131298840));
        AppMethodBeat.o(14046);
      }
      
      public final void aWD()
      {
        AppMethodBeat.i(14047);
        SearchOrRecommendBizUI.this.showVKB();
        AppMethodBeat.o(14047);
      }
      
      public final boolean wR(String paramAnonymousString)
      {
        AppMethodBeat.i(14045);
        GL(paramAnonymousString);
        AppMethodBeat.o(14045);
        return true;
      }
    });
    this.jTk = ((BizSearchResultItemContainer)findViewById(2131821845));
    this.jTk.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(14044);
        SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).clearFocus();
        SearchOrRecommendBizUI.this.hideVKB();
        AppMethodBeat.o(14044);
        return false;
      }
    });
    f localf = new f(this);
    localf.jUM = com.tencent.mm.plugin.brandservice.b.f.aWs();
    this.jTk.setAdapter(localf);
    this.jTk.setBusinessTypes(new long[] { 1L });
    this.jTk.setDisplayArgs$25decb5(false);
    this.jTk.setMode(1);
    this.jTk.setScene(this.ejF);
    this.jTk.setIOnSearchStateChangedListener(this);
    AppMethodBeat.o(14051);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(14049);
    super.onCreate(paramBundle);
    this.jUR = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.ejF = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (com.tencent.mm.plugin.brandservice.b.f.aWr())
    {
      g.Rc().a(456, new SearchOrRecommendBizUI.1(this));
      g.Rc().a(new com.tencent.mm.plugin.brandservice.b.f(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!bo.isNullOrNil(paramBundle)) {
      new ak(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(14042);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).Axs.performClick();
          AppMethodBeat.o(14042);
        }
      });
    }
    AppMethodBeat.o(14049);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(14050);
    super.onDestroy();
    z.afs().afc();
    AppMethodBeat.o(14050);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI
 * JD-Core Version:    0.7.0.1
 */