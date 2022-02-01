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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
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
  private static SimpleDateFormat qkZ = null;
  private static SimpleDateFormat qla = null;
  private static SimpleDateFormat qlb = null;
  
  public static String AF(long paramLong)
  {
    AppMethodBeat.i(113818);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (qkZ == null) {
      qkZ = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = qkZ.format(new Date(paramLong));
    AppMethodBeat.o(113818);
    return str;
  }
  
  private static boolean BV(long paramLong)
  {
    AppMethodBeat.i(113843);
    if ((0x8 & paramLong) > 0L)
    {
      Log.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
      AppMethodBeat.o(113843);
      return true;
    }
    AppMethodBeat.o(113843);
    return false;
  }
  
  public static boolean EH(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 9) || (paramInt == 12) || (paramInt == 17) || (paramInt == 21);
  }
  
  public static boolean EI(int paramInt)
  {
    return (paramInt == 7) || (paramInt == 8) || (paramInt == 16) || (paramInt == 26);
  }
  
  public static boolean EJ(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 15);
  }
  
  public static boolean Eg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static ShapeDrawable U(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(113814);
    paramContext = fi(paramInt, paramContext.getResources().getDimensionPixelOffset(2131165988));
    AppMethodBeat.o(113814);
    return paramContext;
  }
  
  public static Bitmap Y(Bitmap paramBitmap)
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
      Log.d("MicroMsg.CardUtil", bool + "  degree:90.0");
      AppMethodBeat.o(113820);
      return paramBitmap;
      bool = false;
    }
  }
  
  public static String Y(String paramString, long paramLong)
  {
    AppMethodBeat.i(113846);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113846);
      return "";
    }
    float f1 = am.ctW().gmv;
    float f2 = am.ctW().gmu;
    if ((f1 == -1000.0F) || (f2 == -85.0F))
    {
      Log.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
      AppMethodBeat.o(113846);
      return paramString;
    }
    if ((0x10 & paramLong) > 0L)
    {
      String str = "&longitude=" + f1 + "&latitude=" + f2;
      str = paramString.replace("#", str + "#");
      Log.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:".concat(String.valueOf(paramString)));
      Log.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:".concat(String.valueOf(str)));
      AppMethodBeat.o(113846);
      return str;
    }
    AppMethodBeat.o(113846);
    return paramString;
  }
  
  public static void Z(Bitmap paramBitmap)
  {
    AppMethodBeat.i(113821);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    AppMethodBeat.o(113821);
  }
  
  public static dxy a(int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(113840);
    Log.i("MicroMsg.CardUtil", "getShareTag()");
    dxy localdxy = new dxy();
    String str;
    if (paramInt == 2)
    {
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
        localdxy.MXB.addAll(paramArrayList1);
      }
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        paramArrayList1 = new ArrayList();
        paramInt = 0;
        while (paramInt < paramArrayList2.size())
        {
          str = (String)paramArrayList2.get(paramInt);
          if ((!TextUtils.isEmpty(str)) && (isNumeric(str))) {
            paramArrayList1.add(Integer.valueOf(Util.getInt(str, 0)));
          }
          paramInt += 1;
        }
        localdxy.MXD.addAll(paramArrayList1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113840);
      return localdxy;
      if (paramInt == 3)
      {
        if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
          localdxy.MXC.addAll(paramArrayList1);
        }
        if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
        {
          paramArrayList1 = new ArrayList();
          paramInt = 0;
          while (paramInt < paramArrayList2.size())
          {
            str = (String)paramArrayList2.get(paramInt);
            if ((!TextUtils.isEmpty(str)) && (isNumeric(str))) {
              paramArrayList1.add(Integer.valueOf(Util.getInt(str, 0)));
            }
            paramInt += 1;
          }
          localdxy.MXE.addAll(paramArrayList1);
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.card.base.b paramb, String paramString1, String paramString2, int paramInt)
  {
    k.b localb = null;
    AppMethodBeat.i(113823);
    Object localObject = u.a(new m(paramb.csQ().iwv));
    if (localObject != null) {}
    for (localObject = BitmapUtil.Bitmap2Bytes((Bitmap)localObject);; localObject = null)
    {
      com.tencent.mm.plugin.card.compat.a.a locala = (com.tencent.mm.plugin.card.compat.a.a)g.af(com.tencent.mm.plugin.card.compat.a.a.class);
      if (paramb == null)
      {
        paramString2 = localb;
        locala.a(paramString2, paramb.csQ().dNI, paramb.csQ().gTG, paramString1, (byte[])localObject);
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
        if (paramb.csQ() != null)
        {
          localb.title = paramb.csS().MXq;
          localb.description = paramb.csQ().title;
          localb.type = 16;
          localb.dDG = 0;
          localb.iwL = 3;
          localb.appId = paramb.csQ().dNI;
          localb.iwc = 0;
          localb.thumburl = paramb.csQ().iwv;
          localb.ixV = paramInt;
          localb.ixU = paramb.csQ().gTG;
          localb.url = paramb.csQ().LeG;
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("<from_username>").append(paramb.csW()).append("</from_username>");
        if (EH(paramInt))
        {
          localStringBuilder2.append("<card_id>").append(paramb.csV()).append("</card_id>");
          label314:
          localStringBuilder2.append("<card_type>").append(paramb.csQ().nHh).append("</card_type>");
          localStringBuilder2.append("<from_scene>").append(paramInt).append("</from_scene>");
          localStringBuilder2.append("<color>").append(paramb.csQ().ixw).append("</color>");
          localStringBuilder2.append("<card_type_name>").append(paramb.csQ().pTn).append("</card_type_name>");
          localStringBuilder2.append("<brand_name>").append(paramb.csQ().gTG).append("</brand_name>");
          if (!TextUtils.isEmpty(paramString2)) {
            break label569;
          }
          localStringBuilder2.append("<card_ext></card_ext>");
        }
        for (;;)
        {
          localStringBuilder2.append("<is_recommend>").append(i).append("</is_recommend>");
          localStringBuilder2.append("<recommend_card_id>").append(paramb.csU()).append("</recommend_card_id>");
          localb.ixT = localStringBuilder2.toString();
          localb.dPu = k.b.a(localb, null, null);
          paramString2 = localb;
          break;
          if (paramInt != 5) {
            break label314;
          }
          localStringBuilder2.append("<card_id>").append(paramb.csU()).append("</card_id>");
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
    if (!BV(paramb.LfD))
    {
      Log.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      AppMethodBeat.o(113842);
      return false;
    }
    if (aki(paramString))
    {
      Log.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      AppMethodBeat.o(113842);
      return false;
    }
    Log.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    AppMethodBeat.o(113842);
    return true;
  }
  
  public static boolean a(ShareCardInfo paramShareCardInfo)
  {
    AppMethodBeat.i(113832);
    if (paramShareCardInfo == null)
    {
      Log.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
      AppMethodBeat.o(113832);
      return false;
    }
    ShareCardInfo localShareCardInfo = am.ctY().ajA(paramShareCardInfo.field_card_id);
    if (localShareCardInfo == null)
    {
      bool = am.ctY().insert(paramShareCardInfo);
      Log.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        Log.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
      }
      for (;;)
      {
        AppMethodBeat.o(113832);
        return bool;
        com.tencent.mm.plugin.card.sharecard.a.b.ft(paramShareCardInfo.field_card_id, paramShareCardInfo.field_card_tp_id);
      }
    }
    paramShareCardInfo.field_categoryType = localShareCardInfo.field_categoryType;
    paramShareCardInfo.field_itemIndex = localShareCardInfo.field_itemIndex;
    boolean bool = am.ctY().update(paramShareCardInfo, new String[0]);
    Log.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(113832);
    return bool;
  }
  
  public static boolean a(abz paramabz, String paramString)
  {
    AppMethodBeat.i(113841);
    if (!BV(paramabz.LfD))
    {
      Log.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      AppMethodBeat.o(113841);
      return false;
    }
    if (aki(paramString))
    {
      Log.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      AppMethodBeat.o(113841);
      return false;
    }
    Log.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    AppMethodBeat.o(113841);
    return true;
  }
  
  public static int ake(String paramString)
  {
    AppMethodBeat.i(113812);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      Log.e("MicroMsg.CardUtil", "string format error");
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
      Log.e("MicroMsg.CardUtil", paramString.toString());
      AppMethodBeat.o(113812);
    }
    return i;
  }
  
  public static void akf(String paramString)
  {
    AppMethodBeat.i(113834);
    g.aAh().azQ().set(ar.a.NUb, paramString);
    AppMethodBeat.o(113834);
  }
  
  public static String akg(String paramString)
  {
    AppMethodBeat.i(113836);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113836);
      return "";
    }
    String str1 = aa.Is(paramString);
    String str2 = aa.getDisplayName(paramString);
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
  
  public static String akh(String paramString)
  {
    AppMethodBeat.i(113839);
    paramString = Arrays.asList(paramString.split(","));
    LinkedList localLinkedList = new LinkedList();
    if (g.aAc()) {
      if ((paramString != null) && (paramString.size() != 0)) {}
    }
    for (;;)
    {
      paramString = Util.listToString(localLinkedList, ",");
      AppMethodBeat.o(113839);
      return paramString;
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
        paramString = str;
        if (localas != null)
        {
          paramString = str;
          if ((int)localas.gMZ != 0) {
            paramString = localas.arJ();
          }
        }
        localLinkedList.add(paramString);
      }
    }
  }
  
  private static boolean aki(String paramString)
  {
    AppMethodBeat.i(113844);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
      AppMethodBeat.o(113844);
      return true;
    }
    Log.i("MicroMsg.CardUtil", "hasShowWarning()");
    Object localObject = (String)g.aAh().azQ().get(ar.a.NUi, "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
      AppMethodBeat.o(113844);
      return false;
    }
    localObject = ((String)localObject).split(",");
    if ((localObject == null) || (localObject.length == 0))
    {
      Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
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
  
  public static void akj(String paramString)
  {
    AppMethodBeat.i(113845);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
      AppMethodBeat.o(113845);
      return;
    }
    Log.i("MicroMsg.CardUtil", "setShowWarningFlag()");
    String str = (String)g.aAh().azQ().get(ar.a.NUi, "");
    if (TextUtils.isEmpty(str)) {
      Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
    }
    for (;;)
    {
      g.aAh().azQ().set(ar.a.NUi, paramString);
      AppMethodBeat.o(113845);
      return;
      String[] arrayOfString = str.split(",");
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
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
  
  public static int akk(String paramString)
  {
    AppMethodBeat.i(113847);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(z.aTY())))
    {
      AppMethodBeat.o(113847);
      return 1;
    }
    AppMethodBeat.o(113847);
    return 0;
  }
  
  public static ColorStateList ap(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113849);
    int i = paramContext.getResources().getColor(2131101427);
    int j = ake(paramString);
    paramContext = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j });
    AppMethodBeat.o(113849);
    return paramContext;
  }
  
  public static void aq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113852);
    if (!Util.isNullOrNil(paramString))
    {
      Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
      AppMethodBeat.o(113852);
      return;
    }
    h.c(paramContext, paramContext.getString(2131757197), "", false);
    AppMethodBeat.o(113852);
  }
  
  public static void ar(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113853);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = paramContext.getString(2131757197);
    }
    h.c(paramContext, str, "", false);
    AppMethodBeat.o(113853);
  }
  
  public static boolean b(CardInfo paramCardInfo)
  {
    AppMethodBeat.i(113822);
    if (paramCardInfo == null)
    {
      Log.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
      AppMethodBeat.o(113822);
      return false;
    }
    CardInfo localCardInfo = am.ctQ().ajk(paramCardInfo.field_card_id);
    if (localCardInfo == null)
    {
      bool = am.ctQ().insert(paramCardInfo);
      Log.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        Log.e("MicroMsg.CardUtil", "processCardObject, insert fail");
      }
      AppMethodBeat.o(113822);
      return bool;
    }
    paramCardInfo.field_stickyIndex = localCardInfo.field_stickyIndex;
    paramCardInfo.field_stickyEndTime = localCardInfo.field_stickyEndTime;
    paramCardInfo.field_stickyAnnouncement = localCardInfo.field_stickyAnnouncement;
    boolean bool = am.ctQ().update(paramCardInfo, new String[0]);
    Log.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(113822);
    return bool;
  }
  
  public static boolean bcc()
  {
    AppMethodBeat.i(113830);
    try
    {
      boolean bool = ((LocationManager)MMApplicationContext.getContext().getSystemService("location")).isProviderEnabled("gps");
      AppMethodBeat.o(113830);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.CardUtil", localException, "", new Object[0]);
      AppMethodBeat.o(113830);
    }
    return false;
  }
  
  public static boolean bcd()
  {
    AppMethodBeat.i(113831);
    try
    {
      boolean bool = ((LocationManager)MMApplicationContext.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(113831);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.CardUtil", localException, "", new Object[0]);
      AppMethodBeat.o(113831);
    }
    return false;
  }
  
  public static int cT(String paramString, int paramInt)
  {
    AppMethodBeat.i(113850);
    paramInt = fj(Color.parseColor(paramString), paramInt);
    AppMethodBeat.o(113850);
    return paramInt;
  }
  
  public static List<com.tencent.mm.plugin.card.model.b> cX(List<vj> paramList)
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
      vj localvj = (vj)paramList.get(i);
      com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
      localb.title = localvj.title;
      localb.pRY = localvj.pRY;
      localb.pWf = localvj.pWf;
      localb.url = localvj.url;
      localb.LfD = localvj.LfD;
      localb.pSj = false;
      localb.LfE = localvj.LfE;
      localb.LfF = localvj.LfF;
      localb.qGB = localvj.qGB;
      localb.Leo = localvj.Leo;
      localb.Lep = localvj.Lep;
      localb.pSi = 1;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(113817);
    return localArrayList;
  }
  
  public static ArrayList<String> cY(List<String> paramList)
  {
    AppMethodBeat.i(113837);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
      AppMethodBeat.o(113837);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH((String)localObject));
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        Log.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
      } else {
        localHashSet.addAll((Collection)localObject);
      }
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(113837);
    return localArrayList;
  }
  
  public static ArrayList<String> cZ(List<String> paramList)
  {
    AppMethodBeat.i(113838);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
      AppMethodBeat.o(113838);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      str = com.tencent.mm.plugin.label.a.a.ecg().aCH(str);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    AppMethodBeat.o(113838);
    return localArrayList;
  }
  
  public static int convertStringToRGB(String paramString, int paramInt)
  {
    AppMethodBeat.i(113813);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      Log.e("MicroMsg.CardUtil", "string format error");
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
      Log.e("MicroMsg.CardUtil", paramString.toString());
      AppMethodBeat.o(113813);
    }
    return i;
  }
  
  public static void cxE()
  {
    AppMethodBeat.i(113825);
    Integer localInteger = (Integer)g.aAh().azQ().get(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      Log.i("MicroMsg.CardUtil", "card entrance is open");
      AppMethodBeat.o(113825);
      return;
    }
    Log.i("MicroMsg.CardUtil", "open card entrance");
    g.aAh().azQ().set(282883, Integer.valueOf(1));
    AppMethodBeat.o(113825);
  }
  
  public static boolean cxF()
  {
    AppMethodBeat.i(113826);
    Integer localInteger = (Integer)g.aAh().azQ().get(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      AppMethodBeat.o(113826);
      return true;
    }
    AppMethodBeat.o(113826);
    return false;
  }
  
  public static void cxG()
  {
    AppMethodBeat.i(113827);
    Integer localInteger = (Integer)g.aAh().azQ().get(ar.a.NUd, Integer.valueOf(0));
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      Log.i("MicroMsg.CardUtil", "share card entrance is open");
      AppMethodBeat.o(113827);
      return;
    }
    Log.i("MicroMsg.CardUtil", "open share card entrance");
    g.aAh().azQ().set(ar.a.NUd, Integer.valueOf(1));
    AppMethodBeat.o(113827);
  }
  
  public static boolean cxH()
  {
    AppMethodBeat.i(113828);
    Integer localInteger = (Integer)g.aAh().azQ().get(ar.a.NUd, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      AppMethodBeat.o(113828);
      return true;
    }
    AppMethodBeat.o(113828);
    return false;
  }
  
  public static String cxI()
  {
    AppMethodBeat.i(113835);
    String str = (String)g.aAh().azQ().get(ar.a.NUb, "");
    AppMethodBeat.o(113835);
    return str;
  }
  
  public static ShapeDrawable e(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113816);
    int i = paramContext.getResources().getDimensionPixelSize(2131165537);
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
      paramContext = paramContext.getString(2131756997, new Object[] { (int)paramFloat });
      AppMethodBeat.o(113829);
      return paramContext;
    }
    if (paramFloat >= 1000.0F)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramFloat /= 1000.0F;
      paramContext = paramContext.getString(2131756996, new Object[] { new DecimalFormat("0.00").format(paramFloat) });
      AppMethodBeat.o(113829);
      return paramContext;
    }
    AppMethodBeat.o(113829);
    return "";
  }
  
  public static void fB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113824);
    if (!Util.isNullOrNil(paramString1))
    {
      tw localtw = new tw();
      localtw.eaq.dkV = paramString2;
      localtw.eaq.content = paramString1;
      localtw.eaq.type = ab.JG(paramString2);
      localtw.eaq.flags = 0;
      EventCenter.instance.publish(localtw);
    }
    AppMethodBeat.o(113824);
  }
  
  public static ShapeDrawable fi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113815);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2 }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt1);
    AppMethodBeat.o(113815);
    return localShapeDrawable;
  }
  
  public static int fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113851);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(113851);
      return paramInt1;
    }
    paramInt1 = ar.fj(paramInt1, paramInt2);
    AppMethodBeat.o(113851);
    return paramInt1;
  }
  
  public static Drawable h(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(113848);
    paramContext = e(paramContext, ake(paramString), paramInt);
    paramString = fi(ake(paramString), paramInt);
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
      bool2 = am.ctQ().update((CardInfo)paramb, new String[0]);
      bool1 = bool2;
      if (!bool2)
      {
        Log.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.csU() });
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113833);
      return bool1;
      if ((paramb instanceof ShareCardInfo))
      {
        bool2 = am.ctY().update((ShareCardInfo)paramb, new String[0]);
        bool1 = bool2;
        if (!bool2)
        {
          Log.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.csU() });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.l
 * JD-Core Version:    0.7.0.1
 */