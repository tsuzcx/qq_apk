package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.av.a;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.n.b;
import com.tencent.mm.plugin.fav.ui.n.d;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteFileDetailUI
  extends BaseFavDetailReportUI
  implements p, j.a
{
  private long bIr;
  private xv bNt;
  private boolean bTT = true;
  private ah dPi;
  private TextView fhD;
  private ProgressBar frw;
  private TextView gSy;
  private f iuC = null;
  private com.tencent.mm.plugin.fav.a.g jZN;
  private k kdb = new k();
  private Button kfc;
  private Button kfd;
  private Button kfe;
  private MMImageView kff;
  private TextView kfg;
  private View kfh;
  private View kfi;
  private TextView kfj;
  private ImageView kfk;
  private TextView kfl;
  private boolean kfm = false;
  private boolean kfn = false;
  private String kfo;
  private String kfp;
  private boolean kfq = false;
  private boolean kfr = false;
  private boolean kfs = false;
  
  private void aKM()
  {
    if (this.kfq) {
      return;
    }
    Object localObject = this.keY;
    ((h.a)localObject).jYL += 1;
    this.kfq = true;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_detail_info_id", this.bIr);
    ((Intent)localObject).putExtra("key_detail_fav_path", com.tencent.mm.plugin.fav.a.b.b(this.bNt));
    ((Intent)localObject).putExtra("key_detail_fav_thumb_path", com.tencent.mm.plugin.fav.a.b.c(this.bNt));
    ((Intent)localObject).putExtra("key_detail_fav_video_duration", this.bNt.duration);
    ((Intent)localObject).putExtra("key_detail_statExtStr", this.bNt.bYN);
    com.tencent.mm.plugin.fav.a.b.a(this, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject);
    finish();
  }
  
  private void aRH()
  {
    this.kfp = getIntent().getStringExtra("key_detail_data_id");
    Iterator localIterator = this.jZN.field_favProto.sXc.iterator();
    while (localIterator.hasNext())
    {
      xv localxv = (xv)localIterator.next();
      if (localxv.kgC.equals(this.kfp)) {
        this.bNt = localxv;
      }
    }
    if (this.bNt == null) {
      this.bNt = com.tencent.mm.plugin.fav.a.b.c(this.jZN);
    }
  }
  
  private void aRI()
  {
    this.kff.setVisibility(8);
    this.fhD.setVisibility(8);
    this.kfe.setVisibility(8);
    this.kfc.setVisibility(8);
    this.kfd.setVisibility(8);
    this.kfh.setVisibility(8);
    this.gSy.setVisibility(8);
    this.kfk.setVisibility(0);
    this.kfl.setVisibility(0);
    if (this.bNt.aYU == 4)
    {
      this.gSy.setGravity(17);
      this.gSy.setText(n.i.favorite_out_of_date_video);
      return;
    }
    this.gSy.setGravity(17);
    this.gSy.setText(n.i.favorite_out_of_date_file);
    if (this.bNt.sVO == 2)
    {
      this.kfl.setText(n.i.favorite_detail_illegal_big_file);
      return;
    }
    this.kfl.setText(n.i.favorite_detail_illegal_expired_file);
  }
  
  private void aRJ()
  {
    this.kfe.setVisibility(8);
    this.kfc.setVisibility(8);
    this.kfd.setVisibility(8);
    this.gSy.setVisibility(8);
    this.kfh.setVisibility(0);
    c localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(this.bNt.kgC);
    int k;
    int j;
    int i;
    if (localc != null)
    {
      k = (int)localc.getProgress();
      j = localc.field_offset;
      i = localc.field_totalLen;
    }
    while ((this.jZN.aPZ()) && (bk.bl(this.bNt.sUG)))
    {
      b(k, getString(n.i.favorite_uploading, new Object[] { com.tencent.mm.plugin.fav.a.b.ar(j), com.tencent.mm.plugin.fav.a.b.ar(i) }));
      return;
      i = (int)this.bNt.sVb;
      j = 0;
      k = 0;
    }
    b(k, getString(n.i.favorite_downloading, new Object[] { com.tencent.mm.plugin.fav.a.b.ar(j), com.tencent.mm.plugin.fav.a.b.ar(i) }));
  }
  
  private void aRK()
  {
    this.kfh.setVisibility(8);
    this.kfd.setVisibility(8);
    if (bk.bl(this.bNt.sUN))
    {
      this.kfc.setVisibility(8);
      this.kfe.setVisibility(0);
      localObject = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(this.bNt.kgC);
      if ((localObject == null) || (((c)localObject).field_offset <= 0)) {
        break label138;
      }
      localObject = this.kfe;
      if (!this.jZN.aQa()) {
        break label131;
      }
    }
    label131:
    for (int i = n.i.favorite_item_restart_upload;; i = n.i.favorite_item_restart_download)
    {
      ((Button)localObject).setText(i);
      this.gSy.setVisibility(8);
      return;
      this.kfc.setVisibility(0);
      break;
    }
    label138:
    Object localObject = this.kfe;
    if (this.jZN.aQa()) {}
    for (i = n.i.favorite_item_upload;; i = n.i.favorite_item_download)
    {
      ((Button)localObject).setText(i);
      break;
    }
  }
  
  private void b(float paramFloat, String paramString)
  {
    this.dPi.post(new FavoriteFileDetailUI.5(this, paramFloat, paramString));
  }
  
  private void fY(boolean paramBoolean)
  {
    boolean bool = com.tencent.mm.plugin.fav.a.b.f(this.bNt);
    y.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[] { Integer.valueOf(this.jZN.field_itemStatus), Boolean.valueOf(bool), com.tencent.mm.plugin.fav.a.b.b(this.bNt) });
    if (this.bNt.sVO != 0) {
      aRI();
    }
    label625:
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jZN.isDone()) || (bool) || (!bk.bl(this.bNt.sUG)))
          {
            if (bool)
            {
              if ((getType() == 15) && (this.bNt.sVG != null) && (!bk.bl(this.bNt.sVG.dSP)) && (!bk.bl(this.bNt.sVG.dST)))
              {
                this.kfr = true;
                this.kff.setVisibility(8);
                this.kfh.setVisibility(8);
                this.kfe.setVisibility(8);
                this.kfc.setVisibility(8);
                this.kfd.setVisibility(8);
                this.gSy.setVisibility(8);
                String str = com.tencent.mm.plugin.fav.a.b.b(this.bNt);
                y.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.zH() + " initView: fullpath:" + str);
                ViewGroup localViewGroup = (ViewGroup)findViewById(n.e.video_container);
                this.iuC = o.fb(this.mController.uMN);
                RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
                localLayoutParams.addRule(13);
                localViewGroup.addView((View)this.iuC, 0, localLayoutParams);
                this.iuC.setVideoCallback(new FavoriteFileDetailUI.14(this));
                y.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.zH() + " initView :" + str);
                if (str != null)
                {
                  this.iuC.stop();
                  this.iuC.setVideoPath(str);
                }
                y.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.zH() + " initView");
                a.Ps();
                com.tencent.mm.plugin.report.service.h.nFQ.f(11444, new Object[] { Integer.valueOf(4) });
              }
              if ((getType() == 15) || (getType() == 4))
              {
                if (!this.kfr)
                {
                  this.kfh.setVisibility(8);
                  this.kfe.setVisibility(8);
                  this.kfc.setVisibility(8);
                  this.kfd.setVisibility(0);
                  this.kfd.setText(n.i.favorite_item_preview);
                  this.gSy.setVisibility(8);
                  aKM();
                }
                com.tencent.mm.kernel.g.DS().O(new FavoriteFileDetailUI.3(this));
                return;
              }
              if ((com.tencent.mm.plugin.fav.a.b.f(this.bNt)) && (com.tencent.mm.plugin.fav.a.b.g(this.bNt))) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label625;
                }
                this.kfh.setVisibility(8);
                this.kfe.setVisibility(8);
                this.kfc.setVisibility(0);
                this.kfd.setVisibility(8);
                this.gSy.setVisibility(8);
                this.kfc.setOnClickListener(new FavoriteFileDetailUI.2(this));
                break;
              }
              this.kfh.setVisibility(8);
              this.kfe.setVisibility(8);
              if (bk.bl(this.bNt.sUN)) {
                this.kfc.setVisibility(8);
              }
              for (;;)
              {
                this.kfd.setVisibility(0);
                this.keY.jYK = true;
                this.gSy.setVisibility(0);
                break;
                this.kfc.setVisibility(0);
              }
            }
            if (bk.bl(this.bNt.sUG))
            {
              aRI();
              return;
            }
            y.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
            aRK();
            return;
          }
          if (!this.jZN.aQb()) {
            break label837;
          }
          if (!bk.bl(this.bNt.sUG)) {
            break;
          }
          aRI();
        } while (!paramBoolean);
        int i = getType();
        if ((4 == i) || (15 == i)) {}
        for (i = n.i.favorite_record_video_error;; i = n.i.favorite_record_file_error)
        {
          com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(i));
          return;
        }
        aRK();
      } while (!paramBoolean);
      com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(n.i.download_fail));
      return;
      if (!this.jZN.aQa()) {
        break;
      }
      aRK();
    } while (!paramBoolean);
    label837:
    com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(n.i.fav_upload_fail));
    return;
    if ((this.jZN.isDownloading()) || (this.jZN.aPZ()))
    {
      aRJ();
      return;
    }
    y.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
    aRK();
  }
  
  private int getType()
  {
    if (this.bNt == null) {
      y.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
    }
    do
    {
      return 8;
      if (this.bNt.aYU != 0) {
        break;
      }
      y.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[] { Integer.valueOf(this.jZN.field_type) });
      if (4 == this.jZN.field_type) {
        return 4;
      }
    } while (16 != this.jZN.field_type);
    if ((this.bNt != null) && (this.bNt.sVG != null))
    {
      if (!bk.bl(this.bNt.sVG.dSP)) {
        return 15;
      }
      if (!bk.bl(this.bNt.sVG.dST)) {
        return 15;
      }
    }
    return 4;
    if (this.bNt.aYU == 15)
    {
      if ((this.bNt != null) && (this.bNt.sVG != null))
      {
        if (!bk.bl(this.bNt.sVG.dSP)) {
          return 15;
        }
        if (!bk.bl(this.bNt.sVG.dST)) {
          return 15;
        }
      }
      return 4;
    }
    return this.bNt.aYU;
  }
  
  public final void a(String paramString, l paraml)
  {
    y.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.jZN.field_localId) });
    paramString = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.jZN.field_localId);
    if ((paramString == null) && (!this.kfn))
    {
      y.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
      finish();
    }
    for (;;)
    {
      return;
      if (!this.kfn) {
        this.jZN = paramString;
      }
      aRH();
      paramString = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(this.bNt.kgC);
      boolean bool;
      if (paramString == null) {
        bool = false;
      }
      while (!bool)
      {
        this.dPi.post(new FavoriteFileDetailUI.6(this));
        return;
        if (paramString.field_status == 1)
        {
          bool = true;
        }
        else if (this.bNt.aYU == 8)
        {
          bool = false;
        }
        else if (this.kfs)
        {
          bool = false;
        }
        else
        {
          if ((paramString.field_status == 4) && (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(this.bNt.kgC).field_extFlag != 0))
          {
            com.tencent.mm.plugin.fav.a.b.a(this.jZN, this.bNt, true);
            this.kfs = true;
          }
          y.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.kfs) });
          bool = this.kfs;
        }
      }
    }
  }
  
  public final void d(c paramc)
  {
    if ((paramc == null) || (paramc.field_dataId == null)) {
      y.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
    }
    do
    {
      do
      {
        return;
        y.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[] { this.bNt.kgC, paramc.field_dataId });
      } while (!paramc.field_dataId.equals(this.bNt.kgC));
      if ((this.jZN.aPZ()) && (bk.bl(this.bNt.sUG)))
      {
        b(paramc.getProgress(), getString(n.i.favorite_uploading, new Object[] { com.tencent.mm.plugin.fav.a.b.ar(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.ar(paramc.field_totalLen) }));
        return;
      }
      b(paramc.getProgress(), getString(n.i.favorite_downloading, new Object[] { com.tencent.mm.plugin.fav.a.b.ar(paramc.field_offset), com.tencent.mm.plugin.fav.a.b.ar(paramc.field_totalLen) }));
    } while ((!this.kfn) || (!com.tencent.mm.vfs.e.bK(paramc.field_path)));
    this.jZN.field_itemStatus = 10;
    a("", null);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return n.f.favorite_download_detail_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((ab)com.tencent.mm.kernel.g.r(ab.class)).a(this, paramInt1, paramInt2, paramIntent, n.i.no_match_application_msg, n.i.no_match_application_title);
    if (paramInt2 != -1) {}
    Object localObject1;
    label54:
    Object localObject2;
    do
    {
      do
      {
        return;
      } while (paramInt1 != 1);
      if (paramIntent != null) {
        break;
      }
      localObject1 = null;
      if (paramIntent != null) {
        break label279;
      }
      paramIntent = null;
      localObject2 = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(n.i.favorite_forward_tips), false, null);
      y.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
      localObject2 = new FavoriteFileDetailUI.4(this, (Dialog)localObject2);
      paramInt2 = getType();
    } while (bk.bl((String)localObject1));
    Iterator localIterator = bk.G(((String)localObject1).split(",")).iterator();
    label141:
    label279:
    label298:
    label326:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label328;
      }
      String str = (String)localIterator.next();
      if ((paramInt2 == 4) || (paramInt2 == 15))
      {
        i.a(this.mController.uMN, str, this.bNt, (Runnable)localObject2);
        boolean bool = com.tencent.mm.model.s.fn(str);
        if (bool)
        {
          localObject1 = m.c.jZv;
          label209:
          com.tencent.mm.plugin.fav.a.g localg = this.jZN;
          m.d locald = m.d.jZz;
          if (!bool) {
            break label298;
          }
          paramInt1 = com.tencent.mm.model.m.gM(str);
          label231:
          com.tencent.mm.plugin.fav.a.m.a((m.c)localObject1, localg, locald, paramInt1);
        }
      }
      for (;;)
      {
        if (bk.bl(paramIntent)) {
          break label326;
        }
        com.tencent.mm.plugin.messenger.a.g.bhI().D(str, paramIntent, com.tencent.mm.model.s.hW(str));
        break label141;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label54;
        localObject1 = m.c.jZu;
        break label209;
        paramInt1 = 0;
        break label231;
        i.a(this.mController.uMN, str, this.jZN, this.bNt, (Runnable)localObject2);
      }
    }
    label328:
    com.tencent.mm.ui.widget.snackbar.b.h(this, getString(n.i.fav_finish_sent));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onCreate(paramBundle);
    this.dPi = new ah();
    this.bIr = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.kfn = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    this.bTT = getIntent().getBooleanExtra("show_share", true);
    this.kfo = getIntent().getStringExtra("fav_note_xml");
    this.jZN = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.bIr);
    if ((this.kfn) && (!bk.bl(this.kfo))) {
      this.jZN = com.tencent.mm.plugin.fav.a.b.CB(this.kfo);
    }
    if (this.jZN == null)
    {
      y.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
      finish();
      return;
    }
    E(this.jZN);
    com.tencent.mm.plugin.fav.a.m.w(this.jZN);
    aRH();
    this.kfc = ((Button)findViewById(n.e.preview_btn));
    this.kfd = ((Button)findViewById(n.e.open_btn));
    this.kfe = ((Button)findViewById(n.e.download_btn));
    this.kff = ((MMImageView)findViewById(n.e.icon_iv));
    this.fhD = ((TextView)findViewById(n.e.name_tv));
    this.gSy = ((TextView)findViewById(n.e.tips_tv));
    this.kfi = findViewById(n.e.download_stop_btn);
    this.kfh = findViewById(n.e.download_progress_area);
    this.frw = ((ProgressBar)findViewById(n.e.download_pb));
    this.kfg = ((TextView)findViewById(n.e.download_progress_tips));
    this.kfj = ((TextView)findViewById(n.e.show_ad_sight));
    this.kfk = ((ImageView)findViewById(n.e.fav_file_illegal_image));
    this.kfl = ((TextView)findViewById(n.e.fav_file_illegal_tv));
    int i = getType();
    label388:
    xy localxy;
    label425:
    boolean bool3;
    boolean bool1;
    if (4 == i)
    {
      setMMTitle(n.i.favorite_video);
      if (this.bNt.aYU != 4) {
        break label638;
      }
      this.kff.setImageResource(n.h.app_attach_file_icon_video);
      this.fhD.setText(this.bNt.title);
      localxy = this.bNt.sVG;
      if (localxy != null) {
        break label668;
      }
      this.kfj.setVisibility(8);
      setBackBtn(new FavoriteFileDetailUI.8(this));
      this.kfd.setOnClickListener(new FavoriteFileDetailUI.9(this));
      paramBundle = this.bNt.sUN;
      if (!bk.bl(paramBundle)) {
        this.kfc.setOnClickListener(new FavoriteFileDetailUI.10(this, paramBundle));
      }
      this.kfe.setOnClickListener(new FavoriteFileDetailUI.11(this));
      this.kfi.setOnClickListener(new FavoriteFileDetailUI.12(this));
      if (this.bTT)
      {
        bool3 = getIntent().getBooleanExtra("key_detail_can_delete", true);
        i = getType();
        if (i != 8) {
          break label961;
        }
        bool1 = this.jZN.aPX();
      }
    }
    for (;;)
    {
      if ((bool1) || (bool3)) {
        addIconOptionMenu(0, n.i.top_item_desc_more, n.d.mm_title_btn_menu, new FavoriteFileDetailUI.13(this, bool1, bool3, i));
      }
      fY(false);
      return;
      if (15 == i)
      {
        setMMTitle(n.i.favorite_video);
        findViewById(n.e.video_container).setBackgroundResource(n.b.black);
        this.fhD.setVisibility(8);
        break;
      }
      setMMTitle(n.i.favorite_file);
      break;
      label638:
      this.kff.setImageResource(((ab)com.tencent.mm.kernel.g.r(ab.class)).CQ(this.bNt.sUV));
      break label388;
      label668:
      if (bk.bl(localxy.dSP))
      {
        y.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
        paramBundle = localxy.dSS;
        localObject = localxy.dST;
        if ((!bk.bl(paramBundle)) && (!bk.bl((String)localObject)))
        {
          this.kfj.setText(paramBundle);
          this.kfj.setVisibility(0);
          this.kfj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              paramAnonymousView = new Intent();
              Bundle localBundle = new Bundle();
              localBundle.putString("key_snsad_statextstr", FavoriteFileDetailUI.a(FavoriteFileDetailUI.this).bYN);
              paramAnonymousView.putExtra("jsapiargs", localBundle);
              paramAnonymousView.putExtra("rawUrl", this.kft);
              paramAnonymousView.putExtra("useJs", true);
              new ah(Looper.getMainLooper()).post(new FavoriteFileDetailUI.1.1(this, paramAnonymousView));
            }
          });
          break label425;
        }
        this.kfj.setVisibility(8);
        break label425;
      }
      Object localObject = getResources().getString(n.i.sns_ad_sight_full);
      paramBundle = (Bundle)localObject;
      if (localxy.sWK / 60 > 0) {
        paramBundle = (String)localObject + getResources().getString(n.i.sns_ad_sight_full_m, new Object[] { Integer.valueOf(localxy.sWK / 60) });
      }
      localObject = paramBundle;
      if (localxy.sWK % 60 > 0) {
        localObject = paramBundle + getResources().getString(n.i.sns_ad_sight_full_s, new Object[] { Integer.valueOf(localxy.sWK % 60) });
      }
      paramBundle = (String)localObject + getResources().getString(n.i.sns_ad_sight_full_end);
      this.kfj.setText(paramBundle);
      this.kfj.setVisibility(0);
      this.kfj.setOnClickListener(new FavoriteFileDetailUI.7(this));
      break label425;
      label961:
      if (i == 15)
      {
        paramBundle = com.tencent.mm.m.g.AA().getValue("SIGHTCannotTransmitForFav");
        if ((this.jZN.aPX()) && (bk.ZR(paramBundle) == 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      else
      {
        bool1 = bool2;
        if (!this.jZN.aPY())
        {
          bool1 = bool2;
          if (!this.jZN.aPX()) {
            bool1 = false;
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    setResult(0, getIntent().putExtra("key_activity_browse_time", czu()));
    if (this.iuC != null)
    {
      this.iuC.setVideoCallback(null);
      this.iuC.stop();
      this.iuC.onDetach();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().d(this);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b(this);
    if (this.iuC != null) {
      this.iuC.stop();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().c(this);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(this);
    if (this.iuC != null) {
      this.iuC.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI
 * JD-Core Version:    0.7.0.1
 */