package com.tencent.mm.media.widget.camerarecordview.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "photoPath", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;)V", "getEndTime", "()I", "setEndTime", "(I)V", "()Z", "setCaptureVideo", "(Z)V", "getPhotoPath", "()Ljava/lang/String;", "setPhotoPath", "(Ljava/lang/String;)V", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final b.a fbr;
  public int endTime;
  public String fbn;
  public String fbo;
  public boolean fbp;
  public String fbq;
  public int startTime;
  
  static
  {
    AppMethodBeat.i(152138);
    fbr = new b.a((byte)0);
    AppMethodBeat.o(152138);
  }
  
  public b()
  {
    this(null, null, false, 0, null, 63);
  }
  
  private b(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3)
  {
    AppMethodBeat.i(152136);
    this.fbn = paramString1;
    this.fbo = paramString2;
    this.fbp = paramBoolean;
    this.startTime = 0;
    this.endTime = paramInt;
    this.fbq = paramString3;
    AppMethodBeat.o(152136);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(152141);
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label137;
      }
      paramObject = (b)paramObject;
      if ((!j.e(this.fbn, paramObject.fbn)) || (!j.e(this.fbo, paramObject.fbo))) {
        break label137;
      }
      if (this.fbp != paramObject.fbp) {
        break label122;
      }
      i = 1;
      if (i == 0) {
        break label137;
      }
      if (this.startTime != paramObject.startTime) {
        break label127;
      }
      i = 1;
      label80:
      if (i == 0) {
        break label137;
      }
      if (this.endTime != paramObject.endTime) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!j.e(this.fbq, paramObject.fbq))) {
        break label137;
      }
      AppMethodBeat.o(152141);
      return true;
      label122:
      i = 0;
      break;
      label127:
      i = 0;
      break label80;
    }
    label137:
    AppMethodBeat.o(152141);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152139);
    String str = "MediaCaptureInfo(sourceVideoPath=" + this.fbn + ", sourceThumb=" + this.fbo + ", isCaptureVideo=" + this.fbp + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", photoPath=" + this.fbq + ")";
    AppMethodBeat.o(152139);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.b
 * JD-Core Version:    0.7.0.1
 */