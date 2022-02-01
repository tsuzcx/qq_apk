package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.support.v7.a.a.a;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
  extends LinearLayout
  implements p.a, AbsListView.SelectionBoundsAdjuster
{
  private ImageView Xx;
  private TextView Xy;
  private j aeV;
  private boolean afG;
  private RadioButton afT;
  private CheckBox afU;
  private TextView afV;
  private ImageView afW;
  private ImageView afX;
  private LinearLayout afY;
  private Drawable afZ;
  private int aga;
  private Context agb;
  private boolean agc;
  private Drawable agd;
  private boolean age;
  private int agf;
  private LayoutInflater mInflater;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969278);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = az.a(getContext(), paramAttributeSet, a.a.MenuView, paramInt, 0);
    this.afZ = paramAttributeSet.getDrawable(5);
    this.aga = paramAttributeSet.getResourceId(1, -1);
    this.agc = paramAttributeSet.getBoolean(7, false);
    this.agb = paramContext;
    this.agd = paramAttributeSet.getDrawable(8);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, 2130968965, 0);
    this.age = paramContext.hasValue(0);
    paramAttributeSet.ayy.recycle();
    paramContext.recycle();
  }
  
  private void A(View paramView, int paramInt)
  {
    if (this.afY != null)
    {
      this.afY.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(getContext());
    }
    return this.mInflater;
  }
  
  private void hT()
  {
    this.afT = ((RadioButton)getInflater().inflate(2131492925, this, false));
    A(this.afT, -1);
  }
  
  private void hU()
  {
    this.afU = ((CheckBox)getInflater().inflate(2131492922, this, false));
    A(this.afU, -1);
  }
  
  private void setShortcut$25d965e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.aeV.im())) {}
    for (int i = 0;; i = 8)
    {
      if (i == 0) {
        this.afV.setText(this.aeV.il());
      }
      if (this.afV.getVisibility() != i) {
        this.afV.setVisibility(i);
      }
      return;
    }
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.afW != null)
    {
      localImageView = this.afW;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public final void a(j paramj)
  {
    int j = 0;
    this.aeV = paramj;
    this.agf = 0;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      if ((!paramj.im()) || (!this.aeV.im())) {
        break label159;
      }
    }
    Object localObject;
    char c;
    label159:
    for (int i = j;; i = 8)
    {
      if (i == 0)
      {
        TextView localTextView = this.afV;
        localObject = this.aeV;
        c = ((j)localObject).ik();
        if (c != 0) {
          break label165;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.afV.getVisibility() != i) {
        this.afV.setVisibility(i);
      }
      setIcon(paramj.getIcon());
      setEnabled(paramj.isEnabled());
      setSubMenuArrowVisible(paramj.hasSubMenu());
      setContentDescription(paramj.getContentDescription());
      return;
      i = 8;
      break;
    }
    label165:
    Resources localResources = ((j)localObject).aaQ.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(((j)localObject).aaQ.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131755115));
    }
    if (((j)localObject).aaQ.hY())
    {
      j = ((j)localObject).aeL;
      label236:
      j.a(localStringBuilder, j, 65536, localResources.getString(2131755111));
      j.a(localStringBuilder, j, 4096, localResources.getString(2131755107));
      j.a(localStringBuilder, j, 2, localResources.getString(2131755106));
      j.a(localStringBuilder, j, 1, localResources.getString(2131755112));
      j.a(localStringBuilder, j, 4, localResources.getString(2131755114));
      j.a(localStringBuilder, j, 8, localResources.getString(2131755110));
      switch (c)
      {
      default: 
        localStringBuilder.append(c);
      }
    }
    for (;;)
    {
      localObject = localStringBuilder.toString();
      break;
      j = ((j)localObject).aeJ;
      break label236;
      localStringBuilder.append(localResources.getString(2131755109));
      continue;
      localStringBuilder.append(localResources.getString(2131755108));
      continue;
      localStringBuilder.append(localResources.getString(2131755113));
    }
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    if ((this.afX != null) && (this.afX.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.afX.getLayoutParams();
      int i = paramRect.top;
      int j = this.afX.getHeight();
      int k = localLayoutParams.topMargin;
      paramRect.top = (localLayoutParams.bottomMargin + (j + k) + i);
    }
  }
  
  public final boolean bC()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.aeV;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    u.a(this, this.afZ);
    this.Xy = ((TextView)findViewById(2131309195));
    if (this.aga != -1) {
      this.Xy.setTextAppearance(this.agb, this.aga);
    }
    this.afV = ((TextView)findViewById(2131307853));
    this.afW = ((ImageView)findViewById(2131308730));
    if (this.afW != null) {
      this.afW.setImageDrawable(this.agd);
    }
    this.afX = ((ImageView)findViewById(2131302191));
    this.afY = ((LinearLayout)findViewById(2131299180));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.Xx != null) && (this.agc))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.Xx.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.afT == null) && (this.afU == null)) {}
    label121:
    do
    {
      return;
      Object localObject2;
      if (this.aeV.in())
      {
        if (this.afT == null) {
          hT();
        }
        localObject2 = this.afT;
      }
      for (Object localObject1 = this.afU;; localObject1 = this.afT)
      {
        if (!paramBoolean) {
          break label121;
        }
        ((CompoundButton)localObject2).setChecked(this.aeV.isChecked());
        if (((CompoundButton)localObject2).getVisibility() != 0) {
          ((CompoundButton)localObject2).setVisibility(0);
        }
        if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject1).setVisibility(8);
        return;
        if (this.afU == null) {
          hU();
        }
        localObject2 = this.afU;
      }
      if (this.afU != null) {
        this.afU.setVisibility(8);
      }
    } while (this.afT == null);
    this.afT.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.aeV.in()) {
      if (this.afT == null) {
        hT();
      }
    }
    for (Object localObject = this.afT;; localObject = this.afU)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.afU == null) {
        hU();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.afG = paramBoolean;
    this.agc = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.afX != null)
    {
      localImageView = this.afX;
      if ((this.age) || (!paramBoolean)) {
        break label31;
      }
    }
    label31:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if ((this.aeV.aaQ.agE) || (this.afG))
    {
      i = 1;
      if ((i != 0) || (this.agc)) {
        break label39;
      }
    }
    label39:
    while ((this.Xx == null) && (paramDrawable == null) && (!this.agc))
    {
      return;
      i = 0;
      break;
    }
    if (this.Xx == null)
    {
      this.Xx = ((ImageView)getInflater().inflate(2131492923, this, false));
      A(this.Xx, 0);
    }
    if ((paramDrawable != null) || (this.agc))
    {
      ImageView localImageView = this.Xx;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.Xx.getVisibility() == 0) {
          break;
        }
        this.Xx.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.Xx.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Xy.setText(paramCharSequence);
      if (this.Xy.getVisibility() != 0) {
        this.Xy.setVisibility(0);
      }
    }
    while (this.Xy.getVisibility() == 8) {
      return;
    }
    this.Xy.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */