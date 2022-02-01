package com.tencent.mm.plugin.finder.upload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderChooseOriginalView;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "originalView", "Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getOriginalView", "()Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "canPost", "", "onCreate", "", "intent", "Landroid/content/Intent;", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "shouldInterceptBackPress", "plugin-finder_release"})
public final class c
{
  public final FinderChooseOriginalView LaB;
  private final String TAG;
  private final MMActivity activity;
  
  public c(MMActivity paramMMActivity, FinderChooseOriginalView paramFinderChooseOriginalView)
  {
    AppMethodBeat.i(199575);
    this.activity = paramMMActivity;
    this.LaB = paramFinderChooseOriginalView;
    this.TAG = "Finder.FinderOriginalWidget";
    AppMethodBeat.o(199575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.a.c
 * JD-Core Version:    0.7.0.1
 */