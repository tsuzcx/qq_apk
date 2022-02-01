package com.tencent.mm.plugin.location.ui;

import android.content.Context;
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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.dub;
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
  private static Object vdX;
  protected float aTL;
  protected float aTM;
  private b.a fFl;
  private boolean kSw;
  Context mContext;
  public dub vaG;
  private com.tencent.mm.plugin.location.model.k.a vaS;
  public com.tencent.mm.plugin.k.d vbE;
  boolean vbF;
  public List<dub> vdW;
  public TrackPoint vdY;
  TrackPointAnimAvatar vdZ;
  boolean vea;
  public boolean veb;
  public boolean vec;
  public boolean ved;
  public boolean vee;
  public boolean vef;
  public don veg;
  public boolean veh;
  public boolean vei;
  private boolean vej;
  private long vek;
  private View.OnTouchListener vel;
  View.OnClickListener vem;
  View.OnClickListener ven;
  public a veo;
  
  static
  {
    AppMethodBeat.i(55980);
    vdX = new Object();
    AppMethodBeat.o(55980);
  }
  
  public k(Context paramContext, com.tencent.mm.plugin.k.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(55968);
    this.vea = false;
    this.veb = false;
    this.vec = true;
    this.ved = false;
    this.vee = false;
    this.vef = false;
    this.vbF = false;
    this.veh = true;
    this.vei = true;
    this.vej = false;
    this.aTL = 0.0F;
    this.aTM = 0.0F;
    this.kSw = false;
    this.vek = 0L;
    this.vel = new k.1(this);
    this.vem = new k.2(this);
    this.ven = new k.3(this);
    this.veo = null;
    this.fFl = new b.a()
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
        if (localk.vaG == null)
        {
          localk.vaG = new dub();
          localObject = new cle();
          localk.vaG.HGW = ((cle)localObject);
          localObject = u.aAm();
          localk.vaG.Username = ((String)localObject);
          localk.vaG.HGW.FIc = paramAnonymousDouble1;
          localk.vaG.HGW.FIb = paramAnonymousDouble2;
          if ((localk.vbF) && (localk.vea)) {
            localk.dgP();
          }
        }
        localk.vaG.HGW.FIc = paramAnonymousDouble1;
        localk.vaG.HGW.FIb = paramAnonymousDouble2;
        Object localObject = localk.vbE.getViewByItag(localk.vaG.Username);
        if (localObject != null)
        {
          localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
          ad.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
          if ((localObject instanceof TrackPoint))
          {
            localk.vdY = ((TrackPoint)localObject);
            ad.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            localk.vdY.n(paramAnonymousDouble1, paramAnonymousDouble2);
          }
          if (localk.veh) {
            localk.vbE.getIController().setCenter(localk.vaG.HGW.FIc, localk.vaG.HGW.FIb);
          }
          AppMethodBeat.o(55966);
          return true;
        }
        localObject = new TrackPoint(localk.mContext, (ViewManager)localk.vbE.getViewManager(), (byte)0);
        localk.vbE.addView(localObject, 0.0D, 0.0D, localk.vaG.Username);
        ((TrackPoint)localObject).o(paramAnonymousDouble1, paramAnonymousDouble2);
        if (localk.vef)
        {
          ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
          ((TrackPoint)localObject).setOnLocationOnClickListener(null);
          ((TrackPoint)localObject).dht();
        }
        for (;;)
        {
          ((TrackPoint)localObject).setAvatar(localk.vaG.Username);
          localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
          localk.vdZ = new TrackPointAnimAvatar(localk.mContext);
          break;
          ((TrackPoint)localObject).setOnAvatarOnClickListener(localk.ven);
          ((TrackPoint)localObject).setOnLocationOnClickListener(localk.vem);
        }
      }
    };
    this.vaS = new com.tencent.mm.plugin.location.model.k.a()
    {
      public final void w(double paramAnonymousDouble)
      {
        AppMethodBeat.i(55967);
        if (k.d(k.this) != null)
        {
          ad.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          k.d(k.this).x(paramAnonymousDouble);
        }
        AppMethodBeat.o(55967);
      }
    };
    this.mContext = paramContext;
    this.vbF = paramBoolean;
    this.vbE = paramd;
    this.vdW = new ArrayList();
    paramd.setMapViewOnTouchListener(this.vel);
    AppMethodBeat.o(55968);
  }
  
  private void dgQ()
  {
    AppMethodBeat.i(55974);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (this.vaG == null)
    {
      AppMethodBeat.o(55974);
      return;
    }
    LocationInfo localLocationInfo = n.dgh().vaH;
    double d2 = d4;
    double d1 = d3;
    if (this.vaG != null)
    {
      d2 = d4;
      d1 = d3;
      if (e.j(localLocationInfo.uZr, localLocationInfo.uZs))
      {
        d1 = 2.0D * Math.abs(this.vaG.HGW.FIc - localLocationInfo.uZr);
        d2 = Math.abs(this.vaG.HGW.FIb - localLocationInfo.uZs) * 2.0D;
      }
    }
    int i = 0;
    d3 = d1;
    for (d1 = d2; i < this.vdW.size(); d1 = d4)
    {
      dub localdub = (dub)this.vdW.get(i);
      d2 = d3;
      d4 = d1;
      if (localdub != null)
      {
        d2 = d3;
        d4 = d1;
        if (e.j(localdub.HGW.FIc, localdub.HGW.FIb))
        {
          double d5 = 2.0D * Math.abs(localdub.HGW.FIc - this.vaG.HGW.FIc);
          d4 = Math.abs(localdub.HGW.FIb - this.vaG.HGW.FIb) * 2.0D;
          d2 = d3;
          if (d5 > d3) {
            d2 = d5;
          }
          d3 = d1;
          if (d4 > d1) {
            d3 = d4;
          }
          ad.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localdub.Username, Double.valueOf(localdub.HGW.FIc), Double.valueOf(localdub.HGW.FIb) });
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
    ad.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.uZr + " " + localLocationInfo.uZs);
    if (this.vaG != null)
    {
      ad.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.vaG.HGW.FIc), Double.valueOf(this.vaG.HGW.FIb) });
      this.vbE.zoomToSpan(this.vaG.HGW.FIc, this.vaG.HGW.FIb, d3, d1);
      AppMethodBeat.o(55974);
      return;
    }
    if (e.j(localLocationInfo.uZr, localLocationInfo.uZs)) {
      this.vbE.zoomToSpan(localLocationInfo.uZr, localLocationInfo.uZs, d3, d1);
    }
    AppMethodBeat.o(55974);
  }
  
  public final void a(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55975);
    if (this.vaG == null)
    {
      AppMethodBeat.o(55975);
      return;
    }
    if (paramd.getZoomLevel() < 15)
    {
      paramd.getIController().animateTo(this.vaG.HGW.FIc, this.vaG.HGW.FIb, 15);
      AppMethodBeat.o(55975);
      return;
    }
    paramd.getIController().animateTo(this.vaG.HGW.FIc, this.vaG.HGW.FIb);
    AppMethodBeat.o(55975);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55970);
    synchronized (vdX)
    {
      if (this.vdW != null) {
        this.vdW.clear();
      }
      this.vbE.clean();
      AppMethodBeat.o(55970);
      return;
    }
  }
  
  final void dgP()
  {
    AppMethodBeat.i(55973);
    if (this.veb)
    {
      AppMethodBeat.o(55973);
      return;
    }
    if (this.vaG == null)
    {
      AppMethodBeat.o(55973);
      return;
    }
    dgQ();
    this.veb = true;
    AppMethodBeat.o(55973);
  }
  
  public final void eo(List<dub> paramList)
  {
    AppMethodBeat.i(55972);
    this.vea = true;
    int j = this.vdW.size() + 1;
    int i;
    int k;
    synchronized (vdX)
    {
      this.vdW.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.vdW.add(paramList.get(i));
        i += 1;
      }
      k = this.vdW.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (vdX)
    {
      localObject3 = this.vbE.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.vdW.size())
      {
        paramList.add(((dub)this.vdW.get(i)).Username);
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
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.vdY == null) || (!this.vdY.equals(this.vbE.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.vbE.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).vij);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).vik);
        }
      }
      this.vbE.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.vdW.size())
      {
        localObject2 = (dub)this.vdW.get(i);
        paramList = this.vbE.getViewByItag(((dub)localObject2).Username);
        ad.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((dub)localObject2).Username, Double.valueOf(((dub)localObject2).HGW.FIc), Double.valueOf(((dub)localObject2).HGW.FIb), Double.valueOf(((dub)localObject2).HGW.Hew) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label875;
          }
          ((TrackPoint)paramList).n(((dub)localObject2).HGW.FIc, ((dub)localObject2).HGW.FIb);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((dub)localObject2).Username);
          paramList.x(((dub)localObject2).HGW.Hew);
          if (!this.ved)
          {
            paramList.dht();
            break label883;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.vbE.getViewManager());
            this.vbE.addView(paramList, ((dub)localObject2).HGW.FIc, ((dub)localObject2).HGW.FIb, ((dub)localObject2).Username);
            ((TrackPoint)paramList).o(((dub)localObject2).HGW.FIc, ((dub)localObject2).HGW.FIb);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.ven);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.vem);
            continue;
            if ((this.vbF) && (this.vea))
            {
              if (!w.vF(n.dgh().vaL)) {
                break label782;
              }
              dgP();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.vbE.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).dht();
                }
              }
              label782:
              if (this.vdW.size() > 0) {
                dgP();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.vbE.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).dhu();
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
  
  public final void nV(boolean paramBoolean)
  {
    AppMethodBeat.i(55969);
    if (paramBoolean) {
      if (this.vdY == null) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        g.yhR.f(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.vee = paramBoolean;
      }
      AppMethodBeat.o(55969);
      return;
    }
  }
  
  public final void nW(boolean paramBoolean)
  {
    AppMethodBeat.i(55971);
    if ((paramBoolean) && (!this.ved) && (this.vbE != null))
    {
      Iterator localIterator = this.vbE.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).dhu();
        }
      }
    }
    this.ved = paramBoolean;
    AppMethodBeat.o(55971);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(55977);
    com.tencent.mm.modelgeo.d.aHQ().c(this.fFl);
    n.dgj().b(this.vaS);
    AppMethodBeat.o(55977);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(55976);
    com.tencent.mm.modelgeo.d.aHQ().b(this.fFl, true);
    n.dgj().a(this.vaS);
    AppMethodBeat.o(55976);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */