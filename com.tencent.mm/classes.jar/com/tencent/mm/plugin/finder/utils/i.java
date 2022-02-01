package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.hd.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.v.e;
import d.g.b.z;
import d.n.n;
import d.o;
import d.v;
import d.y;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil;", "", "()V", "POST_WIDER_MEDIA_LAYOUT_SIZE", "", "TAG", "", "lastCenterFeedId", "", "margin", "mediaRect", "Landroid/graphics/Rect;", "screenInfoObj", "Lorg/json/JSONObject;", "getScreenInfoObj", "()Lorg/json/JSONObject;", "setScreenInfoObj", "(Lorg/json/JSONObject;)V", "blurVideoThumb", "Landroid/graphics/Bitmap;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "bitmap", "source", "calculateLayoutParams", "Landroid/widget/ImageView$ScaleType;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "params", "Landroid/view/ViewGroup$LayoutParams;", "view", "Landroid/view/View;", "calculatePercent", "offset", "total", "calculatePostLayoutParams", "Landroid/os/Bundle;", "width", "height", "calculateTimelineLayoutParams", "canReprint", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "checkHasAccountAndCreate", "activity", "Landroid/content/Context;", "tip", "showRed", "userPrepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "checkHasRealname", "Landroid/app/Activity;", "convertCompatibilityMediaType", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "currentTimeSecond", "decodeBitmap", "inputStream", "Ljava/io/InputStream;", "limitW", "limitH", "isRotate", "isClose", "fillLocalImageToView", "", "imageView", "Landroid/widget/ImageView;", "path", "fillRefInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getClipData", "getCurrentScreenIndexInfo", "Lorg/json/JSONArray;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getDisplayName", "username", "nickname", "printLog", "getFeedListByAdapterPosRange", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "start", "end", "getFinderPageDir", "scene", "getHint", "key", "resId", "getImageLocation", "Lkotlin/Pair;", "", "getImageWidthHeight", "Landroid/graphics/Point;", "filePath", "getLastBuffKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "tabType", "getLocationShowString", "countryCode", "provinceCode", "cityCode", "getMentionNick", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getNickName", "getPoiText", "city", "poiName", "getPrintDescription", "desc", "getScreenInfo", "getSelfNameByScene", "getSelfUsernameByScene", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "getVideoLocation", "getVisibleFeedListByAdapterPosRange", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "globalVisibleRect", "hasCreateFinderIdentit", "hasFinderAccount", "isAcceptObj", "isCommentClose", "errType", "errCode", "isFinderComment", "displayFlag", "isFinderScene", "isFlowCommentScene", "commentScene", "isFriend", "isLikeNotRecommend", "isNormalVideo", "localFinderMedia", "isPoster", "isSelf", "isWxScene", "isWxSelf", "jumpLocation", "context", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "jumpToWxProfile", "intent", "Landroid/content/Intent;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "makeMediaTypeHappy", "content", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "default", "mapUnsigned", "millisToUnixTime", "timestamp", "multiLet", "R", "T1", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "onFindNearByFeedId", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "firstVisibleItemPosition", "lastVisibleItemPosition", "isOnlyCareVideo", "postCommentCountChangedEvent", "it", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "postExposeDelEvent", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "commentId", "clientId", "printAllItem", "list", "", "tag", "reportCollectUnreadItem", "remain", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setToMachineTab", "tv", "Landroid/widget/TextView;", "onClick", "Lkotlin/Function0;", "shake", "Landroid/animation/ObjectAnimator;", "shakeFactor", "", "sourceFlagToLocalTypeFlag", "sourceType", "switchScene", "tabTypeToSourceFlag", "unixTimeToMillis", "CenterFeed", "VisibleFeedDataObj", "plugin-finder_release"})
public final class i
{
  private static JSONObject Lbj;
  private static final String TAG = "Finder.FinderUtil";
  private static long qGl;
  private static final int qSX;
  private static final int qSY;
  private static final Rect qSZ;
  public static final i qTa;
  
  static
  {
    AppMethodBeat.i(167970);
    qTa = new i();
    TAG = "Finder.FinderUtil";
    Context localContext = aj.getContext();
    d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
    qSX = (int)localContext.getResources().getDimension(2131165284);
    localContext = aj.getContext();
    d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
    qSY = (int)localContext.getResources().getDimension(2131166692);
    qSZ = new Rect();
    qGl = -1L;
    AppMethodBeat.o(167970);
  }
  
