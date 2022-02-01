package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.v;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/PathRouter;", "", "()V", "finderAccDataPath", "", "finderAccPath", "getFinderAccPath", "()Ljava/lang/String;", "finderAvatarPath", "getFinderAvatarPath", "finderCapturePath", "getFinderCapturePath", "finderConstantsDataPath", "getFinderConstantsDataPath", "finderConstantsPath", "getFinderConstantsPath", "finderCoverImagePath", "getFinderCoverImagePath", "finderImgPath", "getFinderImgPath", "finderLivePath", "getFinderLivePath", "finderPostPath", "getFinderPostPath", "finderPostingPath", "getFinderPostingPath", "finderTmpPath", "getFinderTmpPath", "finderVideoPath", "getFinderVideoPath", "folderArray", "", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "getFolderArray", "()[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "checkToCreateDir", "", "path", "noMedia", "", "cleanFile", "dumpCacheDir", "genPostVideoTmpPath", "username", "getAvatarFilePath", "avatar", "Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "getAvatarFileTmpPath", "getBgmExoTempPath", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getBgmTempPath", "getBgmUniqueValue", "finderMediaType", "mediaId", "mediaUrl", "getCaptureFilePath", "getConstantsDataPath", "getConstantsPath", "getCoverImageFilePath", "cover", "Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "getExifRotatedFilePath", "origFilePath", "getFeedAudioTackPath", "feedId", "getImageFilePath", "image", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "getImageFileTmpPath", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getLiveDecorationPagPath", "pagFile", "Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "getLiveGiftPagPath", "getMyFinderAvatarTempPath", "getNormalFileTmpPath", "getNormalJpegTmpPath", "getPostImagePath", "suffix", "getPostImageThumbPath", "imagePath", "getPostMediaDir", "getPostMediaTmpDir", "getPostMediaTmpPath", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getPostPath", "fileName", "getPostTemplateScyDir", "getPostVideoCoverPath", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "getPostVideoHalfThumbPath", "videoPath", "getPostVideoPath", "getPostVideoThumbPath", "getPostingVideoFilePath", "getTmpTextImagePath", "getUniqueValue", "getUrlImageFilePath", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "getUrlImageTmpPath", "getVideoCoverFilePath", "getVideoFilePath", "getVideoFileTmpPath", "inPostDir", "makeImageFilePath", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bm
{
  public static final bm GlZ;
  private static String Gma;
  private static final String Gmb;
  private static final String Gmc;
  private static final String Gmd;
  private static final String Gme;
  private static final String Gmf;
  private static final String Gmg;
  private static final String Gmh;
  private static final String Gmi;
  private static final String Gmj;
  private static final String Gmk;
  private static final String Gml;
  private static final String Gmm;
  public static final p[] Gmn;
  
  static
  {
    AppMethodBeat.i(167988);
    GlZ = new bm();
    Gma = "";
    Gmb = kotlin.g.b.s.X(h.baE().cachePath, "finder/");
    Gmc = kotlin.g.b.s.X(fih(), "image/");
    Gmd = kotlin.g.b.s.X(fih(), "avatar/");
    Gme = kotlin.g.b.s.X(fih(), "cover/");
    Gmf = kotlin.g.b.s.X(fih(), "video/");
    Gmg = kotlin.g.b.s.X(fih(), "tmp/");
    Gmh = kotlin.g.b.s.X(fih(), "capture/");
    Gmi = kotlin.g.b.s.X(fih(), "post/");
    Gmj = kotlin.g.b.s.X(h.baE().cachePath, "finderposting/");
    Gmk = kotlin.g.b.s.X(fih(), "constants/");
    Gml = kotlin.g.b.s.X(Gmb, "constants/");
    Gmm = kotlin.g.b.s.X(Gmb, "live/");
    p[] arrayOfp = new p[11];
    arrayOfp[0] = new p(fih(), "finderAccPath", 0L, true, false);
    arrayOfp[1] = new p(Gmi, "finderPostPath", 0L, true, false);
    arrayOfp[2] = new p(Gmk, "finderConstantsPath", 0L, true, false);
    String str = Gmc;
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    long l = com.tencent.mm.plugin.finder.storage.d.eQL();
    locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eQS().bmg()).intValue() == 0)
    {
      bool = true;
      arrayOfp[3] = new p(str, "finderImgPath", l, bool, 8);
      str = Gmd;
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      l = com.tencent.mm.plugin.finder.storage.d.eQM();
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eQS().bmg()).intValue() != 0) {
        break label647;
      }
      bool = true;
      label313:
      arrayOfp[4] = new p(str, "finderAvatarPath", l, bool, 8);
      str = Gme;
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      l = com.tencent.mm.plugin.finder.storage.d.eQN();
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eQS().bmg()).intValue() != 0) {
        break label652;
      }
      bool = true;
      label369:
      arrayOfp[5] = new p(str, "finderCoverImagePath", l, bool, 8);
      str = Gmf;
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      l = com.tencent.mm.plugin.finder.storage.d.eQO();
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eQS().bmg()).intValue() != 0) {
        break label657;
      }
      bool = true;
      label425:
      arrayOfp[6] = new p(str, "finderVideoPath", l, bool, 8);
      str = Gmg;
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      l = com.tencent.mm.plugin.finder.storage.d.eQP();
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eQS().bmg()).intValue() != 0) {
        break label662;
      }
      bool = true;
      label482:
      arrayOfp[7] = new p(str, "finderTmpPath", l, bool, 8);
      str = Gmh;
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      l = com.tencent.mm.plugin.finder.storage.d.eQQ();
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eQS().bmg()).intValue() != 0) {
        break label667;
      }
    }
    label647:
    label652:
    label657:
    label662:
    label667:
    for (boolean bool = true;; bool = false)
    {
      arrayOfp[8] = new p(str, "finderCapturePath", l, bool, 8);
      arrayOfp[9] = new p(fiu(), "finderPostMediaDir", 0L, false, 8);
      str = fit();
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      arrayOfp[10] = new p(str, "finderPostMediaTmpDir", com.tencent.mm.plugin.finder.storage.d.eQR(), false, 24);
      Gmn = arrayOfp;
      int i = 0;
      while (i < 11)
      {
        arrayOfp[i].feO();
        i += 1;
      }
      bool = false;
      break;
      bool = false;
      break label313;
      bool = false;
      break label369;
      bool = false;
      break label425;
      bool = false;
      break label482;
    }
    Log.i("Finder.Loader", "finderAccPath:" + fih() + " finderImgPath:" + Gmc + " finderVideoPath:" + Gmf + " finderCapturePath:" + Gmh);
    AppMethodBeat.o(167988);
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.b paramb)
  {
    AppMethodBeat.i(167979);
    kotlin.g.b.s.u(paramb, "avatar");
    paramb = kotlin.g.b.s.X(Gmd, paramb.Exa);
    AppMethodBeat.o(167979);
    return paramb;
  }
  
  public static String a(i parami)
  {
    AppMethodBeat.i(167980);
    kotlin.g.b.s.u(parami, "cover");
    parami = kotlin.g.b.s.X(Gme, parami.Exa);
    AppMethodBeat.o(167980);
    return parami;
  }
  
  public static String a(n paramn)
  {
    AppMethodBeat.i(333275);
    kotlin.g.b.s.u(paramn, "image");
    paramn = kotlin.g.b.s.X(Gmc, paramn.aUt());
    AppMethodBeat.o(333275);
    return paramn;
  }
  
  public static String a(n paramn, String paramString)
  {
    AppMethodBeat.i(333402);
    kotlin.g.b.s.u(paramn, "image");
    kotlin.g.b.s.u(paramString, "suffix");
    paramn = fiu() + paramn.aUt() + '_' + paramString;
    AppMethodBeat.o(333402);
    return paramn;
  }
  
  public static String a(o paramo)
  {
    AppMethodBeat.i(333321);
    kotlin.g.b.s.u(paramo, "pagFile");
    paramo = Gmm + paramo.aUt() + ".pag";
    AppMethodBeat.o(333321);
    return paramo;
  }
  
  public static String a(r paramr)
  {
    AppMethodBeat.i(167977);
    kotlin.g.b.s.u(paramr, "image");
    paramr = kotlin.g.b.s.X(Gmg, paramr.aUt());
    AppMethodBeat.o(167977);
    return paramr;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.s params)
  {
    AppMethodBeat.i(167975);
    kotlin.g.b.s.u(params, "image");
    params = kotlin.g.b.s.X(Gmc, params.aUt());
    AppMethodBeat.o(167975);
    return params;
  }
  
  public static String a(t paramt)
  {
    AppMethodBeat.i(333285);
    kotlin.g.b.s.u(paramt, "image");
    paramt = kotlin.g.b.s.X(Gmc, paramt.aUt());
    AppMethodBeat.o(333285);
    return paramt;
  }
  
  public static String a(t paramt, String paramString)
  {
    AppMethodBeat.i(333404);
    kotlin.g.b.s.u(paramt, "image");
    kotlin.g.b.s.u(paramString, "suffix");
    paramt = fiu() + paramt.aUt() + '_' + paramString;
    AppMethodBeat.o(333404);
    return paramt;
  }
  
  public static String a(v paramv)
  {
    AppMethodBeat.i(333231);
    kotlin.g.b.s.u(paramv, "video");
    paramv = kotlin.g.b.s.X(Gmf, paramv.aUt());
    AppMethodBeat.o(333231);
    return paramv;
  }
  
  public static String a(v paramv, String paramString)
  {
    AppMethodBeat.i(333365);
    kotlin.g.b.s.u(paramv, "video");
    kotlin.g.b.s.u(paramString, "suffix");
    paramv = fiu() + paramv.aUt() + '_' + paramString;
    AppMethodBeat.o(333365);
    return paramv;
  }
  
  public static String aCf(String paramString)
  {
    AppMethodBeat.i(167982);
    kotlin.g.b.s.u(paramString, "origFilePath");
    paramString = Gmg + MD5Util.getMD5String(paramString) + '_' + y.bEm(paramString) + "_rotated";
    AppMethodBeat.o(167982);
    return paramString;
  }
  
  public static String aCg(String paramString)
  {
    AppMethodBeat.i(333355);
    kotlin.g.b.s.u(paramString, "feedId");
    paramString = kotlin.g.b.s.X(Gmg, paramString);
    AppMethodBeat.o(333355);
    return paramString;
  }
  
  public static String aCh(String paramString)
  {
    AppMethodBeat.i(333370);
    kotlin.g.b.s.u(paramString, "fileName");
    paramString = kotlin.g.b.s.X(fiu(), paramString);
    AppMethodBeat.o(333370);
    return paramString;
  }
  
  public static String aCi(String paramString)
  {
    AppMethodBeat.i(167984);
    kotlin.g.b.s.u(paramString, "videoPath");
    paramString = fiu() + "video_" + MD5Util.getMD5String(paramString) + '_' + y.bEm(paramString) + "_thumb";
    AppMethodBeat.o(167984);
    return paramString;
  }
  
  public static String aCj(String paramString)
  {
    AppMethodBeat.i(333396);
    kotlin.g.b.s.u(paramString, "videoPath");
    paramString = fiu() + "video_" + MD5Util.getMD5String(paramString) + '_' + y.bEm(paramString) + "_half_thumb";
    AppMethodBeat.o(333396);
    return paramString;
  }
  
  public static String ap(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(333240);
    paramString1 = kotlin.g.b.s.X(Gmf, aq(paramString1, paramString2, paramString3));
    AppMethodBeat.o(333240);
    return paramString1;
  }
  
  public static String aq(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(333248);
    StringBuilder localStringBuilder = new StringBuilder("finder_video_").append(paramString1).append('_');
    paramString1 = paramString2;
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      paramString1 = MD5Util.getMD5String(paramString1);
    }
    paramString1 = paramString1;
    AppMethodBeat.o(333248);
    return paramString1;
  }
  
  public static String ar(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(333257);
    StringBuilder localStringBuilder = new StringBuilder("finder_audio_").append(paramString1).append('_');
    paramString1 = paramString2;
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      paramString1 = MD5Util.getMD5String(paramString1);
    }
    paramString1 = paramString1;
    AppMethodBeat.o(333257);
    return paramString1;
  }
  
  public static String b(o paramo)
  {
    AppMethodBeat.i(333329);
    kotlin.g.b.s.u(paramo, "pagFile");
    paramo = Gmm + "decoration/" + paramo.aUt() + ".pag";
    AppMethodBeat.o(333329);
    return paramo;
  }
  
  public static String b(bqj parambqj)
  {
    AppMethodBeat.i(333342);
    kotlin.g.b.s.u(parambqj, "musicInfo");
    parambqj = kotlin.g.b.s.X(Gmg, parambqj.HsD);
    AppMethodBeat.o(333342);
    return parambqj;
  }
  
  public static String bUk()
  {
    AppMethodBeat.i(333315);
    String str = Gmg + System.nanoTime() + ".jpg";
    AppMethodBeat.o(333315);
    return str;
  }
  
  public static String c(bqj parambqj)
  {
    AppMethodBeat.i(333350);
    kotlin.g.b.s.u(parambqj, "musicInfo");
    parambqj = Gmg + "/exo/" + parambqj.HsD;
    AppMethodBeat.o(333350);
    return parambqj;
  }
  
  public static String fih()
  {
    AppMethodBeat.i(333171);
    String str = kotlin.g.b.s.X(h.baE().mCJ, "finder/");
    AppMethodBeat.o(333171);
    return str;
  }
  
  public static String fii()
  {
    return Gmc;
  }
  
  public static String fij()
  {
    return Gmd;
  }
  
  public static String fik()
  {
    return Gmf;
  }
  
  public static String fil()
  {
    return Gmg;
  }
  
  public static String fim()
  {
    return Gmm;
  }
  
  public static p[] fin()
  {
    return Gmn;
  }
  
  public static void fio()
  {
    int j = 0;
    AppMethodBeat.i(333222);
    p[] arrayOfp = Gmn;
    int k = arrayOfp.length;
    int i = 0;
    while (i < k)
    {
      y.ew(arrayOfp[i].path, true);
      i += 1;
    }
    arrayOfp = Gmn;
    k = arrayOfp.length;
    i = j;
    while (i < k)
    {
      arrayOfp[i].feO();
      i += 1;
    }
    Log.i("Finder.Loader", "cleanFile finderAccPath:" + fih() + " finderImgPath:" + Gmc + " finderVideoPath:" + Gmf + " finderCapturePath:" + Gmh);
    AppMethodBeat.o(333222);
  }
  
  public static String fip()
  {
    AppMethodBeat.i(167978);
    Object localObject1 = Gmh;
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167978);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    kotlin.g.b.s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = kotlin.g.b.s.X((String)localObject1, g.getMessageDigest((byte[])localObject2));
    AppMethodBeat.o(167978);
    return localObject1;
  }
  
  public static String fiq()
  {
    return Gmk;
  }
  
  public static String fir()
  {
    return Gml;
  }
  
  public static String fis()
  {
    AppMethodBeat.i(333413);
    String str = kotlin.g.b.s.X(fiu(), "templateScy/");
    y.bDX(str);
    AppMethodBeat.o(333413);
    return str;
  }
  
  public static String fit()
  {
    AppMethodBeat.i(167985);
    String str = kotlin.g.b.s.X(Gmj, "media_tmp/");
    AppMethodBeat.o(167985);
    return str;
  }
  
  public static String fiu()
  {
    AppMethodBeat.i(167986);
    String str = kotlin.g.b.s.X(Gmj, "posting/");
    AppMethodBeat.o(167986);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bm
 * JD-Core Version:    0.7.0.1
 */