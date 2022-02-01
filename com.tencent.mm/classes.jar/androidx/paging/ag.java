package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.a.a;
import kotlin.d.d<-Landroidx.paging.ag<TT;>;>;
import kotlin.g.a.m;
import kotlin.g.a.m<-TT;-Lkotlin.d.d<-Ljava.lang.Boolean;>;+Ljava.lang.Object;>;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageEvent;", "T", "", "()V", "filter", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "R", "transform", "", "map", "Drop", "Insert", "LoadStateUpdate", "Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class ag<T>
{
  public Object b(m<? super T, ? super kotlin.d.d<? super Boolean>, ? extends Object> paramm, kotlin.d.d<? super ag<T>> paramd)
  {
    return this;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageEvent$Drop;", "T", "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "minPageOffset", "", "maxPageOffset", "placeholdersRemaining", "(Landroidx/paging/LoadType;III)V", "getLoadType", "()Landroidx/paging/LoadType;", "getMaxPageOffset", "()I", "getMinPageOffset", "pageCount", "getPageCount", "getPlaceholdersRemaining", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class a<T>
    extends ag<T>
  {
    final ad bKC;
    final int bNK;
    final int bNL;
    final int bNM;
    
    public a(ad paramad, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
      AppMethodBeat.i(196662);
      this.bKC = paramad;
      this.bNK = paramInt1;
      this.bNL = paramInt2;
      this.bNM = paramInt3;
      if (this.bKC != ad.bNC) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramad = (Throwable)new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
        AppMethodBeat.o(196662);
        throw paramad;
      }
      if (getPageCount() > 0) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramad = (Throwable)new IllegalArgumentException(("Drop count must be > 0, but was " + getPageCount()).toString());
        AppMethodBeat.o(196662);
        throw paramad;
      }
      if (this.bNM >= 0) {}
      for (paramInt1 = i; paramInt1 == 0; paramInt1 = 0)
      {
        paramad = (Throwable)new IllegalArgumentException(("Invalid placeholdersRemaining " + this.bNM).toString());
        AppMethodBeat.o(196662);
        throw paramad;
      }
      AppMethodBeat.o(196662);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196679);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!s.p(this.bKC, paramObject.bKC)) || (this.bNK != paramObject.bNK) || (this.bNL != paramObject.bNL) || (this.bNM != paramObject.bNM)) {}
        }
      }
      else
      {
        AppMethodBeat.o(196679);
        return true;
      }
      AppMethodBeat.o(196679);
      return false;
    }
    
    public final int getPageCount()
    {
      return this.bNL - this.bNK + 1;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(196675);
      ad localad = this.bKC;
      if (localad != null) {}
      for (int i = localad.hashCode();; i = 0)
      {
        int j = this.bNK;
        int k = this.bNL;
        int m = this.bNM;
        AppMethodBeat.o(196675);
        return ((i * 31 + j) * 31 + k) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196670);
      String str = "Drop(loadType=" + this.bKC + ", minPageOffset=" + this.bNK + ", maxPageOffset=" + this.bNL + ", placeholdersRemaining=" + this.bNM + ")";
      AppMethodBeat.o(196670);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageEvent$Insert;", "T", "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "", "placeholdersAfter", "combinedLoadStates", "Landroidx/paging/CombinedLoadStates;", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/CombinedLoadStates;)V", "getCombinedLoadStates", "()Landroidx/paging/CombinedLoadStates;", "getLoadType", "()Landroidx/paging/LoadType;", "getPages", "()Ljava/util/List;", "getPlaceholdersAfter", "()I", "getPlaceholdersBefore", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "filter", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "R", "transform", "", "hashCode", "map", "mapPages", "Lkotlin/Function1;", "toString", "", "transformPages", "transformPages$paging_common", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b<T>
    extends ag<T>
  {
    private static final b<Object> bNP;
    public static final a bNQ;
    final ad bKC;
    final int bMw;
    final int bMx;
    final List<bn<T>> bNN;
    final j bNO;
    
    static
    {
      AppMethodBeat.i(196686);
      bNQ = new a((byte)0);
      Object localObject1 = bn.bRG;
      localObject1 = p.listOf(bn.Ik());
      Object localObject2 = aa.c.bNz;
      localObject2 = (aa)aa.c.HM();
      Object localObject3 = aa.c.bNz;
      localObject3 = (aa)aa.c.HL();
      Object localObject4 = aa.c.bNz;
      localObject4 = (aa)aa.c.HL();
      Object localObject5 = aa.c.bNz;
      localObject5 = (aa)aa.c.HM();
      Object localObject6 = aa.c.bNz;
      localObject6 = (aa)aa.c.HL();
      aa.c.a locala = aa.c.bNz;
      bNP = a.a((List)localObject1, 0, 0, new j((aa)localObject2, (aa)localObject3, (aa)localObject4, new ab((aa)localObject5, (aa)localObject6, (aa)aa.c.HL())));
      AppMethodBeat.o(196686);
    }
    
    private b(ad paramad, List<bn<T>> paramList, int paramInt1, int paramInt2, j paramj)
    {
      super();
      AppMethodBeat.i(196677);
      this.bKC = paramad;
      this.bNN = paramList;
      this.bMw = paramInt1;
      this.bMx = paramInt2;
      this.bNO = paramj;
      if ((this.bKC == ad.bNE) || (this.bMw >= 0)) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramad = (Throwable)new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + this.bMw).toString());
        AppMethodBeat.o(196677);
        throw paramad;
      }
      if ((this.bKC == ad.bND) || (this.bMx >= 0)) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramad = (Throwable)new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + this.bMx).toString());
        AppMethodBeat.o(196677);
        throw paramad;
      }
      if (this.bKC == ad.bNC)
      {
        if (((Collection)this.bNN).isEmpty()) {
          break label233;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label238;
        }
      }
      label233:
      label238:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label243;
        }
        paramad = (Throwable)new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
        AppMethodBeat.o(196677);
        throw paramad;
        paramInt1 = 0;
        break;
      }
      label243:
      AppMethodBeat.o(196677);
    }
    
    public final Object b(m<? super T, ? super kotlin.d.d<? super Boolean>, ? extends Object> paramm, kotlin.d.d<? super ag<T>> paramd)
    {
      AppMethodBeat.i(196717);
      if ((paramd instanceof b))
      {
        localObject1 = (b)paramd;
        if ((((b)localObject1).label & 0x80000000) != 0) {
          ((b)localObject1).label += -2147483648;
        }
      }
      Object localObject6;
      a locala;
      for (paramd = (kotlin.d.d<? super ag<T>>)localObject1;; paramd = new b(this, paramd))
      {
        localObject6 = paramd.result;
        locala = a.aiwj;
        switch (paramd.label)
        {
        default: 
          paramm = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(196717);
          throw paramm;
        }
      }
      ResultKt.throwOnFailure(localObject6);
      Object localObject1 = this.bKC;
      Object localObject3 = (Iterable)this.bNN;
      Object localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      Object localObject4 = ((Iterable)localObject3).iterator();
      localObject3 = paramm;
      b localb = this;
      kotlin.d.d<? super ag<T>> locald = paramd;
      paramd = (kotlin.d.d<? super ag<T>>)localObject4;
      paramm = (m<? super T, ? super kotlin.d.d<? super Boolean>, ? extends Object>)localObject2;
      List localList2;
      List localList1;
      int i;
      Object localObject5;
      label245:
      Object localObject7;
      int k;
      int j;
      if (paramd.hasNext())
      {
        localObject4 = (bn)paramd.next();
        localList2 = (List)new ArrayList();
        localList1 = (List)new ArrayList();
        localObject2 = (Iterable)((bn)localObject4).bMf;
        i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        localObject5 = paramm;
        if (((Iterator)localObject2).hasNext())
        {
          localObject7 = ((Iterator)localObject2).next();
          k = i + 1;
          if (i < 0) {
            p.kkW();
          }
          j = ((Number)Integer.valueOf(i)).intValue();
          locald.L$0 = localObject3;
          locald.Uf = localb;
          locald.VC = localObject1;
          locald.VD = paramm;
          locald.Ze = paramd;
          locald.aqc = localObject4;
          locald.bNS = localList1;
          locald.bNT = localList2;
          locald.bNU = localObject2;
          locald.bNV = localObject7;
          locald.bNW = localObject5;
          locald.aai = k;
          locald.asI = j;
          locald.label = 1;
          localObject6 = ((m)localObject3).invoke(localObject7, locald);
          if (localObject6 != locala) {
            break label680;
          }
          AppMethodBeat.o(196717);
          return locala;
          j = paramd.asI;
          i = paramd.aai;
          localObject5 = (Collection)paramd.bNW;
          localObject7 = paramd.bNV;
          localObject2 = (Iterator)paramd.bNU;
          localList2 = (List)paramd.bNT;
          localList1 = (List)paramd.bNS;
          localObject4 = (bn)paramd.aqc;
          Iterator localIterator = (Iterator)paramd.Ze;
          paramm = (Collection)paramd.VD;
          localObject1 = (ad)paramd.VC;
          localb = (b)paramd.Uf;
          localObject3 = (m)paramd.L$0;
          ResultKt.throwOnFailure(localObject6);
          locald = paramd;
          paramd = localIterator;
        }
      }
      for (;;)
      {
        if (((Boolean)localObject6).booleanValue())
        {
          localList2.add(localObject7);
          localObject6 = ((bn)localObject4).bRE;
          k = j;
          if (localObject6 != null)
          {
            localObject6 = (Integer)((List)localObject6).get(j);
            k = j;
            if (localObject6 != null) {
              k = ((Integer)localObject6).intValue();
            }
          }
          localList1.add(Integer.valueOf(k));
        }
        break label245;
        ((Collection)localObject5).add(new bn(((bn)localObject4).bRC, localList2, ((bn)localObject4).bRD, localList1));
        break;
        paramm = new b((ad)localObject1, (List)paramm, localb.bMw, localb.bMx, localb.bNO, (byte)0);
        AppMethodBeat.o(196717);
        return paramm;
        label680:
        i = k;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196737);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!s.p(this.bKC, paramObject.bKC)) || (!s.p(this.bNN, paramObject.bNN)) || (this.bMw != paramObject.bMw) || (this.bMx != paramObject.bMx) || (!s.p(this.bNO, paramObject.bNO))) {}
        }
      }
      else
      {
        AppMethodBeat.o(196737);
        return true;
      }
      AppMethodBeat.o(196737);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(196729);
      Object localObject = this.bKC;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.bNN;
        if (localObject == null) {
          break label106;
        }
      }
      label106:
      for (int j = localObject.hashCode();; j = 0)
      {
        int m = this.bMw;
        int n = this.bMx;
        localObject = this.bNO;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(196729);
        return (((j + i * 31) * 31 + m) * 31 + n) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196724);
      String str = "Insert(loadType=" + this.bKC + ", pages=" + this.bNN + ", placeholdersBefore=" + this.bMw + ", placeholdersAfter=" + this.bMx + ", combinedLoadStates=" + this.bNO + ")";
      AppMethodBeat.o(196724);
      return str;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageEvent$Insert$Companion;", "", "()V", "EMPTY_REFRESH_LOCAL", "Landroidx/paging/PageEvent$Insert;", "getEMPTY_REFRESH_LOCAL", "()Landroidx/paging/PageEvent$Insert;", "Append", "T", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "combinedLoadStates", "Landroidx/paging/CombinedLoadStates;", "Prepend", "placeholdersBefore", "Refresh", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class a
    {
      public static <T> ag.b<T> a(List<bn<T>> paramList, int paramInt1, int paramInt2, j paramj)
      {
        AppMethodBeat.i(196870);
        s.u(paramList, "pages");
        s.u(paramj, "combinedLoadStates");
        paramList = new ag.b(ad.bNC, paramList, paramInt1, paramInt2, paramj, (byte)0);
        AppMethodBeat.o(196870);
        return paramList;
      }
      
      public static <T> ag.b<T> a(List<bn<T>> paramList, int paramInt, j paramj)
      {
        AppMethodBeat.i(196875);
        s.u(paramList, "pages");
        s.u(paramj, "combinedLoadStates");
        paramList = new ag.b(ad.bND, paramList, paramInt, -1, paramj, (byte)0);
        AppMethodBeat.o(196875);
        return paramList;
      }
      
      public static <T> ag.b<T> b(List<bn<T>> paramList, int paramInt, j paramj)
      {
        AppMethodBeat.i(196880);
        s.u(paramList, "pages");
        s.u(paramj, "combinedLoadStates");
        paramList = new ag.b(ad.bNE, paramList, -1, paramInt, paramj, (byte)0);
        AppMethodBeat.o(196880);
        return paramList;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"filter", "", "T", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "continuation", "Landroidx/paging/PageEvent;"}, k=3, mv={1, 4, 2})
    static final class b
      extends kotlin.d.b.a.d
    {
      Object L$0;
      Object Uf;
      Object VC;
      Object VD;
      Object Ze;
      int aai;
      Object aqc;
      int asI;
      Object bNS;
      Object bNT;
      Object bNU;
      Object bNV;
      Object bNW;
      int label;
      
      b(ag.b paramb, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(196884);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.bNR.b(null, this);
        AppMethodBeat.o(196884);
        return paramObject;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageEvent$LoadStateUpdate;", "T", "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "fromMediator", "", "loadState", "Landroidx/paging/LoadState;", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", "getFromMediator", "()Z", "getLoadState", "()Landroidx/paging/LoadState;", "getLoadType", "()Landroidx/paging/LoadType;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class c<T>
    extends ag<T>
  {
    public static final a bNZ;
    final ad bKC;
    final boolean bNX;
    final aa bNY;
    
    static
    {
      AppMethodBeat.i(196676);
      bNZ = new a((byte)0);
      AppMethodBeat.o(196676);
    }
    
    public c(ad paramad, boolean paramBoolean, aa paramaa)
    {
      super();
      AppMethodBeat.i(196667);
      this.bKC = paramad;
      this.bNX = paramBoolean;
      this.bNY = paramaa;
      if ((this.bKC != ad.bNC) || (this.bNX) || (!(this.bNY instanceof aa.c)) || (!this.bNY.bNv)) {
        i = 1;
      }
      if (i == 0)
      {
        paramad = (Throwable)new IllegalArgumentException("LoadStateUpdate for local REFRESH may not set endOfPaginationReached = true".toString());
        AppMethodBeat.o(196667);
        throw paramad;
      }
      if (!a.a(this.bNY, this.bNX))
      {
        paramad = (Throwable)new IllegalArgumentException("LoadStateUpdates cannot be used to dispatch NotLoading unless it is from remote mediator and remote mediator reached end of pagination.".toString());
        AppMethodBeat.o(196667);
        throw paramad;
      }
      AppMethodBeat.o(196667);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196700);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!s.p(this.bKC, paramObject.bKC)) || (this.bNX != paramObject.bNX) || (!s.p(this.bNY, paramObject.bNY))) {}
        }
      }
      else
      {
        AppMethodBeat.o(196700);
        return true;
      }
      AppMethodBeat.o(196700);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196687);
      String str = "LoadStateUpdate(loadType=" + this.bKC + ", fromMediator=" + this.bNX + ", loadState=" + this.bNY + ")";
      AppMethodBeat.o(196687);
      return str;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageEvent$LoadStateUpdate$Companion;", "", "()V", "canDispatchWithoutInsert", "", "loadState", "Landroidx/paging/LoadState;", "fromMediator", "canDispatchWithoutInsert$paging_common", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class a
    {
      public static boolean a(aa paramaa, boolean paramBoolean)
      {
        AppMethodBeat.i(197165);
        s.u(paramaa, "loadState");
        if (((paramaa instanceof aa.b)) || ((paramaa instanceof aa.a)) || (paramBoolean))
        {
          AppMethodBeat.o(197165);
          return true;
        }
        AppMethodBeat.o(197165);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ag
 * JD-Core Version:    0.7.0.1
 */