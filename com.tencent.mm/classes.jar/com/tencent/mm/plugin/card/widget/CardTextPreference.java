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
  private TextView aop;
  public int kCA;
  boolean kCB;
  private TextView kCz;
  Context mContext;
  
  public CardTextPreference(Context paramContext)
  {
    super(paramContext, null);
    this.kCA = 0;
    this.kCB = true;
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(88957);
    this.kCA = 0;
    this.kCB = true;
    setLayoutResource(2130970179);
    this.mContext = paramContext;
    AppMethodBeat.o(88957);
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.kCA = 0;
    this.kCB = true;
    this.mContext = paramContext;
  }
  
  private static Rect dh(View paramView)
  {
    AppMethodBeat.i(88963);
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    AppMethodBeat.o(88963);
    return localRect;
  }
  
  private void gb(boolean paramBoolean)
  {
    AppMethodBeat.i(88962);
    if (this.aop != null)
    {
      Rect localRect = dh(this.aop);
      this.aop.setSingleLine(paramBoolean);
      if (!paramBoolean)
      {
        localRect.top = this.mContext.getResources().getDimensionPixelOffset(2131427772);
        localRect.bottom = this.mContext.getResources().getDimensionPixelOffset(2131427772);
        j(this.aop, localRect);
      }
    }
    AppMethodBeat.o(88962);
  }
  
  private static void j(View paramView, Rect paramRect)
  {
    AppMethodBeat.i(88964);
    if ((paramView == null) || (paramRect == null))
    {
      AppMethodBeat.o(88964);
      return;
    }
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    AppMethodBeat.o(88964);
  }
  
  public final void bfE()
  {
    AppMethodBeat.i(88960);
    if ((this.kCz != null) && (this.kCA != 0)) {
      this.kCz.setTextColor(this.kCA);
    }
    AppMethodBeat.o(88960);
  }
  
  public final void bfF()
  {
    AppMethodBeat.i(88961);
    gb(false);
    this.kCB = false;
    AppMethodBeat.o(88961);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(88958);
    super.onBindView(paramView);
    this.kCz = ((TextView)paramView.findViewById(16908304));
    this.aop = ((TextView)paramView.findViewById(16908310));
    bfE();
    gb(this.kCB);
    AppMethodBeat.o(88958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTextPreference
 * JD-Core Version:    0.7.0.1
 */