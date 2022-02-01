package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationXXUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "tipDialog", "Landroid/app/ProgressDialog;", "getTipDialog", "()Landroid/app/ProgressDialog;", "setTipDialog", "(Landroid/app/ProgressDialog;)V", "doSomethingOnConvDel", "", "getLayoutId", "", "getTitleResId", "isLastHiSession", "", "onChattingUIExit", "showMoreSheet", "updateActionBar", "talkerType", "plugin-finder_release"})
public final class FinderConversationXXUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  private ProgressDialog gtM;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252236);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252236);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252235);
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
    AppMethodBeat.o(252235);
    return localView1;
  }
  
  public final boolean any()
  {
    AppMethodBeat.i(252234);
    if ((this.vHP.ppH.size() == 1) && (((c)this.vHP.ppH.get(0)).field_type != 1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setResult(1);
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(252234);
      return true;
    }
    boolean bool = super.any();
    AppMethodBeat.o(252234);
    return bool;
  }
  
  public final void dyZ()
  {
    AppMethodBeat.i(252233);
    ProgressDialog localProgressDialog = this.gtM;
    if (localProgressDialog != null)
    {
      Log.i("Finder.FinderConversationParentUI", "datasize " + this.vHP.ppH.isEmpty());
      if ((this.vHP.ppH.isEmpty()) && (localProgressDialog.isShowing()))
      {
        Log.i("Finder.FinderConversationParentUI", "clear hello conv finish");
        localProgressDialog = this.gtM;
        if (localProgressDialog != null) {
          localProgressDialog.dismiss();
        }
        this.gtM = null;
      }
      AppMethodBeat.o(252233);
      return;
    }
    AppMethodBeat.o(252233);
  }
  
  public final int dzb()
  {
    return 2131759619;
  }
  
  public final int getLayoutId()
  {
    return 2131494231;
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