package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public Typeface bKi = null;
  public Layout.Alignment eLF = Layout.Alignment.ALIGN_NORMAL;
  public TextUtils.TruncateAt eLG = null;
  public TextDirectionHeuristic eLI = null;
  public float eLJ = 0.0F;
  public float eLK = 1.0F;
  public boolean eLL = false;
  public TextPaint eLQ = null;
  public int eMi = -1;
  public int fontStyle = -1;
  public int gravity = 51;
  public int linkColor = -1;
  public int maxLength = -1;
  public int maxLines = -1;
  public int minLines = -1;
  public int textColor = -1;
  public float textSize = -1.0F;
  
  public final int hashCode()
  {
    AppMethodBeat.i(105815);
    int j = this.maxLines * 31 + 0 + this.maxLength * 31;
    int i = j;
    if (this.eLQ != null) {
      i = j + this.eLQ.hashCode() * 31;
    }
    j = i + this.eLF.hashCode() * 31;
    i = j;
    if (this.eLG != null) {
      i = j + this.eLG.hashCode() * 31;
    }
    j = i + this.gravity * 31 + this.eMi * 31;
    i = j;
    if (this.eLI != null) {
      i = j + this.eLI.hashCode() * 31;
    }
    j = (int)((int)(i + this.eLJ * 31.0F) + this.eLK * 31.0F);
    if (this.eLL) {}
    for (i = 1;; i = 0)
    {
      j = i * 31 + j;
      i = j;
      if (this.bKi != null) {
        i = j + this.bKi.hashCode() * 31;
      }
      i = (int)(i + this.fontStyle * 31 + this.textSize * 31.0F);
      j = this.textColor;
      int k = this.linkColor;
      AppMethodBeat.o(105815);
      return i + j * 31 + k * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(105814);
    Object localObject = new StringBuilder("");
    ((StringBuilder)localObject).append(String.format("maxLines: %d ", new Object[] { Integer.valueOf(this.maxLines) }));
    ((StringBuilder)localObject).append(String.format("maxLength: %d ", new Object[] { Integer.valueOf(this.maxLength) }));
    ((StringBuilder)localObject).append(String.format("textPaint: %s ", new Object[] { this.eLQ }));
    ((StringBuilder)localObject).append(String.format("alignment: %s ", new Object[] { this.eLF }));
    ((StringBuilder)localObject).append(String.format("ellipsize: %s ", new Object[] { this.eLG }));
    ((StringBuilder)localObject).append(String.format("gravity: %s ", new Object[] { Integer.valueOf(this.gravity) }));
    ((StringBuilder)localObject).append(String.format("ellipsizeWidth: %s ", new Object[] { Integer.valueOf(this.eMi) }));
    ((StringBuilder)localObject).append(String.format("textDirection: %s ", new Object[] { this.eLI }));
    ((StringBuilder)localObject).append(String.format("spacingAdd: %s spacingMult: %s ", new Object[] { Float.valueOf(this.eLJ), Float.valueOf(this.eLK) }));
    ((StringBuilder)localObject).append(String.format("includedPad: %b ", new Object[] { Boolean.valueOf(this.eLL) }));
    ((StringBuilder)localObject).append(String.format("typeface: %s ", new Object[] { this.bKi }));
    ((StringBuilder)localObject).append(String.format("fontStyle: %d ", new Object[] { Integer.valueOf(this.fontStyle) }));
    ((StringBuilder)localObject).append(String.format("textSize: %s ", new Object[] { Float.valueOf(this.textSize) }));
    ((StringBuilder)localObject).append(String.format("textColor: %d", new Object[] { Integer.valueOf(this.textColor) }));
    ((StringBuilder)localObject).append(String.format("linkColor: %d", new Object[] { Integer.valueOf(this.linkColor) }));
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(105814);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.a.a
 * JD-Core Version:    0.7.0.1
 */