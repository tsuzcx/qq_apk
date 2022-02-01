package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public final class n
{
  public static String VF(String paramString)
  {
    AppMethodBeat.i(113860);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CardViewUtil", "toApply is null");
      AppMethodBeat.o(113860);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      localStringBuilder.append(paramString.charAt(i));
      if ((i + 1) % 4 == 0) {
        localStringBuilder.append(" ");
      }
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(113860);
    return paramString;
  }
  
  public static void a(final Context paramContext, ImageView paramImageView, String paramString, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(113862);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(113862);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(paramString);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).gLt = false;
      ((c.a)localObject).hKv = true;
      ((c.a)localObject).gKh = paramInt1;
      ((c.a)localObject).gKg = paramInt1;
      ((c.a)localObject).hKI = 2131231506;
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(paramString, paramImageView, (c)localObject, new h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(113855);
          if (paramAnonymousb.bitmap != null)
          {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(113854);
                n.1.this.oml.setImageBitmap(this.iBJ);
                n.1.this.oml.setColorFilter(n.1.this.lyS, PorterDuff.Mode.SRC_IN);
                AppMethodBeat.o(113854);
              }
            });
            AppMethodBeat.o(113855);
            return;
          }
          n.b(this.oml, this.omm, paramInt2);
          AppMethodBeat.o(113855);
        }
      });
      AppMethodBeat.o(113862);
      return;
    }
    b(paramImageView, 2131231506, paramInt2);
    AppMethodBeat.o(113862);
  }
  
  public static void a(View paramView, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(113867);
    paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramLinearLayout.addView(paramView);
    AppMethodBeat.o(113867);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(113861);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(113861);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(paramString);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).gLt = paramBoolean;
      ((c.a)localObject).hKv = true;
      ((c.a)localObject).gKh = paramInt1;
      ((c.a)localObject).gKg = paramInt1;
      ((c.a)localObject).hKI = paramInt2;
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(113861);
      return;
    }
    paramImageView.setImageResource(paramInt2);
    AppMethodBeat.o(113861);
  }
  
  public static void a(MMActivity paramMMActivity, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113864);
    paramMMActivity.setActionbarColor(l.Vy(paramb.bPi().hiu));
    AppMethodBeat.o(113864);
  }
  
  public static void b(ImageView paramImageView, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(113863);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113856);
        this.oml.setImageResource(paramInt1);
        this.oml.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
        AppMethodBeat.o(113856);
      }
    });
    AppMethodBeat.o(113863);
  }
  
  public static void c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113865);
    paramMMActivity.setActionbarColor(paramMMActivity.getResources().getColor(2131101179));
    AppMethodBeat.o(113865);
  }
  
  public static Rect dH(View paramView)
  {
    AppMethodBeat.i(113858);
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(113858);
    return localRect;
  }
  
  public static void h(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(113866);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(2131757006);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(2131757001);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(2131757004);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(2131757003);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(2131757007);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(2131757008);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(2131757002);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(2131757005);
    }
  }
  
  public static void j(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(113859);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(113859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.n
 * JD-Core Version:    0.7.0.1
 */