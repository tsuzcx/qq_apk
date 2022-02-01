package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class qv
{
  Map<String, a> a;
  private final bi b;
  
  public qv(bi parambi)
  {
    AppMethodBeat.i(226176);
    this.b = parambi;
    this.a = new ConcurrentHashMap();
    AppMethodBeat.o(226176);
  }
  
  private Map<String, a> c()
  {
    return this.a;
  }
  
  final void a()
  {
    AppMethodBeat.i(226227);
    if (this.a == null)
    {
      AppMethodBeat.o(226227);
      return;
    }
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.a.get(localObject);
      if (localObject != null) {
        ((a)localObject).a.remove();
      }
    }
    this.a.clear();
    AppMethodBeat.o(226227);
  }
  
  final void a(List<Detail> paramList)
  {
    AppMethodBeat.i(226202);
    if ((this.b == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(226202);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Detail localDetail = (Detail)paramList.next();
      Object localObject = localDetail.basic.icon_normal;
      int i = ((String)localObject).lastIndexOf("/");
      if ((i != -1) && (i + 1 <= ((String)localObject).length()))
      {
        localObject = ((String)localObject).substring(i + 1);
        kh.a("TTE", "type:" + localDetail.basic.type + ", coord:" + localDetail.basic.coord_lat + ", " + localDetail.basic.coord_lon + ", minScale:" + localDetail.basic.min_scale + ", maxScale:" + localDetail.basic.max_scale);
        a locala = (a)this.a.get(localDetail.basic.eventid);
        if (locala == null)
        {
          localObject = new nh(localDetail.basic.coord_lat, localDetail.basic.coord_lon, (String)localObject);
          ((nh)localObject).anchor(localDetail.basic.anchor_x, localDetail.basic.anchor_y);
          ((nh)localObject).minScaleLevel(localDetail.basic.min_scale);
          ((nh)localObject).maxScaleLevel(localDetail.basic.max_scale);
          ((nh)localObject).avoidAnnotation(true);
          ((nh)localObject).avoidOtherMarker(true);
          localObject = (nf)this.b.a((mo)localObject);
          this.a.put(localDetail.basic.eventid, new a((nf)localObject, localDetail));
        }
        else
        {
          nh localnh = (nh)locala.a.a();
          localnh.position(localDetail.basic.coord_lat, localDetail.basic.coord_lon);
          localnh.iconName((String)localObject);
          localnh.anchor(localDetail.basic.anchor_x, localDetail.basic.anchor_y);
          localnh.minScaleLevel(localDetail.basic.min_scale);
          localnh.maxScaleLevel(localDetail.basic.max_scale);
          locala.a.a(localnh);
        }
      }
    }
    AppMethodBeat.o(226202);
  }
  
  public final void b()
  {
    AppMethodBeat.i(226234);
    a();
    this.a = null;
    AppMethodBeat.o(226234);
  }
  
  final void b(List<Detail> paramList)
  {
    AppMethodBeat.i(226213);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(226213);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Detail localDetail = (Detail)paramList.next();
      a locala = (a)this.a.get(localDetail.basic.eventid);
      if (locala != null)
      {
        locala.a.remove();
        this.a.remove(localDetail.basic.eventid);
      }
    }
    AppMethodBeat.o(226213);
  }
  
  public static final class a
  {
    final nf a;
    final Detail b;
    
    a(nf paramnf, Detail paramDetail)
    {
      this.a = paramnf;
      this.b = paramDetail;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qv
 * JD-Core Version:    0.7.0.1
 */