package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public Typeface bGp = null;
  public TextPaint bzo = null;
  public int ek = 51;
  public int fontStyle = -1;
  public int kgU = -1;
  public int kgV = -1;
  public Layout.Alignment kgr = Layout.Alignment.ALIGN_NORMAL;
  public TextUtils.TruncateAt kgs = null;
  public TextDirectionHeuristic kgu = null;
  public float kgv = 0.0F;
  public float kgw = 1.0F;
  public boolean kgx = false;
  public int kgy = -1;
  public int linkColor = -1;
  public int maxLength = -1;
  public int maxLines = -1;
  public int textColor = -1;
  public float textSize = -1.0F;
  
  public int hashCode()
  {
    AppMethodBeat.i(141135);
    int j = this.maxLines * 31 + 0 + this.maxLength * 31;
    int i = j;
    if (this.bzo != null) {
      i = j + this.bzo.hashCode() * 31;
    }
    j = i + this.kgr.hashCode() * 31;
    i = j;
    if (this.kgs != null) {
      i = j + this.kgs.hashCode() * 31;
    }
    j = i + this.ek * 31 + this.kgV * 31;
    i = j;
    if (this.kgu != null) {
      i = j + this.kgu.hashCode() * 31;
    }
    j = (int)((int)(i + this.kgv * 31.0F) + this.kgw * 31.0F);
    if (this.kgx) {}
    for (i = 1;; i = 0)
    {
      j = i * 31 + j;
      i = j;
      if (this.bGp != null) {
        i = j + this.bGp.hashCode() * 31;
      }
      i = (int)(i + this.fontStyle * 31 + this.textSize * 31.0F);
      j = this.textColor;
      int k = this.linkColor;
      int m = this.kgy;
      AppMethodBeat.o(141135);
      return i + j * 31 + k * 31 + m * 31;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(141134);
    Object localObject = new StringBuilder("");
    ((StringBuilder)localObject).append(String.format("maxLines: %d ", new Object[] { Integer.valueOf(this.maxLines) }));
    ((StringBuilder)localObject).append(String.format("maxLength: %d ", new Object[] { Integer.valueOf(this.maxLength) }));
    ((StringBuilder)localObject).append(String.format("textPaint: %s ", new Object[] { this.bzo }));
    ((StringBuilder)localObject).append(String.format("alignment: %s ", new Object[] { this.kgr }));
    ((StringBuilder)localObject).append(String.format("ellipsize: %s ", new Object[] { this.kgs }));
    ((StringBuilder)localObject).append(String.format("gravity: %s ", new Object[] { Integer.valueOf(this.ek) }));
    ((StringBuilder)localObject).append(String.format("ellipsizeWidth: %s ", new Object[] { Integer.valueOf(this.kgV) }));
    ((StringBuilder)localObject).append(String.format("textDirection: %s ", new Object[] { this.kgu }));
    ((StringBuilder)localObject).append(String.format("spacingAdd: %s spacingMult: %s ", new Object[] { Float.valueOf(this.kgv), Float.valueOf(this.kgw) }));
    ((StringBuilder)localObject).append(String.format("includedPad: %b ", new Object[] { Boolean.valueOf(this.kgx) }));
    ((StringBuilder)localObject).append(String.format("typeface: %s ", new Object[] { this.bGp }));
    ((StringBuilder)localObject).append(String.format("fontStyle: %d ", new Object[] { Integer.valueOf(this.fontStyle) }));
    ((StringBuilder)localObject).append(String.format("textSize: %s ", new Object[] { Float.valueOf(this.textSize) }));
    ((StringBuilder)localObject).append(String.format("textColor: %d", new Object[] { Integer.valueOf(this.textColor) }));
    ((StringBuilder)localObject).append(String.format("linkColor: %d", new Object[] { Integer.valueOf(this.linkColor) }));
    ((StringBuilder)localObject).append(String.format("breakStrategy: %d", new Object[] { Integer.valueOf(this.kgy) }));
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(141134);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.a
 * JD-Core Version:    0.7.0.1
 */