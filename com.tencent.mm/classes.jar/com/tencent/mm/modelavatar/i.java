package com.tencent.mm.modelavatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelavatar/HeadImageUploader;", "", "imgPath", "", "iImgUploadCallback", "Lcom/tencent/mm/modelavatar/HeadImageUploader$IImgUploadCallback;", "(Ljava/lang/String;Lcom/tencent/mm/modelavatar/HeadImageUploader$IImgUploadCallback;)V", "cdnCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "mediaId", "st_new", "", "checkStringValid", "str", "genClientId", "prefix", "createTime", "suffix", "startUpload", "", "Companion", "IImgUploadCallback", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a osE;
  private static int osI;
  private final String hQn;
  private final String mediaId;
  private final b osF;
  private long osG;
  private final g.a osH;
  
  static
  {
    AppMethodBeat.i(231346);
    osE = new i.a((byte)0);
    osI = a.MediaType_FILE;
    AppMethodBeat.o(231346);
  }
  
  public i(String paramString, b paramb)
  {
    AppMethodBeat.i(231338);
    this.osH = ((g.a)new c(paramb, this));
    this.osG = System.currentTimeMillis();
    this.hQn = paramString;
    this.osF = paramb;
    paramb = new Random();
    long l = Util.nowMilliSecond();
    String str = String.valueOf(paramb.nextInt());
    s.u("kidsupload", "prefix");
    Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra genClientId prefix[%s] createtime:%d suffix:[%s] stack[%s]", new Object[] { "kidsupload", Long.valueOf(l), str, Util.getStack() });
    if (Util.isNullOrNil(LQ("kidsupload")))
    {
      Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "prefix is null");
      paramb = null;
    }
    for (;;)
    {
      Object localObject = paramb;
      if (paramb == null) {
        localObject = "";
      }
      this.mediaId = ((String)localObject);
      Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "KidsWatchHeadImageUploader imgPath:%s mediaId:%s", new Object[] { paramString, this.mediaId });
      AppMethodBeat.o(231338);
      return;
      if (l <= 0L)
      {
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "createTime <= 0");
        paramb = null;
      }
      else
      {
        paramb = this.hQn;
        localObject = kotlin.n.d.UTF_8;
        if (paramb == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(231338);
          throw paramString;
        }
        paramb = paramb.getBytes((Charset)localObject);
        s.s(paramb, "(this as java.lang.String).getBytes(charset)");
        localObject = com.tencent.mm.b.g.getMessageDigest(paramb);
        paramb = new StringBuilder("a").append("kidsupload").append('_');
        s.s(localObject, "md5");
        localObject = ((String)localObject).substring(0, 16);
        s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject = (String)localObject + '_' + l;
        paramb = (b)localObject;
        if (!Util.isNullOrNil(str)) {
          paramb = (String)localObject + '_' + str;
        }
        Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", s.X("clientid:", paramb));
      }
    }
  }
  
  private static String LQ(String paramString)
  {
    AppMethodBeat.i(231342);
    if (!Util.isNullOrNil(paramString))
    {
      s.checkNotNull(paramString);
      int i = 0;
      int k = paramString.length();
      while (i < k)
      {
        char c = paramString.charAt(i);
        int j = i + 1;
        i = j;
        if (!Util.isAlpha(c))
        {
          i = j;
          if (!Util.isNum(c))
          {
            AppMethodBeat.o(231342);
            return null;
          }
        }
      }
    }
    AppMethodBeat.o(231342);
    return paramString;
  }
  
  public final boolean bFu()
  {
    AppMethodBeat.i(231349);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_KidsWatchHeadImageUpload";
    localg.lwL = this.osH;
    localg.field_mediaId = this.mediaId;
    localg.field_fullpath = this.hQn;
    localg.field_thumbpath = "";
    localg.field_fileType = osI;
    localg.field_talker = "";
    localg.field_priority = a.lvZ;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 1;
    localg.field_bzScene = 0;
    localg.hyY = 5;
    localg.field_trysafecdn = true;
    localg.field_enable_hitcheck = false;
    if (!k.bHW().g(localg))
    {
      Log.e("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra addSendTask failed. mediaId:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(231349);
      return false;
    }
    AppMethodBeat.o(231349);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelavatar/HeadImageUploader$IImgUploadCallback;", "", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "fileID", "aesKey", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void LR(String paramString);
    
    public abstract void br(String paramString1, String paramString2);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/modelavatar/HeadImageUploader$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g.a
  {
    c(i.b paramb, i parami) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(231351);
      s.u(paramString, "mediaId");
      if (paramInt == -21005)
      {
        Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        AppMethodBeat.o(231351);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", s.X("cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], aesKey:", paramd.field_aesKey), new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        paramString = this.osJ;
        paramc = paramd.field_fileId;
        s.s(paramc, "sceneResult.field_fileId");
        String str = paramd.field_aesKey;
        s.s(str, "sceneResult.field_aesKey");
        paramString.br(paramc, str);
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "uploadsns cdndone pass: " + (System.currentTimeMillis() - i.a(jdField_this)) + ' ' + paramd.field_filemd5);
        AppMethodBeat.o(231351);
        return 0;
      }
      if ((paramd != null) && (paramd.field_retCode != 0))
      {
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        this.osJ.LR("doScene failed");
        AppMethodBeat.o(231351);
        return 0;
      }
      if (paramInt != 0)
      {
        Log.i("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        this.osJ.LR("doScene failed");
        AppMethodBeat.o(231351);
        return 0;
      }
      Log.d("MicroMsg.KidsWatch.KidsWatchHeadImageUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(231351);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(231354);
      s.u(paramString, "mediaId");
      s.u(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(231354);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(231356);
      s.u(paramString, "mediaId");
      s.u(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(231356);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.i
 * JD-Core Version:    0.7.0.1
 */