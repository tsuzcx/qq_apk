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
  private RelativeLayout tjH;
  private RelativeLayout tjI;
  private RelativeLayout tjJ;
  LuckyMoneyAutoScrollItem tjK;
  LuckyMoneyAutoScrollItem tjL;
  LuckyMoneyAutoScrollItem tjM;
  private RelativeLayout tjN;
  private RelativeLayout tjO;
  private RelativeLayout tjP;
  ImageView tjQ;
  ImageView tjR;
  ImageView tjS;
  private String tjT;
  private String tjU;
  private String tjV;
  private a tjW;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65434);
    this.tjT = "0";
    this.tjU = "0";
    this.tjV = "0";
    this.hasCallBack = false;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131494627, this);
    this.contentView = paramContext;
    this.tjK = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296656));
    this.tjL = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296657));
    this.tjM = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296658));
    t.p(this.tjK, 2);
    t.p(this.tjL, 2);
    t.p(this.tjM, 2);
    this.tjN = ((RelativeLayout)paramContext.findViewById(2131296659));
    this.tjO = ((RelativeLayout)paramContext.findViewById(2131296660));
    this.tjP = ((RelativeLayout)paramContext.findViewById(2131296661));
    this.tjQ = ((ImageView)paramContext.findViewById(2131305736));
    this.tjR = ((ImageView)paramContext.findViewById(2131305737));
    this.tjS = ((ImageView)paramContext.findViewById(2131305738));
    this.tjH = ((RelativeLayout)paramContext.findViewById(2131301160));
    this.tjI = ((RelativeLayout)paramContext.findViewById(2131301161));
    this.tjJ = ((RelativeLayout)paramContext.findViewById(2131301162));
    AppMethodBeat.o(65434);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(65436);
    this.tjW = parama;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65432);
        LuckyMoneyAutoScrollView.a(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.b(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.c(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.d(LuckyMoneyAutoScrollView.this).cMi();
        LuckyMoneyAutoScrollView.e(LuckyMoneyAutoScrollView.this).cMi();
        LuckyMoneyAutoScrollView.f(LuckyMoneyAutoScrollView.this).cMi();
        AppMethodBeat.o(65432);
      }
    });
    AppMethodBeat.o(65436);
  }
  
  public final void bss()
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
            LuckyMoneyAutoScrollView.j(LuckyMoneyAutoScrollView.this).cMk();
          }
          AppMethodBeat.o(65433);
        }
      });
    }
    AppMethodBeat.o(65438);
  }
  
  public final void cMj()
  {
    AppMethodBeat.i(65437);
    this.tjK.setVisibility(8);
    this.tjL.setVisibility(8);
    this.tjM.setVisibility(8);
    this.tjQ.setVisibility(0);
    this.tjR.setVisibility(0);
    this.tjS.setVisibility(0);
    AppMethodBeat.o(65437);
  }
  
  public final void fZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65439);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.contentView.setLayoutParams(localLayoutParams);
      this.contentView.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.tjH.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.tjH.setLayoutParams(localLayoutParams);
      this.tjH.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.tjI.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.tjI.setLayoutParams(localLayoutParams);
      this.tjI.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.tjJ.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = 0;
      this.tjJ.setLayoutParams(localLayoutParams);
      this.tjJ.invalidate();
    }
    AppMethodBeat.o(65439);
  }
  
  public void setFinalText(String paramString)
  {
    AppMethodBeat.i(65435);
    ad.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.tjT = paramString.substring(0, 1);
    this.tjU = paramString.substring(2, 3);
    this.tjV = paramString.substring(3, 4);
    this.tjK.setFinalNumber(bt.getInt(this.tjT, 0));
    this.tjL.setFinalNumber(bt.getInt(this.tjU, 0));
    this.tjM.setFinalNumber(bt.getInt(this.tjV, 0));
    this.tjQ.setImageResource(((Integer)LuckyMoneyAutoScrollItem.tjB.get(bt.getInt(this.tjT, 0))).intValue());
    this.tjR.setImageResource(((Integer)LuckyMoneyAutoScrollItem.tjB.get(bt.getInt(this.tjU, 0))).intValue());
    this.tjS.setImageResource(((Integer)LuckyMoneyAutoScrollItem.tjB.get(bt.getInt(this.tjV, 0))).intValue());
    this.tjQ.setVisibility(4);
    this.tjR.setVisibility(4);
    this.tjS.setVisibility(4);
    this.tjK.setOnScrollEndListener(this);
    this.tjL.setOnScrollEndListener(this);
    this.tjM.setOnScrollEndListener(this);
    ad.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.tjT, this.tjU, this.tjV });
    AppMethodBeat.o(65435);
  }
  
  public static abstract interface a
  {
    public abstract void cMk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */