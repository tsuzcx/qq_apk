package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.i;
import com.tencent.mm.plugin.location.model.i.a;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.protocal.c.byn;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class m
{
  private static Object lHc = new Object();
  private a.a dig = new a.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
    {
      if (!paramAnonymousBoolean) {
        return false;
      }
      m localm = m.this;
      paramAnonymousDouble1 = paramAnonymousFloat2;
      paramAnonymousDouble2 = paramAnonymousFloat1;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("[refreshMyLocation] ");
      localStringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) }));
      if (localm.lDX == null)
      {
        localm.lDX = new ccg();
        localObject = new bfb();
        localm.lDX.tRA = ((bfb)localObject);
        localObject = q.Gj();
        localm.lDX.sxM = ((String)localObject);
        localm.lDX.tRA.sDn = paramAnonymousDouble1;
        localm.lDX.tRA.sDm = paramAnonymousDouble2;
        if ((localm.lEV) && (localm.lHf)) {
          localm.beE();
        }
      }
      localm.lDX.tRA.sDn = paramAnonymousDouble1;
      localm.lDX.tRA.sDm = paramAnonymousDouble2;
      Object localObject = localm.lEU.getViewByItag(localm.lDX.sxM);
      if (localObject != null)
      {
        localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
        y.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
        if ((localObject instanceof TrackPoint))
        {
          localm.lHd = ((TrackPoint)localObject);
          y.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
          localm.lHd.k(paramAnonymousDouble1, paramAnonymousDouble2);
        }
        if (localm.lHm) {
          localm.lEU.getIController().setCenter(localm.lDX.tRA.sDn, localm.lDX.tRA.sDm);
        }
        return true;
      }
      localObject = new TrackPoint(localm.mContext, (ViewManager)localm.lEU.getViewManager(), a.d.location_track_point_icon_myself);
      localm.lEU.addView(localObject, 0.0D, 0.0D, localm.lDX.sxM);
      ((TrackPoint)localObject).l(paramAnonymousDouble1, paramAnonymousDouble2);
      if (localm.lHk)
      {
        ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
        ((TrackPoint)localObject).setOnLocationOnClickListener(null);
        ((TrackPoint)localObject).bfa();
      }
      for (;;)
      {
        ((TrackPoint)localObject).setAvatar(localm.lDX.sxM);
        localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
        localm.lHe = new TrackPointAnimAvatar(localm.mContext);
        break;
        ((TrackPoint)localObject).setOnAvatarOnClickListener(localm.lHs);
        ((TrackPoint)localObject).setOnLocationOnClickListener(localm.lHr);
      }
    }
  };
  private boolean guU = false;
  protected float hZz = 0.0F;
  protected float kXk = 0.0F;
  public ccg lDX;
  d lEU;
  boolean lEV = false;
  private i.a lEj = new m.5(this);
  public List<ccg> lHb;
  public TrackPoint lHd;
  TrackPointAnimAvatar lHe;
  boolean lHf = false;
  public boolean lHg = false;
  public boolean lHh = true;
  public boolean lHi = false;
  public boolean lHj = false;
  public boolean lHk = false;
  public byn lHl;
  public boolean lHm = true;
  public boolean lHn = true;
  private boolean lHo = false;
  private long lHp = 0L;
  private View.OnTouchListener lHq = new m.1(this);
  View.OnClickListener lHr = new m.2(this);
  View.OnClickListener lHs = new m.3(this);
  public m.a lHt = null;
  Context mContext;
  
  public m(Context paramContext, d paramd, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.lEV = paramBoolean;
    this.lEU = paramd;
    this.lHb = new ArrayList();
    paramd.setMapViewOnTouchListener(this.lHq);
  }
  
  public final void a(d paramd)
  {
    if (this.lDX == null) {
      return;
    }
    if (paramd.getZoomLevel() < 16)
    {
      paramd.getIController().animateTo(this.lDX.tRA.sDn, this.lDX.tRA.sDm, 16);
      return;
    }
    paramd.getIController().animateTo(this.lDX.tRA.sDn, this.lDX.tRA.sDm);
  }
  
  public final void bJ(List<ccg> paramList)
  {
    this.lHf = true;
    int j = this.lHb.size() + 1;
    int i;
    int k;
    synchronized (lHc)
    {
      this.lHb.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.lHb.add(paramList.get(i));
        i += 1;
      }
      k = this.lHb.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (lHc)
    {
      localObject3 = this.lEU.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.lHb.size())
      {
        paramList.add(((ccg)this.lHb.get(i)).sxM);
        i += 1;
        continue;
        paramList = finally;
        throw paramList;
      }
      localObject2 = new LinkedList();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.lHd == null) || (!this.lHd.equals(this.lEU.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.lEU.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).lKs);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).lKt);
        }
      }
      this.lEU.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.lHb.size())
      {
        localObject2 = (ccg)this.lHb.get(i);
        paramList = this.lEU.getViewByItag(((ccg)localObject2).sxM);
        y.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((ccg)localObject2).sxM, Double.valueOf(((ccg)localObject2).tRA.sDn), Double.valueOf(((ccg)localObject2).tRA.sDm), Double.valueOf(((ccg)localObject2).tRA.tzO) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label851;
          }
          ((TrackPoint)paramList).k(((ccg)localObject2).tRA.sDn, ((ccg)localObject2).tRA.sDm);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((ccg)localObject2).sxM);
          paramList.v(((ccg)localObject2).tRA.tzO);
          if (!this.lHi)
          {
            paramList.bfa();
            break label859;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.lEU.getViewManager());
            this.lEU.addView(paramList, ((ccg)localObject2).tRA.sDn, ((ccg)localObject2).tRA.sDm, ((ccg)localObject2).sxM);
            ((TrackPoint)paramList).l(((ccg)localObject2).tRA.sDn, ((ccg)localObject2).tRA.sDm);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.lHs);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.lHr);
            continue;
            if ((this.lEV) && (this.lHf))
            {
              if (!s.fn(l.bdX().lEc)) {
                break label764;
              }
              beE();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.lEU.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).bfa();
                }
              }
              label764:
              if (this.lHb.size() > 0) {
                beE();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.lEU.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).bfb();
                }
              }
            }
            return;
            label851:
            continue;
            i = 0;
            break;
          }
        }
      }
      label859:
      i += 1;
    }
  }
  
  final void beE()
  {
    if (this.lHg) {}
    while (this.lDX == null) {
      return;
    }
    double d3 = 0.0D;
    double d4 = 0.0D;
    LocationInfo localLocationInfo;
    double d1;
    if (this.lDX != null)
    {
      localLocationInfo = l.bdX().lDY;
      double d2 = d4;
      d1 = d3;
      if (this.lDX != null)
      {
        d2 = d4;
        d1 = d3;
        if (e.h(localLocationInfo.lCJ, localLocationInfo.lCK))
        {
          d1 = 2.0D * Math.abs(this.lDX.tRA.sDn - localLocationInfo.lCJ);
          d2 = Math.abs(this.lDX.tRA.sDm - localLocationInfo.lCK) * 2.0D;
        }
      }
      int i = 0;
      d3 = d1;
      for (d1 = d2; i < this.lHb.size(); d1 = d4)
      {
        ccg localccg = (ccg)this.lHb.get(i);
        d2 = d3;
        d4 = d1;
        if (localccg != null)
        {
          d2 = d3;
          d4 = d1;
          if (e.h(localccg.tRA.sDn, localccg.tRA.sDm))
          {
            double d5 = 2.0D * Math.abs(localccg.tRA.sDn - this.lDX.tRA.sDn);
            d4 = Math.abs(localccg.tRA.sDm - this.lDX.tRA.sDm) * 2.0D;
            d2 = d3;
            if (d5 > d3) {
              d2 = d5;
            }
            d3 = d1;
            if (d4 > d1) {
              d3 = d4;
            }
            y.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localccg.sxM, Double.valueOf(localccg.tRA.sDn), Double.valueOf(localccg.tRA.sDm) });
            d4 = d3;
          }
        }
        i += 1;
        d3 = d2;
      }
      if ((Math.abs(d3 + 1000.0D) >= 0.5D) && (Math.abs(d1 + 1000.0D) >= 0.5D)) {
        break label384;
      }
    }
    for (;;)
    {
      this.lHg = true;
      return;
      label384:
      y.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.lCJ + " " + localLocationInfo.lCK);
      if (this.lDX != null)
      {
        y.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.lDX.tRA.sDn), Double.valueOf(this.lDX.tRA.sDm) });
        this.lEU.zoomToSpan(this.lDX.tRA.sDn, this.lDX.tRA.sDm, d3, d1);
      }
      else if (e.h(localLocationInfo.lCJ, localLocationInfo.lCK))
      {
        this.lEU.zoomToSpan(localLocationInfo.lCJ, localLocationInfo.lCK, d3, d1);
      }
    }
  }
  
  public final void destroy()
  {
    synchronized (lHc)
    {
      if (this.lHb != null) {
        this.lHb.clear();
      }
      this.lEU.clean();
      return;
    }
  }
  
  public final void hj(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.lHd == null) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        h.nFQ.f(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.lHj = paramBoolean;
      }
      return;
    }
  }
  
  public final void hk(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.lHi) && (this.lEU != null))
    {
      Iterator localIterator = this.lEU.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).bfb();
        }
      }
    }
    this.lHi = paramBoolean;
  }
  
  public final void onPause()
  {
    c.Ob().c(this.dig);
    l.bdZ().b(this.lEj);
  }
  
  public final void onResume()
  {
    c.Ob().b(this.dig, true);
    l.bdZ().a(this.lEj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.m
 * JD-Core Version:    0.7.0.1
 */