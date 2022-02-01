package com.tencent.mm.plugin.ball.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.CircleAnimateView;
import com.tencent.mm.plugin.ball.view.CircleImageView;
import com.tencent.mm.plugin.ball.view.d.b;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private static final int oVA;
  private static final int oVB;
  private static final int oVC;
  private static final int oVD;
  private static final int oVE;
  private static final int oVF;
  private static final int oVG;
  private static final int oVH;
  private static final int oVI;
  private static final int oVu;
  private static final int oVv;
  private static final int oVw;
  private static final int oVx;
  private static final int oVy;
  private static final int oVz;
  private Context mContext;
  public boolean oVo;
  public boolean oVp;
  public List<BallInfo> oVq;
  public com.tencent.mm.plugin.ball.d.b oVr;
  public boolean oVs;
  public d.b oVt;
  
  static
  {
    AppMethodBeat.i(106029);
    oVu = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166474);
    oVv = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166456);
    oVw = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166475);
    oVx = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166457);
    oVy = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166471);
    oVz = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166472);
    oVA = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166470);
    oVB = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166464);
    oVC = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166466);
    oVD = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166460);
    oVE = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166462);
    oVF = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166465);
    oVG = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166467);
    oVH = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166461);
    oVI = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166463);
    AppMethodBeat.o(106029);
  }
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private boolean BB(int paramInt)
  {
    AppMethodBeat.i(216964);
    if ((paramInt >= 0) && (paramInt < this.oVq.size()))
    {
      AppMethodBeat.o(216964);
      return true;
    }
    AppMethodBeat.o(216964);
    return false;
  }
  
  private static void a(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(106024);
    if (!Util.isNullOrNil(paramString))
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
      if (ImgUtil.isGif(MMApplicationContext.getContext(), paramInt)) {
        if (parama.oVZ != paramInt)
        {
          parama.oVP.setVisibility(8);
          parama.oVQ.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        parama.oVQ.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L)
        {
          parama.oVQ.setProgress(paramBallInfo.progress);
          parama.oVZ = paramInt;
          AppMethodBeat.o(106025);
          return;
        }
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException1, "setIconAnimateView exception:%s", new Object[] { localException1 });
        i = com.tencent.mm.plugin.ball.f.d.BM(paramBallInfo.state);
        parama.oVQ.setImageResource(i);
        continue;
        parama.oVQ.setProgress(-2147483648L);
        continue;
      }
      if (parama.oVZ != paramInt)
      {
        parama.oVQ.setVisibility(8);
        parama.oVP.setVisibility(0);
      }
      try
      {
        parama.oVP.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L) {
          parama.oVP.setProgress(paramBallInfo.progress);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException2, "setIconImageView exception:%s", new Object[] { localException2 });
          i = com.tencent.mm.plugin.ball.f.d.BL(paramBallInfo.type);
          parama.oVP.setImageResource(i);
          paramBallInfo.noe = i;
        }
        parama.oVP.setProgress(-2147483648L);
      }
      continue;
      parama.oVP.setVisibility(4);
      parama.oVQ.setVisibility(4);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(106022);
    if (com.tencent.mm.plugin.ball.f.d.h(this.oVq))
    {
      int i = this.oVq.size();
      AppMethodBeat.o(106022);
      return i;
    }
    AppMethodBeat.o(106022);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106023);
    if ((com.tencent.mm.plugin.ball.f.d.h(this.oVq)) && (paramInt >= 0) && (paramInt < this.oVq.size()))
    {
      if (((BallInfo)this.oVq.get(paramInt)).oWr)
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
    public BallInfo oVO;
    public CircleImageView oVP;
    public CircleAnimateView oVQ;
    public ImageView oVR;
    public FrameLayout oVS;
    public TextView oVT;
    public TextView oVU;
    public LinearLayout oVV;
    public ImageView oVW;
    public LinearLayout oVX;
    public LinearLayout oVY;
    public int oVZ;
    public int position;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(106021);
      this.oVZ = -1;
      this.oVP = ((CircleImageView)paramView.findViewById(2131302476));
      this.oVQ = ((CircleAnimateView)paramView.findViewById(2131302473));
      this.oVR = ((ImageView)paramView.findViewById(2131306941));
      this.oVS = ((FrameLayout)paramView.findViewById(2131306940));
      this.oVT = ((TextView)paramView.findViewById(2131305212));
      this.oVU = ((TextView)paramView.findViewById(2131305211));
      this.oVV = ((LinearLayout)paramView.findViewById(2131305209));
      this.oVW = ((ImageView)paramView.findViewById(2131297044));
      this.oVX = ((LinearLayout)paramView.findViewById(2131304607));
      this.oVY = ((LinearLayout)paramView.findViewById(2131304609));
      AppMethodBeat.o(106021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.a
 * JD-Core Version:    0.7.0.1
 */