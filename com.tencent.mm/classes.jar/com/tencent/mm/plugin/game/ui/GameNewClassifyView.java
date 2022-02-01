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
import com.tencent.mm.plugin.game.protobuf.ek;
import com.tencent.mm.plugin.game.protobuf.el;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameNewClassifyView
  extends LinearLayout
  implements View.OnClickListener
{
  private LinearLayout Api;
  private int IFc;
  private LayoutInflater pUI;
  
  public GameNewClassifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(el paramel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42315);
    if ((paramel == null) || (Util.isNullOrNil(paramel.IIU)))
    {
      setVisibility(8);
      AppMethodBeat.o(42315);
      return;
    }
    this.IFc = paramInt2;
    if (this.pUI == null) {
      this.pUI = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    this.Api.removeAllViews();
    LinearLayout localLinearLayout;
    while (this.Api.getChildCount() < paramel.IIU.size())
    {
      localLinearLayout = (LinearLayout)this.pUI.inflate(h.f.Iab, this, false);
      localLinearLayout.setOnClickListener(this);
      this.Api.addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
    }
    paramInt2 = 0;
    if (paramInt2 < this.Api.getChildCount())
    {
      if (paramInt2 < paramel.IIU.size()) {
        this.Api.getChildAt(paramInt2).setVisibility(0);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        this.Api.getChildAt(paramInt2).setVisibility(8);
      }
    }
    paramInt2 = 0;
    while (paramInt2 < paramel.IIU.size())
    {
      localLinearLayout = (LinearLayout)this.Api.getChildAt(paramInt2);
      ImageView localImageView = (ImageView)localLinearLayout.findViewById(h.e.HUg);
      TextView localTextView = (TextView)localLinearLayout.findViewById(h.e.HUh);
      e.fIb().p(localImageView, ((ek)paramel.IIU.get(paramInt2)).IHo);
      localTextView.setText(((ek)paramel.IIU.get(paramInt2)).hAP);
      localLinearLayout.setTag(new a(((ek)paramel.IIU.get(paramInt2)).IGI, paramInt2 + 1, ((ek)paramel.IIU.get(paramInt2)).IHI));
      paramInt2 += 1;
    }
    setVisibility(0);
    if (paramInt1 == 2) {
      com.tencent.mm.plugin.game.c.a.b(getContext(), 10, 1019, 0, null, this.IFc, null);
    }
    AppMethodBeat.o(42315);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42316);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42316);
      return;
    }
    paramView = (a)paramView.getTag();
    if (!Util.isNullOrNil(paramView.url))
    {
      c.ba(getContext(), paramView.url);
      g.a(getContext(), 10, 1019, paramView.position, 7, null, this.IFc, com.tencent.mm.plugin.game.c.a.EM(paramView.extInfo));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameNewClassifyView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42316);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42314);
    super.onFinishInflate();
    this.pUI = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.Api = ((LinearLayout)findViewById(h.e.HVW));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewClassifyView
 * JD-Core Version:    0.7.0.1
 */