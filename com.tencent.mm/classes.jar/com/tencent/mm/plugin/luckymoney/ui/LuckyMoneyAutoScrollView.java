package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class LuckyMoneyAutoScrollView
  extends RelativeLayout
  implements LuckyMoneyAutoScrollItem.b
{
  private View contentView;
  private RelativeLayout lUb;
  private RelativeLayout lUc;
  private RelativeLayout lUd;
  LuckyMoneyAutoScrollItem lUe;
  LuckyMoneyAutoScrollItem lUf;
  LuckyMoneyAutoScrollItem lUg;
  ImageView lUh;
  ImageView lUi;
  ImageView lUj;
  private String lUk = "0";
  private String lUl = "0";
  private String lUm = "0";
  boolean lUn = false;
  private LuckyMoneyAutoScrollView.a lUo;
  private Context mContext;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(a.g.lucky_money_auto_scroll_view, this);
    this.contentView = paramContext;
    this.lUe = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_1));
    this.lUf = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_2));
    this.lUg = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_3));
    this.lUh = ((ImageView)paramContext.findViewById(a.f.text_number));
    this.lUi = ((ImageView)paramContext.findViewById(a.f.text_number2));
    this.lUj = ((ImageView)paramContext.findViewById(a.f.text_number3));
    this.lUb = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_1));
    this.lUc = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_2));
    this.lUd = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_3));
  }
  
  public final void a(LuckyMoneyAutoScrollView.a parama)
  {
    this.lUo = parama;
    ai.d(new LuckyMoneyAutoScrollView.1(this));
  }
  
  public final void arA()
  {
    if (!this.lUn)
    {
      this.lUn = true;
      ai.d(new LuckyMoneyAutoScrollView.2(this));
    }
  }
  
  public final void de(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.contentView.setLayoutParams(localLayoutParams);
      this.contentView.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.lUb.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.lUb.setLayoutParams(localLayoutParams);
      this.lUb.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.lUc.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.lUc.setLayoutParams(localLayoutParams);
      this.lUc.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.lUd.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = 0;
      this.lUd.setLayoutParams(localLayoutParams);
      this.lUd.invalidate();
    }
  }
  
  public void setFinalText(String paramString)
  {
    y.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.lUk = paramString.substring(0, 1);
    this.lUl = paramString.substring(2, 3);
    this.lUm = paramString.substring(3, 4);
    this.lUe.setFinalNumber(bk.getInt(this.lUk, 0));
    this.lUf.setFinalNumber(bk.getInt(this.lUl, 0));
    this.lUg.setFinalNumber(bk.getInt(this.lUm, 0));
    this.lUh.setImageResource(((Integer)LuckyMoneyAutoScrollItem.lTV.get(bk.getInt(this.lUk, 0))).intValue());
    this.lUi.setImageResource(((Integer)LuckyMoneyAutoScrollItem.lTV.get(bk.getInt(this.lUl, 0))).intValue());
    this.lUj.setImageResource(((Integer)LuckyMoneyAutoScrollItem.lTV.get(bk.getInt(this.lUm, 0))).intValue());
    this.lUh.setVisibility(4);
    this.lUi.setVisibility(4);
    this.lUj.setVisibility(4);
    this.lUe.setOnScrollEndListener(this);
    this.lUf.setOnScrollEndListener(this);
    this.lUg.setOnScrollEndListener(this);
    y.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.lUk, this.lUl, this.lUm });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */