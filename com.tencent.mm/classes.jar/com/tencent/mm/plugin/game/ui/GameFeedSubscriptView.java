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
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.p;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView pcD;
  private ah upf;
  private TextView upk;
  private TextView upl;
  private LinearLayout upm;
  private TextView upn;
  private TextView upo;
  private TextView upp;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void HX(int paramInt)
  {
    AppMethodBeat.i(42134);
    if (paramInt == 1) {}
    for (String str = com.tencent.mm.plugin.game.e.a.aj(this.upf.ufG, "clickType", "leftCorner");; str = com.tencent.mm.plugin.game.e.a.aj(this.upf.ufG, "clickType", "rightCorner"))
    {
      f.a(getContext(), 10, 1024, this.upf.ufI, 7, this.upf.iht, GameIndexListView.getSourceScene(), str);
      AppMethodBeat.o(42134);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42133);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.upf == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
    }
    if ((paramView.getId() == 2131301390) || (paramView.getId() == 2131301391) || (paramView.getId() == 2131297017)) {
      if ((this.upf.ugK != null) && (!bt.isNullOrNil(this.upf.ugK.ueY)))
      {
        c.aB(getContext(), this.upf.ugK.ueY);
        HX(1);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedSubscriptView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42133);
      return;
      if ((paramView.getId() == 2131304196) && (this.upf.ugL != null) && (!bt.isNullOrNil(this.upf.ugL.ueY)))
      {
        c.aB(getContext(), this.upf.ugL.ueY);
        HX(2);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42131);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131494307, this, true);
    this.upk = ((TextView)localView.findViewById(2131301390));
    this.upl = ((TextView)localView.findViewById(2131301391));
    this.upm = ((LinearLayout)localView.findViewById(2131297017));
    this.pcD = ((ImageView)localView.findViewById(2131296996));
    this.upn = ((TextView)localView.findViewById(2131302858));
    this.upo = ((TextView)localView.findViewById(2131306231));
    this.upp = ((TextView)localView.findViewById(2131304196));
    this.upk.setOnClickListener(this);
    this.upl.setOnClickListener(this);
    this.upm.setOnClickListener(this);
    this.upp.setOnClickListener(this);
    AppMethodBeat.o(42131);
  }
  
  public void setData(ah paramah)
  {
    AppMethodBeat.i(42132);
    if ((paramah == null) || ((paramah.ugK == null) && (paramah.ugL == null)))
    {
      setVisibility(8);
      AppMethodBeat.o(42132);
      return;
    }
    this.upf = paramah;
    setVisibility(0);
    this.upk.setVisibility(8);
    this.upl.setVisibility(8);
    this.upm.setVisibility(8);
    if (paramah.ugK != null) {
      switch (paramah.ugK.ufS)
      {
      }
    }
    while (paramah.ugL != null)
    {
      this.upp.setText(paramah.ugL.Desc);
      this.upp.setVisibility(0);
      AppMethodBeat.o(42132);
      return;
      this.upk.setVisibility(0);
      this.upk.setText(paramah.ugK.Desc);
      continue;
      this.upl.setVisibility(0);
      this.upl.setText(paramah.ugK.Desc);
      continue;
      this.upm.setVisibility(0);
      if (!bt.isNullOrNil(paramah.ugK.ufR))
      {
        e.a.a locala = new e.a.a();
        locala.hfi = true;
        e.dav().a(this.pcD, paramah.ugK.ufR, locala.daw());
        this.pcD.setVisibility(0);
      }
      this.upn.setText(paramah.ugK.Name);
      this.upo.setText(paramah.ugK.Desc);
    }
    this.upp.setVisibility(8);
    AppMethodBeat.o(42132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */