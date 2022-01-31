package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Locale;

public final class AppBrandPreInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR = new AppBrandPreInitTask.3();
  private String appId;
  private int fJy;
  private AppBrandStatObject fPE;
  private transient AppBrandPreInitTask.a gJd;
  private ActivityStarterIpcDelegate gJe;
  private AppBrandInitConfigWC gJf;
  
  public AppBrandPreInitTask(Context paramContext, String paramString, int paramInt, AppBrandStatObject paramAppBrandStatObject, AppBrandPreInitTask.a parama)
  {
    this.appId = paramString;
    this.fJy = paramInt;
    this.fPE = paramAppBrandStatObject;
    this.gJd = parama;
    if ((paramContext instanceof Activity))
    {
      this.gJe = new ActivityStarterIpcDelegate((Activity)paramContext);
      return;
    }
    this.gJe = null;
  }
  
  private AppBrandPreInitTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    c localc = new c(this.appId, this.fJy, this.fPE, this.gJe, new c.a()
    {
      public final void c(AppBrandInitConfigWC paramAnonymousAppBrandInitConfigWC, AppBrandStatObject paramAnonymousAppBrandStatObject)
      {
        AppBrandPreInitTask.a(AppBrandPreInitTask.this, paramAnonymousAppBrandInitConfigWC);
        AppBrandPreInitTask.a(AppBrandPreInitTask.this, paramAnonymousAppBrandStatObject);
        if (paramAnonymousAppBrandInitConfigWC != null) {
          b.b(paramAnonymousAppBrandInitConfigWC, paramAnonymousAppBrandStatObject);
        }
        AppBrandPreInitTask.a(AppBrandPreInitTask.this);
      }
    });
    new ai(String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { this.appId, Integer.valueOf(this.fJy) })).O(new AppBrandPreInitTask.2(this, localc));
  }
  
  public final void Zv()
  {
    if (this.gJd != null) {
      this.gJd.a(this.gJf, this.fPE);
    }
    ahD();
  }
  
  public final void alC()
  {
    ahC();
    AppBrandMainProcessService.a(this);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.fJy = paramParcel.readInt();
    this.gJf = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfig.class.getClassLoader()));
    this.fPE = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.gJe = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.fJy);
    paramParcel.writeParcelable(this.gJf, paramInt);
    paramParcel.writeParcelable(this.fPE, paramInt);
    paramParcel.writeParcelable(this.gJe, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask
 * JD-Core Version:    0.7.0.1
 */