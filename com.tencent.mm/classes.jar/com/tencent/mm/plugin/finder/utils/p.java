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
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.hk.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.search.e.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.k;
import com.tencent.mm.plugin.finder.view.k.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t.b;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.a.j;
import d.a.x;
import d.g.b.y.f;
import d.n.n;
import d.o;
import d.v;
import d.z;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil;", "", "()V", "MEDIA_MAX_HEIGHT_RATIO", "", "POST_WIDER_MEDIA_LAYOUT_SIZE", "", "TAG", "", "lastCenterFeedId", "", "margin", "mediaRect", "Landroid/graphics/Rect;", "screenInfoObj", "Lorg/json/JSONObject;", "getScreenInfoObj", "()Lorg/json/JSONObject;", "setScreenInfoObj", "(Lorg/json/JSONObject;)V", "blurVideoThumb", "Landroid/graphics/Bitmap;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "bitmap", "source", "calculateLayoutParams", "Landroid/widget/ImageView$ScaleType;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "params", "Landroid/view/ViewGroup$LayoutParams;", "view", "Landroid/view/View;", "calculatePercent", "offset", "total", "calculatePostLayoutParams", "Landroid/os/Bundle;", "width", "height", "calculateTimelineLayoutParams", "canFav", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "canReprint", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "canShare", "canShowTime", "checkHasAccountAndCreate", "activity", "Landroid/content/Context;", "tip", "showRed", "userPrepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "checkHasAccountToSendMsg", "checkHasRealname", "Landroid/app/Activity;", "titleStr", "checkIfAccountLegal", "checkIfMsgMute", "context", "extFlag", "checkShowCgiErrorAlter", "errType", "errCode", "errMsg", "clearFinderMsgLastBuf", "", "clearWxMsgLastBuf", "convertCompatibilityMediaType", "obj", "createIntentWithCache", "Landroid/content/Intent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "tag", "createVideoPreloadTask", "taskCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "currentTimeSecond", "decodeBitmap", "inputStream", "Ljava/io/InputStream;", "limitW", "limitH", "isRotate", "isClose", "fillLocalImageToView", "imageView", "Landroid/widget/ImageView;", "fillRefInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "fixRecyclerViewPosition", "initPos", "linearLayoutManager", "genPoiAddress", "descs", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinString_t;", "getClipData", "getCurrentScreenIndexInfo", "Lorg/json/JSONArray;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getDisplayName", "username", "nickname", "printLog", "getFeedListByAdapterPosRange", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "start", "end", "getFinderMsgSuffixColor", "scene", "getFinderPageDir", "getFromUserName", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getHint", "key", "resId", "getImageLocation", "Lkotlin/Pair;", "", "getImageWidthHeight", "Landroid/graphics/Point;", "filePath", "getLastBuffKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "tabType", "getListOfType", "E", "T", "dataList", "clazz", "Ljava/lang/Class;", "getLocationShowString", "countryCode", "provinceCode", "cityCode", "getMentionNick", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getNickName", "getPoiText", "city", "poiName", "getPrintDescription", "desc", "getScreenInfo", "getSelfNameByScene", "getSelfUsernameByScene", "getShareUiEnter", "reportScene", "getToUserName", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "getVideoLocation", "getVisibleFeedListByAdapterPosRange", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "globalVisibleRect", "hasCreateFinderIdentit", "hasFinderAccount", "isAcceptObj", "isCommentClose", "isFinderComment", "displayFlag", "isFinderScene", "isFlowCommentScene", "commentScene", "isFriend", "isFriendComment", "isLikeNotRecommend", "isMsgLikeEvent", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isNormalVideo", "localFinderMedia", "isPoster", "isPrivateAccount", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "isSelf", "isWxScene", "isWxSelf", "jumpLocation", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "jumpToWxProfile", "feedUsername", "intent", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedUserName", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "makeMediaTypeHappy", "content", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "default", "mapUnsigned", "mergeBackCacheAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "data", "updateLoaderLastBuf", "millisToUnixTime", "timestamp", "multiLet", "R", "T1", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "onFindNearByFeedId", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "firstPosition", "lastPosition", "isOnlyCareVideo", "postCommentCountChangedEvent", "it", "postExposeDelEvent", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "commentId", "clientId", "printAllItem", "list", "reportCollectUnreadItem", "remain", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "saveCacheToIntent", "position", "feedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "setAuthIcon", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "setToMachineTab", "tv", "Landroid/widget/TextView;", "onClick", "Lkotlin/Function0;", "setVisibility", "visibility", "shake", "Landroid/animation/ObjectAnimator;", "shakeFactor", "showBanToast", "wording", "showFinderTabType", "sourceFlagToLocalTypeFlag", "sourceType", "switchScene", "tabTypeToSourceFlag", "unixTimeToMillis", "CenterFeed", "VisibleFeedDataObj", "plugin-finder_release"})
public final class p
{
  private static final String TAG = "Finder.FinderUtil";
  private static long rNl;
  private static final int sMk;
  private static final int sMl;
  private static final Rect sMm;
  private static JSONObject sMn;
  public static final p sMo;
  
  static
  {
    AppMethodBeat.i(167970);
    sMo = new p();
    TAG = "Finder.FinderUtil";
    Context localContext = aj.getContext();
    d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    sMk = (int)localContext.getResources().getDimension(2131165284);
    localContext = aj.getContext();
    d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    sMl = (int)localContext.getResources().getDimension(2131166692);
    sMm = new Rect();
    rNl = -1L;
    AppMethodBeat.o(167970);
  }
  
  public static long FJ(int paramInt)
  {
    return paramInt * 1000L;
  }
  
  public static String FK(int paramInt)
  {
    AppMethodBeat.i(167961);
    Object localObject1 = "";
    switch (paramInt)
    {
    }
    while (bt.isNullOrNil((String)localObject1))
    {
      localObject1 = new StringBuilder();
      localObject2 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject2, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject2).ajh() + "finder/page/";
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
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    localObject1 = locale.ajh() + "finder/page/" + (String)localObject1 + '/';
    AppMethodBeat.o(167961);
    return localObject1;
  }
  
  public static boolean FL(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static String FM(int paramInt)
  {
    AppMethodBeat.i(167967);
    String str;
    if (paramInt == 2)
    {
      str = u.aAo();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(167967);
      return localObject;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.c.rHn;
    localObject = u.aAu();
    d.g.b.p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
    localObject = com.tencent.mm.plugin.finder.api.c.a.agW((String)localObject);
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.finder.api.g)localObject).VC();
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
  
  public static String FN(int paramInt)
  {
    AppMethodBeat.i(178461);
    if (paramInt == 2)
    {
      str = u.aAm();
      d.g.b.p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(178461);
      return str;
    }
    String str = u.aAu();
    d.g.b.p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(178461);
    return str;
  }
  
  public static int FO(int paramInt)
  {
    int i = 2;
    if (paramInt == 2) {
      i = 1;
    }
    return i;
  }
  
  public static boolean FP(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean FQ(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static int FR(int paramInt)
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
  
  public static al.a FS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return al.a.IHp;
    case 0: 
      return al.a.IHp;
    case 1: 
      return al.a.IHq;
    case 3: 
      return al.a.IHr;
    case 2: 
      return al.a.IHs;
    }
    return al.a.IHw;
  }
  
  public static int FT(int paramInt)
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
  
  public static boolean FU(int paramInt)
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
    case 31: 
    case 34: 
    default: 
      return false;
    }
    return true;
  }
  
  public static String FV(int paramInt)
  {
    AppMethodBeat.i(204556);
    switch (paramInt)
    {
    default: 
      String str = "unknow ".concat(String.valueOf(paramInt));
      AppMethodBeat.o(204556);
      return str;
    case 0: 
      AppMethodBeat.o(204556);
      return "TAB_TYPE_ALL";
    case 1: 
      AppMethodBeat.o(204556);
      return "TAB_TYPE_FRIEND";
    case 2: 
      AppMethodBeat.o(204556);
      return "TAB_TYPE_LBS";
    case 3: 
      AppMethodBeat.o(204556);
      return "TAB_TYPE_FOLLOW";
    }
    AppMethodBeat.o(204556);
    return "TAB_TYPE_MACHINE";
  }
  
  public static int FW(int paramInt)
  {
    if (paramInt == 2) {
      return 2131099660;
    }
    return 2131100018;
  }
  
  public static boolean Y(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(204535);
    d.g.b.p.h(paramContext, "context");
    if ((paramInt & 0x40) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(aj.getContext());
        locala.aXO(paramContext.getResources().getString(2131766830)).yU(true);
        locala.afp(2131766205).b((f.c)h.sMx).b((DialogInterface.OnDismissListener)i.sMy).show();
      }
      AppMethodBeat.o(204535);
      return bool;
    }
  }
  
  public static int a(bve parambve)
  {
    AppMethodBeat.i(167947);
    d.g.b.p.h(parambve, "content");
    if (parambve.mediaList.size() == 0)
    {
      AppMethodBeat.o(167947);
      return 4;
    }
    int i = ((bvf)parambve.mediaList.get(0)).mediaType;
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    if (!com.tencent.mm.plugin.finder.storage.logic.b.a.cJq().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(167947);
      return i;
    }
    if ((i == 4) && (parambve.mediaList.size() > 1))
    {
      AppMethodBeat.o(167947);
      return 8;
    }
    parambve = parambve.mediaList;
    if (parambve != null)
    {
      parambve = ((Iterable)parambve).iterator();
      while (parambve.hasNext()) {
        if (((bvf)parambve.next()).mediaType != i)
        {
          AppMethodBeat.o(167947);
          return 8;
        }
      }
    }
    AppMethodBeat.o(167947);
    return i;
  }
  
  public static Intent a(BaseFinderFeedLoader paramBaseFinderFeedLoader, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(204565);
    d.g.b.p.h(paramBaseFinderFeedLoader, "feedLoader");
    d.g.b.p.h(paramLinearLayoutManager, "layoutManager");
    Intent localIntent = new Intent();
    DataBuffer localDataBuffer = paramBaseFinderFeedLoader.getDataListJustForAdapter();
    com.tencent.mm.bx.b localb = paramBaseFinderFeedLoader.getLastBuffer();
    int k = paramBaseFinderFeedLoader.getInitPos();
    int j = paramLinearLayoutManager.km();
    int m = paramLinearLayoutManager.ko();
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "fixRVPos posStart:" + j + ", posEnd " + m + ", initPos:" + k);
    int i = j;
    if (k >= j)
    {
      i = j;
      if (k <= m) {
        i = -1;
      }
    }
    BaseFinderFeedLoader.saveCacheToIntent$default(paramBaseFinderFeedLoader, localIntent, (List)localDataBuffer, localb, i, null, 16, null);
    AppMethodBeat.o(204565);
    return localIntent;
  }
  
  public static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167968);
    d.g.b.p.h(paramInputStream, "inputStream");
    com.tencent.mm.plugin.gallery.picker.b.b.a locala = com.tencent.mm.plugin.gallery.picker.b.b.tIT;
    paramInputStream = com.tencent.mm.plugin.gallery.picker.b.b.a.a(paramInputStream, paramInt1, paramInt2, true, false);
    AppMethodBeat.o(167968);
    return paramInputStream;
  }
  
  public static com.tencent.mm.i.h a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, g.a parama, g.b paramb, int paramInt2, long paramLong, String paramString7)
  {
    AppMethodBeat.i(204569);
    d.g.b.p.h(paramString1, "mediaId");
    d.g.b.p.h(paramString2, "url");
    d.g.b.p.h(paramString3, "path");
    d.g.b.p.h(paramString4, "fileFormat");
    d.g.b.p.h(paramString5, "urlToken");
    d.g.b.p.h(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    boolean bool = com.tencent.mm.plugin.finder.storage.b.cGE();
    localObject = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.i.h)localObject).url = (paramString2 + paramString5);
    ((com.tencent.mm.i.h)localObject).field_fullpath = paramString3;
    ((com.tencent.mm.i.h)localObject).snsCipherKey = paramString6;
    ((com.tencent.mm.i.h)localObject).fJz = 2;
    ((com.tencent.mm.i.h)localObject).fJF = 2;
    ((com.tencent.mm.i.h)localObject).fJA = 8;
    ((com.tencent.mm.i.h)localObject).fJK = paramInt2;
    ((com.tencent.mm.i.h)localObject).field_preloadRatio = paramInt2;
    ((com.tencent.mm.i.h)localObject).concurrentCount = com.tencent.mm.plugin.i.a.d.a.tfM;
    ((com.tencent.mm.i.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().slk;
    ((com.tencent.mm.i.h)localObject).field_fileType = com.tencent.mm.i.a.fIF;
    ((com.tencent.mm.i.h)localObject).preloadMinSize = paramLong;
    ((com.tencent.mm.i.h)localObject).fJM = 0;
    ((com.tencent.mm.i.h)localObject).fJj = parama;
    ((com.tencent.mm.i.h)localObject).fJB = paramb;
    int i;
    if (!bool) {
      if (paramInt1 <= 0)
      {
        i = com.tencent.mm.modelcontrol.d.I(1, paramString3);
        ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = i;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i(paramString7, "[createVideoPreloadTask] finder video, reqFormat=" + paramInt1 + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject).url + " preloadPercent:" + paramInt2 + " preloadMinSize:" + paramLong);
      AppMethodBeat.o(204569);
      return localObject;
      i = paramInt1;
      break;
      ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.i.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.i.h a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, h.a parama, String paramString7)
  {
    AppMethodBeat.i(204568);
    d.g.b.p.h(paramString1, "mediaId");
    d.g.b.p.h(paramString2, "url");
    d.g.b.p.h(paramString3, "path");
    d.g.b.p.h(paramString4, "fileFormat");
    d.g.b.p.h(paramString5, "urlToken");
    d.g.b.p.h(parama, "videoCallback");
    d.g.b.p.h(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    boolean bool = com.tencent.mm.plugin.finder.storage.b.cGE();
    localObject = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject).fJi = "task_FinderUtil";
    ((com.tencent.mm.i.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.i.h)localObject).url = (paramString2 + paramString5);
    ((com.tencent.mm.i.h)localObject).fJn = 60;
    ((com.tencent.mm.i.h)localObject).fJo = 60;
    ((com.tencent.mm.i.h)localObject).fJF = 1;
    ((com.tencent.mm.i.h)localObject).fJA = 8;
    ((com.tencent.mm.i.h)localObject).fJM = 0;
    int i;
    if (!bool) {
      if (paramInt <= 0)
      {
        i = com.tencent.mm.modelcontrol.d.I(1, paramString3);
        ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = i;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.i.h)localObject).field_fullpath = paramString3;
      ((com.tencent.mm.i.h)localObject).concurrentCount = com.tencent.mm.plugin.i.a.d.a.tfM;
      ((com.tencent.mm.i.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().sll;
      ((com.tencent.mm.i.h)localObject).snsCipherKey = paramString6;
      ((com.tencent.mm.i.h)localObject).fJN = parama;
      com.tencent.mm.sdk.platformtools.ad.i(paramString7, "[loadByCdn] finder video, reqFormat=" + paramInt + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject).url + ' ');
      AppMethodBeat.o(204568);
      return localObject;
      i = paramInt;
      break;
      ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.i.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.plugin.finder.feed.model.e a(Intent paramIntent, RecyclerView paramRecyclerView, BaseFinderFeedLoader paramBaseFinderFeedLoader, boolean paramBoolean)
  {
    AppMethodBeat.i(204566);
    d.g.b.p.h(paramIntent, "data");
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(paramBaseFinderFeedLoader, "feedLoader");
    RecyclerView.a locala = paramRecyclerView.getAdapter();
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    paramBaseFinderFeedLoader.initBackCache(paramIntent);
    paramIntent = paramBaseFinderFeedLoader.getBackCache();
    if (((locala instanceof WxRecyclerAdapter)) && ((paramRecyclerView instanceof StaggeredGridLayoutManager)) && (paramIntent != null) && (!bt.hj((List)paramIntent.jfg)) && (paramIntent.lastBuffer != null))
    {
      int k = ((WxRecyclerAdapter)locala).Lvi.size();
      DataBuffer localDataBuffer = paramBaseFinderFeedLoader.getDataList();
      Object localObject2 = (Iterable)localDataBuffer;
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          j.gfB();
        }
        if (i >= k) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            ((Collection)localObject1).add(localObject3);
          }
          i += 1;
          break;
        }
      }
      localObject1 = (List)localObject1;
      if (((List)localObject1).size() != paramIntent.jfg.size())
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localDataBuffer.remove((al)((Iterator)localObject1).next());
        }
        localDataBuffer.addAll((Collection)paramIntent.jfg);
        if (paramBoolean) {
          paramBaseFinderFeedLoader.setLastBuffer(paramIntent.lastBuffer);
        }
        locala.notifyDataSetChanged();
      }
      if (paramIntent.position >= 0) {
        ((StaggeredGridLayoutManager)paramRecyclerView).ag(paramIntent.position + k, 0);
      }
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "mergeBackCacheAndNotify, pos:" + paramIntent.position + ", headCount:" + k);
      AppMethodBeat.o(204566);
      return paramIntent;
    }
    AppMethodBeat.o(204566);
    return null;
  }
  
  public static p.b a(final RecyclerView paramRecyclerView, final Rect paramRect)
  {
    AppMethodBeat.i(204549);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(paramRect, "globalVisibleRect");
    final p.b localb = new p.b();
    final RecyclerView.a locala = paramRecyclerView.getAdapter();
    final Set localSet = (Set)x.MKG;
    if ((locala instanceof WxRecyclerAdapter))
    {
      int k = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < k)
      {
        final View localView = paramRecyclerView.getChildAt(i);
        Object localObject;
        final y.f localf1;
        int j;
        final com.tencent.mm.view.recyclerview.f localf;
        if (localView != null)
        {
          localObject = paramRecyclerView.bh(localView);
          if ((localObject != null) && ((localObject instanceof com.tencent.mm.view.recyclerview.e)))
          {
            localf1 = new y.f();
            localf1.MLV = ((com.tencent.mm.view.recyclerview.a)((com.tencent.mm.view.recyclerview.e)localObject).fQC());
            if ((!((com.tencent.mm.view.recyclerview.a)localf1.MLV instanceof BaseFinderFeed)) || (localSet.contains(Integer.valueOf(((BaseFinderFeed)localf1.MLV).feedObject.getMediaType())))) {
              break label624;
            }
            if (((com.tencent.mm.view.recyclerview.a)localf1.MLV).lP() != 0L)
            {
              j = RecyclerView.bw(localView);
              int m = ((WxRecyclerAdapter)locala).Lvi.size();
              final com.tencent.mm.plugin.finder.event.base.g localg = new com.tencent.mm.plugin.finder.event.base.g((BaseFinderFeed)localf1.MLV, j - m, (byte)0);
              localf = (com.tencent.mm.view.recyclerview.f)((WxRecyclerAdapter)locala).LvQ.get(((com.tencent.mm.view.recyclerview.a)localf1.MLV).lP());
              if (localf != null)
              {
                if (((BaseFinderFeed)localf1.MLV).feedObject.getFoldedLayout() != null)
                {
                  localObject = new Rect();
                  paramRecyclerView.getChildVisibleRect(localView, (Rect)localObject, null);
                  localf.Lvy = paramRect.top;
                  localf.Lvz = paramRect.bottom;
                  localf.Lvx = ((Rect)localObject).top;
                  localObject = (FinderFoldedScrollLayout)localView.findViewById(2131307336);
                  if (localObject != null)
                  {
                    if (((FinderFoldedScrollLayout)localObject).getVisibility() != 0) {
                      break label516;
                    }
                    j = 1;
                    label358:
                    if (j == 0) {
                      break label521;
                    }
                    label362:
                    if (localObject != null)
                    {
                      ViewParent localViewParent = ((FinderFoldedScrollLayout)localObject).getParent();
                      if (localViewParent != null)
                      {
                        localViewParent = localViewParent.getParent();
                        if ((localViewParent != null) && ((localViewParent instanceof View)))
                        {
                          localf.LvA = ((View)localViewParent).getTop();
                          localf.LvE = new WeakReference(((FinderFoldedScrollLayout)localObject).getAdapter());
                          localf.LvD = ((FinderFoldedScrollLayout)localObject).getAdapter().LvT;
                          if (localf.LvA != 0) {
                            break label527;
                          }
                          ((View)localViewParent).post((Runnable)new j(localViewParent, (FinderFoldedScrollLayout)localObject, localf, localf1, localg, localView, paramRecyclerView, localSet, locala, paramRect, localb));
                        }
                      }
                    }
                  }
                }
                label491:
                localg.rRb = localf;
              }
              localb.sMr.add(localg);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label516:
          j = 0;
          break label358;
          label521:
          localObject = null;
          break label362;
          label527:
          if (localf.Lvz - localf.Lvy - localf.Lvx > localf.LvA)
          {
            if (localf.LvB) {
              break label491;
            }
            localf.LvB = true;
            localObject = localf.LvE;
            if (localObject == null) {
              break label491;
            }
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject == null) {
              break label491;
            }
            ((WxRecyclerAdapter)localObject).onResume();
            break label491;
          }
          if (!localf.LvB) {
            break label491;
          }
          localf.LvB = false;
          localf.LvC = true;
          break label491;
          label624:
          if ((com.tencent.mm.view.recyclerview.a)localf1.MLV != null) {
            localb.sMs.add((com.tencent.mm.view.recyclerview.a)localf1.MLV);
          }
        }
      }
    }
    AppMethodBeat.o(204549);
    return localb;
  }
  
  public static String a(com.tencent.mm.plugin.finder.model.a parama)
  {
    AppMethodBeat.i(204538);
    d.g.b.p.h(parama, "item");
    Object localObject = parama.sjN;
    if (((ac)localObject).isOverlap())
    {
      parama = new StringBuilder();
      localObject = ((ac)localObject).field_aggregatedContacts.GnK.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
        parama.append(gz(localFinderContact.username, localFinderContact.nickname)).append("，");
      }
      localObject = parama.toString();
      d.g.b.p.g(localObject, "nickNameList.toString()");
      parama = (com.tencent.mm.plugin.finder.model.a)localObject;
      if (!bt.isNullOrNil((String)localObject))
      {
        int i = ((String)localObject).length();
        if (localObject == null)
        {
          parama = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(204538);
          throw parama;
        }
        parama = ((String)localObject).substring(0, i - 1);
        d.g.b.p.g(parama, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      AppMethodBeat.o(204538);
      return parama;
    }
    parama = gz(((ac)localObject).field_username, ((ac)localObject).field_nickname);
    AppMethodBeat.o(204538);
    return parama;
  }
  
  public static List<com.tencent.mm.plugin.finder.event.base.g> a(int paramInt1, int paramInt2, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(204548);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    LinkedList localLinkedList = new LinkedList();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramInt2))
    {
      paramRecyclerView = j.s((Collection)localLinkedList);
      AppMethodBeat.o(204548);
      return paramRecyclerView;
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    List localList;
    int i;
    Object localObject1;
    if ((paramRecyclerView instanceof WxRecyclerAdapter))
    {
      localList = (List)((WxRecyclerAdapter)paramRecyclerView).data;
      if (paramInt1 <= paramInt2) {
        for (;;)
        {
          i = paramInt1 - ((WxRecyclerAdapter)paramRecyclerView).Lvi.size();
          if ((i >= 0) && (i < localList.size()))
          {
            Object localObject2 = (com.tencent.mm.view.recyclerview.a)localList.get(i);
            if (((localObject2 instanceof BaseFinderFeed)) && (((com.tencent.mm.view.recyclerview.a)localObject2).lP() != 0L))
            {
              localObject1 = new com.tencent.mm.plugin.finder.event.base.g((BaseFinderFeed)localObject2, i, (byte)0);
              localObject2 = (com.tencent.mm.view.recyclerview.f)((WxRecyclerAdapter)paramRecyclerView).LvQ.get(((com.tencent.mm.view.recyclerview.a)localObject2).lP());
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.finder.event.base.g)localObject1).rRb = ((com.tencent.mm.view.recyclerview.f)localObject2);
              }
              localLinkedList.add(localObject1);
            }
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += 1;
        }
      }
    }
    else if ((paramRecyclerView instanceof com.tencent.mm.plugin.finder.search.f.a))
    {
      localList = ((com.tencent.mm.plugin.finder.search.f.a)paramRecyclerView).stt.sts.cyt();
      if (paramInt1 <= paramInt2)
      {
        i = paramInt1;
        paramInt1 = com.tencent.mm.plugin.finder.search.f.a(((com.tencent.mm.plugin.finder.search.f.a)paramRecyclerView).stt);
        if (i < paramInt1) {
          paramInt1 = -1;
        }
        for (;;)
        {
          if ((paramInt1 >= 0) && (paramInt1 < localList.size()))
          {
            localObject1 = (BaseFinderFeed)localList.get(paramInt1);
            if (((localObject1 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject1).lP() != 0L)) {
              localLinkedList.add(new com.tencent.mm.plugin.finder.event.base.g((BaseFinderFeed)localObject1, paramInt1, (byte)0));
            }
          }
          if (i == paramInt2) {
            break label355;
          }
          i += 1;
          break;
          if (i == paramInt1) {
            paramInt1 = -1;
          } else {
            paramInt1 = i - paramInt1 - 1;
          }
        }
      }
    }
    label355:
    paramRecyclerView = j.s((Collection)localLinkedList);
    AppMethodBeat.o(204548);
    return paramRecyclerView;
  }
  
  public static <T, E> List<E> a(List<? extends T> paramList, Class<E> paramClass)
  {
    AppMethodBeat.i(204562);
    d.g.b.p.h(paramList, "dataList");
    d.g.b.p.h(paramClass, "clazz");
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (paramClass.isInstance(localObject)) {
        localList.add(localObject);
      }
    }
    AppMethodBeat.o(204562);
    return localList;
  }
  
  public static void a(int paramInt, List<? extends al> paramList, com.tencent.mm.bx.b paramb, Intent paramIntent, com.tencent.mm.plugin.finder.feed.model.a parama)
  {
    AppMethodBeat.i(204563);
    d.g.b.p.h(paramList, "feedList");
    d.g.b.p.h(paramIntent, "intent");
    FinderEmptyLoader localFinderEmptyLoader = new FinderEmptyLoader();
    localFinderEmptyLoader.getDataList().addAll((Collection)paramList);
    localFinderEmptyLoader.setLastBuffer(paramb);
    localFinderEmptyLoader.saveCache(paramIntent, paramInt, parama);
    AppMethodBeat.o(204563);
  }
  
  public static void a(int paramInt, List<? extends BaseFinderFeed> paramList, aqy paramaqy)
  {
    AppMethodBeat.i(204553);
    d.g.b.p.h(paramList, "remain");
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (BaseFinderFeed)paramList.next();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.d.szI;
      if (!com.tencent.mm.plugin.finder.storage.data.d.a.af(paramInt, ((BaseFinderFeed)localObject1).feedObject.getId()))
      {
        localObject2 = new ask();
        ((ask)localObject2).rIZ = ((BaseFinderFeed)localObject1).feedObject.getId();
        ((ask)localObject2).objectNonceId = ((BaseFinderFeed)localObject1).feedObject.getObjectNonceId();
        if (paramaqy != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
          ((ask)localObject2).sessionBuffer = com.tencent.mm.plugin.finder.report.h.I(((ask)localObject2).rIZ, paramaqy.rTD);
        }
        ((ask)localObject2).duh = 4;
        localLinkedList.add(localObject2);
      }
    }
    if (!((Collection)localLinkedList).isEmpty()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        new com.tencent.mm.plugin.finder.cgi.a((List)localLinkedList, paramaqy).aED();
      }
      AppMethodBeat.o(204553);
      return;
    }
  }
  
  public static void a(Context paramContext, aoy paramaoy)
  {
    AppMethodBeat.i(167954);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramaoy, "location");
    if (bt.isNullOrNil(paramaoy.Gnu))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("map_view_type", 7);
      localIntent.putExtra("kwebmap_slat", paramaoy.dyz);
      localIntent.putExtra("kwebmap_lng", paramaoy.dAp);
      String str = paramaoy.jDf;
      localObject = str;
      if (bt.isNullOrNil(str)) {
        localObject = paramaoy.ePv;
      }
      localIntent.putExtra("kPoiName", (String)localObject);
      localIntent.putExtra("Kwebmap_locaion", paramaoy.zSk);
      com.tencent.mm.bs.d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(167954);
      return;
    }
    Object localObject = d.g.b.ad.MLZ;
    paramaoy = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", Arrays.copyOf(new Object[] { paramaoy.Gnu }, 1));
    d.g.b.p.g(paramaoy, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramaoy);
    com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(167954);
  }
  
  public static void a(ImageView paramImageView, FinderAuthInfo paramFinderAuthInfo)
  {
    AppMethodBeat.i(204570);
    d.g.b.p.h(paramImageView, "view");
    paramImageView.setVisibility(8);
    Object localObject = paramImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setColorFilter(null);
    }
    if (paramFinderAuthInfo != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "authType = " + paramFinderAuthInfo.authIconType + ", authIconUrl = " + paramFinderAuthInfo.authIconUrl);
      paramImageView.setVisibility(0);
      if (paramFinderAuthInfo.authIconType > 0)
      {
        switch (paramFinderAuthInfo.authIconType)
        {
        default: 
          paramImageView.setVisibility(8);
          AppMethodBeat.o(204570);
          return;
        case 1: 
          localObject = (CharSequence)paramFinderAuthInfo.authIconUrl;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
          for (int i = 1; i == 0; i = 0)
          {
            localObject = com.tencent.mm.plugin.finder.loader.i.sja;
            localObject = com.tencent.mm.plugin.finder.loader.i.cCB();
            paramFinderAuthInfo = new com.tencent.mm.plugin.finder.loader.l(paramFinderAuthInfo.authIconUrl, r.syD);
            com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
            ((com.tencent.mm.loader.d)localObject).a(paramFinderAuthInfo, paramImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjb));
            AppMethodBeat.o(204570);
            return;
          }
          paramImageView.setImageDrawable(ao.k(paramImageView.getContext(), 2131690481, com.tencent.mm.cc.a.n(paramImageView.getContext(), 2131100725)));
          AppMethodBeat.o(204570);
          return;
        case 2: 
          paramImageView.setImageResource(2131691604);
          AppMethodBeat.o(204570);
          return;
        }
        paramImageView.setVisibility(8);
        AppMethodBeat.o(204570);
        return;
      }
      paramImageView.setVisibility(8);
      AppMethodBeat.o(204570);
      return;
    }
    AppMethodBeat.o(204570);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    AppMethodBeat.i(167946);
    d.g.b.p.h(paramImageView, "imageView");
    d.g.b.p.h(paramString, "path");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    localOptions.inSampleSize = com.tencent.mm.sdk.platformtools.g.O(i, j, paramInt1, paramInt2);
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
      com.tencent.mm.sdk.platformtools.ad.i(str, paramImageView + ", viewSize: " + paramInt1 + ", " + paramInt2 + " inSampleSize:" + localOptions.inSampleSize);
      AppMethodBeat.o(167946);
      return;
    }
  }
  
  public static void a(final TextView paramTextView, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(204552);
    d.g.b.p.h(paramTextView, "tv");
    d.g.b.p.h(parama, "onClick");
    Object localObject1 = paramTextView.getContext();
    d.g.b.p.g(localObject1, "tv.context");
    localObject1 = ((Context)localObject1).getResources();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1 = ((Resources)localObject1).getString(2131766930, new Object[] { com.tencent.mm.plugin.finder.storage.b.cGD() });
    localObject2 = paramTextView.getContext();
    d.g.b.p.g(localObject2, "tv.context");
    localObject2 = ((Context)localObject2).getResources();
    Object localObject3 = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject2 = ((Resources)localObject2).getString(2131766931, new Object[] { com.tencent.mm.plugin.finder.storage.b.cGD() });
    d.g.b.p.g(localObject1, "str");
    localObject3 = (CharSequence)localObject1;
    d.g.b.p.g(localObject2, "strForIndex");
    int i = n.a((CharSequence)localObject3, (String)localObject2, 0, false, 6);
    int j = i + ((String)localObject2).length();
    localObject2 = new SpannableString((CharSequence)localObject1);
    if ((i <= 0) || (j > ((String)localObject1).length()))
    {
      j = ((String)localObject1).length();
      i = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject2).setSpan(new k(parama, paramTextView), i, j, 33);
      parama = paramTextView.getContext();
      d.g.b.p.g(parama, "tv.context");
      paramTextView.setHighlightColor(parama.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject2);
      AppMethodBeat.o(204552);
      return;
    }
  }
  
  public static void a(com.tencent.mm.view.recyclerview.e parame, String paramString, m paramm)
  {
    AppMethodBeat.i(204540);
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramString, "feedUserName");
    d.g.b.p.h(paramm, "item");
    if (d.g.b.p.i(paramm.skh.getUsername(), u.aAm()))
    {
      AppMethodBeat.o(204540);
      return;
    }
    Intent localIntent = new Intent();
    if ((!bt.isNullOrNil(paramString)) && (d.g.b.p.i(paramString, u.aAu())))
    {
      if ((paramm.skh.eQt() == 0) && (!bt.isNullOrNil(paramm.skh.getUsername())) && (!u.aAm().equals(paramm.skh.getUsername()))) {
        localIntent.putExtra("Action", 1);
      }
      localIntent.putExtra("feedUser", paramString);
    }
    for (;;)
    {
      localIntent.putExtra("Avatar", paramm.skh.cIH());
      localIntent.putExtra("Nickname", paramm.skh.VC());
      localIntent.putExtra("CommentId", paramm.skh.cIG());
      localIntent.putExtra("FeedId", paramm.skh.field_feedId);
      localIntent.putExtra("FeedNonceId", paramm.skh.field_objectNonceId);
      paramString = paramm.skh.field_actionInfo.Gla;
      if ((paramString != null) && (paramString.msgInfo != null))
      {
        localIntent.putExtra("ContactMsgInfo", paramm.skh.field_actionInfo.Gla.msgInfo.toByteArray());
        parame = parame.getContext();
        d.g.b.p.g(parame, "holder.context");
        c(parame, paramm.skh.getUsername(), localIntent);
      }
      if (paramm.skh.field_actionInfo.Gla != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "commentInfo = null");
      AppMethodBeat.o(204540);
      return;
      localIntent.putExtra("Action", 2);
    }
    if (paramm.skh.field_actionInfo.Gla.msgInfo == null) {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "msgInfo is null ,feedId:" + paramm.skh.field_feedId + ",comentId:" + paramm.skh.cIG());
    }
    AppMethodBeat.o(204540);
  }
  
  public static void a(LinkedList<FinderCommentInfo> paramLinkedList, long paramLong1, long paramLong2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(167960);
    d.g.b.p.h(paramLinkedList, "commentList");
    d.g.b.p.h(paramString, "clientId");
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
          com.tencent.mm.sdk.platformtools.ad.i(TAG, "update expose commentList, remove at ".concat(String.valueOf(i)));
          paramString = new hk();
          paramString.dtQ.dtq = paramLong1;
          localObject = paramString.dtQ;
          aqa localaqa = new aqa();
          localaqa.commentList = paramLinkedList;
          ((hk.a)localObject).dtR = localaqa;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramString);
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
    } while (d.g.b.p.i(((FinderCommentInfo)((Iterator)localObject).next()).client_id, paramString));
    for (;;)
    {
      i += 1;
      break;
      label250:
      i = -1;
    }
  }
  
  public static boolean a(final Context paramContext, String paramString, boolean paramBoolean, final asp paramasp)
  {
    AppMethodBeat.i(204533);
    d.g.b.p.h(paramContext, "activity");
    if (bt.isNullOrNil(u.aAu()))
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "need create finder contact");
      String str = paramContext.getString(2131759174);
      if (!bt.isNullOrNil(paramString)) {
        str = paramString;
      }
      paramString = com.tencent.mm.plugin.finder.view.c.sSb;
      com.tencent.mm.plugin.finder.view.c.a.a(paramContext, paramContext.getString(2131759179), str, paramContext.getString(2131759178), paramContext.getString(2131759172), (DialogInterface.OnClickListener)new c(paramBoolean, paramasp, paramContext), (DialogInterface.OnClickListener)new d(paramBoolean), (DialogInterface.OnDismissListener)new e(paramBoolean));
      AppMethodBeat.o(204533);
      return false;
    }
    AppMethodBeat.o(204533);
    return true;
  }
  
  public static String ae(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178462);
    d.g.b.p.h(paramString1, "countryCode");
    d.g.b.p.h(paramString2, "provinceCode");
    d.g.b.p.h(paramString3, "cityCode");
    RegionCodeDecoder.fsz();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.fsz();
    String str2 = RegionCodeDecoder.ma(paramString1, paramString2);
    RegionCodeDecoder.fsz();
    paramString1 = RegionCodeDecoder.bg(paramString1, paramString2, paramString3);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zh(str2) + " " + paramString1;
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
      d.g.b.p.g(str1, "countryName");
      AppMethodBeat.o(178462);
      return str1;
    }
    AppMethodBeat.o(178462);
    return "";
  }
  
  public static com.tencent.mm.plugin.sight.base.a aiV(String paramString)
  {
    AppMethodBeat.i(167939);
    d.g.b.p.h(paramString, "filePath");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(167939);
      return null;
    }
    com.tencent.mm.plugin.sight.base.e.axx(paramString);
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
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(i) });
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
  
  public static Point aiW(String paramString)
  {
    AppMethodBeat.i(167940);
    d.g.b.p.h(paramString, "filePath");
    Point localPoint = new Point();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    com.tencent.mm.sdk.platformtools.g.decodeFile(paramString, localOptions);
    localPoint.x = localOptions.outWidth;
    localPoint.y = localOptions.outHeight;
    paramString = Exif.fromFile(paramString);
    d.g.b.p.g(paramString, "Exif.fromFile(filePath)");
    if (paramString.getOrientationInDegree() % 180 != 0)
    {
      int i = localPoint.y;
      localPoint.y = localPoint.x;
      localPoint.x = i;
    }
    AppMethodBeat.o(167940);
    return localPoint;
  }
  
  public static boolean aiX(String paramString)
  {
    AppMethodBeat.i(167957);
    if ((!bt.isNullOrNil(u.aAu())) && (!bt.isNullOrNil(paramString)) && (n.H(paramString, u.aAu(), false)))
    {
      AppMethodBeat.o(167957);
      return true;
    }
    AppMethodBeat.o(167957);
    return false;
  }
  
  public static boolean aiY(String paramString)
  {
    AppMethodBeat.i(167958);
    boolean bool = bt.lQ(paramString, u.aAm());
    AppMethodBeat.o(167958);
    return bool;
  }
  
  public static o<Double, Double> aiZ(String paramString)
  {
    AppMethodBeat.i(167965);
    d.g.b.p.h(paramString, "path");
    Object localObject = new q(new ExifInterface(com.tencent.mm.vfs.i.k(paramString, false)));
    paramString = ((q)localObject).sMN;
    localObject = ((q)localObject).sMM;
    if ((localObject != null) && (paramString != null))
    {
      paramString = new o(Double.valueOf(((Float)localObject).floatValue()), Double.valueOf(paramString.floatValue()));
      AppMethodBeat.o(167965);
      return paramString;
    }
    AppMethodBeat.o(167965);
    return null;
  }
  
  public static o<Double, Double> aja(String paramString)
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
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        break label372;
      }
      d.g.b.p.g(paramString, "locationString");
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
    d.g.b.p.g(paramString, "(this as java.lang.String).toCharArray()");
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
        d.g.b.p.g(paramString, "locSb.toString()");
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
        d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        double d = Double.parseDouble((String)localObject);
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        paramString = paramString.substring(i);
        d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
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
  
  public static String ajb(String paramString)
  {
    AppMethodBeat.i(178463);
    d.g.b.p.h(paramString, "desc");
    if (paramString.length() > 5)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramString = paramString.substring(0, 5);
      d.g.b.p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString + "***";
      AppMethodBeat.o(178463);
      return paramString;
    }
    AppMethodBeat.o(178463);
    return paramString;
  }
  
  public static String am(bu parambu)
  {
    AppMethodBeat.i(204554);
    d.g.b.p.h(parambu, "msg");
    if (parambu.VR() == 1)
    {
      parambu = u.aAm();
      d.g.b.p.g(parambu, "ConfigStorageLogic.getUsernameFromUserInfo()");
    }
    for (;;)
    {
      AppMethodBeat.o(204554);
      return parambu;
      if (!w.vF(parambu.VS())) {
        break;
      }
      parambu = bj.Bk(parambu.getContent());
      d.g.b.p.g(parambu, "MsgInfoStorageLogic.getG…hatMsgTalker(msg.content)");
    }
    parambu = parambu.VS();
    d.g.b.p.g(parambu, "msg.talker");
    AppMethodBeat.o(204554);
    return parambu;
  }
  
  public static boolean amf(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static int amg(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    case 13: 
      return 5;
    case 14: 
      return 6;
    }
    return 7;
  }
  
  public static String an(bu parambu)
  {
    AppMethodBeat.i(204555);
    d.g.b.p.h(parambu, "msg");
    if (parambu.VR() == 1)
    {
      parambu = parambu.VS();
      d.g.b.p.g(parambu, "msg.talker");
    }
    for (;;)
    {
      AppMethodBeat.o(204555);
      return parambu;
      if (w.vF(parambu.VS()))
      {
        parambu = parambu.VS();
        d.g.b.p.g(parambu, "msg.talker");
      }
      else
      {
        parambu = u.aAm();
        d.g.b.p.g(parambu, "ConfigStorageLogic.getUsernameFromUserInfo()");
      }
    }
  }
  
  public static void ar(Context paramContext, String paramString)
  {
    AppMethodBeat.i(204547);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString, "wording");
    com.tencent.mm.ui.base.t.a(paramContext, paramString, (t.b)p.l.sML);
    AppMethodBeat.o(204547);
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(204541);
    d.g.b.p.h(paramContext, "context");
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "jump to wx profile %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    if (!bt.isNullOrNil(paramString)) {
      localIntent.putExtra("Username", paramString);
    }
    paramString = k.sWA;
    k.a.X(paramContext, localIntent);
    AppMethodBeat.o(204541);
  }
  
  public static boolean cLB()
  {
    AppMethodBeat.i(204542);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    if ((locale.ajl().getInt(al.a.IGW, 0) & 0x20) != 0)
    {
      AppMethodBeat.o(204542);
      return true;
    }
    AppMethodBeat.o(204542);
    return false;
  }
  
  public static boolean cLC()
  {
    AppMethodBeat.i(204543);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    if ((locale.ajl().getInt(al.a.IGW, 0) & 0x400) != 0)
    {
      AppMethodBeat.o(204543);
      return true;
    }
    AppMethodBeat.o(204543);
    return false;
  }
  
  public static JSONObject cLD()
  {
    AppMethodBeat.i(204551);
    if (sMn == null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("screenwidth", com.tencent.mm.cc.a.ip(aj.getContext()));
      ((JSONObject)localObject).put("screenheight", com.tencent.mm.cc.a.iq(aj.getContext()));
      sMn = (JSONObject)localObject;
    }
    JSONObject localJSONObject = sMn;
    Object localObject = localJSONObject;
    if (localJSONObject == null) {
      localObject = new JSONObject();
    }
    AppMethodBeat.o(204551);
    return localObject;
  }
  
  public static void cLE()
  {
    AppMethodBeat.i(204557);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIw, "");
    locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIx, "");
    locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIz, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIA, Integer.valueOf(0));
    AppMethodBeat.o(204557);
  }
  
  public static void cLF()
  {
    AppMethodBeat.i(204558);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIt, "");
    locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIy, Integer.valueOf(0));
    AppMethodBeat.o(204558);
  }
  
  public static boolean cLy()
  {
    AppMethodBeat.i(178458);
    if (!bt.isNullOrNil(u.aAu()))
    {
      AppMethodBeat.o(178458);
      return true;
    }
    AppMethodBeat.o(178458);
    return false;
  }
  
  public static String cLz()
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
      d.g.b.p.g(localObject, "clipData.getItemAt(0)");
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
  
  public static boolean d(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(204571);
    d.g.b.p.h(paramContext, "context");
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramContext = new com.tencent.mm.ui.widget.a.d.a(paramContext);
        paramContext.aXG(paramString);
        paramContext.yR(true);
        paramContext.afl(2131755835);
        paramContext.show();
        AppMethodBeat.o(204571);
        return true;
      }
    }
    AppMethodBeat.o(204571);
    return false;
  }
  
  public static boolean d(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167956);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (!bt.isNullOrNil(u.aAu()))
    {
      if (paramBaseFinderFeed != null) {}
      for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; n.H(paramBaseFinderFeed, u.aAu(), false); paramBaseFinderFeed = null)
      {
        AppMethodBeat.o(167956);
        return true;
      }
    }
    AppMethodBeat.o(167956);
    return false;
  }
  
  public static boolean d(bvf parambvf)
  {
    if (parambvf != null) {
      parambvf = parambvf.GPu;
    }
    return (parambvf == null) || (parambvf.FZx != true);
  }
  
  public static String dx(String paramString, int paramInt)
  {
    AppMethodBeat.i(167962);
    d.g.b.p.h(paramString, "key");
    paramString = aj.getContext().getString(paramInt);
    d.g.b.p.g(paramString, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(167962);
    return paramString;
  }
  
  public static void eh(View paramView)
  {
    AppMethodBeat.i(204559);
    if (((paramView == null) || (paramView.getVisibility() != 0)) && (paramView != null))
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(204559);
      return;
    }
    AppMethodBeat.o(204559);
  }
  
  public static Bundle fS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167942);
    Object localObject = aj.getContext();
    d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    d.g.b.p.g(localObject, "MMApplicationContext.getContext().resources");
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = aj.getContext();
    d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    d.g.b.p.g(localObject, "MMApplicationContext.getContext().resources");
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
      else if (paramInt2 * 1.0F / paramInt1 < 1.316667F)
      {
        ((Bundle)localObject).putInt("media_layout_width", i);
        ((Bundle)localObject).putInt("media_layout_height", (int)(i * f));
      }
      else
      {
        ((Bundle)localObject).putInt("media_layout_width", i);
        ((Bundle)localObject).putInt("media_layout_height", (int)(i * 1.316667F));
      }
    }
  }
  
  public static Bundle fT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167943);
    Bundle localBundle = new Bundle();
    float f = 1.0F * paramInt2 / paramInt1;
    localBundle.putInt("media_layout_sale_type", ImageView.ScaleType.FIT_XY.ordinal());
    localBundle.putInt("media_layout_width", sMl);
    localBundle.putInt("media_layout_height", (int)(f * sMl));
    AppMethodBeat.o(167943);
    return localBundle;
  }
  
  public static boolean fU(int paramInt1, int paramInt2)
  {
    return (paramInt2 == -4012) && (paramInt1 == 4);
  }
  
  public static int fV(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      return (int)(100.0F * paramInt1 / paramInt2);
    }
    return 0;
  }
  
  public static String gw(String paramString1, String paramString2)
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
    com.tencent.mm.plugin.finder.api.c.a locala = com.tencent.mm.plugin.finder.api.c.rHn;
    boolean bool;
    if (paramString1 != null)
    {
      bool = n.nA(paramString1, "@finder");
      if (!bool) {
        break label133;
      }
      if (bt.isNullOrNil(paramString2)) {
        break label98;
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      label77:
      localStringBuffer.append("displayName is is finder contact");
    }
    for (;;)
    {
      AppMethodBeat.o(167950);
      return paramString1;
      bool = false;
      break;
      label98:
      paramString2 = com.tencent.mm.plugin.finder.api.c.rHn;
      if (paramString1 == null) {
        d.g.b.p.gfZ();
      }
      paramString1 = com.tencent.mm.plugin.finder.api.c.a.agW(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.VC();
        break label77;
      }
      paramString1 = "";
      break label77;
      label133:
      paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString1);
      d.g.b.p.g(paramString1, "ct");
      if ((paramString1.adt() != 0) && (!bt.isNullOrNil(paramString1.adv())))
      {
        paramString1 = paramString1.adv();
        d.g.b.p.g(paramString1, "ct.displayRemark");
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
        d.g.b.p.g(paramString1, "ct.getUsername()");
      }
    }
  }
  
  public static String gy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167969);
    if (!bt.V(new String[] { paramString1, paramString2 }))
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
  
  public static String gz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204539);
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(204539);
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
      paramString1 = gw(str, paramString1);
    }
    AppMethodBeat.o(204539);
    return paramString1;
  }
  
  public static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(167952);
    if (paramString == null)
    {
      AppMethodBeat.o(167952);
      return false;
    }
    if ((!n.nA(paramString, "@stranger")) && ((d.g.b.p.i(paramString, u.aAm()) ^ true)) && (w.zD(paramString)))
    {
      AppMethodBeat.o(167952);
      return true;
    }
    AppMethodBeat.o(167952);
    return false;
  }
  
  public static boolean j(com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(204544);
    if (paramg != null) {}
    for (String str = paramg.getUsername(); d.g.b.p.i(str, u.aAu()); str = null)
    {
      boolean bool = cLC();
      AppMethodBeat.o(204544);
      return bool;
    }
    if (paramg != null) {}
    for (int i = paramg.field_extFlag; (i & 0x400) != 0; i = 0)
    {
      AppMethodBeat.o(204544);
      return true;
    }
    AppMethodBeat.o(204544);
    return false;
  }
  
  public static void k(List<? extends FinderItem> paramList, String paramString)
  {
    AppMethodBeat.i(167955);
    d.g.b.p.h(paramList, "list");
    d.g.b.p.h(paramString, "tag");
    com.tencent.mm.sdk.platformtools.ad.v(TAG, "---------------------------------------------------------------------printAllItemStart " + paramString + " count " + paramList.size() + "---------------------------------------------------------------------");
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
        com.tencent.mm.sdk.platformtools.ad.i(str, paramList);
        i += 1;
        break;
      }
    }
    com.tencent.mm.sdk.platformtools.ad.v(TAG, "---------------------------------------------------------------------printAllItemEnd " + paramString + "---------------------------------------------------------------------");
    AppMethodBeat.o(167955);
  }
  
  public static aqb n(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167959);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    aqb localaqb = new aqb();
    localaqb.refObjectFlag = 1L;
    if (paramBaseFinderFeed.feedObject.getRefObjectFlag() == 1L) {
      localaqb.refObjectId = paramBaseFinderFeed.feedObject.getRefObjectId();
    }
    FinderContact localFinderContact;
    for (localaqb.refObjectContact = paramBaseFinderFeed.feedObject.getRefObjectContact();; localaqb.refObjectContact = localFinderContact)
    {
      AppMethodBeat.o(167959);
      return localaqb;
      localaqb.refObjectId = paramBaseFinderFeed.feedObject.getId();
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      if (paramBaseFinderFeed == null) {
        d.g.b.p.gfZ();
      }
      d.g.b.p.h(paramBaseFinderFeed, "$this$toServer");
      localFinderContact = new FinderContact();
      localFinderContact.username = paramBaseFinderFeed.getUsername();
      localFinderContact.headUrl = paramBaseFinderFeed.cxL();
      localFinderContact.nickname = paramBaseFinderFeed.VC();
      localFinderContact.seq = paramBaseFinderFeed.field_version;
      localFinderContact.signature = paramBaseFinderFeed.field_signature;
      localFinderContact.followFlag = paramBaseFinderFeed.field_follow_Flag;
      localFinderContact.followTime = paramBaseFinderFeed.field_followTime;
      localFinderContact.coverImgUrl = paramBaseFinderFeed.field_coverImg;
      localFinderContact.authInfo = paramBaseFinderFeed.field_authInfo;
      localFinderContact.coverImgUrl = paramBaseFinderFeed.field_coverImg;
      localFinderContact.spamStatus = paramBaseFinderFeed.field_spamStatus;
      localFinderContact.extInfo = paramBaseFinderFeed.field_extInfo;
      localFinderContact.originalFlag = paramBaseFinderFeed.field_originalFlag;
      localFinderContact.originalInfo = paramBaseFinderFeed.field_originalInfo;
      localFinderContact.extFlag = paramBaseFinderFeed.field_extFlag;
    }
  }
  
  public static boolean o(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(204560);
    d.g.b.p.h(paramBaseFinderFeed, "item");
    if ((paramBaseFinderFeed.feedObject.getFeedObject().incFriendLikeCount > 0) && (paramBaseFinderFeed.feedObject.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(204560);
      return true;
    }
    AppMethodBeat.o(204560);
    return false;
  }
  
  public static boolean o(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167948);
    d.g.b.p.h(paramFinderObject, "obj");
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    if (com.tencent.mm.plugin.finder.storage.logic.b.a.cJq().contains(Integer.valueOf(paramFinderObject.objectDesc.mediaType)))
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
    locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    if (!com.tencent.mm.plugin.finder.storage.logic.b.a.cJq().contains(Integer.valueOf(i)))
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
          return false;
        }
      }
    }
    AppMethodBeat.o(167948);
    return true;
  }
  
  public static int p(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167949);
    d.g.b.p.h(paramFinderObject, "obj");
    if (paramFinderObject.objectDesc == null) {
      com.tencent.mm.sdk.platformtools.ad.m(TAG, "obj ".concat(String.valueOf(paramFinderObject)), new Object[0]);
    }
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    if (com.tencent.mm.plugin.finder.storage.logic.b.a.cJq().contains(Integer.valueOf(paramFinderObject.objectDesc.mediaType)))
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
    locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    if (!com.tencent.mm.plugin.finder.storage.logic.b.a.cJq().contains(Integer.valueOf(i)))
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
  
  public static void q(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(178459);
    d.g.b.p.h(paramFinderItem, "it");
    hk localhk = new hk();
    localhk.dtQ.dtq = paramFinderItem.field_id;
    localhk.dtQ.dtS = paramFinderItem.getCommentCount();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localhk);
    AppMethodBeat.o(178459);
  }
  
  public static boolean q(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(204545);
    d.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x1) == 0)
    {
      AppMethodBeat.o(204545);
      return true;
    }
    AppMethodBeat.o(204545);
    return false;
  }
  
  public static boolean r(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204561);
    d.g.b.p.h(paramFinderItem, "item");
    if ((paramFinderItem.getFeedObject().incFriendLikeCount > 0) && (paramFinderItem.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(204561);
      return true;
    }
    AppMethodBeat.o(204561);
    return false;
  }
  
  public static boolean r(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(204546);
    d.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x2) == 0)
    {
      AppMethodBeat.o(204546);
      return true;
    }
    AppMethodBeat.o(204546);
    return false;
  }
  
  public static boolean s(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(221555);
    d.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x4) != 0)
    {
      AppMethodBeat.o(221555);
      return true;
    }
    AppMethodBeat.o(221555);
    return false;
  }
  
  public static JSONArray x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(204550);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(204550);
      throw paramRecyclerView;
    }
    Object localObject2 = (StaggeredGridLayoutManager)localObject1;
    localObject1 = ((StaggeredGridLayoutManager)localObject2).n(null);
    localObject2 = ((StaggeredGridLayoutManager)localObject2).mA();
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
        Object localObject3 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("feedid", com.tencent.mm.ad.c.rc(((com.tencent.mm.plugin.finder.event.base.g)localObject3).rQZ.lP()));
        ((JSONObject)localObject2).put("feedindex", ((com.tencent.mm.plugin.finder.event.base.g)localObject3).rRa);
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)localObject3).rRb;
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put("x", ((com.tencent.mm.view.recyclerview.f)localObject3).LvF + 1);
          ((JSONObject)localObject2).put("width", ((com.tencent.mm.view.recyclerview.f)localObject3).width);
          ((JSONObject)localObject2).put("height", ((com.tencent.mm.view.recyclerview.f)localObject3).height);
        }
        paramRecyclerView.put(localObject2);
      }
      i = 0;
      break;
    }
    AppMethodBeat.o(204550);
    return paramRecyclerView;
  }
  
  public static int xo(long paramLong)
  {
    return (int)(paramLong / 1000L);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "", "feedId", "", "mediaId", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedPosition", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "currentFeedList", "Ljava/util/LinkedList;", "getCurrentFeedList", "()Ljava/util/LinkedList;", "setCurrentFeedList", "(Ljava/util/LinkedList;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getFeedPosition", "()I", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getMediaId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public final long dtq;
    public final String mediaId;
    public final com.tencent.mm.view.recyclerview.e rMM;
    public final BaseFinderFeed rQZ;
    public LinkedList<a> sMp;
    public final int sMq;
    
    public a(long paramLong, String paramString, BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(204513);
      this.dtq = paramLong;
      this.mediaId = paramString;
      this.rQZ = paramBaseFinderFeed;
      this.sMq = paramInt;
      this.rMM = parame;
      this.sMp = new LinkedList();
      AppMethodBeat.o(204513);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(204517);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.dtq != paramObject.dtq) || (!d.g.b.p.i(this.mediaId, paramObject.mediaId)) || (!d.g.b.p.i(this.rQZ, paramObject.rQZ)) || (this.sMq != paramObject.sMq) || (!d.g.b.p.i(this.rMM, paramObject.rMM))) {}
        }
      }
      else
      {
        AppMethodBeat.o(204517);
        return true;
      }
      AppMethodBeat.o(204517);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(204516);
      long l = this.dtq;
      int m = (int)(l ^ l >>> 32);
      Object localObject = this.mediaId;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.rQZ;
        if (localObject == null) {
          break label115;
        }
      }
      label115:
      for (int j = localObject.hashCode();; j = 0)
      {
        int n = this.sMq;
        localObject = this.rMM;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(204516);
        return ((j + (i + m * 31) * 31) * 31 + n) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204515);
      String str = "CenterFeed(feedId=" + this.dtq + ", mediaId=" + this.mediaId + ", feed=" + this.rQZ + ", feedPosition=" + this.sMq + ", holder=" + this.rMM + ")";
      AppMethodBeat.o(204515);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(boolean paramBoolean, asp paramasp, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167933);
      com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
      if (this.sMt) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(10);
      }
      for (;;)
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("scene", 1);
        Object localObject = paramasp;
        if (localObject != null) {
          paramDialogInterface.putExtra("key_prepare_resp", ((asp)localObject).toByteArray());
        }
        localObject = a.sKD;
        a.w(paramContext, paramDialogInterface);
        AppMethodBeat.o(167933);
        return;
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(12);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167934);
      com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
      if (this.sMt) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.f.soC;
        com.tencent.mm.plugin.finder.report.f.EW(5);
        AppMethodBeat.o(167934);
        return;
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(13);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class e
    implements DialogInterface.OnDismissListener
  {
    e(boolean paramBoolean) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(167936);
      com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
      if (this.sMt) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.f.soC;
        com.tencent.mm.plugin.finder.report.f.EW(5);
        AppMethodBeat.o(167936);
        return;
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(13);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(Activity paramActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167938);
      paramDialogInterface = a.sKD;
      a.ao(this.mFm);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.aj(7, false);
      AppMethodBeat.o(167938);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    public static final g sMw;
    
    static
    {
      AppMethodBeat.i(204524);
      sMw = new g();
      AppMethodBeat.o(204524);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(204523);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.aj(7, false);
      AppMethodBeat.o(204523);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class h
    implements f.c
  {
    public static final h sMx;
    
    static
    {
      AppMethodBeat.i(204525);
      sMx = new h();
      AppMethodBeat.o(204525);
    }
    
    public final void d(boolean paramBoolean, String paramString) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class i
    implements DialogInterface.OnDismissListener
  {
    public static final i sMy;
    
    static
    {
      AppMethodBeat.i(204526);
      sMy = new i();
      AppMethodBeat.o(204526);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/utils/FinderUtil$getVisibleFeedListByAdapterPosRange$1$1$1$1$2$1$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$3", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$4", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$5"})
  static final class j
    implements Runnable
  {
    j(ViewParent paramViewParent, FinderFoldedScrollLayout paramFinderFoldedScrollLayout, com.tencent.mm.view.recyclerview.f paramf, y.f paramf1, com.tencent.mm.plugin.finder.event.base.g paramg, View paramView, RecyclerView paramRecyclerView, Set paramSet, RecyclerView.a parama, Rect paramRect, p.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(204527);
      localf.LvA = ((View)this.sMz).getTop();
      if (localf.Lvz - localf.Lvy - localf.Lvx > localf.LvA)
      {
        if (!localf.LvB)
        {
          localf.LvB = true;
          Object localObject = localf.LvE;
          if (localObject != null)
          {
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject != null)
            {
              ((WxRecyclerAdapter)localObject).onResume();
              AppMethodBeat.o(204527);
              return;
            }
          }
          AppMethodBeat.o(204527);
        }
      }
      else if (localf.LvB)
      {
        localf.LvB = false;
        localf.LvC = true;
      }
      AppMethodBeat.o(204527);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToMachineTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class k
    extends ClickableSpan
  {
    k(d.g.a.a parama, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204528);
      d.g.b.p.h(paramView, "widget");
      paramView = this.sMK;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(204528);
        return;
      }
      AppMethodBeat.o(204528);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(204529);
      d.g.b.p.h(paramTextPaint, "ds");
      Context localContext = paramTextView.getContext();
      d.g.b.p.g(localContext, "tv.context");
      paramTextPaint.setColor(localContext.getResources().getColor(2131099773));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(204529);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p
 * JD-Core Version:    0.7.0.1
 */