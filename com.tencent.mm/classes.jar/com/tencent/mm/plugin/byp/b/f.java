package com.tencent.mm.plugin.byp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.byp.a.a;
import com.tencent.mm.plugin.byp.c.b;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BypSyncResponse;", "selector", "", "", "source", "Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "(Ljava/util/List;Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;)V", "request", "Lcom/tencent/mm/protocal/protobuf/BypSyncRequest;", "getSource", "()Lcom/tencent/mm/plugin/byp/BypSyncCore$SyncSource;", "mergeSyncKey", "", "req", "Lcom/tencent/mm/protocal/protobuf/BypSyncKeyBuff;", "resp", "onCgiBack", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onFailed", "onSuccessfully", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "print", "Companion", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b<uf>
{
  public static final a waR;
  private final c.b waS;
  private final ue waT;
  
  static
  {
    AppMethodBeat.i(272017);
    waR = new a((byte)0);
    AppMethodBeat.o(272017);
  }
  
  public f(List<Integer> paramList, c.b paramb)
  {
    AppMethodBeat.i(271991);
    this.waS = paramb;
    this.waT = new ue();
    paramb = new c.a();
    Object localObject1 = this.waT;
    Object localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      int i = ((Number)localObject3).intValue();
      a.a locala = a.a.wab;
      if (a.a.dii().contains(Integer.valueOf(i))) {
        paramList.add(localObject3);
      }
    }
    ((ue)localObject1).YZj = new LinkedList((Collection)paramList);
    com.tencent.mm.kernel.h.baE().ban().get(at.a.adci, "");
    paramList = com.tencent.mm.kernel.h.baE().ban().get(at.a.adci, "");
    if (paramList == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(271991);
      throw paramList;
    }
    paramList = Util.decodeHexString((String)paramList);
    localObject1 = this.waT;
    localObject2 = new uc();
    ((uc)localObject2).parseFrom(paramList);
    Object localObject3 = ah.aiuX;
    ((ue)localObject1).YZQ = ((uc)localObject2);
    this.waT.scene = this.waS.value;
    paramb.otE = ((a)this.waT);
    localObject1 = new uf();
    ((uf)localObject1).setBaseResponse(new kd());
    ((uf)localObject1).getBaseResponse().akjO = new etl();
    paramb.otF = ((a)localObject1);
    paramb.uri = "/cgi-bin/micromsg-bin/bypsync";
    paramb.funcId = 3673;
    c(paramb.bEF());
    Log.i("Byp.CgiBypSync", "[CgiBypSync] selector=" + this.waT.YZj + " scene=" + this.waS.value + " size=" + paramList.length);
    AppMethodBeat.o(271991);
  }
  
  private static String a(uc paramuc)
  {
    AppMethodBeat.i(272009);
    s.u(paramuc, "<this>");
    StringBuilder localStringBuilder = new StringBuilder();
    paramuc = paramuc.YZN;
    s.s(paramuc, "sync_key_pair_list");
    paramuc = ((Iterable)paramuc).iterator();
    while (paramuc.hasNext())
    {
      ud localud = (ud)paramuc.next();
      localStringBuilder.append(localud.YZO).append("=").append(localud.YZP).append(", ");
    }
    paramuc = localStringBuilder.toString();
    s.s(paramuc, "ss.toString()");
    AppMethodBeat.o(272009);
    return paramuc;
  }
  
  private static boolean a(uc paramuc1, uc paramuc2)
  {
    AppMethodBeat.i(272002);
    Object localObject2 = new StringBuilder("[mergeSyncKey] req: ").append(a(paramuc1)).append(" resp: ");
    Object localObject1;
    int j;
    int i;
    boolean bool1;
    if (paramuc2 == null)
    {
      localObject1 = null;
      Log.i("Byp.CgiBypSync", localObject1);
      boolean bool2 = false;
      j = 0;
      i = j;
      bool1 = bool2;
      if (paramuc2 == null) {
        break label393;
      }
      paramuc2 = paramuc2.YZN;
      i = j;
      bool1 = bool2;
      if (paramuc2 == null) {
        break label393;
      }
      localObject1 = ((Iterable)paramuc2).iterator();
      i = 0;
      bool1 = false;
      label100:
      if (!((Iterator)localObject1).hasNext()) {
        break label393;
      }
      localObject2 = (ud)((Iterator)localObject1).next();
      paramuc2 = paramuc1.YZN;
      s.s(paramuc2, "req.sync_key_pair_list");
      Iterator localIterator = ((Iterable)paramuc2).iterator();
      label145:
      if (!localIterator.hasNext()) {
        break label268;
      }
      paramuc2 = localIterator.next();
      if (((ud)paramuc2).YZO != ((ud)localObject2).YZO) {
        break label263;
      }
      j = 1;
      label180:
      if (j == 0) {
        break label266;
      }
    }
    for (;;)
    {
      paramuc2 = (ud)paramuc2;
      if (paramuc2 != null) {
        break label273;
      }
      paramuc2 = null;
      if (paramuc2 == null)
      {
        i = 1;
        Log.i("Byp.CgiBypSync", "[mergeSyncKey] insert " + ((ud)localObject2).YZO + '=' + ((ud)localObject2).YZP);
        paramuc1.YZN.add(localObject2);
      }
      break label100;
      localObject1 = a(paramuc2);
      break;
      label263:
      j = 0;
      break label180;
      label266:
      break label145;
      label268:
      paramuc2 = null;
    }
    label273:
    if (paramuc2.YZP < ((ud)localObject2).YZP)
    {
      paramuc2.YZP = ((ud)localObject2).YZP;
      bool1 = true;
      Log.i("Byp.CgiBypSync", "[mergeSyncKey] modify " + ((ud)localObject2).YZO + '=' + ((ud)localObject2).YZP);
    }
    for (;;)
    {
      paramuc2 = ah.aiuX;
      break;
      Log.e("Byp.CgiBypSync", "[mergeSyncKey] value(" + ((ud)localObject2).YZP + ") is invalid, client value=" + paramuc2.YZP + ' ');
    }
    label393:
    if ((bool1) || (i != 0)) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adci, Util.encodeHexString(paramuc1.toByteArray()));
    }
    AppMethodBeat.o(272002);
    return bool1;
  }
  
  public final com.tencent.mm.cp.f<b.a<uf>> bFJ()
  {
    AppMethodBeat.i(272023);
    com.tencent.mm.plugin.report.service.h.OAn.p(1465L, this.waS.value, 1L);
    com.tencent.mm.cp.f localf = super.bFJ();
    s.s(localf, "super.run()");
    AppMethodBeat.o(272023);
    return localf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/cgi/CgiBypSync$Companion;", "", "()V", "TAG", "", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.b.f
 * JD-Core Version:    0.7.0.1
 */