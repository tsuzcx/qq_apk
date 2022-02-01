package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.mmsight.SightParams;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "()V", "invoke", "data", "Companion", "TaskParams", "plugin-appbrand-integration_release"})
public final class GetSightParamsIPCTask
  implements com.tencent.mm.ipcinvoker.k<TaskParams, SightParams>
{
  public static final a jWo;
  
  static
  {
    AppMethodBeat.i(50551);
    jWo = new a((byte)0);
    AppMethodBeat.o(50551);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sightMode", "", "maxDuration", "isFront", "", "(IIZ)V", "()Z", "getMaxDuration", "()I", "getSightMode", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  public static final class TaskParams
    implements Parcelable
  {
    public static final a CREATOR;
    final boolean isFront;
    final int jWp;
    final int maxDuration;
    
    static
    {
      AppMethodBeat.i(50548);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(50548);
    }
    
    public TaskParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.jWp = paramInt1;
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
      if (this != paramObject)
      {
        if ((paramObject instanceof TaskParams))
        {
          paramObject = (TaskParams)paramObject;
          if ((this.jWp != paramObject.jWp) || (this.maxDuration != paramObject.maxDuration) || (this.isFront != paramObject.isFront)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(50549);
      String str = "TaskParams(sightMode=" + this.jWp + ", maxDuration=" + this.maxDuration + ", isFront=" + this.isFront + ")";
      AppMethodBeat.o(50549);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50546);
      d.g.b.k.h(paramParcel, "dest");
      paramParcel.writeInt(this.jWp);
      paramParcel.writeInt(this.maxDuration);
      if (this.isFront) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(50546);
        return;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<GetSightParamsIPCTask.TaskParams>
    {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$Companion;", "", "()V", "getSightParams", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "sightMode", "", "maxDuration", "isFront", "", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static SightParams o(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(180477);
      Object localObject = XIPCInvoker.a("com.tencent.mm", new GetSightParamsIPCTask.TaskParams(paramInt1, paramInt2, paramBoolean), GetSightParamsIPCTask.class);
      d.g.b.k.g(localObject, "XIPCInvoker.invokeSync(\n…aramsIPCTask::class.java)");
      localObject = (SightParams)localObject;
      AppMethodBeat.o(180477);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.GetSightParamsIPCTask
 * JD-Core Version:    0.7.0.1
 */