package com.tencent.mm.media.widget.camerarecordview.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "daemonVideoPath", "daemonSourceThumb", "daemonStartTime", "daemonEndTime", "photoPath", "photoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoList", "isLandscape", "extInfo", "Landroid/os/Bundle;", "rect", "Landroid/graphics/Rect;", "backgroundColor", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLandroid/os/Bundle;Landroid/graphics/Rect;I)V", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "getDaemonEndTime", "setDaemonEndTime", "getDaemonSourceThumb", "()Ljava/lang/String;", "setDaemonSourceThumb", "(Ljava/lang/String;)V", "getDaemonStartTime", "setDaemonStartTime", "getDaemonVideoPath", "setDaemonVideoPath", "getEndTime", "setEndTime", "getExtInfo", "()Landroid/os/Bundle;", "setExtInfo", "(Landroid/os/Bundle;)V", "()Z", "setCaptureVideo", "(Z)V", "setLandscape", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "getPhotoPath", "setPhotoPath", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "getVideoList", "setVideoList", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "enableBaseVideo", "enableDaemonVideo", "equals", "other", "getPreviewThumbUrl", "getPreviewUrl", "hashCode", "setImages", "", "imageList", "setVideos", "toString", "videoCheck", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a lfv;
  public int backgroundColor;
  public Rect byG;
  public int endTime;
  public int fod;
  public String lfj;
  public String lfk;
  public boolean lfl;
  public String lfm;
  public String lfn;
  public int lfo;
  public int lfp;
  public String lfq;
  public ArrayList<String> lfr;
  public ArrayList<String> lfs;
  public boolean lft;
  public Bundle lfu;
  
  static
  {
    AppMethodBeat.i(94282);
    lfv = new a((byte)0);
    AppMethodBeat.o(94282);
  }
  
  public b()
  {
    this(null, null, false, null, null, null, null, null, null, 65535);
  }
  
  private b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, Rect paramRect)
  {
    AppMethodBeat.i(261345);
    this.lfj = paramString1;
    this.lfk = paramString2;
    this.lfl = paramBoolean;
    this.fod = 0;
    this.endTime = 0;
    this.lfm = paramString3;
    this.lfn = paramString4;
    this.lfo = 0;
    this.lfp = 0;
    this.lfq = paramString5;
    this.lfr = paramArrayList1;
    this.lfs = paramArrayList2;
    this.lft = false;
    this.lfu = null;
    this.byG = paramRect;
    this.backgroundColor = 0;
    AppMethodBeat.o(261345);
  }
  
  public final void OJ(String paramString)
  {
    AppMethodBeat.i(94277);
    p.k(paramString, "<set-?>");
    this.lfj = paramString;
    AppMethodBeat.o(94277);
  }
  
  public final void OK(String paramString)
  {
    AppMethodBeat.i(94278);
    p.k(paramString, "<set-?>");
    this.lfk = paramString;
    AppMethodBeat.o(94278);
  }
  
  public final void OL(String paramString)
  {
    AppMethodBeat.i(94279);
    p.k(paramString, "<set-?>");
    this.lfq = paramString;
    AppMethodBeat.o(94279);
  }
  
  public final boolean aZf()
  {
    AppMethodBeat.i(94274);
    if ((!TextUtils.isEmpty((CharSequence)this.lfm)) && (u.agG(this.lfm)))
    {
      AppMethodBeat.o(94274);
      return true;
    }
    AppMethodBeat.o(94274);
    return false;
  }
  
  public final boolean aZg()
  {
    AppMethodBeat.i(94275);
    if ((!TextUtils.isEmpty((CharSequence)this.lfj)) && (u.agG(this.lfj)))
    {
      AppMethodBeat.o(94275);
      return true;
    }
    AppMethodBeat.o(94275);
    return false;
  }
  
  public final String aZh()
  {
    AppMethodBeat.i(94276);
    if (aZg())
    {
      str = this.lfj;
      AppMethodBeat.o(94276);
      return str;
    }
    String str = this.lfm;
    AppMethodBeat.o(94276);
    return str;
  }
  
  public final String aZi()
  {
    AppMethodBeat.i(261329);
    if (aZg())
    {
      str = this.lfk;
      AppMethodBeat.o(261329);
      return str;
    }
    String str = this.lfn;
    AppMethodBeat.o(261329);
    return str;
  }
  
  public final void aZj()
  {
    AppMethodBeat.i(261332);
    if ((this.lfr.size() == 0) && (this.lfs.size() == 1))
    {
      this.lfj = ((String)j.lo((List)this.lfs));
      com.tencent.mm.plugin.sight.base.b localb = f.aYg(this.lfj);
      if (localb != null) {
        this.endTime = localb.videoDuration;
      }
    }
    AppMethodBeat.o(261332);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94285);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.lfj, paramObject.lfj)) || (!p.h(this.lfk, paramObject.lfk)) || (this.lfl != paramObject.lfl) || (this.fod != paramObject.fod) || (this.endTime != paramObject.endTime) || (!p.h(this.lfm, paramObject.lfm)) || (!p.h(this.lfn, paramObject.lfn)) || (this.lfo != paramObject.lfo) || (this.lfp != paramObject.lfp) || (!p.h(this.lfq, paramObject.lfq)) || (!p.h(this.lfr, paramObject.lfr)) || (!p.h(this.lfs, paramObject.lfs)) || (this.lft != paramObject.lft) || (!p.h(this.lfu, paramObject.lfu)) || (!p.h(this.byG, paramObject.byG)) || (this.backgroundColor != paramObject.backgroundColor)) {}
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
  
  public final void s(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(261339);
    p.k(paramArrayList, "<set-?>");
    this.lfr = paramArrayList;
    AppMethodBeat.o(261339);
  }
  
  public final void t(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(261342);
    p.k(paramArrayList, "<set-?>");
    this.lfs = paramArrayList;
    AppMethodBeat.o(261342);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94283);
    String str = "MediaCaptureInfo(sourceVideoPath=" + this.lfj + ", sourceThumb=" + this.lfk + ", isCaptureVideo=" + this.lfl + ", startTime=" + this.fod + ", endTime=" + this.endTime + ", daemonVideoPath=" + this.lfm + ", daemonSourceThumb=" + this.lfn + ", daemonStartTime=" + this.lfo + ", daemonEndTime=" + this.lfp + ", photoPath=" + this.lfq + ", photoList=" + this.lfr + ", videoList=" + this.lfs + ", isLandscape=" + this.lft + ", extInfo=" + this.lfu + ", rect=" + this.byG + ", backgroundColor=" + this.backgroundColor + ")";
    AppMethodBeat.o(94283);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo$Companion;", "", "()V", "getCapturePhotoInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "input", "", "getExternalPhotoInfo", "getExternalPhotosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExternalVideoInfo", "startTime", "", "endTime", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static b OM(String paramString)
    {
      AppMethodBeat.i(259324);
      p.k(paramString, "input");
      paramString = new b(null, null, true, null, null, paramString, null, null, null, 65019);
      AppMethodBeat.o(259324);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.b
 * JD-Core Version:    0.7.0.1
 */