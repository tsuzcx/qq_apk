package com.tencent.mm.msgsubscription.util;

import android.os.Parcelable;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Landroid/os/Parcelable;", "()V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "taskId$delegate", "Lkotlin/Lazy;", "callback", "", "describeContents", "", "execAsync", "keepMe", "parseFromParcel", "p", "Landroid/os/Parcel;", "releaseMe", "runInClientProcess", "runInMainProcess", "wxbiz-msgsubscription-sdk_release"})
public abstract class CompatProcessTask
  implements Parcelable
{
  private final f jDe = g.ah((a)new c(this));
  
  public abstract void bjj();
  
  public void bjk() {}
  
  public final String bjl()
  {
    return (String)this.jDe.getValue();
  }
  
  public final void bjm()
  {
    h.RTc.b((Runnable)new b(this), "CompatProcessTask_" + bjl());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(CompatProcessTask paramCompatProcessTask) {}
    
    public final void run()
    {
      AppMethodBeat.i(174575);
      this.jDf.bjk();
      AppMethodBeat.o(174575);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CompatProcessTask paramCompatProcessTask) {}
    
    public final void run()
    {
      AppMethodBeat.i(174576);
      this.jDf.bjj();
      AppMethodBeat.o(174576);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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