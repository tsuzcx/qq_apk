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
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.p, k.a
{
  private static final long rzP;
  private boolean dBt;
  private long dnC;
  private ajn dsC;
  private ap gIf;
  private TextView jfJ;
  private TextView lZb;
  private int nYw;
  private int nYx;
  private com.tencent.mm.ui.widget.b.a nZK;
  private com.tencent.mm.pluginsdk.ui.tools.h oHt;
  private Button pHV;
  private ProgressBar progressBar;
  private n.e qlC;
  private boolean rAa;
  private String rAb;
  private String rAc;
  private boolean rAd;
  private boolean rAe;
  private boolean rAf;
  private HandOffFile rAg;
  private com.tencent.mm.plugin.fav.ui.b.a rAh;
  private View.OnTouchListener rAi;
  private View.OnLongClickListener rAj;
  private com.tencent.mm.plugin.fav.a.g rtA;
  private k rxN;
  private Button rzQ;
  private Button rzR;
  private MMImageView rzS;
  private TextView rzT;
  private View rzU;
  private View rzV;
  private TextView rzW;
  private ImageView rzX;
  private TextView rzY;
  private boolean rzZ;
  
  static
  {
    AppMethodBeat.i(218795);
    rzP = com.tencent.mm.n.b.aci();
    AppMethodBeat.o(218795);
  }
  
  public FavoriteFileDetailUI()
  {
    AppMethodBeat.i(107138);
    this.oHt = null;
    this.rxN = new k();
    this.rzZ = false;
    this.rAa = false;
    this.dBt = true;
    this.rAd = false;
    this.rAe = false;
    this.rAf = false;
    this.nZK = null;
    this.qlC = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107137);
        ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        if (bt.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)) {}
        for (paramAnonymousMenuItem = FavoriteFileDetailUI.this.getString(2131761808);; paramAnonymousMenuItem = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          com.tencent.mm.ui.base.h.cl(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131755702));
          AppMethodBeat.o(107137);
          return;
        }
      }
    };
    this.rAi = new FavoriteFileDetailUI.2(this);
    this.rAj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107116);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$11", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        ad.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
        if (FavoriteFileDetailUI.m(FavoriteFileDetailUI.this) == null) {
          FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, new com.tencent.mm.ui.widget.b.a(FavoriteFileDetailUI.this.cwQ()));
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
    this.gIf.post(new Runnable()
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
  
  private void boN()
  {
    AppMethodBeat.i(107158);
    if (this.rAd)
    {
      AppMethodBeat.o(107158);
      return;
    }
    Object localObject = this.rzL;
    ((com.tencent.mm.plugin.fav.a.h.a)localObject).rsy += 1;
    this.rAd = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.dnC);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.d(this.dsC));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.a(this.dsC));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.dsC.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.dsC.dHv);
    ((Intent)localObject).putExtra("key_detail_msg_uuid", this.dsC.iuq);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
    AppMethodBeat.o(107158);
  }
  
  private void cwP()
  {
    AppMethodBeat.i(107139);
    this.rAc = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.rtA.field_favProto.nZa.iterator();
    while (localIterator.hasNext())
    {
      ajn localajn = (ajn)localIterator.next();
      if (localajn.dsU.equals(this.rAc)) {
        this.dsC = localajn;
      }
    }
    if (this.dsC == null) {
      this.dsC = com.tencent.mm.plugin.fav.a.b.c(this.rtA);
    }
    AppMethodBeat.o(107139);
  }
  
  private void cwR()
  {
    AppMethodBeat.i(107146);
    this.rzS.setVisibility(8);
    this.jfJ.setVisibility(8);
    this.rzR.setVisibility(8);
    this.pHV.setVisibility(8);
    this.rzQ.setVisibility(8);
    this.rzU.setVisibility(8);
    this.lZb.setVisibility(8);
    this.rzX.setVisibility(0);
    this.rzY.setVisibility(0);
    if (this.dsC.dataType == 4)
    {
      this.lZb.setGravity(17);
      this.lZb.setText(2131758941);
      AppMethodBeat.o(107146);
      return;
    }
    this.lZb.setGravity(17);
    this.lZb.setText(2131758940);
    if (this.dsC.GhZ == 2)
    {
      this.rzY.setText(2131758858);
      AppMethodBeat.o(107146);
      return;
    }
    this.rzY.setText(2131758859);
    AppMethodBeat.o(107146);
  }
  
  private void cwS()
  {
    AppMethodBeat.i(107147);
    this.rzR.setVisibility(8);
    this.pHV.setVisibility(8);
    this.rzQ.setVisibility(8);
    this.lZb.setVisibility(8);
    this.rzU.setVisibility(0);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(this.dsC.dsU);
    int j;
    int i;
    int k;
    if (localc != null)
    {
      j = (int)localc.getProgress();
      i = localc.field_offset;
      k = localc.field_totalLen;
    }
    while ((this.rtA.cuT()) && (bt.isNullOrNil(this.dsC.GgR)))
    {
      a(j, getString(2131759028, new Object[] { com.tencent.mm.plugin.fav.a.b.ba(i), com.tencent.mm.plugin.fav.a.b.ba(k) }));
      AppMethodBeat.o(107147);
      return;
      k = (int)this.dsC.Ghm;
      i = 0;
      j = 0;
    }
    a(j, getString(2131758872, new Object[] { com.tencent.mm.plugin.fav.a.b.ba(i), com.tencent.mm.plugin.fav.a.b.ba(k) }));
    AppMethodBeat.o(107147);
  }
  
  private void cwT()
  {
    AppMethodBeat.i(107148);
    this.rzU.setVisibility(8);
    this.rzQ.setVisibility(8);
    if (bt.isNullOrNil(this.dsC.GgY))
    {
      this.pHV.setVisibility(8);
      this.rzR.setVisibility(0);
      localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(this.dsC.dsU);
      if ((localObject == null) || (((com.tencent.mm.plugin.fav.a.c)localObject).field_offset <= 0)) {
        break label150;
      }
      localObject = this.rzR;
      if (!this.rtA.isUploadFailed()) {
        break label143;
      }
    }
    label143:
    for (int i = 2131758922;; i = 2131758921)
    {
      ((Button)localObject).setText(i);
      this.lZb.setVisibility(8);
      AppMethodBeat.o(107148);
      return;
      this.pHV.setVisibility(0);
      break;
    }
    label150:
    Object localObject = this.rzR;
    if (this.rtA.isUploadFailed()) {}
    for (i = 2131758923;; i = 2131758918)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private boolean cwU()
  {
    AppMethodBeat.i(107149);
    if ((com.tencent.mm.plugin.fav.a.b.g(this.dsC)) && (com.tencent.mm.plugin.fav.a.b.h(this.dsC)))
    {
      AppMethodBeat.o(107149);
      return true;
    }
    AppMethodBeat.o(107149);
    return false;
  }
  
  private void cwV()
  {
    AppMethodBeat.i(107150);
    if ((getType() == 15) && (this.dsC.GhR != null) && (!bt.isNullOrNil(this.dsC.GhR.hCe)) && (!bt.isNullOrNil(this.dsC.GhR.hCi)))
    {
      this.rAe = true;
      this.rzS.setVisibility(8);
      this.rzU.setVisibility(8);
      this.rzR.setVisibility(8);
      this.pHV.setVisibility(8);
      this.rzQ.setVisibility(8);
      this.lZb.setVisibility(8);
      String str = com.tencent.mm.plugin.fav.a.b.d(this.dsC);
      ad.d("MicroMsg.FavoriteFileDetailUI", f.abh() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131306317);
      this.oHt = t.hE((MMActivity)super.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.oHt, 0, localLayoutParams);
      this.oHt.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.h.a()
      {
        public final int eT(int paramAnonymousInt1, int paramAnonymousInt2)
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
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(107117);
              com.tencent.mm.ui.base.h.l(FavoriteFileDetailUI.this.cwQ(), 2131764680, 2131764690);
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
        
        public final void ta()
        {
          AppMethodBeat.i(107118);
          ad.d("MicroMsg.FavoriteFileDetailUI", f.abh() + " onPrepared");
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).setLoop(true);
          FavoriteFileDetailUI.q(FavoriteFileDetailUI.this).start();
          AppMethodBeat.o(107118);
        }
      });
      ad.d("MicroMsg.FavoriteFileDetailUI", f.abh() + " initView :" + str);
      if (str != null)
      {
        this.oHt.stop();
        this.oHt.setVideoPath(str);
      }
      ad.d("MicroMsg.FavoriteFileDetailUI", f.abh() + " initView");
      com.tencent.mm.az.a.aJE();
      com.tencent.mm.plugin.report.service.g.yhR.f(11444, new Object[] { Integer.valueOf(4) });
    }
    if ((getType() == 15) || (getType() == 4)) {
      if (!this.rAe)
      {
        this.rzU.setVisibility(8);
        this.rzR.setVisibility(8);
        this.pHV.setVisibility(8);
        this.rzQ.setVisibility(0);
        this.rzQ.setText(2131758920);
        this.lZb.setVisibility(8);
        boN();
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107121);
          com.tencent.mm.plugin.fav.a.b.o(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          AppMethodBeat.o(107121);
        }
      });
      if (this.rAg.uDP != 1)
      {
        this.rAg.uDP = 1;
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.rAg);
      }
      AppMethodBeat.o(107150);
      return;
      if (!cwU()) {
        break;
      }
      this.rzU.setVisibility(8);
      this.rzR.setVisibility(8);
      this.pHV.setVisibility(0);
      this.rzQ.setVisibility(8);
      this.lZb.setVisibility(8);
      this.pHV.setOnClickListener(new FavoriteFileDetailUI.5(this));
    }
    this.rzU.setVisibility(8);
    this.rzR.setVisibility(8);
    if (bt.isNullOrNil(this.dsC.GgY)) {
      this.pHV.setVisibility(8);
    }
    for (;;)
    {
      this.rzQ.setVisibility(0);
      this.rzL.rsx = true;
      this.lZb.setVisibility(0);
      break;
      this.pHV.setVisibility(0);
    }
  }
  
  private boolean cwW()
  {
    AppMethodBeat.i(107159);
    com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(this.dsC.dsU);
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
    if (this.dsC.dataType == 8)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if (this.rAf)
    {
      AppMethodBeat.o(107159);
      return false;
    }
    if ((localc.field_status == 4) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(this.dsC.dsU).field_extFlag != 0))
    {
      com.tencent.mm.plugin.fav.a.b.a(this.rtA, this.dsC, true);
      this.rAf = true;
    }
    ad.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.rAf) });
    boolean bool = this.rAf;
    AppMethodBeat.o(107159);
    return bool;
  }
  
  private int getType()
  {
    AppMethodBeat.i(107143);
    if (this.dsC == null)
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
      AppMethodBeat.o(107143);
      return 8;
    }
    if (this.dsC.dataType == 0)
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.rtA.field_type) });
      if (4 == this.rtA.field_type)
      {
        AppMethodBeat.o(107143);
        return 4;
      }
      if (16 == this.rtA.field_type)
      {
        if ((this.dsC != null) && (this.dsC.GhR != null))
        {
          if (!bt.isNullOrNil(this.dsC.GhR.hCe))
          {
            AppMethodBeat.o(107143);
            return 15;
          }
          if (!bt.isNullOrNil(this.dsC.GhR.hCi))
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
    if (this.dsC.dataType == 15)
    {
      if ((this.dsC != null) && (this.dsC.GhR != null))
      {
        if (!bt.isNullOrNil(this.dsC.GhR.hCe))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
        if (!bt.isNullOrNil(this.dsC.GhR.hCi))
        {
          AppMethodBeat.o(107143);
          return 15;
        }
      }
      AppMethodBeat.o(107143);
      return 4;
    }
    int i = this.dsC.dataType;
    AppMethodBeat.o(107143);
    return i;
  }
  
  private void lC(boolean paramBoolean)
  {
    AppMethodBeat.i(107144);
    boolean bool = com.tencent.mm.plugin.fav.a.b.g(this.dsC);
    ad.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.rtA.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.d(this.dsC) });
    if (this.dsC.GhZ != 0)
    {
      cwR();
      AppMethodBeat.o(107144);
      return;
    }
    int i;
    if ((this.rtA.isDone()) || (bool) || (!bt.isNullOrNil(this.dsC.GgR)))
    {
      if (bool)
      {
        cwV();
        i = getIntent().getIntExtra("key_detail_open_way", 0);
        akf localakf;
        if (bt.jx(i, 1))
        {
          localakf = new akf();
          localakf.dJI = 2;
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), this.rtA, localakf);
          AppMethodBeat.o(107144);
          return;
        }
        if (bt.jx(i, 2))
        {
          localakf = new akf();
          localakf.dJI = 2;
          if ((this.dsC.dataType == 8) && (bt.lQ(this.dsC.dsU, this.rAc)))
          {
            com.tencent.mm.plugin.fav.a.g localg = this.rtA.cuX();
            localg.field_type = 8;
            localg.rsm = true;
            localg.rsn = this.rtA;
            localg.dsK = (this.rtA.field_localId + "_" + this.rAc);
            localg.rso = this.rAc;
            localg.field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(this.rtA.field_favProto);
            localg.field_favProto.nZa = new LinkedList();
            localg.field_favProto.nZa.add(this.dsC);
            localg.field_favProto.aPd(this.dsC.title);
            ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), localg, localakf);
            AppMethodBeat.o(107144);
            return;
          }
          ((y)com.tencent.mm.kernel.g.ab(y.class)).a((MMActivity)super.getContext(), this.rtA, localakf);
        }
        AppMethodBeat.o(107144);
        return;
      }
      if (bt.isNullOrNil(this.dsC.GgR))
      {
        cwR();
        AppMethodBeat.o(107144);
        return;
      }
      ad.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
      cwT();
      AppMethodBeat.o(107144);
      return;
    }
    if (this.rtA.cuU())
    {
      if (bt.isNullOrNil(this.dsC.GgR))
      {
        cwR();
        if (paramBoolean)
        {
          i = getType();
          if ((4 == i) || (15 == i)) {}
          for (i = 2131758978;; i = 2131758965)
          {
            com.tencent.mm.ui.base.h.cl((MMActivity)super.getContext(), getString(i));
            AppMethodBeat.o(107144);
            return;
          }
        }
      }
      else
      {
        cwT();
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.cl((MMActivity)super.getContext(), getString(2131758104));
          AppMethodBeat.o(107144);
        }
      }
    }
    else if (this.rtA.isUploadFailed())
    {
      cwT();
      if (paramBoolean)
      {
        com.tencent.mm.ui.base.h.cl((MMActivity)super.getContext(), getString(2131758844));
        AppMethodBeat.o(107144);
      }
    }
    else
    {
      if ((this.rtA.isDownloading()) || (this.rtA.cuT()))
      {
        cwS();
        AppMethodBeat.o(107144);
        return;
      }
      ad.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      cwT();
    }
    AppMethodBeat.o(107144);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(107157);
    ad.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.rtA.field_localId) });
    paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.rtA.field_localId);
    if ((paramString == null) && (!this.rAa))
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107157);
      return;
    }
    if (!this.rAa) {
      this.rtA = paramString;
    }
    cwP();
    if (cwW())
    {
      AppMethodBeat.o(107157);
      return;
    }
    this.gIf.post(new Runnable()
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
  
  public final MMActivity cwQ()
  {
    AppMethodBeat.i(221342);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(221342);
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
    ad.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.dsC.dsU, paramc.field_dataId });
    if (paramc.field_dataId.equals(this.dsC.dsU))
    {
      if ((this.rtA.cuT()) && (bt.isNullOrNil(this.dsC.GgR)))
      {
        a(paramc.getProgress(), getString(2131759028, new Object[] { com.tencent.mm.plugin.fav.a.b.ba(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.ba(paramc.field_totalLen) }));
        AppMethodBeat.o(107155);
        return;
      }
      a(paramc.getProgress(), getString(2131758872, new Object[] { com.tencent.mm.plugin.fav.a.b.ba(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.ba(paramc.field_totalLen) }));
      if ((this.rAa) && (i.fv(paramc.field_path)))
      {
        this.rtA.field_itemStatus = 10;
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
          break label149;
        }
      }
      Object localObject2;
      label149:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        localObject2 = com.tencent.mm.ui.base.h.b((MMActivity)super.getContext(), getString(2131758906), false, null);
        ad.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new FavoriteFileDetailUI.7(this, (Dialog)localObject2);
        paramInt2 = getType();
        if (!bt.isNullOrNil((String)localObject1)) {
          break label160;
        }
        AppMethodBeat.o(107154);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label160:
      Iterator localIterator = bt.U(((String)localObject1).split(",")).iterator();
      label268:
      label312:
      label340:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((paramInt2 == 4) || (paramInt2 == 15))
        {
          com.tencent.mm.plugin.fav.ui.l.a((MMActivity)super.getContext(), str, this.dsC, (Runnable)localObject2);
          boolean bool = w.vF(str);
          if (bool)
          {
            localObject1 = m.c.rti;
            label246:
            com.tencent.mm.plugin.fav.a.g localg = this.rtA;
            m.d locald = m.d.rtm;
            if (!bool) {
              break label312;
            }
            paramInt1 = com.tencent.mm.model.q.yS(str);
            com.tencent.mm.plugin.fav.a.m.a((m.c)localObject1, localg, locald, paramInt1);
          }
        }
        for (;;)
        {
          if (bt.isNullOrNil(paramIntent)) {
            break label340;
          }
          com.tencent.mm.plugin.messenger.a.g.dlD().aa(str, paramIntent, w.Ar(str));
          break;
          localObject1 = m.c.rth;
          break label246;
          paramInt1 = 0;
          break label268;
          com.tencent.mm.plugin.fav.ui.l.a((MMActivity)super.getContext(), str, this.rtA, this.dsC, (Runnable)localObject2);
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
    this.gIf = new ap();
    this.dnC = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.rAa = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.dBt = getIntent().getBooleanExtra("show_share", true);
    this.rAb = getIntent().getStringExtra("fav_note_xml");
    this.rtA = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.dnC);
    if ((this.rAa) && (!bt.isNullOrNil(this.rAb))) {
      this.rtA = com.tencent.mm.plugin.fav.a.b.agj(this.rAb);
    }
    if (this.rtA == null)
    {
      ad.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      AppMethodBeat.o(107140);
      return;
    }
    H(this.rtA);
    com.tencent.mm.plugin.fav.a.m.x(this.rtA);
    cwP();
    this.pHV = ((Button)findViewById(2131303391));
    this.rzQ = ((Button)findViewById(2131303020));
    this.rzR = ((Button)findViewById(2131299195));
    this.rzS = ((MMImageView)findViewById(2131300891));
    this.jfJ = ((TextView)findViewById(2131302666));
    this.lZb = ((TextView)findViewById(2131305896));
    this.rzV = findViewById(2131299221);
    this.rzU = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.rzT = ((TextView)findViewById(2131299217));
    this.rzW = ((TextView)findViewById(2131304777));
    this.rzX = ((ImageView)findViewById(2131299790));
    this.rzY = ((TextView)findViewById(2131299791));
    this.jfJ.setOnTouchListener(this.rAi);
    this.jfJ.setOnLongClickListener(this.rAj);
    final int i = getType();
    label420:
    Object localObject2;
    label457:
    final boolean bool1;
    if (4 == i)
    {
      setMMTitle(2131759030);
      if (this.dsC.dataType != 4) {
        break label916;
      }
      this.rzS.setImageResource(2131689581);
      this.jfJ.setText(this.dsC.title);
      localObject2 = this.dsC.GhR;
      if (localObject2 != null) {
        break label947;
      }
      this.rzW.setVisibility(8);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107126);
          com.tencent.mm.plugin.fav.a.m.a(m.a.rsX, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          if ((FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null) && (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).sv(1)))
          {
            AppMethodBeat.o(107126);
            return true;
          }
          FavoriteFileDetailUI.this.finish();
          AppMethodBeat.o(107126);
          return true;
        }
      });
      this.rzQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107127);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      paramBundle = this.dsC.GgY;
      if (!bt.isNullOrNil(paramBundle)) {
        this.pHV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(107128);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId) });
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramBundle);
            paramAnonymousView.putExtra("is_favorite_item", true);
            paramAnonymousView.putExtra("fav_local_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            paramAnonymousView.putExtra("geta8key_scene", 14);
            com.tencent.mm.bs.d.b(FavoriteFileDetailUI.this.cwQ(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107128);
          }
        });
      }
      this.rzR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107129);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id), Long.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_itemStatus) });
          if (!com.tencent.mm.compatible.util.e.abf())
          {
            com.tencent.mm.ui.base.h.l(FavoriteFileDetailUI.this.cwQ(), 2131758934, 2131758845);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107129);
            return;
          }
          if ((FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).isUploadFailed()) || (bt.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).GgR))) {
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
      this.rzV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107130);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      if (this.dBt)
      {
        final boolean bool2 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label1240;
        }
        bool1 = this.rtA.cuQ();
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
                if ((!k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).GhZ == 0)) {}
              }
              else if (!bool2)
              {
                AppMethodBeat.o(107136);
                return false;
              }
              paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(FavoriteFileDetailUI.this.cwQ(), 1, false);
              paramAnonymousMenuItem.KJy = new n.d()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(107131);
                  if (FavoriteFileDetailUI.16.this.rAq)
                  {
                    FavoriteFileDetailUI.k(FavoriteFileDetailUI.this);
                    if ((!k.i(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this))) && (FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).GhZ == 0))
                    {
                      if (FavoriteFileDetailUI.16.this.val$type != 8) {
                        break label222;
                      }
                      paramAnonymous2l.c(0, FavoriteFileDetailUI.this.getString(2131759001));
                      if (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) != null)
                      {
                        FavoriteFileDetailUI.c(FavoriteFileDetailUI.this);
                        if (!FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bKz()) {
                          break label201;
                        }
                        paramAnonymous2l.c(5, FavoriteFileDetailUI.this.getString(2131756770));
                      }
                    }
                  }
                  for (;;)
                  {
                    if (FavoriteFileDetailUI.16.this.rAr)
                    {
                      paramAnonymous2l.c(3, FavoriteFileDetailUI.this.getString(2131758875));
                      paramAnonymous2l.c(2, FavoriteFileDetailUI.this.cwQ().getString(2131755707));
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
                      if ((FavoriteFileDetailUI.16.this.rAr) && (FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).cuR())) {
                        paramAnonymous2l.c(1, FavoriteFileDetailUI.this.getString(2131758951));
                      }
                    }
                  }
                }
              };
              paramAnonymousMenuItem.KJz = new n.e()
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
                      if (!i.fv(paramAnonymous2MenuItem))
                      {
                        ad.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131758999), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                      if (new com.tencent.mm.vfs.e(paramAnonymous2MenuItem).length() > FavoriteFileDetailUI.cwX())
                      {
                        ad.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
                        Toast.makeText(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131759000), 1).show();
                        AppMethodBeat.o(107135);
                        return;
                      }
                    }
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.rzL;
                    paramAnonymous2MenuItem.rsz += 1;
                    FavoriteFileDetailUI.a(FavoriteFileDetailUI.this, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
                    AppMethodBeat.o(107135);
                    return;
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.rzL;
                    paramAnonymous2MenuItem.rsA += 1;
                    Object localObject = com.tencent.mm.ui.base.h.b(FavoriteFileDetailUI.this.cwQ(), FavoriteFileDetailUI.this.getString(2131758906), false, null);
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.cwQ();
                    com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(FavoriteFileDetailUI.this);
                    localObject = new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107132);
                        this.rvc.dismiss();
                        AppMethodBeat.o(107132);
                      }
                    };
                    LinkedList localLinkedList = new LinkedList();
                    localLinkedList.add(Integer.valueOf(localg.field_id));
                    paramAnonymous2MenuItem = new an("", localLinkedList, new l.2(localg, paramAnonymous2MenuItem, (Runnable)localObject));
                    com.tencent.mm.kernel.g.aiU().a(paramAnonymous2MenuItem, 0);
                    AppMethodBeat.o(107135);
                    return;
                    com.tencent.mm.ui.base.h.a(FavoriteFileDetailUI.this.cwQ(), FavoriteFileDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                      {
                        AppMethodBeat.i(107134);
                        paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteFileDetailUI.this.cwQ(), FavoriteFileDetailUI.this.getString(2131755709), false, null);
                        com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId, new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(107133);
                            FavoriteFileDetailUI.this.rzL.rsD = true;
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
                    paramAnonymous2MenuItem = FavoriteFileDetailUI.this.rzL;
                    paramAnonymous2MenuItem.rsC += 1;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                    paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_localId);
                    com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.this.cwQ(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                    AppMethodBeat.o(107135);
                    return;
                    FavoriteFileDetailUI.l(FavoriteFileDetailUI.this);
                    AppMethodBeat.o(107135);
                    return;
                  } while (FavoriteFileDetailUI.c(FavoriteFileDetailUI.this) == null);
                  paramAnonymous2MenuItem = FavoriteFileDetailUI.c(FavoriteFileDetailUI.this);
                  if (!FavoriteFileDetailUI.c(FavoriteFileDetailUI.this).bKz()) {}
                  for (;;)
                  {
                    paramAnonymous2MenuItem.gf(bool);
                    break;
                    bool = false;
                  }
                }
              };
              paramAnonymousMenuItem.cMW();
              AppMethodBeat.o(107136);
              return true;
            }
          });
        }
      }
      this.rAg = HandOffFile.b(this.dsC, this.rtA);
      if (!com.tencent.mm.plugin.fav.a.b.g(this.dsC)) {
        break label1313;
      }
      this.rAg.uDP = 1;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.rAg);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.rAg);
      lC(false);
      if (getType() == 8)
      {
        paramBundle = com.tencent.mm.plugin.fav.a.b.d(this.dsC);
        bool1 = i.fv(paramBundle);
        if (bool1)
        {
          this.rAh = new com.tencent.mm.plugin.fav.ui.b.a(new com.tencent.mm.plugin.fav.ui.b.b((MMActivity)super.getContext()));
          this.rAh.gk(paramBundle, this.dsC.Ghg);
          localObject2 = this.rAh;
          paramBundle = this.dsC.Ghg;
          String str = this.dsC.title;
          localObject1 = com.tencent.mm.plugin.ball.f.d.Wr(paramBundle);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = com.tencent.mm.plugin.ball.f.d.Wr("unknown");
          }
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).nGj.lZt = paramBundle.intValue();
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).nGj.name = str;
          ((com.tencent.mm.plugin.fav.ui.b.a)localObject2).bKC();
          this.rAg.L(this.rAh.nGj);
        }
        ad.i("MicroMsg.FavoriteFileDetailUI", "initFloatBallHelper() ifSupportFB:%s", new Object[] { Boolean.valueOf(bool1) });
      }
      AppMethodBeat.o(107140);
      return;
      if (15 == i)
      {
        setMMTitle(2131759030);
        findViewById(2131306317).setBackgroundResource(2131100017);
        this.jfJ.setVisibility(8);
        break;
      }
      setMMTitle(2131758904);
      break;
      label916:
      this.rzS.setImageResource(((ab)com.tencent.mm.kernel.g.ab(ab.class)).agy(this.dsC.Ghg));
      break label420;
      label947:
      if (bt.isNullOrNil(((ajq)localObject2).hCe))
      {
        ad.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = ((ajq)localObject2).hCh;
        localObject1 = ((ajq)localObject2).hCi;
        if ((!bt.isNullOrNil(paramBundle)) && (!bt.isNullOrNil((String)localObject1)))
        {
          this.rzW.setText(paramBundle);
          this.rzW.setVisibility(0);
          this.rzW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymousView)
            {
              AppMethodBeat.i(107114);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              paramAnonymousView = new Intent();
              localObject = new Bundle();
              ((Bundle)localObject).putString("key_snsad_statextstr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).dHv);
              paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
              paramAnonymousView.putExtra("rawUrl", this.rAk);
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
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(107114);
            }
          });
          break label457;
        }
        this.rzW.setVisibility(8);
        break label457;
      }
      Object localObject1 = getResources().getString(2131763759);
      paramBundle = (Bundle)localObject1;
      if (((ajq)localObject2).Gje / 60 > 0) {
        paramBundle = (String)localObject1 + getResources().getString(2131763761, new Object[] { Integer.valueOf(((ajq)localObject2).Gje / 60) });
      }
      localObject1 = paramBundle;
      if (((ajq)localObject2).Gje % 60 > 0) {
        localObject1 = paramBundle + getResources().getString(2131763762, new Object[] { Integer.valueOf(((ajq)localObject2).Gje % 60) });
      }
      paramBundle = (String)localObject1 + getResources().getString(2131763760);
      this.rzW.setText(paramBundle);
      this.rzW.setVisibility(0);
      this.rzW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107125);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          com.tencent.mm.plugin.fav.a.m.a(m.a.rsV, FavoriteFileDetailUI.b(FavoriteFileDetailUI.this));
          paramAnonymousView = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).GhR;
          localObject = com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this));
          Intent localIntent = new Intent();
          localIntent.putExtra("KFromTimeLine", false);
          localIntent.putExtra("KStremVideoUrl", paramAnonymousView.hCe);
          localIntent.putExtra("StreamWording", paramAnonymousView.hCh);
          localIntent.putExtra("StremWebUrl", paramAnonymousView.hCi);
          localIntent.putExtra("KBlockFav", true);
          localIntent.putExtra("KThumUrl", paramAnonymousView.hCj);
          localIntent.putExtra("KThumbPath", (String)localObject);
          localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KMediaVideoTime", paramAnonymousView.Gje);
          localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title);
          localIntent.putExtra("KSta_StremVideoAduxInfo", paramAnonymousView.hCk);
          localIntent.putExtra("KSta_StremVideoPublishId", paramAnonymousView.hCl);
          localIntent.putExtra("KSta_SourceType", 1);
          localIntent.putExtra("KSta_Scene", m.b.rtf.value);
          localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_fromUser);
          localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(FavoriteFileDetailUI.this).field_id);
          localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).dHv);
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqx, 0) > 0)
          {
            com.tencent.mm.bs.d.b(FavoriteFileDetailUI.this, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
            ad.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107125);
            return;
            com.tencent.mm.bs.d.b(FavoriteFileDetailUI.this, "sns", ".ui.VideoAdPlayerUI", localIntent);
          }
        }
      });
      break label457;
      label1240:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.n.g.acA().getValue("SIGHTCannotTransmitForFav");
        if ((this.rtA.cuQ()) && (bt.aRe(paramBundle) == 0))
        {
          bool1 = true;
          break label584;
        }
        bool1 = false;
        break label584;
      }
      if ((this.rtA.cuR()) || (this.rtA.cuQ()))
      {
        bool1 = true;
        break label584;
      }
      bool1 = false;
      break label584;
      label1313:
      if (bt.isNullOrNil(this.dsC.GgR)) {
        this.rAg.uDP = 3;
      } else {
        this.rAg.uDP = 2;
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
    if (this.oHt != null)
    {
      this.oHt.setVideoCallback(null);
      this.oHt.stop();
      this.oHt.onDetach();
    }
    if (this.rAh != null) {
      this.rAh.onDestroy();
    }
    if (this.rAg != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.rAg);
    }
    super.onDestroy();
    AppMethodBeat.o(107151);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107142);
    ad.i("MicroMsg.FavoriteFileDetailUI", "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.rAh != null) && (this.rAh.sv(2)))
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
    if (this.oHt != null) {
      this.oHt.stop();
    }
    if (this.rAh != null) {
      this.rAh.bgC();
    }
    AppMethodBeat.o(107153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107152);
    super.onResume();
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    if (this.oHt != null) {
      this.oHt.start();
    }
    if (this.rAh != null) {
      this.rAh.bgB();
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