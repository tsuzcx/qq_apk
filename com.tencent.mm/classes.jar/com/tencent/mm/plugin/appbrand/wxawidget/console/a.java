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
  private static final SimpleDateFormat mnF;
  LayoutInflater mInflater;
  List<LogInfo> mnG;
  
  static
  {
    AppMethodBeat.i(121614);
    mnF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    AppMethodBeat.o(121614);
  }
  
  a(Context paramContext)
  {
    AppMethodBeat.i(121609);
    this.mInflater = LayoutInflater.from(paramContext);
    this.mnG = new LinkedList();
    AppMethodBeat.o(121609);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(121610);
    paramViewGroup = new a(this.mInflater.inflate(2131493596, paramViewGroup, false), paramInt);
    AppMethodBeat.o(121610);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(121611);
    LogInfo localLogInfo = (LogInfo)this.mnG.get(paramInt);
    ((a)paramv).izX.setText(String.format("[%s] %s", new Object[] { mnF.format(new Date(localLogInfo.gRD)), localLogInfo.message }));
    AppMethodBeat.o(121611);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(121612);
    int i = this.mnG.size();
    AppMethodBeat.o(121612);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(121613);
    paramInt = ((LogInfo)this.mnG.get(paramInt)).level;
    AppMethodBeat.o(121613);
    return paramInt;
  }
  
  static final class a
    extends RecyclerView.v
  {
    TextView izX;
    TextView mnH;
    
    public a(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(121608);
      this.mnH = ((TextView)paramView.findViewById(2131301402));
      this.izX = ((TextView)paramView.findViewById(2131298778));
      switch (paramInt)
      {
      default: 
        this.mnH.setText("L");
        this.izX.setTextColor(-7829368);
        AppMethodBeat.o(121608);
        return;
      case 1: 
        this.mnH.setText("L");
        this.izX.setTextColor(-7829368);
        AppMethodBeat.o(121608);
        return;
      case 2: 
        this.mnH.setText("I");
        this.izX.setTextColor(-16777216);
        AppMethodBeat.o(121608);
        return;
      case 3: 
        this.mnH.setText("W");
        this.izX.setTextColor(Color.rgb(0, 0, 204));
        AppMethodBeat.o(121608);
        return;
      }
      this.mnH.setText("E");
      this.izX.setTextColor(-65536);
      AppMethodBeat.o(121608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.a
 * JD-Core Version:    0.7.0.1
 */