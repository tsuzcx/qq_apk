package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.f.b.a.ac;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader;", "", "imgPath", "", "iImgUploadCallback", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;)V", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "mediaId", "st_new", "", "checkStringValid", "str", "genClientId", "prefix", "createTime", "suffix", "startUpload", "", "Companion", "IImgUploadCallback", "plugin-kidswatch_release"})
public final class b
{
  public static final b.a EbR;
  public static int mJz;
  private final b EbQ;
  public final String fKH;
  public final g.a lPx;
  private long mJB;
  public final String mediaId;
  
  static
  {
    AppMethodBeat.i(251454);
    EbR = new b.a((byte)0);
    mJz = com.tencent.mm.i.a.MediaType_FILE;
    AppMethodBeat.o(251454);
  }
  
  public b(String paramString, final b paramb)
  {
    AppMethodBeat.i(251451);
    this.lPx = ((g.a)new c(this, paramb));
    this.mJB = System.currentTimeMillis();
    this.fKH = paramString;
    this.EbQ = paramb;
    paramb = new Random();
    String str = g("kidsupload", Util.nowMilliSecond(), String.valueOf(paramb.nextInt()));
    paramb = str;
    if (str == null) {
      paramb = "";
    }
    this.mediaId = paramb;
    Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "KidsWatchHeadImageUploader imgPath:%s mediaId:%s", new Object[] { paramString, this.mediaId });
    AppMethodBeat.o(251451);
  }
  
  private String g(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(251450);
    p.k(paramString1, "prefix");
    Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra genClientId prefix[%s] createtime:%d suffix:[%s] stack[%s]", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, Util.getStack() });
    int i;
    if (!Util.isNullOrNil(paramString1))
    {
      int j = paramString1.length();
      i = 0;
      if (i < j)
      {
        char c = paramString1.charAt(i);
        if ((Util.isAlpha(c)) || (Util.isNum(c))) {}
      }
    }
    for (Object localObject = null;; localObject = paramString1)
    {
      if (!Util.isNullOrNil((String)localObject)) {
        break label131;
      }
      Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "prefix is null");
      AppMethodBeat.o(251450);
      return null;
      i += 1;
      break;
    }
    label131:
    if (paramLong <= 0L)
    {
      Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "createTime <= 0");
      AppMethodBeat.o(251450);
      return null;
    }
    localObject = this.fKH;
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(251450);
      throw paramString1;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.j(localObject, "(this as java.lang.String).getBytes(charset)");
    localObject = g.getMessageDigest((byte[])localObject);
    paramString1 = new StringBuilder("a").append(paramString1).append("_");
    p.j(localObject, "md5");
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(251450);
      throw paramString1;
    }
    localObject = ((String)localObject).substring(0, 16);
    p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject = (String)localObject + "_" + paramLong;
    paramString1 = (String)localObject;
    if (!Util.isNullOrNil(paramString2)) {
      paramString1 = (String)localObject + '_' + paramString2;
    }
    Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "clientid:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(251450);
    return paramString1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$IImgUploadCallback;", "", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "fileID", "aesKey", "plugin-kidswatch_release"})
  public static abstract interface b
  {
    public abstract void R(String paramString1, String paramString2);
    
    public abstract void aMM(String paramString);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/kidswatch/model/KidsWatchHeadImageUploader$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-kidswatch_release"})
  public static final class c
    implements g.a
  {
    c(b.b paramb) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(251831);
      p.k(paramString, "mediaId");
      if (paramInt == -21005)
      {
        Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        AppMethodBeat.o(251831);
        return 0;
      }
      long l1;
      long l2;
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], aesKey:" + paramd.field_aesKey, new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        paramString = paramb;
        paramc = paramd.field_fileId;
        p.j(paramc, "sceneResult.field_fileId");
        String str = paramd.field_aesKey;
        p.j(str, "sceneResult.field_aesKey");
        paramString.R(paramc, str);
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "uploadsns cdndone pass: " + (System.currentTimeMillis() - b.a(this.EbS)) + " " + paramd.field_filemd5);
        l1 = b.a(this.EbS);
        l2 = Util.nowMilliSecond();
        paramInt = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
        paramString = b.EbR;
        new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramInt), Integer.valueOf(b.eKR()), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.iUs })).bpa();
        AppMethodBeat.o(251831);
        return 0;
      }
      int i;
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        paramInt = paramd.field_retCode;
        l1 = b.a(this.EbS);
        l2 = Util.nowMilliSecond();
        i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
        paramString = b.EbR;
        paramString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(b.eKR()), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.iUs });
        new ae(paramString).bpa();
        new ac(paramString).bpa();
        paramb.aMM("doScene failed");
        AppMethodBeat.o(251831);
        return 0;
      }
      if (paramInt != 0)
      {
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        if (paramd != null)
        {
          l1 = b.a(this.EbS);
          l2 = Util.nowMilliSecond();
          i = com.tencent.mm.aq.c.cV(MMApplicationContext.getContext());
          paramString = b.EbR;
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(b.eKR()), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.iUs })).bpa();
        }
        paramb.aMM("doScene failed");
        AppMethodBeat.o(251831);
        return 0;
      }
      Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(251831);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(251834);
      p.k(paramString, "mediaId");
      p.k(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(251834);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(251835);
      p.k(paramString, "mediaId");
      p.k(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(251835);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.b
 * JD-Core Version:    0.7.0.1
 */