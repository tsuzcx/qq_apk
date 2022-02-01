package com.tencent.mm.msgsubscription.util;

import android.os.Parcelable;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Landroid/os/Parcelable;", "()V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "taskId$delegate", "Lkotlin/Lazy;", "callback", "", "describeContents", "", "execAsync", "keepMe", "parseFromParcel", "p", "Landroid/os/Parcel;", "releaseMe", "runInClientProcess", "runInMainProcess", "wxbiz-msgsubscription-sdk_release"})
public abstract class CompatProcessTask
  implements Parcelable
{
  private final f iEc = g.O((a)new c(this));
  
  public abstract void aOA();
  
  public void aOB() {}
  
  public final String aOC()
  {
    return (String)this.iEc.getValue();
  }
  
  public final void aOD()
  {
    h.LTJ.f((Runnable)new b(this), "CompatProcessTask_" + aOC());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(CompatProcessTask paramCompatProcessTask) {}
    
    public final void run()
    {
      AppMethodBeat.i(174575);
      this.iEd.aOB();
      AppMethodBeat.o(174575);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CompatProcessTask paramCompatProcessTask) {}
    
    public final void run()
    {
      AppMethodBeat.i(174576);
      this.iEd.aOA();
      AppMethodBeat.o(174576);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<String>
  {
    c(CompatProcessTask paramCompatProcessTask)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.CompatProcessTask
 * JD-Core Version:    0.7.0.1
 */