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
  private TextView awK;
  Context mContext;
  private TextView omx;
  public int omy;
  boolean omz;
  
  public CardTextPreference(Context paramContext)
  {
    super(paramContext, null);
    this.omy = 0;
    this.omz = true;
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113886);
    this.omy = 0;
    this.omz = true;
    setLayoutResource(2131494804);
    this.mContext = paramContext;
    AppMethodBeat.o(113886);
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.omy = 0;
    this.omz = true;
    this.mContext = paramContext;
  }
  
  private static Rect dI(View paramView)
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
  
  private void jp(boolean paramBoolean)
  {
    AppMethodBeat.i(113890);
    if (this.awK != null)
    {
      Rect localRect = dI(this.awK);
      this.awK.setSingleLine(paramBoolean);
      if (!paramBoolean)
      {
        localRect.top = this.mContext.getResources().getDimensionPixelOffset(2131165480);
        localRect.bottom = this.mContext.getResources().getDimensionPixelOffset(2131165480);
        i(this.awK, localRect);
      }
    }
    AppMethodBeat.o(113890);
  }
  
  public final void bUa()
  {
    AppMethodBeat.i(113888);
    if ((this.omx != null) && (this.omy != 0)) {
      this.omx.setTextColor(this.omy);
    }
    AppMethodBeat.o(113888);
  }
  
  public final void bUb()
  {
    AppMethodBeat.i(113889);
    jp(false);
    this.omz = false;
    AppMethodBeat.o(113889);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(113887);
    super.onBindView(paramView);
    this.omx = ((TextView)paramView.findViewById(16908304));
    this.awK = ((TextView)paramView.findViewById(16908310));
    bUa();
    jp(this.omz);
    AppMethodBeat.o(113887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTextPreference
 * JD-Core Version:    0.7.0.1
 */