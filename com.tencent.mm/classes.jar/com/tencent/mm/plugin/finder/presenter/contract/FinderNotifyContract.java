package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.LongSparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.im;
import com.tencent.mm.f.b.a.dt;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.cgi.br.a;
import com.tencent.mm.plugin.finder.convert.bk;
import com.tencent.mm.plugin.finder.convert.bl;
import com.tencent.mm.plugin.finder.convert.bm;
import com.tencent.mm.plugin.finder.convert.bn;
import com.tencent.mm.plugin.finder.convert.bo;
import com.tencent.mm.plugin.finder.convert.bp;
import com.tencent.mm.plugin.finder.convert.bq;
import com.tencent.mm.plugin.finder.convert.bs;
import com.tencent.mm.plugin.finder.convert.bt;
import com.tencent.mm.plugin.finder.convert.bu;
import com.tencent.mm.plugin.finder.convert.bv;
import com.tencent.mm.plugin.finder.convert.bw;
import com.tencent.mm.plugin.finder.convert.bx;
import com.tencent.mm.plugin.finder.model.ax;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.model.be;
import com.tencent.mm.plugin.finder.model.bf;
import com.tencent.mm.plugin.finder.model.bg;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.logic.e.a;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import com.tencent.mm.view.recyclerview.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract;", "", "()V", "PAGE_LIMIT", "", "getPAGE_LIMIT", "()I", "startNetSceneTime", "", "getStartNetSceneTime", "()J", "setStartNetSceneTime", "(J)V", "startNetSceneTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartNetSceneTimeList", "()Ljava/util/ArrayList;", "index", "", "timeStamp", "NotifyPresenter", "NotifyViewCallback", "plugin-finder_release"})
public final class FinderNotifyContract
{
  private static final int zOA = 20;
  private static final ArrayList<Long> zPb;
  public static final FinderNotifyContract zPc;
  
  static
  {
    AppMethodBeat.i(283460);
    zPc = new FinderNotifyContract();
    zPb = new ArrayList();
    zOA = 20;
    AppMethodBeat.o(283460);
  }
  
  public static long OV(int paramInt)
  {
    AppMethodBeat.i(283457);
    Object localObject = zPb;
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
      localObject = (Long)zPb.get(paramInt);
      if (localObject == null) {
        break label75;
      }
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(283457);
      return l;
      i = 0;
      break;
      label69:
      localObject = null;
    }
    label75:
    AppMethodBeat.o(283457);
    return 0L;
  }
  
  public static void ak(int paramInt, long paramLong)
  {
    AppMethodBeat.i(283458);
    ArrayList localArrayList = zPb;
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
        zPb.set(paramInt, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(283458);
      return;
      i = 0;
      break;
      label57:
      localArrayList = null;
    }
  }
  
  public static int dNb()
  {
    return zOA;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scene", "", "requestScenes", "", "msgTypes", "Ljava/util/ArrayList;", "(I[ILjava/util/ArrayList;)V", "TAG", "", "containerList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getMsgTypes", "()Ljava/util/ArrayList;", "msgUpdateListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter$msgUpdateListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter$msgUpdateListener$1;", "onVisibleTimeStamp", "", "getRequestScenes", "()[I", "getScene", "()I", "showStatusList", "", "", "getShowStatusList", "()Ljava/util/List;", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderMsgUIItemBrowseStruct;", "unreadMentionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "viewCallbacks", "doScene", "", "index", "getData", "tabIndex", "getIndexFromScene", "requestScene", "getShowStatus", "getTabData", "getTabTypes", "getUnreadMention", "getViewCallback", "loadDataAndRefresh", "mentionId", "limit", "needLoadingAnim", "isRefresh", "loadDataAndRefreshAll", "loadMsgFromDBWithIndex", "loadMsgFromDBWithTypes", "types", "mergeData", "increment", "", "mergeDataRaw", "raw", "onActivityCreate", "onActivityDestroy", "onAttach", "callback", "onDetach", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshEmpty", "viewCallbak", "requestRefresh", "needAnim", "setBrowserCount", "setLastMentionId", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "sortMentionList", "plugin-finder_release"})
  public static final class NotifyPresenter
    implements com.tencent.mm.an.i, com.tencent.mm.plugin.finder.presenter.base.a<FinderNotifyContract.NotifyViewCallback>
  {
    private final String TAG;
    public final int scene;
    public long zOE;
    public final dt zOF;
    public final List<Boolean> zPd;
    private final ConcurrentHashMap<Integer, Long> zPe;
    private ArrayList<FinderNotifyContract.NotifyViewCallback> zPf;
    private final ArrayList<ArrayList<com.tencent.mm.plugin.finder.model.a>> zPg;
    public final msgUpdateListener.1 zPh;
    final int[] zPi;
    final ArrayList<int[]> zPj;
    
    private NotifyPresenter(int[] paramArrayOfInt, ArrayList<int[]> paramArrayList)
    {
      AppMethodBeat.i(288086);
      this.scene = 1;
      this.zPi = paramArrayOfInt;
      this.zPj = paramArrayList;
      this.TAG = ("Finder.NotifyPresenter." + hashCode());
      this.zPd = ((List)new ArrayList());
      this.zPe = new ConcurrentHashMap();
      this.zPf = new ArrayList();
      this.zPg = new ArrayList();
      this.zOF = new dt();
      this.zPh = new IListener() {};
      int k = this.zPj.size();
      int i = 0;
      while (i < k)
      {
        this.zPg.add(new ArrayList());
        this.zPd.add(Boolean.FALSE);
        i += 1;
      }
      paramArrayOfInt = ((Iterable)this.zPg).iterator();
      i = j;
      while (paramArrayOfInt.hasNext())
      {
        paramArrayList = paramArrayOfInt.next();
        if (i < 0) {
          j.iBO();
        }
        paramArrayList = (ArrayList)paramArrayList;
        Log.i(this.TAG, "init containerList: item[" + i + "]: " + paramArrayList.hashCode());
        i += 1;
      }
      AppMethodBeat.o(288086);
    }
    
    private final int OY(int paramInt)
    {
      int[] arrayOfInt = this.zPi;
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
    
    private final FinderNotifyContract.NotifyViewCallback OZ(int paramInt)
    {
      AppMethodBeat.i(288084);
      Object localObject = this.zPf;
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
        AppMethodBeat.o(288084);
        return localObject;
        i = 0;
        break;
        label55:
        localObject = null;
      }
      label60:
      AppMethodBeat.o(288084);
      return null;
    }
    
    private final long Pa(int paramInt)
    {
      AppMethodBeat.i(288085);
      Long localLong = (Long)this.zPe.get(Integer.valueOf(paramInt));
      if (localLong != null)
      {
        long l = localLong.longValue();
        AppMethodBeat.o(288085);
        return l;
      }
      AppMethodBeat.o(288085);
      return 0L;
    }
    
    private final long c(int paramInt, LinkedList<an> paramLinkedList)
    {
      AppMethodBeat.i(288080);
      if (paramLinkedList != null)
      {
        paramLinkedList = (List)paramLinkedList;
        Object localObject1 = paramLinkedList.listIterator(paramLinkedList.size());
        for (;;)
        {
          if (((ListIterator)localObject1).hasPrevious())
          {
            paramLinkedList = ((ListIterator)localObject1).previous();
            an localan = (an)paramLinkedList;
            Object localObject2 = this.zPj.get(paramInt);
            p.j(localObject2, "msgTypes[index]");
            if (kotlin.a.e.contains((int[])localObject2, localan.field_type))
            {
              paramLinkedList = (an)paramLinkedList;
              if (paramLinkedList == null) {
                break label216;
              }
              if (!this.zPe.containsKey(Integer.valueOf(paramInt))) {
                break label189;
              }
              localObject1 = (Long)this.zPe.get(Integer.valueOf(paramInt));
              if ((localObject1 != null) && (((Number)localObject1).longValue() > paramLinkedList.field_id)) {
                ((Map)this.zPe).put(Integer.valueOf(paramInt), Long.valueOf(paramLinkedList.field_id));
              }
            }
          }
        }
        for (;;)
        {
          long l = paramLinkedList.field_id;
          AppMethodBeat.o(288080);
          return l;
          paramLinkedList = null;
          break;
          label189:
          ((Map)this.zPe).put(Integer.valueOf(paramInt), Long.valueOf(paramLinkedList.field_id));
        }
      }
      label216:
      AppMethodBeat.o(288080);
      return -1L;
    }
    
    public final ArrayList<com.tencent.mm.plugin.finder.model.a> OW(int paramInt)
    {
      AppMethodBeat.i(288077);
      Object localObject = this.zPg;
      int i;
      if ((paramInt >= 0) && (paramInt < this.zPg.size()))
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
          ArrayList localArrayList = (ArrayList)this.zPg.get(paramInt);
          localObject = localArrayList;
          if (localArrayList != null) {}
        }
        else
        {
          localObject = new ArrayList();
        }
        AppMethodBeat.o(288077);
        return localObject;
        i = 0;
        break;
        label78:
        localObject = null;
      }
    }
    
    public final void OX(int paramInt)
    {
      AppMethodBeat.i(288078);
      h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.finder.cgi.br(this.scene, this.zPi[paramInt]));
      FinderNotifyContract localFinderNotifyContract = FinderNotifyContract.zPc;
      FinderNotifyContract.ak(paramInt, SystemClock.uptimeMillis());
      AppMethodBeat.o(288078);
    }
    
    public final void a(final long paramLong, final int paramInt1, int paramInt2, final boolean paramBoolean1, final boolean paramBoolean2)
    {
      AppMethodBeat.i(288083);
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new kotlin.g.b.q(paramLong) {});
      AppMethodBeat.o(288083);
    }
    
    public final void a(FinderNotifyContract.NotifyViewCallback paramNotifyViewCallback)
    {
      AppMethodBeat.i(288074);
      p.k(paramNotifyViewCallback, "callback");
      this.zPf.add(paramNotifyViewCallback);
      paramNotifyViewCallback = (List)this.zPf;
      if (paramNotifyViewCallback.size() > 1) {
        j.a(paramNotifyViewCallback, (Comparator)new Comparator()
        {
          public final int compare(T paramAnonymousT1, T paramAnonymousT2)
          {
            AppMethodBeat.i(286342);
            int i = kotlin.b.a.a((Comparable)Integer.valueOf(((FinderNotifyContract.NotifyViewCallback)paramAnonymousT1).zPu), (Comparable)Integer.valueOf(((FinderNotifyContract.NotifyViewCallback)paramAnonymousT2).zPu));
            AppMethodBeat.o(286342);
            return i;
          }
        });
      }
      Log.i(this.TAG, "onAttach " + this.zPi);
      AppMethodBeat.o(288074);
    }
    
    public final void ao(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(288081);
      FinderNotifyContract.NotifyViewCallback localNotifyViewCallback = OZ(paramInt);
      if (localNotifyViewCallback != null) {
        localNotifyViewCallback.t(null, 0, false);
      }
      Log.i(this.TAG, "requestRefresh " + paramInt + ", " + paramBoolean);
      if (!paramBoolean) {
        OX(paramInt);
      }
      AppMethodBeat.o(288081);
    }
    
    public final void onActivityDestroy()
    {
      AppMethodBeat.i(288073);
      EventCenter.instance.removeListener((IListener)this.zPh);
      if (this.scene == 1)
      {
        Iterator localIterator = ((Iterable)this.zPf).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          int j = i + 1;
          if (i < 0) {
            j.iBO();
          }
          Object localObject2 = (FinderNotifyContract.NotifyViewCallback)localObject1;
          localObject1 = this.zPd;
          int k;
          label108:
          boolean bool;
          if ((i >= 0) && (i < ((List)localObject1).size()))
          {
            k = 1;
            if (k == 0) {
              break label322;
            }
            if (localObject1 == null) {
              break label328;
            }
            bool = ((Boolean)((List)localObject1).get(i)).booleanValue();
            label129:
            if (!bool) {
              break label587;
            }
            long l = Pa(i);
            localObject1 = ((FinderNotifyContract.NotifyViewCallback)localObject2).xnR;
            if (localObject1 == null) {
              break label334;
            }
            localObject1 = ((WxRecyclerAdapter)localObject1).YSX;
            label160:
            if (localObject1 == null) {
              break label587;
            }
            k = ((LongSparseArray)localObject1).size();
            i = 0;
            label173:
            if (i >= k) {
              break label582;
            }
            ((LongSparseArray)localObject1).keyAt(i);
            localObject2 = ((com.tencent.mm.view.recyclerview.l)((LongSparseArray)localObject1).valueAt(i)).YSP;
            if ((localObject2 instanceof com.tencent.mm.plugin.finder.model.a))
            {
              if ((((com.tencent.mm.view.recyclerview.a)localObject2).mf() < l) || (l == 0L)) {
                break label428;
              }
              switch (((com.tencent.mm.plugin.finder.model.a)localObject2).zzT.field_type)
              {
              }
            }
          }
          for (;;)
          {
            localObject2 = this.zOF;
            ((dt)localObject2).jH(((dt)localObject2).ajL() + 1L);
            localObject2 = this.zOF;
            ((dt)localObject2).jG(((dt)localObject2).ajK() + 1L);
            i += 1;
            break label173;
            k = 0;
            break;
            label322:
            localObject1 = null;
            break label108;
            label328:
            bool = false;
            break label129;
            label334:
            localObject1 = null;
            break label160;
            localObject2 = this.zOF;
            ((dt)localObject2).jK(((dt)localObject2).ajO() + 1L);
            continue;
            localObject2 = this.zOF;
            ((dt)localObject2).jL(((dt)localObject2).ajP() + 1L);
            continue;
            localObject2 = this.zOF;
            ((dt)localObject2).jM(((dt)localObject2).ajQ() + 1L);
            continue;
            localObject2 = this.zOF;
            ((dt)localObject2).jJ(((dt)localObject2).ajN() + 1L);
          }
          label428:
          switch (((com.tencent.mm.plugin.finder.model.a)localObject2).zzT.field_type)
          {
          }
          for (;;)
          {
            localObject2 = this.zOF;
            ((dt)localObject2).jI(((dt)localObject2).ajM() + 1L);
            break;
            localObject2 = this.zOF;
            ((dt)localObject2).jO(((dt)localObject2).ajS() + 1L);
            continue;
            localObject2 = this.zOF;
            ((dt)localObject2).jP(((dt)localObject2).ajT() + 1L);
            continue;
            localObject2 = this.zOF;
            ((dt)localObject2).jQ(((dt)localObject2).ajU() + 1L);
            continue;
            localObject2 = this.zOF;
            ((dt)localObject2).jN(((dt)localObject2).ajR() + 1L);
          }
          label582:
          i = j;
          continue;
          label587:
          i = j;
        }
        this.zOF.bpa();
        Object localObject1 = n.zWF;
        n.a((com.tencent.mm.plugin.report.a)this.zOF);
      }
      Log.i(this.TAG, "onDetach " + this.zPi);
      h.aGY().b(978, (com.tencent.mm.an.i)this);
      this.zPf.clear();
      AppMethodBeat.o(288073);
    }
    
    public final void onDetach() {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(288079);
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetMentionList");
        AppMethodBeat.o(288079);
        throw paramString;
      }
      final int i = ((com.tencent.mm.plugin.finder.cgi.br)paramq).xdc;
      Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString + " requestScene " + i);
      i = OY(i);
      if ((((com.tencent.mm.plugin.finder.cgi.br)paramq).scene != this.scene) || (i < 0))
      {
        Log.w(this.TAG, "not my scene or type, ignore");
        AppMethodBeat.o(288079);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.finder.cgi.br)paramq).jKq;
        l = c(i, paramString);
        Log.i(this.TAG, "onSceneEnd :" + paramString.size() + " lastMentionId:" + l + " index:" + i);
        paramq = this.zOF;
        paramq.jF(paramq.ajJ() + paramString.size());
        a(9223372036854775807L, paramString.size(), i, true, true);
        AppMethodBeat.o(288079);
        return;
      }
      paramString = this.zPf.get(i);
      p.j(paramString, "viewCallbacks[index]");
      paramString = (Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278712);
          if (this.zPk.OW(i).isEmpty()) {
            this.zPo.t(c.a.a(this.zPo).getString(b.j.finder_loading_retry_tips), c.a.a(this.zPo).getColor(b.c.BW_0_Alpha_0_9), true);
          }
          AppMethodBeat.o(278712);
        }
      };
      long l = SystemClock.uptimeMillis();
      paramq = FinderNotifyContract.zPc;
      l -= FinderNotifyContract.OV(i);
      paramq = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (l >= ((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue())
      {
        paramString.run();
        AppMethodBeat.o(288079);
        return;
      }
      paramq = com.tencent.mm.plugin.finder.storage.d.AjH;
      com.tencent.mm.ae.d.a(((Number)com.tencent.mm.plugin.finder.storage.d.dUI().aSr()).longValue() - l, paramString);
      AppMethodBeat.o(288079);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "notifyView", "Landroid/view/View;", "presenter", "uiCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "tabIndex", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;I)V", "MENU_ID_BLOCK_MENTION", "MENU_ID_DEL_MENTION", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "contentView", "context", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "currMegaVideoCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoGetDetail;", "isEnableRefresh", "", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshTip", "Landroid/widget/TextView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTabIndex", "()I", "autoRefresh", "", "isRefreshAll", "checkErrorCode", "errCode", "checkMegaVideoDetail", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "finishLoadMore", "msgList", "", "needLoadingAnim", "isRefresh", "getActiveIndex", "getActivity", "getCommentDetail", "getPresenter", "getRefreshLoadMoreLayout", "handleOnMentionClick", "position", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "msg", "initAndRefreshAll", "initRefreshLayout", "initView", "jumpToMv", "isComment", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "commentId", "", "onLongClick", "anchorView", "pos", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refresh", "showRefreshTip", "tipsContent", "textColor", "clickable", "UICallbackListener", "plugin-finder_release"})
  public static final class NotifyViewCallback
    implements c<FinderNotifyContract.NotifyPresenter>, HeadFooterLayout.b
  {
    public final String TAG;
    public final View contentView;
    public final MMActivity iXq;
    public RecyclerView jLl;
    public com.tencent.mm.ui.widget.b.a szq;
    public MMProcessBar xDP;
    public WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> xnR;
    public RefreshLoadMoreLayout xvJ;
    private final int zON;
    public TextView zOP;
    private ag zOQ;
    private ak zOS;
    public final boolean zPq;
    public final FinderNotifyContract.NotifyPresenter zPr;
    private final UICallbackListener zPs;
    private final int zPt;
    public final int zPu;
    
    public NotifyViewCallback(MMActivity paramMMActivity, View paramView, FinderNotifyContract.NotifyPresenter paramNotifyPresenter, UICallbackListener paramUICallbackListener, int paramInt)
    {
      AppMethodBeat.i(279940);
      this.zPu = paramInt;
      this.TAG = ("Finder.NotifyViewCallback." + hashCode());
      this.zPq = true;
      this.zPr = paramNotifyPresenter;
      this.iXq = paramMMActivity;
      this.contentView = paramView;
      this.zPs = paramUICallbackListener;
      this.zON = 100;
      this.zPt = 101;
      AppMethodBeat.o(279940);
    }
    
    public final boolean MB(int paramInt)
    {
      AppMethodBeat.i(279939);
      Log.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(279939);
      return false;
    }
    
    public final void dtZ()
    {
      AppMethodBeat.i(279937);
      Log.i(this.TAG, "[onOverStop]");
      MMProcessBar localMMProcessBar = this.xDP;
      if (localMMProcessBar != null)
      {
        localMMProcessBar.hZH();
        AppMethodBeat.o(279937);
        return;
      }
      AppMethodBeat.o(279937);
    }
    
    public final void t(final String paramString, final int paramInt, final boolean paramBoolean)
    {
      AppMethodBeat.i(279936);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.q(paramString) {});
      AppMethodBeat.o(279936);
    }
    
    public final boolean v(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(279938);
      Log.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(paramInt1)));
      MMProcessBar localMMProcessBar = this.xDP;
      if (localMMProcessBar != null)
      {
        float f = paramInt1;
        Context localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localMMProcessBar.cQ(f / (int)localContext.getResources().getDimension(b.d.Edge_26A));
      }
      AppMethodBeat.o(279938);
      return false;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "", "onItemClick", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
    public static abstract interface UICallbackListener
    {
      public abstract void a(an paraman);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract
 * JD-Core Version:    0.7.0.1
 */