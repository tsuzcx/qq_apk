package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class ExdeviceLikeView
  extends RelativeLayout
{
  private Context mContext;
  private TextView yAA;
  private ImageView yAB;
  private ProgressBar yAC;
  private int yAx;
  private a yAy;
  private int yAz;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24046);
    this.yAz = 2;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(R.i.gjq, this, true);
    this.yAA = ((TextView)paramContext.findViewById(R.h.fHc));
    this.yAB = ((ImageView)paramContext.findViewById(R.h.fHb));
    this.yAC = ((ProgressBar)paramContext.findViewById(R.h.fHf));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24045);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null)
        {
          paramAnonymousView = ExdeviceLikeView.a(ExdeviceLikeView.this);
          ExdeviceLikeView.b(ExdeviceLikeView.this);
          if ((!paramAnonymousView.dGV()) && (ExdeviceLikeView.b(ExdeviceLikeView.this) == 0))
          {
            Log.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
            ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.Ln(ExdeviceLikeView.b(ExdeviceLikeView.this)));
            if (ExdeviceLikeView.b(ExdeviceLikeView.this) == 1) {
              ExdeviceLikeView.c(ExdeviceLikeView.this);
            }
            if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null) {
              ExdeviceLikeView.a(ExdeviceLikeView.this).qz(ExdeviceLikeView.b(ExdeviceLikeView.this));
            }
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24045);
          return;
          Log.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
        }
      }
    });
    AppMethodBeat.o(24046);
  }
  
  public void setLikeNum(int paramInt)
  {
    AppMethodBeat.i(24047);
    this.yAx = paramInt;
    String str = this.yAx;
    if (this.yAx < 0)
    {
      Log.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.yAx > 0) {
        break label97;
      }
      this.yAA.setVisibility(8);
    }
    for (;;)
    {
      this.yAA.setText(str);
      AppMethodBeat.o(24047);
      return;
      if (paramInt <= 999) {
        break;
      }
      Log.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label97:
      this.yAA.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(a parama)
  {
    this.yAy = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    AppMethodBeat.i(24048);
    this.yAz = paramInt;
    if (this.yAz == 1)
    {
      this.yAC.setVisibility(8);
      this.yAA.setVisibility(0);
      this.yAB.setVisibility(0);
      this.yAB.setImageResource(R.k.device_rank_item_liked);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.yAz == 0)
    {
      this.yAC.setVisibility(8);
      this.yAA.setVisibility(0);
      this.yAB.setVisibility(0);
      this.yAB.setImageResource(R.k.device_rank_item_unliked);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.yAz == 2)
    {
      this.yAA.setVisibility(8);
      this.yAC.setVisibility(0);
      this.yAB.setVisibility(8);
      AppMethodBeat.o(24048);
      return;
    }
    Log.w("MicroMsg.ExdeviceLikeView", "hy: error state");
    AppMethodBeat.o(24048);
  }
  
  public static abstract interface a
  {
    public abstract boolean dGV();
    
    public abstract void qz(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */