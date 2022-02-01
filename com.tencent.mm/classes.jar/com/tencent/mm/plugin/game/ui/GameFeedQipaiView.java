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
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.ay;
import com.tencent.mm.plugin.game.protobuf.dp;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView mPa;
  private ao xSA;
  private TextView xSx;
  private ImageView xSy;
  private LinearLayout xSz;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42126);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.xSA == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    if (paramView.getId() == 2131304876)
    {
      if (!Util.isNullOrNil(this.xSA.xKy.xLg))
      {
        i = c.aQ(getContext(), this.xSA.xKy.xLg);
        f.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xSA.xJt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if ((i < 0) || (i > this.xSA.xKy.xJs.size() - 1))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    paramView = (ay)this.xSA.xKy.xJs.get(i);
    if (!Util.isNullOrNil(paramView.xIy))
    {
      int j = c.aQ(getContext(), paramView.xIy);
      f.a(getContext(), 10, 1023, i + 1, j, paramView.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xSA.xJt));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42126);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42124);
    super.onFinishInflate();
    this.mPa = ((TextView)findViewById(2131309195));
    this.xSx = ((TextView)findViewById(2131304876));
    this.xSy = ((ImageView)findViewById(2131304861));
    this.xSz = ((LinearLayout)findViewById(2131301998));
    this.xSx.setOnClickListener(this);
    AppMethodBeat.o(42124);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42125);
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKy == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42125);
      return;
    }
    ao localao = paramd.xEq;
    setVisibility(0);
    this.xSA = localao;
    if (!Util.isNullOrNil(localao.xKy.Title))
    {
      this.mPa.setText(localao.xKy.Title);
      this.mPa.setVisibility(0);
      if (Util.isNullOrNil(localao.xKy.xKE)) {
        break label347;
      }
      this.xSy.setVisibility(0);
      this.xSx.setVisibility(0);
      this.xSx.setText(localao.xKy.xKE);
    }
    for (;;)
    {
      this.xSz.removeAllViews();
      if (Util.isNullOrNil(localao.xKy.xJs)) {
        break label368;
      }
      Iterator localIterator = localao.xKy.xJs.iterator();
      while (localIterator.hasNext())
      {
        ay localay = (ay)localIterator.next();
        Object localObject = LayoutInflater.from(getContext()).inflate(2131494815, this, false);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(Integer.valueOf(localao.xKy.xJs.indexOf(localay)));
        this.xSz.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131306661);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(2131306658);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131306660);
        localObject = (TextView)((View)localObject).findViewById(2131306657);
        localTextView1.setVisibility(8);
        e.dWR().o(localImageView, localay.xKV);
        localTextView2.setText(localay.Title);
        ((TextView)localObject).setText(localay.Desc);
      }
      this.mPa.setVisibility(8);
      break;
      label347:
      this.xSx.setVisibility(8);
      this.xSy.setVisibility(8);
    }
    label368:
    if (!paramd.xEs)
    {
      com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1023, paramd.position, paramd.xEq.jfi, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(paramd.xEq.xJt));
      paramd.xEs = true;
    }
    AppMethodBeat.o(42125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */