package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.q;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import kotlin.n.d;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/PathRouter;", "", "()V", "finderAccDataPath", "", "finderAccPath", "getFinderAccPath", "()Ljava/lang/String;", "finderAvatarPath", "getFinderAvatarPath", "finderCapturePath", "getFinderCapturePath", "finderConstantsDataPath", "getFinderConstantsDataPath", "finderConstantsPath", "getFinderConstantsPath", "finderCoverImagePath", "getFinderCoverImagePath", "finderImgPath", "getFinderImgPath", "finderLivePath", "getFinderLivePath", "finderPostPath", "getFinderPostPath", "finderTmpPath", "getFinderTmpPath", "finderVideoPath", "getFinderVideoPath", "folderArray", "", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "getFolderArray", "()[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "checkToCreateDir", "", "path", "noMedia", "", "cleanFile", "dumpCacheDir", "genPostVideoTmpPath", "username", "getAvatarFilePath", "avatar", "Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "getAvatarFileTmpPath", "getBgmExoTempPath", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getBgmTempPath", "getCaptureFilePath", "getConstantsDataPath", "getConstantsPath", "getCoverImageFilePath", "cover", "Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "getExifRotatedFilePath", "origFilePath", "getFeedAudioTackPath", "feedId", "getImageFilePath", "image", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "getImageFileTmpPath", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getLiveGiftPagPath", "pagFile", "Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "getMyFinderAvatarTempPath", "getNormalFileTmpPath", "getNormalJpegTmpPath", "getPostImagePath", "suffix", "getPostImageThumbPath", "imagePath", "getPostMediaDir", "getPostMediaTmpDir", "getPostMediaTmpPath", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getPostPath", "fileName", "getPostVideoCoverPath", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "getPostVideoHalfThumbPath", "videoPath", "getPostVideoPath", "getPostVideoThumbPath", "getTmpTextImagePath", "getUniqueValue", "finderMediaType", "mediaId", "mediaUrl", "getUrlImageFilePath", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "getUrlImageTmpPath", "getVideoCoverFilePath", "getVideoFilePath", "getVideoFileTmpPath", "inPostDir", "makeImageFilePath", "plugin-finder_release"})
public final class al
{
  private static final String waA;
  public static final i[] waB;
  public static final al waC;
  private static String wap;
  private static final String waq;
  public static final String war;
  private static final String was;
  private static final String wat;
  public static final String wau;
  private static final String wav;
  public static final String waw;
  private static final String wax;
  private static final String way;
  private static final String waz;
  
  static
  {
    AppMethodBeat.i(167988);
    waC = new al();
    wap = "";
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject2, "MMKernel.storage()");
    waq = ((e)localObject2).azM() + "finder/";
    war = dEx() + "image/";
    was = dEx() + "avatar/";
    wat = dEx() + "cover/";
    wau = dEx() + "video/";
    wav = dEx() + "tmp/";
    waw = dEx() + "capture/";
    wax = dEx() + "post/";
    way = dEx() + "constants/";
    waz = waq + "constants/";
    waA = waq + "live/";
    localObject1 = new i[11];
    localObject1[0] = new i(dEx(), "finderAccPath", 0L, true, false);
    localObject1[1] = new i(wax, "finderPostPath", 0L, true, false);
    localObject1[2] = new i(way, "finderConstantsPath", 0L, true, false);
    localObject2 = war;
    c localc = c.vCb;
    localObject1[3] = new i((String)localObject2, "finderImgPath", c.drj(), false, 24);
    localObject2 = was;
    localc = c.vCb;
    localObject1[4] = new i((String)localObject2, "finderAvatarPath", c.drk(), false, 24);
    localObject2 = wat;
    localc = c.vCb;
    localObject1[5] = new i((String)localObject2, "finderCoverImagePath", c.drl(), false, 24);
    localObject2 = wau;
    localc = c.vCb;
    localObject1[6] = new i((String)localObject2, "finderVideoPath", c.drm(), false, 24);
    localObject2 = wav;
    localc = c.vCb;
    localObject1[7] = new i((String)localObject2, "finderTmpPath", c.drn(), false, 24);
    localObject2 = waw;
    localc = c.vCb;
    localObject1[8] = new i((String)localObject2, "finderCapturePath", c.dro(), false, 24);
    localObject1[9] = new i(dEH(), "finderPostMediaDir", 0L, false, 8);
    localObject2 = dEG();
    localc = c.vCb;
    localObject1[10] = new i((String)localObject2, "finderPostMediaTmpDir", c.drp(), false, 24);
    waB = (i[])localObject1;
    int i = 0;
    while (i < 11)
    {
      localObject1[i].dBE();
      i += 1;
    }
    Log.i("Finder.Loader", "finderAccPath:" + dEx() + " finderImgPath:" + war + " finderVideoPath:" + wau + " finderCapturePath:" + waw);
    AppMethodBeat.o(167988);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(167979);
    kotlin.g.b.p.h(parama, "avatar");
    parama = was + parama.uId;
    AppMethodBeat.o(167979);
    return parama;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.g paramg)
  {
    AppMethodBeat.i(167980);
    kotlin.g.b.p.h(paramg, "cover");
    paramg = wat + paramg.uId;
    AppMethodBeat.o(167980);
    return paramg;
  }
  
  public static String a(k paramk)
  {
    AppMethodBeat.i(253808);
    kotlin.g.b.p.h(paramk, "image");
    paramk = war + paramk.auA();
    AppMethodBeat.o(253808);
    return paramk;
  }
  
  public static String a(k paramk, String paramString)
  {
    AppMethodBeat.i(253818);
    kotlin.g.b.p.h(paramk, "image");
    kotlin.g.b.p.h(paramString, "suffix");
    paramk = dEH() + paramk.auA() + "_" + paramString;
    AppMethodBeat.o(253818);
    return paramk;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(253811);
    kotlin.g.b.p.h(paraml, "pagFile");
    paraml = waA + paraml.auA() + ".pag";
    AppMethodBeat.o(253811);
    return paraml;
  }
  
  public static String a(o paramo)
  {
    AppMethodBeat.i(167977);
    kotlin.g.b.p.h(paramo, "image");
    paramo = wav + paramo.auA();
    AppMethodBeat.o(167977);
    return paramo;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.p paramp)
  {
    AppMethodBeat.i(167975);
    kotlin.g.b.p.h(paramp, "image");
    paramp = war + paramp.auA();
    AppMethodBeat.o(167975);
    return paramp;
  }
  
  public static String a(q paramq)
  {
    AppMethodBeat.i(253809);
    kotlin.g.b.p.h(paramq, "image");
    paramq = war + paramq.auA();
    AppMethodBeat.o(253809);
    return paramq;
  }
  
  public static String a(q paramq, String paramString)
  {
    AppMethodBeat.i(253819);
    kotlin.g.b.p.h(paramq, "image");
    kotlin.g.b.p.h(paramString, "suffix");
    paramq = dEH() + paramq.auA() + "_" + paramString;
    AppMethodBeat.o(253819);
    return paramq;
  }
  
  public static String a(com.tencent.mm.plugin.finder.loader.s params, String paramString)
  {
    AppMethodBeat.i(253815);
    kotlin.g.b.p.h(params, "video");
    kotlin.g.b.p.h(paramString, "suffix");
    params = dEH() + params.auA() + "_" + paramString;
    AppMethodBeat.o(253815);
    return params;
  }
  
  public static String am(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(253806);
    paramString1 = wau + an(paramString1, paramString2, paramString3);
    AppMethodBeat.o(253806);
    return paramString1;
  }
  
  public static String an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(253807);
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
    AppMethodBeat.o(253807);
    return paramString1;
  }
  
  public static String awA(String paramString)
  {
    AppMethodBeat.i(167982);
    kotlin.g.b.p.h(paramString, "origFilePath");
    paramString = wav + MD5Util.getMD5String(paramString).toString() + "_" + com.tencent.mm.vfs.s.boX(paramString) + "_rotated";
    AppMethodBeat.o(167982);
    return paramString;
  }
  
  public static String awB(String paramString)
  {
    AppMethodBeat.i(253814);
    kotlin.g.b.p.h(paramString, "feedId");
    paramString = wax + paramString;
    AppMethodBeat.o(253814);
    return paramString;
  }
  
  public static String awC(String paramString)
  {
    AppMethodBeat.i(253816);
    kotlin.g.b.p.h(paramString, "fileName");
    paramString = dEH() + paramString;
    AppMethodBeat.o(253816);
    return paramString;
  }
  
  public static String awD(String paramString)
  {
    AppMethodBeat.i(167984);
    kotlin.g.b.p.h(paramString, "videoPath");
    paramString = dEH() + "video_" + MD5Util.getMD5String(paramString) + "_" + com.tencent.mm.vfs.s.boX(paramString) + "_thumb";
    AppMethodBeat.o(167984);
    return paramString;
  }
  
  public static String awE(String paramString)
  {
    AppMethodBeat.i(253817);
    kotlin.g.b.p.h(paramString, "videoPath");
    paramString = dEH() + "video_" + MD5Util.getMD5String(paramString) + "_" + com.tencent.mm.vfs.s.boX(paramString) + "_half_thumb";
    AppMethodBeat.o(253817);
    return paramString;
  }
  
  public static String b(azk paramazk)
  {
    AppMethodBeat.i(253812);
    kotlin.g.b.p.h(paramazk, "musicInfo");
    paramazk = wav + paramazk.wWb;
    AppMethodBeat.o(253812);
    return paramazk;
  }
  
  public static String c(com.tencent.mm.plugin.finder.loader.s params)
  {
    AppMethodBeat.i(253805);
    kotlin.g.b.p.h(params, "video");
    params = wau + params.auA();
    AppMethodBeat.o(253805);
    return params;
  }
  
  public static String c(azk paramazk)
  {
    AppMethodBeat.i(253813);
    kotlin.g.b.p.h(paramazk, "musicInfo");
    paramazk = wav + "/exo/" + paramazk.wWb;
    AppMethodBeat.o(253813);
    return paramazk;
  }
  
  public static String dEA()
  {
    return wav;
  }
  
  public static i[] dEB()
  {
    return waB;
  }
  
  public static String dEC()
  {
    AppMethodBeat.i(167978);
    Object localObject1 = new StringBuilder().append(waw);
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167978);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    kotlin.g.b.p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject2);
    AppMethodBeat.o(167978);
    return localObject1;
  }
  
  public static String dED()
  {
    AppMethodBeat.i(253810);
    String str = wav + System.nanoTime() + ".jpg";
    AppMethodBeat.o(253810);
    return str;
  }
  
  public static String dEE()
  {
    return way;
  }
  
  public static String dEF()
  {
    return waz;
  }
  
  public static String dEG()
  {
    AppMethodBeat.i(167985);
    String str = wax + "media_tmp/";
    AppMethodBeat.o(167985);
    return str;
  }
  
  public static String dEH()
  {
    AppMethodBeat.i(167986);
    String str = wax + "posting/";
    AppMethodBeat.o(167986);
    return str;
  }
  
  public static String dEx()
  {
    AppMethodBeat.i(253804);
    Object localObject = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    localObject = locale.getAccPath() + "finder/";
    AppMethodBeat.o(253804);
    return localObject;
  }
  
  public static String dEy()
  {
    return war;
  }
  
  public static String dEz()
  {
    return wau;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.al
 * JD-Core Version:    0.7.0.1
 */