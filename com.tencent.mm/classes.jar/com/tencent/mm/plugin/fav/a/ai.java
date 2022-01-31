package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ak.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ok;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class ai
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL = null;
  private int jZM = 0;
  public g jZN;
  private boolean jZO = true;
  private boolean jZP = false;
  HashMap<xv, Boolean> jZQ = new HashMap();
  
  public ai(g paramg)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ol();
    ((b.a)localObject).ecI = new om();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((b.a)localObject).ecG = 404;
    ((b.a)localObject).ecJ = 197;
    ((b.a)localObject).ecK = 1000000197;
    this.dmK = ((b.a)localObject).Kt();
    this.jZN = paramg;
    paramg = paramg.field_favProto.sXc.iterator();
    while (paramg.hasNext())
    {
      localObject = (xv)paramg.next();
      this.jZQ.put(localObject, Boolean.valueOf(false));
    }
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    paramf = this.jZQ.keySet().iterator();
    int j = 0;
    Object localObject;
    if (paramf.hasNext())
    {
      localObject = (xv)paramf.next();
      if (((Boolean)this.jZQ.get(localObject)).booleanValue()) {
        break label634;
      }
    }
    label527:
    label548:
    label625:
    label631:
    label634:
    for (int i = j + 1;; i = j)
    {
      j = i;
      break;
      if (j == 0)
      {
        y.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
        this.jZM = -100;
        return -100;
      }
      paramf = (ol)this.dmK.ecE.ecN;
      paramf.hPT.clear();
      localObject = this.jZN.field_favProto.sXc;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        xv localxv = (xv)((List)localObject).get(m);
        if (((Boolean)this.jZQ.get(localxv)).booleanValue()) {
          break label631;
        }
        k = i;
        if (!localxv.sVs)
        {
          localok = new ok();
          localok.sLV = ((int)localxv.sVb);
          localok.sLT = localxv.sUX;
          localok.sLU = localxv.sUZ;
          localok.sLS = String.valueOf(m);
          localok.sLX = localxv.sVo;
          localok.sLW = this.jZN.field_sourceType;
          localok.sLY = 0;
          paramf.hPT.add(localok);
          k = i + 1;
          y.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localok.sLS, localok.sLX, Integer.valueOf(localok.sLW), Integer.valueOf(localok.sLV), localok.sLT, localok.sLU });
        }
        if (localxv.sVu) {
          break label625;
        }
        ok localok = new ok();
        localok.sLV = ((int)localxv.sVm);
        localok.sLT = localxv.sVi;
        localok.sLU = localxv.sVk;
        localok.sLX = localxv.sVo;
        localok.sLW = this.jZN.field_sourceType;
        localok.sLS = (m + "t");
        localok.sLY = 1;
        paramf.hPT.add(localok);
        i = k + 1;
        y.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localok.sLS, localok.sLX, Integer.valueOf(localok.sLW), Integer.valueOf(localok.sLV), localok.sLT, localok.sLU });
        k = i;
        if (i >= 19) {
          break label548;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        k = i;
        y.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m + 1) });
        paramf.hPS = k;
        if (k == 0)
        {
          y.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.jZM = -101;
          return -101;
        }
        return a(parame, this.dmK, this);
        i = k;
        break label527;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.jZM), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.jZM == -100))
      {
        y.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(9, this.jZN.field_localId);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if ((paramInt2 != 3) || (this.jZM != -101)) {
        break label817;
      }
      i = 0;
    }
    if ((this.jZM != -101) && (paramInt2 == 0) && (i == 0))
    {
      paramq = ((om)((com.tencent.mm.ah.b)paramq).ecF.ecN).hPT;
      paramArrayOfByte = this.jZN.field_favProto.sXc;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < paramq.size())
      {
        localObject1 = (xu)paramq.get(paramInt1);
        localObject2 = ((xu)localObject1).sLS;
        xv localxv;
        if (!bk.bl((String)localObject2))
        {
          y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((xu)localObject1).hQq), localObject2 });
          if (((xu)localObject1).hQq == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label832;
            }
            localxv = (xv)paramArrayOfByte.get(bk.getInt((String)localObject2, 0));
            y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((xu)localObject1).sUw, ((xu)localObject1).sGQ, ((xu)localObject1).sLS, ((xu)localObject1).sLT, Integer.valueOf(((xu)localObject1).sLV), ((xu)localObject1).sLU });
            localxv.Xz(((xu)localObject1).sGQ);
            localxv.Xy(((xu)localObject1).sUw);
            if (!bk.bl(((xu)localObject1).sUx)) {
              localxv.XN(((xu)localObject1).sUx);
            }
            if (bk.bl(localxv.sUX))
            {
              y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              localxv.XF(((xu)localObject1).sLT);
              localxv.hf(((xu)localObject1).sLV);
              localxv.XG(((xu)localObject1).sLU);
              b.a(localxv, this.jZN, 1, false);
            }
            if ((!bk.bl(((xu)localObject1).sLT)) && (!((xu)localObject1).sLT.equals(localxv.sUX)))
            {
              y.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((xu)localObject1).sLT, localxv.sUX });
              localxv.XF(((xu)localObject1).sLT);
            }
            if ((!bk.bl(((xu)localObject1).sLU)) && (!((xu)localObject1).sLU.equals(localxv.sUZ)))
            {
              y.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((xu)localObject1).sLU, localxv.sUZ });
              localxv.XG(((xu)localObject1).sLU);
            }
            if ((((xu)localObject1).sLV > 0) && (((xu)localObject1).sLV != localxv.sVb))
            {
              y.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((xu)localObject1).sLV), Long.valueOf(localxv.sVb) });
              localxv.hf(((xu)localObject1).sLV);
            }
          }
          label689:
          if (((String)localObject2).endsWith("t")) {
            break label1102;
          }
          localxv = (xv)paramArrayOfByte.get(bk.getInt((String)localObject2, 0));
          this.jZQ.put(localxv, Boolean.valueOf(true));
          label732:
          if ((((xu)localObject1).hQq == 1) || (((xu)localObject1).hQq == 2)) {
            break label1237;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1578;
          }
          localxv = (xv)paramArrayOfByte.get(bk.getInt((String)localObject2, 0));
          if (!bk.bl(localxv.sUX)) {
            break label1148;
          }
          y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { localxv.sUX });
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label817:
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
          return;
          label832:
          localxv = (xv)paramArrayOfByte.get(bk.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((xu)localObject1).sUw, ((xu)localObject1).sGQ, ((xu)localObject1).sLS, ((xu)localObject1).sLT, Integer.valueOf(((xu)localObject1).sLV), ((xu)localObject1).sLU });
          localxv.Xx(((xu)localObject1).sGQ);
          localxv.Xw(((xu)localObject1).sUw);
          if (((xu)localObject1).sLV <= 0) {
            break label689;
          }
          localxv.hg(((xu)localObject1).sLV);
          if ((!bk.bl(((xu)localObject1).sLT)) && (!((xu)localObject1).sLT.equals(localxv.sVi)))
          {
            y.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((xu)localObject1).sLT, localxv.sVi });
            localxv.XK(((xu)localObject1).sLT);
          }
          if ((bk.bl(((xu)localObject1).sLU)) || (((xu)localObject1).sLU.equals(localxv.sVk))) {
            break label689;
          }
          y.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((xu)localObject1).sLU, localxv.sVk });
          localxv.XL(((xu)localObject1).sLU);
          break label689;
          label1102:
          localxv = (xv)paramArrayOfByte.get(bk.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.jZQ.put(localxv, Boolean.valueOf(true));
          break label732;
          label1148:
          this.jZO = false;
          String str;
          if (bk.bl(localxv.sUI))
          {
            com.tencent.mm.ak.f.Ne();
            str = a.MW();
            localxv.Xz(str);
            y.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
          }
          y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { localxv.sUX, localxv.sUI });
          b.a(localxv, this.jZN, 0, false);
          for (;;)
          {
            label1237:
            if (((xu)localObject1).hQq != 2) {
              break label1730;
            }
            this.jZP = true;
            if (((String)localObject2).endsWith("t")) {
              break label1732;
            }
            y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((xu)localObject1).sUy), ((xu)localObject1).sUw, ((xu)localObject1).sGQ });
            localObject2 = (xv)paramArrayOfByte.get(bk.getInt((String)localObject2, 0));
            ((xv)localObject2).EI(((xu)localObject1).sUy);
            ((xv)localObject2).Xz(((xu)localObject1).sGQ);
            ((xv)localObject2).Xy(((xu)localObject1).sUw);
            if (!bk.bl(((xu)localObject1).sUx)) {
              ((xv)localObject2).XN(((xu)localObject1).sUx);
            }
            if ((!bk.bl(((xu)localObject1).sLT)) && (!((xu)localObject1).sLT.equals(((xv)localObject2).sUX)))
            {
              y.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((xu)localObject1).sLT, ((xv)localObject2).sUX });
              ((xv)localObject2).XF(((xu)localObject1).sLT);
            }
            if ((!bk.bl(((xu)localObject1).sLU)) && (!((xu)localObject1).sLU.equals(((xv)localObject2).sUZ)))
            {
              y.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((xu)localObject1).sLU, ((xv)localObject2).sUZ });
              ((xv)localObject2).XG(((xu)localObject1).sLU);
            }
            if ((((xu)localObject1).sLV <= 0) || (((xu)localObject1).sLV == ((xv)localObject2).sVb)) {
              break;
            }
            y.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((xu)localObject1).sLV), Long.valueOf(((xv)localObject2).sVb) });
            ((xv)localObject2).hf(((xu)localObject1).sLV);
            break;
            label1578:
            localxv = (xv)paramArrayOfByte.get(bk.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (bk.bl(localxv.sVi))
            {
              y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { localxv.sVi });
              break;
            }
            this.jZO = false;
            if (bk.bl(localxv.sUI))
            {
              com.tencent.mm.ak.f.Ne();
              str = a.MW();
              localxv.Xz(str);
              y.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
            }
            y.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { localxv.sUX, localxv.sUI });
            b.a(localxv, this.jZN, 0);
          }
          label1730:
          continue;
          label1732:
          y.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.jZQ.keySet().iterator();
      paramInt1 = 0;
      label1759:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (xv)((Iterator)localObject1).next();
        if (((Boolean)this.jZQ.get(localObject2)).booleanValue()) {
          break label2276;
        }
        paramInt1 += 1;
      }
    }
    label2276:
    for (;;)
    {
      break label1759;
      y.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[] { Integer.valueOf(paramq.size()), Integer.valueOf(paramArrayOfByte.size()) });
      if (paramInt1 > 0)
      {
        y.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
        paramInt1 = a(this.edc, this.dmL);
        if ((paramInt1 != -100) && (paramInt1 != -101)) {
          break;
        }
      }
      if (this.jZP)
      {
        y.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
        this.jZN.field_itemStatus = 12;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(this.jZN, new String[] { "localId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
        this.dmL.onSceneEnd(paramInt2, i, paramString, this);
        return;
      }
      if (this.jZO)
      {
        y.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
        if (this.jZN.field_id > 0)
        {
          this.jZN.field_itemStatus = 17;
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(this.jZN, new String[] { "localId" });
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getModService().run();
        }
        for (;;)
        {
          this.dmL.onSceneEnd(paramInt2, i, paramString, this);
          return;
          if (this.jZN.field_type == 18) {
            this.jZN.field_favProto.EP(1);
          }
          this.jZN.field_itemStatus = 9;
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(this.jZN, new String[] { "localId" });
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getSendService().run();
        }
      }
      if (this.jZN.field_id > 0) {}
      for (this.jZN.field_itemStatus = 15;; this.jZN.field_itemStatus = 4)
      {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(this.jZN, new String[] { "localId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
        break;
        if (this.jZN.field_type == 18) {
          this.jZN.field_favProto.EP(1);
        }
      }
    }
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 404;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */