package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.k;
import d.l;
import d.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "waitQueue", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getWaitQueue", "()Ljava/util/LinkedHashMap;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "(Ljava/lang/Object;)Lcom/tencent/mm/protobuf/ByteString;", "getCmdId", "", "handleUpdateResult", "", "retCode", "(Ljava/lang/Object;I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryDoNext", "callback", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;)V", "plugin-finder_release"})
public abstract class d<T>
  implements com.tencent.mm.al.g
{
  private final LinkedHashMap<T, WeakReference<i<T>>> qpW = new LinkedHashMap();
  
  public final void a(T paramT, i<T> parami)
  {
    synchronized (this.qpW)
    {
      ahv localahv = new ahv();
      localahv.cmdId = getCmdId();
      localahv.Dkt = cV(paramT);
      this.qpW.put(paramT, new WeakReference(parami));
      paramT = com.tencent.mm.kernel.g.aeS();
      parami = u.aqO();
      if (parami == null) {
        k.fvU();
      }
      paramT.b((n)new com.tencent.mm.plugin.finder.cgi.v(parami, j.listOf(localahv)));
      return;
    }
  }
  
  public abstract b cV(T paramT);
  
  public abstract int getCmdId();
  
  public abstract String getTAG();
  
  public abstract void h(T paramT, int paramInt);
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int k = 0;
    ad.i(getTAG(), "errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    if (paramn == null) {
      throw new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
    }
    Object localObject1 = ((com.tencent.mm.plugin.finder.cgi.v)paramn).ckQ();
    paramString = ((com.tencent.mm.plugin.finder.cgi.v)paramn).ckP();
    paramn = paramString.iterator();
    int i = 0;
    int j;
    if (paramn.hasNext()) {
      if (((ahv)paramn.next()).cmdId == getCmdId())
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
        paramString = (ahv)j.iz(paramString);
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
      synchronized (this.qpW)
      {
        if (!((Map)this.qpW).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label625;
          }
          Object localObject3 = ((Map)this.qpW).entrySet().iterator();
          paramn = (Map.Entry)((Iterator)localObject3).next();
          paramString = paramn.getKey();
          paramn = (i)((WeakReference)paramn.getValue()).get();
          ((Iterator)localObject3).remove();
          localObject3 = y.JfV;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label572;
          }
          ??? = ((List)localObject1).iterator();
          paramInt1 = 0;
          if (!((Iterator)???).hasNext()) {
            break label567;
          }
          if (((ahw)((Iterator)???).next()).cmdId != getCmdId()) {
            break label555;
          }
          paramInt2 = 1;
          if (paramInt2 == 0) {
            break label560;
          }
          if ((paramInt1 != -1) && (paramString != null))
          {
            h(paramString, ((ahw)((List)localObject1).get(paramInt1)).retCode);
            if (paramn != null) {
              paramn.a(paramString, (ahw)((List)localObject1).get(paramInt1));
            }
          }
          paramString = this.qpW;
          paramInt1 = k;
        }
        try
        {
          if (!((Map)this.qpW).isEmpty()) {
            paramInt1 = 1;
          }
          if (paramInt1 != 0)
          {
            paramn = (Map.Entry)((Map)this.qpW).entrySet().iterator().next();
            a(paramn.getKey(), (i)((WeakReference)paramn.getValue()).get());
          }
          paramn = y.JfV;
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
        localObject1 = new ahw();
        ((ahw)localObject1).cmdId = getCmdId();
        ((ahw)localObject1).retCode = -1;
        paramn.a(paramString, (ahw)localObject1);
        continue;
        label625:
        paramString = null;
        paramn = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.d
 * JD-Core Version:    0.7.0.1
 */