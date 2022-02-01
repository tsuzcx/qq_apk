package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI
  extends MMActivity
{
  private ListView mListView;
  private MRecyclerView uem;
  
  public int getLayoutId()
  {
    return ba.g.app_brand_shared_message_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48788);
    super.onCreate(paramBundle);
    this.mListView = ((ListView)findViewById(ba.f.list_view));
    this.uem = ((MRecyclerView)findViewById(ba.f.data_rv));
    this.mListView.setAdapter(new b(getLayoutInflater()));
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(322457);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandSharedMessageUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSharedMessageUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(322457);
      }
    });
    this.uem.setLayoutManager(new LinearLayoutManager(1, false));
    this.uem.setAdapter(new a());
    this.uem.ev(getLayoutInflater().inflate(ba.g.app_brand_shared_message_list_header, null));
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
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      return null;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt) {}
    
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