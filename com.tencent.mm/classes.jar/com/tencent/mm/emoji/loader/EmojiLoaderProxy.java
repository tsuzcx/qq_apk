package com.tencent.mm.emoji.loader;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sticker.loader.StickerLoadInfo;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getArgs", "", "", "params", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)[Ljava/lang/Object;", "load", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadRemote", "md5", "", "loadSticker", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadStickerRemote", "Companion", "plugin-emojisdk_release"})
public final class EmojiLoaderProxy
  extends a
{
  private static EmojiLoaderProxy fPb;
  private static int fPc;
  private static boolean fPd;
  public static final EmojiLoaderProxy.a fPe;
  private final d fPa;
  
  static
  {
    AppMethodBeat.i(105409);
    fPe = new EmojiLoaderProxy.a((byte)0);
    fPb = new EmojiLoaderProxy(new d(ai.getContext()));
    fPd = true;
    AppMethodBeat.o(105409);
  }
  
  public EmojiLoaderProxy(d paramd)
  {
    super(paramd);
    this.fPa = paramd;
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
    return this.fPa;
  }
  
  public final void load(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105404);
    k.h(paramEmojiInfo, "emojiInfo");
    ac.i("MicroMsg.EmojiLoaderProxy", "load: " + paramEmojiInfo.JC());
    REMOTE_CALL("loadRemote", new Object[] { paramEmojiInfo.JC() });
    AppMethodBeat.o(105404);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void loadRemote(String paramString)
  {
    AppMethodBeat.i(105405);
    k.h(paramString, "md5");
    ac.i("MicroMsg.EmojiLoaderProxy", "loadRemote: ".concat(String.valueOf(paramString)));
    Object localObject = az.faZ();
    k.g(localObject, "EmojiStorageMgr.getInstance()");
    paramString = ((az)localObject).bEN().aOT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(105405);
      return;
    }
    localObject = e.fOZ;
    e.e(paramString);
    AppMethodBeat.o(105405);
  }
  
  public final void loadSticker(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105406);
    k.h(paramStickerLoadInfo, "info");
    ac.i("MicroMsg.EmojiLoaderProxy", "loadSticker: " + paramStickerLoadInfo.Ap());
    REMOTE_CALL("loadStickerRemote", new Object[] { paramStickerLoadInfo });
    AppMethodBeat.o(105406);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void loadStickerRemote(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105407);
    k.h(paramStickerLoadInfo, "info");
    ac.i("MicroMsg.EmojiLoaderProxy", "loadStickerRemote: " + paramStickerLoadInfo.Ap());
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.GAP;
    com.tencent.mm.sticker.loader.e.b(paramStickerLoadInfo);
    AppMethodBeat.o(105407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.EmojiLoaderProxy
 * JD-Core Version:    0.7.0.1
 */