package com.tencent.mm.plugin.finder.report;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderDraftReportLogic;", "", "()V", "InnerVersion23348", "", "getInnerVersion23348", "()I", "TAG", "", "draftItemCacheForReport", "Ljava/util/Vector;", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "postDraftListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostDraftListener;", "getPostDraftListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostDraftListener;", "setPostDraftListener", "(Lcom/tencent/mm/plugin/finder/upload/IFinderPostDraftListener;)V", "cacheDraftItem", "", "draftItem", "report23348", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "success", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h Fop;
  private static final int Foq;
  private static final Vector<i> For;
  private static q Fos;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(331482);
    Fop = new h();
    TAG = "Finder.FinderDraftReportLogic";
    Foq = 14;
    For = new Vector();
    Fos = (q)new b();
    AppMethodBeat.o(331482);
  }
  
  public static void a(FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(331469);
    s.u(paramFinderItem, "finderItem");
    Log.i(TAG, "report23348 localId:" + paramFinderItem.getLocalId() + ", " + paramBoolean);
    FinderFeedReportObject localFinderFeedReportObject = paramFinderItem.field_reportObject;
    if (localFinderFeedReportObject == null)
    {
      Log.e(TAG, "report23348, feedReportObj is null");
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1253L, 38L, 1L, false);
      AppMethodBeat.o(331469);
      return;
    }
    Object localObject1 = d.FAy;
    ((Number)d.eQB().bmg()).intValue();
    if (!paramBoolean) {
      switch (localFinderFeedReportObject.postStage)
      {
      default: 
        Log.w(TAG, s.X("postStage range error, ", Integer.valueOf(localFinderFeedReportObject.postStage)));
        localObject1 = ah.aiuX;
      }
    }
    int i1;
    boolean bool;
    int i6;
    int i4;
    int i2;
    int i3;
    long l;
    int k;
    Object localObject6;
    int i5;
    Object localObject5;
    int j;
    for (;;)
    {
      localObject1 = v.FrN;
      i1 = v.h(paramFinderItem);
      bool = paramFinderItem.isLongVideo();
      i6 = localFinderFeedReportObject.uploadCost;
      i4 = localFinderFeedReportObject.mediaProcessCost;
      i2 = localFinderFeedReportObject.postTaskCost;
      i3 = localFinderFeedReportObject.clickRepostCount;
      l = localFinderFeedReportObject.uploadMediaTotalSize;
      k = 0;
      i = 0;
      localObject6 = new ArrayList();
      i5 = CdnLogic.getRecentAverageSpeed(1);
      localObject5 = new JSONObject();
      ((ArrayList)localObject6).addAll((Collection)localFinderFeedReportObject.mediaList);
      if (paramBoolean) {
        break label524;
      }
      ((ArrayList)localObject6).addAll((Collection)localFinderFeedReportObject.mediaList);
      localObject1 = ((Iterable)paramFinderItem.getMediaList()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ((dji)((Iterator)localObject1).next()).aaPt;
        j = i;
        if (localObject3 != null)
        {
          if (((FinderMediaReportObject)localObject3).cdnUploadRetCode != 0)
          {
            ((ArrayList)localObject6).add(localObject3);
            i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
          }
          localObject3 = ah.aiuX;
          localObject3 = ah.aiuX;
          j = i;
        }
        i = j;
      }
      localObject1 = i.c.FoQ;
      i.c.tn(paramFinderItem.isLongVideo());
      localObject1 = ah.aiuX;
      continue;
      localObject1 = i.c.FoQ;
      i.c.to(paramFinderItem.isLongVideo());
      localObject1 = ah.aiuX;
      continue;
      localObject1 = i.c.FoQ;
      i.c.tp(paramFinderItem.isLongVideo());
      localObject1 = ah.aiuX;
      continue;
      localObject1 = i.c.FoQ;
      i.c.tq(paramFinderItem.isLongVideo());
      localObject1 = ah.aiuX;
    }
    localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
    for (;;)
    {
      k = i;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject3 = ((dji)((Iterator)localObject1).next()).aaPt;
      if (localObject3 != null)
      {
        if (((FinderMediaReportObject)localObject3).cdnUploadRetCode != 0)
        {
          ((ArrayList)localObject6).add(localObject3);
          i = ((FinderMediaReportObject)localObject3).cdnUploadRetCode;
        }
        localObject3 = ah.aiuX;
        localObject3 = ah.aiuX;
      }
    }
    label524:
    Object localObject4 = ((Iterable)localObject6).iterator();
    Object localObject3 = "";
    Object localObject7;
    int m;
    Object localObject8;
    int i7;
    Object localObject9;
    label723:
    int n;
    for (int i = 0; ((Iterator)localObject4).hasNext(); i = m)
    {
      localObject7 = (FinderMediaReportObject)((Iterator)localObject4).next();
      localObject5 = new JSONObject();
      com.tencent.mm.ae.f.a(localObject7, (JSONObject)localObject5);
      m = i;
      if (i == 0) {
        if (((FinderMediaReportObject)localObject7).zipTime <= 0) {
          break label723;
        }
      }
      for (i = 1;; i = 0)
      {
        m = i;
        localObject8 = localObject7.getClass().getDeclaredFields();
        s.s(localObject8, "fields");
        i = 0;
        i7 = localObject8.length;
        for (localObject1 = localObject3;; localObject1 = (String)localObject1 + ((Field)localObject3).getName() + ':' + localObject9 + ';')
        {
          if (i >= i7) {
            break label1028;
          }
          localObject3 = localObject8[i];
          i += 1;
          localObject9 = ((Field)localObject3).get(localObject7);
          if (localObject9 == null) {
            break label2254;
          }
          if ((!(localObject9 instanceof Integer)) || (s.p(localObject9, Integer.valueOf(0)))) {
            break;
          }
        }
      }
      if ((localObject9 instanceof String))
      {
        if (((CharSequence)localObject9).length() > 0) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label803;
          }
          localObject1 = (String)localObject1 + ((Field)localObject3).getName() + ':' + localObject9 + ';';
          break;
        }
      }
      label803:
      if (!(localObject9 instanceof a)) {
        break label2254;
      }
      Field[] arrayOfField = localObject9.getClass().getDeclaredFields();
      s.s(arrayOfField, "innerFields");
      j = 0;
      int i8 = arrayOfField.length;
      label836:
      Field localField;
      Object localObject10;
      for (;;)
      {
        if (j >= i8) {
          break label2257;
        }
        localField = arrayOfField[j];
        j += 1;
        localObject10 = localField.get(localObject9);
        if ((!(localObject10 instanceof Integer)) || (s.p(localObject10, Integer.valueOf(0)))) {
          break;
        }
        localObject1 = (String)localObject1 + ((Field)localObject3).getName() + '-' + localField.getName() + ':' + localObject10 + ';';
      }
      if (!(localObject10 instanceof String)) {
        break label2251;
      }
      if (((CharSequence)localObject10).length() > 0) {}
      for (n = 1;; n = 0)
      {
        if (n == 0) {
          break label2251;
        }
        localObject1 = (String)localObject1 + ((Field)localObject3).getName() + '-' + localField.getName() + ':' + localObject10 + ';';
        break;
      }
      label1028:
      localObject3 = s.X((String)localObject1, "#");
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
        Log.printErrStackTrace(TAG, localThrowable, "mediaInfoJson put snn", new Object[0]);
        continue;
        if (!Util.isNullOrNil(localThrowable.aaPd)) {
          continue;
        }
        localObject2 = s.X(localThrowable.url, Util.nullAsNil(localThrowable.url_token));
        if (localObject2 != null) {
          continue;
        }
        localObject4 = "";
        continue;
        localObject2 = ((dji)localObject2).aaPd;
        continue;
        localObject4 = localObject2;
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
        if (((FinderMediaReportObject)localObject5).mediaType != 4) {
          continue;
        }
        localObject5 = v.FrN;
        localObject5 = ((FinderMediaReportObject)p.oK((List)localObject6)).multiMediaInfo;
        s.s(localObject5, "mediaReportList.first().multiMediaInfo");
        localObject6 = v.hr((List)localObject5);
        localObject5 = localObject6;
        if (localObject6 != null) {
          continue;
        }
        localObject5 = "";
        continue;
        localObject6 = "";
        continue;
        j = 0;
        continue;
        j = 0;
        continue;
        localObject5 = Integer.valueOf(0);
        continue;
        i = 0;
        continue;
        paramFinderItem = Integer.valueOf(0);
        continue;
        i = 2;
        continue;
      }
      ((JSONObject)localObject5).put("snn", localObject4);
      localObject1 = (dji)p.oL((List)paramFinderItem.getMediaList());
      if (localObject1 != null)
      {
        localObject1 = ((dji)localObject1).codec_info;
        if (localObject1 != null)
        {
          ((JSONObject)localObject5).put("codecInfo", "video_score:" + ((boy)localObject1).ZXq + ",video_cover_score:" + ((boy)localObject1).ZXr + ",video_audio_score:" + ((boy)localObject1).ZXs + ",thumb_score:" + ((boy)localObject1).ZXt + ",hdimg_score:" + ((boy)localObject1).ZXu + ",has_stickers:" + ((boy)localObject1).ZXv);
          localObject1 = ah.aiuX;
        }
      }
      localObject1 = (dji)p.oL((List)paramFinderItem.getMediaList());
      if (localObject1 == null)
      {
        localObject4 = "";
        if (!bool) {
          continue;
        }
        localObject1 = paramFinderItem.getLongVideoMediaList();
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        localObject5 = ((JSONObject)localObject5).toString();
        s.s(localObject5, "mediaInfoJson.toString()");
        localObject7 = n.bV((String)localObject5, ",", ";");
        localObject5 = (FinderMediaReportObject)p.oL((List)localObject6);
        if (localObject5 != null) {
          continue;
        }
        localObject5 = "";
        localObject8 = n.bV((String)localObject5, ",", ";");
        m = localFinderFeedReportObject.dumpCgiErrorCode;
        n = localFinderFeedReportObject.dumpCgiErrorType;
        i7 = localFinderFeedReportObject.sdkShareType;
        localObject5 = paramFinderItem.getFeedObject().objectDesc;
        if (localObject5 == null) {
          continue;
        }
        localObject5 = ((FinderObjectDesc)localObject5).event;
        if ((localObject5 == null) || (((brg)localObject5).ocD != 0L)) {
          continue;
        }
        j = 1;
        if (j != 0) {
          continue;
        }
        j = 1;
        Log.i(TAG, "23348, sdkShareType:" + i7 + ", isActivityEvent:" + j + ", dumpCgiErrorType:" + n + ", dumpCgiErrorCode:" + m);
        localObject6 = new StringBuilder();
        localObject9 = ((StringBuilder)localObject6).append(localFinderFeedReportObject.enterScene).append(',').append(localFinderFeedReportObject.sessionId).append(',');
        if (!paramBoolean) {
          continue;
        }
        localObject5 = z.FrZ;
        localObject5 = z.pL(paramFinderItem.getId());
        localObject3 = ((StringBuilder)localObject9).append(localObject5).append(',').append(localFinderFeedReportObject.videoSource).append(',').append(cn.bDw() - localFinderFeedReportObject.sendOrExitButtonTime).append(',').append(i).append(',').append(i6).append(',').append((String)localObject3).append(',');
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        ((StringBuilder)localObject3).append(i).append(',').append(i4).append(',').append(Foq).append(',').append(k);
        localObject3 = ((StringBuilder)localObject6).append(',').append(NetStatusUtil.getNetTypeString(MMApplicationContext.getContext())).append(',').append(localFinderFeedReportObject.retryCount).append(',').append(i5).append(',').append((String)localObject7).append(',').append(localFinderFeedReportObject.videoPostType).append(',').append(localFinderFeedReportObject.uploadLogicError).append(',').append(localFinderFeedReportObject.postStage).append(',').append((String)localObject8).append(',');
        if (!paramBoolean) {
          continue;
        }
        localObject5 = z.FrZ;
        paramFinderItem = z.pL(paramFinderItem.getId());
        ((StringBuilder)localObject3).append(paramFinderItem).append(',').append(localFinderFeedReportObject.cgiErrorCode).append(',').append(localFinderFeedReportObject.cgiErrorType).append(',');
        paramFinderItem = ((StringBuilder)localObject6).append((String)localObject4).append(',');
        if (!bool) {
          continue;
        }
        i = 1;
        paramFinderItem.append(i).append(',').append(localObject1).append(',').append(localFinderFeedReportObject.megaCgiErrorCode).append(',').append(localFinderFeedReportObject.megaCgiErrorType).append(',').append(localFinderFeedReportObject.longVideoSizeInvalid).append(',').append(i2).append(',').append(i3).append(',').append(l).append(',').append(m).append(',').append(n).append(',').append(i7);
        ((StringBuilder)localObject6).append(',').append(j).append(',').append(i1);
        paramFinderItem = ((StringBuilder)localObject6).toString();
        Log.i(TAG, s.X("23348 ", paramFinderItem));
        com.tencent.mm.plugin.report.f.Ozc.kvStat(23348, paramFinderItem);
        AppMethodBeat.o(331469);
        return;
        localObject1 = null;
        break label2260;
      }
      label2251:
      break label836;
      label2254:
      break;
      label2257:
      break;
      label2260:
      localObject4 = localObject2;
      if (localObject2 == null) {
        localObject4 = "";
      }
    }
  }
  
  public static void c(i parami)
  {
    AppMethodBeat.i(331432);
    s.u(parami, "draftItem");
    try
    {
      parami.eYM();
      i locali = new i();
      locali.field_localId = parami.field_localId;
      locali.field_createTime = parami.field_createTime;
      locali.field_localFlag = parami.field_localFlag;
      locali.field_finderItem = parami.field_finderItem;
      locali.field_objectType = parami.field_objectType;
      locali.field_postIntent = parami.field_postIntent;
      locali.field_originMvInfo = parami.field_originMvInfo;
      locali.field_objectId = parami.field_objectId;
      locali.field_markDeleted = parami.field_markDeleted;
      locali.field_version = parami.field_version;
      locali.field_dbversion = parami.field_dbversion;
      p.e((List)For, (kotlin.g.a.b)new h.a(locali));
      For.add(locali);
      return;
    }
    finally
    {
      AppMethodBeat.o(331432);
    }
  }
  
  public static q eMo()
  {
    return Fos;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderDraftReportLogic$postDraftListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostDraftListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements q
  {
    public final void nI(long paramLong)
    {
      AppMethodBeat.i(331186);
      label106:
      for (;;)
      {
        try
        {
          Object localObject3 = ((Iterable)h.eMp()).iterator();
          Object localObject1;
          int i;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (((i)localObject1).field_localId == paramLong)
            {
              i = 1;
              break label106;
              localObject1 = (i)localObject1;
              if (localObject1 != null)
              {
                localObject3 = h.Fop;
                h.a(((i)localObject1).eYK(), true);
                AppMethodBeat.o(331186);
              }
            }
            else
            {
              i = 0;
              break label106;
            }
          }
          else
          {
            localObject1 = null;
            continue;
          }
          if (i == 0) {}
        }
        finally
        {
          AppMethodBeat.o(331186);
          return;
        }
      }
    }
    
    public final void nJ(long paramLong)
    {
      AppMethodBeat.i(331178);
      label106:
      for (;;)
      {
        try
        {
          Object localObject3 = ((Iterable)h.eMp()).iterator();
          Object localObject1;
          int i;
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (((i)localObject1).field_localId == paramLong)
            {
              i = 1;
              break label106;
              localObject1 = (i)localObject1;
              if (localObject1 != null)
              {
                localObject3 = h.Fop;
                h.a(((i)localObject1).eYK(), false);
                AppMethodBeat.o(331178);
              }
            }
            else
            {
              i = 0;
              break label106;
            }
          }
          else
          {
            localObject1 = null;
            continue;
          }
          if (i == 0) {}
        }
        finally
        {
          AppMethodBeat.o(331178);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.h
 * JD-Core Version:    0.7.0.1
 */