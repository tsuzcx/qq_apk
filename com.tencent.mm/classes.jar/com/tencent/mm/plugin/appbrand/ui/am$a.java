package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am$a
{
  public final int bottom;
  public final int left;
  public final int right;
  public final int top;
  
  public am$a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.left != paramObject.left) {
        return false;
      }
      if (this.top != paramObject.top) {
        return false;
      }
      if (this.right != paramObject.right) {
        return false;
      }
    } while (this.bottom == paramObject.bottom);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.left * 31 + this.top) * 31 + this.right) * 31 + this.bottom;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135603);
    String str = "Padding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
    AppMethodBeat.o(135603);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.am.a
 * JD-Core Version:    0.7.0.1
 */