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
  private static final int[] jT = { 16842912 };
  private ColorStateList hz;
  private final int jU;
  private float jV;
  private float jW;
  private float jX;
  private int jY;
  private boolean jZ;
  private ImageView ka;
  private final TextView kb;
  private final TextView kc;
  private int kd = -1;
  private j ke;
  
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
    this.jU = paramAttributeSet.getDimensionPixelSize(2131166101);
    this.ka = ((ImageView)findViewById(2131300874));
    this.kb = ((TextView)findViewById(2131304841));
    this.kc = ((TextView)findViewById(2131301309));
    t.p(this.kb, 2);
    t.p(this.kc, 2);
    setFocusable(true);
    b(this.kb.getTextSize(), this.kc.getTextSize());
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
    this.jV = (paramFloat1 - paramFloat2);
    this.jW = (1.0F * paramFloat2 / paramFloat1);
    this.jX = (1.0F * paramFloat1 / paramFloat2);
  }
  
  public final void a(j paramj)
  {
    this.ke = paramj;
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
  
  public final boolean bA()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.ke;
  }
  
  public int getItemPosition()
  {
    return this.kd;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.ke != null) && (this.ke.isCheckable()) && (this.ke.isChecked())) {
      mergeDrawableStates(arrayOfInt, jT);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.kc.setPivotX(this.kc.getWidth() / 2);
    this.kc.setPivotY(this.kc.getBaseline());
    this.kb.setPivotX(this.kb.getWidth() / 2);
    this.kb.setPivotY(this.kb.getBaseline());
    switch (this.jY)
    {
    }
    for (;;)
    {
      refreshDrawableState();
      setSelected(paramBoolean);
      return;
      if (this.jZ)
      {
        if (paramBoolean)
        {
          a(this.ka, this.jU, 49);
          a(this.kc, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.kb.setVisibility(4);
          break;
          a(this.ka, this.jU, 17);
          a(this.kc, 0.5F, 0.5F, 4);
        }
      }
      if (paramBoolean)
      {
        a(this.ka, (int)(this.jU + this.jV), 49);
        a(this.kc, 1.0F, 1.0F, 0);
        a(this.kb, this.jW, this.jW, 4);
      }
      else
      {
        a(this.ka, this.jU, 49);
        a(this.kc, this.jX, this.jX, 4);
        a(this.kb, 1.0F, 1.0F, 0);
        continue;
        if (paramBoolean)
        {
          a(this.ka, this.jU, 49);
          a(this.kc, 1.0F, 1.0F, 0);
        }
        for (;;)
        {
          this.kb.setVisibility(4);
          break;
          a(this.ka, this.jU, 17);
          a(this.kc, 0.5F, 0.5F, 4);
        }
        if (paramBoolean)
        {
          a(this.ka, (int)(this.jU + this.jV), 49);
          a(this.kc, 1.0F, 1.0F, 0);
          a(this.kb, this.jW, this.jW, 4);
        }
        else
        {
          a(this.ka, this.jU, 49);
          a(this.kc, this.jX, this.jX, 4);
          a(this.kb, 1.0F, 1.0F, 0);
          continue;
          a(this.ka, this.jU, 17);
          this.kc.setVisibility(8);
          this.kb.setVisibility(8);
        }
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.kb.setEnabled(paramBoolean);
    this.kc.setEnabled(paramBoolean);
    this.ka.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      t.a(this, r.X(getContext()));
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
      a.a((Drawable)localObject, this.hz);
      this.ka.setImageDrawable((Drawable)localObject);
      return;
      label40:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ka.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.ka.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.hz = paramColorStateList;
    if (this.ke != null) {
      setIcon(this.ke.getIcon());
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
    this.kd = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.jY != paramInt)
    {
      this.jY = paramInt;
      if (this.ke == null) {
        break label38;
      }
    }
    label38:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        setChecked(this.ke.isChecked());
      }
      return;
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.jZ != paramBoolean)
    {
      this.jZ = paramBoolean;
      if (this.ke == null) {
        break label38;
      }
    }
    label38:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        setChecked(this.ke.isChecked());
      }
      return;
    }
  }
  
  public void setTextAppearanceActive(int paramInt)
  {
    q.d(this.kc, paramInt);
    b(this.kb.getTextSize(), this.kc.getTextSize());
  }
  
  public void setTextAppearanceInactive(int paramInt)
  {
    q.d(this.kb, paramInt);
    b(this.kb.getTextSize(), this.kc.getTextSize());
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.kb.setTextColor(paramColorStateList);
      this.kc.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.kb.setText(paramCharSequence);
    this.kc.setText(paramCharSequence);
    if ((this.ke == null) || (TextUtils.isEmpty(this.ke.getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationItemView
 * JD-Core Version:    0.7.0.1
 */