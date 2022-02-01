package com.tencent.mm.plugin.finder.live.report;

import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.el;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.cj;
import com.tencent.mm.plugin.findersdk.a.v;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report;", "", "()V", "TAG", "", "mExposureCallback", "com/tencent/mm/plugin/finder/live/report/Audience21053Report$mExposureCallback$1", "Lcom/tencent/mm/plugin/finder/live/report/Audience21053Report$mExposureCallback$1;", "mFeedExposure", "Lcom/tencent/mm/plugin/finder/live/report/HellFeedExposure;", "mFeedSingleExposure", "Lcom/tencent/mm/plugin/finder/live/report/HellFeedSingleExposure;", "getSessionBuffer", "feedId", "", "scene", "report", "", "listView", "Landroid/widget/AbsListView;", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "firstVisibleItem", "", "visibleItemCount", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "event", "Lcom/tencent/mm/plugin/finder/live/report/HELL_SCROLL_EVENT;", "headerShow", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "reportOnClick", "clickData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorClickData;", "reportOnClickOnShare", "enterData", "Lcom/tencent/mm/plugin/finder/live/report/HellVisitorEnterData;", "reportOnEnter", "reportOnExposeWhenNearby", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "clickSubTabContextId", "chnlExtra", "reportOnExposure", "liveFeed", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveItem;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveMixSearchItem;", "index", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final a DmX;
  private final e DmY;
  final f DmZ;
  final String TAG;
  
  public a()
  {
    AppMethodBeat.i(351818);
    this.TAG = "HABBYGE-MALI.Audience21053Report";
    this.DmX = new a(this);
    this.DmY = new e((p)this.DmX);
    this.DmZ = new f((p)this.DmX);
    AppMethodBeat.o(351818);
  }
  
  static String aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(351828);
    Object localObject2 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).p(paramLong1, (int)paramLong2);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject1 != null) {
        break label108;
      }
      localObject1 = null;
    }
    for (;;)
    {
      localObject1 = String.valueOf(localObject1);
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = k.Doi;
        localObject2 = k.getSessionBuffer();
      }
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(351828);
      return "";
      label108:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).sessionBuffer;
      }
    }
    localObject1 = kotlin.n.n.m((String)localObject2, ",", ";", false);
    if (localObject1 == null)
    {
      AppMethodBeat.o(351828);
      return "";
    }
    AppMethodBeat.o(351828);
    return localObject1;
  }
  
  public final void a(RecyclerView paramRecyclerView, q.w paramw, String paramString, d paramd)
  {
    boolean bool2 = true;
    AppMethodBeat.i(351861);
    s.u(paramw, "actionType");
    s.u(paramString, "commentscene");
    s.u(paramd, "event");
    boolean bool1;
    label47:
    label55:
    label63:
    label71:
    label79:
    label87:
    Object localObject2;
    if (s.p(paramString, "94"))
    {
      bool1 = true;
      if (!bool1) {
        break label196;
      }
      bool1 = true;
      if (!bool1) {
        break label211;
      }
      bool1 = true;
      if (!bool1) {
        break label226;
      }
      bool1 = true;
      if (!bool1) {
        break label237;
      }
      bool1 = true;
      if (!bool1) {
        break label252;
      }
      bool1 = true;
      if (!bool1) {
        break label263;
      }
      bool1 = true;
      if (!bool1) {
        break label1193;
      }
      localObject2 = this.DmY;
      s.u(paramd, "event");
      s.u(paramw, "actionType");
      s.u(paramString, "commentscene");
    }
    label196:
    label211:
    label226:
    label237:
    label252:
    Object localObject1;
    label263:
    label392:
    label655:
    label679:
    label688:
    label694:
    label706:
    label836:
    label966:
    label971:
    label982:
    label1113:
    switch (e.a.$EnumSwitchMapping$0[paramd.ordinal()])
    {
    default: 
      Log.e(((e)localObject2).TAG, s.X("run, else-case, event=", paramd));
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      label504:
      label764:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  AppMethodBeat.o(351861);
                  return;
                  bool1 = s.p(paramString, "80");
                  break;
                  bool1 = s.p(paramString, q.n.DtB.scene);
                  break label47;
                  bool1 = s.p(paramString, q.n.Dtx.scene);
                  break label55;
                  bool1 = s.p(paramString, "26");
                  break label63;
                  bool1 = s.p(paramString, q.n.Dtw.scene);
                  break label71;
                  bool1 = s.p(paramString, "23");
                  break label79;
                  bool1 = s.p(paramString, "15");
                  break label87;
                } while (paramRecyclerView == null);
                paramd = paramRecyclerView.getLayoutManager();
                if ((paramd instanceof StaggeredGridLayoutManager))
                {
                  paramd = (StaggeredGridLayoutManager)paramd;
                  if (paramd == null) {
                    break label504;
                  }
                  ((e)localObject2).Dno = new WeakReference(paramd);
                  if (!s.p(paramString, q.n.Dtw.scene)) {
                    break label392;
                  }
                  paramRecyclerView = paramRecyclerView.getAdapter();
                  if (!(paramRecyclerView instanceof cj)) {
                    break label387;
                  }
                }
                for (paramRecyclerView = (cj)paramRecyclerView;; paramRecyclerView = null)
                {
                  if (paramRecyclerView == null) {
                    break label504;
                  }
                  ((e)localObject2).Dnq = new WeakReference(paramRecyclerView);
                  ((e)localObject2).a(paramRecyclerView, paramd, paramw, paramString);
                  AppMethodBeat.o(351861);
                  return;
                  paramd = null;
                  break;
                }
                if (s.p(paramString, q.n.Dtx.scene))
                {
                  paramRecyclerView = paramRecyclerView.getAdapter();
                  if ((paramRecyclerView instanceof WxRecyclerAdapter)) {}
                  for (paramRecyclerView = (WxRecyclerAdapter)paramRecyclerView; paramRecyclerView != null; paramRecyclerView = null)
                  {
                    ((e)localObject2).Dnr = new WeakReference(paramRecyclerView);
                    ((e)localObject2).a(paramRecyclerView, paramd, paramw, paramString);
                    AppMethodBeat.o(351861);
                    return;
                  }
                }
                paramRecyclerView = paramRecyclerView.getAdapter();
                if ((paramRecyclerView instanceof WxRecyclerAdapter)) {}
                for (paramRecyclerView = (WxRecyclerAdapter)paramRecyclerView;; paramRecyclerView = null)
                {
                  if (paramRecyclerView != null)
                  {
                    ((e)localObject2).Dnp = new WeakReference(paramRecyclerView);
                    ((e)localObject2).b(paramRecyclerView, paramd, paramw, paramString);
                  }
                  AppMethodBeat.o(351861);
                  return;
                }
              } while (paramRecyclerView == null);
              paramd = paramRecyclerView.getAdapter();
              if ((paramd instanceof WxRecyclerAdapter))
              {
                paramd = (WxRecyclerAdapter)paramd;
                if (paramd != null)
                {
                  ((e)localObject2).Dnt = new WeakReference(paramd);
                  paramRecyclerView = paramRecyclerView.getLayoutManager();
                  if (!(paramRecyclerView instanceof LinearLayoutManager)) {
                    break label615;
                  }
                }
              }
              for (paramRecyclerView = (LinearLayoutManager)paramRecyclerView;; paramRecyclerView = null)
              {
                if (paramRecyclerView != null)
                {
                  ((e)localObject2).Dns = new WeakReference(paramRecyclerView);
                  ((e)localObject2).a(paramd, paramRecyclerView, paramw, paramString);
                }
                AppMethodBeat.o(351861);
                return;
                paramd = null;
                break;
              }
              if (!s.p(paramString, q.n.Dtw.scene)) {
                break label801;
              }
              if (paramRecyclerView != null) {
                break label749;
              }
              paramd = null;
              if (!(paramd instanceof cj)) {
                break label758;
              }
              paramd = (cj)paramd;
              localObject1 = paramd;
              if (paramd != null) {
                break label688;
              }
              paramd = ((e)localObject2).Dnq;
              if (paramd != null) {
                break label764;
              }
              paramd = null;
            } while (paramd == null);
            localObject1 = paramd;
            if (paramRecyclerView == null)
            {
              paramRecyclerView = null;
              if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
                break label785;
              }
              paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView;
              paramd = paramRecyclerView;
              if (paramRecyclerView == null)
              {
                paramRecyclerView = ((e)localObject2).Dno;
                if (paramRecyclerView != null) {
                  break label790;
                }
              }
            }
            for (paramRecyclerView = null; paramRecyclerView != null; paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get())
            {
              paramd = paramRecyclerView;
              ((e)localObject2).a((cj)localObject1, paramd, paramw, paramString);
              AppMethodBeat.o(351861);
              return;
              paramd = paramRecyclerView.getAdapter();
              break label640;
              paramd = null;
              break label655;
              paramd = (cj)paramd.get();
              break label679;
              paramRecyclerView = paramRecyclerView.getLayoutManager();
              break label694;
              paramRecyclerView = null;
              break label706;
            }
            if (!s.p(paramString, q.n.Dtx.scene)) {
              break label982;
            }
            if (paramRecyclerView != null) {
              break label930;
            }
            paramd = null;
            if (!(paramd instanceof WxRecyclerAdapter)) {
              break label939;
            }
            paramd = (WxRecyclerAdapter)paramd;
            localObject1 = paramd;
            if (paramd != null) {
              break label869;
            }
            paramd = ((e)localObject2).Dnr;
            if (paramd != null) {
              break label945;
            }
            paramd = null;
          } while (paramd == null);
          localObject1 = paramd;
          if (paramRecyclerView == null)
          {
            paramRecyclerView = null;
            if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
              break label966;
            }
            paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView;
            paramd = paramRecyclerView;
            if (paramRecyclerView == null)
            {
              paramRecyclerView = ((e)localObject2).Dno;
              if (paramRecyclerView != null) {
                break label971;
              }
            }
          }
          for (paramRecyclerView = null; paramRecyclerView != null; paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get())
          {
            paramd = paramRecyclerView;
            ((e)localObject2).a((WxRecyclerAdapter)localObject1, paramd, paramw, paramString);
            AppMethodBeat.o(351861);
            return;
            paramd = paramRecyclerView.getAdapter();
            break label821;
            paramd = null;
            break label836;
            paramd = (WxRecyclerAdapter)paramd.get();
            break label860;
            paramRecyclerView = paramRecyclerView.getLayoutManager();
            break label875;
            paramRecyclerView = null;
            break label887;
          }
          if (paramRecyclerView != null) {
            break label1098;
          }
          paramd = null;
          if (!(paramd instanceof WxRecyclerAdapter)) {
            break label1107;
          }
          paramd = (WxRecyclerAdapter)paramd;
          localObject1 = paramd;
          if (paramd != null) {
            break label1037;
          }
          paramd = ((e)localObject2).Dnp;
          if (paramd != null) {
            break label1113;
          }
          paramd = null;
        } while (paramd == null);
        localObject1 = paramd;
        if (paramRecyclerView == null)
        {
          paramRecyclerView = null;
          if (!(paramRecyclerView instanceof StaggeredGridLayoutManager)) {
            break label1134;
          }
          paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView;
          paramd = paramRecyclerView;
          if (paramRecyclerView == null)
          {
            paramRecyclerView = ((e)localObject2).Dno;
            if (paramRecyclerView != null) {
              break label1139;
            }
          }
        }
        for (paramRecyclerView = null; paramRecyclerView != null; paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.get())
        {
          paramd = paramRecyclerView;
          ((e)localObject2).b((WxRecyclerAdapter)localObject1, paramd, paramw, paramString);
          AppMethodBeat.o(351861);
          return;
          paramd = paramRecyclerView.getAdapter();
          break label989;
          paramd = null;
          break label1004;
          paramd = (WxRecyclerAdapter)paramd.get();
          break label1028;
          paramRecyclerView = paramRecyclerView.getLayoutManager();
          break label1043;
          paramRecyclerView = null;
          break label1055;
        }
        ((e)localObject2).esZ();
      } while (!s.p(paramString, q.n.Dtw.scene));
      label615:
      label749:
      label758:
      label887:
      ((e)localObject2).eta();
      label860:
      label869:
      label875:
      label1004:
      label1134:
      label1139:
      AppMethodBeat.o(351861);
      label989:
      return;
    }
    label387:
    label785:
    label790:
    label801:
    label821:
    label1098:
    label1107:
    ((e)localObject2).Dnw.clear();
    label640:
    label930:
    label939:
    label945:
    AppMethodBeat.o(351861);
    label1028:
    label1037:
    label1043:
    label1055:
    return;
    label1193:
    switch (paramString.hashCode())
    {
    default: 
      bool1 = s.p(paramString, q.n.Dtv.scene);
      if (bool1)
      {
        bool1 = true;
        if (!bool1) {
          break label1681;
        }
        bool1 = true;
        if (!bool1) {
          break label1696;
        }
        bool1 = true;
        if (!bool1) {
          break label1711;
        }
        bool1 = true;
        label1324:
        if (!bool1) {
          break label1723;
        }
        bool1 = true;
        label1332:
        if (!bool1) {
          break label1735;
        }
        bool1 = true;
        label1340:
        if (!bool1) {
          break label1747;
        }
        bool1 = bool2;
        label1349:
        if (!bool1) {
          break label2335;
        }
        localObject2 = this.DmZ;
        s.u(paramd, "event");
        s.u(paramw, "actionType");
        s.u(paramString, "commentscene");
        switch (f.a.avl[paramd.ordinal()])
        {
        default: 
          if ((paramd != d.Dnf) && (paramd != d.Dnh)) {
            break label2255;
          }
          if (!s.p(paramString, q.n.Dtv.scene)) {
            break label2092;
          }
          if (paramRecyclerView == null)
          {
            paramd = null;
            if (!(paramd instanceof v)) {
              break label2046;
            }
            paramd = (v)paramd;
            label1463:
            if (paramd != null) {
              break label2065;
            }
            paramd = ((f)localObject2).Dnx;
            if (paramd != null) {
              break label2052;
            }
            paramd = null;
            label1483:
            if (paramd == null) {
              break label2335;
            }
            label1488:
            if (paramRecyclerView != null) {
              break label2068;
            }
            paramRecyclerView = null;
            label1494:
            if (!(paramRecyclerView instanceof LinearLayoutManager)) {
              break label2076;
            }
            paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
            label1506:
            localObject1 = paramRecyclerView;
            if (paramRecyclerView == null)
            {
              paramRecyclerView = ((f)localObject2).Dno;
              if (paramRecyclerView != null) {
                break label2081;
              }
            }
          }
          break;
        }
      }
      break;
    }
    label1292:
    label1300:
    label1308:
    label1316:
    label1448:
    for (paramRecyclerView = null;; paramRecyclerView = (LinearLayoutManager)paramRecyclerView.get())
    {
      if (paramRecyclerView == null) {
        break label2335;
      }
      localObject1 = paramRecyclerView;
      ((f)localObject2).a(paramd, (LinearLayoutManager)localObject1, paramw, paramString);
      AppMethodBeat.o(351861);
      return;
      if (!paramString.equals("1")) {
        break;
      }
      for (;;)
      {
        bool1 = true;
        break label1292;
        if (!paramString.equals("2"))
        {
          break;
          if (!paramString.equals("25"))
          {
            break;
            if (!paramString.equals("39"))
            {
              break;
              if (!paramString.equals("18"))
              {
                break;
                if (!paramString.equals("61"))
                {
                  break;
                  if (!paramString.equals("40"))
                  {
                    break;
                    if (!paramString.equals("20")) {
                      if ((goto 1280) || (!paramString.equals("21"))) {
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      bool1 = s.p(paramString, "12");
      break label1300;
      bool1 = s.p(paramString, q.n.Dtt.scene);
      break label1308;
      bool1 = s.p(paramString, q.n.DtA.scene);
      break label1316;
      label1711:
      bool1 = s.p(paramString, "27");
      break label1324;
      label1723:
      bool1 = s.p(paramString, "9");
      break label1332;
      label1735:
      bool1 = s.p(paramString, "6");
      break label1340;
      label1747:
      bool1 = s.p(paramString, "16");
      break label1349;
      if (paramRecyclerView == null) {
        break label2335;
      }
      paramd = paramRecyclerView.getLayoutManager();
      if ((paramd instanceof LinearLayoutManager))
      {
        paramd = (LinearLayoutManager)paramd;
        if (paramd == null) {
          break label1921;
        }
        ((f)localObject2).Dno = new WeakReference(paramd);
        if (!s.p(paramString, q.n.Dtv.scene)) {
          break label1877;
        }
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (!(paramRecyclerView instanceof v)) {
          break label1872;
        }
      }
      label1872:
      for (paramRecyclerView = (v)paramRecyclerView;; paramRecyclerView = null)
      {
        if (paramRecyclerView == null) {
          break label1921;
        }
        ((f)localObject2).Dnx = new WeakReference(paramRecyclerView);
        ((f)localObject2).a(paramRecyclerView, paramd, paramw, paramString);
        AppMethodBeat.o(351861);
        return;
        paramd = null;
        break;
      }
      label1877:
      paramRecyclerView = paramRecyclerView.getAdapter();
      if ((paramRecyclerView instanceof WxRecyclerAdapter)) {}
      for (paramRecyclerView = (WxRecyclerAdapter)paramRecyclerView;; paramRecyclerView = null)
      {
        if (paramRecyclerView != null)
        {
          ((f)localObject2).Dnp = new WeakReference(paramRecyclerView);
          ((f)localObject2).b(paramRecyclerView, paramd, paramw, paramString);
        }
        AppMethodBeat.o(351861);
        return;
      }
      if (paramRecyclerView == null) {
        break label2335;
      }
      paramd = paramRecyclerView.getAdapter();
      if ((paramd instanceof WxRecyclerAdapter))
      {
        paramd = (WxRecyclerAdapter)paramd;
        if (paramd != null)
        {
          ((f)localObject2).Dnp = new WeakReference(paramd);
          paramRecyclerView = paramRecyclerView.getLayoutManager();
          if (!(paramRecyclerView instanceof LinearLayoutManager)) {
            break label2032;
          }
        }
      }
      label2032:
      for (paramRecyclerView = (LinearLayoutManager)paramRecyclerView;; paramRecyclerView = null)
      {
        if (paramRecyclerView != null)
        {
          ((f)localObject2).Dno = new WeakReference(paramRecyclerView);
          ((f)localObject2).a(paramd, paramRecyclerView, paramw, paramString);
        }
        AppMethodBeat.o(351861);
        return;
        paramd = null;
        break;
      }
      paramd = paramRecyclerView.getAdapter();
      break label1448;
      label2046:
      paramd = null;
      break label1463;
      paramd = (v)paramd.get();
      break label1483;
      break label1488;
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      break label1494;
      paramRecyclerView = null;
      break label1506;
    }
    label1681:
    label1696:
    label2081:
    label2092:
    if (paramRecyclerView == null)
    {
      paramd = null;
      if (!(paramd instanceof WxRecyclerAdapter)) {
        break label2209;
      }
      paramd = (WxRecyclerAdapter)paramd;
      label2114:
      if (paramd != null) {
        break label2228;
      }
      paramd = ((f)localObject2).Dnp;
      if (paramd != null) {
        break label2215;
      }
      paramd = null;
      label2134:
      if (paramd == null) {
        break label2335;
      }
      label2139:
      if (paramRecyclerView != null) {
        break label2231;
      }
      paramRecyclerView = null;
      label2145:
      if (!(paramRecyclerView instanceof LinearLayoutManager)) {
        break label2239;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      label2157:
      localObject1 = paramRecyclerView;
      if (paramRecyclerView == null)
      {
        paramRecyclerView = ((f)localObject2).Dno;
        if (paramRecyclerView != null) {
          break label2244;
        }
        paramRecyclerView = null;
      }
    }
    for (;;)
    {
      label1921:
      label2052:
      label2065:
      label2068:
      label2076:
      if (paramRecyclerView != null)
      {
        localObject1 = paramRecyclerView;
        ((f)localObject2).b(paramd, (LinearLayoutManager)localObject1, paramw, paramString);
        AppMethodBeat.o(351861);
        return;
        paramd = paramRecyclerView.getAdapter();
        break;
        label2209:
        paramd = null;
        break label2114;
        label2215:
        paramd = (WxRecyclerAdapter)paramd.get();
        break label2134;
        label2228:
        break label2139;
        label2231:
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        break label2145;
        label2239:
        paramRecyclerView = null;
        break label2157;
        label2244:
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView.get();
        continue;
        label2255:
        if (paramd == d.Dng)
        {
          if (s.p(paramString, "12"))
          {
            ((f)localObject2).etd();
            AppMethodBeat.o(351861);
            return;
          }
          if (s.p(paramString, q.n.Dtv.scene))
          {
            ((f)localObject2).eta();
            AppMethodBeat.o(351861);
            return;
          }
          ((f)localObject2).esZ();
          AppMethodBeat.o(351861);
          return;
        }
        if (paramd == d.Dnl) {
          ((f)localObject2).Dnw.clear();
        }
      }
    }
    label2335:
    AppMethodBeat.o(351861);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(351962);
    s.u(paramn, "clickData");
    el localel = new el();
    Object localObject = j.Dob;
    j.a(localel, paramn.userName);
    localel.oM(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramn.feedId));
    localel.iEa = paramn.liveId;
    localel.oT(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramn.liveId));
    localel.ikE = paramn.DnM.beV;
    localel.oO(paramn.DnN);
    localel.iAO = paramn.Dpr;
    localel.iwV = 0L;
    localel.iEb = paramn.Dpt;
    localel.oP(paramn.mIS);
    localel.oU(paramn.Dpu);
    localel.oQ(com.tencent.mm.plugin.expt.hellhound.core.b.bys());
    localel.iEd = paramn.Dps;
    localel.oR(com.tencent.mm.plugin.expt.hellhound.core.b.dIX());
    localel.oX(paramn.DnS);
    localel.oW(kotlin.n.n.m(paramn.DnT, ",", ";", false));
    if (kotlin.n.n.U(paramn.DnN, "temp_", false)) {
      if (s.p(localel.iwO, "temp_2"))
      {
        paramn = j.Dob;
        localel.oS(j.Doc.Dqb);
        if (!s.p(localel.iwO, "61"))
        {
          paramn = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
          if (!s.p(b.a.dLz(), "123")) {}
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)) {
            break label737;
          }
        }
      }
    }
    label682:
    label727:
    label737:
    for (paramn = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA();; paramn = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)
    {
      localel.oV(paramn);
      localel.bMH();
      paramn = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report21053OnClick, struct=\nfeedId=").append(localel.iuI).append("\nliveId=").append(localel.iEe).append("\nuserName=").append(localel.irj).append("\nisPrivate=").append(localel.iwP).append("\nsessionID=").append(localel.iqO).append("\nactionTS=").append(localel.iwW).append("\naction=").append(localel.ikE).append("\ncommentScene=").append(localel.iwO).append("\nindex=").append(localel.iAO).append("\nenterStatus=").append(localel.iwV).append("\ncontextId=").append(localel.ipT).append("\nonlineNum=");
      ((StringBuilder)localObject).append(localel.iEd).append("\nclickTabContextId=").append(localel.ipU).append("\nclickSubTabContextId=").append(localel.ixg).append("\nchnl_extra=").append(localel.ixf).append("\nsessionBuffer=").append(localel.iqp).append("\nenterSessionId=").append(localel.iEg).append("\nenterIconType=").append(localel.iwY).append("\nsnsSessionID=").append(localel.iEh).append("\nshareType=").append(localel.iEb).append("\nshareUserName=").append(localel.iEc).append("\nsnsFeedId=").append(localel.iEf);
      Log.i(paramn, ((StringBuilder)localObject).toString());
      AppMethodBeat.o(351962);
      return;
      localel.oS(paramn.DnN);
      break;
      localObject = (CharSequence)localel.iwO;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label727;
        }
      }
      for (localObject = "0";; localObject = localel.iwO)
      {
        long l = paramn.feedId;
        s.s(localObject, "commentScene");
        localel.oS(aq(l, Long.parseLong((String)localObject)));
        break;
        i = 0;
        break label682;
      }
    }
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(351982);
    s.u(paramo, "enterData");
    el localel = new el();
    Object localObject = j.Dob;
    j.a(localel, paramo.userName);
    localel.oM(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramo.feedId));
    localel.iEa = paramo.liveId;
    localel.oT(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramo.liveId));
    localel.ikE = paramo.DnM.beV;
    localel.oO(paramo.DnN);
    localel.iAO = paramo.Dpr;
    localel.iwV = paramo.Dpv;
    localel.iEb = paramo.Dpt;
    localel.oP(paramo.mIS);
    localel.oU(paramo.Dpu);
    localel.oQ(com.tencent.mm.plugin.expt.hellhound.core.b.bys());
    localel.iEd = paramo.Dps;
    localel.oR(com.tencent.mm.plugin.expt.hellhound.core.b.dIX());
    localel.oX(paramo.DnS);
    if (kotlin.n.n.U(paramo.DnN, "temp_", false))
    {
      localel.oS(paramo.Dpx);
      if ((TextUtils.isEmpty((CharSequence)localel.iqp)) && (s.p(localel.iwO, "temp_2")))
      {
        localObject = j.Dob;
        localel.oS(j.Doc.Dqb);
      }
      if (TextUtils.isEmpty((CharSequence)localel.iqp)) {
        localel.oS(paramo.Dpx);
      }
      localel.iEg = paramo.enterTime;
      localel.oW(kotlin.n.n.m(paramo.DnT, ",", ";", false));
      localObject = j.Dob;
      localel.iwY = q.aB(localel.iwO, paramo.Dpw.type);
      if (!s.p(localel.iwO, "61"))
      {
        paramo = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
        if (!s.p(b.a.dLz(), "123")) {}
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)) {
          break label753;
        }
      }
    }
    label753:
    for (paramo = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA();; paramo = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)
    {
      localel.oV(paramo);
      localel.bMH();
      paramo = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report21053OnEnter, struct=\nfeedId=").append(localel.iuI).append("\nliveId=").append(localel.iEe).append("\nuserName=").append(localel.irj).append("\nisPrivate=").append(localel.iwP).append("\nsessionID=").append(localel.iqO).append("\nactionTS=").append(localel.iwW).append("\naction=").append(localel.ikE).append("\ncommentScene=").append(localel.iwO).append("\nindex=").append(localel.iAO).append("\nenterStatus=").append(localel.iwV).append("\ncontextId=").append(localel.ipT).append("\nonlineNum=");
      ((StringBuilder)localObject).append(localel.iEd).append("\nclickTabContextId=").append(localel.ipU).append("\nclickSubTabContextId=").append(localel.ixg).append("\nsessionBuffer=").append(localel.iqp).append("\nshareType=").append(localel.iEb).append("\nshareUserName=").append(localel.iEc).append("\nenterSessionId=").append(localel.iEg).append("\nenterIconType=").append(localel.iwY).append("\nsnsSessionID=").append(localel.iEh).append("\nsnsFeedId=").append(localel.iEf);
      Log.i(paramo, ((StringBuilder)localObject).toString());
      AppMethodBeat.o(351982);
      return;
      long l = paramo.feedId;
      localObject = localel.iwO;
      s.s(localObject, "struct.commentScene");
      localel.oS(aq(l, Long.parseLong((String)localObject)));
      break;
    }
  }
  
  public final void a(q.w paramw, int paramInt, String paramString, FeedData paramFeedData)
  {
    AppMethodBeat.i(351939);
    s.u(paramw, "actionType");
    s.u(paramString, "commentscene");
    if (paramFeedData == null)
    {
      AppMethodBeat.o(351939);
      return;
    }
    el localel = new el();
    j localj = j.Dob;
    j.a(localel, paramFeedData.getUserName());
    localel.oM(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramFeedData.getFeedId()));
    localel.iEa = paramFeedData.getLiveId();
    localel.oT(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramFeedData.getLiveId()));
    localel.ikE = paramw.beV;
    localel.oO(paramString);
    localel.iAO = paramInt;
    localel.iwV = 0L;
    localel.iEb = 0L;
    localel.oP(paramFeedData.getUserName());
    localel.oQ(com.tencent.mm.plugin.expt.hellhound.core.b.bys());
    localel.iEd = paramFeedData.getOnlineNum();
    localel.oR(com.tencent.mm.plugin.expt.hellhound.core.b.dIX());
    if (s.p(localel.iwO, "temp_2"))
    {
      paramw = j.Dob;
      localel.oS(j.Doc.Dqb);
      if (!s.p(localel.iwO, "61"))
      {
        paramw = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
        if (!s.p(b.a.dLz(), "123")) {}
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)) {
          break label607;
        }
      }
    }
    label607:
    for (paramw = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA();; paramw = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)
    {
      localel.oV(paramw);
      localel.bMH();
      paramw = this.TAG;
      paramString = new StringBuilder();
      paramString.append("report21053OnExposure, struct-2:\nuserName=").append(localel.irj).append("\nnickName=").append(paramFeedData.getNickName()).append("\nfeedID=").append(localel.iuI).append("\nliveIDStr=").append(localel.iEe).append("\nactionTS=").append(localel.iwW).append("\naction=").append(localel.ikE).append("\ncommentScene=").append(localel.iwO).append("\nindex=").append(localel.iAO).append("\nenterStatus=").append(localel.iwV).append("\nshareType=").append(localel.iEb).append("\nshareUserName=").append(localel.iEc).append("\ncontextId=");
      paramString.append(localel.ipT).append("\nonlineNum=").append(localel.iEd).append("\nclickTabContextId=").append(localel.ipU).append("\nisPrivate=").append(localel.iwP).append("\nsessionBuffer=").append(localel.iqp).append("\nsnsFeedId=").append(localel.iEf).append("\nenterSessionId=").append(localel.iEg).append("\nenterIconType=").append(localel.iwY).append("\nsnsSessionID=").append(localel.iEh).append("\nsessionID=").append(localel.iqO);
      Log.i(paramw, paramString.toString());
      AppMethodBeat.o(351939);
      return;
      localel.oS(kotlin.n.n.m(paramFeedData.getSessionBuffer(), ",", ";", false));
      break;
    }
  }
  
  public final void a(cc paramcc, int paramInt, q.w paramw, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(351877);
    s.u(paramcc, "feed");
    s.u(paramw, "actionType");
    s.u(paramString1, "commentscene");
    s.u(paramString2, "clickSubTabContextId");
    s.u(paramString3, "chnlExtra");
    long l1 = paramcc.bZA();
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1);
    s.s(str, "long2UnsignedString(feedIdL)");
    Object localObject1 = g.DnK;
    Object localObject2 = g.a.a(paramcc);
    if ((paramcc instanceof BaseFinderFeed)) {}
    for (localObject1 = ((BaseFinderFeed)paramcc).feedObject.getUserName();; localObject1 = "")
    {
      Object localObject3 = ((com.tencent.mm.vending.j.b)localObject2).get(0);
      s.s(localObject3, "tuple3.`$1`()");
      long l2 = ((Number)localObject3).longValue();
      localObject3 = ((com.tencent.mm.vending.j.c)localObject2).get(1);
      s.s(localObject3, "tuple3.`$2`()");
      int i = ((Number)localObject3).intValue();
      localObject3 = g.DnK;
      localObject3 = g.a.b(paramcc);
      g.b localb = g.b.DnU;
      localObject2 = ((com.tencent.mm.vending.j.d)localObject2).get(2);
      s.s(localObject2, "tuple3.`$3`()");
      b(new g(paramcc, (String)localObject1, paramInt, str, l1, l2, paramw, paramString1, i, (String)localObject3, localb, true, ((Boolean)localObject2).booleanValue(), 0, null, paramString2, paramString3, null, 155648));
      AppMethodBeat.o(351877);
      return;
    }
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(351919);
    s.u(paramg, "liveFeed");
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGs;
    el localel;
    switch (((String)localObject).hashCode())
    {
    default: 
      localel = new el();
      localObject = j.Dob;
      j.a(localel, paramg.userName);
      localel.oM(paramg.feedId);
      localel.iEa = paramg.liveId;
      localel.oT(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramg.liveId));
      localel.ikE = paramg.DnM.beV;
      localel.oO(paramg.DnN);
      localel.iAO = paramg.pos;
      localel.iwV = 0L;
      localel.iEb = paramg.DnR;
      if (localel.iqO != null)
      {
        localObject = localel.iqO;
        s.s(localObject, "struct.sessionID");
        if (kotlin.n.n.U((String)localObject, "101", false)) {
          localel.iEb = q.bp.DBO.type;
        }
      }
      else
      {
        label214:
        localel.oP(Util.nullAs(paramg.hgk, paramg.userName));
        localel.oQ(com.tencent.mm.plugin.expt.hellhound.core.b.bys());
        localel.iEd = paramg.onlineNum;
        localel.oR(com.tencent.mm.plugin.expt.hellhound.core.b.dIX());
        localel.oX(paramg.DnS);
        localel.oW(kotlin.n.n.m(paramg.DnT, ",", ";", false));
        if (!kotlin.n.n.U(paramg.DnN, "temp_", false)) {
          break label627;
        }
        if (!s.p(paramg.DnN, "temp_2")) {
          break label614;
        }
        localObject = j.Dob;
        localel.oS(j.Doc.Dqb);
        label331:
        if (!s.p(localel.iwO, "61"))
        {
          localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
          if (!s.p(b.a.dLz(), "123")) {
            break;
          }
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)) {
            break label665;
          }
        }
      }
      break;
    }
    label665:
    for (localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA();; localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGy)
    {
      localel.oV((String)localObject);
      if (!s.p(localel.iwO, "18")) {
        break label673;
      }
      Log.e(this.TAG, "filter, ConstantsFinder.FinderGetCommentScene.MMFinder_GetComment_Scene_Friend_Rec_Tab");
      AppMethodBeat.o(351919);
      return;
      if (!((String)localObject).equals("FinderFriendTabFragment")) {
        break;
      }
      do
      {
        if ((!s.p(paramg.DnN, q.n.Dtt.scene)) && (!s.p(paramg.DnN, "17"))) {
          break;
        }
        AppMethodBeat.o(351919);
        return;
        if (!((String)localObject).equals("FinderMachineTabFragment")) {
          break;
        }
        do
        {
          if ((!s.p(paramg.DnN, q.n.Dtt.scene)) && (!s.p(paramg.DnN, "17")) && (!s.p(paramg.DnN, q.n.DtA.scene)) && (!s.p(paramg.DnN, "18"))) {
            break;
          }
          AppMethodBeat.o(351919);
          return;
        } while (((String)localObject).equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment"));
        break;
      } while (((String)localObject).equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment"));
      break;
      localObject = localel.iqO;
      s.s(localObject, "struct.sessionID");
      if (!kotlin.n.n.U((String)localObject, "102", false)) {
        break label214;
      }
      localel.iEb = q.bp.DBP.type;
      break label214;
      label614:
      localel.oS(paramg.DnN);
      break label331;
      label627:
      long l = paramg.DnL;
      localObject = localel.iwO;
      s.s(localObject, "struct.commentScene");
      localel.oS(aq(l, Long.parseLong((String)localObject)));
      break label331;
    }
    label673:
    localel.bMH();
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report21053OnExposure, struct:\nuserName=").append(localel.irj).append("\nnickName=").append(paramg.nickName).append("\nfeedID=").append(localel.iuI).append("\nliveIDStr=").append(localel.iEe).append("\nactionTS=").append(localel.iwW).append("\naction=").append(localel.ikE).append("\ncommentScene=").append(localel.iwO).append("\nindex=").append(localel.iAO).append("\nenterStatus=").append(localel.iwV).append("\nshareType=").append(localel.iEb).append("\nshareUserName=").append(localel.iEc).append("\ncontextId=");
    localStringBuilder.append(localel.ipT).append("\nonlineNum=").append(localel.iEd).append("\nclickTabContextId=").append(localel.ipU).append("\nclickSubTabContextId=").append(localel.ixg).append("\nchnl_extra=").append(localel.ixf).append("\nisPrivate=").append(localel.iwP).append("\nsessionBuffer=").append(localel.iqp).append("\nsnsFeedId=").append(localel.iEf).append("\nenterSessionId=").append(localel.iEg).append("\nenterIconType=").append(localel.iwY).append("\nsnsSessionID=").append(localel.iEh).append("\nsessionID=").append(localel.iqO);
    Log.i((String)localObject, localStringBuilder.toString());
    AppMethodBeat.o(351919);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/report/Audience21053Report$mExposureCallback$1", "Lcom/tencent/mm/plugin/finder/live/report/IFeedEventCallback;", "onAppear", "", "liveFeed", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "fromSingleFlow", "", "feed", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveItem;", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveMixSearchItem;", "onDisappear", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements p
  {
    a(a parama) {}
    
    public final void a(g paramg, boolean paramBoolean)
    {
      int j = 1;
      AppMethodBeat.i(351799);
      s.u(paramg, "liveFeed");
      Object localObject;
      if ((paramg.AOm instanceof BaseFinderFeed))
      {
        localObject = aw.Gjk;
        localObject = paramg.AOm;
        if (localObject == null)
        {
          paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(351799);
          throw paramg;
        }
        if (!aw.s((BaseFinderFeed)localObject)) {}
      }
      for (int i = 1;; i = 0)
      {
        if ((paramg.AOm instanceof ac)) {
          paramg.a(q.w.Dxa);
        }
        if ((paramg.DnQ) || (i != 0) || (paramg.DnO == g.b.DnV) || (paramg.DnP)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (paramBoolean) && ((paramg.AOm instanceof BaseFinderFeed)))
          {
            localObject = paramg.AOm;
            if (localObject == null)
            {
              paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
              AppMethodBeat.o(351799);
              throw paramg;
              i = 0;
            }
            else
            {
              localObject = ((BaseFinderFeed)localObject).contact;
              if ((localObject != null) && (((m)localObject).field_liveStatus == 1))
              {
                i = j;
                paramg.a(q.w.DwQ);
              }
            }
          }
        }
        for (;;)
        {
          if (i != 0) {
            this.Dna.b(paramg);
          }
          AppMethodBeat.o(351799);
          return;
          i = 0;
          break;
        }
      }
    }
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(351821);
      s.u(paramh, "feed");
      Object localObject1;
      el localel;
      Object localObject2;
      if (paramh.DnZ)
      {
        localObject1 = this.Dna;
        s.u(paramh, "feed");
        localel = new el();
        localObject2 = j.Dob;
        j.a(localel, paramh.DnY.contact.getUsername());
        localel.oM(paramh.feedId);
        localel.iEa = 0L;
        localel.oT("0");
        localel.ikE = paramh.DnM.beV;
        localel.oO(paramh.DnN);
        localel.iAO = paramh.pos;
        localel.iwV = 0L;
        localel.iEb = 0L;
        localel.oP("");
        localel.oQ(com.tencent.mm.plugin.expt.hellhound.core.b.bys());
        localel.iEd = -1L;
        localel.oR(com.tencent.mm.plugin.expt.hellhound.core.b.dIX());
        if (!kotlin.n.n.U(paramh.DnN, "temp_", false)) {
          break label473;
        }
        if (!s.p(localel.iwO, "temp_2")) {
          break label461;
        }
        localObject2 = j.Dob;
        localel.oS(j.Doc.Dqb);
      }
      for (;;)
      {
        localel.bMH();
        localObject1 = ((a)localObject1).TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report21053OnExposure, item, struct:\nnickName=").append(paramh.nickName).append("\nuserName=").append(localel.irj).append("\nfeedID=").append(localel.iuI).append("\nliveIDStr=").append(localel.iEe).append("\nactionTS=").append(localel.iwW).append("\naction=").append(localel.ikE).append("\ncommentScene=").append(localel.iwO).append("\nindex=").append(localel.iAO).append("\nenterStatus=").append(localel.iwV).append("\nshareType=").append(localel.iEb).append("\nshareUserName=").append(localel.iEc).append("\ncontextId=");
        ((StringBuilder)localObject2).append(localel.ipT).append("\nonlineNum=").append(localel.iEd).append("\nclickTabContextId=").append(localel.ipU).append("\nisPrivate=").append(localel.iwP).append("\nsessionBuffer=").append(localel.iqp).append("\nsnsFeedId=").append(localel.iEf).append("\nsessionID=").append(localel.iqO);
        Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
        AppMethodBeat.o(351821);
        return;
        label461:
        localel.oS(paramh.DnN);
        continue;
        label473:
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(paramh.feedId)) {
          localel.oS(a.aq(Util.getLong(paramh.feedId, -1L), Long.parseLong(paramh.DnN)));
        } else {
          localel.oS(paramh.DnN);
        }
      }
    }
    
    public final void a(i parami)
    {
      AppMethodBeat.i(351840);
      s.u(parami, "feed");
      a locala;
      el localel;
      Object localObject1;
      if (parami.DnZ)
      {
        locala = this.Dna;
        s.u(parami, "feed");
        localel = new el();
        localObject1 = j.Dob;
        localObject1 = parami.Doa.contact;
        if (localObject1 != null) {
          break label511;
        }
        localObject1 = "";
        j.a(localel, (String)localObject1);
        localel.oM(parami.feedId);
        localel.iEa = 0L;
        localel.oT("0");
        localel.ikE = parami.DnM.beV;
        localel.oO(parami.DnN);
        localel.iAO = parami.pos;
        localel.iwV = 0L;
        localel.iEb = 0L;
        localel.oP("");
        localel.oQ(com.tencent.mm.plugin.expt.hellhound.core.b.bys());
        localel.iEd = -1L;
        localel.oR(com.tencent.mm.plugin.expt.hellhound.core.b.dIX());
        if (!kotlin.n.n.U(parami.DnN, "temp_", false)) {
          break label547;
        }
        if (!s.p(localel.iwO, "temp_2")) {
          break label534;
        }
        localObject1 = j.Dob;
        localel.oS(j.Doc.Dqb);
      }
      for (;;)
      {
        localel.bMH();
        localObject1 = locala.TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report21053OnExposure, mixsearch, struct:\nnickName=").append(parami.nickName).append("\nuserName=").append(localel.irj).append("\nfeedID=").append(localel.iuI).append("\nliveIDStr=").append(localel.iEe).append("\nactionTS=").append(localel.iwW).append("\naction=").append(localel.ikE).append("\ncommentScene=").append(localel.iwO).append("\nindex=").append(localel.iAO).append("\nenterStatus=").append(localel.iwV).append("\nshareType=").append(localel.iEb).append("\nshareUserName=").append(localel.iEc).append("\ncontextId=");
        ((StringBuilder)localObject2).append(localel.ipT).append("\nonlineNum=").append(localel.iEd).append("\nclickTabContextId=").append(localel.ipU).append("\nisPrivate=").append(localel.iwP).append("\nsessionBuffer=").append(localel.iqp).append("\nsnsFeedId=").append(localel.iEf).append("\nsessionID=").append(localel.iqO);
        Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
        AppMethodBeat.o(351840);
        return;
        label511:
        localObject2 = ((FinderContact)localObject1).username;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
        label534:
        localel.oS(parami.DnN);
        continue;
        label547:
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(parami.feedId))
        {
          long l = Util.getLong(parami.feedId, -1L);
          localObject1 = localel.iwO;
          s.s(localObject1, "struct.commentScene");
          localel.oS(a.aq(l, Long.parseLong((String)localObject1)));
        }
        else
        {
          localel.oS(parami.DnN);
        }
      }
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(351826);
      s.u(paramh, "feed");
      AppMethodBeat.o(351826);
    }
    
    public final void b(i parami)
    {
      AppMethodBeat.i(351846);
      s.u(parami, "feed");
      AppMethodBeat.o(351846);
    }
    
    public final void c(g paramg)
    {
      AppMethodBeat.i(351807);
      s.u(paramg, "liveFeed");
      AppMethodBeat.o(351807);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.a
 * JD-Core Version:    0.7.0.1
 */