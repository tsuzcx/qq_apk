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
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.a;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.hl.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.search.e.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.l.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t.b;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.ad;
import d.g.b.y.f;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil;", "", "()V", "MEDIA_MAX_HEIGHT_RATIO", "", "POST_WIDER_MEDIA_LAYOUT_SIZE", "", "TAG", "", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "margin", "mediaRect", "Landroid/graphics/Rect;", "screenInfoObj", "Lorg/json/JSONObject;", "getScreenInfoObj", "()Lorg/json/JSONObject;", "setScreenInfoObj", "(Lorg/json/JSONObject;)V", "blurVideoThumb", "Landroid/graphics/Bitmap;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "bitmap", "source", "calculateLayoutParams", "Landroid/widget/ImageView$ScaleType;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "params", "Landroid/view/ViewGroup$LayoutParams;", "view", "Landroid/view/View;", "calculatePercent", "offset", "total", "calculatePostLayoutParams", "Landroid/os/Bundle;", "width", "height", "calculateTimelineLayoutParams", "canFav", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "canReprint", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "canShare", "canShowTime", "checkHasAccountAndCreate", "activity", "Landroid/content/Context;", "tip", "showRed", "userPrepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "checkHasAccountToSendMsg", "checkHasRealname", "Landroid/app/Activity;", "titleStr", "checkIfAccountLegal", "checkIfMsgMute", "context", "extFlag", "checkShowCgiErrorAlter", "errType", "errCode", "errMsg", "checkUserState", "clearFinderMsgLastBuf", "", "clearWxMsgLastBuf", "convertCompatibilityMediaType", "obj", "createIntentWithCache", "Landroid/content/Intent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "tag", "createVideoPreloadTask", "taskCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "currentTimeSecond", "decodeBitmap", "inputStream", "Ljava/io/InputStream;", "limitW", "limitH", "isRotate", "isClose", "fillLocalImageToView", "imageView", "Landroid/widget/ImageView;", "fillRefInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "fixRecyclerViewPosition", "initPos", "linearLayoutManager", "genPoiAddress", "descs", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinString_t;", "getClipData", "getCurrentScreenIndexInfo", "Lorg/json/JSONArray;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getDisplayName", "username", "nickname", "printLog", "getFeedListByAdapterPosRange", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "start", "end", "getFinderMsgSuffixColor", "scene", "getFinderPageDir", "getFromUserName", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getHint", "key", "resId", "getImageLocation", "Lkotlin/Pair;", "", "getImageWidthHeight", "Landroid/graphics/Point;", "filePath", "getLastBuffKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "tabType", "getListOfType", "E", "T", "dataList", "clazz", "Ljava/lang/Class;", "getLocationShowString", "countryCode", "provinceCode", "cityCode", "getMentionNick", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getNickName", "getPoiText", "city", "poiName", "getPrintDescription", "desc", "getScreenInfo", "getSelfNameByScene", "getSelfUsernameByScene", "getShareUiEnter", "reportScene", "getToUserName", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "getVideoLocation", "getVisibleFeedListByAdapterPosRange", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "globalVisibleRect", "hasCreateFinderIdentit", "hasFinderAccount", "isAcceptObj", "isCommentClose", "isFinderComment", "displayFlag", "isFinderScene", "isFlowCommentScene", "commentScene", "isFriend", "isFriendComment", "isLikeNotRecommend", "isMsgLikeEvent", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isNormalVideo", "localFinderMedia", "isPoster", "isPrivateAccount", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "isSelf", "isWxScene", "isWxSelf", "jumpLocation", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "jumpToWxProfile", "feedUsername", "intent", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedUserName", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "makeMediaTypeHappy", "content", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "default", "mapUnsigned", "mergeBackCacheAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "data", "updateLoaderLastBuf", "millisToUnixTime", "timestamp", "multiLet", "R", "T1", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "onFindNearByFeedId", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "firstPosition", "lastPosition", "isOnlyCareVideo", "postCommentCountChangedEvent", "it", "postExposeDelEvent", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "commentId", "clientId", "printAllItem", "list", "reportCollectUnreadItem", "remain", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "saveCacheToIntent", "position", "feedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "setAuthIcon", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "setToMachineTab", "tv", "Landroid/widget/TextView;", "onClick", "Lkotlin/Function0;", "setVisibility", "visibility", "shake", "Landroid/animation/ObjectAnimator;", "shakeFactor", "showBanToast", "wording", "showFeedCommentInput", "ifShow", "type", "showFinderTabType", "sourceFlagToLocalTypeFlag", "sourceType", "switchScene", "tabTypeToSourceFlag", "unixTimeToMillis", "CenterFeed", "VisibleFeedDataObj", "plugin-finder_release"})
public final class p
{
  private static final String TAG = "Finder.FinderUtil";
  private static long rVz;
  private static final int sXv;
  private static final int sXw;
  private static final Rect sXx;
  private static JSONObject sXy;
  public static final p sXz;
  
  static
  {
    AppMethodBeat.i(167970);
    sXz = new p();
    TAG = "Finder.FinderUtil";
    Context localContext = ak.getContext();
    d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    sXv = (int)localContext.getResources().getDimension(2131165284);
    localContext = ak.getContext();
    d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    sXw = (int)localContext.getResources().getDimension(2131166692);
    sXx = new Rect();
    rVz = -1L;
    AppMethodBeat.o(167970);
  }
  
  public static long Gh(int paramInt)
  {
    return paramInt * 1000L;
  }
  
  public static String Gi(int paramInt)
  {
    AppMethodBeat.i(167961);
    Object localObject1 = "";
    switch (paramInt)
    {
    }
    while (bu.isNullOrNil((String)localObject1))
    {
      localObject1 = new StringBuilder();
      localObject2 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject2, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject2).ajw() + "finder/page/";
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
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    localObject1 = locale.ajw() + "finder/page/" + (String)localObject1 + '/';
    AppMethodBeat.o(167961);
    return localObject1;
  }
  
  public static boolean Gj(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static String Gk(int paramInt)
  {
    AppMethodBeat.i(167967);
    String str;
    if (paramInt == 2)
    {
      str = com.tencent.mm.model.v.aAE();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(167967);
      return localObject;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.c.rPy;
    localObject = com.tencent.mm.plugin.finder.api.c.a.ahT(com.tencent.mm.model.v.aAK());
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.finder.api.g)localObject).VK();
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
  
  public static String Gl(int paramInt)
  {
    AppMethodBeat.i(178461);
    if (paramInt == 2)
    {
      str = com.tencent.mm.model.v.aAC();
      d.g.b.p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(178461);
      return str;
    }
    String str = com.tencent.mm.model.v.aAK();
    d.g.b.p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(178461);
    return str;
  }
  
  public static int Gm(int paramInt)
  {
    int i = 2;
    if (paramInt == 2) {
      i = 1;
    }
    return i;
  }
  
  public static boolean Gn(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean Go(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean Gp(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static int Gq(int paramInt)
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
  
  public static am.a Gr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return am.a.JbS;
    case 0: 
      return am.a.JbS;
    case 1: 
      return am.a.JbT;
    case 3: 
      return am.a.JbU;
    case 2: 
      return am.a.JbV;
    }
    return am.a.JbZ;
  }
  
  public static int Gs(int paramInt)
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
  
  public static boolean Gt(int paramInt)
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
  
  public static String Gu(int paramInt)
  {
    AppMethodBeat.i(205177);
    switch (paramInt)
    {
    default: 
      String str = "unknow ".concat(String.valueOf(paramInt));
      AppMethodBeat.o(205177);
      return str;
    case 0: 
      AppMethodBeat.o(205177);
      return "TAB_TYPE_ALL";
    case 1: 
      AppMethodBeat.o(205177);
      return "TAB_TYPE_FRIEND";
    case 2: 
      AppMethodBeat.o(205177);
      return "TAB_TYPE_LBS";
    case 3: 
      AppMethodBeat.o(205177);
      return "TAB_TYPE_FOLLOW";
    }
    AppMethodBeat.o(205177);
    return "TAB_TYPE_MACHINE";
  }
  
  public static int Gv(int paramInt)
  {
    if (paramInt == 2) {
      return 2131099660;
    }
    return 2131100018;
  }
  
  public static int Gw(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    case 11: 
      return 5;
    case 14: 
      return 6;
    }
    return 7;
  }
  
  public static boolean Y(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205155);
    d.g.b.p.h(paramContext, "context");
    if ((paramInt & 0x40) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(ak.getContext());
        locala.aZq(paramContext.getResources().getString(2131766830)).zi(true);
        locala.afY(2131766205).b((f.c)p.h.sXI).b((DialogInterface.OnDismissListener)p.i.sXJ).show();
      }
      AppMethodBeat.o(205155);
      return bool;
    }
  }
  
  public static int a(bvy parambvy)
  {
    AppMethodBeat.i(167947);
    d.g.b.p.h(parambvy, "content");
    if (parambvy.mediaList.size() == 0)
    {
      AppMethodBeat.o(167947);
      return 4;
    }
    int i = ((bvz)parambvy.mediaList.get(0)).mediaType;
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
    if (!com.tencent.mm.plugin.finder.storage.logic.b.a.cLT().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(167947);
      return i;
    }
    if ((i == 4) && (parambvy.mediaList.size() > 1))
    {
      AppMethodBeat.o(167947);
      return 8;
    }
    parambvy = parambvy.mediaList;
    if (parambvy != null)
    {
      parambvy = ((Iterable)parambvy).iterator();
      while (parambvy.hasNext()) {
        if (((bvz)parambvy.next()).mediaType != i)
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
    AppMethodBeat.i(205186);
    d.g.b.p.h(paramBaseFinderFeedLoader, "feedLoader");
    d.g.b.p.h(paramLinearLayoutManager, "layoutManager");
    Intent localIntent = new Intent();
    DataBuffer localDataBuffer = paramBaseFinderFeedLoader.getDataListJustForAdapter();
    com.tencent.mm.bw.b localb = paramBaseFinderFeedLoader.getLastBuffer();
    int k = paramBaseFinderFeedLoader.getInitPos();
    int j = paramLinearLayoutManager.km();
    int m = paramLinearLayoutManager.ko();
    ae.i(TAG, "fixRVPos posStart:" + j + ", posEnd " + m + ", initPos:" + k);
    int i = j;
    if (k >= j)
    {
      i = j;
      if (k <= m) {
        i = -1;
      }
    }
    BaseFinderFeedLoader.saveCacheToIntent$default(paramBaseFinderFeedLoader, localIntent, (List)localDataBuffer, localb, i, null, 16, null);
    AppMethodBeat.o(205186);
    return localIntent;
  }
  
  public static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167968);
    d.g.b.p.h(paramInputStream, "inputStream");
    com.tencent.mm.plugin.gallery.picker.b.b.a locala = com.tencent.mm.plugin.gallery.picker.b.b.tTK;
    paramInputStream = com.tencent.mm.plugin.gallery.picker.b.b.a.a(paramInputStream, paramInt1, paramInt2, true, false);
    AppMethodBeat.o(167968);
    return paramInputStream;
  }
  
  public static com.tencent.mm.i.h a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, g.a parama, g.b paramb, int paramInt2, long paramLong, String paramString7)
  {
    AppMethodBeat.i(205190);
    d.g.b.p.h(paramString1, "mediaId");
    d.g.b.p.h(paramString2, "url");
    d.g.b.p.h(paramString3, "path");
    d.g.b.p.h(paramString4, "fileFormat");
    d.g.b.p.h(paramString5, "urlToken");
    d.g.b.p.h(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    boolean bool = com.tencent.mm.plugin.finder.storage.b.cIB();
    localObject = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.i.h)localObject).url = (paramString2 + paramString5);
    ((com.tencent.mm.i.h)localObject).field_fullpath = paramString3;
    ((com.tencent.mm.i.h)localObject).snsCipherKey = paramString6;
    ((com.tencent.mm.i.h)localObject).fLC = 2;
    ((com.tencent.mm.i.h)localObject).fLI = 2;
    ((com.tencent.mm.i.h)localObject).fLD = 8;
    ((com.tencent.mm.i.h)localObject).fLN = paramInt2;
    ((com.tencent.mm.i.h)localObject).field_preloadRatio = paramInt2;
    ((com.tencent.mm.i.h)localObject).concurrentCount = com.tencent.mm.plugin.i.a.d.a.tqF;
    ((com.tencent.mm.i.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().suh;
    ((com.tencent.mm.i.h)localObject).field_fileType = com.tencent.mm.i.a.fKJ;
    ((com.tencent.mm.i.h)localObject).preloadMinSize = paramLong;
    ((com.tencent.mm.i.h)localObject).fLP = 0;
    ((com.tencent.mm.i.h)localObject).fLm = parama;
    ((com.tencent.mm.i.h)localObject).fLE = paramb;
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
      ae.i(paramString7, "[createVideoPreloadTask] finder video, reqFormat=" + paramInt1 + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject).url + " preloadPercent:" + paramInt2 + " preloadMinSize:" + paramLong);
      AppMethodBeat.o(205190);
      return localObject;
      i = paramInt1;
      break;
      ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.i.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.i.h a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, h.a parama, String paramString7)
  {
    AppMethodBeat.i(205189);
    d.g.b.p.h(paramString1, "mediaId");
    d.g.b.p.h(paramString2, "url");
    d.g.b.p.h(paramString3, "path");
    d.g.b.p.h(paramString4, "fileFormat");
    d.g.b.p.h(paramString5, "urlToken");
    d.g.b.p.h(parama, "videoCallback");
    d.g.b.p.h(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    boolean bool = com.tencent.mm.plugin.finder.storage.b.cIB();
    localObject = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject).fLl = "task_FinderUtil";
    ((com.tencent.mm.i.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.i.h)localObject).url = (paramString2 + paramString5);
    ((com.tencent.mm.i.h)localObject).fLq = 60;
    ((com.tencent.mm.i.h)localObject).fLr = 60;
    ((com.tencent.mm.i.h)localObject).fLI = 1;
    ((com.tencent.mm.i.h)localObject).fLD = 8;
    ((com.tencent.mm.i.h)localObject).fLP = 0;
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
      ((com.tencent.mm.i.h)localObject).concurrentCount = com.tencent.mm.plugin.i.a.d.a.tqF;
      ((com.tencent.mm.i.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().sui;
      ((com.tencent.mm.i.h)localObject).snsCipherKey = paramString6;
      ((com.tencent.mm.i.h)localObject).fLQ = parama;
      ae.i(paramString7, "[loadByCdn] finder video, reqFormat=" + paramInt + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject).url + ' ');
      AppMethodBeat.o(205189);
      return localObject;
      i = paramInt;
      break;
      ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.i.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.plugin.finder.feed.model.e a(Intent paramIntent, RecyclerView paramRecyclerView, BaseFinderFeedLoader paramBaseFinderFeedLoader, boolean paramBoolean)
  {
    AppMethodBeat.i(205187);
    d.g.b.p.h(paramIntent, "data");
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(paramBaseFinderFeedLoader, "feedLoader");
    RecyclerView.a locala = paramRecyclerView.getAdapter();
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    paramBaseFinderFeedLoader.initBackCache(paramIntent);
    paramIntent = paramBaseFinderFeedLoader.getBackCache();
    if (((locala instanceof WxRecyclerAdapter)) && ((paramRecyclerView instanceof StaggeredGridLayoutManager)) && (paramIntent != null) && (!bu.ht((List)paramIntent.jhZ)) && (paramIntent.lastBuffer != null))
    {
      int k = ((WxRecyclerAdapter)locala).LRV.size();
      DataBuffer localDataBuffer = paramBaseFinderFeedLoader.getDataList();
      Object localObject2 = (Iterable)localDataBuffer;
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      int i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          d.a.j.gkd();
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
      if (((List)localObject1).size() != paramIntent.jhZ.size())
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localDataBuffer.remove((am)((Iterator)localObject1).next());
        }
        localDataBuffer.addAll((Collection)paramIntent.jhZ);
        if (paramBoolean) {
          paramBaseFinderFeedLoader.setLastBuffer(paramIntent.lastBuffer);
        }
        locala.notifyDataSetChanged();
      }
      if (paramIntent.position >= 0) {
        ((StaggeredGridLayoutManager)paramRecyclerView).ag(paramIntent.position + k, 0);
      }
      ae.i(TAG, "mergeBackCacheAndNotify, pos:" + paramIntent.position + ", headCount:" + k);
      AppMethodBeat.o(205187);
      return paramIntent;
    }
    AppMethodBeat.o(205187);
    return null;
  }
  
  public static p.b a(final RecyclerView paramRecyclerView, final Rect paramRect)
  {
    AppMethodBeat.i(205170);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(paramRect, "globalVisibleRect");
    final p.b localb = new p.b();
    final RecyclerView.a locala = paramRecyclerView.getAdapter();
    final Set localSet = (Set)d.a.x.NhJ;
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
            localf1.NiY = ((com.tencent.mm.view.recyclerview.a)((com.tencent.mm.view.recyclerview.e)localObject).fUY());
            if ((!((com.tencent.mm.view.recyclerview.a)localf1.NiY instanceof BaseFinderFeed)) || (localSet.contains(Integer.valueOf(((BaseFinderFeed)localf1.NiY).feedObject.getMediaType())))) {
              break label624;
            }
            if (((com.tencent.mm.view.recyclerview.a)localf1.NiY).lP() != 0L)
            {
              j = RecyclerView.bw(localView);
              int m = ((WxRecyclerAdapter)locala).LRV.size();
              final com.tencent.mm.plugin.finder.event.base.g localg = new com.tencent.mm.plugin.finder.event.base.g((BaseFinderFeed)localf1.NiY, j - m, (byte)0);
              localf = (com.tencent.mm.view.recyclerview.f)((WxRecyclerAdapter)locala).LSD.get(((com.tencent.mm.view.recyclerview.a)localf1.NiY).lP());
              if (localf != null)
              {
                if (((BaseFinderFeed)localf1.NiY).feedObject.getFoldedLayout() != null)
                {
                  localObject = new Rect();
                  paramRecyclerView.getChildVisibleRect(localView, (Rect)localObject, null);
                  localf.LSl = paramRect.top;
                  localf.LSm = paramRect.bottom;
                  localf.LSk = ((Rect)localObject).top;
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
                          localf.LSn = ((View)localViewParent).getTop();
                          localf.LSr = new WeakReference(((FinderFoldedScrollLayout)localObject).getAdapter());
                          localf.LSq = ((FinderFoldedScrollLayout)localObject).getAdapter().LSG;
                          if (localf.LSn != 0) {
                            break label527;
                          }
                          ((View)localViewParent).post((Runnable)new j(localViewParent, (FinderFoldedScrollLayout)localObject, localf, localf1, localg, localView, paramRecyclerView, localSet, locala, paramRect, localb));
                        }
                      }
                    }
                  }
                }
                label491:
                localg.rZD = localf;
              }
              localb.sXC.add(localg);
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
          if (localf.LSm - localf.LSl - localf.LSk > localf.LSn)
          {
            if (localf.LSo) {
              break label491;
            }
            localf.LSo = true;
            localObject = localf.LSr;
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
          if (!localf.LSo) {
            break label491;
          }
          localf.LSo = false;
          localf.LSp = true;
          break label491;
          label624:
          if ((com.tencent.mm.view.recyclerview.a)localf1.NiY != null) {
            localb.sXD.add((com.tencent.mm.view.recyclerview.a)localf1.NiY);
          }
        }
      }
    }
    AppMethodBeat.o(205170);
    return localb;
  }
  
  public static String a(com.tencent.mm.plugin.finder.model.a parama)
  {
    AppMethodBeat.i(205158);
    d.g.b.p.h(parama, "item");
    Object localObject = parama.ssK;
    if (((ac)localObject).isOverlap())
    {
      parama = new StringBuilder();
      localObject = ((ac)localObject).field_aggregatedContacts.GGQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
        parama.append(gE(localFinderContact.username, localFinderContact.nickname)).append("，");
      }
      localObject = parama.toString();
      d.g.b.p.g(localObject, "nickNameList.toString()");
      parama = (com.tencent.mm.plugin.finder.model.a)localObject;
      if (!bu.isNullOrNil((String)localObject))
      {
        int i = ((String)localObject).length();
        if (localObject == null)
        {
          parama = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(205158);
          throw parama;
        }
        parama = ((String)localObject).substring(0, i - 1);
        d.g.b.p.g(parama, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      AppMethodBeat.o(205158);
      return parama;
    }
    parama = gE(((ac)localObject).field_username, ((ac)localObject).field_nickname);
    AppMethodBeat.o(205158);
    return parama;
  }
  
  public static List<com.tencent.mm.plugin.finder.event.base.g> a(int paramInt1, int paramInt2, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205169);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    LinkedList localLinkedList = new LinkedList();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramInt2))
    {
      paramRecyclerView = d.a.j.s((Collection)localLinkedList);
      AppMethodBeat.o(205169);
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
          i = paramInt1 - ((WxRecyclerAdapter)paramRecyclerView).LRV.size();
          if ((i >= 0) && (i < localList.size()))
          {
            Object localObject2 = (com.tencent.mm.view.recyclerview.a)localList.get(i);
            if (((localObject2 instanceof BaseFinderFeed)) && (((com.tencent.mm.view.recyclerview.a)localObject2).lP() != 0L))
            {
              localObject1 = new com.tencent.mm.plugin.finder.event.base.g((BaseFinderFeed)localObject2, i, (byte)0);
              localObject2 = (com.tencent.mm.view.recyclerview.f)((WxRecyclerAdapter)paramRecyclerView).LSD.get(((com.tencent.mm.view.recyclerview.a)localObject2).lP());
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.finder.event.base.g)localObject1).rZD = ((com.tencent.mm.view.recyclerview.f)localObject2);
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
      localList = ((com.tencent.mm.plugin.finder.search.f.a)paramRecyclerView).sDE.sDD.czU();
      if (paramInt1 <= paramInt2)
      {
        i = paramInt1;
        paramInt1 = com.tencent.mm.plugin.finder.search.f.a(((com.tencent.mm.plugin.finder.search.f.a)paramRecyclerView).sDE);
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
    paramRecyclerView = d.a.j.s((Collection)localLinkedList);
    AppMethodBeat.o(205169);
    return paramRecyclerView;
  }
  
  public static <T, E> List<E> a(List<? extends T> paramList, Class<E> paramClass)
  {
    AppMethodBeat.i(205183);
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
    AppMethodBeat.o(205183);
    return localList;
  }
  
  public static void a(int paramInt, List<? extends am> paramList, com.tencent.mm.bw.b paramb, Intent paramIntent, com.tencent.mm.plugin.finder.feed.model.a parama)
  {
    AppMethodBeat.i(205184);
    d.g.b.p.h(paramList, "feedList");
    d.g.b.p.h(paramIntent, "intent");
    FinderEmptyLoader localFinderEmptyLoader = new FinderEmptyLoader();
    localFinderEmptyLoader.getDataList().addAll((Collection)paramList);
    localFinderEmptyLoader.setLastBuffer(paramb);
    localFinderEmptyLoader.saveCache(paramIntent, paramInt, parama);
    AppMethodBeat.o(205184);
  }
  
  public static void a(int paramInt, List<? extends BaseFinderFeed> paramList, arn paramarn)
  {
    AppMethodBeat.i(205174);
    d.g.b.p.h(paramList, "remain");
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (BaseFinderFeed)paramList.next();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.d.sKD;
      if (!com.tencent.mm.plugin.finder.storage.data.d.a.af(paramInt, ((BaseFinderFeed)localObject1).feedObject.getId()))
      {
        localObject2 = new asz();
        ((asz)localObject2).rRn = ((BaseFinderFeed)localObject1).feedObject.getId();
        ((asz)localObject2).objectNonceId = ((BaseFinderFeed)localObject1).feedObject.getObjectNonceId();
        if (paramarn != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
          ((asz)localObject2).sessionBuffer = com.tencent.mm.plugin.finder.report.i.I(((asz)localObject2).rRn, paramarn.sch);
        }
        ((asz)localObject2).dvm = 4;
        localLinkedList.add(localObject2);
      }
    }
    if (!((Collection)localLinkedList).isEmpty()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        new com.tencent.mm.plugin.finder.cgi.a((List)localLinkedList, paramarn).aET();
      }
      AppMethodBeat.o(205174);
      return;
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(205194);
    hf localhf;
    hf.a locala;
    if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)
    {
      localhf = new hf();
      localhf.duE.id = paramLong;
      locala = localhf.duE;
      if (!paramBoolean) {
        break label89;
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      locala.duG = i;
      localhf.duE.duF = paramInt;
      localhf.duE.type = 7;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localhf);
      AppMethodBeat.o(205194);
      return;
    }
  }
  
  public static void a(Context paramContext, apl paramapl)
  {
    AppMethodBeat.i(167954);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramapl, "location");
    if (bu.isNullOrNil(paramapl.GGA))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("map_view_type", 7);
      localIntent.putExtra("kwebmap_slat", paramapl.dzE);
      localIntent.putExtra("kwebmap_lng", paramapl.dBu);
      String str = paramapl.jGd;
      localObject = str;
      if (bu.isNullOrNil(str)) {
        localObject = paramapl.eRg;
      }
      localIntent.putExtra("kPoiName", (String)localObject);
      localIntent.putExtra("Kwebmap_locaion", paramapl.Ajr);
      com.tencent.mm.br.d.b(paramContext, "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(167954);
      return;
    }
    Object localObject = ad.Njc;
    paramapl = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", Arrays.copyOf(new Object[] { paramapl.GGA }, 1));
    d.g.b.p.g(paramapl, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramapl);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(167954);
  }
  
  public static void a(ImageView paramImageView, FinderAuthInfo paramFinderAuthInfo)
  {
    AppMethodBeat.i(205191);
    d.g.b.p.h(paramImageView, "view");
    paramImageView.setVisibility(8);
    Object localObject = paramImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setColorFilter(null);
    }
    if (paramFinderAuthInfo != null)
    {
      ae.i(TAG, "authType = " + paramFinderAuthInfo.authIconType + ", authIconUrl = " + paramFinderAuthInfo.authIconUrl);
      paramImageView.setVisibility(0);
      if (paramFinderAuthInfo.authIconType > 0)
      {
        switch (paramFinderAuthInfo.authIconType)
        {
        default: 
          paramImageView.setVisibility(8);
          AppMethodBeat.o(205191);
          return;
        case 1: 
          localObject = (CharSequence)paramFinderAuthInfo.authIconUrl;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
          for (int i = 1; i == 0; i = 0)
          {
            localObject = com.tencent.mm.plugin.finder.loader.i.srW;
            localObject = com.tencent.mm.plugin.finder.loader.i.cEn();
            paramFinderAuthInfo = new com.tencent.mm.plugin.finder.loader.l(paramFinderAuthInfo.authIconUrl, r.sJu);
            com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
            ((com.tencent.mm.loader.d)localObject).a(paramFinderAuthInfo, paramImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
            AppMethodBeat.o(205191);
            return;
          }
          paramImageView.setImageDrawable(ao.k(paramImageView.getContext(), 2131690481, com.tencent.mm.cb.a.n(paramImageView.getContext(), 2131100725)));
          AppMethodBeat.o(205191);
          return;
        case 2: 
          paramImageView.setImageResource(2131691604);
          AppMethodBeat.o(205191);
          return;
        }
        paramImageView.setVisibility(8);
        AppMethodBeat.o(205191);
        return;
      }
      paramImageView.setVisibility(8);
      AppMethodBeat.o(205191);
      return;
    }
    AppMethodBeat.o(205191);
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
    localOptions.inSampleSize = com.tencent.mm.sdk.platformtools.h.O(i, j, paramInt1, paramInt2);
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
      ae.i(str, paramImageView + ", viewSize: " + paramInt1 + ", " + paramInt2 + " inSampleSize:" + localOptions.inSampleSize);
      AppMethodBeat.o(167946);
      return;
    }
  }
  
  public static void a(TextView paramTextView, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(205173);
    d.g.b.p.h(paramTextView, "tv");
    d.g.b.p.h(parama, "onClick");
    Object localObject1 = paramTextView.getContext();
    d.g.b.p.g(localObject1, "tv.context");
    localObject1 = ((Context)localObject1).getResources();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    localObject1 = ((Resources)localObject1).getString(2131766930, new Object[] { com.tencent.mm.plugin.finder.storage.b.cIA() });
    localObject2 = paramTextView.getContext();
    d.g.b.p.g(localObject2, "tv.context");
    localObject2 = ((Context)localObject2).getResources();
    Object localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
    localObject2 = ((Resources)localObject2).getString(2131766931, new Object[] { com.tencent.mm.plugin.finder.storage.b.cIA() });
    d.g.b.p.g(localObject1, "str");
    localObject3 = (CharSequence)localObject1;
    d.g.b.p.g(localObject2, "strForIndex");
    int i = d.n.n.a((CharSequence)localObject3, (String)localObject2, 0, false, 6);
    int j = i + ((String)localObject2).length();
    localObject2 = new SpannableString((CharSequence)localObject1);
    if ((i <= 0) || (j > ((String)localObject1).length()))
    {
      j = ((String)localObject1).length();
      i = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject2).setSpan(new p.k(parama, paramTextView), i, j, 33);
      parama = paramTextView.getContext();
      d.g.b.p.g(parama, "tv.context");
      paramTextView.setHighlightColor(parama.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject2);
      AppMethodBeat.o(205173);
      return;
    }
  }
  
  public static void a(com.tencent.mm.view.recyclerview.e parame, String paramString, com.tencent.mm.plugin.finder.model.n paramn)
  {
    AppMethodBeat.i(205160);
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramString, "feedUserName");
    d.g.b.p.h(paramn, "item");
    if (d.g.b.p.i(paramn.ste.getUsername(), com.tencent.mm.model.v.aAC()))
    {
      AppMethodBeat.o(205160);
      return;
    }
    Intent localIntent = new Intent();
    if ((!bu.isNullOrNil(paramString)) && (d.g.b.p.i(paramString, com.tencent.mm.model.v.aAK())))
    {
      if ((paramn.ste.cLl().blacklist_flag == 0) && (!bu.isNullOrNil(paramn.ste.getUsername())) && (!com.tencent.mm.model.v.aAC().equals(paramn.ste.getUsername()))) {
        localIntent.putExtra("Action", 1);
      }
      localIntent.putExtra("feedUser", paramString);
      localIntent.putExtra("Avatar", paramn.ste.cLm());
      localIntent.putExtra("Nickname", paramn.ste.VK());
      localIntent.putExtra("CommentId", paramn.ste.cLl().commentId);
      localIntent.putExtra("FeedId", paramn.ste.field_feedId);
      localIntent.putExtra("FeedNonceId", paramn.ste.field_objectNonceId);
      paramString = paramn.ste.cLl();
      if ((paramString != null) && (paramString.msgInfo != null))
      {
        paramString = paramn.ste.cLl().msgInfo;
        if (paramString == null) {
          break label323;
        }
      }
    }
    label323:
    for (paramString = paramString.toByteArray();; paramString = null)
    {
      localIntent.putExtra("ContactMsgInfo", paramString);
      parame = parame.getContext();
      d.g.b.p.g(parame, "holder.context");
      c(parame, paramn.ste.getUsername(), localIntent);
      if (paramn.ste.cLl() != null) {
        break label328;
      }
      ae.i(TAG, "commentInfo = null");
      AppMethodBeat.o(205160);
      return;
      localIntent.putExtra("Action", 2);
      break;
    }
    label328:
    if (paramn.ste.cLl().msgInfo == null) {
      ae.i(TAG, "msgInfo is null ,feedId:" + paramn.ste.field_feedId + ",comentId:" + paramn.ste.cLl().commentId);
    }
    AppMethodBeat.o(205160);
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
          ae.i(TAG, "update expose commentList, remove at ".concat(String.valueOf(i)));
          paramString = new hl();
          paramString.duV.duw = paramLong1;
          localObject = paramString.duV;
          aqn localaqn = new aqn();
          localaqn.commentList = paramLinkedList;
          ((hl.a)localObject).duW = localaqn;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramString);
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
  
  public static boolean a(final Context paramContext, String paramString, boolean paramBoolean, final atf paramatf)
  {
    AppMethodBeat.i(205153);
    d.g.b.p.h(paramContext, "activity");
    if (bu.isNullOrNil(com.tencent.mm.model.v.aAK()))
    {
      ae.i(TAG, "need create finder contact");
      String str = paramContext.getString(2131759174);
      if (!bu.isNullOrNil(paramString)) {
        str = paramString;
      }
      paramString = com.tencent.mm.plugin.finder.view.c.tdm;
      com.tencent.mm.plugin.finder.view.c.a.a(paramContext, paramContext.getString(2131759179), str, paramContext.getString(2131759178), paramContext.getString(2131759172), (DialogInterface.OnClickListener)new c(paramBoolean, paramatf, paramContext), (DialogInterface.OnClickListener)new d(paramBoolean), (DialogInterface.OnDismissListener)new e(paramBoolean));
      AppMethodBeat.o(205153);
      return false;
    }
    AppMethodBeat.o(205153);
    return true;
  }
  
  public static String af(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178462);
    d.g.b.p.h(paramString1, "countryCode");
    d.g.b.p.h(paramString2, "provinceCode");
    d.g.b.p.h(paramString3, "cityCode");
    RegionCodeDecoder.fwA();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.fwA();
    String str2 = RegionCodeDecoder.mh(paramString1, paramString2);
    RegionCodeDecoder.fwA();
    paramString1 = RegionCodeDecoder.bh(paramString1, paramString2, paramString3);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zR(str2) + " " + paramString1;
      AppMethodBeat.o(178462);
      return paramString1;
    }
    if (!bu.isNullOrNil(str2))
    {
      paramString1 = str1 + ' ' + str2;
      AppMethodBeat.o(178462);
      return paramString1;
    }
    if (!bu.isNullOrNil(str1))
    {
      d.g.b.p.g(str1, "countryName");
      AppMethodBeat.o(178462);
      return str1;
    }
    AppMethodBeat.o(178462);
    return "";
  }
  
  public static com.tencent.mm.plugin.sight.base.a ajS(String paramString)
  {
    AppMethodBeat.i(167939);
    d.g.b.p.h(paramString, "filePath");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(167939);
      return null;
    }
    com.tencent.mm.plugin.sight.base.e.ayN(paramString);
    com.tencent.mm.plugin.sight.base.a locala = new com.tencent.mm.plugin.sight.base.a();
    if ((locala.height <= 0) || (locala.width <= 0)) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(com.tencent.mm.vfs.o.k(paramString, false));
      locala.width = bu.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      locala.height = bu.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      locala.videoBitrate = bu.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      localMediaMetadataRetriever.release();
      label118:
      int i = SightVideoJNI.getMp4RotateVFS(paramString);
      ae.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(i) });
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
  
  public static Point ajT(String paramString)
  {
    AppMethodBeat.i(167940);
    d.g.b.p.h(paramString, "filePath");
    Point localPoint = new Point();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    com.tencent.mm.sdk.platformtools.h.decodeFile(paramString, localOptions);
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
  
  public static boolean ajU(String paramString)
  {
    AppMethodBeat.i(167957);
    if ((!bu.isNullOrNil(com.tencent.mm.model.v.aAK())) && (!bu.isNullOrNil(paramString)) && (d.n.n.H(paramString, com.tencent.mm.model.v.aAK(), false)))
    {
      AppMethodBeat.o(167957);
      return true;
    }
    AppMethodBeat.o(167957);
    return false;
  }
  
  public static boolean ajV(String paramString)
  {
    AppMethodBeat.i(167958);
    boolean bool = bu.lX(paramString, com.tencent.mm.model.v.aAC());
    AppMethodBeat.o(167958);
    return bool;
  }
  
  public static d.o<Double, Double> ajW(String paramString)
  {
    AppMethodBeat.i(167965);
    d.g.b.p.h(paramString, "path");
    Object localObject = new q(new ExifInterface(com.tencent.mm.vfs.o.k(paramString, false)));
    paramString = ((q)localObject).sXY;
    localObject = ((q)localObject).sXX;
    if ((localObject != null) && (paramString != null))
    {
      paramString = new d.o(Double.valueOf(((Float)localObject).floatValue()), Double.valueOf(paramString.floatValue()));
      AppMethodBeat.o(167965);
      return paramString;
    }
    AppMethodBeat.o(167965);
    return null;
  }
  
  public static d.o<Double, Double> ajX(String paramString)
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
      ae.i(TAG, "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        break label372;
      }
      d.g.b.p.g(paramString, "locationString");
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type java.lang.String");
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
        j = d.n.n.b((CharSequence)paramString, '+');
        i = j;
        if (-1 == j) {
          i = d.n.n.b((CharSequence)paramString, '-');
        }
        if (paramString == null)
        {
          paramString = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        localObject = paramString.substring(0, i);
        d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        double d = Double.parseDouble((String)localObject);
        if (paramString == null)
        {
          paramString = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        paramString = paramString.substring(i);
        d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        paramString = new d.o(Double.valueOf(d), Double.valueOf(Double.parseDouble(paramString)));
        AppMethodBeat.o(167966);
        return paramString;
        label372:
        AppMethodBeat.o(167966);
        return null;
      }
      i += 1;
    }
  }
  
  public static String ajY(String paramString)
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
  
  public static String al(bv parambv)
  {
    AppMethodBeat.i(205175);
    d.g.b.p.h(parambv, "msg");
    if (parambv.VZ() == 1)
    {
      parambv = com.tencent.mm.model.v.aAC();
      d.g.b.p.g(parambv, "ConfigStorageLogic.getUsernameFromUserInfo()");
    }
    for (;;)
    {
      AppMethodBeat.o(205175);
      return parambv;
      if (!com.tencent.mm.model.x.wb(parambv.Wa())) {
        break;
      }
      parambv = bl.BM(parambv.getContent());
      d.g.b.p.g(parambv, "MsgInfoStorageLogic.getG…hatMsgTalker(msg.content)");
    }
    parambv = parambv.Wa();
    d.g.b.p.g(parambv, "msg.talker");
    AppMethodBeat.o(205175);
    return parambv;
  }
  
  public static String am(bv parambv)
  {
    AppMethodBeat.i(205176);
    d.g.b.p.h(parambv, "msg");
    if (parambv.VZ() == 1)
    {
      parambv = parambv.Wa();
      d.g.b.p.g(parambv, "msg.talker");
    }
    for (;;)
    {
      AppMethodBeat.o(205176);
      return parambv;
      if (com.tencent.mm.model.x.wb(parambv.Wa()))
      {
        parambv = parambv.Wa();
        d.g.b.p.g(parambv, "msg.talker");
      }
      else
      {
        parambv = com.tencent.mm.model.v.aAC();
        d.g.b.p.g(parambv, "ConfigStorageLogic.getUsernameFromUserInfo()");
      }
    }
  }
  
  public static void at(Context paramContext, String paramString)
  {
    AppMethodBeat.i(205168);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString, "wording");
    com.tencent.mm.ui.base.t.a(paramContext, paramString, (t.b)p.l.sXW);
    AppMethodBeat.o(205168);
  }
  
  public static void c(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(205161);
    d.g.b.p.h(paramContext, "context");
    ae.i(TAG, "jump to wx profile %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    if (!bu.isNullOrNil(paramString)) {
      localIntent.putExtra("Username", paramString);
    }
    paramString = com.tencent.mm.plugin.finder.view.l.thN;
    l.a.X(paramContext, localIntent);
    AppMethodBeat.o(205161);
  }
  
  public static boolean cOe()
  {
    AppMethodBeat.i(178458);
    if (!bu.isNullOrNil(com.tencent.mm.model.v.aAK()))
    {
      AppMethodBeat.o(178458);
      return true;
    }
    AppMethodBeat.o(178458);
    return false;
  }
  
  public static String cOf()
  {
    AppMethodBeat.i(167953);
    Object localObject = ak.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type android.content.ClipboardManager");
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
  
  public static long cOh()
  {
    return rVz;
  }
  
  public static boolean cOi()
  {
    AppMethodBeat.i(205162);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    if ((locale.ajA().getInt(am.a.Jbx, 0) & 0x20) != 0)
    {
      AppMethodBeat.o(205162);
      return true;
    }
    AppMethodBeat.o(205162);
    return false;
  }
  
  public static boolean cOj()
  {
    AppMethodBeat.i(205163);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    if ((locale.ajA().getInt(am.a.Jbx, 0) & 0x400) != 0)
    {
      AppMethodBeat.o(205163);
      return true;
    }
    AppMethodBeat.o(205163);
    return false;
  }
  
  public static JSONObject cOk()
  {
    AppMethodBeat.i(205172);
    if (sXy == null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("screenwidth", com.tencent.mm.cb.a.iu(ak.getContext()));
      ((JSONObject)localObject).put("screenheight", com.tencent.mm.cb.a.iv(ak.getContext()));
      sXy = (JSONObject)localObject;
    }
    JSONObject localJSONObject = sXy;
    Object localObject = localJSONObject;
    if (localJSONObject == null) {
      localObject = new JSONObject();
    }
    AppMethodBeat.o(205172);
    return localObject;
  }
  
  public static void cOl()
  {
    AppMethodBeat.i(205178);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JcZ, "");
    locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jda, "");
    locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jdc, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jdd, Integer.valueOf(0));
    AppMethodBeat.o(205178);
  }
  
  public static void cOm()
  {
    AppMethodBeat.i(205179);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JcW, "");
    locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jdb, Integer.valueOf(0));
    AppMethodBeat.o(205179);
  }
  
  public static int cOn()
  {
    boolean bool3 = true;
    int j = 1;
    AppMethodBeat.i(205193);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cJA().value()).intValue();
    if (i != -1)
    {
      ae.d(TAG, "harcode user state = ".concat(String.valueOf(i)));
      AppMethodBeat.o(205193);
      return i;
    }
    localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    boolean bool1;
    label129:
    boolean bool2;
    if ((((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.Jbp, 0) & 0x2) != 0)
    {
      bool1 = true;
      boolean bool4 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry();
      localObject = (CharSequence)com.tencent.mm.model.v.aAK();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label208;
      }
      i = 1;
      if (i != 0) {
        break label213;
      }
      bool2 = true;
      label135:
      ae.i(TAG, "[checkUserState] hasCreatedIdentity=" + bool2 + ", showPostEntry=" + bool4 + ", isReviewing=" + bool1);
      if (bool4) {
        break label218;
      }
      ae.i(TAG, "resultState = USER_STATE_NO_POST_QUALITY");
      i = j;
    }
    label208:
    label338:
    for (;;)
    {
      AppMethodBeat.o(205193);
      return i;
      bool1 = false;
      break;
      i = 0;
      break label129;
      label213:
      bool2 = false;
      break label135;
      label218:
      if (bool2)
      {
        localObject = com.tencent.mm.plugin.finder.api.c.rPy;
        localObject = com.tencent.mm.plugin.finder.api.c.a.ahT(com.tencent.mm.model.v.aAK());
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        bool2 = ((com.tencent.mm.plugin.finder.api.g)localObject).isBlock();
        localObject = com.tencent.mm.plugin.finder.api.c.rPy;
        localObject = com.tencent.mm.plugin.finder.api.c.a.ahT(com.tencent.mm.model.v.aAK());
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        if (((com.tencent.mm.plugin.finder.api.g)localObject).field_spamStatus == 2) {}
        for (bool1 = bool3;; bool1 = false)
        {
          ae.i(TAG, "[checkUserState] isAccountBlocked=" + bool2 + ", isAccountSilent=" + bool1);
          if (!bool2) {
            break label338;
          }
          ae.i(TAG, "resultState = USER_STATE_ACCOUNT_FORBID");
          i = 4;
          break;
        }
        if (bool1)
        {
          ae.i(TAG, "resultState = USER_STATE_ACCOUNT_SILIENT");
          i = 6;
        }
        else
        {
          ae.i(TAG, "resultState = USER_STATE_NORMAL");
          i = 3;
        }
      }
      else if (bool1)
      {
        ae.i(TAG, "resultState = USER_STATE_ACCOUNT_REVIEW_ING");
        i = 5;
      }
      else
      {
        ae.i(TAG, "resultState = USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
        i = 2;
      }
    }
  }
  
  public static boolean d(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(205192);
    d.g.b.p.h(paramContext, "context");
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramContext = new com.tencent.mm.ui.widget.a.d.a(paramContext);
        paramContext.aZi(paramString);
        paramContext.zf(true);
        paramContext.afU(2131755835);
        paramContext.show();
        AppMethodBeat.o(205192);
        return true;
      }
    }
    AppMethodBeat.o(205192);
    return false;
  }
  
  public static boolean d(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167956);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (!bu.isNullOrNil(com.tencent.mm.model.v.aAK()))
    {
      if (paramBaseFinderFeed != null) {}
      for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; d.n.n.H(paramBaseFinderFeed, com.tencent.mm.model.v.aAK(), false); paramBaseFinderFeed = null)
      {
        AppMethodBeat.o(167956);
        return true;
      }
    }
    AppMethodBeat.o(167956);
    return false;
  }
  
  public static boolean d(bvz parambvz)
  {
    if (parambvz != null) {
      parambvz = parambvz.HiW;
    }
    return (parambvz == null) || (parambvz.GrX != true);
  }
  
  public static String dC(String paramString, int paramInt)
  {
    AppMethodBeat.i(167962);
    d.g.b.p.h(paramString, "key");
    paramString = ak.getContext().getString(paramInt);
    d.g.b.p.g(paramString, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(167962);
    return paramString;
  }
  
  public static void eh(View paramView)
  {
    AppMethodBeat.i(205180);
    if (((paramView == null) || (paramView.getVisibility() != 0)) && (paramView != null))
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(205180);
      return;
    }
    AppMethodBeat.o(205180);
  }
  
  public static Bundle fS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167942);
    Object localObject = ak.getContext();
    d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    d.g.b.p.g(localObject, "MMApplicationContext.getContext().resources");
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = ak.getContext();
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
    localBundle.putInt("media_layout_width", sXw);
    localBundle.putInt("media_layout_height", (int)(f * sXw));
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
  
  public static String gB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167950);
    if (bu.isNullOrNil(paramString1))
    {
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      AppMethodBeat.o(167950);
      return paramString1;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    com.tencent.mm.plugin.finder.api.c.a locala = com.tencent.mm.plugin.finder.api.c.rPy;
    boolean bool;
    if (paramString1 != null)
    {
      bool = d.n.n.nG(paramString1, "@finder");
      if (!bool) {
        break label133;
      }
      if (bu.isNullOrNil(paramString2)) {
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
      paramString2 = com.tencent.mm.plugin.finder.api.c.rPy;
      if (paramString1 == null) {
        d.g.b.p.gkB();
      }
      paramString1 = com.tencent.mm.plugin.finder.api.c.a.ahT(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.VK();
        break label77;
      }
      paramString1 = "";
      break label77;
      label133:
      paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString1);
      d.g.b.p.g(paramString1, "ct");
      if ((paramString1.adE() != 0) && (!bu.isNullOrNil(paramString1.adG())))
      {
        paramString1 = paramString1.adG();
        d.g.b.p.g(paramString1, "ct.displayRemark");
        localStringBuffer.append("displayName is ".concat(String.valueOf(paramString1)));
      }
      else if (!bu.isNullOrNil(paramString2))
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
  
  public static String gD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167969);
    if (!bu.V(new String[] { paramString1, paramString2 }))
    {
      paramString1 = ak.getResources().getString(2131759250, new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(167969);
      return paramString1;
    }
    if (!bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(167969);
      return paramString1;
    }
    if (!bu.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(167969);
      return paramString2;
    }
    AppMethodBeat.o(167969);
    return "";
  }
  
  public static String gE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205159);
    if (bu.isNullOrNil(paramString1))
    {
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(205159);
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
      paramString1 = gB(str, paramString1);
    }
    AppMethodBeat.o(205159);
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
    if ((!d.n.n.nG(paramString, "@stranger")) && ((d.g.b.p.i(paramString, com.tencent.mm.model.v.aAC()) ^ true)) && (com.tencent.mm.model.x.An(paramString)))
    {
      AppMethodBeat.o(167952);
      return true;
    }
    AppMethodBeat.o(167952);
    return false;
  }
  
  public static boolean j(com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(205164);
    if (paramg != null) {}
    for (String str = paramg.getUsername(); d.g.b.p.i(str, com.tencent.mm.model.v.aAK()); str = null)
    {
      boolean bool = cOj();
      AppMethodBeat.o(205164);
      return bool;
    }
    if (paramg != null) {}
    for (int i = paramg.field_extFlag; (i & 0x400) != 0; i = 0)
    {
      AppMethodBeat.o(205164);
      return true;
    }
    AppMethodBeat.o(205164);
    return false;
  }
  
  public static void k(List<? extends FinderItem> paramList, String paramString)
  {
    AppMethodBeat.i(167955);
    d.g.b.p.h(paramList, "list");
    d.g.b.p.h(paramString, "tag");
    ae.v(TAG, "---------------------------------------------------------------------printAllItemStart " + paramString + " count " + paramList.size() + "---------------------------------------------------------------------");
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
        ae.i(str, paramList);
        i += 1;
        break;
      }
    }
    ae.v(TAG, "---------------------------------------------------------------------printAllItemEnd " + paramString + "---------------------------------------------------------------------");
    AppMethodBeat.o(167955);
  }
  
  public static aqq n(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167959);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    aqq localaqq = new aqq();
    localaqq.refObjectFlag = 1L;
    if (paramBaseFinderFeed.feedObject.getRefObjectFlag() == 1L) {
      localaqq.refObjectId = paramBaseFinderFeed.feedObject.getRefObjectId();
    }
    FinderContact localFinderContact;
    for (localaqq.refObjectContact = paramBaseFinderFeed.feedObject.getRefObjectContact();; localaqq.refObjectContact = localFinderContact)
    {
      AppMethodBeat.o(167959);
      return localaqq;
      localaqq.refObjectId = paramBaseFinderFeed.feedObject.getId();
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      if (paramBaseFinderFeed == null) {
        d.g.b.p.gkB();
      }
      d.g.b.p.h(paramBaseFinderFeed, "$this$toServer");
      localFinderContact = new FinderContact();
      localFinderContact.username = paramBaseFinderFeed.getUsername();
      localFinderContact.headUrl = paramBaseFinderFeed.czm();
      localFinderContact.nickname = paramBaseFinderFeed.VK();
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
      localFinderContact.originalEntranceFlag = paramBaseFinderFeed.field_originalEntranceFlag;
      localFinderContact.originalInfo = paramBaseFinderFeed.field_originalInfo;
      localFinderContact.extFlag = paramBaseFinderFeed.field_extFlag;
    }
  }
  
  public static boolean o(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(205181);
    d.g.b.p.h(paramBaseFinderFeed, "item");
    if ((paramBaseFinderFeed.feedObject.getFeedObject().incFriendLikeCount > 0) && (paramBaseFinderFeed.feedObject.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(205181);
      return true;
    }
    AppMethodBeat.o(205181);
    return false;
  }
  
  public static boolean o(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167948);
    d.g.b.p.h(paramFinderObject, "obj");
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
    localObject = com.tencent.mm.plugin.finder.storage.logic.b.a.cLT();
    FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
    if (localFinderObjectDesc != null) {}
    for (int i = localFinderObjectDesc.mediaType; ((List)localObject).contains(Integer.valueOf(i)); i = 0)
    {
      AppMethodBeat.o(167948);
      return true;
    }
    localObject = paramFinderObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if ((localObject != null) && (((LinkedList)localObject).size() == 0))
      {
        AppMethodBeat.o(167948);
        return false;
      }
    }
    localObject = paramFinderObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = (FinderMedia)((LinkedList)localObject).get(0);
        if (localObject == null) {}
      }
    }
    for (i = ((FinderMedia)localObject).mediaType;; i = 0)
    {
      localObject = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      if (com.tencent.mm.plugin.finder.storage.logic.b.a.cLT().contains(Integer.valueOf(i))) {
        break;
      }
      AppMethodBeat.o(167948);
      return false;
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
            AppMethodBeat.o(167948);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(167948);
    return true;
  }
  
  public static int p(FinderObject paramFinderObject)
  {
    Object localObject2 = null;
    int k = 0;
    AppMethodBeat.i(167949);
    d.g.b.p.h(paramFinderObject, "obj");
    if (paramFinderObject.objectDesc != null)
    {
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null) {
        break label141;
      }
    }
    label141:
    for (Object localObject1 = Integer.valueOf(((FinderObjectDesc)localObject1).mediaType);; localObject1 = null)
    {
      if (localObject1 == null) {
        ae.m(TAG, "obj ".concat(String.valueOf(paramFinderObject)), new Object[0]);
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      Iterable localIterable = (Iterable)com.tencent.mm.plugin.finder.storage.logic.b.a.cLT();
      FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
      localObject1 = localObject2;
      if (localFinderObjectDesc != null) {
        localObject1 = Integer.valueOf(localFinderObjectDesc.mediaType);
      }
      if (!d.a.j.a(localIterable, localObject1)) {
        break label155;
      }
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject == null) {
        break;
      }
      i = paramFinderObject.mediaType;
      AppMethodBeat.o(167949);
      return i;
    }
    AppMethodBeat.o(167949);
    return 0;
    label155:
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if ((localObject1 != null) && (((LinkedList)localObject1).size() == 0))
      {
        paramFinderObject = paramFinderObject.objectDesc;
        if (paramFinderObject != null)
        {
          i = paramFinderObject.mediaType;
          AppMethodBeat.o(167949);
          return i;
        }
        AppMethodBeat.o(167949);
        return 0;
      }
    }
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 != null)
      {
        localObject1 = (FinderMedia)((LinkedList)localObject1).get(0);
        if (localObject1 == null) {}
      }
    }
    for (int i = ((FinderMedia)localObject1).mediaType;; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      if (com.tencent.mm.plugin.finder.storage.logic.b.a.cLT().contains(Integer.valueOf(i))) {
        break;
      }
      AppMethodBeat.o(167949);
      return i;
    }
    if (i == 4)
    {
      localObject1 = paramFinderObject.objectDesc;
      int j = k;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        j = k;
        if (localObject1 != null) {
          j = ((LinkedList)localObject1).size();
        }
      }
      if (j > 1)
      {
        AppMethodBeat.o(167949);
        return 8;
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
            AppMethodBeat.o(167949);
            return 8;
          }
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
    hl localhl = new hl();
    localhl.duV.duw = paramFinderItem.field_id;
    localhl.duV.duX = paramFinderItem.getCommentCount();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localhl);
    AppMethodBeat.o(178459);
  }
  
  public static boolean q(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(205165);
    d.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x1) == 0)
    {
      AppMethodBeat.o(205165);
      return true;
    }
    AppMethodBeat.o(205165);
    return false;
  }
  
  public static boolean r(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(205182);
    d.g.b.p.h(paramFinderItem, "item");
    if ((paramFinderItem.getFeedObject().incFriendLikeCount > 0) && (paramFinderItem.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(205182);
      return true;
    }
    AppMethodBeat.o(205182);
    return false;
  }
  
  public static boolean r(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(205166);
    d.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x2) == 0)
    {
      AppMethodBeat.o(205166);
      return true;
    }
    AppMethodBeat.o(205166);
    return false;
  }
  
  public static boolean s(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(205167);
    d.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x4) != 0)
    {
      AppMethodBeat.o(205167);
      return true;
    }
    AppMethodBeat.o(205167);
    return false;
  }
  
  public static JSONArray x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205171);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new d.v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(205171);
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
        ((JSONObject)localObject2).put("feedid", com.tencent.mm.ac.c.rp(((com.tencent.mm.plugin.finder.event.base.g)localObject3).rZB.lP()));
        ((JSONObject)localObject2).put("feedindex", ((com.tencent.mm.plugin.finder.event.base.g)localObject3).rZC);
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)localObject3).rZD;
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put("x", ((com.tencent.mm.view.recyclerview.f)localObject3).LSs + 1);
          ((JSONObject)localObject2).put("width", ((com.tencent.mm.view.recyclerview.f)localObject3).width);
          ((JSONObject)localObject2).put("height", ((com.tencent.mm.view.recyclerview.f)localObject3).height);
        }
        paramRecyclerView.put(localObject2);
      }
      i = 0;
      break;
    }
    AppMethodBeat.o(205171);
    return paramRecyclerView;
  }
  
  public static int xF(long paramLong)
  {
    return (int)(paramLong / 1000L);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "", "feedId", "", "mediaId", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedPosition", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "currentFeedList", "Ljava/util/LinkedList;", "getCurrentFeedList", "()Ljava/util/LinkedList;", "setCurrentFeedList", "(Ljava/util/LinkedList;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getFeedPosition", "()I", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getMediaId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public final long duw;
    public final String mediaId;
    public final com.tencent.mm.view.recyclerview.e rVa;
    public final BaseFinderFeed rZB;
    public LinkedList<a> sXA;
    public final int sXB;
    
    public a(long paramLong, String paramString, BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(205133);
      this.duw = paramLong;
      this.mediaId = paramString;
      this.rZB = paramBaseFinderFeed;
      this.sXB = paramInt;
      this.rVa = parame;
      this.sXA = new LinkedList();
      AppMethodBeat.o(205133);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205137);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.duw != paramObject.duw) || (!d.g.b.p.i(this.mediaId, paramObject.mediaId)) || (!d.g.b.p.i(this.rZB, paramObject.rZB)) || (this.sXB != paramObject.sXB) || (!d.g.b.p.i(this.rVa, paramObject.rVa))) {}
        }
      }
      else
      {
        AppMethodBeat.o(205137);
        return true;
      }
      AppMethodBeat.o(205137);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(205136);
      long l = this.duw;
      int m = (int)(l ^ l >>> 32);
      Object localObject = this.mediaId;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.rZB;
        if (localObject == null) {
          break label115;
        }
      }
      label115:
      for (int j = localObject.hashCode();; j = 0)
      {
        int n = this.sXB;
        localObject = this.rVa;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(205136);
        return ((j + (i + m * 31) * 31) * 31 + n) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205135);
      String str = "CenterFeed(feedId=" + this.duw + ", mediaId=" + this.mediaId + ", feed=" + this.rZB + ", feedPosition=" + this.sXB + ", holder=" + this.rVa + ")";
      AppMethodBeat.o(205135);
      return str;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(boolean paramBoolean, atf paramatf, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167933);
      com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
      if (this.sXE) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(10);
      }
      for (;;)
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("scene", 1);
        Object localObject = paramatf;
        if (localObject != null) {
          paramDialogInterface.putExtra("key_prepare_resp", ((atf)localObject).toByteArray());
        }
        localObject = a.sVQ;
        a.w(paramContext, paramDialogInterface);
        AppMethodBeat.o(167933);
        return;
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(12);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167934);
      com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
      if (this.sXE) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.g.syJ;
        com.tencent.mm.plugin.finder.report.g.Fs(5);
        AppMethodBeat.o(167934);
        return;
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(13);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class e
    implements DialogInterface.OnDismissListener
  {
    e(boolean paramBoolean) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(167936);
      com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
      if (this.sXE) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.g.syJ;
        com.tencent.mm.plugin.finder.report.g.Fs(5);
        AppMethodBeat.o(167936);
        return;
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).reportPostRedDot(13);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(Activity paramActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167938);
      paramDialogInterface = a.sVQ;
      a.ap(this.mKq);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.an(7, false);
      AppMethodBeat.o(167938);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    public static final g sXH;
    
    static
    {
      AppMethodBeat.i(205144);
      sXH = new g();
      AppMethodBeat.o(205144);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(205143);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.an(7, false);
      AppMethodBeat.o(205143);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/utils/FinderUtil$getVisibleFeedListByAdapterPosRange$1$1$1$1$2$1$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$3", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$4", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$5"})
  static final class j
    implements Runnable
  {
    j(ViewParent paramViewParent, FinderFoldedScrollLayout paramFinderFoldedScrollLayout, com.tencent.mm.view.recyclerview.f paramf, y.f paramf1, com.tencent.mm.plugin.finder.event.base.g paramg, View paramView, RecyclerView paramRecyclerView, Set paramSet, RecyclerView.a parama, Rect paramRect, p.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(205147);
      localf.LSn = ((View)this.sXK).getTop();
      if (localf.LSm - localf.LSl - localf.LSk > localf.LSn)
      {
        if (!localf.LSo)
        {
          localf.LSo = true;
          Object localObject = localf.LSr;
          if (localObject != null)
          {
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject != null)
            {
              ((WxRecyclerAdapter)localObject).onResume();
              AppMethodBeat.o(205147);
              return;
            }
          }
          AppMethodBeat.o(205147);
        }
      }
      else if (localf.LSo)
      {
        localf.LSo = false;
        localf.LSp = true;
      }
      AppMethodBeat.o(205147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p
 * JD-Core Version:    0.7.0.1
 */