package com.tencent.mm.picker.f;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.picker.a.c;
import com.tencent.mm.picker.a.d;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.base.view.WheelView.b;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class e
{
  public static DateFormat dateFormat;
  float bbg;
  Context ctx;
  int endYear;
  int fl;
  boolean[] pyK;
  private int pyf;
  public boolean pyg;
  public WheelView pzD;
  public WheelView pzE;
  public WheelView pzF;
  WheelView pzG;
  WheelView pzH;
  WheelView pzI;
  public d pzJ;
  int pzK;
  int pzL;
  int pzM;
  int pzN;
  int pzO;
  int pzP;
  int pzQ;
  int pzR;
  int pzS;
  com.tencent.mm.picker.d.a pzT;
  private String[] pzU;
  private String[] pzV;
  final List<String> pzW;
  final List<String> pzX;
  WheelView.b pzh;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(175380);
    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(175380);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(175371);
    this.startYear = 1900;
    this.endYear = 2100;
    this.pzK = 1;
    this.pzL = 12;
    this.pzM = 1;
    this.pzN = 31;
    this.pzO = 0;
    this.pzP = 0;
    this.pzQ = 23;
    this.pzR = 59;
    this.pyg = false;
    this.pzU = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.pzV = new String[] { "4", "6", "9", "11" };
    this.pzW = Arrays.asList(this.pzU);
    this.pzX = Arrays.asList(this.pzV);
    this.ctx = paramContext;
    AppMethodBeat.o(175371);
  }
  
  private void bTi()
  {
    AppMethodBeat.i(175375);
    this.pzF.setDividerColor(this.pyf);
    this.pzE.setDividerColor(this.pyf);
    this.pzD.setDividerColor(this.pyf);
    this.pzG.setDividerColor(this.pyf);
    this.pzH.setDividerColor(this.pyf);
    this.pzI.setDividerColor(this.pyf);
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
  
  static void cs(List<WheelView> paramList)
  {
    AppMethodBeat.i(175373);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(175373);
  }
  
  final void b(WheelView paramWheelView)
  {
    AppMethodBeat.i(175374);
    if (this.pzT != null) {
      paramWheelView.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b()
      {
        public final void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(175370);
          e.k(e.this).bSX();
          AppMethodBeat.o(175370);
        }
      });
    }
    AppMethodBeat.o(175374);
  }
  
  public final List<WheelView> bTk()
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
        localWheelView = this.pzD;
        if (this.pyK[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.pyK[i] == 0) {
            break;
          }
          localArrayList.add(this.pzD);
          break;
        }
      case 1: 
        localWheelView = this.pzE;
        if (this.pyK[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.pyK[i] == 0) {
            break;
          }
          localArrayList.add(this.pzE);
          break;
        }
      case 2: 
        localWheelView = this.pzF;
        if (this.pyK[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.pyK[i] == 0) {
            break;
          }
          localArrayList.add(this.pzF);
          break;
        }
      case 3: 
        localWheelView = this.pzG;
        if (this.pyK[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.pyK[i] == 0) {
            break;
          }
          localArrayList.add(this.pzG);
          break;
        }
      case 4: 
        localWheelView = this.pzH;
        if (this.pyK[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.pyK[i] == 0) {
            break;
          }
          localArrayList.add(this.pzH);
          break;
        }
      case 5: 
        localWheelView = this.pzI;
        if (this.pyK[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.pyK[i] == 0) {
            break;
          }
          localArrayList.add(this.pzI);
          break;
        }
      }
    }
    AppMethodBeat.o(175372);
    return localArrayList;
  }
  
  public final String getTime()
  {
    AppMethodBeat.i(175376);
    String str = String.valueOf(c(this.pzD) + "-" + c(this.pzE) + "-" + c(this.pzF) + " " + c(this.pzG) + ":" + c(this.pzH) + ":" + c(this.pzI));
    AppMethodBeat.o(175376);
    return str;
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175378);
    this.pyf = paramInt;
    bTi();
    AppMethodBeat.o(175378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.picker.f.e
 * JD-Core Version:    0.7.0.1
 */