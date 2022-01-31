package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class m
{
  public static String II(String paramString)
  {
    AppMethodBeat.i(88932);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CardViewUtil", "toApply is null");
      AppMethodBeat.o(88932);
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
    AppMethodBeat.o(88932);
    return paramString;
  }
  
  public static void a(final Context paramContext, ImageView paramImageView, String paramString, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(88934);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(88934);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(paramString);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eOk = false;
      ((c.a)localObject).eNK = true;
      ((c.a)localObject).eNT = paramInt1;
      ((c.a)localObject).eNS = paramInt1;
      ((c.a)localObject).eNY = 2130838175;
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(paramString, paramImageView, (c)localObject, new g()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.at.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.at.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(88927);
          if (paramAnonymousb.bitmap != null)
          {
            al.d(new m.1.1(this, paramAnonymousb.bitmap));
            AppMethodBeat.o(88927);
            return;
          }
          m.a(this.kCm, this.kCn, paramInt2);
          AppMethodBeat.o(88927);
        }
        
        public final void tF(String paramAnonymousString) {}
      });
      AppMethodBeat.o(88934);
      return;
    }
    a(paramImageView, 2130838175, paramInt2);
    AppMethodBeat.o(88934);
  }
  
  public static void a(View paramView, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(88939);
    paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramLinearLayout.addView(paramView);
    AppMethodBeat.o(88939);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88935);
    al.d(new m.2(paramImageView, paramInt1, paramInt2));
    AppMethodBeat.o(88935);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(88933);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(88933);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(paramString);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eOk = paramBoolean;
      ((c.a)localObject).eNK = true;
      ((c.a)localObject).eNT = paramInt1;
      ((c.a)localObject).eNS = paramInt1;
      ((c.a)localObject).eNY = paramInt2;
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(paramString, paramImageView, (c)localObject);
      AppMethodBeat.o(88933);
      return;
    }
    paramImageView.setImageResource(paramInt2);
    AppMethodBeat.o(88933);
  }
  
  public static void a(MMActivity paramMMActivity, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88936);
    paramMMActivity.setActionbarColor(l.IB(paramb.bbd().color));
    AppMethodBeat.o(88936);
  }
  
  public static void d(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(88937);
    paramMMActivity.setActionbarColor(paramMMActivity.getResources().getColor(2131690709));
    AppMethodBeat.o(88937);
  }
  
  public static Rect dg(View paramView)
  {
    AppMethodBeat.i(88930);
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(88930);
    return localRect;
  }
  
  public static void f(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(88938);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88938);
      return;
      paramTextView.setText(2131298064);
      AppMethodBeat.o(88938);
      return;
      paramTextView.setText(2131298059);
      AppMethodBeat.o(88938);
      return;
      paramTextView.setText(2131298062);
      AppMethodBeat.o(88938);
      return;
      paramTextView.setText(2131298061);
      AppMethodBeat.o(88938);
      return;
      paramTextView.setText(2131298065);
      AppMethodBeat.o(88938);
      return;
      paramTextView.setText(2131298066);
      AppMethodBeat.o(88938);
      return;
      paramTextView.setText(2131298060);
      AppMethodBeat.o(88938);
      return;
      paramTextView.setText(2131298063);
    }
  }
  
  public static void k(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(88931);
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(88931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m
 * JD-Core Version:    0.7.0.1
 */