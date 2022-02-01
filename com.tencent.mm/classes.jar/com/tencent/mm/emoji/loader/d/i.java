package com.tencent.mm.emoji.loader.d;

import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/request/Request;", "T", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "task", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "getTask", "()Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "setTask", "(Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;)V", "cancel", "", "createTask", "onLoad", "success", "", "reload", "async", "start", "Callback", "Companion", "StateCallback", "plugin-emojisdk_release"})
public abstract class i<T>
{
  private static final int fPV = 1;
  private static final int fPW = -1;
  public static final i.b fPX = new i.b((byte)0);
  final EmojiInfo fPB;
  private c fPU;
  
  public i(EmojiInfo paramEmojiInfo)
  {
    this.fPB = paramEmojiInfo;
  }
  
  private void dg(boolean paramBoolean)
  {
    c localc = this.fPU;
    if (localc != null) {
      localc.d(this);
    }
    this.fPU = acb();
    localc = this.fPU;
    if (localc != null) {
      localc.c(this);
    }
    localc = this.fPU;
    if (localc != null) {
      localc.start(paramBoolean);
    }
  }
  
  protected c acb()
  {
    e locale = e.fOZ;
    return e.c(this.fPB);
  }
  
  public void cancel()
  {
    c localc = this.fPU;
    if (localc != null) {
      localc.d(this);
    }
  }
  
  public abstract void df(boolean paramBoolean);
  
  public void start(boolean paramBoolean)
  {
    dg(paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "", "onResult", "", "success", "", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void de(boolean paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "T", "", "onState", "", "state", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "result", "(ILcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/Object;)V", "plugin-emojisdk_release"})
  public static abstract interface c<T>
  {
    public abstract void aP(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.i
 * JD-Core Version:    0.7.0.1
 */