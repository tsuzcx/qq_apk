package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bu;
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
    this.tGk = paramPattern.split(this.content);
    this.tGl = new int[this.tGk.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.tGl.length; i = k + 1 + i)
    {
      this.tGl[j] = i;
      k = this.tGk[j].length();
      j += 1;
    }
    AppMethodBeat.o(131714);
  }
  
  private void cVu()
  {
    AppMethodBeat.i(131716);
    switch (this.tEX)
    {
    default: 
      AppMethodBeat.o(131716);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    a(c.a.tEb);
    String[] arrayOfString = c.a.tEa.split(this.tGh);
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
      k = Arrays.binarySearch(this.tGl, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.tGk[j];
      str = null;
      localObject = c.a.tEc.split((CharSequence)localObject);
      m -= this.tGl[j];
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
    for (int k = com.tencent.mm.plugin.fts.a.c.tDT[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new g(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break label73;
      k += 1;
      break label174;
      this.tGm = localArrayList;
      break;
    }
  }
  
  private void cVv()
  {
    AppMethodBeat.i(131717);
    switch (this.tEX)
    {
    }
    try
    {
      i = Integer.valueOf(c.a.tEa.split(this.tGh)[1]).intValue();
      this.tGi = new String(this.content.getBytes(), 0, i).length();
      this.tGj = this.content;
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException2)
    {
      int i;
      this.tGi = 2147483647;
      this.tGj = "";
      AppMethodBeat.o(131717);
    }
    this.tGi = 2147483647;
    this.tGj = "";
    AppMethodBeat.o(131717);
    return;
    try
    {
      String[] arrayOfString = c.a.tEa.split(this.tGh);
      a(c.a.tEe);
      i = Integer.valueOf(arrayOfString[1]).intValue();
      i = new String(this.content.getBytes(), 0, i).length();
      this.tGi = Arrays.binarySearch(this.tGl, i);
      if (this.tGi < 0) {
        this.tGi = (-this.tGi - 2);
      }
      this.tGj = this.tGk[this.tGi];
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException1)
    {
      this.tGi = 2147483647;
      this.tGj = "";
      AppMethodBeat.o(131717);
      return;
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(131718);
    if (paramh.tFE.length > 1) {
      this.tGo = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label387;
      }
      this.tFA += 50;
      String str = v.aAC();
      if (this.tEX == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.tGm != null)
        {
          Iterator localIterator = this.tGm.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              g localg = (g)localIterator.next();
              if (!str.equals(localg.fhy))
              {
                localHashSet.add(Integer.valueOf(localg.tFw));
                continue;
                this.tGo = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.tGf - 1L)
        {
          this.tFA += 20;
          this.tGp = true;
        }
        if ((paramh.tFE.length > 1) && (this.content.contains(paramh.tFC)))
        {
          this.tGo = 2;
          this.tFA += 5;
        }
        if (this.tGf <= 15L) {
          this.tGr = 1;
        }
      }
      if (((this.tEX == 5) || (this.tEX == 1)) && (this.content.contains(paramh.tFC)))
      {
        if (paramh.tFE.length > 1) {
          this.tGo = 2;
        }
        this.tFA += 10;
      }
      AppMethodBeat.o(131718);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.tFA += 50;
      }
      if (((this.tEX == 5) || (this.tEX == 1)) && (this.content.contains(paramh.tFC)))
      {
        if (paramh.tFE.length > 1) {
          this.tGo = 2;
        }
        this.tFA += 10;
      }
    }
    label387:
    AppMethodBeat.o(131718);
  }
  
  public final void cVt()
  {
    AppMethodBeat.i(131715);
    if (bu.isNullOrNil(this.tGh))
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
      cVv();
      AppMethodBeat.o(131715);
      return;
      cVu();
    }
  }
  
  public final n g(Cursor paramCursor)
  {
    AppMethodBeat.i(131711);
    this.tGd = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.tEX = paramCursor.getInt(2);
    this.tGf = paramCursor.getLong(3);
    this.tEY = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    AppMethodBeat.o(131711);
    return this;
  }
  
  public final n h(Cursor paramCursor)
  {
    AppMethodBeat.i(131712);
    this.tGd = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.tEX = paramCursor.getInt(2);
    this.tGf = paramCursor.getLong(3);
    this.tEY = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.tGh = paramCursor.getString(7);
    this.tGn = paramCursor.getLong(8);
    AppMethodBeat.o(131712);
    return this;
  }
  
  public final n i(Cursor paramCursor)
  {
    AppMethodBeat.i(131713);
    this.tGd = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.tEX = paramCursor.getInt(2);
    this.tGf = paramCursor.getLong(3);
    this.tEY = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.tGh = paramCursor.getString(7);
    }
    AppMethodBeat.o(131713);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.n
 * JD-Core Version:    0.7.0.1
 */