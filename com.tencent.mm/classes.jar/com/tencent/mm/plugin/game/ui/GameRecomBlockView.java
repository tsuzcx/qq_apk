package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.al;
import com.tencent.mm.plugin.game.d.dg;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class GameRecomBlockView
  extends LinearLayout
  implements View.OnClickListener
{
  private ViewGroup mContainer;
  private Context mContext;
  private LayoutInflater mInflater;
  int udq;
  
  public GameRecomBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42348);
    setOrientation(1);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mContainer = this;
    AppMethodBeat.o(42348);
  }
  
  final void a(al paramal, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42350);
    this.mContainer.removeAllViews();
    if (bt.hj(paramal.ugO))
    {
      setVisibility(8);
      AppMethodBeat.o(42350);
      return;
    }
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, 0, null, paramInt2, com.tencent.mm.plugin.game.e.a.wk(paramal.ufG));
    }
    this.mInflater.inflate(2131494253, this, true);
    Object localObject1 = (TextView)findViewById(2131303853);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131303850);
    Object localObject2 = findViewById(2131303854);
    Object localObject3 = (TextView)findViewById(2131303855);
    label152:
    int k;
    int i;
    label190:
    int j;
    Object localObject4;
    if (!bt.isNullOrNil(paramal.ufH))
    {
      ((TextView)localObject1).setText(paramal.ufH);
      if (bt.isNullOrNil(paramal.ugP)) {
        break label506;
      }
      ((TextView)localObject3).setText(paramal.ugP);
      ((View)localObject2).setTag(new a(null, 999, paramal.ugQ, paramal.ufG, "game_center_mygame_more"));
      ((View)localObject2).setOnClickListener(this);
      k = 0;
      i = 0;
      if (i >= paramal.ugO.size()) {
        break label586;
      }
      localObject1 = (dg)paramal.ugO.get(i);
      j = k;
      if (localObject1 != null)
      {
        if (localLinearLayout.getChildCount() >= 3) {
          break label586;
        }
        k += 1;
        localObject4 = (LinearLayout)this.mInflater.inflate(2131494254, this, false);
        ((LinearLayout)localObject4).setTag(new a(((dg)localObject1).iht, k, ((dg)localObject1).ueY, ((dg)localObject1).ufG, "game_center_mygame_rank"));
        ((LinearLayout)localObject4).setOnClickListener(this);
        localLinearLayout.addView((View)localObject4, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        localObject2 = (TextView)((LinearLayout)localObject4).findViewById(2131303852);
        localObject3 = (ImageView)((LinearLayout)localObject4).findViewById(2131303849);
        TextView localTextView = (TextView)((LinearLayout)localObject4).findViewById(2131303851);
        localObject4 = (TextView)((LinearLayout)localObject4).findViewById(2131303848);
        switch (i)
        {
        default: 
          label388:
          ((TextView)localObject2).setText(((dg)localObject1).Title);
          e.dav().l((ImageView)localObject3, ((dg)localObject1).ueX);
          localTextView.setText(((dg)localObject1).uiR);
          if (!bt.isNullOrNil(((dg)localObject1).Desc)) {
            ((TextView)localObject4).setText(((dg)localObject1).Desc);
          }
          break;
        }
      }
    }
    for (;;)
    {
      j = k;
      if (paramInt1 == 2)
      {
        com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, k, ((dg)localObject1).iht, paramInt2, com.tencent.mm.plugin.game.e.a.wk(((dg)localObject1).ufG));
        j = k;
      }
      i += 1;
      k = j;
      break label190;
      ((TextView)localObject1).setVisibility(8);
      break;
      label506:
      ((TextView)localObject3).setVisibility(8);
      break label152;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131100424));
      break label388;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131100425));
      break label388;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131100426));
      break label388;
      ((TextView)localObject4).setVisibility(8);
    }
    label586:
    paramal = new View(getContext());
    paramal.setBackgroundColor(getContext().getResources().getColor(2131100406));
    addView(paramal, new LinearLayout.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(getContext(), 5)));
    AppMethodBeat.o(42350);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42351);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ad.w("MicroMsg.GameRecomBlockView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42351);
      return;
    }
    paramView = (a)paramView.getTag();
    if (bt.isNullOrNil(paramView.jumpUrl))
    {
      ad.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42351);
      return;
    }
    int i = c.B(this.mContext, paramView.jumpUrl, paramView.dHu);
    f.a(this.mContext, 10, 1021, paramView.uek, i, paramView.appId, this.udq, com.tencent.mm.plugin.game.e.a.wk(paramView.uaR));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42351);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42349);
    super.onFinishInflate();
    ad.i("MicroMsg.GameRecomBlockView", "initView finished");
    AppMethodBeat.o(42349);
  }
  
  static final class a
  {
    public String appId;
    public String dHu;
    public String jumpUrl;
    public String uaR;
    public int uek;
    
    public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.appId = paramString1;
      this.uek = paramInt;
      this.jumpUrl = paramString2;
      this.uaR = paramString3;
      this.dHu = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRecomBlockView
 * JD-Core Version:    0.7.0.1
 */