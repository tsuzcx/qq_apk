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
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.az;
import com.tencent.mm.plugin.game.protobuf.dq;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView CWI;
  private ImageView CWJ;
  private LinearLayout CWK;
  private ap CWL;
  private TextView pPT;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42126);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.CWL == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    if (paramView.getId() == g.e.CkL)
    {
      if (!Util.isNullOrNil(this.CWL.COF.CPo))
      {
        i = c.aY(getContext(), this.CWL.COF.CPo);
        g.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CWL.CNA));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if ((i < 0) || (i > this.CWL.COF.CNz.size() - 1))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    paramView = (az)this.CWL.COF.CNz.get(i);
    if (!Util.isNullOrNil(paramView.CMD))
    {
      int j = c.aY(getContext(), paramView.CMD);
      g.a(getContext(), 10, 1023, i + 1, j, paramView.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(this.CWL.CNA));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42126);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42124);
    super.onFinishInflate();
    this.pPT = ((TextView)findViewById(g.e.title));
    this.CWI = ((TextView)findViewById(g.e.CkL));
    this.CWJ = ((ImageView)findViewById(g.e.more_arrow));
    this.CWK = ((LinearLayout)findViewById(g.e.CjA));
    this.CWI.setOnClickListener(this);
    AppMethodBeat.o(42124);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42125);
    if ((paramd == null) || (paramd.CIr == null) || (paramd.CIr.COF == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42125);
      return;
    }
    ap localap = paramd.CIr;
    setVisibility(0);
    this.CWL = localap;
    if (!Util.isNullOrNil(localap.COF.fwr))
    {
      this.pPT.setText(localap.COF.fwr);
      this.pPT.setVisibility(0);
      if (Util.isNullOrNil(localap.COF.COL)) {
        break label352;
      }
      this.CWJ.setVisibility(0);
      this.CWI.setVisibility(0);
      this.CWI.setText(localap.COF.COL);
    }
    for (;;)
    {
      this.CWK.removeAllViews();
      if (Util.isNullOrNil(localap.COF.CNz)) {
        break label373;
      }
      Iterator localIterator = localap.COF.CNz.iterator();
      while (localIterator.hasNext())
      {
        az localaz = (az)localIterator.next();
        Object localObject = LayoutInflater.from(getContext()).inflate(g.f.Cmy, this, false);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(Integer.valueOf(localap.COF.CNz.indexOf(localaz)));
        this.CWK.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        TextView localTextView1 = (TextView)((View)localObject).findViewById(g.e.Cln);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(g.e.Clk);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(g.e.Clm);
        localObject = (TextView)((View)localObject).findViewById(g.e.Clj);
        localTextView1.setVisibility(8);
        e.eAa().o(localImageView, localaz.CPc);
        localTextView2.setText(localaz.fwr);
        ((TextView)localObject).setText(localaz.CMB);
      }
      this.pPT.setVisibility(8);
      break;
      label352:
      this.CWI.setVisibility(8);
      this.CWJ.setVisibility(8);
    }
    label373:
    if (!paramd.CIt)
    {
      com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1023, paramd.position, paramd.CIr.lVG, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.Md(paramd.CIr.CNA));
      paramd.CIt = true;
    }
    AppMethodBeat.o(42125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */