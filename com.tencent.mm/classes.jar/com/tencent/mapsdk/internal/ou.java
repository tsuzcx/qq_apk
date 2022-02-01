package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.map.lib.models.MapExploreByTouchHelper;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ou
  extends MapExploreByTouchHelper
  implements fh
{
  public List<AccessibleTouchItem> a;
  public List<AccessibleTouchItem> b;
  public sj c;
  private Handler d;
  
  public ou(View paramView, sj paramsj)
  {
    super(paramView);
    AppMethodBeat.i(221892);
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.d = new Handler();
    this.c = paramsj;
    ((VectorMap)this.c.e_).a(this);
    AppMethodBeat.o(221892);
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221902);
    if ((this.accessibleTouchItems != null) && (this.accessibleTouchItems.size() > 0))
    {
      int i = this.accessibleTouchItems.size() - 1;
      AccessibleTouchItem localAccessibleTouchItem = (AccessibleTouchItem)this.accessibleTouchItems.get(i);
      if (((localAccessibleTouchItem instanceof ov)) && (localAccessibleTouchItem.getBounds().contains((int)paramFloat1, (int)paramFloat2)))
      {
        AppMethodBeat.o(221902);
        return i;
      }
    }
    AppMethodBeat.o(221902);
    return -1;
  }
  
  private void a()
  {
    AppMethodBeat.i(221910);
    ((VectorMap)this.c.e_).b(this);
    this.accessibleTouchItems.clear();
    this.a.clear();
    this.b.clear();
    AppMethodBeat.o(221910);
  }
  
  public final void a(oq paramoq)
  {
    AppMethodBeat.i(221995);
    if (paramoq == null)
    {
      AppMethodBeat.o(221995);
      return;
    }
    String str = paramoq.getContentDescription();
    if (gz.a(str))
    {
      AppMethodBeat.o(221995);
      return;
    }
    if (paramoq.E != null)
    {
      localObject = paramoq.i();
      i = paramoq.E.X();
      int j = paramoq.E.Y();
      if ((((Rect)localObject).left < 0) || (((Rect)localObject).top < 0) || (((Rect)localObject).right > i) || (((Rect)localObject).bottom > j)) {}
    }
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(221995);
      return;
    }
    Object localObject = new ov(this.c, paramoq);
    if (this.accessibleTouchItems.size() > 0)
    {
      paramoq = (AccessibleTouchItem)this.accessibleTouchItems.get(this.accessibleTouchItems.size() - 1);
      if ((paramoq == null) || (!(paramoq instanceof ov))) {}
    }
    for (;;)
    {
      if (str.startsWith("我的位置"))
      {
        this.accessibleTouchItems.add(localObject);
        AppMethodBeat.o(221995);
        return;
      }
      this.accessibleTouchItems.clear();
      this.a.add(localObject);
      Collections.sort(this.a);
      this.accessibleTouchItems.addAll(this.a);
      this.accessibleTouchItems.addAll(this.b);
      if (paramoq != null) {
        this.accessibleTouchItems.add(paramoq);
      }
      AppMethodBeat.o(221995);
      return;
      paramoq = null;
    }
  }
  
  public final int getTargetPoiItemIdx(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221973);
    if ((this.accessibleTouchItems != null) && (this.accessibleTouchItems.size() > 0))
    {
      if ((this.accessibleTouchItems != null) && (this.accessibleTouchItems.size() > 0))
      {
        i = this.accessibleTouchItems.size() - 1;
        AccessibleTouchItem localAccessibleTouchItem = (AccessibleTouchItem)this.accessibleTouchItems.get(i);
        if ((!(localAccessibleTouchItem instanceof ov)) || (!localAccessibleTouchItem.getBounds().contains((int)paramFloat1, (int)paramFloat2))) {}
      }
      while (i != -1)
      {
        AppMethodBeat.o(221973);
        return i;
        i = -1;
      }
      int i = 0;
      while (i < this.accessibleTouchItems.size())
      {
        if (((AccessibleTouchItem)this.accessibleTouchItems.get(i)).getBounds().contains((int)paramFloat1, (int)paramFloat2))
        {
          AppMethodBeat.o(221973);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(221973);
    return -1;
  }
  
  public final boolean onItemClicked(int paramInt)
  {
    AppMethodBeat.i(221964);
    if (paramInt >= this.accessibleTouchItems.size())
    {
      AppMethodBeat.o(221964);
      return false;
    }
    AccessibleTouchItem localAccessibleTouchItem = (AccessibleTouchItem)this.accessibleTouchItems.get(paramInt);
    if (localAccessibleTouchItem == null)
    {
      AppMethodBeat.o(221964);
      return false;
    }
    invalidateVirtualView(paramInt);
    sendEventForVirtualView(paramInt, 1);
    localAccessibleTouchItem.onClick();
    AppMethodBeat.o(221964);
    return true;
  }
  
  public final void onTalkBackActivate(View paramView)
  {
    AppMethodBeat.i(222002);
    super.onTalkBackActivate(paramView);
    ((VectorMap)this.c.e_).a(this);
    u();
    AppMethodBeat.o(222002);
  }
  
  public final void onTalkBackDeActivate(View paramView)
  {
    AppMethodBeat.i(222011);
    super.onTalkBackDeActivate(paramView);
    ((VectorMap)this.c.e_).b(this);
    AppMethodBeat.o(222011);
  }
  
  public final void u()
  {
    AppMethodBeat.i(221981);
    this.d.post(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        Object localObject2 = null;
        AppMethodBeat.i(225118);
        ou.a(ou.this).clear();
        ou.b(ou.this).clear();
        ou.c(ou.this).clear();
        if (ou.d(ou.this) != null)
        {
          Object localObject1 = ou.d(ou.this);
          ((sj)localObject1).ar.clear();
          Object localObject4 = x.b(((VectorMap)((bn)localObject1).e_).v().a(new fl(0.0D, 0.0D)));
          Object localObject5 = x.b(((VectorMap)((bn)localObject1).e_).v().a(new fl(((sj)localObject1).X(), ((sj)localObject1).Y())));
          Iterator localIterator = ((sr)localObject1).aB.J.b.iterator();
          while (localIterator.hasNext())
          {
            Object localObject6 = (eq)localIterator.next();
            if ((localObject6 instanceof av))
            {
              localObject6 = ((av)localObject6).a;
              if (sj.a(((an)localObject6).getPosition(), new ft[] { localObject4, localObject5 })) {
                ((sj)localObject1).ar.add(localObject6);
              }
            }
          }
          localObject4 = ((sj)localObject1).ar;
          localObject5 = ou.d(ou.this);
          ((sj)localObject5).as.clear();
          localObject1 = (VectorMap)((bn)localObject5).e_;
          if (((VectorMap)localObject1).o == null)
          {
            localObject1 = null;
            ((sj)localObject5).as = ((List)localObject1);
            localObject5 = ((sj)localObject5).as;
            localObject1 = localObject3;
            if (localObject4 != null)
            {
              localObject3 = ((List)localObject4).iterator();
              localObject1 = localObject2;
            }
          }
          else
          {
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label402;
              }
              localObject2 = (an)((Iterator)localObject3).next();
              localObject4 = ((an)localObject2).getContentDescription();
              if (!gz.a((String)localObject4))
              {
                if (((String)localObject4).startsWith("我的位置"))
                {
                  localObject1 = localObject2;
                  continue;
                  localObject1 = ((VectorMap)localObject1).o.D();
                  break;
                }
                ou.b(ou.this).add(new ov(ou.d(ou.this), (an)localObject2));
              }
            }
            label402:
            Collections.sort(ou.b(ou.this));
            ou.e(ou.this).addAll(ou.b(ou.this));
          }
          if (localObject5 != null)
          {
            localObject2 = ((List)localObject5).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (MapPoi)((Iterator)localObject2).next();
              if (!gz.a(((MapPoi)localObject3).getName())) {
                ou.c(ou.this).add(new ow(ou.d(ou.this), (MapPoi)localObject3));
              }
            }
            Collections.sort(ou.c(ou.this));
            ou.f(ou.this).addAll(ou.c(ou.this));
          }
          if (localObject1 != null) {
            ou.g(ou.this).add(new ov(ou.d(ou.this), (an)localObject1));
          }
        }
        AppMethodBeat.o(225118);
      }
    });
    AppMethodBeat.o(221981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ou
 * JD-Core Version:    0.7.0.1
 */