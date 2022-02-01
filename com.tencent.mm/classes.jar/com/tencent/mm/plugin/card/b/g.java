package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g.c;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements f
{
  public int gkU;
  public List<WeakReference<a>> oCX;
  public com.tencent.mm.plugin.card.d.c oDu;
  public aw oDv;
  
  public g()
  {
    AppMethodBeat.i(112625);
    this.oCX = new ArrayList();
    this.oDv = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112624);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
        g localg = g.this;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
        if (localg.oCX != null)
        {
          int i = 0;
          while (i < localg.oCX.size())
          {
            Object localObject = (WeakReference)localg.oCX.get(i);
            if (localObject != null)
            {
              localObject = (g.a)((WeakReference)localObject).get();
              if (localObject != null) {
                ((g.a)localObject).bVH();
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
  
  private void O(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(112636);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1275, this);
    paramLinkedList = new ah(paramLinkedList);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramLinkedList, 0);
    AppMethodBeat.o(112636);
  }
  
  private void a(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112642);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112642);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
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
  
  private void a(cow paramcow)
  {
    AppMethodBeat.i(112638);
    if (paramcow == null)
    {
      AppMethodBeat.o(112638);
      return;
    }
    String str = paramcow.dJb;
    Object localObject;
    if (am.bWr().Zg(str) == null)
    {
      localObject = b(paramcow);
      am.bWr().insert((com.tencent.mm.sdk.e.c)localObject);
    }
    for (;;)
    {
      localObject = am.bWq().Zh(str);
      if ((!((List)localObject).isEmpty()) && (am.bWq().Dc(str)) && (this.oDu != null)) {
        a(str, (List)localObject, this.oDu);
      }
      paramcow = paramcow.HAF.iterator();
      while (paramcow.hasNext())
      {
        localObject = (cov)paramcow.next();
        k localk = new k();
        localk.field_card_id = str;
        localk.field_code_id = ((cov)localObject).oGg;
        localk.field_code = e.fh(str, ((cov)localObject).data);
        am.bWq().insert(localk);
      }
      localObject = b(paramcow);
      am.bWr().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", i);
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramString);
      if (paramr != null) {
        break label117;
      }
    }
    label117:
    for (int i = 0;; i = paramr.scene)
    {
      paramString = new com.tencent.mm.plugin.card.model.ae((LinkedList)localObject, i);
      com.tencent.mm.kernel.g.ajQ().gDv.a(1382, this);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
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
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
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
  
  public static boolean a(i parami)
  {
    AppMethodBeat.i(112630);
    if (System.currentTimeMillis() - parami.field_fetch_time > parami.field_expire_time_interval * 1000)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(parami.field_fetch_time), Integer.valueOf(parami.field_expire_time_interval) });
      AppMethodBeat.o(112630);
      return true;
    }
    AppMethodBeat.o(112630);
    return false;
  }
  
  private static i b(cow paramcow)
  {
    AppMethodBeat.i(112639);
    i locali = new i();
    locali.field_card_id = paramcow.dJb;
    locali.field_lower_bound = paramcow.HAA;
    locali.field_expire_time_interval = paramcow.HAD;
    locali.field_need_insert_show_timestamp = paramcow.HAB;
    locali.field_show_expire_interval = paramcow.HAE;
    locali.field_show_timestamp_encrypt_key = paramcow.HAC;
    locali.field_fetch_time = System.currentTimeMillis();
    AppMethodBeat.o(112639);
    return locali;
  }
  
  private static cha b(String paramString1, String paramString2, com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112637);
    cha localcha = new cha();
    localcha.dJb = paramString1;
    localcha.oGg = paramString2;
    localcha.HsT = new Long(System.currentTimeMillis() / 1000L).intValue();
    if (paramc == null) {}
    for (int i = -1;; i = paramc.action)
    {
      localcha.HsU = i;
      AppMethodBeat.o(112637);
      return localcha;
    }
  }
  
  private void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(112644);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112644);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
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
    if ((paramb.bVd() != null) && (paramb.bVd().Gid))
    {
      AppMethodBeat.o(112632);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
    AppMethodBeat.o(112632);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112641);
    if (this.oCX == null) {
      this.oCX = new ArrayList();
    }
    this.oCX.add(new WeakReference(parama));
    AppMethodBeat.o(112641);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, r paramr)
  {
    AppMethodBeat.i(112627);
    if (!e(paramb))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
      ah(2, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (!com.tencent.mm.plugin.card.d.l.isNetworkAvailable(ak.getContext()))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
      ah(-1, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (this.gkU >= 3)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.gkU + ",cannot request!");
      AppMethodBeat.o(112627);
      return;
    }
    a(paramb.bVg(), paramr);
    this.gkU += 1;
    AppMethodBeat.o(112627);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(112628);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
    Object localObject1 = am.bWc().bVS();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      AppMethodBeat.o(112628);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      CardInfo localCardInfo = (CardInfo)((Iterator)localObject1).next();
      if (localCardInfo == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
      }
      else if (paramr == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[] { localCardInfo.bVg(), Integer.valueOf(paramr.scene) });
        if (!e(localCardInfo))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[] { localCardInfo.bVg() });
        }
        else
        {
          Object localObject2 = localCardInfo.bVg();
          i locali = am.bWr().Zg((String)localObject2);
          int i;
          if (locali == null) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label356;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[] { localCardInfo.bVg(), Integer.valueOf(paramr.scene) });
            break;
            localObject2 = am.bWq().Zh((String)localObject2);
            if (((List)localObject2).isEmpty())
            {
              i = 1;
            }
            else if (((List)localObject2).size() < locali.field_lower_bound)
            {
              this.oDu = com.tencent.mm.plugin.card.d.c.oWa;
              i = 1;
            }
            else if (a(locali))
            {
              this.oDu = com.tencent.mm.plugin.card.d.c.oVU;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          label356:
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
          a(localCardInfo.bVg(), paramr);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(paramc.action) });
    O(localLinkedList);
    AppMethodBeat.o(112635);
  }
  
  public final void ah(int paramInt, String paramString)
  {
    AppMethodBeat.i(112643);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
    if (this.oCX == null)
    {
      AppMethodBeat.o(112643);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).aH(paramInt, paramString);
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
    Object localObject1 = am.bWq();
    if (paramg.oFZ)
    {
      paramg = am.bWq().Zh(str);
      localObject2 = ((com.tencent.mm.plugin.card.model.l)localObject1).Zj(str);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[] { str });
      if (((com.tencent.mm.plugin.card.model.l)localObject1).Dc(str))
      {
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[] { str });
          b(com.tencent.mm.plugin.card.d.c.oVZ);
        }
        a(str, paramg, com.tencent.mm.plugin.card.d.c.oVZ);
      }
      AppMethodBeat.o(112629);
      return;
    }
    Object localObject2 = paramg.oGa;
    if (localObject2 == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[] { str });
      AppMethodBeat.o(112629);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[] { str, Integer.valueOf(((List)localObject2).size()) });
    paramg = ((com.tencent.mm.plugin.card.model.l)localObject1).Zj(str);
    localObject1 = new LinkedList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      g.c localc = (g.c)((Iterator)localObject2).next();
      if (am.bWq().fa(str, localc.oGg)) {
        ((LinkedList)localObject1).add(b(str, localc.oGg, com.tencent.mm.plugin.card.d.c.oVZ));
      }
    }
    if (paramg != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[] { str, paramg.field_code_id });
      b(com.tencent.mm.plugin.card.d.c.oVZ);
    }
    if (!((LinkedList)localObject1).isEmpty()) {
      O((LinkedList)localObject1);
    }
    AppMethodBeat.o(112629);
  }
  
  public final void bVv()
  {
    AppMethodBeat.i(112631);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
    if (!this.oDv.foU()) {
      this.oDv.stopTimer();
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label170;
      }
      if (!(paramn instanceof com.tencent.mm.plugin.card.model.ae)) {
        break label150;
      }
      paramString = ((com.tencent.mm.plugin.card.model.ae)paramn).oGL;
      if (paramString != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
      AppMethodBeat.o(112640);
      return;
    }
    a(paramString);
    a(this.oDu);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1382, this);
    AppMethodBeat.o(112640);
    return;
    label150:
    com.tencent.mm.kernel.g.ajQ().gDv.b(1275, this);
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
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if (!(paramn instanceof com.tencent.mm.plugin.card.model.ae)) {
        break label301;
      }
      ah(paramInt2, paramString);
      com.tencent.mm.kernel.g.ajQ().gDv.b(1382, this);
      AppMethodBeat.o(112640);
      return;
      paramInt1 = 0;
      break;
    }
    label301:
    com.tencent.mm.kernel.g.ajQ().gDv.b(1275, this);
    AppMethodBeat.o(112640);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112626);
    this.gkU = 0;
    bVv();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
    com.tencent.mm.kernel.g.ajQ().gDv.b(1382, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1275, this);
    AppMethodBeat.o(112626);
  }
  
  public static abstract interface a
  {
    public abstract void aH(int paramInt, String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.d.c paramc);
    
    public abstract void bVH();
    
    public abstract void c(com.tencent.mm.plugin.card.d.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g
 * JD-Core Version:    0.7.0.1
 */