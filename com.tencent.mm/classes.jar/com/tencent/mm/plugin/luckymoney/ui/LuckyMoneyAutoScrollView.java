package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class LuckyMoneyAutoScrollView
  extends RelativeLayout
  implements LuckyMoneyAutoScrollItem.b
{
  private View contentView;
  boolean hasCallBack;
  private Context mContext;
  private RelativeLayout zbG;
  private RelativeLayout zbH;
  private RelativeLayout zbI;
  LuckyMoneyAutoScrollItem zbJ;
  LuckyMoneyAutoScrollItem zbK;
  LuckyMoneyAutoScrollItem zbL;
  private RelativeLayout zbM;
  private RelativeLayout zbN;
  private RelativeLayout zbO;
  ImageView zbP;
  ImageView zbQ;
  ImageView zbR;
  private String zbS;
  private String zbT;
  private String zbU;
  private a zbV;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65434);
    this.zbS = "0";
    this.zbT = "0";
    this.zbU = "0";
    this.hasCallBack = false;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131495349, this);
    this.contentView = paramContext;
    this.zbJ = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296733));
    this.zbK = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296734));
    this.zbL = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296735));
    u.p(this.zbJ, 2);
    u.p(this.zbK, 2);
    u.p(this.zbL, 2);
    this.zbM = ((RelativeLayout)paramContext.findViewById(2131296736));
    this.zbN = ((RelativeLayout)paramContext.findViewById(2131296737));
    this.zbO = ((RelativeLayout)paramContext.findViewById(2131296738));
    this.zbP = ((ImageView)paramContext.findViewById(2131309003));
    this.zbQ = ((ImageView)paramContext.findViewById(2131309004));
    this.zbR = ((ImageView)paramContext.findViewById(2131309005));
    this.zbG = ((RelativeLayout)paramContext.findViewById(2131302820));
    this.zbH = ((RelativeLayout)paramContext.findViewById(2131302821));
    this.zbI = ((RelativeLayout)paramContext.findViewById(2131302822));
    AppMethodBeat.o(65434);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(65436);
    this.zbV = parama;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65432);
        LuckyMoneyAutoScrollView.a(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.b(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.c(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.d(LuckyMoneyAutoScrollView.this).efV();
        LuckyMoneyAutoScrollView.e(LuckyMoneyAutoScrollView.this).efV();
        LuckyMoneyAutoScrollView.f(LuckyMoneyAutoScrollView.this).efV();
        AppMethodBeat.o(65432);
      }
    });
    AppMethodBeat.o(65436);
  }
  
  public final void efW()
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
            LuckyMoneyAutoScrollView.j(LuckyMoneyAutoScrollView.this).efY();
          }
          AppMethodBeat.o(65433);
        }
      });
    }
    AppMethodBeat.o(65438);
  }
  
  public final void efX()
  {
    AppMethodBeat.i(65437);
    this.zbJ.setVisibility(8);
    this.zbK.setVisibility(8);
    this.zbL.setVisibility(8);
    this.zbP.setVisibility(0);
    this.zbQ.setVisibility(0);
    this.zbR.setVisibility(0);
    AppMethodBeat.o(65437);
  }
  
  public final void gV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65439);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.contentView.setLayoutParams(localLayoutParams);
      this.contentView.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.zbG.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.zbG.setLayoutParams(localLayoutParams);
      this.zbG.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.zbH.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.zbH.setLayoutParams(localLayoutParams);
      this.zbH.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.zbI.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = 0;
      this.zbI.setLayoutParams(localLayoutParams);
      this.zbI.invalidate();
    }
    AppMethodBeat.o(65439);
  }
  
  public void setFinalText(String paramString)
  {
    AppMethodBeat.i(65435);
    Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.zbS = paramString.substring(0, 1);
    this.zbT = paramString.substring(2, 3);
    this.zbU = paramString.substring(3, 4);
    this.zbJ.setFinalNumber(Util.getInt(this.zbS, 0));
    this.zbK.setFinalNumber(Util.getInt(this.zbT, 0));
    this.zbL.setFinalNumber(Util.getInt(this.zbU, 0));
    this.zbP.setImageResource(((Integer)LuckyMoneyAutoScrollItem.zbA.get(Util.getInt(this.zbS, 0))).intValue());
    this.zbQ.setImageResource(((Integer)LuckyMoneyAutoScrollItem.zbA.get(Util.getInt(this.zbT, 0))).intValue());
    this.zbR.setImageResource(((Integer)LuckyMoneyAutoScrollItem.zbA.get(Util.getInt(this.zbU, 0))).intValue());
    this.zbP.setVisibility(4);
    this.zbQ.setVisibility(4);
    this.zbR.setVisibility(4);
    this.zbJ.setOnScrollEndListener(this);
    this.zbK.setOnScrollEndListener(this);
    this.zbL.setOnScrollEndListener(this);
    Log.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.zbS, this.zbT, this.zbU });
    AppMethodBeat.o(65435);
  }
  
  public static abstract interface a
  {
    public abstract void efY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */