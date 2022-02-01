package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.o.l;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.g.a;
import com.tencent.mm.plugin.finder.live.model.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.rtmp.TXLivePlayConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.r;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderLiveUtil;", "", "()V", "FINDER_LIVE_MMKV", "", "TAG", "getTAG", "()Ljava/lang/String;", "addSelfAppMsg", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "adjustMarginTopInSecondaryLiveRoom", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "adjustMarginWhenLandScape", "ifLeft", "", "canShowShopEntrance", "livePrivilegesFlag", "", "shopAppId", "shopAppUrl", "checkCanShowShopEntrance", "checkIfAtMe", "commentData", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "checkIfTickleMe", "checkInsertLiveNewReddot", "convertToLiveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "toWhere", "convertToSimilarLive", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "clickFeed", "commentScene", "convertToVisitorLiveData", "tabType", "getAtName", "getBadgeLevelImageSpan", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan;", "badgeLevel", "badgeTag", "getConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentOrientation", "activity", "Landroid/app/Activity;", "getDebugFinderLiveContact", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFinderLiveAndienceFileIdList", "list", "", "", "getLanscapePadding", "isScondaryDevice", "getLotteryRemainTime", "beginTime", "endTime", "remainTime", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getRenderMode", "isLandscape", "getSubMsgString", "msg", "maxCharCount", "withEllapse", "getTickleContact", "getVisibilityString", "visibilityMode", "showDetail", "giftFuncEnableByContactFlag", "contactFlag", "", "giftFuncEnableBySwitchFlag", "switchFlag", "isAnchorLive", "isFriend", "username", "isInSecondaryDevice", "isLibPagEnabled", "isSelf", "linkMicFuncEnableBySwitchFlag", "value", "parseFinderLiveAudienceList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "container", "printDebugMsg", "tag", "rewardGainEnableBySwitchFlag", "setBigPitcureBlurBitmap", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "blurBitmap", "setBlurBitmap", "imageView", "Landroid/widget/ImageView;", "url", "radius", "setETInputConfig", "descTv", "Landroid/widget/EditText;", "textCountTv", "Landroid/widget/TextView;", "maxInputLength", "maxInputSize", "configCallback", "Lkotlin/Function0;", "setLiveGiftTypeFace", "tv", "showDebugToast", "vibrate", "plugin-finder_release"})
public final class m
{
  public static final String TAG = "FinderLiveUtil";
  private static final String vVG = "_finder_live_mmkv";
  public static final m vVH;
  
  static
  {
    AppMethodBeat.i(253452);
    vVH = new m();
    TAG = "FinderLiveUtil";
    vVG = "_finder_live_mmkv";
    AppMethodBeat.o(253452);
  }
  
  public static int B(Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(253427);
    p.h(paramContext, "context");
    if (com.tencent.mm.ui.ao.aQ(paramContext)) {}
    for (int i = au.getStatusBarHeight(paramContext);; i = 0)
    {
      if (paramBoolean) {
        j = au.aD(paramContext);
      }
      if (!paramBoolean) {
        break;
      }
      i = kotlin.k.j.mZ(i, j);
      j = paramContext.getResources().getDimensionPixelOffset(2131165314);
      AppMethodBeat.o(253427);
      return i + j;
    }
    if (i > 0)
    {
      j = paramContext.getResources().getDimensionPixelOffset(2131165314);
      AppMethodBeat.o(253427);
      return j + i;
    }
    i = paramContext.getResources().getDimensionPixelOffset(2131165299);
    AppMethodBeat.o(253427);
    return i;
  }
  
  public static boolean Gc(long paramLong)
  {
    AppMethodBeat.i(253440);
    boolean bool = com.tencent.mm.ac.d.cW((int)paramLong, 4);
    AppMethodBeat.o(253440);
    return bool;
  }
  
  public static boolean Gd(long paramLong)
  {
    AppMethodBeat.i(253441);
    boolean bool1 = com.tencent.mm.ac.d.cW((int)paramLong, 2);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.b)locala).Vt();
    boolean bool3 = dBQ();
    Log.i(TAG, "giftFuncEnableBySwitchFlag isTeenMode:" + bool2 + " pagEnable:" + bool3 + " enableGiftBySwitchFlag:" + bool1 + " switchFlag:" + paramLong);
    if ((bool1) && (bool3) && (!bool2))
    {
      AppMethodBeat.o(253441);
      return true;
    }
    AppMethodBeat.o(253441);
    return false;
  }
  
  public static boolean Ge(long paramLong)
  {
    AppMethodBeat.i(253442);
    boolean bool = com.tencent.mm.ac.d.cW((int)paramLong, 1);
    AppMethodBeat.o(253442);
    return bool;
  }
  
  public static MultiProcessMMKV VQ()
  {
    AppMethodBeat.i(253448);
    Object localObject = new StringBuilder().append(vVG);
    p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    localObject = MultiProcessMMKV.getMMKV(com.tencent.mm.kernel.a.getUin());
    p.g(localObject, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
    AppMethodBeat.o(253448);
    return localObject;
  }
  
  public static int a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, boolean paramBoolean)
  {
    int i = 5;
    AppMethodBeat.i(253436);
    p.h(paramg, "liveData");
    int j = paramg.djc();
    e.a locala = e.a.hxc;
    if (j == e.a.aCe()) {
      if (!paramg.djn()) {}
    }
    for (;;)
    {
      Log.i(TAG, "getRenderMode audienceMode:" + paramg.djc() + ", renderMode:" + i);
      AppMethodBeat.o(253436);
      return i;
      if (!paramBoolean)
      {
        i = 2;
        continue;
        locala = e.a.hxc;
        if (j == e.a.aCf())
        {
          if (paramg.djn()) {
            i = 1;
          } else if (paramBoolean) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else
        {
          Log.i(TAG, "unknown audienceMode:" + paramg.djc());
          i = 0;
        }
      }
    }
  }
  
  public static FinderLiveConfig a(ArrayList<bo> paramArrayList, bo parambo, int paramInt)
  {
    AppMethodBeat.i(253418);
    p.h(paramArrayList, "data");
    p.h(parambo, "clickFeed");
    Object localObject = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      boolean bool = localbo instanceof BaseFinderFeed;
      paramArrayList = y.vXH;
      if (localbo == null)
      {
        paramArrayList = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(253418);
        throw paramArrayList;
      }
      if ((y.w((BaseFinderFeed)localbo) & bool))
      {
        paramArrayList = ((BaseFinderFeed)localbo).feedObject;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.getLiveInfo();
          if ((paramArrayList != null) && (paramArrayList.liveStatus == 2))
          {
            String str = TAG;
            paramArrayList = new StringBuilder("convertToVisitorLiveData feed:").append(localbo.lT()).append(",is click feed:");
            long l = localbo.lT();
            label201:
            StringBuilder localStringBuilder;
            if ((parambo != null) && (l == parambo.lT()))
            {
              bool = true;
              localStringBuilder = paramArrayList.append(bool).append(",nickname:");
              paramArrayList = ((BaseFinderFeed)localbo).contact;
              if (paramArrayList == null) {
                break label330;
              }
              paramArrayList = paramArrayList.getNickname();
              label233:
              localStringBuilder = localStringBuilder.append(paramArrayList).append(",live status:");
              paramArrayList = ((BaseFinderFeed)localbo).feedObject;
              if (paramArrayList == null) {
                break label335;
              }
              paramArrayList = paramArrayList.getLiveInfo();
              if (paramArrayList == null) {
                break label335;
              }
            }
            label330:
            label335:
            for (paramArrayList = Integer.valueOf(paramArrayList.liveStatus);; paramArrayList = null)
            {
              Log.i(str, paramArrayList + '!');
              if (localbo.lT() != parambo.lT()) {
                break;
              }
              ((ArrayList)localObject).add(localbo);
              break;
              bool = false;
              break label201;
              paramArrayList = null;
              break label233;
            }
          }
        }
        ((ArrayList)localObject).add(localbo);
      }
    }
    int i = kotlin.a.j.a((List)localObject, parambo);
    if (i >= 0) {}
    for (;;)
    {
      paramArrayList = new FinderLiveConfig();
      paramArrayList.uis = i;
      paramArrayList.tCE = paramInt;
      localObject = (Iterable)localObject;
      parambo = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parambo.add(q(((BaseFinderFeed)((Iterator)localObject).next()).feedObject.getFeedObject()));
      }
      i = 0;
    }
    paramArrayList.ac(new ArrayList((Collection)parambo));
    paramArrayList.uiy = 1;
    AppMethodBeat.o(253418);
    return paramArrayList;
  }
  
  public static FinderLiveConfig a(ArrayList<bo> paramArrayList, bo parambo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253419);
    p.h(paramArrayList, "data");
    p.h(parambo, "clickFeed");
    Object localObject = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      boolean bool = localbo instanceof BaseFinderFeed;
      paramArrayList = y.vXH;
      if (localbo == null)
      {
        paramArrayList = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(253419);
        throw paramArrayList;
      }
      if ((y.w((BaseFinderFeed)localbo) & bool))
      {
        paramArrayList = ((BaseFinderFeed)localbo).feedObject;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.getLiveInfo();
          if ((paramArrayList != null) && (paramArrayList.liveStatus == 2))
          {
            String str = TAG;
            paramArrayList = new StringBuilder("convertToVisitorLiveData feed:").append(localbo.lT()).append(",is click feed:");
            long l = localbo.lT();
            label201:
            StringBuilder localStringBuilder;
            if ((parambo != null) && (l == parambo.lT()))
            {
              bool = true;
              localStringBuilder = paramArrayList.append(bool).append(",nickname:");
              paramArrayList = ((BaseFinderFeed)localbo).contact;
              if (paramArrayList == null) {
                break label330;
              }
              paramArrayList = paramArrayList.getNickname();
              label233:
              localStringBuilder = localStringBuilder.append(paramArrayList).append(",live status:");
              paramArrayList = ((BaseFinderFeed)localbo).feedObject;
              if (paramArrayList == null) {
                break label335;
              }
              paramArrayList = paramArrayList.getLiveInfo();
              if (paramArrayList == null) {
                break label335;
              }
            }
            label330:
            label335:
            for (paramArrayList = Integer.valueOf(paramArrayList.liveStatus);; paramArrayList = null)
            {
              Log.i(str, paramArrayList + '!');
              if (localbo.lT() != parambo.lT()) {
                break;
              }
              ((ArrayList)localObject).add(localbo);
              break;
              bool = false;
              break label201;
              paramArrayList = null;
              break label233;
            }
          }
        }
        ((ArrayList)localObject).add(localbo);
      }
    }
    int i = kotlin.a.j.a((List)localObject, parambo);
    if (i >= 0) {}
    for (;;)
    {
      paramArrayList = new FinderLiveConfig();
      paramArrayList.uis = i;
      paramArrayList.dLS = paramInt1;
      paramArrayList.tCE = paramInt2;
      localObject = (Iterable)localObject;
      parambo = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        parambo.add(q(((BaseFinderFeed)((Iterator)localObject).next()).feedObject.getFeedObject()));
      }
      i = 0;
    }
    paramArrayList.ac(new ArrayList((Collection)parambo));
    AppMethodBeat.o(253419);
    return paramArrayList;
  }
  
  public static avn a(Context paramContext, com.tencent.mm.plugin.finder.live.model.t paramt)
  {
    AppMethodBeat.i(253432);
    p.h(paramContext, "context");
    p.h(paramt, "commentData");
    if ((paramt instanceof com.tencent.mm.plugin.finder.live.model.f))
    {
      int i = paramt.getType();
      paramContext = o.l.hHy;
      if (i == o.l.aFO())
      {
        paramContext = ((com.tencent.mm.plugin.finder.live.model.f)paramt).uio.LFz;
        AppMethodBeat.o(253432);
        return paramContext;
      }
    }
    AppMethodBeat.o(253432);
    return null;
  }
  
  public static o.f a(final int paramInt, final Context paramContext, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(253413);
    p.h(paramContext, "context");
    p.h(paramBaseFinderFeed, "feed");
    paramContext = (o.f)new c(paramBaseFinderFeed, paramInt, paramContext);
    AppMethodBeat.o(253413);
    return paramContext;
  }
  
  public static o.f a(final Context paramContext, BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(253412);
    p.h(paramContext, "context");
    p.h(paramBaseFinderFeed, "feed");
    p.h(parame, "sheet");
    paramContext = (o.f)new b(paramBaseFinderFeed, paramContext, parame);
    AppMethodBeat.o(253412);
    return paramContext;
  }
  
  public static void a(View paramView, Bitmap paramBitmap, kotlin.g.a.b<? super Bitmap, kotlin.x> paramb)
  {
    AppMethodBeat.i(253416);
    p.h(paramView, "view");
    p.h(paramBitmap, "bitmap");
    Object localObject = com.tencent.mm.live.b.d.a.hLg;
    localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    com.tencent.mm.live.b.d.a.a.a(paramBitmap, ((Context)localObject).getResources().getColor(2131099834), (kotlin.g.a.b)new m.d(paramView, paramb));
    AppMethodBeat.o(253416);
  }
  
  public static void a(EditText paramEditText, TextView paramTextView, int paramInt1, final int paramInt2, final kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(253445);
    InputFilter localInputFilter1 = (InputFilter)new e(paramEditText);
    InputFilter localInputFilter2 = (InputFilter)new f(paramInt1, paramInt1, f.a.Qui);
    if (paramEditText != null) {
      paramEditText.setFilters(new InputFilter[] { localInputFilter1, localInputFilter2 });
    }
    paramTextView = (TextWatcher)new g(paramTextView, paramInt2, parama);
    if (paramEditText != null)
    {
      paramEditText.addTextChangedListener(paramTextView);
      AppMethodBeat.o(253445);
      return;
    }
    AppMethodBeat.o(253445);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(253425);
    p.h(paramd, "plugin");
    if ((paramd.umb.getLayoutParams() != null) && ((paramd.umb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (paramd.isLandscape()))
    {
      Context localContext = paramd.umb.getContext();
      p.g(localContext, "plugin.vg.context");
      int i = localContext.getResources().getDimensionPixelOffset(2131165296);
      paramd = paramd.umb.getLayoutParams();
      if (paramd == null)
      {
        paramd = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(253425);
        throw paramd;
      }
      ((ViewGroup.MarginLayoutParams)paramd).topMargin = i;
    }
    AppMethodBeat.o(253425);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.plugin.d paramd, final boolean paramBoolean)
  {
    AppMethodBeat.i(253426);
    p.h(paramd, "plugin");
    paramd.umb.post((Runnable)new a(paramd, paramBoolean));
    AppMethodBeat.o(253426);
  }
  
  public static void a(aut paramaut, com.tencent.mm.plugin.finder.live.viewmodel.g paramg)
  {
    AppMethodBeat.i(253431);
    p.h(paramaut, "appMsg");
    p.h(paramg, "liveData");
    com.tencent.mm.plugin.finder.live.model.f localf = new com.tencent.mm.plugin.finder.live.model.f(paramaut);
    avn localavn = new avn();
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = z.aTY();
    localFinderContact.nickname = z.aUa();
    localavn.contact = localFinderContact;
    paramaut.LFE = localavn;
    paramg.uDs.add(localf);
    paramaut = com.tencent.mm.live.b.m.hGg;
    com.tencent.mm.live.b.m.aFe();
    AppMethodBeat.o(253431);
  }
  
  public static boolean a(com.tencent.mm.plugin.finder.live.model.t paramt)
  {
    AppMethodBeat.i(253429);
    p.h(paramt, "commentData");
    if ((paramt instanceof com.tencent.mm.plugin.finder.live.model.f))
    {
      int i = paramt.getType();
      o.l locall = o.l.hHy;
      if (i == o.l.aFP())
      {
        paramt = ((com.tencent.mm.plugin.finder.live.model.f)paramt).uio.LFz;
        if (paramt != null)
        {
          paramt = paramt.contact;
          if (paramt == null) {}
        }
        for (paramt = paramt.username; p.j(paramt, z.aTY()); paramt = null)
        {
          AppMethodBeat.o(253429);
          return true;
        }
      }
    }
    AppMethodBeat.o(253429);
    return false;
  }
  
  public static int ag(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(253428);
    int k = cl.aWB();
    int j = paramInt2 - k;
    int m = paramInt2 - paramInt1;
    if ((j > m) || (j > paramInt3)) {}
    for (int i = paramInt3;; i = j)
    {
      if (j <= 0) {
        i = 0;
      }
      Log.i(TAG, "getLotteryRemainTime serverTime:" + k + ",beginTime:" + paramInt1 + ",endTime:" + paramInt2 + ",remainTime:" + paramInt3 + ",calRemainTime:" + j + ",duration:" + m + ",result:" + i);
      AppMethodBeat.o(253428);
      return i;
    }
  }
  
  public static String au(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253449);
    switch (paramInt)
    {
    default: 
      if (paramBoolean)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
      }
      break;
    }
    for (Object localObject = ((Context)localObject).getResources().getString(2131760215);; localObject = ((Context)localObject).getResources().getString(2131760214))
    {
      p.g(localObject, "if (showDetail) {\n      …19/21  \n                }");
      AppMethodBeat.o(253449);
      return localObject;
      if (paramBoolean)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
      }
      for (localObject = ((Context)localObject).getResources().getString(2131760215);; localObject = ((Context)localObject).getResources().getString(2131760214))
      {
        p.g(localObject, "if (showDetail) {\n      …1/19/21\n                }");
        AppMethodBeat.o(253449);
        return localObject;
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
      }
      if (paramBoolean)
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
      }
      for (localObject = ((Context)localObject).getResources().getString(2131760218);; localObject = ((Context)localObject).getResources().getString(2131760216))
      {
        p.g(localObject, "if (showDetail) {\n      …e_list)\n                }");
        AppMethodBeat.o(253449);
        return localObject;
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
      }
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
    }
  }
  
  public static String b(com.tencent.mm.plugin.finder.live.model.t paramt)
  {
    AppMethodBeat.i(253430);
    p.h(paramt, "commentData");
    if ((paramt instanceof com.tencent.mm.plugin.finder.live.model.f))
    {
      int i = paramt.getType();
      o.l locall = o.l.hHy;
      if (i == o.l.aFP())
      {
        paramt = ((com.tencent.mm.plugin.finder.live.model.f)paramt).uio.LFz;
        if (paramt != null)
        {
          paramt = paramt.contact;
          if (paramt != null)
          {
            paramt = paramt.nickname;
            AppMethodBeat.o(253430);
            return paramt;
          }
        }
        AppMethodBeat.o(253430);
        return null;
      }
    }
    AppMethodBeat.o(253430);
    return "";
  }
  
  public static LinkedList<avh> b(List<byte[]> paramList, LinkedList<avh> paramLinkedList)
  {
    AppMethodBeat.i(253450);
    p.h(paramList, "list");
    if (paramLinkedList == null) {
      paramLinkedList = new LinkedList();
    }
    for (;;)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        byte[] arrayOfByte = (byte[])paramList.next();
        avh localavh = new avh();
        localavh.parseFrom(arrayOfByte);
        paramLinkedList.add(localavh);
      }
      paramLinkedList.clear();
    }
    AppMethodBeat.o(253450);
    return paramLinkedList;
  }
  
  public static com.tencent.mm.plugin.finder.live.model.g bd(int paramInt, String paramString)
  {
    AppMethodBeat.i(253446);
    p.h(paramString, "badgeTag");
    switch (paramInt)
    {
    default: 
      localObject1 = com.tencent.mm.plugin.finder.live.model.g.uiK;
      localObject1 = g.a.atD(paramString);
      paramString = (CharSequence)paramString;
      localObject2 = n.ujr;
      f1 = n.dfS();
      localObject2 = n.ujr;
      f2 = n.dfS();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      paramInt = ((Context)localObject2).getResources().getColor(2131099676);
      localObject2 = n.ujr;
      i = n.dfQ();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      j = ((Context)localObject2).getResources().getColor(2131101427);
      localObject2 = n.ujr;
      paramString = new com.tencent.mm.plugin.finder.live.model.g((Drawable)localObject1, new n(paramString, f1, f2, paramInt, i, j, n.dfR()));
      AppMethodBeat.o(253446);
      return paramString;
    case 1: 
      localObject1 = com.tencent.mm.plugin.finder.live.model.g.uiK;
      localObject1 = g.a.atD(paramString);
      paramString = (CharSequence)paramString;
      localObject2 = n.ujr;
      f1 = n.dfS();
      localObject2 = n.ujr;
      f2 = n.dfS();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      paramInt = ((Context)localObject2).getResources().getColor(2131100417);
      localObject2 = n.ujr;
      i = n.dfQ();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      j = ((Context)localObject2).getResources().getColor(2131101427);
      localObject2 = n.ujr;
      paramString = new com.tencent.mm.plugin.finder.live.model.g((Drawable)localObject1, new n(paramString, f1, f2, paramInt, i, j, n.dfR()));
      AppMethodBeat.o(253446);
      return paramString;
    case 2: 
      localObject1 = com.tencent.mm.plugin.finder.live.model.g.uiK;
      localObject1 = g.a.atD(paramString);
      paramString = (CharSequence)paramString;
      localObject2 = n.ujr;
      f1 = n.dfS();
      localObject2 = n.ujr;
      f2 = n.dfS();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      paramInt = ((Context)localObject2).getResources().getColor(2131100419);
      localObject2 = n.ujr;
      i = n.dfQ();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      j = ((Context)localObject2).getResources().getColor(2131101427);
      localObject2 = n.ujr;
      paramString = new com.tencent.mm.plugin.finder.live.model.g((Drawable)localObject1, new n(paramString, f1, f2, paramInt, i, j, n.dfR()));
      AppMethodBeat.o(253446);
      return paramString;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.g.uiK;
    localObject1 = g.a.atD(paramString);
    paramString = (CharSequence)paramString;
    Object localObject2 = n.ujr;
    float f1 = n.dfS();
    localObject2 = n.ujr;
    float f2 = n.dfS();
    localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    paramInt = ((Context)localObject2).getResources().getColor(2131100418);
    localObject2 = n.ujr;
    int i = n.dfQ();
    localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    int j = ((Context)localObject2).getResources().getColor(2131101427);
    localObject2 = n.ujr;
    paramString = new com.tencent.mm.plugin.finder.live.model.g((Drawable)localObject1, new n(paramString, f1, f2, paramInt, i, j, n.dfR()));
    AppMethodBeat.o(253446);
    return paramString;
  }
  
  public static boolean c(com.tencent.mm.plugin.finder.live.model.t paramt)
  {
    AppMethodBeat.i(253433);
    p.h(paramt, "commentData");
    if ((paramt instanceof com.tencent.mm.plugin.finder.live.model.f))
    {
      int i = paramt.getType();
      o.l locall = o.l.hHy;
      if (i == o.l.aFO())
      {
        paramt = ((com.tencent.mm.plugin.finder.live.model.f)paramt).uio.LFz;
        if (paramt != null)
        {
          paramt = paramt.contact;
          if (paramt == null) {}
        }
        for (paramt = paramt.username; p.j(paramt, z.aTY()); paramt = null)
        {
          AppMethodBeat.o(253433);
          return true;
        }
      }
    }
    AppMethodBeat.o(253433);
    return false;
  }
  
  public static void checkInsertLiveNewReddot()
  {
    int i = 0;
    AppMethodBeat.i(253411);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    if (((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.OjO, 0) == 1) {
      i = 1;
    }
    if (i != 0)
    {
      AppMethodBeat.o(253411);
      return;
    }
    localObject = c.vCb;
    if (!c.duS())
    {
      AppMethodBeat.o(253411);
      return;
    }
    localObject = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager();
    bbi localbbi = new bbi();
    localbbi.LKM = String.valueOf(cl.aWA());
    localbbi.priority = 50000;
    localbbi.type = 1010;
    bdo localbdo = new bdo();
    localbdo.xGz = 1;
    localbdo.LNm = 1;
    localbdo.path = "FinderEntrance";
    localbbi.GaM.add(localbdo);
    localbdo = new bdo();
    localbdo.xGz = 1;
    localbdo.LNm = 1;
    localbdo.path = "TLPersonalCenter";
    localbbi.GaM.add(localbdo);
    localbdo = new bdo();
    localbdo.xGz = 1;
    localbdo.LNm = 1;
    localbdo.path = "FinderSelfLiveEntrance";
    localbbi.GaM.add(localbdo);
    com.tencent.mm.plugin.finder.extension.reddot.f.a((com.tencent.mm.plugin.finder.extension.reddot.f)localObject, localbbi, "checkInsertLiveNewReddot", null, true, null, 20);
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).azQ().set(ar.a.OjO, Integer.valueOf(1));
    AppMethodBeat.o(253411);
  }
  
  public static boolean dBN()
  {
    AppMethodBeat.i(253421);
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Okd, Integer.valueOf(0));
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(253421);
      throw ((Throwable)localObject1);
    }
    int i = ((Integer)localObject1).intValue();
    localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Okb, "");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(253421);
      throw ((Throwable)localObject1);
    }
    localObject1 = (String)localObject1;
    Object localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).azQ().get(ar.a.Okc, "");
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(253421);
      throw ((Throwable)localObject1);
    }
    boolean bool = z(i, (String)localObject1, (String)localObject2);
    AppMethodBeat.o(253421);
    return bool;
  }
  
  public static TXLivePlayConfig dBO()
  {
    AppMethodBeat.i(253435);
    Object localObject = c.vCb;
    int i = c.dvg();
    localObject = c.vCb;
    int j = c.dvh();
    localObject = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject).setConnectRetryCount(i);
    ((TXLivePlayConfig)localObject).setConnectRetryInterval(j);
    Log.i(TAG, "cdn config retry count:" + i + ",retry interval:" + j);
    AppMethodBeat.o(253435);
    return localObject;
  }
  
  public static boolean dBP()
  {
    AppMethodBeat.i(253437);
    Object localObject = com.tencent.mm.live.core.core.a.b.hyv;
    if (!b.a.aDp())
    {
      localObject = com.tencent.mm.live.core.core.c.a.hAj;
      if (!com.tencent.mm.live.core.core.c.a.a.aDp()) {}
    }
    else
    {
      AppMethodBeat.o(253437);
      return true;
    }
    AppMethodBeat.o(253437);
    return false;
  }
  
  public static boolean dBQ()
  {
    AppMethodBeat.i(253439);
    com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.rNG;
    boolean bool = com.tencent.mm.plugin.expansions.d.aoc("xlab");
    AppMethodBeat.o(253439);
    return bool;
  }
  
  public static LinkedList<avn> dBR()
  {
    AppMethodBeat.i(253447);
    Object localObject1 = y.vXH;
    if (y.dCM())
    {
      localObject1 = new LinkedList();
      Object localObject2 = com.tencent.mm.plugin.finder.live.plugin.y.uoV;
      int k = com.tencent.mm.plugin.finder.live.plugin.y.dhf();
      int i = 0;
      if (i < k)
      {
        localObject2 = new avn();
        if (i % 7 == 0) {}
        for (int j = 0;; j = 1)
        {
          ((avn)localObject2).hFI = j;
          ((avn)localObject2).LGi = (k * 1000 - i * 50);
          FinderContact localFinderContact = new FinderContact();
          localFinderContact.username = "index:".concat(String.valueOf(i));
          localFinderContact.nickname = "测试用户".concat(String.valueOf(i));
          ((avn)localObject2).contact = localFinderContact;
          ((LinkedList)localObject1).add(localObject2);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(253447);
      return localObject1;
    }
    AppMethodBeat.o(253447);
    return null;
  }
  
  public static void eg(View paramView)
  {
    AppMethodBeat.i(253434);
    p.h(paramView, "view");
    paramView.performHapticFeedback(1, 3);
    AppMethodBeat.o(253434);
  }
  
  public static LinkedList<String> ez(List<byte[]> paramList)
  {
    AppMethodBeat.i(253451);
    LinkedList localLinkedList = new LinkedList();
    if (paramList == null)
    {
      Log.i(TAG, "getFinderLiveAndienceFileIdList list is empty!");
      AppMethodBeat.o(253451);
      return localLinkedList;
    }
    StringBuilder localStringBuilder = new StringBuilder("AndienceFileIdList:");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject1 = paramList.next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      Object localObject2 = (byte[])localObject1;
      localObject1 = new avh();
      ((avh)localObject1).parseFrom((byte[])localObject2);
      localObject2 = ((avh)localObject1).KRd;
      CharSequence localCharSequence = (CharSequence)localObject2;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label216;
        }
        localLinkedList.add(localObject2);
        p.g(localStringBuilder.append("[" + ((avh)localObject1).title + ',' + ((avh)localObject1).KRd + ']'), "printMsg.append(\"[${item.title},${item.file_id}]\")");
        i = j;
        break;
      }
      label216:
      Log.i(TAG, "getFinderLiveAndienceFileIdList index:" + i + " item:" + ((avh)localObject1).title + " is empty!");
      i = j;
    }
    Log.i(TAG, "getFinderLiveAndienceFileIdList ".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(253451);
    return localLinkedList;
  }
  
  public static void g(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(253414);
    p.h(paramImageView, "imageView");
    p.h(paramString, "url");
    Log.i(TAG, "setBlurBitmap imageView:" + paramImageView.getId() + ",url:" + paramString);
    Object localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
    localObject = com.tencent.mm.plugin.finder.loader.m.dke();
    paramString = new com.tencent.mm.plugin.finder.loader.e(paramString, com.tencent.mm.plugin.finder.storage.x.vEo);
    com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
    ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.m.a(com.tencent.mm.plugin.finder.loader.m.a.uJb));
    AppMethodBeat.o(253414);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void hd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253423);
    p.h(paramString1, "tag");
    p.h(paramString2, "msg");
    y localy = y.vXH;
    if (y.dCM()) {
      Log.i(paramString1 + "(Debug)", paramString2);
    }
    AppMethodBeat.o(253423);
  }
  
  public static boolean i(com.tencent.mm.plugin.finder.live.viewmodel.g paramg)
  {
    AppMethodBeat.i(253424);
    p.h(paramg, "liveData");
    if ((paramg.sourceType == 1) || (paramg.sourceType == 2))
    {
      AppMethodBeat.o(253424);
      return true;
    }
    AppMethodBeat.o(253424);
    return false;
  }
  
  public static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(253420);
    p.h(paramString, "username");
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aSN().Kn(paramString);
    p.g(paramString, "contact");
    boolean bool = paramString.arv();
    AppMethodBeat.o(253420);
    return bool;
  }
  
  public static String p(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253443);
    p.h(paramString, "msg");
    String str = com.tencent.mm.ui.tools.f.hm(paramString, paramInt);
    if ((paramBoolean) && (paramString.length() > str.length()))
    {
      paramString = str + "...";
      AppMethodBeat.o(253443);
      return paramString;
    }
    p.g(str, "subString");
    AppMethodBeat.o(253443);
    return str;
  }
  
  public static void p(TextView paramTextView)
  {
    AppMethodBeat.i(253438);
    p.h(paramTextView, "tv");
    try
    {
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      paramTextView.setTypeface(Typeface.createFromAsset(localContext.getAssets(), "fonts/SF-Pro-Display-BoldItalic.otf"));
      AppMethodBeat.o(253438);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.e(TAG, "setTypeface() Exception:" + paramTextView.getMessage());
      AppMethodBeat.o(253438);
    }
  }
  
  public static boolean z(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(253422);
    boolean bool = com.tencent.mm.ac.d.cW(paramInt, 2);
    String str = TAG;
    paramString2 = new StringBuilder("canShowShopEntrance appId:").append(paramString1).append(", appUrl:").append(paramString2).append(", isTest:");
    Object localObject = y.vXH;
    paramString2 = paramString2.append(y.dCM()).append(",Config:");
    localObject = c.vCb;
    Log.i(str, c.duU() + ",flag:" + paramInt + ",flag enable:" + bool);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString1 = y.vXH;
      if (!y.dCM())
      {
        paramString1 = c.vCb;
        if ((!c.duU()) && (!bool)) {}
      }
      else
      {
        AppMethodBeat.o(253422);
        return true;
      }
    }
    AppMethodBeat.o(253422);
    return false;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.plugin.finder.live.plugin.d paramd, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(253402);
      int i;
      Object localObject;
      int j;
      if ((this.vVI.umb.getLayoutParams() != null) && ((this.vVI.umb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (this.vVI.isLandscape()))
      {
        i = this.vVI.getCurrentOrientation();
        localObject = m.vVH;
        localObject = this.vVI.umb.getContext();
        p.g(localObject, "plugin.vg.context");
        m localm = m.vVH;
        j = m.B((Context)localObject, m.i(this.vVI.getLiveData()));
        if (!paramBoolean) {
          break label235;
        }
        localObject = this.vVI.umb.getLayoutParams();
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(253402);
          throw ((Throwable)localObject);
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(j);
      }
      for (;;)
      {
        this.vVI.umb.requestLayout();
        localObject = y.vXH;
        if (y.dCM())
        {
          localObject = m.vVH;
          Log.i(m.getTAG(), "plugin:" + this.vVI.name() + ",Orientation:" + i + ",ifLeft:" + paramBoolean);
        }
        this.vVI.umb.setTag(2131301216, Integer.valueOf(i));
        AppMethodBeat.o(253402);
        return;
        label235:
        localObject = this.vVI.umb.getLayoutParams();
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(253402);
          throw ((Throwable)localObject);
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(j);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements o.f
  {
    b(BaseFinderFeed paramBaseFinderFeed, Context paramContext, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(final com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(253404);
      Object localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      Object localObject2 = ((Context)localObject1).getResources().getString(2131755985);
      p.g(localObject2, "MMApplicationContext.get…ring.app_share_to_weixin)");
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getResources().getString(2131760572);
      p.g(localObject1, "MMApplicationContext.get…ng.finder_share_timeline)");
      Object localObject3 = m.vVH;
      localObject3 = m.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("lxl object Status: ").append(this.tEM.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(this.tEM.feedObject.isOnlySelfSee()).append(" isSelf=");
      y localy = y.vXH;
      Log.i((String)localObject3, y.h(this.tEM) + " isNotShare=" + this.tEM.feedObject.isNotShare());
      boolean bool2;
      boolean bool1;
      if (this.tEM.feedObject.isOnlySelfSee())
      {
        localObject3 = y.vXH;
        if (y.h(this.tEM))
        {
          localObject1 = o.vVT;
          localObject1 = o.a(paramContext, this.tEM, 2, (kotlin.g.a.b)new a(this, paramm));
          localObject2 = (String)((r)localObject1).first;
          localObject1 = (String)((r)localObject1).second;
          bool2 = true;
          bool1 = true;
        }
      }
      for (;;)
      {
        localObject3 = at.tSs;
        int i = at.cXq();
        localObject2 = (CharSequence)localObject2;
        localObject3 = MMApplicationContext.getContext();
        p.g(localObject3, "MMApplicationContext.getContext()");
        paramm.a(i, (CharSequence)localObject2, 2131690251, ((Context)localObject3).getResources().getColor(2131099710), bool1);
        localObject2 = at.tSs;
        paramm.a(at.cXr(), (CharSequence)localObject1, 2131689830, 0, bool2);
        paramm = FinderReporterUIC.wzC;
        paramm = FinderReporterUIC.a.fH(paramContext);
        if (paramm != null)
        {
          localObject1 = k.vfA;
          k.I(this.tEM.lT(), paramm.tCE);
        }
        paramm = FinderReporterUIC.wzC;
        paramm = FinderReporterUIC.a.fH(paramContext);
        if (paramm != null)
        {
          paramm = FinderReporterUIC.b(paramm);
          if (paramm != null)
          {
            paramm.cZR().Ew(this.tEM.lT());
            AppMethodBeat.o(253404);
            return;
            if ((!this.tEM.feedObject.isOnlySelfSee()) && (!this.tEM.feedObject.isNotShare())) {
              break label480;
            }
            localObject1 = y.vXH;
            localObject2 = y.dP("FinderSafeSelfSeeForward", 2131760540);
            localObject1 = y.vXH;
            localObject1 = y.dP("FinderSafeSelfSeeShare", 2131760541);
            bool2 = true;
            bool1 = true;
            continue;
          }
        }
        AppMethodBeat.o(253404);
        return;
        label480:
        bool2 = false;
        bool1 = false;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<r<? extends String, ? extends String, ? extends String>, kotlin.x>
    {
      a(m.b paramb, com.tencent.mm.ui.base.m paramm)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements o.f
  {
    c(BaseFinderFeed paramBaseFinderFeed, int paramInt, Context paramContext) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(253405);
      Object localObject = m.vVH;
      if (!m.t(this.tEM))
      {
        if ((paramInt != 3) && (paramInt != 1))
        {
          localObject = at.tSs;
          paramm.b(at.ddd(), (CharSequence)paramContext.getString(2131763162), 2131690233);
        }
        localObject = at.tSs;
        paramm.b(at.ddf(), (CharSequence)paramContext.getString(2131763159), 2131690898);
      }
      AppMethodBeat.o(253405);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class e
    implements InputFilter
  {
    e(EditText paramEditText) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(253408);
      paramSpanned = this.vVM;
      if (paramSpanned != null) {
        paramSpanned.getText();
      }
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(253408);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(253408);
        return paramCharSequence;
      }
      AppMethodBeat.o(253408);
      return null;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderLiveUtil$setETInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
  public static final class f
    extends com.tencent.mm.ui.tools.f
  {
    f(int paramInt1, int paramInt2, f.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(253409);
      CharSequence localCharSequence;
      if (paramSpanned != null)
      {
        paramInt1 = paramSpanned.length();
        if (paramInt1 <= paramInt3) {
          break label159;
        }
        if (paramSpanned == null) {
          break label153;
        }
        localCharSequence = paramSpanned.subSequence(0, paramInt3);
        label41:
        paramInt1 = com.tencent.mm.ui.tools.f.a(String.valueOf(localCharSequence), f.a.Qui);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label174;
        }
      }
      label153:
      label159:
      label174:
      for (paramInt2 = com.tencent.mm.ui.tools.f.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), f.a.Qui);; paramInt2 = 0)
      {
        paramInt3 = com.tencent.mm.ui.tools.f.a(String.valueOf(paramCharSequence), f.a.Qui);
        paramInt1 = this.vVN - paramInt1 - paramInt2;
        if (paramInt3 <= paramInt1) {
          break label179;
        }
        paramSpanned = m.vVH;
        paramCharSequence = (CharSequence)m.p(String.valueOf(paramCharSequence), paramInt1, false);
        AppMethodBeat.o(253409);
        return paramCharSequence;
        paramInt1 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt1 = com.tencent.mm.ui.tools.f.a(String.valueOf(paramSpanned), f.a.Qui);
        break label53;
      }
      label179:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(253409);
        return paramCharSequence;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderLiveUtil$setETInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class g
    implements TextWatcher
  {
    g(TextView paramTextView, int paramInt, kotlin.g.a.a parama) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(253410);
      int i = com.tencent.mm.ui.tools.f.bnP(String.valueOf(paramEditable)) / 2;
      TextView localTextView = this.vVO;
      if (localTextView != null) {
        if (i < 0) {
          break label85;
        }
      }
      label85:
      for (paramEditable = (CharSequence)(i + '/' + paramInt2);; paramEditable = (CharSequence)("0/" + paramInt2))
      {
        localTextView.setText(paramEditable);
        paramEditable = parama;
        if (paramEditable == null) {
          break;
        }
        paramEditable.invoke();
        AppMethodBeat.o(253410);
        return;
      }
      AppMethodBeat.o(253410);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m
 * JD-Core Version:    0.7.0.1
 */