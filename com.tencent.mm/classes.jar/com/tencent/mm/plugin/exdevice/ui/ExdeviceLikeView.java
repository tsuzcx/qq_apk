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
import com.tencent.mm.sdk.platformtools.ae;

public class ExdeviceLikeView
  extends RelativeLayout
{
  private Context mContext;
  private int qqY;
  private a qqZ;
  private int qra;
  private TextView qrb;
  private ImageView qrc;
  private ProgressBar qrd;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24046);
    this.qra = 2;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131493869, this, true);
    this.qrb = ((TextView)paramContext.findViewById(2131299552));
    this.qrc = ((ImageView)paramContext.findViewById(2131299551));
    this.qrd = ((ProgressBar)paramContext.findViewById(2131299555));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24045);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null)
        {
          paramAnonymousView = ExdeviceLikeView.a(ExdeviceLikeView.this);
          ExdeviceLikeView.b(ExdeviceLikeView.this);
          if ((!paramAnonymousView.cnz()) && (ExdeviceLikeView.b(ExdeviceLikeView.this) == 0))
          {
            ae.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
            ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.CV(ExdeviceLikeView.b(ExdeviceLikeView.this)));
            if (ExdeviceLikeView.b(ExdeviceLikeView.this) == 1) {
              ExdeviceLikeView.c(ExdeviceLikeView.this);
            }
            if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null) {
              ExdeviceLikeView.a(ExdeviceLikeView.this).lh(ExdeviceLikeView.b(ExdeviceLikeView.this));
            }
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(24045);
          return;
          ae.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
        }
      }
    });
    AppMethodBeat.o(24046);
  }
  
  public void setLikeNum(int paramInt)
  {
    AppMethodBeat.i(24047);
    this.qqY = paramInt;
    String str = this.qqY;
    if (this.qqY < 0)
    {
      ae.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.qqY > 0) {
        break label97;
      }
      this.qrb.setVisibility(8);
    }
    for (;;)
    {
      this.qrb.setText(str);
      AppMethodBeat.o(24047);
      return;
      if (paramInt <= 999) {
        break;
      }
      ae.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label97:
      this.qrb.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(a parama)
  {
    this.qqZ = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    AppMethodBeat.i(24048);
    this.qra = paramInt;
    if (this.qra == 1)
    {
      this.qrd.setVisibility(8);
      this.qrb.setVisibility(0);
      this.qrc.setVisibility(0);
      this.qrc.setImageResource(2131690052);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.qra == 0)
    {
      this.qrd.setVisibility(8);
      this.qrb.setVisibility(0);
      this.qrc.setVisibility(0);
      this.qrc.setImageResource(2131690053);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.qra == 2)
    {
      this.qrb.setVisibility(8);
      this.qrd.setVisibility(0);
      this.qrc.setVisibility(8);
      AppMethodBeat.o(24048);
      return;
    }
    ae.w("MicroMsg.ExdeviceLikeView", "hy: error state");
    AppMethodBeat.o(24048);
  }
  
  public static abstract interface a
  {
    public abstract boolean cnz();
    
    public abstract void lh(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */