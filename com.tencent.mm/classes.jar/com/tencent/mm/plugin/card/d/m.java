package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class m
{
  public static void a(final Context paramContext, ImageView paramImageView, String paramString, int paramInt1, final int paramInt2, final int paramInt3)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).eri = e.bkH;
      o.OO();
      ((c.a)localObject).erB = null;
      ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(paramString);
      ((c.a)localObject).erf = true;
      ((c.a)localObject).erD = false;
      ((c.a)localObject).erd = true;
      ((c.a)localObject).erm = paramInt1;
      ((c.a)localObject).erl = paramInt1;
      ((c.a)localObject).eru = paramInt2;
      localObject = ((c.a)localObject).OV();
      o.ON().a(paramString, paramImageView, (c)localObject, new g()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.as.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.as.a.d.b paramAnonymousb)
        {
          if (paramAnonymousb.bitmap != null)
          {
            ai.d(new m.1.1(this, paramAnonymousb.bitmap));
            return;
          }
          m.a(this.izf, paramInt2, paramInt3);
        }
        
        public final void mv(String paramAnonymousString) {}
      });
      return;
    }
    a(paramImageView, paramInt2, paramInt3);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    ai.d(new m.2(paramImageView, paramInt1, paramInt2));
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).eri = e.bkH;
      o.OO();
      ((c.a)localObject).erB = null;
      ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(paramString);
      ((c.a)localObject).erf = true;
      ((c.a)localObject).erD = paramBoolean;
      ((c.a)localObject).erd = true;
      ((c.a)localObject).erm = paramInt1;
      ((c.a)localObject).erl = paramInt1;
      ((c.a)localObject).eru = paramInt2;
      localObject = ((c.a)localObject).OV();
      o.ON().a(paramString, paramImageView, (c)localObject);
      return;
    }
    paramImageView.setImageResource(paramInt2);
  }
  
  public static void a(MMActivity paramMMActivity, com.tencent.mm.plugin.card.base.b paramb)
  {
    paramMMActivity.ta(l.yR(paramb.azx().color));
  }
  
  public static void c(TextView paramTextView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramTextView.setText(a.g.card_state_normal);
      return;
    case 1: 
      paramTextView.setText(a.g.card_state_consumed);
      return;
    case 2: 
      paramTextView.setText(a.g.card_state_expire);
      return;
    case 3: 
      paramTextView.setText(a.g.card_state_donation);
      return;
    case 4: 
      paramTextView.setText(a.g.card_state_received);
      return;
    case 5: 
      paramTextView.setText(a.g.card_state_timeout);
      return;
    case 6: 
      paramTextView.setText(a.g.card_state_deleted);
      return;
    }
    paramTextView.setText(a.g.card_state_lapsed);
  }
  
  public static void c(MMActivity paramMMActivity)
  {
    paramMMActivity.ta(paramMMActivity.getResources().getColor(a.a.white));
  }
  
  public static String yZ(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.CardViewUtil", "toApply is null");
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
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m
 * JD-Core Version:    0.7.0.1
 */