  public static JSONArray B(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(199677);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(199677);
      throw paramRecyclerView;
    }
    Object localObject2 = (StaggeredGridLayoutManager)localObject1;
    localObject1 = ((StaggeredGridLayoutManager)localObject2).x(null);
    localObject2 = ((StaggeredGridLayoutManager)localObject2).ma();
    int i;
    if (localObject1 != null)
    {
      i = localObject1[0];
      if (localObject1 == null) {
        break label250;
      }
    }
    label250:
    for (int j = localObject1[1];; j = 0)
    {
      localObject1 = a(Math.min(i, j), Math.max(localObject2[0], localObject2[1]), paramRecyclerView);
      paramRecyclerView = new JSONArray();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (com.tencent.mm.plugin.finder.event.base.k)((Iterator)localObject1).next();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("feedid", c.ly(((com.tencent.mm.plugin.finder.event.base.k)localObject3).qHv.bMs()));
        ((JSONObject)localObject2).put("feedindex", ((com.tencent.mm.plugin.finder.event.base.k)localObject3).KMi);
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.k)localObject3).KMj;
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put("x", ((com.tencent.mm.view.recyclerview.f)localObject3).LDP + 1);
          ((JSONObject)localObject2).put("width", ((com.tencent.mm.view.recyclerview.f)localObject3).width);
          ((JSONObject)localObject2).put("height", ((com.tencent.mm.view.recyclerview.f)localObject3).height);
        }
        paramRecyclerView.put(localObject2);
      }
      i = 0;
      break;
    }
    AppMethodBeat.o(199677);
    return paramRecyclerView;
  }
  
  public static long Dg(int paramInt)
  {
    return paramInt * 1000L;
  }
  
  public static String Dh(int paramInt)
  {
    AppMethodBeat.i(167961);
    Object localObject1 = "";
    switch (paramInt)
    {
    }
    while (bt.isNullOrNil((String)localObject1))
    {
      localObject1 = new StringBuilder();
      localObject2 = g.afB();
      d.g.b.k.g(localObject2, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject2).aff() + "finder/page/";
      AppMethodBeat.o(167961);
      return localObject1;
      localObject1 = "follow";
      continue;
      localObject1 = "feed";
      continue;
      localObject1 = "fans";
      continue;
      localObject1 = "preload";
    }
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.e locale = g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    localObject1 = locale.aff() + "finder/page/" + (String)localObject1 + '/';
    AppMethodBeat.o(167961);
    return localObject1;
  }
  
  public static boolean Di(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static String Dj(int paramInt)
  {
    AppMethodBeat.i(167967);
    String str;
    if (paramInt == 2)
    {
      str = u.aqI();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(167967);
      return localObject;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject = u.aqO();
    d.g.b.k.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
    localObject = com.tencent.mm.plugin.finder.api.b.a.YL((String)localObject);
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.finder.api.f)localObject).Su();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(167967);
    return localObject;
  }
  
  public static String Dk(int paramInt)
  {
    AppMethodBeat.i(178461);
    if (paramInt == 2)
    {
      str = u.aqG();
      d.g.b.k.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(178461);
      return str;
    }
    String str = u.aqO();
    d.g.b.k.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(178461);
    return str;
  }
  
  public static int Dl(int paramInt)
  {
    int i = 2;
    if (paramInt == 2) {
      i = 1;
    }
    return i;
  }
  
  public static boolean Dm(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean Dn(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static com.tencent.mm.plugin.sight.base.a ZP(String paramString)
  {
    AppMethodBeat.i(167939);
    d.g.b.k.h(paramString, "filePath");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(167939);
      return null;
    }
    com.tencent.mm.plugin.sight.base.e.ano(paramString);
    com.tencent.mm.plugin.sight.base.a locala = new com.tencent.mm.plugin.sight.base.a();
    if ((locala.height <= 0) || (locala.width <= 0)) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(com.tencent.mm.vfs.i.k(paramString, false));
      locala.width = bt.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      locala.height = bt.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      locala.videoBitrate = bt.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      localMediaMetadataRetriever.release();
      label118:
      int i = SightVideoJNI.getMp4RotateVFS(paramString);
      ad.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(i) });
      if ((i == 270) || (i == 90))
      {
        i = locala.height;
        locala.height = locala.width;
        locala.width = i;
      }
      AppMethodBeat.o(167939);
      return locala;
    }
    catch (Exception localException)
    {
      break label118;
    }
  }
  
  public static Point ZQ(String paramString)
  {
    AppMethodBeat.i(167940);
    d.g.b.k.h(paramString, "filePath");
    Point localPoint = new Point();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    com.tencent.mm.sdk.platformtools.f.decodeFile(paramString, localOptions);
    localPoint.x = localOptions.outWidth;
    localPoint.y = localOptions.outHeight;
    paramString = Exif.fromFile(paramString);
    d.g.b.k.g(paramString, "Exif.fromFile(filePath)");
    if (paramString.getOrientationInDegree() % 180 != 0)
    {
      int i = localPoint.y;
      localPoint.y = localPoint.x;
      localPoint.x = i;
    }
    AppMethodBeat.o(167940);
    return localPoint;
  }
  
  public static boolean ZR(String paramString)
  {
    AppMethodBeat.i(167957);
    if ((!bt.isNullOrNil(u.aqO())) && (!bt.isNullOrNil(paramString)) && (n.I(paramString, u.aqO(), false)))
    {
      AppMethodBeat.o(167957);
      return true;
    }
    AppMethodBeat.o(167957);
    return false;
  }
  
  public static boolean ZS(String paramString)
  {
    AppMethodBeat.i(167958);
    boolean bool = bt.kU(paramString, u.aqG());
    AppMethodBeat.o(167958);
    return bool;
  }
  
  public static o<Double, Double> ZT(String paramString)
  {
    AppMethodBeat.i(167965);
    d.g.b.k.h(paramString, "path");
    Object localObject = new j(new ExifInterface(com.tencent.mm.vfs.i.k(paramString, false)));
    paramString = ((j)localObject).qTe;
    localObject = ((j)localObject).qTd;
    if ((localObject != null) && (paramString != null))
    {
      paramString = new o(Double.valueOf(((Float)localObject).floatValue()), Double.valueOf(paramString.floatValue()));
      AppMethodBeat.o(167965);
      return paramString;
    }
    AppMethodBeat.o(167965);
    return null;
  }
  
  public static o<Double, Double> ZU(String paramString)
  {
    AppMethodBeat.i(167966);
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        AppMethodBeat.o(167966);
        return null;
      }
      localObject = new com.tencent.mm.compatible.h.d();
      ((com.tencent.mm.compatible.h.d)localObject).setDataSource(paramString);
      paramString = ((com.tencent.mm.compatible.h.d)localObject).extractMetadata(23);
      ((com.tencent.mm.compatible.h.d)localObject).release();
      ad.i(TAG, "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        break label372;
      }
      d.g.b.k.g(paramString, "locationString");
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167966);
        throw paramString;
      }
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(167966);
      return null;
    }
    paramString = paramString.toCharArray();
    d.g.b.k.g(paramString, "(this as java.lang.String).toCharArray()");
    Object localObject = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        char c = paramString[i];
        if ((c == '+') || (c == '-') || (c == '.') || (TextUtils.isDigitsOnly((CharSequence)(String.valueOf(c) + "")))) {
          ((StringBuilder)localObject).append(c);
        }
      }
      else
      {
        paramString = ((StringBuilder)localObject).toString();
        d.g.b.k.g(paramString, "locSb.toString()");
        j = n.b((CharSequence)paramString, '+');
        i = j;
        if (-1 == j) {
          i = n.b((CharSequence)paramString, '-');
        }
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        localObject = paramString.substring(0, i);
        d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        double d = Double.parseDouble((String)localObject);
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        paramString = paramString.substring(i);
        d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
        paramString = new o(Double.valueOf(d), Double.valueOf(Double.parseDouble(paramString)));
        AppMethodBeat.o(167966);
        return paramString;
        label372:
        AppMethodBeat.o(167966);
        return null;
      }
      i += 1;
    }
  }
  
  public static String ZV(String paramString)
  {
    AppMethodBeat.i(178463);
    d.g.b.k.h(paramString, "desc");
    if (paramString.length() > 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramString = paramString.substring(0, 2);
      d.g.b.k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString + "***";
      AppMethodBeat.o(178463);
      return paramString;
    }
    AppMethodBeat.o(178463);
    return paramString;
  }
  
  public static int a(bmc parambmc)
  {
    AppMethodBeat.i(167947);
    d.g.b.k.h(parambmc, "content");
    if (parambmc.mediaList.size() == 0)
    {
      AppMethodBeat.o(167947);
      return 4;
    }
    int i = ((bmd)parambmc.mediaList.get(0)).mediaType;
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    if (!com.tencent.mm.plugin.finder.storage.logic.b.a.cqK().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(167947);
      return i;
    }
    if ((i == 4) && (parambmc.mediaList.size() > 1))
    {
      AppMethodBeat.o(167947);
      return 8;
    }
    parambmc = parambmc.mediaList;
    if (parambmc != null)
    {
      parambmc = ((Iterable)parambmc).iterator();
      while (parambmc.hasNext()) {
        if (((bmd)parambmc.next()).mediaType != i)
        {
          AppMethodBeat.o(167947);
          return 8;
        }
      }
    }
    AppMethodBeat.o(167947);
    return i;
  }
  
  public static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167968);
    d.g.b.k.h(paramInputStream, "inputStream");
    com.tencent.mm.plugin.gallery.picker.b.b.a locala = com.tencent.mm.plugin.gallery.picker.b.b.rDt;
    paramInputStream = com.tencent.mm.plugin.gallery.picker.b.b.a.a(paramInputStream, paramInt1, paramInt2, true, false);
    AppMethodBeat.o(167968);
    return paramInputStream;
  }
  
  public static f a(final RecyclerView paramRecyclerView, final Rect paramRect)
  {
    AppMethodBeat.i(199676);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(paramRect, "globalVisibleRect");
    final f localf = new f();
    final RecyclerView.a locala = paramRecyclerView.getAdapter();
    if ((locala instanceof WxRecyclerAdapter))
    {
      int k = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < k)
      {
        final View localView = paramRecyclerView.getChildAt(i);
        Object localObject;
        final v.e locale;
        int j;
        final com.tencent.mm.view.recyclerview.f localf1;
        if (localView != null)
        {
          localObject = paramRecyclerView.bh(localView);
          if ((localObject != null) && ((localObject instanceof com.tencent.mm.view.recyclerview.e)))
          {
            locale = new v.e();
            locale.Jhw = ((com.tencent.mm.view.recyclerview.a)((com.tencent.mm.view.recyclerview.e)localObject).fjf());
            if (!((com.tencent.mm.view.recyclerview.a)locale.Jhw instanceof BaseFinderFeed)) {
              break label584;
            }
            if (((com.tencent.mm.view.recyclerview.a)locale.Jhw).bMs() != 0L)
            {
              j = RecyclerView.bw(localView);
              int m = ((WxRecyclerAdapter)locala).Ibl.size();
              final com.tencent.mm.plugin.finder.event.base.k localk = new com.tencent.mm.plugin.finder.event.base.k((BaseFinderFeed)locale.Jhw, j - m, (byte)0);
              localf1 = (com.tencent.mm.view.recyclerview.f)((WxRecyclerAdapter)locala).LDZ.get(((com.tencent.mm.view.recyclerview.a)locale.Jhw).bMs());
              if (localf1 != null)
              {
                if (((BaseFinderFeed)locale.Jhw).feedObject.getFoldedLayout() != null)
                {
                  localObject = new Rect();
                  paramRecyclerView.getChildVisibleRect(localView, (Rect)localObject, null);
                  localf1.LDI = paramRect.top;
                  localf1.LDJ = paramRect.bottom;
                  localf1.LDH = ((Rect)localObject).top;
                  localObject = (FinderFoldedScrollLayout)localView.findViewById(2131307305);
                  if (localObject != null)
                  {
                    if (((FinderFoldedScrollLayout)localObject).getVisibility() != 0) {
                      break label476;
                    }
                    j = 1;
                    label320:
                    if (j == 0) {
                      break label481;
                    }
                    label324:
                    if (localObject != null)
                    {
                      ViewParent localViewParent = ((FinderFoldedScrollLayout)localObject).getParent();
                      if (localViewParent != null)
                      {
                        localViewParent = localViewParent.getParent();
                        if ((localViewParent != null) && ((localViewParent instanceof View)))
                        {
                          localf1.LDK = ((View)localViewParent).getTop();
                          localf1.LDO = new WeakReference(((FinderFoldedScrollLayout)localObject).getAdapter());
                          localf1.LDN = ((FinderFoldedScrollLayout)localObject).getAdapter().LEc;
                          if (localf1.LDK != 0) {
                            break label487;
                          }
                          ((View)localViewParent).post((Runnable)new g(localViewParent, (FinderFoldedScrollLayout)localObject, localf1, locale, localk, localView, paramRecyclerView, locala, paramRect, localf));
                        }
                      }
                    }
                  }
                }
                label451:
                localk.KMj = localf1;
              }
              localf.Lbl.add(localk);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label476:
          j = 0;
          break label320;
          label481:
          localObject = null;
          break label324;
          label487:
          if (localf1.LDJ - localf1.LDI - localf1.LDH > localf1.LDK)
          {
            if (localf1.LDL) {
              break label451;
            }
            localf1.LDL = true;
            localObject = localf1.LDO;
            if (localObject == null) {
              break label451;
            }
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject == null) {
              break label451;
            }
            ((WxRecyclerAdapter)localObject).onResume();
            break label451;
          }
          if (!localf1.LDL) {
            break label451;
          }
          localf1.LDL = false;
          localf1.LDM = true;
          break label451;
          label584:
          localf.Lbm.add((com.tencent.mm.view.recyclerview.a)locale.Jhw);
        }
      }
    }
    AppMethodBeat.o(199676);
    return localf;
  }
  
  public static String a(com.tencent.mm.plugin.finder.model.a parama)
  {
    AppMethodBeat.i(199672);
    d.g.b.k.h(parama, "item");
    Object localObject = parama.qDo;
    if (((com.tencent.mm.plugin.finder.storage.l)localObject).isOverlap())
    {
      parama = new StringBuilder();
      localObject = ((com.tencent.mm.plugin.finder.storage.l)localObject).field_aggregatedContacts.LxL.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
        parama.append(mS(localFinderContact.username, localFinderContact.nickname)).append("，");
      }
      localObject = parama.toString();
      d.g.b.k.g(localObject, "nickNameList.toString()");
      parama = (com.tencent.mm.plugin.finder.model.a)localObject;
      if (!bt.isNullOrNil((String)localObject))
      {
        int i = ((String)localObject).length();
        if (localObject == null)
        {
          parama = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199672);
          throw parama;
        }
        parama = ((String)localObject).substring(0, i - 1);
        d.g.b.k.g(parama, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      AppMethodBeat.o(199672);
      return parama;
    }
    parama = mS(((com.tencent.mm.plugin.finder.storage.l)localObject).field_username, ((com.tencent.mm.plugin.finder.storage.l)localObject).field_nickname);
    AppMethodBeat.o(199672);
    return parama;
  }
  
  public static List<com.tencent.mm.plugin.finder.event.base.k> a(int paramInt1, int paramInt2, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(199675);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    LinkedList localLinkedList = new LinkedList();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramInt2))
    {
      paramRecyclerView = d.a.j.q((Collection)localLinkedList);
      AppMethodBeat.o(199675);
      return paramRecyclerView;
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    if ((paramRecyclerView instanceof WxRecyclerAdapter))
    {
      List localList = (List)((WxRecyclerAdapter)paramRecyclerView).data;
      if (paramInt1 <= paramInt2) {
        for (;;)
        {
          int i = paramInt1 - ((WxRecyclerAdapter)paramRecyclerView).Ibl.size();
          if ((i >= 0) && (i < localList.size()))
          {
            Object localObject = (com.tencent.mm.view.recyclerview.a)localList.get(i);
            if (((localObject instanceof BaseFinderFeed)) && (((com.tencent.mm.view.recyclerview.a)localObject).bMs() != 0L))
            {
              com.tencent.mm.plugin.finder.event.base.k localk = new com.tencent.mm.plugin.finder.event.base.k((BaseFinderFeed)localObject, i, (byte)0);
              localObject = (com.tencent.mm.view.recyclerview.f)((WxRecyclerAdapter)paramRecyclerView).LDZ.get(((com.tencent.mm.view.recyclerview.a)localObject).bMs());
              if (localObject != null) {
                localk.KMj = ((com.tencent.mm.view.recyclerview.f)localObject);
              }
              localLinkedList.add(localk);
            }
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += 1;
        }
      }
    }
    paramRecyclerView = d.a.j.q((Collection)localLinkedList);
    AppMethodBeat.o(199675);
    return paramRecyclerView;
  }
  
  public static void a(Context paramContext, ajq paramajq)
  {
    AppMethodBeat.i(167954);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramajq, "location");
    if (bt.isNullOrNil(paramajq.DlE))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("map_view_type", 7);
      localIntent.putExtra("kwebmap_slat", paramajq.dpb);
      localIntent.putExtra("kwebmap_lng", paramajq.dqQ);
      String str = paramajq.goQ;
      localObject = str;
      if (bt.isNullOrNil(str)) {
        localObject = paramajq.evA;
      }
      localIntent.putExtra("kPoiName", (String)localObject);
      localIntent.putExtra("Kwebmap_locaion", paramajq.xoe);
      com.tencent.mm.bs.d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(167954);
      return;
    }
    Object localObject = z.Jhz;
    paramajq = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", Arrays.copyOf(new Object[] { paramajq.DlE }, 1));
    d.g.b.k.g(paramajq, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramajq);
    com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(167954);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    AppMethodBeat.i(167946);
    d.g.b.k.h(paramImageView, "imageView");
    d.g.b.k.h(paramString, "path");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    localOptions.inSampleSize = com.tencent.mm.sdk.platformtools.f.M(i, j, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    localOptions.inMutable = true;
    paramString = MMBitmapFactory.decodeFile(paramString, localOptions);
    paramImageView.setImageBitmap(paramString);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("filLocalImageToView preSize: ").append(i).append(", ").append(j).append(", finalSize:");
    if (paramString != null) {}
    for (paramImageView = Integer.valueOf(paramString.getWidth());; paramImageView = null)
    {
      localStringBuilder = localStringBuilder.append(paramImageView).append(", ");
      paramImageView = localObject;
      if (paramString != null) {
        paramImageView = Integer.valueOf(paramString.getHeight());
      }
      ad.i(str, paramImageView + ", viewSize: " + paramInt1 + ", " + paramInt2 + " inSampleSize:" + localOptions.inSampleSize);
      AppMethodBeat.o(167946);
      return;
    }
  }
  
  public static void a(final TextView paramTextView, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(199679);
    d.g.b.k.h(paramTextView, "tv");
    d.g.b.k.h(parama, "onClick");
    Object localObject = paramTextView.getContext();
    d.g.b.k.g(localObject, "tv.context");
    localObject = new SpannableString((CharSequence)((Context)localObject).getResources().getString(2131766401));
    ((SpannableString)localObject).setSpan(new h(parama, paramTextView), 7, 11, 33);
    parama = paramTextView.getContext();
    d.g.b.k.g(parama, "tv.context");
    paramTextView.setHighlightColor(parama.getResources().getColor(17170445));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
    AppMethodBeat.o(199679);
  }
  
  public static void a(LinkedList<FinderCommentInfo> paramLinkedList, long paramLong1, long paramLong2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(167960);
    d.g.b.k.h(paramLinkedList, "commentList");
    d.g.b.k.h(paramString, "clientId");
    int j;
    if (paramLong2 != 0L)
    {
      paramString = ((List)paramLinkedList).iterator();
      i = 0;
      if (paramString.hasNext()) {
        if (((FinderCommentInfo)paramString.next()).commentId == paramLong2)
        {
          j = 1;
          label75:
          if (j == 0) {
            break label181;
          }
        }
      }
    }
    Object localObject;
    label181:
    do
    {
      for (;;)
      {
        if (i >= 0)
        {
          paramLinkedList.remove(i);
          ad.i(TAG, "update expose commentList, remove at ".concat(String.valueOf(i)));
          paramString = new hd();
          paramString.dkK.feedId = paramLong1;
          localObject = paramString.dkK;
          ake localake = new ake();
          localake.commentList = paramLinkedList;
          ((hd.a)localObject).dkL = localake;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramString);
        }
        AppMethodBeat.o(167960);
        return;
        j = 0;
        break label75;
        i += 1;
        break;
        i = -1;
      }
      localObject = ((List)paramLinkedList).iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label250;
      }
    } while (d.g.b.k.g(((FinderCommentInfo)((Iterator)localObject).next()).client_id, paramString));
    for (;;)
    {
      i += 1;
      break;
      label250:
      i = -1;
    }
  }
  
  public static void a(List<? extends BaseFinderFeed> paramList, dzp paramdzp)
  {
    AppMethodBeat.i(199680);
    d.g.b.k.h(paramList, "remain");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)((Iterator)localObject).next();
      dzy localdzy = new dzy();
      localdzy.objectId = localBaseFinderFeed.feedObject.getId();
      localdzy.objectNonceId = localBaseFinderFeed.feedObject.getObjectNonceId();
      localdzy.IoU = 4;
      paramList.add(localdzy);
    }
    new com.tencent.mm.plugin.finder.cgi.k((List)paramList, paramdzp).auK();
    AppMethodBeat.o(199680);
  }
  
  public static boolean a(final Context paramContext, String paramString, boolean paramBoolean, final alv paramalv)
  {
    AppMethodBeat.i(199668);
    d.g.b.k.h(paramContext, "activity");
    if (bt.isNullOrNil(u.aqO()))
    {
      ad.i(TAG, "need create finder contact");
      String str = paramContext.getString(2131759174);
      if (!bt.isNullOrNil(paramString)) {
        str = paramString;
      }
      paramString = com.tencent.mm.plugin.finder.view.b.qVm;
      com.tencent.mm.plugin.finder.view.b.a.a(paramContext, paramContext.getString(2131759179), str, paramContext.getString(2131759178), paramContext.getString(2131759172), (DialogInterface.OnClickListener)new a(paramBoolean, paramalv, paramContext), (DialogInterface.OnClickListener)new b(paramBoolean), (DialogInterface.OnDismissListener)new c(paramBoolean));
      AppMethodBeat.o(199668);
      return false;
    }
    AppMethodBeat.o(199668);
    return true;
  }
  
  public static String aa(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178462);
    d.g.b.k.h(paramString1, "countryCode");
    d.g.b.k.h(paramString2, "provinceCode");
    d.g.b.k.h(paramString3, "cityCode");
    RegionCodeDecoder.eMO();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.eMO();
    String str2 = RegionCodeDecoder.lf(paramString1, paramString2);
    RegionCodeDecoder.eMO();
    paramString1 = RegionCodeDecoder.aU(paramString1, paramString2, paramString3);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString1 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sj(str2) + " " + paramString1;
      AppMethodBeat.o(178462);
      return paramString1;
    }
    if (!bt.isNullOrNil(str2))
    {
      paramString1 = str1 + ' ' + str2;
      AppMethodBeat.o(178462);
      return paramString1;
    }
    if (!bt.isNullOrNil(str1))
    {
      d.g.b.k.g(str1, "countryName");
      AppMethodBeat.o(178462);
      return str1;
    }
    AppMethodBeat.o(178462);
    return "";
  }
  
  public static int ahG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 1: 
      return 0;
    case 512: 
      return 5;
    case 2048: 
      return 7;
    case 1024: 
      return 6;
    case 128: 
      return 4;
    case 2: 
      return 1;
    case 4: 
      return 2;
    case 4096: 
      return 8;
    }
    return 10;
  }
  
  public static ae.a ahH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ae.a.LAY;
    case 0: 
      return ae.a.LAY;
    case 1: 
      return ae.a.LAZ;
    case 3: 
      return ae.a.LBa;
    case 2: 
      return ae.a.LBb;
    }
    return ae.a.LBd;
  }
  
  public static int ahI(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 3: 
      return 2048;
    case 1: 
      return 512;
    case 2: 
      return 1024;
    }
    return 4096;
  }
  
  public static boolean ahJ(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 25: 
    case 27: 
    case 29: 
    case 30: 
    case 31: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean al(Activity paramActivity)
  {
    AppMethodBeat.i(167944);
    d.g.b.k.h(paramActivity, "activity");
    Object localObject1 = g.afB();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(ae.a.Fwn, 0);
    ad.i(TAG, "check has realname userFlag %d", new Object[] { Integer.valueOf(i) });
    if ((i & 0x1) != 0)
    {
      h.vKh.m(1279L, 35L, 1L);
      localObject1 = paramActivity.getString(2131759340);
      if (!bt.isNullOrNil(null)) {
        localObject1 = null;
      }
      String str1 = paramActivity.getString(2131764859);
      Object localObject2 = com.tencent.mm.plugin.finder.view.b.qVm;
      localObject2 = (Context)paramActivity;
      String str2 = paramActivity.getString(2131759341);
      String str3 = paramActivity.getString(2131755691);
      paramActivity = (DialogInterface.OnClickListener)new d(paramActivity);
      d.g.b.k.h(localObject2, "context");
      com.tencent.mm.plugin.finder.view.b.a.a((Context)localObject2, str1, (String)localObject1, str2, str3, paramActivity, null, null);
      AppMethodBeat.o(167944);
      return false;
    }
    AppMethodBeat.o(167944);
    return true;
  }
  
  public static boolean c(bmd parambmd)
  {
    if (parambmd != null) {
      parambmd = parambmd.LzL;
    }
    return (parambmd == null) || (parambmd.LwV != true);
  }
  
  public static boolean crT()
  {
    AppMethodBeat.i(178458);
    if (!bt.isNullOrNil(u.aqO()))
    {
      AppMethodBeat.o(178458);
      return true;
    }
    AppMethodBeat.o(178458);
    return false;
  }
  
  public static String crU()
  {
    AppMethodBeat.i(167953);
    Object localObject = aj.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(167953);
      throw ((Throwable)localObject);
    }
    localObject = ((ClipboardManager)localObject).getPrimaryClip();
    if ((localObject != null) && (((ClipData)localObject).getItemCount() > 0))
    {
      localObject = ((ClipData)localObject).getItemAt(0);
      d.g.b.k.g(localObject, "clipData.getItemAt(0)");
      localObject = ((ClipData.Item)localObject).getText();
      if (localObject != null)
      {
        String str = localObject.toString();
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      AppMethodBeat.o(167953);
      return localObject;
    }
    AppMethodBeat.o(167953);
    return "";
  }
  
  public static String dc(String paramString, int paramInt)
  {
    AppMethodBeat.i(167962);
    d.g.b.k.h(paramString, "key");
    paramString = aj.getContext().getString(paramInt);
    d.g.b.k.g(paramString, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(167962);
    return paramString;
  }
  
  public static boolean f(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167948);
    d.g.b.k.h(paramFinderObject, "obj");
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    if (com.tencent.mm.plugin.finder.storage.logic.b.a.cqK().contains(Integer.valueOf(paramFinderObject.objectDesc.mediaType)))
    {
      AppMethodBeat.o(167948);
      return true;
    }
    if (paramFinderObject.objectDesc.media.size() == 0)
    {
      AppMethodBeat.o(167948);
      return false;
    }
    int i = ((FinderMedia)paramFinderObject.objectDesc.media.get(0)).mediaType;
    locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    if (!com.tencent.mm.plugin.finder.storage.logic.b.a.cqK().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(167948);
      return false;
    }
    paramFinderObject = paramFinderObject.objectDesc.media;
    if (paramFinderObject != null)
    {
      paramFinderObject = ((Iterable)paramFinderObject).iterator();
      while (paramFinderObject.hasNext()) {
        if (((FinderMedia)paramFinderObject.next()).mediaType != i)
        {
          AppMethodBeat.o(167948);
          return true;
        }
      }
    }
    AppMethodBeat.o(167948);
    return true;
  }
  
  public static Bundle fA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167942);
    Object localObject = aj.getContext();
    d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    d.g.b.k.g(localObject, "MMApplicationContext.getContext().resources");
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = aj.getContext();
    d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    d.g.b.k.g(localObject, "MMApplicationContext.getContext().resources");
    i = Math.min(i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    float f = paramInt2 * 1.0F / paramInt1;
    localObject = new Bundle();
    ((Bundle)localObject).putInt("media_layout_sale_type", ImageView.ScaleType.CENTER_CROP.ordinal());
    if (Math.abs(paramInt1 - paramInt2) <= 10)
    {
      ((Bundle)localObject).putInt("media_layout_width", i);
      ((Bundle)localObject).putInt("media_layout_height", i);
    }
    for (;;)
    {
      AppMethodBeat.o(167942);
      return localObject;
      if (paramInt2 * 1.0F / paramInt1 < 0.5625F)
      {
        ((Bundle)localObject).putInt("media_layout_width", i);
        ((Bundle)localObject).putInt("media_layout_height", (int)(i * 9.0F / 16.0F));
      }
      else if (paramInt2 * 1.0F / paramInt1 < 1.0F)
      {
        ((Bundle)localObject).putInt("media_layout_width", i);
        ((Bundle)localObject).putInt("media_layout_height", (int)(i * f));
      }
      else if (paramInt2 * 1.0F / paramInt1 < 1.166667F)
      {
        ((Bundle)localObject).putInt("media_layout_width", i);
        ((Bundle)localObject).putInt("media_layout_height", (int)(i * f));
      }
      else
      {
        ((Bundle)localObject).putInt("media_layout_width", i);
        ((Bundle)localObject).putInt("media_layout_height", (int)(i * 1.166667F));
      }
    }
  }
  
  public static Bundle fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167943);
    Bundle localBundle = new Bundle();
    float f = 1.0F * paramInt2 / paramInt1;
    localBundle.putInt("media_layout_sale_type", ImageView.ScaleType.FIT_XY.ordinal());
    localBundle.putInt("media_layout_width", qSY);
    localBundle.putInt("media_layout_height", (int)(f * qSY));
    AppMethodBeat.o(167943);
    return localBundle;
  }
  
  public static boolean fC(int paramInt1, int paramInt2)
  {
    return (paramInt2 == -4012) && (paramInt1 == 4);
  }
  
  public static String fW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167950);
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      AppMethodBeat.o(167950);
      return paramString1;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    com.tencent.mm.plugin.finder.api.b.a locala = com.tencent.mm.plugin.finder.api.b.qnX;
    boolean bool;
    if (paramString1 != null)
    {
      locala = com.tencent.mm.plugin.finder.api.b.qnX;
      bool = n.mB(paramString1, com.tencent.mm.plugin.finder.api.b.cko());
      if (!bool) {
        break label138;
      }
      if (bt.isNullOrNil(paramString2)) {
        break label103;
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      label82:
      localStringBuffer.append("displayName is is finder contact");
    }
    for (;;)
    {
      AppMethodBeat.o(167950);
      return paramString1;
      bool = false;
      break;
      label103:
      paramString2 = com.tencent.mm.plugin.finder.api.b.qnX;
      if (paramString1 == null) {
        d.g.b.k.fvU();
      }
      paramString1 = com.tencent.mm.plugin.finder.api.b.a.YL(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.Su();
        break label82;
      }
      paramString1 = "";
      break label82;
      label138:
      paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString1);
      d.g.b.k.g(paramString1, "ct");
      if ((paramString1.ZV() != 0) && (!bt.isNullOrNil(paramString1.ZX())))
      {
        paramString1 = paramString1.ZX();
        d.g.b.k.g(paramString1, "ct.displayRemark");
        localStringBuffer.append("displayName is ".concat(String.valueOf(paramString1)));
      }
      else if (!bt.isNullOrNil(paramString2))
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
      }
      else
      {
        paramString1 = paramString1.getUsername();
        d.g.b.k.g(paramString1, "ct.getUsername()");
      }
    }
  }
  
  public static boolean fWf()
  {
    AppMethodBeat.i(199674);
    com.tencent.mm.kernel.e locale = g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    if ((locale.afk().getInt(ae.a.Fwo, 0) & 0x20) != 0)
    {
      AppMethodBeat.o(199674);
      return true;
    }
    AppMethodBeat.o(199674);
    return false;
  }
  
  public static JSONObject fWg()
  {
    AppMethodBeat.i(199678);
    if (Lbj == null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("screenwidth", com.tencent.mm.cd.a.hV(aj.getContext()));
      ((JSONObject)localObject).put("screenheight", com.tencent.mm.cd.a.hW(aj.getContext()));
      Lbj = (JSONObject)localObject;
    }
    JSONObject localJSONObject = Lbj;
    Object localObject = localJSONObject;
    if (localJSONObject == null) {
      localObject = new JSONObject();
    }
    AppMethodBeat.o(199678);
    return localObject;
  }
  
  public static String fY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167969);
    if (!bt.T(new String[] { paramString1, paramString2 }))
    {
      paramString1 = aj.getResources().getString(2131759250, new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(167969);
      return paramString1;
    }
    if (!bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(167969);
      return paramString1;
    }
    if (!bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(167969);
      return paramString2;
    }
    AppMethodBeat.o(167969);
    return "";
  }
  
  public static int g(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167949);
    d.g.b.k.h(paramFinderObject, "obj");
    if (paramFinderObject.objectDesc == null) {
      ad.m(TAG, "obj ".concat(String.valueOf(paramFinderObject)), new Object[0]);
    }
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    if (com.tencent.mm.plugin.finder.storage.logic.b.a.cqK().contains(Integer.valueOf(paramFinderObject.objectDesc.mediaType)))
    {
      i = paramFinderObject.objectDesc.mediaType;
      AppMethodBeat.o(167949);
      return i;
    }
    if (paramFinderObject.objectDesc.media.size() == 0)
    {
      i = paramFinderObject.objectDesc.mediaType;
      AppMethodBeat.o(167949);
      return i;
    }
    int i = ((FinderMedia)paramFinderObject.objectDesc.media.get(0)).mediaType;
    locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    if (!com.tencent.mm.plugin.finder.storage.logic.b.a.cqK().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(167949);
      return i;
    }
    if ((i == 4) && (paramFinderObject.objectDesc.media.size() > 1))
    {
      AppMethodBeat.o(167949);
      return 8;
    }
    paramFinderObject = paramFinderObject.objectDesc.media;
    if (paramFinderObject != null)
    {
      paramFinderObject = ((Iterable)paramFinderObject).iterator();
      while (paramFinderObject.hasNext()) {
        if (((FinderMedia)paramFinderObject.next()).mediaType != i)
        {
          AppMethodBeat.o(167949);
          return 8;
        }
      }
    }
    AppMethodBeat.o(167949);
    return i;
  }
  
  public static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(167952);
    if (((d.g.b.k.g(paramString, u.aqG()) ^ true)) && (w.sD(paramString)))
    {
      AppMethodBeat.o(167952);
      return true;
    }
    AppMethodBeat.o(167952);
    return false;
  }
  
  public static boolean k(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167956);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (!bt.isNullOrNil(u.aqO()))
    {
      if (paramBaseFinderFeed != null) {}
      for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; n.I(paramBaseFinderFeed, u.aqO(), false); paramBaseFinderFeed = null)
      {
        AppMethodBeat.o(167956);
        return true;
      }
    }
    AppMethodBeat.o(167956);
    return false;
  }
  
  public static akf l(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167959);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    akf localakf = new akf();
    localakf.refObjectFlag = 1L;
    if (paramBaseFinderFeed.feedObject.getRefObjectFlag() == 1L) {
      localakf.refObjectId = paramBaseFinderFeed.feedObject.getRefObjectId();
    }
    FinderContact localFinderContact;
    for (localakf.refObjectContact = paramBaseFinderFeed.feedObject.getRefObjectContact();; localakf.refObjectContact = localFinderContact)
    {
      AppMethodBeat.o(167959);
      return localakf;
      localakf.refObjectId = paramBaseFinderFeed.feedObject.getId();
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      if (paramBaseFinderFeed == null) {
        d.g.b.k.fvU();
      }
      d.g.b.k.h(paramBaseFinderFeed, "$this$toServer");
      localFinderContact = new FinderContact();
      localFinderContact.username = paramBaseFinderFeed.getUsername();
      localFinderContact.headUrl = paramBaseFinderFeed.cks();
      localFinderContact.nickname = paramBaseFinderFeed.Su();
      localFinderContact.seq = paramBaseFinderFeed.field_version;
      localFinderContact.signature = paramBaseFinderFeed.field_signature;
      localFinderContact.followFlag = paramBaseFinderFeed.field_follow_Flag;
      localFinderContact.followTime = paramBaseFinderFeed.field_followTime;
      localFinderContact.coverImgUrl = paramBaseFinderFeed.field_coverImg;
      localFinderContact.spamStatus = paramBaseFinderFeed.field_spamStatus;
      localFinderContact.authInfo = paramBaseFinderFeed.field_authInfo;
    }
  }
  
  public static void l(List<? extends FinderItem> paramList, String paramString)
  {
    AppMethodBeat.i(167955);
    d.g.b.k.h(paramList, "list");
    d.g.b.k.h(paramString, "tag");
    ad.v(TAG, "---------------------------------------------------------------------printAllItemStart " + paramString + " count " + paramList.size() + "---------------------------------------------------------------------");
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramList = (FinderItem)localIterator.next();
      int j = paramList.getCreateTime();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("#").append(i).append(" print item id:").append(paramList.getId()).append(" rowid:").append(paramList.getLocalId()).append(" time: ").append(Integer.valueOf(j)).append(" sourceFlag:").append(paramList.field_sourceFlag).append(" username:");
      paramList = paramList.getFinderObject();
      if (paramList != null) {}
      for (paramList = paramList.username;; paramList = null)
      {
        ad.i(str, paramList);
        i += 1;
        break;
      }
    }
    ad.v(TAG, "---------------------------------------------------------------------printAllItemEnd " + paramString + "---------------------------------------------------------------------");
    AppMethodBeat.o(167955);
  }
  
  public static int lb(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      return (int)(100.0F * paramInt1 / paramInt2);
    }
    return 0;
  }
  
  public static void m(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(178459);
    d.g.b.k.h(paramFinderItem, "it");
    hd localhd = new hd();
    localhd.dkK.feedId = paramFinderItem.field_id;
    localhd.dkK.dkM = paramFinderItem.getCommentCount();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localhd);
    AppMethodBeat.o(178459);
  }
  
  private static String mS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199673);
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(199673);
        return "";
      }
    }
    else
    {
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      paramString1 = fW(str, paramString1);
    }
    AppMethodBeat.o(199673);
    return paramString1;
  }
  
  public static int qO(long paramLong)
  {
    return (int)(paramLong / 1000L);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(boolean paramBoolean, alv paramalv, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167933);
      g.ad(com.tencent.mm.plugin.i.a.j.class);
      if (this.qTb) {
        ((com.tencent.mm.plugin.i.a.j)g.ad(com.tencent.mm.plugin.i.a.j.class)).reportPostRedDot(10);
      }
      for (;;)
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("scene", 1);
        Object localObject = paramalv;
        if (localObject != null) {
          paramDialogInterface.putExtra("key_prepare_resp", ((alv)localObject).toByteArray());
        }
        localObject = a.qSb;
        a.u(paramContext, paramDialogInterface);
        AppMethodBeat.o(167933);
        return;
        ((com.tencent.mm.plugin.i.a.j)g.ad(com.tencent.mm.plugin.i.a.j.class)).reportPostRedDot(12);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167934);
      g.ad(com.tencent.mm.plugin.i.a.j.class);
      if (this.qTb) {
        ((com.tencent.mm.plugin.i.a.j)g.ad(com.tencent.mm.plugin.i.a.j.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.a.qFo;
        com.tencent.mm.plugin.finder.report.a.CL(5);
        AppMethodBeat.o(167934);
        return;
        ((com.tencent.mm.plugin.i.a.j)g.ad(com.tencent.mm.plugin.i.a.j.class)).reportPostRedDot(13);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class c
    implements DialogInterface.OnDismissListener
  {
    c(boolean paramBoolean) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(167936);
      g.ad(com.tencent.mm.plugin.i.a.j.class);
      if (this.qTb) {
        ((com.tencent.mm.plugin.i.a.j)g.ad(com.tencent.mm.plugin.i.a.j.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.a.qFo;
        com.tencent.mm.plugin.finder.report.a.CL(5);
        AppMethodBeat.o(167936);
        return;
        ((com.tencent.mm.plugin.i.a.j)g.ad(com.tencent.mm.plugin.i.a.j.class)).reportPostRedDot(13);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(Activity paramActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167938);
      paramDialogInterface = a.qSb;
      a.ak(this.lCU);
      AppMethodBeat.o(167938);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "", "feedId", "", "mediaId", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedPosition", "", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getFeedPosition", "()I", "getMediaId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class e
  {
    public final int Lbk;
    public final long feedId;
    public final String mediaId;
    public final BaseFinderFeed qHv;
    
    public e(long paramLong, String paramString, BaseFinderFeed paramBaseFinderFeed, int paramInt)
    {
      AppMethodBeat.i(199655);
      this.feedId = paramLong;
      this.mediaId = paramString;
      this.qHv = paramBaseFinderFeed;
      this.Lbk = paramInt;
      AppMethodBeat.o(199655);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199659);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((this.feedId != paramObject.feedId) || (!d.g.b.k.g(this.mediaId, paramObject.mediaId)) || (!d.g.b.k.g(this.qHv, paramObject.qHv)) || (this.Lbk != paramObject.Lbk)) {}
        }
      }
      else
      {
        AppMethodBeat.o(199659);
        return true;
      }
      AppMethodBeat.o(199659);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(199658);
      long l = this.feedId;
      int k = (int)(l ^ l >>> 32);
      Object localObject = this.mediaId;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.qHv;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        int m = this.Lbk;
        AppMethodBeat.o(199658);
        return ((i + k * 31) * 31 + j) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199657);
      String str = "CenterFeed(feedId=" + this.feedId + ", mediaId=" + this.mediaId + ", feed=" + this.qHv + ", feedPosition=" + this.Lbk + ")";
      AppMethodBeat.o(199657);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "", "feedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "notFeedDataList", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Ljava/util/LinkedList;Ljava/util/LinkedList;)V", "getFeedDataList", "()Ljava/util/LinkedList;", "setFeedDataList", "(Ljava/util/LinkedList;)V", "getNotFeedDataList", "setNotFeedDataList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class f
  {
    public LinkedList<com.tencent.mm.plugin.finder.event.base.k> Lbl;
    public LinkedList<com.tencent.mm.view.recyclerview.a> Lbm;
    
    private f(LinkedList<com.tencent.mm.plugin.finder.event.base.k> paramLinkedList, LinkedList<com.tencent.mm.view.recyclerview.a> paramLinkedList1)
    {
      AppMethodBeat.i(199660);
      this.Lbl = paramLinkedList;
      this.Lbm = paramLinkedList1;
      AppMethodBeat.o(199660);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199664);
      if (this != paramObject)
      {
        if ((paramObject instanceof f))
        {
          paramObject = (f)paramObject;
          if ((!d.g.b.k.g(this.Lbl, paramObject.Lbl)) || (!d.g.b.k.g(this.Lbm, paramObject.Lbm))) {}
        }
      }
      else
      {
        AppMethodBeat.o(199664);
        return true;
      }
      AppMethodBeat.o(199664);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(199663);
      LinkedList localLinkedList = this.Lbl;
      if (localLinkedList != null) {}
      for (int i = localLinkedList.hashCode();; i = 0)
      {
        localLinkedList = this.Lbm;
        if (localLinkedList != null) {
          j = localLinkedList.hashCode();
        }
        AppMethodBeat.o(199663);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199662);
      String str = "VisibleFeedDataObj(feedDataList=" + this.Lbl + ", notFeedDataList=" + this.Lbm + ")";
      AppMethodBeat.o(199662);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/utils/FinderUtil$getVisibleFeedListByAdapterPosRange$1$1$1$1$2$1$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$3", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$4", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$5"})
  static final class g
    implements Runnable
  {
    g(ViewParent paramViewParent, FinderFoldedScrollLayout paramFinderFoldedScrollLayout, com.tencent.mm.view.recyclerview.f paramf, v.e parame, com.tencent.mm.plugin.finder.event.base.k paramk, View paramView, RecyclerView paramRecyclerView, RecyclerView.a parama, Rect paramRect, i.f paramf1) {}
    
    public final void run()
    {
      AppMethodBeat.i(199665);
      localf1.LDK = ((View)this.Lbo).getTop();
      if (localf1.LDJ - localf1.LDI - localf1.LDH > localf1.LDK)
      {
        if (!localf1.LDL)
        {
          localf1.LDL = true;
          Object localObject = localf1.LDO;
          if (localObject != null)
          {
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject != null)
            {
              ((WxRecyclerAdapter)localObject).onResume();
              AppMethodBeat.o(199665);
              return;
            }
          }
          AppMethodBeat.o(199665);
        }
      }
      else if (localf1.LDL)
      {
        localf1.LDL = false;
        localf1.LDM = true;
      }
      AppMethodBeat.o(199665);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToMachineTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class h
    extends ClickableSpan
  {
    h(d.g.a.a parama, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199666);
      d.g.b.k.h(paramView, "widget");
      paramView = this.qYM;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(199666);
        return;
      }
      AppMethodBeat.o(199666);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(199667);
      d.g.b.k.h(paramTextPaint, "ds");
      Context localContext = paramTextView.getContext();
      d.g.b.k.g(localContext, "tv.context");
      paramTextPaint.setColor(localContext.getResources().getColor(2131099773));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(199667);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.i
 * JD-Core Version:    0.7.0.1
 */