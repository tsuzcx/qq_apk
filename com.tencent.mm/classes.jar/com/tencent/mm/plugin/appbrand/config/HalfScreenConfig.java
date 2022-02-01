package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enable", "", "height", "", "hideCapsuleHomeButton", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "closeWhenClickEmptyArea", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "forceLightMode", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "(ZIZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;)V", "isEnable", "()Z", "describeContents", "performCloseHalfScreen", "activity", "Landroid/app/Activity;", "toAnimationRes", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "style", "toBuilder", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "toString", "", "writeToParcel", "", "flags", "ActivityAnimationStyle", "BackgroundShapeConfig", "Builder", "CloseWhenClickEmptyAreaConfig", "Companion", "data-model_release"})
public final class HalfScreenConfig
  implements Parcelable
{
  public static final Parcelable.Creator<HalfScreenConfig> CREATOR;
  public static final HalfScreenConfig lfr;
  public static final c lfs;
  private final boolean enable;
  public final int height;
  public final boolean kuZ;
  public final boolean lfm;
  public final a lfn;
  public final boolean lfo;
  public final BackgroundShapeConfig lfp;
  public final CloseWhenClickEmptyAreaConfig lfq;
  
  static
  {
    AppMethodBeat.i(225274);
    lfs = new c((byte)0);
    CREATOR = (Parcelable.Creator)new HalfScreenConfig.d();
    lfr = new HalfScreenConfig(false, 0, false, null, false, null, false, null, 248);
    AppMethodBeat.o(225274);
  }
  
  public HalfScreenConfig(Parcel paramParcel) {}
  
  public HalfScreenConfig(boolean paramBoolean1, int paramInt, boolean paramBoolean2, a parama, boolean paramBoolean3, BackgroundShapeConfig paramBackgroundShapeConfig, boolean paramBoolean4, CloseWhenClickEmptyAreaConfig paramCloseWhenClickEmptyAreaConfig)
  {
    AppMethodBeat.i(225271);
    this.height = paramInt;
    this.lfm = paramBoolean2;
    this.lfn = parama;
    this.lfo = paramBoolean3;
    this.lfp = paramBackgroundShapeConfig;
    this.kuZ = paramBoolean4;
    this.lfq = paramCloseWhenClickEmptyAreaConfig;
    this.enable = paramBoolean1;
    AppMethodBeat.o(225271);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean isEnable()
  {
    return (this.enable) && (this.height > 0);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225269);
    String str = "HalfScreenConfig(enable=" + isEnable() + ", height=" + this.height + ", hideCapsuleHomeButton=" + this.lfm + ", closeWhenClickEmptyArea=" + this.lfo + ", forceLightMode=" + this.kuZ + ')';
    AppMethodBeat.o(225269);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(225270);
    p.h(paramParcel, "parcel");
    int i;
    if (isEnable())
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.height);
      if (!this.lfm) {
        break label128;
      }
      b1 = 1;
      label47:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.lfn.name());
      if (!this.lfo) {
        break label133;
      }
      b1 = 1;
      label72:
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.lfp, paramInt);
      if (!this.kuZ) {
        break label138;
      }
    }
    label128:
    label133:
    label138:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.lfq, paramInt);
      AppMethodBeat.o(225270);
      return;
      i = 0;
      break;
      b1 = 0;
      break label47;
      b1 = 0;
      break label72;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "cornerRadius", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FZZZZ)V", "getBottomLeft", "()Z", "getBottomRight", "getCornerRadius", "()F", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "getRadiusArray", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "Companion", "data-model_release"})
  public static final class BackgroundShapeConfig
    implements Parcelable
  {
    public static final Parcelable.Creator<BackgroundShapeConfig> CREATOR;
    public static final BackgroundShapeConfig lfA;
    public static final a lfB;
    public final boolean lfw;
    public final boolean lfx;
    public final boolean lfy;
    public final boolean lfz;
    public final float tt;
    
    static
    {
      AppMethodBeat.i(225255);
      lfB = new a((byte)0);
      lfA = new BackgroundShapeConfig(0.0F, false, false, 31);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(225255);
    }
    
    public BackgroundShapeConfig()
    {
      this(0.0F, false, false, 31);
    }
    
    private BackgroundShapeConfig(float paramFloat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.tt = paramFloat;
      this.lfw = paramBoolean1;
      this.lfx = paramBoolean2;
      this.lfy = paramBoolean3;
      this.lfz = paramBoolean4;
    }
    
    public BackgroundShapeConfig(Parcel paramParcel) {}
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(225258);
      if (this != paramObject)
      {
        if ((paramObject instanceof BackgroundShapeConfig))
        {
          paramObject = (BackgroundShapeConfig)paramObject;
          if ((Float.compare(this.tt, paramObject.tt) != 0) || (this.lfw != paramObject.lfw) || (this.lfx != paramObject.lfx) || (this.lfy != paramObject.lfy) || (this.lfz != paramObject.lfz)) {}
        }
      }
      else
      {
        AppMethodBeat.o(225258);
        return true;
      }
      AppMethodBeat.o(225258);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(225256);
      String str = "BackgroundShapeConfig(cornerRadius=" + this.tt + ", topLeft=" + this.lfw + ", topRight=" + this.lfx + ", bottomLeft=" + this.lfy + ", bottomRight=" + this.lfz + ")";
      AppMethodBeat.o(225256);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(225252);
      p.h(paramParcel, "parcel");
      paramParcel.writeFloat(this.tt);
      if (this.lfw)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.lfx) {
          break label90;
        }
        b1 = 1;
        label45:
        paramParcel.writeByte(b1);
        if (!this.lfy) {
          break label95;
        }
        b1 = 1;
        label59:
        paramParcel.writeByte(b1);
        if (!this.lfz) {
          break label100;
        }
      }
      label90:
      label95:
      label100:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(225252);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label45;
        b1 = 0;
        break label59;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "DUMMY", "data-model_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "data-model_release"})
    public static final class b
      implements Parcelable.Creator<HalfScreenConfig.BackgroundShapeConfig>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "activityClassName", "", "closeAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;)V", "getActivityClassName", "()Ljava/lang/String;", "getCloseAnimStyle", "()Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "data-model_release"})
  public static final class CloseWhenClickEmptyAreaConfig
    implements Parcelable
  {
    public static final Parcelable.Creator<CloseWhenClickEmptyAreaConfig> CREATOR;
    public static final CloseWhenClickEmptyAreaConfig lfE;
    public static final a lfF;
    public final String lfC;
    public final HalfScreenConfig.a lfD;
    
    static
    {
      AppMethodBeat.i(225264);
      lfF = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      lfE = new CloseWhenClickEmptyAreaConfig("", HalfScreenConfig.a.lft);
      AppMethodBeat.o(225264);
    }
    
    public CloseWhenClickEmptyAreaConfig(Parcel paramParcel)
    {
      this(str1, HalfScreenConfig.a.valueOf(paramParcel));
      AppMethodBeat.i(225263);
      AppMethodBeat.o(225263);
    }
    
    public CloseWhenClickEmptyAreaConfig(String paramString, HalfScreenConfig.a parama)
    {
      AppMethodBeat.i(225262);
      this.lfC = paramString;
      this.lfD = parama;
      AppMethodBeat.o(225262);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(225267);
      if (this != paramObject)
      {
        if ((paramObject instanceof CloseWhenClickEmptyAreaConfig))
        {
          paramObject = (CloseWhenClickEmptyAreaConfig)paramObject;
          if ((!p.j(this.lfC, paramObject.lfC)) || (!p.j(this.lfD, paramObject.lfD))) {}
        }
      }
      else
      {
        AppMethodBeat.o(225267);
        return true;
      }
      AppMethodBeat.o(225267);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(225266);
      Object localObject = this.lfC;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.lfD;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(225266);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(225265);
      String str = "CloseWhenClickEmptyAreaConfig(activityClassName=" + this.lfC + ", closeAnimStyle=" + this.lfD + ")";
      AppMethodBeat.o(225265);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(225261);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.lfC);
      paramParcel.writeString(this.lfD.name());
      AppMethodBeat.o(225261);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "DUMMY", "EXTRA_START_BY_HALF_SCREEN_EMPTY_AREA_CLICK_SCENE", "", "data-model_release"})
    public static final class a {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "data-model_release"})
    public static final class b
      implements Parcelable.Creator<HalfScreenConfig.CloseWhenClickEmptyAreaConfig>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "", "(Ljava/lang/String;I)V", "POPUP", "SLIDE", "data-model_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(225248);
      a locala1 = new a("POPUP", 0);
      lft = locala1;
      a locala2 = new a("SLIDE", 1);
      lfu = locala2;
      lfv = new a[] { locala1, locala2 };
      AppMethodBeat.o(225248);
    }
    
    private a() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "", "()V", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "closeWhenClickEmptyArea", "", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "enable", "forceLightMode", "height", "", "hideCapsuleHomeButton", "build", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "data-model_release"})
  public static final class b
  {
    public boolean enable;
    public int height;
    public boolean kuZ;
    public boolean lfm;
    public HalfScreenConfig.a lfn = HalfScreenConfig.a.lft;
    public boolean lfo;
    public HalfScreenConfig.BackgroundShapeConfig lfp = HalfScreenConfig.BackgroundShapeConfig.lfA;
    public HalfScreenConfig.CloseWhenClickEmptyAreaConfig lfq = HalfScreenConfig.CloseWhenClickEmptyAreaConfig.lfE;
    
    public final b a(HalfScreenConfig.CloseWhenClickEmptyAreaConfig paramCloseWhenClickEmptyAreaConfig)
    {
      AppMethodBeat.i(225259);
      p.h(paramCloseWhenClickEmptyAreaConfig, "closeWhenClickEmptyAreaConfig");
      ((b)this).lfq = paramCloseWhenClickEmptyAreaConfig;
      paramCloseWhenClickEmptyAreaConfig = (b)this;
      AppMethodBeat.o(225259);
      return paramCloseWhenClickEmptyAreaConfig;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "DUMMY", "data-model_release"})
  public static final class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.HalfScreenConfig
 * JD-Core Version:    0.7.0.1
 */