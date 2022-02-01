package com.tencent.mm.emoji.loader.d;

import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/request/Request;", "T", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "task", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "getTask", "()Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "setTask", "(Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;)V", "cancel", "", "createTask", "onLoad", "success", "", "reload", "async", "start", "Callback", "Companion", "StateCallback", "plugin-emojisdk_release"})
public abstract class i<T>
{
  private static final int jHA = 0;
  private static final int jHB = 1;
  private static final int jHC = -1;
  public static final i.b jHD = new i.b((byte)0);
  final EmojiInfo jHh;
  private c jHz;
  
  public i(EmojiInfo paramEmojiInfo)
  {
    this.jHh = paramEmojiInfo;
  }
  
  private void er(boolean paramBoolean)
  {
    c localc = this.jHz;
    if (localc != null) {
      localc.d(this);
    }
    this.jHz = aBA();
    localc = this.jHz;
    if (localc != null) {
      localc.c(this);
    }
    localc = this.jHz;
    if (localc != null) {
      localc.start(paramBoolean);
    }
  }
  
  protected c aBA()
  {
    e locale = e.jGI;
    return e.c(this.jHh);
  }
  
  public void cancel()
  {
    c localc = this.jHz;
    if (localc != null) {
      localc.d(this);
    }
  }
  
  public abstract void eq(boolean paramBoolean);
  
  public void start(boolean paramBoolean)
  {
    er(paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "", "onResult", "", "success", "", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void ep(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.i
 * JD-Core Version:    0.7.0.1
 */