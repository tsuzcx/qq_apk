package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
  implements com.tencent.mm.ak.g, k.a, com.tencent.mm.plugin.card.base.d
{
  public WeakReference<Context> mContextRef;
  public List<WeakReference<a>> nTa;
  public HashMap<a, Boolean> nTm;
  public HashMap<String, Boolean> nTn;
  public HashMap<String, Boolean> nTo;
  public com.tencent.mm.plugin.card.base.b nTp;
  public boolean nTq;
  public String nTr;
  
  public d()
  {
    AppMethodBeat.i(112598);
    this.nTa = new ArrayList();
    this.nTm = new HashMap();
    this.nTn = new HashMap();
    this.nTo = new HashMap();
    this.nTp = null;
    this.nTq = false;
    AppMethodBeat.o(112598);
  }
  
  private void Uw(String paramString)
  {
    AppMethodBeat.i(112609);
    ac.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112609);
      return;
    }
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < this.nTa.size())
    {
      localObject = (WeakReference)this.nTa.get(j);
      if (localObject == null) {
        break label216;
      }
      localObject = (a)((WeakReference)localObject).get();
      Boolean localBoolean = (Boolean)this.nTm.get(localObject);
      if ((localObject == null) || (localBoolean == null) || (!localBoolean.booleanValue())) {
        break label216;
      }
      ((a)localObject).Ux(paramString);
      i = 1;
    }
    label216:
    for (;;)
    {
      j += 1;
      break;
      localObject = (Boolean)this.nTn.get(this.nTp.bPm());
      if (i != 0)
      {
        ac.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
        this.nTr = "";
        AppMethodBeat.o(112609);
        return;
      }
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        ac.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
        this.nTr = paramString;
        this.nTo.put(this.nTp.bPm(), Boolean.TRUE);
      }
      AppMethodBeat.o(112609);
      return;
    }
  }
  
  private void bPD()
  {
    AppMethodBeat.i(112611);
    ac.i("MicroMsg.CardConsumedMgr", "doVibrate()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112611);
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
          ((a)localObject).bPH();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112611);
  }
  
  private void bPE()
  {
    AppMethodBeat.i(112612);
    ac.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112612);
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
          ((a)localObject).bPI();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112612);
  }
  
  private void bPF()
  {
    AppMethodBeat.i(112613);
    ac.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
    bPG();
    AppMethodBeat.o(112613);
  }
  
  /* Error */
  private void bPG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 60	com/tencent/mm/plugin/card/b/d:nTq	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 69
    //   16: ldc 149
    //   18: invokestatic 76	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 147
    //   23: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 69
    //   31: ldc 151
    //   33: invokestatic 76	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 60	com/tencent/mm/plugin/card/b/d:nTq	Z
    //   41: new 153	com/tencent/mm/plugin/card/sharecard/model/d
    //   44: dup
    //   45: aload_0
    //   46: getfield 58	com/tencent/mm/plugin/card/b/d:nTp	Lcom/tencent/mm/plugin/card/base/b;
    //   49: invokeinterface 109 1 0
    //   54: ldc 113
    //   56: ldc 113
    //   58: invokespecial 156	com/tencent/mm/plugin/card/sharecard/model/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore_1
    //   62: invokestatic 162	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   65: getfield 168	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   68: aload_1
    //   69: iconst_0
    //   70: invokevirtual 173	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   73: pop
    //   74: ldc 147
    //   76: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -53 -> 26
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	d
    //   61	8	1	locald	com.tencent.mm.plugin.card.sharecard.model.d
    //   82	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	82	finally
    //   29	79	82	finally
  }
  
  private void c(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112610);
    ac.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
    if (this.nTa == null)
    {
      AppMethodBeat.o(112610);
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
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112610);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(112600);
    if (this.nTa == null) {
      this.nTa = new ArrayList();
    }
    this.nTa.add(new WeakReference(parama));
    AppMethodBeat.o(112600);
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112603);
    if (this.nTm == null) {
      this.nTm = new HashMap();
    }
    this.nTm.put(parama, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(112603);
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(112607);
    ac.i("MicroMsg.CardConsumedMgr", "onChange()");
    ac.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if (this.nTp == null)
    {
      ac.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
      bPE();
      AppMethodBeat.o(112607);
      return;
    }
    ac.i("MicroMsg.CardConsumedMgr", "card msg card id is " + paramg.field_card_id);
    if ((this.nTp.bON()) && (paramg.field_card_id != null) && (paramg.field_card_id.equals(this.nTp.bPm())) && (paramg.nWc == 3))
    {
      ac.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
      bPE();
      AppMethodBeat.o(112607);
      return;
    }
    if (!this.nTp.bOO())
    {
      ac.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
      bPE();
      AppMethodBeat.o(112607);
      return;
    }
    int i;
    Object localObject;
    if ((paramg.nWc == 3) || ((paramg.field_card_id != null) && (paramg.field_card_id.equals(this.nTp.bPm())) && (!TextUtils.isEmpty(paramg.field_consumed_box_id))))
    {
      long l1 = System.currentTimeMillis();
      ac.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
      if ((paramg.field_card_id == null) || (!paramg.field_card_id.equals(this.nTp.bPm()))) {
        break label652;
      }
      paramg = am.bQq().UV(this.nTp.bPm());
      if ((paramg != null) && (paramg.bPj() != null))
      {
        i = this.nTp.bPj().status;
        ac.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramg.bPj().status), Integer.valueOf(((ShareCardInfo)this.nTp).field_status) });
        if (paramg.bPj().status == i) {
          break label585;
        }
        bPD();
      }
      c(this.nTp);
      paramg = (Boolean)this.nTn.get(this.nTp.bPm());
      if ((paramg != null) && (paramg.booleanValue())) {
        break label769;
      }
      paramg = (Context)this.mContextRef.get();
      ac.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.nTp.bPm());
      com.tencent.mm.plugin.card.sharecard.a.b.a(paramg, this.nTp);
      this.nTn.put(this.nTp.bPm(), Boolean.TRUE);
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
      h.wUl.b(paramg, true);
    }
    for (;;)
    {
      bPF();
      AppMethodBeat.o(112607);
      return;
      label585:
      if (i == 1) {
        break;
      }
      ac.i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i)));
      paramg = this.nTp.bPj();
      paramg.status = 1;
      ((ShareCardInfo)this.nTp).field_status = 1;
      this.nTp.a(paramg);
      l.h(this.nTp);
      break;
      label652:
      if (paramg.field_card_id == null) {
        break;
      }
      paramg = am.bQq().UV(paramg.field_card_id);
      if ((paramg != null) && (paramg.bPj() != null))
      {
        ac.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[] { Integer.valueOf(paramg.bPj().status), Integer.valueOf(paramg.field_status) });
        if (paramg.bPj().status == 1) {
          break;
        }
        localObject = paramg.bPj();
        ((qy)localObject).status = 1;
        paramg.field_status = 1;
        paramg.a((qy)localObject);
        l.h(paramg);
        break;
      }
      ac.w("MicroMsg.CardConsumedMgr", "tempCard is null");
      break;
      label769:
      ac.i("MicroMsg.CardConsumedMgr", "consumed:" + paramg.booleanValue());
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(112601);
    if (this.nTa == null)
    {
      AppMethodBeat.o(112601);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nTa.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.nTa.remove(localWeakReference);
          AppMethodBeat.o(112601);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112601);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112602);
    this.nTp = paramb;
    if ((this.nTq) && (this.nTp != null) && (paramb.bPm() != null) && (!paramb.bPm().equals(this.nTp.bPm()))) {
      this.nTq = false;
    }
    if (this.nTa == null)
    {
      AppMethodBeat.o(112602);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      Object localObject = (WeakReference)this.nTa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        Boolean localBoolean = (Boolean)this.nTm.get(localObject);
        if ((localObject != null) && (localBoolean != null) && (!localBoolean.booleanValue())) {
          ((a)localObject).d(paramb);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112602);
  }
  
  public final void bPt()
  {
    AppMethodBeat.i(112605);
    ac.i("MicroMsg.CardConsumedMgr", "onDBchange()");
    if (this.nTp == null)
    {
      ac.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
      AppMethodBeat.o(112605);
      return;
    }
    Object localObject1;
    label222:
    Object localObject2;
    if (this.nTp.bOO())
    {
      localObject1 = am.bQq().UV(this.nTp.bPm());
      if ((localObject1 != null) && (((com.tencent.mm.plugin.card.base.b)localObject1).bPj() != null) && (this.nTp != null) && (this.nTp.bPj() != null))
      {
        int i = this.nTp.bPj().status;
        ac.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.card.base.b)localObject1).bPj().status), Boolean.valueOf(this.nTq), Boolean.valueOf(this.nTp.bOO()) });
        if ((!this.nTp.bOO()) || (!(this.nTp instanceof ShareCardInfo))) {
          break label555;
        }
        ac.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[] { Integer.valueOf(((ShareCardInfo)this.nTp).field_status) });
        if (((com.tencent.mm.plugin.card.base.b)localObject1).bPj().status != i)
        {
          bPD();
          if ((!this.nTp.bOO()) || (this.nTq) || (((com.tencent.mm.plugin.card.base.b)localObject1).bPj().status != 1)) {
            break label607;
          }
          ac.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
          localObject2 = (Boolean)this.nTn.get(this.nTp.bPm());
          if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
            break label578;
          }
          ac.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
          long l1 = System.currentTimeMillis();
          localObject2 = (Context)this.mContextRef.get();
          ac.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.nTp.bPm());
          com.tencent.mm.plugin.card.sharecard.a.b.a((Context)localObject2, this.nTp);
          this.nTn.put(this.nTp.bPm(), Boolean.TRUE);
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
          h.wUl.b((ArrayList)localObject2, true);
          label502:
          bPF();
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
      this.nTp = ((com.tencent.mm.plugin.card.base.b)localObject1);
      c(this.nTp);
      AppMethodBeat.o(112605);
      return;
      localObject1 = am.bQi().UF(this.nTp.bPm());
      break;
      label555:
      if (!this.nTp.bOO()) {
        break label222;
      }
      ac.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
      break label222;
      label578:
      ac.i("MicroMsg.CardConsumedMgr", "consumed:" + ((Boolean)localObject2).booleanValue());
      break label502;
      label607:
      if ((this.nTp.bOO()) && (this.nTq))
      {
        ac.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
      }
      else
      {
        ac.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
        bPE();
      }
    }
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(112604);
    if (this.nTm == null) {
      this.nTm = new HashMap();
    }
    this.nTm.remove(parama);
    AppMethodBeat.o(112604);
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(112606);
    bPD();
    AppMethodBeat.o(112606);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112608);
    ac.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramn;
        if (!TextUtils.isEmpty(paramString.nWw)) {
          Uw(paramString.nWw);
        }
        for (;;)
        {
          this.nTq = false;
          ac.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
          bPE();
          AppMethodBeat.o(112608);
          return;
          ac.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
        }
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
    {
      this.nTq = false;
      ac.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
      bPE();
      AppMethodBeat.o(112608);
      return;
    }
    AppMethodBeat.o(112608);
  }
  
  public final void release()
  {
    AppMethodBeat.i(112599);
    com.tencent.mm.kernel.g.agQ().ghe.b(910, this);
    am.bQp().b(this);
    b localb = am.bQh();
    int i;
    if (localb.nTa != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < localb.nTa.size())
      {
        WeakReference localWeakReference = (WeakReference)localb.nTa.get(i);
        if (localWeakReference != null)
        {
          com.tencent.mm.plugin.card.base.d locald = (com.tencent.mm.plugin.card.base.d)localWeakReference.get();
          if ((locald != null) && (locald.equals(this))) {
            localb.nTa.remove(localWeakReference);
          }
        }
      }
      else
      {
        this.nTa.clear();
        this.nTm.clear();
        this.nTo.clear();
        this.nTq = false;
        AppMethodBeat.o(112599);
        return;
      }
      i += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Ux(String paramString);
    
    public abstract void bPH();
    
    public abstract void bPI();
    
    public abstract void d(com.tencent.mm.plugin.card.base.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.d
 * JD-Core Version:    0.7.0.1
 */