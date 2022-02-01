package com.tencent.mm.plugin.finder.upload.postui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderChooseOriginalView;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "originalView", "Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getOriginalView", "()Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "canPost", "", "onCreate", "", "intent", "Landroid/content/Intent;", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "shouldInterceptBackPress", "plugin-finder_release"})
public final class d
{
  private final String TAG;
  public final MMActivity activity;
  public final FinderChooseOriginalView vUS;
  
  public d(MMActivity paramMMActivity, FinderChooseOriginalView paramFinderChooseOriginalView)
  {
    AppMethodBeat.i(253250);
    this.activity = paramMMActivity;
    this.vUS = paramFinderChooseOriginalView;
    this.TAG = "Finder.FinderOriginalWidget";
    AppMethodBeat.o(253250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.d
 * JD-Core Version:    0.7.0.1
 */