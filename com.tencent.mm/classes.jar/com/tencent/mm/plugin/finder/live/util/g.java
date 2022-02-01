package com.tencent.mm.plugin.finder.live.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/BlurAvatarUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lruAvatarBlurCache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Landroid/graphics/Bitmap;", "loadAvatarBlurBg", "", "anchorUsername", "liveCoverUrl", "view", "Landroid/view/View;", "next", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g DIp;
  private static final LruCache<String, Bitmap> DIq;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(351448);
    DIp = new g();
    TAG = "BlurAvatarUtil";
    DIq = new LruCache(5);
    AppMethodBeat.o(351448);
  }
  
  private static final void a(View paramView, final kotlin.g.a.b paramb, String paramString, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(351421);
    kotlin.g.b.s.u(paramView, "$view");
    if (paramBitmap != null)
    {
      parama = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a(paramView, paramBitmap, (kotlin.g.a.b)new a(paramString, paramb));
      AppMethodBeat.o(351421);
      return;
    }
    Log.i(TAG, "loadAvatarBlurBg resource is null!");
    if (paramb != null) {
      paramb.invoke(Boolean.FALSE);
    }
    AppMethodBeat.o(351421);
  }
  
  public static boolean a(String paramString1, String paramString2, View paramView, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(351380);
    kotlin.g.b.s.u(paramString2, "liveCoverUrl");
    kotlin.g.b.s.u(paramView, "view");
    label284:
    label289:
    label295:
    label301:
    label309:
    label333:
    label339:
    label506:
    for (;;)
    {
      Object localObject3;
      synchronized (DIq)
      {
        localObject3 = DIq.get(paramString1);
        ah localah = ah.aiuX;
        if (localObject3 != null) {
          break label394;
        }
        if (((CharSequence)paramString2).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label506;
          }
          if (paramString1 == null) {
            break label284;
          }
          paramString2 = com.tencent.mm.plugin.finder.api.d.AwY;
          paramString2 = d.a.auT(paramString1);
          if (paramString2 == null) {
            break label295;
          }
          ??? = paramString2.field_liveCoverImg;
          if (??? == null) {
            break label295;
          }
          if (((CharSequence)???).length() != 0) {
            break label289;
          }
          i = 1;
          if (i != 1) {
            break label295;
          }
          i = 1;
          if (i != 0) {
            break label309;
          }
          if (paramString2 != null) {
            break label301;
          }
          paramString2 = null;
          paramString2 = String.valueOf(paramString2);
          Log.i(TAG, "loadAvatarBlurBg anchorUsername:" + paramString1 + ",coverUrl:" + paramString2 + ", id:" + MD5Util.getMD5String(paramString2) + '!');
          localObject1 = (CharSequence)paramString2;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label333;
          }
          i = 1;
          if (i == 0) {
            break label339;
          }
          if (paramb != null) {
            paramb.invoke(Boolean.FALSE);
          }
          paramString1 = (CharSequence)paramString2;
          if ((paramString1 != null) && (paramString1.length() != 0)) {
            break label382;
          }
          i = 1;
          if (i != 0) {
            break label388;
          }
          bool = true;
          AppMethodBeat.o(351380);
          return bool;
        }
      }
      int i = 0;
      continue;
      paramString2 = null;
      continue;
      i = 0;
      continue;
      i = 0;
      continue;
      paramString2 = paramString2.field_liveCoverImg;
      continue;
      if (paramString2 == null) {}
      for (paramString2 = (String)localObject1;; paramString2 = paramString2.field_avatarUrl)
      {
        kotlin.g.b.s.s(paramString2, "contact?.field_avatarUrl");
        break;
      }
      i = 0;
      continue;
      localObject1 = p.ExI;
      p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(paramString2, v.FKZ)).a(new g..ExternalSyntheticLambda0(paramView, paramb, paramString1)).Td();
      continue;
      label382:
      i = 0;
      continue;
      boolean bool = false;
      continue;
      Log.i(TAG, "loadAvatarBlurBg from cache anchorUsername:" + paramString1 + '!');
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageDrawable((Drawable)new BitmapDrawable(MMApplicationContext.getContext().getResources(), (Bitmap)localObject3));
      }
      for (;;)
      {
        if (paramb != null) {
          paramb.invoke(Boolean.TRUE);
        }
        bool = true;
        break;
        paramString1 = (Bitmap)localObject3;
        paramView.setBackground((Drawable)new BitmapDrawable(MMApplicationContext.getContext().getResources(), paramString1));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "blurBitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    a(String paramString, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.g
 * JD-Core Version:    0.7.0.1
 */