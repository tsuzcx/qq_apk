package com.tencent.mm.plugin.finder.upload;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.report.ah.d;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "Lcom/tencent/mm/plugin/finder/publish/IFinderPostManager;", "()V", "TAG", "", "draftListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostDraftListener;", "finderPostPipeline", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderPostPipeline;", "listeners", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "mediaProcessQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "mvMediaProcessQueue", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "mvUploadQueue", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "postCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "uploadCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1;", "uploadImageQueue", "Lcom/tencent/mm/loader/loader/IWorkTask;", "uploadQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "addDraftListener", "", "listener", "addPostEndListener", "checkNextPost", "checkToStart", "doMvProcess", "processTask", "callback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "doMvUpload", "uploadTask", "doPost", "", "data", "Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "draftObjectId", "clientId", "waitType", "", "doPostMv", "musicData", "", "doProcess", "doUpload", "generateFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mediaType", "description", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "isLongVideo", "isNewsFeed", "jumpInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "notifyDraftEventPost", "localId", "isOk", "notifyDraftPostError", "notifyDraftPostOk", "svrId", "notifyDraftStartPost", "notifyEventPost", "notifyPostError", "notifyPostOk", "notifyStartPost", "onStart", "onStop", "rePost", "feed", "rePostDraft", "draft", "removeDraftListener", "removePostEndListener", "resizeOfShort", "Lkotlin/Pair;", "originWidth", "originHeight", "max", "uploadActivityCover", "path", "uploadCoverImage", "userName", "uploadLiveCoverImage", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements com.tencent.mm.plugin.finder.publish.b
{
  public static final g.a GbJ;
  private static final g GbT;
  private static int GbU;
  public com.tencent.mm.loader.f.d<n> GbK;
  private com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> GbL;
  com.tencent.mm.loader.f.d<c> GbM;
  com.tencent.mm.loader.f.d<Object> GbN;
  com.tencent.mm.loader.f.d<s> GbO;
  private final com.tencent.mm.plugin.finder.upload.postlogic.d GbP;
  public final g.j GbQ;
  public final g.m GbR;
  private final HashSet<q> GbS;
  public final String TAG;
  private final HashSet<r> listeners;
  public com.tencent.mm.loader.f.d<h> nry;
  
  static
  {
    AppMethodBeat.i(167765);
    GbJ = new g.a((byte)0);
    GbT = new g();
    AppMethodBeat.o(167765);
  }
  
  public g()
  {
    AppMethodBeat.i(167764);
    this.nry = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "finderPost"));
    this.GbK = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "finderUpload"));
    this.GbL = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "finderUploadImage"));
    this.GbM = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "finderMediaProcess"));
    this.GbN = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "mv_finderMediaProcess"));
    this.GbO = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "mv_finderUpload"));
    this.GbP = new com.tencent.mm.plugin.finder.upload.postlogic.d();
    this.TAG = "Finder.LogPost.FinderPostManager";
    this.GbQ = new g.j(this);
    this.GbR = new g.m();
    this.listeners = new HashSet();
    this.GbS = new HashSet();
    AppMethodBeat.o(167764);
  }
  
  public final void E(String paramString, Object paramObject)
  {
    AppMethodBeat.i(343149);
    kotlin.g.b.s.u(paramString, "path");
    kotlin.g.b.s.u(paramObject, "callback");
    this.GbL.a((com.tencent.mm.loader.f.c)new k(paramString), (e)paramObject);
    AppMethodBeat.o(343149);
  }
  
  public final FinderItem a(int paramInt1, String paramString1, djh paramdjh, boi paramboi, axa paramaxa, int paramInt2, brq parambrq, boolean paramBoolean1, String paramString2, ArrayList<djg> paramArrayList, boolean paramBoolean2, boolean paramBoolean3, LinkedList<FinderJumpInfo> paramLinkedList, brg parambrg)
  {
    AppMethodBeat.i(343104);
    kotlin.g.b.s.u(paramString1, "description");
    kotlin.g.b.s.u(paramString2, "videoPathBeforeCut");
    kotlin.g.b.s.u(paramLinkedList, "jumpInfoList");
    FinderItem localFinderItem = new FinderItem();
    Object localObject1 = localFinderItem.field_reportObject;
    if (localObject1 != null)
    {
      ((FinderFeedReportObject)localObject1).sendOrExitButtonTime = cn.bDw();
      ((FinderFeedReportObject)localObject1).videoPostType = paramInt1;
      ((FinderFeedReportObject)localObject1).beforeCutMediaPath = paramString2;
      ((FinderFeedReportObject)localObject1).postStage = 1;
      paramString2 = kotlin.ah.aiuX;
      paramString2 = kotlin.ah.aiuX;
    }
    paramString2 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = com.tencent.mm.plugin.finder.api.d.a.auT(z.bAW());
    FinderObject localFinderObject = new FinderObject();
    Object localObject2 = new FinderObjectDesc();
    ((FinderObjectDesc)localObject2).event = parambrg;
    long l;
    if (paramBoolean3)
    {
      i = 1;
      localFinderObject.objectType = i;
      if (parambrq != null) {
        break label246;
      }
      l = 0L;
      label148:
      localFinderObject.refObjectId = l;
      if (parambrq != null) {
        break label256;
      }
      l = 0L;
      label163:
      localFinderObject.refObjectFlag = l;
      if (parambrq != null) {
        break label266;
      }
    }
    label256:
    label266:
    for (paramString2 = null;; paramString2 = parambrq.refObjectContact)
    {
      localFinderObject.refObjectContact = paramString2;
      localFinderObject.id = 0L;
      localFinderObject.username = z.bAW();
      paramString2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZS, "");
      if (paramString2 != null) {
        break label276;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(343104);
      throw paramString1;
      i = 0;
      break;
      label246:
      l = parambrq.refObjectId;
      break label148;
      l = parambrq.refObjectFlag;
      break label163;
    }
    label276:
    localFinderObject.nickname = ((String)paramString2);
    localFinderObject.objectDesc = ((FinderObjectDesc)localObject2);
    paramString2 = av.GiL;
    localFinderObject.createtime = av.qH(cn.bDu());
    if (localObject1 == null) {
      paramString2 = null;
    }
    while (paramString2 == null)
    {
      parambrg = new FinderContact();
      parambrg.username = z.bAW();
      paramString2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZS, "");
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(343104);
        throw paramString1;
        paramString2 = com.tencent.mm.plugin.finder.api.c.a((m)localObject1);
      }
      else
      {
        parambrg.nickname = ((String)paramString2);
        paramString2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZU, "");
        if (paramString2 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(343104);
          throw paramString1;
        }
        parambrg.headUrl = ((String)paramString2);
        if (localObject1 == null) {
          paramString2 = "";
        }
        for (;;)
        {
          parambrg.signature = paramString2;
          paramString2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adab, "");
          if (paramString2 != null) {
            break;
          }
          paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(343104);
          throw paramString1;
          localObject1 = ((m)localObject1).field_signature;
          paramString2 = (String)localObject1;
          if (localObject1 == null) {
            paramString2 = "";
          }
        }
        parambrg.coverImgUrl = ((String)paramString2);
        paramString2 = kotlin.ah.aiuX;
        paramString2 = parambrg;
      }
    }
    Object localObject3;
    for (;;)
    {
      localFinderObject.contact = paramString2;
      localFinderObject.mentionedUserContact = new LinkedList();
      paramString2 = localFinderObject.contact;
      if (paramString2 != null)
      {
        paramString2.one_time_flag |= 0x1;
        paramString2 = kotlin.ah.aiuX;
        paramString2 = kotlin.ah.aiuX;
      }
      paramString2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((!com.tencent.mm.plugin.finder.storage.d.eRt()) || (paramArrayList == null)) {
        break label697;
      }
      paramString2 = paramArrayList.iterator();
      while (paramString2.hasNext())
      {
        parambrg = (djg)paramString2.next();
        localObject1 = localFinderObject.mentionedUserContact;
        localObject3 = com.tencent.mm.plugin.finder.utils.h.Gga;
        kotlin.g.b.s.s(parambrg, "atContact");
        ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.utils.h.b(parambrg));
      }
    }
    paramString2 = kotlin.ah.aiuX;
    paramString2 = kotlin.ah.aiuX;
    label697:
    paramString2 = aw.Gjk;
    if (aw.eKm()) {
      localFinderObject.permissionFlag = 131;
    }
    localObject1 = new bso();
    label755:
    Object localObject4;
    if (paramdjh == null)
    {
      paramString2 = null;
      ((FinderObjectDesc)localObject2).imgFeedBgmInfo = paramString2;
      localObject3 = new bqz();
      if (paramdjh != null) {
        break label1582;
      }
      paramString2 = null;
      ((bqz)localObject3).musicInfo = paramString2;
      if (paramdjh != null) {
        break label1591;
      }
      paramString2 = null;
      label769:
      parambrg = paramString2;
      if (paramString2 == null)
      {
        paramString2 = ((bqz)localObject3).musicInfo;
        if (paramString2 != null) {
          break label1600;
        }
        parambrg = null;
      }
      label793:
      ((bqz)localObject3).groupId = parambrg;
      if ((paramdjh == null) || (paramdjh.GZQ)) {
        break label1610;
      }
      i = 1;
      label814:
      if (i == 0)
      {
        if ((paramdjh == null) || (paramdjh.GZR)) {
          break label1616;
        }
        i = 1;
        label833:
        if (i == 0) {
          break label1622;
        }
      }
      i = 1;
      label841:
      ((bqz)localObject3).ZZa = i;
      parambrg = this.TAG;
      localObject4 = new StringBuilder("FinderObjectBGMInfo, groupId:").append(((bqz)localObject3).groupId).append(", mediaMute:");
      if (paramdjh != null) {
        break label1628;
      }
      paramString2 = null;
      label887:
      localObject4 = ((StringBuilder)localObject4).append(paramString2).append(", musicMute:");
      if (paramdjh != null) {
        break label1640;
      }
      paramString2 = null;
      label909:
      Log.d(parambrg, paramString2 + ", hasBgm:" + ((bqz)localObject3).ZZa);
      paramString2 = (CharSequence)((bqz)localObject3).groupId;
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label1652;
      }
      i = 1;
      label966:
      if ((i == 0) && (((bqz)localObject3).musicInfo == null))
      {
        parambrg = new bqj();
        if (paramdjh != null) {
          break label1658;
        }
        paramString2 = null;
        label995:
        paramString2 = (CharSequence)paramString2;
        if ((paramString2 != null) && (paramString2.length() != 0)) {
          break label1667;
        }
        i = 1;
        label1020:
        if (i == 0) {
          break label1682;
        }
        if (paramdjh != null) {
          break label1673;
        }
        paramString2 = null;
        paramString2 = com.tencent.mm.b.q.n(paramString2, true);
        parambrg.ZYp = paramString2;
        paramString2 = kotlin.ah.aiuX;
        ((bqz)localObject3).musicInfo = parambrg;
      }
      label1032:
      label1040:
      paramString2 = kotlin.ah.aiuX;
      ((FinderObjectDesc)localObject2).feedBgmInfo = ((bqz)localObject3);
      if (paramdjh == null) {
        break label1893;
      }
      paramString2 = paramdjh.mediaList;
      if (paramString2 == null) {
        break label1893;
      }
      localObject3 = ((Iterable)paramString2).iterator();
      i = 0;
    }
    label1101:
    int j;
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label1888;
      }
      paramString2 = ((Iterator)localObject3).next();
      j = i + 1;
      if (i < 0) {
        p.kkW();
      }
      localObject4 = (dji)paramString2;
      Object localObject5 = new FinderMedia();
      ((FinderMedia)localObject5).url = ((dji)localObject4).url;
      ((FinderMedia)localObject5).mediaType = ((dji)localObject4).mediaType;
      ((FinderMedia)localObject5).thumbUrl = ((dji)localObject4).thumbUrl;
      ((FinderMedia)localObject5).full_thumb_url = ((dji)localObject4).aaPi;
      if ((!((dji)localObject4).aaPf) && (((dji)localObject4).videoDuration <= 0))
      {
        paramString2 = com.tencent.mm.plugin.sight.base.f.aVX(((dji)localObject4).url);
        if (paramString2 != null)
        {
          ((dji)localObject4).videoDuration = paramString2.getVideoDuration();
          paramString2 = kotlin.ah.aiuX;
          paramString2 = kotlin.ah.aiuX;
        }
      }
      ((FinderMedia)localObject5).videoDuration = ((dji)localObject4).videoDuration;
      ((FinderMedia)localObject5).width = ((dji)localObject4).width;
      ((FinderMedia)localObject5).height = ((dji)localObject4).height;
      ((FinderMedia)localObject5).md5sum = ((dji)localObject4).md5sum;
      ((FinderMedia)localObject5).coverUrl = ((dji)localObject4).coverUrl;
      ((FinderObjectDesc)localObject2).media.add(localObject5);
      if ((i == 0) && (!Util.isNullOrNil(((dji)localObject4).url)) && ((((dji)localObject4).mediaType == 2) || (((dji)localObject4).mediaType == 4)))
      {
        if (((dji)localObject4).mediaType != 2) {
          break label1701;
        }
        paramString2 = av.GiL;
        parambrg = ((dji)localObject4).url;
        paramString2 = parambrg;
        if (parambrg == null) {
          paramString2 = "";
        }
      }
      for (paramString2 = av.aBJ(paramString2);; paramString2 = av.aBK(((dji)localObject4).url))
      {
        if (paramString2 != null)
        {
          ((bso)localObject1).aaat = ((float)((Number)paramString2.bsC).doubleValue());
          ((bso)localObject1).aaas = ((float)((Number)paramString2.bsD).doubleValue());
          paramString2 = kotlin.ah.aiuX;
          paramString2 = kotlin.ah.aiuX;
        }
        if (((FinderMedia)localObject5).mediaType != 2) {
          break label1719;
        }
        paramString2 = this.TAG;
        parambrg = new StringBuilder("print mediaList ").append(i).append(' ').append(((dji)localObject4).url).append(" size:").append(Util.getSizeKB(y.bEl(((dji)localObject4).url))).append(" option ");
        localObject4 = BitmapUtil.getImageOptions(((dji)localObject4).url);
        Log.i(paramString2, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject4).outWidth).append(" * ").append(((BitmapFactory.Options)localObject4).outHeight).append(']').toString() + '}');
        i = j;
        break label1101;
        paramString2 = paramdjh.aaOZ;
        break;
        label1582:
        paramString2 = paramdjh.aaOZ;
        break label755;
        label1591:
        paramString2 = paramdjh.FSW;
        break label769;
        label1600:
        parambrg = paramString2.HsD;
        break label793;
        label1610:
        i = 0;
        break label814;
        label1616:
        i = 0;
        break label833;
        label1622:
        i = 0;
        break label841;
        label1628:
        paramString2 = Boolean.valueOf(paramdjh.GZQ);
        break label887;
        label1640:
        paramString2 = Boolean.valueOf(paramdjh.GZR);
        break label909;
        label1652:
        i = 0;
        break label966;
        label1658:
        paramString2 = paramdjh.aaPa;
        break label995;
        label1667:
        i = 0;
        break label1020;
        label1673:
        paramString2 = paramdjh.FSU;
        break label1032;
        label1682:
        if (paramdjh == null)
        {
          paramString2 = null;
          break label1040;
        }
        paramString2 = paramdjh.aaPa;
        break label1040;
        label1701:
        paramString2 = av.GiL;
      }
      label1719:
      if (((FinderMedia)localObject5).mediaType == 4)
      {
        paramString2 = this.TAG;
        parambrg = new StringBuilder("print mediaList ").append(i).append(' ').append(((dji)localObject4).url).append(" size:").append(Util.getSizeKB(y.bEl(((dji)localObject4).url))).append(" option ");
        localObject5 = com.tencent.mm.plugin.gallery.b.g.HRf;
        Log.i(paramString2, com.tencent.mm.plugin.gallery.b.g.aBH(((dji)localObject4).url));
        i = j;
      }
      else
      {
        Log.i(this.TAG, "print mediaList " + i + ' ' + ((dji)localObject4).url + " size:" + Util.getSizeKB(y.bEl(((dji)localObject4).url)));
        i = j;
      }
    }
    label1888:
    paramString2 = kotlin.ah.aiuX;
    label1893:
    paramString2 = com.tencent.mm.ui.component.k.aeZF;
    paramString2 = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    ((bso)localObject1).longitude = ((Number)paramString2.bsC).floatValue();
    ((bso)localObject1).latitude = ((Number)paramString2.bsD).floatValue();
    paramString2 = kotlin.ah.aiuX;
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      ((bso)localObject1).aaau = i;
      localFinderItem.field_postExtraData = ((bso)localObject1);
      localFinderObject.displayidDiscarded = "";
      localFinderObject.recommendReason = "";
      localFinderObject.secondaryShowFlag = 1;
      localFinderObject.originalFlag = paramInt2;
      paramString2 = com.tencent.mm.plugin.finder.upload.postlogic.a.GdF;
      com.tencent.mm.plugin.finder.upload.postlogic.a.a(paramLinkedList, localFinderObject);
      ((FinderObjectDesc)localObject2).description = paramString1;
      ((FinderObjectDesc)localObject2).mediaType = paramInt1;
      ((FinderObjectDesc)localObject2).location = paramboi;
      ((FinderObjectDesc)localObject2).extReading = paramaxa;
      parambrg = new HashMap();
      paramboi = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((!com.tencent.mm.plugin.finder.storage.d.eRt()) || (paramArrayList == null)) {
        break label2216;
      }
      localObject1 = new LinkedList();
      localObject3 = paramArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (djg)((Iterator)localObject3).next();
        paramboi = new bpj();
        paramboi.username = ((djg)localObject4).username;
        paramboi.source = ((djg)localObject4).type;
        paramboi.nickname = ((djg)localObject4).nickname;
        ((LinkedList)localObject1).add(paramboi);
        paramString2 = ((djg)localObject4).nickname;
        paramboi = paramString2;
        if (paramString2 == null) {
          paramboi = "";
        }
        parambrg.put(paramboi, localObject4);
        paramboi = kotlin.ah.aiuX;
      }
    }
    ((FinderObjectDesc)localObject2).mentionedUser = ((LinkedList)localObject1);
    paramboi = kotlin.ah.aiuX;
    paramboi = kotlin.ah.aiuX;
    label2216:
    paramboi = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eRs())
    {
      paramboi = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRt()) {}
    }
    else
    {
      paramboi = new bxs();
      paramString2 = ao.GhZ;
      paramboi.aagD = ao.d(paramString1, parambrg);
      paramString1 = kotlin.ah.aiuX;
      ((FinderObjectDesc)localObject2).topic = paramboi;
    }
    paramString1 = localFinderItem.field_reportObject;
    label2316:
    float f;
    if (paramString1 != null)
    {
      paramboi = ((FinderObjectDesc)localObject2).description;
      if (paramboi != null) {
        break label2651;
      }
      paramInt1 = 0;
      paramString1.descCount = paramInt1;
      if (localFinderItem.field_reportObject.descCount <= 0) {
        break label2660;
      }
      paramInt1 = 1;
      paramString1.existDesc = paramInt1;
      paramboi = ((FinderObjectDesc)localObject2).location;
      if (paramboi != null) {
        break label2665;
      }
      f = 0.0F;
      label2336:
      if (f <= 0.0F) {
        break label2685;
      }
      paramboi = ((FinderObjectDesc)localObject2).location;
      if (paramboi != null) {
        break label2675;
      }
      f = 0.0F;
      label2358:
      if (f <= 0.0F) {
        break label2685;
      }
    }
    label2651:
    label2660:
    label2665:
    label2675:
    label2685:
    for (paramString1.existLocation = 1;; paramString1.existLocation = 0)
    {
      paramString1.link = paramaxa.link;
      paramString1 = kotlin.ah.aiuX;
      paramString1 = kotlin.ah.aiuX;
      paramString1 = kotlin.ah.aiuX;
      paramString1 = kotlin.ah.aiuX;
      paramString1 = kotlin.ah.aiuX;
      if (!paramBoolean2) {
        break label2831;
      }
      paramaxa = new dnh();
      paramaxa.description = ((FinderObjectDesc)localObject2).description;
      paramString1 = ((FinderObjectDesc)localObject2).media;
      if (paramString1 == null) {
        break label2697;
      }
      paramString2 = ((Iterable)paramString1).iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (FinderMedia)paramString2.next();
        parambrg = new dnv();
        parambrg.url = ((FinderMedia)localObject1).url;
        paramString1 = f.GbE;
        paramboi = parambrg.url;
        paramString1 = paramboi;
        if (paramboi == null) {
          paramString1 = "";
        }
        parambrg.thumbUrl = f.aBj(paramString1);
        parambrg.mediaType = 0;
        localObject2 = MultiMediaVideoChecker.ObB;
        paramboi = parambrg.url;
        paramString1 = paramboi;
        if (paramboi == null) {
          paramString1 = "";
        }
        paramString1 = ((MultiMediaVideoChecker)localObject2).aTG(paramString1);
        if (paramString1 != null)
        {
          parambrg.width = paramString1.width;
          parambrg.height = paramString1.height;
          parambrg.aaUX = kotlin.h.a.eH((float)paramString1.duration / 1000.0F);
          paramString1 = kotlin.ah.aiuX;
          paramString1 = kotlin.ah.aiuX;
        }
        parambrg.md5sum = ((FinderMedia)localObject1).md5sum;
        parambrg.fileSize = ((FinderMedia)localObject1).fileSize;
        parambrg.bitrate = ((FinderMedia)localObject1).bitrate;
        paramString1 = kotlin.ah.aiuX;
        paramaxa.media.add(parambrg);
      }
      paramInt1 = paramboi.length();
      break;
      paramInt1 = 0;
      break label2316;
      f = paramboi.latitude;
      break label2336;
      f = paramboi.longitude;
      break label2358;
    }
    paramString1 = kotlin.ah.aiuX;
    label2697:
    paramboi = new dne();
    paramboi.id = 0L;
    paramboi.createTime = localFinderObject.createtime;
    paramboi.aaUt = paramaxa;
    paramString1 = kotlin.ah.aiuX;
    paramString1 = new atr();
    paramString1.ZEi = new LinkedList();
    paramaxa = paramString1.ZEi;
    paramString2 = new atq();
    paramString2.type = 1;
    parambrg = new byx();
    parambrg.id = 0L;
    parambrg.ZXx = paramboi;
    paramboi = kotlin.ah.aiuX;
    paramString2.ZEf = parambrg;
    paramboi = kotlin.ah.aiuX;
    paramaxa.add(paramString2);
    paramboi = kotlin.ah.aiuX;
    localFinderObject.attachmentList = paramString1;
    label2831:
    paramString1 = com.tencent.mm.plugin.finder.upload.postlogic.a.GdF;
    com.tencent.mm.plugin.finder.upload.postlogic.a.a(localFinderObject, paramLinkedList);
    Log.i(this.TAG, kotlin.g.b.s.X("finder send post ", com.tencent.mm.ae.f.dg(localFinderObject)));
    localFinderItem.updateFinderObject(localFinderObject);
    paramString1 = com.tencent.mm.plugin.finder.storage.ah.FMh;
    paramString1 = com.tencent.mm.plugin.finder.storage.ah.eZB();
    paramString1.aaPx = cn.bDu();
    if (paramArrayList != null)
    {
      paramString1.aaPA.clear();
      paramString1.aaPA.addAll((Collection)paramArrayList);
      paramboi = kotlin.ah.aiuX;
      paramboi = kotlin.ah.aiuX;
    }
    paramboi = kotlin.ah.aiuX;
    localFinderItem.setPostInfo(paramString1);
    if (paramdjh == null)
    {
      paramString1 = null;
      paramdjh = paramString1;
      if (paramString1 == null) {
        paramdjh = new LinkedList();
      }
      localFinderItem.setMediaExtList(paramdjh);
      paramString1 = localFinderObject.attachmentList;
      if (paramString1 != null) {
        break label3567;
      }
      paramString1 = null;
      label2966:
      paramdjh = paramString1;
      if (paramString1 == null) {
        paramdjh = new LinkedList();
      }
      localFinderItem.setLongVideoMediaExtList(paramdjh);
      paramboi = ((Iterable)localFinderItem.getLongVideoMediaExtList()).iterator();
      label3001:
      if (!paramboi.hasNext()) {
        break label4130;
      }
      paramaxa = (dji)paramboi.next();
      paramaxa.mediaId = kotlin.g.b.s.X("longvideo_", paramaxa.mediaId);
      paramaxa.aaPf = true;
      paramString2 = new dju();
      paramString1 = com.tencent.mm.plugin.finder.ui.config.a.FWH;
      paramArrayList = com.tencent.mm.plugin.finder.ui.config.a.fcM();
      paramInt1 = (int)paramaxa.width;
      paramInt2 = (int)paramaxa.height;
      switch (SightVideoJNI.getMp4RotateVFS(paramaxa.url))
      {
      default: 
        label3112:
        i = MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels;
        f = paramInt1 / paramInt2;
        if (f <= 1.777778F) {
          if (0.5625F <= f)
          {
            i = 1;
            label3155:
            if (i == 0) {
              break label3747;
            }
            paramString1 = new fyb();
            paramString1.left = 0;
            paramString1.top = paramInt2;
            paramString1.right = paramInt1;
            paramString1.bottom = 0;
            paramdjh = kotlin.ah.aiuX;
            paramString2.aaPJ = paramString1;
            paramString2.aaPL = paramString1;
            paramdjh = p.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
            paramString1 = new byz();
            paramString1.aaib.addAll((Collection)p.p((Iterable)paramdjh));
            paramdjh = kotlin.ah.aiuX;
            paramString2.aaPK = paramString1;
            i = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i;
            label3326:
            paramString2.startTime = 0;
            paramLinkedList = MultiMediaVideoChecker.ObB;
            paramdjh = paramaxa.url;
            paramString1 = paramdjh;
            if (paramdjh == null) {
              paramString1 = "";
            }
            paramString1 = paramLinkedList.aTG(paramString1);
            if (paramString1 != null)
            {
              paramString2.endTime = Math.min(paramArrayList.duration * 1000, (int)paramString1.duration);
              paramString1 = kotlin.ah.aiuX;
              paramString1 = kotlin.ah.aiuX;
            }
            j = Math.min(paramArrayList.width, paramArrayList.height);
            if (paramInt2 >= paramInt1) {
              break label4053;
            }
            if (paramInt2 % 16 == 0) {
              break label4201;
            }
          }
        }
        break;
      }
    }
    label3653:
    label4053:
    label4201:
    for (i = paramInt2 - paramInt2 % 16;; i = paramInt2)
    {
      if (paramInt2 > j) {
        paramInt1 = (int)(paramInt1 * (j / paramInt2));
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 % 16 != 0) {
          paramInt2 = paramInt1 - paramInt1 % 16;
        }
        paramString1 = new kotlin.r(Integer.valueOf(j), Integer.valueOf(paramInt2));
        paramInt1 = ((Number)paramString1.bsC).intValue();
        paramInt2 = ((Number)paramString1.bsD).intValue();
        paramString2.width = paramInt1;
        paramString2.height = paramInt2;
        paramaxa.width = paramInt1;
        paramaxa.height = paramInt2;
        paramString2.retryCount = 0;
        paramString1 = kotlin.ah.aiuX;
        paramaxa.EDC = paramString2;
        break label3001;
        paramString1 = paramdjh.mediaList;
        break;
        label3567:
        paramString1 = paramString1.ZEi;
        if (paramString1 == null)
        {
          paramString1 = null;
          break label2966;
        }
        paramdjh = ((Iterable)paramString1).iterator();
        do
        {
          if (!paramdjh.hasNext()) {
            break;
          }
          paramString1 = paramdjh.next();
          paramboi = (atq)paramString1;
          paramaxa = av.GiL;
          kotlin.g.b.s.s(paramboi, "it");
        } while (!av.a(paramboi));
        for (;;)
        {
          paramString1 = (atq)paramString1;
          if (paramString1 != null) {
            break label3653;
          }
          paramString1 = null;
          break;
          paramString1 = null;
        }
        paramString1 = paramString1.ZEf;
        if (paramString1 == null)
        {
          paramString1 = null;
          break label2966;
        }
        paramString1 = paramString1.ZXx;
        if (paramString1 == null)
        {
          paramString1 = null;
          break label2966;
        }
        paramString1 = paramString1.aaUt;
        if (paramString1 == null)
        {
          paramString1 = null;
          break label2966;
        }
        paramString1 = paramString1.media;
        if (paramString1 == null)
        {
          paramString1 = null;
          break label2966;
        }
        paramString1 = com.tencent.mm.plugin.finder.storage.data.i.aZ(paramString1);
        break label2966;
        paramInt1 = (int)paramaxa.height;
        paramInt2 = (int)paramaxa.width;
        break label3112;
        i = 0;
        break label3155;
        i = 0;
        break label3155;
        if (f > 1.777778F)
        {
          i = (int)(paramInt2 * 16.0F / 9.0F);
          paramdjh = new fyb();
          paramdjh.left = ((paramInt1 - i) / 2);
          paramdjh.top = paramInt2;
          paramdjh.right = (paramInt1 - paramdjh.left);
          paramdjh.bottom = 0;
          paramString1 = kotlin.ah.aiuX;
          paramString2.aaPJ = paramdjh;
          paramString2.aaPL = paramdjh;
          paramString1 = new Matrix();
          paramString1.postTranslate(-paramdjh.left, 0.0F);
          paramdjh = new byz();
          paramLinkedList = new float[9];
          paramString1.getValues(paramLinkedList);
          paramdjh.aaib.addAll((Collection)kotlin.a.k.D(paramLinkedList));
          paramString1 = kotlin.ah.aiuX;
          paramString2.aaPK = paramdjh;
          paramInt1 = paramInt2;
          paramInt2 = i;
          break label3326;
        }
        i = (int)(paramInt1 * 16.0F / 9.0F);
        paramdjh = new fyb();
        paramdjh.left = 0;
        paramdjh.bottom = ((paramInt2 - i) / 2);
        paramdjh.right = paramInt1;
        paramdjh.top = (paramInt2 - paramdjh.bottom);
        paramString1 = kotlin.ah.aiuX;
        paramString2.aaPJ = paramdjh;
        paramString2.aaPL = paramdjh;
        paramString1 = new Matrix();
        paramString1.postTranslate(0.0F, -paramdjh.bottom);
        paramdjh = new byz();
        paramLinkedList = new float[9];
        paramString1.getValues(paramLinkedList);
        paramdjh.aaib.addAll((Collection)kotlin.a.k.D(paramLinkedList));
        paramString1 = kotlin.ah.aiuX;
        paramString2.aaPK = paramdjh;
        paramInt2 = i;
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
        break label3326;
        if (paramInt1 % 16 != 0) {}
        for (i = paramInt1 - paramInt1 % 16;; i = paramInt1)
        {
          if (i > j)
          {
            f = paramInt2;
            paramInt1 = (int)(j / paramInt1 * f);
          }
          for (;;)
          {
            paramInt2 = paramInt1;
            if (paramInt1 % 16 != 0) {
              paramInt2 = paramInt1 - paramInt1 % 16;
            }
            paramString1 = new kotlin.r(Integer.valueOf(paramInt2), Integer.valueOf(j));
            break;
            if (parambrq != null)
            {
              paramString1 = localFinderItem.getPostInfo();
              paramString1.aaPu = 1;
              paramdjh = kotlin.ah.aiuX;
              localFinderItem.setPostInfo(paramString1);
            }
            localFinderItem.setPostWaiting();
            localFinderItem.setLocalId(System.currentTimeMillis());
            AppMethodBeat.o(343104);
            return localFinderItem;
            paramInt1 = paramInt2;
            j = i;
          }
        }
        j = i;
      }
    }
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(343168);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramq, this));
    AppMethodBeat.o(343168);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(167760);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramr, this));
    AppMethodBeat.o(167760);
  }
  
  public final void ay(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(343190);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramLong1, paramLong2));
    AppMethodBeat.o(343190);
  }
  
  public final void az(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(343204);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramLong1, paramLong2));
    AppMethodBeat.o(343204);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(343174);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k(paramq, this));
    AppMethodBeat.o(343174);
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(167761);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new l(paramr, this));
    AppMethodBeat.o(167761);
  }
  
  public final void eKX()
  {
    AppMethodBeat.i(167759);
    this.GbP.c(null);
    AppMethodBeat.o(167759);
  }
  
  public final void eKY()
  {
    AppMethodBeat.i(343018);
    int i = Process.myPid();
    if (GbU != i)
    {
      GbT.eKX();
      GbU = i;
    }
    AppMethodBeat.o(343018);
  }
  
  public final void fy(Object paramObject)
  {
    AppMethodBeat.i(343120);
    kotlin.g.b.s.u(paramObject, "feed");
    if (!(paramObject instanceof FinderItem))
    {
      AppMethodBeat.o(343120);
      return;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("Finder.PostLog repost ", Long.valueOf(((FinderItem)paramObject).getLocalId())));
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(((FinderItem)paramObject).getLocalId());
    if (localObject1 == null) {}
    Object localObject2;
    for (paramObject = (FinderItem)paramObject;; paramObject = localObject1)
    {
      localObject1 = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      localObject1 = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(com.tencent.mm.plugin.finder.report.postreport.b.eOd(), paramObject);
      paramObject.setPostWaiting();
      localObject1 = paramObject.getPostInfo();
      ((djj)localObject1).nrQ = 0;
      ((djj)localObject1).aaPw = 0;
      if (((djj)localObject1).aaPu == 2) {
        ((djj)localObject1).aaPu = 0;
      }
      localObject1 = ((Iterable)paramObject.getMediaList()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((dji)((Iterator)localObject1).next()).EDC;
        if (localObject2 != null) {
          ((dju)localObject2).retryCount = 0;
        }
      }
    }
    localObject1 = ((Iterable)paramObject.getLongVideoMediaExtList()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((dji)((Iterator)localObject1).next()).EDC;
      if (localObject2 != null) {
        ((dju)localObject2).retryCount = 0;
      }
    }
    localObject1 = paramObject.field_reportObject;
    if (localObject1 != null)
    {
      ((FinderFeedReportObject)localObject1).clickRepostCount += 1;
      localObject2 = i.Gcb;
      i.a((FinderFeedReportObject)localObject1, "clickRepost");
    }
    if (paramObject.isMvFeed())
    {
      localObject1 = ((Iterable)paramObject.getClipListExt()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterable)((FinderItem)((Iterator)localObject1).next()).getMediaList()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          dju localdju = ((dji)((Iterator)localObject2).next()).EDC;
          if (localdju != null) {
            localdju.retryCount = 0;
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      com.tencent.mm.plugin.finder.storage.logic.d.a.u(paramObject);
    }
    for (;;)
    {
      eKX();
      localObject1 = ah.d.Ftw;
      ah.d.tB(paramObject.isLongVideo());
      localObject1 = ah.d.Ftw;
      ah.d.tK(paramObject.isLongVideo());
      if (paramObject.isLongVideo())
      {
        localObject1 = ah.d.Ftw;
        ah.d.eMs();
      }
      localObject1 = new ic();
      ((ic)localObject1).hJy.localId = paramObject.getLocalId();
      ((ic)localObject1).hJy.progress = paramObject.getPostInfo().aaPw;
      ((ic)localObject1).publish();
      AppMethodBeat.o(343120);
      return;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      com.tencent.mm.plugin.finder.storage.logic.d.a.v(paramObject);
    }
  }
  
  public final void fz(Object paramObject)
  {
    AppMethodBeat.i(343136);
    kotlin.g.b.s.u(paramObject, "draft");
    if (!(paramObject instanceof com.tencent.mm.plugin.finder.storage.i))
    {
      AppMethodBeat.o(343136);
      return;
    }
    Log.i(this.TAG, "Finder.PostLog repost draft " + ((com.tencent.mm.plugin.finder.storage.i)paramObject).field_localId + ", " + ((com.tencent.mm.plugin.finder.storage.i)paramObject).field_objectId);
    com.tencent.mm.plugin.finder.storage.i locali = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getDraftStorage().qm(((com.tencent.mm.plugin.finder.storage.i)paramObject).field_localId);
    if (locali == null)
    {
      Log.e(this.TAG, kotlin.g.b.s.X("repost draftItem empty, ", ((com.tencent.mm.plugin.finder.storage.i)paramObject).eYN()));
      AppMethodBeat.o(343136);
      return;
    }
    locali.field_localFlag = 1;
    paramObject = locali.eYK();
    Object localObject1 = paramObject.getPostInfo();
    ((djj)localObject1).nrQ = 0;
    ((djj)localObject1).aaPw = 0;
    if (((djj)localObject1).aaPu == 2) {
      ((djj)localObject1).aaPu = 0;
    }
    localObject1 = ((Iterable)paramObject.getMediaList()).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((dji)((Iterator)localObject1).next()).EDC;
      if (localObject2 != null) {
        ((dju)localObject2).retryCount = 0;
      }
    }
    localObject1 = ((Iterable)paramObject.getLongVideoMediaExtList()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((dji)((Iterator)localObject1).next()).EDC;
      if (localObject2 != null) {
        ((dju)localObject2).retryCount = 0;
      }
    }
    localObject1 = paramObject.field_reportObject;
    if (localObject1 != null)
    {
      ((FinderFeedReportObject)localObject1).clickRepostCount += 1;
      localObject2 = i.Gcb;
      i.a((FinderFeedReportObject)localObject1, "clickRepost");
    }
    if (paramObject.isMvFeed())
    {
      paramObject = ((Iterable)paramObject.getClipListExt()).iterator();
      while (paramObject.hasNext())
      {
        localObject1 = ((Iterable)((FinderItem)paramObject.next()).getMediaList()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((dji)((Iterator)localObject1).next()).EDC;
          if (localObject2 != null) {
            ((dju)localObject2).retryCount = 0;
          }
        }
      }
    }
    paramObject = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(locali);
    eKX();
    paramObject = i.c.FoQ;
    i.c.tB(locali.eYK().isLongVideo());
    paramObject = i.c.FoQ;
    i.c.tK(locali.eYK().isLongVideo());
    if (locali.eYK().isLongVideo())
    {
      paramObject = i.c.FoQ;
      i.c.eMs();
    }
    paramObject = new ic();
    paramObject.hJy.localId = locali.field_localId;
    paramObject.hJy.progress = locali.eYK().getPostInfo().aaPw;
    paramObject.publish();
    AppMethodBeat.o(343136);
  }
  
  public final void g(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(343140);
    kotlin.g.b.s.u(paramString1, "path");
    kotlin.g.b.s.u(paramString2, "userName");
    kotlin.g.b.s.u(paramObject, "callback");
    this.GbL.a((com.tencent.mm.loader.f.c)new l(paramString1, paramString2), (e)paramObject);
    AppMethodBeat.o(343140);
  }
  
  public final void h(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(343145);
    kotlin.g.b.s.u(paramString1, "path");
    kotlin.g.b.s.u(paramString2, "userName");
    kotlin.g.b.s.u(paramObject, "callback");
    this.GbL.a(((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).co(paramString1, paramString2), (e)paramObject);
    AppMethodBeat.o(343145);
  }
  
  public final void qA(final long paramLong)
  {
    AppMethodBeat.i(167763);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this, paramLong));
    AppMethodBeat.o(167763);
  }
  
  public final void qB(final long paramLong)
  {
    AppMethodBeat.i(343203);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramLong));
    AppMethodBeat.o(343203);
  }
  
  public final void qy(final long paramLong)
  {
    AppMethodBeat.i(343177);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramLong));
    AppMethodBeat.o(343177);
  }
  
  public final void qz(final long paramLong)
  {
    AppMethodBeat.i(167762);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramLong));
    AppMethodBeat.o(167762);
  }
  
  public final long u(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(343039);
    kotlin.g.b.s.u(paramObject, "musicData");
    if (!(paramObject instanceof dtf))
    {
      AppMethodBeat.o(343039);
      return -1L;
    }
    FinderObject localFinderObject = ((dtf)paramObject).aaYK;
    Object localObject5 = ((dtf)paramObject).ZJp;
    Object localObject2 = ((dtf)paramObject).aaYL;
    if (localFinderObject == null) {}
    Object localObject3;
    Object localObject4;
    bso localbso;
    for (Object localObject1 = null;; localObject1 = localFinderObject.objectDesc)
    {
      localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject4 = com.tencent.mm.plugin.finder.api.d.a.auT(z.bAW());
      localbso = new bso();
      if ((localFinderObject != null) && (localObject1 != null)) {
        break;
      }
      AppMethodBeat.o(343039);
      return -1L;
    }
    ((FinderObjectDesc)localObject1).draftObjectId = paramLong;
    paramObject = ((dtf)paramObject).aaYK;
    if (paramObject != null) {
      paramObject.id = 0L;
    }
    LinkedList localLinkedList = new LinkedList();
    paramObject = (CharSequence)localObject2;
    Object localObject6;
    if ((paramObject == null) || (paramObject.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        paramObject = new FinderMedia();
        paramObject.url = ((String)localObject2);
        paramObject.thumbUrl = ((String)localObject2);
        paramObject.mediaType = 2;
        ((FinderObjectDesc)localObject1).media.add(paramObject);
        localObject6 = com.tencent.mm.plugin.finder.storage.data.i.c(paramObject);
        paramObject = ((dji)localObject6).url;
        if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
          break label702;
        }
        i = 1;
        label242:
        if (i != 0)
        {
          localObject2 = ((dji)localObject6).url;
          paramObject = localObject2;
          if (localObject2 == null) {
            paramObject = "";
          }
          localObject3 = ((dji)localObject6).url_token;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          ((dji)localObject6).aaPd = kotlin.g.b.s.X(paramObject, localObject2);
        }
        paramObject = ((dji)localObject6).thumbUrl;
        if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
          break label708;
        }
        i = 1;
        label323:
        if (i != 0)
        {
          localObject2 = ((dji)localObject6).thumbUrl;
          paramObject = localObject2;
          if (localObject2 == null) {
            paramObject = "";
          }
          localObject3 = ((dji)localObject6).thumb_url_token;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          ((dji)localObject6).aaPe = kotlin.g.b.s.X(paramObject, localObject2);
        }
        paramObject = ((dji)localObject6).full_url;
        if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
          break label714;
        }
        i = 1;
        label404:
        if (i != 0)
        {
          localObject2 = ((dji)localObject6).full_url;
          paramObject = localObject2;
          if (localObject2 == null) {
            paramObject = "";
          }
          ((dji)localObject6).aaPm = paramObject;
        }
        paramObject = ((dji)localObject6).aaPi;
        if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
          break label720;
        }
        i = 1;
        label459:
        if (i != 0)
        {
          localObject2 = ((dji)localObject6).aaPi;
          paramObject = localObject2;
          if (localObject2 == null) {
            paramObject = "";
          }
          localObject3 = ((dji)localObject6).aaPj;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          ((dji)localObject6).aaPk = kotlin.g.b.s.X(paramObject, localObject2);
        }
        paramObject = ((dji)localObject6).coverUrl;
        if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
          break label726;
        }
        i = 1;
        label540:
        if (i != 0)
        {
          localObject2 = ((dji)localObject6).coverUrl;
          paramObject = localObject2;
          if (localObject2 == null) {
            paramObject = "";
          }
          localObject3 = ((dji)localObject6).cover_url_token;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          ((dji)localObject6).aaPg = kotlin.g.b.s.X(paramObject, localObject2);
        }
        paramObject = kotlin.ah.aiuX;
        localLinkedList.add(localObject6);
      }
      localFinderObject.objectType = 2;
      paramObject = av.GiL;
      localFinderObject.createtime = av.qH(cn.bDu());
      if (localObject4 != null) {
        break label732;
      }
      paramObject = null;
    }
    for (;;)
    {
      if (paramObject == null)
      {
        localObject2 = new FinderContact();
        ((FinderContact)localObject2).username = z.bAW();
        paramObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZS, "");
        if (paramObject == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(343039);
          throw paramObject;
          i = 0;
          break;
          label702:
          i = 0;
          break label242;
          label708:
          i = 0;
          break label323;
          label714:
          i = 0;
          break label404;
          label720:
          i = 0;
          break label459;
          label726:
          i = 0;
          break label540;
          label732:
          paramObject = com.tencent.mm.plugin.finder.api.c.a((m)localObject4);
          continue;
        }
        ((FinderContact)localObject2).nickname = ((String)paramObject);
        paramObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZU, "");
        if (paramObject == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(343039);
          throw paramObject;
        }
        ((FinderContact)localObject2).headUrl = ((String)paramObject);
        if (localObject4 == null) {
          paramObject = "";
        }
        for (;;)
        {
          ((FinderContact)localObject2).signature = paramObject;
          paramObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adab, "");
          if (paramObject != null) {
            break;
          }
          paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(343039);
          throw paramObject;
          localObject3 = ((m)localObject4).field_signature;
          paramObject = localObject3;
          if (localObject3 == null) {
            paramObject = "";
          }
        }
        ((FinderContact)localObject2).coverImgUrl = ((String)paramObject);
        paramObject = kotlin.ah.aiuX;
        paramObject = localObject2;
        localFinderObject.contact = paramObject;
        paramObject = aw.Gjk;
        if (aw.eKm()) {
          localFinderObject.permissionFlag = 131;
        }
        localObject4 = new FinderItem();
        ((FinderItem)localObject4).updateFinderObject(localFinderObject);
        ((FinderItem)localObject4).field_clipList = new dje();
        kotlin.g.b.s.s(localObject5, "clipFinderObjects");
        localObject5 = ((Iterable)localObject5).iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label1694;
      }
      localObject2 = (FinderObject)((Iterator)localObject5).next();
      if (localObject2 != null)
      {
        paramObject = ((FinderObject)localObject2).objectDesc;
        label1030:
        label1047:
        label1076:
        label1133:
        djq localdjq;
        label1167:
        dji localdji;
        if (paramObject != null)
        {
          paramObject = paramObject.media;
          if (paramObject != null)
          {
            paramObject = (FinderMedia)paramObject.getFirst();
            if ((paramObject != null) && (paramObject.mediaType == 0))
            {
              i = 1;
              if (i != 0)
              {
                paramObject = ((FinderObject)localObject2).objectDesc;
                if (paramObject != null) {
                  break label1591;
                }
                paramObject = null;
                if (paramObject != null) {
                  paramObject.mediaType = 4;
                }
              }
              paramObject = ((FinderObject)localObject2).objectDesc;
              if ((paramObject == null) || (paramObject.mediaType != 0)) {
                break label1616;
              }
              i = 1;
              if (i != 0)
              {
                paramObject = ((FinderObject)localObject2).objectDesc;
                if (paramObject != null) {
                  paramObject.mediaType = 4;
                }
              }
              paramObject = FinderItem.Companion;
              localObject6 = FinderItem.a.e((FinderObject)localObject2, 0);
              ((FinderItem)localObject6).setCreateTime(localFinderObject.createtime);
              paramObject = ((FinderItem)localObject6).getFeedObject().objectDesc;
              if (paramObject != null) {
                break label1622;
              }
              paramObject = null;
              if ((paramObject == null) || (paramObject.size() <= 0)) {
                break label1667;
              }
              localdjq = new djq();
              Iterator localIterator = ((Iterable)com.tencent.mm.plugin.finder.storage.data.i.aY(paramObject)).iterator();
              if (!localIterator.hasNext()) {
                break label1660;
              }
              localdji = (dji)localIterator.next();
              paramObject = localdji.url;
              if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
                break label1630;
              }
              i = 1;
              label1214:
              if (i != 0)
              {
                localObject2 = localdji.url;
                paramObject = localObject2;
                if (localObject2 == null) {
                  paramObject = "";
                }
                localObject3 = localdji.url_token;
                localObject2 = localObject3;
                if (localObject3 == null) {
                  localObject2 = "";
                }
                localdji.aaPd = kotlin.g.b.s.X(paramObject, localObject2);
              }
              paramObject = localdji.thumbUrl;
              if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
                break label1636;
              }
              i = 1;
              label1295:
              if (i != 0)
              {
                localObject2 = localdji.thumbUrl;
                paramObject = localObject2;
                if (localObject2 == null) {
                  paramObject = "";
                }
                localObject3 = localdji.thumb_url_token;
                localObject2 = localObject3;
                if (localObject3 == null) {
                  localObject2 = "";
                }
                localdji.aaPe = kotlin.g.b.s.X(paramObject, localObject2);
              }
              paramObject = localdji.full_url;
              if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
                break label1642;
              }
              i = 1;
              label1376:
              if (i != 0)
              {
                localObject2 = localdji.full_url;
                paramObject = localObject2;
                if (localObject2 == null) {
                  paramObject = "";
                }
                localdji.aaPm = paramObject;
              }
              paramObject = localdji.aaPi;
              if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
                break label1648;
              }
              i = 1;
              label1431:
              if (i != 0)
              {
                localObject2 = localdji.aaPi;
                paramObject = localObject2;
                if (localObject2 == null) {
                  paramObject = "";
                }
                localObject3 = localdji.aaPj;
                localObject2 = localObject3;
                if (localObject3 == null) {
                  localObject2 = "";
                }
                localdji.aaPk = kotlin.g.b.s.X(paramObject, localObject2);
              }
              paramObject = localdji.coverUrl;
              if ((paramObject == null) || (kotlin.n.n.U(paramObject, "http", false) != true)) {
                break label1654;
              }
            }
          }
        }
        label1591:
        label1616:
        label1622:
        label1630:
        label1636:
        label1642:
        label1648:
        label1654:
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            localObject2 = localdji.coverUrl;
            paramObject = localObject2;
            if (localObject2 == null) {
              paramObject = "";
            }
            localObject3 = localdji.cover_url_token;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localdji.aaPg = kotlin.g.b.s.X(paramObject, localObject2);
          }
          localdjq.aaPD.add(localdji);
          break label1167;
          break;
          i = 0;
          break label1030;
          paramObject = paramObject.media;
          if (paramObject == null)
          {
            paramObject = null;
            break label1047;
          }
          paramObject = (FinderMedia)paramObject.getFirst();
          break label1047;
          i = 0;
          break label1076;
          paramObject = paramObject.media;
          break label1133;
          i = 0;
          break label1214;
          i = 0;
          break label1295;
          i = 0;
          break label1376;
          i = 0;
          break label1431;
        }
        label1660:
        ((FinderItem)localObject6).field_mediaExtList = localdjq;
        label1667:
        paramObject = ((FinderItem)localObject4).field_clipList.aaOX;
        localObject2 = FinderItem.Companion;
        paramObject.add(FinderItem.a.r((FinderItem)localObject6));
      }
    }
    label1694:
    paramObject = v.FrN;
    ((FinderItem)localObject4).field_reportObject = v.eMT();
    paramObject = ((FinderItem)localObject4).field_reportObject;
    if (paramObject != null)
    {
      paramObject.sendOrExitButtonTime = cn.bDw();
      paramObject.videoPostType = 2;
      paramObject.postStage = 1;
      paramObject = kotlin.ah.aiuX;
      paramObject = kotlin.ah.aiuX;
    }
    paramObject = ((FinderItem)localObject4).field_reportObject;
    if (paramObject != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).description;
      if (localObject1 != null) {
        break label2038;
      }
      i = 0;
      paramObject.descCount = i;
      if (((FinderItem)localObject4).field_reportObject.descCount <= 0) {
        break label2048;
      }
    }
    label2048:
    for (int i = 1;; i = 0)
    {
      paramObject.existDesc = i;
      paramObject = kotlin.ah.aiuX;
      paramObject = kotlin.ah.aiuX;
      paramObject = com.tencent.mm.ui.component.k.aeZF;
      paramObject = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      localbso.longitude = ((Number)paramObject.bsC).floatValue();
      localbso.latitude = ((Number)paramObject.bsD).floatValue();
      paramObject = kotlin.ah.aiuX;
      paramObject = com.tencent.mm.plugin.finder.storage.ah.FMh;
      paramObject = com.tencent.mm.plugin.finder.storage.ah.eZB();
      paramObject.aaPx = cn.bDu();
      localObject1 = paramObject.aaPA;
      if (localObject1 != null)
      {
        paramObject.aaPA.clear();
        paramObject.aaPA.addAll((Collection)localObject1);
        localObject1 = kotlin.ah.aiuX;
        localObject1 = kotlin.ah.aiuX;
      }
      localObject1 = kotlin.ah.aiuX;
      ((FinderItem)localObject4).setPostInfo(paramObject);
      ((FinderItem)localObject4).setMediaExtList(localLinkedList);
      ((FinderItem)localObject4).setPostWaiting();
      paramLong = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFeedStorage().q((FinderItem)localObject4);
      Log.i(this.TAG, "MV insertNewFeed " + paramLong + " localId:" + paramLong);
      ((FinderItem)localObject4).setLocalId(paramLong);
      qA(paramLong);
      eKX();
      paramObject = ah.d.Ftw;
      ah.d.tB(((FinderItem)localObject4).isLongVideo());
      paramObject = com.tencent.mm.plugin.vlog.report.b.UeG;
      com.tencent.mm.plugin.vlog.report.b.hSi();
      ((FinderItem)localObject4).trackPost("doMvPost");
      AppMethodBeat.o(343039);
      return paramLong;
      label2038:
      i = ((String)localObject1).length();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(q paramq, g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(r paramr, g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(g paramg, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    g(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    h(g paramg, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    i(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    k(q paramq, g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    l(r paramr, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.g
 * JD-Core Version:    0.7.0.1
 */