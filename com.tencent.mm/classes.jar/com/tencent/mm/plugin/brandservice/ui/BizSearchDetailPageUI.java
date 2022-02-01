package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI
  extends MMActivity
  implements r.b
{
  private int MW;
  private int fwc;
  private r mSearchViewHelper;
  private BizSearchResultItemContainer nvU;
  private long nvV;
  private String nvW;
  private int nvX;
  private Runnable nvY;
  
  public BizSearchDetailPageUI()
  {
    AppMethodBeat.i(5617);
    this.nvY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5613);
        BizSearchDetailPageUI.c(BizSearchDetailPageUI.this).ct(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this), BizSearchDetailPageUI.b(BizSearchDetailPageUI.this));
        BizSearchDetailPageUI.d(BizSearchDetailPageUI.this);
        AppMethodBeat.o(5613);
      }
    };
    AppMethodBeat.o(5617);
  }
  
  public final boolean Ga(String paramString)
  {
    return false;
  }
  
  public final void Gb(String paramString)
  {
    AppMethodBeat.i(5622);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5622);
      return;
    }
    paramString = paramString.trim();
    if (!paramString.equals(this.nvW))
    {
      ap.aB(this.nvY);
      this.nvW = paramString;
      ap.n(this.nvY, 400L);
    }
    AppMethodBeat.o(5622);
  }
  
  public final void aPa()
  {
    AppMethodBeat.i(5623);
    finish();
    AppMethodBeat.o(5623);
  }
  
  public final void aPb() {}
  
  public final void aPc() {}
  
  public final void aPd() {}
  
  public int getLayoutId()
  {
    return 2131493199;
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
    this.nvV = paramBundle.getLongExtra("businessType", 0L);
    boolean bool1 = paramBundle.getBooleanExtra("showEditText", false);
    this.fwc = paramBundle.getIntExtra("fromScene", 0);
    this.nvX = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool2 = paramBundle.getBooleanExtra("showCatalog", false);
    this.MW = paramBundle.getIntExtra("offset", 0);
    if ((this.nvV == 0L) || (bs.isNullOrNil(str)))
    {
      ac.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.nvV) });
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
        paramBundle = (pm)new pm().parseFrom(paramBundle);
        if (paramBundle != null) {
          i = 1;
        }
        this.nvU = ((BizSearchResultItemContainer)findViewById(2131304388));
        this.nvU.setAdapter(new c(this));
        this.nvU.setBusinessTypes(new long[] { this.nvV });
        this.nvU.setMode(1);
        this.nvU.setDisplayArgs$25decb5(bool2);
        this.nvU.setScene(this.fwc);
        this.nvU.setAddContactScene(this.nvX);
        this.nvU.setReporter(new c.b()
        {
          public final void a(c paramAnonymousc, a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(5615);
            pm localpm;
            StringBuilder localStringBuilder;
            if ((BizSearchDetailPageUI.e(BizSearchDetailPageUI.this) == 1) && (paramAnonymousa.type == 5))
            {
              paramAnonymousa = (pt)paramAnonymousa.getData();
              if ((paramAnonymousa.Egr == null) || (paramAnonymousa.Egr.EfP == null))
              {
                ac.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                AppMethodBeat.o(5615);
                return;
              }
              localpm = paramAnonymousc.yz(paramAnonymousInt3);
              localStringBuilder = new StringBuilder().append(bs.nullAsNil(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this))).append(",").append(paramAnonymousInt1).append(",").append(bs.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.nwe).append(",");
              if (localpm != null) {
                break label237;
              }
            }
            label237:
            for (paramAnonymousc = "";; paramAnonymousc = localpm.EfU + ",1")
            {
              paramAnonymousc = paramAnonymousc;
              h.wUl.kvStat(10866, paramAnonymousc);
              ac.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(paramAnonymousc)));
              if ((paramAnonymousa.Egr.EfP.Feq & 0x8) > 0) {
                h.wUl.kvStat(10298, paramAnonymousString + ",35");
              }
              AppMethodBeat.o(5615);
              return;
            }
          }
        });
        if (bool1)
        {
          this.mSearchViewHelper = new r();
          addSearchMenu(true, this.mSearchViewHelper);
          this.mSearchViewHelper.xO(false);
          this.mSearchViewHelper.clearFocus();
          this.mSearchViewHelper.setSearchContent(str);
          this.mSearchViewHelper.ITM = this;
          this.nvU.setOnTouchListener(new View.OnTouchListener()
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
            break label571;
          }
          localObject = this.nvU;
          i = this.MW;
          ((BizSearchResultItemContainer)localObject).reset();
          if (paramBundle != null) {
            break label445;
          }
          ac.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
          AppMethodBeat.o(5618);
          return;
        }
      }
      catch (IOException paramBundle)
      {
        ac.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", paramBundle, "", new Object[0]);
        finish();
        AppMethodBeat.o(5618);
        return;
      }
      if (!bs.isNullOrNil((String)localObject))
      {
        setMMTitle((String)localObject);
        continue;
        label445:
        ((BizSearchResultItemContainer)localObject).nwo.cZL = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.EfR });
        ((BizSearchResultItemContainer)localObject).nwo.continueFlag = paramBundle.EfS;
        ((BizSearchResultItemContainer)localObject).nwt = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).nwm.k(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).nwo.offset = (i + paramBundle.EfV);
        paramBundle = ((BizSearchResultItemContainer)localObject).nwo;
        if (!((BizSearchResultItemContainer)localObject).nwm.isEmpty()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.isSearchMode = bool1;
          AppMethodBeat.o(5618);
          return;
        }
        label571:
        Gb(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI
 * JD-Core Version:    0.7.0.1
 */