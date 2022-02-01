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
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader;", "", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "avatarLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "avatarOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "avatarWithoutDefaultOption", "bigAvatarOption", "coverOption", "defaultAvatar", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "defaultOption", "defaultRoundAvatar", "getDefaultRoundAvatar", "imageLoaderConfiguration", "instance", "getInstance", "msgThumbOption", "previewAvatar", "getPreviewAvatar", "previewAvatarConfiguration", "getPreviewAvatarConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "rectAvatar", "getRectAvatar", "rectAvatarConfiguration", "timelineOption", "wxAvatar", "getWxAvatar", "wxAvatarLoaderConfiguration", "wxAvatarOption", "getOption", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "LoaderType", "plugin-finder_release"})
public final class i
{
  private static final Bitmap nZT;
  private static final com.tencent.mm.loader.c.e siH;
  private static final com.tencent.mm.loader.c.e siI;
  private static final com.tencent.mm.loader.c.e siJ;
  private static final com.tencent.mm.loader.c.e siK;
  private static final com.tencent.mm.loader.c.e siL;
  private static final Bitmap siM;
  private static final com.tencent.mm.loader.c.e siN;
  private static final com.tencent.mm.loader.c.e siO;
  private static final com.tencent.mm.loader.c.e siP;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> siQ;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> siR;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> siS;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> siT;
  private static final com.tencent.mm.loader.c.d<k, Bitmap> siU;
  private static final com.tencent.mm.loader.d<k> siV;
  private static final com.tencent.mm.loader.d<k> siW;
  private static final com.tencent.mm.loader.d<k> siX;
  private static final com.tencent.mm.loader.d<k> siY;
  private static final com.tencent.mm.loader.d<k> siZ;
  public static final i sja;
  
