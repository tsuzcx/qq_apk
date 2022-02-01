package com.tencent.mm.plugin.finder.live.sidebar;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "currentSideBarJumpInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;", "getCurrentSideBarJumpInfo", "()Ljava/util/LinkedList;", "finderLivePresenter", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "getFinderLivePresenter", "()Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "setFinderLivePresenter", "(Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;)V", "finderLiveSideBar", "Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar;", "getFinderLiveSideBar", "()Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar;", "setFinderLiveSideBar", "(Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBar;)V", "value", "", "inSideBarStatus", "getInSideBarStatus", "()Z", "setInSideBarStatus", "(Z)V", "reporter", "Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBarUIC$SideBarReporter;", "getReporter", "()Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBarUIC$SideBarReporter;", "setReporter", "(Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBarUIC$SideBarReporter;)V", "mount", "", "curLive", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "bannerJumpInfo", "unMount", "SideBarReporter", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  public boolean DGD;
  public c DGE;
  public com.tencent.mm.plugin.finder.live.g DGF;
  public final LinkedList<com.tencent.mm.plugin.finder.live.model.b> DGG;
  public a DGH;
  private final String TAG;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(351979);
    this.TAG = "Finder.FinderLiveSideBarUIC";
    this.DGG = new LinkedList();
    this.DGH = new a();
    AppMethodBeat.o(351979);
  }
  
  public final void a(f paramf, com.tencent.mm.plugin.finder.live.model.b paramb)
  {
    AppMethodBeat.i(352008);
    s.u(paramf, "curLive");
    s.u(paramb, "bannerJumpInfo");
    Object localObject = a.DGm;
    localObject = a.axE(paramb.CDz.ext_info);
    int i;
    label130:
    int j;
    if (localObject == null)
    {
      i = -1;
      this.DGH = new a(i);
      Log.i(this.TAG, "report init reporter. " + this.DGH.id + ", hashCode:" + this.DGH.hashCode());
      this.DGG.clear();
      this.DGG.add(paramb);
      localObject = ((List)paramb.CDA).iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label279;
      }
      if (((f)((Iterator)localObject).next()).Ebr.liveId != paramf.Ebr.liveId) {
        break label266;
      }
      j = 1;
      label170:
      if (j == 0) {
        break label272;
      }
    }
    for (;;)
    {
      if (i < 0) {
        paramb.CDA.add(0, paramf);
      }
      c localc = this.DGE;
      if (localc != null)
      {
        List localList = (List)paramb.CDA;
        localObject = paramb.CDz.wording;
        paramb = (com.tencent.mm.plugin.finder.live.model.b)localObject;
        if (localObject == null) {
          paramb = getContext().getString(p.h.CsU);
        }
        s.s(paramb, "bannerJumpInfo.data.word…ive_sidebar_default_tips)");
        localc.a(paramf, localList, paramb);
      }
      AppMethodBeat.o(352008);
      return;
      i = ((bfn)localObject).ZPw;
      break;
      label266:
      j = 0;
      break label170;
      label272:
      i += 1;
      break label130;
      label279:
      i = -1;
    }
  }
  
  public final void rT(boolean paramBoolean)
  {
    AppMethodBeat.i(351992);
    Log.i(this.TAG, s.X("set inSideBarStatus:", Boolean.valueOf(paramBoolean)));
    this.DGD = paramBoolean;
    AppMethodBeat.o(351992);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(352015);
    c localc = this.DGE;
    if (localc != null) {
      localc.etC();
    }
    AppMethodBeat.o(352015);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBarUIC$SideBarReporter;", "", "id", "", "(Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveSideBarUIC;I)V", "activeIndex", "getActiveIndex", "()I", "setActiveIndex", "(I)V", "enterFromRightClick", "", "getEnterFromRightClick", "()Z", "setEnterFromRightClick", "(Z)V", "enterOpType", "getEnterOpType", "setEnterOpType", "exitOpType", "getExitOpType", "setExitOpType", "getId", "setId", "lastActiveIndex", "getLastActiveIndex", "setLastActiveIndex", "lastClickItemPos", "getLastClickItemPos", "setLastClickItemPos", "lastExposeSet", "Ljava/util/HashSet;", "getLastExposeSet", "()Ljava/util/HashSet;", "model_operat_type", "getModel_operat_type", "setModel_operat_type", "model_start_time", "", "getModel_start_time", "()J", "setModel_start_time", "(J)V", "appendChnlExtra", "", "chnlExtra", "key", "value", "checkJoinRoomMode", "", "curPos", "genJoinLiveChnlExtra", "Lkotlin/Pair;", "genQuitLiveChnlExtra", "reportBannerClick", "reportBannerExpose", "reportEnterSideBar", "reportExitSideBar", "reportSideBarExpose", "sideBarDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/sidebar/FinderLiveFeed;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "reportSideBarExposeWhenEnter", "sideBarRv", "Landroidx/recyclerview/widget/RecyclerView;", "doAfterReport", "Lkotlin/Function0;", "reportSideBarItemClick", "index", "feed", "reportSideBarItemExpose", "card_exp_type", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    final HashSet<Integer> AUK;
    long DGI;
    public boolean DGJ;
    public int DGK;
    public int DGL;
    int DGM;
    public int DGN;
    public int activeIndex;
    int id;
    
    public a()
    {
      AppMethodBeat.i(352041);
      int i;
      this.id = i;
      this.DGK = -1;
      this.activeIndex = -1;
      this.DGL = -1;
      this.DGM = 2;
      this.DGN = 2;
      this.AUK = new HashSet();
      AppMethodBeat.o(352041);
    }
    
    public final void a(int paramInt1, b paramb, int paramInt2)
    {
      AppMethodBeat.i(352091);
      if (paramb == null)
      {
        Log.i(d.a(d.this), "report reportSideBarItemExpose feed is null");
        AppMethodBeat.o(352091);
        return;
      }
      Map localMap = (Map)new LinkedHashMap();
      localMap.put("banner_type", "common_recmd");
      localMap.put("active_id", String.valueOf(this.id));
      localMap.put("active_index", String.valueOf(paramInt1));
      localMap.put("card_exp_type", String.valueOf(paramInt2));
      localMap.put("liveId", com.tencent.mm.ae.d.hF(paramb.data.Ebr.liveId));
      localMap.put("feedId", com.tencent.mm.ae.d.hF(paramb.data.Ebr.mIH));
      Object localObject;
      if (d.this.DGF == null) {
        localObject = "";
      }
      for (;;)
      {
        localMap.put("liveid_id", localObject);
        j.Dob.a(q.t.Dwu, localMap);
        Log.i(d.a(d.this), "report reportSideBarItemExpose " + this.id + ", " + paramInt1 + ", " + com.tencent.mm.ae.d.hF(paramb.data.Ebr.liveId) + ", " + com.tencent.mm.ae.d.hF(paramb.data.Ebr.mIH) + ' ');
        AppMethodBeat.o(352091);
        return;
        localObject = com.tencent.mm.plugin.finder.live.g.egY();
        if (localObject == null)
        {
          localObject = "";
        }
        else
        {
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).exW();
          if (localObject == null)
          {
            localObject = "";
          }
          else
          {
            localObject = ((f)localObject).Ebr;
            if (localObject == null)
            {
              localObject = "";
            }
            else
            {
              String str = Long.valueOf(((LiveConfig)localObject).liveId).toString();
              localObject = str;
              if (str == null) {
                localObject = "";
              }
            }
          }
        }
      }
    }
    
    final String ai(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(352106);
      try
      {
        JSONObject localJSONObject = new JSONObject(n.m(paramString1, ";", ",", false));
        localJSONObject.put(paramString2, paramString3);
        paramString2 = localJSONObject.toString();
        s.s(paramString2, "jsonObject.toString()");
        paramString2 = n.bV(paramString2, ",", ";");
        AppMethodBeat.o(352106);
        return paramString2;
      }
      catch (Exception paramString2)
      {
        Log.i(d.a(d.this), s.X("report appendChnlExtra error, ", paramString2.getMessage()));
        AppMethodBeat.o(352106);
      }
      return paramString1;
    }
    
    public final r<Boolean, String> etF()
    {
      AppMethodBeat.i(352059);
      Object localObject = k.aeZF;
      localObject = ((bn)k.nq((Context)d.this.getContext()).cq(bn.class)).foA();
      if (this.DGJ) {}
      for (localObject = ai(ai((String)localObject, "active_id", String.valueOf(this.id)), "active_index", String.valueOf(this.activeIndex));; localObject = ai(ai(ai((String)localObject, "single_stream_type", "active"), "active_id", String.valueOf(this.id)), "active_index", String.valueOf(this.activeIndex)))
      {
        Log.i(d.a(d.this), d.this.DGH.hashCode() + "report genJoinLiveChnlExtra " + this.DGJ + ", " + this.id + ", " + this.activeIndex + ", " + (String)localObject);
        localObject = new r(Boolean.valueOf(this.DGJ), localObject);
        AppMethodBeat.o(352059);
        return localObject;
      }
    }
    
    public final r<Boolean, String> etG()
    {
      AppMethodBeat.i(352070);
      Object localObject = k.aeZF;
      localObject = ((bn)k.nq((Context)d.this.getContext()).cq(bn.class)).foA();
      if (this.DGJ) {}
      for (localObject = ai(ai((String)localObject, "active_id", String.valueOf(this.id)), "active_index", String.valueOf(this.DGL));; localObject = ai(ai(ai((String)localObject, "single_stream_type", "active"), "active_id", String.valueOf(this.id)), "active_index", String.valueOf(this.DGL)))
      {
        Log.i(d.a(d.this), d.this.DGH.hashCode() + "report genQuitLiveChnlExtra " + this.DGJ + ", " + this.id + ", " + this.DGL + ", " + (String)localObject);
        localObject = new r(Boolean.valueOf(this.DGJ), localObject);
        AppMethodBeat.o(352070);
        return localObject;
      }
    }
    
    public final void etH()
    {
      AppMethodBeat.i(352079);
      Map localMap = (Map)new LinkedHashMap();
      localMap.put("banner_type", "common_recmd");
      localMap.put("active_id", String.valueOf(this.id));
      j.Dob.a(q.t.Dwt, localMap);
      Log.i(d.a(d.this), "report reportBannerExpose " + this.id + ", " + localMap.get("liveId") + ", " + localMap.get("feedId"));
      AppMethodBeat.o(352079);
    }
    
    public final void etI()
    {
      AppMethodBeat.i(352098);
      Map localMap = (Map)new LinkedHashMap();
      localMap.put("banner_type", "common_recmd");
      localMap.put("active_id", String.valueOf(this.id));
      j.Dob.a(q.s.Dvh, localMap);
      Log.i(d.a(d.this), s.X("report reportBannerClick ", Integer.valueOf(this.id)));
      AppMethodBeat.o(352098);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(HashSet<Integer> paramHashSet, d.a parama, d paramd, ArrayList<b> paramArrayList)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(int paramInt1, int paramInt2, d.a parama, ArrayList<b> paramArrayList, kotlin.g.a.a<ah> parama1)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.sidebar.d
 * JD-Core Version:    0.7.0.1
 */