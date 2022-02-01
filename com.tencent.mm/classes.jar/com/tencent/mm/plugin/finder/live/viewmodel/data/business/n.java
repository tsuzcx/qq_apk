package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.epb;
import com.tencent.mm.protocal.protobuf.fgz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.j;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "bgmUrls", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBgmUrls", "()Ljava/util/ArrayList;", "bulletCommentClickInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$BulletCommentClickData;", "getBulletCommentClickInfo", "()Landroidx/lifecycle/MutableLiveData;", "setBulletCommentClickInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "commentStore", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CommentStore;", "getCommentStore", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CommentStore;", "setCommentStore", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CommentStore;)V", "enableShowOlympicReserveGuide", "", "getEnableShowOlympicReserveGuide", "()Z", "setEnableShowOlympicReserveGuide", "(Z)V", "isJoinRunWith", "setJoinRunWith", "isNeedAutoGetCert", "setNeedAutoGetCert", "isOlympicCertificateShare", "setOlympicCertificateShare", "isShareFromWXSport", "setShareFromWXSport", "lastInitTime", "", "getLastInitTime", "()I", "setLastInitTime", "(I)V", "localCertificateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderOlympicLiveFireAuthorInfo;", "getLocalCertificateInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderOlympicLiveFireAuthorInfo;", "setLocalCertificateInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderOlympicLiveFireAuthorInfo;)V", "olympicData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicBaseData;", "getOlympicData", "setOlympicData", "remainDays", "getRemainDays", "setRemainDays", "remainTime", "getRemainTime", "setRemainTime", "selfCertificateInfo", "getSelfCertificateInfo", "setSelfCertificateInfo", "sportActivity", "Lcom/tencent/mm/protocal/protobuf/SportActivity;", "getSportActivity", "()Lcom/tencent/mm/protocal/protobuf/SportActivity;", "setSportActivity", "(Lcom/tencent/mm/protocal/protobuf/SportActivity;)V", "sportEvent", "Lcom/tencent/mm/protocal/protobuf/RelatedEventInfo;", "getSportEvent", "()Lcom/tencent/mm/protocal/protobuf/RelatedEventInfo;", "setSportEvent", "(Lcom/tencent/mm/protocal/protobuf/RelatedEventInfo;)V", "torchCenterOffset", "", "kotlin.jvm.PlatformType", "getTorchCenterOffset", "setTorchCenterOffset", "clearBulletCommentClick", "", "getCertificateState", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CertificateState;", "state", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicState;", "getOlympicState", "initData", "response", "Lcom/tencent/mm/protocal/protobuf/InitTorchLiveResponse;", "onCleared", "updateData", "syncEventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgSyncEventInfo;", "BulletCommentClickData", "CertificateState", "CommentStore", "Companion", "OlympicBaseData", "OlympicState", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final d Eha;
  public static final String TAG;
  public boolean CPq;
  public int CWC;
  public c Dhw;
  public int Ehb;
  public int Ehc;
  public x<n.e> Ehd;
  public brs Ehe;
  public brs Ehf;
  public boolean Ehg;
  public boolean Ehh;
  public x<a> Ehi;
  public final ArrayList<String> Ehj;
  public epb Ehk;
  public fgz Ehl;
  public boolean Ehm;
  public x<Float> Ehn;
  
  static
  {
    AppMethodBeat.i(356626);
    Eha = new d((byte)0);
    TAG = "Finder.LiveOlympicsSlice";
    AppMethodBeat.o(356626);
  }
  
  public n(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356608);
    this.CWC = -1;
    this.Ehc = -1;
    this.Ehd = new x();
    this.Dhw = new c();
    this.Ehi = new x();
    this.Ehj = new ArrayList();
    this.Ehn = new x(Float.valueOf(0.0F));
    AppMethodBeat.o(356608);
  }
  
  public static b b(f paramf)
  {
    AppMethodBeat.i(356614);
    s.u(paramf, "state");
    switch (g.$EnumSwitchMapping$0[paramf.ordinal()])
    {
    default: 
      paramf = new kotlin.p();
      AppMethodBeat.o(356614);
      throw paramf;
    case 1: 
      paramf = b.Eht;
      AppMethodBeat.o(356614);
      return paramf;
    case 2: 
      paramf = b.Ehs;
      AppMethodBeat.o(356614);
      return paramf;
    }
    paramf = b.Ehr;
    AppMethodBeat.o(356614);
    return paramf;
  }
  
  public final f ezi()
  {
    AppMethodBeat.i(356644);
    Object localObject = (n.e)this.Ehd.getValue();
    e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "finderolympicsdatanull", localObject);
    if ((localObject != null) && (!((n.e)localObject).isStart)) {
      i = 1;
    }
    while (i != 0) {
      if (((n.e)localObject).EhI)
      {
        localObject = f.EhM;
        AppMethodBeat.o(356644);
        return localObject;
        i = 0;
      }
      else
      {
        localObject = f.EhL;
        AppMethodBeat.o(356644);
        return localObject;
      }
    }
    if ((localObject != null) && (((n.e)localObject).EhJ == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = f.EhM;
      AppMethodBeat.o(356644);
      return localObject;
    }
    localObject = f.EhN;
    AppMethodBeat.o(356644);
    return localObject;
  }
  
  public final void ezj()
  {
    AppMethodBeat.i(356648);
    this.Ehi.t(new a());
    AppMethodBeat.o(356648);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356634);
    super.onCleared();
    this.Ehb = 0;
    this.CWC = -1;
    this.Ehc = -1;
    this.CPq = false;
    this.Ehk = null;
    this.Ehl = null;
    this.Dhw = new c();
    this.Ehe = null;
    this.Ehf = null;
    this.Ehg = false;
    this.Ehd = new x();
    this.Ehn = new x(Float.valueOf(0.0F));
    this.Ehi = new x();
    AppMethodBeat.o(356634);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$BulletCommentClickData;", "", "danmuX", "", "danmuY", "danmuText", "", "(FFLjava/lang/String;)V", "getDanmuText", "()Ljava/lang/String;", "setDanmuText", "(Ljava/lang/String;)V", "getDanmuX", "()F", "setDanmuX", "(F)V", "getDanmuY", "setDanmuY", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public float Eho;
    public float Ehp;
    public String Ehq;
    
    public a(float paramFloat1, float paramFloat2, String paramString)
    {
      this.Eho = paramFloat1;
      this.Ehp = paramFloat2;
      this.Ehq = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(356813);
      if (this == paramObject)
      {
        AppMethodBeat.o(356813);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(356813);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(Float.valueOf(this.Eho), Float.valueOf(paramObject.Eho)))
      {
        AppMethodBeat.o(356813);
        return false;
      }
      if (!s.p(Float.valueOf(this.Ehp), Float.valueOf(paramObject.Ehp)))
      {
        AppMethodBeat.o(356813);
        return false;
      }
      if (!s.p(this.Ehq, paramObject.Ehq))
      {
        AppMethodBeat.o(356813);
        return false;
      }
      AppMethodBeat.o(356813);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(356805);
      int j = Float.floatToIntBits(this.Eho);
      int k = Float.floatToIntBits(this.Ehp);
      if (this.Ehq == null) {}
      for (int i = 0;; i = this.Ehq.hashCode())
      {
        AppMethodBeat.o(356805);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(356797);
      String str = "BulletCommentClickData(danmuX=" + this.Eho + ", danmuY=" + this.Ehp + ", danmuText=" + this.Ehq + ')';
      AppMethodBeat.o(356797);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CertificateState;", "", "(Ljava/lang/String;I)V", "SELF_RELAY_TORCH_CERTIFICATE_STATE", "BURN_TORCH_CERTIFICATE_STATE", "MY_CERTIFICATE_STATE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(356794);
      Ehr = new b("SELF_RELAY_TORCH_CERTIFICATE_STATE", 0);
      Ehs = new b("BURN_TORCH_CERTIFICATE_STATE", 1);
      Eht = new b("MY_CERTIFICATE_STATE", 2);
      Ehu = new b[] { Ehr, Ehs, Eht };
      AppMethodBeat.o(356794);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$CommentStore;", "", "()V", "FRIEND_COMMENT_PERCENT", "", "MAX_RECENT_SIZE", "", "MAX_WAIT_SIZE", "friendWaittingComments", "Lkotlin/collections/ArrayDeque;", "Lcom/tencent/mm/protocal/protobuf/Comment;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "listener", "Lkotlin/Function0;", "", "getListener", "()Lkotlin/jvm/functions/Function0;", "setListener", "(Lkotlin/jvm/functions/Function0;)V", "recentComments", "waittingComments", "checkString", "", "str", "", "consume", "", "maxSize", "maintainQueue", "deque", "newComments", "offerN", "n", "from", "to", "", "produce", "comments", "wxRemoveIf", "E", "filter", "Lkotlin/Function1;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public final j<aep> EhA;
    public kotlin.g.a.a<ah> EhB;
    public final int Ehv;
    private final int Ehw;
    private final double Ehx;
    public final j<aep> Ehy;
    public final j<aep> Ehz;
    public com.tencent.mm.bx.b lastBuffer;
    
    public c()
    {
      AppMethodBeat.i(356798);
      this.Ehv = 200;
      this.Ehw = 200;
      this.Ehx = 0.6D;
      this.Ehy = new j();
      this.Ehz = new j();
      this.EhA = new j();
      AppMethodBeat.o(356798);
    }
    
    private static void a(int paramInt, j<aep> paramj, List<aep> paramList)
    {
      AppMethodBeat.i(356815);
      if (paramInt <= 0)
      {
        AppMethodBeat.o(356815);
        return;
      }
      int i = 0;
      if (paramInt > 0) {}
      for (;;)
      {
        i += 1;
        aep localaep = (aep)paramj.kkV();
        if (localaep != null) {
          paramList.add(localaep);
        }
        if (i >= paramInt)
        {
          AppMethodBeat.o(356815);
          return;
        }
      }
    }
    
    public static void a(j<aep> paramj, List<? extends aep> paramList, int paramInt)
    {
      AppMethodBeat.i(356823);
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        paramj.hr((aep)paramList.next());
      }
      int j = paramj.size() - paramInt;
      paramInt = 0;
      if (j > 0)
      {
        int i;
        do
        {
          i = paramInt + 1;
          paramj.kkV();
          paramInt = i;
        } while (i < j);
      }
      AppMethodBeat.o(356823);
    }
    
    public static <E> void a(j<E> paramj, kotlin.g.a.b<? super E, Boolean> paramb)
    {
      AppMethodBeat.i(356806);
      s.u(paramj, "<this>");
      s.u(paramb, "filter");
      Iterator localIterator = ((Iterable)paramj).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!((Boolean)paramb.invoke(localObject)).booleanValue());
      for (paramb = localObject;; paramb = null)
      {
        if (paramb != null) {
          paramj.remove(paramb);
        }
        AppMethodBeat.o(356806);
        return;
      }
    }
    
    public static boolean ayw(String paramString)
    {
      AppMethodBeat.i(356826);
      if (paramString != null)
      {
        if (((CharSequence)paramString).length() == 0) {}
        for (int i = 1; (i == 0) && (!kotlin.n.n.bp((CharSequence)paramString)); i = 0)
        {
          AppMethodBeat.o(356826);
          return true;
        }
      }
      AppMethodBeat.o(356826);
      return false;
    }
    
    public final List<aep> Qf(int paramInt)
    {
      AppMethodBeat.i(356833);
      List localList = (List)new ArrayList();
      a(Math.min((int)(paramInt * this.Ehx), this.Ehy.size()), this.Ehy, localList);
      Object localObject = bj.GlQ;
      localObject = n.Eha;
      bj.hf(n.access$getTAG$cp(), s.X("consume friends:", kotlin.a.p.a((Iterable)localList, null, null, null, 0, null, (kotlin.g.a.b)a.EhC, 31)));
      a(Math.min(paramInt - localList.size(), this.Ehz.size()), this.Ehz, localList);
      if (localList.size() < paramInt) {
        a(Math.min(paramInt - localList.size(), this.EhA.size()), this.EhA, localList);
      }
      a(this.EhA, localList, this.Ehw);
      localObject = n.Eha;
      Log.i(n.access$getTAG$cp(), "waittingBulletComments, consume comments:" + localList.size() + ", afterSize:" + this.Ehz.size() + ", recentSize:" + this.EhA.size());
      localObject = bj.GlQ;
      localObject = n.Eha;
      bj.hf(n.access$getTAG$cp(), s.X("consume:", kotlin.a.p.a((Iterable)localList, null, null, null, 0, null, (kotlin.g.a.b)b.EhD, 31)));
      AppMethodBeat.o(356833);
      return localList;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/Comment;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<aep, CharSequence>
    {
      public static final a EhC;
      
      static
      {
        AppMethodBeat.i(356660);
        EhC = new a();
        AppMethodBeat.o(356660);
      }
      
      a()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/Comment;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<aep, CharSequence>
    {
      public static final b EhD;
      
      static
      {
        AppMethodBeat.i(356642);
        EhD = new b();
        AppMethodBeat.o(356642);
      }
      
      b()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "local", "Lcom/tencent/mm/protocal/protobuf/Comment;"}, k=3, mv={1, 5, 1}, xi=48)
    public static final class c
      extends u
      implements kotlin.g.a.b<aep, Boolean>
    {
      public c(aep paramaep)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "local", "Lcom/tencent/mm/protocal/protobuf/Comment;"}, k=3, mv={1, 5, 1}, xi=48)
    public static final class d
      extends u
      implements kotlin.g.a.b<aep, Boolean>
    {
      public d(aep paramaep)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "local", "Lcom/tencent/mm/protocal/protobuf/Comment;"}, k=3, mv={1, 5, 1}, xi=48)
    public static final class e
      extends u
      implements kotlin.g.a.b<aep, Boolean>
    {
      public e(aep paramaep)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/Comment;"}, k=3, mv={1, 5, 1}, xi=48)
    public static final class f
      extends u
      implements kotlin.g.a.b<aep, CharSequence>
    {
      public static final f EhF;
      
      static
      {
        AppMethodBeat.i(356656);
        EhF = new f();
        AppMethodBeat.o(356656);
      }
      
      f()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/Comment;"}, k=3, mv={1, 5, 1}, xi=48)
    public static final class g
      extends u
      implements kotlin.g.a.b<aep, CharSequence>
    {
      public static final g EhG;
      
      static
      {
        AppMethodBeat.i(356653);
        EhG = new g();
        AppMethodBeat.o(356653);
      }
      
      g()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicState;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "RELAY_TORCH_STATE", "CERTIFICATE_STATE", "BURN_TORCH_STATE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum f
  {
    public final int id;
    
    static
    {
      AppMethodBeat.i(356818);
      EhL = new f("RELAY_TORCH_STATE", 0, 1);
      EhM = new f("CERTIFICATE_STATE", 1, 2);
      EhN = new f("BURN_TORCH_STATE", 2, 3);
      EhO = new f[] { EhL, EhM, EhN };
      AppMethodBeat.o(356818);
    }
    
    private f(int paramInt)
    {
      this.id = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    public h(n paramn, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    public i(n paramn, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.n
 * JD-Core Version:    0.7.0.1
 */