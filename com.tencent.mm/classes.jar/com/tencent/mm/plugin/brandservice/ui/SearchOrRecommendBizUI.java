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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.o.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.brandservice.b.j;
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
  private int fPp = 0;
  private BizSearchResultItemContainer nXs;
  private ProgressDialog nZt = null;
  private int nZu = 0;
  private SearchViewNotRealTimeHelper nZv;
  
  public final void bNT()
  {
    AppMethodBeat.i(5790);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.nZt = h.b(localAppCompatActivity, getString(2131757920), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5786);
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface.nXO);
        paramAnonymousDialogInterface.nXM.nXZ = false;
        AppMethodBeat.o(5786);
      }
    });
    AppMethodBeat.o(5790);
  }
  
  public final void bNU()
  {
    AppMethodBeat.i(5791);
    if (this.nZt != null)
    {
      this.nZt.dismiss();
      this.nZt = null;
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
    this.nZv = ((SearchViewNotRealTimeHelper)findViewById(2131304452));
    this.nZv.setSearchColor(getResources().getColor(2131100711));
    this.nZv.setSearchHint(getString(2131757922));
    this.nZv.setSearchHintColor(getResources().getColor(2131100489));
    this.nZv.setSearchIcon(0);
    this.nZv.setShowBackIcon(false);
    this.nZv.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final boolean Jp(String paramAnonymousString)
      {
        AppMethodBeat.i(5783);
        Xe(paramAnonymousString);
        AppMethodBeat.o(5783);
        return true;
      }
      
      public final void Xe(String paramAnonymousString)
      {
        AppMethodBeat.i(5784);
        if (!bt.isNullOrNil(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.hideVKB();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).cw(paramAnonymousString, 0);
          AppMethodBeat.o(5784);
          return;
        }
        h.cl(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(2131757918));
        AppMethodBeat.o(5784);
      }
      
      public final void bOe()
      {
        AppMethodBeat.i(5785);
        SearchOrRecommendBizUI.this.showVKB();
        AppMethodBeat.o(5785);
      }
    });
    this.nXs = ((BizSearchResultItemContainer)findViewById(2131304388));
    this.nXs.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(5782);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/brandservice/ui/SearchOrRecommendBizUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).clearFocus();
        SearchOrRecommendBizUI.this.hideVKB();
        a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/SearchOrRecommendBizUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(5782);
        return false;
      }
    });
    g localg = new g(this);
    localg.nZp = j.bNN();
    this.nXs.setAdapter(localg);
    this.nXs.setBusinessTypes(new long[] { 1L });
    this.nXs.setDisplayArgs$25decb5(false);
    this.nXs.setMode(1);
    this.nXs.setScene(this.fPp);
    this.nXs.setIOnSearchStateChangedListener(this);
    AppMethodBeat.o(5789);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5787);
    super.onCreate(paramBundle);
    this.nZu = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.fPp = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (j.bNM())
    {
      com.tencent.mm.kernel.g.aiU().a(456, new f()
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
          com.tencent.mm.kernel.g.aiU().b(456, this);
          ad.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousn = j.bNN();
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
            paramAnonymousString.nZp = paramAnonymousn;
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
      com.tencent.mm.kernel.g.aiU().a(new j(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!bt.isNullOrNil(paramBundle)) {
      new ap(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5780);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).KLd.performClick();
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
    ag.aGj().aFP();
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