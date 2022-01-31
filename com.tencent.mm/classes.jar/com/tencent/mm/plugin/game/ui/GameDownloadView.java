package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public class GameDownloadView
  extends FrameLayout
  implements View.OnClickListener
{
  private j.a nxv;
  private k nxx;
  private Button nyC;
  private TextProgressBar nyD;
  private d nyE;
  
  public GameDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111896);
    this.nxv = new GameDownloadView.4(this);
    AppMethodBeat.o(111896);
  }
  
  private void bHm()
  {
    AppMethodBeat.i(111902);
    al.d(new GameDownloadView.3(this));
    AppMethodBeat.o(111902);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(111899);
    super.onAttachedToWindow();
    j.a(this.nxv);
    AppMethodBeat.o(111899);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111903);
    this.nxx.em(ah.getContext());
    this.nyE.a(this.nxx.nmJ, this.nxx);
    AppMethodBeat.o(111903);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(111898);
    super.onDetachedFromWindow();
    j.b(this.nxv);
    AppMethodBeat.o(111898);
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(111897);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2130969742, this, true);
    this.nyC = ((Button)localView.findViewById(2131824529));
    this.nyD = ((TextProgressBar)localView.findViewById(2131824530));
    this.nyD.setTextSize(14);
    this.nyC.setOnClickListener(this);
    this.nyD.setOnClickListener(this);
    this.nyE = new d(getContext());
    this.nyE.nvf = new GameDownloadView.1(this);
    AppMethodBeat.o(111897);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(111900);
    if (this.nxx != null)
    {
      this.nxx.em(ah.getContext());
      this.nxx.bjZ();
      bHm();
    }
    AppMethodBeat.o(111900);
  }
  
  public void setDownloadInfo(k paramk)
  {
    AppMethodBeat.i(111901);
    this.nxx = paramk;
    c.aNS().ac(new GameDownloadView.2(this));
    bHm();
    AppMethodBeat.o(111901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadView
 * JD-Core Version:    0.7.0.1
 */