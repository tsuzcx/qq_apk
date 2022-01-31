package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class LuckyMoneyAutoScrollView
  extends RelativeLayout
  implements LuckyMoneyAutoScrollItem.b
{
  private View contentView;
  boolean hasCallBack;
  private Context mContext;
  private RelativeLayout ori;
  private RelativeLayout orj;
  private RelativeLayout ork;
  LuckyMoneyAutoScrollItem orl;
  LuckyMoneyAutoScrollItem orm;
  LuckyMoneyAutoScrollItem orn;
  private RelativeLayout oro;
  private RelativeLayout orp;
  private RelativeLayout orq;
  ImageView orr;
  ImageView ors;
  ImageView ort;
  private String oru;
  private String orv;
  private String orw;
  private LuckyMoneyAutoScrollView.a orx;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42570);
    this.oru = "0";
    this.orv = "0";
    this.orw = "0";
    this.hasCallBack = false;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2130970015, this);
    this.contentView = paramContext;
    this.orl = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131825546));
    this.orm = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131825550));
    this.orn = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131825554));
    t.o(this.orl, 2);
    t.o(this.orm, 2);
    t.o(this.orn, 2);
    this.oro = ((RelativeLayout)paramContext.findViewById(2131825547));
    this.orp = ((RelativeLayout)paramContext.findViewById(2131825551));
    this.orq = ((RelativeLayout)paramContext.findViewById(2131825555));
    this.orr = ((ImageView)paramContext.findViewById(2131825544));
    this.ors = ((ImageView)paramContext.findViewById(2131825549));
    this.ort = ((ImageView)paramContext.findViewById(2131825553));
    this.ori = ((RelativeLayout)paramContext.findViewById(2131825545));
    this.orj = ((RelativeLayout)paramContext.findViewById(2131825548));
    this.ork = ((RelativeLayout)paramContext.findViewById(2131825552));
    AppMethodBeat.o(42570);
  }
  
  public final void a(LuckyMoneyAutoScrollView.a parama)
  {
    AppMethodBeat.i(42572);
    this.orx = parama;
    al.d(new LuckyMoneyAutoScrollView.1(this));
    AppMethodBeat.o(42572);
  }
  
  public final void aQl()
  {
    AppMethodBeat.i(42574);
    if (!this.hasCallBack)
    {
      this.hasCallBack = true;
      al.d(new LuckyMoneyAutoScrollView.2(this));
    }
    AppMethodBeat.o(42574);
  }
  
  public final void bNN()
  {
    AppMethodBeat.i(42573);
    this.orl.setVisibility(8);
    this.orm.setVisibility(8);
    this.orn.setVisibility(8);
    this.orr.setVisibility(0);
    this.ors.setVisibility(0);
    this.ort.setVisibility(0);
    AppMethodBeat.o(42573);
  }
  
  public final void eD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42575);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.contentView.setLayoutParams(localLayoutParams);
      this.contentView.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.ori.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.ori.setLayoutParams(localLayoutParams);
      this.ori.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.orj.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.orj.setLayoutParams(localLayoutParams);
      this.orj.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.ork.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = 0;
      this.ork.setLayoutParams(localLayoutParams);
      this.ork.invalidate();
    }
    AppMethodBeat.o(42575);
  }
  
  public void setFinalText(String paramString)
  {
    AppMethodBeat.i(42571);
    ab.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.oru = paramString.substring(0, 1);
    this.orv = paramString.substring(2, 3);
    this.orw = paramString.substring(3, 4);
    this.orl.setFinalNumber(bo.getInt(this.oru, 0));
    this.orm.setFinalNumber(bo.getInt(this.orv, 0));
    this.orn.setFinalNumber(bo.getInt(this.orw, 0));
    this.orr.setImageResource(((Integer)LuckyMoneyAutoScrollItem.orc.get(bo.getInt(this.oru, 0))).intValue());
    this.ors.setImageResource(((Integer)LuckyMoneyAutoScrollItem.orc.get(bo.getInt(this.orv, 0))).intValue());
    this.ort.setImageResource(((Integer)LuckyMoneyAutoScrollItem.orc.get(bo.getInt(this.orw, 0))).intValue());
    this.orr.setVisibility(4);
    this.ors.setVisibility(4);
    this.ort.setVisibility(4);
    this.orl.setOnScrollEndListener(this);
    this.orm.setOnScrollEndListener(this);
    this.orn.setOnScrollEndListener(this);
    ab.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.oru, this.orv, this.orw });
    AppMethodBeat.o(42571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */