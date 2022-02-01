package com.tencent.mm.plugin.finder.report;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jh;
import com.tencent.mm.autogen.a.jh.a;
import com.tencent.mm.autogen.mmdata.rpt.fi;
import com.tencent.mm.autogen.mmdata.rpt.fl;
import com.tencent.mm.autogen.mmdata.rpt.fo;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.r;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.as;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderPostReportLogic;", "", "()V", "InnerVersion19086", "", "getInnerVersion19086", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "_18939InnerVersion", "", "finderFeedReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "getFinderFeedReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "setFinderFeedReportObj", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;)V", "postListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "setPostListener", "(Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;)V", "buildMultiMediaJson", "multiMediaInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;", "finishEdit", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "finishTakePhoto", "getFeedReportType", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getReportInfoAndClear", "packageJson", "Lorg/json/JSONObject;", "jsonObject", "key", "value", "pickMedia", "mediaSource", "pickTopicActivity", "topicId", "topicType", "postExit", "pageId", "isSaveDraft", "", "report19086", "success", "report20949", "isExpose", "scene", "report21638", "deleteFlag", "mediaType", "picCnt", "videoLen", "report21666", "reportCurrentPost", "reportCurrentPostExit", "reportCurrentPostFail", "localId", "reportCurrentPostSuccess", "svrId", "saveMegaPostError", "errorType", "errorCode", "savePostError", "setActiveId", "activeId", "setAtData", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "clickMentionCount", "clickSucMentionCount", "setClickId", "clickId", "setColorSpace", "colorSpace", "setDraftId", "draftId", "setDraftType", "draftType", "setFollowSoundTrack", "followId", "setFromAppId", "appId", "setMusicFeedId", "musicFeedId", "setMusicId", "musicId", "setMusicType", "type", "setPostId", "postId", "editId", "setRemuxType", "setSoundTrackType", "startPost", "entrance", "draft", "updateLBSFlag", "lbsFlag", "selectLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  private static r BuC;
  public static final v FrN;
  private static FinderFeedReportObject FrO;
  private static final long FrP;
  private static final int FrQ;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(166575);
    FrN = new v();
    TAG = "Finder.FinderPostReportLogic";
    FrP = 2L;
    BuC = (r)new a();
    FrQ = 14;
    AppMethodBeat.o(166575);
  }
  
  public static void Sw(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.soundTrackType = paramInt;
    }
  }
  
  public static void Sx(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.musicType = paramInt;
    }
  }
  
  public static void Sy(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.draftType = paramInt;
    }
  }
  
  public static void Sz(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.videoSource = paramInt;
    }
  }
  
  public static void T(boolean paramBoolean, int paramInt)
  {
    int m = 2;
    int n = 1;
    AppMethodBeat.i(331742);
    Object localObject = com.tencent.mm.model.z.bAW();
    s.s(localObject, "getMyFinderUsername()");
    int j;
    label117:
    com.tencent.mm.plugin.report.service.h localh;
    int k;
    if (((CharSequence)localObject).length() > 0)
    {
      i = 1;
      localObject = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localObject = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
      if ((((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLPostCamera") == null) && (((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLCamera") == null)) {
        break label201;
      }
      j = 1;
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      if (!paramBoolean) {
        break label206;
      }
      k = 1;
      label129:
      if (i != 0) {
        m = 1;
      }
      if (j == 0) {
        break label212;
      }
    }
    label201:
    label206:
    label212:
    for (int i = n;; i = 0)
    {
      localh.b(20949, new Object[] { localObject, Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(i) });
      AppMethodBeat.o(331742);
      return;
      i = 0;
      break;
      j = 0;
      break label117;
      k = 2;
      break label129;
    }
  }
  
  public static void a(int paramInt, boi paramboi)
  {
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.lbsFlag = paramInt;
      localFinderFeedReportObject.selectLocation = paramboi;
    }
  }
  
  public static void a(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    int j = 1;
    AppMethodBeat.i(331537);
    s.u(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    Object localObject;
    if (localFinderFeedReportObject != null)
    {
      localObject = paramRecordMediaReportInfo.J("KEY_RECORD_IS_BEAUTIFY", Boolean.FALSE);
      s.s(localObject, "reportInfo.getReportValu…ECORD_IS_BEAUTIFY, false)");
      if (!((Boolean)localObject).booleanValue()) {
        break label507;
      }
      i = 1;
      localFinderFeedReportObject.isBeauty = i;
      localObject = paramRecordMediaReportInfo.J("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
      s.s(localObject, "reportInfo.getReportValu…DIA_DURATION_MS_LONG, 0L)");
      localFinderFeedReportObject.videoRecordTime = ((Number)localObject).longValue();
      localFinderFeedReportObject.videoSource = (((Number)paramRecordMediaReportInfo.J("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
      localFinderFeedReportObject.videoMusicId = String.valueOf(paramRecordMediaReportInfo.J("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0)));
      localObject = paramRecordMediaReportInfo.J("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
      localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
      localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
      localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
      localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
      s.s(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
      localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
      localObject = paramRecordMediaReportInfo.J("KEY_ENTER_TIME_MS_LONG", Long.valueOf(0L));
      s.s(localObject, "reportInfo.getReportValu…Y_ENTER_TIME_MS_LONG, 0L)");
      localFinderFeedReportObject.enterTakePhotoTime = ((Number)localObject).longValue();
      localObject = paramRecordMediaReportInfo.J("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
      s.s(localObject, "reportInfo.getReportValu…UB_RECORD_BOOLEAN, false)");
      if (!((Boolean)localObject).booleanValue()) {
        break label512;
      }
    }
    label512:
    for (int i = j;; i = 0)
    {
      localFinderFeedReportObject.isMultiShot = i;
      localObject = paramRecordMediaReportInfo.J("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…GE_SUB_RECORD_TAB_INT, 0)");
      localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…IDEO_RECORD_CLICK_INT, 0)");
      localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…EO_RECORD_SUCCESS_INT, 0)");
      localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
      paramRecordMediaReportInfo = paramRecordMediaReportInfo.J("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
      s.s(paramRecordMediaReportInfo, "reportInfo.getReportValu…KEY_SUB_VIDEO_NUM_INT, 0)");
      localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
      AppMethodBeat.o(331537);
      return;
      label507:
      i = 0;
      break;
    }
  }
  
  public static void a(FinderFeedReportObject paramFinderFeedReportObject)
  {
    FrO = paramFinderFeedReportObject;
  }
  
  public static void aP(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(331464);
    Object localObject1 = new FinderFeedReportObject();
    FrO = (FinderFeedReportObject)localObject1;
    ((FinderFeedReportObject)localObject1).flowId = (cn.bDv() + '_' + com.tencent.mm.model.z.bAW());
    if (paramBoolean)
    {
      localObject1 = FrO;
      if (localObject1 != null)
      {
        com.tencent.mm.ae.d.e(TAG, (kotlin.g.a.a)new c(paramBoolean, (FinderFeedReportObject)localObject1, paramInt));
        AppMethodBeat.o(331464);
      }
    }
    else
    {
      localObject1 = FrO;
      if (localObject1 != null)
      {
        ((FinderFeedReportObject)localObject1).sessionId = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
        ((FinderFeedReportObject)localObject1).enterScene = paramInt;
        if (!paramBoolean) {
          break label163;
        }
        paramInt = 1;
        ((FinderFeedReportObject)localObject1).draft = paramInt;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      localObject1 = FrO;
      if (localObject1 != null) {
        break label168;
      }
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a((String)localObject1, com.tencent.mm.plugin.finder.report.postreport.b.eOc());
      AppMethodBeat.o(331464);
      return;
      label163:
      paramInt = 0;
      break;
      label168:
      localObject2 = ((FinderFeedReportObject)localObject1).flowId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  public static void aQ(int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(331601);
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.exitPageId = paramInt;
      if (paramInt == 4) {
        localFinderFeedReportObject.sendOrExitButtonTime = cn.bDw();
      }
      localFinderFeedReportObject = FrO;
      if (localFinderFeedReportObject != null) {
        com.tencent.mm.ae.d.e(TAG, (kotlin.g.a.a)new b(localFinderFeedReportObject, paramBoolean));
      }
    }
    AppMethodBeat.o(331601);
  }
  
  public static void azL(String paramString)
  {
    AppMethodBeat.i(331475);
    s.u(paramString, "musicId");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.videoMusicId = paramString;
    }
    AppMethodBeat.o(331475);
  }
  
  public static void azM(String paramString)
  {
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.musicFeedId = paramString;
    }
  }
  
  public static void azN(String paramString)
  {
    AppMethodBeat.i(331495);
    s.u(paramString, "followId");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.followSoundTrackId = paramString;
    }
    AppMethodBeat.o(331495);
  }
  
  public static void azO(String paramString)
  {
    AppMethodBeat.i(331508);
    s.u(paramString, "appId");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.forwardingAppId = paramString;
    }
    AppMethodBeat.o(331508);
  }
  
  public static void azQ(String paramString)
  {
    AppMethodBeat.i(331572);
    Log.i(TAG, s.X("setColorSpace ", paramString));
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.originColorSpace = paramString;
    }
    AppMethodBeat.o(331572);
  }
  
  public static void azR(String paramString)
  {
    AppMethodBeat.i(331585);
    s.u(paramString, "clickId");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.clickId = paramString;
    }
    AppMethodBeat.o(331585);
  }
  
  private static JSONObject b(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    AppMethodBeat.i(331656);
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramInt);
      label27:
      AppMethodBeat.o(331656);
      return localJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      break label27;
    }
  }
  
  private static void b(FinderItem paramFinderItem, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(178388);
    Object localObject1 = "";
    Object localObject3 = (Iterable)paramFinderItem.getMediaList();
    Object localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    int i = 0;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (dji)((Iterator)localObject3).next();
      localObject1 = (String)localObject1 + ((dji)localObject4).mediaType + ';' + ((dji)localObject4).videoDuration + '#';
      if (Util.isNullOrNil(((dji)localObject4).coverUrl)) {}
      for (i = 0;; i = 1)
      {
        ((Collection)localObject2).add(ah.aiuX);
        break;
      }
    }
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    int j;
    label225:
    long l;
    if (localFinderFeedReportObject != null)
    {
      localObject4 = new fo();
      ((fo)localObject4).pW(localFinderFeedReportObject.sessionId);
      ((fo)localObject4).iHU = localFinderFeedReportObject.enterScene;
      if (!paramBoolean) {
        break label1031;
      }
      j = 1;
      ((fo)localObject4).iHV = j;
      if (((fo)localObject4).iHV == 1)
      {
        localObject2 = FrO;
        if (localObject2 != null) {
          break label1036;
        }
        localObject2 = null;
        ((fo)localObject4).qq((String)localObject2);
      }
      localObject2 = z.FrZ;
      ((fo)localObject4).pX(z.pL(paramFinderItem.getId()));
      ((fo)localObject4).qo(com.tencent.mm.ae.d.hF(localFinderFeedReportObject.draftId));
      ((fo)localObject4).iIR = localFinderFeedReportObject.draftType;
      ((fo)localObject4).iHW = localFinderFeedReportObject.exitPageId;
      ((fo)localObject4).iHX = localFinderFeedReportObject.enterTakePhotoTime;
      ((fo)localObject4).iHY = localFinderFeedReportObject.enterVideoEditTime;
      ((fo)localObject4).iHZ = localFinderFeedReportObject.sendOrExitButtonTime;
      ((fo)localObject4).iIa = localFinderFeedReportObject.videoRecordTime;
      ((fo)localObject4).iHM = localFinderFeedReportObject.videoSource;
      ((fo)localObject4).iIb = localFinderFeedReportObject.videoEmojiCount;
      ((fo)localObject4).iIc = localFinderFeedReportObject.videoWordingCount;
      localObject3 = localFinderFeedReportObject.videoMusicId;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((fo)localObject4).pY((String)localObject2);
      ((fo)localObject4).iIe = localFinderFeedReportObject.videoMusicIndex;
      ((fo)localObject4).itK = localFinderFeedReportObject.videoMusicSearch;
      ((fo)localObject4).iIf = localFinderFeedReportObject.videoPostType;
      ((fo)localObject4).pZ((String)localObject1);
      ((fo)localObject4).ixn = localFinderFeedReportObject.existDesc;
      ((fo)localObject4).iIh = localFinderFeedReportObject.descCount;
      localObject2 = localFinderFeedReportObject.actionTrace;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((fo)localObject4).qa((String)localObject1);
      ((fo)localObject4).iIj = localFinderFeedReportObject.lbsFlag;
      localObject2 = localFinderFeedReportObject.link;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((fo)localObject4).qb((String)localObject1);
      ((fo)localObject4).iIk = localFinderFeedReportObject.draft;
      localObject1 = as.GiG;
      ((fo)localObject4).qc(n.bV(as.F(paramFinderItem), ",", ";"));
      ((fo)localObject4).qd("");
      if (!BuildInfo.DEBUG) {
        break label1046;
      }
      l = 0L;
      label574:
      ((fo)localObject4).iwf = l;
      ((fo)localObject4).iIq = localFinderFeedReportObject.mentionCount;
      ((fo)localObject4).iIr = localFinderFeedReportObject.clickMentionCount;
      ((fo)localObject4).iIs = localFinderFeedReportObject.clickSucMentionCount;
      ((fo)localObject4).iIt = localFinderFeedReportObject.mentionRepeatCount;
      ((fo)localObject4).qe("");
      ((fo)localObject4).iIp = i;
      ((fo)localObject4).qm(localFinderFeedReportObject.forwardingAppId);
      ((fo)localObject4).qn(localFinderFeedReportObject.topicActivityId);
      ((fo)localObject4).iIO = localFinderFeedReportObject.topicActivityType;
      localObject1 = b(b(b(b(b(null, "IsMultiShot", localFinderFeedReportObject.isMultiShot), "MultiShotChangeCnt", localFinderFeedReportObject.multiShotChangeCnt), "MultiShotClickCnt", localFinderFeedReportObject.multiShotClickCnt), "MultiShotSuccessCnt", localFinderFeedReportObject.multiShotSuccessCnt), "MultiShotVideoCnt", localFinderFeedReportObject.multiShotVideoCnt).toString();
      s.s(localObject1, "recordInfo.toString()");
      ((fo)localObject4).qf(n.bV((String)localObject1, ",", ";"));
      ((fo)localObject4).iIv = localFinderFeedReportObject.videoSubType;
      ((fo)localObject4).qg(localFinderFeedReportObject.postId);
      ((fo)localObject4).qh(localFinderFeedReportObject.editId);
      ((fo)localObject4).qr(localFinderFeedReportObject.originColorSpace);
      ((fo)localObject4).qj(localFinderFeedReportObject.clickId);
      localObject1 = paramFinderItem.getLocation();
      if (localObject1 != null)
      {
        localObject2 = av.GiL;
        ((fo)localObject4).qi(av.cn(((boi)localObject1).city, ((boi)localObject1).poiName));
      }
      ((fo)localObject4).iIx = localFinderFeedReportObject.remuxType;
      ((fo)localObject4).iIG = localFinderFeedReportObject.musicType;
      ((fo)localObject4).ql(localFinderFeedReportObject.followSoundTrackId);
      ((fo)localObject4).iIH = localFinderFeedReportObject.soundTrackType;
      ((fo)localObject4).qp(localFinderFeedReportObject.musicFeedId);
      localObject1 = paramFinderItem.getMegaVideo();
      if (localObject1 != null)
      {
        ((fo)localObject4).qk(com.tencent.mm.ae.d.hF(((dne)localObject1).id));
        localObject2 = ((dne)localObject1).aaUt;
        if (localObject2 != null) {
          break label1054;
        }
        i = 0;
        label942:
        ((fo)localObject4).iID = i;
        localObject2 = (dji)p.oL((List)paramFinderItem.getMediaList());
        if (localObject2 != null) {
          break label1103;
        }
        i = 0;
        label971:
        ((fo)localObject4).iIE = i;
        localObject1 = ((dne)localObject1).aaUt;
        if (localObject1 != null) {
          break label1112;
        }
        i = k;
      }
    }
    for (;;)
    {
      ((fo)localObject4).iIF = i;
      ((fo)localObject4).bMH();
      localObject1 = z.FrZ;
      z.a((com.tencent.mm.plugin.report.a)localObject4);
      c(paramFinderItem, paramBoolean);
      AppMethodBeat.o(178388);
      return;
      label1031:
      j = 0;
      break;
      label1036:
      localObject2 = ((FinderFeedReportObject)localObject2).activeInfo;
      break label225;
      label1046:
      l = FrP;
      break label574;
      label1054:
      localObject2 = ((dnh)localObject2).media;
      if (localObject2 == null)
      {
        i = 0;
        break label942;
      }
      localObject2 = (dnv)p.oL((List)localObject2);
      if (localObject2 == null)
      {
        i = 0;
        break label942;
      }
      i = ((dnv)localObject2).aaUX;
      break label942;
      label1103:
      i = ((dji)localObject2).fileSize;
      break label971;
      label1112:
      localObject1 = ((dnh)localObject1).media;
      i = k;
      if (localObject1 != null)
      {
        localObject1 = (dnv)p.oL((List)localObject1);
        i = k;
        if (localObject1 != null) {
          i = ((dnv)localObject1).fileSize;
        }
      }
    }
  }
  
  public static void b(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(331551);
    s.u(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    Object localObject;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.videoMusicId = String.valueOf(paramRecordMediaReportInfo.J("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0)));
      localObject = paramRecordMediaReportInfo.J("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
      localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
      localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
      localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
      localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
      s.s(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
      localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
      localObject = paramRecordMediaReportInfo.J("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…EY_VIDEO_SUB_TYPE_INT, 0)");
      localFinderFeedReportObject.videoSubType = ((Number)localObject).intValue();
      localFinderFeedReportObject.postId = ((String)paramRecordMediaReportInfo.J("KEY_MULTI_MEDIA_POST_ID_STRING", ""));
      localFinderFeedReportObject.editId = ((String)paramRecordMediaReportInfo.J("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      localObject = paramRecordMediaReportInfo.J("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
      s.s(localObject, "reportInfo.getReportValu…UB_RECORD_BOOLEAN, false)");
      if (!((Boolean)localObject).booleanValue()) {
        break label415;
      }
    }
    label415:
    for (int i = 1;; i = 0)
    {
      localFinderFeedReportObject.isMultiShot = i;
      localObject = paramRecordMediaReportInfo.J("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…GE_SUB_RECORD_TAB_INT, 0)");
      localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…IDEO_RECORD_CLICK_INT, 0)");
      localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.J("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
      s.s(localObject, "reportInfo.getReportValu…EO_RECORD_SUCCESS_INT, 0)");
      localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
      paramRecordMediaReportInfo = paramRecordMediaReportInfo.J("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
      s.s(paramRecordMediaReportInfo, "reportInfo.getReportValu…KEY_SUB_VIDEO_NUM_INT, 0)");
      localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
      AppMethodBeat.o(331551);
      return;
    }
  }
  
  public static void be(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(331594);
    s.u(paramJSONObject, "activeId");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null)
    {
      paramJSONObject = paramJSONObject.toString();
      s.s(paramJSONObject, "activeId.toString()");
      localFinderFeedReportObject.activeInfo = n.m(paramJSONObject, ",", ";", false);
    }
    AppMethodBeat.o(331594);
  }
  
  private static void c(FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(166574);
    s.u(paramFinderItem, "finderItem");
    Log.i(TAG, "report19086 localId:" + paramFinderItem.getLocalId() + ", " + paramBoolean);
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject == null)
    {
      Log.e(TAG, "report19086, feedReportObj is null");
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1253L, 38L, 1L, false);
      AppMethodBeat.o(166574);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eQB().bmg()).intValue() != 0)
    {
      AppMethodBeat.o(166574);
      return;
    }
    if (!paramBoolean) {
      switch (localFinderFeedReportObject.postStage)
      {
      default: 
        Log.w(TAG, s.X("postStage range error, ", Integer.valueOf(localFinderFeedReportObject.postStage)));
        localObject1 = ah.aiuX;
      }
    }
    int m;
    boolean bool;
    int n;
    int i1;
    int i2;
    int i3;
    long l;
    int k;
    int j;
    Object localObject5;
    int i4;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      m = h(paramFinderItem);
      bool = paramFinderItem.isLongVideo();
      n = localFinderFeedReportObject.uploadCost;
      i1 = localFinderFeedReportObject.mediaProcessCost;
      i2 = localFinderFeedReportObject.postTaskCost;
      i3 = localFinderFeedReportObject.clickRepostCount;
      l = localFinderFeedReportObject.uploadMediaTotalSize;
      k = 0;
      j = 0;
      i = 0;
      localObject5 = new ArrayList();
      i4 = CdnLogic.getRecentAverageSpeed(1);
      localObject4 = new JSONObject();
      ((ArrayList)localObject5).addAll((Collection)localFinderFeedReportObject.mediaList);
      if (paramBoolean) {
        break label581;
      }
      ((ArrayList)localObject5).addAll((Collection)localFinderFeedReportObject.mediaList);
      localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ((dji)((Iterator)localObject1).next()).aaPt;
        j = i;
        if (localObject3 != null)
        {
          if (((FinderMediaReportObject)localObject3).cdnUploadRetCode != 0)
          {
            ((ArrayList)localObject5).add(localObject3);
            i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
          }
          localObject3 = ah.aiuX;
          localObject3 = ah.aiuX;
          j = i;
        }
        i = j;
      }
      ((c)com.tencent.mm.kernel.h.az(c.class)).publishStatApi().tn(paramFinderItem.isLongVideo());
      localObject1 = ah.aiuX;
      continue;
      ((c)com.tencent.mm.kernel.h.az(c.class)).publishStatApi().to(paramFinderItem.isLongVideo());
      localObject1 = ah.aiuX;
      continue;
      ((c)com.tencent.mm.kernel.h.az(c.class)).publishStatApi().tp(paramFinderItem.isLongVideo());
      localObject1 = ah.aiuX;
      continue;
      ((c)com.tencent.mm.kernel.h.az(c.class)).publishStatApi().tq(paramFinderItem.isLongVideo());
      localObject1 = ah.aiuX;
    }
    localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject3 = ((dji)((Iterator)localObject1).next()).aaPt;
      if (localObject3 != null)
      {
        if (((FinderMediaReportObject)localObject3).cdnUploadRetCode != 0)
        {
          ((ArrayList)localObject5).add(localObject3);
          i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
        }
        localObject3 = ah.aiuX;
        localObject3 = ah.aiuX;
      }
    }
    label581:
    localObject1 = ((Iterable)localObject5).iterator();
    int i = k;
    if (((Iterator)localObject1).hasNext())
    {
      localObject3 = (FinderMediaReportObject)((Iterator)localObject1).next();
      localObject4 = new JSONObject();
      com.tencent.mm.ae.f.a(localObject3, (JSONObject)localObject4);
      if (i != 0) {
        break label1998;
      }
      if (((FinderMediaReportObject)localObject3).zipTime > 0) {}
      for (i = 1;; i = 0) {
        break;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZS, "");
        if (!(localObject1 instanceof String)) {
          continue;
        }
        localObject1 = (String)localObject1;
      }
      finally
      {
        Object localObject6;
        String str;
        int i5;
        int i6;
        int i7;
        StringBuilder localStringBuilder;
        Log.printErrStackTrace(TAG, localThrowable, "mediaInfoJson put snn", new Object[0]);
        continue;
        if (!Util.isNullOrNil(localThrowable.aaPd)) {
          continue;
        }
        localObject2 = s.X(localThrowable.url, Util.nullAsNil(localThrowable.url_token));
        if (localObject2 != null) {
          continue;
        }
        localObject3 = "";
        continue;
        localObject2 = ((dji)localObject2).aaPd;
        continue;
        localObject3 = localObject2;
        continue;
        localObject2 = (dji)p.oL((List)localObject2);
        if (localObject2 != null) {
          continue;
        }
        localObject2 = null;
        continue;
        if (!Util.isNullOrNil(((dji)localObject2).aaPd)) {
          continue;
        }
        localObject2 = s.X(((dji)localObject2).url, Util.nullAsNil(((dji)localObject2).url_token));
        continue;
        localObject2 = ((dji)localObject2).aaPd;
        continue;
        localObject2 = "";
        continue;
        if (((FinderMediaReportObject)localObject4).mediaType != 4) {
          continue;
        }
        localObject4 = ((FinderMediaReportObject)p.oK((List)localObject5)).multiMediaInfo;
        s.s(localObject4, "mediaReportList.first().multiMediaInfo");
        localObject5 = hr((List)localObject4);
        localObject4 = localObject5;
        if (localObject5 != null) {
          continue;
        }
        localObject4 = "";
        continue;
        localObject5 = "";
        continue;
        k = 0;
        continue;
        k = 0;
        continue;
        localObject4 = Integer.valueOf(0);
        continue;
        i = 0;
        continue;
        paramFinderItem = Integer.valueOf(0);
        continue;
        i = 2;
        continue;
      }
      ((JSONObject)localObject4).put("snn", localObject3);
      localObject1 = (dji)p.oL((List)paramFinderItem.getMediaList());
      if (localObject1 != null)
      {
        localObject1 = ((dji)localObject1).codec_info;
        if (localObject1 != null)
        {
          ((JSONObject)localObject4).put("codecInfo", "video_score:" + ((boy)localObject1).ZXq + ",video_cover_score:" + ((boy)localObject1).ZXr + ",video_audio_score:" + ((boy)localObject1).ZXs + ",thumb_score:" + ((boy)localObject1).ZXt + ",hdimg_score:" + ((boy)localObject1).ZXu + ",has_stickers:" + ((boy)localObject1).ZXv);
          localObject1 = ah.aiuX;
        }
      }
      localObject1 = (dji)p.oL((List)paramFinderItem.getMediaList());
      if (localObject1 == null)
      {
        localObject3 = "";
        if (!bool) {
          continue;
        }
        localObject1 = paramFinderItem.getLongVideoMediaList();
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        localObject4 = ((JSONObject)localObject4).toString();
        s.s(localObject4, "mediaInfoJson.toString()");
        localObject6 = n.bV((String)localObject4, ",", ";");
        localObject4 = (FinderMediaReportObject)p.oL((List)localObject5);
        if (localObject4 != null) {
          continue;
        }
        localObject4 = "";
        str = n.bV((String)localObject4, ",", ";");
        i5 = localFinderFeedReportObject.dumpCgiErrorCode;
        i6 = localFinderFeedReportObject.dumpCgiErrorType;
        i7 = localFinderFeedReportObject.sdkShareType;
        localObject4 = paramFinderItem.getFeedObject().objectDesc;
        if (localObject4 == null) {
          continue;
        }
        localObject4 = ((FinderObjectDesc)localObject4).event;
        if ((localObject4 == null) || (((brg)localObject4).ocD != 0L)) {
          continue;
        }
        k = 1;
        if (k != 0) {
          continue;
        }
        k = 1;
        Log.i(TAG, "19086, sdkShareType:" + i7 + ", isActivityEvent:" + k + ", dumpCgiErrorType:" + i6 + ", dumpCgiErrorCode:" + i5);
        Log.i(TAG, s.X("waitingPostCount: ", Integer.valueOf(localFinderFeedReportObject.waitingPostCount)));
        localObject5 = new StringBuilder();
        localStringBuilder = ((StringBuilder)localObject5).append(localFinderFeedReportObject.enterScene).append(',').append(localFinderFeedReportObject.sessionId).append(',');
        if (!paramBoolean) {
          continue;
        }
        localObject4 = z.FrZ;
        localObject4 = z.pL(paramFinderItem.getId());
        localObject4 = localStringBuilder.append(localObject4).append(',').append(localFinderFeedReportObject.videoSource).append(',').append(cn.bDw() - localFinderFeedReportObject.sendOrExitButtonTime).append(',').append(i).append(',').append(n).append(',').append("").append(',');
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        ((StringBuilder)localObject4).append(i).append(',').append(i1).append(',').append(FrQ).append(',').append(j);
        localObject4 = ((StringBuilder)localObject5).append(',').append(NetStatusUtil.getNetTypeString(MMApplicationContext.getContext())).append(',').append(localFinderFeedReportObject.retryCount).append(',').append(i4).append(',').append((String)localObject6).append(',').append(localFinderFeedReportObject.videoPostType).append(',').append(localFinderFeedReportObject.uploadLogicError).append(',').append(localFinderFeedReportObject.postStage).append(',').append(str).append(',');
        if (!paramBoolean) {
          continue;
        }
        localObject6 = z.FrZ;
        paramFinderItem = z.pL(paramFinderItem.getId());
        ((StringBuilder)localObject4).append(paramFinderItem).append(',').append(localFinderFeedReportObject.cgiErrorCode).append(',').append(localFinderFeedReportObject.cgiErrorType).append(',');
        paramFinderItem = ((StringBuilder)localObject5).append((String)localObject3).append(',');
        if (!bool) {
          continue;
        }
        i = 1;
        paramFinderItem.append(i).append(',').append(localObject1).append(',').append(localFinderFeedReportObject.megaCgiErrorCode).append(',').append(localFinderFeedReportObject.megaCgiErrorType).append(',').append(localFinderFeedReportObject.longVideoSizeInvalid).append(',').append(i2).append(',').append(i3).append(',').append(l).append(',').append(i5).append(',').append(i6).append(',').append(i7);
        ((StringBuilder)localObject5).append(',').append(k).append(',').append(m).append(',').append(localFinderFeedReportObject.fromDraft).append(',').append(localFinderFeedReportObject.mpError).append(',').append(localFinderFeedReportObject.waitingPostCount).append(',').append(localFinderFeedReportObject.editId);
        paramFinderItem = ((StringBuilder)localObject5).toString();
        Log.i(TAG, s.X("19086 ", paramFinderItem));
        Log.i(TAG, "FinderPostCostTime, taskCostTime:" + i2 + ", cdnUploadTime:" + n + ", remuxTime:" + i1 + ", fromDraft:" + localFinderFeedReportObject.fromDraft);
        com.tencent.mm.plugin.report.f.Ozc.kvStat(19086, paramFinderItem);
        AppMethodBeat.o(166574);
        return;
        localObject1 = null;
        break label2001;
      }
      label1998:
      break;
      label2001:
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = "";
      }
    }
  }
  
  public static void eG(String paramString, int paramInt)
  {
    AppMethodBeat.i(331505);
    s.u(paramString, "topicId");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.topicActivityId = paramString;
      localFinderFeedReportObject.topicActivityType = paramInt;
    }
    AppMethodBeat.o(331505);
  }
  
  public static FinderFeedReportObject eMS()
  {
    return FrO;
  }
  
  public static FinderFeedReportObject eMT()
  {
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    FrO = null;
    return localFinderFeedReportObject;
  }
  
  public static r eMU()
  {
    return BuC;
  }
  
  public static void f(ArrayList<djg> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331524);
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null)
    {
      if (paramArrayList != null)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str2 = ((djg)localIterator.next()).username;
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
      if (paramArrayList != null) {
        break label123;
      }
    }
    label123:
    for (paramInt1 = 0;; paramInt1 = paramArrayList.size())
    {
      localFinderFeedReportObject.mentionRepeatCount = paramInt1;
      AppMethodBeat.o(331524);
      return;
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static int h(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(331679);
    s.u(paramFinderItem, "finderItem");
    if (paramFinderItem.isMvFeed())
    {
      AppMethodBeat.o(331679);
      return 1;
    }
    AppMethodBeat.o(331679);
    return 0;
  }
  
  public static String hr(List<? extends FinderMediaReportInfo> paramList)
  {
    AppMethodBeat.i(331736);
    s.u(paramList, "multiMediaInfo");
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
    s.s(paramList, "array.toString()");
    AppMethodBeat.o(331736);
    return paramList;
  }
  
  public static void i(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(331727);
    s.u(paramFinderItem, "finderItem");
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject == null)
    {
      Log.e(TAG, "report21666, feedReportObj is null");
      AppMethodBeat.o(331727);
      return;
    }
    fi localfi = new fi();
    localfi.iGY = paramFinderItem.getLocalId();
    localfi.iGZ = (cn.bDw() - localFinderFeedReportObject.sendOrExitButtonTime);
    localfi.iHa = localFinderFeedReportObject.uploadCost;
    localfi.iHc = localFinderFeedReportObject.mediaProcessCost;
    localfi.iwf = FrQ;
    localfi.ijV = localfi.F("NetType", NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()), true);
    localfi.iHe = localFinderFeedReportObject.retryCount;
    localfi.iHf = CdnLogic.getRecentAverageSpeed(1);
    localfi.iAB = localFinderFeedReportObject.videoPostType;
    localfi.iHh = localFinderFeedReportObject.postStage;
    localfi.iHr = paramFinderItem.getPostInfo().aaPw;
    boolean bool = paramFinderItem.isLongVideo();
    localfi.iHs = localFinderFeedReportObject.postTaskCost;
    localfi.iHt = localFinderFeedReportObject.clickRepostCount;
    localfi.iHu = localFinderFeedReportObject.uploadMediaTotalSize;
    Object localObject5 = new ArrayList();
    Object localObject4 = new JSONObject();
    int i = 0;
    ((ArrayList)localObject5).addAll((Collection)localFinderFeedReportObject.mediaList);
    ((ArrayList)localObject5).addAll((Collection)localFinderFeedReportObject.mediaList);
    Object localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
    int j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((dji)((Iterator)localObject1).next()).aaPt;
      j = i;
      if (localObject3 != null)
      {
        if (((FinderMediaReportObject)localObject3).cdnUploadRetCode != 0)
        {
          ((ArrayList)localObject5).add(localObject3);
          i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
        }
        localObject3 = ah.aiuX;
        localObject3 = ah.aiuX;
        j = i;
      }
      i = j;
    }
    localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((dji)((Iterator)localObject1).next()).aaPt;
      if (localObject3 != null)
      {
        if (((FinderMediaReportObject)localObject3).cdnUploadRetCode != 0)
        {
          ((ArrayList)localObject5).add(localObject3);
          i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
        }
        localObject3 = ah.aiuX;
        localObject3 = ah.aiuX;
      }
    }
    localfi.iHd = i;
    Object localObject3 = ((Iterable)localObject5).iterator();
    for (localObject1 = ""; ((Iterator)localObject3).hasNext(); localObject1 = s.X((String)localObject1, "#"))
    {
      FinderMediaReportObject localFinderMediaReportObject = (FinderMediaReportObject)((Iterator)localObject3).next();
      localObject4 = new JSONObject();
      com.tencent.mm.ae.f.a(localFinderMediaReportObject, (JSONObject)localObject4);
      Field[] arrayOfField1 = localFinderMediaReportObject.getClass().getDeclaredFields();
      s.s(arrayOfField1, "fields");
      i = 0;
      int m = arrayOfField1.length;
      while (i < m)
      {
        Field localField1 = arrayOfField1[i];
        i += 1;
        Object localObject6 = localField1.get(localFinderMediaReportObject);
        if (localObject6 == null) {
          break label1697;
        }
        if (((localObject6 instanceof Integer)) && (!s.p(localObject6, Integer.valueOf(0))))
        {
          localObject1 = (String)localObject1 + localField1.getName() + ':' + localObject6 + ';';
        }
        else
        {
          if ((localObject6 instanceof String))
          {
            if (((CharSequence)localObject6).length() > 0) {}
            for (j = 1;; j = 0)
            {
              if (j == 0) {
                break label683;
              }
              localObject1 = (String)localObject1 + localField1.getName() + ':' + localObject6 + ';';
              break;
            }
          }
          label683:
          if (!(localObject6 instanceof com.tencent.mm.bx.a)) {
            break label1697;
          }
          Field[] arrayOfField2 = localObject6.getClass().getDeclaredFields();
          s.s(arrayOfField2, "innerFields");
          j = 0;
          int n = arrayOfField2.length;
          label716:
          Field localField2;
          Object localObject7;
          for (;;)
          {
            if (j >= n) {
              break label1694;
            }
            localField2 = arrayOfField2[j];
            j += 1;
            localObject7 = localField2.get(localObject6);
            if ((!(localObject7 instanceof Integer)) || (s.p(localObject7, Integer.valueOf(0)))) {
              break;
            }
            localObject1 = (String)localObject1 + localField1.getName() + '-' + localField2.getName() + ':' + localObject7 + ';';
          }
          if (!(localObject7 instanceof String)) {
            break label1691;
          }
          if (((CharSequence)localObject7).length() > 0) {}
          for (int k = 1;; k = 0)
          {
            if (k == 0) {
              break label1691;
            }
            localObject1 = (String)localObject1 + localField1.getName() + '-' + localField2.getName() + ':' + localObject7 + ';';
            break;
          }
        }
      }
    }
    localfi.iHb = localfi.F("MediaInfo", (String)localObject1, true);
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZS, "");
        if (!(localObject1 instanceof String)) {
          continue;
        }
        localObject1 = (String)localObject1;
      }
      finally
      {
        Log.printErrStackTrace(TAG, localThrowable, "mediaInfoJson put snn", new Object[0]);
        continue;
        if (!Util.isNullOrNil(localThrowable.aaPd)) {
          continue;
        }
        localObject2 = s.X(localThrowable.url, Util.nullAsNil(localThrowable.url_token));
        if (localObject2 != null) {
          continue;
        }
        localObject3 = "";
        continue;
        localObject2 = ((dji)localObject2).aaPd;
        continue;
        localObject3 = localObject2;
        continue;
        localObject2 = (dji)p.oL((List)localObject2);
        if (localObject2 != null) {
          continue;
        }
        localObject2 = null;
        continue;
        if (!Util.isNullOrNil(((dji)localObject2).aaPd)) {
          continue;
        }
        localObject2 = s.X(((dji)localObject2).url, Util.nullAsNil(((dji)localObject2).url_token));
        continue;
        localObject2 = ((dji)localObject2).aaPd;
        continue;
        localObject2 = "";
        continue;
        if (((FinderMediaReportObject)localObject4).mediaType != 4) {
          continue;
        }
        localObject4 = ((FinderMediaReportObject)p.oK((List)localObject5)).multiMediaInfo;
        s.s(localObject4, "mediaReportList.first().multiMediaInfo");
        localObject5 = hr((List)localObject4);
        localObject4 = localObject5;
        if (localObject5 != null) {
          continue;
        }
        localObject4 = "";
        continue;
        localObject5 = "";
        continue;
        long l = 2L;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      ((JSONObject)localObject4).put("snn", localObject3);
      localObject1 = (dji)p.oL((List)paramFinderItem.getMediaList());
      if (localObject1 != null)
      {
        localObject1 = ((dji)localObject1).codec_info;
        if (localObject1 != null)
        {
          ((JSONObject)localObject4).put("codecInfo", "video_score:" + ((boy)localObject1).ZXq + ",video_cover_score:" + ((boy)localObject1).ZXr + ",video_audio_score:" + ((boy)localObject1).ZXs + ",thumb_score:" + ((boy)localObject1).ZXt + ",hdimg_score:" + ((boy)localObject1).ZXu + ",has_stickers:" + ((boy)localObject1).ZXv);
          localObject1 = ah.aiuX;
        }
      }
      localObject1 = (dji)p.oL((List)paramFinderItem.getMediaList());
      if (localObject1 == null)
      {
        localObject3 = "";
        if (!bool) {
          continue;
        }
        localObject1 = paramFinderItem.getLongVideoMediaList();
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        localObject4 = ((JSONObject)localObject4).toString();
        s.s(localObject4, "mediaInfoJson.toString()");
        localfi.iHg = localfi.F("mediaInfoJson", n.bV((String)localObject4, ",", ";"), true);
        localObject4 = (FinderMediaReportObject)p.oL((List)localObject5);
        if (localObject4 != null) {
          continue;
        }
        localObject4 = "";
        localfi.iHi = localfi.F("multiMediaInfo", n.bV((String)localObject4, ",", ";"), true);
        localfi.iHj = localFinderFeedReportObject.cgiErrorCode;
        localfi.iHk = localFinderFeedReportObject.cgiErrorType;
        localfi.iHl = localfi.F("firstUrl", (String)localObject3, true);
        if (!bool) {
          continue;
        }
        l = 1L;
        localfi.iHm = l;
        localfi.iHn = localfi.F("longVideoUrl", (String)localObject1, true);
        localfi.iHo = localFinderFeedReportObject.megaCgiErrorCode;
        localfi.iHp = localFinderFeedReportObject.megaCgiErrorType;
        localfi.iHq = localFinderFeedReportObject.longVideoSizeInvalid;
        localfi.iHv = localFinderFeedReportObject.dumpCgiErrorCode;
        localfi.iHw = localFinderFeedReportObject.dumpCgiErrorType;
        localfi.iHx = localFinderFeedReportObject.sdkShareType;
        paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
        if (paramFinderItem == null) {
          continue;
        }
        paramFinderItem = paramFinderItem.event;
        if ((paramFinderItem == null) || (paramFinderItem.ocD != 0L)) {
          continue;
        }
        i = 1;
        if (i != 0) {
          continue;
        }
        i = 1;
        localfi.iHy = i;
        localfi.bMH();
        paramFinderItem = z.FrZ;
        z.a((com.tencent.mm.plugin.report.a)localfi);
        AppMethodBeat.o(331727);
        return;
        localObject1 = null;
        break label1700;
      }
      label1691:
      break label716;
      label1694:
      break;
      label1697:
      break;
      label1700:
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = "";
      }
    }
  }
  
  public static void ib(String paramString1, String paramString2)
  {
    AppMethodBeat.i(331560);
    s.u(paramString1, "postId");
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.postId = paramString1;
      if (paramString2 != null) {
        localFinderFeedReportObject.editId = paramString2;
      }
    }
    AppMethodBeat.o(331560);
  }
  
  public static void m(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(331747);
    fl localfl = new fl();
    Object localObject = FrO;
    if (localObject != null)
    {
      localfl.iHK = localfl.F("PostId", ((FinderFeedReportObject)localObject).postId, true);
      localfl.iHL = localfl.F("EditId", ((FinderFeedReportObject)localObject).editId, true);
      localfl.iHM = ((FinderFeedReportObject)localObject).videoSource;
      localfl.iAH = paramInt;
      localfl.iHN = paramLong1;
      localfl.iHO = paramLong2;
      localfl.bMH();
      localObject = z.FrZ;
      z.a((com.tencent.mm.plugin.report.a)localfl);
    }
    AppMethodBeat.o(331747);
  }
  
  public static void pE(long paramLong)
  {
    FinderFeedReportObject localFinderFeedReportObject = FrO;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.draftId = ((int)paramLong);
    }
  }
  
  public static void pF(long paramLong)
  {
    AppMethodBeat.i(166572);
    Object localObject1 = e.FMN;
    localObject1 = e.a.jn(paramLong);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = m.TYW;
      localObject2 = ((FinderItem)localObject1).field_reportObject;
      if (localObject2 != null) {
        break label65;
      }
    }
    label65:
    for (paramLong = 0L;; paramLong = ((FinderFeedReportObject)localObject2).uploadCost)
    {
      m.wy(paramLong);
      localObject2 = m.TYW;
      m.hQB();
      b((FinderItem)localObject1, true);
      localObject2 = z.FrZ;
      z.k((FinderItem)localObject1);
      AppMethodBeat.o(166572);
      return;
    }
  }
  
  public static void pG(long paramLong)
  {
    AppMethodBeat.i(166573);
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject = d.a.qr(paramLong);
    if (localObject != null) {
      b((FinderItem)localObject, false);
    }
    AppMethodBeat.o(166573);
  }
  
  public static void r(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331666);
    Log.i(TAG, "savePostError " + paramLong + ", " + paramInt1 + ", " + paramInt2);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject1 = d.a.qr(paramLong);
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
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      d.a.v((FinderItem)localObject1);
    }
    AppMethodBeat.o(331666);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderPostReportLogic$postListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements r
  {
    public final void onPostEnd(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(166567);
      Object localObject = v.FrN;
      v.pG(paramLong);
      localObject = new jh();
      ((jh)localObject).hKS.localId = paramLong;
      ((jh)localObject).hKS.hKT = false;
      ((jh)localObject).publish();
      AppMethodBeat.o(166567);
    }
    
    public final void onPostNotify(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(331053);
      if (!paramBoolean)
      {
        jh localjh = new jh();
        localjh.hKS.localId = paramLong;
        localjh.hKS.hKT = false;
        localjh.publish();
      }
      AppMethodBeat.o(331053);
    }
    
    public final void onPostOk(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166568);
      Object localObject = v.FrN;
      v.pF(paramLong2);
      localObject = e.FMN;
      localObject = e.a.jn(paramLong2);
      if (localObject != null)
      {
        jh localjh = new jh();
        localjh.hKS.localId = paramLong1;
        localjh.hKS.hKT = true;
        jh.a locala = localjh.hKS;
        an.a locala1 = an.GhR;
        locala.hKU = an.a.d((FinderItem)localObject, true);
        localjh.publish();
      }
      AppMethodBeat.o(166568);
    }
    
    public final void onPostStart(long paramLong) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderFeedReportObject paramFinderFeedReportObject, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(boolean paramBoolean, FinderFeedReportObject paramFinderFeedReportObject, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.v
 * JD-Core Version:    0.7.0.1
 */