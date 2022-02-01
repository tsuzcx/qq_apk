package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bt;
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
    this.rpY = paramPattern.split(this.content);
    this.rpZ = new int[this.rpY.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.rpZ.length; i = k + 1 + i)
    {
      this.rpZ[j] = i;
      k = this.rpY[j].length();
      j += 1;
    }
    AppMethodBeat.o(131714);
  }
  
  private void cxo()
  {
    AppMethodBeat.i(131716);
    switch (this.roM)
    {
    default: 
      AppMethodBeat.o(131716);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    c(c.a.rnP);
    String[] arrayOfString = c.a.rnO.split(this.rpV);
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
      k = Arrays.binarySearch(this.rpZ, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.rpY[j];
      str = null;
      localObject = c.a.rnQ.split((CharSequence)localObject);
      m -= this.rpZ[j];
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
    for (int k = com.tencent.mm.plugin.fts.a.c.rnH[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new g(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break label73;
      k += 1;
      break label174;
      this.rqa = localArrayList;
      break;
    }
  }
  
  private void cxp()
  {
    AppMethodBeat.i(131717);
    switch (this.roM)
    {
    }
    try
    {
      i = Integer.valueOf(c.a.rnO.split(this.rpV)[1]).intValue();
      this.rpW = new String(this.content.getBytes(), 0, i).length();
      this.rpX = this.content;
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException2)
    {
      int i;
      this.rpW = 2147483647;
      this.rpX = "";
      AppMethodBeat.o(131717);
    }
    this.rpW = 2147483647;
    this.rpX = "";
    AppMethodBeat.o(131717);
    return;
    try
    {
      String[] arrayOfString = c.a.rnO.split(this.rpV);
      c(c.a.rnS);
      i = Integer.valueOf(arrayOfString[1]).intValue();
      i = new String(this.content.getBytes(), 0, i).length();
      this.rpW = Arrays.binarySearch(this.rpZ, i);
      if (this.rpW < 0) {
        this.rpW = (-this.rpW - 2);
      }
      this.rpX = this.rpY[this.rpW];
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException1)
    {
      this.rpW = 2147483647;
      this.rpX = "";
      AppMethodBeat.o(131717);
      return;
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(131718);
    if (paramh.rps.length > 1) {
      this.rqc = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label387;
      }
      this.rpo += 50;
      String str = u.aqG();
      if (this.roM == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.rqa != null)
        {
          Iterator localIterator = this.rqa.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              g localg = (g)localIterator.next();
              if (!str.equals(localg.eKn))
              {
                localHashSet.add(Integer.valueOf(localg.rpk));
                continue;
                this.rqc = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.rpT - 1L)
        {
          this.rpo += 20;
          this.rqd = true;
        }
        if ((paramh.rps.length > 1) && (this.content.contains(paramh.rpq)))
        {
          this.rqc = 2;
          this.rpo += 5;
        }
        if (this.rpT <= 15L) {
          this.rqf = 1;
        }
      }
      if (((this.roM == 5) || (this.roM == 1)) && (this.content.contains(paramh.rpq)))
      {
        if (paramh.rps.length > 1) {
          this.rqc = 2;
        }
        this.rpo += 10;
      }
      AppMethodBeat.o(131718);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.rpo += 50;
      }
      if (((this.roM == 5) || (this.roM == 1)) && (this.content.contains(paramh.rpq)))
      {
        if (paramh.rps.length > 1) {
          this.rqc = 2;
        }
        this.rpo += 10;
      }
    }
    label387:
    AppMethodBeat.o(131718);
  }
  
  public final void cxn()
  {
    AppMethodBeat.i(131715);
    if (bt.isNullOrNil(this.rpV))
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
      cxp();
      AppMethodBeat.o(131715);
      return;
      cxo();
    }
  }
  
  public final n h(Cursor paramCursor)
  {
    AppMethodBeat.i(131711);
    this.rpR = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.roM = paramCursor.getInt(2);
    this.rpT = paramCursor.getLong(3);
    this.roN = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    AppMethodBeat.o(131711);
    return this;
  }
  
  public final n i(Cursor paramCursor)
  {
    AppMethodBeat.i(131712);
    this.rpR = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.roM = paramCursor.getInt(2);
    this.rpT = paramCursor.getLong(3);
    this.roN = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.rpV = paramCursor.getString(7);
    this.rqb = paramCursor.getLong(8);
    AppMethodBeat.o(131712);
    return this;
  }
  
  public final n j(Cursor paramCursor)
  {
    AppMethodBeat.i(131713);
    this.rpR = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.roM = paramCursor.getInt(2);
    this.rpT = paramCursor.getLong(3);
    this.roN = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.rpV = paramCursor.getString(7);
    }
    AppMethodBeat.o(131713);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.n
 * JD-Core Version:    0.7.0.1
 */