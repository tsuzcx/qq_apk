package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI
  extends BaseFavDetailReportUI
  implements p, k.a
{
  private boolean cBz;
  private long cpM;
  private aca cuL;
  private ak faV;
  private TextView gzk;
  private TextView ivt;
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.c.a jVd;
  private com.tencent.mm.pluginsdk.ui.tools.e kvG;
  private n.d lNZ;
  private boolean mAa;
  private boolean mAb;
  private View.OnTouchListener mAc;
  private View.OnLongClickListener mAd;
  private com.tencent.mm.plugin.fav.a.g muk;
  private k mxM;
  private Button mzL;
  private Button mzM;
  private Button mzN;
  private MMImageView mzO;
  private TextView mzP;
  private View mzQ;
  private View mzR;
  private TextView mzS;
  private ImageView mzT;
  private TextView mzU;
  private boolean mzV;
  private boolean mzW;
  private String mzX;
  private String mzY;
  private boolean mzZ;
  private ProgressBar progressBar;
  
  public FavoriteFileDetailUI()
  {
    AppMethodBeat.i(74345);
    this.kvG = null;
    this.mxM = new k();
    this.mzV = false;
    this.mzW = false;
    this.cBz = true;
    this.mzZ = false;
    this.mAa = false;
    this.mAb = false;
    this.jVd = null;
    this.lNZ = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(74344);
        ClipboardManager localClipboardManager = (ClipboardManager)ah.getContext().getSystemService("clipboard");
        if (bo.isNullOrNil(FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)) {}
        for (paramAnonymousMenuItem = FavoriteFileDetailUI.this.getString(2131302024);; paramAnonymousMenuItem = FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).title)
        {
          localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramAnonymousMenuItem));
          com.tencent.mm.ui.base.h.bO(FavoriteFileDetailUI.this, FavoriteFileDetailUI.this.getString(2131296896));
          AppMethodBeat.o(74344);
          return;
        }
      }
    };
    this.mAc = new FavoriteFileDetailUI.2(this);
    this.mAd = new FavoriteFileDetailUI.3(this);
    AppMethodBeat.o(74345);
  }
  
  private void b(float paramFloat, String paramString)
  {
    AppMethodBeat.i(74361);
    this.faV.post(new FavoriteFileDetailUI.8(this, paramFloat, paramString));
    AppMethodBeat.o(74361);
  }
  
  private void boV()
  {
    AppMethodBeat.i(74363);
    if (this.mzZ)
    {
      AppMethodBeat.o(74363);
      return;
    }
    Object localObject = this.mzH;
    ((h.a)localObject).mte += 1;
    this.mzZ = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.cpM);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.b(this.cuL));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.c(this.cuL));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.cuL.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.cuL.cGU);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
    AppMethodBeat.o(74363);
  }
  
  private void bxX()
  {
    AppMethodBeat.i(74346);
    this.mzY = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.muk.field_favProto.wVc.iterator();
    while (localIterator.hasNext())
    {
      aca localaca = (aca)localIterator.next();
      if (localaca.mBq.equals(this.mzY)) {
        this.cuL = localaca;
      }
    }
    if (this.cuL == null) {
      this.cuL = com.tencent.mm.plugin.fav.a.b.c(this.muk);
    }
    AppMethodBeat.o(74346);
  }
  
  private void bxY()
  {
    AppMethodBeat.i(74351);
    this.mzO.setVisibility(8);
    this.gzk.setVisibility(8);
    this.mzN.setVisibility(8);
    this.mzL.setVisibility(8);
    this.mzM.setVisibility(8);
    this.mzQ.setVisibility(8);
    this.ivt.setVisibility(8);
    this.mzT.setVisibility(0);
    this.mzU.setVisibility(0);
    if (this.cuL.dataType == 4)
    {
      this.ivt.setGravity(17);
      this.ivt.setText(2131299769);
      AppMethodBeat.o(74351);
      return;
    }
    this.ivt.setGravity(17);
    this.ivt.setText(2131299768);
    if (this.cuL.wTK == 2)
    {
      this.mzU.setText(2131299689);
      AppMethodBeat.o(74351);
      return;
    }
    this.mzU.setText(2131299690);
    AppMethodBeat.o(74351);
  }
  
  private void bxZ()
  {
    AppMethodBeat.i(74352);
    this.mzN.setVisibility(8);
    this.mzL.setVisibility(8);
    this.mzM.setVisibility(8);
    this.ivt.setVisibility(8);
    this.mzQ.setVisibility(0);
    c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(this.cuL.mBq);
    int j;
    int i;
    int k;
    if (localc != null)
    {
      j = (int)localc.getProgress();
      i = localc.field_offset;
      k = localc.field_totalLen;
    }
    while ((this.muk.bwo()) && (bo.isNullOrNil(this.cuL.wSC)))
    {
      b(j, getString(2131299851, new Object[] { com.tencent.mm.plugin.fav.a.b.aJ(i), com.tencent.mm.plugin.fav.a.b.aJ(k) }));
      AppMethodBeat.o(74352);
      return;
      k = (int)this.cuL.wSX;
      i = 0;
      j = 0;
    }
    b(j, getString(2131299700, new Object[] { com.tencent.mm.plugin.fav.a.b.aJ(i), com.tencent.mm.plugin.fav.a.b.aJ(k) }));
    AppMethodBeat.o(74352);
  }
  
  private void bya()
  {
    AppMethodBeat.i(74353);
    this.mzQ.setVisibility(8);
    this.mzM.setVisibility(8);
    if (bo.isNullOrNil(this.cuL.wSJ))
    {
      this.mzL.setVisibility(8);
      this.mzN.setVisibility(0);
      localObject = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(this.cuL.mBq);
      if ((localObject == null) || (((c)localObject).field_offset <= 0)) {
        break label150;
      }
      localObject = this.mzN;
      if (!this.muk.bwp()) {
        break label143;
      }
    }
    label143:
    for (int i = 2131299750;; i = 2131299749)
    {
      ((Button)localObject).setText(i);
      this.ivt.setVisibility(8);
      AppMethodBeat.o(74353);
      return;
      this.mzL.setVisibility(0);
      break;
    }
    label150:
    Object localObject = this.mzN;
    if (this.muk.bwp()) {}
    for (i = 2131299751;; i = 2131299746)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private boolean byb()
  {
    AppMethodBeat.i(74354);
    if ((com.tencent.mm.plugin.fav.a.b.f(this.cuL)) && (com.tencent.mm.plugin.fav.a.b.g(this.cuL)))
    {
      AppMethodBeat.o(74354);
      return true;
    }
    AppMethodBeat.o(74354);
    return false;
  }
  
  private void byc()
  {
    AppMethodBeat.i(74355);
    if ((getType() == 15) && (this.cuL.wTC != null) && (!bo.isNullOrNil(this.cuL.wTC.fiO)) && (!bo.isNullOrNil(this.cuL.wTC.fiS)))
    {
      this.mAa = true;
      this.mzO.setVisibility(8);
      this.mzQ.setVisibility(8);
      this.mzN.setVisibility(8);
      this.mzL.setVisibility(8);
      this.mzM.setVisibility(8);
      this.ivt.setVisibility(8);
      String str = com.tencent.mm.plugin.fav.a.b.b(this.cuL);
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Mk() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131824108);
      this.kvG = com.tencent.mm.pluginsdk.ui.tools.q.ga(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.kvG, 0, localLayoutParams);
      this.kvG.setVideoCallback(new FavoriteFileDetailUI.4(this));
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Mk() + " initView :" + str);
      if (str != null)
      {
        this.kvG.stop();
        this.kvG.setVideoPath(str);
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.Mk() + " initView");
      com.tencent.mm.aw.a.aiu();
      com.tencent.mm.plugin.report.service.h.qsU.e(11444, new Object[] { Integer.valueOf(4) });
    }
    if ((getType() == 15) || (getType() == 4)) {
      if (!this.mAa)
      {
        this.mzQ.setVisibility(8);
        this.mzN.setVisibility(8);
        this.mzL.setVisibility(8);
        this.mzM.setVisibility(0);
        this.mzM.setText(2131299748);
        this.ivt.setVisibility(8);
        boV();
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RO().ac(new FavoriteFileDetailUI.6(this));
      AppMethodBeat.o(74355);
      return;
      if (!byb()) {
        break;
      }
      this.mzQ.setVisibility(8);
      this.mzN.setVisibility(8);
      this.mzL.setVisibility(0);
      this.mzM.setVisibility(8);
      this.ivt.setVisibility(8);
      this.mzL.setOnClickListener(new FavoriteFileDetailUI.5(this));
    }
    this.mzQ.setVisibility(8);
    this.mzN.setVisibility(8);
    if (bo.isNullOrNil(this.cuL.wSJ)) {
      this.mzL.setVisibility(8);
    }
    for (;;)
    {
      this.mzM.setVisibility(0);
      this.mzH.mtd = true;
      this.ivt.setVisibility(0);
      break;
      this.mzL.setVisibility(0);
    }
  }
  
  private boolean byd()
  {
    AppMethodBeat.i(74364);
    c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(this.cuL.mBq);
    if (localc == null)
    {
      AppMethodBeat.o(74364);
      return false;
    }
    if (localc.field_status == 1)
    {
      AppMethodBeat.o(74364);
      return true;
    }
    if (this.cuL.dataType == 8)
    {
      AppMethodBeat.o(74364);
      return false;
    }
    if (this.mAb)
    {
      AppMethodBeat.o(74364);
      return false;
    }
    if ((localc.field_status == 4) && (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(this.cuL.mBq).field_extFlag != 0))
    {
      com.tencent.mm.plugin.fav.a.b.a(this.muk, this.cuL, true);
      this.mAb = true;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.mAb) });
    boolean bool = this.mAb;
    AppMethodBeat.o(74364);
    return bool;
  }
  
  private int getType()
  {
    AppMethodBeat.i(74348);
    if (this.cuL == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
      AppMethodBeat.o(74348);
      return 8;
    }
    if (this.cuL.dataType == 0)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.muk.field_type) });
      if (4 == this.muk.field_type)
      {
        AppMethodBeat.o(74348);
        return 4;
      }
      if (16 == this.muk.field_type)
      {
        if ((this.cuL != null) && (this.cuL.wTC != null))
        {
          if (!bo.isNullOrNil(this.cuL.wTC.fiO))
          {
            AppMethodBeat.o(74348);
            return 15;
          }
          if (!bo.isNullOrNil(this.cuL.wTC.fiS))
          {
            AppMethodBeat.o(74348);
            return 15;
          }
        }
        AppMethodBeat.o(74348);
        return 4;
      }
      AppMethodBeat.o(74348);
      return 8;
    }
    if (this.cuL.dataType == 15)
    {
      if ((this.cuL != null) && (this.cuL.wTC != null))
      {
        if (!bo.isNullOrNil(this.cuL.wTC.fiO))
        {
          AppMethodBeat.o(74348);
          return 15;
        }
        if (!bo.isNullOrNil(this.cuL.wTC.fiS))
        {
          AppMethodBeat.o(74348);
          return 15;
        }
      }
      AppMethodBeat.o(74348);
      return 4;
    }
    int i = this.cuL.dataType;
    AppMethodBeat.o(74348);
    return i;
  }
  
  private void hC(boolean paramBoolean)
  {
    AppMethodBeat.i(74349);
    boolean bool = com.tencent.mm.plugin.fav.a.b.f(this.cuL);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.muk.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.b(this.cuL) });
    if (this.cuL.wTK != 0)
    {
      bxY();
      AppMethodBeat.o(74349);
      return;
    }
    if ((this.muk.isDone()) || (bool) || (!bo.isNullOrNil(this.cuL.wSC)))
    {
      if (bool)
      {
        byc();
        if (getIntent().getBooleanExtra("key_detail_open_way", false))
        {
          acs localacs = new acs();
          localacs.cIT = 2;
          ((y)com.tencent.mm.kernel.g.E(y.class)).a(getContext(), this.muk, localacs);
          AppMethodBeat.o(74349);
        }
      }
      else
      {
        if (bo.isNullOrNil(this.cuL.wSC))
        {
          bxY();
          AppMethodBeat.o(74349);
          return;
        }
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
        bya();
      }
      AppMethodBeat.o(74349);
      return;
    }
    if (this.muk.bwq())
    {
      if (bo.isNullOrNil(this.cuL.wSC))
      {
        bxY();
        if (paramBoolean)
        {
          int i = getType();
          if ((4 == i) || (15 == i)) {}
          for (i = 2131299804;; i = 2131299791)
          {
            com.tencent.mm.ui.base.h.bO(getContext(), getString(i));
            AppMethodBeat.o(74349);
            return;
          }
        }
      }
      else
      {
        bya();
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.h.bO(getContext(), getString(2131299004));
          AppMethodBeat.o(74349);
        }
      }
    }
    else if (this.muk.bwp())
    {
      bya();
      if (paramBoolean)
      {
        com.tencent.mm.ui.base.h.bO(getContext(), getString(2131299679));
        AppMethodBeat.o(74349);
      }
    }
    else
    {
      if ((this.muk.isDownloading()) || (this.muk.bwo()))
      {
        bxZ();
        AppMethodBeat.o(74349);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
      bya();
    }
    AppMethodBeat.o(74349);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(74362);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.muk.field_localId) });
    paramString = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.muk.field_localId);
    if ((paramString == null) && (!this.mzW))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(74362);
      return;
    }
    if (!this.mzW) {
      this.muk = paramString;
    }
    bxX();
    if (byd())
    {
      AppMethodBeat.o(74362);
      return;
    }
    this.faV.post(new FavoriteFileDetailUI.9(this));
    AppMethodBeat.o(74362);
  }
  
  public final void d(c paramc)
  {
    AppMethodBeat.i(74360);
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(74360);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.cuL.mBq, paramc.field_dataId });
    if (paramc.field_dataId.equals(this.cuL.mBq))
    {
      if ((this.muk.bwo()) && (bo.isNullOrNil(this.cuL.wSC)))
      {
        b(paramc.getProgress(), getString(2131299851, new Object[] { com.tencent.mm.plugin.fav.a.b.aJ(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.aJ(paramc.field_totalLen) }));
        AppMethodBeat.o(74360);
        return;
      }
      b(paramc.getProgress(), getString(2131299700, new Object[] { com.tencent.mm.plugin.fav.a.b.aJ(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.aJ(paramc.field_totalLen) }));
      if ((this.mzW) && (com.tencent.mm.vfs.e.cN(paramc.field_path)))
      {
        this.muk.field_itemStatus = 10;
        a("", null);
      }
      AppMethodBeat.o(74360);
      return;
    }
    AppMethodBeat.o(74360);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969569;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74359);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.fav.a.ab.class)).b(this, paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(74359);
      return;
    }
    if (paramInt1 == 1)
    {
      Object localObject1;
      if (paramIntent == null)
      {
        localObject1 = null;
        if (paramIntent != null) {
          break label145;
        }
      }
      Object localObject2;
      label145:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131299734), false, null);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new FavoriteFileDetailUI.7(this, (Dialog)localObject2);
        paramInt2 = getType();
        if (!bo.isNullOrNil((String)localObject1)) {
          break label156;
        }
        AppMethodBeat.o(74359);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label156:
      Iterator localIterator = bo.P(((String)localObject1).split(",")).iterator();
      label261:
      label305:
      label330:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((paramInt2 == 4) || (paramInt2 == 15))
        {
          i.a(getContext(), str, this.cuL, (Runnable)localObject2);
          boolean bool = t.lA(str);
          if (bool)
          {
            localObject1 = m.c.mtN;
            label239:
            com.tencent.mm.plugin.fav.a.g localg = this.muk;
            m.d locald = m.d.mtR;
            if (!bool) {
              break label305;
            }
            paramInt1 = n.nv(str);
            com.tencent.mm.plugin.fav.a.m.a((m.c)localObject1, localg, locald, paramInt1);
          }
        }
        for (;;)
        {
          if (bo.isNullOrNil(paramIntent)) {
            break label330;
          }
          com.tencent.mm.plugin.messenger.a.g.bPJ().K(str, paramIntent, t.oF(str));
          break;
          localObject1 = m.c.mtM;
          break label239;
          paramInt1 = 0;
          break label261;
          i.a(getContext(), str, this.muk, this.cuL, (Runnable)localObject2);
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131299674));
    }
    AppMethodBeat.o(74359);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(74347);
    super.onCreate(paramBundle);
    this.faV = new ak();
    this.cpM = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.mzW = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.cBz = getIntent().getBooleanExtra("show_share", true);
    this.mzX = getIntent().getStringExtra("fav_note_xml");
    this.muk = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.cpM);
    if ((this.mzW) && (!bo.isNullOrNil(this.mzX))) {
      this.muk = com.tencent.mm.plugin.fav.a.b.ND(this.mzX);
    }
    if (this.muk == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      AppMethodBeat.o(74347);
      return;
    }
    F(this.muk);
    com.tencent.mm.plugin.fav.a.m.w(this.muk);
    bxX();
    this.mzL = ((Button)findViewById(2131824113));
    this.mzM = ((Button)findViewById(2131824114));
    this.mzN = ((Button)findViewById(2131822726));
    this.mzO = ((MMImageView)findViewById(2131821253));
    this.gzk = ((TextView)findViewById(2131821254));
    this.ivt = ((TextView)findViewById(2131823916));
    this.mzR = findViewById(2131821564);
    this.mzQ = findViewById(2131821562);
    this.progressBar = ((ProgressBar)findViewById(2131821563));
    this.mzP = ((TextView)findViewById(2131824112));
    this.mzS = ((TextView)findViewById(2131827797));
    this.mzT = ((ImageView)findViewById(2131824110));
    this.mzU = ((TextView)findViewById(2131824111));
    this.gzk.setOnTouchListener(this.mAc);
    this.gzk.setOnLongClickListener(this.mAd);
    int i = getType();
    label422:
    acd localacd;
    label459:
    boolean bool3;
    boolean bool1;
    if (4 == i)
    {
      setMMTitle(2131299853);
      if (this.cuL.dataType != 4) {
        break label678;
      }
      this.mzO.setImageResource(2131230826);
      this.gzk.setText(this.cuL.title);
      localacd = this.cuL.wTC;
      if (localacd != null) {
        break label708;
      }
      this.mzS.setVisibility(8);
      setBackBtn(new FavoriteFileDetailUI.11(this));
      this.mzM.setOnClickListener(new FavoriteFileDetailUI.12(this));
      paramBundle = this.cuL.wSJ;
      if (!bo.isNullOrNil(paramBundle)) {
        this.mzL.setOnClickListener(new FavoriteFileDetailUI.13(this, paramBundle));
      }
      this.mzN.setOnClickListener(new FavoriteFileDetailUI.14(this));
      this.mzR.setOnClickListener(new FavoriteFileDetailUI.15(this));
      if (this.cBz)
      {
        bool3 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label1001;
        }
        bool1 = this.muk.bwl();
      }
    }
    for (;;)
    {
      if ((bool1) || (bool3)) {
        addIconOptionMenu(0, 2131304317, 2130839668, new FavoriteFileDetailUI.16(this, bool1, bool3, i));
      }
      hC(false);
      AppMethodBeat.o(74347);
      return;
      if (15 == i)
      {
        setMMTitle(2131299853);
        findViewById(2131824108).setBackgroundResource(2131689763);
        this.gzk.setVisibility(8);
        break;
      }
      setMMTitle(2131299732);
      break;
      label678:
      this.mzO.setImageResource(((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.fav.a.ab.class)).NS(this.cuL.wSR));
      break label422;
      label708:
      if (bo.isNullOrNil(localacd.fiO))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = localacd.fiR;
        localObject = localacd.fiS;
        if ((!bo.isNullOrNil(paramBundle)) && (!bo.isNullOrNil((String)localObject)))
        {
          this.mzS.setText(paramBundle);
          this.mzS.setVisibility(0);
          this.mzS.setOnClickListener(new FavoriteFileDetailUI.1(this, (String)localObject));
          break label459;
        }
        this.mzS.setVisibility(8);
        break label459;
      }
      Object localObject = getResources().getString(2131303756);
      paramBundle = (Bundle)localObject;
      if (localacd.wUJ / 60 > 0) {
        paramBundle = (String)localObject + getResources().getString(2131303758, new Object[] { Integer.valueOf(localacd.wUJ / 60) });
      }
      localObject = paramBundle;
      if (localacd.wUJ % 60 > 0) {
        localObject = paramBundle + getResources().getString(2131303759, new Object[] { Integer.valueOf(localacd.wUJ % 60) });
      }
      paramBundle = (String)localObject + getResources().getString(2131303757);
      this.mzS.setText(paramBundle);
      this.mzS.setVisibility(0);
      this.mzS.setOnClickListener(new FavoriteFileDetailUI.10(this));
      break label459;
      label1001:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.m.g.Nq().getValue("SIGHTCannotTransmitForFav");
        if ((this.muk.bwl()) && (bo.apV(paramBundle) == 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      else
      {
        bool1 = bool2;
        if (!this.muk.bwm())
        {
          bool1 = bool2;
          if (!this.muk.bwl()) {
            bool1 = false;
          }
        }
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(74350);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, getString(2131296895));
    AppMethodBeat.o(74350);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74356);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    if (this.kvG != null)
    {
      this.kvG.setVideoCallback(null);
      this.kvG.stop();
      this.kvG.onDetach();
    }
    super.onDestroy();
    AppMethodBeat.o(74356);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74358);
    super.onPause();
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().remove(this);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(this);
    if (this.kvG != null) {
      this.kvG.stop();
    }
    AppMethodBeat.o(74358);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74357);
    super.onResume();
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().add(this);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(this);
    if (this.kvG != null) {
      this.kvG.start();
    }
    AppMethodBeat.o(74357);
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