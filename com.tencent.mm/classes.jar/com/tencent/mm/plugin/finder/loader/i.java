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
import com.tencent.mm.loader.f.g;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader;", "", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "avatarLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "avatarOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "avatarWithoutDefaultOption", "bigAvatarOption", "coverOption", "defaultAvatar", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "defaultOption", "defaultRoundAvatar", "getDefaultRoundAvatar", "imageLoaderConfiguration", "instance", "getInstance", "msgThumbOption", "previewAvatar", "getPreviewAvatar", "previewAvatarConfiguration", "getPreviewAvatarConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "rectAvatar", "getRectAvatar", "rectAvatarConfiguration", "rectAvatarOption", "timelineOption", "wxAvatar", "getWxAvatar", "wxAvatarLoaderConfiguration", "wxAvatarOption", "getOption", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "LoaderType", "plugin-finder_release"})
public final class i
{
  private static final Bitmap ofD;
  private static final com.tencent.mm.loader.c.e srC;
  private static final com.tencent.mm.loader.c.e srD;
  private static final com.tencent.mm.loader.c.e srE;
  private static final com.tencent.mm.loader.c.e srF;
  private static final com.tencent.mm.loader.c.e srG;
  private static final Bitmap srH;
  private static final com.tencent.mm.loader.c.e srI;
  private static final com.tencent.mm.loader.c.e srJ;
  private static final com.tencent.mm.loader.c.e srK;
  private static final com.tencent.mm.loader.c.e srL;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> srM;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> srN;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> srO;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> srP;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> srQ;
  private static final com.tencent.mm.loader.d<k> srR;
  private static final com.tencent.mm.loader.d<k> srS;
  private static final com.tencent.mm.loader.d<k> srT;
  private static final com.tencent.mm.loader.d<k> srU;
  private static final com.tencent.mm.loader.d<k> srV;
  public static final i srW;
  
