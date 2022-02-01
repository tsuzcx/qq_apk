package com.tencent.mm.plugin.finder.webview.search;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.sdk.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/search/FinderWebSearchService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderWebSearchService;", "()V", "enterFinderSearch", "", "context", "Landroid/content/Context;", "json", "Lorg/json/JSONObject;", "enterFinderTimeline", "getFinderItemDetail", "Lkotlinx/coroutines/flow/Flow;", "", "preloadFinderItem", "returnFail", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.findersdk.a.cb
{
  public static final a GZk;
  
  static
  {
    AppMethodBeat.i(334660);
    GZk = new a((byte)0);
    AppMethodBeat.o(334660);
  }
  
  private static final kotlinx.coroutines.cb a(Context paramContext, kotlinx.coroutines.a.h paramh, final a parama, b.a parama1)
  {
    AppMethodBeat.i(334651);
    s.u(paramContext, "$context");
    s.u(paramh, "$channel");
    s.u(parama, "this$0");
    localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((com.tencent.mm.plugin.mvvmbase.a.a)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramContext).q(com.tencent.mm.plugin.mvvmbase.a.a.class)).gsu();
    try
    {
      parama1 = ((ayl)parama1.ott).ZJq;
      paramContext = parama1;
      if (parama1 == null) {
        paramContext = "";
      }
      paramContext = LifecycleScope.launchDefault$default((LifecycleScope)localObject, null, (m)new a.c(new JSONObject(paramContext), paramh, null), 1, null);
    }
    finally
    {
      for (;;)
      {
        paramContext = LifecycleScope.launchDefault$default((LifecycleScope)localObject, null, (m)new d(paramh, parama, null), 1, null);
      }
    }
    AppMethodBeat.o(334651);
    return paramContext;
  }
  
  public static JSONObject fqu()
  {
    AppMethodBeat.i(334643);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", -1);
      label21:
      AppMethodBeat.o(334643);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final boolean f(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(334690);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "json");
    i = -1;
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("tabtype") != true) {
          continue;
        }
        j = 1;
        if (j != 0) {
          i = paramJSONObject.getInt("tabtype");
        }
      }
      catch (Exception localException1)
      {
        Log.printDebugStack("safeGetInt", "", new Object[] { localException1 });
        i = -1;
        continue;
        j = 0;
        continue;
      }
      localObject3 = null;
      try
      {
        if (paramJSONObject.has("finderstreamParams") != true) {
          continue;
        }
        j = 1;
        localObject1 = localObject3;
        if (j != 0) {
          localObject1 = paramJSONObject.getJSONObject("finderstreamParams");
        }
      }
      catch (Exception localException2)
      {
        Object localObject1;
        Log.printDebugStack("safeGetInt", "", new Object[] { localException2 });
        localObject2 = localObject3;
        continue;
        j = 0;
        continue;
      }
      localObject5 = null;
      if (localObject1 == null) {
        break label306;
      }
      try
      {
        if (((JSONObject)localObject1).has("targetFeedId") != true) {
          break label306;
        }
        j = 1;
        localObject3 = localObject5;
        if (j != 0) {
          localObject3 = ((JSONObject)localObject1).getString("targetFeedId");
        }
      }
      catch (Exception localException4)
      {
        Log.printDebugStack("safeGetString", "", new Object[] { localException4 });
        localObject4 = localObject5;
        continue;
        j = 0;
        continue;
      }
      localObject5 = null;
      if (localObject1 == null) {
        break label337;
      }
      try
      {
        if (((JSONObject)localObject1).has("h5ByPass") != true) {
          break label337;
        }
        j = 1;
        if (j == 0) {
          break label759;
        }
        localObject1 = ((JSONObject)localObject1).getString("h5ByPass");
      }
      catch (Exception localException3)
      {
        Object localObject4;
        Log.printDebugStack("safeGetString", "", new Object[] { localException3 });
        continue;
        j = 0;
        continue;
        Intent localIntent;
        localObject5 = com.tencent.mm.ui.component.k.aeZF;
        localObject5 = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(i);
        ((d.a)localObject5).a(d.d.GKM);
        ((d.a)localObject5).GKz = 0L;
        localIntent.putExtra("KEY_FINDER_IS_NEED_REFRESH_TAB", true);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(paramJSONObject, localIntent);
        if (str != null) {
          break label728;
        }
        localObject5 = null;
        localIntent.putExtra("key_extra_info", (String)localObject5);
        localObject5 = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.a(paramContext, localIntent, 4, false, 8);
        localObject5 = com.tencent.mm.plugin.report.service.h.OAn;
        if (str != null) {
          break label744;
        }
        for (paramContext = null;; paramContext = n.bV(str, ",", ";"))
        {
          ((com.tencent.mm.plugin.report.service.h)localObject5).b(21140, new Object[] { paramJSONObject, paramContext, localObject4, "" });
          AppMethodBeat.o(334690);
          return true;
          localIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", true);
          paramJSONObject = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(30, 2, 20);
          s.s(paramJSONObject, "plugin(IPluginFinder::cl…nt_Scene_Search_Rec_List)");
          break;
          localIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", true);
          paramJSONObject = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(30, 2, 18);
          s.s(paramJSONObject, "plugin(IPluginFinder::cl…ent_Scene_Friend_Rec_Tab)");
          break;
          localIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", true);
          paramJSONObject = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(30, 2, 17);
          s.s(paramJSONObject, "plugin(IPluginFinder::cl…Comment_Scene_Follow_Tab)");
          break;
          localObject5 = n.bV(str, ",", ";");
          break label533;
        }
        String str = null;
        continue;
      }
      localObject5 = localObject1;
      localObject1 = null;
      try
      {
        if (paramJSONObject.has("reportInfo") != true) {
          break label364;
        }
        j = 1;
        if (j != 0) {
          localObject1 = paramJSONObject.getString("reportInfo");
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject2;
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        str = null;
        continue;
        localIntent = new Intent();
        localIntent.putExtra("KEY_GUIDE_BAR_OBJ_ID", com.tencent.mm.ae.d.FK(localObject4));
        localIntent.putExtra("KEY_BY_PASS_INFO", (String)localObject5);
        switch (i)
        {
        case 2: 
        default: 
          paramJSONObject = "";
        }
      }
      Log.i("Finder.WebSearchService", "[enterFinderTimeline] tabType=" + i + " feedId=" + localObject3 + " h5ByPass=" + localObject5);
      if (i != -1) {
        break label392;
      }
      Log.e("Finder.WebSearchService", "[enterFinderTimeline] tabType is error!");
      AppMethodBeat.o(334690);
      return false;
      j = 0;
    }
  }
  
  public final boolean g(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(334704);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "json");
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("selectIndex") == true)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          i = paramJSONObject.getInt("selectIndex");
        }
      }
      catch (Exception localException1)
      {
        String str;
        Object localObject2;
        Log.printDebugStack("safeGetInt", "", new Object[] { localException1 });
        final int i = -1;
        continue;
        int j = 0;
        continue;
        Object localObject1;
        i = -1;
        continue;
      }
      try
      {
        if (paramJSONObject.has("scene") != true) {
          continue;
        }
        j = 1;
        if (j == 0) {
          continue;
        }
        str = paramJSONObject.getString("scene");
      }
      catch (Exception localException2)
      {
        Log.printDebugStack("safeGetString", "", new Object[] { localException2 });
        localObject2 = null;
        continue;
        j = 0;
        continue;
        localObject1 = null;
        continue;
      }
      localObject2 = str;
      try
      {
        if (paramJSONObject.has("reportInfo") != true) {
          continue;
        }
        j = 1;
        if (j == 0) {
          continue;
        }
        str = paramJSONObject.getString("reportInfo");
      }
      catch (Exception localException3)
      {
        Log.printDebugStack("safeGetString", "", new Object[] { localException3 });
        localObject1 = null;
        continue;
        final ah.f localf = new ah.f();
        LinkedList localLinkedList = new LinkedList();
        try
        {
          if (paramJSONObject.has("allSearchWord") != true) {
            continue;
          }
          j = 1;
          if (j == 0) {
            continue;
          }
          paramJSONObject = paramJSONObject.getJSONArray("allSearchWord");
        }
        catch (Exception paramJSONObject)
        {
          StringBuilder localStringBuilder;
          Log.printDebugStack("safeGetInt", "", new Object[] { paramJSONObject });
          paramJSONObject = null;
          continue;
          paramJSONObject = paramJSONObject.aacq;
          continue;
          AppMethodBeat.o(334704);
          return false;
        }
        if (paramJSONObject == null) {
          continue;
        }
        c.a(paramJSONObject, (kotlin.g.a.b)new b(localLinkedList, new ah.d(), i, localf));
        localStringBuilder = new StringBuilder("[enterFinderSearch] selectIndex=").append(i).append(" searchWord=");
        paramJSONObject = (bux)localf.aqH;
        if (paramJSONObject != null) {
          continue;
        }
        paramJSONObject = null;
        Log.i("Finder.WebSearchService", paramJSONObject + " hotWordList=" + localLinkedList.size() + " scene=" + localObject2 + " reportInfo=" + localObject1);
        paramJSONObject = (bux)localf.aqH;
        if (paramJSONObject == null) {
          continue;
        }
        localObject2 = new Intent();
        localObject1 = as.GSQ;
        as.a.a(paramContext, (Intent)localObject2, 0L, 0, false, 124);
        localObject1 = paramJSONObject.aacq;
        paramJSONObject = (JSONObject)localObject1;
        if (localObject1 != null) {
          continue;
        }
        paramJSONObject = "";
        ((Intent)localObject2).putExtra("key_search_query", paramJSONObject);
        ((Intent)localObject2).putExtra("key_search_is_from_wx_global_search", true);
        paramJSONObject = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.b(paramContext, null, (Intent)localObject2);
        AppMethodBeat.o(334704);
        return true;
        j = 0;
        continue;
        paramJSONObject = null;
        continue;
        localObject1 = null;
        continue;
      }
      if (i != -1) {
        continue;
      }
      Log.e("Finder.WebSearchService", "[enterFinderSearch] selectIndex is error!");
      AppMethodBeat.o(334704);
      return false;
      i = 0;
    }
  }
  
  public final g<String> h(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(334712);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "json");
    kotlinx.coroutines.a.h localh = kotlinx.coroutines.a.k.a(0, null, 7);
    Log.i("Finder.WebSearchService", s.X("[getFinderItemDetail] ", paramJSONObject));
    localObject3 = null;
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("feedid") != true) {
          continue;
        }
        i = 1;
        localObject1 = localObject3;
        if (i != 0) {
          localObject1 = paramJSONObject.getString("feedid");
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        long l;
        Log.printDebugStack("safeGetString", "", new Object[] { localException });
        localObject2 = localObject3;
        continue;
        int i = 0;
        continue;
      }
      l = com.tencent.mm.ae.d.FK((String)localObject1);
      localObject1 = null;
      try
      {
        if (paramJSONObject.has("nonceid") != true) {
          continue;
        }
        i = 1;
        if (i != 0) {
          localObject1 = paramJSONObject.getString("nonceid");
        }
        paramJSONObject = (JSONObject)localObject1;
      }
      catch (Exception paramJSONObject)
      {
        Log.printDebugStack("safeGetString", "", new Object[] { paramJSONObject });
        paramJSONObject = null;
        continue;
        Object localObject2 = ((as)localObject2).fou();
        continue;
      }
      localObject1 = as.GSQ;
      localObject1 = as.a.hu(paramContext);
      if (localObject1 != null) {
        break label262;
      }
      localObject1 = null;
      new az(l, paramJSONObject, 1100001, 2, "", true, null, null, 0L, null, false, false, null, (bui)localObject1, 0, null, 57280).bFJ().a((com.tencent.mm.vending.e.b)paramContext).h(new a..ExternalSyntheticLambda0(paramContext, localh, this));
      paramContext = kotlinx.coroutines.b.k.a((x)localh);
      AppMethodBeat.o(334712);
      return paramContext;
      i = 0;
    }
  }
  
  public final boolean i(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(334718);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "json");
    AppMethodBeat.o(334718);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/search/FinderWebSearchService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "searchObj", "Lorg/json/JSONObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<JSONObject, ah>
  {
    b(LinkedList<bux> paramLinkedList, ah.d paramd, int paramInt, ah.f<bux> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(kotlinx.coroutines.a.h<String> paramh, a parama, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(334665);
      paramObject = (kotlin.d.d)new d(this.aaM, parama, paramd);
      AppMethodBeat.o(334665);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(334655);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(334655);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.aaM;
        String str = a.fqu().toString();
        s.s(str, "returnFail().toString()");
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.b(str, locald) == locala)
        {
          AppMethodBeat.o(334655);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(334655);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.search.a
 * JD-Core Version:    0.7.0.1
 */