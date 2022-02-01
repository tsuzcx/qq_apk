package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
  private static final SimpleDateFormat oFA;
  LayoutInflater mInflater;
  List<LogInfo> oFB;
  
  static
  {
    AppMethodBeat.i(121614);
    oFA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    AppMethodBeat.o(121614);
  }
  
  a(Context paramContext)
  {
    AppMethodBeat.i(121609);
    this.mInflater = LayoutInflater.from(paramContext);
    this.oFB = new LinkedList();
    AppMethodBeat.o(121609);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(121610);
    paramViewGroup = new a(this.mInflater.inflate(2131493713, paramViewGroup, false), paramInt);
    AppMethodBeat.o(121610);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(121611);
    LogInfo localLogInfo = (LogInfo)this.oFB.get(paramInt);
    ((a)paramv).hXC.setText(String.format("[%s] %s", new Object[] { oFA.format(new Date(localLogInfo.ts)), localLogInfo.message }));
    AppMethodBeat.o(121611);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(121612);
    int i = this.oFB.size();
    AppMethodBeat.o(121612);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(121613);
    paramInt = ((LogInfo)this.oFB.get(paramInt)).level;
    AppMethodBeat.o(121613);
    return paramInt;
  }
  
  static final class a
    extends RecyclerView.v
  {
    TextView hXC;
    TextView oFC;
    
    public a(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(121608);
      this.oFC = ((TextView)paramView.findViewById(2131303157));
      this.hXC = ((TextView)paramView.findViewById(2131299223));
      switch (paramInt)
      {
      default: 
        this.oFC.setText("L");
        this.hXC.setTextColor(-7829368);
        AppMethodBeat.o(121608);
        return;
      case 1: 
        this.oFC.setText("L");
        this.hXC.setTextColor(-7829368);
        AppMethodBeat.o(121608);
        return;
      case 2: 
        this.oFC.setText("I");
        this.hXC.setTextColor(-16777216);
        AppMethodBeat.o(121608);
        return;
      case 3: 
        this.oFC.setText("W");
        this.hXC.setTextColor(Color.rgb(0, 0, 204));
        AppMethodBeat.o(121608);
        return;
      }
      this.oFC.setText("E");
      this.hXC.setTextColor(-65536);
      AppMethodBeat.o(121608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.a
 * JD-Core Version:    0.7.0.1
 */