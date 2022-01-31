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
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.widget.b.a;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.j;
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
  private static final long kdW = com.tencent.mm.m.b.Ai();
  private j contextMenuHelper;
  private com.tencent.mm.ui.base.n.d hZq = new FavoriteIndexUI.18(this);
  private int kdX = 0;
  private com.tencent.mm.plugin.fav.ui.a.b kdY;
  private com.tencent.mm.plugin.fav.ui.widget.b kdZ;
  private View.OnClickListener kdc = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      int i = ((Integer)paramAnonymousView.getTag()).intValue();
      paramAnonymousView = new Intent();
      paramAnonymousView.putExtra("key_enter_fav_search_from", 0);
      paramAnonymousView.putExtra("key_preset_search_type", i);
      FavoriteIndexUI.a(FavoriteIndexUI.this, paramAnonymousView);
    }
  };
  private com.tencent.mm.plugin.fav.a.g kea;
  private com.tencent.mm.ah.f keb = new FavoriteIndexUI.12(this);
  private AdapterView.OnItemLongClickListener kec = new FavoriteIndexUI.17(this);
  private com.tencent.mm.plugin.fav.a.g ked;
  private long startTime = 0L;
  
  private void a(List<com.tencent.mm.plugin.fav.a.g> paramList, String paramString1, String paramString2)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    while (bk.bl(paramString2)) {
      return;
    }
    boolean bool = com.tencent.mm.model.s.fn(paramString2);
    Object localObject = new k();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)localIterator.next();
      if (!((k)localObject).t(localg))
      {
        com.tencent.mm.plugin.fav.a.h.f(localg.field_localId, 1, 0);
        localLinkedList.add(localg);
        label114:
        m.d locald;
        if (bool)
        {
          paramList = m.c.jZv;
          locald = m.d.jZy;
          if (!bool) {
            break label150;
          }
        }
        label150:
        for (int i = com.tencent.mm.model.m.gM(paramString2);; i = 0)
        {
          com.tencent.mm.plugin.fav.a.m.a(paramList, localg, locald, i);
          break;
          paramList = m.c.jZu;
          break label114;
        }
      }
    }
    if (localLinkedList.isEmpty())
    {
      y.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
      paramList = getString(n.i.favorite_retransmit_tip);
      com.tencent.mm.ui.base.h.bC(getApplicationContext(), paramList);
      return;
    }
    paramList = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(n.i.favorite_forward_tips), false, null);
    i.a(this.mController.uMN, paramString2, paramString1, localLinkedList, new FavoriteIndexUI.6(this, paramList));
    paramString2 = localLinkedList.iterator();
    for (;;)
    {
      if (!paramString2.hasNext()) {
        break label487;
      }
      localObject = (com.tencent.mm.plugin.fav.a.g)paramString2.next();
      if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_type == 5))
      {
        paramList = "";
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.sWh != null) {
          paramList = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.sWh.sXG;
        }
        paramString1 = paramList;
        if (((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.sXa != null)
        {
          paramString1 = paramList;
          if (bk.bl(paramList)) {
            paramString1 = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.sXa.eAl;
          }
        }
        if (!bk.bl(paramString1))
        {
          y.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramString1, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
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
          y.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramString1, "", new Object[0]);
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { paramList, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1) });
    }
    label487:
    com.tencent.mm.plugin.report.service.h.nFQ.f(11125, new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(1) });
  }
  
  public static void a(List<com.tencent.mm.plugin.fav.a.g> paramList, String[] paramArrayOfString)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      {
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
            bool |= localg.CF(paramArrayOfString[i]);
            i += 1;
          }
          if (bool)
          {
            ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
            com.tencent.mm.plugin.fav.a.b.p(localg);
            localLinkedList.add(localg);
          }
        }
        paramList = localLinkedList.iterator();
        while (paramList.hasNext()) {
          com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)paramList.next(), 3);
        }
      }
    }
  }
  
  public static boolean a(List<com.tencent.mm.plugin.fav.a.g> paramList, Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
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
        if ((localg != null) && (localg.field_favProto != null) && (localg.field_favProto.sXc != null)) {
          if (localg.field_type == 3)
          {
            m += 1;
          }
          else
          {
            Iterator localIterator2 = localg.field_favProto.sXc.iterator();
            k = 0;
            while (localIterator2.hasNext())
            {
              xv localxv = (xv)localIterator2.next();
              if (localxv.sVO == 2) {
                n += 1;
              } else if (localxv.sVO == 1) {
                i1 += 1;
              } else {
                k += 1;
              }
            }
            if (!k.u(localg)) {
              break label549;
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
      if ((i == 0) && (i2 == localg.field_favProto.sXc.size())) {
        i = 1;
      }
      for (;;)
      {
        break;
        if (1 == paramList.size())
        {
          if ((((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type == 14) && ((n > 0) || (i1 > 0)))
          {
            com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(n.i.favorite_detail_illegal_trans_big_expired));
            return false;
          }
          if (n > 0)
          {
            com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(n.i.favorite_detail_illegal_trans_big_file));
            return false;
          }
          if (i1 > 0)
          {
            switch (((com.tencent.mm.plugin.fav.a.g)paramList.get(0)).field_type)
            {
            }
            for (;;)
            {
              return false;
              com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(n.i.favorite_detail_illegal_trans_file));
              continue;
              com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(n.i.favorite_detail_illegal_trans_image));
              continue;
              com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(n.i.favorite_detail_illegal_trans_video));
            }
          }
          if (j > 0)
          {
            com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(n.i.Fav_NotDownload_CannotForward));
            return false;
          }
          if (m > 0)
          {
            com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(n.i.Fav_Voice_CannotForward));
            return false;
          }
        }
        else if ((n > 0) || (i1 > 0) || (j > 0) || (m > 0))
        {
          if (i != 0) {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(n.i.favorite_detail_illegal_transmay_tips_yes), "", paramContext.getString(n.i.confirm_dialog_ok), paramContext.getString(n.i.confirm_dialog_cancel), paramOnClickListener, null, n.b.wechat_green);
          }
          for (;;)
          {
            return false;
            com.tencent.mm.ui.base.h.bC(paramContext, paramContext.getString(n.i.favorite_detail_illegal_transmay_tips_no));
          }
        }
        return true;
      }
      label549:
      i2 = k;
    }
  }
  
  private void aRs()
  {
    this.kdY.a(false, null);
    this.kba.setOnItemLongClickListener(this.kec);
    showOptionMenu(11, true);
    com.tencent.mm.plugin.fav.ui.widget.b localb = this.kdZ;
    if ((localb.kjj) && (localb.kjk.getVisibility() != 8))
    {
      localb.kjk.setVisibility(8);
      localb.kjk.startAnimation(AnimationUtils.loadAnimation(localb.kjk.getContext(), n.a.fast_faded_out));
    }
  }
  
  private void z(Intent paramIntent)
  {
    Bundle localBundle = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localBundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
    }
    if (this.kdY.keG)
    {
      paramIntent.putExtra("key_search_type", 2);
      com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavSearchUI", paramIntent, 4103, localBundle);
      return;
    }
    com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavSearchUI", paramIntent, localBundle);
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a aQX()
  {
    if (this.kdY == null)
    {
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      this.kdY = new com.tencent.mm.plugin.fav.ui.a.b(this.kbg, false);
      this.kdY.a(new FavoriteIndexUI.19(this));
      this.kdY.keN = this;
      this.kdY.scene = 1;
      this.kdY.keQ = this.kba;
    }
    return this.kdY;
  }
  
  protected final void aQY()
  {
    this.kbe.post(new FavoriteIndexUI.20(this));
  }
  
  protected final boolean aQZ()
  {
    switch (this.kdX)
    {
    }
    for (int i = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().getCount(); i > 0; i = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQu()) {
      return true;
    }
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  protected final void aRa()
  {
    switch (this.kdX)
    {
    default: 
      this.kbb.setCompoundDrawablesWithIntrinsicBounds(0, n.d.favorites_empty_favorites_icon, 0, 0);
      this.kbb.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 10));
      this.kbb.setText(n.i.favorite_empty_fav);
      return;
    }
    this.kbb.setCompoundDrawablesWithIntrinsicBounds(0, n.h.fav_list_img_default, 0, 0);
    this.kbb.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 10));
    this.kbb.setText(n.i.favorite_empty_fav_img);
  }
  
  protected final View.OnClickListener aRb()
  {
    return this.kdc;
  }
  
  protected final void aRc()
  {
    super.aRc();
    this.dPi.post(new FavoriteIndexUI.16(this));
  }
  
  public final void aRt()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_enter_fav_cleanui_from", 0);
    com.tencent.mm.plugin.fav.a.b.a(this.mController.uMN, ".ui.FavCleanUI", localIntent);
  }
  
  public final void eI(long paramLong)
  {
    com.tencent.mm.plugin.fav.ui.widget.b localb;
    if (this.kdY.keG)
    {
      localb = this.kdZ;
      if (this.kdY.aRC() <= 0) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      if (localb.kjj)
      {
        localb.kjo.setEnabled(bool);
        localb.kjp.setEnabled(bool);
        localb.kjq.setEnabled(bool);
      }
      return;
    }
  }
  
  protected final void initHeaderView()
  {
    super.initHeaderView();
    this.kbe.gd(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    switch (paramInt1)
    {
    default: 
      y.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -1) {
        if (((this.ked != null) && (this.ked.field_type == 5)) || ((this.kea != null) && (this.kea.field_type == 5)))
        {
          localObject1 = "";
          if ((this.kea == null) || (this.kea.field_favProto.sXa == null)) {
            break label269;
          }
          paramIntent = this.kea.field_favProto.sXa.eAl;
          label139:
          if (!bk.bl(paramIntent)) {
            y.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
          }
        }
      }
      break;
    }
    label269:
    label1311:
    do
    {
      try
      {
        paramIntent = URLEncoder.encode(paramIntent, "UTF-8");
        com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3) });
        return;
        com.tencent.mm.plugin.fav.a.i.CH(".ui.transmit.SelectConversationUI");
        break;
        if (this.ked.field_favProto.sWh != null) {
          localObject1 = this.ked.field_favProto.sWh.sXG;
        }
        paramIntent = (Intent)localObject1;
        if (this.ked.field_favProto.sXa == null) {
          break label139;
        }
        paramIntent = (Intent)localObject1;
        if (!bk.bl((String)localObject1)) {
          break label139;
        }
        paramIntent = this.ked.field_favProto.sXa.eAl;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FavoriteIndexUI", paramIntent, "", new Object[0]);
          paramIntent = "";
        }
      }
      paramInt2 = 2;
      localObject1 = paramIntent.getStringExtra("custom_send_text");
      switch (paramInt1)
      {
      default: 
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label1311;
        }
        com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(n.i.favorite_ok));
        return;
        paramInt1 = 0;
        this.kaX = true;
        continue;
        paramIntent = l.f(getApplicationContext(), paramIntent, com.tencent.mm.plugin.n.c.FG());
        if (paramIntent == null)
        {
          y.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
          return;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("CropImageMode", 4);
        ((Intent)localObject1).putExtra("CropImage_Filter", true);
        ((Intent)localObject1).putExtra("CropImage_ImgPath", paramIntent);
        ((Intent)localObject1).setClassName(this.mController.uMN, "com.tencent.mm.ui.tools.CropImageNewUI");
        startActivityForResult((Intent)localObject1, 4099);
        paramInt1 = paramInt2;
        continue;
        paramIntent = paramIntent.getStringExtra("CropImage_OutputPath");
        if (paramIntent == null)
        {
          y.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
          return;
        }
        paramInt1 = 0;
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(paramIntent);
        this.jWn.post(new FavoriteIndexUI.7(this, (ArrayList)localObject1));
        continue;
        paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((paramIntent == null) || (paramIntent.size() == 0))
        {
          y.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
          return;
        }
        paramInt1 = 0;
        this.jWn.post(new FavoriteIndexUI.8(this, paramIntent));
        continue;
        double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
        double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
        paramInt1 = paramIntent.getIntExtra("kwebmap_scale", 0);
        localObject1 = bk.aM(paramIntent.getStringExtra("Kwebmap_locaion"), "");
        Object localObject2 = paramIntent.getCharSequenceExtra("kRemark");
        Object localObject3 = paramIntent.getStringExtra("kPoiName");
        paramIntent = paramIntent.getStringArrayListExtra("kTags");
        this.jWn.post(new FavoriteIndexUI.9(this, d1, d2, paramInt1, (String)localObject1, (CharSequence)localObject2, (String)localObject3, paramIntent));
        paramInt1 = 0;
        continue;
        paramIntent = paramIntent.getStringExtra("choosed_file_path");
        if (bk.bl(paramIntent))
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
          else if (((com.tencent.mm.vfs.b)localObject1).length() >= kdW)
          {
            paramInt1 = 3;
          }
          else
          {
            if (bk.bl(paramIntent)) {
              paramInt1 = 0;
            }
            for (;;)
            {
              if (paramInt1 == 0) {
                break label1031;
              }
              paramInt1 = 0;
              this.kaX = true;
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
                h.D((com.tencent.mm.plugin.fav.a.g)localObject2);
                ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Yo(((com.tencent.mm.vfs.b)localObject1).getName());
                localObject3 = new xv();
                ((xv)localObject3).XI(paramIntent);
                ((xv)localObject3).mk(true);
                ((xv)localObject3).Xu(((com.tencent.mm.vfs.b)localObject1).getName());
                ((xv)localObject3).EH(((com.tencent.mm.plugin.fav.a.g)localObject2).field_type);
                ((xv)localObject3).XE(e.bM(paramIntent));
                ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.sXc.add(localObject3);
                b.B((com.tencent.mm.plugin.fav.a.g)localObject2);
                com.tencent.mm.plugin.report.service.h.nFQ.f(10648, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
                paramInt1 = 1;
              }
            }
            paramInt1 = 1;
            continue;
            long l = paramIntent.getLongExtra("key_fav_result_local_id", -1L);
            if (-1L == l) {
              break;
            }
            paramInt1 = this.kdY.eJ(l);
            if (-1 == paramInt1) {
              break;
            }
            this.kba.removeFooterView(this.kbc);
            this.kba.setSelection(paramInt1);
            return;
            localObject1 = this.kdY.fX(false);
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
                  localObject2 = com.tencent.mm.ui.base.h.b(this.mController.uMN, "", false, null);
                  com.tencent.mm.kernel.g.DS().O(new FavoriteIndexUI.5(this, (List)localObject1, paramIntent, (Dialog)localObject2));
                  com.tencent.mm.plugin.report.service.h.nFQ.f(11125, new Object[] { Integer.valueOf(paramIntent.length), Integer.valueOf(2) });
                  paramInt1 = paramInt2;
                  continue;
                  paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                  y.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                  a(this.kdY.fX(false), (String)localObject1, paramIntent);
                  paramInt1 = paramInt2;
                  continue;
                  paramIntent = paramIntent.getStringExtra("Select_Conv_User");
                  y.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[] { paramIntent });
                  localObject2 = new ArrayList();
                  ((List)localObject2).add(this.ked);
                  a((List)localObject2, (String)localObject1, paramIntent);
                  paramInt1 = paramInt2;
                }
              }
            }
          }
        }
      }
      if (1 == paramInt1)
      {
        com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(n.i.favorite_fail));
        return;
      }
      if (3 == paramInt1)
      {
        Toast.makeText(this.mController.uMN, getString(n.i.favorite_too_large), 1).show();
        return;
      }
    } while (!this.kdY.keG);
    label1031:
    aRs();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.kbh = this;
    y.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
    super.onCreate(paramBundle);
    if (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQt() == null)
    {
      y.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
      finish();
      return;
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().fS(false);
    setMMTitle(n.i.favorite_index_ui_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).keG)
        {
          FavoriteIndexUI.b(FavoriteIndexUI.this);
          return true;
        }
        FavoriteIndexUI.this.finish();
        return true;
      }
    });
    this.kba.setOnItemLongClickListener(this.kec);
    com.tencent.mm.kernel.g.Dk().a(438, this.keb);
    com.tencent.mm.kernel.g.Dk().a(401, this.keb);
    this.contextMenuHelper = new j(this);
    addIconOptionMenu(11, n.i.fav_actionbar_title_add_fav, n.h.actionbar_icon_dark_add, new FavoriteIndexUI.22(this));
    this.kdZ = new com.tencent.mm.plugin.fav.ui.widget.b();
    paramBundle = this.kdZ;
    View localView = findViewById(n.e.fav_edit_footer);
    paramBundle.kjj = false;
    paramBundle.kjk = localView;
    this.kdZ.kjr = new b.a()
    {
      public final void aRe()
      {
        com.tencent.mm.ui.base.h.a(FavoriteIndexUI.this.mController.uMN, FavoriteIndexUI.this.getString(n.i.favorite_delete_items_confirm), "", new FavoriteIndexUI.3.2(this), null);
      }
      
      public final void aRu()
      {
        if (!FavoriteIndexUI.a(FavoriteIndexUI.a(FavoriteIndexUI.this).fX(false), FavoriteIndexUI.this, new FavoriteIndexUI.3.1(this))) {
          return;
        }
        FavoriteIndexUI.a(FavoriteIndexUI.this, 4105);
      }
      
      public final void aRv()
      {
        if (FavoriteIndexUI.a(FavoriteIndexUI.this).aRC() <= 0) {}
        do
        {
          return;
          if (FavoriteIndexUI.a(FavoriteIndexUI.this).aRC() > 1)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("key_fav_scene", 3);
            com.tencent.mm.plugin.fav.a.b.b(FavoriteIndexUI.this.mController.uMN, ".ui.FavTagEditUI", (Intent)localObject, 4104);
            com.tencent.mm.plugin.fav.a.i.CG("FavTagEditUI");
            return;
          }
          Object localObject = (com.tencent.mm.plugin.fav.a.g)FavoriteIndexUI.a(FavoriteIndexUI.this).fX(false).get(0);
          Intent localIntent = new Intent();
          localIntent.putExtra("key_fav_scene", 3);
          localIntent.putExtra("key_fav_item_id", ((com.tencent.mm.plugin.fav.a.g)localObject).field_localId);
          com.tencent.mm.plugin.fav.a.b.a(FavoriteIndexUI.this.mController.uMN, ".ui.FavTagEditUI", localIntent);
          com.tencent.mm.plugin.fav.a.i.CG("FavTagEditUI");
        } while (!FavoriteIndexUI.a(FavoriteIndexUI.this).keG);
        FavoriteIndexUI.b(FavoriteIndexUI.this);
      }
    };
    com.tencent.mm.kernel.g.DS().O(new FavoriteIndexUI.15(this));
    com.tencent.mm.plugin.fav.a.d.aPV().a(null);
    c.aRf();
    com.tencent.mm.plugin.fav.a.i.start();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    k localk = new k();
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    localObject = this.kdY.rd(((AdapterView.AdapterContextMenuInfo)localObject).position - this.kba.getHeaderViewsCount() - 1);
    switch (this.kdX)
    {
    default: 
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      return;
    }
    paramContextMenu.setHeaderTitle(n.i.app_tip);
    boolean bool = localk.t((com.tencent.mm.plugin.fav.a.g)localObject);
    if (!bool) {
      paramContextMenu.add(0, 3, 0, n.i.favorite_retransmit);
    }
    if ((bool) && (com.tencent.mm.plugin.fav.a.b.g((com.tencent.mm.plugin.fav.a.g)localObject))) {
      paramContextMenu.add(0, 3, 0, n.i.favorite_retransmit);
    }
    paramContextMenu.add(0, 2, 0, n.i.favorite_edit_tag_tips);
    paramContextMenu.add(0, 0, 0, n.i.favorite_delete);
    paramContextMenu.add(0, 1, 0, n.i.favorite_more);
  }
  
  @SuppressLint({"ResourceType"})
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.add(0, 10, 0, n.i.top_item_desc_search);
    localMenuItem.setIcon(n.h.actionbar_icon_dark_search);
    android.support.v4.view.f.a(localMenuItem, 2);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQt() == null) {
      return;
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().fS(true);
    if (this.kdY != null) {
      this.kdY.finish();
    }
    ku localku = new ku();
    localku.bTL.type = 12;
    com.tencent.mm.sdk.b.a.udP.m(localku);
    com.tencent.mm.kernel.g.Dk().b(438, this.keb);
    com.tencent.mm.kernel.g.Dk().b(401, this.keb);
    com.tencent.mm.plugin.fav.a.i.end();
    c.aYx();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (this.kdX)
    {
    }
    do
    {
      return;
    } while (this.kdY == null);
    this.kdY.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = (a.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      y.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
      return;
    }
    if (paramAdapterView.jZN == null)
    {
      y.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
      return;
    }
    y.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[] { Integer.valueOf(paramAdapterView.jZN.field_type) });
    com.tencent.mm.plugin.report.service.h.nFQ.f(12746, new Object[] { Integer.valueOf(paramAdapterView.jZN.field_type), Integer.valueOf(0), Integer.valueOf(paramInt - 1) });
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (this.kdY.keG))
    {
      aRs();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 10)
    {
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_enter_fav_search_from", 0);
      z(paramMenuItem);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.plugin.fav.a.i.CH(getClass().getSimpleName());
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.FavoriteIndexUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    case 80: 
      if (paramArrayOfInt[0] == 0)
      {
        com.tencent.mm.plugin.fav.a.b.b(this, ".ui.FavPostVoiceUI", new Intent(), 4102);
        overridePendingTransition(0, 0);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(n.i.permission_microphone_request_again_msg), "", getString(n.i.jump_to_settings), getString(n.i.app_cancel), false, new FavoriteIndexUI.10(this), new FavoriteIndexUI.11(this));
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      paramArrayOfString = new Intent();
      paramArrayOfString.putExtra("MMActivity.OverrideExitAnimation", n.a.push_down_out);
      paramArrayOfString.putExtra("MMActivity.OverrideEnterAnimation", n.a.fast_faded_in);
      paramArrayOfString.putExtra("map_view_type", 3);
      com.tencent.mm.br.d.b(this, "location", ".ui.RedirectUI", paramArrayOfString, 4097);
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(n.i.permission_location_request_again_msg), "", getString(n.i.jump_to_settings), getString(n.i.app_cancel), false, new FavoriteIndexUI.13(this), new FavoriteIndexUI.14(this));
  }
  
  protected void onResume()
  {
    long l = System.currentTimeMillis();
    super.onResume();
    this.dPi.post(new FavoriteIndexUI.21(this));
    y.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    com.tencent.mm.plugin.fav.a.i.CG(getClass().getSimpleName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI
 * JD-Core Version:    0.7.0.1
 */