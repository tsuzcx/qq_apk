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
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.d.cy;
import com.tencent.mm.plugin.game.f.c;
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
  int rXI;
  
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
  
  final void a(aj paramaj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42350);
    this.mContainer.removeAllViews();
    if (bt.gL(paramaj.saZ))
    {
      setVisibility(8);
      AppMethodBeat.o(42350);
      return;
    }
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, 0, null, paramInt2, com.tencent.mm.plugin.game.e.a.qh(paramaj.rZW));
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
    if (!bt.isNullOrNil(paramaj.rZX))
    {
      ((TextView)localObject1).setText(paramaj.rZX);
      if (bt.isNullOrNil(paramaj.sba)) {
        break label506;
      }
      ((TextView)localObject3).setText(paramaj.sba);
      ((View)localObject2).setTag(new a(null, 999, paramaj.sbb, paramaj.rZW, "game_center_mygame_more"));
      ((View)localObject2).setOnClickListener(this);
      k = 0;
      i = 0;
      if (i >= paramaj.saZ.size()) {
        break label586;
      }
      localObject1 = (cy)paramaj.saZ.get(i);
      j = k;
      if (localObject1 != null)
      {
        if (localLinearLayout.getChildCount() >= 3) {
          break label586;
        }
        k += 1;
        localObject4 = (LinearLayout)this.mInflater.inflate(2131494254, this, false);
        ((LinearLayout)localObject4).setTag(new a(((cy)localObject1).hnC, k, ((cy)localObject1).rZo, ((cy)localObject1).rZW, "game_center_mygame_rank"));
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
          ((TextView)localObject2).setText(((cy)localObject1).Title);
          com.tencent.mm.plugin.game.f.e.cEB().l((ImageView)localObject3, ((cy)localObject1).rZn);
          localTextView.setText(((cy)localObject1).scR);
          if (!bt.isNullOrNil(((cy)localObject1).Desc)) {
            ((TextView)localObject4).setText(((cy)localObject1).Desc);
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
        com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1021, k, ((cy)localObject1).hnC, paramInt2, com.tencent.mm.plugin.game.e.a.qh(((cy)localObject1).rZW));
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
    paramaj = new View(getContext());
    paramaj.setBackgroundColor(getContext().getResources().getColor(2131100406));
    addView(paramaj, new LinearLayout.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(getContext(), 5)));
    AppMethodBeat.o(42350);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42351);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ad.w("MicroMsg.GameRecomBlockView", "getTag is null");
      AppMethodBeat.o(42351);
      return;
    }
    paramView = (a)paramView.getTag();
    if (bt.isNullOrNil(paramView.jumpUrl))
    {
      ad.w("MicroMsg.GameRecomBlockView", "jumpUrl is null");
      AppMethodBeat.o(42351);
      return;
    }
    int i = c.A(this.mContext, paramView.jumpUrl, paramView.dxF);
    com.tencent.mm.game.report.e.a(this.mContext, 10, 1021, paramView.rYB, i, paramView.appId, this.rXI, com.tencent.mm.plugin.game.e.a.qh(paramView.rVj));
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
    public String dxF;
    public String jumpUrl;
    public String rVj;
    public int rYB;
    
    public a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.appId = paramString1;
      this.rYB = paramInt;
      this.jumpUrl = paramString2;
      this.rVj = paramString3;
      this.dxF = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRecomBlockView
 * JD-Core Version:    0.7.0.1
 */