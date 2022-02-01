package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1;", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "createCdnTask", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "fetch", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements d
{
  final String TAG;
  private b<? super Boolean, ah> callback;
  private e mgu;
  private final a mgv;
  
  public a()
  {
    AppMethodBeat.i(105420);
    this.TAG = "MicroMsg.EmojiLoader.EmojiFetcher";
    this.mgv = new a(this);
    AppMethodBeat.o(105420);
  }
  
  public final void a(e parame, b<? super Boolean, ah> paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(105419);
    s.u(parame, "fetcherConfig");
    this.mgu = parame;
    this.callback = paramb;
    com.tencent.mm.modelcdntran.g localg = k.bHW();
    com.tencent.mm.g.g localg1 = new com.tencent.mm.g.g();
    localg1.taskName = "task_EmojiCdnFetcher";
    paramb = this.mgu;
    parame = paramb;
    if (paramb == null)
    {
      s.bIx("fetcherConfig");
      parame = null;
    }
    localg1.field_authKey = parame.authKey;
    localg1.field_fileType = 19;
    String str = d.a.aUx();
    paramb = this.mgu;
    parame = paramb;
    if (paramb == null)
    {
      s.bIx("fetcherConfig");
      parame = null;
    }
    localg1.field_mediaId = s.X(str, parame.mgK.getMd5());
    paramb = this.mgu;
    parame = paramb;
    if (paramb == null)
    {
      s.bIx("fetcherConfig");
      parame = null;
    }
    localg1.field_fullpath = parame.path;
    parame = this.mgu;
    if (parame == null)
    {
      s.bIx("fetcherConfig");
      parame = localObject;
    }
    for (;;)
    {
      localg1.lwO = parame.url;
      localg1.lwL = ((g.a)this.mgv);
      localg.b(localg1, -1);
      AppMethodBeat.o(105419);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g.a
  {
    a(a parama) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(105418);
      Log.i(this.mgw.TAG, "callback " + paramInt + ' ' + paramc + ' ' + paramd);
      if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
      {
        paramd = this.mgw.TAG;
        StringBuilder localStringBuilder = new StringBuilder("download ");
        paramc = a.a(this.mgw);
        paramString = paramc;
        if (paramc == null)
        {
          s.bIx("fetcherConfig");
          paramString = null;
        }
        Log.i(paramd, paramString.mgK.getMd5() + " finish");
        paramString = a.b(this.mgw);
        if (paramString != null) {
          paramString.invoke(Boolean.TRUE);
        }
        AppMethodBeat.o(105418);
        return 0;
      }
      if ((paramInt != 0) || ((paramd != null) && (paramd.field_retCode != 0)))
      {
        paramString = a.b(this.mgw);
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
      }
      AppMethodBeat.o(105418);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.a
 * JD-Core Version:    0.7.0.1
 */