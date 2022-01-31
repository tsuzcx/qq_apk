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
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.cx;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameRecomBlockView
  extends LinearLayout
  implements View.OnClickListener
{
  private ViewGroup mContainer;
  private Context mContext;
  private LayoutInflater mInflater;
  int nok;
  
  public GameRecomBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112150);
    setOrientation(1);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mContainer = this;
    AppMethodBeat.o(112150);
  }
  
  final void a(ah paramah, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112152);
    this.mContainer.removeAllViews();
    if (bo.es(paramah.nrw))
    {
      setVisibility(8);
      AppMethodBeat.o(112152);
      return;
    }
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, 0, null, paramInt2, com.tencent.mm.plugin.game.e.a.lR(paramah.nqt));
    }
    this.mInflater.inflate(2130969701, this, true);
    Object localObject1 = (TextView)findViewById(2131824449);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131824450);
    Object localObject2 = findViewById(2131824451);
    Object localObject3 = (TextView)findViewById(2131824452);
    label152:
    int k;
    int i;
    label190:
    int j;
    Object localObject4;
    if (!bo.isNullOrNil(paramah.nqu))
    {
      ((TextView)localObject1).setText(paramah.nqu);
      if (bo.isNullOrNil(paramah.nrx)) {
        break label506;
      }
      ((TextView)localObject3).setText(paramah.nrx);
      ((View)localObject2).setTag(new GameRecomBlockView.a(null, 999, paramah.nry, paramah.nqt, "game_center_mygame_more"));
      ((View)localObject2).setOnClickListener(this);
      k = 0;
      i = 0;
      if (i >= paramah.nrw.size()) {
        break label586;
      }
      localObject1 = (cx)paramah.nrw.get(i);
      j = k;
      if (localObject1 != null)
      {
        if (localLinearLayout.getChildCount() >= 3) {
          break label586;
        }
        k += 1;
        localObject4 = (LinearLayout)this.mInflater.inflate(2130969702, this, false);
        ((LinearLayout)localObject4).setTag(new GameRecomBlockView.a(((cx)localObject1).fKw, k, ((cx)localObject1).npR, ((cx)localObject1).nqt, "game_center_mygame_rank"));
        ((LinearLayout)localObject4).setOnClickListener(this);
        localLinearLayout.addView((View)localObject4, new LinearLayout.LayoutParams(-1, -2, 1.0F));
        localObject2 = (TextView)((LinearLayout)localObject4).findViewById(2131824453);
        localObject3 = (ImageView)((LinearLayout)localObject4).findViewById(2131824454);
        TextView localTextView = (TextView)((LinearLayout)localObject4).findViewById(2131824455);
        localObject4 = (TextView)((LinearLayout)localObject4).findViewById(2131824456);
        switch (i)
        {
        default: 
          label388:
          ((TextView)localObject2).setText(((cx)localObject1).Title);
          e.bHE().i((ImageView)localObject3, ((cx)localObject1).npQ);
          localTextView.setText(((cx)localObject1).ntp);
          if (!bo.isNullOrNil(((cx)localObject1).Desc)) {
            ((TextView)localObject4).setText(((cx)localObject1).Desc);
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
        com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, k, ((cx)localObject1).fKw, paramInt2, com.tencent.mm.plugin.game.e.a.lR(((cx)localObject1).nqt));
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
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131690101));
      break label388;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131690102));
      break label388;
      ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131690103));
      break label388;
      ((TextView)localObject4).setVisibility(8);
    }
    label586:
    paramah = new View(getContext());
    paramah.setBackgroundColor(getContext().getResources().getColor(2131690085));
    addView(paramah, new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5)));
    AppMethodBeat.o(112152);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112153);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof GameRecomBlockView.a)))
    {
      ab.w("MicroMsg.GameRecomBlockView", "getTag is null");
      AppMethodBeat.o(112153);
      return;
    }
    paramView = (GameRecomBlockView.a)paramView.getTag();
    if (bo.isNullOrNil(paramView.jumpUrl))
    {
      ab.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
      AppMethodBeat.o(112153);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.t(this.mContext, paramView.jumpUrl, paramView.cGT);
    com.tencent.mm.game.report.c.a(this.mContext, 10, 1021, paramView.npg, i, paramView.appId, this.nok, com.tencent.mm.plugin.game.e.a.lR(paramView.nml));
    AppMethodBeat.o(112153);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112151);
    super.onFinishInflate();
    ab.i("MicroMsg.GameRecomBlockView", "initView finished");
    AppMethodBeat.o(112151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRecomBlockView
 * JD-Core Version:    0.7.0.1
 */