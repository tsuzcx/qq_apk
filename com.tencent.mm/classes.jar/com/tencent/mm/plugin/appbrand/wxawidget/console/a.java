package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.b.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class a
  extends RecyclerView.a
{
  private static final SimpleDateFormat rHp;
  LayoutInflater mInflater;
  List<LogInfo> rHq;
  
  static
  {
    AppMethodBeat.i(121614);
    rHp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    AppMethodBeat.o(121614);
  }
  
  a(Context paramContext)
  {
    AppMethodBeat.i(121609);
    this.mInflater = LayoutInflater.from(paramContext);
    this.rHq = new LinkedList();
    AppMethodBeat.o(121609);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(248202);
    paramViewGroup = new a(this.mInflater.inflate(b.b.console_log_item, paramViewGroup, false), paramInt);
    AppMethodBeat.o(248202);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(248205);
    LogInfo localLogInfo = (LogInfo)this.rHq.get(paramInt);
    ((a)paramv).kMh.setText(String.format("[%s] %s", new Object[] { rHp.format(new Date(localLogInfo.ts)), localLogInfo.message }));
    AppMethodBeat.o(248205);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(121612);
    int i = this.rHq.size();
    AppMethodBeat.o(121612);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(121613);
    paramInt = ((LogInfo)this.rHq.get(paramInt)).level;
    AppMethodBeat.o(121613);
    return paramInt;
  }
  
  static final class a
    extends RecyclerView.v
  {
    TextView kMh;
    TextView rHr;
    
    public a(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(121608);
      this.rHr = ((TextView)paramView.findViewById(b.a.level_tv));
      this.kMh = ((TextView)paramView.findViewById(b.a.content_tv));
      switch (paramInt)
      {
      default: 
        this.rHr.setText("L");
        this.kMh.setTextColor(-7829368);
        AppMethodBeat.o(121608);
        return;
      case 1: 
        this.rHr.setText("L");
        this.kMh.setTextColor(-7829368);
        AppMethodBeat.o(121608);
        return;
      case 2: 
        this.rHr.setText("I");
        this.kMh.setTextColor(-16777216);
        AppMethodBeat.o(121608);
        return;
      case 3: 
        this.rHr.setText("W");
        this.kMh.setTextColor(Color.rgb(0, 0, 204));
        AppMethodBeat.o(121608);
        return;
      }
      this.rHr.setText("E");
      this.kMh.setTextColor(-65536);
      AppMethodBeat.o(121608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.a
 * JD-Core Version:    0.7.0.1
 */