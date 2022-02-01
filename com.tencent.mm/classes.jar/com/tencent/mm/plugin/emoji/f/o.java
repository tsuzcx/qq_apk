package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.a.dq;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  private final int mScene;
  public final int mType;
  private final d rr;
  public byte[] uGe;
  public int uGg;
  private boolean uGh;
  private ArrayList<akh> uGi;
  
  public o(int paramInt1, int paramInt2)
  {
    this(paramInt1, null, paramInt2);
  }
  
  public o(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this(paramInt1, paramArrayOfByte, paramInt2, false);
  }
  
  public o(int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(108706);
    this.uGh = false;
    this.uGi = new ArrayList();
    this.uGe = null;
    d.a locala = new d.a();
    locala.lBU = new bug();
    locala.lBV = new buh();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionlist";
    locala.funcId = 411;
    locala.lBW = 210;
    locala.respCmdId = 1000000210;
    this.rr = locala.bgN();
    this.uGe = paramArrayOfByte;
    this.mType = paramInt1;
    this.mScene = paramInt2;
    this.uGh = paramBoolean;
    Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "NetSceneGetEmotionList: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(108706);
  }
  
  public static l a(buh parambuh)
  {
    AppMethodBeat.i(108709);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
    if (parambuh == null)
    {
      AppMethodBeat.o(108709);
      return null;
    }
    l locall = new l();
    if (parambuh != null)
    {
      locall.uEw = parambuh.VHV;
      Object localObject1 = new ArrayList();
      if ((parambuh.Tek != null) && (!parambuh.Tek.isEmpty()))
      {
        Object[] arrayOfObject = parambuh.Tek.toArray();
        if ((arrayOfObject != null) && (arrayOfObject.length > 0))
        {
          int j = arrayOfObject.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = arrayOfObject[i];
            if ((localObject2 != null) && ((localObject2 instanceof akh)))
            {
              localObject2 = (akh)localObject2;
              if ((localObject2 != null) && (!Util.isNullOrNil(((akh)localObject2).ProductID))) {
                ((List)localObject1).add(new com.tencent.mm.plugin.emoji.a.a.f((akh)localObject2));
              }
            }
            i += 1;
          }
        }
      }
      locall.uEx = ((List)localObject1);
      locall.uEy = parambuh.VHW;
      locall.uEz = parambuh.VHY;
      localObject1 = parambuh.VIe;
      if (locall.uEB == null)
      {
        locall.uEB = new LinkedList();
        locall.uEB.addAll((Collection)localObject1);
      }
      locall.uEA = parambuh.VIa;
    }
    AppMethodBeat.o(108709);
    return locall;
  }
  
  private void cVh()
  {
    AppMethodBeat.i(108710);
    buh localbuh = cVg();
    if ((localbuh != null) && (localbuh.Tek != null) && (localbuh.Tek.size() > 0))
    {
      this.uGi.addAll(localbuh.Tek);
      AppMethodBeat.o(108710);
      return;
    }
    Log.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
    AppMethodBeat.o(108710);
  }
  
  public final buh cVg()
  {
    AppMethodBeat.i(257168);
    if (this.rr == null)
    {
      AppMethodBeat.o(257168);
      return null;
    }
    buh localbuh = (buh)d.c.b(this.rr.lBS);
    AppMethodBeat.o(257168);
    return localbuh;
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(108707);
    this.callback = parami;
    bug localbug = (bug)d.b.b(this.rr.lBR);
    if (this.uGe != null)
    {
      localbug.RJA = z.aN(this.uGe);
      if (localbug.RJA != null) {
        break label133;
      }
    }
    label133:
    for (parami = "Buf is NULL";; parami = localbug.RJA.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetEmotionList", parami);
      localbug.lpw = this.mType;
      localbug.CPw = this.mScene;
      if (this.mType == 7) {
        localbug.Tei = this.uGg;
      }
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108707);
      return i;
      localbug.RJA = new eae();
      break;
    }
  }
  
  public final int getType()
  {
    return 411;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108708);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if (this.mType == 8)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgH, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else if (this.mType == 11)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label185;
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgL, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      p.getEmojiStorageMgr().VFK.a(this.mType, cVg());
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break label214;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgH, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      break;
      label185:
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgL, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    label214:
    paramArrayOfByte = (buh)d.c.b(((d)params).lBS);
    if (paramArrayOfByte.RJA != null) {
      this.uGe = z.a(paramArrayOfByte.RJA);
    }
    if (this.mType == 8)
    {
      if (paramInt3 == 0)
      {
        cVh();
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179057);
            o.a(o.this, o.a(o.this));
            AppMethodBeat.o(179057);
          }
        });
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgH, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else
    {
      if ((this.mType != 1) && (this.mType != 9)) {
        break label525;
      }
      params = j.cUG();
      paramArrayOfByte = cVg().VIf;
      if (!Util.isEqual(params.uEp, paramArrayOfByte))
      {
        params.uEp = paramArrayOfByte;
        params.cUH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvv, paramArrayOfByte);
        EventCenter.instance.publish(new dq());
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      if (paramInt3 == 2)
      {
        cVh();
        ((bug)d.b.b(((d)params).lBR)).RJA = ((buh)d.c.b(((d)params).lBS)).RJA;
        doScene(dispatcher(), this.callback);
        break;
      }
      if (paramInt3 != 3) {
        break;
      }
      if (this.uGi != null) {
        this.uGi.clear();
      }
      ((bug)d.b.b(((d)params).lBR)).RJA = new eae();
      doScene(dispatcher(), this.callback);
      break;
      label525:
      if (this.mType == 5)
      {
        params = j.cUG();
        paramArrayOfByte = cVg().VIf;
        if (!Util.isEqual(params.uEo, paramArrayOfByte))
        {
          params.uEo = paramArrayOfByte;
          params.cUH();
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvw, paramArrayOfByte);
          EventCenter.instance.publish(new dq());
        }
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.o
 * JD-Core Version:    0.7.0.1
 */