package com.tencent.mm.plugin.finder.report;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.a.j;
import d.g.b.q;
import d.n.n;
import d.z;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderPostReportLogic;", "", "()V", "InnerVersion19086", "", "getInnerVersion19086", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "_18939InnerVersion", "", "finderFeedReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "postListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "setPostListener", "(Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;)V", "buildMultiMediaJson", "multiMediaInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportInfo;", "finishEdit", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "finishTakePhoto", "getReportInfoAndClear", "packageJson", "Lorg/json/JSONObject;", "jsonObject", "key", "value", "pickMedia", "mediaSource", "postExit", "pageId", "isSaveDraft", "", "report19086", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "success", "reportCurrentPost", "reportCurrentPostExit", "reportCurrentPostFail", "localId", "reportCurrentPostSuccess", "svrId", "savePostError", "errorType", "errorCode", "setAtData", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "clickMentionCount", "clickSucMentionCount", "setPostId", "postId", "editId", "setRemuxType", "type", "startPost", "entrance", "draft", "updateLBSFlag", "lbsFlag", "selectLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "plugin-finder_release"})
public final class f
{
  private static final String TAG = "Finder.FinderPostReportLogic";
  private static com.tencent.mm.plugin.finder.upload.l soA;
  private static final int soB = 10;
  public static final f soC;
  private static FinderFeedReportObject soy;
  private static final long soz = 2L;
  
  static
  {
    AppMethodBeat.i(166575);
    soC = new f();
    TAG = "Finder.FinderPostReportLogic";
    soz = 2L;
    soA = (com.tencent.mm.plugin.finder.upload.l)new a();
    soB = 10;
    AppMethodBeat.o(166575);
  }
  
  public static void EV(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = soy;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.videoSource = paramInt;
    }
  }
  
  public static void a(int paramInt, aoy paramaoy)
  {
    FinderFeedReportObject localFinderFeedReportObject = soy;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.lbsFlag = paramInt;
      localFinderFeedReportObject.selectLocation = paramaoy;
    }
  }
  
  private static void a(FinderItem paramFinderItem, boolean paramBoolean)
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
      localObject4 = (bvf)((Iterator)localObject3).next();
      localObject1 = (String)localObject1 + ((bvf)localObject4).mediaType + ';' + ((bvf)localObject4).videoDuration + '#';
      if (bt.isNullOrNil(((bvf)localObject4).coverUrl)) {}
      for (i = 0;; i = 1)
      {
        ((Collection)localObject2).add(z.MKo);
        break;
      }
    }
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject != null)
    {
      localObject4 = new bj();
      ((bj)localObject4).jG(localFinderFeedReportObject.sessionId);
      ((bj)localObject4).ir(localFinderFeedReportObject.enterScene);
      if (paramBoolean)
      {
        ((bj)localObject4).is(j);
        localObject2 = h.soM;
        ((bj)localObject4).jH(h.wu(paramFinderItem.getId()));
        ((bj)localObject4).it(localFinderFeedReportObject.exitPageId);
        ((bj)localObject4).fx(localFinderFeedReportObject.enterTakePhotoTime);
        ((bj)localObject4).fy(localFinderFeedReportObject.enterVideoEditTime);
        ((bj)localObject4).fz(localFinderFeedReportObject.sendOrExitButtonTime);
        ((bj)localObject4).fA(localFinderFeedReportObject.videoRecordTime);
        ((bj)localObject4).fB(localFinderFeedReportObject.videoSource);
        ((bj)localObject4).fC(localFinderFeedReportObject.videoEmojiCount);
        ((bj)localObject4).fD(localFinderFeedReportObject.videoWordingCount);
        localObject3 = localFinderFeedReportObject.videoMusicId;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        ((bj)localObject4).jI((String)localObject2);
        ((bj)localObject4).fE(localFinderFeedReportObject.videoMusicIndex);
        ((bj)localObject4).fF(localFinderFeedReportObject.videoMusicSearch);
        ((bj)localObject4).fG(localFinderFeedReportObject.videoPostType);
        ((bj)localObject4).jJ((String)localObject1);
        ((bj)localObject4).fH(localFinderFeedReportObject.existDesc);
        ((bj)localObject4).fI(localFinderFeedReportObject.descCount);
        localObject2 = localFinderFeedReportObject.actionTrace;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((bj)localObject4).jK((String)localObject1);
        ((bj)localObject4).fJ(localFinderFeedReportObject.lbsFlag);
        localObject2 = localFinderFeedReportObject.link;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((bj)localObject4).jL((String)localObject1);
        ((bj)localObject4).fK(localFinderFeedReportObject.draft);
        localObject1 = o.sMi;
        ((bj)localObject4).jM(n.h(o.p(paramFinderItem), ",", ";", false));
        ((bj)localObject4).jN("");
        if (!i.DEBUG) {
          break label800;
        }
      }
      label800:
      for (long l = 0L;; l = soz)
      {
        ((bj)localObject4).fL(l);
        ((bj)localObject4).iv(localFinderFeedReportObject.mentionCount);
        ((bj)localObject4).fM(localFinderFeedReportObject.clickMentionCount);
        ((bj)localObject4).fN(localFinderFeedReportObject.clickSucMentionCount);
        ((bj)localObject4).fO(localFinderFeedReportObject.mentionRepeatCount);
        ((bj)localObject4).jO("");
        ((bj)localObject4).iu(i);
        localObject1 = b(b(b(b(b(null, "IsMultiShot", localFinderFeedReportObject.isMultiShot), "MultiShotChangeCnt", localFinderFeedReportObject.multiShotChangeCnt), "MultiShotClickCnt", localFinderFeedReportObject.multiShotClickCnt), "MultiShotSuccessCnt", localFinderFeedReportObject.multiShotSuccessCnt), "MultiShotVideoCnt", localFinderFeedReportObject.multiShotVideoCnt).toString();
        d.g.b.p.g(localObject1, "recordInfo.toString()");
        ((bj)localObject4).jP(n.h((String)localObject1, ",", ";", false));
        ((bj)localObject4).fP(localFinderFeedReportObject.videoSubType);
        ((bj)localObject4).jQ(localFinderFeedReportObject.postId);
        ((bj)localObject4).jR(localFinderFeedReportObject.editId);
        localObject1 = paramFinderItem.getLocation();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
          ((bj)localObject4).jS(com.tencent.mm.plugin.finder.utils.p.gy(((aoy)localObject1).ePv, ((aoy)localObject1).jDf));
        }
        ((bj)localObject4).fQ(localFinderFeedReportObject.remuxType);
        ((bj)localObject4).aLk();
        localObject1 = h.soM;
        h.a((com.tencent.mm.plugin.report.a)localObject4);
        b(paramFinderItem, paramBoolean);
        AppMethodBeat.o(178388);
        return;
        j = 0;
        break;
      }
    }
    AppMethodBeat.o(178388);
  }
  
  public static void a(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    int j = 1;
    AppMethodBeat.i(203238);
    d.g.b.p.h(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = soy;
    if (localFinderFeedReportObject != null)
    {
      Object localObject = paramRecordMediaReportInfo.v("KEY_RECORD_IS_BEAUTIFY", Boolean.FALSE);
      d.g.b.p.g(localObject, "reportInfo.getReportValu…ECORD_IS_BEAUTIFY, false)");
      if (((Boolean)localObject).booleanValue())
      {
        i = 1;
        localFinderFeedReportObject.isBeauty = i;
        localObject = paramRecordMediaReportInfo.v("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…DIA_DURATION_MS_LONG, 0L)");
        localFinderFeedReportObject.videoRecordTime = ((Number)localObject).longValue();
        localFinderFeedReportObject.videoSource = (((Number)paramRecordMediaReportInfo.v("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
        localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.v("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
        localObject = paramRecordMediaReportInfo.v("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
        localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.v("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
        localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
        localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
        localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.v("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.v("KEY_ENTER_TIME_MS_LONG", Long.valueOf(0L));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…Y_ENTER_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterTakePhotoTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.v("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
        d.g.b.p.g(localObject, "reportInfo.getReportValu…SUB_RECORD_BOOLEAN,false)");
        if (!((Boolean)localObject).booleanValue()) {
          break label518;
        }
      }
      label518:
      for (int i = j;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.v("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…NGE_SUB_RECORD_TAB_INT,0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.v("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…VIDEO_RECORD_CLICK_INT,0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.v("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…DEO_RECORD_SUCCESS_INT,0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.v("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        d.g.b.p.g(paramRecordMediaReportInfo, "reportInfo.getReportValue(KEY_SUB_VIDEO_NUM_INT,0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(203238);
        return;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(203238);
  }
  
  public static void ai(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(203236);
    soy = new FinderFeedReportObject();
    if (paramBoolean)
    {
      localFinderFeedReportObject = soy;
      if (localFinderFeedReportObject != null)
      {
        com.tencent.mm.ad.c.c(TAG, (d.g.a.a)new c(localFinderFeedReportObject, paramBoolean, paramInt));
        AppMethodBeat.o(203236);
        return;
      }
      AppMethodBeat.o(203236);
      return;
    }
    FinderFeedReportObject localFinderFeedReportObject = soy;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.sessionId = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      localFinderFeedReportObject.enterScene = paramInt;
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localFinderFeedReportObject.draft = paramInt;
        AppMethodBeat.o(203236);
        return;
      }
    }
    AppMethodBeat.o(203236);
  }
  
  public static void aj(int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(203242);
    FinderFeedReportObject localFinderFeedReportObject = soy;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.exitPageId = paramInt;
      if (paramInt == 4) {
        localFinderFeedReportObject.sendOrExitButtonTime = cf.aCM();
      }
      localFinderFeedReportObject = soy;
      if (localFinderFeedReportObject != null) {
        com.tencent.mm.ad.c.c(TAG, (d.g.a.a)new b(localFinderFeedReportObject, paramBoolean));
      }
      soy = null;
      AppMethodBeat.o(203242);
      return;
    }
    AppMethodBeat.o(203242);
  }
  
  private static JSONObject b(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    AppMethodBeat.i(203244);
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramInt);
      label27:
      AppMethodBeat.o(203244);
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
    d.g.b.p.h(paramFinderItem, "finderItem");
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject == null)
    {
      ad.e(TAG, "report19086, feedReportObj is null");
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1253L, 38L, 1L, false);
      AppMethodBeat.o(166574);
      return;
    }
    if (!paramBoolean) {}
    int k;
    int j;
    label145:
    int m;
    int i;
    Object localObject6;
    int i3;
    Object localObject5;
    Object localObject1;
    label220:
    Object localObject2;
    switch (localFinderFeedReportObject.postStage)
    {
    default: 
      ad.w(TAG, "postStage range error, " + localFinderFeedReportObject.postStage);
      if (localFinderFeedReportObject.remuxEndTime == 0L)
      {
        k = (int)(localFinderFeedReportObject.cdnEndTime - localFinderFeedReportObject.sendOrExitButtonTime);
        j = 0;
        m = 0;
        i = 0;
        localObject6 = new ArrayList();
        i3 = CdnLogic.getRecentAverageSpeed(1);
        localObject5 = new JSONObject();
        ((ArrayList)localObject6).addAll((Collection)localFinderFeedReportObject.mediaList);
        if (paramBoolean) {
          break label352;
        }
        ((ArrayList)localObject6).addAll((Collection)localFinderFeedReportObject.mediaList);
        localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
        do
        {
          m = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((bvf)((Iterator)localObject1).next()).GPw;
        } while (localObject2 == null);
        if (((FinderMediaReportObject)localObject2).cdnUploadRetCode == 0) {
          break label1802;
        }
        ((ArrayList)localObject6).add(localObject2);
        i = ((FinderMediaReportObject)localObject2).cdnUploadRetCode;
      }
      break;
    }
    label662:
    label942:
    for (;;)
    {
      break label220;
      localObject1 = n.c.sqy;
      n.c.cEa();
      break;
      localObject1 = n.c.sqy;
      n.c.cEb();
      break;
      localObject1 = n.c.sqy;
      n.c.cEc();
      break;
      localObject1 = n.c.sqy;
      n.c.cEd();
      break;
      j = (int)(localFinderFeedReportObject.remuxEndTime - localFinderFeedReportObject.sendOrExitButtonTime);
      k = (int)(localFinderFeedReportObject.cdnEndTime - localFinderFeedReportObject.remuxEndTime);
      break label145;
      label352:
      Object localObject4 = ((Iterable)localObject6).iterator();
      localObject1 = "";
      int n = 0;
      Object localObject7;
      label445:
      Field localField;
      label495:
      int i1;
      label572:
      Object localObject9;
      if (((Iterator)localObject4).hasNext())
      {
        localObject7 = (FinderMediaReportObject)((Iterator)localObject4).next();
        localObject5 = new JSONObject();
        com.tencent.mm.ad.f.a(localObject7, (JSONObject)localObject5);
        i = n;
        Object localObject8;
        if (n == 0)
        {
          if (((FinderMediaReportObject)localObject7).zipTime > 0) {
            i = 1;
          }
        }
        else
        {
          Field[] arrayOfField1 = localObject7.getClass().getDeclaredFields();
          int i4 = arrayOfField1.length;
          n = 0;
          if (n >= i4) {
            break label942;
          }
          localField = arrayOfField1[n];
          localObject8 = localField.get(localObject7);
          if (localObject8 != null) {
            break label495;
          }
          localObject2 = localObject1;
        }
        Field[] arrayOfField2;
        int i5;
        label692:
        do
        {
          do
          {
            for (;;)
            {
              n += 1;
              localObject1 = localObject2;
              break label445;
              i = 0;
              break;
              if ((!(localObject8 instanceof Integer)) || (!(d.g.b.p.i(localObject8, Integer.valueOf(0)) ^ true))) {
                break label572;
              }
              localObject1 = new StringBuilder().append((String)localObject1);
              d.g.b.p.g(localField, "field");
              localObject2 = localField.getName() + ':' + localObject8 + ';';
            }
            if ((localObject8 instanceof String))
            {
              if (((CharSequence)localObject8).length() > 0) {}
              for (i1 = 1;; i1 = 0)
              {
                if (i1 == 0) {
                  break label662;
                }
                localObject1 = new StringBuilder().append((String)localObject1);
                d.g.b.p.g(localField, "field");
                localObject2 = localField.getName() + ':' + localObject8 + ';';
                break;
              }
            }
            localObject2 = localObject1;
          } while (!(localObject8 instanceof com.tencent.mm.bx.a));
          arrayOfField2 = localObject8.getClass().getDeclaredFields();
          i5 = arrayOfField2.length;
          i1 = 0;
          localObject2 = localObject1;
        } while (i1 >= i5);
        localObject2 = arrayOfField2[i1];
        localObject9 = ((Field)localObject2).get(localObject8);
        if (((localObject9 instanceof Integer)) && ((d.g.b.p.i(localObject9, Integer.valueOf(0)) ^ true)))
        {
          localObject1 = new StringBuilder().append((String)localObject1);
          d.g.b.p.g(localField, "field");
          localObject1 = ((StringBuilder)localObject1).append(localField.getName()).append('-');
          d.g.b.p.g(localObject2, "innerField");
          localObject1 = ((Field)localObject2).getName() + ':' + localObject9 + ';';
        }
      }
      label818:
      label1763:
      label1770:
      label1779:
      label1784:
      for (;;)
      {
        i1 += 1;
        break label692;
        if ((localObject9 instanceof String))
        {
          int i2;
          if (((CharSequence)localObject9).length() > 0) {
            i2 = 1;
          }
          for (;;)
          {
            if (i2 != 0)
            {
              localObject1 = new StringBuilder().append((String)localObject1);
              d.g.b.p.g(localField, "field");
              localObject1 = ((StringBuilder)localObject1).append(localField.getName()).append('-');
              d.g.b.p.g(localObject2, "innerField");
              localObject1 = ((Field)localObject2).getName() + ':' + localObject9 + ';';
              break label818;
              i2 = 0;
              continue;
              localObject1 = (String)localObject1 + "#";
              n = i;
              break;
              try
              {
                localObject2 = g.ajC();
                d.g.b.p.g(localObject2, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IGx, "");
                localObject2 = localObject4;
                if (!(localObject4 instanceof String)) {
                  localObject2 = null;
                }
                localObject4 = (String)localObject2;
                localObject2 = localObject4;
                if (localObject4 == null) {
                  localObject2 = "";
                }
                ((JSONObject)localObject5).put("snn", localObject2);
                localObject2 = (bvf)j.jd((List)paramFinderItem.getMediaList());
                if (localObject2 != null)
                {
                  localObject2 = ((bvf)localObject2).codec_info;
                  if (localObject2 != null) {
                    ((JSONObject)localObject5).put("codecInfo", "video_score:" + ((apb)localObject2).Gnw + ",video_cover_score:" + ((apb)localObject2).Gnx + ",video_audio_score:" + ((apb)localObject2).Gny + ",thumb_score:" + ((apb)localObject2).Gnz + ",hdimg_score:" + ((apb)localObject2).GnA + ",has_stickers:" + ((apb)localObject2).GnB);
                  }
                }
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  ad.printErrStackTrace(TAG, localThrowable, "mediaInfoJson put snn", new Object[0]);
                  continue;
                  Object localObject3 = localThrowable.GPr;
                  continue;
                  localObject3 = "";
                  continue;
                  localObject3 = Integer.valueOf(0);
                  continue;
                  i = 0;
                  continue;
                  paramFinderItem = Integer.valueOf(0);
                  continue;
                  localObject4 = localObject3;
                }
              }
              localObject2 = (bvf)j.jd((List)paramFinderItem.getMediaList());
              if (localObject2 != null)
              {
                if (bt.isNullOrNil(((bvf)localObject2).GPr))
                {
                  localObject2 = ((bvf)localObject2).url + bt.nullAsNil(((bvf)localObject2).url_token);
                  if (localObject2 != null) {
                    break label1792;
                  }
                }
              }
              else
              {
                localObject4 = "";
                localObject2 = ((JSONObject)localObject5).toString();
                d.g.b.p.g(localObject2, "mediaInfoJson.toString()");
                localObject7 = n.h((String)localObject2, ",", ";", false);
                localObject2 = (FinderMediaReportObject)j.jd((List)localObject6);
                if (localObject2 != null)
                {
                  if (((FinderMediaReportObject)localObject2).mediaType != 4) {
                    break label1763;
                  }
                  localObject2 = ((FinderMediaReportObject)j.jc((List)localObject6)).multiMediaInfo;
                  d.g.b.p.g(localObject2, "mediaReportList.first().multiMediaInfo");
                  localObject2 = dG((List)localObject2);
                  localObject5 = localObject2;
                  if (localObject2 != null) {}
                }
                else
                {
                  localObject5 = "";
                }
                localObject5 = n.h((String)localObject5, ",", ";", false);
                localObject6 = new StringBuilder().append(localFinderFeedReportObject.enterScene).append(',').append(localFinderFeedReportObject.sessionId).append(',');
                if (!paramBoolean) {
                  break label1770;
                }
                localObject2 = h.soM;
                localObject2 = h.wu(paramFinderItem.getId());
                localObject1 = ((StringBuilder)localObject6).append(localObject2).append(',').append(localFinderFeedReportObject.videoSource).append(',').append(cf.aCM() - localFinderFeedReportObject.sendOrExitButtonTime).append(',').append(n).append(',').append(k).append(',').append((String)localObject1).append(',');
                if (!paramBoolean) {
                  break label1779;
                }
                i = 1;
                localObject1 = ((StringBuilder)localObject1).append(i).append(',').append(j).append(',').append(soB).append(',').append(m).append(',').append(ay.getNetTypeString(aj.getContext())).append(',').append(localFinderFeedReportObject.retryCount).append(',').append(i3).append(',').append((String)localObject7).append(',').append(localFinderFeedReportObject.videoPostType).append(',').append(localFinderFeedReportObject.uploadLogicError).append(',').append(localFinderFeedReportObject.postStage).append(',').append((String)localObject5).append(',');
                if (!paramBoolean) {
                  break label1784;
                }
                localObject2 = h.soM;
                paramFinderItem = h.wu(paramFinderItem.getId());
                paramFinderItem = paramFinderItem + ',' + localFinderFeedReportObject.cgiErrorCode + ',' + localFinderFeedReportObject.cgiErrorType + ',' + (String)localObject4;
                ad.i(TAG, "19086 ".concat(String.valueOf(paramFinderItem)));
                com.tencent.mm.plugin.report.e.ygI.kvStat(19086, paramFinderItem);
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
    AppMethodBeat.i(203239);
    d.g.b.p.h(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = soy;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.v("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
      Object localObject = paramRecordMediaReportInfo.v("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
      d.g.b.p.g(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
      localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.v("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
      d.g.b.p.g(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
      localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
      d.g.b.p.g(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
      localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
      d.g.b.p.g(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
      localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.v("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
      d.g.b.p.g(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
      localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
      localObject = paramRecordMediaReportInfo.v("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(0));
      d.g.b.p.g(localObject, "reportInfo.getReportValu…EY_VIDEO_SUB_TYPE_INT, 0)");
      localFinderFeedReportObject.videoSubType = ((Number)localObject).intValue();
      localFinderFeedReportObject.postId = ((String)paramRecordMediaReportInfo.v("KEY_MULTI_MEDIA_POST_ID_STRING", ""));
      localFinderFeedReportObject.editId = ((String)paramRecordMediaReportInfo.v("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      localObject = paramRecordMediaReportInfo.v("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
      d.g.b.p.g(localObject, "reportInfo.getReportValu…SUB_RECORD_BOOLEAN,false)");
      if (((Boolean)localObject).booleanValue()) {}
      for (int i = 1;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.v("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…NGE_SUB_RECORD_TAB_INT,0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.v("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…VIDEO_RECORD_CLICK_INT,0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.v("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        d.g.b.p.g(localObject, "reportInfo.getReportValu…DEO_RECORD_SUCCESS_INT,0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.v("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        d.g.b.p.g(paramRecordMediaReportInfo, "reportInfo.getReportValue(KEY_SUB_VIDEO_NUM_INT,0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(203239);
        return;
      }
    }
    AppMethodBeat.o(203239);
  }
  
  public static void c(ArrayList<bvd> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203237);
    FinderFeedReportObject localFinderFeedReportObject = soy;
    if (localFinderFeedReportObject != null)
    {
      if (paramArrayList != null)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext()) {
          localHashSet.add(((bvd)localIterator.next()).username);
        }
        localFinderFeedReportObject.mentionCount = localHashSet.size();
      }
      localFinderFeedReportObject.clickMentionCount = paramInt1;
      localFinderFeedReportObject.clickSucMentionCount = paramInt2;
      if (paramArrayList != null) {}
      for (paramInt1 = paramArrayList.size();; paramInt1 = 0)
      {
        localFinderFeedReportObject.mentionRepeatCount = paramInt1;
        AppMethodBeat.o(203237);
        return;
      }
    }
    AppMethodBeat.o(203237);
  }
  
  public static FinderFeedReportObject cDv()
  {
    FinderFeedReportObject localFinderFeedReportObject = soy;
    soy = null;
    return localFinderFeedReportObject;
  }
  
  public static com.tencent.mm.plugin.finder.upload.l cDw()
  {
    return soA;
  }
  
  private static String dG(List<? extends FinderMediaReportInfo> paramList)
  {
    AppMethodBeat.i(203246);
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
    d.g.b.p.g(paramList, "array.toString()");
    AppMethodBeat.o(203246);
    return paramList;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public static void gm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203240);
    d.g.b.p.h(paramString1, "postId");
    FinderFeedReportObject localFinderFeedReportObject = soy;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.postId = paramString1;
      if (paramString2 != null) {
        localFinderFeedReportObject.editId = paramString2;
      }
      AppMethodBeat.o(203240);
      return;
    }
    AppMethodBeat.o(203240);
  }
  
  public static void k(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203245);
    ad.i(TAG, "savePostError " + paramLong + ", " + paramInt1 + ", " + paramInt2);
    Object localObject1 = b.sAs;
    localObject1 = b.a.xg(paramLong);
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
      localObject2 = b.sAs;
      b.a.i((FinderItem)localObject1);
      AppMethodBeat.o(203245);
      return;
    }
    AppMethodBeat.o(203245);
  }
  
  public static void wq(long paramLong)
  {
    AppMethodBeat.i(166572);
    Object localObject = d.szI;
    localObject = d.a.wT(paramLong);
    if (localObject != null)
    {
      a((FinderItem)localObject, true);
      h localh = h.soM;
      h.d((FinderItem)localObject);
      AppMethodBeat.o(166572);
      return;
    }
    AppMethodBeat.o(166572);
  }
  
  public static void wr(long paramLong)
  {
    AppMethodBeat.i(166573);
    Object localObject = b.sAs;
    localObject = b.a.xg(paramLong);
    if (localObject != null)
    {
      a((FinderItem)localObject, false);
      AppMethodBeat.o(166573);
      return;
    }
    AppMethodBeat.o(166573);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/report/FinderPostReportLogic$postListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.upload.l
  {
    public final void onPostEnd(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(166567);
      f localf = f.soC;
      f.wr(paramLong);
      AppMethodBeat.o(166567);
    }
    
    public final void onPostNotify(long paramLong, boolean paramBoolean) {}
    
    public final void onPostOk(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166568);
      f localf = f.soC;
      f.wq(paramLong2);
      AppMethodBeat.o(166568);
    }
    
    public final void onPostStart(long paramLong) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/report/FinderPostReportLogic$reportCurrentPostExit$1$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(FinderFeedReportObject paramFinderFeedReportObject, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/report/FinderPostReportLogic$startPost$1$1"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(FinderFeedReportObject paramFinderFeedReportObject, boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.f
 * JD-Core Version:    0.7.0.1
 */