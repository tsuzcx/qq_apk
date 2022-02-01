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
import com.tencent.mm.plugin.game.d.ef;
import com.tencent.mm.plugin.game.d.eg;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class GameNewClassifyView
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater jiz;
  private LinearLayout rMv;
  private int uoy;
  
  public GameNewClassifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(eg parameg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42315);
    if ((parameg == null) || (bu.ht(parameg.usl)))
    {
      setVisibility(8);
      AppMethodBeat.o(42315);
      return;
    }
    this.uoy = paramInt2;
    if (this.jiz == null) {
      this.jiz = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    this.rMv.removeAllViews();
    LinearLayout localLinearLayout;
    while (this.rMv.getChildCount() < parameg.usl.size())
    {
      localLinearLayout = (LinearLayout)this.jiz.inflate(2131494363, this, false);
      localLinearLayout.setOnClickListener(this);
      this.rMv.addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
    }
    paramInt2 = 0;
    if (paramInt2 < this.rMv.getChildCount())
    {
      if (paramInt2 < parameg.usl.size()) {
        this.rMv.getChildAt(paramInt2).setVisibility(0);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        this.rMv.getChildAt(paramInt2).setVisibility(8);
      }
    }
    paramInt2 = 0;
    while (paramInt2 < parameg.usl.size())
    {
      localLinearLayout = (LinearLayout)this.rMv.getChildAt(paramInt2);
      ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131300367);
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131300368);
      e.ddh().l(localImageView, ((ef)parameg.usl.get(paramInt2)).IconUrl);
      localTextView.setText(((ef)parameg.usl.get(paramInt2)).Title);
      localLinearLayout.setTag(new a(((ef)parameg.usl.get(paramInt2)).uqf, paramInt2 + 1, ((ef)parameg.usl.get(paramInt2)).ura));
      paramInt2 += 1;
    }
    setVisibility(0);
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.e.a.a(getContext(), 10, 1019, 0, null, this.uoy, null);
    }
    AppMethodBeat.o(42315);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42316);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42316);
      return;
    }
    paramView = (a)paramView.getTag();
    if (!bu.isNullOrNil(paramView.url))
    {
      c.aD(getContext(), paramView.url);
      f.a(getContext(), 10, 1019, paramView.position, 7, null, this.uoy, com.tencent.mm.plugin.game.e.a.wT(paramView.extInfo));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42316);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42314);
    super.onFinishInflate();
    this.jiz = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.rMv = ((LinearLayout)findViewById(2131300497));
    AppMethodBeat.o(42314);
  }
  
  static final class a
  {
    public String extInfo;
    public int position;
    public String url;
    
    public a(String paramString1, int paramInt, String paramString2)
    {
      this.url = paramString1;
      this.position = paramInt;
      this.extInfo = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewClassifyView
 * JD-Core Version:    0.7.0.1
 */