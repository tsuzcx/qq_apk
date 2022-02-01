package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.n.d;
import d.v;
import java.nio.charset.Charset;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/PathRouter;", "", "()V", "finderAccDataPath", "", "finderAccPath", "getFinderAccPath", "()Ljava/lang/String;", "finderAvatarPath", "getFinderAvatarPath", "finderCapturePath", "getFinderCapturePath", "finderConstantsDataPath", "getFinderConstantsDataPath", "finderConstantsPath", "getFinderConstantsPath", "finderCoverImagePath", "getFinderCoverImagePath", "finderImgPath", "getFinderImgPath", "finderPostPath", "getFinderPostPath", "finderTmpPath", "getFinderTmpPath", "finderVideoPath", "getFinderVideoPath", "folderArray", "", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "getFolderArray", "()[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "checkToCreateDir", "", "path", "noMedia", "", "cleanFile", "dumpCacheDir", "genPostVideoTmpPath", "username", "getAvatarFilePath", "avatar", "Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "getAvatarFileTmpPath", "getCaptureFilePath", "getConstantsDataPath", "getConstantsPath", "getCoverImageFilePath", "cover", "Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "getExifRotatedFilePath", "origFilePath", "getImageFilePath", "image", "Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "getImageFileTmpPath", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getMyFinderAvatarTempPath", "getNormalFileTmpPath", "getNormalJpegTmpPath", "getPostImagePath", "suffix", "getPostImageThumbPath", "imagePath", "getPostMediaDir", "getPostMediaTmpDir", "getPostMediaTmpPath", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getPostPath", "fileName", "getPostVideoCoverPath", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "getPostVideoPath", "getPostVideoThumbPath", "videoPath", "getTmpTextImagePath", "getUniqueValue", "finderMediaType", "mediaId", "mediaUrl", "getUrlImageFilePath", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "getUrlImageTmpPath", "getVideoCoverFilePath", "getVideoFilePath", "getVideoFileTmpPath", "inPostDir", "makeImageFilePath", "plugin-finder_release"})
public final class r
{
  private static String sYb;
  private static final String sYc;
  public static final String sYd;
  private static final String sYe;
  private static final String sYf;
  public static final String sYg;
  private static final String sYh;
  public static final String sYi;
  private static final String sYj;
  private static final String sYk;
  private static final String sYl;
  public static final f[] sYm;
  public static final r sYn;
  
  static
  {
    AppMethodBeat.i(167988);
    sYn = new r();
    sYb = "";
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    sYc = ((com.tencent.mm.kernel.e)localObject2).ajw() + "finder/";
    sYd = cXR() + "image/";
    sYe = cXR() + "avatar/";
    sYf = cXR() + "cover/";
    sYg = cXR() + "video/";
    sYh = cXR() + "tmp/";
    sYi = cXR() + "capture/";
    sYj = cXR() + "post/";
    sYk = cXR() + "constants/";
    sYl = sYc + "constants/";
    localObject1 = new f[11];
    localObject1[0] = new f(cXR(), "finderAccPath", 0L, true, false);
    localObject1[1] = new f(sYj, "finderPostPath", 0L, true, false);
    localObject1[2] = new f(sYk, "finderConstantsPath", 0L, true, false);
    localObject2 = sYd;
    b localb = b.sHP;
    localObject1[3] = new f((String)localObject2, "finderImgPath", b.cHy(), false, 24);
    localObject2 = sYe;
    localb = b.sHP;
    localObject1[4] = new f((String)localObject2, "finderAvatarPath", b.cHz(), false, 24);
    localObject2 = sYf;
    localb = b.sHP;
    localObject1[5] = new f((String)localObject2, "finderCoverImagePath", b.cHA(), false, 24);
    localObject2 = sYg;
    localb = b.sHP;
    localObject1[6] = new f((String)localObject2, "finderVideoPath", b.cHB(), false, 24);
    localObject2 = sYh;
    localb = b.sHP;
    localObject1[7] = new f((String)localObject2, "finderTmpPath", b.cHC(), false, 24);
    localObject2 = sYi;
    localb = b.sHP;
    localObject1[8] = new f((String)localObject2, "finderCapturePath", b.cHD(), false, 24);
    localObject1[9] = new f(cOy(), "finderPostMediaDir", 0L, false, 8);
    localObject2 = cOx();
    localb = b.sHP;
    localObject1[10] = new f((String)localObject2, "finderPostMediaTmpDir", b.cHE(), false, 24);
    sYm = (f[])localObject1;
    int i = 0;
    while (i < 11)
    {
      localObject1[i].cNI();
      i += 1;
    }
    ae.i("Finder.Loader", "finderAccPath:" + cXR() + " finderImgPath:" + sYd + " finderVideoPath:" + sYg + " finderCapturePath:" + sYi);
    AppMethodBeat.o(167988);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(167979);
    p.h(parama, "avatar");
    parama = sYe + parama.srn;
    AppMethodBeat.o(167979);
    return parama;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.e parame)
  {
    AppMethodBeat.i(167980);
    p.h(parame, "cover");
    parame = sYf + parame.srn;
    AppMethodBeat.o(167980);
    return parame;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.g paramg)
  {
    AppMethodBeat.i(167976);
    p.h(paramg, "image");
    paramg = sYd + paramg.aeM();
    AppMethodBeat.o(167976);
    return paramg;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.g paramg, String paramString)
  {
    AppMethodBeat.i(205204);
    p.h(paramg, "image");
    p.h(paramString, "suffix");
    paramg = cOy() + paramg.aeM() + "_" + paramString;
    AppMethodBeat.o(205204);
    return paramg;
  }
  
  public static String a(k paramk)
  {
    AppMethodBeat.i(167977);
    p.h(paramk, "image");
    paramk = sYh + paramk.aeM();
    AppMethodBeat.o(167977);
    return paramk;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(167975);
    p.h(paraml, "image");
    paraml = sYd + paraml.aeM();
    AppMethodBeat.o(167975);
    return paraml;
  }
  
  public static String a(m paramm)
  {
    AppMethodBeat.i(167974);
    p.h(paramm, "video");
    paramm = sYg + paramm.aeM();
    AppMethodBeat.o(167974);
    return paramm;
  }
  
  public static String a(m paramm, String paramString)
  {
    AppMethodBeat.i(167983);
    p.h(paramm, "video");
    p.h(paramString, "suffix");
    paramm = cOy() + paramm.aeM() + "_" + paramString;
    AppMethodBeat.o(167983);
    return paramm;
  }
  
  public static String a(n paramn)
  {
    AppMethodBeat.i(205201);
    p.h(paramn, "image");
    paramn = sYd + paramn.aeM();
    AppMethodBeat.o(205201);
    return paramn;
  }
  
  public static String a(n paramn, String paramString)
  {
    AppMethodBeat.i(205205);
    p.h(paramn, "image");
    p.h(paramString, "suffix");
    paramn = cOy() + paramn.aeM() + "_" + paramString;
    AppMethodBeat.o(205205);
    return paramn;
  }
  
  public static String aka(String paramString)
  {
    AppMethodBeat.i(167982);
    p.h(paramString, "origFilePath");
    paramString = sYh + aj.ej(paramString).toString() + "_" + o.aZS(paramString) + "_rotated";
    AppMethodBeat.o(167982);
    return paramString;
  }
  
  public static String akb(String paramString)
  {
    AppMethodBeat.i(205203);
    p.h(paramString, "fileName");
    paramString = cOy() + paramString;
    AppMethodBeat.o(205203);
    return paramString;
  }
  
  public static String akc(String paramString)
  {
    AppMethodBeat.i(167984);
    p.h(paramString, "videoPath");
    paramString = cOy() + "video_" + aj.ej(paramString) + "_" + o.aZS(paramString) + "_thumb";
    AppMethodBeat.o(167984);
    return paramString;
  }
  
  public static String bw(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224309);
    StringBuilder localStringBuilder = new StringBuilder("finder_video_").append(paramString1).append('_');
    paramString1 = paramString2;
    if (bu.isNullOrNil(paramString2))
    {
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      paramString1 = aj.ej(paramString1);
    }
    paramString1 = paramString1;
    AppMethodBeat.o(224309);
    return paramString1;
  }
  
  public static String cOo()
  {
    return sYd;
  }
  
  public static String cOp()
  {
    return sYg;
  }
  
  public static String cOq()
  {
    return sYh;
  }
  
  public static f[] cOr()
  {
    return sYm;
  }
  
  public static String cOt()
  {
    AppMethodBeat.i(167978);
    Object localObject1 = new StringBuilder().append(sYi);
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167978);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject2);
    AppMethodBeat.o(167978);
    return localObject1;
  }
  
  public static String cOu()
  {
    AppMethodBeat.i(205202);
    String str = sYh + System.nanoTime() + ".jpg";
    AppMethodBeat.o(205202);
    return str;
  }
  
  public static String cOv()
  {
    return sYk;
  }
  
  public static String cOw()
  {
    return sYl;
  }
  
  public static String cOx()
  {
    AppMethodBeat.i(167985);
    String str = sYj + "media_tmp/";
    AppMethodBeat.o(167985);
    return str;
  }
  
  public static String cOy()
  {
    AppMethodBeat.i(167986);
    String str = sYj + "posting/";
    AppMethodBeat.o(167986);
    return str;
  }
  
  public static String cXR()
  {
    AppMethodBeat.i(224308);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    localObject = locale.getAccPath() + "finder/";
    AppMethodBeat.o(224308);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.r
 * JD-Core Version:    0.7.0.1
 */