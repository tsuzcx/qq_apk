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
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l.2;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.p, k.a
{
  private long dcg;
  private agx dhe;
  private boolean dpG;
  private ao gox;
  private TextView iMz;
  private TextView lzD;
  private int nwY;
  private int nwZ;
  private com.tencent.mm.ui.widget.b.a nym;
  private com.tencent.mm.pluginsdk.ui.tools.h odZ;
  private n.d pHX;
  private Button pet;
  private ProgressBar progressBar;
  private com.tencent.mm.plugin.fav.a.g qJy;
  private k qNO;
  private Button qPQ;
  private Button qPR;
  private MMImageView qPS;
  private TextView qPT;
  private View qPU;
  private View qPV;
  private TextView qPW;
  private ImageView qPX;
  private TextView qPY;
  private boolean qPZ;
  private boolean qQa;
  private String qQb;
  private String qQc;
  private boolean qQd;
  private boolean qQe;
  private boolean qQf;
  private HandOffFile qQg;
  private com.tencent.mm.plugin.fav.ui.b.a qQh;
  private View.OnTouchListener qQi;
  private View.OnLongClickListener qQj;
  
  public FavoriteFileDetailUI()
  {
    AppMethodBeat.i(107138);
    this.odZ = null;
    this.qNO = new k();
    this.qPZ = false;
    this.qQa = false;
    this.dpG = true;
    this.qQd = false;
    this.qQe = false;
    this.qQf = false;
    this.nym = null;
    this.pHX = new FavoriteFileDetailUI.17(this);
    this.qQi = new View.OnTouchListener()
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
    this.qQj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107116);
        ac.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
        if (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) == null) {
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.crg()));
        }
        FavoriteFileDetailUI.m(FavoriteFileDetailUI.this).a(paramAnonymousView, FavoriteFileDetailUI.this, FavoriteFileDetailUI.n(FavoriteFileDetailUI.this), FavoriteFileDetailUI.o(FavoriteFileDetailUI.this), FavoriteFileDetailUI.p(FavoriteFileDetailUI.this));
        AppMethodBeat.o(107116);
        return true;
      }
    };
    AppMethodBeat.o(107138);
  }
  
  private void a(final float paramFloat, final String paramString)
  {
    AppMethodBeat.i(107156);
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107123);
        FavoriteFileDetailUI.u(FavoriteFileDetailUI.this).setProgress((int)paramFloat);
        FavoriteFileDetailUI.v(FavoriteFileDetailUI.this).setText(paramString);
        AppMethodBeat.o(107123);
      }
    });
    AppMethodBeat.o(107156);
  }
  
  private void blc()
  {
    AppMethodBeat.i(107158);
    if (this.qQd)
    {
      AppMethodBeat.o(107158);
      return;
    }
    Object localObject = this.qPM;
    ((com.tencent.mm.plugin.fav.a.h.a)localObject).qIx += 1;
    this.qQd = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.dcg);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(this.dhe));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(this.dhe));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.dhe.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.dhe.dvs);
    ((Intent)localObject).putExtra("key_detail_msg_uuid", this.dhe.iaU);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
    AppMethodBeat.o(107158);
  }
  
  private void crf()
  {
    AppMethodBeat.i(107139);
    this.qQc = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.qJy.field_favProto.nxC.iterator();
    while (localIterator.hasNext())
    {
      agx localagx = (agx)localIterator.next();
      if (localagx.dhw.equals(this.qQc)) {
        this.dhe = localagx;
      }
    }
    if (this.dhe == null) {
      this.dhe = com.tencent.mm.plugin.fav.a.b.c(this.qJy);
    }
    AppMethodBeat.o(107139);
  }
  
  private void crh()
  {
    AppMethodBeat.i(107146);
    this.qPS.setVisibility(8);
    this.iMz.setVisibility(8);
    this.qPR.setVisibility(8);
    this.pet.setVisibility(8);
    this.qPQ.setVisibility(8);
    this.qPU.setVisibility(8);
    this.lzD.setVisibility(8);
    this.qPX.setVisibility(0);
    this.qPY.setVisibility(0);
    if (this.dhe.dataType == 4)
    {
      this.lzD.setGravity(17);
      this.lzD.setText(2131758941);
      AppMethodBeat.o(107146);
      return;
    }
    this.lzD.setGravity(17);
    this.lzD.setText(2131758940);
    if (this.dhe.EAn == 2)
    {
      this.qPY.setText(2131758858);
      AppMethodBeat.o(107146);
      return;
    }
    this.qPY.setText(2131758859);
    AppMethodBeat.o(107146);
  }
  
  private void cri()
  {
    AppMethodBeat.i(107147);
    this.qPR.setVisibility(8);
    this.pet.setVisibility(8);
    this.qPQ.setVisibility(8);
    this.lzD.setVisibility(8);
    this.qPU.setVisibility(0);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(this.dhe.dhw);
    int j;
    int i;
    int k;
    if (localc != null)
    {
      j = (int)localc.getProgress();
      i = localc.field_offset;
      k = localc.field_totalLen;
    }
    while ((this.qJy.cpo()) && (bs.isNullOrNil(this.dhe.Ezf)))
    {
      a(j, getString(2131759028, new Object[] { com.tencent.mm.plugin.fav.a.b.aX(i), com.tencent.mm.plugin.fav.a.b.aX(k) }));
      AppMethodBeat.o(107147);
      return;
      k = (int)this.dhe.EzA;
      i = 0;
      j = 0;
    }
    a(j, getString(2131758872, new Object[] { com.tencent.mm.plugin.fav.a.b.aX(i), com.tencent.mm.plugin.fav.a.b.aX(k) }));
    AppMethodBeat.o(107147);
  }
  
  private void crj()
  {
    AppMethodBeat.i(107148);
    this.qPU.setVisibility(8);
    this.qPQ.setVisibility(8);
    if (bs.isNullOrNil(this.dhe.Ezm))
    {
      this.pet.setVisibility(8);
      this.qPR.setVisibility(0);
      localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(this.dhe.dhw);
      if ((localObject == null) || (((com.tencent.mm.plugin.fav.a.c)localObject).field_offset <= 0)) {
        break label150;
      }
      localObject = this.qPR;
      if (!this.qJy.isUploadFailed()) {
        break label143;
      }
    }
    label143:
    for (int i = 2131758922;; i = 2131758921)
    {
      ((Button)localObject).setText(i);
      this.lzD.setVisibility(8);
      AppMethodBeat.o(107148);
      return;
      this.pet.setVisibility(0);
      break;
    }
    label150:
    Object localObject = this.qPR;
    if (this.qJy.isUploadFailed()) {}
    for (i = 2131758923;; i = 2131758918)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private boolean crk()
  {
    AppMethodBeat.i(107149);
    if ((com.tencent.mm.plugin.fav.a.b.g(this.dhe)) && (com.tencent.mm.plugin.fav.a.b.h(this.dhe)))
    {
      AppMethodBeat.o(107149);
      return true;
    }
    AppMethodBeat.o(107149);
    return false;
  }
  
  private void crl()
  {
    AppMethodBeat.i(107150);
    if ((getType() == 15) && (this.dhe.EAf != null) && (!bs.isNullOrNil(this.dhe.EAf.hjV)) && (!bs.isNullOrNil(this.dhe.EAf.hjZ)))
    {
      this.qQe = true;
      this.qPS.setVisibility(8);
      this.qPU.setVisibility(8);
      this.qPR.setVisibility(8);
      this.pet.setVisibility(8);
      this.qPQ.setVisibility(8);
      this.lzD.setVisibility(8);
      String str = com.tencent.mm.plugin.fav.a.b.d(this.dhe);
      ac.d("MicroMsg.FavoriteFileDetailUI", f.YF() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131306317);
      this.odZ = t.hz((MMActivity)super.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.odZ, 0, localLayoutParams);
      this.odZ.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.h.a()
      {
        public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int eP(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion() {}
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(107119);
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).stop();
          if (FavoriteFileDetailUI.r(FavoriteFileDetailUI.this))
          {
            AppMethodBeat.o(107119);
            return;
          }
          FavoriteFileDetailUI.s(FavoriteFileDetailUI.this);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107117);
              com.tencent.mm.ui.base.h.l(FavoriteFileDetailUI.this.crg(), 2131764680, 2131764690);
              Bitmap localBitmap = o.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this), FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
              ImageView localImageView = (ImageView)FavoriteFileDetailUI.this.findViewById(2131306415);
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
        
        public final void rB()
        {
          AppMethodBeat.i(107118);
          ac.d("MicroMsg.FavoriteFileDetailUI", f.YF() + " onPrepared");
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).setLoop(true);
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).start();
          AppMethodBeat.o(107118);
        }
      });
      ac.d("MicroMsg.FavoriteFileDetailUI", f.YF() + " initView :" + str);
      if (str != null)
      {
        this.odZ.stop();
        this.odZ.setVideoPath(str);
      }
      ac.d("MicroMsg.FavoriteFileDetailUI", f.YF() + " initView");
      com.tencent.mm.ay.a.aGt();
      com.tencent.mm.plugin.report.service.h.wUl.f(11444, new Object[] { Integer.valueOf(4) });
    }
    if ((getType() == 15) || (getType() == 4)) {
      if (!this.qQe)
      {
        this.qPU.setVisibility(8);
        this.qPR.setVisibility(8);
        this.pet.setVisibility(8);
        this.qPQ.setVisibility(0);
        this.qPQ.setText(2131758920);
        this.lzD.setVisibility(8);
        blc();
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107121);
          com.tencent.mm.plugin.fav.a.b.o(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          AppMethodBeat.o(107121);
        }
      });
      if (this.qQg.tBg != 1)
      {
        this.qQg.tBg = 1;
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.qQg);
      }
      AppMethodBeat.o(107150);
      return;
      if (!crk()) {
        break;
      }
      this.qPU.setVisibility(8);
      this.qPR.setVisibility(8);
      this.pet.setVisibility(0);
      this.qPQ.setVisibility(8);
      this.lzD.setVisibility(8);
      this.pet.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107120);
          FavoriteFileDetailUI.t(FavoriteFileDetailUI.this);
          AppMethodBeat.o(107120);
        }
      });
    }
    this.qPU.setVisibility(8);
    this.qPR.setVisibility(8);
    if (bs.isNullOrNil(this.dhe.Ezm)) {
      this.pet.setVisibility(8);
    }
    for (;;)
    {
      this.qPQ.setVisibility(0);
      this.qPM.qIw = true;
      this.lzD.setVisibility(0);
      break;
      this.pet.setVisibility(0);
    }
  }
  
  private boolean crm()
  {
    AppMethodBeat.i(107159);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(this.dhe.dhw);
    if (localc == null)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if (localc.field_status == 1)
    {
      AppMethodBeat.o(107159);
      return true;
    }
    if (this.dhe.dataType == 8)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if (this.qQf)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if ((localc.field_status == 4) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().acG(this.dhe.dhw).field_extFlag != 0))
    {
      com.tencent.mm.plugin.fav.a.b.a(this.qJy, this.dhe, true);
      this.qQf = true;
    }
    ac.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.qQf) });
    boolean bool = this.qQf;
    AppMethodBeat.o(107159);
    return bool;
  }
  
  private int getType()
  {
    AppMethodBeat.i(107143);
    if (this.dhe == null)
    {
      ac.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
      AppMethodBeat.o(107143);
      return 8;
    }
    if (this.dhe.dataType == 0)
    {
      ac.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.qJy.field_type) });
      if (4 == this.qJy.field_type)
      {
        AppMethodBeat.o(107143);
        return 4;
      }
      if (16 == this.qJy.field_type)
      {
        if ((this.dhe != null) && (this.dhe.EAf != null))
        {
          if (!bs.isNullOrNil(this.dhe.EAf.hjV))
          {
            AppMethodBeat.o(107143);
            return 15;
          }
          if (!bs.isNullOrNil(this.dhe.EAf.hjZ))
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
    if (this.dhe.dataType == 15)
    {
      if ((this.dhe != null) && (this.dhe.EAf != null))
      {
        if (!bs.isNullOrNil(this.dhe.EAf.hjV))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
        if (!bs.isNullOrNil(this.dhe.EAf.hjZ))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
      }
      AppMethodBeat.o(107143);
      return 4;
    }
    int i = this.dhe.dataType;
    AppMethodBeat.o(107143);
    return i;
  }
  
  private void lj(boolean paramBoolean)
  {
    AppMethodBeat.i(107144);
    boolean bool = com.tencent.mm.plugin.fav.a.b.g(this.dhe);
    ac.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.qJy.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.d(this.dhe) });
    if (this.dhe.EAn != 0)
    {
      crh();
      AppMethodBeat.o(107144);
      return;
    }
    int i;
    if ((this.qJy.isDone()) || (bool) || (!bs.isNullOrNil(this.dhe.Ezf)))
    {
      if (bool)
      {
        crl();
        i = getIntent().getIntExtra("key_detail_open_way", 0);
        ahp localahp;
        if (bs.jl(i, 1))
        {
          localahp = new ahp();
          localahp.dxw = 2;
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), this.qJy, localahp);
          AppMethodBeat.o(107144);
          return;
        }
        if (bs.jl(i, 2))
        {
          localahp = new ahp();
          localahp.dxw = 2;
          if ((this.dhe.dataType == 8) && (bs.lr(this.dhe.dhw, this.qQc)))
          {
            com.tencent.mm.plugin.fav.a.g localg = this.qJy.cps();
            localg.field_type = 8;
            localg.qIl = true;
            localg.qIm = this.qJy;
            localg.dhm = (this.qJy.field_localId + "_" + this.qQc);
            localg.qIn = this.qQc;
            localg.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(this.qJy.field_favProto);
            localg.field_favProto.nxC = new LinkedList();
            localg.field_favProto.nxC.add(this.dhe);
            localg.field_favProto.aJA(this.dhe.title);
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), localg, localahp);
            AppMethodBeat.o(107144);
            return;
          }
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), this.qJy, localahp);
        }
        AppMethodBeat.o(107144);
        return;
      }
      if (bs.isNullOrNil(this.dhe.Ezf))
      {
        crh();
        AppMethodBeat.o(107144);
        return;
      }
      ac.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
      crj();
      AppMethodBeat.o(107144);
      return;
    }
    if (this.qJy.cpp())
    {
      if (bs.isNullOrNil(this.dhe.Ezf))
      {
        crh();
        if (paramBoolean)
        {
          i = getType();
          if ((4 == i) || (15 == i)) {}
          for (i = 2131758978;; i = 2131758965)
          {
            com.tencent.mm.ui.base.h.cg((MMActivity)super.getContext(), getString(i));
            AppMethodBeat.o(107144);
            return;
          }
        }
      }
      else
      {
        crj();
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.cg((MMActivity)super.getContext(), getString(2131758104));
          AppMethodBeat.o(107144);
        }
      }
    }
    else if (this.qJy.isUploadFailed())
    {
      crj();
      if (paramBoolean)
      {
        com.tencent.mm.ui.base.h.cg((MMActivity)super.getContext(), getString(2131758844));
        AppMethodBeat.o(107144);
      }
    }
    else
    {
      if ((this.qJy.isDownloading()) || (this.qJy.cpo()))
      {
        cri();
        AppMethodBeat.o(107144);
        return;
      }
      ac.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      crj();
    }
    AppMethodBeat.o(107144);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(107157);
    ac.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.qJy.field_localId) });
    paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(this.qJy.field_localId);
    if ((paramString == null) && (!this.qQa))
    {
      ac.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107157);
      return;
    }
    if (!this.qQa) {
      this.qJy = paramString;
    }
    crf();
    if (crm())
    {
      AppMethodBeat.o(107157);
      return;
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107124);
        FavoriteFileDetailUI.w(FavoriteFileDetailUI.this);
        AppMethodBeat.o(107124);
      }
    });
    AppMethodBeat.o(107157);
  }
  
  public final MMActivity crg()
  {
    AppMethodBeat.i(210542);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(210542);
    return localMMActivity;
  }
  
  public final void e(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(107155);
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      ac.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(107155);
      return;
    }
    ac.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.dhe.dhw, paramc.field_dataId });
    if (paramc.field_dataId.equals(this.dhe.dhw))
    {
      if ((this.qJy.cpo()) && (bs.isNullOrNil(this.dhe.Ezf)))
      {
        a(paramc.getProgress(), getString(2131759028, new Object[] { com.tencent.mm.plugin.fav.a.b.aX(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.aX(paramc.field_totalLen) }));
        AppMethodBeat.o(107155);
        return;
      }
      a(paramc.getProgress(), getString(2131758872, new Object[] { com.tencent.mm.plugin.fav.a.b.aX(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.aX(paramc.field_totalLen) }));
      if ((this.qQa) && (i.eA(paramc.field_path)))
      {
        this.qJy.field_itemStatus = 10;
        a("", null);
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
    return 2131493987;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107154);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((ab)com.tencent.mm.kernel.g.ab(ab.class)).b(this, paramInt1, paramInt2, paramIntent);
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
        localObject2 = com.tencent.mm.ui.base.h.b((MMActivity)super.getContext(), getString(2131758906), false, null);
        ac.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107122);
            this.qLa.dismiss();
            AppMethodBeat.o(107122);
          }
        };
        paramInt2 = getType();
        if (!bs.isNullOrNil((String)localObject1)) {
          break label159;
        }
        AppMethodBeat.o(107154);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label159:
      Iterator localIterator = bs.S(((String)localObject1).split(",")).iterator();
      label267:
      label311:
      label339:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((paramInt2 == 4) || (paramInt2 == 15))
        {
          com.tencent.mm.plugin.fav.ui.l.a((MMActivity)super.getContext(), str, this.dhe, (Runnable)localObject2);
          boolean bool = w.sQ(str);
          if (bool)
          {
            localObject1 = m.c.qJh;
            label245:
            com.tencent.mm.plugin.fav.a.g localg = this.qJy;
            m.d locald = m.d.qJl;
            if (!bool) {
              break label311;
            }
            paramInt1 = com.tencent.mm.model.q.wb(str);
            com.tencent.mm.plugin.fav.a.m.a((m.c)localObject1, localg, locald, paramInt1);
          }
        }
        for (;;)
        {
          if (bs.isNullOrNil(paramIntent)) {
            break label339;
          }
          j.dck().X(str, paramIntent, w.xt(str));
          break;
          localObject1 = m.c.qJg;
          break label245;
          paramInt1 = 0;
          break label267;
          com.tencent.mm.plugin.fav.ui.l.a((MMActivity)super.getContext(), str, this.qJy, this.dhe, (Runnable)localObject2);
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131758834));
    }
    AppMethodBeat.o(107154);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(107140);
    super.onCreate(paramBundle);
    this.gox = new ao();
    this.dcg = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.qQa = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.dpG = getIntent().getBooleanExtra("show_share", true);
    this.qQb = getIntent().getStringExtra("fav_note_xml");
    this.qJy = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(this.dcg);
    if ((this.qQa) && (!bs.isNullOrNil(this.qQb))) {
      this.qJy = com.tencent.mm.plugin.fav.a.b.acu(this.qQb);
    }
    if (this.qJy == null)
    {
      ac.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      AppMethodBeat.o(107140);
      return;
    }
    H(this.qJy);
    com.tencent.mm.plugin.fav.a.m.x(this.qJy);
    crf();
    this.pet = ((Button)findViewById(2131303391));
    this.qPQ = ((Button)findViewById(2131303020));
    this.qPR = ((Button)findViewById(2131299195));
    this.qPS = ((MMImageView)findViewById(2131300891));
    this.iMz = ((TextView)findViewById(2131302666));
    this.lzD = ((TextView)findViewById(2131305896));
    this.qPV = findViewById(2131299221);
    this.qPU = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.qPT = ((TextView)findViewById(2131299217));
    this.qPW = ((TextView)findViewById(2131304777));
    this.qPX = ((ImageView)findViewById(2131299790));
    this.qPY = ((TextView)findViewById(2131299791));
    this.iMz.setOnTouchListener(this.qQi);
    this.iMz.setOnLongClickListener(this.qQj);
    final int i = getType();
    label420:
    Object localObject2;
    label457:
    final boolean bool1;
    if (4 == i)
    {
      setMMTitle(2131759030);
      if (this.dhe.dataType != 4) {
        break label916;
      }
      this.qPS.setImageResource(2131689581);
      this.iMz.setText(this.dhe.title);
      localObject2 = this.dhe.EAf;
      if (localObject2 != null) {
        break label946;
      }
      this.qPW.setVisibility(8);
      setBackBtn(new FavoriteFileDetailUI.11(this));
      this.qPQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107127);
          paramAnonymousView = com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
          if (4 == FavoriteFileDetailUI.d(FavoriteFileDetailUI.this))
          {
            FavoriteFileDetailUI.e(FavoriteFileDetailUI.this);
            FavoriteFileDetailUI.f(FavoriteFileDetailUI.this);
            AppMethodBeat.o(107127);
            return;
          }
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, paramAnonymousView);
          AppMethodBeat.o(107127);
        }
      });
      paramBundle = this.dhe.Ezm;
      if (!bs.isNullOrNil(paramBundle)) {
        this.pet.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(107128);
            ac.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId) });
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramBundle);
            paramAnonymousView.putExtra("is_favorite_item", true);
            paramAnonymousView.putExtra("fav_local_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            com.tencent.mm.br.d.b(FavoriteFileDetailUI.this.crg(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            AppMethodBeat.o(107128);
          }
        });
      }
      this.qPR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107129);
          ac.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_itemStatus) });
          if (!com.tencent.mm.compatible.util.e.YD())
          {
            com.tencent.mm.ui.base.h.l(FavoriteFileDetailUI.this.crg(), 2131758934, 2131758845);
            AppMethodBeat.o(107129);
            return;
          }
          if ((FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isUploadFailed()) || (bs.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).Ezf))) {
            com.tencent.mm.plugin.fav.a.b.l(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          }
          for (;;)
          {
            FavoriteFileDetailUI.h(FavoriteFileDetailUI.this);
            AppMethodBeat.o(107129);
            return;
            if (!FavoriteFileDetailUI.g(FavoriteFileDetailUI.this))
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
      this.qPV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107130);
          if (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isDownloading())
          {
            com.tencent.mm.plugin.fav.a.b.e(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.i(FavoriteFileDetailUI.this).setText(2131758921);
          }
          for (;;)
          {
            FavoriteFileDetailUI.j(FavoriteFileDetailUI.this);
            AppMethodBeat.o(107130);
            return;
            com.tencent.mm.plugin.fav.a.b.n(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.i(FavoriteFileDetailUI.this).setText(2131758922);
          }
        }
      });
      if (this.dpG)
      {
        final boolean bool2 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label1239;
        }
        bool1 = this.qJy.cpl();
        label584:
        if ((bool1) || (bool2)) {
          addIconOptionMenu(0, 2131764451, 2131690603, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(107136);
              if (bool1)
              {
                FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
                if ((!k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).EAn == 0)) {}
              }
              else if (!bool2)
              {
                AppMethodBeat.o(107136);
                return false;
              }
              paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(FavoriteFileDetailUI.this.crg(), 1, false);
              paramAnonymousMenuItem.ISu = new n.c()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(107131);
                  if (FavoriteFileDetailUI.16.this.qQq)
                  {
                    FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
                    if ((!k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).EAn == 0))
                    {
                      if (FavoriteFileDetailUI.16.this.val$type != 8) {
                        break label222;
                      }
                      paramAnonymous2l.c(0, FavoriteFileDetailUI.this.getString(2131759001));
                      if (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null)
                      {
                        FavoriteFileDetailUI.c(FavoriteFileDetailUI.this);
                        if (!FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bGo()) {
                          break label201;
                        }
                        paramAnonymous2l.c(5, FavoriteFileDetailUI.this.getString(2131756770));
                      }
                    }
                  }
                  for (;;)
                  {
                    if (FavoriteFileDetailUI.16.this.qQr)
                    {
                      paramAnonymous2l.c(3, FavoriteFileDetailUI.this.getString(2131758875));
                      paramAnonymous2l.c(2, FavoriteFileDetailUI.this.crg().getString(2131755707));
                    }
                    AppMethodBeat.o(107131);
                    return;
                    label201:
                    paramAnonymous2l.c(5, FavoriteFileDetailUI.this.getString(2131758422));
                    continue;
                    label222:
                    if (FavoriteFileDetailUI.16.this.val$type == 15)
                    {
                      paramAnonymous2l.c(0, FavoriteFileDetailUI.this.getString(2131759001));
                      paramAnonymous2l.c(4, FavoriteFileDetailUI.this.getString(2131762784));
                    }
                    else if (FavoriteFileDetailUI.16.this.val$type == 4)
                    {
                      paramAnonymous2l.c(0, FavoriteFileDetailUI.this.getString(2131759001));
                      paramAnonymous2l.c(4, FavoriteFileDetailUI.this.getString(2131762784));
                    }
                    else
                    {
                      paramAnonymous2l.c(0, FavoriteFileDetailUI.this.getString(2131759001));
                      if ((FavoriteFileDetailUI.16.this.qQr) && (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).cpm())) {
                        paramAnonymous2l.c(1, FavoriteFileDetailUI.this.getString(2131758951));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.ISv = new n.d()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  boolean bool = true;
                  AppMethodBeat.i(107135);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  do
                  {
                    AppMethodBeat.o(107135);
                    return;
                    if (FavoriteFileDetailUI.d(FavoriteFileDetailUI.this) == 8)
                    {
                      paramAnonymous2MenuItem = com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
                      if (!i.eA(paramAnonymous2MenuItem))
                      {
                        ac.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131758999), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                      if (new com.tencent.mm.vfs.e(paramAnonymous2MenuItem).length() > 10485760L)
                      {
                        ac.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131759000), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                    }
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.qPM;
                    paramAnonymous2MenuItem.qIy += 1;
                    FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.qPM;
                    paramAnonymous2MenuItem.qIz += 1;
                    Object localObject = com.tencent.mm.ui.base.h.b(FavoriteFileDetailUI.this.crg(), FavoriteFileDetailUI.this.getString(2131758906), false, null);
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.crg();
                    com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(FavoriteFileDetailUI.this);
                    localObject = new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107132);
                        this.qLa.dismiss();
                        AppMethodBeat.o(107132);
                      }
                    };
                    LinkedList localLinkedList = new LinkedList();
                    localLinkedList.add(Integer.valueOf(localg.field_id));
                    paramAnonymous2MenuItem = new an("", localLinkedList, new l.2(localg, paramAnonymous2MenuItem, (Runnable)localObject));
                    com.tencent.mm.kernel.g.agi().a(paramAnonymous2MenuItem, 0);
                    AppMethodBeat.o(107135);
                    return;
                    com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.crg(), FavoriteFileDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(107134);
                        paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteFileDetailUI.this.crg(), FavoriteFileDetailUI.this.getString(2131755709), false, null);
                        com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId, new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(107133);
                            FavoriteFileDetailUI.this.qPM.qIC = true;
                            paramAnonymous3DialogInterface.dismiss();
                            ac.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id) });
                            FavoriteFileDetailUI.this.finish();
                            AppMethodBeat.o(107133);
                          }
                        });
                        AppMethodBeat.o(107134);
                      }
                    }, null);
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.qPM;
                    paramAnonymous2MenuItem.qIB += 1;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                    paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.this.crg(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                    AppMethodBeat.o(107135);
                    return;
                    FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(107135);
                    return;
                  } while (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) == null);
                  paramAnonymous2MenuItem = FavoriteFileDetailUI.c(FavoriteFileDetailUI.this);
                  if (!FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bGo()) {}
                  for (;;)
                  {
                    paramAnonymous2MenuItem.ga(bool);
                    break;
                    bool = false;
                  }
                }
              };
              paramAnonymousMenuItem.cED();
              AppMethodBeat.o(107136);
              return true;
            }
          });
        }
      }
      this.qQg = HandOffFile.b(this.dhe, this.qJy);
      if (!com.tencent.mm.plugin.fav.a.b.g(this.dhe)) {
        break label1312;
      }
      this.qQg.tBg = 1;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.qQg);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.qQg);
      lj(false);
      if (getType() == 8)
      {
        paramBundle = com.tencent.mm.plugin.fav.a.b.d(this.dhe);
        bool1 = i.eA(paramBundle);
        if (bool1)
        {
          this.qQh = new com.tencent.mm.plugin.fav.ui.b.a(new com.tencent.mm.plugin.fav.ui.b.b((MMActivity)super.getContext()));
          this.qQh.gb(paramBundle, this.dhe.Ezu);
          localObject2 = this.qQh;
          paramBundle = this.dhe.Ezu;
          String str = this.dhe.title;
          localObject1 = com.tencent.mm.plugin.ball.f.d.SU(paramBundle);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = com.tencent.mm.plugin.ball.f.d.SU("unknown");
          }
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).nfN.lzV = paramBundle.intValue();
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).nfN.name = str;
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).bGr();
          this.qQg.K(this.qQh.nfN);
        }
        ac.i("MicroMsg.FavoriteFileDetailUI", "initFloatBallHelper() ifSupportFB:%s", new Object[] { Boolean.valueOf(bool1) });
      }
      AppMethodBeat.o(107140);
      return;
      if (15 == i)
      {
        setMMTitle(2131759030);
        findViewById(2131306317).setBackgroundResource(2131100017);
        this.iMz.setVisibility(8);
        break;
      }
      setMMTitle(2131758904);
      break;
      label916:
      this.qPS.setImageResource(((ab)com.tencent.mm.kernel.g.ab(ab.class)).acJ(this.dhe.Ezu));
      break label420;
      label946:
      if (bs.isNullOrNil(((aha)localObject2).hjV))
      {
        ac.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = ((aha)localObject2).hjY;
        localObject1 = ((aha)localObject2).hjZ;
        if ((!bs.isNullOrNil(paramBundle)) && (!bs.isNullOrNil((String)localObject1)))
        {
          this.qPW.setText(paramBundle);
          this.qPW.setVisibility(0);
          this.qPW.setOnClickListener(new FavoriteFileDetailUI.1(this, (String)localObject1));
          break label457;
        }
        this.qPW.setVisibility(8);
        break label457;
      }
      Object localObject1 = getResources().getString(2131763759);
      paramBundle = (Bundle)localObject1;
      if (((aha)localObject2).EBs / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131763761, new Object[] { Integer.valueOf(((aha)localObject2).EBs / 60) });
      }
      localObject1 = paramBundle;
      if (((aha)localObject2).EBs % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131763762, new Object[] { Integer.valueOf(((aha)localObject2).EBs % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131763760);
      this.qPW.setText(paramBundle);
      this.qPW.setVisibility(0);
      this.qPW.setOnClickListener(new FavoriteFileDetailUI.10(this));
      break label457;
      label1239:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.m.g.ZY().getValue("SIGHTCannotTransmitForFav");
        if ((this.qJy.cpl()) && (bs.aLy(paramBundle) == 0))
        {
          bool1 = true;
          break label584;
        }
        bool1 = false;
        break label584;
      }
      if ((this.qJy.cpm()) || (this.qJy.cpl()))
      {
        bool1 = true;
        break label584;
      }
      bool1 = false;
      break label584;
      label1312:
      if (bs.isNullOrNil(this.dhe.Ezf)) {
        this.qQg.tBg = 3;
      } else {
        this.qQg.tBg = 2;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(107145);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131755701));
    AppMethodBeat.o(107145);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107151);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    if (this.odZ != null)
    {
      this.odZ.setVideoCallback(null);
      this.odZ.stop();
      this.odZ.onDetach();
    }
    if (this.qQh != null) {
      this.qQh.onDestroy();
    }
    if (this.qQg != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.qQg);
    }
    super.onDestroy();
    AppMethodBeat.o(107151);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107142);
    ac.i("MicroMsg.FavoriteFileDetailUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.qQh != null) && (this.qQh.rT(2)))
    {
      AppMethodBeat.o(107142);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(107142);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107153);
    super.onPause();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(this);
    if (this.odZ != null) {
      this.odZ.stop();
    }
    if (this.qQh != null) {
      this.qQh.bcY();
    }
    AppMethodBeat.o(107153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107152);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    if (this.odZ != null) {
      this.odZ.start();
    }
    if (this.qQh != null) {
      this.qQh.bcX();
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