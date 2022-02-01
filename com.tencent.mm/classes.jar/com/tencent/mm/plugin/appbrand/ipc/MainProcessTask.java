package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@Deprecated
public abstract class MainProcessTask
  implements Parcelable
{
  private final d orG = new d((byte)0);
  private final a orH = new a((byte)0);
  
  private static void a(Parcelable paramParcelable, MainProcessTask paramMainProcessTask)
  {
    if (paramParcelable == null) {
      return;
    }
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramMainProcessTask.f(localParcel);
    localParcel.recycle();
  }
  
  public abstract void RW();
  
  @Deprecated
  public final void bPk()
  {
    this.orH.orI.orP = null;
  }
  
  public final boolean bPt()
  {
    if (this.orG.orO != null) {
      this.orG.orO.run();
    }
    return true;
  }
  
  public final boolean bPu()
  {
    if (!j.Mp(MMApplicationContext.getMainProcessName())) {}
    Parcelable localParcelable;
    do
    {
      return false;
      localParcelable = j.a(MMApplicationContext.getMainProcessName(), this, c.class);
    } while (localParcelable == null);
    a(localParcelable, this);
    bsK();
    return true;
  }
  
  public void bsK() {}
  
  public final void bsM()
  {
    j.a(MMApplicationContext.getMainProcessName(), this, b.class, this.orH.orI, "MicroMsg.AppBrand.MainProcessTask");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void f(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
  
  final class a
  {
    final f<Parcelable> orI;
    
    private a()
    {
      AppMethodBeat.i(210407);
      this.orI = new f(new com.tencent.mm.ipcinvoker.f() {});
      AppMethodBeat.o(210407);
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
    transient Runnable orO = null;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
 * JD-Core Version:    0.7.0.1
 */