package com.tencent.mm.plugin.finder.report;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.l;
import d.n.n;
import d.y;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderPostReportLogic;", "", "()V", "InnerVersion19086", "", "getInnerVersion19086", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "_18939InnerVersion", "", "finderFeedReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "postListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "setPostListener", "(Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;)V", "finishEdit", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "finishTakePhoto", "getReportInfoAndClear", "packageJson", "Lcom/tencent/mm/json/JSONObject;", "jsonObject", "key", "value", "pickMedia", "mediaSource", "postExit", "pageId", "report19086", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "success", "", "reportCurrentPost", "reportCurrentPostExit", "reportCurrentPostFail", "localId", "reportCurrentPostSuccess", "svrId", "setAtData", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "clickMentionCount", "clickSucMentionCount", "setDraft", "draft", "setPostId", "postId", "editId", "startPost", "entrance", "updateLBSFlag", "lbsFlag", "selectLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "Finder.FinderPostReportLogic";
  private static FinderFeedReportObject qFk;
  private static final long qFl = 1L;
  private static com.tencent.mm.plugin.finder.upload.k qFm;
  private static final int qFn = 7;
  public static final a qFo;
  
  static
  {
    AppMethodBeat.i(166575);
    qFo = new a();
    TAG = "Finder.FinderPostReportLogic";
    qFl = 1L;
    qFm = (com.tencent.mm.plugin.finder.upload.k)new a();
    qFn = 7;
    AppMethodBeat.o(166575);
  }
  
  public static void CJ(int paramInt)
  {
    AppMethodBeat.i(166569);
    FinderFeedReportObject localFinderFeedReportObject = new FinderFeedReportObject();
    qFk = localFinderFeedReportObject;
    localFinderFeedReportObject.sessionId = ((c)g.ab(c.class)).cbk();
    localFinderFeedReportObject.enterScene = paramInt;
    localFinderFeedReportObject.videoMediaInfo = "";
    localFinderFeedReportObject.actionTrace = "";
    localFinderFeedReportObject.videoMusicId = "";
    localFinderFeedReportObject.link = "";
    AppMethodBeat.o(166569);
  }
  
  public static void CK(int paramInt)
  {
    FinderFeedReportObject localFinderFeedReportObject = qFk;
    if (localFinderFeedReportObject != null) {
      localFinderFeedReportObject.videoSource = paramInt;
    }
  }
  
  public static void CL(int paramInt)
  {
    AppMethodBeat.i(166571);
    Object localObject1 = qFk;
    if (localObject1 != null)
    {
      ((FinderFeedReportObject)localObject1).exitPageId = paramInt;
      if (paramInt == 4) {
        ((FinderFeedReportObject)localObject1).sendOrExitButtonTime = ce.asS();
      }
      FinderFeedReportObject localFinderFeedReportObject = qFk;
      af localaf;
      Object localObject2;
      if (localFinderFeedReportObject != null)
      {
        localaf = new af();
        localaf.gT(localFinderFeedReportObject.sessionId);
        localaf.it(localFinderFeedReportObject.enterScene);
        localaf.iu(2);
        localaf.gU("0");
        localaf.iv(localFinderFeedReportObject.exitPageId);
        localaf.df(localFinderFeedReportObject.enterTakePhotoTime);
        localaf.dg(localFinderFeedReportObject.enterVideoEditTime);
        localaf.dh(localFinderFeedReportObject.sendOrExitButtonTime);
        localaf.di(localFinderFeedReportObject.videoRecordTime);
        localaf.dj(localFinderFeedReportObject.videoSource);
        localaf.dk(localFinderFeedReportObject.videoEmojiCount);
        localaf.dl(localFinderFeedReportObject.videoWordingCount);
        localaf.gV(localFinderFeedReportObject.videoMusicId);
        localaf.dm(localFinderFeedReportObject.videoMusicIndex);
        localaf.dn(localFinderFeedReportObject.videoMusicSearch);
        localaf.jdMethod_do(localFinderFeedReportObject.videoPostType);
        localObject2 = localFinderFeedReportObject.videoMediaInfo;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localaf.gW((String)localObject1);
        localaf.dp(localFinderFeedReportObject.existDesc);
        localaf.dq(localFinderFeedReportObject.descCount);
        localObject2 = localFinderFeedReportObject.actionTrace;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localaf.gX((String)localObject1);
        localaf.dr(localFinderFeedReportObject.existLocation);
        localaf.gY(localFinderFeedReportObject.link);
        localaf.ds(localFinderFeedReportObject.draft);
        localaf.gZ("");
        localaf.ha("");
        if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
          break label597;
        }
      }
      label597:
      for (long l = 0L;; l = qFl)
      {
        localaf.dt(l);
        localaf.kK(localFinderFeedReportObject.mentionCount);
        localaf.zb(localFinderFeedReportObject.clickMentionCount);
        localaf.zc(localFinderFeedReportObject.clickSucMentionCount);
        localaf.zd(localFinderFeedReportObject.mentionRepeatCount);
        localaf.hb("");
        localObject1 = a(a(a(a(a(null, "IsMultiShot", localFinderFeedReportObject.isMultiShot), "MultiShotChangeCnt", localFinderFeedReportObject.multiShotChangeCnt), "MultiShotClickCnt", localFinderFeedReportObject.multiShotClickCnt), "MultiShotSuccessCnt", localFinderFeedReportObject.multiShotSuccessCnt), "MultiShotVideoCnt", localFinderFeedReportObject.multiShotVideoCnt).toString();
        d.g.b.k.g(localObject1, "recordInfo.toString()");
        localaf.aSg(n.h((String)localObject1, ",", ";", false));
        localaf.ze(localFinderFeedReportObject.videoSubType);
        localaf.aSh(localFinderFeedReportObject.postId);
        localaf.aSi(localFinderFeedReportObject.editId);
        localObject1 = localFinderFeedReportObject.selectLocation;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
          localaf.aSj(com.tencent.mm.plugin.finder.utils.i.fY(((ajq)localObject1).evA, ((ajq)localObject1).goQ));
        }
        localaf.aBj();
        localObject1 = b.qFq;
        b.a((com.tencent.mm.plugin.report.a)localaf);
        qFk = null;
        AppMethodBeat.o(166571);
        return;
      }
    }
    AppMethodBeat.o(166571);
  }
  
  private static com.tencent.mm.ac.i a(com.tencent.mm.ac.i parami, String paramString, int paramInt)
  {
    AppMethodBeat.i(198784);
    com.tencent.mm.ac.i locali = parami;
    if (parami == null) {
      locali = new com.tencent.mm.ac.i();
    }
    try
    {
      locali.O(paramString, paramInt);
      label27:
      AppMethodBeat.o(198784);
      return locali;
    }
    catch (Exception parami)
    {
      break label27;
    }
  }
  
  public static void a(int paramInt, ajq paramajq)
  {
    FinderFeedReportObject localFinderFeedReportObject = qFk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.lbsFlag = paramInt;
      localFinderFeedReportObject.selectLocation = paramajq;
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
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (bmd)((Iterator)localObject3).next();
      localObject1 = (String)localObject1 + ((bmd)localObject4).mediaType + ';' + ((bmd)localObject4).videoDuration + '#';
      if (bt.isNullOrNil(((bmd)localObject4).coverUrl)) {}
      for (i = 0;; i = 1)
      {
        ((Collection)localObject2).add(y.JfV);
        break;
      }
    }
    Object localObject4 = paramFinderItem.field_reportObject;
    if (localObject4 != null)
    {
      localObject3 = new af();
      ((af)localObject3).gT(((FinderFeedReportObject)localObject4).sessionId);
      ((af)localObject3).it(((FinderFeedReportObject)localObject4).enterScene);
      if (paramBoolean)
      {
        ((af)localObject3).iu(j);
        localObject2 = b.qFq;
        ((af)localObject3).gU(b.qi(paramFinderItem.getId()));
        ((af)localObject3).iv(((FinderFeedReportObject)localObject4).exitPageId);
        ((af)localObject3).df(((FinderFeedReportObject)localObject4).enterTakePhotoTime);
        ((af)localObject3).dg(((FinderFeedReportObject)localObject4).enterVideoEditTime);
        ((af)localObject3).dh(((FinderFeedReportObject)localObject4).sendOrExitButtonTime);
        ((af)localObject3).di(((FinderFeedReportObject)localObject4).videoRecordTime);
        ((af)localObject3).dj(((FinderFeedReportObject)localObject4).videoSource);
        ((af)localObject3).dk(((FinderFeedReportObject)localObject4).videoEmojiCount);
        ((af)localObject3).dl(((FinderFeedReportObject)localObject4).videoWordingCount);
        ((af)localObject3).gV(((FinderFeedReportObject)localObject4).videoMusicId);
        ((af)localObject3).dm(((FinderFeedReportObject)localObject4).videoMusicIndex);
        ((af)localObject3).dn(((FinderFeedReportObject)localObject4).videoMusicSearch);
        ((af)localObject3).jdMethod_do(((FinderFeedReportObject)localObject4).videoPostType);
        ((af)localObject3).gW((String)localObject1);
        ((af)localObject3).dp(((FinderFeedReportObject)localObject4).existDesc);
        ((af)localObject3).dq(((FinderFeedReportObject)localObject4).descCount);
        localObject2 = ((FinderFeedReportObject)localObject4).actionTrace;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((af)localObject3).gX((String)localObject1);
        ((af)localObject3).dr(((FinderFeedReportObject)localObject4).lbsFlag);
        ((af)localObject3).gY(((FinderFeedReportObject)localObject4).link);
        ((af)localObject3).ds(((FinderFeedReportObject)localObject4).draft);
        localObject1 = com.tencent.mm.plugin.finder.utils.h.qSR;
        ((af)localObject3).gZ(n.h(com.tencent.mm.plugin.finder.utils.h.l(paramFinderItem), ",", ";", false));
        ((af)localObject3).ha("");
        if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
          break label756;
        }
      }
      label756:
      for (long l = 0L;; l = qFl)
      {
        ((af)localObject3).dt(l);
        ((af)localObject3).kK(((FinderFeedReportObject)localObject4).mentionCount);
        ((af)localObject3).zb(((FinderFeedReportObject)localObject4).clickMentionCount);
        ((af)localObject3).zc(((FinderFeedReportObject)localObject4).clickSucMentionCount);
        ((af)localObject3).zd(((FinderFeedReportObject)localObject4).mentionRepeatCount);
        ((af)localObject3).hb("");
        ((af)localObject3).kJ(i);
        localObject1 = a(a(a(a(a(null, "IsMultiShot", ((FinderFeedReportObject)localObject4).isMultiShot), "MultiShotChangeCnt", ((FinderFeedReportObject)localObject4).multiShotChangeCnt), "MultiShotClickCnt", ((FinderFeedReportObject)localObject4).multiShotClickCnt), "MultiShotSuccessCnt", ((FinderFeedReportObject)localObject4).multiShotSuccessCnt), "MultiShotVideoCnt", ((FinderFeedReportObject)localObject4).multiShotVideoCnt).toString();
        d.g.b.k.g(localObject1, "recordInfo.toString()");
        ((af)localObject3).aSg(n.h((String)localObject1, ",", ";", false));
        ((af)localObject3).ze(((FinderFeedReportObject)localObject4).videoSubType);
        ((af)localObject3).aSh(((FinderFeedReportObject)localObject4).postId);
        ((af)localObject3).aSi(((FinderFeedReportObject)localObject4).editId);
        localObject1 = paramFinderItem.getLocation();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
          ((af)localObject3).aSj(com.tencent.mm.plugin.finder.utils.i.fY(((ajq)localObject1).evA, ((ajq)localObject1).goQ));
        }
        ((af)localObject3).aBj();
        localObject1 = b.qFq;
        b.a((com.tencent.mm.plugin.report.a)localObject3);
        b(paramFinderItem, paramBoolean);
        AppMethodBeat.o(178388);
        return;
        j = 0;
        break;
      }
    }
    AppMethodBeat.o(178388);
  }
  
  private static void b(FinderItem paramFinderItem, boolean paramBoolean)
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
        localObject3 = ((bmd)((Iterator)localObject2).next()).DJE;
      } while (localObject3 == null);
      if (((FinderMediaReportObject)localObject3).cdnUploadRetCode == 0) {
        break label1051;
      }
      ((ArrayList)localObject1).add(localObject3);
      i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
    }
    label271:
    label1040:
    label1045:
    label1051:
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
      label253:
      Field localField;
      label321:
      int i1;
      label488:
      Object localObject5;
      if (((Iterator)localObject3).hasNext())
      {
        FinderMediaReportObject localFinderMediaReportObject = (FinderMediaReportObject)((Iterator)localObject3).next();
        if (i != 0) {
          break label1045;
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
            break label768;
          }
          localField = arrayOfField1[n];
          localObject4 = localField.get(localFinderMediaReportObject);
          if (localObject4 != null) {
            break label321;
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
              break label271;
              i = 0;
              break;
              if ((!(localObject4 instanceof Integer)) || (!(d.g.b.k.g(localObject4, Integer.valueOf(0)) ^ true))) {
                break label398;
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
                  break label488;
                }
                localObject1 = new StringBuilder().append((String)localObject1);
                d.g.b.k.g(localField, "field");
                localObject2 = localField.getName() + ':' + localObject4 + ';';
                break;
              }
            }
            localObject2 = localObject1;
          } while (!(localObject4 instanceof com.tencent.mm.bx.a));
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
        break label518;
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
              break label644;
              i2 = 0;
              continue;
              localObject1 = (String)localObject1 + "#";
              break;
              localObject2 = new StringBuilder().append(localFinderFeedReportObject.enterScene).append(',').append(localFinderFeedReportObject.sessionId).append(',');
              if (paramBoolean)
              {
                localObject3 = b.qFq;
                paramFinderItem = b.qi(paramFinderItem.getId());
                paramFinderItem = ((StringBuilder)localObject2).append(paramFinderItem).append(',').append(localFinderFeedReportObject.videoSource).append(',').append(ce.asS() - localFinderFeedReportObject.sendOrExitButtonTime).append(',').append(i).append(',').append(k).append(',').append((String)localObject1).append(',');
                if (!paramBoolean) {
                  break label1040;
                }
              }
              for (i = 1;; i = 0)
              {
                paramFinderItem = i + ',' + j + ',' + qFn + ',' + m + ',' + ay.getNetTypeString(aj.getContext()) + ',' + localFinderFeedReportObject.retryCount + ',' + i3;
                ad.i(TAG, "19086 ".concat(String.valueOf(paramFinderItem)));
                e.vIY.kvStat(19086, paramFinderItem);
                AppMethodBeat.o(166574);
                return;
                paramFinderItem = Integer.valueOf(0);
                break;
              }
              break label253;
            }
          }
        }
      }
    }
  }
  
  public static void b(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    int j = 1;
    AppMethodBeat.i(198780);
    d.g.b.k.h(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = qFk;
    if (localFinderFeedReportObject != null)
    {
      Object localObject = paramRecordMediaReportInfo.w("KEY_RECORD_IS_BEAUTIFY", Boolean.FALSE);
      d.g.b.k.g(localObject, "reportInfo.getReportValu…ECORD_IS_BEAUTIFY, false)");
      if (((Boolean)localObject).booleanValue())
      {
        i = 1;
        localFinderFeedReportObject.isBeauty = i;
        localObject = paramRecordMediaReportInfo.w("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(0L));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…DIA_DURATION_MS_LONG, 0L)");
        localFinderFeedReportObject.videoRecordTime = ((Number)localObject).longValue();
        localFinderFeedReportObject.videoSource = (((Number)paramRecordMediaReportInfo.w("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
        localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.w("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
        localObject = paramRecordMediaReportInfo.w("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
        localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.w("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
        localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
        localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
        localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.w("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.w("KEY_ENTER_TIME_MS_LONG", Long.valueOf(0L));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…Y_ENTER_TIME_MS_LONG, 0L)");
        localFinderFeedReportObject.enterTakePhotoTime = ((Number)localObject).longValue();
        localObject = paramRecordMediaReportInfo.w("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
        d.g.b.k.g(localObject, "reportInfo.getReportValu…SUB_RECORD_BOOLEAN,false)");
        if (!((Boolean)localObject).booleanValue()) {
          break label518;
        }
      }
      label518:
      for (int i = j;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.w("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…NGE_SUB_RECORD_TAB_INT,0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.w("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…VIDEO_RECORD_CLICK_INT,0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.w("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…DEO_RECORD_SUCCESS_INT,0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.w("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        d.g.b.k.g(paramRecordMediaReportInfo, "reportInfo.getReportValue(KEY_SUB_VIDEO_NUM_INT,0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(198780);
        return;
        i = 0;
        break;
      }
    }
    AppMethodBeat.o(198780);
  }
  
  public static void c(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(198781);
    d.g.b.k.h(paramRecordMediaReportInfo, "reportInfo");
    FinderFeedReportObject localFinderFeedReportObject = qFk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.videoMusicId = String.valueOf(((Number)paramRecordMediaReportInfo.w("KEY_MUSIC_REQ_ID_INT", Integer.valueOf(0))).intValue());
      Object localObject = paramRecordMediaReportInfo.w("KEY_SEARCH_MUSIC_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
      localFinderFeedReportObject.videoMusicSearch = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.w("KEY_MUSIC_INDEX_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
      localFinderFeedReportObject.videoMusicIndex = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
      localFinderFeedReportObject.videoEmojiCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
      localFinderFeedReportObject.videoWordingCount = ((Number)localObject).intValue();
      localObject = paramRecordMediaReportInfo.w("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(0L));
      d.g.b.k.g(localObject, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
      localFinderFeedReportObject.enterVideoEditTime = ((Number)localObject).longValue();
      localObject = paramRecordMediaReportInfo.w("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(0));
      d.g.b.k.g(localObject, "reportInfo.getReportValu…EY_VIDEO_SUB_TYPE_INT, 0)");
      localFinderFeedReportObject.videoSubType = ((Number)localObject).intValue();
      localFinderFeedReportObject.postId = ((String)paramRecordMediaReportInfo.w("KEY_MULTI_MEDIA_POST_ID_STRING", ""));
      localFinderFeedReportObject.editId = ((String)paramRecordMediaReportInfo.w("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      localObject = paramRecordMediaReportInfo.w("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
      d.g.b.k.g(localObject, "reportInfo.getReportValu…SUB_RECORD_BOOLEAN,false)");
      if (((Boolean)localObject).booleanValue()) {}
      for (int i = 1;; i = 0)
      {
        localFinderFeedReportObject.isMultiShot = i;
        localObject = paramRecordMediaReportInfo.w("KEY_CHANGE_SUB_RECORD_TAB_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…NGE_SUB_RECORD_TAB_INT,0)");
        localFinderFeedReportObject.multiShotChangeCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.w("KEY_SUB_VIDEO_RECORD_CLICK_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…VIDEO_RECORD_CLICK_INT,0)");
        localFinderFeedReportObject.multiShotClickCnt = ((Number)localObject).intValue();
        localObject = paramRecordMediaReportInfo.w("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", Integer.valueOf(0));
        d.g.b.k.g(localObject, "reportInfo.getReportValu…DEO_RECORD_SUCCESS_INT,0)");
        localFinderFeedReportObject.multiShotSuccessCnt = ((Number)localObject).intValue();
        paramRecordMediaReportInfo = paramRecordMediaReportInfo.w("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(0));
        d.g.b.k.g(paramRecordMediaReportInfo, "reportInfo.getReportValue(KEY_SUB_VIDEO_NUM_INT,0)");
        localFinderFeedReportObject.multiShotVideoCnt = ((Number)paramRecordMediaReportInfo).intValue();
        AppMethodBeat.o(198781);
        return;
      }
    }
    AppMethodBeat.o(198781);
  }
  
  public static com.tencent.mm.plugin.finder.upload.k cnA()
  {
    return qFm;
  }
  
  public static FinderFeedReportObject cnz()
  {
    FinderFeedReportObject localFinderFeedReportObject = qFk;
    qFk = null;
    return localFinderFeedReportObject;
  }
  
  public static void d(ArrayList<ebc> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198779);
    FinderFeedReportObject localFinderFeedReportObject = qFk;
    if (localFinderFeedReportObject != null)
    {
      if (paramArrayList != null)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext()) {
          localHashSet.add(((ebc)localIterator.next()).username);
        }
        localFinderFeedReportObject.mentionCount = localHashSet.size();
      }
      localFinderFeedReportObject.clickMentionCount = paramInt1;
      localFinderFeedReportObject.clickSucMentionCount = paramInt2;
      if (paramArrayList != null) {}
      for (paramInt1 = paramArrayList.size();; paramInt1 = 0)
      {
        localFinderFeedReportObject.mentionRepeatCount = paramInt1;
        AppMethodBeat.o(198779);
        return;
      }
    }
    AppMethodBeat.o(198779);
  }
  
  public static void kZ(boolean paramBoolean)
  {
    FinderFeedReportObject localFinderFeedReportObject = qFk;
    if (localFinderFeedReportObject != null) {
      if (!paramBoolean) {
        break label20;
      }
    }
    label20:
    for (int i = 1;; i = 0)
    {
      localFinderFeedReportObject.draft = i;
      return;
    }
  }
  
  public static void ka(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198782);
    d.g.b.k.h(paramString1, "postId");
    FinderFeedReportObject localFinderFeedReportObject = qFk;
    if (localFinderFeedReportObject != null)
    {
      localFinderFeedReportObject.postId = paramString1;
      if (paramString2 != null) {
        localFinderFeedReportObject.editId = paramString2;
      }
      AppMethodBeat.o(198782);
      return;
    }
    AppMethodBeat.o(198782);
  }
  
  public static void qf(long paramLong)
  {
    AppMethodBeat.i(166572);
    Object localObject = com.tencent.mm.plugin.finder.storage.data.b.qKl;
    localObject = com.tencent.mm.plugin.finder.storage.data.b.a.qC(paramLong);
    if (localObject != null)
    {
      a((FinderItem)localObject, true);
      b localb = b.qFq;
      b.n((FinderItem)localObject);
      AppMethodBeat.o(166572);
      return;
    }
    AppMethodBeat.o(166572);
  }
  
  public static void qg(long paramLong)
  {
    AppMethodBeat.i(166573);
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    localObject = com.tencent.mm.plugin.finder.storage.logic.b.a.qG(paramLong);
    if (localObject != null)
    {
      a((FinderItem)localObject, false);
      AppMethodBeat.o(166573);
      return;
    }
    AppMethodBeat.o(166573);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/report/FinderPostReportLogic$postListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.finder.upload.k
  {
    public final void onPostEnd(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(166567);
      a locala = a.qFo;
      a.qg(paramLong);
      AppMethodBeat.o(166567);
    }
    
    public final void onPostNotify(long paramLong, boolean paramBoolean) {}
    
    public final void onPostOk(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166568);
      a locala = a.qFo;
      a.qf(paramLong2);
      AppMethodBeat.o(166568);
    }
    
    public final void onPostStart(long paramLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.a
 * JD-Core Version:    0.7.0.1
 */