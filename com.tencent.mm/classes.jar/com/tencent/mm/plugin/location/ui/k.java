package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
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
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class k
{
  private static Object vqi;
  protected float aTL;
  protected float aTM;
  private b.a fHp;
  private boolean kWf;
  Context mContext;
  public duy vmR;
  public com.tencent.mm.plugin.k.d vnP;
  boolean vnQ;
  private com.tencent.mm.plugin.location.model.k.a vnd;
  public List<duy> vqh;
  public TrackPoint vqj;
  TrackPointAnimAvatar vqk;
  boolean vql;
  public boolean vqm;
  public boolean vqn;
  public boolean vqo;
  public boolean vqp;
  public boolean vqq;
  public dpk vqr;
  public boolean vqs;
  public boolean vqt;
  private boolean vqu;
  private long vqv;
  private View.OnTouchListener vqw;
  View.OnClickListener vqx;
  View.OnClickListener vqy;
  public a vqz;
  
  static
  {
    AppMethodBeat.i(55980);
    vqi = new Object();
    AppMethodBeat.o(55980);
  }
  
  public k(Context paramContext, com.tencent.mm.plugin.k.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(55968);
    this.vql = false;
    this.vqm = false;
    this.vqn = true;
    this.vqo = false;
    this.vqp = false;
    this.vqq = false;
    this.vnQ = false;
    this.vqs = true;
    this.vqt = true;
    this.vqu = false;
    this.aTL = 0.0F;
    this.aTM = 0.0F;
    this.kWf = false;
    this.vqv = 0L;
    this.vqw = new k.1(this);
    this.vqx = new k.2(this);
    this.vqy = new k.3(this);
    this.vqz = null;
    this.fHp = new b.a()
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
        if (localk.vmR == null)
        {
          localk.vmR = new duy();
          localObject = new cly();
          localk.vmR.IaJ = ((cly)localObject);
          localObject = v.aAC();
          localk.vmR.Username = ((String)localObject);
          localk.vmR.IaJ.Gay = paramAnonymousDouble1;
          localk.vmR.IaJ.Gax = paramAnonymousDouble2;
          if ((localk.vnQ) && (localk.vql)) {
            localk.djO();
          }
        }
        localk.vmR.IaJ.Gay = paramAnonymousDouble1;
        localk.vmR.IaJ.Gax = paramAnonymousDouble2;
        Object localObject = localk.vnP.getViewByItag(localk.vmR.Username);
        if (localObject != null)
        {
          localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
          ae.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
          if ((localObject instanceof TrackPoint))
          {
            localk.vqj = ((TrackPoint)localObject);
            ae.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            localk.vqj.n(paramAnonymousDouble1, paramAnonymousDouble2);
          }
          if (localk.vqs) {
            localk.vnP.getIController().setCenter(localk.vmR.IaJ.Gay, localk.vmR.IaJ.Gax);
          }
          AppMethodBeat.o(55966);
          return true;
        }
        localObject = new TrackPoint(localk.mContext, (ViewManager)localk.vnP.getViewManager(), (byte)0);
        localk.vnP.addView(localObject, 0.0D, 0.0D, localk.vmR.Username);
        ((TrackPoint)localObject).o(paramAnonymousDouble1, paramAnonymousDouble2);
        if (localk.vqq)
        {
          ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
          ((TrackPoint)localObject).setOnLocationOnClickListener(null);
          ((TrackPoint)localObject).dks();
        }
        for (;;)
        {
          ((TrackPoint)localObject).setAvatar(localk.vmR.Username);
          localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
          localk.vqk = new TrackPointAnimAvatar(localk.mContext);
          break;
          ((TrackPoint)localObject).setOnAvatarOnClickListener(localk.vqy);
          ((TrackPoint)localObject).setOnLocationOnClickListener(localk.vqx);
        }
      }
    };
    this.vnd = new com.tencent.mm.plugin.location.model.k.a()
    {
      public final void w(double paramAnonymousDouble)
      {
        AppMethodBeat.i(55967);
        if (k.d(k.this) != null)
        {
          ae.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          k.d(k.this).x(paramAnonymousDouble);
        }
        AppMethodBeat.o(55967);
      }
    };
    this.mContext = paramContext;
    this.vnQ = paramBoolean;
    this.vnP = paramd;
    this.vqh = new ArrayList();
    paramd.setMapViewOnTouchListener(this.vqw);
    AppMethodBeat.o(55968);
  }
  
  private void djP()
  {
    AppMethodBeat.i(55974);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (this.vmR == null)
    {
      AppMethodBeat.o(55974);
      return;
    }
    LocationInfo localLocationInfo = n.djg().vmS;
    double d2 = d4;
    double d1 = d3;
    if (this.vmR != null)
    {
      d2 = d4;
      d1 = d3;
      if (e.j(localLocationInfo.vlC, localLocationInfo.vlD))
      {
        d1 = 2.0D * Math.abs(this.vmR.IaJ.Gay - localLocationInfo.vlC);
        d2 = Math.abs(this.vmR.IaJ.Gax - localLocationInfo.vlD) * 2.0D;
      }
    }
    int i = 0;
    d3 = d1;
    for (d1 = d2; i < this.vqh.size(); d1 = d4)
    {
      duy localduy = (duy)this.vqh.get(i);
      d2 = d3;
      d4 = d1;
      if (localduy != null)
      {
        d2 = d3;
        d4 = d1;
        if (e.j(localduy.IaJ.Gay, localduy.IaJ.Gax))
        {
          double d5 = 2.0D * Math.abs(localduy.IaJ.Gay - this.vmR.IaJ.Gay);
          d4 = Math.abs(localduy.IaJ.Gax - this.vmR.IaJ.Gax) * 2.0D;
          d2 = d3;
          if (d5 > d3) {
            d2 = d5;
          }
          d3 = d1;
          if (d4 > d1) {
            d3 = d4;
          }
          ae.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localduy.Username, Double.valueOf(localduy.IaJ.Gay), Double.valueOf(localduy.IaJ.Gax) });
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
    ae.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.vlC + " " + localLocationInfo.vlD);
    if (this.vmR != null)
    {
      ae.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.vmR.IaJ.Gay), Double.valueOf(this.vmR.IaJ.Gax) });
      this.vnP.zoomToSpan(this.vmR.IaJ.Gay, this.vmR.IaJ.Gax, d3, d1);
      AppMethodBeat.o(55974);
      return;
    }
    if (e.j(localLocationInfo.vlC, localLocationInfo.vlD)) {
      this.vnP.zoomToSpan(localLocationInfo.vlC, localLocationInfo.vlD, d3, d1);
    }
    AppMethodBeat.o(55974);
  }
  
  public final void a(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55975);
    if (this.vmR == null)
    {
      AppMethodBeat.o(55975);
      return;
    }
    if (paramd.getZoomLevel() < 15)
    {
      paramd.getIController().animateTo(this.vmR.IaJ.Gay, this.vmR.IaJ.Gax, 15);
      AppMethodBeat.o(55975);
      return;
    }
    paramd.getIController().animateTo(this.vmR.IaJ.Gay, this.vmR.IaJ.Gax);
    AppMethodBeat.o(55975);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55970);
    synchronized (vqi)
    {
      if (this.vqh != null) {
        this.vqh.clear();
      }
      this.vnP.clean();
      AppMethodBeat.o(55970);
      return;
    }
  }
  
  final void djO()
  {
    AppMethodBeat.i(55973);
    if (this.vqm)
    {
      AppMethodBeat.o(55973);
      return;
    }
    if (this.vmR == null)
    {
      AppMethodBeat.o(55973);
      return;
    }
    djP();
    this.vqm = true;
    AppMethodBeat.o(55973);
  }
  
  public final void es(List<duy> paramList)
  {
    AppMethodBeat.i(55972);
    this.vql = true;
    int j = this.vqh.size() + 1;
    int i;
    int k;
    synchronized (vqi)
    {
      this.vqh.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.vqh.add(paramList.get(i));
        i += 1;
      }
      k = this.vqh.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (vqi)
    {
      localObject3 = this.vnP.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.vqh.size())
      {
        paramList.add(((duy)this.vqh.get(i)).Username);
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
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.vqj == null) || (!this.vqj.equals(this.vnP.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.vnP.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).vuo);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).vup);
        }
      }
      this.vnP.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.vqh.size())
      {
        localObject2 = (duy)this.vqh.get(i);
        paramList = this.vnP.getViewByItag(((duy)localObject2).Username);
        ae.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((duy)localObject2).Username, Double.valueOf(((duy)localObject2).IaJ.Gay), Double.valueOf(((duy)localObject2).IaJ.Gax), Double.valueOf(((duy)localObject2).IaJ.HxW) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label875;
          }
          ((TrackPoint)paramList).n(((duy)localObject2).IaJ.Gay, ((duy)localObject2).IaJ.Gax);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((duy)localObject2).Username);
          paramList.x(((duy)localObject2).IaJ.HxW);
          if (!this.vqo)
          {
            paramList.dks();
            break label883;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.vnP.getViewManager());
            this.vnP.addView(paramList, ((duy)localObject2).IaJ.Gay, ((duy)localObject2).IaJ.Gax, ((duy)localObject2).Username);
            ((TrackPoint)paramList).o(((duy)localObject2).IaJ.Gay, ((duy)localObject2).IaJ.Gax);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.vqy);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.vqx);
            continue;
            if ((this.vnQ) && (this.vql))
            {
              if (!x.wb(n.djg().vmW)) {
                break label782;
              }
              djO();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.vnP.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).dks();
                }
              }
              label782:
              if (this.vqh.size() > 0) {
                djO();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.vnP.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).dkt();
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
  
  public final void oa(boolean paramBoolean)
  {
    AppMethodBeat.i(55969);
    if (paramBoolean) {
      if (this.vqj == null) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        g.yxI.f(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.vqp = paramBoolean;
      }
      AppMethodBeat.o(55969);
      return;
    }
  }
  
  public final void ob(boolean paramBoolean)
  {
    AppMethodBeat.i(55971);
    if ((paramBoolean) && (!this.vqo) && (this.vnP != null))
    {
      Iterator localIterator = this.vnP.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).dkt();
        }
      }
    }
    this.vqo = paramBoolean;
    AppMethodBeat.o(55971);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(55977);
    com.tencent.mm.modelgeo.d.aIh().c(this.fHp);
    n.dji().b(this.vnd);
    AppMethodBeat.o(55977);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(55976);
    com.tencent.mm.modelgeo.d.aIh().b(this.fHp, true);
    n.dji().a(this.vnd);
    AppMethodBeat.o(55976);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */