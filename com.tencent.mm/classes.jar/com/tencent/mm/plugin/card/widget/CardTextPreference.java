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
  private TextView ayz;
  Context mContext;
  private TextView qlo;
  public int qlp;
  boolean qlq;
  
  public CardTextPreference(Context paramContext)
  {
    super(paramContext, null);
    this.qlp = 0;
    this.qlq = true;
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113886);
    this.qlp = 0;
    this.qlq = true;
    setLayoutResource(2131495538);
    this.mContext = paramContext;
    AppMethodBeat.o(113886);
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.qlp = 0;
    this.qlq = true;
    this.mContext = paramContext;
  }
  
  private static Rect dD(View paramView)
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
  
  private void kC(boolean paramBoolean)
  {
    AppMethodBeat.i(113890);
    if (this.ayz != null)
    {
      Rect localRect = dD(this.ayz);
      this.ayz.setSingleLine(paramBoolean);
      if (!paramBoolean)
      {
        localRect.top = this.mContext.getResources().getDimensionPixelOffset(2131165498);
        localRect.bottom = this.mContext.getResources().getDimensionPixelOffset(2131165498);
        e(this.ayz, localRect);
      }
    }
    AppMethodBeat.o(113890);
  }
  
  public final void cxJ()
  {
    AppMethodBeat.i(113888);
    if ((this.qlo != null) && (this.qlp != 0)) {
      this.qlo.setTextColor(this.qlp);
    }
    AppMethodBeat.o(113888);
  }
  
  public final void cxK()
  {
    AppMethodBeat.i(113889);
    kC(false);
    this.qlq = false;
    AppMethodBeat.o(113889);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(113887);
    super.onBindView(paramView);
    this.qlo = ((TextView)paramView.findViewById(16908304));
    this.ayz = ((TextView)paramView.findViewById(16908310));
    cxJ();
    kC(this.qlq);
    AppMethodBeat.o(113887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTextPreference
 * JD-Core Version:    0.7.0.1
 */