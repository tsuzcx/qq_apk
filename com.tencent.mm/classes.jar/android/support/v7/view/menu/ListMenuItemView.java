package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
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
  private ImageView Xk;
  private TextView Xl;
  private j aeI;
  private RadioButton afG;
  private CheckBox afH;
  private TextView afI;
  private ImageView afJ;
  private ImageView afK;
  private LinearLayout afL;
  private Drawable afM;
  private int afN;
  private Context afO;
  private boolean afP;
  private Drawable afQ;
  private boolean afR;
  private int afS;
  private boolean aft;
  private LayoutInflater mInflater;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969238);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = az.a(getContext(), paramAttributeSet, a.a.MenuView, paramInt, 0);
    this.afM = paramAttributeSet.getDrawable(5);
    this.afN = paramAttributeSet.getResourceId(1, -1);
    this.afP = paramAttributeSet.getBoolean(7, false);
    this.afO = paramContext;
    this.afQ = paramAttributeSet.getDrawable(8);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, 2130968938, 0);
    this.afR = paramContext.hasValue(0);
    paramAttributeSet.ayA.recycle();
    paramContext.recycle();
  }
  
  private void A(View paramView, int paramInt)
  {
    if (this.afL != null)
    {
      this.afL.addView(paramView, paramInt);
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
  
  private void hK()
  {
    this.afG = ((RadioButton)getInflater().inflate(2131492908, this, false));
    A(this.afG, -1);
  }
  
  private void hL()
  {
    this.afH = ((CheckBox)getInflater().inflate(2131492905, this, false));
    A(this.afH, -1);
  }
  
  private void setShortcut$25d965e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.aeI.ic())) {}
    for (int i = 0;; i = 8)
    {
      if (i == 0) {
        this.afI.setText(this.aeI.ib());
      }
      if (this.afI.getVisibility() != i) {
        this.afI.setVisibility(i);
      }
      return;
    }
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.afJ != null)
    {
      localImageView = this.afJ;
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
    this.aeI = paramj;
    this.afS = 0;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      if ((!paramj.ic()) || (!this.aeI.ic())) {
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
        TextView localTextView = this.afI;
        localObject = this.aeI;
        c = ((j)localObject).ia();
        if (c != 0) {
          break label165;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.afI.getVisibility() != i) {
        this.afI.setVisibility(i);
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
    Resources localResources = ((j)localObject).aaD.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(((j)localObject).aaD.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131755102));
    }
    if (((j)localObject).aaD.hP())
    {
      j = ((j)localObject).aey;
      label236:
      j.a(localStringBuilder, j, 65536, localResources.getString(2131755098));
      j.a(localStringBuilder, j, 4096, localResources.getString(2131755094));
      j.a(localStringBuilder, j, 2, localResources.getString(2131755093));
      j.a(localStringBuilder, j, 1, localResources.getString(2131755099));
      j.a(localStringBuilder, j, 4, localResources.getString(2131755101));
      j.a(localStringBuilder, j, 8, localResources.getString(2131755097));
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
      j = ((j)localObject).aew;
      break label236;
      localStringBuilder.append(localResources.getString(2131755096));
      continue;
      localStringBuilder.append(localResources.getString(2131755095));
      continue;
      localStringBuilder.append(localResources.getString(2131755100));
    }
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    if ((this.afK != null) && (this.afK.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.afK.getLayoutParams();
      int i = paramRect.top;
      int j = this.afK.getHeight();
      int k = localLayoutParams.topMargin;
      paramRect.top = (localLayoutParams.bottomMargin + (j + k) + i);
    }
  }
  
  public final boolean bA()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.aeI;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    t.a(this, this.afM);
    this.Xl = ((TextView)findViewById(2131305902));
    if (this.afN != -1) {
      this.Xl.setTextAppearance(this.afO, this.afN);
    }
    this.afI = ((TextView)findViewById(2131304771));
    this.afJ = ((ImageView)findViewById(2131305514));
    if (this.afJ != null) {
      this.afJ.setImageDrawable(this.afQ);
    }
    this.afK = ((ImageView)findViewById(2131300634));
    this.afL = ((LinearLayout)findViewById(2131298739));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.Xk != null) && (this.afP))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.Xk.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.afG == null) && (this.afH == null)) {}
    label121:
    do
    {
      return;
      Object localObject2;
      if (this.aeI.ie())
      {
        if (this.afG == null) {
          hK();
        }
        localObject2 = this.afG;
      }
      for (Object localObject1 = this.afH;; localObject1 = this.afG)
      {
        if (!paramBoolean) {
          break label121;
        }
        ((CompoundButton)localObject2).setChecked(this.aeI.isChecked());
        if (((CompoundButton)localObject2).getVisibility() != 0) {
          ((CompoundButton)localObject2).setVisibility(0);
        }
        if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject1).setVisibility(8);
        return;
        if (this.afH == null) {
          hL();
        }
        localObject2 = this.afH;
      }
      if (this.afH != null) {
        this.afH.setVisibility(8);
      }
    } while (this.afG == null);
    this.afG.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.aeI.ie()) {
      if (this.afG == null) {
        hK();
      }
    }
    for (Object localObject = this.afG;; localObject = this.afH)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.afH == null) {
        hL();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.aft = paramBoolean;
    this.afP = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.afK != null)
    {
      localImageView = this.afK;
      if ((this.afR) || (!paramBoolean)) {
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
    if ((this.aeI.aaD.agr) || (this.aft))
    {
      i = 1;
      if ((i != 0) || (this.afP)) {
        break label39;
      }
    }
    label39:
    while ((this.Xk == null) && (paramDrawable == null) && (!this.afP))
    {
      return;
      i = 0;
      break;
    }
    if (this.Xk == null)
    {
      this.Xk = ((ImageView)getInflater().inflate(2131492906, this, false));
      A(this.Xk, 0);
    }
    if ((paramDrawable != null) || (this.afP))
    {
      ImageView localImageView = this.Xk;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.Xk.getVisibility() == 0) {
          break;
        }
        this.Xk.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.Xk.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Xl.setText(paramCharSequence);
      if (this.Xl.getVisibility() != 0) {
        this.Xl.setVisibility(0);
      }
    }
    while (this.Xl.getVisibility() == 8) {
      return;
    }
    this.Xl.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */