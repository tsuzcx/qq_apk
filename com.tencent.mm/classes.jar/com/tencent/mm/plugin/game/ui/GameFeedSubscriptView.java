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
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.s;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.sdk.platformtools.bu;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView pjj;
  private an uAB;
  private TextView uAG;
  private TextView uAH;
  private LinearLayout uAI;
  private TextView uAJ;
  private TextView uAK;
  private TextView uAL;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void Iv(int paramInt)
  {
    AppMethodBeat.i(42134);
    if (paramInt == 1) {}
    for (String str = com.tencent.mm.plugin.game.e.a.ak(this.uAB.ura, "clickType", "leftCorner");; str = com.tencent.mm.plugin.game.e.a.ak(this.uAB.ura, "clickType", "rightCorner"))
    {
      f.a(getContext(), 10, 1024, this.uAB.urc, 7, this.uAB.ikm, GameIndexListView.getSourceScene(), str);
      AppMethodBeat.o(42134);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42133);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (this.uAB == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
    }
    if ((paramView.getId() == 2131301390) || (paramView.getId() == 2131301391) || (paramView.getId() == 2131297017)) {
      if ((this.uAB.ush != null) && (!bu.isNullOrNil(this.uAB.ush.uqf)))
      {
        c.aD(getContext(), this.uAB.ush.uqf);
        Iv(1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
      if ((paramView.getId() == 2131304196) && (this.uAB.usi != null) && (!bu.isNullOrNil(this.uAB.usi.uqf)))
      {
        c.aD(getContext(), this.uAB.usi.uqf);
        Iv(2);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42131);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494307, this, true);
    this.uAG = ((TextView)localView.findViewById(2131301390));
    this.uAH = ((TextView)localView.findViewById(2131301391));
    this.uAI = ((LinearLayout)localView.findViewById(2131297017));
    this.pjj = ((ImageView)localView.findViewById(2131296996));
    this.uAJ = ((TextView)localView.findViewById(2131302858));
    this.uAK = ((TextView)localView.findViewById(2131306231));
    this.uAL = ((TextView)localView.findViewById(2131304196));
    this.uAG.setOnClickListener(this);
    this.uAH.setOnClickListener(this);
    this.uAI.setOnClickListener(this);
    this.uAL.setOnClickListener(this);
    AppMethodBeat.o(42131);
  }
  
  public void setData(an paraman)
  {
    AppMethodBeat.i(42132);
    if ((paraman == null) || ((paraman.ush == null) && (paraman.usi == null)))
    {
      setVisibility(8);
      AppMethodBeat.o(42132);
      return;
    }
    this.uAB = paraman;
    setVisibility(0);
    this.uAG.setVisibility(8);
    this.uAH.setVisibility(8);
    this.uAI.setVisibility(8);
    if (paraman.ush != null) {
      switch (paraman.ush.uro)
      {
      }
    }
    while (paraman.usi != null)
    {
      this.uAL.setText(paraman.usi.Desc);
      this.uAL.setVisibility(0);
      AppMethodBeat.o(42132);
      return;
      this.uAG.setVisibility(0);
      this.uAG.setText(paraman.ush.Desc);
      continue;
      this.uAH.setVisibility(0);
      this.uAH.setText(paraman.ush.Desc);
      continue;
      this.uAI.setVisibility(0);
      if (!bu.isNullOrNil(paraman.ush.urn))
      {
        e.a.a locala = new e.a.a();
        locala.hhW = true;
        e.ddh().a(this.pjj, paraman.ush.urn, locala.ddi());
        this.pjj.setVisibility(0);
      }
      this.uAJ.setText(paraman.ush.Name);
      this.uAK.setText(paraman.ush.Desc);
    }
    this.uAL.setVisibility(8);
    AppMethodBeat.o(42132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */