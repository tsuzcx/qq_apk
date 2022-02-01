package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationXXUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "tipDialog", "Landroid/app/ProgressDialog;", "getTipDialog", "()Landroid/app/ProgressDialog;", "setTipDialog", "(Landroid/app/ProgressDialog;)V", "doSomethingOnConvDel", "", "getLayoutId", "", "getTitleResId", "", "isLastHiSession", "", "onChattingUIExit", "showMoreSheet", "updateActionBar", "talkerType", "plugin-finder_release"})
public final class FinderConversationXXUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  private ProgressDialog iXX;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(279952);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(279952);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(279951);
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
    AppMethodBeat.o(279951);
    return localView1;
  }
  
  public final boolean atz()
  {
    AppMethodBeat.i(279950);
    if ((this.AoM.syG.size() == 1) && (((d)this.AoM.syG.get(0)).field_type != 1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setResult(1);
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(279950);
      return true;
    }
    boolean bool = super.atz();
    AppMethodBeat.o(279950);
    return bool;
  }
  
  public final void dZR()
  {
    AppMethodBeat.i(279949);
    ProgressDialog localProgressDialog = this.iXX;
    if (localProgressDialog != null)
    {
      Log.i("Finder.FinderConversationParentUI", "datasize " + this.AoM.syG.isEmpty());
      if ((this.AoM.syG.isEmpty()) && (localProgressDialog.isShowing()))
      {
        Log.i("Finder.FinderConversationParentUI", "clear hello conv finish");
        localProgressDialog = this.iXX;
        if (localProgressDialog != null) {
          localProgressDialog.dismiss();
        }
        this.iXX = null;
      }
      AppMethodBeat.o(279949);
      return;
    }
    AppMethodBeat.o(279949);
  }
  
  public final String duZ()
  {
    AppMethodBeat.i(279947);
    String str = getString(b.j.finder_conversation_hello_message_title);
    p.j(str, "this.getString(R.string.…tion_hello_message_title)");
    AppMethodBeat.o(279947);
    return str;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_conversation_ui;
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