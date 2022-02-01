package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.l.2;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI
  extends BaseFavDetailReportUI
  implements p, MStorage.IOnStorageChange
{
  private static final long thH;
  private com.tencent.mm.plugin.fav.ui.g.a RbU;
  private com.tencent.mm.plugin.fav.ui.e.a RbV;
  private long dFW;
  private aml dKT;
  private boolean dUo;
  private MMHandler hAk;
  private TextView kgE;
  private TextView nnM;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private ProgressBar progressBar;
  private j qbJ;
  private o.g rJj;
  private Button reX;
  private com.tencent.mm.plugin.fav.a.g tbr;
  private k tfE;
  private Button thI;
  private Button thJ;
  private MMImageView thK;
  private TextView thL;
  private View thM;
  private View thN;
  private TextView thO;
  private ImageView thP;
  private TextView thQ;
  private boolean thR;
  private boolean thS;
  private String thT;
  private String thU;
  private boolean thV;
  private boolean thW;
  private boolean thX;
  private HandOffFile thY;
  private View.OnTouchListener tia;
  private View.OnLongClickListener tib;
  
  static
  {
    AppMethodBeat.i(235332);
    thH = com.tencent.mm.n.c.aqr();
    AppMethodBeat.o(235332);
  }
  
  public FavoriteFileDetailUI()
  {
    AppMethodBeat.i(107138);
    this.qbJ = null;
    this.tfE = new k();
    this.thR = false;
    this.thS = false;
    this.dUo = true;
    this.thV = false;
    this.thW = false;
    this.thX = false;
    this.pqr = null;
    this.rJj = new FavoriteFileDetailUI.18(this);
    this.tia = new View.OnTouchListener()
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
          FavoriteFileDetailUI.b(FavoriteFileDetailUI.this, (int)paramAnonymousMotionEvent.getRawX());
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    this.tib = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107116);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
        if (FavoriteFileDetailUI.o(FavoriteFileDetailUI.this) == null) {
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.cWv()));
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
    this.hAk.post(new Runnable()
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
  
  private void bLd()
  {
    AppMethodBeat.i(107158);
    if (this.thV)
    {
      AppMethodBeat.o(107158);
      return;
    }
    Object localObject = this.thD;
    ((h.a)localObject).taq += 1;
    this.thV = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.dFW);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(this.dKT));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(this.dKT));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.dKT.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.dKT.ean);
    ((Intent)localObject).putExtra("key_detail_msg_uuid", this.dKT.jsz);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
    AppMethodBeat.o(107158);
  }
  
  private void cWA()
  {
    AppMethodBeat.i(107150);
    if ((getType() == 15) && (this.dKT.Lwn != null) && (!Util.isNullOrNil(this.dKT.Lwn.iyZ)) && (!Util.isNullOrNil(this.dKT.Lwn.izd)))
    {
      this.thW = true;
      this.thK.setVisibility(8);
      this.thM.setVisibility(8);
      this.thJ.setVisibility(8);
      this.reX.setVisibility(8);
      this.thI.setVisibility(8);
      this.nnM.setVisibility(8);
      String str = com.tencent.mm.plugin.fav.a.b.d(this.dKT);
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.app() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131309736);
      this.qbJ = com.tencent.mm.pluginsdk.ui.tools.v.iE((MMActivity)super.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.qbJ, 0, localLayoutParams);
      this.qbJ.setVideoCallback(new j.a()
      {
        public final void eo(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fh(int paramAnonymousInt1, int paramAnonymousInt2)
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
              com.tencent.mm.ui.base.h.n(FavoriteFileDetailUI.this.cWv(), 2131767073, 2131767097);
              Bitmap localBitmap = com.tencent.mm.plugin.fav.ui.o.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this), FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
              ImageView localImageView = (ImageView)FavoriteFileDetailUI.this.findViewById(2131309846);
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
        
        public final void tf()
        {
          AppMethodBeat.i(107118);
          Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.app() + " onPrepared");
          FavoriteFileDetailUI.s(FavoriteFileDetailUI.this).setLoop(true);
          FavoriteFileDetailUI.s(FavoriteFileDetailUI.this).start();
          AppMethodBeat.o(107118);
        }
      });
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.app() + " initView :" + str);
      if (str != null)
      {
        this.qbJ.stop();
        this.qbJ.setVideoPath(str);
      }
      Log.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.f.app() + " initView");
      com.tencent.mm.ay.a.bea();
      com.tencent.mm.plugin.report.service.h.CyF.a(11444, new Object[] { Integer.valueOf(4) });
    }
    if ((getType() == 15) || (getType() == 4)) {
      if (!this.thW)
      {
        this.thM.setVisibility(8);
        this.thJ.setVisibility(8);
        this.reX.setVisibility(8);
        this.thI.setVisibility(0);
        this.thI.setText(2131759244);
        this.nnM.setVisibility(8);
        bLd();
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107121);
          com.tencent.mm.plugin.fav.a.b.o(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          AppMethodBeat.o(107121);
        }
      });
      if (this.thY.getFileStatus() != 1)
      {
        this.thY.setFileStatus(1);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.thY);
      }
      AppMethodBeat.o(107150);
      return;
      if (!cWz()) {
        break;
      }
      this.thM.setVisibility(8);
      this.thJ.setVisibility(8);
      this.reX.setVisibility(0);
      this.thI.setVisibility(8);
      this.nnM.setVisibility(8);
      this.reX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107120);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          FavoriteFileDetailUI.v(FavoriteFileDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107120);
        }
      });
    }
    this.thM.setVisibility(8);
    this.thJ.setVisibility(8);
    if (Util.isNullOrNil(this.dKT.Lvu)) {
      this.reX.setVisibility(8);
    }
    for (;;)
    {
      this.thI.setVisibility(0);
      this.thD.tap = true;
      this.nnM.setVisibility(0);
      break;
      this.reX.setVisibility(0);
    }
  }
  
  private void cWu()
  {
    AppMethodBeat.i(107139);
    this.thU = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.tbr.field_favProto.ppH.iterator();
    while (localIterator.hasNext())
    {
      aml localaml = (aml)localIterator.next();
      if (localaml.dLl.equals(this.thU)) {
        this.dKT = localaml;
      }
    }
    if (this.dKT == null) {
      this.dKT = com.tencent.mm.plugin.fav.a.b.c(this.tbr);
    }
    AppMethodBeat.o(107139);
  }
  
  private void cWw()
  {
    AppMethodBeat.i(107146);
    this.thK.setVisibility(8);
    this.kgE.setVisibility(8);
    this.thJ.setVisibility(8);
    this.reX.setVisibility(8);
    this.thI.setVisibility(8);
    this.thM.setVisibility(8);
    this.nnM.setVisibility(8);
    this.thP.setVisibility(0);
    this.thQ.setVisibility(0);
    if (this.dKT.dataType == 4)
    {
      this.nnM.setGravity(17);
      this.nnM.setText(2131759265);
      AppMethodBeat.o(107146);
      return;
    }
    this.nnM.setGravity(17);
    this.nnM.setText(2131759264);
    if (this.dKT.Lwv == 2)
    {
      this.thQ.setText(2131759181);
      AppMethodBeat.o(107146);
      return;
    }
    this.thQ.setText(2131759182);
    AppMethodBeat.o(107146);
  }
  
  private void cWx()
  {
    AppMethodBeat.i(107147);
    this.thJ.setVisibility(8);
    this.reX.setVisibility(8);
    this.thI.setVisibility(8);
    this.nnM.setVisibility(8);
    this.thM.setVisibility(0);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
    int j;
    int i;
    int k;
    if (localc != null)
    {
      j = (int)localc.getProgress();
      i = localc.field_offset;
      k = localc.field_totalLen;
    }
    while ((this.tbr.cUx()) && (Util.isNullOrNil(this.dKT.KuR)))
    {
      b(j, getString(2131759354, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(i), com.tencent.mm.plugin.fav.a.b.getLengthStr(k) }));
      AppMethodBeat.o(107147);
      return;
      k = (int)this.dKT.LvI;
      i = 0;
      j = 0;
    }
    b(j, getString(2131759196, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(i), com.tencent.mm.plugin.fav.a.b.getLengthStr(k) }));
    AppMethodBeat.o(107147);
  }
  
  private void cWy()
  {
    AppMethodBeat.i(107148);
    this.thM.setVisibility(8);
    this.thI.setVisibility(8);
    if (Util.isNullOrNil(this.dKT.Lvu))
    {
      this.reX.setVisibility(8);
      this.thJ.setVisibility(0);
      localObject = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
      if ((localObject == null) || (((com.tencent.mm.plugin.fav.a.c)localObject).field_offset <= 0)) {
        break label150;
      }
      localObject = this.thJ;
      if (!this.tbr.cUy()) {
        break label143;
      }
    }
    label143:
    for (int i = 2131759246;; i = 2131759245)
    {
      ((Button)localObject).setText(i);
      this.nnM.setVisibility(8);
      AppMethodBeat.o(107148);
      return;
      this.reX.setVisibility(0);
      break;
    }
    label150:
    Object localObject = this.thJ;
    if (this.tbr.cUy()) {}
    for (i = 2131759247;; i = 2131759242)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private boolean cWz()
  {
    AppMethodBeat.i(107149);
    if ((com.tencent.mm.plugin.fav.a.b.g(this.dKT)) && (com.tencent.mm.plugin.fav.a.b.h(this.dKT)))
    {
      AppMethodBeat.o(107149);
      return true;
    }
    AppMethodBeat.o(107149);
    return false;
  }
  
  private int getType()
  {
    AppMethodBeat.i(107143);
    if (this.dKT == null)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
      AppMethodBeat.o(107143);
      return 8;
    }
    if (this.dKT.dataType == 0)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.tbr.field_type) });
      if (4 == this.tbr.field_type)
      {
        AppMethodBeat.o(107143);
        return 4;
      }
      if (16 == this.tbr.field_type)
      {
        if ((this.dKT != null) && (this.dKT.Lwn != null))
        {
          if (!Util.isNullOrNil(this.dKT.Lwn.iyZ))
          {
            AppMethodBeat.o(107143);
            return 15;
          }
          if (!Util.isNullOrNil(this.dKT.Lwn.izd))
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
    if (this.dKT.dataType == 15)
    {
      if ((this.dKT != null) && (this.dKT.Lwn != null))
      {
        if (!Util.isNullOrNil(this.dKT.Lwn.iyZ))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
        if (!Util.isNullOrNil(this.dKT.Lwn.izd))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
      }
      AppMethodBeat.o(107143);
      return 4;
    }
    int i = this.dKT.dataType;
    AppMethodBeat.o(107143);
    return i;
  }
  
  private void mF(boolean paramBoolean)
  {
    AppMethodBeat.i(107144);
    boolean bool = com.tencent.mm.plugin.fav.a.b.g(this.dKT);
    Log.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.tbr.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.d(this.dKT) });
    if (this.dKT.Lwv != 0)
    {
      cWw();
      AppMethodBeat.o(107144);
      return;
    }
    int i;
    if ((this.tbr.isDone()) || (bool) || (!Util.isNullOrNil(this.dKT.KuR)))
    {
      if (bool)
      {
        cWA();
        i = getIntent().getIntExtra("key_detail_open_way", 0);
        and localand;
        if (Util.isEqual(i, 1))
        {
          localand = new and();
          localand.ecL = 2;
          ((y)com.tencent.mm.kernel.g.af(y.class)).a((MMActivity)super.getContext(), this.tbr, localand);
          AppMethodBeat.o(107144);
          return;
        }
        if (Util.isEqual(i, 2))
        {
          localand = new and();
          localand.ecL = 2;
          if ((this.dKT.dataType == 8) && (Util.isEqual(this.dKT.dLl, this.thU)))
          {
            com.tencent.mm.plugin.fav.a.g localg = this.tbr.cUC();
            localg.field_type = 8;
            localg.tad = true;
            localg.tae = this.tbr;
            localg.dLb = (this.tbr.field_localId + "_" + this.thU);
            localg.taf = this.thU;
            localg.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(this.tbr.field_favProto);
            localg.field_favProto.ppH = new LinkedList();
            localg.field_favProto.ppH.add(this.dKT);
            localg.field_favProto.bhd(this.dKT.title);
            ((y)com.tencent.mm.kernel.g.af(y.class)).a((MMActivity)super.getContext(), localg, localand);
            AppMethodBeat.o(107144);
            return;
          }
          ((y)com.tencent.mm.kernel.g.af(y.class)).a((MMActivity)super.getContext(), this.tbr, localand);
        }
        AppMethodBeat.o(107144);
        return;
      }
      if (Util.isNullOrNil(this.dKT.KuR))
      {
        cWw();
        AppMethodBeat.o(107144);
        return;
      }
      Log.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
      cWy();
      AppMethodBeat.o(107144);
      return;
    }
    if (this.tbr.cUz())
    {
      if (Util.isNullOrNil(this.dKT.KuR))
      {
        cWw();
        if (paramBoolean)
        {
          i = getType();
          if ((4 == i) || (15 == i)) {}
          for (i = 2131759303;; i = 2131759289)
          {
            com.tencent.mm.ui.base.h.cD((MMActivity)super.getContext(), getString(i));
            AppMethodBeat.o(107144);
            return;
          }
        }
      }
      else
      {
        cWy();
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.cD((MMActivity)super.getContext(), getString(2131758370));
          AppMethodBeat.o(107144);
        }
      }
    }
    else if (this.tbr.cUy())
    {
      cWy();
      if (paramBoolean)
      {
        com.tencent.mm.ui.base.h.cD((MMActivity)super.getContext(), getString(2131759167));
        AppMethodBeat.o(107144);
      }
    }
    else
    {
      if ((this.tbr.isDownloading()) || (this.tbr.cUx()))
      {
        cWx();
        AppMethodBeat.o(107144);
        return;
      }
      Log.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      cWy();
    }
    AppMethodBeat.o(107144);
  }
  
  public final MMActivity cWv()
  {
    AppMethodBeat.i(258677);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(258677);
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
    Log.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.dKT.dLl, paramc.field_dataId });
    if (paramc.field_dataId.equals(this.dKT.dLl))
    {
      if ((this.tbr.cUx()) && (Util.isNullOrNil(this.dKT.KuR)))
      {
        b(paramc.getProgress(), getString(2131759354, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_totalLen) }));
        AppMethodBeat.o(107155);
        return;
      }
      b(paramc.getProgress(), getString(2131759196, new Object[] { com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.getLengthStr(paramc.field_totalLen) }));
      if ((this.thS) && (s.YS(paramc.field_path)))
      {
        this.tbr.field_itemStatus = 10;
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
    return 2131494157;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107154);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).c(this, paramInt1, paramInt2, paramIntent);
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
          break label148;
        }
      }
      Object localObject2;
      label148:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        localObject2 = com.tencent.mm.ui.base.h.a((MMActivity)super.getContext(), getString(2131759230), false, null);
        Log.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107122);
            this.tcT.dismiss();
            AppMethodBeat.o(107122);
          }
        };
        paramInt2 = getType();
        if (!Util.isNullOrNil((String)localObject1)) {
          break label159;
        }
        AppMethodBeat.o(107154);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label159:
      Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
      label267:
      label311:
      label339:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((paramInt2 == 4) || (paramInt2 == 15))
        {
          l.a((MMActivity)super.getContext(), str, this.dKT, (Runnable)localObject2);
          boolean bool = com.tencent.mm.model.ab.Eq(str);
          if (bool)
          {
            localObject1 = m.c.tba;
            label245:
            com.tencent.mm.plugin.fav.a.g localg = this.tbr;
            m.d locald = m.d.tbe;
            if (!bool) {
              break label311;
            }
            paramInt1 = com.tencent.mm.model.v.Ie(str);
            com.tencent.mm.plugin.fav.a.m.a((m.c)localObject1, localg, locald, paramInt1);
          }
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramIntent)) {
            break label339;
          }
          com.tencent.mm.plugin.messenger.a.g.eir().ad(str, paramIntent, com.tencent.mm.model.ab.JG(str));
          break;
          localObject1 = m.c.taZ;
          break label245;
          paramInt1 = 0;
          break label267;
          l.a((MMActivity)super.getContext(), str, this.tbr, this.dKT, (Runnable)localObject2);
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131759157));
    }
    AppMethodBeat.o(107154);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107140);
    super.onCreate(paramBundle);
    this.hAk = new MMHandler();
    this.dFW = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.thS = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.dUo = getIntent().getBooleanExtra("show_share", true);
    this.thT = getIntent().getStringExtra("fav_note_xml");
    this.tbr = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.dFW);
    if ((this.thS) && (!Util.isNullOrNil(this.thT))) {
      this.tbr = com.tencent.mm.plugin.fav.a.b.arO(this.thT);
    }
    if (this.tbr == null)
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      AppMethodBeat.o(107140);
      return;
    }
    H(this.tbr);
    com.tencent.mm.plugin.fav.a.m.x(this.tbr);
    cWu();
    this.reX = ((Button)findViewById(2131306105));
    this.thI = ((Button)findViewById(2131305616));
    this.thJ = ((Button)findViewById(2131299751));
    this.thK = ((MMImageView)findViewById(2131302497));
    this.kgE = ((TextView)findViewById(2131305220));
    this.nnM = ((TextView)findViewById(2131309187));
    this.thN = findViewById(2131299784);
    this.thM = findViewById(2131299778);
    this.progressBar = ((ProgressBar)findViewById(2131299776));
    this.thL = ((TextView)findViewById(2131299780));
    this.thO = ((TextView)findViewById(2131307859));
    this.thP = ((ImageView)findViewById(2131300464));
    this.thQ = ((TextView)findViewById(2131300465));
    this.kgE.setOnTouchListener(this.tia);
    this.kgE.setOnLongClickListener(this.tib);
    final int i = getType();
    label420:
    Object localObject2;
    label457:
    final boolean bool1;
    if (4 == i)
    {
      setMMTitle(2131759356);
      if (this.dKT.dataType != 4) {
        break label1038;
      }
      this.thK.setImageResource(2131689584);
      this.kgE.setText(this.dKT.title);
      localObject2 = this.dKT.Lwn;
      if (localObject2 != null) {
        break label1068;
      }
      this.thO.setVisibility(8);
      setBackBtn(new FavoriteFileDetailUI.12(this));
      this.thI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107127);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      paramBundle = this.dKT.Lvu;
      if (!Util.isNullOrNil(paramBundle)) {
        this.reX.setOnClickListener(new FavoriteFileDetailUI.14(this, paramBundle));
      }
      this.thJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_itemStatus) });
          if (!com.tencent.mm.compatible.util.e.apn())
          {
            com.tencent.mm.ui.base.h.n(FavoriteFileDetailUI.this.cWv(), 2131759258, 2131759168);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107129);
            return;
          }
          if ((FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).cUy()) || (Util.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).KuR))) {
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
      this.thN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isDownloading())
          {
            com.tencent.mm.plugin.fav.a.b.e(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.j(FavoriteFileDetailUI.this).setText(2131759245);
          }
          for (;;)
          {
            FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107130);
            return;
            com.tencent.mm.plugin.fav.a.b.n(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.j(FavoriteFileDetailUI.this).setText(2131759246);
          }
        }
      });
      if (this.dUo)
      {
        final boolean bool2 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label1361;
        }
        bool1 = this.tbr.cUu();
        label584:
        if ((bool1) || (bool2)) {
          addIconOptionMenu(0, 2131766795, 2131690843, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(107136);
              if (bool1)
              {
                FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                if ((!k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).Lwv == 0)) {}
              }
              else if (!bool2)
              {
                AppMethodBeat.o(107136);
                return false;
              }
              paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(FavoriteFileDetailUI.this.cWv(), 1, false);
              paramAnonymousMenuItem.HLX = new o.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
                {
                  AppMethodBeat.i(107131);
                  if (FavoriteFileDetailUI.17.this.tij)
                  {
                    FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                    if ((!k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).Lwv == 0))
                    {
                      if (FavoriteFileDetailUI.17.this.val$type != 8) {
                        break label262;
                      }
                      paramAnonymous2m.d(0, FavoriteFileDetailUI.this.getString(2131759326));
                      if ((FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bPq())) {
                        paramAnonymous2m.d(5, FavoriteFileDetailUI.this.getString(2131758718));
                      }
                      String str = s.akC(com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this)));
                      if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl()) && (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) != null) && (HandOffFile.isSupportOpenFile(str))) {
                        paramAnonymous2m.d(6, FavoriteFileDetailUI.this.getString(2131759414));
                      }
                    }
                  }
                  for (;;)
                  {
                    if (FavoriteFileDetailUI.17.this.tik)
                    {
                      paramAnonymous2m.d(3, FavoriteFileDetailUI.this.getString(2131759199));
                      paramAnonymous2m.d(2, FavoriteFileDetailUI.this.cWv().getString(2131755778));
                    }
                    AppMethodBeat.o(107131);
                    return;
                    label262:
                    if (FavoriteFileDetailUI.17.this.val$type == 15)
                    {
                      paramAnonymous2m.d(0, FavoriteFileDetailUI.this.getString(2131759326));
                      paramAnonymous2m.d(4, FavoriteFileDetailUI.this.getString(2131764871));
                    }
                    else if (FavoriteFileDetailUI.17.this.val$type == 4)
                    {
                      paramAnonymous2m.d(0, FavoriteFileDetailUI.this.getString(2131759326));
                      paramAnonymous2m.d(4, FavoriteFileDetailUI.this.getString(2131764871));
                    }
                    else
                    {
                      paramAnonymous2m.d(0, FavoriteFileDetailUI.this.getString(2131759326));
                      if ((FavoriteFileDetailUI.17.this.tik) && (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).cUv())) {
                        paramAnonymous2m.d(1, FavoriteFileDetailUI.this.getString(2131759275));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.HLY = new o.g()
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
                      if (!s.YS(paramAnonymous2MenuItem))
                      {
                        Log.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131759324), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                      if (new com.tencent.mm.vfs.o(paramAnonymous2MenuItem).length() > FavoriteFileDetailUI.heP())
                      {
                        Log.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131759325), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                    }
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.thD;
                    paramAnonymous2MenuItem.tar += 1;
                    FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.thD;
                    paramAnonymous2MenuItem.tas += 1;
                    Object localObject = com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.cWv(), FavoriteFileDetailUI.this.getString(2131759230), false, null);
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.cWv();
                    com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(FavoriteFileDetailUI.this);
                    localObject = new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107132);
                        this.tcT.dismiss();
                        AppMethodBeat.o(107132);
                      }
                    };
                    LinkedList localLinkedList = new LinkedList();
                    localLinkedList.add(Integer.valueOf(localg.field_id));
                    paramAnonymous2MenuItem = new an("", localLinkedList, new l.2(localg, paramAnonymous2MenuItem, (Runnable)localObject));
                    com.tencent.mm.kernel.g.azz().a(paramAnonymous2MenuItem, 0);
                    AppMethodBeat.o(107135);
                    return;
                    com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.cWv(), FavoriteFileDetailUI.this.getString(2131755780), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(107134);
                        paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.cWv(), FavoriteFileDetailUI.this.getString(2131755780), false, null);
                        com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId, new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(107133);
                            FavoriteFileDetailUI.this.thD.tav = true;
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
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.thD;
                    paramAnonymous2MenuItem.tau += 1;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                    paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.this.cWv(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                    AppMethodBeat.o(107135);
                    return;
                    FavoriteFileDetailUI.n(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(107135);
                    return;
                    if (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null)
                    {
                      FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).ic(true);
                      AppMethodBeat.o(107135);
                      return;
                      if (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) != null) {
                        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(FavoriteFileDetailUI.m(FavoriteFileDetailUI.this));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.dGm();
              AppMethodBeat.o(107136);
              return true;
            }
          });
        }
      }
      paramBundle = null;
      if (this.tbr != null) {
        paramBundle = String.valueOf(this.tbr.field_id);
      }
      this.thY = HandOffFile.fromFavItem(this.dKT, paramBundle, null, com.tencent.mm.plugin.fav.a.b.d(this.dKT));
      if (!com.tencent.mm.plugin.fav.a.b.g(this.dKT)) {
        break label1434;
      }
      this.thY.setFileStatus(1);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).c(this.thY);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.thY);
      mF(false);
      if (getType() == 8)
      {
        localObject2 = com.tencent.mm.plugin.fav.a.b.d(this.dKT);
        bool1 = s.YS((String)localObject2);
        if (bool1)
        {
          this.RbU = new com.tencent.mm.plugin.fav.ui.g.a(new com.tencent.mm.plugin.fav.ui.g.b((MMActivity)super.getContext()));
          this.RbU.gH((String)localObject2, this.dKT.LvC);
          Object localObject3 = this.RbU;
          paramBundle = this.dKT.LvC;
          String str = this.dKT.title;
          localObject1 = com.tencent.mm.plugin.ball.f.d.agX(paramBundle);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = com.tencent.mm.plugin.ball.f.d.agX("unknown");
          }
          ((com.tencent.mm.plugin.fav.ui.g.a)localObject3).oWE.noe = paramBundle.intValue();
          ((com.tencent.mm.plugin.fav.ui.g.a)localObject3).oWE.name = str;
          ((com.tencent.mm.plugin.fav.ui.g.a)localObject3).cit();
          this.RbV = new com.tencent.mm.plugin.fav.ui.e.a(new com.tencent.mm.plugin.multitask.a.b((MMActivity)super.getContext()));
          this.RbV.gH((String)localObject2, this.dKT.LvC);
          paramBundle = this.RbV;
          localObject1 = this.dKT.LvC;
          localObject2 = this.dKT.title;
          localObject3 = paramBundle.Abp;
          ((MultiTaskInfo)localObject3).erh().title = ((String)localObject2);
          ((MultiTaskInfo)localObject3).erh().gCr = ((String)localObject1);
          paramBundle.eqX();
          this.thY.saveToMultiTaskInfo(this.RbV.Abp);
        }
        Log.i("MicroMsg.FavoriteFileDetailUI", "initFloatBallHelper() ifSupportFB:%s", new Object[] { Boolean.valueOf(bool1) });
      }
      AppMethodBeat.o(107140);
      return;
      if (15 == i)
      {
        setMMTitle(2131759356);
        findViewById(2131309736).setBackgroundResource(2131100042);
        this.kgE.setVisibility(8);
        break;
      }
      setMMTitle(2131759228);
      break;
      label1038:
      this.thK.setImageResource(((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).asd(this.dKT.LvC));
      break label420;
      label1068:
      if (Util.isNullOrNil(((amo)localObject2).iyZ))
      {
        Log.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = ((amo)localObject2).izc;
        localObject1 = ((amo)localObject2).izd;
        if ((!Util.isNullOrNil(paramBundle)) && (!Util.isNullOrNil((String)localObject1)))
        {
          this.thO.setText(paramBundle);
          this.thO.setVisibility(0);
          this.thO.setOnClickListener(new FavoriteFileDetailUI.1(this, (String)localObject1));
          break label457;
        }
        this.thO.setVisibility(8);
        break label457;
      }
      Object localObject1 = getResources().getString(2131765980);
      paramBundle = (Bundle)localObject1;
      if (((amo)localObject2).LxJ / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131765982, new Object[] { Integer.valueOf(((amo)localObject2).LxJ / 60) });
      }
      localObject1 = paramBundle;
      if (((amo)localObject2).LxJ % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131765983, new Object[] { Integer.valueOf(((amo)localObject2).LxJ % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131765981);
      this.thO.setText(paramBundle);
      this.thO.setVisibility(0);
      this.thO.setOnClickListener(new FavoriteFileDetailUI.11(this));
      break label457;
      label1361:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.n.h.aqJ().getValue("SIGHTCannotTransmitForFav");
        if ((this.tbr.cUu()) && (Util.safeParseInt(paramBundle) == 0))
        {
          bool1 = true;
          break label584;
        }
        bool1 = false;
        break label584;
      }
      if ((this.tbr.cUv()) || (this.tbr.cUu()))
      {
        bool1 = true;
        break label584;
      }
      bool1 = false;
      break label584;
      label1434:
      if (Util.isNullOrNil(this.dKT.KuR)) {
        this.thY.setFileStatus(3);
      } else {
        this.thY.setFileStatus(2);
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(107145);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131755772));
    AppMethodBeat.o(107145);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107151);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    if (this.qbJ != null)
    {
      this.qbJ.setVideoCallback(null);
      this.qbJ.stop();
      this.qbJ.onDetach();
    }
    if (this.RbU != null) {
      this.RbU.onDestroy();
    }
    if (this.thY != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(this.thY);
    }
    super.onDestroy();
    AppMethodBeat.o(107151);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107142);
    Log.i("MicroMsg.FavoriteFileDetailUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.RbV != null) && (this.RbV.O(2, false)))
    {
      AppMethodBeat.o(107142);
      return true;
    }
    if ((paramInt == 4) && (this.RbU != null) && (this.RbU.wu(2)))
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
    Log.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.tbr.field_localId) });
    paramString = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tbr.field_localId);
    if ((paramString == null) && (!this.thS))
    {
      Log.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107157);
      return;
    }
    if (!this.thS) {
      this.tbr = paramString;
    }
    cWu();
    paramString = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
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
      else if (this.dKT.dataType == 8)
      {
        bool = false;
      }
      else if (this.thX)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.tbr, this.dKT, true);
          this.thX = true;
        }
        Log.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.thX) });
        bool = this.thX;
      }
    }
    this.hAk.post(new Runnable()
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
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(this);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(this);
    if (this.qbJ != null) {
      this.qbJ.stop();
    }
    if (this.RbU != null) {
      this.RbU.aGj();
    }
    if (this.RbV != null) {
      this.RbV.aGj();
    }
    AppMethodBeat.o(107153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107152);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(this);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(this);
    if (this.qbJ != null) {
      this.qbJ.start();
    }
    if (this.RbU != null) {
      this.RbU.bCA();
    }
    if (this.RbV != null) {
      this.RbV.bCA();
    }
    AppMethodBeat.o(107152);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI
 * JD-Core Version:    0.7.0.1
 */