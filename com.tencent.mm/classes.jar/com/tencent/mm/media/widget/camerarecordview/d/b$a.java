package com.tencent.mm.media.widget.camerarecordview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "", "sizeConfigStrategy", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "Lkotlin/collections/HashMap;", "focusModeStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "fpsConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "formatConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "previewConfigStrategy", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "scene", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashSet;I)V", "getFocusModeStrategy", "()Ljava/util/HashMap;", "setFocusModeStrategy", "(Ljava/util/HashMap;)V", "getFormatConfigStrategy", "setFormatConfigStrategy", "getFpsConfigStrategy", "setFpsConfigStrategy", "getPreviewConfigStrategy", "()Ljava/util/HashSet;", "setPreviewConfigStrategy", "(Ljava/util/HashSet;)V", "getScene", "()I", "setScene", "(I)V", "getSizeConfigStrategy", "setSizeConfigStrategy", "Builder", "FocusConfigItem", "FpsConfigItem", "PreviewFormatItem", "SizeConfigItem", "plugin-mediaeditor_release"})
public final class b$a
{
  public HashMap<Integer, e> ira;
  public HashMap<Integer, b.a.b> irb;
  public HashMap<Integer, c> irc;
  public HashMap<Integer, b.a.d> ird;
  public HashSet<String> ire;
  private int scene;
  
