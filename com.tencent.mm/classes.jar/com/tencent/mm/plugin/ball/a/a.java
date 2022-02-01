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
  private static final int rXA;
  private static final int rXB;
  private static final int rXC;
  private static final int rXD;
  private static final int rXE;
  private static final int rXF;
  private static final int rXG;
  private static final int rXH;
  private static final int rXt;
  private static final int rXu;
  private static final int rXv;
  private static final int rXw;
  private static final int rXx;
  private static final int rXy;
  private static final int rXz;
  private Context mContext;
  public boolean rXn;
  public boolean rXo;
  public List<BallInfo> rXp;
  public com.tencent.mm.plugin.ball.d.b rXq;
  public boolean rXr;
  public d.b rXs;
  
  static
  {
    AppMethodBeat.i(106029);
    rXt = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_width_active);
    rXu = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_height_active);
    rXv = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_width_passive);
    rXw = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_height_passive);
    rXx = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_shadow_horizontal);
    rXy = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_shadow_top);
    rXz = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_shadow_bottom);
    rXA = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_padding_start_left_active);
    rXB = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_padding_start_right_active);
    rXC = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_padding_end_left_active);
    rXD = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_padding_end_right_active);
    rXE = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_padding_start_left_passive);
    rXF = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_padding_start_right_passive);
    rXG = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_padding_end_left_passive);
    rXH = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.c.float_menu_item_padding_end_right_passive);
    AppMethodBeat.o(106029);
  }
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private boolean Fc(int paramInt)
  {
    AppMethodBeat.i(187748);
    if ((paramInt >= 0) && (paramInt < this.rXp.size()))
    {
      AppMethodBeat.o(187748);
      return true;
    }
    AppMethodBeat.o(187748);
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
        if (parama.rXY != paramInt)
        {
          parama.rXO.setVisibility(8);
          parama.rXP.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        parama.rXP.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L)
        {
          parama.rXP.setProgress(paramBallInfo.progress);
          parama.rXY = paramInt;
          AppMethodBeat.o(106025);
          return;
        }
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException1, "setIconAnimateView exception:%s", new Object[] { localException1 });
        i = com.tencent.mm.plugin.ball.f.d.Fn(paramBallInfo.state);
        parama.rXP.setImageResource(i);
        continue;
        parama.rXP.setProgress(-2147483648L);
        continue;
      }
      if (parama.rXY != paramInt)
      {
        parama.rXP.setVisibility(8);
        parama.rXO.setVisibility(0);
      }
      try
      {
        parama.rXO.setImageResource(paramInt);
        if (paramBallInfo.progress >= 0L) {
          parama.rXO.setProgress(paramBallInfo.progress);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FloatBallMenuAdapter", localException2, "setIconImageView exception:%s", new Object[] { localException2 });
          i = com.tencent.mm.plugin.ball.f.d.Fm(paramBallInfo.type);
          parama.rXO.setImageResource(i);
          paramBallInfo.qpN = i;
        }
        parama.rXO.setProgress(-2147483648L);
      }
      continue;
      parama.rXO.setVisibility(4);
      parama.rXP.setVisibility(4);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(106022);
    if (com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.rXp))
    {
      int i = this.rXp.size();
      AppMethodBeat.o(106022);
      return i;
    }
    AppMethodBeat.o(106022);
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106023);
    if ((com.tencent.mm.plugin.ball.f.d.checkListNotEmpty(this.rXp)) && (paramInt >= 0) && (paramInt < this.rXp.size()))
    {
      if (((BallInfo)this.rXp.get(paramInt)).rYr)
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
    public BallInfo rXN;
    public CircleImageView rXO;
    public CircleAnimateView rXP;
    public ImageView rXQ;
    public FrameLayout rXR;
    public TextView rXS;
    public TextView rXT;
    public LinearLayout rXU;
    public ImageView rXV;
    public LinearLayout rXW;
    public LinearLayout rXX;
    public int rXY;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(106021);
      this.rXY = -1;
      this.rXO = ((CircleImageView)paramView.findViewById(a.e.iconImageView));
      this.rXP = ((CircleAnimateView)paramView.findViewById(a.e.iconAnimateView));
      this.rXQ = ((ImageView)paramView.findViewById(a.e.removeImageView));
      this.rXR = ((FrameLayout)paramView.findViewById(a.e.removeFrameLayout));
      this.rXS = ((TextView)paramView.findViewById(a.e.nameTextView));
      this.rXT = ((TextView)paramView.findViewById(a.e.nameTagTextView));
      this.rXU = ((LinearLayout)paramView.findViewById(a.e.nameLayout));
      this.rXV = ((ImageView)paramView.findViewById(a.e.arrowImageView));
      this.rXW = ((LinearLayout)paramView.findViewById(a.e.menu_content_layout));
      this.rXX = ((LinearLayout)paramView.findViewById(a.e.menu_custom_view_layout));
      AppMethodBeat.o(106021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.a
 * JD-Core Version:    0.7.0.1
 */