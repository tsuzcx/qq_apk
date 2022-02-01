package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "waitQueue", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getWaitQueue", "()Ljava/util/LinkedHashMap;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "cmdBufItem", "(Ljava/lang/Object;)Lcom/tencent/mm/protobuf/ByteString;", "getCmdId", "", "handleUpdateResult", "", "retCode", "(Ljava/lang/Object;I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryDoNext", "callback", "isMegaVideo", "", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;Z)V", "plugin-finder_release"})
public abstract class k<T>
  implements i
{
  private final LinkedHashMap<T, WeakReference<ai<T>>> txP = new LinkedHashMap();
  
  public final void a(T paramT, ai<T> paramai, boolean paramBoolean)
  {
    synchronized (this.txP)
    {
      apf localapf = new apf();
      localapf.cmdId = getCmdId();
      localapf.LBo = di(paramT);
      this.txP.put(paramT, new WeakReference(paramai));
      paramT = g.azz();
      paramai = z.aUg();
      if (paramai == null) {
        p.hyc();
      }
      paramT.b((q)new bx(paramai, j.listOf(localapf), paramBoolean));
      return;
    }
  }
  
  public abstract b di(T paramT);
  
  public abstract int getCmdId();
  
  public abstract String getTAG();
  
  public abstract void n(T paramT, int paramInt);
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int k = 0;
    Log.i(getTAG(), "errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    if (paramq == null) {
      throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
    }
    Object localObject1 = ((bx)paramq).cYN();
    paramString = ((bx)paramq).cYM();
    paramq = paramString.iterator();
    int i = 0;
    int j;
    if (paramq.hasNext()) {
      if (((apf)paramq.next()).cmdId == getCmdId())
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
        paramq = getTAG();
        localObject1 = new StringBuilder("not cares cmdId: ");
        paramString = (apf)j.kt(paramString);
        if (paramString == null) {
          break label205;
        }
      }
    }
    label190:
    label205:
    for (paramString = Integer.valueOf(paramString.cmdId);; paramString = null)
    {
      Log.i(paramq, paramString);
      return;
      j = 0;
      break label122;
      i += 1;
      break;
      i = -1;
      break label127;
    }
    label210:
    Log.i(getTAG(), "retList " + ((List)localObject1).size());
    for (;;)
    {
      synchronized (this.txP)
      {
        if (!((Map)this.txP).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label626;
          }
          Object localObject3 = ((Map)this.txP).entrySet().iterator();
          paramq = (Map.Entry)((Iterator)localObject3).next();
          paramString = paramq.getKey();
          paramq = (ai)((WeakReference)paramq.getValue()).get();
          ((Iterator)localObject3).remove();
          localObject3 = x.SXb;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label573;
          }
          ??? = ((List)localObject1).iterator();
          paramInt1 = 0;
          if (!((Iterator)???).hasNext()) {
            break label568;
          }
          if (((apg)((Iterator)???).next()).cmdId != getCmdId()) {
            break label556;
          }
          paramInt2 = 1;
          if (paramInt2 == 0) {
            break label561;
          }
          if ((paramInt1 != -1) && (paramString != null))
          {
            n(paramString, ((apg)((List)localObject1).get(paramInt1)).retCode);
            if (paramq != null) {
              paramq.a(paramString, (apg)((List)localObject1).get(paramInt1));
            }
          }
          paramString = this.txP;
          paramInt1 = k;
        }
        try
        {
          if (!((Map)this.txP).isEmpty()) {
            paramInt1 = 1;
          }
          if (paramInt1 != 0)
          {
            paramq = (Map.Entry)((Map)this.txP).entrySet().iterator().next();
            a(paramq.getKey(), (ai)((WeakReference)paramq.getValue()).get(), false);
          }
          paramq = x.SXb;
          return;
        }
        finally {}
        i = 0;
      }
      label556:
      paramInt2 = 0;
      continue;
      label561:
      paramInt1 += 1;
      continue;
      label568:
      paramInt1 = -1;
      continue;
      label573:
      if ((paramString != null) && (paramq != null))
      {
        localObject1 = new apg();
        ((apg)localObject1).cmdId = getCmdId();
        ((apg)localObject1).retCode = -1;
        paramq.a(paramString, (apg)localObject1);
        continue;
        label626:
        paramString = null;
        paramq = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.k
 * JD-Core Version:    0.7.0.1
 */