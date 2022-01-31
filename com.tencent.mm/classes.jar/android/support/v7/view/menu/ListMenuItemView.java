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
  private TextView Nx;
  private boolean VD;
  private RadioButton VQ;
  private CheckBox VR;
  private TextView VS;
  private ImageView VT;
  private ImageView VU;
  private LinearLayout VV;
  private Drawable VW;
  private Context VX;
  private boolean VY;
  private Drawable VZ;
  private boolean Wa;
  private int Wb;
  private j dZ;
  private int eP;
  private LayoutInflater mInflater;
  private ImageView me;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772237);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = az.a(getContext(), paramAttributeSet, a.a.MenuView, paramInt, 0);
    this.VW = paramAttributeSet.getDrawable(5);
    this.eP = paramAttributeSet.getResourceId(1, -1);
    this.VY = paramAttributeSet.getBoolean(7, false);
    this.VX = paramContext;
    this.VZ = paramAttributeSet.getDrawable(8);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, 2130772197, 0);
    this.Wa = paramContext.hasValue(0);
    paramAttributeSet.aoo.recycle();
    paramContext.recycle();
  }
  
  private void fQ()
  {
    this.VQ = ((RadioButton)getInflater().inflate(2130968601, this, false));
    y(this.VQ, -1);
  }
  
  private void fR()
  {
    this.VR = ((CheckBox)getInflater().inflate(2130968598, this, false));
    y(this.VR, -1);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(getContext());
    }
    return this.mInflater;
  }
  
  private void setShortcut$25d965e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.dZ.gj())) {}
    for (int i = 0;; i = 8)
    {
      if (i == 0) {
        this.VS.setText(this.dZ.gi());
      }
      if (this.VS.getVisibility() != i) {
        this.VS.setVisibility(i);
      }
      return;
    }
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.VT != null)
    {
      localImageView = this.VT;
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
  
  private void y(View paramView, int paramInt)
  {
    if (this.VV != null)
    {
      this.VV.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }
  
  public final void a(j paramj)
  {
    int j = 0;
    this.dZ = paramj;
    this.Wb = 0;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      if ((!paramj.gj()) || (!this.dZ.gj())) {
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
        TextView localTextView = this.VS;
        localObject = this.dZ;
        c = ((j)localObject).gh();
        if (c != 0) {
          break label165;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.VS.getVisibility() != i) {
        this.VS.setVisibility(i);
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
    Resources localResources = ((j)localObject).eq.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(((j)localObject).eq.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(2131296273));
    }
    if (((j)localObject).eq.fV())
    {
      j = ((j)localObject).UK;
      label236:
      j.a(localStringBuilder, j, 65536, localResources.getString(2131296269));
      j.a(localStringBuilder, j, 4096, localResources.getString(2131296265));
      j.a(localStringBuilder, j, 2, localResources.getString(2131296264));
      j.a(localStringBuilder, j, 1, localResources.getString(2131296270));
      j.a(localStringBuilder, j, 4, localResources.getString(2131296272));
      j.a(localStringBuilder, j, 8, localResources.getString(2131296268));
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
      j = ((j)localObject).UI;
      break label236;
      localStringBuilder.append(localResources.getString(2131296267));
      continue;
      localStringBuilder.append(localResources.getString(2131296266));
      continue;
      localStringBuilder.append(localResources.getString(2131296271));
    }
  }
  
  public final boolean aE()
  {
    return false;
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    if ((this.VU != null) && (this.VU.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.VU.getLayoutParams();
      int i = paramRect.top;
      int j = this.VU.getHeight();
      int k = localLayoutParams.topMargin;
      paramRect.top = (localLayoutParams.bottomMargin + (j + k) + i);
    }
  }
  
  public j getItemData()
  {
    return this.dZ;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    t.a(this, this.VW);
    this.Nx = ((TextView)findViewById(2131820680));
    if (this.eP != -1) {
      this.Nx.setTextAppearance(this.VX, this.eP);
    }
    this.VS = ((TextView)findViewById(2131820947));
    this.VT = ((ImageView)findViewById(2131820948));
    if (this.VT != null) {
      this.VT.setImageDrawable(this.VZ);
    }
    this.VU = ((ImageView)findViewById(2131820945));
    this.VV = ((LinearLayout)findViewById(2131820946));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.me != null) && (this.VY))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.me.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.VQ == null) && (this.VR == null)) {}
    label121:
    do
    {
      return;
      Object localObject2;
      if (this.dZ.gk())
      {
        if (this.VQ == null) {
          fQ();
        }
        localObject2 = this.VQ;
      }
      for (Object localObject1 = this.VR;; localObject1 = this.VQ)
      {
        if (!paramBoolean) {
          break label121;
        }
        ((CompoundButton)localObject2).setChecked(this.dZ.isChecked());
        if (((CompoundButton)localObject2).getVisibility() != 0) {
          ((CompoundButton)localObject2).setVisibility(0);
        }
        if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject1).setVisibility(8);
        return;
        if (this.VR == null) {
          fR();
        }
        localObject2 = this.VR;
      }
      if (this.VR != null) {
        this.VR.setVisibility(8);
      }
    } while (this.VQ == null);
    this.VQ.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.dZ.gk()) {
      if (this.VQ == null) {
        fQ();
      }
    }
    for (Object localObject = this.VQ;; localObject = this.VR)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.VR == null) {
        fR();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.VD = paramBoolean;
    this.VY = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.VU != null)
    {
      localImageView = this.VU;
      if ((this.Wa) || (!paramBoolean)) {
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
    if ((this.dZ.eq.WA) || (this.VD))
    {
      i = 1;
      if ((i != 0) || (this.VY)) {
        break label39;
      }
    }
    label39:
    while ((this.me == null) && (paramDrawable == null) && (!this.VY))
    {
      return;
      i = 0;
      break;
    }
    if (this.me == null)
    {
      this.me = ((ImageView)getInflater().inflate(2130968599, this, false));
      y(this.me, 0);
    }
    if ((paramDrawable != null) || (this.VY))
    {
      ImageView localImageView = this.me;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.me.getVisibility() == 0) {
          break;
        }
        this.me.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.me.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Nx.setText(paramCharSequence);
      if (this.Nx.getVisibility() != 0) {
        this.Nx.setVisibility(0);
      }
    }
    while (this.Nx.getVisibility() == 8) {
      return;
    }
    this.Nx.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */