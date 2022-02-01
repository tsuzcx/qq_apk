package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.j;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.i;
import d.o;
import d.v;
import d.y;
import java.nio.charset.Charset;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/PathRouter;", "", "()V", "finderAccDataPath", "", "finderAccPath", "finderAvatarPath", "getFinderAvatarPath", "()Ljava/lang/String;", "finderCapturePath", "getFinderCapturePath", "finderConstantsDataPath", "getFinderConstantsDataPath", "finderConstantsPath", "getFinderConstantsPath", "finderCoverImagePath", "getFinderCoverImagePath", "finderImgPath", "getFinderImgPath", "finderPostPath", "getFinderPostPath", "finderTmpPath", "getFinderTmpPath", "finderVideoPath", "getFinderVideoPath", "folderArray", "", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "getFolderArray", "()[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "checkToCreateDir", "", "path", "noMedia", "", "cleanFile", "dumpCacheDir", "genPostVideoTmpPath", "username", "getAvatarFilePath", "avatar", "Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "getAvatarFileTmpPath", "getCaptureFilePath", "getConstantsDataPath", "getConstantsPath", "getCoverImageFilePath", "cover", "Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "getExifRotatedFilePath", "origFilePath", "getImageFilePath", "image", "Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "getImageFileTmpPath", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getMyFinderAvatarTempPath", "getNormalFileTmpPath", "getNormalJpegTmpPath", "getPostImagePath", "suffix", "getPostImageThumbPath", "imagePath", "getPostMediaDir", "getPostMediaTmpDir", "getPostMediaTmpPath", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getPostPath", "fileName", "getPostVideoCoverPath", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "getPostVideoPath", "getPostVideoThumbPath", "videoPath", "getTmpTextImagePath", "getUrlImageFilePath", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "getUrlImageTmpPath", "getVideoCoverFilePath", "getVideoFilePath", "getVideoFileTmpPath", "inPostDir", "makeImageFilePath", "plugin-finder_release"})
public final class p
{
  private static final String rQk;
  private static final String rQl;
  private static final String rQm;
  private static final String rQn;
  private static final String rQo;
  private static final String rQp;
  private static final String rQq;
  private static final String rQr;
  private static final String rQs;
  private static final String rQt;
  private static final String rQu;
  private static final e[] rQv;
  public static final p rQw;
  
  static
  {
    AppMethodBeat.i(167988);
    rQw = new p();
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    rQk = ((com.tencent.mm.kernel.e)localObject2).getAccPath() + "finder/";
    localObject1 = new StringBuilder();
    localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    rQl = ((com.tencent.mm.kernel.e)localObject2).agv() + "finder/";
    rQm = rQk + "image/";
    rQn = rQk + "avatar/";
    rQo = rQk + "cover/";
    rQp = rQk + "video/";
    rQq = rQk + "tmp/";
    rQr = rQk + "capture/";
    rQs = rQk + "post/";
    rQt = rQk + "constants/";
    rQu = rQl + "constants/";
    localObject1 = new e[11];
    localObject1[0] = new e(rQk, "finderAccPath", 0L, true, false);
    localObject1[1] = new e(rQs, "finderPostPath", 0L, true, false);
    localObject1[2] = new e(rQt, "finderConstantsPath", 0L, true, false);
    localObject2 = rQm;
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject1[3] = new e((String)localObject2, "finderImgPath", com.tencent.mm.plugin.finder.storage.b.cyC(), false, 24);
    localObject2 = rQn;
    localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject1[4] = new e((String)localObject2, "finderAvatarPath", com.tencent.mm.plugin.finder.storage.b.cyD(), false, 24);
    localObject2 = rQo;
    localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject1[5] = new e((String)localObject2, "finderCoverImagePath", com.tencent.mm.plugin.finder.storage.b.cyE(), false, 24);
    localObject2 = rQp;
    localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject1[6] = new e((String)localObject2, "finderVideoPath", com.tencent.mm.plugin.finder.storage.b.cyF(), false, 24);
    localObject2 = rQq;
    localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject1[7] = new e((String)localObject2, "finderTmpPath", com.tencent.mm.plugin.finder.storage.b.cyG(), false, 24);
    localObject2 = rQr;
    localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject1[8] = new e((String)localObject2, "finderCapturePath", com.tencent.mm.plugin.finder.storage.b.cyH(), false, 24);
    localObject1[9] = new e(cDw(), "finderPostMediaDir", 0L, false, 8);
    localObject2 = cDv();
    localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject1[10] = new e((String)localObject2, "finderPostMediaTmpDir", com.tencent.mm.plugin.finder.storage.b.cyI(), false, 24);
    rQv = (e[])localObject1;
    int i = 0;
    while (i < 11)
    {
      localObject1[i].cCN();
      i += 1;
    }
    ac.i("Finder.Loader", "finderAccPath:" + rQk + " finderImgPath:" + rQm + " finderVideoPath:" + rQp + " finderCapturePath:" + rQr);
    AppMethodBeat.o(167988);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(167979);
    d.g.b.k.h(parama, "avatar");
    parama = rQn + parama.rtf;
    AppMethodBeat.o(167979);
    return parama;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.d paramd)
  {
    AppMethodBeat.i(167980);
    d.g.b.k.h(paramd, "cover");
    paramd = rQo + paramd.rtf;
    AppMethodBeat.o(167980);
    return paramd;
  }
  
  public static String a(f paramf)
  {
    AppMethodBeat.i(167976);
    d.g.b.k.h(paramf, "image");
    paramf = rQm + paramf.abW();
    AppMethodBeat.o(167976);
    return paramf;
  }
  
  public static String a(f paramf, String paramString)
  {
    AppMethodBeat.i(203673);
    d.g.b.k.h(paramf, "image");
    d.g.b.k.h(paramString, "suffix");
    paramf = cDw() + paramf.abW() + "_" + paramString;
    AppMethodBeat.o(203673);
    return paramf;
  }
  
  public static String a(j paramj)
  {
    AppMethodBeat.i(167977);
    d.g.b.k.h(paramj, "image");
    paramj = rQq + paramj.abW();
    AppMethodBeat.o(167977);
    return paramj;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.k paramk)
  {
    AppMethodBeat.i(167975);
    d.g.b.k.h(paramk, "image");
    paramk = rQm + paramk.abW();
    AppMethodBeat.o(167975);
    return paramk;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(167974);
    d.g.b.k.h(paraml, "video");
    paraml = rQp + paraml.abW();
    AppMethodBeat.o(167974);
    return paraml;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.l paraml, String paramString)
  {
    AppMethodBeat.i(167983);
    d.g.b.k.h(paraml, "video");
    d.g.b.k.h(paramString, "suffix");
    paraml = cDw() + paraml.abW() + "_" + paramString;
    AppMethodBeat.o(167983);
    return paraml;
  }
  
  public static String a(m paramm)
  {
    AppMethodBeat.i(203670);
    d.g.b.k.h(paramm, "image");
    paramm = rQm + paramm.abW();
    AppMethodBeat.o(203670);
    return paramm;
  }
  
  public static String a(m paramm, String paramString)
  {
    AppMethodBeat.i(203674);
    d.g.b.k.h(paramm, "image");
    d.g.b.k.h(paramString, "suffix");
    paramm = cDw() + paramm.abW() + "_" + paramString;
    AppMethodBeat.o(203674);
    return paramm;
  }
  
  public static String aeJ(String paramString)
  {
    AppMethodBeat.i(167982);
    d.g.b.k.h(paramString, "origFilePath");
    paramString = rQq + ah.dg(paramString).toString() + "_" + i.aSq(paramString) + "_rotated";
    AppMethodBeat.o(167982);
    return paramString;
  }
  
  public static String aeK(String paramString)
  {
    AppMethodBeat.i(203672);
    d.g.b.k.h(paramString, "fileName");
    paramString = cDw() + paramString;
    AppMethodBeat.o(203672);
    return paramString;
  }
  
  public static String aeL(String paramString)
  {
    AppMethodBeat.i(167984);
    d.g.b.k.h(paramString, "videoPath");
    paramString = cDw() + "video_" + ah.dg(paramString) + "_" + i.aSq(paramString) + "_thumb";
    AppMethodBeat.o(167984);
    return paramString;
  }
  
  public static String cDm()
  {
    return rQm;
  }
  
  public static String cDn()
  {
    return rQp;
  }
  
  public static String cDo()
  {
    return rQq;
  }
  
  public static e[] cDp()
  {
    return rQv;
  }
  
  public static void cDq()
  {
    int j = 0;
    AppMethodBeat.i(203669);
    e[] arrayOfe = rQv;
    int k = arrayOfe.length;
    int i = 0;
    while (i < k)
    {
      i.deleteDir(arrayOfe[i].path);
      i += 1;
    }
    arrayOfe = rQv;
    k = arrayOfe.length;
    i = j;
    while (i < k)
    {
      arrayOfe[i].cCN();
      i += 1;
    }
    ac.i("Finder.Loader", "cleanFile finderAccPath:" + rQk + " finderImgPath:" + rQm + " finderVideoPath:" + rQp + " finderCapturePath:" + rQr);
    AppMethodBeat.o(203669);
  }
  
  public static String cDr()
  {
    AppMethodBeat.i(167978);
    Object localObject1 = new StringBuilder().append(rQr);
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167978);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    d.g.b.k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject2);
    AppMethodBeat.o(167978);
    return localObject1;
  }
  
  public static String cDs()
  {
    AppMethodBeat.i(203671);
    String str = rQq + System.nanoTime() + ".jpg";
    AppMethodBeat.o(203671);
    return str;
  }
  
  public static String cDt()
  {
    return rQt;
  }
  
  public static String cDu()
  {
    return rQu;
  }
  
  public static String cDv()
  {
    AppMethodBeat.i(167985);
    String str = rQs + "media_tmp/";
    AppMethodBeat.o(167985);
    return str;
  }
  
  public static String cDw()
  {
    AppMethodBeat.i(167986);
    String str = rQs + "posting/";
    AppMethodBeat.o(167986);
    return str;
  }
  
  public static String cDx()
  {
    AppMethodBeat.i(167987);
    com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("dumpCacheDir");
    Object localObject = "";
    e[] arrayOfe = rQv;
    int j = arrayOfe.length;
    int i = 0;
    while (i < j)
    {
      o localo = arrayOfe[i].cCO();
      localObject = (String)localObject + (String)localo.first + "\n";
      i += 1;
    }
    localObject = new StringBuilder().append(rQk).append(": \n ").append((String)localObject).append("  ");
    localb.aic();
    localObject = y.KTp;
    AppMethodBeat.o(167987);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.p
 * JD-Core Version:    0.7.0.1
 */