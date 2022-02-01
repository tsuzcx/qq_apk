package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.ao.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class aj
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private final com.tencent.mm.al.b rr;
  public g rtA;
  private boolean rtB;
  private boolean rtC;
  HashMap<ajn, Boolean> rtD;
  private int rtz;
  
  public aj(g paramg)
  {
    AppMethodBeat.i(103471);
    this.rtz = 0;
    this.callback = null;
    this.rtB = true;
    this.rtC = false;
    this.rtD = new HashMap();
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new wl();
    ((b.a)localObject).hNN = new wm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((b.a)localObject).funcId = 404;
    ((b.a)localObject).hNO = 197;
    ((b.a)localObject).respCmdId = 1000000197;
    this.rr = ((b.a)localObject).aDC();
    this.rtA = paramg;
    paramg = paramg.field_favProto.nZa.iterator();
    while (paramg.hasNext())
    {
      localObject = (ajn)paramg.next();
      this.rtD.put(localObject, Boolean.FALSE);
    }
    AppMethodBeat.o(103471);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(103472);
    this.callback = paramf;
    paramf = this.rtD.keySet().iterator();
    int j = 0;
    Object localObject;
    if (paramf.hasNext())
    {
      localObject = (ajn)paramf.next();
      if (((Boolean)this.rtD.get(localObject)).booleanValue()) {
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
        ad.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
        this.rtz = -100;
        AppMethodBeat.o(103472);
        return -100;
      }
      paramf = (wl)this.rr.hNK.hNQ;
      paramf.nDj.clear();
      localObject = this.rtA.field_favProto.nZa;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        ajn localajn = (ajn)((List)localObject).get(m);
        if (((Boolean)this.rtD.get(localajn)).booleanValue()) {
          break label653;
        }
        k = i;
        if (!localajn.GhD)
        {
          localwk = new wk();
          localwk.FVN = ((int)localajn.Ghm);
          localwk.FVL = localajn.Ghi;
          localwk.FVM = localajn.Ghk;
          localwk.FVK = String.valueOf(m);
          localwk.FVP = localajn.Ghz;
          localwk.FVO = this.rtA.field_sourceType;
          localwk.FVQ = 0;
          paramf.nDj.add(localwk);
          k = i + 1;
          ad.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localwk.FVK, localwk.FVP, Integer.valueOf(localwk.FVO), Integer.valueOf(localwk.FVN), localwk.FVL, localwk.FVM });
        }
        if (localajn.GhF) {
          break label647;
        }
        wk localwk = new wk();
        localwk.FVN = ((int)localajn.Ghx);
        localwk.FVL = localajn.Ght;
        localwk.FVM = localajn.Ghv;
        localwk.FVP = localajn.Ghz;
        localwk.FVO = this.rtA.field_sourceType;
        localwk.FVK = (m + "t");
        localwk.FVQ = 1;
        paramf.nDj.add(localwk);
        i = k + 1;
        ad.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localwk.FVK, localwk.FVP, Integer.valueOf(localwk.FVO), Integer.valueOf(localwk.FVN), localwk.FVL, localwk.FVM });
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
        ad.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m + 1) });
        paramf.nDi = k;
        if (k == 0)
        {
          ad.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.rtz = -101;
          AppMethodBeat.o(103472);
          return -101;
        }
        i = dispatch(parame, this.rr, this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103473);
    ad.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.rtz), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.rtz == -100))
      {
        ad.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ad(9, this.rtA.field_localId);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if ((paramInt2 != 3) || (this.rtz != -101)) {
        break label828;
      }
      i = 0;
    }
    if ((this.rtz != -101) && (paramInt2 == 0) && (i == 0))
    {
      paramq = ((wm)((com.tencent.mm.al.b)paramq).hNL.hNQ).nDj;
      paramArrayOfByte = this.rtA.field_favProto.nZa;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < paramq.size())
      {
        localObject1 = (ajm)paramq.get(paramInt1);
        localObject2 = ((ajm)localObject1).FVK;
        ajn localajn;
        if (!bt.isNullOrNil((String)localObject2))
        {
          ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((ajm)localObject1).nDG), localObject2 });
          if (((ajm)localObject1).nDG == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label849;
            }
            localajn = (ajn)paramArrayOfByte.get(bt.getInt((String)localObject2, 0));
            ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((ajm)localObject1).GgI, ((ajm)localObject1).FOH, ((ajm)localObject1).FVK, ((ajm)localObject1).FVL, Integer.valueOf(((ajm)localObject1).FVN), ((ajm)localObject1).FVM });
            localajn.aOk(((ajm)localObject1).FOH);
            localajn.aOj(((ajm)localObject1).GgI);
            if (!bt.isNullOrNil(((ajm)localObject1).FGh)) {
              localajn.aOy(((ajm)localObject1).FGh);
            }
            if (bt.isNullOrNil(localajn.Ghi))
            {
              ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              localajn.aOq(((ajm)localObject1).FVL);
              localajn.CG(((ajm)localObject1).FVN);
              localajn.aOr(((ajm)localObject1).FVM);
              b.a(localajn, this.rtA, 1, false);
            }
            if ((!bt.isNullOrNil(((ajm)localObject1).FVL)) && (!((ajm)localObject1).FVL.equals(localajn.Ghi)))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((ajm)localObject1).FVL, localajn.Ghi });
              localajn.aOq(((ajm)localObject1).FVL);
            }
            if ((!bt.isNullOrNil(((ajm)localObject1).FVM)) && (!((ajm)localObject1).FVM.equals(localajn.Ghk)))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((ajm)localObject1).FVM, localajn.Ghk });
              localajn.aOr(((ajm)localObject1).FVM);
            }
            if ((((ajm)localObject1).FVN > 0) && (((ajm)localObject1).FVN != localajn.Ghm))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((ajm)localObject1).FVN), Long.valueOf(localajn.Ghm) });
              localajn.CG(((ajm)localObject1).FVN);
            }
          }
          label701:
          if (((String)localObject2).endsWith("t")) {
            break label1119;
          }
          localajn = (ajn)paramArrayOfByte.get(bt.getInt((String)localObject2, 0));
          this.rtD.put(localajn, Boolean.TRUE);
          label743:
          if ((((ajm)localObject1).nDG == 1) || (((ajm)localObject1).nDG == 2)) {
            break label1253;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1594;
          }
          localajn = (ajn)paramArrayOfByte.get(bt.getInt((String)localObject2, 0));
          if (!bt.isNullOrNil(localajn.Ghi)) {
            break label1164;
          }
          ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { localajn.Ghi });
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
          localajn = (ajn)paramArrayOfByte.get(bt.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((ajm)localObject1).GgI, ((ajm)localObject1).FOH, ((ajm)localObject1).FVK, ((ajm)localObject1).FVL, Integer.valueOf(((ajm)localObject1).FVN), ((ajm)localObject1).FVM });
          localajn.aOi(((ajm)localObject1).FOH);
          localajn.aOh(((ajm)localObject1).GgI);
          if (((ajm)localObject1).FVN <= 0) {
            break label701;
          }
          localajn.CH(((ajm)localObject1).FVN);
          if ((!bt.isNullOrNil(((ajm)localObject1).FVL)) && (!((ajm)localObject1).FVL.equals(localajn.Ght)))
          {
            ad.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((ajm)localObject1).FVL, localajn.Ght });
            localajn.aOv(((ajm)localObject1).FVL);
          }
          if ((bt.isNullOrNil(((ajm)localObject1).FVM)) || (((ajm)localObject1).FVM.equals(localajn.Ghv))) {
            break label701;
          }
          ad.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((ajm)localObject1).FVM, localajn.Ghv });
          localajn.aOw(((ajm)localObject1).FVM);
          break label701;
          label1119:
          localajn = (ajn)paramArrayOfByte.get(bt.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.rtD.put(localajn, Boolean.TRUE);
          break label743;
          label1164:
          this.rtB = false;
          String str;
          if (bt.isNullOrNil(localajn.GgT))
          {
            com.tencent.mm.ao.f.aGJ();
            str = a.aGz();
            localajn.aOk(str);
            ad.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
          }
          ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { localajn.Ghi, localajn.GgT });
          b.a(localajn, this.rtA, 0, false);
          for (;;)
          {
            label1253:
            if (((ajm)localObject1).nDG != 2) {
              break label1746;
            }
            this.rtC = true;
            if (((String)localObject2).endsWith("t")) {
              break label1748;
            }
            ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((ajm)localObject1).GgJ), ((ajm)localObject1).GgI, ((ajm)localObject1).FOH });
            localObject2 = (ajn)paramArrayOfByte.get(bt.getInt((String)localObject2, 0));
            ((ajn)localObject2).ZJ(((ajm)localObject1).GgJ);
            ((ajn)localObject2).aOk(((ajm)localObject1).FOH);
            ((ajn)localObject2).aOj(((ajm)localObject1).GgI);
            if (!bt.isNullOrNil(((ajm)localObject1).FGh)) {
              ((ajn)localObject2).aOy(((ajm)localObject1).FGh);
            }
            if ((!bt.isNullOrNil(((ajm)localObject1).FVL)) && (!((ajm)localObject1).FVL.equals(((ajn)localObject2).Ghi)))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((ajm)localObject1).FVL, ((ajn)localObject2).Ghi });
              ((ajn)localObject2).aOq(((ajm)localObject1).FVL);
            }
            if ((!bt.isNullOrNil(((ajm)localObject1).FVM)) && (!((ajm)localObject1).FVM.equals(((ajn)localObject2).Ghk)))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((ajm)localObject1).FVM, ((ajn)localObject2).Ghk });
              ((ajn)localObject2).aOr(((ajm)localObject1).FVM);
            }
            if ((((ajm)localObject1).FVN <= 0) || (((ajm)localObject1).FVN == ((ajn)localObject2).Ghm)) {
              break;
            }
            ad.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((ajm)localObject1).FVN), Long.valueOf(((ajn)localObject2).Ghm) });
            ((ajn)localObject2).CG(((ajm)localObject1).FVN);
            break;
            label1594:
            localajn = (ajn)paramArrayOfByte.get(bt.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (bt.isNullOrNil(localajn.Ght))
            {
              ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { localajn.Ght });
              break;
            }
            this.rtB = false;
            if (bt.isNullOrNil(localajn.GgT))
            {
              com.tencent.mm.ao.f.aGJ();
              str = a.aGz();
              localajn.aOk(str);
              ad.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
            }
            ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { localajn.Ghi, localajn.GgT });
            b.a(localajn, this.rtA, 0);
          }
          label1746:
          continue;
          label1748:
          ad.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.rtD.keySet().iterator();
      paramInt1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ajn)((Iterator)localObject1).next();
        if (((Boolean)this.rtD.get(localObject2)).booleanValue()) {
          break label2311;
        }
        paramInt1 += 1;
      }
    }
    label2311:
    for (;;)
    {
      break;
      ad.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[] { Integer.valueOf(paramq.size()), Integer.valueOf(paramArrayOfByte.size()) });
      if (paramInt1 > 0)
      {
        ad.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
        paramInt1 = doScene(dispatcher(), this.callback);
        if ((paramInt1 != -100) && (paramInt1 != -101))
        {
          AppMethodBeat.o(103473);
          return;
        }
      }
      if (this.rtC)
      {
        ad.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
        this.rtA.field_itemStatus = 12;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rtA, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, i, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if (this.rtB)
      {
        ad.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
        if (this.rtA.field_id > 0)
        {
          this.rtA.field_itemStatus = 17;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rtA, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(103473);
          return;
          if (this.rtA.field_type == 18) {
            this.rtA.field_favProto.ZQ(1);
          }
          this.rtA.field_itemStatus = 9;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rtA, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        }
      }
      if (this.rtA.field_id > 0) {}
      for (this.rtA.field_itemStatus = 15;; this.rtA.field_itemStatus = 4)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rtA, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
        break;
        if (this.rtA.field_type == 18) {
          this.rtA.field_favProto.ZQ(1);
        }
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */