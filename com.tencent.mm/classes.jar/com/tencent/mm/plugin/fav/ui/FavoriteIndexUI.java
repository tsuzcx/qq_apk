package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.li;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI
  extends FavBaseUI
  implements a.c, c.a
{
  private static final long myG;
  private View.OnClickListener bTw;
  private l contextMenuHelper;
  private int myH;
  private com.tencent.mm.plugin.fav.ui.a.b myI;
  private com.tencent.mm.plugin.fav.ui.widget.b myJ;
  private com.tencent.mm.plugin.fav.a.g myK;
  private int[] myL;
  private f myM;
  private AdapterView.OnItemLongClickListener myN;
  private com.tencent.mm.plugin.fav.a.g myO;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(74283);
    myG = com.tencent.mm.m.b.MX();
    AppMethodBeat.o(74283);
  }
  
  public FavoriteIndexUI()
  {
    AppMethodBeat.i(74252);
    this.myH = 0;
    this.startTime = 0L;
    this.myL = new int[2];
    this.myM = new FavoriteIndexUI.18(this);
    this.myN = new FavoriteIndexUI.20(this);
    this.bTw = new FavoriteIndexUI.4(this);
    AppMethodBeat.o(74252);
  }
  
  private void S(Intent paramIntent)
  {
    AppMethodBeat.i(74271);
    Bundle localBundle = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localBundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
    }
    if (this.myI.mzp)
    {
      paramIntent.putExtra("key_search_type", 2);
      com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavSearchUI", paramIntent, 4103, localBundle);
      AppMethodBeat.o(74271);
      return;
    }
    com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavSearchUI", paramIntent, localBundle);
    AppMethodBeat.o(74271);
  }
  
  public static void a(List<com.tencent.mm.plugin.fav.a.g> paramList, String[] paramArrayOfString)
  {
    AppMethodBeat.i(74274);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(74274);
      return;
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      AppMethodBeat.o(74274);
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
        bool |= localg.NH(paramArrayOfString[i]);
        i += 1;
      }
      if (bool)
      {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        com.tencent.mm.plugin.fav.a.b.p(localg);
        localLinkedList.add(localg);
      }
    }
    paramList = localLinkedList.iterator();
    while (paramList.hasNext()) {
      com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)paramList.next(), 3);
    }
    AppMethodBeat.o(74274);
  }
  
  public static boolean a(List<com.tencent.mm.plugin.fav.a.g> paramList, Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(74275);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(74275);
      return true;
    }
    int n = 0;
    int i1 = 0;
    int m = 0;
    new k();
    Iterator localIterator1 = paramList.iterator();
    int i = 0;
    int j = 0;
    com.tencent.mm.plugin.fav.a.g localg;
    int k;
    int i2;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localIterator1.next();
        if ((localg != null) && (localg.field_favProto != null) && (localg.field_favProto.wVc != null)) {
          if (localg.field_type == 3)
          {
            m += 1;
          }
          else
          {
            Iterator localIterator2 = localg.field_favProto.wVc.iterator();
            k = 0;
            while (localIterator2.hasNext())
            {
              aca localaca = (aca)localIterator2.next();
              if (localaca.wTK == 2) {
                n += 1;
              } else if (localaca.wTK == 1) {
                i1 += 1;
              } else {
                k += 1;
              }
            }
            if (!k.u(localg)) {
              break label603;
            }
            int i3 = j + 1;
            j = i3;
            i2 = k;
            if (k > 0)
            {
              i2 = k - 1;
              j = i3;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (i2 == localg.field_favProto.wVc.size())) {
        i = 1;
      }
      for (;;)
      {
        break;
        if (1 == paramList.size())
        {
          if ((((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type == 14) && ((n > 0) || (i1 > 0)))
          {
            com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131299693));
            AppMethodBeat.o(74275);
            return false;
          }
          if (n > 0)
          {
            com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131299694));
            AppMethodBeat.o(74275);
            return false;
          }
          if (i1 > 0)
          {
            switch (((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(74275);
              return false;
              com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131299695));
              continue;
              com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131299696));
              continue;
              com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131299697));
            }
          }
          if (j > 0)
          {
            com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131296330));
            AppMethodBeat.o(74275);
            return false;
          }
          if (m > 0)
          {
            com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131296331));
            AppMethodBeat.o(74275);
            return false;
          }
        }
        else if ((n > 0) || (i1 > 0) || (j > 0) || (m > 0))
        {
          if (i != 0) {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131299699), "", paramContext.getString(2131298501), paramContext.getString(2131298499), paramOnClickListener, null, 2131690701);
          }
          for (;;)
          {
            AppMethodBeat.o(74275);
            return false;
            com.tencent.mm.ui.base.h.bO(paramContext, paramContext.getString(2131299698));
          }
        }
        AppMethodBeat.o(74275);
        return true;
      }
      label603:
      i2 = k;
    }
  }
  
  private void b(List<com.tencent.mm.plugin.fav.a.g> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(74266);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(74266);
      return;
    }
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(74266);
      return;
    }
    boolean bool = t.lA(paramString2);
    Object localObject = new k();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (!((k)localObject).t(localg))
      {
        com.tencent.mm.plugin.fav.a.h.i(localg.field_localId, 1, 0);
        localLinkedList.add(localg);
        label133:
        m.d locald;
        if (bool)
        {
          paramList = m.c.mtN;
          locald = m.d.mtQ;
          if (!bool) {
            break label169;
          }
        }
        label169:
        for (int i = com.tencent.mm.model.n.nv(paramString2);; i = 0)
        {
          m.a(paramList, localg, locald, i);
          break;
          paramList = m.c.mtM;
          break label133;
        }
      }
    }
    if (localLinkedList.isEmpty())
    {
      ab.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
      paramList = getString(2131299813);
      com.tencent.mm.ui.base.h.bO(getApplicationContext(), paramList);
      AppMethodBeat.o(74266);
      return;
    }
    paramList = com.tencent.mm.ui.base.h.b(getContext(), getString(2131299734), false, null);
    i.a(getContext(), paramString2, paramString1, localLinkedList, new FavoriteIndexUI.8(this, paramList));
    paramString2 = localLinkedList.iterator();
    for (;;)
    {
      if (!paramString2.hasNext()) {
        break label505;
      }
      localObject = (com.tencent.mm.plugin.fav.a.g)paramString2.next();
      if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_type == 5))
      {
        paramList = "";
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.wUf != null) {
          paramList = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.wUf.wVF;
        }
        paramString1 = paramList;
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.wVa != null)
        {
          paramString1 = paramList;
          if (bo.isNullOrNil(paramList)) {
            paramString1 = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.wVa.link;
          }
        }
        if (!bo.isNullOrNil(paramString1))
        {
          ab.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramString1, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
          paramList = "";
        }
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramList = paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramString1, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { paramList, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
    }
    label505:
    com.tencent.mm.plugin.report.service.h.qsU.e(11125, new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(1) });
    AppMethodBeat.o(74266);
  }
  
  private void bxH()
  {
    AppMethodBeat.i(74257);
    this.myI.a(false, null);
    this.mvw.setOnItemLongClickListener(this.myN);
    showOptionMenu(11, true);
    this.myJ.hide();
    AppMethodBeat.o(74257);
  }
  
  public final void bxI()
  {
    AppMethodBeat.i(74273);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_enter_fav_cleanui_from", 0);
    com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavCleanUI", localIntent);
    AppMethodBeat.o(74273);
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a bxl()
  {
    AppMethodBeat.i(74259);
    if (this.myI == null)
    {
      getContext();
      this.myI = new com.tencent.mm.plugin.fav.ui.a.b(this.mvC, false);
      this.myI.a(new FavoriteIndexUI.23(this));
      this.myI.mzw = this;
      this.myI.scene = 1;
      this.myI.mzz = this.mvw;
    }
    com.tencent.mm.plugin.fav.ui.a.b localb = this.myI;
    AppMethodBeat.o(74259);
    return localb;
  }
  
  protected final void bxm()
  {
    AppMethodBeat.i(74260);
    this.mvA.post(new FavoriteIndexUI.24(this));
    AppMethodBeat.o(74260);
  }
  
  protected final boolean bxn()
  {
    AppMethodBeat.i(74261);
    switch (this.myH)
    {
    }
    for (int i = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().getCount(); i > 0; i = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwJ())
    {
      AppMethodBeat.o(74261);
      return true;
    }
    AppMethodBeat.o(74261);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  protected final void bxo()
  {
    AppMethodBeat.i(74262);
    switch (this.myH)
    {
    default: 
      this.mvx.setCompoundDrawablesWithIntrinsicBounds(0, 2130838832, 0, 0);
      this.mvx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
      this.mvx.setText(2131299706);
      AppMethodBeat.o(74262);
      return;
    }
    this.mvx.setCompoundDrawablesWithIntrinsicBounds(0, 2131231298, 0, 0);
    this.mvx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
    this.mvx.setText(2131299707);
    AppMethodBeat.o(74262);
  }
  
  protected final View.OnClickListener bxp()
  {
    return this.bTw;
  }
  
  protected final void bxq()
  {
    AppMethodBeat.i(74254);
    super.bxq();
    this.faV.post(new FavoriteIndexUI.19(this));
    AppMethodBeat.o(74254);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(74265);
    super.initHeaderView();
    this.mvA.hE(false);
    AppMethodBeat.o(74265);
  }
  
  public final void kf(long paramLong)
  {
    AppMethodBeat.i(74268);
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.myI.mzp)
    {
      localb = this.myJ;
      if (this.myI.bxS() <= 0) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      if (localb.mDP)
      {
        localb.mDU.setEnabled(bool);
        localb.mDV.setEnabled(bool);
        localb.mDW.setEnabled(bool);
      }
      AppMethodBeat.o(74268);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74267);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      ab.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -1)
      {
        if (((this.myO != null) && (this.myO.field_type == 5)) || ((this.myK != null) && (this.myK.field_type == 5)))
        {
          localObject1 = "";
          if ((this.myK == null) || (this.myK.field_favProto.wVa == null)) {
            break label279;
          }
          paramIntent = this.myK.field_favProto.wVa.link;
          label143:
          if (!bo.isNullOrNil(paramIntent)) {
            ab.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          }
        }
        try
        {
          paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
          com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          AppMethodBeat.o(74267);
          return;
          com.tencent.mm.plugin.fav.a.i.NJ(".ui.transmit.SelectConversationUI");
          continue;
          label279:
          if (this.myO.field_favProto.wUf != null) {
            localObject1 = this.myO.field_favProto.wUf.wVF;
          }
          paramIntent = (Intent)localObject1;
          if (this.myO.field_favProto.wVa == null) {
            break label143;
          }
          paramIntent = (Intent)localObject1;
          if (!bo.isNullOrNil((String)localObject1)) {
            break label143;
          }
          paramIntent = this.myO.field_favProto.wVa.link;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramIntent, "", new Object[0]);
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
      com.tencent.mm.ui.base.h.bO(getContext(), getString(2131299764));
      AppMethodBeat.o(74267);
      return;
      paramInt1 = 0;
      this.mvt = true;
      continue;
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.n.h(getApplicationContext(), paramIntent, com.tencent.mm.plugin.i.c.YK());
      if (paramIntent == null)
      {
        ab.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
        AppMethodBeat.o(74267);
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
        ab.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
        AppMethodBeat.o(74267);
        return;
      }
      paramInt1 = 0;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramIntent);
      this.mqF.post(new FavoriteIndexUI.9(this, (ArrayList)localObject1));
      continue;
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if ((paramIntent == null) || (paramIntent.size() == 0))
      {
        ab.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
        AppMethodBeat.o(74267);
        return;
      }
      paramInt1 = 0;
      this.mqF.post(new FavoriteIndexUI.10(this, paramIntent));
      continue;
      double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
      double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
      paramInt1 = paramIntent.getIntExtra("kwebmap_scale", 0);
      localObject1 = bo.bf(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      Object localObject2 = paramIntent.getCharSequenceExtra("kRemark");
      Object localObject3 = paramIntent.getStringExtra("kPoiName");
      paramIntent = paramIntent.getStringArrayListExtra("kTags");
      this.mqF.post(new FavoriteIndexUI.11(this, d1, d2, paramInt1, (String)localObject1, (CharSequence)localObject2, (String)localObject3, paramIntent));
      paramInt1 = 0;
      continue;
      paramIntent = paramIntent.getStringExtra("choosed_file_path");
      if (bo.isNullOrNil(paramIntent))
      {
        paramInt1 = 1;
      }
      else
      {
        localObject1 = new com.tencent.mm.vfs.b(paramIntent);
        if (!((com.tencent.mm.vfs.b)localObject1).exists())
        {
          paramInt1 = 1;
        }
        else if (((com.tencent.mm.vfs.b)localObject1).length() >= myG)
        {
          paramInt1 = 3;
        }
        else
        {
          if (bo.isNullOrNil(paramIntent)) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 == 0) {
              break label1061;
            }
            paramInt1 = 0;
            this.mvt = true;
            break;
            localObject1 = new com.tencent.mm.vfs.b(paramIntent);
            if (!((com.tencent.mm.vfs.b)localObject1).exists())
            {
              paramInt1 = 0;
            }
            else
            {
              localObject2 = new com.tencent.mm.plugin.fav.a.g();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 8;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
              h.E((com.tencent.mm.plugin.fav.a.g)localObject2);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aol(((com.tencent.mm.vfs.b)localObject1).getName());
              localObject3 = new aca();
              ((aca)localObject3).anE(paramIntent);
              ((aca)localObject3).pz(true);
              ((aca)localObject3).anq(((com.tencent.mm.vfs.b)localObject1).getName());
              ((aca)localObject3).MI(((com.tencent.mm.plugin.fav.a.g)localObject2).field_type);
              ((aca)localObject3).anA(e.cP(paramIntent));
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.wVc.add(localObject3);
              b.B((com.tencent.mm.plugin.fav.a.g)localObject2);
              com.tencent.mm.plugin.report.service.h.qsU.e(10648, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
              paramInt1 = 1;
            }
          }
          label1061:
          paramInt1 = 1;
          continue;
          long l = paramIntent.getLongExtra("key_fav_result_local_id", -1L);
          if (-1L == l)
          {
            AppMethodBeat.o(74267);
            return;
          }
          paramInt1 = this.myI.kh(l);
          if (-1 == paramInt1)
          {
            AppMethodBeat.o(74267);
            return;
          }
          this.mvw.removeFooterView(this.mvy);
          this.mvw.setSelection(paramInt1);
          AppMethodBeat.o(74267);
          return;
          localObject1 = this.myI.hB(false);
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
                com.tencent.mm.kernel.g.RO().ac(new FavoriteIndexUI.7(this, (List)localObject1, paramIntent, (Dialog)localObject2));
                com.tencent.mm.plugin.report.service.h.qsU.e(11125, new Object[] { Integer.valueOf(paramIntent.length), Integer.valueOf(2) });
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                ab.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                b(this.myI.hB(false), (String)localObject1, paramIntent);
                paramInt1 = paramInt2;
                continue;
                paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                ab.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                localObject2 = new ArrayList();
                ((List)localObject2).add(this.myO);
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
      com.tencent.mm.ui.base.h.bO(getContext(), getString(2131299712));
      AppMethodBeat.o(74267);
      return;
    }
    if (3 == paramInt1)
    {
      Toast.makeText(getContext(), getString(2131299848), 1).show();
      AppMethodBeat.o(74267);
      return;
    }
    if (this.myI.mzp) {
      bxH();
    }
    AppMethodBeat.o(74267);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74253);
    this.mvD = this;
    ab.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
    super.onCreate(paramBundle);
    if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwI() == null)
    {
      ab.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
      finish();
      AppMethodBeat.o(74253);
      return;
    }
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().hw(false);
    setMMTitle(2131299740);
    setBackBtn(new FavoriteIndexUI.1(this));
    this.mvw.setOnItemLongClickListener(this.myN);
    this.mvw.setOnTouchListener(new FavoriteIndexUI.12(this));
    com.tencent.mm.kernel.g.Rc().a(438, this.myM);
    com.tencent.mm.kernel.g.Rc().a(401, this.myM);
    this.contextMenuHelper = new l(this);
    addIconOptionMenu(11, 2131299660, 2131230736, new FavoriteIndexUI.3(this));
    this.myJ = new com.tencent.mm.plugin.fav.ui.widget.b();
    paramBundle = this.myJ;
    View localView = findViewById(2131824004);
    paramBundle.mDP = false;
    paramBundle.mDQ = localView;
    this.myJ.mDX = new FavoriteIndexUI.5(this);
    com.tencent.mm.kernel.g.RO().ac(new FavoriteIndexUI.17(this));
    com.tencent.mm.plugin.fav.a.d.bwj().a(null);
    c.bxu();
    com.tencent.mm.plugin.fav.a.i.start();
    AppMethodBeat.o(74253);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(74269);
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, 2131304318);
    localMenuItem.setIcon(2131230741);
    localMenuItem.setShowAsAction(2);
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(74269);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74255);
    super.onDestroy();
    if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwI() == null)
    {
      AppMethodBeat.o(74255);
      return;
    }
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().hw(true);
    if (this.myI != null) {
      this.myI.finish();
    }
    li localli = new li();
    localli.cBr.type = 12;
    com.tencent.mm.sdk.b.a.ymk.l(localli);
    com.tencent.mm.kernel.g.Rc().b(438, this.myM);
    com.tencent.mm.kernel.g.Rc().b(401, this.myM);
    com.tencent.mm.plugin.fav.a.i.end();
    c.bxt();
    AppMethodBeat.o(74255);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(74258);
    switch (this.myH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74258);
      return;
      if (this.myI != null)
      {
        this.myI.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = (a.b)paramView.getTag();
        if (paramAdapterView == null)
        {
          ab.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
          AppMethodBeat.o(74258);
          return;
        }
        if (paramAdapterView.muk == null)
        {
          ab.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
          AppMethodBeat.o(74258);
          return;
        }
        ab.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[] { Integer.valueOf(paramAdapterView.muk.field_type) });
        com.tencent.mm.plugin.report.service.h.qsU.e(12746, new Object[] { Integer.valueOf(paramAdapterView.muk.field_type), Integer.valueOf(0), Integer.valueOf(paramInt - 1) });
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74256);
    if ((4 == paramInt) && (this.myI.mzp))
    {
      bxH();
      AppMethodBeat.o(74256);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(74256);
    return bool;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74270);
    if (paramMenuItem.getItemId() == 10)
    {
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_enter_fav_search_from", 0);
      S(paramMenuItem);
      AppMethodBeat.o(74270);
      return true;
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(74270);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74264);
    super.onPause();
    com.tencent.mm.plugin.fav.a.i.NJ(getClass().getSimpleName());
    AppMethodBeat.o(74264);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(74272);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(74272);
      return;
    }
    ab.i("MicroMsg.FavoriteIndexUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74272);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavPostVoiceUI", new Intent(), 4102);
        overridePendingTransition(0, 0);
        AppMethodBeat.o(74272);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302075), "", getString(2131300996), getString(2131296888), false, new FavoriteIndexUI.13(this), new FavoriteIndexUI.14(this));
      AppMethodBeat.o(74272);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = new Intent();
        paramArrayOfString.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
        paramArrayOfString.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
        paramArrayOfString.putExtra("map_view_type", 3);
        com.tencent.mm.bq.d.b(this, "location", ".ui.RedirectUI", paramArrayOfString, 4097);
        AppMethodBeat.o(74272);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302073), "", getString(2131300996), getString(2131296888), false, new FavoriteIndexUI.15(this), new FavoriteIndexUI.16(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74263);
    long l = System.currentTimeMillis();
    super.onResume();
    this.faV.post(new FavoriteIndexUI.2(this));
    ab.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    com.tencent.mm.plugin.fav.a.i.NI(getClass().getSimpleName());
    AppMethodBeat.o(74263);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI
 * JD-Core Version:    0.7.0.1
 */