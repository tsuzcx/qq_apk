package com.tencent.mm.media.widget.camerarecordview.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "daemonVideoPath", "daemonSourceThumb", "daemonStartTime", "daemonEndTime", "photoPath", "photoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoList", "isLandscape", "extInfo", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLandroid/os/Bundle;)V", "getDaemonEndTime", "()I", "setDaemonEndTime", "(I)V", "getDaemonSourceThumb", "()Ljava/lang/String;", "setDaemonSourceThumb", "(Ljava/lang/String;)V", "getDaemonStartTime", "setDaemonStartTime", "getDaemonVideoPath", "setDaemonVideoPath", "getEndTime", "setEndTime", "getExtInfo", "()Landroid/os/Bundle;", "setExtInfo", "(Landroid/os/Bundle;)V", "()Z", "setCaptureVideo", "(Z)V", "setLandscape", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "getPhotoPath", "setPhotoPath", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "getVideoList", "setVideoList", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "enableBaseVideo", "enableDaemonVideo", "equals", "other", "getPreviewThumbUrl", "getPreviewUrl", "hashCode", "setImages", "", "imageList", "setVideos", "toString", "videoCheck", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a hua;
  public int ddx;
  public String htN;
  public String htO;
  public boolean htP;
  public int htQ;
  public String htR;
  public String htS;
  public int htT;
  public int htU;
  public String htV;
  public ArrayList<String> htW;
  public ArrayList<String> htX;
  public boolean htY;
  public Bundle htZ;
  
  static
  {
    AppMethodBeat.i(94282);
    hua = new a((byte)0);
    AppMethodBeat.o(94282);
  }
  
  public b()
  {
    this(null, null, false, null, null, null, null, null, 16383);
  }
  
  private b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(94280);
    this.htN = paramString1;
    this.htO = paramString2;
    this.htP = paramBoolean;
    this.ddx = 0;
    this.htQ = 0;
    this.htR = paramString3;
    this.htS = paramString4;
    this.htT = 0;
    this.htU = 0;
    this.htV = paramString5;
    this.htW = paramArrayList1;
    this.htX = paramArrayList2;
    this.htY = false;
    this.htZ = null;
    AppMethodBeat.o(94280);
  }
  
  public final boolean axB()
  {
    AppMethodBeat.i(94274);
    if ((!TextUtils.isEmpty((CharSequence)this.htR)) && (i.fv(this.htR)))
    {
      AppMethodBeat.o(94274);
      return true;
    }
    AppMethodBeat.o(94274);
    return false;
  }
  
  public final boolean axC()
  {
    AppMethodBeat.i(94275);
    if ((!TextUtils.isEmpty((CharSequence)this.htN)) && (i.fv(this.htN)))
    {
      AppMethodBeat.o(94275);
      return true;
    }
    AppMethodBeat.o(94275);
    return false;
  }
  
  public final String axD()
  {
    AppMethodBeat.i(94276);
    if (axC())
    {
      str = this.htN;
      AppMethodBeat.o(94276);
      return str;
    }
    String str = this.htR;
    AppMethodBeat.o(94276);
    return str;
  }
  
  public final void axE()
  {
    AppMethodBeat.i(219319);
    if ((this.htW.size() == 0) && (this.htX.size() == 1))
    {
      this.htN = ((String)j.jc((List)this.htX));
      a locala = e.axx(this.htN);
      if (locala != null) {
        this.htQ = locala.videoDuration;
      }
    }
    AppMethodBeat.o(219319);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94285);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.htN, paramObject.htN)) || (!p.i(this.htO, paramObject.htO)) || (this.htP != paramObject.htP) || (this.ddx != paramObject.ddx) || (this.htQ != paramObject.htQ) || (!p.i(this.htR, paramObject.htR)) || (!p.i(this.htS, paramObject.htS)) || (this.htT != paramObject.htT) || (this.htU != paramObject.htU) || (!p.i(this.htV, paramObject.htV)) || (!p.i(this.htW, paramObject.htW)) || (!p.i(this.htX, paramObject.htX)) || (this.htY != paramObject.htY) || (!p.i(this.htZ, paramObject.htZ))) {}
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
    AppMethodBeat.i(219320);
    p.h(paramArrayList, "<set-?>");
    this.htW = paramArrayList;
    AppMethodBeat.o(219320);
  }
  
  public final void p(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(219321);
    p.h(paramArrayList, "<set-?>");
    this.htX = paramArrayList;
    AppMethodBeat.o(219321);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94283);
    String str = "MediaCaptureInfo(sourceVideoPath=" + this.htN + ", sourceThumb=" + this.htO + ", isCaptureVideo=" + this.htP + ", startTime=" + this.ddx + ", endTime=" + this.htQ + ", daemonVideoPath=" + this.htR + ", daemonSourceThumb=" + this.htS + ", daemonStartTime=" + this.htT + ", daemonEndTime=" + this.htU + ", photoPath=" + this.htV + ", photoList=" + this.htW + ", videoList=" + this.htX + ", isLandscape=" + this.htY + ", extInfo=" + this.htZ + ")";
    AppMethodBeat.o(94283);
    return str;
  }
  
  public final void yk(String paramString)
  {
    AppMethodBeat.i(94277);
    p.h(paramString, "<set-?>");
    this.htN = paramString;
    AppMethodBeat.o(94277);
  }
  
  public final void yl(String paramString)
  {
    AppMethodBeat.i(94278);
    p.h(paramString, "<set-?>");
    this.htO = paramString;
    AppMethodBeat.o(94278);
  }
  
  public final void ym(String paramString)
  {
    AppMethodBeat.i(94279);
    p.h(paramString, "<set-?>");
    this.htV = paramString;
    AppMethodBeat.o(94279);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo$Companion;", "", "()V", "getCapturePhotoInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "input", "", "getExternalPhotoInfo", "getExternalPhotosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExternalVideoInfo", "startTime", "", "endTime", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static b yn(String paramString)
    {
      AppMethodBeat.i(219318);
      p.h(paramString, "input");
      paramString = new b(null, null, true, null, null, paramString, null, null, 15867);
      AppMethodBeat.o(219318);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.b
 * JD-Core Version:    0.7.0.1
 */