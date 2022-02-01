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
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int LZ;
  private int fsv;
  private r mSearchViewHelper;
  private BizSearchResultItemContainer mTC;
  private long mTD;
  private String mTE;
  private int mTF;
  private Runnable mTG;
  
  public BizSearchDetailPageUI()
  {
    AppMethodBeat.i(5617);
    this.mTG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5613);
        BizSearchDetailPageUI.c(BizSearchDetailPageUI.this).co(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this), BizSearchDetailPageUI.b(BizSearchDetailPageUI.this));
        BizSearchDetailPageUI.d(BizSearchDetailPageUI.this);
        AppMethodBeat.o(5613);
      }
    };
    AppMethodBeat.o(5617);
  }
  
  public final boolean BX(String paramString)
  {
    return false;
  }
  
  public final void BY(String paramString)
  {
    AppMethodBeat.i(5622);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5622);
      return;
    }
    paramString = paramString.trim();
    if (!paramString.equals(this.mTE))
    {
      aq.az(this.mTG);
      this.mTE = paramString;
      aq.n(this.mTG, 400L);
    }
    AppMethodBeat.o(5622);
  }
  
  public final void aIj()
  {
    AppMethodBeat.i(5623);
    finish();
    AppMethodBeat.o(5623);
  }
  
  public final void aIk() {}
  
  public final void aIl() {}
  
  public final void aIm() {}
  
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
    this.mTD = paramBundle.getLongExtra("businessType", 0L);
    boolean bool1 = paramBundle.getBooleanExtra("showEditText", false);
    this.fsv = paramBundle.getIntExtra("fromScene", 0);
    this.mTF = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool2 = paramBundle.getBooleanExtra("showCatalog", false);
    this.LZ = paramBundle.getIntExtra("offset", 0);
    if ((this.mTD == 0L) || (bt.isNullOrNil(str)))
    {
      ad.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.mTD) });
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
        paramBundle = (pf)new pf().parseFrom(paramBundle);
        if (paramBundle != null) {
          i = 1;
        }
        this.mTC = ((BizSearchResultItemContainer)findViewById(2131304388));
        this.mTC.setAdapter(new c(this));
        this.mTC.setBusinessTypes(new long[] { this.mTD });
        this.mTC.setMode(1);
        this.mTC.setDisplayArgs$25decb5(bool2);
        this.mTC.setScene(this.fsv);
        this.mTC.setAddContactScene(this.mTF);
        this.mTC.setReporter(new c.b()
        {
          public final void a(c paramAnonymousc, a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(5615);
            pf localpf;
            StringBuilder localStringBuilder;
            if ((BizSearchDetailPageUI.e(BizSearchDetailPageUI.this) == 1) && (paramAnonymousa.type == 5))
            {
              paramAnonymousa = (pm)paramAnonymousa.getData();
              if ((paramAnonymousa.CNP == null) || (paramAnonymousa.CNP.CNn == null))
              {
                ad.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                AppMethodBeat.o(5615);
                return;
              }
              localpf = paramAnonymousc.xH(paramAnonymousInt3);
              localStringBuilder = new StringBuilder().append(bt.nullAsNil(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this))).append(",").append(paramAnonymousInt1).append(",").append(bt.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.mTM).append(",");
              if (localpf != null) {
                break label237;
              }
            }
            label237:
            for (paramAnonymousc = "";; paramAnonymousc = localpf.CNs + ",1")
            {
              paramAnonymousc = paramAnonymousc;
              h.vKh.kvStat(10866, paramAnonymousc);
              ad.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(paramAnonymousc)));
              if ((paramAnonymousa.CNP.CNn.DIV & 0x8) > 0) {
                h.vKh.kvStat(10298, paramAnonymousString + ",35");
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
          this.mSearchViewHelper.wH(false);
          this.mSearchViewHelper.clearFocus();
          this.mSearchViewHelper.setSearchContent(str);
          this.mSearchViewHelper.Htp = this;
          this.mTC.setOnTouchListener(new View.OnTouchListener()
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
          localObject = this.mTC;
          i = this.LZ;
          ((BizSearchResultItemContainer)localObject).reset();
          if (paramBundle != null) {
            break label445;
          }
          ad.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
          AppMethodBeat.o(5618);
          return;
        }
      }
      catch (IOException paramBundle)
      {
        ad.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", paramBundle, "", new Object[0]);
        finish();
        AppMethodBeat.o(5618);
        return;
      }
      if (!bt.isNullOrNil((String)localObject))
      {
        setMMTitle((String)localObject);
        continue;
        label445:
        ((BizSearchResultItemContainer)localObject).mTW.dcm = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.CNp });
        ((BizSearchResultItemContainer)localObject).mTW.continueFlag = paramBundle.CNq;
        ((BizSearchResultItemContainer)localObject).mUb = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).mTU.m(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).mTW.offset = (i + paramBundle.CNt);
        paramBundle = ((BizSearchResultItemContainer)localObject).mTW;
        if (!((BizSearchResultItemContainer)localObject).mTU.isEmpty()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.isSearchMode = bool1;
          AppMethodBeat.o(5618);
          return;
        }
        label571:
        BY(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI
 * JD-Core Version:    0.7.0.1
 */