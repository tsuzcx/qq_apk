package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.content.b;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.r;
import android.support.v4.view.t;
import android.support.v4.widget.q;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.bb;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class BottomNavigationItemView
  extends FrameLayout
  implements p.a
{
  private static final int[] gZ = { 16842912 };
  private ColorStateList eH;
  private final int ha;
  private float hb;
  private float hc;
  private float hd;
  private int he;
  private boolean hf;
  private ImageView hg;
  private final TextView hh;
  private final TextView hi;
  private int hj = -1;
  private j hk;
  
  public BottomNavigationItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getResources();
    LayoutInflater.from(paramContext).inflate(2131493692, this, true);
    setBackgroundResource(2131231891);
    this.ha = paramAttributeSet.getDimensionPixelSize(2131166101);
    this.hg = ((ImageView)findViewById(2131300874));
    this.hh = ((TextView)findViewById(2131304841));
    this.hi = ((TextView)findViewById(2131301309));
    t.p(this.hh, 2);
    t.p(this.hi, 2);
    setFocusable(true);
    b(this.hh.getTextSize(), this.hi.getTextSize());
  }
  
  private static void a(View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.hb = (paramFloat1 - paramFloat2);
    this.hc = (1.0F * paramFloat2 / paramFloat1);
    this.hd = (1.0F * paramFloat1 / paramFloat2);
  }
  
  public final void a(j paramj)
  {
    this.hk = paramj;
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setIcon(paramj.getIcon());
    setTitle(paramj.getTitle());
    setId(paramj.getItemId());
    if (!TextUtils.isEmpty(paramj.getContentDescription())) {
      setContentDescription(paramj.getContentDescription());
    }
    bb.a(this, paramj.getTooltipText());
    if (paramj.isVisible()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      return;
    }
  }
  
  public final boolean be()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.hk;
  }
  
  public int getItemPosition()
  {
    return this.hj;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.hk != null) && (this.hk.isCheckable()) && (this.hk.isChecked())) {
      mergeDrawableStates(arrayOfInt, gZ);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.hi.setPivotX(this.hi.getWidth() / 2);
    this.hi.setPivotY(this.hi.getBaseline());
    this.hh.setPivotX(this.hh.getWidth() / 2);
    this.hh.setPivotY(this.hh.getBaseline());
    switch (this.he)
    {
    }
    for (;;)
    {
      refreshDrawableState();
      setSelected(paramBoolean);
      return;
      if (this.hf)
      {
        if (paramBoolean)
        {
          a(this.hg, this.ha, 49);
          a(this.hi, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.hh.setVisibility(4);
          break;
          a(this.hg, this.ha, 17);
          a(this.hi, 0.5F, 0.5F, 4);
        }
      }
      if (paramBoolean)
      {
        a(this.hg, (int)(this.ha + this.hb), 49);
        a(this.hi, 1.0F, 1.0F, 0);
        a(this.hh, this.hc, this.hc, 4);
      }
      else
      {
        a(this.hg, this.ha, 49);
        a(this.hi, this.hd, this.hd, 4);
        a(this.hh, 1.0F, 1.0F, 0);
        continue;
        if (paramBoolean)
        {
          a(this.hg, this.ha, 49);
          a(this.hi, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.hh.setVisibility(4);
          break;
          a(this.hg, this.ha, 17);
          a(this.hi, 0.5F, 0.5F, 4);
        }
        if (paramBoolean)
        {
          a(this.hg, (int)(this.ha + this.hb), 49);
          a(this.hi, 1.0F, 1.0F, 0);
          a(this.hh, this.hc, this.hc, 4);
        }
        else
        {
          a(this.hg, this.ha, 49);
          a(this.hi, this.hd, this.hd, 4);
          a(this.hh, 1.0F, 1.0F, 0);
          continue;
          a(this.hg, this.ha, 17);
          this.hi.setVisibility(8);
          this.hh.setVisibility(8);
        }
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.hh.setEnabled(paramBoolean);
    this.hi.setEnabled(paramBoolean);
    this.hg.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      t.a(this, r.V(getContext()));
      return;
    }
    t.a(this, null);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        break label40;
      }
    }
    for (;;)
    {
      localObject = a.i(paramDrawable).mutate();
      a.a((Drawable)localObject, this.eH);
      this.hg.setImageDrawable((Drawable)localObject);
      return;
      label40:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.hg.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.hg.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.eH = paramColorStateList;
    if (this.hk != null) {
      setIcon(this.hk.getIcon());
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    if (paramInt == 0) {}
    for (Drawable localDrawable = null;; localDrawable = b.l(getContext(), paramInt))
    {
      setItemBackground(localDrawable);
      return;
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    t.a(this, paramDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.hj = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.he != paramInt)
    {
      this.he = paramInt;
      if (this.hk == null) {
        break label38;
      }
    }
    label38:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        setChecked(this.hk.isChecked());
      }
      return;
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.hf != paramBoolean)
    {
      this.hf = paramBoolean;
      if (this.hk == null) {
        break label38;
      }
    }
    label38:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        setChecked(this.hk.isChecked());
      }
      return;
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    q.d(this.hi, paramInt);
    b(this.hh.getTextSize(), this.hi.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    q.d(this.hh, paramInt);
    b(this.hh.getTextSize(), this.hi.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.hh.setTextColor(paramColorStateList);
      this.hi.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.hh.setText(paramCharSequence);
    this.hi.setText(paramCharSequence);
    if ((this.hk == null) || (TextUtils.isEmpty(this.hk.getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */