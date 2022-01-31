package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

final class AppBrandStickyBannerLogic$Watcher
  extends MainProcessTask
{
  public static final Parcelable.Creator<Watcher> CREATOR = new AppBrandStickyBannerLogic.Watcher.2();
  private static final transient Map<String, f> hfV = new HashMap();
  String hfS;
  String hfT;
  int hfU;
  
  public final void Zu()
  {
    if (bk.bl(this.hfS)) {
      return;
    }
    synchronized (hfV)
    {
      if (hfV.containsKey(this.hfS)) {
        AppBrandStickyBannerLogic.b.c((f)hfV.get(this.hfS));
      }
      AppBrandStickyBannerLogic.Watcher.1 local1 = new AppBrandStickyBannerLogic.Watcher.1(this);
      AppBrandStickyBannerLogic.b.d(local1);
      hfV.put(this.hfS, local1);
      return;
    }
  }
  
  public final void Zv()
  {
    AppBrandStickyBannerLogic.a.bc(this.hfT, this.hfU);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.hfS = paramParcel.readString();
    this.hfT = paramParcel.readString();
    this.hfU = paramParcel.readInt();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.hfS);
    paramParcel.writeString(this.hfT);
    paramParcel.writeInt(this.hfU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.Watcher
 * JD-Core Version:    0.7.0.1
 */