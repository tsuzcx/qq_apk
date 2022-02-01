package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.fot;
import com.tencent.mm.protocal.protobuf.fvj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class k
{
  private static Object oab;
  public boolean Fr;
  public fvj Kdm;
  private com.tencent.mm.plugin.location.model.k.a Kdx;
  public com.tencent.mm.plugin.p.d Kei;
  boolean Kej;
  TrackPointAnimAvatar KgA;
  boolean KgB;
  public boolean KgC;
  public boolean KgD;
  public boolean KgE;
  public boolean KgF;
  public fot KgG;
  public boolean KgH;
  public boolean KgI;
  private boolean KgJ;
  private long KgK;
  private View.OnTouchListener KgL;
  View.OnClickListener KgM;
  View.OnClickListener KgN;
  public a KgO;
  public List<fvj> Kgy;
  public TrackPoint Kgz;
  protected float cxM;
  protected float cxN;
  private b.a lsF;
  Context mContext;
  private boolean seH;
  
  static
  {
    AppMethodBeat.i(55980);
    oab = new Object();
    AppMethodBeat.o(55980);
  }
  
  public k(Context paramContext, com.tencent.mm.plugin.p.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(55968);
    this.KgB = false;
    this.KgC = false;
    this.KgD = true;
    this.Fr = false;
    this.KgE = false;
    this.KgF = false;
    this.Kej = false;
    this.KgH = true;
    this.KgI = true;
    this.KgJ = false;
    this.cxM = 0.0F;
    this.cxN = 0.0F;
    this.seH = false;
    this.KgK = 0L;
    this.KgL = new View.OnTouchListener()
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
          if ((Math.abs(paramAnonymousMotionEvent.getX() - k.this.cxM) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - k.this.cxN) > 10.0F))
          {
            k.a(k.this, true);
            continue;
            k.this.cxM = paramAnonymousMotionEvent.getX();
            k.this.cxN = paramAnonymousMotionEvent.getY();
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
    this.KgM = new k.2(this);
    this.KgN = new k.3(this);
    this.KgO = null;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264965);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264965);
          return false;
        }
        k localk = k.this;
        paramAnonymousDouble1 = paramAnonymousFloat2;
        paramAnonymousDouble2 = paramAnonymousFloat1;
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("[refreshMyLocation] ");
        localStringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[] { Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) }));
        if (localk.Kdm == null)
        {
          localk.Kdm = new fvj();
          localObject = new efn();
          localk.Kdm.abTG = ((efn)localObject);
          localObject = z.bAM();
          localk.Kdm.Username = ((String)localObject);
          localk.Kdm.abTG.YTd = paramAnonymousDouble1;
          localk.Kdm.abTG.YTc = paramAnonymousDouble2;
          if ((localk.Kej) && (localk.KgB)) {
            localk.fVm();
          }
        }
        localk.Kdm.abTG.YTd = paramAnonymousDouble1;
        localk.Kdm.abTG.YTc = paramAnonymousDouble2;
        Object localObject = localk.Kei.getViewByItag(localk.Kdm.Username);
        if (localObject != null)
        {
          localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
          Log.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
          if ((localObject instanceof TrackPoint))
          {
            localk.Kgz = ((TrackPoint)localObject);
            Log.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            localk.Kgz.p(paramAnonymousDouble1, paramAnonymousDouble2);
          }
          if (localk.KgH) {
            localk.Kei.getIController().setCenter(localk.Kdm.abTG.YTd, localk.Kdm.abTG.YTc);
          }
          AppMethodBeat.o(264965);
          return true;
        }
        localObject = new TrackPoint(localk.mContext, (ViewManager)localk.Kei.getViewManager(), a.d.location_track_point_icon_myself);
        localk.Kei.addView(localObject, 0.0D, 0.0D, localk.Kdm.Username);
        ((TrackPoint)localObject).q(paramAnonymousDouble1, paramAnonymousDouble2);
        if (localk.KgF)
        {
          ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
          ((TrackPoint)localObject).setOnLocationOnClickListener(null);
          ((TrackPoint)localObject).fVS();
        }
        for (;;)
        {
          ((TrackPoint)localObject).setAvatar(localk.Kdm.Username);
          localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
          localk.KgA = new TrackPointAnimAvatar(localk.mContext);
          break;
          ((TrackPoint)localObject).setOnAvatarOnClickListener(localk.KgN);
          ((TrackPoint)localObject).setOnLocationOnClickListener(localk.KgM);
        }
      }
    };
    this.Kdx = new com.tencent.mm.plugin.location.model.k.a()
    {
      public final void Q(double paramAnonymousDouble)
      {
        AppMethodBeat.i(55967);
        if (k.d(k.this) != null)
        {
          Log.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          k.d(k.this).R(paramAnonymousDouble);
        }
        AppMethodBeat.o(55967);
      }
    };
    this.mContext = paramContext;
    this.Kej = paramBoolean;
    this.Kei = paramd;
    this.Kgy = new ArrayList();
    paramd.setMapViewOnTouchListener(this.KgL);
    AppMethodBeat.o(55968);
  }
  
  private void fVn()
  {
    AppMethodBeat.i(55974);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (this.Kdm == null)
    {
      AppMethodBeat.o(55974);
      return;
    }
    LocationInfo localLocationInfo = SubCoreLocation.fUB().Kdn;
    double d2 = d4;
    double d1 = d3;
    if (this.Kdm != null)
    {
      d2 = d4;
      d1 = d3;
      if (e.m(localLocationInfo.KbW, localLocationInfo.KbX))
      {
        d1 = 2.0D * Math.abs(this.Kdm.abTG.YTd - localLocationInfo.KbW);
        d2 = Math.abs(this.Kdm.abTG.YTc - localLocationInfo.KbX) * 2.0D;
      }
    }
    int i = 0;
    d3 = d1;
    for (d1 = d2; i < this.Kgy.size(); d1 = d4)
    {
      fvj localfvj = (fvj)this.Kgy.get(i);
      d2 = d3;
      d4 = d1;
      if (localfvj != null)
      {
        d2 = d3;
        d4 = d1;
        if (e.m(localfvj.abTG.YTd, localfvj.abTG.YTc))
        {
          double d5 = 2.0D * Math.abs(localfvj.abTG.YTd - this.Kdm.abTG.YTd);
          d4 = Math.abs(localfvj.abTG.YTc - this.Kdm.abTG.YTc) * 2.0D;
          d2 = d3;
          if (d5 > d3) {
            d2 = d5;
          }
          d3 = d1;
          if (d4 > d1) {
            d3 = d4;
          }
          Log.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localfvj.Username, Double.valueOf(localfvj.abTG.YTd), Double.valueOf(localfvj.abTG.YTc) });
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
    Log.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.KbW + " " + localLocationInfo.KbX);
    if (this.Kdm != null)
    {
      Log.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.Kdm.abTG.YTd), Double.valueOf(this.Kdm.abTG.YTc) });
      this.Kei.zoomToSpan(this.Kdm.abTG.YTd, this.Kdm.abTG.YTc, d3, d1);
      AppMethodBeat.o(55974);
      return;
    }
    if (e.m(localLocationInfo.KbW, localLocationInfo.KbX)) {
      this.Kei.zoomToSpan(localLocationInfo.KbW, localLocationInfo.KbX, d3, d1);
    }
    AppMethodBeat.o(55974);
  }
  
  public final void a(com.tencent.mm.plugin.p.d paramd)
  {
    AppMethodBeat.i(55975);
    if (this.Kdm == null)
    {
      AppMethodBeat.o(55975);
      return;
    }
    if (paramd.getZoomLevel() < 15)
    {
      paramd.getIController().animateTo(this.Kdm.abTG.YTd, this.Kdm.abTG.YTc, 15);
      AppMethodBeat.o(55975);
      return;
    }
    paramd.getIController().animateTo(this.Kdm.abTG.YTd, this.Kdm.abTG.YTc);
    AppMethodBeat.o(55975);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55970);
    synchronized (oab)
    {
      if (this.Kgy != null) {
        this.Kgy.clear();
      }
      this.Kei.clean();
      AppMethodBeat.o(55970);
      return;
    }
  }
  
  final void fVm()
  {
    AppMethodBeat.i(55973);
    if (this.KgC)
    {
      AppMethodBeat.o(55973);
      return;
    }
    if (this.Kdm == null)
    {
      AppMethodBeat.o(55973);
      return;
    }
    fVn();
    this.KgC = true;
    AppMethodBeat.o(55973);
  }
  
  public final void iM(List<fvj> paramList)
  {
    AppMethodBeat.i(55972);
    this.KgB = true;
    int j = this.Kgy.size() + 1;
    int i;
    int k;
    synchronized (oab)
    {
      this.Kgy.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.Kgy.add((fvj)paramList.get(i));
        i += 1;
      }
      k = this.Kgy.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (oab)
    {
      localObject3 = this.Kei.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.Kgy.size())
      {
        paramList.add(((fvj)this.Kgy.get(i)).Username);
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
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.Kgz == null) || (!this.Kgz.equals(this.Kei.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.Kei.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).KkH);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).KkI);
        }
      }
      this.Kei.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.Kgy.size())
      {
        localObject2 = (fvj)this.Kgy.get(i);
        paramList = this.Kei.getViewByItag(((fvj)localObject2).Username);
        Log.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((fvj)localObject2).Username, Double.valueOf(((fvj)localObject2).abTG.YTd), Double.valueOf(((fvj)localObject2).abTG.YTc), Double.valueOf(((fvj)localObject2).abTG.abkT) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label878;
          }
          ((TrackPoint)paramList).p(((fvj)localObject2).abTG.YTd, ((fvj)localObject2).abTG.YTc);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((fvj)localObject2).Username);
          paramList.R(((fvj)localObject2).abTG.abkT);
          if (!this.Fr)
          {
            paramList.fVS();
            break label886;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.Kei.getViewManager());
            this.Kei.addView(paramList, ((fvj)localObject2).abTG.YTd, ((fvj)localObject2).abTG.YTc, ((fvj)localObject2).Username);
            ((TrackPoint)paramList).q(((fvj)localObject2).abTG.YTd, ((fvj)localObject2).abTG.YTc);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.KgN);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.KgM);
            continue;
            if ((this.Kej) && (this.KgB))
            {
              if (!au.bwE(SubCoreLocation.fUB().mpr)) {
                break label785;
              }
              fVm();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.Kei.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).fVS();
                }
              }
              label785:
              if (this.Kgy.size() > 0) {
                fVm();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.Kei.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).fVT();
                }
              }
            }
            AppMethodBeat.o(55972);
            return;
            label878:
            continue;
            i = 0;
            break;
          }
        }
      }
      label886:
      i += 1;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(55977);
    com.tencent.mm.modelgeo.d.bJl().a(this.lsF);
    SubCoreLocation.fUD().b(this.Kdx);
    AppMethodBeat.o(55977);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(55976);
    com.tencent.mm.modelgeo.d.bJl().a(this.lsF, true);
    SubCoreLocation.fUD().a(this.Kdx);
    AppMethodBeat.o(55976);
  }
  
  public final void xW(boolean paramBoolean)
  {
    AppMethodBeat.i(55969);
    if (paramBoolean)
    {
      if (this.Kgz != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        h.OAn.b(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.KgE = paramBoolean;
        AppMethodBeat.o(55969);
        return;
      }
    }
    this.KgE = paramBoolean;
    AppMethodBeat.o(55969);
  }
  
  public final void xX(boolean paramBoolean)
  {
    AppMethodBeat.i(55971);
    if ((paramBoolean) && (!this.Fr) && (this.Kei != null))
    {
      Iterator localIterator = this.Kei.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).fVT();
        }
      }
    }
    this.Fr = paramBoolean;
    AppMethodBeat.o(55971);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */