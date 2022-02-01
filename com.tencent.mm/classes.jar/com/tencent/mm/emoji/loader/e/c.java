package com.tencent.mm.emoji.loader.e;

import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "finished", "", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "result", "running", "runningInQueue", "started", "addRequest", "", "request", "call", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "async", "uniqueId", "plugin-emojisdk_release"})
public abstract class c
  extends com.tencent.mm.loader.g.c
  implements Runnable
{
  private boolean chA;
  private boolean gWO;
  final EmojiInfo gWm;
  private final List<i<?>> requests;
  private boolean result;
  private boolean running;
  private boolean started;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    this.gWm = paramEmojiInfo;
    this.requests = Collections.synchronizedList((List)new LinkedList());
  }
  
  public abstract String auJ();
  
  public final String auK()
  {
    return auJ();
  }
  
  public final void c(i<?> parami)
  {
    p.h(parami, "request");
    if (this.chA) {
      parami.dR(this.result);
    }
    while (this.requests.contains(parami)) {
      return;
    }
    this.requests.add(parami);
  }
  
  public final void call()
  {
    this.gWO = true;
    run();
  }
  
  public final void d(i<?> parami)
  {
    p.h(parami, "request");
    this.requests.remove(parami);
    if (this.requests.size() == 0)
    {
      Log.d(d.auD(), "cancel " + auJ() + ", " + this.running);
      if (!this.running)
      {
        parami = e.gVM;
        e.EN(auJ());
        dQ(false);
      }
    }
  }
  
  public void dQ(boolean paramBoolean)
  {
    this.result = paramBoolean;
    this.chA = true;
    if (this.gWO) {
      a(j.ibw);
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = this.requests;
      p.g(localObject1, "requests");
      try
      {
        localLinkedList.addAll((Collection)this.requests);
        this.requests.clear();
        x localx = x.SXb;
        localObject1 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((i)((Iterator)localObject1).next()).dR(paramBoolean);
          continue;
          localObject1 = e.gVM;
          e.EN(auJ());
        }
      }
      finally {}
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
      e locale = e.gVM;
      e.a(auJ(), this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.c
 * JD-Core Version:    0.7.0.1
 */