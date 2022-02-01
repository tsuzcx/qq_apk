package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.v;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.convert.bf;
import com.tencent.mm.plugin.finder.convert.bi;
import com.tencent.mm.plugin.finder.convert.bj;
import com.tencent.mm.plugin.finder.convert.bk;
import com.tencent.mm.plugin.finder.convert.bl;
import com.tencent.mm.plugin.finder.convert.bm;
import com.tencent.mm.plugin.finder.convert.bn;
import com.tencent.mm.plugin.finder.convert.bp;
import com.tencent.mm.plugin.finder.convert.bq;
import com.tencent.mm.plugin.finder.convert.br;
import com.tencent.mm.plugin.finder.convert.bs;
import com.tencent.mm.plugin.finder.convert.bt;
import com.tencent.mm.plugin.finder.convert.bu;
import com.tencent.mm.plugin.finder.convert.bv;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.model.ax;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.model.bb;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.model.be;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract;", "", "()V", "PAGE_LIMIT", "", "getPAGE_LIMIT", "()I", "startNetSceneTime", "", "getStartNetSceneTime", "()J", "setStartNetSceneTime", "(J)V", "startNetSceneTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartNetSceneTimeList", "()Ljava/util/ArrayList;", "index", "", "timeStamp", "NotifyPresenter", "NotifyViewCallback", "plugin-finder_release"})
public final class FinderNotifyContract
{
  private static final ArrayList<Long> uYJ;
  public static final FinderNotifyContract uYK;
  private static final int uYm = 20;
  
  static
  {
    AppMethodBeat.i(249960);
    uYK = new FinderNotifyContract();
    uYJ = new ArrayList();
    uYm = 20;
    AppMethodBeat.o(249960);
  }
  
  public static long JU(int paramInt)
  {
    AppMethodBeat.i(249958);
    Object localObject = uYJ;
    int i;
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
    }
    for (;;)
    {
      if (localObject == null) {
        break label75;
      }
      localObject = (Long)uYJ.get(paramInt);
      if (localObject == null) {
        break label75;
      }
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(249958);
      return l;
      i = 0;
      break;
      label69:
      localObject = null;
    }
    label75:
    AppMethodBeat.o(249958);
    return 0L;
  }
  
  public static void ah(int paramInt, long paramLong)
  {
    AppMethodBeat.i(249959);
    ArrayList localArrayList = uYJ;
    int i;
    if ((paramInt >= 0) && (paramInt < localArrayList.size()))
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    for (;;)
    {
      if (localArrayList != null) {
        uYJ.set(paramInt, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(249959);
      return;
      i = 0;
      break;
      label57:
      localArrayList = null;
    }
  }
  
  public static int dlX()
  {
    return uYm;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scene", "", "requestScenes", "", "msgTypes", "Ljava/util/ArrayList;", "(I[ILjava/util/ArrayList;)V", "TAG", "", "containerList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getMsgTypes", "()Ljava/util/ArrayList;", "msgUpdateListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter$msgUpdateListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter$msgUpdateListener$1;", "onVisibleTimeStamp", "", "getRequestScenes", "()[I", "getScene", "()I", "showStatusList", "", "", "getShowStatusList", "()Ljava/util/List;", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderMsgUIItemBrowseStruct;", "unreadMentionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "viewCallbacks", "doScene", "", "index", "getData", "tabIndex", "getIndexFromScene", "requestScene", "getShowStatus", "getTabData", "getTabTypes", "getUnreadMention", "getViewCallback", "loadDataAndRefresh", "mentionId", "limit", "needLoadingAnim", "isRefresh", "loadDataAndRefreshAll", "loadMsgFromDBWithIndex", "loadMsgFromDBWithTypes", "types", "mergeData", "increment", "", "mergeDataRaw", "raw", "onActivityCreate", "onActivityDestroy", "onAttach", "callback", "onDetach", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshEmpty", "viewCallbak", "requestRefresh", "needAnim", "setBrowserCount", "setLastMentionId", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "sortMentionList", "plugin-finder_release"})
  public static final class NotifyPresenter
    implements i, com.tencent.mm.plugin.finder.presenter.base.a<FinderNotifyContract.NotifyViewCallback>
  {
    private final String TAG;
    public final int scene;
    public final List<Boolean> uYL;
    private final ConcurrentHashMap<Integer, Long> uYM;
    private ArrayList<FinderNotifyContract.NotifyViewCallback> uYN;
    private final ArrayList<ArrayList<com.tencent.mm.plugin.finder.model.a>> uYO;
    public final msgUpdateListener.1 uYP;
    final int[] uYQ;
    final ArrayList<int[]> uYR;
    public long uYq;
    public final dc uYr;
    
    private NotifyPresenter(int[] paramArrayOfInt, ArrayList<int[]> paramArrayList)
    {
      AppMethodBeat.i(249928);
      this.scene = 1;
      this.uYQ = paramArrayOfInt;
      this.uYR = paramArrayList;
      this.TAG = ("Finder.NotifyPresenter." + hashCode());
      this.uYL = ((List)new ArrayList());
      this.uYM = new ConcurrentHashMap();
      this.uYN = new ArrayList();
      this.uYO = new ArrayList();
      this.uYr = new dc();
      this.uYP = new IListener() {};
      int k = this.uYR.size();
      int i = 0;
      while (i < k)
      {
        this.uYO.add(new ArrayList());
        this.uYL.add(Boolean.FALSE);
        i += 1;
      }
      paramArrayOfInt = ((Iterable)this.uYO).iterator();
      i = j;
      while (paramArrayOfInt.hasNext())
      {
        paramArrayList = paramArrayOfInt.next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        paramArrayList = (ArrayList)paramArrayList;
        Log.i(this.TAG, "init containerList: item[" + i + "]: " + paramArrayList.hashCode());
        i += 1;
      }
      AppMethodBeat.o(249928);
    }
    
    private final int JX(int paramInt)
    {
      int[] arrayOfInt = this.uYQ;
      int k = arrayOfInt.length;
      int j = 0;
      int i = 0;
      while (j < k)
      {
        if (paramInt == arrayOfInt[j]) {
          return i;
        }
        j += 1;
        i += 1;
      }
      return -1;
    }
    
    private final FinderNotifyContract.NotifyViewCallback JY(int paramInt)
    {
      AppMethodBeat.i(249926);
      Object localObject = this.uYN;
      int i;
      if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
      {
        i = 1;
        if (i == 0) {
          break label55;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label60;
        }
        localObject = (FinderNotifyContract.NotifyViewCallback)((ArrayList)localObject).get(paramInt);
        AppMethodBeat.o(249926);
        return localObject;
        i = 0;
        break;
        label55:
        localObject = null;
      }
      label60:
      AppMethodBeat.o(249926);
      return null;
    }
    
    private final long JZ(int paramInt)
    {
      AppMethodBeat.i(249927);
      Long localLong = (Long)this.uYM.get(Integer.valueOf(paramInt));
      if (localLong != null)
      {
        long l = localLong.longValue();
        AppMethodBeat.o(249927);
        return l;
      }
      AppMethodBeat.o(249927);
      return 0L;
    }
    
    private final long c(int paramInt, LinkedList<ao> paramLinkedList)
    {
      AppMethodBeat.i(249922);
      if (paramLinkedList != null)
      {
        paramLinkedList = (List)paramLinkedList;
        Object localObject1 = paramLinkedList.listIterator(paramLinkedList.size());
        for (;;)
        {
          if (((ListIterator)localObject1).hasPrevious())
          {
            paramLinkedList = ((ListIterator)localObject1).previous();
            ao localao = (ao)paramLinkedList;
            Object localObject2 = this.uYR.get(paramInt);
            p.g(localObject2, "msgTypes[index]");
            if (kotlin.a.e.contains((int[])localObject2, localao.field_type))
            {
              paramLinkedList = (ao)paramLinkedList;
              if (paramLinkedList == null) {
                break label216;
              }
              if (!this.uYM.containsKey(Integer.valueOf(paramInt))) {
                break label189;
              }
              localObject1 = (Long)this.uYM.get(Integer.valueOf(paramInt));
              if ((localObject1 != null) && (((Number)localObject1).longValue() > paramLinkedList.field_id)) {
                ((Map)this.uYM).put(Integer.valueOf(paramInt), Long.valueOf(paramLinkedList.field_id));
              }
            }
          }
        }
        for (;;)
        {
          long l = paramLinkedList.field_id;
          AppMethodBeat.o(249922);
          return l;
          paramLinkedList = null;
          break;
          label189:
          ((Map)this.uYM).put(Integer.valueOf(paramInt), Long.valueOf(paramLinkedList.field_id));
        }
      }
      label216:
      AppMethodBeat.o(249922);
      return -1L;
    }
    
    public final ArrayList<com.tencent.mm.plugin.finder.model.a> JV(int paramInt)
    {
      AppMethodBeat.i(249919);
      Object localObject = this.uYO;
      int i;
      if ((paramInt >= 0) && (paramInt < this.uYO.size()))
      {
        i = 1;
        if (i == 0) {
          break label78;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ArrayList localArrayList = (ArrayList)this.uYO.get(paramInt);
          localObject = localArrayList;
          if (localArrayList != null) {}
        }
        else
        {
          localObject = new ArrayList();
        }
        AppMethodBeat.o(249919);
        return localObject;
        i = 0;
        break;
        label78:
        localObject = null;
      }
    }
    
    public final void JW(int paramInt)
    {
      AppMethodBeat.i(249920);
      g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.finder.cgi.bo(this.scene, this.uYQ[paramInt]));
      FinderNotifyContract localFinderNotifyContract = FinderNotifyContract.uYK;
      FinderNotifyContract.ah(paramInt, SystemClock.uptimeMillis());
      AppMethodBeat.o(249920);
    }
    
    public final void a(final long paramLong, final int paramInt1, int paramInt2, final boolean paramBoolean1, final boolean paramBoolean2)
    {
      AppMethodBeat.i(249925);
      d.i((kotlin.g.a.a)new kotlin.g.b.q(paramLong) {});
      AppMethodBeat.o(249925);
    }
    
    public final void a(FinderNotifyContract.NotifyViewCallback paramNotifyViewCallback)
    {
      AppMethodBeat.i(249917);
      p.h(paramNotifyViewCallback, "callback");
      this.uYN.add(paramNotifyViewCallback);
      paramNotifyViewCallback = (List)this.uYN;
      if (paramNotifyViewCallback.size() > 1) {
        kotlin.a.j.a(paramNotifyViewCallback, (Comparator)new Comparator()
        {
          public final int compare(T paramAnonymousT1, T paramAnonymousT2)
          {
            AppMethodBeat.i(249911);
            int i = kotlin.b.a.a((Comparable)Integer.valueOf(((FinderNotifyContract.NotifyViewCallback)paramAnonymousT1).uZc), (Comparable)Integer.valueOf(((FinderNotifyContract.NotifyViewCallback)paramAnonymousT2).uZc));
            AppMethodBeat.o(249911);
            return i;
          }
        });
      }
      Log.i(this.TAG, "onAttach " + this.uYQ);
      AppMethodBeat.o(249917);
    }
    
    public final void am(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(249923);
      FinderNotifyContract.NotifyViewCallback localNotifyViewCallback = JY(paramInt);
      if (localNotifyViewCallback != null) {
        localNotifyViewCallback.o(null, 0, false);
      }
      Log.i(this.TAG, "requestRefresh " + paramInt + ", " + paramBoolean);
      if (!paramBoolean) {
        JW(paramInt);
      }
      AppMethodBeat.o(249923);
    }
    
    public final void onActivityDestroy()
    {
      AppMethodBeat.i(249916);
      EventCenter.instance.removeListener((IListener)this.uYP);
      if (this.scene == 1)
      {
        Iterator localIterator = ((Iterable)this.uYN).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          int j = i + 1;
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          FinderNotifyContract.NotifyViewCallback localNotifyViewCallback = (FinderNotifyContract.NotifyViewCallback)localObject;
          localObject = this.uYL;
          int k;
          label104:
          label108:
          boolean bool;
          label129:
          long l;
          if ((i >= 0) && (i < ((List)localObject).size()))
          {
            k = 1;
            if (k == 0) {
              break label194;
            }
            if (localObject == null) {
              break label200;
            }
            bool = ((Boolean)((List)localObject).get(i)).booleanValue();
            if (!bool) {
              break label212;
            }
            l = JZ(i);
            localObject = localNotifyViewCallback.tFp;
            if (localObject == null) {
              break label206;
            }
          }
          label194:
          label200:
          label206:
          for (localObject = ((WxRecyclerAdapter)localObject).Rrx;; localObject = null)
          {
            if (localObject == null) {
              break label212;
            }
            d.b((LongSparseArray)localObject, (m)new kotlin.g.b.q(l) {});
            i = j;
            break;
            k = 0;
            break label104;
            localObject = null;
            break label108;
            bool = false;
            break label129;
          }
          label212:
          i = j;
        }
        this.uYr.bfK();
        Object localObject = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a((com.tencent.mm.plugin.report.a)this.uYr);
      }
      Log.i(this.TAG, "onDetach " + this.uYQ);
      g.azz().b(978, (i)this);
      this.uYN.clear();
      AppMethodBeat.o(249916);
    }
    
    public final void onDetach() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(249921);
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetMentionList");
        AppMethodBeat.o(249921);
        throw paramString;
      }
      final int i = ((com.tencent.mm.plugin.finder.cgi.bo)paramq).tvu;
      Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString + " requestScene " + i);
      i = JX(i);
      if ((((com.tencent.mm.plugin.finder.cgi.bo)paramq).scene != this.scene) || (i < 0))
      {
        Log.w(this.TAG, "not my scene or type, ignore");
        AppMethodBeat.o(249921);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.finder.cgi.bo)paramq).gZp;
        l = c(i, paramString);
        Log.i(this.TAG, "onSceneEnd :" + paramString.size() + " lastMentionId:" + l + " index:" + i);
        paramq = this.uYr;
        paramq.iL(paramq.aeP() + paramString.size());
        a(9223372036854775807L, paramString.size(), i, true, true);
        AppMethodBeat.o(249921);
        return;
      }
      paramString = this.uYN.get(i);
      p.g(paramString, "viewCallbacks[index]");
      paramString = (Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249912);
          if (this.uYS.JV(i).isEmpty()) {
            this.uYW.o(c.a.a(this.uYW).getString(2131760236), c.a.a(this.uYW).getColor(2131099669), true);
          }
          AppMethodBeat.o(249912);
        }
      };
      long l = SystemClock.uptimeMillis();
      paramq = FinderNotifyContract.uYK;
      l -= FinderNotifyContract.JU(i);
      paramq = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (l >= ((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue())
      {
        paramString.run();
        AppMethodBeat.o(249921);
        return;
      }
      paramq = com.tencent.mm.plugin.finder.storage.c.vCb;
      d.a(((Number)com.tencent.mm.plugin.finder.storage.c.dty().value()).longValue() - l, paramString);
      AppMethodBeat.o(249921);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "notifyView", "Landroid/view/View;", "presenter", "uiCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "tabIndex", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;I)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "contentView", "context", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "currScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetDetail;", "isEnableRefresh", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshTip", "Landroid/widget/TextView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTabIndex", "()I", "autoRefresh", "", "isRefreshAll", "checkErrorCode", "errCode", "checkMegaVideoDetail", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "finishLoadMore", "msgList", "", "needLoadingAnim", "isRefresh", "getActiveIndex", "getActivity", "getCommentDetail", "getPresenter", "getRefreshLoadMoreLayout", "handleOnMentionClick", "position", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "msg", "initAndRefreshAll", "initRefreshLayout", "initView", "jumpToMv", "isComment", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "commentId", "", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refresh", "showRefreshTip", "tipsContent", "textColor", "clickable", "UICallbackListener", "plugin-finder_release"})
  public static final class NotifyViewCallback
    implements com.tencent.mm.plugin.finder.presenter.base.c<FinderNotifyContract.NotifyPresenter>, HeadFooterLayout.b
  {
    public final String TAG;
    public final View contentView;
    public final MMActivity gte;
    public RecyclerView hak;
    public WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> tFp;
    public RefreshLoadMoreLayout tLS;
    public MMProcessBar tSY;
    private af tzB;
    public TextView uYA;
    private cu uYC;
    public final boolean uYZ;
    public final FinderNotifyContract.NotifyPresenter uZa;
    private final UICallbackListener uZb;
    public final int uZc;
    
    public NotifyViewCallback(MMActivity paramMMActivity, View paramView, FinderNotifyContract.NotifyPresenter paramNotifyPresenter, UICallbackListener paramUICallbackListener, int paramInt)
    {
      AppMethodBeat.i(249953);
      this.uZc = paramInt;
      this.TAG = ("Finder.NotifyViewCallback." + hashCode());
      this.uYZ = true;
      this.uZa = paramNotifyPresenter;
      this.gte = paramMMActivity;
      this.contentView = paramView;
      this.uZb = paramUICallbackListener;
      AppMethodBeat.o(249953);
    }
    
    public final boolean IJ(int paramInt)
    {
      AppMethodBeat.i(249952);
      Log.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(249952);
      return false;
    }
    
    public final void ddr()
    {
      AppMethodBeat.i(249950);
      Log.i(this.TAG, "[onOverStop]");
      MMProcessBar localMMProcessBar = this.tSY;
      if (localMMProcessBar != null)
      {
        localMMProcessBar.gYP();
        AppMethodBeat.o(249950);
        return;
      }
      AppMethodBeat.o(249950);
    }
    
    public final void o(final String paramString, final int paramInt, final boolean paramBoolean)
    {
      AppMethodBeat.i(249949);
      d.h((kotlin.g.a.a)new kotlin.g.b.q(paramString) {});
      AppMethodBeat.o(249949);
    }
    
    public final boolean u(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(249951);
      Log.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
      MMProcessBar localMMProcessBar = this.tSY;
      if (localMMProcessBar != null)
      {
        float f = paramInt1;
        Context localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localMMProcessBar.rotate(f / (int)localContext.getResources().getDimension(2131165295));
      }
      AppMethodBeat.o(249951);
      return false;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "", "onItemClick", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
    public static abstract interface UICallbackListener
    {
      public abstract void a(ao paramao);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract
 * JD-Core Version:    0.7.0.1
 */