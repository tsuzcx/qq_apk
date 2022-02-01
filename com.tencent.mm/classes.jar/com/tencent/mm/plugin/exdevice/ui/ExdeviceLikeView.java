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
import com.tencent.mm.sdk.platformtools.ac;

public class ExdeviceLikeView
  extends RelativeLayout
{
  private Context mContext;
  private int pGO;
  private a pGP;
  private int pGQ;
  private TextView pGR;
  private ImageView pGS;
  private ProgressBar pGT;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24046);
    this.pGQ = 2;
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(2131493869, this, true);
    this.pGR = ((TextView)paramContext.findViewById(2131299552));
    this.pGS = ((ImageView)paramContext.findViewById(2131299551));
    this.pGT = ((ProgressBar)paramContext.findViewById(2131299555));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24045);
        if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null)
        {
          paramAnonymousView = ExdeviceLikeView.a(ExdeviceLikeView.this);
          ExdeviceLikeView.b(ExdeviceLikeView.this);
          if ((!paramAnonymousView.chF()) && (ExdeviceLikeView.b(ExdeviceLikeView.this) == 0))
          {
            ac.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
            ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.Ca(ExdeviceLikeView.b(ExdeviceLikeView.this)));
            if (ExdeviceLikeView.b(ExdeviceLikeView.this) == 1) {
              ExdeviceLikeView.c(ExdeviceLikeView.this);
            }
            if (ExdeviceLikeView.a(ExdeviceLikeView.this) == null) {
              break label136;
            }
            ExdeviceLikeView.a(ExdeviceLikeView.this).kG(ExdeviceLikeView.b(ExdeviceLikeView.this));
            AppMethodBeat.o(24045);
            return;
          }
        }
        ac.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
        label136:
        AppMethodBeat.o(24045);
      }
    });
    AppMethodBeat.o(24046);
  }
  
  public void setLikeNum(int paramInt)
  {
    AppMethodBeat.i(24047);
    this.pGO = paramInt;
    String str = this.pGO;
    if (this.pGO < 0)
    {
      ac.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.pGO > 0) {
        break label97;
      }
      this.pGR.setVisibility(8);
    }
    for (;;)
    {
      this.pGR.setText(str);
      AppMethodBeat.o(24047);
      return;
      if (paramInt <= 999) {
        break;
      }
      ac.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label97:
      this.pGR.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(a parama)
  {
    this.pGP = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    AppMethodBeat.i(24048);
    this.pGQ = paramInt;
    if (this.pGQ == 1)
    {
      this.pGT.setVisibility(8);
      this.pGR.setVisibility(0);
      this.pGS.setVisibility(0);
      this.pGS.setImageResource(2131690052);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.pGQ == 0)
    {
      this.pGT.setVisibility(8);
      this.pGR.setVisibility(0);
      this.pGS.setVisibility(0);
      this.pGS.setImageResource(2131690053);
      AppMethodBeat.o(24048);
      return;
    }
    if (this.pGQ == 2)
    {
      this.pGR.setVisibility(8);
      this.pGT.setVisibility(0);
      this.pGS.setVisibility(8);
      AppMethodBeat.o(24048);
      return;
    }
    ac.w("MicroMsg.ExdeviceLikeView", "hy: error state");
    AppMethodBeat.o(24048);
  }
  
  public static abstract interface a
  {
    public abstract boolean chF();
    
    public abstract void kG(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */