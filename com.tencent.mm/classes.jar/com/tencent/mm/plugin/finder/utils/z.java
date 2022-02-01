package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.d;
import com.tencent.mm.plugin.finder.cgi.e;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.view.j;
import com.tencent.mm.plugin.i.a.ab;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.aj.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderUtilApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi;", "()V", "TAG", "", "enterActivityProfileUI", "", "context", "Landroid/content/Context;", "encryptedTopicId", "eventName", "extra", "enterFriendLikeTimelineUI", "targetUsername", "targetNickname", "commentScene", "", "get3TabTargetTabCommentScene", "getFinderSnsHeader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader;", "Landroid/app/Activity;", "getLiveNoticeStateWithAnchorUserName", "username", "noticeId", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "failedCallback", "getLiveStatusWithUserName", "liveId", "", "getLongVideoMaxDuration", "getLongVideoMaxRatio", "", "getLongVideoMinRatio", "getWxProfileInfo", "", "wxUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "isEnableNearbyLiveFriends", "isEnableNearbyLivePullSimilar", "jumpLiveUIByFeedId", "feedExportId", "feedNonceId", "Ljava/lang/Void;", "contextId", "reportExtraInfo", "reserveLiveNoticeWithAnchorUsername", "reserveOperation", "resetRequestTime", "setBlurBitmap", "imageView", "Landroid/widget/ImageView;", "url", "radius", "showLiveRoomWithUserName", "", "plugin-finder_release"})
public final class z
  implements com.tencent.mm.plugin.i.a.af
{
  final String TAG = "Finder.FinderUtilApi";
  
  public final void B(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(253725);
    p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (paramString1 == null) {}
    for (String str = "";; str = paramString1)
    {
      localIntent.putExtra("key_encrypted_topic_id", str);
      if (paramString2 == null) {}
      for (str = "";; str = paramString2)
      {
        localIntent.putExtra("key_activity_name", str);
        Log.i(this.TAG, "enterActivityProfileUI :" + paramString1 + " eventName:" + paramString2);
        paramString1 = a.vUU;
        a.aa(paramContext, localIntent);
        AppMethodBeat.o(253725);
        return;
      }
    }
  }
  
  public final Object a(String paramString, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, af.a<Object> parama, af.a<Integer> parama1)
  {
    AppMethodBeat.i(253716);
    p.h(paramb, "lifeCycle");
    aa localaa = aa.vYi;
    paramString = aa.b(paramString, paramb, parama, parama1);
    AppMethodBeat.o(253716);
    return paramString;
  }
  
  public final void a(long paramLong, af.a<Boolean> parama)
  {
    AppMethodBeat.i(253722);
    ((aj)g.ah(aj.class)).getLiveInfo(Long.valueOf(paramLong), (aj.b)new b(parama));
    AppMethodBeat.o(253722);
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, String paramString3, af.a<Void> parama, af.a<Integer> parama1)
  {
    AppMethodBeat.i(253723);
    a(paramString1, paramString2, parama1, paramString3, paramLong, parama, ((PluginFinder)g.ah(PluginFinder.class)).genContextId(4, 4, 65), "");
    AppMethodBeat.o(253723);
  }
  
  public final void a(String paramString1, final String paramString2, final af.a<Boolean> parama, final af.a<Integer> parama1)
  {
    AppMethodBeat.i(253720);
    if ((paramString1 == null) || (paramString2 == null))
    {
      parama1.bn(Integer.valueOf(-1000));
      AppMethodBeat.o(253720);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.live.a.ufi;
    localObject = com.tencent.mm.plugin.finder.live.a.gK(paramString1, paramString2);
    if (localObject != null)
    {
      parama.bn(localObject);
      AppMethodBeat.o(253720);
      return;
    }
    new d(paramString1, paramString2).aYI().g((com.tencent.mm.vending.c.a)new a(paramString1, paramString2, parama, parama1));
    AppMethodBeat.o(253720);
  }
  
  public final void a(String paramString1, String paramString2, final af.a<Integer> parama, String paramString3, final long paramLong, final af.a<Void> parama1, final String paramString4, final String paramString5)
  {
    AppMethodBeat.i(253724);
    p.h(paramString4, "contextId");
    p.h(paramString5, "reportExtraInfo");
    if (paramString2 == null)
    {
      if (parama != null)
      {
        parama.bn(Integer.valueOf(-1000));
        AppMethodBeat.o(253724);
        return;
      }
      AppMethodBeat.o(253724);
      return;
    }
    new com.tencent.mm.plugin.finder.cgi.af(0L, paramString3, 65, 2, "", true, null, null, 0L, null, false, false, paramString2, null, 0, 20416).aYI().g((com.tencent.mm.vending.c.a)new c(this, paramLong, paramString1, paramString4, paramString5, parama1, parama));
    AppMethodBeat.o(253724);
  }
  
  public final ab ao(Activity paramActivity)
  {
    AppMethodBeat.i(253715);
    p.h(paramActivity, "context");
    paramActivity = (ab)new j(paramActivity);
    AppMethodBeat.o(253715);
    return paramActivity;
  }
  
  public final void awv(String paramString)
  {
    AppMethodBeat.i(253717);
    aa localaa = aa.vYi;
    aa.awv(paramString);
    AppMethodBeat.o(253717);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(253719);
    if (paramContext != null)
    {
      localObject = (CharSequence)paramString1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label46;
      }
    }
    label46:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(253719);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("KEY_USERNAME", paramString1);
    ((Intent)localObject).putExtra("KEY_NICKNAME", paramString2);
    ((Intent)localObject).putExtra("KEY_COMMENT_SCENE", paramInt);
    ((aj)g.ah(aj.class)).fillContextIdToIntent(14, 2, paramInt, (Intent)localObject);
    paramString1 = a.vUU;
    a.T(paramContext, (Intent)localObject);
    AppMethodBeat.o(253719);
  }
  
  public final void b(String paramString1, String paramString2, af.a<Void> parama, final af.a<Integer> parama1)
  {
    AppMethodBeat.i(253721);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramString1 == null) || (paramString2 == null))
    {
      parama1.bn(Integer.valueOf(-1000));
      AppMethodBeat.o(253721);
      return;
    }
    new e(paramString1, paramString2).aYI().g((com.tencent.mm.vending.c.a)new d(parama, parama1));
    AppMethodBeat.o(253721);
  }
  
  public final int dDc()
  {
    AppMethodBeat.i(253712);
    Object localObject = c.vCb;
    if (((Number)c.dvD().value()).intValue() != 1)
    {
      localObject = c.vCb;
      i = c.dqA();
      AppMethodBeat.o(253712);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scb, 1801);
    localObject = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scc, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(253712);
      return i;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      int j = ((JSONObject)localObject).getInt("apiLevel");
      double d = ((JSONObject)localObject).getDouble("durationMultiplier");
      int k = Build.VERSION.SDK_INT;
      if ((d >= 0.0D) && (k <= j))
      {
        j = (int)(d * i);
        AppMethodBeat.o(253712);
        return j;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(253712);
    }
    return i;
  }
  
  public final float dDd()
  {
    AppMethodBeat.i(253713);
    float f = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scd, 3.0F);
    Log.i(this.TAG, "getLongVideoMaxRatio ".concat(String.valueOf(f)));
    AppMethodBeat.o(253713);
    return f;
  }
  
  public final float dDe()
  {
    AppMethodBeat.i(253714);
    float f = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scd, 3.0F);
    if (f >= 1.0F) {}
    for (f = 1.0F / f;; f = 0.3333333F)
    {
      Log.i(this.TAG, "getLongVideoMinRatio ".concat(String.valueOf(f)));
      AppMethodBeat.o(253714);
      return f;
    }
  }
  
  public final boolean dDf()
  {
    AppMethodBeat.i(253726);
    c localc = c.vCb;
    int i;
    boolean bool1;
    label45:
    boolean bool3;
    if (((Number)c.dwJ().value()).intValue() == 1)
    {
      i = 1;
      if (h.aqJ().getInt("FinderNearbyLiveSwitch", 1) != 1) {
        break label158;
      }
      bool1 = true;
      bool3 = ((aj)g.ah(aj.class)).showFinderEntry();
      localc = c.vCb;
      if (((Number)c.dwI().value()).intValue() != 1) {
        break label163;
      }
    }
    label158:
    label163:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i(this.TAG, "isEnableNearbyLiveFriends isValidUser:" + bool1 + " hasFinder:" + bool3 + " isEnableNearbyLiveFriends:" + bool2);
      if ((i == 0) && ((!bool1) || (!bool3) || (!bool2))) {
        break label168;
      }
      AppMethodBeat.o(253726);
      return true;
      i = 0;
      break;
      bool1 = false;
      break label45;
    }
    label168:
    AppMethodBeat.o(253726);
    return false;
  }
  
  public final boolean dDg()
  {
    AppMethodBeat.i(253727);
    c localc = c.vCb;
    if (((Number)c.dwK().value()).intValue() == 1)
    {
      AppMethodBeat.o(253727);
      return true;
    }
    AppMethodBeat.o(253727);
    return false;
  }
  
  public final int dli()
  {
    AppMethodBeat.i(253728);
    com.tencent.mm.plugin.finder.nearby.a locala = com.tencent.mm.plugin.finder.nearby.a.uQd;
    int i = com.tencent.mm.plugin.finder.nearby.a.dli();
    AppMethodBeat.o(253728);
    return i;
  }
  
  public final void g(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(253718);
    Object localObject = y.vXH;
    if ((paramImageView != null) && (paramString != null))
    {
      localObject = m.vVH;
      m.g(paramImageView, paramString);
    }
    AppMethodBeat.o(253718);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(String paramString1, String paramString2, af.a parama1, af.a parama2) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "espLiveId", "", "liveStatus", "", "resp", "", "kotlin.jvm.PlatformType", "onLiveStatusCallback"})
  static final class b
    implements aj.b
  {
    b(af.a parama) {}
    
    public final void a(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(253709);
      paramObject = this.tpa;
      if (paramObject != null)
      {
        if (paramInt != 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramObject.bn(Boolean.valueOf(bool));
          AppMethodBeat.o(253709);
          return;
        }
      }
      AppMethodBeat.o(253709);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(z paramz, long paramLong, String paramString1, String paramString2, String paramString3, af.a parama1, af.a parama2) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(af.a parama1, af.a parama2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.z
 * JD-Core Version:    0.7.0.1
 */