package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g.c;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements f
{
  public int evn;
  public List<WeakReference<g.a>> kkV;
  public com.tencent.mm.plugin.card.d.c klr;
  public ap kls;
  
  public g()
  {
    AppMethodBeat.i(87681);
    this.kkV = new ArrayList();
    this.kls = new ap(new g.1(this), false);
    AppMethodBeat.o(87681);
  }
  
  private void I(LinkedList<bjj> paramLinkedList)
  {
    AppMethodBeat.i(87692);
    com.tencent.mm.kernel.g.RK().eHt.a(1275, this);
    paramLinkedList = new com.tencent.mm.plugin.card.model.ah(paramLinkedList);
    com.tencent.mm.kernel.g.RK().eHt.a(paramLinkedList, 0);
    AppMethodBeat.o(87692);
  }
  
  private void a(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(87698);
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87698);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (g.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((g.a)localObject).c(paramc);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87698);
  }
  
  private void a(bpi parambpi)
  {
    AppMethodBeat.i(87694);
    if (parambpi == null)
    {
      AppMethodBeat.o(87694);
      return;
    }
    String str = parambpi.cHn;
    Object localObject;
    if (am.bcs().HK(str) == null)
    {
      localObject = b(parambpi);
      am.bcs().insert((com.tencent.mm.sdk.e.c)localObject);
    }
    for (;;)
    {
      localObject = am.bcr().HL(str);
      if ((!((List)localObject).isEmpty()) && (am.bcr().qD(str)) && (this.klr != null)) {
        a(str, (List)localObject, this.klr);
      }
      parambpi = parambpi.xDv.iterator();
      while (parambpi.hasNext())
      {
        localObject = (bph)parambpi.next();
        k localk = new k();
        localk.field_card_id = str;
        localk.field_code_id = ((bph)localObject).knW;
        localk.field_code = e.dw(str, ((bph)localObject).data);
        am.bcr().insert(localk);
      }
      localObject = b(parambpi);
      am.bcs().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    }
    AppMethodBeat.o(87694);
  }
  
  private void a(String paramString, q paramq)
  {
    AppMethodBeat.i(87689);
    Object localObject = new StringBuilder("doNetSceneGetDynamicQrcode, cardId:").append(paramString).append(",scene :");
    if (paramq == null)
    {
      i = 0;
      ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", i);
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramString);
      if (paramq != null) {
        break label117;
      }
    }
    label117:
    for (int i = 0;; i = paramq.scene)
    {
      paramString = new ae((LinkedList)localObject, i);
      com.tencent.mm.kernel.g.RK().eHt.a(1382, this);
      com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
      AppMethodBeat.o(87689);
      return;
      i = paramq.scene;
      break;
    }
  }
  
  private void a(String paramString, List<k> paramList, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(87690);
    if (paramc == null)
    {
      ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
      AppMethodBeat.o(87690);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList.add(b(paramString, ((k)paramList.next()).field_code_id, paramc));
    }
    I(localLinkedList);
    AppMethodBeat.o(87690);
  }
  
  public static boolean a(i parami)
  {
    AppMethodBeat.i(87686);
    if (System.currentTimeMillis() - parami.field_fetch_time > parami.field_expire_time_interval * 1000)
    {
      ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(parami.field_fetch_time), Integer.valueOf(parami.field_expire_time_interval) });
      AppMethodBeat.o(87686);
      return true;
    }
    AppMethodBeat.o(87686);
    return false;
  }
  
  private static i b(bpi parambpi)
  {
    AppMethodBeat.i(87695);
    i locali = new i();
    locali.field_card_id = parambpi.cHn;
    locali.field_lower_bound = parambpi.xDq;
    locali.field_expire_time_interval = parambpi.xDt;
    locali.field_need_insert_show_timestamp = parambpi.xDr;
    locali.field_show_expire_interval = parambpi.xDu;
    locali.field_show_timestamp_encrypt_key = parambpi.xDs;
    locali.field_fetch_time = System.currentTimeMillis();
    AppMethodBeat.o(87695);
    return locali;
  }
  
  private static bjj b(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(87693);
    bjj localbjj = new bjj();
    localbjj.cHn = paramString1;
    localbjj.knW = paramString2;
    localbjj.xxP = new Long(System.currentTimeMillis() / 1000L).intValue();
    if (paramc == null) {}
    for (int i = -1;; i = paramc.action)
    {
      localbjj.xxQ = i;
      AppMethodBeat.o(87693);
      return localbjj;
    }
  }
  
  private void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(87700);
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87700);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (g.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((g.a)localObject).b(paramc);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87700);
  }
  
  private static boolean e(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(87688);
    if (paramb == null)
    {
      AppMethodBeat.o(87688);
      return false;
    }
    if ((paramb.bbe() != null) && (paramb.bbe().wEi))
    {
      AppMethodBeat.o(87688);
      return true;
    }
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
    AppMethodBeat.o(87688);
    return false;
  }
  
  public final void S(int paramInt, String paramString)
  {
    AppMethodBeat.i(87699);
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
    if (this.kkV == null)
    {
      AppMethodBeat.o(87699);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (g.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((g.a)localObject).ap(paramInt, paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(87699);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(87697);
    if (this.kkV == null) {
      this.kkV = new ArrayList();
    }
    this.kkV.add(new WeakReference(parama));
    AppMethodBeat.o(87697);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, q paramq)
  {
    AppMethodBeat.i(87683);
    if (!e(paramb))
    {
      ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
      S(2, "");
      AppMethodBeat.o(87683);
      return;
    }
    if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(com.tencent.mm.sdk.platformtools.ah.getContext()))
    {
      ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
      S(-1, "");
      AppMethodBeat.o(87683);
      return;
    }
    if (this.evn >= 3)
    {
      ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.evn + ",cannot request!");
      AppMethodBeat.o(87683);
      return;
    }
    a(paramb.bbh(), paramq);
    this.evn += 1;
    AppMethodBeat.o(87683);
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(87684);
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[] { Integer.valueOf(paramq.scene) });
    Object localObject1 = am.bcd().bbT();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[] { Integer.valueOf(paramq.scene) });
      AppMethodBeat.o(87684);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      CardInfo localCardInfo = (CardInfo)((Iterator)localObject1).next();
      if (localCardInfo == null)
      {
        ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[] { Integer.valueOf(paramq.scene) });
      }
      else if (paramq == null)
      {
        ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
      }
      else
      {
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[] { localCardInfo.bbh(), Integer.valueOf(paramq.scene) });
        if (!e(localCardInfo))
        {
          ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[] { localCardInfo.bbh() });
        }
        else
        {
          Object localObject2 = localCardInfo.bbh();
          i locali = am.bcs().HK((String)localObject2);
          int i;
          if (locali == null) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label356;
            }
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[] { localCardInfo.bbh(), Integer.valueOf(paramq.scene) });
            break;
            localObject2 = am.bcr().HL((String)localObject2);
            if (((List)localObject2).isEmpty())
            {
              i = 1;
            }
            else if (((List)localObject2).size() < locali.field_lower_bound)
            {
              this.klr = com.tencent.mm.plugin.card.d.c.kCe;
              i = 1;
            }
            else if (a(locali))
            {
              this.klr = com.tencent.mm.plugin.card.d.c.kBY;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          label356:
          ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[] { Integer.valueOf(paramq.scene) });
          a(localCardInfo.bbh(), paramq);
        }
      }
    }
    AppMethodBeat.o(87684);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(87691);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(b(paramString1, paramString2, paramc));
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(paramc.action) });
    I(localLinkedList);
    AppMethodBeat.o(87691);
  }
  
  public final void b(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(87685);
    String str = paramg.field_card_id;
    Object localObject1 = am.bcr();
    if (paramg.knP)
    {
      paramg = am.bcr().HL(str);
      localObject2 = ((com.tencent.mm.plugin.card.model.l)localObject1).HN(str);
      ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[] { str });
      if (((com.tencent.mm.plugin.card.model.l)localObject1).qD(str))
      {
        if (localObject2 != null)
        {
          ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[] { str });
          b(com.tencent.mm.plugin.card.d.c.kCd);
        }
        a(str, paramg, com.tencent.mm.plugin.card.d.c.kCd);
      }
      AppMethodBeat.o(87685);
      return;
    }
    Object localObject2 = paramg.knQ;
    if (localObject2 == null)
    {
      ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[] { str });
      AppMethodBeat.o(87685);
      return;
    }
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[] { str, Integer.valueOf(((List)localObject2).size()) });
    paramg = ((com.tencent.mm.plugin.card.model.l)localObject1).HN(str);
    localObject1 = new LinkedList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      g.c localc = (g.c)((Iterator)localObject2).next();
      if (am.bcr().dp(str, localc.knW)) {
        ((LinkedList)localObject1).add(b(str, localc.knW, com.tencent.mm.plugin.card.d.c.kCd));
      }
    }
    if (paramg != null)
    {
      ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[] { str, paramg.field_code_id });
      b(com.tencent.mm.plugin.card.d.c.kCd);
    }
    if (!((LinkedList)localObject1).isEmpty()) {
      I((LinkedList)localObject1);
    }
    AppMethodBeat.o(87685);
  }
  
  public final void bbw()
  {
    AppMethodBeat.i(87687);
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
    if (!this.kls.dtj()) {
      this.kls.stopTimer();
    }
    AppMethodBeat.o(87687);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(87696);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(",NetSceneBase=");
    if (paramm != null) {}
    for (Object localObject = paramm.getClass();; localObject = "")
    {
      ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label170;
      }
      if (!(paramm instanceof ae)) {
        break label150;
      }
      paramString = ((ae)paramm).koC;
      if (paramString != null) {
        break;
      }
      ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
      AppMethodBeat.o(87696);
      return;
    }
    a(paramString);
    a(this.klr);
    com.tencent.mm.kernel.g.RK().eHt.b(1382, this);
    AppMethodBeat.o(87696);
    return;
    label150:
    com.tencent.mm.kernel.g.RK().eHt.b(1275, this);
    AppMethodBeat.o(87696);
    return;
    label170:
    localObject = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(" cmd:");
    if (paramm != null)
    {
      paramInt1 = paramm.getType();
      localStringBuilder = ((StringBuilder)localObject).append(paramInt1).append("  NetSceneBase=");
      if (paramm == null) {
        break label293;
      }
    }
    label293:
    for (localObject = paramm.getClass();; localObject = "")
    {
      ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if (!(paramm instanceof ae)) {
        break label301;
      }
      S(paramInt2, paramString);
      com.tencent.mm.kernel.g.RK().eHt.b(1382, this);
      AppMethodBeat.o(87696);
      return;
      paramInt1 = 0;
      break;
    }
    label301:
    com.tencent.mm.kernel.g.RK().eHt.b(1275, this);
    AppMethodBeat.o(87696);
  }
  
  public final void release()
  {
    AppMethodBeat.i(87682);
    this.evn = 0;
    bbw();
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
    com.tencent.mm.kernel.g.RK().eHt.b(1382, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1275, this);
    AppMethodBeat.o(87682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g
 * JD-Core Version:    0.7.0.1
 */