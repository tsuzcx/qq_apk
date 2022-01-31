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
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.aj;
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
  private static SimpleDateFormat kCj = null;
  private static SimpleDateFormat kCk = null;
  private static SimpleDateFormat kCl = null;
  
  public static Bitmap H(Bitmap paramBitmap)
  {
    boolean bool = true;
    AppMethodBeat.i(88892);
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    ((Matrix)localObject).setRotate(90.0F, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    localObject = new StringBuilder("resultBmp is null: ");
    if (paramBitmap == null) {}
    for (;;)
    {
      ab.d("MicroMsg.CardUtil", bool + "  degree:90.0");
      AppMethodBeat.o(88892);
      return paramBitmap;
      bool = false;
    }
  }
  
  public static String H(String paramString, long paramLong)
  {
    AppMethodBeat.i(88918);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(88918);
      return "";
    }
    float f1 = am.bcj().dZv;
    float f2 = am.bcj().dZu;
    if ((f1 == -1000.0F) || (f2 == -85.0F))
    {
      ab.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
      AppMethodBeat.o(88918);
      return paramString;
    }
    if ((0x10 & paramLong) > 0L)
    {
      String str = "&longitude=" + f1 + "&latitude=" + f2;
      str = paramString.replace("#", str + "#");
      ab.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:".concat(String.valueOf(paramString)));
      ab.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:".concat(String.valueOf(str)));
      AppMethodBeat.o(88918);
      return str;
    }
    AppMethodBeat.o(88918);
    return paramString;
  }
  
  public static ShapeDrawable I(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88886);
    paramContext = dR(paramInt, paramContext.getResources().getDimensionPixelOffset(2131428157));
    AppMethodBeat.o(88886);
    return paramContext;
  }
  
  public static void I(Bitmap paramBitmap)
  {
    AppMethodBeat.i(88893);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ab.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    AppMethodBeat.o(88893);
  }
  
  public static int IB(String paramString)
  {
    AppMethodBeat.i(88884);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      ab.e("MicroMsg.CardUtil", "string format error");
      AppMethodBeat.o(88884);
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      int j = Color.argb(255, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      AppMethodBeat.o(88884);
      return j;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.CardUtil", paramString.toString());
      AppMethodBeat.o(88884);
    }
    return i;
  }
  
  public static void IC(String paramString)
  {
    AppMethodBeat.i(88906);
    g.RL().Ru().set(ac.a.yzb, paramString);
    AppMethodBeat.o(88906);
  }
  
  public static String ID(String paramString)
  {
    AppMethodBeat.i(88908);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(88908);
      return "";
    }
    String str1 = s.nF(paramString);
    String str2 = s.nE(paramString);
    if (!TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(88908);
      return str1;
    }
    if (!TextUtils.isEmpty(str2))
    {
      AppMethodBeat.o(88908);
      return str2;
    }
    AppMethodBeat.o(88908);
    return paramString;
  }
  
  public static String IE(String paramString)
  {
    AppMethodBeat.i(88911);
    paramString = Arrays.asList(paramString.split(","));
    LinkedList localLinkedList = new LinkedList();
    if (g.RG()) {
      if ((paramString != null) && (paramString.size() != 0)) {}
    }
    for (;;)
    {
      paramString = bo.d(localLinkedList, ",");
      AppMethodBeat.o(88911);
      return paramString;
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ad localad = ((j)g.E(j.class)).YA().arw(str);
        paramString = str;
        if (localad != null)
        {
          paramString = str;
          if ((int)localad.euF != 0) {
            paramString = localad.Of();
          }
        }
        localLinkedList.add(paramString);
      }
    }
  }
  
  private static boolean IF(String paramString)
  {
    AppMethodBeat.i(88916);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
      AppMethodBeat.o(88916);
      return true;
    }
    ab.i("MicroMsg.CardUtil", "hasShowWarning()");
    Object localObject = (String)g.RL().Ru().get(ac.a.yzi, "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ab.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
      AppMethodBeat.o(88916);
      return false;
    }
    localObject = ((String)localObject).split(",");
    if ((localObject == null) || (localObject.length == 0))
    {
      ab.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
      AppMethodBeat.o(88916);
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(localObject[i]))
      {
        AppMethodBeat.o(88916);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(88916);
    return false;
  }
  
  public static void IG(String paramString)
  {
    AppMethodBeat.i(88917);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
      AppMethodBeat.o(88917);
      return;
    }
    ab.i("MicroMsg.CardUtil", "setShowWarningFlag()");
    String str = (String)g.RL().Ru().get(ac.a.yzi, "");
    if (TextUtils.isEmpty(str)) {
      ab.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
    }
    for (;;)
    {
      g.RL().Ru().set(ac.a.yzi, paramString);
      AppMethodBeat.o(88917);
      return;
      String[] arrayOfString = str.split(",");
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        ab.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
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
  
  public static int IH(String paramString)
  {
    AppMethodBeat.i(88919);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(r.Zn())))
    {
      AppMethodBeat.o(88919);
      return 1;
    }
    AppMethodBeat.o(88919);
    return 0;
  }
  
  public static ccj a(int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(88912);
    ab.i("MicroMsg.CardUtil", "getShareTag()");
    ccj localccj = new ccj();
    String str;
    if (paramInt == 2)
    {
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
        localccj.xML.addAll(paramArrayList1);
      }
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        paramArrayList1 = new ArrayList();
        paramInt = 0;
        while (paramInt < paramArrayList2.size())
        {
          str = (String)paramArrayList2.get(paramInt);
          if ((!TextUtils.isEmpty(str)) && (isNumeric(str))) {
            paramArrayList1.add(Integer.valueOf(str));
          }
          paramInt += 1;
        }
        localccj.xMN.addAll(paramArrayList1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(88912);
      return localccj;
      if (paramInt == 3)
      {
        if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
          localccj.xMM.addAll(paramArrayList1);
        }
        if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
        {
          paramArrayList1 = new ArrayList();
          paramInt = 0;
          while (paramInt < paramArrayList2.size())
          {
            str = (String)paramArrayList2.get(paramInt);
            if ((!TextUtils.isEmpty(str)) && (isNumeric(str))) {
              paramArrayList1.add(Integer.valueOf(str));
            }
            paramInt += 1;
          }
          localccj.xMO.addAll(paramArrayList1);
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.card.base.b paramb, String paramString1, String paramString2, int paramInt)
  {
    j.b localb = null;
    AppMethodBeat.i(88895);
    Object localObject = x.a(new m(paramb.bbd().kmm));
    if (localObject != null) {}
    for (localObject = d.ai((Bitmap)localObject);; localObject = null)
    {
      com.tencent.mm.plugin.card.compat.a.a locala = (com.tencent.mm.plugin.card.compat.a.a)g.E(com.tencent.mm.plugin.card.compat.a.a.class);
      if (paramb == null)
      {
        paramString2 = localb;
        locala.b(paramString2, paramb.bbd().cwc, paramb.bbd().knw, paramString1, (byte[])localObject);
        AppMethodBeat.o(88895);
        return;
      }
      if (paramInt == 23) {
        paramInt = 2;
      }
      for (int i = 1;; i = 0)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localb = new j.b();
        if (paramb.bbd() != null)
        {
          localb.title = paramb.bbf().xMB;
          localb.description = paramb.bbd().title;
          localb.type = 16;
          localb.showType = 0;
          localb.fgz = 3;
          localb.appId = paramb.bbd().cwc;
          localb.fgh = 0;
          localb.thumburl = paramb.bbd().kmm;
          localb.fhL = paramInt;
          localb.fhK = paramb.bbd().knw;
          localb.url = paramb.bbd().wGf;
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("<from_username>").append(paramb.bbj()).append("</from_username>");
        if (tt(paramInt))
        {
          localStringBuilder2.append("<card_id>").append(paramb.bbi()).append("</card_id>");
          label314:
          localStringBuilder2.append("<card_type>").append(paramb.bbd().iFL).append("</card_type>");
          localStringBuilder2.append("<from_scene>").append(paramInt).append("</from_scene>");
          localStringBuilder2.append("<color>").append(paramb.bbd().color).append("</color>");
          localStringBuilder2.append("<card_type_name>").append(paramb.bbd().knv).append("</card_type_name>");
          localStringBuilder2.append("<brand_name>").append(paramb.bbd().knw).append("</brand_name>");
          if (!TextUtils.isEmpty(paramString2)) {
            break label569;
          }
          localStringBuilder2.append("<card_ext></card_ext>");
        }
        for (;;)
        {
          localStringBuilder2.append("<is_recommend>").append(i).append("</is_recommend>");
          localStringBuilder2.append("<recommend_card_id>").append(paramb.bbh()).append("</recommend_card_id>");
          localb.fhJ = localStringBuilder2.toString();
          localb.cxK = j.b.a(localb, null, null);
          paramString2 = localb;
          break;
          if (paramInt != 5) {
            break label314;
          }
          localStringBuilder2.append("<card_id>").append(paramb.bbh()).append("</card_id>");
          break label314;
          label569:
          localStringBuilder2.append("<card_ext>").append(paramString2).append("</card_ext>");
        }
      }
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.card.model.b paramb, String paramString)
  {
    AppMethodBeat.i(88914);
    if (!ig(paramb.wGZ))
    {
      ab.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      AppMethodBeat.o(88914);
      return false;
    }
    if (IF(paramString))
    {
      ab.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      AppMethodBeat.o(88914);
      return false;
    }
    ab.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    AppMethodBeat.o(88914);
    return true;
  }
  
  public static boolean a(ShareCardInfo paramShareCardInfo)
  {
    AppMethodBeat.i(88904);
    if (paramShareCardInfo == null)
    {
      ab.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
      AppMethodBeat.o(88904);
      return false;
    }
    ShareCardInfo localShareCardInfo = am.bcl().HZ(paramShareCardInfo.field_card_id);
    if (localShareCardInfo == null)
    {
      bool = am.bcl().insert(paramShareCardInfo);
      ab.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        ab.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
      }
      for (;;)
      {
        AppMethodBeat.o(88904);
        return bool;
        com.tencent.mm.plugin.card.sharecard.a.b.dr(paramShareCardInfo.field_card_id, paramShareCardInfo.field_card_tp_id);
      }
    }
    paramShareCardInfo.field_categoryType = localShareCardInfo.field_categoryType;
    paramShareCardInfo.field_itemIndex = localShareCardInfo.field_itemIndex;
    boolean bool = am.bcl().update(paramShareCardInfo, new String[0]);
    ab.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(88904);
    return bool;
  }
  
  public static boolean a(uo paramuo, String paramString)
  {
    AppMethodBeat.i(88913);
    if (!ig(paramuo.wGZ))
    {
      ab.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      AppMethodBeat.o(88913);
      return false;
    }
    if (IF(paramString))
    {
      ab.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      AppMethodBeat.o(88913);
      return false;
    }
    ab.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    AppMethodBeat.o(88913);
    return true;
  }
  
  public static ColorStateList ag(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88921);
    int i = paramContext.getResources().getColor(2131690709);
    int j = IB(paramString);
    paramContext = new int[0];
    paramContext = new ColorStateList(new int[][] { { 16842919, 16842910 }, paramContext }, new int[] { i, j });
    AppMethodBeat.o(88921);
    return paramContext;
  }
  
  public static boolean agR()
  {
    AppMethodBeat.i(88902);
    try
    {
      boolean bool = ((LocationManager)ah.getContext().getSystemService("location")).isProviderEnabled("gps");
      AppMethodBeat.o(88902);
      return bool;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.CardUtil", localException, "", new Object[0]);
      AppMethodBeat.o(88902);
    }
    return false;
  }
  
  public static boolean agS()
  {
    AppMethodBeat.i(88903);
    try
    {
      boolean bool = ((LocationManager)ah.getContext().getSystemService("location")).isProviderEnabled("network");
      AppMethodBeat.o(88903);
      return bool;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.CardUtil", localException, "", new Object[0]);
      AppMethodBeat.o(88903);
    }
    return false;
  }
  
  public static void ah(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88924);
    if (!bo.isNullOrNil(paramString))
    {
      Toast.makeText(ah.getContext(), paramString, 1).show();
      AppMethodBeat.o(88924);
      return;
    }
    h.b(paramContext, paramContext.getString(2131298085), "", false);
    AppMethodBeat.o(88924);
  }
  
  public static void ai(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88925);
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = paramContext.getString(2131298085);
    }
    h.b(paramContext, str, "", false);
    AppMethodBeat.o(88925);
  }
  
  public static ShapeDrawable b(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88888);
    int i = paramContext.getResources().getDimensionPixelSize(2131427811);
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
    AppMethodBeat.o(88888);
    return paramContext;
  }
  
  public static boolean b(CardInfo paramCardInfo)
  {
    AppMethodBeat.i(88894);
    if (paramCardInfo == null)
    {
      ab.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
      AppMethodBeat.o(88894);
      return false;
    }
    CardInfo localCardInfo = am.bcd().HJ(paramCardInfo.field_card_id);
    if (localCardInfo == null)
    {
      bool = am.bcd().insert(paramCardInfo);
      ab.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        ab.e("MicroMsg.CardUtil", "processCardObject, insert fail");
      }
      AppMethodBeat.o(88894);
      return bool;
    }
    paramCardInfo.field_stickyIndex = localCardInfo.field_stickyIndex;
    paramCardInfo.field_stickyEndTime = localCardInfo.field_stickyEndTime;
    paramCardInfo.field_stickyAnnouncement = localCardInfo.field_stickyAnnouncement;
    boolean bool = am.bcd().update(paramCardInfo, new String[0]);
    ab.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(88894);
    return bool;
  }
  
  public static int bS(String paramString, int paramInt)
  {
    AppMethodBeat.i(88885);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      ab.e("MicroMsg.CardUtil", "string format error");
      AppMethodBeat.o(88885);
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      paramInt = Color.argb(paramInt, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      AppMethodBeat.o(88885);
      return paramInt;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.CardUtil", paramString.toString());
      AppMethodBeat.o(88885);
    }
    return i;
  }
  
  public static int bT(String paramString, int paramInt)
  {
    AppMethodBeat.i(88922);
    paramInt = dS(Color.parseColor(paramString), paramInt);
    AppMethodBeat.o(88922);
    return paramInt;
  }
  
  public static boolean bfA()
  {
    AppMethodBeat.i(88898);
    Integer localInteger = (Integer)g.RL().Ru().get(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      AppMethodBeat.o(88898);
      return true;
    }
    AppMethodBeat.o(88898);
    return false;
  }
  
  public static void bfB()
  {
    AppMethodBeat.i(88899);
    Integer localInteger = (Integer)g.RL().Ru().get(ac.a.yzd, Integer.valueOf(0));
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      ab.i("MicroMsg.CardUtil", "share card entrance is open");
      AppMethodBeat.o(88899);
      return;
    }
    ab.i("MicroMsg.CardUtil", "open share card entrance");
    g.RL().Ru().set(ac.a.yzd, Integer.valueOf(1));
    AppMethodBeat.o(88899);
  }
  
  public static boolean bfC()
  {
    AppMethodBeat.i(88900);
    Integer localInteger = (Integer)g.RL().Ru().get(ac.a.yzd, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      AppMethodBeat.o(88900);
      return true;
    }
    AppMethodBeat.o(88900);
    return false;
  }
  
  public static String bfD()
  {
    AppMethodBeat.i(88907);
    String str = (String)g.RL().Ru().get(ac.a.yzb, "");
    AppMethodBeat.o(88907);
    return str;
  }
  
  public static void bfz()
  {
    AppMethodBeat.i(88897);
    Integer localInteger = (Integer)g.RL().Ru().get(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      ab.i("MicroMsg.CardUtil", "card entrance is open");
      AppMethodBeat.o(88897);
      return;
    }
    ab.i("MicroMsg.CardUtil", "open card entrance");
    g.RL().Ru().set(282883, Integer.valueOf(1));
    AppMethodBeat.o(88897);
  }
  
  public static List<com.tencent.mm.plugin.card.model.b> bg(List<pn> paramList)
  {
    AppMethodBeat.i(88889);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(88889);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      pn localpn = (pn)paramList.get(i);
      com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
      localb.title = localpn.title;
      localb.kmn = localpn.kmn;
      localb.kqb = localpn.kqb;
      localb.url = localpn.url;
      localb.wGZ = localpn.wGZ;
      localb.kmy = false;
      localb.wHa = localpn.wHa;
      localb.wHb = localpn.wHb;
      localb.kWy = localpn.kWy;
      localb.wFL = localpn.wFL;
      localb.wFM = localpn.wFM;
      localb.kmx = 1;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(88889);
    return localArrayList;
  }
  
  public static ArrayList<String> bh(List<String> paramList)
  {
    AppMethodBeat.i(88909);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
      AppMethodBeat.o(88909);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = com.tencent.mm.plugin.label.a.a.bKV().RR(com.tencent.mm.plugin.label.a.a.bKV().RO((String)localObject));
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        ab.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
      } else {
        localHashSet.addAll((Collection)localObject);
      }
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(88909);
    return localArrayList;
  }
  
  public static ArrayList<String> bi(List<String> paramList)
  {
    AppMethodBeat.i(88910);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
      AppMethodBeat.o(88910);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      str = com.tencent.mm.plugin.label.a.a.bKV().RO(str);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    AppMethodBeat.o(88910);
    return localArrayList;
  }
  
  public static ShapeDrawable dR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88887);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2 }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt1);
    AppMethodBeat.o(88887);
    return localShapeDrawable;
  }
  
  public static int dS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88923);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(88923);
      return paramInt1;
    }
    paramInt1 = aj.dS(paramInt1, paramInt2);
    AppMethodBeat.o(88923);
    return paramInt1;
  }
  
  public static void dz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88896);
    if (!bo.isNullOrNil(paramString1))
    {
      qj localqj = new qj();
      localqj.cGX.cGY = paramString2;
      localqj.cGX.content = paramString1;
      localqj.cGX.type = t.oF(paramString2);
      localqj.cGX.flags = 0;
      com.tencent.mm.sdk.b.a.ymk.l(localqj);
    }
    AppMethodBeat.o(88896);
  }
  
  public static Drawable g(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(88920);
    paramContext = b(paramContext, IB(paramString), paramInt);
    paramString = dR(IB(paramString), paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramString);
    localStateListDrawable.addState(new int[0], paramContext);
    AppMethodBeat.o(88920);
    return localStateListDrawable;
  }
  
  public static String g(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(88901);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(88901);
      return "";
    }
    if ((paramFloat > 0.0F) && (paramFloat < 1000.0F))
    {
      paramContext = paramContext.getString(2131297900, new Object[] { (int)paramFloat });
      AppMethodBeat.o(88901);
      return paramContext;
    }
    if (paramFloat >= 1000.0F)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramFloat /= 1000.0F;
      paramContext = paramContext.getString(2131297899, new Object[] { new DecimalFormat("0.00").format(paramFloat) });
      AppMethodBeat.o(88901);
      return paramContext;
    }
    AppMethodBeat.o(88901);
    return "";
  }
  
  public static boolean h(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88905);
    boolean bool2;
    boolean bool1;
    if ((paramb instanceof CardInfo))
    {
      bool2 = am.bcd().update((CardInfo)paramb, new String[0]);
      bool1 = bool2;
      if (!bool2)
      {
        ab.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.bbh() });
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(88905);
      return bool1;
      if ((paramb instanceof ShareCardInfo))
      {
        bool2 = am.bcl().update((ShareCardInfo)paramb, new String[0]);
        bool1 = bool2;
        if (!bool2)
        {
          ab.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.bbh() });
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public static String ha(long paramLong)
  {
    AppMethodBeat.i(88890);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (kCj == null) {
      kCj = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = kCj.format(new Date(paramLong));
    AppMethodBeat.o(88890);
    return str;
  }
  
  private static boolean ig(long paramLong)
  {
    AppMethodBeat.i(88915);
    if ((0x8 & paramLong) > 0L)
    {
      ab.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
      AppMethodBeat.o(88915);
      return true;
    }
    AppMethodBeat.o(88915);
    return false;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(88883);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED))
      {
        AppMethodBeat.o(88883);
        return true;
      }
    }
    AppMethodBeat.o(88883);
    return false;
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(88891);
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(88891);
    return bool;
  }
  
  public static boolean sX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean tt(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 9) || (paramInt == 12) || (paramInt == 17) || (paramInt == 21);
  }
  
  public static boolean tu(int paramInt)
  {
    return (paramInt == 7) || (paramInt == 8) || (paramInt == 16) || (paramInt == 26);
  }
  
  public static boolean tv(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.l
 * JD-Core Version:    0.7.0.1
 */