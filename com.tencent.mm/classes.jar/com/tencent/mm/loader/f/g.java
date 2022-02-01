package com.tencent.mm.loader.f;

import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/SingleTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "task", "Lkotlin/Function1;", "", "id", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTask", "()Lkotlin/jvm/functions/Function1;", "token", "", "getToken", "()I", "setToken", "(I)V", "call", "cancel", "toString", "uniqueId", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
  extends c
{
  private final String id;
  private final b<g, ah> nrv;
  public int nrw;
  
  private g(b<? super g, ah> paramb, String paramString)
  {
    this.nrv = paramb;
    this.id = paramString;
    this.nrw = -1;
  }
  
  public final String aUE()
  {
    return this.id;
  }
  
  public final void call()
  {
    this.nrv.invoke(this);
  }
  
  public void cancel() {}
  
  public String toString()
  {
    return "{token=" + this.nrw + " id=" + this.id + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.f.g
 * JD-Core Version:    0.7.0.1
 */