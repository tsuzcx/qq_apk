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
  implements com.tencent.mm.plugin.appbrand.jsapi.r.c<String>
{
  private Context context;
  private View mView;
  private boolean ozc;
  private boolean ozd;
  public Date ozh;
  public Date ozi;
  private int ozm;
  private int ozn;
  private int ozo;
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
    this.ozd = paramBoolean3;
    this.ozc = paramBoolean2;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt1, paramInt2 - 1, paramInt3);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(this.ozh);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(this.ozi);
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
    localb.jKP.jKT = local1;
    localObject = localb.bkZ().b(new boolean[] { paramBoolean1, paramBoolean2, paramBoolean3, false, false, false }).a((Calendar)localObject).a(localCalendar1, localCalendar2);
    paramInt1 = this.context.getResources().getDimensionPixelSize(2131166801);
    ((com.tencent.mm.picker.b.b)localObject).jKP.kn = paramInt1;
    ((com.tencent.mm.picker.b.b)localObject).a(this.pvTime);
    this.pvTime.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165950));
    this.context.getResources().getDimensionPixelSize(2131166801);
    localObject = this.pvTime;
    paramInt1 = android.support.v4.content.b.n(this.context, 2131099657);
    ((com.tencent.mm.picker.f.c)localObject).jLJ.setDividerColor(paramInt1);
    this.pvTime.dE(this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296));
    localObject = this.pvTime.jLJ.bll().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).uL(android.support.v4.content.b.n(this.context, 2131099669)).uK(this.context.getResources().getDimensionPixelSize(2131165296)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    }
    localObject = this.pvTime.jLJ.bll();
    if (((List)localObject).size() == 1)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
      AppMethodBeat.o(137988);
      return;
    }
    if (((List)localObject).size() == 2)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
      AppMethodBeat.o(137988);
      return;
    }
    if (((List)localObject).size() == 3)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
    }
    AppMethodBeat.o(137988);
  }
  
  public View getView()
  {
    AppMethodBeat.i(137987);
    if (this.mView == null) {
      this.mView = this.pvTime.bli();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2
 * JD-Core Version:    0.7.0.1
 */