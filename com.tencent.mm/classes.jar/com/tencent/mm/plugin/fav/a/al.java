package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class al
  extends com.tencent.mm.am.p
  implements m
{
  private int AdE;
  public g AdF;
  private boolean AdG;
  private boolean AdH;
  HashMap<arf, Boolean> AdI;
  private LinkedList<a> AdJ;
  private LinkedList<a> AdK;
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public al(g paramg)
  {
    AppMethodBeat.i(103471);
    this.AdE = 0;
    this.callback = null;
    this.AdG = true;
    this.AdH = false;
    this.AdI = new HashMap();
    this.AdJ = new LinkedList();
    this.AdK = new LinkedList();
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aab();
    ((c.a)localObject).otF = new aac();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkcdn";
    ((c.a)localObject).funcId = 404;
    ((c.a)localObject).otG = 197;
    ((c.a)localObject).respCmdId = 1000000197;
    this.rr = ((c.a)localObject).bEF();
    this.AdF = paramg;
    paramg = paramg.field_favProto.vEn.iterator();
    while (paramg.hasNext())
    {
      localObject = (arf)paramg.next();
      this.AdI.put(localObject, Boolean.FALSE);
    }
    AppMethodBeat.o(103471);
  }
  
  private boolean dQV()
  {
    AppMethodBeat.i(274347);
    Iterator localIterator = this.AdK.iterator();
    a locala;
    for (boolean bool = false; localIterator.hasNext(); bool = true)
    {
      locala = (a)localIterator.next();
      b.a(locala.hIy, locala.AdF, locala.AdL);
    }
    this.AdK.clear();
    localIterator = this.AdJ.iterator();
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      b.a(locala.hIy, locala.AdF, locala.AdL, locala.AdM);
      bool = true;
    }
    this.AdJ.clear();
    Log.i("MicroMsg.Fav.NetSceneCheckCDN", "insertAllCdnItem dataSize:%s thumbSize:%s needUpload:%s", new Object[] { Integer.valueOf(this.AdJ.size()), Integer.valueOf(this.AdK.size()), Boolean.valueOf(bool) });
    AppMethodBeat.o(274347);
    return bool;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(103472);
    this.callback = paramh;
    paramh = this.AdI.keySet().iterator();
    int j = 0;
    Object localObject;
    if (paramh.hasNext())
    {
      localObject = (arf)paramh.next();
      if (((Boolean)this.AdI.get(localObject)).booleanValue()) {
        break label657;
      }
    }
    label648:
    label654:
    label657:
    for (int i = j + 1;; i = j)
    {
      j = i;
      break;
      if (j == 0)
      {
        Log.e("MicroMsg.Fav.NetSceneCheckCDN", "klem doScene data list null");
        this.AdE = -100;
        AppMethodBeat.o(103472);
        return -100;
      }
      paramh = (aab)c.b.b(this.rr.otB);
      paramh.vgO.clear();
      localObject = this.AdF.field_favProto.vEn;
      int m = 0;
      i = 0;
      int k;
      if (m < ((List)localObject).size())
      {
        arf localarf = (arf)((List)localObject).get(m);
        if (((Boolean)this.AdI.get(localarf)).booleanValue()) {
          break label654;
        }
        k = i;
        if (!localarf.Zzq)
        {
          localaaa = new aaa();
          localaaa.Ziy = ((int)localarf.Zza);
          localaaa.Ziw = localarf.ZyW;
          localaaa.Zix = localarf.ZyY;
          localaaa.Ziv = String.valueOf(m);
          localaaa.ZiA = localarf.Zzm;
          localaaa.Ziz = this.AdF.field_sourceType;
          localaaa.ZiB = 0;
          paramh.vgO.add(localaaa);
          k = i + 1;
          Log.i("MicroMsg.Fav.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localaaa.Ziv, localaaa.ZiA, Integer.valueOf(localaaa.Ziz), Integer.valueOf(localaaa.Ziy), localaaa.Ziw, localaaa.Zix });
        }
        if (localarf.Zzs) {
          break label648;
        }
        aaa localaaa = new aaa();
        localaaa.Ziy = ((int)localarf.Zzk);
        localaaa.Ziw = localarf.QJs;
        localaaa.Zix = localarf.Zzi;
        localaaa.ZiA = localarf.Zzm;
        localaaa.Ziz = this.AdF.field_sourceType;
        localaaa.Ziv = (m + "t");
        localaaa.ZiB = 1;
        paramh.vgO.add(localaaa);
        i = k + 1;
        Log.i("MicroMsg.Fav.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[] { localaaa.Ziv, localaaa.ZiA, Integer.valueOf(localaaa.Ziz), Integer.valueOf(localaaa.Ziy), localaaa.Ziw, localaaa.Zix });
        label538:
        k = i;
        if (i >= 19) {
          break label559;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        k = i;
        label559:
        Log.i("MicroMsg.Fav.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m + 1) });
        paramh.vgN = k;
        if (k == 0)
        {
          Log.w("MicroMsg.Fav.NetSceneCheckCDN", "no more data, must not check cdn!");
          this.AdE = -101;
          AppMethodBeat.o(103472);
          return -101;
        }
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(103472);
        return i;
        i = k;
        break label538;
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
    Log.i("MicroMsg.Fav.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.AdE), paramString });
    int i;
    if (paramInt2 == 0)
    {
      i = paramInt3;
      if (paramInt3 == 0) {}
    }
    else
    {
      if ((paramInt2 == 3) && (this.AdE == -100))
      {
        Log.d("MicroMsg.Fav.NetSceneCheckCDN", "need not check cdn, add fav now");
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ak(9, this.AdF.field_localId);
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(103473);
        return;
      }
      if ((paramInt2 != 3) || (this.AdE != -101)) {
        break label844;
      }
      i = 0;
    }
    if ((this.AdE != -101) && (paramInt2 == 0) && (i == 0))
    {
      params = ((aac)c.c.b(((c)params).otC)).vgO;
      paramArrayOfByte = this.AdF.field_favProto.vEn;
      paramInt1 = 0;
      Object localObject2;
      if (paramInt1 < params.size())
      {
        localObject1 = (are)params.get(paramInt1);
        localObject2 = ((are)localObject1).Ziv;
        Object localObject3;
        Object localObject4;
        if (!Util.isNullOrNil((String)localObject2))
        {
          Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[] { Integer.valueOf(((are)localObject1).vhk), localObject2 });
          if (((are)localObject1).vhk == 1)
          {
            if (((String)localObject2).endsWith("t")) {
              break label865;
            }
            localObject3 = (arf)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
            Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((are)localObject1).Zyx, ((are)localObject1).ZaN, ((are)localObject1).Ziv, ((are)localObject1).Ziw, Integer.valueOf(((are)localObject1).Ziy), ((are)localObject1).Zix });
            ((arf)localObject3).bst(((are)localObject1).ZaN);
            ((arf)localObject3).bss(((are)localObject1).Zyx);
            if (!Util.isNullOrNil(((are)localObject1).YQV)) {
              ((arf)localObject3).bsH(((are)localObject1).YQV);
            }
            if (Util.isNullOrNil(((arf)localObject3).ZyW))
            {
              Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
              ((arf)localObject3).bsz(((are)localObject1).Ziw);
              ((arf)localObject3).yo(((are)localObject1).Ziy);
              ((arf)localObject3).bsA(((are)localObject1).Zix);
              localObject4 = new a((arf)localObject3, this.AdF, 1);
              this.AdJ.add(localObject4);
            }
            if ((!Util.isNullOrNil(((are)localObject1).Ziw)) && (!((are)localObject1).Ziw.equals(((arf)localObject3).ZyW)))
            {
              Log.w("MicroMsg.Fav.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[] { ((are)localObject1).Ziw, ((arf)localObject3).ZyW });
              ((arf)localObject3).bsz(((are)localObject1).Ziw);
            }
            if ((!Util.isNullOrNil(((are)localObject1).Zix)) && (!((are)localObject1).Zix.equals(((arf)localObject3).ZyY)))
            {
              Log.w("MicroMsg.Fav.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[] { ((are)localObject1).Zix, ((arf)localObject3).ZyY });
              ((arf)localObject3).bsA(((are)localObject1).Zix);
            }
            if ((((are)localObject1).Ziy > 0) && (((are)localObject1).Ziy != ((arf)localObject3).Zza))
            {
              Log.w("MicroMsg.Fav.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((are)localObject1).Ziy), Long.valueOf(((arf)localObject3).Zza) });
              ((arf)localObject3).yo(((are)localObject1).Ziy);
            }
          }
          label717:
          if (((String)localObject2).endsWith("t")) {
            break label1135;
          }
          localObject3 = (arf)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
          this.AdI.put(localObject3, Boolean.TRUE);
          label759:
          if ((((are)localObject1).vhk == 1) || (((are)localObject1).vhk == 2)) {
            break label1285;
          }
          if (((String)localObject2).endsWith("t")) {
            break label1626;
          }
          localObject3 = (arf)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
          if (!Util.isNullOrNil(((arf)localObject3).ZyW)) {
            break label1180;
          }
          Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[] { ((arf)localObject3).ZyW });
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label844:
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(103473);
          return;
          label865:
          localObject3 = (arf)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[] { ((are)localObject1).Zyx, ((are)localObject1).ZaN, ((are)localObject1).Ziv, ((are)localObject1).Ziw, Integer.valueOf(((are)localObject1).Ziy), ((are)localObject1).Zix });
          ((arf)localObject3).bsr(((are)localObject1).ZaN);
          ((arf)localObject3).bsq(((are)localObject1).Zyx);
          if (((are)localObject1).Ziy <= 0) {
            break label717;
          }
          ((arf)localObject3).yp(((are)localObject1).Ziy);
          if ((!Util.isNullOrNil(((are)localObject1).Ziw)) && (!((are)localObject1).Ziw.equals(((arf)localObject3).QJs)))
          {
            Log.w("MicroMsg.Fav.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[] { ((are)localObject1).Ziw, ((arf)localObject3).QJs });
            ((arf)localObject3).bsE(((are)localObject1).Ziw);
          }
          if ((Util.isNullOrNil(((are)localObject1).Zix)) || (((are)localObject1).Zix.equals(((arf)localObject3).Zzi))) {
            break label717;
          }
          Log.w("MicroMsg.Fav.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[] { ((are)localObject1).Zix, ((arf)localObject3).Zzi });
          ((arf)localObject3).bsF(((are)localObject1).Zix);
          break label717;
          label1135:
          localObject3 = (arf)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
          this.AdI.put(localObject3, Boolean.TRUE);
          break label759;
          label1180:
          this.AdG = false;
          if (Util.isNullOrNil(((arf)localObject3).ZyH))
          {
            k.bHX();
            localObject4 = d.bHI();
            ((arf)localObject3).bst((String)localObject4);
            Log.i("MicroMsg.Fav.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { localObject4 });
          }
          Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[] { ((arf)localObject3).ZyW, ((arf)localObject3).ZyH });
          localObject3 = new a((arf)localObject3, this.AdF, 0);
          this.AdJ.add(localObject3);
          for (;;)
          {
            label1285:
            if (((are)localObject1).vhk != 2) {
              break label1795;
            }
            this.AdH = true;
            if (((String)localObject2).endsWith("t")) {
              break label1797;
            }
            Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[] { Integer.valueOf(((are)localObject1).Zyy), ((are)localObject1).Zyx, ((are)localObject1).ZaN });
            localObject2 = (arf)paramArrayOfByte.get(Util.getInt((String)localObject2, 0));
            ((arf)localObject2).axz(((are)localObject1).Zyy);
            ((arf)localObject2).bst(((are)localObject1).ZaN);
            ((arf)localObject2).bss(((are)localObject1).Zyx);
            if (!Util.isNullOrNil(((are)localObject1).YQV)) {
              ((arf)localObject2).bsH(((are)localObject1).YQV);
            }
            if ((!Util.isNullOrNil(((are)localObject1).Ziw)) && (!((are)localObject1).Ziw.equals(((arf)localObject2).ZyW)))
            {
              Log.w("MicroMsg.Fav.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[] { ((are)localObject1).Ziw, ((arf)localObject2).ZyW });
              ((arf)localObject2).bsz(((are)localObject1).Ziw);
            }
            if ((!Util.isNullOrNil(((are)localObject1).Zix)) && (!((are)localObject1).Zix.equals(((arf)localObject2).ZyY)))
            {
              Log.w("MicroMsg.Fav.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[] { ((are)localObject1).Zix, ((arf)localObject2).ZyY });
              ((arf)localObject2).bsA(((are)localObject1).Zix);
            }
            if ((((are)localObject1).Ziy <= 0) || (((are)localObject1).Ziy == ((arf)localObject2).Zza)) {
              break;
            }
            Log.w("MicroMsg.Fav.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[] { Integer.valueOf(((are)localObject1).Ziy), Long.valueOf(((arf)localObject2).Zza) });
            ((arf)localObject2).yo(((are)localObject1).Ziy);
            break;
            label1626:
            localObject3 = (arf)paramArrayOfByte.get(Util.getInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1), 0));
            if (Util.isNullOrNil(((arf)localObject3).QJs))
            {
              Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[] { ((arf)localObject3).QJs });
              break;
            }
            this.AdG = false;
            if (Util.isNullOrNil(((arf)localObject3).ZyH))
            {
              k.bHX();
              localObject4 = d.bHI();
              ((arf)localObject3).bst((String)localObject4);
              Log.i("MicroMsg.Fav.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[] { localObject4 });
            }
            Log.i("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[] { ((arf)localObject3).ZyW, ((arf)localObject3).ZyH });
            localObject3 = new a((arf)localObject3, this.AdF, 0);
            this.AdK.add(localObject3);
          }
          label1795:
          continue;
          label1797:
          Log.e("MicroMsg.Fav.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
        }
      }
      Object localObject1 = this.AdI.keySet().iterator();
      paramInt1 = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (arf)((Iterator)localObject1).next();
        if (((Boolean)this.AdI.get(localObject2)).booleanValue()) {
          break label2405;
        }
        paramInt1 += 1;
      }
    }
    label2405:
    for (;;)
    {
      break;
      Log.i("MicroMsg.Fav.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[] { Integer.valueOf(params.size()), Integer.valueOf(paramArrayOfByte.size()) });
      if (paramInt1 > 0)
      {
        paramInt1 = doScene(dispatcher(), this.callback);
        Log.w("MicroMsg.Fav.NetSceneCheckCDN", "check cdn list not end, continues %s", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 != -100) && (paramInt1 != -101))
        {
          AppMethodBeat.o(103473);
          return;
        }
      }
      if (this.AdH)
      {
        Log.i("MicroMsg.Fav.NetSceneCheckCDN", "onGYNet waitServerUpload, send item now");
        this.AdF.field_itemStatus = 12;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(this.AdF, new String[] { "localId" });
        if (dQV()) {
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(103473);
          return;
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
        }
      }
      if (this.AdG)
      {
        Log.i("MicroMsg.Fav.NetSceneCheckCDN", "onGYNet all data exist, start send item");
        if (this.AdF.field_id > 0)
        {
          this.AdF.field_itemStatus = 17;
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(this.AdF, new String[] { "localId" });
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getModService().run();
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, i, paramString, this);
          AppMethodBeat.o(103473);
          return;
          if (this.AdF.field_type == 18) {
            this.AdF.field_favProto.axG(1);
          }
          this.AdF.field_itemStatus = 9;
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(this.AdF, new String[] { "localId" });
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
        }
      }
      dQV();
      if (this.AdF.field_id > 0) {}
      for (this.AdF.field_itemStatus = 15;; this.AdF.field_itemStatus = 4)
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(this.AdF, new String[] { "localId" });
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
        break;
        if (this.AdF.field_type == 18) {
          this.AdF.field_favProto.axG(1);
        }
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  final class a
  {
    g AdF;
    int AdL;
    boolean AdM;
    arf hIy;
    
    public a(arf paramarf, g paramg, int paramInt)
    {
      this.hIy = paramarf;
      this.AdF = paramg;
      this.AdL = paramInt;
      this.AdM = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */