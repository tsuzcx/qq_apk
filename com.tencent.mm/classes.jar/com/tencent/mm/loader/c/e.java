package com.tencent.mm.loader.c;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "", "builder", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "defaultBackgroudColorId", "", "getDefaultBackgroudColorId", "()I", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "defaultBackgroundResId", "getDefaultBackgroundResId", "defaultDrawable", "defaultResId", "getDefaultResId", "fullPath", "", "isCacheInMemory", "", "()Z", "isRound", "isSaveOnDisk", "loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getLoadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "maxImageHeight", "getMaxImageHeight", "maxImageWidth", "getMaxImageWidth", "showEmptyImage", "getDefaultBackgroundDrawable", "resources", "Landroid/content/res/Resources;", "getfullPath", "Builder", "Companion", "LoadFrom", "libimageloader_release"})
public final class e
{
  private static boolean DEBUG;
  private static final e.c gKn = e.c.gKD;
  public static final b gKo = new b((byte)0);
  public final int gIW;
  public final Animation gIX;
  public final Drawable gIY;
  public final boolean gKc;
  public final boolean gKd;
  public final String gKe;
  public final e.c gKf;
  public final int gKg;
  public final int gKh;
  private final int gKi;
  private final Drawable gKj;
  public final int gKk;
  public final boolean gKl;
  private final boolean gKm;
  
  private e(a parama)
  {
    this.gKc = parama.gKp;
    this.gKd = parama.gKq;
    this.gKe = parama.gKr;
    this.gKf = parama.gKs;
    this.gKg = parama.gKt;
    this.gKh = parama.gKu;
    this.gKi = parama.gKv;
    this.gKj = parama.gKw;
    this.gIX = parama.gKB;
    this.gIW = parama.gKx;
    this.gKk = parama.gKy;
    this.gIY = parama.gKz;
    this.gKm = parama.gKA;
    this.gKl = parama.gKC;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "", "()V", "_animation", "Landroid/view/animation/Animation;", "get_animation", "()Landroid/view/animation/Animation;", "set_animation", "(Landroid/view/animation/Animation;)V", "_cacheInMemory", "", "get_cacheInMemory", "()Z", "set_cacheInMemory", "(Z)V", "_defaultBackgroudColorId", "", "get_defaultBackgroudColorId", "()I", "set_defaultBackgroudColorId", "(I)V", "_defaultBackgroudDrawable", "Landroid/graphics/drawable/Drawable;", "get_defaultBackgroudDrawable", "()Landroid/graphics/drawable/Drawable;", "set_defaultBackgroudDrawable", "(Landroid/graphics/drawable/Drawable;)V", "_defaultBackgroudResId", "get_defaultBackgroudResId", "set_defaultBackgroudResId", "_defaultDrawable", "get_defaultDrawable", "set_defaultDrawable", "_defualtResId", "get_defualtResId", "set_defualtResId", "_fullPath", "", "get_fullPath", "()Ljava/lang/String;", "set_fullPath", "(Ljava/lang/String;)V", "_isRound", "get_isRound", "set_isRound", "_loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "get_loadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "set_loadFrom", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;)V", "_maxImageHeight", "get_maxImageHeight", "set_maxImageHeight", "_maxImageWidth", "get_maxImageWidth", "set_maxImageWidth", "_saveOnDisk", "get_saveOnDisk", "set_saveOnDisk", "_showEmptyImage", "get_showEmptyImage", "build", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setAnimation", "animation", "setCacheInMemory", "setDefaultBackgroudColor", "_resId", "setDefaultBackgroudDrawable", "_drawable", "setDefaultBackgroudResId", "setDefaultDrawable", "setDefaultResId", "setFullPath", "_path", "setIsRound", "setLoadFrom", "setMaxDisplayHeight", "_maxDisplayHeight", "setMaxDisplayWidth", "_maxDisplayWidth", "setSaveOnDisk", "libimageloader_release"})
  public static final class a
  {
    final boolean gKA;
    public Animation gKB;
    public boolean gKC;
    public boolean gKp = true;
    public boolean gKq;
    String gKr = "";
    e.c gKs;
    public int gKt;
    public int gKu;
    public int gKv;
    Drawable gKw;
    int gKx;
    public int gKy;
    Drawable gKz;
    
    public a()
    {
      e.b localb = e.gKo;
      this.gKs = e.aos();
      this.gKA = true;
    }
    
    public final a a(e.c paramc)
    {
      k.h(paramc, "_loadFrom");
      this.gKs = paramc;
      return this;
    }
    
    public final e aot()
    {
      return new e(this, (byte)0);
    }
    
    public final a vh(String paramString)
    {
      k.h(paramString, "_path");
      this.gKr = paramString;
      return this;
    }
    
    public final a w(Drawable paramDrawable)
    {
      k.h(paramDrawable, "_drawable");
      this.gKz = paramDrawable;
      return this;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEFAULT_LOAD_FROM", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getDEFAULT_LOAD_FROM", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "createSimpleOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "libimageloader_release"})
  public static final class b
  {
    public static e aou()
    {
      return new e.a().aot();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.c.e
 * JD-Core Version:    0.7.0.1
 */