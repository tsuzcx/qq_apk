package com.tencent.mm.loader.c;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "", "builder", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "defaultBackgroudColorId", "", "getDefaultBackgroudColorId", "()I", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "defaultBackgroundResId", "getDefaultBackgroundResId", "defaultDrawable", "defaultResId", "getDefaultResId", "fullPath", "", "isCacheInMemory", "", "()Z", "isRound", "isSaveOnDisk", "loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getLoadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "maxImageHeight", "getMaxImageHeight", "maxImageWidth", "getMaxImageWidth", "showEmptyImage", "getDefaultBackgroundDrawable", "resources", "Landroid/content/res/Resources;", "getfullPath", "Builder", "Companion", "LoadFrom", "libimageloader_release"})
public final class e
{
  private static boolean DEBUG;
  private static final e.c hdY = e.c.heo;
  public static final b hdZ = new b((byte)0);
  public final int hcH;
  public final Animation hcI;
  public final Drawable hcJ;
  public final boolean hdN;
  public final boolean hdO;
  public final String hdP;
  public final e.c hdQ;
  public final int hdR;
  public final int hdS;
  private final int hdT;
  private final Drawable hdU;
  public final int hdV;
  public final boolean hdW;
  private final boolean hdX;
  
  private e(a parama)
  {
    this.hdN = parama.hea;
    this.hdO = parama.heb;
    this.hdP = parama.hec;
    this.hdQ = parama.hed;
    this.hdR = parama.hee;
    this.hdS = parama.hef;
    this.hdT = parama.heg;
    this.hdU = parama.heh;
    this.hcI = parama.hem;
    this.hcH = parama.hei;
    this.hdV = parama.hej;
    this.hcJ = parama.hek;
    this.hdX = parama.hel;
    this.hdW = parama.hen;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "", "()V", "_animation", "Landroid/view/animation/Animation;", "get_animation", "()Landroid/view/animation/Animation;", "set_animation", "(Landroid/view/animation/Animation;)V", "_cacheInMemory", "", "get_cacheInMemory", "()Z", "set_cacheInMemory", "(Z)V", "_defaultBackgroudColorId", "", "get_defaultBackgroudColorId", "()I", "set_defaultBackgroudColorId", "(I)V", "_defaultBackgroudDrawable", "Landroid/graphics/drawable/Drawable;", "get_defaultBackgroudDrawable", "()Landroid/graphics/drawable/Drawable;", "set_defaultBackgroudDrawable", "(Landroid/graphics/drawable/Drawable;)V", "_defaultBackgroudResId", "get_defaultBackgroudResId", "set_defaultBackgroudResId", "_defaultDrawable", "get_defaultDrawable", "set_defaultDrawable", "_defualtResId", "get_defualtResId", "set_defualtResId", "_fullPath", "", "get_fullPath", "()Ljava/lang/String;", "set_fullPath", "(Ljava/lang/String;)V", "_isRound", "get_isRound", "set_isRound", "_loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "get_loadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "set_loadFrom", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;)V", "_maxImageHeight", "get_maxImageHeight", "set_maxImageHeight", "_maxImageWidth", "get_maxImageWidth", "set_maxImageWidth", "_saveOnDisk", "get_saveOnDisk", "set_saveOnDisk", "_showEmptyImage", "get_showEmptyImage", "build", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setAnimation", "animation", "setCacheInMemory", "setDefaultBackgroudColor", "_resId", "setDefaultBackgroudDrawable", "_drawable", "setDefaultBackgroudResId", "setDefaultDrawable", "setDefaultResId", "setFullPath", "_path", "setIsRound", "setLoadFrom", "setMaxDisplayHeight", "_maxDisplayHeight", "setMaxDisplayWidth", "_maxDisplayWidth", "setSaveOnDisk", "libimageloader_release"})
  public static final class a
  {
    public boolean hea = true;
    public boolean heb;
    String hec = "";
    e.c hed;
    public int hee;
    public int hef;
    public int heg;
    Drawable heh;
    int hei;
    public int hej;
    Drawable hek;
    final boolean hel;
    public Animation hem;
    public boolean hen;
    
    public a()
    {
      e.b localb = e.hdZ;
      this.hed = e.are();
      this.hel = true;
    }
    
    public final a a(e.c paramc)
    {
      p.h(paramc, "_loadFrom");
      this.hed = paramc;
      return this;
    }
    
    public final e arf()
    {
      return new e(this, (byte)0);
    }
    
    public final a w(Drawable paramDrawable)
    {
      p.h(paramDrawable, "_drawable");
      this.hek = paramDrawable;
      return this;
    }
    
    public final a xY(String paramString)
    {
      p.h(paramString, "_path");
      this.hec = paramString;
      return this;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEFAULT_LOAD_FROM", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getDEFAULT_LOAD_FROM", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "createSimpleOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "libimageloader_release"})
  public static final class b
  {
    public static e arg()
    {
      return new e.a().arf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.c.e
 * JD-Core Version:    0.7.0.1
 */