package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference
  extends Preference
{
  private TextView ayB;
  Context mContext;
  private TextView oWu;
  public int oWv;
  boolean oWw;
  
  public CardTextPreference(Context paramContext)
  {
    super(paramContext, null);
    this.oWv = 0;
    this.oWw = true;
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113886);
    this.oWv = 0;
    this.oWw = true;
    setLayoutResource(2131494804);
    this.mContext = paramContext;
    AppMethodBeat.o(113886);
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.oWv = 0;
    this.oWw = true;
    this.mContext = paramContext;
  }
  
  private static Rect dL(View paramView)
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
  
  private static void i(View paramView, Rect paramRect)
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
  
  private void jz(boolean paramBoolean)
  {
    AppMethodBeat.i(113890);
    if (this.ayB != null)
    {
      Rect localRect = dL(this.ayB);
      this.ayB.setSingleLine(paramBoolean);
      if (!paramBoolean)
      {
        localRect.top = this.mContext.getResources().getDimensionPixelOffset(2131165480);
        localRect.bottom = this.mContext.getResources().getDimensionPixelOffset(2131165480);
        i(this.ayB, localRect);
      }
    }
    AppMethodBeat.o(113890);
  }
  
  public final void bZU()
  {
    AppMethodBeat.i(113888);
    if ((this.oWu != null) && (this.oWv != 0)) {
      this.oWu.setTextColor(this.oWv);
    }
    AppMethodBeat.o(113888);
  }
  
  public final void bZV()
  {
    AppMethodBeat.i(113889);
    jz(false);
    this.oWw = false;
    AppMethodBeat.o(113889);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(113887);
    super.onBindView(paramView);
    this.oWu = ((TextView)paramView.findViewById(16908304));
    this.ayB = ((TextView)paramView.findViewById(16908310));
    bZU();
    jz(this.oWw);
    AppMethodBeat.o(113887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTextPreference
 * JD-Core Version:    0.7.0.1
 */