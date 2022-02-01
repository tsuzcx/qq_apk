package com.tencent.mm.emoji.loader.e;

import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "finished", "", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "result", "running", "runningInQueue", "started", "addRequest", "", "request", "call", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "async", "uniqueId", "plugin-emojisdk_release"})
public abstract class c
  extends com.tencent.mm.loader.g.c
  implements Runnable
{
  private boolean bOX;
  final EmojiInfo fLP;
  private boolean fMt;
  private final List<i<?>> requests;
  private boolean result;
  private boolean running;
  private boolean started;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    this.fLP = paramEmojiInfo;
    this.requests = Collections.synchronizedList((List)new LinkedList());
  }
  
  public abstract String abh();
  
  public final String abi()
  {
    return abh();
  }
  
  public final void c(i<?> parami)
  {
    k.h(parami, "request");
    if (this.bOX) {
      parami.dg(this.result);
    }
    while (this.requests.contains(parami)) {
      return;
    }
    this.requests.add(parami);
  }
  
  public final void call()
  {
    this.fMt = true;
    run();
  }
  
  public final void d(i<?> parami)
  {
    k.h(parami, "request");
    this.requests.remove(parami);
    if (this.requests.size() == 0)
    {
      ad.d(d.abb(), "cancel " + abh() + ", " + this.running);
      if (!this.running)
      {
        parami = e.fLn;
        e.pR(abh());
        df(false);
      }
    }
  }
  
  public void df(boolean paramBoolean)
  {
    this.result = paramBoolean;
    this.bOX = true;
    if (this.fMt) {
      a(h.gla);
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = this.requests;
      k.g(localObject1, "requests");
      try
      {
        localLinkedList.addAll((Collection)this.requests);
        this.requests.clear();
        y localy = y.JfV;
        localObject1 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((i)((Iterator)localObject1).next()).dg(paramBoolean);
          continue;
          localObject1 = e.fLn;
          e.pR(abh());
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
      e locale = e.fLn;
      e.a(abh(), this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.c
 * JD-Core Version:    0.7.0.1
 */