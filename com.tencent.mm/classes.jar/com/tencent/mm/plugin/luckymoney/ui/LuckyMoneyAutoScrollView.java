package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class LuckyMoneyAutoScrollView
  extends RelativeLayout
  implements LuckyMoneyAutoScrollItem.b
{
  private RelativeLayout EGd;
  private RelativeLayout EGe;
  private RelativeLayout EGf;
  LuckyMoneyAutoScrollItem EGg;
  LuckyMoneyAutoScrollItem EGh;
  LuckyMoneyAutoScrollItem EGi;
  private RelativeLayout EGj;
  private RelativeLayout EGk;
  private RelativeLayout EGl;
  ImageView EGm;
  ImageView EGn;
  ImageView EGo;
  private String EGp;
  private String EGq;
  private String EGr;
  private a EGs;
  private View contentView;
  boolean hasCallBack;
  private Context mContext;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65434);
    this.EGp = "0";
    this.EGq = "0";
    this.EGr = "0";
    this.hasCallBack = false;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(a.g.lucky_money_auto_scroll_view, this);
    this.contentView = paramContext;
    this.EGg = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_1));
    this.EGh = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_2));
    this.EGi = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_3));
    w.p(this.EGg, 2);
    w.p(this.EGh, 2);
    w.p(this.EGi, 2);
    this.EGj = ((RelativeLayout)paramContext.findViewById(a.f.amount_mask_1));
    this.EGk = ((RelativeLayout)paramContext.findViewById(a.f.amount_mask_2));
    this.EGl = ((RelativeLayout)paramContext.findViewById(a.f.amount_mask_3));
    this.EGm = ((ImageView)paramContext.findViewById(a.f.text_number));
    this.EGn = ((ImageView)paramContext.findViewById(a.f.text_number2));
    this.EGo = ((ImageView)paramContext.findViewById(a.f.text_number3));
    this.EGd = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_1));
    this.EGe = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_2));
    this.EGf = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_3));
    AppMethodBeat.o(65434);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(65436);
    this.EGs = parama;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65432);
        LuckyMoneyAutoScrollView.a(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.b(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.c(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.d(LuckyMoneyAutoScrollView.this).ePw();
        LuckyMoneyAutoScrollView.e(LuckyMoneyAutoScrollView.this).ePw();
        LuckyMoneyAutoScrollView.f(LuckyMoneyAutoScrollView.this).ePw();
        AppMethodBeat.o(65432);
      }
    });
    AppMethodBeat.o(65436);
  }
  
  public final void ePx()
  {
    AppMethodBeat.i(65438);
    if (!this.hasCallBack)
    {
      this.hasCallBack = true;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(65433);
          LuckyMoneyAutoScrollView.a(LuckyMoneyAutoScrollView.this).setVisibility(8);
          LuckyMoneyAutoScrollView.b(LuckyMoneyAutoScrollView.this).setVisibility(8);
          LuckyMoneyAutoScrollView.c(LuckyMoneyAutoScrollView.this).setVisibility(8);
          LuckyMoneyAutoScrollView.d(LuckyMoneyAutoScrollView.this).setVisibility(8);
          LuckyMoneyAutoScrollView.e(LuckyMoneyAutoScrollView.this).setVisibility(8);
          LuckyMoneyAutoScrollView.f(LuckyMoneyAutoScrollView.this).setVisibility(8);
          LuckyMoneyAutoScrollView.g(LuckyMoneyAutoScrollView.this).setVisibility(0);
          LuckyMoneyAutoScrollView.h(LuckyMoneyAutoScrollView.this).setVisibility(0);
          LuckyMoneyAutoScrollView.i(LuckyMoneyAutoScrollView.this).setVisibility(0);
          if (LuckyMoneyAutoScrollView.j(LuckyMoneyAutoScrollView.this) != null) {
            LuckyMoneyAutoScrollView.j(LuckyMoneyAutoScrollView.this).ePz();
          }
          AppMethodBeat.o(65433);
        }
      });
    }
    AppMethodBeat.o(65438);
  }
  
  public final void ePy()
  {
    AppMethodBeat.i(65437);
    this.EGg.setVisibility(8);
    this.EGh.setVisibility(8);
    this.EGi.setVisibility(8);
    this.EGm.setVisibility(0);
    this.EGn.setVisibility(0);
    this.EGo.setVisibility(0);
    AppMethodBeat.o(65437);
  }
  
  public final void ia(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65439);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.contentView.setLayoutParams(localLayoutParams);
      this.contentView.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.EGd.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.EGd.setLayoutParams(localLayoutParams);
      this.EGd.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.EGe.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.EGe.setLayoutParams(localLayoutParams);
      this.EGe.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.EGf.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = 0;
      this.EGf.setLayoutParams(localLayoutParams);
      this.EGf.invalidate();
    }
    AppMethodBeat.o(65439);
  }
  
  public void setFinalText(String paramString)
  {
    AppMethodBeat.i(65435);
    Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.EGp = paramString.substring(0, 1);
    this.EGq = paramString.substring(2, 3);
    this.EGr = paramString.substring(3, 4);
    this.EGg.setFinalNumber(Util.getInt(this.EGp, 0));
    this.EGh.setFinalNumber(Util.getInt(this.EGq, 0));
    this.EGi.setFinalNumber(Util.getInt(this.EGr, 0));
    this.EGm.setImageResource(((Integer)LuckyMoneyAutoScrollItem.EFX.get(Util.getInt(this.EGp, 0))).intValue());
    this.EGn.setImageResource(((Integer)LuckyMoneyAutoScrollItem.EFX.get(Util.getInt(this.EGq, 0))).intValue());
    this.EGo.setImageResource(((Integer)LuckyMoneyAutoScrollItem.EFX.get(Util.getInt(this.EGr, 0))).intValue());
    this.EGm.setVisibility(4);
    this.EGn.setVisibility(4);
    this.EGo.setVisibility(4);
    this.EGg.setOnScrollEndListener(this);
    this.EGh.setOnScrollEndListener(this);
    this.EGi.setOnScrollEndListener(this);
    Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.EGp, this.EGq, this.EGr });
    AppMethodBeat.o(65435);
  }
  
  public static abstract interface a
  {
    public abstract void ePz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */