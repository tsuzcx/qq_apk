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
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader;", "", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "avatarLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "avatarOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "avatarWithoutDefaultOption", "bigAvatarOption", "coverOption", "defaultAvatar", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "defaultOption", "defaultRoundAvatar", "getDefaultRoundAvatar", "imageLoaderConfiguration", "instance", "getInstance", "msgThumbOption", "previewAvatar", "getPreviewAvatar", "previewAvatarConfiguration", "getPreviewAvatarConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "rectAvatar", "getRectAvatar", "rectAvatarConfiguration", "timelineOption", "wxAvatar", "getWxAvatar", "wxAvatarLoaderConfiguration", "wxAvatarOption", "getOption", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "LoaderType", "plugin-finder_release"})
public final class h
{
  private static final Bitmap nyv;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> rtA;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> rtB;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> rtC;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> rtD;
  private static final com.tencent.mm.loader.c.d<j, Bitmap> rtE;
  private static final com.tencent.mm.loader.d<j> rtF;
  private static final com.tencent.mm.loader.d<j> rtG;
  private static final com.tencent.mm.loader.d<j> rtH;
  private static final com.tencent.mm.loader.d<j> rtI;
  private static final com.tencent.mm.loader.d<j> rtJ;
  public static final h rtK;
  private static final com.tencent.mm.loader.c.e rtq;
  private static final com.tencent.mm.loader.c.e rtr;
  private static final com.tencent.mm.loader.c.e rts;
  private static final com.tencent.mm.loader.c.e rtu;
  private static final com.tencent.mm.loader.c.e rtv;
  private static final Bitmap rtw;
  private static final com.tencent.mm.loader.c.e rtx;
  private static final com.tencent.mm.loader.c.e rty;
  private static final com.tencent.mm.loader.c.e rtz;
  
