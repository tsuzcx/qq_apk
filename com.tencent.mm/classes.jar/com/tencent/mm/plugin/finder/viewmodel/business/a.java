package com.tencent.mm.plugin.finder.viewmodel.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.e;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.finder.live.model.af;
import com.tencent.mm.plugin.finder.live.model.af.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/business/LiveDecorationSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "lastAvatarDecorItem", "Lcom/tencent/mm/protocal/protobuf/LiveElementMedia;", "getLastAvatarDecorItem", "()Lcom/tencent/mm/protocal/protobuf/LiveElementMedia;", "setLastAvatarDecorItem", "(Lcom/tencent/mm/protocal/protobuf/LiveElementMedia;)V", "lastBgDecorItem", "getLastBgDecorItem", "setLastBgDecorItem", "lastBgDecorShowTimestamp", "", "getLastBgDecorShowTimestamp", "()J", "setLastBgDecorShowTimestamp", "(J)V", "attachDecorTaskInfo", "", "url", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "decorResPath", "item", "loadDecorationRes", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "markLastAvatarItem", "decorItem", "markLastBgItem", "markLastBgShowTimestamp", "needUpdate", "decorType", "", "onCleared", "startBgDecorationLooper", "startDecorationCheck", "Lkotlin/Function2;", "avatarItem", "bgItem", "Companion", "FinderLiveDecorationTask", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.live.viewmodel.data.business.c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a GLS;
  private static final int GLW = 0;
  private static final int GLX;
  private static final String TAG;
  public dik GLT;
  public dik GLU;
  public long GLV;
  
  static
  {
    AppMethodBeat.i(337328);
    GLS = new a((byte)0);
    TAG = "Finder.LiveDecorationSlice";
    GLX = 1;
    AppMethodBeat.o(337328);
  }
  
  public a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(337274);
    AppMethodBeat.o(337274);
  }
  
  private static boolean b(String paramString1, String paramString2, e parame)
  {
    AppMethodBeat.i(337286);
    if (paramString1 != null) {}
    try
    {
      String str = new URL(paramString1).getHost();
      int i = com.tencent.mm.network.d.a(str, false, (List)new ArrayList());
      int j = com.tencent.mm.network.d.a(str, true, (List)new ArrayList());
      parame.field_mediaId = MD5Util.getMD5String(paramString1);
      parame.url = paramString1;
      parame.host = str;
      parame.lwD = paramString2;
      parame.lwG = i;
      parame.lwH = j;
      parame.signalQuality = s.X("", Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)));
      parame.snsScene = "";
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i(TAG, "attachDecorTaskInfo url:%s", new Object[] { paramString1 });
      AppMethodBeat.o(337286);
      return true;
    }
    catch (MalformedURLException paramString1)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString1, "", new Object[0]);
      Log.w(TAG, s.X("attachGiftPagTaskInfo fail:", paramString1));
      AppMethodBeat.o(337286);
    }
    return false;
  }
  
  public static String d(dik paramdik)
  {
    Object localObject2 = null;
    AppMethodBeat.i(337305);
    Object localObject1;
    if (paramdik == null)
    {
      localObject1 = null;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label53;
      }
    }
    label53:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label58;
      }
      AppMethodBeat.o(337305);
      return "";
      localObject1 = paramdik.url;
      break;
    }
    label58:
    if (paramdik == null) {}
    for (paramdik = localObject2;; paramdik = paramdik.url)
    {
      paramdik = MD5Util.getMD5String(paramdik);
      localObject1 = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(paramdik, "key");
      paramdik = ((com.tencent.mm.plugin.h)localObject1).b(new o("", paramdik, ""));
      AppMethodBeat.o(337305);
      return paramdik;
    }
  }
  
  public static void o(m<? super dik, ? super dik, ah> paramm)
  {
    AppMethodBeat.i(337293);
    aj localaj = aj.CGT;
    aj.elm().a(8, (com.tencent.mm.bx.a)new bwy(), (af.c)new d(paramm, bwz.class));
    AppMethodBeat.o(337293);
  }
  
  public final void a(dik paramdik, final b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(337342);
    if (paramdik != null)
    {
      String str = paramdik.url;
      if (str != null)
      {
        final b localb = new b(((f)business(f.class)).liveInfo.liveId, paramdik.md5);
        localb.taskName = "task_FinderCdnDownloader";
        paramdik = d(paramdik);
        y.deleteFile(paramdik);
        y.bDX(new u(paramdik).jKO());
        if (b(str, paramdik, (e)localb))
        {
          localb.lwL = ((g.a)new c(this, localb, paramb));
          if (k.bHW().b((com.tencent.mm.g.g)localb, -1))
          {
            Log.i(TAG, "SubCoreCdnTransport addRecvTask suc");
            AppMethodBeat.o(337342);
            return;
          }
          paramb.invoke(Boolean.FALSE);
          Log.w(TAG, "SubCoreCdnTransport addRecvTask failed");
        }
      }
    }
    AppMethodBeat.o(337342);
  }
  
  public final boolean fd(String paramString, int paramInt)
  {
    dik localdik = null;
    Object localObject = null;
    AppMethodBeat.i(337354);
    if (paramInt == GLW)
    {
      localdik = this.GLT;
      if (localdik == null) {}
      while (!Util.isEqual((String)localObject, paramString))
      {
        AppMethodBeat.o(337354);
        return true;
        localObject = localdik.url;
      }
      AppMethodBeat.o(337354);
      return false;
    }
    if (paramInt == GLX)
    {
      localObject = this.GLU;
      if (localObject == null) {}
      for (localObject = localdik; !Util.isEqual((String)localObject, paramString); localObject = ((dik)localObject).url)
      {
        AppMethodBeat.o(337354);
        return true;
      }
      AppMethodBeat.o(337354);
      return false;
    }
    AppMethodBeat.o(337354);
    return false;
  }
  
  public final void onCleared()
  {
    this.GLT = null;
    this.GLU = null;
    this.GLV = 0L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/business/LiveDecorationSlice$Companion;", "", "()V", "DECORATION_TYPE_AVATAR", "", "getDECORATION_TYPE_AVATAR", "()I", "DECORATION_TYPE_BG", "getDECORATION_TYPE_BG", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/business/LiveDecorationSlice$FinderLiveDecorationTask;", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "liveId", "", "md5", "", "(JLjava/lang/String;)V", "getLiveId", "()J", "getMd5", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e
  {
    final long liveId;
    final String md5;
    
    public b(long paramLong, String paramString)
    {
      this.liveId = paramLong;
      this.md5 = paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/business/LiveDecorationSlice$loadDecorationRes$1$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g.a
  {
    c(a parama, a.b paramb, b<? super Boolean, ah> paramb1) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(337291);
      s.u(paramString, "mediaId");
      paramc = a.GLS;
      Log.i(a.access$getTAG$cp(), "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
      if (paramd == null)
      {
        paramString = a.GLS;
        Log.i(a.access$getTAG$cp(), "skip fetch pag callback, sceneResult == null");
        AppMethodBeat.o(337291);
        return 0;
      }
      if (paramd.field_retCode != 0)
      {
        paramString = a.GLS;
        Log.w(a.access$getTAG$cp(), s.X("skip fetch pag callback, fetch pag fail:", Integer.valueOf(paramd.field_retCode)));
        AppMethodBeat.o(337291);
        return 0;
      }
      for (;;)
      {
        try
        {
          long l = ((f)this.GLY.business(f.class)).liveInfo.liveId;
          paramString = com.tencent.mm.b.g.a(new u(localb.lwD), (int)y.bEl(localb.lwD));
          paramc = a.GLS;
          Log.i(a.access$getTAG$cp(), "loadDecorationRes finish. localMd5:" + paramString + " taskMd5:" + localb.md5 + " curLiveId:" + l + " taskLiveId:" + localb.liveId);
          if ((l != localb.liveId) || (!Util.isEqual(paramString, localb.md5))) {
            continue;
          }
          paramString = paramb;
          if (paramString != null) {
            paramString.invoke(Boolean.TRUE);
          }
        }
        catch (Exception paramString)
        {
          paramc = a.GLS;
          Log.e(a.access$getTAG$cp(), s.X("loadDecorationRes err:", paramString.getMessage()));
          paramString = paramb;
          if (paramString == null) {
            continue;
          }
          paramString.invoke(Boolean.FALSE);
          continue;
        }
        AppMethodBeat.o(337291);
        return 0;
        paramString = paramb;
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(337301);
      s.u(paramString, "mediaId");
      s.u(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(337301);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(337309);
      s.u(paramString, "mediaId");
      s.u(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(337309);
      return new byte[0];
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/business/LiveDecorationSlice$startDecorationCheck$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;", "Lcom/tencent/mm/protocal/protobuf/FinderSyncDecorationInfoResp;", "onPollingSuccess", "", "result", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends af.c<bwz>
  {
    d(m<? super dik, ? super dik, ah> paramm, Class<bwz> paramClass)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.business.a
 * JD-Core Version:    0.7.0.1
 */