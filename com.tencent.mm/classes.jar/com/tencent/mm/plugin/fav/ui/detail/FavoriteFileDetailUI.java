package com.tencent.mm.plugin.fav.ui.detail;

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
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.plugin.fav.a.n.b;
import com.tencent.mm.plugin.fav.a.n.c;
import com.tencent.mm.plugin.fav.a.n.d;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.l.2;
import com.tencent.mm.plugin.fav.ui.q.b;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI
  extends BaseFavDetailReportUI
  implements q, MStorage.IOnStorageChange
{
  private static final long AkA;
  private com.tencent.mm.plugin.fav.a.g AdF;
  private com.tencent.mm.plugin.fav.a.k Air;
  private Button AkB;
  private Button AkC;
  private MMImageView AkD;
  private TextView AkE;
  private View AkF;
  private View AkG;
  private TextView AkH;
  private ImageView AkI;
  private TextView AkJ;
  private boolean AkK;
  private boolean AkL;
  private String AkM;
  private String AkN;
  private boolean AkO;
  private boolean AkP;
  private boolean AkQ;
  private HandOffFile AkR;
  private com.tencent.mm.plugin.fav.ui.b.a AkS;
  private com.tencent.mm.plugin.fav.ui.e.a AkT;
  private View.OnTouchListener AkU;
  private View.OnLongClickListener AkV;
  private long hDn;
  private arf hIy;
  private boolean hTH;
  private MMHandler mRi;
  private TextView pUL;
  private ProgressBar progressBar;
  private TextView ttU;
  private com.tencent.mm.ui.widget.b.a vEV;
  private com.tencent.mm.pluginsdk.ui.tools.i wCd;
  private Button xQS;
  private int x_down;
  private u.i yBn;
  private int y_down;
  
  static
  {
    AppMethodBeat.i(274509);
    AkA = com.tencent.mm.k.c.aRk();
    AppMethodBeat.o(274509);
  }
  
  public FavoriteFileDetailUI()
  {
    AppMethodBeat.i(107138);
    this.wCd = null;
    this.Air = new com.tencent.mm.plugin.fav.a.k();
    this.AkK = false;
    this.AkL = false;
    this.hTH = true;
    this.AkO = false;
    this.AkP = false;
    this.AkQ = false;
    this.vEV = null;
    this.yBn = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107137);
        if (Util.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)) {}
        for (paramAnonymousMenuItem = FavoriteFileDetailUI.this.getString(q.i.openapi_app_file);; paramAnonymousMenuItem = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)
        {
          ClipboardHelper.setText(MMApplicationContext.getContext(), null, paramAnonymousMenuItem);
          com.tencent.mm.ui.base.k.cZ(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(q.i.app_copy_ok));
          AppMethodBeat.o(107137);
          return;
        }
      }
    };
    this.AkU = new View.OnTouchListener()
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
    this.AkV = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107116);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        Log.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
        if (FavoriteFileDetailUI.o(FavoriteFileDetailUI.this) == null) {
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.dSs()));
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
    this.mRi.post(new Runnable()
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
  
  private void cxo()
  {
    AppMethodBeat.i(107158);
    if (this.AkO)
    {
      AppMethodBeat.o(107158);
      return;
    }
    Object localObject = this.Akw;
    ((h.a)localObject).AcC += 1;
    this.AkO = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.hDn);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(this.hIy));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(this.hIy));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.hIy.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.hIy.iah);
    ((Intent)localObject).putExtra("key_detail_msg_uuid", this.hIy.pbn);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
    AppMethodBeat.o(107158);
  }
  
  private void dSr()
  {
    AppMethodBeat.i(107139);
    this.AkN = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.AdF.field_favProto.vEn.iterator();
    while (localIterator.hasNext())
    {
      arf localarf = (arf)localIterator.next();
      if (localarf.hIQ.equals(this.AkN)) {
        this.hIy = localarf;
      }
    }
    if (this.hIy == null) {
      this.hIy = com.tencent.mm.plugin.fav.a.b.c(this.AdF);
    }
    AppMethodBeat.o(107139);
  }
  
  private void dSt()
  {
    AppMethodBeat.i(107146);
    this.AkD.setVisibility(8);
    this.pUL.setVisibility(8);
    this.AkC.setVisibility(8);
    this.xQS.setVisibility(8);
    this.AkB.setVisibility(8);
    this.AkF.setVisibility(8);
    this.ttU.setVisibility(8);
    this.AkI.setVisibility(0);
    this.AkJ.setVisibility(0);
    if (this.hIy.dataType == 4)
    {
      this.ttU.setGravity(17);
      this.ttU.setText(q.i.favorite_out_of_date_video);
      AppMethodBeat.o(107146);
      return;
    }
    this.ttU.setGravity(17);
    this.ttU.setText(q.i.favorite_out_of_date_file);
    if (this.hIy.ZzM == 2)
    {
      this.AkJ.setText(q.i.favorite_detail_illegal_big_file);
      AppMethodBeat.o(107146);
      return;
    }
    this.AkJ.setText(q.i.favorite_detail_illegal_expired_file);
    AppMethodBeat.o(107146);
  }
  
  private void dSu()
  {
    AppMethodBeat.i(107147);
    this.AkC.setVisibility(8);
    this.xQS.setVisibility(8);
    this.AkB.setVisibility(8);
    this.ttU.setVisibility(8);
    this.AkF.setVisibility(0);
    com.tencent.mm.plugin.fav.a.c localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(this.hIy.hIQ);
    int j;
    int i;
    int k;
    if (localc != null)
    {
      j = (int)localc.getProgress();
      i = localc.field_offset;
      k = localc.field_totalLen;
    }
    while ((this.AdF.dQo()) && (Util.isNullOrNil(this.hIy.Ysw)))
    {
      b(j, getString(q.i.favorite_uploading, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(i), com.tencent.mm.plugin.fav.a.b.getLengthStr(k) }));
      AppMethodBeat.o(107147);
      return;
      k = (int)this.hIy.Zza;
      i = 0;
      j = 0;
    }
    b(j, getString(q.i.favorite_downloading, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(i), com.tencent.mm.plugin.fav.a.b.getLengthStr(k) }));
    AppMethodBeat.o(107147);
  }
  
  private void dSv()
  {
    AppMethodBeat.i(107148);
    this.AkF.setVisibility(8);
    this.AkB.setVisibility(8);
    if (Util.isNullOrNil(this.hIy.ZyM))
    {
      this.xQS.setVisibility(8);
      this.AkC.setVisibility(0);
      localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(this.hIy.hIQ);
      if ((localObject == null) || (((com.tencent.mm.plugin.fav.a.c)localObject).field_offset <= 0)) {
        break label150;
      }
      localObject = this.AkC;
      if (!this.AdF.dQp()) {
        break label143;
      }
    }
    label143:
    for (int i = q.i.favorite_item_restart_upload;; i = q.i.favorite_item_restart_download)
    {
      ((Button)localObject).setText(i);
      this.ttU.setVisibility(8);
      AppMethodBeat.o(107148);
      return;
      this.xQS.setVisibility(0);
      break;
    }
    label150:
    Object localObject = this.AkC;
    if (this.AdF.dQp()) {}
    for (i = q.i.favorite_item_upload;; i = q.i.favorite_item_download)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private boolean dSw()
  {
    AppMethodBeat.i(107149);
    if ((com.tencent.mm.plugin.fav.a.b.g(this.hIy)) && (com.tencent.mm.plugin.fav.a.b.h(this.hIy)))
    {
      AppMethodBeat.o(107149);
      return true;
    }
    AppMethodBeat.o(107149);
    return false;
  }
  
  private void dSx()
  {
    AppMethodBeat.i(107150);
    if ((getType() == 15) && (this.hIy.ZzE != null) && (!Util.isNullOrNil(this.hIy.ZzE.nTu)) && (!Util.isNullOrNil(this.hIy.ZzE.nTy)))
    {
      this.AkP = true;
      this.AkD.setVisibility(8);
      this.AkF.setVisibility(8);
      this.AkC.setVisibility(8);
      this.xQS.setVisibility(8);
      this.AkB.setVisibility(8);
      this.ttU.setVisibility(8);
      String str = com.tencent.mm.plugin.fav.a.b.d(this.hIy);
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.aPW() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(q.e.video_container);
      this.wCd = com.tencent.mm.pluginsdk.ui.tools.w.lG((MMActivity)super.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.wCd, 0, localLayoutParams);
      this.wCd.setVideoCallback(new i.a()
      {
        public final void Qz()
        {
          AppMethodBeat.i(107118);
          Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.aPW() + " onPrepared");
          FavoriteFileDetailUI.s(FavoriteFileDetailUI.this).setLoop(true);
          FavoriteFileDetailUI.s(FavoriteFileDetailUI.this).start();
          AppMethodBeat.o(107118);
        }
        
        public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int gw(int paramAnonymousInt1, int paramAnonymousInt2)
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
              com.tencent.mm.ui.base.k.s(FavoriteFileDetailUI.this.dSs(), q.i.video_file_play_faile, q.i.video_play_err);
              Bitmap localBitmap = FavoriteImageServer.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this), FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
              ImageView localImageView = (ImageView)FavoriteFileDetailUI.this.findViewById(q.e.videoplayer_maskview);
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
      });
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.aPW() + " initView :" + str);
      if (str != null)
      {
        this.wCd.stop();
        this.wCd.setVideoPath(str);
      }
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.aPW() + " initView");
      com.tencent.mm.aw.a.bLi();
      com.tencent.mm.plugin.report.service.h.OAn.b(11444, new Object[] { Integer.valueOf(4) });
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.AkP)
      {
        this.AkF.setVisibility(8);
        this.AkC.setVisibility(8);
        this.xQS.setVisibility(8);
        this.AkB.setVisibility(0);
        this.AkB.setText(q.i.favorite_item_preview);
        this.ttU.setVisibility(8);
        cxo();
      }
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(274456);
          com.tencent.mm.plugin.fav.a.b.o(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          AppMethodBeat.o(274456);
        }
      });
    }
    for (;;)
    {
      if (this.AkR.getFileStatus() != 1)
      {
        this.AkR.setFileStatus(1);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.AkR);
      }
      AppMethodBeat.o(107150);
      return;
      if (!dSw()) {
        break;
      }
      this.AkF.setVisibility(8);
      this.AkC.setVisibility(8);
      this.xQS.setVisibility(0);
      this.AkB.setVisibility(8);
      this.ttU.setVisibility(8);
      this.xQS.setOnClickListener(new FavoriteFileDetailUI.6(this));
    }
    this.AkF.setVisibility(8);
    this.AkC.setVisibility(8);
    if (Util.isNullOrNil(this.hIy.ZyM)) {
      this.xQS.setVisibility(8);
    }
    for (;;)
    {
      this.AkB.setVisibility(0);
      this.Akw.AcB = true;
      this.ttU.setVisibility(0);
      break;
      this.xQS.setVisibility(0);
    }
  }
  
  private int getType()
  {
    AppMethodBeat.i(107143);
    if (this.hIy == null)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
      AppMethodBeat.o(107143);
      return 8;
    }
    if (this.hIy.dataType == 0)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.AdF.field_type) });
      if (4 == this.AdF.field_type)
      {
        AppMethodBeat.o(107143);
        return 4;
      }
      if (16 == this.AdF.field_type)
      {
        if ((this.hIy != null) && (this.hIy.ZzE != null))
        {
          if (!Util.isNullOrNil(this.hIy.ZzE.nTu))
          {
            AppMethodBeat.o(107143);
            return 15;
          }
          if (!Util.isNullOrNil(this.hIy.ZzE.nTy))
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
    if (this.hIy.dataType == 15)
    {
      if ((this.hIy != null) && (this.hIy.ZzE != null))
      {
        if (!Util.isNullOrNil(this.hIy.ZzE.nTu))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
        if (!Util.isNullOrNil(this.hIy.ZzE.nTy))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
      }
      AppMethodBeat.o(107143);
      return 4;
    }
    int i = this.hIy.dataType;
    AppMethodBeat.o(107143);
    return i;
  }
  
  private void pt(boolean paramBoolean)
  {
    AppMethodBeat.i(107144);
    boolean bool = com.tencent.mm.plugin.fav.a.b.g(this.hIy);
    Log.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.AdF.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.d(this.hIy) });
    if (this.hIy.ZzM != 0)
    {
      dSt();
      AppMethodBeat.o(107144);
      return;
    }
    int i;
    if ((this.AdF.isDone()) || (bool) || (!Util.isNullOrNil(this.hIy.Ysw)))
    {
      if (bool)
      {
        dSx();
        i = getIntent().getIntExtra("key_detail_open_way", 0);
        arx localarx;
        if (Util.isEqual(i, 1))
        {
          localarx = new arx();
          localarx.icP = 2;
          ((z)com.tencent.mm.kernel.h.ax(z.class)).a((MMActivity)super.getContext(), this.AdF, localarx);
          AppMethodBeat.o(107144);
          return;
        }
        if (Util.isEqual(i, 2))
        {
          localarx = new arx();
          localarx.icP = 2;
          if ((this.hIy.dataType == 8) && (Util.isEqual(this.hIy.hIQ, this.AkN)))
          {
            com.tencent.mm.plugin.fav.a.g localg = this.AdF.dQt();
            localg.field_type = 8;
            localg.Acq = true;
            localg.Acr = this.AdF;
            localg.hIG = (this.AdF.field_localId + "_" + this.AkN);
            localg.Acs = this.AkN;
            localg.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(this.AdF.field_favProto);
            localg.field_favProto.vEn = new LinkedList();
            localg.field_favProto.vEn.add(this.hIy);
            localg.field_favProto.btm(this.hIy.title);
            ((z)com.tencent.mm.kernel.h.ax(z.class)).a((MMActivity)super.getContext(), localg, localarx);
            AppMethodBeat.o(107144);
            return;
          }
          ((z)com.tencent.mm.kernel.h.ax(z.class)).a((MMActivity)super.getContext(), this.AdF, localarx);
        }
        AppMethodBeat.o(107144);
        return;
      }
      if (Util.isNullOrNil(this.hIy.Ysw))
      {
        dSt();
        AppMethodBeat.o(107144);
        return;
      }
      Log.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
      dSv();
      AppMethodBeat.o(107144);
      return;
    }
    if (this.AdF.dQq())
    {
      if (Util.isNullOrNil(this.hIy.Ysw))
      {
        dSt();
        if (paramBoolean)
        {
          i = getType();
          if ((4 == i) || (15 == i)) {}
          for (i = q.i.favorite_record_video_error;; i = q.i.favorite_record_file_error)
          {
            com.tencent.mm.ui.base.k.cZ((MMActivity)super.getContext(), getString(i));
            AppMethodBeat.o(107144);
            return;
          }
        }
      }
      else
      {
        dSv();
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.k.cZ((MMActivity)super.getContext(), getString(q.i.download_fail));
          AppMethodBeat.o(107144);
        }
      }
    }
    else if (this.AdF.dQp())
    {
      dSv();
      if (paramBoolean)
      {
        com.tencent.mm.ui.base.k.cZ((MMActivity)super.getContext(), getString(q.i.fav_upload_fail));
        AppMethodBeat.o(107144);
      }
    }
    else
    {
      if ((this.AdF.isDownloading()) || (this.AdF.dQo()))
      {
        dSu();
        AppMethodBeat.o(107144);
        return;
      }
      Log.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      dSv();
    }
    AppMethodBeat.o(107144);
  }
  
  public final MMActivity dSs()
  {
    AppMethodBeat.i(369755);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(369755);
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
    Log.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.hIy.hIQ, paramc.field_dataId });
    if (paramc.field_dataId.equals(this.hIy.hIQ))
    {
      if ((this.AdF.dQo()) && (Util.isNullOrNil(this.hIy.Ysw)))
      {
        b(paramc.getProgress(), getString(q.i.favorite_uploading, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_totalLen) }));
        AppMethodBeat.o(107155);
        return;
      }
      b(paramc.getProgress(), getString(q.i.favorite_downloading, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_totalLen) }));
      if ((this.AkL) && (com.tencent.mm.vfs.y.ZC(paramc.field_path)))
      {
        this.AdF.field_itemStatus = 10;
        onNotifyChange("", null);
      }
      AppMethodBeat.o(107155);
      return;
    }
    AppMethodBeat.o(107155);
  }
  
  public void finish()
  {
    AppMethodBeat.i(274524);
    if (this.AkS != null) {
      this.AkS.finish();
    }
    super.finish();
    AppMethodBeat.o(274524);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return q.f.favorite_download_detail_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107154);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((ad)com.tencent.mm.kernel.h.ax(ad.class)).a(this, paramInt1, paramInt2, paramIntent, q.i.no_match_application_msg, q.i.no_match_application_title);
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
          break label154;
        }
      }
      Object localObject2;
      label154:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        localObject2 = com.tencent.mm.ui.base.k.a((MMActivity)super.getContext(), getString(q.i.favorite_forward_tips), false, null);
        Log.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new FavoriteFileDetailUI.7(this, (Dialog)localObject2);
        paramInt2 = getType();
        if (!Util.isNullOrNil((String)localObject1)) {
          break label165;
        }
        AppMethodBeat.o(107154);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label165:
      Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
      label273:
      label317:
      label345:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((paramInt2 == 4) || (paramInt2 == 15))
        {
          l.a((MMActivity)super.getContext(), str, this.hIy, (Runnable)localObject2);
          boolean bool = au.bwE(str);
          if (bool)
          {
            localObject1 = n.c.Ado;
            label251:
            com.tencent.mm.plugin.fav.a.g localg = this.AdF;
            n.d locald = n.d.Ads;
            if (!bool) {
              break label317;
            }
            paramInt1 = v.getMembersCountByChatRoomName(str);
            n.a((n.c)localObject1, localg, locald, paramInt1);
          }
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramIntent)) {
            break label345;
          }
          com.tencent.mm.plugin.messenger.a.g.gaI().ap(str, paramIntent, ab.IX(str));
          break;
          localObject1 = n.c.Adn;
          break label251;
          paramInt1 = 0;
          break label273;
          l.a((MMActivity)super.getContext(), str, this.AdF, this.hIy, (Runnable)localObject2);
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(q.i.fav_finish_sent));
    }
    AppMethodBeat.o(107154);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(107140);
    super.onCreate(paramBundle);
    this.mRi = new MMHandler();
    this.hDn = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.AkL = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.hTH = getIntent().getBooleanExtra("show_share", true);
    this.AkM = getIntent().getStringExtra("fav_note_xml");
    this.AdF = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(this.hDn);
    if ((this.AkL) && (!Util.isNullOrNil(this.AkM))) {
      this.AdF = com.tencent.mm.plugin.fav.a.b.atV(this.AkM);
    }
    if (this.AdF == null)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      AppMethodBeat.o(107140);
      return;
    }
    H(this.AdF);
    n.x(this.AdF);
    dSr();
    this.xQS = ((Button)findViewById(q.e.preview_btn));
    this.AkB = ((Button)findViewById(q.e.open_btn));
    this.AkC = ((Button)findViewById(q.e.download_btn));
    this.AkD = ((MMImageView)findViewById(q.e.icon_iv));
    this.pUL = ((TextView)findViewById(q.e.name_tv));
    this.ttU = ((TextView)findViewById(q.e.tips_tv));
    this.AkG = findViewById(q.e.download_stop_btn);
    this.AkF = findViewById(q.e.download_progress_area);
    this.progressBar = ((ProgressBar)findViewById(q.e.download_pb));
    this.AkE = ((TextView)findViewById(q.e.download_progress_tips));
    this.AkH = ((TextView)findViewById(q.e.show_ad_sight));
    this.AkI = ((ImageView)findViewById(q.e.fav_file_illegal_image));
    this.AkJ = ((TextView)findViewById(q.e.fav_file_illegal_tv));
    this.pUL.setOnTouchListener(this.AkU);
    this.pUL.setOnLongClickListener(this.AkV);
    final int i = getType();
    label420:
    Object localObject2;
    label457:
    final boolean bool1;
    if (4 == i)
    {
      setMMTitle(q.i.favorite_video);
      if (this.hIy.dataType != 4) {
        break label1038;
      }
      this.AkD.setImageResource(q.h.app_attach_file_icon_video);
      this.pUL.setText(this.hIy.title);
      localObject2 = this.hIy.ZzE;
      if (localObject2 != null) {
        break label1068;
      }
      this.AkH.setVisibility(8);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107126);
          n.a(n.a.Add, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          if ((FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).af(1, false)))
          {
            AppMethodBeat.o(107126);
            return true;
          }
          if ((FavoriteFileDetailUI.d(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.d(FavoriteFileDetailUI.this).zX(1)))
          {
            AppMethodBeat.o(107126);
            return true;
          }
          FavoriteFileDetailUI.this.finish();
          AppMethodBeat.o(107126);
          return true;
        }
      });
      this.AkB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107127);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
      paramBundle = this.hIy.ZyM;
      if (!Util.isNullOrNil(paramBundle)) {
        this.xQS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(107128);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId) });
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramBundle);
            paramAnonymousView.putExtra("is_favorite_item", true);
            paramAnonymousView.putExtra("fav_local_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            com.tencent.mm.br.c.b(FavoriteFileDetailUI.this.dSs(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107128);
          }
        });
      }
      this.AkC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_itemStatus) });
          if (!e.aPU())
          {
            com.tencent.mm.ui.base.k.s(FavoriteFileDetailUI.this.dSs(), q.i.favorite_no_sdcard, q.i.favorite);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107129);
            return;
          }
          if ((FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).dQp()) || (Util.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).Ysw))) {
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
      this.AkG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isDownloading())
          {
            com.tencent.mm.plugin.fav.a.b.e(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.j(FavoriteFileDetailUI.this).setText(q.i.favorite_item_restart_download);
          }
          for (;;)
          {
            FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107130);
            return;
            com.tencent.mm.plugin.fav.a.b.n(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.j(FavoriteFileDetailUI.this).setText(q.i.favorite_item_restart_upload);
          }
        }
      });
      if (this.hTH)
      {
        final boolean bool2 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label1361;
        }
        bool1 = this.AdF.dQl();
        label584:
        if ((bool1) || (bool2)) {
          addIconOptionMenu(0, q.i.top_item_desc_more, q.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(107136);
              if (bool1)
              {
                FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                if ((!com.tencent.mm.plugin.fav.a.k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).ZzM == 0)) {}
              }
              else if (!bool2)
              {
                AppMethodBeat.o(107136);
                return false;
              }
              paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(FavoriteFileDetailUI.this.dSs(), 1, false);
              paramAnonymousMenuItem.Vtg = new u.g()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
                {
                  AppMethodBeat.i(107131);
                  if (FavoriteFileDetailUI.17.this.Alc)
                  {
                    FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                    if ((!com.tencent.mm.plugin.fav.a.k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).ZzM == 0))
                    {
                      if (FavoriteFileDetailUI.17.this.val$type != 8) {
                        break label267;
                      }
                      paramAnonymous2s.c(0, FavoriteFileDetailUI.this.getString(q.i.favorite_share_with_friend));
                      if ((FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).cCa())) {
                        paramAnonymous2s.c(5, FavoriteFileDetailUI.this.getString(q.i.enter_multi_task));
                      }
                      String str = com.tencent.mm.vfs.y.alV(com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this)));
                      if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJL()) && (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) != null) && (HandOffFile.isSupportOpenFile(str))) {
                        paramAnonymous2s.c(6, FavoriteFileDetailUI.this.getString(q.i.files_open_in_computer));
                      }
                    }
                  }
                  for (;;)
                  {
                    if (FavoriteFileDetailUI.17.this.Ald)
                    {
                      paramAnonymous2s.c(3, FavoriteFileDetailUI.this.getString(q.i.favorite_edit_tag_tips));
                      paramAnonymous2s.c(2, FavoriteFileDetailUI.this.dSs().getString(q.i.app_delete));
                    }
                    AppMethodBeat.o(107131);
                    return;
                    label267:
                    if (FavoriteFileDetailUI.17.this.val$type == 15)
                    {
                      paramAnonymous2s.c(0, FavoriteFileDetailUI.this.getString(q.i.favorite_share_with_friend));
                      paramAnonymous2s.c(4, FavoriteFileDetailUI.this.getString(q.i.save_video_to_local));
                    }
                    else if (FavoriteFileDetailUI.17.this.val$type == 4)
                    {
                      paramAnonymous2s.c(0, FavoriteFileDetailUI.this.getString(q.i.favorite_share_with_friend));
                      paramAnonymous2s.c(4, FavoriteFileDetailUI.this.getString(q.i.save_video_to_local));
                    }
                    else
                    {
                      paramAnonymous2s.c(0, FavoriteFileDetailUI.this.getString(q.i.favorite_share_with_friend));
                      if ((FavoriteFileDetailUI.17.this.Ald) && (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).dQm())) {
                        paramAnonymous2s.c(1, FavoriteFileDetailUI.this.getString(q.i.favorite_post_to_sns));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.GAC = new u.i()
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
                      if (!com.tencent.mm.vfs.y.ZC(paramAnonymous2MenuItem))
                      {
                        Log.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(q.i.favorite_share_file_not_exists), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                      if (new u(paramAnonymous2MenuItem).length() > FavoriteFileDetailUI.dSy())
                      {
                        Log.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(q.i.favorite_share_too_large), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                    }
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.Akw;
                    paramAnonymous2MenuItem.AcD += 1;
                    FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.Akw;
                    paramAnonymous2MenuItem.AcE += 1;
                    Object localObject = com.tencent.mm.ui.base.k.a(FavoriteFileDetailUI.this.dSs(), FavoriteFileDetailUI.this.getString(q.i.favorite_forward_tips), false, null);
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.dSs();
                    com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(FavoriteFileDetailUI.this);
                    localObject = new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107132);
                        this.Afz.dismiss();
                        AppMethodBeat.o(107132);
                      }
                    };
                    LinkedList localLinkedList = new LinkedList();
                    localLinkedList.add(Integer.valueOf(localg.field_id));
                    paramAnonymous2MenuItem = new ap("", localLinkedList, new l.2(localg, paramAnonymous2MenuItem, (Runnable)localObject));
                    com.tencent.mm.kernel.h.aZW().a(paramAnonymous2MenuItem, 0);
                    AppMethodBeat.o(107135);
                    return;
                    com.tencent.mm.ui.base.k.a(FavoriteFileDetailUI.this.dSs(), FavoriteFileDetailUI.this.getString(q.i.app_delete_tips), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(107134);
                        paramAnonymous3DialogInterface = com.tencent.mm.ui.base.k.a(FavoriteFileDetailUI.this.dSs(), FavoriteFileDetailUI.this.getString(q.i.app_delete_tips), false, null);
                        com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId, new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(107133);
                            FavoriteFileDetailUI.this.Akw.AcH = true;
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
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.Akw;
                    paramAnonymous2MenuItem.AcG += 1;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                    paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.this.dSs(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                    AppMethodBeat.o(107135);
                    return;
                    FavoriteFileDetailUI.n(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(107135);
                    return;
                    if (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null)
                    {
                      FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).ke(true);
                      AppMethodBeat.o(107135);
                      return;
                      if (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) != null) {
                        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).f(FavoriteFileDetailUI.m(FavoriteFileDetailUI.this));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.dDn();
              AppMethodBeat.o(107136);
              return true;
            }
          });
        }
      }
      paramBundle = null;
      if (this.AdF != null) {
        paramBundle = String.valueOf(this.AdF.field_id);
      }
      this.AkR = HandOffFile.fromFavItem(this.hIy, paramBundle, null, com.tencent.mm.plugin.fav.a.b.d(this.hIy));
      if (!com.tencent.mm.plugin.fav.a.b.g(this.hIy)) {
        break label1434;
      }
      this.AkR.setFileStatus(1);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).c(this.AkR);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).g(this.AkR);
      pt(false);
      if (getType() == 8)
      {
        localObject2 = com.tencent.mm.plugin.fav.a.b.d(this.hIy);
        bool1 = com.tencent.mm.vfs.y.ZC((String)localObject2);
        if (bool1)
        {
          this.AkS = new com.tencent.mm.plugin.fav.ui.b.a(new com.tencent.mm.plugin.fav.ui.b.b((MMActivity)super.getContext()));
          this.AkS.hE((String)localObject2, this.hIy.ZyU);
          Object localObject3 = this.AkS;
          paramBundle = this.hIy.ZyU;
          String str = this.hIy.title;
          localObject1 = com.tencent.mm.plugin.ball.f.d.ahZ(paramBundle);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = com.tencent.mm.plugin.ball.f.d.ahZ("unknown");
          }
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject3).vjV.tus = paramBundle.intValue();
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject3).vjV.name = str;
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject3).cYr();
          this.AkT = new com.tencent.mm.plugin.fav.ui.e.a(new com.tencent.mm.plugin.multitask.a.b((MMActivity)super.getContext()));
          this.AkT.hE((String)localObject2, this.hIy.ZyU);
          paramBundle = this.AkT;
          localObject1 = this.hIy.ZyU;
          localObject2 = this.hIy.title;
          localObject3 = paramBundle.LCE;
          ((MultiTaskInfo)localObject3).gkh().title = ((String)localObject2);
          ((MultiTaskInfo)localObject3).gkh().lPJ = ((String)localObject1);
          paramBundle.gjW();
          this.AkR.saveToMultiTaskInfo(this.AkT.LCE);
        }
        Log.i("MicroMsg.FavoriteFileDetailUI", "initFloatBallHelper() ifSupportFB:%s", new Object[] { Boolean.valueOf(bool1) });
      }
      AppMethodBeat.o(107140);
      return;
      if (15 == i)
      {
        setMMTitle(q.i.favorite_video);
        findViewById(q.e.video_container).setBackgroundResource(q.b.black);
        this.pUL.setVisibility(8);
        break;
      }
      setMMTitle(q.i.favorite_file);
      break;
      label1038:
      this.AkD.setImageResource(((ad)com.tencent.mm.kernel.h.ax(ad.class)).aul(this.hIy.ZyU));
      break label420;
      label1068:
      if (Util.isNullOrNil(((ari)localObject2).nTu))
      {
        Log.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = ((ari)localObject2).nTx;
        localObject1 = ((ari)localObject2).nTy;
        if ((!Util.isNullOrNil(paramBundle)) && (!Util.isNullOrNil((String)localObject1)))
        {
          this.AkH.setText(paramBundle);
          this.AkH.setVisibility(0);
          this.AkH.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymousView)
            {
              AppMethodBeat.i(107114);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              paramAnonymousView = new Intent();
              localObject = new Bundle();
              ((Bundle)localObject).putString("key_snsad_statextstr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).iah);
              paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
              paramAnonymousView.putExtra("rawUrl", this.AkW);
              paramAnonymousView.putExtra("useJs", true);
              new MMHandler(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(107113);
                  com.tencent.mm.br.c.b(FavoriteFileDetailUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
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
        this.AkH.setVisibility(8);
        break label457;
      }
      Object localObject1 = getResources().getString(q.i.sns_ad_sight_full);
      paramBundle = (Bundle)localObject1;
      if (((ari)localObject2).ZBc / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(q.i.sns_ad_sight_full_m, new Object[] { Integer.valueOf(((ari)localObject2).ZBc / 60) });
      }
      localObject1 = paramBundle;
      if (((ari)localObject2).ZBc % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(q.i.sns_ad_sight_full_s, new Object[] { Integer.valueOf(((ari)localObject2).ZBc % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(q.i.sns_ad_sight_full_end);
      this.AkH.setText(paramBundle);
      this.AkH.setVisibility(0);
      this.AkH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107125);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          n.a(n.a.Adb, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          paramAnonymousView = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).ZzE;
          localObject = com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
          Intent localIntent = new Intent();
          localIntent.putExtra("KFromTimeLine", false);
          localIntent.putExtra("KStremVideoUrl", paramAnonymousView.nTu);
          localIntent.putExtra("StreamWording", paramAnonymousView.nTx);
          localIntent.putExtra("StremWebUrl", paramAnonymousView.nTy);
          localIntent.putExtra("KBlockFav", true);
          localIntent.putExtra("KThumUrl", paramAnonymousView.nTz);
          localIntent.putExtra("KThumbPath", (String)localObject);
          localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KMediaVideoTime", paramAnonymousView.ZBc);
          localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title);
          localIntent.putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.nTA);
          localIntent.putExtra("KSta_StremVideoPublishId", paramAnonymousView.nTB);
          localIntent.putExtra("KSta_SourceType", 1);
          localIntent.putExtra("KSta_Scene", n.b.Adl.value);
          localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_fromUser);
          localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).iah);
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHP, 0) > 0)
          {
            com.tencent.mm.br.c.b(FavoriteFileDetailUI.this, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
            Log.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107125);
            return;
            com.tencent.mm.br.c.b(FavoriteFileDetailUI.this, "sns", ".ui.VideoAdPlayerUI", localIntent);
          }
        }
      });
      break label457;
      label1361:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.k.i.aRC().getValue("SIGHTCannotTransmitForFav");
        if ((this.AdF.dQl()) && (Util.safeParseInt(paramBundle) == 0))
        {
          bool1 = true;
          break label584;
        }
        bool1 = false;
        break label584;
      }
      if ((this.AdF.dQm()) || (this.AdF.dQl()))
      {
        bool1 = true;
        break label584;
      }
      bool1 = false;
      break label584;
      label1434:
      if (Util.isNullOrNil(this.hIy.Ysw)) {
        this.AkR.setFileStatus(3);
      } else {
        this.AkR.setFileStatus(2);
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(107145);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(q.i.app_copy));
    AppMethodBeat.o(107145);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107151);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    if (this.wCd != null)
    {
      this.wCd.setVideoCallback(null);
      this.wCd.stop();
      this.wCd.onDetach();
    }
    if (this.AkS != null) {
      this.AkS.onDestroy();
    }
    if (this.AkR != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).d(this.AkR);
    }
    super.onDestroy();
    AppMethodBeat.o(107151);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107142);
    Log.i("MicroMsg.FavoriteFileDetailUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.AkT != null) && (this.AkT.af(2, false)))
    {
      AppMethodBeat.o(107142);
      return true;
    }
    if ((paramInt == 4) && (this.AkS != null) && (this.AkS.zX(2)))
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
    Log.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.AdF.field_localId) });
    paramString = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(this.AdF.field_localId);
    if ((paramString == null) && (!this.AkL))
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107157);
      return;
    }
    if (!this.AkL) {
      this.AdF = paramString;
    }
    dSr();
    paramString = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(this.hIy.hIQ);
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
      else if (this.hIy.dataType == 8)
      {
        bool = false;
      }
      else if (this.AkQ)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(this.hIy.hIQ).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.AdF, this.hIy, true);
          this.AkQ = true;
        }
        Log.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.AkQ) });
        bool = this.AkQ;
      }
    }
    this.mRi.post(new Runnable()
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
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().remove(this);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(this);
    if (this.wCd != null) {
      this.wCd.stop();
    }
    if (this.AkS != null) {
      this.AkS.bhW();
    }
    if (this.AkT != null) {
      this.AkT.bhW();
    }
    AppMethodBeat.o(107153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107152);
    super.onResume();
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().add(this);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(this);
    if (this.wCd != null) {
      this.wCd.start();
    }
    if (this.AkS != null) {
      this.AkS.coi();
    }
    if (this.AkT != null) {
      this.AkT.coi();
    }
    AppMethodBeat.o(107152);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI
 * JD-Core Version:    0.7.0.1
 */