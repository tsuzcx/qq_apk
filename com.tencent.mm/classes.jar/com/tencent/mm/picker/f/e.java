package com.tencent.mm.picker.f;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
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
  Context ctx;
  int ek;
  int endYear;
  private int mBx;
  public boolean mBy;
  WheelView.b mCA;
  public WheelView mCV;
  public WheelView mCW;
  public WheelView mCX;
  WheelView mCY;
  WheelView mCZ;
  boolean[] mCc;
  float mCy;
  WheelView mDa;
  public d mDc;
  int mDd;
  int mDe;
  int mDf;
  int mDg;
  int mDh;
  int mDi;
  int mDj;
  int mDk;
  int mDl;
  com.tencent.mm.picker.d.a mDm;
  private String[] mDn;
  private String[] mDo;
  final List<String> mDp;
  final List<String> mDq;
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
    this.mDd = 1;
    this.mDe = 12;
    this.mDf = 1;
    this.mDg = 31;
    this.mDh = 0;
    this.mDi = 0;
    this.mDj = 23;
    this.mDk = 59;
    this.mBy = false;
    this.mDn = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.mDo = new String[] { "4", "6", "9", "11" };
    this.mDp = Arrays.asList(this.mDn);
    this.mDq = Arrays.asList(this.mDo);
    this.ctx = paramContext;
    AppMethodBeat.o(175371);
  }
  
  static void aN(List<WheelView> paramList)
  {
    AppMethodBeat.i(175373);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(175373);
  }
  
  private void buZ()
  {
    AppMethodBeat.i(175375);
    this.mCX.setDividerColor(this.mBx);
    this.mCW.setDividerColor(this.mBx);
    this.mCV.setDividerColor(this.mBx);
    this.mCY.setDividerColor(this.mBx);
    this.mCZ.setDividerColor(this.mBx);
    this.mDa.setDividerColor(this.mBx);
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
    if (this.mDm != null) {
      paramWheelView.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b()
      {
        public final void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(175370);
          e.k(e.this).buO();
          AppMethodBeat.o(175370);
        }
      });
    }
    AppMethodBeat.o(175374);
  }
  
  public final List<WheelView> bvb()
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
        localWheelView = this.mCV;
        if (this.mCc[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.mCc[i] == 0) {
            break;
          }
          localArrayList.add(this.mCV);
          break;
        }
      case 1: 
        localWheelView = this.mCW;
        if (this.mCc[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.mCc[i] == 0) {
            break;
          }
          localArrayList.add(this.mCW);
          break;
        }
      case 2: 
        localWheelView = this.mCX;
        if (this.mCc[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.mCc[i] == 0) {
            break;
          }
          localArrayList.add(this.mCX);
          break;
        }
      case 3: 
        localWheelView = this.mCY;
        if (this.mCc[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.mCc[i] == 0) {
            break;
          }
          localArrayList.add(this.mCY);
          break;
        }
      case 4: 
        localWheelView = this.mCZ;
        if (this.mCc[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.mCc[i] == 0) {
            break;
          }
          localArrayList.add(this.mCZ);
          break;
        }
      case 5: 
        localWheelView = this.mDa;
        if (this.mCc[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.mCc[i] == 0) {
            break;
          }
          localArrayList.add(this.mDa);
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
    String str = String.valueOf(c(this.mCV) + "-" + c(this.mCW) + "-" + c(this.mCX) + " " + c(this.mCY) + ":" + c(this.mCZ) + ":" + c(this.mDa));
    AppMethodBeat.o(175376);
    return str;
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175378);
    this.mBx = paramInt;
    buZ();
    AppMethodBeat.o(175378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.f.e
 * JD-Core Version:    0.7.0.1
 */