package com.tencent.mm.media.widget.camerarecordview.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.vfs.o;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "daemonVideoPath", "daemonSourceThumb", "daemonStartTime", "daemonEndTime", "photoPath", "photoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoList", "isLandscape", "extInfo", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLandroid/os/Bundle;)V", "getDaemonEndTime", "()I", "setDaemonEndTime", "(I)V", "getDaemonSourceThumb", "()Ljava/lang/String;", "setDaemonSourceThumb", "(Ljava/lang/String;)V", "getDaemonStartTime", "setDaemonStartTime", "getDaemonVideoPath", "setDaemonVideoPath", "getEndTime", "setEndTime", "getExtInfo", "()Landroid/os/Bundle;", "setExtInfo", "(Landroid/os/Bundle;)V", "()Z", "setCaptureVideo", "(Z)V", "setLandscape", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "getPhotoPath", "setPhotoPath", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "getVideoList", "setVideoList", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "enableBaseVideo", "enableDaemonVideo", "equals", "other", "getPreviewThumbUrl", "getPreviewUrl", "hashCode", "setImages", "", "imageList", "setVideos", "toString", "videoCheck", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a hwO;
  public int dez;
  public String hwB;
  public String hwC;
  public boolean hwD;
  public int hwE;
  public String hwF;
  public String hwG;
  public int hwH;
  public int hwI;
  public String hwJ;
  public ArrayList<String> hwK;
  public ArrayList<String> hwL;
  public boolean hwM;
  public Bundle hwN;
  
  static
  {
    AppMethodBeat.i(94282);
    hwO = new a((byte)0);
    AppMethodBeat.o(94282);
  }
  
  public b()
  {
    this(null, null, false, null, null, null, null, null, 16383);
  }
  
  private b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(94280);
    this.hwB = paramString1;
    this.hwC = paramString2;
    this.hwD = paramBoolean;
    this.dez = 0;
    this.hwE = 0;
    this.hwF = paramString3;
    this.hwG = paramString4;
    this.hwH = 0;
    this.hwI = 0;
    this.hwJ = paramString5;
    this.hwK = paramArrayList1;
    this.hwL = paramArrayList2;
    this.hwM = false;
    this.hwN = null;
    AppMethodBeat.o(94280);
  }
  
  public final boolean axQ()
  {
    AppMethodBeat.i(94274);
    if ((!TextUtils.isEmpty((CharSequence)this.hwF)) && (o.fB(this.hwF)))
    {
      AppMethodBeat.o(94274);
      return true;
    }
    AppMethodBeat.o(94274);
    return false;
  }
  
  public final boolean axR()
  {
    AppMethodBeat.i(94275);
    if ((!TextUtils.isEmpty((CharSequence)this.hwB)) && (o.fB(this.hwB)))
    {
      AppMethodBeat.o(94275);
      return true;
    }
    AppMethodBeat.o(94275);
    return false;
  }
  
  public final String axS()
  {
    AppMethodBeat.i(94276);
    if (axR())
    {
      str = this.hwB;
      AppMethodBeat.o(94276);
      return str;
    }
    String str = this.hwF;
    AppMethodBeat.o(94276);
    return str;
  }
  
  public final void axT()
  {
    AppMethodBeat.i(217545);
    if ((this.hwK.size() == 0) && (this.hwL.size() == 1))
    {
      this.hwB = ((String)j.jl((List)this.hwL));
      a locala = e.ayN(this.hwB);
      if (locala != null) {
        this.hwE = locala.videoDuration;
      }
    }
    AppMethodBeat.o(217545);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94285);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.hwB, paramObject.hwB)) || (!p.i(this.hwC, paramObject.hwC)) || (this.hwD != paramObject.hwD) || (this.dez != paramObject.dez) || (this.hwE != paramObject.hwE) || (!p.i(this.hwF, paramObject.hwF)) || (!p.i(this.hwG, paramObject.hwG)) || (this.hwH != paramObject.hwH) || (this.hwI != paramObject.hwI) || (!p.i(this.hwJ, paramObject.hwJ)) || (!p.i(this.hwK, paramObject.hwK)) || (!p.i(this.hwL, paramObject.hwL)) || (this.hwM != paramObject.hwM) || (!p.i(this.hwN, paramObject.hwN))) {}
      }
    }
    else
    {
      AppMethodBeat.o(94285);
      return true;
    }
    AppMethodBeat.o(94285);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void o(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(217546);
    p.h(paramArrayList, "<set-?>");
    this.hwK = paramArrayList;
    AppMethodBeat.o(217546);
  }
  
  public final void p(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(217547);
    p.h(paramArrayList, "<set-?>");
    this.hwL = paramArrayList;
    AppMethodBeat.o(217547);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94283);
    String str = "MediaCaptureInfo(sourceVideoPath=" + this.hwB + ", sourceThumb=" + this.hwC + ", isCaptureVideo=" + this.hwD + ", startTime=" + this.dez + ", endTime=" + this.hwE + ", daemonVideoPath=" + this.hwF + ", daemonSourceThumb=" + this.hwG + ", daemonStartTime=" + this.hwH + ", daemonEndTime=" + this.hwI + ", photoPath=" + this.hwJ + ", photoList=" + this.hwK + ", videoList=" + this.hwL + ", isLandscape=" + this.hwM + ", extInfo=" + this.hwN + ")";
    AppMethodBeat.o(94283);
    return str;
  }
  
  public final void yU(String paramString)
  {
    AppMethodBeat.i(94277);
    p.h(paramString, "<set-?>");
    this.hwB = paramString;
    AppMethodBeat.o(94277);
  }
  
  public final void yV(String paramString)
  {
    AppMethodBeat.i(94278);
    p.h(paramString, "<set-?>");
    this.hwC = paramString;
    AppMethodBeat.o(94278);
  }
  
  public final void yW(String paramString)
  {
    AppMethodBeat.i(94279);
    p.h(paramString, "<set-?>");
    this.hwJ = paramString;
    AppMethodBeat.o(94279);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo$Companion;", "", "()V", "getCapturePhotoInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "input", "", "getExternalPhotoInfo", "getExternalPhotosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExternalVideoInfo", "startTime", "", "endTime", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static b yX(String paramString)
    {
      AppMethodBeat.i(217544);
      p.h(paramString, "input");
      paramString = new b(null, null, true, null, null, paramString, null, null, 15867);
      AppMethodBeat.o(217544);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.b
 * JD-Core Version:    0.7.0.1
 */