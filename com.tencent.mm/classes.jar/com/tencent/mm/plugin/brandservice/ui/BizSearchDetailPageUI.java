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
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI
  extends MMActivity
  implements s.b
{
  private int fs;
  private int gwE;
  private s mSearchViewHelper;
  private BizSearchResultItemContainer pnY;
  private long pnZ;
  private String poa;
  private int pob;
  private Runnable poc;
  
  public BizSearchDetailPageUI()
  {
    AppMethodBeat.i(5617);
    this.poc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5613);
        BizSearchDetailPageUI.c(BizSearchDetailPageUI.this).cH(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this), BizSearchDetailPageUI.b(BizSearchDetailPageUI.this));
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
    if (!paramString.equals(this.poa))
    {
      MMHandlerThread.removeRunnable(this.poc);
      this.poa = paramString;
      MMHandlerThread.postToMainThreadDelayed(this.poc, 400L);
    }
    AppMethodBeat.o(5622);
  }
  
  public final void bnA() {}
  
  public final void bnB() {}
  
  public final void bny()
  {
    AppMethodBeat.i(5623);
    finish();
    AppMethodBeat.o(5623);
  }
  
  public final void bnz() {}
  
  public int getLayoutId()
  {
    return 2131493245;
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
    this.pnZ = paramBundle.getLongExtra("businessType", 0L);
    boolean bool1 = paramBundle.getBooleanExtra("showEditText", false);
    this.gwE = paramBundle.getIntExtra("fromScene", 0);
    this.pob = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool2 = paramBundle.getBooleanExtra("showCatalog", false);
    this.fs = paramBundle.getIntExtra("offset", 0);
    if ((this.pnZ == 0L) || (Util.isNullOrNil(str)))
    {
      Log.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.pnZ) });
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
        paramBundle = (ru)new ru().parseFrom(paramBundle);
        if (paramBundle != null) {
          i = 1;
        }
        this.pnY = ((BizSearchResultItemContainer)findViewById(2131307353));
        this.pnY.setAdapter(new c(this));
        this.pnY.setBusinessTypes(new long[] { this.pnZ });
        this.pnY.setMode(1);
        this.pnY.setDisplayArgs$25decb5(bool2);
        this.pnY.setScene(this.gwE);
        this.pnY.setAddContactScene(this.pob);
        this.pnY.setReporter(new c.b()
        {
          public final void a(c paramAnonymousc, a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(5615);
            ru localru;
            StringBuilder localStringBuilder;
            if ((BizSearchDetailPageUI.e(BizSearchDetailPageUI.this) == 1) && (paramAnonymousa.type == 5))
            {
              paramAnonymousa = (sb)paramAnonymousa.getData();
              if ((paramAnonymousa.KZG == null) || (paramAnonymousa.KZG.KZe == null))
              {
                Log.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                AppMethodBeat.o(5615);
                return;
              }
              localru = paramAnonymousc.CX(paramAnonymousInt3);
              localStringBuilder = new StringBuilder().append(Util.nullAsNil(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this))).append(",").append(paramAnonymousInt1).append(",").append(Util.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.poi).append(",");
              if (localru != null) {
                break label237;
              }
            }
            label237:
            for (paramAnonymousc = "";; paramAnonymousc = localru.KZj + ",1")
            {
              paramAnonymousc = paramAnonymousc;
              h.CyF.kvStat(10866, paramAnonymousc);
              Log.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(paramAnonymousc)));
              if ((paramAnonymousa.KZG.KZe.MmK & 0x8) > 0) {
                h.CyF.kvStat(10298, paramAnonymousString + ",35");
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
          this.mSearchViewHelper.CK(false);
          this.mSearchViewHelper.clearFocus();
          this.mSearchViewHelper.setSearchContent(str);
          this.mSearchViewHelper.Qwi = this;
          this.pnY.setOnTouchListener(new View.OnTouchListener()
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
          localObject = this.pnY;
          i = this.fs;
          ((BizSearchResultItemContainer)localObject).reset();
          if (paramBundle != null) {
            break label445;
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
        label445:
        ((BizSearchResultItemContainer)localObject).pot.dDv = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.KZg });
        ((BizSearchResultItemContainer)localObject).pot.continueFlag = paramBundle.KZh;
        ((BizSearchResultItemContainer)localObject).poy = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).poq.m(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).pot.offset = (i + paramBundle.KZk);
        paramBundle = ((BizSearchResultItemContainer)localObject).pot;
        if (!((BizSearchResultItemContainer)localObject).poq.isEmpty()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.isSearchMode = bool1;
          AppMethodBeat.o(5618);
          return;
        }
        label571:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI
 * JD-Core Version:    0.7.0.1
 */