package com.tencent.mm.plugin.ball.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.ball.a.c;
import com.tencent.mm.plugin.ball.a.e;
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
  private static final int viK;
  private static final int viL;
  private static final int viM;
  private static final int viN;
  private static final int viO;
  private static final int viP;
  private static final int viQ;
  private static final int viR;
  private static final int viS;
  private static final int viT;
  private static final int viU;
  private static final int viV;
  private static final int viW;
  private static final int viX;
  private static final int viY;
  private Context mContext;
  public boolean viE;
  public boolean viF;
  public List<BallInfo> viG;
  public com.tencent.mm.plugin.ball.d.b viH;
  public boolean viI;
  public d.b viJ;
  
  static
  {
    AppMethodBeat.i(106029);
    viK = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_width_active);
    viL = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_height_active);
    viM = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_width_passive);
    viN = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_height_passive);
    viO = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_shadow_horizontal);
    viP = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_shadow_top);
    viQ = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_shadow_bottom);
    viR = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_padding_start_left_active);
    viS = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_padding_start_right_active);
    viT = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_padding_end_left_active);
    viU = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_padding_end_right_active);
    viV = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_padding_start_left_passive);
    viW = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_padding_start_right_passive);
    viX = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_padding_end_left_passive);
    viY = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.c.float_menu_item_padding_end_right_passive);
    AppMethodBeat.o(106029);
  }
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private boolean FD(int paramInt)
  {
    AppMethodBeat.i(288314);
    if ((paramInt >= 0) && (paramInt < this.viG.size()))
    {
      AppMethodBeat.o(288314);
      return true;
    }
    AppMethodBeat.o(288314);
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
        if (parama.vjo != paramInt)
        {
          parama.vje.setVisibility(8);
          parama.vjf.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        parama.vjf.setImageResource(paramInt);
        if (paramBallInfo.hQO >= 0L)
        {
          parama.vjf.setProgress(paramBallInfo.hQO);
          parama.vjo = paramInt;
          AppMethodBeat.o(106025);
          return;
        }
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException1, "setIconAnimateView exception:%s", new Object[] { localException1 });
        i = com.tencent.mm.plugin.ball.f.d.K(paramBallInfo);
        parama.vjf.setImageResource(i);
        continue;
        parama.vjf.setProgress(-2147483648L);
        continue;
      }
      if (parama.vjo != paramInt)
      {
        parama.vjf.setVisibility(8);
        parama.vje.setVisibility(0);
      }
      try
      {
        parama.vje.setImageResource(paramInt);
        if (paramBallInfo.hQO >= 0L) {
          parama.vje.setProgress(paramBallInfo.hQO);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException2, "setIconImageView exception:%s", new Object[] { localException2 });
          i = com.tencent.mm.plugin.ball.f.d.J(paramBallInfo);
          parama.vje.setImageResource(i);
          paramBallInfo.tus = i;
        }
        parama.vje.setProgress(-2147483648L);
      }
      continue;
      parama.vje.setVisibility(4);
      parama.vjf.setVisibility(4);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(106022);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.viG))
    {
      int i = this.viG.size();
      AppMethodBeat.o(106022);
      return i;
    }
    AppMethodBeat.o(106022);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106023);
    if ((com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.viG)) && (paramInt >= 0) && (paramInt < this.viG.size()))
    {
      BallInfo localBallInfo = (BallInfo)this.viG.get(paramInt);
      if ((localBallInfo.vjH) || (localBallInfo.type == 20))
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
    public int position;
    public BallInfo vjd;
    public CircleImageView vje;
    public CircleAnimateView vjf;
    public ImageView vjg;
    public FrameLayout vjh;
    public TextView vji;
    public TextView vjj;
    public LinearLayout vjk;
    public ImageView vjl;
    public LinearLayout vjm;
    public LinearLayout vjn;
    public int vjo;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(106021);
      this.vjo = -1;
      this.vje = ((CircleImageView)paramView.findViewById(a.e.iconImageView));
      this.vjf = ((CircleAnimateView)paramView.findViewById(a.e.iconAnimateView));
      this.vjg = ((ImageView)paramView.findViewById(a.e.removeImageView));
      this.vjh = ((FrameLayout)paramView.findViewById(a.e.removeFrameLayout));
      this.vji = ((TextView)paramView.findViewById(a.e.nameTextView));
      this.vjj = ((TextView)paramView.findViewById(a.e.nameTagTextView));
      this.vjk = ((LinearLayout)paramView.findViewById(a.e.nameLayout));
      this.vjl = ((ImageView)paramView.findViewById(a.e.arrowImageView));
      this.vjm = ((LinearLayout)paramView.findViewById(a.e.menu_content_layout));
      this.vjn = ((LinearLayout)paramView.findViewById(a.e.menu_custom_view_layout));
      AppMethodBeat.o(106021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.a
 * JD-Core Version:    0.7.0.1
 */