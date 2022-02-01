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
  public static DateFormat dateFormat;
  Context ctx;
  int endYear;
  int gravity;
  boolean[] jKX;
  private int jKu;
  WheelView jLQ;
  WheelView jLR;
  WheelView jLS;
  WheelView jLT;
  WheelView jLU;
  WheelView jLV;
  int jLW;
  int jLX;
  int jLY;
  int jLZ;
  float jLu;
  WheelView.b jLw;
  int jMa;
  int jMb;
  int jMc;
  int jMd;
  int jMe;
  a jMf;
  private String[] jMg;
  private String[] jMh;
  final List<String> jMi;
  final List<String> jMj;
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
    this.jLW = 1;
    this.jLX = 12;
    this.jLY = 1;
    this.jLZ = 31;
    this.jMa = 0;
    this.jMb = 0;
    this.jMc = 23;
    this.jMd = 59;
    this.jMg = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.jMh = new String[] { "4", "6", "9", "11" };
    this.jMi = Arrays.asList(this.jMg);
    this.jMj = Arrays.asList(this.jMh);
    this.ctx = paramContext;
    AppMethodBeat.o(175371);
  }
  
  static void aP(List<WheelView> paramList)
  {
    AppMethodBeat.i(175373);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(175373);
  }
  
  private void blj()
  {
    AppMethodBeat.i(175375);
    this.jLS.setDividerColor(this.jKu);
    this.jLR.setDividerColor(this.jKu);
    this.jLQ.setDividerColor(this.jKu);
    this.jLT.setDividerColor(this.jKu);
    this.jLU.setDividerColor(this.jKu);
    this.jLV.setDividerColor(this.jKu);
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
  
  final void b(WheelView paramWheelView)
  {
    AppMethodBeat.i(175374);
    if (this.jMf != null) {
      paramWheelView.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b()
      {
        public final void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(175370);
          e.k(e.this).bla();
          AppMethodBeat.o(175370);
        }
      });
    }
    AppMethodBeat.o(175374);
  }
  
  public final List<WheelView> bll()
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
        localWheelView = this.jLQ;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.jLQ);
          break;
        }
      case 1: 
        localWheelView = this.jLR;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.jLR);
          break;
        }
      case 2: 
        localWheelView = this.jLS;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.jLS);
          break;
        }
      case 3: 
        localWheelView = this.jLT;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.jLT);
          break;
        }
      case 4: 
        localWheelView = this.jLU;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.jLU);
          break;
        }
      case 5: 
        localWheelView = this.jLV;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.jLV);
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
    String str = String.valueOf(c(this.jLQ) + "-" + c(this.jLR) + "-" + c(this.jLS) + " " + c(this.jLT) + ":" + c(this.jLU) + ":" + c(this.jLV));
    AppMethodBeat.o(175376);
    return str;
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175378);
    this.jKu = paramInt;
    blj();
    AppMethodBeat.o(175378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.e
 * JD-Core Version:    0.7.0.1
 */