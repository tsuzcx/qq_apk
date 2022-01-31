package com.tencent.mm.plugin.appbrand.ui.collection;

import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;

final class b$b
  implements DragSortListView.h
{
  b$b(b paramb) {}
  
  public final void cg(int paramInt1, int paramInt2)
  {
    Object localObject = b.a(this.hgt);
    if (localObject != null)
    {
      localObject = ((c)localObject).mq(paramInt1);
      if (localObject != null)
      {
        c localc = b.a(this.hgt);
        if (localc != null) {
          localc.insert(localObject, paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b.b
 * JD-Core Version:    0.7.0.1
 */