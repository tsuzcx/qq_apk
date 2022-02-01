package com.tencent.mm.plugin.finder.live.gala.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.gala.a.a.a;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.cy;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.a.l;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.w.a.a.a.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/viewpager/ViewPagerPluginRegister;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "viewPagerDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/gala/data/ViewPagerItemSelect;", "Lkotlin/collections/ArrayList;", "genLayout", "Landroid/view/View;", "id", "", "getCommentViewDatas", "registerPlugin", "", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "param", "Landroid/os/Bundle;", "resetBoxInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  public ArrayList<com.tencent.mm.plugin.finder.live.gala.a.a> agjD;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  public final MMActivity lzt;
  private final com.tencent.mm.live.b.b nfT;
  
  public d(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(371155);
    this.lzt = paramMMActivity;
    this.buContext = parama;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.agjD = new ArrayList();
    AppMethodBeat.o(371155);
  }
  
  public final void cc(Bundle paramBundle)
  {
    AppMethodBeat.i(371193);
    if (this.agjD.size() > 1)
    {
      localObject1 = this.agjD.get(0);
      kotlin.g.b.s.s(localObject1, "viewPagerDataList[0]");
      localObject1 = (com.tencent.mm.plugin.finder.live.gala.a.a)localObject1;
      this.agjD.clear();
      this.agjD.add(localObject1);
    }
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)this.buContext.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLh();
    if (localObject1 != null)
    {
      localObject1 = (ConcurrentHashMap)((x)localObject1).getValue();
      if (localObject1 != null)
      {
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        label512:
        label822:
        if (localIterator.hasNext())
        {
          h localh = (h)((Map.Entry)localIterator.next()).getValue();
          String str = localh.adma;
          localObject1 = com.tencent.mm.plugin.finder.live.gala.d.a.adlZ;
          com.tencent.mm.plugin.finder.live.gala.d.a.aLK(str);
          localObject1 = com.tencent.mm.plugin.finder.live.gala.d.a.adlZ;
          com.tencent.mm.plugin.finder.live.gala.d.a.rw(false);
          Object localObject2 = (cy)this.CwG.getPlugin(cy.class);
          int i;
          label232:
          boolean bool;
          if (localObject2 == null)
          {
            i = p.f.WkH;
            localObject1 = LayoutInflater.from((Context)this.lzt).inflate(i, null);
            kotlin.g.b.s.s(localObject1, "from(context).inflate(id, null)");
            localObject2 = new cy((ViewGroup)localObject1, this.nfT);
            kotlin.g.b.s.u(str, "boxId");
            if ((paramBundle == null) || (paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW") != true)) {
              break label466;
            }
            bool = true;
            label255:
            kotlin.g.b.s.u(str, "boxId");
            if (!kotlin.g.b.s.p(str, ((cy)localObject2).agxq)) {
              break label471;
            }
            Log.i("FinderLiveBoxCommentPlugin", kotlin.g.b.s.X("createBoxComment same id:", str));
            ((cy)localObject2).tO(0);
            localObject1 = ((com.tencent.mm.live.b.a)localObject2).mJe.getParent();
            if (!(localObject1 instanceof ViewGroup)) {
              break label1023;
            }
          }
          label466:
          label471:
          label1018:
          label1023:
          for (localObject1 = (ViewGroup)localObject1;; localObject1 = null)
          {
            if (localObject1 != null) {
              ((ViewGroup)localObject1).removeView((View)((com.tencent.mm.live.b.a)localObject2).mJe);
            }
            localObject1 = this.agjD;
            Object localObject3 = com.tencent.mm.plugin.finder.live.gala.a.a.adlB;
            localObject3 = (Context)this.lzt;
            localObject2 = (a)localObject2;
            kotlin.g.b.s.u(localObject3, "context");
            kotlin.g.b.s.u(localh, "msgInfo");
            kotlin.g.b.s.u(localObject2, "commentView");
            str = localh.adma;
            i = p.h.XMD;
            Object localObject4 = com.tencent.mm.plugin.finder.live.gala.d.b.admb;
            localObject3 = ((Context)localObject3).getString(i, new Object[] { a.a.aza(com.tencent.mm.plugin.finder.live.gala.d.b.bhS(localh.adma)) });
            kotlin.g.b.s.s(localObject3, "context.getString(R.stri…roupName(msgInfo.boxId)))");
            ((ArrayList)localObject1).add(new com.tencent.mm.plugin.finder.live.gala.a.a(str, (String)localObject3, localh.adlC, (a)localObject2));
            break;
            break label232;
            bool = false;
            break label255;
            ((cy)localObject2).bko(str);
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)((cy)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
            kotlin.g.b.s.u(str, "boxId");
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject1).akgV;
            if (localObject1 == null)
            {
              localObject1 = null;
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = new ArrayList((Collection)ab.aivy);
              }
              Log.i("FinderLiveBoxCommentPlugin", "createBoxComment " + ((cy)localObject2).hashCode() + " id:" + str + ",fromMiniWindow:" + bool + ", dataSize:" + ((ArrayList)localObject3).size());
              if ((((ArrayList)localObject3).size() <= 0) || (bool)) {
                break label1018;
              }
            }
            for (bool = true;; bool = false)
            {
              ((cy)localObject2).NQ(bool);
              localObject1 = com.tencent.mm.plugin.finder.live.b.b.Zuu;
              ((cy)localObject2).agxw = new WxRecyclerAdapter(com.tencent.mm.plugin.finder.live.b.b.ech(), (ArrayList)localObject3);
              ((cy)localObject2).jdt().setAdapter((RecyclerView.a)((cy)localObject2).agxw);
              localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)((cy)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
              localObject1 = (f.a)((cy)localObject2).jdu();
              kotlin.g.b.s.u(str, "boxId");
              kotlin.g.b.s.u(localObject1, "notifier");
              localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject3).akgV;
              if (localObject3 == null) {
                break;
              }
              kotlin.g.b.s.u(str, "boxId");
              Log.i(f.TAG, "setMsgNotifier,boxId " + str + ", notifier:" + localObject1);
              ((Map)((f)localObject3).akgp).put(str, localObject1);
              break;
              kotlin.g.b.s.u(str, "boxId");
              if (((CharSequence)str).length() == 0) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label822;
                }
                localObject1 = new ArrayList((Collection)ab.aivy);
                break;
              }
              localObject4 = ((f)localObject1).bkJ(str);
              if (localObject4 != null)
              {
                localObject3 = ((h)localObject4).akgL.akjP;
                localObject4 = ((h)localObject4).pUj;
                com.tencent.mm.ae.d.a((ArrayList)localObject4, (kotlin.g.a.b)f.h.akgG);
                kotlin.g.b.s.s(localObject3, "memDataList");
                com.tencent.mm.ae.d.a((LinkedList)localObject3, (kotlin.g.a.b)f.i.akgH);
                Object localObject5 = new bdm();
                ((bdm)localObject5).msg_type = 10001;
                ((bdm)localObject5).seq = -1L;
                Object localObject6 = new edf();
                ((edf)localObject6).content = MMApplicationContext.getContext().getString(a.i.finder_live_box_sys_content);
                ah localah = ah.aiuX;
                ((bdm)localObject5).ZNY = com.tencent.mm.bx.b.cX(((edf)localObject6).toByteArray());
                localObject5 = new l((bdm)localObject5);
                localObject6 = f.b.g((com.tencent.mm.plugin.finder.live.viewmodel.data.a.b)localObject5);
                ((ArrayList)localObject4).add(localObject5);
                ((LinkedList)localObject3).add(localObject6);
              }
              localObject1 = ((f)localObject1).bkJ(str);
              if (localObject1 == null)
              {
                localObject1 = null;
                break label512;
              }
              localObject1 = ((h)localObject1).pUj;
              break label512;
            }
          }
        }
      }
    }
    AppMethodBeat.o(371193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.viewpager.d
 * JD-Core Version:    0.7.0.1
 */