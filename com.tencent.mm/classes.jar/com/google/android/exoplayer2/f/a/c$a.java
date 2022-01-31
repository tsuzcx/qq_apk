package com.google.android.exoplayer2.f.a;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.List;

final class c$a
{
  public static final int aNh = j(2, 2, 2, 0);
  public static final int aNi = j(0, 0, 0, 0);
  public static final int aNj = j(0, 0, 0, 3);
  static final int[] aNk = { 0, 0, 0, 0, 0, 2, 0 };
  private static final int[] aNl = { 0, 0, 0, 0, 0, 0, 2 };
  private static final int[] aNm = { 3, 3, 3, 3, 3, 3, 1 };
  private static final boolean[] aNn = { 0, 0, 0, 1, 1, 1, 0 };
  static final int[] aNo = { aNi, aNj, aNi, aNi, aNj, aNi, aNi };
  private static final int[] aNp = { 0, 1, 2, 3, 4, 3, 4 };
  private static final int[] aNq = { 0, 0, 0, 0, 0, 3, 3 };
  static final int[] aNr = { aNi, aNi, aNi, aNi, aNi, aNj, aNj };
  final List<SpannableString> aMV = new LinkedList();
  final SpannableStringBuilder aMW = new SpannableStringBuilder();
  private int aMY;
  int aNA;
  private int aNB;
  private int aNC;
  private int aND;
  private int aNE;
  boolean aNs;
  boolean aNt;
  int aNu;
  int aNv;
  int aNw;
  boolean aNx;
  private int aNy;
  int aNz;
  boolean aoL;
  private int backgroundColor;
  private int foregroundColor;
  int priority;
  int row;
  int rowCount;
  
  public c$a()
  {
    reset();
  }
  