  static
  {
    AppMethodBeat.i(166329);
    sja = new i();
    Object localObject1 = new e.a();
    ((e.a)localObject1).heb = true;
    ((e.a)localObject1).hea = true;
    siH = ((e.a)localObject1).arf();
    localObject1 = new e.a();
    ((e.a)localObject1).heb = true;
    ((e.a)localObject1).hea = true;
    ((e.a)localObject1).hej = 2131099682;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    ((e.a)localObject1).hef = com.tencent.mm.plugin.finder.storage.b.cFh();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    ((e.a)localObject1).hee = com.tencent.mm.plugin.finder.storage.b.cFi();
    localObject2 = (Animation)new AlphaAnimation(0.0F, 1.0F);
    p.h(localObject2, "animation");
    ((e.a)localObject1).hem = ((Animation)localObject2);
    siI = ((e.a)localObject1).arf();
    localObject1 = new e.a();
    ((e.a)localObject1).heb = true;
    ((e.a)localObject1).hea = true;
    ((e.a)localObject1).hej = 2131099682;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    ((e.a)localObject1).hef = com.tencent.mm.plugin.finder.storage.b.cFl();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    ((e.a)localObject1).hee = com.tencent.mm.plugin.finder.storage.b.cFm();
    siJ = ((e.a)localObject1).arf();
    localObject1 = new e.a();
    ((e.a)localObject1).heb = true;
    ((e.a)localObject1).hea = true;
    ((e.a)localObject1).hej = 2131099682;
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    ((e.a)localObject1).hef = com.tencent.mm.plugin.finder.storage.b.cFo();
    localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    ((e.a)localObject1).hee = com.tencent.mm.plugin.finder.storage.b.cFp();
    siK = ((e.a)localObject1).arf();
    localObject1 = new e.a();
    ((e.a)localObject1).heb = true;
    ((e.a)localObject1).hea = true;
    ((e.a)localObject1).hej = 2131099682;
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.gfZ();
    }
    ((e.a)localObject1).hee = ((Resources)localObject2).getDimensionPixelSize(2131165302);
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources();
    if (localObject2 == null) {
      p.gfZ();
    }
    ((e.a)localObject1).hef = ((Resources)localObject2).getDimensionPixelSize(2131165302);
    siL = ((e.a)localObject1).arf();
    localObject1 = com.tencent.mm.compatible.e.a.decodeResource(aj.getContext().getResources(), 2131690013);
    nZT = (Bitmap)localObject1;
    siM = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject1, false, nZT.getWidth() * 0.5F);
    localObject1 = new e.a();
    ((e.a)localObject1).heb = true;
    ((e.a)localObject1).hea = true;
    localObject1 = ((e.a)localObject1).w((Drawable)new BitmapDrawable(siM));
    ((e.a)localObject1).hef = 132;
    ((e.a)localObject1).hee = 132;
    siN = ((e.a)localObject1).arf();
    localObject1 = new e.a();
    ((e.a)localObject1).heb = true;
    ((e.a)localObject1).hea = true;
    localObject2 = aj.getContext().getResources().getDrawable(2131231875);
    p.g(localObject2, "MMApplicationContext.get….drawable.default_avatar)");
    siO = ((e.a)localObject1).w((Drawable)localObject2).arf();
    localObject1 = new e.a();
    ((e.a)localObject1).heb = true;
    ((e.a)localObject1).hea = true;
    ((e.a)localObject1).hej = 2131099682;
    ((e.a)localObject1).hef = 132;
    ((e.a)localObject1).hee = 132;
    siP = ((e.a)localObject1).arf();
    siQ = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new d()).a((com.tencent.mm.loader.f.g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new c()).b(siH).aqQ();
    siR = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new h()).a((com.tencent.mm.loader.f.g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(siN).b((com.tencent.mm.loader.d.d)new c()).b(new com.tencent.mm.loader.e.c.c(0.5F).ark()).aqQ();
    siS = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new h()).a((com.tencent.mm.loader.f.g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(siO).b(new com.tencent.mm.loader.e.c.c(0.1F).ark()).aqQ();
    siT = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new h()).a((com.tencent.mm.loader.f.g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b(siN).aqQ();
    siU = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new f()).a((com.tencent.mm.loader.d.b)new h()).a((com.tencent.mm.loader.f.g)new com.tencent.mm.loader.e.a()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).b((com.tencent.mm.loader.d.d)new c()).b(siH).aqQ();
    localObject1 = com.tencent.mm.loader.e.hcm;
    siV = com.tencent.mm.loader.e.a(siQ);
    localObject1 = com.tencent.mm.loader.e.hcm;
    siW = com.tencent.mm.loader.e.a(siR);
    localObject1 = com.tencent.mm.loader.e.hcm;
    siX = com.tencent.mm.loader.e.a(siS);
    localObject1 = com.tencent.mm.loader.e.hcm;
    siY = com.tencent.mm.loader.e.a(siT);
    localObject1 = com.tencent.mm.loader.e.hcm;
    siZ = com.tencent.mm.loader.e.a(siU);
    AppMethodBeat.o(166329);
  }
  
  public static com.tencent.mm.loader.c.e a(a parama)
  {
    AppMethodBeat.i(166328);
    p.h(parama, "type");
    switch (j.cpQ[parama.ordinal()])
    {
    default: 
      parama = siH;
      AppMethodBeat.o(166328);
      return parama;
    case 1: 
      parama = siI;
      AppMethodBeat.o(166328);
      return parama;
    case 2: 
      parama = siI;
      AppMethodBeat.o(166328);
      return parama;
    case 3: 
      parama = siN;
      AppMethodBeat.o(166328);
      return parama;
    case 4: 
      parama = siP;
      AppMethodBeat.o(166328);
      return parama;
    case 5: 
      parama = siL;
      AppMethodBeat.o(166328);
      return parama;
    case 6: 
      parama = siJ;
      AppMethodBeat.o(166328);
      return parama;
    case 7: 
      parama = siK;
      AppMethodBeat.o(166328);
      return parama;
    }
    parama = siO;
    AppMethodBeat.o(166328);
    return parama;
  }
  
  public static com.tencent.mm.loader.d<k> cCB()
  {
    return siV;
  }
  
  public static com.tencent.mm.loader.d<k> cCC()
  {
    return siW;
  }
  
  public static com.tencent.mm.loader.d<k> cCD()
  {
    return siX;
  }
  
  public static com.tencent.mm.loader.d<k> cCE()
  {
    return siZ;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "", "(Ljava/lang/String;I)V", "TIMELINE", "FEED_DETAIL", "AVATAR", "WX_AVATAR", "AVATAR_WITHOUT_DEFAULT", "MSG_THUMB", "DEFAULT", "BIG_AVATAR", "PROFILE_COVER", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166324);
      a locala1 = new a("TIMELINE", 0);
      sjb = locala1;
      a locala2 = new a("FEED_DETAIL", 1);
      sjc = locala2;
      a locala3 = new a("AVATAR", 2);
      sjd = locala3;
      a locala4 = new a("WX_AVATAR", 3);
      sje = locala4;
      a locala5 = new a("AVATAR_WITHOUT_DEFAULT", 4);
      sjf = locala5;
      a locala6 = new a("MSG_THUMB", 5);
      sjg = locala6;
      a locala7 = new a("DEFAULT", 6);
      sjh = locala7;
      a locala8 = new a("BIG_AVATAR", 7);
      sji = locala8;
      a locala9 = new a("PROFILE_COVER", 8);
      sjj = locala9;
      sjk = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9 };
      AppMethodBeat.o(166324);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.i
 * JD-Core Version:    0.7.0.1
 */