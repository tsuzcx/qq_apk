package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g.c;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.protocal.protobuf.dqq;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.an.i
{
  public List<WeakReference<a>> cSF;
  public int jGL;
  public com.tencent.mm.plugin.card.d.c tnc;
  public MTimerHandler tnd;
  
  public g()
  {
    AppMethodBeat.i(112625);
    this.cSF = new ArrayList();
    this.tnd = new MTimerHandler(new g.1(this), false);
    AppMethodBeat.o(112625);
  }
  
  private void O(LinkedList<dgr> paramLinkedList)
  {
    AppMethodBeat.i(112636);
    h.aHF().kcd.a(1275, this);
    paramLinkedList = new ah(paramLinkedList);
    h.aHF().kcd.a(paramLinkedList, 0);
    AppMethodBeat.o(112636);
  }
  
  private void a(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112642);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
    if (this.cSF == null)
    {
      AppMethodBeat.o(112642);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      Object localObject = (WeakReference)this.cSF.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).c(paramc);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112642);
  }
  
  private void a(dqq paramdqq)
  {
    AppMethodBeat.i(112638);
    if (paramdqq == null)
    {
      AppMethodBeat.o(112638);
      return;
    }
    String str = paramdqq.fUL;
    Object localObject;
    if (am.cHH().aqY(str) == null)
    {
      localObject = b(paramdqq);
      am.cHH().insert((IAutoDBItem)localObject);
    }
    for (;;)
    {
      localObject = am.cHG().aqZ(str);
      if ((!((List)localObject).isEmpty()) && (am.cHG().ho(str)) && (this.tnc != null)) {
        a(str, (List)localObject, this.tnc);
      }
      paramdqq = paramdqq.TXl.iterator();
      while (paramdqq.hasNext())
      {
        localObject = (dqp)paramdqq.next();
        k localk = new k();
        localk.field_card_id = str;
        localk.field_code_id = ((dqp)localObject).tpN;
        localk.field_code = e.fM(str, ((dqp)localObject).data);
        am.cHG().insert(localk);
      }
      localObject = b(paramdqq);
      am.cHH().update((IAutoDBItem)localObject, new String[0]);
    }
    AppMethodBeat.o(112638);
  }
  
  private void a(String paramString, r paramr)
  {
    AppMethodBeat.i(112633);
    Object localObject = new StringBuilder("doNetSceneGetDynamicQrcode, cardId:").append(paramString).append(",scene :");
    if (paramr == null)
    {
      i = 0;
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", i);
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramString);
      if (paramr != null) {
        break label117;
      }
    }
    label117:
    for (int i = 0;; i = paramr.scene)
    {
      paramString = new ae((LinkedList)localObject, i);
      h.aHF().kcd.a(1382, this);
      h.aHF().kcd.a(paramString, 0);
      AppMethodBeat.o(112633);
      return;
      i = paramr.scene;
      break;
    }
  }
  
  private void a(String paramString, List<k> paramList, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112634);
    if (paramc == null)
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
      AppMethodBeat.o(112634);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList.add(b(paramString, ((k)paramList.next()).field_code_id, paramc));
    }
    O(localLinkedList);
    AppMethodBeat.o(112634);
  }
  
  public static boolean a(com.tencent.mm.plugin.card.model.i parami)
  {
    AppMethodBeat.i(112630);
    if (System.currentTimeMillis() - parami.field_fetch_time > parami.field_expire_time_interval * 1000)
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(parami.field_fetch_time), Integer.valueOf(parami.field_expire_time_interval) });
      AppMethodBeat.o(112630);
      return true;
    }
    AppMethodBeat.o(112630);
    return false;
  }
  
  private static com.tencent.mm.plugin.card.model.i b(dqq paramdqq)
  {
    AppMethodBeat.i(112639);
    com.tencent.mm.plugin.card.model.i locali = new com.tencent.mm.plugin.card.model.i();
    locali.field_card_id = paramdqq.fUL;
    locali.field_lower_bound = paramdqq.TXg;
    locali.field_expire_time_interval = paramdqq.TXj;
    locali.field_need_insert_show_timestamp = paramdqq.TXh;
    locali.field_show_expire_interval = paramdqq.TXk;
    locali.field_show_timestamp_encrypt_key = paramdqq.TXi;
    locali.field_fetch_time = System.currentTimeMillis();
    AppMethodBeat.o(112639);
    return locali;
  }
  
  private static dgr b(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112637);
    dgr localdgr = new dgr();
    localdgr.fUL = paramString1;
    localdgr.tpN = paramString2;
    localdgr.TNv = new Long(System.currentTimeMillis() / 1000L).intValue();
    if (paramc == null) {}
    for (int i = -1;; i = paramc.action)
    {
      localdgr.TNw = i;
      AppMethodBeat.o(112637);
      return localdgr;
    }
  }
  
  private void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112644);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
    if (this.cSF == null)
    {
      AppMethodBeat.o(112644);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      Object localObject = (WeakReference)this.cSF.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).b(paramc);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112644);
  }
  
  private static boolean e(b paramb)
  {
    AppMethodBeat.i(112632);
    if (paramb == null)
    {
      AppMethodBeat.o(112632);
      return false;
    }
    if ((paramb.cGt() != null) && (paramb.cGt().SdT))
    {
      AppMethodBeat.o(112632);
      return true;
    }
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
    AppMethodBeat.o(112632);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112641);
    if (this.cSF == null) {
      this.cSF = new ArrayList();
    }
    this.cSF.add(new WeakReference(parama));
    AppMethodBeat.o(112641);
  }
  
  public final void a(b paramb, r paramr)
  {
    AppMethodBeat.i(112627);
    if (!e(paramb))
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
      am(2, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
      am(-1, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (this.jGL >= 3)
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.jGL + ",cannot request!");
      AppMethodBeat.o(112627);
      return;
    }
    a(paramb.cGw(), paramr);
    this.jGL += 1;
    AppMethodBeat.o(112627);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(112628);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
    Object localObject1 = am.cHs().cHi();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      AppMethodBeat.o(112628);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      CardInfo localCardInfo = (CardInfo)((Iterator)localObject1).next();
      if (localCardInfo == null)
      {
        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      }
      else if (paramr == null)
      {
        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
      }
      else
      {
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[] { localCardInfo.cGw(), Integer.valueOf(paramr.scene) });
        if (!e(localCardInfo))
        {
          Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[] { localCardInfo.cGw() });
        }
        else
        {
          Object localObject2 = localCardInfo.cGw();
          com.tencent.mm.plugin.card.model.i locali = am.cHH().aqY((String)localObject2);
          int i;
          if (locali == null) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label356;
            }
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[] { localCardInfo.cGw(), Integer.valueOf(paramr.scene) });
            break;
            localObject2 = am.cHG().aqZ((String)localObject2);
            if (((List)localObject2).isEmpty())
            {
              i = 1;
            }
            else if (((List)localObject2).size() < locali.field_lower_bound)
            {
              this.tnc = com.tencent.mm.plugin.card.d.c.tGQ;
              i = 1;
            }
            else if (a(locali))
            {
              this.tnc = com.tencent.mm.plugin.card.d.c.tGK;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          label356:
          Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
          a(localCardInfo.cGw(), paramr);
        }
      }
    }
    AppMethodBeat.o(112628);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112635);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(b(paramString1, paramString2, paramc));
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(paramc.action) });
    O(localLinkedList);
    AppMethodBeat.o(112635);
  }
  
  public final void am(int paramInt, String paramString)
  {
    AppMethodBeat.i(112643);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
    if (this.cSF == null)
    {
      AppMethodBeat.o(112643);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      Object localObject = (WeakReference)this.cSF.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).aL(paramInt, paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112643);
  }
  
  public final void b(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(112629);
    String str = paramg.field_card_id;
    Object localObject1 = am.cHG();
    if (paramg.tpH)
    {
      paramg = am.cHG().aqZ(str);
      localObject2 = ((com.tencent.mm.plugin.card.model.l)localObject1).arb(str);
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[] { str });
      if (((com.tencent.mm.plugin.card.model.l)localObject1).ho(str))
      {
        if (localObject2 != null)
        {
          Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[] { str });
          b(com.tencent.mm.plugin.card.d.c.tGP);
        }
        a(str, paramg, com.tencent.mm.plugin.card.d.c.tGP);
      }
      AppMethodBeat.o(112629);
      return;
    }
    Object localObject2 = paramg.tpI;
    if (localObject2 == null)
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[] { str });
      AppMethodBeat.o(112629);
      return;
    }
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[] { str, Integer.valueOf(((List)localObject2).size()) });
    paramg = ((com.tencent.mm.plugin.card.model.l)localObject1).arb(str);
    localObject1 = new LinkedList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      g.c localc = (g.c)((Iterator)localObject2).next();
      if (am.cHG().fF(str, localc.tpN)) {
        ((LinkedList)localObject1).add(b(str, localc.tpN, com.tencent.mm.plugin.card.d.c.tGP));
      }
    }
    if (paramg != null)
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[] { str, paramg.field_code_id });
      b(com.tencent.mm.plugin.card.d.c.tGP);
    }
    if (!((LinkedList)localObject1).isEmpty()) {
      O((LinkedList)localObject1);
    }
    AppMethodBeat.o(112629);
  }
  
  public final void cGL()
  {
    AppMethodBeat.i(112631);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
    if (!this.tnd.stopped()) {
      this.tnd.stopTimer();
    }
    AppMethodBeat.o(112631);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112640);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(",NetSceneBase=");
    if (paramq != null) {}
    for (Object localObject = paramq.getClass();; localObject = "")
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label170;
      }
      if (!(paramq instanceof ae)) {
        break label150;
      }
      paramString = ((ae)paramq).tqs;
      if (paramString != null) {
        break;
      }
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
      AppMethodBeat.o(112640);
      return;
    }
    a(paramString);
    a(this.tnc);
    h.aHF().kcd.b(1382, this);
    AppMethodBeat.o(112640);
    return;
    label150:
    h.aHF().kcd.b(1275, this);
    AppMethodBeat.o(112640);
    return;
    label170:
    localObject = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(" cmd:");
    if (paramq != null)
    {
      paramInt1 = paramq.getType();
      localStringBuilder = ((StringBuilder)localObject).append(paramInt1).append("  NetSceneBase=");
      if (paramq == null) {
        break label293;
      }
    }
    label293:
    for (localObject = paramq.getClass();; localObject = "")
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if (!(paramq instanceof ae)) {
        break label301;
      }
      am(paramInt2, paramString);
      h.aHF().kcd.b(1382, this);
      AppMethodBeat.o(112640);
      return;
      paramInt1 = 0;
      break;
    }
    label301:
    h.aHF().kcd.b(1275, this);
    AppMethodBeat.o(112640);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112626);
    this.jGL = 0;
    cGL();
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
    h.aHF().kcd.b(1382, this);
    h.aHF().kcd.b(1275, this);
    AppMethodBeat.o(112626);
  }
  
  public static abstract interface a
  {
    public abstract void aL(int paramInt, String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.d.c paramc);
    
    public abstract void c(com.tencent.mm.plugin.card.d.c paramc);
    
    public abstract void cGX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g
 * JD-Core Version:    0.7.0.1
 */