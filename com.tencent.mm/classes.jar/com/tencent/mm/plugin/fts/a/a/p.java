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

public final class p
  extends o
{
  private void a(Pattern paramPattern)
  {
    AppMethodBeat.i(131714);
    this.HtN = paramPattern.split(this.content);
    this.HtO = new int[this.HtN.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.HtO.length; i = k + 1 + i)
    {
      this.HtO[j] = i;
      k = this.HtN[j].length();
      j += 1;
    }
    AppMethodBeat.o(131714);
  }
  
  private void fxC()
  {
    AppMethodBeat.i(131716);
    switch (this.subtype)
    {
    default: 
      AppMethodBeat.o(131716);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    a(c.a.HrA);
    String[] arrayOfString = c.a.Hrz.split(this.HtK);
    byte[] arrayOfByte = this.content.getBytes();
    int i = 0;
    label73:
    int n;
    int j;
    Object localObject;
    String str;
    if (i < arrayOfString.length - 1)
    {
      n = Integer.valueOf(arrayOfString[i]).intValue();
      int m = new String(arrayOfByte, 0, Integer.valueOf(arrayOfString[(i + 1)]).intValue()).length();
      k = Arrays.binarySearch(this.HtO, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.HtN[j];
      str = null;
      localObject = c.a.HrB.split((CharSequence)localObject);
      m -= this.HtO[j];
      k = 0;
      label176:
      if (k >= localObject.length) {
        break label270;
      }
      m = m - localObject[k].length() - 1;
      if (m < 0) {
        str = localObject[k];
      }
    }
    label270:
    for (int k = com.tencent.mm.plugin.fts.a.c.Hrs[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new i(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break label73;
      k += 1;
      break label176;
      this.HtP = localArrayList;
      break;
    }
  }
  
  private void fxD()
  {
    AppMethodBeat.i(131717);
    switch (this.subtype)
    {
    }
    try
    {
      i = Integer.valueOf(c.a.Hrz.split(this.HtK)[1]).intValue();
      this.HtL = new String(this.content.getBytes(), 0, i).length();
      this.HtM = this.content;
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException2)
    {
      int i;
      this.HtL = 2147483647;
      this.HtM = "";
      AppMethodBeat.o(131717);
    }
    this.HtL = 2147483647;
    this.HtM = "";
    AppMethodBeat.o(131717);
    return;
    try
    {
      String[] arrayOfString = c.a.Hrz.split(this.HtK);
      a(c.a.HrD);
      i = Integer.valueOf(arrayOfString[1]).intValue();
      i = new String(this.content.getBytes(), 0, i).length();
      this.HtL = Arrays.binarySearch(this.HtO, i);
      if (this.HtL < 0) {
        this.HtL = (-this.HtL - 2);
      }
      this.HtM = this.HtN[this.HtL];
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException1)
    {
      this.HtL = 2147483647;
      this.HtM = "";
      AppMethodBeat.o(131717);
      return;
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(131718);
    if (paramj.Htg.length > 1) {
      this.HtS = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label387;
      }
      this.Htc += 50;
      String str = z.bAM();
      if (this.subtype == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.HtP != null)
        {
          Iterator localIterator = this.HtP.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              i locali = (i)localIterator.next();
              if (!str.equals(locali.kDc))
              {
                localHashSet.add(Integer.valueOf(locali.HsY));
                continue;
                this.HtS = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.HtI - 1L)
        {
          this.Htc += 20;
          this.HtT = true;
        }
        if ((paramj.Htg.length > 1) && (this.content.contains(paramj.Hte)))
        {
          this.HtS = 2;
          this.Htc += 5;
        }
        if (this.HtI <= 15L) {
          this.HtV = 1;
        }
      }
      if (((this.subtype == 5) || (this.subtype == 1)) && (this.content.contains(paramj.Hte)))
      {
        if (paramj.Htg.length > 1) {
          this.HtS = 2;
        }
        this.Htc += 10;
      }
      AppMethodBeat.o(131718);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.Htc += 50;
      }
      if (((this.subtype == 5) || (this.subtype == 1)) && (this.content.contains(paramj.Hte)))
      {
        if (paramj.Htg.length > 1) {
          this.HtS = 2;
        }
        this.Htc += 10;
      }
    }
    label387:
    AppMethodBeat.o(131718);
  }
  
  public final void fxB()
  {
    AppMethodBeat.i(131715);
    if (Util.isNullOrNil(this.HtK))
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
      fxD();
      AppMethodBeat.o(131715);
      return;
      fxC();
    }
  }
  
  public final p j(Cursor paramCursor)
  {
    AppMethodBeat.i(131711);
    this.HtG = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.subtype = paramCursor.getInt(2);
    this.HtI = paramCursor.getLong(3);
    this.Hsz = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    AppMethodBeat.o(131711);
    return this;
  }
  
  public final p k(Cursor paramCursor)
  {
    AppMethodBeat.i(131712);
    this.HtG = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.subtype = paramCursor.getInt(2);
    this.HtI = paramCursor.getLong(3);
    this.Hsz = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.HtK = paramCursor.getString(7);
    this.HtR = paramCursor.getLong(8);
    AppMethodBeat.o(131712);
    return this;
  }
  
  public final p l(Cursor paramCursor)
  {
    AppMethodBeat.i(131713);
    this.HtG = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.subtype = paramCursor.getInt(2);
    this.HtI = paramCursor.getLong(3);
    this.Hsz = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.HtK = paramCursor.getString(7);
    }
    AppMethodBeat.o(131713);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.p
 * JD-Core Version:    0.7.0.1
 */