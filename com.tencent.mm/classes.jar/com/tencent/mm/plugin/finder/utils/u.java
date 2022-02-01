package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.jump.a;
import com.tencent.mm.plugin.finder.report.jump.b;
import com.tencent.mm.plugin.finder.report.jump.c;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderJumpDataUtils;", "", "()V", "TAG", "", "getJumpDataStrFromIntent", "activity", "Landroid/app/Activity;", "initJumpData", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "toCommentScene", "", "entranceType", "OnClearListenerImpl", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final u GgT;
  
  static
  {
    AppMethodBeat.i(333703);
    GgT = new u();
    AppMethodBeat.o(333703);
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(333681);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    Object localObject1;
    as localas;
    int i;
    label51:
    b localb;
    Object localObject2;
    int j;
    String str;
    int k;
    int m;
    if ((paramContext instanceof MMFragmentActivity))
    {
      localObject1 = as.GSQ;
      localas = as.a.hu(paramContext);
      if (localas != null) {
        break label596;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label606;
      }
      i = 0;
      localObject1 = b.FuP;
      localb = b.eOa();
      localObject2 = (MMFragmentActivity)paramContext;
      c localc = (c)new a();
      s.u(localObject2, "activity");
      s.u(paramIntent, "intent");
      s.u(localc, "onClearListener");
      j = ((MMFragmentActivity)localObject2).hashCode();
      localObject1 = (Integer)localb.FuQ.get(Integer.valueOf(j));
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = Integer.valueOf(0);
      }
      if (((Number)paramContext).intValue() > 0)
      {
        s.u(localObject2, "activity");
        s.u(paramIntent, "intent");
        s.u(localc, "onClearListener");
        str = localObject2.getClass().getSimpleName();
        k = ((MMFragmentActivity)localObject2).hashCode();
        ((Map)localb.FuS).put(Integer.valueOf(k), localc);
        localObject1 = (Integer)localb.FuQ.get(Integer.valueOf(k));
        paramContext = (Context)localObject1;
        if (localObject1 == null) {
          paramContext = Integer.valueOf(0);
        }
        m = ((Number)paramContext).intValue();
        paramContext = (a)localb.FuR.get(Integer.valueOf(m));
        if (paramContext != null) {
          break label660;
        }
        paramContext = new a();
        ((Map)localb.FuR).put(Integer.valueOf(m), paramContext);
      }
    }
    label596:
    label606:
    label637:
    for (;;)
    {
      localObject1 = i + '-' + paramInt2 + '-' + paramInt1 + '-' + System.currentTimeMillis();
      if (((CharSequence)paramContext.sourceId).length() == 0) {}
      for (j = 1;; j = 0)
      {
        if (j != 0)
        {
          s.u(localObject1, "<set-?>");
          paramContext.sourceId = ((String)localObject1);
          paramContext.FuO = k;
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("sourceid", paramContext.sourceId);
          ((JSONObject)localObject2).put("traceid", localObject1);
          localObject2 = ((JSONObject)localObject2).toString();
          s.s(localObject2, "json.toString()");
          if (k == paramContext.FuO)
          {
            s.u(localObject2, "<set-?>");
            paramContext.pjP = ((String)localObject2);
          }
          paramIntent.putExtra("key_jump_id", (String)localObject2);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.e("FinderJumpDataManager", localJSONException.getMessage());
            continue;
            paramIntent = n.bV(paramContext, ",", ";");
            paramContext = paramIntent;
            if (paramIntent == null) {
              paramContext = "";
            }
          }
        }
        Log.i("FinderJumpDataManager", "[initJumpData] " + str + " taskId=" + m + ", finderTaskId=" + localb.FuT + ", activityId=" + paramContext.FuO + ", sourceId=" + paramContext.sourceId + ", traceId=" + (String)localObject1 + ", fromCommentScene=" + i + ", toCommentScene=" + paramInt1 + ", entranceType=" + paramInt2);
        if (localas != null)
        {
          paramContext = paramIntent.getStringExtra("key_jump_id");
          if (paramContext != null) {
            break label637;
          }
          paramContext = "";
          localas.ayc(paramContext);
        }
        AppMethodBeat.o(333681);
        return;
        localObject1 = localas.fou();
        break;
        i = ((bui)localObject1).AJo;
        break label51;
      }
    }
  }
  
  public static String aN(Activity paramActivity)
  {
    AppMethodBeat.i(333687);
    s.u(paramActivity, "activity");
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {
      paramActivity = "";
    }
    for (;;)
    {
      Log.i("FinderJumpDataUtils", s.X("[getJumpDataStr] ", paramActivity));
      AppMethodBeat.o(333687);
      return paramActivity;
      paramActivity = paramActivity.getStringExtra("key_jump_id");
      if (paramActivity == null)
      {
        paramActivity = "";
      }
      else
      {
        String str = n.m(paramActivity, ",", ";", false);
        paramActivity = str;
        if (str == null) {
          paramActivity = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderJumpDataUtils$OnClearListenerImpl;", "Lcom/tencent/mm/plugin/finder/report/jump/OnClearListener;", "()V", "onClear", "", "context", "Landroid/content/Context;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c
  {
    public final void gQ(Context paramContext)
    {
      AppMethodBeat.i(333649);
      s.u(paramContext, "context");
      as.a locala = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext != null) {
        paramContext.ayc("");
      }
      Log.i("FinderJumpDataUtils", "[onClear] jumpInfo");
      AppMethodBeat.o(333649);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.u
 * JD-Core Version:    0.7.0.1
 */