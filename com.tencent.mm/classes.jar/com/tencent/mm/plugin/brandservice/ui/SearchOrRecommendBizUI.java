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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.al.n.a;
import com.tencent.mm.plugin.brandservice.b.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import java.util.LinkedList;

public class SearchOrRecommendBizUI
  extends MMActivity
  implements BizSearchResultItemContainer.b
{
  private int fwc = 0;
  private BizSearchResultItemContainer nvU;
  private ProgressDialog nxV = null;
  private int nxW = 0;
  private SearchViewNotRealTimeHelper nxX;
  
  public final void bJA()
  {
    AppMethodBeat.i(5790);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.nxV = h.b(localAppCompatActivity, getString(2131757920), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5786);
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface.nwq);
        paramAnonymousDialogInterface.nwo.nwB = false;
        AppMethodBeat.o(5786);
      }
    });
    AppMethodBeat.o(5790);
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(5791);
    if (this.nxV != null)
    {
      this.nxV.dismiss();
      this.nxV = null;
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
    this.nxX = ((SearchViewNotRealTimeHelper)findViewById(2131304452));
    this.nxX.setSearchColor(getResources().getColor(2131100711));
    this.nxX.setSearchHint(getString(2131757922));
    this.nxX.setSearchHintColor(getResources().getColor(2131100489));
    this.nxX.setSearchIcon(0);
    this.nxX.setShowBackIcon(false);
    this.nxX.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        AppMethodBeat.i(5783);
        Tx(paramAnonymousString);
        AppMethodBeat.o(5783);
        return true;
      }
      
      public final void Tx(String paramAnonymousString)
      {
        AppMethodBeat.i(5784);
        if (!bs.isNullOrNil(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.hideVKB();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).ct(paramAnonymousString, 0);
          AppMethodBeat.o(5784);
          return;
        }
        h.cg(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(2131757918));
        AppMethodBeat.o(5784);
      }
      
      public final void bJL()
      {
        AppMethodBeat.i(5785);
        SearchOrRecommendBizUI.this.showVKB();
        AppMethodBeat.o(5785);
      }
    });
    this.nvU = ((BizSearchResultItemContainer)findViewById(2131304388));
    this.nvU.setOnTouchListener(new View.OnTouchListener()
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
    localg.nxR = j.bJu();
    this.nvU.setAdapter(localg);
    this.nvU.setBusinessTypes(new long[] { 1L });
    this.nvU.setDisplayArgs$25decb5(false);
    this.nvU.setMode(1);
    this.nvU.setScene(this.fwc);
    this.nvU.setIOnSearchStateChangedListener(this);
    AppMethodBeat.o(5789);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5787);
    super.onCreate(paramBundle);
    this.nxW = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.fwc = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (j.bJt())
    {
      com.tencent.mm.kernel.g.agi().a(456, new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(5779);
          if (paramAnonymousn == null)
          {
            ac.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
            AppMethodBeat.o(5779);
            return;
          }
          if (paramAnonymousn.getType() != 456)
          {
            ac.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
            AppMethodBeat.o(5779);
            return;
          }
          com.tencent.mm.kernel.g.agi().b(456, this);
          ac.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousn = j.bJu();
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
            paramAnonymousString.nxR = paramAnonymousn;
            if (paramAnonymousInt1 != 0) {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(5778);
                  ac.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
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
      com.tencent.mm.kernel.g.agi().a(new j(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!bs.isNullOrNil(paramBundle)) {
      new ao(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5780);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).ITZ.performClick();
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
    af.aDg().aCM();
    AppMethodBeat.o(5788);
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