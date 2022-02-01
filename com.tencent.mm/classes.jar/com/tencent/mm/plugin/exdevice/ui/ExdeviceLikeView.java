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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class ExdeviceLikeView
  extends RelativeLayout
{
  private Context mContext;
  private int rIt;
  private a rIu;
  private int rIv;
  private TextView rIw;
  private ImageView rIx;
  private ProgressBar rIy;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24046);
    this.rIv = 2;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131494027, this, true);
    this.rIw = ((TextView)paramContext.findViewById(2131300200));
    this.rIx = ((ImageView)paramContext.findViewById(2131300199));
    this.rIy = ((ProgressBar)paramContext.findViewById(2131300203));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24045);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null)
        {
          paramAnonymousView = ExdeviceLikeView.a(ExdeviceLikeView.this);
          ExdeviceLikeView.b(ExdeviceLikeView.this);
          if ((!paramAnonymousView.cLN()) && (ExdeviceLikeView.b(ExdeviceLikeView.this) == 0))
          {
            Log.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
            ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.GG(ExdeviceLikeView.b(ExdeviceLikeView.this)));
            if (ExdeviceLikeView.b(ExdeviceLikeView.this) == 1) {
              ExdeviceLikeView.c(ExdeviceLikeView.this);
            }
            if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null) {
              ExdeviceLikeView.a(ExdeviceLikeView.this).oj(ExdeviceLikeView.b(ExdeviceLikeView.this));
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
    this.rIt = paramInt;
    String str = this.rIt;
    if (this.rIt < 0)
    {
      Log.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.rIt > 0) {
        break label97;
      }
      this.rIw.setVisibility(8);
    }
    for (;;)
    {
      this.rIw.setText(str);
      AppMethodBeat.o(24047);
      return;
      if (paramInt <= 999) {
        break;
      }
      Log.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label97:
      this.rIw.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(a parama)
  {
    this.rIu = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    AppMethodBeat.i(24048);
    this.rIv = paramInt;
    if (this.rIv == 1)
    {
      this.rIy.setVisibility(8);
      this.rIw.setVisibility(0);
      this.rIx.setVisibility(0);
      this.rIx.setImageResource(2131690082);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.rIv == 0)
    {
      this.rIy.setVisibility(8);
      this.rIw.setVisibility(0);
      this.rIx.setVisibility(0);
      this.rIx.setImageResource(2131690083);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.rIv == 2)
    {
      this.rIw.setVisibility(8);
      this.rIy.setVisibility(0);
      this.rIx.setVisibility(8);
      AppMethodBeat.o(24048);
      return;
    }
    Log.w("MicroMsg.ExdeviceLikeView", "hy: error state");
    AppMethodBeat.o(24048);
  }
  
  public static abstract interface a
  {
    public abstract boolean cLN();
    
    public abstract void oj(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */