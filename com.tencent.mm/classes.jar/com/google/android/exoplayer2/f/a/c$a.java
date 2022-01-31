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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

final class c$a
{
  public static final int aUB;
  public static final int aUC;
  public static final int aUD;
  static final int[] aUE;
  private static final int[] aUF;
  private static final int[] aUG;
  private static final boolean[] aUH;
  static final int[] aUI;
  private static final int[] aUJ;
  private static final int[] aUK;
  static final int[] aUL;
  boolean aUM;
  boolean aUN;
  int aUO;
  int aUP;
  int aUQ;
  boolean aUR;
  private int aUS;
  int aUT;
  int aUU;
  private int aUV;
  private int aUW;
  private int aUX;
  private int aUY;
  final List<SpannableString> aUp;
  private final SpannableStringBuilder aUq;
  private int aUs;
  boolean arf;
  private int backgroundColor;
  private int foregroundColor;
  int priority;
  int row;
  int rowCount;
  
  static
  {
    AppMethodBeat.i(95593);
    aUB = l(2, 2, 2, 0);
    aUC = l(0, 0, 0, 0);
    aUD = l(0, 0, 0, 3);
    aUE = new int[] { 0, 0, 0, 0, 0, 2, 0 };
    aUF = new int[] { 0, 0, 0, 0, 0, 0, 2 };
    aUG = new int[] { 3, 3, 3, 3, 3, 3, 1 };
    aUH = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
    aUI = new int[] { aUC, aUD, aUC, aUC, aUD, aUC, aUC };
    aUJ = new int[] { 0, 1, 2, 3, 4, 3, 4 };
    aUK = new int[] { 0, 0, 0, 0, 0, 3, 3 };
    aUL = new int[] { aUC, aUC, aUC, aUC, aUC, aUD, aUD };
    AppMethodBeat.o(95593);
  }
  
  public c$a()
  {
    AppMethodBeat.i(95581);
    this.aUp = new LinkedList();
    this.aUq = new SpannableStringBuilder();
    reset();
    AppMethodBeat.o(95581);
  }
  
  public static int l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 255;
    AppMethodBeat.i(95592);
    a.ba(paramInt1, 4);
    a.ba(paramInt2, 4);
    a.ba(paramInt3, 4);
    a.ba(paramInt4, 4);
    switch (paramInt4)
    {
    default: 
      paramInt4 = 255;
      if (paramInt1 > 1)
      {
        paramInt1 = 255;
        label77:
        if (paramInt2 <= 1) {
          break label132;
        }
        paramInt2 = 255;
        label86:
        if (paramInt3 <= 1) {
          break label137;
        }
      }
      break;
    }
    label132:
    label137:
    for (paramInt3 = i;; paramInt3 = 0)
    {
      paramInt1 = Color.argb(paramInt4, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(95592);
      return paramInt1;
      paramInt4 = 255;
      break;
      paramInt4 = 127;
      break;
      paramInt4 = 0;
      break;
      paramInt1 = 0;
      break label77;
      paramInt2 = 0;
      break label86;
    }
  }
  
