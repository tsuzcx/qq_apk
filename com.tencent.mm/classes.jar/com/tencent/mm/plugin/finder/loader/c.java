package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.vfs.i;
import d.g.b.z;
import d.l;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "attachSnsImgTaskInfo", "", "data", "imageUrl", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.loader.d.b<j>
{
  public static final a qCf;
  
  static
  {
    AppMethodBeat.i(166308);
    qCf = new a((byte)0);
    AppMethodBeat.o(166308);
  }
  
  private static boolean a(j paramj, String paramString1, String paramString2, com.tencent.mm.i.e parame, String paramString3)
  {
    AppMethodBeat.i(166306);
    try
    {
      String str = new URL(paramString1).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.b.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.b.a(str, true, (List)localArrayList2);
      parame.field_mediaId = ai.du(paramString1);
      parame.url = paramString1;
      parame.snsCipherKey = paramj.cmS();
      parame.host = str;
      parame.referer = paramString3;
      parame.fny = paramString2;
      parame.fnz = dy((List)localArrayList1);
      parame.fnA = dy((List)localArrayList2);
      parame.fnB = i;
      parame.fnC = j;
      parame.isColdSnsData = false;
      parame.signalQuality = ay.getStrength(aj.getContext());
      parame.snsScene = "";
      parame.evH = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      ad.i("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo decodeKey:%s, imageUrl:%s", new Object[] { paramj.cmS(), paramString1 });
      AppMethodBeat.o(166306);
      return true;
    }
    catch (MalformedURLException paramj)
    {
      ad.printErrStackTrace("Finder.FinderCdnDownloader", (Throwable)paramj, "", new Object[0]);
      ad.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramj)));
      AppMethodBeat.o(166306);
    }
    return false;
  }
  
  private static String[] dy(List<String> paramList)
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
  
  public final void a(com.tencent.mm.loader.h.a.a<j> parama, com.tencent.mm.loader.f.f paramf, final b.b paramb)
  {
    AppMethodBeat.i(166305);
    d.g.b.k.h(parama, "item");
    d.g.b.k.h(paramf, "fileNameCreator");
    d.g.b.k.h(paramb, "callback");
    paramf = (j)parama.value();
    if (paramf.cmR() == h.qJY)
    {
      parama = paramf.getUrl() + paramf.fTN();
      ad.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramf.cmR() + ' ' + paramf.fTN() + " uniqueValue=" + paramf.aaX() + ' ' + parama);
    }
    for (;;)
    {
      Object localObject1 = z.Jhz;
      int i = com.tencent.mm.protocal.d.CpK;
      d.g.b.k.g(com.tencent.mm.kernel.g.afz(), "MMKernel.account()");
      localObject1 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(ay.getNetTypeForStat(aj.getContext())), Integer.valueOf(ay.getStrength(aj.getContext())), "" }, 5));
      d.g.b.k.g(localObject1, "java.lang.String.format(format, *args)");
      com.tencent.mm.i.e locale = new com.tencent.mm.i.e();
      Object localObject2 = com.tencent.mm.plugin.finder.utils.k.qTp;
      d.g.b.k.g(paramf, "data");
      localObject2 = com.tencent.mm.plugin.finder.utils.k.a(paramf);
      i.deleteFile((String)localObject2);
      i.aMF(new com.tencent.mm.vfs.e((String)localObject2).getParent());
      if (!a(paramf, parama, (String)localObject2, locale, (String)localObject1)) {
        break label453;
      }
      locale.fnH = ((g.a)new b(paramf, paramb, (String)localObject2));
      if (!com.tencent.mm.ao.f.awL().d((com.tencent.mm.i.g)locale)) {
        break;
      }
      ad.i("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(166305);
      return;
      parama = paramf.cmT() + paramf.fTO();
      ad.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramf.cmR() + ' ' + paramf.fTO() + " uniqueValue=" + paramf.aaX() + ' ' + parama);
    }
    ad.w("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(166305);
    return;
    label453:
    ad.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(166305);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/loader/FinderCdnDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    b(j paramj, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(166302);
      d.g.b.k.h(paramString, "mediaId");
      ad.i("Finder.FinderCdnDownloader", "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
      if (paramd != null)
      {
        if (this.qCg == null)
        {
          AppMethodBeat.o(166302);
          return 0;
        }
        paramString = paramb;
        paramc = com.tencent.mm.loader.h.a.an(this.qCi, "");
        d.g.b.k.g(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
        paramString.a((com.tencent.mm.loader.h.f)paramc);
      }
      AppMethodBeat.o(166302);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(166303);
      d.g.b.k.h(paramString, "mediaId");
      d.g.b.k.h(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(166303);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(166304);
      d.g.b.k.h(paramString, "mediaId");
      d.g.b.k.h(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(166304);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.c
 * JD-Core Version:    0.7.0.1
 */