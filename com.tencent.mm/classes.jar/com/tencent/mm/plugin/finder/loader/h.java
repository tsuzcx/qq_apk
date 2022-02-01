package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c;
import com.tencent.mm.g.e;
import com.tencent.mm.g.g.a;
import com.tencent.mm.loader.c.b.b;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "onCdnDownloadCallback", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;)V", "getOnCdnDownloadCallback", "()Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "attachSnsImgTaskInfo", "", "data", "imageUrl", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.loader.c.b<r>
{
  public static final h.a Exq;
  private final h.a.a Exr;
  
  static
  {
    AppMethodBeat.i(166308);
    Exq = new h.a((byte)0);
    AppMethodBeat.o(166308);
  }
  
  public h(h.a.a parama)
  {
    this.Exr = parama;
  }
  
  private static boolean a(r paramr, String paramString1, String paramString2, e parame, String paramString3)
  {
    AppMethodBeat.i(166306);
    try
    {
      String str = new URL(paramString1).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.d.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.d.a(str, true, (List)localArrayList2);
      parame.field_mediaId = paramr.aUt();
      parame.url = paramString1;
      parame.snsCipherKey = paramr.eCe();
      parame.host = str;
      parame.referer = paramString3;
      parame.lwD = paramString2;
      parame.lwE = hb((List)localArrayList1);
      parame.lwF = hb((List)localArrayList2);
      parame.lwG = i;
      parame.lwH = j;
      parame.isColdSnsData = false;
      parame.signalQuality = s.X("", Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)));
      parame.snsScene = "";
      parame.hyY = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo decodeKey:%s, imageUrl:%s", new Object[] { paramr.eCe(), paramString1 });
      AppMethodBeat.o(166306);
      return true;
    }
    catch (MalformedURLException paramr)
    {
      Log.printErrStackTrace("Finder.FinderCdnDownloader", (Throwable)paramr, "", new Object[0]);
      Log.w("Finder.FinderCdnDownloader", s.X("attachSnsImgTaskInfo fail:", paramr));
      AppMethodBeat.o(166306);
    }
    return false;
  }
  
  private static String[] hb(List<String> paramList)
  {
    AppMethodBeat.i(166307);
    String[] arrayOfString = new String[paramList.size()];
    int k = arrayOfString.length - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      arrayOfString[i] = ((String)paramList.get(i));
      if (j > k)
      {
        AppMethodBeat.o(166307);
        return arrayOfString;
      }
    }
  }
  
  public final void a(com.tencent.mm.loader.g.a.a<r> parama, com.tencent.mm.loader.e.g paramg, final b.b paramb)
  {
    AppMethodBeat.i(166305);
    s.u(parama, "item");
    s.u(paramg, "fileNameCreator");
    s.u(paramb, "callback");
    paramg = (r)parama.bmg();
    if (paramg.eCd() == v.FKY)
    {
      parama = s.X(paramg.getUrl(), paramg.eCf());
      Log.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.eCd() + ' ' + paramg.eCf() + " uniqueValue=" + paramg.aUt() + ' ' + parama);
    }
    for (;;)
    {
      Object localObject1 = am.aixg;
      localObject1 = "https://" + WeChatHosts.domainString(e.h.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
      int i = com.tencent.mm.protocal.d.Yxh;
      com.tencent.mm.kernel.h.baC();
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i), p.getString(com.tencent.mm.kernel.b.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)), "" }, 5));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      e locale = new e();
      locale.taskName = "task_FinderCdnDownloader";
      Object localObject2 = bm.GlZ;
      s.s(paramg, "data");
      localObject2 = bm.a(paramg);
      y.deleteFile((String)localObject2);
      y.bDX(new u((String)localObject2).jKO());
      if (!a(paramg, parama, (String)localObject2, locale, (String)localObject1)) {
        break label463;
      }
      locale.lwL = ((g.a)new b(paramg, paramb, (String)localObject2));
      if (!k.bHW().b((com.tencent.mm.g.g)locale, -1)) {
        break;
      }
      Log.i("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(166305);
      return;
      parama = s.X(paramg.eCi(), paramg.eCg());
      Log.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.eCd() + ' ' + paramg.eCg() + " uniqueValue=" + paramg.aUt() + ' ' + parama);
    }
    Log.w("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask failed");
    paramb.atR();
    AppMethodBeat.o(166305);
    return;
    label463:
    Log.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo failed");
    paramb.atR();
    AppMethodBeat.o(166305);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/loader/FinderCdnDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(r paramr, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(166302);
      s.u(paramString, "mediaId");
      paramc = new StringBuilder("mediaId ").append(paramString).append(" startRet ").append(paramInt).append(" sceneResult ").append(paramd).append(" onlyCheckExist ").append(paramBoolean).append(" retCode ");
      if (paramd == null) {}
      for (paramString = "";; paramString = Integer.valueOf(paramd.field_retCode))
      {
        Log.i("Finder.FinderCdnDownloader", paramString);
        if (paramd == null) {
          break label169;
        }
        if (this.Exs != null) {
          break;
        }
        AppMethodBeat.o(166302);
        return 0;
      }
      if (paramd.field_retCode != 0) {
        paramb.atR();
      }
      for (;;)
      {
        AppMethodBeat.o(166302);
        return 0;
        paramString = paramb;
        paramc = com.tencent.mm.loader.g.a.aL(this.Exu, "");
        s.s(paramc, "create(tmpFilePath, \"\")");
        paramString.a((f)paramc);
        continue;
        label169:
        if (paramInt != 0) {
          paramb.atR();
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(166303);
      s.u(paramString, "mediaId");
      s.u(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(166303);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(166304);
      s.u(paramString, "mediaId");
      s.u(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(166304);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.h
 * JD-Core Version:    0.7.0.1
 */