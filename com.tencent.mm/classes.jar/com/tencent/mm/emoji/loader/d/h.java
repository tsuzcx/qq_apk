package com.tencent.mm.emoji.loader.d;

import a.l;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/request/Request;", "T", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "task", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "getTask", "()Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "setTask", "(Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;)V", "cancel", "", "createTask", "onLoad", "success", "", "reload", "async", "start", "Callback", "plugin-emojisdk_release"})
public abstract class h<T>
{
  final EmojiInfo evH;
  private c evY;
  
  public h(EmojiInfo paramEmojiInfo)
  {
    this.evH = paramEmojiInfo;
  }
  
  private void cg(boolean paramBoolean)
  {
    c localc = this.evY;
    if (localc != null) {
      localc.c(this);
    }
    this.evY = Ov();
    localc = this.evY;
    if (localc != null) {
      localc.b(this);
    }
    localc = this.evY;
    if (localc != null) {
      localc.start(paramBoolean);
    }
  }
  
  protected c Ov()
  {
    a locala = a.evk;
    return a.a(this.evH);
  }
  
  public void cancel()
  {
    c localc = this.evY;
    if (localc != null) {
      localc.c(this);
    }
  }
  
  public abstract void cf(boolean paramBoolean);
  
  public void start(boolean paramBoolean)
  {
    cg(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.h
 * JD-Core Version:    0.7.0.1
 */