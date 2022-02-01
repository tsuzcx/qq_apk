package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.EmojiLoaderProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/task/ProcessTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getTaskKey", "", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class e
  extends c
{
  public e(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105484);
    AppMethodBeat.o(105484);
  }
  
  public final String acf()
  {
    AppMethodBeat.i(105481);
    String str = this.fPB.JC();
    k.g(str, "emojiInfo.md5");
    AppMethodBeat.o(105481);
    return str;
  }
  
  public final void de(boolean paramBoolean)
  {
    AppMethodBeat.i(105483);
    super.de(paramBoolean);
    Object localObject = EmojiLoaderProxy.fPe;
    EmojiLoaderProxy.access$setRequestCount$cp(EmojiLoaderProxy.access$getRequestCount$cp() - 1);
    if (EmojiLoaderProxy.access$getRequestCount$cp() <= 0)
    {
      EmojiLoaderProxy.access$setNeedCreate$cp(true);
      localObject = EmojiLoaderProxy.access$getInstance$cp().getServerProxy();
      if (localObject != null)
      {
        ((d)localObject).release();
        AppMethodBeat.o(105483);
        return;
      }
    }
    AppMethodBeat.o(105483);
  }
  
  public final void run()
  {
    AppMethodBeat.i(105482);
    super.run();
    Object localObject = EmojiLoaderProxy.fPe;
    EmojiLoaderProxy.access$setRequestCount$cp(EmojiLoaderProxy.access$getRequestCount$cp() + 1);
    if (EmojiLoaderProxy.access$getNeedCreate$cp())
    {
      EmojiLoaderProxy.access$setNeedCreate$cp(false);
      localObject = new EmojiLoaderProxy(new d(ai.getContext()));
      k.h(localObject, "<set-?>");
      EmojiLoaderProxy.access$setInstance$cp((EmojiLoaderProxy)localObject);
    }
    localObject = EmojiLoaderProxy.fPe;
    EmojiLoaderProxy.access$getInstance$cp().load(this.fPB);
    AppMethodBeat.o(105482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.e
 * JD-Core Version:    0.7.0.1
 */