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
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.protobuf.at;
import com.tencent.mm.plugin.game.protobuf.dp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameRecomBlockView
  extends LinearLayout
  implements View.OnClickListener
{
  int CKU;
  private ViewGroup mContainer;
  private Context mContext;
  private LayoutInflater mInflater;
  
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
  
  final void a(at paramat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42350);
    this.mContainer.removeAllViews();
    if (Util.isNullOrNil(paramat.COK))
    {
      setVisibility(8);
      AppMethodBeat.o(42350);
      return;
    }
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1021, 0, null, paramInt2, com.tencent.mm.plugin.game.c.a.Md(paramat.CNA));
    }
    this.mInflater.inflate(g.f.Cmx, this, true);
    Object localObject1 = (TextView)findViewById(g.e.Clo);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(g.e.Cll);
    Object localObject2 = findViewById(g.e.Clp);
    Object localObject3 = (TextView)findViewById(g.e.Clq);
    label157:
    int k;
    int i;
    label195:
    int j;
    Object localObject4;
    if (!Util.isNullOrNil(paramat.CNB))
    {
      ((TextView)localObject1).setText(paramat.CNB);
      if (Util.isNullOrNil(paramat.COL)) {
        break label514;
      }
      ((TextView)localObject3).setText(paramat.COL);
      ((View)localObject2).setTag(new a(null, 999, paramat.COM, paramat.CNA, "game_center_mygame_more"));
      ((View)localObject2).setOnClickListener(this);
      k = 0;
      i = 0;
      if (i >= paramat.COK.size()) {
        break label597;
      }
      localObject1 = (dp)paramat.COK.get(i);
      j = k;
      if (localObject1 != null)
      {
        if (localLinearLayout.getChildCount() >= 3) {
          break label597;
        }
        k += 1;
        localObject4 = (LinearLayout)this.mInflater.inflate(g.f.Cmy, this, false);
        ((LinearLayout)localObject4).setTag(new a(((dp)localObject1).lVG, k, ((dp)localObject1).CMD, ((dp)localObject1).CNA, "game_center_mygame_rank"));
        ((LinearLayout)localObject4).setOnClickListener(this);
        localLinearLayout.addView((View)localObject4, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        localObject2 = (TextView)((LinearLayout)localObject4).findViewById(g.e.Cln);
        localObject3 = (ImageView)((LinearLayout)localObject4).findViewById(g.e.Clk);
        TextView localTextView = (TextView)((LinearLayout)localObject4).findViewById(g.e.Clm);
        localObject4 = (TextView)((LinearLayout)localObject4).findViewById(g.e.Clj);
        switch (i)
        {
        default: 
          label396:
          ((TextView)localObject2).setText(((dp)localObject1).fwr);
          e.eAa().o((ImageView)localObject3, ((dp)localObject1).CMC);
          localTextView.setText(((dp)localObject1).CQz);
          if (!Util.isNullOrNil(((dp)localObject1).CMB)) {
            ((TextView)localObject4).setText(((dp)localObject1).CMB);
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
        com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1021, k, ((dp)localObject1).lVG, paramInt2, com.tencent.mm.plugin.game.c.a.Md(((dp)localObject1).CNA));
        j = k;
      }
      i += 1;
      k = j;
      break label195;
      ((TextView)localObject1).setVisibility(8);
      break;
      label514:
      ((TextView)localObject3).setVisibility(8);
      break label157;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(g.b.CgC));
      break label396;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(g.b.CgD));
      break label396;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(g.b.CgE));
      break label396;
      ((TextView)localObject4).setVisibility(8);
    }
    label597:
    paramat = new View(getContext());
    paramat.setBackgroundColor(getContext().getResources().getColor(g.b.Cgz));
    addView(paramat, new LinearLayout.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(getContext(), 5)));
    AppMethodBeat.o(42350);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42351);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      Log.w("MicroMsg.GameRecomBlockView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42351);
      return;
    }
    paramView = (a)paramView.getTag();
    if (Util.isNullOrNil(paramView.jumpUrl))
    {
      Log.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42351);
      return;
    }
    int i = c.I(this.mContext, paramView.jumpUrl, paramView.fUj);
    g.a(this.mContext, 10, 1021, paramView.CLN, i, paramView.appId, this.CKU, com.tencent.mm.plugin.game.c.a.Md(paramView.CIm));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42351);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42349);
    super.onFinishInflate();
    Log.i("MicroMsg.GameRecomBlockView", "initView finished");
    AppMethodBeat.o(42349);
  }
  
  static final class a
  {
    public String CIm;
    public int CLN;
    public String appId;
    public String fUj;
    public String jumpUrl;
    
    public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.appId = paramString1;
      this.CLN = paramInt;
      this.jumpUrl = paramString2;
      this.CIm = paramString3;
      this.fUj = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRecomBlockView
 * JD-Core Version:    0.7.0.1
 */