package com.tencent.mm.plugin.finder.report.postreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.autogen.mmdata.rpt.fj;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/postreport/PostFlowReporter;", "", "()V", "InnerVersion", "", "buildCustomInfoJson", "", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "checkOrInitReportObject", "", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "report", "stage", "Lcom/tencent/mm/plugin/finder/report/postreport/PostReportStage;", "errType", "errCode", "id", "mediaInfoJson", "customInfoJson", "mediaType", "buildMediaInfoJson", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a FuZ;
  private static final int Fva;
  
  static
  {
    AppMethodBeat.i(331056);
    FuZ = new a();
    Fva = 2;
    AppMethodBeat.o(331056);
  }
  
  public static void a(c paramc, FinderItem paramFinderItem, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(331019);
    s.u(paramFinderItem, "finderObj");
    int i;
    Object localObject;
    if (paramc == null)
    {
      i = 0;
      localObject = b.Fvb;
      if (i < b.eOl().Fvx)
      {
        if (paramFinderItem.field_reportObject == null) {
          paramFinderItem.field_reportObject = new FinderFeedReportObject();
        }
        localObject = paramFinderItem.field_reportObject;
        if (localObject != null) {
          break label199;
        }
        localObject = null;
        label69:
        localObject = (CharSequence)localObject;
        if (localObject != null)
        {
          i = j;
          if (((CharSequence)localObject).length() != 0) {}
        }
        else
        {
          i = 1;
        }
        if (i != 0)
        {
          localObject = paramFinderItem.field_reportObject;
          if (localObject != null) {
            ((FinderFeedReportObject)localObject).flowId = (cn.bDv() + '_' + com.tencent.mm.model.z.bAW());
          }
        }
      }
      localObject = paramFinderItem.field_reportObject;
      if (localObject != null) {
        break label209;
      }
      localObject = "";
    }
    for (;;)
    {
      a((String)localObject, paramc, m(paramFinderItem), b(paramFinderItem.field_reportObject), paramFinderItem.getMediaType(), paramInt1, paramInt2);
      AppMethodBeat.o(331019);
      return;
      i = paramc.Fvx;
      break;
      label199:
      localObject = ((FinderFeedReportObject)localObject).flowId;
      break label69;
      label209:
      String str = ((FinderFeedReportObject)localObject).flowId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(331009);
    Object localObject = v.FrN;
    if (v.eMS() == null)
    {
      localObject = v.FrN;
      v.a(new FinderFeedReportObject());
    }
    localObject = v.FrN;
    localObject = v.eMS();
    if (localObject == null)
    {
      localObject = null;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label136;
      }
    }
    label136:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = v.FrN;
        localObject = v.eMS();
        if (localObject != null) {
          ((FinderFeedReportObject)localObject).flowId = (cn.bDv() + '_' + com.tencent.mm.model.z.bAW());
        }
      }
      a(paramString, paramc, "", "", 0, 0, 0);
      AppMethodBeat.o(331009);
      return;
      localObject = ((FinderFeedReportObject)localObject).flowId;
      break;
    }
  }
  
  private static void a(String paramString1, c paramc, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    AppMethodBeat.i(331032);
    s.u(paramString2, "mediaInfoJson");
    s.u(paramString3, "customInfoJson");
    try
    {
      fj localfj = new fj();
      localfj.iHz = Fva;
      Object localObject;
      if (paramc == null)
      {
        localObject = "";
        localfj.pT((String)localObject);
        if (paramc != null) {
          break label188;
        }
        i = 0;
        label60:
        localfj.iHB = i;
        localfj.iHD = 1;
        localObject = paramString1;
        if (paramString1 == null) {
          localObject = "";
        }
        localfj.pS((String)localObject);
        if (paramc != null) {
          break label197;
        }
      }
      label188:
      label197:
      for (int i = j;; i = paramc.Fvy)
      {
        localfj.iHE = i;
        localfj.pU(paramString2);
        localfj.pV(paramString3);
        localfj.iHH = paramInt1;
        localfj.ivK = paramInt2;
        localfj.inj = paramInt3;
        localfj.bMH();
        paramString1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.a((com.tencent.mm.plugin.report.a)localfj);
        return;
        String str = paramc.Fvw;
        localObject = str;
        if (str != null) {
          break;
        }
        localObject = "";
        break;
        i = paramc.Fvx;
        break label60;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(331032);
    }
  }
  
  private static String b(FinderFeedReportObject paramFinderFeedReportObject)
  {
    AppMethodBeat.i(331050);
    if (paramFinderFeedReportObject == null)
    {
      AppMethodBeat.o(331050);
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("megaCgiErrorType", paramFinderFeedReportObject.megaCgiErrorType);
      localJSONObject.put("megaCgiErrorCode", paramFinderFeedReportObject.megaCgiErrorCode);
      localJSONObject.put("dumpCgiErrorType", paramFinderFeedReportObject.dumpCgiErrorType);
      localJSONObject.put("dumpCgiErrorCode", paramFinderFeedReportObject.dumpCgiErrorCode);
      localJSONObject.put("videoSource", paramFinderFeedReportObject.videoSource);
      localJSONObject.put("draft", paramFinderFeedReportObject.draft);
      localJSONObject.put("retryCount", paramFinderFeedReportObject.retryCount);
      localJSONObject.put("postStage", paramFinderFeedReportObject.postStage);
      localJSONObject.put("sdkShareType", paramFinderFeedReportObject.sdkShareType);
      localJSONObject.put("draftType", paramFinderFeedReportObject.draftType);
      localJSONObject.put("fromDraft", paramFinderFeedReportObject.fromDraft);
      paramFinderFeedReportObject = localJSONObject.toString();
      s.s(paramFinderFeedReportObject, "json.toString()");
      paramFinderFeedReportObject = n.bV(paramFinderFeedReportObject, ",", ";");
      return paramFinderFeedReportObject;
    }
    finally
    {
      AppMethodBeat.o(331050);
    }
    return "";
  }
  
  private static String m(FinderItem paramFinderItem)
  {
    MultiMediaVideoChecker localMultiMediaVideoChecker = null;
    AppMethodBeat.i(331044);
    s.u(paramFinderItem, "<this>");
    JSONObject localJSONObject;
    Object localObject2;
    FinderMediaReportObject localFinderMediaReportObject;
    for (;;)
    {
      try
      {
        if (paramFinderItem.getMediaType() != 4)
        {
          AppMethodBeat.o(331044);
          return "";
        }
        localJSONObject = new JSONObject();
        localObject1 = paramFinderItem.field_reportObject;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            localObject2 = (dji)p.oL((List)paramFinderItem.getLongVideoMediaExtList());
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = (dji)p.oL((List)paramFinderItem.getMediaList());
            }
            if (localObject1 != null)
            {
              localObject2 = new FinderMediaReportInfo();
              ((FinderMediaReportInfo)localObject2).fileSize = ((dji)localObject1).fileSize;
              localMultiMediaVideoChecker = MultiMediaVideoChecker.ObB;
              localObject1 = ((dji)localObject1).url;
              paramFinderItem = (FinderItem)localObject1;
              if (localObject1 == null) {
                paramFinderItem = "";
              }
              paramFinderItem = localMultiMediaVideoChecker.aTG(paramFinderItem);
              if (paramFinderItem != null)
              {
                ((FinderMediaReportInfo)localObject2).videoDuration = ((int)paramFinderItem.duration);
                ((FinderMediaReportInfo)localObject2).width = paramFinderItem.width;
                ((FinderMediaReportInfo)localObject2).height = paramFinderItem.height;
                ((FinderMediaReportInfo)localObject2).videoBitrate = paramFinderItem.bitrate;
                ((FinderMediaReportInfo)localObject2).audioBitrate = paramFinderItem.audioBitrate;
                ((FinderMediaReportInfo)localObject2).fps = ((int)paramFinderItem.eGw);
              }
              localJSONObject.put("origin", f.dh(localObject2));
            }
          }
          paramFinderItem = localJSONObject.toString();
          s.s(paramFinderItem, "json.toString()");
          paramFinderItem = n.bV(paramFinderItem, ",", ";");
        }
      }
      finally
      {
        AppMethodBeat.o(331044);
        return "";
      }
      localObject1 = ((FinderFeedReportObject)localObject1).mediaList;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localFinderMediaReportObject = (FinderMediaReportObject)p.oL((List)localObject1);
        if (localFinderMediaReportObject != null) {
          break;
        }
        localObject1 = null;
      }
    }
    Object localObject1 = localFinderMediaReportObject.origin;
    if (localObject1 == null)
    {
      localObject1 = null;
      label291:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new JSONObject();
      }
      localObject1 = localFinderMediaReportObject.target;
      if (localObject1 != null) {
        break label348;
      }
    }
    label348:
    for (localObject1 = localMultiMediaVideoChecker;; localObject1 = f.dh(localObject1))
    {
      localJSONObject.put("origin", localObject2);
      localObject1 = localJSONObject.put("target", localObject1);
      break;
      localObject1 = f.dh(localObject1);
      break label291;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.postreport.a
 * JD-Core Version:    0.7.0.1
 */