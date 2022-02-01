package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/luggage/base/ICustomize;", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "Padding", "Size", "luggage-wxa-app_release"})
public abstract interface y
  extends b
{
  public abstract a CM();
  
  public abstract y.b boM();
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-wxa-app_release"})
  public static final class a
  {
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.left = paramInt1;
      this.top = paramInt2;
      this.right = paramInt3;
      this.bottom = paramInt4;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.left != paramObject.left) || (this.top != paramObject.top) || (this.right != paramObject.right) || (this.bottom != paramObject.bottom)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return ((this.left * 31 + this.top) * 31 + this.right) * 31 + this.bottom;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(135603);
      String str = "Padding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
      AppMethodBeat.o(135603);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.y
 * JD-Core Version:    0.7.0.1
 */