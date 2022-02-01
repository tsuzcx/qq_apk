package com.tencent.mm.loader.c;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "", "builder", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "defaultBackgroudColorId", "", "getDefaultBackgroudColorId", "()I", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "defaultBackgroundResId", "getDefaultBackgroundResId", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "defaultResId", "getDefaultResId", "fullPath", "", "isCacheInMemory", "", "()Z", "isRound", "isSaveOnDisk", "loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getLoadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "maxImageHeight", "getMaxImageHeight", "maxImageWidth", "getMaxImageWidth", "showEmptyImage", "getDefaultBackgroundDrawable", "resources", "Landroid/content/res/Resources;", "getfullPath", "Builder", "Companion", "LoadFrom", "libimageloader_release"})
public final class e
{
  private static boolean DEBUG;
  private static final c kOm = c.kOC;
  public static final b kOn = new b((byte)0);
  public final String fullPath;
  public int kMT;
  public final Animation kMU;
  public final Drawable kMV;
  public final boolean kOc;
  public final boolean kOd;
  public final c kOe;
  public final int kOf;
  public final int kOg;
  private final int kOh;
  private final Drawable kOi;
  public final int kOj;
  public final boolean kOk;
  private final boolean kOl;
  
  private e(a parama)
  {
    this.kOc = parama.kOo;
    this.kOd = parama.kOp;
    this.fullPath = parama.kOq;
    this.kOe = parama.kOr;
    this.kOf = parama.kOs;
    this.kOg = parama.kOt;
    this.kOh = parama.kOu;
    this.kOi = parama.kOv;
    this.kMU = parama.kOA;
    this.kMT = parama.kOw;
    this.kOj = parama.kOx;
    this.kMV = parama.kOy;
    this.kOl = parama.kOz;
    this.kOk = parama.kOB;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "", "()V", "_animation", "Landroid/view/animation/Animation;", "get_animation", "()Landroid/view/animation/Animation;", "set_animation", "(Landroid/view/animation/Animation;)V", "_cacheInMemory", "", "get_cacheInMemory", "()Z", "set_cacheInMemory", "(Z)V", "_defaultBackgroudColorId", "", "get_defaultBackgroudColorId", "()I", "set_defaultBackgroudColorId", "(I)V", "_defaultBackgroudDrawable", "Landroid/graphics/drawable/Drawable;", "get_defaultBackgroudDrawable", "()Landroid/graphics/drawable/Drawable;", "set_defaultBackgroudDrawable", "(Landroid/graphics/drawable/Drawable;)V", "_defaultBackgroudResId", "get_defaultBackgroudResId", "set_defaultBackgroudResId", "_defaultDrawable", "get_defaultDrawable", "set_defaultDrawable", "_defualtResId", "get_defualtResId", "set_defualtResId", "_fullPath", "", "get_fullPath", "()Ljava/lang/String;", "set_fullPath", "(Ljava/lang/String;)V", "_isRound", "get_isRound", "set_isRound", "_loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "get_loadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "set_loadFrom", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;)V", "_maxImageHeight", "get_maxImageHeight", "set_maxImageHeight", "_maxImageWidth", "get_maxImageWidth", "set_maxImageWidth", "_saveOnDisk", "get_saveOnDisk", "set_saveOnDisk", "_showEmptyImage", "get_showEmptyImage", "build", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setAnimation", "animation", "setCacheInMemory", "setDefaultBackgroudColor", "_resId", "setDefaultBackgroudDrawable", "_drawable", "setDefaultBackgroudResId", "setDefaultDrawable", "setDefaultResId", "setFullPath", "_path", "setIsRound", "setLoadFrom", "setMaxDisplayHeight", "_maxDisplayHeight", "setMaxDisplayWidth", "_maxDisplayWidth", "setSaveOnDisk", "libimageloader_release"})
  public static final class a
  {
    Animation kOA;
    public boolean kOB;
    public boolean kOo = true;
    public boolean kOp;
    String kOq = "";
    e.c kOr;
    public int kOs;
    public int kOt;
    public int kOu;
    Drawable kOv;
    public int kOw;
    public int kOx;
    Drawable kOy;
    final boolean kOz;
    
    public a()
    {
      e.b localb = e.kOn;
      this.kOr = e.aRS();
      this.kOz = true;
    }
    
    public final a B(Drawable paramDrawable)
    {
      p.k(paramDrawable, "_drawable");
      this.kOy = paramDrawable;
      return this;
    }
    
    public final a Os(String paramString)
    {
      p.k(paramString, "_path");
      this.kOq = paramString;
      return this;
    }
    
    public final a a(e.c paramc)
    {
      p.k(paramc, "_loadFrom");
      this.kOr = paramc;
      return this;
    }
    
    public final e aRT()
    {
      return new e(this, (byte)0);
    }
    
    public final a b(Animation paramAnimation)
    {
      p.k(paramAnimation, "animation");
      this.kOA = paramAnimation;
      return this;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEFAULT_LOAD_FROM", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getDEFAULT_LOAD_FROM", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "createSimpleOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "libimageloader_release"})
  public static final class b
  {
    public static e aRU()
    {
      return new e.a().aRT();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "", "(Ljava/lang/String;I)V", "NETWORK", "FILE", "libimageloader_release"})
  public static enum c
  {
    static
    {
      c localc1 = new c("NETWORK", 0);
      kOC = localc1;
      c localc2 = new c("FILE", 1);
      kOD = localc2;
      kOE = new c[] { localc1, localc2 };
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.c.e
 * JD-Core Version:    0.7.0.1
 */