package com.tencent.mm.loader.b;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "", "builder", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "defaultBackgroudColorId", "", "getDefaultBackgroudColorId", "()I", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "defaultBackgroundResId", "getDefaultBackgroundResId", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "defaultResId", "getDefaultResId", "fullPath", "", "isCacheInMemory", "", "()Z", "isRound", "isSaveOnDisk", "loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getLoadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "maxImageHeight", "getMaxImageHeight", "maxImageWidth", "getMaxImageWidth", "showEmptyImage", "getDefaultBackgroundDrawable", "resources", "Landroid/content/res/Resources;", "getfullPath", "Builder", "Companion", "LoadFrom", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static boolean DEBUG;
  public static final b npQ = new b((byte)0);
  private static final e.c nqb = e.c.nqq;
  public final String fullPath;
  public int noM;
  public final Animation noN;
  public final Drawable noO;
  public final boolean npR;
  public final boolean npS;
  public final e.c npT;
  public final int npU;
  public final int npV;
  private final int npW;
  private final Drawable npX;
  public final int npY;
  public final boolean npZ;
  private final boolean nqa;
  
  private e(a parama)
  {
    this.npR = parama.nqc;
    this.npS = parama.nqd;
    this.fullPath = parama.nqe;
    this.npT = parama.nqf;
    this.npU = parama.nqg;
    this.npV = parama.nqh;
    this.npW = parama.nqi;
    this.npX = parama.nqj;
    this.noN = parama.nqo;
    this.noM = parama.nqk;
    this.npY = parama.nql;
    this.noO = parama.nqm;
    this.nqa = parama.nqn;
    this.npZ = parama.nqp;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Builder;", "", "()V", "_animation", "Landroid/view/animation/Animation;", "get_animation", "()Landroid/view/animation/Animation;", "set_animation", "(Landroid/view/animation/Animation;)V", "_cacheInMemory", "", "get_cacheInMemory", "()Z", "set_cacheInMemory", "(Z)V", "_defaultBackgroudColorId", "", "get_defaultBackgroudColorId", "()I", "set_defaultBackgroudColorId", "(I)V", "_defaultBackgroudDrawable", "Landroid/graphics/drawable/Drawable;", "get_defaultBackgroudDrawable", "()Landroid/graphics/drawable/Drawable;", "set_defaultBackgroudDrawable", "(Landroid/graphics/drawable/Drawable;)V", "_defaultBackgroudResId", "get_defaultBackgroudResId", "set_defaultBackgroudResId", "_defaultDrawable", "get_defaultDrawable", "set_defaultDrawable", "_defualtResId", "get_defualtResId", "set_defualtResId", "_fullPath", "", "get_fullPath", "()Ljava/lang/String;", "set_fullPath", "(Ljava/lang/String;)V", "_isRound", "get_isRound", "set_isRound", "_loadFrom", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "get_loadFrom", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "set_loadFrom", "(Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;)V", "_maxImageHeight", "get_maxImageHeight", "set_maxImageHeight", "_maxImageWidth", "get_maxImageWidth", "set_maxImageWidth", "_saveOnDisk", "get_saveOnDisk", "set_saveOnDisk", "_showEmptyImage", "get_showEmptyImage", "build", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "setAnimation", "animation", "setCacheInMemory", "setDefaultBackgroudColor", "_resId", "setDefaultBackgroudDrawable", "_drawable", "setDefaultBackgroudResId", "setDefaultDrawable", "setDefaultResId", "setFullPath", "_path", "setIsRound", "setLoadFrom", "setMaxDisplayHeight", "_maxDisplayHeight", "setMaxDisplayWidth", "_maxDisplayWidth", "setSaveOnDisk", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public boolean nqc = true;
    public boolean nqd;
    String nqe = "";
    e.c nqf;
    public int nqg;
    public int nqh;
    public int nqi;
    Drawable nqj;
    public int nqk;
    public int nql;
    Drawable nqm;
    final boolean nqn;
    Animation nqo;
    public boolean nqp;
    
    public a()
    {
      e.b localb = e.npQ;
      this.nqf = e.blH();
      this.nqn = true;
    }
    
    public final a GG(String paramString)
    {
      s.u(paramString, "_path");
      this.nqe = paramString;
      return this;
    }
    
    public final a L(Drawable paramDrawable)
    {
      s.u(paramDrawable, "_drawable");
      this.nqm = paramDrawable;
      return this;
    }
    
    public final a a(e.c paramc)
    {
      s.u(paramc, "_loadFrom");
      this.nqf = paramc;
      return this;
    }
    
    public final a b(Animation paramAnimation)
    {
      s.u(paramAnimation, "animation");
      this.nqo = paramAnimation;
      return this;
    }
    
    public final e blI()
    {
      return new e(this, (byte)0);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEFAULT_LOAD_FROM", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "getDEFAULT_LOAD_FROM", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "createSimpleOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static e blJ()
    {
      return new e.a().blI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.b.e
 * JD-Core Version:    0.7.0.1
 */