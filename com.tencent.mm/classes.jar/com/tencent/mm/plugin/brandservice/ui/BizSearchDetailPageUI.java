package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.tools.n.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI
  extends MMActivity
  implements n.b
{
  private int El;
  private int drX;
  private n icu;
  private BizSearchResultItemContainer icv;
  private long icw;
  private String icx;
  private int icy;
  private Runnable icz = new BizSearchDetailPageUI.1(this);
  
  public final void Wl()
  {
    finish();
  }
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  protected final int getLayoutId()
  {
    return b.e.biz_search_detail_page_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = true;
    super.onCreate(paramBundle);
    setBackBtn(new BizSearchDetailPageUI.2(this));
    paramBundle = getIntent();
    this.icw = paramBundle.getLongExtra("businessType", 0L);
    boolean bool2 = paramBundle.getBooleanExtra("showEditText", false);
    this.drX = paramBundle.getIntExtra("fromScene", 0);
    this.icy = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool3 = paramBundle.getBooleanExtra("showCatalog", false);
    this.El = paramBundle.getIntExtra("offset", 0);
    if ((this.icw == 0L) || (bk.bl(str)))
    {
      y.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.icw) });
      finish();
      return;
    }
    paramBundle = paramBundle.getByteArrayExtra("result");
    if (paramBundle != null) {}
    for (;;)
    {
      int i;
      try
      {
        paramBundle = (kq)new kq().aH(paramBundle);
        if (paramBundle == null) {
          break label538;
        }
        i = 1;
        this.icv = ((BizSearchResultItemContainer)findViewById(b.d.searchResultItemContainer));
        this.icv.setAdapter(new c(this));
        this.icv.setBusinessTypes(new long[] { this.icw });
        this.icv.setMode(1);
        this.icv.setDisplayArgs$25decb5(bool3);
        this.icv.setScene(this.drX);
        this.icv.setAddContactScene(this.icy);
        this.icv.setReporter(new BizSearchDetailPageUI.3(this));
        if (bool2)
        {
          this.icu = new n();
          a(this.icu);
          this.icu.nK(false);
          this.icu.clearFocus();
          this.icu.setSearchContent(str);
          this.icu.weq = this;
          this.icv.setOnTouchListener(new BizSearchDetailPageUI.4(this));
          if (i == 0) {
            break label531;
          }
          localObject = this.icv;
          i = this.El;
          ((BizSearchResultItemContainer)localObject).reset();
          if (paramBundle != null) {
            break label416;
          }
          y.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
          return;
        }
      }
      catch (IOException paramBundle)
      {
        y.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", paramBundle, "", new Object[0]);
        finish();
        return;
      }
      if (!bk.bl((String)localObject))
      {
        setMMTitle((String)localObject);
        continue;
        label416:
        ((BizSearchResultItemContainer)localObject).icQ.bGm = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.sFC });
        ((BizSearchResultItemContainer)localObject).icQ.icI = paramBundle.sFD;
        ((BizSearchResultItemContainer)localObject).icV = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).icO.h(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).icQ.offset = (i + paramBundle.sDT);
        paramBundle = ((BizSearchResultItemContainer)localObject).icQ;
        if (!((BizSearchResultItemContainer)localObject).icO.isEmpty()) {}
        for (;;)
        {
          paramBundle.ide = bool1;
          return;
          bool1 = false;
        }
        label531:
        pC(str);
        return;
        label538:
        i = 0;
        continue;
        i = 0;
        paramBundle = null;
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.icu != null) {
      this.icu.a(this, paramMenu);
    }
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.icu != null) {
      this.icu.clearFocus();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.icu != null) {
      this.icu.a(this, paramMenu);
    }
    return true;
  }
  
  public final boolean pB(String paramString)
  {
    return false;
  }
  
  public final void pC(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return;
      paramString = paramString.trim();
    } while (paramString.equals(this.icx));
    ai.S(this.icz);
    this.icx = paramString;
    ai.l(this.icz, 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI
 * JD-Core Version:    0.7.0.1
 */