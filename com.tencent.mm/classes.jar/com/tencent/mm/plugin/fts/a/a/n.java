package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class n
  extends m
{
  private void c(Pattern paramPattern)
  {
    AppMethodBeat.i(131714);
    this.syS = paramPattern.split(this.content);
    this.syT = new int[this.syS.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.syT.length; i = k + 1 + i)
    {
      this.syT[j] = i;
      k = this.syS[j].length();
      j += 1;
    }
    AppMethodBeat.o(131714);
  }
  
  private void cKA()
  {
    AppMethodBeat.i(131716);
    switch (this.sxF)
    {
    default: 
      AppMethodBeat.o(131716);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    c(c.a.swJ);
    String[] arrayOfString = c.a.swI.split(this.syP);
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
      k = Arrays.binarySearch(this.syT, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.syS[j];
      str = null;
      localObject = c.a.swK.split((CharSequence)localObject);
      m -= this.syT[j];
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
    for (int k = com.tencent.mm.plugin.fts.a.c.swB[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new g(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break label73;
      k += 1;
      break label174;
      this.syU = localArrayList;
      break;
    }
  }
  
  private void cKB()
  {
    AppMethodBeat.i(131717);
    switch (this.sxF)
    {
    }
    try
    {
      i = Integer.valueOf(c.a.swI.split(this.syP)[1]).intValue();
      this.syQ = new String(this.content.getBytes(), 0, i).length();
      this.syR = this.content;
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException2)
    {
      int i;
      this.syQ = 2147483647;
      this.syR = "";
      AppMethodBeat.o(131717);
    }
    this.syQ = 2147483647;
    this.syR = "";
    AppMethodBeat.o(131717);
    return;
    try
    {
      String[] arrayOfString = c.a.swI.split(this.syP);
      c(c.a.swM);
      i = Integer.valueOf(arrayOfString[1]).intValue();
      i = new String(this.content.getBytes(), 0, i).length();
      this.syQ = Arrays.binarySearch(this.syT, i);
      if (this.syQ < 0) {
        this.syQ = (-this.syQ - 2);
      }
      this.syR = this.syS[this.syQ];
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException1)
    {
      this.syQ = 2147483647;
      this.syR = "";
      AppMethodBeat.o(131717);
      return;
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(131718);
    if (paramh.sym.length > 1) {
      this.syW = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label387;
      }
      this.syi += 50;
      String str = u.axw();
      if (this.sxF == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.syU != null)
        {
          Iterator localIterator = this.syU.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              g localg = (g)localIterator.next();
              if (!str.equals(localg.eNf))
              {
                localHashSet.add(Integer.valueOf(localg.sye));
                continue;
                this.syW = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.syN - 1L)
        {
          this.syi += 20;
          this.syX = true;
        }
        if ((paramh.sym.length > 1) && (this.content.contains(paramh.syk)))
        {
          this.syW = 2;
          this.syi += 5;
        }
        if (this.syN <= 15L) {
          this.syZ = 1;
        }
      }
      if (((this.sxF == 5) || (this.sxF == 1)) && (this.content.contains(paramh.syk)))
      {
        if (paramh.sym.length > 1) {
          this.syW = 2;
        }
        this.syi += 10;
      }
      AppMethodBeat.o(131718);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.syi += 50;
      }
      if (((this.sxF == 5) || (this.sxF == 1)) && (this.content.contains(paramh.syk)))
      {
        if (paramh.sym.length > 1) {
          this.syW = 2;
        }
        this.syi += 10;
      }
    }
    label387:
    AppMethodBeat.o(131718);
  }
  
  public final void cKz()
  {
    AppMethodBeat.i(131715);
    if (bs.isNullOrNil(this.syP))
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
      cKB();
      AppMethodBeat.o(131715);
      return;
      cKA();
    }
  }
  
  public final n g(Cursor paramCursor)
  {
    AppMethodBeat.i(131711);
    this.syL = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.sxF = paramCursor.getInt(2);
    this.syN = paramCursor.getLong(3);
    this.sxG = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    AppMethodBeat.o(131711);
    return this;
  }
  
  public final n h(Cursor paramCursor)
  {
    AppMethodBeat.i(131712);
    this.syL = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.sxF = paramCursor.getInt(2);
    this.syN = paramCursor.getLong(3);
    this.sxG = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.syP = paramCursor.getString(7);
    this.syV = paramCursor.getLong(8);
    AppMethodBeat.o(131712);
    return this;
  }
  
  public final n i(Cursor paramCursor)
  {
    AppMethodBeat.i(131713);
    this.syL = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.sxF = paramCursor.getInt(2);
    this.syN = paramCursor.getLong(3);
    this.sxG = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.syP = paramCursor.getString(7);
    }
    AppMethodBeat.o(131713);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.n
 * JD-Core Version:    0.7.0.1
 */