  static
  {
    AppMethodBeat.i(166329);
    srW = new i();
    Object localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    srC = ((e.a)localObject1).aru();
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    ((e.a)localObject1).hgX = 2131099682;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((e.a)localObject1).hgT = com.tencent.mm.plugin.finder.storage.b.cHe();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((e.a)localObject1).hgS = com.tencent.mm.plugin.finder.storage.b.cHf();
    localObject2 = (Animation)new AlphaAnimation(0.0F, 1.0F);
    p.h(localObject2, "animation");
    ((e.a)localObject1).hha = ((Animation)localObject2);
    srD = ((e.a)localObject1).aru();
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    ((e.a)localObject1).hgX = 2131099682;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((e.a)localObject1).hgT = com.tencent.mm.plugin.finder.storage.b.cHi();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((e.a)localObject1).hgS = com.tencent.mm.plugin.finder.storage.b.cHj();
    srE = ((e.a)localObject1).aru();
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    ((e.a)localObject1).hgX = 2131099682;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((e.a)localObject1).hgT = com.tencent.mm.plugin.finder.storage.b.cHl();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((e.a)localObject1).hgS = com.tencent.mm.plugin.finder.storage.b.cHm();
    srF = ((e.a)localObject1).aru();
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    ((e.a)localObject1).hgX = 2131099682;
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.gkB();
    }
    ((e.a)localObject1).hgS = ((Resources)localObject2).getDimensionPixelSize(2131165302);
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.gkB();
    }
    ((e.a)localObject1).hgT = ((Resources)localObject2).getDimensionPixelSize(2131165302);
    srG = ((e.a)localObject1).aru();
    localObject1 = com.tencent.mm.compatible.e.a.decodeResource(ak.getContext().getResources(), 2131690013);
    ofD = (Bitmap)localObject1;
    srH = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject1, false, ofD.getWidth() * 0.5F);
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    localObject1 = ((e.a)localObject1).w((Drawable)new BitmapDrawable(srH));
    ((e.a)localObject1).hgT = 132;
    ((e.a)localObject1).hgS = 132;
    srI = ((e.a)localObject1).aru();
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    localObject1 = ((e.a)localObject1).w((Drawable)new BitmapDrawable(ofD));
    ((e.a)localObject1).hgT = 132;
    ((e.a)localObject1).hgS = 132;
    srJ = ((e.a)localObject1).aru();
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    localObject2 = ak.getContext().getResources().getDrawable(2131231875);
    p.g(localObject2, "MMApplicationContext.get….drawable.default_avatar)");
    srK = ((e.a)localObject1).w((Drawable)localObject2).aru();
    localObject1 = new e.a();
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hgO = true;
    ((e.a)localObject1).hgX = 2131099682;
    ((e.a)localObject1).hgT = 132;
    ((e.a)localObject1).hgS = 132;
    srL = ((e.a)localObject1).aru();
    srM = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new d()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new c()).b(srC).arf();
    srN = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new h()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(srI).b((com.tencent.mm.loader.d.d)new c()).b(new com.tencent.mm.loader.e.c.c(0.5F).arz()).arf();
    srO = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new h()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(srK).b(new com.tencent.mm.loader.e.c.c(0.1F).arz()).arf();
    srP = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new h()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(srI).b((com.tencent.mm.loader.d.d)new c()).arf();
    srQ = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new h()).a((g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new c()).b(srC).arf();
    localObject1 = com.tencent.mm.loader.e.hfa;
    srR = com.tencent.mm.loader.e.a(srM);
    localObject1 = com.tencent.mm.loader.e.hfa;
    srS = com.tencent.mm.loader.e.a(srN);
    localObject1 = com.tencent.mm.loader.e.hfa;
    srT = com.tencent.mm.loader.e.a(srO);
    localObject1 = com.tencent.mm.loader.e.hfa;
    srU = com.tencent.mm.loader.e.a(srP);
    localObject1 = com.tencent.mm.loader.e.hfa;
    srV = com.tencent.mm.loader.e.a(srQ);
    AppMethodBeat.o(166329);
  }
  
  public static com.tencent.mm.loader.c.e a(a parama)
  {
    AppMethodBeat.i(166328);
    p.h(parama, "type");
    switch (j.cqt[parama.ordinal()])
    {
    default: 
      parama = srC;
      AppMethodBeat.o(166328);
      return parama;
    case 1: 
      parama = srD;
      AppMethodBeat.o(166328);
      return parama;
    case 2: 
      parama = srD;
      AppMethodBeat.o(166328);
      return parama;
    case 3: 
      parama = srI;
      AppMethodBeat.o(166328);
      return parama;
    case 4: 
      parama = srJ;
      AppMethodBeat.o(166328);
      return parama;
    case 5: 
      parama = srL;
      AppMethodBeat.o(166328);
      return parama;
    case 6: 
      parama = srG;
      AppMethodBeat.o(166328);
      return parama;
    case 7: 
      parama = srE;
      AppMethodBeat.o(166328);
      return parama;
    case 8: 
      parama = srF;
      AppMethodBeat.o(166328);
      return parama;
    }
    parama = srK;
    AppMethodBeat.o(166328);
    return parama;
  }
  
  public static com.tencent.mm.loader.d<k> cEn()
  {
    return srR;
  }
  
  public static com.tencent.mm.loader.d<k> cEo()
  {
    return srS;
  }
  
  public static com.tencent.mm.loader.d<k> cEp()
  {
    return srT;
  }
  
  public static com.tencent.mm.loader.d<k> cEq()
  {
    return srU;
  }
  
  public static com.tencent.mm.loader.d<k> cEr()
  {
    return srV;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "", "(Ljava/lang/String;I)V", "TIMELINE", "FEED_DETAIL", "AVATAR", "RECT_AVATAR", "WX_AVATAR", "AVATAR_WITHOUT_DEFAULT", "MSG_THUMB", "DEFAULT", "BIG_AVATAR", "PROFILE_COVER", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166324);
      a locala1 = new a("TIMELINE", 0);
      srX = locala1;
      a locala2 = new a("FEED_DETAIL", 1);
      srY = locala2;
      a locala3 = new a("AVATAR", 2);
      srZ = locala3;
      a locala4 = new a("RECT_AVATAR", 3);
      ssa = locala4;
      a locala5 = new a("WX_AVATAR", 4);
      ssb = locala5;
      a locala6 = new a("AVATAR_WITHOUT_DEFAULT", 5);
      ssc = locala6;
      a locala7 = new a("MSG_THUMB", 6);
      ssd = locala7;
      a locala8 = new a("DEFAULT", 7);
      sse = locala8;
      a locala9 = new a("BIG_AVATAR", 8);
      ssf = locala9;
      a locala10 = new a("PROFILE_COVER", 9);
      ssg = locala10;
      ssh = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10 };
      AppMethodBeat.o(166324);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.i
 * JD-Core Version:    0.7.0.1
 */