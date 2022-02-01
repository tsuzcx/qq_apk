package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.HashMap;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationXXUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "tipDialog", "Landroid/app/ProgressDialog;", "getTipDialog", "()Landroid/app/ProgressDialog;", "setTipDialog", "(Landroid/app/ProgressDialog;)V", "doSomethingOnConvDel", "", "getLayoutId", "", "getTitleResId", "isLastHiSession", "", "onChattingUIExit", "showMoreSheet", "updateActionBar", "talkerType", "plugin-finder_release"})
public final class FinderConversationXXUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  private ProgressDialog fOC;
  
  public final boolean ZL()
  {
    AppMethodBeat.i(204538);
    if ((this.sLZ.oeJ.size() == 1) && (((c)this.sLZ.oeJ.get(0)).field_type != 1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setResult(1);
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(204538);
      return true;
    }
    boolean bool = super.ZL();
    AppMethodBeat.o(204538);
    return bool;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204539);
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
    AppMethodBeat.o(204539);
    return localView1;
  }
  
  public final void cMb()
  {
    AppMethodBeat.i(204537);
    ProgressDialog localProgressDialog = this.fOC;
    if (localProgressDialog != null)
    {
      ae.i("Finder.FinderConversationParentUI", "datasize " + this.sLZ.oeJ.isEmpty());
      if ((this.sLZ.oeJ.isEmpty()) && (localProgressDialog.isShowing()))
      {
        ae.i("Finder.FinderConversationParentUI", "clear hello conv finish");
        localProgressDialog = this.fOC;
        if (localProgressDialog != null) {
          localProgressDialog.dismiss();
        }
        this.fOC = null;
      }
      AppMethodBeat.o(204537);
      return;
    }
    AppMethodBeat.o(204537);
  }
  
  public final int cMd()
  {
    return 2131766544;
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