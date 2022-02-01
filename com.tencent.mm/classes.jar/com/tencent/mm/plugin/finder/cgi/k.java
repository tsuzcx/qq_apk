package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamRefreshPreload;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamRefreshPreload.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "", "tabType", "", "pullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isPreload", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "modifyReason", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$ModifyResponseReason;", "streamCgi", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1;", "buildBaseRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "buildPartialExposeRequest", "buildRedDotRequest", "buildResponse", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "buildStatsRequest", "createFinderStreamResponseEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "it", "mergeResp", "streamResponse", "historyResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "onCgiBack", "errType", "errCode", "errMsg", "", "resp", "run", "showErrorToast", "tip", "Callback", "Companion", "FinderStreamHistoryCgi", "FinderStreamResponseEx", "ModifyResponseReason", "plugin-finder_release"})
public final class k
{
  public static final b qXi;
  private final anm contextObj;
  private final int diw;
  private boolean jSK;
  private final com.tencent.mm.bw.b lastBuffer;
  private final int pullType;
  private k.a qXe;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> qXf;
  private final e qXg;
  private final k.h qXh;
  
  static
  {
    AppMethodBeat.i(201126);
    qXi = new b((byte)0);
    AppMethodBeat.o(201126);
  }
  
  public k(int paramInt1, int paramInt2, com.tencent.mm.bw.b paramb, anm paramanm)
  {
    AppMethodBeat.i(201125);
    this.diw = paramInt1;
    this.pullType = paramInt2;
    this.lastBuffer = paramb;
    this.contextObj = paramanm;
    this.qXg = new e();
    this.qXh = new k.h(this);
    AppMethodBeat.o(201125);
  }
  
