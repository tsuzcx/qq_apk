package com.tencent.mm.plugin.ball.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.ball.d.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.CircleAnimateView;
import com.tencent.mm.plugin.ball.view.CircleImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private static final int mCE;
  private static final int mCF;
  private static final int mCG;
  private static final int mCH;
  private static final int mCI;
  private static final int mCJ;
  private static final int mCK;
  private static final int mCL;
  private static final int mCM;
  private static final int mCN;
  private static final int mCO;
  private static final int mCP;
  private static final int mCQ;
  private static final int mCR;
  private static final int mCS;
  public boolean mCA;
  public boolean mCB;
  public List<BallInfo> mCC;
  public c mCD;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(106029);
    mCE = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166382);
    mCF = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166364);
    mCG = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166383);
    mCH = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166365);
    mCI = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166379);
    mCJ = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166380);
    mCK = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166378);
    mCL = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166372);
    mCM = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166374);
    mCN = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166368);
    mCO = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166370);
    mCP = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166373);
    mCQ = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166375);
    mCR = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166369);
    mCS = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166371);
    AppMethodBeat.o(106029);
  }
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static void a(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(106024);
    if (!bt.isNullOrNil(paramString))
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
      if (t.av(aj.getContext(), paramInt)) {
        if (parama.mDh != paramInt)
        {
          parama.mCY.setVisibility(8);
          parama.mCZ.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        parama.mCZ.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L)
        {
          parama.mCZ.setProgress(paramBallInfo.progress);
          parama.mDh = paramInt;
          AppMethodBeat.o(106025);
          return;
        }
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException1, "setIconAnimateView exception:%s", new Object[] { localException1 });
        i = com.tencent.mm.plugin.ball.f.d.wG(paramBallInfo.state);
        parama.mCZ.setImageResource(i);
        continue;
        parama.mCZ.setProgress(-2147483648L);
        continue;
      }
      if (parama.mDh != paramInt)
      {
        parama.mCZ.setVisibility(8);
        parama.mCY.setVisibility(0);
      }
      try
      {
        parama.mCY.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L) {
          parama.mCY.setProgress(paramBallInfo.progress);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException2, "setIconImageView exception:%s", new Object[] { localException2 });
          i = com.tencent.mm.plugin.ball.f.d.wF(paramBallInfo.type);
          parama.mCY.setImageResource(i);
          paramBallInfo.kYl = i;
        }
        parama.mCY.setProgress(-2147483648L);
      }
      continue;
      parama.mCY.setVisibility(4);
      parama.mCZ.setVisibility(4);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(106022);
    if (com.tencent.mm.plugin.ball.f.d.h(this.mCC))
    {
      int i = this.mCC.size();
      AppMethodBeat.o(106022);
      return i;
    }
    AppMethodBeat.o(106022);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106023);
    if ((com.tencent.mm.plugin.ball.f.d.h(this.mCC)) && (paramInt >= 0) && (paramInt < this.mCC.size()))
    {
      if (((BallInfo)this.mCC.get(paramInt)).mDu)
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
    extends RecyclerView.v
  {
    public CircleImageView mCY;
    public CircleAnimateView mCZ;
    public ImageView mDa;
    public FrameLayout mDc;
    public TextView mDd;
    public TextView mDe;
    public LinearLayout mDf;
    public ImageView mDg;
    public int mDh;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(106021);
      this.mDh = -1;
      this.mCY = ((CircleImageView)paramView.findViewById(2131300881));
      this.mCZ = ((CircleAnimateView)paramView.findViewById(2131300879));
      this.mDa = ((ImageView)paramView.findViewById(2131304078));
      this.mDc = ((FrameLayout)paramView.findViewById(2131304077));
      this.mDd = ((TextView)paramView.findViewById(2131302658));
      this.mDe = ((TextView)paramView.findViewById(2131302657));
      this.mDf = ((LinearLayout)paramView.findViewById(2131302655));
      this.mDg = ((ImageView)paramView.findViewById(2131296938));
      AppMethodBeat.o(106021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.a
 * JD-Core Version:    0.7.0.1
 */