package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI
  extends MMActivity
{
  private MRecyclerView iOL;
  private ListView mListView;
  
  public int getLayoutId()
  {
    return 2130968736;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(133097);
    super.onCreate(paramBundle);
    this.mListView = ((ListView)findViewById(2131821401));
    this.iOL = ((MRecyclerView)findViewById(2131821402));
    this.mListView.setAdapter(new AppBrandSharedMessageUI.b(getLayoutInflater()));
    this.mListView.setOnItemClickListener(new AppBrandSharedMessageUI.1(this));
    this.iOL.setLayoutManager(new LinearLayoutManager(1));
    this.iOL.setAdapter(new AppBrandSharedMessageUI.a());
    this.iOL.addHeaderView(getLayoutInflater().inflate(2130968735, null));
    AppMethodBeat.o(133097);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI
 * JD-Core Version:    0.7.0.1
 */