package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.utils.as;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "activityPostManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "getActivityPostManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "setActivityPostManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;)V", "atManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "getAtManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "setAtManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;)V", "topicSuggestManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "getTopicSuggestManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "setTopicSuggestManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;)V", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "iniFinderTopicSuggestManager", "initFinderAtManager", "initPostManager", "release", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a GHY;
  private static final String TAG;
  public e GHZ;
  public b GIa;
  public a GIb;
  
  static
  {
    AppMethodBeat.i(346122);
    GHY = new d.a((byte)0);
    TAG = "Finder.FinderStyleManager";
    AppMethodBeat.o(346122);
  }
  
  public d(FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(346115);
    paramFinderPostEditText = new e(paramFinderPostEditText, paramMMActivity);
    s.u(paramFinderPostEditText, "<set-?>");
    this.GHZ = paramFinderPostEditText;
    paramFinderPostEditText = new b();
    s.u(paramFinderPostEditText, "<set-?>");
    this.GIa = paramFinderPostEditText;
    paramFinderPostEditText = new a();
    s.u(paramFinderPostEditText, "<set-?>");
    this.GIb = paramFinderPostEditText;
    AppMethodBeat.o(346115);
  }
  
  public final void a(String paramString, Editable paramEditable)
  {
    AppMethodBeat.i(346155);
    s.u(paramString, "curDesc");
    s.u(paramEditable, "s");
    Object localObject1 = (Spannable)paramEditable;
    Object localObject2 = (ForegroundColorSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), ForegroundColorSpan.class);
    s.s(localObject2, "spans");
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((Spannable)localObject1).removeSpan(localObject2[i]);
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    Object localObject3;
    if (com.tencent.mm.plugin.finder.storage.d.eRt())
    {
      localObject1 = fmb();
      s.u(paramString, "curDesc");
      s.u(paramEditable, "s");
      localObject2 = (Spannable)paramEditable;
      ((b)localObject1).Gct.clear();
      ((b)localObject1).GHD.clear();
      localObject3 = h.Gga;
      localObject2 = h.a(paramString, ((b)localObject1).GHC, (q)new b.b((Spannable)localObject2));
      ((b)localObject1).Gct.addAll((Collection)((r)localObject2).bsC);
      ((b)localObject1).GHD.addAll((Collection)((r)localObject2).bsD);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eRs())
    {
      localObject1 = fma();
      localObject2 = fmb().GHD;
      s.u(paramString, "curDesc");
      s.u(paramEditable, "s");
      s.u(localObject2, "atStringInfoList");
      localObject3 = (Spannable)paramEditable;
      ((e)localObject1).GId.clear();
      as localas = as.GiG;
      localObject2 = as.a(paramString, (ArrayList)localObject2, (m)new e.b((Spannable)localObject3));
      ((e)localObject1).GId.addAll((Collection)localObject2);
    }
    localObject1 = this.GIb;
    if (localObject1 != null) {}
    for (;;)
    {
      s.u(paramString, "curDesc");
      s.u(paramEditable, "s");
      i = n.a((CharSequence)paramString, ((a)localObject1).GHv, 0, false, 6);
      if ((!Util.isNullOrNil(((a)localObject1).GHv)) && (i >= 0)) {
        break;
      }
      paramString = ((a)localObject1).GHw;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(346155);
      return;
      s.bIx("activityPostManager");
      localObject1 = null;
    }
    ((a)localObject1).GHx = true;
    paramString = (Spannable)paramEditable;
    j = ((a)localObject1).GHv.length() + i;
    paramString.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(l.b.link_color)), i, j, 17);
    paramString.setSpan(new BackgroundColorSpan(MMApplicationContext.getContext().getResources().getColor(l.b.general_sub_background_color)), i, j, 17);
    AppMethodBeat.o(346155);
  }
  
  public final e fma()
  {
    AppMethodBeat.i(346132);
    e locale = this.GHZ;
    if (locale != null)
    {
      AppMethodBeat.o(346132);
      return locale;
    }
    s.bIx("topicSuggestManager");
    AppMethodBeat.o(346132);
    return null;
  }
  
  public final b fmb()
  {
    AppMethodBeat.i(346138);
    b localb = this.GIa;
    if (localb != null)
    {
      AppMethodBeat.o(346138);
      return localb;
    }
    s.bIx("atManager");
    AppMethodBeat.o(346138);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.d
 * JD-Core Version:    0.7.0.1
 */