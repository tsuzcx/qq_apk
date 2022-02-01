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
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader;", "", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "avatarLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "avatarOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "avatarWithoutDefaultOption", "bigAvatarOption", "coverOption", "defaultAvatar", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "defaultOption", "defaultRoundAvatar", "getDefaultRoundAvatar", "imageLoaderConfiguration", "instance", "getInstance", "msgThumbOption", "rectAvatar", "getRectAvatar", "rectAvatarConfiguration", "timelineOption", "wxAvatar", "getWxAvatar", "wxAvatarLoaderConfiguration", "wxAvatarOption", "getOption", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "LoaderType", "plugin-finder_release"})
public final class h
{
  private static final Bitmap mVW;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> qCA;
  private static final com.tencent.mm.loader.d<j> qCB;
  private static final com.tencent.mm.loader.d<j> qCC;
  private static final com.tencent.mm.loader.d<j> qCD;
  private static final com.tencent.mm.loader.d<j> qCE;
  public static final h qCF;
  private static final com.tencent.mm.loader.c.e qCo;
  private static final com.tencent.mm.loader.c.e qCp;
  private static final com.tencent.mm.loader.c.e qCq;
  private static final com.tencent.mm.loader.c.e qCr;
  private static final com.tencent.mm.loader.c.e qCs;
  private static final Bitmap qCt;
  private static final com.tencent.mm.loader.c.e qCu;
  private static final com.tencent.mm.loader.c.e qCv;
  private static final com.tencent.mm.loader.c.e qCw;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> qCx;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> qCy;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> qCz;
  
