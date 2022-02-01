package com.tencent.mm.emoji.b.d;

import com.tencent.mm.emoji.b.e;
import com.tencent.mm.emoji.b.e.c;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/Request;", "T", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "task", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "getTask", "()Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "setTask", "(Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;)V", "cancel", "", "createTask", "onLoad", "success", "", "reload", "async", "start", "Callback", "Companion", "StateCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h<T>
{
  public static final h.b mhd = new h.b((byte)0);
  private static final int mhf = 0;
  private static final int mhg = 1;
  private static final int mhh = -1;
  final EmojiInfo mgK;
  private c mhe;
  
  public h(EmojiInfo paramEmojiInfo)
  {
    this.mgK = paramEmojiInfo;
  }
  
  private void fd(boolean paramBoolean)
  {
    c localc = this.mhe;
    if (localc != null) {
      localc.d(this);
    }
    this.mhe = aUy();
    localc = this.mhe;
    if (localc != null) {
      localc.c(this);
    }
    localc = this.mhe;
    if (localc != null) {
      localc.start(paramBoolean);
    }
  }
  
  protected c aUy()
  {
    e locale = e.mgl;
    return e.c(this.mgK);
  }
  
  public void cancel()
  {
    c localc = this.mhe;
    if (localc != null) {
      localc.d(this);
    }
  }
  
  public abstract void fc(boolean paramBoolean);
  
  public void start(boolean paramBoolean)
  {
    fd(paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "", "onResult", "", "success", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "T", "", "onState", "", "state", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "result", "(ILcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/Object;)V", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c<T>
  {
    public abstract void a(int paramInt, EmojiInfo paramEmojiInfo, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d.h
 * JD-Core Version:    0.7.0.1
 */