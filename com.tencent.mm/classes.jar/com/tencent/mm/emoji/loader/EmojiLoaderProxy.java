package com.tencent.mm.emoji.loader;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sticker.loader.StickerLoadInfo;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getArgs", "", "", "params", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)[Ljava/lang/Object;", "load", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadRemote", "md5", "", "loadSticker", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadStickerRemote", "Companion", "plugin-emojisdk_release"})
public final class EmojiLoaderProxy
  extends a
{
  private static EmojiLoaderProxy gVO;
  private static int gVP;
  private static boolean gVQ;
  public static final EmojiLoaderProxy.a gVR;
  private final d gVN;
  
  static
  {
    AppMethodBeat.i(105409);
    gVR = new EmojiLoaderProxy.a((byte)0);
    gVO = new EmojiLoaderProxy(new d(MMApplicationContext.getContext()));
    gVQ = true;
    AppMethodBeat.o(105409);
  }
  
  public EmojiLoaderProxy(d paramd)
  {
    super(paramd);
    this.gVN = paramd;
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
    return this.gVN;
  }
  
  public final void load(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105404);
    p.h(paramEmojiInfo, "emojiInfo");
    Log.i("MicroMsg.EmojiLoaderProxy", "load: " + paramEmojiInfo.getMd5());
    REMOTE_CALL("loadRemote", new Object[] { paramEmojiInfo.getMd5() });
    AppMethodBeat.o(105404);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void loadRemote(String paramString)
  {
    AppMethodBeat.i(105405);
    p.h(paramString, "md5");
    Log.i("MicroMsg.EmojiLoaderProxy", "loadRemote: ".concat(String.valueOf(paramString)));
    Object localObject = bj.gCJ();
    p.g(localObject, "EmojiStorageMgr.getInstance()");
    paramString = ((bj)localObject).cgN().blk(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(105405);
      return;
    }
    localObject = e.gVM;
    e.e(paramString);
    AppMethodBeat.o(105405);
  }
  
  public final void loadSticker(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105406);
    p.h(paramStickerLoadInfo, "info");
    Log.i("MicroMsg.EmojiLoaderProxy", "loadSticker: " + paramStickerLoadInfo.Lb());
    REMOTE_CALL("loadStickerRemote", new Object[] { paramStickerLoadInfo });
    AppMethodBeat.o(105406);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void loadStickerRemote(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105407);
    p.h(paramStickerLoadInfo, "info");
    Log.i("MicroMsg.EmojiLoaderProxy", "loadStickerRemote: " + paramStickerLoadInfo.Lb());
    com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.NNN;
    com.tencent.mm.sticker.loader.e.b(paramStickerLoadInfo);
    AppMethodBeat.o(105407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.EmojiLoaderProxy
 * JD-Core Version:    0.7.0.1
 */