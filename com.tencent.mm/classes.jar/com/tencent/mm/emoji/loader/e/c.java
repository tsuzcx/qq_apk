package com.tencent.mm.emoji.loader.e;

import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "finished", "", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "result", "running", "runningInQueue", "started", "addRequest", "", "request", "call", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "async", "uniqueId", "plugin-emojisdk_release"})
public abstract class c
  extends com.tencent.mm.loader.g.c
  implements Runnable
{
  private boolean bMF;
  final EmojiInfo fPB;
  private boolean fQf;
  private final List<i<?>> requests;
  private boolean result;
  private boolean running;
  private boolean started;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    this.fPB = paramEmojiInfo;
    this.requests = Collections.synchronizedList((List)new LinkedList());
  }
  
  public abstract String acf();
  
  public final String acg()
  {
    return acf();
  }
  
  public final void c(i<?> parami)
  {
    k.h(parami, "request");
    if (this.bMF) {
      parami.df(this.result);
    }
    while (this.requests.contains(parami)) {
      return;
    }
    this.requests.add(parami);
  }
  
  public final void call()
  {
    this.fQf = true;
    run();
  }
  
  public final void d(i<?> parami)
  {
    k.h(parami, "request");
    this.requests.remove(parami);
    if (this.requests.size() == 0)
    {
      ac.d(d.abZ(), "cancel " + acf() + ", " + this.running);
      if (!this.running)
      {
        parami = e.fOZ;
        e.tc(acf());
        de(false);
      }
    }
  }
  
  public void de(boolean paramBoolean)
  {
    this.result = paramBoolean;
    this.bMF = true;
    if (this.fQf) {
      a(h.gLN);
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
        y localy = y.KTp;
        localObject1 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((i)((Iterator)localObject1).next()).df(paramBoolean);
          continue;
          localObject1 = e.fOZ;
          e.tc(acf());
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
      e locale = e.fOZ;
      e.a(acf(), this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.c
 * JD-Core Version:    0.7.0.1
 */