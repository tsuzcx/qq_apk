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
import android.util.Pair;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.a.a.a;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.g;
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
  private com.tencent.mm.ui.tools.l contextMenuHelper;
  private View.OnClickListener dec;
  private long startTime;
  private int[] tef;
  private com.tencent.mm.plugin.fav.a.g teg;
  private com.tencent.mm.plugin.fav.a.g teh;
  private com.tencent.mm.plugin.fav.ui.widget.b tei;
  private AdapterView.OnItemLongClickListener tej;
  private int tgr;
  private com.tencent.mm.plugin.fav.ui.a.b tgs;
  private int tgt;
  private com.tencent.mm.ak.i tgu;
  
  public FavoriteIndexUI()
  {
    AppMethodBeat.i(107024);
    this.tgr = 0;
    this.startTime = 0L;
    this.tgt = 0;
    this.tef = new int[2];
    this.tgu = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(107016);
        Log.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
        FavoriteIndexUI.this.tde.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107015);
            FavoriteIndexUI.this.tde.cWR();
            AppMethodBeat.o(107015);
          }
        });
        AppMethodBeat.o(107016);
      }
    };
    this.tej = new FavoriteIndexUI.19(this);
    this.dec = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106996);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_fav_search_from", 0);
        paramAnonymousView.putExtra("key_preset_search_type", i);
        p.b(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.a(FavoriteIndexUI.this).thl, paramAnonymousView);
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
        if ((localg != null) && (localg.field_favProto != null) && (localg.field_favProto.ppH != null)) {
          if (localg.field_type == 3)
          {
            m += 1;
          }
          else if ((localg.field_type == 19) && (c.a(localg.field_favProto.Lxf)))
          {
            n += 1;
          }
          else
          {
            Iterator localIterator2 = localg.field_favProto.ppH.iterator();
            k = 0;
            while (localIterator2.hasNext())
            {
              aml localaml = (aml)localIterator2.next();
              if (localaml.Lwv == 2) {
                i1 += 1;
              } else if (localaml.Lwv == 1) {
                i2 += 1;
              } else {
                k += 1;
              }
            }
            if (!com.tencent.mm.plugin.fav.a.k.v(localg)) {
              break label698;
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
      if ((i == 0) && (i3 == localg.field_favProto.ppH.size())) {
        i = 1;
      }
      for (;;)
      {
        break;
        if (1 == paramList.size())
        {
          if ((((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type == 14) && ((i1 > 0) || (i2 > 0)))
          {
            com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131759188));
            AppMethodBeat.o(107047);
            return false;
          }
          if (i1 > 0)
          {
            com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131759190, new Object[] { Integer.valueOf(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavSizeLimitInMB(true, ((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type)) }));
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
              com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131759191));
              continue;
              com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131759192));
              continue;
              com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131759193));
            }
          }
          if (j > 0)
          {
            com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755011));
            AppMethodBeat.o(107047);
            return false;
          }
          if (m > 0)
          {
            com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755012));
            AppMethodBeat.o(107047);
            return false;
          }
          if (n > 0)
          {
            com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131755009));
            AppMethodBeat.o(107047);
            return false;
          }
        }
        else if ((i1 > 0) || (i2 > 0) || (j > 0) || (m > 0) || (n > 0))
        {
          if (i != 0) {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759195), "", paramContext.getString(2131757787), paramContext.getString(2131757785), paramOnClickListener, null, 2131101414);
          }
          for (;;)
          {
            AppMethodBeat.o(107047);
            return false;
            com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getString(2131759194));
          }
        }
        AppMethodBeat.o(107047);
        return true;
      }
      label698:
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
        bool |= localg.arS(paramArrayOfString[i]);
        i += 1;
      }
      if (bool)
      {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
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
  
  private void cVM()
  {
    AppMethodBeat.i(107029);
    this.tgs.a(false, null);
    this.tdb.setOnItemLongClickListener(this.tej);
    showOptionMenu(11, true);
    this.tei.hide();
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
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(107038);
      return;
    }
    boolean bool = ab.Eq(paramString2);
    Object localObject1 = new com.tencent.mm.plugin.fav.a.k();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)((Iterator)localObject2).next();
      if (!((com.tencent.mm.plugin.fav.a.k)localObject1).u(localg))
      {
        com.tencent.mm.plugin.fav.a.h.b(localg.field_localId, 1, 0, this.tgt);
        localLinkedList.add(localg);
        label137:
        m.d locald;
        if (bool)
        {
          paramList = m.c.tba;
          locald = m.d.tbd;
          if (!bool) {
            break label173;
          }
        }
        label173:
        for (int i = v.Ie(paramString2);; i = 0)
        {
          m.a(paramList, localg, locald, i);
          break;
          paramList = m.c.taZ;
          break label137;
        }
      }
    }
    if (localLinkedList.isEmpty())
    {
      Log.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
      paramList = getString(2131759312);
      com.tencent.mm.ui.base.h.cD(getApplicationContext(), paramList);
      AppMethodBeat.o(107038);
      return;
    }
    paramList = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
    l.a(getContext(), paramString2, paramString1, localLinkedList, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107005);
        paramList.dismiss();
        com.tencent.mm.ui.widget.snackbar.b.r(FavoriteIndexUI.this, FavoriteIndexUI.this.getString(2131759157));
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
        if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.LwS != null) {
          paramList = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.LwS.LyC;
        }
        paramString1 = paramList;
        if (((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Lya != null)
        {
          paramString1 = paramList;
          if (Util.isNullOrNil(paramList)) {
            paramString1 = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Lya.link;
          }
        }
        if (Util.isNullOrNil(paramString1)) {
          continue;
        }
        Log.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramString1, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
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
            Log.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramString1, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { paramList, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
        continue;
      }
      if ((localObject2 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject2).field_type == 20))
      {
        paramList = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Lxk;
        paramString2.add(new Pair(paramList.objectId, paramList.objectNonceId));
      }
    }
    if (paramString2.size() > 0) {
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport(paramString2, false);
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11125, new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(1) });
    AppMethodBeat.o(107038);
  }
  
  public final void Ec(long paramLong)
  {
    AppMethodBeat.i(107041);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.tgs.thl)
    {
      localb = this.tei;
      if (this.tgs.cWp() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.gf(bool);
      AppMethodBeat.o(107041);
      return;
    }
  }
  
  protected final void cVA()
  {
    AppMethodBeat.i(107032);
    this.tde.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107023);
        FavoriteIndexUI.this.tde.cWR();
        AppMethodBeat.o(107023);
      }
    });
    AppMethodBeat.o(107032);
  }
  
  protected final boolean cVB()
  {
    AppMethodBeat.i(107033);
    switch (this.tgr)
    {
    }
    for (int i = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().getCount(); i > 0; i = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUQ())
    {
      AppMethodBeat.o(107033);
      return true;
    }
    AppMethodBeat.o(107033);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  protected final void cVC()
  {
    AppMethodBeat.i(107034);
    switch (this.tgr)
    {
    default: 
      this.hSx.setCompoundDrawablesWithIntrinsicBounds(0, 2131232388, 0, 0);
      this.hSx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
      this.hSx.setText(2131759202);
      AppMethodBeat.o(107034);
      return;
    }
    this.hSx.setCompoundDrawablesWithIntrinsicBounds(0, 2131690179, 0, 0);
    this.hSx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
    this.hSx.setText(2131759203);
    AppMethodBeat.o(107034);
  }
  
  protected final View.OnClickListener cVD()
  {
    return this.dec;
  }
  
  protected final void cVE()
  {
    AppMethodBeat.i(107026);
    super.cVE();
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107017);
        AppMethodBeat.o(107017);
      }
    });
    AppMethodBeat.o(107026);
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a cVz()
  {
    AppMethodBeat.i(107031);
    if (this.tgs == null)
    {
      getContext();
      this.tgs = new com.tencent.mm.plugin.fav.ui.a.b(this.tdg, false);
      this.tgs.a(new a.a()
      {
        public final void cWe()
        {
          AppMethodBeat.i(107022);
          FavoriteIndexUI.this.tde.mJ(true);
          AppMethodBeat.o(107022);
        }
      });
      this.tgs.ths = this;
      this.tgs.scene = 1;
      this.tgs.thv = this.tdb;
    }
    com.tencent.mm.plugin.fav.ui.a.b localb = this.tgs;
    AppMethodBeat.o(107031);
    return localb;
  }
  
  public final void cWd()
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
    this.tde.mJ(false);
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
      Log.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -1)
      {
        if (((this.teh != null) && (this.teh.field_type == 5)) || ((this.teg != null) && (this.teg.field_type == 5)))
        {
          localObject1 = "";
          if ((this.teg == null) || (this.teg.field_favProto.Lya == null)) {
            break label278;
          }
          paramIntent = this.teg.field_favProto.Lya.link;
          label142:
          if (!Util.isNullOrNil(paramIntent)) {
            Log.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          }
        }
        try
        {
          paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
          com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          AppMethodBeat.o(107040);
          return;
          com.tencent.mm.plugin.fav.a.i.arU(".ui.transmit.SelectConversationUI");
          continue;
          label278:
          if (this.teh.field_favProto.LwS != null) {
            localObject1 = this.teh.field_favProto.LwS.LyC;
          }
          paramIntent = (Intent)localObject1;
          if (this.teh.field_favProto.Lya == null) {
            break label142;
          }
          paramIntent = (Intent)localObject1;
          if (!Util.isNullOrNil((String)localObject1)) {
            break label142;
          }
          paramIntent = this.teh.field_favProto.Lya.link;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramIntent, "", new Object[0]);
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
      com.tencent.mm.ui.base.h.cD(getContext(), getString(2131759260));
      AppMethodBeat.o(107040);
      return;
      paramInt1 = 0;
      this.tcY = true;
      continue;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.s.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.aSY());
      if (paramIntent == null)
      {
        Log.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
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
        Log.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
        AppMethodBeat.o(107040);
        return;
      }
      paramInt1 = 0;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramIntent);
      this.workerHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107006);
          FavoriteIndexUI.this.tcY = true;
          k.dI(this.tgz);
          AppMethodBeat.o(107006);
        }
      });
      continue;
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        Log.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
        AppMethodBeat.o(107040);
        return;
      }
      paramInt1 = 0;
      this.workerHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107007);
          FavoriteIndexUI.this.tcY = true;
          k.dI(paramIntent);
          AppMethodBeat.o(107007);
        }
      });
      continue;
      final double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
      double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
      paramInt1 = paramIntent.getIntExtra("kwebmap_scale", 0);
      localObject1 = Util.nullAs(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      Object localObject2 = paramIntent.getCharSequenceExtra("kRemark");
      Object localObject3 = paramIntent.getStringExtra("kPoiName");
      paramIntent = paramIntent.getStringArrayListExtra("kTags");
      this.workerHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107008);
          FavoriteIndexUI.this.tcY = true;
          double d1 = d1;
          double d2 = paramInt1;
          int i = this.tgC;
          Object localObject2 = this.mFe;
          Object localObject1 = paramIntent;
          String str = this.tgE;
          ArrayList localArrayList = this.tgF;
          ams localams = new ams();
          localams.bgW((String)localObject2);
          localams.C(d1);
          localams.B(d2);
          localams.aji(i);
          localams.bgX(str);
          localObject2 = new com.tencent.mm.plugin.fav.a.g();
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 6;
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
          ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(localams);
          if ((localObject1 != null) && (!Util.isNullOrNil(((CharSequence)localObject1).toString())))
          {
            ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bhc(((CharSequence)localObject1).toString());
            ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.My(Util.nowMilliSecond());
            com.tencent.mm.plugin.report.service.h.CyF.a(10873, new Object[] { Integer.valueOf(6) });
          }
          k.G((com.tencent.mm.plugin.fav.a.g)localObject2);
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.plugin.fav.a.g)localObject2).arS((String)((Iterator)localObject1).next());
            }
          }
          b.C((com.tencent.mm.plugin.fav.a.g)localObject2);
          com.tencent.mm.plugin.report.service.h.CyF.a(10648, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
          com.tencent.mm.plugin.fav.a.b.DN(((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId);
          long l = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId;
          localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.LwQ != null)) {
            com.tencent.mm.plugin.fav.a.b.a(l, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.LwQ, "", "", new ArrayList(), FavoriteIndexUI.this.getContext());
          }
          AppMethodBeat.o(107008);
        }
      });
      paramInt1 = 0;
      continue;
      paramIntent = paramIntent.getStringExtra("choosed_file_path");
      if (Util.isNullOrNil(paramIntent))
      {
        paramInt1 = 1;
      }
      else
      {
        localObject1 = new com.tencent.mm.vfs.o(paramIntent);
        if (!((com.tencent.mm.vfs.o)localObject1).exists())
        {
          paramInt1 = 1;
        }
        else if (((com.tencent.mm.vfs.o)localObject1).length() >= ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(true))
        {
          paramInt1 = 4;
        }
        else
        {
          if (Util.isNullOrNil(paramIntent)) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 == 0) {
              break label1069;
            }
            paramInt1 = 0;
            this.tcY = true;
            break;
            localObject1 = new com.tencent.mm.vfs.o(paramIntent);
            if (!((com.tencent.mm.vfs.o)localObject1).exists())
            {
              paramInt1 = 0;
            }
            else
            {
              localObject2 = new com.tencent.mm.plugin.fav.a.g();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 8;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
              k.G((com.tencent.mm.plugin.fav.a.g)localObject2);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bhd(((com.tencent.mm.vfs.o)localObject1).getName());
              localObject3 = new aml();
              ((aml)localObject3).bgt(paramIntent);
              ((aml)localObject3).At(true);
              ((aml)localObject3).bgf(((com.tencent.mm.vfs.o)localObject1).getName());
              ((aml)localObject3).ajd(((com.tencent.mm.plugin.fav.a.g)localObject2).field_type);
              ((aml)localObject3).bgp(com.tencent.mm.vfs.s.akC(paramIntent));
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ppH.add(localObject3);
              b.C((com.tencent.mm.plugin.fav.a.g)localObject2);
              com.tencent.mm.plugin.report.service.h.CyF.a(10648, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
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
          paramInt1 = this.tgs.p(l, "");
          if (-1 == paramInt1)
          {
            AppMethodBeat.o(107040);
            return;
          }
          this.tdb.removeFooterView(this.tdc);
          this.tdb.setSelection(paramInt1);
          AppMethodBeat.o(107040);
          return;
          localObject1 = this.tgs.mE(false);
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
                localObject2 = com.tencent.mm.ui.base.h.a(getContext(), "", false, null);
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(107004);
                    FavoriteIndexUI.b(this.tdE, paramIntent);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107002);
                        FavoriteIndexUI.6.this.tcT.dismiss();
                        AppMethodBeat.o(107002);
                      }
                      
                      public final String toString()
                      {
                        AppMethodBeat.i(107003);
                        String str = super.toString() + "|batchAddFavTags";
                        AppMethodBeat.o(107003);
                        return str;
                      }
                    });
                    AppMethodBeat.o(107004);
                  }
                });
                com.tencent.mm.plugin.report.service.h.CyF.a(11125, new Object[] { Integer.valueOf(paramIntent.length), Integer.valueOf(2) });
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                Log.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                f(this.tgs.mE(false), (String)localObject1, paramIntent);
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                Log.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                localObject2 = new ArrayList();
                ((List)localObject2).add(this.teh);
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
      com.tencent.mm.ui.base.h.cD(getContext(), getString(2131759208));
      AppMethodBeat.o(107040);
      return;
    }
    if (3 == paramInt1)
    {
      Toast.makeText(getContext(), getString(2131759350), 1).show();
      AppMethodBeat.o(107040);
      return;
    }
    if (4 == paramInt1)
    {
      Toast.makeText(getContext(), getString(2131759351, new Object[] { Integer.valueOf(((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(true)) }), 1).show();
      AppMethodBeat.o(107040);
      return;
    }
    if (this.tgs.thl) {
      cVM();
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
    this.tdh = this;
    Log.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
    super.onCreate(paramBundle);
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUP() == null)
    {
      Log.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
      finish();
      AppMethodBeat.o(107025);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().mx(false);
    setMMTitle(2131759236);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106993);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).thl)
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
    this.tdb.setOnItemLongClickListener(this.tej);
    this.tdb.setOnTouchListener(new FavoriteIndexUI.12(this));
    com.tencent.mm.kernel.g.azz().a(438, this.tgu);
    com.tencent.mm.kernel.g.azz().a(401, this.tgu);
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(this);
    addIconOptionMenu(11, 2131759142, 2131689491, new FavoriteIndexUI.3(this));
    this.tei = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.tei.dQ(findViewById(2131300459));
    this.tei.tmy = new b.a()
    {
      public final void cVF()
      {
        AppMethodBeat.i(107000);
        com.tencent.mm.ui.base.h.a(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.this.getString(2131759175), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106998);
            paramAnonymous2DialogInterface = FavoriteIndexUI.a(FavoriteIndexUI.this).mE(true);
            p.a(FavoriteIndexUI.this.getContext(), paramAnonymous2DialogInterface, null);
            com.tencent.mm.plugin.report.service.h.CyF.a(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
            if (FavoriteIndexUI.a(FavoriteIndexUI.this).thl) {
              FavoriteIndexUI.b(FavoriteIndexUI.this);
            }
            AppMethodBeat.o(106998);
          }
        }, null);
        AppMethodBeat.o(107000);
      }
      
      public final void cVS()
      {
        AppMethodBeat.i(106999);
        if (!FavoriteIndexUI.a(FavoriteIndexUI.a(FavoriteIndexUI.this).mE(false), FavoriteIndexUI.this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106997);
            FavoriteIndexUI.a(FavoriteIndexUI.this.getContext(), 4105, FavoriteIndexUI.a(FavoriteIndexUI.this), FavoriteIndexUI.g(FavoriteIndexUI.this));
            AppMethodBeat.o(106997);
          }
        }))
        {
          AppMethodBeat.o(106999);
          return;
        }
        FavoriteIndexUI.a(FavoriteIndexUI.this.getContext(), 4105, FavoriteIndexUI.a(FavoriteIndexUI.this), FavoriteIndexUI.g(FavoriteIndexUI.this));
        AppMethodBeat.o(106999);
      }
      
      public final void cVT()
      {
        AppMethodBeat.i(107001);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).cWp() <= 0)
        {
          AppMethodBeat.o(107001);
          return;
        }
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).cWp() > 1)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_fav_scene", 3);
          com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", (Intent)localObject, 4104);
          com.tencent.mm.plugin.fav.a.i.arT("FavTagEditUI");
          AppMethodBeat.o(107001);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.fav.a.g)FavoriteIndexUI.a(FavoriteIndexUI.this).mE(false).get(0);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_fav_scene", 3);
        localIntent.putExtra("key_fav_item_id", ((com.tencent.mm.plugin.fav.a.g)localObject).field_localId);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", localIntent);
        com.tencent.mm.plugin.fav.a.i.arT("FavTagEditUI");
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).thl) {
          FavoriteIndexUI.b(FavoriteIndexUI.this);
        }
        AppMethodBeat.o(107001);
      }
    };
    com.tencent.mm.kernel.g.aAk().postToWorker(new FavoriteIndexUI.16(this));
    com.tencent.mm.plugin.fav.a.d.cUs().a(null);
    e.cVJ();
    com.tencent.mm.plugin.fav.a.i.start();
    com.tencent.mm.pluginsdk.h.a(this, getContentView());
    AppMethodBeat.o(107025);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(107042);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131766796);
    localMenuItem.setIcon(ar.m(getContext(), 2131689496, getResources().getColor(2131099746)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(107042);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107027);
    super.onDestroy();
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUP() == null)
    {
      AppMethodBeat.o(107027);
      return;
    }
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().mx(true);
    if (this.tgs != null) {
      this.tgs.finish();
    }
    oc localoc = new oc();
    localoc.dUe.type = 12;
    EventCenter.instance.publish(localoc);
    com.tencent.mm.kernel.g.azz().b(438, this.tgu);
    com.tencent.mm.kernel.g.azz().b(401, this.tgu);
    com.tencent.mm.plugin.fav.a.i.end();
    e.cVI();
    AppMethodBeat.o(107027);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107030);
    switch (this.tgr)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107030);
      return;
      if (this.tgs != null)
      {
        this.tgs.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = (b.b)paramView.getTag();
        if (paramAdapterView == null)
        {
          Log.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
          AppMethodBeat.o(107030);
          return;
        }
        if (paramAdapterView.tbr == null)
        {
          Log.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
          AppMethodBeat.o(107030);
          return;
        }
        Log.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[] { Integer.valueOf(paramAdapterView.tbr.field_type) });
        com.tencent.mm.plugin.report.service.h.CyF.a(12746, new Object[] { Integer.valueOf(paramAdapterView.tbr.field_type), Integer.valueOf(0), Integer.valueOf(paramInt - 1) });
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107028);
    if ((4 == paramInt) && (this.tgs.thl))
    {
      cVM();
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
      p.a(getContext(), this.tgs.thl, paramMenuItem);
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
    com.tencent.mm.plugin.fav.a.i.arU(getClass().getSimpleName());
    AppMethodBeat.o(107036);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(107044);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(107044);
      return;
    }
    Log.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
        BackwardSupportUtil.AnimationHelper.overridePendingTransition(this, 0, 0);
        AppMethodBeat.o(107044);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763876), "", getString(2131762043), getString(2131755761), false, new FavoriteIndexUI.11(this), new FavoriteIndexUI.13(this));
      AppMethodBeat.o(107044);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = new Intent();
        paramArrayOfString.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
        paramArrayOfString.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
        paramArrayOfString.putExtra("map_view_type", 3);
        com.tencent.mm.br.c.b(this, "location", ".ui.RedirectUI", paramArrayOfString, 4097);
        AppMethodBeat.o(107044);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763874), "", getString(2131762043), getString(2131755761), false, new FavoriteIndexUI.14(this), new FavoriteIndexUI.15(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107035);
    long l = System.currentTimeMillis();
    super.onResume();
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106994);
        if (FavoriteIndexUI.this.tde != null) {
          FavoriteIndexUI.this.tde.cWR();
        }
        AppMethodBeat.o(106994);
      }
    });
    Log.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    com.tencent.mm.plugin.fav.a.i.arT(getClass().getSimpleName());
    AppMethodBeat.o(107035);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI
 * JD-Core Version:    0.7.0.1
 */