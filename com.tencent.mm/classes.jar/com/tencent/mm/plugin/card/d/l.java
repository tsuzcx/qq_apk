package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.ao;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l
{
  private static SimpleDateFormat oWf = null;
  private static SimpleDateFormat oWg = null;
  private static SimpleDateFormat oWh = null;
  
  public static boolean AB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean AZ(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 9) || (paramInt == 12) || (paramInt == 17) || (paramInt == 21);
  }
  
  public static boolean Ba(int paramInt)
  {
    return (paramInt == 7) || (paramInt == 8) || (paramInt == 16) || (paramInt == 26);
  }
  
  public static boolean Bb(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 15);
  }
  
  public static ShapeDrawable P(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(113814);
    paramContext = eV(paramInt, paramContext.getResources().getDimensionPixelOffset(2131165956));
    AppMethodBeat.o(113814);
    return paramContext;
  }
  
  public static Bitmap T(Bitmap paramBitmap)
  {
    boolean bool = true;
    AppMethodBeat.i(113820);
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    ((Matrix)localObject).setRotate(90.0F, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new StringBuilder("resultBmp is null: ");
    if (paramBitmap == null) {}
    for (;;)
    {
      ae.d("MicroMsg.CardUtil", bool + "  degree:90.0");
      AppMethodBeat.o(113820);
      return paramBitmap;
      bool = false;
    }
  }
  
  public static void U(Bitmap paramBitmap)
  {
    AppMethodBeat.i(113821);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ae.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    AppMethodBeat.o(113821);
  }
  
  public static String Z(String paramString, long paramLong)
  {
    AppMethodBeat.i(113846);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113846);
      return "";
    }
    float f1 = am.bWi().fHk;
    float f2 = am.bWi().fHj;
    if ((f1 == -1000.0F) || (f2 == -85.0F))
    {
      ae.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
      AppMethodBeat.o(113846);
      return paramString;
    }
    if ((0x10 & paramLong) > 0L)
    {
      String str = "&longitude=" + f1 + "&latitude=" + f2;
      str = paramString.replace("#", str + "#");
      ae.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:".concat(String.valueOf(paramString)));
      ae.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:".concat(String.valueOf(str)));
      AppMethodBeat.o(113846);
      return str;
    }
    AppMethodBeat.o(113846);
    return paramString;
  }
  
  public static int ZY(String paramString)
  {
    AppMethodBeat.i(113812);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      ae.e("MicroMsg.CardUtil", "string format error");
      AppMethodBeat.o(113812);
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      int j = Color.argb(255, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      AppMethodBeat.o(113812);
      return j;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.CardUtil", paramString.toString());
      AppMethodBeat.o(113812);
    }
    return i;
  }
  
  public static void ZZ(String paramString)
  {
    AppMethodBeat.i(113834);
    g.ajR().ajA().set(am.a.ILZ, paramString);
    AppMethodBeat.o(113834);
  }
  
  public static det a(int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(113840);
    ae.i("MicroMsg.CardUtil", "getShareTag()");
    det localdet = new det();
    String str;
    if (paramInt == 2)
    {
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
        localdet.HLR.addAll(paramArrayList1);
      }
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        paramArrayList1 = new ArrayList();
        paramInt = 0;
        while (paramInt < paramArrayList2.size())
        {
          str = (String)paramArrayList2.get(paramInt);
          if ((!TextUtils.isEmpty(str)) && (isNumeric(str))) {
            paramArrayList1.add(Integer.valueOf(bu.getInt(str, 0)));
          }
          paramInt += 1;
        }
        localdet.HLU.addAll(paramArrayList1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113840);
      return localdet;
      if (paramInt == 3)
      {
        if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
          localdet.HLT.addAll(paramArrayList1);
        }
        if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
        {
          paramArrayList1 = new ArrayList();
          paramInt = 0;
          while (paramInt < paramArrayList2.size())
          {
            str = (String)paramArrayList2.get(paramInt);
            if ((!TextUtils.isEmpty(str)) && (isNumeric(str))) {
              paramArrayList1.add(Integer.valueOf(bu.getInt(str, 0)));
            }
            paramInt += 1;
          }
          localdet.HLV.addAll(paramArrayList1);
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.card.base.b paramb, String paramString1, String paramString2, int paramInt)
  {
    k.b localb = null;
    AppMethodBeat.i(113823);
    Object localObject = u.a(new m(paramb.bVc().hCp));
    if (localObject != null) {}
    for (localObject = com.tencent.mm.sdk.platformtools.h.Bitmap2Bytes((Bitmap)localObject);; localObject = null)
    {
      com.tencent.mm.plugin.card.compat.a.a locala = (com.tencent.mm.plugin.card.compat.a.a)g.ab(com.tencent.mm.plugin.card.compat.a.a.class);
      if (paramb == null)
      {
        paramString2 = localb;
        locala.a(paramString2, paramb.bVc().dwb, paramb.bVc().oFG, paramString1, (byte[])localObject);
        AppMethodBeat.o(113823);
        return;
      }
      if (paramInt == 23) {
        paramInt = 2;
      }
      for (int i = 1;; i = 0)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localb = new k.b();
        if (paramb.bVc() != null)
        {
          localb.title = paramb.bVe().HLH;
          localb.description = paramb.bVc().title;
          localb.type = 16;
          localb.dmr = 0;
          localb.hCF = 3;
          localb.appId = paramb.bVc().dwb;
          localb.hBV = 0;
          localb.thumburl = paramb.bVc().hCp;
          localb.hDQ = paramInt;
          localb.hDP = paramb.bVc().oFG;
          localb.url = paramb.bVc().Gkd;
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("<from_username>").append(paramb.bVi()).append("</from_username>");
        if (AZ(paramInt))
        {
          localStringBuilder2.append("<card_id>").append(paramb.bVh()).append("</card_id>");
          label314:
          localStringBuilder2.append("<card_type>").append(paramb.bVc().mwj).append("</card_type>");
          localStringBuilder2.append("<from_scene>").append(paramInt).append("</from_scene>");
          localStringBuilder2.append("<color>").append(paramb.bVc().hDr).append("</color>");
          localStringBuilder2.append("<card_type_name>").append(paramb.bVc().oFF).append("</card_type_name>");
          localStringBuilder2.append("<brand_name>").append(paramb.bVc().oFG).append("</brand_name>");
          if (!TextUtils.isEmpty(paramString2)) {
            break label569;
          }
          localStringBuilder2.append("<card_ext></card_ext>");
        }
        for (;;)
        {
          localStringBuilder2.append("<is_recommend>").append(i).append("</is_recommend>");
          localStringBuilder2.append("<recommend_card_id>").append(paramb.bVg()).append("</recommend_card_id>");
          localb.hDO = localStringBuilder2.toString();
          localb.dxN = k.b.a(localb, null, null);
          paramString2 = localb;
          break;
          if (paramInt != 5) {
            break label314;
          }
          localStringBuilder2.append("<card_id>").append(paramb.bVg()).append("</card_id>");
          break label314;
          label569:
          localStringBuilder2.append("<card_ext>").append(paramString2).append("</card_ext>");
        }
      }
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.card.model.b paramb, String paramString)
  {
    AppMethodBeat.i(113842);
    if (!tQ(paramb.GkZ))
    {
      ae.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      AppMethodBeat.o(113842);
      return false;
    }
    if (aac(paramString))
    {
      ae.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      AppMethodBeat.o(113842);
      return false;
    }
    ae.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    AppMethodBeat.o(113842);
    return true;
  }
  
  public static boolean a(ShareCardInfo paramShareCardInfo)
  {
    AppMethodBeat.i(113832);
    if (paramShareCardInfo == null)
    {
      ae.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
      AppMethodBeat.o(113832);
      return false;
    }
    ShareCardInfo localShareCardInfo = am.bWk().Zv(paramShareCardInfo.field_card_id);
    if (localShareCardInfo == null)
    {
      bool = am.bWk().insert(paramShareCardInfo);
      ae.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        ae.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
      }
      for (;;)
      {
        AppMethodBeat.o(113832);
        return bool;
        com.tencent.mm.plugin.card.sharecard.a.b.fc(paramShareCardInfo.field_card_id, paramShareCardInfo.field_card_tp_id);
      }
    }
    paramShareCardInfo.field_categoryType = localShareCardInfo.field_categoryType;
    paramShareCardInfo.field_itemIndex = localShareCardInfo.field_itemIndex;
    boolean bool = am.bWk().update(paramShareCardInfo, new String[0]);
    ae.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(113832);
    return bool;
  }
  
  public static boolean a(aai paramaai, String paramString)
  {
    AppMethodBeat.i(113841);
    if (!tQ(paramaai.GkZ))
    {
      ae.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      AppMethodBeat.o(113841);
      return false;
    }
    if (aac(paramString))
    {
      ae.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      AppMethodBeat.o(113841);
      return false;
    }
    ae.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    AppMethodBeat.o(113841);
    return true;
  }
  
  public static boolean aIi()
  {
    AppMethodBeat.i(113830);
    try
    {
      boolean bool = ((LocationManager)ak.getContext().getSystemService("location")).isProviderEnabled("gps");
      AppMethodBeat.o(113830);
      return bool;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.CardUtil", localException, "", new Object[0]);
      AppMethodBeat.o(113830);
    }
    return false;
  }
  
  public static boolean aIj()
  {
    AppMethodBeat.i(113831);
    try
    {
      boolean bool = ((LocationManager)ak.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(113831);
      return bool;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.CardUtil", localException, "", new Object[0]);
      AppMethodBeat.o(113831);
    }
    return false;
  }
  
  public static String aaa(String paramString)
  {
    AppMethodBeat.i(113836);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113836);
      return "";
    }
    String str1 = w.zQ(paramString);
    String str2 = w.zP(paramString);
    if (!TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(113836);
      return str1;
    }
    if (!TextUtils.isEmpty(str2))
    {
      AppMethodBeat.o(113836);
      return str2;
    }
    AppMethodBeat.o(113836);
    return paramString;
  }
  
  public static String aab(String paramString)
  {
    AppMethodBeat.i(113839);
    paramString = Arrays.asList(paramString.split(","));
    LinkedList localLinkedList = new LinkedList();
    if (g.ajM()) {
      if ((paramString != null) && (paramString.size() != 0)) {}
    }
    for (;;)
    {
      paramString = bu.m(localLinkedList, ",");
      AppMethodBeat.o(113839);
      return paramString;
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str);
        paramString = str;
        if (localan != null)
        {
          paramString = str;
          if ((int)localan.ght != 0) {
            paramString = localan.adG();
          }
        }
        localLinkedList.add(paramString);
      }
    }
  }
  
  private static boolean aac(String paramString)
  {
    AppMethodBeat.i(113844);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
      AppMethodBeat.o(113844);
      return true;
    }
    ae.i("MicroMsg.CardUtil", "hasShowWarning()");
    Object localObject = (String)g.ajR().ajA().get(am.a.IMg, "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ae.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
      AppMethodBeat.o(113844);
      return false;
    }
    localObject = ((String)localObject).split(",");
    if ((localObject == null) || (localObject.length == 0))
    {
      ae.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
      AppMethodBeat.o(113844);
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(localObject[i]))
      {
        AppMethodBeat.o(113844);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(113844);
    return false;
  }
  
  public static void aad(String paramString)
  {
    AppMethodBeat.i(113845);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
      AppMethodBeat.o(113845);
      return;
    }
    ae.i("MicroMsg.CardUtil", "setShowWarningFlag()");
    String str = (String)g.ajR().ajA().get(am.a.IMg, "");
    if (TextUtils.isEmpty(str)) {
      ae.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
    }
    for (;;)
    {
      g.ajR().ajA().set(am.a.IMg, paramString);
      AppMethodBeat.o(113845);
      return;
      String[] arrayOfString = str.split(",");
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        ae.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
        str = paramString;
      }
      int k = arrayOfString.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (paramString.equals(arrayOfString[i])) {
          j = 1;
        }
        i += 1;
      }
      if (j == 0) {
        paramString = str + "," + paramString;
      } else {
        paramString = str;
      }
    }
  }
  
  public static int aae(String paramString)
  {
    AppMethodBeat.i(113847);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(v.aAC())))
    {
      AppMethodBeat.o(113847);
      return 1;
    }
    AppMethodBeat.o(113847);
    return 0;
  }
  
  public static ColorStateList ah(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113849);
    int i = paramContext.getResources().getColor(2131101182);
    int j = ZY(paramString);
    paramContext = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j });
    AppMethodBeat.o(113849);
    return paramContext;
  }
  
  public static void ai(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113852);
    if (!bu.isNullOrNil(paramString))
    {
      Toast.makeText(ak.getContext(), paramString, 1).show();
      AppMethodBeat.o(113852);
      return;
    }
    com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(2131757027), "", false);
    AppMethodBeat.o(113852);
  }
  
  public static void aj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113853);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = paramContext.getString(2131757027);
    }
    com.tencent.mm.ui.base.h.c(paramContext, str, "", false);
    AppMethodBeat.o(113853);
  }
  
  public static boolean b(CardInfo paramCardInfo)
  {
    AppMethodBeat.i(113822);
    if (paramCardInfo == null)
    {
      ae.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
      AppMethodBeat.o(113822);
      return false;
    }
    CardInfo localCardInfo = am.bWc().Zf(paramCardInfo.field_card_id);
    if (localCardInfo == null)
    {
      bool = am.bWc().insert(paramCardInfo);
      ae.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        ae.e("MicroMsg.CardUtil", "processCardObject, insert fail");
      }
      AppMethodBeat.o(113822);
      return bool;
    }
    paramCardInfo.field_stickyIndex = localCardInfo.field_stickyIndex;
    paramCardInfo.field_stickyEndTime = localCardInfo.field_stickyEndTime;
    paramCardInfo.field_stickyAnnouncement = localCardInfo.field_stickyAnnouncement;
    boolean bool = am.bWc().update(paramCardInfo, new String[0]);
    ae.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(113822);
    return bool;
  }
  
  public static void bZP()
  {
    AppMethodBeat.i(113825);
    Integer localInteger = (Integer)g.ajR().ajA().get(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      ae.i("MicroMsg.CardUtil", "card entrance is open");
      AppMethodBeat.o(113825);
      return;
    }
    ae.i("MicroMsg.CardUtil", "open card entrance");
    g.ajR().ajA().set(282883, Integer.valueOf(1));
    AppMethodBeat.o(113825);
  }
  
  public static boolean bZQ()
  {
    AppMethodBeat.i(113826);
    Integer localInteger = (Integer)g.ajR().ajA().get(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      AppMethodBeat.o(113826);
      return true;
    }
    AppMethodBeat.o(113826);
    return false;
  }
  
  public static void bZR()
  {
    AppMethodBeat.i(113827);
    Integer localInteger = (Integer)g.ajR().ajA().get(am.a.IMb, Integer.valueOf(0));
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      ae.i("MicroMsg.CardUtil", "share card entrance is open");
      AppMethodBeat.o(113827);
      return;
    }
    ae.i("MicroMsg.CardUtil", "open share card entrance");
    g.ajR().ajA().set(am.a.IMb, Integer.valueOf(1));
    AppMethodBeat.o(113827);
  }
  
  public static boolean bZS()
  {
    AppMethodBeat.i(113828);
    Integer localInteger = (Integer)g.ajR().ajA().get(am.a.IMb, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      AppMethodBeat.o(113828);
      return true;
    }
    AppMethodBeat.o(113828);
    return false;
  }
  
  public static String bZT()
  {
    AppMethodBeat.i(113835);
    String str = (String)g.ajR().ajA().get(am.a.ILZ, "");
    AppMethodBeat.o(113835);
    return str;
  }
  
  public static List<com.tencent.mm.plugin.card.model.b> cI(List<uc> paramList)
  {
    AppMethodBeat.i(113817);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(113817);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      uc localuc = (uc)paramList.get(i);
      com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
      localb.title = localuc.title;
      localb.oEp = localuc.oEp;
      localb.oIr = localuc.oIr;
      localb.url = localuc.url;
      localb.GkZ = localuc.GkZ;
      localb.oEA = false;
      localb.Gla = localuc.Gla;
      localb.Glb = localuc.Glb;
      localb.pqW = localuc.pqW;
      localb.GjJ = localuc.GjJ;
      localb.GjK = localuc.GjK;
      localb.oEz = 1;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(113817);
    return localArrayList;
  }
  
  public static ArrayList<String> cJ(List<String> paramList)
  {
    AppMethodBeat.i(113837);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
      AppMethodBeat.o(113837);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = com.tencent.mm.plugin.label.a.a.dig().apr(com.tencent.mm.plugin.label.a.a.dig().apo((String)localObject));
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        ae.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
      } else {
        localHashSet.addAll((Collection)localObject);
      }
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(113837);
    return localArrayList;
  }
  
  public static ArrayList<String> cK(List<String> paramList)
  {
    AppMethodBeat.i(113838);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
      AppMethodBeat.o(113838);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      str = com.tencent.mm.plugin.label.a.a.dig().apo(str);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    AppMethodBeat.o(113838);
    return localArrayList;
  }
  
  public static int cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(113813);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      ae.e("MicroMsg.CardUtil", "string format error");
      AppMethodBeat.o(113813);
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      paramInt = Color.argb(paramInt, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      AppMethodBeat.o(113813);
      return paramInt;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.CardUtil", paramString.toString());
      AppMethodBeat.o(113813);
    }
    return i;
  }
  
  public static int cO(String paramString, int paramInt)
  {
    AppMethodBeat.i(113850);
    paramInt = eW(Color.parseColor(paramString), paramInt);
    AppMethodBeat.o(113850);
    return paramInt;
  }
  
  public static ShapeDrawable eV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113815);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2 }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt1);
    AppMethodBeat.o(113815);
    return localShapeDrawable;
  }
  
  public static int eW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113851);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(113851);
      return paramInt1;
    }
    paramInt1 = ao.eW(paramInt1, paramInt2);
    AppMethodBeat.o(113851);
    return paramInt1;
  }
  
  public static ShapeDrawable f(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113816);
    int i = paramContext.getResources().getDimensionPixelSize(2131165519);
    paramContext = new float[8];
    paramContext[0] = paramInt2;
    paramContext[1] = paramInt2;
    paramContext[2] = paramInt2;
    paramContext[3] = paramInt2;
    paramContext[4] = paramInt2;
    paramContext[5] = paramInt2;
    paramContext[6] = paramInt2;
    paramContext[7] = paramInt2;
    paramContext = new ShapeDrawable(new RoundRectShape(paramContext, new RectF(i, i, i, i), paramContext));
    Paint localPaint = paramContext.getPaint();
    localPaint.setColor(paramInt1);
    localPaint.setStrokeWidth(i);
    AppMethodBeat.o(113816);
    return paramContext;
  }
  
  public static String f(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(113829);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(113829);
      return "";
    }
    if ((paramFloat > 0.0F) && (paramFloat < 1000.0F))
    {
      paramContext = paramContext.getString(2131756832, new Object[] { (int)paramFloat });
      AppMethodBeat.o(113829);
      return paramContext;
    }
    if (paramFloat >= 1000.0F)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramFloat /= 1000.0F;
      paramContext = paramContext.getString(2131756831, new Object[] { new DecimalFormat("0.00").format(paramFloat) });
      AppMethodBeat.o(113829);
      return paramContext;
    }
    AppMethodBeat.o(113829);
    return "";
  }
  
  public static void fk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113824);
    if (!bu.isNullOrNil(paramString1))
    {
      sy localsy = new sy();
      localsy.dID.cUB = paramString2;
      localsy.dID.content = paramString1;
      localsy.dID.type = x.Bb(paramString2);
      localsy.dID.flags = 0;
      com.tencent.mm.sdk.b.a.IvT.l(localsy);
    }
    AppMethodBeat.o(113824);
  }
  
  public static Drawable h(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(113848);
    paramContext = f(paramContext, ZY(paramString), paramInt);
    paramString = eV(ZY(paramString), paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramString);
    localStateListDrawable.addState(new int[0], paramContext);
    AppMethodBeat.o(113848);
    return localStateListDrawable;
  }
  
  public static boolean h(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113833);
    boolean bool2;
    boolean bool1;
    if ((paramb instanceof CardInfo))
    {
      bool2 = am.bWc().update((CardInfo)paramb, new String[0]);
      bool1 = bool2;
      if (!bool2)
      {
        ae.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.bVg() });
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113833);
      return bool1;
      if ((paramb instanceof ShareCardInfo))
      {
        bool2 = am.bWk().update((ShareCardInfo)paramb, new String[0]);
        bool1 = bool2;
        if (!bool2)
        {
          ae.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.bVg() });
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(113811);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED))
      {
        AppMethodBeat.o(113811);
        return true;
      }
    }
    AppMethodBeat.o(113811);
    return false;
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(113819);
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(113819);
    return bool;
  }
  
  public static String sz(long paramLong)
  {
    AppMethodBeat.i(113818);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (oWf == null) {
      oWf = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = oWf.format(new Date(paramLong));
    AppMethodBeat.o(113818);
    return str;
  }
  
  private static boolean tQ(long paramLong)
  {
    AppMethodBeat.i(113843);
    if ((0x8 & paramLong) > 0L)
    {
      ae.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
      AppMethodBeat.o(113843);
      return true;
    }
    AppMethodBeat.o(113843);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.l
 * JD-Core Version:    0.7.0.1
 */