package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AppBrandTimePickerV2
  implements com.tencent.mm.plugin.appbrand.jsapi.n.c<String>
{
  private Context context;
  private int currentHour;
  private int currentMinute;
  private int mMaxTimeHour;
  private int mMaxTimeMinute;
  private int mMinTimeHour;
  private int mMinTimeMinute;
  private View mView;
  private com.tencent.mm.picker.f.c pvTime;
  
  @Keep
  AppBrandTimePickerV2(Context paramContext)
  {
    AppMethodBeat.i(138076);
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.pvTime = new com.tencent.mm.picker.f.c(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(138076);
  }
  
  private void configPadding(List<WheelView> paramList)
  {
    AppMethodBeat.i(138078);
    if (paramList.size() == 1)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(138078);
      return;
    }
    if (paramList.size() == 2)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)paramList.get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(138078);
      return;
    }
    if (paramList.size() == 3)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)paramList.get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)paramList.get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
    }
    AppMethodBeat.o(138078);
  }
  
  private void getTimeString(Date paramDate)
  {
    AppMethodBeat.i(138079);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    this.currentHour = localCalendar.get(11);
    this.currentMinute = localCalendar.get(12);
    AppMethodBeat.o(138079);
  }
  
  public String currentValue()
  {
    AppMethodBeat.i(138080);
    this.pvTime.aGe();
    String str = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(this.currentHour), Integer.valueOf(this.currentMinute) });
    AppMethodBeat.o(138080);
    return str;
  }
  
  public View getView()
  {
    AppMethodBeat.i(138081);
    if (this.mView == null) {
      this.mView = this.pvTime.aGg();
    }
    View localView = this.mView;
    AppMethodBeat.o(138081);
    return localView;
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138077);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(11, paramInt1);
    ((Calendar)localObject).set(12, paramInt2);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(11, this.mMinTimeHour);
    localCalendar1.set(12, this.mMinTimeMinute);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(11, this.mMaxTimeHour);
    localCalendar2.set(12, this.mMaxTimeMinute);
    localObject = new com.tencent.mm.picker.b.b(this.context, new com.tencent.mm.picker.d.e()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(138075);
        AppBrandTimePickerV2.access$000(AppBrandTimePickerV2.this, paramAnonymousDate);
        AppMethodBeat.o(138075);
      }
    }).b(new boolean[] { 0, 0, 0, 1, 1, 0 }).a((Calendar)localObject).a(localCalendar1, localCalendar2).aFX();
    paramInt1 = android.support.v4.content.b.n(this.context, 2131099656);
    ((com.tencent.mm.picker.b.b)localObject).hSa.hRF = paramInt1;
    ((com.tencent.mm.picker.b.b)localObject).a(this.pvTime);
    this.pvTime.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131166681);
    this.pvTime.ds(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    localObject = this.pvTime.hST.aGj().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).pD(android.support.v4.content.b.n(this.context, 2131099664)).pC(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    }
    configPadding(this.pvTime.hST.aGj());
    AppMethodBeat.o(138077);
  }
  
  public boolean isNewPicker()
  {
    return true;
  }
  
  public void onAttach(c paramc) {}
  
  public void onDetach(c paramc) {}
  
  public void onHide(c paramc) {}
  
  public void onShow(c paramc) {}
  
  public void setMaxTime(int paramInt1, int paramInt2)
  {
    this.mMaxTimeHour = paramInt1;
    this.mMaxTimeMinute = paramInt2;
  }
  
  public void setMinTime(int paramInt1, int paramInt2)
  {
    this.mMinTimeHour = paramInt1;
    this.mMinTimeMinute = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePickerV2
 * JD-Core Version:    0.7.0.1
 */