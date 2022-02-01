package com.tencent.mm.emoji.b.e;

import com.tencent.mm.emoji.b.d.h;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "finished", "", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "result", "running", "runningInQueue", "started", "addRequest", "", "request", "call", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "async", "uniqueId", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends com.tencent.mm.loader.f.c
  implements Runnable
{
  final EmojiInfo mgK;
  private boolean mhp;
  private boolean mhq;
  private final List<h<?>> requests;
  private boolean result;
  private boolean running;
  private boolean started;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    this.mgK = paramEmojiInfo;
    this.requests = Collections.synchronizedList((List)new LinkedList());
  }
  
  public abstract String aUD();
  
  public final String aUE()
  {
    return aUD();
  }
  
  public final void c(h<?> paramh)
  {
    s.u(paramh, "request");
    if (this.mhq) {
      paramh.fc(this.result);
    }
    while (this.requests.contains(paramh)) {
      return;
    }
    this.requests.add(paramh);
  }
  
  public final void call()
  {
    this.mhp = true;
    run();
  }
  
  public final void d(h<?> paramh)
  {
    s.u(paramh, "request");
    this.requests.remove(paramh);
    if (this.requests.size() == 0)
    {
      Log.d(d.aUw(), "cancel " + aUD() + ", " + this.running);
      if (!this.running)
      {
        paramh = e.mgl;
        e.Em(aUD());
        onResult(false);
      }
    }
  }
  
  public void onResult(final boolean paramBoolean)
  {
    this.result = paramBoolean;
    this.mhq = true;
    if (this.mhp) {
      a(i.nrG);
    }
    for (;;)
    {
      com.tencent.mm.ae.d.B((a)new a(this, paramBoolean));
      return;
      e locale = e.mgl;
      e.Em(aUD());
    }
  }
  
  public void run()
  {
    this.running = true;
  }
  
  public final void start(boolean paramBoolean)
  {
    if (!this.started)
    {
      this.started = true;
      e locale = e.mgl;
      e.a(aUD(), this, paramBoolean);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e.c
 * JD-Core Version:    0.7.0.1
 */