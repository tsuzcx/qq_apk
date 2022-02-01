package com.tencent.mm.loader.c;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "", "builder", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "defaultBackgroudColorId", "", "getDefaultBackgroudColorId", "()I", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "defaultBackgroundResId", "getDefaultBackgroundResId", "defaultDrawable", "defaultResId", "getDefaultResId", "fullPath", "", "isCacheInMemory", "", "()Z", "isRound", "isSaveOnDisk", "loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getLoadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "maxImageHeight", "getMaxImageHeight", "maxImageWidth", "getMaxImageWidth", "showEmptyImage", "getDefaultBackgroundDrawable", "resources", "Landroid/content/res/Resources;", "getfullPath", "Builder", "Companion", "LoadFrom", "libimageloader_release"})
public final class e
{
  private static boolean DEBUG;
  private static final e.c hgM = e.c.hhc;
  public static final b hgN = new b((byte)0);
  public final int hfv;
  public final Animation hfw;
  public final Drawable hfx;
  public final boolean hgB;
  public final boolean hgC;
  public final String hgD;
  public final e.c hgE;
  public final int hgF;
  public final int hgG;
  private final int hgH;
  private final Drawable hgI;
  public final int hgJ;
  public final boolean hgK;
  private final boolean hgL;
  
  private e(a parama)
  {
    this.hgB = parama.hgO;
    this.hgC = parama.hgP;
    this.hgD = parama.hgQ;
    this.hgE = parama.hgR;
    this.hgF = parama.hgS;
    this.hgG = parama.hgT;
    this.hgH = parama.hgU;
    this.hgI = parama.hgV;
    this.hfw = parama.hha;
    this.hfv = parama.hgW;
    this.hgJ = parama.hgX;
    this.hfx = parama.hgY;
    this.hgL = parama.hgZ;
    this.hgK = parama.hhb;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "", "()V", "_animation", "Landroid/view/animation/Animation;", "get_animation", "()Landroid/view/animation/Animation;", "set_animation", "(Landroid/view/animation/Animation;)V", "_cacheInMemory", "", "get_cacheInMemory", "()Z", "set_cacheInMemory", "(Z)V", "_defaultBackgroudColorId", "", "get_defaultBackgroudColorId", "()I", "set_defaultBackgroudColorId", "(I)V", "_defaultBackgroudDrawable", "Landroid/graphics/drawable/Drawable;", "get_defaultBackgroudDrawable", "()Landroid/graphics/drawable/Drawable;", "set_defaultBackgroudDrawable", "(Landroid/graphics/drawable/Drawable;)V", "_defaultBackgroudResId", "get_defaultBackgroudResId", "set_defaultBackgroudResId", "_defaultDrawable", "get_defaultDrawable", "set_defaultDrawable", "_defualtResId", "get_defualtResId", "set_defualtResId", "_fullPath", "", "get_fullPath", "()Ljava/lang/String;", "set_fullPath", "(Ljava/lang/String;)V", "_isRound", "get_isRound", "set_isRound", "_loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "get_loadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "set_loadFrom", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;)V", "_maxImageHeight", "get_maxImageHeight", "set_maxImageHeight", "_maxImageWidth", "get_maxImageWidth", "set_maxImageWidth", "_saveOnDisk", "get_saveOnDisk", "set_saveOnDisk", "_showEmptyImage", "get_showEmptyImage", "build", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setAnimation", "animation", "setCacheInMemory", "setDefaultBackgroudColor", "_resId", "setDefaultBackgroudDrawable", "_drawable", "setDefaultBackgroudResId", "setDefaultDrawable", "setDefaultResId", "setFullPath", "_path", "setIsRound", "setLoadFrom", "setMaxDisplayHeight", "_maxDisplayHeight", "setMaxDisplayWidth", "_maxDisplayWidth", "setSaveOnDisk", "libimageloader_release"})
  public static final class a
  {
    public boolean hgO = true;
    public boolean hgP;
    String hgQ = "";
    e.c hgR;
    public int hgS;
    public int hgT;
    public int hgU;
    Drawable hgV;
    int hgW;
    public int hgX;
    Drawable hgY;
    final boolean hgZ;
    public Animation hha;
    public boolean hhb;
    
    public a()
    {
      e.b localb = e.hgN;
      this.hgR = e.art();
      this.hgZ = true;
    }
    
    public final a a(e.c paramc)
    {
      p.h(paramc, "_loadFrom");
      this.hgR = paramc;
      return this;
    }
    
    public final e aru()
    {
      return new e(this, (byte)0);
    }
    
    public final a w(Drawable paramDrawable)
    {
      p.h(paramDrawable, "_drawable");
      this.hgY = paramDrawable;
      return this;
    }
    
    public final a yI(String paramString)
    {
      p.h(paramString, "_path");
      this.hgQ = paramString;
      return this;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEFAULT_LOAD_FROM", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getDEFAULT_LOAD_FROM", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "createSimpleOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "libimageloader_release"})
  public static final class b
  {
    public static e arv()
    {
      return new e.a().aru();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.c.e
 * JD-Core Version:    0.7.0.1
 */