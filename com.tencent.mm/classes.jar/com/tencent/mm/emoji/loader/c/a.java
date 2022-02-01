package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1;", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "createCdnTask", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "fetch", "plugin-emojisdk_release"})
public final class a
  implements d
{
  final String TAG;
  private kotlin.g.a.b<? super Boolean, x> callback;
  private e jGR;
  private final a jGS;
  
  public a()
  {
    AppMethodBeat.i(105420);
    this.TAG = "MicroMsg.EmojiLoader.EmojiFetcher";
    this.jGS = new a(this);
    AppMethodBeat.o(105420);
  }
  
  public final void a(e parame, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(105419);
    p.k(parame, "fetcherConfig");
    this.jGR = parame;
    this.callback = paramb;
    parame = f.bkg();
    paramb = new g();
    paramb.taskName = "task_EmojiCdnFetcher";
    Object localObject = this.jGR;
    if (localObject == null) {
      p.bGy("fetcherConfig");
    }
    paramb.field_authKey = ((e)localObject).authKey;
    paramb.field_fileType = 19;
    localObject = new StringBuilder().append(d.a.aBz());
    e locale = this.jGR;
    if (locale == null) {
      p.bGy("fetcherConfig");
    }
    paramb.field_mediaId = locale.jHh.getMd5();
    localObject = this.jGR;
    if (localObject == null) {
      p.bGy("fetcherConfig");
    }
    paramb.field_fullpath = ((e)localObject).path;
    localObject = this.jGR;
    if (localObject == null) {
      p.bGy("fetcherConfig");
    }
    paramb.iUJ = ((e)localObject).url;
    paramb.iUG = ((g.a)this.jGS);
    parame.e(paramb);
    AppMethodBeat.o(105419);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-emojisdk_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(105418);
      Log.i(this.jGT.TAG, "callback " + paramInt + ' ' + paramc + ' ' + paramd);
      if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i(this.jGT.TAG, "download " + a.a(this.jGT).jHh.getMd5() + " finish");
        paramString = a.b(this.jGT);
        if (paramString != null) {
          paramString.invoke(Boolean.TRUE);
        }
        AppMethodBeat.o(105418);
        return 0;
      }
      if ((paramInt != 0) || ((paramd != null) && (paramd.field_retCode != 0)))
      {
        paramString = a.b(this.jGT);
        if (paramString != null) {
          paramString.invoke(Boolean.FALSE);
        }
      }
      AppMethodBeat.o(105418);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.a
 * JD-Core Version:    0.7.0.1
 */