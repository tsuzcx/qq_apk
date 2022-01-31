package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class d
{
  public static void a(MMActivity paramMMActivity, d.b paramb)
  {
    h.a(paramMMActivity, true, paramMMActivity.getString(a.g.card_clear_list_tip), "", paramMMActivity.getString(a.g.app_ok), paramMMActivity.getString(a.g.app_cancel), new d.4(paramb), new d.5());
  }
  
  public static void a(MMActivity paramMMActivity, String paramString1, String paramString2, d.b paramb)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = paramMMActivity.getString(a.g.app_delete_tips);
    }
    for (;;)
    {
      h.a(paramMMActivity, true, paramString2, paramMMActivity.getString(a.g.app_tip), paramMMActivity.getString(a.g.app_ok), paramMMActivity.getString(a.g.app_cancel), new d.1(paramb, paramString1), new d.3());
      return;
    }
  }
  
  public static void a(MMActivity paramMMActivity, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramMMActivity.getString(a.g.card_wallet_unknown_err);
    }
    h.a(paramMMActivity, str, null, false, new d.6(paramBoolean, paramMMActivity));
  }
  
  public static void b(MMActivity paramMMActivity, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramMMActivity.getString(a.g.card_wallet_unknown_err);
    }
    a(paramMMActivity, str, false);
  }
  
  public static void b(MMActivity paramMMActivity, String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "errcode = " + paramInt;
    }
    a(paramMMActivity, str, false);
  }
  
  public static void c(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == -1) {
      return;
    }
    String str1;
    if (paramInt1 == a.e.card_show_share_card_entrance_tips)
    {
      str2 = paramContext.getResources().getString(paramInt2);
      str3 = paramContext.getResources().getString(a.g.card_iknow);
      localObject1 = new d.9();
      localObject2 = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt1, null);
      if (paramInt1 == a.e.card_show_accepted_tips_for_share)
      {
        localObject3 = (TextView)((View)localObject2).findViewById(a.d.card_show_accepted_tips_tv);
        str1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str1 = paramContext.getResources().getString(a.g.card_coupon);
        }
        ((TextView)localObject3).setText(paramContext.getResources().getString(a.g.card_accepted_tips_for_share, new Object[] { str1 }));
      }
      for (;;)
      {
        paramContext = h.a(paramContext, str2, str3, (View)localObject2, (DialogInterface.OnClickListener)localObject1);
        label139:
        if (paramContext == null) {
          break;
        }
        paramContext.show();
        return;
        if (paramInt1 == a.e.card_show_accepted_tips)
        {
          localObject3 = (TextView)((View)localObject2).findViewById(a.d.card_show_accepted_tips_tv);
          str1 = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str1 = paramContext.getResources().getString(a.g.card_coupon);
          }
          ((TextView)localObject3).setText(paramContext.getResources().getString(a.g.card_accepted_tips, new Object[] { str1 }));
        }
      }
    }
    String str2 = paramContext.getResources().getString(paramInt2);
    String str3 = paramContext.getResources().getString(a.g.card_jump_to_card_entrance_tips_btn);
    Object localObject1 = paramContext.getResources().getString(a.g.card_iknow);
    Object localObject2 = new d.10(paramContext);
    Object localObject3 = new d.2();
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(paramInt1, null);
    TextView localTextView;
    if (paramInt1 == a.e.card_show_accepted_tips_for_share)
    {
      localTextView = (TextView)localView.findViewById(a.d.card_show_accepted_tips_tv);
      str1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str1 = paramContext.getResources().getString(a.g.card_coupon);
      }
      localTextView.setText(paramContext.getResources().getString(a.g.card_accepted_tips_for_share, new Object[] { str1 }));
    }
    for (;;)
    {
      paramContext = h.a(paramContext, str2, localView, str3, (String)localObject1, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject3);
      break label139;
      break;
      if (paramInt1 == a.e.card_show_accepted_tips)
      {
        localTextView = (TextView)localView.findViewById(a.d.card_show_accepted_tips_tv);
        str1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str1 = paramContext.getResources().getString(a.g.card_coupon);
        }
        localTextView.setText(paramContext.getResources().getString(a.g.card_accepted_tips, new Object[] { str1 }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d
 * JD-Core Version:    0.7.0.1
 */