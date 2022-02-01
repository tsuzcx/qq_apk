package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "waitQueue", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getWaitQueue", "()Ljava/util/LinkedHashMap;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "(Ljava/lang/Object;)Lcom/tencent/mm/protobuf/ByteString;", "getCmdId", "", "handleUpdateResult", "", "retCode", "(Ljava/lang/Object;I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryDoNext", "callback", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;)V", "plugin-finder_release"})
public abstract class h<T>
  implements f
{
  private final LinkedHashMap<T, WeakReference<s<T>>> rTw = new LinkedHashMap();
  
  public final void a(T paramT, s<T> params)
  {
    synchronized (this.rTw)
    {
      ama localama = new ama();
      localama.cmdId = getCmdId();
      localama.GEu = db(paramT);
      this.rTw.put(paramT, new WeakReference(params));
      paramT = g.ajj();
      params = com.tencent.mm.model.v.aAK();
      if (params == null) {
        p.gkB();
      }
      paramT.b((n)new au(params, j.listOf(localama)));
      return;
    }
  }
  
  public abstract b db(T paramT);
  
  public abstract int getCmdId();
  
  public abstract String getTAG();
  
  public abstract void l(T paramT, int paramInt);
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int k = 0;
    ae.i(getTAG(), "errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    if (paramn == null) {
      throw new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
    }
    Object localObject1 = ((au)paramn).czZ();
    paramString = ((au)paramn).czY();
    paramn = paramString.iterator();
    int i = 0;
    int j;
    if (paramn.hasNext()) {
      if (((ama)paramn.next()).cmdId == getCmdId())
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
        paramString = (ama)j.jm(paramString);
        if (paramString == null) {
          break label205;
        }
      }
    }
    label190:
    label205:
    for (paramString = Integer.valueOf(paramString.cmdId);; paramString = null)
    {
      ae.i(paramn, paramString);
      return;
      j = 0;
      break label122;
      i += 1;
      break;
      i = -1;
      break label127;
    }
    label210:
    ae.i(getTAG(), "retList " + ((List)localObject1).size());
    for (;;)
    {
      synchronized (this.rTw)
      {
        if (!((Map)this.rTw).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label625;
          }
          Object localObject3 = ((Map)this.rTw).entrySet().iterator();
          paramn = (Map.Entry)((Iterator)localObject3).next();
          paramString = paramn.getKey();
          paramn = (s)((WeakReference)paramn.getValue()).get();
          ((Iterator)localObject3).remove();
          localObject3 = z.Nhr;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label572;
          }
          ??? = ((List)localObject1).iterator();
          paramInt1 = 0;
          if (!((Iterator)???).hasNext()) {
            break label567;
          }
          if (((amb)((Iterator)???).next()).cmdId != getCmdId()) {
            break label555;
          }
          paramInt2 = 1;
          if (paramInt2 == 0) {
            break label560;
          }
          if ((paramInt1 != -1) && (paramString != null))
          {
            l(paramString, ((amb)((List)localObject1).get(paramInt1)).retCode);
            if (paramn != null) {
              paramn.a(paramString, (amb)((List)localObject1).get(paramInt1));
            }
          }
          paramString = this.rTw;
          paramInt1 = k;
        }
        try
        {
          if (!((Map)this.rTw).isEmpty()) {
            paramInt1 = 1;
          }
          if (paramInt1 != 0)
          {
            paramn = (Map.Entry)((Map)this.rTw).entrySet().iterator().next();
            a(paramn.getKey(), (s)((WeakReference)paramn.getValue()).get());
          }
          paramn = z.Nhr;
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
        localObject1 = new amb();
        ((amb)localObject1).cmdId = getCmdId();
        ((amb)localObject1).retCode = -1;
        paramn.a(paramString, (amb)localObject1);
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