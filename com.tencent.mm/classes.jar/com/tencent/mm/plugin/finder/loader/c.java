package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderCdnDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "attachSnsImgTaskInfo", "", "data", "imageUrl", "", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.loader.d.b<j>
{
  public static final c.a rth;
  
  static
  {
    AppMethodBeat.i(166308);
    rth = new c.a((byte)0);
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
      parame.field_mediaId = ah.dg(paramString1);
      parame.url = paramString1;
      parame.snsCipherKey = paramj.cwk();
      parame.host = str;
      parame.referer = paramString3;
      parame.fqS = paramString2;
      parame.fqT = dz((List)localArrayList1);
      parame.fqU = dz((List)localArrayList2);
      parame.fqV = i;
      parame.fqW = j;
      parame.isColdSnsData = false;
      parame.signalQuality = ax.getStrength(ai.getContext());
      parame.snsScene = "";
      parame.eyd = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      ac.i("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo decodeKey:%s, imageUrl:%s", new Object[] { paramj.cwk(), paramString1 });
      AppMethodBeat.o(166306);
      return true;
    }
    catch (MalformedURLException paramj)
    {
      ac.printErrStackTrace("Finder.FinderCdnDownloader", (Throwable)paramj, "", new Object[0]);
      ac.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramj)));
      AppMethodBeat.o(166306);
    }
    return false;
  }
  
  private static String[] dz(List<String> paramList)
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
  
  public final void a(com.tencent.mm.loader.h.a.a<j> parama, com.tencent.mm.loader.f.f paramf, b.b paramb)
  {
    AppMethodBeat.i(166305);
    k.h(parama, "item");
    k.h(paramf, "fileNameCreator");
    k.h(paramb, "callback");
    paramf = (j)parama.value();
    if (paramf.cwj() == m.rDQ)
    {
      parama = paramf.getUrl() + paramf.cwl();
      ac.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramf.cwj() + ' ' + paramf.cwl() + " uniqueValue=" + paramf.abW() + ' ' + parama);
    }
    for (;;)
    {
      Object localObject1 = z.KUT;
      int i = d.DIc;
      k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
      localObject1 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(ax.getNetTypeForStat(ai.getContext())), Integer.valueOf(ax.getStrength(ai.getContext())), "" }, 5));
      k.g(localObject1, "java.lang.String.format(format, *args)");
      com.tencent.mm.i.e locale = new com.tencent.mm.i.e();
      Object localObject2 = com.tencent.mm.plugin.finder.utils.p.rQw;
      k.g(paramf, "data");
      localObject2 = com.tencent.mm.plugin.finder.utils.p.a(paramf);
      i.deleteFile((String)localObject2);
      i.aSh(new com.tencent.mm.vfs.e((String)localObject2).getParent());
      if (!a(paramf, parama, (String)localObject2, locale, (String)localObject1)) {
        break label453;
      }
      locale.frb = ((g.a)new c.b(paramf, paramb, (String)localObject2));
      if (!com.tencent.mm.an.f.aDD().e((com.tencent.mm.i.g)locale)) {
        break;
      }
      ac.i("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(166305);
      return;
      parama = paramf.aik() + paramf.cwm();
      ac.i("Finder.FinderCdnDownloader", "[loadByCdn] finder image, " + paramf.cwj() + ' ' + paramf.cwm() + " uniqueValue=" + paramf.abW() + ' ' + parama);
    }
    ac.w("Finder.FinderCdnDownloader", "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(166305);
    return;
    label453:
    ac.w("Finder.FinderCdnDownloader", "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(166305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.c
 * JD-Core Version:    0.7.0.1
 */