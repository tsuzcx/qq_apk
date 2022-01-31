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
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.d.c.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    if (paramJSONObject == null) {}
    for (int i = 0;; i = paramJSONObject.optInt("businessType"))
    {
      int j = i;
      if (i == 0)
      {
        if (!paramString.equals(paramContext.getString(n.g.search_education_article))) {
          break;
        }
        j = 2;
      }
      return j;
    }
    if (paramString.equals(paramContext.getString(n.g.search_education_timeline))) {
      return 8;
    }
    if (paramString.equals(paramContext.getString(n.g.search_education_biz_contact))) {
      return 1;
    }
    y.i("MicroMsg.FTS.FTSUIApiLogic", "option " + paramString + " no type");
    return i;
  }
  
  public static CharSequence a(Context paramContext, List<com.tencent.mm.plugin.fts.a.a.f> paramList, String[] paramArrayOfString, com.tencent.mm.plugin.fts.a.a.g paramg, TextPaint paramTextPaint)
  {
    Arrays.sort(paramArrayOfString, new m.1((n)com.tencent.mm.kernel.g.t(n.class)));
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject1 = (com.tencent.mm.plugin.fts.a.a.f)paramList.get(i);
      String str1;
      String str2;
      if (((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwA < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[localObject1.kwA];
        if (!bk.bl((String)localObject2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl((String)localObject2);
          if (localObject2 != null)
          {
            str1 = ((ao)localObject2).field_username;
            str2 = s.a((ad)localObject2, str1);
            switch (((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwf)
            {
            }
          }
        }
      }
      for (;;)
      {
        if ((!bk.bl(((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwC)) && (((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwC.contains(paramg.kwG))) {
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwE += 10;
        }
        i += 1;
        break;
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwC = com.tencent.mm.plugin.fts.a.d.dk(str1, ((ad)localObject2).vk());
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwD = str2;
        continue;
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwF = true;
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwj = true;
        ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwC = ((ao)localObject2).field_nickname;
        if (!((ao)localObject2).field_nickname.equals(str2))
        {
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwD = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwF = true;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwj = true;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwC = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwC = ((com.tencent.mm.plugin.fts.a.a.f)localObject1).content;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwD = str2;
          continue;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwC = ((ao)localObject2).cCJ;
          ((com.tencent.mm.plugin.fts.a.a.f)localObject1).kwD = str2;
        }
      }
    }
    Collections.sort(paramList, new m.2());
    i = 0;
    float f = 0.0F;
    while ((i < paramList.size()) && (i < paramg.kwI.length))
    {
      f = b.a.kzX - 100 - f;
      if (f <= 100.0F) {
        break;
      }
      paramArrayOfString = (com.tencent.mm.plugin.fts.a.a.f)paramList.get(i);
      localObject1 = com.tencent.mm.pluginsdk.ui.d.j.a(paramContext, paramArrayOfString.kwC, paramTextPaint.getTextSize());
      if (localSpannableStringBuilder.length() > 0) {
        localSpannableStringBuilder.append(", ");
      }
      localObject2 = new com.tencent.mm.plugin.fts.a.a.d();
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).kwh = ((CharSequence)localObject1);
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).kwi = paramg;
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).kwj = paramArrayOfString.kwj;
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).kwk = paramArrayOfString.kwF;
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).kwn = f;
      ((com.tencent.mm.plugin.fts.a.a.d)localObject2).dOi = paramTextPaint;
      if (!bk.bl(paramArrayOfString.kwD))
      {
        ((com.tencent.mm.plugin.fts.a.a.d)localObject2).kwo = TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.d.j.a(paramContext, paramArrayOfString.kwD, paramTextPaint.getTextSize()), "(" });
        ((com.tencent.mm.plugin.fts.a.a.d)localObject2).kwp = ")";
      }
      localSpannableStringBuilder.append(com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.d)localObject2).kwz);
      f = paramTextPaint.measureText(localSpannableStringBuilder.toString());
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, paramImageView, paramString1, paramString2, paramInt, true, 0, 0);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSImageLoader().a(paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
    if ((!bk.bl(paramString1)) || (!bk.bl(paramString2)))
    {
      Bitmap localBitmap = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSImageLoader().a(paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        c.a.a(paramContext.getResources(), localBitmap, paramImageView);
        paramImageView.setVisibility(0);
        return;
      }
      if (paramInt1 > 0) {
        paramImageView.setImageResource(paramInt1);
      }
      for (;;)
      {
        ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSImageLoader().a(paramContext, paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
        break;
        paramImageView.setImageResource(n.a.transparent);
      }
    }
    if ((paramInt1 > 0) && ((!bk.bl(paramString1)) || (!bk.bl(paramString2))))
    {
      paramImageView.setImageResource(paramInt1);
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  public static boolean a(CharSequence paramCharSequence, TextView paramTextView)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
    {
      paramTextView.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      paramTextView.setVisibility(0);
      return true;
    }
    paramTextView.setVisibility(8);
    return false;
  }
  
  public static boolean a(String paramString, TextView paramTextView)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      return true;
    }
    paramTextView.setVisibility(8);
    return false;
  }
  
  public static final void k(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setBackgroundResource(n.c.comm_list_item_selector);
      return;
    }
    paramView.setBackgroundResource(n.c.comm_list_item_selector_no_divider);
  }
  
  public static final void l(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setBackgroundResource(n.c.list_item_normal);
      return;
    }
    paramView.setBackgroundResource(n.c.mm_trans);
  }
  
  public static String rF(int paramInt)
  {
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      return null;
      i = n.g.fts_header_top_hits;
      continue;
      i = n.g.fts_header_favorite;
      continue;
      i = n.g.fts_header_message;
      continue;
      i = n.g.fts_header_chatroom;
      continue;
      i = n.g.fts_header_contact;
      continue;
      i = n.g.fts_header_game;
      continue;
      i = n.g.fts_header_feature;
      continue;
      i = n.g.fts_header_focus_biz;
      continue;
      i = n.g.fts_header_mobile_friend;
      continue;
      i = n.g.fts_header_we_app;
      continue;
      i = n.g.fts_header_mini_game;
    }
    return ae.getContext().getString(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.m
 * JD-Core Version:    0.7.0.1
 */