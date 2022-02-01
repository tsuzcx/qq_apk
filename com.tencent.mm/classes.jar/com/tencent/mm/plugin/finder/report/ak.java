package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderTextReporter;", "", "()V", "EID_LINK_ACTIVITY_TAG", "", "EID_LINK_AT_PROFILE_TAG", "EID_LINK_POI_TAG", "reportActivity21875", "", "context", "Landroid/content/Context;", "eventCode", "", "activityId", "", "(Landroid/content/Context;ILjava/lang/Long;)V", "reportAtProfile21875", "nickName", "reportPoi21875", "poiName", "setTextExposed", "contentTv", "Landroid/view/View;", "spannableString", "Landroid/text/SpannableString;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
{
  public static final ak FtG;
  
  static
  {
    AppMethodBeat.i(331298);
    FtG = new ak();
    AppMethodBeat.o(331298);
  }
  
  public static void a(Context paramContext, int paramInt, Long paramLong)
  {
    AppMethodBeat.i(331281);
    s.u(paramContext, "context");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("activityid", paramLong);
      label27:
      paramLong = bb.FuK;
      paramLong = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.fou())
      {
        bb.a(paramContext, "link_activity", paramInt, localJSONObject);
        AppMethodBeat.o(331281);
        return;
      }
    }
    catch (JSONException paramLong)
    {
      break label27;
    }
  }
  
  public static void a(final View paramView, SpannableString paramSpannableString, final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(331292);
    s.u(paramView, "contentTv");
    s.u(paramSpannableString, "spannableString");
    s.u(paramBaseFinderFeed, "item");
    f.a(paramView, (e.b)new a(paramSpannableString, paramBaseFinderFeed, paramView));
    AppMethodBeat.o(331292);
  }
  
  public static void f(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(331266);
    s.u(paramContext, "context");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("poi_name", paramString);
      label27:
      paramString = bb.FuK;
      paramString = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.fou())
      {
        bb.a(paramContext, "link_poi", paramInt, localJSONObject);
        AppMethodBeat.o(331266);
        return;
      }
    }
    catch (JSONException paramString)
    {
      break label27;
    }
  }
  
  public static void g(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(331274);
    s.u(paramContext, "context");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("nickname", paramString);
      label27:
      paramString = bb.FuK;
      paramString = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.fou())
      {
        bb.a(paramContext, "link_at_profile", paramInt, localJSONObject);
        AppMethodBeat.o(331274);
        return;
      }
    }
    catch (JSONException paramString)
    {
      break label27;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderTextReporter$setTextExposed$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends e.b
  {
    a(SpannableString paramSpannableString, BaseFinderFeed paramBaseFinderFeed, View paramView) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(331544);
      s.u(paramView, "view");
      q[] arrayOfq;
      int i;
      int k;
      if (paramBoolean)
      {
        paramView = this.FtH.getSpans(0, this.FtH.length(), q.class);
        s.s(paramView, "spannableString.getSpans…extClickSpan::class.java)");
        arrayOfq = (q[])paramView;
        i = 0;
        k = arrayOfq.length;
      }
      label131:
      label171:
      label314:
      label317:
      label323:
      label351:
      for (;;)
      {
        if (i < k)
        {
          q localq = arrayOfq[i];
          i += 1;
          int j;
          if (localq.zID)
          {
            paramView = av.GiL;
            paramView = paramBaseFinderFeed.feedObject.getLocation().city;
            Object localObject = (CharSequence)paramView;
            if ((localObject == null) || (((CharSequence)localObject).length() == 0))
            {
              j = 1;
              label124:
              if (j == 0) {
                break label314;
              }
              paramView = null;
              localObject = paramBaseFinderFeed.feedObject.getLocation().poiName;
              CharSequence localCharSequence = (CharSequence)localObject;
              if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
                break label317;
              }
              j = 1;
              if (j != 0) {
                localObject = null;
              }
              paramView = av.cn(paramView, (String)localObject);
              localObject = ak.FtG;
              localObject = paramView.getContext();
              s.s(localObject, "contentTv.context");
              ak.f((Context)localObject, 0, paramView);
            }
          }
          else
          {
            if (localq.GDh)
            {
              paramView = ak.FtG;
              paramView = paramView.getContext();
              s.s(paramView, "contentTv.context");
              ak.g(paramView, 0, localq.text);
            }
            if (!localq.GDi) {
              break label351;
            }
            paramView = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramView != null) {
              break label323;
            }
            paramLong1 = 0L;
          }
          for (;;)
          {
            paramView = ak.FtG;
            paramView = paramView.getContext();
            s.s(paramView, "contentTv.context");
            ak.a(paramView, 0, Long.valueOf(paramLong1));
            break;
            j = 0;
            break label124;
            break label131;
            j = 0;
            break label171;
            paramView = paramView.event;
            if (paramView == null) {
              paramLong1 = 0L;
            } else {
              paramLong1 = paramView.ocD;
            }
          }
        }
        else
        {
          AppMethodBeat.o(331544);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ak
 * JD-Core Version:    0.7.0.1
 */