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
import com.tencent.mm.loader.e.c.b.b;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader;", "", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "avatarLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "avatarOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "avatarWithoutDefaultOption", "bigAvatarOption", "blurImageLoaderConfiguration", "blurInstance", "getBlurInstance", "coverOption", "darkTimelineOption", "defaultAvatar", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "defaultOption", "defaultRoundAvatar", "getDefaultRoundAvatar", "halfImageLoaderConfiguration", "halfRectInstance", "getHalfRectInstance", "imageLoaderConfiguration", "instance", "getInstance", "msgThumbOption", "previewAvatar", "getPreviewAvatar", "previewAvatarConfiguration", "getPreviewAvatarConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "rectAvatar", "getRectAvatar", "rectAvatarConfiguration", "rectAvatarOption", "timelineOption", "wxAvatar", "getWxAvatar", "wxAvatarLoaderConfiguration", "wxAvatarOption", "getOption", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "LoaderType", "plugin-finder_release"})
public final class m
{
  private static final Bitmap pqA;
  private static final com.tencent.mm.loader.c.e uIB;
  private static final com.tencent.mm.loader.c.e uIC;
  private static final com.tencent.mm.loader.c.e uID;
  private static final com.tencent.mm.loader.c.e uIE;
  private static final com.tencent.mm.loader.c.e uIF;
  private static final com.tencent.mm.loader.c.e uIG;
  private static final Bitmap uIH;
  private static final com.tencent.mm.loader.c.e uII;
  private static final com.tencent.mm.loader.c.e uIJ;
  private static final com.tencent.mm.loader.c.e uIK;
  private static final com.tencent.mm.loader.c.e uIL;
  private static final com.tencent.mm.loader.c.d<o, Bitmap> uIM;
  private static final com.tencent.mm.loader.c.d<o, Bitmap> uIN;
  private static final com.tencent.mm.loader.c.d<o, Bitmap> uIO;
  private static final com.tencent.mm.loader.c.d<o, Bitmap> uIP;
  private static final com.tencent.mm.loader.c.d<o, Bitmap> uIQ;
  private static final com.tencent.mm.loader.c.d<o, Bitmap> uIR;
  private static final com.tencent.mm.loader.c.d<o, Bitmap> uIS;
  private static final com.tencent.mm.loader.d<o> uIT;
  private static final com.tencent.mm.loader.d<o> uIU;
  private static final com.tencent.mm.loader.d<o> uIV;
  private static final com.tencent.mm.loader.d<o> uIW;
  private static final com.tencent.mm.loader.d<o> uIX;
  private static final com.tencent.mm.loader.d<o> uIY;
  private static final com.tencent.mm.loader.d<o> uIZ;
  public static final m uJa;
  
