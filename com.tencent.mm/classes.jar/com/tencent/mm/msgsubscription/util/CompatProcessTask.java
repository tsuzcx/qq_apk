package com.tencent.mm.msgsubscription.util;

import android.os.Parcelable;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Landroid/os/Parcelable;", "()V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "taskId$delegate", "Lkotlin/Lazy;", "callback", "", "describeContents", "", "execAsync", "keepMe", "parseFromParcel", "p", "Landroid/os/Parcel;", "releaseMe", "runInClientProcess", "runInMainProcess", "wxbiz-msgsubscription-sdk_release"})
public abstract class CompatProcessTask
  implements Parcelable
{
  private final f ikL = g.K((a)new c(this));
  
  public abstract void aLq();
  
  public void aLr() {}
  
  public final String aLs()
  {
    return (String)this.ikL.getValue();
  }
  
  public final void aLt()
  {
    h.JZN.f((Runnable)new b(this), "CompatProcessTask_" + aLs());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(CompatProcessTask paramCompatProcessTask) {}
    
    public final void run()
    {
      AppMethodBeat.i(174575);
      this.ikM.aLr();
      AppMethodBeat.o(174575);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CompatProcessTask paramCompatProcessTask) {}
    
    public final void run()
    {
      AppMethodBeat.i(174576);
      this.ikM.aLq();
      AppMethodBeat.o(174576);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
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