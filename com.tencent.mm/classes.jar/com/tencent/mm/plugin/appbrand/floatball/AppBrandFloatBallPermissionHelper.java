package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.ball.f.c;
import com.tencent.mm.plugin.ball.f.c.a;

public final class AppBrandFloatBallPermissionHelper
{
  public static void a(Context paramContext, int paramInt, c.a parama)
  {
    AppMethodBeat.i(44992);
    CheckFloatBallPermissionRequest localCheckFloatBallPermissionRequest = new CheckFloatBallPermissionRequest();
    localCheckFloatBallPermissionRequest.lqH = paramInt;
    a.a(paramContext, localCheckFloatBallPermissionRequest, new AppBrandProxyUIProcessTask.b() {});
    AppMethodBeat.o(44992);
  }
  
  static final class CheckFloatBallPermissionRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<CheckFloatBallPermissionRequest> CREATOR;
    int lqH;
    
    static
    {
      AppMethodBeat.i(44984);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44984);
    }
    
    CheckFloatBallPermissionRequest() {}
    
    CheckFloatBallPermissionRequest(Parcel paramParcel)
    {
      super();
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bCJ()
    {
      return AppBrandFloatBallPermissionHelper.a.class;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      AppMethodBeat.i(44982);
      this.lqH = paramParcel.readInt();
      AppMethodBeat.o(44982);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44983);
      paramParcel.writeInt(this.lqH);
      AppMethodBeat.o(44983);
    }
  }
  
  static final class CheckFloatBallPermissionResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<CheckFloatBallPermissionResult> CREATOR;
    boolean dHF;
    
    static
    {
      AppMethodBeat.i(44988);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44988);
    }
    
    CheckFloatBallPermissionResult() {}
    
    CheckFloatBallPermissionResult(Parcel paramParcel)
    {
      super();
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(44986);
      if (paramParcel.readByte() == 1) {}
      for (;;)
      {
        this.dHF = bool;
        AppMethodBeat.o(44986);
        return;
        bool = false;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44987);
      if (this.dHF) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(44987);
        return;
      }
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(44990);
      if (!(paramProcessRequest instanceof AppBrandFloatBallPermissionHelper.CheckFloatBallPermissionRequest))
      {
        AppMethodBeat.o(44990);
        return;
      }
      int i = ((AppBrandFloatBallPermissionHelper.CheckFloatBallPermissionRequest)paramProcessRequest).lqH;
      c.a(bDF(), i, false, new c.a()
      {
        public final void ha(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(44989);
          AppBrandFloatBallPermissionHelper.CheckFloatBallPermissionResult localCheckFloatBallPermissionResult = new AppBrandFloatBallPermissionHelper.CheckFloatBallPermissionResult();
          localCheckFloatBallPermissionResult.dHF = paramAnonymousBoolean;
          AppBrandFloatBallPermissionHelper.a.a(AppBrandFloatBallPermissionHelper.a.this, localCheckFloatBallPermissionResult);
          AppMethodBeat.o(44989);
        }
      });
      AppMethodBeat.o(44990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper
 * JD-Core Version:    0.7.0.1
 */