  static
  {
    AppMethodBeat.i(166329);
    uJa = new m();
    Object localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZN = com.tencent.mm.plugin.finder.storage.c.dqO();
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZM = com.tencent.mm.plugin.finder.storage.c.dqP();
    uIB = ((e.a)localObject1).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZR = 2131099692;
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZN = com.tencent.mm.plugin.finder.storage.c.dqO();
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZM = com.tencent.mm.plugin.finder.storage.c.dqP();
    uIC = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZR = 2131099740;
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZN = com.tencent.mm.plugin.finder.storage.c.dqO();
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZM = com.tencent.mm.plugin.finder.storage.c.dqP();
    uID = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZR = 2131099692;
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZN = com.tencent.mm.plugin.finder.storage.c.dqS();
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZM = com.tencent.mm.plugin.finder.storage.c.dqT();
    uIE = ((e.a)localObject1).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZR = 2131099692;
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZN = com.tencent.mm.plugin.finder.storage.c.dqV();
    localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    ((e.a)localObject1).hZM = com.tencent.mm.plugin.finder.storage.c.dqW();
    uIF = ((e.a)localObject1).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZR = 2131099692;
    localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.hyc();
    }
    ((e.a)localObject1).hZM = ((Resources)localObject2).getDimensionPixelSize(2131165313);
    localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.hyc();
    }
    ((e.a)localObject1).hZN = ((Resources)localObject2).getDimensionPixelSize(2131165313);
    uIG = ((e.a)localObject1).aJT();
    localObject1 = com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getContext().getResources(), 2131690042);
    pqA = (Bitmap)localObject1;
    uIH = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, pqA.getWidth() * 0.5F);
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    localObject1 = ((e.a)localObject1).w((Drawable)new BitmapDrawable(uIH));
    ((e.a)localObject1).hZN = 132;
    ((e.a)localObject1).hZM = 132;
    uII = ((e.a)localObject1).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    localObject1 = ((e.a)localObject1).w((Drawable)new BitmapDrawable(pqA));
    ((e.a)localObject1).hZN = 132;
    ((e.a)localObject1).hZM = 132;
    uIJ = ((e.a)localObject1).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    localObject2 = MMApplicationContext.getContext().getResources().getDrawable(2131231957);
    p.g(localObject2, "MMApplicationContext.get….drawable.default_avatar)");
    uIK = ((e.a)localObject1).w((Drawable)localObject2).aJT();
    localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZR = 2131099692;
    ((e.a)localObject1).hZN = 132;
    ((e.a)localObject1).hZM = 132;
    uIL = ((e.a)localObject1).aJT();
    uIM = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new h()).a((com.tencent.mm.loader.d.b)new f()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new c()).b(uIB).aJE();
    uIN = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new h()).a((com.tencent.mm.loader.d.b)new j()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(uII).b((com.tencent.mm.loader.d.d)new c()).b(new com.tencent.mm.loader.e.c.c(0.5F).aJY()).aJE();
    uIO = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new h()).a((com.tencent.mm.loader.d.b)new j()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(uIK).b(new com.tencent.mm.loader.e.c.c(0.1F).aJY()).aJE();
    uIP = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new h()).a((com.tencent.mm.loader.d.b)new j()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(uII).b((com.tencent.mm.loader.d.d)new c()).aJE();
    uIQ = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new h()).a((com.tencent.mm.loader.d.b)new j()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new c()).b(uIB).aJE();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new h()).a((com.tencent.mm.loader.d.b)new f()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new c());
    localObject2 = new d(Integer.valueOf(2131099833));
    ((com.tencent.mm.loader.e.c.b)localObject2).iaK = b.b.iaR;
    uIR = ((com.tencent.mm.loader.c.b)localObject1).b((com.tencent.mm.loader.e.c.b)localObject2).b(uIB).aJE();
    localObject1 = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new h());
    localObject2 = com.tencent.mm.plugin.finder.upload.o.vTw;
    uIS = ((com.tencent.mm.loader.c.b)localObject1).a((com.tencent.mm.loader.d.b)new f(com.tencent.mm.plugin.finder.upload.o.dBk())).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new c()).b(uIB).aJE();
    localObject1 = com.tencent.mm.loader.e.hXU;
    uIT = com.tencent.mm.loader.e.a(uIM);
    localObject1 = com.tencent.mm.loader.e.hXU;
    uIU = com.tencent.mm.loader.e.a(uIS);
    localObject1 = com.tencent.mm.loader.e.hXU;
    uIV = com.tencent.mm.loader.e.a(uIN);
    localObject1 = com.tencent.mm.loader.e.hXU;
    uIW = com.tencent.mm.loader.e.a(uIO);
    localObject1 = com.tencent.mm.loader.e.hXU;
    uIX = com.tencent.mm.loader.e.a(uIP);
    localObject1 = com.tencent.mm.loader.e.hXU;
    uIY = com.tencent.mm.loader.e.a(uIQ);
    localObject1 = com.tencent.mm.loader.e.hXU;
    uIZ = com.tencent.mm.loader.e.a(uIR);
    AppMethodBeat.o(166329);
  }
  
  public static com.tencent.mm.loader.c.e a(m.a parama)
  {
    AppMethodBeat.i(166328);
    p.h(parama, "type");
    switch (n.$EnumSwitchMapping$0[parama.ordinal()])
    {
    default: 
      parama = uIB;
      AppMethodBeat.o(166328);
      return parama;
    case 1: 
      parama = uIC;
      AppMethodBeat.o(166328);
      return parama;
    case 2: 
      parama = uID;
      AppMethodBeat.o(166328);
      return parama;
    case 3: 
      parama = uIC;
      AppMethodBeat.o(166328);
      return parama;
    case 4: 
      parama = uII;
      AppMethodBeat.o(166328);
      return parama;
    case 5: 
      parama = uIJ;
      AppMethodBeat.o(166328);
      return parama;
    case 6: 
      parama = uIL;
      AppMethodBeat.o(166328);
      return parama;
    case 7: 
      parama = uIG;
      AppMethodBeat.o(166328);
      return parama;
    case 8: 
      parama = uIE;
      AppMethodBeat.o(166328);
      return parama;
    case 9: 
      parama = uIF;
      AppMethodBeat.o(166328);
      return parama;
    }
    parama = uIK;
    AppMethodBeat.o(166328);
    return parama;
  }
  
  public static com.tencent.mm.loader.d<o> djY()
  {
    return uIT;
  }
  
  public static com.tencent.mm.loader.d<o> djZ()
  {
    return uIU;
  }
  
  public static com.tencent.mm.loader.d<o> dka()
  {
    return uIV;
  }
  
  public static com.tencent.mm.loader.d<o> dkb()
  {
    return uIW;
  }
  
  public static com.tencent.mm.loader.d<o> dkc()
  {
    return uIX;
  }
  
  public static com.tencent.mm.loader.d<o> dkd()
  {
    return uIY;
  }
  
  public static com.tencent.mm.loader.d<o> dke()
  {
    return uIZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.m
 * JD-Core Version:    0.7.0.1
 */