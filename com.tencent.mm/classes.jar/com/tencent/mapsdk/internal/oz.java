package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer.OnAoiLayerLoadListener;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class oz
  implements ey, AoiLayer.OnAoiLayerLoadListener
{
  public final List<ox> a;
  public final mk b;
  public TencentMap.OnMapPoiClickListener c;
  public final Map<String, AoiLayer.OnAoiLayerLoadListener> d;
  
  public oz(mk parammk)
  {
    AppMethodBeat.i(221804);
    this.a = new CopyOnWriteArrayList();
    this.d = new HashMap();
    this.b = parammk;
    AppMethodBeat.o(221804);
  }
  
  private bm a()
  {
    return this.b;
  }
  
  private AoiLayer a(String paramString, AoiLayerOptions paramAoiLayerOptions, AoiLayer.OnAoiLayerLoadListener paramOnAoiLayerLoadListener)
  {
    AppMethodBeat.i(221826);
    Object localObject = this.a.iterator();
    ox localox;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localox = (ox)((Iterator)localObject).next();
    } while ((localox.getId() == null) || (!localox.getId().equals(paramString)));
    for (;;)
    {
      localObject = localox;
      if (localox == null)
      {
        localox = new ox(this, paramString, paramAoiLayerOptions, this);
        this.a.add(localox);
        localObject = localox;
        if (paramOnAoiLayerLoadListener != null)
        {
          this.d.put(paramString, paramOnAoiLayerLoadListener);
          localObject = localox;
        }
      }
      ((ox)localObject).a(paramAoiLayerOptions);
      AppMethodBeat.o(221826);
      return localObject;
      localox = null;
    }
  }
  
  private void a(ox paramox)
  {
    AppMethodBeat.i(221832);
    this.a.remove(paramox);
    AppMethodBeat.o(221832);
  }
  
  private void a(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    this.c = paramOnMapPoiClickListener;
  }
  
  private boolean a(TappedElement paramTappedElement)
  {
    AppMethodBeat.i(221844);
    if (this.c == null)
    {
      AppMethodBeat.o(221844);
      return false;
    }
    ox localox;
    if ((paramTappedElement != null) && (paramTappedElement.type == 4))
    {
      long l = paramTappedElement.itemId;
      Iterator localIterator1 = this.a.iterator();
      if (!localIterator1.hasNext()) {
        break label229;
      }
      localox = (ox)localIterator1.next();
      if ((localox.b != null) && (localox.b.a != null) && (localox.b.a.j != null))
      {
        Iterator localIterator2 = localox.b.a.j.iterator();
        while (localIterator2.hasNext())
        {
          paramTappedElement = (oy.d)localIterator2.next();
          nf localnf = (nf)localox.a.b.k.a(nf.class, paramTappedElement.a);
          if ((localnf != null) && (localnf.e_() == l)) {
            label182:
            if (paramTappedElement == null) {
              break label220;
            }
          }
        }
      }
    }
    label220:
    label229:
    for (paramTappedElement = ox.a(localox.getId(), paramTappedElement);; paramTappedElement = null)
    {
      if (paramTappedElement != null)
      {
        this.c.onClicked(paramTappedElement);
        AppMethodBeat.o(221844);
        return true;
        paramTappedElement = null;
        break label182;
        break;
      }
      AppMethodBeat.o(221844);
      return false;
    }
  }
  
  private mk b()
  {
    return this.b;
  }
  
  private void c()
  {
    AppMethodBeat.i(221861);
    this.c = null;
    this.a.clear();
    this.d.clear();
    AppMethodBeat.o(221861);
  }
  
  public final void a(fr paramfr) {}
  
  public final void onAoiLayerLoaded(boolean paramBoolean, AoiLayer paramAoiLayer)
  {
    AppMethodBeat.i(221876);
    if ((paramAoiLayer != null) && (this.b != null))
    {
      AoiLayer.OnAoiLayerLoadListener localOnAoiLayerLoadListener = (AoiLayer.OnAoiLayerLoadListener)this.d.get(paramAoiLayer.getId());
      if (localOnAoiLayerLoadListener != null) {
        localOnAoiLayerLoadListener.onAoiLayerLoaded(paramBoolean, paramAoiLayer);
      }
      if (paramBoolean)
      {
        paramAoiLayer = this.b.d.g();
        paramAoiLayer.a += 1;
      }
    }
    AppMethodBeat.o(221876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.oz
 * JD-Core Version:    0.7.0.1
 */