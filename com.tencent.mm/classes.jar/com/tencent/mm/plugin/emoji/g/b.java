package com.tencent.mm.plugin.emoji.g;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.j;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/utils/EmojiStoreWecoinTool;", "", "()V", "Companion", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a ydG;
  private static int ydH;
  
  static
  {
    AppMethodBeat.i(269784);
    ydG = new a((byte)0);
    ydH = -1;
    AppMethodBeat.o(269784);
  }
  
  public static final boolean KK(int paramInt)
  {
    AppMethodBeat.i(269761);
    boolean bool = a.KK(paramInt);
    AppMethodBeat.o(269761);
    return bool;
  }
  
  public static final void ay(Context paramContext, String paramString)
  {
    AppMethodBeat.i(269779);
    a.ay(paramContext, paramString);
    AppMethodBeat.o(269779);
  }
  
  public static final CharSequence c(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(269758);
    paramContext = a.c(paramContext, paramInt, paramString);
    AppMethodBeat.o(269758);
    return paramContext;
  }
  
  public static final void c(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(269776);
    s.u(paramContext, "context");
    s.u(paramString1, "productId");
    s.u(paramString2, "priceType");
    s.u(paramString3, "goodName");
    if (a.dDq())
    {
      a.ga(paramContext).dDn();
      AppMethodBeat.o(269776);
      return;
    }
    Object localObject = am.aixg;
    localObject = paramContext.getResources().getString(h.h.emoji_good_name);
    s.s(localObject, "context.resources.getStr…R.string.emoji_good_name)");
    paramString3 = String.format((String)localObject, Arrays.copyOf(new Object[] { paramString3 }, 1));
    s.s(paramString3, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_product_id", paramString1);
    ((Intent)localObject).putExtra("key_currency_type", paramString2);
    ((Intent)localObject).putExtra("key_pay_type", 6);
    ((Intent)localObject).putExtra("key_price", String.valueOf(paramInt));
    ((Intent)localObject).putExtra("key_desc", paramString3);
    c.b(paramContext, "wallet_index", ".ui.WecoinIapUI", (Intent)localObject, 2001);
    AppMethodBeat.o(269776);
  }
  
  public static final boolean dDp()
  {
    AppMethodBeat.i(269767);
    boolean bool = ((d)com.tencent.mm.kernel.h.ax(d.class)).aBu();
    AppMethodBeat.o(269767);
    return bool;
  }
  
  public static final boolean dDq()
  {
    AppMethodBeat.i(269768);
    boolean bool = a.dDq();
    AppMethodBeat.o(269768);
    return bool;
  }
  
  public static final void dDr()
  {
    AppMethodBeat.i(269771);
    if ((MMApplicationContext.isMainProcess()) && (com.tencent.mm.kernel.h.baz()))
    {
      ydH = 1;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIg, Integer.valueOf(ydH));
    }
    AppMethodBeat.o(269771);
  }
  
  public static final j ga(Context paramContext)
  {
    AppMethodBeat.i(269755);
    paramContext = a.ga(paramContext);
    AppMethodBeat.o(269755);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/utils/EmojiStoreWecoinTool$Companion;", "", "()V", "TAG", "", "isFirstClickWecoinPayButton", "", "checkFirstClickWecoinPayButton", "", "createEmojiStoreWecoinTutorialDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "mContext", "Landroid/content/Context;", "enableWecoinPay", "getEmotionWecoinPriceContentSpan", "", "context", "packWecoinNum", "suffix", "iconColor", "isNeedWecoinPay", "packFlag", "isTeenModeEnable", "launchWecoinPurchase", "", "productId", "priceType", "wecoinNum", "goodName", "showInterceptTipsDialog", "content", "positiveClickCallback", "Lkotlin/Function0;", "updateStatusClickWecoinPayButton", "isClicked", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean KK(int paramInt)
    {
      return (paramInt & 0x200) == 512;
    }
    
    private static final void a(j paramj)
    {
      AppMethodBeat.i(269788);
      s.u(paramj, "$bottomDialog");
      paramj.cyW();
      AppMethodBeat.o(269788);
    }
    
    private static final void a(kotlin.g.a.a parama, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(269792);
      if ((paramBoolean) && (parama != null)) {
        parama.invoke();
      }
      AppMethodBeat.o(269792);
    }
    
    public static void ay(Context paramContext, String paramString)
    {
      AppMethodBeat.i(269782);
      s.u(paramContext, "context");
      s.u(paramString, "content");
      g.a locala = new g.a(paramContext);
      locala.bDE(paramString).bDI(paramContext.getString(h.h.emoji_wecoin_intercept_dialog_button_wording)).c(new b.a..ExternalSyntheticLambda0(null)).show();
      locala.pRv.cX(-2, false);
      AppMethodBeat.o(269782);
    }
    
    public static CharSequence c(Context paramContext, int paramInt, String paramString)
    {
      AppMethodBeat.i(269777);
      s.u(paramContext, "context");
      s.u(paramString, "suffix");
      Object localObject = am.aixg;
      localObject = paramContext.getString(h.h.emoji_wecoin_price_button_woring);
      s.s(localObject, "context.getString(R.stri…coin_price_button_woring)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      paramString = new SpannableString((CharSequence)s.X((String)localObject, paramString));
      localObject = paramContext.getString(h.h.emoji_wecoin_price_button_wording_replace);
      s.s(localObject, "context.getString(R.stri…e_button_wording_replace)");
      paramInt = n.a((CharSequence)paramString, (String)localObject, 0, false, 6);
      int i = paramContext.getResources().getDrawable(h.g.wecoin_balance_icons).getIntrinsicWidth();
      int j = com.tencent.mm.cd.a.br(paramContext, h.c.Edge_2A);
      float f = 1.0F * j / i;
      paramContext = com.tencent.mm.svg.a.a.a(paramContext.getResources(), h.g.wecoin_balance_icons, f);
      paramContext.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      paramContext.setBounds(0, 0, j, j);
      s.s(paramContext, "scaleDrawable");
      paramString.setSpan(new com.tencent.mm.view.h(paramContext), paramInt, ((String)localObject).length() + paramInt, 17);
      paramContext = (CharSequence)paramString;
      AppMethodBeat.o(269777);
      return paramContext;
    }
    
    public static boolean dDq()
    {
      AppMethodBeat.i(269781);
      if (b.dDs() == -1) {
        b.KL(com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acIg, 0));
      }
      if (b.dDs() == 0)
      {
        AppMethodBeat.o(269781);
        return true;
      }
      AppMethodBeat.o(269781);
      return false;
    }
    
    public static j ga(Context paramContext)
    {
      AppMethodBeat.i(269773);
      s.u(paramContext, "mContext");
      j localj = new j(paramContext, 2, 0);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      String str = paramContext.getResources().getString(h.h.emoji_wecoin_tutorial_dialog_title_wording);
      s.s(str, "mContext.resources.getSt…ial_dialog_title_wording)");
      TextView localTextView = new TextView(paramContext);
      localLinearLayout.addView((View)localTextView);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(localTextView.getLayoutParams());
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.topMargin = com.tencent.mm.cd.a.bs(paramContext, h.c.Edge_5A);
      localLayoutParams.bottomMargin = com.tencent.mm.cd.a.bs(paramContext, h.c.Edge_3A);
      localTextView.setTextColor(com.tencent.mm.cd.a.w(paramContext, h.b.black_text_color));
      localTextView.setTextSize(1, 17.0F);
      aw.a((Paint)localTextView.getPaint(), 0.8F);
      localTextView.setText((CharSequence)str);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      str = paramContext.getResources().getString(h.h.emoji_wecoin_tutorial_dialog_desc_wording);
      s.s(str, "mContext.resources.getSt…rial_dialog_desc_wording)");
      localTextView = new TextView(paramContext);
      localLinearLayout.addView((View)localTextView);
      localLayoutParams = new LinearLayout.LayoutParams(localTextView.getLayoutParams());
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.bottomMargin = com.tencent.mm.cd.a.bs(paramContext, h.c.Edge_A);
      localTextView.setTextColor(com.tencent.mm.cd.a.w(paramContext, h.b.desc_text));
      localTextView.setTextSize(1, 17.0F);
      localTextView.setText((CharSequence)str);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      localj.setCustomView((View)localLinearLayout);
      localj.au((CharSequence)paramContext.getResources().getString(h.h.emoji_wecoin_tutorial_dialog_button_wording));
      localj.aFe(1);
      localj.agfR = new b.a..ExternalSyntheticLambda1(localj);
      AppMethodBeat.o(269773);
      return localj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.b
 * JD-Core Version:    0.7.0.1
 */