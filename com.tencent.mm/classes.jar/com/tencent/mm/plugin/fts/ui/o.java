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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public final class o
{
  public static String Wp(int paramInt)
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
      i = p.g.fts_header_top_hits;
      continue;
      i = p.g.fts_header_favorite;
      continue;
      i = p.g.fts_header_message;
      continue;
      i = p.g.fts_header_chatroom;
      continue;
      i = p.g.fts_header_contact;
      continue;
      i = p.g.fts_header_game;
      continue;
      i = p.g.fts_header_feature;
      continue;
      i = p.g.fts_header_focus_biz;
      continue;
      i = p.g.fts_header_focus_finder_follow;
      continue;
      i = p.g.fts_header_mobile_friend;
      continue;
      i = p.g.fts_header_we_app;
      continue;
      i = p.g.fts_header_mini_game;
      continue;
      i = p.g.fts_header_we_app_search;
      continue;
      i = p.g.search_service_notify_username;
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
        if (!paramString.equals(paramContext.getString(p.g.search_education_article))) {
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
      if (paramString.equals(paramContext.getString(p.g.search_education_timeline)))
      {
        i = 8;
      }
      else if (paramString.equals(paramContext.getString(p.g.search_education_biz_contact)))
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
  
  public static CharSequence a(Context paramContext, List<i> paramList, String[] paramArrayOfString, j paramj, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(112044);
    Arrays.sort(paramArrayOfString, new Comparator() {});
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject1 = (i)paramList.get(i);
      String str1;
      String str2;
      if (((i)localObject1).HsY < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[localObject1.HsY];
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject2);
          if (localObject2 != null)
          {
            str1 = ((az)localObject2).field_username;
            str2 = ((b)com.tencent.mm.kernel.h.ax(b.class)).b((au)localObject2, str1);
            switch (((i)localObject1).subtype)
            {
            }
          }
        }
      }
      for (;;)
      {
        if ((!Util.isNullOrNil(((i)localObject1).Hta)) && (((i)localObject1).Hta.contains(paramj.Hte))) {
          ((i)localObject1).Htc += 10;
        }
        i += 1;
        break;
        ((i)localObject1).Hta = com.tencent.mm.plugin.fts.a.d.iC(str1, ((au)localObject2).aJs());
        ((i)localObject1).Htb = str2;
        continue;
        ((i)localObject1).Htd = true;
        ((i)localObject1).HsH = true;
        ((i)localObject1).Hta = ((az)localObject2).field_nickname;
        if (!((az)localObject2).field_nickname.equals(str2))
        {
          ((i)localObject1).Htb = str2;
          continue;
          ((i)localObject1).Htd = true;
          ((i)localObject1).HsH = true;
          ((i)localObject1).Hta = str2;
          continue;
          ((i)localObject1).Hta = ((i)localObject1).content;
          ((i)localObject1).Htb = str2;
          continue;
          ((i)localObject1).Hta = ((az)localObject2).kal;
          ((i)localObject1).Htb = str2;
        }
      }
    }
    Collections.sort(paramList, new Comparator() {});
    i = 0;
    float f = 0.0F;
    while ((i < paramList.size()) && (i < paramj.Htg.length))
    {
      f = b.a.HwK - 100 - f;
      if (f <= 100.0F) {
        break;
      }
      paramArrayOfString = (i)paramList.get(i);
      localObject1 = p.b(paramContext, paramArrayOfString.Hta, paramTextPaint.getTextSize());
      if (localSpannableStringBuilder.length() > 0) {
        localSpannableStringBuilder.append(", ");
      }
      localObject2 = new g();
      ((g)localObject2).HsG = ((CharSequence)localObject1);
      ((g)localObject2).FWt = paramj;
      ((g)localObject2).HsH = paramArrayOfString.HsH;
      ((g)localObject2).HsI = paramArrayOfString.Htd;
      ((g)localObject2).HsL = f;
      ((g)localObject2).dso = paramTextPaint;
      if (!Util.isNullOrNil(paramArrayOfString.Htb))
      {
        ((g)localObject2).HsM = TextUtils.concat(new CharSequence[] { p.b(paramContext, paramArrayOfString.Htb, paramTextPaint.getTextSize()), "(" });
        ((g)localObject2).HsN = ")";
      }
      localSpannableStringBuilder.append(f.a((g)localObject2).HsX);
      f = paramTextPaint.measureText(localSpannableStringBuilder.toString());
      i += 1;
    }
    AppMethodBeat.o(112044);
    return localSpannableStringBuilder;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112039);
    a(paramContext, paramImageView, paramString1, paramString2, paramInt, paramBoolean, 0, 0);
    AppMethodBeat.o(112039);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
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
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
    if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
    {
      Bitmap localBitmap = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().c(paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        com.tencent.mm.plugin.fts.a.d.c.a.a(paramContext.getResources(), localBitmap, paramImageView);
        paramImageView.setVisibility(0);
        AppMethodBeat.o(112042);
        return;
      }
      if (paramInt1 > 0) {
        paramImageView.setImageResource(paramInt1);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(paramContext, paramImageView, paramString1, paramString2, paramBoolean, paramInt2, paramInt3);
        break;
        paramImageView.setImageResource(p.a.transparent);
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
      paramTextView.setText(p.b(paramTextView.getContext(), paramString, paramTextView.getTextSize()));
      paramTextView.setVisibility(0);
      AppMethodBeat.o(112038);
      return true;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(112038);
    return false;
  }
  
  public static boolean fyA()
  {
    AppMethodBeat.i(265666);
    long l = z.bAR();
    boolean bool3 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
    boolean bool1;
    boolean bool4;
    if ((0x0 & l) != 0L)
    {
      bool1 = true;
      bool4 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      int i = fyB();
      if ((i != 1) && (i != 2)) {
        break label146;
      }
    }
    label146:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.FTS.FTSUIApiLogic", "isOpenFTSHotSearch show:%s open:%s, isTeenModeAndNothing:%s exptFlag:%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(bool2) });
      if ((!bool3) || (bool1) || (bool4) || (!bool2)) {
        break label152;
      }
      AppMethodBeat.o(265666);
      return true;
      bool1 = false;
      break;
    }
    label152:
    AppMethodBeat.o(265666);
    return false;
  }
  
  public static int fyB()
  {
    AppMethodBeat.i(265670);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjF, com.tencent.mm.util.b.a.agsV, 0);
    AppMethodBeat.o(265670);
    return i;
  }
  
  public static final void w(View paramView, boolean paramBoolean)
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
  
  public static final void x(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112046);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(p.c.comm_list_item_selector);
      AppMethodBeat.o(112046);
      return;
    }
    paramView.setBackgroundResource(p.c.fts_web_search_result_header_bg);
    AppMethodBeat.o(112046);
  }
  
  public static final void y(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112047);
    if (paramBoolean)
    {
      paramView.setBackgroundResource(p.c.list_item_normal);
      AppMethodBeat.o(112047);
      return;
    }
    paramView.setBackgroundResource(p.c.mm_trans);
    AppMethodBeat.o(112047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.o
 * JD-Core Version:    0.7.0.1
 */