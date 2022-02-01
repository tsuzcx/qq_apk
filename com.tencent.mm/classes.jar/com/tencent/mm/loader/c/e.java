package com.tencent.mm.loader.c;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "", "builder", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "defaultBackgroudColorId", "", "getDefaultBackgroudColorId", "()I", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "defaultBackgroundResId", "getDefaultBackgroundResId", "defaultDrawable", "defaultResId", "getDefaultResId", "fullPath", "", "isCacheInMemory", "", "()Z", "isRound", "isSaveOnDisk", "loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getLoadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "maxImageHeight", "getMaxImageHeight", "maxImageWidth", "getMaxImageWidth", "showEmptyImage", "getDefaultBackgroundDrawable", "resources", "Landroid/content/res/Resources;", "getfullPath", "Builder", "Companion", "LoadFrom", "libimageloader_release"})
public final class e
{
  private static boolean DEBUG;
  private static final e.c hZG = e.c.hZW;
  public static final b hZH = new b((byte)0);
  public final String fullPath;
  public final int hYp;
  public final Animation hYq;
  public final Drawable hYr;
  public final int hZA;
  private final int hZB;
  private final Drawable hZC;
  public final int hZD;
  public final boolean hZE;
  private final boolean hZF;
  public final boolean hZw;
  public final boolean hZx;
  public final e.c hZy;
  public final int hZz;
  
  private e(a parama)
  {
    this.hZw = parama.hZI;
    this.hZx = parama.hZJ;
    this.fullPath = parama.hZK;
    this.hZy = parama.hZL;
    this.hZz = parama.hZM;
    this.hZA = parama.hZN;
    this.hZB = parama.hZO;
    this.hZC = parama.hZP;
    this.hYq = parama.hZU;
    this.hYp = parama.hZQ;
    this.hZD = parama.hZR;
    this.hYr = parama.hZS;
    this.hZF = parama.hZT;
    this.hZE = parama.hZV;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "", "()V", "_animation", "Landroid/view/animation/Animation;", "get_animation", "()Landroid/view/animation/Animation;", "set_animation", "(Landroid/view/animation/Animation;)V", "_cacheInMemory", "", "get_cacheInMemory", "()Z", "set_cacheInMemory", "(Z)V", "_defaultBackgroudColorId", "", "get_defaultBackgroudColorId", "()I", "set_defaultBackgroudColorId", "(I)V", "_defaultBackgroudDrawable", "Landroid/graphics/drawable/Drawable;", "get_defaultBackgroudDrawable", "()Landroid/graphics/drawable/Drawable;", "set_defaultBackgroudDrawable", "(Landroid/graphics/drawable/Drawable;)V", "_defaultBackgroudResId", "get_defaultBackgroudResId", "set_defaultBackgroudResId", "_defaultDrawable", "get_defaultDrawable", "set_defaultDrawable", "_defualtResId", "get_defualtResId", "set_defualtResId", "_fullPath", "", "get_fullPath", "()Ljava/lang/String;", "set_fullPath", "(Ljava/lang/String;)V", "_isRound", "get_isRound", "set_isRound", "_loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "get_loadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "set_loadFrom", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;)V", "_maxImageHeight", "get_maxImageHeight", "set_maxImageHeight", "_maxImageWidth", "get_maxImageWidth", "set_maxImageWidth", "_saveOnDisk", "get_saveOnDisk", "set_saveOnDisk", "_showEmptyImage", "get_showEmptyImage", "build", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setAnimation", "animation", "setCacheInMemory", "setDefaultBackgroudColor", "_resId", "setDefaultBackgroudDrawable", "_drawable", "setDefaultBackgroudResId", "setDefaultDrawable", "setDefaultResId", "setFullPath", "_path", "setIsRound", "setLoadFrom", "setMaxDisplayHeight", "_maxDisplayHeight", "setMaxDisplayWidth", "_maxDisplayWidth", "setSaveOnDisk", "libimageloader_release"})
  public static final class a
  {
    public boolean hZI = true;
    public boolean hZJ;
    String hZK = "";
    e.c hZL;
    public int hZM;
    public int hZN;
    public int hZO;
    Drawable hZP;
    int hZQ;
    public int hZR;
    Drawable hZS;
    final boolean hZT;
    Animation hZU;
    public boolean hZV;
    
    public a()
    {
      e.b localb = e.hZH;
      this.hZL = e.aJS();
      this.hZT = true;
    }
    
    public final a Hh(String paramString)
    {
      p.h(paramString, "_path");
      this.hZK = paramString;
      return this;
    }
    
    public final a a(e.c paramc)
    {
      p.h(paramc, "_loadFrom");
      this.hZL = paramc;
      return this;
    }
    
    public final e aJT()
    {
      return new e(this, (byte)0);
    }
    
    public final a b(Animation paramAnimation)
    {
      p.h(paramAnimation, "animation");
      this.hZU = paramAnimation;
      return this;
    }
    
    public final a w(Drawable paramDrawable)
    {
      p.h(paramDrawable, "_drawable");
      this.hZS = paramDrawable;
      return this;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEFAULT_LOAD_FROM", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getDEFAULT_LOAD_FROM", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "createSimpleOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "libimageloader_release"})
  public static final class b
  {
    public static e aJU()
    {
      return new e.a().aJT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.c.e
 * JD-Core Version:    0.7.0.1
 */