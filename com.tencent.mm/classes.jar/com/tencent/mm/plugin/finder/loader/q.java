package com.tencent.mm.plugin.finder.loader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache;
import com.tencent.mm.loader.d.c.c;
import com.tencent.mm.loader.e.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.plugin.ringtone.b.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.n;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderLoaderConfig;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/plugin/finder/loader/IFinderLoader;", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "avatarLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "avatarOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "avatarWithoutDefaultOption", "bgBlurImageLoaderConfiguration", "bgBlurInstance", "getBgBlurInstance", "bigAvatarOption", "blurImageLoaderConfiguration", "blurInstance", "getBlurInstance", "coverOption", "darkLiveSquareOption", "darkTimelineOption", "defaultAvatar", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "defaultOption", "defaultRoundAvatar", "getDefaultRoundAvatar", "effectImageLoaderConfiguration", "effectInstance", "getEffectInstance", "halfImageLoaderConfiguration", "halfRectInstance", "getHalfRectInstance", "imageLoaderConfiguration", "instance", "getInstance", "likeHotOption", "linkThumbOption", "liveShoppingOption", "mpArticleOption", "msgThumbOption", "notWxUrlInstance", "getNotWxUrlInstance", "notWxUrlLoaderConfiguration", "olympicsOption", "previewAvatar", "getPreviewAvatar", "previewAvatarConfiguration", "getPreviewAvatarConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "rectAvatar", "getRectAvatar", "rectAvatarConfiguration", "rectAvatarOption", "ringtoneInstance", "getRingtoneInstance", "ringtoneLoaderConfiguration", "ringtoneOption", "shareStreamGuideItemOption", "timelineOption", "wxAvatar", "getWxAvatar", "wxAvatarLoaderConfiguration", "wxAvatarOption", "getOption", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends n<PluginFinder>
  implements w
{
  private final com.tencent.mm.loader.b.e EyA;
  private final com.tencent.mm.loader.b.e EyB;
  private final com.tencent.mm.loader.b.e EyC;
  private final com.tencent.mm.loader.b.e EyD;
  private final com.tencent.mm.loader.b.d<r, Bitmap> EyE;
  private final com.tencent.mm.loader.b.e EyF;
  private final com.tencent.mm.loader.b.e EyG;
  private final com.tencent.mm.loader.d<r> EyH;
  private final com.tencent.mm.loader.d<r> EyI;
  private final com.tencent.mm.loader.d<r> EyJ;
  private final com.tencent.mm.loader.d<r> EyK;
  private final com.tencent.mm.loader.d<r> EyL;
  private final com.tencent.mm.loader.d<r> EyM;
  private final com.tencent.mm.loader.d<r> EyN;
  private final com.tencent.mm.loader.d<r> EyO;
  private final com.tencent.mm.loader.d<r> EyP;
  private final com.tencent.mm.loader.d<r> EyQ;
  private final com.tencent.mm.loader.d<r> EyR;
  private final com.tencent.mm.loader.b.e Eyd;
  private final com.tencent.mm.loader.b.e Eye;
  private final com.tencent.mm.loader.b.e Eyf;
  private final com.tencent.mm.loader.b.e Eyg;
  private final com.tencent.mm.loader.b.e Eyh;
  private final com.tencent.mm.loader.b.e Eyi;
  private final com.tencent.mm.loader.b.e Eyj;
  private final com.tencent.mm.loader.b.e Eyk;
  private final Bitmap Eyl;
  private final com.tencent.mm.loader.b.e Eym;
  private final com.tencent.mm.loader.b.e Eyn;
  private final com.tencent.mm.loader.b.e Eyo;
  private final com.tencent.mm.loader.b.e Eyp;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyq;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyr;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eys;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyt;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyu;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyv;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyw;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyx;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyy;
  private final com.tencent.mm.loader.b.d<r, Bitmap> Eyz;
  private final Bitmap hkp;
  
  public q()
  {
    AppMethodBeat.i(331806);
    Object localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQo();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQp();
    this.Eyd = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.BW_97;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQo();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQp();
    this.Eye = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.Dark_0;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQo();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQp();
    this.Eyf = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.Dark_0;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQo();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQp();
    this.Eyg = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.BW_97;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQt();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQu();
    this.Eyh = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.BW_97;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQw();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQx();
    this.Eyi = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.BW_97;
    localObject2 = MMApplicationContext.getContext().getResources();
    s.checkNotNull(localObject2);
    ((e.a)localObject1).nqg = ((Resources)localObject2).getDimensionPixelSize(e.c.Edge_9A);
    localObject2 = MMApplicationContext.getContext().getResources();
    s.checkNotNull(localObject2);
    ((e.a)localObject1).nqh = ((Resources)localObject2).getDimensionPixelSize(e.c.Edge_9A);
    this.Eyj = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.hot_tab_BW_100_Alpha_0_1;
    localObject2 = MMApplicationContext.getContext().getResources();
    s.checkNotNull(localObject2);
    ((e.a)localObject1).nqg = ((Resources)localObject2).getDimensionPixelSize(e.c.Edge_3A);
    localObject2 = MMApplicationContext.getContext().getResources();
    s.checkNotNull(localObject2);
    ((e.a)localObject1).nqh = ((Resources)localObject2).getDimensionPixelSize(e.c.Edge_3A);
    this.Eyk = ((e.a)localObject1).blI();
    this.hkp = com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getContext().getResources(), e.g.default_avatar);
    this.Eyl = BitmapUtil.getRoundedCornerBitmap(this.hkp, false, this.hkp.getWidth() * 0.5F);
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    localObject1 = ((e.a)localObject1).L((Drawable)new BitmapDrawable(this.Eyl));
    ((e.a)localObject1).nqh = 132;
    ((e.a)localObject1).nqg = 132;
    this.Eym = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    localObject1 = ((e.a)localObject1).L((Drawable)new BitmapDrawable(this.hkp));
    ((e.a)localObject1).nqh = 132;
    ((e.a)localObject1).nqg = 132;
    this.Eyn = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    localObject2 = MMApplicationContext.getContext().getResources().getDrawable(e.d.default_avatar);
    s.s(localObject2, "getContext().getResource….drawable.default_avatar)");
    localObject1 = ((e.a)localObject1).L((Drawable)localObject2);
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQt();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQt();
    this.Eyo = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.BW_97;
    ((e.a)localObject1).nqh = 132;
    ((e.a)localObject1).nqg = 132;
    this.Eyp = ((e.a)localObject1).blI();
    this.Eyq = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new h()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new d()).b((com.tencent.mm.loader.c.d)new e()).b(this.Eyd).blt();
    this.Eyr = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new m()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new d()).b((com.tencent.mm.loader.c.d)new e()).b(this.Eyd).blt();
    this.Eys = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new m()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new d()).b(this.Eym).b((com.tencent.mm.loader.c.d)new e()).b(new c(0.5F).blN()).blt();
    this.Eyt = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new m()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b(this.Eyo).b(new c(0.1F).blN()).blt();
    this.Eyu = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new m()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b(this.Eym).b((com.tencent.mm.loader.c.d)new e()).blt();
    this.Eyv = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new m()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b((com.tencent.mm.loader.c.d)new e()).b(this.Eyd).blt();
    this.Eyw = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new h()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b((com.tencent.mm.loader.c.d)new e()).b(new f(25.0F, Integer.valueOf(e.b.UN_BW_0_Alpha_0_2)).blO()).b(this.Eyd).blt();
    this.Eyx = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new h()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b((com.tencent.mm.loader.c.d)new e()).b(new f(100.0F, Integer.valueOf(e.b.UN_BW_0_Alpha_0_2)).blO()).b(this.Eyd).blt();
    this.Eyy = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new h()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b((com.tencent.mm.loader.c.d)new l()).b(this.Eyd).blt();
    localObject1 = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j());
    localObject2 = o.Gco;
    this.Eyz = ((com.tencent.mm.loader.b.b)localObject1).a((com.tencent.mm.loader.c.b)new h(o.fdZ())).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).b((com.tencent.mm.loader.c.d)new e()).b(this.Eyd).blt();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    localObject2 = MMApplicationContext.getContext().getResources().getDrawable(e.d.finder_live_shopping_default);
    s.s(localObject2, "getContext().getResource…er_live_shopping_default)");
    localObject1 = ((e.a)localObject1).L((Drawable)localObject2);
    localObject2 = com.tencent.d.a.a.a.a.a.ahiX;
    ((e.a)localObject1).nqh = com.tencent.d.a.a.a.a.a.jSO();
    localObject2 = com.tencent.d.a.a.a.a.a.ahiX;
    ((e.a)localObject1).nqg = com.tencent.d.a.a.a.a.a.jSO();
    this.EyA = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    localObject2 = MMApplicationContext.getContext().getResources().getDrawable(e.g.olympics_avatar_default);
    s.s(localObject2, "getContext().getResource….olympics_avatar_default)");
    localObject1 = ((e.a)localObject1).L((Drawable)localObject2);
    ((e.a)localObject1).nqh = 132;
    ((e.a)localObject1).nqg = 132;
    this.EyB = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    localObject2 = MMApplicationContext.getContext().getResources().getDrawable(e.d.empty_music_cover);
    s.s(localObject2, "getContext().getResource…awable.empty_music_cover)");
    localObject1 = ((e.a)localObject1).L((Drawable)localObject2);
    ((e.a)localObject1).nqk = b.b.empty_music_cover;
    ((e.a)localObject1).nqi = b.b.empty_music_cover;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQo();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQp();
    this.EyC = ((e.a)localObject1).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nqk = e.d.finder_filled_hot_like_red_big;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQo();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQp();
    this.EyD = ((e.a)localObject1).blI();
    this.EyE = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new j()).a((com.tencent.mm.loader.c.b)new h()).a((g)new com.tencent.mm.loader.d.a()).a((com.tencent.mm.loader.cache.memory.d)new d()).b((com.tencent.mm.loader.c.d)new e()).b(this.EyC).blt();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nql = e.b.BW_BG_19;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQo();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQp();
    this.EyF = ((e.a)localObject1).b((Animation)new AlphaAnimation(0.0F, 1.0F)).blI();
    localObject1 = new e.a();
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqc = true;
    ((e.a)localObject1).nqk = e.d.finder_live_promote_mp_default_icon;
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqh = com.tencent.mm.plugin.finder.storage.d.eQo();
    localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    ((e.a)localObject1).nqg = com.tencent.mm.plugin.finder.storage.d.eQp();
    this.EyG = ((e.a)localObject1).blI();
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyH = com.tencent.mm.loader.e.a(this.Eyq);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyI = com.tencent.mm.loader.e.a(this.EyE);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyJ = com.tencent.mm.loader.e.a(this.Eyr);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyK = com.tencent.mm.loader.e.a(this.Eyz);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyL = com.tencent.mm.loader.e.a(this.Eys);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyM = com.tencent.mm.loader.e.a(this.Eyt);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyN = com.tencent.mm.loader.e.a(this.Eyu);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyO = com.tencent.mm.loader.e.a(this.Eyv);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyP = com.tencent.mm.loader.e.a(this.Eyw);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyQ = com.tencent.mm.loader.e.a(this.Eyx);
    localObject1 = com.tencent.mm.loader.e.noo;
    this.EyR = com.tencent.mm.loader.e.a(this.Eyy);
    AppMethodBeat.o(331806);
  }
  
  public final com.tencent.mm.loader.b.e a(p.a parama)
  {
    AppMethodBeat.i(331864);
    s.u(parama, "type");
    switch (q.a.$EnumSwitchMapping$0[parama.ordinal()])
    {
    default: 
      parama = this.Eyd;
      AppMethodBeat.o(331864);
      return parama;
    case 1: 
      parama = this.Eye;
      AppMethodBeat.o(331864);
      return parama;
    case 2: 
      parama = this.Eyf;
      AppMethodBeat.o(331864);
      return parama;
    case 3: 
      parama = this.Eye;
      AppMethodBeat.o(331864);
      return parama;
    case 4: 
      parama = this.Eym;
      AppMethodBeat.o(331864);
      return parama;
    case 5: 
      parama = this.Eyn;
      AppMethodBeat.o(331864);
      return parama;
    case 6: 
      parama = this.Eyp;
      AppMethodBeat.o(331864);
      return parama;
    case 7: 
      parama = this.Eyj;
      AppMethodBeat.o(331864);
      return parama;
    case 8: 
      parama = this.Eyk;
      AppMethodBeat.o(331864);
      return parama;
    case 9: 
      parama = this.Eyh;
      AppMethodBeat.o(331864);
      return parama;
    case 10: 
      parama = this.Eyi;
      AppMethodBeat.o(331864);
      return parama;
    case 11: 
      parama = this.Eyo;
      AppMethodBeat.o(331864);
      return parama;
    case 12: 
      parama = this.EyA;
      AppMethodBeat.o(331864);
      return parama;
    case 13: 
      parama = this.EyB;
      AppMethodBeat.o(331864);
      return parama;
    case 14: 
      parama = this.Eyg;
      AppMethodBeat.o(331864);
      return parama;
    case 15: 
      parama = this.EyD;
      AppMethodBeat.o(331864);
      return parama;
    case 16: 
      parama = this.EyF;
      AppMethodBeat.o(331864);
      return parama;
    case 17: 
      parama = this.EyC;
      AppMethodBeat.o(331864);
      return parama;
    }
    parama = this.EyG;
    AppMethodBeat.o(331864);
    return parama;
  }
  
  public final com.tencent.mm.loader.d<r> eCA()
  {
    return this.EyM;
  }
  
  public final com.tencent.mm.loader.d<r> eCB()
  {
    return this.EyN;
  }
  
  public final com.tencent.mm.loader.d<r> eCC()
  {
    return this.EyO;
  }
  
  public final com.tencent.mm.loader.d<r> eCD()
  {
    return this.EyP;
  }
  
  public final com.tencent.mm.loader.d<r> eCE()
  {
    return this.EyQ;
  }
  
  public final com.tencent.mm.loader.d<r> eCv()
  {
    return this.EyH;
  }
  
  public final com.tencent.mm.loader.d<r> eCw()
  {
    return this.EyI;
  }
  
  public final com.tencent.mm.loader.d<r> eCx()
  {
    return this.EyJ;
  }
  
  public final com.tencent.mm.loader.d<r> eCy()
  {
    return this.EyK;
  }
  
  public final com.tencent.mm.loader.d<r> eCz()
  {
    return this.EyL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.q
 * JD-Core Version:    0.7.0.1
 */