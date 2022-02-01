package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.d;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppBrandDatePickerV2
  implements com.tencent.mm.plugin.appbrand.jsapi.p.c<String>
{
  private Context context;
  private View mView;
  public Date npA;
  public Date npB;
  private int npF;
  private int npG;
  private int npH;
  private boolean npv;
  private boolean npw;
  private com.tencent.mm.picker.f.c pvTime;
  
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
    this.npw = paramBoolean3;
    this.npv = paramBoolean2;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt1, paramInt2 - 1, paramInt3);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(this.npA);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(this.npB);
    com.tencent.mm.picker.b.b localb = new com.tencent.mm.picker.b.b(this.context, new com.tencent.mm.picker.d.e()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(137985);
        AppBrandDatePickerV2.a(AppBrandDatePickerV2.this, paramAnonymousDate);
        AppMethodBeat.o(137985);
      }
    });
    d local1 = new d() {};
    localb.iOb.iOe = local1;
    localObject = localb.aQu().b(new boolean[] { paramBoolean1, paramBoolean2, paramBoolean3, false, false, false }).a((Calendar)localObject).a(localCalendar1, localCalendar2);
    paramInt1 = this.context.getResources().getDimensionPixelSize(2131166681);
    ((com.tencent.mm.picker.b.b)localObject).iOb.kl = paramInt1;
    ((com.tencent.mm.picker.b.b)localObject).a(this.pvTime);
    this.pvTime.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131166681);
    localObject = this.pvTime;
    paramInt1 = android.support.v4.content.b.n(this.context, 2131099656);
    ((com.tencent.mm.picker.f.c)localObject).iOU.setDividerColor(paramInt1);
    this.pvTime.du(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    localObject = this.pvTime.iOU.aQG().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).qT(android.support.v4.content.b.n(this.context, 2131099664)).qS(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    }
    localObject = this.pvTime.iOU.aQG();
    if (((List)localObject).size() == 1)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(137988);
      return;
    }
    if (((List)localObject).size() == 2)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(137988);
      return;
    }
    if (((List)localObject).size() == 3)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
    }
    AppMethodBeat.o(137988);
  }
  
  public View getView()
  {
    AppMethodBeat.i(137987);
    if (this.mView == null) {
      this.mView = this.pvTime.aQD();
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