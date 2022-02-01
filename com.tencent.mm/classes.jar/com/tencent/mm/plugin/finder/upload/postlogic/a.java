package com.tencent.mm.plugin.finder.upload.postlogic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.gallery.b.g;
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
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.epm;
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
import java.util.ArrayList<Lcom.tencent.mm.protocal.protobuf.djg;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderPostDataLogic;", "", "()V", "TAG", "", "clearObjectDescWhenLocalContentNull", "", "objectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "fillActivityEventInfo", "draftEventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "fillAdFlag", "jumpInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "fakeSvrObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "fillAttachmentList", "fillFinderObject", "isNewsFeed", "", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "originalFlag", "", "isFromCamera", "sendObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "fillGeneralReportInfo", "reportInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGeneralReportInfo;", "fillLongVideoAttachment", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "fillLongVideoMediaExtList", "fillObjectDesc", "data", "Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "postExtra", "Lcom/tencent/mm/protocal/protobuf/FinderPostExtra;", "description", "mediaType", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "videoTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "fillObjectDescExceptMedia", "fillPostInfo", "fillReportInfo", "videoPathBeforeCut", "fromDraft", "generateFinderItemToPost", "forPreview", "resizeOfShort", "Lkotlin/Pair;", "originWidth", "originHeight", "max", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a GdF;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(343130);
    GdF = new a();
    TAG = "Finder.FinderPostDataLogic";
    AppMethodBeat.o(343130);
  }
  
  public static FinderItem a(com.tencent.mm.plugin.finder.upload.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(342995);
    s.u(paramp, "data");
    int i = paramp.mediaType;
    Object localObject1 = paramp.description;
    Object localObject3 = paramp.Gcp;
    Object localObject2 = paramp.location;
    axa localaxa = paramp.Gcq;
    int j = paramp.originalFlag;
    boolean bool1 = paramp.Gcr;
    String str = paramp.Gcs;
    ArrayList localArrayList = paramp.Gct;
    boolean bool2 = paramp.isLongVideo;
    boolean bool3 = paramp.Gcu;
    brg localbrg = paramp.Gcw;
    awt localawt = paramp.GcB;
    LinkedList localLinkedList = paramp.Gcy;
    byy localbyy = paramp.Gcz;
    ayb localayb = paramp.GcA;
    FinderItem localFinderItem = paramp.Gcx;
    if (localFinderItem != null)
    {
      localObject4 = localFinderItem.field_finderObject;
      s.s(localObject4, "draftFinderItem.field_finderObject");
      a((FinderObject)localObject4, bool3, localArrayList, j, bool1, localFinderItem, localLinkedList);
      if (localFinderItem.field_finderObject.objectDesc == null) {
        localFinderItem.field_finderObject.objectDesc = new FinderObjectDesc();
      }
      if (localObject3 != null)
      {
        localObject4 = localFinderItem.field_finderObject.objectDesc;
        s.checkNotNull(localObject4);
        s.s(localObject4, "draftFinderItem.field_finderObject.objectDesc!!");
        localObject5 = localFinderItem.field_postExtraData;
        s.s(localObject5, "draftFinderItem.field_postExtraData");
        a((FinderObjectDesc)localObject4, (djh)localObject3, paramp, localbrg, (bso)localObject5, (String)localObject1, i, (boi)localObject2, localaxa, localArrayList, localbyy);
        if (bool2)
        {
          localObject1 = localFinderItem.field_finderObject.objectDesc;
          s.checkNotNull(localObject1);
          s.s(localObject1, "draftFinderItem.field_finderObject.objectDesc!!");
          localObject2 = localFinderItem.field_finderObject;
          s.s(localObject2, "draftFinderItem.field_finderObject");
          a((FinderObjectDesc)localObject1, (FinderObject)localObject2, (djh)localObject3);
        }
        localObject2 = ((djh)localObject3).mediaList;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new LinkedList();
        }
        localFinderItem.setMediaExtList((LinkedList)localObject1);
        localObject1 = localFinderItem.field_finderObject;
        s.s(localObject1, "draftFinderItem.field_finderObject");
        a(localFinderItem, (FinderObject)localObject1, (djh)localObject3);
      }
      for (;;)
      {
        a(localFinderItem.field_finderObject.objectDesc, localayb);
        a(localFinderItem.field_finderObject.objectDesc, localawt);
        localObject1 = localFinderItem.field_finderObject;
        s.s(localObject1, "draftFinderItem.field_finderObject");
        a((FinderObject)localObject1, localLinkedList);
        a(localFinderItem, localArrayList, paramp);
        if (!paramBoolean) {
          a(localFinderItem, i, str, paramp, localFinderItem.field_finderObject.objectDesc, localaxa, 1);
        }
        localFinderItem.setPostWaiting();
        paramp = localFinderItem.field_finderObject;
        s.s(paramp, "draftFinderItem.field_finderObject");
        localFinderItem.setFeedObject(paramp);
        AppMethodBeat.o(342995);
        return localFinderItem;
        localObject3 = localFinderItem.field_finderObject.objectDesc;
        s.checkNotNull(localObject3);
        s.s(localObject3, "draftFinderItem.field_finderObject.objectDesc!!");
        a((FinderObjectDesc)localObject3, localbrg, (String)localObject1, i, (boi)localObject2, localaxa, localArrayList, localbyy);
      }
    }
    localFinderItem = new FinderItem();
    Object localObject4 = new FinderObject();
    Object localObject5 = new FinderObjectDesc();
    ((FinderObject)localObject4).objectDesc = ((FinderObjectDesc)localObject5);
    a((FinderObject)localObject4, bool3, localArrayList, j, bool1, localFinderItem, localLinkedList);
    bso localbso = localFinderItem.field_postExtraData;
    s.s(localbso, "sendObject.field_postExtraData");
    a((FinderObjectDesc)localObject5, (djh)localObject3, paramp, localbrg, localbso, (String)localObject1, i, (boi)localObject2, localaxa, localArrayList, localbyy);
    if (bool2) {
      a((FinderObjectDesc)localObject5, (FinderObject)localObject4, (djh)localObject3);
    }
    a(localFinderItem, i, str, paramp, (FinderObjectDesc)localObject5, localaxa, 0);
    localFinderItem.updateFinderObject((FinderObject)localObject4);
    a((FinderObjectDesc)localObject5, localayb);
    a((FinderObjectDesc)localObject5, localawt);
    a((FinderObject)localObject4, localLinkedList);
    a(localFinderItem, localArrayList, paramp);
    if (localObject3 == null) {}
    for (paramp = null;; paramp = ((djh)localObject3).mediaList)
    {
      localObject1 = paramp;
      if (paramp == null) {
        localObject1 = new LinkedList();
      }
      localFinderItem.setMediaExtList((LinkedList)localObject1);
      a(localFinderItem, (FinderObject)localObject4, (djh)localObject3);
      localFinderItem.setPostWaiting();
      Log.i(TAG, s.X("finder send post ", com.tencent.mm.ae.f.dg(localObject4)));
      AppMethodBeat.o(342995);
      return localFinderItem;
    }
  }
  
  private static void a(FinderItem paramFinderItem, int paramInt1, String paramString, com.tencent.mm.plugin.finder.upload.p paramp, FinderObjectDesc paramFinderObjectDesc, axa paramaxa, int paramInt2)
  {
    AppMethodBeat.i(343110);
    if (paramFinderItem.field_reportObject == null)
    {
      localObject = v.FrN;
      paramFinderItem.field_reportObject = v.eMS();
      localObject = paramFinderItem.field_reportObject;
      if (localObject != null)
      {
        ((FinderFeedReportObject)localObject).postStage = 1;
        ((FinderFeedReportObject)localObject).sdkShareType = paramp.sdkShareType;
      }
    }
    Object localObject = paramFinderItem.field_reportObject;
    label145:
    label162:
    float f;
    if (localObject != null)
    {
      ((FinderFeedReportObject)localObject).sendOrExitButtonTime = cn.bDw();
      ((FinderFeedReportObject)localObject).videoPostType = paramInt1;
      ((FinderFeedReportObject)localObject).beforeCutMediaPath = paramString;
      ((FinderFeedReportObject)localObject).postTaskCost = 0;
      ((FinderFeedReportObject)localObject).uploadCost = 0;
      ((FinderFeedReportObject)localObject).mediaProcessCost = 0;
      ((FinderFeedReportObject)localObject).fromDraft = paramInt2;
      paramString = v.FrN;
      paramString = v.eMS();
      if (paramString == null)
      {
        paramString = "";
        ((FinderFeedReportObject)localObject).flowId = paramString;
      }
    }
    else
    {
      paramString = paramFinderItem.field_reportObject;
      if (paramString != null)
      {
        if (paramFinderObjectDesc != null) {
          break label241;
        }
        paramInt1 = 0;
        paramString.descCount = paramInt1;
        if (paramFinderItem.field_reportObject.descCount <= 0) {
          break label264;
        }
        paramInt1 = 1;
        paramString.existDesc = paramInt1;
        if (paramFinderObjectDesc != null) {
          break label269;
        }
        f = 0.0F;
        label175:
        if (f <= 0.0F) {
          break label319;
        }
        if (paramFinderObjectDesc != null) {
          break label294;
        }
        f = 0.0F;
        label190:
        if (f <= 0.0F) {
          break label319;
        }
      }
    }
    label264:
    label269:
    label294:
    label319:
    for (paramString.existLocation = 1;; paramString.existLocation = 0)
    {
      if (paramaxa != null) {
        paramString.link = paramaxa.link;
      }
      AppMethodBeat.o(343110);
      return;
      paramp = paramString.flowId;
      paramString = paramp;
      if (paramp != null) {
        break;
      }
      paramString = "";
      break;
      label241:
      paramp = paramFinderObjectDesc.description;
      if (paramp == null)
      {
        paramInt1 = 0;
        break label145;
      }
      paramInt1 = paramp.length();
      break label145;
      paramInt1 = 0;
      break label162;
      paramFinderItem = paramFinderObjectDesc.location;
      if (paramFinderItem == null)
      {
        f = 0.0F;
        break label175;
      }
      f = paramFinderItem.latitude;
      break label175;
      paramFinderItem = paramFinderObjectDesc.location;
      if (paramFinderItem == null)
      {
        f = 0.0F;
        break label190;
      }
      f = paramFinderItem.longitude;
      break label190;
    }
  }
  
  private static void a(FinderItem paramFinderItem, FinderObject paramFinderObject, djh paramdjh)
  {
    AppMethodBeat.i(343044);
    int i;
    Object localObject1;
    label79:
    Object localObject2;
    label132:
    label152:
    Object localObject3;
    int j;
    label220:
    float f;
    label261:
    label423:
    Object localObject4;
    int m;
    if ((paramdjh != null) && (paramdjh.aaPb == true))
    {
      i = 1;
      if (i == 0) {
        break label672;
      }
      paramFinderObject = new LinkedList();
      paramFinderObject.addAll((Collection)paramdjh.mediaList);
      localObject1 = kotlin.ah.aiuX;
      paramFinderItem.setLongVideoMediaExtList(paramFinderObject);
      Log.i(TAG, "remote url for long video");
      localObject1 = ((Iterable)paramFinderItem.getLongVideoMediaExtList()).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label1287;
      }
      localObject2 = (dji)((Iterator)localObject1).next();
      ((dji)localObject2).mediaId = s.X("longvideo_", ((dji)localObject2).mediaId);
      if ((paramdjh == null) || (paramdjh.aaPb != true)) {
        break label861;
      }
      i = 1;
      if (i == 0) {
        break label867;
      }
      ((dji)localObject2).aaPf = false;
      Log.i(TAG, "remote url not need crop");
      localObject3 = new dju();
      paramFinderItem = com.tencent.mm.plugin.finder.ui.config.a.FWH;
      VideoTransPara localVideoTransPara = com.tencent.mm.plugin.finder.ui.config.a.fcM();
      j = (int)((dji)localObject2).width;
      i = (int)((dji)localObject2).height;
      switch (SightVideoJNI.getMp4RotateVFS(((dji)localObject2).url))
      {
      default: 
        k = MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels;
        f = j / i;
        if (f <= 1.777778F) {
          if (0.5625F <= f)
          {
            k = 1;
            if (k == 0) {
              break label907;
            }
            paramFinderItem = new fyb();
            paramFinderItem.left = 0;
            paramFinderItem.top = i;
            paramFinderItem.right = j;
            paramFinderItem.bottom = 0;
            paramFinderObject = kotlin.ah.aiuX;
            ((dju)localObject3).aaPJ = paramFinderItem;
            ((dju)localObject3).aaPL = paramFinderItem;
            paramFinderObject = kotlin.a.p.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
            paramFinderItem = new byz();
            paramFinderItem.aaib.addAll((Collection)kotlin.a.p.p((Iterable)paramFinderObject));
            paramFinderObject = kotlin.ah.aiuX;
            ((dju)localObject3).aaPK = paramFinderItem;
            ((dju)localObject3).startTime = 0;
            localObject4 = MultiMediaVideoChecker.ObB;
            paramFinderObject = ((dji)localObject2).url;
            paramFinderItem = paramFinderObject;
            if (paramFinderObject == null) {
              paramFinderItem = "";
            }
            paramFinderItem = ((MultiMediaVideoChecker)localObject4).aTG(paramFinderItem);
            if (paramFinderItem != null)
            {
              ((dju)localObject3).endTime = Math.min(localVideoTransPara.duration * 1000, (int)paramFinderItem.duration);
              paramFinderItem = kotlin.ah.aiuX;
              paramFinderItem = kotlin.ah.aiuX;
            }
            m = Math.min(localVideoTransPara.width, localVideoTransPara.height);
            if (j >= i) {
              break label1203;
            }
            if (j % 16 == 0) {
              break label1315;
            }
          }
        }
        break;
      }
    }
    label672:
    label1315:
    for (int k = j - j % 16;; k = j)
    {
      if (j > m) {
        i = (int)(i * (m / j));
      }
      for (;;)
      {
        j = i;
        if (i % 16 != 0) {
          j = i - i % 16;
        }
        paramFinderItem = new r(Integer.valueOf(m), Integer.valueOf(j));
        i = ((Number)paramFinderItem.bsC).intValue();
        j = ((Number)paramFinderItem.bsD).intValue();
        ((dju)localObject3).width = i;
        ((dju)localObject3).height = j;
        ((dji)localObject2).width = i;
        ((dji)localObject2).height = j;
        ((dju)localObject3).retryCount = 0;
        paramFinderItem = kotlin.ah.aiuX;
        ((dji)localObject2).EDC = ((dju)localObject3);
        break label79;
        i = 0;
        break;
        paramFinderObject = paramFinderObject.attachmentList;
        if (paramFinderObject == null) {
          paramFinderObject = null;
        }
        for (;;)
        {
          localObject1 = paramFinderObject;
          if (paramFinderObject == null) {
            localObject1 = new LinkedList();
          }
          paramFinderItem.setLongVideoMediaExtList((LinkedList)localObject1);
          break;
          paramFinderObject = paramFinderObject.ZEi;
          if (paramFinderObject == null)
          {
            paramFinderObject = null;
          }
          else
          {
            localObject1 = ((Iterable)paramFinderObject).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              paramFinderObject = ((Iterator)localObject1).next();
              localObject2 = (atq)paramFinderObject;
              localObject3 = av.GiL;
              s.s(localObject2, "it");
            } while (!av.a((atq)localObject2));
            for (;;)
            {
              paramFinderObject = (atq)paramFinderObject;
              if (paramFinderObject != null) {
                break label797;
              }
              paramFinderObject = null;
              break;
              paramFinderObject = null;
            }
            paramFinderObject = paramFinderObject.ZEf;
            if (paramFinderObject == null)
            {
              paramFinderObject = null;
            }
            else
            {
              paramFinderObject = paramFinderObject.ZXx;
              if (paramFinderObject == null)
              {
                paramFinderObject = null;
              }
              else
              {
                paramFinderObject = paramFinderObject.aaUt;
                if (paramFinderObject == null)
                {
                  paramFinderObject = null;
                }
                else
                {
                  paramFinderObject = paramFinderObject.media;
                  if (paramFinderObject == null) {
                    paramFinderObject = null;
                  } else {
                    paramFinderObject = i.aZ(paramFinderObject);
                  }
                }
              }
            }
          }
        }
        label861:
        i = 0;
        break label132;
        label867:
        ((dji)localObject2).aaPf = true;
        break label152;
        j = (int)((dji)localObject2).height;
        i = (int)((dji)localObject2).width;
        break label220;
        k = 0;
        break label261;
        k = 0;
        break label261;
        if (f > 1.777778F)
        {
          k = (int)(i * 16.0F / 9.0F);
          paramFinderObject = new fyb();
          paramFinderObject.left = ((j - k) / 2);
          paramFinderObject.top = i;
          paramFinderObject.right = (j - paramFinderObject.left);
          paramFinderObject.bottom = 0;
          paramFinderItem = kotlin.ah.aiuX;
          ((dju)localObject3).aaPJ = paramFinderObject;
          ((dju)localObject3).aaPL = paramFinderObject;
          paramFinderItem = new Matrix();
          paramFinderItem.postTranslate(-paramFinderObject.left, 0.0F);
          paramFinderObject = new byz();
          localObject4 = new float[9];
          paramFinderItem.getValues((float[])localObject4);
          paramFinderObject.aaib.addAll((Collection)kotlin.a.k.D((float[])localObject4));
          paramFinderItem = kotlin.ah.aiuX;
          ((dju)localObject3).aaPK = paramFinderObject;
          j = k;
          break label423;
        }
        k = (int)(j * 16.0F / 9.0F);
        paramFinderObject = new fyb();
        paramFinderObject.left = 0;
        paramFinderObject.bottom = ((i - k) / 2);
        paramFinderObject.right = j;
        paramFinderObject.top = (i - paramFinderObject.bottom);
        paramFinderItem = kotlin.ah.aiuX;
        ((dju)localObject3).aaPJ = paramFinderObject;
        ((dju)localObject3).aaPL = paramFinderObject;
        paramFinderItem = new Matrix();
        paramFinderItem.postTranslate(0.0F, -paramFinderObject.bottom);
        paramFinderObject = new byz();
        localObject4 = new float[9];
        paramFinderItem.getValues((float[])localObject4);
        paramFinderObject.aaib.addAll((Collection)kotlin.a.k.D((float[])localObject4));
        paramFinderItem = kotlin.ah.aiuX;
        ((dju)localObject3).aaPK = paramFinderObject;
        i = k;
        break label423;
        label1203:
        if (i % 16 != 0) {}
        for (k = i - i % 16;; k = i)
        {
          if (k > m)
          {
            f = j;
            j = (int)(m / i * f);
          }
          for (;;)
          {
            i = j;
            if (j % 16 != 0) {
              i = j - j % 16;
            }
            paramFinderItem = new r(Integer.valueOf(i), Integer.valueOf(m));
            break;
            AppMethodBeat.o(343044);
            return;
            m = k;
          }
        }
        m = k;
      }
    }
  }
  
  private static void a(FinderItem paramFinderItem, ArrayList<djg> paramArrayList, com.tencent.mm.plugin.finder.upload.p paramp)
  {
    AppMethodBeat.i(343023);
    Object localObject2 = paramFinderItem.field_postinfo;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.ah.FMh;
      localObject1 = com.tencent.mm.plugin.finder.storage.ah.eZB();
    }
    ((djj)localObject1).aaPx = cn.bDu();
    if (paramArrayList != null)
    {
      ((djj)localObject1).aaPA.clear();
      ((djj)localObject1).aaPA.addAll((Collection)paramArrayList);
    }
    epm localepm;
    if (!Util.isNullOrNil(paramp.AyS))
    {
      localepm = new epm();
      paramArrayList = paramp.Gcv;
      if (paramArrayList != null) {
        break label140;
      }
      paramArrayList = "";
    }
    for (;;)
    {
      localepm.appid = paramArrayList;
      localepm.AyT = paramp.AyT;
      localepm.AyS = paramp.AyS;
      paramArrayList = kotlin.ah.aiuX;
      ((djj)localObject1).aaPB = localepm;
      paramArrayList = kotlin.ah.aiuX;
      paramFinderItem.setPostInfo((djj)localObject1);
      AppMethodBeat.o(343023);
      return;
      label140:
      localObject2 = paramArrayList.appid;
      paramArrayList = (ArrayList<djg>)localObject2;
      if (localObject2 == null) {
        paramArrayList = "";
      }
    }
  }
  
  public static void a(FinderObject paramFinderObject, LinkedList<FinderJumpInfo> paramLinkedList)
  {
    AppMethodBeat.i(343064);
    s.u(paramFinderObject, "fakeSvrObj");
    s.u(paramLinkedList, "jumpInfoList");
    Object localObject1 = paramFinderObject.attachmentList;
    if (localObject1 != null)
    {
      localObject1 = ((atr)localObject1).ZEi;
      if (localObject1 != null) {
        com.tencent.mm.ae.d.a((LinkedList)localObject1, (kotlin.g.a.b)a.a.GdG);
      }
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (FinderJumpInfo)paramLinkedList.next();
      Object localObject3;
      if (paramFinderObject.attachmentList == null)
      {
        localObject2 = new atr();
        ((atr)localObject2).ZEi = new LinkedList();
        localObject3 = kotlin.ah.aiuX;
        paramFinderObject.attachmentList = ((atr)localObject2);
      }
      Object localObject2 = paramFinderObject.attachmentList;
      if (localObject2 != null)
      {
        localObject2 = ((atr)localObject2).ZEi;
        if (localObject2 != null)
        {
          localObject3 = new atq();
          ((atq)localObject3).type = 3;
          bce localbce = new bce();
          localbce.ZNl = ((FinderJumpInfo)localObject1);
          localObject1 = kotlin.ah.aiuX;
          ((atq)localObject3).ZEh = localbce;
          localObject1 = kotlin.ah.aiuX;
          ((LinkedList)localObject2).add(localObject3);
        }
      }
    }
    AppMethodBeat.o(343064);
  }
  
  private static void a(FinderObject paramFinderObject, boolean paramBoolean1, ArrayList<djg> paramArrayList, int paramInt, boolean paramBoolean2, FinderItem paramFinderItem, LinkedList<FinderJumpInfo> paramLinkedList)
  {
    int j = 1;
    AppMethodBeat.i(343008);
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      paramFinderObject.objectType = i;
      paramFinderObject.id = 0L;
      paramFinderObject.username = z.bAW();
      localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZS, "");
      if (localObject1 != null) {
        break;
      }
      paramFinderObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(343008);
      throw paramFinderObject;
    }
    paramFinderObject.nickname = ((String)localObject1);
    Object localObject1 = av.GiL;
    paramFinderObject.createtime = av.qH(cn.bDu());
    localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    Object localObject3 = d.a.auT(z.bAW());
    if (localObject3 == null) {
      localObject1 = null;
    }
    Object localObject2;
    while (localObject1 == null)
    {
      localObject2 = new FinderContact();
      ((FinderContact)localObject2).username = z.bAW();
      localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZS, "");
      if (localObject1 == null)
      {
        paramFinderObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(343008);
        throw paramFinderObject;
        localObject1 = c.a((m)localObject3);
      }
      else
      {
        ((FinderContact)localObject2).nickname = ((String)localObject1);
        localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZU, "");
        if (localObject1 == null)
        {
          paramFinderObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(343008);
          throw paramFinderObject;
        }
        ((FinderContact)localObject2).headUrl = ((String)localObject1);
        if (localObject3 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          ((FinderContact)localObject2).signature = ((String)localObject1);
          localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adab, "");
          if (localObject1 != null) {
            break;
          }
          paramFinderObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(343008);
          throw paramFinderObject;
          localObject3 = ((m)localObject3).field_signature;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
        }
        ((FinderContact)localObject2).coverImgUrl = ((String)localObject1);
        localObject1 = kotlin.ah.aiuX;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      paramFinderObject.contact = ((FinderContact)localObject1);
      localObject1 = paramFinderObject.contact;
      if (localObject1 != null) {
        ((FinderContact)localObject1).one_time_flag |= 0x1;
      }
      paramFinderObject.mentionedUserContact = new LinkedList();
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((!com.tencent.mm.plugin.finder.storage.d.eRt()) || (paramArrayList == null)) {
        break;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (djg)paramArrayList.next();
        localObject2 = paramFinderObject.mentionedUserContact;
        localObject3 = com.tencent.mm.plugin.finder.utils.h.Gga;
        s.s(localObject1, "atContact");
        ((LinkedList)localObject2).add(com.tencent.mm.plugin.finder.utils.h.b((djg)localObject1));
      }
    }
    paramArrayList = aw.Gjk;
    if (aw.eKm()) {
      paramFinderObject.permissionFlag = 131;
    }
    paramFinderObject.displayidDiscarded = "";
    paramFinderObject.recommendReason = "";
    paramFinderObject.secondaryShowFlag = 1;
    paramFinderObject.originalFlag = paramInt;
    a(paramLinkedList, paramFinderObject);
    paramFinderObject = new bso();
    if (paramBoolean2) {}
    for (paramInt = j;; paramInt = 0)
    {
      paramFinderObject.aaau = paramInt;
      paramArrayList = com.tencent.mm.ui.component.k.aeZF;
      paramArrayList = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      paramFinderObject.longitude = ((Number)paramArrayList.bsC).floatValue();
      paramFinderObject.latitude = ((Number)paramArrayList.bsD).floatValue();
      paramFinderItem.field_postExtraData = paramFinderObject;
      AppMethodBeat.o(343008);
      return;
    }
  }
  
  public static void a(FinderObjectDesc paramFinderObjectDesc)
  {
    AppMethodBeat.i(343098);
    if (paramFinderObjectDesc == null)
    {
      AppMethodBeat.o(343098);
      return;
    }
    paramFinderObjectDesc.imgFeedBgmInfo = null;
    paramFinderObjectDesc.feedBgmInfo = null;
    paramFinderObjectDesc.media.clear();
    paramFinderObjectDesc.mediaType = 0;
    AppMethodBeat.o(343098);
  }
  
  private static void a(FinderObjectDesc paramFinderObjectDesc, FinderObject paramFinderObject, djh paramdjh)
  {
    AppMethodBeat.i(343056);
    Object localObject2 = new dnh();
    ((dnh)localObject2).description = paramFinderObjectDesc.description;
    paramFinderObjectDesc = paramFinderObjectDesc.media;
    if (paramFinderObjectDesc != null)
    {
      localObject3 = ((Iterable)paramFinderObjectDesc).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        FinderMedia localFinderMedia = (FinderMedia)((Iterator)localObject3).next();
        dnv localdnv = new dnv();
        int i;
        if ((paramdjh != null) && (paramdjh.aaPb == true))
        {
          i = 1;
          label89:
          if (i == 0) {
            break label197;
          }
          localdnv.url = localFinderMedia.url;
          localdnv.thumbUrl = localFinderMedia.thumbUrl;
          localdnv.HaI = localFinderMedia.full_cover_url;
          localdnv.coverUrl = localFinderMedia.coverUrl;
          localdnv.aaUX = localFinderMedia.videoDuration;
          localdnv.aaUY = (localFinderMedia.videoDuration * 1000L);
          localdnv.fileSize = localFinderMedia.fileSize;
        }
        for (localdnv.bitrate = localFinderMedia.bitrate;; localdnv.bitrate = localFinderMedia.bitrate)
        {
          ((dnh)localObject2).media.add(localdnv);
          break;
          i = 0;
          break label89;
          label197:
          localdnv.url = localFinderMedia.url;
          paramFinderObjectDesc = com.tencent.mm.plugin.finder.upload.f.GbE;
          localObject1 = localdnv.url;
          paramFinderObjectDesc = (FinderObjectDesc)localObject1;
          if (localObject1 == null) {
            paramFinderObjectDesc = "";
          }
          localdnv.thumbUrl = com.tencent.mm.plugin.finder.upload.f.aBj(paramFinderObjectDesc);
          localdnv.coverUrl = localFinderMedia.coverUrl;
          localdnv.HaI = localFinderMedia.full_cover_url;
          localdnv.mediaType = 0;
          MultiMediaVideoChecker localMultiMediaVideoChecker = MultiMediaVideoChecker.ObB;
          localObject1 = localdnv.url;
          paramFinderObjectDesc = (FinderObjectDesc)localObject1;
          if (localObject1 == null) {
            paramFinderObjectDesc = "";
          }
          paramFinderObjectDesc = localMultiMediaVideoChecker.aTG(paramFinderObjectDesc);
          if (paramFinderObjectDesc != null)
          {
            localdnv.width = paramFinderObjectDesc.width;
            localdnv.height = paramFinderObjectDesc.height;
            localdnv.aaUX = kotlin.h.a.eH((float)paramFinderObjectDesc.duration / 1000.0F);
            localdnv.aaUY = paramFinderObjectDesc.duration;
          }
          localdnv.md5sum = localFinderMedia.md5sum;
          localdnv.fileSize = localFinderMedia.fileSize;
        }
      }
    }
    Object localObject3 = new dne();
    ((dne)localObject3).id = 0L;
    ((dne)localObject3).createTime = paramFinderObject.createtime;
    ((dne)localObject3).aaUt = ((dnh)localObject2);
    paramFinderObjectDesc = new atr();
    paramFinderObjectDesc.ZEi = new LinkedList();
    paramdjh = paramFinderObjectDesc.ZEi;
    Object localObject1 = new atq();
    ((atq)localObject1).type = 1;
    localObject2 = new byx();
    ((byx)localObject2).id = 0L;
    ((byx)localObject2).ZXx = ((dne)localObject3);
    localObject3 = kotlin.ah.aiuX;
    ((atq)localObject1).ZEf = ((byx)localObject2);
    localObject2 = kotlin.ah.aiuX;
    paramdjh.add(localObject1);
    paramdjh = kotlin.ah.aiuX;
    paramFinderObject.attachmentList = paramFinderObjectDesc;
    AppMethodBeat.o(343056);
  }
  
  private static void a(FinderObjectDesc paramFinderObjectDesc, awt paramawt)
  {
    AppMethodBeat.i(343116);
    if (paramFinderObjectDesc == null)
    {
      AppMethodBeat.o(343116);
      return;
    }
    if (paramFinderObjectDesc.client_draft_ext_info == null) {
      paramFinderObjectDesc.client_draft_ext_info = new auq();
    }
    paramFinderObjectDesc = paramFinderObjectDesc.client_draft_ext_info;
    if (paramFinderObjectDesc != null) {
      paramFinderObjectDesc.ZEY = paramawt;
    }
    AppMethodBeat.o(343116);
  }
  
  private static void a(FinderObjectDesc paramFinderObjectDesc, ayb paramayb)
  {
    if (paramFinderObjectDesc != null) {
      paramFinderObjectDesc.generalReportInfo = paramayb;
    }
  }
  
  private static void a(FinderObjectDesc paramFinderObjectDesc, brg parambrg, String paramString, int paramInt, boi paramboi, axa paramaxa, ArrayList<djg> paramArrayList, byy parambyy)
  {
    AppMethodBeat.i(343089);
    paramFinderObjectDesc.event = parambrg;
    paramFinderObjectDesc.video_tmpl_info = parambyy;
    paramFinderObjectDesc.description = paramString;
    paramFinderObjectDesc.mediaType = paramInt;
    parambrg = paramboi;
    if (paramboi == null) {
      parambrg = new boi();
    }
    paramFinderObjectDesc.location = parambrg;
    parambrg = paramaxa;
    if (paramaxa == null) {
      parambrg = new axa();
    }
    paramFinderObjectDesc.extReading = parambrg;
    paramaxa = new HashMap();
    parambrg = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((com.tencent.mm.plugin.finder.storage.d.eRt()) && (paramArrayList != null))
    {
      parambyy = new LinkedList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        djg localdjg = (djg)paramArrayList.next();
        parambrg = new bpj();
        parambrg.username = localdjg.username;
        parambrg.source = localdjg.type;
        parambrg.nickname = localdjg.nickname;
        parambyy.add(parambrg);
        paramboi = localdjg.nickname;
        parambrg = paramboi;
        if (paramboi == null) {
          parambrg = "";
        }
        paramaxa.put(parambrg, localdjg);
      }
      paramFinderObjectDesc.mentionedUser = parambyy;
    }
    parambrg = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eRs())
    {
      parambrg = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRt()) {}
    }
    else
    {
      parambrg = new bxs();
      paramboi = ao.GhZ;
      parambrg.aagD = ao.d(paramString, paramaxa);
      paramString = kotlin.ah.aiuX;
      paramFinderObjectDesc.topic = parambrg;
    }
    AppMethodBeat.o(343089);
  }
  
  private static void a(FinderObjectDesc paramFinderObjectDesc, djh paramdjh, com.tencent.mm.plugin.finder.upload.p paramp, brg parambrg, bso parambso, String paramString, int paramInt, boi paramboi, axa paramaxa, ArrayList<djg> paramArrayList, byy parambyy)
  {
    AppMethodBeat.i(343076);
    Object localObject1;
    Object localObject3;
    label35:
    label49:
    Object localObject2;
    label73:
    int i;
    label94:
    label113:
    label121:
    Object localObject4;
    if (paramdjh == null)
    {
      localObject1 = null;
      paramFinderObjectDesc.imgFeedBgmInfo = ((bqj)localObject1);
      localObject3 = new bqz();
      if (paramdjh != null) {
        break label830;
      }
      localObject1 = null;
      ((bqz)localObject3).musicInfo = ((bqj)localObject1);
      if (paramdjh != null) {
        break label839;
      }
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = ((bqz)localObject3).musicInfo;
        if (localObject1 != null) {
          break label848;
        }
        localObject2 = null;
      }
      ((bqz)localObject3).groupId = ((String)localObject2);
      if ((paramdjh == null) || (paramdjh.GZQ)) {
        break label858;
      }
      i = 1;
      if (i == 0)
      {
        if ((paramdjh == null) || (paramdjh.GZR)) {
          break label864;
        }
        i = 1;
        if (i == 0) {
          break label870;
        }
      }
      i = 1;
      ((bqz)localObject3).ZZa = i;
      localObject2 = TAG;
      localObject4 = new StringBuilder("FinderObjectBGMInfo, groupId:").append(((bqz)localObject3).groupId).append(", mediaMute:");
      if (paramdjh != null) {
        break label876;
      }
      localObject1 = null;
      label166:
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(", musicMute:");
      if (paramdjh != null) {
        break label888;
      }
      localObject1 = null;
      label188:
      Log.d((String)localObject2, localObject1 + ", hasBgm:" + ((bqz)localObject3).ZZa);
      localObject1 = (CharSequence)((bqz)localObject3).groupId;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label900;
      }
      i = 1;
      label245:
      if ((i == 0) && (((bqz)localObject3).musicInfo == null))
      {
        localObject2 = new bqj();
        if (paramdjh != null) {
          break label906;
        }
        localObject1 = null;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label915;
        }
        i = 1;
        if (i == 0) {
          break label930;
        }
        if (paramdjh != null) {
          break label921;
        }
        localObject1 = null;
        localObject1 = q.n((String)localObject1, true);
        ((bqj)localObject2).ZYp = ((String)localObject1);
        localObject1 = kotlin.ah.aiuX;
        ((bqz)localObject3).musicInfo = ((bqj)localObject2);
      }
      label274:
      label299:
      label311:
      label319:
      localObject1 = kotlin.ah.aiuX;
      paramFinderObjectDesc.feedBgmInfo = ((bqz)localObject3);
      if (paramdjh == null) {
        break label1130;
      }
      paramdjh = paramdjh.mediaList;
      if (paramdjh == null) {
        break label1130;
      }
      localObject2 = ((Iterable)paramdjh).iterator();
      i = 0;
    }
    for (;;)
    {
      label376:
      if (!((Iterator)localObject2).hasNext()) {
        break label1130;
      }
      paramdjh = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject3 = (dji)paramdjh;
      localObject4 = new FinderMedia();
      ((FinderMedia)localObject4).url = ((dji)localObject3).url;
      ((FinderMedia)localObject4).mediaType = ((dji)localObject3).mediaType;
      ((FinderMedia)localObject4).thumbUrl = ((dji)localObject3).thumbUrl;
      ((FinderMedia)localObject4).full_thumb_url = ((dji)localObject3).aaPi;
      if ((!((dji)localObject3).aaPf) && (((dji)localObject3).videoDuration <= 0))
      {
        paramdjh = com.tencent.mm.plugin.sight.base.f.aVX(((dji)localObject3).url);
        if (paramdjh != null) {
          ((dji)localObject3).videoDuration = paramdjh.getVideoDuration();
        }
      }
      ((FinderMedia)localObject4).videoDuration = ((dji)localObject3).videoDuration;
      ((FinderMedia)localObject4).width = ((dji)localObject3).width;
      ((FinderMedia)localObject4).height = ((dji)localObject3).height;
      ((FinderMedia)localObject4).md5sum = ((dji)localObject3).md5sum;
      ((FinderMedia)localObject4).coverUrl = ((dji)localObject3).coverUrl;
      ((FinderMedia)localObject4).full_cover_url = ((dji)localObject3).HaI;
      paramFinderObjectDesc.media.add(localObject4);
      if ((i == 0) && (!Util.isNullOrNil(((dji)localObject3).url)) && ((((dji)localObject3).mediaType == 2) || (((dji)localObject3).mediaType == 4)))
      {
        if (((dji)localObject3).mediaType != 2) {
          break label949;
        }
        paramdjh = av.GiL;
        localObject1 = ((dji)localObject3).url;
        paramdjh = (djh)localObject1;
        if (localObject1 == null) {
          paramdjh = "";
        }
      }
      for (paramdjh = av.aBJ(paramdjh);; paramdjh = av.aBK(((dji)localObject3).url))
      {
        if (paramdjh != null)
        {
          parambso.aaat = ((float)((Number)paramdjh.bsC).doubleValue());
          parambso.aaas = ((float)((Number)paramdjh.bsD).doubleValue());
        }
        if (((FinderMedia)localObject4).mediaType != 2) {
          break label965;
        }
        paramdjh = TAG;
        localObject1 = new StringBuilder("print mediaList ").append(i).append(' ').append(((dji)localObject3).url).append(" size:").append(Util.getSizeKB(y.bEl(((dji)localObject3).url))).append(" option ");
        localObject3 = BitmapUtil.getImageOptions(((dji)localObject3).url);
        Log.i(paramdjh, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject3).outWidth).append(" * ").append(((BitmapFactory.Options)localObject3).outHeight).append(']').toString() + '}');
        i = j;
        break label376;
        localObject1 = paramdjh.aaOZ;
        break;
        label830:
        localObject1 = paramdjh.aaOZ;
        break label35;
        label839:
        localObject1 = paramdjh.FSW;
        break label49;
        label848:
        localObject2 = ((bqj)localObject1).HsD;
        break label73;
        label858:
        i = 0;
        break label94;
        label864:
        i = 0;
        break label113;
        label870:
        i = 0;
        break label121;
        label876:
        localObject1 = Boolean.valueOf(paramdjh.GZQ);
        break label166;
        label888:
        localObject1 = Boolean.valueOf(paramdjh.GZR);
        break label188;
        label900:
        i = 0;
        break label245;
        label906:
        localObject1 = paramdjh.aaPa;
        break label274;
        label915:
        i = 0;
        break label299;
        label921:
        localObject1 = paramdjh.FSU;
        break label311;
        label930:
        if (paramdjh == null)
        {
          localObject1 = null;
          break label319;
        }
        localObject1 = paramdjh.aaPa;
        break label319;
        label949:
        paramdjh = av.GiL;
      }
      label965:
      if (((FinderMedia)localObject4).mediaType == 4)
      {
        paramdjh = TAG;
        localObject1 = new StringBuilder("print mediaList ").append(i).append(' ').append(((dji)localObject3).url).append(" size:").append(Util.getSizeKB(y.bEl(((dji)localObject3).url))).append(" option ");
        localObject4 = g.HRf;
        Log.i(paramdjh, g.aBH(((dji)localObject3).url));
        i = j;
      }
      else
      {
        Log.i(TAG, "print mediaList " + i + ' ' + ((dji)localObject3).url + " size:" + Util.getSizeKB(y.bEl(((dji)localObject3).url)));
        i = j;
      }
    }
    label1130:
    paramFinderObjectDesc.fromApp = paramp.Gcv;
    a(paramFinderObjectDesc, parambrg, paramString, paramInt, paramboi, paramaxa, paramArrayList, parambyy);
    AppMethodBeat.o(343076);
  }
  
  public static void a(LinkedList<FinderJumpInfo> paramLinkedList, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(343015);
    s.u(paramLinkedList, "jumpInfoList");
    s.u(paramFinderObject, "fakeSvrObj");
    if (((Collection)paramLinkedList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramFinderObject.adFlag = 0;
      AppMethodBeat.o(343015);
      return;
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      FinderJumpInfo localFinderJumpInfo = (FinderJumpInfo)paramLinkedList.next();
      if (localFinderJumpInfo.source == 0) {
        localFinderJumpInfo.source = 1;
      }
    }
    paramFinderObject.adFlag = 4;
    AppMethodBeat.o(343015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.a
 * JD-Core Version:    0.7.0.1
 */