package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.y;
import java.io.ByteArrayOutputStream;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1;", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "createCdnTask", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "fetch", "plugin-emojisdk_release"})
public final class a
  implements d
{
  final String TAG;
  private e fLx;
  private d.g.a.b<? super Boolean, y> fLy;
  private final a fLz;
  
  public a()
  {
    AppMethodBeat.i(105420);
    this.TAG = "MicroMsg.EmojiLoader.EmojiFetcher";
    this.fLz = new a(this);
    AppMethodBeat.o(105420);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(105419);
    k.h(parame, "fetcherConfig");
    this.fLx = parame;
    this.fLy = paramb;
    parame = f.awL();
    paramb = new g();
    Object localObject = this.fLx;
    if (localObject == null) {
      k.aPZ("fetcherConfig");
    }
    paramb.field_authKey = ((e)localObject).fLQ;
    paramb.field_fileType = 19;
    localObject = new StringBuilder().append(d.a.abc());
    e locale = this.fLx;
    if (locale == null) {
      k.aPZ("fetcherConfig");
    }
    paramb.field_mediaId = locale.fLP.JS();
    localObject = this.fLx;
    if (localObject == null) {
      k.aPZ("fetcherConfig");
    }
    paramb.field_fullpath = ((e)localObject).path;
    localObject = this.fLx;
    if (localObject == null) {
      k.aPZ("fetcherConfig");
    }
    paramb.fnK = ((e)localObject).url;
    paramb.fnH = ((g.a)this.fLz);
    parame.d(paramb);
    AppMethodBeat.o(105419);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-emojisdk_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(105418);
      ad.i(this.fLA.TAG, "callback " + paramInt + ' ' + paramc + ' ' + paramd);
      if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
      {
        ad.i(this.fLA.TAG, "download " + a.a(this.fLA).fLP.JS() + " finish");
        paramString = a.b(this.fLA);
        if (paramString != null) {
          paramString.aA(Boolean.TRUE);
        }
        AppMethodBeat.o(105418);
        return 0;
      }
      if ((paramInt != 0) || ((paramd != null) && (paramd.field_retCode != 0)))
      {
        paramString = a.b(this.fLA);
        if (paramString != null) {
          paramString.aA(Boolean.FALSE);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.a
 * JD-Core Version:    0.7.0.1
 */