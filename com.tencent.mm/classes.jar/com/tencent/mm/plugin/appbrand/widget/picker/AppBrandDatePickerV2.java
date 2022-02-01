package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.content.a;
import com.tencent.luggage.b.a.a.b;
import com.tencent.luggage.b.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.b.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.d;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppBrandDatePickerV2
  implements com.tencent.mm.plugin.appbrand.jsapi.s.c<String>
{
  private Context context;
  private View mView;
  private com.tencent.mm.picker.f.c pvTime;
  private boolean rBJ;
  private boolean rBK;
  public Date rBO;
  public Date rBP;
  private int rBT;
  private int rBU;
  private int rBV;
  
  @Keep
  AppBrandDatePickerV2(Context paramContext)
  {
    AppMethodBeat.i(137986);
    this.mView = null;
    this.context = paramContext;
    this.pvTime = new com.tencent.mm.picker.f.c(paramContext);
    AppMethodBeat.o(137986);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(137988);
    this.rBK = paramBoolean3;
    this.rBJ = paramBoolean2;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt1, paramInt2 - 1, paramInt3);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(this.rBO);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(this.rBP);
    new b(this.context, new com.tencent.mm.picker.d.e()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(137985);
        AppBrandDatePickerV2.a(AppBrandDatePickerV2.this, paramAnonymousDate);
        AppMethodBeat.o(137985);
      }
    }).a(new d()
    {
      public final void buP() {}
    }).buN().c(new boolean[] { paramBoolean1, paramBoolean2, paramBoolean3, false, false, false }).a((Calendar)localObject).a(localCalendar1, localCalendar2).xR(this.context.getResources().getDimensionPixelSize(a.c.picker_item_height)).a(this.pvTime);
    this.pvTime.setDividerHeight(this.context.getResources().getDimensionPixelSize(a.c.bottomsheet_dividing_line_height));
    this.context.getResources().getDimensionPixelSize(a.c.picker_item_height);
    this.pvTime.setDividerColor(a.w(this.context, a.b.BW_0_Alpha_0_1));
    this.pvTime.ec(this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A));
    localObject = this.pvTime.mCN.bvb().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).xN(a.w(this.context, a.b.BW_0_Alpha_0_9)).xM(this.context.getResources().getDimensionPixelSize(a.c.Edge_2A)).setBackgroundColor(a.w(this.context, a.b.BG_5));
    }
    localObject = this.pvTime.mCN.bvb();
    if (((List)localObject).size() == 1)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.c.Edge_2A));
      AppMethodBeat.o(137988);
      return;
    }
    if (((List)localObject).size() == 2)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.c.Edge_2A));
      AppMethodBeat.o(137988);
      return;
    }
    if (((List)localObject).size() == 3)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), this.context.getResources().getDimensionPixelSize(a.c.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(a.c.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), this.context.getResources().getDimensionPixelSize(a.c.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A));
      ((WheelView)((List)localObject).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(a.c.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.c.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.c.Edge_2A));
    }
    AppMethodBeat.o(137988);
  }
  
  public View getView()
  {
    AppMethodBeat.i(137987);
    if (this.mView == null) {
      this.mView = this.pvTime.buX();
    }
    View localView = this.mView;
    AppMethodBeat.o(137987);
    return localView;
  }
  
  public void onAttach(c paramc) {}
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc) {}
  
  public void onShow(c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2
 * JD-Core Version:    0.7.0.1
 */