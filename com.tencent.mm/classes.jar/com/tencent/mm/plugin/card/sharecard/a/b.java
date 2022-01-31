package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
{
  private static boolean fpN = false;
  public static boolean kpI = false;
  public b.a kpH = null;
  private Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    kpI = false;
  }
  
  public static void HP(String paramString)
  {
    AppMethodBeat.i(87992);
    ab.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
      AppMethodBeat.o(87992);
      return;
    }
    d.post(new b.1(paramString, new ak(Looper.getMainLooper())), "updateShareUserInfo_thread");
    AppMethodBeat.o(87992);
  }
  
  public static String HQ(String paramString)
  {
    AppMethodBeat.i(88000);
    Map localMap = (Map)am.bci().getValue("key_share_card_annoucement_map");
    if (localMap == null)
    {
      AppMethodBeat.o(88000);
      return "";
    }
    paramString = (String)localMap.get(paramString);
    AppMethodBeat.o(88000);
    return paramString;
  }
  
  public static int HR(String paramString)
  {
    AppMethodBeat.i(88001);
    Map localMap = (Map)am.bci().getValue("key_share_card_count_map");
    if (localMap == null)
    {
      AppMethodBeat.o(88001);
      return 0;
    }
    paramString = (Integer)localMap.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(88001);
      return 0;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(88001);
    return i;
  }
  
  public static ArrayList<r> HS(String paramString)
  {
    AppMethodBeat.i(88003);
    Map localMap = (Map)am.bci().getValue("key_share_user_info_map");
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    paramString = (ArrayList)((Map)localObject).get(paramString);
    if (paramString == null)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(88003);
      return paramString;
    }
    AppMethodBeat.o(88003);
    return paramString;
  }
  
  public static boolean HT(String paramString)
  {
    AppMethodBeat.i(88008);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(88008);
      return false;
    }
    Object localObject2 = (ArrayList)am.bci().getValue("key_share_card_other_city_top_info_list");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (p)((Iterator)localObject1).next();
      if ((localObject2 != null) && (paramString.equals(((p)localObject2).kml)) && (((p)localObject2).top == 1))
      {
        AppMethodBeat.o(88008);
        return true;
      }
    }
    AppMethodBeat.o(88008);
    return false;
  }
  
  public static void HU(String paramString)
  {
    AppMethodBeat.i(88009);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(88009);
      return;
    }
    ArrayList localArrayList = (ArrayList)am.bci().getValue("key_share_card_other_city_top_info_list");
    if (localArrayList == null) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        p localp = (p)localArrayList.get(i);
        if ((localp != null) && (paramString.equals(localp.kml)) && (localp.top == 1))
        {
          localp.kqh = true;
          localArrayList.set(i, localp);
          am.bci().putValue("key_share_card_other_city_top_info_list", localArrayList);
          AppMethodBeat.o(88009);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(88009);
      return;
    }
  }
  
  private static void J(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(88004);
    Object localObject = (Map)am.bci().getValue("key_share_user_info_map");
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
          r localr = (r)localArrayList.get(i);
          if ((paramString3 != null) && (paramString3.equals(localr.kqi)))
          {
            localr.kql = false;
            localr.kqj -= 1;
            localr.kqk.remove(paramString1);
            localArrayList.set(i, localr);
          }
          i += 1;
        }
        ((Map)localObject).put(paramString2, localArrayList);
        am.bci().putValue("key_share_user_info_map", localObject);
        AppMethodBeat.o(88004);
        return;
      }
    }
  }
  
  private static String a(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(87991);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ab.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
      AppMethodBeat.o(87991);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if ((i < paramArrayList.size()) && (i < 2))
    {
      if (i != 0) {
        localStringBuilder.append("、");
      }
      String str1 = com.tencent.mm.model.s.nF((String)paramArrayList.get(i));
      String str2 = com.tencent.mm.model.s.nE((String)paramArrayList.get(i));
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
      ab.e("MicroMsg.ShareCardDataMgr", "context == null");
      AppMethodBeat.o(87991);
      return "";
    }
    if ((paramArrayList.size() == 1) || (paramArrayList.size() == 2))
    {
      paramContext = paramContext.getString(2131298048, new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(87991);
      return paramContext;
    }
    paramContext = paramContext.getString(2131298029, new Object[] { localStringBuilder.toString(), Integer.valueOf(paramArrayList.size()) });
    AppMethodBeat.o(87991);
    return paramContext;
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88014);
    ab.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
    ab.i("MicroMsg.ShareCardDataMgr", "card id:" + paramb.bbh() + " cardtpid:" + paramb.bbi());
    dq(paramb.bbh(), paramb.bbi());
    if (paramContext != null) {
      ac(paramContext, paramb.bbi());
    }
    J(paramb.bbh(), paramb.bbi(), paramb.bbj());
    HP(paramb.bbi());
    AppMethodBeat.o(88014);
  }
  
  private static void a(com.tencent.mm.plugin.card.sharecard.model.l paraml1, com.tencent.mm.plugin.card.sharecard.model.l paraml2, boolean paramBoolean)
  {
    AppMethodBeat.i(87988);
    if ((paraml1 == null) && (paraml2 == null))
    {
      ab.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
      AppMethodBeat.o(87988);
      return;
    }
    if ((paraml1 != null) && (paraml1.kpW == null) && (paraml1.kpV == null) && (paraml2 != null) && (paraml2.kpW == null) && (paraml2.kpV == null))
    {
      ab.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
      AppMethodBeat.o(87988);
      return;
    }
    ab.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
    Object localObject1 = (ArrayList)am.bci().getValue("key_share_card_local_city_category_info_list");
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = (ArrayList)am.bci().getValue("key_share_card_other_city_category_info_list");
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        int j = 0;
        if (paramBoolean)
        {
          am.bcl().tc(10);
          ((ArrayList)localObject1).clear();
          am.bcl().tc(0);
          localArrayList.clear();
          i = 0;
        }
        for (;;)
        {
          long l1 = System.currentTimeMillis();
          long l2 = g.RL().eHS.kr(Thread.currentThread().getId());
          Object localObject2;
          if ((paraml1 != null) && (paraml1.kpV != null) && (paraml1.kpV.size() > 0))
          {
            int k = 0;
            for (;;)
            {
              if (k < paraml1.kpV.size())
              {
                localObject2 = (m)paraml1.kpV.get(k);
                am.bcl().X(((m)localObject2).kml, 10, k + j);
                i locali = new i();
                locali.kml = ((m)localObject2).kml;
                locali.kpR = (k + j);
                ((ArrayList)localObject1).add(locali);
                k += 1;
                continue;
                j = i;
                if (paraml2 != null)
                {
                  j = i;
                  if (paraml2.kpV != null)
                  {
                    j = i;
                    if (paraml2.kpV.size() >= 0) {
                      j = paraml2.kpV.size();
                    }
                  }
                }
                if ((paraml2 == null) || (paraml2.kpW == null) || (paraml2.kpW.size() < 0)) {
                  break label681;
                }
                i = paraml2.kpW.size();
                break;
              }
            }
            if ((!paramBoolean) && (paraml2 != null) && (paraml2.kpV != null)) {
              paraml1.kpV.addAll(paraml2.kpV);
            }
          }
          for (;;)
          {
            am.bci().putValue("key_share_card_local_city_category_info_list", localObject1);
            if ((paraml1 == null) || (paraml1.kpW == null) || (paraml1.kpW.size() <= 0)) {
              break label651;
            }
            j = 0;
            while (j < paraml1.kpW.size())
            {
              localObject1 = (m)paraml1.kpW.get(j);
              am.bcl().X(((m)localObject1).kml, 0, j + i);
              localObject2 = new i();
              ((i)localObject2).kml = ((m)localObject1).kml;
              ((i)localObject2).kpR = (j + i);
              localArrayList.add(localObject2);
              j += 1;
            }
            if ((paraml1 != null) && (!paramBoolean) && (paraml2 != null) && (paraml2.kpV != null)) {
              paraml1.kpV = paraml2.kpV;
            }
          }
          if ((!paramBoolean) && (paraml2 != null) && (paraml2.kpW != null)) {
            paraml1.kpW.addAll(paraml2.kpW);
          }
          for (;;)
          {
            am.bci().putValue("key_share_card_other_city_category_info_list", localArrayList);
            g.RL().eHS.nY(l2);
            ab.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
            AppMethodBeat.o(87988);
            return;
            label651:
            if ((paraml1 != null) && (!paramBoolean) && (paraml2 != null) && (paraml2.kpW != null)) {
              paraml1.kpW = paraml2.kpW;
            }
          }
          label681:
          i = 0;
        }
      }
    }
  }
  
  private void a(com.tencent.mm.plugin.card.sharecard.model.l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(87987);
    if (paraml == null)
    {
      ab.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
      AppMethodBeat.o(87987);
      return;
    }
    ab.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
    Object localObject1 = (Map)am.bci().getValue("key_share_card_annoucement_map");
    if (localObject1 == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      Object localObject2 = (Map)am.bci().getValue("key_share_card_count_map");
      if (localObject2 == null) {
        localObject2 = new HashMap();
      }
      for (;;)
      {
        Object localObject3 = (Map)am.bci().getValue("key_share_card_username_map");
        if (localObject3 == null) {
          localObject3 = new HashMap();
        }
        for (;;)
        {
          ArrayList localArrayList1 = (ArrayList)am.bci().getValue("key_share_card_local_city_ids");
          if (localArrayList1 == null) {
            localArrayList1 = new ArrayList();
          }
          for (;;)
          {
            ArrayList localArrayList2 = (ArrayList)am.bci().getValue("key_share_card_other_city_ids");
            if (localArrayList2 == null) {
              localArrayList2 = new ArrayList();
            }
            for (;;)
            {
              ArrayList localArrayList3 = (ArrayList)am.bci().getValue("key_share_card_other_city_top_info_list");
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
                int j;
                Object localObject4;
                if ((paraml.kpV != null) && (paraml.kpV.size() > 0))
                {
                  i = 0;
                  if (i < paraml.kpV.size())
                  {
                    localm = (m)paraml.kpV.get(i);
                    if (!TextUtils.isEmpty(localm.kqd)) {
                      ((Map)localObject1).put(localm.kml, localm.kqd);
                    }
                    j = am.bcl().HW(localm.kml);
                    ((Map)localObject2).put(localm.kml, Integer.valueOf(j));
                    ((Map)localObject3).put(localm.kml, t(am.bcl().HV(localm.kml)));
                    if (!localArrayList4.contains(localm.kml))
                    {
                      localObject4 = am.bcl().HX(localm.kml);
                      if ((TextUtils.isEmpty((CharSequence)localObject4)) || (localArrayList1.contains(localObject4))) {
                        break label464;
                      }
                      localArrayList1.add(localObject4);
                    }
                    for (;;)
                    {
                      localArrayList4.add(localm.kml);
                      localObject4 = new p();
                      ((p)localObject4).kml = localm.kml;
                      ((p)localObject4).top = localm.top;
                      localArrayList3.add(localObject4);
                      i += 1;
                      break;
                      label464:
                      if (!localArrayList1.contains(localm.cHn)) {
                        localArrayList1.add(localm.cHn);
                      }
                    }
                  }
                }
                localArrayList4.clear();
                if ((paraml.kpW != null) && (paraml.kpW.size() > 0))
                {
                  i = 0;
                  if (i < paraml.kpW.size())
                  {
                    localm = (m)paraml.kpW.get(i);
                    if (!TextUtils.isEmpty(localm.kqd)) {
                      ((Map)localObject1).put(localm.kml, localm.kqd);
                    }
                    j = am.bcl().HW(localm.kml);
                    ((Map)localObject2).put(localm.kml, Integer.valueOf(j));
                    ((Map)localObject3).put(localm.kml, t(am.bcl().HV(localm.kml)));
                    if (!localArrayList4.contains(localm.kml))
                    {
                      localObject4 = am.bcl().HX(localm.kml);
                      if ((TextUtils.isEmpty((CharSequence)localObject4)) || (localArrayList2.contains(localObject4))) {
                        break label734;
                      }
                      localArrayList2.add(localObject4);
                    }
                    for (;;)
                    {
                      localArrayList4.add(localm.kml);
                      localObject4 = new p();
                      ((p)localObject4).kml = localm.kml;
                      ((p)localObject4).top = localm.top;
                      localArrayList3.add(localObject4);
                      i += 1;
                      break;
                      label734:
                      if (!localArrayList2.contains(localm.cHn)) {
                        localArrayList2.add(localm.cHn);
                      }
                    }
                  }
                }
                am.bci().putValue("key_share_card_annoucement_map", localObject1);
                am.bci().putValue("key_share_card_count_map", localObject2);
                am.bci().putValue("key_share_card_username_map", localObject3);
                am.bci().putValue("key_share_card_local_city", paraml.kpX);
                am.bci().putValue("key_share_card_local_city_ids", localArrayList1);
                am.bci().putValue("key_share_card_other_city_ids", localArrayList2);
                am.bci().putValue("key_share_card_other_city_top_info_list", localArrayList3);
                AppMethodBeat.o(87987);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public static void ac(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88006);
    ab.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:".concat(String.valueOf(paramString)));
    Object localObject1 = (Map)am.bci().getValue("key_share_card_count_map");
    if (localObject1 == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      Map localMap = (Map)am.bci().getValue("key_share_card_username_map");
      Object localObject2 = localMap;
      if (localMap == null) {
        localObject2 = new HashMap();
      }
      ((Map)localObject1).put(paramString, Integer.valueOf(am.bcl().HW(paramString)));
      ((Map)localObject2).put(paramString, a(paramContext, am.bcl().HV(paramString)));
      am.bci().putValue("key_share_card_count_map", localObject1);
      am.bci().putValue("key_share_card_username_map", localObject2);
      AppMethodBeat.o(88006);
      return;
    }
  }
  
  public static void bcA()
  {
    AppMethodBeat.i(87989);
    long l1 = System.currentTimeMillis();
    long l2 = g.RL().eHS.kr(Thread.currentThread().getId());
    ab.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
    Object localObject = (ArrayList)am.bci().getValue("key_share_card_local_city_category_info_list");
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = (ArrayList)am.bci().getValue("key_share_card_other_city_category_info_list");
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          i locali = (i)((ArrayList)localObject).get(i);
          am.bcl().X(locali.kml, 10, locali.kpR);
          i += 1;
        }
        i = 0;
        while (i < localArrayList.size())
        {
          localObject = (i)localArrayList.get(i);
          am.bcl().X(((i)localObject).kml, 0, ((i)localObject).kpR);
          i += 1;
        }
        g.RL().eHS.nY(l2);
        ab.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(87989);
        return;
      }
    }
  }
  
  public static int bcB()
  {
    AppMethodBeat.i(87997);
    if (bcD())
    {
      AppMethodBeat.o(87997);
      return 1;
    }
    if (bcC())
    {
      if (kpI)
      {
        AppMethodBeat.o(87997);
        return 3;
      }
      AppMethodBeat.o(87997);
      return 4;
    }
    AppMethodBeat.o(87997);
    return 0;
  }
  
  public static boolean bcC()
  {
    AppMethodBeat.i(87998);
    ArrayList localArrayList = (ArrayList)am.bci().getValue("key_share_card_other_city_ids");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      AppMethodBeat.o(87998);
      return true;
    }
    AppMethodBeat.o(87998);
    return false;
  }
  
  public static boolean bcD()
  {
    AppMethodBeat.i(87999);
    ArrayList localArrayList = (ArrayList)am.bci().getValue("key_share_card_local_city_ids");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      AppMethodBeat.o(87999);
      return true;
    }
    AppMethodBeat.o(87999);
    return false;
  }
  
  public static void bcE()
  {
    AppMethodBeat.i(88005);
    ab.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
    d.post(new b.2(), "delelteAllIllegalStatusCard");
    AppMethodBeat.o(88005);
  }
  
  public static boolean bcF()
  {
    AppMethodBeat.i(88011);
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.bci().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      AppMethodBeat.o(88011);
      return true;
    }
    boolean bool = locall.kpY;
    AppMethodBeat.o(88011);
    return bool;
  }
  
  public static boolean bcG()
  {
    AppMethodBeat.i(88012);
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.bci().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      AppMethodBeat.o(88012);
      return true;
    }
    boolean bool = locall.kpZ;
    AppMethodBeat.o(88012);
    return bool;
  }
  
  public static boolean bcH()
  {
    AppMethodBeat.i(88013);
    Object localObject = (Integer)g.RL().Ru().get(ac.a.yzj, Integer.valueOf(0));
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      AppMethodBeat.o(88013);
      return false;
    }
    g.RL().Ru().set(ac.a.yzj, Integer.valueOf(1));
    localObject = am.bcd().a(n.a.koa);
    if ((localObject != null) && (((Cursor)localObject).getCount() > 0))
    {
      ((Cursor)localObject).moveToFirst();
      if (!((Cursor)localObject).isAfterLast())
      {
        CardInfo localCardInfo = new CardInfo();
        localCardInfo.convertFrom((Cursor)localObject);
        if (localCardInfo.field_card_type == -1)
        {
          if (localCardInfo.bbd() != null) {
            break label147;
          }
          ab.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
        }
        for (;;)
        {
          ((Cursor)localObject).moveToNext();
          break;
          label147:
          localCardInfo.field_card_type = localCardInfo.bbd().iFL;
          if (!am.bcd().update(localCardInfo, new String[0])) {
            ab.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", new Object[] { localCardInfo.field_card_id });
          }
        }
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(88013);
      return true;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    ab.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
    AppMethodBeat.o(88013);
    return false;
  }
  
  public static int bcz()
  {
    int i = 0;
    AppMethodBeat.i(87985);
    Object localObject1 = am.bcd();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=0 OR status=5) AND card_type=10");
    localObject2 = "select count(*) from UserCardInfo" + ((StringBuilder)localObject2).toString();
    localObject1 = ((c)localObject1).db.a((String)localObject2, null, 2);
    if (localObject1 == null)
    {
      AppMethodBeat.o(87985);
      return 0;
    }
    if (((Cursor)localObject1).moveToFirst()) {
      i = ((Cursor)localObject1).getInt(0);
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(87985);
    return i;
  }
  
  public static void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87995);
    if (fpN)
    {
      ab.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
      AppMethodBeat.o(87995);
      return;
    }
    ab.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
    fpN = true;
    ArrayList localArrayList = sY(1);
    if ((localArrayList != null) && (localArrayList.contains(paramString1)))
    {
      localArrayList.remove(paramString1);
      String str = am.bcl().dt(paramString1, paramString2);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      am.bci().putValue("key_share_card_local_city_ids", localArrayList);
    }
    localArrayList = sY(2);
    if ((localArrayList != null) && (localArrayList.contains(paramString1)))
    {
      localArrayList.remove(paramString1);
      paramString1 = am.bcl().dt(paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString1)) {
        localArrayList.add(paramString1);
      }
      am.bci().putValue("key_share_card_other_city_ids", localArrayList);
    }
    fpN = false;
    AppMethodBeat.o(87995);
  }
  
  public static void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87996);
    ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + paramString1 + ", card_tp_id:" + paramString2);
    ArrayList localArrayList1 = sY(1);
    if ((localArrayList1 != null) && (localArrayList1.contains(paramString1)))
    {
      AppMethodBeat.o(87996);
      return;
    }
    ArrayList localArrayList2 = sY(2);
    if ((localArrayList2 != null) && (localArrayList2.contains(paramString1)))
    {
      AppMethodBeat.o(87996);
      return;
    }
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.bci().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      ab.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
      AppMethodBeat.o(87996);
      return;
    }
    int j = am.bcl().HW(paramString2);
    int k = HR(paramString2);
    ab.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + j + " cacheCount:" + k);
    int i;
    if ((locall.kpV != null) && (locall.kpV.size() > 0) && ((k <= 0) || (j == 1))) {
      i = 0;
    }
    while (i < locall.kpV.size())
    {
      m localm = (m)locall.kpV.get(i);
      if ((paramString2 != null) && (paramString2.contains(localm.kml)))
      {
        localArrayList1.add(paramString1);
        am.bci().putValue("key_share_card_local_city_ids", localArrayList1);
        ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(87996);
        return;
      }
      i += 1;
      continue;
      ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
    }
    if ((localArrayList2 != null) && ((k <= 0) || (j == 1)))
    {
      localArrayList2.add(paramString1);
      am.bci().putValue("key_share_card_other_city_ids", localArrayList2);
      ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(87996);
      return;
    }
    ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
    AppMethodBeat.o(87996);
  }
  
  public static String ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88010);
    ab.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
    if (paramString2 != null)
    {
      paramString2 = HS(paramString2);
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        paramString2 = (r)paramString2.get(0);
        if ((paramString2 != null) && (paramString2.kqk != null) && (paramString2.kqk.size() > 0) && (!paramString1.equals(paramString2.kqk.get(0))))
        {
          paramString1 = (String)paramString2.kqk.get(0);
          ab.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(88010);
      return paramString1;
      ab.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
      continue;
      ab.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
      continue;
      ab.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
    }
  }
  
  public static ArrayList<String> sY(int paramInt)
  {
    AppMethodBeat.i(87993);
    ArrayList localArrayList;
    if (paramInt == 1)
    {
      localArrayList = (ArrayList)am.bci().getValue("key_share_card_local_city_ids");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        ab.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(paramInt)));
        localArrayList = sZ(paramInt);
        AppMethodBeat.o(87993);
        return localArrayList;
      }
      AppMethodBeat.o(87993);
      return localArrayList;
    }
    if (paramInt == 2)
    {
      localArrayList = (ArrayList)am.bci().getValue("key_share_card_other_city_ids");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        ab.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(paramInt)));
        localArrayList = sZ(paramInt);
        AppMethodBeat.o(87993);
        return localArrayList;
      }
      AppMethodBeat.o(87993);
      return localArrayList;
    }
    AppMethodBeat.o(87993);
    return null;
  }
  
  private static ArrayList<String> sZ(int paramInt)
  {
    AppMethodBeat.i(87994);
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.bci().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      ab.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(87994);
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    m localm;
    String str;
    if (paramInt == 1)
    {
      if ((locall.kpV != null) && (locall.kpV.size() > 0))
      {
        paramInt = 0;
        if (paramInt < locall.kpV.size())
        {
          localm = (m)locall.kpV.get(paramInt);
          if (!localArrayList2.contains(localm.kml))
          {
            str = am.bcl().HX(localm.kml);
            if ((TextUtils.isEmpty(str)) || (localArrayList1.contains(str))) {
              break label176;
            }
            localArrayList1.add(str);
          }
          for (;;)
          {
            localArrayList2.add(localm.kml);
            paramInt += 1;
            break;
            label176:
            if (!localArrayList1.contains(localm.cHn)) {
              localArrayList1.add(localm.cHn);
            }
          }
        }
        am.bci().putValue("key_share_card_local_city_ids", localArrayList1);
      }
      AppMethodBeat.o(87994);
      return localArrayList1;
    }
    if (paramInt == 2)
    {
      if ((locall.kpW != null) && (locall.kpW.size() > 0))
      {
        paramInt = 0;
        if (paramInt < locall.kpW.size())
        {
          localm = (m)locall.kpW.get(paramInt);
          if (!localArrayList2.contains(localm.kml))
          {
            str = am.bcl().HX(localm.kml);
            if ((TextUtils.isEmpty(str)) || (localArrayList1.contains(str))) {
              break label333;
            }
            localArrayList1.add(str);
          }
          for (;;)
          {
            localArrayList2.add(localm.kml);
            paramInt += 1;
            break;
            label333:
            if (!localArrayList1.contains(localm.cHn)) {
              localArrayList1.add(localm.cHn);
            }
          }
        }
        am.bci().putValue("key_share_card_other_city_ids", localArrayList1);
      }
      AppMethodBeat.o(87994);
      return localArrayList1;
    }
    AppMethodBeat.o(87994);
    return null;
  }
  
  public static String so(String paramString)
  {
    AppMethodBeat.i(88002);
    Map localMap = (Map)am.bci().getValue("key_share_card_username_map");
    if (localMap == null)
    {
      AppMethodBeat.o(88002);
      return "";
    }
    paramString = (String)localMap.get(paramString);
    AppMethodBeat.o(88002);
    return paramString;
  }
  
  private String t(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(87990);
    paramArrayList = a(this.mContext, paramArrayList);
    AppMethodBeat.o(87990);
    return paramArrayList;
  }
  
  public static boolean ta(int paramInt)
  {
    AppMethodBeat.i(88007);
    Object localObject = (Integer)am.bci().getValue("key_share_card_show_type");
    if (localObject == null)
    {
      AppMethodBeat.o(88007);
      return false;
    }
    if (((Integer)localObject).intValue() == 0)
    {
      AppMethodBeat.o(88007);
      return false;
    }
    if (paramInt == 0)
    {
      localObject = (ArrayList)am.bci().getValue("key_share_card_other_city_ids");
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(88007);
        return false;
      }
      AppMethodBeat.o(88007);
      return true;
    }
    if (paramInt == 10)
    {
      localObject = (ArrayList)am.bci().getValue("key_share_card_local_city_ids");
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(88007);
        return false;
      }
      AppMethodBeat.o(88007);
      return true;
    }
    AppMethodBeat.o(88007);
    return false;
  }
  
  public final void ay(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(87986);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
      AppMethodBeat.o(87986);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.plugin.card.d.s.IK(paramString);
    Object localObject2 = (com.tencent.mm.plugin.card.sharecard.model.l)am.bci().getValue("key_share_card_layout_data");
    if (localObject1 == null)
    {
      ab.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
      a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, (com.tencent.mm.plugin.card.sharecard.model.l)localObject2, paramBoolean);
      am.bci().putValue("key_share_card_layout_data", localObject1);
      AppMethodBeat.o(87986);
      return;
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.IC(paramString);
    }
    a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, paramBoolean);
    a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, (com.tencent.mm.plugin.card.sharecard.model.l)localObject2, paramBoolean);
    am.bci().putValue("key_share_card_layout_data", localObject1);
    int j = 0;
    int i = j;
    if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).kpV != null)
    {
      i = j;
      if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).kpV.size() > 0) {
        i = ((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).kpV.size();
      }
    }
    j = i;
    if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).kpW != null)
    {
      j = i;
      if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).kpW.size() > 0) {
        j = i + ((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).kpW.size();
      }
    }
    if (j > 0)
    {
      i = (int)(System.currentTimeMillis() - l);
      paramString = new ArrayList();
      localObject1 = new IDKey();
      ((IDKey)localObject1).SetID(281);
      ((IDKey)localObject1).SetKey(10);
      ((IDKey)localObject1).SetValue(1L);
      localObject2 = new IDKey();
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
      com.tencent.mm.plugin.report.service.h.qsU.b(paramString, true);
    }
    AppMethodBeat.o(87986);
  }
  
  public final void init()
  {
    AppMethodBeat.i(87984);
    if ((com.tencent.mm.plugin.card.sharecard.model.l)am.bci().getValue("key_share_card_layout_data") == null)
    {
      ab.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
      Object localObject = com.tencent.mm.plugin.card.d.l.bfD();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ab.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
        AppMethodBeat.o(87984);
        return;
      }
      localObject = com.tencent.mm.plugin.card.d.s.IK((String)localObject);
      if (localObject != null)
      {
        ab.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
        am.bci().putValue("key_share_card_layout_data", localObject);
        a((com.tencent.mm.plugin.card.sharecard.model.l)localObject, true);
        AppMethodBeat.o(87984);
        return;
      }
      ab.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
      AppMethodBeat.o(87984);
      return;
    }
    ab.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
    AppMethodBeat.o(87984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.b
 * JD-Core Version:    0.7.0.1
 */