package com.tencent.mm.plugin.finder.view.manager;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderTopicSuggestView;
import com.tencent.mm.ui.MMActivity;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "", "topicSuggestView", "Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "atManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "getAtManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "setAtManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;)V", "topicSuggestManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "getTopicSuggestManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "setTopicSuggestManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;)V", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "iniFinderTopicSuggestManager", "initFinderAtManager", "release", "Companion", "plugin-finder_release"})
public final class d
{
  public static final a LgR;
  private static final String TAG = "Finder.FinderStyleManager";
  public b LgP;
  public c LgQ;
  
  static
  {
    AppMethodBeat.i(200285);
    LgR = new a((byte)0);
    TAG = "Finder.FinderStyleManager";
    AppMethodBeat.o(200285);
  }
  
  public d(FinderTopicSuggestView paramFinderTopicSuggestView, FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(200284);
    this.LgP = new b(paramFinderTopicSuggestView, paramFinderPostEditText, paramMMActivity);
    this.LgQ = new c();
    AppMethodBeat.o(200284);
  }
  
  public final void a(String paramString, Editable paramEditable)
  {
    int i = 0;
    AppMethodBeat.i(200283);
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
    localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    Object localObject3;
    if (com.tencent.mm.plugin.finder.storage.b.fUh())
    {
      localObject1 = this.LgQ;
      if (localObject1 == null) {
        k.aPZ("atManager");
      }
      k.h(paramString, "curDesc");
      k.h(paramEditable, "s");
      localObject2 = (Spannable)paramEditable;
      ((c)localObject1).LgI.clear();
      ((c)localObject1).LgJ.clear();
      localObject3 = n.LaC;
      localObject2 = n.a(paramString, ((c)localObject1).LgH, (q)new c.b((Spannable)localObject2));
      ((c)localObject1).LgI.addAll((Collection)((o)localObject2).first);
      ((c)localObject1).LgJ.addAll((Collection)((o)localObject2).second);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpO())
    {
      localObject1 = this.LgP;
      if (localObject1 == null) {
        k.aPZ("topicSuggestManager");
      }
      localObject2 = this.LgQ;
      if (localObject2 == null) {
        k.aPZ("atManager");
      }
      localObject2 = ((c)localObject2).LgJ;
      k.h(paramString, "curDesc");
      k.h(paramEditable, "s");
      k.h(localObject2, "atStringInfoList");
      paramEditable = (Spannable)paramEditable;
      ((b)localObject1).qZo.clear();
      localObject3 = h.qSR;
      paramString = h.a(paramString, (ArrayList)localObject2, (m)new b.c(paramEditable));
      ((b)localObject1).qZo.addAll((Collection)paramString);
    }
    AppMethodBeat.o(200283);
  }
  
  public final b fXc()
  {
    AppMethodBeat.i(200281);
    b localb = this.LgP;
    if (localb == null) {
      k.aPZ("topicSuggestManager");
    }
    AppMethodBeat.o(200281);
    return localb;
  }
  
  public final c fXd()
  {
    AppMethodBeat.i(200282);
    c localc = this.LgQ;
    if (localc == null) {
      k.aPZ("atManager");
    }
    AppMethodBeat.o(200282);
    return localc;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.d
 * JD-Core Version:    0.7.0.1
 */