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
  public static DateFormat iMi;
  Context ctx;
  int endYear;
  int gravity;
  private int iKN;
  float iLM;
  WheelView.b iLO;
  boolean[] iLp;
  private String[] iMA;
  final List<String> iMB;
  final List<String> iMC;
  WheelView iMj;
  WheelView iMk;
  WheelView iMl;
  WheelView iMm;
  WheelView iMn;
  WheelView iMo;
  int iMp;
  int iMq;
  int iMr;
  int iMs;
  int iMt;
  int iMu;
  int iMv;
  int iMw;
  int iMx;
  a iMy;
  private String[] iMz;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(175380);
    iMi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(175380);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(175371);
    this.startYear = 1900;
    this.endYear = 2100;
    this.iMp = 1;
    this.iMq = 12;
    this.iMr = 1;
    this.iMs = 31;
    this.iMt = 0;
    this.iMu = 0;
    this.iMv = 23;
    this.iMw = 59;
    this.iMz = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.iMA = new String[] { "4", "6", "9", "11" };
    this.iMB = Arrays.asList(this.iMz);
    this.iMC = Arrays.asList(this.iMA);
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
  
  private void aQf()
  {
    AppMethodBeat.i(175375);
    this.iMl.setDividerColor(this.iKN);
    this.iMk.setDividerColor(this.iKN);
    this.iMj.setDividerColor(this.iKN);
    this.iMm.setDividerColor(this.iKN);
    this.iMn.setDividerColor(this.iKN);
    this.iMo.setDividerColor(this.iKN);
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
  
  public final List<WheelView> aQh()
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
        localWheelView = this.iMj;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.iMj);
          break;
        }
      case 1: 
        localWheelView = this.iMk;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.iMk);
          break;
        }
      case 2: 
        localWheelView = this.iMl;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.iMl);
          break;
        }
      case 3: 
        localWheelView = this.iMm;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.iMm);
          break;
        }
      case 4: 
        localWheelView = this.iMn;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.iMn);
          break;
        }
      case 5: 
        localWheelView = this.iMo;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.iMo);
          break;
        }
      }
    }
    AppMethodBeat.o(175372);
    return localArrayList;
  }
  
  public final String aQi()
  {
    AppMethodBeat.i(175376);
    String str = String.valueOf(c(this.iMj) + "-" + c(this.iMk) + "-" + c(this.iMl) + " " + c(this.iMm) + ":" + c(this.iMn) + ":" + c(this.iMo));
    AppMethodBeat.o(175376);
    return str;
  }
  
  final void b(WheelView paramWheelView)
  {
    AppMethodBeat.i(175374);
    if (this.iMy != null) {
      paramWheelView.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b()
      {
        public final void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(175370);
          e.k(e.this).aPW();
          AppMethodBeat.o(175370);
        }
      });
    }
    AppMethodBeat.o(175374);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175378);
    this.iKN = paramInt;
    aQf();
    AppMethodBeat.o(175378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.picker.f.e
 * JD-Core Version:    0.7.0.1
 */