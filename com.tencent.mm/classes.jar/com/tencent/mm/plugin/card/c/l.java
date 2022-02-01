package com.tencent.mm.plugin.card.c;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.fbz;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bb;
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
import org.json.JSONObject;

public final class l
{
  private static SimpleDateFormat wKu = null;
  private static SimpleDateFormat wKv = null;
  private static SimpleDateFormat wKw = null;
  
  public static boolean IL(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 9) || (paramInt == 12) || (paramInt == 17) || (paramInt == 21);
  }
  
  public static boolean IM(int paramInt)
  {
    return (paramInt == 7) || (paramInt == 8) || (paramInt == 16) || (paramInt == 26);
  }
  
  public static boolean IN(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 15);
  }
  
  public static boolean Ii(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static fbz a(int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(113840);
    Log.i("MicroMsg.CardUtil", "getShareTag()");
    fbz localfbz = new fbz();
    String str;
    if (paramInt == 2)
    {
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
        localfbz.abBA.addAll(paramArrayList1);
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
        localfbz.abBC.addAll(paramArrayList1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113840);
      return localfbz;
      if (paramInt == 3)
      {
        if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
          localfbz.abBB.addAll(paramArrayList1);
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
          localfbz.abBD.addAll(paramArrayList1);
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.card.base.b paramb, String paramString1, String paramString2, int paramInt)
  {
    k.b localb = null;
    AppMethodBeat.i(113823);
    Object localObject = r.a(new m(paramb.djK().nQG));
    if (localObject != null) {}
    for (localObject = BitmapUtil.Bitmap2Bytes((Bitmap)localObject);; localObject = null)
    {
      com.tencent.mm.plugin.card.compat.a.a locala = (com.tencent.mm.plugin.card.compat.a.a)h.ax(com.tencent.mm.plugin.card.compat.a.a.class);
      if (paramb == null)
      {
        paramString2 = localb;
        locala.a(paramString2, paramb.djK().appid, paramb.djK().mee, paramString1, (byte[])localObject);
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
        if (paramb.djK() != null)
        {
          localb.title = paramb.djM().abBp;
          localb.description = paramb.djK().title;
          localb.type = 16;
          localb.hAN = 0;
          localb.nRg = 3;
          localb.appId = paramb.djK().appid;
          localb.nQm = 0;
          localb.thumburl = paramb.djK().nQG;
          localb.nSp = paramInt;
          localb.nSo = paramb.djK().mee;
          localb.url = paramb.djK().ZdP;
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("<from_username>").append(paramb.djQ()).append("</from_username>");
        if (IL(paramInt))
        {
          localStringBuilder2.append("<card_id>").append(paramb.djP()).append("</card_id>");
          label307:
          localStringBuilder2.append("<card_type>").append(paramb.djK().tNW).append("</card_type>");
          localStringBuilder2.append("<from_scene>").append(paramInt).append("</from_scene>");
          localStringBuilder2.append("<color>").append(paramb.djK().nRQ).append("</color>");
          localStringBuilder2.append("<card_type_name>").append(paramb.djK().wtN).append("</card_type_name>");
          localStringBuilder2.append("<brand_name>").append(paramb.djK().mee).append("</brand_name>");
          if (!TextUtils.isEmpty(paramString2)) {
            break label553;
          }
          localStringBuilder2.append("<card_ext></card_ext>");
        }
        for (;;)
        {
          localStringBuilder2.append("<is_recommend>").append(i).append("</is_recommend>");
          localStringBuilder2.append("<recommend_card_id>").append(paramb.djO()).append("</recommend_card_id>");
          localb.nSn = localStringBuilder2.toString();
          localb.hOj = k.b.a(localb, null, null);
          paramString2 = localb;
          break;
          if (paramInt != 5) {
            break label307;
          }
          localStringBuilder2.append("<card_id>").append(paramb.djO()).append("</card_id>");
          break label307;
          label553:
          localStringBuilder2.append("<card_ext>").append(paramString2).append("</card_ext>");
        }
      }
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.card.model.b paramb, String paramString)
  {
    AppMethodBeat.i(113842);
    if (!kw(paramb.ZeU))
    {
      Log.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      AppMethodBeat.o(113842);
      return false;
    }
    if (alz(paramString))
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
    ShareCardInfo localShareCardInfo = am.dkR().akS(paramShareCardInfo.field_card_id);
    if (localShareCardInfo == null)
    {
      bool = am.dkR().insert(paramShareCardInfo);
      Log.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        Log.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
      }
      for (;;)
      {
        AppMethodBeat.o(113832);
        return bool;
        com.tencent.mm.plugin.card.sharecard.a.b.gg(paramShareCardInfo.field_card_id, paramShareCardInfo.field_card_tp_id);
      }
    }
    paramShareCardInfo.field_categoryType = localShareCardInfo.field_categoryType;
    paramShareCardInfo.field_itemIndex = localShareCardInfo.field_itemIndex;
    boolean bool = am.dkR().update(paramShareCardInfo, new String[0]);
    Log.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(113832);
    return bool;
  }
  
  public static boolean a(aek paramaek, String paramString)
  {
    AppMethodBeat.i(113841);
    if (!kw(paramaek.ZeU))
    {
      Log.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
      AppMethodBeat.o(113841);
      return false;
    }
    if (alz(paramString))
    {
      Log.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
      AppMethodBeat.o(113841);
      return false;
    }
    Log.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
    AppMethodBeat.o(113841);
    return true;
  }
  
  public static String ad(String paramString, long paramLong)
  {
    AppMethodBeat.i(113846);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113846);
      return "";
    }
    float f1 = am.dkP().lsA;
    float f2 = am.dkP().lsz;
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
  
  public static Bitmap ag(Bitmap paramBitmap)
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
  
  public static ShapeDrawable ag(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(113814);
    paramContext = gx(paramInt, paramContext.getResources().getDimensionPixelOffset(a.b.wdJ));
    AppMethodBeat.o(113814);
    return paramContext;
  }
  
  public static void ah(Bitmap paramBitmap)
  {
    AppMethodBeat.i(113821);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    AppMethodBeat.o(113821);
  }
  
  public static void alA(String paramString)
  {
    AppMethodBeat.i(113845);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
      AppMethodBeat.o(113845);
      return;
    }
    Log.i("MicroMsg.CardUtil", "setShowWarningFlag()");
    String str = (String)h.baE().ban().get(at.a.acJC, "");
    if (TextUtils.isEmpty(str)) {
      Log.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
    }
    for (;;)
    {
      h.baE().ban().set(at.a.acJC, paramString);
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
  
  public static int alB(String paramString)
  {
    AppMethodBeat.i(113847);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(z.bAM())))
    {
      AppMethodBeat.o(113847);
      return 1;
    }
    AppMethodBeat.o(113847);
    return 0;
  }
  
  public static int alv(String paramString)
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
  
  public static void alw(String paramString)
  {
    AppMethodBeat.i(113834);
    h.baE().ban().set(at.a.acJv, paramString);
    AppMethodBeat.o(113834);
  }
  
  public static String alx(String paramString)
  {
    AppMethodBeat.i(113836);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113836);
      return "";
    }
    String str1 = aa.IE(paramString);
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
  
  public static String aly(String paramString)
  {
    AppMethodBeat.i(113839);
    paramString = Arrays.asList(paramString.split(","));
    LinkedList localLinkedList = new LinkedList();
    if (h.baz()) {
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
        au localau = ((n)h.ax(n.class)).bzA().JE(str);
        paramString = str;
        if (localau != null)
        {
          paramString = str;
          if ((int)localau.maN != 0) {
            paramString = localau.aSV();
          }
        }
        localLinkedList.add(paramString);
      }
    }
  }
  
  private static boolean alz(String paramString)
  {
    AppMethodBeat.i(113844);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
      AppMethodBeat.o(113844);
      return true;
    }
    Log.i("MicroMsg.CardUtil", "hasShowWarning()");
    Object localObject = (String)h.baE().ban().get(at.a.acJC, "");
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
  
  public static ColorStateList aq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113849);
    int i = paramContext.getResources().getColor(a.a.white_text_color);
    int j = alv(paramString);
    paramContext = new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j });
    AppMethodBeat.o(113849);
    return paramContext;
  }
  
  public static void ar(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113852);
    if (!Util.isNullOrNil(paramString))
    {
      Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
      AppMethodBeat.o(113852);
      return;
    }
    com.tencent.mm.ui.base.k.c(paramContext, paramContext.getString(a.g.wqJ), "", false);
    AppMethodBeat.o(113852);
  }
  
  public static void as(Context paramContext, String paramString)
  {
    AppMethodBeat.i(113853);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = paramContext.getString(a.g.wqJ);
    }
    com.tencent.mm.ui.base.k.c(paramContext, str, "", false);
    AppMethodBeat.o(113853);
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(293745);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      Log.e("MicroMsg.CardUtil", "getRoundedCornerBitmap in bitmap is null");
      AppMethodBeat.o(293745);
      return null;
    }
    Bitmap localBitmap = BitmapUtil.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888, false);
    if (localBitmap == null)
    {
      AppMethodBeat.o(293745);
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    Log.i("MicroMsg.CardUtil", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
    paramBitmap.recycle();
    AppMethodBeat.o(293745);
    return localBitmap;
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
    CardInfo localCardInfo = am.dkJ().akC(paramCardInfo.field_card_id);
    if (localCardInfo == null)
    {
      bool = am.dkJ().insert(paramCardInfo);
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
    boolean bool = am.dkJ().update(paramCardInfo, new String[0]);
    Log.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(113822);
    return bool;
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
  
  public static int dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(113850);
    paramInt = gy(Color.parseColor(paramString), paramInt);
    AppMethodBeat.o(113850);
    return paramInt;
  }
  
  public static boolean doN()
  {
    AppMethodBeat.i(293740);
    Object localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()) && (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED))
      {
        AppMethodBeat.o(293740);
        return true;
      }
    }
    AppMethodBeat.o(293740);
    return false;
  }
  
  public static void doO()
  {
    AppMethodBeat.i(113825);
    Integer localInteger = (Integer)h.baE().ban().d(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      Log.i("MicroMsg.CardUtil", "card entrance is open");
      AppMethodBeat.o(113825);
      return;
    }
    Log.i("MicroMsg.CardUtil", "open card entrance");
    h.baE().ban().B(282883, Integer.valueOf(1));
    AppMethodBeat.o(113825);
  }
  
  public static boolean doP()
  {
    AppMethodBeat.i(113826);
    Integer localInteger = (Integer)h.baE().ban().d(282883, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      AppMethodBeat.o(113826);
      return true;
    }
    AppMethodBeat.o(113826);
    return false;
  }
  
  public static void doQ()
  {
    AppMethodBeat.i(113827);
    Integer localInteger = (Integer)h.baE().ban().get(at.a.acJx, Integer.valueOf(0));
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      Log.i("MicroMsg.CardUtil", "share card entrance is open");
      AppMethodBeat.o(113827);
      return;
    }
    Log.i("MicroMsg.CardUtil", "open share card entrance");
    h.baE().ban().set(at.a.acJx, Integer.valueOf(1));
    AppMethodBeat.o(113827);
  }
  
  public static boolean doR()
  {
    AppMethodBeat.i(113828);
    Integer localInteger = (Integer)h.baE().ban().get(at.a.acJx, null);
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      AppMethodBeat.o(113828);
      return true;
    }
    AppMethodBeat.o(113828);
    return false;
  }
  
  public static String doS()
  {
    AppMethodBeat.i(113835);
    String str = (String)h.baE().ban().get(at.a.acJv, "");
    AppMethodBeat.o(113835);
    return str;
  }
  
  public static String doT()
  {
    AppMethodBeat.i(293763);
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("EnterScene", 3);
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(293763);
    }
    return "";
  }
  
  public static ShapeDrawable e(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113816);
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
    AppMethodBeat.o(113816);
    return paramContext;
  }
  
  public static List<com.tencent.mm.plugin.card.model.b> eP(List<xd> paramList)
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
      xd localxd = (xd)paramList.get(i);
      com.tencent.mm.plugin.card.model.b localb = new com.tencent.mm.plugin.card.model.b();
      localb.title = localxd.title;
      localb.wsz = localxd.wsz;
      localb.lym = localxd.lym;
      localb.url = localxd.url;
      localb.ZeU = localxd.ZeU;
      localb.wsJ = false;
      localb.ZeV = localxd.ZeV;
      localb.ZeW = localxd.ZeW;
      localb.icon_url = localxd.icon_url;
      localb.Zdw = localxd.Zdw;
      localb.Zdx = localxd.Zdx;
      localb.YIZ = localxd.YIZ;
      localb.ZeX = localxd.ZeX;
      localb.mdD = localxd.mdD;
      localb.wsI = 1;
      localArrayList.add(localb);
      i += 1;
    }
    AppMethodBeat.o(113817);
    return localArrayList;
  }
  
  public static ArrayList<String> eQ(List<String> paramList)
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
      localObject = com.tencent.mm.plugin.label.a.a.fTb().aJK(com.tencent.mm.plugin.label.a.a.fTb().aJH((String)localObject));
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
  
  public static ArrayList<String> eR(List<String> paramList)
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
      str = com.tencent.mm.plugin.label.a.a.fTb().aJH(str);
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    AppMethodBeat.o(113838);
    return localArrayList;
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
      paramContext = paramContext.getString(a.g.woA, new Object[] { (int)paramFloat });
      AppMethodBeat.o(113829);
      return paramContext;
    }
    if (paramFloat >= 1000.0F)
    {
      int i = a.g.woz;
      StringBuilder localStringBuilder = new StringBuilder();
      paramFloat /= 1000.0F;
      paramContext = paramContext.getString(i, new Object[] { new DecimalFormat("0.00").format(paramFloat) });
      AppMethodBeat.o(113829);
      return paramContext;
    }
    AppMethodBeat.o(113829);
    return "";
  }
  
  public static void f(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(293738);
    r.a(new l.1(paramString, paramImageView));
    paramString = r.a(new m(paramString));
    if (paramString != null) {
      paramImageView.setImageBitmap(paramString);
    }
    AppMethodBeat.o(293738);
  }
  
  public static Drawable g(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(113848);
    paramContext = e(paramContext, alv(paramString), paramInt);
    paramString = gx(alv(paramString), paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramString);
    localStateListDrawable.addState(new int[0], paramContext);
    AppMethodBeat.o(113848);
    return localStateListDrawable;
  }
  
  public static void go(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113824);
    if (!Util.isNullOrNil(paramString1))
    {
      wp localwp = new wp();
      localwp.iak.hgl = paramString2;
      localwp.iak.content = paramString1;
      localwp.iak.type = ab.IX(paramString2);
      localwp.iak.flags = 0;
      localwp.publish();
    }
    AppMethodBeat.o(113824);
  }
  
  public static ShapeDrawable gx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113815);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2, paramInt2 }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt1);
    AppMethodBeat.o(113815);
    return localShapeDrawable;
  }
  
  public static int gy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113851);
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(113851);
      return paramInt1;
    }
    paramInt1 = bb.gy(paramInt1, paramInt2);
    AppMethodBeat.o(113851);
    return paramInt1;
  }
  
  public static boolean h(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113833);
    boolean bool2;
    boolean bool1;
    if ((paramb instanceof CardInfo))
    {
      bool2 = am.dkJ().update((CardInfo)paramb, new String[0]);
      bool1 = bool2;
      if (!bool2)
      {
        Log.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.djO() });
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(113833);
      return bool1;
      if ((paramb instanceof ShareCardInfo))
      {
        bool2 = am.dkR().update((ShareCardInfo)paramb, new String[0]);
        bool1 = bool2;
        if (!bool2)
        {
          Log.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", new Object[] { paramb.djO() });
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public static String iY(long paramLong)
  {
    AppMethodBeat.i(113818);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (wKu == null) {
      wKu = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = wKu.format(new Date(paramLong));
    AppMethodBeat.o(113818);
    return str;
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(113819);
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(113819);
    return bool;
  }
  
  private static boolean kw(long paramLong)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.l
 * JD-Core Version:    0.7.0.1
 */