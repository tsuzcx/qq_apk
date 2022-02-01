package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ewb;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI
  extends MMActivity
  implements s.c
{
  private int Sc;
  private int lCR;
  private s mSearchViewHelper;
  private BizSearchResultItemContainer vCF;
  private long vCG;
  private String vCH;
  private int vCI;
  private Runnable vCJ;
  
  public BizSearchDetailPageUI()
  {
    AppMethodBeat.i(5617);
    this.vCJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5613);
        BizSearchDetailPageUI.c(BizSearchDetailPageUI.this).dE(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this), BizSearchDetailPageUI.b(BizSearchDetailPageUI.this));
        BizSearchDetailPageUI.d(BizSearchDetailPageUI.this);
        AppMethodBeat.o(5613);
      }
    };
    AppMethodBeat.o(5617);
  }
  
  public final boolean SN(String paramString)
  {
    return false;
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(5622);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5622);
      return;
    }
    paramString = paramString.trim();
    if (!paramString.equals(this.vCH))
    {
      MMHandlerThread.removeRunnable(this.vCJ);
      this.vCH = paramString;
      MMHandlerThread.postToMainThreadDelayed(this.vCJ, 400L);
    }
    AppMethodBeat.o(5622);
  }
  
  public final void bWw()
  {
    AppMethodBeat.i(5623);
    finish();
    AppMethodBeat.o(5623);
  }
  
  public final void bWx() {}
  
  public final void bWy() {}
  
  public final void bWz() {}
  
  public int getLayoutId()
  {
    return d.f.biz_search_detail_page_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5618);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5614);
        BizSearchDetailPageUI.this.finish();
        AppMethodBeat.o(5614);
        return true;
      }
    });
    paramBundle = getIntent();
    this.vCG = paramBundle.getLongExtra("businessType", 0L);
    boolean bool1 = paramBundle.getBooleanExtra("showEditText", false);
    this.lCR = paramBundle.getIntExtra("fromScene", 0);
    this.vCI = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool2 = paramBundle.getBooleanExtra("showCatalog", false);
    this.Sc = paramBundle.getIntExtra("offset", 0);
    if ((this.vCG == 0L) || (Util.isNullOrNil(str)))
    {
      Log.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.vCG) });
      finish();
      AppMethodBeat.o(5618);
      return;
    }
    paramBundle = paramBundle.getByteArrayExtra("result");
    int j = 0;
    int i = 0;
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        paramBundle = (sy)new sy().parseFrom(paramBundle);
        if (paramBundle != null) {
          i = 1;
        }
        this.vCF = ((BizSearchResultItemContainer)findViewById(d.e.searchResultItemContainer));
        this.vCF.setAdapter(new c(this));
        this.vCF.setBusinessTypes(new long[] { this.vCG });
        this.vCF.setMode(1);
        this.vCF.mP(bool2);
        this.vCF.setScene(this.lCR);
        this.vCF.setAddContactScene(this.vCI);
        this.vCF.setReporter(new c.b()
        {
          public final void a(c paramAnonymousc, a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(5615);
            sy localsy;
            StringBuilder localStringBuilder;
            if ((BizSearchDetailPageUI.e(BizSearchDetailPageUI.this) == 1) && (paramAnonymousa.type == 5))
            {
              paramAnonymousa = (tf)paramAnonymousa.getData();
              if ((paramAnonymousa.YYO == null) || (paramAnonymousa.YYO.YYm == null))
              {
                Log.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                AppMethodBeat.o(5615);
                return;
              }
              localsy = paramAnonymousc.Hc(paramAnonymousInt3);
              localStringBuilder = new StringBuilder().append(Util.nullAsNil(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this))).append(",").append(paramAnonymousInt1).append(",").append(Util.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.vCP).append(",");
              if (localsy != null) {
                break label237;
              }
            }
            label237:
            for (paramAnonymousc = "";; paramAnonymousc = localsy.YYr + ",1")
            {
              paramAnonymousc = paramAnonymousc;
              h.OAn.kvStat(10866, paramAnonymousc);
              Log.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(paramAnonymousc)));
              if ((paramAnonymousa.YYO.YYm.aaMm & 0x8) > 0) {
                h.OAn.kvStat(10298, paramAnonymousString + ",35");
              }
              AppMethodBeat.o(5615);
              return;
            }
          }
        });
        if (bool1)
        {
          this.mSearchViewHelper = new s();
          addSearchMenu(true, this.mSearchViewHelper);
          this.mSearchViewHelper.MY(false);
          this.mSearchViewHelper.clearFocus();
          this.mSearchViewHelper.setSearchContent(str);
          this.mSearchViewHelper.afKz = this;
          this.vCF.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(5616);
              if (BizSearchDetailPageUI.f(BizSearchDetailPageUI.this) != null) {
                BizSearchDetailPageUI.f(BizSearchDetailPageUI.this).clearFocus();
              }
              BizSearchDetailPageUI.this.hideVKB();
              AppMethodBeat.o(5616);
              return false;
            }
          });
          if (i == 0) {
            break label572;
          }
          localObject = this.vCF;
          i = this.Sc;
          ((BizSearchResultItemContainer)localObject).reset();
          if (paramBundle != null) {
            break label446;
          }
          Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
          AppMethodBeat.o(5618);
          return;
        }
      }
      catch (IOException paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", paramBundle, "", new Object[0]);
        finish();
        AppMethodBeat.o(5618);
        return;
      }
      if (!Util.isNullOrNil((String)localObject))
      {
        setMMTitle((String)localObject);
        continue;
        label446:
        ((BizSearchResultItemContainer)localObject).vCZ.hAB = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.YYo });
        ((BizSearchResultItemContainer)localObject).vCZ.continueFlag = paramBundle.YYp;
        ((BizSearchResultItemContainer)localObject).vDe = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).vCX.r(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).vCZ.offset = (i + paramBundle.YYs);
        paramBundle = ((BizSearchResultItemContainer)localObject).vCZ;
        if (!((BizSearchResultItemContainer)localObject).vCX.isEmpty()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.isSearchMode = bool1;
          AppMethodBeat.o(5618);
          return;
        }
        label572:
        SO(str);
        AppMethodBeat.o(5618);
        return;
        paramBundle = null;
        i = j;
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5619);
    if (this.mSearchViewHelper != null) {
      this.mSearchViewHelper.a(this, paramMenu);
    }
    AppMethodBeat.o(5619);
    return true;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5621);
    super.onPause();
    if (this.mSearchViewHelper != null) {
      this.mSearchViewHelper.clearFocus();
    }
    AppMethodBeat.o(5621);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(5620);
    if (this.mSearchViewHelper != null) {
      this.mSearchViewHelper.a(this, paramMenu);
    }
    AppMethodBeat.o(5620);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI
 * JD-Core Version:    0.7.0.1
 */