package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.an.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class aj
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private int rBL;
  public g rBM;
  private boolean rBN;
  private boolean rBO;
  HashMap<ajx, Boolean> rBP;
  private final com.tencent.mm.ak.b rr;
  
  public aj(g paramg)
  {
    AppMethodBeat.i(103471);
    this.rBL = 0;
    this.callback = null;
    this.rBN = true;
    this.rBO = false;
    this.rBP = new HashMap();
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new wo();
    ((b.a)localObject).hQG = new wp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((b.a)localObject).funcId = 404;
    ((b.a)localObject).hQH = 197;
    ((b.a)localObject).respCmdId = 1000000197;
    this.rr = ((b.a)localObject).aDS();
    this.rBM = paramg;
    paramg = paramg.field_favProto.oeJ.iterator();
    while (paramg.hasNext())
    {
      localObject = (ajx)paramg.next();
      this.rBP.put(localObject, Boolean.FALSE);
    }
    AppMethodBeat.o(103471);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(103472);
    this.callback = paramf;
    paramf = this.rBP.keySet().iterator();
    int j = 0;
    Object localObject;
    if (paramf.hasNext())
    {
      localObject = (ajx)paramf.next();
      if (((Boolean)this.rBP.get(localObject)).booleanValue()) {
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
        ae.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
        this.rBL = -100;
        AppMethodBeat.o(103472);
        return -100;
      }
      paramf = (wo)this.rr.hQD.hQJ;
      paramf.nIE.clear();
      localObject = this.rBM.field_favProto.oeJ;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        ajx localajx = (ajx)((List)localObject).get(m);
        if (((Boolean)this.rBP.get(localajx)).booleanValue()) {
          break label653;
        }
        k = i;
        if (!localajx.GAm)
        {
          localwn = new wn();
          localwn.Gom = ((int)localajx.GzV);
          localwn.Gok = localajx.GzR;
          localwn.Gol = localajx.GzT;
          localwn.Goj = String.valueOf(m);
          localwn.Goo = localajx.GAi;
          localwn.Gon = this.rBM.field_sourceType;
          localwn.Gop = 0;
          paramf.nIE.add(localwn);
          k = i + 1;
          ae.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localwn.Goj, localwn.Goo, Integer.valueOf(localwn.Gon), Integer.valueOf(localwn.Gom), localwn.Gok, localwn.Gol });
        }
        if (localajx.GAo) {
          break label647;
        }
        wn localwn = new wn();
        localwn.Gom = ((int)localajx.GAg);
        localwn.Gok = localajx.GAc;
        localwn.Gol = localajx.GAe;
        localwn.Goo = localajx.GAi;
        localwn.Gon = this.rBM.field_sourceType;
        localwn.Goj = (m + "t");
        localwn.Gop = 1;
        paramf.nIE.add(localwn);
        i = k + 1;
        ae.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localwn.Goj, localwn.Goo, Integer.valueOf(localwn.Gon), Integer.valueOf(localwn.Gom), localwn.Gok, localwn.Gol });
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
        ae.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m + 1) });
        paramf.nID = k;
        if (k == 0)
        {
          ae.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.rBL = -101;
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
    ae.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.rBL), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.rBL == -100))
      {
        ae.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ac(9, this.rBM.field_localId);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if ((paramInt2 != 3) || (this.rBL != -101)) {
        break label828;
      }
      i = 0;
    }
    if ((this.rBL != -101) && (paramInt2 == 0) && (i == 0))
    {
      paramq = ((wp)((com.tencent.mm.ak.b)paramq).hQE.hQJ).nIE;
      paramArrayOfByte = this.rBM.field_favProto.oeJ;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < paramq.size())
      {
        localObject1 = (ajw)paramq.get(paramInt1);
        localObject2 = ((ajw)localObject1).Goj;
        ajx localajx;
        if (!bu.isNullOrNil((String)localObject2))
        {
          ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((ajw)localObject1).nJb), localObject2 });
          if (((ajw)localObject1).nJb == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label849;
            }
            localajx = (ajx)paramArrayOfByte.get(bu.getInt((String)localObject2, 0));
            ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((ajw)localObject1).Gzr, ((ajw)localObject1).Ghg, ((ajw)localObject1).Goj, ((ajw)localObject1).Gok, Integer.valueOf(((ajw)localObject1).Gom), ((ajw)localObject1).Gol });
            localajx.aPH(((ajw)localObject1).Ghg);
            localajx.aPG(((ajw)localObject1).Gzr);
            if (!bu.isNullOrNil(((ajw)localObject1).FYD)) {
              localajx.aPV(((ajw)localObject1).FYD);
            }
            if (bu.isNullOrNil(localajx.GzR))
            {
              ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              localajx.aPN(((ajw)localObject1).Gok);
              localajx.De(((ajw)localObject1).Gom);
              localajx.aPO(((ajw)localObject1).Gol);
              b.a(localajx, this.rBM, 1, false);
            }
            if ((!bu.isNullOrNil(((ajw)localObject1).Gok)) && (!((ajw)localObject1).Gok.equals(localajx.GzR)))
            {
              ae.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((ajw)localObject1).Gok, localajx.GzR });
              localajx.aPN(((ajw)localObject1).Gok);
            }
            if ((!bu.isNullOrNil(((ajw)localObject1).Gol)) && (!((ajw)localObject1).Gol.equals(localajx.GzT)))
            {
              ae.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((ajw)localObject1).Gol, localajx.GzT });
              localajx.aPO(((ajw)localObject1).Gol);
            }
            if ((((ajw)localObject1).Gom > 0) && (((ajw)localObject1).Gom != localajx.GzV))
            {
              ae.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((ajw)localObject1).Gom), Long.valueOf(localajx.GzV) });
              localajx.De(((ajw)localObject1).Gom);
            }
          }
          label701:
          if (((String)localObject2).endsWith("t")) {
            break label1119;
          }
          localajx = (ajx)paramArrayOfByte.get(bu.getInt((String)localObject2, 0));
          this.rBP.put(localajx, Boolean.TRUE);
          label743:
          if ((((ajw)localObject1).nJb == 1) || (((ajw)localObject1).nJb == 2)) {
            break label1253;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1594;
          }
          localajx = (ajx)paramArrayOfByte.get(bu.getInt((String)localObject2, 0));
          if (!bu.isNullOrNil(localajx.GzR)) {
            break label1164;
          }
          ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { localajx.GzR });
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
          localajx = (ajx)paramArrayOfByte.get(bu.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((ajw)localObject1).Gzr, ((ajw)localObject1).Ghg, ((ajw)localObject1).Goj, ((ajw)localObject1).Gok, Integer.valueOf(((ajw)localObject1).Gom), ((ajw)localObject1).Gol });
          localajx.aPF(((ajw)localObject1).Ghg);
          localajx.aPE(((ajw)localObject1).Gzr);
          if (((ajw)localObject1).Gom <= 0) {
            break label701;
          }
          localajx.Df(((ajw)localObject1).Gom);
          if ((!bu.isNullOrNil(((ajw)localObject1).Gok)) && (!((ajw)localObject1).Gok.equals(localajx.GAc)))
          {
            ae.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((ajw)localObject1).Gok, localajx.GAc });
            localajx.aPS(((ajw)localObject1).Gok);
          }
          if ((bu.isNullOrNil(((ajw)localObject1).Gol)) || (((ajw)localObject1).Gol.equals(localajx.GAe))) {
            break label701;
          }
          ae.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((ajw)localObject1).Gol, localajx.GAe });
          localajx.aPT(((ajw)localObject1).Gol);
          break label701;
          label1119:
          localajx = (ajx)paramArrayOfByte.get(bu.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.rBP.put(localajx, Boolean.TRUE);
          break label743;
          label1164:
          this.rBN = false;
          String str;
          if (bu.isNullOrNil(localajx.GzC))
          {
            com.tencent.mm.an.f.aHa();
            str = a.aGP();
            localajx.aPH(str);
            ae.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
          }
          ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { localajx.GzR, localajx.GzC });
          b.a(localajx, this.rBM, 0, false);
          for (;;)
          {
            label1253:
            if (((ajw)localObject1).nJb != 2) {
              break label1746;
            }
            this.rBO = true;
            if (((String)localObject2).endsWith("t")) {
              break label1748;
            }
            ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((ajw)localObject1).Gzs), ((ajw)localObject1).Gzr, ((ajw)localObject1).Ghg });
            localObject2 = (ajx)paramArrayOfByte.get(bu.getInt((String)localObject2, 0));
            ((ajx)localObject2).aap(((ajw)localObject1).Gzs);
            ((ajx)localObject2).aPH(((ajw)localObject1).Ghg);
            ((ajx)localObject2).aPG(((ajw)localObject1).Gzr);
            if (!bu.isNullOrNil(((ajw)localObject1).FYD)) {
              ((ajx)localObject2).aPV(((ajw)localObject1).FYD);
            }
            if ((!bu.isNullOrNil(((ajw)localObject1).Gok)) && (!((ajw)localObject1).Gok.equals(((ajx)localObject2).GzR)))
            {
              ae.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((ajw)localObject1).Gok, ((ajx)localObject2).GzR });
              ((ajx)localObject2).aPN(((ajw)localObject1).Gok);
            }
            if ((!bu.isNullOrNil(((ajw)localObject1).Gol)) && (!((ajw)localObject1).Gol.equals(((ajx)localObject2).GzT)))
            {
              ae.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((ajw)localObject1).Gol, ((ajx)localObject2).GzT });
              ((ajx)localObject2).aPO(((ajw)localObject1).Gol);
            }
            if ((((ajw)localObject1).Gom <= 0) || (((ajw)localObject1).Gom == ((ajx)localObject2).GzV)) {
              break;
            }
            ae.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((ajw)localObject1).Gom), Long.valueOf(((ajx)localObject2).GzV) });
            ((ajx)localObject2).De(((ajw)localObject1).Gom);
            break;
            label1594:
            localajx = (ajx)paramArrayOfByte.get(bu.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (bu.isNullOrNil(localajx.GAc))
            {
              ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { localajx.GAc });
              break;
            }
            this.rBN = false;
            if (bu.isNullOrNil(localajx.GzC))
            {
              com.tencent.mm.an.f.aHa();
              str = a.aGP();
              localajx.aPH(str);
              ae.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
            }
            ae.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { localajx.GzR, localajx.GzC });
            b.a(localajx, this.rBM, 0);
          }
          label1746:
          continue;
          label1748:
          ae.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.rBP.keySet().iterator();
      paramInt1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ajx)((Iterator)localObject1).next();
        if (((Boolean)this.rBP.get(localObject2)).booleanValue()) {
          break label2311;
        }
        paramInt1 += 1;
      }
    }
    label2311:
    for (;;)
    {
      break;
      ae.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[] { Integer.valueOf(paramq.size()), Integer.valueOf(paramArrayOfByte.size()) });
      if (paramInt1 > 0)
      {
        ae.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
        paramInt1 = doScene(dispatcher(), this.callback);
        if ((paramInt1 != -100) && (paramInt1 != -101))
        {
          AppMethodBeat.o(103473);
          return;
        }
      }
      if (this.rBO)
      {
        ae.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
        this.rBM.field_itemStatus = 12;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rBM, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, i, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if (this.rBN)
      {
        ae.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
        if (this.rBM.field_id > 0)
        {
          this.rBM.field_itemStatus = 17;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rBM, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(103473);
          return;
          if (this.rBM.field_type == 18) {
            this.rBM.field_favProto.aaw(1);
          }
          this.rBM.field_itemStatus = 9;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rBM, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        }
      }
      if (this.rBM.field_id > 0) {}
      for (this.rBM.field_itemStatus = 15;; this.rBM.field_itemStatus = 4)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.rBM, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
        break;
        if (this.rBM.field_type == 18) {
          this.rBM.field_favProto.aaw(1);
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
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */