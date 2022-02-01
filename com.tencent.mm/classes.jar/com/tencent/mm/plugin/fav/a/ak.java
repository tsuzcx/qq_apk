package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.aq.a;
import com.tencent.mm.aq.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class ak
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private int wHv;
  public g wHw;
  private boolean wHx;
  private boolean wHy;
  HashMap<anm, Boolean> wHz;
  
  public ak(g paramg)
  {
    AppMethodBeat.i(103471);
    this.wHv = 0;
    this.callback = null;
    this.wHx = true;
    this.wHy = false;
    this.wHz = new HashMap();
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ye();
    ((d.a)localObject).lBV = new yf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((d.a)localObject).funcId = 404;
    ((d.a)localObject).lBW = 197;
    ((d.a)localObject).respCmdId = 1000000197;
    this.rr = ((d.a)localObject).bgN();
    this.wHw = paramg;
    paramg = paramg.field_favProto.syG.iterator();
    while (paramg.hasNext())
    {
      localObject = (anm)paramg.next();
      this.wHz.put(localObject, Boolean.FALSE);
    }
    AppMethodBeat.o(103471);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(103472);
    this.callback = parami;
    parami = this.wHz.keySet().iterator();
    int j = 0;
    Object localObject;
    if (parami.hasNext())
    {
      localObject = (anm)parami.next();
      if (((Boolean)this.wHz.get(localObject)).booleanValue()) {
        break label656;
      }
    }
    label647:
    label653:
    label656:
    for (int i = j + 1;; i = j)
    {
      j = i;
      break;
      if (j == 0)
      {
        Log.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
        this.wHv = -100;
        AppMethodBeat.o(103472);
        return -100;
      }
      parami = (ye)d.b.b(this.rr.lBR);
      parami.rVy.clear();
      localObject = this.wHw.field_favProto.syG;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        anm localanm = (anm)((List)localObject).get(m);
        if (((Boolean)this.wHz.get(localanm)).booleanValue()) {
          break label653;
        }
        k = i;
        if (!localanm.Syy)
        {
          localyd = new yd();
          localyd.Sko = ((int)localanm.Syi);
          localyd.Skm = localanm.Sye;
          localyd.Skn = localanm.Syg;
          localyd.Skl = String.valueOf(m);
          localyd.Skq = localanm.Syu;
          localyd.Skp = this.wHw.field_sourceType;
          localyd.Skr = 0;
          parami.rVy.add(localyd);
          k = i + 1;
          Log.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localyd.Skl, localyd.Skq, Integer.valueOf(localyd.Skp), Integer.valueOf(localyd.Sko), localyd.Skm, localyd.Skn });
        }
        if (localanm.SyA) {
          break label647;
        }
        yd localyd = new yd();
        localyd.Sko = ((int)localanm.Sys);
        localyd.Skm = localanm.Kll;
        localyd.Skn = localanm.Syq;
        localyd.Skq = localanm.Syu;
        localyd.Skp = this.wHw.field_sourceType;
        localyd.Skl = (m + "t");
        localyd.Skr = 1;
        parami.rVy.add(localyd);
        i = k + 1;
        Log.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localyd.Skl, localyd.Skq, Integer.valueOf(localyd.Skp), Integer.valueOf(localyd.Sko), localyd.Skm, localyd.Skn });
        label537:
        k = i;
        if (i >= 19) {
          break label558;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        k = i;
        label558:
        Log.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m + 1) });
        parami.rVx = k;
        if (k == 0)
        {
          Log.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.wHv = -101;
          AppMethodBeat.o(103472);
          return -101;
        }
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(103472);
        return i;
        i = k;
        break label537;
      }
    }
  }
  
  public final int getType()
  {
    return 404;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103473);
    Log.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.wHv), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.wHv == -100))
      {
        Log.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((ag)h.ag(ag.class)).getFavItemInfoStorage().ag(9, this.wHw.field_localId);
        ((ag)h.ag(ag.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if ((paramInt2 != 3) || (this.wHv != -101)) {
        break label828;
      }
      i = 0;
    }
    if ((this.wHv != -101) && (paramInt2 == 0) && (i == 0))
    {
      params = ((yf)d.c.b(((d)params).lBS)).rVy;
      paramArrayOfByte = this.wHw.field_favProto.syG;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < params.size())
      {
        localObject1 = (anl)params.get(paramInt1);
        localObject2 = ((anl)localObject1).Skl;
        anm localanm;
        if (!Util.isNullOrNil((String)localObject2))
        {
          Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((anl)localObject1).rVU), localObject2 });
          if (((anl)localObject1).rVU == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label849;
            }
            localanm = (anm)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((anl)localObject1).SxF, ((anl)localObject1).ScV, ((anl)localObject1).Skl, ((anl)localObject1).Skm, Integer.valueOf(((anl)localObject1).Sko), ((anl)localObject1).Skn });
            localanm.bsC(((anl)localObject1).ScV);
            localanm.bsB(((anl)localObject1).SxF);
            if (!Util.isNullOrNil(((anl)localObject1).RTv)) {
              localanm.bsQ(((anl)localObject1).RTv);
            }
            if (Util.isNullOrNil(localanm.Sye))
            {
              Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              localanm.bsI(((anl)localObject1).Skm);
              localanm.TY(((anl)localObject1).Sko);
              localanm.bsJ(((anl)localObject1).Skn);
              b.a(localanm, this.wHw, 1, false);
            }
            if ((!Util.isNullOrNil(((anl)localObject1).Skm)) && (!((anl)localObject1).Skm.equals(localanm.Sye)))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((anl)localObject1).Skm, localanm.Sye });
              localanm.bsI(((anl)localObject1).Skm);
            }
            if ((!Util.isNullOrNil(((anl)localObject1).Skn)) && (!((anl)localObject1).Skn.equals(localanm.Syg)))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((anl)localObject1).Skn, localanm.Syg });
              localanm.bsJ(((anl)localObject1).Skn);
            }
            if ((((anl)localObject1).Sko > 0) && (((anl)localObject1).Sko != localanm.Syi))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((anl)localObject1).Sko), Long.valueOf(localanm.Syi) });
              localanm.TY(((anl)localObject1).Sko);
            }
          }
          label701:
          if (((String)localObject2).endsWith("t")) {
            break label1119;
          }
          localanm = (anm)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
          this.wHz.put(localanm, Boolean.TRUE);
          label743:
          if ((((anl)localObject1).rVU == 1) || (((anl)localObject1).rVU == 2)) {
            break label1253;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1594;
          }
          localanm = (anm)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
          if (!Util.isNullOrNil(localanm.Sye)) {
            break label1164;
          }
          Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { localanm.Sye });
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label828:
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(103473);
          return;
          label849:
          localanm = (anm)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((anl)localObject1).SxF, ((anl)localObject1).ScV, ((anl)localObject1).Skl, ((anl)localObject1).Skm, Integer.valueOf(((anl)localObject1).Sko), ((anl)localObject1).Skn });
          localanm.bsA(((anl)localObject1).ScV);
          localanm.bsz(((anl)localObject1).SxF);
          if (((anl)localObject1).Sko <= 0) {
            break label701;
          }
          localanm.TZ(((anl)localObject1).Sko);
          if ((!Util.isNullOrNil(((anl)localObject1).Skm)) && (!((anl)localObject1).Skm.equals(localanm.Kll)))
          {
            Log.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((anl)localObject1).Skm, localanm.Kll });
            localanm.bsN(((anl)localObject1).Skm);
          }
          if ((Util.isNullOrNil(((anl)localObject1).Skn)) || (((anl)localObject1).Skn.equals(localanm.Syq))) {
            break label701;
          }
          Log.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((anl)localObject1).Skn, localanm.Syq });
          localanm.bsO(((anl)localObject1).Skn);
          break label701;
          label1119:
          localanm = (anm)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.wHz.put(localanm, Boolean.TRUE);
          break label743;
          label1164:
          this.wHx = false;
          String str;
          if (Util.isNullOrNil(localanm.SxP))
          {
            f.bkh();
            str = a.bjV();
            localanm.bsC(str);
            Log.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
          }
          Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { localanm.Sye, localanm.SxP });
          b.a(localanm, this.wHw, 0, false);
          for (;;)
          {
            label1253:
            if (((anl)localObject1).rVU != 2) {
              break label1746;
            }
            this.wHy = true;
            if (((String)localObject2).endsWith("t")) {
              break label1748;
            }
            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((anl)localObject1).SxG), ((anl)localObject1).SxF, ((anl)localObject1).ScV });
            localObject2 = (anm)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
            ((anm)localObject2).arr(((anl)localObject1).SxG);
            ((anm)localObject2).bsC(((anl)localObject1).ScV);
            ((anm)localObject2).bsB(((anl)localObject1).SxF);
            if (!Util.isNullOrNil(((anl)localObject1).RTv)) {
              ((anm)localObject2).bsQ(((anl)localObject1).RTv);
            }
            if ((!Util.isNullOrNil(((anl)localObject1).Skm)) && (!((anl)localObject1).Skm.equals(((anm)localObject2).Sye)))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((anl)localObject1).Skm, ((anm)localObject2).Sye });
              ((anm)localObject2).bsI(((anl)localObject1).Skm);
            }
            if ((!Util.isNullOrNil(((anl)localObject1).Skn)) && (!((anl)localObject1).Skn.equals(((anm)localObject2).Syg)))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((anl)localObject1).Skn, ((anm)localObject2).Syg });
              ((anm)localObject2).bsJ(((anl)localObject1).Skn);
            }
            if ((((anl)localObject1).Sko <= 0) || (((anl)localObject1).Sko == ((anm)localObject2).Syi)) {
              break;
            }
            Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((anl)localObject1).Sko), Long.valueOf(((anm)localObject2).Syi) });
            ((anm)localObject2).TY(((anl)localObject1).Sko);
            break;
            label1594:
            localanm = (anm)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (Util.isNullOrNil(localanm.Kll))
            {
              Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { localanm.Kll });
              break;
            }
            this.wHx = false;
            if (Util.isNullOrNil(localanm.SxP))
            {
              f.bkh();
              str = a.bjV();
              localanm.bsC(str);
              Log.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
            }
            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { localanm.Sye, localanm.SxP });
            b.a(localanm, this.wHw, 0);
          }
          label1746:
          continue;
          label1748:
          Log.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.wHz.keySet().iterator();
      paramInt1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (anm)((Iterator)localObject1).next();
        if (((Boolean)this.wHz.get(localObject2)).booleanValue()) {
          break label2311;
        }
        paramInt1 += 1;
      }
    }
    label2311:
    for (;;)
    {
      break;
      Log.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[] { Integer.valueOf(params.size()), Integer.valueOf(paramArrayOfByte.size()) });
      if (paramInt1 > 0)
      {
        Log.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
        paramInt1 = doScene(dispatcher(), this.callback);
        if ((paramInt1 != -100) && (paramInt1 != -101))
        {
          AppMethodBeat.o(103473);
          return;
        }
      }
      if (this.wHy)
      {
        Log.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
        this.wHw.field_itemStatus = 12;
        ((ag)h.ag(ag.class)).getFavItemInfoStorage().a(this.wHw, new String[] { "localId" });
        ((ag)h.ag(ag.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, i, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if (this.wHx)
      {
        Log.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
        if (this.wHw.field_id > 0)
        {
          this.wHw.field_itemStatus = 17;
          ((ag)h.ag(ag.class)).getFavItemInfoStorage().a(this.wHw, new String[] { "localId" });
          ((ag)h.ag(ag.class)).getModService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(103473);
          return;
          if (this.wHw.field_type == 18) {
            this.wHw.field_favProto.ary(1);
          }
          this.wHw.field_itemStatus = 9;
          ((ag)h.ag(ag.class)).getFavItemInfoStorage().a(this.wHw, new String[] { "localId" });
          ((ag)h.ag(ag.class)).getSendService().run();
        }
      }
      if (this.wHw.field_id > 0) {}
      for (this.wHw.field_itemStatus = 15;; this.wHw.field_itemStatus = 4)
      {
        ((ag)h.ag(ag.class)).getFavItemInfoStorage().a(this.wHw, new String[] { "localId" });
        ((ag)h.ag(ag.class)).getFavCdnService().run();
        break;
        if (this.wHw.field_type == 18) {
          this.wHw.field_favProto.ary(1);
        }
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ak
 * JD-Core Version:    0.7.0.1
 */