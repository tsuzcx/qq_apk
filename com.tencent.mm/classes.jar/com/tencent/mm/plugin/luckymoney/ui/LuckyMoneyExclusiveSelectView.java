package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyExclusiveSelectView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyInputView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "arrowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "titleTv", "Landroid/widget/TextView;", "usernameTv", "checkInputValid", "", "checkInputValid2", "getErrTips", "", "checkValidType", "getInputViewId", "init", "", "onError", "restore", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuckyMoneyExclusiveSelectView
  extends LinearLayout
  implements d
{
  private TextView nnW;
  private TextView titleTv;
  private WeImageView wEX;
  
  public LuckyMoneyExclusiveSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(284313);
    paramContext = LinearLayout.inflate(paramContext, a.g.lucky_money_exclusive_select_view, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(a.f.lucky_money_exclusive_username_tv);
    s.s(paramAttributeSet, "view.findViewById(R.id.l…ey_exclusive_username_tv)");
    this.nnW = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(a.f.lucky_money_exclusive_title_tv);
    s.s(paramAttributeSet, "view.findViewById(R.id.l…money_exclusive_title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(a.f.lucky_money_exclusive_arrow_iv);
    s.s(paramContext, "view.findViewById(R.id.l…money_exclusive_arrow_iv)");
    this.wEX = ((WeImageView)paramContext);
    AppMethodBeat.o(284313);
  }
  
  public final String ZF(int paramInt)
  {
    AppMethodBeat.i(284334);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(284334);
      return "";
    }
    Context localContext = getContext();
    paramInt = a.i.lucky_money_prepare_item_error_accessibility_text2;
    TextView localTextView = this.titleTv;
    Object localObject = localTextView;
    if (localTextView == null)
    {
      s.bIx("titleTv");
      localObject = null;
    }
    localObject = localContext.getString(paramInt, new Object[] { ((TextView)localObject).getText() });
    s.s(localObject, "context.getString(R.stri…lity_text2, titleTv.text)");
    AppMethodBeat.o(284334);
    return localObject;
  }
  
  public final void atR()
  {
    Object localObject2 = null;
    AppMethodBeat.i(284327);
    TextView localTextView = this.titleTv;
    Object localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("titleTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(ah.iM(getContext()));
    localObject1 = this.wEX;
    if (localObject1 == null)
    {
      s.bIx("arrowIv");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((WeImageView)localObject1).setIconColor(ah.iM(getContext()));
      AppMethodBeat.o(284327);
      return;
    }
  }
  
  public final int fWv()
  {
    return 0;
  }
  
  public final int fWw()
  {
    AppMethodBeat.i(284321);
    TextView localTextView2 = this.nnW;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("usernameTv");
      localTextView1 = null;
    }
    if (!Util.isNullOrNil(localTextView1.getText()))
    {
      AppMethodBeat.o(284321);
      return 0;
    }
    AppMethodBeat.o(284321);
    return 4;
  }
  
  public final int getInputViewId()
  {
    return 0;
  }
  
  public final void restore()
  {
    Object localObject2 = null;
    AppMethodBeat.i(284323);
    TextView localTextView = this.titleTv;
    Object localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("titleTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(a.c.normal_text_color));
    localObject1 = this.wEX;
    if (localObject1 == null)
    {
      s.bIx("arrowIv");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((WeImageView)localObject1).setIconColor(getResources().getColor(a.c.FG_0));
      AppMethodBeat.o(284323);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyExclusiveSelectView
 * JD-Core Version:    0.7.0.1
 */