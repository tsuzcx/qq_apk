package com.tencent.mm.plugin.finder.utils;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.f;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.w.a.a.a.i;
import com.tencent.threadpool.i;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.n.n;
import kotlin.r;
import kotlin.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil2;", "", "()V", "CARE_MEDIA_TYPE", "", "", "getCARE_MEDIA_TYPE", "()Ljava/util/List;", "CARE_MEDIA_TYPE$delegate", "Lkotlin/Lazy;", "FAST_CLICK_DELAY_TIME_MS", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "OTHER_CARE_REPORT_RV_TYPE", "", "getOTHER_CARE_REPORT_RV_TYPE", "()Ljava/util/Set;", "TAG", "", "lastClickTime", "", "buildBeforeJoinLiveStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBeforeJoinLiveRoomStatus;", "buildConvertFailMsg", "", "logPrefix", "type", "buildJson", "maps", "", "calculateLayoutParams", "Lkotlin/Pair;", "scaleType", "containerWidth", "containerHeight", "videoWidth", "videoHeight", "calculateLongVideoTLLayoutParams", "Lkotlin/Triple;", "context", "Landroid/content/Context;", "originWidth", "originHeight", "calculateTimelineLayoutParams", "width", "height", "canShare", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "centerCrop", "centerFit", "convertCompatibilityMediaType", "obj", "convertToLiveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "toWhere", "forceFetchObject", "filterText", "origin", "foldView", "view", "Landroid/view/View;", "sourceSize", "destSize", "duration", "finishCallback", "Lkotlin/Function0;", "genClientMsgId", "genCoverUrlByMedia", "media", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getDisplayName", "username", "nickname", "printLog", "getFinderLiveNoticeTips", "time", "forceDate", "needDayOfWeek", "(JLjava/lang/Boolean;Z)Ljava/lang/String;", "getHint", "key", "resId", "getImageWidthHeight", "Landroid/graphics/Point;", "filePath", "getLiveCoverUrl", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getMediaRateLimit", "hwRate", "getNumFormatStr", "num", "getSelfNameByScene", "scene", "getWxDisplayName", "hasFinderAccount", "hasShowFinderLoadMoreNewGuide", "hasShowFinderRealHistoryNewGuide", "ifPosterBolcked", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "isCommentClose", "errType", "errCode", "isFastClick", "isFinderComment", "displayFlag", "isJsapiFromAd", "extraInfo", "isLiveFeed", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isNormalVideo", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isPoster", "isPrivateAccount", "isPromoteFuncOpen", "isRegInChina", "isSelf", "isTest", "isViewVisibleRectMoreThanThreshold", "visibleRectThreshold", "isHeight", "isWxSelf", "liveJumpToBizContactProfile", "bizUsername", "sessionId", "liveId", "subScene", "loadPagLib", "loadPagLibImpl", "multiLet", "R", "T1", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "parsePrice", "price", "setPriceTypeFace", "tv", "Landroid/widget/TextView;", "useSS", "testStack", "transOldFinderMsgSessionAndConv", "tryCatchReleaseException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "extraMsg", "tryLoadPagLibrary", "prefix", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
{
  private static final Set<Integer> GiP;
  public static final aw Gjk;
  private static final j Gjl;
  public static final String TAG;
  private static long lastClickTime;
  
  static
  {
    AppMethodBeat.i(333463);
    Gjk = new aw();
    TAG = "Finder.FinderUtil2";
    Gjl = kotlin.k.cm((kotlin.g.a.a)aw.a.Gjm);
    GiP = ar.setOf(Integer.valueOf(2013));
    AppMethodBeat.o(333463);
  }
  
  public static boolean A(FinderObject paramFinderObject)
  {
    boolean bool = false;
    if (paramFinderObject == null) {}
    for (int i = 0;; i = paramFinderObject.permissionFlag)
    {
      if ((i & 0x1) == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static int G(FinderObject paramFinderObject)
  {
    Object localObject2 = null;
    int j = 0;
    AppMethodBeat.i(333092);
    s.u(paramFinderObject, "obj");
    if (paramFinderObject.objectDesc != null)
    {
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 != null) {
        break label103;
      }
      localObject1 = null;
      if (localObject1 != null) {}
    }
    else
    {
      Log.printInfoStack(TAG, s.X("obj ", paramFinderObject), new Object[0]);
    }
    Iterable localIterable = (Iterable)fgq();
    Object localObject1 = paramFinderObject.objectDesc;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    label103:
    int i;
    for (;;)
    {
      if (p.a(localIterable, localObject1))
      {
        paramFinderObject = paramFinderObject.objectDesc;
        if (paramFinderObject == null)
        {
          AppMethodBeat.o(333092);
          return 0;
          localObject1 = Integer.valueOf(((FinderObjectDesc)localObject1).mediaType);
          break;
          localObject1 = Integer.valueOf(((FinderObjectDesc)localObject1).mediaType);
          continue;
        }
        i = paramFinderObject.mediaType;
        AppMethodBeat.o(333092);
        return i;
      }
    }
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if ((localObject1 != null) && (((LinkedList)localObject1).size() == 0)) {
        i = 1;
      }
    }
    while (i != 0)
    {
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject == null)
      {
        AppMethodBeat.o(333092);
        return 0;
        i = 0;
      }
      else
      {
        i = paramFinderObject.mediaType;
        AppMethodBeat.o(333092);
        return i;
      }
    }
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 == null) {
      i = 0;
    }
    while (!fgq().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(333092);
      return i;
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 == null)
      {
        i = 0;
      }
      else
      {
        localObject1 = (FinderMedia)((LinkedList)localObject1).get(0);
        if (localObject1 == null) {
          i = 0;
        } else {
          i = ((FinderMedia)localObject1).mediaType;
        }
      }
    }
    if (i == 4)
    {
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null) {}
      while (j > 1)
      {
        AppMethodBeat.o(333092);
        return 8;
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null) {
          j = ((LinkedList)localObject1).size();
        }
      }
    }
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        paramFinderObject = ((Iterable)paramFinderObject).iterator();
        while (paramFinderObject.hasNext()) {
          if (((FinderMedia)paramFinderObject.next()).mediaType != i)
          {
            AppMethodBeat.o(333092);
            return 8;
          }
        }
      }
    }
    AppMethodBeat.o(333092);
    return i;
  }
  
  public static boolean Iz(String paramString)
  {
    AppMethodBeat.i(333353);
    if ((!Util.isNullOrNil(z.bAW())) && (!Util.isNullOrNil(paramString)) && (n.T(paramString, z.bAW(), false)))
    {
      AppMethodBeat.o(333353);
      return true;
    }
    AppMethodBeat.o(333353);
    return false;
  }
  
  public static String Ud(int paramInt)
  {
    AppMethodBeat.i(333361);
    if (paramInt == 2)
    {
      localObject = z.bAO();
      if (localObject == null)
      {
        AppMethodBeat.o(333361);
        return "";
      }
      AppMethodBeat.o(333361);
      return localObject;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = d.a.auT(z.bAW());
    if (localObject == null)
    {
      AppMethodBeat.o(333361);
      return "";
    }
    localObject = ((m)localObject).getNickname();
    if (localObject == null)
    {
      AppMethodBeat.o(333361);
      return "";
    }
    AppMethodBeat.o(333361);
    return localObject;
  }
  
  public static boolean Us(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean Ut(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static String Uu(int paramInt)
  {
    AppMethodBeat.i(333314);
    try
    {
      String str = new DecimalFormat("0.##").format(paramInt / 100.0D);
      s.s(str, "DecimalFormat(\"0.##\").format(price / 100.00)");
      AppMethodBeat.o(333314);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(333314);
    }
    return "";
  }
  
  public static String Uv(int paramInt)
  {
    AppMethodBeat.i(333318);
    if (paramInt < 10)
    {
      String str = s.X("0", Integer.valueOf(paramInt));
      AppMethodBeat.o(333318);
      return str;
    }
    AppMethodBeat.o(333318);
    return String.valueOf(paramInt);
  }
  
  public static LiveConfig a(FinderObject paramFinderObject, int paramInt, boolean paramBoolean)
  {
    long l2 = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(333249);
    s.u(paramFinderObject, "obj");
    Object localObject1 = paramFinderObject.liveInfo;
    int j;
    String str;
    label70:
    label89:
    int i;
    label103:
    byte[] arrayOfByte;
    label138:
    Object localObject3;
    label174:
    label203:
    long l1;
    if ((localObject1 != null) && (((bip)localObject1).liveStatus == 1))
    {
      j = 1;
      if (j == 0) {
        break label507;
      }
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 == null) {
        break label507;
      }
      str = ((bip)localObject1).mIE;
      if (str == null) {
        break label507;
      }
      if (j == 0) {
        break label555;
      }
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label515;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label546;
      }
      localObject1 = e.b.mKf;
      i = e.b.bcu();
      if (j == 0) {
        break label560;
      }
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 == null) {
        break label560;
      }
      localObject1 = ((bip)localObject1).ZOg;
      if (localObject1 == null) {
        break label560;
      }
      arrayOfByte = ((dix)localObject1).toByteArray();
      if (j == 0)
      {
        localObject3 = TAG;
        StringBuilder localStringBuilder = new StringBuilder("convertToLiveConfig liveId:");
        localObject1 = paramFinderObject.liveInfo;
        if (localObject1 != null) {
          break label566;
        }
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(",liveStatus:");
        localObject1 = paramFinderObject.contact;
        if (localObject1 != null) {
          break label579;
        }
        localObject1 = null;
        Log.i((String)localObject3, localObject1 + " nickname:" + paramFinderObject.nickname);
      }
      localObject3 = new LiveConfig.a();
      localObject1 = bj.GlQ;
      ((LiveConfig.a)localObject3).mIy = paramInt;
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label592;
      }
      l1 = 0L;
      label265:
      ((LiveConfig.a)localObject3).liveId = l1;
      ((LiveConfig.a)localObject3).nonceId = paramFinderObject.objectNonceId;
      ((LiveConfig.a)localObject3).mIH = paramFinderObject.id;
      ((LiveConfig.a)localObject3).mIC = paramFinderObject.username;
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 != null) {
        break label602;
      }
      localObject1 = null;
      label313:
      ((LiveConfig.a)localObject3).thumbUrl = e((FinderMedia)localObject1);
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 != null) {
        break label636;
      }
      localObject1 = null;
      label337:
      ((LiveConfig.a)localObject3).desc = ((String)localObject1);
      ((LiveConfig.a)localObject3).sessionBuffer = paramFinderObject.sessionBuffer;
      ((LiveConfig.a)localObject3).mIE = str;
      ((LiveConfig.a)localObject3).mIF = i;
      ((LiveConfig.a)localObject3).mIR = Boolean.valueOf(paramBoolean).booleanValue();
      ((LiveConfig.a)localObject3).mJd = paramFinderObject.nickname;
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label646;
      }
      l1 = l2;
      label402:
      ((LiveConfig.a)localObject3).mIV = l1;
      ((LiveConfig.a)localObject3).mIW = arrayOfByte;
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label656;
      }
      paramInt = 0;
      label429:
      ((LiveConfig.a)localObject3).mIX = paramInt;
      s.s(localObject3, "builder.toWhere(toWhere)…eInfo?.live_vr_type ?: 0)");
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject != null) {
        break label665;
      }
    }
    label515:
    label646:
    label656:
    label665:
    for (paramFinderObject = localObject2;; paramFinderObject = paramFinderObject.ZSn)
    {
      paramFinderObject = bj.a((LiveConfig.a)localObject3, "convertToLiveConfig", paramFinderObject).bcd();
      s.s(paramFinderObject, "builder.toWhere(toWhere)…nfo)\n            .build()");
      localObject1 = com.tencent.mm.plugin.findersdk.f.b.HeJ;
      com.tencent.mm.plugin.findersdk.f.b.iz(TAG, s.X("convertToLiveConfig ", paramFinderObject));
      AppMethodBeat.o(333249);
      return paramFinderObject;
      j = 0;
      break;
      label507:
      str = "";
      break label70;
      localObject1 = ((bip)localObject1).ZRQ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label89;
      }
      localObject1 = Integer.valueOf(((bmi)localObject1).mNn);
      break label89;
      label546:
      i = ((Integer)localObject1).intValue();
      break label103;
      label555:
      i = 0;
      break label103;
      label560:
      arrayOfByte = null;
      break label138;
      label566:
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break label174;
      label579:
      localObject1 = Integer.valueOf(((FinderContact)localObject1).liveStatus);
      break label203;
      label592:
      l1 = ((bip)localObject1).liveId;
      break label265;
      label602:
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label313;
      }
      localObject1 = (FinderMedia)p.oL((List)localObject1);
      break label313;
      label636:
      localObject1 = ((FinderObjectDesc)localObject1).description;
      break label337;
      l1 = ((bip)localObject1).ZFH;
      break label402;
      paramInt = ((bip)localObject1).ZSl;
      break label429;
    }
  }
  
  private static final String a(ah.f<Calendar> paramf, boolean paramBoolean, long paramLong, ah.f<CharSequence> paramf1, Boolean paramBoolean1)
  {
    AppMethodBeat.i(333443);
    int i = ((Calendar)paramf.aqH).get(7);
    paramf = MMApplicationContext.getContext().getResources().getStringArray(com.tencent.mm.w.a.a.a.a.time_day)[((i + 5) % 7)];
    if (s.p(paramBoolean1, Boolean.FALSE))
    {
      if (paramBoolean)
      {
        paramf = s.X(MMApplicationContext.getContext().getString(a.i.finder_live_days_after, new Object[] { DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(a.i.fmt_date), paramLong), paramf }), paramf1.aqH);
        AppMethodBeat.o(333443);
        return paramf;
      }
      paramf = s.X(MMApplicationContext.getContext().getString(a.i.finder_live_days_after_no_day_of_week, new Object[] { DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(a.i.fmt_date), paramLong) }), paramf1.aqH);
      AppMethodBeat.o(333443);
      return paramf;
    }
    paramf = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(a.i.fmt_date), paramLong) + paramf1.aqH;
    AppMethodBeat.o(333443);
    return paramf;
  }
  
  public static u<Integer, Integer, Integer> a(Context paramContext, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(333135);
    s.u(paramContext, "context");
    Point localPoint = com.tencent.mm.ui.aw.bf(paramContext);
    int j;
    int i;
    if ((localPoint.x != 0) && (localPoint.y != 0))
    {
      j = 1;
      if (j == 0) {
        break label133;
      }
      i = localPoint.y;
      label49:
      if (j == 0) {
        break label147;
      }
      j = localPoint.x;
      label61:
      if (paramFloat2 / paramFloat1 <= i / j) {
        break label162;
      }
    }
    label133:
    label147:
    label162:
    for (int k = i;; k = (int)(j * paramFloat2 / paramFloat1))
    {
      if (i == k) {
        j = (int)(i * paramFloat1 / paramFloat2);
      }
      paramContext = new u(Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(333135);
      return paramContext;
      j = 0;
      break;
      i = paramContext.getResources().getDisplayMetrics().heightPixels;
      break label49;
      j = paramContext.getResources().getDisplayMetrics().widthPixels;
      break label61;
    }
  }
  
  private static final void a(int paramInt, View paramView, kotlin.g.a.a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(333451);
    s.u(paramView, "$view");
    if (s.p(paramValueAnimator.getAnimatedValue(), Integer.valueOf(paramInt)))
    {
      paramView.getLayoutParams().width = paramInt;
      if (parama != null)
      {
        parama.invoke();
        AppMethodBeat.o(333451);
      }
    }
    else
    {
      parama = paramView.getLayoutParams();
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(333451);
        throw paramView;
      }
      parama.width = ((Integer)paramValueAnimator).intValue();
      paramView.requestLayout();
    }
    AppMethodBeat.o(333451);
  }
  
  public static void a(Exception paramException, String paramString)
  {
    AppMethodBeat.i(333054);
    s.u(paramException, "e");
    s.u(paramString, "extraMsg");
    if (bgV())
    {
      AppMethodBeat.o(333054);
      throw paramException;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(' ').append(paramException.getMessage()).append(' ');
    paramString = paramException.getCause();
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.getMessage())
    {
      Log.printInfoStack(str, paramString, new Object[0]);
      Log.printErrStackTrace(TAG, (Throwable)paramException, "", new Object[0]);
      AppMethodBeat.o(333054);
      return;
    }
  }
  
  public static void a(String paramString1, Context paramContext, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(333424);
    s.u(paramString1, "bizUsername");
    s.u(paramContext, "context");
    s.u(paramString2, "liveId");
    Log.i(TAG, "#liveJumpToBizContactProfile bizUsername=" + paramString1 + " sessionId=" + paramLong + " liveId=" + paramString2 + " subScene=" + paramInt);
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(333424);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString1);
    localIntent.putExtra("Contact_Scene", 208);
    localIntent.putExtra("Contact_Sub_Scene", paramInt);
    localIntent.putExtra("force_get_contact", true);
    localIntent.putExtra("key_use_new_contact_profile", true);
    localIntent.putExtra("Contact_Scene_Note", paramString2);
    localIntent.putExtra("biz_profile_tab_type", 1);
    localIntent.putExtra("biz_profile_enter_from_finder", true);
    c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(333424);
  }
  
  public static boolean aBI(String paramString)
  {
    AppMethodBeat.i(333101);
    boolean bool = Util.isEqual(paramString, z.bAM());
    AppMethodBeat.o(333101);
    return bool;
  }
  
  public static String aBP(String paramString)
  {
    AppMethodBeat.i(333194);
    s.u(paramString, "origin");
    paramString = (CharSequence)n.bq((CharSequence)paramString).toString();
    paramString = (CharSequence)new kotlin.n.k("(\n\n[\\s]*\n)|(\n[\\s]*\n\n)").e(paramString, "\n\n");
    paramString = (CharSequence)new kotlin.n.k("(\r\n\r\n[\\s]*\r\n)|(\r\n[\\s]*\r\n\r\n)").e(paramString, "\r\n\r\n");
    paramString = new kotlin.n.k("[ ]{11,}").e(paramString, "          ");
    AppMethodBeat.o(333194);
    return paramString;
  }
  
  public static boolean aBT(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(333405);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label85;
      }
      bool1 = false;
      label20:
      AppMethodBeat.o(333405);
      return bool1;
    }
    int i;
    try
    {
      if (((CharSequence)paramString).length() <= 0) {
        break label132;
      }
      i = 1;
    }
    catch (Exception paramString)
    {
      label45:
      Log.e(TAG, s.X("isJsapiFromAd ", paramString.getMessage()));
      bool1 = bool2;
    }
    paramString = new JSONObject(paramString).optJSONObject("sns_ad");
    if ((paramString != null) && (paramString.has("uxinfo") == true)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString = Boolean.valueOf(bool1);
      break;
      label85:
      bool1 = paramString.booleanValue();
      break label20;
      break label20;
      label115:
      if (i != 0) {}
      for (String str = paramString;; str = null)
      {
        if (str != null) {
          break label141;
        }
        paramString = null;
        break;
        label132:
        i = 0;
        break label115;
      }
      label141:
      break label45;
    }
  }
  
  public static void aBW(String paramString)
  {
    AppMethodBeat.i(333176);
    s.u(paramString, "prefix");
    Object localObject = ((cn)com.tencent.mm.kernel.h.az(cn.class)).isPagEnable();
    boolean bool = ChannelUtil.isGPVersion();
    Log.i(TAG, paramString + " tryLoadPagLibrary pag start,gpVersion:" + bool + ",isPagEnable:" + localObject);
    if (bool)
    {
      s.s(localObject, "isPagEnable");
      if (!((Boolean)localObject).booleanValue()) {}
    }
    else
    {
      if (com.tencent.mm.kernel.h.baz()) {
        break label125;
      }
      Log.e(TAG, "loadPagLib account is not ready");
    }
    for (;;)
    {
      Log.i(TAG, s.X(paramString, " tryLoadPagLibrary pag end"));
      AppMethodBeat.o(333176);
      return;
      label125:
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jRU().bmg()).intValue() == 0) {
        com.tencent.threadpool.h.ahAA.bm(aw..ExternalSyntheticLambda1.INSTANCE);
      } else {
        fgu();
      }
    }
  }
  
  public static Point aBX(String paramString)
  {
    AppMethodBeat.i(333393);
    s.u(paramString, "filePath");
    Point localPoint = new Point();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, localOptions);
    localPoint.x = localOptions.outWidth;
    localPoint.y = localOptions.outHeight;
    if (Exif.fromFile(paramString).getOrientationInDegree() % 180 != 0)
    {
      int i = localPoint.y;
      localPoint.y = localPoint.x;
      paramString = ah.aiuX;
      localPoint.x = i;
    }
    AppMethodBeat.o(333393);
    return localPoint;
  }
  
  public static String aj(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(333401);
    s.u(paramMap, "maps");
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (Exception localException) {}
    }
    paramMap = localJSONObject.toString();
    s.s(paramMap, "json.toString()");
    paramMap = n.bV(paramMap, ",", ";");
    AppMethodBeat.o(333401);
    return paramMap;
  }
  
  public static r<Integer, Integer> b(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    AppMethodBeat.i(333153);
    if (paramFloat2 == 0.0F)
    {
      i = 1;
      if (i == 0)
      {
        if (paramFloat1 != 0.0F) {
          break label81;
        }
        i = 1;
        label32:
        if (i == 0)
        {
          if (paramFloat4 != 0.0F) {
            break label87;
          }
          i = 1;
          label47:
          if (i == 0) {
            if (paramFloat3 != 0.0F) {
              break label93;
            }
          }
        }
      }
    }
    label81:
    label87:
    label93:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label99;
      }
      AppMethodBeat.o(333153);
      return null;
      i = 0;
      break;
      i = 0;
      break label32;
      i = 0;
      break label47;
    }
    label99:
    if (paramInt == ImageView.ScaleType.FIT_CENTER.ordinal())
    {
      if (paramFloat4 / paramFloat3 < paramFloat2 / paramFloat1)
      {
        paramInt = (int)(paramFloat4 * paramFloat1 / paramFloat3);
        localr = new r(Integer.valueOf((int)paramFloat1), Integer.valueOf(paramInt));
        AppMethodBeat.o(333153);
        return localr;
      }
      localr = new r(Integer.valueOf((int)(paramFloat3 * paramFloat2 / paramFloat4)), Integer.valueOf((int)paramFloat2));
      AppMethodBeat.o(333153);
      return localr;
    }
    if (paramFloat4 / paramFloat3 > paramFloat2 / paramFloat1)
    {
      paramInt = (int)(paramFloat4 * paramFloat1 / paramFloat3);
      localr = new r(Integer.valueOf((int)paramFloat1), Integer.valueOf(paramInt));
      AppMethodBeat.o(333153);
      return localr;
    }
    r localr = new r(Integer.valueOf((int)(paramFloat3 * paramFloat2 / paramFloat4)), Integer.valueOf((int)paramFloat2));
    AppMethodBeat.o(333153);
    return localr;
  }
  
  public static boolean bgV()
  {
    AppMethodBeat.i(333060);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(333060);
      return true;
    }
    AppMethodBeat.o(333060);
    return false;
  }
  
  public static String e(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(333268);
    String str = "";
    if (paramFinderMedia != null) {
      str = s.X(Util.nullAsNil(paramFinderMedia.thumbUrl), Util.nullAsNil(paramFinderMedia.thumb_url_token));
    }
    AppMethodBeat.o(333268);
    return str;
  }
  
  public static boolean e(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(333111);
    s.u(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (!Util.isNullOrNil(z.bAW()))
    {
      if (paramBaseFinderFeed == null) {}
      for (paramBaseFinderFeed = null; n.T(paramBaseFinderFeed, z.bAW(), false); paramBaseFinderFeed = paramBaseFinderFeed.field_username)
      {
        AppMethodBeat.o(333111);
        return true;
      }
    }
    AppMethodBeat.o(333111);
    return false;
  }
  
  public static boolean eKm()
  {
    AppMethodBeat.i(333333);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x400) != 0)
    {
      AppMethodBeat.o(333333);
      return true;
    }
    AppMethodBeat.o(333333);
    return false;
  }
  
  public static String eX(String paramString, int paramInt)
  {
    AppMethodBeat.i(333374);
    s.u(paramString, "key");
    paramString = MMApplicationContext.getContext().getString(paramInt);
    s.s(paramString, "getContext().getString(resId)");
    AppMethodBeat.o(333374);
    return paramString;
  }
  
  public static void eY(String paramString, int paramInt)
  {
    AppMethodBeat.i(333129);
    s.u(paramString, "logPrefix");
    if (bgV())
    {
      paramString = new RuntimeException(paramString + " type:" + paramInt + " invalid");
      AppMethodBeat.o(333129);
      throw paramString;
    }
    Log.printInfoStack(TAG, paramString + " type:" + paramInt + " invalid", new Object[0]);
    AppMethodBeat.o(333129);
  }
  
  public static void f(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(333310);
    s.u(paramTextView, "tv");
    if (paramBoolean) {}
    for (String str = "fonts/WeChatSansSS-Medium.ttf";; str = "fonts/WeChatSansStd-Medium.ttf") {
      try
      {
        paramTextView.setTypeface(Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), str));
        AppMethodBeat.o(333310);
        return;
      }
      catch (Exception paramTextView)
      {
        Log.e(TAG, s.X("setTypeface() Exception:", paramTextView.getMessage()));
        AppMethodBeat.o(333310);
      }
    }
  }
  
  public static Set<Integer> ffO()
  {
    return GiP;
  }
  
  public static boolean ffR()
  {
    AppMethodBeat.i(333121);
    if (!Util.isNullOrNil(z.bAW()))
    {
      AppMethodBeat.o(333121);
      return true;
    }
    AppMethodBeat.o(333121);
    return false;
  }
  
  public static void fgp()
  {
    AppMethodBeat.i(333079);
    boolean bool1 = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adbc, false);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    boolean bool2 = ((Boolean)com.tencent.mm.plugin.finder.storage.d.eWD().bmg()).booleanValue();
    Log.i(TAG, "[checkOldSessionInfo] hasTrans:" + bool1 + " , ignoreHasTrans:" + bool2);
    ah.a locala;
    e locale;
    if ((!bool1) || (bool2))
    {
      Log.i(TAG, "[checkOldSessionInfo] begin");
      long l = SystemClock.uptimeMillis();
      localObject = new ah.a();
      ((ah.a)localObject).aiwY = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUc();
      locala = new ah.a();
      locala.aiwY = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUd();
      l = SystemClock.uptimeMillis() - l;
      Log.i(TAG, s.X("[checkOldSessionInfo] end,duration = ", Long.valueOf(l)));
      locale = (e)com.tencent.mm.plugin.findersdk.b.HbT;
      if (l <= 10000L) {
        break label299;
      }
      bool1 = true;
      e.a.a(locale, "transOldFinderMsgSessionInfo", bool1, (kotlin.g.a.a)new aw.b(l));
      locale = (e)com.tencent.mm.plugin.findersdk.b.HbT;
      if ((!((ah.a)localObject).aiwY) || (!locala.aiwY)) {
        break label304;
      }
    }
    label299:
    label304:
    for (bool1 = true;; bool1 = false)
    {
      e.a.a(locale, "transOldFinderMsgSessionInfo-result", bool1, null, false, (kotlin.g.a.a)new aw.c((ah.a)localObject, locala), 28);
      if ((((ah.a)localObject).aiwY) && (locala.aiwY)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adbc, Boolean.TRUE);
      }
      AppMethodBeat.o(333079);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static List<Integer> fgq()
  {
    AppMethodBeat.i(333045);
    List localList = (List)Gjl.getValue();
    AppMethodBeat.o(333045);
    return localList;
  }
  
  public static String fgr()
  {
    AppMethodBeat.i(333067);
    if (bgV())
    {
      String str = Util.getStack().toString();
      s.s(str, "getStack().toString()");
      AppMethodBeat.o(333067);
      return str;
    }
    AppMethodBeat.o(333067);
    return "";
  }
  
  public static boolean fgs()
  {
    AppMethodBeat.i(333160);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adev, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(333160);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(333160);
    return bool;
  }
  
  public static boolean fgt()
  {
    AppMethodBeat.i(333168);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adew, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(333168);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(333168);
    return bool;
  }
  
  private static void fgu()
  {
    AppMethodBeat.i(333183);
    com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 200L, 1L);
    com.tencent.mm.plugin.expansions.b localb = com.tencent.mm.plugin.expansions.b.yFu;
    boolean bool = com.tencent.mm.plugin.expansions.b.tryLoadLibrary("pag");
    Log.i(TAG, s.X("loadPagLib result:", Boolean.valueOf(bool)));
    com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 201L, 1L);
    AppMethodBeat.o(333183);
  }
  
  public static bfu fgv()
  {
    AppMethodBeat.i(333211);
    bfu localbfu = new bfu();
    bft localbft = new bft();
    localbft.ZPE = CdnLogic.getRecentAverageSpeed(2);
    ah localah = ah.aiuX;
    localbfu.ZPF = localbft;
    AppMethodBeat.o(333211);
    return localbfu;
  }
  
  public static String fgw()
  {
    AppMethodBeat.i(333279);
    String str = MD5Util.getMD5String(s.X(z.bAM(), Long.valueOf(System.currentTimeMillis())));
    s.s(str, "getMD5String(\"${ConfigSt…em.currentTimeMillis()}\")");
    AppMethodBeat.o(333279);
    return str;
  }
  
  public static boolean fgx()
  {
    AppMethodBeat.i(333382);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().d(274436, null);
    if ((localObject instanceof String)) {}
    for (localObject = (String)localObject;; localObject = null)
    {
      localObject = Util.nullAs((String)localObject, "CN");
      boolean bool = n.T("CN", (String)localObject, true);
      Log.i(TAG, "isRegInChina, regCountryIsoCode:" + localObject + " isChinaReg:" + bool);
      AppMethodBeat.o(333382);
      return bool;
    }
  }
  
  public static boolean fgy()
  {
    AppMethodBeat.i(333430);
    long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.adgm, 0L);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYv().bmg()).intValue() == -1)
    {
      boolean bool = com.tencent.mm.ae.d.ee((int)l, 1);
      AppMethodBeat.o(333430);
      return bool;
    }
    locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYv().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(333430);
      return true;
    }
    AppMethodBeat.o(333430);
    return false;
  }
  
  private static final void fgz()
  {
    AppMethodBeat.i(333436);
    fgu();
    AppMethodBeat.o(333436);
  }
  
  public static u<Integer, Integer, Integer> i(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = 0.5625F;
    AppMethodBeat.i(333142);
    s.u(paramContext, "context");
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = ((Activity)paramContext).getBaseContext();
    }
    int i = kotlin.k.k.qv(localContext.getResources().getDisplayMetrics().widthPixels, localContext.getResources().getDisplayMetrics().heightPixels);
    float f1 = paramInt2 * 1.0F / paramInt1;
    int j = ImageView.ScaleType.CENTER_CROP.ordinal();
    if (Math.abs(paramInt1 - paramInt2) <= 10)
    {
      paramInt1 = i;
      paramContext = new u(Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1));
      AppMethodBeat.o(333142);
      return paramContext;
    }
    if (f1 < 0.5625F) {}
    for (f1 = f2;; f1 = 1.316667F) {
      do
      {
        paramInt1 = (int)(f1 * i);
        break;
      } while ((f1 < 1.0F) || (f1 < 1.316667F));
    }
  }
  
  public static boolean i(dji paramdji)
  {
    boolean bool = false;
    if (paramdji != null)
    {
      paramdji = paramdji.aaDI;
      if ((paramdji == null) || (paramdji.Znj != true)) {
        break label33;
      }
    }
    label33:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static String ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(333292);
    paramString1 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).k(paramString1, paramString2, false);
    AppMethodBeat.o(333292);
    return paramString1;
  }
  
  public static boolean isFastClick()
  {
    AppMethodBeat.i(333202);
    boolean bool = true;
    long l = System.currentTimeMillis();
    if (l - lastClickTime >= 500L) {
      bool = false;
    }
    lastClickTime = l;
    AppMethodBeat.o(333202);
    return bool;
  }
  
  public static boolean iv(int paramInt1, int paramInt2)
  {
    return (paramInt2 == -4012) && (paramInt1 == 4);
  }
  
  public static com.tencent.mm.bx.b j(com.tencent.mm.bx.a parama)
  {
    AppMethodBeat.i(333287);
    s.u(parama, "<this>");
    parama = parama.toByteArray();
    if (parama != null)
    {
      parama = new com.tencent.mm.bx.b(parama);
      AppMethodBeat.o(333287);
      return parama;
    }
    AppMethodBeat.o(333287);
    return null;
  }
  
  public static boolean n(m paramm)
  {
    AppMethodBeat.i(333340);
    if (paramm == null) {}
    for (Object localObject = null; s.p(localObject, z.bAW()); localObject = paramm.getUsername())
    {
      boolean bool = eKm();
      AppMethodBeat.o(333340);
      return bool;
    }
    if (paramm == null) {}
    for (int i = 0; (i & 0x400) != 0; i = paramm.field_extFlag)
    {
      AppMethodBeat.o(333340);
      return true;
    }
    AppMethodBeat.o(333340);
    return false;
  }
  
  public static boolean o(m paramm)
  {
    if (paramm != null)
    {
      if ((paramm.field_extFlag & 0x4000) == 0) {}
      for (int i = 1; i == 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean s(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(333369);
    s.u(paramBaseFinderFeed, "item");
    if (paramBaseFinderFeed.feedObject.getMediaType() == 9)
    {
      AppMethodBeat.o(333369);
      return true;
    }
    AppMethodBeat.o(333369);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aw
 * JD-Core Version:    0.7.0.1
 */