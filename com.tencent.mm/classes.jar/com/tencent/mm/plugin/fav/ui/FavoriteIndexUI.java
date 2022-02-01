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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.a.a.a;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.plugin.fav.ui.e.b.c;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.e;
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
  private View.OnClickListener cNE;
  private com.tencent.mm.ui.tools.l contextMenuHelper;
  private int[] rEA;
  private com.tencent.mm.plugin.fav.a.g rEB;
  private com.tencent.mm.plugin.fav.a.g rEC;
  private com.tencent.mm.plugin.fav.ui.widget.b rED;
  private AdapterView.OnItemLongClickListener rEE;
  private int rGL;
  private com.tencent.mm.plugin.fav.ui.a.b rGM;
  private f rGN;
  private long startTime;
  
  public FavoriteIndexUI()
  {
    AppMethodBeat.i(107024);
    this.rGL = 0;
    this.startTime = 0L;
    this.rEA = new int[2];
    this.rGN = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(107016);
        ae.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
        FavoriteIndexUI.this.rDz.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107015);
            FavoriteIndexUI.this.rDz.cyO();
            AppMethodBeat.o(107015);
          }
        });
        AppMethodBeat.o(107016);
      }
    };
    this.rEE = new FavoriteIndexUI.19(this);
    this.cNE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106996);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_fav_search_from", 0);
        paramAnonymousView.putExtra("key_preset_search_type", i);
        p.b(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.a(FavoriteIndexUI.this).rHE, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        if ((localg != null) && (localg.field_favProto != null) && (localg.field_favProto.oeJ != null)) {
          if (localg.field_type == 3)
          {
            m += 1;
          }
          else if ((localg.field_type == 19) && (c.a(localg.field_favProto.GBs)))
          {
            n += 1;
          }
          else
          {
            Iterator localIterator2 = localg.field_favProto.oeJ.iterator();
            k = 0;
            while (localIterator2.hasNext())
            {
              ajx localajx = (ajx)localIterator2.next();
              if (localajx.GAI == 2) {
                i1 += 1;
              } else if (localajx.GAI == 1) {
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
      if ((i == 0) && (i3 == localg.field_favProto.oeJ.size())) {
        i = 1;
      }
      for (;;)
      {
        break;
        if (1 == paramList.size())
        {
          if ((((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type == 14) && ((i1 > 0) || (i2 > 0)))
          {
            com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131758865));
            AppMethodBeat.o(107047);
            return false;
          }
          if (i1 > 0)
          {
            com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131758866));
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
              com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131758867));
              continue;
              com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131758868));
              continue;
              com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131758869));
            }
          }
          if (j > 0)
          {
            com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755010));
            AppMethodBeat.o(107047);
            return false;
          }
          if (m > 0)
          {
            com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755011));
            AppMethodBeat.o(107047);
            return false;
          }
          if (n > 0)
          {
            com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131755132));
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
            com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getString(2131758870));
          }
        }
        AppMethodBeat.o(107047);
        return true;
      }
      label658:
      i3 = k;
    }
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
        bool |= localg.ahk(paramArrayOfString[i]);
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
  
  private void cxI()
  {
    AppMethodBeat.i(107029);
    this.rGM.a(false, null);
    this.rDw.setOnItemLongClickListener(this.rEE);
    showOptionMenu(11, true);
    this.rED.hide();
    AppMethodBeat.o(107029);
  }
  
  private void f(final List<com.tencent.mm.plugin.fav.a.g> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(107038);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107038);
      return;
    }
    if (bu.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(107038);
      return;
    }
    boolean bool = com.tencent.mm.model.x.wb(paramString2);
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
          paramList = m.c.rBv;
          locald = m.d.rBy;
          if (!bool) {
            break label169;
          }
        }
        label169:
        for (int i = r.zC(paramString2);; i = 0)
        {
          m.a(paramList, localg, locald, i);
          break;
          paramList = m.c.rBu;
          break label133;
        }
      }
    }
    if (localLinkedList.isEmpty())
    {
      ae.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
      paramList = getString(2131758987);
      com.tencent.mm.ui.base.h.cm(getApplicationContext(), paramList);
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
        if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.GBf != null) {
          paramList = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.GBf.GCG;
        }
        paramString1 = paramList;
        if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.GCe != null)
        {
          paramString1 = paramList;
          if (bu.isNullOrNil(paramList)) {
            paramString1 = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.GCe.link;
          }
        }
        if (bu.isNullOrNil(paramString1)) {
          continue;
        }
        ae.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramString1, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
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
            ae.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramString1, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { paramList, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
        continue;
      }
      if ((localObject2 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject2).field_type == 20)) {
        paramString2.add(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.GBx.objectId);
      }
    }
    if (paramString2.size() > 0) {
      ((t)com.tencent.mm.kernel.g.ad(t.class)).shareStatsReport(paramString2);
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(11125, new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(1) });
    AppMethodBeat.o(107038);
  }
  
  protected final void cxA()
  {
    AppMethodBeat.i(107026);
    super.cxA();
    this.gKO.post(new FavoriteIndexUI.18(this));
    AppMethodBeat.o(107026);
  }
  
  public final void cxZ()
  {
    AppMethodBeat.i(107045);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_enter_fav_cleanui_from", 0);
    com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavCleanUI", localIntent);
    AppMethodBeat.o(107045);
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a cxv()
  {
    AppMethodBeat.i(107031);
    if (this.rGM == null)
    {
      getContext();
      this.rGM = new com.tencent.mm.plugin.fav.ui.a.b(this.rDB, false);
      this.rGM.a(new a.a()
      {
        public final void cya()
        {
          AppMethodBeat.i(107022);
          FavoriteIndexUI.this.rDz.lH(true);
          AppMethodBeat.o(107022);
        }
      });
      this.rGM.rHL = this;
      this.rGM.scene = 1;
      this.rGM.rHO = this.rDw;
    }
    com.tencent.mm.plugin.fav.ui.a.b localb = this.rGM;
    AppMethodBeat.o(107031);
    return localb;
  }
  
  protected final void cxw()
  {
    AppMethodBeat.i(107032);
    this.rDz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107023);
        FavoriteIndexUI.this.rDz.cyO();
        AppMethodBeat.o(107023);
      }
    });
    AppMethodBeat.o(107032);
  }
  
  protected final boolean cxx()
  {
    AppMethodBeat.i(107033);
    switch (this.rGL)
    {
    }
    for (int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().getCount(); i > 0; i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwM())
    {
      AppMethodBeat.o(107033);
      return true;
    }
    AppMethodBeat.o(107033);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  protected final void cxy()
  {
    AppMethodBeat.i(107034);
    switch (this.rGL)
    {
    default: 
      this.gZC.setCompoundDrawablesWithIntrinsicBounds(0, 2131232274, 0, 0);
      this.gZC.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
      this.gZC.setText(2131758878);
      AppMethodBeat.o(107034);
      return;
    }
    this.gZC.setCompoundDrawablesWithIntrinsicBounds(0, 2131690142, 0, 0);
    this.gZC.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
    this.gZC.setText(2131758879);
    AppMethodBeat.o(107034);
  }
  
  protected final View.OnClickListener cxz()
  {
    return this.cNE;
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(107037);
    super.initHeaderView();
    this.rDz.lH(false);
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
      ae.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -1)
      {
        if (((this.rEC != null) && (this.rEC.field_type == 5)) || ((this.rEB != null) && (this.rEB.field_type == 5)))
        {
          localObject1 = "";
          if ((this.rEB == null) || (this.rEB.field_favProto.GCe == null)) {
            break label278;
          }
          paramIntent = this.rEB.field_favProto.GCe.link;
          label142:
          if (!bu.isNullOrNil(paramIntent)) {
            ae.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          }
        }
        try
        {
          paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
          com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          AppMethodBeat.o(107040);
          return;
          i.ahm(".ui.transmit.SelectConversationUI");
          continue;
          label278:
          if (this.rEC.field_favProto.GBf != null) {
            localObject1 = this.rEC.field_favProto.GBf.GCG;
          }
          paramIntent = (Intent)localObject1;
          if (this.rEC.field_favProto.GCe == null) {
            break label142;
          }
          paramIntent = (Intent)localObject1;
          if (!bu.isNullOrNil((String)localObject1)) {
            break label142;
          }
          paramIntent = this.rEC.field_favProto.GCe.link;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramIntent, "", new Object[0]);
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
      com.tencent.mm.ui.base.h.cm(getContext(), getString(2131758936));
      AppMethodBeat.o(107040);
      return;
      paramInt1 = 0;
      this.rDt = true;
      continue;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.azQ());
      if (paramIntent == null)
      {
        ae.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
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
        ae.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
        AppMethodBeat.o(107040);
        return;
      }
      paramInt1 = 0;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramIntent);
      this.rxJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107006);
          FavoriteIndexUI.this.rDt = true;
          k.du(this.rGS);
          AppMethodBeat.o(107006);
        }
      });
      continue;
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        ae.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
        AppMethodBeat.o(107040);
        return;
      }
      paramInt1 = 0;
      this.rxJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107007);
          FavoriteIndexUI.this.rDt = true;
          k.du(paramIntent);
          AppMethodBeat.o(107007);
        }
      });
      continue;
      final double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
      double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
      paramInt1 = paramIntent.getIntExtra("kwebmap_scale", 0);
      localObject1 = bu.bI(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      Object localObject2 = paramIntent.getCharSequenceExtra("kRemark");
      Object localObject3 = paramIntent.getStringExtra("kPoiName");
      paramIntent = paramIntent.getStringArrayListExtra("kTags");
      this.rxJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107008);
          FavoriteIndexUI.this.rDt = true;
          double d1 = d1;
          double d2 = paramInt1;
          int i = this.rGV;
          Object localObject2 = this.lye;
          Object localObject1 = paramIntent;
          String str = this.rGX;
          ArrayList localArrayList = this.rGY;
          ake localake = new ake();
          localake.aQt((String)localObject2);
          localake.B(d1);
          localake.A(d2);
          localake.aat(i);
          localake.aQu(str);
          localObject2 = new com.tencent.mm.plugin.fav.a.g();
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 6;
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(localake);
          if ((localObject1 != null) && (!bu.isNullOrNil(((CharSequence)localObject1).toString())))
          {
            ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aQz(((CharSequence)localObject1).toString());
            ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Di(bu.fpO());
            com.tencent.mm.plugin.report.service.g.yxI.f(10873, new Object[] { Integer.valueOf(6) });
          }
          k.G((com.tencent.mm.plugin.fav.a.g)localObject2);
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.plugin.fav.a.g)localObject2).ahk((String)((Iterator)localObject1).next());
            }
          }
          b.C((com.tencent.mm.plugin.fav.a.g)localObject2);
          com.tencent.mm.plugin.report.service.g.yxI.f(10648, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
          com.tencent.mm.plugin.fav.a.b.vJ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId);
          long l = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId;
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(l);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.GBd != null)) {
            com.tencent.mm.plugin.fav.a.b.a(l, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.GBd, "", "", new ArrayList(), FavoriteIndexUI.this.getContext());
          }
          AppMethodBeat.o(107008);
        }
      });
      paramInt1 = 0;
      continue;
      paramIntent = paramIntent.getStringExtra("choosed_file_path");
      if (bu.isNullOrNil(paramIntent))
      {
        paramInt1 = 1;
      }
      else
      {
        localObject1 = new com.tencent.mm.vfs.k(paramIntent);
        if (!((com.tencent.mm.vfs.k)localObject1).exists())
        {
          paramInt1 = 1;
        }
        else if (((com.tencent.mm.vfs.k)localObject1).length() >= ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(true))
        {
          paramInt1 = 4;
        }
        else
        {
          if (bu.isNullOrNil(paramIntent)) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 == 0) {
              break label1069;
            }
            paramInt1 = 0;
            this.rDt = true;
            break;
            localObject1 = new com.tencent.mm.vfs.k(paramIntent);
            if (!((com.tencent.mm.vfs.k)localObject1).exists())
            {
              paramInt1 = 0;
            }
            else
            {
              localObject2 = new com.tencent.mm.plugin.fav.a.g();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 8;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
              k.G((com.tencent.mm.plugin.fav.a.g)localObject2);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aQA(((com.tencent.mm.vfs.k)localObject1).getName());
              localObject3 = new ajx();
              ((ajx)localObject3).aPQ(paramIntent);
              ((ajx)localObject3).wt(true);
              ((ajx)localObject3).aPC(((com.tencent.mm.vfs.k)localObject1).getName());
              ((ajx)localObject3).aao(((com.tencent.mm.plugin.fav.a.g)localObject2).field_type);
              ((ajx)localObject3).aPM(com.tencent.mm.vfs.o.aaw(paramIntent));
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.oeJ.add(localObject3);
              b.C((com.tencent.mm.plugin.fav.a.g)localObject2);
              com.tencent.mm.plugin.report.service.g.yxI.f(10648, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
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
          paramInt1 = this.rGM.o(l, "");
          if (-1 == paramInt1)
          {
            AppMethodBeat.o(107040);
            return;
          }
          this.rDw.removeFooterView(this.rDx);
          this.rDw.setSelection(paramInt1);
          AppMethodBeat.o(107040);
          return;
          localObject1 = this.rGM.lB(false);
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
                com.tencent.mm.kernel.g.ajU().aw(new FavoriteIndexUI.6(this, (List)localObject1, paramIntent, (Dialog)localObject2));
                com.tencent.mm.plugin.report.service.g.yxI.f(11125, new Object[] { Integer.valueOf(paramIntent.length), Integer.valueOf(2) });
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                ae.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                f(this.rGM.lB(false), (String)localObject1, paramIntent);
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                ae.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                localObject2 = new ArrayList();
                ((List)localObject2).add(this.rEC);
                f((List)localObject2, (String)localObject1, paramIntent);
                paramInt1 = paramInt2;
              }
            }
          }
        }
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.cm(getContext(), getString(2131758884));
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
    if (this.rGM.rHE) {
      cxI();
    }
    AppMethodBeat.o(107040);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(107039);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.h.a(this, getContentView());
    AppMethodBeat.o(107039);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107025);
    this.rDC = this;
    ae.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
    super.onCreate(paramBundle);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwL() == null)
    {
      ae.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
      finish();
      AppMethodBeat.o(107025);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().lv(false);
    setMMTitle(2131758912);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106993);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).rHE)
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
    this.rDw.setOnItemLongClickListener(this.rEE);
    this.rDw.setOnTouchListener(new FavoriteIndexUI.12(this));
    com.tencent.mm.kernel.g.ajj().a(438, this.rGN);
    com.tencent.mm.kernel.g.ajj().a(401, this.rGN);
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(this);
    addIconOptionMenu(11, 2131758819, 2131689489, new FavoriteIndexUI.3(this));
    this.rED = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.rED.dY(findViewById(2131299786));
    this.rED.rMM = new b.a()
    {
      public final void cxB()
      {
        AppMethodBeat.i(107000);
        com.tencent.mm.ui.base.h.a(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.this.getString(2131758852), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106998);
            paramAnonymous2DialogInterface = FavoriteIndexUI.a(FavoriteIndexUI.this).lB(true);
            p.a(FavoriteIndexUI.this.getContext(), paramAnonymous2DialogInterface, null);
            com.tencent.mm.plugin.report.service.g.yxI.f(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
            if (FavoriteIndexUI.a(FavoriteIndexUI.this).rHE) {
              FavoriteIndexUI.b(FavoriteIndexUI.this);
            }
            AppMethodBeat.o(106998);
          }
        }, null);
        AppMethodBeat.o(107000);
      }
      
      public final void cxO()
      {
        AppMethodBeat.i(106999);
        if (!FavoriteIndexUI.a(FavoriteIndexUI.a(FavoriteIndexUI.this).lB(false), FavoriteIndexUI.this, new DialogInterface.OnClickListener()
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
      
      public final void cxP()
      {
        AppMethodBeat.i(107001);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).cyl() <= 0)
        {
          AppMethodBeat.o(107001);
          return;
        }
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).cyl() > 1)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_fav_scene", 3);
          com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", (Intent)localObject, 4104);
          i.ahl("FavTagEditUI");
          AppMethodBeat.o(107001);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.fav.a.g)FavoriteIndexUI.a(FavoriteIndexUI.this).lB(false).get(0);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_fav_scene", 3);
        localIntent.putExtra("key_fav_item_id", ((com.tencent.mm.plugin.fav.a.g)localObject).field_localId);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", localIntent);
        i.ahl("FavTagEditUI");
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).rHE) {
          FavoriteIndexUI.b(FavoriteIndexUI.this);
        }
        AppMethodBeat.o(107001);
      }
    };
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107014);
        long l = System.currentTimeMillis();
        List localList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwS();
        if (localList != null)
        {
          ae.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
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
          ae.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        }
        AppMethodBeat.o(107014);
      }
    });
    com.tencent.mm.plugin.fav.a.d.cwp().a(null);
    e.cxF();
    i.start();
    com.tencent.mm.pluginsdk.h.a(this, getContentView());
    AppMethodBeat.o(107025);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(107042);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131764452);
    localMenuItem.setIcon(ao.k(getContext(), 2131689494, getResources().getColor(2131099732)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(107042);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107027);
    super.onDestroy();
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwL() == null)
    {
      AppMethodBeat.o(107027);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().lv(true);
    if (this.rGM != null) {
      this.rGM.finish();
    }
    nk localnk = new nk();
    localnk.dCo.type = 12;
    com.tencent.mm.sdk.b.a.IvT.l(localnk);
    com.tencent.mm.kernel.g.ajj().b(438, this.rGN);
    com.tencent.mm.kernel.g.ajj().b(401, this.rGN);
    i.end();
    e.cxE();
    AppMethodBeat.o(107027);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107030);
    switch (this.rGL)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107030);
      return;
      if (this.rGM != null)
      {
        this.rGM.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = (b.b)paramView.getTag();
        if (paramAdapterView == null)
        {
          ae.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
          AppMethodBeat.o(107030);
          return;
        }
        if (paramAdapterView.rBM == null)
        {
          ae.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
          AppMethodBeat.o(107030);
          return;
        }
        ae.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[] { Integer.valueOf(paramAdapterView.rBM.field_type) });
        com.tencent.mm.plugin.report.service.g.yxI.f(12746, new Object[] { Integer.valueOf(paramAdapterView.rBM.field_type), Integer.valueOf(0), Integer.valueOf(paramInt - 1) });
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107028);
    if ((4 == paramInt) && (this.rGM.rHE))
    {
      cxI();
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
      p.a(getContext(), this.rGM.rHE, paramMenuItem);
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
    i.ahm(getClass().getSimpleName());
    AppMethodBeat.o(107036);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(107044);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107044);
      return;
    }
    ae.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
        com.tencent.mm.br.d.b(this, "location", ".ui.RedirectUI", paramArrayOfString, 4097);
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
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106994);
        if (FavoriteIndexUI.this.rDz != null) {
          FavoriteIndexUI.this.rDz.cyO();
        }
        AppMethodBeat.o(106994);
      }
    });
    ae.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    i.ahl(getClass().getSimpleName());
    AppMethodBeat.o(107035);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vY(long paramLong)
  {
    AppMethodBeat.i(107041);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.rGM.rHE)
    {
      localb = this.rED;
      if (this.rGM.cyl() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.lG(bool);
      AppMethodBeat.o(107041);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI
 * JD-Core Version:    0.7.0.1
 */