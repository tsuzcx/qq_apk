package com.tencent.mm.emoji.loader.d;

import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/Request;", "T", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "task", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "getTask", "()Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "setTask", "(Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;)V", "cancel", "", "createTask", "onLoad", "success", "", "reload", "async", "start", "Callback", "Companion", "StateCallback", "plugin-emojisdk_release"})
public abstract class i<T>
{
  private static final int fMj = 1;
  private static final int fMk = -1;
  public static final b fMl = new b((byte)0);
  final EmojiInfo fLP;
  private c fMi;
  
  public i(EmojiInfo paramEmojiInfo)
  {
    this.fLP = paramEmojiInfo;
  }
  
  private void dh(boolean paramBoolean)
  {
    c localc = this.fMi;
    if (localc != null) {
      localc.d(this);
    }
    this.fMi = abd();
    localc = this.fMi;
    if (localc != null) {
      localc.c(this);
    }
    localc = this.fMi;
    if (localc != null) {
      localc.start(paramBoolean);
    }
  }
  
  protected c abd()
  {
    e locale = e.fLn;
    return e.c(this.fLP);
  }
  
  public void cancel()
  {
    c localc = this.fMi;
    if (localc != null) {
      localc.d(this);
    }
  }
  
  public abstract void dg(boolean paramBoolean);
  
  public void start(boolean paramBoolean)
  {
    dh(paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "", "onResult", "", "success", "", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void df(boolean paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/Request$Companion;", "", "()V", "StateFailed", "", "StateFailed$annotations", "getStateFailed", "()I", "StateLoading", "StateLoading$annotations", "getStateLoading", "StateSuccess", "StateSuccess$annotations", "getStateSuccess", "plugin-emojisdk_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "T", "", "onState", "", "state", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "result", "(ILcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/Object;)V", "plugin-emojisdk_release"})
  public static abstract interface c<T>
  {
    public abstract void aS(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.i
 * JD-Core Version:    0.7.0.1
 */