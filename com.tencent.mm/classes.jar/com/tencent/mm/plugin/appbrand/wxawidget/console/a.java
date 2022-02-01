package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LogInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class a
  extends RecyclerView.a
{
  private static final SimpleDateFormat nvy;
  LayoutInflater mInflater;
  List<LogInfo> nvz;
  
  static
  {
    AppMethodBeat.i(121614);
    nvy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    AppMethodBeat.o(121614);
  }
  
  a(Context paramContext)
  {
    AppMethodBeat.i(121609);
    this.mInflater = LayoutInflater.from(paramContext);
    this.nvz = new LinkedList();
    AppMethodBeat.o(121609);
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(121610);
    paramViewGroup = new a(this.mInflater.inflate(2131493596, paramViewGroup, false), paramInt);
    AppMethodBeat.o(121610);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(121611);
    LogInfo localLogInfo = (LogInfo)this.nvz.get(paramInt);
    ((a)paramw).heO.setText(String.format("[%s] %s", new Object[] { nvy.format(new Date(localLogInfo.hNo)), localLogInfo.message }));
    AppMethodBeat.o(121611);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(121612);
    int i = this.nvz.size();
    AppMethodBeat.o(121612);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(121613);
    paramInt = ((LogInfo)this.nvz.get(paramInt)).level;
    AppMethodBeat.o(121613);
    return paramInt;
  }
  
  static final class a
    extends RecyclerView.w
  {
    TextView heO;
    TextView nvA;
    
    public a(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(121608);
      this.nvA = ((TextView)paramView.findViewById(2131301402));
      this.heO = ((TextView)paramView.findViewById(2131298778));
      switch (paramInt)
      {
      default: 
        this.nvA.setText("L");
        this.heO.setTextColor(-7829368);
        AppMethodBeat.o(121608);
        return;
      case 1: 
        this.nvA.setText("L");
        this.heO.setTextColor(-7829368);
        AppMethodBeat.o(121608);
        return;
      case 2: 
        this.nvA.setText("I");
        this.heO.setTextColor(-16777216);
        AppMethodBeat.o(121608);
        return;
      case 3: 
        this.nvA.setText("W");
        this.heO.setTextColor(Color.rgb(0, 0, 204));
        AppMethodBeat.o(121608);
        return;
      }
      this.nvA.setText("E");
      this.heO.setTextColor(-65536);
      AppMethodBeat.o(121608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.a
 * JD-Core Version:    0.7.0.1
 */