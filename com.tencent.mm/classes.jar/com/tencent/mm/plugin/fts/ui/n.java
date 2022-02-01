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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.c.a;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
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
  public static String SI(int paramInt)
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
      i = o.g.fts_header_top_hits;
      continue;
      i = o.g.fts_header_favorite;
      continue;
      i = o.g.fts_header_message;
      continue;
      i = o.g.fts_header_chatroom;
      continue;
      i = o.g.fts_header_contact;
      continue;
      i = o.g.fts_header_game;
      continue;
      i = o.g.fts_header_feature;
      continue;
      i = o.g.fts_header_focus_biz;
      continue;
      i = o.g.fts_header_mobile_friend;
      continue;
      i = o.g.fts_header_we_app;
      continue;
      i = o.g.fts_header_mini_game;
      continue;
      i = o.g.fts_header_we_app_search;
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
        if (!paramString.equals(paramContext.getString(o.g.search_education_article))) {
          break label54;
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
      label54:
      if (paramString.equals(paramContext.getString(o.g.search_education_timeline)))
      {
        i = 8;
      }
      else if (paramString.equals(paramContext.getString(o.g.search_education_biz_contact)))
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
  
  public static CharSequence a(Context paramContext, List<g> paramList, String[] paramArrayOfString, com.tencent.mm.plugin.fts.a.a.h paramh, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(112044);
    Arrays.sort(paramArrayOfString, new Comparator() {});
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject1 = (g)paramList.get(i);
      String str1;
      String str2;
      if (((g)localObject1).BIq < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[localObject1.BIq];
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)localObject2);
          if (localObject2 != null)
          {
            str1 = ((ax)localObject2).field_username;
            str2 = ((b)com.tencent.mm.kernel.h.ae(b.class)).b((as)localObject2, str1);
            switch (((g)localObject1).BHR)
            {
            }
          }
        }
      }
      for (;;)
      {
        if ((!Util.isNullOrNil(((g)localObject1).BIs)) && (((g)localObject1).BIs.contains(paramh.BIw))) {
          ((g)localObject1).BIu += 10;
        }
        i += 1;
        break;
        ((g)localObject1).BIs = d.hD(str1, ((as)localObject2).apf());
        ((g)localObject1).BIt = str2;
        continue;
        ((g)localObject1).BIv = true;
        ((g)localObject1).BHZ = true;
        ((g)localObject1).BIs = ((ax)localObject2).field_nickname;
        if (!((ax)localObject2).field_nickname.equals(str2))
        {
          ((g)localObject1).BIt = str2;
          continue;
          ((g)localObject1).BIv = true;
          ((g)localObject1).BHZ = true;
          ((g)localObject1).BIs = str2;
          continue;
          ((g)localObject1).BIs = ((g)localObject1).content;
          ((g)localObject1).BIt = str2;
          continue;
          ((g)localObject1).BIs = ((ax)localObject2).hDq;
          ((g)localObject1).BIt = str2;
        }
      }
    }
    Collections.sort(paramList, new Comparator() {});
    i = 0;
    float f = 0.0F;
    while ((i < paramList.size()) && (i < paramh.BIy.length))
    {
      f = b.a.BLO - 100 - f;
      if (f <= 100.0F) {
        break;
      }
      paramArrayOfString = (g)paramList.get(i);
      localObject1 = l.b(paramContext, paramArrayOfString.BIs, paramTextPaint.getTextSize());
      if (localSpannableStringBuilder.length() > 0) {
        localSpannableStringBuilder.append(", ");
      }
      localObject2 = new e();
      ((e)localObject2).BHX = ((CharSequence)localObject1);
      ((e)localObject2).BHY = paramh;
      ((e)localObject2).BHZ = paramArrayOfString.BHZ;
      ((e)localObject2).BIa = paramArrayOfString.BIv;
      ((e)localObject2).BId = f;
      ((e)localObject2).bzo = paramTextPaint;
      if (!Util.isNullOrNil(paramArrayOfString.BIt))
      {
        ((e)localObject2).BIe = TextUtils.concat(new CharSequence[] { l.b(paramContext, paramArrayOfString.BIt, paramTextPaint.getTextSize()), "(" });
        ((e)localObject2).BIf = ")";
      }
      localSpannableStringBuilder.append(com.tencent.mm.plugin.fts.a.f.a((e)localObject2).BIp);
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
      paramTextView.setText(l.b(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
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
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
    if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
    {
      Bitmap localBitmap = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().c(paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
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
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(paramContext, paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
        break;
        paramImageView.setImageResource(o.a.transparent);
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
      paramView.setBackgroundResource(o.c.comm_list_item_selector);
      AppMethodBeat.o(112046);
      return;
    }
    paramView.setBackgroundResource(o.c.fts_web_search_result_header_bg);
    AppMethodBeat.o(112046);
  }
  
  public static final void s(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112047);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(o.c.list_item_normal);
      AppMethodBeat.o(112047);
      return;
    }
    paramView.setBackgroundResource(o.c.mm_trans);
    AppMethodBeat.o(112047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.n
 * JD-Core Version:    0.7.0.1
 */