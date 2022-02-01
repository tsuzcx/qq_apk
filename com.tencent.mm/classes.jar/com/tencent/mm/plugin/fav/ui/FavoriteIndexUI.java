package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.a.a.a;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI
  extends FavBaseUI
  implements b.c, c.a
{
  private View.OnClickListener cEO;
  private com.tencent.mm.ui.tools.l contextMenuHelper;
  private int[] qdJ;
  private com.tencent.mm.plugin.fav.a.g qdK;
  private com.tencent.mm.plugin.fav.a.g qdL;
  private com.tencent.mm.plugin.fav.ui.widget.b qdM;
  private AdapterView.OnItemLongClickListener qdN;
  private int qfZ;
  private com.tencent.mm.plugin.fav.ui.a.b qga;
  private com.tencent.mm.al.g qgb;
  private long startTime;
  
  public FavoriteIndexUI()
  {
    AppMethodBeat.i(107024);
    this.qfZ = 0;
    this.startTime = 0L;
    this.qdJ = new int[2];
    this.qgb = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(107016);
        ad.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
        FavoriteIndexUI.this.qcG.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107015);
            FavoriteIndexUI.this.qcG.cjU();
            AppMethodBeat.o(107015);
          }
        });
        AppMethodBeat.o(107016);
      }
    };
    this.qdN = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(107018);
        if (paramAnonymousInt < FavoriteIndexUI.this.qcC.getHeaderViewsCount())
        {
          ad.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
          AppMethodBeat.o(107018);
          return true;
        }
        FavoriteIndexUI.a(FavoriteIndexUI.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLong, FavoriteIndexUI.c(FavoriteIndexUI.this));
        AppMethodBeat.o(107018);
        return true;
      }
    };
    this.cEO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106996);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_fav_search_from", 0);
        paramAnonymousView.putExtra("key_preset_search_type", i);
        p.b(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.a(FavoriteIndexUI.this).qgS, paramAnonymousView);
        AppMethodBeat.o(106996);
      }
    };
    AppMethodBeat.o(107024);
  }
  
  public static boolean a(List<com.tencent.mm.plugin.fav.a.g> paramList, Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(107047);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107047);
      return true;
    }
    int i1 = 0;
    int i2 = 0;
    int m = 0;
    int j = 0;
    new com.tencent.mm.plugin.fav.a.k();
    Iterator localIterator1 = paramList.iterator();
    int i = 0;
    int n = 0;
    com.tencent.mm.plugin.fav.a.g localg;
    int k;
    int i3;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator1.next();
        if ((localg != null) && (localg.field_favProto != null) && (localg.field_favProto.mVb != null)) {
          if (localg.field_type == 3)
          {
            m += 1;
          }
          else if ((localg.field_type == 19) && (c.a(localg.field_favProto.DhR)))
          {
            n += 1;
          }
          else
          {
            Iterator localIterator2 = localg.field_favProto.mVb.iterator();
            k = 0;
            while (localIterator2.hasNext())
            {
              afy localafy = (afy)localIterator2.next();
              if (localafy.Dhh == 2) {
                i1 += 1;
              } else if (localafy.Dhh == 1) {
                i2 += 1;
              } else {
                k += 1;
              }
            }
            if (!com.tencent.mm.plugin.fav.a.k.v(localg)) {
              break label658;
            }
            int i4 = j + 1;
            j = i4;
            i3 = k;
            if (k > 0)
            {
              i3 = k - 1;
              j = i4;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (i3 == localg.field_favProto.mVb.size())) {
        i = 1;
      }
      for (;;)
      {
        break;
        if (1 == paramList.size())
        {
          if ((((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type == 14) && ((i1 > 0) || (i2 > 0)))
          {
            com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131758865));
            AppMethodBeat.o(107047);
            return false;
          }
          if (i1 > 0)
          {
            com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131758866));
            AppMethodBeat.o(107047);
            return false;
          }
          if (i2 > 0)
          {
            switch (((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(107047);
              return false;
              com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131758867));
              continue;
              com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131758868));
              continue;
              com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131758869));
            }
          }
          if (j > 0)
          {
            com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755010));
            AppMethodBeat.o(107047);
            return false;
          }
          if (m > 0)
          {
            com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755011));
            AppMethodBeat.o(107047);
            return false;
          }
          if (n > 0)
          {
            com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131755132));
            AppMethodBeat.o(107047);
            return false;
          }
        }
        else if ((i1 > 0) || (i2 > 0) || (j > 0) || (m > 0) || (n > 0))
        {
          if (i != 0) {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758871), "", paramContext.getString(2131757560), paramContext.getString(2131757558), paramOnClickListener, null, 2131101171);
          }
          for (;;)
          {
            AppMethodBeat.o(107047);
            return false;
            com.tencent.mm.ui.base.h.cf(paramContext, paramContext.getString(2131758870));
          }
        }
        AppMethodBeat.o(107047);
        return true;
      }
      label658:
      i3 = k;
    }
  }
  
  private void b(final List<com.tencent.mm.plugin.fav.a.g> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(107038);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107038);
      return;
    }
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(107038);
      return;
    }
    boolean bool = w.pF(paramString2);
    Object localObject1 = new com.tencent.mm.plugin.fav.a.k();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next();
      if (!((com.tencent.mm.plugin.fav.a.k)localObject1).u(localg))
      {
        com.tencent.mm.plugin.fav.a.h.i(localg.field_localId, 1, 0);
        localLinkedList.add(localg);
        label133:
        m.d locald;
        if (bool)
        {
          paramList = m.c.qaB;
          locald = m.d.qaE;
          if (!bool) {
            break label169;
          }
        }
        label169:
        for (int i = com.tencent.mm.model.q.rY(paramString2);; i = 0)
        {
          m.a(paramList, localg, locald, i);
          break;
          paramList = m.c.qaA;
          break label133;
        }
      }
    }
    if (localLinkedList.isEmpty())
    {
      ad.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
      paramList = getString(2131758987);
      com.tencent.mm.ui.base.h.cf(getApplicationContext(), paramList);
      AppMethodBeat.o(107038);
      return;
    }
    paramList = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
    l.a(getContext(), paramString2, paramString1, localLinkedList, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107005);
        paramList.dismiss();
        com.tencent.mm.ui.widget.snackbar.b.n(FavoriteIndexUI.this, FavoriteIndexUI.this.getString(2131758834));
        AppMethodBeat.o(107005);
      }
    });
    paramString2 = new LinkedList();
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject2).field_type == 5))
      {
        paramList = "";
        if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.DhE != null) {
          paramList = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.DhE.Djf;
        }
        paramString1 = paramList;
        if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.DiD != null)
        {
          paramString1 = paramList;
          if (bt.isNullOrNil(paramList)) {
            paramString1 = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.DiD.link;
          }
        }
        if (bt.isNullOrNil(paramString1)) {
          continue;
        }
        ad.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramString1, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
        paramList = "";
        try
        {
          paramString1 = URLEncoder.encode(paramString1, "UTF-8");
          paramList = paramString1;
        }
        catch (UnsupportedEncodingException paramString1)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramString1, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(13378, new Object[] { paramList, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
        continue;
      }
      if ((localObject2 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject2).field_type == 20)) {
        paramString2.add(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.DhW.objectId);
      }
    }
    if (paramString2.size() > 0) {
      ((j)com.tencent.mm.kernel.g.ad(j.class)).shareStatsReport(paramString2);
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(11125, new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(1) });
    AppMethodBeat.o(107038);
  }
  
  public static void b(List<com.tencent.mm.plugin.fav.a.g> paramList, String[] paramArrayOfString)
  {
    AppMethodBeat.i(107046);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107046);
      return;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      AppMethodBeat.o(107046);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)paramList.next();
      int j = paramArrayOfString.length;
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= localg.Yc(paramArrayOfString[i]);
        i += 1;
      }
      if (bool)
      {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        com.tencent.mm.plugin.fav.a.b.p(localg);
        localLinkedList.add(localg);
      }
    }
    paramList = localLinkedList.iterator();
    while (paramList.hasNext()) {
      com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)paramList.next(), 3);
    }
    AppMethodBeat.o(107046);
  }
  
  private void ciV()
  {
    AppMethodBeat.i(107029);
    this.qga.a(false, null);
    this.qcC.setOnItemLongClickListener(this.qdN);
    showOptionMenu(11, true);
    this.qdM.hide();
    AppMethodBeat.o(107029);
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a ciI()
  {
    AppMethodBeat.i(107031);
    if (this.qga == null)
    {
      getContext();
      this.qga = new com.tencent.mm.plugin.fav.ui.a.b(this.qcI, false);
      this.qga.a(new a.a()
      {
        public final void cji()
        {
          AppMethodBeat.i(107022);
          FavoriteIndexUI.this.qcG.kK(true);
          AppMethodBeat.o(107022);
        }
      });
      this.qga.qgZ = this;
      this.qga.scene = 1;
      this.qga.qhc = this.qcC;
    }
    com.tencent.mm.plugin.fav.ui.a.b localb = this.qga;
    AppMethodBeat.o(107031);
    return localb;
  }
  
  protected final void ciJ()
  {
    AppMethodBeat.i(107032);
    this.qcG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107023);
        FavoriteIndexUI.this.qcG.cjU();
        AppMethodBeat.o(107023);
      }
    });
    AppMethodBeat.o(107032);
  }
  
  protected final boolean ciK()
  {
    AppMethodBeat.i(107033);
    switch (this.qfZ)
    {
    }
    for (int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().getCount(); i > 0; i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().chZ())
    {
      AppMethodBeat.o(107033);
      return true;
    }
    AppMethodBeat.o(107033);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  protected final void ciL()
  {
    AppMethodBeat.i(107034);
    switch (this.qfZ)
    {
    default: 
      this.qcD.setCompoundDrawablesWithIntrinsicBounds(0, 2131232274, 0, 0);
      this.qcD.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 10));
      this.qcD.setText(2131758878);
      AppMethodBeat.o(107034);
      return;
    }
    this.qcD.setCompoundDrawablesWithIntrinsicBounds(0, 2131690142, 0, 0);
    this.qcD.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 10));
    this.qcD.setText(2131758879);
    AppMethodBeat.o(107034);
  }
  
  protected final View.OnClickListener ciM()
  {
    return this.cEO;
  }
  
  protected final void ciN()
  {
    AppMethodBeat.i(107026);
    super.ciN();
    this.gAC.post(new FavoriteIndexUI.18(this));
    AppMethodBeat.o(107026);
  }
  
  public final void cjh()
  {
    AppMethodBeat.i(107045);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_enter_fav_cleanui_from", 0);
    com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavCleanUI", localIntent);
    AppMethodBeat.o(107045);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(107037);
    super.initHeaderView();
    this.qcG.kK(false);
    AppMethodBeat.o(107037);
  }
  
  public void onActivityResult(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(107040);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      ad.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -1)
      {
        if (((this.qdL != null) && (this.qdL.field_type == 5)) || ((this.qdK != null) && (this.qdK.field_type == 5)))
        {
          localObject1 = "";
          if ((this.qdK == null) || (this.qdK.field_favProto.DiD == null)) {
            break label278;
          }
          paramIntent = this.qdK.field_favProto.DiD.link;
          label142:
          if (!bt.isNullOrNil(paramIntent)) {
            ad.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          }
        }
        try
        {
          paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
          com.tencent.mm.plugin.report.service.h.vKh.f(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          AppMethodBeat.o(107040);
          return;
          com.tencent.mm.plugin.fav.a.i.Ye(".ui.transmit.SelectConversationUI");
          continue;
          label278:
          if (this.qdL.field_favProto.DhE != null) {
            localObject1 = this.qdL.field_favProto.DhE.Djf;
          }
          paramIntent = (Intent)localObject1;
          if (this.qdL.field_favProto.DiD == null) {
            break label142;
          }
          paramIntent = (Intent)localObject1;
          if (!bt.isNullOrNil((String)localObject1)) {
            break label142;
          }
          paramIntent = this.qdL.field_favProto.DiD.link;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramIntent, "", new Object[0]);
            paramIntent = "";
          }
        }
      }
    }
    paramInt2 = 2;
    Object localObject1 = paramIntent.getStringExtra("custom_send_text");
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
    }
    while (paramInt1 == 0)
    {
      com.tencent.mm.ui.base.h.cf(getContext(), getString(2131758936));
      AppMethodBeat.o(107040);
      return;
      paramInt1 = 0;
      this.qcz = true;
      continue;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.apW());
      if (paramIntent == null)
      {
        ad.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
        AppMethodBeat.o(107040);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("CropImageMode", 4);
      ((Intent)localObject1).putExtra("CropImage_Filter", true);
      ((Intent)localObject1).putExtra("CropImage_ImgPath", paramIntent);
      ((Intent)localObject1).setClassName(getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
      startActivityForResult((Intent)localObject1, 4099);
      paramInt1 = paramInt2;
      continue;
      paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
      if (paramIntent == null)
      {
        ad.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
        AppMethodBeat.o(107040);
        return;
      }
      paramInt1 = 0;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramIntent);
      this.pXi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107006);
          FavoriteIndexUI.this.qcz = true;
          k.dn(this.qgg);
          AppMethodBeat.o(107006);
        }
      });
      continue;
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        ad.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
        AppMethodBeat.o(107040);
        return;
      }
      paramInt1 = 0;
      this.pXi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107007);
          FavoriteIndexUI.this.qcz = true;
          k.dn(paramIntent);
          AppMethodBeat.o(107007);
        }
      });
      continue;
      final double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
      double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
      paramInt1 = paramIntent.getIntExtra("kwebmap_scale", 0);
      localObject1 = bt.by(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      Object localObject2 = paramIntent.getCharSequenceExtra("kRemark");
      Object localObject3 = paramIntent.getStringExtra("kPoiName");
      paramIntent = paramIntent.getStringArrayListExtra("kTags");
      this.pXi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107008);
          FavoriteIndexUI.this.qcz = true;
          double d1 = d1;
          double d2 = paramInt1;
          int i = this.qgj;
          Object localObject2 = this.kvs;
          Object localObject1 = paramIntent;
          String str = this.qgl;
          ArrayList localArrayList = this.qgm;
          agf localagf = new agf();
          localagf.aEc((String)localObject2);
          localagf.C(d1);
          localagf.B(d2);
          localagf.VI(i);
          localagf.aEd(str);
          localObject2 = new com.tencent.mm.plugin.fav.a.g();
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 6;
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(localagf);
          if ((localObject1 != null) && (!bt.isNullOrNil(((CharSequence)localObject1).toString())))
          {
            ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aEi(((CharSequence)localObject1).toString());
            ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.vt(bt.eGO());
            com.tencent.mm.plugin.report.service.h.vKh.f(10873, new Object[] { Integer.valueOf(6) });
          }
          k.G((com.tencent.mm.plugin.fav.a.g)localObject2);
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.plugin.fav.a.g)localObject2).Yc((String)((Iterator)localObject1).next());
            }
          }
          b.C((com.tencent.mm.plugin.fav.a.g)localObject2);
          com.tencent.mm.plugin.report.service.h.vKh.f(10648, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
          com.tencent.mm.plugin.fav.a.b.pH(((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId);
          long l = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId;
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(l);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.DhC != null)) {
            com.tencent.mm.plugin.fav.a.b.a(l, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.DhC, "", "", new ArrayList(), FavoriteIndexUI.this.getContext());
          }
          AppMethodBeat.o(107008);
        }
      });
      paramInt1 = 0;
      continue;
      paramIntent = paramIntent.getStringExtra("choosed_file_path");
      if (bt.isNullOrNil(paramIntent))
      {
        paramInt1 = 1;
      }
      else
      {
        localObject1 = new com.tencent.mm.vfs.e(paramIntent);
        if (!((com.tencent.mm.vfs.e)localObject1).exists())
        {
          paramInt1 = 1;
        }
        else if (((com.tencent.mm.vfs.e)localObject1).length() >= ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true))
        {
          paramInt1 = 4;
        }
        else
        {
          if (bt.isNullOrNil(paramIntent)) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 == 0) {
              break label1069;
            }
            paramInt1 = 0;
            this.qcz = true;
            break;
            localObject1 = new com.tencent.mm.vfs.e(paramIntent);
            if (!((com.tencent.mm.vfs.e)localObject1).exists())
            {
              paramInt1 = 0;
            }
            else
            {
              localObject2 = new com.tencent.mm.plugin.fav.a.g();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 8;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
              k.G((com.tencent.mm.plugin.fav.a.g)localObject2);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aEj(((com.tencent.mm.vfs.e)localObject1).getName());
              localObject3 = new afy();
              ((afy)localObject3).aDz(paramIntent);
              ((afy)localObject3).ux(true);
              ((afy)localObject3).aDl(((com.tencent.mm.vfs.e)localObject1).getName());
              ((afy)localObject3).VD(((com.tencent.mm.plugin.fav.a.g)localObject2).field_type);
              ((afy)localObject3).aDv(com.tencent.mm.vfs.i.RK(paramIntent));
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.mVb.add(localObject3);
              b.C((com.tencent.mm.plugin.fav.a.g)localObject2);
              com.tencent.mm.plugin.report.service.h.vKh.f(10648, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
              paramInt1 = 1;
            }
          }
          label1069:
          paramInt1 = 1;
          continue;
          long l = paramIntent.getLongExtra("key_fav_result_local_id", -1L);
          if (-1L == l)
          {
            AppMethodBeat.o(107040);
            return;
          }
          paramInt1 = this.qga.n(l, "");
          if (-1 == paramInt1)
          {
            AppMethodBeat.o(107040);
            return;
          }
          this.qcC.removeFooterView(this.qcE);
          this.qcC.setSelection(paramInt1);
          AppMethodBeat.o(107040);
          return;
          localObject1 = this.qga.kE(false);
          paramIntent = paramIntent.getStringArrayExtra("key_fav_result_array");
          paramInt1 = paramInt2;
          if (!((List)localObject1).isEmpty())
          {
            paramInt1 = paramInt2;
            if (paramIntent != null)
            {
              paramInt1 = paramInt2;
              if (paramIntent.length > 0)
              {
                localObject2 = com.tencent.mm.ui.base.h.b(getContext(), "", false, null);
                com.tencent.mm.kernel.g.afE().ax(new FavoriteIndexUI.6(this, (List)localObject1, paramIntent, (Dialog)localObject2));
                com.tencent.mm.plugin.report.service.h.vKh.f(11125, new Object[] { Integer.valueOf(paramIntent.length), Integer.valueOf(2) });
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                ad.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                b(this.qga.kE(false), (String)localObject1, paramIntent);
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                ad.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                localObject2 = new ArrayList();
                ((List)localObject2).add(this.qdL);
                b((List)localObject2, (String)localObject1, paramIntent);
                paramInt1 = paramInt2;
              }
            }
          }
        }
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.cf(getContext(), getString(2131758884));
      AppMethodBeat.o(107040);
      return;
    }
    if (3 == paramInt1)
    {
      Toast.makeText(getContext(), getString(2131759024), 1).show();
      AppMethodBeat.o(107040);
      return;
    }
    if (4 == paramInt1)
    {
      Toast.makeText(getContext(), getString(2131759025, new Object[] { Integer.valueOf(((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimitInMB(true)) }), 1).show();
      AppMethodBeat.o(107040);
      return;
    }
    if (this.qga.qgS) {
      ciV();
    }
    AppMethodBeat.o(107040);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(107039);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.g.a(this, getContentView());
    AppMethodBeat.o(107039);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107025);
    this.qcJ = this;
    ad.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
    super.onCreate(paramBundle);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().chY() == null)
    {
      ad.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
      finish();
      AppMethodBeat.o(107025);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ky(false);
    setMMTitle(2131758912);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106993);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).qgS)
        {
          FavoriteIndexUI.b(FavoriteIndexUI.this);
          AppMethodBeat.o(106993);
          return true;
        }
        FavoriteIndexUI.this.finish();
        AppMethodBeat.o(106993);
        return true;
      }
    });
    this.qcC.setOnItemLongClickListener(this.qdN);
    this.qcC.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(107010);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(107010);
          return false;
          FavoriteIndexUI.c(FavoriteIndexUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          FavoriteIndexUI.c(FavoriteIndexUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    com.tencent.mm.kernel.g.aeS().a(438, this.qgb);
    com.tencent.mm.kernel.g.aeS().a(401, this.qgb);
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(this);
    addIconOptionMenu(11, 2131758819, 2131689489, new FavoriteIndexUI.3(this));
    this.qdM = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.qdM.dP(findViewById(2131299786));
    this.qdM.qlL = new b.a()
    {
      public final void ciO()
      {
        AppMethodBeat.i(107000);
        com.tencent.mm.ui.base.h.a(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.this.getString(2131758852), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106998);
            paramAnonymous2DialogInterface = FavoriteIndexUI.a(FavoriteIndexUI.this).kE(true);
            p.a(FavoriteIndexUI.this.getContext(), paramAnonymous2DialogInterface, null);
            com.tencent.mm.plugin.report.service.h.vKh.f(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
            if (FavoriteIndexUI.a(FavoriteIndexUI.this).qgS) {
              FavoriteIndexUI.b(FavoriteIndexUI.this);
            }
            AppMethodBeat.o(106998);
          }
        }, null);
        AppMethodBeat.o(107000);
      }
      
      public final void ciW()
      {
        AppMethodBeat.i(106999);
        if (!FavoriteIndexUI.a(FavoriteIndexUI.a(FavoriteIndexUI.this).kE(false), FavoriteIndexUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106997);
            FavoriteIndexUI.a(FavoriteIndexUI.this.getContext(), 4105, FavoriteIndexUI.a(FavoriteIndexUI.this), FavoriteIndexUI.f(FavoriteIndexUI.this));
            AppMethodBeat.o(106997);
          }
        }))
        {
          AppMethodBeat.o(106999);
          return;
        }
        FavoriteIndexUI.a(FavoriteIndexUI.this.getContext(), 4105, FavoriteIndexUI.a(FavoriteIndexUI.this), FavoriteIndexUI.f(FavoriteIndexUI.this));
        AppMethodBeat.o(106999);
      }
      
      public final void ciX()
      {
        AppMethodBeat.i(107001);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).cjt() <= 0)
        {
          AppMethodBeat.o(107001);
          return;
        }
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).cjt() > 1)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_fav_scene", 3);
          com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", (Intent)localObject, 4104);
          com.tencent.mm.plugin.fav.a.i.Yd("FavTagEditUI");
          AppMethodBeat.o(107001);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.fav.a.g)FavoriteIndexUI.a(FavoriteIndexUI.this).kE(false).get(0);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_fav_scene", 3);
        localIntent.putExtra("key_fav_item_id", ((com.tencent.mm.plugin.fav.a.g)localObject).field_localId);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", localIntent);
        com.tencent.mm.plugin.fav.a.i.Yd("FavTagEditUI");
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).qgS) {
          FavoriteIndexUI.b(FavoriteIndexUI.this);
        }
        AppMethodBeat.o(107001);
      }
    };
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107014);
        long l = System.currentTimeMillis();
        List localList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cif();
        if (localList != null)
        {
          ad.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
          if (localList.size() == 0)
          {
            AppMethodBeat.o(107014);
            return;
          }
          int j = localList.size();
          int i = 0;
          while (i < j)
          {
            ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A((com.tencent.mm.plugin.fav.a.g)localList.get(i));
            i += 1;
          }
          ad.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        }
        AppMethodBeat.o(107014);
      }
    });
    com.tencent.mm.plugin.fav.a.d.chC().a(null);
    e.ciS();
    com.tencent.mm.plugin.fav.a.i.start();
    com.tencent.mm.pluginsdk.g.a(this, getContentView());
    AppMethodBeat.o(107025);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(107042);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131764452);
    localMenuItem.setIcon(am.i(getContext(), 2131689494, getResources().getColor(2131099732)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(107042);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107027);
    super.onDestroy();
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().chY() == null)
    {
      AppMethodBeat.o(107027);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().ky(true);
    if (this.qga != null) {
      this.qga.finish();
    }
    ms localms = new ms();
    localms.drL.type = 12;
    com.tencent.mm.sdk.b.a.ESL.l(localms);
    com.tencent.mm.kernel.g.aeS().b(438, this.qgb);
    com.tencent.mm.kernel.g.aeS().b(401, this.qgb);
    com.tencent.mm.plugin.fav.a.i.end();
    e.ciR();
    AppMethodBeat.o(107027);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107030);
    switch (this.qfZ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107030);
      return;
      if (this.qga != null)
      {
        this.qga.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = (b.b)paramView.getTag();
        if (paramAdapterView == null)
        {
          ad.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
          AppMethodBeat.o(107030);
          return;
        }
        if (paramAdapterView.qaS == null)
        {
          ad.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
          AppMethodBeat.o(107030);
          return;
        }
        ad.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[] { Integer.valueOf(paramAdapterView.qaS.field_type) });
        com.tencent.mm.plugin.report.service.h.vKh.f(12746, new Object[] { Integer.valueOf(paramAdapterView.qaS.field_type), Integer.valueOf(0), Integer.valueOf(paramInt - 1) });
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107028);
    if ((4 == paramInt) && (this.qga.qgS))
    {
      ciV();
      AppMethodBeat.o(107028);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(107028);
    return bool;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(107043);
    if (paramMenuItem.getItemId() == 10)
    {
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_enter_fav_search_from", 0);
      p.a(getContext(), this.qga.qgS, paramMenuItem);
      AppMethodBeat.o(107043);
      return true;
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(107043);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107036);
    super.onPause();
    com.tencent.mm.plugin.fav.a.i.Ye(getClass().getSimpleName());
    AppMethodBeat.o(107036);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(107044);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107044);
      return;
    }
    ad.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107044);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavPostVoiceUI", new Intent(), 4102);
        overridePendingTransition(0, 0);
        AppMethodBeat.o(107044);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761871), "", getString(2131760598), getString(2131755691), false, new FavoriteIndexUI.11(this), new FavoriteIndexUI.13(this));
      AppMethodBeat.o(107044);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = new Intent();
        paramArrayOfString.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
        paramArrayOfString.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
        paramArrayOfString.putExtra("map_view_type", 3);
        com.tencent.mm.bs.d.b(this, "location", ".ui.RedirectUI", paramArrayOfString, 4097);
        AppMethodBeat.o(107044);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), "", getString(2131760598), getString(2131755691), false, new FavoriteIndexUI.14(this), new FavoriteIndexUI.15(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107035);
    long l = System.currentTimeMillis();
    super.onResume();
    this.gAC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106994);
        if (FavoriteIndexUI.this.qcG != null) {
          FavoriteIndexUI.this.qcG.cjU();
        }
        AppMethodBeat.o(106994);
      }
    });
    ad.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    com.tencent.mm.plugin.fav.a.i.Yd(getClass().getSimpleName());
    AppMethodBeat.o(107035);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pW(long paramLong)
  {
    AppMethodBeat.i(107041);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.qga.qgS)
    {
      localb = this.qdM;
      if (this.qga.cjt() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.kJ(bool);
      AppMethodBeat.o(107041);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI
 * JD-Core Version:    0.7.0.1
 */