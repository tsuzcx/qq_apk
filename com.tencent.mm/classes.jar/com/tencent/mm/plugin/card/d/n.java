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
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class n
{
  public static void a(final Context paramContext, ImageView paramImageView, String paramString, int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(252568);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(252568);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(paramString);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).kPz = false;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOg = paramInt1;
      ((c.a)localObject).kOf = paramInt1;
      ((c.a)localObject).lRP = paramInt2;
      localObject = ((c.a)localObject).bmL();
      q.bml().a(paramString, paramImageView, (c)localObject, new h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(113855);
          if (paramAnonymousb.bitmap != null)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(113854);
                n.1.this.tGY.setImageBitmap(this.mLY);
                n.1.this.tGY.setColorFilter(n.1.this.qoT, PorterDuff.Mode.SRC_IN);
                AppMethodBeat.o(113854);
              }
            });
            AppMethodBeat.o(113855);
            return;
          }
          n.b(this.tGY, paramInt2, paramInt3);
          AppMethodBeat.o(113855);
        }
      });
      AppMethodBeat.o(252568);
      return;
    }
    b(paramImageView, paramInt2, paramInt3);
    AppMethodBeat.o(252568);
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
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(paramString);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).kPz = paramBoolean;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOg = paramInt1;
      ((c.a)localObject).kOf = paramInt1;
      ((c.a)localObject).lRP = paramInt2;
      localObject = ((c.a)localObject).bmL();
      q.bml().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(113861);
      return;
    }
    paramImageView.setImageResource(paramInt2);
    AppMethodBeat.o(113861);
  }
  
  public static void a(MMActivity paramMMActivity, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113864);
    paramMMActivity.setActionbarColor(l.arR(paramb.cGs().lmL));
    AppMethodBeat.o(113864);
  }
  
  public static String arY(String paramString)
  {
    AppMethodBeat.i(113860);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CardViewUtil", "toApply is null");
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
  
  public static void b(ImageView paramImageView, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(113863);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113856);
        this.tGY.setImageResource(paramInt1);
        this.tGY.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
        AppMethodBeat.o(113856);
      }
    });
    AppMethodBeat.o(113863);
  }
  
  public static void e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113865);
    paramMMActivity.setActionbarColor(paramMMActivity.getResources().getColor(a.a.white));
    AppMethodBeat.o(113865);
  }
  
  public static Rect ea(View paramView)
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
  
  public static void f(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(113859);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(113859);
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
      paramTextView.setText(a.g.tlU);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.tlP);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.tlS);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.tlR);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.tlV);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.tlW);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.tlQ);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.tlT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.n
 * JD-Core Version:    0.7.0.1
 */