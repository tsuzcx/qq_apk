package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "waitQueue", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getWaitQueue", "()Ljava/util/LinkedHashMap;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "(Ljava/lang/Object;)Lcom/tencent/mm/protobuf/ByteString;", "getCmdId", "", "handleUpdateResult", "", "retCode", "(Ljava/lang/Object;I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryDoNext", "callback", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;)V", "plugin-finder_release"})
public abstract class h<T>
  implements f
{
  private final LinkedHashMap<T, WeakReference<s<T>>> rLi = new LinkedHashMap();
  
  public final void a(T paramT, s<T> params)
  {
    synchronized (this.rLi)
    {
      alo localalo = new alo();
      localalo.cmdId = getCmdId();
      localalo.Glr = da(paramT);
      this.rLi.put(paramT, new WeakReference(params));
      paramT = g.aiU();
      params = u.aAu();
      if (params == null) {
        p.gfZ();
      }
      paramT.b((n)new at(params, j.listOf(localalo)));
      return;
    }
  }
  
  public abstract b da(T paramT);
  
  public abstract int getCmdId();
  
  public abstract String getTAG();
  
  public abstract void l(T paramT, int paramInt);
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int k = 0;
    ad.i(getTAG(), "errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    if (paramn == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
    }
    Object localObject1 = ((at)paramn).cyy();
    paramString = ((at)paramn).cyx();
    paramn = paramString.iterator();
    int i = 0;
    int j;
    if (paramn.hasNext()) {
      if (((alo)paramn.next()).cmdId == getCmdId())
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
        paramString = (alo)j.jd(paramString);
        if (paramString == null) {
          break label205;
        }
      }
    }
    label190:
    label205:
    for (paramString = Integer.valueOf(paramString.cmdId);; paramString = null)
    {
      ad.i(paramn, paramString);
      return;
      j = 0;
      break label122;
      i += 1;
      break;
      i = -1;
      break label127;
    }
    label210:
    ad.i(getTAG(), "retList " + ((List)localObject1).size());
    for (;;)
    {
      synchronized (this.rLi)
      {
        if (!((Map)this.rLi).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label625;
          }
          Object localObject3 = ((Map)this.rLi).entrySet().iterator();
          paramn = (Map.Entry)((Iterator)localObject3).next();
          paramString = paramn.getKey();
          paramn = (s)((WeakReference)paramn.getValue()).get();
          ((Iterator)localObject3).remove();
          localObject3 = z.MKo;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label572;
          }
          ??? = ((List)localObject1).iterator();
          paramInt1 = 0;
          if (!((Iterator)???).hasNext()) {
            break label567;
          }
          if (((alp)((Iterator)???).next()).cmdId != getCmdId()) {
            break label555;
          }
          paramInt2 = 1;
          if (paramInt2 == 0) {
            break label560;
          }
          if ((paramInt1 != -1) && (paramString != null))
          {
            l(paramString, ((alp)((List)localObject1).get(paramInt1)).retCode);
            if (paramn != null) {
              paramn.a(paramString, (alp)((List)localObject1).get(paramInt1));
            }
          }
          paramString = this.rLi;
          paramInt1 = k;
        }
        try
        {
          if (!((Map)this.rLi).isEmpty()) {
            paramInt1 = 1;
          }
          if (paramInt1 != 0)
          {
            paramn = (Map.Entry)((Map)this.rLi).entrySet().iterator().next();
            a(paramn.getKey(), (s)((WeakReference)paramn.getValue()).get());
          }
          paramn = z.MKo;
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
        localObject1 = new alp();
        ((alp)localObject1).cmdId = getCmdId();
        ((alp)localObject1).retCode = -1;
        paramn.a(paramString, (alp)localObject1);
        continue;
        label625:
        paramString = null;
        paramn = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.h
 * JD-Core Version:    0.7.0.1
 */