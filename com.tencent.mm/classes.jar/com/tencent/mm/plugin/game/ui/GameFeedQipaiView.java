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
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.d.cy;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView iJG;
  private TextView nzm;
  private ImageView nzn;
  private LinearLayout nzo;
  private ad nzp;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111947);
    if (this.nzp == null)
    {
      AppMethodBeat.o(111947);
      return;
    }
    if (paramView.getId() == 2131824625)
    {
      if (!bo.isNullOrNil(this.nzp.nrr.nrQ))
      {
        i = com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nzp.nrr.nrQ);
        com.tencent.mm.game.report.c.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), a.lR(this.nzp.nqt));
      }
      AppMethodBeat.o(111947);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if ((i < 0) || (i > this.nzp.nrr.nqs.size() - 1))
    {
      AppMethodBeat.o(111947);
      return;
    }
    paramView = (an)this.nzp.nrr.nqs.get(i);
    if (!bo.isNullOrNil(paramView.npR))
    {
      int j = com.tencent.mm.plugin.game.f.c.ax(getContext(), paramView.npR);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1023, i + 1, j, paramView.fKw, GameIndexListView.getSourceScene(), a.lR(this.nzp.nqt));
    }
    AppMethodBeat.o(111947);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111945);
    super.onFinishInflate();
    this.iJG = ((TextView)findViewById(2131820680));
    this.nzm = ((TextView)findViewById(2131824625));
    this.nzn = ((ImageView)findViewById(2131824336));
    this.nzo = ((LinearLayout)findViewById(2131824626));
    this.nzm.setOnClickListener(this);
    AppMethodBeat.o(111945);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111946);
    if ((paramd == null) || (paramd.nmr == null) || (paramd.nmr.nrr == null))
    {
      setVisibility(8);
      AppMethodBeat.o(111946);
      return;
    }
    ad localad = paramd.nmr;
    setVisibility(0);
    this.nzp = localad;
    if (!bo.isNullOrNil(localad.nrr.Title))
    {
      this.iJG.setText(localad.nrr.Title);
      this.iJG.setVisibility(0);
      if (bo.isNullOrNil(localad.nrr.nrx)) {
        break label347;
      }
      this.nzn.setVisibility(0);
      this.nzm.setVisibility(0);
      this.nzm.setText(localad.nrr.nrx);
    }
    for (;;)
    {
      this.nzo.removeAllViews();
      if (bo.es(localad.nrr.nqs)) {
        break label368;
      }
      Iterator localIterator = localad.nrr.nqs.iterator();
      while (localIterator.hasNext())
      {
        an localan = (an)localIterator.next();
        Object localObject = LayoutInflater.from(getContext()).inflate(2130969702, this, false);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(Integer.valueOf(localad.nrr.nqs.indexOf(localan)));
        this.nzo.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131824453);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131824454);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131824455);
        localObject = (TextView)((View)localObject).findViewById(2131824456);
        localTextView1.setVisibility(8);
        e.bHE().i(localImageView, localan.nrM);
        localTextView2.setText(localan.Title);
        ((TextView)localObject).setText(localan.Desc);
      }
      this.iJG.setVisibility(8);
      break;
      label347:
      this.nzm.setVisibility(8);
      this.nzn.setVisibility(8);
    }
    label368:
    if (!paramd.nmt)
    {
      a.a(getContext(), 10, 1023, paramd.position, paramd.nmr.fKw, GameIndexListView.getSourceScene(), a.lR(paramd.nmr.nqt));
      paramd.nmt = true;
    }
    AppMethodBeat.o(111946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */