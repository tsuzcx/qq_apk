package com.tencent.mm.plugin.bottle.ui;

import java.util.Calendar;
import java.util.Date;

final class f
{
  private static final long[] hZU = { 19416L, 19168L, 42352L, 21717L, 53856L, 55632L, 91476L, 22176L, 39632L, 21970L, 19168L, 42422L, 42192L, 53840L, 119381L, 46400L, 54944L, 44450L, 38320L, 84343L, 18800L, 42160L, 46261L, 27216L, 27968L, 109396L, 11104L, 38256L, 21234L, 18800L, 25958L, 54432L, 59984L, 28309L, 23248L, 11104L, 100067L, 37600L, 116951L, 51536L, 54432L, 120998L, 46416L, 22176L, 107956L, 9680L, 37584L, 53938L, 43344L, 46423L, 27808L, 46416L, 86869L, 19872L, 42448L, 83315L, 21200L, 43432L, 59728L, 27296L, 44710L, 43856L, 19296L, 43748L, 42352L, 21088L, 62051L, 55632L, 23383L, 22176L, 38608L, 19925L, 19152L, 42192L, 54484L, 53840L, 54616L, 46400L, 46496L, 103846L, 38320L, 18864L, 43380L, 42160L, 45690L, 27216L, 27968L, 44870L, 43872L, 38256L, 19189L, 18800L, 25776L, 29859L, 59984L, 27480L, 21952L, 43872L, 38613L, 37600L, 51552L, 55636L, 54432L, 55888L, 30034L, 22176L, 43959L, 9680L, 37584L, 51893L, 43344L, 46240L, 47780L, 44368L, 21977L, 19360L, 42416L, 86390L, 21168L, 43312L, 31060L, 27296L, 44368L, 23378L, 19296L, 42726L, 42208L, 53856L, 60005L, 54576L, 23200L, 30371L, 38608L, 19415L, 19152L, 42192L, 118966L, 53840L, 54560L, 56645L, 46496L, 22224L, 21938L, 18864L, 42359L, 42160L, 43600L, 111189L, 27936L, 44448L };
  private static final long hZW = new Date(0, 0, 31).getTime();
  public int day;
  public boolean hZV;
  public int month;
  public int year;
  
  public f()
  {
    this(Calendar.getInstance());
  }
  
  private f(Calendar paramCalendar)
  {
    int k = (int)((paramCalendar.getTime().getTime() - hZW) / 86400000L);
    int i = 1900;
    int m = 0;
    while ((i < 2050) && (k > 0))
    {
      m = on(i);
      k -= m;
      i += 1;
    }
    int j = k;
    int n = i;
    if (k < 0)
    {
      j = k + m;
      n = i - 1;
    }
    this.year = n;
    n = op(n);
    this.hZV = false;
    m = 0;
    i = 1;
    k = j;
    j = m;
    if ((i < 13) && (k > 0))
    {
      if ((n > 0) && (i == n + 1) && (!this.hZV))
      {
        i -= 1;
        this.hZV = true;
        j = oo(this.year);
      }
      for (;;)
      {
        k -= j;
        if ((this.hZV) && (i == n + 1)) {
          this.hZV = false;
        }
        i += 1;
        break;
        j = this.year;
        if ((hZU[(j - 1900)] & 65536 >> i) == 0L) {
          j = 29;
        } else {
          j = 30;
        }
      }
    }
    if ((k == 0) && (n > 0) && (i == n + 1)) {
      if (this.hZV) {
        this.hZV = false;
      }
    }
    for (;;)
    {
      if (k < 0)
      {
        j = k + j;
        i -= 1;
      }
      for (;;)
      {
        this.month = i;
        this.day = (j + 1);
        return;
        this.hZV = true;
        i -= 1;
        break;
        j = k;
      }
    }
  }
  
  private static int on(int paramInt)
  {
    int j = 348;
    int i = 32768;
    while (i > 8)
    {
      int k = j;
      if ((hZU[(paramInt - 1900)] & i) != 0L) {
        k = j + 1;
      }
      i >>= 1;
      j = k;
    }
    return j + oo(paramInt);
  }
  
  private static int oo(int paramInt)
  {
    if (op(paramInt) != 0)
    {
      if ((hZU[(paramInt - 1900)] & 0x10000) != 0L) {
        return 30;
      }
      return 29;
    }
    return 0;
  }
  
  private static int op(int paramInt)
  {
    return (int)(hZU[(paramInt - 1900)] & 0xF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.f
 * JD-Core Version:    0.7.0.1
 */