package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.plugin.fav.a.n.b;
import com.tencent.mm.plugin.fav.a.n.c;
import com.tencent.mm.plugin.fav.a.n.d;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.l.2;
import com.tencent.mm.plugin.fav.ui.s.b;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.q, MStorage.IOnStorageChange
{
  private static final long wNY;
  private anm fDI;
  private boolean fNQ;
  private long fyE;
  private MMHandler knk;
  private TextView mYd;
  private ProgressBar progressBar;
  private TextView qpt;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private com.tencent.mm.pluginsdk.ui.tools.k txH;
  private Button uId;
  private q.g voR;
  private com.tencent.mm.plugin.fav.a.g wHw;
  private com.tencent.mm.plugin.fav.a.k wLT;
  private Button wNZ;
  private Button wOa;
  private MMImageView wOb;
  private TextView wOc;
  private View wOd;
  private View wOe;
  private TextView wOf;
  private ImageView wOg;
  private TextView wOh;
  private boolean wOi;
  private boolean wOj;
  private String wOk;
  private String wOl;
  private boolean wOm;
  private boolean wOn;
  private boolean wOo;
  private HandOffFile wOp;
  private com.tencent.mm.plugin.fav.ui.b.a wOq;
  private com.tencent.mm.plugin.fav.ui.f.a wOr;
  private View.OnTouchListener wOs;
  private View.OnLongClickListener wOt;
  
  static
  {
    AppMethodBeat.i(228330);
    wNY = com.tencent.mm.n.c.awK();
    AppMethodBeat.o(228330);
  }
  
  public FavoriteFileDetailUI()
  {
    AppMethodBeat.i(107138);
    this.txH = null;
    this.wLT = new com.tencent.mm.plugin.fav.a.k();
    this.wOi = false;
    this.wOj = false;
    this.fNQ = true;
    this.wOm = false;
    this.wOn = false;
    this.wOo = false;
    this.szq = null;
    this.voR = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107137);
        if (Util.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)) {}
        for (paramAnonymousMenuItem = FavoriteFileDetailUI.this.getString(s.i.openapi_app_file);; paramAnonymousMenuItem = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)
        {
          ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
          com.tencent.mm.ui.base.h.cO(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(s.i.app_copy_ok));
          AppMethodBeat.o(107137);
          return;
        }
      }
    };
    this.wOs = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(107115);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(107115);
          return false;
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, (int)paramAnonymousMotionEvent.getRawX());
          FavoriteFileDetailUI.b(FavoriteFileDetailUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.wOt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107116);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        Log.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
        if (FavoriteFileDetailUI.o(FavoriteFileDetailUI.this) == null) {
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.dlC()));
        }
        FavoriteFileDetailUI.o(FavoriteFileDetailUI.this).a(paramAnonymousView, FavoriteFileDetailUI.this, FavoriteFileDetailUI.p(FavoriteFileDetailUI.this), FavoriteFileDetailUI.q(FavoriteFileDetailUI.this), FavoriteFileDetailUI.r(FavoriteFileDetailUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107116);
        return true;
      }
    };
    AppMethodBeat.o(107138);
  }
  
  private void b(final float paramFloat, final String paramString)
  {
    AppMethodBeat.i(107156);
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107123);
        FavoriteFileDetailUI.w(FavoriteFileDetailUI.this).setProgress((int)paramFloat);
        FavoriteFileDetailUI.x(FavoriteFileDetailUI.this).setText(paramString);
        AppMethodBeat.o(107123);
      }
    });
    AppMethodBeat.o(107156);
  }
  
  private void bXd()
  {
    AppMethodBeat.i(107158);
    if (this.wOm)
    {
      AppMethodBeat.o(107158);
      return;
    }
    Object localObject = this.wNU;
    ((h.a)localObject).wGt += 1;
    this.wOm = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.fyE);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(this.fDI));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(this.fDI));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.fDI.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.fDI.fUk);
    ((Intent)localObject).putExtra("key_detail_msg_uuid", this.fDI.mic);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
    AppMethodBeat.o(107158);
  }
  
  private void dlB()
  {
    AppMethodBeat.i(107139);
    this.wOl = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.wHw.field_favProto.syG.iterator();
    while (localIterator.hasNext())
    {
      anm localanm = (anm)localIterator.next();
      if (localanm.fEa.equals(this.wOl)) {
        this.fDI = localanm;
      }
    }
    if (this.fDI == null) {
      this.fDI = com.tencent.mm.plugin.fav.a.b.c(this.wHw);
    }
    AppMethodBeat.o(107139);
  }
  
  private void dlD()
  {
    AppMethodBeat.i(107146);
    this.wOb.setVisibility(8);
    this.mYd.setVisibility(8);
    this.wOa.setVisibility(8);
    this.uId.setVisibility(8);
    this.wNZ.setVisibility(8);
    this.wOd.setVisibility(8);
    this.qpt.setVisibility(8);
    this.wOg.setVisibility(0);
    this.wOh.setVisibility(0);
    if (this.fDI.dataType == 4)
    {
      this.qpt.setGravity(17);
      this.qpt.setText(s.i.favorite_out_of_date_video);
      AppMethodBeat.o(107146);
      return;
    }
    this.qpt.setGravity(17);
    this.qpt.setText(s.i.favorite_out_of_date_file);
    if (this.fDI.SyU == 2)
    {
      this.wOh.setText(s.i.favorite_detail_illegal_big_file);
      AppMethodBeat.o(107146);
      return;
    }
    this.wOh.setText(s.i.favorite_detail_illegal_expired_file);
    AppMethodBeat.o(107146);
  }
  
  private void dlE()
  {
    AppMethodBeat.i(107147);
    this.wOa.setVisibility(8);
    this.uId.setVisibility(8);
    this.wNZ.setVisibility(8);
    this.qpt.setVisibility(8);
    this.wOd.setVisibility(0);
    com.tencent.mm.plugin.fav.a.c localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(this.fDI.fEa);
    int j;
    int i;
    int k;
    if (localc != null)
    {
      j = (int)localc.getProgress();
      i = localc.field_offset;
      k = localc.field_totalLen;
    }
    while ((this.wHw.djD()) && (Util.isNullOrNil(this.fDI.Rwb)))
    {
      b(j, getString(s.i.favorite_uploading, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(i), com.tencent.mm.plugin.fav.a.b.getLengthStr(k) }));
      AppMethodBeat.o(107147);
      return;
      k = (int)this.fDI.Syi;
      i = 0;
      j = 0;
    }
    b(j, getString(s.i.favorite_downloading, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(i), com.tencent.mm.plugin.fav.a.b.getLengthStr(k) }));
    AppMethodBeat.o(107147);
  }
  
  private void dlF()
  {
    AppMethodBeat.i(107148);
    this.wOd.setVisibility(8);
    this.wNZ.setVisibility(8);
    if (Util.isNullOrNil(this.fDI.SxU))
    {
      this.uId.setVisibility(8);
      this.wOa.setVisibility(0);
      localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(this.fDI.fEa);
      if ((localObject == null) || (((com.tencent.mm.plugin.fav.a.c)localObject).field_offset <= 0)) {
        break label150;
      }
      localObject = this.wOa;
      if (!this.wHw.djE()) {
        break label143;
      }
    }
    label143:
    for (int i = s.i.favorite_item_restart_upload;; i = s.i.favorite_item_restart_download)
    {
      ((Button)localObject).setText(i);
      this.qpt.setVisibility(8);
      AppMethodBeat.o(107148);
      return;
      this.uId.setVisibility(0);
      break;
    }
    label150:
    Object localObject = this.wOa;
    if (this.wHw.djE()) {}
    for (i = s.i.favorite_item_upload;; i = s.i.favorite_item_download)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private boolean dlG()
  {
    AppMethodBeat.i(107149);
    if ((com.tencent.mm.plugin.fav.a.b.g(this.fDI)) && (com.tencent.mm.plugin.fav.a.b.h(this.fDI)))
    {
      AppMethodBeat.o(107149);
      return true;
    }
    AppMethodBeat.o(107149);
    return false;
  }
  
  private void dlH()
  {
    AppMethodBeat.i(107150);
    if ((getType() == 15) && (this.fDI.SyM != null) && (!Util.isNullOrNil(this.fDI.SyM.lor)) && (!Util.isNullOrNil(this.fDI.SyM.lov)))
    {
      this.wOn = true;
      this.wOb.setVisibility(8);
      this.wOd.setVisibility(8);
      this.wOa.setVisibility(8);
      this.uId.setVisibility(8);
      this.wNZ.setVisibility(8);
      this.qpt.setVisibility(8);
      String str = com.tencent.mm.plugin.fav.a.b.d(this.fDI);
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.avC() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(s.e.video_container);
      this.txH = x.jH((MMActivity)super.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.txH, 0, localLayoutParams);
      this.txH.setVideoCallback(new k.a()
      {
        public final void eM(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fE(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion() {}
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107119);
          FavoriteFileDetailUI.s(FavoriteFileDetailUI.this).stop();
          if (FavoriteFileDetailUI.t(FavoriteFileDetailUI.this))
          {
            AppMethodBeat.o(107119);
            return;
          }
          FavoriteFileDetailUI.u(FavoriteFileDetailUI.this);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107117);
              com.tencent.mm.ui.base.h.p(FavoriteFileDetailUI.this.dlC(), s.i.video_file_play_faile, s.i.video_play_err);
              Bitmap localBitmap = com.tencent.mm.plugin.fav.ui.o.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this), FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
              ImageView localImageView = (ImageView)FavoriteFileDetailUI.this.findViewById(s.e.videoplayer_maskview);
              if (localImageView != null)
              {
                localImageView.setImageBitmap(localBitmap);
                localImageView.setVisibility(0);
              }
              AppMethodBeat.o(107117);
            }
          });
          AppMethodBeat.o(107119);
        }
        
        public final void qX()
        {
          AppMethodBeat.i(107118);
          Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.avC() + " onPrepared");
          FavoriteFileDetailUI.s(FavoriteFileDetailUI.this).setLoop(true);
          FavoriteFileDetailUI.s(FavoriteFileDetailUI.this).start();
          AppMethodBeat.o(107118);
        }
      });
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.avC() + " initView :" + str);
      if (str != null)
      {
        this.txH.stop();
        this.txH.setVideoPath(str);
      }
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.avC() + " initView");
      com.tencent.mm.bb.a.bnv();
      com.tencent.mm.plugin.report.service.h.IzE.a(11444, new Object[] { Integer.valueOf(4) });
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.wOn)
      {
        this.wOd.setVisibility(8);
        this.wOa.setVisibility(8);
        this.uId.setVisibility(8);
        this.wNZ.setVisibility(0);
        this.wNZ.setText(s.i.favorite_item_preview);
        this.qpt.setVisibility(8);
        bXd();
      }
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230226);
          com.tencent.mm.plugin.fav.a.b.o(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          AppMethodBeat.o(230226);
        }
      });
    }
    for (;;)
    {
      if (this.wOp.getFileStatus() != 1)
      {
        this.wOp.setFileStatus(1);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.wOp);
      }
      AppMethodBeat.o(107150);
      return;
      if (!dlG()) {
        break;
      }
      this.wOd.setVisibility(8);
      this.wOa.setVisibility(8);
      this.uId.setVisibility(0);
      this.wNZ.setVisibility(8);
      this.qpt.setVisibility(8);
      this.uId.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(229201);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FavoriteFileDetailUI.v(FavoriteFileDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(229201);
        }
      });
    }
    this.wOd.setVisibility(8);
    this.wOa.setVisibility(8);
    if (Util.isNullOrNil(this.fDI.SxU)) {
      this.uId.setVisibility(8);
    }
    for (;;)
    {
      this.wNZ.setVisibility(0);
      this.wNU.wGs = true;
      this.qpt.setVisibility(0);
      break;
      this.uId.setVisibility(0);
    }
  }
  
  private int getType()
  {
    AppMethodBeat.i(107143);
    if (this.fDI == null)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
      AppMethodBeat.o(107143);
      return 8;
    }
    if (this.fDI.dataType == 0)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.wHw.field_type) });
      if (4 == this.wHw.field_type)
      {
        AppMethodBeat.o(107143);
        return 4;
      }
      if (16 == this.wHw.field_type)
      {
        if ((this.fDI != null) && (this.fDI.SyM != null))
        {
          if (!Util.isNullOrNil(this.fDI.SyM.lor))
          {
            AppMethodBeat.o(107143);
            return 15;
          }
          if (!Util.isNullOrNil(this.fDI.SyM.lov))
          {
            AppMethodBeat.o(107143);
            return 15;
          }
        }
        AppMethodBeat.o(107143);
        return 4;
      }
      AppMethodBeat.o(107143);
      return 8;
    }
    if (this.fDI.dataType == 15)
    {
      if ((this.fDI != null) && (this.fDI.SyM != null))
      {
        if (!Util.isNullOrNil(this.fDI.SyM.lor))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
        if (!Util.isNullOrNil(this.fDI.SyM.lov))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
      }
      AppMethodBeat.o(107143);
      return 4;
    }
    int i = this.fDI.dataType;
    AppMethodBeat.o(107143);
    return i;
  }
  
  private void nT(boolean paramBoolean)
  {
    AppMethodBeat.i(107144);
    boolean bool = com.tencent.mm.plugin.fav.a.b.g(this.fDI);
    Log.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.wHw.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.d(this.fDI) });
    if (this.fDI.SyU != 0)
    {
      dlD();
      AppMethodBeat.o(107144);
      return;
    }
    int i;
    if ((this.wHw.isDone()) || (bool) || (!Util.isNullOrNil(this.fDI.Rwb)))
    {
      if (bool)
      {
        dlH();
        i = getIntent().getIntExtra("key_detail_open_way", 0);
        aoe localaoe;
        if (Util.isEqual(i, 1))
        {
          localaoe = new aoe();
          localaoe.fWQ = 2;
          ((z)com.tencent.mm.kernel.h.ae(z.class)).a((MMActivity)super.getContext(), this.wHw, localaoe);
          AppMethodBeat.o(107144);
          return;
        }
        if (Util.isEqual(i, 2))
        {
          localaoe = new aoe();
          localaoe.fWQ = 2;
          if ((this.fDI.dataType == 8) && (Util.isEqual(this.fDI.fEa, this.wOl)))
          {
            com.tencent.mm.plugin.fav.a.g localg = this.wHw.djI();
            localg.field_type = 8;
            localg.wGh = true;
            localg.wGi = this.wHw;
            localg.fDQ = (this.wHw.field_localId + "_" + this.wOl);
            localg.wGj = this.wOl;
            localg.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(this.wHw.field_favProto);
            localg.field_favProto.syG = new LinkedList();
            localg.field_favProto.syG.add(this.fDI);
            localg.field_favProto.btv(this.fDI.title);
            ((z)com.tencent.mm.kernel.h.ae(z.class)).a((MMActivity)super.getContext(), localg, localaoe);
            AppMethodBeat.o(107144);
            return;
          }
          ((z)com.tencent.mm.kernel.h.ae(z.class)).a((MMActivity)super.getContext(), this.wHw, localaoe);
        }
        AppMethodBeat.o(107144);
        return;
      }
      if (Util.isNullOrNil(this.fDI.Rwb))
      {
        dlD();
        AppMethodBeat.o(107144);
        return;
      }
      Log.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
      dlF();
      AppMethodBeat.o(107144);
      return;
    }
    if (this.wHw.djF())
    {
      if (Util.isNullOrNil(this.fDI.Rwb))
      {
        dlD();
        if (paramBoolean)
        {
          i = getType();
          if ((4 == i) || (15 == i)) {}
          for (i = s.i.favorite_record_video_error;; i = s.i.favorite_record_file_error)
          {
            com.tencent.mm.ui.base.h.cO((MMActivity)super.getContext(), getString(i));
            AppMethodBeat.o(107144);
            return;
          }
        }
      }
      else
      {
        dlF();
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.cO((MMActivity)super.getContext(), getString(s.i.download_fail));
          AppMethodBeat.o(107144);
        }
      }
    }
    else if (this.wHw.djE())
    {
      dlF();
      if (paramBoolean)
      {
        com.tencent.mm.ui.base.h.cO((MMActivity)super.getContext(), getString(s.i.fav_upload_fail));
        AppMethodBeat.o(107144);
      }
    }
    else
    {
      if ((this.wHw.isDownloading()) || (this.wHw.djD()))
      {
        dlE();
        AppMethodBeat.o(107144);
        return;
      }
      Log.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      dlF();
    }
    AppMethodBeat.o(107144);
  }
  
  public final MMActivity dlC()
  {
    AppMethodBeat.i(292902);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(292902);
    return localMMActivity;
  }
  
  public final void e(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(107155);
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(107155);
      return;
    }
    Log.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.fDI.fEa, paramc.field_dataId });
    if (paramc.field_dataId.equals(this.fDI.fEa))
    {
      if ((this.wHw.djD()) && (Util.isNullOrNil(this.fDI.Rwb)))
      {
        b(paramc.getProgress(), getString(s.i.favorite_uploading, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_totalLen) }));
        AppMethodBeat.o(107155);
        return;
      }
      b(paramc.getProgress(), getString(s.i.favorite_downloading, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_totalLen) }));
      if ((this.wOj) && (com.tencent.mm.vfs.u.agG(paramc.field_path)))
      {
        this.wHw.field_itemStatus = 10;
        onNotifyChange("", null);
      }
      AppMethodBeat.o(107155);
      return;
    }
    AppMethodBeat.o(107155);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return s.f.favorite_download_detail_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107154);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((ac)com.tencent.mm.kernel.h.ae(ac.class)).a(this, paramInt1, paramInt2, paramIntent, s.i.no_match_application_msg, s.i.no_match_application_title);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(107154);
      return;
    }
    if (paramInt1 == 1)
    {
      Object localObject1;
      if (paramIntent == null)
      {
        localObject1 = null;
        if (paramIntent != null) {
          break label155;
        }
      }
      Object localObject2;
      label155:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        localObject2 = com.tencent.mm.ui.base.h.a((MMActivity)super.getContext(), getString(s.i.favorite_forward_tips), false, null);
        Log.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107122);
            this.wJe.dismiss();
            AppMethodBeat.o(107122);
          }
        };
        paramInt2 = getType();
        if (!Util.isNullOrNil((String)localObject1)) {
          break label166;
        }
        AppMethodBeat.o(107154);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label166:
      Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
      label274:
      label318:
      label346:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((paramInt2 == 4) || (paramInt2 == 15))
        {
          l.a((MMActivity)super.getContext(), str, this.fDI, (Runnable)localObject2);
          boolean bool = ab.Lj(str);
          if (bool)
          {
            localObject1 = n.c.wHf;
            label252:
            com.tencent.mm.plugin.fav.a.g localg = this.wHw;
            n.d locald = n.d.wHj;
            if (!bool) {
              break label318;
            }
            paramInt1 = v.Pu(str);
            n.a((n.c)localObject1, localg, locald, paramInt1);
          }
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramIntent)) {
            break label346;
          }
          com.tencent.mm.plugin.messenger.a.g.eRW().ai(str, paramIntent, ab.QZ(str));
          break;
          localObject1 = n.c.wHe;
          break label252;
          paramInt1 = 0;
          break label274;
          l.a((MMActivity)super.getContext(), str, this.wHw, this.fDI, (Runnable)localObject2);
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(s.i.fav_finish_sent));
    }
    AppMethodBeat.o(107154);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(107140);
    super.onCreate(paramBundle);
    this.knk = new MMHandler();
    this.fyE = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.wOj = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.fNQ = getIntent().getBooleanExtra("show_share", true);
    this.wOk = getIntent().getStringExtra("fav_note_xml");
    this.wHw = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.fyE);
    if ((this.wOj) && (!Util.isNullOrNil(this.wOk))) {
      this.wHw = com.tencent.mm.plugin.fav.a.b.azP(this.wOk);
    }
    if (this.wHw == null)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      AppMethodBeat.o(107140);
      return;
    }
    H(this.wHw);
    n.x(this.wHw);
    dlB();
    this.uId = ((Button)findViewById(s.e.preview_btn));
    this.wNZ = ((Button)findViewById(s.e.open_btn));
    this.wOa = ((Button)findViewById(s.e.download_btn));
    this.wOb = ((MMImageView)findViewById(s.e.icon_iv));
    this.mYd = ((TextView)findViewById(s.e.name_tv));
    this.qpt = ((TextView)findViewById(s.e.tips_tv));
    this.wOe = findViewById(s.e.download_stop_btn);
    this.wOd = findViewById(s.e.download_progress_area);
    this.progressBar = ((ProgressBar)findViewById(s.e.download_pb));
    this.wOc = ((TextView)findViewById(s.e.download_progress_tips));
    this.wOf = ((TextView)findViewById(s.e.show_ad_sight));
    this.wOg = ((ImageView)findViewById(s.e.fav_file_illegal_image));
    this.wOh = ((TextView)findViewById(s.e.fav_file_illegal_tv));
    this.mYd.setOnTouchListener(this.wOs);
    this.mYd.setOnLongClickListener(this.wOt);
    final int i = getType();
    label420:
    Object localObject2;
    label457:
    final boolean bool1;
    if (4 == i)
    {
      setMMTitle(s.i.favorite_video);
      if (this.fDI.dataType != 4) {
        break label1038;
      }
      this.wOb.setImageResource(s.h.app_attach_file_icon_video);
      this.mYd.setText(this.fDI.title);
      localObject2 = this.fDI.SyM;
      if (localObject2 != null) {
        break label1069;
      }
      this.wOf.setVisibility(8);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107126);
          n.a(n.a.wGU, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          if ((FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).Q(1, false)))
          {
            AppMethodBeat.o(107126);
            return true;
          }
          if ((FavoriteFileDetailUI.d(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.d(FavoriteFileDetailUI.this).zH(1)))
          {
            AppMethodBeat.o(107126);
            return true;
          }
          FavoriteFileDetailUI.this.finish();
          AppMethodBeat.o(107126);
          return true;
        }
      });
      this.wNZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107127);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
          if (4 == FavoriteFileDetailUI.e(FavoriteFileDetailUI.this))
          {
            FavoriteFileDetailUI.f(FavoriteFileDetailUI.this);
            FavoriteFileDetailUI.g(FavoriteFileDetailUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107127);
            return;
            FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, paramAnonymousView);
          }
        }
      });
      paramBundle = this.fDI.SxU;
      if (!Util.isNullOrNil(paramBundle)) {
        this.uId.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(107128);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId) });
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramBundle);
            paramAnonymousView.putExtra("is_favorite_item", true);
            paramAnonymousView.putExtra("fav_local_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            com.tencent.mm.by.c.b(FavoriteFileDetailUI.this.dlC(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107128);
          }
        });
      }
      this.wOa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_itemStatus) });
          if (!com.tencent.mm.compatible.util.e.avA())
          {
            com.tencent.mm.ui.base.h.p(FavoriteFileDetailUI.this.dlC(), s.i.favorite_no_sdcard, s.i.favorite);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107129);
            return;
          }
          if ((FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).djE()) || (Util.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).Rwb))) {
            com.tencent.mm.plugin.fav.a.b.l(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          }
          for (;;)
          {
            FavoriteFileDetailUI.i(FavoriteFileDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107129);
            return;
            if (!FavoriteFileDetailUI.h(FavoriteFileDetailUI.this))
            {
              com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this), FavoriteFileDetailUI.a(FavoriteFileDetailUI.this), true);
            }
            else
            {
              FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_itemStatus = 7;
              com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this), 18, -1L);
            }
          }
        }
      });
      this.wOe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isDownloading())
          {
            com.tencent.mm.plugin.fav.a.b.e(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.j(FavoriteFileDetailUI.this).setText(s.i.favorite_item_restart_download);
          }
          for (;;)
          {
            FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107130);
            return;
            com.tencent.mm.plugin.fav.a.b.n(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.j(FavoriteFileDetailUI.this).setText(s.i.favorite_item_restart_upload);
          }
        }
      });
      if (this.fNQ)
      {
        final boolean bool2 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label1362;
        }
        bool1 = this.wHw.djA();
        label584:
        if ((bool1) || (bool2)) {
          addIconOptionMenu(0, s.i.top_item_desc_more, s.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(107136);
              if (bool1)
              {
                FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                if ((!com.tencent.mm.plugin.fav.a.k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).SyU == 0)) {}
              }
              else if (!bool2)
              {
                AppMethodBeat.o(107136);
                return false;
              }
              paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(FavoriteFileDetailUI.this.dlC(), 1, false);
              paramAnonymousMenuItem.ODT = new q.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
                {
                  AppMethodBeat.i(107131);
                  if (FavoriteFileDetailUI.17.this.wOA)
                  {
                    FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                    if ((!com.tencent.mm.plugin.fav.a.k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).SyU == 0))
                    {
                      if (FavoriteFileDetailUI.17.this.val$type != 8) {
                        break label267;
                      }
                      paramAnonymous2o.d(0, FavoriteFileDetailUI.this.getString(s.i.favorite_share_with_friend));
                      if ((FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).cbH())) {
                        paramAnonymous2o.d(5, FavoriteFileDetailUI.this.getString(s.i.enter_multi_task));
                      }
                      String str = com.tencent.mm.vfs.u.asq(com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this)));
                      if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBJ()) && (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) != null) && (HandOffFile.isSupportOpenFile(str))) {
                        paramAnonymous2o.d(6, FavoriteFileDetailUI.this.getString(s.i.files_open_in_computer));
                      }
                    }
                  }
                  for (;;)
                  {
                    if (FavoriteFileDetailUI.17.this.wOB)
                    {
                      paramAnonymous2o.d(3, FavoriteFileDetailUI.this.getString(s.i.favorite_edit_tag_tips));
                      paramAnonymous2o.d(2, FavoriteFileDetailUI.this.dlC().getString(s.i.app_delete));
                    }
                    AppMethodBeat.o(107131);
                    return;
                    label267:
                    if (FavoriteFileDetailUI.17.this.val$type == 15)
                    {
                      paramAnonymous2o.d(0, FavoriteFileDetailUI.this.getString(s.i.favorite_share_with_friend));
                      paramAnonymous2o.d(4, FavoriteFileDetailUI.this.getString(s.i.save_video_to_local));
                    }
                    else if (FavoriteFileDetailUI.17.this.val$type == 4)
                    {
                      paramAnonymous2o.d(0, FavoriteFileDetailUI.this.getString(s.i.favorite_share_with_friend));
                      paramAnonymous2o.d(4, FavoriteFileDetailUI.this.getString(s.i.save_video_to_local));
                    }
                    else
                    {
                      paramAnonymous2o.d(0, FavoriteFileDetailUI.this.getString(s.i.favorite_share_with_friend));
                      if ((FavoriteFileDetailUI.17.this.wOB) && (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).djB())) {
                        paramAnonymous2o.d(1, FavoriteFileDetailUI.this.getString(s.i.favorite_post_to_sns));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.ODU = new q.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(107135);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(107135);
                    return;
                    if (FavoriteFileDetailUI.e(FavoriteFileDetailUI.this) == 8)
                    {
                      paramAnonymous2MenuItem = com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
                      if (!com.tencent.mm.vfs.u.agG(paramAnonymous2MenuItem))
                      {
                        Log.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(s.i.favorite_share_file_not_exists), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                      if (new com.tencent.mm.vfs.q(paramAnonymous2MenuItem).length() > FavoriteFileDetailUI.dlI())
                      {
                        Log.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(s.i.favorite_share_too_large), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                    }
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.wNU;
                    paramAnonymous2MenuItem.wGu += 1;
                    FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.wNU;
                    paramAnonymous2MenuItem.wGv += 1;
                    Object localObject = com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.dlC(), FavoriteFileDetailUI.this.getString(s.i.favorite_forward_tips), false, null);
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.dlC();
                    com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(FavoriteFileDetailUI.this);
                    localObject = new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107132);
                        this.wJe.dismiss();
                        AppMethodBeat.o(107132);
                      }
                    };
                    LinkedList localLinkedList = new LinkedList();
                    localLinkedList.add(Integer.valueOf(localg.field_id));
                    paramAnonymous2MenuItem = new ao("", localLinkedList, new l.2(localg, paramAnonymous2MenuItem, (Runnable)localObject));
                    com.tencent.mm.kernel.h.aGY().a(paramAnonymous2MenuItem, 0);
                    AppMethodBeat.o(107135);
                    return;
                    com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.dlC(), FavoriteFileDetailUI.this.getString(s.i.app_delete_tips), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(107134);
                        paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.dlC(), FavoriteFileDetailUI.this.getString(s.i.app_delete_tips), false, null);
                        com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId, new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(107133);
                            FavoriteFileDetailUI.this.wNU.wGy = true;
                            paramAnonymous3DialogInterface.dismiss();
                            Log.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id) });
                            FavoriteFileDetailUI.this.finish();
                            AppMethodBeat.o(107133);
                          }
                        });
                        AppMethodBeat.o(107134);
                      }
                    }, null);
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.wNU;
                    paramAnonymous2MenuItem.wGx += 1;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                    paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.this.dlC(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                    AppMethodBeat.o(107135);
                    return;
                    FavoriteFileDetailUI.n(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(107135);
                    return;
                    if (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null)
                    {
                      FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).iW(true);
                      AppMethodBeat.o(107135);
                      return;
                      if (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) != null) {
                        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).f(FavoriteFileDetailUI.m(FavoriteFileDetailUI.this));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.eik();
              AppMethodBeat.o(107136);
              return true;
            }
          });
        }
      }
      paramBundle = null;
      if (this.wHw != null) {
        paramBundle = String.valueOf(this.wHw.field_id);
      }
      this.wOp = HandOffFile.fromFavItem(this.fDI, paramBundle, null, com.tencent.mm.plugin.fav.a.b.d(this.fDI));
      if (!com.tencent.mm.plugin.fav.a.b.g(this.fDI)) {
        break label1435;
      }
      this.wOp.setFileStatus(1);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).c(this.wOp);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).g(this.wOp);
      nT(false);
      if (getType() == 8)
      {
        localObject2 = com.tencent.mm.plugin.fav.a.b.d(this.fDI);
        bool1 = com.tencent.mm.vfs.u.agG((String)localObject2);
        if (bool1)
        {
          this.wOq = new com.tencent.mm.plugin.fav.ui.b.a(new com.tencent.mm.plugin.fav.ui.b.b((MMActivity)super.getContext()));
          this.wOq.gV((String)localObject2, this.fDI.Syc);
          Object localObject3 = this.wOq;
          paramBundle = this.fDI.Syc;
          String str = this.fDI.title;
          localObject1 = com.tencent.mm.plugin.ball.f.d.aoD(paramBundle);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = com.tencent.mm.plugin.ball.f.d.aoD("unknown");
          }
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject3).rYE.qpN = paramBundle.intValue();
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject3).rYE.name = str;
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject3).cvG();
          this.wOr = new com.tencent.mm.plugin.fav.ui.f.a(new com.tencent.mm.plugin.multitask.a.b((MMActivity)super.getContext()));
          this.wOr.gV((String)localObject2, this.fDI.Syc);
          paramBundle = this.wOr;
          localObject1 = this.fDI.Syc;
          localObject2 = this.fDI.title;
          localObject3 = paramBundle.FHd;
          ((MultiTaskInfo)localObject3).fbc().title = ((String)localObject2);
          ((MultiTaskInfo)localObject3).fbc().jmx = ((String)localObject1);
          paramBundle.faR();
          this.wOp.saveToMultiTaskInfo(this.wOr.FHd);
        }
        Log.i("MicroMsg.FavoriteFileDetailUI", "initFloatBallHelper() ifSupportFB:%s", new Object[] { Boolean.valueOf(bool1) });
      }
      AppMethodBeat.o(107140);
      return;
      if (15 == i)
      {
        setMMTitle(s.i.favorite_video);
        findViewById(s.e.video_container).setBackgroundResource(s.b.black);
        this.mYd.setVisibility(8);
        break;
      }
      setMMTitle(s.i.favorite_file);
      break;
      label1038:
      this.wOb.setImageResource(((ac)com.tencent.mm.kernel.h.ae(ac.class)).aAe(this.fDI.Syc));
      break label420;
      label1069:
      if (Util.isNullOrNil(((anp)localObject2).lor))
      {
        Log.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = ((anp)localObject2).lou;
        localObject1 = ((anp)localObject2).lov;
        if ((!Util.isNullOrNil(paramBundle)) && (!Util.isNullOrNil((String)localObject1)))
        {
          this.wOf.setText(paramBundle);
          this.wOf.setVisibility(0);
          this.wOf.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymousView)
            {
              AppMethodBeat.i(107114);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              paramAnonymousView = new Intent();
              localObject = new Bundle();
              ((Bundle)localObject).putString("key_snsad_statextstr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).fUk);
              paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
              paramAnonymousView.putExtra("rawUrl", this.wOu);
              paramAnonymousView.putExtra("useJs", true);
              new MMHandler(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(107113);
                  com.tencent.mm.by.c.b(FavoriteFileDetailUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                  FavoriteFileDetailUI.this.finish();
                  AppMethodBeat.o(107113);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(107114);
            }
          });
          break label457;
        }
        this.wOf.setVisibility(8);
        break label457;
      }
      Object localObject1 = getResources().getString(s.i.sns_ad_sight_full);
      paramBundle = (Bundle)localObject1;
      if (((anp)localObject2).SAk / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(s.i.sns_ad_sight_full_m, new Object[] { Integer.valueOf(((anp)localObject2).SAk / 60) });
      }
      localObject1 = paramBundle;
      if (((anp)localObject2).SAk % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(s.i.sns_ad_sight_full_s, new Object[] { Integer.valueOf(((anp)localObject2).SAk % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(s.i.sns_ad_sight_full_end);
      this.wOf.setText(paramBundle);
      this.wOf.setVisibility(0);
      this.wOf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107125);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          n.a(n.a.wGS, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          paramAnonymousView = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).SyM;
          localObject = com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
          Intent localIntent = new Intent();
          localIntent.putExtra("KFromTimeLine", false);
          localIntent.putExtra("KStremVideoUrl", paramAnonymousView.lor);
          localIntent.putExtra("StreamWording", paramAnonymousView.lou);
          localIntent.putExtra("StremWebUrl", paramAnonymousView.lov);
          localIntent.putExtra("KBlockFav", true);
          localIntent.putExtra("KThumUrl", paramAnonymousView.low);
          localIntent.putExtra("KThumbPath", (String)localObject);
          localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KMediaVideoTime", paramAnonymousView.SAk);
          localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title);
          localIntent.putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.lox);
          localIntent.putExtra("KSta_StremVideoPublishId", paramAnonymousView.loy);
          localIntent.putExtra("KSta_SourceType", 1);
          localIntent.putExtra("KSta_Scene", n.b.wHc.value);
          localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_fromUser);
          localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).fUk);
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuU, 0) > 0)
          {
            com.tencent.mm.by.c.b(FavoriteFileDetailUI.this, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
            Log.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107125);
            return;
            com.tencent.mm.by.c.b(FavoriteFileDetailUI.this, "sns", ".ui.VideoAdPlayerUI", localIntent);
          }
        }
      });
      break label457;
      label1362:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.n.h.axc().getValue("SIGHTCannotTransmitForFav");
        if ((this.wHw.djA()) && (Util.safeParseInt(paramBundle) == 0))
        {
          bool1 = true;
          break label584;
        }
        bool1 = false;
        break label584;
      }
      if ((this.wHw.djB()) || (this.wHw.djA()))
      {
        bool1 = true;
        break label584;
      }
      bool1 = false;
      break label584;
      label1435:
      if (Util.isNullOrNil(this.fDI.Rwb)) {
        this.wOp.setFileStatus(3);
      } else {
        this.wOp.setFileStatus(2);
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(107145);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(s.i.app_copy));
    AppMethodBeat.o(107145);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107151);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    if (this.txH != null)
    {
      this.txH.setVideoCallback(null);
      this.txH.stop();
      this.txH.onDetach();
    }
    if (this.wOq != null) {
      this.wOq.onDestroy();
    }
    if (this.wOp != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).d(this.wOp);
    }
    super.onDestroy();
    AppMethodBeat.o(107151);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107142);
    Log.i("MicroMsg.FavoriteFileDetailUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.wOr != null) && (this.wOr.Q(2, false)))
    {
      AppMethodBeat.o(107142);
      return true;
    }
    if ((paramInt == 4) && (this.wOq != null) && (this.wOq.zH(2)))
    {
      AppMethodBeat.o(107142);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(107142);
    return bool;
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(107157);
    Log.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.wHw.field_localId) });
    paramString = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.wHw.field_localId);
    if ((paramString == null) && (!this.wOj))
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107157);
      return;
    }
    if (!this.wOj) {
      this.wHw = paramString;
    }
    dlB();
    paramString = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(this.fDI.fEa);
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(107157);
      return;
      if (paramString.field_status == 1)
      {
        bool = true;
      }
      else if (this.fDI.dataType == 8)
      {
        bool = false;
      }
      else if (this.wOo)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(this.fDI.fEa).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.wHw, this.fDI, true);
          this.wOo = true;
        }
        Log.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.wOo) });
        bool = this.wOo;
      }
    }
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107124);
        FavoriteFileDetailUI.y(FavoriteFileDetailUI.this);
        AppMethodBeat.o(107124);
      }
    });
    AppMethodBeat.o(107157);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107153);
    super.onPause();
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().remove(this);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(this);
    if (this.txH != null) {
      this.txH.stop();
    }
    if (this.wOq != null) {
      this.wOq.aOj();
    }
    if (this.wOr != null) {
      this.wOr.aOj();
    }
    AppMethodBeat.o(107153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107152);
    super.onResume();
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().add(this);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(this);
    if (this.txH != null) {
      this.txH.start();
    }
    if (this.wOq != null) {
      this.wOq.bNV();
    }
    if (this.wOr != null) {
      this.wOr.bNV();
    }
    AppMethodBeat.o(107152);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI
 * JD-Core Version:    0.7.0.1
 */