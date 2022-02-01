package com.tencent.mm.plugin.emoji.f;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class n
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private final int mScene;
  public final int mType;
  public byte[] oyQ;
  public int oyS;
  boolean oyT;
  ArrayList<EmotionSummary> oyU;
  private final com.tencent.mm.al.b rr;
  
  public n(int paramInt1, int paramInt2)
  {
    this(paramInt1, null, paramInt2);
  }
  
  public n(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this(paramInt1, paramArrayOfByte, paramInt2, false);
  }
  
  public n(int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(108706);
    this.oyT = false;
    this.oyU = new ArrayList();
    this.oyQ = null;
    b.a locala = new b.a();
    locala.gUU = new GetEmotionListRequest();
    locala.gUV = new GetEmotionListResponse();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionlist";
    locala.funcId = 411;
    locala.reqCmdId = 210;
    locala.respCmdId = 1000000210;
    this.rr = locala.atI();
    this.oyQ = paramArrayOfByte;
    this.mType = paramInt1;
    this.mScene = paramInt2;
    this.oyT = paramBoolean;
    AppMethodBeat.o(108706);
  }
  
  public static com.tencent.mm.plugin.emoji.model.f b(GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(108709);
    ad.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
    if (paramGetEmotionListResponse == null)
    {
      AppMethodBeat.o(108709);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.f localf = new com.tencent.mm.plugin.emoji.model.f();
    if (paramGetEmotionListResponse != null)
    {
      localf.owY = paramGetEmotionListResponse.EmotionCount;
      Object localObject1 = new ArrayList();
      if ((paramGetEmotionListResponse.EmotionList != null) && (!paramGetEmotionListResponse.EmotionList.isEmpty()))
      {
        Object[] arrayOfObject = paramGetEmotionListResponse.EmotionList.toArray();
        if ((arrayOfObject != null) && (arrayOfObject.length > 0))
        {
          int j = arrayOfObject.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = arrayOfObject[i];
            if ((localObject2 != null) && ((localObject2 instanceof EmotionSummary)))
            {
              localObject2 = (EmotionSummary)localObject2;
              if ((localObject2 != null) && (!bt.isNullOrNil(((EmotionSummary)localObject2).ProductID))) {
                ((List)localObject1).add(new com.tencent.mm.plugin.emoji.a.a.f((EmotionSummary)localObject2));
              }
            }
            i += 1;
          }
        }
      }
      localf.owZ = ((List)localObject1);
      localf.oxa = paramGetEmotionListResponse.Banner;
      localf.oxb = paramGetEmotionListResponse.NewBannerList;
      localObject1 = paramGetEmotionListResponse.CellSetList;
      if (localf.oxd == null)
      {
        localf.oxd = new LinkedList();
        localf.oxd.addAll((Collection)localObject1);
      }
      localf.oxc = paramGetEmotionListResponse.BannerSetList;
    }
    AppMethodBeat.o(108709);
    return localf;
  }
  
  private void bVt()
  {
    AppMethodBeat.i(108710);
    GetEmotionListResponse localGetEmotionListResponse = bVs();
    if ((localGetEmotionListResponse != null) && (localGetEmotionListResponse.EmotionList != null) && (localGetEmotionListResponse.EmotionList.size() > 0))
    {
      this.oyU.addAll(localGetEmotionListResponse.EmotionList);
      AppMethodBeat.o(108710);
      return;
    }
    ad.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
    AppMethodBeat.o(108710);
  }
  
  public final GetEmotionListResponse bVs()
  {
    if (this.rr == null) {
      return null;
    }
    return (GetEmotionListResponse)this.rr.gUT.gUX;
  }
  
  public int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(108707);
    this.callback = paramg;
    GetEmotionListRequest localGetEmotionListRequest = (GetEmotionListRequest)this.rr.gUS.gUX;
    if (this.oyQ != null)
    {
      localGetEmotionListRequest.ReqBuf = z.am(this.oyQ);
      if (localGetEmotionListRequest.ReqBuf != null) {
        break label130;
      }
    }
    label130:
    for (paramg = "Buf is NULL";; paramg = localGetEmotionListRequest.ReqBuf.toString())
    {
      ad.d("MicroMsg.emoji.NetSceneGetEmotionList", paramg);
      localGetEmotionListRequest.ReqType = this.mType;
      localGetEmotionListRequest.Scene = this.mScene;
      if (this.mType == 7) {
        localGetEmotionListRequest.Category = this.oyS;
      }
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108707);
      return i;
      localGetEmotionListRequest.ReqBuf = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public int getType()
  {
    return 411;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108708);
    ad.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if (this.mType == 8)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgi, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else if (this.mType == 11)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label185;
      }
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgm, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().Fzb.a(this.mType, bVs());
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break label214;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgi, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      break;
      label185:
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgm, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    label214:
    paramArrayOfByte = (GetEmotionListResponse)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramArrayOfByte.ReqBuf != null) {
      this.oyQ = z.a(paramArrayOfByte.ReqBuf);
    }
    if (this.mType == 8)
    {
      if (paramInt3 == 0)
      {
        bVt();
        com.tencent.e.h.Iye.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179057);
            n localn = n.this;
            Object localObject3 = n.this.oyU;
            com.tencent.mm.storage.emotion.c localc = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyZ;
            if (localc == null)
            {
              ad.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
              AppMethodBeat.o(179057);
              return;
            }
            long l = System.currentTimeMillis();
            Object localObject1;
            if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
              if ((localObject3 == null) || (((List)localObject3).size() <= 0))
              {
                ad.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
                ad.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
                localc.doNotify("event_update_group", 0, bt.eGN().toString());
                if (!localn.oyT) {
                  break label1327;
                }
                if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
                  break label1493;
                }
                ad.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()) });
                localObject1 = new ArrayList();
                localObject2 = ((ArrayList)localObject3).iterator();
              }
            }
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label1292;
              }
              localObject3 = (EmotionSummary)((Iterator)localObject2).next();
              if ((localObject3 != null) && (!bt.isNullOrNil(((EmotionSummary)localObject3).ProductID)))
              {
                if (((EmotionSummary)localObject3).ProductID.equals(String.valueOf(EmojiGroupInfo.LBN)))
                {
                  ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                  continue;
                  HashMap localHashMap = localc.eNh();
                  ArrayList localArrayList1 = new ArrayList();
                  ArrayList localArrayList2 = new ArrayList();
                  int j = ((List)localObject3).size();
                  ad.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[] { Integer.valueOf(j) });
                  int i = 0;
                  while (i < j)
                  {
                    EmotionSummary localEmotionSummary = (EmotionSummary)((List)localObject3).get(i);
                    if ((localEmotionSummary == null) || (bt.isNullOrNil(localEmotionSummary.ProductID)))
                    {
                      ad.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                      i += 1;
                    }
                    else
                    {
                      ad.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[] { localEmotionSummary.ProductID });
                      localArrayList1.add(localEmotionSummary.ProductID);
                      if (localHashMap.containsKey(localEmotionSummary.ProductID))
                      {
                        localObject2 = (EmojiGroupInfo)localHashMap.get(localEmotionSummary.ProductID);
                        localObject1 = localObject2;
                        if (localObject2 == null) {
                          localObject1 = new EmojiGroupInfo();
                        }
                        ((EmojiGroupInfo)localObject1).field_productID = localEmotionSummary.ProductID;
                        label450:
                        if (!localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                          break label923;
                        }
                        ((EmojiGroupInfo)localObject1).field_flag = 0;
                        ((EmojiGroupInfo)localObject1).field_packName = "emoji_custom_all";
                        ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.TYPE_SYSTEM;
                        label484:
                        ((EmojiGroupInfo)localObject1).field_packIconUrl = localEmotionSummary.IconUrl;
                        ((EmojiGroupInfo)localObject1).field_packGrayIconUrl = localEmotionSummary.PanelUrl;
                        ((EmojiGroupInfo)localObject1).field_packCoverUrl = localEmotionSummary.CoverUrl;
                        ((EmojiGroupInfo)localObject1).field_packDesc = localEmotionSummary.PackDesc;
                        ((EmojiGroupInfo)localObject1).field_packAuthInfo = localEmotionSummary.PackAuthInfo;
                        ((EmojiGroupInfo)localObject1).field_packPrice = localEmotionSummary.PackPrice;
                        ((EmojiGroupInfo)localObject1).field_packType = localEmotionSummary.PackType;
                        ((EmojiGroupInfo)localObject1).field_packFlag = localEmotionSummary.PackFlag;
                        ((EmojiGroupInfo)localObject1).field_packExpire = localEmotionSummary.PackExpire;
                        ((EmojiGroupInfo)localObject1).field_packTimeStamp = localEmotionSummary.Timestamp;
                        ((EmojiGroupInfo)localObject1).field_sort = 1;
                        ((EmojiGroupInfo)localObject1).field_idx = i;
                        if (((EmojiGroupInfo)localObject1).field_sync == 0) {
                          if ((((EmojiGroupInfo)localObject1).field_status != 7) || (((EmojiGroupInfo)localObject1).field_packStatus != 1)) {
                            break label944;
                          }
                        }
                      }
                      label923:
                      label944:
                      for (((EmojiGroupInfo)localObject1).field_sync = 2;; ((EmojiGroupInfo)localObject1).field_sync = 1)
                      {
                        if (((EmojiGroupInfo)localObject1).field_sync == 2) {
                          ((EmojiGroupInfo)localObject1).field_status = 7;
                        }
                        if ((((EmojiGroupInfo)localObject1).field_sync == 2) && (!localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")))
                        {
                          localObject2 = localEmotionSummary.ProductID;
                          boolean bool2 = false;
                          boolean bool1 = bool2;
                          if (!bt.isNullOrNil((String)localObject2))
                          {
                            localObject2 = aw.eLx().FyY.aJz((String)localObject2);
                            bool1 = bool2;
                            if (localObject2 != null)
                            {
                              bool1 = bool2;
                              if (((EmojiInfo)localObject2).fZM())
                              {
                                bool1 = com.tencent.mm.emoji.decode.a.aaP().b((EmojiInfo)localObject2);
                                if (!bool1) {
                                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(252L, 9L, 1L, false);
                                }
                              }
                            }
                          }
                          if (!bool1)
                          {
                            ad.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[] { localEmotionSummary.ProductID });
                            ((EmojiGroupInfo)localObject1).field_sync = 1;
                          }
                        }
                        ad.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[] { ((EmojiGroupInfo)localObject1).field_productID, Long.valueOf(((EmojiGroupInfo)localObject1).field_lastUseTime), Integer.valueOf(((EmojiGroupInfo)localObject1).field_sort) });
                        localc.replace((com.tencent.mm.sdk.e.c)localObject1);
                        break;
                        if (localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji"))
                        {
                          localObject2 = (EmojiGroupInfo)localHashMap.get(String.valueOf(EmojiGroupInfo.LBN));
                          localObject1 = localObject2;
                          if (localObject2 == null) {
                            localObject1 = new EmojiGroupInfo();
                          }
                          ((EmojiGroupInfo)localObject1).field_productID = String.valueOf(EmojiGroupInfo.LBN);
                          break label450;
                        }
                        localObject1 = new EmojiGroupInfo();
                        ((EmojiGroupInfo)localObject1).field_productID = localEmotionSummary.ProductID;
                        break label450;
                        ((EmojiGroupInfo)localObject1).field_packName = localEmotionSummary.PackName;
                        ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.LBK;
                        break label484;
                      }
                    }
                  }
                  localObject1 = localHashMap.values().iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (EmojiGroupInfo)((Iterator)localObject1).next();
                    if ((localObject2 != null) && (!bt.isNullOrNil(((EmojiGroupInfo)localObject2).field_productID)) && (!((EmojiGroupInfo)localObject2).field_productID.equals(String.valueOf(EmojiGroupInfo.LBO)))) {
                      if (((EmojiGroupInfo)localObject2).field_productID.equals(String.valueOf(EmojiGroupInfo.LBN)))
                      {
                        if (!localArrayList1.contains("com.tencent.xin.emoticon.tusiji"))
                        {
                          ad.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { "com.tencent.xin.emoticon.tusiji" });
                          localArrayList2.add("com.tencent.xin.emoticon.tusiji");
                        }
                      }
                      else if (!localArrayList1.contains(((EmojiGroupInfo)localObject2).field_productID))
                      {
                        ad.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { ((EmojiGroupInfo)localObject2).field_productID });
                        localArrayList2.add(((EmojiGroupInfo)localObject2).field_productID);
                      }
                    }
                  }
                  if (localArrayList2.size() > 0)
                  {
                    localObject1 = localArrayList2.iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      localc.aJq((String)((Iterator)localObject1).next());
                    }
                  }
                  localc.doNotify("event_update_group", 0, bt.eGN().toString());
                  break;
                  localObject1 = localc.eNi().iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (EmojiGroupInfo)((Iterator)localObject1).next();
                    if (((EmojiGroupInfo)localObject2).field_sync > 0)
                    {
                      ad.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[] { ((EmojiGroupInfo)localObject2).field_productID });
                      localc.aJq(((EmojiGroupInfo)localObject2).field_productID);
                    }
                  }
                  localc.aJq("com.tencent.xin.emoticon.tusiji");
                  break;
                }
                ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b(((EmotionSummary)localObject3).ProductID, (byte)0));
              }
            }
            label1292:
            com.tencent.mm.plugin.emoji.model.k.bVa().L((ArrayList)localObject1);
            if (!com.tencent.mm.plugin.emoji.model.k.bVa().ozk.ozu) {
              com.tencent.mm.plugin.emoji.model.k.bVa().ozk.bVx();
            }
            AppMethodBeat.o(179057);
            return;
            label1327:
            Object localObject2 = (ArrayList)localc.eNr();
            if (((ArrayList)localObject2).size() > 0)
            {
              ad.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
              localObject1 = new ArrayList();
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (!bt.isNullOrNil((String)localObject3)) {
                  if (((String)localObject3).equals(String.valueOf(EmojiGroupInfo.LBN))) {
                    ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                  } else {
                    ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b((String)localObject3));
                  }
                }
              }
              com.tencent.mm.plugin.emoji.model.k.bVa().L((ArrayList)localObject1);
              if (!com.tencent.mm.plugin.emoji.model.k.bVa().ozk.ozu) {
                com.tencent.mm.plugin.emoji.model.k.bVa().ozk.bVx();
              }
            }
            label1493:
            AppMethodBeat.o(179057);
          }
        });
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgi, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else
    {
      if ((this.mType != 1) && (this.mType != 9)) {
        break label525;
      }
      paramq = d.bUR();
      paramArrayOfByte = bVs().EmotionExptConfig;
      if (!bt.kU(paramq.owR, paramArrayOfByte))
      {
        paramq.owR = paramArrayOfByte;
        paramq.bUS();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtK, paramArrayOfByte);
        com.tencent.mm.sdk.b.a.ESL.l(new dd());
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      if (paramInt3 == 2)
      {
        bVt();
        ((GetEmotionListRequest)((com.tencent.mm.al.b)paramq).gUS.gUX).ReqBuf = ((GetEmotionListResponse)((com.tencent.mm.al.b)paramq).gUT.gUX).ReqBuf;
        doScene(dispatcher(), this.callback);
        break;
      }
      if (paramInt3 != 3) {
        break;
      }
      if (this.oyU != null) {
        this.oyU.clear();
      }
      ((GetEmotionListRequest)((com.tencent.mm.al.b)paramq).gUS.gUX).ReqBuf = new SKBuiltinBuffer_t();
      doScene(dispatcher(), this.callback);
      break;
      label525:
      if (this.mType == 5)
      {
        paramq = d.bUR();
        paramArrayOfByte = bVs().EmotionExptConfig;
        if (!bt.kU(paramq.owQ, paramArrayOfByte))
        {
          paramq.owQ = paramArrayOfByte;
          paramq.bUS();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtL, paramArrayOfByte);
          com.tencent.mm.sdk.b.a.ESL.l(new dd());
        }
      }
    }
  }
  
  public int securityLimitCount()
  {
    return 100;
  }
  
  public n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.n
 * JD-Core Version:    0.7.0.1
 */