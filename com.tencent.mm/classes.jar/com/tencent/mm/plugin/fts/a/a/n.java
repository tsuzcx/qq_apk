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
    this.BJe = paramPattern.split(this.content);
    this.BJf = new int[this.BJe.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.BJf.length; i = k + 1 + i)
    {
      this.BJf[j] = i;
      k = this.BJe[j].length();
      j += 1;
    }
    AppMethodBeat.o(131714);
  }
  
  private void eqU()
  {
    AppMethodBeat.i(131716);
    switch (this.BHR)
    {
    default: 
      AppMethodBeat.o(131716);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    a(c.a.BGW);
    String[] arrayOfString = c.a.BGV.split(this.BJb);
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
      k = Arrays.binarySearch(this.BJf, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.BJe[j];
      str = null;
      localObject = c.a.BGX.split((CharSequence)localObject);
      m -= this.BJf[j];
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
    for (int k = com.tencent.mm.plugin.fts.a.c.BGO[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new g(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break label73;
      k += 1;
      break label176;
      this.BJg = localArrayList;
      break;
    }
  }
  
  private void eqV()
  {
    AppMethodBeat.i(131717);
    switch (this.BHR)
    {
    }
    try
    {
      i = Integer.valueOf(c.a.BGV.split(this.BJb)[1]).intValue();
      this.BJc = new String(this.content.getBytes(), 0, i).length();
      this.BJd = this.content;
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException2)
    {
      int i;
      this.BJc = 2147483647;
      this.BJd = "";
      AppMethodBeat.o(131717);
    }
    this.BJc = 2147483647;
    this.BJd = "";
    AppMethodBeat.o(131717);
    return;
    try
    {
      String[] arrayOfString = c.a.BGV.split(this.BJb);
      a(c.a.BGZ);
      i = Integer.valueOf(arrayOfString[1]).intValue();
      i = new String(this.content.getBytes(), 0, i).length();
      this.BJc = Arrays.binarySearch(this.BJf, i);
      if (this.BJc < 0) {
        this.BJc = (-this.BJc - 2);
      }
      this.BJd = this.BJe[this.BJc];
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException1)
    {
      this.BJc = 2147483647;
      this.BJd = "";
      AppMethodBeat.o(131717);
      return;
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(131718);
    if (paramh.BIy.length > 1) {
      this.BJj = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label387;
      }
      this.BIu += 50;
      String str = z.bcZ();
      if (this.BHR == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.BJg != null)
        {
          Iterator localIterator = this.BJg.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              g localg = (g)localIterator.next();
              if (!str.equals(localg.idS))
              {
                localHashSet.add(Integer.valueOf(localg.BIq));
                continue;
                this.BJj = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.BIZ - 1L)
        {
          this.BIu += 20;
          this.BJk = true;
        }
        if ((paramh.BIy.length > 1) && (this.content.contains(paramh.BIw)))
        {
          this.BJj = 2;
          this.BIu += 5;
        }
        if (this.BIZ <= 15L) {
          this.BJm = 1;
        }
      }
      if (((this.BHR == 5) || (this.BHR == 1)) && (this.content.contains(paramh.BIw)))
      {
        if (paramh.BIy.length > 1) {
          this.BJj = 2;
        }
        this.BIu += 10;
      }
      AppMethodBeat.o(131718);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.BIu += 50;
      }
      if (((this.BHR == 5) || (this.BHR == 1)) && (this.content.contains(paramh.BIw)))
      {
        if (paramh.BIy.length > 1) {
          this.BJj = 2;
        }
        this.BIu += 10;
      }
    }
    label387:
    AppMethodBeat.o(131718);
  }
  
  public final void eqT()
  {
    AppMethodBeat.i(131715);
    if (Util.isNullOrNil(this.BJb))
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
      eqV();
      AppMethodBeat.o(131715);
      return;
      eqU();
    }
  }
  
  public final n i(Cursor paramCursor)
  {
    AppMethodBeat.i(131711);
    this.BIX = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.BHR = paramCursor.getInt(2);
    this.BIZ = paramCursor.getLong(3);
    this.BHS = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    AppMethodBeat.o(131711);
    return this;
  }
  
  public final n j(Cursor paramCursor)
  {
    AppMethodBeat.i(131712);
    this.BIX = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.BHR = paramCursor.getInt(2);
    this.BIZ = paramCursor.getLong(3);
    this.BHS = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.BJb = paramCursor.getString(7);
    this.BJi = paramCursor.getLong(8);
    AppMethodBeat.o(131712);
    return this;
  }
  
  public final n k(Cursor paramCursor)
  {
    AppMethodBeat.i(131713);
    this.BIX = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.BHR = paramCursor.getInt(2);
    this.BIZ = paramCursor.getLong(3);
    this.BHS = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.BJb = paramCursor.getString(7);
    }
    AppMethodBeat.o(131713);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.n
 * JD-Core Version:    0.7.0.1
 */