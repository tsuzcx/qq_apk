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
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i
  extends AlertDialog
  implements ViewPager.OnPageChangeListener
{
  private CharSequence Hn;
  private TextView Xy;
  private View jBN;
  private Context mContext;
  private MMDotView oxc;
  private b yyK;
  private IPCallShareViewPager yyL;
  private View.OnClickListener yyM;
  private LinkedList<Integer> yyN;
  
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
      Log.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + localException.getMessage());
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
    setContentView(this.jBN);
    AppMethodBeat.o(25972);
  }
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(25973);
    if (this.yyK.getCount() <= 1)
    {
      this.oxc.setVisibility(4);
      AppMethodBeat.o(25973);
      return;
    }
    this.oxc.setVisibility(0);
    this.oxc.setDotCount(this.yyK.getCount());
    this.oxc.setSelectedDot(paramInt);
    AppMethodBeat.o(25973);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Hn = paramCharSequence;
      return;
    }
    this.Hn = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(25974);
    if ((this.yyN == null) || (this.yyN.size() == 0))
    {
      AppMethodBeat.o(25974);
      return;
    }
    this.yyL.setOnPageChangeListener(this);
    b localb = new b();
    localb.yyO = this.yyM;
    localb.yyT = this.yyN;
    int i;
    if (localb.yyT.size() > 0)
    {
      localb.mCount = ((localb.yyT.size() - 1) / 9 + 1);
      i = 0;
    }
    for (;;)
    {
      if (i >= localb.mCount) {
        break label257;
      }
      View localView = ((LayoutInflater)localb.yyV.mContext.getSystemService("layout_inflater")).inflate(2131495118, null);
      GridView localGridView = (GridView)localView.findViewById(2131302787);
      ArrayList localArrayList = new ArrayList();
      int j = i * 9;
      for (;;)
      {
        if ((j < localb.yyT.size()) && (j < i * 9 + 9))
        {
          localArrayList.add(localb.yyT.get(j));
          j += 1;
          continue;
          localb.mCount = 0;
          break;
        }
      }
      i.a locala = new i.a(localb.yyV.getContext());
      locala.yyO = localb.yyO;
      locala.cvc = localArrayList;
      localGridView.setAdapter(locala);
      localb.yyU.add(localView);
      i += 1;
    }
    label257:
    this.yyK = localb;
    this.yyL.setAdapter(this.yyK);
    this.Xy.setText(this.Hn);
    super.show();
    AppMethodBeat.o(25974);
  }
  
  public final class b
    extends q
  {
    int mCount;
    View.OnClickListener yyO;
    LinkedList<Integer> yyT;
    ArrayList<View> yyU;
    
    public b()
    {
      AppMethodBeat.i(25968);
      this.yyU = new ArrayList();
      this.mCount = 0;
      AppMethodBeat.o(25968);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(25969);
      Log.v("MicroMsg.IPCallShareDialog", "destroy item: %d", new Object[] { Integer.valueOf(paramInt) });
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
      if (this.yyU.get(paramInt) != null) {}
      for (View localView = (View)this.yyU.get(paramInt);; localView = null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i
 * JD-Core Version:    0.7.0.1
 */