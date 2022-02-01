package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ck;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.data.m;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "doGetFollowScene", "", "fakeTopicInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "", "Companion", "plugin-finder_release"})
public final class FinderFollowTopicListContract$FollowTopicPresenter
  implements i, com.tencent.mm.plugin.finder.presenter.base.a<FinderFollowTopicListContract.FollowTopicViewCallback>
{
  private static final String uWR = "topicFollowList.fp";
  public static final Companion uWS;
  boolean hasMore;
  public final ArrayList<com.tencent.mm.plugin.finder.model.bk> kgc;
  private boolean tQl;
  private long tQo;
  private com.tencent.mm.bw.b tsO;
  FinderFollowTopicListContract.FollowTopicViewCallback uWP;
  private final m uWQ;
  
  static
  {
    AppMethodBeat.i(249763);
    uWS = new Companion((byte)0);
    uWR = "topicFollowList.fp";
    AppMethodBeat.o(249763);
  }
  
  public FinderFollowTopicListContract$FollowTopicPresenter()
  {
    AppMethodBeat.i(249762);
    this.uWQ = new m(uWR);
    this.kgc = new ArrayList();
    this.hasMore = true;
    this.tQo = SystemClock.uptimeMillis();
    AppMethodBeat.o(249762);
  }
  
  public final void a(FinderFollowTopicListContract.FollowTopicViewCallback paramFollowTopicViewCallback)
  {
    AppMethodBeat.i(249757);
    p.h(paramFollowTopicViewCallback, "callback");
    this.uWP = paramFollowTopicViewCallback;
    g.azz().a(712, (i)this);
    g.azz().a(3844, (i)this);
    AppMethodBeat.o(249757);
  }
  
  public final void nO(boolean paramBoolean)
  {
    AppMethodBeat.i(249761);
    this.tQo = SystemClock.uptimeMillis();
    this.tQl = paramBoolean;
    Object localObject = this.tsO;
    String str = z.aUg();
    p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    localObject = new com.tencent.mm.plugin.finder.cgi.bk((com.tencent.mm.bw.b)localObject, str);
    g.azz().b((com.tencent.mm.ak.q)localObject);
    AppMethodBeat.o(249761);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(249759);
    g.azz().b(712, (i)this);
    g.azz().b(3844, (i)this);
    AppMethodBeat.o(249759);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    Object localObject1 = null;
    AppMethodBeat.i(249760);
    Object localObject2 = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramq != null)
    {
      paramString = Integer.valueOf(paramq.getType());
      Log.i("Finder.FollowTopicPresenter", paramString);
      if (paramq == null) {
        break label107;
      }
      paramString = Integer.valueOf(paramq.getType());
      label88:
      if (paramString != null) {
        break label112;
      }
    }
    for (;;)
    {
      label561:
      if (paramString == null)
      {
        AppMethodBeat.o(249760);
        return;
        paramString = null;
        break;
        label107:
        paramString = null;
        break label88;
        label112:
        if (paramString.intValue() == 712)
        {
          z.f localf = new z.f();
          localf.SYG = null;
          boolean bool;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            final z.a locala = new z.a();
            locala.SYB = false;
            if (paramq == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowTopicList");
              AppMethodBeat.o(249760);
              throw paramString;
            }
            localObject2 = ((com.tencent.mm.plugin.finder.cgi.bk)paramq).rr.aYJ();
            paramString = (String)localObject2;
            if (!(localObject2 instanceof ash)) {
              paramString = null;
            }
            paramString = (ash)paramString;
            if (paramString != null) {}
            for (paramString = paramString.LDs; (p.j(this.tsO, paramString) ^ true); paramString = null)
            {
              Log.i("Finder.FollowTopicPresenter", "not my buf, ignore!");
              AppMethodBeat.o(249760);
              return;
            }
            if (this.tsO == null)
            {
              locala.SYB = true;
              com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new kotlin.g.b.q(locala) {});
            }
            paramString = g.aAh();
            p.g(paramString, "MMKernel.storage()");
            paramString.azQ().set(ar.a.OlB, Integer.valueOf(((com.tencent.mm.plugin.finder.cgi.bk)paramq).cYv()));
            paramString = this.uWP;
            if (paramString == null) {
              p.btv("viewCallback");
            }
            paramString.JT(((com.tencent.mm.plugin.finder.cgi.bk)paramq).cYv());
            paramString = this.uWP;
            if (paramString == null) {
              p.btv("viewCallback");
            }
            paramString.dlT();
            paramString = ((com.tencent.mm.plugin.finder.cgi.bk)paramq).rr.aYK();
            if (paramString == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
              AppMethodBeat.o(249760);
              throw paramString;
            }
            if (((asi)paramString).tUC != 0)
            {
              bool = true;
              this.hasMore = bool;
              localObject2 = ((com.tencent.mm.plugin.finder.cgi.bk)paramq).rr.aYK();
              paramString = (String)localObject2;
              if (!(localObject2 instanceof asi)) {
                paramString = null;
              }
              localObject2 = (asi)paramString;
              paramString = localObject1;
              if (localObject2 != null) {
                paramString = ((asi)localObject2).LDs;
              }
              this.tsO = paramString;
              localf.SYG = ((Runnable)new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(249754);
                  Object localObject1 = this.uWT;
                  boolean bool1 = locala.SYB;
                  Object localObject2 = (List)((com.tencent.mm.plugin.finder.cgi.bk)paramq).cYu();
                  boolean bool2 = FinderFollowTopicListContract.FollowTopicPresenter.e(this.uWT);
                  p.h(localObject2, "dataList");
                  Log.i("Finder.FollowTopicPresenter", "firstPage " + bool1 + ", get follow contact " + ((List)localObject2).size());
                  int j = ((FinderFollowTopicListContract.FollowTopicPresenter)localObject1).kgc.size();
                  int i = ((List)localObject2).size();
                  if (bool1)
                  {
                    ((FinderFollowTopicListContract.FollowTopicPresenter)localObject1).kgc.clear();
                    i = -1;
                    j = -1;
                  }
                  ArrayList localArrayList = ((FinderFollowTopicListContract.FollowTopicPresenter)localObject1).kgc;
                  Object localObject3 = (Iterable)localObject2;
                  localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext()) {
                    ((Collection)localObject2).add(new com.tencent.mm.plugin.finder.model.bk((bds)((Iterator)localObject3).next()));
                  }
                  localArrayList.addAll((Collection)localObject2);
                  localObject1 = ((FinderFollowTopicListContract.FollowTopicPresenter)localObject1).uWP;
                  if (localObject1 == null) {
                    p.btv("viewCallback");
                  }
                  ((FinderFollowTopicListContract.FollowTopicViewCallback)localObject1).f(bool2, j, i);
                  AppMethodBeat.o(249754);
                }
              });
            }
          }
          else
          {
            l = SystemClock.uptimeMillis() - this.tQo;
            if (!this.tQl)
            {
              paramString = c.vCb;
              if (l < ((Number)c.dty().value()).longValue()) {
                break label561;
              }
            }
          }
          for (long l = 0L;; l = ((Number)c.dty().value()).longValue() - l)
          {
            com.tencent.mm.ac.d.a(l, (kotlin.g.a.a)new kotlin.g.b.q(localf) {});
            AppMethodBeat.o(249760);
            return;
            bool = false;
            break;
            paramString = c.vCb;
          }
        }
      }
    }
    if ((paramString.intValue() == 3844) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderTopicFollow");
        AppMethodBeat.o(249760);
        throw paramString;
      }
      paramString = (ck)paramq;
      paramInt1 = paramString.opType;
      paramq = ck.twr;
      if (paramInt1 == ck.cYj()) {
        j.c((List)this.kgc, (kotlin.g.a.b)new kotlin.g.b.q(paramString) {});
      }
      paramString = this.uWP;
      if (paramString == null) {
        p.btv("viewCallback");
      }
      FinderFollowTopicListContract.FollowTopicViewCallback.b(paramString);
      paramString = g.aAh();
      p.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.azQ().getInt(ar.a.OlB, 0);
      if (paramInt1 > 0)
      {
        paramString = g.aAh();
        p.g(paramString, "MMKernel.storage()");
        paramString.azQ().set(ar.a.OlB, Integer.valueOf(paramInt1 - 1));
        paramString = this.uWP;
        if (paramString == null) {
          p.btv("viewCallback");
        }
        paramString.JT(paramInt1 - 1);
        paramString = this.uWP;
        if (paramString == null) {
          p.btv("viewCallback");
        }
        paramString.dlT();
        AppMethodBeat.o(249760);
        return;
      }
      paramString = this.uWP;
      if (paramString == null) {
        p.btv("viewCallback");
      }
      paramString.JT(0);
      paramString = this.uWP;
      if (paramString == null) {
        p.btv("viewCallback");
      }
      paramString.dlT();
    }
    AppMethodBeat.o(249760);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter
 * JD-Core Version:    0.7.0.1
 */