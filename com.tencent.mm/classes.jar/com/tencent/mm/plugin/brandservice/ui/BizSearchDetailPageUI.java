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
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private int fRv;
  private int fq;
  private r mSearchViewHelper;
  private BizSearchResultItemContainer odb;
  private long odc;
  private String odd;
  private int ode;
  private Runnable odf;
  
  public BizSearchDetailPageUI()
  {
    AppMethodBeat.i(5617);
    this.odf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5613);
        BizSearchDetailPageUI.c(BizSearchDetailPageUI.this).cA(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this), BizSearchDetailPageUI.b(BizSearchDetailPageUI.this));
        BizSearchDetailPageUI.d(BizSearchDetailPageUI.this);
        AppMethodBeat.o(5613);
      }
    };
    AppMethodBeat.o(5617);
  }
  
  public final boolean JO(String paramString)
  {
    return false;
  }
  
  public final void JP(String paramString)
  {
    AppMethodBeat.i(5622);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5622);
      return;
    }
    paramString = paramString.trim();
    if (!paramString.equals(this.odd))
    {
      ar.ay(this.odf);
      this.odd = paramString;
      ar.o(this.odf, 400L);
    }
    AppMethodBeat.o(5622);
  }
  
  public final void aSL()
  {
    AppMethodBeat.i(5623);
    finish();
    AppMethodBeat.o(5623);
  }
  
  public final void aSM() {}
  
  public final void aSN() {}
  
  public final void aSO() {}
  
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
    this.odc = paramBundle.getLongExtra("businessType", 0L);
    boolean bool1 = paramBundle.getBooleanExtra("showEditText", false);
    this.fRv = paramBundle.getIntExtra("fromScene", 0);
    this.ode = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool2 = paramBundle.getBooleanExtra("showCatalog", false);
    this.fq = paramBundle.getIntExtra("offset", 0);
    if ((this.odc == 0L) || (bu.isNullOrNil(str)))
    {
      ae.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.odc) });
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
        paramBundle = (qt)new qt().parseFrom(paramBundle);
        if (paramBundle != null) {
          i = 1;
        }
        this.odb = ((BizSearchResultItemContainer)findViewById(2131304388));
        this.odb.setAdapter(new c(this));
        this.odb.setBusinessTypes(new long[] { this.odc });
        this.odb.setMode(1);
        this.odb.setDisplayArgs$25decb5(bool2);
        this.odb.setScene(this.fRv);
        this.odb.setAddContactScene(this.ode);
        this.odb.setReporter(new c.b()
        {
          public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(5615);
            qt localqt;
            StringBuilder localStringBuilder;
            if ((BizSearchDetailPageUI.e(BizSearchDetailPageUI.this) == 1) && (paramAnonymousa.type == 5))
            {
              paramAnonymousa = (ra)paramAnonymousa.getData();
              if ((paramAnonymousa.Gfp == null) || (paramAnonymousa.Gfp.GeN == null))
              {
                ae.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                AppMethodBeat.o(5615);
                return;
              }
              localqt = paramAnonymousc.zs(paramAnonymousInt3);
              localStringBuilder = new StringBuilder().append(bu.nullAsNil(BizSearchDetailPageUI.a(BizSearchDetailPageUI.this))).append(",").append(paramAnonymousInt1).append(",").append(bu.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.odl).append(",");
              if (localqt != null) {
                break label237;
              }
            }
            label237:
            for (paramAnonymousc = "";; paramAnonymousc = localqt.GeS + ",1")
            {
              paramAnonymousc = paramAnonymousc;
              g.yxI.kvStat(10866, paramAnonymousc);
              ae.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : ".concat(String.valueOf(paramAnonymousc)));
              if ((paramAnonymousa.Gfp.GeN.Hhu & 0x8) > 0) {
                g.yxI.kvStat(10298, paramAnonymousString + ",35");
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
          this.mSearchViewHelper.yP(false);
          this.mSearchViewHelper.clearFocus();
          this.mSearchViewHelper.setSearchContent(str);
          this.mSearchViewHelper.Lhk = this;
          this.odb.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(5616);
              b localb = new b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/BizSearchDetailPageUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
          localObject = this.odb;
          i = this.fq;
          ((BizSearchResultItemContainer)localObject).reset();
          if (paramBundle != null) {
            break label445;
          }
          ae.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
          AppMethodBeat.o(5618);
          return;
        }
      }
      catch (IOException paramBundle)
      {
        ae.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", paramBundle, "", new Object[0]);
        finish();
        AppMethodBeat.o(5618);
        return;
      }
      if (!bu.isNullOrNil((String)localObject))
      {
        setMMTitle((String)localObject);
        continue;
        label445:
        ((BizSearchResultItemContainer)localObject).odv.dmf = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.GeP });
        ((BizSearchResultItemContainer)localObject).odv.continueFlag = paramBundle.GeQ;
        ((BizSearchResultItemContainer)localObject).odA = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).odt.l(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).odv.offset = (i + paramBundle.GeT);
        paramBundle = ((BizSearchResultItemContainer)localObject).odv;
        if (!((BizSearchResultItemContainer)localObject).odt.isEmpty()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.isSearchMode = bool1;
          AppMethodBeat.o(5618);
          return;
        }
        label571:
        JP(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI
 * JD-Core Version:    0.7.0.1
 */