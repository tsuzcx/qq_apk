package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a.b;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private final int mScene;
  public final int mType;
  public byte[] rcY;
  public int rda;
  boolean rdb;
  ArrayList<EmotionSummary> rdc;
  private final d rr;
  
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
    AppMethodBeat.i(108706);
    this.rdb = false;
    this.rdc = new ArrayList();
    this.rcY = null;
    d.a locala = new d.a();
    locala.iLN = new GetEmotionListRequest();
    locala.iLO = new GetEmotionListResponse();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionlist";
    locala.funcId = 411;
    locala.iLP = 210;
    locala.respCmdId = 1000000210;
    this.rr = locala.aXF();
    this.rcY = paramArrayOfByte;
    this.mType = paramInt1;
    this.mScene = paramInt2;
    this.rdb = paramBoolean;
    Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "NetSceneGetEmotionList: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(108706);
  }
  
  public static com.tencent.mm.plugin.emoji.model.g a(GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(108709);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
    if (paramGetEmotionListResponse == null)
    {
      AppMethodBeat.o(108709);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.g localg = new com.tencent.mm.plugin.emoji.model.g();
    if (paramGetEmotionListResponse != null)
    {
      localg.rbs = paramGetEmotionListResponse.EmotionCount;
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
              if ((localObject2 != null) && (!Util.isNullOrNil(((EmotionSummary)localObject2).ProductID))) {
                ((List)localObject1).add(new com.tencent.mm.plugin.emoji.a.a.f((EmotionSummary)localObject2));
              }
            }
            i += 1;
          }
        }
      }
      localg.rbt = ((List)localObject1);
      localg.rbu = paramGetEmotionListResponse.Banner;
      localg.rbv = paramGetEmotionListResponse.NewBannerList;
      localObject1 = paramGetEmotionListResponse.CellSetList;
      if (localg.rbx == null)
      {
        localg.rbx = new LinkedList();
        localg.rbx.addAll((Collection)localObject1);
      }
      localg.rbw = paramGetEmotionListResponse.BannerSetList;
    }
    AppMethodBeat.o(108709);
    return localg;
  }
  
  private void cGy()
  {
    AppMethodBeat.i(108710);
    GetEmotionListResponse localGetEmotionListResponse = cGx();
    if ((localGetEmotionListResponse != null) && (localGetEmotionListResponse.EmotionList != null) && (localGetEmotionListResponse.EmotionList.size() > 0))
    {
      this.rdc.addAll(localGetEmotionListResponse.EmotionList);
      AppMethodBeat.o(108710);
      return;
    }
    Log.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
    AppMethodBeat.o(108710);
  }
  
  public final GetEmotionListResponse cGx()
  {
    if (this.rr == null) {
      return null;
    }
    return (GetEmotionListResponse)this.rr.iLL.iLR;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(108707);
    this.callback = parami;
    GetEmotionListRequest localGetEmotionListRequest = (GetEmotionListRequest)this.rr.iLK.iLR;
    if (this.rcY != null)
    {
      localGetEmotionListRequest.ReqBuf = z.aC(this.rcY);
      if (localGetEmotionListRequest.ReqBuf != null) {
        break label131;
      }
    }
    label131:
    for (parami = "Buf is NULL";; parami = localGetEmotionListRequest.ReqBuf.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetEmotionList", parami);
      localGetEmotionListRequest.ReqType = this.mType;
      localGetEmotionListRequest.Scene = this.mScene;
      if (this.mType == 7) {
        localGetEmotionListRequest.Category = this.rda;
      }
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108707);
      return i;
      localGetEmotionListRequest.ReqBuf = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public final int getType()
  {
    return 411;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108708);
    Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if (this.mType == 8)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSJ, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else if (this.mType == 11)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label185;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSN, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      k.getEmojiStorageMgr().OpQ.a(this.mType, cGx());
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break label214;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSJ, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      break;
      label185:
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSN, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    label214:
    paramArrayOfByte = (GetEmotionListResponse)((d)params).iLL.iLR;
    if (paramArrayOfByte.ReqBuf != null) {
      this.rcY = z.a(paramArrayOfByte.ReqBuf);
    }
    if (this.mType == 8)
    {
      if (paramInt3 == 0)
      {
        cGy();
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179057);
            o localo = o.this;
            Object localObject3 = o.this.rdc;
            Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList: %s", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()) });
            c localc = k.getEmojiStorageMgr().OpO;
            if (localc == null)
            {
              Log.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
              AppMethodBeat.o(179057);
              return;
            }
            long l = System.currentTimeMillis();
            Object localObject1;
            if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
              if ((localObject3 == null) || (((List)localObject3).size() <= 0))
              {
                Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
                Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
                localc.doNotify("event_update_group", 0, Util.getStack().toString());
                if (!localo.rdb) {
                  break label1349;
                }
                if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
                  break label1515;
                }
                Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()) });
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
              if ((localObject3 != null) && (!Util.isNullOrNil(((EmotionSummary)localObject3).ProductID)))
              {
                if (((EmotionSummary)localObject3).ProductID.equals(String.valueOf(EmojiGroupInfo.Uum)))
                {
                  ((ArrayList)localObject1).add(new b("com.tencent.xin.emoticon.tusiji"));
                  continue;
                  HashMap localHashMap = localc.gEF();
                  ArrayList localArrayList1 = new ArrayList();
                  ArrayList localArrayList2 = new ArrayList();
                  int j = ((List)localObject3).size();
                  Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[] { Integer.valueOf(j) });
                  int i = 0;
                  while (i < j)
                  {
                    EmotionSummary localEmotionSummary = (EmotionSummary)((List)localObject3).get(i);
                    if ((localEmotionSummary == null) || (Util.isNullOrNil(localEmotionSummary.ProductID)))
                    {
                      Log.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                      i += 1;
                    }
                    else
                    {
                      Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[] { localEmotionSummary.ProductID });
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
                          if (!Util.isNullOrNil((String)localObject2))
                          {
                            localObject2 = bj.gCJ().OpN.blm((String)localObject2);
                            bool1 = bool2;
                            if (localObject2 != null)
                            {
                              bool1 = bool2;
                              if (((EmojiInfo)localObject2).hRx())
                              {
                                bool1 = com.tencent.mm.emoji.decode.a.aum().b((EmojiInfo)localObject2);
                                if (!bool1) {
                                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(252L, 9L, 1L, false);
                                }
                              }
                            }
                          }
                          if (!bool1)
                          {
                            Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[] { localEmotionSummary.ProductID });
                            ((EmojiGroupInfo)localObject1).field_sync = 1;
                          }
                        }
                        Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[] { ((EmojiGroupInfo)localObject1).field_productID, Long.valueOf(((EmojiGroupInfo)localObject1).field_lastUseTime), Integer.valueOf(((EmojiGroupInfo)localObject1).field_sort) });
                        localc.replace((IAutoDBItem)localObject1);
                        break;
                        if (localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji"))
                        {
                          localObject2 = (EmojiGroupInfo)localHashMap.get(String.valueOf(EmojiGroupInfo.Uum));
                          localObject1 = localObject2;
                          if (localObject2 == null) {
                            localObject1 = new EmojiGroupInfo();
                          }
                          ((EmojiGroupInfo)localObject1).field_productID = String.valueOf(EmojiGroupInfo.Uum);
                          break label472;
                        }
                        localObject1 = new EmojiGroupInfo();
                        ((EmojiGroupInfo)localObject1).field_productID = localEmotionSummary.ProductID;
                        break label472;
                        ((EmojiGroupInfo)localObject1).field_packName = localEmotionSummary.PackName;
                        ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.Uuj;
                        break label506;
                      }
                    }
                  }
                  localObject1 = localHashMap.values().iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (EmojiGroupInfo)((Iterator)localObject1).next();
                    if ((localObject2 != null) && (!Util.isNullOrNil(((EmojiGroupInfo)localObject2).field_productID)) && (!((EmojiGroupInfo)localObject2).field_productID.equals(String.valueOf(EmojiGroupInfo.Uun)))) {
                      if (((EmojiGroupInfo)localObject2).field_productID.equals(String.valueOf(EmojiGroupInfo.Uum)))
                      {
                        if (!localArrayList1.contains("com.tencent.xin.emoticon.tusiji"))
                        {
                          Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { "com.tencent.xin.emoticon.tusiji" });
                          localArrayList2.add("com.tencent.xin.emoticon.tusiji");
                        }
                      }
                      else if (!localArrayList1.contains(((EmojiGroupInfo)localObject2).field_productID))
                      {
                        Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { ((EmojiGroupInfo)localObject2).field_productID });
                        localArrayList2.add(((EmojiGroupInfo)localObject2).field_productID);
                      }
                    }
                  }
                  if (localArrayList2.size() > 0)
                  {
                    localObject1 = localArrayList2.iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      localc.blc((String)((Iterator)localObject1).next());
                    }
                  }
                  localc.doNotify("event_update_group", 0, Util.getStack().toString());
                  break;
                  localObject1 = localc.gEG().iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (EmojiGroupInfo)((Iterator)localObject1).next();
                    if (((EmojiGroupInfo)localObject2).field_sync > 0)
                    {
                      Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[] { ((EmojiGroupInfo)localObject2).field_productID });
                      localc.blc(((EmojiGroupInfo)localObject2).field_productID);
                    }
                  }
                  localc.blc("com.tencent.xin.emoticon.tusiji");
                  break;
                }
                ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a(((EmotionSummary)localObject3).ProductID, (byte)0));
              }
            }
            label1314:
            k.cGg().X((ArrayList)localObject1);
            if (!k.cGg().rds.rdC) {
              k.cGg().rds.cGC();
            }
            AppMethodBeat.o(179057);
            return;
            label1349:
            Object localObject2 = (ArrayList)localc.gEQ();
            if (((ArrayList)localObject2).size() > 0)
            {
              Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
              localObject1 = new ArrayList();
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (!Util.isNullOrNil((String)localObject3)) {
                  if (((String)localObject3).equals(String.valueOf(EmojiGroupInfo.Uum))) {
                    ((ArrayList)localObject1).add(new b("com.tencent.xin.emoticon.tusiji"));
                  } else {
                    ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a((String)localObject3));
                  }
                }
              }
              k.cGg().X((ArrayList)localObject1);
              if (!k.cGg().rds.rdC) {
                k.cGg().rds.cGC();
              }
            }
            label1515:
            AppMethodBeat.o(179057);
          }
        });
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSJ, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else
    {
      if ((this.mType != 1) && (this.mType != 9)) {
        break label525;
      }
      params = com.tencent.mm.plugin.emoji.model.e.cFX();
      paramArrayOfByte = cGx().EmotionExptConfig;
      if (!Util.isEqual(params.rbl, paramArrayOfByte))
      {
        params.rbl = paramArrayOfByte;
        params.cFY();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohf, paramArrayOfByte);
        EventCenter.instance.publish(new dl());
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      if (paramInt3 == 2)
      {
        cGy();
        ((GetEmotionListRequest)((d)params).iLK.iLR).ReqBuf = ((GetEmotionListResponse)((d)params).iLL.iLR).ReqBuf;
        doScene(dispatcher(), this.callback);
        break;
      }
      if (paramInt3 != 3) {
        break;
      }
      if (this.rdc != null) {
        this.rdc.clear();
      }
      ((GetEmotionListRequest)((d)params).iLK.iLR).ReqBuf = new SKBuiltinBuffer_t();
      doScene(dispatcher(), this.callback);
      break;
      label525:
      if (this.mType == 5)
      {
        params = com.tencent.mm.plugin.emoji.model.e.cFX();
        paramArrayOfByte = cGx().EmotionExptConfig;
        if (!Util.isEqual(params.rbk, paramArrayOfByte))
        {
          params.rbk = paramArrayOfByte;
          params.cFY();
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohg, paramArrayOfByte);
          EventCenter.instance.publish(new dl());
        }
      }
    }
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.o
 * JD-Core Version:    0.7.0.1
 */