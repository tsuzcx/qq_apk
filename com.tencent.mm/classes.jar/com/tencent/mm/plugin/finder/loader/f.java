package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.ae;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "onCdnDownloadCallback", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;)V", "getOnCdnDownloadCallback", "()Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "attachSnsImgTaskInfo", "", "data", "imageUrl", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.loader.d.b<o>
{
  public static final a uIq;
  private final f.a.a uIo;
  
  static
  {
    AppMethodBeat.i(166308);
    uIq = new a((byte)0);
    AppMethodBeat.o(166308);
  }
  
  public f(f.a.a parama)
  {
    this.uIo = parama;
  }
  
  private static boolean a(o paramo, String paramString1, String paramString2, e parame, String paramString3)
  {
    AppMethodBeat.i(166306);
    try
    {
      String str = new URL(paramString1).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.d.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.d.a(str, true, (List)localArrayList2);
      parame.field_mediaId = MD5Util.getMD5String(paramString1);
      parame.url = paramString1;
      parame.snsCipherKey = paramo.djV();
      parame.host = str;
      parame.referer = paramString3;
      parame.gqq = paramString2;
      parame.gqr = ef((List)localArrayList1);
      parame.gqs = ef((List)localArrayList2);
      parame.gqt = i;
      parame.gqu = j;
      parame.isColdSnsData = false;
      parame.signalQuality = NetStatusUtil.getStrength(MMApplicationContext.getContext());
      parame.snsScene = "";
      parame.fuQ = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo decodeKey:%s, imageUrl:%s", new Object[] { paramo.djV(), paramString1 });
      AppMethodBeat.o(166306);
      return true;
    }
    catch (MalformedURLException paramo)
    {
      Log.printErrStackTrace("Finder.FinderCdnDownloader", (Throwable)paramo, "", new Object[0]);
      Log.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramo)));
      AppMethodBeat.o(166306);
    }
    return false;
  }
  
  private static String[] ef(List<String> paramList)
  {
    AppMethodBeat.i(166307);
    String[] arrayOfString = new String[paramList.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(166307);
    return arrayOfString;
  }
  
  public final void a(com.tencent.mm.loader.h.a.a<o> parama, com.tencent.mm.loader.f.g paramg, final b.b paramb)
  {
    AppMethodBeat.i(166305);
    kotlin.g.b.p.h(parama, "item");
    kotlin.g.b.p.h(paramg, "fileNameCreator");
    kotlin.g.b.p.h(paramb, "callback");
    paramg = (o)parama.value();
    if (paramg.djU() == x.vEn)
    {
      parama = paramg.getUrl() + paramg.djW();
      Log.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.djU() + ' ' + paramg.djW() + " uniqueValue=" + paramg.auA() + ' ' + parama);
    }
    for (;;)
    {
      Object localObject1 = ae.SYK;
      localObject1 = "https://" + WeChatHosts.domainString(2131761749) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
      int i = com.tencent.mm.protocal.d.KyO;
      kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())), "" }, 5));
      kotlin.g.b.p.g(localObject1, "java.lang.String.format(format, *args)");
      e locale = new e();
      locale.taskName = "task_FinderCdnDownloader";
      Object localObject2 = al.waC;
      kotlin.g.b.p.g(paramg, "data");
      localObject2 = al.a(paramg);
      s.deleteFile((String)localObject2);
      s.boN(new com.tencent.mm.vfs.o((String)localObject2).getParent());
      if (!a(paramg, parama, (String)localObject2, locale, (String)localObject1)) {
        break label490;
      }
      locale.gqy = ((g.a)new b(paramg, paramb, (String)localObject2));
      if (!com.tencent.mm.an.f.baQ().e((com.tencent.mm.i.g)locale)) {
        break;
      }
      Log.i("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(166305);
      return;
      parama = paramg.aBE() + paramg.djX();
      Log.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.djU() + ' ' + paramg.djX() + " uniqueValue=" + paramg.auA() + ' ' + parama);
    }
    Log.w("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(166305);
    return;
    label490:
    Log.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(166305);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion;", "", "()V", "TAG", "", "OnCdnDownloadCallback", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/loader/FinderCdnDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    b(o paramo, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(166302);
      kotlin.g.b.p.h(paramString, "mediaId");
      paramc = new StringBuilder("mediaId ").append(paramString).append(" startRet ").append(paramInt).append(" sceneResult ").append(paramd).append(" onlyCheckExist ").append(paramBoolean).append(" retCode ");
      if (paramd != null) {}
      for (paramString = Integer.valueOf(paramd.field_retCode);; paramString = "")
      {
        Log.i("Finder.FinderCdnDownloader", paramString);
        if (paramd == null) {
          break label169;
        }
        if (this.uIr != null) {
          break;
        }
        AppMethodBeat.o(166302);
        return 0;
      }
      if (paramd.field_retCode != 0) {
        paramb.onError();
      }
      for (;;)
      {
        AppMethodBeat.o(166302);
        return 0;
        paramString = paramb;
        paramc = com.tencent.mm.loader.h.a.az(this.uIt, "");
        kotlin.g.b.p.g(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
        paramString.a((com.tencent.mm.loader.h.f)paramc);
        continue;
        label169:
        if (paramInt != 0) {
          paramb.onError();
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(166303);
      kotlin.g.b.p.h(paramString, "mediaId");
      kotlin.g.b.p.h(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(166303);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(166304);
      kotlin.g.b.p.h(paramString, "mediaId");
      kotlin.g.b.p.h(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(166304);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.f
 * JD-Core Version:    0.7.0.1
 */