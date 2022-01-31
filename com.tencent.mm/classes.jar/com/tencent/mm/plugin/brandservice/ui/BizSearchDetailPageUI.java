package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.q.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI
  extends MMActivity
  implements q.b
{
  private int Fb;
  private int ejF;
  private BizSearchResultItemContainer jTk;
  private long jTl;
  private String jTm;
  private int jTn;
  private Runnable jTo;
  private q mSearchViewHelper;
  
  public BizSearchDetailPageUI()
  {
    AppMethodBeat.i(13879);
    this.jTo = new BizSearchDetailPageUI.1(this);
    AppMethodBeat.o(13879);
  }
  
  public final void apN()
  {
    AppMethodBeat.i(13885);
    finish();
    AppMethodBeat.o(13885);
  }
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public int getLayoutId()
  {
    return 2130968864;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13880);
    super.onCreate(paramBundle);
    setBackBtn(new BizSearchDetailPageUI.2(this));
    paramBundle = getIntent();
    this.jTl = paramBundle.getLongExtra("businessType", 0L);
    boolean bool1 = paramBundle.getBooleanExtra("showEditText", false);
    this.ejF = paramBundle.getIntExtra("fromScene", 0);
    this.jTn = paramBundle.getIntExtra("addContactScene", 35);
    Object localObject = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("keyword");
    boolean bool2 = paramBundle.getBooleanExtra("showCatalog", false);
    this.Fb = paramBundle.getIntExtra("offset", 0);
    if ((this.jTl == 0L) || (bo.isNullOrNil(str)))
    {
      ab.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[] { Long.valueOf(this.jTl) });
      finish();
      AppMethodBeat.o(13880);
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
        paramBundle = (nc)new nc().parseFrom(paramBundle);
        if (paramBundle != null) {
          i = 1;
        }
        this.jTk = ((BizSearchResultItemContainer)findViewById(2131821845));
        this.jTk.setAdapter(new c(this));
        this.jTk.setBusinessTypes(new long[] { this.jTl });
        this.jTk.setMode(1);
        this.jTk.setDisplayArgs$25decb5(bool2);
        this.jTk.setScene(this.ejF);
        this.jTk.setAddContactScene(this.jTn);
        this.jTk.setReporter(new BizSearchDetailPageUI.3(this));
        if (bool1)
        {
          this.mSearchViewHelper = new q();
          addSearchMenu(true, this.mSearchViewHelper);
          this.mSearchViewHelper.ru(false);
          this.mSearchViewHelper.clearFocus();
          this.mSearchViewHelper.setSearchContent(str);
          this.mSearchViewHelper.Axg = this;
          this.jTk.setOnTouchListener(new BizSearchDetailPageUI.4(this));
          if (i == 0) {
            break label568;
          }
          localObject = this.jTk;
          i = this.Fb;
          ((BizSearchResultItemContainer)localObject).reset();
          if (paramBundle != null) {
            break label442;
          }
          ab.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
          AppMethodBeat.o(13880);
          return;
        }
      }
      catch (IOException paramBundle)
      {
        ab.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", paramBundle, "", new Object[0]);
        finish();
        AppMethodBeat.o(13880);
        return;
      }
      if (!bo.isNullOrNil((String)localObject))
      {
        setMMTitle((String)localObject);
        continue;
        label442:
        ((BizSearchResultItemContainer)localObject).jTF.cnv = str;
        ((BizSearchResultItemContainer)localObject).setBusinessTypes(new long[] { paramBundle.wBW });
        ((BizSearchResultItemContainer)localObject).jTF.jTx = paramBundle.wBX;
        ((BizSearchResultItemContainer)localObject).jTK = i;
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(paramBundle);
        ((BizSearchResultItemContainer)localObject).jTD.i(str, localLinkedList);
        ((BizSearchResultItemContainer)localObject).jTF.offset = (i + paramBundle.wzS);
        paramBundle = ((BizSearchResultItemContainer)localObject).jTF;
        if (!((BizSearchResultItemContainer)localObject).jTD.isEmpty()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramBundle.isSearchMode = bool1;
          AppMethodBeat.o(13880);
          return;
        }
        label568:
        wS(str);
        AppMethodBeat.o(13880);
        return;
        paramBundle = null;
        i = j;
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(13881);
    if (this.mSearchViewHelper != null) {
      this.mSearchViewHelper.a(this, paramMenu);
    }
    AppMethodBeat.o(13881);
    return true;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13883);
    super.onPause();
    if (this.mSearchViewHelper != null) {
      this.mSearchViewHelper.clearFocus();
    }
    AppMethodBeat.o(13883);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(13882);
    if (this.mSearchViewHelper != null) {
      this.mSearchViewHelper.a(this, paramMenu);
    }
    AppMethodBeat.o(13882);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final boolean wR(String paramString)
  {
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(13884);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(13884);
      return;
    }
    paramString = paramString.trim();
    if (!paramString.equals(this.jTm))
    {
      al.ae(this.jTo);
      this.jTm = paramString;
      al.p(this.jTo, 400L);
    }
    AppMethodBeat.o(13884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI
 * JD-Core Version:    0.7.0.1
 */