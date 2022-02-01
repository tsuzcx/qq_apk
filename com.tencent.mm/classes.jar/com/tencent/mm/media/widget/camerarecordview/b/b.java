package com.tencent.mm.media.widget.camerarecordview.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "daemonVideoPath", "daemonSourceThumb", "daemonStartTime", "daemonEndTime", "photoPath", "photoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoList", "isLandscape", "extInfo", "Landroid/os/Bundle;", "rect", "Landroid/graphics/Rect;", "backgroundColor", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLandroid/os/Bundle;Landroid/graphics/Rect;I)V", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "getDaemonEndTime", "setDaemonEndTime", "getDaemonSourceThumb", "()Ljava/lang/String;", "setDaemonSourceThumb", "(Ljava/lang/String;)V", "getDaemonStartTime", "setDaemonStartTime", "getDaemonVideoPath", "setDaemonVideoPath", "getEndTime", "setEndTime", "getExtInfo", "()Landroid/os/Bundle;", "setExtInfo", "(Landroid/os/Bundle;)V", "()Z", "setCaptureVideo", "(Z)V", "setLandscape", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "getPhotoPath", "setPhotoPath", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "getVideoList", "setVideoList", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "enableBaseVideo", "enableDaemonVideo", "equals", "other", "getPreviewThumbUrl", "getPreviewUrl", "hashCode", "setImages", "", "imageList", "setVideos", "toString", "videoCheck", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a iqq;
  public int backgroundColor;
  public int dvv;
  public String iqd;
  public String iqe;
  public boolean iqf;
  public int iqg;
  public String iqh;
  public String iqi;
  public int iqj;
  public int iqk;
  public String iql;
  public ArrayList<String> iqm;
  public ArrayList<String> iqn;
  public boolean iqo;
  public Bundle iqp;
  public Rect rect;
  
  static
  {
    AppMethodBeat.i(94282);
    iqq = new a((byte)0);
    AppMethodBeat.o(94282);
  }
  
  public b()
  {
    this(null, null, false, null, null, null, null, null, null, 65535);
  }
  
  private b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, Rect paramRect)
  {
    AppMethodBeat.i(218883);
    this.iqd = paramString1;
    this.iqe = paramString2;
    this.iqf = paramBoolean;
    this.dvv = 0;
    this.iqg = 0;
    this.iqh = paramString3;
    this.iqi = paramString4;
    this.iqj = 0;
    this.iqk = 0;
    this.iql = paramString5;
    this.iqm = paramArrayList1;
    this.iqn = paramArrayList2;
    this.iqo = false;
    this.iqp = null;
    this.rect = paramRect;
    this.backgroundColor = 0;
    AppMethodBeat.o(218883);
  }
  
  public final void Hw(String paramString)
  {
    AppMethodBeat.i(94277);
    p.h(paramString, "<set-?>");
    this.iqd = paramString;
    AppMethodBeat.o(94277);
  }
  
  public final void Hx(String paramString)
  {
    AppMethodBeat.i(94278);
    p.h(paramString, "<set-?>");
    this.iqe = paramString;
    AppMethodBeat.o(94278);
  }
  
  public final void Hy(String paramString)
  {
    AppMethodBeat.i(94279);
    p.h(paramString, "<set-?>");
    this.iql = paramString;
    AppMethodBeat.o(94279);
  }
  
  public final boolean aQo()
  {
    AppMethodBeat.i(94274);
    if ((!TextUtils.isEmpty((CharSequence)this.iqh)) && (s.YS(this.iqh)))
    {
      AppMethodBeat.o(94274);
      return true;
    }
    AppMethodBeat.o(94274);
    return false;
  }
  
  public final boolean aQp()
  {
    AppMethodBeat.i(94275);
    if ((!TextUtils.isEmpty((CharSequence)this.iqd)) && (s.YS(this.iqd)))
    {
      AppMethodBeat.o(94275);
      return true;
    }
    AppMethodBeat.o(94275);
    return false;
  }
  
  public final String aQq()
  {
    AppMethodBeat.i(94276);
    if (aQp())
    {
      str = this.iqd;
      AppMethodBeat.o(94276);
      return str;
    }
    String str = this.iqh;
    AppMethodBeat.o(94276);
    return str;
  }
  
  public final void aQr()
  {
    AppMethodBeat.i(218879);
    if ((this.iqm.size() == 0) && (this.iqn.size() == 1))
    {
      this.iqd = ((String)j.ks((List)this.iqn));
      a locala = e.aNx(this.iqd);
      if (locala != null) {
        this.iqg = locala.videoDuration;
      }
    }
    AppMethodBeat.o(218879);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94285);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.j(this.iqd, paramObject.iqd)) || (!p.j(this.iqe, paramObject.iqe)) || (this.iqf != paramObject.iqf) || (this.dvv != paramObject.dvv) || (this.iqg != paramObject.iqg) || (!p.j(this.iqh, paramObject.iqh)) || (!p.j(this.iqi, paramObject.iqi)) || (this.iqj != paramObject.iqj) || (this.iqk != paramObject.iqk) || (!p.j(this.iql, paramObject.iql)) || (!p.j(this.iqm, paramObject.iqm)) || (!p.j(this.iqn, paramObject.iqn)) || (this.iqo != paramObject.iqo) || (!p.j(this.iqp, paramObject.iqp)) || (!p.j(this.rect, paramObject.rect)) || (this.backgroundColor != paramObject.backgroundColor)) {}
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
    AppMethodBeat.i(218880);
    p.h(paramArrayList, "<set-?>");
    this.iqm = paramArrayList;
    AppMethodBeat.o(218880);
  }
  
  public final void setRect(Rect paramRect)
  {
    AppMethodBeat.i(218882);
    p.h(paramRect, "<set-?>");
    this.rect = paramRect;
    AppMethodBeat.o(218882);
  }
  
  public final void t(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(218881);
    p.h(paramArrayList, "<set-?>");
    this.iqn = paramArrayList;
    AppMethodBeat.o(218881);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94283);
    String str = "MediaCaptureInfo(sourceVideoPath=" + this.iqd + ", sourceThumb=" + this.iqe + ", isCaptureVideo=" + this.iqf + ", startTime=" + this.dvv + ", endTime=" + this.iqg + ", daemonVideoPath=" + this.iqh + ", daemonSourceThumb=" + this.iqi + ", daemonStartTime=" + this.iqj + ", daemonEndTime=" + this.iqk + ", photoPath=" + this.iql + ", photoList=" + this.iqm + ", videoList=" + this.iqn + ", isLandscape=" + this.iqo + ", extInfo=" + this.iqp + ", rect=" + this.rect + ", backgroundColor=" + this.backgroundColor + ")";
    AppMethodBeat.o(94283);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo$Companion;", "", "()V", "getCapturePhotoInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "input", "", "getExternalPhotoInfo", "getExternalPhotosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExternalVideoInfo", "startTime", "", "endTime", "plugin-mediaeditor_release"})
  public static final class a
  {
    public static b Hz(String paramString)
    {
      AppMethodBeat.i(218878);
      p.h(paramString, "input");
      paramString = new b(null, null, true, null, null, paramString, null, null, null, 65019);
      AppMethodBeat.o(218878);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b.b
 * JD-Core Version:    0.7.0.1
 */