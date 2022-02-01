package com.tencent.mm.picker.f;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.a.c;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import com.tencent.mm.picker.d.a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class e
{
  public static DateFormat iPb;
  Context ctx;
  int endYear;
  int gravity;
  private int iNG;
  float iOF;
  WheelView.b iOH;
  boolean[] iOi;
  WheelView iPc;
  WheelView iPd;
  WheelView iPe;
  WheelView iPf;
  WheelView iPg;
  WheelView iPh;
  int iPi;
  int iPj;
  int iPk;
  int iPl;
  int iPm;
  int iPn;
  int iPo;
  int iPp;
  int iPq;
  a iPr;
  private String[] iPs;
  private String[] iPt;
  final List<String> iPu;
  final List<String> iPw;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(175380);
    iPb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(175380);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(175371);
    this.startYear = 1900;
    this.endYear = 2100;
    this.iPi = 1;
    this.iPj = 12;
    this.iPk = 1;
    this.iPl = 31;
    this.iPm = 0;
    this.iPn = 0;
    this.iPo = 23;
    this.iPp = 59;
    this.iPs = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.iPt = new String[] { "4", "6", "9", "11" };
    this.iPu = Arrays.asList(this.iPs);
    this.iPw = Arrays.asList(this.iPt);
    this.ctx = paramContext;
    AppMethodBeat.o(175371);
  }
  
  static void aH(List<WheelView> paramList)
  {
    AppMethodBeat.i(175373);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(175373);
  }
  
  private void aQE()
  {
    AppMethodBeat.i(175375);
    this.iPe.setDividerColor(this.iNG);
    this.iPd.setDividerColor(this.iNG);
    this.iPc.setDividerColor(this.iNG);
    this.iPf.setDividerColor(this.iNG);
    this.iPg.setDividerColor(this.iNG);
    this.iPh.setDividerColor(this.iNG);
    AppMethodBeat.o(175375);
  }
  
  private static int c(WheelView paramWheelView)
  {
    AppMethodBeat.i(175377);
    if ((paramWheelView.getAdapter() instanceof c))
    {
      paramWheelView = paramWheelView.getAdapter().getItem(paramWheelView.getCurrentItem());
      if (paramWheelView != null)
      {
        int i = ((Integer)paramWheelView).intValue();
        AppMethodBeat.o(175377);
        return i;
      }
    }
    AppMethodBeat.o(175377);
    return 0;
  }
  
  public final List<WheelView> aQG()
  {
    AppMethodBeat.i(175372);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 6)
    {
      WheelView localWheelView;
      int j;
      switch (i)
      {
      default: 
        i += 1;
        break;
      case 0: 
        localWheelView = this.iPc;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.iPc);
          break;
        }
      case 1: 
        localWheelView = this.iPd;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.iPd);
          break;
        }
      case 2: 
        localWheelView = this.iPe;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.iPe);
          break;
        }
      case 3: 
        localWheelView = this.iPf;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.iPf);
          break;
        }
      case 4: 
        localWheelView = this.iPg;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.iPg);
          break;
        }
      case 5: 
        localWheelView = this.iPh;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.iPh);
          break;
        }
      }
    }
    AppMethodBeat.o(175372);
    return localArrayList;
  }
  
  public final String aQH()
  {
    AppMethodBeat.i(175376);
    String str = String.valueOf(c(this.iPc) + "-" + c(this.iPd) + "-" + c(this.iPe) + " " + c(this.iPf) + ":" + c(this.iPg) + ":" + c(this.iPh));
    AppMethodBeat.o(175376);
    return str;
  }
  
  final void b(WheelView paramWheelView)
  {
    AppMethodBeat.i(175374);
    if (this.iPr != null) {
      paramWheelView.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b()
      {
        public final void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(175370);
          e.k(e.this).aQv();
          AppMethodBeat.o(175370);
        }
      });
    }
    AppMethodBeat.o(175374);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175378);
    this.iNG = paramInt;
    aQE();
    AppMethodBeat.o(175378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.e
 * JD-Core Version:    0.7.0.1
 */