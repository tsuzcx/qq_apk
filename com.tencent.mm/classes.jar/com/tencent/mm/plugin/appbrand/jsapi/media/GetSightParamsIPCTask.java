package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.mmsight.SightParams;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "()V", "invoke", "data", "Companion", "TaskParams", "plugin-appbrand-integration_release"})
public final class GetSightParamsIPCTask
  implements i<TaskParams, SightParams>
{
  public static final GetSightParamsIPCTask.a hQz;
  
  static
  {
    AppMethodBeat.i(143814);
    hQz = new GetSightParamsIPCTask.a((byte)0);
    AppMethodBeat.o(143814);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sightMode", "", "maxDuration", "isFront", "", "(IIZ)V", "()Z", "getMaxDuration", "()I", "getSightMode", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  public static final class TaskParams
    implements Parcelable
  {
    public static final GetSightParamsIPCTask.TaskParams.a CREATOR;
    final int hQA;
    final boolean isFront;
    final int maxDuration;
    
    static
    {
      AppMethodBeat.i(143811);
      CREATOR = new GetSightParamsIPCTask.TaskParams.a((byte)0);
      AppMethodBeat.o(143811);
    }
    
    public TaskParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.hQA = paramInt1;
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
      boolean bool2 = false;
      boolean bool1;
      if (this != paramObject)
      {
        bool1 = bool2;
        if (!(paramObject instanceof TaskParams)) {
          break label85;
        }
        paramObject = (TaskParams)paramObject;
        if (this.hQA != paramObject.hQA) {
          break label87;
        }
        i = 1;
        bool1 = bool2;
        if (i == 0) {
          break label85;
        }
        if (this.maxDuration != paramObject.maxDuration) {
          break label92;
        }
        i = 1;
        label56:
        bool1 = bool2;
        if (i == 0) {
          break label85;
        }
        if (this.isFront != paramObject.isFront) {
          break label97;
        }
      }
      label85:
      label87:
      label92:
      label97:
      for (int i = 1;; i = 0)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
        return bool1;
        i = 0;
        break;
        i = 0;
        break label56;
      }
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(143812);
      String str = "TaskParams(sightMode=" + this.hQA + ", maxDuration=" + this.maxDuration + ", isFront=" + this.isFront + ")";
      AppMethodBeat.o(143812);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(143809);
      j.q(paramParcel, "dest");
      paramParcel.writeInt(this.hQA);
      paramParcel.writeInt(this.maxDuration);
      if (this.isFront) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(143809);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.GetSightParamsIPCTask
 * JD-Core Version:    0.7.0.1
 */