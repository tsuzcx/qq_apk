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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.c.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public final class n
{
  public static String GX(int paramInt)
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
      i = 2131759698;
      continue;
      i = 2131759685;
      continue;
      i = 2131759689;
      continue;
      i = 2131759681;
      continue;
      i = 2131759682;
      continue;
      i = 2131759688;
      continue;
      i = 2131759686;
      continue;
      i = 2131759687;
      continue;
      i = 2131759691;
      continue;
      i = 2131759699;
      continue;
      i = 2131759690;
      continue;
      i = 2131759700;
    }
    String str = aj.getContext().getString(i);
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
        if (!paramString.equals(paramContext.getString(2131762938))) {
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
      if (paramString.equals(paramContext.getString(2131762942)))
      {
        i = 8;
      }
      else if (paramString.equals(paramContext.getString(2131762939)))
      {
        i = 1;
      }
      else
      {
        ad.i("MicroMsg.FTS.FTSUIApiLogic", "option " + paramString + " no type");
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
      if (((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuF < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[localObject1.tuF];
        if (!bt.isNullOrNil((String)localObject2))
        {
          localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject2);
          if (localObject2 != null)
          {
            str1 = ((aw)localObject2).field_username;
            str2 = ((b)com.tencent.mm.kernel.g.ab(b.class)).b((am)localObject2, str1);
            switch (((com.tencent.mm.plugin.fts.a.a.g)localObject1).tug)
            {
            }
          }
        }
      }
      for (;;)
      {
        if ((!bt.isNullOrNil(((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuH)) && (((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuH.contains(paramh.tuL))) {
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuJ += 10;
        }
        i += 1;
        break;
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuH = d.gL(str1, ((am)localObject2).VA());
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuI = str2;
        continue;
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuK = true;
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuo = true;
        ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuH = ((aw)localObject2).field_nickname;
        if (!((aw)localObject2).field_nickname.equals(str2))
        {
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuI = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuK = true;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuo = true;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuH = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuH = ((com.tencent.mm.plugin.fts.a.a.g)localObject1).content;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuI = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuH = ((aw)localObject2).ePD;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject1).tuI = str2;
        }
      }
    }
    Collections.sort(paramList, new Comparator() {});
    i = 0;
    float f = 0.0F;
    while ((i < paramList.size()) && (i < paramh.tuN.length))
    {
      f = b.a.txZ - 100 - f;
      if (f <= 100.0F) {
        break;
      }
      paramArrayOfString = (com.tencent.mm.plugin.fts.a.a.g)paramList.get(i);
      localObject1 = k.b(paramContext, paramArrayOfString.tuH, paramTextPaint.getTextSize());
      if (localSpannableStringBuilder.length() > 0) {
        localSpannableStringBuilder.append(", ");
      }
      localObject2 = new e();
      ((e)localObject2).tum = ((CharSequence)localObject1);
      ((e)localObject2).tun = paramh;
      ((e)localObject2).tuo = paramArrayOfString.tuo;
      ((e)localObject2).tup = paramArrayOfString.tuK;
      ((e)localObject2).tus = f;
      ((e)localObject2).iU = paramTextPaint;
      if (!bt.isNullOrNil(paramArrayOfString.tuI))
      {
        ((e)localObject2).tut = TextUtils.concat(new CharSequence[] { k.b(paramContext, paramArrayOfString.tuI, paramTextPaint.getTextSize()), "(" });
        ((e)localObject2).tuu = ")";
      }
      localSpannableStringBuilder.append(com.tencent.mm.plugin.fts.a.f.a((e)localObject2).tuE);
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
  
  public static boolean a(String paramString, TextView paramTextView)
  {
    AppMethodBeat.i(112038);
    if (paramTextView == null)
    {
      AppMethodBeat.o(112038);
      return false;
    }
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramTextView.setText(k.b(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
      paramTextView.setVisibility(0);
      AppMethodBeat.o(112038);
      return true;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(112038);
    return false;
  }
  
  private static void b(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112042);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
    if ((!bt.isNullOrNil(paramString1)) || (!bt.isNullOrNil(paramString2)))
    {
      Bitmap localBitmap = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().b(paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
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
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(paramContext, paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
        break;
        paramImageView.setImageResource(2131101053);
      }
    }
    if ((paramInt1 > 0) && ((!bt.isNullOrNil(paramString1)) || (!bt.isNullOrNil(paramString2))))
    {
      paramImageView.setImageResource(paramInt1);
      AppMethodBeat.o(112042);
      return;
    }
    paramImageView.setVisibility(8);
    AppMethodBeat.o(112042);
  }
  
  public static final void p(View paramView, boolean paramBoolean)
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
  
  public static final void q(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112046);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2131231818);
      AppMethodBeat.o(112046);
      return;
    }
    paramView.setBackgroundResource(2131232477);
    AppMethodBeat.o(112046);
  }
  
  public static final void r(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112047);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2131232867);
      AppMethodBeat.o(112047);
      return;
    }
    paramView.setBackgroundResource(2131233299);
    AppMethodBeat.o(112047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.n
 * JD-Core Version:    0.7.0.1
 */