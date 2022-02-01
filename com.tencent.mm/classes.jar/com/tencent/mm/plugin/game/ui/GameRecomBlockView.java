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
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.protobuf.as;
import com.tencent.mm.plugin.game.protobuf.do;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameRecomBlockView
  extends LinearLayout
  implements View.OnClickListener
{
  private ViewGroup mContainer;
  private Context mContext;
  private LayoutInflater mInflater;
  int xGR;
  
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
  
  final void a(as paramas, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42350);
    this.mContainer.removeAllViews();
    if (Util.isNullOrNil(paramas.xKD))
    {
      setVisibility(8);
      AppMethodBeat.o(42350);
      return;
    }
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.d.a.b(this.mContext, 10, 1021, 0, null, paramInt2, com.tencent.mm.plugin.game.d.a.Fh(paramas.xJt));
    }
    this.mInflater.inflate(2131494814, this, true);
    Object localObject1 = (TextView)findViewById(2131306662);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131306659);
    Object localObject2 = findViewById(2131306663);
    Object localObject3 = (TextView)findViewById(2131306664);
    label152:
    int k;
    int i;
    label190:
    int j;
    Object localObject4;
    if (!Util.isNullOrNil(paramas.xJu))
    {
      ((TextView)localObject1).setText(paramas.xJu);
      if (Util.isNullOrNil(paramas.xKE)) {
        break label506;
      }
      ((TextView)localObject3).setText(paramas.xKE);
      ((View)localObject2).setTag(new a(null, 999, paramas.xKF, paramas.xJt, "game_center_mygame_more"));
      ((View)localObject2).setOnClickListener(this);
      k = 0;
      i = 0;
      if (i >= paramas.xKD.size()) {
        break label586;
      }
      localObject1 = (do)paramas.xKD.get(i);
      j = k;
      if (localObject1 != null)
      {
        if (localLinearLayout.getChildCount() >= 3) {
          break label586;
        }
        k += 1;
        localObject4 = (LinearLayout)this.mInflater.inflate(2131494815, this, false);
        ((LinearLayout)localObject4).setTag(new a(((do)localObject1).jfi, k, ((do)localObject1).xIy, ((do)localObject1).xJt, "game_center_mygame_rank"));
        ((LinearLayout)localObject4).setOnClickListener(this);
        localLinearLayout.addView((View)localObject4, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        localObject2 = (TextView)((LinearLayout)localObject4).findViewById(2131306661);
        localObject3 = (ImageView)((LinearLayout)localObject4).findViewById(2131306658);
        TextView localTextView = (TextView)((LinearLayout)localObject4).findViewById(2131306660);
        localObject4 = (TextView)((LinearLayout)localObject4).findViewById(2131306657);
        switch (i)
        {
        default: 
          label388:
          ((TextView)localObject2).setText(((do)localObject1).Title);
          e.dWR().o((ImageView)localObject3, ((do)localObject1).xIx);
          localTextView.setText(((do)localObject1).xMq);
          if (!Util.isNullOrNil(((do)localObject1).Desc)) {
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
        com.tencent.mm.plugin.game.d.a.b(this.mContext, 10, 1021, k, ((do)localObject1).jfi, paramInt2, com.tencent.mm.plugin.game.d.a.Fh(((do)localObject1).xJt));
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
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131100526));
      break label388;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131100527));
      break label388;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131100528));
      break label388;
      ((TextView)localObject4).setVisibility(8);
    }
    label586:
    paramas = new View(getContext());
    paramas.setBackgroundColor(getContext().getResources().getColor(2131100508));
    addView(paramas, new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5)));
    AppMethodBeat.o(42350);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42351);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameRecomBlockView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    int i = c.D(this.mContext, paramView.jumpUrl, paramView.eam);
    f.a(this.mContext, 10, 1021, paramView.xHK, i, paramView.appId, this.xGR, com.tencent.mm.plugin.game.d.a.Fh(paramView.xEl));
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
    public String appId;
    public String eam;
    public String jumpUrl;
    public String xEl;
    public int xHK;
    
    public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.appId = paramString1;
      this.xHK = paramInt;
      this.jumpUrl = paramString2;
      this.xEl = paramString3;
      this.eam = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRecomBlockView
 * JD-Core Version:    0.7.0.1
 */