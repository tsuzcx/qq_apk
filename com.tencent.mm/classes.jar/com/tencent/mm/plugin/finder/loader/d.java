package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.vfs.i;
import d.l;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "attachSnsImgTaskInfo", "", "data", "imageUrl", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.loader.d.b<k>
{
  public static final a siy;
  
  static
  {
    AppMethodBeat.i(166308);
    siy = new a((byte)0);
    AppMethodBeat.o(166308);
  }
  
  private static boolean a(k paramk, String paramString1, String paramString2, com.tencent.mm.i.e parame, String paramString3)
  {
    AppMethodBeat.i(166306);
    try
    {
      String str = new URL(paramString1).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.b.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.b.a(str, true, (List)localArrayList2);
      parame.field_mediaId = ai.ee(paramString1);
      parame.url = paramString1;
      parame.snsCipherKey = paramk.cCy();
      parame.host = str;
      parame.referer = paramString3;
      parame.fIZ = paramString2;
      parame.fJa = dF((List)localArrayList1);
      parame.fJb = dF((List)localArrayList2);
      parame.fJc = i;
      parame.fJd = j;
      parame.isColdSnsData = false;
      parame.signalQuality = ay.getStrength(aj.getContext());
      parame.snsScene = "";
      parame.ePC = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo decodeKey:%s, imageUrl:%s", new Object[] { paramk.cCy(), paramString1 });
      AppMethodBeat.o(166306);
      return true;
    }
    catch (MalformedURLException paramk)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("Finder.FinderCdnDownloader", (Throwable)paramk, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ad.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramk)));
      AppMethodBeat.o(166306);
    }
    return false;
  }
  
  private static String[] dF(List<String> paramList)
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
  
  public final void a(com.tencent.mm.loader.h.a.a<k> parama, com.tencent.mm.loader.f.g paramg, final b.b paramb)
  {
    AppMethodBeat.i(166305);
    d.g.b.p.h(parama, "item");
    d.g.b.p.h(paramg, "fileNameCreator");
    d.g.b.p.h(paramb, "callback");
    paramg = (k)parama.value();
    if (paramg.cCx() == com.tencent.mm.plugin.finder.storage.r.syD)
    {
      parama = paramg.getUrl() + paramg.cCz();
      com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.cCx() + ' ' + paramg.cCz() + " uniqueValue=" + paramg.aeA() + ' ' + parama);
    }
    for (;;)
    {
      Object localObject1 = d.g.b.ad.MLZ;
      int i = com.tencent.mm.protocal.d.Fnj;
      d.g.b.p.g(com.tencent.mm.kernel.g.ajA(), "MMKernel.account()");
      localObject1 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(ay.getNetTypeForStat(aj.getContext())), Integer.valueOf(ay.getStrength(aj.getContext())), "" }, 5));
      d.g.b.p.g(localObject1, "java.lang.String.format(format, *args)");
      com.tencent.mm.i.e locale = new com.tencent.mm.i.e();
      locale.fJi = "task_FinderCdnDownloader";
      Object localObject2 = com.tencent.mm.plugin.finder.utils.r.sNc;
      d.g.b.p.g(paramg, "data");
      localObject2 = com.tencent.mm.plugin.finder.utils.r.a(paramg);
      i.deleteFile((String)localObject2);
      i.aYg(new com.tencent.mm.vfs.e((String)localObject2).getParent());
      if (!a(paramg, parama, (String)localObject2, locale, (String)localObject1)) {
        break label461;
      }
      locale.fJj = ((g.a)new b(paramg, paramb, (String)localObject2));
      if (!com.tencent.mm.ao.f.aGI().e((com.tencent.mm.i.g)locale)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(166305);
      return;
      parama = paramg.akW() + paramg.cCA();
      com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.cCx() + ' ' + paramg.cCA() + " uniqueValue=" + paramg.aeA() + ' ' + parama);
    }
    com.tencent.mm.sdk.platformtools.ad.w("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(166305);
    return;
    label461:
    com.tencent.mm.sdk.platformtools.ad.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(166305);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/loader/FinderCdnDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    b(k paramk, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(166302);
      d.g.b.p.h(paramString, "mediaId");
      com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderCdnDownloader", "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
      if (paramd != null)
      {
        if (this.siz == null)
        {
          AppMethodBeat.o(166302);
          return 0;
        }
        paramString = paramb;
        paramc = com.tencent.mm.loader.h.a.aw(this.siB, "");
        d.g.b.p.g(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
        paramString.a((com.tencent.mm.loader.h.f)paramc);
      }
      AppMethodBeat.o(166302);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(166303);
      d.g.b.p.h(paramString, "mediaId");
      d.g.b.p.h(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(166303);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(166304);
      d.g.b.p.h(paramString, "mediaId");
      d.g.b.p.h(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(166304);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.d
 * JD-Core Version:    0.7.0.1
 */