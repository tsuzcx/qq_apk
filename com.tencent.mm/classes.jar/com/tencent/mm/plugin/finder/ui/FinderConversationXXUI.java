package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.HashMap;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationXXUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "tipDialog", "Landroid/app/ProgressDialog;", "getTipDialog", "()Landroid/app/ProgressDialog;", "setTipDialog", "(Landroid/app/ProgressDialog;)V", "doSomethingOnConvDel", "", "getLayoutId", "", "getTitleResId", "isLastHiSession", "", "onChattingUIExit", "showMoreSheet", "updateActionBar", "talkerType", "plugin-finder_release"})
public final class FinderConversationXXUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  private ProgressDialog fMu;
  
  public final boolean ZC()
  {
    AppMethodBeat.i(203942);
    if ((this.sAZ.nZa.size() == 1) && (((c)this.sAZ.nZa.get(0)).field_type != 1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setResult(1);
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(203942);
      return true;
    }
    boolean bool = super.ZC();
    AppMethodBeat.o(203942);
    return bool;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203943);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(203943);
    return localView1;
  }
  
  public final int cJA()
  {
    return 2131766544;
  }
  
  public final void cJy()
  {
    AppMethodBeat.i(203941);
    ProgressDialog localProgressDialog = this.fMu;
    if (localProgressDialog != null)
    {
      ad.i("Finder.FinderConversationParentUI", "datasize " + this.sAZ.nZa.isEmpty());
      if ((this.sAZ.nZa.isEmpty()) && (localProgressDialog.isShowing()))
      {
        ad.i("Finder.FinderConversationParentUI", "clear hello conv finish");
        localProgressDialog = this.fMu;
        if (localProgressDialog != null) {
          localProgressDialog.dismiss();
        }
        this.fMu = null;
      }
      AppMethodBeat.o(203941);
      return;
    }
    AppMethodBeat.o(203941);
  }
  
  public final int getLayoutId()
  {
    return 2131496390;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationXXUI
 * JD-Core Version:    0.7.0.1
 */