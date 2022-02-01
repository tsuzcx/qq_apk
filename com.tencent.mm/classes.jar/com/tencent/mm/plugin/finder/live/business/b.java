package com.tencent.mm.plugin.finder.live.business;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/business/LiveFestivalSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "checkCoupletsGuide", "", "activity", "Landroid/app/Activity;", "checkTigerFlag", "", "onCleared", "share2SNS", "showCoupletsGuide", "storeTigerFlag", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  private final String TAG;
  
  public b(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(371042);
    this.TAG = "Finder.LiveFestivalSlice";
    AppMethodBeat.o(371042);
  }
  
  public final boolean cr(Activity paramActivity)
  {
    boolean bool3 = false;
    AppMethodBeat.i(371055);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool4 = com.tencent.mm.plugin.finder.live.utils.a.azc(((e)business(e.class)).mIY);
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool5 = com.tencent.mm.plugin.finder.live.utils.a.azd(((e)business(e.class)).mIY);
    if (i.aRC().getInt("SnsTiger2022LivePopUp", 0) != 1)
    {
      localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.kME().bmg()).intValue() != 1) {
        break label127;
      }
    }
    label127:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = h.baE().ban().get(at.a.aklw, Boolean.FALSE);
      if (localObject1 != null) {
        break;
      }
      paramActivity = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(371055);
      throw paramActivity;
    }
    boolean bool6 = ((Boolean)localObject1).booleanValue();
    Log.i(this.TAG, "checkCoupletsGuide isFestivalEvent:" + bool4 + " isCoupletsEvent:" + bool5 + " coupletsActivityEnable:" + bool1 + " hasShowCoupletsGuide:" + bool6);
    boolean bool2 = bool3;
    Object localObject2;
    Object localObject3;
    if (paramActivity != null) {
      if (!bool4)
      {
        bool2 = bool3;
        if (!bool5) {}
      }
      else
      {
        bool2 = bool3;
        if (bool1)
        {
          if (bool6) {
            break label521;
          }
          d.uiThread((kotlin.g.a.a)new b.a(paramActivity, this));
          paramActivity = j.Dob;
          localObject1 = q.t.akfq;
          localObject2 = (Map)new LinkedHashMap();
          ((Map)localObject2).put("liveid", d.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
          localObject3 = ((e)business(e.class)).Eco;
          if (localObject3 != null) {
            break label500;
          }
          l = 0L;
          ((Map)localObject2).put("feedid", d.hF(l));
          localObject3 = ah.aiuX;
          paramActivity.a((q.t)localObject1, (Map)localObject2);
          localObject1 = ((e)business(e.class)).Eco;
          if (localObject1 != null)
          {
            paramActivity = FinderItem.Companion;
            paramActivity = FinderItem.a.e((FinderObject)localObject1, 16384);
            paramActivity.setEcSource(((e)business(e.class)).Edn);
            localObject2 = MultiProcessMMKV.getMMKV("FINDER_LIVE_MMKV");
            if (localObject2 != null) {
              ((MultiProcessMMKV)localObject2).encode("MMKV_KEY_FINDER_LIVE_TIGER", paramActivity.getFinderLive().toByteArray());
            }
            localObject2 = this.TAG;
            localObject3 = new StringBuilder("storeTigerFlag ");
            paramActivity = ((FinderObject)localObject1).liveInfo;
            if (paramActivity != null) {
              break label510;
            }
            paramActivity = null;
            label451:
            Log.i((String)localObject2, paramActivity + ' ' + ((FinderObject)localObject1).id + ' ' + ((FinderObject)localObject1).username);
          }
          bool2 = true;
        }
      }
    }
    label500:
    label510:
    do
    {
      AppMethodBeat.o(371055);
      return bool2;
      l = ((FinderObject)localObject3).id;
      break;
      paramActivity = Long.valueOf(paramActivity.liveId);
      break label451;
      localObject2 = MultiProcessMMKV.getMMKV("FINDER_LIVE_MMKV");
      bool2 = bool3;
    } while (localObject2 == null);
    label521:
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    paramActivity = ((e)business(e.class)).Eej;
    if (paramActivity == null) {
      paramActivity = "";
    }
    for (;;)
    {
      localObject1 = ((MultiProcessMMKV)localObject2).decodeBytes("MMKV_KEY_FINDER_LIVE_TIGER");
      Log.i(this.TAG, "checkTigerFlag cache:" + localObject1 + " curLiveId:" + String.valueOf(l) + " curfun:" + paramActivity);
      bool2 = bool3;
      if (localObject1 != null) {
        break;
      }
      paramActivity = ((e)business(e.class)).Eco;
      bool2 = bool3;
      if (paramActivity == null) {
        break;
      }
      localObject1 = FinderItem.Companion;
      paramActivity = FinderItem.a.e(paramActivity, 16384);
      paramActivity.setEcSource(((e)business(e.class)).Edn);
      ((MultiProcessMMKV)localObject2).encode("MMKV_KEY_FINDER_LIVE_TIGER", paramActivity.getFinderLive().toByteArray());
      bool2 = bool3;
      break;
      localObject1 = paramActivity.getUsername();
      paramActivity = (Activity)localObject1;
      if (localObject1 == null) {
        paramActivity = "";
      }
    }
  }
  
  public final void onCleared() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.business.b
 * JD-Core Version:    0.7.0.1
 */