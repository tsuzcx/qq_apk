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
  public static DateFormat hTa;
  Context ctx;
  int endYear;
  int gravity;
  private int hRF;
  float hSE;
  WheelView.b hSG;
  boolean[] hSh;
  WheelView hTb;
  WheelView hTc;
  WheelView hTd;
  WheelView hTe;
  WheelView hTf;
  WheelView hTg;
  int hTh;
  int hTi;
  int hTj;
  int hTk;
  int hTl;
  int hTm;
  int hTn;
  int hTo;
  int hTp;
  a hTq;
  private String[] hTr;
  private String[] hTs;
  final List<String> hTt;
  final List<String> hTu;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(175380);
    hTa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(175380);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(175371);
    this.startYear = 1900;
    this.endYear = 2100;
    this.hTh = 1;
    this.hTi = 12;
    this.hTj = 1;
    this.hTk = 31;
    this.hTl = 0;
    this.hTm = 0;
    this.hTn = 23;
    this.hTo = 59;
    this.hTr = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.hTs = new String[] { "4", "6", "9", "11" };
    this.hTt = Arrays.asList(this.hTr);
    this.hTu = Arrays.asList(this.hTs);
    this.ctx = paramContext;
    AppMethodBeat.o(175371);
  }
  
  private void aGh()
  {
    AppMethodBeat.i(175375);
    this.hTd.setDividerColor(this.hRF);
    this.hTc.setDividerColor(this.hRF);
    this.hTb.setDividerColor(this.hRF);
    this.hTe.setDividerColor(this.hRF);
    this.hTf.setDividerColor(this.hRF);
    this.hTg.setDividerColor(this.hRF);
    AppMethodBeat.o(175375);
  }
  
  static void aJ(List<WheelView> paramList)
  {
    AppMethodBeat.i(175373);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(175373);
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
  
  public final List<WheelView> aGj()
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
        localWheelView = this.hTb;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.hTb);
          break;
        }
      case 1: 
        localWheelView = this.hTc;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.hTc);
          break;
        }
      case 2: 
        localWheelView = this.hTd;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.hTd);
          break;
        }
      case 3: 
        localWheelView = this.hTe;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.hTe);
          break;
        }
      case 4: 
        localWheelView = this.hTf;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.hTf);
          break;
        }
      case 5: 
        localWheelView = this.hTg;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.hTg);
          break;
        }
      }
    }
    AppMethodBeat.o(175372);
    return localArrayList;
  }
  
  public final String aGk()
  {
    AppMethodBeat.i(175376);
    String str = String.valueOf(c(this.hTb) + "-" + c(this.hTc) + "-" + c(this.hTd) + " " + c(this.hTe) + ":" + c(this.hTf) + ":" + c(this.hTg));
    AppMethodBeat.o(175376);
    return str;
  }
  
  final void b(WheelView paramWheelView)
  {
    AppMethodBeat.i(175374);
    if (this.hTq != null) {
      paramWheelView.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b()
      {
        public final void pz(int paramAnonymousInt)
        {
          AppMethodBeat.i(175370);
          e.k(e.this).aFY();
          AppMethodBeat.o(175370);
        }
      });
    }
    AppMethodBeat.o(175374);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175378);
    this.hRF = paramInt;
    aGh();
    AppMethodBeat.o(175378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.f.e
 * JD-Core Version:    0.7.0.1
 */