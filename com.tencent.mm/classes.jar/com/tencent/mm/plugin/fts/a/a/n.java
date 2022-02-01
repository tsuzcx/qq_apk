package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class n
  extends m
{
  private void a(Pattern paramPattern)
  {
    AppMethodBeat.i(131714);
    this.wXj = paramPattern.split(this.content);
    this.wXk = new int[this.wXj.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.wXk.length; i = k + 1 + i)
    {
      this.wXk[j] = i;
      k = this.wXj[j].length();
      j += 1;
    }
    AppMethodBeat.o(131714);
  }
  
  private void dOD()
  {
    AppMethodBeat.i(131716);
    switch (this.wVW)
    {
    default: 
      AppMethodBeat.o(131716);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    a(c.a.wVa);
    String[] arrayOfString = c.a.wUZ.split(this.wXg);
    byte[] arrayOfByte = this.content.getBytes();
    int i = 0;
    label73:
    int n;
    int j;
    Object localObject;
    String str;
    if (i < arrayOfString.length)
    {
      n = Integer.valueOf(arrayOfString[i]).intValue();
      int m = new String(arrayOfByte, 0, Integer.valueOf(arrayOfString[(i + 1)]).intValue()).length();
      k = Arrays.binarySearch(this.wXk, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.wXj[j];
      str = null;
      localObject = c.a.wVb.split((CharSequence)localObject);
      m -= this.wXk[j];
      k = 0;
      label174:
      if (k >= localObject.length) {
        break label268;
      }
      m = m - localObject[k].length() - 1;
      if (m < 0) {
        str = localObject[k];
      }
    }
    label268:
    for (int k = com.tencent.mm.plugin.fts.a.c.wUS[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new g(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break label73;
      k += 1;
      break label174;
      this.wXl = localArrayList;
      break;
    }
  }
  
  private void dOE()
  {
    AppMethodBeat.i(131717);
    switch (this.wVW)
    {
    }
    try
    {
      i = Integer.valueOf(c.a.wUZ.split(this.wXg)[1]).intValue();
      this.wXh = new String(this.content.getBytes(), 0, i).length();
      this.wXi = this.content;
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException2)
    {
      int i;
      this.wXh = 2147483647;
      this.wXi = "";
      AppMethodBeat.o(131717);
    }
    this.wXh = 2147483647;
    this.wXi = "";
    AppMethodBeat.o(131717);
    return;
    try
    {
      String[] arrayOfString = c.a.wUZ.split(this.wXg);
      a(c.a.wVd);
      i = Integer.valueOf(arrayOfString[1]).intValue();
      i = new String(this.content.getBytes(), 0, i).length();
      this.wXh = Arrays.binarySearch(this.wXk, i);
      if (this.wXh < 0) {
        this.wXh = (-this.wXh - 2);
      }
      this.wXi = this.wXj[this.wXh];
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException1)
    {
      this.wXh = 2147483647;
      this.wXi = "";
      AppMethodBeat.o(131717);
      return;
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(131718);
    if (paramh.wWD.length > 1) {
      this.wXn = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label387;
      }
      this.wWz += 50;
      String str = z.aTY();
      if (this.wVW == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.wXl != null)
        {
          Iterator localIterator = this.wXl.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              g localg = (g)localIterator.next();
              if (!str.equals(localg.fMb))
              {
                localHashSet.add(Integer.valueOf(localg.wWv));
                continue;
                this.wXn = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.wXe - 1L)
        {
          this.wWz += 20;
          this.wXo = true;
        }
        if ((paramh.wWD.length > 1) && (this.content.contains(paramh.wWB)))
        {
          this.wXn = 2;
          this.wWz += 5;
        }
        if (this.wXe <= 15L) {
          this.wXq = 1;
        }
      }
      if (((this.wVW == 5) || (this.wVW == 1)) && (this.content.contains(paramh.wWB)))
      {
        if (paramh.wWD.length > 1) {
          this.wXn = 2;
        }
        this.wWz += 10;
      }
      AppMethodBeat.o(131718);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.wWz += 50;
      }
      if (((this.wVW == 5) || (this.wVW == 1)) && (this.content.contains(paramh.wWB)))
      {
        if (paramh.wWD.length > 1) {
          this.wXn = 2;
        }
        this.wWz += 10;
      }
    }
    label387:
    AppMethodBeat.o(131718);
  }
  
  public final void dOC()
  {
    AppMethodBeat.i(131715);
    if (Util.isNullOrNil(this.wXg))
    {
      AppMethodBeat.o(131715);
      return;
    }
    switch (this.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131715);
      return;
      dOE();
      AppMethodBeat.o(131715);
      return;
      dOD();
    }
  }
  
  public final n g(Cursor paramCursor)
  {
    AppMethodBeat.i(131711);
    this.wXc = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.wVW = paramCursor.getInt(2);
    this.wXe = paramCursor.getLong(3);
    this.wVX = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    AppMethodBeat.o(131711);
    return this;
  }
  
  public final n h(Cursor paramCursor)
  {
    AppMethodBeat.i(131712);
    this.wXc = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.wVW = paramCursor.getInt(2);
    this.wXe = paramCursor.getLong(3);
    this.wVX = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.wXg = paramCursor.getString(7);
    this.wXm = paramCursor.getLong(8);
    AppMethodBeat.o(131712);
    return this;
  }
  
  public final n i(Cursor paramCursor)
  {
    AppMethodBeat.i(131713);
    this.wXc = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.wVW = paramCursor.getInt(2);
    this.wXe = paramCursor.getLong(3);
    this.wVX = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.wXg = paramCursor.getString(7);
    }
    AppMethodBeat.o(131713);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.n
 * JD-Core Version:    0.7.0.1
 */