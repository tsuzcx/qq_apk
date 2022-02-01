package com.tencent.mm.plugin.emoji.f;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.dh;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
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
  private com.tencent.mm.al.f callback;
  private final int mScene;
  public final int mType;
  public byte[] pGa;
  public int pGc;
  boolean pGd;
  ArrayList<EmotionSummary> pGe;
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
    this.pGd = false;
    this.pGe = new ArrayList();
    this.pGa = null;
    b.a locala = new b.a();
    locala.hNM = new GetEmotionListRequest();
    locala.hNN = new GetEmotionListResponse();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionlist";
    locala.funcId = 411;
    locala.hNO = 210;
    locala.respCmdId = 1000000210;
    this.rr = locala.aDC();
    this.pGa = paramArrayOfByte;
    this.mType = paramInt1;
    this.mScene = paramInt2;
    this.pGd = paramBoolean;
    ad.i("MicroMsg.emoji.NetSceneGetEmotionList", "NetSceneGetEmotionList: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
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
      localf.pEi = paramGetEmotionListResponse.EmotionCount;
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
      localf.pEj = ((List)localObject1);
      localf.pEk = paramGetEmotionListResponse.Banner;
      localf.pEl = paramGetEmotionListResponse.NewBannerList;
      localObject1 = paramGetEmotionListResponse.CellSetList;
      if (localf.pEn == null)
      {
        localf.pEn = new LinkedList();
        localf.pEn.addAll((Collection)localObject1);
      }
      localf.pEm = paramGetEmotionListResponse.BannerSetList;
    }
    AppMethodBeat.o(108709);
    return localf;
  }
  
  private void chk()
  {
    AppMethodBeat.i(108710);
    GetEmotionListResponse localGetEmotionListResponse = chj();
    if ((localGetEmotionListResponse != null) && (localGetEmotionListResponse.EmotionList != null) && (localGetEmotionListResponse.EmotionList.size() > 0))
    {
      this.pGe.addAll(localGetEmotionListResponse.EmotionList);
      AppMethodBeat.o(108710);
      return;
    }
    ad.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
    AppMethodBeat.o(108710);
  }
  
  public final GetEmotionListResponse chj()
  {
    if (this.rr == null) {
      return null;
    }
    return (GetEmotionListResponse)this.rr.hNL.hNQ;
  }
  
  public int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(108707);
    this.callback = paramf;
    GetEmotionListRequest localGetEmotionListRequest = (GetEmotionListRequest)this.rr.hNK.hNQ;
    if (this.pGa != null)
    {
      localGetEmotionListRequest.ReqBuf = z.al(this.pGa);
      if (localGetEmotionListRequest.ReqBuf != null) {
        break label131;
      }
    }
    label131:
    for (paramf = "Buf is NULL";; paramf = localGetEmotionListRequest.ReqBuf.toString())
    {
      ad.d("MicroMsg.emoji.NetSceneGetEmotionList", paramf);
      localGetEmotionListRequest.ReqType = this.mType;
      localGetEmotionListRequest.Scene = this.mScene;
      if (this.mType == 7) {
        localGetEmotionListRequest.Category = this.pGc;
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
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqp, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else if (this.mType == 11)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label185;
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqt, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILq.a(this.mType, chj());
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break label214;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqp, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      break;
      label185:
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqt, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    label214:
    paramArrayOfByte = (GetEmotionListResponse)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (paramArrayOfByte.ReqBuf != null) {
      this.pGa = z.a(paramArrayOfByte.ReqBuf);
    }
    if (this.mType == 8)
    {
      if (paramInt3 == 0)
      {
        chk();
        h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179057);
            n localn = n.this;
            Object localObject3 = n.this.pGe;
            ad.i("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList: %s", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()) });
            com.tencent.mm.storage.emotion.c localc = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILo;
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
                localc.doNotify("event_update_group", 0, bt.flS().toString());
                if (!localn.pGd) {
                  break label1349;
                }
                if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
                  break label1515;
                }
                ad.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()) });
                localObject1 = new ArrayList();
                localObject2 = ((ArrayList)localObject3).iterator();
              }
            }
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label1314;
              }
              localObject3 = (EmotionSummary)((Iterator)localObject2).next();
              if ((localObject3 != null) && (!bt.isNullOrNil(((EmotionSummary)localObject3).ProductID)))
              {
                if (((EmotionSummary)localObject3).ProductID.equals(String.valueOf(EmojiGroupInfo.OeK)))
                {
                  ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b("com.tencent.xin.emoticon.tusiji"));
                  continue;
                  HashMap localHashMap = localc.fsS();
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
                        label472:
                        if (!localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                          break label945;
                        }
                        ((EmojiGroupInfo)localObject1).field_flag = 0;
                        ((EmojiGroupInfo)localObject1).field_packName = "emoji_custom_all";
                        ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.TYPE_SYSTEM;
                        label506:
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
                            break label966;
                          }
                        }
                      }
                      label945:
                      label966:
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
                            localObject2 = bd.frc().ILn.aUM((String)localObject2);
                            bool1 = bool2;
                            if (localObject2 != null)
                            {
                              bool1 = bool2;
                              if (((EmojiInfo)localObject2).fOu())
                              {
                                bool1 = com.tencent.mm.emoji.decode.a.aes().b((EmojiInfo)localObject2);
                                if (!bool1) {
                                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(252L, 9L, 1L, false);
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
                          localObject2 = (EmojiGroupInfo)localHashMap.get(String.valueOf(EmojiGroupInfo.OeK));
                          localObject1 = localObject2;
                          if (localObject2 == null) {
                            localObject1 = new EmojiGroupInfo();
                          }
                          ((EmojiGroupInfo)localObject1).field_productID = String.valueOf(EmojiGroupInfo.OeK);
                          break label472;
                        }
                        localObject1 = new EmojiGroupInfo();
                        ((EmojiGroupInfo)localObject1).field_productID = localEmotionSummary.ProductID;
                        break label472;
                        ((EmojiGroupInfo)localObject1).field_packName = localEmotionSummary.PackName;
                        ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.OeH;
                        break label506;
                      }
                    }
                  }
                  localObject1 = localHashMap.values().iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (EmojiGroupInfo)((Iterator)localObject1).next();
                    if ((localObject2 != null) && (!bt.isNullOrNil(((EmojiGroupInfo)localObject2).field_productID)) && (!((EmojiGroupInfo)localObject2).field_productID.equals(String.valueOf(EmojiGroupInfo.OeL)))) {
                      if (((EmojiGroupInfo)localObject2).field_productID.equals(String.valueOf(EmojiGroupInfo.OeK)))
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
                      localc.aUD((String)((Iterator)localObject1).next());
                    }
                  }
                  localc.doNotify("event_update_group", 0, bt.flS().toString());
                  break;
                  localObject1 = localc.fsT().iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (EmojiGroupInfo)((Iterator)localObject1).next();
                    if (((EmojiGroupInfo)localObject2).field_sync > 0)
                    {
                      ad.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[] { ((EmojiGroupInfo)localObject2).field_productID });
                      localc.aUD(((EmojiGroupInfo)localObject2).field_productID);
                    }
                  }
                  localc.aUD("com.tencent.xin.emoticon.tusiji");
                  break;
                }
                ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a(((EmotionSummary)localObject3).ProductID, (byte)0));
              }
            }
            label1314:
            com.tencent.mm.plugin.emoji.model.k.cgR().Q((ArrayList)localObject1);
            if (!com.tencent.mm.plugin.emoji.model.k.cgR().pGu.pGE) {
              com.tencent.mm.plugin.emoji.model.k.cgR().pGu.cho();
            }
            AppMethodBeat.o(179057);
            return;
            label1349:
            Object localObject2 = (ArrayList)localc.ftc();
            if (((ArrayList)localObject2).size() > 0)
            {
              ad.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
              localObject1 = new ArrayList();
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (!bt.isNullOrNil((String)localObject3)) {
                  if (((String)localObject3).equals(String.valueOf(EmojiGroupInfo.OeK))) {
                    ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b("com.tencent.xin.emoticon.tusiji"));
                  } else {
                    ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a((String)localObject3));
                  }
                }
              }
              com.tencent.mm.plugin.emoji.model.k.cgR().Q((ArrayList)localObject1);
              if (!com.tencent.mm.plugin.emoji.model.k.cgR().pGu.pGE) {
                com.tencent.mm.plugin.emoji.model.k.cgR().pGu.cho();
              }
            }
            label1515:
            AppMethodBeat.o(179057);
          }
        });
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqp, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else
    {
      if ((this.mType != 1) && (this.mType != 9)) {
        break label525;
      }
      paramq = d.cgI();
      paramArrayOfByte = chj().EmotionExptConfig;
      if (!bt.lQ(paramq.pEb, paramArrayOfByte))
      {
        paramq.pEb = paramArrayOfByte;
        paramq.cgJ();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEi, paramArrayOfByte);
        com.tencent.mm.sdk.b.a.IbL.l(new dh());
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      if (paramInt3 == 2)
      {
        chk();
        ((GetEmotionListRequest)((com.tencent.mm.al.b)paramq).hNK.hNQ).ReqBuf = ((GetEmotionListResponse)((com.tencent.mm.al.b)paramq).hNL.hNQ).ReqBuf;
        doScene(dispatcher(), this.callback);
        break;
      }
      if (paramInt3 != 3) {
        break;
      }
      if (this.pGe != null) {
        this.pGe.clear();
      }
      ((GetEmotionListRequest)((com.tencent.mm.al.b)paramq).hNK.hNQ).ReqBuf = new SKBuiltinBuffer_t();
      doScene(dispatcher(), this.callback);
      break;
      label525:
      if (this.mType == 5)
      {
        paramq = d.cgI();
        paramArrayOfByte = chj().EmotionExptConfig;
        if (!bt.lQ(paramq.pEa, paramArrayOfByte))
        {
          paramq.pEa = paramArrayOfByte;
          paramq.cgJ();
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEj, paramArrayOfByte);
          com.tencent.mm.sdk.b.a.IbL.l(new dh());
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
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.n
 * JD-Core Version:    0.7.0.1
 */