package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.card.d.t;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
{
  private static boolean gnW = false;
  public static boolean oHY = false;
  private Context mContext;
  public b.a oHX = null;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    oHY = false;
  }
  
  public static ArrayList<String> AC(int paramInt)
  {
    AppMethodBeat.i(112932);
    ArrayList localArrayList;
    if (paramInt == 1)
    {
      localArrayList = (ArrayList)am.bWh().getValue("key_share_card_local_city_ids");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        ae.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(paramInt)));
        localArrayList = AD(paramInt);
        AppMethodBeat.o(112932);
        return localArrayList;
      }
      AppMethodBeat.o(112932);
      return localArrayList;
    }
    if (paramInt == 2)
    {
      localArrayList = (ArrayList)am.bWh().getValue("key_share_card_other_city_ids");
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        ae.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(paramInt)));
        localArrayList = AD(paramInt);
        AppMethodBeat.o(112932);
        return localArrayList;
      }
      AppMethodBeat.o(112932);
      return localArrayList;
    }
    AppMethodBeat.o(112932);
    return null;
  }
  
  private static ArrayList<String> AD(int paramInt)
  {
    AppMethodBeat.i(112933);
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.bWh().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      ae.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(112933);
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    m localm;
    String str;
    if (paramInt == 1)
    {
      if ((locall.oIl != null) && (locall.oIl.size() > 0))
      {
        paramInt = 0;
        if (paramInt < locall.oIl.size())
        {
          localm = (m)locall.oIl.get(paramInt);
          if (!localArrayList2.contains(localm.oEo))
          {
            str = am.bWk().Zt(localm.oEo);
            if ((TextUtils.isEmpty(str)) || (localArrayList1.contains(str))) {
              break label172;
            }
            localArrayList1.add(str);
          }
          for (;;)
          {
            localArrayList2.add(localm.oEo);
            paramInt += 1;
            break;
            label172:
            if (!localArrayList1.contains(localm.dJb)) {
              localArrayList1.add(localm.dJb);
            }
          }
        }
        am.bWh().putValue("key_share_card_local_city_ids", localArrayList1);
      }
      AppMethodBeat.o(112933);
      return localArrayList1;
    }
    if (paramInt == 2)
    {
      if ((locall.oIm != null) && (locall.oIm.size() > 0))
      {
        paramInt = 0;
        if (paramInt < locall.oIm.size())
        {
          localm = (m)locall.oIm.get(paramInt);
          if (!localArrayList2.contains(localm.oEo))
          {
            str = am.bWk().Zt(localm.oEo);
            if ((TextUtils.isEmpty(str)) || (localArrayList1.contains(str))) {
              break label327;
            }
            localArrayList1.add(str);
          }
          for (;;)
          {
            localArrayList2.add(localm.oEo);
            paramInt += 1;
            break;
            label327:
            if (!localArrayList1.contains(localm.dJb)) {
              localArrayList1.add(localm.dJb);
            }
          }
        }
        am.bWh().putValue("key_share_card_other_city_ids", localArrayList1);
      }
      AppMethodBeat.o(112933);
      return localArrayList1;
    }
    AppMethodBeat.o(112933);
    return null;
  }
  
  public static boolean AE(int paramInt)
  {
    AppMethodBeat.i(112946);
    Object localObject = (Integer)am.bWh().getValue("key_share_card_show_type");
    if (localObject == null)
    {
      AppMethodBeat.o(112946);
      return false;
    }
    if (((Integer)localObject).intValue() == 0)
    {
      AppMethodBeat.o(112946);
      return false;
    }
    if (paramInt == 0)
    {
      localObject = (ArrayList)am.bWh().getValue("key_share_card_other_city_ids");
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(112946);
        return false;
      }
      AppMethodBeat.o(112946);
      return true;
    }
    if (paramInt == 10)
    {
      localObject = (ArrayList)am.bWh().getValue("key_share_card_local_city_ids");
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        AppMethodBeat.o(112946);
        return false;
      }
      AppMethodBeat.o(112946);
      return true;
    }
    AppMethodBeat.o(112946);
    return false;
  }
  
  public static String ET(String paramString)
  {
    AppMethodBeat.i(112941);
    Map localMap = (Map)am.bWh().getValue("key_share_card_username_map");
    if (localMap == null)
    {
      AppMethodBeat.o(112941);
      return "";
    }
    paramString = (String)localMap.get(paramString);
    AppMethodBeat.o(112941);
    return paramString;
  }
  
  private String I(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(112929);
    paramArrayList = b(this.mContext, paramArrayList);
    AppMethodBeat.o(112929);
    return paramArrayList;
  }
  
  private static void P(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(112943);
    Object localObject = (Map)am.bWh().getValue("key_share_user_info_map");
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
          if ((paramString3 != null) && (paramString3.equals(localr.oIy)))
          {
            localr.oIB = false;
            localr.oIz -= 1;
            localr.oIA.remove(paramString1);
            localArrayList.set(i, localr);
          }
          i += 1;
        }
        ((Map)localObject).put(paramString2, localArrayList);
        am.bWh().putValue("key_share_user_info_map", localObject);
        AppMethodBeat.o(112943);
        return;
      }
    }
  }
  
  public static void Zl(String paramString)
  {
    AppMethodBeat.i(112931);
    ae.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
      AppMethodBeat.o(112931);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        Object localObject1 = null;
        AppMethodBeat.i(112921);
        ae.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
        Object localObject2 = am.bWk();
        Object localObject3 = this.oHZ;
        ae.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(" where ( status=0) ");
        ((StringBuilder)localObject4).append(" AND (card_tp_id = '" + (String)localObject3 + "' )");
        ((StringBuilder)localObject4).append(" order by share_time desc ");
        localObject3 = "select * from ShareCardInfo" + ((StringBuilder)localObject4).toString();
        localObject3 = ((k)localObject2).db.a((String)localObject3, null, 2);
        if (localObject3 == null)
        {
          ae.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
          ae.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            ae.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
            AppMethodBeat.o(112921);
          }
        }
        else
        {
          localObject2 = new ArrayList();
          localObject4 = new ArrayList();
        }
        label181:
        label445:
        label448:
        for (;;)
        {
          ShareCardInfo localShareCardInfo;
          int i;
          if (((Cursor)localObject3).moveToNext())
          {
            localShareCardInfo = new ShareCardInfo();
            localShareCardInfo.convertFrom((Cursor)localObject3);
            if (!((ArrayList)localObject4).contains(localShareCardInfo.field_from_username))
            {
              localObject1 = new r();
              ((r)localObject1).oEo = localShareCardInfo.field_card_tp_id;
              ((r)localObject1).oIy = localShareCardInfo.field_from_username;
              ((r)localObject1).oIA = new ArrayList();
              ((r)localObject1).oIA.add(localShareCardInfo.field_card_id);
              ((r)localObject1).oIz = 1;
              ((ArrayList)localObject2).add(localObject1);
              ((ArrayList)localObject4).add(localShareCardInfo.field_from_username);
              continue;
            }
            i = 0;
            localObject1 = null;
            if (i >= ((ArrayList)localObject2).size()) {
              break label445;
            }
            localObject1 = (r)((ArrayList)localObject2).get(i);
            if ((localShareCardInfo.field_from_username == null) || (!localShareCardInfo.field_from_username.equals(((r)localObject1).oIy))) {}
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label448;
            }
            ((r)localObject1).oIA.add(0, localShareCardInfo.field_card_id);
            ((r)localObject1).oIz += 1;
            ((ArrayList)localObject2).set(i, localObject1);
            break label181;
            i += 1;
            break label299;
            ((Cursor)localObject3).close();
            localObject1 = localObject2;
            break;
            if (((ArrayList)localObject1).get(0) != null) {
              ((r)((ArrayList)localObject1).get(0)).oIB = true;
            }
            ae.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
            this.oIa.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(112920);
                Map localMap = (Map)am.bWh().getValue("key_share_user_info_map");
                Object localObject = localMap;
                if (localMap == null) {
                  localObject = new HashMap();
                }
                ((Map)localObject).put(b.1.this.oHZ, this.oIb);
                am.bWh().putValue("key_share_user_info_map", localObject);
                AppMethodBeat.o(112920);
              }
            });
            AppMethodBeat.o(112921);
            return;
            i = 0;
          }
        }
      }
    }, "updateShareUserInfo_thread");
    AppMethodBeat.o(112931);
  }
  
  public static String Zm(String paramString)
  {
    AppMethodBeat.i(112939);
    Map localMap = (Map)am.bWh().getValue("key_share_card_annoucement_map");
    if (localMap == null)
    {
      AppMethodBeat.o(112939);
      return "";
    }
    paramString = (String)localMap.get(paramString);
    AppMethodBeat.o(112939);
    return paramString;
  }
  
  public static int Zn(String paramString)
  {
    AppMethodBeat.i(112940);
    Map localMap = (Map)am.bWh().getValue("key_share_card_count_map");
    if (localMap == null)
    {
      AppMethodBeat.o(112940);
      return 0;
    }
    paramString = (Integer)localMap.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(112940);
      return 0;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(112940);
    return i;
  }
  
  public static ArrayList<r> Zo(String paramString)
  {
    AppMethodBeat.i(112942);
    Map localMap = (Map)am.bWh().getValue("key_share_user_info_map");
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    paramString = (ArrayList)((Map)localObject).get(paramString);
    if (paramString == null)
    {
      paramString = new ArrayList();
      AppMethodBeat.o(112942);
      return paramString;
    }
    AppMethodBeat.o(112942);
    return paramString;
  }
  
  public static boolean Zp(String paramString)
  {
    AppMethodBeat.i(112947);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(112947);
      return false;
    }
    Object localObject2 = (ArrayList)am.bWh().getValue("key_share_card_other_city_top_info_list");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (p)((Iterator)localObject1).next();
      if ((localObject2 != null) && (paramString.equals(((p)localObject2).oEo)) && (((p)localObject2).top == 1))
      {
        AppMethodBeat.o(112947);
        return true;
      }
    }
    AppMethodBeat.o(112947);
    return false;
  }
  
  public static void Zq(String paramString)
  {
    AppMethodBeat.i(112948);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(112948);
      return;
    }
    ArrayList localArrayList = (ArrayList)am.bWh().getValue("key_share_card_other_city_top_info_list");
    if (localArrayList == null) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        p localp = (p)localArrayList.get(i);
        if ((localp != null) && (paramString.equals(localp.oEo)) && (localp.top == 1))
        {
          localp.oIx = true;
          localArrayList.set(i, localp);
          am.bWh().putValue("key_share_card_other_city_top_info_list", localArrayList);
          AppMethodBeat.o(112948);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(112948);
      return;
    }
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(112953);
    ae.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
    ae.i("MicroMsg.ShareCardDataMgr", "card id:" + paramb.bVg() + " cardtpid:" + paramb.bVh());
    fb(paramb.bVg(), paramb.bVh());
    if (paramContext != null) {
      ad(paramContext, paramb.bVh());
    }
    P(paramb.bVg(), paramb.bVh(), paramb.bVi());
    Zl(paramb.bVh());
    AppMethodBeat.o(112953);
  }
  
  private static void a(com.tencent.mm.plugin.card.sharecard.model.l paraml1, com.tencent.mm.plugin.card.sharecard.model.l paraml2, boolean paramBoolean)
  {
    AppMethodBeat.i(112927);
    if ((paraml1 == null) && (paraml2 == null))
    {
      ae.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
      AppMethodBeat.o(112927);
      return;
    }
    if ((paraml1 != null) && (paraml1.oIm == null) && (paraml1.oIl == null) && (paraml2 != null) && (paraml2.oIm == null) && (paraml2.oIl == null))
    {
      ae.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
      AppMethodBeat.o(112927);
      return;
    }
    ae.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
    Object localObject1 = (ArrayList)am.bWh().getValue("key_share_card_local_city_category_info_list");
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = (ArrayList)am.bWh().getValue("key_share_card_other_city_category_info_list");
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        int j = 0;
        if (paramBoolean)
        {
          am.bWk().AG(10);
          ((ArrayList)localObject1).clear();
          am.bWk().AG(0);
          localArrayList.clear();
          i = 0;
        }
        for (;;)
        {
          long l1 = System.currentTimeMillis();
          long l2 = com.tencent.mm.kernel.g.ajR().gDX.yi(Thread.currentThread().getId());
          Object localObject2;
          if ((paraml1 != null) && (paraml1.oIl != null) && (paraml1.oIl.size() > 0))
          {
            int k = 0;
            for (;;)
            {
              if (k < paraml1.oIl.size())
              {
                localObject2 = (m)paraml1.oIl.get(k);
                am.bWk().V(((m)localObject2).oEo, 10, k + j);
                i locali = new i();
                locali.oEo = ((m)localObject2).oEo;
                locali.oIh = (k + j);
                ((ArrayList)localObject1).add(locali);
                k += 1;
                continue;
                j = i;
                if (paraml2 != null)
                {
                  j = i;
                  if (paraml2.oIl != null)
                  {
                    j = i;
                    if (paraml2.oIl.size() >= 0) {
                      j = paraml2.oIl.size();
                    }
                  }
                }
                if ((paraml2 == null) || (paraml2.oIm == null) || (paraml2.oIm.size() < 0)) {
                  break label681;
                }
                i = paraml2.oIm.size();
                break;
              }
            }
            if ((!paramBoolean) && (paraml2 != null) && (paraml2.oIl != null)) {
              paraml1.oIl.addAll(paraml2.oIl);
            }
          }
          for (;;)
          {
            am.bWh().putValue("key_share_card_local_city_category_info_list", localObject1);
            if ((paraml1 == null) || (paraml1.oIm == null) || (paraml1.oIm.size() <= 0)) {
              break label651;
            }
            j = 0;
            while (j < paraml1.oIm.size())
            {
              localObject1 = (m)paraml1.oIm.get(j);
              am.bWk().V(((m)localObject1).oEo, 0, j + i);
              localObject2 = new i();
              ((i)localObject2).oEo = ((m)localObject1).oEo;
              ((i)localObject2).oIh = (j + i);
              localArrayList.add(localObject2);
              j += 1;
            }
            if ((paraml1 != null) && (!paramBoolean) && (paraml2 != null) && (paraml2.oIl != null)) {
              paraml1.oIl = paraml2.oIl;
            }
          }
          if ((!paramBoolean) && (paraml2 != null) && (paraml2.oIm != null)) {
            paraml1.oIm.addAll(paraml2.oIm);
          }
          for (;;)
          {
            am.bWh().putValue("key_share_card_other_city_category_info_list", localArrayList);
            com.tencent.mm.kernel.g.ajR().gDX.sW(l2);
            ae.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
            AppMethodBeat.o(112927);
            return;
            label651:
            if ((paraml1 != null) && (!paramBoolean) && (paraml2 != null) && (paraml2.oIm != null)) {
              paraml1.oIm = paraml2.oIm;
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
    AppMethodBeat.i(112926);
    if (paraml == null)
    {
      ae.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
      AppMethodBeat.o(112926);
      return;
    }
    ae.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
    Object localObject1 = (Map)am.bWh().getValue("key_share_card_annoucement_map");
    if (localObject1 == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      Object localObject2 = (Map)am.bWh().getValue("key_share_card_count_map");
      if (localObject2 == null) {
        localObject2 = new HashMap();
      }
      for (;;)
      {
        Object localObject3 = (Map)am.bWh().getValue("key_share_card_username_map");
        if (localObject3 == null) {
          localObject3 = new HashMap();
        }
        for (;;)
        {
          ArrayList localArrayList1 = (ArrayList)am.bWh().getValue("key_share_card_local_city_ids");
          if (localArrayList1 == null) {
            localArrayList1 = new ArrayList();
          }
          for (;;)
          {
            ArrayList localArrayList2 = (ArrayList)am.bWh().getValue("key_share_card_other_city_ids");
            if (localArrayList2 == null) {
              localArrayList2 = new ArrayList();
            }
            for (;;)
            {
              ArrayList localArrayList3 = (ArrayList)am.bWh().getValue("key_share_card_other_city_top_info_list");
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
                if ((paraml.oIl != null) && (paraml.oIl.size() > 0))
                {
                  i = 0;
                  if (i < paraml.oIl.size())
                  {
                    localm = (m)paraml.oIl.get(i);
                    if (!TextUtils.isEmpty(localm.oIt)) {
                      ((Map)localObject1).put(localm.oEo, localm.oIt);
                    }
                    j = am.bWk().Zs(localm.oEo);
                    ((Map)localObject2).put(localm.oEo, Integer.valueOf(j));
                    ((Map)localObject3).put(localm.oEo, I(am.bWk().Zr(localm.oEo)));
                    if (!localArrayList4.contains(localm.oEo))
                    {
                      localObject4 = am.bWk().Zt(localm.oEo);
                      if ((TextUtils.isEmpty((CharSequence)localObject4)) || (localArrayList1.contains(localObject4))) {
                        break label462;
                      }
                      localArrayList1.add(localObject4);
                    }
                    for (;;)
                    {
                      localArrayList4.add(localm.oEo);
                      localObject4 = new p();
                      ((p)localObject4).oEo = localm.oEo;
                      ((p)localObject4).top = localm.top;
                      localArrayList3.add(localObject4);
                      i += 1;
                      break;
                      label462:
                      if (!localArrayList1.contains(localm.dJb)) {
                        localArrayList1.add(localm.dJb);
                      }
                    }
                  }
                }
                localArrayList4.clear();
                if ((paraml.oIm != null) && (paraml.oIm.size() > 0))
                {
                  i = 0;
                  if (i < paraml.oIm.size())
                  {
                    localm = (m)paraml.oIm.get(i);
                    if (!TextUtils.isEmpty(localm.oIt)) {
                      ((Map)localObject1).put(localm.oEo, localm.oIt);
                    }
                    j = am.bWk().Zs(localm.oEo);
                    ((Map)localObject2).put(localm.oEo, Integer.valueOf(j));
                    ((Map)localObject3).put(localm.oEo, I(am.bWk().Zr(localm.oEo)));
                    if (!localArrayList4.contains(localm.oEo))
                    {
                      localObject4 = am.bWk().Zt(localm.oEo);
                      if ((TextUtils.isEmpty((CharSequence)localObject4)) || (localArrayList2.contains(localObject4))) {
                        break label732;
                      }
                      localArrayList2.add(localObject4);
                    }
                    for (;;)
                    {
                      localArrayList4.add(localm.oEo);
                      localObject4 = new p();
                      ((p)localObject4).oEo = localm.oEo;
                      ((p)localObject4).top = localm.top;
                      localArrayList3.add(localObject4);
                      i += 1;
                      break;
                      label732:
                      if (!localArrayList2.contains(localm.dJb)) {
                        localArrayList2.add(localm.dJb);
                      }
                    }
                  }
                }
                am.bWh().putValue("key_share_card_annoucement_map", localObject1);
                am.bWh().putValue("key_share_card_count_map", localObject2);
                am.bWh().putValue("key_share_card_username_map", localObject3);
                am.bWh().putValue("key_share_card_local_city", paraml.oIn);
                am.bWh().putValue("key_share_card_local_city_ids", localArrayList1);
                am.bWh().putValue("key_share_card_other_city_ids", localArrayList2);
                am.bWh().putValue("key_share_card_other_city_top_info_list", localArrayList3);
                AppMethodBeat.o(112926);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public static void ad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(112945);
    ae.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:".concat(String.valueOf(paramString)));
    Object localObject1 = (Map)am.bWh().getValue("key_share_card_count_map");
    if (localObject1 == null) {
      localObject1 = new HashMap();
    }
    for (;;)
    {
      Map localMap = (Map)am.bWh().getValue("key_share_card_username_map");
      Object localObject2 = localMap;
      if (localMap == null) {
        localObject2 = new HashMap();
      }
      ((Map)localObject1).put(paramString, Integer.valueOf(am.bWk().Zs(paramString)));
      ((Map)localObject2).put(paramString, b(paramContext, am.bWk().Zr(paramString)));
      am.bWh().putValue("key_share_card_count_map", localObject1);
      am.bWh().putValue("key_share_card_username_map", localObject2);
      AppMethodBeat.o(112945);
      return;
    }
  }
  
  private static String b(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(112930);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ae.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
      AppMethodBeat.o(112930);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if ((i < paramArrayList.size()) && (i < 2))
    {
      if (i != 0) {
        localStringBuilder.append("、");
      }
      String str1 = w.zQ((String)paramArrayList.get(i));
      String str2 = w.zP((String)paramArrayList.get(i));
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
      ae.e("MicroMsg.ShareCardDataMgr", "context == null");
      AppMethodBeat.o(112930);
      return "";
    }
    if ((paramArrayList.size() == 1) || (paramArrayList.size() == 2))
    {
      paramContext = paramContext.getString(2131756990, new Object[] { localStringBuilder.toString() });
      AppMethodBeat.o(112930);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756971, new Object[] { localStringBuilder.toString(), Integer.valueOf(paramArrayList.size()) });
    AppMethodBeat.o(112930);
    return paramContext;
  }
  
  public static int bWE()
  {
    int i = 0;
    AppMethodBeat.i(112924);
    Object localObject1 = am.bWc();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=0 OR status=5) AND card_type=10");
    localObject2 = "select count(*) from UserCardInfo" + ((StringBuilder)localObject2).toString();
    localObject1 = ((c)localObject1).db.a((String)localObject2, null, 2);
    if (localObject1 == null)
    {
      AppMethodBeat.o(112924);
      return 0;
    }
    if (((Cursor)localObject1).moveToFirst()) {
      i = ((Cursor)localObject1).getInt(0);
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(112924);
    return i;
  }
  
  public static void bWF()
  {
    AppMethodBeat.i(112928);
    long l1 = System.currentTimeMillis();
    long l2 = com.tencent.mm.kernel.g.ajR().gDX.yi(Thread.currentThread().getId());
    ae.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
    Object localObject = (ArrayList)am.bWh().getValue("key_share_card_local_city_category_info_list");
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = (ArrayList)am.bWh().getValue("key_share_card_other_city_category_info_list");
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        int i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          i locali = (i)((ArrayList)localObject).get(i);
          am.bWk().V(locali.oEo, 10, locali.oIh);
          i += 1;
        }
        i = 0;
        while (i < localArrayList.size())
        {
          localObject = (i)localArrayList.get(i);
          am.bWk().V(((i)localObject).oEo, 0, ((i)localObject).oIh);
          i += 1;
        }
        com.tencent.mm.kernel.g.ajR().gDX.sW(l2);
        ae.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(112928);
        return;
      }
    }
  }
  
  public static int bWG()
  {
    AppMethodBeat.i(112936);
    if (bWI())
    {
      AppMethodBeat.o(112936);
      return 1;
    }
    if (bWH())
    {
      if (oHY)
      {
        AppMethodBeat.o(112936);
        return 3;
      }
      AppMethodBeat.o(112936);
      return 4;
    }
    AppMethodBeat.o(112936);
    return 0;
  }
  
  public static boolean bWH()
  {
    AppMethodBeat.i(112937);
    ArrayList localArrayList = (ArrayList)am.bWh().getValue("key_share_card_other_city_ids");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      AppMethodBeat.o(112937);
      return true;
    }
    AppMethodBeat.o(112937);
    return false;
  }
  
  public static boolean bWI()
  {
    AppMethodBeat.i(112938);
    ArrayList localArrayList = (ArrayList)am.bWh().getValue("key_share_card_local_city_ids");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      AppMethodBeat.o(112938);
      return true;
    }
    AppMethodBeat.o(112938);
    return false;
  }
  
  public static void bWJ()
  {
    AppMethodBeat.i(112944);
    ae.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112922);
        ae.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
        Object localObject1 = am.bWk();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
        localObject2 = "delete from ShareCardInfo" + ((StringBuilder)localObject2).toString();
        boolean bool = ((k)localObject1).db.execSQL("ShareCardInfo", (String)localObject2);
        localObject1 = new StringBuilder("delelteAllIllegalStatusCard updateRet is ");
        if (bool) {}
        for (int i = 1;; i = 0)
        {
          ae.i("MicroMsg.ShareCardInfoStorage", i);
          ae.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
          AppMethodBeat.o(112922);
          return;
        }
      }
    }, "delelteAllIllegalStatusCard");
    AppMethodBeat.o(112944);
  }
  
  public static boolean bWK()
  {
    AppMethodBeat.i(112950);
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.bWh().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      AppMethodBeat.o(112950);
      return true;
    }
    boolean bool = locall.oIo;
    AppMethodBeat.o(112950);
    return bool;
  }
  
  public static boolean bWL()
  {
    AppMethodBeat.i(112951);
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.bWh().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      AppMethodBeat.o(112951);
      return true;
    }
    boolean bool = locall.oIp;
    AppMethodBeat.o(112951);
    return bool;
  }
  
  public static boolean bWM()
  {
    AppMethodBeat.i(112952);
    Object localObject = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMh, Integer.valueOf(0));
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      AppMethodBeat.o(112952);
      return false;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMh, Integer.valueOf(1));
    localObject = am.bWc().a(n.a.oGk);
    if ((localObject != null) && (((Cursor)localObject).getCount() > 0))
    {
      ((Cursor)localObject).moveToFirst();
      if (!((Cursor)localObject).isAfterLast())
      {
        CardInfo localCardInfo = new CardInfo();
        localCardInfo.convertFrom((Cursor)localObject);
        if (localCardInfo.field_card_type == -1)
        {
          if (localCardInfo.bVc() != null) {
            break label147;
          }
          ae.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
        }
        for (;;)
        {
          ((Cursor)localObject).moveToNext();
          break;
          label147:
          localCardInfo.field_card_type = localCardInfo.bVc().mwj;
          if (!am.bWc().update(localCardInfo, new String[0])) {
            ae.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", new Object[] { localCardInfo.field_card_id });
          }
        }
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(112952);
      return true;
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    ae.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
    AppMethodBeat.o(112952);
    return false;
  }
  
  public static void fb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112934);
    if (gnW)
    {
      ae.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
      AppMethodBeat.o(112934);
      return;
    }
    ae.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
    gnW = true;
    ArrayList localArrayList = AC(1);
    if ((localArrayList != null) && (localArrayList.contains(paramString1)))
    {
      localArrayList.remove(paramString1);
      String str = am.bWk().fe(paramString1, paramString2);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
      am.bWh().putValue("key_share_card_local_city_ids", localArrayList);
    }
    localArrayList = AC(2);
    if ((localArrayList != null) && (localArrayList.contains(paramString1)))
    {
      localArrayList.remove(paramString1);
      paramString1 = am.bWk().fe(paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString1)) {
        localArrayList.add(paramString1);
      }
      am.bWh().putValue("key_share_card_other_city_ids", localArrayList);
    }
    gnW = false;
    AppMethodBeat.o(112934);
  }
  
  public static void fc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112935);
    ae.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + paramString1 + ", card_tp_id:" + paramString2);
    ArrayList localArrayList1 = AC(1);
    if ((localArrayList1 != null) && (localArrayList1.contains(paramString1)))
    {
      AppMethodBeat.o(112935);
      return;
    }
    ArrayList localArrayList2 = AC(2);
    if ((localArrayList2 != null) && (localArrayList2.contains(paramString1)))
    {
      AppMethodBeat.o(112935);
      return;
    }
    com.tencent.mm.plugin.card.sharecard.model.l locall = (com.tencent.mm.plugin.card.sharecard.model.l)am.bWh().getValue("key_share_card_layout_data");
    if (locall == null)
    {
      ae.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
      AppMethodBeat.o(112935);
      return;
    }
    int j = am.bWk().Zs(paramString2);
    int k = Zn(paramString2);
    ae.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + j + " cacheCount:" + k);
    int i;
    if ((locall.oIl != null) && (locall.oIl.size() > 0) && ((k <= 0) || (j == 1))) {
      i = 0;
    }
    while (i < locall.oIl.size())
    {
      m localm = (m)locall.oIl.get(i);
      if ((paramString2 != null) && (paramString2.contains(localm.oEo)))
      {
        localArrayList1.add(paramString1);
        am.bWh().putValue("key_share_card_local_city_ids", localArrayList1);
        ae.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(112935);
        return;
      }
      i += 1;
      continue;
      ae.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
    }
    if ((localArrayList2 != null) && ((k <= 0) || (j == 1)))
    {
      localArrayList2.add(paramString1);
      am.bWh().putValue("key_share_card_other_city_ids", localArrayList2);
      ae.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(112935);
      return;
    }
    ae.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
    AppMethodBeat.o(112935);
  }
  
  public static String fd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112949);
    ae.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
    if (paramString2 != null)
    {
      paramString2 = Zo(paramString2);
      if ((paramString2 != null) && (paramString2.size() > 0))
      {
        paramString2 = (r)paramString2.get(0);
        if ((paramString2 != null) && (paramString2.oIA != null) && (paramString2.oIA.size() > 0) && (!paramString1.equals(paramString2.oIA.get(0))))
        {
          paramString1 = (String)paramString2.oIA.get(0);
          ae.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112949);
      return paramString1;
      ae.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
      continue;
      ae.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
      continue;
      ae.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
    }
  }
  
  public final void aJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(112925);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
      AppMethodBeat.o(112925);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = t.aah(paramString);
    Object localObject2 = (com.tencent.mm.plugin.card.sharecard.model.l)am.bWh().getValue("key_share_card_layout_data");
    if (localObject1 == null)
    {
      ae.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
      a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, (com.tencent.mm.plugin.card.sharecard.model.l)localObject2, paramBoolean);
      am.bWh().putValue("key_share_card_layout_data", localObject1);
      AppMethodBeat.o(112925);
      return;
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.ZZ(paramString);
    }
    a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, paramBoolean);
    a((com.tencent.mm.plugin.card.sharecard.model.l)localObject1, (com.tencent.mm.plugin.card.sharecard.model.l)localObject2, paramBoolean);
    am.bWh().putValue("key_share_card_layout_data", localObject1);
    int j = 0;
    int i = j;
    if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).oIl != null)
    {
      i = j;
      if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).oIl.size() > 0) {
        i = ((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).oIl.size();
      }
    }
    j = i;
    if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).oIm != null)
    {
      j = i;
      if (((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).oIm.size() > 0) {
        j = i + ((com.tencent.mm.plugin.card.sharecard.model.l)localObject1).oIm.size();
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
      com.tencent.mm.plugin.report.service.g.yxI.b(paramString, true);
    }
    AppMethodBeat.o(112925);
  }
  
  public final void init()
  {
    AppMethodBeat.i(112923);
    if ((com.tencent.mm.plugin.card.sharecard.model.l)am.bWh().getValue("key_share_card_layout_data") == null)
    {
      ae.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
      Object localObject = com.tencent.mm.plugin.card.d.l.bZT();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ae.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
        AppMethodBeat.o(112923);
        return;
      }
      localObject = t.aah((String)localObject);
      if (localObject != null)
      {
        ae.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
        am.bWh().putValue("key_share_card_layout_data", localObject);
        a((com.tencent.mm.plugin.card.sharecard.model.l)localObject, true);
        AppMethodBeat.o(112923);
        return;
      }
      ae.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
      AppMethodBeat.o(112923);
      return;
    }
    ae.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
    AppMethodBeat.o(112923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.a.b
 * JD-Core Version:    0.7.0.1
 */