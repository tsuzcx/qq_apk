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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.nb;
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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private View.OnClickListener cBW;
  private com.tencent.mm.ui.tools.l contextMenuHelper;
  private int[] qMm;
  private com.tencent.mm.plugin.fav.a.g qMn;
  private com.tencent.mm.plugin.fav.a.g qMo;
  private com.tencent.mm.plugin.fav.ui.widget.b qMp;
  private AdapterView.OnItemLongClickListener qMq;
  private int qOB;
  private com.tencent.mm.plugin.fav.ui.a.b qOC;
  private com.tencent.mm.ak.g qOD;
  private long startTime;
  
  public FavoriteIndexUI()
  {
    AppMethodBeat.i(107024);
    this.qOB = 0;
    this.startTime = 0L;
    this.qMm = new int[2];
    this.qOD = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(107016);
        ac.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
        FavoriteIndexUI.this.qLl.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107015);
            FavoriteIndexUI.this.qLl.crB();
            AppMethodBeat.o(107015);
          }
        });
        AppMethodBeat.o(107016);
      }
    };
    this.qMq = new FavoriteIndexUI.19(this);
    this.cBW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106996);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_fav_search_from", 0);
        paramAnonymousView.putExtra("key_preset_search_type", i);
        p.b(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.a(FavoriteIndexUI.this).qPu, paramAnonymousView);
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
        if ((localg != null) && (localg.field_favProto != null) && (localg.field_favProto.nxC != null)) {
          if (localg.field_type == 3)
          {
            m += 1;
          }
          else if ((localg.field_type == 19) && (c.a(localg.field_favProto.EAX)))
          {
            n += 1;
          }
          else
          {
            Iterator localIterator2 = localg.field_favProto.nxC.iterator();
            k = 0;
            while (localIterator2.hasNext())
            {
              agx localagx = (agx)localIterator2.next();
              if (localagx.EAn == 2) {
                i1 += 1;
              } else if (localagx.EAn == 1) {
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
      if ((i == 0) && (i3 == localg.field_favProto.nxC.size())) {
        i = 1;
      }
      for (;;)
      {
        break;
        if (1 == paramList.size())
        {
          if ((((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type == 14) && ((i1 > 0) || (i2 > 0)))
          {
            com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131758865));
            AppMethodBeat.o(107047);
            return false;
          }
          if (i1 > 0)
          {
            com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131758866));
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
              com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131758867));
              continue;
              com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131758868));
              continue;
              com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131758869));
            }
          }
          if (j > 0)
          {
            com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131755010));
            AppMethodBeat.o(107047);
            return false;
          }
          if (m > 0)
          {
            com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131755011));
            AppMethodBeat.o(107047);
            return false;
          }
          if (n > 0)
          {
            com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131755132));
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
            com.tencent.mm.ui.base.h.cg(paramContext, paramContext.getString(2131758870));
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
        bool |= localg.acy(paramArrayOfString[i]);
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
  
  private void cqC()
  {
    AppMethodBeat.i(107029);
    this.qOC.a(false, null);
    this.qLi.setOnItemLongClickListener(this.qMq);
    showOptionMenu(11, true);
    this.qMp.hide();
    AppMethodBeat.o(107029);
  }
  
  private void e(final List<com.tencent.mm.plugin.fav.a.g> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(107038);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107038);
      return;
    }
    if (bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(107038);
      return;
    }
    boolean bool = w.sQ(paramString2);
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
          paramList = m.c.qJh;
          locald = m.d.qJk;
          if (!bool) {
            break label169;
          }
        }
        label169:
        for (int i = com.tencent.mm.model.q.wb(paramString2);; i = 0)
        {
          m.a(paramList, localg, locald, i);
          break;
          paramList = m.c.qJg;
          break label133;
        }
      }
    }
    if (localLinkedList.isEmpty())
    {
      ac.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
      paramList = getString(2131758987);
      com.tencent.mm.ui.base.h.cg(getApplicationContext(), paramList);
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
        if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EAK != null) {
          paramList = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EAK.ECl;
        }
        paramString1 = paramList;
        if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EBJ != null)
        {
          paramString1 = paramList;
          if (bs.isNullOrNil(paramList)) {
            paramString1 = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EBJ.link;
          }
        }
        if (bs.isNullOrNil(paramString1)) {
          continue;
        }
        ac.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramString1, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
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
            ac.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramString1, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { paramList, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
        continue;
      }
      if ((localObject2 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject2).field_type == 20)) {
        paramString2.add(((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.EBc.objectId);
      }
    }
    if (paramString2.size() > 0) {
      ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).shareStatsReport(paramString2);
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(11125, new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(1) });
    AppMethodBeat.o(107038);
  }
  
  public final void cqO()
  {
    AppMethodBeat.i(107045);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_enter_fav_cleanui_from", 0);
    com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavCleanUI", localIntent);
    AppMethodBeat.o(107045);
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a cqp()
  {
    AppMethodBeat.i(107031);
    if (this.qOC == null)
    {
      getContext();
      this.qOC = new com.tencent.mm.plugin.fav.ui.a.b(this.qLn, false);
      this.qOC.a(new a.a()
      {
        public final void cqP()
        {
          AppMethodBeat.i(107022);
          FavoriteIndexUI.this.qLl.lo(true);
          AppMethodBeat.o(107022);
        }
      });
      this.qOC.qPB = this;
      this.qOC.scene = 1;
      this.qOC.qPE = this.qLi;
    }
    com.tencent.mm.plugin.fav.ui.a.b localb = this.qOC;
    AppMethodBeat.o(107031);
    return localb;
  }
  
  protected final void cqq()
  {
    AppMethodBeat.i(107032);
    this.qLl.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107023);
        FavoriteIndexUI.this.qLl.crB();
        AppMethodBeat.o(107023);
      }
    });
    AppMethodBeat.o(107032);
  }
  
  protected final boolean cqr()
  {
    AppMethodBeat.i(107033);
    switch (this.qOB)
    {
    }
    for (int i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().getCount(); i > 0; i = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpG())
    {
      AppMethodBeat.o(107033);
      return true;
    }
    AppMethodBeat.o(107033);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  protected final void cqs()
  {
    AppMethodBeat.i(107034);
    switch (this.qOB)
    {
    default: 
      this.gDf.setCompoundDrawablesWithIntrinsicBounds(0, 2131232274, 0, 0);
      this.gDf.setCompoundDrawablePadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 10));
      this.gDf.setText(2131758878);
      AppMethodBeat.o(107034);
      return;
    }
    this.gDf.setCompoundDrawablesWithIntrinsicBounds(0, 2131690142, 0, 0);
    this.gDf.setCompoundDrawablePadding(com.tencent.mm.cc.a.fromDPToPix(getContext(), 10));
    this.gDf.setText(2131758879);
    AppMethodBeat.o(107034);
  }
  
  protected final View.OnClickListener cqt()
  {
    return this.cBW;
  }
  
  protected final void cqu()
  {
    AppMethodBeat.i(107026);
    super.cqu();
    this.gox.post(new FavoriteIndexUI.18(this));
    AppMethodBeat.o(107026);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(107037);
    super.initHeaderView();
    this.qLl.lo(false);
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
      ac.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -1)
      {
        if (((this.qMo != null) && (this.qMo.field_type == 5)) || ((this.qMn != null) && (this.qMn.field_type == 5)))
        {
          localObject1 = "";
          if ((this.qMn == null) || (this.qMn.field_favProto.EBJ == null)) {
            break label278;
          }
          paramIntent = this.qMn.field_favProto.EBJ.link;
          label142:
          if (!bs.isNullOrNil(paramIntent)) {
            ac.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          }
        }
        try
        {
          paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
          com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          AppMethodBeat.o(107040);
          return;
          com.tencent.mm.plugin.fav.a.i.acA(".ui.transmit.SelectConversationUI");
          continue;
          label278:
          if (this.qMo.field_favProto.EAK != null) {
            localObject1 = this.qMo.field_favProto.EAK.ECl;
          }
          paramIntent = (Intent)localObject1;
          if (this.qMo.field_favProto.EBJ == null) {
            break label142;
          }
          paramIntent = (Intent)localObject1;
          if (!bs.isNullOrNil((String)localObject1)) {
            break label142;
          }
          paramIntent = this.qMo.field_favProto.EBJ.link;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramIntent, "", new Object[0]);
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
      com.tencent.mm.ui.base.h.cg(getContext(), getString(2131758936));
      AppMethodBeat.o(107040);
      return;
      paramInt1 = 0;
      this.qLf = true;
      continue;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.awL());
      if (paramIntent == null)
      {
        ac.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
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
        ac.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
        AppMethodBeat.o(107040);
        return;
      }
      paramInt1 = 0;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramIntent);
      this.qFN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107006);
          FavoriteIndexUI.this.qLf = true;
          k.dp(this.qOI);
          AppMethodBeat.o(107006);
        }
      });
      continue;
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        ac.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
        AppMethodBeat.o(107040);
        return;
      }
      paramInt1 = 0;
      this.qFN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107007);
          FavoriteIndexUI.this.qLf = true;
          k.dp(paramIntent);
          AppMethodBeat.o(107007);
        }
      });
      continue;
      final double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
      double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
      paramInt1 = paramIntent.getIntExtra("kwebmap_scale", 0);
      localObject1 = bs.bG(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      Object localObject2 = paramIntent.getCharSequenceExtra("kRemark");
      Object localObject3 = paramIntent.getStringExtra("kPoiName");
      paramIntent = paramIntent.getStringArrayListExtra("kTags");
      this.qFN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107008);
          FavoriteIndexUI.this.qLf = true;
          double d1 = d1;
          double d2 = paramInt1;
          int i = this.qOL;
          Object localObject2 = this.kWG;
          Object localObject1 = paramIntent;
          String str = this.qON;
          ArrayList localArrayList = this.qOO;
          ahe localahe = new ahe();
          localahe.aJt((String)localObject2);
          localahe.B(d1);
          localahe.A(d2);
          localahe.XR(i);
          localahe.aJu(str);
          localObject2 = new com.tencent.mm.plugin.fav.a.g();
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 6;
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(localahe);
          if ((localObject1 != null) && (!bs.isNullOrNil(((CharSequence)localObject1).toString())))
          {
            ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aJz(((CharSequence)localObject1).toString());
            ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.zW(bs.eWj());
            com.tencent.mm.plugin.report.service.h.wUl.f(10873, new Object[] { Integer.valueOf(6) });
          }
          k.G((com.tencent.mm.plugin.fav.a.g)localObject2);
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.plugin.fav.a.g)localObject2).acy((String)((Iterator)localObject1).next());
            }
          }
          b.C((com.tencent.mm.plugin.fav.a.g)localObject2);
          com.tencent.mm.plugin.report.service.h.wUl.f(10648, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
          com.tencent.mm.plugin.fav.a.b.tw(((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId);
          long l = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId;
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(l);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.EAI != null)) {
            com.tencent.mm.plugin.fav.a.b.a(l, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.EAI, "", "", new ArrayList(), FavoriteIndexUI.this.getContext());
          }
          AppMethodBeat.o(107008);
        }
      });
      paramInt1 = 0;
      continue;
      paramIntent = paramIntent.getStringExtra("choosed_file_path");
      if (bs.isNullOrNil(paramIntent))
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
          if (bs.isNullOrNil(paramIntent)) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 == 0) {
              break label1069;
            }
            paramInt1 = 0;
            this.qLf = true;
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
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aJA(((com.tencent.mm.vfs.e)localObject1).getName());
              localObject3 = new agx();
              ((agx)localObject3).aIQ(paramIntent);
              ((agx)localObject3).vz(true);
              ((agx)localObject3).aIC(((com.tencent.mm.vfs.e)localObject1).getName());
              ((agx)localObject3).XM(((com.tencent.mm.plugin.fav.a.g)localObject2).field_type);
              ((agx)localObject3).aIM(com.tencent.mm.vfs.i.VW(paramIntent));
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.nxC.add(localObject3);
              b.C((com.tencent.mm.plugin.fav.a.g)localObject2);
              com.tencent.mm.plugin.report.service.h.wUl.f(10648, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
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
          paramInt1 = this.qOC.n(l, "");
          if (-1 == paramInt1)
          {
            AppMethodBeat.o(107040);
            return;
          }
          this.qLi.removeFooterView(this.qLj);
          this.qLi.setSelection(paramInt1);
          AppMethodBeat.o(107040);
          return;
          localObject1 = this.qOC.li(false);
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
                com.tencent.mm.kernel.g.agU().az(new FavoriteIndexUI.6(this, (List)localObject1, paramIntent, (Dialog)localObject2));
                com.tencent.mm.plugin.report.service.h.wUl.f(11125, new Object[] { Integer.valueOf(paramIntent.length), Integer.valueOf(2) });
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                ac.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                e(this.qOC.li(false), (String)localObject1, paramIntent);
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                ac.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                localObject2 = new ArrayList();
                ((List)localObject2).add(this.qMo);
                e((List)localObject2, (String)localObject1, paramIntent);
                paramInt1 = paramInt2;
              }
            }
          }
        }
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.h.cg(getContext(), getString(2131758884));
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
    if (this.qOC.qPu) {
      cqC();
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
    this.qLo = this;
    ac.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
    super.onCreate(paramBundle);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpF() == null)
    {
      ac.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
      finish();
      AppMethodBeat.o(107025);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().lc(false);
    setMMTitle(2131758912);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106993);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).qPu)
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
    this.qLi.setOnItemLongClickListener(this.qMq);
    this.qLi.setOnTouchListener(new FavoriteIndexUI.12(this));
    com.tencent.mm.kernel.g.agi().a(438, this.qOD);
    com.tencent.mm.kernel.g.agi().a(401, this.qOD);
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(this);
    addIconOptionMenu(11, 2131758819, 2131689489, new FavoriteIndexUI.3(this));
    this.qMp = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.qMp.dT(findViewById(2131299786));
    this.qMp.qUn = new b.a()
    {
      public final void cqD()
      {
        AppMethodBeat.i(106999);
        if (!FavoriteIndexUI.a(FavoriteIndexUI.a(FavoriteIndexUI.this).li(false), FavoriteIndexUI.this, new DialogInterface.OnClickListener()
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
      
      public final void cqE()
      {
        AppMethodBeat.i(107001);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).cra() <= 0)
        {
          AppMethodBeat.o(107001);
          return;
        }
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).cra() > 1)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_fav_scene", 3);
          com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", (Intent)localObject, 4104);
          com.tencent.mm.plugin.fav.a.i.acz("FavTagEditUI");
          AppMethodBeat.o(107001);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.fav.a.g)FavoriteIndexUI.a(FavoriteIndexUI.this).li(false).get(0);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_fav_scene", 3);
        localIntent.putExtra("key_fav_item_id", ((com.tencent.mm.plugin.fav.a.g)localObject).field_localId);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", localIntent);
        com.tencent.mm.plugin.fav.a.i.acz("FavTagEditUI");
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).qPu) {
          FavoriteIndexUI.b(FavoriteIndexUI.this);
        }
        AppMethodBeat.o(107001);
      }
      
      public final void cqv()
      {
        AppMethodBeat.i(107000);
        com.tencent.mm.ui.base.h.a(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.this.getString(2131758852), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106998);
            paramAnonymous2DialogInterface = FavoriteIndexUI.a(FavoriteIndexUI.this).li(true);
            p.a(FavoriteIndexUI.this.getContext(), paramAnonymous2DialogInterface, null);
            com.tencent.mm.plugin.report.service.h.wUl.f(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
            if (FavoriteIndexUI.a(FavoriteIndexUI.this).qPu) {
              FavoriteIndexUI.b(FavoriteIndexUI.this);
            }
            AppMethodBeat.o(106998);
          }
        }, null);
        AppMethodBeat.o(107000);
      }
    };
    com.tencent.mm.kernel.g.agU().az(new FavoriteIndexUI.16(this));
    com.tencent.mm.plugin.fav.a.d.cpj().a(null);
    e.cqz();
    com.tencent.mm.plugin.fav.a.i.start();
    com.tencent.mm.pluginsdk.g.a(this, getContentView());
    AppMethodBeat.o(107025);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(107042);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131764452);
    localMenuItem.setIcon(am.k(getContext(), 2131689494, getResources().getColor(2131099732)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(107042);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107027);
    super.onDestroy();
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpF() == null)
    {
      AppMethodBeat.o(107027);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().lc(true);
    if (this.qOC != null) {
      this.qOC.finish();
    }
    nb localnb = new nb();
    localnb.dpw.type = 12;
    com.tencent.mm.sdk.b.a.GpY.l(localnb);
    com.tencent.mm.kernel.g.agi().b(438, this.qOD);
    com.tencent.mm.kernel.g.agi().b(401, this.qOD);
    com.tencent.mm.plugin.fav.a.i.end();
    e.cqy();
    AppMethodBeat.o(107027);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107030);
    switch (this.qOB)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107030);
      return;
      if (this.qOC != null)
      {
        this.qOC.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = (b.b)paramView.getTag();
        if (paramAdapterView == null)
        {
          ac.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
          AppMethodBeat.o(107030);
          return;
        }
        if (paramAdapterView.qJy == null)
        {
          ac.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
          AppMethodBeat.o(107030);
          return;
        }
        ac.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[] { Integer.valueOf(paramAdapterView.qJy.field_type) });
        com.tencent.mm.plugin.report.service.h.wUl.f(12746, new Object[] { Integer.valueOf(paramAdapterView.qJy.field_type), Integer.valueOf(0), Integer.valueOf(paramInt - 1) });
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107028);
    if ((4 == paramInt) && (this.qOC.qPu))
    {
      cqC();
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
      p.a(getContext(), this.qOC.qPu, paramMenuItem);
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
    com.tencent.mm.plugin.fav.a.i.acA(getClass().getSimpleName());
    AppMethodBeat.o(107036);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(107044);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107044);
      return;
    }
    ac.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106994);
        if (FavoriteIndexUI.this.qLl != null) {
          FavoriteIndexUI.this.qLl.crB();
        }
        AppMethodBeat.o(106994);
      }
    });
    ac.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    com.tencent.mm.plugin.fav.a.i.acz(getClass().getSimpleName());
    AppMethodBeat.o(107035);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tL(long paramLong)
  {
    AppMethodBeat.i(107041);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.qOC.qPu)
    {
      localb = this.qMp;
      if (this.qOC.cra() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.ln(bool);
      AppMethodBeat.o(107041);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI
 * JD-Core Version:    0.7.0.1
 */