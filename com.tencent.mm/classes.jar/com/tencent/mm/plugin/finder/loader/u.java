package com.tencent.mm.plugin.finder.loader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.e.c.c;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderLoaderConfig;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/plugin/finder/loader/IFinderLoader;", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "avatarLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "avatarOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "avatarWithoutDefaultOption", "bgBlurImageLoaderConfiguration", "bgBlurInstance", "getBgBlurInstance", "bigAvatarOption", "blurImageLoaderConfiguration", "blurInstance", "getBlurInstance", "coverOption", "darkLiveSquareOption", "darkTimelineOption", "defaultAvatar", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "defaultOption", "defaultRoundAvatar", "getDefaultRoundAvatar", "effectImageLoaderConfiguration", "effectInstance", "getEffectInstance", "halfImageLoaderConfiguration", "halfRectInstance", "getHalfRectInstance", "imageLoaderConfiguration", "instance", "getInstance", "likeHotOption", "linkThumbOption", "liveShoppingOption", "msgThumbOption", "notWxUrlInstance", "getNotWxUrlInstance", "notWxUrlLoaderConfiguration", "previewAvatar", "getPreviewAvatar", "previewAvatarConfiguration", "getPreviewAvatarConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "rectAvatar", "getRectAvatar", "rectAvatarConfiguration", "rectAvatarOption", "timelineOption", "wxAvatar", "getWxAvatar", "wxAvatarLoaderConfiguration", "wxAvatarOption", "getOption", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "plugin-finder_release"})
public final class u
  extends com.tencent.mm.ui.component.i<PluginFinder>
  implements ab
{
  private final Bitmap fgf;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuA;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuB;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuC;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuD;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuE;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuF;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuG;
  private final com.tencent.mm.loader.c.e zuH;
  private final com.tencent.mm.loader.c.e zuI;
  private final com.tencent.mm.loader.d<w> zuJ;
  private final com.tencent.mm.loader.d<w> zuK;
  private final com.tencent.mm.loader.d<w> zuL;
  private final com.tencent.mm.loader.d<w> zuM;
  private final com.tencent.mm.loader.d<w> zuN;
  private final com.tencent.mm.loader.d<w> zuO;
  private final com.tencent.mm.loader.d<w> zuP;
  private final com.tencent.mm.loader.d<w> zuQ;
  private final com.tencent.mm.loader.d<w> zuR;
  private final com.tencent.mm.loader.d<w> zuS;
  private final com.tencent.mm.loader.c.e zuk;
  private final com.tencent.mm.loader.c.e zul;
  private final com.tencent.mm.loader.c.e zum;
  private final com.tencent.mm.loader.c.e zun;
  private final com.tencent.mm.loader.c.e zuo;
  private final com.tencent.mm.loader.c.e zup;
  private final com.tencent.mm.loader.c.e zuq;
  private final com.tencent.mm.loader.c.e zur;
  private final Bitmap zus;
  private final com.tencent.mm.loader.c.e zut;
  private final com.tencent.mm.loader.c.e zuu;
  private final com.tencent.mm.loader.c.e zuv;
  private final com.tencent.mm.loader.c.e zuw;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zux;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuy;
  private final com.tencent.mm.loader.c.d<w, Bitmap> zuz;
  
  public u()
  {
    AppMethodBeat.i(282829);
    Object localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOt = com.tencent.mm.plugin.finder.storage.d.dSb();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOs = com.tencent.mm.plugin.finder.storage.d.dSc();
    this.zuk = ((e.a)localObject1).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOx = b.c.BW_97;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOt = com.tencent.mm.plugin.finder.storage.d.dSb();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOs = com.tencent.mm.plugin.finder.storage.d.dSc();
    this.zul = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOx = b.c.Dark_0;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOt = com.tencent.mm.plugin.finder.storage.d.dSb();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOs = com.tencent.mm.plugin.finder.storage.d.dSc();
    this.zum = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOx = b.c.Dark_0;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOt = com.tencent.mm.plugin.finder.storage.d.dSb();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOs = com.tencent.mm.plugin.finder.storage.d.dSc();
    this.zun = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOx = b.c.BW_97;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOt = com.tencent.mm.plugin.finder.storage.d.dSg();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOs = com.tencent.mm.plugin.finder.storage.d.dSh();
    this.zuo = ((e.a)localObject1).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOx = b.c.BW_97;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOt = com.tencent.mm.plugin.finder.storage.d.dSj();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOs = com.tencent.mm.plugin.finder.storage.d.dSk();
    this.zup = ((e.a)localObject1).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOx = b.c.BW_97;
    localObject2 = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      kotlin.g.b.p.iCn();
    }
    ((e.a)localObject1).kOs = ((Resources)localObject2).getDimensionPixelSize(b.d.Edge_9A);
    localObject2 = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      kotlin.g.b.p.iCn();
    }
    ((e.a)localObject1).kOt = ((Resources)localObject2).getDimensionPixelSize(b.d.Edge_9A);
    this.zuq = ((e.a)localObject1).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOx = b.c.hot_tab_BW_100_Alpha_0_1;
    localObject2 = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      kotlin.g.b.p.iCn();
    }
    ((e.a)localObject1).kOs = ((Resources)localObject2).getDimensionPixelSize(b.d.Edge_3A);
    localObject2 = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      kotlin.g.b.p.iCn();
    }
    ((e.a)localObject1).kOt = ((Resources)localObject2).getDimensionPixelSize(b.d.Edge_3A);
    this.zur = ((e.a)localObject1).aRT();
    this.fgf = com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getContext().getResources(), b.i.default_avatar);
    this.zus = BitmapUtil.getRoundedCornerBitmap(this.fgf, false, this.fgf.getWidth() * 0.5F);
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    localObject1 = ((e.a)localObject1).B((Drawable)new BitmapDrawable(this.zus));
    ((e.a)localObject1).kOt = 132;
    ((e.a)localObject1).kOs = 132;
    this.zut = ((e.a)localObject1).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    localObject1 = ((e.a)localObject1).B((Drawable)new BitmapDrawable(this.fgf));
    ((e.a)localObject1).kOt = 132;
    ((e.a)localObject1).kOs = 132;
    this.zuu = ((e.a)localObject1).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    localObject2 = MMApplicationContext.getContext().getResources().getDrawable(b.e.default_avatar);
    kotlin.g.b.p.j(localObject2, "MMApplicationContext.get….drawable.default_avatar)");
    localObject1 = ((e.a)localObject1).B((Drawable)localObject2);
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOt = com.tencent.mm.plugin.finder.storage.d.dSg();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOs = com.tencent.mm.plugin.finder.storage.d.dSg();
    this.zuv = ((e.a)localObject1).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOx = b.c.BW_97;
    ((e.a)localObject1).kOt = 132;
    ((e.a)localObject1).kOs = 132;
    this.zuw = ((e.a)localObject1).aRT();
    this.zux = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new l()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new h()).b((com.tencent.mm.loader.d.d)new i()).b(this.zuk).aRE();
    this.zuy = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new q()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new h()).b((com.tencent.mm.loader.d.d)new i()).b(this.zuk).aRE();
    this.zuz = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new q()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new h()).b(this.zut).b((com.tencent.mm.loader.d.d)new i()).b(new c(0.5F).aRY()).aRE();
    this.zuA = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new q()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(this.zuv).b(new c(0.1F).aRY()).aRE();
    this.zuB = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new q()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(this.zut).b((com.tencent.mm.loader.d.d)new i()).aRE();
    this.zuC = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new q()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new i()).b(this.zuk).aRE();
    this.zuD = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new l()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new i()).b(new j(25.0F, Integer.valueOf(b.c.UN_BW_0_Alpha_0_2)).aRZ()).b(this.zuk).aRE();
    this.zuE = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new l()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new i()).b(new j(100.0F, Integer.valueOf(b.c.UN_BW_0_Alpha_0_2)).aRZ()).b(this.zuk).aRE();
    this.zuF = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n()).a((com.tencent.mm.loader.d.b)new l()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new p()).b(this.zuk).aRE();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new n());
    localObject2 = o.AAZ;
    this.zuG = ((com.tencent.mm.loader.c.b)localObject1).a((com.tencent.mm.loader.d.b)new l(o.ecs())).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new i()).b(this.zuk).aRE();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    localObject2 = MMApplicationContext.getContext().getResources().getDrawable(b.e.finder_live_shopping_default);
    kotlin.g.b.p.j(localObject2, "MMApplicationContext.get…er_live_shopping_default)");
    localObject1 = ((e.a)localObject1).B((Drawable)localObject2);
    localObject2 = com.tencent.c.a.a.a.a.a.Zlt;
    ((e.a)localObject1).kOt = com.tencent.c.a.a.a.a.a.iml();
    localObject2 = com.tencent.c.a.a.a.a.a.Zlt;
    ((e.a)localObject1).kOs = com.tencent.c.a.a.a.a.a.iml();
    this.zuH = ((e.a)localObject1).aRT();
    localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOw = b.e.finder_filled_hot_like_red_big;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOt = com.tencent.mm.plugin.finder.storage.d.dSb();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    ((e.a)localObject1).kOs = com.tencent.mm.plugin.finder.storage.d.dSc();
    this.zuI = ((e.a)localObject1).aRT();
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuJ = com.tencent.mm.loader.e.a(this.zux);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuK = com.tencent.mm.loader.e.a(this.zuy);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuL = com.tencent.mm.loader.e.a(this.zuG);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuM = com.tencent.mm.loader.e.a(this.zuz);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuN = com.tencent.mm.loader.e.a(this.zuA);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuO = com.tencent.mm.loader.e.a(this.zuB);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuP = com.tencent.mm.loader.e.a(this.zuB);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuQ = com.tencent.mm.loader.e.a(this.zuD);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuR = com.tencent.mm.loader.e.a(this.zuE);
    localObject1 = com.tencent.mm.loader.e.kMy;
    this.zuS = com.tencent.mm.loader.e.a(this.zuF);
    AppMethodBeat.o(282829);
  }
  
  public final com.tencent.mm.loader.c.e a(t.a parama)
  {
    AppMethodBeat.i(282826);
    kotlin.g.b.p.k(parama, "type");
    switch (v.$EnumSwitchMapping$0[parama.ordinal()])
    {
    default: 
      parama = this.zuk;
      AppMethodBeat.o(282826);
      return parama;
    case 1: 
      parama = this.zul;
      AppMethodBeat.o(282826);
      return parama;
    case 2: 
      parama = this.zum;
      AppMethodBeat.o(282826);
      return parama;
    case 3: 
      parama = this.zul;
      AppMethodBeat.o(282826);
      return parama;
    case 4: 
      parama = this.zut;
      AppMethodBeat.o(282826);
      return parama;
    case 5: 
      parama = this.zuu;
      AppMethodBeat.o(282826);
      return parama;
    case 6: 
      parama = this.zuw;
      AppMethodBeat.o(282826);
      return parama;
    case 7: 
      parama = this.zuq;
      AppMethodBeat.o(282826);
      return parama;
    case 8: 
      parama = this.zur;
      AppMethodBeat.o(282826);
      return parama;
    case 9: 
      parama = this.zuo;
      AppMethodBeat.o(282826);
      return parama;
    case 10: 
      parama = this.zup;
      AppMethodBeat.o(282826);
      return parama;
    case 11: 
      parama = this.zuv;
      AppMethodBeat.o(282826);
      return parama;
    case 12: 
      parama = this.zuH;
      AppMethodBeat.o(282826);
      return parama;
    case 13: 
      parama = this.zun;
      AppMethodBeat.o(282826);
      return parama;
    }
    parama = this.zuI;
    AppMethodBeat.o(282826);
    return parama;
  }
  
  public final com.tencent.mm.loader.d<w> dJn()
  {
    return this.zuJ;
  }
  
  public final com.tencent.mm.loader.d<w> dJo()
  {
    return this.zuK;
  }
  
  public final com.tencent.mm.loader.d<w> dJp()
  {
    return this.zuL;
  }
  
  public final com.tencent.mm.loader.d<w> dJq()
  {
    return this.zuM;
  }
  
  public final com.tencent.mm.loader.d<w> dJr()
  {
    return this.zuN;
  }
  
  public final com.tencent.mm.loader.d<w> dJs()
  {
    return this.zuO;
  }
  
  public final com.tencent.mm.loader.d<w> dJt()
  {
    return this.zuP;
  }
  
  public final com.tencent.mm.loader.d<w> dJu()
  {
    return this.zuQ;
  }
  
  public final com.tencent.mm.loader.d<w> dJv()
  {
    return this.zuR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.u
 * JD-Core Version:    0.7.0.1
 */