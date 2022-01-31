package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.j;
import android.support.v7.widget.ax;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
  extends LinearLayout
  implements p.a
{
  private LayoutInflater Lu;
  private TextView NI;
  private boolean UQ;
  private RadioButton Vd;
  private CheckBox Ve;
  private TextView Vf;
  private ImageView Vg;
  private Drawable Vh;
  private Context Vi;
  private boolean Vj;
  private Drawable Vk;
  private int Vl;
  private j cV;
  private int dN;
  private ImageView li;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = ax.a(getContext(), paramAttributeSet, a.j.MenuView, paramInt, 0);
    this.Vh = paramAttributeSet.getDrawable(a.j.MenuView_android_itemBackground);
    this.dN = paramAttributeSet.getResourceId(a.j.MenuView_android_itemTextAppearance, -1);
    this.Vj = paramAttributeSet.getBoolean(a.j.MenuView_preserveIconSpacing, false);
    this.Vi = paramContext;
    this.Vk = paramAttributeSet.getDrawable(a.j.MenuView_subMenuArrow);
    paramAttributeSet.alZ.recycle();
  }
  
  private void fb()
  {
    this.Vd = ((RadioButton)getInflater().inflate(a.g.abc_list_menu_item_radio, this, false));
    addView(this.Vd);
  }
  
  private void fc()
  {
    this.Ve = ((CheckBox)getInflater().inflate(a.g.abc_list_menu_item_checkbox, this, false));
    addView(this.Ve);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.Lu == null) {
      this.Lu = LayoutInflater.from(getContext());
    }
    return this.Lu;
  }
  
  private void setShortcut$25d965e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.cV.fr())) {}
    char c;
    for (int i = 0;; i = 8)
    {
      if (i == 0)
      {
        TextView localTextView = this.Vf;
        c = this.cV.fq();
        if (c != 0) {
          break;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.Vf.getVisibility() != i) {
        this.Vf.setVisibility(i);
      }
      return;
    }
    Object localObject = new StringBuilder(j.Wc);
    switch (c)
    {
    default: 
      ((StringBuilder)localObject).append(c);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      break;
      ((StringBuilder)localObject).append(j.Wd);
      continue;
      ((StringBuilder)localObject).append(j.We);
      continue;
      ((StringBuilder)localObject).append(j.Wf);
    }
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.Vg != null)
    {
      localImageView = this.Vg;
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
  
  public final boolean T()
  {
    return false;
  }
  
  public final void a(j paramj)
  {
    int j = 0;
    this.cV = paramj;
    this.Vl = 0;
    if (paramj.isVisible())
    {
      i = 0;
      setVisibility(i);
      setTitle(paramj.a(this));
      setCheckable(paramj.isCheckable());
      boolean bool = paramj.fr();
      paramj.fq();
      if ((!bool) || (!this.cV.fr())) {
        break label164;
      }
    }
    char c;
    label164:
    for (int i = j;; i = 8)
    {
      if (i == 0)
      {
        TextView localTextView = this.Vf;
        c = this.cV.fq();
        if (c != 0) {
          break label170;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
      }
      if (this.Vf.getVisibility() != i) {
        this.Vf.setVisibility(i);
      }
      setIcon(paramj.getIcon());
      setEnabled(paramj.isEnabled());
      setSubMenuArrowVisible(paramj.hasSubMenu());
      setContentDescription(paramj.getContentDescription());
      return;
      i = 8;
      break;
    }
    label170:
    Object localObject = new StringBuilder(j.Wc);
    switch (c)
    {
    default: 
      ((StringBuilder)localObject).append(c);
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      break;
      ((StringBuilder)localObject).append(j.Wd);
      continue;
      ((StringBuilder)localObject).append(j.We);
      continue;
      ((StringBuilder)localObject).append(j.Wf);
    }
  }
  
  public j getItemData()
  {
    return this.cV;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    q.a(this, this.Vh);
    this.NI = ((TextView)findViewById(a.f.title));
    if (this.dN != -1) {
      this.NI.setTextAppearance(this.Vi, this.dN);
    }
    this.Vf = ((TextView)findViewById(a.f.shortcut));
    this.Vg = ((ImageView)findViewById(a.f.submenuarrow));
    if (this.Vg != null) {
      this.Vg.setImageDrawable(this.Vk);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.li != null) && (this.Vj))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.li.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.Vd == null) && (this.Ve == null)) {}
    label51:
    do
    {
      return;
      Object localObject2;
      Object localObject1;
      if (this.cV.fs())
      {
        if (this.Vd == null) {
          fb();
        }
        localObject2 = this.Vd;
        localObject1 = this.Ve;
        if (!paramBoolean) {
          break label139;
        }
        ((CompoundButton)localObject2).setChecked(this.cV.isChecked());
        if (!paramBoolean) {
          break label133;
        }
      }
      for (int i = 0;; i = 8)
      {
        if (((CompoundButton)localObject2).getVisibility() != i) {
          ((CompoundButton)localObject2).setVisibility(i);
        }
        if ((localObject1 == null) || (((CompoundButton)localObject1).getVisibility() == 8)) {
          break;
        }
        ((CompoundButton)localObject1).setVisibility(8);
        return;
        if (this.Ve == null) {
          fc();
        }
        localObject2 = this.Ve;
        localObject1 = this.Vd;
        break label51;
      }
      if (this.Ve != null) {
        this.Ve.setVisibility(8);
      }
    } while (this.Vd == null);
    label133:
    label139:
    this.Vd.setVisibility(8);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.cV.fs()) {
      if (this.Vd == null) {
        fb();
      }
    }
    for (Object localObject = this.Vd;; localObject = this.Ve)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.Ve == null) {
        fc();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.UQ = paramBoolean;
    this.Vj = paramBoolean;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if ((this.cV.dm.VL) || (this.UQ))
    {
      i = 1;
      if ((i != 0) || (this.Vj)) {
        break label39;
      }
    }
    label39:
    while ((this.li == null) && (paramDrawable == null) && (!this.Vj))
    {
      return;
      i = 0;
      break;
    }
    if (this.li == null)
    {
      this.li = ((ImageView)getInflater().inflate(a.g.abc_list_menu_item_icon, this, false));
      addView(this.li, 0);
    }
    if ((paramDrawable != null) || (this.Vj))
    {
      ImageView localImageView = this.li;
      if (i != 0) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        if (this.li.getVisibility() == 0) {
          break;
        }
        this.li.setVisibility(0);
        return;
        paramDrawable = null;
      }
    }
    this.li.setVisibility(8);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.NI.setText(paramCharSequence);
      if (this.NI.getVisibility() != 0) {
        this.NI.setVisibility(0);
      }
    }
    while (this.NI.getVisibility() == 8) {
      return;
    }
    this.NI.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */