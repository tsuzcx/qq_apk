package com.tencent.mm.plugin.finder.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTimelineShareDialog;", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "btnContainer", "Landroid/view/ViewGroup;", "cancelBtn", "Landroid/widget/TextView;", "contactContainer", "editText", "Landroid/widget/EditText;", "headerTitleText", "okBtn", "popupContainer", "shareContainer", "Landroid/widget/FrameLayout;", "titleImage", "Landroid/widget/ImageView;", "titleText", "getEditText", "", "initView", "", "disableBottomSheetBehavior", "", "onKeyboardChange", "height", "", "isResized", "optFinderObjectView", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "setCancelClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOkClickListener", "setShareContentView", "contentView", "setShareFeedContentView", "setTitle", "title", "username", "tryShow", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends d
{
  public static final a GDr;
  private static r<Boolean, Long> Gxl;
  
  static
  {
    AppMethodBeat.i(344380);
    GDr = new a((byte)0);
    Gxl = new r(Boolean.FALSE, Long.valueOf(0L));
    AppMethodBeat.o(344380);
  }
  
  protected final void L(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(344386);
    super.L(paramContext, paramBoolean);
    paramContext = this.sRs.getWindow();
    if (paramContext == null) {
      paramContext = localObject;
    }
    for (;;)
    {
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
      AppMethodBeat.o(344386);
      return;
      View localView = paramContext.getDecorView();
      paramContext = localObject;
      if (localView != null) {
        paramContext = localView.findViewById(16908310);
      }
    }
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(344392);
    super.dDn();
    Window localWindow = this.sRs.getWindow();
    if (localWindow != null) {
      localWindow.setSoftInputMode(48);
    }
    AppMethodBeat.o(344392);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTimelineShareDialog$Companion;", "", "()V", "DIALOG_STATUS_VALID_LIMIT", "", "TAG", "", "dialogStatus", "Lkotlin/Pair;", "", "", "getDialogStatus", "()Lkotlin/Pair;", "setDialogStatus", "(Lkotlin/Pair;)V", "isInShareStatus", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.t
 * JD-Core Version:    0.7.0.1
 */