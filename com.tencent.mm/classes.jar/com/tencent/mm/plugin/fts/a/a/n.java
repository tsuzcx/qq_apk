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
  private void a(Pattern paramPattern)
  {
    AppMethodBeat.i(131714);
    this.tvt = paramPattern.split(this.content);
    this.tvu = new int[this.tvt.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.tvu.length; i = k + 1 + i)
    {
      this.tvu[j] = i;
      k = this.tvt[j].length();
      j += 1;
    }
    AppMethodBeat.o(131714);
  }
  
  private void cSP()
  {
    AppMethodBeat.i(131716);
    switch (this.tug)
    {
    default: 
      AppMethodBeat.o(131716);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    a(c.a.ttk);
    String[] arrayOfString = c.a.ttj.split(this.tvq);
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
      k = Arrays.binarySearch(this.tvu, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.tvt[j];
      str = null;
      localObject = c.a.ttl.split((CharSequence)localObject);
      m -= this.tvu[j];
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
    for (int k = com.tencent.mm.plugin.fts.a.c.ttc[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new g(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break label73;
      k += 1;
      break label174;
      this.tvv = localArrayList;
      break;
    }
  }
  
  private void cSQ()
  {
    AppMethodBeat.i(131717);
    switch (this.tug)
    {
    }
    try
    {
      i = Integer.valueOf(c.a.ttj.split(this.tvq)[1]).intValue();
      this.tvr = new String(this.content.getBytes(), 0, i).length();
      this.tvs = this.content;
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException2)
    {
      int i;
      this.tvr = 2147483647;
      this.tvs = "";
      AppMethodBeat.o(131717);
    }
    this.tvr = 2147483647;
    this.tvs = "";
    AppMethodBeat.o(131717);
    return;
    try
    {
      String[] arrayOfString = c.a.ttj.split(this.tvq);
      a(c.a.ttn);
      i = Integer.valueOf(arrayOfString[1]).intValue();
      i = new String(this.content.getBytes(), 0, i).length();
      this.tvr = Arrays.binarySearch(this.tvu, i);
      if (this.tvr < 0) {
        this.tvr = (-this.tvr - 2);
      }
      this.tvs = this.tvt[this.tvr];
      AppMethodBeat.o(131717);
      return;
    }
    catch (Exception localException1)
    {
      this.tvr = 2147483647;
      this.tvs = "";
      AppMethodBeat.o(131717);
      return;
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(131718);
    if (paramh.tuN.length > 1) {
      this.tvx = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label387;
      }
      this.tuJ += 50;
      String str = u.aAm();
      if (this.tug == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.tvv != null)
        {
          Iterator localIterator = this.tvv.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              g localg = (g)localIterator.next();
              if (!str.equals(localg.ffB))
              {
                localHashSet.add(Integer.valueOf(localg.tuF));
                continue;
                this.tvx = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.tvo - 1L)
        {
          this.tuJ += 20;
          this.tvy = true;
        }
        if ((paramh.tuN.length > 1) && (this.content.contains(paramh.tuL)))
        {
          this.tvx = 2;
          this.tuJ += 5;
        }
        if (this.tvo <= 15L) {
          this.tvA = 1;
        }
      }
      if (((this.tug == 5) || (this.tug == 1)) && (this.content.contains(paramh.tuL)))
      {
        if (paramh.tuN.length > 1) {
          this.tvx = 2;
        }
        this.tuJ += 10;
      }
      AppMethodBeat.o(131718);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.tuJ += 50;
      }
      if (((this.tug == 5) || (this.tug == 1)) && (this.content.contains(paramh.tuL)))
      {
        if (paramh.tuN.length > 1) {
          this.tvx = 2;
        }
        this.tuJ += 10;
      }
    }
    label387:
    AppMethodBeat.o(131718);
  }
  
  public final void cSO()
  {
    AppMethodBeat.i(131715);
    if (bt.isNullOrNil(this.tvq))
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
      cSQ();
      AppMethodBeat.o(131715);
      return;
      cSP();
    }
  }
  
  public final n g(Cursor paramCursor)
  {
    AppMethodBeat.i(131711);
    this.tvm = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.tug = paramCursor.getInt(2);
    this.tvo = paramCursor.getLong(3);
    this.tuh = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    AppMethodBeat.o(131711);
    return this;
  }
  
  public final n h(Cursor paramCursor)
  {
    AppMethodBeat.i(131712);
    this.tvm = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.tug = paramCursor.getInt(2);
    this.tvo = paramCursor.getLong(3);
    this.tuh = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.tvq = paramCursor.getString(7);
    this.tvw = paramCursor.getLong(8);
    AppMethodBeat.o(131712);
    return this;
  }
  
  public final n i(Cursor paramCursor)
  {
    AppMethodBeat.i(131713);
    this.tvm = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.tug = paramCursor.getInt(2);
    this.tvo = paramCursor.getLong(3);
    this.tuh = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.tvq = paramCursor.getString(7);
    }
    AppMethodBeat.o(131713);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.n
 * JD-Core Version:    0.7.0.1
 */