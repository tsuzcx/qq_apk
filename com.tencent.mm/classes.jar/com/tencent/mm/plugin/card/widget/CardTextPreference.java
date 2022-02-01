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
  private TextView oPS;
  public int oPT;
  boolean oPU;
  
  public CardTextPreference(Context paramContext)
  {
    super(paramContext, null);
    this.oPT = 0;
    this.oPU = true;
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113886);
    this.oPT = 0;
    this.oPU = true;
    setLayoutResource(2131494804);
    this.mContext = paramContext;
    AppMethodBeat.o(113886);
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.oPT = 0;
    this.oPU = true;
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
  
  private void jA(boolean paramBoolean)
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
  
  public final void bYF()
  {
    AppMethodBeat.i(113888);
    if ((this.oPS != null) && (this.oPT != 0)) {
      this.oPS.setTextColor(this.oPT);
    }
    AppMethodBeat.o(113888);
  }
  
  public final void bYG()
  {
    AppMethodBeat.i(113889);
    jA(false);
    this.oPU = false;
    AppMethodBeat.o(113889);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(113887);
    super.onBindView(paramView);
    this.oPS = ((TextView)paramView.findViewById(16908304));
    this.ayB = ((TextView)paramView.findViewById(16908310));
    bYF();
    jA(this.oPU);
    AppMethodBeat.o(113887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTextPreference
 * JD-Core Version:    0.7.0.1
 */