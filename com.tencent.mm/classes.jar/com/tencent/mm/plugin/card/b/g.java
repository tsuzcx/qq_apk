package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g.c;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.ak.g
{
  public int fPc;
  public List<WeakReference<a>> nTa;
  public com.tencent.mm.plugin.card.d.c nTx;
  public au nTy;
  
  public g()
  {
    AppMethodBeat.i(112625);
    this.nTa = new ArrayList();
    this.nTy = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112624);
        ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
        g localg = g.this;
        ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
        if (localg.nTa != null)
        {
          int i = 0;
          while (i < localg.nTa.size())
          {
            Object localObject = (WeakReference)localg.nTa.get(i);
            if (localObject != null)
            {
              localObject = (g.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((g.a)localObject).bPN();
              }
            }
            i += 1;
          }
        }
        AppMethodBeat.o(112624);
        return true;
      }
    }, false);
    AppMethodBeat.o(112625);
  }
  
  private void N(LinkedList<cbp> paramLinkedList)
  {
    AppMethodBeat.i(112636);
    com.tencent.mm.kernel.g.agQ().ghe.a(1275, this);
    paramLinkedList = new ah(paramLinkedList);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramLinkedList, 0);
    AppMethodBeat.o(112636);
  }
  
  private void a(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112642);
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112642);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      Object localObject = (WeakReference)this.nTa.get(i);
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
  
  private void a(cjc paramcjc)
  {
    AppMethodBeat.i(112638);
    if (paramcjc == null)
    {
      AppMethodBeat.o(112638);
      return;
    }
    String str = paramcjc.dvO;
    Object localObject;
    if (am.bQx().UG(str) == null)
    {
      localObject = b(paramcjc);
      am.bQx().insert((com.tencent.mm.sdk.e.c)localObject);
    }
    for (;;)
    {
      localObject = am.bQw().UH(str);
      if ((!((List)localObject).isEmpty()) && (am.bQw().zB(str)) && (this.nTx != null)) {
        a(str, (List)localObject, this.nTx);
      }
      paramcjc = paramcjc.Fxa.iterator();
      while (paramcjc.hasNext())
      {
        localObject = (cjb)paramcjc.next();
        k localk = new k();
        localk.field_card_id = str;
        localk.field_code_id = ((cjb)localObject).nWk;
        localk.field_code = e.eT(str, ((cjb)localObject).data);
        am.bQw().insert(localk);
      }
      localObject = b(paramcjc);
      am.bQx().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
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
      ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", i);
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
      com.tencent.mm.kernel.g.agQ().ghe.a(1382, this);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
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
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
      AppMethodBeat.o(112634);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLinkedList.add(b(paramString, ((k)paramList.next()).field_code_id, paramc));
    }
    N(localLinkedList);
    AppMethodBeat.o(112634);
  }
  
  public static boolean a(i parami)
  {
    AppMethodBeat.i(112630);
    if (System.currentTimeMillis() - parami.field_fetch_time > parami.field_expire_time_interval * 1000)
    {
      ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(parami.field_fetch_time), Integer.valueOf(parami.field_expire_time_interval) });
      AppMethodBeat.o(112630);
      return true;
    }
    AppMethodBeat.o(112630);
    return false;
  }
  
  private static i b(cjc paramcjc)
  {
    AppMethodBeat.i(112639);
    i locali = new i();
    locali.field_card_id = paramcjc.dvO;
    locali.field_lower_bound = paramcjc.FwV;
    locali.field_expire_time_interval = paramcjc.FwY;
    locali.field_need_insert_show_timestamp = paramcjc.FwW;
    locali.field_show_expire_interval = paramcjc.FwZ;
    locali.field_show_timestamp_encrypt_key = paramcjc.FwX;
    locali.field_fetch_time = System.currentTimeMillis();
    AppMethodBeat.o(112639);
    return locali;
  }
  
  private static cbp b(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112637);
    cbp localcbp = new cbp();
    localcbp.dvO = paramString1;
    localcbp.nWk = paramString2;
    localcbp.FpI = new Long(System.currentTimeMillis() / 1000L).intValue();
    if (paramc == null) {}
    for (int i = -1;; i = paramc.action)
    {
      localcbp.FpJ = i;
      AppMethodBeat.o(112637);
      return localcbp;
    }
  }
  
  private void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112644);
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112644);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      Object localObject = (WeakReference)this.nTa.get(i);
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
  
  private static boolean e(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112632);
    if (paramb == null)
    {
      AppMethodBeat.o(112632);
      return false;
    }
    if ((paramb.bPj() != null) && (paramb.bPj().Eiu))
    {
      AppMethodBeat.o(112632);
      return true;
    }
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
    AppMethodBeat.o(112632);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112641);
    if (this.nTa == null) {
      this.nTa = new ArrayList();
    }
    this.nTa.add(new WeakReference(parama));
    AppMethodBeat.o(112641);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, r paramr)
  {
    AppMethodBeat.i(112627);
    if (!e(paramb))
    {
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
      af(2, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(ai.getContext()))
    {
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
      af(-1, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (this.fPc >= 3)
    {
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.fPc + ",cannot request!");
      AppMethodBeat.o(112627);
      return;
    }
    a(paramb.bPm(), paramr);
    this.fPc += 1;
    AppMethodBeat.o(112627);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(112628);
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
    Object localObject1 = am.bQi().bPY();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      AppMethodBeat.o(112628);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      CardInfo localCardInfo = (CardInfo)((Iterator)localObject1).next();
      if (localCardInfo == null)
      {
        ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      }
      else if (paramr == null)
      {
        ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
      }
      else
      {
        ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[] { localCardInfo.bPm(), Integer.valueOf(paramr.scene) });
        if (!e(localCardInfo))
        {
          ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[] { localCardInfo.bPm() });
        }
        else
        {
          Object localObject2 = localCardInfo.bPm();
          i locali = am.bQx().UG((String)localObject2);
          int i;
          if (locali == null) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label356;
            }
            ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[] { localCardInfo.bPm(), Integer.valueOf(paramr.scene) });
            break;
            localObject2 = am.bQw().UH((String)localObject2);
            if (((List)localObject2).isEmpty())
            {
              i = 1;
            }
            else if (((List)localObject2).size() < locali.field_lower_bound)
            {
              this.nTx = com.tencent.mm.plugin.card.d.c.omd;
              i = 1;
            }
            else if (a(locali))
            {
              this.nTx = com.tencent.mm.plugin.card.d.c.olX;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          label356:
          ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
          a(localCardInfo.bPm(), paramr);
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
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(paramc.action) });
    N(localLinkedList);
    AppMethodBeat.o(112635);
  }
  
  public final void af(int paramInt, String paramString)
  {
    AppMethodBeat.i(112643);
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112643);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      Object localObject = (WeakReference)this.nTa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).aF(paramInt, paramString);
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
    Object localObject1 = am.bQw();
    if (paramg.nWd)
    {
      paramg = am.bQw().UH(str);
      localObject2 = ((com.tencent.mm.plugin.card.model.l)localObject1).UJ(str);
      ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[] { str });
      if (((com.tencent.mm.plugin.card.model.l)localObject1).zB(str))
      {
        if (localObject2 != null)
        {
          ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[] { str });
          b(com.tencent.mm.plugin.card.d.c.omc);
        }
        a(str, paramg, com.tencent.mm.plugin.card.d.c.omc);
      }
      AppMethodBeat.o(112629);
      return;
    }
    Object localObject2 = paramg.nWe;
    if (localObject2 == null)
    {
      ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[] { str });
      AppMethodBeat.o(112629);
      return;
    }
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[] { str, Integer.valueOf(((List)localObject2).size()) });
    paramg = ((com.tencent.mm.plugin.card.model.l)localObject1).UJ(str);
    localObject1 = new LinkedList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      g.c localc = (g.c)((Iterator)localObject2).next();
      if (am.bQw().eM(str, localc.nWk)) {
        ((LinkedList)localObject1).add(b(str, localc.nWk, com.tencent.mm.plugin.card.d.c.omc));
      }
    }
    if (paramg != null)
    {
      ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[] { str, paramg.field_code_id });
      b(com.tencent.mm.plugin.card.d.c.omc);
    }
    if (!((LinkedList)localObject1).isEmpty()) {
      N((LinkedList)localObject1);
    }
    AppMethodBeat.o(112629);
  }
  
  public final void bPB()
  {
    AppMethodBeat.i(112631);
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
    if (!this.nTy.eVs()) {
      this.nTy.stopTimer();
    }
    AppMethodBeat.o(112631);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112640);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(",NetSceneBase=");
    if (paramn != null) {}
    for (Object localObject = paramn.getClass();; localObject = "")
    {
      ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label170;
      }
      if (!(paramn instanceof ae)) {
        break label150;
      }
      paramString = ((ae)paramn).nWP;
      if (paramString != null) {
        break;
      }
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
      AppMethodBeat.o(112640);
      return;
    }
    a(paramString);
    a(this.nTx);
    com.tencent.mm.kernel.g.agQ().ghe.b(1382, this);
    AppMethodBeat.o(112640);
    return;
    label150:
    com.tencent.mm.kernel.g.agQ().ghe.b(1275, this);
    AppMethodBeat.o(112640);
    return;
    label170:
    localObject = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(" cmd:");
    if (paramn != null)
    {
      paramInt1 = paramn.getType();
      localStringBuilder = ((StringBuilder)localObject).append(paramInt1).append("  NetSceneBase=");
      if (paramn == null) {
        break label293;
      }
    }
    label293:
    for (localObject = paramn.getClass();; localObject = "")
    {
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if (!(paramn instanceof ae)) {
        break label301;
      }
      af(paramInt2, paramString);
      com.tencent.mm.kernel.g.agQ().ghe.b(1382, this);
      AppMethodBeat.o(112640);
      return;
      paramInt1 = 0;
      break;
    }
    label301:
    com.tencent.mm.kernel.g.agQ().ghe.b(1275, this);
    AppMethodBeat.o(112640);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112626);
    this.fPc = 0;
    bPB();
    ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
    com.tencent.mm.kernel.g.agQ().ghe.b(1382, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1275, this);
    AppMethodBeat.o(112626);
  }
  
  public static abstract interface a
  {
    public abstract void aF(int paramInt, String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.d.c paramc);
    
    public abstract void bPN();
    
    public abstract void c(com.tencent.mm.plugin.card.d.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g
 * JD-Core Version:    0.7.0.1
 */