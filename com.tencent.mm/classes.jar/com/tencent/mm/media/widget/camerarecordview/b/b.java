package com.tencent.mm.media.widget.camerarecordview.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "daemonVideoPath", "daemonSourceThumb", "daemonStartTime", "daemonEndTime", "photoPath", "photoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoList", "isLandscape", "extInfo", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLandroid/os/Bundle;)V", "getDaemonEndTime", "()I", "setDaemonEndTime", "(I)V", "getDaemonSourceThumb", "()Ljava/lang/String;", "setDaemonSourceThumb", "(Ljava/lang/String;)V", "getDaemonStartTime", "setDaemonStartTime", "getDaemonVideoPath", "setDaemonVideoPath", "getEndTime", "setEndTime", "getExtInfo", "()Landroid/os/Bundle;", "setExtInfo", "(Landroid/os/Bundle;)V", "()Z", "setCaptureVideo", "(Z)V", "setLandscape", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "getPhotoPath", "setPhotoPath", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "getVideoList", "setVideoList", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "enableBaseVideo", "enableDaemonVideo", "equals", "other", "getPreviewThumbUrl", "getPreviewUrl", "hashCode", "setImages", "", "imageList", "setVideos", "toString", "videoCheck", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a hbS;
  public int cSh;
  public String hbF;
  public String hbG;
  public boolean hbH;
  public int hbI;
  public String hbJ;
  public String hbK;
  public int hbL;
  public int hbM;
  public String hbN;
  public ArrayList<String> hbO;
  public ArrayList<String> hbP;
  public boolean hbQ;
  public Bundle hbR;
  
  static
  {
    AppMethodBeat.i(94282);
    hbS = new a((byte)0);
    AppMethodBeat.o(94282);
  }
  
  public b()
  {
    this(null, null, false, null, null, null, null, null, 16383);
  }
  
  private b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(94280);
    this.hbF = paramString1;
    this.hbG = paramString2;
    this.hbH = paramBoolean;
    this.cSh = 0;
    this.hbI = 0;
    this.hbJ = paramString3;
    this.hbK = paramString4;
    this.hbL = 0;
    this.hbM = 0;
    this.hbN = paramString5;
    this.hbO = paramArrayList1;
    this.hbP = paramArrayList2;
    this.hbQ = false;
    this.hbR = null;
    AppMethodBeat.o(94280);
  }
  
  public final boolean auO()
  {
    AppMethodBeat.i(94274);
    if ((!TextUtils.isEmpty((CharSequence)this.hbJ)) && (i.eA(this.hbJ)))
    {
      AppMethodBeat.o(94274);
      return true;
    }
    AppMethodBeat.o(94274);
    return false;
  }
  
  public final boolean auP()
  {
    AppMethodBeat.i(94275);
    if ((!TextUtils.isEmpty((CharSequence)this.hbF)) && (i.eA(this.hbF)))
    {
      AppMethodBeat.o(94275);
      return true;
    }
    AppMethodBeat.o(94275);
    return false;
  }
  
  public final String auQ()
  {
    AppMethodBeat.i(94276);
    if (auP())
    {
      str = this.hbF;
      AppMethodBeat.o(94276);
      return str;
    }
    String str = this.hbJ;
    AppMethodBeat.o(94276);
    return str;
  }
  
  public final void auR()
  {
    AppMethodBeat.i(209924);
    if ((this.hbO.size() == 0) && (this.hbP.size() == 1))
    {
      this.hbF = ((String)j.iO((List)this.hbP));
      a locala = e.asx(this.hbF);
      if (locala != null) {
        this.hbI = locala.videoDuration;
      }
    }
    AppMethodBeat.o(209924);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94285);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!k.g(this.hbF, paramObject.hbF)) || (!k.g(this.hbG, paramObject.hbG)) || (this.hbH != paramObject.hbH) || (this.cSh != paramObject.cSh) || (this.hbI != paramObject.hbI) || (!k.g(this.hbJ, paramObject.hbJ)) || (!k.g(this.hbK, paramObject.hbK)) || (this.hbL != paramObject.hbL) || (this.hbM != paramObject.hbM) || (!k.g(this.hbN, paramObject.hbN)) || (!k.g(this.hbO, paramObject.hbO)) || (!k.g(this.hbP, paramObject.hbP)) || (this.hbQ != paramObject.hbQ) || (!k.g(this.hbR, paramObject.hbR))) {}
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
    AppMethodBeat.i(209925);
    k.h(paramArrayList, "<set-?>");
    this.hbO = paramArrayList;
    AppMethodBeat.o(209925);
  }
  
  public final void p(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(209926);
    k.h(paramArrayList, "<set-?>");
    this.hbP = paramArrayList;
    AppMethodBeat.o(209926);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94283);
    String str = "MediaCaptureInfo(sourceVideoPath=" + this.hbF + ", sourceThumb=" + this.hbG + ", isCaptureVideo=" + this.hbH + ", startTime=" + this.cSh + ", endTime=" + this.hbI + ", daemonVideoPath=" + this.hbJ + ", daemonSourceThumb=" + this.hbK + ", daemonStartTime=" + this.hbL + ", daemonEndTime=" + this.hbM + ", photoPath=" + this.hbN + ", photoList=" + this.hbO + ", videoList=" + this.hbP + ", isLandscape=" + this.hbQ + ", extInfo=" + this.hbR + ")";
    AppMethodBeat.o(94283);
    return str;
  }
  
  public final void vt(String paramString)
  {
    AppMethodBeat.i(94277);
    k.h(paramString, "<set-?>");
    this.hbF = paramString;
    AppMethodBeat.o(94277);
  }
  
  public final void vu(String paramString)
  {
    AppMethodBeat.i(94278);
    k.h(paramString, "<set-?>");
    this.hbG = paramString;
    AppMethodBeat.o(94278);
  }
  
  public final void vv(String paramString)
  {
    AppMethodBeat.i(94279);
    k.h(paramString, "<set-?>");
    this.hbN = paramString;
    AppMethodBeat.o(94279);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo$Companion;", "", "()V", "getCapturePhotoInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "input", "", "getExternalPhotoInfo", "getExternalPhotosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExternalVideoInfo", "startTime", "", "endTime", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static b vw(String paramString)
    {
      AppMethodBeat.i(209923);
      k.h(paramString, "input");
      paramString = new b(null, null, true, null, null, paramString, null, null, 15867);
      AppMethodBeat.o(209923);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.b
 * JD-Core Version:    0.7.0.1
 */