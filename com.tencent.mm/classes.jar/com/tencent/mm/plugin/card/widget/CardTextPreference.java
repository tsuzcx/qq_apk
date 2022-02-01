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
  private TextView avQ;
  Context mContext;
  private TextView nJx;
  public int nJy;
  boolean nJz;
  
  public CardTextPreference(Context paramContext)
  {
    super(paramContext, null);
    this.nJy = 0;
    this.nJz = true;
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113886);
    this.nJy = 0;
    this.nJz = true;
    setLayoutResource(2131494804);
    this.mContext = paramContext;
    AppMethodBeat.o(113886);
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.nJy = 0;
    this.nJz = true;
    this.mContext = paramContext;
  }
  
  private static Rect dG(View paramView)
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
  
  private void iM(boolean paramBoolean)
  {
    AppMethodBeat.i(113890);
    if (this.avQ != null)
    {
      Rect localRect = dG(this.avQ);
      this.avQ.setSingleLine(paramBoolean);
      if (!paramBoolean)
      {
        localRect.top = this.mContext.getResources().getDimensionPixelOffset(2131165480);
        localRect.bottom = this.mContext.getResources().getDimensionPixelOffset(2131165480);
        i(this.avQ, localRect);
      }
    }
    AppMethodBeat.o(113890);
  }
  
  public final void bMP()
  {
    AppMethodBeat.i(113888);
    if ((this.nJx != null) && (this.nJy != 0)) {
      this.nJx.setTextColor(this.nJy);
    }
    AppMethodBeat.o(113888);
  }
  
  public final void bMQ()
  {
    AppMethodBeat.i(113889);
    iM(false);
    this.nJz = false;
    AppMethodBeat.o(113889);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(113887);
    super.onBindView(paramView);
    this.nJx = ((TextView)paramView.findViewById(16908304));
    this.avQ = ((TextView)paramView.findViewById(16908310));
    bMP();
    iM(this.nJz);
    AppMethodBeat.o(113887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTextPreference
 * JD-Core Version:    0.7.0.1
 */