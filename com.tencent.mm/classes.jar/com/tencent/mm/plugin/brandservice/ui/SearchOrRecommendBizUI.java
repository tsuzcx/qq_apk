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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.o.a;
import com.tencent.mm.plugin.brandservice.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import java.util.LinkedList;

public class SearchOrRecommendBizUI
  extends MMActivity
  implements BizSearchResultItemContainer.b
{
  private int gwE = 0;
  private BizSearchResultItemContainer pnY;
  private ProgressDialog pqa = null;
  private int pqb = 0;
  private SearchViewNotRealTimeHelper pqc;
  
  public final void clW()
  {
    AppMethodBeat.i(5790);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755998);
    this.pqa = h.a(localAppCompatActivity, getString(2131758160), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5786);
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface.pov);
        paramAnonymousDialogInterface.pot.poG = false;
        AppMethodBeat.o(5786);
      }
    });
    AppMethodBeat.o(5790);
  }
  
  public final void clX()
  {
    AppMethodBeat.i(5791);
    if (this.pqa != null)
    {
      this.pqa.dismiss();
      this.pqa = null;
    }
    AppMethodBeat.o(5791);
  }
  
  public int getLayoutId()
  {
    return 2131493789;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5789);
    setMMTitle(2131758162);
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
    this.pqc = ((SearchViewNotRealTimeHelper)findViewById(2131307428));
    this.pqc.setSearchColor(getResources().getColor(2131100904));
    this.pqc.setSearchHint(getString(2131758162));
    this.pqc.setSearchHintColor(getResources().getColor(2131100593));
    this.pqc.setSearchIcon(0);
    this.pqc.setShowBackIcon(false);
    this.pqc.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final boolean SN(String paramAnonymousString)
      {
        AppMethodBeat.i(5783);
        ahN(paramAnonymousString);
        AppMethodBeat.o(5783);
        return true;
      }
      
      public final void ahN(String paramAnonymousString)
      {
        AppMethodBeat.i(5784);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.hideVKB();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).cH(paramAnonymousString, 0);
          AppMethodBeat.o(5784);
          return;
        }
        h.cD(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(2131758158));
        AppMethodBeat.o(5784);
      }
      
      public final void cmh()
      {
        AppMethodBeat.i(5785);
        SearchOrRecommendBizUI.this.showVKB();
        AppMethodBeat.o(5785);
      }
    });
    this.pnY = ((BizSearchResultItemContainer)findViewById(2131307353));
    this.pnY.setOnTouchListener(new View.OnTouchListener()
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
    localg.ppW = j.clQ();
    this.pnY.setAdapter(localg);
    this.pnY.setBusinessTypes(new long[] { 1L });
    this.pnY.setDisplayArgs$25decb5(false);
    this.pnY.setMode(1);
    this.pnY.setScene(this.gwE);
    this.pnY.setIOnSearchStateChangedListener(this);
    AppMethodBeat.o(5789);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5787);
    super.onCreate(paramBundle);
    this.pqb = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.gwE = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (j.clP())
    {
      com.tencent.mm.kernel.g.azz().a(456, new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(5779);
          if (paramAnonymousq == null)
          {
            Log.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
            AppMethodBeat.o(5779);
            return;
          }
          if (paramAnonymousq.getType() != 456)
          {
            Log.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
            AppMethodBeat.o(5779);
            return;
          }
          com.tencent.mm.kernel.g.azz().b(456, this);
          Log.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousq = j.clQ();
            if (SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this) != null) {
              break label169;
            }
            paramAnonymousString = null;
            if ((paramAnonymousString != null) && (paramAnonymousq != null) && (paramAnonymousq.size() > 0)) {
              if (paramAnonymousString.getCount() != 0) {
                break label189;
              }
            }
          }
          label169:
          label189:
          for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
          {
            paramAnonymousString.ppW = paramAnonymousq;
            if (paramAnonymousInt1 != 0) {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(5778);
                  Log.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
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
      com.tencent.mm.kernel.g.azz().a(new j(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!Util.isNullOrNil(paramBundle)) {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5780);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).Qwv.performClick();
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
    ag.bas().aZX();
    AppMethodBeat.o(5788);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI
 * JD-Core Version:    0.7.0.1
 */