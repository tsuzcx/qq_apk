package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.dh;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView lCL;
  private TextView upc;
  private ImageView upd;
  private LinearLayout upe;
  private ah upf;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42126);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.upf == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    if (paramView.getId() == 2131302466)
    {
      if (!bt.isNullOrNil(this.upf.ugJ.uhp))
      {
        i = c.aB(getContext(), this.upf.ugJ.uhp);
        f.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.upf.ufG));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if ((i < 0) || (i > this.upf.ugJ.ufF.size() - 1))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    paramView = (ar)this.upf.ugJ.ufF.get(i);
    if (!bt.isNullOrNil(paramView.ueY))
    {
      int j = c.aB(getContext(), paramView.ueY);
      f.a(getContext(), 10, 1023, i + 1, j, paramView.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(this.upf.ufG));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42126);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42124);
    super.onFinishInflate();
    this.lCL = ((TextView)findViewById(2131305902));
    this.upc = ((TextView)findViewById(2131302466));
    this.upd = ((ImageView)findViewById(2131302455));
    this.upe = ((LinearLayout)findViewById(2131300475));
    this.upc.setOnClickListener(this);
    AppMethodBeat.o(42124);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42125);
    if ((paramd == null) || (paramd.uaW == null) || (paramd.uaW.ugJ == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42125);
      return;
    }
    ah localah = paramd.uaW;
    setVisibility(0);
    this.upf = localah;
    if (!bt.isNullOrNil(localah.ugJ.Title))
    {
      this.lCL.setText(localah.ugJ.Title);
      this.lCL.setVisibility(0);
      if (bt.isNullOrNil(localah.ugJ.ugP)) {
        break label347;
      }
      this.upd.setVisibility(0);
      this.upc.setVisibility(0);
      this.upc.setText(localah.ugJ.ugP);
    }
    for (;;)
    {
      this.upe.removeAllViews();
      if (bt.hj(localah.ugJ.ufF)) {
        break label368;
      }
      Iterator localIterator = localah.ugJ.ufF.iterator();
      while (localIterator.hasNext())
      {
        ar localar = (ar)localIterator.next();
        Object localObject = LayoutInflater.from(getContext()).inflate(2131494254, this, false);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(Integer.valueOf(localah.ugJ.ufF.indexOf(localar)));
        this.upe.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131303852);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131303849);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131303851);
        localObject = (TextView)((View)localObject).findViewById(2131303848);
        localTextView1.setVisibility(8);
        e.dav().l(localImageView, localar.uhg);
        localTextView2.setText(localar.Title);
        ((TextView)localObject).setText(localar.Desc);
      }
      this.lCL.setVisibility(8);
      break;
      label347:
      this.upc.setVisibility(8);
      this.upd.setVisibility(8);
    }
    label368:
    if (!paramd.uaY)
    {
      com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1023, paramd.position, paramd.uaW.iht, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wk(paramd.uaW.ufG));
      paramd.uaY = true;
    }
    AppMethodBeat.o(42125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */