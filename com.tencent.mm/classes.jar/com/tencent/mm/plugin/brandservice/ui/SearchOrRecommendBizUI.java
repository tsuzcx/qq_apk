package com.tencent.mm.plugin.brandservice.ui;

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
import android.widget.Button;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a;

public class SearchOrRecommendBizUI
  extends MMActivity
  implements BizSearchResultItemContainer.b
{
  private int drX = 0;
  private BizSearchResultItemContainer icv;
  private ProgressDialog iec = null;
  private int ied = 0;
  private SearchViewNotRealTimeHelper iee;
  
  public final void axA()
  {
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(b.h.app_tip);
    this.iec = h.b(localAppCompatActivity, getString(b.h.contact_search_recommend_biz_searching), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        paramAnonymousDialogInterface = SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this);
        g.Dk().c(paramAnonymousDialogInterface.icS);
        paramAnonymousDialogInterface.icQ.idd = false;
      }
    });
  }
  
  public final void axB()
  {
    if (this.iec != null)
    {
      this.iec.dismiss();
      this.iec = null;
    }
  }
  
  protected final int getLayoutId()
  {
    return b.e.contact_search_recommend_biz;
  }
  
  protected final void initView()
  {
    setMMTitle(b.h.contact_search_recommend_biz_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        SearchOrRecommendBizUI.this.XM();
        SearchOrRecommendBizUI.this.finish();
        return true;
      }
    });
    this.iee = ((SearchViewNotRealTimeHelper)findViewById(b.d.search_view));
    this.iee.setSearchColor(getResources().getColor(b.a.normal_text_color));
    this.iee.setSearchHint(getString(b.h.contact_search_recommend_biz_title));
    this.iee.setSearchHintColor(getResources().getColor(b.a.hint_color_white_bg));
    this.iee.setSearchIcon(0);
    this.iee.setShowBackIcon(false);
    this.iee.setCallBack(new SearchViewNotRealTimeHelper.a()
    {
      public final void axG()
      {
        SearchOrRecommendBizUI.this.showVKB();
      }
      
      public final boolean pB(String paramAnonymousString)
      {
        xR(paramAnonymousString);
        return true;
      }
      
      public final void xR(String paramAnonymousString)
      {
        if (!bk.bl(paramAnonymousString))
        {
          SearchOrRecommendBizUI.this.XM();
          SearchOrRecommendBizUI.a(SearchOrRecommendBizUI.this).bi(paramAnonymousString, 0);
          return;
        }
        h.bC(SearchOrRecommendBizUI.this.mController.uMN, SearchOrRecommendBizUI.this.getString(b.h.contact_search_recommend_biz_notext));
      }
    });
    this.icv = ((BizSearchResultItemContainer)findViewById(b.d.searchResultItemContainer));
    this.icv.setOnTouchListener(new SearchOrRecommendBizUI.4(this));
    f localf = new f(this);
    localf.idY = com.tencent.mm.plugin.brandservice.b.f.axu();
    this.icv.setAdapter(localf);
    this.icv.setBusinessTypes(new long[] { 1L });
    this.icv.setDisplayArgs$25decb5(false);
    this.icv.setMode(1);
    this.icv.setScene(this.drX);
    this.icv.setIOnSearchStateChangedListener(this);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ied = getIntent().getIntExtra("intent_extra_entry_flag", 0);
    this.drX = getIntent().getIntExtra("fromScene", 0);
    initView();
    if (com.tencent.mm.plugin.brandservice.b.f.axt())
    {
      g.Dk().a(456, new SearchOrRecommendBizUI.1(this));
      g.Dk().a(new com.tencent.mm.plugin.brandservice.b.f(), 0);
    }
    paramBundle = getIntent().getStringExtra("Search_Str");
    if (!bk.bl(paramBundle)) {
      new ah(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).setSearchContent(paramBundle);
          SearchOrRecommendBizUI.b(SearchOrRecommendBizUI.this).weC.performClick();
        }
      });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    z.MI().Ms();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI
 * JD-Core Version:    0.7.0.1
 */