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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.o.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.brandservice.b.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import java.util.LinkedList;

public class SearchOrRecommendBizUI
  extends MMActivity
  implements BizSearchResultItemContainer.b
{
  private int fRv = 0;
  private BizSearchResultItemContainer odb;
  private ProgressDialog ofc = null;
  private int ofd = 0;
  private SearchViewNotRealTimeHelper ofe;
  
  public final void bOQ()
  {
    AppMethodBeat.i(5790);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.ofc = h.b(localAppCompatActivity, getString(2131757920), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5786);
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface.odx);
        paramAnonymousDialogInterface.odv.odI = false;
        AppMethodBeat.o(5786);
      }
    });
    AppMethodBeat.o(5790);
  }
  
  public final void bOR()
  {
    AppMethodBeat.i(5791);
    if (this.ofc != null)
    {
      this.ofc.dismiss();
      this.ofc = null;
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
    this.ofe = ((SearchViewNotRealTimeHelper)findViewById(2131304452));
    this.ofe.setSearchColor(getResources().getColor(2131100711));
    this.ofe.setSearchHint(getString(2131757922));
    this.ofe.setSearchHintColor(getResources().getColor(2131100489));
    this.ofe.setSearchIcon(0);
    this.ofe.setShowBackIcon(false);
    this.ofe.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final boolean JO(String paramAnonymousString)
      {
        AppMethodBeat.i(5783);
        XQ(paramAnonymousString);
        AppMethodBeat.o(5783);
        return true;
      }
      
      public final void XQ(String paramAnonymousString)
      {
        AppMethodBeat.i(5784);
        if (!bu.isNullOrNil(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.hideVKB();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).cA(paramAnonymousString, 0);
          AppMethodBeat.o(5784);
          return;
        }
        h.cm(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(2131757918));
        AppMethodBeat.o(5784);
      }
      
      public final void bPb()
      {
        AppMethodBeat.i(5785);
        SearchOrRecommendBizUI.this.showVKB();
        AppMethodBeat.o(5785);
      }
    });
    this.odb = ((BizSearchResultItemContainer)findViewById(2131304388));
    this.odb.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(5782);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/brandservice/ui/SearchOrRecommendBizUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).clearFocus();
        SearchOrRecommendBizUI.this.hideVKB();
        a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/SearchOrRecommendBizUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(5782);
        return false;
      }
    });
    g localg = new g(this);
    localg.oeY = j.bOK();
    this.odb.setAdapter(localg);
    this.odb.setBusinessTypes(new long[] { 1L });
    this.odb.setDisplayArgs$25decb5(false);
    this.odb.setMode(1);
    this.odb.setScene(this.fRv);
    this.odb.setIOnSearchStateChangedListener(this);
    AppMethodBeat.o(5789);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5787);
    super.onCreate(paramBundle);
    this.ofd = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.fRv = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (j.bOJ())
    {
      com.tencent.mm.kernel.g.ajj().a(456, new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(5779);
          if (paramAnonymousn == null)
          {
            ae.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
            AppMethodBeat.o(5779);
            return;
          }
          if (paramAnonymousn.getType() != 456)
          {
            ae.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
            AppMethodBeat.o(5779);
            return;
          }
          com.tencent.mm.kernel.g.ajj().b(456, this);
          ae.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousn = j.bOK();
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
            paramAnonymousString.oeY = paramAnonymousn;
            if (paramAnonymousInt1 != 0) {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(5778);
                  ae.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
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
      com.tencent.mm.kernel.g.ajj().a(new j(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!bu.isNullOrNil(paramBundle)) {
      new aq(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5780);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).Lhx.performClick();
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
    ag.aGz().aGf();
    AppMethodBeat.o(5788);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI
 * JD-Core Version:    0.7.0.1
 */