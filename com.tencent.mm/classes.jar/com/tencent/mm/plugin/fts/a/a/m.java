package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class m
  extends l
{
  private void a(Pattern paramPattern)
  {
    this.kxp = paramPattern.split(this.content);
    this.kxq = new int[this.kxp.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.kxq.length; i = k + 1 + i)
    {
      this.kxq[j] = i;
      k = this.kxp[j].length();
      j += 1;
    }
  }
  
  private void aVB()
  {
    switch (this.kwf)
    {
    default: 
      return;
    }
    ArrayList localArrayList = new ArrayList();
    a(c.a.kvl);
    String[] arrayOfString = c.a.kvk.split(this.kxm);
    byte[] arrayOfByte = this.content.getBytes();
    int i = 0;
    int n;
    int j;
    Object localObject;
    String str;
    if (i < arrayOfString.length)
    {
      n = Integer.valueOf(arrayOfString[i]).intValue();
      int m = new String(arrayOfByte, 0, Integer.valueOf(arrayOfString[(i + 1)]).intValue()).length();
      k = Arrays.binarySearch(this.kxq, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.kxp[j];
      str = null;
      localObject = c.a.kvm.split((CharSequence)localObject);
      m -= this.kxq[j];
      k = 0;
      label165:
      if (k >= localObject.length) {
        break label257;
      }
      m = m - localObject[k].length() - 1;
      if (m < 0) {
        str = localObject[k];
      }
    }
    label257:
    for (int k = com.tencent.mm.plugin.fts.a.c.kvd[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new f(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break;
      k += 1;
      break label165;
      this.kxr = localArrayList;
      return;
    }
  }
  
  public final void a(g paramg)
  {
    if (paramg.kwI.length > 1) {
      this.kxt = 1;
    }
    for (;;)
    {
      if (this.type == 131075) {
        if (System.currentTimeMillis() - this.timestamp < 1209600000L)
        {
          this.kwE += 50;
          String str = q.Gj();
          if (this.kwf == 38)
          {
            HashSet localHashSet = new HashSet();
            if (this.kxr != null)
            {
              Iterator localIterator = this.kxr.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  f localf = (f)localIterator.next();
                  if (!str.equals(localf.cMT))
                  {
                    localHashSet.add(Integer.valueOf(localf.kwA));
                    continue;
                    this.kxt = 0;
                    break;
                  }
                }
              }
            }
            if (localHashSet.size() >= this.kxk - 1L)
            {
              this.kwE += 20;
              this.kxu = true;
            }
            if ((paramg.kwI.length > 1) && (this.content.contains(paramg.kwG)))
            {
              this.kxt = 2;
              this.kwE += 5;
            }
            if (this.kxk <= 15L) {
              this.kxw = 1;
            }
          }
          if (((this.kwf == 5) || (this.kwf == 1)) && (this.content.contains(paramg.kwG)))
          {
            if (paramg.kwI.length > 1) {
              this.kxt = 2;
            }
            this.kwE += 10;
          }
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (this.type != 131072);
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.kwE += 50;
      }
    } while (((this.kwf != 5) && (this.kwf != 1)) || (!this.content.contains(paramg.kwG)));
    if (paramg.kwI.length > 1) {
      this.kxt = 2;
    }
    this.kwE += 10;
  }
  
  public final void aVA()
  {
    if (bk.bl(this.kxm)) {
      return;
    }
    switch (this.type)
    {
    default: 
      return;
    case 131072: 
    case 131073: 
    case 131074: 
    case 131076: 
    case 131081: 
    case 262144: 
    case 327680: 
      int i;
      switch (this.kwf)
      {
      default: 
        try
        {
          i = Integer.valueOf(c.a.kvk.split(this.kxm)[1]).intValue();
          this.kxn = new String(this.content.getBytes(), 0, i).length();
          this.kxo = this.content;
          return;
        }
        catch (Exception localException1)
        {
          this.kxn = 2147483647;
          this.kxo = "";
          return;
        }
      case 11: 
      case 51: 
        this.kxn = 2147483647;
        this.kxo = "";
        return;
      }
      try
      {
        String[] arrayOfString = c.a.kvk.split(this.kxm);
        a(c.a.kvo);
        i = Integer.valueOf(arrayOfString[1]).intValue();
        i = new String(this.content.getBytes(), 0, i).length();
        this.kxn = Arrays.binarySearch(this.kxq, i);
        if (this.kxn < 0) {
          this.kxn = (-this.kxn - 2);
        }
        this.kxo = this.kxp[this.kxn];
        return;
      }
      catch (Exception localException2)
      {
        this.kxn = 2147483647;
        this.kxo = "";
        return;
      }
    }
    aVB();
  }
  
  public final m h(Cursor paramCursor)
  {
    this.kxi = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.kwf = paramCursor.getInt(2);
    this.kxk = paramCursor.getLong(3);
    this.kwg = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    return this;
  }
  
  public final m i(Cursor paramCursor)
  {
    this.kxi = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.kwf = paramCursor.getInt(2);
    this.kxk = paramCursor.getLong(3);
    this.kwg = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.kxm = paramCursor.getString(7);
    this.kxs = paramCursor.getLong(8);
    return this;
  }
  
  public final m j(Cursor paramCursor)
  {
    this.kxi = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.kwf = paramCursor.getInt(2);
    this.kxk = paramCursor.getLong(3);
    this.kwg = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.kxm = paramCursor.getString(7);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.m
 * JD-Core Version:    0.7.0.1
 */