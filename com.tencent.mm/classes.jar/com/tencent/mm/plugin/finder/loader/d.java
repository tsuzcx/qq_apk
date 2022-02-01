package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.vfs.o;
import d.g.b.ad;
import d.l;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "attachSnsImgTaskInfo", "", "data", "imageUrl", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.loader.d.b<k>
{
  public static final a srt;
  
  static
  {
    AppMethodBeat.i(166308);
    srt = new a((byte)0);
    AppMethodBeat.o(166308);
  }
  
  private static boolean a(k paramk, String paramString1, String paramString2, e parame, String paramString3)
  {
    AppMethodBeat.i(166306);
    try
    {
      String str = new URL(paramString1).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.b.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.b.a(str, true, (List)localArrayList2);
      parame.field_mediaId = aj.ej(paramString1);
      parame.url = paramString1;
      parame.snsCipherKey = paramk.cEk();
      parame.host = str;
      parame.referer = paramString3;
      parame.fLd = paramString2;
      parame.fLe = dI((List)localArrayList1);
      parame.fLf = dI((List)localArrayList2);
      parame.fLg = i;
      parame.fLh = j;
      parame.isColdSnsData = false;
      parame.signalQuality = az.getStrength(ak.getContext());
      parame.snsScene = "";
      parame.eRn = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      ae.i("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo decodeKey:%s, imageUrl:%s", new Object[] { paramk.cEk(), paramString1 });
      AppMethodBeat.o(166306);
      return true;
    }
    catch (MalformedURLException paramk)
    {
      ae.printErrStackTrace("Finder.FinderCdnDownloader", (Throwable)paramk, "", new Object[0]);
      ae.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramk)));
      AppMethodBeat.o(166306);
    }
    return false;
  }
  
  private static String[] dI(List<String> paramList)
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
    if (paramg.cEj() == com.tencent.mm.plugin.finder.storage.r.sJu)
    {
      parama = paramg.getUrl() + paramg.cEl();
      ae.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.cEj() + ' ' + paramg.cEl() + " uniqueValue=" + paramg.aeM() + ' ' + parama);
    }
    for (;;)
    {
      Object localObject1 = ad.Njc;
      int i = com.tencent.mm.protocal.d.FFH;
      d.g.b.p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
      localObject1 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(az.getNetTypeForStat(ak.getContext())), Integer.valueOf(az.getStrength(ak.getContext())), "" }, 5));
      d.g.b.p.g(localObject1, "java.lang.String.format(format, *args)");
      e locale = new e();
      locale.fLl = "task_FinderCdnDownloader";
      Object localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
      d.g.b.p.g(paramg, "data");
      localObject2 = com.tencent.mm.plugin.finder.utils.r.a(paramg);
      o.deleteFile((String)localObject2);
      o.aZI(new com.tencent.mm.vfs.k((String)localObject2).getParent());
      if (!a(paramg, parama, (String)localObject2, locale, (String)localObject1)) {
        break label461;
      }
      locale.fLm = ((g.a)new b(paramg, paramb, (String)localObject2));
      if (!com.tencent.mm.an.f.aGZ().e((com.tencent.mm.i.g)locale)) {
        break;
      }
      ae.i("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(166305);
      return;
      parama = paramg.all() + paramg.cEm();
      ae.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramg.cEj() + ' ' + paramg.cEm() + " uniqueValue=" + paramg.aeM() + ' ' + parama);
    }
    ae.w("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(166305);
    return;
    label461:
    ae.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(166305);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/loader/FinderCdnDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    b(k paramk, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(166302);
      d.g.b.p.h(paramString, "mediaId");
      ae.i("Finder.FinderCdnDownloader", "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
      if (paramd != null)
      {
        if (this.sru == null)
        {
          AppMethodBeat.o(166302);
          return 0;
        }
        paramString = paramb;
        paramc = com.tencent.mm.loader.h.a.ax(this.srw, "");
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