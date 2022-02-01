package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.y;
import java.io.ByteArrayOutputStream;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1;", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "createCdnTask", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "fetch", "plugin-emojisdk_release"})
public final class a
  implements d
{
  final String TAG;
  private e fPj;
  private d.g.a.b<? super Boolean, y> fPk;
  private final a fPl;
  
  public a()
  {
    AppMethodBeat.i(105420);
    this.TAG = "MicroMsg.EmojiLoader.EmojiFetcher";
    this.fPl = new a(this);
    AppMethodBeat.o(105420);
  }
  
  public final void a(e parame, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(105419);
    k.h(parame, "fetcherConfig");
    this.fPj = parame;
    this.fPk = paramb;
    parame = f.aDD();
    paramb = new g();
    Object localObject = this.fPj;
    if (localObject == null) {
      k.aVY("fetcherConfig");
    }
    paramb.field_authKey = ((e)localObject).fPC;
    paramb.field_fileType = 19;
    localObject = new StringBuilder().append(d.a.aca());
    e locale = this.fPj;
    if (locale == null) {
      k.aVY("fetcherConfig");
    }
    paramb.field_mediaId = locale.fPB.JC();
    localObject = this.fPj;
    if (localObject == null) {
      k.aVY("fetcherConfig");
    }
    paramb.field_fullpath = ((e)localObject).path;
    localObject = this.fPj;
    if (localObject == null) {
      k.aVY("fetcherConfig");
    }
    paramb.fre = ((e)localObject).url;
    paramb.frb = ((g.a)this.fPl);
    parame.e(paramb);
    AppMethodBeat.o(105419);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-emojisdk_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(105418);
      ac.i(this.fPm.TAG, "callback " + paramInt + ' ' + paramc + ' ' + paramd);
      if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
      {
        ac.i(this.fPm.TAG, "download " + a.a(this.fPm).fPB.JC() + " finish");
        paramString = a.b(this.fPm);
        if (paramString != null) {
          paramString.ay(Boolean.TRUE);
        }
        AppMethodBeat.o(105418);
        return 0;
      }
      if ((paramInt != 0) || ((paramd != null) && (paramd.field_retCode != 0)))
      {
        paramString = a.b(this.fPm);
        if (paramString != null) {
          paramString.ay(Boolean.FALSE);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.a
 * JD-Core Version:    0.7.0.1
 */