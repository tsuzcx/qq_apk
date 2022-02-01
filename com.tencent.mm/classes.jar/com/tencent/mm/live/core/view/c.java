package com.tencent.mm.live.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class c
{
  public static RelativeLayout.LayoutParams G(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205586);
    int i = dip2px(paramContext, 10.0F);
    int j = dip2px(paramContext, 15.0F);
    int k = dip2px(paramContext, 50.0F);
    int m = dip2px(paramContext, 192.0F);
    paramContext = new RelativeLayout.LayoutParams(m, dip2px(paramContext, 108.0F));
    paramContext.leftMargin = (paramInt - j - m);
    paramContext.topMargin = (i + k);
    AppMethodBeat.o(205586);
    return paramContext;
  }
  
  public static RelativeLayout.LayoutParams aP(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205587);
    int i = dip2px(paramContext, 10.0F);
    int j = dip2px(paramContext, 15.0F);
    int k = dip2px(paramContext, 50.0F);
    int m = dip2px(paramContext, 108.0F);
    paramContext = new RelativeLayout.LayoutParams(m, dip2px(paramContext, 192.0F));
    paramContext.leftMargin = (paramInt - j - m);
    paramContext.topMargin = (i + k);
    AppMethodBeat.o(205587);
    return paramContext;
  }
  
  public static RelativeLayout.LayoutParams aQ(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205590);
    int i = dip2px(paramContext, 10.0F);
    int j = dip2px(paramContext, 15.0F);
    int k = dip2px(paramContext, 50.0F);
    int m = dip2px(paramContext, 108.0F);
    paramContext = new RelativeLayout.LayoutParams(m, dip2px(paramContext, 192.0F));
    paramContext.leftMargin = (paramInt - j - m);
    paramContext.topMargin = (i + k);
    AppMethodBeat.o(205590);
    return paramContext;
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(205585);
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    AppMethodBeat.o(205585);
    return i;
  }
  
  public static ArrayList<RelativeLayout.LayoutParams> l(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205588);
    int i = dip2px(paramContext, 10.0F);
    int j = dip2px(paramContext, 50.0F);
    paramContext = new ArrayList();
    paramInt1 = (paramInt1 - i * 2) / 2;
    paramInt2 = (paramInt2 - i * 2 - j) / 2;
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams1.addRule(9);
    localLayoutParams1.addRule(10);
    localLayoutParams1.topMargin = i;
    localLayoutParams1.leftMargin = i;
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.addRule(11);
    localLayoutParams2.addRule(10);
    localLayoutParams2.topMargin = i;
    localLayoutParams2.rightMargin = i;
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams3.addRule(9);
    localLayoutParams3.addRule(12);
    localLayoutParams3.bottomMargin = (i + j);
    localLayoutParams3.leftMargin = i;
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams4.addRule(11);
    localLayoutParams4.addRule(12);
    localLayoutParams4.bottomMargin = (j + i);
    localLayoutParams4.rightMargin = i;
    paramContext.add(localLayoutParams1);
    paramContext.add(localLayoutParams2);
    paramContext.add(localLayoutParams3);
    paramContext.add(localLayoutParams4);
    AppMethodBeat.o(205588);
    return paramContext;
  }
  
  public static ArrayList<RelativeLayout.LayoutParams> m(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205589);
    int i = dip2px(paramContext, 10.0F);
    int j = dip2px(paramContext, 50.0F);
    paramContext = new ArrayList();
    paramInt1 = (paramInt1 - i * 2) / 3;
    paramInt2 = (paramInt2 - i * 2 - j) / 3;
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams1.addRule(9);
    localLayoutParams1.addRule(10);
    localLayoutParams1.topMargin = i;
    localLayoutParams1.leftMargin = i;
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.addRule(14);
    localLayoutParams2.addRule(10);
    localLayoutParams2.topMargin = i;
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams3.addRule(11);
    localLayoutParams3.addRule(10);
    localLayoutParams3.topMargin = i;
    localLayoutParams3.rightMargin = i;
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams4.addRule(10);
    localLayoutParams4.addRule(9);
    localLayoutParams4.leftMargin = i;
    localLayoutParams4.topMargin = (i + paramInt2);
    RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams5.addRule(14);
    localLayoutParams5.topMargin = (i + paramInt2);
    RelativeLayout.LayoutParams localLayoutParams6 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams6.addRule(10);
    localLayoutParams6.addRule(11);
    localLayoutParams6.topMargin = (i + paramInt2);
    localLayoutParams6.rightMargin = i;
    RelativeLayout.LayoutParams localLayoutParams7 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams7.addRule(9);
    localLayoutParams7.addRule(12);
    localLayoutParams7.bottomMargin = (i + j);
    localLayoutParams7.leftMargin = i;
    RelativeLayout.LayoutParams localLayoutParams8 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams8.addRule(14);
    localLayoutParams8.addRule(12);
    localLayoutParams8.bottomMargin = (i + j);
    RelativeLayout.LayoutParams localLayoutParams9 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams9.addRule(11);
    localLayoutParams9.addRule(12);
    localLayoutParams9.bottomMargin = (j + i);
    localLayoutParams9.rightMargin = i;
    paramContext.add(localLayoutParams1);
    paramContext.add(localLayoutParams2);
    paramContext.add(localLayoutParams3);
    paramContext.add(localLayoutParams4);
    paramContext.add(localLayoutParams5);
    paramContext.add(localLayoutParams6);
    paramContext.add(localLayoutParams7);
    paramContext.add(localLayoutParams8);
    paramContext.add(localLayoutParams9);
    AppMethodBeat.o(205589);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.view.c
 * JD-Core Version:    0.7.0.1
 */