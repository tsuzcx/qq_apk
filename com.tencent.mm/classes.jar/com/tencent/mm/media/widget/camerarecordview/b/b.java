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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "daemonVideoPath", "daemonSourceThumb", "daemonStartTime", "daemonEndTime", "photoPath", "photoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoList", "isLandscape", "extInfo", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLandroid/os/Bundle;)V", "getDaemonEndTime", "()I", "setDaemonEndTime", "(I)V", "getDaemonSourceThumb", "()Ljava/lang/String;", "setDaemonSourceThumb", "(Ljava/lang/String;)V", "getDaemonStartTime", "setDaemonStartTime", "getDaemonVideoPath", "setDaemonVideoPath", "getEndTime", "setEndTime", "getExtInfo", "()Landroid/os/Bundle;", "setExtInfo", "(Landroid/os/Bundle;)V", "()Z", "setCaptureVideo", "(Z)V", "setLandscape", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "getPhotoPath", "setPhotoPath", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "getVideoList", "setVideoList", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "enableBaseVideo", "enableDaemonVideo", "equals", "other", "getPreviewThumbUrl", "getPreviewUrl", "hashCode", "setImages", "", "imageList", "setVideos", "toString", "videoCheck", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a gBv;
  public Bundle Cos;
  public int cUL;
  public String gBj;
  public String gBk;
  public boolean gBl;
  public int gBm;
  public String gBn;
  public String gBo;
  public int gBp;
  public int gBq;
  public String gBr;
  public ArrayList<String> gBs;
  public ArrayList<String> gBt;
  public boolean gBu;
  
  static
  {
    AppMethodBeat.i(94282);
    gBv = new a((byte)0);
    AppMethodBeat.o(94282);
  }
  
  public b()
  {
    this(null, null, false, null, null, null, null, null, 16383);
  }
  
  private b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(94280);
    this.gBj = paramString1;
    this.gBk = paramString2;
    this.gBl = paramBoolean;
    this.cUL = 0;
    this.gBm = 0;
    this.gBn = paramString3;
    this.gBo = paramString4;
    this.gBp = 0;
    this.gBq = 0;
    this.gBr = paramString5;
    this.gBs = paramArrayList1;
    this.gBt = paramArrayList2;
    this.gBu = false;
    this.Cos = null;
    AppMethodBeat.o(94280);
  }
  
  public final void aS(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(205888);
    k.h(paramArrayList, "<set-?>");
    this.gBs = paramArrayList;
    AppMethodBeat.o(205888);
  }
  
  public final void aU(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(205889);
    k.h(paramArrayList, "<set-?>");
    this.gBt = paramArrayList;
    AppMethodBeat.o(205889);
  }
  
  public final boolean anY()
  {
    AppMethodBeat.i(94274);
    if ((!TextUtils.isEmpty((CharSequence)this.gBn)) && (i.eK(this.gBn)))
    {
      AppMethodBeat.o(94274);
      return true;
    }
    AppMethodBeat.o(94274);
    return false;
  }
  
  public final boolean anZ()
  {
    AppMethodBeat.i(94275);
    if ((!TextUtils.isEmpty((CharSequence)this.gBj)) && (i.eK(this.gBj)))
    {
      AppMethodBeat.o(94275);
      return true;
    }
    AppMethodBeat.o(94275);
    return false;
  }
  
  public final String aoa()
  {
    AppMethodBeat.i(94276);
    if (anZ())
    {
      str = this.gBj;
      AppMethodBeat.o(94276);
      return str;
    }
    String str = this.gBn;
    AppMethodBeat.o(94276);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94285);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!k.g(this.gBj, paramObject.gBj)) || (!k.g(this.gBk, paramObject.gBk)) || (this.gBl != paramObject.gBl) || (this.cUL != paramObject.cUL) || (this.gBm != paramObject.gBm) || (!k.g(this.gBn, paramObject.gBn)) || (!k.g(this.gBo, paramObject.gBo)) || (this.gBp != paramObject.gBp) || (this.gBq != paramObject.gBq) || (!k.g(this.gBr, paramObject.gBr)) || (!k.g(this.gBs, paramObject.gBs)) || (!k.g(this.gBt, paramObject.gBt)) || (this.gBu != paramObject.gBu) || (!k.g(this.Cos, paramObject.Cos))) {}
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
  
  public final void fQH()
  {
    AppMethodBeat.i(205887);
    if ((this.gBs.size() == 0) && (this.gBt.size() == 1))
    {
      this.gBj = ((String)j.iy((List)this.gBt));
      a locala = e.ano(this.gBj);
      if (locala != null) {
        this.gBm = locala.videoDuration;
      }
    }
    AppMethodBeat.o(205887);
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void rr(String paramString)
  {
    AppMethodBeat.i(94277);
    k.h(paramString, "<set-?>");
    this.gBj = paramString;
    AppMethodBeat.o(94277);
  }
  
  public final void rs(String paramString)
  {
    AppMethodBeat.i(94278);
    k.h(paramString, "<set-?>");
    this.gBk = paramString;
    AppMethodBeat.o(94278);
  }
  
  public final void rt(String paramString)
  {
    AppMethodBeat.i(94279);
    k.h(paramString, "<set-?>");
    this.gBr = paramString;
    AppMethodBeat.o(94279);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94283);
    String str = "MediaCaptureInfo(sourceVideoPath=" + this.gBj + ", sourceThumb=" + this.gBk + ", isCaptureVideo=" + this.gBl + ", startTime=" + this.cUL + ", endTime=" + this.gBm + ", daemonVideoPath=" + this.gBn + ", daemonSourceThumb=" + this.gBo + ", daemonStartTime=" + this.gBp + ", daemonEndTime=" + this.gBq + ", photoPath=" + this.gBr + ", photoList=" + this.gBs + ", videoList=" + this.gBt + ", isLandscape=" + this.gBu + ", extInfo=" + this.Cos + ")";
    AppMethodBeat.o(94283);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo$Companion;", "", "()V", "getCapturePhotoInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "input", "", "getExternalPhotoInfo", "getExternalPhotosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExternalVideoInfo", "startTime", "", "endTime", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static b aUx(String paramString)
    {
      AppMethodBeat.i(205886);
      k.h(paramString, "input");
      paramString = new b(null, null, true, null, null, paramString, null, null, 15867);
      AppMethodBeat.o(205886);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.b
 * JD-Core Version:    0.7.0.1
 */