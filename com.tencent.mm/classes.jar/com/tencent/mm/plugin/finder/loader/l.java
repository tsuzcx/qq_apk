package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.af;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "onCdnDownloadCallback", "Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;)V", "getOnCdnDownloadCallback", "()Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion$OnCdnDownloadCallback;", "attachSnsImgTaskInfo", "", "data", "imageUrl", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-finder_release"})
public final class l
  extends com.tencent.mm.loader.d.b<w>
{
  public static final a ztz;
  private final l.a.a zty;
  
  static
  {
    AppMethodBeat.i(166308);
    ztz = new a((byte)0);
    AppMethodBeat.o(166308);
  }
  
  public l(l.a.a parama)
  {
    this.zty = parama;
  }
  
  private static boolean a(w paramw, String paramString1, String paramString2, e parame, String paramString3)
  {
    AppMethodBeat.i(166306);
    try
    {
      String str = new URL(paramString1).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.d.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.d.a(str, true, (List)localArrayList2);
      parame.field_mediaId = paramw.aBv();
      parame.url = paramString1;
      parame.snsCipherKey = paramw.dIY();
      parame.host = str;
      parame.referer = paramString3;
      parame.iUy = paramString2;
      parame.iUz = ey((List)localArrayList1);
      parame.iUA = ey((List)localArrayList2);
      parame.iUB = i;
      parame.iUC = j;
      parame.isColdSnsData = false;
      parame.signalQuality = ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null);
      parame.snsScene = "";
      parame.hDp = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo decodeKey:%s, imageUrl:%s", new Object[] { paramw.dIY(), paramString1 });
      AppMethodBeat.o(166306);
      return true;
    }
    catch (MalformedURLException paramw)
    {
      Log.printErrStackTrace("Finder.FinderCdnDownloader", (Throwable)paramw, "", new Object[0]);
      Log.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramw)));
      AppMethodBeat.o(166306);
    }
    return false;
  }
  
  private static String[] ey(List<String> paramList)
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
  
  public final void a(com.tencent.mm.loader.h.a.a<w> parama, com.tencent.mm.loader.f.g paramg, final b.b paramb)
  {
    AppMethodBeat.i(166305);
    kotlin.g.b.p.k(parama, "item");
    kotlin.g.b.p.k(paramg, "fileNameCreator");
    kotlin.g.b.p.k(paramb, "callback");
    paramg = (w)parama.aSr();
    if (paramg.dIX() == com.tencent.mm.plugin.finder.storage.u.Aly)
    {
      parama = paramg.getUrl() + paramg.dIZ();
      Log.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.dIX() + ' ' + paramg.dIZ() + " uniqueValue=" + paramg.aBv() + ' ' + parama);
    }
    for (;;)
    {
      Object localObject1 = af.aaBG;
      localObject1 = "https://" + WeChatHosts.domainString(b.j.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
      int i = com.tencent.mm.protocal.d.RAD;
      kotlin.g.b.p.j(h.aHE(), "MMKernel.account()");
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.b.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)), "" }, 5));
      kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
      e locale = new e();
      locale.taskName = "task_FinderCdnDownloader";
      Object localObject2 = av.AJz;
      kotlin.g.b.p.j(paramg, "data");
      localObject2 = av.a(paramg);
      com.tencent.mm.vfs.u.deleteFile((String)localObject2);
      com.tencent.mm.vfs.u.bBD(new q((String)localObject2).ifA());
      if (!a(paramg, parama, (String)localObject2, locale, (String)localObject1)) {
        break label493;
      }
      locale.iUG = ((g.a)new b(paramg, paramb, (String)localObject2));
      if (!com.tencent.mm.aq.f.bkg().e((com.tencent.mm.i.g)locale)) {
        break;
      }
      Log.i("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(166305);
      return;
      parama = paramg.aJi() + paramg.dJa();
      Log.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.dIX() + ' ' + paramg.dJa() + " uniqueValue=" + paramg.aBv() + ' ' + parama);
    }
    Log.w("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(166305);
    return;
    label493:
    Log.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(166305);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion;", "", "()V", "TAG", "", "OnCdnDownloadCallback", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/loader/FinderCdnDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    b(w paramw, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(166302);
      kotlin.g.b.p.k(paramString, "mediaId");
      paramc = new StringBuilder("mediaId ").append(paramString).append(" startRet ").append(paramInt).append(" sceneResult ").append(paramd).append(" onlyCheckExist ").append(paramBoolean).append(" retCode ");
      if (paramd != null) {}
      for (paramString = Integer.valueOf(paramd.field_retCode);; paramString = "")
      {
        Log.i("Finder.FinderCdnDownloader", paramString);
        if (paramd == null) {
          break label169;
        }
        if (this.ztA != null) {
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
        paramc = com.tencent.mm.loader.h.a.aC(this.ztC, "");
        kotlin.g.b.p.j(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
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
      kotlin.g.b.p.k(paramString, "mediaId");
      kotlin.g.b.p.k(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(166303);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(166304);
      kotlin.g.b.p.k(paramString, "mediaId");
      kotlin.g.b.p.k(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(166304);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.l
 * JD-Core Version:    0.7.0.1
 */