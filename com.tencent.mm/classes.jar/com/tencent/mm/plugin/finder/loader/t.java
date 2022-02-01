package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader;", "", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "bgBlurInstance", "getBgBlurInstance", "blurInstance", "getBlurInstance", "effectInstance", "getEffectInstance", "halfRectInstance", "getHalfRectInstance", "instance", "getInstance", "notWxUrlInstance", "getNotWxUrlInstance", "previewAvatar", "getPreviewAvatar", "rectAvatar", "getRectAvatar", "wxAvatar", "getWxAvatar", "getOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "LoaderType", "plugin-finder-base_release"})
public final class t
{
  public static final t ztT;
  
  static
  {
    AppMethodBeat.i(166329);
    ztT = new t();
    AppMethodBeat.o(166329);
  }
  
  public static e a(a parama)
  {
    AppMethodBeat.i(166328);
    p.k(parama, "type");
    g localg = g.Xox;
    parama = ((ab)g.bD(ak.class).bE(ab.class)).a(parama);
    AppMethodBeat.o(166328);
    return parama;
  }
  
  public static d<w> dJe()
  {
    AppMethodBeat.i(261018);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJn();
    AppMethodBeat.o(261018);
    return localObject;
  }
  
  public static d<w> dJf()
  {
    AppMethodBeat.i(261021);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJo();
    AppMethodBeat.o(261021);
    return localObject;
  }
  
  public static d<w> dJg()
  {
    AppMethodBeat.i(261022);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJp();
    AppMethodBeat.o(261022);
    return localObject;
  }
  
  public static d<w> dJh()
  {
    AppMethodBeat.i(261024);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJq();
    AppMethodBeat.o(261024);
    return localObject;
  }
  
  public static d<w> dJi()
  {
    AppMethodBeat.i(261025);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJr();
    AppMethodBeat.o(261025);
    return localObject;
  }
  
  public static d<w> dJj()
  {
    AppMethodBeat.i(261027);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJs();
    AppMethodBeat.o(261027);
    return localObject;
  }
  
  public static d<w> dJk()
  {
    AppMethodBeat.i(261028);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJt();
    AppMethodBeat.o(261028);
    return localObject;
  }
  
  public static d<w> dJl()
  {
    AppMethodBeat.i(261029);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJu();
    AppMethodBeat.o(261029);
    return localObject;
  }
  
  public static d<w> dJm()
  {
    AppMethodBeat.i(261031);
    Object localObject = g.Xox;
    localObject = ((ab)g.bD(ak.class).bE(ab.class)).dJv();
    AppMethodBeat.o(261031);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "", "(Ljava/lang/String;I)V", "TIMELINE", "DARK_TIMELINE", "FEED_DETAIL", "AVATAR", "RECT_AVATAR", "WX_AVATAR", "AVATAR_WITHOUT_DEFAULT", "MSG_THUMB", "LINK_THUMB", "DEFAULT", "BIG_AVATAR", "PROFILE_COVER", "LIVE_SHOPPING_DEFAULT", "DARK_LIVE_SQUARE", "LIKE_HOT_DEFAULT", "plugin-finder-base_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166324);
      a locala1 = new a("TIMELINE", 0);
      ztU = locala1;
      a locala2 = new a("DARK_TIMELINE", 1);
      ztV = locala2;
      a locala3 = new a("FEED_DETAIL", 2);
      ztW = locala3;
      a locala4 = new a("AVATAR", 3);
      ztX = locala4;
      a locala5 = new a("RECT_AVATAR", 4);
      ztY = locala5;
      a locala6 = new a("WX_AVATAR", 5);
      ztZ = locala6;
      a locala7 = new a("AVATAR_WITHOUT_DEFAULT", 6);
      zua = locala7;
      a locala8 = new a("MSG_THUMB", 7);
      zub = locala8;
      a locala9 = new a("LINK_THUMB", 8);
      zuc = locala9;
      a locala10 = new a("DEFAULT", 9);
      zud = locala10;
      a locala11 = new a("BIG_AVATAR", 10);
      zue = locala11;
      a locala12 = new a("PROFILE_COVER", 11);
      zuf = locala12;
      a locala13 = new a("LIVE_SHOPPING_DEFAULT", 12);
      zug = locala13;
      a locala14 = new a("DARK_LIVE_SQUARE", 13);
      zuh = locala14;
      a locala15 = new a("LIKE_HOT_DEFAULT", 14);
      zui = locala15;
      zuj = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13, locala14, locala15 };
      AppMethodBeat.o(166324);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.t
 * JD-Core Version:    0.7.0.1
 */