  private SpannableString pU()
  {
    AppMethodBeat.i(95589);
    Object localObject = new SpannableStringBuilder(this.aUq);
    int i = ((SpannableStringBuilder)localObject).length();
    if (i > 0)
    {
      if (this.aUW != -1) {
        ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(2), this.aUW, i, 33);
      }
      if (this.aUs != -1) {
        ((SpannableStringBuilder)localObject).setSpan(new UnderlineSpan(), this.aUs, i, 33);
      }
      if (this.aUX != -1) {
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.foregroundColor), this.aUX, i, 33);
      }
      if (this.aUY != -1) {
        ((SpannableStringBuilder)localObject).setSpan(new BackgroundColorSpan(this.backgroundColor), this.aUY, i, 33);
      }
    }
    localObject = new SpannableString((CharSequence)localObject);
    AppMethodBeat.o(95589);
    return localObject;
  }
  
  public static int r(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95591);
    paramInt1 = l(paramInt1, paramInt2, paramInt3, 0);
    AppMethodBeat.o(95591);
    return paramInt1;
  }
  
  public final void aX(int paramInt1, int paramInt2)
  {
    this.aUV = paramInt1;
    this.aUS = paramInt2;
  }
  
  public final void aY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95586);
    if ((this.aUX != -1) && (this.foregroundColor != paramInt1)) {
      this.aUq.setSpan(new ForegroundColorSpan(this.foregroundColor), this.aUX, this.aUq.length(), 33);
    }
    if (paramInt1 != aUB)
    {
      this.aUX = this.aUq.length();
      this.foregroundColor = paramInt1;
    }
    if ((this.aUY != -1) && (this.backgroundColor != paramInt2)) {
      this.aUq.setSpan(new BackgroundColorSpan(this.backgroundColor), this.aUY, this.aUq.length(), 33);
    }
    if (paramInt2 != aUC)
    {
      this.aUY = this.aUq.length();
      this.backgroundColor = paramInt2;
    }
    AppMethodBeat.o(95586);
  }
  
  public final void append(char paramChar)
  {
    AppMethodBeat.i(95588);
    if (paramChar == '\n')
    {
      this.aUp.add(pU());
      this.aUq.clear();
      if (this.aUW != -1) {
        this.aUW = 0;
      }
      if (this.aUs != -1) {
        this.aUs = 0;
      }
      if (this.aUX != -1) {
        this.aUX = 0;
      }
      if (this.aUY != -1) {
        this.aUY = 0;
      }
      while (((this.aUR) && (this.aUp.size() >= this.rowCount)) || (this.aUp.size() >= 15)) {
        this.aUp.remove(0);
      }
    }
    this.aUq.append(paramChar);
    AppMethodBeat.o(95588);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(95584);
    this.aUp.clear();
    this.aUq.clear();
    this.aUW = -1;
    this.aUs = -1;
    this.aUX = -1;
    this.aUY = -1;
    this.row = 0;
    AppMethodBeat.o(95584);
  }
  
  public final void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95585);
    if (this.aUW != -1) {
      if (!paramBoolean1)
      {
        this.aUq.setSpan(new StyleSpan(2), this.aUW, this.aUq.length(), 33);
        this.aUW = -1;
      }
    }
    while (this.aUs != -1)
    {
      if (paramBoolean2) {
        break label133;
      }
      this.aUq.setSpan(new UnderlineSpan(), this.aUs, this.aUq.length(), 33);
      this.aUs = -1;
      AppMethodBeat.o(95585);
      return;
      if (paramBoolean1) {
        this.aUW = this.aUq.length();
      }
    }
    if (paramBoolean2) {
      this.aUs = this.aUq.length();
    }
    label133:
    AppMethodBeat.o(95585);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(95582);
    if ((!this.aUM) || ((this.aUp.isEmpty()) && (this.aUq.length() == 0)))
    {
      AppMethodBeat.o(95582);
      return true;
    }
    AppMethodBeat.o(95582);
    return false;
  }
  
  public final void pS()
  {
    AppMethodBeat.i(95587);
    int i = this.aUq.length();
    if (i > 0) {
      this.aUq.delete(i - 1, i);
    }
    AppMethodBeat.o(95587);
  }
  
  public final b pY()
  {
    boolean bool = false;
    AppMethodBeat.i(95590);
    if (isEmpty())
    {
      AppMethodBeat.o(95590);
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < this.aUp.size())
    {
      localSpannableStringBuilder.append((CharSequence)this.aUp.get(i));
      localSpannableStringBuilder.append('\n');
      i += 1;
    }
    localSpannableStringBuilder.append(pU());
    Object localObject;
    float f2;
    float f1;
    label192:
    label203:
    int j;
    switch (this.aUS)
    {
    default: 
      localObject = new IllegalArgumentException("Unexpected justification value: " + this.aUS);
      AppMethodBeat.o(95590);
      throw ((Throwable)localObject);
    case 0: 
    case 3: 
      localObject = Layout.Alignment.ALIGN_NORMAL;
      if (this.aUN)
      {
        f2 = this.aUP / 99.0F;
        f1 = this.aUO / 99.0F;
        if (this.aUQ % 3 != 0) {
          break label319;
        }
        i = 0;
        if (this.aUQ / 3 != 0) {
          break label339;
        }
        j = 0;
      }
      break;
    }
    for (;;)
    {
      if (this.aUV != aUC) {
        bool = true;
      }
      localObject = new b(localSpannableStringBuilder, (Layout.Alignment)localObject, f1 * 0.9F + 0.05F, i, f2 * 0.9F + 0.05F, j, bool, this.aUV, this.priority);
      AppMethodBeat.o(95590);
      return localObject;
      localObject = Layout.Alignment.ALIGN_OPPOSITE;
      break;
      localObject = Layout.Alignment.ALIGN_CENTER;
      break;
      f2 = this.aUP / 209.0F;
      f1 = this.aUO / 74.0F;
      break label192;
      label319:
      if (this.aUQ % 3 == 1)
      {
        i = 1;
        break label203;
      }
      i = 2;
      break label203;
      label339:
      if (this.aUQ / 3 == 1) {
        j = 1;
      } else {
        j = 2;
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(95583);
    clear();
    this.aUM = false;
    this.arf = false;
    this.priority = 4;
    this.aUN = false;
    this.aUO = 0;
    this.aUP = 0;
    this.aUQ = 0;
    this.rowCount = 15;
    this.aUR = true;
    this.aUS = 0;
    this.aUT = 0;
    this.aUU = 0;
    this.aUV = aUC;
    this.foregroundColor = aUB;
    this.backgroundColor = aUC;
    AppMethodBeat.o(95583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c.a
 * JD-Core Version:    0.7.0.1
 */