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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView kEu;
  private TextView siM;
  private ImageView siN;
  private LinearLayout siO;
  private af siP;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42126);
    if (this.siP == null)
    {
      AppMethodBeat.o(42126);
      return;
    }
    if (paramView.getId() == 2131302466)
    {
      if (!bt.isNullOrNil(this.siP.saU.sbv))
      {
        i = c.ax(getContext(), this.siP.saU.sbv);
        com.tencent.mm.game.report.e.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), a.qh(this.siP.rZW));
      }
      AppMethodBeat.o(42126);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if ((i < 0) || (i > this.siP.saU.rZV.size() - 1))
    {
      AppMethodBeat.o(42126);
      return;
    }
    paramView = (ap)this.siP.saU.rZV.get(i);
    if (!bt.isNullOrNil(paramView.rZo))
    {
      int j = c.ax(getContext(), paramView.rZo);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1023, i + 1, j, paramView.hnC, GameIndexListView.getSourceScene(), a.qh(this.siP.rZW));
    }
    AppMethodBeat.o(42126);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42124);
    super.onFinishInflate();
    this.kEu = ((TextView)findViewById(2131305902));
    this.siM = ((TextView)findViewById(2131302466));
    this.siN = ((ImageView)findViewById(2131302455));
    this.siO = ((LinearLayout)findViewById(2131300475));
    this.siM.setOnClickListener(this);
    AppMethodBeat.o(42124);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42125);
    if ((paramd == null) || (paramd.rVo == null) || (paramd.rVo.saU == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42125);
      return;
    }
    af localaf = paramd.rVo;
    setVisibility(0);
    this.siP = localaf;
    if (!bt.isNullOrNil(localaf.saU.Title))
    {
      this.kEu.setText(localaf.saU.Title);
      this.kEu.setVisibility(0);
      if (bt.isNullOrNil(localaf.saU.sba)) {
        break label347;
      }
      this.siN.setVisibility(0);
      this.siM.setVisibility(0);
      this.siM.setText(localaf.saU.sba);
    }
    for (;;)
    {
      this.siO.removeAllViews();
      if (bt.gL(localaf.saU.rZV)) {
        break label368;
      }
      Iterator localIterator = localaf.saU.rZV.iterator();
      while (localIterator.hasNext())
      {
        ap localap = (ap)localIterator.next();
        Object localObject = LayoutInflater.from(getContext()).inflate(2131494254, this, false);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(Integer.valueOf(localaf.saU.rZV.indexOf(localap)));
        this.siO.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131303852);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131303849);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131303851);
        localObject = (TextView)((View)localObject).findViewById(2131303848);
        localTextView1.setVisibility(8);
        com.tencent.mm.plugin.game.f.e.cEB().l(localImageView, localap.sbr);
        localTextView2.setText(localap.Title);
        ((TextView)localObject).setText(localap.Desc);
      }
      this.kEu.setVisibility(8);
      break;
      label347:
      this.siM.setVisibility(8);
      this.siN.setVisibility(8);
    }
    label368:
    if (!paramd.rVq)
    {
      a.a(getContext(), 10, 1023, paramd.position, paramd.rVo.hnC, GameIndexListView.getSourceScene(), a.qh(paramd.rVo.rZW));
      paramd.rVq = true;
    }
    AppMethodBeat.o(42125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */