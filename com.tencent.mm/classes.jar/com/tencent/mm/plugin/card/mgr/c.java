package com.tencent.mm.plugin.card.mgr;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.card.base.d, j.a
{
  public List<WeakReference<a>> eNV;
  public WeakReference<Context> mContextRef;
  public HashMap<a, Boolean> wrr;
  public HashMap<String, Boolean> wrs;
  public HashMap<String, Boolean> wrt;
  public com.tencent.mm.plugin.card.base.b wru;
  public boolean wrv;
  public String wrw;
  
  public c()
  {
    AppMethodBeat.i(112598);
    this.eNV = new ArrayList();
    this.wrr = new HashMap();
    this.wrs = new HashMap();
    this.wrt = new HashMap();
    this.wru = null;
    this.wrv = false;
    AppMethodBeat.o(112598);
  }
  
  private void akt(String paramString)
  {
    AppMethodBeat.i(112609);
    Log.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112609);
      return;
    }
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < this.eNV.size())
    {
      localObject = (WeakReference)this.eNV.get(j);
      if (localObject == null) {
        break label216;
      }
      localObject = (a)((WeakReference)localObject).get();
      Boolean localBoolean = (Boolean)this.wrr.get(localObject);
      if ((localObject == null) || (localBoolean == null) || (!localBoolean.booleanValue())) {
        break label216;
      }
      ((a)localObject).aku(paramString);
      i = 1;
    }
    label216:
    for (;;)
    {
      j += 1;
      break;
      localObject = (Boolean)this.wrs.get(this.wru.djO());
      if (i != 0)
      {
        Log.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
        this.wrw = "";
        AppMethodBeat.o(112609);
        return;
      }
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        Log.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
        this.wrw = paramString;
        this.wrt.put(this.wru.djO(), Boolean.TRUE);
      }
      AppMethodBeat.o(112609);
      return;
    }
  }
  
  private void c(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112610);
    Log.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112610);
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
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112610);
  }
  
  private void dke()
  {
    AppMethodBeat.i(112611);
    Log.i("MicroMsg.CardConsumedMgr", "doVibrate()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112611);
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
          ((a)localObject).dki();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112611);
  }
  
  private void dkf()
  {
    AppMethodBeat.i(112612);
    Log.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
    if (this.eNV == null)
    {
      AppMethodBeat.o(112612);
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
          ((a)localObject).dkj();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112612);
  }
  
  private void dkg()
  {
    AppMethodBeat.i(112613);
    Log.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
    dkh();
    AppMethodBeat.o(112613);
  }
  
  /* Error */
  private void dkh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 155
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 60	com/tencent/mm/plugin/card/mgr/c:wrv	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 69
    //   16: ldc 157
    //   18: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 155
    //   23: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 69
    //   31: ldc 159
    //   33: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 60	com/tencent/mm/plugin/card/mgr/c:wrv	Z
    //   41: new 161	com/tencent/mm/plugin/card/sharecard/model/d
    //   44: dup
    //   45: aload_0
    //   46: getfield 58	com/tencent/mm/plugin/card/mgr/c:wru	Lcom/tencent/mm/plugin/card/base/b;
    //   49: invokeinterface 109 1 0
    //   54: ldc 113
    //   56: ldc 113
    //   58: invokespecial 164	com/tencent/mm/plugin/card/sharecard/model/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore_1
    //   62: invokestatic 170	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   65: getfield 176	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokevirtual 181	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   73: pop
    //   74: ldc 155
    //   76: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -53 -> 26
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	c
    //   61	8	1	locald	com.tencent.mm.plugin.card.sharecard.model.d
    //   82	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	82	finally
    //   29	79	82	finally
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112600);
    if (this.eNV == null) {
      this.eNV = new ArrayList();
    }
    this.eNV.add(new WeakReference(parama));
    AppMethodBeat.o(112600);
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112603);
    if (this.wrr == null) {
      this.wrr = new HashMap();
    }
    this.wrr.put(parama, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(112603);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(112607);
    Log.i("MicroMsg.CardConsumedMgr", "onChange()");
    Log.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if (this.wru == null)
    {
      Log.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
      dkf();
      AppMethodBeat.o(112607);
      return;
    }
    Log.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if ((this.wru.djo()) && (paramg.field_card_id != null) && (paramg.field_card_id.equals(this.wru.djO())) && (paramg.wuf == 3))
    {
      Log.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
      dkf();
      AppMethodBeat.o(112607);
      return;
    }
    if (!this.wru.djp())
    {
      Log.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
      dkf();
      AppMethodBeat.o(112607);
      return;
    }
    int i;
    Object localObject;
    if ((paramg.wuf == 3) || ((paramg.field_card_id != null) && (paramg.field_card_id.equals(this.wru.djO())) && (!TextUtils.isEmpty(paramg.field_consumed_box_id))))
    {
      long l1 = System.currentTimeMillis();
      Log.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
      if ((paramg.field_card_id == null) || (!paramg.field_card_id.equals(this.wru.djO()))) {
        break label652;
      }
      paramg = am.dkR().akS(this.wru.djO());
      if ((paramg != null) && (paramg.djL() != null))
      {
        i = this.wru.djL().status;
        Log.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramg.djL().status), Integer.valueOf(((ShareCardInfo)this.wru).field_status) });
        if (paramg.djL().status == i) {
          break label585;
        }
        dke();
      }
      c(this.wru);
      paramg = (Boolean)this.wrs.get(this.wru.djO());
      if ((paramg != null) && (paramg.booleanValue())) {
        break label769;
      }
      paramg = (Context)this.mContextRef.get();
      Log.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.wru.djO());
      com.tencent.mm.plugin.card.sharecard.a.b.a(paramg, this.wru);
      this.wrs.put(this.wru.djO(), Boolean.TRUE);
      long l2 = System.currentTimeMillis();
      paramg = new ArrayList();
      localObject = new IDKey();
      ((IDKey)localObject).SetID(281);
      ((IDKey)localObject).SetKey(30);
      ((IDKey)localObject).SetValue(1L);
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(281);
      localIDKey.SetKey(31);
      localIDKey.SetValue((int)(l2 - l1));
      paramg.add(localObject);
      paramg.add(localIDKey);
      com.tencent.mm.plugin.report.service.h.OAn.b(paramg, true);
    }
    for (;;)
    {
      dkg();
      AppMethodBeat.o(112607);
      return;
      label585:
      if (i == 1) {
        break;
      }
      Log.i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i)));
      paramg = this.wru.djL();
      paramg.status = 1;
      ((ShareCardInfo)this.wru).field_status = 1;
      this.wru.a(paramg);
      l.h(this.wru);
      break;
      label652:
      if (paramg.field_card_id == null) {
        break;
      }
      paramg = am.dkR().akS(paramg.field_card_id);
      if ((paramg != null) && (paramg.djL() != null))
      {
        Log.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[] { Integer.valueOf(paramg.djL().status), Integer.valueOf(paramg.field_status) });
        if (paramg.djL().status == 1) {
          break;
        }
        localObject = paramg.djL();
        ((vr)localObject).status = 1;
        paramg.field_status = 1;
        paramg.a((vr)localObject);
        l.h(paramg);
        break;
      }
      Log.w("MicroMsg.CardConsumedMgr", "tempCard is null");
      break;
      label769:
      Log.i("MicroMsg.CardConsumedMgr", "consumed:" + paramg.booleanValue());
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112602);
    this.wru = paramb;
    if ((this.wrv) && (this.wru != null) && (paramb.djO() != null) && (!paramb.djO().equals(this.wru.djO()))) {
      this.wrv = false;
    }
    if (this.eNV == null)
    {
      AppMethodBeat.o(112602);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        Boolean localBoolean = (Boolean)this.wrr.get(localObject);
        if ((localObject != null) && (localBoolean != null) && (!localBoolean.booleanValue())) {
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112602);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112601);
    if (this.eNV == null)
    {
      AppMethodBeat.o(112601);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.eNV.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.eNV.remove(localWeakReference);
          AppMethodBeat.o(112601);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112601);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(112604);
    if (this.wrr == null) {
      this.wrr = new HashMap();
    }
    this.wrr.remove(parama);
    AppMethodBeat.o(112604);
  }
  
  public final void djU()
  {
    AppMethodBeat.i(112605);
    Log.i("MicroMsg.CardConsumedMgr", "onDBchange()");
    if (this.wru == null)
    {
      Log.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
      AppMethodBeat.o(112605);
      return;
    }
    Object localObject1;
    label222:
    Object localObject2;
    if (this.wru.djp())
    {
      localObject1 = am.dkR().akS(this.wru.djO());
      if ((localObject1 != null) && (((com.tencent.mm.plugin.card.base.b)localObject1).djL() != null) && (this.wru != null) && (this.wru.djL() != null))
      {
        int i = this.wru.djL().status;
        Log.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.card.base.b)localObject1).djL().status), Boolean.valueOf(this.wrv), Boolean.valueOf(this.wru.djp()) });
        if ((!this.wru.djp()) || (!(this.wru instanceof ShareCardInfo))) {
          break label555;
        }
        Log.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[] { Integer.valueOf(((ShareCardInfo)this.wru).field_status) });
        if (((com.tencent.mm.plugin.card.base.b)localObject1).djL().status != i)
        {
          dke();
          if ((!this.wru.djp()) || (this.wrv) || (((com.tencent.mm.plugin.card.base.b)localObject1).djL().status != 1)) {
            break label607;
          }
          Log.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
          localObject2 = (Boolean)this.wrs.get(this.wru.djO());
          if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
            break label578;
          }
          Log.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
          long l1 = System.currentTimeMillis();
          localObject2 = (Context)this.mContextRef.get();
          Log.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.wru.djO());
          com.tencent.mm.plugin.card.sharecard.a.b.a((Context)localObject2, this.wru);
          this.wrs.put(this.wru.djO(), Boolean.TRUE);
          long l2 = System.currentTimeMillis();
          localObject2 = new ArrayList();
          IDKey localIDKey1 = new IDKey();
          localIDKey1.SetID(281);
          localIDKey1.SetKey(30);
          localIDKey1.SetValue(1L);
          IDKey localIDKey2 = new IDKey();
          localIDKey2.SetID(281);
          localIDKey2.SetKey(31);
          localIDKey2.SetValue((int)(l2 - l1));
          ((ArrayList)localObject2).add(localIDKey1);
          ((ArrayList)localObject2).add(localIDKey2);
          com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject2, true);
          label502:
          dkg();
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
      this.wru = ((com.tencent.mm.plugin.card.base.b)localObject1);
      c(this.wru);
      AppMethodBeat.o(112605);
      return;
      localObject1 = am.dkJ().akC(this.wru.djO());
      break;
      label555:
      if (!this.wru.djp()) {
        break label222;
      }
      Log.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
      break label222;
      label578:
      Log.i("MicroMsg.CardConsumedMgr", "consumed:" + ((Boolean)localObject2).booleanValue());
      break label502;
      label607:
      if ((this.wru.djp()) && (this.wrv))
      {
        Log.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
      }
      else
      {
        Log.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
        dkf();
      }
    }
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112606);
    dke();
    AppMethodBeat.o(112606);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112608);
    Log.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramp;
        if (!TextUtils.isEmpty(paramString.wuy)) {
          akt(paramString.wuy);
        }
        for (;;)
        {
          this.wrv = false;
          Log.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
          dkf();
          AppMethodBeat.o(112608);
          return;
          Log.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
        }
      }
    }
    else if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.d))
    {
      this.wrv = false;
      Log.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
      dkf();
      AppMethodBeat.o(112608);
      return;
    }
    AppMethodBeat.o(112608);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112599);
    com.tencent.mm.kernel.h.baD().mCm.b(910, this);
    am.dkQ().b(this);
    a locala = am.dkI();
    int i;
    if (locala.eNV != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < locala.eNV.size())
      {
        WeakReference localWeakReference = (WeakReference)locala.eNV.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.card.base.d locald = (com.tencent.mm.plugin.card.base.d)localWeakReference.get();
          if ((locald != null) && (locald.equals(this))) {
            locala.eNV.remove(localWeakReference);
          }
        }
      }
      else
      {
        this.eNV.clear();
        this.wrr.clear();
        this.wrt.clear();
        this.wrv = false;
        AppMethodBeat.o(112599);
        return;
      }
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aku(String paramString);
    
    public abstract void d(com.tencent.mm.plugin.card.base.b paramb);
    
    public abstract void dki();
    
    public abstract void dkj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.c
 * JD-Core Version:    0.7.0.1
 */