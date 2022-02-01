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
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.ba;
import com.tencent.mm.plugin.game.protobuf.du;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView IQZ;
  private ImageView IRa;
  private LinearLayout IRb;
  private aq IRc;
  private TextView sUt;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42126);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.IRc == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    if (paramView.getId() == h.e.HWT)
    {
      if (!Util.isNullOrNil(this.IRc.IIP.IJy))
      {
        i = c.ba(getContext(), this.IRc.IIP.IJy);
        g.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.IRc.IHI));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if ((i < 0) || (i > this.IRc.IIP.IHH.size() - 1))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42126);
      return;
    }
    paramView = (ba)this.IRc.IIP.IHH.get(i);
    if (!Util.isNullOrNil(paramView.IGI))
    {
      int j = c.ba(getContext(), paramView.IGI);
      g.a(getContext(), 10, 1023, i + 1, j, paramView.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(this.IRc.IHI));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameFeedQipaiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42126);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42124);
    super.onFinishInflate();
    this.sUt = ((TextView)findViewById(h.e.title));
    this.IQZ = ((TextView)findViewById(h.e.HWT));
    this.IRa = ((ImageView)findViewById(h.e.more_arrow));
    this.IRb = ((LinearLayout)findViewById(h.e.HVI));
    this.IQZ.setOnClickListener(this);
    AppMethodBeat.o(42124);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42125);
    if ((paramd == null) || (paramd.ICB == null) || (paramd.ICB.IIP == null))
    {
      setVisibility(8);
      AppMethodBeat.o(42125);
      return;
    }
    aq localaq = paramd.ICB;
    setVisibility(0);
    this.IRc = localaq;
    if (!Util.isNullOrNil(localaq.IIP.hAP))
    {
      this.sUt.setText(localaq.IIP.hAP);
      this.sUt.setVisibility(0);
      if (Util.isNullOrNil(localaq.IIP.IIV)) {
        break label352;
      }
      this.IRa.setVisibility(0);
      this.IQZ.setVisibility(0);
      this.IQZ.setText(localaq.IIP.IIV);
    }
    for (;;)
    {
      this.IRb.removeAllViews();
      if (Util.isNullOrNil(localaq.IIP.IHH)) {
        break label373;
      }
      Iterator localIterator = localaq.IIP.IHH.iterator();
      while (localIterator.hasNext())
      {
        ba localba = (ba)localIterator.next();
        Object localObject = LayoutInflater.from(getContext()).inflate(h.f.HYG, this, false);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(Integer.valueOf(localaq.IIP.IHH.indexOf(localba)));
        this.IRb.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        TextView localTextView1 = (TextView)((View)localObject).findViewById(h.e.HXv);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(h.e.HXs);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(h.e.HXu);
        localObject = (TextView)((View)localObject).findViewById(h.e.HXr);
        localTextView1.setVisibility(8);
        e.fIb().p(localImageView, localba.IJm);
        localTextView2.setText(localba.hAP);
        ((TextView)localObject).setText(localba.IGG);
      }
      this.sUt.setVisibility(8);
      break;
      label352:
      this.IQZ.setVisibility(8);
      this.IRa.setVisibility(8);
    }
    label373:
    if (!paramd.ICD)
    {
      com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1023, paramd.position, paramd.ICB.oOI, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.c.a.EM(paramd.ICB.IHI));
      paramd.ICD = true;
    }
    AppMethodBeat.o(42125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */