package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.an.a;
import com.tencent.mm.an.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class aj
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private boolean qJA;
  HashMap<agx, Boolean> qJB;
  private int qJx;
  public g qJy;
  private boolean qJz;
  private final com.tencent.mm.ak.b rr;
  
  public aj(g paramg)
  {
    AppMethodBeat.i(103471);
    this.qJx = 0;
    this.callback = null;
    this.qJz = true;
    this.qJA = false;
    this.qJB = new HashMap();
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new um();
    ((b.a)localObject).hvu = new un();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((b.a)localObject).funcId = 404;
    ((b.a)localObject).reqCmdId = 197;
    ((b.a)localObject).respCmdId = 1000000197;
    this.rr = ((b.a)localObject).aAz();
    this.qJy = paramg;
    paramg = paramg.field_favProto.nxC.iterator();
    while (paramg.hasNext())
    {
      localObject = (agx)paramg.next();
      this.qJB.put(localObject, Boolean.FALSE);
    }
    AppMethodBeat.o(103471);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(103472);
    this.callback = paramg;
    paramg = this.qJB.keySet().iterator();
    int j = 0;
    Object localObject;
    if (paramg.hasNext())
    {
      localObject = (agx)paramg.next();
      if (((Boolean)this.qJB.get(localObject)).booleanValue()) {
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
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
        this.qJx = -100;
        AppMethodBeat.o(103472);
        return -100;
      }
      paramg = (um)this.rr.hvr.hvw;
      paramg.ncM.clear();
      localObject = this.qJy.field_favProto.nxC;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        agx localagx = (agx)((List)localObject).get(m);
        if (((Boolean)this.qJB.get(localagx)).booleanValue()) {
          break label653;
        }
        k = i;
        if (!localagx.EzR)
        {
          localul = new ul();
          localul.EoB = ((int)localagx.EzA);
          localul.Eoz = localagx.Ezw;
          localul.EoA = localagx.Ezy;
          localul.Eoy = String.valueOf(m);
          localul.EoD = localagx.EzN;
          localul.EoC = this.qJy.field_sourceType;
          localul.EoE = 0;
          paramg.ncM.add(localul);
          k = i + 1;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localul.Eoy, localul.EoD, Integer.valueOf(localul.EoC), Integer.valueOf(localul.EoB), localul.Eoz, localul.EoA });
        }
        if (localagx.EzT) {
          break label647;
        }
        ul localul = new ul();
        localul.EoB = ((int)localagx.EzL);
        localul.Eoz = localagx.EzH;
        localul.EoA = localagx.EzJ;
        localul.EoD = localagx.EzN;
        localul.EoC = this.qJy.field_sourceType;
        localul.Eoy = (m + "t");
        localul.EoE = 1;
        paramg.ncM.add(localul);
        i = k + 1;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localul.Eoy, localul.EoD, Integer.valueOf(localul.EoC), Integer.valueOf(localul.EoB), localul.Eoz, localul.EoA });
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m + 1) });
        paramg.ncL = k;
        if (k == 0)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.qJx = -101;
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.qJx), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.qJx == -100))
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().aa(9, this.qJy.field_localId);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if ((paramInt2 != 3) || (this.qJx != -101)) {
        break label828;
      }
      i = 0;
    }
    if ((this.qJx != -101) && (paramInt2 == 0) && (i == 0))
    {
      paramq = ((un)((com.tencent.mm.ak.b)paramq).hvs.hvw).ncM;
      paramArrayOfByte = this.qJy.field_favProto.nxC;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < paramq.size())
      {
        localObject1 = (agw)paramq.get(paramInt1);
        localObject2 = ((agw)localObject1).Eoy;
        agx localagx;
        if (!bs.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((agw)localObject1).ndj), localObject2 });
          if (((agw)localObject1).ndj == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label849;
            }
            localagx = (agx)paramArrayOfByte.get(bs.getInt((String)localObject2, 0));
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((agw)localObject1).EyW, ((agw)localObject1).EhA, ((agw)localObject1).Eoy, ((agw)localObject1).Eoz, Integer.valueOf(((agw)localObject1).EoB), ((agw)localObject1).EoA });
            localagx.aIH(((agw)localObject1).EhA);
            localagx.aIG(((agw)localObject1).EyW);
            if (!bs.isNullOrNil(((agw)localObject1).Eay)) {
              localagx.aIV(((agw)localObject1).Eay);
            }
            if (bs.isNullOrNil(localagx.Ezw))
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              localagx.aIN(((agw)localObject1).Eoz);
              localagx.zS(((agw)localObject1).EoB);
              localagx.aIO(((agw)localObject1).EoA);
              b.a(localagx, this.qJy, 1, false);
            }
            if ((!bs.isNullOrNil(((agw)localObject1).Eoz)) && (!((agw)localObject1).Eoz.equals(localagx.Ezw)))
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((agw)localObject1).Eoz, localagx.Ezw });
              localagx.aIN(((agw)localObject1).Eoz);
            }
            if ((!bs.isNullOrNil(((agw)localObject1).EoA)) && (!((agw)localObject1).EoA.equals(localagx.Ezy)))
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((agw)localObject1).EoA, localagx.Ezy });
              localagx.aIO(((agw)localObject1).EoA);
            }
            if ((((agw)localObject1).EoB > 0) && (((agw)localObject1).EoB != localagx.EzA))
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((agw)localObject1).EoB), Long.valueOf(localagx.EzA) });
              localagx.zS(((agw)localObject1).EoB);
            }
          }
          label701:
          if (((String)localObject2).endsWith("t")) {
            break label1119;
          }
          localagx = (agx)paramArrayOfByte.get(bs.getInt((String)localObject2, 0));
          this.qJB.put(localagx, Boolean.TRUE);
          label743:
          if ((((agw)localObject1).ndj == 1) || (((agw)localObject1).ndj == 2)) {
            break label1253;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1594;
          }
          localagx = (agx)paramArrayOfByte.get(bs.getInt((String)localObject2, 0));
          if (!bs.isNullOrNil(localagx.Ezw)) {
            break label1164;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { localagx.Ezw });
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
          localagx = (agx)paramArrayOfByte.get(bs.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((agw)localObject1).EyW, ((agw)localObject1).EhA, ((agw)localObject1).Eoy, ((agw)localObject1).Eoz, Integer.valueOf(((agw)localObject1).EoB), ((agw)localObject1).EoA });
          localagx.aIF(((agw)localObject1).EhA);
          localagx.aIE(((agw)localObject1).EyW);
          if (((agw)localObject1).EoB <= 0) {
            break label701;
          }
          localagx.zT(((agw)localObject1).EoB);
          if ((!bs.isNullOrNil(((agw)localObject1).Eoz)) && (!((agw)localObject1).Eoz.equals(localagx.EzH)))
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((agw)localObject1).Eoz, localagx.EzH });
            localagx.aIS(((agw)localObject1).Eoz);
          }
          if ((bs.isNullOrNil(((agw)localObject1).EoA)) || (((agw)localObject1).EoA.equals(localagx.EzJ))) {
            break label701;
          }
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((agw)localObject1).EoA, localagx.EzJ });
          localagx.aIT(((agw)localObject1).EoA);
          break label701;
          label1119:
          localagx = (agx)paramArrayOfByte.get(bs.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.qJB.put(localagx, Boolean.TRUE);
          break label743;
          label1164:
          this.qJz = false;
          String str;
          if (bs.isNullOrNil(localagx.Ezh))
          {
            f.aDE();
            str = a.aDw();
            localagx.aIH(str);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { localagx.Ezw, localagx.Ezh });
          b.a(localagx, this.qJy, 0, false);
          for (;;)
          {
            label1253:
            if (((agw)localObject1).ndj != 2) {
              break label1746;
            }
            this.qJA = true;
            if (((String)localObject2).endsWith("t")) {
              break label1748;
            }
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((agw)localObject1).EyX), ((agw)localObject1).EyW, ((agw)localObject1).EhA });
            localObject2 = (agx)paramArrayOfByte.get(bs.getInt((String)localObject2, 0));
            ((agx)localObject2).XN(((agw)localObject1).EyX);
            ((agx)localObject2).aIH(((agw)localObject1).EhA);
            ((agx)localObject2).aIG(((agw)localObject1).EyW);
            if (!bs.isNullOrNil(((agw)localObject1).Eay)) {
              ((agx)localObject2).aIV(((agw)localObject1).Eay);
            }
            if ((!bs.isNullOrNil(((agw)localObject1).Eoz)) && (!((agw)localObject1).Eoz.equals(((agx)localObject2).Ezw)))
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((agw)localObject1).Eoz, ((agx)localObject2).Ezw });
              ((agx)localObject2).aIN(((agw)localObject1).Eoz);
            }
            if ((!bs.isNullOrNil(((agw)localObject1).EoA)) && (!((agw)localObject1).EoA.equals(((agx)localObject2).Ezy)))
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((agw)localObject1).EoA, ((agx)localObject2).Ezy });
              ((agx)localObject2).aIO(((agw)localObject1).EoA);
            }
            if ((((agw)localObject1).EoB <= 0) || (((agw)localObject1).EoB == ((agx)localObject2).EzA)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((agw)localObject1).EoB), Long.valueOf(((agx)localObject2).EzA) });
            ((agx)localObject2).zS(((agw)localObject1).EoB);
            break;
            label1594:
            localagx = (agx)paramArrayOfByte.get(bs.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (bs.isNullOrNil(localagx.EzH))
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { localagx.EzH });
              break;
            }
            this.qJz = false;
            if (bs.isNullOrNil(localagx.Ezh))
            {
              f.aDE();
              str = a.aDw();
              localagx.aIH(str);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
            }
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { localagx.Ezw, localagx.Ezh });
            b.a(localagx, this.qJy, 0);
          }
          label1746:
          continue;
          label1748:
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.qJB.keySet().iterator();
      paramInt1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (agx)((Iterator)localObject1).next();
        if (((Boolean)this.qJB.get(localObject2)).booleanValue()) {
          break label2311;
        }
        paramInt1 += 1;
      }
    }
    label2311:
    for (;;)
    {
      break;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[] { Integer.valueOf(paramq.size()), Integer.valueOf(paramArrayOfByte.size()) });
      if (paramInt1 > 0)
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
        paramInt1 = doScene(dispatcher(), this.callback);
        if ((paramInt1 != -100) && (paramInt1 != -101))
        {
          AppMethodBeat.o(103473);
          return;
        }
      }
      if (this.qJA)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
        this.qJy.field_itemStatus = 12;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qJy, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, i, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if (this.qJz)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
        if (this.qJy.field_id > 0)
        {
          this.qJy.field_itemStatus = 17;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qJy, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(103473);
          return;
          if (this.qJy.field_type == 18) {
            this.qJy.field_favProto.XU(1);
          }
          this.qJy.field_itemStatus = 9;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qJy, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
        }
      }
      if (this.qJy.field_id > 0) {}
      for (this.qJy.field_itemStatus = 15;; this.qJy.field_itemStatus = 4)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(this.qJy, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
        break;
        if (this.qJy.field_type == 18) {
          this.qJy.field_favProto.XU(1);
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
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */