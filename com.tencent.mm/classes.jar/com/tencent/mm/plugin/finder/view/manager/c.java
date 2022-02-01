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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "", "topicSuggestView", "Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "atManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "getAtManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "setAtManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;)V", "topicSuggestManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "getTopicSuggestManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "setTopicSuggestManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;)V", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "iniFinderTopicSuggestManager", "initFinderAtManager", "release", "Companion", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FinderStyleManager";
  public static final c.a tjV;
  public d tjT;
  public a tjU;
  
  static
  {
    AppMethodBeat.i(206015);
    tjV = new c.a((byte)0);
    TAG = "Finder.FinderStyleManager";
    AppMethodBeat.o(206015);
  }
  
  public c(FinderTopicSuggestView paramFinderTopicSuggestView, FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(206014);
    this.tjT = new d(paramFinderTopicSuggestView, paramFinderPostEditText, paramMMActivity);
    this.tjU = new a();
    AppMethodBeat.o(206014);
  }
  
  public final void a(String paramString, Editable paramEditable)
  {
    int i = 0;
    AppMethodBeat.i(206013);
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
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    Object localObject3;
    if (com.tencent.mm.plugin.finder.storage.b.cId())
    {
      localObject1 = this.tjU;
      if (localObject1 == null) {
        p.bdF("atManager");
      }
      p.h(paramString, "curDesc");
      p.h(paramEditable, "s");
      localObject2 = (Spannable)paramEditable;
      ((a)localObject1).tjm.clear();
      ((a)localObject1).tjn.clear();
      localObject3 = com.tencent.mm.plugin.finder.utils.b.sWa;
      localObject2 = com.tencent.mm.plugin.finder.utils.b.a(paramString, ((a)localObject1).tjl, (q)new a.b((Spannable)localObject2));
      ((a)localObject1).tjm.addAll((Collection)((d.o)localObject2).first);
      ((a)localObject1).tjn.addAll((Collection)((d.o)localObject2).second);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIc())
    {
      localObject1 = this.tjT;
      if (localObject1 == null) {
        p.bdF("topicSuggestManager");
      }
      localObject2 = this.tjU;
      if (localObject2 == null) {
        p.bdF("atManager");
      }
      localObject2 = ((a)localObject2).tjn;
      p.h(paramString, "curDesc");
      p.h(paramEditable, "s");
      p.h(localObject2, "atStringInfoList");
      paramEditable = (Spannable)paramEditable;
      ((d)localObject1).tjW.clear();
      localObject3 = com.tencent.mm.plugin.finder.utils.o.sXt;
      paramString = com.tencent.mm.plugin.finder.utils.o.a(paramString, (ArrayList)localObject2, (m)new d.c(paramEditable));
      ((d)localObject1).tjW.addAll((Collection)paramString);
    }
    AppMethodBeat.o(206013);
  }
  
  public final d cQH()
  {
    AppMethodBeat.i(206011);
    d locald = this.tjT;
    if (locald == null) {
      p.bdF("topicSuggestManager");
    }
    AppMethodBeat.o(206011);
    return locald;
  }
  
  public final a cQI()
  {
    AppMethodBeat.i(206012);
    a locala = this.tjU;
    if (locala == null) {
      p.bdF("atManager");
    }
    AppMethodBeat.o(206012);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.c
 * JD-Core Version:    0.7.0.1
 */