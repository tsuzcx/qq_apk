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
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.protobuf.au;
import com.tencent.mm.plugin.game.protobuf.dt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameRecomBlockView
  extends LinearLayout
  implements View.OnClickListener
{
  int IFc;
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
  
  final void a(au paramau, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42350);
    this.mContainer.removeAllViews();
    if (Util.isNullOrNil(paramau.IIU))
    {
      setVisibility(8);
      AppMethodBeat.o(42350);
      return;
    }
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1021, 0, null, paramInt2, com.tencent.mm.plugin.game.c.a.EM(paramau.IHI));
    }
    this.mInflater.inflate(h.f.HYF, this, true);
    Object localObject1 = (TextView)findViewById(h.e.HXw);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(h.e.HXt);
    Object localObject2 = findViewById(h.e.HXx);
    Object localObject3 = (TextView)findViewById(h.e.HXy);
    label157:
    int k;
    int i;
    label195:
    int j;
    Object localObject4;
    if (!Util.isNullOrNil(paramau.IHJ))
    {
      ((TextView)localObject1).setText(paramau.IHJ);
      if (Util.isNullOrNil(paramau.IIV)) {
        break label514;
      }
      ((TextView)localObject3).setText(paramau.IIV);
      ((View)localObject2).setTag(new a(null, 999, paramau.IIW, paramau.IHI, "game_center_mygame_more"));
      ((View)localObject2).setOnClickListener(this);
      k = 0;
      i = 0;
      if (i >= paramau.IIU.size()) {
        break label597;
      }
      localObject1 = (dt)paramau.IIU.get(i);
      j = k;
      if (localObject1 != null)
      {
        if (localLinearLayout.getChildCount() >= 3) {
          break label597;
        }
        k += 1;
        localObject4 = (LinearLayout)this.mInflater.inflate(h.f.HYG, this, false);
        ((LinearLayout)localObject4).setTag(new a(((dt)localObject1).oOI, k, ((dt)localObject1).IGI, ((dt)localObject1).IHI, "game_center_mygame_rank"));
        ((LinearLayout)localObject4).setOnClickListener(this);
        localLinearLayout.addView((View)localObject4, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        localObject2 = (TextView)((LinearLayout)localObject4).findViewById(h.e.HXv);
        localObject3 = (ImageView)((LinearLayout)localObject4).findViewById(h.e.HXs);
        TextView localTextView = (TextView)((LinearLayout)localObject4).findViewById(h.e.HXu);
        localObject4 = (TextView)((LinearLayout)localObject4).findViewById(h.e.HXr);
        switch (i)
        {
        default: 
          label396:
          ((TextView)localObject2).setText(((dt)localObject1).hAP);
          e.fIb().p((ImageView)localObject3, ((dt)localObject1).IGH);
          localTextView.setText(((dt)localObject1).IKJ);
          if (!Util.isNullOrNil(((dt)localObject1).IGG)) {
            ((TextView)localObject4).setText(((dt)localObject1).IGG);
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
        com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1021, k, ((dt)localObject1).oOI, paramInt2, com.tencent.mm.plugin.game.c.a.EM(((dt)localObject1).IHI));
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
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(h.b.HSL));
      break label396;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(h.b.HSM));
      break label396;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(h.b.HSN));
      break label396;
      ((TextView)localObject4).setVisibility(8);
    }
    label597:
    paramau = new View(getContext());
    paramau.setBackgroundColor(getContext().getResources().getColor(h.b.HSI));
    addView(paramau, new LinearLayout.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(getContext(), 5)));
    AppMethodBeat.o(42350);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42351);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    int i = c.I(this.mContext, paramView.jumpUrl, paramView.iag);
    g.a(this.mContext, 10, 1021, paramView.IFU, i, paramView.appId, this.IFc, com.tencent.mm.plugin.game.c.a.EM(paramView.ICw));
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
    public String ICw;
    public int IFU;
    public String appId;
    public String iag;
    public String jumpUrl;
    
    public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.appId = paramString1;
      this.IFU = paramInt;
      this.jumpUrl = paramString2;
      this.ICw = paramString3;
      this.iag = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRecomBlockView
 * JD-Core Version:    0.7.0.1
 */