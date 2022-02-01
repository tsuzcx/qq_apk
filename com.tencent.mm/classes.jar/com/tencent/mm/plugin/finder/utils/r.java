package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.n.d;
import d.o;
import d.v;
import d.z;
import java.nio.charset.Charset;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/PathRouter;", "", "()V", "finderAccDataPath", "", "finderAccPath", "finderAvatarPath", "getFinderAvatarPath", "()Ljava/lang/String;", "finderCapturePath", "getFinderCapturePath", "finderConstantsDataPath", "getFinderConstantsDataPath", "finderConstantsPath", "getFinderConstantsPath", "finderCoverImagePath", "getFinderCoverImagePath", "finderImgPath", "getFinderImgPath", "finderPostPath", "getFinderPostPath", "finderTmpPath", "getFinderTmpPath", "finderVideoPath", "getFinderVideoPath", "folderArray", "", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "getFolderArray", "()[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "checkToCreateDir", "", "path", "noMedia", "", "cleanFile", "dumpCacheDir", "genPostVideoTmpPath", "username", "getAvatarFilePath", "avatar", "Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "getAvatarFileTmpPath", "getCaptureFilePath", "getConstantsDataPath", "getConstantsPath", "getCoverImageFilePath", "cover", "Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "getExifRotatedFilePath", "origFilePath", "getImageFilePath", "image", "Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "getImageFileTmpPath", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getMyFinderAvatarTempPath", "getNormalFileTmpPath", "getNormalJpegTmpPath", "getPostImagePath", "suffix", "getPostImageThumbPath", "imagePath", "getPostMediaDir", "getPostMediaTmpDir", "getPostMediaTmpPath", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getPostPath", "fileName", "getPostVideoCoverPath", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "getPostVideoPath", "getPostVideoThumbPath", "videoPath", "getTmpTextImagePath", "getUrlImageFilePath", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "getUrlImageTmpPath", "getVideoCoverFilePath", "getVideoFilePath", "getVideoFileTmpPath", "inPostDir", "makeImageFilePath", "plugin-finder_release"})
public final class r
{
  private static final String sMQ;
  private static final String sMR;
  private static final String sMS;
  private static final String sMT;
  private static final String sMU;
  private static final String sMV;
  private static final String sMW;
  private static final String sMX;
  private static final String sMY;
  private static final String sMZ;
  private static final String sNa;
  private static final f[] sNb;
  public static final r sNc;
  
  static
  {
    AppMethodBeat.i(167988);
    sNc = new r();
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    sMQ = ((com.tencent.mm.kernel.e)localObject2).getAccPath() + "finder/";
    localObject1 = new StringBuilder();
    localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    sMR = ((com.tencent.mm.kernel.e)localObject2).ajh() + "finder/";
    sMS = sMQ + "image/";
    sMT = sMQ + "avatar/";
    sMU = sMQ + "cover/";
    sMV = sMQ + "video/";
    sMW = sMQ + "tmp/";
    sMX = sMQ + "capture/";
    sMY = sMQ + "post/";
    sMZ = sMQ + "constants/";
    sNa = sMR + "constants/";
    localObject1 = new f[11];
    localObject1[0] = new f(sMQ, "finderAccPath", 0L, true, false);
    localObject1[1] = new f(sMY, "finderPostPath", 0L, true, false);
    localObject1[2] = new f(sMZ, "finderConstantsPath", 0L, true, false);
    localObject2 = sMS;
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1[3] = new f((String)localObject2, "finderImgPath", com.tencent.mm.plugin.finder.storage.b.cFB(), false, 24);
    localObject2 = sMT;
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1[4] = new f((String)localObject2, "finderAvatarPath", com.tencent.mm.plugin.finder.storage.b.cFC(), false, 24);
    localObject2 = sMU;
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1[5] = new f((String)localObject2, "finderCoverImagePath", com.tencent.mm.plugin.finder.storage.b.cFD(), false, 24);
    localObject2 = sMV;
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1[6] = new f((String)localObject2, "finderVideoPath", com.tencent.mm.plugin.finder.storage.b.cFE(), false, 24);
    localObject2 = sMW;
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1[7] = new f((String)localObject2, "finderTmpPath", com.tencent.mm.plugin.finder.storage.b.cFF(), false, 24);
    localObject2 = sMX;
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1[8] = new f((String)localObject2, "finderCapturePath", com.tencent.mm.plugin.finder.storage.b.cFG(), false, 24);
    localObject1[9] = new f(cLQ(), "finderPostMediaDir", 0L, false, 8);
    localObject2 = cLP();
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1[10] = new f((String)localObject2, "finderPostMediaTmpDir", com.tencent.mm.plugin.finder.storage.b.cFH(), false, 24);
    sNb = (f[])localObject1;
    int i = 0;
    while (i < 11)
    {
      localObject1[i].cLe();
      i += 1;
    }
    ad.i("Finder.Loader", "finderAccPath:" + sMQ + " finderImgPath:" + sMS + " finderVideoPath:" + sMV + " finderCapturePath:" + sMX);
    AppMethodBeat.o(167988);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(167979);
    p.h(parama, "avatar");
    parama = sMT + parama.sis;
    AppMethodBeat.o(167979);
    return parama;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.e parame)
  {
    AppMethodBeat.i(167980);
    p.h(parame, "cover");
    parame = sMU + parame.sis;
    AppMethodBeat.o(167980);
    return parame;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.g paramg)
  {
    AppMethodBeat.i(167976);
    p.h(paramg, "image");
    paramg = sMS + paramg.aeA();
    AppMethodBeat.o(167976);
    return paramg;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.g paramg, String paramString)
  {
    AppMethodBeat.i(204580);
    p.h(paramg, "image");
    p.h(paramString, "suffix");
    paramg = cLQ() + paramg.aeA() + "_" + paramString;
    AppMethodBeat.o(204580);
    return paramg;
  }
  
  public static String a(k paramk)
  {
    AppMethodBeat.i(167977);
    p.h(paramk, "image");
    paramk = sMW + paramk.aeA();
    AppMethodBeat.o(167977);
    return paramk;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(167975);
    p.h(paraml, "image");
    paraml = sMS + paraml.aeA();
    AppMethodBeat.o(167975);
    return paraml;
  }
  
  public static String a(m paramm)
  {
    AppMethodBeat.i(167974);
    p.h(paramm, "video");
    paramm = sMV + paramm.aeA();
    AppMethodBeat.o(167974);
    return paramm;
  }
  
  public static String a(m paramm, String paramString)
  {
    AppMethodBeat.i(167983);
    p.h(paramm, "video");
    p.h(paramString, "suffix");
    paramm = cLQ() + paramm.aeA() + "_" + paramString;
    AppMethodBeat.o(167983);
    return paramm;
  }
  
  public static String a(n paramn)
  {
    AppMethodBeat.i(204577);
    p.h(paramn, "image");
    paramn = sMS + paramn.aeA();
    AppMethodBeat.o(204577);
    return paramn;
  }
  
  public static String a(n paramn, String paramString)
  {
    AppMethodBeat.i(204581);
    p.h(paramn, "image");
    p.h(paramString, "suffix");
    paramn = cLQ() + paramn.aeA() + "_" + paramString;
    AppMethodBeat.o(204581);
    return paramn;
  }
  
  public static String ajd(String paramString)
  {
    AppMethodBeat.i(167982);
    p.h(paramString, "origFilePath");
    paramString = sMW + ai.ee(paramString).toString() + "_" + i.aYp(paramString) + "_rotated";
    AppMethodBeat.o(167982);
    return paramString;
  }
  
  public static String aje(String paramString)
  {
    AppMethodBeat.i(204579);
    p.h(paramString, "fileName");
    paramString = cLQ() + paramString;
    AppMethodBeat.o(204579);
    return paramString;
  }
  
  public static String ajf(String paramString)
  {
    AppMethodBeat.i(167984);
    p.h(paramString, "videoPath");
    paramString = cLQ() + "video_" + ai.ee(paramString) + "_" + i.aYp(paramString) + "_thumb";
    AppMethodBeat.o(167984);
    return paramString;
  }
  
  public static String cLG()
  {
    return sMS;
  }
  
  public static String cLH()
  {
    return sMV;
  }
  
  public static String cLI()
  {
    return sMW;
  }
  
  public static f[] cLJ()
  {
    return sNb;
  }
  
  public static void cLK()
  {
    int j = 0;
    AppMethodBeat.i(204576);
    f[] arrayOff = sNb;
    int k = arrayOff.length;
    int i = 0;
    while (i < k)
    {
      i.deleteDir(arrayOff[i].path);
      i += 1;
    }
    arrayOff = sNb;
    k = arrayOff.length;
    i = j;
    while (i < k)
    {
      arrayOff[i].cLe();
      i += 1;
    }
    ad.i("Finder.Loader", "cleanFile finderAccPath:" + sMQ + " finderImgPath:" + sMS + " finderVideoPath:" + sMV + " finderCapturePath:" + sMX);
    AppMethodBeat.o(204576);
  }
  
  public static String cLL()
  {
    AppMethodBeat.i(167978);
    Object localObject1 = new StringBuilder().append(sMX);
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
  
  public static String cLM()
  {
    AppMethodBeat.i(204578);
    String str = sMW + System.nanoTime() + ".jpg";
    AppMethodBeat.o(204578);
    return str;
  }
  
  public static String cLN()
  {
    return sMZ;
  }
  
  public static String cLO()
  {
    return sNa;
  }
  
  public static String cLP()
  {
    AppMethodBeat.i(167985);
    String str = sMY + "media_tmp/";
    AppMethodBeat.o(167985);
    return str;
  }
  
  public static String cLQ()
  {
    AppMethodBeat.i(167986);
    String str = sMY + "posting/";
    AppMethodBeat.o(167986);
    return str;
  }
  
  public static String cLR()
  {
    AppMethodBeat.i(167987);
    com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("dumpCacheDir");
    Object localObject = "";
    f[] arrayOff = sNb;
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      o localo = arrayOff[i].cLf();
      localObject = (String)localObject + (String)localo.first + "\n";
      i += 1;
    }
    localObject = new StringBuilder().append(sMQ).append(": \n ").append((String)localObject).append("  ");
    localb.akO();
    localObject = z.MKo;
    AppMethodBeat.o(167987);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.r
 * JD-Core Version:    0.7.0.1
 */