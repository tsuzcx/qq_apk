package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class a
  extends RecyclerView.a
{
  private static final SimpleDateFormat hEc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
  LayoutInflater Lu;
  List<LogInfo> hEd;
  
  a(Context paramContext)
  {
    this.Lu = LayoutInflater.from(paramContext);
    this.hEd = new LinkedList();
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a.a(this.Lu.inflate(b.c.console_log_item, paramViewGroup, false), paramInt);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    LogInfo localLogInfo = (LogInfo)this.hEd.get(paramInt);
    ((a.a)paramv).fuN.setText(String.format("[%s] %s", new Object[] { hEc.format(new Date(localLogInfo.ts)), localLogInfo.message }));
  }
  
  public final int getItemCount()
  {
    return this.hEd.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ((LogInfo)this.hEd.get(paramInt)).level;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.a
 * JD-Core Version:    0.7.0.1
 */