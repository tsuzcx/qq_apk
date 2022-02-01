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
import com.tencent.mm.sdk.platformtools.bs;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView ozi;
  private af tqI;
  private TextView tqN;
  private TextView tqO;
  private LinearLayout tqP;
  private TextView tqQ;
  private TextView tqR;
  private TextView tqS;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void GE(int paramInt)
  {
    AppMethodBeat.i(42134);
    if (paramInt == 1) {}
    for (String str = a.ae(this.tqI.thP, "clickType", "leftCorner");; str = a.ae(this.tqI.thP, "clickType", "rightCorner"))
    {
      com.tencent.mm.game.report.e.a(getContext(), 10, 1024, this.tqI.thR, 7, this.tqI.hOf, GameIndexListView.getSourceScene(), str);
      AppMethodBeat.o(42134);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42133);
    if (this.tqI == null)
    {
      AppMethodBeat.o(42133);
      return;
    }
    if ((paramView.getId() == 2131301390) || (paramView.getId() == 2131301391) || (paramView.getId() == 2131297017))
    {
      if ((this.tqI.tiP != null) && (!bs.isNullOrNil(this.tqI.tiP.thh)))
      {
        c.ay(getContext(), this.tqI.tiP.thh);
        GE(1);
        AppMethodBeat.o(42133);
      }
    }
    else if ((paramView.getId() == 2131304196) && (this.tqI.tiQ != null) && (!bs.isNullOrNil(this.tqI.tiQ.thh)))
    {
      c.ay(getContext(), this.tqI.tiQ.thh);
      GE(2);
    }
    AppMethodBeat.o(42133);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42131);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494307, this, true);
    this.tqN = ((TextView)localView.findViewById(2131301390));
    this.tqO = ((TextView)localView.findViewById(2131301391));
    this.tqP = ((LinearLayout)localView.findViewById(2131297017));
    this.ozi = ((ImageView)localView.findViewById(2131296996));
    this.tqQ = ((TextView)localView.findViewById(2131302858));
    this.tqR = ((TextView)localView.findViewById(2131306231));
    this.tqS = ((TextView)localView.findViewById(2131304196));
    this.tqN.setOnClickListener(this);
    this.tqO.setOnClickListener(this);
    this.tqP.setOnClickListener(this);
    this.tqS.setOnClickListener(this);
    AppMethodBeat.o(42131);
  }
  
  public void setData(af paramaf)
  {
    AppMethodBeat.i(42132);
    if ((paramaf == null) || ((paramaf.tiP == null) && (paramaf.tiQ == null)))
    {
      setVisibility(8);
      AppMethodBeat.o(42132);
      return;
    }
    this.tqI = paramaf;
    setVisibility(0);
    this.tqN.setVisibility(8);
    this.tqO.setVisibility(8);
    this.tqP.setVisibility(8);
    if (paramaf.tiP != null) {
      switch (paramaf.tiP.tib)
      {
      }
    }
    while (paramaf.tiQ != null)
    {
      this.tqS.setText(paramaf.tiQ.Desc);
      this.tqS.setVisibility(0);
      AppMethodBeat.o(42132);
      return;
      this.tqN.setVisibility(0);
      this.tqN.setText(paramaf.tiP.Desc);
      continue;
      this.tqO.setVisibility(0);
      this.tqO.setText(paramaf.tiP.Desc);
      continue;
      this.tqP.setVisibility(0);
      if (!bs.isNullOrNil(paramaf.tiP.tia))
      {
        e.a.a locala = new e.a.a();
        locala.gLt = true;
        com.tencent.mm.plugin.game.f.e.cRL().a(this.ozi, paramaf.tiP.tia, locala.cRM());
        this.ozi.setVisibility(0);
      }
      this.tqQ.setText(paramaf.tiP.Name);
      this.tqR.setText(paramaf.tiP.Desc);
    }
    this.tqS.setVisibility(8);
    AppMethodBeat.o(42132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */