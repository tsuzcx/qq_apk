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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public class LuckyMoneyAutoScrollView
  extends RelativeLayout
  implements LuckyMoneyAutoScrollItem.b
{
  private View contentView;
  boolean hasCallBack;
  private Context mContext;
  private RelativeLayout vGH;
  private RelativeLayout vGI;
  private RelativeLayout vGJ;
  LuckyMoneyAutoScrollItem vGK;
  LuckyMoneyAutoScrollItem vGL;
  LuckyMoneyAutoScrollItem vGM;
  private RelativeLayout vGN;
  private RelativeLayout vGO;
  private RelativeLayout vGP;
  ImageView vGQ;
  ImageView vGR;
  ImageView vGS;
  private String vGT;
  private String vGU;
  private String vGV;
  private a vGW;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65434);
    this.vGT = "0";
    this.vGU = "0";
    this.vGV = "0";
    this.hasCallBack = false;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131494627, this);
    this.contentView = paramContext;
    this.vGK = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296656));
    this.vGL = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296657));
    this.vGM = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296658));
    t.p(this.vGK, 2);
    t.p(this.vGL, 2);
    t.p(this.vGM, 2);
    this.vGN = ((RelativeLayout)paramContext.findViewById(2131296659));
    this.vGO = ((RelativeLayout)paramContext.findViewById(2131296660));
    this.vGP = ((RelativeLayout)paramContext.findViewById(2131296661));
    this.vGQ = ((ImageView)paramContext.findViewById(2131305736));
    this.vGR = ((ImageView)paramContext.findViewById(2131305737));
    this.vGS = ((ImageView)paramContext.findViewById(2131305738));
    this.vGH = ((RelativeLayout)paramContext.findViewById(2131301160));
    this.vGI = ((RelativeLayout)paramContext.findViewById(2131301161));
    this.vGJ = ((RelativeLayout)paramContext.findViewById(2131301162));
    AppMethodBeat.o(65434);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(65436);
    this.vGW = parama;
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65432);
        LuckyMoneyAutoScrollView.a(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.b(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.c(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.d(LuckyMoneyAutoScrollView.this).dma();
        LuckyMoneyAutoScrollView.e(LuckyMoneyAutoScrollView.this).dma();
        LuckyMoneyAutoScrollView.f(LuckyMoneyAutoScrollView.this).dma();
        AppMethodBeat.o(65432);
      }
    });
    AppMethodBeat.o(65436);
  }
  
  public final void bEo()
  {
    AppMethodBeat.i(65438);
    if (!this.hasCallBack)
    {
      this.hasCallBack = true;
      ar.f(new Runnable()
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
            LuckyMoneyAutoScrollView.j(LuckyMoneyAutoScrollView.this).dmc();
          }
          AppMethodBeat.o(65433);
        }
      });
    }
    AppMethodBeat.o(65438);
  }
  
  public final void dmb()
  {
    AppMethodBeat.i(65437);
    this.vGK.setVisibility(8);
    this.vGL.setVisibility(8);
    this.vGM.setVisibility(8);
    this.vGQ.setVisibility(0);
    this.vGR.setVisibility(0);
    this.vGS.setVisibility(0);
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
      localLayoutParams = (LinearLayout.LayoutParams)this.vGH.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.vGH.setLayoutParams(localLayoutParams);
      this.vGH.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.vGI.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.vGI.setLayoutParams(localLayoutParams);
      this.vGI.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.vGJ.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = 0;
      this.vGJ.setLayoutParams(localLayoutParams);
      this.vGJ.invalidate();
    }
    AppMethodBeat.o(65439);
  }
  
  public void setFinalText(String paramString)
  {
    AppMethodBeat.i(65435);
    ae.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.vGT = paramString.substring(0, 1);
    this.vGU = paramString.substring(2, 3);
    this.vGV = paramString.substring(3, 4);
    this.vGK.setFinalNumber(bu.getInt(this.vGT, 0));
    this.vGL.setFinalNumber(bu.getInt(this.vGU, 0));
    this.vGM.setFinalNumber(bu.getInt(this.vGV, 0));
    this.vGQ.setImageResource(((Integer)LuckyMoneyAutoScrollItem.vGB.get(bu.getInt(this.vGT, 0))).intValue());
    this.vGR.setImageResource(((Integer)LuckyMoneyAutoScrollItem.vGB.get(bu.getInt(this.vGU, 0))).intValue());
    this.vGS.setImageResource(((Integer)LuckyMoneyAutoScrollItem.vGB.get(bu.getInt(this.vGV, 0))).intValue());
    this.vGQ.setVisibility(4);
    this.vGR.setVisibility(4);
    this.vGS.setVisibility(4);
    this.vGK.setOnScrollEndListener(this);
    this.vGL.setOnScrollEndListener(this);
    this.vGM.setOnScrollEndListener(this);
    ae.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.vGT, this.vGU, this.vGV });
    AppMethodBeat.o(65435);
  }
  
  public static abstract interface a
  {
    public abstract void dmc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */