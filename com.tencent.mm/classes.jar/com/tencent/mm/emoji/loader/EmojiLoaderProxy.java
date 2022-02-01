package com.tencent.mm.emoji.loader;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sticker.loader.StickerLoadInfo;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getArgs", "", "", "params", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)[Ljava/lang/Object;", "load", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadRemote", "md5", "", "loadSticker", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadStickerRemote", "Companion", "plugin-emojisdk_release"})
public final class EmojiLoaderProxy
  extends a
{
  private static EmojiLoaderProxy gkT;
  private static int gkU;
  private static boolean gkV;
  public static final EmojiLoaderProxy.a gkW;
  private final d gkS;
  
  static
  {
    AppMethodBeat.i(105409);
    gkW = new EmojiLoaderProxy.a((byte)0);
    gkT = new EmojiLoaderProxy(new d(ak.getContext()));
    gkV = true;
    AppMethodBeat.o(105409);
  }
  
  public EmojiLoaderProxy(d paramd)
  {
    super(paramd);
    this.gkS = paramd;
  }
  
  public final Object[] getArgs(Bundle paramBundle)
  {
    AppMethodBeat.i(105408);
    if (paramBundle != null) {
      paramBundle.setClassLoader(StickerLoadInfo.class.getClassLoader());
    }
    paramBundle = super.getArgs(paramBundle);
    p.g(paramBundle, "super.getArgs(params)");
    AppMethodBeat.o(105408);
    return paramBundle;
  }
  
  public final d getServerProxy()
  {
    return this.gkS;
  }
  
  public final void load(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105404);
    p.h(paramEmojiInfo, "emojiInfo");
    ae.i("MicroMsg.EmojiLoaderProxy", "load: " + paramEmojiInfo.Lj());
    REMOTE_CALL("loadRemote", new Object[] { paramEmojiInfo.Lj() });
    AppMethodBeat.o(105404);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void loadRemote(String paramString)
  {
    AppMethodBeat.i(105405);
    p.h(paramString, "md5");
    ae.i("MicroMsg.EmojiLoaderProxy", "loadRemote: ".concat(String.valueOf(paramString)));
    Object localObject = be.fvc();
    p.g(localObject, "EmojiStorageMgr.getInstance()");
    paramString = ((be)localObject).bJU().aWl(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(105405);
      return;
    }
    localObject = e.gkR;
    e.e(paramString);
    AppMethodBeat.o(105405);
  }
  
  public final void loadSticker(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105406);
    p.h(paramStickerLoadInfo, "info");
    ae.i("MicroMsg.EmojiLoaderProxy", "loadSticker: " + paramStickerLoadInfo.BN());
    REMOTE_CALL("loadStickerRemote", new Object[] { paramStickerLoadInfo });
    AppMethodBeat.o(105406);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void loadStickerRemote(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105407);
    p.h(paramStickerLoadInfo, "info");
    ae.i("MicroMsg.EmojiLoaderProxy", "loadStickerRemote: " + paramStickerLoadInfo.BN());
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.IGU;
    com.tencent.mm.sticker.loader.e.b(paramStickerLoadInfo);
    AppMethodBeat.o(105407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.EmojiLoaderProxy
 * JD-Core Version:    0.7.0.1
 */