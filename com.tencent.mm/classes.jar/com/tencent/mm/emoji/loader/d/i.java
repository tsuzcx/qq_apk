package com.tencent.mm.emoji.loader.d;

import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/request/Request;", "T", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "task", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "getTask", "()Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "setTask", "(Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;)V", "cancel", "", "createTask", "onLoad", "success", "", "reload", "async", "start", "Callback", "Companion", "StateCallback", "plugin-emojisdk_release"})
public abstract class i<T>
{
  private static final int gWE = 1;
  private static final int gWF = -1;
  public static final i.b gWG = new i.b((byte)0);
  private c gWD;
  final EmojiInfo gWm;
  
  public i(EmojiInfo paramEmojiInfo)
  {
    this.gWm = paramEmojiInfo;
  }
  
  private void dS(boolean paramBoolean)
  {
    c localc = this.gWD;
    if (localc != null) {
      localc.d(this);
    }
    this.gWD = auF();
    localc = this.gWD;
    if (localc != null) {
      localc.c(this);
    }
    localc = this.gWD;
    if (localc != null) {
      localc.start(paramBoolean);
    }
  }
  
  protected c auF()
  {
    e locale = e.gVM;
    return e.c(this.gWm);
  }
  
  public void cancel()
  {
    c localc = this.gWD;
    if (localc != null) {
      localc.d(this);
    }
  }
  
  public abstract void dR(boolean paramBoolean);
  
  public void start(boolean paramBoolean)
  {
    dS(paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "", "onResult", "", "success", "", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void dQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.i
 * JD-Core Version:    0.7.0.1
 */