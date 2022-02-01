package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/luggage/base/ICustomize;", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "Padding", "Size", "luggage-wxa-app_release"})
public abstract interface aa
  extends b
{
  public abstract a DS();
  
  public abstract b bAI();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "getLeft", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-wxa-app_release"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-wxa-app_release"})
  public static final class b
  {
    public final int height;
    public final int width;
    
    public b(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.width * 31 + this.height;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(135604);
      String str = "Size(width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(135604);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aa
 * JD-Core Version:    0.7.0.1
 */