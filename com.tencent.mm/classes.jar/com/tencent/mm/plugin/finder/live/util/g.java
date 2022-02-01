package com.tencent.mm.plugin.finder.live.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/BlurAvatarUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lruAvatarBlurCache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Landroid/graphics/Bitmap;", "loadAvatarBlurBg", "", "anchorUsername", "liveCoverUrl", "view", "Landroid/view/View;", "next", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "plugin-finder_release"})
public final class g
{
  private static final String TAG = "BlurAvatarUtil";
  private static final LruCache<String, Bitmap> yPI;
  public static final g yPJ;
  
  static
  {
    AppMethodBeat.i(286441);
    yPJ = new g();
    TAG = "BlurAvatarUtil";
    yPI = new LruCache(5);
    AppMethodBeat.o(286441);
  }
  
  public static boolean a(final String paramString1, String paramString2, View paramView, final kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
  {
    AppMethodBeat.i(286439);
    p.k(paramString2, "liveCoverUrl");
    p.k(paramView, "view");
    label288:
    label293:
    label299:
    label304:
    label318:
    label324:
    label370:
    label376:
    label504:
    for (;;)
    {
      synchronized (yPI)
      {
        localObject = (Bitmap)yPI.get(paramString1);
        kotlin.x localx = kotlin.x.aazN;
        if (localObject != null) {
          break label382;
        }
        if (((CharSequence)paramString2).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label504;
          }
          if (paramString1 == null) {
            break label288;
          }
          paramString2 = com.tencent.mm.plugin.finder.api.d.wZQ;
          paramString2 = d.a.aAK(paramString1);
          if (paramString2 != null)
          {
            localObject = paramString2.field_liveCoverImg;
            if (localObject != null)
            {
              localObject = (CharSequence)localObject;
              if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                break label293;
              }
              i = 1;
              if (i == 1) {
                break label304;
              }
            }
          }
          if (paramString2 == null) {
            break label299;
          }
          paramString2 = paramString2.field_liveCoverImg;
          paramString2 = String.valueOf(paramString2);
          Log.i(TAG, "loadAvatarBlurBg anchorUsername:" + paramString1 + ",coverUrl:" + paramString2 + ", id:" + MD5Util.getMD5String(paramString2) + '!');
          localObject = (CharSequence)paramString2;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label318;
          }
          i = 1;
          if (i == 0) {
            break label324;
          }
          if (paramb != null) {
            paramb.invoke(Boolean.FALSE);
          }
          paramString1 = (CharSequence)paramString2;
          if ((paramString1 != null) && (paramString1.length() != 0)) {
            break label370;
          }
          i = 1;
          if (i != 0) {
            break label376;
          }
          bool = true;
          AppMethodBeat.o(286439);
          return bool;
        }
      }
      int i = 0;
      continue;
      paramString2 = null;
      continue;
      i = 0;
      continue;
      paramString2 = null;
      continue;
      paramString2 = paramString2.field_avatarUrl;
      p.j(paramString2, "contact?.field_avatarUrl");
      continue;
      i = 0;
      continue;
      Object localObject = t.ztT;
      t.dJe().bQ(new com.tencent.mm.plugin.finder.loader.x(paramString2, u.Alz)).a((e)new a(paramView, paramString1, paramb)).tA();
      continue;
      i = 0;
      continue;
      boolean bool = false;
      continue;
      label382:
      Log.i(TAG, "loadAvatarBlurBg from cache anchorUsername:" + paramString1 + '!');
      if ((paramView instanceof ImageView))
      {
        paramString1 = (ImageView)paramView;
        paramString2 = MMApplicationContext.getContext();
        p.j(paramString2, "MMApplicationContext.getContext()");
        paramString1.setImageDrawable((Drawable)new BitmapDrawable(paramString2.getResources(), (Bitmap)localObject));
      }
      for (;;)
      {
        if (paramb != null) {
          paramb.invoke(Boolean.TRUE);
        }
        bool = true;
        break;
        paramString1 = MMApplicationContext.getContext();
        p.j(paramString1, "MMApplicationContext.getContext()");
        paramView.setBackground((Drawable)new BitmapDrawable(paramString1.getResources(), (Bitmap)localObject));
      }
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class a<T, R>
    implements e<w, Bitmap>
  {
    a(View paramView, String paramString, kotlin.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.g
 * JD-Core Version:    0.7.0.1
 */