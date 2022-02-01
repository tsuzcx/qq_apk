package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@Deprecated
public abstract class MainProcessTask
  implements Parcelable
{
  private final d rvA = new d((byte)0);
  private final a rvB = new a((byte)0);
  
  private static void a(Parcelable paramParcelable, MainProcessTask paramMainProcessTask)
  {
    if (paramParcelable == null) {
      return;
    }
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramMainProcessTask.h(localParcel);
    localParcel.recycle();
  }
  
  public abstract void asn();
  
  public void bQr() {}
  
  public final void bQt()
  {
    j.a(MMApplicationContext.getMainProcessName(), this, b.class, this.rvB.rvC, "MicroMsg.AppBrand.MainProcessTask");
  }
  
  public final boolean cpA()
  {
    if (this.rvA.rvI != null) {
      this.rvA.rvI.run();
    }
    return true;
  }
  
  public final boolean cpB()
  {
    if (!j.EX(MMApplicationContext.getMainProcessName())) {}
    Parcelable localParcelable;
    do
    {
      return false;
      localParcelable = j.a(MMApplicationContext.getMainProcessName(), this, c.class);
    } while (localParcelable == null);
    a(localParcelable, this);
    bQr();
    return true;
  }
  
  @Deprecated
  public final void cpx()
  {
    this.rvB.rvC.rvJ = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void h(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
  
  final class a
  {
    final g<Parcelable> rvC;
    
    private a()
    {
      AppMethodBeat.i(319429);
      this.rvC = new g(new f() {});
      AppMethodBeat.o(319429);
    }
  }
  
  static class b
    implements d<MainProcessTask, Parcelable>
  {}
  
  static class c
    implements m<MainProcessTask, MainProcessTask>
  {}
  
  final class d
  {
    transient Runnable rvI = null;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */