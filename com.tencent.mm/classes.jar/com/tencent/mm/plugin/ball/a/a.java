package com.tencent.mm.plugin.ball.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.CircleAnimateView;
import com.tencent.mm.plugin.ball.view.CircleImageView;
import com.tencent.mm.plugin.ball.view.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private static final int nKA;
  private static final int nKB;
  private static final int nKC;
  private static final int nKD;
  private static final int nKE;
  private static final int nKF;
  private static final int nKG;
  private static final int nKH;
  private static final int nKI;
  private static final int nKJ;
  private static final int nKK;
  private static final int nKL;
  private static final int nKM;
  private static final int nKN;
  private static final int nKz;
  private Context mContext;
  public boolean nKt;
  public boolean nKu;
  public List<BallInfo> nKv;
  public com.tencent.mm.plugin.ball.d.b nKw;
  public boolean nKx;
  public d.b nKy;
  
  static
  {
    AppMethodBeat.i(106029);
    nKz = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166382);
    nKA = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166364);
    nKB = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166383);
    nKC = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166365);
    nKD = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166379);
    nKE = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166380);
    nKF = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166378);
    nKG = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166372);
    nKH = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166374);
    nKI = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166368);
    nKJ = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166370);
    nKK = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166373);
    nKL = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166375);
    nKM = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166369);
    nKN = com.tencent.mm.cb.a.ay(ak.getContext(), 2131166371);
    AppMethodBeat.o(106029);
  }
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static void a(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(106024);
    if (!bu.isNullOrNil(paramString))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(Html.fromHtml(paramString));
      AppMethodBeat.o(106024);
      return;
    }
    paramTextView.setText("");
    paramTextView.setVisibility(8);
    AppMethodBeat.o(106024);
  }
  
  private static void a(a parama, int paramInt, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106025);
    if (paramInt != -1) {
      if (u.aE(ak.getContext(), paramInt)) {
        if (parama.nLe != paramInt)
        {
          parama.nKU.setVisibility(8);
          parama.nKV.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        parama.nKV.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L)
        {
          parama.nKV.setProgress(paramBallInfo.progress);
          parama.nLe = paramInt;
          AppMethodBeat.o(106025);
          return;
        }
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException1, "setIconAnimateView exception:%s", new Object[] { localException1 });
        i = com.tencent.mm.plugin.ball.f.d.yg(paramBallInfo.state);
        parama.nKV.setImageResource(i);
        continue;
        parama.nKV.setProgress(-2147483648L);
        continue;
      }
      if (parama.nLe != paramInt)
      {
        parama.nKV.setVisibility(8);
        parama.nKU.setVisibility(0);
      }
      try
      {
        parama.nKU.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L) {
          parama.nKU.setProgress(paramBallInfo.progress);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException2, "setIconImageView exception:%s", new Object[] { localException2 });
          i = com.tencent.mm.plugin.ball.f.d.yf(paramBallInfo.type);
          parama.nKU.setImageResource(i);
          paramBallInfo.mdM = i;
        }
        parama.nKU.setProgress(-2147483648L);
      }
      continue;
      parama.nKU.setVisibility(4);
      parama.nKV.setVisibility(4);
    }
  }
  
  private boolean xV(int paramInt)
  {
    AppMethodBeat.i(209426);
    if ((paramInt >= 0) && (paramInt < this.nKv.size()))
    {
      AppMethodBeat.o(209426);
      return true;
    }
    AppMethodBeat.o(209426);
    return false;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(106022);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nKv))
    {
      int i = this.nKv.size();
      AppMethodBeat.o(106022);
      return i;
    }
    AppMethodBeat.o(106022);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106023);
    if ((com.tencent.mm.plugin.ball.f.d.h(this.nKv)) && (paramInt >= 0) && (paramInt < this.nKv.size()))
    {
      if (((BallInfo)this.nKv.get(paramInt)).nLu)
      {
        AppMethodBeat.o(106023);
        return 2;
      }
      AppMethodBeat.o(106023);
      return 1;
    }
    AppMethodBeat.o(106023);
    return 1;
  }
  
  public final class a
    extends RecyclerView.w
  {
    public BallInfo nKT;
    public CircleImageView nKU;
    public CircleAnimateView nKV;
    public ImageView nKW;
    public FrameLayout nKX;
    public TextView nKY;
    public TextView nKZ;
    public LinearLayout nLa;
    public ImageView nLb;
    public LinearLayout nLc;
    public LinearLayout nLd;
    public int nLe;
    public int position;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(106021);
      this.nLe = -1;
      this.nKU = ((CircleImageView)paramView.findViewById(2131300881));
      this.nKV = ((CircleAnimateView)paramView.findViewById(2131300879));
      this.nKW = ((ImageView)paramView.findViewById(2131304078));
      this.nKX = ((FrameLayout)paramView.findViewById(2131304077));
      this.nKY = ((TextView)paramView.findViewById(2131302658));
      this.nKZ = ((TextView)paramView.findViewById(2131302657));
      this.nLa = ((LinearLayout)paramView.findViewById(2131302655));
      this.nLb = ((ImageView)paramView.findViewById(2131296938));
      this.nLc = ((LinearLayout)paramView.findViewById(2131307865));
      this.nLd = ((LinearLayout)paramView.findViewById(2131307866));
      AppMethodBeat.o(106021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.a
 * JD-Core Version:    0.7.0.1
 */