package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.List;

public final class WxaMenuHelper
{
  private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> qgn;
  
  private WxaMenuHelper()
  {
    AppMethodBeat.i(47672);
    this.qgn = new SparseArray();
    a(new u());
    a(new k());
    a(new o());
    a(new q());
    a(new t());
    a(new r());
    a(new j());
    a(new p());
    a(new c());
    a(new l());
    a(new e());
    a(new d());
    a(new i());
    a(new f());
    a(new g());
    a(new a());
    a(new s());
    a(new n());
    a(new m());
    a(new h());
    AppMethodBeat.o(47672);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.menu.a.a parama)
  {
    AppMethodBeat.i(47674);
    this.qgn.put(parama.qgq, parama);
    AppMethodBeat.o(47674);
  }
  
  public static void a(List<v> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47673);
    v localv = new v(paramInt, paramBoolean1, (com.tencent.mm.plugin.appbrand.menu.a.a)WxaMenuHelper.a.qgp.qgn.get(paramInt));
    localv.qfB = paramBoolean2;
    paramList.add(localv);
    AppMethodBeat.o(47673);
  }
  
  public static class GetCopyPathMenuExpireTimeTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetCopyPathMenuExpireTimeTask> CREATOR;
    private String mAppId;
    private long qgo;
    
    static
    {
      AppMethodBeat.i(47670);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47670);
    }
    
    public GetCopyPathMenuExpireTimeTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47666);
      this.qgo = 0L;
      f(paramParcel);
      AppMethodBeat.o(47666);
    }
    
    public GetCopyPathMenuExpireTimeTask(String paramString)
    {
      this.qgo = 0L;
      this.mAppId = paramString;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(47667);
      Object localObject = com.tencent.mm.plugin.appbrand.message.h.qhn;
      localObject = com.tencent.mm.plugin.appbrand.message.h.eJ(this.mAppId, "copypath");
      if (localObject == null)
      {
        this.qgo = 0L;
        AppMethodBeat.o(47667);
        return;
      }
      this.qgo = ((Long)localObject).longValue();
      AppMethodBeat.o(47667);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(47668);
      this.qgo = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      AppMethodBeat.o(47668);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47669);
      paramParcel.writeLong(this.qgo);
      paramParcel.writeString(this.mAppId);
      AppMethodBeat.o(47669);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper
 * JD-Core Version:    0.7.0.1
 */