  public static int j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 255;
    a.aI(paramInt1, 4);
    a.aI(paramInt2, 4);
    a.aI(paramInt3, 4);
    a.aI(paramInt4, 4);
    switch (paramInt4)
    {
    default: 
      paramInt4 = 255;
      if (paramInt1 > 1)
      {
        paramInt1 = 255;
        label73:
        if (paramInt2 <= 1) {
          break label121;
        }
        paramInt2 = 255;
        label82:
        if (paramInt3 <= 1) {
          break label126;
        }
      }
      break;
    }
    label121:
    label126:
    for (paramInt3 = i;; paramInt3 = 0)
    {
      return Color.argb(paramInt4, paramInt1, paramInt2, paramInt3);
      paramInt4 = 255;
      break;
      paramInt4 = 127;
      break;
      paramInt4 = 0;
      break;
      paramInt1 = 0;
      break label73;
      paramInt2 = 0;
      break label82;
    }
  }
  
  private SpannableString nx()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.aMW);
    int i = localSpannableStringBuilder.length();
    if (i > 0)
    {
      if (this.aNC != -1) {
        localSpannableStringBuilder.setSpan(new StyleSpan(2), this.aNC, i, 33);
      }
      if (this.aMY != -1) {
        localSpannableStringBuilder.setSpan(new UnderlineSpan(), this.aMY, i, 33);
      }
      if (this.aND != -1) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.aND, i, 33);
      }
      if (this.aNE != -1) {
        localSpannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.aNE, i, 33);
      }
    }
    return new SpannableString(localSpannableStringBuilder);
  }
  
  public static int r(int paramInt1, int paramInt2, int paramInt3)
  {
    return j(paramInt1, paramInt2, paramInt3, 0);
  }
  
  public final void aF(int paramInt1, int paramInt2)
  {
    this.aNB = paramInt1;
    this.aNy = paramInt2;
  }
  
  public final void aG(int paramInt1, int paramInt2)
  {
    if ((this.aND != -1) && (this.foregroundColor != paramInt1)) {
      this.aMW.setSpan(new ForegroundColorSpan(this.foregroundColor), this.aND, this.aMW.length(), 33);
    }
    if (paramInt1 != aNh)
    {
      this.aND = this.aMW.length();
      this.foregroundColor = paramInt1;
    }
    if ((this.aNE != -1) && (this.backgroundColor != paramInt2)) {
      this.aMW.setSpan(new BackgroundColorSpan(this.backgroundColor), this.aNE, this.aMW.length(), 33);
    }
    if (paramInt2 != aNi)
    {
      this.aNE = this.aMW.length();
      this.backgroundColor = paramInt2;
    }
  }
  
  public final void append(char paramChar)
  {
    if (paramChar == '\n')
    {
      this.aMV.add(nx());
      this.aMW.clear();
      if (this.aNC != -1) {
        this.aNC = 0;
      }
      if (this.aMY != -1) {
        this.aMY = 0;
      }
      if (this.aND != -1) {
        this.aND = 0;
      }
      if (this.aNE != -1) {
        this.aNE = 0;
      }
      while (((this.aNx) && (this.aMV.size() >= this.rowCount)) || (this.aMV.size() >= 15)) {
        this.aMV.remove(0);
      }
    }
    this.aMW.append(paramChar);
  }
  
  public final void clear()
  {
    this.aMV.clear();
    this.aMW.clear();
    this.aNC = -1;
    this.aMY = -1;
    this.aND = -1;
    this.aNE = -1;
    this.row = 0;
  }
  
  public final void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.aNC != -1) {
      if (!paramBoolean1)
      {
        this.aMW.setSpan(new StyleSpan(2), this.aNC, this.aMW.length(), 33);
        this.aNC = -1;
      }
    }
    do
    {
      while (this.aMY != -1)
      {
        if (!paramBoolean2)
        {
          this.aMW.setSpan(new UnderlineSpan(), this.aMY, this.aMW.length(), 33);
          this.aMY = -1;
        }
        return;
        if (paramBoolean1) {
          this.aNC = this.aMW.length();
        }
      }
    } while (!paramBoolean2);
    this.aMY = this.aMW.length();
  }
  
  public final boolean isEmpty()
  {
    return (!this.aNs) || ((this.aMV.isEmpty()) && (this.aMW.length() == 0));
  }
  
  public final b nA()
  {
    boolean bool = false;
    if (isEmpty()) {
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < this.aMV.size())
    {
      localSpannableStringBuilder.append((CharSequence)this.aMV.get(i));
      localSpannableStringBuilder.append('\n');
      i += 1;
    }
    localSpannableStringBuilder.append(nx());
    Layout.Alignment localAlignment;
    float f2;
    float f1;
    label173:
    label184:
    int j;
    switch (this.aNy)
    {
    default: 
      throw new IllegalArgumentException("Unexpected justification value: " + this.aNy);
    case 0: 
    case 3: 
      localAlignment = Layout.Alignment.ALIGN_NORMAL;
      if (this.aNt)
      {
        f2 = this.aNv / 99.0F;
        f1 = this.aNu / 99.0F;
        if (this.aNw % 3 != 0) {
          break label285;
        }
        i = 0;
        if (this.aNw / 3 != 0) {
          break label305;
        }
        j = 0;
      }
      break;
    }
    for (;;)
    {
      if (this.aNB != aNi) {
        bool = true;
      }
      return new b(localSpannableStringBuilder, localAlignment, f1 * 0.9F + 0.05F, i, f2 * 0.9F + 0.05F, j, bool, this.aNB, this.priority);
      localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      break;
      localAlignment = Layout.Alignment.ALIGN_CENTER;
      break;
      f2 = this.aNv / 209.0F;
      f1 = this.aNu / 74.0F;
      break label173;
      label285:
      if (this.aNw % 3 == 1)
      {
        i = 1;
        break label184;
      }
      i = 2;
      break label184;
      label305:
      if (this.aNw / 3 == 1) {
        j = 1;
      } else {
        j = 2;
      }
    }
  }
  
  public final void reset()
  {
    clear();
    this.aNs = false;
    this.aoL = false;
    this.priority = 4;
    this.aNt = false;
    this.aNu = 0;
    this.aNv = 0;
    this.aNw = 0;
    this.rowCount = 15;
    this.aNx = true;
    this.aNy = 0;
    this.aNz = 0;
    this.aNA = 0;
    this.aNB = aNi;
    this.foregroundColor = aNh;
    this.backgroundColor = aNi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c.a
 * JD-Core Version:    0.7.0.1
 */