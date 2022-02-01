package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class i
  extends AlertDialog
  implements ViewPager.OnPageChangeListener
{
  private CharSequence Hd;
  private TextView Xl;
  private View iCR;
  private Context mContext;
  private MMDotView nio;
  private View.OnClickListener uUA;
  private LinkedList<Integer> uUB;
  private b uUy;
  private IPCallShareViewPager uUz;
  
  public final void dismiss()
  {
    AppMethodBeat.i(25975);
    try
    {
      super.dismiss();
      AppMethodBeat.o(25975);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(25975);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25972);
    super.onCreate(paramBundle);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().setGravity(80);
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    setContentView(this.iCR);
    AppMethodBeat.o(25972);
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(25973);
    if (this.uUy.getCount() <= 1)
    {
      this.nio.setVisibility(4);
      AppMethodBeat.o(25973);
      return;
    }
    this.nio.setVisibility(0);
    this.nio.setDotCount(this.uUy.getCount());
    this.nio.setSelectedDot(paramInt);
    AppMethodBeat.o(25973);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Hd = paramCharSequence;
      return;
    }
    this.Hd = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(25974);
    if ((this.uUB == null) || (this.uUB.size() == 0))
    {
      AppMethodBeat.o(25974);
      return;
    }
    this.uUz.setOnPageChangeListener(this);
    b localb = new b();
    localb.uUC = this.uUA;
    localb.uUH = this.uUB;
    int i;
    if (localb.uUH.size() > 0)
    {
      localb.mCount = ((localb.uUH.size() - 1) / 9 + 1);
      i = 0;
    }
    for (;;)
    {
      if (i >= localb.mCount) {
        break label257;
      }
      View localView = ((LayoutInflater)localb.uUJ.mContext.getSystemService("layout_inflater")).inflate(2131494526, null);
      GridView localGridView = (GridView)localView.findViewById(2131301133);
      ArrayList localArrayList = new ArrayList();
      int j = i * 9;
      for (;;)
      {
        if ((j < localb.uUH.size()) && (j < i * 9 + 9))
        {
          localArrayList.add(localb.uUH.get(j));
          j += 1;
          continue;
          localb.mCount = 0;
          break;
        }
      }
      a locala = new a(localb.uUJ.getContext());
      locala.uUC = localb.uUC;
      locala.cje = localArrayList;
      localGridView.setAdapter(locala);
      localb.uUI.add(localView);
      i += 1;
    }
    label257:
    this.uUy = localb;
    this.uUz.setAdapter(this.uUy);
    this.Xl.setText(this.Hd);
    super.show();
    AppMethodBeat.o(25974);
  }
  
  public static final class a
    extends BaseAdapter
  {
    List<Integer> cje;
    private Context mContext;
    View.OnClickListener uUC;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(25964);
      this.cje = null;
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.mContext = paramContext;
        AppMethodBeat.o(25964);
        return;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25965);
      if (this.cje == null)
      {
        AppMethodBeat.o(25965);
        return 0;
      }
      int i = this.cje.size();
      AppMethodBeat.o(25965);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25966);
      if (this.cje != null)
      {
        Object localObject = this.cje.get(paramInt);
        AppMethodBeat.o(25966);
        return localObject;
      }
      AppMethodBeat.o(25966);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25967);
      if (paramView == null)
      {
        paramView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131494527, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.uUE = ((RelativeLayout)paramView.findViewById(2131301339));
        paramViewGroup.uUF = ((TextView)paramView.findViewById(2131301132));
        paramViewGroup.uUG = ((ImageView)paramView.findViewById(2131301131));
        paramView.setTag(paramViewGroup);
      }
      Object localObject;
      for (;;)
      {
        localObject = getItem(paramInt);
        if (localObject != null) {
          break;
        }
        AppMethodBeat.o(25967);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.id = ((Integer)localObject).intValue();
      IPCallShareCouponCardUI.a(this.mContext, paramViewGroup.id, paramViewGroup.uUF, paramViewGroup.uUG);
      paramViewGroup.uUE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25963);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareDialog$IPCallShareItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (i.a.a(i.a.this) != null) {
            i.a.a(i.a.this).onClick(paramAnonymousView);
          }
          a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareDialog$IPCallShareItemAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25963);
        }
      });
      AppMethodBeat.o(25967);
      return paramView;
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final class a
    {
      int id;
      RelativeLayout uUE;
      TextView uUF;
      ImageView uUG;
      
      public a() {}
    }
  }
  
  public final class b
    extends q
  {
    int mCount;
    View.OnClickListener uUC;
    LinkedList<Integer> uUH;
    ArrayList<View> uUI;
    
    public b()
    {
      AppMethodBeat.i(25968);
      this.uUI = new ArrayList();
      this.mCount = 0;
      AppMethodBeat.o(25968);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(25969);
      ad.v("MicroMsg.IPCallShareDialog", "destroy item: %d", new Object[] { Integer.valueOf(paramInt) });
      paramViewGroup.removeView((View)paramObject);
      AppMethodBeat.o(25969);
    }
    
    public final int getCount()
    {
      return this.mCount;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(25971);
      int i = super.getItemPosition(paramObject);
      AppMethodBeat.o(25971);
      return i;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(25970);
      if (this.uUI.get(paramInt) != null) {}
      for (View localView = (View)this.uUI.get(paramInt);; localView = null)
      {
        if (localView != null)
        {
          if (localView.getParent() != null) {
            ((ViewGroup)localView.getParent()).removeView(localView);
          }
          if (paramViewGroup != null) {
            paramViewGroup.addView(localView, 0);
          }
        }
        AppMethodBeat.o(25970);
        return localView;
      }
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i
 * JD-Core Version:    0.7.0.1
 */