  public b$a(HashMap<Integer, e> paramHashMap, HashMap<Integer, b.a.b> paramHashMap1, HashMap<Integer, c> paramHashMap2, HashMap<Integer, b.a.d> paramHashMap3, HashSet<String> paramHashSet, int paramInt)
  {
    AppMethodBeat.i(218908);
    this.ira = paramHashMap;
    this.irb = paramHashMap1;
    this.irc = paramHashMap2;
    this.ird = paramHashMap3;
    this.ire = paramHashSet;
    this.scene = paramInt;
    AppMethodBeat.o(218908);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "", "()V", "focusModeStrategy", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FocusConfigItem;", "Lkotlin/collections/HashMap;", "getFocusModeStrategy", "()Ljava/util/HashMap;", "setFocusModeStrategy", "(Ljava/util/HashMap;)V", "formatConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$PreviewFormatItem;", "getFormatConfigStrategy", "setFormatConfigStrategy", "fpsConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "getFpsConfigStrategy", "setFpsConfigStrategy", "previewConfigStrategy", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getPreviewConfigStrategy", "()Ljava/util/HashSet;", "setPreviewConfigStrategy", "(Ljava/util/HashSet;)V", "scene", "getScene", "()I", "setScene", "(I)V", "sizeConfigStrategy", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "getSizeConfigStrategy", "setSizeConfigStrategy", "addFocusStrategy", "configs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "addFpsConfigStrategy", "addPreviewCallbackConfigStrategy", "([Ljava/lang/String;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$Builder;", "addPreviewFormatConfigStrategy", "addSizeConfigStrategy", "build", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "plugin-mediaeditor_release"})
  public static final class a
  {
    private HashMap<Integer, b.a.e> ira;
    private HashMap<Integer, b.a.b> irb;
    private HashMap<Integer, b.a.c> irc;
    private HashMap<Integer, b.a.d> ird;
    private HashSet<String> ire;
    public int scene;
    
    public a()
    {
      AppMethodBeat.i(218892);
      this.irb = new HashMap();
      this.irc = new HashMap();
      this.ira = new HashMap();
      this.ird = new HashMap();
      this.ire = new HashSet();
      this.scene = -1;
      AppMethodBeat.o(218892);
    }
    
    public final a a(o<Integer, b.a.b>... paramVarArgs)
    {
      AppMethodBeat.i(218886);
      p.h(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        o<Integer, b.a.b> localo = paramVarArgs[0];
        ((Map)this.irb).put(localo.first, localo.second);
        i += 1;
      }
      AppMethodBeat.o(218886);
      return this;
    }
    
    public final b.a aQz()
    {
      AppMethodBeat.i(218891);
      b.a locala = new b.a(this.ira, this.irb, this.irc, this.ird, this.ire, this.scene);
      AppMethodBeat.o(218891);
      return locala;
    }
    
    public final a b(o<Integer, b.a.c>... paramVarArgs)
    {
      AppMethodBeat.i(218887);
      p.h(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        o<Integer, b.a.c> localo = paramVarArgs[0];
        ((Map)this.irc).put(localo.first, localo.second);
        i += 1;
      }
      AppMethodBeat.o(218887);
      return this;
    }
    
    public final a c(o<Integer, b.a.e>... paramVarArgs)
    {
      AppMethodBeat.i(218888);
      p.h(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        o<Integer, b.a.e> localo = paramVarArgs[0];
        ((Map)this.ira).put(localo.first, localo.second);
        i += 1;
      }
      AppMethodBeat.o(218888);
      return this;
    }
    
    public final a d(o<Integer, b.a.d>... paramVarArgs)
    {
      AppMethodBeat.i(218889);
      p.h(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        o<Integer, b.a.d> localo = paramVarArgs[0];
        ((Map)this.ird).put(localo.first, localo.second);
        i += 1;
      }
      AppMethodBeat.o(218889);
      return this;
    }
    
    public final a j(String... paramVarArgs)
    {
      AppMethodBeat.i(218890);
      p.h(paramVarArgs, "configs");
      int i = 0;
      while (i <= 0)
      {
        String str = paramVarArgs[0];
        this.ire.add(str);
        i += 1;
      }
      AppMethodBeat.o(218890);
      return this;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "", "lowerFps", "", "upperFps", "curFps", "useFixMode", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCurFps", "()Ljava/lang/Integer;", "setCurFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLowerFps", "setLowerFps", "getUpperFps", "setUpperFps", "getUseFixMode", "()Ljava/lang/Boolean;", "setUseFixMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$FpsConfigItem;", "equals", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"})
  public static final class c
  {
    public Integer irg;
    public Integer irh;
    public Integer iri;
    public Boolean irj;
    
    private c(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
    {
      this.irg = paramInteger1;
      this.irh = paramInteger2;
      this.iri = paramInteger3;
      this.irj = null;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218899);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.j(this.irg, paramObject.irg)) || (!p.j(this.irh, paramObject.irh)) || (!p.j(this.iri, paramObject.iri)) || (!p.j(this.irj, paramObject.irj))) {}
        }
      }
      else
      {
        AppMethodBeat.o(218899);
        return true;
      }
      AppMethodBeat.o(218899);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(218898);
      Object localObject = this.irg;
      int i;
      int j;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.irh;
        if (localObject == null) {
          break label105;
        }
        j = localObject.hashCode();
        label42:
        localObject = this.iri;
        if (localObject == null) {
          break label110;
        }
      }
      label105:
      label110:
      for (int k = localObject.hashCode();; k = 0)
      {
        localObject = this.irj;
        if (localObject != null) {
          m = localObject.hashCode();
        }
        AppMethodBeat.o(218898);
        return (k + (j + i * 31) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label42;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(218897);
      String str = "FpsConfigItem(lowerFps=" + this.irg + ", upperFps=" + this.irh + ", curFps=" + this.iri + ", useFixMode=" + this.irj + ")";
      AppMethodBeat.o(218897);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "", "width", "", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getWidth", "setWidth", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig$SizeConfigItem;", "equals", "", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"})
  public static final class e
  {
    public Integer irl;
    public Integer irm;
    
    private e(Integer paramInteger1, Integer paramInteger2)
    {
      this.irl = paramInteger1;
      this.irm = paramInteger2;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218907);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((!p.j(this.irl, paramObject.irl)) || (!p.j(this.irm, paramObject.irm))) {}
        }
      }
      else
      {
        AppMethodBeat.o(218907);
        return true;
      }
      AppMethodBeat.o(218907);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(218906);
      Integer localInteger = this.irl;
      if (localInteger != null) {}
      for (int i = localInteger.hashCode();; i = 0)
      {
        localInteger = this.irm;
        if (localInteger != null) {
          j = localInteger.hashCode();
        }
        AppMethodBeat.o(218906);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(218905);
      String str = "SizeConfigItem(width=" + this.irl + ", height=" + this.irm + ")";
      AppMethodBeat.o(218905);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d.b.a
 * JD-Core Version:    0.7.0.1
 */