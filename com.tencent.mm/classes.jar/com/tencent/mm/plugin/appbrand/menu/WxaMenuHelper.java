package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.List;

public final class WxaMenuHelper
{
  private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> nfD;
  
  private WxaMenuHelper()
  {
    AppMethodBeat.i(47672);
    this.nfD = new SparseArray();
    a(new s());
    a(new j());
    a(new m());
    a(new o());
    a(new r());
    a(new p());
    a(new i());
    a(new n());
    a(new c());
    a(new k());
    a(new e());
    a(new d());
    a(new h());
    a(new f());
    a(new g());
    a(new a());
    a(new q());
    a(new l());
    AppMethodBeat.o(47672);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.menu.a.a parama)
  {
    AppMethodBeat.i(47674);
    this.nfD.put(parama.nfG, parama);
    AppMethodBeat.o(47674);
  }
  
  public static void a(List<t> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(47673);
    t localt = new t(paramInt, paramBoolean1, (com.tencent.mm.plugin.appbrand.menu.a.a)a.nfF.nfD.get(paramInt));
    localt.neT = paramBoolean2;
    paramList.add(localt);
    AppMethodBeat.o(47673);
  }
  
  public static class GetCopyPathMenuExpireTimeTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetCopyPathMenuExpireTimeTask> CREATOR;
    private String mAppId;
    private long nfE;
    
    static
    {
      AppMethodBeat.i(47670);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47670);
    }
    
    public GetCopyPathMenuExpireTimeTask(Parcel paramParcel)
    {
      AppMethodBeat.i(47666);
      this.nfE = 0L;
      f(paramParcel);
      AppMethodBeat.o(47666);
    }
    
    public GetCopyPathMenuExpireTimeTask(String paramString)
    {
      this.nfE = 0L;
      this.mAppId = paramString;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(47667);
      Object localObject = com.tencent.mm.plugin.appbrand.message.h.ngD;
      localObject = com.tencent.mm.plugin.appbrand.message.h.ev(this.mAppId, "copypath");
      if (localObject == null)
      {
        this.nfE = 0L;
        AppMethodBeat.o(47667);
        return;
      }
      this.nfE = ((Long)localObject).longValue();
      AppMethodBeat.o(47667);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(47668);
      this.nfE = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      AppMethodBeat.o(47668);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47669);
      paramParcel.writeLong(this.nfE);
      paramParcel.writeString(this.mAppId);
      AppMethodBeat.o(47669);
    }
  }
  
  static final class a
  {
    static WxaMenuHelper nfF;
    
    static
    {
      AppMethodBeat.i(47671);
      nfF = new WxaMenuHelper((byte)0);
      AppMethodBeat.o(47671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper
 * JD-Core Version:    0.7.0.1
 */