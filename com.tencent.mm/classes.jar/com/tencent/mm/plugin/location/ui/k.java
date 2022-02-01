package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.q;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.q.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.eti;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class k
{
  private static Object EnR;
  public ezh EkD;
  private com.tencent.mm.plugin.location.model.k.a EkO;
  boolean ElA;
  public com.tencent.mm.plugin.q.d Elz;
  public List<ezh> EnQ;
  public TrackPoint EnS;
  TrackPointAnimAvatar EnT;
  boolean EnU;
  public boolean EnV;
  public boolean EnW;
  public boolean EnX;
  public boolean EnY;
  public boolean EnZ;
  public eti Eoa;
  public boolean Eob;
  public boolean Eoc;
  private boolean Eod;
  private long Eoe;
  private View.OnTouchListener Eof;
  View.OnClickListener Eog;
  View.OnClickListener Eoh;
  public a Eoi;
  protected float aCa;
  protected float aCb;
  private b.a iQJ;
  Context mContext;
  private boolean oZf;
  
  static
  {
    AppMethodBeat.i(55980);
    EnR = new Object();
    AppMethodBeat.o(55980);
  }
  
  public k(Context paramContext, com.tencent.mm.plugin.q.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(55968);
    this.EnU = false;
    this.EnV = false;
    this.EnW = true;
    this.EnX = false;
    this.EnY = false;
    this.EnZ = false;
    this.ElA = false;
    this.Eob = true;
    this.Eoc = true;
    this.Eod = false;
    this.aCa = 0.0F;
    this.aCb = 0.0F;
    this.oZf = false;
    this.Eoe = 0L;
    this.Eof = new View.OnTouchListener()
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
          if ((Math.abs(paramAnonymousMotionEvent.getX() - k.this.aCa) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - k.this.aCb) > 10.0F))
          {
            k.a(k.this, true);
            continue;
            k.this.aCa = paramAnonymousMotionEvent.getX();
            k.this.aCb = paramAnonymousMotionEvent.getY();
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
    this.Eog = new k.2(this);
    this.Eoh = new k.3(this);
    this.Eoi = null;
    this.iQJ = new b.a()
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
        if (localk.EkD == null)
        {
          localk.EkD = new ezh();
          localObject = new dmz();
          localk.EkD.UzK = ((dmz)localObject);
          localObject = z.bcZ();
          localk.EkD.Username = ((String)localObject);
          localk.EkD.UzK.RVz = paramAnonymousDouble1;
          localk.EkD.UzK.RVy = paramAnonymousDouble2;
          if ((localk.ElA) && (localk.EnU)) {
            localk.eMT();
          }
        }
        localk.EkD.UzK.RVz = paramAnonymousDouble1;
        localk.EkD.UzK.RVy = paramAnonymousDouble2;
        Object localObject = localk.Elz.getViewByItag(localk.EkD.Username);
        if (localObject != null)
        {
          localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
          Log.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
          if ((localObject instanceof TrackPoint))
          {
            localk.EnS = ((TrackPoint)localObject);
            Log.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            localk.EnS.l(paramAnonymousDouble1, paramAnonymousDouble2);
          }
          if (localk.Eob) {
            localk.Elz.getIController().setCenter(localk.EkD.UzK.RVz, localk.EkD.UzK.RVy);
          }
          AppMethodBeat.o(55966);
          return true;
        }
        localObject = new TrackPoint(localk.mContext, (ViewManager)localk.Elz.getViewManager(), a.d.location_track_point_icon_myself);
        localk.Elz.addView(localObject, 0.0D, 0.0D, localk.EkD.Username);
        ((TrackPoint)localObject).m(paramAnonymousDouble1, paramAnonymousDouble2);
        if (localk.EnZ)
        {
          ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
          ((TrackPoint)localObject).setOnLocationOnClickListener(null);
          ((TrackPoint)localObject).eNz();
        }
        for (;;)
        {
          ((TrackPoint)localObject).setAvatar(localk.EkD.Username);
          localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
          localk.EnT = new TrackPointAnimAvatar(localk.mContext);
          break;
          ((TrackPoint)localObject).setOnAvatarOnClickListener(localk.Eoh);
          ((TrackPoint)localObject).setOnLocationOnClickListener(localk.Eog);
        }
      }
    };
    this.EkO = new com.tencent.mm.plugin.location.model.k.a()
    {
      public final void x(double paramAnonymousDouble)
      {
        AppMethodBeat.i(55967);
        if (k.d(k.this) != null)
        {
          Log.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          k.d(k.this).y(paramAnonymousDouble);
        }
        AppMethodBeat.o(55967);
      }
    };
    this.mContext = paramContext;
    this.ElA = paramBoolean;
    this.Elz = paramd;
    this.EnQ = new ArrayList();
    paramd.setMapViewOnTouchListener(this.Eof);
    AppMethodBeat.o(55968);
  }
  
  private void eMU()
  {
    AppMethodBeat.i(55974);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (this.EkD == null)
    {
      AppMethodBeat.o(55974);
      return;
    }
    LocationInfo localLocationInfo = n.eMj().EkE;
    double d2 = d4;
    double d1 = d3;
    if (this.EkD != null)
    {
      d2 = d4;
      d1 = d3;
      if (e.i(localLocationInfo.Ejn, localLocationInfo.Ejo))
      {
        d1 = 2.0D * Math.abs(this.EkD.UzK.RVz - localLocationInfo.Ejn);
        d2 = Math.abs(this.EkD.UzK.RVy - localLocationInfo.Ejo) * 2.0D;
      }
    }
    int i = 0;
    d3 = d1;
    for (d1 = d2; i < this.EnQ.size(); d1 = d4)
    {
      ezh localezh = (ezh)this.EnQ.get(i);
      d2 = d3;
      d4 = d1;
      if (localezh != null)
      {
        d2 = d3;
        d4 = d1;
        if (e.i(localezh.UzK.RVz, localezh.UzK.RVy))
        {
          double d5 = 2.0D * Math.abs(localezh.UzK.RVz - this.EkD.UzK.RVz);
          d4 = Math.abs(localezh.UzK.RVy - this.EkD.UzK.RVy) * 2.0D;
          d2 = d3;
          if (d5 > d3) {
            d2 = d5;
          }
          d3 = d1;
          if (d4 > d1) {
            d3 = d4;
          }
          Log.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localezh.Username, Double.valueOf(localezh.UzK.RVz), Double.valueOf(localezh.UzK.RVy) });
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
    Log.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.Ejn + " " + localLocationInfo.Ejo);
    if (this.EkD != null)
    {
      Log.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.EkD.UzK.RVz), Double.valueOf(this.EkD.UzK.RVy) });
      this.Elz.zoomToSpan(this.EkD.UzK.RVz, this.EkD.UzK.RVy, d3, d1);
      AppMethodBeat.o(55974);
      return;
    }
    if (e.i(localLocationInfo.Ejn, localLocationInfo.Ejo)) {
      this.Elz.zoomToSpan(localLocationInfo.Ejn, localLocationInfo.Ejo, d3, d1);
    }
    AppMethodBeat.o(55974);
  }
  
  public final void a(com.tencent.mm.plugin.q.d paramd)
  {
    AppMethodBeat.i(55975);
    if (this.EkD == null)
    {
      AppMethodBeat.o(55975);
      return;
    }
    if (paramd.getZoomLevel() < 15)
    {
      paramd.getIController().animateTo(this.EkD.UzK.RVz, this.EkD.UzK.RVy, 15);
      AppMethodBeat.o(55975);
      return;
    }
    paramd.getIController().animateTo(this.EkD.UzK.RVz, this.EkD.UzK.RVy);
    AppMethodBeat.o(55975);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55970);
    synchronized (EnR)
    {
      if (this.EnQ != null) {
        this.EnQ.clear();
      }
      this.Elz.clean();
      AppMethodBeat.o(55970);
      return;
    }
  }
  
  final void eMT()
  {
    AppMethodBeat.i(55973);
    if (this.EnV)
    {
      AppMethodBeat.o(55973);
      return;
    }
    if (this.EkD == null)
    {
      AppMethodBeat.o(55973);
      return;
    }
    eMU();
    this.EnV = true;
    AppMethodBeat.o(55973);
  }
  
  public final void fO(List<ezh> paramList)
  {
    AppMethodBeat.i(55972);
    this.EnU = true;
    int j = this.EnQ.size() + 1;
    int i;
    int k;
    synchronized (EnR)
    {
      this.EnQ.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.EnQ.add(paramList.get(i));
        i += 1;
      }
      k = this.EnQ.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (EnR)
    {
      localObject3 = this.Elz.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.EnQ.size())
      {
        paramList.add(((ezh)this.EnQ.get(i)).Username);
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
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.EnS == null) || (!this.EnS.equals(this.Elz.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.Elz.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).Esb);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).Esc);
        }
      }
      this.Elz.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.EnQ.size())
      {
        localObject2 = (ezh)this.EnQ.get(i);
        paramList = this.Elz.getViewByItag(((ezh)localObject2).Username);
        Log.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((ezh)localObject2).Username, Double.valueOf(((ezh)localObject2).UzK.RVz), Double.valueOf(((ezh)localObject2).UzK.RVy), Double.valueOf(((ezh)localObject2).UzK.TUj) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label875;
          }
          ((TrackPoint)paramList).l(((ezh)localObject2).UzK.RVz, ((ezh)localObject2).UzK.RVy);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((ezh)localObject2).Username);
          paramList.y(((ezh)localObject2).UzK.TUj);
          if (!this.EnX)
          {
            paramList.eNz();
            break label883;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.Elz.getViewManager());
            this.Elz.addView(paramList, ((ezh)localObject2).UzK.RVz, ((ezh)localObject2).UzK.RVy, ((ezh)localObject2).Username);
            ((TrackPoint)paramList).m(((ezh)localObject2).UzK.RVz, ((ezh)localObject2).UzK.RVy);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.Eoh);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.Eog);
            continue;
            if ((this.ElA) && (this.EnU))
            {
              if (!ab.Lj(n.eMj().uJM)) {
                break label782;
              }
              eMT();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.Elz.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).eNz();
                }
              }
              label782:
              if (this.EnQ.size() > 0) {
                eMT();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.Elz.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).eNA();
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
  
  public final void onPause()
  {
    AppMethodBeat.i(55977);
    com.tencent.mm.modelgeo.d.blq().b(this.iQJ);
    n.eMl().b(this.EkO);
    AppMethodBeat.o(55977);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(55976);
    com.tencent.mm.modelgeo.d.blq().b(this.iQJ, true);
    n.eMl().a(this.EkO);
    AppMethodBeat.o(55976);
  }
  
  public final void tK(boolean paramBoolean)
  {
    AppMethodBeat.i(55969);
    if (paramBoolean)
    {
      if (this.EnS != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        h.IzE.a(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.EnY = paramBoolean;
        AppMethodBeat.o(55969);
        return;
      }
    }
    this.EnY = paramBoolean;
    AppMethodBeat.o(55969);
  }
  
  public final void tL(boolean paramBoolean)
  {
    AppMethodBeat.i(55971);
    if ((paramBoolean) && (!this.EnX) && (this.Elz != null))
    {
      Iterator localIterator = this.Elz.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).eNA();
        }
      }
    }
    this.EnX = paramBoolean;
    AppMethodBeat.o(55971);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */