package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference
  extends Preference
{
  private TextView ama;
  private TextView izt;
  public int izu = 0;
  boolean izv = true;
  Context mContext;
  
  public CardTextPreference(Context paramContext)
  {
    super(paramContext, null);
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setLayoutResource(a.e.mm_preference);
    this.mContext = paramContext;
  }
  
  public CardTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void eC(boolean paramBoolean)
  {
    TextView localTextView;
    Rect localRect;
    if (this.ama != null)
    {
      localTextView = this.ama;
      localRect = new Rect();
      localRect.left = localTextView.getPaddingLeft();
      localRect.right = localTextView.getPaddingRight();
      localRect.top = localTextView.getPaddingTop();
      localRect.bottom = localTextView.getPaddingBottom();
      this.ama.setSingleLine(paramBoolean);
      if (!paramBoolean)
      {
        localRect.top = this.mContext.getResources().getDimensionPixelOffset(a.b.LargePadding);
        localRect.bottom = this.mContext.getResources().getDimensionPixelOffset(a.b.LargePadding);
        localTextView = this.ama;
        if (localTextView != null) {
          break label108;
        }
      }
    }
    return;
    label108:
    localTextView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  public final void aDh()
  {
    if ((this.izt != null) && (this.izu != 0)) {
      this.izt.setTextColor(this.izu);
    }
  }
  
  public final void aDi()
  {
    eC(false);
    this.izv = false;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.izt = ((TextView)paramView.findViewById(16908304));
    this.ama = ((TextView)paramView.findViewById(16908310));
    aDh();
    eC(this.izv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTextPreference
 * JD-Core Version:    0.7.0.1
 */