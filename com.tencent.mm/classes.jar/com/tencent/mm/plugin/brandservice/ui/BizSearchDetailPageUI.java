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
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.t.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI
  extends MMActivity
  implements t.b
{
  private int jaR;
  private t mSearchViewHelper;
  private BizSearchResultItemContainer swY;
  private long swZ;
  private String sxa;
  private int sxb;
  private Runnable sxc;
  private int zP;
  
  public BizSearchDetailPageUI()
  {
    AppMethodBeat.i(5617);
    this.sxc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5613);
        BizSearchDetailPageUI.c(BizSearchDetailPageUI.this).dc(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this), BizSearchDetailPageUI.b(BizSearchDetailPageUI.this));
        BizSearchDetailPageUI.d(BizSearchDetailPageUI.this);
        AppMethodBeat.o(5613);
      }
    };
    AppMethodBeat.o(5617);
  }
  
  public final boolean aat(String paramString)
  {
    return false;
  }
  
  public final void aau(String paramString)
  {
    AppMethodBeat.i(5622);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5622);
      return;
    }
    paramString = paramString.trim();
    if (!paramString.equals(this.sxa))
    {
      MMHandlerThread.removeRunnable(this.sxc);
      this.sxa = paramString;
      MMHandlerThread.postToMainThreadDelayed(this.sxc, 400L);
    }
    AppMethodBeat.o(5622);
  }
  
  public final void bxH()
  {
    AppMethodBeat.i(5623);
    finish();
    AppMethodBeat.o(5623);
  }
  
  public final void bxI() {}
  
  public final void bxJ() {}
  
  public final void bxK() {}
  
  public int getLayoutId()
  {
    return d.f.stE;
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
    this.swZ = paramBundle.getLongExtra("businessType", 0L);
    boolean bool1 = paramBundle.getBooleanExtra("showEditText", false);
    this.jaR = paramBundle.getIntExtra("fromScene", 0);
    this.sxb = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool2 = paramBundle.getBooleanExtra("showCatalog", false);
    this.zP = paramBundle.getIntExtra("offset", 0);
    if ((this.swZ == 0L) || (Util.isNullOrNil(str)))
    {
      Log.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.swZ) });
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
        paramBundle = (rn)new rn().parseFrom(paramBundle);
        if (paramBundle != null) {
          i = 1;
        }
        this.swY = ((BizSearchResultItemContainer)findViewById(d.e.ssQ));
        this.swY.setAdapter(new c(this));
        this.swY.setBusinessTypes(new long[] { this.swZ });
        this.swY.setMode(1);
        this.swY.lx(bool2);
        this.swY.setScene(this.jaR);
        this.swY.setAddContactScene(this.sxb);
        this.swY.setReporter(new c.b()
        {
          public final void a(c paramAnonymousc, a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(5615);
            rn localrn;
            StringBuilder localStringBuilder;
            if ((BizSearchDetailPageUI.e(BizSearchDetailPageUI.this) == 1) && (paramAnonymousa.type == 5))
            {
              paramAnonymousa = (ru)paramAnonymousa.getData();
              if ((paramAnonymousa.SaP == null) || (paramAnonymousa.SaP.San == null))
              {
                Log.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                AppMethodBeat.o(5615);
                return;
              }
              localrn = paramAnonymousc.GD(paramAnonymousInt3);
              localStringBuilder = new StringBuilder().append(Util.nullAsNil(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this))).append(",").append(paramAnonymousInt1).append(",").append(Util.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.sxi).append(",");
              if (localrn != null) {
                break label237;
              }
            }
            label237:
            for (paramAnonymousc = "";; paramAnonymousc = localrn.Sas + ",1")
            {
              paramAnonymousc = paramAnonymousc;
              h.IzE.kvStat(10866, paramAnonymousc);
              Log.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(paramAnonymousc)));
              if ((paramAnonymousa.SaP.San.TxF & 0x8) > 0) {
                h.IzE.kvStat(10298, paramAnonymousString + ",35");
              }
              AppMethodBeat.o(5615);
              return;
            }
          }
        });
        if (bool1)
        {
          this.mSearchViewHelper = new t();
          addSearchMenu(true, this.mSearchViewHelper);
          this.mSearchViewHelper.He(false);
          this.mSearchViewHelper.clearFocus();
          this.mSearchViewHelper.setSearchContent(str);
          this.mSearchViewHelper.XUl = this;
          this.swY.setOnTouchListener(new View.OnTouchListener()
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
          localObject = this.swY;
          i = this.zP;
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
        ((BizSearchResultItemContainer)localObject).sxs.fwe = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.Sap });
        ((BizSearchResultItemContainer)localObject).sxs.continueFlag = paramBundle.Saq;
        ((BizSearchResultItemContainer)localObject).sxx = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).sxq.m(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).sxs.offset = (i + paramBundle.Sat);
        paramBundle = ((BizSearchResultItemContainer)localObject).sxs;
        if (!((BizSearchResultItemContainer)localObject).sxq.isEmpty()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.isSearchMode = bool1;
          AppMethodBeat.o(5618);
          return;
        }
        label572:
        aau(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI
 * JD-Core Version:    0.7.0.1
 */