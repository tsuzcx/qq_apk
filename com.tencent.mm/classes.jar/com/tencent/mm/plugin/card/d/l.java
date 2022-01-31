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
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.protocal.c.bry;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
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
  private static SimpleDateFormat izc = null;
  private static SimpleDateFormat izd = null;
  private static SimpleDateFormat ize = null;
  
  public static boolean Oc()
  {
    try
    {
      boolean bool = ((LocationManager)ae.getContext().getSystemService("location")).isProviderEnabled("gps");
      return bool;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CardUtil", localException, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean Od()
  {
    try
    {
      boolean bool = ((LocationManager)ae.getContext().getSystemService("location")).isProviderEnabled("network");
      return bool;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CardUtil", localException, "", new Object[0]);
    }
    return false;
  }
  
  public static void a(com.tencent.mm.plugin.card.base.b paramb, String paramString1, String paramString2, int paramInt)
  {
    g.a locala = null;
    Object localObject = x.a(new m(paramb.azx().ilp));
    if (localObject != null) {}
    for (localObject = com.tencent.mm.sdk.platformtools.c.T((Bitmap)localObject);; localObject = null)
    {
      com.tencent.mm.plugin.card.compat.a.a locala1 = (com.tencent.mm.plugin.card.compat.a.a)g.r(com.tencent.mm.plugin.card.compat.a.a.class);
      if (paramb == null)
      {
        paramString2 = locala;
        locala1.b(paramString2, paramb.azx().bOL, paramb.azx().imA, paramString1, (byte[])localObject);
        return;
      }
      if (paramInt == 23) {
        paramInt = 2;
      }
      for (int i = 1;; i = 0)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        locala = new g.a();
        if (paramb.azx() != null)
        {
          locala.title = paramb.azz().tIn;
          locala.description = paramb.azx().title;
          locala.type = 16;
          locala.showType = 0;
          locala.dQy = 3;
          locala.appId = paramb.azx().bOL;
          locala.dQW = 0;
          locala.thumburl = paramb.azx().ilp;
          locala.dRM = paramInt;
          locala.dRL = paramb.azx().imA;
          locala.url = paramb.azx().sIw;
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("<from_username>").append(paramb.azD()).append("</from_username>");
        if (pe(paramInt))
        {
          localStringBuilder2.append("<card_id>").append(paramb.azC()).append("</card_id>");
          label297:
          localStringBuilder2.append("<card_type>").append(paramb.azx().ilo).append("</card_type>");
          localStringBuilder2.append("<from_scene>").append(paramInt).append("</from_scene>");
          localStringBuilder2.append("<color>").append(paramb.azx().color).append("</color>");
          localStringBuilder2.append("<card_type_name>").append(paramb.azx().imz).append("</card_type_name>");
          localStringBuilder2.append("<brand_name>").append(paramb.azx().imA).append("</brand_name>");
          if (!TextUtils.isEmpty(paramString2)) {
            break label535;
          }
          localStringBuilder2.append("<card_ext></card_ext>");
        }
        for (;;)
        {
          localStringBuilder2.append("<is_recommend>").append(i).append("</is_recommend>");
          localStringBuilder2.append("<recommend_card_id>").append(paramb.azB()).append("</recommend_card_id>");
          locala.dRK = localStringBuilder2.toString();
          locala.bQr = g.a.a(locala, null, null);
          paramString2 = locala;
          break;
          if (paramInt != 5) {
            break label297;
          }
          localStringBuilder2.append("<card_id>").append(paramb.azB()).append("</card_id>");
          break label297;
          label535:
          localStringBuilder2.append("<card_ext>").append(paramString2).append("</card_ext>");
        }
      }
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.card.model.b paramb, String paramString)
  {
    if (!cS(paramb.sJq))
    {
      y.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      return false;
    }
    paramb = paramb.title;
    if (yW(paramString))
    {
      y.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      return false;
    }
    y.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    return true;
  }
  
  public static boolean a(ShareCardInfo paramShareCardInfo)
  {
    if (paramShareCardInfo == null)
    {
      y.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
      return false;
    }
    ShareCardInfo localShareCardInfo = am.aAA().yy(paramShareCardInfo.field_card_id);
    if (localShareCardInfo == null)
    {
      bool = am.aAA().b(paramShareCardInfo);
      y.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        y.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
      }
      for (;;)
      {
        return bool;
        com.tencent.mm.plugin.card.sharecard.a.b.cu(paramShareCardInfo.field_card_id, paramShareCardInfo.field_card_tp_id);
      }
    }
    paramShareCardInfo.field_categoryType = localShareCardInfo.field_categoryType;
    paramShareCardInfo.field_itemIndex = localShareCardInfo.field_itemIndex;
    boolean bool = am.aAA().c(paramShareCardInfo, new String[0]);
    y.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean a(ra paramra, String paramString)
  {
    if (!cS(paramra.sJq))
    {
      y.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      return false;
    }
    paramra = paramra.title;
    if (yW(paramString))
    {
      y.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      return false;
    }
    y.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    return true;
  }
  
  public static void aDc()
  {
    Integer localInteger = (Integer)g.DP().Dz().get(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      y.i("MicroMsg.CardUtil", "card entrance is open");
      return;
    }
    y.i("MicroMsg.CardUtil", "open card entrance");
    g.DP().Dz().o(282883, Integer.valueOf(1));
  }
  
  public static boolean aDd()
  {
    Integer localInteger = (Integer)g.DP().Dz().get(282883, null);
    return (localInteger != null) && (localInteger.intValue() == 1);
  }
  
  public static void aDe()
  {
    Integer localInteger = (Integer)g.DP().Dz().get(ac.a.uph, Integer.valueOf(0));
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      y.i("MicroMsg.CardUtil", "share card entrance is open");
      return;
    }
    y.i("MicroMsg.CardUtil", "open share card entrance");
    g.DP().Dz().c(ac.a.uph, Integer.valueOf(1));
  }
  
  public static boolean aDf()
  {
    Integer localInteger = (Integer)g.DP().Dz().get(ac.a.uph, null);
    return (localInteger != null) && (localInteger.intValue() == 1);
  }
  
  public static String aDg()
  {
    return (String)g.DP().Dz().get(ac.a.upf, "");
  }
  
  public static List<com.tencent.mm.plugin.card.model.b> aR(List<mn> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      mn localmn = (mn)paramList.get(i);
      com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
      localb.title = localmn.title;
      localb.ilq = localmn.ilq;
      localb.ioU = localmn.ioU;
      localb.url = localmn.url;
      localb.sJq = localmn.sJq;
      localb.ilA = false;
      localb.sJr = localmn.sJr;
      localb.sJs = localmn.sJs;
      localb.iQn = localmn.iQn;
      localb.sIf = localmn.sIf;
      localb.sIg = localmn.sIg;
      localb.ilz = 1;
      localArrayList.add(localb);
      i += 1;
    }
    return localArrayList;
  }
  
  public static ArrayList<String> aS(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = com.tencent.mm.plugin.label.a.a.bdA().Go(com.tencent.mm.plugin.label.a.a.bdA().Gl((String)localObject));
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        y.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
      } else {
        localHashSet.addAll((Collection)localObject);
      }
    }
    localArrayList.addAll(localHashSet);
    return localArrayList;
  }
  
  public static ArrayList<String> aT(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      str = com.tencent.mm.plugin.label.a.a.bdA().Gl(str);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  public static ColorStateList ac(Context paramContext, String paramString)
  {
    int i = paramContext.getResources().getColor(a.a.white);
    int j = yR(paramString);
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j });
  }
  
  public static ShapeDrawable b(Context paramContext, int paramInt1, int paramInt2)
  {
    int i = paramContext.getResources().getDimensionPixelSize(a.b.OneDPPadding);
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
    return paramContext;
  }
  
  public static boolean b(CardInfo paramCardInfo)
  {
    if (paramCardInfo == null)
    {
      y.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
      return false;
    }
    CardInfo localCardInfo = am.aAs().yi(paramCardInfo.field_card_id);
    if (localCardInfo == null)
    {
      bool = am.aAs().b(paramCardInfo);
      y.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        y.e("MicroMsg.CardUtil", "processCardObject, insert fail");
      }
      return bool;
    }
    paramCardInfo.field_stickyIndex = localCardInfo.field_stickyIndex;
    paramCardInfo.field_stickyEndTime = localCardInfo.field_stickyEndTime;
    paramCardInfo.field_stickyAnnouncement = localCardInfo.field_stickyAnnouncement;
    boolean bool = am.aAs().c(paramCardInfo, new String[0]);
    y.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static int bq(String paramString, int paramInt)
  {
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      y.e("MicroMsg.CardUtil", "string format error");
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      paramInt = Color.argb(paramInt, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      return paramInt;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.CardUtil", paramString.toString());
    }
    return i;
  }
  
  public static void cC(String paramString1, String paramString2)
  {
    if (!bk.bl(paramString1))
    {
      pe localpe = new pe();
      localpe.bYQ.bYR = paramString2;
      localpe.bYQ.content = paramString1;
      localpe.bYQ.type = s.hW(paramString2);
      localpe.bYQ.flags = 0;
      com.tencent.mm.sdk.b.a.udP.m(localpe);
    }
  }
  
  private static boolean cS(long paramLong)
  {
    if ((0x8 & paramLong) > 0L)
    {
      y.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
      return true;
    }
    return false;
  }
  
  public static String ce(long paramLong)
  {
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (izc == null) {
      izc = new SimpleDateFormat("yyyy.MM.dd");
    }
    return izc.format(new Date(paramLong));
  }
  
  public static ShapeDrawable cx(int paramInt1, int paramInt2)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2 }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt1);
    return localShapeDrawable;
  }
  
  public static Drawable f(Context paramContext, String paramString, int paramInt)
  {
    paramContext = b(paramContext, yR(paramString), paramInt);
    paramString = cx(yR(paramString), paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramString);
    localStateListDrawable.addState(new int[0], paramContext);
    return localStateListDrawable;
  }
  
  public static bry f(int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    y.i("MicroMsg.CardUtil", "getShareTag()");
    bry localbry = new bry();
    String str;
    if (paramInt == 2)
    {
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
        localbry.tIx.addAll(paramArrayList1);
      }
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        paramArrayList1 = new ArrayList();
        paramInt = 0;
        while (paramInt < paramArrayList2.size())
        {
          str = (String)paramArrayList2.get(paramInt);
          if ((!TextUtils.isEmpty(str)) && (yS(str))) {
            paramArrayList1.add(Integer.valueOf(str));
          }
          paramInt += 1;
        }
        localbry.tIz.addAll(paramArrayList1);
      }
    }
    do
    {
      do
      {
        return localbry;
      } while (paramInt != 3);
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
        localbry.tIy.addAll(paramArrayList1);
      }
    } while ((paramArrayList2 == null) || (paramArrayList2.size() <= 0));
    paramArrayList1 = new ArrayList();
    paramInt = 0;
    while (paramInt < paramArrayList2.size())
    {
      str = (String)paramArrayList2.get(paramInt);
      if ((!TextUtils.isEmpty(str)) && (yS(str))) {
        paramArrayList1.add(Integer.valueOf(str));
      }
      paramInt += 1;
    }
    localbry.tIA.addAll(paramArrayList1);
    return localbry;
  }
  
  public static String f(Context paramContext, float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return "";
    }
    if ((paramFloat > 0.0F) && (paramFloat < 1000.0F)) {
      return paramContext.getString(a.g.card_distance_m, new Object[] { (int)paramFloat });
    }
    if (paramFloat >= 1000.0F)
    {
      int i = a.g.card_distance_km;
      StringBuilder localStringBuilder = new StringBuilder();
      paramFloat /= 1000.0F;
      return paramContext.getString(i, new Object[] { new DecimalFormat("0.00").format(paramFloat) });
    }
    return "";
  }
  
  public static boolean h(com.tencent.mm.plugin.card.base.b paramb)
  {
    boolean bool2;
    boolean bool1;
    if ((paramb instanceof CardInfo))
    {
      bool2 = am.aAs().c((CardInfo)paramb, new String[0]);
      bool1 = bool2;
      if (!bool2)
      {
        y.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.azB() });
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      if (!(paramb instanceof ShareCardInfo)) {
        break;
      }
      bool2 = am.aAA().c((ShareCardInfo)paramb, new String[0]);
      bool1 = bool2;
    } while (bool2);
    y.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.azB() });
    return bool2;
    return false;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean oN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean pe(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 9) || (paramInt == 12) || (paramInt == 17) || (paramInt == 21);
  }
  
  public static boolean pf(int paramInt)
  {
    return (paramInt == 7) || (paramInt == 8) || (paramInt == 16) || (paramInt == 26);
  }
  
  public static boolean pg(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 15);
  }
  
  public static Bitmap v(Bitmap paramBitmap)
  {
    boolean bool = true;
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    ((Matrix)localObject).setRotate(90.0F, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new StringBuilder("resultBmp is null: ");
    if (paramBitmap == null) {}
    for (;;)
    {
      y.d("MicroMsg.CardUtil", bool + "  degree:90.0");
      return paramBitmap;
      bool = false;
    }
  }
  
  public static void w(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      y.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
  }
  
  public static String y(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    float f1;
    float f2;
    do
    {
      return str;
      f1 = am.aAy().dib;
      f2 = am.aAy().dia;
      if ((f1 == -1000.0F) || (f2 == -85.0F))
      {
        y.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
        return paramString;
      }
      str = paramString;
    } while ((0x10 & paramLong) <= 0L);
    String str = "&longitude=" + f1 + "&latitude=" + f2;
    str = paramString.replace("#", str + "#");
    y.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:" + paramString);
    y.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:" + str);
    return str;
  }
  
  public static int yR(String paramString)
  {
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      y.e("MicroMsg.CardUtil", "string format error");
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      int j = Color.argb(255, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      return j;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.CardUtil", paramString.toString());
    }
    return i;
  }
  
  public static boolean yS(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public static void yT(String paramString)
  {
    g.DP().Dz().c(ac.a.upf, paramString);
  }
  
  public static String yU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str1;
    do
    {
      return paramString;
      String str2 = r.gW(paramString);
      str1 = r.gV(paramString);
      if (!TextUtils.isEmpty(str2)) {
        return str2;
      }
    } while (TextUtils.isEmpty(str1));
    return str1;
  }
  
  public static String yV(String paramString)
  {
    paramString = Arrays.asList(paramString.split(","));
    LinkedList localLinkedList = new LinkedList();
    if (g.DK()) {
      if ((paramString != null) && (paramString.size() != 0)) {}
    }
    for (;;)
    {
      return bk.c(localLinkedList, ",");
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ad localad = ((j)g.r(j.class)).Fw().abl(str);
        paramString = str;
        if (localad != null)
        {
          paramString = str;
          if ((int)localad.dBe != 0) {
            paramString = localad.Bq();
          }
        }
        localLinkedList.add(paramString);
      }
    }
  }
  
  private static boolean yW(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
      return true;
    }
    y.i("MicroMsg.CardUtil", "hasShowWarning()");
    Object localObject = (String)g.DP().Dz().get(ac.a.upm, "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      y.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
      return false;
    }
    localObject = ((String)localObject).split(",");
    if ((localObject == null) || (localObject.length == 0))
    {
      y.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(localObject[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void yX(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
      return;
    }
    y.i("MicroMsg.CardUtil", "setShowWarningFlag()");
    String str = (String)g.DP().Dz().get(ac.a.upm, "");
    if (TextUtils.isEmpty(str)) {
      y.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
    }
    for (;;)
    {
      g.DP().Dz().c(ac.a.upm, paramString);
      return;
      String[] arrayOfString = str.split(",");
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        y.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
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
  
  public static int yY(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(q.Gj()))) {
      return 1;
    }
    return 0;
  }
  
  public static ShapeDrawable z(Context paramContext, int paramInt)
  {
    return cx(paramInt, paramContext.getResources().getDimensionPixelOffset(a.b.card_btn_bg_corner));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.l
 * JD-Core Version:    0.7.0.1
 */