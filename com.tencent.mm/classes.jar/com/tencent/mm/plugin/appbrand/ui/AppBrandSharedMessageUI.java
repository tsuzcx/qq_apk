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
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI
  extends MMActivity
{
  private MRecyclerView lCp;
  private ListView mListView;
  
  public int getLayoutId()
  {
    return 2131493058;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48788);
    super.onCreate(paramBundle);
    this.mListView = ((ListView)findViewById(2131301452));
    this.lCp = ((MRecyclerView)findViewById(2131298926));
    this.mListView.setAdapter(new AppBrandSharedMessageUI.b(getLayoutInflater()));
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
    });
    this.lCp.setLayoutManager(new LinearLayoutManager(1));
    this.lCp.setAdapter(new a());
    this.lCp.addHeaderView(getLayoutInflater().inflate(2131493057, null));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI
 * JD-Core Version:    0.7.0.1
 */