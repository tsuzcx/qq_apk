package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
{
  private static boolean dZI = false;
  public static boolean ioB = false;
  public b.a ioA = null;
  private Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    ioB = false;
  }
  
  private static void F(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = (Map)am.aAx().getValue("key_share_user_info_map");
    if (localObject == null) {
      localObject = new HashMap();
    }
    for (;;)
    {
      ArrayList localArrayList = (ArrayList)((Map)localObject).get(paramString2);
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < localArrayList.size())
        {
          com.tencent.mm.plugin.card.sharecard.model.r localr = (com.tencent.mm.plugin.card.sharecard.model.r)localArrayList.get(i);
          if ((paramString3 != null) && (paramString3.equals(localr.ipb)))
          {
            localr.ipd = false;
            localr.share_count -= 1;
            localr.ipc.remove(paramString1);
            localArrayList.set(i, localr);
          }
          i += 1;
        }
        ((Map)localObject).put(paramString2, localArrayList);
        am.aAx().putValue("key_share_user_info_map", localObject);
        return;
      }
    }
  }
  
  public static void Z(Context paramContext, String paramString)
  {
    y.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:" + paramString);
    Object localObject1 = (Map)am.aAx().getValue("key_share_card_count_map");
    if (localObject1 == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      Map localMap = (Map)am.aAx().getValue("key_share_card_username_map");
      Object localObject2 = localMap;
      if (localMap == null) {
        localObject2 = new HashMap();
      }
      ((Map)localObject1).put(paramString, Integer.valueOf(am.aAA().yv(paramString)));
      ((Map)localObject2).put(paramString, a(paramContext, am.aAA().yu(paramString)));
      am.aAx().putValue("key_share_card_count_map", localObject1);
      am.aAx().putValue("key_share_card_username_map", localObject2);
      return;
    }
  }
  
  private static String a(Context paramContext, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      y.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if ((i < paramArrayList.size()) && (i < 2))
    {
      if (i != 0) {
        localStringBuilder.append("、");
      }
      String str1 = com.tencent.mm.model.r.gW((String)paramArrayList.get(i));
      String str2 = com.tencent.mm.model.r.gV((String)paramArrayList.get(i));
      if (!TextUtils.isEmpty(str1)) {
        localStringBuilder.append(str1);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(str2);
      }
    }
    if (paramContext == null)
    {
      y.e("MicroMsg.ShareCardDataMgr", "context == null");
      return "";
    }
    if ((paramArrayList.size() == 1) || (paramArrayList.size() == 2)) {
      return paramContext.getString(a.g.card_share_card_users, new Object[] { localStringBuilder.toString() });
    }
    return paramContext.getString(a.g.card_share_card_list_more_users, new Object[] { localStringBuilder.toString(), Integer.valueOf(paramArrayList.size()) });
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.card.base.b paramb)
  {
    y.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
    y.i("MicroMsg.ShareCardDataMgr", "card id:" + paramb.azB() + " cardtpid:" + paramb.azC());
    ct(paramb.azB(), paramb.azC());
    if (paramContext != null) {
      Z(paramContext, paramb.azC());
    }
    F(paramb.azB(), paramb.azC(), paramb.azD());
    yo(paramb.azC());
  }
  
  private static void a(com.tencent.mm.plugin.card.sharecard.model.l paraml1, com.tencent.mm.plugin.card.sharecard.model.l paraml2, boolean paramBoolean)
  {
    if ((paraml1 == null) && (paraml2 == null))
    {
      y.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
      return;
    }
    if ((paraml1 != null) && (paraml1.ioP == null) && (paraml1.ioO == null) && (paraml2 != null) && (paraml2.ioP == null) && (paraml2.ioO == null))
    {
      y.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
      return;
    }
    y.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
    Object localObject1 = (ArrayList)am.aAx().getValue("key_share_card_local_city_category_info_list");
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = (ArrayList)am.aAx().getValue("key_share_card_other_city_category_info_list");
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        int j = 0;
        if (paramBoolean)
        {
          am.aAA().oS(10);
          ((ArrayList)localObject1).clear();
          am.aAA().oS(0);
          localArrayList.clear();
          i = 0;
        }
        for (;;)
        {
          long l1 = System.currentTimeMillis();
          long l2 = g.DP().dKu.eV(Thread.currentThread().getId());
          Object localObject2;
          if ((paraml1 != null) && (paraml1.ioO != null) && (paraml1.ioO.size() > 0))
          {
            int k = 0;
            for (;;)
            {
              if (k < paraml1.ioO.size())
              {
                localObject2 = (m)paraml1.ioO.get(k);
                am.aAA().J(((m)localObject2).iln, 10, k + j);
                i locali = new i();
                locali.iln = ((m)localObject2).iln;
                locali.item_index = (k + j);
                ((ArrayList)localObject1).add(locali);
                k += 1;
                continue;
                j = i;
                if (paraml2 != null)
                {
                  j = i;
                  if (paraml2.ioO != null)
                  {
                    j = i;
                    if (paraml2.ioO.size() >= 0) {
                      j = paraml2.ioO.size();
                    }
                  }
                }
                if ((paraml2 == null) || (paraml2.ioP == null) || (paraml2.ioP.size() < 0)) {
                  break label650;
                }
                i = paraml2.ioP.size();
                break;
              }
            }
            if ((!paramBoolean) && (paraml2 != null) && (paraml2.ioO != null)) {
              paraml1.ioO.addAll(paraml2.ioO);
            }
          }
          for (;;)
          {
            am.aAx().putValue("key_share_card_local_city_category_info_list", localObject1);
            if ((paraml1 == null) || (paraml1.ioP == null) || (paraml1.ioP.size() <= 0)) {
              break label620;
            }
            j = 0;
            while (j < paraml1.ioP.size())
            {
              localObject1 = (m)paraml1.ioP.get(j);
              am.aAA().J(((m)localObject1).iln, 0, j + i);
              localObject2 = new i();
              ((i)localObject2).iln = ((m)localObject1).iln;
              ((i)localObject2).item_index = (j + i);
              localArrayList.add(localObject2);
              j += 1;
            }
            if ((paraml1 != null) && (!paramBoolean) && (paraml2 != null) && (paraml2.ioO != null)) {
              paraml1.ioO = paraml2.ioO;
            }
          }
          if ((!paramBoolean) && (paraml2 != null) && (paraml2.ioP != null)) {
            paraml1.ioP.addAll(paraml2.ioP);
          }
          for (;;)
          {
            am.aAx().putValue("key_share_card_other_city_category_info_list", localArrayList);
            g.DP().dKu.hI(l2);
            y.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
            return;
            label620:
            if ((paraml1 != null) && (!paramBoolean) && (paraml2 != null) && (paraml2.ioP != null)) {
              paraml1.ioP = paraml2.ioP;
            }
          }
          label650:
          i = 0;
        }
      }
    }
  }
  
  private void a(com.tencent.mm.plugin.card.sharecard.model.l paraml, boolean paramBoolean)
  {
    int j = 0;
    if (paraml == null)
    {
      y.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
      return;
    }
    y.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
    Object localObject1 = (Map)am.aAx().getValue("key_share_card_annoucement_map");
    if (localObject1 == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      Object localObject2 = (Map)am.aAx().getValue("key_share_card_count_map");
      if (localObject2 == null) {
        localObject2 = new HashMap();
      }
      for (;;)
      {
        Object localObject3 = (Map)am.aAx().getValue("key_share_card_username_map");
        if (localObject3 == null) {
          localObject3 = new HashMap();
        }
        for (;;)
        {
          ArrayList localArrayList1 = (ArrayList)am.aAx().getValue("key_share_card_local_city_ids");
          if (localArrayList1 == null) {
            localArrayList1 = new ArrayList();
          }
          for (;;)
          {
            ArrayList localArrayList2 = (ArrayList)am.aAx().getValue("key_share_card_other_city_ids");
            if (localArrayList2 == null) {
              localArrayList2 = new ArrayList();
            }
            for (;;)
            {
              ArrayList localArrayList3 = (ArrayList)am.aAx().getValue("key_share_card_other_city_top_info_list");
              if (localArrayList3 == null) {
                localArrayList3 = new ArrayList();
              }
              for (;;)
              {
                if (paramBoolean)
                {
                  localArrayList1.clear();
                  localArrayList2.clear();
                  localArrayList3.clear();
                }
                ArrayList localArrayList4 = new ArrayList();
                int i;
                m localm;
                Object localObject4;
                if ((paraml.ioO != null) && (paraml.ioO.size() > 0))
                {
                  i = 0;
                  if (i < paraml.ioO.size())
                  {
                    localm = (m)paraml.ioO.get(i);
                    if (!TextUtils.isEmpty(localm.ioW)) {
                      ((Map)localObject1).put(localm.iln, localm.ioW);
                    }
                    int k = am.aAA().yv(localm.iln);
                    ((Map)localObject2).put(localm.iln, Integer.valueOf(k));
                    ((Map)localObject3).put(localm.iln, o(am.aAA().yu(localm.iln)));
                    if (!localArrayList4.contains(localm.iln))
                    {
                      localObject4 = am.aAA().yw(localm.iln);
                      if ((TextUtils.isEmpty((CharSequence)localObject4)) || (localArrayList1.contains(localObject4))) {
                        break label456;
                      }
                      localArrayList1.add(localObject4);
                    }
                    for (;;)
                    {
                      localArrayList4.add(localm.iln);
                      localObject4 = new p();
                      ((p)localObject4).iln = localm.iln;
                      ((p)localObject4).top = localm.top;
                      localArrayList3.add(localObject4);
                      i += 1;
                      break;
                      label456:
                      if (!localArrayList1.contains(localm.bZc)) {
                        localArrayList1.add(localm.bZc);
                      }
                    }
                  }
                }
                localArrayList4.clear();
                if ((paraml.ioP != null) && (paraml.ioP.size() > 0))
                {
                  i = j;
                  if (i < paraml.ioP.size())
                  {
                    localm = (m)paraml.ioP.get(i);
                    if (!TextUtils.isEmpty(localm.ioW)) {
                      ((Map)localObject1).put(localm.iln, localm.ioW);
                    }
                    j = am.aAA().yv(localm.iln);
                    ((Map)localObject2).put(localm.iln, Integer.valueOf(j));
                    ((Map)localObject3).put(localm.iln, o(am.aAA().yu(localm.iln)));
                    if (!localArrayList4.contains(localm.iln))
                    {
                      localObject4 = am.aAA().yw(localm.iln);
                      if ((TextUtils.isEmpty((CharSequence)localObject4)) || (localArrayList2.contains(localObject4))) {
                        break label727;
                      }
                      localArrayList2.add(localObject4);
                    }
                    for (;;)
                    {
                      localArrayList4.add(localm.iln);
                      localObject4 = new p();
                      ((p)localObject4).iln = localm.iln;
                      ((p)localObject4).top = localm.top;
                      localArrayList3.add(localObject4);
                      i += 1;
                      break;
                      label727:
                      if (!localArrayList2.contains(localm.bZc)) {
                        localArrayList2.add(localm.bZc);
                      }
                    }
                  }
                }
                am.aAx().putValue("key_share_card_annoucement_map", localObject1);
                am.aAx().putValue("key_share_card_count_map", localObject2);
                am.aAx().putValue("key_share_card_username_map", localObject3);
                am.aAx().putValue("key_share_card_local_city", paraml.ioQ);
                am.aAx().putValue("key_share_card_local_city_ids", localArrayList1);
                am.aAx().putValue("key_share_card_other_city_ids", localArrayList2);
                am.aAx().putValue("key_share_card_other_city_top_info_list", localArrayList3);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public static int aAO()
  {
    int i = 0;
    Object localObject1 = am.aAs();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=0 OR status=5) AND card_type=10");
    localObject2 = "select count(*) from UserCardInfo" + ((StringBuilder)localObject2).toString();
    localObject1 = ((c)localObject1).dXw.a((String)localObject2, null, 2);
    if (localObject1 == null) {
      return 0;
    }
    if (((Cursor)localObject1).moveToFirst()) {
      i = ((Cursor)localObject1).getInt(0);
    }
    ((Cursor)localObject1).close();
    return i;
  }
  
  public static void aAP()
  {
    long l1 = System.currentTimeMillis();
    long l2 = g.DP().dKu.eV(Thread.currentThread().getId());
    y.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
    Object localObject = (ArrayList)am.aAx().getValue("key_share_card_local_city_category_info_list");
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = (ArrayList)am.aAx().getValue("key_share_card_other_city_category_info_list");
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          i locali = (i)((ArrayList)localObject).get(i);
          am.aAA().J(locali.iln, 10, locali.item_index);
          i += 1;
        }
        i = 0;
        while (i < localArrayList.size())
        {
          localObject = (i)localArrayList.get(i);
          am.aAA().J(((i)localObject).iln, 0, ((i)localObject).item_index);
          i += 1;
        }
        g.DP().dKu.hI(l2);
        y.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        return;
      }
    }
  }
  
  public static int aAQ()
  {
    if (aAS()) {
      return 1;
    }
    if (aAR())
    {
      if (ioB) {
        return 3;
      }
      return 4;
    }
    return 0;
  }
  
  public static boolean aAR()
  {
    ArrayList localArrayList = (ArrayList)am.aAx().getValue("key_share_card_other_city_ids");
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public static boolean aAS()
  {
    ArrayList localArrayList = (ArrayList)am.aAx().getValue("key_share_card_local_city_ids");
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public static void aAT()
  {
    y.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
    com.tencent.mm.sdk.f.e.post(new b.2(), "delelteAllIllegalStatusCard");
  }
  
  public static boolean aAU()
  {
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.aAx().getValue("key_share_card_layout_data");
    if (locall == null) {
      return true;
    }
    return locall.ioR;
  }
  
  public static boolean aAV()
  {
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.aAx().getValue("key_share_card_layout_data");
    if (locall == null) {
      return true;
    }
    return locall.ioS;
  }
  
  public static void ct(String paramString1, String paramString2)
  {
    if (dZI)
    {
      y.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
      return;
    }
    y.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
    dZI = true;
    ArrayList localArrayList = oO(1);
    if ((localArrayList != null) && (localArrayList.contains(paramString1)))
    {
      localArrayList.remove(paramString1);
      String str = am.aAA().cw(paramString1, paramString2);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      am.aAx().putValue("key_share_card_local_city_ids", localArrayList);
    }
    localArrayList = oO(2);
    if ((localArrayList != null) && (localArrayList.contains(paramString1)))
    {
      localArrayList.remove(paramString1);
      paramString1 = am.aAA().cw(paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString1)) {
        localArrayList.add(paramString1);
      }
      am.aAx().putValue("key_share_card_other_city_ids", localArrayList);
    }
    dZI = false;
  }
  
  public static void cu(String paramString1, String paramString2)
  {
    y.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + paramString1 + ", card_tp_id:" + paramString2);
    ArrayList localArrayList1 = oO(1);
    if ((localArrayList1 != null) && (localArrayList1.contains(paramString1))) {}
    ArrayList localArrayList2;
    do
    {
      return;
      localArrayList2 = oO(2);
    } while ((localArrayList2 != null) && (localArrayList2.contains(paramString1)));
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.aAx().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      y.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
      return;
    }
    int j = am.aAA().yv(paramString2);
    int k = yq(paramString2);
    y.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + j + " cacheCount:" + k);
    int i;
    if ((locall.ioO != null) && (locall.ioO.size() > 0) && ((k <= 0) || (j == 1))) {
      i = 0;
    }
    while (i < locall.ioO.size())
    {
      m localm = (m)locall.ioO.get(i);
      if ((paramString2 != null) && (paramString2.contains(localm.iln)))
      {
        localArrayList1.add(paramString1);
        am.aAx().putValue("key_share_card_local_city_ids", localArrayList1);
        y.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is " + paramString1);
        return;
      }
      i += 1;
      continue;
      y.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
    }
    if ((localArrayList2 != null) && ((k <= 0) || (j == 1)))
    {
      localArrayList2.add(paramString1);
      am.aAx().putValue("key_share_card_other_city_ids", localArrayList2);
      y.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is " + paramString1);
      return;
    }
    y.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
  }
  
  public static String cv(String paramString1, String paramString2)
  {
    y.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
    if (paramString2 != null)
    {
      paramString2 = yr(paramString2);
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        paramString2 = (com.tencent.mm.plugin.card.sharecard.model.r)paramString2.get(0);
        if ((paramString2 != null) && (paramString2.ipc != null) && (paramString2.ipc.size() > 0) && (!paramString1.equals(paramString2.ipc.get(0))))
        {
          paramString1 = (String)paramString2.ipc.get(0);
          y.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
          return paramString1;
        }
        y.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
        return paramString1;
      }
      y.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
      return paramString1;
    }
    y.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
    return paramString1;
  }
  
  public static String ls(String paramString)
  {
    Map localMap = (Map)am.aAx().getValue("key_share_card_username_map");
    if (localMap == null) {
      return "";
    }
    return (String)localMap.get(paramString);
  }
  
  private String o(ArrayList<String> paramArrayList)
  {
    return a(this.mContext, paramArrayList);
  }
  
  public static ArrayList<String> oO(int paramInt)
  {
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    if (paramInt == 1)
    {
      localArrayList2 = (ArrayList)am.aAx().getValue("key_share_card_local_city_ids");
      if (localArrayList2 != null)
      {
        localArrayList1 = localArrayList2;
        if (localArrayList2.size() != 0) {}
      }
      else
      {
        y.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + paramInt);
        localArrayList1 = oP(paramInt);
      }
    }
    do
    {
      return localArrayList1;
      if (paramInt != 2) {
        break label118;
      }
      localArrayList2 = (ArrayList)am.aAx().getValue("key_share_card_other_city_ids");
      if (localArrayList2 == null) {
        break;
      }
      localArrayList1 = localArrayList2;
    } while (localArrayList2.size() != 0);
    y.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == " + paramInt);
    return oP(paramInt);
    label118:
    return null;
  }
  
  private static ArrayList<String> oP(int paramInt)
  {
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.aAx().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      y.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = " + paramInt);
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    m localm;
    String str;
    if (paramInt == 1)
    {
      if ((locall.ioO != null) && (locall.ioO.size() > 0))
      {
        paramInt = 0;
        if (paramInt < locall.ioO.size())
        {
          localm = (m)locall.ioO.get(paramInt);
          if (!localArrayList2.contains(localm.iln))
          {
            str = am.aAA().yw(localm.iln);
            if ((TextUtils.isEmpty(str)) || (localArrayList1.contains(str))) {
              break label171;
            }
            localArrayList1.add(str);
          }
          for (;;)
          {
            localArrayList2.add(localm.iln);
            paramInt += 1;
            break;
            label171:
            if (!localArrayList1.contains(localm.bZc)) {
              localArrayList1.add(localm.bZc);
            }
          }
        }
        am.aAx().putValue("key_share_card_local_city_ids", localArrayList1);
      }
      return localArrayList1;
    }
    if (paramInt == 2)
    {
      if ((locall.ioP != null) && (locall.ioP.size() > 0))
      {
        paramInt = 0;
        if (paramInt < locall.ioP.size())
        {
          localm = (m)locall.ioP.get(paramInt);
          if (!localArrayList2.contains(localm.iln))
          {
            str = am.aAA().yw(localm.iln);
            if ((TextUtils.isEmpty(str)) || (localArrayList1.contains(str))) {
              break label322;
            }
            localArrayList1.add(str);
          }
          for (;;)
          {
            localArrayList2.add(localm.iln);
            paramInt += 1;
            break;
            label322:
            if (!localArrayList1.contains(localm.bZc)) {
              localArrayList1.add(localm.bZc);
            }
          }
        }
        am.aAx().putValue("key_share_card_other_city_ids", localArrayList1);
      }
      return localArrayList1;
    }
    return null;
  }
  
  public static boolean oQ(int paramInt)
  {
    Object localObject = (Integer)am.aAx().getValue("key_share_card_show_type");
    if (localObject == null) {
      return false;
    }
    if (((Integer)localObject).intValue() == 0) {
      return false;
    }
    if (paramInt == 0)
    {
      localObject = (ArrayList)am.aAx().getValue("key_share_card_other_city_ids");
      return (localObject != null) && (((ArrayList)localObject).size() != 0);
    }
    if (paramInt == 10)
    {
      localObject = (ArrayList)am.aAx().getValue("key_share_card_local_city_ids");
      return (localObject != null) && (((ArrayList)localObject).size() != 0);
    }
    return false;
  }
  
  public static void yo(String paramString)
  {
    y.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
      return;
    }
    com.tencent.mm.sdk.f.e.post(new b.1(paramString, new ah(Looper.getMainLooper())), "updateShareUserInfo_thread");
  }
  
  public static String yp(String paramString)
  {
    Map localMap = (Map)am.aAx().getValue("key_share_card_annoucement_map");
    if (localMap == null) {
      return "";
    }
    return (String)localMap.get(paramString);
  }
  
  public static int yq(String paramString)
  {
    Map localMap = (Map)am.aAx().getValue("key_share_card_count_map");
    if (localMap == null) {
      return 0;
    }
    paramString = (Integer)localMap.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public static ArrayList<com.tencent.mm.plugin.card.sharecard.model.r> yr(String paramString)
  {
    Map localMap = (Map)am.aAx().getValue("key_share_user_info_map");
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    localObject = (ArrayList)((Map)localObject).get(paramString);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public static boolean ys(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = (ArrayList)am.aAx().getValue("key_share_card_other_city_top_info_list");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (p)((Iterator)localObject1).next();
      if ((localObject2 != null) && (paramString.equals(((p)localObject2).iln)) && (((p)localObject2).top == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public static void yt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList = (ArrayList)am.aAx().getValue("key_share_card_other_city_top_info_list");
    if (localArrayList == null) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        p localp = (p)localArrayList.get(i);
        if ((localp != null) && (paramString.equals(localp.iln)) && (localp.top == 1))
        {
          localp.ipa = true;
          localArrayList.set(i, localp);
          am.aAx().putValue("key_share_card_other_city_top_info_list", localArrayList);
          return;
        }
        i += 1;
      }
      break;
    }
  }
  
  public final void al(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      y.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
    }
    long l;
    int j;
    do
    {
      return;
      l = System.currentTimeMillis();
      localObject1 = s.zb(paramString);
      localObject2 = (com.tencent.mm.plugin.card.sharecard.model.l)am.aAx().getValue("key_share_card_layout_data");
      if (localObject1 == null)
      {
        y.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
        a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, (com.tencent.mm.plugin.card.sharecard.model.l)localObject2, paramBoolean);
        am.aAx().putValue("key_share_card_layout_data", localObject1);
        return;
      }
      if (paramBoolean) {
        com.tencent.mm.plugin.card.d.l.yT(paramString);
      }
      a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, paramBoolean);
      a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, (com.tencent.mm.plugin.card.sharecard.model.l)localObject2, paramBoolean);
      am.aAx().putValue("key_share_card_layout_data", localObject1);
      j = 0;
      i = j;
      if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).ioO != null)
      {
        i = j;
        if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).ioO.size() > 0) {
          i = ((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).ioO.size();
        }
      }
      j = i;
      if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).ioP != null)
      {
        j = i;
        if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).ioP.size() > 0) {
          j = i + ((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).ioP.size();
        }
      }
    } while (j <= 0);
    int i = (int)(System.currentTimeMillis() - l);
    paramString = new ArrayList();
    Object localObject1 = new IDKey();
    ((IDKey)localObject1).SetID(281);
    ((IDKey)localObject1).SetKey(10);
    ((IDKey)localObject1).SetValue(1L);
    Object localObject2 = new IDKey();
    ((IDKey)localObject2).SetID(281);
    ((IDKey)localObject2).SetKey(11);
    ((IDKey)localObject2).SetValue(i);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(281);
    localIDKey1.SetKey(12);
    localIDKey1.SetValue(j);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(281);
    localIDKey2.SetKey(14);
    localIDKey2.SetValue(i / j);
    paramString.add(localObject1);
    paramString.add(localObject2);
    paramString.add(localIDKey1);
    paramString.add(localIDKey2);
    com.tencent.mm.plugin.report.service.h.nFQ.b(paramString, true);
  }
  
  public final void init()
  {
    if ((com.tencent.mm.plugin.card.sharecard.model.l)am.aAx().getValue("key_share_card_layout_data") == null)
    {
      y.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
      Object localObject = com.tencent.mm.plugin.card.d.l.aDg();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        y.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
        return;
      }
      localObject = s.zb((String)localObject);
      if (localObject != null)
      {
        y.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
        am.aAx().putValue("key_share_card_layout_data", localObject);
        a((com.tencent.mm.plugin.card.sharecard.model.l)localObject, true);
        return;
      }
      y.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
      return;
    }
    y.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.b
 * JD-Core Version:    0.7.0.1
 */