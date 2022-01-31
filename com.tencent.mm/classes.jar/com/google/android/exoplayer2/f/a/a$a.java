package com.google.android.exoplayer2.f.a;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class a$a
{
  private int aMO;
  int aMP;
  final List<CharacterStyle> aMT = new ArrayList();
  final List<a.a.a> aMU = new ArrayList();
  final List<SpannableString> aMV = new LinkedList();
  final SpannableStringBuilder aMW = new SpannableStringBuilder();
  int aMX;
  int aMY;
  int asa;
  int row;
  
  public a$a(int paramInt1, int paramInt2)
  {
    reset(paramInt1, paramInt2);
  }
  
  private SpannableString nx()
  {
    int k = this.aMW.length();
    int i = 0;
    while (i < this.aMT.size())
    {
      this.aMW.setSpan(this.aMT.get(i), 0, k, 33);
      i += 1;
    }
    i = 0;
    if (i < this.aMU.size())
    {
      a.a.a locala = (a.a.a)this.aMU.get(i);
      if (i < this.aMU.size() - locala.aNa) {}
      for (int j = ((a.a.a)this.aMU.get(locala.aNa + i)).start;; j = k)
      {
        this.aMW.setSpan(locala.aMZ, locala.start, j, 33);
        i += 1;
        break;
      }
    }
    if (this.aMY != -1) {
      this.aMW.setSpan(new UnderlineSpan(), this.aMY, k, 33);
    }
    return new SpannableString(this.aMW);
  }
  
  public final void a(CharacterStyle paramCharacterStyle)
  {
    this.aMT.add(paramCharacterStyle);
  }
  
  public final void a(CharacterStyle paramCharacterStyle, int paramInt)
  {
    this.aMU.add(new a.a.a(paramCharacterStyle, this.aMW.length(), paramInt));
  }
  
  public final void append(char paramChar)
  {
    this.aMW.append(paramChar);
  }
  
  public final boolean isEmpty()
  {
    return (this.aMT.isEmpty()) && (this.aMU.isEmpty()) && (this.aMV.isEmpty()) && (this.aMW.length() == 0);
  }
  
  public final void nv()
  {
    int i = this.aMW.length();
    if (i > 0) {
      this.aMW.delete(i - 1, i);
    }
  }
  
  public final void nw()
  {
    this.aMV.add(nx());
    this.aMW.clear();
    this.aMT.clear();
    this.aMU.clear();
    this.aMY = -1;
    int i = Math.min(this.aMP, this.row);
    while (this.aMV.size() >= i) {
      this.aMV.remove(0);
    }
  }
  
  public final a ny()
  {
    int j = 2;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < this.aMV.size())
    {
      localSpannableStringBuilder.append((CharSequence)this.aMV.get(i));
      localSpannableStringBuilder.append('\n');
      i += 1;
    }
    localSpannableStringBuilder.append(nx());
    if (localSpannableStringBuilder.length() == 0) {
      return null;
    }
    i = this.asa + this.aMX;
    int k = 32 - i - localSpannableStringBuilder.length();
    int m = i - k;
    float f;
    if ((this.aMO == 2) && (Math.abs(m) < 3))
    {
      f = 0.5F;
      i = 1;
      if ((this.aMO != 1) && (this.row <= 7)) {
        break label231;
      }
      k = this.row - 15 - 2;
    }
    for (;;)
    {
      return new a(localSpannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, k, 1, j, f, i, 1.4E-45F);
      if ((this.aMO == 2) && (m > 0))
      {
        f = (32 - k) / 32.0F * 0.8F + 0.1F;
        i = 2;
        break;
      }
      f = i / 32.0F * 0.8F + 0.1F;
      i = 0;
      break;
      label231:
      k = this.row;
      j = 0;
    }
  }
  
  public final void reset(int paramInt1, int paramInt2)
  {
    this.aMT.clear();
    this.aMU.clear();
    this.aMV.clear();
    this.aMW.clear();
    this.row = 15;
    this.asa = 0;
    this.aMX = 0;
    this.aMO = paramInt1;
    this.aMP = paramInt2;
    this.aMY = -1;
  }
  
  public final String toString()
  {
    return this.aMW.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a.a
 * JD-Core Version:    0.7.0.1
 */