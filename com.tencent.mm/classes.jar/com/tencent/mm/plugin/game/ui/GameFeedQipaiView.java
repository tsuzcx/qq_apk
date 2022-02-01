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
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.dp;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView lHk;
  private LinearLayout uAA;
  private an uAB;
  private TextView uAy;
  private ImageView uAz;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42126);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (this.uAB == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    if (paramView.getId() == 2131302466)
    {
      if (!bu.isNullOrNil(this.uAB.usg.usN))
      {
        i = c.aD(getContext(), this.uAB.usg.usN);
        f.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uAB.ura));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if ((i < 0) || (i > this.uAB.usg.uqZ.size() - 1))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    paramView = (ax)this.uAB.usg.uqZ.get(i);
    if (!bu.isNullOrNil(paramView.uqf))
    {
      int j = c.aD(getContext(), paramView.uqf);
      f.a(getContext(), 10, 1023, i + 1, j, paramView.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(this.uAB.ura));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42126);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42124);
    super.onFinishInflate();
    this.lHk = ((TextView)findViewById(2131305902));
    this.uAy = ((TextView)findViewById(2131302466));
    this.uAz = ((ImageView)findViewById(2131302455));
    this.uAA = ((LinearLayout)findViewById(2131300475));
    this.uAy.setOnClickListener(this);
    AppMethodBeat.o(42124);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42125);
    if ((paramd == null) || (paramd.ulY == null) || (paramd.ulY.usg == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42125);
      return;
    }
    an localan = paramd.ulY;
    setVisibility(0);
    this.uAB = localan;
    if (!bu.isNullOrNil(localan.usg.Title))
    {
      this.lHk.setText(localan.usg.Title);
      this.lHk.setVisibility(0);
      if (bu.isNullOrNil(localan.usg.usm)) {
        break label347;
      }
      this.uAz.setVisibility(0);
      this.uAy.setVisibility(0);
      this.uAy.setText(localan.usg.usm);
    }
    for (;;)
    {
      this.uAA.removeAllViews();
      if (bu.ht(localan.usg.uqZ)) {
        break label368;
      }
      Iterator localIterator = localan.usg.uqZ.iterator();
      while (localIterator.hasNext())
      {
        ax localax = (ax)localIterator.next();
        Object localObject = LayoutInflater.from(getContext()).inflate(2131494254, this, false);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(Integer.valueOf(localan.usg.uqZ.indexOf(localax)));
        this.uAA.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131303852);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131303849);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131303851);
        localObject = (TextView)((View)localObject).findViewById(2131303848);
        localTextView1.setVisibility(8);
        e.ddh().l(localImageView, localax.usD);
        localTextView2.setText(localax.Title);
        ((TextView)localObject).setText(localax.Desc);
      }
      this.lHk.setVisibility(8);
      break;
      label347:
      this.uAy.setVisibility(8);
      this.uAz.setVisibility(8);
    }
    label368:
    if (!paramd.uma)
    {
      com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1023, paramd.position, paramd.ulY.ikm, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.e.a.wT(paramd.ulY.ura));
      paramd.uma = true;
    }
    AppMethodBeat.o(42125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */