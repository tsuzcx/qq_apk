package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.j;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.i;
import d.o;
import d.v;
import d.y;
import java.nio.charset.Charset;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/PathRouter;", "", "()V", "finderAccDataPath", "", "finderAccPath", "finderAvatarPath", "getFinderAvatarPath", "()Ljava/lang/String;", "finderCapturePath", "getFinderCapturePath", "finderConstantsDataPath", "getFinderConstantsDataPath", "finderConstantsPath", "getFinderConstantsPath", "finderCoverImagePath", "getFinderCoverImagePath", "finderImgPath", "getFinderImgPath", "finderPostPath", "getFinderPostPath", "finderTmpPath", "getFinderTmpPath", "finderVideoPath", "getFinderVideoPath", "folderArray", "", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "getFolderArray", "()[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "checkToCreateDir", "", "path", "noMedia", "", "cleanFile", "dumpCacheDir", "genPostVideoTmpPath", "username", "getAvatarFilePath", "avatar", "Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "getAvatarFileTmpPath", "getCaptureFilePath", "getConstantsDataPath", "getConstantsPath", "getCoverImageFilePath", "cover", "Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "getExifRotatedFilePath", "origFilePath", "getImageFilePath", "image", "Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "getImageFileTmpPath", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getMyFinderAvatarTempPath", "getNormalFileTmpPath", "getPostImagePath", "suffix", "getPostImageThumbPath", "imagePath", "getPostMediaDir", "getPostMediaTmpDir", "getPostMediaTmpPath", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getPostPath", "fileName", "getPostVideoCoverPath", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "getPostVideoPath", "getPostVideoThumbPath", "videoPath", "getTmpTextImagePath", "getUrlImageFilePath", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "getUrlImageTmpPath", "getVideoCoverFilePath", "getVideoFilePath", "getVideoFileTmpPath", "inPostDir", "makeImageFilePath", "plugin-finder_release"})
public final class k
{
  private static final String LbA;
  private static final String LbB;
  private static final String qTf;
  private static final String qTg;
  private static final String qTh;
  private static final String qTi;
  private static final String qTj;
  private static final String qTk;
  private static final String qTl;
  private static final String qTm;
  private static final String qTn;
  private static final c[] qTo;
  public static final k qTp;
  
  static
  {
    AppMethodBeat.i(167988);
    qTp = new k();
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    qTf = ((e)localObject2).getAccPath() + "finder/";
    localObject1 = new StringBuilder();
    localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    LbA = ((e)localObject2).aff() + "finder/";
    qTg = qTf + "image/";
    qTh = qTf + "avatar/";
    qTi = qTf + "cover/";
    qTj = qTf + "video/";
    qTk = qTf + "tmp/";
    qTl = qTf + "capture/";
    qTm = qTf + "post/";
    qTn = qTf + "constants/";
    LbB = LbA + "constants/";
    localObject1 = new c[11];
    localObject1[0] = new c(qTf, "finderAccPath", 0L, true, false);
    localObject1[1] = new c(qTm, "finderPostPath", 0L, true, false);
    localObject1[2] = new c(qTn, "finderConstantsPath", 0L, true, false);
    localObject2 = qTg;
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject1[3] = new c((String)localObject2, "finderImgPath", com.tencent.mm.plugin.finder.storage.b.cpf(), false, 24);
    localObject2 = qTh;
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject1[4] = new c((String)localObject2, "finderAvatarPath", com.tencent.mm.plugin.finder.storage.b.cpg(), false, 24);
    localObject2 = qTi;
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject1[5] = new c((String)localObject2, "finderCoverImagePath", com.tencent.mm.plugin.finder.storage.b.cph(), false, 24);
    localObject2 = qTj;
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject1[6] = new c((String)localObject2, "finderVideoPath", com.tencent.mm.plugin.finder.storage.b.cpi(), false, 24);
    localObject2 = qTk;
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject1[7] = new c((String)localObject2, "finderTmpPath", com.tencent.mm.plugin.finder.storage.b.cpj(), false, 24);
    localObject2 = qTl;
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject1[8] = new c((String)localObject2, "finderCapturePath", com.tencent.mm.plugin.finder.storage.b.cpk(), false, 24);
    localObject1[9] = new c(csd(), "finderPostMediaDir", 0L, false, 8);
    localObject2 = csc();
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject1[10] = new c((String)localObject2, "finderPostMediaTmpDir", com.tencent.mm.plugin.finder.storage.b.cpl(), false, 24);
    qTo = (c[])localObject1;
    int i = 0;
    while (i < 11)
    {
      localObject1[i].crM();
      i += 1;
    }
    ad.i("Finder.Loader", "finderAccPath:" + qTf + " finderImgPath:" + qTg + " finderVideoPath:" + qTj + " finderCapturePath:" + qTl);
    AppMethodBeat.o(167988);
  }
  
  public static String ZX(String paramString)
  {
    AppMethodBeat.i(167982);
    d.g.b.k.h(paramString, "origFilePath");
    paramString = qTk + ai.du(paramString).toString() + "_" + i.aMO(paramString) + "_rotated";
    AppMethodBeat.o(167982);
    return paramString;
  }
  
  public static String ZY(String paramString)
  {
    AppMethodBeat.i(167984);
    d.g.b.k.h(paramString, "videoPath");
    paramString = csd() + "video_" + ai.du(paramString) + "_" + i.aMO(paramString) + "_thumb";
    AppMethodBeat.o(167984);
    return paramString;
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(167979);
    d.g.b.k.h(parama, "avatar");
    parama = qTh + parama.qCd;
    AppMethodBeat.o(167979);
    return parama;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.d paramd)
  {
    AppMethodBeat.i(167980);
    d.g.b.k.h(paramd, "cover");
    paramd = qTi + paramd.qCd;
    AppMethodBeat.o(167980);
    return paramd;
  }
  
  public static String a(f paramf)
  {
    AppMethodBeat.i(167976);
    d.g.b.k.h(paramf, "image");
    paramf = qTg + paramf.aaX();
    AppMethodBeat.o(167976);
    return paramf;
  }
  
  public static String a(f paramf, String paramString)
  {
    AppMethodBeat.i(199688);
    d.g.b.k.h(paramf, "image");
    d.g.b.k.h(paramString, "suffix");
    paramf = csd() + paramf.aaX() + "_" + paramString;
    AppMethodBeat.o(199688);
    return paramf;
  }
  
  public static String a(j paramj)
  {
    AppMethodBeat.i(167977);
    d.g.b.k.h(paramj, "image");
    paramj = qTk + paramj.aaX();
    AppMethodBeat.o(167977);
    return paramj;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.k paramk)
  {
    AppMethodBeat.i(167975);
    d.g.b.k.h(paramk, "image");
    paramk = qTg + paramk.aaX();
    AppMethodBeat.o(167975);
    return paramk;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.l paraml, String paramString)
  {
    AppMethodBeat.i(167983);
    d.g.b.k.h(paraml, "video");
    d.g.b.k.h(paramString, "suffix");
    paraml = csd() + paraml.aaX() + "_" + paramString;
    AppMethodBeat.o(167983);
    return paraml;
  }
  
  public static String a(n paramn)
  {
    AppMethodBeat.i(199686);
    d.g.b.k.h(paramn, "image");
    paramn = qTg + paramn.aaX();
    AppMethodBeat.o(199686);
    return paramn;
  }
  
  public static String a(n paramn, String paramString)
  {
    AppMethodBeat.i(199689);
    d.g.b.k.h(paramn, "image");
    d.g.b.k.h(paramString, "suffix");
    paramn = csd() + paramn.aaX() + "_" + paramString;
    AppMethodBeat.o(199689);
    return paramn;
  }
  
  public static String aVH(String paramString)
  {
    AppMethodBeat.i(199687);
    d.g.b.k.h(paramString, "fileName");
    paramString = csd() + paramString;
    AppMethodBeat.o(199687);
    return paramString;
  }
  
  public static String b(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(167974);
    d.g.b.k.h(paraml, "video");
    paraml = qTj + paraml.aaX();
    AppMethodBeat.o(167974);
    return paraml;
  }
  
  public static String crV()
  {
    return qTg;
  }
  
  public static String crW()
  {
    return qTj;
  }
  
  public static String crX()
  {
    return qTk;
  }
  
  public static c[] crY()
  {
    return qTo;
  }
  
  public static String crZ()
  {
    AppMethodBeat.i(167978);
    Object localObject1 = new StringBuilder().append(qTl);
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
  
  public static String csa()
  {
    AppMethodBeat.i(167981);
    String str = qTk + System.nanoTime() + ".tmp";
    AppMethodBeat.o(167981);
    return str;
  }
  
  public static String csb()
  {
    return qTn;
  }
  
  public static String csc()
  {
    AppMethodBeat.i(167985);
    String str = qTm + "media_tmp/";
    AppMethodBeat.o(167985);
    return str;
  }
  
  public static String csd()
  {
    AppMethodBeat.i(167986);
    String str = qTm + "posting/";
    AppMethodBeat.o(167986);
    return str;
  }
  
  public static String cse()
  {
    AppMethodBeat.i(167987);
    com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("dumpCacheDir");
    Object localObject = "";
    c[] arrayOfc = qTo;
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      o localo = arrayOfc[i].crN();
      localObject = (String)localObject + (String)localo.first + "\n";
      i += 1;
    }
    localObject = new StringBuilder().append(qTf).append(": \n ").append((String)localObject).append("  ");
    localb.agL();
    localObject = y.JfV;
    AppMethodBeat.o(167987);
    return localObject;
  }
  
  public static void eJc()
  {
    int j = 0;
    AppMethodBeat.i(199685);
    c[] arrayOfc = qTo;
    int k = arrayOfc.length;
    int i = 0;
    while (i < k)
    {
      i.deleteDir(arrayOfc[i].path);
      i += 1;
    }
    arrayOfc = qTo;
    k = arrayOfc.length;
    i = j;
    while (i < k)
    {
      arrayOfc[i].crM();
      i += 1;
    }
    ad.i("Finder.Loader", "cleanFile finderAccPath:" + qTf + " finderImgPath:" + qTg + " finderVideoPath:" + qTj + " finderCapturePath:" + qTl);
    AppMethodBeat.o(199685);
  }
  
  public static String fWh()
  {
    return LbB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.k
 * JD-Core Version:    0.7.0.1
 */