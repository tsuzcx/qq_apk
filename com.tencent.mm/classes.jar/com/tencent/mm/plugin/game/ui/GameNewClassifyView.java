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
import com.tencent.mm.plugin.game.protobuf.ef;
import com.tencent.mm.plugin.game.protobuf.eg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameNewClassifyView
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater kgB;
  private LinearLayout tmh;
  private int xGR;
  
  public GameNewClassifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(eg parameg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42315);
    if ((parameg == null) || (Util.isNullOrNil(parameg.xKD)))
    {
      setVisibility(8);
      AppMethodBeat.o(42315);
      return;
    }
    this.xGR = paramInt2;
    if (this.kgB == null) {
      this.kgB = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    this.tmh.removeAllViews();
    LinearLayout localLinearLayout;
    while (this.tmh.getChildCount() < parameg.xKD.size())
    {
      localLinearLayout = (LinearLayout)this.kgB.inflate(2131494929, this, false);
      localLinearLayout.setOnClickListener(this);
      this.tmh.addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
    }
    paramInt2 = 0;
    if (paramInt2 < this.tmh.getChildCount())
    {
      if (paramInt2 < parameg.xKD.size()) {
        this.tmh.getChildAt(paramInt2).setVisibility(0);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        this.tmh.getChildAt(paramInt2).setVisibility(8);
      }
    }
    paramInt2 = 0;
    while (paramInt2 < parameg.xKD.size())
    {
      localLinearLayout = (LinearLayout)this.tmh.getChildAt(paramInt2);
      ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131301890);
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131301891);
      e.dWR().o(localImageView, ((ef)parameg.xKD.get(paramInt2)).IconUrl);
      localTextView.setText(((ef)parameg.xKD.get(paramInt2)).Title);
      localLinearLayout.setTag(new a(((ef)parameg.xKD.get(paramInt2)).xIy, paramInt2 + 1, ((ef)parameg.xKD.get(paramInt2)).xJt));
      paramInt2 += 1;
    }
    setVisibility(0);
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1019, 0, null, this.xGR, null);
    }
    AppMethodBeat.o(42315);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42316);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42316);
      return;
    }
    paramView = (a)paramView.getTag();
    if (!Util.isNullOrNil(paramView.url))
    {
      c.aQ(getContext(), paramView.url);
      f.a(getContext(), 10, 1019, paramView.position, 7, null, this.xGR, com.tencent.mm.plugin.game.d.a.Fh(paramView.extInfo));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42316);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42314);
    super.onFinishInflate();
    this.kgB = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.tmh = ((LinearLayout)findViewById(2131302022));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewClassifyView
 * JD-Core Version:    0.7.0.1
 */