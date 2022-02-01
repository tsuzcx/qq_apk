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
import com.tencent.mm.sdk.platformtools.ad;

public class ExdeviceLikeView
  extends RelativeLayout
{
  private Context mContext;
  private int pdD;
  private a pdE;
  private int pdF;
  private TextView pdG;
  private ImageView pdH;
  private ProgressBar pdI;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24046);
    this.pdF = 2;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131493869, this, true);
    this.pdG = ((TextView)paramContext.findViewById(2131299552));
    this.pdH = ((ImageView)paramContext.findViewById(2131299551));
    this.pdI = ((ProgressBar)paramContext.findViewById(2131299555));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24045);
        if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null)
        {
          paramAnonymousView = ExdeviceLikeView.a(ExdeviceLikeView.this);
          ExdeviceLikeView.b(ExdeviceLikeView.this);
          if ((!paramAnonymousView.caw()) && (ExdeviceLikeView.b(ExdeviceLikeView.this) == 0))
          {
            ad.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
            ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.Bi(ExdeviceLikeView.b(ExdeviceLikeView.this)));
            if (ExdeviceLikeView.b(ExdeviceLikeView.this) == 1) {
              ExdeviceLikeView.c(ExdeviceLikeView.this);
            }
            if (ExdeviceLikeView.a(ExdeviceLikeView.this) == null) {
              break label136;
            }
            ExdeviceLikeView.a(ExdeviceLikeView.this).kM(ExdeviceLikeView.b(ExdeviceLikeView.this));
            AppMethodBeat.o(24045);
            return;
          }
        }
        ad.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
        label136:
        AppMethodBeat.o(24045);
      }
    });
    AppMethodBeat.o(24046);
  }
  
  public void setLikeNum(int paramInt)
  {
    AppMethodBeat.i(24047);
    this.pdD = paramInt;
    String str = this.pdD;
    if (this.pdD < 0)
    {
      ad.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.pdD > 0) {
        break label97;
      }
      this.pdG.setVisibility(8);
    }
    for (;;)
    {
      this.pdG.setText(str);
      AppMethodBeat.o(24047);
      return;
      if (paramInt <= 999) {
        break;
      }
      ad.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label97:
      this.pdG.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(a parama)
  {
    this.pdE = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    AppMethodBeat.i(24048);
    this.pdF = paramInt;
    if (this.pdF == 1)
    {
      this.pdI.setVisibility(8);
      this.pdG.setVisibility(0);
      this.pdH.setVisibility(0);
      this.pdH.setImageResource(2131690052);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.pdF == 0)
    {
      this.pdI.setVisibility(8);
      this.pdG.setVisibility(0);
      this.pdH.setVisibility(0);
      this.pdH.setImageResource(2131690053);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.pdF == 2)
    {
      this.pdG.setVisibility(8);
      this.pdI.setVisibility(0);
      this.pdH.setVisibility(8);
      AppMethodBeat.o(24048);
      return;
    }
    ad.w("MicroMsg.ExdeviceLikeView", "hy: error state");
    AppMethodBeat.o(24048);
  }
  
  public static abstract interface a
  {
    public abstract boolean caw();
    
    public abstract void kM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */