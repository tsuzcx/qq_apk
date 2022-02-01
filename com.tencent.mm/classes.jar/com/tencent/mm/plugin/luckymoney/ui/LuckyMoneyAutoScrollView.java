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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public class LuckyMoneyAutoScrollView
  extends RelativeLayout
  implements LuckyMoneyAutoScrollItem.b
{
  private View contentView;
  boolean hasCallBack;
  private Context mContext;
  private RelativeLayout usa;
  private RelativeLayout usb;
  private RelativeLayout usc;
  LuckyMoneyAutoScrollItem usd;
  LuckyMoneyAutoScrollItem use;
  LuckyMoneyAutoScrollItem usf;
  private RelativeLayout usg;
  private RelativeLayout ush;
  private RelativeLayout usi;
  ImageView usj;
  ImageView usk;
  ImageView usl;
  private String usm;
  private String usn;
  private String uso;
  private a usp;
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LuckyMoneyAutoScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65434);
    this.usm = "0";
    this.usn = "0";
    this.uso = "0";
    this.hasCallBack = false;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131494627, this);
    this.contentView = paramContext;
    this.usd = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296656));
    this.use = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296657));
    this.usf = ((LuckyMoneyAutoScrollItem)paramContext.findViewById(2131296658));
    t.p(this.usd, 2);
    t.p(this.use, 2);
    t.p(this.usf, 2);
    this.usg = ((RelativeLayout)paramContext.findViewById(2131296659));
    this.ush = ((RelativeLayout)paramContext.findViewById(2131296660));
    this.usi = ((RelativeLayout)paramContext.findViewById(2131296661));
    this.usj = ((ImageView)paramContext.findViewById(2131305736));
    this.usk = ((ImageView)paramContext.findViewById(2131305737));
    this.usl = ((ImageView)paramContext.findViewById(2131305738));
    this.usa = ((RelativeLayout)paramContext.findViewById(2131301160));
    this.usb = ((RelativeLayout)paramContext.findViewById(2131301161));
    this.usc = ((RelativeLayout)paramContext.findViewById(2131301162));
    AppMethodBeat.o(65434);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(65436);
    this.usp = parama;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65432);
        LuckyMoneyAutoScrollView.a(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.b(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.c(LuckyMoneyAutoScrollView.this).setVisibility(0);
        LuckyMoneyAutoScrollView.d(LuckyMoneyAutoScrollView.this).cZO();
        LuckyMoneyAutoScrollView.e(LuckyMoneyAutoScrollView.this).cZO();
        LuckyMoneyAutoScrollView.f(LuckyMoneyAutoScrollView.this).cZO();
        AppMethodBeat.o(65432);
      }
    });
    AppMethodBeat.o(65436);
  }
  
  public final void bzs()
  {
    AppMethodBeat.i(65438);
    if (!this.hasCallBack)
    {
      this.hasCallBack = true;
      ap.f(new Runnable()
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
            LuckyMoneyAutoScrollView.j(LuckyMoneyAutoScrollView.this).cZQ();
          }
          AppMethodBeat.o(65433);
        }
      });
    }
    AppMethodBeat.o(65438);
  }
  
  public final void cZP()
  {
    AppMethodBeat.i(65437);
    this.usd.setVisibility(8);
    this.use.setVisibility(8);
    this.usf.setVisibility(8);
    this.usj.setVisibility(0);
    this.usk.setVisibility(0);
    this.usl.setVisibility(0);
    AppMethodBeat.o(65437);
  }
  
  public final void gg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65439);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      localLayoutParams.height = paramInt2;
      this.contentView.setLayoutParams(localLayoutParams);
      this.contentView.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.usa.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.usa.setLayoutParams(localLayoutParams);
      this.usa.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.usb.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      this.usb.setLayoutParams(localLayoutParams);
      this.usb.invalidate();
      localLayoutParams = (LinearLayout.LayoutParams)this.usc.getLayoutParams();
      localLayoutParams.height = paramInt2;
      localLayoutParams.width = paramInt1;
      localLayoutParams.leftMargin = 0;
      this.usc.setLayoutParams(localLayoutParams);
      this.usc.invalidate();
    }
    AppMethodBeat.o(65439);
  }
  
  public void setFinalText(String paramString)
  {
    AppMethodBeat.i(65435);
    ac.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[] { paramString });
    this.usm = paramString.substring(0, 1);
    this.usn = paramString.substring(2, 3);
    this.uso = paramString.substring(3, 4);
    this.usd.setFinalNumber(bs.getInt(this.usm, 0));
    this.use.setFinalNumber(bs.getInt(this.usn, 0));
    this.usf.setFinalNumber(bs.getInt(this.uso, 0));
    this.usj.setImageResource(((Integer)LuckyMoneyAutoScrollItem.urU.get(bs.getInt(this.usm, 0))).intValue());
    this.usk.setImageResource(((Integer)LuckyMoneyAutoScrollItem.urU.get(bs.getInt(this.usn, 0))).intValue());
    this.usl.setImageResource(((Integer)LuckyMoneyAutoScrollItem.urU.get(bs.getInt(this.uso, 0))).intValue());
    this.usj.setVisibility(4);
    this.usk.setVisibility(4);
    this.usl.setVisibility(4);
    this.usd.setOnScrollEndListener(this);
    this.use.setOnScrollEndListener(this);
    this.usf.setOnScrollEndListener(this);
    ac.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[] { this.usm, this.usn, this.uso });
    AppMethodBeat.o(65435);
  }
  
  public static abstract interface a
  {
    public abstract void cZQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView
 * JD-Core Version:    0.7.0.1
 */