package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class AppBrandStickyBannerLogic$Watcher
  extends MainProcessTask
{
  public static final Parcelable.Creator<Watcher> CREATOR;
  private static final transient Map<String, f> iRj;
  String iRg;
  String iRh;
  int iRi;
  
  static
  {
    AppMethodBeat.i(133312);
    iRj = new HashMap();
    CREATOR = new AppBrandStickyBannerLogic.Watcher.2();
    AppMethodBeat.o(133312);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(133307);
    if (bo.isNullOrNil(this.iRg))
    {
      AppMethodBeat.o(133307);
      return;
    }
    synchronized (iRj)
    {
      if (iRj.containsKey(this.iRg)) {
        AppBrandStickyBannerLogic.b.c((f)iRj.get(this.iRg));
      }
      AppBrandStickyBannerLogic.Watcher.1 local1 = new AppBrandStickyBannerLogic.Watcher.1(this);
      AppBrandStickyBannerLogic.b.d(local1);
      iRj.put(this.iRg, local1);
      AppMethodBeat.o(133307);
      return;
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(133308);
    AppBrandStickyBannerLogic.a.bx(this.iRh, this.iRi);
    AppMethodBeat.o(133308);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(133310);
    this.iRg = paramParcel.readString();
    this.iRh = paramParcel.readString();
    this.iRi = paramParcel.readInt();
    AppMethodBeat.o(133310);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(133309);
    paramParcel.writeString(this.iRg);
    paramParcel.writeString(this.iRh);
    paramParcel.writeInt(this.iRi);
    AppMethodBeat.o(133309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.Watcher
 * JD-Core Version:    0.7.0.1
 */