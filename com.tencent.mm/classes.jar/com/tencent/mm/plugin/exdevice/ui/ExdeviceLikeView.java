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
  private int vob;
  private a voc;
  private int vod;
  private TextView voe;
  private ImageView vof;
  private ProgressBar vog;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24046);
    this.vod = 2;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(R.i.egx, this, true);
    this.voe = ((TextView)paramContext.findViewById(R.h.dFW));
    this.vof = ((ImageView)paramContext.findViewById(R.h.dFV));
    this.vog = ((ProgressBar)paramContext.findViewById(R.h.dFZ));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24045);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null)
        {
          paramAnonymousView = ExdeviceLikeView.a(ExdeviceLikeView.this);
          ExdeviceLikeView.b(ExdeviceLikeView.this);
          if ((!paramAnonymousView.daA()) && (ExdeviceLikeView.b(ExdeviceLikeView.this) == 0))
          {
            Log.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
            ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.Ko(ExdeviceLikeView.b(ExdeviceLikeView.this)));
            if (ExdeviceLikeView.b(ExdeviceLikeView.this) == 1) {
              ExdeviceLikeView.c(ExdeviceLikeView.this);
            }
            if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null) {
              ExdeviceLikeView.a(ExdeviceLikeView.this).qy(ExdeviceLikeView.b(ExdeviceLikeView.this));
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
    this.vob = paramInt;
    String str = this.vob;
    if (this.vob < 0)
    {
      Log.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.vob > 0) {
        break label97;
      }
      this.voe.setVisibility(8);
    }
    for (;;)
    {
      this.voe.setText(str);
      AppMethodBeat.o(24047);
      return;
      if (paramInt <= 999) {
        break;
      }
      Log.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label97:
      this.voe.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(a parama)
  {
    this.voc = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    AppMethodBeat.i(24048);
    this.vod = paramInt;
    if (this.vod == 1)
    {
      this.vog.setVisibility(8);
      this.voe.setVisibility(0);
      this.vof.setVisibility(0);
      this.vof.setImageResource(R.k.device_rank_item_liked);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.vod == 0)
    {
      this.vog.setVisibility(8);
      this.voe.setVisibility(0);
      this.vof.setVisibility(0);
      this.vof.setImageResource(R.k.device_rank_item_unliked);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.vod == 2)
    {
      this.voe.setVisibility(8);
      this.vog.setVisibility(0);
      this.vof.setVisibility(8);
      AppMethodBeat.o(24048);
      return;
    }
    Log.w("MicroMsg.ExdeviceLikeView", "hy: error state");
    AppMethodBeat.o(24048);
  }
  
  public static abstract interface a
  {
    public abstract boolean daA();
    
    public abstract void qy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */