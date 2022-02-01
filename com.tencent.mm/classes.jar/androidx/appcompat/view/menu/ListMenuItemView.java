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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ListMenuItemView
  extends LinearLayout
  implements AbsListView.SelectionBoundsAdjuster, p.a
{
  private ImageView eL;
  private TextView eM;
  private boolean lQ;
  private j ld;
  private LayoutInflater mInflater;
  private RadioButton md;
  private CheckBox me;
  private TextView mf;
  private ImageView mg;
  private ImageView mh;
  private LinearLayout mi;
  private Drawable mj;
  private int mk;
  private Context ml;
  private boolean mm;
  private Drawable mn;
  private boolean mo;
  private int mp;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239245);
    paramAttributeSet = ac.a(getContext(), paramAttributeSet, a.j.MenuView, paramInt, 0);
    this.mj = paramAttributeSet.getDrawable(a.j.MenuView_android_itemBackground);
    this.mk = paramAttributeSet.r(a.j.MenuView_android_itemTextAppearance, -1);
    this.mm = paramAttributeSet.c(a.j.MenuView_preserveIconSpacing, false);
    this.ml = paramContext;
    this.mn = paramAttributeSet.getDrawable(a.j.MenuView_subMenuArrow);
    paramContext = paramContext.getTheme();
    paramInt = a.a.dropDownListViewStyle;
    paramContext = paramContext.obtainStyledAttributes(null, new int[] { 16843049 }, paramInt, 0);
    this.mo = paramContext.hasValue(0);
    paramAttributeSet.wA.recycle();
    paramContext.recycle();
    AppMethodBeat.o(239245);
  }
  
  private void bX()
  {
    AppMethodBeat.i(239260);
    this.md = ((RadioButton)getInflater().inflate(a.g.abc_list_menu_item_radio, this, false));
    f(this.md, -1);
    AppMethodBeat.o(239260);
  }
  
  private void bY()
  {
    AppMethodBeat.i(239262);
    this.me = ((CheckBox)getInflater().inflate(a.g.abc_list_menu_item_checkbox, this, false));
    f(this.me, -1);
    AppMethodBeat.o(239262);
  }
  
  private void f(View paramView, int paramInt)
  {
    AppMethodBeat.i(239249);
    if (this.mi != null)
    {
      this.mi.addView(paramView, paramInt);
      AppMethodBeat.o(239249);
      return;
    }
    addView(paramView, paramInt);
    AppMethodBeat.o(239249);
  }
  
  private LayoutInflater getInflater()
  {
    AppMethodBeat.i(239264);
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(getContext());
    }
    LayoutInflater localLayoutInflater = this.mInflater;
    AppMethodBeat.o(239264);
    return localLayoutInflater;
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(239256);
    ImageView localImageView;
    if (this.mg != null)
    {
      localImageView = this.mg;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(239256);
      return;
    }
  }
  
  public final void a(j paramj)
  {
    int j = 0;
    AppMethodBeat.i(239248);
    this.ld = paramj;
    this.mp = 0;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      boolean bool = paramj.co();
      paramj.cn();
      if ((!bool) || (!this.ld.co())) {
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
        TextView localTextView = this.mf;
        localObject = this.ld;
        c = ((j)localObject).cn();
        if (c != 0) {
          break label184;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.mf.getVisibility() != i) {
        this.mf.setVisibility(i);
      }
      setIcon(paramj.getIcon());
      setEnabled(paramj.isEnabled());
      setSubMenuArrowVisible(paramj.hasSubMenu());
      setContentDescription(paramj.getContentDescription());
      AppMethodBeat.o(239248);
      return;
      i = 8;
      break;
    }
    label184:
    Resources localResources = ((j)localObject).is.mContext.getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(((j)localObject).is.mContext).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(a.h.abc_prepend_shortcut_label));
    }
    if (((j)localObject).is.cc())
    {
      j = ((j)localObject).kT;
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
      j = ((j)localObject).kR;
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
    AppMethodBeat.i(239267);
    if ((this.mh != null) && (this.mh.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mh.getLayoutParams();
      int i = paramRect.top;
      int j = this.mh.getHeight();
      int k = localLayoutParams.topMargin;
      paramRect.top = (localLayoutParams.bottomMargin + (j + k) + i);
    }
    AppMethodBeat.o(239267);
  }
  
  public final boolean bL()
  {
    return false;
  }
  
  public j getItemData()
  {
    return this.ld;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(239246);
    super.onFinishInflate();
    w.a(this, this.mj);
    this.eM = ((TextView)findViewById(a.f.title));
    if (this.mk != -1) {
      this.eM.setTextAppearance(this.ml, this.mk);
    }
    this.mf = ((TextView)findViewById(a.f.shortcut));
    this.mg = ((ImageView)findViewById(a.f.submenuarrow));
    if (this.mg != null) {
      this.mg.setImageDrawable(this.mn);
    }
    this.mh = ((ImageView)findViewById(a.f.group_divider));
    this.mi = ((LinearLayout)findViewById(a.f.content));
    AppMethodBeat.o(239246);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239259);
    if ((this.eL != null) && (this.mm))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.eL.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(239259);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(239253);
    if ((!paramBoolean) && (this.md == null) && (this.me == null))
    {
      AppMethodBeat.o(239253);
      return;
    }
    Object localObject2;
    if (this.ld.cp())
    {
      if (this.md == null) {
        bX();
      }
      localObject2 = this.md;
    }
    for (Object localObject1 = this.me; paramBoolean; localObject1 = this.md)
    {
      ((CompoundButton)localObject2).setChecked(this.ld.isChecked());
      if (((CompoundButton)localObject2).getVisibility() != 0) {
        ((CompoundButton)localObject2).setVisibility(0);
      }
      if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
        break label171;
      }
      ((CompoundButton)localObject1).setVisibility(8);
      AppMethodBeat.o(239253);
      return;
      if (this.me == null) {
        bY();
      }
      localObject2 = this.me;
    }
    if (this.me != null) {
      this.me.setVisibility(8);
    }
    if (this.md != null) {
      this.md.setVisibility(8);
    }
    label171:
    AppMethodBeat.o(239253);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(239255);
    if (this.ld.cp()) {
      if (this.md == null) {
        bX();
      }
    }
    for (Object localObject = this.md;; localObject = this.me)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      AppMethodBeat.o(239255);
      return;
      if (this.me == null) {
        bY();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.lQ = paramBoolean;
    this.mm = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(239265);
    ImageView localImageView;
    if (this.mh != null)
    {
      localImageView = this.mh;
      if ((this.mo) || (!paramBoolean)) {
        break label43;
      }
    }
    label43:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(239265);
      return;
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(239258);
    if ((this.ld.is.mP) || (this.lQ)) {}
    for (int i = 1; (i == 0) && (!this.mm); i = 0)
    {
      AppMethodBeat.o(239258);
      return;
    }
    if ((this.eL == null) && (paramDrawable == null) && (!this.mm))
    {
      AppMethodBeat.o(239258);
      return;
    }
    if (this.eL == null)
    {
      this.eL = ((ImageView)getInflater().inflate(a.g.abc_list_menu_item_icon, this, false));
      f(this.eL, 0);
    }
    if ((paramDrawable != null) || (this.mm))
    {
      ImageView localImageView = this.eL;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.eL.getVisibility() == 0) {
          break;
        }
        this.eL.setVisibility(0);
        AppMethodBeat.o(239258);
        return;
        paramDrawable = null;
      }
    }
    this.eL.setVisibility(8);
    AppMethodBeat.o(239258);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239250);
    if (paramCharSequence != null)
    {
      this.eM.setText(paramCharSequence);
      if (this.eM.getVisibility() != 0)
      {
        this.eM.setVisibility(0);
        AppMethodBeat.o(239250);
      }
    }
    else if (this.eM.getVisibility() != 8)
    {
      this.eM.setVisibility(8);
    }
    AppMethodBeat.o(239250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */