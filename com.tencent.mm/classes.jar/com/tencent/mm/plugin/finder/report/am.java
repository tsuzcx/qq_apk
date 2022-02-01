package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.du;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.b.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMFragmentActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "hasRecordFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedRecord;", "Lkotlin/collections/HashMap;", "lastVisibleFeedMap", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "needMarkRead", "onEventHappen", "", "onExit", "invokeSource", "", "onInvisible", "onRelease", "visibleItemToInvisible", "Lcom/tencent/mm/protocal/protobuf/Stats;", "record", "fastSlip", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class am
  extends m
{
  public static final a FtJ;
  private HashMap<Long, an> Fsu;
  private HashMap<Long, an> FtK;
  
  static
  {
    AppMethodBeat.i(331345);
    FtJ = new a((byte)0);
    AppMethodBeat.o(331345);
  }
  
  public am(MMFragmentActivity paramMMFragmentActivity, bui parambui)
  {
    super(paramMMFragmentActivity, parambui);
    AppMethodBeat.i(331284);
    this.FtK = new HashMap();
    this.Fsu = new HashMap();
    AppMethodBeat.o(331284);
  }
  
  private final fhp a(an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(331315);
    if (paraman.endTime == 0L) {
      paraman.endTime = cn.bDw();
    }
    Object localObject1 = an.FtN;
    s.u(paraman, "record");
    fhp localfhp = new fhp();
    Object localObject3 = new BitSet(64);
    localfhp.hKN = paraman.feedId;
    localObject1 = paraman.ANj;
    label134:
    float f;
    label170:
    long l;
    label276:
    Object localObject2;
    label317:
    Object localObject4;
    label363:
    label380:
    JSONObject localJSONObject;
    if (localObject1 == null)
    {
      localObject1 = "";
      localfhp.objectNonceId = ((String)localObject1);
      localfhp.abIh = new ni();
      localfhp.abIi = new fvu();
      localfhp.abIj = new dzj();
      localObject1 = paraman.ANj;
      if (localObject1 != null) {
        break label1227;
      }
      localObject1 = "";
      localfhp.finderUsername = ((String)localObject1);
      f = (float)(paraman.endTime - paraman.startTime) / 1000.0F;
      if (f >= 0.5F) {
        break label1250;
      }
      ((BitSet)localObject3).set(21, true);
      l = localObject3.toLongArray()[0];
      localObject1 = localfhp.abIh;
      if (localObject1 != null) {
        ((ni)localObject1).YPj = l;
      }
      localObject1 = localfhp.abIi;
      if (localObject1 != null) {
        ((fvu)localObject1).QXQ = ((int)f);
      }
      localObject1 = localfhp.abIj;
      if (localObject1 != null) {
        ((dzj)localObject1).abeh = ((int)f);
      }
      localObject1 = localfhp.abIj;
      if (localObject1 != null) {
        ((dzj)localObject1).abep = paraman.FsD;
      }
      localObject1 = localfhp.abIj;
      if (localObject1 != null)
      {
        if (!paramBoolean) {
          break label1428;
        }
        i = 0;
        ((dzj)localObject1).abeo = i;
      }
      localObject2 = paraman.ANj;
      if (localObject2 != null)
      {
        localObject1 = localfhp.abIj;
        if (localObject1 != null)
        {
          if (((FinderItem)localObject2).getLikeFlag() == 0) {
            break label1434;
          }
          i = 1;
          ((dzj)localObject1).abel = i;
        }
        localObject3 = localfhp.abIj;
        if (localObject3 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
          localObject4 = ((FinderItem)localObject2).getUserName();
          localObject1 = ((FinderItem)localObject2).getBizInfo();
          if (localObject1 != null) {
            break label1440;
          }
          localObject1 = null;
          if (!d.a.a((String)localObject4, (String)localObject1, false, false, 12)) {
            break label1450;
          }
          i = 1;
          ((dzj)localObject3).FUX = i;
        }
        localObject1 = localfhp.abIj;
        if (localObject1 != null)
        {
          if (((FinderItem)localObject2).getFavFlag() != 1) {
            break label1456;
          }
          i = 1;
          label411:
          ((dzj)localObject1).aben = i;
        }
      }
      localObject4 = this.Auc;
      s.u(localObject4, "contextObj");
      s.u(paraman, "record");
      localObject3 = new du();
      localJSONObject = new JSONObject();
      ((du)localObject3).iqr = ((bui)localObject4).AJo;
      ((du)localObject3).iqk = ((du)localObject3).F("Feedid", com.tencent.mm.ae.d.hF(paraman.feedId), true);
      ((du)localObject3).ixm = ((du)localObject3).F("Sessionid", ((bui)localObject4).sessionId, true);
      ((du)localObject3).iwI = ((du)localObject3).F("Contextid", ((bui)localObject4).zIO, true);
      ((du)localObject3).ijl = ((du)localObject3).F("ClickTabContextid", ((bui)localObject4).zIB, true);
      ((du)localObject3).iAR = paraman.startTime;
      ((du)localObject3).iAS = paraman.endTime;
      ((du)localObject3).iAQ = (paraman.endTime - paraman.startTime);
      FinderItem localFinderItem = paraman.ANj;
      if (localFinderItem != null)
      {
        ((du)localObject3).iAT = localFinderItem.getLikeCount();
        localObject1 = ((bui)localObject4).GSV;
        if (localObject1 != null) {
          break label1462;
        }
        localObject1 = "";
        label613:
        ((du)localObject3).iAG = ((du)localObject3).F("PageTag", (String)localObject1, true);
        ((du)localObject3).iAB = localFinderItem.getMediaType();
        if (localFinderItem.getFriendLikeCount() > 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eYF().bmg()).intValue() == 1) {
            localJSONObject.put("friends_like_total", localFinderItem.getFriendLikeCount());
          }
        }
      }
      ((du)localObject3).iAO = paraman.FsD;
      localObject1 = com.tencent.mm.plugin.findersdk.b.c.HcH;
      ((du)localObject3).iAE = c.a.VA(((bui)localObject4).AJo);
      localObject1 = an.FtN;
      ((du)localObject3).iAP = ((du)localObject3).F("IndexInfo", n.bV(an.a.a(paraman), ",", ";"), true);
      localObject1 = z.FrZ;
      ((du)localObject3).iqp = ((du)localObject3).F("SessionBuffer", z.p(paraman.feedId, ((bui)localObject4).AJo), true);
      if (((bui)localObject4).AJo == 15)
      {
        localObject1 = paraman.ANj;
        if (localObject1 != null) {
          break label1491;
        }
        localObject1 = null;
        label798:
        if (localObject1 == null) {}
      }
      switch (paraman.ANj.getFeedObject().recommendReasonType)
      {
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        l = 0L;
        label883:
        ((du)localObject3).iAJ = l;
        localObject2 = paraman.ANj.getFeedObject().recommendReason;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((du)localObject3).iAK = ((du)localObject3).F("RecommendWording", (String)localObject1, false);
        localObject1 = paraman.ANj;
        if (localObject1 != null)
        {
          localObject1 = ((FinderItem)localObject1).getFinderObject();
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 != null)
            {
              localObject1 = ((FinderObjectDesc)localObject1).event;
              if (localObject1 != null)
              {
                ((du)localObject3).izp = ((du)localObject3).F("ActivityID", com.tencent.mm.ae.d.hF(((brg)localObject1).ocD), true);
                ((du)localObject3).iAL = ((bui)localObject4).hJx;
                localObject2 = ((bui)localObject4).GSS;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                ((du)localObject3).iAM = ((du)localObject3).F("ActivityInfo", (String)localObject1, true);
              }
            }
          }
        }
        localObject1 = paraman.ANj;
        if (localObject1 == null)
        {
          localObject1 = null;
          label1061:
          if (localObject1 == null)
          {
            localObject1 = paraman.ANj;
            if (localObject1 != null) {
              break label1707;
            }
            l = 0L;
            label1080:
            ((du)localObject3).nI(com.tencent.mm.ae.d.hF(l));
            paraman = paraman.ANj;
            if ((paraman == null) || (paraman.getMediaType() != 4)) {
              break label1735;
            }
          }
        }
        break;
      }
    }
    label1428:
    label1434:
    label1440:
    label1450:
    label1456:
    label1462:
    label1735:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((du)localObject3).izn = 1L;
      }
      ((du)localObject3).iAa = ((du)localObject3).F("jump_id", ((bui)localObject4).DUN, true);
      paraman = localJSONObject.toString();
      s.s(paraman, "kvJson.toString()");
      ((du)localObject3).iAN = ((du)localObject3).F("udf_kv", n.bV(paraman, ",", ";"), true);
      ((du)localObject3).gNE();
      paraman = z.FrZ;
      z.a((com.tencent.mm.plugin.report.a)localObject3);
      AppMethodBeat.o(331315);
      return localfhp;
      localObject2 = ((FinderItem)localObject1).getObjectNonceId();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label1227:
      localObject2 = ((FinderItem)localObject1).field_username;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label134;
      }
      localObject1 = "";
      break label134;
      label1250:
      if (f < 1.0F)
      {
        ((BitSet)localObject3).set(22, true);
        break label170;
      }
      if (f < 2.0F)
      {
        ((BitSet)localObject3).set(23, true);
        break label170;
      }
      if (f < 3.0F)
      {
        ((BitSet)localObject3).set(24, true);
        break label170;
      }
      if (f < 5.0F)
      {
        ((BitSet)localObject3).set(25, true);
        break label170;
      }
      if (f < 10.0F)
      {
        ((BitSet)localObject3).set(26, true);
        break label170;
      }
      if (f < 20.0F)
      {
        ((BitSet)localObject3).set(27, true);
        break label170;
      }
      if (f < 30.0F)
      {
        ((BitSet)localObject3).set(28, true);
        break label170;
      }
      if (f < 40.0F)
      {
        ((BitSet)localObject3).set(29, true);
        break label170;
      }
      if (f < 50.0F)
      {
        ((BitSet)localObject3).set(30, true);
        break label170;
      }
      ((BitSet)localObject3).set(31, true);
      break label170;
      i = 1;
      break label276;
      i = 0;
      break label317;
      localObject1 = ((pu)localObject1).ADE;
      break label363;
      i = 0;
      break label380;
      i = 0;
      break label411;
      localObject2 = n.bV((String)localObject1, ",", ";");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label613;
      }
      localObject1 = "";
      break label613;
      label1491:
      localObject1 = ((FinderItem)localObject1).getFeedObject();
      break label798;
      l = 1L;
      break label883;
      l = 2L;
      break label883;
      l = 3L;
      break label883;
      l = 4L;
      break label883;
      l = 5L;
      break label883;
      l = 6L;
      break label883;
      localObject1 = ((FinderItem)localObject1).getFinderObject();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label1061;
      }
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label1061;
      }
      localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label1061;
      }
      ((du)localObject3).nI(((bqz)localObject1).groupId);
      if (((bqz)localObject1).musicInfo != null)
      {
        localObject1 = ((bqz)localObject1).musicInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          label1635:
          localObject1 = (CharSequence)localObject1;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label1695;
          }
          i = 1;
          label1660:
          if (i != 0) {
            break label1701;
          }
        }
      }
      for (l = 2L;; l = 1L)
      {
        ((du)localObject3).izn = l;
        localObject1 = ah.aiuX;
        break;
        localObject1 = ((bqj)localObject1).HsD;
        break label1635;
        i = 0;
        break label1660;
      }
      localObject1 = ((FinderItem)localObject1).getFinderObject();
      if (localObject1 == null)
      {
        l = 0L;
        break label1080;
      }
      l = ((FinderObject)localObject1).id;
      break label1080;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(331378);
    s.u(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.m))
    {
      switch (this.Auc.AJo)
      {
      }
      Object localObject4;
      for (boolean bool = false;; bool = true)
      {
        Log.d("Finder.FinderTwoFeedFlowReporter", "needMarkRead:" + bool + " commentScene:" + this.Auc.AJo + " fromCommentScene:" + this.Auc.hLK);
        if (bool)
        {
          localObject1 = ay.EDk;
          ay.b(((com.tencent.mm.plugin.finder.event.base.m)paramb).AOA, this.Auc);
        }
        if ((((com.tencent.mm.plugin.finder.event.base.m)paramb).vIj == ((com.tencent.mm.plugin.finder.event.base.m)paramb).AOr) && (((com.tencent.mm.plugin.finder.event.base.m)paramb).AOt == ((com.tencent.mm.plugin.finder.event.base.m)paramb).vIk)) {
          break label849;
        }
        localObject1 = new HashSet();
        localObject2 = new HashSet();
        ((HashSet)localObject1).addAll((Collection)this.Fsu.keySet());
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.m)paramb).AOB;
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (g)((Iterator)localObject3).next();
          ((HashSet)localObject1).add(Long.valueOf(((g)localObject4).AOm.bZA()));
          ((HashSet)localObject2).add(Long.valueOf(((g)localObject4).AOm.bZA()));
        }
      }
      Object localObject3 = ((com.tencent.mm.plugin.finder.event.base.m)paramb).AOA;
      label417:
      long l1;
      long l2;
      if (localObject3 != null)
      {
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (!((HashSet)localObject1).contains(Long.valueOf(((g)localObject5).AOm.bZA()))) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label417;
            }
            ((Collection)localObject3).add(localObject5);
            break;
          }
        }
        localObject3 = ((Iterable)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (g)((Iterator)localObject3).next();
          l1 = ((g)localObject4).AOm.bZA();
          l2 = paramb.ANT;
          if ((((g)localObject4).AOm instanceof BaseFinderFeed)) {}
          for (localObject1 = ((BaseFinderFeed)((g)localObject4).AOm).feedObject;; localObject1 = null)
          {
            localObject1 = new an(l1, l2, (FinderItem)localObject1);
            ((an)localObject1).FsD = ((g)localObject4).AOn;
            ((an)localObject1).AOo = ((g)localObject4).AOo;
            a((an)localObject1, true);
            break;
          }
        }
      }
      Object localObject1 = ((Map)this.Fsu).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (!((HashSet)localObject2).contains(((Map.Entry)localObject3).getKey())) {
          a((an)((Map.Entry)localObject3).getValue(), false);
        }
      }
      Object localObject2 = new HashMap();
      localObject1 = ((com.tencent.mm.plugin.finder.event.base.m)paramb).AOB;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (g)((Iterator)localObject3).next();
          localObject1 = (an)this.Fsu.get(Long.valueOf(((g)localObject4).AOm.bZA()));
          if (localObject1 != null)
          {
            ((HashMap)localObject2).put(Long.valueOf(((g)localObject4).AOm.bZA()), localObject1);
          }
          else
          {
            l1 = ((g)localObject4).AOm.bZA();
            l2 = paramb.ANT;
            if ((((g)localObject4).AOm instanceof BaseFinderFeed)) {}
            for (localObject1 = ((BaseFinderFeed)((g)localObject4).AOm).feedObject;; localObject1 = null)
            {
              localObject1 = new an(l1, l2, (FinderItem)localObject1);
              ((an)localObject1).FsD = ((g)localObject4).AOn;
              ((an)localObject1).AOo = ((g)localObject4).AOo;
              ((HashMap)localObject2).put(Long.valueOf(((g)localObject4).AOm.bZA()), localObject1);
              break;
            }
          }
        }
      }
      this.Fsu = ((HashMap)localObject2);
    }
    label849:
    AppMethodBeat.o(331378);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(331360);
    s.u(paramc, "dispatcher");
    s.u(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.m))
    {
      AppMethodBeat.o(331360);
      return true;
    }
    AppMethodBeat.o(331360);
    return false;
  }
  
  protected void azF(String paramString)
  {
    AppMethodBeat.i(331355);
    s.u(paramString, "invokeSource");
    as.a locala = as.GSQ;
    com.tencent.mm.ae.d.e(as.foC(), (kotlin.g.a.a)new am.b(this, paramString));
    AppMethodBeat.o(331355);
  }
  
  public void onInvisible()
  {
    AppMethodBeat.i(331384);
    super.onInvisible();
    this.FtK.putAll((Map)this.Fsu);
    azF("onInvisible");
    AppMethodBeat.o(331384);
  }
  
  public void onRelease()
  {
    AppMethodBeat.i(331351);
    azF("onRelease");
    super.onRelease();
    AppMethodBeat.o(331351);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.am
 * JD-Core Version:    0.7.0.1
 */