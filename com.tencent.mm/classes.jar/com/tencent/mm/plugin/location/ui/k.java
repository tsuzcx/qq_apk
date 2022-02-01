package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.q;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class k
{
  private static Object sTc;
  private b.a fjJ;
  private boolean jVE;
  Context mContext;
  protected float qXK;
  public div sPK;
  private com.tencent.mm.plugin.location.model.k.a sPW;
  public com.tencent.mm.plugin.k.d sQI;
  boolean sQJ;
  public List<div> sTb;
  public TrackPoint sTd;
  TrackPointAnimAvatar sTe;
  boolean sTf;
  public boolean sTg;
  public boolean sTh;
  public boolean sTi;
  public boolean sTj;
  public boolean sTk;
  public ddj sTl;
  public boolean sTm;
  public boolean sTn;
  private boolean sTo;
  private long sTp;
  private View.OnTouchListener sTq;
  View.OnClickListener sTr;
  View.OnClickListener sTs;
  public a sTt;
  protected float seQ;
  
  static
  {
    AppMethodBeat.i(55980);
    sTc = new Object();
    AppMethodBeat.o(55980);
  }
  
  public k(Context paramContext, com.tencent.mm.plugin.k.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(55968);
    this.sTf = false;
    this.sTg = false;
    this.sTh = true;
    this.sTi = false;
    this.sTj = false;
    this.sTk = false;
    this.sQJ = false;
    this.sTm = true;
    this.sTn = true;
    this.sTo = false;
    this.qXK = 0.0F;
    this.seQ = 0.0F;
    this.jVE = false;
    this.sTp = 0L;
    this.sTq = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(55963);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(55963);
          return false;
          if ((Math.abs(paramAnonymousMotionEvent.getX() - k.this.qXK) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - k.this.seQ) > 10.0F))
          {
            k.a(k.this, true);
            continue;
            k.this.qXK = paramAnonymousMotionEvent.getX();
            k.this.seQ = paramAnonymousMotionEvent.getY();
            k.a(k.this, System.currentTimeMillis());
            k.a(k.this, false);
            continue;
            if ((!k.a(k.this)) && (System.currentTimeMillis() - k.b(k.this) < 200L)) {
              k.c(k.this);
            }
          }
        }
      }
    };
    this.sTr = new k.2(this);
    this.sTs = new k.3(this);
    this.sTt = null;
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55966);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55966);
          return false;
        }
        k localk = k.this;
        paramAnonymousDouble1 = paramAnonymousFloat2;
        paramAnonymousDouble2 = paramAnonymousFloat1;
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("[refreshMyLocation] ");
        localStringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) }));
        if (localk.sPK == null)
        {
          localk.sPK = new div();
          localObject = new cbf();
          localk.sPK.Eze = ((cbf)localObject);
          localObject = u.aqG();
          localk.sPK.Username = ((String)localObject);
          localk.sPK.Eze.CJE = paramAnonymousDouble1;
          localk.sPK.Eze.CJD = paramAnonymousDouble2;
          if ((localk.sQJ) && (localk.sTf)) {
            localk.cJY();
          }
        }
        localk.sPK.Eze.CJE = paramAnonymousDouble1;
        localk.sPK.Eze.CJD = paramAnonymousDouble2;
        Object localObject = localk.sQI.getViewByItag(localk.sPK.Username);
        if (localObject != null)
        {
          localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
          ad.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
          if ((localObject instanceof TrackPoint))
          {
            localk.sTd = ((TrackPoint)localObject);
            ad.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            localk.sTd.n(paramAnonymousDouble1, paramAnonymousDouble2);
          }
          if (localk.sTm) {
            localk.sQI.getIController().setCenter(localk.sPK.Eze.CJE, localk.sPK.Eze.CJD);
          }
          AppMethodBeat.o(55966);
          return true;
        }
        localObject = new TrackPoint(localk.mContext, (ViewManager)localk.sQI.getViewManager(), (byte)0);
        localk.sQI.addView(localObject, 0.0D, 0.0D, localk.sPK.Username);
        ((TrackPoint)localObject).o(paramAnonymousDouble1, paramAnonymousDouble2);
        if (localk.sTk)
        {
          ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
          ((TrackPoint)localObject).setOnLocationOnClickListener(null);
          ((TrackPoint)localObject).cKC();
        }
        for (;;)
        {
          ((TrackPoint)localObject).setAvatar(localk.sPK.Username);
          localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
          localk.sTe = new TrackPointAnimAvatar(localk.mContext);
          break;
          ((TrackPoint)localObject).setOnAvatarOnClickListener(localk.sTs);
          ((TrackPoint)localObject).setOnLocationOnClickListener(localk.sTr);
        }
      }
    };
    this.sPW = new com.tencent.mm.plugin.location.model.k.a()
    {
      public final void x(double paramAnonymousDouble)
      {
        AppMethodBeat.i(55967);
        if (k.d(k.this) != null)
        {
          ad.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          k.d(k.this).y(paramAnonymousDouble);
        }
        AppMethodBeat.o(55967);
      }
    };
    this.mContext = paramContext;
    this.sQJ = paramBoolean;
    this.sQI = paramd;
    this.sTb = new ArrayList();
    paramd.setMapViewOnTouchListener(this.sTq);
    AppMethodBeat.o(55968);
  }
  
  private void cJZ()
  {
    AppMethodBeat.i(55974);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (this.sPK == null)
    {
      AppMethodBeat.o(55974);
      return;
    }
    LocationInfo localLocationInfo = n.cJq().sPL;
    double d2 = d4;
    double d1 = d3;
    if (this.sPK != null)
    {
      d2 = d4;
      d1 = d3;
      if (e.j(localLocationInfo.sOv, localLocationInfo.sOw))
      {
        d1 = 2.0D * Math.abs(this.sPK.Eze.CJE - localLocationInfo.sOv);
        d2 = Math.abs(this.sPK.Eze.CJD - localLocationInfo.sOw) * 2.0D;
      }
    }
    int i = 0;
    d3 = d1;
    for (d1 = d2; i < this.sTb.size(); d1 = d4)
    {
      div localdiv = (div)this.sTb.get(i);
      d2 = d3;
      d4 = d1;
      if (localdiv != null)
      {
        d2 = d3;
        d4 = d1;
        if (e.j(localdiv.Eze.CJE, localdiv.Eze.CJD))
        {
          double d5 = 2.0D * Math.abs(localdiv.Eze.CJE - this.sPK.Eze.CJE);
          d4 = Math.abs(localdiv.Eze.CJD - this.sPK.Eze.CJD) * 2.0D;
          d2 = d3;
          if (d5 > d3) {
            d2 = d5;
          }
          d3 = d1;
          if (d4 > d1) {
            d3 = d4;
          }
          ad.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localdiv.Username, Double.valueOf(localdiv.Eze.CJE), Double.valueOf(localdiv.Eze.CJD) });
          d4 = d3;
        }
      }
      i += 1;
      d3 = d2;
    }
    if ((Math.abs(d3 + 1000.0D) < 0.5D) || (Math.abs(d1 + 1000.0D) < 0.5D))
    {
      AppMethodBeat.o(55974);
      return;
    }
    ad.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.sOv + " " + localLocationInfo.sOw);
    if (this.sPK != null)
    {
      ad.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.sPK.Eze.CJE), Double.valueOf(this.sPK.Eze.CJD) });
      this.sQI.zoomToSpan(this.sPK.Eze.CJE, this.sPK.Eze.CJD, d3, d1);
      AppMethodBeat.o(55974);
      return;
    }
    if (e.j(localLocationInfo.sOv, localLocationInfo.sOw)) {
      this.sQI.zoomToSpan(localLocationInfo.sOv, localLocationInfo.sOw, d3, d1);
    }
    AppMethodBeat.o(55974);
  }
  
  public final void a(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55975);
    if (this.sPK == null)
    {
      AppMethodBeat.o(55975);
      return;
    }
    if (paramd.getZoomLevel() < 15)
    {
      paramd.getIController().animateTo(this.sPK.Eze.CJE, this.sPK.Eze.CJD, 15);
      AppMethodBeat.o(55975);
      return;
    }
    paramd.getIController().animateTo(this.sPK.Eze.CJE, this.sPK.Eze.CJD);
    AppMethodBeat.o(55975);
  }
  
  final void cJY()
  {
    AppMethodBeat.i(55973);
    if (this.sTg)
    {
      AppMethodBeat.o(55973);
      return;
    }
    if (this.sPK == null)
    {
      AppMethodBeat.o(55973);
      return;
    }
    cJZ();
    this.sTg = true;
    AppMethodBeat.o(55973);
  }
  
  public final void dX(List<div> paramList)
  {
    AppMethodBeat.i(55972);
    this.sTf = true;
    int j = this.sTb.size() + 1;
    int i;
    int k;
    synchronized (sTc)
    {
      this.sTb.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.sTb.add(paramList.get(i));
        i += 1;
      }
      k = this.sTb.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (sTc)
    {
      localObject3 = this.sQI.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.sTb.size())
      {
        paramList.add(((div)this.sTb.get(i)).Username);
        i += 1;
        continue;
        paramList = finally;
        AppMethodBeat.o(55972);
        throw paramList;
      }
      localObject2 = new LinkedList();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.sTd == null) || (!this.sTd.equals(this.sQI.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.sQI.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).sXm);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).sXn);
        }
      }
      this.sQI.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.sTb.size())
      {
        localObject2 = (div)this.sTb.get(i);
        paramList = this.sQI.getViewByItag(((div)localObject2).Username);
        ad.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((div)localObject2).Username, Double.valueOf(((div)localObject2).Eze.CJE), Double.valueOf(((div)localObject2).Eze.CJD), Double.valueOf(((div)localObject2).Eze.DXx) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label875;
          }
          ((TrackPoint)paramList).n(((div)localObject2).Eze.CJE, ((div)localObject2).Eze.CJD);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((div)localObject2).Username);
          paramList.y(((div)localObject2).Eze.DXx);
          if (!this.sTi)
          {
            paramList.cKC();
            break label883;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.sQI.getViewManager());
            this.sQI.addView(paramList, ((div)localObject2).Eze.CJE, ((div)localObject2).Eze.CJD, ((div)localObject2).Username);
            ((TrackPoint)paramList).o(((div)localObject2).Eze.CJE, ((div)localObject2).Eze.CJD);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.sTs);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.sTr);
            continue;
            if ((this.sQJ) && (this.sTf))
            {
              if (!w.pF(n.cJq().sPP)) {
                break label782;
              }
              cJY();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.sQI.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).cKC();
                }
              }
              label782:
              if (this.sTb.size() > 0) {
                cJY();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.sQI.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).cKD();
                }
              }
            }
            AppMethodBeat.o(55972);
            return;
            label875:
            continue;
            i = 0;
            break;
          }
        }
      }
      label883:
      i += 1;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55970);
    synchronized (sTc)
    {
      if (this.sTb != null) {
        this.sTb.clear();
      }
      this.sQI.clean();
      AppMethodBeat.o(55970);
      return;
    }
  }
  
  public final void mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(55969);
    if (paramBoolean) {
      if (this.sTd == null) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        h.vKh.f(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.sTj = paramBoolean;
      }
      AppMethodBeat.o(55969);
      return;
    }
  }
  
  public final void mK(boolean paramBoolean)
  {
    AppMethodBeat.i(55971);
    if ((paramBoolean) && (!this.sTi) && (this.sQI != null))
    {
      Iterator localIterator = this.sQI.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).cKD();
        }
      }
    }
    this.sTi = paramBoolean;
    AppMethodBeat.o(55971);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(55977);
    com.tencent.mm.modelgeo.d.axT().c(this.fjJ);
    n.cJs().b(this.sPW);
    AppMethodBeat.o(55977);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(55976);
    com.tencent.mm.modelgeo.d.axT().b(this.fjJ, true);
    n.cJs().a(this.sPW);
    AppMethodBeat.o(55976);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */