package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "activityPostManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "getActivityPostManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "setActivityPostManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;)V", "atManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "getAtManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "setAtManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;)V", "topicSuggestManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "getTopicSuggestManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "setTopicSuggestManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;)V", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "iniFinderTopicSuggestManager", "initFinderAtManager", "initPostManager", "release", "Companion", "plugin-finder_release"})
public final class d
{
  public static final a BfJ;
  private static final String TAG = "Finder.FinderStyleManager";
  public e BfG;
  public b BfH;
  public a BfI;
  
  static
  {
    AppMethodBeat.i(282981);
    BfJ = new a((byte)0);
    TAG = "Finder.FinderStyleManager";
    AppMethodBeat.o(282981);
  }
  
  public d(FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(282980);
    this.BfG = new e(paramFinderPostEditText, paramMMActivity);
    this.BfH = new b();
    this.BfI = new a();
    AppMethodBeat.o(282980);
  }
  
  public final void a(String paramString, Editable paramEditable)
  {
    AppMethodBeat.i(282978);
    p.k(paramString, "curDesc");
    p.k(paramEditable, "s");
    Object localObject1 = (Spannable)paramEditable;
    Object localObject2 = (ForegroundColorSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), ForegroundColorSpan.class);
    p.j(localObject2, "spans");
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((Spannable)localObject1).removeSpan(localObject2[i]);
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    Object localObject3;
    if (com.tencent.mm.plugin.finder.storage.d.dTe())
    {
      localObject1 = this.BfH;
      if (localObject1 == null) {
        p.bGy("atManager");
      }
      p.k(paramString, "curDesc");
      p.k(paramEditable, "s");
      localObject2 = (Spannable)paramEditable;
      ((b)localObject1).ABf.clear();
      ((b)localObject1).BeY.clear();
      localObject3 = com.tencent.mm.plugin.finder.utils.e.ACV;
      localObject2 = com.tencent.mm.plugin.finder.utils.e.a(paramString, ((b)localObject1).BeX, (q)new b.b((Spannable)localObject2));
      ((b)localObject1).ABf.addAll((Collection)((o)localObject2).Mx);
      ((b)localObject1).BeY.addAll((Collection)((o)localObject2).My);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dTd())
    {
      localObject1 = this.BfG;
      if (localObject1 == null) {
        p.bGy("topicSuggestManager");
      }
      localObject2 = this.BfH;
      if (localObject2 == null) {
        p.bGy("atManager");
      }
      localObject2 = ((b)localObject2).BeY;
      p.k(paramString, "curDesc");
      p.k(paramEditable, "s");
      p.k(localObject2, "atStringInfoList");
      localObject3 = (Spannable)paramEditable;
      ((e)localObject1).BfK.clear();
      ag localag = ag.AFH;
      localObject2 = ag.a(paramString, (ArrayList)localObject2, (m)new e.b((Spannable)localObject3));
      ((e)localObject1).BfK.addAll((Collection)localObject2);
    }
    localObject1 = this.BfI;
    if (localObject1 == null) {
      p.bGy("activityPostManager");
    }
    p.k(paramString, "curDesc");
    p.k(paramEditable, "s");
    i = n.a((CharSequence)paramString, ((a)localObject1).BeQ, 0, false, 6);
    if ((Util.isNullOrNil(((a)localObject1).BeQ)) || (i < 0))
    {
      paramString = ((a)localObject1).BeR;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(282978);
        return;
      }
      AppMethodBeat.o(282978);
      return;
    }
    ((a)localObject1).BeS = true;
    paramString = (Spannable)paramEditable;
    j = ((a)localObject1).BeQ.length() + i;
    paramEditable = MMApplicationContext.getContext();
    p.j(paramEditable, "MMApplicationContext.getContext()");
    paramString.setSpan(new ForegroundColorSpan(paramEditable.getResources().getColor(b.c.link_color)), i, j, 17);
    paramEditable = MMApplicationContext.getContext();
    p.j(paramEditable, "MMApplicationContext.getContext()");
    paramString.setSpan(new BackgroundColorSpan(paramEditable.getResources().getColor(b.c.general_sub_background_color)), i, j, 17);
    AppMethodBeat.o(282978);
  }
  
  public final b ejT()
  {
    AppMethodBeat.i(282977);
    b localb = this.BfH;
    if (localb == null) {
      p.bGy("atManager");
    }
    AppMethodBeat.o(282977);
    return localb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.d
 * JD-Core Version:    0.7.0.1
 */