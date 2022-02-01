package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cz;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "T", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "waitQueue", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "getWaitQueue", "()Ljava/util/LinkedHashMap;", "_tryDoNext", "", "username", "cmdBufItem", "callback", "isMegaVideo", "", "isIgnoreSpam", "(Ljava/lang/String;Ljava/lang/Object;Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;ZZ)V", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/Object;)Lcom/tencent/mm/protobuf/ByteString;", "getCmdId", "", "handleUpdateResult", "retCode", "(Ljava/lang/Object;I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryDoNext", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;ZZ)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class n<T>
  implements com.tencent.mm.am.h
{
  private final LinkedHashMap<T, WeakReference<ck<T>>> AFq = new LinkedHashMap();
  
  private void a(T paramT, ck<T> paramck, boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (this.AFq)
    {
      Object localObject = new auw();
      ((auw)localObject).cmdId = getCmdId();
      ((auw)localObject).ZFn = ff(paramT);
      this.AFq.put(paramT, new WeakReference(paramck));
      paramT = com.tencent.mm.kernel.h.aZW();
      paramck = z.bAW();
      kotlin.g.b.s.checkNotNull(paramck);
      paramck = new cz(paramck, kotlin.a.p.listOf(localObject), paramBoolean1);
      paramck.ACS = paramBoolean2;
      localObject = ah.aiuX;
      paramT.a((com.tencent.mm.am.p)paramck, 0);
      return;
    }
  }
  
  public final void a(String paramString, T paramT, ck<T> paramck)
  {
    kotlin.g.b.s.u(paramString, "username");
    synchronized (this.AFq)
    {
      auw localauw = new auw();
      localauw.cmdId = getCmdId();
      localauw.ZFn = ff(paramT);
      this.AFq.put(paramT, new WeakReference(paramck));
      paramT = com.tencent.mm.kernel.h.aZW();
      paramString = new cz(paramString, kotlin.a.p.listOf(localauw), false);
      paramString.ACS = false;
      paramck = ah.aiuX;
      paramT.a((com.tencent.mm.am.p)paramString, 0);
      return;
    }
  }
  
  public abstract b ff(T paramT);
  
  public abstract int getCmdId();
  
  public abstract String getTAG();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int k = 0;
    Log.i(getTAG(), "errType " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString);
    if (paramp == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
    }
    Object localObject1 = ((cz)paramp).dWp();
    paramString = ((cz)paramp).dWo();
    paramp = paramString.iterator();
    int i = 0;
    int j;
    if (paramp.hasNext()) {
      if (((auw)paramp.next()).cmdId == getCmdId())
      {
        j = 1;
        label122:
        if (j == 0) {
          break label170;
        }
        label127:
        if (i >= 0) {
          break label196;
        }
        paramp = getTAG();
        paramString = (auw)kotlin.a.p.oL(paramString);
        if (paramString != null) {
          break label185;
        }
      }
    }
    label170:
    label185:
    for (paramString = null;; paramString = Integer.valueOf(paramString.cmdId))
    {
      Log.i(paramp, kotlin.g.b.s.X("not cares cmdId: ", paramString));
      return;
      j = 0;
      break label122;
      i += 1;
      break;
      i = -1;
      break label127;
    }
    label196:
    Log.i(getTAG(), kotlin.g.b.s.X("retList ", Integer.valueOf(((List)localObject1).size())));
    label653:
    for (;;)
    {
      synchronized (this.AFq)
      {
        if (!((Map)this.AFq).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label653;
          }
          Object localObject3 = ((Map)this.AFq).entrySet().iterator();
          paramp = (Map.Entry)((Iterator)localObject3).next();
          paramString = paramp.getKey();
          paramp = ((WeakReference)paramp.getValue()).get();
          ((Iterator)localObject3).remove();
          localObject3 = ah.aiuX;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label588;
          }
          ??? = ((List)localObject1).iterator();
          paramInt1 = 0;
          if (!((Iterator)???).hasNext()) {
            break label583;
          }
          if (((aux)((Iterator)???).next()).cmdId != getCmdId()) {
            break label571;
          }
          paramInt2 = 1;
          if (paramInt2 == 0) {
            break label576;
          }
          if ((paramInt1 != -1) && (paramString != null))
          {
            Log.i("NetSceneFinderOplog", kotlin.g.b.s.X("handleUpdateResult ", Integer.valueOf(((aux)((List)localObject1).get(paramInt1)).retCode)));
            u(paramString, ((aux)((List)localObject1).get(paramInt1)).retCode);
            paramp = (ck)paramp;
            if (paramp != null) {
              paramp.a(paramString, (aux)((List)localObject1).get(paramInt1));
            }
          }
          paramString = this.AFq;
          paramInt1 = k;
        }
        try
        {
          if (!((Map)this.AFq).isEmpty()) {
            paramInt1 = 1;
          }
          if (paramInt1 != 0)
          {
            paramp = (Map.Entry)((Map)this.AFq).entrySet().iterator().next();
            a(this, paramp.getKey(), (ck)((WeakReference)paramp.getValue()).get(), false, false, 12);
          }
          paramp = ah.aiuX;
          return;
        }
        finally {}
        i = 0;
      }
      label571:
      paramInt2 = 0;
      continue;
      label576:
      paramInt1 += 1;
      continue;
      label583:
      paramInt1 = -1;
      continue;
      label588:
      if (paramString != null)
      {
        paramp = (ck)paramp;
        if (paramp != null)
        {
          localObject1 = new aux();
          ((aux)localObject1).cmdId = getCmdId();
          ((aux)localObject1).retCode = -1;
          ??? = ah.aiuX;
          paramp.a(paramString, (aux)localObject1);
          continue;
          paramString = null;
          paramp = null;
        }
      }
    }
  }
  
  public abstract void u(T paramT, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.oplog.n
 * JD-Core Version:    0.7.0.1
 */