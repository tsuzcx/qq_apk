package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.w;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "activityPostManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "getActivityPostManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "setActivityPostManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;)V", "atManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "getAtManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "setAtManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;)V", "topicSuggestManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "getTopicSuggestManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "setTopicSuggestManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;)V", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "iniFinderTopicSuggestManager", "initFinderAtManager", "initPostManager", "release", "Companion", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "Finder.FinderStyleManager";
  public static final a wts;
  public e wtp;
  public b wtq;
  public a wtr;
  
  static
  {
    AppMethodBeat.i(255288);
    wts = new a((byte)0);
    TAG = "Finder.FinderStyleManager";
    AppMethodBeat.o(255288);
  }
  
  public d(FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(255287);
    this.wtp = new e(paramFinderPostEditText, paramMMActivity);
    this.wtq = new b();
    this.wtr = new a();
    AppMethodBeat.o(255287);
  }
  
  public final void a(String paramString, Editable paramEditable)
  {
    AppMethodBeat.i(255286);
    p.h(paramString, "curDesc");
    p.h(paramEditable, "s");
    Object localObject1 = (Spannable)paramEditable;
    Object localObject2 = (ForegroundColorSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), ForegroundColorSpan.class);
    p.g(localObject2, "spans");
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((Spannable)localObject1).removeSpan(localObject2[i]);
      i += 1;
    }
    localObject1 = c.vCb;
    Object localObject3;
    if (c.drO())
    {
      localObject1 = this.wtq;
      if (localObject1 == null) {
        p.btv("atManager");
      }
      p.h(paramString, "curDesc");
      p.h(paramEditable, "s");
      localObject2 = (Spannable)paramEditable;
      ((b)localObject1).vTC.clear();
      ((b)localObject1).wsH.clear();
      localObject3 = com.tencent.mm.plugin.finder.utils.d.vVg;
      localObject2 = com.tencent.mm.plugin.finder.utils.d.a(paramString, ((b)localObject1).wsG, (q)new b.b((Spannable)localObject2));
      ((b)localObject1).vTC.addAll((Collection)((o)localObject2).first);
      ((b)localObject1).wsH.addAll((Collection)((o)localObject2).second);
    }
    localObject1 = c.vCb;
    if (c.drN())
    {
      localObject1 = this.wtp;
      if (localObject1 == null) {
        p.btv("topicSuggestManager");
      }
      localObject2 = this.wtq;
      if (localObject2 == null) {
        p.btv("atManager");
      }
      localObject2 = ((b)localObject2).wsH;
      p.h(paramString, "curDesc");
      p.h(paramEditable, "s");
      p.h(localObject2, "atStringInfoList");
      localObject3 = (Spannable)paramEditable;
      ((e)localObject1).wtt.clear();
      w localw = w.vXp;
      localObject2 = w.a(paramString, (ArrayList)localObject2, (m)new e.b((Spannable)localObject3));
      ((e)localObject1).wtt.addAll((Collection)localObject2);
    }
    localObject1 = this.wtr;
    if (localObject1 == null) {
      p.btv("activityPostManager");
    }
    p.h(paramString, "curDesc");
    p.h(paramEditable, "s");
    i = n.a((CharSequence)paramString, ((a)localObject1).wsz, 0, false, 6);
    if ((Util.isNullOrNil(((a)localObject1).wsz)) || (i < 0))
    {
      paramString = ((a)localObject1).wsA;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        AppMethodBeat.o(255286);
        return;
      }
      AppMethodBeat.o(255286);
      return;
    }
    ((a)localObject1).wsB = true;
    paramString = (Spannable)paramEditable;
    j = ((a)localObject1).wsz.length() + i;
    paramEditable = MMApplicationContext.getContext();
    p.g(paramEditable, "MMApplicationContext.getContext()");
    paramString.setSpan(new ForegroundColorSpan(paramEditable.getResources().getColor(2131100685)), i, j, 17);
    paramEditable = MMApplicationContext.getContext();
    p.g(paramEditable, "MMApplicationContext.getContext()");
    paramString.setSpan(new BackgroundColorSpan(paramEditable.getResources().getColor(2131100556)), i, j, 17);
    AppMethodBeat.o(255286);
  }
  
  public final b dHI()
  {
    AppMethodBeat.i(255285);
    b localb = this.wtq;
    if (localb == null) {
      p.btv("atManager");
    }
    AppMethodBeat.o(255285);
    return localb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.d
 * JD-Core Version:    0.7.0.1
 */