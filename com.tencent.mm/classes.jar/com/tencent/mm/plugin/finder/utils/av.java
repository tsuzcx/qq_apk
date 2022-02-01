package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.loader.y;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/PathRouter;", "", "()V", "finderAccDataPath", "", "finderAccPath", "getFinderAccPath", "()Ljava/lang/String;", "finderAvatarPath", "getFinderAvatarPath", "finderCapturePath", "getFinderCapturePath", "finderConstantsDataPath", "getFinderConstantsDataPath", "finderConstantsPath", "getFinderConstantsPath", "finderCoverImagePath", "getFinderCoverImagePath", "finderImgPath", "getFinderImgPath", "finderLivePath", "getFinderLivePath", "finderPostPath", "getFinderPostPath", "finderPostingPath", "getFinderPostingPath", "finderTmpPath", "getFinderTmpPath", "finderVideoPath", "getFinderVideoPath", "folderArray", "", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "getFolderArray", "()[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "checkToCreateDir", "", "path", "noMedia", "", "cleanFile", "dumpCacheDir", "genPostVideoTmpPath", "username", "getAvatarFilePath", "avatar", "Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "getAvatarFileTmpPath", "getBgmExoTempPath", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getBgmTempPath", "getCaptureFilePath", "getConstantsDataPath", "getConstantsPath", "getCoverImageFilePath", "cover", "Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "getExifRotatedFilePath", "origFilePath", "getFeedAudioTackPath", "feedId", "getImageFilePath", "image", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "getImageFileTmpPath", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getLiveGiftPagPath", "pagFile", "Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "getMyFinderAvatarTempPath", "getNormalFileTmpPath", "getNormalJpegTmpPath", "getPostImagePath", "suffix", "getPostImageThumbPath", "imagePath", "getPostMediaDir", "getPostMediaTmpDir", "getPostMediaTmpPath", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getPostPath", "fileName", "getPostVideoCoverPath", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "getPostVideoHalfThumbPath", "videoPath", "getPostVideoPath", "getPostVideoThumbPath", "getPostingVideoFilePath", "finderMediaType", "mediaId", "mediaUrl", "getTmpTextImagePath", "getUniqueValue", "getUrlImageFilePath", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "getUrlImageTmpPath", "getVideoCoverFilePath", "getVideoFilePath", "getVideoFileTmpPath", "inPostDir", "makeImageFilePath", "plugin-finder_release"})
public final class av
{
  private static String AJl;
  private static final String AJm;
  public static final String AJn;
  private static final String AJo;
  private static final String AJp;
  public static final String AJq;
  private static final String AJr;
  public static final String AJs;
  private static final String AJt;
  private static final String AJu;
  private static final String AJv;
  private static final String AJw;
  private static final String AJx;
  public static final k[] AJy;
  public static final av AJz;
  
  static
  {
    AppMethodBeat.i(167988);
    AJz = new av();
    AJl = "";
    Object localObject1 = new StringBuilder();
    Object localObject2 = h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    AJm = ((f)localObject2).aHl() + "finder/";
    AJn = egj() + "image/";
    AJo = egj() + "avatar/";
    AJp = egj() + "cover/";
    AJq = egj() + "video/";
    AJr = egj() + "tmp/";
    AJs = egj() + "capture/";
    AJt = egj() + "post/";
    localObject1 = new StringBuilder();
    localObject2 = h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    AJu = ((f)localObject2).aHl() + "finderposting/";
    AJv = egj() + "constants/";
    AJw = AJm + "constants/";
    AJx = AJm + "live/";
    localObject1 = new k[11];
    localObject1[0] = new k(egj(), "finderAccPath", 0L, true, false);
    localObject1[1] = new k(AJt, "finderPostPath", 0L, true, false);
    localObject1[2] = new k(AJv, "finderConstantsPath", 0L, true, false);
    localObject2 = AJn;
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    long l = com.tencent.mm.plugin.finder.storage.d.dSx();
    locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dSE().aSr()).intValue() == 0)
    {
      bool = true;
      localObject1[3] = new k((String)localObject2, "finderImgPath", l, bool, 8);
      localObject2 = AJo;
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      l = com.tencent.mm.plugin.finder.storage.d.dSy();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dSE().aSr()).intValue() != 0) {
        break label834;
      }
      bool = true;
      label500:
      localObject1[4] = new k((String)localObject2, "finderAvatarPath", l, bool, 8);
      localObject2 = AJp;
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      l = com.tencent.mm.plugin.finder.storage.d.dSz();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dSE().aSr()).intValue() != 0) {
        break label839;
      }
      bool = true;
      label556:
      localObject1[5] = new k((String)localObject2, "finderCoverImagePath", l, bool, 8);
      localObject2 = AJq;
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      l = com.tencent.mm.plugin.finder.storage.d.dSA();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dSE().aSr()).intValue() != 0) {
        break label844;
      }
      bool = true;
      label612:
      localObject1[6] = new k((String)localObject2, "finderVideoPath", l, bool, 8);
      localObject2 = AJr;
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      l = com.tencent.mm.plugin.finder.storage.d.dSB();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dSE().aSr()).intValue() != 0) {
        break label849;
      }
      bool = true;
      label669:
      localObject1[7] = new k((String)localObject2, "finderTmpPath", l, bool, 8);
      localObject2 = AJs;
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      l = com.tencent.mm.plugin.finder.storage.d.dSC();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dSE().aSr()).intValue() != 0) {
        break label854;
      }
    }
    label834:
    label839:
    label844:
    label849:
    label854:
    for (boolean bool = true;; bool = false)
    {
      localObject1[8] = new k((String)localObject2, "finderCapturePath", l, bool, 8);
      localObject1[9] = new k(egu(), "finderPostMediaDir", 0L, false, 8);
      localObject2 = egt();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      localObject1[10] = new k((String)localObject2, "finderPostMediaTmpDir", com.tencent.mm.plugin.finder.storage.d.dSD(), false, 24);
      AJy = (k[])localObject1;
      int i = 0;
      while (i < 11)
      {
        localObject1[i].ecR();
        i += 1;
      }
      bool = false;
      break;
      bool = false;
      break label500;
      bool = false;
      break label556;
      bool = false;
      break label612;
      bool = false;
      break label669;
    }
    Log.i("Finder.Loader", "finderAccPath:" + egj() + " finderImgPath:" + AJn + " finderVideoPath:" + AJq + " finderCapturePath:" + AJs);
    AppMethodBeat.o(167988);
  }
  
  public static String a(aa paramaa)
  {
    AppMethodBeat.i(272013);
    p.k(paramaa, "video");
    paramaa = AJq + paramaa.aBv();
    AppMethodBeat.o(272013);
    return paramaa;
  }
  
  public static String a(aa paramaa, String paramString)
  {
    AppMethodBeat.i(272022);
    p.k(paramaa, "video");
    p.k(paramString, "suffix");
    paramaa = egu() + paramaa.aBv() + "_" + paramString;
    AppMethodBeat.o(272022);
    return paramaa;
  }
  
  public static String a(e parame)
  {
    AppMethodBeat.i(167979);
    p.k(parame, "avatar");
    parame = AJo + parame.ztf;
    AppMethodBeat.o(167979);
    return parame;
  }
  
  public static String a(m paramm)
  {
    AppMethodBeat.i(167980);
    p.k(paramm, "cover");
    paramm = AJp + paramm.ztf;
    AppMethodBeat.o(167980);
    return paramm;
  }
  
  public static String a(r paramr)
  {
    AppMethodBeat.i(272015);
    p.k(paramr, "image");
    paramr = AJn + paramr.aBv();
    AppMethodBeat.o(272015);
    return paramr;
  }
  
  public static String a(r paramr, String paramString)
  {
    AppMethodBeat.i(272027);
    p.k(paramr, "image");
    p.k(paramString, "suffix");
    paramr = egu() + paramr.aBv() + "_" + paramString;
    AppMethodBeat.o(272027);
    return paramr;
  }
  
  public static String a(s params)
  {
    AppMethodBeat.i(272018);
    p.k(params, "pagFile");
    params = AJx + params.aBv() + ".pag";
    AppMethodBeat.o(272018);
    return params;
  }
  
  public static String a(w paramw)
  {
    AppMethodBeat.i(167977);
    p.k(paramw, "image");
    paramw = AJr + paramw.aBv();
    AppMethodBeat.o(167977);
    return paramw;
  }
  
  public static String a(x paramx)
  {
    AppMethodBeat.i(167975);
    p.k(paramx, "image");
    paramx = AJn + paramx.aBv();
    AppMethodBeat.o(167975);
    return paramx;
  }
  
  public static String a(y paramy)
  {
    AppMethodBeat.i(272016);
    p.k(paramy, "image");
    paramy = AJn + paramy.aBv();
    AppMethodBeat.o(272016);
    return paramy;
  }
  
  public static String aGc(String paramString)
  {
    AppMethodBeat.i(167982);
    p.k(paramString, "origFilePath");
    paramString = AJr + MD5Util.getMD5String(paramString).toString() + "_" + u.bBR(paramString) + "_rotated";
    AppMethodBeat.o(167982);
    return paramString;
  }
  
  public static String aGd(String paramString)
  {
    AppMethodBeat.i(272021);
    p.k(paramString, "feedId");
    paramString = AJr + paramString;
    AppMethodBeat.o(272021);
    return paramString;
  }
  
  public static String aGe(String paramString)
  {
    AppMethodBeat.i(272023);
    p.k(paramString, "fileName");
    paramString = egu() + paramString;
    AppMethodBeat.o(272023);
    return paramString;
  }
  
  public static String aGf(String paramString)
  {
    AppMethodBeat.i(167984);
    p.k(paramString, "videoPath");
    paramString = egu() + "video_" + MD5Util.getMD5String(paramString) + "_" + u.bBR(paramString) + "_thumb";
    AppMethodBeat.o(167984);
    return paramString;
  }
  
  public static String aGg(String paramString)
  {
    AppMethodBeat.i(272026);
    p.k(paramString, "videoPath");
    paramString = egu() + "video_" + MD5Util.getMD5String(paramString) + "_" + u.bBR(paramString) + "_half_thumb";
    AppMethodBeat.o(272026);
    return paramString;
  }
  
  public static String ai(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(272014);
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
    AppMethodBeat.o(272014);
    return paramString1;
  }
  
  public static String b(bfg parambfg)
  {
    AppMethodBeat.i(272019);
    p.k(parambfg, "musicInfo");
    parambfg = AJr + parambfg.BHW;
    AppMethodBeat.o(272019);
    return parambfg;
  }
  
  public static String c(bfg parambfg)
  {
    AppMethodBeat.i(272020);
    p.k(parambfg, "musicInfo");
    parambfg = AJr + "/exo/" + parambfg.BHW;
    AppMethodBeat.o(272020);
    return parambfg;
  }
  
  public static String egj()
  {
    AppMethodBeat.i(272012);
    Object localObject = new StringBuilder();
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localObject = localf.getAccPath() + "finder/";
    AppMethodBeat.o(272012);
    return localObject;
  }
  
  public static String egk()
  {
    return AJn;
  }
  
  public static String egl()
  {
    return AJo;
  }
  
  public static String egm()
  {
    return AJq;
  }
  
  public static String egn()
  {
    return AJr;
  }
  
  public static k[] ego()
  {
    return AJy;
  }
  
  public static String egp()
  {
    AppMethodBeat.i(167978);
    Object localObject1 = new StringBuilder().append(AJs);
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167978);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = g.getMessageDigest((byte[])localObject2);
    AppMethodBeat.o(167978);
    return localObject1;
  }
  
  public static String egq()
  {
    AppMethodBeat.i(272017);
    String str = AJr + System.nanoTime() + ".jpg";
    AppMethodBeat.o(272017);
    return str;
  }
  
  public static String egr()
  {
    return AJv;
  }
  
  public static String egs()
  {
    return AJw;
  }
  
  public static String egt()
  {
    AppMethodBeat.i(167985);
    String str = AJu + "media_tmp/";
    AppMethodBeat.o(167985);
    return str;
  }
  
  public static String egu()
  {
    AppMethodBeat.i(167986);
    String str = AJu + "posting/";
    AppMethodBeat.o(167986);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.av
 * JD-Core Version:    0.7.0.1
 */