  private static d a(aoe paramaoe)
  {
    AppMethodBeat.i(201124);
    d locald = new d();
    locald.rmq = paramaoe.rmq;
    locald.rmp = paramaoe.rmp;
    locald.object.addAll((Collection)paramaoe.object);
    locald.EHl.addAll((Collection)paramaoe.EHl);
    locald.rmr = paramaoe.rmr;
    locald.EHg = paramaoe.EHg;
    locald.EHh = paramaoe.EHh;
    locald.rmt = paramaoe.rmt;
    locald.EHk = paramaoe.EHk;
    locald.EHi = paramaoe.EHi;
    locald.EHn = paramaoe.EHn;
    locald.EHj = paramaoe.EHj;
    locald.EHm = paramaoe.EHm;
    locald.lastBuffer = paramaoe.lastBuffer;
    locald.qXm = paramaoe.object.size();
    locald.EHo = paramaoe.EHo;
    locald.qYj = paramaoe.qYj;
    locald.EHp = paramaoe.EHp;
    AppMethodBeat.o(201124);
    return locald;
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(201121);
    Object localObject1 = p.qXG;
    localObject1 = paramd.object;
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = (List)localObject1;; localObject1 = (List)new LinkedList())
    {
      ac.i("Finder.FinderStream", p.dw((List)localObject1));
      localObject1 = com.tencent.mm.plugin.finder.preload.a.rvk;
      localObject1 = paramd.rmt;
      localObject2 = paramd.object;
      d.g.b.k.g(localObject2, "resp.`object`");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FinderObject localFinderObject = (FinderObject)((Iterator)localObject3).next();
        Object localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        localObject4 = FinderItem.rDA;
        d.g.b.k.g(localFinderObject, "it");
        ((Collection)localObject2).add(com.tencent.mm.plugin.finder.storage.logic.b.a.i(FinderItem.a.a(localFinderObject, 0)));
      }
    }
    com.tencent.mm.plugin.finder.preload.a.a((anb)localObject1, (List)localObject2);
    this.qXg.a(paramd);
    localObject1 = this.qXe;
    if (localObject1 == null) {
      d.g.b.k.aVY("callback");
    }
    ((k.a)localObject1).a(paramInt1, paramInt2, paramString, paramd);
    AppMethodBeat.o(201121);
  }
  
  public final void a(com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> paramc, k.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(201122);
    d.g.b.k.h(parama, "callback");
    this.jSK = paramBoolean;
    this.qXe = parama;
    Object localObject = paramc;
    if (paramc == null) {
      localObject = new com.tencent.mm.vending.e.c();
    }
    this.qXf = ((com.tencent.mm.vending.e.c)localObject);
    if (parama.csh())
    {
      paramc = new c(null, this.lastBuffer).aBB();
      parama = this.qXf;
      if (parama == null) {
        d.g.b.k.aVY("lifeCycleKeeper");
      }
      paramc.a((com.tencent.mm.vending.e.b)parama);
      AppMethodBeat.o(201122);
      return;
    }
    paramc = com.tencent.mm.ui.component.a.IrY;
    paramc = ((FinderStreamRefreshPreload)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderStreamRefreshPreload.class)).EY(this.diw);
    if ((paramBoolean) || ((this.pullType != 1) && (this.pullType != 0)))
    {
      parama.a(this.qXh.qXr);
      paramc = this.qXh.aBB();
      parama = this.qXf;
      if (parama == null) {
        d.g.b.k.aVY("lifeCycleKeeper");
      }
      paramc.a((com.tencent.mm.vending.e.b)parama);
      AppMethodBeat.o(201122);
      return;
    }
    paramc = paramc.cFS();
    if (paramc != null)
    {
      parama = MediaPreloadCore.rvo;
      if (MediaPreloadCore.cwJ()) {
        com.tencent.mm.ac.c.g((d.g.a.a)new k.f(this));
      }
      ac.i("Finder.FinderStream", "[run] use preload cache. tabType=" + this.diw + ' ');
      a(0, 0, null, paramc);
      AppMethodBeat.o(201122);
      return;
    }
    paramc = (k)this;
    parama.a(paramc.qXh.qXr);
    parama = paramc.qXh.aBB();
    paramc = paramc.qXf;
    if (paramc == null) {
      d.g.b.k.aVY("lifeCycleKeeper");
    }
    parama.a((com.tencent.mm.vending.e.b)paramc);
    AppMethodBeat.o(201122);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamHistoryCgi;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;Lcom/tencent/mm/protobuf/ByteString;)V", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public final class c
    extends r<aku>
  {
    private aoe qXj;
    
    public c(com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(201115);
      this.qXj = paramb;
      paramb = new com.tencent.mm.ak.b.a();
      akt localakt = new akt();
      localakt.EEI = u.axE();
      localakt.diw = k.c(k.this);
      Object localObject;
      localakt.EEJ = localObject;
      ac.i("Finder.FinderStream", "[request#historyCgi] isPreload=" + k.b(k.this) + " tabType=" + k.c(k.this) + " pullType=" + k.d(k.this));
      this$1 = q.qXH;
      localakt.EDL = q.a(this.contextObj);
      paramb.c((com.tencent.mm.bw.a)localakt);
      this$1 = new aku();
      k.this.setBaseResponse(new BaseResponse());
      k.this.getBaseResponse().ErrMsg = new crm();
      paramb.d((com.tencent.mm.bw.a)k.this);
      paramb.Am("/cgi-bin/micromsg-bin/findergethistory");
      paramb.op(3814);
      c(paramb.aAz());
      AppMethodBeat.o(201115);
    }
    
    public final boolean csf()
    {
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "()V", "continue_flag", "", "getContinue_flag", "()I", "setContinue_flag", "(I)V", "historySize", "getHistorySize", "setHistorySize", "isFetchHistory", "", "()Z", "setFetchHistory", "(Z)V", "streamSize", "getStreamSize", "setStreamSize", "plugin-finder_release"})
  public static final class d
    extends aoe
  {
    public int qXl = 1;
    public int qXm;
    public int qXn = -1;
    public boolean qXo;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$ModifyResponseReason;", "", "()V", "redDotFeedId", "", "getRedDotFeedId", "()J", "setRedDotFeedId", "(J)V", "redDotUsername", "", "getRedDotUsername", "()Ljava/lang/String;", "setRedDotUsername", "(Ljava/lang/String;)V", "modify", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "plugin-finder_release"})
  public static final class e
  {
    long qXp;
    String qXq = "";
    
    public final void a(k.d paramd)
    {
      int j = 0;
      AppMethodBeat.i(201116);
      d.g.b.k.h(paramd, "resp");
      if ((this.qXp != 0L) && (!bs.isNullOrNil(this.qXq)))
      {
        paramd = paramd.object;
        Object localObject;
        int i;
        if (paramd != null)
        {
          localObject = ((Iterable)paramd).iterator();
          if (((Iterator)localObject).hasNext())
          {
            paramd = ((Iterator)localObject).next();
            if (((FinderObject)paramd).id == this.qXp)
            {
              i = 1;
              label87:
              if (i == 0) {
                break label360;
              }
              label91:
              paramd = (FinderObject)paramd;
              label96:
              if (paramd == null) {
                break label408;
              }
              localObject = paramd.likeList;
              d.g.b.k.g(localObject, "likeList");
              localObject = ((List)localObject).iterator();
              i = 0;
              label127:
              if (!((Iterator)localObject).hasNext()) {
                break label379;
              }
              if (!d.g.b.k.g(((FinderCommentInfo)((Iterator)localObject).next()).username, this.qXq)) {
                break label372;
              }
              label160:
              if ((i >= 2) && (paramd.likeList.size() >= 3))
              {
                localObject = paramd.likeList;
                d.g.b.k.g(localObject, "likeList");
                localObject = ((List)localObject).iterator();
                i = 0;
                label203:
                if (!((Iterator)localObject).hasNext()) {
                  break label391;
                }
                if (!d.g.b.k.g(((FinderCommentInfo)((Iterator)localObject).next()).username, u.axw())) {
                  break label384;
                }
                label235:
                if (i > 1)
                {
                  localObject = (FinderCommentInfo)paramd.likeList.remove(i);
                  paramd.likeList.add(1, localObject);
                }
                localObject = paramd.likeList;
                d.g.b.k.g(localObject, "likeList");
                localObject = ((List)localObject).iterator();
                i = j;
                label290:
                if (!((Iterator)localObject).hasNext()) {
                  break label403;
                }
                if (!d.g.b.k.g(((FinderCommentInfo)((Iterator)localObject).next()).username, this.qXq)) {
                  break label396;
                }
              }
            }
          }
        }
        for (;;)
        {
          if (i > 2)
          {
            localObject = (FinderCommentInfo)paramd.likeList.remove(i);
            paramd.likeList.add(2, localObject);
          }
          AppMethodBeat.o(201116);
          return;
          i = 0;
          break label87;
          label360:
          break;
          paramd = null;
          break label91;
          paramd = null;
          break label96;
          label372:
          i += 1;
          break label127;
          label379:
          i = -1;
          break label160;
          label384:
          i += 1;
          break label203;
          label391:
          i = -1;
          break label235;
          label396:
          i += 1;
          break label290;
          label403:
          i = -1;
        }
      }
      label408:
      AppMethodBeat.o(201116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k
 * JD-Core Version:    0.7.0.1
 */