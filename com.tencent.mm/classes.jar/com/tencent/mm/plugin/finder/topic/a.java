package com.tencent.mm.plugin.finder.topic;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.finder.viewmodel.component.ao;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/topic/FinderTopicReport;", "", "()V", "EID_LINK_TOPIC_TAG", "", "EID_VIDEO_CARD", "addKvFor21874", "", "context", "Landroid/content/Context;", "activityId", "", "feedId", "topicId", "topicName", "fragment", "Landroidx/fragment/app/Fragment;", "report21875", "eid", "eventCode", "", "setTopicExposed", "contentTv", "Landroid/view/View;", "spannableString", "Landroid/text/SpannableString;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a FNS;
  
  static
  {
    AppMethodBeat.i(329860);
    FNS = new a();
    AppMethodBeat.o(329860);
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(329828);
    s.u(paramContext, "context");
    s.u(paramString, "topicName");
    k localk = k.aeZF;
    paramContext = (ao)k.nq(paramContext).q(ao.class);
    paramContext.iv("feedid", d.hF(paramLong1));
    paramContext.iv("topicid", d.hF(paramLong2));
    paramContext.iv("topicname", paramString);
    AppMethodBeat.o(329828);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(329847);
    s.u(paramContext, "context");
    s.u(paramString1, "eid");
    s.u(paramString2, "topicName");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedid", d.hF(paramLong1));
      localJSONObject.put("topicid", d.hF(paramLong2));
      localJSONObject.put("topicname", paramString2);
      label68:
      paramString2 = bb.FuK;
      paramString2 = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.fou())
      {
        bb.a(paramContext, paramString1, paramInt, localJSONObject);
        AppMethodBeat.o(329847);
        return;
      }
    }
    catch (JSONException paramString2)
    {
      break label68;
    }
  }
  
  public static void a(final View paramView, SpannableString paramSpannableString, final long paramLong)
  {
    AppMethodBeat.i(329855);
    s.u(paramView, "contentTv");
    s.u(paramSpannableString, "spannableString");
    f.a(paramView, (e.b)new a(paramSpannableString, paramView, paramLong));
    AppMethodBeat.o(329855);
  }
  
  public static void a(Fragment paramFragment, long paramLong)
  {
    AppMethodBeat.i(329839);
    s.u(paramFragment, "fragment");
    k localk = k.aeZF;
    ((ao)k.y(paramFragment).q(ao.class)).iv("activityid", d.hF(paramLong));
    AppMethodBeat.o(329839);
  }
  
  public static void k(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(329833);
    s.u(paramContext, "context");
    k localk = k.aeZF;
    ((ao)k.nq(paramContext).q(ao.class)).iv("activityid", d.hF(paramLong));
    AppMethodBeat.o(329833);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/topic/FinderTopicReport$setTopicExposed$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends e.b
  {
    a(SpannableString paramSpannableString, View paramView, long paramLong) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(329818);
      s.u(paramView, "view");
      int i;
      int j;
      if (paramBoolean)
      {
        paramView = this.FtH.getSpans(0, this.FtH.length(), q.class);
        s.s(paramView, "spannableString.getSpans…extClickSpan::class.java)");
        paramView = (q[])paramView;
        i = 0;
        j = paramView.length;
      }
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = paramView[i];
          i += 1;
          if (localObject1.GDg)
          {
            Object localObject2 = a.FNS;
            localObject2 = paramView.getContext();
            s.s(localObject2, "contentTv.context");
            a.a((Context)localObject2, "link_topic_tag", 0, paramLong, 0L, localObject1.text);
          }
        }
        else
        {
          AppMethodBeat.o(329818);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.topic.a
 * JD-Core Version:    0.7.0.1
 */