package com.tencent.mm.plugin.card.c;

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
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class n
{
  public static void a(final Context paramContext, ImageView paramImageView, String paramString, int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(293743);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(293743);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = r.bKf();
      ((c.a)localObject).fullPath = m.akH(paramString);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).nrc = false;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).npV = paramInt1;
      ((c.a)localObject).npU = paramInt1;
      ((c.a)localObject).oKB = paramInt2;
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(paramString, paramImageView, (c)localObject, new h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          AppMethodBeat.i(113855);
          if (paramAnonymousb.bitmap != null)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(113854);
                n.this.setImageBitmap(this.pIG);
                n.this.setColorFilter(n.1.this.ttw, PorterDuff.Mode.SRC_IN);
                AppMethodBeat.o(113854);
              }
            });
            AppMethodBeat.o(113855);
            return;
          }
          n.b(n.this, paramInt2, paramInt3);
          AppMethodBeat.o(113855);
        }
        
        public final void c(String paramAnonymousString, View paramAnonymousView) {}
      });
      AppMethodBeat.o(293743);
      return;
    }
    b(paramImageView, paramInt2, paramInt3);
    AppMethodBeat.o(293743);
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
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = r.bKf();
      ((c.a)localObject).fullPath = m.akH(paramString);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).nrc = paramBoolean;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).npV = paramInt1;
      ((c.a)localObject).npU = paramInt1;
      ((c.a)localObject).oKB = paramInt2;
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(113861);
      return;
    }
    paramImageView.setImageResource(paramInt2);
    AppMethodBeat.o(113861);
  }
  
  public static void a(MMActivity paramMMActivity, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113864);
    paramMMActivity.setActionbarColor(l.alv(paramb.djK().nRQ));
    AppMethodBeat.o(113864);
  }
  
  public static String alC(String paramString)
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
        n.this.setImageResource(paramInt1);
        n.this.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
        AppMethodBeat.o(113856);
      }
    });
    AppMethodBeat.o(113863);
  }
  
  public static Rect eO(View paramView)
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
  
  public static void f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(113865);
    paramMMActivity.setActionbarColor(paramMMActivity.getResources().getColor(a.a.white));
    AppMethodBeat.o(113865);
  }
  
  public static void i(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(113866);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.wqt);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.wqo);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.wqr);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.wqq);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.wqu);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.wqv);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.wqp);
      AppMethodBeat.o(113866);
      return;
      paramTextView.setText(a.g.wqs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.n
 * JD-Core Version:    0.7.0.1
 */