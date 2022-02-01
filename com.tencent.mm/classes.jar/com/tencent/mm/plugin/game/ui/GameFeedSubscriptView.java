package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.p;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView nVN;
  private af siP;
  private TextView siU;
  private TextView siV;
  private LinearLayout siW;
  private TextView siX;
  private TextView siY;
  private TextView siZ;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void EI(int paramInt)
  {
    AppMethodBeat.i(42134);
    if (paramInt == 1) {}
    for (String str = a.ad(this.siP.rZW, "clickType", "leftCorner");; str = a.ad(this.siP.rZW, "clickType", "rightCorner"))
    {
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.siP.rZY, 7, this.siP.hnC, GameIndexListView.getSourceScene(), str);
      AppMethodBeat.o(42134);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42133);
    if (this.siP == null)
    {
      AppMethodBeat.o(42133);
      return;
    }
    if ((paramView.getId() == 2131301390) || (paramView.getId() == 2131301391) || (paramView.getId() == 2131297017))
    {
      if ((this.siP.saV != null) && (!bt.isNullOrNil(this.siP.saV.rZo)))
      {
        c.ax(getContext(), this.siP.saV.rZo);
        EI(1);
        AppMethodBeat.o(42133);
      }
    }
    else if ((paramView.getId() == 2131304196) && (this.siP.saW != null) && (!bt.isNullOrNil(this.siP.saW.rZo)))
    {
      c.ax(getContext(), this.siP.saW.rZo);
      EI(2);
    }
    AppMethodBeat.o(42133);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42131);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494307, this, true);
    this.siU = ((TextView)localView.findViewById(2131301390));
    this.siV = ((TextView)localView.findViewById(2131301391));
    this.siW = ((LinearLayout)localView.findViewById(2131297017));
    this.nVN = ((ImageView)localView.findViewById(2131296996));
    this.siX = ((TextView)localView.findViewById(2131302858));
    this.siY = ((TextView)localView.findViewById(2131306231));
    this.siZ = ((TextView)localView.findViewById(2131304196));
    this.siU.setOnClickListener(this);
    this.siV.setOnClickListener(this);
    this.siW.setOnClickListener(this);
    this.siZ.setOnClickListener(this);
    AppMethodBeat.o(42131);
  }
  
  public void setData(af paramaf)
  {
    AppMethodBeat.i(42132);
    if ((paramaf == null) || ((paramaf.saV == null) && (paramaf.saW == null)))
    {
      setVisibility(8);
      AppMethodBeat.o(42132);
      return;
    }
    this.siP = paramaf;
    setVisibility(0);
    this.siU.setVisibility(8);
    this.siV.setVisibility(8);
    this.siW.setVisibility(8);
    if (paramaf.saV != null) {
      switch (paramaf.saV.sai)
      {
      }
    }
    while (paramaf.saW != null)
    {
      this.siZ.setText(paramaf.saW.Desc);
      this.siZ.setVisibility(0);
      AppMethodBeat.o(42132);
      return;
      this.siU.setVisibility(0);
      this.siU.setText(paramaf.saV.Desc);
      continue;
      this.siV.setVisibility(0);
      this.siV.setText(paramaf.saV.Desc);
      continue;
      this.siW.setVisibility(0);
      if (!bt.isNullOrNil(paramaf.saV.sah))
      {
        e.a.a locala = new e.a.a();
        locala.gkG = true;
        com.tencent.mm.plugin.game.f.e.cEB().a(this.nVN, paramaf.saV.sah, locala.cEC());
        this.nVN.setVisibility(0);
      }
      this.siX.setText(paramaf.saV.Name);
      this.siY.setText(paramaf.saV.Desc);
    }
    this.siZ.setVisibility(8);
    AppMethodBeat.o(42132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */