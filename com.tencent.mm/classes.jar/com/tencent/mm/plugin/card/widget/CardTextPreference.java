package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference
  extends Preference
{
  Context mContext;
  private TextView tHj;
  public int tHk;
  boolean tHl;
  private TextView wB;
  
  public CardTextPreference(Context paramContext)
  {
    super(paramContext, null);
    this.tHk = 0;
    this.tHl = true;
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113886);
    this.tHk = 0;
    this.tHl = true;
    setLayoutResource(a.e.mm_preference);
    this.mContext = paramContext;
    AppMethodBeat.o(113886);
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.tHk = 0;
    this.tHl = true;
    this.mContext = paramContext;
  }
  
  private static void e(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(113892);
    if ((paramView == null) || (paramRect == null))
    {
      AppMethodBeat.o(113892);
      return;
    }
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(113892);
  }
  
  private static Rect eb(View paramView)
  {
    AppMethodBeat.i(113891);
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(113891);
    return localRect;
  }
  
  private void lO(boolean paramBoolean)
  {
    AppMethodBeat.i(113890);
    if (this.wB != null)
    {
      Rect localRect = eb(this.wB);
      this.wB.setSingleLine(paramBoolean);
      if (!paramBoolean)
      {
        localRect.top = this.mContext.getResources().getDimensionPixelOffset(a.b.LargePadding);
        localRect.bottom = this.mContext.getResources().getDimensionPixelOffset(a.b.LargePadding);
        e(this.wB, localRect);
      }
    }
    AppMethodBeat.o(113890);
  }
  
  public final void cLl()
  {
    AppMethodBeat.i(113888);
    if ((this.tHj != null) && (this.tHk != 0)) {
      this.tHj.setTextColor(this.tHk);
    }
    AppMethodBeat.o(113888);
  }
  
  public final void cLm()
  {
    AppMethodBeat.i(113889);
    lO(false);
    this.tHl = false;
    AppMethodBeat.o(113889);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(113887);
    super.onBindView(paramView);
    this.tHj = ((TextView)paramView.findViewById(16908304));
    this.wB = ((TextView)paramView.findViewById(16908310));
    cLl();
    lO(this.tHl);
    AppMethodBeat.o(113887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTextPreference
 * JD-Core Version:    0.7.0.1
 */