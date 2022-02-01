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
import com.tencent.mm.sdk.platformtools.ad;

public class ExdeviceLikeView
  extends RelativeLayout
{
  private Context mContext;
  private int qkt;
  private a qku;
  private int qkv;
  private TextView qkw;
  private ImageView qkx;
  private ProgressBar qky;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24046);
    this.qkv = 2;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131493869, this, true);
    this.qkw = ((TextView)paramContext.findViewById(2131299552));
    this.qkx = ((ImageView)paramContext.findViewById(2131299551));
    this.qky = ((ProgressBar)paramContext.findViewById(2131299555));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24045);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null)
        {
          paramAnonymousView = ExdeviceLikeView.a(ExdeviceLikeView.this);
          ExdeviceLikeView.b(ExdeviceLikeView.this);
          if ((!paramAnonymousView.cmj()) && (ExdeviceLikeView.b(ExdeviceLikeView.this) == 0))
          {
            ad.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
            ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.CJ(ExdeviceLikeView.b(ExdeviceLikeView.this)));
            if (ExdeviceLikeView.b(ExdeviceLikeView.this) == 1) {
              ExdeviceLikeView.c(ExdeviceLikeView.this);
            }
            if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null) {
              ExdeviceLikeView.a(ExdeviceLikeView.this).lf(ExdeviceLikeView.b(ExdeviceLikeView.this));
            }
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24045);
          return;
          ad.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
        }
      }
    });
    AppMethodBeat.o(24046);
  }
  
  public void setLikeNum(int paramInt)
  {
    AppMethodBeat.i(24047);
    this.qkt = paramInt;
    String str = this.qkt;
    if (this.qkt < 0)
    {
      ad.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.qkt > 0) {
        break label97;
      }
      this.qkw.setVisibility(8);
    }
    for (;;)
    {
      this.qkw.setText(str);
      AppMethodBeat.o(24047);
      return;
      if (paramInt <= 999) {
        break;
      }
      ad.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label97:
      this.qkw.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(a parama)
  {
    this.qku = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    AppMethodBeat.i(24048);
    this.qkv = paramInt;
    if (this.qkv == 1)
    {
      this.qky.setVisibility(8);
      this.qkw.setVisibility(0);
      this.qkx.setVisibility(0);
      this.qkx.setImageResource(2131690052);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.qkv == 0)
    {
      this.qky.setVisibility(8);
      this.qkw.setVisibility(0);
      this.qkx.setVisibility(0);
      this.qkx.setImageResource(2131690053);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.qkv == 2)
    {
      this.qkw.setVisibility(8);
      this.qky.setVisibility(0);
      this.qkx.setVisibility(8);
      AppMethodBeat.o(24048);
      return;
    }
    ad.w("MicroMsg.ExdeviceLikeView", "hy: error state");
    AppMethodBeat.o(24048);
  }
  
  public static abstract interface a
  {
    public abstract boolean cmj();
    
    public abstract void lf(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */