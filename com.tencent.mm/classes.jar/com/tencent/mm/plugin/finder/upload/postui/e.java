package com.tencent.mm.plugin.finder.upload.postui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderChooseNewsView;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderSetNewsFeedWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "newsView", "Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getNewsView", "()Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "canPost", "", "isChecked", "onCreate", "", "intent", "Landroid/content/Intent;", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "shouldInterceptBackPress", "plugin-finder_release"})
public final class e
{
  public final MMActivity activity;
  public final FinderChooseNewsView vUT;
  
  public e(MMActivity paramMMActivity, FinderChooseNewsView paramFinderChooseNewsView)
  {
    AppMethodBeat.i(253252);
    this.activity = paramMMActivity;
    this.vUT = paramFinderChooseNewsView;
    AppMethodBeat.o(253252);
  }
  
  public final boolean isChecked()
  {
    AppMethodBeat.i(253251);
    y localy = y.vXH;
    if ((y.dCH()) && (this.vUT.isChecked()))
    {
      AppMethodBeat.o(253251);
      return true;
    }
    AppMethodBeat.o(253251);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.e
 * JD-Core Version:    0.7.0.1
 */