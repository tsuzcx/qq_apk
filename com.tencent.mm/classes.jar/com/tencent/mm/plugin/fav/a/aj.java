package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.an.a;
import com.tencent.mm.an.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amk;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class aj
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private int tbq;
  public g tbr;
  private boolean tbs;
  private boolean tbt;
  HashMap<aml, Boolean> tbu;
  
  public aj(g paramg)
  {
    AppMethodBeat.i(103471);
    this.tbq = 0;
    this.callback = null;
    this.tbs = true;
    this.tbt = false;
    this.tbu = new HashMap();
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new xy();
    ((d.a)localObject).iLO = new xz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((d.a)localObject).funcId = 404;
    ((d.a)localObject).iLP = 197;
    ((d.a)localObject).respCmdId = 1000000197;
    this.rr = ((d.a)localObject).aXF();
    this.tbr = paramg;
    paramg = paramg.field_favProto.ppH.iterator();
    while (paramg.hasNext())
    {
      localObject = (aml)paramg.next();
      this.tbu.put(localObject, Boolean.FALSE);
    }
    AppMethodBeat.o(103471);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(103472);
    this.callback = parami;
    parami = this.tbu.keySet().iterator();
    int j = 0;
    Object localObject;
    if (parami.hasNext())
    {
      localObject = (aml)parami.next();
      if (((Boolean)this.tbu.get(localObject)).booleanValue()) {
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
        this.tbq = -100;
        AppMethodBeat.o(103472);
        return -100;
      }
      parami = (xy)this.rr.iLK.iLR;
      parami.oTA.clear();
      localObject = this.tbr.field_favProto.ppH;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        aml localaml = (aml)((List)localObject).get(m);
        if (((Boolean)this.tbu.get(localaml)).booleanValue()) {
          break label653;
        }
        k = i;
        if (!localaml.LvZ)
        {
          localxx = new xx();
          localxx.LiX = ((int)localaml.LvI);
          localxx.LiV = localaml.LvE;
          localxx.LiW = localaml.LvG;
          localxx.LiU = String.valueOf(m);
          localxx.LiZ = localaml.LvV;
          localxx.LiY = this.tbr.field_sourceType;
          localxx.Lja = 0;
          parami.oTA.add(localxx);
          k = i + 1;
          Log.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localxx.LiU, localxx.LiZ, Integer.valueOf(localxx.LiY), Integer.valueOf(localxx.LiX), localxx.LiV, localxx.LiW });
        }
        if (localaml.Lwb) {
          break label647;
        }
        xx localxx = new xx();
        localxx.LiX = ((int)localaml.LvT);
        localxx.LiV = localaml.LvP;
        localxx.LiW = localaml.LvR;
        localxx.LiZ = localaml.LvV;
        localxx.LiY = this.tbr.field_sourceType;
        localxx.LiU = (m + "t");
        localxx.Lja = 1;
        parami.oTA.add(localxx);
        i = k + 1;
        Log.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localxx.LiU, localxx.LiZ, Integer.valueOf(localxx.LiY), Integer.valueOf(localxx.LiX), localxx.LiV, localxx.LiW });
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
        parami.oTz = k;
        if (k == 0)
        {
          Log.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.tbq = -101;
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
    Log.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.tbq), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.tbq == -100))
      {
        Log.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(9, this.tbr.field_localId);
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if ((paramInt2 != 3) || (this.tbq != -101)) {
        break label828;
      }
      i = 0;
    }
    if ((this.tbq != -101) && (paramInt2 == 0) && (i == 0))
    {
      params = ((xz)((d)params).iLL.iLR).oTA;
      paramArrayOfByte = this.tbr.field_favProto.ppH;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < params.size())
      {
        localObject1 = (amk)params.get(paramInt1);
        localObject2 = ((amk)localObject1).LiU;
        aml localaml;
        if (!Util.isNullOrNil((String)localObject2))
        {
          Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((amk)localObject1).oTW), localObject2 });
          if (((amk)localObject1).oTW == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label849;
            }
            localaml = (aml)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((amk)localObject1).Lvf, ((amk)localObject1).LbJ, ((amk)localObject1).LiU, ((amk)localObject1).LiV, Integer.valueOf(((amk)localObject1).LiX), ((amk)localObject1).LiW });
            localaml.bgk(((amk)localObject1).LbJ);
            localaml.bgj(((amk)localObject1).Lvf);
            if (!Util.isNullOrNil(((amk)localObject1).KSu)) {
              localaml.bgy(((amk)localObject1).KSu);
            }
            if (Util.isNullOrNil(localaml.LvE))
            {
              Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              localaml.bgq(((amk)localObject1).LiV);
              localaml.Mu(((amk)localObject1).LiX);
              localaml.bgr(((amk)localObject1).LiW);
              b.a(localaml, this.tbr, 1, false);
            }
            if ((!Util.isNullOrNil(((amk)localObject1).LiV)) && (!((amk)localObject1).LiV.equals(localaml.LvE)))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((amk)localObject1).LiV, localaml.LvE });
              localaml.bgq(((amk)localObject1).LiV);
            }
            if ((!Util.isNullOrNil(((amk)localObject1).LiW)) && (!((amk)localObject1).LiW.equals(localaml.LvG)))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((amk)localObject1).LiW, localaml.LvG });
              localaml.bgr(((amk)localObject1).LiW);
            }
            if ((((amk)localObject1).LiX > 0) && (((amk)localObject1).LiX != localaml.LvI))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((amk)localObject1).LiX), Long.valueOf(localaml.LvI) });
              localaml.Mu(((amk)localObject1).LiX);
            }
          }
          label701:
          if (((String)localObject2).endsWith("t")) {
            break label1119;
          }
          localaml = (aml)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
          this.tbu.put(localaml, Boolean.TRUE);
          label743:
          if ((((amk)localObject1).oTW == 1) || (((amk)localObject1).oTW == 2)) {
            break label1253;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1594;
          }
          localaml = (aml)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
          if (!Util.isNullOrNil(localaml.LvE)) {
            break label1164;
          }
          Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { localaml.LvE });
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
          localaml = (aml)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((amk)localObject1).Lvf, ((amk)localObject1).LbJ, ((amk)localObject1).LiU, ((amk)localObject1).LiV, Integer.valueOf(((amk)localObject1).LiX), ((amk)localObject1).LiW });
          localaml.bgi(((amk)localObject1).LbJ);
          localaml.bgh(((amk)localObject1).Lvf);
          if (((amk)localObject1).LiX <= 0) {
            break label701;
          }
          localaml.Mv(((amk)localObject1).LiX);
          if ((!Util.isNullOrNil(((amk)localObject1).LiV)) && (!((amk)localObject1).LiV.equals(localaml.LvP)))
          {
            Log.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((amk)localObject1).LiV, localaml.LvP });
            localaml.bgv(((amk)localObject1).LiV);
          }
          if ((Util.isNullOrNil(((amk)localObject1).LiW)) || (((amk)localObject1).LiW.equals(localaml.LvR))) {
            break label701;
          }
          Log.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((amk)localObject1).LiW, localaml.LvR });
          localaml.bgw(((amk)localObject1).LiW);
          break label701;
          label1119:
          localaml = (aml)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.tbu.put(localaml, Boolean.TRUE);
          break label743;
          label1164:
          this.tbs = false;
          String str;
          if (Util.isNullOrNil(localaml.Lvp))
          {
            f.baR();
            str = a.baG();
            localaml.bgk(str);
            Log.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
          }
          Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { localaml.LvE, localaml.Lvp });
          b.a(localaml, this.tbr, 0, false);
          for (;;)
          {
            label1253:
            if (((amk)localObject1).oTW != 2) {
              break label1746;
            }
            this.tbt = true;
            if (((String)localObject2).endsWith("t")) {
              break label1748;
            }
            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((amk)localObject1).Lvg), ((amk)localObject1).Lvf, ((amk)localObject1).LbJ });
            localObject2 = (aml)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
            ((aml)localObject2).aje(((amk)localObject1).Lvg);
            ((aml)localObject2).bgk(((amk)localObject1).LbJ);
            ((aml)localObject2).bgj(((amk)localObject1).Lvf);
            if (!Util.isNullOrNil(((amk)localObject1).KSu)) {
              ((aml)localObject2).bgy(((amk)localObject1).KSu);
            }
            if ((!Util.isNullOrNil(((amk)localObject1).LiV)) && (!((amk)localObject1).LiV.equals(((aml)localObject2).LvE)))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((amk)localObject1).LiV, ((aml)localObject2).LvE });
              ((aml)localObject2).bgq(((amk)localObject1).LiV);
            }
            if ((!Util.isNullOrNil(((amk)localObject1).LiW)) && (!((amk)localObject1).LiW.equals(((aml)localObject2).LvG)))
            {
              Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((amk)localObject1).LiW, ((aml)localObject2).LvG });
              ((aml)localObject2).bgr(((amk)localObject1).LiW);
            }
            if ((((amk)localObject1).LiX <= 0) || (((amk)localObject1).LiX == ((aml)localObject2).LvI)) {
              break;
            }
            Log.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((amk)localObject1).LiX), Long.valueOf(((aml)localObject2).LvI) });
            ((aml)localObject2).Mu(((amk)localObject1).LiX);
            break;
            label1594:
            localaml = (aml)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (Util.isNullOrNil(localaml.LvP))
            {
              Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { localaml.LvP });
              break;
            }
            this.tbs = false;
            if (Util.isNullOrNil(localaml.Lvp))
            {
              f.baR();
              str = a.baG();
              localaml.bgk(str);
              Log.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { str });
            }
            Log.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { localaml.LvE, localaml.Lvp });
            b.a(localaml, this.tbr, 0);
          }
          label1746:
          continue;
          label1748:
          Log.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.tbu.keySet().iterator();
      paramInt1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aml)((Iterator)localObject1).next();
        if (((Boolean)this.tbu.get(localObject2)).booleanValue()) {
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
      if (this.tbt)
      {
        Log.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
        this.tbr.field_itemStatus = 12;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbr, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, i, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if (this.tbs)
      {
        Log.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
        if (this.tbr.field_id > 0)
        {
          this.tbr.field_itemStatus = 17;
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbr, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getModService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(103473);
          return;
          if (this.tbr.field_type == 18) {
            this.tbr.field_favProto.ajl(1);
          }
          this.tbr.field_itemStatus = 9;
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbr, new String[] { "localId" });
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
        }
      }
      if (this.tbr.field_id > 0) {}
      for (this.tbr.field_itemStatus = 15;; this.tbr.field_itemStatus = 4)
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(this.tbr, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
        break;
        if (this.tbr.field_type == 18) {
          this.tbr.field_favProto.ajl(1);
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
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */