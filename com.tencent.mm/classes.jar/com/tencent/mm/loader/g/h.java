package com.tencent.mm.loader.g;

import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/loader/SingleTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "task", "Lkotlin/Function1;", "", "id", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTask", "()Lkotlin/jvm/functions/Function1;", "token", "", "getToken", "()I", "setToken", "(I)V", "call", "cancel", "toString", "uniqueId", "libimageloader_release"})
public class h
  extends c
{
  private final String id;
  public int kPS;
  private final b<h, x> kPT;
  
  private h(b<? super h, x> paramb, String paramString)
  {
    this.kPT = paramb;
    this.id = paramString;
    this.kPS = -1;
  }
  
  public final String aBG()
  {
    return this.id;
  }
  
  public final void call()
  {
    this.kPT.invoke(this);
  }
  
  public void cancel() {}
  
  public String toString()
  {
    return "{token=" + this.kPS + " id=" + this.id + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.g.h
 * JD-Core Version:    0.7.0.1
 */