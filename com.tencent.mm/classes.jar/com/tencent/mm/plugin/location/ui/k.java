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
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class k
{
  private static Object ubo;
  private b.a fnd;
  private boolean kwq;
  Context mContext;
  protected float rYu;
  public dok tXX;
  public com.tencent.mm.plugin.k.d tYV;
  boolean tYW;
  private com.tencent.mm.plugin.location.model.k.a tYj;
  protected float tmJ;
  private boolean ubA;
  private long ubB;
  private View.OnTouchListener ubC;
  View.OnClickListener ubD;
  View.OnClickListener ubE;
  public a ubF;
  public List<dok> ubn;
  public TrackPoint ubp;
  TrackPointAnimAvatar ubq;
  boolean ubr;
  public boolean ubs;
  public boolean ubt;
  public boolean ubu;
  public boolean ubv;
  public boolean ubw;
  public diy ubx;
  public boolean uby;
  public boolean ubz;
  
  static
  {
    AppMethodBeat.i(55980);
    ubo = new Object();
    AppMethodBeat.o(55980);
  }
  
  public k(Context paramContext, com.tencent.mm.plugin.k.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(55968);
    this.ubr = false;
    this.ubs = false;
    this.ubt = true;
    this.ubu = false;
    this.ubv = false;
    this.ubw = false;
    this.tYW = false;
    this.uby = true;
    this.ubz = true;
    this.ubA = false;
    this.rYu = 0.0F;
    this.tmJ = 0.0F;
    this.kwq = false;
    this.ubB = 0L;
    this.ubC = new View.OnTouchListener()
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
          if ((Math.abs(paramAnonymousMotionEvent.getX() - k.this.rYu) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - k.this.tmJ) > 10.0F))
          {
            k.a(k.this, true);
            continue;
            k.this.rYu = paramAnonymousMotionEvent.getX();
            k.this.tmJ = paramAnonymousMotionEvent.getY();
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
    this.ubD = new k.2(this);
    this.ubE = new k.3(this);
    this.ubF = null;
    this.fnd = new b.a()
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
        if (localk.tXX == null)
        {
          localk.tXX = new dok();
          localObject = new cgf();
          localk.tXX.FWg = ((cgf)localObject);
          localObject = u.axw();
          localk.tXX.Username = ((String)localObject);
          localk.tXX.FWg.Ecg = paramAnonymousDouble1;
          localk.tXX.FWg.Ecf = paramAnonymousDouble2;
          if ((localk.tYW) && (localk.ubr)) {
            localk.cXD();
          }
        }
        localk.tXX.FWg.Ecg = paramAnonymousDouble1;
        localk.tXX.FWg.Ecf = paramAnonymousDouble2;
        Object localObject = localk.tYV.getViewByItag(localk.tXX.Username);
        if (localObject != null)
        {
          localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
          ac.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
          if ((localObject instanceof TrackPoint))
          {
            localk.ubp = ((TrackPoint)localObject);
            ac.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            localk.ubp.n(paramAnonymousDouble1, paramAnonymousDouble2);
          }
          if (localk.uby) {
            localk.tYV.getIController().setCenter(localk.tXX.FWg.Ecg, localk.tXX.FWg.Ecf);
          }
          AppMethodBeat.o(55966);
          return true;
        }
        localObject = new TrackPoint(localk.mContext, (ViewManager)localk.tYV.getViewManager(), (byte)0);
        localk.tYV.addView(localObject, 0.0D, 0.0D, localk.tXX.Username);
        ((TrackPoint)localObject).o(paramAnonymousDouble1, paramAnonymousDouble2);
        if (localk.ubw)
        {
          ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
          ((TrackPoint)localObject).setOnLocationOnClickListener(null);
          ((TrackPoint)localObject).cYh();
        }
        for (;;)
        {
          ((TrackPoint)localObject).setAvatar(localk.tXX.Username);
          localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
          localk.ubq = new TrackPointAnimAvatar(localk.mContext);
          break;
          ((TrackPoint)localObject).setOnAvatarOnClickListener(localk.ubE);
          ((TrackPoint)localObject).setOnLocationOnClickListener(localk.ubD);
        }
      }
    };
    this.tYj = new com.tencent.mm.plugin.location.model.k.a()
    {
      public final void w(double paramAnonymousDouble)
      {
        AppMethodBeat.i(55967);
        if (k.d(k.this) != null)
        {
          ac.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          k.d(k.this).x(paramAnonymousDouble);
        }
        AppMethodBeat.o(55967);
      }
    };
    this.mContext = paramContext;
    this.tYW = paramBoolean;
    this.tYV = paramd;
    this.ubn = new ArrayList();
    paramd.setMapViewOnTouchListener(this.ubC);
    AppMethodBeat.o(55968);
  }
  
  private void cXE()
  {
    AppMethodBeat.i(55974);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (this.tXX == null)
    {
      AppMethodBeat.o(55974);
      return;
    }
    LocationInfo localLocationInfo = n.cWV().tXY;
    double d2 = d4;
    double d1 = d3;
    if (this.tXX != null)
    {
      d2 = d4;
      d1 = d3;
      if (e.j(localLocationInfo.tWI, localLocationInfo.tWJ))
      {
        d1 = 2.0D * Math.abs(this.tXX.FWg.Ecg - localLocationInfo.tWI);
        d2 = Math.abs(this.tXX.FWg.Ecf - localLocationInfo.tWJ) * 2.0D;
      }
    }
    int i = 0;
    d3 = d1;
    for (d1 = d2; i < this.ubn.size(); d1 = d4)
    {
      dok localdok = (dok)this.ubn.get(i);
      d2 = d3;
      d4 = d1;
      if (localdok != null)
      {
        d2 = d3;
        d4 = d1;
        if (e.j(localdok.FWg.Ecg, localdok.FWg.Ecf))
        {
          double d5 = 2.0D * Math.abs(localdok.FWg.Ecg - this.tXX.FWg.Ecg);
          d4 = Math.abs(localdok.FWg.Ecf - this.tXX.FWg.Ecf) * 2.0D;
          d2 = d3;
          if (d5 > d3) {
            d2 = d5;
          }
          d3 = d1;
          if (d4 > d1) {
            d3 = d4;
          }
          ac.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localdok.Username, Double.valueOf(localdok.FWg.Ecg), Double.valueOf(localdok.FWg.Ecf) });
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
    ac.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.tWI + " " + localLocationInfo.tWJ);
    if (this.tXX != null)
    {
      ac.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.tXX.FWg.Ecg), Double.valueOf(this.tXX.FWg.Ecf) });
      this.tYV.zoomToSpan(this.tXX.FWg.Ecg, this.tXX.FWg.Ecf, d3, d1);
      AppMethodBeat.o(55974);
      return;
    }
    if (e.j(localLocationInfo.tWI, localLocationInfo.tWJ)) {
      this.tYV.zoomToSpan(localLocationInfo.tWI, localLocationInfo.tWJ, d3, d1);
    }
    AppMethodBeat.o(55974);
  }
  
  public final void a(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55975);
    if (this.tXX == null)
    {
      AppMethodBeat.o(55975);
      return;
    }
    if (paramd.getZoomLevel() < 15)
    {
      paramd.getIController().animateTo(this.tXX.FWg.Ecg, this.tXX.FWg.Ecf, 15);
      AppMethodBeat.o(55975);
      return;
    }
    paramd.getIController().animateTo(this.tXX.FWg.Ecg, this.tXX.FWg.Ecf);
    AppMethodBeat.o(55975);
  }
  
  final void cXD()
  {
    AppMethodBeat.i(55973);
    if (this.ubs)
    {
      AppMethodBeat.o(55973);
      return;
    }
    if (this.tXX == null)
    {
      AppMethodBeat.o(55973);
      return;
    }
    cXE();
    this.ubs = true;
    AppMethodBeat.o(55973);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55970);
    synchronized (ubo)
    {
      if (this.ubn != null) {
        this.ubn.clear();
      }
      this.tYV.clean();
      AppMethodBeat.o(55970);
      return;
    }
  }
  
  public final void eb(List<dok> paramList)
  {
    AppMethodBeat.i(55972);
    this.ubr = true;
    int j = this.ubn.size() + 1;
    int i;
    int k;
    synchronized (ubo)
    {
      this.ubn.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.ubn.add(paramList.get(i));
        i += 1;
      }
      k = this.ubn.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (ubo)
    {
      localObject3 = this.tYV.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.ubn.size())
      {
        paramList.add(((dok)this.ubn.get(i)).Username);
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
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.ubp == null) || (!this.ubp.equals(this.tYV.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.tYV.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).ufz);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).ufA);
        }
      }
      this.tYV.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.ubn.size())
      {
        localObject2 = (dok)this.ubn.get(i);
        paramList = this.tYV.getViewByItag(((dok)localObject2).Username);
        ac.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((dok)localObject2).Username, Double.valueOf(((dok)localObject2).FWg.Ecg), Double.valueOf(((dok)localObject2).FWg.Ecf), Double.valueOf(((dok)localObject2).FWg.Fur) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label875;
          }
          ((TrackPoint)paramList).n(((dok)localObject2).FWg.Ecg, ((dok)localObject2).FWg.Ecf);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((dok)localObject2).Username);
          paramList.x(((dok)localObject2).FWg.Fur);
          if (!this.ubu)
          {
            paramList.cYh();
            break label883;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.tYV.getViewManager());
            this.tYV.addView(paramList, ((dok)localObject2).FWg.Ecg, ((dok)localObject2).FWg.Ecf, ((dok)localObject2).Username);
            ((TrackPoint)paramList).o(((dok)localObject2).FWg.Ecg, ((dok)localObject2).FWg.Ecf);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.ubE);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.ubD);
            continue;
            if ((this.tYW) && (this.ubr))
            {
              if (!w.sQ(n.cWV().tYc)) {
                break label782;
              }
              cXD();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.tYV.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).cYh();
                }
              }
              label782:
              if (this.ubn.size() > 0) {
                cXD();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.tYV.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).cYi();
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
  
  public final void nB(boolean paramBoolean)
  {
    AppMethodBeat.i(55969);
    if (paramBoolean) {
      if (this.ubp == null) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        h.wUl.f(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.ubv = paramBoolean;
      }
      AppMethodBeat.o(55969);
      return;
    }
  }
  
  public final void nC(boolean paramBoolean)
  {
    AppMethodBeat.i(55971);
    if ((paramBoolean) && (!this.ubu) && (this.tYV != null))
    {
      Iterator localIterator = this.tYV.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).cYi();
        }
      }
    }
    this.ubu = paramBoolean;
    AppMethodBeat.o(55971);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(55977);
    com.tencent.mm.modelgeo.d.aEL().c(this.fnd);
    n.cWX().b(this.tYj);
    AppMethodBeat.o(55977);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(55976);
    com.tencent.mm.modelgeo.d.aEL().b(this.fnd, true);
    n.cWX().a(this.tYj);
    AppMethodBeat.o(55976);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */