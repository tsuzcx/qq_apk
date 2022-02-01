package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.List;

public final class WxaMenuHelper
{
  private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> lXX;
  
  private WxaMenuHelper()
  {
    AppMethodBeat.i(47672);
    this.lXX = new SparseArray();
    a(new d());
    a(new i());
    a(new l());
    a(new n());
    a(new q());
    a(new o());
    a(new h());
    a(new m());
    a(new c());
    a(new j());
    a(new g());
    a(new e());
    a(new f());
    a(new a());
    a(new p());
    a(new k());
    AppMethodBeat.o(47672);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.menu.a.a parama)
  {
    AppMethodBeat.i(47674);
    this.lXX.put(parama.lYa, parama);
    AppMethodBeat.o(47674);
  }
  
  public static void a(List<r> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47673);
    r localr = new r(paramInt, paramBoolean1, (com.tencent.mm.plugin.appbrand.menu.a.a)a.lXZ.lXX.get(paramInt));
    localr.lXh = paramBoolean2;
    paramList.add(localr);
    AppMethodBeat.o(47673);
  }
  
  public static class GetCopyPathMenuExpireTimeTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetCopyPathMenuExpireTimeTask> CREATOR;
    private long lXY;
    private String mAppId;
    
    static
    {
      AppMethodBeat.i(47670);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47670);
    }
    
    public GetCopyPathMenuExpireTimeTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47666);
      this.lXY = 0L;
      e(paramParcel);
      AppMethodBeat.o(47666);
    }
    
    public GetCopyPathMenuExpireTimeTask(String paramString)
    {
      this.lXY = 0L;
      this.mAppId = paramString;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(47667);
      Object localObject = com.tencent.mm.plugin.appbrand.message.h.lYX;
      localObject = com.tencent.mm.plugin.appbrand.message.h.ee(this.mAppId, "copypath");
      if (localObject == null)
      {
        this.lXY = 0L;
        AppMethodBeat.o(47667);
        return;
      }
      this.lXY = ((Long)localObject).longValue();
      AppMethodBeat.o(47667);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(47668);
      this.lXY = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      AppMethodBeat.o(47668);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47669);
      paramParcel.writeLong(this.lXY);
      paramParcel.writeString(this.mAppId);
      AppMethodBeat.o(47669);
    }
  }
  
  static final class a
  {
    static WxaMenuHelper lXZ;
    
    static
    {
      AppMethodBeat.i(47671);
      lXZ = new WxaMenuHelper((byte)0);
      AppMethodBeat.o(47671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper
 * JD-Core Version:    0.7.0.1
 */