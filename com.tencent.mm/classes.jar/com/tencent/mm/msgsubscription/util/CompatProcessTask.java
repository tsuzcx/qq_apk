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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Landroid/os/Parcelable;", "()V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "taskId$delegate", "Lkotlin/Lazy;", "callback", "", "describeContents", "", "execAsync", "keepMe", "parseFromParcel", "p", "Landroid/os/Parcel;", "releaseMe", "runInClientProcess", "runInMainProcess", "wxbiz-msgsubscription-sdk_release"})
public abstract class CompatProcessTask
  implements Parcelable
{
  private final f iGV = g.O((a)new c(this));
  
  public abstract void aOX();
  
  public void aOY() {}
  
  public final String aOZ()
  {
    return (String)this.iGV.getValue();
  }
  
  public final void aPa()
  {
    h.MqF.f((Runnable)new b(this), "CompatProcessTask_" + aOZ());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(CompatProcessTask paramCompatProcessTask) {}
    
    public final void run()
    {
      AppMethodBeat.i(174575);
      this.iGW.aOY();
      AppMethodBeat.o(174575);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CompatProcessTask paramCompatProcessTask) {}
    
    public final void run()
    {
      AppMethodBeat.i(174576);
      this.iGW.aOX();
      AppMethodBeat.o(174576);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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