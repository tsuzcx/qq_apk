package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

final class AppBrandStickyBannerLogic$Watcher
  extends MainProcessTask
{
  public static final Parcelable.Creator<Watcher> CREATOR;
  private static final transient Map<String, f> oav;
  String oas;
  String oat;
  int oau;
  
  static
  {
    AppMethodBeat.i(49031);
    oav = new HashMap();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(49031);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(49026);
    if (Util.isNullOrNil(this.oas))
    {
      AppMethodBeat.o(49026);
      return;
    }
    synchronized (oav)
    {
      if (oav.containsKey(this.oas)) {
        AppBrandStickyBannerLogic.b.c((f)oav.get(this.oas));
      }
      f local1 = new f()
      {
        public final void bJ(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(49024);
          AppBrandStickyBannerLogic.Watcher.this.oat = paramAnonymousString;
          AppBrandStickyBannerLogic.Watcher.this.oau = paramAnonymousInt;
          AppBrandStickyBannerLogic.Watcher.a(AppBrandStickyBannerLogic.Watcher.this);
          AppMethodBeat.o(49024);
        }
      };
      AppBrandStickyBannerLogic.b.d(local1);
      oav.put(this.oas, local1);
      AppMethodBeat.o(49026);
      return;
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(49027);
    AppBrandStickyBannerLogic.a.cq(this.oat, this.oau);
    AppMethodBeat.o(49027);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(49029);
    this.oas = paramParcel.readString();
    this.oat = paramParcel.readString();
    this.oau = paramParcel.readInt();
    AppMethodBeat.o(49029);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(49028);
    paramParcel.writeString(this.oas);
    paramParcel.writeString(this.oat);
    paramParcel.writeInt(this.oau);
    AppMethodBeat.o(49028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.Watcher
 * JD-Core Version:    0.7.0.1
 */