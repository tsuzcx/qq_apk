package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public int breakStrategy = -1;
  public int fontStyle = -1;
  public int gFD = -1;
  public Layout.Alignment gFb = Layout.Alignment.ALIGN_NORMAL;
  public TextUtils.TruncateAt gFc = null;
  public TextDirectionHeuristic gFe = null;
  public float gFf = 0.0F;
  public float gFg = 1.0F;
  public boolean gFh = false;
  public int gravity = 51;
  public TextPaint iU = null;
  public int linkColor = -1;
  public int maxLength = -1;
  public int maxLines = -1;
  public int minLines = -1;
  public Typeface sx = null;
  public int textColor = -1;
  public float textSize = -1.0F;
  
  public final int hashCode()
  {
    AppMethodBeat.i(141135);
    int j = this.maxLines * 31 + 0 + this.maxLength * 31;
    int i = j;
    if (this.iU != null) {
      i = j + this.iU.hashCode() * 31;
    }
    j = i + this.gFb.hashCode() * 31;
    i = j;
    if (this.gFc != null) {
      i = j + this.gFc.hashCode() * 31;
    }
    j = i + this.gravity * 31 + this.gFD * 31;
    i = j;
    if (this.gFe != null) {
      i = j + this.gFe.hashCode() * 31;
    }
    j = (int)((int)(i + this.gFf * 31.0F) + this.gFg * 31.0F);
    if (this.gFh) {}
    for (i = 1;; i = 0)
    {
      j = i * 31 + j;
      i = j;
      if (this.sx != null) {
        i = j + this.sx.hashCode() * 31;
      }
      i = (int)(i + this.fontStyle * 31 + this.textSize * 31.0F);
      j = this.textColor;
      int k = this.linkColor;
      int m = this.breakStrategy;
      AppMethodBeat.o(141135);
      return i + j * 31 + k * 31 + m * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(141134);
    Object localObject = new StringBuilder("");
    ((StringBuilder)localObject).append(String.format("maxLines: %d ", new Object[] { Integer.valueOf(this.maxLines) }));
    ((StringBuilder)localObject).append(String.format("maxLength: %d ", new Object[] { Integer.valueOf(this.maxLength) }));
    ((StringBuilder)localObject).append(String.format("textPaint: %s ", new Object[] { this.iU }));
    ((StringBuilder)localObject).append(String.format("alignment: %s ", new Object[] { this.gFb }));
    ((StringBuilder)localObject).append(String.format("ellipsize: %s ", new Object[] { this.gFc }));
    ((StringBuilder)localObject).append(String.format("gravity: %s ", new Object[] { Integer.valueOf(this.gravity) }));
    ((StringBuilder)localObject).append(String.format("ellipsizeWidth: %s ", new Object[] { Integer.valueOf(this.gFD) }));
    ((StringBuilder)localObject).append(String.format("textDirection: %s ", new Object[] { this.gFe }));
    ((StringBuilder)localObject).append(String.format("spacingAdd: %s spacingMult: %s ", new Object[] { Float.valueOf(this.gFf), Float.valueOf(this.gFg) }));
    ((StringBuilder)localObject).append(String.format("includedPad: %b ", new Object[] { Boolean.valueOf(this.gFh) }));
    ((StringBuilder)localObject).append(String.format("typeface: %s ", new Object[] { this.sx }));
    ((StringBuilder)localObject).append(String.format("fontStyle: %d ", new Object[] { Integer.valueOf(this.fontStyle) }));
    ((StringBuilder)localObject).append(String.format("textSize: %s ", new Object[] { Float.valueOf(this.textSize) }));
    ((StringBuilder)localObject).append(String.format("textColor: %d", new Object[] { Integer.valueOf(this.textColor) }));
    ((StringBuilder)localObject).append(String.format("linkColor: %d", new Object[] { Integer.valueOf(this.linkColor) }));
    ((StringBuilder)localObject).append(String.format("breakStrategy: %d", new Object[] { Integer.valueOf(this.breakStrategy) }));
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(141134);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.a
 * JD-Core Version:    0.7.0.1
 */