package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.ao.a;
import com.tencent.mm.ao.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.protocal.protobuf.ud;
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
  private com.tencent.mm.al.g callback;
  private int qaR;
  public g qaS;
  private boolean qaT;
  private boolean qaU;
  HashMap<afy, Boolean> qaV;
  private final com.tencent.mm.al.b rr;
  
  public aj(g paramg)
  {
    AppMethodBeat.i(103471);
    this.qaR = 0;
    this.callback = null;
    this.qaT = true;
    this.qaU = false;
    this.qaV = new HashMap();
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new uc();
    ((b.a)localObject).gUV = new ud();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((b.a)localObject).funcId = 404;
    ((b.a)localObject).reqCmdId = 197;
    ((b.a)localObject).respCmdId = 1000000197;
    this.rr = ((b.a)localObject).atI();
    this.qaS = paramg;
    paramg = paramg.field_favProto.mVb.iterator();
    while (paramg.hasNext())
    {
      localObject = (afy)paramg.next();
      this.qaV.put(localObject, Boolean.FALSE);
    }
    AppMethodBeat.o(103471);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(103472);
    this.callback = paramg;
    paramg = this.qaV.keySet().iterator();
    int j = 0;
    Object localObject;
    if (paramg.hasNext())
    {
      localObject = (afy)paramg.next();
      if (((Boolean)this.qaV.get(localObject)).booleanValue()) {
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
        this.qaR = -100;
        AppMethodBeat.o(103472);
        return -100;
      }
      paramg = (uc)this.rr.gUS.gUX;
      paramg.mAL.clear();
      localObject = this.qaS.field_favProto.mVb;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        afy localafy = (afy)((List)localObject).get(m);
        if (((Boolean)this.qaV.get(localafy)).booleanValue()) {
          break label653;
        }
        k = i;
        if (!localafy.DgL)
        {
          localub = new ub();
          localub.CVR = ((int)localafy.Dgu);
          localub.CVP = localafy.Dgq;
          localub.CVQ = localafy.Dgs;
          localub.CVO = String.valueOf(m);
          localub.CVT = localafy.DgH;
          localub.CVS = this.qaS.field_sourceType;
          localub.CVU = 0;
          paramg.mAL.add(localub);
          k = i + 1;
          ad.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localub.CVO, localub.CVT, Integer.valueOf(localub.CVS), Integer.valueOf(localub.CVR), localub.CVP, localub.CVQ });
        }
        if (localafy.DgN) {
          break label647;
        }
        ub localub = new ub();
        localub.CVR = ((int)localafy.DgF);
        localub.CVP = localafy.DgB;
        localub.CVQ = localafy.DgD;
        localub.CVT = localafy.DgH;
        localub.CVS = this.qaS.field_sourceType;
        localub.CVO = (m + "t");
        localub.CVU = 1;
        paramg.mAL.add(localub);
        i = k + 1;
        ad.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localub.CVO, localub.CVT, Integer.valueOf(localub.CVS), Integer.valueOf(localub.CVR), localub.CVP, localub.CVQ });
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
        paramg.mAK = k;
        if (k == 0)
        {
          ad.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.qaR = -101;
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
    ad.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.qaR), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.qaR == -100))
      {
        ad.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().ab(9, this.qaS.field_localId);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if ((paramInt2 != 3) || (this.qaR != -101)) {
        break label828;
      }
      i = 0;
    }
    if ((this.qaR != -101) && (paramInt2 == 0) && (i == 0))
    {
      paramq = ((ud)((com.tencent.mm.al.b)paramq).gUT.gUX).mAL;
      paramArrayOfByte = this.qaS.field_favProto.mVb;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < paramq.size())
      {
        localObject1 = (afx)paramq.get(paramInt1);
        localObject2 = ((afx)localObject1).CVO;
        afy localafy;
        if (!bt.isNullOrNil((String)localObject2))
        {
          ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((afx)localObject1).mBi), localObject2 });
          if (((afx)localObject1).mBi == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label849;
            }
            localafy = (afy)paramArrayOfByte.get(bt.getInt((String)localObject2, 0));
            ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((afx)localObject1).DfQ, ((afx)localObject1).COP, ((afx)localObject1).CVO, ((afx)localObject1).CVP, Integer.valueOf(((afx)localObject1).CVR), ((afx)localObject1).CVQ });
            localafy.aDq(((afx)localObject1).COP);
            localafy.aDp(((afx)localObject1).DfQ);
            if (!bt.isNullOrNil(((afx)localObject1).CHW)) {
              localafy.aDE(((afx)localObject1).CHW);
            }
            if (bt.isNullOrNil(localafy.Dgq))
            {
              ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              localafy.aDw(((afx)localObject1).CVP);
              localafy.vp(((afx)localObject1).CVR);
              localafy.aDx(((afx)localObject1).CVQ);
              b.a(localafy, this.qaS, 1, false);
            }
            if ((!bt.isNullOrNil(((afx)localObject1).CVP)) && (!((afx)localObject1).CVP.equals(localafy.Dgq)))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((afx)localObject1).CVP, localafy.Dgq });
              localafy.aDw(((afx)localObject1).CVP);
            }
            if ((!bt.isNullOrNil(((afx)localObject1).CVQ)) && (!((afx)localObject1).CVQ.equals(localafy.Dgs)))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((afx)localObject1).CVQ, localafy.Dgs });
              localafy.aDx(((afx)localObject1).CVQ);
            }
            if ((((afx)localObject1).CVR > 0) && (((afx)localObject1).CVR != localafy.Dgu))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((afx)localObject1).CVR), Long.valueOf(localafy.Dgu) });
              localafy.vp(((afx)localObject1).CVR);
            }
          }
          label701:
          if (((String)localObject2).endsWith("t")) {
            break label1119;
          }
          localafy = (afy)paramArrayOfByte.get(bt.getInt((String)localObject2, 0));
          this.qaV.put(localafy, Boolean.TRUE);
          label743:
          if ((((afx)localObject1).mBi == 1) || (((afx)localObject1).mBi == 2)) {
            break label1253;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1594;
          }
          localafy = (afy)paramArrayOfByte.get(bt.getInt((String)localObject2, 0));
          if (!bt.isNullOrNil(localafy.Dgq)) {
            break label1164;
          }
          ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { localafy.Dgq });
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
          localafy = (afy)paramArrayOfByte.get(bt.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((afx)localObject1).DfQ, ((afx)localObject1).COP, ((afx)localObject1).CVO, ((afx)localObject1).CVP, Integer.valueOf(((afx)localObject1).CVR), ((afx)localObject1).CVQ });
          localafy.aDo(((afx)localObject1).COP);
          localafy.aDn(((afx)localObject1).DfQ);
          if (((afx)localObject1).CVR <= 0) {
            break label701;
          }
          localafy.vq(((afx)localObject1).CVR);
          if ((!bt.isNullOrNil(((afx)localObject1).CVP)) && (!((afx)localObject1).CVP.equals(localafy.DgB)))
          {
            ad.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((afx)localObject1).CVP, localafy.DgB });
            localafy.aDB(((afx)localObject1).CVP);
          }
          if ((bt.isNullOrNil(((afx)localObject1).CVQ)) || (((afx)localObject1).CVQ.equals(localafy.DgD))) {
            break label701;
          }
          ad.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((afx)localObject1).CVQ, localafy.DgD });
          localafy.aDC(((afx)localObject1).CVQ);
          break label701;
          label1119:
          localafy = (afy)paramArrayOfByte.get(bt.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.qaV.put(localafy, Boolean.TRUE);
          break label743;
          label1164:
          this.qaT = false;
          String str;
          if (bt.isNullOrNil(localafy.Dgb))
          {
            f.awM();
            str = a.awE();
            localafy.aDq(str);
            ad.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
          }
          ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { localafy.Dgq, localafy.Dgb });
          b.a(localafy, this.qaS, 0, false);
          for (;;)
          {
            label1253:
            if (((afx)localObject1).mBi != 2) {
              break label1746;
            }
            this.qaU = true;
            if (((String)localObject2).endsWith("t")) {
              break label1748;
            }
            ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((afx)localObject1).DfR), ((afx)localObject1).DfQ, ((afx)localObject1).COP });
            localObject2 = (afy)paramArrayOfByte.get(bt.getInt((String)localObject2, 0));
            ((afy)localObject2).VE(((afx)localObject1).DfR);
            ((afy)localObject2).aDq(((afx)localObject1).COP);
            ((afy)localObject2).aDp(((afx)localObject1).DfQ);
            if (!bt.isNullOrNil(((afx)localObject1).CHW)) {
              ((afy)localObject2).aDE(((afx)localObject1).CHW);
            }
            if ((!bt.isNullOrNil(((afx)localObject1).CVP)) && (!((afx)localObject1).CVP.equals(((afy)localObject2).Dgq)))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((afx)localObject1).CVP, ((afy)localObject2).Dgq });
              ((afy)localObject2).aDw(((afx)localObject1).CVP);
            }
            if ((!bt.isNullOrNil(((afx)localObject1).CVQ)) && (!((afx)localObject1).CVQ.equals(((afy)localObject2).Dgs)))
            {
              ad.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((afx)localObject1).CVQ, ((afy)localObject2).Dgs });
              ((afy)localObject2).aDx(((afx)localObject1).CVQ);
            }
            if ((((afx)localObject1).CVR <= 0) || (((afx)localObject1).CVR == ((afy)localObject2).Dgu)) {
              break;
            }
            ad.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((afx)localObject1).CVR), Long.valueOf(((afy)localObject2).Dgu) });
            ((afy)localObject2).vp(((afx)localObject1).CVR);
            break;
            label1594:
            localafy = (afy)paramArrayOfByte.get(bt.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (bt.isNullOrNil(localafy.DgB))
            {
              ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { localafy.DgB });
              break;
            }
            this.qaT = false;
            if (bt.isNullOrNil(localafy.Dgb))
            {
              f.awM();
              str = a.awE();
              localafy.aDq(str);
              ad.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
            }
            ad.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { localafy.Dgq, localafy.Dgb });
            b.a(localafy, this.qaS, 0);
          }
          label1746:
          continue;
          label1748:
          ad.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.qaV.keySet().iterator();
      paramInt1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (afy)((Iterator)localObject1).next();
        if (((Boolean)this.qaV.get(localObject2)).booleanValue()) {
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
      if (this.qaU)
      {
        ad.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
        this.qaS.field_itemStatus = 12;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qaS, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, i, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if (this.qaT)
      {
        ad.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
        if (this.qaS.field_id > 0)
        {
          this.qaS.field_itemStatus = 17;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qaS, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(103473);
          return;
          if (this.qaS.field_type == 18) {
            this.qaS.field_favProto.VL(1);
          }
          this.qaS.field_itemStatus = 9;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qaS, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        }
      }
      if (this.qaS.field_id > 0) {}
      for (this.qaS.field_itemStatus = 15;; this.qaS.field_itemStatus = 4)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qaS, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
        break;
        if (this.qaS.field_type == 18) {
          this.qaS.field_favProto.VL(1);
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */