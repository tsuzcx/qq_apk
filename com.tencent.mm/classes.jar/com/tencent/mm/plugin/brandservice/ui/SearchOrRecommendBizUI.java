package com.tencent.mm.plugin.brandservice.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.an.o.a;
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
  private int lCR = 0;
  private BizSearchResultItemContainer vCF;
  private ProgressDialog vEG = null;
  private int vEH = 0;
  private SearchViewNotRealTimeHelper vEI;
  
  public final void dcs()
  {
    AppMethodBeat.i(5790);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(d.i.app_tip);
    this.vEG = com.tencent.mm.ui.base.k.a(localAppCompatActivity, getString(d.i.contact_search_recommend_biz_searching), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(5786);
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface.vDb);
        paramAnonymousDialogInterface.vCZ.vDm = false;
        AppMethodBeat.o(5786);
      }
    });
    AppMethodBeat.o(5790);
  }
  
  public final void dct()
  {
    AppMethodBeat.i(5791);
    if (this.vEG != null)
    {
      this.vEG.dismiss();
      this.vEG = null;
    }
    AppMethodBeat.o(5791);
  }
  
  public int getLayoutId()
  {
    return d.f.contact_search_recommend_biz;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5789);
    setMMTitle(d.i.contact_search_recommend_biz_title);
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
    this.vEI = ((SearchViewNotRealTimeHelper)findViewById(d.e.search_view));
    this.vEI.setSearchColor(getResources().getColor(d.b.normal_text_color));
    this.vEI.setSearchHint(getString(d.i.contact_search_recommend_biz_title));
    this.vEI.setSearchHintColor(getResources().getColor(d.b.hint_color_white_bg));
    this.vEI.setSearchIcon(0);
    this.vEI.setShowBackIcon(false);
    this.vEI.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final boolean SN(String paramAnonymousString)
      {
        AppMethodBeat.i(5783);
        aiU(paramAnonymousString);
        AppMethodBeat.o(5783);
        return true;
      }
      
      public final void aiU(String paramAnonymousString)
      {
        AppMethodBeat.i(5784);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.hideVKB();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).dE(paramAnonymousString, 0);
          AppMethodBeat.o(5784);
          return;
        }
        com.tencent.mm.ui.base.k.cZ(SearchOrRecommendBizUI.this.getContext(), SearchOrRecommendBizUI.this.getString(d.i.contact_search_recommend_biz_notext));
        AppMethodBeat.o(5784);
      }
      
      public final void dcD()
      {
        AppMethodBeat.i(5785);
        SearchOrRecommendBizUI.this.showVKB();
        AppMethodBeat.o(5785);
      }
    });
    this.vCF = ((BizSearchResultItemContainer)findViewById(d.e.searchResultItemContainer));
    this.vCF.setOnTouchListener(new View.OnTouchListener()
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
    h localh = new h(this);
    localh.vEC = com.tencent.mm.plugin.brandservice.model.k.dcm();
    this.vCF.setAdapter(localh);
    this.vCF.setBusinessTypes(new long[] { 1L });
    this.vCF.mP(false);
    this.vCF.setMode(1);
    this.vCF.setScene(this.lCR);
    this.vCF.setIOnSearchStateChangedListener(this);
    AppMethodBeat.o(5789);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(5787);
    super.onCreate(paramBundle);
    this.vEH = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.lCR = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (com.tencent.mm.plugin.brandservice.model.k.dcl())
    {
      com.tencent.mm.kernel.h.aZW().a(456, new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(5779);
          if (paramAnonymousp == null)
          {
            Log.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
            AppMethodBeat.o(5779);
            return;
          }
          if (paramAnonymousp.getType() != 456)
          {
            Log.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
            AppMethodBeat.o(5779);
            return;
          }
          com.tencent.mm.kernel.h.aZW().b(456, this);
          Log.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousp = com.tencent.mm.plugin.brandservice.model.k.dcm();
            if (SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this) != null) {
              break label169;
            }
            paramAnonymousString = null;
            if ((paramAnonymousString != null) && (paramAnonymousp != null) && (paramAnonymousp.size() > 0)) {
              if (paramAnonymousString.getCount() != 0) {
                break label186;
              }
            }
          }
          label169:
          label186:
          for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
          {
            paramAnonymousString.vEC = paramAnonymousp;
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
            paramAnonymousString = (h)SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).getAdapter();
            break;
          }
        }
      });
      com.tencent.mm.kernel.h.aZW().a(new com.tencent.mm.plugin.brandservice.model.k(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!Util.isNullOrNil(paramBundle)) {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5780);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).afKP.performClick();
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
    af.bHr().bGW();
    AppMethodBeat.o(5788);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI
 * JD-Core Version:    0.7.0.1
 */