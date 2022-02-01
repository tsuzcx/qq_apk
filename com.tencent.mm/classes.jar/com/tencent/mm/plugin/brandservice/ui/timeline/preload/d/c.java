package com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/TransferRequestTokenManager;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;", "()V", "TAG", "", "callbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$GetTokenCallback;", "Lkotlin/collections/ArrayList;", "isGettingToken", "", "tokenCache", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$TokenInfo;", "clearToken", "", "getLocalToken", "getToken", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "getTokenCallback", "onGetTokenFailed", "onGetTokenSuccess", "h5AuthResponse", "Lcom/tencent/mm/protocal/protobuf/H5AuthResponse;", "runTask", "runnable", "Ljava/lang/Runnable;", "saveH5AuthToken", "saveToken", "token", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  public static final c vWh;
  private static a.b vWi;
  private static ArrayList<a.a> vWj;
  private static boolean vWk;
  
  static
  {
    AppMethodBeat.i(303092);
    vWh = new c();
    vWi = new a.b();
    vWj = new ArrayList();
    AppMethodBeat.o(303092);
  }
  
  private static final void a(a.a parama, TransferRequestInfo paramTransferRequestInfo)
  {
    AppMethodBeat.i(303062);
    s.u(parama, "$getTokenCallback");
    s.u(paramTransferRequestInfo, "$requestInfo");
    a.b localb;
    label112:
    Object localObject;
    if (((CharSequence)vWi.vBk).length() == 0)
    {
      i = 1;
      if (i != 0) {
        break label212;
      }
      Log.i("MicroMsg.TransferRequestTokenManager", "getLocalH5AuthToken token: " + vWi.vBk + ", expiredTime: " + vWi.vWe + ", now: " + System.currentTimeMillis());
      localb = vWi;
      if (((CharSequence)localb.vBk).length() <= 0) {
        break label202;
      }
      i = 1;
      if ((i == 0) || (localb.vWe <= 0) || (localb.vWe <= System.currentTimeMillis() / 1000L)) {
        break label207;
      }
      i = 1;
      label141:
      if (i == 0) {
        break label212;
      }
      localb = vWi;
      label149:
      if (localb != null) {
        break label217;
      }
      localObject = null;
      label156:
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label226;
      }
    }
    label202:
    label207:
    label212:
    label217:
    label226:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label231;
      }
      parama.a(localb);
      AppMethodBeat.o(303062);
      return;
      i = 0;
      break;
      i = 0;
      break label112;
      i = 0;
      break label141;
      localb = null;
      break label149;
      localObject = localb.vBk;
      break label156;
    }
    label231:
    if (!vWj.contains(parama)) {
      vWj.add(parama);
    }
    if (!vWk)
    {
      vWk = true;
      Log.v("MicroMsg.TransferRequestTokenManager", "[transferRequest] getToken url: %s, scope: %s, %s", new Object[] { paramTransferRequestInfo.url, paramTransferRequestInfo.scope, paramTransferRequestInfo.vBm });
      parama = new cyb();
      parama.YAb = paramTransferRequestInfo.url;
      parama.aaDe = -520089598;
      parama.scope = paramTransferRequestInfo.scope;
      parama.aaDf = paramTransferRequestInfo.vBm;
      paramTransferRequestInfo = new c.a();
      paramTransferRequestInfo.otE = ((com.tencent.mm.bx.a)parama);
      paramTransferRequestInfo.otF = ((com.tencent.mm.bx.a)new cyc());
      paramTransferRequestInfo.uri = "/cgi-bin/micromsg-bin/h5auth";
      paramTransferRequestInfo.funcId = 5805;
      paramTransferRequestInfo.otG = 0;
      paramTransferRequestInfo.respCmdId = 0;
      z.a(paramTransferRequestInfo.bEF(), c..ExternalSyntheticLambda0.INSTANCE);
    }
    AppMethodBeat.o(303062);
  }
  
  private static final void a(cyc paramcyc)
  {
    AppMethodBeat.i(303074);
    s.u(paramcyc, "$h5AuthResponse");
    Log.i("MicroMsg.TransferRequestTokenManager", "[transferRequest] h5Auth onGetTokenSuccess callback size: %s", new Object[] { Integer.valueOf(vWj.size()) });
    vWk = false;
    Object localObject = (CharSequence)paramcyc.aaDg;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = vWi;
        String str = paramcyc.aaDg;
        s.s(str, "h5AuthResponse.h5authtoken");
        s.u(str, "<set-?>");
        ((a.b)localObject).vBk = str;
        ((a.b)localObject).vWe = paramcyc.aaiS;
        Log.i("MicroMsg.TransferRequestTokenManager", "saveH5AuthToken token: " + vWi.vBk + ", expiredTime: " + vWi.vWe);
      }
      paramcyc = ((Iterable)vWj).iterator();
      while (paramcyc.hasNext()) {
        ((a.a)paramcyc.next()).a(vWi);
      }
    }
    vWj.clear();
    AppMethodBeat.o(303074);
  }
  
  private static final int d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(303067);
    Log.i("MicroMsg.TransferRequestTokenManager", "[transferRequest] h5Auth errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = c.c.b(paramc.otC);
      if ((paramString instanceof cyc)) {}
      for (paramString = (cyc)paramString; paramString != null; paramString = null)
      {
        y(new c..ExternalSyntheticLambda2(paramString));
        AppMethodBeat.o(303067);
        return 0;
      }
    }
    y(c..ExternalSyntheticLambda4.INSTANCE);
    AppMethodBeat.o(303067);
    return 0;
  }
  
  private static final void dgS()
  {
    AppMethodBeat.i(303082);
    Log.e("MicroMsg.TransferRequestTokenManager", "[transferRequest] h5Auth onGetTokenFailed");
    vWk = false;
    vWh.dgR();
    Iterator localIterator = ((Iterable)vWj).iterator();
    while (localIterator.hasNext()) {
      ((a.a)localIterator.next()).a(null);
    }
    vWj.clear();
    AppMethodBeat.o(303082);
  }
  
  private static final void dgT()
  {
    a.b localb = vWi;
    localb.vBk = "";
    localb.vWe = -1;
  }
  
  private static void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(303054);
    h.ahAA.g(paramRunnable, "TransferRequestTokenManager");
    AppMethodBeat.o(303054);
  }
  
  public final void a(TransferRequestInfo paramTransferRequestInfo, a.a parama)
  {
    AppMethodBeat.i(303122);
    s.u(paramTransferRequestInfo, "requestInfo");
    s.u(parama, "getTokenCallback");
    y(new c..ExternalSyntheticLambda1(parama, paramTransferRequestInfo));
    AppMethodBeat.o(303122);
  }
  
  public final void dgR()
  {
    AppMethodBeat.i(303129);
    Log.i("MicroMsg.TransferRequestTokenManager", "clearToken");
    y(c..ExternalSyntheticLambda3.INSTANCE);
    AppMethodBeat.o(303129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.c
 * JD-Core Version:    0.7.0.1
 */