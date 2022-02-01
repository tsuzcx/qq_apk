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
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.do;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class GameRecomBlockView
  extends LinearLayout
  implements View.OnClickListener
{
  private ViewGroup mContainer;
  private Context mContext;
  private LayoutInflater mInflater;
  int uoy;
  
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
  
  final void a(ar paramar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42350);
    this.mContainer.removeAllViews();
    if (bu.ht(paramar.usl))
    {
      setVisibility(8);
      AppMethodBeat.o(42350);
      return;
    }
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, 0, null, paramInt2, com.tencent.mm.plugin.game.e.a.wT(paramar.ura));
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
    if (!bu.isNullOrNil(paramar.urb))
    {
      ((TextView)localObject1).setText(paramar.urb);
      if (bu.isNullOrNil(paramar.usm)) {
        break label506;
      }
      ((TextView)localObject3).setText(paramar.usm);
      ((View)localObject2).setTag(new a(null, 999, paramar.usn, paramar.ura, "game_center_mygame_more"));
      ((View)localObject2).setOnClickListener(this);
      k = 0;
      i = 0;
      if (i >= paramar.usl.size()) {
        break label586;
      }
      localObject1 = (do)paramar.usl.get(i);
      j = k;
      if (localObject1 != null)
      {
        if (localLinearLayout.getChildCount() >= 3) {
          break label586;
        }
        k += 1;
        localObject4 = (LinearLayout)this.mInflater.inflate(2131494254, this, false);
        ((LinearLayout)localObject4).setTag(new a(((do)localObject1).ikm, k, ((do)localObject1).uqf, ((do)localObject1).ura, "game_center_mygame_rank"));
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
          ((TextView)localObject2).setText(((do)localObject1).Title);
          e.ddh().l((ImageView)localObject3, ((do)localObject1).uqe);
          localTextView.setText(((do)localObject1).uuo);
          if (!bu.isNullOrNil(((do)localObject1).Desc)) {
            ((TextView)localObject4).setText(((do)localObject1).Desc);
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
        com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, k, ((do)localObject1).ikm, paramInt2, com.tencent.mm.plugin.game.e.a.wT(((do)localObject1).ura));
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
    paramar = new View(getContext());
    paramar.setBackgroundColor(getContext().getResources().getColor(2131100406));
    addView(paramar, new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5)));
    AppMethodBeat.o(42350);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42351);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ae.w("MicroMsg.GameRecomBlockView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42351);
      return;
    }
    paramView = (a)paramView.getTag();
    if (bu.isNullOrNil(paramView.jumpUrl))
    {
      ae.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42351);
      return;
    }
    int i = c.B(this.mContext, paramView.jumpUrl, paramView.dIz);
    f.a(this.mContext, 10, 1021, paramView.upr, i, paramView.appId, this.uoy, com.tencent.mm.plugin.game.e.a.wT(paramView.ulT));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42351);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42349);
    super.onFinishInflate();
    ae.i("MicroMsg.GameRecomBlockView", "initView finished");
    AppMethodBeat.o(42349);
  }
  
  static final class a
  {
    public String appId;
    public String dIz;
    public String jumpUrl;
    public String ulT;
    public int upr;
    
    public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.appId = paramString1;
      this.upr = paramInt;
      this.jumpUrl = paramString2;
      this.ulT = paramString3;
      this.dIz = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRecomBlockView
 * JD-Core Version:    0.7.0.1
 */