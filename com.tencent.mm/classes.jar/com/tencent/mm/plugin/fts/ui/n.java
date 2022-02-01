package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.c.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public final class n
{
  public static String Nu(int paramInt)
  {
    AppMethodBeat.i(112043);
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(112043);
      return null;
      i = 2131761019;
      continue;
      i = 2131761006;
      continue;
      i = 2131761010;
      continue;
      i = 2131761002;
      continue;
      i = 2131761003;
      continue;
      i = 2131761009;
      continue;
      i = 2131761007;
      continue;
      i = 2131761008;
      continue;
      i = 2131761012;
      continue;
      i = 2131761020;
      continue;
      i = 2131761011;
      continue;
      i = 2131761021;
    }
    String str = MMApplicationContext.getContext().getString(i);
    AppMethodBeat.o(112043);
    return str;
  }
  
  public static int a(JSONObject paramJSONObject, String paramString, Context paramContext)
  {
    AppMethodBeat.i(112048);
    int j;
    int i;
    if (paramJSONObject == null)
    {
      j = 0;
      i = j;
      if (j == 0)
      {
        if (!paramString.equals(paramContext.getString(2131765074))) {
          break label53;
        }
        i = 2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112048);
      return i;
      j = paramJSONObject.optInt("businessType");
      break;
      label53:
      if (paramString.equals(paramContext.getString(2131765078)))
      {
        i = 8;
      }
      else if (paramString.equals(paramContext.getString(2131765075)))
      {
        i = 1;
      }
      else
      {
        Log.i("MicroMsg.FTS.FTSUIApiLogic", "option " + paramString + " no type");
        i = j;
      }
    }
  }
  
  public static CharSequence a(Context paramContext, List<com.tencent.mm.plugin.fts.a.a.g> paramList, String[] paramArrayOfString, h paramh, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(112044);
    Arrays.sort(paramArrayOfString, new Comparator() {});
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject1 = (com.tencent.mm.plugin.fts.a.a.g)paramList.get(i);
      String str1;
      String str2;
      if (((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWv < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[localObject1.wWv];
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject2);
          if (localObject2 != null)
          {
            str1 = ((ax)localObject2).field_username;
            str2 = ((b)com.tencent.mm.kernel.g.af(b.class)).b((as)localObject2, str1);
            switch (((com.tencent.mm.plugin.fts.a.a.g)localObject1).wVW)
            {
            }
          }
        }
      }
      for (;;)
      {
        if ((!Util.isNullOrNil(((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWx)) && (((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWx.contains(paramh.wWB))) {
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWz += 10;
        }
        i += 1;
        break;
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWx = d.hw(str1, ((as)localObject2).ajx());
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWy = str2;
        continue;
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWA = true;
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWe = true;
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWx = ((ax)localObject2).field_nickname;
        if (!((ax)localObject2).field_nickname.equals(str2))
        {
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWy = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWA = true;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWe = true;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWx = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWx = ((com.tencent.mm.plugin.fts.a.a.g)localObject1).content;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWy = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWx = ((ax)localObject2).fuR;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).wWy = str2;
        }
      }
    }
    Collections.sort(paramList, new Comparator() {});
    i = 0;
    float f = 0.0F;
    while ((i < paramList.size()) && (i < paramh.wWD.length))
    {
      f = b.a.wZP - 100 - f;
      if (f <= 100.0F) {
        break;
      }
      paramArrayOfString = (com.tencent.mm.plugin.fts.a.a.g)paramList.get(i);
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, paramArrayOfString.wWx, paramTextPaint.getTextSize());
      if (localSpannableStringBuilder.length() > 0) {
        localSpannableStringBuilder.append(", ");
      }
      localObject2 = new e();
      ((e)localObject2).wWc = ((CharSequence)localObject1);
      ((e)localObject2).wWd = paramh;
      ((e)localObject2).wWe = paramArrayOfString.wWe;
      ((e)localObject2).wWf = paramArrayOfString.wWA;
      ((e)localObject2).wWi = f;
      ((e)localObject2).iW = paramTextPaint;
      if (!Util.isNullOrNil(paramArrayOfString.wWy))
      {
        ((e)localObject2).wWj = TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, paramArrayOfString.wWy, paramTextPaint.getTextSize()), "(" });
        ((e)localObject2).wWk = ")";
      }
      localSpannableStringBuilder.append(com.tencent.mm.plugin.fts.a.f.a((e)localObject2).wWu);
      f = paramTextPaint.measureText(localSpannableStringBuilder.toString());
      i += 1;
    }
    AppMethodBeat.o(112044);
    return localSpannableStringBuilder;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112040);
    a(paramContext, paramImageView, paramString1, paramString2, paramInt1, false, paramInt2, paramInt3);
    AppMethodBeat.o(112040);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112039);
    a(paramContext, paramImageView, paramString1, paramString2, paramInt, paramBoolean, 0, 0);
    AppMethodBeat.o(112039);
  }
  
  private static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112041);
    b(paramContext, paramImageView, paramString1, paramString2, paramInt1, paramBoolean, paramInt2, paramInt3);
    AppMethodBeat.o(112041);
  }
  
  public static boolean a(CharSequence paramCharSequence, TextView paramTextView)
  {
    AppMethodBeat.i(112037);
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
    {
      paramTextView.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      paramTextView.setVisibility(0);
      AppMethodBeat.o(112037);
      return true;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(112037);
    return false;
  }
  
  private static void b(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112042);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
    if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
    {
      Bitmap localBitmap = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().b(paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        c.a.a(paramContext.getResources(), localBitmap, paramImageView);
        paramImageView.setVisibility(0);
        AppMethodBeat.o(112042);
        return;
      }
      if (paramInt1 > 0) {
        paramImageView.setImageResource(paramInt1);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(paramContext, paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
        break;
        paramImageView.setImageResource(2131101287);
      }
    }
    if ((paramInt1 > 0) && ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2))))
    {
      paramImageView.setImageResource(paramInt1);
      AppMethodBeat.o(112042);
      return;
    }
    paramImageView.setVisibility(8);
    AppMethodBeat.o(112042);
  }
  
  public static boolean b(String paramString, TextView paramTextView)
  {
    AppMethodBeat.i(112038);
    if (paramTextView == null)
    {
      AppMethodBeat.o(112038);
      return false;
    }
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
      paramTextView.setVisibility(0);
      AppMethodBeat.o(112038);
      return true;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(112038);
    return false;
  }
  
  public static final void q(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112045);
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(112045);
      return;
    }
    paramView.setVisibility(8);
    AppMethodBeat.o(112045);
  }
  
  public static final void r(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112046);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2131231898);
      AppMethodBeat.o(112046);
      return;
    }
    paramView.setBackgroundResource(2131232860);
    AppMethodBeat.o(112046);
  }
  
  public static final void s(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112047);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2131233327);
      AppMethodBeat.o(112047);
      return;
    }
    paramView.setBackgroundResource(2131233974);
    AppMethodBeat.o(112047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.n
 * JD-Core Version:    0.7.0.1
 */