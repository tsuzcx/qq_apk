package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class n$1
  implements Runnable
{
  n$1(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(179057);
    n localn = this.pMJ;
    Object localObject3 = this.pMJ.pMI;
    ae.i("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList: %s", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()) });
    com.tencent.mm.storage.emotion.c localc = k.getEmojiStorageMgr().JfV;
    if (localc == null)
    {
      ae.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
      AppMethodBeat.o(179057);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1;
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
      if ((localObject3 == null) || (((List)localObject3).size() <= 0))
      {
        ae.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
        ae.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
        localc.doNotify("event_update_group", 0, bu.fpN().toString());
        if (!localn.pMH) {
          break label1349;
        }
        if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
          break label1515;
        }
        ae.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()) });
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
      if ((localObject3 != null) && (!bu.isNullOrNil(((EmotionSummary)localObject3).ProductID)))
      {
        if (((EmotionSummary)localObject3).ProductID.equals(String.valueOf(EmojiGroupInfo.OzR)))
        {
          ((ArrayList)localObject1).add(new b("com.tencent.xin.emoticon.tusiji"));
          continue;
          HashMap localHashMap = localc.fwT();
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          int j = ((List)localObject3).size();
          ae.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", new Object[] { Integer.valueOf(j) });
          int i = 0;
          while (i < j)
          {
            EmotionSummary localEmotionSummary = (EmotionSummary)((List)localObject3).get(i);
            if ((localEmotionSummary == null) || (bu.isNullOrNil(localEmotionSummary.ProductID)))
            {
              ae.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
              i += 1;
            }
            else
            {
              ae.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", new Object[] { localEmotionSummary.ProductID });
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
                  if (!bu.isNullOrNil((String)localObject2))
                  {
                    localObject2 = be.fvc().JfU.aWn((String)localObject2);
                    bool1 = bool2;
                    if (localObject2 != null)
                    {
                      bool1 = bool2;
                      if (((EmojiInfo)localObject2).fxn())
                      {
                        bool1 = com.tencent.mm.emoji.decode.a.aeE().b((EmojiInfo)localObject2);
                        if (!bool1) {
                          g.yxI.idkeyStat(252L, 9L, 1L, false);
                        }
                      }
                    }
                  }
                  if (!bool1)
                  {
                    ae.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", new Object[] { localEmotionSummary.ProductID });
                    ((EmojiGroupInfo)localObject1).field_sync = 1;
                  }
                }
                ae.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", new Object[] { ((EmojiGroupInfo)localObject1).field_productID, Long.valueOf(((EmojiGroupInfo)localObject1).field_lastUseTime), Integer.valueOf(((EmojiGroupInfo)localObject1).field_sort) });
                localc.replace((com.tencent.mm.sdk.e.c)localObject1);
                break;
                if (localEmotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji"))
                {
                  localObject2 = (EmojiGroupInfo)localHashMap.get(String.valueOf(EmojiGroupInfo.OzR));
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new EmojiGroupInfo();
                  }
                  ((EmojiGroupInfo)localObject1).field_productID = String.valueOf(EmojiGroupInfo.OzR);
                  break label472;
                }
                localObject1 = new EmojiGroupInfo();
                ((EmojiGroupInfo)localObject1).field_productID = localEmotionSummary.ProductID;
                break label472;
                ((EmojiGroupInfo)localObject1).field_packName = localEmotionSummary.PackName;
                ((EmojiGroupInfo)localObject1).field_type = EmojiGroupInfo.OzO;
                break label506;
              }
            }
          }
          localObject1 = localHashMap.values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (EmojiGroupInfo)((Iterator)localObject1).next();
            if ((localObject2 != null) && (!bu.isNullOrNil(((EmojiGroupInfo)localObject2).field_productID)) && (!((EmojiGroupInfo)localObject2).field_productID.equals(String.valueOf(EmojiGroupInfo.OzS)))) {
              if (((EmojiGroupInfo)localObject2).field_productID.equals(String.valueOf(EmojiGroupInfo.OzR)))
              {
                if (!localArrayList1.contains("com.tencent.xin.emoticon.tusiji"))
                {
                  ae.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { "com.tencent.xin.emoticon.tusiji" });
                  localArrayList2.add("com.tencent.xin.emoticon.tusiji");
                }
              }
              else if (!localArrayList1.contains(((EmojiGroupInfo)localObject2).field_productID))
              {
                ae.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", new Object[] { ((EmojiGroupInfo)localObject2).field_productID });
                localArrayList2.add(((EmojiGroupInfo)localObject2).field_productID);
              }
            }
          }
          if (localArrayList2.size() > 0)
          {
            localObject1 = localArrayList2.iterator();
            while (((Iterator)localObject1).hasNext()) {
              localc.aWe((String)((Iterator)localObject1).next());
            }
          }
          localc.doNotify("event_update_group", 0, bu.fpN().toString());
          break;
          localObject1 = localc.fwU().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (EmojiGroupInfo)((Iterator)localObject1).next();
            if (((EmojiGroupInfo)localObject2).field_sync > 0)
            {
              ae.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", new Object[] { ((EmojiGroupInfo)localObject2).field_productID });
              localc.aWe(((EmojiGroupInfo)localObject2).field_productID);
            }
          }
          localc.aWe("com.tencent.xin.emoticon.tusiji");
          break;
        }
        ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a(((EmotionSummary)localObject3).ProductID, (byte)0));
      }
    }
    label1314:
    k.cih().Q((ArrayList)localObject1);
    if (!k.cih().pMY.pNi) {
      k.cih().pMY.ciE();
    }
    AppMethodBeat.o(179057);
    return;
    label1349:
    Object localObject2 = (ArrayList)localc.fxd();
    if (((ArrayList)localObject2).size() > 0)
    {
      ae.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (!bu.isNullOrNil((String)localObject3)) {
          if (((String)localObject3).equals(String.valueOf(EmojiGroupInfo.OzR))) {
            ((ArrayList)localObject1).add(new b("com.tencent.xin.emoticon.tusiji"));
          } else {
            ((ArrayList)localObject1).add(new com.tencent.mm.plugin.emoji.sync.a.a((String)localObject3));
          }
        }
      }
      k.cih().Q((ArrayList)localObject1);
      if (!k.cih().pMY.pNi) {
        k.cih().pMY.ciE();
      }
    }
    label1515:
    AppMethodBeat.o(179057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.n.1
 * JD-Core Version:    0.7.0.1
 */