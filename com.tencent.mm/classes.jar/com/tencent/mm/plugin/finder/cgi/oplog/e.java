package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.l;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "waitQueue", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getWaitQueue", "()Ljava/util/LinkedHashMap;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "(Ljava/lang/Object;)Lcom/tencent/mm/protobuf/ByteString;", "getCmdId", "", "handleUpdateResult", "", "retCode", "(Ljava/lang/Object;I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryDoNext", "callback", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;)V", "plugin-finder_release"})
public abstract class e<T>
  implements com.tencent.mm.ak.g
{
  private final LinkedHashMap<T, WeakReference<com.tencent.mm.plugin.i.a.k<T>>> qZD = new LinkedHashMap();
  
  public final void a(T paramT, com.tencent.mm.plugin.i.a.k<T> paramk)
  {
    synchronized (this.qZD)
    {
      aiy localaiy = new aiy();
      localaiy.cmdId = getCmdId();
      localaiy.EDH = cW(paramT);
      this.qZD.put(paramT, new WeakReference(paramk));
      paramT = com.tencent.mm.kernel.g.agi();
      paramk = u.axE();
      if (paramk == null) {
        d.g.b.k.fOy();
      }
      paramT.b((n)new am(paramk, j.listOf(localaiy)));
      return;
    }
  }
  
  public abstract b cW(T paramT);
  
  public abstract int getCmdId();
  
  public abstract String getTAG();
  
  public abstract void k(T paramT, int paramInt);
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int k = 0;
    ac.i(getTAG(), "errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    if (paramn == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
    }
    Object localObject1 = ((am)paramn).csH();
    paramString = ((am)paramn).csG();
    paramn = paramString.iterator();
    int i = 0;
    int j;
    if (paramn.hasNext()) {
      if (((aiy)paramn.next()).cmdId == getCmdId())
      {
        j = 1;
        label122:
        if (j == 0) {
          break label190;
        }
        label127:
        if (i >= 0) {
          break label210;
        }
        paramn = getTAG();
        localObject1 = new StringBuilder("not cares cmdId: ");
        paramString = (aiy)j.iP(paramString);
        if (paramString == null) {
          break label205;
        }
      }
    }
    label190:
    label205:
    for (paramString = Integer.valueOf(paramString.cmdId);; paramString = null)
    {
      ac.i(paramn, paramString);
      return;
      j = 0;
      break label122;
      i += 1;
      break;
      i = -1;
      break label127;
    }
    label210:
    ac.i(getTAG(), "retList " + ((List)localObject1).size());
    for (;;)
    {
      synchronized (this.qZD)
      {
        if (!((Map)this.qZD).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label625;
          }
          Object localObject3 = ((Map)this.qZD).entrySet().iterator();
          paramn = (Map.Entry)((Iterator)localObject3).next();
          paramString = paramn.getKey();
          paramn = (com.tencent.mm.plugin.i.a.k)((WeakReference)paramn.getValue()).get();
          ((Iterator)localObject3).remove();
          localObject3 = y.KTp;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label572;
          }
          ??? = ((List)localObject1).iterator();
          paramInt1 = 0;
          if (!((Iterator)???).hasNext()) {
            break label567;
          }
          if (((aiz)((Iterator)???).next()).cmdId != getCmdId()) {
            break label555;
          }
          paramInt2 = 1;
          if (paramInt2 == 0) {
            break label560;
          }
          if ((paramInt1 != -1) && (paramString != null))
          {
            k(paramString, ((aiz)((List)localObject1).get(paramInt1)).retCode);
            if (paramn != null) {
              paramn.a(paramString, (aiz)((List)localObject1).get(paramInt1));
            }
          }
          paramString = this.qZD;
          paramInt1 = k;
        }
        try
        {
          if (!((Map)this.qZD).isEmpty()) {
            paramInt1 = 1;
          }
          if (paramInt1 != 0)
          {
            paramn = (Map.Entry)((Map)this.qZD).entrySet().iterator().next();
            a(paramn.getKey(), (com.tencent.mm.plugin.i.a.k)((WeakReference)paramn.getValue()).get());
          }
          paramn = y.KTp;
          return;
        }
        finally {}
        i = 0;
      }
      label555:
      paramInt2 = 0;
      continue;
      label560:
      paramInt1 += 1;
      continue;
      label567:
      paramInt1 = -1;
      continue;
      label572:
      if ((paramString != null) && (paramn != null))
      {
        localObject1 = new aiz();
        ((aiz)localObject1).cmdId = getCmdId();
        ((aiz)localObject1).retCode = -1;
        paramn.a(paramString, (aiz)localObject1);
        continue;
        label625:
        paramString = null;
        paramn = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.e
 * JD-Core Version:    0.7.0.1
 */