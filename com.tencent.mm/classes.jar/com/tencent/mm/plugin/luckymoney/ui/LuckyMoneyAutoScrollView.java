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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class LuckyMoneyAutoScrollView
  extends RelativeLayout
  implements LuckyMoneyAutoScrollItem.b
{
  private View contentView;
  boolean hasCallBack;
  private Context mContext;
  private RelativeLayout vuD;
  private RelativeLayout vuE;
  private RelativeLayout vuF;
  LuckyMoneyAutoScrollItem vuG;
  LuckyMoneyAutoScrollItem vuH;
  LuckyMoneyAutoScrollItem vuI;
  private RelativeLayout vuJ;
  private RelativeLayout vuK;
  private RelativeLayout vuL;
  ImageView vuM;
  ImageView vuN;
  ImageView vuO;
  private String vuP;
  private String vuQ;
  private String vuR;
  private a vuS;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65434);
    this.vuP = "0";
    this.vuQ = "0";
    this.vuR = "0";
    this.hasCallBack = false;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131494627, this);
    this.contentView = paramContext;
    this.vuG = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296656));
    this.vuH = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296657));
    this.vuI = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296658));
    t.p(this.vuG, 2);
    t.p(this.vuH, 2);
    t.p(this.vuI, 2);
    this.vuJ = ((RelativeLayout)paramContext.findViewById(2131296659));
    this.vuK = ((RelativeLayout)paramContext.findViewById(2131296660));
    this.vuL = ((RelativeLayout)paramContext.findViewById(2131296661));
    this.vuM = ((ImageView)paramContext.findViewById(2131305736));
    this.vuN = ((ImageView)paramContext.findViewById(2131305737));
    this.vuO = ((ImageView)paramContext.findViewById(2131305738));
    this.vuD = ((RelativeLayout)paramContext.findViewById(2131301160));
    this.vuE = ((RelativeLayout)paramContext.findViewById(2131301161));
    this.vuF = ((RelativeLayout)paramContext.findViewById(2131301162));
    AppMethodBeat.o(65434);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(65436);
    this.vuS = parama;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65432);
        LuckyMoneyAutoScrollView.a(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.b(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.c(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.d(LuckyMoneyAutoScrollView.this).djb();
        LuckyMoneyAutoScrollView.e(LuckyMoneyAutoScrollView.this).djb();
        LuckyMoneyAutoScrollView.f(LuckyMoneyAutoScrollView.this).djb();
        AppMethodBeat.o(65432);
      }
    });
    AppMethodBeat.o(65436);
  }
  
  public final void bDw()
  {
    AppMethodBeat.i(65438);
    if (!this.hasCallBack)
    {
      this.hasCallBack = true;
      aq.f(new Runnable()
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
            LuckyMoneyAutoScrollView.j(LuckyMoneyAutoScrollView.this).djd();
          }
          AppMethodBeat.o(65433);
        }
      });
    }
    AppMethodBeat.o(65438);
  }
  
  public final void djc()
  {
    AppMethodBeat.i(65437);
    this.vuG.setVisibility(8);
    this.vuH.setVisibility(8);
    this.vuI.setVisibility(8);
    this.vuM.setVisibility(0);
    this.vuN.setVisibility(0);
    this.vuO.setVisibility(0);
    AppMethodBeat.o(65437);
  }
  
  public final void gx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65439);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.contentView.setLayoutParams(localLayoutParams);
      this.contentView.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.vuD.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.vuD.setLayoutParams(localLayoutParams);
      this.vuD.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.vuE.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.vuE.setLayoutParams(localLayoutParams);
      this.vuE.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.vuF.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = 0;
      this.vuF.setLayoutParams(localLayoutParams);
      this.vuF.invalidate();
    }
    AppMethodBeat.o(65439);
  }
  
  public void setFinalText(String paramString)
  {
    AppMethodBeat.i(65435);
    ad.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.vuP = paramString.substring(0, 1);
    this.vuQ = paramString.substring(2, 3);
    this.vuR = paramString.substring(3, 4);
    this.vuG.setFinalNumber(bt.getInt(this.vuP, 0));
    this.vuH.setFinalNumber(bt.getInt(this.vuQ, 0));
    this.vuI.setFinalNumber(bt.getInt(this.vuR, 0));
    this.vuM.setImageResource(((Integer)LuckyMoneyAutoScrollItem.vux.get(bt.getInt(this.vuP, 0))).intValue());
    this.vuN.setImageResource(((Integer)LuckyMoneyAutoScrollItem.vux.get(bt.getInt(this.vuQ, 0))).intValue());
    this.vuO.setImageResource(((Integer)LuckyMoneyAutoScrollItem.vux.get(bt.getInt(this.vuR, 0))).intValue());
    this.vuM.setVisibility(4);
    this.vuN.setVisibility(4);
    this.vuO.setVisibility(4);
    this.vuG.setOnScrollEndListener(this);
    this.vuH.setOnScrollEndListener(this);
    this.vuI.setOnScrollEndListener(this);
    ad.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.vuP, this.vuQ, this.vuR });
    AppMethodBeat.o(65435);
  }
  
  public static abstract interface a
  {
    public abstract void djd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */