package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.u;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;

public class MPSmileyFooter
  extends InputPanelLinearLayout
{
  private MMActivity cmc;
  private ChatFooterPanel eys;
  private int kjA;
  private boolean kjB;
  private MMEditText kju;
  private ImageButton kjv;
  private LinearLayout kjw;
  private LinearLayout kjx;
  private int kjy;
  private int kjz;
  
  public MPSmileyFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(14472);
    this.kju = null;
    this.kjy = -1;
    this.kjz = -1;
    this.kjA = 0;
    this.kjB = true;
    this.cmc = ((MMActivity)paramContext);
    this.kjv = ((ImageButton)((ViewGroup)w.hM(this.cmc).inflate(2130970306, this)).findViewById(2131825850));
    this.kjv.setOnClickListener(new MPSmileyFooter.3(this));
    if (u.j(this.cmc, true) == null)
    {
      this.eys = new d(this.cmc);
      AppMethodBeat.o(14472);
      return;
    }
    this.eys = u.j(this.cmc, true);
    this.eys.setEntranceScene(ChatFooterPanel.vQn);
    this.eys.setBackgroundResource(2131689982);
    this.eys.setVisibility(8);
    this.kjw = ((LinearLayout)findViewById(2131826351));
    this.kjx = ((LinearLayout)findViewById(2131826350));
    this.kjw.setOnClickListener(null);
    this.kjA = x.gL(getContext());
    this.kjw.addView(this.eys, -1, this.kjA);
    this.eys.Az();
    this.eys.bo(false);
    this.eys.onResume();
    baf();
    this.eys.setOnTextOperationListener(new MPSmileyFooter.4(this));
    AppMethodBeat.o(14472);
  }
  
  private void aRm()
  {
    AppMethodBeat.i(14480);
    this.eys.onPause();
    this.eys.setVisibility(8);
    AppMethodBeat.o(14480);
  }
  
  private void baf()
  {
    AppMethodBeat.i(14482);
    ViewGroup.LayoutParams localLayoutParams = this.kjw.getLayoutParams();
    localLayoutParams.height = this.kjA;
    this.kjw.setLayoutParams(localLayoutParams);
    int i = x.gL(getContext());
    this.eys.setPortHeightPx(i);
    this.eys.AD();
    localLayoutParams = this.eys.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(14482);
  }
  
  public final void baa()
  {
    AppMethodBeat.i(14473);
    setVisibility(0);
    if (this.kjv != null) {
      this.kjv.setImageResource(2130839725);
    }
    AppMethodBeat.o(14473);
  }
  
  public final void bab()
  {
    AppMethodBeat.i(14474);
    if (bad())
    {
      AppMethodBeat.o(14474);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(14474);
  }
  
  public final boolean bac()
  {
    AppMethodBeat.i(14476);
    if ((bad()) || (getVisibility() == 0))
    {
      AppMethodBeat.o(14476);
      return true;
    }
    AppMethodBeat.o(14476);
    return false;
  }
  
  public final boolean bad()
  {
    AppMethodBeat.i(14477);
    if (this.eys.getVisibility() == 0)
    {
      AppMethodBeat.o(14477);
      return true;
    }
    AppMethodBeat.o(14477);
    return false;
  }
  
  public final void bae()
  {
    AppMethodBeat.i(14478);
    aRm();
    setVisibility(8);
    AppMethodBeat.o(14478);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(14479);
    super.onConfigurationChanged(paramConfiguration);
    if (this.eys != null)
    {
      baf();
      this.eys.refresh();
    }
    AppMethodBeat.o(14479);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(14483);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.kjy < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.kjy)
    {
      this.kjy = paramInt1;
      this.kjz = paramInt4;
      AppMethodBeat.o(14483);
      return;
    }
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(14481);
    super.p(paramBoolean, paramInt);
    if ((this.kjA != paramInt) && (paramInt != 0))
    {
      this.kjA = paramInt;
      j.z(getContext(), paramInt);
      baf();
    }
    AppMethodBeat.o(14481);
  }
  
  public final void release()
  {
    AppMethodBeat.i(152664);
    if (this.eys != null)
    {
      this.eys.Ay();
      this.eys.destroy();
    }
    AppMethodBeat.o(152664);
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(14475);
    this.kju = paramMMEditText;
    paramMMEditText.setOnClickListener(new MPSmileyFooter.1(this));
    paramMMEditText.setOnEditorActionListener(new MPSmileyFooter.2(this));
    AppMethodBeat.o(14475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter
 * JD-Core Version:    0.7.0.1
 */