package com.tencent.mm.plugin.finder.report;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.ia.a;
import com.tencent.mm.g.b.a.dg;
import com.tencent.mm.g.b.a.di;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
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
import kotlin.n.n;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderPostReportLogic;", "", "()V", "InnerVersion19086", "", "getInnerVersion19086", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "_18939InnerVersion", "", "finderFeedReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "getFinderFeedReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "setFinderFeedReportObj", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;)V", "postListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "setPostListener", "(Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;)V", "buildMultiMediaJson", "multiMediaInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;", "finishEdit", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "finishTakePhoto", "getFeedReportType", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getReportInfoAndClear", "packageJson", "Lorg/json/JSONObject;", "jsonObject", "key", "value", "pickMedia", "mediaSource", "pickTopicActivity", "topicId", "topicType", "postExit", "pageId", "isSaveDraft", "", "report19086", "success", "report20949", "isExpose", "scene", "report21638", "deleteFlag", "mediaType", "picCnt", "videoLen", "report21666", "reportCurrentPost", "reportCurrentPostExit", "reportCurrentPostFail", "localId", "reportCurrentPostSuccess", "svrId", "saveMegaPostError", "errorType", "errorCode", "savePostError", "setAtData", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "clickMentionCount", "clickSucMentionCount", "setClickId", "clickId", "setDraftType", "draftType", "setFollowSoundTrack", "followId", "setFromAppId", "appId", "setMusicId", "musicId", "setMusicType", "type", "setPostId", "postId", "editId", "setRemuxType", "setSoundTrackType", "startPost", "entrance", "draft", "updateLBSFlag", "lbsFlag", "selectLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderPostReportLogic";
  private static FinderFeedReportObject vfk;
  private static final long vfl = 2L;
  private static com.tencent.mm.plugin.finder.upload.q vfm;
  private static final int vfn = 14;
  public static final i vfo;
  
  static
  {
    AppMethodBeat.i(166575);
    vfo = new i();
    TAG = "Finder.FinderPostReportLogic";
    vfl = 2L;
    vfm = (com.tencent.mm.plugin.finder.upload.q)new a();
    vfn = 14;
    AppMethodBeat.o(166575);
  }
  
  public static void Fa(long paramLong)
  {
    AppMethodBeat.i(166572);
    Object localObject = com.tencent.mm.plugin.finder.storage.data.e.vFX;
    localObject = e.a.Fy(paramLong);
    if (localObject != null)
    {
      a((FinderItem)localObject, true);
      k localk = k.vfA;
      k.g((FinderItem)localObject);
      AppMethodBeat.o(166572);
      return;
    }
    AppMethodBeat.o(166572);
  }
  
  public static void Fb(long paramLong)
  {
    AppMethodBeat.i(166573);
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    localObject = c.a.FS(paramLong);
    if (localObject != null)
    {
      a((FinderItem)localObject, false);
      AppMethodBeat.o(166573);
      return;
    }
    AppMethodBeat.o(166573);
  }
  
  public static void H(boolean paramBoolean, int paramInt)
  {
    int m = 2;
    int n = 1;
    AppMethodBeat.i(250619);
    Object localObject1 = z.aUg();
    p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    Object localObject2;
    int j;
    label147:
    int k;
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      localObject1 = new StringBuilder();
      p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
      localObject1 = com.tencent.mm.kernel.a.ayV() + '_' + Util.nowMilliSecond();
      localObject2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
      if (((PluginFinder)localObject2).getRedDotManager().asW("TLPostCamera") == null)
      {
        localObject2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)localObject2).getRedDotManager().asW("TLCamera") == null) {
          break label231;
        }
      }
      j = 1;
      localObject2 = h.CyF;
      if (!paramBoolean) {
        break label236;
      }
      k = 1;
      label159:
      if (i != 0) {
        m = 1;
      }
      if (j == 0) {
        break label242;
      }
    }
    label231:
    label236:
    label242:
    for (int i = n;; i = 0)
    {
      ((h)localObject2).a(20949, new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(i) });
      AppMethodBeat.o(250619);
      return;
      i = 0;
      break;
      j = 0;
      break label147;
      k = 2;
      break label159;
    }
  }
  
  public static void Ko(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.soundTrackType = paramInt;
    }
  }
  
  public static void Kp(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.musicType = paramInt;
    }
  }
  
  public static void Kq(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.draftType = paramInt;
    }
  }
  
  public static void Kr(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.videoSource = paramInt;
    }
  }
  
  public static void a(int paramInt, axt paramaxt)
  {
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.lbsFlag = paramInt;
      localFinderFeedReportObject.selectLocation = paramaxt;
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
      localObject4 = (cjl)((Iterator)localObject3).next();
      localObject1 = (String)localObject1 + ((cjl)localObject4).mediaType + ';' + ((cjl)localObject4).videoDuration + '#';
      if (Util.isNullOrNil(((cjl)localObject4).coverUrl)) {}
      for (i = 0;; i = 1)
      {
        ((Collection)localObject2).add(x.SXb);
        break;
      }
    }
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    long l;
    if (localFinderFeedReportObject != null)
    {
      localObject4 = new dl();
      ((dl)localObject4).oM(localFinderFeedReportObject.sessionId);
      ((dl)localObject4).kS(localFinderFeedReportObject.enterScene);
      if (!paramBoolean) {
        break label1066;
      }
      ((dl)localObject4).kT(j);
      localObject2 = k.vfA;
      ((dl)localObject4).oN(k.Fg(paramFinderItem.getId()));
      ((dl)localObject4).kU(localFinderFeedReportObject.exitPageId);
      ((dl)localObject4).jJ(localFinderFeedReportObject.enterTakePhotoTime);
      ((dl)localObject4).jK(localFinderFeedReportObject.enterVideoEditTime);
      ((dl)localObject4).jL(localFinderFeedReportObject.sendOrExitButtonTime);
      ((dl)localObject4).jM(localFinderFeedReportObject.videoRecordTime);
      ((dl)localObject4).jN(localFinderFeedReportObject.videoSource);
      ((dl)localObject4).jO(localFinderFeedReportObject.videoEmojiCount);
      ((dl)localObject4).jP(localFinderFeedReportObject.videoWordingCount);
      localObject3 = localFinderFeedReportObject.videoMusicId;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((dl)localObject4).oO((String)localObject2);
      ((dl)localObject4).jQ(localFinderFeedReportObject.videoMusicIndex);
      ((dl)localObject4).jR(localFinderFeedReportObject.videoMusicSearch);
      ((dl)localObject4).jS(localFinderFeedReportObject.videoPostType);
      ((dl)localObject4).oP((String)localObject1);
      ((dl)localObject4).jT(localFinderFeedReportObject.existDesc);
      ((dl)localObject4).jU(localFinderFeedReportObject.descCount);
      localObject2 = localFinderFeedReportObject.actionTrace;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((dl)localObject4).oQ((String)localObject1);
      ((dl)localObject4).jV(localFinderFeedReportObject.lbsFlag);
      localObject2 = localFinderFeedReportObject.link;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((dl)localObject4).oR((String)localObject1);
      ((dl)localObject4).jW(localFinderFeedReportObject.draft);
      localObject1 = w.vXp;
      ((dl)localObject4).oS(n.j(w.z(paramFinderItem), ",", ";", false));
      ((dl)localObject4).oT("");
      if (!BuildInfo.DEBUG) {
        break label1071;
      }
      l = 0L;
      label536:
      ((dl)localObject4).jX(l);
      ((dl)localObject4).kW(localFinderFeedReportObject.mentionCount);
      ((dl)localObject4).jY(localFinderFeedReportObject.clickMentionCount);
      ((dl)localObject4).jZ(localFinderFeedReportObject.clickSucMentionCount);
      ((dl)localObject4).ka(localFinderFeedReportObject.mentionRepeatCount);
      ((dl)localObject4).oU("");
      ((dl)localObject4).kV(i);
      ((dl)localObject4).pc(localFinderFeedReportObject.forwardingAppId);
      ((dl)localObject4).pd(localFinderFeedReportObject.topicActivityId);
      ((dl)localObject4).ki(localFinderFeedReportObject.topicActivityType);
      localObject1 = b(b(b(b(b(null, "IsMultiShot", localFinderFeedReportObject.isMultiShot), "MultiShotChangeCnt", localFinderFeedReportObject.multiShotChangeCnt), "MultiShotClickCnt", localFinderFeedReportObject.multiShotClickCnt), "MultiShotSuccessCnt", localFinderFeedReportObject.multiShotSuccessCnt), "MultiShotVideoCnt", localFinderFeedReportObject.multiShotVideoCnt).toString();
      p.g(localObject1, "recordInfo.toString()");
      ((dl)localObject4).oV(n.j((String)localObject1, ",", ";", false));
      ((dl)localObject4).kb(localFinderFeedReportObject.videoSubType);
      ((dl)localObject4).oW(localFinderFeedReportObject.postId);
      ((dl)localObject4).oX(localFinderFeedReportObject.editId);
      ((dl)localObject4).oZ(localFinderFeedReportObject.clickId);
      localObject1 = paramFinderItem.getLocation();
      if (localObject1 != null)
      {
        localObject2 = y.vXH;
        ((dl)localObject4).oY(y.hg(((axt)localObject1).fuK, ((axt)localObject1).kHV));
      }
      ((dl)localObject4).kc(localFinderFeedReportObject.remuxType);
      ((dl)localObject4).kg(localFinderFeedReportObject.musicType);
      ((dl)localObject4).pb(localFinderFeedReportObject.followSoundTrackId);
      ((dl)localObject4).kh(localFinderFeedReportObject.soundTrackType);
      localObject1 = paramFinderItem.getMegaVideo();
      if (localObject1 != null)
      {
        ((dl)localObject4).pa(d.zs(((cng)localObject1).id));
        localObject2 = ((cng)localObject1).MtG;
        if (localObject2 == null) {
          break label1079;
        }
        localObject2 = ((cnl)localObject2).media;
        if (localObject2 == null) {
          break label1079;
        }
        localObject2 = (cod)j.kt((List)localObject2);
        if (localObject2 == null) {
          break label1079;
        }
        i = ((cod)localObject2).Mur;
        label928:
        ((dl)localObject4).kd(i);
        localObject2 = (cjl)j.kt((List)paramFinderItem.getMediaList());
        if (localObject2 == null) {
          break label1084;
        }
      }
    }
    label1066:
    label1071:
    label1079:
    label1084:
    for (i = ((cjl)localObject2).fileSize;; i = 0)
    {
      ((dl)localObject4).ke(i);
      localObject1 = ((cng)localObject1).MtG;
      i = k;
      if (localObject1 != null)
      {
        localObject1 = ((cnl)localObject1).media;
        i = k;
        if (localObject1 != null)
        {
          localObject1 = (cod)j.kt((List)localObject1);
          i = k;
          if (localObject1 != null) {
            i = ((cod)localObject1).fileSize;
          }
        }
      }
      ((dl)localObject4).kf(i);
      ((dl)localObject4).bfK();
      localObject1 = k.vfA;
      k.a((com.tencent.mm.plugin.report.a)localObject4);
      b(paramFinderItem, paramBoolean);
      AppMethodBeat.o(178388);
      return;
      j = 0;
      break;
      l = vfl;
      break label536;
      i = 0;
      break label928;
    }
  }
  
  public static void a(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    int j = 1;
    AppMethodBeat.i(250608);
    p.h(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      Object localObject = paramRecordMediaReportInfo.y("KEY_RECORD_IS_BEAUTIFY", Boolean.FALSE);
      p.g(localObject, "reportInfo.getReportValu…ECORD_IS_BEAUTIFY, false)");
      if (((Boolean)localObject).booleanValue())
      {
        i = 1;
        localFinderFeedReportObject.isBeauty = i;
        localObject = paramRecordMediaReportInfo.y("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
        p.g(localObject, "reportInfo.getReportValu…DIA_DURATION_MS_LONG, 0L)");
        localFinderFeedReportObject.videoRecordTime = ((Number)localObject).longValue();
        localFinderFeedReportObject.videoSource = (((Number)paramRecordMediaReportInfo.y("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
        localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.y("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
        localObject = paramRecordMediaReportInfo.y("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
        localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.y("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
        localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.y("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
        localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.y("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
        localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.y("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
        p.g(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.y("KEY_ENTER_TIME_MS_LONG", Long.valueOf(0L));
        p.g(localObject, "reportInfo.getReportValu…Y_ENTER_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterTakePhotoTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.y("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
        p.g(localObject, "reportInfo.getReportValu…UB_RECORD_BOOLEAN, false)");
        if (!((Boolean)localObject).booleanValue()) {
          break label518;
        }
      }
      label518:
      for (int i = j;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.y("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValu…GE_SUB_RECORD_TAB_INT, 0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.y("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValu…IDEO_RECORD_CLICK_INT, 0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.y("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValu…EO_RECORD_SUCCESS_INT, 0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.y("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        p.g(paramRecordMediaReportInfo, "reportInfo.getReportValu…KEY_SUB_VIDEO_NUM_INT, 0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(250608);
        return;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(250608);
  }
  
  public static void as(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(250602);
    vfk = new FinderFeedReportObject();
    if (paramBoolean)
    {
      localFinderFeedReportObject = vfk;
      if (localFinderFeedReportObject != null)
      {
        d.c(TAG, (kotlin.g.a.a)new c(localFinderFeedReportObject, paramBoolean, paramInt));
        AppMethodBeat.o(250602);
        return;
      }
      AppMethodBeat.o(250602);
      return;
    }
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.sessionId = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      localFinderFeedReportObject.enterScene = paramInt;
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localFinderFeedReportObject.draft = paramInt;
        AppMethodBeat.o(250602);
        return;
      }
    }
    AppMethodBeat.o(250602);
  }
  
  public static void at(int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(250613);
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.exitPageId = paramInt;
      if (paramInt == 4) {
        localFinderFeedReportObject.sendOrExitButtonTime = cl.aWA();
      }
      localFinderFeedReportObject = vfk;
      if (localFinderFeedReportObject != null) {
        d.c(TAG, (kotlin.g.a.a)new b(localFinderFeedReportObject, paramBoolean));
      }
      vfk = null;
      AppMethodBeat.o(250613);
      return;
    }
    AppMethodBeat.o(250613);
  }
  
  public static void auE(String paramString)
  {
    AppMethodBeat.i(250603);
    p.h(paramString, "musicId");
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.videoMusicId = paramString;
      AppMethodBeat.o(250603);
      return;
    }
    AppMethodBeat.o(250603);
  }
  
  public static void auF(String paramString)
  {
    AppMethodBeat.i(250604);
    p.h(paramString, "followId");
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.followSoundTrackId = paramString;
      AppMethodBeat.o(250604);
      return;
    }
    AppMethodBeat.o(250604);
  }
  
  public static void auG(String paramString)
  {
    AppMethodBeat.i(250606);
    p.h(paramString, "appId");
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.forwardingAppId = paramString;
      AppMethodBeat.o(250606);
      return;
    }
    AppMethodBeat.o(250606);
  }
  
  public static void auI(String paramString)
  {
    AppMethodBeat.i(250612);
    p.h(paramString, "clickId");
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.clickId = paramString;
      AppMethodBeat.o(250612);
      return;
    }
    AppMethodBeat.o(250612);
  }
  
  private static JSONObject b(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    AppMethodBeat.i(250615);
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramInt);
      label27:
      AppMethodBeat.o(250615);
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
    p.h(paramFinderItem, "finderItem");
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject == null)
    {
      Log.e(TAG, "report19086, feedReportObj is null");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1253L, 38L, 1L, false);
      AppMethodBeat.o(166574);
      return;
    }
    if (!paramBoolean) {}
    int j;
    label135:
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
    Object localObject1;
    label251:
    Object localObject2;
    switch (localFinderFeedReportObject.postStage)
    {
    default: 
      Log.w(TAG, "postStage range error, " + localFinderFeedReportObject.postStage);
      p.h(paramFinderItem, "finderItem");
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
          break label453;
        }
        ((ArrayList)localObject5).addAll((Collection)localFinderFeedReportObject.mediaList);
        localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((cjl)((Iterator)localObject1).next()).MoZ;
          if (localObject2 != null)
          {
            if (((FinderMediaReportObject)localObject2).cdnUploadRetCode == 0) {
              break label2285;
            }
            ((ArrayList)localObject5).add(localObject2);
            i = ((FinderMediaReportObject)localObject2).cdnUploadRetCode;
          }
        }
      }
      break;
    }
    label453:
    label609:
    label2275:
    label2285:
    for (;;)
    {
      localObject2 = x.SXb;
      break label251;
      localObject1 = r.d.vhx;
      r.d.oo(paramFinderItem.isLongVideo());
      break;
      localObject1 = r.d.vhx;
      r.d.op(paramFinderItem.isLongVideo());
      break;
      localObject1 = r.d.vhx;
      r.d.oq(paramFinderItem.isLongVideo());
      break;
      localObject1 = r.d.vhx;
      r.d.or(paramFinderItem.isLongVideo());
      break;
      j = 0;
      break label135;
      localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
      for (;;)
      {
        k = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((cjl)((Iterator)localObject1).next()).MoZ;
        if (localObject2 != null)
        {
          if (((FinderMediaReportObject)localObject2).cdnUploadRetCode != 0)
          {
            ((ArrayList)localObject5).add(localObject2);
            i = ((FinderMediaReportObject)localObject2).cdnUploadRetCode;
          }
          localObject2 = x.SXb;
        }
      }
      Object localObject4 = ((Iterable)localObject5).iterator();
      localObject2 = "";
      int m = 0;
      Object localObject6;
      Object localObject7;
      int i7;
      Object localObject8;
      int n;
      Object localObject10;
      if (((Iterator)localObject4).hasNext())
      {
        localObject6 = (FinderMediaReportObject)((Iterator)localObject4).next();
        localObject3 = new JSONObject();
        com.tencent.mm.ac.g.a(localObject6, (JSONObject)localObject3);
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
          p.g(localObject7, "it::class.java.declaredFields");
          i7 = localObject7.length;
          m = 0;
          localObject1 = localObject2;
          if (m >= i7) {
            break label1064;
          }
          localObject8 = localObject7[m];
          localObject9 = localObject8.get(localObject6);
          if (localObject9 != null) {
            break label609;
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
              break label559;
              i = 0;
              break;
              if ((!(localObject9 instanceof Integer)) || (!(p.j(localObject9, Integer.valueOf(0)) ^ true))) {
                break label686;
              }
              localObject1 = new StringBuilder().append((String)localObject1);
              p.g(localObject8, "field");
              localObject2 = localObject8.getName() + ':' + localObject9 + ';';
            }
            if ((localObject9 instanceof String))
            {
              if (((CharSequence)localObject9).length() > 0) {}
              for (n = 1;; n = 0)
              {
                if (n == 0) {
                  break label776;
                }
                localObject1 = new StringBuilder().append((String)localObject1);
                p.g(localObject8, "field");
                localObject2 = localObject8.getName() + ':' + localObject9 + ';';
                break;
              }
            }
            localObject2 = localObject1;
          } while (!(localObject9 instanceof com.tencent.mm.bw.a));
          arrayOfField = localObject9.getClass().getDeclaredFields();
          p.g(arrayOfField, "fieldValue::class.java.declaredFields");
          i8 = arrayOfField.length;
          n = 0;
          localObject2 = localObject1;
        } while (n >= i8);
        localObject2 = arrayOfField[n];
        localObject10 = ((Field)localObject2).get(localObject9);
        if (((localObject10 instanceof Integer)) && ((p.j(localObject10, Integer.valueOf(0)) ^ true)))
        {
          localObject1 = new StringBuilder().append((String)localObject1);
          p.g(localObject8, "field");
          localObject1 = ((StringBuilder)localObject1).append(localObject8.getName()).append('-');
          p.g(localObject2, "innerField");
          localObject1 = ((Field)localObject2).getName() + ':' + localObject10 + ';';
        }
      }
      for (;;)
      {
        n += 1;
        break label814;
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
              p.g(localObject8, "field");
              localObject1 = ((StringBuilder)localObject1).append(localObject8.getName()).append('-');
              p.g(localObject2, "innerField");
              localObject1 = ((Field)localObject2).getName() + ':' + localObject10 + ';';
              break label940;
              i1 = 0;
              continue;
              localObject2 = (String)localObject1 + "#";
              m = i;
              break;
              try
              {
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.OjH, "");
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
                localObject1 = (cjl)j.kt((List)paramFinderItem.getMediaList());
                if (localObject1 != null)
                {
                  localObject1 = ((cjl)localObject1).codec_info;
                  if (localObject1 != null)
                  {
                    ((JSONObject)localObject3).put("codecInfo", "video_score:" + ((ayg)localObject1).LIt + ",video_cover_score:" + ((ayg)localObject1).LIu + ",video_audio_score:" + ((ayg)localObject1).LIv + ",thumb_score:" + ((ayg)localObject1).LIw + ",hdimg_score:" + ((ayg)localObject1).LIx + ",has_stickers:" + ((ayg)localObject1).LIy);
                    localObject1 = x.SXb;
                  }
                }
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  Log.printErrStackTrace(TAG, localThrowable, "mediaInfoJson put snn", new Object[0]);
                  continue;
                  String str = localThrowable.MoM;
                  continue;
                  str = str.MoM;
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
              localObject1 = (cjl)j.kt((List)paramFinderItem.getMediaList());
              if (localObject1 != null)
              {
                if (Util.isNullOrNil(((cjl)localObject1).MoM))
                {
                  localObject1 = p.I(((cjl)localObject1).url, Util.nullAsNil(((cjl)localObject1).url_token));
                  if (localObject1 != null) {
                    break label2275;
                  }
                }
              }
              else
              {
                localObject4 = "";
                if (!bool) {
                  break label2225;
                }
                localObject1 = paramFinderItem.getLongVideoMediaList();
                if (localObject1 == null) {
                  break label2219;
                }
                localObject1 = (cjl)j.kt((List)localObject1);
                if (localObject1 == null) {
                  break label2219;
                }
                if (!Util.isNullOrNil(((cjl)localObject1).MoM)) {
                  break label2209;
                }
                localObject1 = p.I(((cjl)localObject1).url, Util.nullAsNil(((cjl)localObject1).url_token));
                localObject3 = ((JSONObject)localObject3).toString();
                p.g(localObject3, "mediaInfoJson.toString()");
                localObject6 = n.j((String)localObject3, ",", ";", false);
                localObject3 = (FinderMediaReportObject)j.kt((List)localObject5);
                if (localObject3 != null)
                {
                  if (((FinderMediaReportObject)localObject3).mediaType != 4) {
                    break label2233;
                  }
                  localObject3 = ((FinderMediaReportObject)j.ks((List)localObject5)).multiMediaInfo;
                  p.g(localObject3, "mediaReportList.first().multiMediaInfo");
                  localObject3 = ep((List)localObject3);
                  localObject5 = localObject3;
                  if (localObject3 != null) {}
                }
                else
                {
                  localObject5 = "";
                }
                localObject5 = n.j((String)localObject5, ",", ";", false);
                n = localFinderFeedReportObject.dumpCgiErrorCode;
                i1 = localFinderFeedReportObject.dumpCgiErrorType;
                i7 = localFinderFeedReportObject.sdkShareType;
                localObject3 = paramFinderItem.getFeedObject().objectDesc;
                if (localObject3 != null)
                {
                  localObject3 = ((FinderObjectDesc)localObject3).event;
                  if ((localObject3 != null) && (((azs)localObject3).twd == 0L)) {
                    break label2241;
                  }
                }
                i = 1;
                Log.i(TAG, "19086, sdkShareType:" + i7 + ", isActivityEvent:" + i + ", dumpCgiErrorType:" + i1 + ", dumpCgiErrorCode:" + n);
                localObject7 = new StringBuilder().append(localFinderFeedReportObject.enterScene).append(',').append(localFinderFeedReportObject.sessionId).append(',');
                if (!paramBoolean) {
                  break label2246;
                }
                localObject3 = k.vfA;
                localObject3 = k.Fg(paramFinderItem.getId());
                localObject2 = ((StringBuilder)localObject7).append(localObject3).append(',').append(localFinderFeedReportObject.videoSource).append(',').append(cl.aWA() - localFinderFeedReportObject.sendOrExitButtonTime).append(',').append(m).append(',').append(i6).append(',').append((String)localObject2).append(',');
                if (!paramBoolean) {
                  break label2255;
                }
                m = 1;
                localObject2 = ((StringBuilder)localObject2).append(m).append(',').append(i4).append(',').append(vfn).append(',').append(k).append(',').append(NetStatusUtil.getNetTypeString(MMApplicationContext.getContext())).append(',').append(localFinderFeedReportObject.retryCount).append(',').append(i5).append(',').append((String)localObject6).append(',').append(localFinderFeedReportObject.videoPostType).append(',').append(localFinderFeedReportObject.uploadLogicError).append(',').append(localFinderFeedReportObject.postStage).append(',').append((String)localObject5).append(',');
                if (!paramBoolean) {
                  break label2261;
                }
                localObject3 = k.vfA;
                paramFinderItem = k.Fg(paramFinderItem.getId());
                paramFinderItem = ((StringBuilder)localObject2).append(paramFinderItem).append(',').append(localFinderFeedReportObject.cgiErrorCode).append(',').append(localFinderFeedReportObject.cgiErrorType).append(',').append((String)localObject4).append(',');
                if (!bool) {
                  break label2269;
                }
                k = 1;
                paramFinderItem = k + ',' + (String)localObject1 + ',' + localFinderFeedReportObject.megaCgiErrorCode + ',' + localFinderFeedReportObject.megaCgiErrorType + ',' + localFinderFeedReportObject.longVideoSizeInvalid + ',' + i2 + ',' + i3 + ',' + l + ',' + n + ',' + i1 + ',' + i7 + ',' + i + ',' + j;
                Log.i(TAG, "19086 ".concat(String.valueOf(paramFinderItem)));
                com.tencent.mm.plugin.report.e.Cxv.kvStat(19086, paramFinderItem);
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
    AppMethodBeat.i(250609);
    p.h(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.y("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
      Object localObject = paramRecordMediaReportInfo.y("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
      p.g(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
      localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.y("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
      p.g(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
      localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.y("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
      p.g(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
      localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.y("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
      p.g(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
      localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.y("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
      p.g(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
      localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
      localObject = paramRecordMediaReportInfo.y("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(0));
      p.g(localObject, "reportInfo.getReportValu…EY_VIDEO_SUB_TYPE_INT, 0)");
      localFinderFeedReportObject.videoSubType = ((Number)localObject).intValue();
      localFinderFeedReportObject.postId = ((String)paramRecordMediaReportInfo.y("KEY_MULTI_MEDIA_POST_ID_STRING", ""));
      localFinderFeedReportObject.editId = ((String)paramRecordMediaReportInfo.y("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      localObject = paramRecordMediaReportInfo.y("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
      p.g(localObject, "reportInfo.getReportValu…UB_RECORD_BOOLEAN, false)");
      if (((Boolean)localObject).booleanValue()) {}
      for (int i = 1;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.y("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValu…GE_SUB_RECORD_TAB_INT, 0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.y("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValu…IDEO_RECORD_CLICK_INT, 0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.y("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        p.g(localObject, "reportInfo.getReportValu…EO_RECORD_SUCCESS_INT, 0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.y("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        p.g(paramRecordMediaReportInfo, "reportInfo.getReportValu…KEY_SUB_VIDEO_NUM_INT, 0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(250609);
        return;
      }
    }
    AppMethodBeat.o(250609);
  }
  
  public static void c(ArrayList<cjj> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250607);
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      if (paramArrayList != null)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str2 = ((cjj)localIterator.next()).username;
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
        AppMethodBeat.o(250607);
        return;
      }
    }
    AppMethodBeat.o(250607);
  }
  
  public static FinderFeedReportObject dnX()
  {
    return vfk;
  }
  
  public static FinderFeedReportObject dnY()
  {
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    vfk = null;
    return localFinderFeedReportObject;
  }
  
  public static com.tencent.mm.plugin.finder.upload.q dnZ()
  {
    return vfm;
  }
  
  public static void dz(String paramString, int paramInt)
  {
    AppMethodBeat.i(250605);
    p.h(paramString, "topicId");
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.topicActivityId = paramString;
      localFinderFeedReportObject.topicActivityType = paramInt;
      AppMethodBeat.o(250605);
      return;
    }
    AppMethodBeat.o(250605);
  }
  
  public static void e(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(250617);
    p.h(paramFinderItem, "finderItem");
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject == null)
    {
      Log.e(TAG, "report21666, feedReportObj is null");
      AppMethodBeat.o(250617);
      return;
    }
    dg localdg = new dg();
    localdg.ji(paramFinderItem.getLocalId());
    localdg.jj(cl.aWA() - localFinderFeedReportObject.sendOrExitButtonTime);
    localdg.jk(localFinderFeedReportObject.uploadCost);
    localdg.jl(localFinderFeedReportObject.mediaProcessCost);
    localdg.jm(vfn);
    localdg.ox(NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()));
    localdg.jn(localFinderFeedReportObject.retryCount);
    localdg.jo(CdnLogic.getRecentAverageSpeed(1));
    localdg.jp(localFinderFeedReportObject.videoPostType);
    localdg.jq(localFinderFeedReportObject.postStage);
    localdg.jt(paramFinderItem.getPostInfo().Mpc);
    boolean bool = paramFinderItem.isLongVideo();
    localdg.ju(localFinderFeedReportObject.postTaskCost);
    localdg.jv(localFinderFeedReportObject.clickRepostCount);
    localdg.jw(localFinderFeedReportObject.uploadMediaTotalSize);
    Object localObject4 = new ArrayList();
    Object localObject2 = new JSONObject();
    int i = 0;
    ((ArrayList)localObject4).addAll((Collection)localFinderFeedReportObject.mediaList);
    ((ArrayList)localObject4).addAll((Collection)localFinderFeedReportObject.mediaList);
    Object localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((cjl)((Iterator)localObject1).next()).MoZ;
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
      localObject3 = x.SXb;
      break;
      localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ((cjl)((Iterator)localObject1).next()).MoZ;
        if (localObject3 != null)
        {
          if (((FinderMediaReportObject)localObject3).cdnUploadRetCode != 0)
          {
            ((ArrayList)localObject4).add(localObject3);
            i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
          }
          localObject3 = x.SXb;
        }
      }
      localdg.kJ(i);
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
        com.tencent.mm.ac.g.a(localFinderMediaReportObject, (JSONObject)localObject3);
        Field[] arrayOfField1 = localFinderMediaReportObject.getClass().getDeclaredFields();
        p.g(arrayOfField1, "it::class.java.declaredFields");
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
                if ((!(localObject5 instanceof Integer)) || (!(p.j(localObject5, Integer.valueOf(0)) ^ true))) {
                  break label623;
                }
                localObject1 = new StringBuilder().append((String)localObject1);
                p.g(localField, "field");
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
                  p.g(localField, "field");
                  localObject2 = localField.getName() + ':' + localObject5 + ';';
                  break;
                }
              }
              localObject2 = localObject1;
            } while (!(localObject5 instanceof com.tencent.mm.bw.a));
            arrayOfField2 = localObject5.getClass().getDeclaredFields();
            p.g(arrayOfField2, "fieldValue::class.java.declaredFields");
            n = arrayOfField2.length;
            j = 0;
            localObject2 = localObject1;
          } while (j >= n);
          localObject2 = arrayOfField2[j];
          localObject6 = ((Field)localObject2).get(localObject5);
          if (((localObject6 instanceof Integer)) && ((p.j(localObject6, Integer.valueOf(0)) ^ true)))
          {
            localObject1 = new StringBuilder().append((String)localObject1);
            p.g(localField, "field");
            localObject1 = ((StringBuilder)localObject1).append(localField.getName()).append('-');
            p.g(localObject2, "innerField");
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
              p.g(localField, "field");
              localObject1 = ((StringBuilder)localObject1).append(localField.getName()).append('-');
              p.g(localObject2, "innerField");
              localObject1 = ((Field)localObject2).getName() + ':' + localObject6 + ';';
              break label871;
              k = 0;
              continue;
              localObject1 = (String)localObject1 + "#";
              localObject2 = localObject3;
              break;
              localdg.ow((String)localObject1);
              try
              {
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject3 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.OjH, "");
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
                localObject1 = (cjl)j.kt((List)paramFinderItem.getMediaList());
                if (localObject1 != null)
                {
                  localObject1 = ((cjl)localObject1).codec_info;
                  if (localObject1 != null)
                  {
                    ((JSONObject)localObject2).put("codecInfo", "video_score:" + ((ayg)localObject1).LIt + ",video_cover_score:" + ((ayg)localObject1).LIu + ",video_audio_score:" + ((ayg)localObject1).LIv + ",thumb_score:" + ((ayg)localObject1).LIw + ",hdimg_score:" + ((ayg)localObject1).LIx + ",has_stickers:" + ((ayg)localObject1).LIy);
                    localObject1 = x.SXb;
                  }
                }
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  Log.printErrStackTrace(TAG, localThrowable, "mediaInfoJson put snn", new Object[0]);
                  continue;
                  String str = localThrowable.MoM;
                  continue;
                  str = str.MoM;
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
              localObject1 = (cjl)j.kt((List)paramFinderItem.getMediaList());
              if (localObject1 != null)
              {
                if (Util.isNullOrNil(((cjl)localObject1).MoM))
                {
                  localObject1 = p.I(((cjl)localObject1).url, Util.nullAsNil(((cjl)localObject1).url_token));
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
                localObject1 = (cjl)j.kt((List)localObject1);
                if (localObject1 == null) {
                  break label1714;
                }
                if (!Util.isNullOrNil(((cjl)localObject1).MoM)) {
                  break label1704;
                }
                localObject1 = p.I(((cjl)localObject1).url, Util.nullAsNil(((cjl)localObject1).url_token));
                localObject2 = ((JSONObject)localObject2).toString();
                p.g(localObject2, "mediaInfoJson.toString()");
                localdg.oy(n.j((String)localObject2, ",", ";", false));
                localObject2 = (FinderMediaReportObject)j.kt((List)localObject4);
                if (localObject2 != null)
                {
                  if (((FinderMediaReportObject)localObject2).mediaType != 4) {
                    break label1728;
                  }
                  localObject2 = ((FinderMediaReportObject)j.ks((List)localObject4)).multiMediaInfo;
                  p.g(localObject2, "mediaReportList.first().multiMediaInfo");
                  localObject2 = ep((List)localObject2);
                  localObject4 = localObject2;
                  if (localObject2 != null) {}
                }
                else
                {
                  localObject4 = "";
                }
                localdg.oz(n.j((String)localObject4, ",", ";", false));
                localdg.kK(localFinderFeedReportObject.cgiErrorCode);
                localdg.kL(localFinderFeedReportObject.cgiErrorType);
                localdg.oA((String)localObject3);
                if (!bool) {
                  break label1736;
                }
                l = 1L;
                localdg.jr(l);
                localdg.oB((String)localObject1);
                localdg.kM(localFinderFeedReportObject.megaCgiErrorCode);
                localdg.kN(localFinderFeedReportObject.megaCgiErrorType);
                localdg.js(localFinderFeedReportObject.longVideoSizeInvalid);
                localdg.kO(localFinderFeedReportObject.dumpCgiErrorCode);
                localdg.kP(localFinderFeedReportObject.dumpCgiErrorType);
                localdg.kQ(localFinderFeedReportObject.sdkShareType);
                paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
                if (paramFinderItem != null)
                {
                  paramFinderItem = paramFinderItem.event;
                  if ((paramFinderItem != null) && (paramFinderItem.twd == 0L)) {
                    break label1744;
                  }
                }
                i = 1;
                localdg.kR(i);
                localdg.bfK();
                paramFinderItem = k.vfA;
                k.a((com.tencent.mm.plugin.report.a)localdg);
                AppMethodBeat.o(250617);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  private static String ep(List<? extends FinderMediaReportInfo> paramList)
  {
    AppMethodBeat.i(250618);
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
    p.g(paramList, "array.toString()");
    AppMethodBeat.o(250618);
    return paramList;
  }
  
  public static void gR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250610);
    p.h(paramString1, "postId");
    FinderFeedReportObject localFinderFeedReportObject = vfk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.postId = paramString1;
      if (paramString2 != null) {
        localFinderFeedReportObject.editId = paramString2;
      }
      AppMethodBeat.o(250610);
      return;
    }
    AppMethodBeat.o(250610);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void j(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(250620);
    di localdi = new di();
    Object localObject = vfk;
    if (localObject != null)
    {
      localdi.oG(((FinderFeedReportObject)localObject).postId);
      localdi.oH(((FinderFeedReportObject)localObject).editId);
      localdi.jx(((FinderFeedReportObject)localObject).videoSource);
      localdi.jy(paramInt);
      localdi.jz(paramLong1);
      localdi.jA(paramLong2);
      localdi.bfK();
      localObject = k.vfA;
      k.a((com.tencent.mm.plugin.report.a)localdi);
      AppMethodBeat.o(250620);
      return;
    }
    AppMethodBeat.o(250620);
  }
  
  public static void j(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250616);
    Log.i(TAG, "savePostError " + paramLong + ", " + paramInt1 + ", " + paramInt2);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    localObject1 = c.a.FS(paramLong);
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
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      c.a.r((FinderItem)localObject1);
      AppMethodBeat.o(250616);
      return;
    }
    AppMethodBeat.o(250616);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/report/FinderPostReportLogic$postListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.upload.q
  {
    public final void onPostEnd(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(166567);
      Object localObject = i.vfo;
      i.Fb(paramLong);
      localObject = new ia();
      ((ia)localObject).dMC.localId = paramLong;
      ((ia)localObject).dMC.dMD = false;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(166567);
    }
    
    public final void onPostNotify(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(250599);
      if (!paramBoolean)
      {
        ia localia = new ia();
        localia.dMC.localId = paramLong;
        localia.dMC.dMD = false;
        EventCenter.instance.publish((IEvent)localia);
      }
      AppMethodBeat.o(250599);
    }
    
    public final void onPostOk(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166568);
      Object localObject = i.vfo;
      i.Fa(paramLong2);
      localObject = com.tencent.mm.plugin.finder.storage.data.e.vFX;
      localObject = e.a.Fy(paramLong2);
      if (localObject != null)
      {
        ia localia = new ia();
        localia.dMC.localId = paramLong1;
        localia.dMC.dMD = true;
        ia.a locala = localia.dMC;
        s.a locala1 = s.vWt;
        locala.dME = s.a.c((FinderItem)localObject, true);
        EventCenter.instance.publish((IEvent)localia);
        AppMethodBeat.o(166568);
        return;
      }
      AppMethodBeat.o(166568);
    }
    
    public final void onPostStart(long paramLong) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/report/FinderPostReportLogic$reportCurrentPostExit$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(FinderFeedReportObject paramFinderFeedReportObject, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/report/FinderPostReportLogic$startPost$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i
 * JD-Core Version:    0.7.0.1
 */