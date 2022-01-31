package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.al.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class ai
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private int muj;
  public g muk;
  private boolean mul;
  private boolean mum;
  HashMap<aca, Boolean> mun;
  private final com.tencent.mm.ai.b rr;
  
  public ai(g paramg)
  {
    AppMethodBeat.i(102731);
    this.muj = 0;
    this.callback = null;
    this.mul = true;
    this.mum = false;
    this.mun = new HashMap();
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new rn();
    ((b.a)localObject).fsY = new ro();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((b.a)localObject).funcId = 404;
    ((b.a)localObject).reqCmdId = 197;
    ((b.a)localObject).respCmdId = 1000000197;
    this.rr = ((b.a)localObject).ado();
    this.muk = paramg;
    paramg = paramg.field_favProto.wVc.iterator();
    while (paramg.hasNext())
    {
      localObject = (aca)paramg.next();
      this.mun.put(localObject, Boolean.FALSE);
    }
    AppMethodBeat.o(102731);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(102732);
    this.callback = paramf;
    paramf = this.mun.keySet().iterator();
    int j = 0;
    Object localObject;
    if (paramf.hasNext())
    {
      localObject = (aca)paramf.next();
      if (((Boolean)this.mun.get(localObject)).booleanValue()) {
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
        ab.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
        this.muj = -100;
        AppMethodBeat.o(102732);
        return -100;
      }
      paramf = (rn)this.rr.fsV.fta;
      paramf.jJv.clear();
      localObject = this.muk.field_favProto.wVc;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        aca localaca = (aca)((List)localObject).get(m);
        if (((Boolean)this.mun.get(localaca)).booleanValue()) {
          break label653;
        }
        k = i;
        if (!localaca.wTo)
        {
          localrm = new rm();
          localrm.wJI = ((int)localaca.wSX);
          localrm.wJG = localaca.wST;
          localrm.wJH = localaca.wSV;
          localrm.wJF = String.valueOf(m);
          localrm.wJK = localaca.wTk;
          localrm.wJJ = this.muk.field_sourceType;
          localrm.wJL = 0;
          paramf.jJv.add(localrm);
          k = i + 1;
          ab.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localrm.wJF, localrm.wJK, Integer.valueOf(localrm.wJJ), Integer.valueOf(localrm.wJI), localrm.wJG, localrm.wJH });
        }
        if (localaca.wTq) {
          break label647;
        }
        rm localrm = new rm();
        localrm.wJI = ((int)localaca.wTi);
        localrm.wJG = localaca.wTe;
        localrm.wJH = localaca.wTg;
        localrm.wJK = localaca.wTk;
        localrm.wJJ = this.muk.field_sourceType;
        localrm.wJF = (m + "t");
        localrm.wJL = 1;
        paramf.jJv.add(localrm);
        i = k + 1;
        ab.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localrm.wJF, localrm.wJK, Integer.valueOf(localrm.wJJ), Integer.valueOf(localrm.wJI), localrm.wJG, localrm.wJH });
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
        ab.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m + 1) });
        paramf.jJu = k;
        if (k == 0)
        {
          ab.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.muj = -101;
          AppMethodBeat.o(102732);
          return -101;
        }
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(102732);
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
    AppMethodBeat.i(102733);
    ab.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.muj), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.muj == -100))
      {
        ab.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(9, this.muk.field_localId);
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(102733);
        return;
      }
      if ((paramInt2 != 3) || (this.muj != -101)) {
        break label828;
      }
      i = 0;
    }
    if ((this.muj != -101) && (paramInt2 == 0) && (i == 0))
    {
      paramq = ((ro)((com.tencent.mm.ai.b)paramq).fsW.fta).jJv;
      paramArrayOfByte = this.muk.field_favProto.wVc;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < paramq.size())
      {
        localObject1 = (abz)paramq.get(paramInt1);
        localObject2 = ((abz)localObject1).wJF;
        aca localaca;
        if (!bo.isNullOrNil((String)localObject2))
        {
          ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((abz)localObject1).jJS), localObject2 });
          if (((abz)localObject1).jJS == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label849;
            }
            localaca = (aca)paramArrayOfByte.get(bo.getInt((String)localObject2, 0));
            ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((abz)localObject1).wSt, ((abz)localObject1).wDo, ((abz)localObject1).wJF, ((abz)localObject1).wJG, Integer.valueOf(((abz)localObject1).wJI), ((abz)localObject1).wJH });
            localaca.anv(((abz)localObject1).wDo);
            localaca.anu(((abz)localObject1).wSt);
            if (!bo.isNullOrNil(((abz)localObject1).wxt)) {
              localaca.anJ(((abz)localObject1).wxt);
            }
            if (bo.isNullOrNil(localaca.wST))
            {
              ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              localaca.anB(((abz)localObject1).wJG);
              localaca.nC(((abz)localObject1).wJI);
              localaca.anC(((abz)localObject1).wJH);
              b.a(localaca, this.muk, 1, false);
            }
            if ((!bo.isNullOrNil(((abz)localObject1).wJG)) && (!((abz)localObject1).wJG.equals(localaca.wST)))
            {
              ab.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((abz)localObject1).wJG, localaca.wST });
              localaca.anB(((abz)localObject1).wJG);
            }
            if ((!bo.isNullOrNil(((abz)localObject1).wJH)) && (!((abz)localObject1).wJH.equals(localaca.wSV)))
            {
              ab.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((abz)localObject1).wJH, localaca.wSV });
              localaca.anC(((abz)localObject1).wJH);
            }
            if ((((abz)localObject1).wJI > 0) && (((abz)localObject1).wJI != localaca.wSX))
            {
              ab.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((abz)localObject1).wJI), Long.valueOf(localaca.wSX) });
              localaca.nC(((abz)localObject1).wJI);
            }
          }
          label701:
          if (((String)localObject2).endsWith("t")) {
            break label1119;
          }
          localaca = (aca)paramArrayOfByte.get(bo.getInt((String)localObject2, 0));
          this.mun.put(localaca, Boolean.TRUE);
          label743:
          if ((((abz)localObject1).jJS == 1) || (((abz)localObject1).jJS == 2)) {
            break label1253;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1594;
          }
          localaca = (aca)paramArrayOfByte.get(bo.getInt((String)localObject2, 0));
          if (!bo.isNullOrNil(localaca.wST)) {
            break label1164;
          }
          ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { localaca.wST });
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label828:
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(102733);
          return;
          label849:
          localaca = (aca)paramArrayOfByte.get(bo.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((abz)localObject1).wSt, ((abz)localObject1).wDo, ((abz)localObject1).wJF, ((abz)localObject1).wJG, Integer.valueOf(((abz)localObject1).wJI), ((abz)localObject1).wJH });
          localaca.ant(((abz)localObject1).wDo);
          localaca.ans(((abz)localObject1).wSt);
          if (((abz)localObject1).wJI <= 0) {
            break label701;
          }
          localaca.nD(((abz)localObject1).wJI);
          if ((!bo.isNullOrNil(((abz)localObject1).wJG)) && (!((abz)localObject1).wJG.equals(localaca.wTe)))
          {
            ab.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((abz)localObject1).wJG, localaca.wTe });
            localaca.anG(((abz)localObject1).wJG);
          }
          if ((bo.isNullOrNil(((abz)localObject1).wJH)) || (((abz)localObject1).wJH.equals(localaca.wTg))) {
            break label701;
          }
          ab.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((abz)localObject1).wJH, localaca.wTg });
          localaca.anH(((abz)localObject1).wJH);
          break label701;
          label1119:
          localaca = (aca)paramArrayOfByte.get(bo.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.mun.put(localaca, Boolean.TRUE);
          break label743;
          label1164:
          this.mul = false;
          String str;
          if (bo.isNullOrNil(localaca.wSE))
          {
            com.tencent.mm.al.f.afP();
            str = a.afG();
            localaca.anv(str);
            ab.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
          }
          ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { localaca.wST, localaca.wSE });
          b.a(localaca, this.muk, 0, false);
          for (;;)
          {
            label1253:
            if (((abz)localObject1).jJS != 2) {
              break label1746;
            }
            this.mum = true;
            if (((String)localObject2).endsWith("t")) {
              break label1748;
            }
            ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((abz)localObject1).wSu), ((abz)localObject1).wSt, ((abz)localObject1).wDo });
            localObject2 = (aca)paramArrayOfByte.get(bo.getInt((String)localObject2, 0));
            ((aca)localObject2).MJ(((abz)localObject1).wSu);
            ((aca)localObject2).anv(((abz)localObject1).wDo);
            ((aca)localObject2).anu(((abz)localObject1).wSt);
            if (!bo.isNullOrNil(((abz)localObject1).wxt)) {
              ((aca)localObject2).anJ(((abz)localObject1).wxt);
            }
            if ((!bo.isNullOrNil(((abz)localObject1).wJG)) && (!((abz)localObject1).wJG.equals(((aca)localObject2).wST)))
            {
              ab.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((abz)localObject1).wJG, ((aca)localObject2).wST });
              ((aca)localObject2).anB(((abz)localObject1).wJG);
            }
            if ((!bo.isNullOrNil(((abz)localObject1).wJH)) && (!((abz)localObject1).wJH.equals(((aca)localObject2).wSV)))
            {
              ab.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((abz)localObject1).wJH, ((aca)localObject2).wSV });
              ((aca)localObject2).anC(((abz)localObject1).wJH);
            }
            if ((((abz)localObject1).wJI <= 0) || (((abz)localObject1).wJI == ((aca)localObject2).wSX)) {
              break;
            }
            ab.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((abz)localObject1).wJI), Long.valueOf(((aca)localObject2).wSX) });
            ((aca)localObject2).nC(((abz)localObject1).wJI);
            break;
            label1594:
            localaca = (aca)paramArrayOfByte.get(bo.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (bo.isNullOrNil(localaca.wTe))
            {
              ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { localaca.wTe });
              break;
            }
            this.mul = false;
            if (bo.isNullOrNil(localaca.wSE))
            {
              com.tencent.mm.al.f.afP();
              str = a.afG();
              localaca.anv(str);
              ab.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
            }
            ab.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { localaca.wST, localaca.wSE });
            b.a(localaca, this.muk, 0);
          }
          label1746:
          continue;
          label1748:
          ab.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.mun.keySet().iterator();
      paramInt1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aca)((Iterator)localObject1).next();
        if (((Boolean)this.mun.get(localObject2)).booleanValue()) {
          break label2311;
        }
        paramInt1 += 1;
      }
    }
    label2311:
    for (;;)
    {
      break;
      ab.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[] { Integer.valueOf(paramq.size()), Integer.valueOf(paramArrayOfByte.size()) });
      if (paramInt1 > 0)
      {
        ab.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
        paramInt1 = doScene(dispatcher(), this.callback);
        if ((paramInt1 != -100) && (paramInt1 != -101))
        {
          AppMethodBeat.o(102733);
          return;
        }
      }
      if (this.mum)
      {
        ab.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
        this.muk.field_itemStatus = 12;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(this.muk, new String[] { "localId" });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, i, paramString, this);
        AppMethodBeat.o(102733);
        return;
      }
      if (this.mul)
      {
        ab.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
        if (this.muk.field_id > 0)
        {
          this.muk.field_itemStatus = 17;
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(this.muk, new String[] { "localId" });
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getModService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(102733);
          return;
          if (this.muk.field_type == 18) {
            this.muk.field_favProto.MQ(1);
          }
          this.muk.field_itemStatus = 9;
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(this.muk, new String[] { "localId" });
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getSendService().run();
        }
      }
      if (this.muk.field_id > 0) {}
      for (this.muk.field_itemStatus = 15;; this.muk.field_itemStatus = 4)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(this.muk, new String[] { "localId" });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
        break;
        if (this.muk.field_type == 18) {
          this.muk.field_favProto.MQ(1);
        }
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */