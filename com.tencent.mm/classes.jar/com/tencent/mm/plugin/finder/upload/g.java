package com.tencent.mm.plugin.finder.upload;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.report.r.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "", "()V", "TAG", "", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "mediaProcessQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "mvMediaProcessQueue", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "mvUploadQueue", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "postCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "uploadCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1;", "uploadImageQueue", "Lcom/tencent/mm/loader/loader/IWorkTask;", "uploadQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "addPostEndListener", "", "listener", "checkNextPost", "doMvProcess", "processTask", "callback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "doMvUpload", "uploadTask", "doPost", "", "data", "Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "musicData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "doProcess", "doUpload", "generateFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mediaType", "", "description", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "isLongVideo", "isNewsFeed", "notifyEventPost", "localId", "isOk", "notifyPostError", "notifyPostOk", "svrId", "notifyStartPost", "onStart", "onStop", "rePost", "feed", "removePostEndListener", "resizeOfShort", "Lkotlin/Pair;", "originWidth", "originHeight", "max", "uploadActivityCover", "path", "uploadCoverImage", "userName", "uploadLiveCoverImage", "Companion", "plugin-finder_release"})
public final class g
{
  private static final g vSH;
  private static boolean vSI;
  public static final a vSJ;
  public final String TAG;
  public com.tencent.mm.loader.g.d<h> ibn;
  private final HashSet<q> listeners;
  public com.tencent.mm.loader.g.d<n> vSA;
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> vSB;
  com.tencent.mm.loader.g.d<c> vSC;
  com.tencent.mm.loader.g.d<r> vSD;
  com.tencent.mm.loader.g.d<s> vSE;
  public final g vSF;
  public final i vSG;
  
  static
  {
    AppMethodBeat.i(167765);
    vSJ = new a((byte)0);
    vSH = new g();
    AppMethodBeat.o(167765);
  }
  
  public g()
  {
    AppMethodBeat.i(167764);
    this.ibn = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderPost"));
    this.vSA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUpload"));
    this.vSB = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUploadImage"));
    this.vSC = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderMediaProcess"));
    this.vSD = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "mv_finderMediaProcess"));
    this.vSE = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "mv_finderUpload"));
    this.TAG = "Finder.LogPost.FinderPostManager";
    this.vSF = new g(this);
    this.vSG = new i();
    this.listeners = new HashSet();
    AppMethodBeat.o(167764);
  }
  
  public static kotlin.o<Integer, Integer> af(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(253079);
    if (paramInt1 < paramInt2) {
      if (paramInt1 % 16 == 0) {
        break label165;
      }
    }
    label165:
    for (int i = paramInt1 - paramInt1 % 16;; i = paramInt1)
    {
      if (paramInt1 > paramInt3) {
        paramInt2 = (int)(paramInt2 * (paramInt3 / paramInt1));
      }
      for (;;)
      {
        paramInt1 = paramInt2;
        if (paramInt2 % 16 != 0) {
          paramInt1 = paramInt2 - paramInt2 % 16;
        }
        kotlin.o localo = new kotlin.o(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        AppMethodBeat.o(253079);
        return localo;
        if (paramInt2 % 16 != 0) {}
        for (i = paramInt2 - paramInt2 % 16;; i = paramInt2)
        {
          if (i > paramInt3) {
            paramInt1 = (int)(paramInt1 * (paramInt3 / paramInt2));
          }
          for (;;)
          {
            paramInt2 = paramInt1;
            if (paramInt1 % 16 != 0) {
              paramInt2 = paramInt1 - paramInt1 % 16;
            }
            localo = new kotlin.o(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
            AppMethodBeat.o(253079);
            return localo;
            paramInt3 = i;
          }
        }
        paramInt3 = i;
      }
    }
  }
  
  public final void FY(final long paramLong)
  {
    AppMethodBeat.i(167762);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, paramLong));
    AppMethodBeat.o(167762);
  }
  
  public final void FZ(final long paramLong)
  {
    AppMethodBeat.i(167763);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new f(this, paramLong));
    AppMethodBeat.o(167763);
  }
  
  public final long a(p paramp)
  {
    AppMethodBeat.i(253078);
    kotlin.g.b.p.h(paramp, "data");
    int k = paramp.mediaType;
    Object localObject8 = paramp.description;
    Object localObject6 = paramp.vTx;
    Object localObject3 = paramp.location;
    Object localObject2 = paramp.vTy;
    int m = paramp.originalFlag;
    azy localazy = paramp.vTz;
    boolean bool1 = paramp.vTA;
    Object localObject1 = paramp.vTB;
    ArrayList localArrayList = paramp.vTC;
    boolean bool2 = paramp.isLongVideo;
    boolean bool3 = paramp.vTD;
    Object localObject9 = paramp.vTF;
    FinderItem localFinderItem = new FinderItem();
    Object localObject4 = com.tencent.mm.plugin.finder.report.i.vfo;
    localFinderItem.field_reportObject = com.tencent.mm.plugin.finder.report.i.dnY();
    localObject4 = localFinderItem.field_reportObject;
    if (localObject4 != null)
    {
      ((FinderFeedReportObject)localObject4).sendOrExitButtonTime = cl.aWA();
      ((FinderFeedReportObject)localObject4).videoPostType = k;
      ((FinderFeedReportObject)localObject4).beforeCutMediaPath = ((String)localObject1);
      ((FinderFeedReportObject)localObject4).postStage = 1;
      ((FinderFeedReportObject)localObject4).sdkShareType = paramp.sdkShareType;
      localObject1 = x.SXb;
    }
    localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    Object localObject5 = com.tencent.mm.plugin.finder.api.c.a.asG(z.aUg());
    FinderObject localFinderObject = new FinderObject();
    Object localObject7 = new FinderObjectDesc();
    int i;
    long l;
    if (bool3)
    {
      i = 1;
      localFinderObject.objectType = i;
      if (localazy == null) {
        break label340;
      }
      l = localazy.refObjectId;
      label223:
      localFinderObject.refObjectId = l;
      if (localazy == null) {
        break label346;
      }
      l = localazy.refObjectFlag;
      label242:
      localFinderObject.refObjectFlag = l;
      if (localazy == null) {
        break label352;
      }
    }
    label340:
    label346:
    label352:
    for (localObject1 = localazy.refObjectContact;; localObject1 = null)
    {
      localFinderObject.refObjectContact = ((FinderContact)localObject1);
      localFinderObject.id = 0L;
      localFinderObject.username = z.aUg();
      localObject1 = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.OjH, "");
      if (localObject1 != null) {
        break label358;
      }
      paramp = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(253078);
      throw paramp;
      i = 0;
      break;
      l = 0L;
      break label223;
      l = 0L;
      break label242;
    }
    label358:
    localFinderObject.nickname = ((String)localObject1);
    localFinderObject.objectDesc = ((FinderObjectDesc)localObject7);
    localObject1 = y.vXH;
    localFinderObject.createtime = y.Gg(cl.aWy());
    if (localObject5 != null) {}
    for (localObject1 = b.a((com.tencent.mm.plugin.finder.api.g)localObject5);; localObject1 = localObject4)
    {
      localFinderObject.contact = ((FinderContact)localObject1);
      localFinderObject.mentionedUserContact = new LinkedList();
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((!com.tencent.mm.plugin.finder.storage.c.drO()) || (localArrayList == null)) {
        break label757;
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (cjj)((Iterator)localObject1).next();
        localObject5 = localFinderObject.mentionedUserContact;
        localObject10 = com.tencent.mm.plugin.finder.utils.d.vVg;
        kotlin.g.b.p.g(localObject4, "atContact");
        ((LinkedList)localObject5).add(com.tencent.mm.plugin.finder.utils.d.b((cjj)localObject4));
      }
      localObject4 = new FinderContact();
      ((FinderContact)localObject4).username = z.aUg();
      localObject1 = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.OjH, "");
      if (localObject1 == null)
      {
        paramp = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(253078);
        throw paramp;
      }
      ((FinderContact)localObject4).nickname = ((String)localObject1);
      localObject1 = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.OjJ, "");
      if (localObject1 == null)
      {
        paramp = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(253078);
        throw paramp;
      }
      ((FinderContact)localObject4).headUrl = ((String)localObject1);
      if (localObject5 != null)
      {
        localObject5 = ((com.tencent.mm.plugin.finder.api.g)localObject5).field_signature;
        localObject1 = localObject5;
        if (localObject5 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((FinderContact)localObject4).signature = ((String)localObject1);
      localObject1 = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.OjM, "");
      if (localObject1 == null)
      {
        paramp = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(253078);
        throw paramp;
      }
      ((FinderContact)localObject4).coverImgUrl = ((String)localObject1);
      localObject1 = x.SXb;
    }
    localObject1 = x.SXb;
    label757:
    localObject1 = y.vXH;
    if (y.dnv()) {
      localFinderObject.permissionFlag = 3;
    }
    Object localObject10 = new bal();
    label823:
    label870:
    Object localObject11;
    if (localObject6 != null)
    {
      localObject1 = ((cjk)localObject6).MoJ;
      ((FinderObjectDesc)localObject7).imgFeedBgmInfo = ((azk)localObject1);
      localObject5 = new azr();
      if (localObject6 == null) {
        break label1800;
      }
      localObject1 = ((cjk)localObject6).MoJ;
      ((azr)localObject5).musicInfo = ((azk)localObject1);
      if (localObject6 != null)
      {
        localObject4 = ((cjk)localObject6).vMX;
        localObject1 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject1 = ((azr)localObject5).musicInfo;
        if (localObject1 == null) {
          break label1806;
        }
        localObject1 = ((azk)localObject1).wWb;
      }
      ((azr)localObject5).groupId = ((String)localObject1);
      if (((localObject6 == null) || (((cjk)localObject6).wCu)) && ((localObject6 == null) || (((cjk)localObject6).wCv))) {
        break label1812;
      }
      i = 1;
      label905:
      ((azr)localObject5).LJw = i;
      localObject4 = this.TAG;
      localObject11 = new StringBuilder("FinderObjectBGMInfo, groupId:").append(((azr)localObject5).groupId).append(", mediaMute:");
      if (localObject6 == null) {
        break label1817;
      }
      localObject1 = Boolean.valueOf(((cjk)localObject6).wCu);
      label958:
      localObject11 = ((StringBuilder)localObject11).append(localObject1).append(", musicMute:");
      if (localObject6 == null) {
        break label1823;
      }
      localObject1 = Boolean.valueOf(((cjk)localObject6).wCv);
      label988:
      Log.d((String)localObject4, localObject1 + ", hasBgm:" + ((azr)localObject5).LJw);
      localObject1 = (CharSequence)((azr)localObject5).groupId;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label1829;
      }
      i = 1;
      label1044:
      if ((i == 0) && (((azr)localObject5).musicInfo == null))
      {
        localObject4 = new azk();
        if (localObject6 == null) {
          break label1834;
        }
        localObject1 = ((cjk)localObject6).MoK;
        label1077:
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label1840;
        }
        i = 1;
        label1101:
        if (i == 0) {
          break label1851;
        }
        if (localObject6 == null) {
          break label1845;
        }
        localObject1 = ((cjk)localObject6).vMV;
        label1117:
        localObject1 = com.tencent.mm.b.q.k((String)localObject1, true);
        label1125:
        ((azk)localObject4).LJi = ((String)localObject1);
        localObject1 = x.SXb;
        ((azr)localObject5).musicInfo = ((azk)localObject4);
      }
      localObject1 = x.SXb;
      ((FinderObjectDesc)localObject7).feedBgmInfo = ((azr)localObject5);
      ((FinderObjectDesc)localObject7).fromApp = paramp.vTE;
      ((FinderObjectDesc)localObject7).event = ((azs)localObject9);
      localObject5 = new LinkedList();
      if (localObject6 == null) {
        break label2060;
      }
      localObject1 = ((cjk)localObject6).mediaList;
      if (localObject1 == null) {
        break label2060;
      }
      localObject9 = ((Iterable)localObject1).iterator();
      i = 0;
    }
    label1212:
    int j;
    for (;;)
    {
      if (!((Iterator)localObject9).hasNext()) {
        break label2055;
      }
      localObject1 = ((Iterator)localObject9).next();
      j = i + 1;
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject11 = (cjl)localObject1;
      Object localObject12 = new FinderMedia();
      ((FinderMedia)localObject12).url = ((cjl)localObject11).url;
      ((FinderMedia)localObject12).mediaType = ((cjl)localObject11).mediaType;
      ((FinderMedia)localObject12).thumbUrl = ((cjl)localObject11).thumbUrl;
      ((FinderMedia)localObject12).full_thumb_url = ((cjl)localObject11).MoR;
      if ((!((cjl)localObject11).MoO) && (((cjl)localObject11).videoDuration <= 0))
      {
        localObject1 = com.tencent.mm.plugin.sight.base.e.aNx(((cjl)localObject11).url);
        if (localObject1 != null)
        {
          ((cjl)localObject11).videoDuration = ((com.tencent.mm.plugin.sight.base.a)localObject1).getVideoDuration();
          localObject1 = x.SXb;
        }
      }
      ((FinderMedia)localObject12).videoDuration = ((cjl)localObject11).videoDuration;
      ((FinderMedia)localObject12).width = ((cjl)localObject11).width;
      ((FinderMedia)localObject12).height = ((cjl)localObject11).height;
      ((FinderMedia)localObject12).md5sum = ((cjl)localObject11).md5sum;
      ((FinderMedia)localObject12).coverUrl = ((cjl)localObject11).coverUrl;
      if (((cjl)localObject11).MoX != null)
      {
        localObject1 = ((cjl)localObject11).MfU;
        if (localObject1 != null)
        {
          localObject4 = ((acn)localObject1).Gxw.Lnm;
          ((dlh)localObject4).Msu.set(0, Integer.valueOf(0));
          ((dlh)localObject4).Msu.set(1, Integer.valueOf(0));
          ((dlh)localObject4).Msu.set(2, Integer.valueOf(((acn)localObject1).Gxw.xlg));
          ((dlh)localObject4).Msu.set(3, Integer.valueOf(((acn)localObject1).Gxw.xlh));
          localObject1 = x.SXb;
        }
      }
      localObject1 = o.vTw;
      kotlin.g.b.p.g(localObject11, "it");
      o.a((cjl)localObject11, (LinkedList)localObject5);
      ((FinderObjectDesc)localObject7).media.add(localObject12);
      if ((i == 0) && (!Util.isNullOrNil(((cjl)localObject11).url)) && ((((cjl)localObject11).mediaType == 2) || (((cjl)localObject11).mediaType == 4)))
      {
        if (((cjl)localObject11).mediaType != 2) {
          break label1872;
        }
        localObject1 = y.vXH;
        localObject4 = ((cjl)localObject11).url;
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
      }
      for (localObject1 = y.awo((String)localObject1);; localObject1 = y.awp(((cjl)localObject11).url))
      {
        if (localObject1 != null)
        {
          ((bal)localObject10).LKd = ((float)((Number)((kotlin.o)localObject1).first).doubleValue());
          ((bal)localObject10).LKc = ((float)((Number)((kotlin.o)localObject1).second).doubleValue());
          localObject1 = x.SXb;
        }
        if (((FinderMedia)localObject12).mediaType != 2) {
          break label1890;
        }
        localObject1 = this.TAG;
        localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((cjl)localObject11).url).append(" size:").append(Util.getSizeKB(com.tencent.mm.vfs.s.boW(((cjl)localObject11).url))).append(" option ");
        localObject11 = BitmapUtil.getImageOptions(((cjl)localObject11).url);
        Log.i((String)localObject1, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject11).outWidth).append(" * ").append(((BitmapFactory.Options)localObject11).outHeight).append(']').toString() + '}');
        i = j;
        break label1212;
        localObject1 = null;
        break;
        label1800:
        localObject1 = null;
        break label823;
        label1806:
        localObject1 = null;
        break label870;
        label1812:
        i = 0;
        break label905;
        label1817:
        localObject1 = null;
        break label958;
        label1823:
        localObject1 = null;
        break label988;
        label1829:
        i = 0;
        break label1044;
        label1834:
        localObject1 = null;
        break label1077;
        label1840:
        i = 0;
        break label1101;
        label1845:
        localObject1 = null;
        break label1117;
        label1851:
        if (localObject6 != null)
        {
          localObject1 = ((cjk)localObject6).MoK;
          break label1125;
        }
        localObject1 = null;
        break label1125;
        label1872:
        localObject1 = y.vXH;
      }
      label1890:
      if (((FinderMedia)localObject12).mediaType == 4)
      {
        localObject1 = this.TAG;
        localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((cjl)localObject11).url).append(" size:").append(Util.getSizeKB(com.tencent.mm.vfs.s.boW(((cjl)localObject11).url))).append(" option ");
        localObject12 = com.tencent.mm.plugin.gallery.a.c.xsz;
        Log.i((String)localObject1, com.tencent.mm.plugin.gallery.a.c.awl(((cjl)localObject11).url));
        i = j;
      }
      else
      {
        Log.i(this.TAG, "print mediaList " + i + ' ' + ((cjl)localObject11).url + " size:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(((cjl)localObject11).url)));
        i = j;
      }
    }
    label2055:
    localObject1 = x.SXb;
    label2060:
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject1 = FinderGlobalLocationVM.dHP();
    ((bal)localObject10).dTj = ((Number)((kotlin.o)localObject1).first).floatValue();
    ((bal)localObject10).latitude = ((Number)((kotlin.o)localObject1).second).floatValue();
    localObject1 = x.SXb;
    if (bool1)
    {
      i = 1;
      ((bal)localObject10).LKe = i;
      localFinderItem.field_postExtraData = ((bal)localObject10);
      localFinderObject.displayidDiscarded = "";
      localFinderObject.recommendReason = "";
      localFinderObject.secondaryShowFlag = 1;
      localFinderObject.originalFlag = m;
      ((FinderObjectDesc)localObject7).description = ((String)localObject8);
      ((FinderObjectDesc)localObject7).mediaType = k;
      if (localObject3 != null) {
        break label4354;
      }
    }
    label4354:
    for (localObject1 = new axt();; localObject1 = localObject3)
    {
      ((FinderObjectDesc)localObject7).location = ((axt)localObject1);
      if (localObject2 == null) {}
      for (localObject1 = new aqp();; localObject1 = localObject2)
      {
        ((FinderObjectDesc)localObject7).extReading = ((aqp)localObject1);
        localObject4 = new HashMap();
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if ((com.tencent.mm.plugin.finder.storage.c.drO()) && (localArrayList != null))
        {
          localObject9 = new LinkedList();
          localObject10 = localArrayList.iterator();
          for (;;)
          {
            if (((Iterator)localObject10).hasNext())
            {
              localObject11 = (cjj)((Iterator)localObject10).next();
              localObject1 = new ayq();
              ((ayq)localObject1).username = ((cjj)localObject11).username;
              ((ayq)localObject1).source = ((cjj)localObject11).type;
              ((ayq)localObject1).nickname = ((cjj)localObject11).nickname;
              ((LinkedList)localObject9).add(localObject1);
              localObject3 = ((cjj)localObject11).nickname;
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = "";
              }
              ((HashMap)localObject4).put(localObject1, localObject11);
              localObject1 = x.SXb;
              continue;
              i = 0;
              break;
            }
          }
          ((FinderObjectDesc)localObject7).mentionedUser = ((LinkedList)localObject9);
          localObject1 = x.SXb;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drN())
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (!com.tencent.mm.plugin.finder.storage.c.drO()) {}
        }
        else
        {
          localObject1 = new bdq();
          localObject3 = com.tencent.mm.plugin.finder.utils.t.vWZ;
          ((bdq)localObject1).LNs = com.tencent.mm.plugin.finder.utils.t.c((String)localObject8, (HashMap)localObject4);
          localObject3 = x.SXb;
          ((FinderObjectDesc)localObject7).topic = ((bdq)localObject1);
        }
        localObject1 = localFinderItem.field_reportObject;
        label2500:
        float f;
        if (localObject1 != null)
        {
          localObject3 = ((FinderObjectDesc)localObject7).description;
          if (localObject3 == null) {
            break label2860;
          }
          i = ((String)localObject3).length();
          ((FinderFeedReportObject)localObject1).descCount = i;
          if (localFinderItem.field_reportObject.descCount <= 0) {
            break label2865;
          }
          i = 1;
          ((FinderFeedReportObject)localObject1).existDesc = i;
          localObject3 = ((FinderObjectDesc)localObject7).location;
          if (localObject3 == null) {
            break label2870;
          }
          f = ((axt)localObject3).latitude;
          label2524:
          if (f <= 0.0F) {
            break label2880;
          }
          localObject3 = ((FinderObjectDesc)localObject7).location;
          if (localObject3 == null) {
            break label2875;
          }
          f = ((axt)localObject3).dTj;
          label2548:
          if (f <= 0.0F) {
            break label2880;
          }
        }
        label2860:
        label2865:
        label2870:
        label2875:
        label2880:
        for (((FinderFeedReportObject)localObject1).existLocation = 1;; ((FinderFeedReportObject)localObject1).existLocation = 0)
        {
          if (localObject2 != null)
          {
            ((FinderFeedReportObject)localObject1).link = ((aqp)localObject2).link;
            localObject1 = x.SXb;
          }
          localObject1 = x.SXb;
          if (!bool2) {
            break label3033;
          }
          localObject3 = new cnl();
          ((cnl)localObject3).description = ((FinderObjectDesc)localObject7).description;
          localObject1 = ((FinderObjectDesc)localObject7).media;
          if (localObject1 == null) {
            break label2894;
          }
          localObject4 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject8 = (FinderMedia)((Iterator)localObject4).next();
            localObject7 = new cod();
            ((cod)localObject7).url = ((FinderMedia)localObject8).url;
            localObject1 = f.vSz;
            localObject2 = ((cod)localObject7).url;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            ((cod)localObject7).thumbUrl = f.avT((String)localObject1);
            ((cod)localObject7).mediaType = 0;
            localObject9 = MultiMediaVideoChecker.GyY;
            localObject2 = ((cod)localObject7).url;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject1 = ((MultiMediaVideoChecker)localObject9).aTV((String)localObject1);
            if (localObject1 != null)
            {
              ((cod)localObject7).width = ((MultiMediaVideoChecker.a)localObject1).width;
              ((cod)localObject7).height = ((MultiMediaVideoChecker.a)localObject1).height;
              ((cod)localObject7).Mur = kotlin.h.a.cR((float)((MultiMediaVideoChecker.a)localObject1).duration / 1000.0F);
              ((cod)localObject7).Mus = ((MultiMediaVideoChecker.a)localObject1).duration;
              localObject1 = x.SXb;
            }
            ((cod)localObject7).md5sum = ((FinderMedia)localObject8).md5sum;
            ((cod)localObject7).fileSize = ((FinderMedia)localObject8).fileSize;
            ((cod)localObject7).bitrate = ((FinderMedia)localObject8).bitrate;
            localObject1 = x.SXb;
            ((cnl)localObject3).media.add(localObject7);
          }
          i = 0;
          break;
          i = 0;
          break label2500;
          f = 0.0F;
          break label2524;
          f = 0.0F;
          break label2548;
        }
        localObject1 = x.SXb;
        label2894:
        localObject2 = new cng();
        ((cng)localObject2).id = 0L;
        ((cng)localObject2).iXu = localFinderObject.createtime;
        ((cng)localObject2).MtG = ((cnl)localObject3);
        localObject1 = x.SXb;
        localObject1 = new aoq();
        ((aoq)localObject1).LAM = new LinkedList();
        localObject3 = ((aoq)localObject1).LAM;
        localObject4 = new aop();
        ((aop)localObject4).type = 1;
        localObject7 = new bei();
        ((bei)localObject7).id = 0L;
        ((bei)localObject7).LIA = ((cng)localObject2);
        localObject2 = x.SXb;
        ((aop)localObject4).LAL = ((bei)localObject7);
        localObject2 = x.SXb;
        ((LinkedList)localObject3).add(localObject4);
        localObject2 = x.SXb;
        localFinderObject.attachmentList = ((aoq)localObject1);
        label3033:
        Log.i(this.TAG, "finder send post " + com.tencent.mm.ac.g.bN(localFinderObject));
        localFinderItem.updateFinderObject(localFinderObject);
        localObject1 = i.vSX;
        localObject3 = i.dBh();
        ((cjm)localObject3).Mpd = cl.aWy();
        if (localArrayList != null)
        {
          ((cjm)localObject3).Mpg.clear();
          ((cjm)localObject3).Mpg.addAll((Collection)localArrayList);
        }
        if (!Util.isNullOrNil(paramp.tsW))
        {
          localObject4 = new dmr();
          localObject1 = paramp.vTE;
          if (localObject1 != null)
          {
            localObject2 = ((arm)localObject1).dNI;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          ((dmr)localObject4).dNI = ((String)localObject1);
          ((dmr)localObject4).tsX = paramp.tsX;
          ((dmr)localObject4).tsW = paramp.tsW;
          paramp = x.SXb;
          ((cjm)localObject3).Mph = ((dmr)localObject4);
        }
        paramp = x.SXb;
        localFinderItem.setPostInfo((cjm)localObject3);
        if (localObject6 != null)
        {
          localObject1 = ((cjk)localObject6).mediaList;
          paramp = (p)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramp = new LinkedList();
        }
        localFinderItem.setMediaExtList(paramp);
        if (!((Collection)localObject5).isEmpty())
        {
          i = 1;
          if (i != 0) {
            localFinderItem.setHalfVideoMediaExtList((LinkedList)localObject5);
          }
          paramp = localFinderObject.attachmentList;
          if (paramp == null) {
            break label3872;
          }
          paramp = paramp.LAM;
          if (paramp == null) {
            break label3872;
          }
          paramp = (aop)kotlin.a.j.kt((List)paramp);
          if (paramp == null) {
            break label3872;
          }
          paramp = paramp.LAL;
          if (paramp == null) {
            break label3872;
          }
          paramp = paramp.LIA;
          if (paramp == null) {
            break label3872;
          }
          paramp = paramp.MtG;
          if (paramp == null) {
            break label3872;
          }
          paramp = paramp.media;
          if (paramp == null) {
            break label3872;
          }
          paramp = com.tencent.mm.plugin.finder.storage.data.j.aB(paramp);
          label3346:
          localFinderItem.setLongVideoMediaExtList(paramp);
          localObject2 = ((Iterable)localFinderItem.getLongVideoMediaExtList()).iterator();
          label3367:
          if (!((Iterator)localObject2).hasNext()) {
            break label4198;
          }
          localObject3 = (cjl)((Iterator)localObject2).next();
          ((cjl)localObject3).mediaId = ("longvideo_" + ((cjl)localObject3).mediaId);
          ((cjl)localObject3).MoO = true;
          localObject4 = new cjx();
          paramp = com.tencent.mm.plugin.finder.storage.c.vCb;
          localObject5 = com.tencent.mm.plugin.finder.storage.c.dqy();
          j = (int)((cjl)localObject3).width;
          i = (int)((cjl)localObject3).height;
          k = SightVideoJNI.getMp4RotateVFS(((cjl)localObject3).url);
          if ((k == 90) || (k == 270))
          {
            j = (int)((cjl)localObject3).height;
            i = (int)((cjl)localObject3).width;
          }
          paramp = MMApplicationContext.getContext();
          kotlin.g.b.p.g(paramp, "MMApplicationContext.getContext()");
          paramp = paramp.getResources();
          kotlin.g.b.p.g(paramp, "MMApplicationContext.getContext().resources");
          k = paramp.getDisplayMetrics().widthPixels;
          f = j / i;
          if ((f < 0.5625F) || (f > 1.777778F)) {
            break label3883;
          }
          paramp = new erf();
          paramp.left = 0;
          paramp.top = i;
          paramp.right = j;
          paramp.bottom = 0;
          localObject1 = x.SXb;
          ((cjx)localObject4).Mpq = paramp;
          ((cjx)localObject4).Mps = paramp;
          localObject1 = kotlin.a.j.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
          paramp = new bej();
          paramp.LOe.addAll((Collection)kotlin.a.j.p((Iterable)localObject1));
          localObject1 = x.SXb;
          ((cjx)localObject4).Mpr = paramp;
        }
        for (;;)
        {
          ((cjx)localObject4).dvv = 0;
          localObject6 = MultiMediaVideoChecker.GyY;
          localObject1 = ((cjl)localObject3).url;
          paramp = (p)localObject1;
          if (localObject1 == null) {
            paramp = "";
          }
          paramp = ((MultiMediaVideoChecker)localObject6).aTV(paramp);
          if (paramp != null)
          {
            ((cjx)localObject4).iqg = Math.min(((VideoTransPara)localObject5).duration * 1000, (int)paramp.duration);
            paramp = x.SXb;
          }
          paramp = af(j, i, Math.min(((VideoTransPara)localObject5).width, ((VideoTransPara)localObject5).height));
          i = ((Number)paramp.first).intValue();
          j = ((Number)paramp.second).intValue();
          ((cjx)localObject4).width = i;
          ((cjx)localObject4).height = j;
          ((cjl)localObject3).width = i;
          ((cjl)localObject3).height = j;
          ((cjx)localObject4).retryCount = 0;
          paramp = x.SXb;
          ((cjl)localObject3).uOR = ((cjx)localObject4);
          break label3367;
          i = 0;
          break;
          label3872:
          paramp = new LinkedList();
          break label3346;
          label3883:
          if (f > 1.777778F)
          {
            k = (int)(i * 16.0F / 9.0F);
            localObject1 = new erf();
            ((erf)localObject1).left = ((j - k) / 2);
            ((erf)localObject1).top = i;
            ((erf)localObject1).right = (j - ((erf)localObject1).left);
            ((erf)localObject1).bottom = 0;
            paramp = x.SXb;
            ((cjx)localObject4).Mpq = ((erf)localObject1);
            ((cjx)localObject4).Mps = ((erf)localObject1);
            paramp = new Matrix();
            paramp.postTranslate(-((erf)localObject1).left, 0.0F);
            localObject1 = new bej();
            localObject6 = new float[9];
            paramp.getValues((float[])localObject6);
            ((bej)localObject1).LOe.addAll((Collection)kotlin.a.e.s((float[])localObject6));
            paramp = x.SXb;
            ((cjx)localObject4).Mpr = ((bej)localObject1);
            j = k;
          }
          else
          {
            k = (int)(j * 16.0F / 9.0F);
            localObject1 = new erf();
            ((erf)localObject1).left = 0;
            ((erf)localObject1).bottom = ((i - k) / 2);
            ((erf)localObject1).right = j;
            ((erf)localObject1).top = (i - ((erf)localObject1).bottom);
            paramp = x.SXb;
            ((cjx)localObject4).Mpq = ((erf)localObject1);
            ((cjx)localObject4).Mps = ((erf)localObject1);
            paramp = new Matrix();
            paramp.postTranslate(0.0F, -((erf)localObject1).bottom);
            localObject1 = new bej();
            localObject6 = new float[9];
            paramp.getValues((float[])localObject6);
            ((bej)localObject1).LOe.addAll((Collection)kotlin.a.e.s((float[])localObject6));
            paramp = x.SXb;
            ((cjx)localObject4).Mpr = ((bej)localObject1);
            i = k;
          }
        }
        label4198:
        if (localazy != null)
        {
          paramp = localFinderItem.getPostInfo();
          paramp.Mpa = 1;
          localObject1 = x.SXb;
          localFinderItem.setPostInfo(paramp);
        }
        localFinderItem.setPostWaiting();
        l = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().k(localFinderItem);
        Log.i(this.TAG, "insertNewFeed " + l + " localId:" + l);
        localFinderItem.setLocalId(l);
        paramp = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        l.a.p(localFinderItem);
        FZ(l);
        dAZ();
        paramp = r.d.vhx;
        r.d.oa(localFinderItem.isLongVideo());
        paramp = com.tencent.mm.plugin.vlog.report.a.GDl;
        com.tencent.mm.plugin.vlog.report.a.fCu();
        localFinderItem.trackPost("doPost");
        AppMethodBeat.o(253078);
        return l;
      }
    }
  }
  
  public final void a(final q paramq)
  {
    AppMethodBeat.i(167760);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, paramq));
    AppMethodBeat.o(167760);
  }
  
  public final void b(final q paramq)
  {
    AppMethodBeat.i(167761);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(this, paramq));
    AppMethodBeat.o(167761);
  }
  
  public final void dAZ()
  {
    AppMethodBeat.i(167759);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().dxC();
    if (localFinderItem == null)
    {
      Log.d(this.TAG, "All has post, check posting folder");
      localObject = f.vSz;
      if (!f.dAX())
      {
        localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!((Boolean)com.tencent.mm.plugin.finder.storage.c.dtp().value()).booleanValue()) {}
      }
      else
      {
        localObject = new e(System.currentTimeMillis());
        this.ibn.c((com.tencent.mm.loader.g.c)localObject);
      }
      AppMethodBeat.o(167759);
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checking post-waiting finder feed from db, next will post: ").append(localFinderItem.getLocalId()).append(' ').append(localFinderItem.getCreateTime()).append(' ');
    Object localObject = localFinderItem.getPostInfo();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((cjm)localObject).ibG);; localObject = null)
    {
      Log.i(str, ((Integer)localObject).intValue());
      localObject = new h(localFinderItem);
      this.ibn.c((com.tencent.mm.loader.g.c)localObject);
      AppMethodBeat.o(167759);
      return;
    }
  }
  
  public final void t(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167758);
    kotlin.g.b.p.h(paramFinderItem, "feed");
    Log.i(this.TAG, "Finder.PostLog repost " + paramFinderItem.getLocalId());
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.a.FS(paramFinderItem.getLocalId());
    if (localObject1 == null) {}
    for (;;)
    {
      paramFinderItem.setPostWaiting();
      localObject1 = paramFinderItem.getPostInfo();
      ((cjm)localObject1).ibG = 0;
      ((cjm)localObject1).Mpc = 0;
      if (((cjm)localObject1).Mpa == 2) {
        ((cjm)localObject1).Mpa = 0;
      }
      localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((cjl)((Iterator)localObject1).next()).uOR;
        if (localObject2 != null) {
          ((cjx)localObject2).retryCount = 0;
        }
      }
      localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((cjl)((Iterator)localObject1).next()).uOR;
        if (localObject2 != null) {
          ((cjx)localObject2).retryCount = 0;
        }
      }
      localObject1 = paramFinderItem.field_reportObject;
      if (localObject1 != null)
      {
        ((FinderFeedReportObject)localObject1).clickRepostCount += 1;
        localObject2 = i.vSX;
        i.a((FinderFeedReportObject)localObject1, "clickRepost");
      }
      if (paramFinderItem.isMvFeed())
      {
        localObject1 = ((Iterable)paramFinderItem.getClipListExt()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterable)((FinderItem)((Iterator)localObject1).next()).getMediaList()).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            cjx localcjx = ((cjl)((Iterator)localObject2).next()).uOR;
            if (localcjx != null) {
              localcjx.retryCount = 0;
            }
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        com.tencent.mm.plugin.finder.storage.logic.c.a.q(paramFinderItem);
      }
      for (;;)
      {
        dAZ();
        localObject1 = r.d.vhx;
        r.d.oa(paramFinderItem.isLongVideo());
        localObject1 = r.d.vhx;
        r.d.on(paramFinderItem.isLongVideo());
        if (paramFinderItem.isLongVideo())
        {
          localObject1 = r.d.vhx;
          r.d.doy();
        }
        localObject1 = EventCenter.instance;
        localObject2 = new hk();
        ((hk)localObject2).dLT.localId = paramFinderItem.getLocalId();
        ((hk)localObject2).dLT.progress = paramFinderItem.getPostInfo().Mpc;
        ((EventCenter)localObject1).publish((IEvent)localObject2);
        AppMethodBeat.o(167758);
        return;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        com.tencent.mm.plugin.finder.storage.logic.c.a.r(paramFinderItem);
      }
      paramFinderItem = (FinderItem)localObject1;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "shouldScrollToPostingItem", "", "getShouldScrollToPostingItem", "()Z", "setShouldScrollToPostingItem", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(g paramg, q paramq)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(g paramg, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<h>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(g paramg, q paramq)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.loader.g.f<n>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.g
 * JD-Core Version:    0.7.0.1
 */