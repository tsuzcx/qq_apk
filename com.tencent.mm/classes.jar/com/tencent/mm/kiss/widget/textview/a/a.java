package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class a
{
  public Typeface blk = null;
  public Layout.Alignment dNX = Layout.Alignment.ALIGN_NORMAL;
  public TextUtils.TruncateAt dNY = null;
  public int dOA = -1;
  public float dOB = -1.0F;
  public TextDirectionHeuristic dOa = null;
  public float dOb = 0.0F;
  public float dOc = 1.0F;
  public boolean dOd = false;
  public TextPaint dOi = null;
  public int fontStyle = -1;
  public int gravity = 51;
  public int linkColor = -1;
  public int maxLength = -1;
  public int maxLines = -1;
  public int minLines = -1;
  public int textColor = -1;
  
  public final int hashCode()
  {
    int j = this.maxLines * 31 + 0 + this.maxLength * 31;
    int i = j;
    if (this.dOi != null) {
      i = j + this.dOi.hashCode() * 31;
    }
    j = i + this.dNX.hashCode() * 31;
    i = j;
    if (this.dNY != null) {
      i = j + this.dNY.hashCode() * 31;
    }
    j = i + this.gravity * 31 + this.dOA * 31;
    i = j;
    if (this.dOa != null) {
      i = j + this.dOa.hashCode() * 31;
    }
    j = (int)((int)(i + this.dOb * 31.0F) + this.dOc * 31.0F);
    if (this.dOd) {}
    for (i = 1;; i = 0)
    {
      j = i * 31 + j;
      i = j;
      if (this.blk != null) {
        i = j + this.blk.hashCode() * 31;
      }
      return (int)(i + this.fontStyle * 31 + this.dOB * 31.0F) + this.textColor * 31 + this.linkColor * 31;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(String.format("maxLines: %d ", new Object[] { Integer.valueOf(this.maxLines) }));
    localStringBuilder.append(String.format("maxLength: %d ", new Object[] { Integer.valueOf(this.maxLength) }));
    localStringBuilder.append(String.format("textPaint: %s ", new Object[] { this.dOi }));
    localStringBuilder.append(String.format("alignment: %s ", new Object[] { this.dNX }));
    localStringBuilder.append(String.format("ellipsize: %s ", new Object[] { this.dNY }));
    localStringBuilder.append(String.format("gravity: %s ", new Object[] { Integer.valueOf(this.gravity) }));
    localStringBuilder.append(String.format("ellipsizeWidth: %s ", new Object[] { Integer.valueOf(this.dOA) }));
    localStringBuilder.append(String.format("textDirection: %s ", new Object[] { this.dOa }));
    localStringBuilder.append(String.format("spacingAdd: %s spacingMult: %s ", new Object[] { Float.valueOf(this.dOb), Float.valueOf(this.dOc) }));
    localStringBuilder.append(String.format("includedPad: %b ", new Object[] { Boolean.valueOf(this.dOd) }));
    localStringBuilder.append(String.format("typeface: %s ", new Object[] { this.blk }));
    localStringBuilder.append(String.format("fontStyle: %d ", new Object[] { Integer.valueOf(this.fontStyle) }));
    localStringBuilder.append(String.format("textSize: %s ", new Object[] { Float.valueOf(this.dOB) }));
    localStringBuilder.append(String.format("textColor: %d", new Object[] { Integer.valueOf(this.textColor) }));
    localStringBuilder.append(String.format("linkColor: %d", new Object[] { Integer.valueOf(this.linkColor) }));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.a
 * JD-Core Version:    0.7.0.1
 */