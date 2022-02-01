package com.tencent.mm.loader.g;

import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/loader/SingleTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "task", "Lkotlin/Function1;", "", "id", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTask", "()Lkotlin/jvm/functions/Function1;", "token", "", "getToken", "()I", "setToken", "(I)V", "call", "toString", "uniqueId", "libimageloader_release"})
public final class h
  extends c
{
  private final b<h, x> ibm;
  private final String id;
  public int token;
  
  private h(b<? super h, x> paramb, String paramString)
  {
    this.ibm = paramb;
    this.id = paramString;
    this.token = -1;
  }
  
  public final String auK()
  {
    return this.id;
  }
  
  public final void call()
  {
    this.ibm.invoke(this);
  }
  
  public final String toString()
  {
    return "{token=" + this.token + " id=" + this.id + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.g.h
 * JD-Core Version:    0.7.0.1
 */