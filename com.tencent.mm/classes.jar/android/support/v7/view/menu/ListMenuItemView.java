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
  private ImageView Vv;
  private TextView Vw;
  private j acR;
  private boolean adC;
  private RadioButton adP;
  private CheckBox adQ;
  private TextView adR;
  private ImageView adS;
  private ImageView adT;
  private LinearLayout adU;
  private Drawable adV;
  private int adW;
  private Context adX;
  private boolean adY;
  private Drawable adZ;
  private boolean aea;
  private int aeb;
  private LayoutInflater mInflater;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969238);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = az.a(getContext(), paramAttributeSet, a.a.MenuView, paramInt, 0);
    this.adV = paramAttributeSet.getDrawable(5);
    this.adW = paramAttributeSet.getResourceId(1, -1);
    this.adY = paramAttributeSet.getBoolean(7, false);
    this.adX = paramContext;
    this.adZ = paramAttributeSet.getDrawable(8);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, 2130968938, 0);
    this.aea = paramContext.hasValue(0);
    paramAttributeSet.awJ.recycle();
    paramContext.recycle();
  }
  
  private void A(View paramView, int paramInt)
  {
    if (this.adU != null)
    {
      this.adU.addView(paramView, paramInt);
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
  
  private void hu()
  {
    this.adP = ((RadioButton)getInflater().inflate(2131492908, this, false));
    A(this.adP, -1);
  }
  
  private void hv()
  {
    this.adQ = ((CheckBox)getInflater().inflate(2131492905, this, false));
    A(this.adQ, -1);
  }
  
  private void setShortcut$25d965e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.acR.hM())) {}
    for (int i = 0;; i = 8)
    {
      if (i == 0) {
        this.adR.setText(this.acR.hL());
      }
      if (this.adR.getVisibility() != i) {
        this.adR.setVisibility(i);
      }
      return;
    }
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.adS != null)
    {
      localImageView = this.adS;
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
    this.acR = paramj;
    this.aeb = 0;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      if ((!paramj.hM()) || (!this.acR.hM())) {
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
        TextView localTextView = this.adR;
        localObject = this.acR;
        c = ((j)localObject).hK();
        if (c != 0) {
          break label165;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.adR.getVisibility() != i) {
        this.adR.setVisibility(i);
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
    Resources localResources = ((j)localObject).YO.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(((j)localObject).YO.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131755102));
    }
    if (((j)localObject).YO.hz())
    {
      j = ((j)localObject).acH;
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
      j = ((j)localObject).acF;
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
    if ((this.adT != null) && (this.adT.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.adT.getLayoutParams();
      int i = paramRect.top;
      int j = this.adT.getHeight();
      int k = localLayoutParams.topMargin;
      paramRect.top = (localLayoutParams.bottomMargin + (j + k) + i);
    }
  }
  
  public final boolean bl()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.acR;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    t.a(this, this.adV);
    this.Vw = ((TextView)findViewById(2131305902));
    if (this.adW != -1) {
      this.Vw.setTextAppearance(this.adX, this.adW);
    }
    this.adR = ((TextView)findViewById(2131304771));
    this.adS = ((ImageView)findViewById(2131305514));
    if (this.adS != null) {
      this.adS.setImageDrawable(this.adZ);
    }
    this.adT = ((ImageView)findViewById(2131300634));
    this.adU = ((LinearLayout)findViewById(2131298739));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.Vv != null) && (this.adY))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.Vv.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.adP == null) && (this.adQ == null)) {}
    label121:
    do
    {
      return;
      Object localObject2;
      if (this.acR.hN())
      {
        if (this.adP == null) {
          hu();
        }
        localObject2 = this.adP;
      }
      for (Object localObject1 = this.adQ;; localObject1 = this.adP)
      {
        if (!paramBoolean) {
          break label121;
        }
        ((CompoundButton)localObject2).setChecked(this.acR.isChecked());
        if (((CompoundButton)localObject2).getVisibility() != 0) {
          ((CompoundButton)localObject2).setVisibility(0);
        }
        if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject1).setVisibility(8);
        return;
        if (this.adQ == null) {
          hv();
        }
        localObject2 = this.adQ;
      }
      if (this.adQ != null) {
        this.adQ.setVisibility(8);
      }
    } while (this.adP == null);
    this.adP.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.acR.hN()) {
      if (this.adP == null) {
        hu();
      }
    }
    for (Object localObject = this.adP;; localObject = this.adQ)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.adQ == null) {
        hv();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.adC = paramBoolean;
    this.adY = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.adT != null)
    {
      localImageView = this.adT;
      if ((this.aea) || (!paramBoolean)) {
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
    if ((this.acR.YO.aeA) || (this.adC))
    {
      i = 1;
      if ((i != 0) || (this.adY)) {
        break label39;
      }
    }
    label39:
    while ((this.Vv == null) && (paramDrawable == null) && (!this.adY))
    {
      return;
      i = 0;
      break;
    }
    if (this.Vv == null)
    {
      this.Vv = ((ImageView)getInflater().inflate(2131492906, this, false));
      A(this.Vv, 0);
    }
    if ((paramDrawable != null) || (this.adY))
    {
      ImageView localImageView = this.Vv;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.Vv.getVisibility() == 0) {
          break;
        }
        this.Vv.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.Vv.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Vw.setText(paramCharSequence);
      if (this.Vw.getVisibility() != 0) {
        this.Vw.setVisibility(0);
      }
    }
    while (this.Vw.getVisibility() == 8) {
      return;
    }
    this.Vw.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */