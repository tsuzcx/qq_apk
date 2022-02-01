package com.tencent.mm.plugin.finder.view.manager;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderTopicSuggestView;
import com.tencent.mm.ui.MMActivity;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "", "topicSuggestView", "Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "atManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "getAtManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "setAtManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;)V", "topicSuggestManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "getTopicSuggestManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "setTopicSuggestManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;)V", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "iniFinderTopicSuggestManager", "initFinderAtManager", "release", "Companion", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FinderStyleManager";
  public static final c.a sbq;
  public d sbo;
  public a sbp;
  
  static
  {
    AppMethodBeat.i(204355);
    sbq = new c.a((byte)0);
    TAG = "Finder.FinderStyleManager";
    AppMethodBeat.o(204355);
  }
  
  public c(FinderTopicSuggestView paramFinderTopicSuggestView, FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(204354);
    this.sbo = new d(paramFinderTopicSuggestView, paramFinderPostEditText, paramMMActivity);
    this.sbp = new a();
    AppMethodBeat.o(204354);
  }
  
  public final void a(String paramString, Editable paramEditable)
  {
    int i = 0;
    AppMethodBeat.i(204353);
    k.h(paramString, "curDesc");
    k.h(paramEditable, "s");
    Object localObject1 = (Spannable)paramEditable;
    Object localObject2 = (ForegroundColorSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), ForegroundColorSpan.class);
    k.g(localObject2, "spans");
    int j = localObject2.length;
    while (i < j)
    {
      ((Spannable)localObject1).removeSpan(localObject2[i]);
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    Object localObject3;
    if (com.tencent.mm.plugin.finder.storage.b.czp())
    {
      localObject1 = this.sbp;
      if (localObject1 == null) {
        k.aVY("atManager");
      }
      k.h(paramString, "curDesc");
      k.h(paramEditable, "s");
      localObject2 = (Spannable)paramEditable;
      ((a)localObject1).saJ.clear();
      ((a)localObject1).saK.clear();
      localObject3 = com.tencent.mm.plugin.finder.utils.b.rOw;
      localObject2 = com.tencent.mm.plugin.finder.utils.b.a(paramString, ((a)localObject1).saI, (q)new a.b((Spannable)localObject2));
      ((a)localObject1).saJ.addAll((Collection)((o)localObject2).first);
      ((a)localObject1).saK.addAll((Collection)((o)localObject2).second);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czo())
    {
      localObject1 = this.sbo;
      if (localObject1 == null) {
        k.aVY("topicSuggestManager");
      }
      localObject2 = this.sbp;
      if (localObject2 == null) {
        k.aVY("atManager");
      }
      localObject2 = ((a)localObject2).saK;
      k.h(paramString, "curDesc");
      k.h(paramEditable, "s");
      k.h(localObject2, "atStringInfoList");
      paramEditable = (Spannable)paramEditable;
      ((d)localObject1).sbr.clear();
      localObject3 = com.tencent.mm.plugin.finder.utils.m.rPH;
      paramString = com.tencent.mm.plugin.finder.utils.m.a(paramString, (ArrayList)localObject2, (d.g.a.m)new d.c(paramEditable));
      ((d)localObject1).sbr.addAll((Collection)paramString);
    }
    AppMethodBeat.o(204353);
  }
  
  public final d cFC()
  {
    AppMethodBeat.i(204351);
    d locald = this.sbo;
    if (locald == null) {
      k.aVY("topicSuggestManager");
    }
    AppMethodBeat.o(204351);
    return locald;
  }
  
  public final a cFD()
  {
    AppMethodBeat.i(204352);
    a locala = this.sbp;
    if (locala == null) {
      k.aVY("atManager");
    }
    AppMethodBeat.o(204352);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.c
 * JD-Core Version:    0.7.0.1
 */