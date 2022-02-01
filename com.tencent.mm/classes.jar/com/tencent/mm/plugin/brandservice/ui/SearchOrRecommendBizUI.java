package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.o.a;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;
import java.util.LinkedList;

public class SearchOrRecommendBizUI
  extends MMActivity
  implements BizSearchResultItemContainer.b
{
  private int jaR = 0;
  private BizSearchResultItemContainer swY;
  private ProgressDialog syZ = null;
  private int sza = 0;
  private SearchViewNotRealTimeHelper szb;
  
  public final void czA()
  {
    AppMethodBeat.i(5790);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(d.i.app_tip);
    this.syZ = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(d.i.svg), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5786);
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface.sxu);
        paramAnonymousDialogInterface.sxs.sxF = false;
        AppMethodBeat.o(5786);
      }
    });
    AppMethodBeat.o(5790);
  }
  
  public final void czB()
  {
    AppMethodBeat.i(5791);
    if (this.syZ != null)
    {
      this.syZ.dismiss();
      this.syZ = null;
    }
    AppMethodBeat.o(5791);
  }
  
  public int getLayoutId()
  {
    return d.f.suh;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5789);
    setMMTitle(d.i.svh);
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
    this.szb = ((SearchViewNotRealTimeHelper)findViewById(d.e.dTs));
    this.szb.setSearchColor(getResources().getColor(d.b.normal_text_color));
    this.szb.setSearchHint(getString(d.i.svh));
    this.szb.setSearchHintColor(getResources().getColor(d.b.hint_color_white_bg));
    this.szb.setSearchIcon(0);
    this.szb.setShowBackIcon(false);
    this.szb.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final boolean aat(String paramAnonymousString)
      {
        AppMethodBeat.i(5783);
        apz(paramAnonymousString);
        AppMethodBeat.o(5783);
        return true;
      }
      
      public final void apz(String paramAnonymousString)
      {
        AppMethodBeat.i(5784);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.hideVKB();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).dc(paramAnonymousString, 0);
          AppMethodBeat.o(5784);
          return;
        }
        com.tencent.mm.ui.base.h.cO(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(d.i.svf));
        AppMethodBeat.o(5784);
      }
      
      public final void czL()
      {
        AppMethodBeat.i(5785);
        SearchOrRecommendBizUI.this.showVKB();
        AppMethodBeat.o(5785);
      }
    });
    this.swY = ((BizSearchResultItemContainer)findViewById(d.e.ssQ));
    this.swY.setOnTouchListener(new View.OnTouchListener()
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
    localg.syV = k.czu();
    this.swY.setAdapter(localg);
    this.swY.setBusinessTypes(new long[] { 1L });
    this.swY.lx(false);
    this.swY.setMode(1);
    this.swY.setScene(this.jaR);
    this.swY.setIOnSearchStateChangedListener(this);
    AppMethodBeat.o(5789);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5787);
    super.onCreate(paramBundle);
    this.sza = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.jaR = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (k.czt())
    {
      com.tencent.mm.kernel.h.aGY().a(456, new i()
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
          com.tencent.mm.kernel.h.aGY().b(456, this);
          Log.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousq = k.czu();
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
            paramAnonymousString.syV = paramAnonymousq;
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
      com.tencent.mm.kernel.h.aGY().a(new k(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!Util.isNullOrNil(paramBundle)) {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5780);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).XUA.performClick();
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
    af.bjG().bjm();
    AppMethodBeat.o(5788);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI
 * JD-Core Version:    0.7.0.1
 */