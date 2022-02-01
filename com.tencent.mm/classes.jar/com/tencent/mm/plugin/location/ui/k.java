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
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.q;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.eox;
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
  private static Object yJY;
  protected float aTD;
  protected float aTE;
  private b.a gmA;
  Context mContext;
  private boolean mbo;
  public eox yGJ;
  private com.tencent.mm.plugin.location.model.k.a yGU;
  public com.tencent.mm.plugin.k.d yHG;
  boolean yHH;
  public List<eox> yJX;
  public TrackPoint yJZ;
  TrackPointAnimAvatar yKa;
  boolean yKb;
  public boolean yKc;
  public boolean yKd;
  public boolean yKe;
  public boolean yKf;
  public boolean yKg;
  public ejg yKh;
  public boolean yKi;
  public boolean yKj;
  private boolean yKk;
  private long yKl;
  private View.OnTouchListener yKm;
  View.OnClickListener yKn;
  View.OnClickListener yKo;
  public a yKp;
  
  static
  {
    AppMethodBeat.i(55980);
    yJY = new Object();
    AppMethodBeat.o(55980);
  }
  
  public k(Context paramContext, com.tencent.mm.plugin.k.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(55968);
    this.yKb = false;
    this.yKc = false;
    this.yKd = true;
    this.yKe = false;
    this.yKf = false;
    this.yKg = false;
    this.yHH = false;
    this.yKi = true;
    this.yKj = true;
    this.yKk = false;
    this.aTD = 0.0F;
    this.aTE = 0.0F;
    this.mbo = false;
    this.yKl = 0L;
    this.yKm = new View.OnTouchListener()
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
          if ((Math.abs(paramAnonymousMotionEvent.getX() - k.this.aTD) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - k.this.aTE) > 10.0F))
          {
            k.a(k.this, true);
            continue;
            k.this.aTD = paramAnonymousMotionEvent.getX();
            k.this.aTE = paramAnonymousMotionEvent.getY();
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
    this.yKn = new k.2(this);
    this.yKo = new k.3(this);
    this.yKp = null;
    this.gmA = new b.a()
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
        if (localk.yGJ == null)
        {
          localk.yGJ = new eox();
          localObject = new ddj();
          localk.yGJ.NmV = ((ddj)localObject);
          localObject = z.aTY();
          localk.yGJ.Username = ((String)localObject);
          localk.yGJ.NmV.KUu = paramAnonymousDouble1;
          localk.yGJ.NmV.KUt = paramAnonymousDouble2;
          if ((localk.yHH) && (localk.yKb)) {
            localk.edz();
          }
        }
        localk.yGJ.NmV.KUu = paramAnonymousDouble1;
        localk.yGJ.NmV.KUt = paramAnonymousDouble2;
        Object localObject = localk.yHG.getViewByItag(localk.yGJ.Username);
        if (localObject != null)
        {
          localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
          Log.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
          if ((localObject instanceof TrackPoint))
          {
            localk.yJZ = ((TrackPoint)localObject);
            Log.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            localk.yJZ.n(paramAnonymousDouble1, paramAnonymousDouble2);
          }
          if (localk.yKi) {
            localk.yHG.getIController().setCenter(localk.yGJ.NmV.KUu, localk.yGJ.NmV.KUt);
          }
          AppMethodBeat.o(55966);
          return true;
        }
        localObject = new TrackPoint(localk.mContext, (ViewManager)localk.yHG.getViewManager(), (byte)0);
        localk.yHG.addView(localObject, 0.0D, 0.0D, localk.yGJ.Username);
        ((TrackPoint)localObject).o(paramAnonymousDouble1, paramAnonymousDouble2);
        if (localk.yKg)
        {
          ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
          ((TrackPoint)localObject).setOnLocationOnClickListener(null);
          ((TrackPoint)localObject).eee();
        }
        for (;;)
        {
          ((TrackPoint)localObject).setAvatar(localk.yGJ.Username);
          localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
          localk.yKa = new TrackPointAnimAvatar(localk.mContext);
          break;
          ((TrackPoint)localObject).setOnAvatarOnClickListener(localk.yKo);
          ((TrackPoint)localObject).setOnLocationOnClickListener(localk.yKn);
        }
      }
    };
    this.yGU = new com.tencent.mm.plugin.location.model.k.a()
    {
      public final void w(double paramAnonymousDouble)
      {
        AppMethodBeat.i(55967);
        if (k.d(k.this) != null)
        {
          Log.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          k.d(k.this).x(paramAnonymousDouble);
        }
        AppMethodBeat.o(55967);
      }
    };
    this.mContext = paramContext;
    this.yHH = paramBoolean;
    this.yHG = paramd;
    this.yJX = new ArrayList();
    paramd.setMapViewOnTouchListener(this.yKm);
    AppMethodBeat.o(55968);
  }
  
  private void edA()
  {
    AppMethodBeat.i(55974);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (this.yGJ == null)
    {
      AppMethodBeat.o(55974);
      return;
    }
    LocationInfo localLocationInfo = n.ecR().yGK;
    double d2 = d4;
    double d1 = d3;
    if (this.yGJ != null)
    {
      d2 = d4;
      d1 = d3;
      if (e.j(localLocationInfo.yFu, localLocationInfo.yFv))
      {
        d1 = 2.0D * Math.abs(this.yGJ.NmV.KUu - localLocationInfo.yFu);
        d2 = Math.abs(this.yGJ.NmV.KUt - localLocationInfo.yFv) * 2.0D;
      }
    }
    int i = 0;
    d3 = d1;
    for (d1 = d2; i < this.yJX.size(); d1 = d4)
    {
      eox localeox = (eox)this.yJX.get(i);
      d2 = d3;
      d4 = d1;
      if (localeox != null)
      {
        d2 = d3;
        d4 = d1;
        if (e.j(localeox.NmV.KUu, localeox.NmV.KUt))
        {
          double d5 = 2.0D * Math.abs(localeox.NmV.KUu - this.yGJ.NmV.KUu);
          d4 = Math.abs(localeox.NmV.KUt - this.yGJ.NmV.KUt) * 2.0D;
          d2 = d3;
          if (d5 > d3) {
            d2 = d5;
          }
          d3 = d1;
          if (d4 > d1) {
            d3 = d4;
          }
          Log.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localeox.Username, Double.valueOf(localeox.NmV.KUu), Double.valueOf(localeox.NmV.KUt) });
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
    Log.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.yFu + " " + localLocationInfo.yFv);
    if (this.yGJ != null)
    {
      Log.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.yGJ.NmV.KUu), Double.valueOf(this.yGJ.NmV.KUt) });
      this.yHG.zoomToSpan(this.yGJ.NmV.KUu, this.yGJ.NmV.KUt, d3, d1);
      AppMethodBeat.o(55974);
      return;
    }
    if (e.j(localLocationInfo.yFu, localLocationInfo.yFv)) {
      this.yHG.zoomToSpan(localLocationInfo.yFu, localLocationInfo.yFv, d3, d1);
    }
    AppMethodBeat.o(55974);
  }
  
  public final void a(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(55975);
    if (this.yGJ == null)
    {
      AppMethodBeat.o(55975);
      return;
    }
    if (paramd.getZoomLevel() < 15)
    {
      paramd.getIController().animateTo(this.yGJ.NmV.KUu, this.yGJ.NmV.KUt, 15);
      AppMethodBeat.o(55975);
      return;
    }
    paramd.getIController().animateTo(this.yGJ.NmV.KUu, this.yGJ.NmV.KUt);
    AppMethodBeat.o(55975);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(55970);
    synchronized (yJY)
    {
      if (this.yJX != null) {
        this.yJX.clear();
      }
      this.yHG.clean();
      AppMethodBeat.o(55970);
      return;
    }
  }
  
  final void edz()
  {
    AppMethodBeat.i(55973);
    if (this.yKc)
    {
      AppMethodBeat.o(55973);
      return;
    }
    if (this.yGJ == null)
    {
      AppMethodBeat.o(55973);
      return;
    }
    edA();
    this.yKc = true;
    AppMethodBeat.o(55973);
  }
  
  public final void fm(List<eox> paramList)
  {
    AppMethodBeat.i(55972);
    this.yKb = true;
    int j = this.yJX.size() + 1;
    int i;
    int k;
    synchronized (yJY)
    {
      this.yJX.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.yJX.add(paramList.get(i));
        i += 1;
      }
      k = this.yJX.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (yJY)
    {
      localObject3 = this.yHG.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.yJX.size())
      {
        paramList.add(((eox)this.yJX.get(i)).Username);
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
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.yJZ == null) || (!this.yJZ.equals(this.yHG.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.yHG.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).yOd);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).yOe);
        }
      }
      this.yHG.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.yJX.size())
      {
        localObject2 = (eox)this.yJX.get(i);
        paramList = this.yHG.getViewByItag(((eox)localObject2).Username);
        Log.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((eox)localObject2).Username, Double.valueOf(((eox)localObject2).NmV.KUu), Double.valueOf(((eox)localObject2).NmV.KUt), Double.valueOf(((eox)localObject2).NmV.MIv) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label875;
          }
          ((TrackPoint)paramList).n(((eox)localObject2).NmV.KUu, ((eox)localObject2).NmV.KUt);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((eox)localObject2).Username);
          paramList.x(((eox)localObject2).NmV.MIv);
          if (!this.yKe)
          {
            paramList.eee();
            break label883;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.yHG.getViewManager());
            this.yHG.addView(paramList, ((eox)localObject2).NmV.KUu, ((eox)localObject2).NmV.KUt, ((eox)localObject2).Username);
            ((TrackPoint)paramList).o(((eox)localObject2).NmV.KUu, ((eox)localObject2).NmV.KUt);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.yKo);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.yKn);
            continue;
            if ((this.yHH) && (this.yKb))
            {
              if (!ab.Eq(n.ecR().rgD)) {
                break label782;
              }
              edz();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.yHG.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).eee();
                }
              }
              label782:
              if (this.yJX.size() > 0) {
                edz();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.yHG.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).eef();
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
    com.tencent.mm.modelgeo.d.bca().c(this.gmA);
    n.ecT().b(this.yGU);
    AppMethodBeat.o(55977);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(55976);
    com.tencent.mm.modelgeo.d.bca().b(this.gmA, true);
    n.ecT().a(this.yGU);
    AppMethodBeat.o(55976);
  }
  
  public final void qI(boolean paramBoolean)
  {
    AppMethodBeat.i(55969);
    if (paramBoolean) {
      if (this.yJZ == null) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        h.CyF.a(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.yKf = paramBoolean;
      }
      AppMethodBeat.o(55969);
      return;
    }
  }
  
  public final void qJ(boolean paramBoolean)
  {
    AppMethodBeat.i(55971);
    if ((paramBoolean) && (!this.yKe) && (this.yHG != null))
    {
      Iterator localIterator = this.yHG.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).eef();
        }
      }
    }
    this.yKe = paramBoolean;
    AppMethodBeat.o(55971);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */