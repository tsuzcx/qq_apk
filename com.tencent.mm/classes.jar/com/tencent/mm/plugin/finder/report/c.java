package com.tencent.mm.plugin.finder.report;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import d.a.j;
import d.l;
import d.y;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderPostReportLogic;", "", "()V", "InnerVersion19086", "", "getInnerVersion19086", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "_18939InnerVersion", "", "finderFeedReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "postListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "setPostListener", "(Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;)V", "finishEdit", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "finishTakePhoto", "getReportInfoAndClear", "packageJson", "Lcom/tencent/mm/json/JSONObject;", "jsonObject", "key", "value", "pickMedia", "mediaSource", "postExit", "pageId", "isSaveDraft", "", "report19086", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "success", "reportCurrentPost", "reportCurrentPostExit", "reportCurrentPostFail", "localId", "reportCurrentPostSuccess", "svrId", "setAtData", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "clickMentionCount", "clickSucMentionCount", "setDraft", "draft", "setPostId", "postId", "editId", "setRemuxType", "type", "startPost", "entrance", "updateLBSFlag", "lbsFlag", "selectLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FinderPostReportLogic";
  private static FinderFeedReportObject rxe;
  private static final long rxf = 2L;
  private static com.tencent.mm.plugin.finder.upload.k rxg;
  private static final int rxh = 7;
  public static final c rxi;
  
  static
  {
    AppMethodBeat.i(166575);
    rxi = new c();
    TAG = "Finder.FinderPostReportLogic";
    rxf = 2L;
    rxg = (com.tencent.mm.plugin.finder.upload.k)new c.a();
    rxh = 7;
    AppMethodBeat.o(166575);
  }
  
  public static void DR(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = rxe;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.videoSource = paramInt;
    }
  }
  
  private static i a(i parami, String paramString, int paramInt)
  {
    AppMethodBeat.i(202726);
    i locali = parami;
    if (parami == null) {
      locali = new i();
    }
    try
    {
      locali.O(paramString, paramInt);
      label26:
      AppMethodBeat.o(202726);
      return locali;
    }
    catch (Exception parami)
    {
      break label26;
    }
  }
  
  public static void a(int paramInt, alt paramalt)
  {
    FinderFeedReportObject localFinderFeedReportObject = rxe;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.lbsFlag = paramInt;
      localFinderFeedReportObject.selectLocation = paramalt;
    }
  }
  
  public static void a(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    int j = 1;
    AppMethodBeat.i(202720);
    d.g.b.k.h(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = rxe;
    if (localFinderFeedReportObject != null)
    {
      Object localObject = paramRecordMediaReportInfo.x("KEY_RECORD_IS_BEAUTIFY", Boolean.FALSE);
      d.g.b.k.g(localObject, "reportInfo.getReportValu…ECORD_IS_BEAUTIFY, false)");
      if (((Boolean)localObject).booleanValue())
      {
        i = 1;
        localFinderFeedReportObject.isBeauty = i;
        localObject = paramRecordMediaReportInfo.x("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…DIA_DURATION_MS_LONG, 0L)");
        localFinderFeedReportObject.videoRecordTime = ((Number)localObject).longValue();
        localFinderFeedReportObject.videoSource = (((Number)paramRecordMediaReportInfo.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
        localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.x("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
        localObject = paramRecordMediaReportInfo.x("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
        localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
        localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
        localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
        localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.x("KEY_ENTER_TIME_MS_LONG", Long.valueOf(0L));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…Y_ENTER_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterTakePhotoTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.x("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
        d.g.b.k.g(localObject, "reportInfo.getReportValu…SUB_RECORD_BOOLEAN,false)");
        if (!((Boolean)localObject).booleanValue()) {
          break label501;
        }
      }
      label501:
      for (int i = j;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.x("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…NGE_SUB_RECORD_TAB_INT,0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…VIDEO_RECORD_CLICK_INT,0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…DEO_RECORD_SUCCESS_INT,0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        d.g.b.k.g(paramRecordMediaReportInfo, "reportInfo.getReportValue(KEY_SUB_VIDEO_NUM_INT,0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(202720);
        return;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(202720);
  }
  
  public static void ae(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(202718);
    rxe = new FinderFeedReportObject();
    if (paramBoolean)
    {
      FinderFeedReportObject localFinderFeedReportObject = rxe;
      if (localFinderFeedReportObject != null)
      {
        com.tencent.mm.ac.c.c(TAG, (d.g.a.a)new c.c(localFinderFeedReportObject, paramBoolean, paramInt));
        AppMethodBeat.o(202718);
        return;
      }
    }
    AppMethodBeat.o(202718);
  }
  
  public static void af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(202724);
    FinderFeedReportObject localFinderFeedReportObject = rxe;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.exitPageId = paramInt;
      if (paramInt == 4) {
        localFinderFeedReportObject.sendOrExitButtonTime = ce.azJ();
      }
      localFinderFeedReportObject = rxe;
      if (localFinderFeedReportObject != null) {
        com.tencent.mm.ac.c.c(TAG, (d.g.a.a)new c.b(localFinderFeedReportObject, paramBoolean));
      }
      rxe = null;
      AppMethodBeat.o(202724);
      return;
    }
    AppMethodBeat.o(202724);
  }
  
  private static void b(FinderItem paramFinderItem, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(178388);
    Object localObject1 = "";
    Object localObject3 = (Iterable)paramFinderItem.getMediaList();
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    int i = 0;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (bqs)((Iterator)localObject3).next();
      localObject1 = (String)localObject1 + ((bqs)localObject4).mediaType + ';' + ((bqs)localObject4).videoDuration + '#';
      if (bs.isNullOrNil(((bqs)localObject4).coverUrl)) {}
      for (i = 0;; i = 1)
      {
        ((Collection)localObject2).add(y.KTp);
        break;
      }
    }
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject != null)
    {
      localObject4 = new com.tencent.mm.g.b.a.ax();
      ((com.tencent.mm.g.b.a.ax)localObject4).ii(localFinderFeedReportObject.sessionId);
      ((com.tencent.mm.g.b.a.ax)localObject4).ig(localFinderFeedReportObject.enterScene);
      if (paramBoolean)
      {
        ((com.tencent.mm.g.b.a.ax)localObject4).ih(j);
        localObject2 = d.rxr;
        ((com.tencent.mm.g.b.a.ax)localObject4).ij(d.ut(paramFinderItem.getId()));
        ((com.tencent.mm.g.b.a.ax)localObject4).ii(localFinderFeedReportObject.exitPageId);
        ((com.tencent.mm.g.b.a.ax)localObject4).eu(localFinderFeedReportObject.enterTakePhotoTime);
        ((com.tencent.mm.g.b.a.ax)localObject4).ev(localFinderFeedReportObject.enterVideoEditTime);
        ((com.tencent.mm.g.b.a.ax)localObject4).ew(localFinderFeedReportObject.sendOrExitButtonTime);
        ((com.tencent.mm.g.b.a.ax)localObject4).ex(localFinderFeedReportObject.videoRecordTime);
        ((com.tencent.mm.g.b.a.ax)localObject4).ey(localFinderFeedReportObject.videoSource);
        ((com.tencent.mm.g.b.a.ax)localObject4).ez(localFinderFeedReportObject.videoEmojiCount);
        ((com.tencent.mm.g.b.a.ax)localObject4).eA(localFinderFeedReportObject.videoWordingCount);
        localObject3 = localFinderFeedReportObject.videoMusicId;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        ((com.tencent.mm.g.b.a.ax)localObject4).ik((String)localObject2);
        ((com.tencent.mm.g.b.a.ax)localObject4).eB(localFinderFeedReportObject.videoMusicIndex);
        ((com.tencent.mm.g.b.a.ax)localObject4).eC(localFinderFeedReportObject.videoMusicSearch);
        ((com.tencent.mm.g.b.a.ax)localObject4).eD(localFinderFeedReportObject.videoPostType);
        ((com.tencent.mm.g.b.a.ax)localObject4).il((String)localObject1);
        ((com.tencent.mm.g.b.a.ax)localObject4).eE(localFinderFeedReportObject.existDesc);
        ((com.tencent.mm.g.b.a.ax)localObject4).eF(localFinderFeedReportObject.descCount);
        localObject2 = localFinderFeedReportObject.actionTrace;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((com.tencent.mm.g.b.a.ax)localObject4).im((String)localObject1);
        ((com.tencent.mm.g.b.a.ax)localObject4).eG(localFinderFeedReportObject.lbsFlag);
        localObject2 = localFinderFeedReportObject.link;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((com.tencent.mm.g.b.a.ax)localObject4).in((String)localObject1);
        ((com.tencent.mm.g.b.a.ax)localObject4).eH(localFinderFeedReportObject.draft);
        localObject1 = m.rPH;
        ((com.tencent.mm.g.b.a.ax)localObject4).io(d.n.n.h(m.n(paramFinderItem), ",", ";", false));
        ((com.tencent.mm.g.b.a.ax)localObject4).ip("");
        if (!h.DEBUG) {
          break label808;
        }
      }
      label808:
      for (long l = 0L;; l = rxf)
      {
        ((com.tencent.mm.g.b.a.ax)localObject4).eI(l);
        ((com.tencent.mm.g.b.a.ax)localObject4).ik(localFinderFeedReportObject.mentionCount);
        ((com.tencent.mm.g.b.a.ax)localObject4).eJ(localFinderFeedReportObject.clickMentionCount);
        ((com.tencent.mm.g.b.a.ax)localObject4).eK(localFinderFeedReportObject.clickSucMentionCount);
        ((com.tencent.mm.g.b.a.ax)localObject4).eL(localFinderFeedReportObject.mentionRepeatCount);
        ((com.tencent.mm.g.b.a.ax)localObject4).iq("");
        ((com.tencent.mm.g.b.a.ax)localObject4).ij(i);
        localObject1 = a(a(a(a(a(null, "IsMultiShot", localFinderFeedReportObject.isMultiShot), "MultiShotChangeCnt", localFinderFeedReportObject.multiShotChangeCnt), "MultiShotClickCnt", localFinderFeedReportObject.multiShotClickCnt), "MultiShotSuccessCnt", localFinderFeedReportObject.multiShotSuccessCnt), "MultiShotVideoCnt", localFinderFeedReportObject.multiShotVideoCnt).toString();
        d.g.b.k.g(localObject1, "recordInfo.toString()");
        ((com.tencent.mm.g.b.a.ax)localObject4).ir(d.n.n.h((String)localObject1, ",", ";", false));
        ((com.tencent.mm.g.b.a.ax)localObject4).eM(localFinderFeedReportObject.videoSubType);
        ((com.tencent.mm.g.b.a.ax)localObject4).is(localFinderFeedReportObject.postId);
        ((com.tencent.mm.g.b.a.ax)localObject4).it(localFinderFeedReportObject.editId);
        localObject1 = paramFinderItem.getLocation();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
          ((com.tencent.mm.g.b.a.ax)localObject4).iu(com.tencent.mm.plugin.finder.utils.n.gn(((alt)localObject1).exW, ((alt)localObject1).gPy));
        }
        ((com.tencent.mm.g.b.a.ax)localObject4).eN(localFinderFeedReportObject.remuxType);
        ((com.tencent.mm.g.b.a.ax)localObject4).aHZ();
        localObject1 = d.rxr;
        d.a((com.tencent.mm.plugin.report.a)localObject4);
        c(paramFinderItem, paramBoolean);
        AppMethodBeat.o(178388);
        return;
        j = 0;
        break;
      }
    }
    AppMethodBeat.o(178388);
  }
  
  public static void b(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(202721);
    d.g.b.k.h(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = rxe;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.x("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
      Object localObject = paramRecordMediaReportInfo.x("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
      localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.x("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
      localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
      localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
      localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
      d.g.b.k.g(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
      localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
      localObject = paramRecordMediaReportInfo.x("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValu…EY_VIDEO_SUB_TYPE_INT, 0)");
      localFinderFeedReportObject.videoSubType = ((Number)localObject).intValue();
      localFinderFeedReportObject.postId = ((String)paramRecordMediaReportInfo.x("KEY_MULTI_MEDIA_POST_ID_STRING", ""));
      localFinderFeedReportObject.editId = ((String)paramRecordMediaReportInfo.x("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      localObject = paramRecordMediaReportInfo.x("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
      d.g.b.k.g(localObject, "reportInfo.getReportValu…SUB_RECORD_BOOLEAN,false)");
      if (((Boolean)localObject).booleanValue()) {}
      for (int i = 1;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.x("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…NGE_SUB_RECORD_TAB_INT,0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…VIDEO_RECORD_CLICK_INT,0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…DEO_RECORD_SUCCESS_INT,0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.x("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        d.g.b.k.g(paramRecordMediaReportInfo, "reportInfo.getReportValue(KEY_SUB_VIDEO_NUM_INT,0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(202721);
        return;
      }
    }
    AppMethodBeat.o(202721);
  }
  
  private static void c(FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(166574);
    d.g.b.k.h(paramFinderItem, "finderItem");
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    int k;
    int j;
    int m;
    int i;
    Object localObject1;
    int i3;
    Object localObject2;
    label111:
    Object localObject3;
    if (localFinderFeedReportObject.remuxEndTime == 0L)
    {
      k = (int)(localFinderFeedReportObject.cdnEndTime - localFinderFeedReportObject.sendOrExitButtonTime);
      j = 0;
      m = 0;
      i = 0;
      localObject1 = new ArrayList();
      i3 = CdnLogic.getRecentAverageSpeed(1);
      ((ArrayList)localObject1).addAll((Collection)localFinderFeedReportObject.mediaList);
      if (paramBoolean) {
        break label199;
      }
      ((ArrayList)localObject1).addAll((Collection)localFinderFeedReportObject.mediaList);
      localObject2 = ((Iterable)paramFinderItem.getMediaList()).iterator();
      do
      {
        m = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = ((bqs)((Iterator)localObject2).next()).FfS;
      } while (localObject3 == null);
      if (((FinderMediaReportObject)localObject3).cdnUploadRetCode == 0) {
        break label1052;
      }
      ((ArrayList)localObject1).add(localObject3);
      i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
    }
    label272:
    label1041:
    label1046:
    label1052:
    for (;;)
    {
      break label111;
      j = (int)(localFinderFeedReportObject.remuxEndTime - localFinderFeedReportObject.sendOrExitButtonTime);
      k = (int)(localFinderFeedReportObject.cdnEndTime - localFinderFeedReportObject.remuxEndTime);
      break;
      label199:
      localObject3 = ((Iterable)localObject1).iterator();
      localObject1 = "";
      i = 0;
      label254:
      Field localField;
      label322:
      int i1;
      label489:
      Object localObject5;
      if (((Iterator)localObject3).hasNext())
      {
        FinderMediaReportObject localFinderMediaReportObject = (FinderMediaReportObject)((Iterator)localObject3).next();
        if (i != 0) {
          break label1046;
        }
        int n;
        Object localObject4;
        if (localFinderMediaReportObject.zipTime > 0)
        {
          i = 1;
          Field[] arrayOfField1 = localFinderMediaReportObject.getClass().getDeclaredFields();
          int i4 = arrayOfField1.length;
          n = 0;
          if (n >= i4) {
            break label769;
          }
          localField = arrayOfField1[n];
          localObject4 = localField.get(localFinderMediaReportObject);
          if (localObject4 != null) {
            break label322;
          }
          localObject2 = localObject1;
        }
        Field[] arrayOfField2;
        int i5;
        do
        {
          do
          {
            for (;;)
            {
              n += 1;
              localObject1 = localObject2;
              break label272;
              i = 0;
              break;
              if ((!(localObject4 instanceof Integer)) || (!(d.g.b.k.g(localObject4, Integer.valueOf(0)) ^ true))) {
                break label399;
              }
              localObject1 = new StringBuilder().append((String)localObject1);
              d.g.b.k.g(localField, "field");
              localObject2 = localField.getName() + ':' + localObject4 + ';';
            }
            if ((localObject4 instanceof String))
            {
              if (((CharSequence)localObject4).length() > 0) {}
              for (i1 = 1;; i1 = 0)
              {
                if (i1 == 0) {
                  break label489;
                }
                localObject1 = new StringBuilder().append((String)localObject1);
                d.g.b.k.g(localField, "field");
                localObject2 = localField.getName() + ':' + localObject4 + ';';
                break;
              }
            }
            localObject2 = localObject1;
          } while (!(localObject4 instanceof com.tencent.mm.bw.a));
          arrayOfField2 = localObject4.getClass().getDeclaredFields();
          i5 = arrayOfField2.length;
          i1 = 0;
          localObject2 = localObject1;
        } while (i1 >= i5);
        localObject2 = arrayOfField2[i1];
        localObject5 = ((Field)localObject2).get(localObject4);
        if (((localObject5 instanceof Integer)) && ((d.g.b.k.g(localObject5, Integer.valueOf(0)) ^ true)))
        {
          localObject1 = new StringBuilder().append((String)localObject1);
          d.g.b.k.g(localField, "field");
          localObject1 = ((StringBuilder)localObject1).append(localField.getName()).append('-');
          d.g.b.k.g(localObject2, "innerField");
          localObject1 = ((Field)localObject2).getName() + ':' + localObject5 + ';';
        }
      }
      for (;;)
      {
        i1 += 1;
        break label519;
        if ((localObject5 instanceof String))
        {
          int i2;
          if (((CharSequence)localObject5).length() > 0) {
            i2 = 1;
          }
          for (;;)
          {
            if (i2 != 0)
            {
              localObject1 = new StringBuilder().append((String)localObject1);
              d.g.b.k.g(localField, "field");
              localObject1 = ((StringBuilder)localObject1).append(localField.getName()).append('-');
              d.g.b.k.g(localObject2, "innerField");
              localObject1 = ((Field)localObject2).getName() + ':' + localObject5 + ';';
              break label645;
              i2 = 0;
              continue;
              localObject1 = (String)localObject1 + "#";
              break;
              localObject2 = new StringBuilder().append(localFinderFeedReportObject.enterScene).append(',').append(localFinderFeedReportObject.sessionId).append(',');
              if (paramBoolean)
              {
                localObject3 = d.rxr;
                paramFinderItem = d.ut(paramFinderItem.getId());
                paramFinderItem = ((StringBuilder)localObject2).append(paramFinderItem).append(',').append(localFinderFeedReportObject.videoSource).append(',').append(ce.azJ() - localFinderFeedReportObject.sendOrExitButtonTime).append(',').append(i).append(',').append(k).append(',').append((String)localObject1).append(',');
                if (!paramBoolean) {
                  break label1041;
                }
              }
              for (i = 1;; i = 0)
              {
                paramFinderItem = i + ',' + j + ',' + rxh + ',' + m + ',' + com.tencent.mm.sdk.platformtools.ax.getNetTypeString(ai.getContext()) + ',' + localFinderFeedReportObject.retryCount + ',' + i3;
                ac.i(TAG, "19086 ".concat(String.valueOf(paramFinderItem)));
                e.wTc.kvStat(19086, paramFinderItem);
                AppMethodBeat.o(166574);
                return;
                paramFinderItem = Integer.valueOf(0);
                break;
              }
              break label254;
            }
          }
        }
      }
    }
  }
  
  public static void c(ArrayList<bqq> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202719);
    FinderFeedReportObject localFinderFeedReportObject = rxe;
    if (localFinderFeedReportObject != null)
    {
      if (paramArrayList != null)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext()) {
          localHashSet.add(((bqq)localIterator.next()).username);
        }
        localFinderFeedReportObject.mentionCount = localHashSet.size();
      }
      localFinderFeedReportObject.clickMentionCount = paramInt1;
      localFinderFeedReportObject.clickSucMentionCount = paramInt2;
      if (paramArrayList != null) {}
      for (paramInt1 = paramArrayList.size();; paramInt1 = 0)
      {
        localFinderFeedReportObject.mentionRepeatCount = paramInt1;
        AppMethodBeat.o(202719);
        return;
      }
    }
    AppMethodBeat.o(202719);
  }
  
  public static FinderFeedReportObject cwQ()
  {
    FinderFeedReportObject localFinderFeedReportObject = rxe;
    rxe = null;
    return localFinderFeedReportObject;
  }
  
  public static com.tencent.mm.plugin.finder.upload.k cwR()
  {
    return rxg;
  }
  
  public static void gd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202722);
    d.g.b.k.h(paramString1, "postId");
    FinderFeedReportObject localFinderFeedReportObject = rxe;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.postId = paramString1;
      if (paramString2 != null) {
        localFinderFeedReportObject.editId = paramString2;
      }
      AppMethodBeat.o(202722);
      return;
    }
    AppMethodBeat.o(202722);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void up(long paramLong)
  {
    AppMethodBeat.i(166572);
    Object localObject = com.tencent.mm.plugin.finder.storage.data.d.rEF;
    localObject = d.a.uS(paramLong);
    if (localObject != null)
    {
      b((FinderItem)localObject, true);
      d locald = d.rxr;
      d.d((FinderItem)localObject);
      AppMethodBeat.o(166572);
      return;
    }
    AppMethodBeat.o(166572);
  }
  
  public static void uq(long paramLong)
  {
    AppMethodBeat.i(166573);
    Object localObject = b.rFl;
    localObject = b.a.ve(paramLong);
    if (localObject != null)
    {
      b((FinderItem)localObject, false);
      AppMethodBeat.o(166573);
      return;
    }
    AppMethodBeat.o(166573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.c
 * JD-Core Version:    0.7.0.1
 */