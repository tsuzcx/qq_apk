package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ah;

public class MallWalletSectionCellView
  extends LinearLayout
{
  static final int kzk;
  public View iDS;
  public View ksW;
  public CdnImageView oAA;
  public TextView oAB;
  public ImageView oAC;
  public TextView oAD;
  public TextView oAE;
  public ViewGroup oAF;
  public TextView oAG;
  public ProgressBar oAH;
  public CdnImageView oAx;
  public TextView oAy;
  public TextView oAz;
  
  static
  {
    AppMethodBeat.i(43258);
    kzk = a.fromDPToPix(ah.getContext(), 16);
    AppMethodBeat.o(43258);
  }
  
  public MallWalletSectionCellView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(43251);
    init(paramContext);
    AppMethodBeat.o(43251);
  }
  
  public MallWalletSectionCellView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(43252);
    init(paramContext);
    AppMethodBeat.o(43252);
  }
  
  public MallWalletSectionCellView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(43253);
    init(paramContext);
    AppMethodBeat.o(43253);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(43254);
    this.iDS = LayoutInflater.from(paramContext).inflate(2130970113, this, true);
    this.oAx = ((CdnImageView)this.iDS.findViewById(2131826070));
    this.oAy = ((TextView)this.iDS.findViewById(2131826071));
    this.oAz = ((TextView)this.iDS.findViewById(2131826076));
    this.oAA = ((CdnImageView)this.iDS.findViewById(2131826079));
    this.oAB = ((TextView)this.iDS.findViewById(2131826078));
    this.oAC = ((ImageView)this.iDS.findViewById(2131826073));
    this.oAD = ((TextView)this.iDS.findViewById(2131826074));
    this.oAE = ((TextView)this.iDS.findViewById(2131826075));
    this.ksW = this.iDS.findViewById(2131826080);
    this.oAF = ((ViewGroup)this.iDS.findViewById(2131826069));
    this.oAG = ((TextView)this.iDS.findViewById(2131826072));
    this.oAH = ((ProgressBar)this.iDS.findViewById(2131826077));
    AppMethodBeat.o(43254);
  }
  
  final int aP(float paramFloat)
  {
    AppMethodBeat.i(43255);
    int i = a.fromDPToPix(getContext(), (int)paramFloat);
    AppMethodBeat.o(43255);
    return i;
  }
  
  final void bOQ()
  {
    AppMethodBeat.i(43256);
    this.oAD.setVisibility(8);
    this.oAC.setVisibility(8);
    this.oAE.setVisibility(8);
    AppMethodBeat.o(43256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView
 * JD-Core Version:    0.7.0.1
 */