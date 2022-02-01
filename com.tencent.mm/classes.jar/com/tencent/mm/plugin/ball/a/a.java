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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.ball.d.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.CircleAnimateView;
import com.tencent.mm.plugin.ball.view.CircleImageView;
import com.tencent.mm.plugin.ball.view.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private static final int nFe;
  private static final int nFf;
  private static final int nFg;
  private static final int nFh;
  private static final int nFi;
  private static final int nFj;
  private static final int nFk;
  private static final int nFl;
  private static final int nFm;
  private static final int nFn;
  private static final int nFo;
  private static final int nFp;
  private static final int nFq;
  private static final int nFr;
  private static final int nFs;
  private Context mContext;
  public boolean nEY;
  public boolean nEZ;
  public List<BallInfo> nFa;
  public c nFb;
  public boolean nFc;
  public d.b nFd;
  
  static
  {
    AppMethodBeat.i(106029);
    nFe = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166382);
    nFf = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166364);
    nFg = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166383);
    nFh = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166365);
    nFi = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166379);
    nFj = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166380);
    nFk = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166378);
    nFl = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166372);
    nFm = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166374);
    nFn = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166368);
    nFo = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166370);
    nFp = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166373);
    nFq = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166375);
    nFr = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166369);
    nFs = com.tencent.mm.cc.a.ay(aj.getContext(), 2131166371);
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
      if (t.aE(aj.getContext(), paramInt)) {
        if (parama.nFJ != paramInt)
        {
          parama.nFz.setVisibility(8);
          parama.nFA.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        parama.nFA.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L)
        {
          parama.nFA.setProgress(paramBallInfo.progress);
          parama.nFJ = paramInt;
          AppMethodBeat.o(106025);
          return;
        }
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException1, "setIconAnimateView exception:%s", new Object[] { localException1 });
        i = com.tencent.mm.plugin.ball.f.d.yd(paramBallInfo.state);
        parama.nFA.setImageResource(i);
        continue;
        parama.nFA.setProgress(-2147483648L);
        continue;
      }
      if (parama.nFJ != paramInt)
      {
        parama.nFA.setVisibility(8);
        parama.nFz.setVisibility(0);
      }
      try
      {
        parama.nFz.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L) {
          parama.nFz.setProgress(paramBallInfo.progress);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException2, "setIconImageView exception:%s", new Object[] { localException2 });
          i = com.tencent.mm.plugin.ball.f.d.yc(paramBallInfo.type);
          parama.nFz.setImageResource(i);
          paramBallInfo.lZt = i;
        }
        parama.nFz.setProgress(-2147483648L);
      }
      continue;
      parama.nFz.setVisibility(4);
      parama.nFA.setVisibility(4);
    }
  }
  
  private boolean xR(int paramInt)
  {
    AppMethodBeat.i(217242);
    if ((paramInt >= 0) && (paramInt < this.nFa.size()))
    {
      AppMethodBeat.o(217242);
      return true;
    }
    AppMethodBeat.o(217242);
    return false;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(106022);
    if (com.tencent.mm.plugin.ball.f.d.h(this.nFa))
    {
      int i = this.nFa.size();
      AppMethodBeat.o(106022);
      return i;
    }
    AppMethodBeat.o(106022);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106023);
    if ((com.tencent.mm.plugin.ball.f.d.h(this.nFa)) && (paramInt >= 0) && (paramInt < this.nFa.size()))
    {
      if (((BallInfo)this.nFa.get(paramInt)).nFX)
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
    public CircleAnimateView nFA;
    public ImageView nFB;
    public FrameLayout nFC;
    public TextView nFD;
    public TextView nFE;
    public LinearLayout nFF;
    public ImageView nFG;
    public LinearLayout nFH;
    public LinearLayout nFI;
    public int nFJ;
    public BallInfo nFy;
    public CircleImageView nFz;
    public int position;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(106021);
      this.nFJ = -1;
      this.nFz = ((CircleImageView)paramView.findViewById(2131300881));
      this.nFA = ((CircleAnimateView)paramView.findViewById(2131300879));
      this.nFB = ((ImageView)paramView.findViewById(2131304078));
      this.nFC = ((FrameLayout)paramView.findViewById(2131304077));
      this.nFD = ((TextView)paramView.findViewById(2131302658));
      this.nFE = ((TextView)paramView.findViewById(2131302657));
      this.nFF = ((LinearLayout)paramView.findViewById(2131302655));
      this.nFG = ((ImageView)paramView.findViewById(2131296938));
      this.nFH = ((LinearLayout)paramView.findViewById(2131307865));
      this.nFI = ((LinearLayout)paramView.findViewById(2131307866));
      AppMethodBeat.o(106021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.a
 * JD-Core Version:    0.7.0.1
 */