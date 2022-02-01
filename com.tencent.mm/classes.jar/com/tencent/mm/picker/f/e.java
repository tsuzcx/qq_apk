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
  public static DateFormat itf;
  Context ctx;
  int endYear;
  int gravity;
  private int irK;
  float isJ;
  WheelView.b isL;
  boolean[] ism;
  WheelView itg;
  WheelView ith;
  WheelView iti;
  WheelView itj;
  WheelView itk;
  WheelView itl;
  int itm;
  int itn;
  int ito;
  int itp;
  int itq;
  int itr;
  int its;
  int itt;
  int itu;
  a itv;
  private String[] itw;
  private String[] itx;
  final List<String> ity;
  final List<String> itz;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(175380);
    itf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(175380);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(175371);
    this.startYear = 1900;
    this.endYear = 2100;
    this.itm = 1;
    this.itn = 12;
    this.ito = 1;
    this.itp = 31;
    this.itq = 0;
    this.itr = 0;
    this.its = 23;
    this.itt = 59;
    this.itw = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.itx = new String[] { "4", "6", "9", "11" };
    this.ity = Arrays.asList(this.itw);
    this.itz = Arrays.asList(this.itx);
    this.ctx = paramContext;
    AppMethodBeat.o(175371);
  }
  
  static void aG(List<WheelView> paramList)
  {
    AppMethodBeat.i(175373);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(175373);
  }
  
  private void aMU()
  {
    AppMethodBeat.i(175375);
    this.iti.setDividerColor(this.irK);
    this.ith.setDividerColor(this.irK);
    this.itg.setDividerColor(this.irK);
    this.itj.setDividerColor(this.irK);
    this.itk.setDividerColor(this.irK);
    this.itl.setDividerColor(this.irK);
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
  
  public final List<WheelView> aMW()
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
        localWheelView = this.itg;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.itg);
          break;
        }
      case 1: 
        localWheelView = this.ith;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.ith);
          break;
        }
      case 2: 
        localWheelView = this.iti;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.iti);
          break;
        }
      case 3: 
        localWheelView = this.itj;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.itj);
          break;
        }
      case 4: 
        localWheelView = this.itk;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.itk);
          break;
        }
      case 5: 
        localWheelView = this.itl;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.itl);
          break;
        }
      }
    }
    AppMethodBeat.o(175372);
    return localArrayList;
  }
  
  public final String aMX()
  {
    AppMethodBeat.i(175376);
    String str = String.valueOf(c(this.itg) + "-" + c(this.ith) + "-" + c(this.iti) + " " + c(this.itj) + ":" + c(this.itk) + ":" + c(this.itl));
    AppMethodBeat.o(175376);
    return str;
  }
  
  final void b(WheelView paramWheelView)
  {
    AppMethodBeat.i(175374);
    if (this.itv != null) {
      paramWheelView.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b()
      {
        public final void qm(int paramAnonymousInt)
        {
          AppMethodBeat.i(175370);
          e.k(e.this).aML();
          AppMethodBeat.o(175370);
        }
      });
    }
    AppMethodBeat.o(175374);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175378);
    this.irK = paramInt;
    aMU();
    AppMethodBeat.o(175378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.e
 * JD-Core Version:    0.7.0.1
 */