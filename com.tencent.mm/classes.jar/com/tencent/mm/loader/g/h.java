package com.tencent.mm.loader.g;

import d.g.a.b;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/loader/SingleTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "task", "Lkotlin/Function1;", "", "id", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTask", "()Lkotlin/jvm/functions/Function1;", "token", "", "getToken", "()I", "setToken", "(I)V", "call", "toString", "uniqueId", "libimageloader_release"})
public final class h
  extends c
{
  private final b<h, z> hio;
  private final String id;
  public int token;
  
  private h(b<? super h, z> paramb, String paramString)
  {
    this.hio = paramb;
    this.id = paramString;
    this.token = -1;
  }
  
  public final String aeW()
  {
    return this.id;
  }
  
  public final void call()
  {
    this.hio.invoke(this);
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