package com.tencent.mm.plugin.finder.report;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.f.a.in;
import com.tencent.mm.f.a.in.a;
import com.tencent.mm.f.b.a.dy;
import com.tencent.mm.f.b.a.ea;
import com.tencent.mm.f.b.a.ed;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderPostReportLogic;", "", "()V", "InnerVersion19086", "", "getInnerVersion19086", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "_18939InnerVersion", "", "finderFeedReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "getFinderFeedReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "setFinderFeedReportObj", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;)V", "postListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "setPostListener", "(Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;)V", "buildMultiMediaJson", "multiMediaInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;", "finishEdit", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "finishTakePhoto", "getFeedReportType", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getReportInfoAndClear", "packageJson", "Lorg/json/JSONObject;", "jsonObject", "key", "value", "pickMedia", "mediaSource", "pickTopicActivity", "topicId", "topicType", "postExit", "pageId", "isSaveDraft", "", "report19086", "success", "report20949", "isExpose", "scene", "report21638", "deleteFlag", "mediaType", "picCnt", "videoLen", "report21666", "reportCurrentPost", "reportCurrentPostExit", "reportCurrentPostFail", "localId", "reportCurrentPostSuccess", "svrId", "saveMegaPostError", "errorType", "errorCode", "savePostError", "setAtData", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "clickMentionCount", "clickSucMentionCount", "setClickId", "clickId", "setDraftType", "draftType", "setFollowSoundTrack", "followId", "setFromAppId", "appId", "setMusicFeedId", "musicFeedId", "setMusicId", "musicId", "setMusicType", "type", "setPostId", "postId", "editId", "setRemuxType", "setSoundTrackType", "startPost", "entrance", "draft", "updateLBSFlag", "lbsFlag", "selectLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "plugin-finder_release"})
public final class k
{
  private static final String TAG = "Finder.FinderPostReportLogic";
  private static FinderFeedReportObject zWo;
  private static final long zWp = 2L;
  private static com.tencent.mm.plugin.finder.upload.q zWq;
  private static final int zWr = 14;
  public static final k zWs;
  
  static
  {
    AppMethodBeat.i(166575);
    zWs = new k();
    TAG = "Finder.FinderPostReportLogic";
    zWp = 2L;
    zWq = (com.tencent.mm.plugin.finder.upload.q)new a();
    zWr = 14;
    AppMethodBeat.o(166575);
  }
  
  public static void Mk(long paramLong)
  {
    AppMethodBeat.i(166572);
    Object localObject = e.AmW;
    localObject = e.a.MH(paramLong);
    if (localObject != null)
    {
      a((FinderItem)localObject, true);
      n localn = n.zWF;
      n.h((FinderItem)localObject);
      AppMethodBeat.o(166572);
      return;
    }
    AppMethodBeat.o(166572);
  }
  
  public static void Ml(long paramLong)
  {
    AppMethodBeat.i(166573);
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    localObject = c.a.MS(paramLong);
    if (localObject != null)
    {
      a((FinderItem)localObject, false);
      AppMethodBeat.o(166573);
      return;
    }
    AppMethodBeat.o(166573);
  }
  
  public static void Ps(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.soundTrackType = paramInt;
    }
  }
  
  public static void Pt(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.musicType = paramInt;
    }
  }
  
  public static void Pu(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.draftType = paramInt;
    }
  }
  
  public static void Pv(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.videoSource = paramInt;
    }
  }
  
  public static void R(boolean paramBoolean, int paramInt)
  {
    int m = 2;
    int n = 1;
    AppMethodBeat.i(284494);
    Object localObject1 = z.bdh();
    p.j(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    Object localObject2;
    int j;
    label148:
    int k;
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      localObject1 = new StringBuilder();
      p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
      localObject1 = com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond();
      localObject2 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
      if (((PluginFinder)localObject2).getRedDotManager().aBe("TLPostCamera") == null)
      {
        localObject2 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)localObject2).getRedDotManager().aBe("TLCamera") == null) {
          break label232;
        }
      }
      j = 1;
      localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
      if (!paramBoolean) {
        break label237;
      }
      k = 1;
      label160:
      if (i != 0) {
        m = 1;
      }
      if (j == 0) {
        break label243;
      }
    }
    label232:
    label237:
    label243:
    for (int i = n;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(20949, new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(i) });
      AppMethodBeat.o(284494);
      return;
      i = 0;
      break;
      j = 0;
      break label148;
      k = 2;
      break label160;
    }
  }
  
  public static void a(int paramInt, bdm parambdm)
  {
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.lbsFlag = paramInt;
      localFinderFeedReportObject.selectLocation = parambdm;
    }
  }
  
  private static void a(FinderItem paramFinderItem, boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(178388);
    Object localObject1 = "";
    Object localObject3 = (Iterable)paramFinderItem.getMediaList();
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    int i = 0;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (csg)((Iterator)localObject3).next();
      localObject1 = (String)localObject1 + ((csg)localObject4).mediaType + ';' + ((csg)localObject4).videoDuration + '#';
      if (Util.isNullOrNil(((csg)localObject4).coverUrl)) {}
      for (i = 0;; i = 1)
      {
        ((Collection)localObject2).add(x.aazN);
        break;
      }
    }
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    long l;
    if (localFinderFeedReportObject != null)
    {
      localObject4 = new ed();
      ((ed)localObject4).rt(localFinderFeedReportObject.sessionId);
      ((ed)localObject4).lW(localFinderFeedReportObject.enterScene);
      if (!paramBoolean) {
        break label1077;
      }
      ((ed)localObject4).lX(j);
      localObject2 = n.zWF;
      ((ed)localObject4).ru(n.Mp(paramFinderItem.getId()));
      ((ed)localObject4).lY(localFinderFeedReportObject.exitPageId);
      ((ed)localObject4).kH(localFinderFeedReportObject.enterTakePhotoTime);
      ((ed)localObject4).kI(localFinderFeedReportObject.enterVideoEditTime);
      ((ed)localObject4).kJ(localFinderFeedReportObject.sendOrExitButtonTime);
      ((ed)localObject4).kK(localFinderFeedReportObject.videoRecordTime);
      ((ed)localObject4).kL(localFinderFeedReportObject.videoSource);
      ((ed)localObject4).kM(localFinderFeedReportObject.videoEmojiCount);
      ((ed)localObject4).kN(localFinderFeedReportObject.videoWordingCount);
      localObject3 = localFinderFeedReportObject.videoMusicId;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((ed)localObject4).rv((String)localObject2);
      ((ed)localObject4).kO(localFinderFeedReportObject.videoMusicIndex);
      ((ed)localObject4).kP(localFinderFeedReportObject.videoMusicSearch);
      ((ed)localObject4).kQ(localFinderFeedReportObject.videoPostType);
      ((ed)localObject4).rw((String)localObject1);
      ((ed)localObject4).kR(localFinderFeedReportObject.existDesc);
      ((ed)localObject4).kS(localFinderFeedReportObject.descCount);
      localObject2 = localFinderFeedReportObject.actionTrace;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((ed)localObject4).rx((String)localObject1);
      ((ed)localObject4).kT(localFinderFeedReportObject.lbsFlag);
      localObject2 = localFinderFeedReportObject.link;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((ed)localObject4).ry((String)localObject1);
      ((ed)localObject4).kU(localFinderFeedReportObject.draft);
      localObject1 = ag.AFH;
      ((ed)localObject4).rz(kotlin.n.n.l(ag.A(paramFinderItem), ",", ";", false));
      ((ed)localObject4).rA("");
      if (!BuildInfo.DEBUG) {
        break label1082;
      }
      l = 0L;
      label536:
      ((ed)localObject4).kV(l);
      ((ed)localObject4).ma(localFinderFeedReportObject.mentionCount);
      ((ed)localObject4).kW(localFinderFeedReportObject.clickMentionCount);
      ((ed)localObject4).kX(localFinderFeedReportObject.clickSucMentionCount);
      ((ed)localObject4).kY(localFinderFeedReportObject.mentionRepeatCount);
      ((ed)localObject4).rB("");
      ((ed)localObject4).lZ(i);
      ((ed)localObject4).rJ(localFinderFeedReportObject.forwardingAppId);
      ((ed)localObject4).rK(localFinderFeedReportObject.topicActivityId);
      ((ed)localObject4).lg(localFinderFeedReportObject.topicActivityType);
      localObject1 = b(b(b(b(b(null, "IsMultiShot", localFinderFeedReportObject.isMultiShot), "MultiShotChangeCnt", localFinderFeedReportObject.multiShotChangeCnt), "MultiShotClickCnt", localFinderFeedReportObject.multiShotClickCnt), "MultiShotSuccessCnt", localFinderFeedReportObject.multiShotSuccessCnt), "MultiShotVideoCnt", localFinderFeedReportObject.multiShotVideoCnt).toString();
      p.j(localObject1, "recordInfo.toString()");
      ((ed)localObject4).rC(kotlin.n.n.l((String)localObject1, ",", ";", false));
      ((ed)localObject4).kZ(localFinderFeedReportObject.videoSubType);
      ((ed)localObject4).rD(localFinderFeedReportObject.postId);
      ((ed)localObject4).rE(localFinderFeedReportObject.editId);
      ((ed)localObject4).rG(localFinderFeedReportObject.clickId);
      localObject1 = paramFinderItem.getLocation();
      if (localObject1 != null)
      {
        localObject2 = aj.AGc;
        ((ed)localObject4).rF(aj.hu(((bdm)localObject1).city, ((bdm)localObject1).poiName));
      }
      ((ed)localObject4).la(localFinderFeedReportObject.remuxType);
      ((ed)localObject4).le(localFinderFeedReportObject.musicType);
      ((ed)localObject4).rI(localFinderFeedReportObject.followSoundTrackId);
      ((ed)localObject4).lf(localFinderFeedReportObject.soundTrackType);
      ((ed)localObject4).rL(localFinderFeedReportObject.musicFeedId);
      localObject1 = paramFinderItem.getMegaVideo();
      if (localObject1 != null)
      {
        ((ed)localObject4).rH(com.tencent.mm.ae.d.Fw(((cvy)localObject1).id));
        localObject2 = ((cvy)localObject1).TEM;
        if (localObject2 == null) {
          break label1090;
        }
        localObject2 = ((cwc)localObject2).media;
        if (localObject2 == null) {
          break label1090;
        }
        localObject2 = (cwq)j.lp((List)localObject2);
        if (localObject2 == null) {
          break label1090;
        }
        i = ((cwq)localObject2).TFq;
        label939:
        ((ed)localObject4).lb(i);
        localObject2 = (csg)j.lp((List)paramFinderItem.getMediaList());
        if (localObject2 == null) {
          break label1095;
        }
      }
    }
    label1077:
    label1082:
    label1090:
    label1095:
    for (i = ((csg)localObject2).fileSize;; i = 0)
    {
      ((ed)localObject4).lc(i);
      localObject1 = ((cvy)localObject1).TEM;
      i = k;
      if (localObject1 != null)
      {
        localObject1 = ((cwc)localObject1).media;
        i = k;
        if (localObject1 != null)
        {
          localObject1 = (cwq)j.lp((List)localObject1);
          i = k;
          if (localObject1 != null) {
            i = ((cwq)localObject1).fileSize;
          }
        }
      }
      ((ed)localObject4).ld(i);
      ((ed)localObject4).bpa();
      localObject1 = n.zWF;
      n.a((com.tencent.mm.plugin.report.a)localObject4);
      b(paramFinderItem, paramBoolean);
      AppMethodBeat.o(178388);
      return;
      j = 0;
      break;
      l = zWp;
      break label536;
      i = 0;
      break label939;
    }
  }
  
  public static void a(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    int j = 1;
    AppMethodBeat.i(284479);
    p.k(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      Object localObject = paramRecordMediaReportInfo.x("KEY_RECORD_IS_BEAUTIFY", Boolean.FALSE);
      p.j(localObject, "reportInfo.getReportValu…ECORD_IS_BEAUTIFY, false)");
      if (((Boolean)localObject).booleanValue())
      {
        i = 1;
        localFinderFeedReportObject.isBeauty = i;
        localObject = paramRecordMediaReportInfo.x("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
        p.j(localObject, "reportInfo.getReportValu…DIA_DURATION_MS_LONG, 0L)");
        localFinderFeedReportObject.videoRecordTime = ((Number)localObject).longValue();
        localFinderFeedReportObject.videoSource = (((Number)paramRecordMediaReportInfo.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
        localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.x("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
        localObject = paramRecordMediaReportInfo.x("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
        localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
        localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
        localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
        localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
        p.j(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.x("KEY_ENTER_TIME_MS_LONG", Long.valueOf(0L));
        p.j(localObject, "reportInfo.getReportValu…Y_ENTER_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterTakePhotoTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.x("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
        p.j(localObject, "reportInfo.getReportValu…UB_RECORD_BOOLEAN, false)");
        if (!((Boolean)localObject).booleanValue()) {
          break label518;
        }
      }
      label518:
      for (int i = j;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.x("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValu…GE_SUB_RECORD_TAB_INT, 0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValu…IDEO_RECORD_CLICK_INT, 0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValu…EO_RECORD_SUCCESS_INT, 0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        p.j(paramRecordMediaReportInfo, "reportInfo.getReportValu…KEY_SUB_VIDEO_NUM_INT, 0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(284479);
        return;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(284479);
  }
  
  public static void aDW(String paramString)
  {
    AppMethodBeat.i(284474);
    p.k(paramString, "musicId");
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.videoMusicId = paramString;
      AppMethodBeat.o(284474);
      return;
    }
    AppMethodBeat.o(284474);
  }
  
  public static void aDX(String paramString)
  {
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.musicFeedId = paramString;
    }
  }
  
  public static void aDY(String paramString)
  {
    AppMethodBeat.i(284475);
    p.k(paramString, "followId");
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.followSoundTrackId = paramString;
      AppMethodBeat.o(284475);
      return;
    }
    AppMethodBeat.o(284475);
  }
  
  public static void aDZ(String paramString)
  {
    AppMethodBeat.i(284477);
    p.k(paramString, "appId");
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.forwardingAppId = paramString;
      AppMethodBeat.o(284477);
      return;
    }
    AppMethodBeat.o(284477);
  }
  
  public static void aEb(String paramString)
  {
    AppMethodBeat.i(284485);
    p.k(paramString, "clickId");
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.clickId = paramString;
      AppMethodBeat.o(284485);
      return;
    }
    AppMethodBeat.o(284485);
  }
  
  public static void av(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(284473);
    zWo = new FinderFeedReportObject();
    if (paramBoolean)
    {
      localFinderFeedReportObject = zWo;
      if (localFinderFeedReportObject != null)
      {
        com.tencent.mm.ae.d.c(TAG, (kotlin.g.a.a)new c(localFinderFeedReportObject, paramBoolean, paramInt));
        AppMethodBeat.o(284473);
        return;
      }
      AppMethodBeat.o(284473);
      return;
    }
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.sessionId = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      localFinderFeedReportObject.enterScene = paramInt;
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localFinderFeedReportObject.draft = paramInt;
        AppMethodBeat.o(284473);
        return;
      }
    }
    AppMethodBeat.o(284473);
  }
  
  public static void aw(int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(284487);
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.exitPageId = paramInt;
      if (paramInt == 4) {
        localFinderFeedReportObject.sendOrExitButtonTime = cm.bfE();
      }
      localFinderFeedReportObject = zWo;
      if (localFinderFeedReportObject != null) {
        com.tencent.mm.ae.d.c(TAG, (kotlin.g.a.a)new b(localFinderFeedReportObject, paramBoolean));
      }
      zWo = null;
      AppMethodBeat.o(284487);
      return;
    }
    AppMethodBeat.o(284487);
  }
  
  private static JSONObject b(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    AppMethodBeat.i(284489);
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramInt);
      label27:
      AppMethodBeat.o(284489);
      return localJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      break label27;
    }
  }
  
  private static void b(FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(166574);
    p.k(paramFinderItem, "finderItem");
    Log.i(TAG, "report19086 localId:" + paramFinderItem.getLocalId() + ", " + paramBoolean);
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject == null)
    {
      Log.e(TAG, "report19086, feedReportObj is null");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1253L, 38L, 1L, false);
      AppMethodBeat.o(166574);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dSo().aSr()).intValue() != 0)
    {
      AppMethodBeat.o(166574);
      return;
    }
    if (!paramBoolean) {}
    int j;
    label199:
    boolean bool;
    int i6;
    int i4;
    int i2;
    int i3;
    long l;
    int k;
    int i;
    Object localObject5;
    int i5;
    Object localObject3;
    label315:
    Object localObject2;
    switch (localFinderFeedReportObject.postStage)
    {
    default: 
      Log.w(TAG, "postStage range error, " + localFinderFeedReportObject.postStage);
      p.k(paramFinderItem, "finderItem");
      if (paramFinderItem.isMvFeed())
      {
        j = 1;
        bool = paramFinderItem.isLongVideo();
        i6 = localFinderFeedReportObject.uploadCost;
        i4 = localFinderFeedReportObject.mediaProcessCost;
        i2 = localFinderFeedReportObject.postTaskCost;
        i3 = localFinderFeedReportObject.clickRepostCount;
        l = localFinderFeedReportObject.uploadMediaTotalSize;
        k = 0;
        i = 0;
        localObject5 = new ArrayList();
        i5 = CdnLogic.getRecentAverageSpeed(1);
        localObject3 = new JSONObject();
        ((ArrayList)localObject5).addAll((Collection)localFinderFeedReportObject.mediaList);
        if (paramBoolean) {
          break label517;
        }
        ((ArrayList)localObject5).addAll((Collection)localFinderFeedReportObject.mediaList);
        localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((csg)((Iterator)localObject1).next()).TAf;
          if (localObject2 != null)
          {
            if (((FinderMediaReportObject)localObject2).cdnUploadRetCode == 0) {
              break label2349;
            }
            ((ArrayList)localObject5).add(localObject2);
            i = ((FinderMediaReportObject)localObject2).cdnUploadRetCode;
          }
        }
      }
      break;
    }
    label517:
    label673:
    label840:
    label1128:
    label2283:
    for (;;)
    {
      localObject2 = x.aazN;
      break label315;
      localObject1 = v.d.zYG;
      v.d.qz(paramFinderItem.isLongVideo());
      break;
      localObject1 = v.d.zYG;
      v.d.qA(paramFinderItem.isLongVideo());
      break;
      localObject1 = v.d.zYG;
      v.d.qB(paramFinderItem.isLongVideo());
      break;
      localObject1 = v.d.zYG;
      v.d.qC(paramFinderItem.isLongVideo());
      break;
      j = 0;
      break label199;
      localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
      for (;;)
      {
        k = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((csg)((Iterator)localObject1).next()).TAf;
        if (localObject2 != null)
        {
          if (((FinderMediaReportObject)localObject2).cdnUploadRetCode != 0)
          {
            ((ArrayList)localObject5).add(localObject2);
            i = ((FinderMediaReportObject)localObject2).cdnUploadRetCode;
          }
          localObject2 = x.aazN;
        }
      }
      Object localObject4 = ((Iterable)localObject5).iterator();
      localObject2 = "";
      int m = 0;
      Object localObject6;
      Object localObject7;
      int i7;
      label623:
      Object localObject8;
      label750:
      int n;
      label878:
      Object localObject10;
      if (((Iterator)localObject4).hasNext())
      {
        localObject6 = (FinderMediaReportObject)((Iterator)localObject4).next();
        localObject3 = new JSONObject();
        g.a(localObject6, (JSONObject)localObject3);
        i = m;
        Object localObject9;
        if (m == 0)
        {
          if (((FinderMediaReportObject)localObject6).zipTime > 0) {
            i = 1;
          }
        }
        else
        {
          localObject7 = localObject6.getClass().getDeclaredFields();
          p.j(localObject7, "it::class.java.declaredFields");
          i7 = localObject7.length;
          m = 0;
          localObject1 = localObject2;
          if (m >= i7) {
            break label1128;
          }
          localObject8 = localObject7[m];
          localObject9 = localObject8.get(localObject6);
          if (localObject9 != null) {
            break label673;
          }
          localObject2 = localObject1;
        }
        Field[] arrayOfField;
        int i8;
        do
        {
          do
          {
            for (;;)
            {
              m += 1;
              localObject1 = localObject2;
              break label623;
              i = 0;
              break;
              if ((!(localObject9 instanceof Integer)) || (!(p.h(localObject9, Integer.valueOf(0)) ^ true))) {
                break label750;
              }
              localObject1 = new StringBuilder().append((String)localObject1);
              p.j(localObject8, "field");
              localObject2 = localObject8.getName() + ':' + localObject9 + ';';
            }
            if ((localObject9 instanceof String))
            {
              if (((CharSequence)localObject9).length() > 0) {}
              for (n = 1;; n = 0)
              {
                if (n == 0) {
                  break label840;
                }
                localObject1 = new StringBuilder().append((String)localObject1);
                p.j(localObject8, "field");
                localObject2 = localObject8.getName() + ':' + localObject9 + ';';
                break;
              }
            }
            localObject2 = localObject1;
          } while (!(localObject9 instanceof com.tencent.mm.cd.a));
          arrayOfField = localObject9.getClass().getDeclaredFields();
          p.j(arrayOfField, "fieldValue::class.java.declaredFields");
          i8 = arrayOfField.length;
          n = 0;
          localObject2 = localObject1;
        } while (n >= i8);
        localObject2 = arrayOfField[n];
        localObject10 = ((Field)localObject2).get(localObject9);
        if (((localObject10 instanceof Integer)) && ((p.h(localObject10, Integer.valueOf(0)) ^ true)))
        {
          localObject1 = new StringBuilder().append((String)localObject1);
          p.j(localObject8, "field");
          localObject1 = ((StringBuilder)localObject1).append(localObject8.getName()).append('-');
          p.j(localObject2, "innerField");
          localObject1 = ((Field)localObject2).getName() + ':' + localObject10 + ';';
        }
      }
      label1004:
      label2289:
      label2297:
      for (;;)
      {
        n += 1;
        break label878;
        if ((localObject10 instanceof String))
        {
          int i1;
          if (((CharSequence)localObject10).length() > 0) {
            i1 = 1;
          }
          for (;;)
          {
            if (i1 != 0)
            {
              localObject1 = new StringBuilder().append((String)localObject1);
              p.j(localObject8, "field");
              localObject1 = ((StringBuilder)localObject1).append(localObject8.getName()).append('-');
              p.j(localObject2, "innerField");
              localObject1 = ((Field)localObject2).getName() + ':' + localObject10 + ';';
              break label1004;
              i1 = 0;
              continue;
              localObject2 = (String)localObject1 + "#";
              m = i;
              break;
              try
              {
                localObject1 = com.tencent.mm.kernel.h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.VxY, "");
                localObject1 = localObject4;
                if (!(localObject4 instanceof String)) {
                  localObject1 = null;
                }
                localObject4 = (String)localObject1;
                localObject1 = localObject4;
                if (localObject4 == null) {
                  localObject1 = "";
                }
                ((JSONObject)localObject3).put("snn", localObject1);
                localObject1 = (csg)j.lp((List)paramFinderItem.getMediaList());
                if (localObject1 != null)
                {
                  localObject1 = ((csg)localObject1).codec_info;
                  if (localObject1 != null)
                  {
                    ((JSONObject)localObject3).put("codecInfo", "video_score:" + ((bea)localObject1).SPf + ",video_cover_score:" + ((bea)localObject1).SPg + ",video_audio_score:" + ((bea)localObject1).SPh + ",thumb_score:" + ((bea)localObject1).SPi + ",hdimg_score:" + ((bea)localObject1).SPj + ",has_stickers:" + ((bea)localObject1).SPk);
                    localObject1 = x.aazN;
                  }
                }
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  Log.printErrStackTrace(TAG, localThrowable, "mediaInfoJson put snn", new Object[0]);
                  continue;
                  String str = localThrowable.TzS;
                  continue;
                  str = str.TzS;
                  continue;
                  str = null;
                  continue;
                  str = "";
                  continue;
                  localObject3 = "";
                  continue;
                  i = 0;
                  continue;
                  localObject3 = Integer.valueOf(0);
                  continue;
                  m = 0;
                  continue;
                  paramFinderItem = Integer.valueOf(0);
                  continue;
                  k = 2;
                  continue;
                  localObject4 = str;
                }
              }
              localObject1 = (csg)j.lp((List)paramFinderItem.getMediaList());
              if (localObject1 != null)
              {
                if (Util.isNullOrNil(((csg)localObject1).TzS))
                {
                  localObject1 = p.I(((csg)localObject1).url, Util.nullAsNil(((csg)localObject1).url_token));
                  if (localObject1 != null) {
                    break label2339;
                  }
                }
              }
              else
              {
                localObject4 = "";
                if (!bool) {
                  break label2289;
                }
                localObject1 = paramFinderItem.getLongVideoMediaList();
                if (localObject1 == null) {
                  break label2283;
                }
                localObject1 = (csg)j.lp((List)localObject1);
                if (localObject1 == null) {
                  break label2283;
                }
                if (!Util.isNullOrNil(((csg)localObject1).TzS)) {
                  break label2273;
                }
                localObject1 = p.I(((csg)localObject1).url, Util.nullAsNil(((csg)localObject1).url_token));
                localObject3 = ((JSONObject)localObject3).toString();
                p.j(localObject3, "mediaInfoJson.toString()");
                localObject6 = kotlin.n.n.l((String)localObject3, ",", ";", false);
                localObject3 = (FinderMediaReportObject)j.lp((List)localObject5);
                if (localObject3 != null)
                {
                  if (((FinderMediaReportObject)localObject3).mediaType != 4) {
                    break label2297;
                  }
                  localObject3 = ((FinderMediaReportObject)j.lo((List)localObject5)).multiMediaInfo;
                  p.j(localObject3, "mediaReportList.first().multiMediaInfo");
                  localObject3 = eG((List)localObject3);
                  localObject5 = localObject3;
                  if (localObject3 != null) {}
                }
                else
                {
                  localObject5 = "";
                }
                localObject5 = kotlin.n.n.l((String)localObject5, ",", ";", false);
                n = localFinderFeedReportObject.dumpCgiErrorCode;
                i1 = localFinderFeedReportObject.dumpCgiErrorType;
                i7 = localFinderFeedReportObject.sdkShareType;
                localObject3 = paramFinderItem.getFeedObject().objectDesc;
                if (localObject3 != null)
                {
                  localObject3 = ((FinderObjectDesc)localObject3).event;
                  if ((localObject3 != null) && (((bfv)localObject3).xdR == 0L)) {
                    break label2305;
                  }
                }
                i = 1;
                Log.i(TAG, "19086, sdkShareType:" + i7 + ", isActivityEvent:" + i + ", dumpCgiErrorType:" + i1 + ", dumpCgiErrorCode:" + n);
                localObject7 = new StringBuilder().append(localFinderFeedReportObject.enterScene).append(',').append(localFinderFeedReportObject.sessionId).append(',');
                if (!paramBoolean) {
                  break label2310;
                }
                localObject3 = n.zWF;
                localObject3 = n.Mp(paramFinderItem.getId());
                localObject2 = ((StringBuilder)localObject7).append(localObject3).append(',').append(localFinderFeedReportObject.videoSource).append(',').append(cm.bfE() - localFinderFeedReportObject.sendOrExitButtonTime).append(',').append(m).append(',').append(i6).append(',').append((String)localObject2).append(',');
                if (!paramBoolean) {
                  break label2319;
                }
                m = 1;
                localObject2 = ((StringBuilder)localObject2).append(m).append(',').append(i4).append(',').append(zWr).append(',').append(k).append(',').append(NetStatusUtil.getNetTypeString(MMApplicationContext.getContext())).append(',').append(localFinderFeedReportObject.retryCount).append(',').append(i5).append(',').append((String)localObject6).append(',').append(localFinderFeedReportObject.videoPostType).append(',').append(localFinderFeedReportObject.uploadLogicError).append(',').append(localFinderFeedReportObject.postStage).append(',').append((String)localObject5).append(',');
                if (!paramBoolean) {
                  break label2325;
                }
                localObject3 = n.zWF;
                paramFinderItem = n.Mp(paramFinderItem.getId());
                paramFinderItem = ((StringBuilder)localObject2).append(paramFinderItem).append(',').append(localFinderFeedReportObject.cgiErrorCode).append(',').append(localFinderFeedReportObject.cgiErrorType).append(',').append((String)localObject4).append(',');
                if (!bool) {
                  break label2333;
                }
                k = 1;
                paramFinderItem = k + ',' + (String)localObject1 + ',' + localFinderFeedReportObject.megaCgiErrorCode + ',' + localFinderFeedReportObject.megaCgiErrorType + ',' + localFinderFeedReportObject.longVideoSizeInvalid + ',' + i2 + ',' + i3 + ',' + l + ',' + n + ',' + i1 + ',' + i7 + ',' + i + ',' + j;
                Log.i(TAG, "19086 ".concat(String.valueOf(paramFinderItem)));
                com.tencent.mm.plugin.report.f.Iyx.kvStat(19086, paramFinderItem);
                AppMethodBeat.o(166574);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public static void b(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(284481);
    p.k(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.x("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
      Object localObject = paramRecordMediaReportInfo.x("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
      p.j(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
      localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.x("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
      p.j(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
      localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
      p.j(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
      localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
      p.j(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
      localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
      p.j(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
      localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
      localObject = paramRecordMediaReportInfo.x("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(0));
      p.j(localObject, "reportInfo.getReportValu…EY_VIDEO_SUB_TYPE_INT, 0)");
      localFinderFeedReportObject.videoSubType = ((Number)localObject).intValue();
      localFinderFeedReportObject.postId = ((String)paramRecordMediaReportInfo.x("KEY_MULTI_MEDIA_POST_ID_STRING", ""));
      localFinderFeedReportObject.editId = ((String)paramRecordMediaReportInfo.x("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      localObject = paramRecordMediaReportInfo.x("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
      p.j(localObject, "reportInfo.getReportValu…UB_RECORD_BOOLEAN, false)");
      if (((Boolean)localObject).booleanValue()) {}
      for (int i = 1;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.x("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValu…GE_SUB_RECORD_TAB_INT, 0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValu…IDEO_RECORD_CLICK_INT, 0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        p.j(localObject, "reportInfo.getReportValu…EO_RECORD_SUCCESS_INT, 0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        p.j(paramRecordMediaReportInfo, "reportInfo.getReportValu…KEY_SUB_VIDEO_NUM_INT, 0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(284481);
        return;
      }
    }
    AppMethodBeat.o(284481);
  }
  
  public static void c(ArrayList<cse> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284478);
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      if (paramArrayList != null)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str2 = ((cse)localIterator.next()).username;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          localHashSet.add(str1);
        }
        localFinderFeedReportObject.mentionCount = localHashSet.size();
      }
      localFinderFeedReportObject.clickMentionCount = paramInt1;
      localFinderFeedReportObject.clickSucMentionCount = paramInt2;
      if (paramArrayList != null) {}
      for (paramInt1 = paramArrayList.size();; paramInt1 = 0)
      {
        localFinderFeedReportObject.mentionRepeatCount = paramInt1;
        AppMethodBeat.o(284478);
        return;
      }
    }
    AppMethodBeat.o(284478);
  }
  
  public static com.tencent.mm.plugin.finder.upload.q dPA()
  {
    return zWq;
  }
  
  public static FinderFeedReportObject dPy()
  {
    return zWo;
  }
  
  public static FinderFeedReportObject dPz()
  {
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    zWo = null;
    return localFinderFeedReportObject;
  }
  
  public static void dU(String paramString, int paramInt)
  {
    AppMethodBeat.i(284476);
    p.k(paramString, "topicId");
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.topicActivityId = paramString;
      localFinderFeedReportObject.topicActivityType = paramInt;
      AppMethodBeat.o(284476);
      return;
    }
    AppMethodBeat.o(284476);
  }
  
  private static String eG(List<? extends FinderMediaReportInfo> paramList)
  {
    AppMethodBeat.i(284492);
    JSONArray localJSONArray = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      FinderMediaReportInfo localFinderMediaReportInfo = (FinderMediaReportInfo)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("w", localFinderMediaReportInfo.width);
      localJSONObject.put("h", localFinderMediaReportInfo.height);
      localJSONObject.put("fps", localFinderMediaReportInfo.fps);
      localJSONObject.put("audiobitrate", localFinderMediaReportInfo.audioBitrate);
      localJSONObject.put("videobitrate", localFinderMediaReportInfo.videoBitrate);
      localJSONArray.put(localJSONObject);
    }
    paramList = localJSONArray.toString();
    p.j(paramList, "array.toString()");
    AppMethodBeat.o(284492);
    return paramList;
  }
  
  public static void f(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(284491);
    p.k(paramFinderItem, "finderItem");
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject == null)
    {
      Log.e(TAG, "report21666, feedReportObj is null");
      AppMethodBeat.o(284491);
      return;
    }
    dy localdy = new dy();
    localdy.kg(paramFinderItem.getLocalId());
    localdy.kh(cm.bfE() - localFinderFeedReportObject.sendOrExitButtonTime);
    localdy.ki(localFinderFeedReportObject.uploadCost);
    localdy.kj(localFinderFeedReportObject.mediaProcessCost);
    localdy.kk(zWr);
    localdy.re(NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()));
    localdy.kl(localFinderFeedReportObject.retryCount);
    localdy.km(CdnLogic.getRecentAverageSpeed(1));
    localdy.kn(localFinderFeedReportObject.videoPostType);
    localdy.ko(localFinderFeedReportObject.postStage);
    localdy.kr(paramFinderItem.getPostInfo().TAi);
    boolean bool = paramFinderItem.isLongVideo();
    localdy.ks(localFinderFeedReportObject.postTaskCost);
    localdy.kt(localFinderFeedReportObject.clickRepostCount);
    localdy.ku(localFinderFeedReportObject.uploadMediaTotalSize);
    Object localObject4 = new ArrayList();
    Object localObject2 = new JSONObject();
    int i = 0;
    ((ArrayList)localObject4).addAll((Collection)localFinderFeedReportObject.mediaList);
    ((ArrayList)localObject4).addAll((Collection)localFinderFeedReportObject.mediaList);
    Object localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((csg)((Iterator)localObject1).next()).TAf;
      if (localObject3 != null)
      {
        if (((FinderMediaReportObject)localObject3).cdnUploadRetCode == 0) {
          break label1759;
        }
        ((ArrayList)localObject4).add(localObject3);
        i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
      }
    }
    label710:
    label1736:
    label1744:
    label1749:
    label1759:
    for (;;)
    {
      localObject3 = x.aazN;
      break;
      localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ((csg)((Iterator)localObject1).next()).TAf;
        if (localObject3 != null)
        {
          if (((FinderMediaReportObject)localObject3).cdnUploadRetCode != 0)
          {
            ((ArrayList)localObject4).add(localObject3);
            i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
          }
          localObject3 = x.aazN;
        }
      }
      localdy.lN(i);
      Iterator localIterator = ((Iterable)localObject4).iterator();
      localObject1 = "";
      Field localField;
      label623:
      int j;
      label747:
      Object localObject6;
      if (localIterator.hasNext())
      {
        FinderMediaReportObject localFinderMediaReportObject = (FinderMediaReportObject)localIterator.next();
        localObject3 = new JSONObject();
        g.a(localFinderMediaReportObject, (JSONObject)localObject3);
        Field[] arrayOfField1 = localFinderMediaReportObject.getClass().getDeclaredFields();
        p.j(arrayOfField1, "it::class.java.declaredFields");
        int m = arrayOfField1.length;
        i = 0;
        if (i < m)
        {
          localField = arrayOfField1[i];
          Object localObject5 = localField.get(localFinderMediaReportObject);
          if (localObject5 == null) {
            localObject2 = localObject1;
          }
          Field[] arrayOfField2;
          int n;
          do
          {
            do
            {
              for (;;)
              {
                i += 1;
                localObject1 = localObject2;
                break;
                if ((!(localObject5 instanceof Integer)) || (!(p.h(localObject5, Integer.valueOf(0)) ^ true))) {
                  break label623;
                }
                localObject1 = new StringBuilder().append((String)localObject1);
                p.j(localField, "field");
                localObject2 = localField.getName() + ':' + localObject5 + ';';
              }
              if ((localObject5 instanceof String))
              {
                if (((CharSequence)localObject5).length() > 0) {}
                for (j = 1;; j = 0)
                {
                  if (j == 0) {
                    break label710;
                  }
                  localObject1 = new StringBuilder().append((String)localObject1);
                  p.j(localField, "field");
                  localObject2 = localField.getName() + ':' + localObject5 + ';';
                  break;
                }
              }
              localObject2 = localObject1;
            } while (!(localObject5 instanceof com.tencent.mm.cd.a));
            arrayOfField2 = localObject5.getClass().getDeclaredFields();
            p.j(arrayOfField2, "fieldValue::class.java.declaredFields");
            n = arrayOfField2.length;
            j = 0;
            localObject2 = localObject1;
          } while (j >= n);
          localObject2 = arrayOfField2[j];
          localObject6 = ((Field)localObject2).get(localObject5);
          if (((localObject6 instanceof Integer)) && ((p.h(localObject6, Integer.valueOf(0)) ^ true)))
          {
            localObject1 = new StringBuilder().append((String)localObject1);
            p.j(localField, "field");
            localObject1 = ((StringBuilder)localObject1).append(localField.getName()).append('-');
            p.j(localObject2, "innerField");
            localObject1 = ((Field)localObject2).getName() + ':' + localObject6 + ';';
          }
        }
      }
      for (;;)
      {
        label871:
        j += 1;
        break label747;
        if ((localObject6 instanceof String))
        {
          int k;
          if (((CharSequence)localObject6).length() > 0) {
            k = 1;
          }
          for (;;)
          {
            if (k != 0)
            {
              localObject1 = new StringBuilder().append((String)localObject1);
              p.j(localField, "field");
              localObject1 = ((StringBuilder)localObject1).append(localField.getName()).append('-');
              p.j(localObject2, "innerField");
              localObject1 = ((Field)localObject2).getName() + ':' + localObject6 + ';';
              break label871;
              k = 0;
              continue;
              localObject1 = (String)localObject1 + "#";
              localObject2 = localObject3;
              break;
              localdy.rd((String)localObject1);
              try
              {
                localObject1 = com.tencent.mm.kernel.h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject3 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.VxY, "");
                localObject1 = localObject3;
                if (!(localObject3 instanceof String)) {
                  localObject1 = null;
                }
                localObject3 = (String)localObject1;
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = "";
                }
                ((JSONObject)localObject2).put("snn", localObject1);
                localObject1 = (csg)j.lp((List)paramFinderItem.getMediaList());
                if (localObject1 != null)
                {
                  localObject1 = ((csg)localObject1).codec_info;
                  if (localObject1 != null)
                  {
                    ((JSONObject)localObject2).put("codecInfo", "video_score:" + ((bea)localObject1).SPf + ",video_cover_score:" + ((bea)localObject1).SPg + ",video_audio_score:" + ((bea)localObject1).SPh + ",thumb_score:" + ((bea)localObject1).SPi + ",hdimg_score:" + ((bea)localObject1).SPj + ",has_stickers:" + ((bea)localObject1).SPk);
                    localObject1 = x.aazN;
                  }
                }
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  Log.printErrStackTrace(TAG, localThrowable, "mediaInfoJson put snn", new Object[0]);
                  continue;
                  String str = localThrowable.TzS;
                  continue;
                  str = str.TzS;
                  continue;
                  str = null;
                  continue;
                  str = "";
                  continue;
                  localObject2 = "";
                  continue;
                  long l = 2L;
                  continue;
                  i = 0;
                  continue;
                  localObject3 = str;
                }
              }
              localObject1 = (csg)j.lp((List)paramFinderItem.getMediaList());
              if (localObject1 != null)
              {
                if (Util.isNullOrNil(((csg)localObject1).TzS))
                {
                  localObject1 = p.I(((csg)localObject1).url, Util.nullAsNil(((csg)localObject1).url_token));
                  if (localObject1 != null) {
                    break label1749;
                  }
                }
              }
              else
              {
                localObject3 = "";
                if (!bool) {
                  break label1720;
                }
                localObject1 = paramFinderItem.getLongVideoMediaList();
                if (localObject1 == null) {
                  break label1714;
                }
                localObject1 = (csg)j.lp((List)localObject1);
                if (localObject1 == null) {
                  break label1714;
                }
                if (!Util.isNullOrNil(((csg)localObject1).TzS)) {
                  break label1704;
                }
                localObject1 = p.I(((csg)localObject1).url, Util.nullAsNil(((csg)localObject1).url_token));
                localObject2 = ((JSONObject)localObject2).toString();
                p.j(localObject2, "mediaInfoJson.toString()");
                localdy.rf(kotlin.n.n.l((String)localObject2, ",", ";", false));
                localObject2 = (FinderMediaReportObject)j.lp((List)localObject4);
                if (localObject2 != null)
                {
                  if (((FinderMediaReportObject)localObject2).mediaType != 4) {
                    break label1728;
                  }
                  localObject2 = ((FinderMediaReportObject)j.lo((List)localObject4)).multiMediaInfo;
                  p.j(localObject2, "mediaReportList.first().multiMediaInfo");
                  localObject2 = eG((List)localObject2);
                  localObject4 = localObject2;
                  if (localObject2 != null) {}
                }
                else
                {
                  localObject4 = "";
                }
                localdy.rg(kotlin.n.n.l((String)localObject4, ",", ";", false));
                localdy.lO(localFinderFeedReportObject.cgiErrorCode);
                localdy.lP(localFinderFeedReportObject.cgiErrorType);
                localdy.rh((String)localObject3);
                if (!bool) {
                  break label1736;
                }
                l = 1L;
                localdy.kp(l);
                localdy.ri((String)localObject1);
                localdy.lQ(localFinderFeedReportObject.megaCgiErrorCode);
                localdy.lR(localFinderFeedReportObject.megaCgiErrorType);
                localdy.kq(localFinderFeedReportObject.longVideoSizeInvalid);
                localdy.lS(localFinderFeedReportObject.dumpCgiErrorCode);
                localdy.lT(localFinderFeedReportObject.dumpCgiErrorType);
                localdy.lU(localFinderFeedReportObject.sdkShareType);
                paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
                if (paramFinderItem != null)
                {
                  paramFinderItem = paramFinderItem.event;
                  if ((paramFinderItem != null) && (paramFinderItem.xdR == 0L)) {
                    break label1744;
                  }
                }
                i = 1;
                localdy.lV(i);
                localdy.bpa();
                paramFinderItem = n.zWF;
                n.a((com.tencent.mm.plugin.report.a)localdy);
                AppMethodBeat.o(284491);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void hh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(284482);
    p.k(paramString1, "postId");
    FinderFeedReportObject localFinderFeedReportObject = zWo;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.postId = paramString1;
      if (paramString2 != null) {
        localFinderFeedReportObject.editId = paramString2;
      }
      AppMethodBeat.o(284482);
      return;
    }
    AppMethodBeat.o(284482);
  }
  
  public static void j(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284490);
    Log.i(TAG, "savePostError " + paramLong + ", " + paramInt1 + ", " + paramInt2);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    localObject1 = c.a.MS(paramLong);
    if (localObject1 != null)
    {
      Object localObject2 = ((FinderItem)localObject1).field_reportObject;
      if (localObject2 != null) {
        ((FinderFeedReportObject)localObject2).cgiErrorType = paramInt1;
      }
      localObject2 = ((FinderItem)localObject1).field_reportObject;
      if (localObject2 != null) {
        ((FinderFeedReportObject)localObject2).cgiErrorCode = paramInt2;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      c.a.s((FinderItem)localObject1);
      AppMethodBeat.o(284490);
      return;
    }
    AppMethodBeat.o(284490);
  }
  
  public static void m(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(284495);
    ea localea = new ea();
    Object localObject = zWo;
    if (localObject != null)
    {
      localea.rn(((FinderFeedReportObject)localObject).postId);
      localea.ro(((FinderFeedReportObject)localObject).editId);
      localea.kv(((FinderFeedReportObject)localObject).videoSource);
      localea.kw(paramInt);
      localea.kx(paramLong1);
      localea.ky(paramLong2);
      localea.bpa();
      localObject = n.zWF;
      n.a((com.tencent.mm.plugin.report.a)localea);
      AppMethodBeat.o(284495);
      return;
    }
    AppMethodBeat.o(284495);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/report/FinderPostReportLogic$postListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.upload.q
  {
    public final void onPostEnd(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(166567);
      Object localObject = k.zWs;
      k.Ml(paramLong);
      localObject = new in();
      ((in)localObject).fFH.localId = paramLong;
      ((in)localObject).fFH.fFI = false;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(166567);
    }
    
    public final void onPostNotify(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(264773);
      if (!paramBoolean)
      {
        in localin = new in();
        localin.fFH.localId = paramLong;
        localin.fFH.fFI = false;
        EventCenter.instance.publish((IEvent)localin);
      }
      AppMethodBeat.o(264773);
    }
    
    public final void onPostOk(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166568);
      Object localObject = k.zWs;
      k.Mk(paramLong2);
      localObject = e.AmW;
      localObject = e.a.MH(paramLong2);
      if (localObject != null)
      {
        in localin = new in();
        localin.fFH.localId = paramLong1;
        localin.fFH.fFI = true;
        in.a locala = localin.fFH;
        ac.a locala1 = ac.AEJ;
        locala.fFJ = ac.a.c((FinderItem)localObject, true);
        EventCenter.instance.publish((IEvent)localin);
        AppMethodBeat.o(166568);
        return;
      }
      AppMethodBeat.o(166568);
    }
    
    public final void onPostStart(long paramLong) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/report/FinderPostReportLogic$reportCurrentPostExit$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(FinderFeedReportObject paramFinderFeedReportObject, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/report/FinderPostReportLogic$startPost$1$1"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(FinderFeedReportObject paramFinderFeedReportObject, boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.k
 * JD-Core Version:    0.7.0.1
 */