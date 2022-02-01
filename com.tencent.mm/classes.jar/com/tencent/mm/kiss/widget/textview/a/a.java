package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public Typeface bbO = null;
  public Layout.Alignment bbd = Layout.Alignment.ALIGN_NORMAL;
  public TextUtils.TruncateAt bbe = null;
  public int bbl = -1;
  public TextPaint dso = null;
  public int fl = 51;
  public int fontStyle = -1;
  public int linkColor = -1;
  public TextDirectionHeuristic mGO = null;
  public float mGP = 0.0F;
  public float mGQ = 1.1F;
  public boolean mGR = false;
  public int mHn = -1;
  public int mHo = -1;
  public int maxLength = -1;
  public int maxLines = -1;
  public int textColor = -1;
  public float textSize = -1.0F;
  
  public int hashCode()
  {
    AppMethodBeat.i(141135);
    int j = this.maxLines * 31 + 0 + this.maxLength * 31;
    int i = j;
    if (this.dso != null) {
      i = j + this.dso.hashCode() * 31;
    }
    j = i + this.bbd.hashCode() * 31;
    i = j;
    if (this.bbe != null) {
      i = j + this.bbe.hashCode() * 31;
    }
    j = i + this.fl * 31 + this.mHo * 31;
    i = j;
    if (this.mGO != null) {
      i = j + this.mGO.hashCode() * 31;
    }
    j = (int)((int)(i + this.mGP * 31.0F) + this.mGQ * 31.0F);
    if (this.mGR) {}
    for (i = 1;; i = 0)
    {
      j = i * 31 + j;
      i = j;
      if (this.bbO != null) {
        i = j + this.bbO.hashCode() * 31;
      }
      i = (int)(i + this.fontStyle * 31 + this.textSize * 31.0F);
      j = this.textColor;
      int k = this.linkColor;
      int m = this.bbl;
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
    ((StringBuilder)localObject).append(String.format("textPaint: %s ", new Object[] { this.dso }));
    ((StringBuilder)localObject).append(String.format("alignment: %s ", new Object[] { this.bbd }));
    ((StringBuilder)localObject).append(String.format("ellipsize: %s ", new Object[] { this.bbe }));
    ((StringBuilder)localObject).append(String.format("gravity: %s ", new Object[] { Integer.valueOf(this.fl) }));
    ((StringBuilder)localObject).append(String.format("ellipsizeWidth: %s ", new Object[] { Integer.valueOf(this.mHo) }));
    ((StringBuilder)localObject).append(String.format("textDirection: %s ", new Object[] { this.mGO }));
    ((StringBuilder)localObject).append(String.format("spacingAdd: %s spacingMult: %s ", new Object[] { Float.valueOf(this.mGP), Float.valueOf(this.mGQ) }));
    ((StringBuilder)localObject).append(String.format("includedPad: %b ", new Object[] { Boolean.valueOf(this.mGR) }));
    ((StringBuilder)localObject).append(String.format("typeface: %s ", new Object[] { this.bbO }));
    ((StringBuilder)localObject).append(String.format("fontStyle: %d ", new Object[] { Integer.valueOf(this.fontStyle) }));
    ((StringBuilder)localObject).append(String.format("textSize: %s ", new Object[] { Float.valueOf(this.textSize) }));
    ((StringBuilder)localObject).append(String.format("textColor: %d", new Object[] { Integer.valueOf(this.textColor) }));
    ((StringBuilder)localObject).append(String.format("linkColor: %d", new Object[] { Integer.valueOf(this.linkColor) }));
    ((StringBuilder)localObject).append(String.format("breakStrategy: %d", new Object[] { Integer.valueOf(this.bbl) }));
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(141134);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.a
 * JD-Core Version:    0.7.0.1
 */