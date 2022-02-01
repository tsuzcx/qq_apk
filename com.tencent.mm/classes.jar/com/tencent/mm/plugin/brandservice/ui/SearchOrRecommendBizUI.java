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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.af;
import com.tencent.mm.am.n.a;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import java.util.LinkedList;

public class SearchOrRecommendBizUI
  extends MMActivity
  implements BizSearchResultItemContainer.b
{
  private int fsv = 0;
  private BizSearchResultItemContainer mTC;
  private ProgressDialog mVv = null;
  private int mVw = 0;
  private SearchViewNotRealTimeHelper mVx;
  
  public final void bCx()
  {
    AppMethodBeat.i(5790);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.mVv = h.b(localAppCompatActivity, getString(2131757920), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5786);
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface.mTY);
        paramAnonymousDialogInterface.mTW.mUj = false;
        AppMethodBeat.o(5786);
      }
    });
    AppMethodBeat.o(5790);
  }
  
  public final void bCy()
  {
    AppMethodBeat.i(5791);
    if (this.mVv != null)
    {
      this.mVv.dismiss();
      this.mVv = null;
    }
    AppMethodBeat.o(5791);
  }
  
  public int getLayoutId()
  {
    return 2131493659;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5789);
    setMMTitle(2131757922);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5781);
        SearchOrRecommendBizUI.this.hideVKB();
        SearchOrRecommendBizUI.this.finish();
        AppMethodBeat.o(5781);
        return true;
      }
    });
    this.mVx = ((SearchViewNotRealTimeHelper)findViewById(2131304452));
    this.mVx.setSearchColor(getResources().getColor(2131100711));
    this.mVx.setSearchHint(getString(2131757922));
    this.mVx.setSearchHintColor(getResources().getColor(2131100489));
    this.mVx.setSearchIcon(0);
    this.mVx.setShowBackIcon(false);
    this.mVx.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final boolean BX(String paramAnonymousString)
      {
        AppMethodBeat.i(5783);
        Pm(paramAnonymousString);
        AppMethodBeat.o(5783);
        return true;
      }
      
      public final void Pm(String paramAnonymousString)
      {
        AppMethodBeat.i(5784);
        if (!bt.isNullOrNil(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.hideVKB();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).co(paramAnonymousString, 0);
          AppMethodBeat.o(5784);
          return;
        }
        h.cf(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(2131757918));
        AppMethodBeat.o(5784);
      }
      
      public final void bCD()
      {
        AppMethodBeat.i(5785);
        SearchOrRecommendBizUI.this.showVKB();
        AppMethodBeat.o(5785);
      }
    });
    this.mTC = ((BizSearchResultItemContainer)findViewById(2131304388));
    this.mTC.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(5782);
        SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).clearFocus();
        SearchOrRecommendBizUI.this.hideVKB();
        AppMethodBeat.o(5782);
        return false;
      }
    });
    g localg = new g(this);
    localg.mVr = k.bCr();
    this.mTC.setAdapter(localg);
    this.mTC.setBusinessTypes(new long[] { 1L });
    this.mTC.setDisplayArgs$25decb5(false);
    this.mTC.setMode(1);
    this.mTC.setScene(this.fsv);
    this.mTC.setIOnSearchStateChangedListener(this);
    AppMethodBeat.o(5789);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5787);
    super.onCreate(paramBundle);
    this.mVw = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.fsv = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (k.bCq())
    {
      com.tencent.mm.kernel.g.aeS().a(456, new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(5779);
          if (paramAnonymousn == null)
          {
            ad.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
            AppMethodBeat.o(5779);
            return;
          }
          if (paramAnonymousn.getType() != 456)
          {
            ad.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
            AppMethodBeat.o(5779);
            return;
          }
          com.tencent.mm.kernel.g.aeS().b(456, this);
          ad.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousn = k.bCr();
            if (SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this) != null) {
              break label169;
            }
            paramAnonymousString = null;
            if ((paramAnonymousString != null) && (paramAnonymousn != null) && (paramAnonymousn.size() > 0)) {
              if (paramAnonymousString.getCount() != 0) {
                break label189;
              }
            }
          }
          label169:
          label189:
          for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
          {
            paramAnonymousString.mVr = paramAnonymousn;
            if (paramAnonymousInt1 != 0) {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(5778);
                  ad.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
                  paramAnonymousString.notifyDataSetChanged();
                  AppMethodBeat.o(5778);
                }
              });
            }
            AppMethodBeat.o(5779);
            return;
            paramAnonymousString = (g)SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).getAdapter();
            break;
          }
        }
      });
      com.tencent.mm.kernel.g.aeS().a(new k(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!bt.isNullOrNil(paramBundle)) {
      new ap(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5780);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).HtC.performClick();
          AppMethodBeat.o(5780);
        }
      });
    }
    AppMethodBeat.o(5787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5788);
    super.onDestroy();
    af.awo().avU();
    AppMethodBeat.o(5788);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI
 * JD-Core Version:    0.7.0.1
 */