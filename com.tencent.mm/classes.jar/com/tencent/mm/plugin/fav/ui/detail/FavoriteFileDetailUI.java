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
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l.2;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.p, k.a
{
  private static final long rIa;
  private boolean dCy;
  private long doH;
  private ajx dtI;
  private aq gKO;
  private TextView jiC;
  private TextView mdu;
  private com.tencent.mm.pluginsdk.ui.tools.h oNV;
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.widget.b.a ofu;
  private Button pOz;
  private ProgressBar progressBar;
  private n.e qsh;
  private com.tencent.mm.plugin.fav.a.g rBM;
  private com.tencent.mm.plugin.fav.a.k rFY;
  private Button rIb;
  private Button rIc;
  private MMImageView rId;
  private TextView rIe;
  private View rIf;
  private View rIg;
  private TextView rIh;
  private ImageView rIi;
  private TextView rIj;
  private boolean rIk;
  private boolean rIl;
  private String rIm;
  private String rIn;
  private boolean rIo;
  private boolean rIp;
  private boolean rIq;
  private HandOffFile rIr;
  private com.tencent.mm.plugin.fav.ui.b.a rIs;
  private View.OnTouchListener rIt;
  private View.OnLongClickListener rIu;
  
  static
  {
    AppMethodBeat.i(191070);
    rIa = com.tencent.mm.n.b.acs();
    AppMethodBeat.o(191070);
  }
  
  public FavoriteFileDetailUI()
  {
    AppMethodBeat.i(107138);
    this.oNV = null;
    this.rFY = new com.tencent.mm.plugin.fav.a.k();
    this.rIk = false;
    this.rIl = false;
    this.dCy = true;
    this.rIo = false;
    this.rIp = false;
    this.rIq = false;
    this.ofu = null;
    this.qsh = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107137);
        ClipboardManager localClipboardManager = (ClipboardManager)ak.getContext().getSystemService("clipboard");
        if (bu.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)) {}
        for (paramAnonymousMenuItem = FavoriteFileDetailUI.this.getString(2131761808);; paramAnonymousMenuItem = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          com.tencent.mm.ui.base.h.cm(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131755702));
          AppMethodBeat.o(107137);
          return;
        }
      }
    };
    this.rIt = new FavoriteFileDetailUI.2(this);
    this.rIu = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107116);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
        if (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) == null) {
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.cyr()));
        }
        FavoriteFileDetailUI.m(FavoriteFileDetailUI.this).a(paramAnonymousView, FavoriteFileDetailUI.this, FavoriteFileDetailUI.n(FavoriteFileDetailUI.this), FavoriteFileDetailUI.o(FavoriteFileDetailUI.this), FavoriteFileDetailUI.p(FavoriteFileDetailUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107116);
        return true;
      }
    };
    AppMethodBeat.o(107138);
  }
  
  private void a(final float paramFloat, final String paramString)
  {
    AppMethodBeat.i(107156);
    this.gKO.post(new Runnable()
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
  
  private void bpx()
  {
    AppMethodBeat.i(107158);
    if (this.rIo)
    {
      AppMethodBeat.o(107158);
      return;
    }
    Object localObject = this.rHW;
    ((com.tencent.mm.plugin.fav.a.h.a)localObject).rAL += 1;
    this.rIo = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.doH);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(this.dtI));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(this.dtI));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.dtI.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.dtI.dIA);
    ((Intent)localObject).putExtra("key_detail_msg_uuid", this.dtI.ixk);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
    AppMethodBeat.o(107158);
  }
  
  private void cyq()
  {
    AppMethodBeat.i(107139);
    this.rIn = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.rBM.field_favProto.oeJ.iterator();
    while (localIterator.hasNext())
    {
      ajx localajx = (ajx)localIterator.next();
      if (localajx.dua.equals(this.rIn)) {
        this.dtI = localajx;
      }
    }
    if (this.dtI == null) {
      this.dtI = com.tencent.mm.plugin.fav.a.b.c(this.rBM);
    }
    AppMethodBeat.o(107139);
  }
  
  private void cys()
  {
    AppMethodBeat.i(107146);
    this.rId.setVisibility(8);
    this.jiC.setVisibility(8);
    this.rIc.setVisibility(8);
    this.pOz.setVisibility(8);
    this.rIb.setVisibility(8);
    this.rIf.setVisibility(8);
    this.mdu.setVisibility(8);
    this.rIi.setVisibility(0);
    this.rIj.setVisibility(0);
    if (this.dtI.dataType == 4)
    {
      this.mdu.setGravity(17);
      this.mdu.setText(2131758941);
      AppMethodBeat.o(107146);
      return;
    }
    this.mdu.setGravity(17);
    this.mdu.setText(2131758940);
    if (this.dtI.GAI == 2)
    {
      this.rIj.setText(2131758858);
      AppMethodBeat.o(107146);
      return;
    }
    this.rIj.setText(2131758859);
    AppMethodBeat.o(107146);
  }
  
  private void cyt()
  {
    AppMethodBeat.i(107147);
    this.rIc.setVisibility(8);
    this.pOz.setVisibility(8);
    this.rIb.setVisibility(8);
    this.mdu.setVisibility(8);
    this.rIf.setVisibility(0);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(this.dtI.dua);
    int j;
    int i;
    int k;
    if (localc != null)
    {
      j = (int)localc.getProgress();
      i = localc.field_offset;
      k = localc.field_totalLen;
    }
    while ((this.rBM.cwu()) && (bu.isNullOrNil(this.dtI.GzA)))
    {
      a(j, getString(2131759028, new Object[] { com.tencent.mm.plugin.fav.a.b.ba(i), com.tencent.mm.plugin.fav.a.b.ba(k) }));
      AppMethodBeat.o(107147);
      return;
      k = (int)this.dtI.GzV;
      i = 0;
      j = 0;
    }
    a(j, getString(2131758872, new Object[] { com.tencent.mm.plugin.fav.a.b.ba(i), com.tencent.mm.plugin.fav.a.b.ba(k) }));
    AppMethodBeat.o(107147);
  }
  
  private void cyu()
  {
    AppMethodBeat.i(107148);
    this.rIf.setVisibility(8);
    this.rIb.setVisibility(8);
    if (bu.isNullOrNil(this.dtI.GzH))
    {
      this.pOz.setVisibility(8);
      this.rIc.setVisibility(0);
      localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(this.dtI.dua);
      if ((localObject == null) || (((com.tencent.mm.plugin.fav.a.c)localObject).field_offset <= 0)) {
        break label150;
      }
      localObject = this.rIc;
      if (!this.rBM.isUploadFailed()) {
        break label143;
      }
    }
    label143:
    for (int i = 2131758922;; i = 2131758921)
    {
      ((Button)localObject).setText(i);
      this.mdu.setVisibility(8);
      AppMethodBeat.o(107148);
      return;
      this.pOz.setVisibility(0);
      break;
    }
    label150:
    Object localObject = this.rIc;
    if (this.rBM.isUploadFailed()) {}
    for (i = 2131758923;; i = 2131758918)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private boolean cyv()
  {
    AppMethodBeat.i(107149);
    if ((com.tencent.mm.plugin.fav.a.b.g(this.dtI)) && (com.tencent.mm.plugin.fav.a.b.h(this.dtI)))
    {
      AppMethodBeat.o(107149);
      return true;
    }
    AppMethodBeat.o(107149);
    return false;
  }
  
  private void cyw()
  {
    AppMethodBeat.i(107150);
    if ((getType() == 15) && (this.dtI.GAA != null) && (!bu.isNullOrNil(this.dtI.GAA.hET)) && (!bu.isNullOrNil(this.dtI.GAA.hEX)))
    {
      this.rIp = true;
      this.rId.setVisibility(8);
      this.rIf.setVisibility(8);
      this.rIc.setVisibility(8);
      this.pOz.setVisibility(8);
      this.rIb.setVisibility(8);
      this.mdu.setVisibility(8);
      String str = com.tencent.mm.plugin.fav.a.b.d(this.dtI);
      ae.d("MicroMsg.FavoriteFileDetailUI", f.abq() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131306317);
      this.oNV = t.hK((MMActivity)super.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.oNV, 0, localLayoutParams);
      this.oNV.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.h.a()
      {
        public final int eU(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
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
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107117);
              com.tencent.mm.ui.base.h.l(FavoriteFileDetailUI.this.cyr(), 2131764680, 2131764690);
              Bitmap localBitmap = com.tencent.mm.plugin.fav.ui.o.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this), FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
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
        
        public final void ta()
        {
          AppMethodBeat.i(107118);
          ae.d("MicroMsg.FavoriteFileDetailUI", f.abq() + " onPrepared");
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).setLoop(true);
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).start();
          AppMethodBeat.o(107118);
        }
      });
      ae.d("MicroMsg.FavoriteFileDetailUI", f.abq() + " initView :" + str);
      if (str != null)
      {
        this.oNV.stop();
        this.oNV.setVideoPath(str);
      }
      ae.d("MicroMsg.FavoriteFileDetailUI", f.abq() + " initView");
      com.tencent.mm.ay.a.aJX();
      com.tencent.mm.plugin.report.service.g.yxI.f(11444, new Object[] { Integer.valueOf(4) });
    }
    if ((getType() == 15) || (getType() == 4)) {
      if (!this.rIp)
      {
        this.rIf.setVisibility(8);
        this.rIc.setVisibility(8);
        this.pOz.setVisibility(8);
        this.rIb.setVisibility(0);
        this.rIb.setText(2131758920);
        this.mdu.setVisibility(8);
        bpx();
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107121);
          com.tencent.mm.plugin.fav.a.b.o(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          AppMethodBeat.o(107121);
        }
      });
      if (this.rIr.uPu != 1)
      {
        this.rIr.uPu = 1;
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.rIr);
      }
      AppMethodBeat.o(107150);
      return;
      if (!cyv()) {
        break;
      }
      this.rIf.setVisibility(8);
      this.rIc.setVisibility(8);
      this.pOz.setVisibility(0);
      this.rIb.setVisibility(8);
      this.mdu.setVisibility(8);
      this.pOz.setOnClickListener(new FavoriteFileDetailUI.5(this));
    }
    this.rIf.setVisibility(8);
    this.rIc.setVisibility(8);
    if (bu.isNullOrNil(this.dtI.GzH)) {
      this.pOz.setVisibility(8);
    }
    for (;;)
    {
      this.rIb.setVisibility(0);
      this.rHW.rAK = true;
      this.mdu.setVisibility(0);
      break;
      this.pOz.setVisibility(0);
    }
  }
  
  private boolean cyx()
  {
    AppMethodBeat.i(107159);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(this.dtI.dua);
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
    if (this.dtI.dataType == 8)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if (this.rIq)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if ((localc.field_status == 4) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(this.dtI.dua).field_extFlag != 0))
    {
      com.tencent.mm.plugin.fav.a.b.a(this.rBM, this.dtI, true);
      this.rIq = true;
    }
    ae.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.rIq) });
    boolean bool = this.rIq;
    AppMethodBeat.o(107159);
    return bool;
  }
  
  private int getType()
  {
    AppMethodBeat.i(107143);
    if (this.dtI == null)
    {
      ae.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
      AppMethodBeat.o(107143);
      return 8;
    }
    if (this.dtI.dataType == 0)
    {
      ae.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.rBM.field_type) });
      if (4 == this.rBM.field_type)
      {
        AppMethodBeat.o(107143);
        return 4;
      }
      if (16 == this.rBM.field_type)
      {
        if ((this.dtI != null) && (this.dtI.GAA != null))
        {
          if (!bu.isNullOrNil(this.dtI.GAA.hET))
          {
            AppMethodBeat.o(107143);
            return 15;
          }
          if (!bu.isNullOrNil(this.dtI.GAA.hEX))
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
    if (this.dtI.dataType == 15)
    {
      if ((this.dtI != null) && (this.dtI.GAA != null))
      {
        if (!bu.isNullOrNil(this.dtI.GAA.hET))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
        if (!bu.isNullOrNil(this.dtI.GAA.hEX))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
      }
      AppMethodBeat.o(107143);
      return 4;
    }
    int i = this.dtI.dataType;
    AppMethodBeat.o(107143);
    return i;
  }
  
  private void lC(boolean paramBoolean)
  {
    AppMethodBeat.i(107144);
    boolean bool = com.tencent.mm.plugin.fav.a.b.g(this.dtI);
    ae.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.rBM.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.d(this.dtI) });
    if (this.dtI.GAI != 0)
    {
      cys();
      AppMethodBeat.o(107144);
      return;
    }
    int i;
    if ((this.rBM.isDone()) || (bool) || (!bu.isNullOrNil(this.dtI.GzA)))
    {
      if (bool)
      {
        cyw();
        i = getIntent().getIntExtra("key_detail_open_way", 0);
        akp localakp;
        if (bu.jB(i, 1))
        {
          localakp = new akp();
          localakp.dKW = 2;
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), this.rBM, localakp);
          AppMethodBeat.o(107144);
          return;
        }
        if (bu.jB(i, 2))
        {
          localakp = new akp();
          localakp.dKW = 2;
          if ((this.dtI.dataType == 8) && (bu.lX(this.dtI.dua, this.rIn)))
          {
            com.tencent.mm.plugin.fav.a.g localg = this.rBM.cwy();
            localg.field_type = 8;
            localg.rAz = true;
            localg.rAA = this.rBM;
            localg.dtQ = (this.rBM.field_localId + "_" + this.rIn);
            localg.rAB = this.rIn;
            localg.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(this.rBM.field_favProto);
            localg.field_favProto.oeJ = new LinkedList();
            localg.field_favProto.oeJ.add(this.dtI);
            localg.field_favProto.aQA(this.dtI.title);
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), localg, localakp);
            AppMethodBeat.o(107144);
            return;
          }
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), this.rBM, localakp);
        }
        AppMethodBeat.o(107144);
        return;
      }
      if (bu.isNullOrNil(this.dtI.GzA))
      {
        cys();
        AppMethodBeat.o(107144);
        return;
      }
      ae.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
      cyu();
      AppMethodBeat.o(107144);
      return;
    }
    if (this.rBM.cwv())
    {
      if (bu.isNullOrNil(this.dtI.GzA))
      {
        cys();
        if (paramBoolean)
        {
          i = getType();
          if ((4 == i) || (15 == i)) {}
          for (i = 2131758978;; i = 2131758965)
          {
            com.tencent.mm.ui.base.h.cm((MMActivity)super.getContext(), getString(i));
            AppMethodBeat.o(107144);
            return;
          }
        }
      }
      else
      {
        cyu();
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.cm((MMActivity)super.getContext(), getString(2131758104));
          AppMethodBeat.o(107144);
        }
      }
    }
    else if (this.rBM.isUploadFailed())
    {
      cyu();
      if (paramBoolean)
      {
        com.tencent.mm.ui.base.h.cm((MMActivity)super.getContext(), getString(2131758844));
        AppMethodBeat.o(107144);
      }
    }
    else
    {
      if ((this.rBM.isDownloading()) || (this.rBM.cwu()))
      {
        cyt();
        AppMethodBeat.o(107144);
        return;
      }
      ae.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      cyu();
    }
    AppMethodBeat.o(107144);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(107157);
    ae.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.rBM.field_localId) });
    paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(this.rBM.field_localId);
    if ((paramString == null) && (!this.rIl))
    {
      ae.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107157);
      return;
    }
    if (!this.rIl) {
      this.rBM = paramString;
    }
    cyq();
    if (cyx())
    {
      AppMethodBeat.o(107157);
      return;
    }
    this.gKO.post(new Runnable()
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
  
  public final MMActivity cyr()
  {
    AppMethodBeat.i(224513);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(224513);
    return localMMActivity;
  }
  
  public final void e(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(107155);
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      ae.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(107155);
      return;
    }
    ae.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.dtI.dua, paramc.field_dataId });
    if (paramc.field_dataId.equals(this.dtI.dua))
    {
      if ((this.rBM.cwu()) && (bu.isNullOrNil(this.dtI.GzA)))
      {
        a(paramc.getProgress(), getString(2131759028, new Object[] { com.tencent.mm.plugin.fav.a.b.ba(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.ba(paramc.field_totalLen) }));
        AppMethodBeat.o(107155);
        return;
      }
      a(paramc.getProgress(), getString(2131758872, new Object[] { com.tencent.mm.plugin.fav.a.b.ba(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.ba(paramc.field_totalLen) }));
      if ((this.rIl) && (com.tencent.mm.vfs.o.fB(paramc.field_path)))
      {
        this.rBM.field_itemStatus = 10;
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
    ((ab)com.tencent.mm.kernel.g.ab(ab.class)).c(this, paramInt1, paramInt2, paramIntent);
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
          break label149;
        }
      }
      Object localObject2;
      label149:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        localObject2 = com.tencent.mm.ui.base.h.b((MMActivity)super.getContext(), getString(2131758906), false, null);
        ae.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new FavoriteFileDetailUI.7(this, (Dialog)localObject2);
        paramInt2 = getType();
        if (!bu.isNullOrNil((String)localObject1)) {
          break label160;
        }
        AppMethodBeat.o(107154);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label160:
      Iterator localIterator = bu.U(((String)localObject1).split(",")).iterator();
      label268:
      label312:
      label340:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((paramInt2 == 4) || (paramInt2 == 15))
        {
          com.tencent.mm.plugin.fav.ui.l.a((MMActivity)super.getContext(), str, this.dtI, (Runnable)localObject2);
          boolean bool = com.tencent.mm.model.x.wb(str);
          if (bool)
          {
            localObject1 = m.c.rBv;
            label246:
            com.tencent.mm.plugin.fav.a.g localg = this.rBM;
            m.d locald = m.d.rBz;
            if (!bool) {
              break label312;
            }
            paramInt1 = r.zC(str);
            com.tencent.mm.plugin.fav.a.m.a((m.c)localObject1, localg, locald, paramInt1);
          }
        }
        for (;;)
        {
          if (bu.isNullOrNil(paramIntent)) {
            break label340;
          }
          com.tencent.mm.plugin.messenger.a.g.doC().aa(str, paramIntent, com.tencent.mm.model.x.Bb(str));
          break;
          localObject1 = m.c.rBu;
          break label246;
          paramInt1 = 0;
          break label268;
          com.tencent.mm.plugin.fav.ui.l.a((MMActivity)super.getContext(), str, this.rBM, this.dtI, (Runnable)localObject2);
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
    this.gKO = new aq();
    this.doH = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.rIl = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.dCy = getIntent().getBooleanExtra("show_share", true);
    this.rIm = getIntent().getStringExtra("fav_note_xml");
    this.rBM = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(this.doH);
    if ((this.rIl) && (!bu.isNullOrNil(this.rIm))) {
      this.rBM = com.tencent.mm.plugin.fav.a.b.ahg(this.rIm);
    }
    if (this.rBM == null)
    {
      ae.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      AppMethodBeat.o(107140);
      return;
    }
    H(this.rBM);
    com.tencent.mm.plugin.fav.a.m.x(this.rBM);
    cyq();
    this.pOz = ((Button)findViewById(2131303391));
    this.rIb = ((Button)findViewById(2131303020));
    this.rIc = ((Button)findViewById(2131299195));
    this.rId = ((MMImageView)findViewById(2131300891));
    this.jiC = ((TextView)findViewById(2131302666));
    this.mdu = ((TextView)findViewById(2131305896));
    this.rIg = findViewById(2131299221);
    this.rIf = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.rIe = ((TextView)findViewById(2131299217));
    this.rIh = ((TextView)findViewById(2131304777));
    this.rIi = ((ImageView)findViewById(2131299790));
    this.rIj = ((TextView)findViewById(2131299791));
    this.jiC.setOnTouchListener(this.rIt);
    this.jiC.setOnLongClickListener(this.rIu);
    final int i = getType();
    label420:
    Object localObject2;
    label457:
    final boolean bool1;
    if (4 == i)
    {
      setMMTitle(2131759030);
      if (this.dtI.dataType != 4) {
        break label916;
      }
      this.rId.setImageResource(2131689581);
      this.jiC.setText(this.dtI.title);
      localObject2 = this.dtI.GAA;
      if (localObject2 != null) {
        break label947;
      }
      this.rIh.setVisibility(8);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107126);
          com.tencent.mm.plugin.fav.a.m.a(m.a.rBk, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          if ((FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).sy(1)))
          {
            AppMethodBeat.o(107126);
            return true;
          }
          FavoriteFileDetailUI.this.finish();
          AppMethodBeat.o(107126);
          return true;
        }
      });
      this.rIb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107127);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = com.tencent.mm.plugin.fav.a.b.d(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
          if (4 == FavoriteFileDetailUI.d(FavoriteFileDetailUI.this))
          {
            FavoriteFileDetailUI.e(FavoriteFileDetailUI.this);
            FavoriteFileDetailUI.f(FavoriteFileDetailUI.this);
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
      paramBundle = this.dtI.GzH;
      if (!bu.isNullOrNil(paramBundle)) {
        this.pOz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(107128);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId) });
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramBundle);
            paramAnonymousView.putExtra("is_favorite_item", true);
            paramAnonymousView.putExtra("fav_local_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            com.tencent.mm.br.d.b(FavoriteFileDetailUI.this.cyr(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107128);
          }
        });
      }
      this.rIc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_itemStatus) });
          if (!com.tencent.mm.compatible.util.e.abo())
          {
            com.tencent.mm.ui.base.h.l(FavoriteFileDetailUI.this.cyr(), 2131758934, 2131758845);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107129);
            return;
          }
          if ((FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isUploadFailed()) || (bu.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).GzA))) {
            com.tencent.mm.plugin.fav.a.b.l(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          }
          for (;;)
          {
            FavoriteFileDetailUI.h(FavoriteFileDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      this.rIg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isDownloading())
          {
            com.tencent.mm.plugin.fav.a.b.e(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.i(FavoriteFileDetailUI.this).setText(2131758921);
          }
          for (;;)
          {
            FavoriteFileDetailUI.j(FavoriteFileDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107130);
            return;
            com.tencent.mm.plugin.fav.a.b.n(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
            FavoriteFileDetailUI.i(FavoriteFileDetailUI.this).setText(2131758922);
          }
        }
      });
      if (this.dCy)
      {
        final boolean bool2 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label1240;
        }
        bool1 = this.rBM.cwr();
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
                if ((!com.tencent.mm.plugin.fav.a.k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).GAI == 0)) {}
              }
              else if (!bool2)
              {
                AppMethodBeat.o(107136);
                return false;
              }
              paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(FavoriteFileDetailUI.this.cyr(), 1, false);
              paramAnonymousMenuItem.LfS = new n.d()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(107131);
                  if (FavoriteFileDetailUI.16.this.rIB)
                  {
                    FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
                    if ((!com.tencent.mm.plugin.fav.a.k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).GAI == 0))
                    {
                      if (FavoriteFileDetailUI.16.this.val$type != 8) {
                        break label222;
                      }
                      paramAnonymous2l.d(0, FavoriteFileDetailUI.this.getString(2131759001));
                      if (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null)
                      {
                        FavoriteFileDetailUI.c(FavoriteFileDetailUI.this);
                        if (!FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bLw()) {
                          break label201;
                        }
                        paramAnonymous2l.d(5, FavoriteFileDetailUI.this.getString(2131756770));
                      }
                    }
                  }
                  for (;;)
                  {
                    if (FavoriteFileDetailUI.16.this.rIC)
                    {
                      paramAnonymous2l.d(3, FavoriteFileDetailUI.this.getString(2131758875));
                      paramAnonymous2l.d(2, FavoriteFileDetailUI.this.cyr().getString(2131755707));
                    }
                    AppMethodBeat.o(107131);
                    return;
                    label201:
                    paramAnonymous2l.d(5, FavoriteFileDetailUI.this.getString(2131758422));
                    continue;
                    label222:
                    if (FavoriteFileDetailUI.16.this.val$type == 15)
                    {
                      paramAnonymous2l.d(0, FavoriteFileDetailUI.this.getString(2131759001));
                      paramAnonymous2l.d(4, FavoriteFileDetailUI.this.getString(2131762784));
                    }
                    else if (FavoriteFileDetailUI.16.this.val$type == 4)
                    {
                      paramAnonymous2l.d(0, FavoriteFileDetailUI.this.getString(2131759001));
                      paramAnonymous2l.d(4, FavoriteFileDetailUI.this.getString(2131762784));
                    }
                    else
                    {
                      paramAnonymous2l.d(0, FavoriteFileDetailUI.this.getString(2131759001));
                      if ((FavoriteFileDetailUI.16.this.rIC) && (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).cws())) {
                        paramAnonymous2l.d(1, FavoriteFileDetailUI.this.getString(2131758951));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.LfT = new n.e()
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
                      if (!com.tencent.mm.vfs.o.fB(paramAnonymous2MenuItem))
                      {
                        ae.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131758999), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                      if (new com.tencent.mm.vfs.k(paramAnonymous2MenuItem).length() > FavoriteFileDetailUI.cyy())
                      {
                        ae.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131759000), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                    }
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.rHW;
                    paramAnonymous2MenuItem.rAM += 1;
                    FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.rHW;
                    paramAnonymous2MenuItem.rAN += 1;
                    Object localObject = com.tencent.mm.ui.base.h.b(FavoriteFileDetailUI.this.cyr(), FavoriteFileDetailUI.this.getString(2131758906), false, null);
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.cyr();
                    com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(FavoriteFileDetailUI.this);
                    localObject = new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107132);
                        this.rDo.dismiss();
                        AppMethodBeat.o(107132);
                      }
                    };
                    LinkedList localLinkedList = new LinkedList();
                    localLinkedList.add(Integer.valueOf(localg.field_id));
                    paramAnonymous2MenuItem = new an("", localLinkedList, new l.2(localg, paramAnonymous2MenuItem, (Runnable)localObject));
                    com.tencent.mm.kernel.g.ajj().a(paramAnonymous2MenuItem, 0);
                    AppMethodBeat.o(107135);
                    return;
                    com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.cyr(), FavoriteFileDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(107134);
                        paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteFileDetailUI.this.cyr(), FavoriteFileDetailUI.this.getString(2131755709), false, null);
                        com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId, new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(107133);
                            FavoriteFileDetailUI.this.rHW.rAQ = true;
                            paramAnonymous3DialogInterface.dismiss();
                            ae.d("MicroMsg.FavoriteFileDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id) });
                            FavoriteFileDetailUI.this.finish();
                            AppMethodBeat.o(107133);
                          }
                        });
                        AppMethodBeat.o(107134);
                      }
                    }, null);
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.rHW;
                    paramAnonymous2MenuItem.rAP += 1;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                    paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.this.cyr(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                    AppMethodBeat.o(107135);
                    return;
                    FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(107135);
                    return;
                  } while (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) == null);
                  paramAnonymous2MenuItem = FavoriteFileDetailUI.c(FavoriteFileDetailUI.this);
                  if (!FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bLw()) {}
                  for (;;)
                  {
                    paramAnonymous2MenuItem.o(bool, 2);
                    break;
                    bool = false;
                  }
                }
              };
              paramAnonymousMenuItem.cPF();
              AppMethodBeat.o(107136);
              return true;
            }
          });
        }
      }
      this.rIr = HandOffFile.b(this.dtI, this.rBM);
      if (!com.tencent.mm.plugin.fav.a.b.g(this.dtI)) {
        break label1313;
      }
      this.rIr.uPu = 1;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.rIr);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).g(this.rIr);
      lC(false);
      if (getType() == 8)
      {
        paramBundle = com.tencent.mm.plugin.fav.a.b.d(this.dtI);
        bool1 = com.tencent.mm.vfs.o.fB(paramBundle);
        if (bool1)
        {
          this.rIs = new com.tencent.mm.plugin.fav.ui.b.a(new com.tencent.mm.plugin.fav.ui.b.b((MMActivity)super.getContext()));
          this.rIs.gp(paramBundle, this.dtI.GzP);
          localObject2 = this.rIs;
          paramBundle = this.dtI.GzP;
          String str = this.dtI.title;
          localObject1 = com.tencent.mm.plugin.ball.f.d.Xd(paramBundle);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = com.tencent.mm.plugin.ball.f.d.Xd("unknown");
          }
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).nLK.mdM = paramBundle.intValue();
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).nLK.name = str;
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).bLz();
          this.rIr.N(this.rIs.nLK);
        }
        ae.i("MicroMsg.FavoriteFileDetailUI", "initFloatBallHelper() ifSupportFB:%s", new Object[] { Boolean.valueOf(bool1) });
      }
      AppMethodBeat.o(107140);
      return;
      if (15 == i)
      {
        setMMTitle(2131759030);
        findViewById(2131306317).setBackgroundResource(2131100017);
        this.jiC.setVisibility(8);
        break;
      }
      setMMTitle(2131758904);
      break;
      label916:
      this.rId.setImageResource(((ab)com.tencent.mm.kernel.g.ab(ab.class)).ahv(this.dtI.GzP));
      break label420;
      label947:
      if (bu.isNullOrNil(((aka)localObject2).hET))
      {
        ae.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = ((aka)localObject2).hEW;
        localObject1 = ((aka)localObject2).hEX;
        if ((!bu.isNullOrNil(paramBundle)) && (!bu.isNullOrNil((String)localObject1)))
        {
          this.rIh.setText(paramBundle);
          this.rIh.setVisibility(0);
          this.rIh.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymousView)
            {
              AppMethodBeat.i(107114);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              paramAnonymousView = new Intent();
              localObject = new Bundle();
              ((Bundle)localObject).putString("key_snsad_statextstr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).dIA);
              paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
              paramAnonymousView.putExtra("rawUrl", this.rIv);
              paramAnonymousView.putExtra("useJs", true);
              new aq(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(107113);
                  com.tencent.mm.br.d.b(FavoriteFileDetailUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
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
        this.rIh.setVisibility(8);
        break label457;
      }
      Object localObject1 = getResources().getString(2131763759);
      paramBundle = (Bundle)localObject1;
      if (((aka)localObject2).GBN / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131763761, new Object[] { Integer.valueOf(((aka)localObject2).GBN / 60) });
      }
      localObject1 = paramBundle;
      if (((aka)localObject2).GBN % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131763762, new Object[] { Integer.valueOf(((aka)localObject2).GBN % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131763760);
      this.rIh.setText(paramBundle);
      this.rIh.setVisibility(0);
      this.rIh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107125);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.plugin.fav.a.m.a(m.a.rBi, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          paramAnonymousView = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).GAA;
          localObject = com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
          Intent localIntent = new Intent();
          localIntent.putExtra("KFromTimeLine", false);
          localIntent.putExtra("KStremVideoUrl", paramAnonymousView.hET);
          localIntent.putExtra("StreamWording", paramAnonymousView.hEW);
          localIntent.putExtra("StremWebUrl", paramAnonymousView.hEX);
          localIntent.putExtra("KBlockFav", true);
          localIntent.putExtra("KThumUrl", paramAnonymousView.hEY);
          localIntent.putExtra("KThumbPath", (String)localObject);
          localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KMediaVideoTime", paramAnonymousView.GBN);
          localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title);
          localIntent.putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.hEZ);
          localIntent.putExtra("KSta_StremVideoPublishId", paramAnonymousView.hFa);
          localIntent.putExtra("KSta_SourceType", 1);
          localIntent.putExtra("KSta_Scene", m.b.rBs.value);
          localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_fromUser);
          localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).dIA);
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxf, 0) > 0)
          {
            com.tencent.mm.br.d.b(FavoriteFileDetailUI.this, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
            ae.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107125);
            return;
            com.tencent.mm.br.d.b(FavoriteFileDetailUI.this, "sns", ".ui.VideoAdPlayerUI", localIntent);
          }
        }
      });
      break label457;
      label1240:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.n.g.acL().getValue("SIGHTCannotTransmitForFav");
        if ((this.rBM.cwr()) && (bu.aSB(paramBundle) == 0))
        {
          bool1 = true;
          break label584;
        }
        bool1 = false;
        break label584;
      }
      if ((this.rBM.cws()) || (this.rBM.cwr()))
      {
        bool1 = true;
        break label584;
      }
      bool1 = false;
      break label584;
      label1313:
      if (bu.isNullOrNil(this.dtI.GzA)) {
        this.rIr.uPu = 3;
      } else {
        this.rIr.uPu = 2;
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
    if (this.oNV != null)
    {
      this.oNV.setVideoCallback(null);
      this.oNV.stop();
      this.oNV.onDetach();
    }
    if (this.rIs != null) {
      this.rIs.onDestroy();
    }
    if (this.rIr != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.rIr);
    }
    super.onDestroy();
    AppMethodBeat.o(107151);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107142);
    ae.i("MicroMsg.FavoriteFileDetailUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.rIs != null) && (this.rIs.sy(2)))
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
    if (this.oNV != null) {
      this.oNV.stop();
    }
    if (this.rIs != null) {
      this.rIs.bhk();
    }
    AppMethodBeat.o(107153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107152);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    if (this.oNV != null) {
      this.oNV.start();
    }
    if (this.rIs != null) {
      this.rIs.bhj();
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