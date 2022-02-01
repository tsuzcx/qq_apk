package com.tencent.mm.emoji.loader;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sticker.loader.StickerLoadInfo;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getArgs", "", "", "params", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)[Ljava/lang/Object;", "load", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadRemote", "md5", "", "loadSticker", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadStickerRemote", "Companion", "plugin-emojisdk_release"})
public final class EmojiLoaderProxy
  extends a
{
  private static EmojiLoaderProxy fLp;
  private static int fLq;
  private static boolean fLr;
  public static final a fLs;
  private final d fLo;
  
  static
  {
    AppMethodBeat.i(105409);
    fLs = new a((byte)0);
    fLp = new EmojiLoaderProxy(new d(aj.getContext()));
    fLr = true;
    AppMethodBeat.o(105409);
  }
  
  public EmojiLoaderProxy(d paramd)
  {
    super(paramd);
    this.fLo = paramd;
  }
  
  public final Object[] getArgs(Bundle paramBundle)
  {
    AppMethodBeat.i(105408);
    if (paramBundle != null) {
      paramBundle.setClassLoader(StickerLoadInfo.class.getClassLoader());
    }
    paramBundle = super.getArgs(paramBundle);
    k.g(paramBundle, "super.getArgs(params)");
    AppMethodBeat.o(105408);
    return paramBundle;
  }
  
  public final d getServerProxy()
  {
    return this.fLo;
  }
  
  public final void load(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105404);
    k.h(paramEmojiInfo, "emojiInfo");
    ad.i("MicroMsg.EmojiLoaderProxy", "load: " + paramEmojiInfo.JS());
    REMOTE_CALL("loadRemote", new Object[] { paramEmojiInfo.JS() });
    AppMethodBeat.o(105404);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void loadRemote(String paramString)
  {
    AppMethodBeat.i(105405);
    k.h(paramString, "md5");
    ad.i("MicroMsg.EmojiLoaderProxy", "loadRemote: ".concat(String.valueOf(paramString)));
    Object localObject = aw.eLx();
    k.g(localObject, "EmojiStorageMgr.getInstance()");
    paramString = ((aw)localObject).bxR().aJx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(105405);
      return;
    }
    localObject = e.fLn;
    e.e(paramString);
    AppMethodBeat.o(105405);
  }
  
  public final void loadSticker(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105406);
    k.h(paramStickerLoadInfo, "info");
    ad.i("MicroMsg.EmojiLoaderProxy", "loadSticker: " + paramStickerLoadInfo.AL());
    REMOTE_CALL("loadStickerRemote", new Object[] { paramStickerLoadInfo });
    AppMethodBeat.o(105406);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void loadStickerRemote(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105407);
    k.h(paramStickerLoadInfo, "info");
    ad.i("MicroMsg.EmojiLoaderProxy", "loadStickerRemote: " + paramStickerLoadInfo.AL());
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.Fds;
    com.tencent.mm.sticker.loader.e.b(paramStickerLoadInfo);
    AppMethodBeat.o(105407);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "getInstance", "()Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "setInstance", "(Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.EmojiLoaderProxy
 * JD-Core Version:    0.7.0.1
 */