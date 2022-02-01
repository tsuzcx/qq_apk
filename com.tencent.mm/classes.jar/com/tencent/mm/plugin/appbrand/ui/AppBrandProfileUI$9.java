package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.EllipsizeCallback;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.utils.an;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class AppBrandProfileUI$9
  implements Runnable
{
  AppBrandProfileUI$9(AppBrandProfileUI paramAppBrandProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(322415);
    AppBrandProfileUI.k(this.udA).setHighlightColor(this.udA.getResources().getColor(17170445));
    AppBrandProfileUI.k(this.udA).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(321976);
        Object localObject2 = new ArrayList();
        Object localObject1;
        int i;
        int j;
        if (AppBrandProfileUI.l(AppBrandProfileUI.9.this.udA))
        {
          localObject1 = an.a(AppBrandProfileUI.9.this.udA.getContext(), ba.e.appbrand_brand_official_icon, new ClickableSpan()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(322081);
              if (TextUtils.isEmpty(AppBrandProfileUI.m(AppBrandProfileUI.9.this.udA)))
              {
                AppMethodBeat.o(322081);
                return;
              }
              AppBrandProfileUI.a(AppBrandProfileUI.9.this.udA, 25, 1);
              c.b(AppBrandProfileUI.9.this.udA, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", AppBrandProfileUI.m(AppBrandProfileUI.9.this.udA)).putExtra("forceHideShare", true));
              Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click official icon");
              AppMethodBeat.o(322081);
            }
          });
          ((List)localObject2).add((SpannableString)((Pair)localObject1).first);
          i = ((Integer)((Pair)localObject1).second).intValue() + 0;
          j = 1;
        }
        for (;;)
        {
          int k;
          if (AppBrandProfileUI.n(AppBrandProfileUI.9.this.udA))
          {
            localObject1 = an.a(AppBrandProfileUI.9.this.udA.getContext(), ba.e.app_brand_profile_game_original, new ClickableSpan()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(322092);
                if (TextUtils.isEmpty(AppBrandProfileUI.o(AppBrandProfileUI.9.this.udA)))
                {
                  AppMethodBeat.o(322092);
                  return;
                }
                try
                {
                  paramAnonymous2View = ac.cG(AppBrandProfileUI.o(AppBrandProfileUI.9.this.udA), "appid=" + AppBrandProfileUI.f(AppBrandProfileUI.9.this.udA).appId);
                  paramAnonymous2View = new Intent().putExtra("rawUrl", paramAnonymous2View).putExtra("forceHideShare", true);
                  c.b(AppBrandProfileUI.9.this.udA, "webview", ".ui.tools.WebViewUI", paramAnonymous2View);
                  AppBrandProfileUI.a(AppBrandProfileUI.9.this.udA, 21, 1);
                  Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "click original icon");
                  AppMethodBeat.o(322092);
                  return;
                }
                catch (URISyntaxException paramAnonymous2View)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.AppBrand.Profile.AppBrandProfileUI", paramAnonymous2View, "URISyntaxException with originalRedirectUrl %s", new Object[] { AppBrandProfileUI.o(AppBrandProfileUI.9.this.udA) });
                  }
                }
              }
            });
            ((List)localObject2).add((SpannableString)((Pair)localObject1).first);
            k = ((Integer)((Pair)localObject1).second).intValue();
            j = 1;
            i += k;
          }
          for (;;)
          {
            if (j != 0) {
              ((List)localObject2).add((SpannableString)an.fp(AppBrandProfileUI.9.this.udA.getContext()).first);
            }
            final a locala = new a();
            k = AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).getWidth() - AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).getPaddingLeft() - AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).getPaddingRight();
            Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "bufferWidth: %d, availableTextWidth: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
            if (k <= i)
            {
              locala.value = true;
              AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).setText(AppBrandProfileUI.p(AppBrandProfileUI.9.this.udA));
              localObject1 = ((List)localObject2).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (SpannableString)((Iterator)localObject1).next();
                AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).append((CharSequence)localObject2);
              }
            }
            TextPaint localTextPaint = AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).getPaint();
            if (AppBrandProfileUI.p(AppBrandProfileUI.9.this.udA) == null) {}
            for (localObject1 = "";; localObject1 = AppBrandProfileUI.p(AppBrandProfileUI.9.this.udA))
            {
              localObject1 = an.a(localTextPaint, (CharSequence)localObject1, k);
              if (((List)localObject1).size() < AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).getMaxLines()) {
                break;
              }
              int m = Math.min(AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).getMaxLines() - 1, ((List)localObject1).size() - 1);
              TextUtils.ellipsize(AppBrandProfileUI.p(AppBrandProfileUI.9.this.udA).substring(((Point)((List)localObject1).get(m)).x), localTextPaint, k - i, TextUtils.TruncateAt.END, false, new TextUtils.EllipsizeCallback()
              {
                public final void ellipsized(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(322121);
                  Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "ellipsized, start: %d, end: %d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                  if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0)) {
                    locala.value = true;
                  }
                  AppMethodBeat.o(322121);
                }
              });
              break;
            }
            AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).setFocusable(true);
            if (j != 0) {
              AppBrandProfileUI.k(AppBrandProfileUI.9.this.udA).setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (locala.value) {
              AppBrandProfileUI.q(AppBrandProfileUI.9.this.udA);
            }
            AppMethodBeat.o(321976);
            return;
          }
          j = 0;
          i = 0;
        }
      }
      
      final class a
      {
        public boolean value = false;
        
        public a() {}
      }
    });
    AppMethodBeat.o(322415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.9
 * JD-Core Version:    0.7.0.1
 */