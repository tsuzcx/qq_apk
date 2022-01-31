package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.ay.b;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class n
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public byte[] liN;
  public int liP;
  private boolean liQ;
  private ArrayList<EmotionSummary> liR;
  private final int mScene;
  public final int mType;
  private final com.tencent.mm.ai.b rr;
  
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
    AppMethodBeat.i(53134);
    this.liQ = false;
    this.liR = new ArrayList();
    this.liN = null;
    b.a locala = new b.a();
    locala.fsX = new GetEmotionListRequest();
    locala.fsY = new GetEmotionListResponse();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionlist";
    locala.funcId = 411;
    locala.reqCmdId = 210;
    locala.respCmdId = 1000000210;
    this.rr = locala.ado();
    this.liN = paramArrayOfByte;
    this.mType = paramInt1;
    this.mScene = paramInt2;
    this.liQ = paramBoolean;
    AppMethodBeat.o(53134);
  }
  
  public static com.tencent.mm.plugin.emoji.model.e a(GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(53137);
    ab.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
    if (paramGetEmotionListResponse == null)
    {
      AppMethodBeat.o(53137);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.e locale = new com.tencent.mm.plugin.emoji.model.e();
    if (paramGetEmotionListResponse != null)
    {
      locale.lhk = paramGetEmotionListResponse.EmotionCount;
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
              if ((localObject2 != null) && (!bo.isNullOrNil(((EmotionSummary)localObject2).ProductID))) {
                ((List)localObject1).add(new com.tencent.mm.plugin.emoji.a.a.f((EmotionSummary)localObject2));
              }
            }
            i += 1;
          }
        }
      }
      locale.lhl = ((List)localObject1);
      locale.lhm = paramGetEmotionListResponse.Banner;
      locale.lhn = paramGetEmotionListResponse.NewBannerList;
      localObject1 = paramGetEmotionListResponse.CellSetList;
      if (locale.lhp == null)
      {
        locale.lhp = new LinkedList();
        locale.lhp.addAll((Collection)localObject1);
      }
      locale.lho = paramGetEmotionListResponse.BannerSetList;
    }
    AppMethodBeat.o(53137);
    return locale;
  }
  
  private void blI()
  {
    AppMethodBeat.i(53138);
    GetEmotionListResponse localGetEmotionListResponse = blH();
    if ((localGetEmotionListResponse != null) && (localGetEmotionListResponse.EmotionList != null) && (localGetEmotionListResponse.EmotionList.size() > 0))
    {
      this.liR.addAll(localGetEmotionListResponse.EmotionList);
      AppMethodBeat.o(53138);
      return;
    }
    ab.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
    AppMethodBeat.o(53138);
  }
  
  private void y(ArrayList<EmotionSummary> paramArrayList)
  {
    AppMethodBeat.i(53139);
    com.tencent.mm.storage.emotion.a locala = i.getEmojiStorageMgr().yNo;
    if (locala == null)
    {
      ab.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
      AppMethodBeat.o(53139);
      return;
    }
    long l2 = System.currentTimeMillis();
    Object localObject2;
    long l1;
    if ((locala.db instanceof h))
    {
      localObject2 = (h)locala.db;
      l1 = ((h)localObject2).kr(Thread.currentThread().getId());
      ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", new Object[] { Long.valueOf(l1) });
    }
    for (;;)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        if ((paramArrayList == null) || (paramArrayList.size() <= 0))
        {
          ab.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
          if (localObject2 != null)
          {
            ((h)localObject2).nY(l1);
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
          }
          ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l2).longValue()) });
          locala.doNotify("event_update_group", 0, bo.dtY().toString());
          if (!this.liQ) {
            break label1352;
          }
          if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
            break label1515;
          }
          ab.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[] { Integer.valueOf(paramArrayList.size()) });
          localObject1 = new ArrayList();
          paramArrayList = paramArrayList.iterator();
        }
      }
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label1317;
        }
        localObject2 = (EmotionSummary)paramArrayList.next();
        if ((localObject2 != null) && (!bo.isNullOrNil(((EmotionSummary)localObject2).ProductID)))
        {
          if (((EmotionSummary)localObject2).ProductID.equals(String.valueOf(EmojiGroupInfo.yPd)))
          {
            ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
            continue;
            HashMap localHashMap = locala.dyV();
            ArrayList localArrayList1 = new ArrayList();
            ArrayList localArrayList2 = new ArrayList();
            int j = paramArrayList.size();
            ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[] { Integer.valueOf(j) });
            int i = 0;
            Object localObject3;
            while (i < j)
            {
              EmotionSummary localEmotionSummary = (EmotionSummary)paramArrayList.get(i);
              if ((localEmotionSummary == null) || (bo.isNullOrNil(localEmotionSummary.ProductID)))
              {
                ab.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                i += 1;
              }
              else
              {
                ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[] { localEmotionSummary.ProductID });
                localArrayList1.add(localEmotionSummary.ProductID);
                if (localHashMap.containsKey(localEmotionSummary.ProductID))
                {
                  localObject3 = (EmojiGroupInfo)localHashMap.get(localEmotionSummary.ProductID);
                  localObject1 = localObject3;
                  if (localObject3 == null) {
                    localObject1 = new EmojiGroupInfo();
                  }
                  ((EmojiGroupInfo)localObject1).field_productID = localEmotionSummary.ProductID;
                  label505:
                  if (!localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                    break label943;
                  }
                  ((EmojiGroupInfo)localObject1).field_flag = 0;
                  ((EmojiGroupInfo)localObject1).field_packName = "emoji_custom_all";
                  ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.TYPE_SYSTEM;
                  label541:
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
                      break label964;
                    }
                  }
                }
                label943:
                label964:
                for (((EmojiGroupInfo)localObject1).field_sync = 2;; ((EmojiGroupInfo)localObject1).field_sync = 1)
                {
                  if (((EmojiGroupInfo)localObject1).field_sync == 2) {
                    ((EmojiGroupInfo)localObject1).field_status = 7;
                  }
                  if ((((EmojiGroupInfo)localObject1).field_sync == 2) && (!localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")))
                  {
                    localObject3 = new ay();
                    ((ay)localObject3).coq.type = 1;
                    ((ay)localObject3).coq.cot = localEmotionSummary.ProductID;
                    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
                    if (!((ay)localObject3).cor.cmX)
                    {
                      ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[] { localEmotionSummary.ProductID });
                      ((EmojiGroupInfo)localObject1).field_sync = 1;
                    }
                  }
                  ab.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[] { ((EmojiGroupInfo)localObject1).field_productID, Long.valueOf(((EmojiGroupInfo)localObject1).field_lastUseTime), Integer.valueOf(((EmojiGroupInfo)localObject1).field_sort) });
                  locala.replace((com.tencent.mm.sdk.e.c)localObject1);
                  break;
                  if (localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji"))
                  {
                    localObject3 = (EmojiGroupInfo)localHashMap.get(String.valueOf(EmojiGroupInfo.yPd));
                    localObject1 = localObject3;
                    if (localObject3 == null) {
                      localObject1 = new EmojiGroupInfo();
                    }
                    ((EmojiGroupInfo)localObject1).field_productID = String.valueOf(EmojiGroupInfo.yPd);
                    break label505;
                  }
                  localObject1 = new EmojiGroupInfo();
                  ((EmojiGroupInfo)localObject1).field_productID = localEmotionSummary.ProductID;
                  break label505;
                  ((EmojiGroupInfo)localObject1).field_packName = localEmotionSummary.PackName;
                  ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.yPa;
                  break label541;
                }
              }
            }
            localObject1 = localHashMap.values().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (EmojiGroupInfo)((Iterator)localObject1).next();
              if ((localObject3 != null) && (!bo.isNullOrNil(((EmojiGroupInfo)localObject3).field_productID)) && (!((EmojiGroupInfo)localObject3).field_productID.equals(String.valueOf(EmojiGroupInfo.yPe)))) {
                if (((EmojiGroupInfo)localObject3).field_productID.equals(String.valueOf(EmojiGroupInfo.yPd)))
                {
                  if (!localArrayList1.contains("com.tencent.xin.emoticon.tusiji"))
                  {
                    ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { "com.tencent.xin.emoticon.tusiji" });
                    localArrayList2.add("com.tencent.xin.emoticon.tusiji");
                  }
                }
                else if (!localArrayList1.contains(((EmojiGroupInfo)localObject3).field_productID))
                {
                  ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { ((EmojiGroupInfo)localObject3).field_productID });
                  localArrayList2.add(((EmojiGroupInfo)localObject3).field_productID);
                }
              }
            }
            if (localArrayList2.size() > 0)
            {
              localObject1 = localArrayList2.iterator();
              while (((Iterator)localObject1).hasNext()) {
                locala.asK((String)((Iterator)localObject1).next());
              }
            }
            locala.doNotify("event_update_group", 0, bo.dtY().toString());
            break;
            localObject1 = locala.dyW().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (EmojiGroupInfo)((Iterator)localObject1).next();
              if (((EmojiGroupInfo)localObject3).field_sync > 0)
              {
                ab.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[] { ((EmojiGroupInfo)localObject3).field_productID });
                locala.asK(((EmojiGroupInfo)localObject3).field_productID);
              }
            }
            locala.asK("com.tencent.xin.emoticon.tusiji");
            break;
          }
          ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.b(((EmotionSummary)localObject2).ProductID, (byte)0));
        }
      }
      label1317:
      i.blq().z((ArrayList)localObject1);
      if (!i.blq().lje.ljm) {
        i.blq().lje.blM();
      }
      AppMethodBeat.o(53139);
      return;
      label1352:
      Object localObject1 = (ArrayList)locala.dzf();
      if (((ArrayList)localObject1).size() > 0)
      {
        ab.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
        paramArrayList = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!bo.isNullOrNil((String)localObject2)) {
            if (((String)localObject2).equals(String.valueOf(EmojiGroupInfo.yPd))) {
              paramArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
            } else {
              paramArrayList.add(new com.tencent.mm.plugin.emoji.sync.a.b((String)localObject2));
            }
          }
        }
        i.blq().z(paramArrayList);
        if (!i.blq().lje.ljm) {
          i.blq().lje.blM();
        }
      }
      label1515:
      AppMethodBeat.o(53139);
      return;
      l1 = -1L;
      localObject2 = null;
    }
  }
  
  public final GetEmotionListResponse blH()
  {
    if (this.rr == null) {
      return null;
    }
    return (GetEmotionListResponse)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(53135);
    this.callback = paramf;
    GetEmotionListRequest localGetEmotionListRequest = (GetEmotionListRequest)this.rr.fsV.fta;
    if (this.liN != null)
    {
      localGetEmotionListRequest.ReqBuf = aa.ac(this.liN);
      if (localGetEmotionListRequest.ReqBuf != null) {
        break label133;
      }
    }
    label133:
    for (paramf = "Buf is NULL";; paramf = localGetEmotionListRequest.ReqBuf.toString())
    {
      ab.d("MicroMsg.emoji.NetSceneGetEmotionList", paramf);
      localGetEmotionListRequest.ReqType = this.mType;
      localGetEmotionListRequest.Scene = this.mScene;
      if (this.mType == 7) {
        localGetEmotionListRequest.Category = this.liP;
      }
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(53135);
      return i;
      localGetEmotionListRequest.ReqBuf = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public final int getType()
  {
    return 411;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53136);
    ab.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if (this.mType == 8)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        g.RL().Ru().set(ac.a.yxO, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else if (this.mType == 11)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label185;
      }
      g.RL().Ru().set(ac.a.yxS, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      i.getEmojiStorageMgr().yNq.a(this.mType, blH());
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break label214;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53136);
      return;
      g.RL().Ru().set(ac.a.yxO, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      break;
      label185:
      g.RL().Ru().set(ac.a.yxS, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    label214:
    paramArrayOfByte = (GetEmotionListResponse)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramArrayOfByte.ReqBuf != null) {
      this.liN = aa.a(paramArrayOfByte.ReqBuf);
    }
    if (this.mType == 8)
    {
      if (paramInt3 != 0) {
        break label401;
      }
      blI();
      y(this.liR);
      g.RL().Ru().set(ac.a.yxO, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      if ((this.mType == 1) || (this.mType == 5) || (this.mType == 9))
      {
        paramq = i.getEmojiStorageMgr();
        paramArrayOfByte = blH().EmotionExptConfig;
        if (!bo.isEqual(paramq.yNI, paramArrayOfByte))
        {
          paramq.yNI = paramArrayOfByte;
          g.RL().Ru().set(ac.a.yKz, paramArrayOfByte);
          com.tencent.mm.sdk.b.a.ymk.l(new cx());
        }
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53136);
      return;
      label401:
      if (paramInt3 == 2)
      {
        blI();
        ((GetEmotionListRequest)((com.tencent.mm.ai.b)paramq).fsV.fta).ReqBuf = ((GetEmotionListResponse)((com.tencent.mm.ai.b)paramq).fsW.fta).ReqBuf;
        doScene(dispatcher(), this.callback);
      }
      else if (paramInt3 == 3)
      {
        if (this.liR != null) {
          this.liR.clear();
        }
        ((GetEmotionListRequest)((com.tencent.mm.ai.b)paramq).fsV.fta).ReqBuf = new SKBuiltinBuffer_t();
        doScene(dispatcher(), this.callback);
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.n
 * JD-Core Version:    0.7.0.1
 */