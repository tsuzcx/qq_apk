package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI
  extends MMActivity
{
  private ListView mListView;
  private MRecyclerView nWH;
  
  public int getLayoutId()
  {
    return 2131493097;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48788);
    super.onCreate(paramBundle);
    this.mListView = ((ListView)findViewById(2131303237));
    this.nWH = ((MRecyclerView)findViewById(2131299410));
    this.mListView.setAdapter(new b(getLayoutInflater()));
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(227669);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSharedMessageUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSharedMessageUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(227669);
      }
    });
    this.nWH.setLayoutManager(new LinearLayoutManager(1, false));
    this.nWH.setAdapter(new a());
    this.nWH.addHeaderView(getLayoutInflater().inflate(2131493096, null));
    AppMethodBeat.o(48788);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends RecyclerView.a
  {
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      return null;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt) {}
    
    public final int getItemCount()
    {
      return 0;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(48786);
      paramInt = super.getItemViewType(paramInt);
      AppMethodBeat.o(48786);
      return paramInt;
    }
  }
  
  static final class b
    extends BaseAdapter
  {
    private LayoutInflater mInflater;
    
    public b(LayoutInflater paramLayoutInflater)
    {
      this.mInflater = paramLayoutInflater;
    }
    
    public final int getCount()
    {
      return 0;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(48787);
      paramInt = super.getItemViewType(paramInt);
      AppMethodBeat.o(48787);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return null;
    }
    
    public final int getViewTypeCount()
    {
      return 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI
 * JD-Core Version:    0.7.0.1
 */