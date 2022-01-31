package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI
  extends MMActivity
{
  private ListView Nn;
  private MRecyclerView hdY;
  
  protected final int getLayoutId()
  {
    return y.h.app_brand_shared_message_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.Nn = ((ListView)findViewById(y.g.list_view));
    this.hdY = ((MRecyclerView)findViewById(y.g.data_rv));
    this.Nn.setAdapter(new AppBrandSharedMessageUI.b(getLayoutInflater()));
    this.Nn.setOnItemClickListener(new AppBrandSharedMessageUI.1(this));
    this.hdY.setLayoutManager(new LinearLayoutManager(1));
    this.hdY.setAdapter(new AppBrandSharedMessageUI.a());
    this.hdY.addHeaderView(getLayoutInflater().inflate(y.h.app_brand_shared_message_list_header, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI
 * JD-Core Version:    0.7.0.1
 */