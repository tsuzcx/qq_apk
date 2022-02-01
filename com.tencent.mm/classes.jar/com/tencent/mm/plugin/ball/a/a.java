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
import com.tencent.mm.plugin.ball.d.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.CircleAnimateView;
import com.tencent.mm.plugin.ball.view.CircleImageView;
import com.tencent.mm.plugin.ball.view.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private static final int neI;
  private static final int neJ;
  private static final int neK;
  private static final int neL;
  private static final int neM;
  private static final int neN;
  private static final int neO;
  private static final int neP;
  private static final int neQ;
  private static final int neR;
  private static final int neS;
  private static final int neT;
  private static final int neU;
  private static final int neV;
  private static final int neW;
  private Context mContext;
  public boolean neC;
  public boolean neD;
  public List<BallInfo> neE;
  public c neF;
  public boolean neG;
  public d.b neH;
  
  static
  {
    AppMethodBeat.i(106029);
    neI = com.tencent.mm.cc.a.av(ai.getContext(), 2131166382);
    neJ = com.tencent.mm.cc.a.av(ai.getContext(), 2131166364);
    neK = com.tencent.mm.cc.a.av(ai.getContext(), 2131166383);
    neL = com.tencent.mm.cc.a.av(ai.getContext(), 2131166365);
    neM = com.tencent.mm.cc.a.av(ai.getContext(), 2131166379);
    neN = com.tencent.mm.cc.a.av(ai.getContext(), 2131166380);
    neO = com.tencent.mm.cc.a.av(ai.getContext(), 2131166378);
    neP = com.tencent.mm.cc.a.av(ai.getContext(), 2131166372);
    neQ = com.tencent.mm.cc.a.av(ai.getContext(), 2131166374);
    neR = com.tencent.mm.cc.a.av(ai.getContext(), 2131166368);
    neS = com.tencent.mm.cc.a.av(ai.getContext(), 2131166370);
    neT = com.tencent.mm.cc.a.av(ai.getContext(), 2131166373);
    neU = com.tencent.mm.cc.a.av(ai.getContext(), 2131166375);
    neV = com.tencent.mm.cc.a.av(ai.getContext(), 2131166369);
    neW = com.tencent.mm.cc.a.av(ai.getContext(), 2131166371);
    AppMethodBeat.o(106029);
  }
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static void a(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(106024);
    if (!bs.isNullOrNil(paramString))
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
      if (s.aB(ai.getContext(), paramInt)) {
        if (parama.nfn != paramInt)
        {
          parama.nfd.setVisibility(8);
          parama.nfe.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        parama.nfe.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L)
        {
          parama.nfe.setProgress(paramBallInfo.progress);
          parama.nfn = paramInt;
          AppMethodBeat.o(106025);
          return;
        }
      }
      catch (Exception localException1)
      {
        ac.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException1, "setIconAnimateView exception:%s", new Object[] { localException1 });
        i = com.tencent.mm.plugin.ball.f.d.xx(paramBallInfo.state);
        parama.nfe.setImageResource(i);
        continue;
        parama.nfe.setProgress(-2147483648L);
        continue;
      }
      if (parama.nfn != paramInt)
      {
        parama.nfe.setVisibility(8);
        parama.nfd.setVisibility(0);
      }
      try
      {
        parama.nfd.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L) {
          parama.nfd.setProgress(paramBallInfo.progress);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException2, "setIconImageView exception:%s", new Object[] { localException2 });
          i = com.tencent.mm.plugin.ball.f.d.xw(paramBallInfo.type);
          parama.nfd.setImageResource(i);
          paramBallInfo.lzV = i;
        }
        parama.nfd.setProgress(-2147483648L);
      }
      continue;
      parama.nfd.setVisibility(4);
      parama.nfe.setVisibility(4);
    }
  }
  
  private boolean xl(int paramInt)
  {
    AppMethodBeat.i(207960);
    if ((paramInt >= 0) && (paramInt < this.neE.size()))
    {
      AppMethodBeat.o(207960);
      return true;
    }
    AppMethodBeat.o(207960);
    return false;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(106022);
    if (com.tencent.mm.plugin.ball.f.d.h(this.neE))
    {
      int i = this.neE.size();
      AppMethodBeat.o(106022);
      return i;
    }
    AppMethodBeat.o(106022);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106023);
    if ((com.tencent.mm.plugin.ball.f.d.h(this.neE)) && (paramInt >= 0) && (paramInt < this.neE.size()))
    {
      if (((BallInfo)this.neE.get(paramInt)).nfB)
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
    public BallInfo nfc;
    public CircleImageView nfd;
    public CircleAnimateView nfe;
    public ImageView nff;
    public FrameLayout nfg;
    public TextView nfh;
    public TextView nfi;
    public LinearLayout nfj;
    public ImageView nfk;
    public LinearLayout nfl;
    public LinearLayout nfm;
    public int nfn;
    public int position;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(106021);
      this.nfn = -1;
      this.nfd = ((CircleImageView)paramView.findViewById(2131300881));
      this.nfe = ((CircleAnimateView)paramView.findViewById(2131300879));
      this.nff = ((ImageView)paramView.findViewById(2131304078));
      this.nfg = ((FrameLayout)paramView.findViewById(2131304077));
      this.nfh = ((TextView)paramView.findViewById(2131302658));
      this.nfi = ((TextView)paramView.findViewById(2131302657));
      this.nfj = ((LinearLayout)paramView.findViewById(2131302655));
      this.nfk = ((ImageView)paramView.findViewById(2131296938));
      this.nfl = ((LinearLayout)paramView.findViewById(2131307865));
      this.nfm = ((LinearLayout)paramView.findViewById(2131307866));
      AppMethodBeat.o(106021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.a
 * JD-Core Version:    0.7.0.1
 */