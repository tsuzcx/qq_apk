package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(114278);
    this.mTe = paramPattern.split(this.content);
    this.mTf = new int[this.mTe.length];
    int j = 0;
    int k;
    for (int i = 0; j < this.mTf.length; i = k + 1 + i)
    {
      this.mTf[j] = i;
      k = this.mTe[j].length();
      j += 1;
    }
    AppMethodBeat.o(114278);
  }
  
  private void bCb()
  {
    AppMethodBeat.i(114280);
    switch (this.mRU)
    {
    default: 
      AppMethodBeat.o(114280);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    a(c.a.mQY);
    String[] arrayOfString = c.a.mQX.split(this.mTb);
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
      k = Arrays.binarySearch(this.mTf, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      localObject = this.mTe[j];
      str = null;
      localObject = c.a.mQZ.split((CharSequence)localObject);
      m -= this.mTf[j];
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
    for (int k = com.tencent.mm.plugin.fts.a.c.mQQ[k];; k = -1)
    {
      if (k > 0) {
        localArrayList.add(new f(j, n, k, str, localObject[(localObject.length - 1)]));
      }
      i += 2;
      break label73;
      k += 1;
      break label174;
      this.mTg = localArrayList;
      break;
    }
  }
  
  private void bCc()
  {
    AppMethodBeat.i(114281);
    switch (this.mRU)
    {
    }
    try
    {
      i = Integer.valueOf(c.a.mQX.split(this.mTb)[1]).intValue();
      this.mTc = new String(this.content.getBytes(), 0, i).length();
      this.mTd = this.content;
      AppMethodBeat.o(114281);
      return;
    }
    catch (Exception localException2)
    {
      int i;
      this.mTc = 2147483647;
      this.mTd = "";
      AppMethodBeat.o(114281);
    }
    this.mTc = 2147483647;
    this.mTd = "";
    AppMethodBeat.o(114281);
    return;
    try
    {
      String[] arrayOfString = c.a.mQX.split(this.mTb);
      a(c.a.mRb);
      i = Integer.valueOf(arrayOfString[1]).intValue();
      i = new String(this.content.getBytes(), 0, i).length();
      this.mTc = Arrays.binarySearch(this.mTf, i);
      if (this.mTc < 0) {
        this.mTc = (-this.mTc - 2);
      }
      this.mTd = this.mTe[this.mTc];
      AppMethodBeat.o(114281);
      return;
    }
    catch (Exception localException1)
    {
      this.mTc = 2147483647;
      this.mTd = "";
      AppMethodBeat.o(114281);
      return;
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(114282);
    if (paramg.mSy.length > 1) {
      this.mTi = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label387;
      }
      this.mSu += 50;
      String str = r.Zn();
      if (this.mRU == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.mTg != null)
        {
          Iterator localIterator = this.mTg.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              f localf = (f)localIterator.next();
              if (!str.equals(localf.dCJ))
              {
                localHashSet.add(Integer.valueOf(localf.mSq));
                continue;
                this.mTi = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.mSZ - 1L)
        {
          this.mSu += 20;
          this.mTj = true;
        }
        if ((paramg.mSy.length > 1) && (this.content.contains(paramg.mSw)))
        {
          this.mTi = 2;
          this.mSu += 5;
        }
        if (this.mSZ <= 15L) {
          this.mTl = 1;
        }
      }
      if (((this.mRU == 5) || (this.mRU == 1)) && (this.content.contains(paramg.mSw)))
      {
        if (paramg.mSy.length > 1) {
          this.mTi = 2;
        }
        this.mSu += 10;
      }
      AppMethodBeat.o(114282);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.mSu += 50;
      }
      if (((this.mRU == 5) || (this.mRU == 1)) && (this.content.contains(paramg.mSw)))
      {
        if (paramg.mSy.length > 1) {
          this.mTi = 2;
        }
        this.mSu += 10;
      }
    }
    label387:
    AppMethodBeat.o(114282);
  }
  
  public final void bCa()
  {
    AppMethodBeat.i(114279);
    if (bo.isNullOrNil(this.mTb))
    {
      AppMethodBeat.o(114279);
      return;
    }
    switch (this.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114279);
      return;
      bCc();
      AppMethodBeat.o(114279);
      return;
      bCb();
    }
  }
  
  public final m g(Cursor paramCursor)
  {
    AppMethodBeat.i(114275);
    this.mSX = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.mRU = paramCursor.getInt(2);
    this.mSZ = paramCursor.getLong(3);
    this.mRV = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.talker = paramCursor.getString(6);
    AppMethodBeat.o(114275);
    return this;
  }
  
  public final m h(Cursor paramCursor)
  {
    AppMethodBeat.i(114276);
    this.mSX = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.mRU = paramCursor.getInt(2);
    this.mSZ = paramCursor.getLong(3);
    this.mRV = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    this.content = paramCursor.getString(6);
    this.mTb = paramCursor.getString(7);
    this.mTh = paramCursor.getLong(8);
    AppMethodBeat.o(114276);
    return this;
  }
  
  public final m i(Cursor paramCursor)
  {
    AppMethodBeat.i(114277);
    this.mSX = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.mRU = paramCursor.getInt(2);
    this.mSZ = paramCursor.getLong(3);
    this.mRV = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.mTb = paramCursor.getString(7);
    }
    AppMethodBeat.o(114277);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.m
 * JD-Core Version:    0.7.0.1
 */