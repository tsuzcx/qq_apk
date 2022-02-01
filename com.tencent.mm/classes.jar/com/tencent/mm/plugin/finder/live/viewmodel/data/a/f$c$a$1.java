package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import com.tencent.d.a.a.a.b.c.b;
import com.tencent.d.a.a.a.b.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class f$c$a$1
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  f$c$a$1(f.c paramc, boolean paramBoolean, com.tencent.mm.bx.b paramb, List<? extends bdm> paramList1, List<? extends bdm> paramList2, List<? extends anb> paramList, d<? super 1> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(371629);
    paramObject = (d)new 1(this.akgx, this.akgy, this.AEL, this.EZy, this.akgz, this.akgA, paramd);
    AppMethodBeat.o(371629);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(371624);
    Object localObject1 = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(371624);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    f.c localc = this.akgx;
    boolean bool = this.akgy;
    Object localObject5 = this.AEL;
    Object localObject4 = this.EZy;
    List localList2 = this.akgz;
    List localList1 = this.akgA;
    Object localObject2 = localc.akgw;
    localObject1 = localc.Don.id;
    paramObject = localObject1;
    if (localObject1 == null) {
      paramObject = "";
    }
    localObject2 = ((f)localObject2).bkJ(paramObject);
    if (localObject2 != null)
    {
      Object localObject3 = localc.akgw.akgp;
      localObject1 = localc.Don.id;
      paramObject = localObject1;
      if (localObject1 == null) {
        paramObject = "";
      }
      localObject3 = (f.a)((ConcurrentHashMap)localObject3).get(paramObject);
      int i;
      if (bool)
      {
        localc.akgv.akjP.clear();
        i = ((h)localObject2).pUj.size();
        ((h)localObject2).pUj.clear();
        if ((i > 0) && (localObject3 != null))
        {
          localObject1 = localc.Don.id;
          paramObject = localObject1;
          if (localObject1 == null) {
            paramObject = "";
          }
          ((f.a)localObject3).b(new f.d(paramObject, 0, i, null));
        }
      }
      localc.akgv.ZEQ = ((com.tencent.mm.bx.b)localObject5);
      localObject1 = new ArrayList();
      paramObject = new ArrayList();
      Object localObject6 = (Iterable)((h)localObject2).pUj;
      localObject5 = (Collection)new ArrayList();
      localObject6 = ((Iterable)localObject6).iterator();
      Object localObject7;
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = ((Iterator)localObject6).next();
        if (((b)localObject7).hJv) {
          ((Collection)localObject5).add(localObject7);
        }
      }
      localObject5 = (List)localObject5;
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (bdm)((Iterator)localObject4).next();
        localObject7 = (CharSequence)((bdm)localObject6).ZOc;
        if ((localObject7 == null) || (((CharSequence)localObject7).length() == 0))
        {
          i = 1;
          label422:
          if (i != 0) {
            break label505;
          }
          localObject7 = ((List)localObject5).iterator();
          i = 0;
          label437:
          if (!((Iterator)localObject7).hasNext()) {
            break label500;
          }
          if (!s.p(((b)((Iterator)localObject7).next()).akfZ.Tro, ((bdm)localObject6).ZOc)) {
            break label493;
          }
        }
        for (;;)
        {
          if (i < 0) {
            break label505;
          }
          paramObject.add(localObject6);
          break;
          i = 0;
          break label422;
          label493:
          i += 1;
          break label437;
          label500:
          i = -1;
        }
        label505:
        ((ArrayList)localObject1).add(localObject6);
      }
      localObject4 = f.akgm;
      Log.i(f.access$getTAG$cp(), "curSize:" + ((h)localObject2).pUj.size() + ", svr selfPostList:" + paramObject.size() + ", appendList:" + ((ArrayList)localObject1).size() + ", updateList:" + localList2.size() + ", bulletList:" + localList1.size());
      localObject4 = ((Iterable)paramObject).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (bdm)((Iterator)localObject4).next();
        paramObject = (List)((h)localObject2).pUj;
        i = 0;
        paramObject = paramObject.iterator();
        label661:
        label696:
        label767:
        Object localObject8;
        int j;
        if (paramObject.hasNext()) {
          if (s.p(((b)paramObject.next()).akfZ.Tro, ((bdm)localObject6).ZOc))
          {
            if (i < 0) {
              break label1031;
            }
            localObject5 = (b)p.ae((List)((h)localObject2).pUj, i);
            if (localObject5 == null) {
              continue;
            }
            s.u(localObject6, "<set-?>");
            ((b)localObject5).akfZ = ((bdm)localObject6);
            ((b)localObject5).hJv = false;
            paramObject = localc.akgv.akjP;
            if (paramObject != null)
            {
              localObject7 = ((Iterable)paramObject).iterator();
              if (!((Iterator)localObject7).hasNext()) {
                break label1038;
              }
              paramObject = ((Iterator)localObject7).next();
              localObject8 = (anf)paramObject;
              long l = ((b)localObject5).akfZ.seq;
              localObject8 = ((anf)localObject8).akfZ;
              if ((localObject8 == null) || (l != ((bdm)localObject8).seq)) {
                break label1033;
              }
              j = 1;
              label826:
              if (j == 0) {
                break label1036;
              }
              label830:
              localObject7 = (anf)paramObject;
              if (localObject7 != null)
              {
                ((anf)localObject7).akfZ = ((bdm)localObject6);
                ((anf)localObject7).hJv = false;
                paramObject = bq.akii;
                paramObject = f.akgm;
                localObject6 = f.access$getTAG$cp();
                localObject8 = new StringBuilder("updateBySvr, seq:");
                paramObject = ((anf)localObject7).akfZ;
                if (paramObject != null) {
                  break label1043;
                }
                paramObject = null;
                label891:
                localObject8 = ((StringBuilder)localObject8).append(paramObject).append(", client_msg_id:");
                paramObject = ((anf)localObject7).akfZ;
                if (paramObject != null) {
                  break label1054;
                }
              }
            }
          }
        }
        label1031:
        label1033:
        label1036:
        label1038:
        label1043:
        label1054:
        for (paramObject = null;; paramObject = paramObject.ZOc)
        {
          bq.rQ((String)localObject6, paramObject);
          f.bkK(s.X("local update to svr, ", ((b)localObject5).eYN()));
          f.bkK("notifier update index:" + i + ", msg:" + ((b)localObject5).eYN());
          if (localObject3 == null) {
            break;
          }
          paramObject = ((h)localObject2).adma;
          localObject5 = c.b.aknb;
          ((f.a)localObject3).c(new f.d(paramObject, i, 1, Integer.valueOf(c.b.a.kMJ())));
          break;
          i += 1;
          break label661;
          i = -1;
          break label696;
          break;
          j = 0;
          break label826;
          break label767;
          paramObject = null;
          break label830;
          paramObject = Long.valueOf(paramObject.seq);
          break label891;
        }
      }
      localObject1 = (Iterable)localObject1;
      paramObject = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (bdm)((Iterator)localObject1).next();
        localObject5 = f.akgm;
        paramObject.add(f.b.d((bdm)localObject4));
      }
      f.a("polling", p.l((Iterable)paramObject), localc.akgv, (h)localObject2, (f.a)localObject3);
      paramObject = ((Iterable)localList2).iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (bdm)paramObject.next();
        f.a("svr", localc.akgv, (h)localObject2, (bdm)localObject1, (f.a)localObject3);
      }
      paramObject = localc.Don.id;
      if (paramObject != null) {
        localc.akgw.akgn.ac(paramObject, localList1);
      }
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(371624);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.f.c.a.1
 * JD-Core Version:    0.7.0.1
 */