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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI
  extends MMActivity
  implements r.b
{
  private int fPp;
  private int fq;
  private r mSearchViewHelper;
  private BizSearchResultItemContainer nXs;
  private long nXt;
  private String nXu;
  private int nXv;
  private Runnable nXw;
  
  public BizSearchDetailPageUI()
  {
    AppMethodBeat.i(5617);
    this.nXw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5613);
        BizSearchDetailPageUI.c(BizSearchDetailPageUI.this).cw(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this), BizSearchDetailPageUI.b(BizSearchDetailPageUI.this));
        BizSearchDetailPageUI.d(BizSearchDetailPageUI.this);
        AppMethodBeat.o(5613);
      }
    };
    AppMethodBeat.o(5617);
  }
  
  public final boolean Jp(String paramString)
  {
    return false;
  }
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(5622);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5622);
      return;
    }
    paramString = paramString.trim();
    if (!paramString.equals(this.nXu))
    {
      aq.aA(this.nXw);
      this.nXu = paramString;
      aq.o(this.nXw, 400L);
    }
    AppMethodBeat.o(5622);
  }
  
  public final void aSm()
  {
    AppMethodBeat.i(5623);
    finish();
    AppMethodBeat.o(5623);
  }
  
  public final void aSn() {}
  
  public final void aSo() {}
  
  public final void aSp() {}
  
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
    this.nXt = paramBundle.getLongExtra("businessType", 0L);
    boolean bool1 = paramBundle.getBooleanExtra("showEditText", false);
    this.fPp = paramBundle.getIntExtra("fromScene", 0);
    this.nXv = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool2 = paramBundle.getBooleanExtra("showCatalog", false);
    this.fq = paramBundle.getIntExtra("offset", 0);
    if ((this.nXt == 0L) || (bt.isNullOrNil(str)))
    {
      ad.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.nXt) });
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
        paramBundle = (qr)new qr().parseFrom(paramBundle);
        if (paramBundle != null) {
          i = 1;
        }
        this.nXs = ((BizSearchResultItemContainer)findViewById(2131304388));
        this.nXs.setAdapter(new c(this));
        this.nXs.setBusinessTypes(new long[] { this.nXt });
        this.nXs.setMode(1);
        this.nXs.setDisplayArgs$25decb5(bool2);
        this.nXs.setScene(this.fPp);
        this.nXs.setAddContactScene(this.nXv);
        this.nXs.setReporter(new c.b()
        {
          public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(5615);
            qr localqr;
            StringBuilder localStringBuilder;
            if ((BizSearchDetailPageUI.e(BizSearchDetailPageUI.this) == 1) && (paramAnonymousa.type == 5))
            {
              paramAnonymousa = (qy)paramAnonymousa.getData();
              if ((paramAnonymousa.FMQ == null) || (paramAnonymousa.FMQ.FMo == null))
              {
                ad.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                AppMethodBeat.o(5615);
                return;
              }
              localqr = paramAnonymousc.zj(paramAnonymousInt3);
              localStringBuilder = new StringBuilder().append(bt.nullAsNil(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this))).append(",").append(paramAnonymousInt1).append(",").append(bt.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.nXC).append(",");
              if (localqr != null) {
                break label237;
              }
            }
            label237:
            for (paramAnonymousc = "";; paramAnonymousc = localqr.FMt + ",1")
            {
              paramAnonymousc = paramAnonymousc;
              g.yhR.kvStat(10866, paramAnonymousc);
              ad.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(paramAnonymousc)));
              if ((paramAnonymousa.FMQ.FMo.GNU & 0x8) > 0) {
                g.yhR.kvStat(10298, paramAnonymousString + ",35");
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
          this.mSearchViewHelper.yC(false);
          this.mSearchViewHelper.clearFocus();
          this.mSearchViewHelper.setSearchContent(str);
          this.mSearchViewHelper.KKQ = this;
          this.nXs.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(5616);
              b localb = new b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/BizSearchDetailPageUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
              if (BizSearchDetailPageUI.f(BizSearchDetailPageUI.this) != null) {
                BizSearchDetailPageUI.f(BizSearchDetailPageUI.this).clearFocus();
              }
              BizSearchDetailPageUI.this.hideVKB();
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/BizSearchDetailPageUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(5616);
              return false;
            }
          });
          if (i == 0) {
            break label571;
          }
          localObject = this.nXs;
          i = this.fq;
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
        ((BizSearchResultItemContainer)localObject).nXM.dld = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.FMq });
        ((BizSearchResultItemContainer)localObject).nXM.continueFlag = paramBundle.FMr;
        ((BizSearchResultItemContainer)localObject).nXR = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).nXK.l(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).nXM.offset = (i + paramBundle.FMu);
        paramBundle = ((BizSearchResultItemContainer)localObject).nXM;
        if (!((BizSearchResultItemContainer)localObject).nXK.isEmpty()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.isSearchMode = bool1;
          AppMethodBeat.o(5618);
          return;
        }
        label571:
        Jq(str);
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