package com.tencent.mm.msgsubscription.util;

import android.os.Parcelable;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Landroid/os/Parcelable;", "()V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "taskId$delegate", "Lkotlin/Lazy;", "callback", "", "describeContents", "", "execAsync", "keepMe", "parseFromParcel", "p", "Landroid/os/Parcel;", "releaseMe", "runInClientProcess", "runInMainProcess", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class CompatProcessTask
  implements Parcelable
{
  private final j pmQ = k.cm((a)new a(this));
  
  private static final void a(CompatProcessTask paramCompatProcessTask)
  {
    s.u(paramCompatProcessTask, "this$0");
    paramCompatProcessTask.asn();
  }
  
  private static final void b(CompatProcessTask paramCompatProcessTask)
  {
    s.u(paramCompatProcessTask, "this$0");
    paramCompatProcessTask.bQr();
  }
  
  private String bQs()
  {
    return (String)this.pmQ.getValue();
  }
  
  public abstract void asn();
  
  public void bQr() {}
  
  public final void bQt()
  {
    h.ahAA.g(new CompatProcessTask..ExternalSyntheticLambda0(this), s.X("CompatProcessTask_", bQs()));
  }
  
  public final void callback()
  {
    h.ahAA.g(new CompatProcessTask..ExternalSyntheticLambda1(this), s.X("CompatProcessTask_", bQs()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<String>
  {
    a(CompatProcessTask paramCompatProcessTask)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.CompatProcessTask
 * JD-Core Version:    0.7.0.1
 */