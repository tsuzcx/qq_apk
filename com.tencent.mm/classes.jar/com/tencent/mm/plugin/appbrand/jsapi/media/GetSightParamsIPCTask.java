package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.mmsight.SightParams;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "()V", "invoke", "data", "Companion", "TaskParams", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GetSightParamsIPCTask
  implements m<TaskParams, SightParams>
{
  public static final a sfl;
  
  static
  {
    AppMethodBeat.i(50551);
    sfl = new a((byte)0);
    AppMethodBeat.o(50551);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sightMode", "", "maxDuration", "isFront", "", "(IIZ)V", "()Z", "getMaxDuration", "()I", "getSightMode", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class TaskParams
    implements Parcelable
  {
    public static final a CREATOR;
    final boolean isFront;
    final int maxDuration;
    final int sfm;
    
    static
    {
      AppMethodBeat.i(50548);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(50548);
    }
    
    public TaskParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.sfm = paramInt1;
      this.maxDuration = paramInt2;
      this.isFront = paramBoolean;
    }
    
    public TaskParams(Parcel paramParcel) {}
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof TaskParams)) {
          return false;
        }
        paramObject = (TaskParams)paramObject;
        if (this.sfm != paramObject.sfm) {
          return false;
        }
        if (this.maxDuration != paramObject.maxDuration) {
          return false;
        }
      } while (this.isFront == paramObject.isFront);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50549);
      String str = "TaskParams(sightMode=" + this.sfm + ", maxDuration=" + this.maxDuration + ", isFront=" + this.isFront + ')';
      AppMethodBeat.o(50549);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50546);
      s.u(paramParcel, "dest");
      paramParcel.writeInt(this.sfm);
      paramParcel.writeInt(this.maxDuration);
      if (this.isFront) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(50546);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<GetSightParamsIPCTask.TaskParams>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$Companion;", "", "()V", "getSightParams", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "sightMode", "", "maxDuration", "isFront", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static SightParams q(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(180477);
      Object localObject = XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new GetSightParamsIPCTask.TaskParams(paramInt1, paramInt2, paramBoolean), GetSightParamsIPCTask.class);
      s.s(localObject, "invokeSync(\n            …aramsIPCTask::class.java)");
      localObject = (SightParams)localObject;
      AppMethodBeat.o(180477);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.GetSightParamsIPCTask
 * JD-Core Version:    0.7.0.1
 */