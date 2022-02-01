package com.tencent.mm.media.widget.camerarecordview.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "daemonVideoPath", "daemonSourceThumb", "daemonStartTime", "daemonEndTime", "photoPath", "photoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoList", "isLandscape", "extInfo", "Landroid/os/Bundle;", "rect", "Landroid/graphics/Rect;", "backgroundColor", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLandroid/os/Bundle;Landroid/graphics/Rect;I)V", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "getDaemonEndTime", "setDaemonEndTime", "getDaemonSourceThumb", "()Ljava/lang/String;", "setDaemonSourceThumb", "(Ljava/lang/String;)V", "getDaemonStartTime", "setDaemonStartTime", "getDaemonVideoPath", "setDaemonVideoPath", "getEndTime", "setEndTime", "getExtInfo", "()Landroid/os/Bundle;", "setExtInfo", "(Landroid/os/Bundle;)V", "()Z", "setCaptureVideo", "(Z)V", "setLandscape", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "getPhotoPath", "setPhotoPath", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "getVideoList", "setVideoList", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "enableBaseVideo", "enableDaemonVideo", "equals", "other", "getPreviewThumbUrl", "getPreviewUrl", "hashCode", "setImages", "", "imageList", "setVideos", "toString", "videoCheck", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a nJT;
  public int backgroundColor;
  public int endTime;
  public String nJU;
  public String nJV;
  public boolean nJW;
  public String nJX;
  public String nJY;
  public int nJZ;
  public int nKa;
  public String nKb;
  public ArrayList<String> nKc;
  public ArrayList<String> nKd;
  public boolean nKe;
  public Bundle nKf;
  public Rect rect;
  public int startTime;
  
  static
  {
    AppMethodBeat.i(94282);
    nJT = new b.a((byte)0);
    AppMethodBeat.o(94282);
  }
  
  public b()
  {
    this(null, null, false, null, null, null, null, null, null, 65535);
  }
  
  private b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, Rect paramRect)
  {
    AppMethodBeat.i(237706);
    this.nJU = paramString1;
    this.nJV = paramString2;
    this.nJW = paramBoolean;
    this.startTime = 0;
    this.endTime = 0;
    this.nJX = paramString3;
    this.nJY = paramString4;
    this.nJZ = 0;
    this.nKa = 0;
    this.nKb = paramString5;
    this.nKc = paramArrayList1;
    this.nKd = paramArrayList2;
    this.nKe = false;
    this.nKf = null;
    this.rect = paramRect;
    this.backgroundColor = 0;
    AppMethodBeat.o(237706);
  }
  
  public final void GZ(String paramString)
  {
    AppMethodBeat.i(94277);
    s.u(paramString, "<set-?>");
    this.nJU = paramString;
    AppMethodBeat.o(94277);
  }
  
  public final void Ha(String paramString)
  {
    AppMethodBeat.i(94278);
    s.u(paramString, "<set-?>");
    this.nJV = paramString;
    AppMethodBeat.o(94278);
  }
  
  public final void Hb(String paramString)
  {
    AppMethodBeat.i(94279);
    s.u(paramString, "<set-?>");
    this.nKb = paramString;
    AppMethodBeat.o(94279);
  }
  
  public final boolean bue()
  {
    AppMethodBeat.i(94274);
    if ((!TextUtils.isEmpty((CharSequence)this.nJX)) && (y.ZC(this.nJX)))
    {
      AppMethodBeat.o(94274);
      return true;
    }
    AppMethodBeat.o(94274);
    return false;
  }
  
  public final boolean buf()
  {
    AppMethodBeat.i(94275);
    if ((!TextUtils.isEmpty((CharSequence)this.nJU)) && (y.ZC(this.nJU)))
    {
      AppMethodBeat.o(94275);
      return true;
    }
    AppMethodBeat.o(94275);
    return false;
  }
  
  public final String bug()
  {
    AppMethodBeat.i(94276);
    if (buf())
    {
      str = this.nJU;
      AppMethodBeat.o(94276);
      return str;
    }
    String str = this.nJX;
    AppMethodBeat.o(94276);
    return str;
  }
  
  public final String buh()
  {
    AppMethodBeat.i(237725);
    if (buf())
    {
      str = this.nJV;
      AppMethodBeat.o(237725);
      return str;
    }
    String str = this.nJY;
    AppMethodBeat.o(237725);
    return str;
  }
  
  public final void bui()
  {
    AppMethodBeat.i(237728);
    if ((this.nKc.size() == 0) && (this.nKd.size() == 1))
    {
      this.nJU = ((String)p.oK((List)this.nKd));
      com.tencent.mm.plugin.sight.base.b localb = f.aVX(this.nJU);
      if (localb != null) {
        this.endTime = localb.videoDuration;
      }
    }
    AppMethodBeat.o(237728);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94285);
    if (this == paramObject)
    {
      AppMethodBeat.o(94285);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.nJU, paramObject.nJU))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (!s.p(this.nJV, paramObject.nJV))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (this.nJW != paramObject.nJW)
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (this.startTime != paramObject.startTime)
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (this.endTime != paramObject.endTime)
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (!s.p(this.nJX, paramObject.nJX))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (!s.p(this.nJY, paramObject.nJY))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (this.nJZ != paramObject.nJZ)
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (this.nKa != paramObject.nKa)
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (!s.p(this.nKb, paramObject.nKb))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (!s.p(this.nKc, paramObject.nKc))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (!s.p(this.nKd, paramObject.nKd))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (this.nKe != paramObject.nKe)
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (!s.p(this.nKf, paramObject.nKf))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (!s.p(this.rect, paramObject.rect))
    {
      AppMethodBeat.o(94285);
      return false;
    }
    if (this.backgroundColor != paramObject.backgroundColor)
    {
      AppMethodBeat.o(94285);
      return false;
    }
    AppMethodBeat.o(94285);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94283);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MediaCaptureInfo(sourceVideoPath=").append(this.nJU).append(", sourceThumb=").append(this.nJV).append(", isCaptureVideo=").append(this.nJW).append(", startTime=").append(this.startTime).append(", endTime=").append(this.endTime).append(", daemonVideoPath=").append(this.nJX).append(", daemonSourceThumb=").append(this.nJY).append(", daemonStartTime=").append(this.nJZ).append(", daemonEndTime=").append(this.nKa).append(", photoPath=").append(this.nKb).append(", photoList=").append(this.nKc).append(", videoList=");
    ((StringBuilder)localObject).append(this.nKd).append(", isLandscape=").append(this.nKe).append(", extInfo=").append(this.nKf).append(", rect=").append(this.rect).append(", backgroundColor=").append(this.backgroundColor).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(94283);
    return localObject;
  }
  
  public final void v(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(237718);
    s.u(paramArrayList, "<set-?>");
    this.nKc = paramArrayList;
    AppMethodBeat.o(237718);
  }
  
  public final void w(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(237719);
    s.u(paramArrayList, "<set-?>");
    this.nKd = paramArrayList;
    AppMethodBeat.o(237719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.b
 * JD-Core Version:    0.7.0.1
 */