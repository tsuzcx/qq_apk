package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.a.a;
import androidx.appcompat.a.f;
import androidx.appcompat.a.g;
import androidx.appcompat.a.h;
import androidx.appcompat.a.j;
import androidx.appcompat.widget.ac;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ListMenuItemView
  extends LinearLayout
  implements AbsListView.SelectionBoundsAdjuster, p.a
{
  private ImageView fN;
  private TextView fO;
  private j lZ;
  private LayoutInflater mInflater;
  private boolean mN;
  private RadioButton nc;
  private CheckBox nd;
  private TextView ne;
  private ImageView nf;
  private ImageView ng;
  private LinearLayout nh;
  private Drawable ni;
  private int nj;
  private Context nk;
  private boolean nl;
  private Drawable nm;
  private boolean nn;
  private int no;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200852);
    paramAttributeSet = ac.a(getContext(), paramAttributeSet, a.j.MenuView, paramInt, 0);
    this.ni = paramAttributeSet.getDrawable(a.j.MenuView_android_itemBackground);
    this.nj = paramAttributeSet.w(a.j.MenuView_android_itemTextAppearance, -1);
    this.nl = paramAttributeSet.m(a.j.MenuView_preserveIconSpacing, false);
    this.nk = paramContext;
    this.nm = paramAttributeSet.getDrawable(a.j.MenuView_subMenuArrow);
    paramContext = paramContext.getTheme();
    paramInt = a.a.dropDownListViewStyle;
    paramContext = paramContext.obtainStyledAttributes(null, new int[] { 16843049 }, paramInt, 0);
    this.nn = paramContext.hasValue(0);
    paramAttributeSet.xv.recycle();
    paramContext.recycle();
    AppMethodBeat.o(200852);
  }
  
  private void cQ()
  {
    AppMethodBeat.i(200881);
    this.nc = ((RadioButton)getInflater().inflate(a.g.abc_list_menu_item_radio, this, false));
    f(this.nc, -1);
    AppMethodBeat.o(200881);
  }
  
  private void cR()
  {
    AppMethodBeat.i(200887);
    this.nd = ((CheckBox)getInflater().inflate(a.g.abc_list_menu_item_checkbox, this, false));
    f(this.nd, -1);
    AppMethodBeat.o(200887);
  }
  
  private void f(View paramView, int paramInt)
  {
    AppMethodBeat.i(200861);
    if (this.nh != null)
    {
      this.nh.addView(paramView, paramInt);
      AppMethodBeat.o(200861);
      return;
    }
    addView(paramView, paramInt);
    AppMethodBeat.o(200861);
  }
  
  private LayoutInflater getInflater()
  {
    AppMethodBeat.i(200898);
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(getContext());
    }
    LayoutInflater localLayoutInflater = this.mInflater;
    AppMethodBeat.o(200898);
    return localLayoutInflater;
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(200870);
    ImageView localImageView;
    if (this.nf != null)
    {
      localImageView = this.nf;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(200870);
      return;
    }
  }
  
  public final void a(j paramj)
  {
    int j = 0;
    AppMethodBeat.i(200951);
    this.lZ = paramj;
    this.no = 0;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      boolean bool = paramj.dh();
      paramj.dg();
      if ((!bool) || (!this.lZ.dh())) {
        break label178;
      }
    }
    Object localObject;
    char c;
    label178:
    for (int i = j;; i = 8)
    {
      if (i == 0)
      {
        TextView localTextView = this.ne;
        localObject = this.lZ;
        c = ((j)localObject).dg();
        if (c != 0) {
          break label184;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.ne.getVisibility() != i) {
        this.ne.setVisibility(i);
      }
      setIcon(paramj.getIcon());
      setEnabled(paramj.isEnabled());
      setSubMenuArrowVisible(paramj.hasSubMenu());
      setContentDescription(paramj.getContentDescription());
      AppMethodBeat.o(200951);
      return;
      i = 8;
      break;
    }
    label184:
    Resources localResources = ((j)localObject).jo.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(((j)localObject).jo.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(a.h.abc_prepend_shortcut_label));
    }
    if (((j)localObject).jo.cV())
    {
      j = ((j)localObject).lP;
      label255:
      j.a(localStringBuilder, j, 65536, localResources.getString(a.h.abc_menu_meta_shortcut_label));
      j.a(localStringBuilder, j, 4096, localResources.getString(a.h.abc_menu_ctrl_shortcut_label));
      j.a(localStringBuilder, j, 2, localResources.getString(a.h.abc_menu_alt_shortcut_label));
      j.a(localStringBuilder, j, 1, localResources.getString(a.h.abc_menu_shift_shortcut_label));
      j.a(localStringBuilder, j, 4, localResources.getString(a.h.abc_menu_sym_shortcut_label));
      j.a(localStringBuilder, j, 8, localResources.getString(a.h.abc_menu_function_shortcut_label));
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
      j = ((j)localObject).lN;
      break label255;
      localStringBuilder.append(localResources.getString(a.h.abc_menu_enter_shortcut_label));
      continue;
      localStringBuilder.append(localResources.getString(a.h.abc_menu_delete_shortcut_label));
      continue;
      localStringBuilder.append(localResources.getString(a.h.abc_menu_space_shortcut_label));
    }
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    AppMethodBeat.i(201054);
    if ((this.ng != null) && (this.ng.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ng.getLayoutParams();
      int i = paramRect.top;
      int j = this.ng.getHeight();
      int k = localLayoutParams.topMargin;
      paramRect.top = (localLayoutParams.bottomMargin + (j + k) + i);
    }
    AppMethodBeat.o(201054);
  }
  
  public final boolean cE()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.lZ;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(200906);
    super.onFinishInflate();
    z.a(this, this.ni);
    this.fO = ((TextView)findViewById(a.f.title));
    if (this.nj != -1) {
      this.fO.setTextAppearance(this.nk, this.nj);
    }
    this.ne = ((TextView)findViewById(a.f.shortcut));
    this.nf = ((ImageView)findViewById(a.f.submenuarrow));
    if (this.nf != null) {
      this.nf.setImageDrawable(this.nm);
    }
    this.ng = ((ImageView)findViewById(a.f.group_divider));
    this.nh = ((LinearLayout)findViewById(a.f.content));
    AppMethodBeat.o(200906);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201033);
    if ((this.fN != null) && (this.nl))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.fN.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(201033);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(200996);
    if ((!paramBoolean) && (this.nc == null) && (this.nd == null))
    {
      AppMethodBeat.o(200996);
      return;
    }
    Object localObject2;
    if (this.lZ.di())
    {
      if (this.nc == null) {
        cQ();
      }
      localObject2 = this.nc;
    }
    for (Object localObject1 = this.nd; paramBoolean; localObject1 = this.nc)
    {
      ((CompoundButton)localObject2).setChecked(this.lZ.isChecked());
      if (((CompoundButton)localObject2).getVisibility() != 0) {
        ((CompoundButton)localObject2).setVisibility(0);
      }
      if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
        break label171;
      }
      ((CompoundButton)localObject1).setVisibility(8);
      AppMethodBeat.o(200996);
      return;
      if (this.nd == null) {
        cR();
      }
      localObject2 = this.nd;
    }
    if (this.nd != null) {
      this.nd.setVisibility(8);
    }
    if (this.nc != null) {
      this.nc.setVisibility(8);
    }
    label171:
    AppMethodBeat.o(200996);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(201007);
    if (this.lZ.di()) {
      if (this.nc == null) {
        cQ();
      }
    }
    for (Object localObject = this.nc;; localObject = this.nd)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      AppMethodBeat.o(201007);
      return;
      if (this.nd == null) {
        cR();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mN = paramBoolean;
    this.nl = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(201045);
    ImageView localImageView;
    if (this.ng != null)
    {
      localImageView = this.ng;
      if ((this.nn) || (!paramBoolean)) {
        break label43;
      }
    }
    label43:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(201045);
      return;
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(201027);
    if ((this.lZ.jo.nN) || (this.mN)) {}
    for (int i = 1; (i == 0) && (!this.nl); i = 0)
    {
      AppMethodBeat.o(201027);
      return;
    }
    if ((this.fN == null) && (paramDrawable == null) && (!this.nl))
    {
      AppMethodBeat.o(201027);
      return;
    }
    if (this.fN == null)
    {
      this.fN = ((ImageView)getInflater().inflate(a.g.abc_list_menu_item_icon, this, false));
      f(this.fN, 0);
    }
    if ((paramDrawable != null) || (this.nl))
    {
      ImageView localImageView = this.fN;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.fN.getVisibility() == 0) {
          break;
        }
        this.fN.setVisibility(0);
        AppMethodBeat.o(201027);
        return;
        paramDrawable = null;
      }
    }
    this.fN.setVisibility(8);
    AppMethodBeat.o(201027);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200971);
    if (paramCharSequence != null)
    {
      this.fO.setText(paramCharSequence);
      if (this.fO.getVisibility() != 0)
      {
        this.fO.setVisibility(0);
        AppMethodBeat.o(200971);
      }
    }
    else if (this.fO.getVisibility() != 8)
    {
      this.fO.setVisibility(8);
    }
    AppMethodBeat.o(200971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */