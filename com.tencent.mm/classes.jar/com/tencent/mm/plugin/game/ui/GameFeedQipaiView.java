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
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.cz;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView lfN;
  private TextView tqF;
  private ImageView tqG;
  private LinearLayout tqH;
  private af tqI;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42126);
    if (this.tqI == null)
    {
      AppMethodBeat.o(42126);
      return;
    }
    if (paramView.getId() == 2131302466)
    {
      if (!bs.isNullOrNil(this.tqI.tiO.tjp))
      {
        i = c.ay(getContext(), this.tqI.tiO.tjp);
        com.tencent.mm.game.report.e.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), a.tu(this.tqI.thP));
      }
      AppMethodBeat.o(42126);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if ((i < 0) || (i > this.tqI.tiO.thO.size() - 1))
    {
      AppMethodBeat.o(42126);
      return;
    }
    paramView = (ap)this.tqI.tiO.thO.get(i);
    if (!bs.isNullOrNil(paramView.thh))
    {
      int j = c.ay(getContext(), paramView.thh);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1023, i + 1, j, paramView.hOf, GameIndexListView.getSourceScene(), a.tu(this.tqI.thP));
    }
    AppMethodBeat.o(42126);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42124);
    super.onFinishInflate();
    this.lfN = ((TextView)findViewById(2131305902));
    this.tqF = ((TextView)findViewById(2131302466));
    this.tqG = ((ImageView)findViewById(2131302455));
    this.tqH = ((LinearLayout)findViewById(2131300475));
    this.tqF.setOnClickListener(this);
    AppMethodBeat.o(42124);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42125);
    if ((paramd == null) || (paramd.tdg == null) || (paramd.tdg.tiO == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42125);
      return;
    }
    af localaf = paramd.tdg;
    setVisibility(0);
    this.tqI = localaf;
    if (!bs.isNullOrNil(localaf.tiO.Title))
    {
      this.lfN.setText(localaf.tiO.Title);
      this.lfN.setVisibility(0);
      if (bs.isNullOrNil(localaf.tiO.tiU)) {
        break label347;
      }
      this.tqG.setVisibility(0);
      this.tqF.setVisibility(0);
      this.tqF.setText(localaf.tiO.tiU);
    }
    for (;;)
    {
      this.tqH.removeAllViews();
      if (bs.gY(localaf.tiO.thO)) {
        break label368;
      }
      Iterator localIterator = localaf.tiO.thO.iterator();
      while (localIterator.hasNext())
      {
        ap localap = (ap)localIterator.next();
        Object localObject = LayoutInflater.from(getContext()).inflate(2131494254, this, false);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(Integer.valueOf(localaf.tiO.thO.indexOf(localap)));
        this.tqH.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131303852);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131303849);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131303851);
        localObject = (TextView)((View)localObject).findViewById(2131303848);
        localTextView1.setVisibility(8);
        com.tencent.mm.plugin.game.f.e.cRL().l(localImageView, localap.tjl);
        localTextView2.setText(localap.Title);
        ((TextView)localObject).setText(localap.Desc);
      }
      this.lfN.setVisibility(8);
      break;
      label347:
      this.tqF.setVisibility(8);
      this.tqG.setVisibility(8);
    }
    label368:
    if (!paramd.tdi)
    {
      a.a(getContext(), 10, 1023, paramd.position, paramd.tdg.hOf, GameIndexListView.getSourceScene(), a.tu(paramd.tdg.thP));
      paramd.tdi = true;
    }
    AppMethodBeat.o(42125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */