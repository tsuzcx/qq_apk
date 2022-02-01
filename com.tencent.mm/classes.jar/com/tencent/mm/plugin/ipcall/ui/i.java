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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class i
  extends AlertDialog
  implements ViewPager.OnPageChangeListener
{
  private CharSequence Fm;
  private TextView Vw;
  private View ijA;
  private Context mContext;
  private MMDotView mHQ;
  private b tRL;
  private IPCallShareViewPager tRM;
  private View.OnClickListener tRN;
  private LinkedList<Integer> tRO;
  
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
      ac.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + localException.getMessage());
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
    setContentView(this.ijA);
    AppMethodBeat.o(25972);
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(25973);
    if (this.tRL.getCount() <= 1)
    {
      this.mHQ.setVisibility(4);
      AppMethodBeat.o(25973);
      return;
    }
    this.mHQ.setVisibility(0);
    this.mHQ.setDotCount(this.tRL.getCount());
    this.mHQ.setSelectedDot(paramInt);
    AppMethodBeat.o(25973);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Fm = paramCharSequence;
      return;
    }
    this.Fm = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(25974);
    if ((this.tRO == null) || (this.tRO.size() == 0))
    {
      AppMethodBeat.o(25974);
      return;
    }
    this.tRM.setOnPageChangeListener(this);
    b localb = new b();
    localb.tRP = this.tRN;
    localb.tRU = this.tRO;
    int i;
    if (localb.tRU.size() > 0)
    {
      localb.mCount = ((localb.tRU.size() - 1) / 9 + 1);
      i = 0;
    }
    for (;;)
    {
      if (i >= localb.mCount) {
        break label257;
      }
      View localView = ((LayoutInflater)localb.tRW.mContext.getSystemService("layout_inflater")).inflate(2131494526, null);
      GridView localGridView = (GridView)localView.findViewById(2131301133);
      ArrayList localArrayList = new ArrayList();
      int j = i * 9;
      for (;;)
      {
        if ((j < localb.tRU.size()) && (j < i * 9 + 9))
        {
          localArrayList.add(localb.tRU.get(j));
          j += 1;
          continue;
          localb.mCount = 0;
          break;
        }
      }
      a locala = new a(localb.tRW.getContext());
      locala.tRP = localb.tRP;
      locala.bYM = localArrayList;
      localGridView.setAdapter(locala);
      localb.tRV.add(localView);
      i += 1;
    }
    label257:
    this.tRL = localb;
    this.tRM.setAdapter(this.tRL);
    this.Vw.setText(this.Fm);
    super.show();
    AppMethodBeat.o(25974);
  }
  
  public static final class a
    extends BaseAdapter
  {
    List<Integer> bYM;
    private Context mContext;
    View.OnClickListener tRP;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(25964);
      this.bYM = null;
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
      if (this.bYM == null)
      {
        AppMethodBeat.o(25965);
        return 0;
      }
      int i = this.bYM.size();
      AppMethodBeat.o(25965);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25966);
      if (this.bYM != null)
      {
        Object localObject = this.bYM.get(paramInt);
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
        paramViewGroup.tRR = ((RelativeLayout)paramView.findViewById(2131301339));
        paramViewGroup.tRS = ((TextView)paramView.findViewById(2131301132));
        paramViewGroup.tRT = ((ImageView)paramView.findViewById(2131301131));
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
      IPCallShareCouponCardUI.a(this.mContext, paramViewGroup.id, paramViewGroup.tRS, paramViewGroup.tRT);
      paramViewGroup.tRR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25963);
          if (i.a.a(i.a.this) != null) {
            i.a.a(i.a.this).onClick(paramAnonymousView);
          }
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
      RelativeLayout tRR;
      TextView tRS;
      ImageView tRT;
      
      public a() {}
    }
  }
  
  public final class b
    extends q
  {
    int mCount;
    View.OnClickListener tRP;
    LinkedList<Integer> tRU;
    ArrayList<View> tRV;
    
    public b()
    {
      AppMethodBeat.i(25968);
      this.tRV = new ArrayList();
      this.mCount = 0;
      AppMethodBeat.o(25968);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(25969);
      ac.v("MicroMsg.IPCallShareDialog", "destroy item: %d", new Object[] { Integer.valueOf(paramInt) });
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
      if (this.tRV.get(paramInt) != null) {}
      for (View localView = (View)this.tRV.get(paramInt);; localView = null)
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