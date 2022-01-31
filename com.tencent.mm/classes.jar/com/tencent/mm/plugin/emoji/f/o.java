package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.av;
import com.tencent.mm.h.a.av.b;
import com.tencent.mm.h.a.cu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private final int fzn;
  public byte[] iZW = null;
  public int iZY;
  private boolean iZZ = false;
  private ArrayList<vn> jaa = new ArrayList();
  public final int mType;
  
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
    b.a locala = new b.a();
    locala.ecH = new afh();
    locala.ecI = new afi();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionlist";
    locala.ecG = 411;
    locala.ecJ = 210;
    locala.ecK = 1000000210;
    this.dmK = locala.Kt();
    this.iZW = paramArrayOfByte;
    this.mType = paramInt1;
    this.fzn = paramInt2;
    this.iZZ = paramBoolean;
  }
  
  public static com.tencent.mm.plugin.emoji.model.f a(afi paramafi)
  {
    y.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
    if (paramafi == null) {
      return null;
    }
    com.tencent.mm.plugin.emoji.model.f localf = new com.tencent.mm.plugin.emoji.model.f();
    if (paramafi != null)
    {
      localf.iYg = paramafi.tcZ;
      Object localObject1 = new ArrayList();
      if ((paramafi.tda != null) && (!paramafi.tda.isEmpty()))
      {
        Object[] arrayOfObject = paramafi.tda.toArray();
        if ((arrayOfObject != null) && (arrayOfObject.length > 0))
        {
          int j = arrayOfObject.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = arrayOfObject[i];
            if ((localObject2 != null) && ((localObject2 instanceof vn)))
            {
              localObject2 = (vn)localObject2;
              if ((localObject2 != null) && (!bk.bl(((vn)localObject2).syc))) {
                ((List)localObject1).add(new com.tencent.mm.plugin.emoji.a.a.f((vn)localObject2));
              }
            }
            i += 1;
          }
        }
      }
      localf.iYh = ((List)localObject1);
      localf.iYi = paramafi.tdb;
      localf.iYj = paramafi.tdd;
      localObject1 = paramafi.tdl;
      if (localf.iYl == null)
      {
        localf.iYl = new LinkedList();
        localf.iYl.addAll((Collection)localObject1);
      }
      localf.iYk = paramafi.tdh;
    }
    return localf;
  }
  
  private void aIj()
  {
    afi localafi = aIi();
    if ((localafi != null) && (localafi.tda != null) && (localafi.tda.size() > 0))
    {
      this.jaa.addAll(localafi.tda);
      return;
    }
    y.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
  }
  
  private void t(ArrayList<vn> paramArrayList)
  {
    com.tencent.mm.storage.emotion.a locala = i.getEmojiStorageMgr().uBc;
    if (locala == null)
    {
      y.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
      return;
    }
    long l2 = System.currentTimeMillis();
    Object localObject2;
    long l1;
    if ((locala.dXw instanceof h))
    {
      localObject2 = (h)locala.dXw;
      l1 = ((h)localObject2).eV(Thread.currentThread().getId());
      y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", new Object[] { Long.valueOf(l1) });
    }
    for (;;)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        if ((paramArrayList == null) || (paramArrayList.size() <= 0))
        {
          y.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
          if (localObject2 != null)
          {
            ((h)localObject2).hI(l1);
            y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
          }
          y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l2).longValue()) });
          locala.b("event_update_group", 0, bk.csb().toString());
          if (!this.iZZ) {
            break label1336;
          }
          if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
            break;
          }
          y.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[] { Integer.valueOf(paramArrayList.size()) });
          localObject1 = new ArrayList();
          paramArrayList = paramArrayList.iterator();
        }
      }
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label1306;
        }
        localObject2 = (vn)paramArrayList.next();
        if ((localObject2 != null) && (!bk.bl(((vn)localObject2).syc)))
        {
          if (((vn)localObject2).syc.equals(String.valueOf(EmojiGroupInfo.uCQ)))
          {
            ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
            continue;
            HashMap localHashMap = locala.cwk();
            ArrayList localArrayList1 = new ArrayList();
            ArrayList localArrayList2 = new ArrayList();
            int j = paramArrayList.size();
            y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[] { Integer.valueOf(j) });
            int i = 0;
            Object localObject3;
            while (i < j)
            {
              vn localvn = (vn)paramArrayList.get(i);
              if ((localvn == null) || (bk.bl(localvn.syc)))
              {
                y.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                i += 1;
              }
              else
              {
                y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[] { localvn.syc });
                localArrayList1.add(localvn.syc);
                if (localHashMap.containsKey(localvn.syc))
                {
                  localObject3 = (EmojiGroupInfo)localHashMap.get(localvn.syc);
                  localObject1 = localObject3;
                  if (localObject3 == null) {
                    localObject1 = new EmojiGroupInfo();
                  }
                  ((EmojiGroupInfo)localObject1).field_productID = localvn.syc;
                  label494:
                  if (!localvn.syc.equals("com.tencent.xin.emoticon.tusiji")) {
                    break label932;
                  }
                  ((EmojiGroupInfo)localObject1).field_flag = 0;
                  ((EmojiGroupInfo)localObject1).field_packName = "emoji_custom_all";
                  ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.TYPE_SYSTEM;
                  label530:
                  ((EmojiGroupInfo)localObject1).field_packIconUrl = localvn.kSy;
                  ((EmojiGroupInfo)localObject1).field_packGrayIconUrl = localvn.sSp;
                  ((EmojiGroupInfo)localObject1).field_packCoverUrl = localvn.sSk;
                  ((EmojiGroupInfo)localObject1).field_packDesc = localvn.sSd;
                  ((EmojiGroupInfo)localObject1).field_packAuthInfo = localvn.sSe;
                  ((EmojiGroupInfo)localObject1).field_packPrice = localvn.sSf;
                  ((EmojiGroupInfo)localObject1).field_packType = localvn.sSg;
                  ((EmojiGroupInfo)localObject1).field_packFlag = localvn.sSh;
                  ((EmojiGroupInfo)localObject1).field_packExpire = localvn.sSl;
                  ((EmojiGroupInfo)localObject1).field_packTimeStamp = localvn.sSK;
                  ((EmojiGroupInfo)localObject1).field_sort = 1;
                  ((EmojiGroupInfo)localObject1).field_idx = i;
                  if (((EmojiGroupInfo)localObject1).field_sync == 0) {
                    if ((((EmojiGroupInfo)localObject1).field_status != 7) || (((EmojiGroupInfo)localObject1).field_packStatus != 1)) {
                      break label953;
                    }
                  }
                }
                label932:
                label953:
                for (((EmojiGroupInfo)localObject1).field_sync = 2;; ((EmojiGroupInfo)localObject1).field_sync = 1)
                {
                  if (((EmojiGroupInfo)localObject1).field_sync == 2) {
                    ((EmojiGroupInfo)localObject1).field_status = 7;
                  }
                  if ((((EmojiGroupInfo)localObject1).field_sync == 2) && (!localvn.syc.equals("com.tencent.xin.emoticon.tusiji")))
                  {
                    localObject3 = new av();
                    ((av)localObject3).bHb.type = 1;
                    ((av)localObject3).bHb.bHe = localvn.syc;
                    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
                    if (!((av)localObject3).bHc.bFQ)
                    {
                      y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[] { localvn.syc });
                      ((EmojiGroupInfo)localObject1).field_sync = 1;
                    }
                  }
                  y.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[] { ((EmojiGroupInfo)localObject1).field_productID, Long.valueOf(((EmojiGroupInfo)localObject1).field_lastUseTime), Integer.valueOf(((EmojiGroupInfo)localObject1).field_sort) });
                  locala.a((com.tencent.mm.sdk.e.c)localObject1);
                  break;
                  if (localvn.syc.equals("com.tencent.xin.emoticon.tusiji"))
                  {
                    localObject3 = (EmojiGroupInfo)localHashMap.get(String.valueOf(EmojiGroupInfo.uCQ));
                    localObject1 = localObject3;
                    if (localObject3 == null) {
                      localObject1 = new EmojiGroupInfo();
                    }
                    ((EmojiGroupInfo)localObject1).field_productID = String.valueOf(EmojiGroupInfo.uCQ);
                    break label494;
                  }
                  localObject1 = new EmojiGroupInfo();
                  ((EmojiGroupInfo)localObject1).field_productID = localvn.syc;
                  break label494;
                  ((EmojiGroupInfo)localObject1).field_packName = localvn.sSc;
                  ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.uCN;
                  break label530;
                }
              }
            }
            localObject1 = localHashMap.values().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (EmojiGroupInfo)((Iterator)localObject1).next();
              if ((localObject3 != null) && (!bk.bl(((EmojiGroupInfo)localObject3).field_productID)) && (!((EmojiGroupInfo)localObject3).field_productID.equals(String.valueOf(EmojiGroupInfo.uCR)))) {
                if (((EmojiGroupInfo)localObject3).field_productID.equals(String.valueOf(EmojiGroupInfo.uCQ)))
                {
                  if (!localArrayList1.contains("com.tencent.xin.emoticon.tusiji"))
                  {
                    y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { "com.tencent.xin.emoticon.tusiji" });
                    localArrayList2.add("com.tencent.xin.emoticon.tusiji");
                  }
                }
                else if (!localArrayList1.contains(((EmojiGroupInfo)localObject3).field_productID))
                {
                  y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { ((EmojiGroupInfo)localObject3).field_productID });
                  localArrayList2.add(((EmojiGroupInfo)localObject3).field_productID);
                }
              }
            }
            if (localArrayList2.size() > 0)
            {
              localObject1 = localArrayList2.iterator();
              while (((Iterator)localObject1).hasNext()) {
                locala.acy((String)((Iterator)localObject1).next());
              }
            }
            locala.b("event_update_group", 0, bk.csb().toString());
            break;
            localObject1 = locala.cwl().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (EmojiGroupInfo)((Iterator)localObject1).next();
              if (((EmojiGroupInfo)localObject3).field_sync > 0)
              {
                y.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[] { ((EmojiGroupInfo)localObject3).field_productID });
                locala.acy(((EmojiGroupInfo)localObject3).field_productID);
              }
            }
            locala.acy("com.tencent.xin.emoticon.tusiji");
            break;
          }
          ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b(((vn)localObject2).syc, (byte)0));
        }
      }
      label1306:
      i.aHQ().v((ArrayList)localObject1);
      if (i.aHQ().jan.jaD) {
        break;
      }
      i.aHQ().jan.aIn();
      return;
      label1336:
      Object localObject1 = (ArrayList)locala.cwu();
      if (((ArrayList)localObject1).size() <= 0) {
        break;
      }
      y.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
      paramArrayList = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!bk.bl((String)localObject2)) {
          if (((String)localObject2).equals(String.valueOf(EmojiGroupInfo.uCQ))) {
            paramArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
          } else {
            paramArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.b((String)localObject2));
          }
        }
      }
      i.aHQ().v(paramArrayList);
      if (i.aHQ().jan.jaD) {
        break;
      }
      i.aHQ().jan.aIn();
      return;
      l1 = -1L;
      localObject2 = null;
    }
  }
  
  protected final int Ka()
  {
    return 100;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    afh localafh = (afh)this.dmK.ecE.ecN;
    if (this.iZW != null)
    {
      localafh.swr = aa.I(this.iZW);
      if (localafh.swr != null) {
        break label112;
      }
    }
    label112:
    for (paramf = "Buf is NULL";; paramf = localafh.swr.toString())
    {
      y.d("MicroMsg.emoji.NetSceneGetEmotionList", paramf);
      localafh.sAs = this.mType;
      localafh.pyo = this.fzn;
      if (this.mType == 7) {
        localafh.tcY = this.iZY;
      }
      return a(parame, this.dmK, this);
      localafh.swr = new bmk();
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if (this.mType == 8)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        g.DP().Dz().c(ac.a.unX, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else if (this.mType == 11)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label173;
      }
      g.DP().Dz().c(ac.a.uob, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      i.getEmojiStorageMgr().uBe.a(this.mType, aIi());
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break label202;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      g.DP().Dz().c(ac.a.unX, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      break;
      label173:
      g.DP().Dz().c(ac.a.uob, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    label202:
    paramArrayOfByte = (afi)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramArrayOfByte.swr != null) {
      this.iZW = aa.a(paramArrayOfByte.swr);
    }
    if (this.mType == 8)
    {
      if (paramInt3 != 0) {
        break label383;
      }
      aIj();
      t(this.jaa);
      g.DP().Dz().c(ac.a.unX, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      if ((this.mType == 1) || (this.mType == 5) || (this.mType == 9))
      {
        paramq = i.getEmojiStorageMgr();
        paramArrayOfByte = aIi().tdm;
        if (!bk.isEqual(paramq.uBy, paramArrayOfByte))
        {
          paramq.uBy = paramArrayOfByte;
          g.DP().Dz().c(ac.a.uzH, paramArrayOfByte);
          com.tencent.mm.sdk.b.a.udP.m(new cu());
        }
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label383:
      if (paramInt3 == 2)
      {
        aIj();
        ((afh)((com.tencent.mm.ah.b)paramq).ecE.ecN).swr = ((afi)((com.tencent.mm.ah.b)paramq).ecF.ecN).swr;
        a(this.edc, this.dmL);
      }
      else if (paramInt3 == 3)
      {
        if (this.jaa != null) {
          this.jaa.clear();
        }
        ((afh)((com.tencent.mm.ah.b)paramq).ecE.ecN).swr = new bmk();
        a(this.edc, this.dmL);
      }
    }
  }
  
  public final afi aIi()
  {
    if (this.dmK == null) {
      return null;
    }
    return (afi)this.dmK.ecF.ecN;
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 411;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.o
 * JD-Core Version:    0.7.0.1
 */