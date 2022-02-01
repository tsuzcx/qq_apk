package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
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
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l.2;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private long deL;
  private afy djJ;
  private boolean drV;
  private ap gAC;
  private TextView imt;
  private TextView kXT;
  private int mUE;
  private int mUF;
  private com.tencent.mm.ui.widget.b.a mVN;
  private com.tencent.mm.pluginsdk.ui.tools.h nAZ;
  private Button oAT;
  private n.d peM;
  private ProgressBar progressBar;
  private com.tencent.mm.plugin.fav.a.g qaS;
  private k qfm;
  private String qhA;
  private boolean qhB;
  private boolean qhC;
  private boolean qhD;
  private HandOffFile qhE;
  private com.tencent.mm.plugin.fav.ui.b.a qhF;
  private View.OnTouchListener qhG;
  private View.OnLongClickListener qhH;
  private Button qho;
  private Button qhp;
  private MMImageView qhq;
  private TextView qhr;
  private View qhs;
  private View qht;
  private TextView qhu;
  private ImageView qhv;
  private TextView qhw;
  private boolean qhx;
  private boolean qhy;
  private String qhz;
  
  public FavoriteFileDetailUI()
  {
    AppMethodBeat.i(107138);
    this.nAZ = null;
    this.qfm = new k();
    this.qhx = false;
    this.qhy = false;
    this.drV = true;
    this.qhB = false;
    this.qhC = false;
    this.qhD = false;
    this.mVN = null;
    this.peM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107137);
        ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        if (bt.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)) {}
        for (paramAnonymousMenuItem = FavoriteFileDetailUI.this.getString(2131761808);; paramAnonymousMenuItem = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          com.tencent.mm.ui.base.h.cf(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131755702));
          AppMethodBeat.o(107137);
          return;
        }
      }
    };
    this.qhG = new View.OnTouchListener()
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
    this.qhH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107116);
        ad.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
        if (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) == null) {
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.cjz()));
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
    this.gAC.post(new Runnable()
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
  
  private void bei()
  {
    AppMethodBeat.i(107158);
    if (this.qhB)
    {
      AppMethodBeat.o(107158);
      return;
    }
    Object localObject = this.qhk;
    ((com.tencent.mm.plugin.fav.a.h.a)localObject).pZQ += 1;
    this.qhB = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.deL);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(this.djJ));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(this.djJ));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.djJ.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.djJ.dxG);
    ((Intent)localObject).putExtra("key_detail_msg_uuid", this.djJ.hAt);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
    AppMethodBeat.o(107158);
  }
  
  private void cjA()
  {
    AppMethodBeat.i(107146);
    this.qhq.setVisibility(8);
    this.imt.setVisibility(8);
    this.qhp.setVisibility(8);
    this.oAT.setVisibility(8);
    this.qho.setVisibility(8);
    this.qhs.setVisibility(8);
    this.kXT.setVisibility(8);
    this.qhv.setVisibility(0);
    this.qhw.setVisibility(0);
    if (this.djJ.dataType == 4)
    {
      this.kXT.setGravity(17);
      this.kXT.setText(2131758941);
      AppMethodBeat.o(107146);
      return;
    }
    this.kXT.setGravity(17);
    this.kXT.setText(2131758940);
    if (this.djJ.Dhh == 2)
    {
      this.qhw.setText(2131758858);
      AppMethodBeat.o(107146);
      return;
    }
    this.qhw.setText(2131758859);
    AppMethodBeat.o(107146);
  }
  
  private void cjB()
  {
    AppMethodBeat.i(107147);
    this.qhp.setVisibility(8);
    this.oAT.setVisibility(8);
    this.qho.setVisibility(8);
    this.kXT.setVisibility(8);
    this.qhs.setVisibility(0);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(this.djJ.dkb);
    int j;
    int i;
    int k;
    if (localc != null)
    {
      j = (int)localc.getProgress();
      i = localc.field_offset;
      k = localc.field_totalLen;
    }
    while ((this.qaS.chH()) && (bt.isNullOrNil(this.djJ.DfZ)))
    {
      a(j, getString(2131759028, new Object[] { com.tencent.mm.plugin.fav.a.b.aS(i), com.tencent.mm.plugin.fav.a.b.aS(k) }));
      AppMethodBeat.o(107147);
      return;
      k = (int)this.djJ.Dgu;
      i = 0;
      j = 0;
    }
    a(j, getString(2131758872, new Object[] { com.tencent.mm.plugin.fav.a.b.aS(i), com.tencent.mm.plugin.fav.a.b.aS(k) }));
    AppMethodBeat.o(107147);
  }
  
  private void cjC()
  {
    AppMethodBeat.i(107148);
    this.qhs.setVisibility(8);
    this.qho.setVisibility(8);
    if (bt.isNullOrNil(this.djJ.Dgg))
    {
      this.oAT.setVisibility(8);
      this.qhp.setVisibility(0);
      localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(this.djJ.dkb);
      if ((localObject == null) || (((com.tencent.mm.plugin.fav.a.c)localObject).field_offset <= 0)) {
        break label150;
      }
      localObject = this.qhp;
      if (!this.qaS.isUploadFailed()) {
        break label143;
      }
    }
    label143:
    for (int i = 2131758922;; i = 2131758921)
    {
      ((Button)localObject).setText(i);
      this.kXT.setVisibility(8);
      AppMethodBeat.o(107148);
      return;
      this.oAT.setVisibility(0);
      break;
    }
    label150:
    Object localObject = this.qhp;
    if (this.qaS.isUploadFailed()) {}
    for (i = 2131758923;; i = 2131758918)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private boolean cjD()
  {
    AppMethodBeat.i(107149);
    if ((com.tencent.mm.plugin.fav.a.b.g(this.djJ)) && (com.tencent.mm.plugin.fav.a.b.h(this.djJ)))
    {
      AppMethodBeat.o(107149);
      return true;
    }
    AppMethodBeat.o(107149);
    return false;
  }
  
  private void cjE()
  {
    AppMethodBeat.i(107150);
    if ((getType() == 15) && (this.djJ.DgZ != null) && (!bt.isNullOrNil(this.djJ.DgZ.gJv)) && (!bt.isNullOrNil(this.djJ.DgZ.gJz)))
    {
      this.qhC = true;
      this.qhq.setVisibility(8);
      this.qhs.setVisibility(8);
      this.qhp.setVisibility(8);
      this.oAT.setVisibility(8);
      this.qho.setVisibility(8);
      this.kXT.setVisibility(8);
      String str = com.tencent.mm.plugin.fav.a.b.d(this.djJ);
      ad.d("MicroMsg.FavoriteFileDetailUI", f.XI() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131306317);
      this.nAZ = t.ho((MMActivity)super.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.nAZ, 0, localLayoutParams);
      this.nAZ.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.h.a()
      {
        public final void dY(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int eM(int paramAnonymousInt1, int paramAnonymousInt2)
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
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107117);
              com.tencent.mm.ui.base.h.j(FavoriteFileDetailUI.this.cjz(), 2131764680, 2131764690);
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
        
        public final void rq()
        {
          AppMethodBeat.i(107118);
          ad.d("MicroMsg.FavoriteFileDetailUI", f.XI() + " onPrepared");
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).setLoop(true);
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).start();
          AppMethodBeat.o(107118);
        }
      });
      ad.d("MicroMsg.FavoriteFileDetailUI", f.XI() + " initView :" + str);
      if (str != null)
      {
        this.nAZ.stop();
        this.nAZ.setVideoPath(str);
      }
      ad.d("MicroMsg.FavoriteFileDetailUI", f.XI() + " initView");
      com.tencent.mm.az.a.azD();
      com.tencent.mm.plugin.report.service.h.vKh.f(11444, new Object[] { Integer.valueOf(4) });
    }
    if ((getType() == 15) || (getType() == 4)) {
      if (!this.qhC)
      {
        this.qhs.setVisibility(8);
        this.qhp.setVisibility(8);
        this.oAT.setVisibility(8);
        this.qho.setVisibility(0);
        this.qho.setText(2131758920);
        this.kXT.setVisibility(8);
        bei();
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107121);
          com.tencent.mm.plugin.fav.a.b.o(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          AppMethodBeat.o(107121);
        }
      });
      if (this.qhE.stq != 1)
      {
        this.qhE.stq = 1;
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.qhE);
      }
      AppMethodBeat.o(107150);
      return;
      if (!cjD()) {
        break;
      }
      this.qhs.setVisibility(8);
      this.qhp.setVisibility(8);
      this.oAT.setVisibility(0);
      this.qho.setVisibility(8);
      this.kXT.setVisibility(8);
      this.oAT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107120);
          FavoriteFileDetailUI.t(FavoriteFileDetailUI.this);
          AppMethodBeat.o(107120);
        }
      });
    }
    this.qhs.setVisibility(8);
    this.qhp.setVisibility(8);
    if (bt.isNullOrNil(this.djJ.Dgg)) {
      this.oAT.setVisibility(8);
    }
    for (;;)
    {
      this.qho.setVisibility(0);
      this.qhk.pZP = true;
      this.kXT.setVisibility(0);
      break;
      this.oAT.setVisibility(0);
    }
  }
  
  private boolean cjF()
  {
    AppMethodBeat.i(107159);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(this.djJ.dkb);
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
    if (this.djJ.dataType == 8)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if (this.qhD)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if ((localc.field_status == 4) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().Yk(this.djJ.dkb).field_extFlag != 0))
    {
      com.tencent.mm.plugin.fav.a.b.a(this.qaS, this.djJ, true);
      this.qhD = true;
    }
    ad.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.qhD) });
    boolean bool = this.qhD;
    AppMethodBeat.o(107159);
    return bool;
  }
  
  private void cjy()
  {
    AppMethodBeat.i(107139);
    this.qhA = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.qaS.field_favProto.mVb.iterator();
    while (localIterator.hasNext())
    {
      afy localafy = (afy)localIterator.next();
      if (localafy.dkb.equals(this.qhA)) {
        this.djJ = localafy;
      }
    }
    if (this.djJ == null) {
      this.djJ = com.tencent.mm.plugin.fav.a.b.c(this.qaS);
    }
    AppMethodBeat.o(107139);
  }
  
  private int getType()
  {
    AppMethodBeat.i(107143);
    if (this.djJ == null)
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
      AppMethodBeat.o(107143);
      return 8;
    }
    if (this.djJ.dataType == 0)
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.qaS.field_type) });
      if (4 == this.qaS.field_type)
      {
        AppMethodBeat.o(107143);
        return 4;
      }
      if (16 == this.qaS.field_type)
      {
        if ((this.djJ != null) && (this.djJ.DgZ != null))
        {
          if (!bt.isNullOrNil(this.djJ.DgZ.gJv))
          {
            AppMethodBeat.o(107143);
            return 15;
          }
          if (!bt.isNullOrNil(this.djJ.DgZ.gJz))
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
    if (this.djJ.dataType == 15)
    {
      if ((this.djJ != null) && (this.djJ.DgZ != null))
      {
        if (!bt.isNullOrNil(this.djJ.DgZ.gJv))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
        if (!bt.isNullOrNil(this.djJ.DgZ.gJz))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
      }
      AppMethodBeat.o(107143);
      return 4;
    }
    int i = this.djJ.dataType;
    AppMethodBeat.o(107143);
    return i;
  }
  
  private void kF(boolean paramBoolean)
  {
    AppMethodBeat.i(107144);
    boolean bool = com.tencent.mm.plugin.fav.a.b.g(this.djJ);
    ad.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.qaS.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.d(this.djJ) });
    if (this.djJ.Dhh != 0)
    {
      cjA();
      AppMethodBeat.o(107144);
      return;
    }
    int i;
    if ((this.qaS.isDone()) || (bool) || (!bt.isNullOrNil(this.djJ.DfZ)))
    {
      if (bool)
      {
        cjE();
        i = getIntent().getIntExtra("key_detail_open_way", 0);
        agq localagq;
        if (bt.iY(i, 1))
        {
          localagq = new agq();
          localagq.dzK = 2;
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), this.qaS, localagq);
          AppMethodBeat.o(107144);
          return;
        }
        if (bt.iY(i, 2))
        {
          localagq = new agq();
          localagq.dzK = 2;
          if ((this.djJ.dataType == 8) && (bt.kU(this.djJ.dkb, this.qhA)))
          {
            com.tencent.mm.plugin.fav.a.g localg = this.qaS.chL();
            localg.field_type = 8;
            localg.pZE = true;
            localg.pZF = this.qaS;
            localg.djR = (this.qaS.field_localId + "_" + this.qhA);
            localg.pZG = this.qhA;
            localg.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(this.qaS.field_favProto);
            localg.field_favProto.mVb = new LinkedList();
            localg.field_favProto.mVb.add(this.djJ);
            localg.field_favProto.aEj(this.djJ.title);
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), localg, localagq);
            AppMethodBeat.o(107144);
            return;
          }
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), this.qaS, localagq);
        }
        AppMethodBeat.o(107144);
        return;
      }
      if (bt.isNullOrNil(this.djJ.DfZ))
      {
        cjA();
        AppMethodBeat.o(107144);
        return;
      }
      ad.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
      cjC();
      AppMethodBeat.o(107144);
      return;
    }
    if (this.qaS.chI())
    {
      if (bt.isNullOrNil(this.djJ.DfZ))
      {
        cjA();
        if (paramBoolean)
        {
          i = getType();
          if ((4 == i) || (15 == i)) {}
          for (i = 2131758978;; i = 2131758965)
          {
            com.tencent.mm.ui.base.h.cf((MMActivity)super.getContext(), getString(i));
            AppMethodBeat.o(107144);
            return;
          }
        }
      }
      else
      {
        cjC();
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.cf((MMActivity)super.getContext(), getString(2131758104));
          AppMethodBeat.o(107144);
        }
      }
    }
    else if (this.qaS.isUploadFailed())
    {
      cjC();
      if (paramBoolean)
      {
        com.tencent.mm.ui.base.h.cf((MMActivity)super.getContext(), getString(2131758844));
        AppMethodBeat.o(107144);
      }
    }
    else
    {
      if ((this.qaS.isDownloading()) || (this.qaS.chH()))
      {
        cjB();
        AppMethodBeat.o(107144);
        return;
      }
      ad.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      cjC();
    }
    AppMethodBeat.o(107144);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(107157);
    ad.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.qaS.field_localId) });
    paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(this.qaS.field_localId);
    if ((paramString == null) && (!this.qhy))
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107157);
      return;
    }
    if (!this.qhy) {
      this.qaS = paramString;
    }
    cjy();
    if (cjF())
    {
      AppMethodBeat.o(107157);
      return;
    }
    this.gAC.post(new Runnable()
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
  
  public final MMActivity cjz()
  {
    AppMethodBeat.i(202392);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(202392);
    return localMMActivity;
  }
  
  public final void e(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(107155);
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(107155);
      return;
    }
    ad.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.djJ.dkb, paramc.field_dataId });
    if (paramc.field_dataId.equals(this.djJ.dkb))
    {
      if ((this.qaS.chH()) && (bt.isNullOrNil(this.djJ.DfZ)))
      {
        a(paramc.getProgress(), getString(2131759028, new Object[] { com.tencent.mm.plugin.fav.a.b.aS(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.aS(paramc.field_totalLen) }));
        AppMethodBeat.o(107155);
        return;
      }
      a(paramc.getProgress(), getString(2131758872, new Object[] { com.tencent.mm.plugin.fav.a.b.aS(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.aS(paramc.field_totalLen) }));
      if ((this.qhy) && (i.eK(paramc.field_path)))
      {
        this.qaS.field_itemStatus = 10;
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
        ad.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107122);
            this.qcu.dismiss();
            AppMethodBeat.o(107122);
          }
        };
        paramInt2 = getType();
        if (!bt.isNullOrNil((String)localObject1)) {
          break label159;
        }
        AppMethodBeat.o(107154);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label159:
      Iterator localIterator = bt.S(((String)localObject1).split(",")).iterator();
      label267:
      label311:
      label339:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((paramInt2 == 4) || (paramInt2 == 15))
        {
          com.tencent.mm.plugin.fav.ui.l.a((MMActivity)super.getContext(), str, this.djJ, (Runnable)localObject2);
          boolean bool = w.pF(str);
          if (bool)
          {
            localObject1 = m.c.qaB;
            label245:
            com.tencent.mm.plugin.fav.a.g localg = this.qaS;
            m.d locald = m.d.qaF;
            if (!bool) {
              break label311;
            }
            paramInt1 = com.tencent.mm.model.q.rY(str);
            com.tencent.mm.plugin.fav.a.m.a((m.c)localObject1, localg, locald, paramInt1);
          }
        }
        for (;;)
        {
          if (bt.isNullOrNil(paramIntent)) {
            break label339;
          }
          j.cOB().W(str, paramIntent, w.tq(str));
          break;
          localObject1 = m.c.qaA;
          break label245;
          paramInt1 = 0;
          break label267;
          com.tencent.mm.plugin.fav.ui.l.a((MMActivity)super.getContext(), str, this.qaS, this.djJ, (Runnable)localObject2);
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
    this.gAC = new ap();
    this.deL = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.qhy = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.drV = getIntent().getBooleanExtra("show_share", true);
    this.qhz = getIntent().getStringExtra("fav_note_xml");
    this.qaS = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(this.deL);
    if ((this.qhy) && (!bt.isNullOrNil(this.qhz))) {
      this.qaS = com.tencent.mm.plugin.fav.a.b.XY(this.qhz);
    }
    if (this.qaS == null)
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      AppMethodBeat.o(107140);
      return;
    }
    H(this.qaS);
    com.tencent.mm.plugin.fav.a.m.x(this.qaS);
    cjy();
    this.oAT = ((Button)findViewById(2131303391));
    this.qho = ((Button)findViewById(2131303020));
    this.qhp = ((Button)findViewById(2131299195));
    this.qhq = ((MMImageView)findViewById(2131300891));
    this.imt = ((TextView)findViewById(2131302666));
    this.kXT = ((TextView)findViewById(2131305896));
    this.qht = findViewById(2131299221);
    this.qhs = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.qhr = ((TextView)findViewById(2131299217));
    this.qhu = ((TextView)findViewById(2131304777));
    this.qhv = ((ImageView)findViewById(2131299790));
    this.qhw = ((TextView)findViewById(2131299791));
    this.imt.setOnTouchListener(this.qhG);
    this.imt.setOnLongClickListener(this.qhH);
    final int i = getType();
    label420:
    Object localObject2;
    label457:
    final boolean bool1;
    if (4 == i)
    {
      setMMTitle(2131759030);
      if (this.djJ.dataType != 4) {
        break label916;
      }
      this.qhq.setImageResource(2131689581);
      this.imt.setText(this.djJ.title);
      localObject2 = this.djJ.DgZ;
      if (localObject2 != null) {
        break label946;
      }
      this.qhu.setVisibility(8);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107126);
          com.tencent.mm.plugin.fav.a.m.a(m.a.qaq, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          if ((FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).rg(1)))
          {
            AppMethodBeat.o(107126);
            return true;
          }
          FavoriteFileDetailUI.this.finish();
          AppMethodBeat.o(107126);
          return true;
        }
      });
      this.qho.setOnClickListener(new View.OnClickListener()
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
      paramBundle = this.djJ.Dgg;
      if (!bt.isNullOrNil(paramBundle)) {
        this.oAT.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(107128);
            ad.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId) });
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramBundle);
            paramAnonymousView.putExtra("is_favorite_item", true);
            paramAnonymousView.putExtra("fav_local_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            com.tencent.mm.bs.d.b(FavoriteFileDetailUI.this.cjz(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            AppMethodBeat.o(107128);
          }
        });
      }
      this.qhp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107129);
          ad.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_itemStatus) });
          if (!com.tencent.mm.compatible.util.e.XG())
          {
            com.tencent.mm.ui.base.h.j(FavoriteFileDetailUI.this.cjz(), 2131758934, 2131758845);
            AppMethodBeat.o(107129);
            return;
          }
          if ((FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isUploadFailed()) || (bt.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).DfZ))) {
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
      this.qht.setOnClickListener(new View.OnClickListener()
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
      if (this.drV)
      {
        final boolean bool2 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label1239;
        }
        bool1 = this.qaS.chE();
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
                if ((!k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).Dhh == 0)) {}
              }
              else if (!bool2)
              {
                AppMethodBeat.o(107136);
                return false;
              }
              paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(FavoriteFileDetailUI.this.cjz(), 1, false);
              paramAnonymousMenuItem.HrX = new n.c()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(107131);
                  if (FavoriteFileDetailUI.16.this.qhO)
                  {
                    FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
                    if ((!k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).Dhh == 0))
                    {
                      if (FavoriteFileDetailUI.16.this.val$type != 8) {
                        break label222;
                      }
                      paramAnonymous2l.c(0, FavoriteFileDetailUI.this.getString(2131759001));
                      if (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null)
                      {
                        FavoriteFileDetailUI.c(FavoriteFileDetailUI.this);
                        if (!FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bzs()) {
                          break label201;
                        }
                        paramAnonymous2l.c(5, FavoriteFileDetailUI.this.getString(2131756770));
                      }
                    }
                  }
                  for (;;)
                  {
                    if (FavoriteFileDetailUI.16.this.qhP)
                    {
                      paramAnonymous2l.c(3, FavoriteFileDetailUI.this.getString(2131758875));
                      paramAnonymous2l.c(2, FavoriteFileDetailUI.this.cjz().getString(2131755707));
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
                      if ((FavoriteFileDetailUI.16.this.qhP) && (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).chF())) {
                        paramAnonymous2l.c(1, FavoriteFileDetailUI.this.getString(2131758951));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.HrY = new n.d()
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
                      if (!i.eK(paramAnonymous2MenuItem))
                      {
                        ad.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131758999), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                      if (new com.tencent.mm.vfs.e(paramAnonymous2MenuItem).length() > 10485760L)
                      {
                        ad.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131759000), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                    }
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.qhk;
                    paramAnonymous2MenuItem.pZR += 1;
                    FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.qhk;
                    paramAnonymous2MenuItem.pZS += 1;
                    Object localObject = com.tencent.mm.ui.base.h.b(FavoriteFileDetailUI.this.cjz(), FavoriteFileDetailUI.this.getString(2131758906), false, null);
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.cjz();
                    com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(FavoriteFileDetailUI.this);
                    localObject = new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107132);
                        this.qcu.dismiss();
                        AppMethodBeat.o(107132);
                      }
                    };
                    LinkedList localLinkedList = new LinkedList();
                    localLinkedList.add(Integer.valueOf(localg.field_id));
                    paramAnonymous2MenuItem = new an("", localLinkedList, new l.2(localg, paramAnonymous2MenuItem, (Runnable)localObject));
                    com.tencent.mm.kernel.g.aeS().a(paramAnonymous2MenuItem, 0);
                    AppMethodBeat.o(107135);
                    return;
                    com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.cjz(), FavoriteFileDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(107134);
                        paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteFileDetailUI.this.cjz(), FavoriteFileDetailUI.this.getString(2131755709), false, null);
                        com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId, new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(107133);
                            FavoriteFileDetailUI.this.qhk.pZV = true;
                            paramAnonymous3DialogInterface.dismiss();
                            ad.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id) });
                            FavoriteFileDetailUI.this.finish();
                            AppMethodBeat.o(107133);
                          }
                        });
                        AppMethodBeat.o(107134);
                      }
                    }, null);
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.qhk;
                    paramAnonymous2MenuItem.pZU += 1;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                    paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.this.cjz(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                    AppMethodBeat.o(107135);
                    return;
                    FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(107135);
                    return;
                  } while (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) == null);
                  paramAnonymous2MenuItem = FavoriteFileDetailUI.c(FavoriteFileDetailUI.this);
                  if (!FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bzs()) {}
                  for (;;)
                  {
                    paramAnonymous2MenuItem.fE(bool);
                    break;
                    bool = false;
                  }
                }
              };
              paramAnonymousMenuItem.csG();
              AppMethodBeat.o(107136);
              return true;
            }
          });
        }
      }
      this.qhE = HandOffFile.b(this.djJ, this.qaS);
      if (!com.tencent.mm.plugin.fav.a.b.g(this.djJ)) {
        break label1312;
      }
      this.qhE.stq = 1;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.qhE);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.qhE);
      kF(false);
      if (getType() == 8)
      {
        paramBundle = com.tencent.mm.plugin.fav.a.b.d(this.djJ);
        bool1 = i.eK(paramBundle);
        if (bool1)
        {
          this.qhF = new com.tencent.mm.plugin.fav.ui.b.a(new com.tencent.mm.plugin.fav.ui.b.b((MMActivity)super.getContext()));
          this.qhF.fO(paramBundle, this.djJ.Dgo);
          localObject2 = this.qhF;
          paramBundle = this.djJ.Dgo;
          String str = this.djJ.title;
          localObject1 = com.tencent.mm.plugin.ball.f.d.OK(paramBundle);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = com.tencent.mm.plugin.ball.f.d.OK("unknown");
          }
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).mDH.kYl = paramBundle.intValue();
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).mDH.name = str;
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).bzv();
          this.qhE.K(this.qhF.mDH);
        }
        ad.i("MicroMsg.FavoriteFileDetailUI", "initFloatBallHelper() ifSupportFB:%s", new Object[] { Boolean.valueOf(bool1) });
      }
      AppMethodBeat.o(107140);
      return;
      if (15 == i)
      {
        setMMTitle(2131759030);
        findViewById(2131306317).setBackgroundResource(2131100017);
        this.imt.setVisibility(8);
        break;
      }
      setMMTitle(2131758904);
      break;
      label916:
      this.qhq.setImageResource(((ab)com.tencent.mm.kernel.g.ab(ab.class)).Yn(this.djJ.Dgo));
      break label420;
      label946:
      if (bt.isNullOrNil(((agb)localObject2).gJv))
      {
        ad.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = ((agb)localObject2).gJy;
        localObject1 = ((agb)localObject2).gJz;
        if ((!bt.isNullOrNil(paramBundle)) && (!bt.isNullOrNil((String)localObject1)))
        {
          this.qhu.setText(paramBundle);
          this.qhu.setVisibility(0);
          this.qhu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymousView)
            {
              AppMethodBeat.i(107114);
              paramAnonymousView = new Intent();
              Bundle localBundle = new Bundle();
              localBundle.putString("key_snsad_statextstr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).dxG);
              paramAnonymousView.putExtra("jsapiargs", localBundle);
              paramAnonymousView.putExtra("rawUrl", this.qhI);
              paramAnonymousView.putExtra("useJs", true);
              new ap(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(107113);
                  com.tencent.mm.bs.d.b(FavoriteFileDetailUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                  FavoriteFileDetailUI.this.finish();
                  AppMethodBeat.o(107113);
                }
              });
              AppMethodBeat.o(107114);
            }
          });
          break label457;
        }
        this.qhu.setVisibility(8);
        break label457;
      }
      Object localObject1 = getResources().getString(2131763759);
      paramBundle = (Bundle)localObject1;
      if (((agb)localObject2).Dim / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131763761, new Object[] { Integer.valueOf(((agb)localObject2).Dim / 60) });
      }
      localObject1 = paramBundle;
      if (((agb)localObject2).Dim % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131763762, new Object[] { Integer.valueOf(((agb)localObject2).Dim % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131763760);
      this.qhu.setText(paramBundle);
      this.qhu.setVisibility(0);
      this.qhu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107125);
          com.tencent.mm.plugin.fav.a.m.a(m.a.qao, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          paramAnonymousView = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).DgZ;
          String str = com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
          Intent localIntent = new Intent();
          localIntent.putExtra("KFromTimeLine", false);
          localIntent.putExtra("KStremVideoUrl", paramAnonymousView.gJv);
          localIntent.putExtra("StreamWording", paramAnonymousView.gJy);
          localIntent.putExtra("StremWebUrl", paramAnonymousView.gJz);
          localIntent.putExtra("KBlockFav", true);
          localIntent.putExtra("KThumUrl", paramAnonymousView.gJA);
          localIntent.putExtra("KThumbPath", str);
          localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KMediaVideoTime", paramAnonymousView.Dim);
          localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title);
          localIntent.putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.gJB);
          localIntent.putExtra("KSta_StremVideoPublishId", paramAnonymousView.gJC);
          localIntent.putExtra("KSta_SourceType", 1);
          localIntent.putExtra("KSta_Scene", m.b.qay.value);
          localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_fromUser);
          localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).dxG);
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjp, 0) > 0)
          {
            com.tencent.mm.bs.d.b(FavoriteFileDetailUI.this, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
            ad.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
            AppMethodBeat.o(107125);
            return;
          }
          com.tencent.mm.bs.d.b(FavoriteFileDetailUI.this, "sns", ".ui.VideoAdPlayerUI", localIntent);
          AppMethodBeat.o(107125);
        }
      });
      break label457;
      label1239:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.m.g.Zd().getValue("SIGHTCannotTransmitForFav");
        if ((this.qaS.chE()) && (bt.aGh(paramBundle) == 0))
        {
          bool1 = true;
          break label584;
        }
        bool1 = false;
        break label584;
      }
      if ((this.qaS.chF()) || (this.qaS.chE()))
      {
        bool1 = true;
        break label584;
      }
      bool1 = false;
      break label584;
      label1312:
      if (bt.isNullOrNil(this.djJ.DfZ)) {
        this.qhE.stq = 3;
      } else {
        this.qhE.stq = 2;
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
    if (this.nAZ != null)
    {
      this.nAZ.setVideoCallback(null);
      this.nAZ.stop();
      this.nAZ.onDetach();
    }
    if (this.qhF != null) {
      this.qhF.onDestroy();
    }
    if (this.qhE != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.qhE);
    }
    super.onDestroy();
    AppMethodBeat.o(107151);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107142);
    ad.i("MicroMsg.FavoriteFileDetailUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.qhF != null) && (this.qhF.rg(2)))
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
    if (this.nAZ != null) {
      this.nAZ.stop();
    }
    if (this.qhF != null) {
      this.qhF.aWa();
    }
    AppMethodBeat.o(107153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107152);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    if (this.nAZ != null) {
      this.nAZ.start();
    }
    if (this.qhF != null) {
      this.qhF.aVZ();
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