  static
  {
    AppMethodBeat.i(166329);
    qCF = new h();
    Object localObject1 = new e.a();
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjD = true;
    qCo = ((e.a)localObject1).ahr();
    localObject1 = new e.a();
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjD = true;
    ((e.a)localObject1).KBE = 2131099682;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    ((e.a)localObject1).gjI = com.tencent.mm.plugin.finder.storage.b.coH();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    ((e.a)localObject1).gjH = com.tencent.mm.plugin.finder.storage.b.coI();
    localObject2 = (Animation)new AlphaAnimation(0.0F, 1.0F);
    k.h(localObject2, "animation");
    ((e.a)localObject1).gjO = ((Animation)localObject2);
    qCp = ((e.a)localObject1).ahr();
    localObject1 = new e.a();
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjD = true;
    ((e.a)localObject1).KBE = 2131099682;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    ((e.a)localObject1).gjI = com.tencent.mm.plugin.finder.storage.b.coL();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    ((e.a)localObject1).gjH = com.tencent.mm.plugin.finder.storage.b.coM();
    qCq = ((e.a)localObject1).ahr();
    localObject1 = new e.a();
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjD = true;
    ((e.a)localObject1).KBE = 2131099682;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    ((e.a)localObject1).gjI = com.tencent.mm.plugin.finder.storage.b.coO();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    ((e.a)localObject1).gjH = com.tencent.mm.plugin.finder.storage.b.coP();
    qCr = ((e.a)localObject1).ahr();
    localObject1 = new e.a();
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjD = true;
    ((e.a)localObject1).KBE = 2131099682;
    localObject2 = aj.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      k.fvU();
    }
    ((e.a)localObject1).gjH = ((Resources)localObject2).getDimensionPixelSize(2131165302);
    localObject2 = aj.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      k.fvU();
    }
    ((e.a)localObject1).gjI = ((Resources)localObject2).getDimensionPixelSize(2131165302);
    qCs = ((e.a)localObject1).ahr();
    localObject1 = com.tencent.mm.compatible.e.a.decodeResource(aj.getContext().getResources(), 2131690013);
    mVW = (Bitmap)localObject1;
    qCt = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, false, mVW.getWidth() * 0.5F);
    localObject1 = new e.a();
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjD = true;
    localObject1 = ((e.a)localObject1).w((Drawable)new BitmapDrawable(qCt));
    ((e.a)localObject1).gjI = 132;
    ((e.a)localObject1).gjH = 132;
    qCu = ((e.a)localObject1).ahr();
    localObject1 = new e.a();
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjD = true;
    localObject2 = aj.getContext().getResources().getDrawable(2131231875);
    k.g(localObject2, "MMApplicationContext.get….drawable.default_avatar)");
    qCv = ((e.a)localObject1).w((Drawable)localObject2).ahr();
    localObject1 = new e.a();
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjD = true;
    ((e.a)localObject1).KBE = 2131099682;
    ((e.a)localObject1).gjI = 132;
    ((e.a)localObject1).gjH = 132;
    qCw = ((e.a)localObject1).ahr();
    qCx = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new c()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new b()).b(qCo).ahb();
    qCy = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(qCu).b((com.tencent.mm.loader.d.d)new b()).b(new com.tencent.mm.loader.e.c.c(0.5F).ahw()).ahb();
    qCz = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(qCv).b(new com.tencent.mm.loader.e.c.c(0.1F).ahw()).ahb();
    qCA = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(qCu).ahb();
    localObject1 = com.tencent.mm.loader.e.ghT;
    qCB = com.tencent.mm.loader.e.a(qCx);
    localObject1 = com.tencent.mm.loader.e.ghT;
    qCC = com.tencent.mm.loader.e.a(qCy);
    localObject1 = com.tencent.mm.loader.e.ghT;
    qCD = com.tencent.mm.loader.e.a(qCz);
    localObject1 = com.tencent.mm.loader.e.ghT;
    qCE = com.tencent.mm.loader.e.a(qCA);
    AppMethodBeat.o(166329);
  }
  
  public static com.tencent.mm.loader.c.e a(a parama)
  {
    AppMethodBeat.i(166328);
    k.h(parama, "type");
    switch (i.ciE[parama.ordinal()])
    {
    default: 
      parama = qCo;
      AppMethodBeat.o(166328);
      return parama;
    case 1: 
      parama = qCp;
      AppMethodBeat.o(166328);
      return parama;
    case 2: 
      parama = qCp;
      AppMethodBeat.o(166328);
      return parama;
    case 3: 
      parama = qCu;
      AppMethodBeat.o(166328);
      return parama;
    case 4: 
      parama = qCw;
      AppMethodBeat.o(166328);
      return parama;
    case 5: 
      parama = qCs;
      AppMethodBeat.o(166328);
      return parama;
    case 6: 
      parama = qCq;
      AppMethodBeat.o(166328);
      return parama;
    case 7: 
      parama = qCr;
      AppMethodBeat.o(166328);
      return parama;
    }
    parama = qCv;
    AppMethodBeat.o(166328);
    return parama;
  }
  
  public static com.tencent.mm.loader.d<j> cmU()
  {
    return qCB;
  }
  
  public static com.tencent.mm.loader.d<j> cmV()
  {
    return qCC;
  }
  
  public static com.tencent.mm.loader.d<j> cmW()
  {
    return qCD;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "", "(Ljava/lang/String;I)V", "TIMELINE", "FEED_DETAIL", "AVATAR", "WX_AVATAR", "AVATAR_WITHOUT_DEFAULT", "MSG_THUMB", "DEFAULT", "BIG_AVATAR", "PROFILE_COVER", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166324);
      a locala1 = new a("TIMELINE", 0);
      qCG = locala1;
      a locala2 = new a("FEED_DETAIL", 1);
      qCH = locala2;
      a locala3 = new a("AVATAR", 2);
      qCI = locala3;
      a locala4 = new a("WX_AVATAR", 3);
      qCJ = locala4;
      a locala5 = new a("AVATAR_WITHOUT_DEFAULT", 4);
      qCK = locala5;
      a locala6 = new a("MSG_THUMB", 5);
      qCL = locala6;
      a locala7 = new a("DEFAULT", 6);
      qCM = locala7;
      a locala8 = new a("BIG_AVATAR", 7);
      qCN = locala8;
      a locala9 = new a("PROFILE_COVER", 8);
      qCO = locala9;
      qCP = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9 };
      AppMethodBeat.o(166324);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.h
 * JD-Core Version:    0.7.0.1
 */