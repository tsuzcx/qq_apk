package com.tencent.mm.plugin.finder.view.manager;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderTopicSuggestView;
import com.tencent.mm.ui.MMActivity;
import d.g.a.m;
import d.g.a.q;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "", "topicSuggestView", "Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "atManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "getAtManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "setAtManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;)V", "topicSuggestManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "getTopicSuggestManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "setTopicSuggestManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;)V", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "iniFinderTopicSuggestManager", "initFinderAtManager", "release", "Companion", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FinderStyleManager";
  public static final a sYH;
  public d sYF;
  public a sYG;
  
  static
  {
    AppMethodBeat.i(205369);
    sYH = new a((byte)0);
    TAG = "Finder.FinderStyleManager";
    AppMethodBeat.o(205369);
  }
  
  public c(FinderTopicSuggestView paramFinderTopicSuggestView, FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(205368);
    this.sYF = new d(paramFinderTopicSuggestView, paramFinderPostEditText, paramMMActivity);
    this.sYG = new a();
    AppMethodBeat.o(205368);
  }
  
  public final void a(String paramString, Editable paramEditable)
  {
    int i = 0;
    AppMethodBeat.i(205367);
    p.h(paramString, "curDesc");
    p.h(paramEditable, "s");
    Object localObject1 = (Spannable)paramEditable;
    Object localObject2 = (ForegroundColorSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), ForegroundColorSpan.class);
    p.g(localObject2, "spans");
    int j = localObject2.length;
    while (i < j)
    {
      ((Spannable)localObject1).removeSpan(localObject2[i]);
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    Object localObject3;
    if (com.tencent.mm.plugin.finder.storage.b.cGg())
    {
      localObject1 = this.sYG;
      if (localObject1 == null) {
        p.bcb("atManager");
      }
      p.h(paramString, "curDesc");
      p.h(paramEditable, "s");
      localObject2 = (Spannable)paramEditable;
      ((a)localObject1).sXY.clear();
      ((a)localObject1).sXZ.clear();
      localObject3 = com.tencent.mm.plugin.finder.utils.b.sKO;
      localObject2 = com.tencent.mm.plugin.finder.utils.b.a(paramString, ((a)localObject1).sXX, (q)new a.b((Spannable)localObject2));
      ((a)localObject1).sXY.addAll((Collection)((d.o)localObject2).first);
      ((a)localObject1).sXZ.addAll((Collection)((d.o)localObject2).second);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGf())
    {
      localObject1 = this.sYF;
      if (localObject1 == null) {
        p.bcb("topicSuggestManager");
      }
      localObject2 = this.sYG;
      if (localObject2 == null) {
        p.bcb("atManager");
      }
      localObject2 = ((a)localObject2).sXZ;
      p.h(paramString, "curDesc");
      p.h(paramEditable, "s");
      p.h(localObject2, "atStringInfoList");
      paramEditable = (Spannable)paramEditable;
      ((d)localObject1).sYI.clear();
      localObject3 = com.tencent.mm.plugin.finder.utils.o.sMi;
      paramString = com.tencent.mm.plugin.finder.utils.o.a(paramString, (ArrayList)localObject2, (m)new d.c(paramEditable));
      ((d)localObject1).sYI.addAll((Collection)paramString);
    }
    AppMethodBeat.o(205367);
  }
  
  public final d cNX()
  {
    AppMethodBeat.i(205365);
    d locald = this.sYF;
    if (locald == null) {
      p.bcb("topicSuggestManager");
    }
    AppMethodBeat.o(205365);
    return locald;
  }
  
  public final a cNY()
  {
    AppMethodBeat.i(205366);
    a locala = this.sYG;
    if (locala == null) {
      p.bcb("atManager");
    }
    AppMethodBeat.o(205366);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.c
 * JD-Core Version:    0.7.0.1
 */