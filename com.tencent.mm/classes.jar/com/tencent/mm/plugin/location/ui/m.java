package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.i;
import com.tencent.mm.plugin.location.model.i.a;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class m
{
  private static Object oep;
  private b.a dZA;
  private boolean hPP;
  Context mContext;
  protected float nvl;
  protected float nvm;
  public cpm obk;
  private i.a obw;
  com.tencent.mm.plugin.k.d oci;
  boolean ocj;
  public boolean oeA;
  private boolean oeB;
  private long oeC;
  private View.OnTouchListener oeD;
  View.OnClickListener oeE;
  View.OnClickListener oeF;
  public m.a oeG;
  public List<cpm> oeo;
  public TrackPoint oeq;
  TrackPointAnimAvatar oer;
  boolean oes;
  public boolean oet;
  public boolean oeu;
  public boolean oev;
  public boolean oew;
  public boolean oex;
  public clf oey;
  public boolean oez;
  
  static
  {
    AppMethodBeat.i(113576);
    oep = new Object();
    AppMethodBeat.o(113576);
  }
  
  public m(Context paramContext, com.tencent.mm.plugin.k.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(113564);
    this.oes = false;
    this.oet = false;
    this.oeu = true;
    this.oev = false;
    this.oew = false;
    this.oex = false;
    this.ocj = false;
    this.oez = true;
    this.oeA = true;
    this.oeB = false;
    this.nvl = 0.0F;
    this.nvm = 0.0F;
    this.hPP = false;
    this.oeC = 0L;
    this.oeD = new m.1(this);
    this.oeE = new m.2(this);
    this.oeF = new m.3(this);
    this.oeG = null;
    this.dZA = new m.4(this);
    this.obw = new m.5(this);
    this.mContext = paramContext;
    this.ocj = paramBoolean;
    this.oci = paramd;
    this.oeo = new ArrayList();
    paramd.setMapViewOnTouchListener(this.oeD);
    AppMethodBeat.o(113564);
  }
  
  private void bLY()
  {
    AppMethodBeat.i(113570);
    double d3 = 0.0D;
    double d4 = 0.0D;
    if (this.obk == null)
    {
      AppMethodBeat.o(113570);
      return;
    }
    LocationInfo localLocationInfo = l.bLr().obl;
    double d2 = d4;
    double d1 = d3;
    if (this.obk != null)
    {
      d2 = d4;
      d1 = d3;
      if (e.j(localLocationInfo.nZV, localLocationInfo.nZW))
      {
        d1 = 2.0D * Math.abs(this.obk.xYw.wyP - localLocationInfo.nZV);
        d2 = Math.abs(this.obk.xYw.wyO - localLocationInfo.nZW) * 2.0D;
      }
    }
    int i = 0;
    d3 = d1;
    for (d1 = d2; i < this.oeo.size(); d1 = d4)
    {
      cpm localcpm = (cpm)this.oeo.get(i);
      d2 = d3;
      d4 = d1;
      if (localcpm != null)
      {
        d2 = d3;
        d4 = d1;
        if (e.j(localcpm.xYw.wyP, localcpm.xYw.wyO))
        {
          double d5 = 2.0D * Math.abs(localcpm.xYw.wyP - this.obk.xYw.wyP);
          d4 = Math.abs(localcpm.xYw.wyO - this.obk.xYw.wyO) * 2.0D;
          d2 = d3;
          if (d5 > d3) {
            d2 = d5;
          }
          d3 = d1;
          if (d4 > d1) {
            d3 = d4;
          }
          ab.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[] { localcpm.Username, Double.valueOf(localcpm.xYw.wyP), Double.valueOf(localcpm.xYw.wyO) });
          d4 = d3;
        }
      }
      i += 1;
      d3 = d2;
    }
    if ((Math.abs(d3 + 1000.0D) < 0.5D) || (Math.abs(d1 + 1000.0D) < 0.5D))
    {
      AppMethodBeat.o(113570);
      return;
    }
    ab.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + 1000000.0D * d3 + " maxlng " + 1000000.0D * d1 + " poi " + localLocationInfo.nZV + " " + localLocationInfo.nZW);
    if (this.obk != null)
    {
      ab.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[] { Double.valueOf(this.obk.xYw.wyP), Double.valueOf(this.obk.xYw.wyO) });
      this.oci.zoomToSpan(this.obk.xYw.wyP, this.obk.xYw.wyO, d3, d1);
      AppMethodBeat.o(113570);
      return;
    }
    if (e.j(localLocationInfo.nZV, localLocationInfo.nZW)) {
      this.oci.zoomToSpan(localLocationInfo.nZV, localLocationInfo.nZW, d3, d1);
    }
    AppMethodBeat.o(113570);
  }
  
  public final void a(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(113571);
    if (this.obk == null)
    {
      AppMethodBeat.o(113571);
      return;
    }
    if (paramd.getZoomLevel() < 16)
    {
      paramd.getIController().animateTo(this.obk.xYw.wyP, this.obk.xYw.wyO, 16);
      AppMethodBeat.o(113571);
      return;
    }
    paramd.getIController().animateTo(this.obk.xYw.wyP, this.obk.xYw.wyO);
    AppMethodBeat.o(113571);
  }
  
  final void bLX()
  {
    AppMethodBeat.i(113569);
    if (this.oet)
    {
      AppMethodBeat.o(113569);
      return;
    }
    if (this.obk == null)
    {
      AppMethodBeat.o(113569);
      return;
    }
    bLY();
    this.oet = true;
    AppMethodBeat.o(113569);
  }
  
  public final void cg(List<cpm> paramList)
  {
    AppMethodBeat.i(113568);
    this.oes = true;
    int j = this.oeo.size() + 1;
    int i;
    int k;
    synchronized (oep)
    {
      this.oeo.clear();
      i = 0;
      while (i < paramList.size())
      {
        this.oeo.add(paramList.get(i));
        i += 1;
      }
      k = this.oeo.size() + 1;
    }
    Object localObject3;
    Object localObject2;
    synchronized (oep)
    {
      localObject3 = this.oci.getTags();
      paramList = new HashSet();
      i = 0;
      while (i < this.oeo.size())
      {
        paramList.add(((cpm)this.oeo.get(i)).Username);
        i += 1;
        continue;
        paramList = finally;
        AppMethodBeat.o(113568);
        throw paramList;
      }
      localObject2 = new LinkedList();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if ((!paramList.contains(str)) && (!str.endsWith("myAnim")) && ((this.oeq == null) || (!this.oeq.equals(this.oci.getViewByItag(str))))) {
          ((List)localObject2).add(str);
        }
      }
    }
    paramList = ((List)localObject2).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      localObject3 = this.oci.getViewByItag((String)localObject2);
      if ((localObject3 instanceof TrackPoint))
      {
        localObject3 = (TrackPoint)localObject3;
        if (((TrackPoint)localObject3).mViewManager != null)
        {
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).ohK);
          ((TrackPoint)localObject3).mViewManager.removeView(((TrackPoint)localObject3).ohL);
        }
      }
      this.oci.removeViewByTag((String)localObject2);
    }
    for (;;)
    {
      if (i < this.oeo.size())
      {
        localObject2 = (cpm)this.oeo.get(i);
        paramList = this.oci.getViewByItag(((cpm)localObject2).Username);
        ab.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[] { Integer.valueOf(i), ((cpm)localObject2).Username, Double.valueOf(((cpm)localObject2).xYw.wyP), Double.valueOf(((cpm)localObject2).xYw.wyO), Double.valueOf(((cpm)localObject2).xYw.xBh) });
        if (paramList != null)
        {
          if (!(paramList instanceof TrackPoint)) {
            break label875;
          }
          ((TrackPoint)paramList).n(((cpm)localObject2).xYw.wyP, ((cpm)localObject2).xYw.wyO);
        }
      }
      for (;;)
      {
        if ((paramList instanceof TrackPoint))
        {
          paramList = (TrackPoint)paramList;
          paramList.setAvatar(((cpm)localObject2).Username);
          paramList.y(((cpm)localObject2).xYw.xBh);
          if (!this.oev)
          {
            paramList.bMw();
            break label883;
            paramList = new TrackPoint(this.mContext, (ViewManager)this.oci.getViewManager());
            this.oci.addView(paramList, ((cpm)localObject2).xYw.wyP, ((cpm)localObject2).xYw.wyO, ((cpm)localObject2).Username);
            ((TrackPoint)paramList).o(((cpm)localObject2).xYw.wyP, ((cpm)localObject2).xYw.wyO);
            ((TrackPoint)paramList).setOnAvatarOnClickListener(this.oeF);
            ((TrackPoint)paramList).setOnLocationOnClickListener(this.oeE);
            continue;
            if ((this.ocj) && (this.oes))
            {
              if (!t.lA(l.bLr().obp)) {
                break label782;
              }
              bLX();
            }
            while ((j < 10) && (k >= 10))
            {
              paramList = this.oci.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).bMw();
                }
              }
              label782:
              if (this.oeo.size() > 0) {
                bLX();
              }
            }
            if ((j >= 10) && (k < 10))
            {
              paramList = this.oci.getChilds().iterator();
              while (paramList.hasNext())
              {
                localObject2 = paramList.next();
                if ((localObject2 instanceof TrackPoint)) {
                  ((TrackPoint)localObject2).bMx();
                }
              }
            }
            AppMethodBeat.o(113568);
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
    AppMethodBeat.i(113566);
    synchronized (oep)
    {
      if (this.oeo != null) {
        this.oeo.clear();
      }
      this.oci.clean();
      AppMethodBeat.o(113566);
      return;
    }
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(113565);
    if (paramBoolean) {
      if (this.oeq == null) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        h.qsU.e(10997, new Object[] { "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.oew = paramBoolean;
      }
      AppMethodBeat.o(113565);
      return;
    }
  }
  
  public final void iU(boolean paramBoolean)
  {
    AppMethodBeat.i(113567);
    if ((paramBoolean) && (!this.oev) && (this.oci != null))
    {
      Iterator localIterator = this.oci.getChilds().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TrackPoint)) {
          ((TrackPoint)localObject).bMx();
        }
      }
    }
    this.oev = paramBoolean;
    AppMethodBeat.o(113567);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(113573);
    com.tencent.mm.modelgeo.d.agQ().c(this.dZA);
    l.bLt().b(this.obw);
    AppMethodBeat.o(113573);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(113572);
    com.tencent.mm.modelgeo.d.agQ().b(this.dZA, true);
    l.bLt().a(this.obw);
    AppMethodBeat.o(113572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.m
 * JD-Core Version:    0.7.0.1
 */