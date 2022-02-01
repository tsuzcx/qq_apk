package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bn;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.model.bq;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicFollowData;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderTopicFollowListPage;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "isDown", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "startLoadingTime", "", "viewCallback", "doGetFollowScene", "", "fakeTopicInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getData", "loadStart", "onAttach", "callback", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "", "Companion", "plugin-finder_release"})
public final class FinderFollowTopicListContract$FollowTopicPresenter
  implements i, com.tencent.mm.plugin.finder.presenter.base.a<FinderFollowTopicListContract.FollowTopicViewCallback>
{
  private static final String zNg = "topicFollowList.fp";
  public static final Companion zNh;
  boolean hasMore;
  public final ArrayList<bq> mXB;
  private boolean xBb;
  private long xBe;
  private com.tencent.mm.cd.b xaw;
  FinderFollowTopicListContract.FollowTopicViewCallback zNe;
  private final com.tencent.mm.plugin.finder.storage.data.l zNf;
  
  static
  {
    AppMethodBeat.i(261821);
    zNh = new Companion((byte)0);
    zNg = "topicFollowList.fp";
    AppMethodBeat.o(261821);
  }
  
  public FinderFollowTopicListContract$FollowTopicPresenter()
  {
    AppMethodBeat.i(261819);
    this.zNf = new com.tencent.mm.plugin.finder.storage.data.l(zNg);
    this.mXB = new ArrayList();
    this.hasMore = true;
    this.xBe = SystemClock.uptimeMillis();
    AppMethodBeat.o(261819);
  }
  
  public final void a(FinderFollowTopicListContract.FollowTopicViewCallback paramFollowTopicViewCallback)
  {
    AppMethodBeat.i(261805);
    p.k(paramFollowTopicViewCallback, "callback");
    this.zNe = paramFollowTopicViewCallback;
    h.aGY().a(712, (i)this);
    h.aGY().a(3844, (i)this);
    AppMethodBeat.o(261805);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(261809);
    h.aGY().b(712, (i)this);
    h.aGY().b(3844, (i)this);
    AppMethodBeat.o(261809);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    Object localObject1 = null;
    AppMethodBeat.i(261814);
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
      label560:
      if (paramString == null)
      {
        AppMethodBeat.o(261814);
        return;
        paramString = null;
        break;
        label107:
        paramString = null;
        break label88;
        label112:
        if (paramString.intValue() == 712)
        {
          aa.f localf = new aa.f();
          localf.aaBC = null;
          boolean bool;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            final aa.a locala = new aa.a();
            locala.aaBx = false;
            if (paramq == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowTopicList");
              AppMethodBeat.o(261814);
              throw paramString;
            }
            localObject2 = ((bn)paramq).rr.bhX();
            paramString = (String)localObject2;
            if (!(localObject2 instanceof aui)) {
              paramString = null;
            }
            paramString = (aui)paramString;
            if (paramString != null) {}
            for (paramString = paramString.SDI; (p.h(this.xaw, paramString) ^ true); paramString = null)
            {
              Log.i("Finder.FollowTopicPresenter", "not my buf, ignore!");
              AppMethodBeat.o(261814);
              return;
            }
            if (this.xaw == null)
            {
              locala.aaBx = true;
              com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new kotlin.g.b.q(locala) {});
            }
            paramString = h.aHG();
            p.j(paramString, "MMKernel.storage()");
            paramString.aHp().set(ar.a.VAw, Integer.valueOf(((bn)paramq).doj()));
            paramString = this.zNe;
            if (paramString == null) {
              p.bGy("viewCallback");
            }
            paramString.OU(((bn)paramq).doj());
            paramString = this.zNe;
            if (paramString == null) {
              p.bGy("viewCallback");
            }
            paramString.dMX();
            paramString = ((bn)paramq).rr.bhY();
            if (paramString == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFollowTopicListResponse");
              AppMethodBeat.o(261814);
              throw paramString;
            }
            if (((auj)paramString).xFI != 0)
            {
              bool = true;
              this.hasMore = bool;
              localObject2 = ((bn)paramq).rr.bhY();
              paramString = (String)localObject2;
              if (!(localObject2 instanceof auj)) {
                paramString = null;
              }
              localObject2 = (auj)paramString;
              paramString = localObject1;
              if (localObject2 != null) {
                paramString = ((auj)localObject2).SDI;
              }
              this.xaw = paramString;
              localf.aaBC = ((Runnable)new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(271053);
                  Object localObject1 = this.zNi;
                  boolean bool1 = locala.aaBx;
                  Object localObject2 = (List)((bn)paramq).doi();
                  boolean bool2 = FinderFollowTopicListContract.FollowTopicPresenter.e(this.zNi);
                  p.k(localObject2, "dataList");
                  Log.i("Finder.FollowTopicPresenter", "firstPage " + bool1 + ", get follow contact " + ((List)localObject2).size());
                  int j = ((FinderFollowTopicListContract.FollowTopicPresenter)localObject1).mXB.size();
                  int i = ((List)localObject2).size();
                  if (bool1)
                  {
                    ((FinderFollowTopicListContract.FollowTopicPresenter)localObject1).mXB.clear();
                    i = -1;
                    j = -1;
                  }
                  ArrayList localArrayList = ((FinderFollowTopicListContract.FollowTopicPresenter)localObject1).mXB;
                  Object localObject3 = (Iterable)localObject2;
                  localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext()) {
                    ((Collection)localObject2).add(new bq((bkr)((Iterator)localObject3).next()));
                  }
                  localArrayList.addAll((Collection)localObject2);
                  localObject1 = ((FinderFollowTopicListContract.FollowTopicPresenter)localObject1).zNe;
                  if (localObject1 == null) {
                    p.bGy("viewCallback");
                  }
                  ((FinderFollowTopicListContract.FollowTopicViewCallback)localObject1).i(bool2, j, i);
                  AppMethodBeat.o(271053);
                }
              });
            }
          }
          else
          {
            l = SystemClock.uptimeMillis() - this.xBe;
            if (!this.xBb)
            {
              paramString = com.tencent.mm.plugin.finder.storage.d.AjH;
              if (l < ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue()) {
                break label560;
              }
            }
          }
          for (long l = 0L;; l = ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue() - l)
          {
            com.tencent.mm.ae.d.a(l, (kotlin.g.a.a)new kotlin.g.b.q(localf) {});
            AppMethodBeat.o(261814);
            return;
            bool = false;
            break;
            paramString = com.tencent.mm.plugin.finder.storage.d.AjH;
          }
        }
      }
    }
    if ((paramString.intValue() == 3844) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderTopicFollow");
        AppMethodBeat.o(261814);
        throw paramString;
      }
      paramString = (co)paramq;
      paramInt1 = paramString.opType;
      paramq = co.xeg;
      if (paramInt1 == co.dnB()) {
        j.c((List)this.mXB, (kotlin.g.a.b)new kotlin.g.b.q(paramString) {});
      }
      paramString = this.zNe;
      if (paramString == null) {
        p.bGy("viewCallback");
      }
      FinderFollowTopicListContract.FollowTopicViewCallback.b(paramString);
      paramString = h.aHG();
      p.j(paramString, "MMKernel.storage()");
      paramInt1 = paramString.aHp().getInt(ar.a.VAw, 0);
      if (paramInt1 > 0)
      {
        paramString = h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString.aHp().set(ar.a.VAw, Integer.valueOf(paramInt1 - 1));
        paramString = this.zNe;
        if (paramString == null) {
          p.bGy("viewCallback");
        }
        paramString.OU(paramInt1 - 1);
        paramString = this.zNe;
        if (paramString == null) {
          p.bGy("viewCallback");
        }
        paramString.dMX();
        AppMethodBeat.o(261814);
        return;
      }
      paramString = this.zNe;
      if (paramString == null) {
        p.bGy("viewCallback");
      }
      paramString.OU(0);
      paramString = this.zNe;
      if (paramString == null) {
        p.bGy("viewCallback");
      }
      paramString.dMX();
    }
    AppMethodBeat.o(261814);
  }
  
  public final void pY(boolean paramBoolean)
  {
    AppMethodBeat.i(261816);
    this.xBe = SystemClock.uptimeMillis();
    this.xBb = paramBoolean;
    Object localObject = this.xaw;
    String str = z.bdh();
    p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
    localObject = new bn((com.tencent.mm.cd.b)localObject, str);
    h.aGY().b((com.tencent.mm.an.q)localObject);
    AppMethodBeat.o(261816);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicPresenter$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract.FollowTopicPresenter
 * JD-Core Version:    0.7.0.1
 */