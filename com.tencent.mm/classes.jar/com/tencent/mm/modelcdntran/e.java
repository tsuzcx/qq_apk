package com.tencent.mm.modelcdntran;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelcdntran/CdnTransportEvent;", "", "action", "Lcom/tencent/mm/modelcdntran/CdnTransportEvent$ActionType;", "mediaId", "", "(Lcom/tencent/mm/modelcdntran/CdnTransportEvent$ActionType;Ljava/lang/String;)V", "getAction", "()Lcom/tencent/mm/modelcdntran/CdnTransportEvent$ActionType;", "getMediaId", "()Ljava/lang/String;", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "getProgressInfo", "()Lcom/tencent/mm/cdn/keep_ProgressInfo;", "setProgressInfo", "(Lcom/tencent/mm/cdn/keep_ProgressInfo;)V", "ret", "", "getRet", "()I", "setRet", "(I)V", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "taskInfo", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_TaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_TaskInfo;)V", "ActionType", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final b ozJ;
  final String mediaId;
  public d mxU;
  public final a ozK;
  g ozL;
  public c ozM;
  public int ret;
  
  static
  {
    AppMethodBeat.i(237857);
    ozJ = new b((byte)0);
    AppMethodBeat.o(237857);
  }
  
  public e(a parama, String paramString)
  {
    AppMethodBeat.i(237855);
    this.ozK = parama;
    this.mediaId = paramString;
    AppMethodBeat.o(237855);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelcdntran/CdnTransportEvent$ActionType;", "", "(Ljava/lang/String;I)V", "OnDownloadCallbackError", "OnDownloadCallbackSuccess", "OnDownloadCallbackProgress", "OnUploadCallbackError", "OnUploadCallbackSuccess", "OnUploadCallbackProgress", "OnDownloadInvalidMediaId", "OnDownloadInvalidTaskName", "OnDownloadAlreadyRunning", "OnDownloadStartSuccess", "OnDownloadStartError", "OnDownloadCancel", "OnUploadInvalidMediaId", "OnUploadAlreadyRunning", "OnUploadInvalidTaskName", "OnUploadStartSuccess", "OnUploadStartError", "OnUploadCancel", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(237860);
      ozN = new a("OnDownloadCallbackError", 0);
      ozO = new a("OnDownloadCallbackSuccess", 1);
      ozP = new a("OnDownloadCallbackProgress", 2);
      ozQ = new a("OnUploadCallbackError", 3);
      ozR = new a("OnUploadCallbackSuccess", 4);
      ozS = new a("OnUploadCallbackProgress", 5);
      ozT = new a("OnDownloadInvalidMediaId", 6);
      ozU = new a("OnDownloadInvalidTaskName", 7);
      ozV = new a("OnDownloadAlreadyRunning", 8);
      ozW = new a("OnDownloadStartSuccess", 9);
      ozX = new a("OnDownloadStartError", 10);
      ozY = new a("OnDownloadCancel", 11);
      ozZ = new a("OnUploadInvalidMediaId", 12);
      oAa = new a("OnUploadAlreadyRunning", 13);
      oAb = new a("OnUploadInvalidTaskName", 14);
      oAc = new a("OnUploadStartSuccess", 15);
      oAd = new a("OnUploadStartError", 16);
      oAe = new a("OnUploadCancel", 17);
      oAf = new a[] { ozN, ozO, ozP, ozQ, ozR, ozS, ozT, ozU, ozV, ozW, ozX, ozY, ozZ, oAa, oAb, oAc, oAd, oAe };
      AppMethodBeat.o(237860);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelcdntran/CdnTransportEvent$Companion;", "", "()V", "create", "Lcom/tencent/mm/modelcdntran/CdnTransportEvent;", "action", "Lcom/tencent/mm/modelcdntran/CdnTransportEvent$ActionType;", "taskInfo", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static e a(e.a parama, g paramg)
    {
      AppMethodBeat.i(237840);
      s.u(parama, "action");
      s.u(paramg, "taskInfo");
      String str2 = paramg.field_mediaId;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      parama = new e(parama, str1);
      parama.ozL = paramg;
      AppMethodBeat.o(237840);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.e
 * JD-Core Version:    0.7.0.1
 */