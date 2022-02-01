package com.tencent.mm.loader.c;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "", "builder", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "defaultBackgroudColorId", "", "getDefaultBackgroudColorId", "()I", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "defaultBackgroundResId", "getDefaultBackgroundResId", "defaultDrawable", "defaultResId", "getDefaultResId", "fullPath", "", "isCacheInMemory", "", "()Z", "isRound", "isSaveOnDisk", "loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getLoadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "maxImageHeight", "getMaxImageHeight", "maxImageWidth", "getMaxImageWidth", "showEmptyImage", "getDefaultBackgroundDrawable", "resources", "Landroid/content/res/Resources;", "getfullPath", "Builder", "Companion", "LoadFrom", "libimageloader_release"})
public final class e
{
  private static boolean DEBUG;
  private static final e.c gjB = e.c.gjQ;
  public static final b gjC = new b((byte)0);
  public final int KBD;
  public final int gin;
  public final Animation gio;
  public final Drawable gip;
  private final boolean gjA;
  public final boolean gjr;
  public final boolean gjs;
  public final String gjt;
  public final e.c gju;
  public final int gjv;
  public final int gjw;
  private final int gjx;
  private final Drawable gjy;
  public final boolean gjz;
  
  private e(a parama)
  {
    this.gjr = parama.gjD;
    this.gjs = parama.gjE;
    this.gjt = parama.gjF;
    this.gju = parama.gjG;
    this.gjv = parama.gjH;
    this.gjw = parama.gjI;
    this.gjx = parama.gjJ;
    this.gjy = parama.gjK;
    this.gio = parama.gjO;
    this.gin = parama.gjL;
    this.KBD = parama.KBE;
    this.gip = parama.gjM;
    this.gjA = parama.gjN;
    this.gjz = parama.gjP;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "", "()V", "_animation", "Landroid/view/animation/Animation;", "get_animation", "()Landroid/view/animation/Animation;", "set_animation", "(Landroid/view/animation/Animation;)V", "_cacheInMemory", "", "get_cacheInMemory", "()Z", "set_cacheInMemory", "(Z)V", "_defaultBackgroudColorId", "", "get_defaultBackgroudColorId", "()I", "set_defaultBackgroudColorId", "(I)V", "_defaultBackgroudDrawable", "Landroid/graphics/drawable/Drawable;", "get_defaultBackgroudDrawable", "()Landroid/graphics/drawable/Drawable;", "set_defaultBackgroudDrawable", "(Landroid/graphics/drawable/Drawable;)V", "_defaultBackgroudResId", "get_defaultBackgroudResId", "set_defaultBackgroudResId", "_defaultDrawable", "get_defaultDrawable", "set_defaultDrawable", "_defualtResId", "get_defualtResId", "set_defualtResId", "_fullPath", "", "get_fullPath", "()Ljava/lang/String;", "set_fullPath", "(Ljava/lang/String;)V", "_isRound", "get_isRound", "set_isRound", "_loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "get_loadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "set_loadFrom", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;)V", "_maxImageHeight", "get_maxImageHeight", "set_maxImageHeight", "_maxImageWidth", "get_maxImageWidth", "set_maxImageWidth", "_saveOnDisk", "get_saveOnDisk", "set_saveOnDisk", "_showEmptyImage", "get_showEmptyImage", "build", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setAnimation", "animation", "setCacheInMemory", "setDefaultBackgroudColor", "_resId", "setDefaultBackgroudDrawable", "_drawable", "setDefaultBackgroudResId", "setDefaultDrawable", "setDefaultResId", "setFullPath", "_path", "setIsRound", "setLoadFrom", "setMaxDisplayHeight", "_maxDisplayHeight", "setMaxDisplayWidth", "_maxDisplayWidth", "setSaveOnDisk", "libimageloader_release"})
  public static final class a
  {
    public int KBE;
    public boolean gjD = true;
    public boolean gjE;
    String gjF = "";
    e.c gjG;
    public int gjH;
    public int gjI;
    public int gjJ;
    Drawable gjK;
    int gjL;
    Drawable gjM;
    final boolean gjN;
    public Animation gjO;
    public boolean gjP;
    
    public a()
    {
      e.b localb = e.gjC;
      this.gjG = e.ahq();
      this.gjN = true;
    }
    
    public final a a(e.c paramc)
    {
      k.h(paramc, "_loadFrom");
      this.gjG = paramc;
      return this;
    }
    
    public final e ahr()
    {
      return new e(this, (byte)0);
    }
    
    public final a rf(String paramString)
    {
      k.h(paramString, "_path");
      this.gjF = paramString;
      return this;
    }
    
    public final a w(Drawable paramDrawable)
    {
      k.h(paramDrawable, "_drawable");
      this.gjM = paramDrawable;
      return this;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEFAULT_LOAD_FROM", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getDEFAULT_LOAD_FROM", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "createSimpleOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "libimageloader_release"})
  public static final class b
  {
    public static e ahs()
    {
      return new e.a().ahr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.c.e
 * JD-Core Version:    0.7.0.1
 */