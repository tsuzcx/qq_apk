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
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.c.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class m
{
  public static int a(JSONObject paramJSONObject, String paramString, Context paramContext)
  {
    AppMethodBeat.i(61964);
    int j;
    int i;
    if (paramJSONObject == null)
    {
      j = 0;
      i = j;
      if (j == 0)
      {
        if (!paramString.equals(paramContext.getString(2131302999))) {
          break label53;
        }
        i = 2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(61964);
      return i;
      j = paramJSONObject.optInt("businessType");
      break;
      label53:
      if (paramString.equals(paramContext.getString(2131303003)))
      {
        i = 8;
      }
      else if (paramString.equals(paramContext.getString(2131303000)))
      {
        i = 1;
      }
      else
      {
        ab.i("MicroMsg.FTS.FTSUIApiLogic", "option " + paramString + " no type");
        i = j;
      }
    }
  }
  
  public static CharSequence a(Context paramContext, List<com.tencent.mm.plugin.fts.a.a.f> paramList, String[] paramArrayOfString, com.tencent.mm.plugin.fts.a.a.g paramg, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(61961);
    Arrays.sort(paramArrayOfString, new m.1((n)com.tencent.mm.kernel.g.G(n.class)));
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject1 = (com.tencent.mm.plugin.fts.a.a.f)paramList.get(i);
      String str1;
      String str2;
      if (((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSq < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[localObject1.mSq];
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject2);
          if (localObject2 != null)
          {
            str1 = ((aq)localObject2).field_username;
            str2 = t.a((ad)localObject2, str1);
            switch (((com.tencent.mm.plugin.fts.a.a.f)localObject1).mRU)
            {
            }
          }
        }
      }
      for (;;)
      {
        if ((!bo.isNullOrNil(((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSs)) && (((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSs.contains(paramg.mSw))) {
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSu += 10;
        }
        i += 1;
        break;
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSs = com.tencent.mm.plugin.fts.a.d.ey(str1, ((ad)localObject2).Hq());
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSt = str2;
        continue;
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSv = true;
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mRY = true;
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSs = ((aq)localObject2).field_nickname;
        if (!((aq)localObject2).field_nickname.equals(str2))
        {
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSt = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSv = true;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mRY = true;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSs = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSs = ((com.tencent.mm.plugin.fts.a.a.f)localObject1).content;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSt = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSs = ((aq)localObject2).dqT;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).mSt = str2;
        }
      }
    }
    Collections.sort(paramList, new m.2());
    i = 0;
    float f = 0.0F;
    while ((i < paramList.size()) && (i < paramg.mSy.length))
    {
      f = b.a.mVP - 100 - f;
      if (f <= 100.0F) {
        break;
      }
      paramArrayOfString = (com.tencent.mm.plugin.fts.a.a.f)paramList.get(i);
      localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramArrayOfString.mSs, paramTextPaint.getTextSize());
      if (localSpannableStringBuilder.length() > 0) {
        localSpannableStringBuilder.append(", ");
      }
      localObject2 = new com.tencent.mm.plugin.fts.a.a.d();
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).mRW = ((CharSequence)localObject1);
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).mRX = paramg;
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).mRY = paramArrayOfString.mRY;
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).mRZ = paramArrayOfString.mSv;
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).mSc = f;
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).eLQ = paramTextPaint;
      if (!bo.isNullOrNil(paramArrayOfString.mSt))
      {
        ((com.tencent.mm.plugin.fts.a.a.d)localObject2).mSd = TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramArrayOfString.mSt, paramTextPaint.getTextSize()), "(" });
        ((com.tencent.mm.plugin.fts.a.a.d)localObject2).mSe = ")";
      }
      localSpannableStringBuilder.append(com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.d)localObject2).mSp);
      f = paramTextPaint.measureText(localSpannableStringBuilder.toString());
      i += 1;
    }
    AppMethodBeat.o(61961);
    return localSpannableStringBuilder;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(61958);
    a(paramContext, paramImageView, paramString1, paramString2, paramInt, true, 0, 0);
    AppMethodBeat.o(61958);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152155);
    a(paramContext, paramImageView, paramString1, paramString2, paramInt1, false, paramInt2, paramInt3);
    AppMethodBeat.o(152155);
  }
  
  private static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(61959);
    ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSImageLoader().a(paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
    if ((!bo.isNullOrNil(paramString1)) || (!bo.isNullOrNil(paramString2)))
    {
      Bitmap localBitmap = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSImageLoader().a(paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        c.a.a(paramContext.getResources(), localBitmap, paramImageView);
        paramImageView.setVisibility(0);
        AppMethodBeat.o(61959);
        return;
      }
      if (paramInt1 > 0) {
        paramImageView.setImageResource(paramInt1);
      }
      for (;;)
      {
        ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSImageLoader().a(paramContext, paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
        break;
        paramImageView.setImageResource(2131690605);
      }
    }
    if ((paramInt1 > 0) && ((!bo.isNullOrNil(paramString1)) || (!bo.isNullOrNil(paramString2))))
    {
      paramImageView.setImageResource(paramInt1);
      AppMethodBeat.o(61959);
      return;
    }
    paramImageView.setVisibility(8);
    AppMethodBeat.o(61959);
  }
  
  public static boolean a(CharSequence paramCharSequence, TextView paramTextView)
  {
    AppMethodBeat.i(61956);
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
    {
      paramTextView.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      paramTextView.setVisibility(0);
      AppMethodBeat.o(61956);
      return true;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(61956);
    return false;
  }
  
  public static boolean a(String paramString, TextView paramTextView)
  {
    AppMethodBeat.i(61957);
    if (paramTextView == null)
    {
      AppMethodBeat.o(61957);
      return false;
    }
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      AppMethodBeat.o(61957);
      return true;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(61957);
    return false;
  }
  
  public static final void p(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(152156);
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(152156);
      return;
    }
    paramView.setVisibility(8);
    AppMethodBeat.o(152156);
  }
  
  public static final void q(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(61962);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130838445);
      AppMethodBeat.o(61962);
      return;
    }
    paramView.setBackgroundResource(2130838447);
    AppMethodBeat.o(61962);
  }
  
  public static final void r(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(61963);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839276);
      AppMethodBeat.o(61963);
      return;
    }
    paramView.setBackgroundResource(2130839676);
    AppMethodBeat.o(61963);
  }
  
  public static String wA(int paramInt)
  {
    AppMethodBeat.i(61960);
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      AppMethodBeat.o(61960);
      return null;
      i = 2131300225;
      continue;
      i = 2131300212;
      continue;
      i = 2131300216;
      continue;
      i = 2131300208;
      continue;
      i = 2131300209;
      continue;
      i = 2131300215;
      continue;
      i = 2131300213;
      continue;
      i = 2131300214;
      continue;
      i = 2131300218;
      continue;
      i = 2131300226;
      continue;
      i = 2131300217;
      continue;
      i = 2131300227;
    }
    String str = ah.getContext().getString(i);
    AppMethodBeat.o(61960);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.m
 * JD-Core Version:    0.7.0.1
 */