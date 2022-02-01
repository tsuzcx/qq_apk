package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "", "sizeConfigStrategy", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "Lkotlin/collections/HashMap;", "focusModeStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "fpsConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "formatConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "previewConfigStrategy", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "scene", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashSet;I)V", "getFocusModeStrategy", "()Ljava/util/HashMap;", "setFocusModeStrategy", "(Ljava/util/HashMap;)V", "getFormatConfigStrategy", "setFormatConfigStrategy", "getFpsConfigStrategy", "setFpsConfigStrategy", "getPreviewConfigStrategy", "()Ljava/util/HashSet;", "setPreviewConfigStrategy", "(Ljava/util/HashSet;)V", "getScene", "()I", "setScene", "(I)V", "getSizeConfigStrategy", "setSizeConfigStrategy", "Builder", "FocusConfigItem", "FpsConfigItem", "PreviewFormatItem", "SizeConfigItem", "plugin-mediaeditor_release"})
public final class b$a
{
  public HashMap<Integer, e> lgf;
  public HashMap<Integer, b.a.b> lgg;
  public HashMap<Integer, c> lgh;
  public HashMap<Integer, b.a.d> lgi;
  public HashSet<String> lgj;
  private int scene;
  
  public b$a(HashMap<Integer, e> paramHashMap, HashMap<Integer, b.a.b> paramHashMap1, HashMap<Integer, c> paramHashMap2, HashMap<Integer, b.a.d> paramHashMap3, HashSet<String> paramHashSet, int paramInt)
  {
    AppMethodBeat.i(262155);
    this.lgf = paramHashMap;
    this.lgg = paramHashMap1;
    this.lgh = paramHashMap2;
    this.lgi = paramHashMap3;
    this.lgj = paramHashSet;
    this.scene = paramInt;
    AppMethodBeat.o(262155);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "", "()V", "focusModeStrategy", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "Lkotlin/collections/HashMap;", "getFocusModeStrategy", "()Ljava/util/HashMap;", "setFocusModeStrategy", "(Ljava/util/HashMap;)V", "formatConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "getFormatConfigStrategy", "setFormatConfigStrategy", "fpsConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "getFpsConfigStrategy", "setFpsConfigStrategy", "previewConfigStrategy", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getPreviewConfigStrategy", "()Ljava/util/HashSet;", "setPreviewConfigStrategy", "(Ljava/util/HashSet;)V", "scene", "getScene", "()I", "setScene", "(I)V", "sizeConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "getSizeConfigStrategy", "setSizeConfigStrategy", "addFocusStrategy", "configs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "addFpsConfigStrategy", "addPreviewCallbackConfigStrategy", "([Ljava/lang/String;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "addPreviewFormatConfigStrategy", "addSizeConfigStrategy", "build", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "plugin-mediaeditor_release"})
  public static final class a
  {
    private HashMap<Integer, b.a.e> lgf;
    private HashMap<Integer, b.a.b> lgg;
    private HashMap<Integer, b.a.c> lgh;
    private HashMap<Integer, b.a.d> lgi;
    private HashSet<String> lgj;
    public int scene;
    
    public a()
    {
      AppMethodBeat.i(257997);
      this.lgg = new HashMap();
      this.lgh = new HashMap();
      this.lgf = new HashMap();
      this.lgi = new HashMap();
      this.lgj = new HashSet();
      this.scene = -1;
      AppMethodBeat.o(257997);
    }
    
    public final a a(o<Integer, b.a.b>... paramVarArgs)
    {
      AppMethodBeat.i(257991);
      p.k(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        o<Integer, b.a.b> localo = paramVarArgs[0];
        ((Map)this.lgg).put(localo.Mx, localo.My);
        i += 1;
      }
      AppMethodBeat.o(257991);
      return this;
    }
    
    public final b.a aZr()
    {
      AppMethodBeat.i(257996);
      b.a locala = new b.a(this.lgf, this.lgg, this.lgh, this.lgi, this.lgj, this.scene);
      AppMethodBeat.o(257996);
      return locala;
    }
    
    public final a b(o<Integer, b.a.c>... paramVarArgs)
    {
      AppMethodBeat.i(257992);
      p.k(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        o<Integer, b.a.c> localo = paramVarArgs[0];
        ((Map)this.lgh).put(localo.Mx, localo.My);
        i += 1;
      }
      AppMethodBeat.o(257992);
      return this;
    }
    
    public final a c(o<Integer, b.a.e>... paramVarArgs)
    {
      AppMethodBeat.i(257993);
      p.k(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        o<Integer, b.a.e> localo = paramVarArgs[0];
        ((Map)this.lgf).put(localo.Mx, localo.My);
        i += 1;
      }
      AppMethodBeat.o(257993);
      return this;
    }
    
    public final a d(o<Integer, b.a.d>... paramVarArgs)
    {
      AppMethodBeat.i(257994);
      p.k(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        o<Integer, b.a.d> localo = paramVarArgs[0];
        ((Map)this.lgi).put(localo.Mx, localo.My);
        i += 1;
      }
      AppMethodBeat.o(257994);
      return this;
    }
    
    public final a h(String... paramVarArgs)
    {
      AppMethodBeat.i(257995);
      p.k(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        String str = paramVarArgs[0];
        this.lgj.add(str);
        i += 1;
      }
      AppMethodBeat.o(257995);
      return this;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "", "lowerFps", "", "upperFps", "curFps", "useFixMode", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCurFps", "()Ljava/lang/Integer;", "setCurFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLowerFps", "setLowerFps", "getUpperFps", "setUpperFps", "getUseFixMode", "()Ljava/lang/Boolean;", "setUseFixMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "equals", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"})
  public static final class c
  {
    public Integer lgl;
    public Integer lgm;
    public Integer lgn;
    public Boolean lgo;
    
    private c(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
    {
      this.lgl = paramInteger1;
      this.lgm = paramInteger2;
      this.lgn = paramInteger3;
      this.lgo = null;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(261828);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.h(this.lgl, paramObject.lgl)) || (!p.h(this.lgm, paramObject.lgm)) || (!p.h(this.lgn, paramObject.lgn)) || (!p.h(this.lgo, paramObject.lgo))) {}
        }
      }
      else
      {
        AppMethodBeat.o(261828);
        return true;
      }
      AppMethodBeat.o(261828);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(261827);
      Object localObject = this.lgl;
      int i;
      int j;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.lgm;
        if (localObject == null) {
          break label105;
        }
        j = localObject.hashCode();
        label42:
        localObject = this.lgn;
        if (localObject == null) {
          break label110;
        }
      }
      label105:
      label110:
      for (int k = localObject.hashCode();; k = 0)
      {
        localObject = this.lgo;
        if (localObject != null) {
          m = localObject.hashCode();
        }
        AppMethodBeat.o(261827);
        return (k + (j + i * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label42;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(261825);
      String str = "FpsConfigItem(lowerFps=" + this.lgl + ", upperFps=" + this.lgm + ", curFps=" + this.lgn + ", useFixMode=" + this.lgo + ")";
      AppMethodBeat.o(261825);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "", "width", "", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getWidth", "setWidth", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "equals", "", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"})
  public static final class e
  {
    public Integer lgq;
    public Integer lgr;
    
    private e(Integer paramInteger1, Integer paramInteger2)
    {
      this.lgq = paramInteger1;
      this.lgr = paramInteger2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(259194);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((!p.h(this.lgq, paramObject.lgq)) || (!p.h(this.lgr, paramObject.lgr))) {}
        }
      }
      else
      {
        AppMethodBeat.o(259194);
        return true;
      }
      AppMethodBeat.o(259194);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(259192);
      Integer localInteger = this.lgq;
      if (localInteger != null) {}
      for (int i = localInteger.hashCode();; i = 0)
      {
        localInteger = this.lgr;
        if (localInteger != null) {
          j = localInteger.hashCode();
        }
        AppMethodBeat.o(259192);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(259191);
      String str = "SizeConfigItem(width=" + this.lgq + ", height=" + this.lgr + ")";
      AppMethodBeat.o(259191);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a
 * JD-Core Version:    0.7.0.1
 */