  static
  {
    AppMethodBeat.i(166329);
    rtK = new h();
    Object localObject1 = new e.a();
    ((e.a)localObject1).gKq = true;
    ((e.a)localObject1).gKp = true;
    rtq = ((e.a)localObject1).aot();
    localObject1 = new e.a();
    ((e.a)localObject1).gKq = true;
    ((e.a)localObject1).gKp = true;
    ((e.a)localObject1).gKy = 2131099682;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    ((e.a)localObject1).gKu = com.tencent.mm.plugin.finder.storage.b.cyf();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    ((e.a)localObject1).gKt = com.tencent.mm.plugin.finder.storage.b.cyg();
    localObject2 = (Animation)new AlphaAnimation(0.0F, 1.0F);
    k.h(localObject2, "animation");
    ((e.a)localObject1).gKB = ((Animation)localObject2);
    rtr = ((e.a)localObject1).aot();
    localObject1 = new e.a();
    ((e.a)localObject1).gKq = true;
    ((e.a)localObject1).gKp = true;
    ((e.a)localObject1).gKy = 2131099682;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    ((e.a)localObject1).gKu = com.tencent.mm.plugin.finder.storage.b.cyj();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    ((e.a)localObject1).gKt = com.tencent.mm.plugin.finder.storage.b.cyk();
    rts = ((e.a)localObject1).aot();
    localObject1 = new e.a();
    ((e.a)localObject1).gKq = true;
    ((e.a)localObject1).gKp = true;
    ((e.a)localObject1).gKy = 2131099682;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    ((e.a)localObject1).gKu = com.tencent.mm.plugin.finder.storage.b.cym();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    ((e.a)localObject1).gKt = com.tencent.mm.plugin.finder.storage.b.cyn();
    rtu = ((e.a)localObject1).aot();
    localObject1 = new e.a();
    ((e.a)localObject1).gKq = true;
    ((e.a)localObject1).gKp = true;
    ((e.a)localObject1).gKy = 2131099682;
    localObject2 = ai.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      k.fOy();
    }
    ((e.a)localObject1).gKt = ((Resources)localObject2).getDimensionPixelSize(2131165302);
    localObject2 = ai.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      k.fOy();
    }
    ((e.a)localObject1).gKu = ((Resources)localObject2).getDimensionPixelSize(2131165302);
    rtv = ((e.a)localObject1).aot();
    localObject1 = com.tencent.mm.compatible.e.a.decodeResource(ai.getContext().getResources(), 2131690013);
    nyv = (Bitmap)localObject1;
    rtw = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, false, nyv.getWidth() * 0.5F);
    localObject1 = new e.a();
    ((e.a)localObject1).gKq = true;
    ((e.a)localObject1).gKp = true;
    localObject1 = ((e.a)localObject1).w((Drawable)new BitmapDrawable(rtw));
    ((e.a)localObject1).gKu = 132;
    ((e.a)localObject1).gKt = 132;
    rtx = ((e.a)localObject1).aot();
    localObject1 = new e.a();
    ((e.a)localObject1).gKq = true;
    ((e.a)localObject1).gKp = true;
    localObject2 = ai.getContext().getResources().getDrawable(2131231875);
    k.g(localObject2, "MMApplicationContext.get….drawable.default_avatar)");
    rty = ((e.a)localObject1).w((Drawable)localObject2).aot();
    localObject1 = new e.a();
    ((e.a)localObject1).gKq = true;
    ((e.a)localObject1).gKp = true;
    ((e.a)localObject1).gKy = 2131099682;
    ((e.a)localObject1).gKu = 132;
    ((e.a)localObject1).gKt = 132;
    rtz = ((e.a)localObject1).aot();
    rtA = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new c()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new b()).b(rtq).aod();
    rtB = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(rtx).b((com.tencent.mm.loader.d.d)new b()).a(new com.tencent.mm.loader.e.c.c(0.5F).aoy()).aod();
    rtC = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(rty).a(new com.tencent.mm.loader.e.c.c(0.1F).aoy()).aod();
    rtD = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(rtx).aod();
    rtE = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new e()).a((com.tencent.mm.loader.d.b)new g()).a((com.tencent.mm.loader.f.f)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new b()).b(rtq).aod();
    localObject1 = com.tencent.mm.loader.e.gIC;
    rtF = com.tencent.mm.loader.e.a(rtA);
    localObject1 = com.tencent.mm.loader.e.gIC;
    rtG = com.tencent.mm.loader.e.a(rtB);
    localObject1 = com.tencent.mm.loader.e.gIC;
    rtH = com.tencent.mm.loader.e.a(rtC);
    localObject1 = com.tencent.mm.loader.e.gIC;
    rtI = com.tencent.mm.loader.e.a(rtD);
    localObject1 = com.tencent.mm.loader.e.gIC;
    rtJ = com.tencent.mm.loader.e.a(rtE);
    AppMethodBeat.o(166329);
  }
  
  public static com.tencent.mm.loader.c.e a(a parama)
  {
    AppMethodBeat.i(166328);
    k.h(parama, "type");
    switch (i.cfA[parama.ordinal()])
    {
    default: 
      parama = rtq;
      AppMethodBeat.o(166328);
      return parama;
    case 1: 
      parama = rtr;
      AppMethodBeat.o(166328);
      return parama;
    case 2: 
      parama = rtr;
      AppMethodBeat.o(166328);
      return parama;
    case 3: 
      parama = rtx;
      AppMethodBeat.o(166328);
      return parama;
    case 4: 
      parama = rtz;
      AppMethodBeat.o(166328);
      return parama;
    case 5: 
      parama = rtv;
      AppMethodBeat.o(166328);
      return parama;
    case 6: 
      parama = rts;
      AppMethodBeat.o(166328);
      return parama;
    case 7: 
      parama = rtu;
      AppMethodBeat.o(166328);
      return parama;
    }
    parama = rty;
    AppMethodBeat.o(166328);
    return parama;
  }
  
  public static com.tencent.mm.loader.d<j> cwn()
  {
    return rtF;
  }
  
  public static com.tencent.mm.loader.d<j> cwo()
  {
    return rtG;
  }
  
  public static com.tencent.mm.loader.d<j> cwp()
  {
    return rtH;
  }
  
  public static com.tencent.mm.loader.d<j> cwq()
  {
    return rtJ;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "", "(Ljava/lang/String;I)V", "TIMELINE", "FEED_DETAIL", "AVATAR", "WX_AVATAR", "AVATAR_WITHOUT_DEFAULT", "MSG_THUMB", "DEFAULT", "BIG_AVATAR", "PROFILE_COVER", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166324);
      a locala1 = new a("TIMELINE", 0);
      rtL = locala1;
      a locala2 = new a("FEED_DETAIL", 1);
      rtM = locala2;
      a locala3 = new a("AVATAR", 2);
      rtN = locala3;
      a locala4 = new a("WX_AVATAR", 3);
      rtO = locala4;
      a locala5 = new a("AVATAR_WITHOUT_DEFAULT", 4);
      rtP = locala5;
      a locala6 = new a("MSG_THUMB", 5);
      rtQ = locala6;
      a locala7 = new a("DEFAULT", 6);
      rtR = locala7;
      a locala8 = new a("BIG_AVATAR", 7);
      rtS = locala8;
      a locala9 = new a("PROFILE_COVER", 8);
      rtT = locala9;
      rtU = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9 };
      AppMethodBeat.o(166324);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.h
 * JD-Core Version:    0.7.0.1
 */