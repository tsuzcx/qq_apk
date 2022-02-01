package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.c.e;
import com.tencent.mm.plugin.card.c.r;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.c;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.ejk;
import com.tencent.mm.protocal.protobuf.ejl;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.am.h
{
  public List<WeakReference<a>> eNV;
  public com.tencent.mm.plugin.card.c.c wrC;
  public int wrD;
  public MTimerHandler wrE;
  
  public f()
  {
    AppMethodBeat.i(112625);
    this.eNV = new ArrayList();
    this.wrE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112624);
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
        f.a(f.this);
        AppMethodBeat.o(112624);
        return true;
      }
    }, false);
    AppMethodBeat.o(112625);
  }
  
  private void Q(LinkedList<dyy> paramLinkedList)
  {
    AppMethodBeat.i(112636);
    com.tencent.mm.kernel.h.baD().mCm.a(1275, this);
    paramLinkedList = new ah(paramLinkedList);
    com.tencent.mm.kernel.h.baD().mCm.a(paramLinkedList, 0);
    AppMethodBeat.o(112636);
  }
  
  private void a(com.tencent.mm.plugin.card.c.c paramc)
  {
    AppMethodBeat.i(112642);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112642);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
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
  
  private void a(ejl paramejl)
  {
    AppMethodBeat.i(112638);
    if (paramejl == null)
    {
      AppMethodBeat.o(112638);
      return;
    }
    String str = paramejl.iaI;
    Object localObject;
    if (am.dkY().akD(str) == null)
    {
      localObject = b(paramejl);
      am.dkY().insert((IAutoDBItem)localObject);
    }
    for (;;)
    {
      localObject = am.dkX().akE(str);
      if ((!((List)localObject).isEmpty()) && (am.dkX().iP(str)) && (this.wrC != null)) {
        a(str, (List)localObject, this.wrC);
      }
      paramejl = paramejl.abod.iterator();
      while (paramejl.hasNext())
      {
        localObject = (ejk)paramejl.next();
        k localk = new k();
        localk.field_card_id = str;
        localk.field_code_id = ((ejk)localObject).wum;
        localk.field_code = e.gl(str, ((ejk)localObject).data);
        am.dkX().insert(localk);
      }
      localObject = b(paramejl);
      am.dkY().update((IAutoDBItem)localObject, new String[0]);
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
      com.tencent.mm.kernel.h.baD().mCm.a(1382, this);
      com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
      AppMethodBeat.o(112633);
      return;
      i = paramr.scene;
      break;
    }
  }
  
  private void a(String paramString, List<k> paramList, com.tencent.mm.plugin.card.c.c paramc)
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
    Q(localLinkedList);
    AppMethodBeat.o(112634);
  }
  
  public static boolean a(i parami)
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
  
  private static i b(ejl paramejl)
  {
    AppMethodBeat.i(112639);
    i locali = new i();
    locali.field_card_id = paramejl.iaI;
    locali.field_lower_bound = paramejl.abnY;
    locali.field_expire_time_interval = paramejl.abob;
    locali.field_need_insert_show_timestamp = paramejl.abnZ;
    locali.field_show_expire_interval = paramejl.aboc;
    locali.field_show_timestamp_encrypt_key = paramejl.aboa;
    locali.field_fetch_time = System.currentTimeMillis();
    AppMethodBeat.o(112639);
    return locali;
  }
  
  private static dyy b(String paramString1, String paramString2, com.tencent.mm.plugin.card.c.c paramc)
  {
    AppMethodBeat.i(112637);
    dyy localdyy = new dyy();
    localdyy.iaI = paramString1;
    localdyy.wum = paramString2;
    localdyy.abdO = new Long(System.currentTimeMillis() / 1000L).intValue();
    if (paramc == null) {}
    for (int i = -1;; i = paramc.action)
    {
      localdyy.abdP = i;
      AppMethodBeat.o(112637);
      return localdyy;
    }
  }
  
  private void b(com.tencent.mm.plugin.card.c.c paramc)
  {
    AppMethodBeat.i(112644);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112644);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
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
    if ((paramb.djL() != null) && (paramb.djL().ZbN))
    {
      AppMethodBeat.o(112632);
      return true;
    }
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
    AppMethodBeat.o(112632);
    return false;
  }
  
  public final void a(b paramb, r paramr)
  {
    AppMethodBeat.i(112627);
    if (!e(paramb))
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
      aw(2, "");
      AppMethodBeat.o(112627);
      return;
    }
    MMApplicationContext.getContext();
    if (!com.tencent.mm.plugin.card.c.l.doN())
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
      aw(-1, "");
      AppMethodBeat.o(112627);
      return;
    }
    if (this.wrD >= 3)
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.wrD + ",cannot request!");
      AppMethodBeat.o(112627);
      return;
    }
    a(paramb.djO(), paramr);
    this.wrD += 1;
    AppMethodBeat.o(112627);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(112628);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
    Object localObject1 = am.dkJ().dkz();
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
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[] { localCardInfo.djO(), Integer.valueOf(paramr.scene) });
        if (!e(localCardInfo))
        {
          Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[] { localCardInfo.djO() });
        }
        else
        {
          Object localObject2 = localCardInfo.djO();
          i locali = am.dkY().akD((String)localObject2);
          int i;
          if (locali == null) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label356;
            }
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[] { localCardInfo.djO(), Integer.valueOf(paramr.scene) });
            break;
            localObject2 = am.dkX().akE((String)localObject2);
            if (((List)localObject2).isEmpty())
            {
              i = 1;
            }
            else if (((List)localObject2).size() < locali.field_lower_bound)
            {
              this.wrC = com.tencent.mm.plugin.card.c.c.wKp;
              i = 1;
            }
            else if (a(locali))
            {
              this.wrC = com.tencent.mm.plugin.card.c.c.wKj;
              i = 1;
            }
            else
            {
              i = 0;
            }
          }
          label356:
          Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[] { Integer.valueOf(paramr.scene) });
          a(localCardInfo.djO(), paramr);
        }
      }
    }
    AppMethodBeat.o(112628);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112641);
    if (this.eNV == null) {
      this.eNV = new ArrayList();
    }
    this.eNV.add(new WeakReference(parama));
    AppMethodBeat.o(112641);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.card.c.c paramc)
  {
    AppMethodBeat.i(112635);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(b(paramString1, paramString2, paramc));
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(paramc.action) });
    Q(localLinkedList);
    AppMethodBeat.o(112635);
  }
  
  public final void aw(int paramInt, String paramString)
  {
    AppMethodBeat.i(112643);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112643);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).aY(paramInt, paramString);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112643);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(112629);
    String str = paramg.field_card_id;
    Object localObject1 = am.dkX();
    if (paramg.wug)
    {
      paramg = am.dkX().akE(str);
      localObject2 = ((com.tencent.mm.plugin.card.model.l)localObject1).akG(str);
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[] { str });
      if (((com.tencent.mm.plugin.card.model.l)localObject1).iP(str))
      {
        if (localObject2 != null)
        {
          Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[] { str });
          b(com.tencent.mm.plugin.card.c.c.wKo);
        }
        a(str, paramg, com.tencent.mm.plugin.card.c.c.wKo);
      }
      AppMethodBeat.o(112629);
      return;
    }
    Object localObject2 = paramg.wuh;
    if (localObject2 == null)
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[] { str });
      AppMethodBeat.o(112629);
      return;
    }
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[] { str, Integer.valueOf(((List)localObject2).size()) });
    paramg = ((com.tencent.mm.plugin.card.model.l)localObject1).akG(str);
    localObject1 = new LinkedList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      g.c localc = (g.c)((Iterator)localObject2).next();
      if (am.dkX().ge(str, localc.wum)) {
        ((LinkedList)localObject1).add(b(str, localc.wum, com.tencent.mm.plugin.card.c.c.wKo));
      }
    }
    if (paramg != null)
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[] { str, paramg.field_code_id });
      b(com.tencent.mm.plugin.card.c.c.wKo);
    }
    if (!((LinkedList)localObject1).isEmpty()) {
      Q((LinkedList)localObject1);
    }
    AppMethodBeat.o(112629);
  }
  
  public final void dkc()
  {
    AppMethodBeat.i(112631);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
    if (!this.wrE.stopped()) {
      this.wrE.stopTimer();
    }
    AppMethodBeat.o(112631);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112640);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(",NetSceneBase=");
    if (paramp != null) {}
    for (Object localObject = paramp.getClass();; localObject = "")
    {
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label170;
      }
      if (!(paramp instanceof ae)) {
        break label150;
      }
      paramString = ((ae)paramp).wuR;
      if (paramString != null) {
        break;
      }
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
      AppMethodBeat.o(112640);
      return;
    }
    a(paramString);
    a(this.wrC);
    com.tencent.mm.kernel.h.baD().mCm.b(1382, this);
    AppMethodBeat.o(112640);
    return;
    label150:
    com.tencent.mm.kernel.h.baD().mCm.b(1275, this);
    AppMethodBeat.o(112640);
    return;
    label170:
    localObject = new StringBuilder("onSceneEnd, errType = ").append(paramInt1).append(" errCode = ").append(paramInt2).append(" cmd:");
    if (paramp != null)
    {
      paramInt1 = paramp.getType();
      localStringBuilder = ((StringBuilder)localObject).append(paramInt1).append("  NetSceneBase=");
      if (paramp == null) {
        break label293;
      }
    }
    label293:
    for (localObject = paramp.getClass();; localObject = "")
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", localObject);
      if (!(paramp instanceof ae)) {
        break label301;
      }
      aw(paramInt2, paramString);
      com.tencent.mm.kernel.h.baD().mCm.b(1382, this);
      AppMethodBeat.o(112640);
      return;
      paramInt1 = 0;
      break;
    }
    label301:
    com.tencent.mm.kernel.h.baD().mCm.b(1275, this);
    AppMethodBeat.o(112640);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112626);
    this.wrD = 0;
    dkc();
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
    com.tencent.mm.kernel.h.baD().mCm.b(1382, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1275, this);
    AppMethodBeat.o(112626);
  }
  
  public static abstract interface a
  {
    public abstract void aY(int paramInt, String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.c.c paramc);
    
    public abstract void c(com.tencent.mm.plugin.card.c.c paramc);
    
    public abstract void dko();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.f
 * JD-Core Version:    0.7.0.1
 */