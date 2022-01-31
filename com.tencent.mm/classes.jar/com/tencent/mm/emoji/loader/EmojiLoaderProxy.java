package com.tencent.mm.emoji.loader;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/EmojiLoaderProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "load", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadRemote", "md5", "", "Companion", "plugin-emojisdk_release"})
public final class EmojiLoaderProxy
  extends com.tencent.mm.remoteservice.a
{
  private static EmojiLoaderProxy evm;
  private static int evn;
  private static boolean evo;
  public static final EmojiLoaderProxy.a evp;
  private final com.tencent.mm.remoteservice.d evl;
  
  static
  {
    AppMethodBeat.i(63164);
    evp = new EmojiLoaderProxy.a((byte)0);
    evm = new EmojiLoaderProxy(new com.tencent.mm.remoteservice.d(ah.getContext()));
    evo = true;
    AppMethodBeat.o(63164);
  }
  
  public EmojiLoaderProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    this.evl = paramd;
  }
  
  public final com.tencent.mm.remoteservice.d getServerProxy()
  {
    return this.evl;
  }
  
  public final void load(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63162);
    j.q(paramEmojiInfo, "emojiInfo");
    ab.i("MicroMsg.EmojiLoaderProxy", "load: " + paramEmojiInfo.Al());
    REMOTE_CALL("loadRemote", new Object[] { paramEmojiInfo.Al() });
    AppMethodBeat.o(63162);
  }
  
  @f
  public final void loadRemote(String paramString)
  {
    AppMethodBeat.i(63163);
    j.q(paramString, "md5");
    ab.i("MicroMsg.EmojiLoaderProxy", "loadRemote: ".concat(String.valueOf(paramString)));
    Object localObject = at.dxt();
    j.p(localObject, "EmojiStorageMgr.getInstance()");
    paramString = ((at)localObject).aUI().asP(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(63163);
      return;
    }
    localObject = a.evk;
    a.c(paramString);
    AppMethodBeat.o(63163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.EmojiLoaderProxy
 * JD-Core Version:    0.7.0.1
 */