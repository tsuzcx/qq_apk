package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class LuckyMoneyAutoScrollView
  extends RelativeLayout
  implements LuckyMoneyAutoScrollItem.b
{
  private String KzA;
  private a KzB;
  private RelativeLayout Kzm;
  private RelativeLayout Kzn;
  private RelativeLayout Kzo;
  private LuckyMoneyAutoScrollItem Kzp;
  private LuckyMoneyAutoScrollItem Kzq;
  private LuckyMoneyAutoScrollItem Kzr;
  private RelativeLayout Kzs;
  private RelativeLayout Kzt;
  private RelativeLayout Kzu;
  private ImageView Kzv;
  private ImageView Kzw;
  private ImageView Kzx;
  private String Kzy;
  private String Kzz;
  private View contentView;
  private boolean hasCallBack;
  private Context mContext;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65434);
    this.Kzy = "0";
    this.Kzz = "0";
    this.KzA = "0";
    this.hasCallBack = false;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(a.g.lucky_money_auto_scroll_view, this);
    this.contentView = paramContext;
    this.Kzp = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_1));
    this.Kzq = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_2));
    this.Kzr = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(a.f.amount_3));
    z.p(this.Kzp, 2);
    z.p(this.Kzq, 2);
    z.p(this.Kzr, 2);
    this.Kzs = ((RelativeLayout)paramContext.findViewById(a.f.amount_mask_1));
    this.Kzt = ((RelativeLayout)paramContext.findViewById(a.f.amount_mask_2));
    this.Kzu = ((RelativeLayout)paramContext.findViewById(a.f.amount_mask_3));
    this.Kzv = ((ImageView)paramContext.findViewById(a.f.text_number));
    this.Kzw = ((ImageView)paramContext.findViewById(a.f.text_number2));
    this.Kzx = ((ImageView)paramContext.findViewById(a.f.text_number3));
    this.Kzm = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_1));
    this.Kzn = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_2));
    this.Kzo = ((RelativeLayout)paramContext.findViewById(a.f.item_layout_3));
    AppMethodBeat.o(65434);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(65436);
    this.KzB = parama;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65432);
        LuckyMoneyAutoScrollView.a(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.b(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.c(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.d(LuckyMoneyAutoScrollView.this).fYa();
        LuckyMoneyAutoScrollView.e(LuckyMoneyAutoScrollView.this).fYa();
        LuckyMoneyAutoScrollView.f(LuckyMoneyAutoScrollView.this).fYa();
        AppMethodBeat.o(65432);
      }
    });
    AppMethodBeat.o(65436);
  }
  
  public final void fYb()
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
            LuckyMoneyAutoScrollView.j(LuckyMoneyAutoScrollView.this).fYe();
          }
          AppMethodBeat.o(65433);
        }
      });
    }
    AppMethodBeat.o(65438);
  }
  
  public final void fYc()
  {
    AppMethodBeat.i(65437);
    this.Kzp.setVisibility(8);
    this.Kzq.setVisibility(8);
    this.Kzr.setVisibility(8);
    this.Kzv.setVisibility(0);
    this.Kzw.setVisibility(0);
    this.Kzx.setVisibility(0);
    AppMethodBeat.o(65437);
  }
  
  public final void fYd()
  {
    AppMethodBeat.i(284401);
    this.hasCallBack = false;
    this.Kzp.setVisibility(0);
    this.Kzq.setVisibility(0);
    this.Kzr.setVisibility(0);
    this.Kzv.setVisibility(4);
    this.Kzw.setVisibility(4);
    this.Kzx.setVisibility(4);
    AppMethodBeat.o(284401);
  }
  
  public final void jF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65439);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.contentView.setLayoutParams(localLayoutParams);
      this.contentView.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.Kzm.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.Kzm.setLayoutParams(localLayoutParams);
      this.Kzm.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.Kzn.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.Kzn.setLayoutParams(localLayoutParams);
      this.Kzn.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.Kzo.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = a.fromDPToPix(getContext(), 3);
      this.Kzo.setLayoutParams(localLayoutParams);
      this.Kzo.invalidate();
    }
    AppMethodBeat.o(65439);
  }
  
  public void setFinalText(String paramString)
  {
    AppMethodBeat.i(65435);
    Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.Kzy = paramString.substring(0, 1);
    this.Kzz = paramString.substring(2, 3);
    this.KzA = paramString.substring(3, 4);
    this.Kzp.setFinalNumber(Util.getInt(this.Kzy, 0));
    this.Kzq.setFinalNumber(Util.getInt(this.Kzz, 0));
    this.Kzr.setFinalNumber(Util.getInt(this.KzA, 0));
    this.Kzv.setImageResource(((Integer)LuckyMoneyAutoScrollItem.Kzg.get(Util.getInt(this.Kzy, 0))).intValue());
    this.Kzw.setImageResource(((Integer)LuckyMoneyAutoScrollItem.Kzg.get(Util.getInt(this.Kzz, 0))).intValue());
    this.Kzx.setImageResource(((Integer)LuckyMoneyAutoScrollItem.Kzg.get(Util.getInt(this.KzA, 0))).intValue());
    this.Kzv.setVisibility(4);
    this.Kzw.setVisibility(4);
    this.Kzx.setVisibility(4);
    this.Kzp.setOnScrollEndListener(this);
    this.Kzq.setOnScrollEndListener(this);
    this.Kzr.setOnScrollEndListener(this);
    Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.Kzy, this.Kzz, this.KzA });
    AppMethodBeat.o(65435);
  }
  
  public static abstract interface a
  {
    public abstract void fYe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */