package com.facebook.device.yearclass;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;

public class YearClass
{
  public static final int CLASS_2008 = 2008;
  public static final int CLASS_2009 = 2009;
  public static final int CLASS_2010 = 2010;
  public static final int CLASS_2011 = 2011;
  public static final int CLASS_2012 = 2012;
  public static final int CLASS_2013 = 2013;
  public static final int CLASS_2014 = 2014;
  public static final int CLASS_2015 = 2015;
  public static final int CLASS_2016 = 2016;
  public static final int CLASS_UNKNOWN = -1;
  private static final long MB = 1048576L;
  private static final int MHZ_IN_KHZ = 1000;
  private static volatile Integer mYearCategory;
  
  private static int categorizeByYear2014Method(Context paramContext)
  {
    AppMethodBeat.i(114638);
    ArrayList localArrayList = new ArrayList();
    conditionallyAdd(localArrayList, getNumCoresYear());
    conditionallyAdd(localArrayList, getClockSpeedYear());
    conditionallyAdd(localArrayList, getRamYear(paramContext));
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(114638);
      return -1;
    }
    Collections.sort(localArrayList);
    if ((localArrayList.size() & 0x1) == 1)
    {
      i = ((Integer)localArrayList.get(localArrayList.size() / 2)).intValue();
      AppMethodBeat.o(114638);
      return i;
    }
    int j = localArrayList.size() / 2 - 1;
    int i = ((Integer)localArrayList.get(j)).intValue();
    j = (((Integer)localArrayList.get(j + 1)).intValue() - ((Integer)localArrayList.get(j)).intValue()) / 2;
    AppMethodBeat.o(114638);
    return j + i;
  }
  
  private static int categorizeByYear2016Method(Context paramContext)
  {
    AppMethodBeat.i(114637);
    long l = DeviceInfo.getTotalMemory(paramContext);
    if (l == -1L)
    {
      int i = categorizeByYear2014Method(paramContext);
      AppMethodBeat.o(114637);
      return i;
    }
    if (l <= 805306368L)
    {
      if (DeviceInfo.getNumberOfCPUCores() <= 1)
      {
        AppMethodBeat.o(114637);
        return 2009;
      }
      AppMethodBeat.o(114637);
      return 2010;
    }
    if (l <= 1073741824L)
    {
      if (DeviceInfo.getCPUMaxFreqKHz() < 1300000)
      {
        AppMethodBeat.o(114637);
        return 2011;
      }
      AppMethodBeat.o(114637);
      return 2012;
    }
    if (l <= 1610612736L)
    {
      if (DeviceInfo.getCPUMaxFreqKHz() < 1800000)
      {
        AppMethodBeat.o(114637);
        return 2012;
      }
      AppMethodBeat.o(114637);
      return 2013;
    }
    if (l <= 2147483648L)
    {
      AppMethodBeat.o(114637);
      return 2013;
    }
    if (l <= 3221225472L)
    {
      AppMethodBeat.o(114637);
      return 2014;
    }
    if (l <= 5368709120L)
    {
      AppMethodBeat.o(114637);
      return 2015;
    }
    AppMethodBeat.o(114637);
    return 2016;
  }
  
  private static void conditionallyAdd(ArrayList<Integer> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(114636);
    if (paramInt != -1) {
      paramArrayList.add(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(114636);
  }
  
  public static int get(Context paramContext)
  {
    AppMethodBeat.i(114635);
    if (mYearCategory == null) {}
    try
    {
      if (mYearCategory == null) {
        mYearCategory = Integer.valueOf(categorizeByYear2016Method(paramContext));
      }
      int i = mYearCategory.intValue();
      AppMethodBeat.o(114635);
      return i;
    }
    finally
    {
      AppMethodBeat.o(114635);
    }
  }
  
  private static int getClockSpeedYear()
  {
    AppMethodBeat.i(114640);
    long l = DeviceInfo.getCPUMaxFreqKHz();
    if (l == -1L)
    {
      AppMethodBeat.o(114640);
      return -1;
    }
    if (l <= 528000L)
    {
      AppMethodBeat.o(114640);
      return 2008;
    }
    if (l <= 620000L)
    {
      AppMethodBeat.o(114640);
      return 2009;
    }
    if (l <= 1020000L)
    {
      AppMethodBeat.o(114640);
      return 2010;
    }
    if (l <= 1220000L)
    {
      AppMethodBeat.o(114640);
      return 2011;
    }
    if (l <= 1520000L)
    {
      AppMethodBeat.o(114640);
      return 2012;
    }
    if (l <= 2020000L)
    {
      AppMethodBeat.o(114640);
      return 2013;
    }
    AppMethodBeat.o(114640);
    return 2014;
  }
  
  private static int getNumCoresYear()
  {
    AppMethodBeat.i(114639);
    int i = DeviceInfo.getNumberOfCPUCores();
    if (i <= 0)
    {
      AppMethodBeat.o(114639);
      return -1;
    }
    if (i == 1)
    {
      AppMethodBeat.o(114639);
      return 2008;
    }
    if (i <= 3)
    {
      AppMethodBeat.o(114639);
      return 2011;
    }
    AppMethodBeat.o(114639);
    return 2012;
  }
  
  private static int getRamYear(Context paramContext)
  {
    AppMethodBeat.i(114641);
    long l = DeviceInfo.getTotalMemory(paramContext);
    if (l <= 0L)
    {
      AppMethodBeat.o(114641);
      return -1;
    }
    if (l <= 201326592L)
    {
      AppMethodBeat.o(114641);
      return 2008;
    }
    if (l <= 304087040L)
    {
      AppMethodBeat.o(114641);
      return 2009;
    }
    if (l <= 536870912L)
    {
      AppMethodBeat.o(114641);
      return 2010;
    }
    if (l <= 1073741824L)
    {
      AppMethodBeat.o(114641);
      return 2011;
    }
    if (l <= 1610612736L)
    {
      AppMethodBeat.o(114641);
      return 2012;
    }
    if (l <= 2147483648L)
    {
      AppMethodBeat.o(114641);
      return 2013;
    }
    AppMethodBeat.o(114641);
    return 2014;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.device.yearclass.YearClass
 * JD-Core Version:    0.7.0.1
 */