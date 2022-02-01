package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am$b
{
  public final int height;
  public final int width;
  
  public am$b(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.width != paramObject.width) {
        return false;
      }
    } while (this.height == paramObject.height);
    return false;
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135604);
    String str = "Size(width=" + this.width + ", height=" + this.height + ')';
    AppMethodBeat.o(135604);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.am.b
 * JD-Core Version:    0.7.0.1
 */