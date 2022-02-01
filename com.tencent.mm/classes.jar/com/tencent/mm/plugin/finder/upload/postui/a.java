package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.ui.MMActivity;
import d.g.a.m;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendReadingWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "extendReadingView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "changeEditViewCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "open", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getChangeEditViewCallback", "()Lkotlin/jvm/functions/Function1;", "extendReadingManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderExtendReadingManager;", "getExtendReadingView", "()Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingView;", "intent", "Landroid/content/Intent;", "postData", "Landroid/os/Bundle;", "canPost", "fillData", "link", "", "title", "onCreate", "onDestroy", "onPause", "onResume", "shouldInterceptBackPress", "plugin-finder_release"})
public final class a
{
  private final MMActivity activity;
  public Intent intent;
  public com.tencent.mm.plugin.finder.view.manager.b rOk;
  public Bundle rOl;
  private final FinderExtendReadingView rOm;
  private final d.g.a.b<Boolean, y> rOn;
  
  public a(MMActivity paramMMActivity, FinderExtendReadingView paramFinderExtendReadingView, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(203546);
    this.activity = paramMMActivity;
    this.rOm = paramFinderExtendReadingView;
    this.rOn = paramb;
    this.rOk = new com.tencent.mm.plugin.finder.view.manager.b(this.activity, this.rOm, (m)new a.1(this), this.rOn);
    AppMethodBeat.o(203546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.a
 * JD-Core Version:    0.7.0.1
 */