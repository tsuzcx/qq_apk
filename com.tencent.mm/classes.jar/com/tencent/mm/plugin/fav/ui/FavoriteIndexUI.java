package com.tencent.mm.plugin.fav.ui;

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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.c;
import com.tencent.mm.plugin.fav.a.n.d;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.adapter.a.a;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.plugin.fav.ui.d.b.c;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI
  extends FavBaseUI
  implements b.c, c.a
{
  private int[] AgN;
  private g AgO;
  private g AgP;
  private com.tencent.mm.plugin.fav.ui.widget.b AgQ;
  private AdapterView.OnItemLongClickListener AgR;
  private int Aje;
  private com.tencent.mm.plugin.fav.ui.adapter.b Ajf;
  private int Ajg;
  private com.tencent.mm.am.h Ajh;
  private com.tencent.mm.ui.tools.l contextMenuHelper;
  private View.OnClickListener fhU;
  private long startTime;
  
  public FavoriteIndexUI()
  {
    AppMethodBeat.i(107024);
    this.Aje = 0;
    this.startTime = 0L;
    this.Ajg = 0;
    this.AgN = new int[2];
    this.Ajh = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(107016);
        Log.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
        FavoriteIndexUI.this.AfK.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107015);
            FavoriteIndexUI.this.AfK.dSP();
            AppMethodBeat.o(107015);
          }
        });
        AppMethodBeat.o(107016);
      }
    };
    this.AgR = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(107018);
        if (paramAnonymousInt < FavoriteIndexUI.this.AfH.getHeaderViewsCount())
        {
          Log.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
          AppMethodBeat.o(107018);
          return true;
        }
        FavoriteIndexUI.a(FavoriteIndexUI.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLong, FavoriteIndexUI.c(FavoriteIndexUI.this));
        AppMethodBeat.o(107018);
        return true;
      }
    };
    this.fhU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106996);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_fav_search_from", 0);
        paramAnonymousView.putExtra("key_preset_search_type", i);
        o.b(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.a(FavoriteIndexUI.this).Ake, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavoriteIndexUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(106996);
      }
    };
    AppMethodBeat.o(107024);
  }
  
  public static boolean a(List<g> paramList, Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(107047);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(107047);
      return true;
    }
    int i2 = 0;
    int i3 = 0;
    int m = 0;
    int j = 0;
    int n = 0;
    new com.tencent.mm.plugin.fav.a.k();
    Iterator localIterator1 = paramList.iterator();
    int i = 0;
    int i1 = 0;
    g localg;
    int k;
    int i4;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localg = (g)localIterator1.next();
        if ((localg != null) && (localg.field_favProto != null) && (localg.field_favProto.vEn != null)) {
          if (localg.field_type == 3)
          {
            m += 1;
          }
          else if ((localg.field_type == 19) && (b.a(localg.field_favProto.ZAw)))
          {
            n += 1;
          }
          else if ((localg.field_type == 5) && (m.a(localg.field_favProto.ZAj)))
          {
            i1 += 1;
          }
          else
          {
            Iterator localIterator2 = localg.field_favProto.vEn.iterator();
            k = 0;
            while (localIterator2.hasNext())
            {
              arf localarf = (arf)localIterator2.next();
              if (localarf.ZzM == 2) {
                i2 += 1;
              } else if (localarf.ZzM == 1) {
                i3 += 1;
              } else {
                k += 1;
              }
            }
            if (!com.tencent.mm.plugin.fav.a.k.v(localg)) {
              break label763;
            }
            int i5 = j + 1;
            j = i5;
            i4 = k;
            if (k > 0)
            {
              i4 = k - 1;
              j = i5;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (i4 == localg.field_favProto.vEn.size())) {
        i = 1;
      }
      for (;;)
      {
        break;
        if (1 == paramList.size())
        {
          if ((((g)paramList.get(0)).field_type == 14) && ((i2 > 0) || (i3 > 0)))
          {
            com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.favorite_detail_illegal_trans_big_expired));
            AppMethodBeat.o(107047);
            return false;
          }
          if (i2 > 0)
          {
            i = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavSizeLimitInMB(true, ((g)paramList.get(0)).field_type);
            com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.favorite_detail_illegal_trans_big_file_format, new Object[] { Integer.valueOf(i) }));
            AppMethodBeat.o(107047);
            return false;
          }
          if (i3 > 0)
          {
            switch (((g)paramList.get(0)).field_type)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(107047);
              return false;
              com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.favorite_detail_illegal_trans_file));
              continue;
              com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.favorite_detail_illegal_trans_image));
              continue;
              com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.favorite_detail_illegal_trans_video));
            }
          }
          if (j > 0)
          {
            com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.Fav_NotDownload_CannotForward));
            AppMethodBeat.o(107047);
            return false;
          }
          if (m > 0)
          {
            com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.Fav_Voice_CannotForward));
            AppMethodBeat.o(107047);
            return false;
          }
          if (n > 0)
          {
            com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.Fav_AppBrand_CannotForward));
            AppMethodBeat.o(107047);
            return false;
          }
          if (i1 > 0)
          {
            com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.Fav_WebPage_CannotForward));
            AppMethodBeat.o(107047);
            return false;
          }
        }
        else if ((i2 > 0) || (i3 > 0) || (j > 0) || (m > 0) || (n > 0) || (i1 > 0))
        {
          if (i != 0) {
            com.tencent.mm.ui.base.k.a(paramContext, paramContext.getString(q.i.favorite_detail_illegal_transmay_tips_yes), "", paramContext.getString(q.i.confirm_dialog_ok), paramContext.getString(q.i.confirm_dialog_cancel), paramOnClickListener, null, q.b.wechat_green);
          }
          for (;;)
          {
            AppMethodBeat.o(107047);
            return false;
            com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getString(q.i.favorite_detail_illegal_transmay_tips_no));
          }
        }
        AppMethodBeat.o(107047);
        return true;
      }
      label763:
      i4 = k;
    }
  }
  
  public static void b(List<g> paramList, String[] paramArrayOfString)
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
      g localg = (g)paramList.next();
      int j = paramArrayOfString.length;
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= localg.atZ(paramArrayOfString[i]);
        i += 1;
      }
      if (bool)
      {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        com.tencent.mm.plugin.fav.a.b.p(localg);
        localLinkedList.add(localg);
      }
    }
    paramList = localLinkedList.iterator();
    while (paramList.hasNext()) {
      com.tencent.mm.plugin.fav.a.b.a((g)paramList.next(), 3);
    }
    AppMethodBeat.o(107046);
  }
  
  private void dRI()
  {
    AppMethodBeat.i(107029);
    this.Ajf.a(false, null);
    this.AfH.setOnItemLongClickListener(this.AgR);
    showOptionMenu(11, true);
    this.AgQ.hide();
    AppMethodBeat.o(107029);
  }
  
  private void e(final List<g> paramList, String paramString1, String paramString2)
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
    boolean bool = au.bwE(paramString2);
    Object localObject1 = new com.tencent.mm.plugin.fav.a.k();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      g localg = (g)((Iterator)localObject2).next();
      if (!((com.tencent.mm.plugin.fav.a.k)localObject1).u(localg))
      {
        com.tencent.mm.plugin.fav.a.h.b(localg.field_localId, 1, 0, this.Ajg);
        localLinkedList.add(localg);
        label137:
        n.d locald;
        if (bool)
        {
          paramList = n.c.Ado;
          locald = n.d.Adr;
          if (!bool) {
            break label173;
          }
        }
        label173:
        for (int i = v.getMembersCountByChatRoomName(paramString2);; i = 0)
        {
          n.a(paramList, localg, locald, i);
          break;
          paramList = n.c.Adn;
          break label137;
        }
      }
    }
    if (localLinkedList.isEmpty())
    {
      Log.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
      paramList = getString(q.i.favorite_retransmit_tip);
      com.tencent.mm.ui.base.k.cZ(getApplicationContext(), paramList);
      AppMethodBeat.o(107038);
      return;
    }
    paramList = com.tencent.mm.ui.base.k.a(getContext(), getString(q.i.favorite_forward_tips), false, null);
    l.a(getContext(), paramString2, paramString1, localLinkedList, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107005);
        paramList.dismiss();
        com.tencent.mm.ui.widget.snackbar.b.u(FavoriteIndexUI.this, FavoriteIndexUI.this.getString(q.i.fav_finish_sent));
        AppMethodBeat.o(107005);
      }
    });
    paramString2 = new LinkedList();
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (g)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((g)localObject2).field_type == 5))
      {
        paramList = "";
        if (((g)localObject2).field_favProto.ZAj != null) {
          paramList = ((g)localObject2).field_favProto.ZAj.ZBV;
        }
        paramString1 = paramList;
        if (((g)localObject2).field_favProto.ZBt != null)
        {
          paramString1 = paramList;
          if (Util.isNullOrNil(paramList)) {
            paramString1 = ((g)localObject2).field_favProto.ZBt.link;
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
        com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { paramList, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
        continue;
      }
      if ((localObject2 != null) && (((g)localObject2).field_type == 20))
      {
        paramList = ((g)localObject2).field_favProto.ZAB;
        paramString2.add(new Pair(paramList.objectId, paramList.objectNonceId));
      }
    }
    if (paramString2.size() > 0) {
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).shareStatsReport(paramString2, false);
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(11125, new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(1) });
    AppMethodBeat.o(107038);
  }
  
  protected final void dRA()
  {
    AppMethodBeat.i(107026);
    super.dRA();
    this.mRi.post(new FavoriteIndexUI.18(this));
    AppMethodBeat.o(107026);
  }
  
  public final com.tencent.mm.plugin.fav.ui.adapter.a dRv()
  {
    AppMethodBeat.i(107031);
    if (this.Ajf == null)
    {
      getContext();
      this.Ajf = new com.tencent.mm.plugin.fav.ui.adapter.b(this.AfM, false);
      this.Ajf.a(new a.a()
      {
        public final void dSb()
        {
          AppMethodBeat.i(107022);
          FavoriteIndexUI.this.AfK.px(true);
          AppMethodBeat.o(107022);
        }
      });
      this.Ajf.Akl = this;
      this.Ajf.scene = 1;
      this.Ajf.Ako = this.AfH;
    }
    com.tencent.mm.plugin.fav.ui.adapter.b localb = this.Ajf;
    AppMethodBeat.o(107031);
    return localb;
  }
  
  protected final void dRw()
  {
    AppMethodBeat.i(107032);
    this.AfK.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107023);
        FavoriteIndexUI.this.AfK.dSP();
        AppMethodBeat.o(107023);
      }
    });
    AppMethodBeat.o(107032);
  }
  
  protected final boolean dRx()
  {
    AppMethodBeat.i(107033);
    switch (this.Aje)
    {
    }
    for (int i = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().getCount(); i > 0; i = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQG())
    {
      AppMethodBeat.o(107033);
      return true;
    }
    AppMethodBeat.o(107033);
    return false;
  }
  
  protected final void dRy()
  {
    AppMethodBeat.i(107034);
    switch (this.Aje)
    {
    default: 
      this.njO.setCompoundDrawablesWithIntrinsicBounds(0, q.d.favorites_empty_favorites_icon, 0, 0);
      this.njO.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 10));
      this.njO.setText(q.i.favorite_empty_fav);
      AppMethodBeat.o(107034);
      return;
    }
    this.njO.setCompoundDrawablesWithIntrinsicBounds(0, q.h.fav_list_img_default, 0, 0);
    this.njO.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 10));
    this.njO.setText(q.i.favorite_empty_fav_img);
    AppMethodBeat.o(107034);
  }
  
  protected final View.OnClickListener dRz()
  {
    return this.fhU;
  }
  
  public final void dSa()
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
    this.AfK.px(false);
    AppMethodBeat.o(107037);
  }
  
  public final void mO(long paramLong)
  {
    AppMethodBeat.i(107041);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.Ajf.Ake)
    {
      localb = this.AgQ;
      if (this.Ajf.dSm() <= 0) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.hH(bool);
      AppMethodBeat.o(107041);
      return;
    }
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
        if (((this.AgP != null) && (this.AgP.field_type == 5)) || ((this.AgO != null) && (this.AgO.field_type == 5)))
        {
          localObject1 = "";
          if ((this.AgO == null) || (this.AgO.field_favProto.ZBt == null)) {
            break label278;
          }
          paramIntent = this.AgO.field_favProto.ZBt.link;
          label142:
          if (!Util.isNullOrNil(paramIntent)) {
            Log.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          }
        }
        try
        {
          paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
          com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          AppMethodBeat.o(107040);
          return;
          i.aub(".ui.transmit.SelectConversationUI");
          continue;
          label278:
          if (this.AgP.field_favProto.ZAj != null) {
            localObject1 = this.AgP.field_favProto.ZAj.ZBV;
          }
          paramIntent = (Intent)localObject1;
          if (this.AgP.field_favProto.ZBt == null) {
            break label142;
          }
          paramIntent = (Intent)localObject1;
          if (!Util.isNullOrNil((String)localObject1)) {
            break label142;
          }
          paramIntent = this.AgP.field_favProto.ZBt.link;
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
      com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.favorite_ok));
      AppMethodBeat.o(107040);
      return;
      paramInt1 = 0;
      this.AfE = true;
      continue;
      paramIntent = t.g(getApplicationContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
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
          FavoriteIndexUI.this.AfE = true;
          k.fJ(this.Ajm);
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
          FavoriteIndexUI.this.AfE = true;
          k.fJ(paramIntent);
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
          FavoriteIndexUI.this.AfE = true;
          double d1 = d1;
          double d2 = paramInt1;
          int i = this.Ajp;
          Object localObject2 = this.sJB;
          Object localObject1 = paramIntent;
          String str = this.Ajr;
          ArrayList localArrayList = this.Ajs;
          arm localarm = new arm();
          localarm.btf((String)localObject2);
          localarm.W(d1);
          localarm.V(d2);
          localarm.axD(i);
          localarm.btg(str);
          localObject2 = new g();
          ((g)localObject2).field_type = 6;
          ((g)localObject2).field_sourceType = 6;
          ((g)localObject2).field_favProto.d(localarm);
          if ((localObject1 != null) && (!Util.isNullOrNil(((CharSequence)localObject1).toString())))
          {
            ((g)localObject2).field_favProto.btl(((CharSequence)localObject1).toString());
            ((g)localObject2).field_favProto.ys(Util.nowMilliSecond());
            com.tencent.mm.plugin.report.service.h.OAn.b(10873, new Object[] { Integer.valueOf(6) });
          }
          k.G((g)localObject2);
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((g)localObject2).atZ((String)((Iterator)localObject1).next());
            }
          }
          a.C((g)localObject2);
          com.tencent.mm.plugin.report.service.h.OAn.b(10648, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
          com.tencent.mm.plugin.fav.a.b.mz(((g)localObject2).field_localId);
          long l = ((g)localObject2).field_localId;
          localObject1 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(l);
          if ((localObject1 != null) && (((g)localObject1).field_favProto.ZAh != null)) {
            com.tencent.mm.plugin.fav.a.b.a(l, ((g)localObject1).field_favProto.ZAh, "", "", new ArrayList(), FavoriteIndexUI.this.getContext());
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
        localObject1 = new u(paramIntent);
        if (!((u)localObject1).jKS())
        {
          paramInt1 = 1;
        }
        else if (((u)localObject1).length() >= ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimit(true))
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
              break label1068;
            }
            paramInt1 = 0;
            this.AfE = true;
            break;
            localObject1 = new u(paramIntent);
            if (!((u)localObject1).jKS())
            {
              paramInt1 = 0;
            }
            else
            {
              localObject2 = new g();
              ((g)localObject2).field_type = 8;
              ((g)localObject2).field_sourceType = 6;
              k.G((g)localObject2);
              ((g)localObject2).field_favProto.btm(((u)localObject1).getName());
              localObject3 = new arf();
              ((arf)localObject3).bsC(paramIntent);
              ((arf)localObject3).Kk(true);
              ((arf)localObject3).bso(((u)localObject1).getName());
              ((arf)localObject3).axy(((g)localObject2).field_type);
              ((arf)localObject3).bsy(com.tencent.mm.vfs.y.alV(paramIntent));
              ((g)localObject2).field_favProto.vEn.add(localObject3);
              a.C((g)localObject2);
              com.tencent.mm.plugin.report.service.h.OAn.b(10648, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
              paramInt1 = 1;
            }
          }
          label1068:
          paramInt1 = 1;
          continue;
          long l = paramIntent.getLongExtra("key_fav_result_local_id", -1L);
          if (-1L == l)
          {
            AppMethodBeat.o(107040);
            return;
          }
          paramInt1 = this.Ajf.A(l, "");
          if (-1 == paramInt1)
          {
            AppMethodBeat.o(107040);
            return;
          }
          this.AfH.removeFooterView(this.AfI);
          this.AfH.setSelection(paramInt1);
          AppMethodBeat.o(107040);
          return;
          localObject1 = this.Ajf.ps(false);
          paramIntent = paramIntent.getStringArrayExtra("key_fav_result_array");
          paramInt1 = paramInt2;
          if (localObject1 != null)
          {
            paramInt1 = paramInt2;
            if (!((List)localObject1).isEmpty())
            {
              paramInt1 = paramInt2;
              if (paramIntent != null)
              {
                paramInt1 = paramInt2;
                if (paramIntent.length > 0)
                {
                  localObject2 = com.tencent.mm.ui.base.k.a(getContext(), "", false, null);
                  com.tencent.mm.kernel.h.baH().postToWorker(new FavoriteIndexUI.6(this, (List)localObject1, paramIntent, (Dialog)localObject2));
                  com.tencent.mm.plugin.report.service.h.OAn.b(11125, new Object[] { Integer.valueOf(paramIntent.length), Integer.valueOf(2) });
                  paramInt1 = paramInt2;
                  continue;
                  paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                  Log.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                  e(this.Ajf.ps(false), (String)localObject1, paramIntent);
                  paramInt1 = paramInt2;
                  continue;
                  paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                  Log.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                  localObject2 = new ArrayList();
                  ((List)localObject2).add(this.AgP);
                  e((List)localObject2, (String)localObject1, paramIntent);
                  paramInt1 = paramInt2;
                }
              }
            }
          }
        }
      }
    }
    if (1 == paramInt1)
    {
      com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.favorite_fail));
      AppMethodBeat.o(107040);
      return;
    }
    if (3 == paramInt1)
    {
      Toast.makeText(getContext(), getString(q.i.favorite_too_large), 1).show();
      AppMethodBeat.o(107040);
      return;
    }
    if (4 == paramInt1)
    {
      Toast.makeText(getContext(), getString(q.i.favorite_too_large_format, new Object[] { Integer.valueOf(((ah)com.tencent.mm.kernel.h.az(ah.class)).getFileSizeLimitInMB(true)) }), 1).show();
      AppMethodBeat.o(107040);
      return;
    }
    if (this.Ajf.Ake) {
      dRI();
    }
    AppMethodBeat.o(107040);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(107039);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.h.b(this, getContentView());
    AppMethodBeat.o(107039);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107025);
    this.AfN = this;
    Log.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
    super.onCreate(paramBundle);
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQF() == null)
    {
      Log.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
      finish();
      AppMethodBeat.o(107025);
      return;
    }
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().pk(false);
    setMMTitle(q.i.favorite_index_ui_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106993);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).Ake)
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
    this.AfH.setOnItemLongClickListener(this.AgR);
    this.AfH.setOnTouchListener(new View.OnTouchListener()
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
    com.tencent.mm.kernel.h.aZW().a(438, this.Ajh);
    com.tencent.mm.kernel.h.aZW().a(401, this.Ajh);
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(this);
    addIconOptionMenu(11, q.i.fav_actionbar_title_add_fav, q.h.actionbar_icon_dark_add, new FavoriteIndexUI.3(this));
    this.AgQ = new com.tencent.mm.plugin.fav.ui.widget.b();
    this.AgQ.fj(findViewById(q.e.fav_edit_footer));
    this.AgQ.Apz = new b.a()
    {
      public final void dRB()
      {
        AppMethodBeat.i(107000);
        com.tencent.mm.ui.base.k.a(FavoriteIndexUI.this.getContext(), FavoriteIndexUI.this.getString(q.i.favorite_delete_items_confirm), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(106998);
            paramAnonymous2DialogInterface = FavoriteIndexUI.a(FavoriteIndexUI.this).ps(true);
            o.a(FavoriteIndexUI.this.getContext(), paramAnonymous2DialogInterface, null);
            com.tencent.mm.plugin.report.service.h.OAn.b(11125, new Object[] { Integer.valueOf(paramAnonymous2DialogInterface.size()), Integer.valueOf(3) });
            if (FavoriteIndexUI.a(FavoriteIndexUI.this).Ake) {
              FavoriteIndexUI.b(FavoriteIndexUI.this);
            }
            AppMethodBeat.o(106998);
          }
        }, null);
        AppMethodBeat.o(107000);
      }
      
      public final void dRO()
      {
        AppMethodBeat.i(106999);
        if (!FavoriteIndexUI.a(FavoriteIndexUI.a(FavoriteIndexUI.this).ps(false), FavoriteIndexUI.this, new DialogInterface.OnClickListener()
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
      
      public final void dRP()
      {
        AppMethodBeat.i(107001);
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).dSm() <= 0)
        {
          AppMethodBeat.o(107001);
          return;
        }
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).dSm() > 1)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_fav_scene", 3);
          com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", (Intent)localObject1, 4104);
          i.aua("FavTagEditUI");
          localObject1 = FavoriteIndexUI.a(FavoriteIndexUI.this).ps(false).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((ab)com.tencent.mm.kernel.h.ax(ab.class)).c(Long.valueOf(((g)localObject2).field_localId));
            }
          }
          AppMethodBeat.o(107001);
          return;
        }
        Object localObject1 = (g)FavoriteIndexUI.a(FavoriteIndexUI.this).ps(false).get(0);
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_fav_scene", 3);
        ((Intent)localObject2).putExtra("key_fav_item_id", ((g)localObject1).field_localId);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.getContext(), ".ui.FavTagEditUI", (Intent)localObject2);
        i.aua("FavTagEditUI");
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).Ake) {
          FavoriteIndexUI.b(FavoriteIndexUI.this);
        }
        AppMethodBeat.o(107001);
      }
    };
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107014);
        long l = System.currentTimeMillis();
        List localList = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQM();
        if (localList != null)
        {
          Log.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
          if (localList.size() == 0)
          {
            AppMethodBeat.o(107014);
            return;
          }
          int j = localList.size();
          int i = 0;
          while (i < j)
          {
            ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().A((g)localList.get(i));
            i += 1;
          }
          Log.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        }
        AppMethodBeat.o(107014);
      }
    });
    com.tencent.mm.plugin.fav.a.d.dQj().a(null);
    e.dRF();
    i.start();
    com.tencent.mm.pluginsdk.h.b(this, getContentView());
    AppMethodBeat.o(107025);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(107042);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, q.i.top_item_desc_search);
    localMenuItem.setIcon(bb.m(getContext(), q.h.actionbar_icon_dark_search, getResources().getColor(q.b.FG_0)));
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(107042);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107027);
    super.onDestroy();
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQF() == null)
    {
      AppMethodBeat.o(107027);
      return;
    }
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().pk(true);
    if ((!aw.jkS()) && (!aj.aAy(getTaskId())))
    {
      ql localql = new ql();
      localql.hTy.type = 12;
      localql.publish();
    }
    com.tencent.mm.kernel.h.aZW().b(438, this.Ajh);
    com.tencent.mm.kernel.h.aZW().b(401, this.Ajh);
    i.end();
    e.dRE();
    AppMethodBeat.o(107027);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107030);
    switch (this.Aje)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107030);
      return;
      if (this.Ajf != null)
      {
        this.Ajf.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = (b.b)paramView.getTag();
        if (paramAdapterView == null)
        {
          Log.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
          AppMethodBeat.o(107030);
          return;
        }
        if (paramAdapterView.AdF == null)
        {
          Log.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
          AppMethodBeat.o(107030);
          return;
        }
        Log.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[] { Integer.valueOf(paramAdapterView.AdF.field_type) });
        com.tencent.mm.plugin.report.service.h.OAn.b(12746, new Object[] { Integer.valueOf(paramAdapterView.AdF.field_type), Integer.valueOf(0), Integer.valueOf(paramInt - 1) });
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107028);
    if ((4 == paramInt) && (this.Ajf.Ake))
    {
      dRI();
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
      o.a(getContext(), this.Ajf.Ake, paramMenuItem);
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
    i.aub(getClass().getSimpleName());
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
      com.tencent.mm.ui.base.k.a(this, getString(q.i.permission_microphone_request_again_msg), "", getString(q.i.jump_to_settings), getString(q.i.app_cancel), false, new FavoriteIndexUI.11(this), new FavoriteIndexUI.13(this));
      AppMethodBeat.o(107044);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = new Intent();
        paramArrayOfString.putExtra("MMActivity.OverrideExitAnimation", q.a.push_down_out);
        paramArrayOfString.putExtra("MMActivity.OverrideEnterAnimation", q.a.fast_faded_in);
        paramArrayOfString.putExtra("map_view_type", 3);
        com.tencent.mm.br.c.b(this, "location", ".ui.RedirectUI", paramArrayOfString, 4097);
        AppMethodBeat.o(107044);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(q.i.permission_location_request_again_msg), "", getString(q.i.jump_to_settings), getString(q.i.app_cancel), false, new FavoriteIndexUI.14(this), new FavoriteIndexUI.15(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107035);
    long l = System.currentTimeMillis();
    super.onResume();
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106994);
        if (FavoriteIndexUI.this.AfK != null) {
          FavoriteIndexUI.this.AfK.dSP();
        }
        AppMethodBeat.o(106994);
      }
    });
    Log.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    i.aua(getClass().getSimpleName());
    AppMethodBeat.o(107035);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(274402);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.fav.ui.a.a.class);
    AppMethodBeat.o(274402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI
 * JD-Core Version:    0.7.0.1
 */