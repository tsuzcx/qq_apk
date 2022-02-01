package com.tencent.mm.plugin.finder.upload;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.report.v.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dwi;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "", "()V", "TAG", "", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "mediaProcessQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "mvMediaProcessQueue", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "mvUploadQueue", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "postCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "uploadCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1;", "uploadImageQueue", "Lcom/tencent/mm/loader/loader/IWorkTask;", "uploadQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "addPostEndListener", "", "listener", "checkNextPost", "doMvProcess", "processTask", "callback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "doMvUpload", "uploadTask", "doPost", "", "data", "Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "musicData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "doProcess", "doUpload", "generateFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mediaType", "", "description", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "isLongVideo", "isNewsFeed", "notifyEventPost", "localId", "isOk", "notifyPostError", "notifyPostOk", "svrId", "notifyStartPost", "onStart", "onStop", "rePost", "feed", "removePostEndListener", "resizeOfShort", "Lkotlin/Pair;", "originWidth", "originHeight", "max", "uploadActivityCover", "path", "uploadCoverImage", "userName", "uploadLiveCoverImage", "Companion", "plugin-finder_release"})
public final class g
{
  private static final g AAh;
  private static int AAi;
  private static boolean AAj;
  public static final a AAk;
  public com.tencent.mm.loader.g.d<n> AAa;
  public com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> AAb;
  com.tencent.mm.loader.g.d<c> AAc;
  com.tencent.mm.loader.g.d<r> AAd;
  com.tencent.mm.loader.g.d<s> AAe;
  public final g AAf;
  public final i AAg;
  public final String TAG;
  public com.tencent.mm.loader.g.d<h> kPU;
  private final HashSet<q> listeners;
  
  static
  {
    AppMethodBeat.i(167765);
    AAk = new a((byte)0);
    AAh = new g();
    AppMethodBeat.o(167765);
  }
  
  public g()
  {
    AppMethodBeat.i(167764);
    this.kPU = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderPost"));
    this.AAa = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUpload"));
    this.AAb = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUploadImage"));
    this.AAc = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderMediaProcess"));
    this.AAd = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "mv_finderMediaProcess"));
    this.AAe = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "mv_finderUpload"));
    this.TAG = "Finder.LogPost.FinderPostManager";
    this.AAf = new g(this);
    this.AAg = new i();
    this.listeners = new HashSet();
    AppMethodBeat.o(167764);
  }
  
  public static kotlin.o<Integer, Integer> aj(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(269718);
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
        AppMethodBeat.o(269718);
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
            AppMethodBeat.o(269718);
            return localo;
            paramInt3 = i;
          }
        }
        paramInt3 = i;
      }
    }
  }
  
  public final void MZ(final long paramLong)
  {
    AppMethodBeat.i(167763);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramLong));
    AppMethodBeat.o(167763);
  }
  
  public final long a(p paramp)
  {
    AppMethodBeat.i(269714);
    kotlin.g.b.p.k(paramp, "data");
    int k = paramp.mediaType;
    Object localObject8 = paramp.description;
    Object localObject6 = paramp.ABa;
    Object localObject3 = paramp.location;
    Object localObject2 = paramp.ABb;
    int m = paramp.originalFlag;
    bge localbge = paramp.ABc;
    boolean bool1 = paramp.ABd;
    Object localObject1 = paramp.ABe;
    ArrayList localArrayList = paramp.ABf;
    boolean bool2 = paramp.isLongVideo;
    boolean bool3 = paramp.ABg;
    Object localObject9 = paramp.ABi;
    FinderItem localFinderItem = new FinderItem();
    Object localObject4 = com.tencent.mm.plugin.finder.report.k.zWs;
    localFinderItem.field_reportObject = com.tencent.mm.plugin.finder.report.k.dPz();
    localObject4 = localFinderItem.field_reportObject;
    if (localObject4 != null)
    {
      ((FinderFeedReportObject)localObject4).sendOrExitButtonTime = cm.bfE();
      ((FinderFeedReportObject)localObject4).videoPostType = k;
      ((FinderFeedReportObject)localObject4).beforeCutMediaPath = ((String)localObject1);
      ((FinderFeedReportObject)localObject4).postStage = 1;
      ((FinderFeedReportObject)localObject4).sdkShareType = paramp.sdkShareType;
      localObject1 = x.aazN;
    }
    localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    Object localObject5 = d.a.aAK(z.bdh());
    FinderObject localFinderObject = new FinderObject();
    Object localObject7 = new FinderObjectDesc();
    int i;
    long l;
    if (bool3)
    {
      i = 1;
      localFinderObject.objectType = i;
      if (localbge == null) {
        break label340;
      }
      l = localbge.refObjectId;
      label223:
      localFinderObject.refObjectId = l;
      if (localbge == null) {
        break label346;
      }
      l = localbge.refObjectFlag;
      label242:
      localFinderObject.refObjectFlag = l;
      if (localbge == null) {
        break label352;
      }
    }
    label340:
    label346:
    label352:
    for (localObject1 = localbge.refObjectContact;; localObject1 = null)
    {
      localFinderObject.refObjectContact = ((FinderContact)localObject1);
      localFinderObject.id = 0L;
      localFinderObject.username = z.bdh();
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.VxY, "");
      if (localObject1 != null) {
        break label358;
      }
      paramp = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(269714);
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
    localObject1 = aj.AGc;
    localFinderObject.createtime = aj.Ne(cm.bfC());
    if (localObject5 != null) {}
    for (localObject1 = com.tencent.mm.plugin.finder.api.c.a((com.tencent.mm.plugin.finder.api.i)localObject5);; localObject1 = localObject4)
    {
      localFinderObject.contact = ((FinderContact)localObject1);
      localFinderObject.mentionedUserContact = new LinkedList();
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((!com.tencent.mm.plugin.finder.storage.d.dTe()) || (localArrayList == null)) {
        break label757;
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (cse)((Iterator)localObject1).next();
        localObject5 = localFinderObject.mentionedUserContact;
        localObject10 = com.tencent.mm.plugin.finder.utils.e.ACV;
        kotlin.g.b.p.j(localObject4, "atContact");
        ((LinkedList)localObject5).add(com.tencent.mm.plugin.finder.utils.e.b((cse)localObject4));
      }
      localObject4 = new FinderContact();
      ((FinderContact)localObject4).username = z.bdh();
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.VxY, "");
      if (localObject1 == null)
      {
        paramp = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(269714);
        throw paramp;
      }
      ((FinderContact)localObject4).nickname = ((String)localObject1);
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.Vya, "");
      if (localObject1 == null)
      {
        paramp = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(269714);
        throw paramp;
      }
      ((FinderContact)localObject4).headUrl = ((String)localObject1);
      if (localObject5 != null)
      {
        localObject5 = ((com.tencent.mm.plugin.finder.api.i)localObject5).field_signature;
        localObject1 = localObject5;
        if (localObject5 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((FinderContact)localObject4).signature = ((String)localObject1);
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.Vyg, "");
      if (localObject1 == null)
      {
        paramp = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(269714);
        throw paramp;
      }
      ((FinderContact)localObject4).coverImgUrl = ((String)localObject1);
      localObject1 = x.aazN;
    }
    localObject1 = x.aazN;
    label757:
    localObject1 = aj.AGc;
    if (aj.dOO()) {
      localFinderObject.permissionFlag = 3;
    }
    Object localObject10 = new bgw();
    label823:
    label870:
    Object localObject11;
    if (localObject6 != null)
    {
      localObject1 = ((csf)localObject6).TzP;
      ((FinderObjectDesc)localObject7).imgFeedBgmInfo = ((bfg)localObject1);
      localObject5 = new bfs();
      if (localObject6 == null) {
        break label1695;
      }
      localObject1 = ((csf)localObject6).TzP;
      ((bfs)localObject5).musicInfo = ((bfg)localObject1);
      if (localObject6 != null)
      {
        localObject4 = ((csf)localObject6).AtP;
        localObject1 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject1 = ((bfs)localObject5).musicInfo;
        if (localObject1 == null) {
          break label1701;
        }
        localObject1 = ((bfg)localObject1).BHW;
      }
      ((bfs)localObject5).groupId = ((String)localObject1);
      if (((localObject6 == null) || (((csf)localObject6).Btc)) && ((localObject6 == null) || (((csf)localObject6).Btd))) {
        break label1707;
      }
      i = 1;
      label905:
      ((bfs)localObject5).SQv = i;
      localObject4 = this.TAG;
      localObject11 = new StringBuilder("FinderObjectBGMInfo, groupId:").append(((bfs)localObject5).groupId).append(", mediaMute:");
      if (localObject6 == null) {
        break label1712;
      }
      localObject1 = Boolean.valueOf(((csf)localObject6).Btc);
      label958:
      localObject11 = ((StringBuilder)localObject11).append(localObject1).append(", musicMute:");
      if (localObject6 == null) {
        break label1718;
      }
      localObject1 = Boolean.valueOf(((csf)localObject6).Btd);
      label988:
      Log.d((String)localObject4, localObject1 + ", hasBgm:" + ((bfs)localObject5).SQv);
      localObject1 = (CharSequence)((bfs)localObject5).groupId;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label1724;
      }
      i = 1;
      label1044:
      if ((i == 0) && (((bfs)localObject5).musicInfo == null))
      {
        localObject4 = new bfg();
        if (localObject6 == null) {
          break label1729;
        }
        localObject1 = ((csf)localObject6).TzQ;
        label1077:
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label1735;
        }
        i = 1;
        label1101:
        if (i == 0) {
          break label1746;
        }
        if (localObject6 == null) {
          break label1740;
        }
        localObject1 = ((csf)localObject6).AtN;
        label1117:
        localObject1 = com.tencent.mm.b.q.n((String)localObject1, true);
        label1125:
        ((bfg)localObject4).SPV = ((String)localObject1);
        localObject1 = x.aazN;
        ((bfs)localObject5).musicInfo = ((bfg)localObject4);
      }
      localObject1 = x.aazN;
      ((FinderObjectDesc)localObject7).feedBgmInfo = ((bfs)localObject5);
      ((FinderObjectDesc)localObject7).fromApp = paramp.ABh;
      ((FinderObjectDesc)localObject7).event = ((bfv)localObject9);
      localObject5 = new LinkedList();
      if (localObject6 == null) {
        break label1955;
      }
      localObject1 = ((csf)localObject6).mediaList;
      if (localObject1 == null) {
        break label1955;
      }
      localObject9 = ((Iterable)localObject1).iterator();
      i = 0;
    }
    label1212:
    int j;
    for (;;)
    {
      if (!((Iterator)localObject9).hasNext()) {
        break label1950;
      }
      localObject1 = ((Iterator)localObject9).next();
      j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localObject11 = (csg)localObject1;
      Object localObject12 = new FinderMedia();
      ((FinderMedia)localObject12).url = ((csg)localObject11).url;
      ((FinderMedia)localObject12).mediaType = ((csg)localObject11).mediaType;
      ((FinderMedia)localObject12).thumbUrl = ((csg)localObject11).thumbUrl;
      ((FinderMedia)localObject12).full_thumb_url = ((csg)localObject11).TzX;
      if ((!((csg)localObject11).TzU) && (((csg)localObject11).videoDuration <= 0))
      {
        localObject1 = com.tencent.mm.plugin.sight.base.f.aYg(((csg)localObject11).url);
        if (localObject1 != null)
        {
          ((csg)localObject11).videoDuration = ((com.tencent.mm.plugin.sight.base.b)localObject1).getVideoDuration();
          localObject1 = x.aazN;
        }
      }
      ((FinderMedia)localObject12).videoDuration = ((csg)localObject11).videoDuration;
      ((FinderMedia)localObject12).width = ((csg)localObject11).width;
      ((FinderMedia)localObject12).height = ((csg)localObject11).height;
      ((FinderMedia)localObject12).md5sum = ((csg)localObject11).md5sum;
      ((FinderMedia)localObject12).coverUrl = ((csg)localObject11).coverUrl;
      localObject1 = o.AAZ;
      kotlin.g.b.p.j(localObject11, "it");
      o.a((csg)localObject11, (LinkedList)localObject5);
      ((FinderObjectDesc)localObject7).media.add(localObject12);
      if ((i == 0) && (!Util.isNullOrNil(((csg)localObject11).url)) && ((((csg)localObject11).mediaType == 2) || (((csg)localObject11).mediaType == 4)))
      {
        if (((csg)localObject11).mediaType != 2) {
          break label1767;
        }
        localObject1 = aj.AGc;
        localObject4 = ((csg)localObject11).url;
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
      }
      for (localObject1 = aj.aFK((String)localObject1);; localObject1 = aj.aFL(((csg)localObject11).url))
      {
        if (localObject1 != null)
        {
          ((bgw)localObject10).SRy = ((float)((Number)((kotlin.o)localObject1).Mx).doubleValue());
          ((bgw)localObject10).SRx = ((float)((Number)((kotlin.o)localObject1).My).doubleValue());
          localObject1 = x.aazN;
        }
        if (((FinderMedia)localObject12).mediaType != 2) {
          break label1785;
        }
        localObject1 = this.TAG;
        localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((csg)localObject11).url).append(" size:").append(Util.getSizeKB(u.bBQ(((csg)localObject11).url))).append(" option ");
        localObject11 = BitmapUtil.getImageOptions(((csg)localObject11).url);
        Log.i((String)localObject1, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject11).outWidth).append(" * ").append(((BitmapFactory.Options)localObject11).outHeight).append(']').toString() + '}');
        i = j;
        break label1212;
        localObject1 = null;
        break;
        label1695:
        localObject1 = null;
        break label823;
        label1701:
        localObject1 = null;
        break label870;
        label1707:
        i = 0;
        break label905;
        label1712:
        localObject1 = null;
        break label958;
        label1718:
        localObject1 = null;
        break label988;
        label1724:
        i = 0;
        break label1044;
        label1729:
        localObject1 = null;
        break label1077;
        label1735:
        i = 0;
        break label1101;
        label1740:
        localObject1 = null;
        break label1117;
        label1746:
        if (localObject6 != null)
        {
          localObject1 = ((csf)localObject6).TzQ;
          break label1125;
        }
        localObject1 = null;
        break label1125;
        label1767:
        localObject1 = aj.AGc;
      }
      label1785:
      if (((FinderMedia)localObject12).mediaType == 4)
      {
        localObject1 = this.TAG;
        localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((csg)localObject11).url).append(" size:").append(Util.getSizeKB(u.bBQ(((csg)localObject11).url))).append(" option ");
        localObject12 = com.tencent.mm.plugin.gallery.a.d.CeY;
        Log.i((String)localObject1, com.tencent.mm.plugin.gallery.a.d.aFG(((csg)localObject11).url));
        i = j;
      }
      else
      {
        Log.i(this.TAG, "print mediaList " + i + ' ' + ((csg)localObject11).url + " size:" + Util.getSizeKB(u.bBQ(((csg)localObject11).url)));
        i = j;
      }
    }
    label1950:
    localObject1 = x.aazN;
    label1955:
    localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.a)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
    ((bgw)localObject10).longitude = ((Number)((kotlin.o)localObject1).Mx).floatValue();
    ((bgw)localObject10).latitude = ((Number)((kotlin.o)localObject1).My).floatValue();
    localObject1 = x.aazN;
    if (bool1)
    {
      i = 1;
      ((bgw)localObject10).SRz = i;
      localFinderItem.field_postExtraData = ((bgw)localObject10);
      localFinderObject.displayidDiscarded = "";
      localFinderObject.recommendReason = "";
      localFinderObject.secondaryShowFlag = 1;
      localFinderObject.originalFlag = m;
      ((FinderObjectDesc)localObject7).description = ((String)localObject8);
      ((FinderObjectDesc)localObject7).mediaType = k;
      if (localObject3 != null) {
        break label4288;
      }
    }
    label2445:
    label3243:
    label3769:
    label4288:
    for (localObject1 = new bdm();; localObject1 = localObject3)
    {
      ((FinderObjectDesc)localObject7).location = ((bdm)localObject1);
      if (localObject2 == null) {}
      for (localObject1 = new asl();; localObject1 = localObject2)
      {
        ((FinderObjectDesc)localObject7).extReading = ((asl)localObject1);
        localObject4 = new HashMap();
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if ((com.tencent.mm.plugin.finder.storage.d.dTe()) && (localArrayList != null))
        {
          localObject9 = new LinkedList();
          localObject10 = localArrayList.iterator();
          for (;;)
          {
            if (((Iterator)localObject10).hasNext())
            {
              localObject11 = (cse)((Iterator)localObject10).next();
              localObject1 = new bek();
              ((bek)localObject1).username = ((cse)localObject11).username;
              ((bek)localObject1).source = ((cse)localObject11).type;
              ((bek)localObject1).nickname = ((cse)localObject11).nickname;
              ((LinkedList)localObject9).add(localObject1);
              localObject3 = ((cse)localObject11).nickname;
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = "";
              }
              ((HashMap)localObject4).put(localObject1, localObject11);
              localObject1 = x.aazN;
              continue;
              i = 0;
              break;
            }
          }
          ((FinderObjectDesc)localObject7).mentionedUser = ((LinkedList)localObject9);
          localObject1 = x.aazN;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!com.tencent.mm.plugin.finder.storage.d.dTd())
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (!com.tencent.mm.plugin.finder.storage.d.dTe()) {}
        }
        else
        {
          localObject1 = new bkp();
          localObject3 = ad.AFr;
          ((bkp)localObject1).SVC = ad.d((String)localObject8, (HashMap)localObject4);
          localObject3 = x.aazN;
          ((FinderObjectDesc)localObject7).topic = ((bkp)localObject1);
        }
        localObject1 = localFinderItem.field_reportObject;
        label2397:
        float f;
        if (localObject1 != null)
        {
          localObject3 = ((FinderObjectDesc)localObject7).description;
          if (localObject3 == null) {
            break label2757;
          }
          i = ((String)localObject3).length();
          ((FinderFeedReportObject)localObject1).descCount = i;
          if (localFinderItem.field_reportObject.descCount <= 0) {
            break label2762;
          }
          i = 1;
          ((FinderFeedReportObject)localObject1).existDesc = i;
          localObject3 = ((FinderObjectDesc)localObject7).location;
          if (localObject3 == null) {
            break label2767;
          }
          f = ((bdm)localObject3).latitude;
          label2421:
          if (f <= 0.0F) {
            break label2777;
          }
          localObject3 = ((FinderObjectDesc)localObject7).location;
          if (localObject3 == null) {
            break label2772;
          }
          f = ((bdm)localObject3).longitude;
          if (f <= 0.0F) {
            break label2777;
          }
        }
        label2757:
        label2762:
        label2767:
        label2772:
        label2777:
        for (((FinderFeedReportObject)localObject1).existLocation = 1;; ((FinderFeedReportObject)localObject1).existLocation = 0)
        {
          if (localObject2 != null)
          {
            ((FinderFeedReportObject)localObject1).link = ((asl)localObject2).link;
            localObject1 = x.aazN;
          }
          localObject1 = x.aazN;
          if (!bool2) {
            break label2930;
          }
          localObject3 = new cwc();
          ((cwc)localObject3).description = ((FinderObjectDesc)localObject7).description;
          localObject1 = ((FinderObjectDesc)localObject7).media;
          if (localObject1 == null) {
            break label2791;
          }
          localObject4 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject8 = (FinderMedia)((Iterator)localObject4).next();
            localObject7 = new cwq();
            ((cwq)localObject7).url = ((FinderMedia)localObject8).url;
            localObject1 = f.AzZ;
            localObject2 = ((cwq)localObject7).url;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            ((cwq)localObject7).thumbUrl = f.aFj((String)localObject1);
            ((cwq)localObject7).mediaType = 0;
            localObject9 = MultiMediaVideoChecker.NmA;
            localObject2 = ((cwq)localObject7).url;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject1 = ((MultiMediaVideoChecker)localObject9).bfs((String)localObject1);
            if (localObject1 != null)
            {
              ((cwq)localObject7).width = ((MultiMediaVideoChecker.a)localObject1).width;
              ((cwq)localObject7).height = ((MultiMediaVideoChecker.a)localObject1).height;
              ((cwq)localObject7).TFq = kotlin.h.a.dm((float)((MultiMediaVideoChecker.a)localObject1).duration / 1000.0F);
              ((cwq)localObject7).TFr = ((MultiMediaVideoChecker.a)localObject1).duration;
              localObject1 = x.aazN;
            }
            ((cwq)localObject7).md5sum = ((FinderMedia)localObject8).md5sum;
            ((cwq)localObject7).fileSize = ((FinderMedia)localObject8).fileSize;
            ((cwq)localObject7).bitrate = ((FinderMedia)localObject8).bitrate;
            localObject1 = x.aazN;
            ((cwc)localObject3).media.add(localObject7);
          }
          i = 0;
          break;
          i = 0;
          break label2397;
          f = 0.0F;
          break label2421;
          f = 0.0F;
          break label2445;
        }
        localObject1 = x.aazN;
        label2791:
        localObject2 = new cvy();
        ((cvy)localObject2).id = 0L;
        ((cvy)localObject2).createTime = localFinderObject.createtime;
        ((cvy)localObject2).TEM = ((cwc)localObject3);
        localObject1 = x.aazN;
        localObject1 = new apx();
        ((apx)localObject1).SDm = new LinkedList();
        localObject3 = ((apx)localObject1).SDm;
        localObject4 = new apw();
        ((apw)localObject4).type = 1;
        localObject7 = new blj();
        ((blj)localObject7).id = 0L;
        ((blj)localObject7).SPm = ((cvy)localObject2);
        localObject2 = x.aazN;
        ((apw)localObject4).SDl = ((blj)localObject7);
        localObject2 = x.aazN;
        ((LinkedList)localObject3).add(localObject4);
        localObject2 = x.aazN;
        localFinderObject.attachmentList = ((apx)localObject1);
        label2930:
        Log.i(this.TAG, "finder send post " + com.tencent.mm.ae.g.bN(localFinderObject));
        localFinderItem.updateFinderObject(localFinderObject);
        localObject1 = i.AAy;
        localObject3 = i.ecp();
        ((csh)localObject3).TAj = cm.bfC();
        if (localArrayList != null)
        {
          ((csh)localObject3).TAm.clear();
          ((csh)localObject3).TAm.addAll((Collection)localArrayList);
        }
        if (!Util.isNullOrNil(paramp.xaL))
        {
          localObject4 = new dwi();
          localObject1 = paramp.ABh;
          if (localObject1 != null)
          {
            localObject2 = ((ati)localObject1).appid;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          ((dwi)localObject4).appid = ((String)localObject1);
          ((dwi)localObject4).xaM = paramp.xaM;
          ((dwi)localObject4).xaL = paramp.xaL;
          paramp = x.aazN;
          ((csh)localObject3).TAn = ((dwi)localObject4);
        }
        paramp = x.aazN;
        localFinderItem.setPostInfo((csh)localObject3);
        if (localObject6 != null)
        {
          localObject1 = ((csf)localObject6).mediaList;
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
            break label3769;
          }
          paramp = paramp.SDm;
          if (paramp == null) {
            break label3769;
          }
          paramp = (apw)j.lp((List)paramp);
          if (paramp == null) {
            break label3769;
          }
          paramp = paramp.SDl;
          if (paramp == null) {
            break label3769;
          }
          paramp = paramp.SPm;
          if (paramp == null) {
            break label3769;
          }
          paramp = paramp.TEM;
          if (paramp == null) {
            break label3769;
          }
          paramp = paramp.media;
          if (paramp == null) {
            break label3769;
          }
          paramp = com.tencent.mm.plugin.finder.storage.data.i.aS(paramp);
          localFinderItem.setLongVideoMediaExtList(paramp);
          localObject2 = ((Iterable)localFinderItem.getLongVideoMediaExtList()).iterator();
          label3264:
          if (!((Iterator)localObject2).hasNext()) {
            break label4095;
          }
          localObject3 = (csg)((Iterator)localObject2).next();
          ((csg)localObject3).mediaId = ("longvideo_" + ((csg)localObject3).mediaId);
          ((csg)localObject3).TzU = true;
          localObject4 = new css();
          paramp = com.tencent.mm.plugin.finder.ui.config.a.AxF;
          localObject5 = com.tencent.mm.plugin.finder.ui.config.a.ebF();
          j = (int)((csg)localObject3).width;
          i = (int)((csg)localObject3).height;
          k = SightVideoJNI.getMp4RotateVFS(((csg)localObject3).url);
          if ((k == 90) || (k == 270))
          {
            j = (int)((csg)localObject3).height;
            i = (int)((csg)localObject3).width;
          }
          paramp = MMApplicationContext.getContext();
          kotlin.g.b.p.j(paramp, "MMApplicationContext.getContext()");
          paramp = paramp.getResources();
          kotlin.g.b.p.j(paramp, "MMApplicationContext.getContext().resources");
          k = paramp.getDisplayMetrics().widthPixels;
          f = j / i;
          if ((f < 0.5625F) || (f > 1.777778F)) {
            break label3780;
          }
          paramp = new fbq();
          paramp.left = 0;
          paramp.top = i;
          paramp.right = j;
          paramp.bottom = 0;
          localObject1 = x.aazN;
          ((css)localObject4).TAv = paramp;
          ((css)localObject4).TAx = paramp;
          localObject1 = j.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
          paramp = new blk();
          paramp.SWx.addAll((Collection)j.p((Iterable)localObject1));
          localObject1 = x.aazN;
          ((css)localObject4).TAw = paramp;
        }
        for (;;)
        {
          ((css)localObject4).fod = 0;
          localObject6 = MultiMediaVideoChecker.NmA;
          localObject1 = ((csg)localObject3).url;
          paramp = (p)localObject1;
          if (localObject1 == null) {
            paramp = "";
          }
          paramp = ((MultiMediaVideoChecker)localObject6).bfs(paramp);
          if (paramp != null)
          {
            ((css)localObject4).endTime = Math.min(((VideoTransPara)localObject5).duration * 1000, (int)paramp.duration);
            paramp = x.aazN;
          }
          paramp = aj(j, i, Math.min(((VideoTransPara)localObject5).width, ((VideoTransPara)localObject5).height));
          i = ((Number)paramp.Mx).intValue();
          j = ((Number)paramp.My).intValue();
          ((css)localObject4).width = i;
          ((css)localObject4).height = j;
          ((csg)localObject3).width = i;
          ((csg)localObject3).height = j;
          ((css)localObject4).retryCount = 0;
          paramp = x.aazN;
          ((csg)localObject3).zBo = ((css)localObject4);
          break label3264;
          i = 0;
          break;
          paramp = new LinkedList();
          break label3243;
          label3780:
          if (f > 1.777778F)
          {
            k = (int)(i * 16.0F / 9.0F);
            localObject1 = new fbq();
            ((fbq)localObject1).left = ((j - k) / 2);
            ((fbq)localObject1).top = i;
            ((fbq)localObject1).right = (j - ((fbq)localObject1).left);
            ((fbq)localObject1).bottom = 0;
            paramp = x.aazN;
            ((css)localObject4).TAv = ((fbq)localObject1);
            ((css)localObject4).TAx = ((fbq)localObject1);
            paramp = new Matrix();
            paramp.postTranslate(-((fbq)localObject1).left, 0.0F);
            localObject1 = new blk();
            localObject6 = new float[9];
            paramp.getValues((float[])localObject6);
            ((blk)localObject1).SWx.addAll((Collection)kotlin.a.e.t((float[])localObject6));
            paramp = x.aazN;
            ((css)localObject4).TAw = ((blk)localObject1);
            j = k;
          }
          else
          {
            k = (int)(j * 16.0F / 9.0F);
            localObject1 = new fbq();
            ((fbq)localObject1).left = 0;
            ((fbq)localObject1).bottom = ((i - k) / 2);
            ((fbq)localObject1).right = j;
            ((fbq)localObject1).top = (i - ((fbq)localObject1).bottom);
            paramp = x.aazN;
            ((css)localObject4).TAv = ((fbq)localObject1);
            ((css)localObject4).TAx = ((fbq)localObject1);
            paramp = new Matrix();
            paramp.postTranslate(0.0F, -((fbq)localObject1).bottom);
            localObject1 = new blk();
            localObject6 = new float[9];
            paramp.getValues((float[])localObject6);
            ((blk)localObject1).SWx.addAll((Collection)kotlin.a.e.t((float[])localObject6));
            paramp = x.aazN;
            ((css)localObject4).TAw = ((blk)localObject1);
            i = k;
          }
        }
        label4095:
        if (localbge != null)
        {
          paramp = localFinderItem.getPostInfo();
          paramp.TAg = 1;
          localObject1 = x.aazN;
          localFinderItem.setPostInfo(paramp);
        }
        localFinderItem.setPostWaiting();
        if (((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage().dYC() != null)
        {
          Log.i(this.TAG, "movefile first");
          paramp = f.AzZ;
          f.t(localFinderItem);
        }
        l = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage().l(localFinderItem);
        Log.i(this.TAG, "insertNewFeed " + l + " localId:" + l);
        localFinderItem.setLocalId(l);
        paramp = com.tencent.mm.plugin.finder.storage.data.k.Anu;
        k.a.q(localFinderItem);
        MZ(l);
        eci();
        paramp = v.d.zYG;
        v.d.ql(localFinderItem.isLongVideo());
        paramp = com.tencent.mm.plugin.vlog.report.b.NqX;
        com.tencent.mm.plugin.vlog.report.b.gut();
        localFinderItem.trackPost("doPost");
        AppMethodBeat.o(269714);
        return l;
      }
    }
  }
  
  public final void a(final q paramq)
  {
    AppMethodBeat.i(167760);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramq));
    AppMethodBeat.o(167760);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c> paramf)
  {
    AppMethodBeat.i(269716);
    kotlin.g.b.p.k(paramString1, "path");
    kotlin.g.b.p.k(paramString2, "userName");
    kotlin.g.b.p.k(paramf, "callback");
    this.AAb.a((com.tencent.mm.loader.g.c)new m(paramString1, paramString2), paramf);
    AppMethodBeat.o(269716);
  }
  
  public final void b(final q paramq)
  {
    AppMethodBeat.i(167761);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramq));
    AppMethodBeat.o(167761);
  }
  
  public final void eci()
  {
    AppMethodBeat.i(167759);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage().dYC();
    if (localFinderItem == null)
    {
      Log.i(this.TAG, "All has post, check posting folder");
      localObject = f.AzZ;
      if (!f.ecg())
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.dUA().aSr()).booleanValue()) {}
      }
      else
      {
        localObject = new e(System.currentTimeMillis());
        this.kPU.b((com.tencent.mm.loader.g.c)localObject);
      }
      AppMethodBeat.o(167759);
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checking post-waiting finder feed from db, next will post: ").append(localFinderItem.getLocalId()).append(' ').append(localFinderItem.getCreateTime()).append(' ');
    Object localObject = localFinderItem.getPostInfo();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((csh)localObject).kQn);; localObject = null)
    {
      Log.i(str, ((Integer)localObject).intValue());
      localObject = new h(localFinderItem);
      this.kPU.b((com.tencent.mm.loader.g.c)localObject);
      AppMethodBeat.o(167759);
      return;
    }
  }
  
  public final void v(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167758);
    kotlin.g.b.p.k(paramFinderItem, "feed");
    Log.i(this.TAG, "Finder.PostLog repost " + paramFinderItem.getLocalId());
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    localObject1 = c.a.MS(paramFinderItem.getLocalId());
    if (localObject1 == null) {}
    for (;;)
    {
      paramFinderItem.setPostWaiting();
      localObject1 = paramFinderItem.getPostInfo();
      ((csh)localObject1).kQn = 0;
      ((csh)localObject1).TAi = 0;
      if (((csh)localObject1).TAg == 2) {
        ((csh)localObject1).TAg = 0;
      }
      localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((csg)((Iterator)localObject1).next()).zBo;
        if (localObject2 != null) {
          ((css)localObject2).retryCount = 0;
        }
      }
      localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((csg)((Iterator)localObject1).next()).zBo;
        if (localObject2 != null) {
          ((css)localObject2).retryCount = 0;
        }
      }
      localObject1 = paramFinderItem.field_reportObject;
      if (localObject1 != null)
      {
        ((FinderFeedReportObject)localObject1).clickRepostCount += 1;
        localObject2 = i.AAy;
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
            css localcss = ((csg)((Iterator)localObject2).next()).zBo;
            if (localcss != null) {
              localcss.retryCount = 0;
            }
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.r(paramFinderItem);
      }
      for (;;)
      {
        eci();
        localObject1 = v.d.zYG;
        v.d.ql(paramFinderItem.isLongVideo());
        localObject1 = v.d.zYG;
        v.d.qy(paramFinderItem.isLongVideo());
        if (paramFinderItem.isLongVideo())
        {
          localObject1 = v.d.zYG;
          v.d.dQg();
        }
        localObject1 = EventCenter.instance;
        localObject2 = new hr();
        ((hr)localObject2).fEI.localId = paramFinderItem.getLocalId();
        ((hr)localObject2).fEI.progress = paramFinderItem.getPostInfo().TAi;
        ((EventCenter)localObject1).publish((IEvent)localObject2);
        AppMethodBeat.o(167758);
        return;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.s(paramFinderItem);
      }
      paramFinderItem = (FinderItem)localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "lastProcessId", "", "getLastProcessId", "()I", "setLastProcessId", "(I)V", "shouldScrollToPostingItem", "", "getShouldScrollToPostingItem", "()Z", "setShouldScrollToPostingItem", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(g paramg, q paramq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(g paramg, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<h>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(g paramg, q paramq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.loader.g.f<n>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.g
 * JD-Core Version:    0.7.0.1
 */