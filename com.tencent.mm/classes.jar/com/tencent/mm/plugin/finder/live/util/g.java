package com.tencent.mm.plugin.finder.live.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/BlurAvatarUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lruAvatarBlurCache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Landroid/graphics/Bitmap;", "loadAvatarBlurBg", "", "anchorUsername", "liveCoverUrl", "view", "Landroid/view/View;", "next", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-finder_release"})
public final class g
{
  private static final String TAG = "BlurAvatarUtil";
  private static final LruCache<String, Bitmap> uwc;
  public static final g uwd;
  
  static
  {
    AppMethodBeat.i(247239);
    uwd = new g();
    TAG = "BlurAvatarUtil";
    uwc = new LruCache(5);
    AppMethodBeat.o(247239);
  }
  
  public static void a(final String paramString1, String paramString2, View paramView, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(247237);
    p.h(paramString2, "liveCoverUrl");
    p.h(paramView, "view");
    if (paramString1 == null)
    {
      Log.i(TAG, "loadAvatarBlurBg anchorUsername is null!");
      if (paramb != null)
      {
        paramb.invoke(Boolean.FALSE);
        AppMethodBeat.o(247237);
        return;
      }
      AppMethodBeat.o(247237);
      return;
    }
    label279:
    label285:
    label290:
    label304:
    label310:
    label316:
    label362:
    label490:
    for (;;)
    {
      synchronized (uwc)
      {
        localObject = (Bitmap)uwc.get(paramString1);
        x localx = x.SXb;
        if (localObject != null) {
          break label362;
        }
        if (((CharSequence)paramString2).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label490;
          }
          paramString2 = c.tsp;
          paramString2 = c.a.asG(paramString1);
          if (paramString2 != null)
          {
            localObject = paramString2.field_liveCoverImg;
            if (localObject != null)
            {
              localObject = (CharSequence)localObject;
              if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                break label279;
              }
              i = 1;
              if (i == 1) {
                break label290;
              }
            }
          }
          if (paramString2 == null) {
            break label285;
          }
          paramString2 = paramString2.field_liveCoverImg;
          paramString2 = String.valueOf(paramString2);
          Log.i(TAG, "loadAvatarBlurBg anchorUsername:" + paramString1 + ",coverUrl:" + paramString2 + '!');
          localObject = (CharSequence)paramString2;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label304;
          }
          i = 1;
          if (i == 0) {
            break label316;
          }
          if (paramb == null) {
            break label310;
          }
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(247237);
          return;
        }
      }
      int i = 0;
      continue;
      i = 0;
      continue;
      paramString2 = null;
      continue;
      paramString2 = paramString2.field_avatarUrl;
      p.g(paramString2, "contact?.field_avatarUrl");
      continue;
      i = 0;
      continue;
      AppMethodBeat.o(247237);
      return;
      Object localObject = m.uJa;
      m.djY().bQ(new a(paramString2)).a((e)new a(paramView, paramString1, paramb)).vC();
      AppMethodBeat.o(247237);
      return;
      Log.i(TAG, "loadAvatarBlurBg from cache anchorUsername:" + paramString1 + '!');
      if ((paramView instanceof ImageView))
      {
        paramString1 = (ImageView)paramView;
        paramString2 = MMApplicationContext.getContext();
        p.g(paramString2, "MMApplicationContext.getContext()");
        paramString1.setImageDrawable((Drawable)new BitmapDrawable(paramString2.getResources(), (Bitmap)localObject));
      }
      while (paramb != null)
      {
        paramb.invoke(Boolean.TRUE);
        AppMethodBeat.o(247237);
        return;
        paramString1 = MMApplicationContext.getContext();
        p.g(paramString1, "MMApplicationContext.getContext()");
        paramView.setBackground((Drawable)new BitmapDrawable(paramString1.getResources(), (Bitmap)localObject));
      }
      AppMethodBeat.o(247237);
      return;
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class a<T, R>
    implements e<o, Bitmap>
  {
    a(View paramView, String paramString, kotlin.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.g
 * JD-Core Version:    0.7.0.1
 */