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
  private TextView UA;
  private ImageView Uz;
  private j abX;
  private boolean acI;
  private RadioButton acV;
  private CheckBox acW;
  private TextView acX;
  private ImageView acY;
  private ImageView acZ;
  private LinearLayout ada;
  private Drawable adb;
  private int adc;
  private Context add;
  private boolean ade;
  private Drawable adf;
  private boolean adg;
  private int adh;
  private LayoutInflater mInflater;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969238);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = az.a(getContext(), paramAttributeSet, a.a.MenuView, paramInt, 0);
    this.adb = paramAttributeSet.getDrawable(5);
    this.adc = paramAttributeSet.getResourceId(1, -1);
    this.ade = paramAttributeSet.getBoolean(7, false);
    this.add = paramContext;
    this.adf = paramAttributeSet.getDrawable(8);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, 2130968938, 0);
    this.adg = paramContext.hasValue(0);
    paramAttributeSet.avP.recycle();
    paramContext.recycle();
  }
  
  private void A(View paramView, int paramInt)
  {
    if (this.ada != null)
    {
      this.ada.addView(paramView, paramInt);
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
  
  private void hm()
  {
    this.acV = ((RadioButton)getInflater().inflate(2131492908, this, false));
    A(this.acV, -1);
  }
  
  private void hn()
  {
    this.acW = ((CheckBox)getInflater().inflate(2131492905, this, false));
    A(this.acW, -1);
  }
  
  private void setShortcut$25d965e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.abX.hE())) {}
    for (int i = 0;; i = 8)
    {
      if (i == 0) {
        this.acX.setText(this.abX.hD());
      }
      if (this.acX.getVisibility() != i) {
        this.acX.setVisibility(i);
      }
      return;
    }
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.acY != null)
    {
      localImageView = this.acY;
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
    this.abX = paramj;
    this.adh = 0;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      if ((!paramj.hE()) || (!this.abX.hE())) {
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
        TextView localTextView = this.acX;
        localObject = this.abX;
        c = ((j)localObject).hC();
        if (c != 0) {
          break label165;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.acX.getVisibility() != i) {
        this.acX.setVisibility(i);
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
    Resources localResources = ((j)localObject).XT.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(((j)localObject).XT.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131755102));
    }
    if (((j)localObject).XT.hr())
    {
      j = ((j)localObject).abN;
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
      j = ((j)localObject).abL;
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
    if ((this.acZ != null) && (this.acZ.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.acZ.getLayoutParams();
      int i = paramRect.top;
      int j = this.acZ.getHeight();
      int k = localLayoutParams.topMargin;
      paramRect.top = (localLayoutParams.bottomMargin + (j + k) + i);
    }
  }
  
  public final boolean be()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.abX;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    t.a(this, this.adb);
    this.UA = ((TextView)findViewById(2131305902));
    if (this.adc != -1) {
      this.UA.setTextAppearance(this.add, this.adc);
    }
    this.acX = ((TextView)findViewById(2131304771));
    this.acY = ((ImageView)findViewById(2131305514));
    if (this.acY != null) {
      this.acY.setImageDrawable(this.adf);
    }
    this.acZ = ((ImageView)findViewById(2131300634));
    this.ada = ((LinearLayout)findViewById(2131298739));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.Uz != null) && (this.ade))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.Uz.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.acV == null) && (this.acW == null)) {}
    label121:
    do
    {
      return;
      Object localObject2;
      if (this.abX.hF())
      {
        if (this.acV == null) {
          hm();
        }
        localObject2 = this.acV;
      }
      for (Object localObject1 = this.acW;; localObject1 = this.acV)
      {
        if (!paramBoolean) {
          break label121;
        }
        ((CompoundButton)localObject2).setChecked(this.abX.isChecked());
        if (((CompoundButton)localObject2).getVisibility() != 0) {
          ((CompoundButton)localObject2).setVisibility(0);
        }
        if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject1).setVisibility(8);
        return;
        if (this.acW == null) {
          hn();
        }
        localObject2 = this.acW;
      }
      if (this.acW != null) {
        this.acW.setVisibility(8);
      }
    } while (this.acV == null);
    this.acV.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.abX.hF()) {
      if (this.acV == null) {
        hm();
      }
    }
    for (Object localObject = this.acV;; localObject = this.acW)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.acW == null) {
        hn();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.acI = paramBoolean;
    this.ade = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.acZ != null)
    {
      localImageView = this.acZ;
      if ((this.adg) || (!paramBoolean)) {
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
    if ((this.abX.XT.adG) || (this.acI))
    {
      i = 1;
      if ((i != 0) || (this.ade)) {
        break label39;
      }
    }
    label39:
    while ((this.Uz == null) && (paramDrawable == null) && (!this.ade))
    {
      return;
      i = 0;
      break;
    }
    if (this.Uz == null)
    {
      this.Uz = ((ImageView)getInflater().inflate(2131492906, this, false));
      A(this.Uz, 0);
    }
    if ((paramDrawable != null) || (this.ade))
    {
      ImageView localImageView = this.Uz;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.Uz.getVisibility() == 0) {
          break;
        }
        this.Uz.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.Uz.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.UA.setText(paramCharSequence);
      if (this.UA.getVisibility() != 0) {
        this.UA.setVisibility(0);
      }
    }
    while (this.UA.getVisibility() == 8) {
      return;
    }
    this.UA.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */