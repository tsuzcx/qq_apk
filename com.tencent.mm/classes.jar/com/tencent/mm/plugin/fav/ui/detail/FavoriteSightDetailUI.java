package com.tencent.mm.plugin.fav.ui.detail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.e;

public class FavoriteSightDetailUI
  extends BaseFavDetailReportUI
  implements p, k.a
{
  private aca cuL;
  private View mAI;
  private ImageView mAJ;
  private MMPinProgressBtn mAK;
  private VideoPlayerTextureView mAL;
  private ImageView mAM;
  private long mAN;
  private boolean mAO;
  private boolean mAP;
  private Runnable mAQ;
  private boolean mAR;
  private boolean mAb;
  private k mxM;
  private com.tencent.mm.plugin.fav.a.g mxX;
  private boolean mzV;
  
  public FavoriteSightDetailUI()
  {
    AppMethodBeat.i(74423);
    this.mAO = true;
    this.mzV = false;
    this.mAP = false;
    this.mAb = false;
    this.mxM = new k();
    this.mAQ = new FavoriteSightDetailUI.5(this);
    this.mAR = false;
    AppMethodBeat.o(74423);
  }
  
  private void byf()
  {
    AppMethodBeat.i(74433);
    String str = com.tencent.mm.plugin.fav.a.b.b(this.cuL);
    if (!e.cN(str))
    {
      AppMethodBeat.o(74433);
      return;
    }
    this.mAL.stop();
    this.mAL.setMute(true);
    this.mAL.setVideoPath(str);
    AppMethodBeat.o(74433);
  }
  
  @SuppressLint({"ResourceType"})
  private void hD(boolean paramBoolean)
  {
    AppMethodBeat.i(74429);
    if (this.mxX.isDone())
    {
      if (com.tencent.mm.plugin.fav.a.b.f(this.cuL))
      {
        this.mAJ.setVisibility(8);
        this.mAK.setVisibility(8);
        byf();
        AppMethodBeat.o(74429);
        return;
      }
      if (bo.isNullOrNil(this.cuL.wSC)) {
        this.mAJ.setImageResource(2131231980);
      }
    }
    for (;;)
    {
      this.mAJ.setVisibility(0);
      this.mAK.setVisibility(8);
      this.mAM.setVisibility(0);
      AppMethodBeat.o(74429);
      return;
      ab.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      this.mAJ.setImageResource(2131231980);
      continue;
      if (this.mxX.bwq())
      {
        if (bo.isNullOrNil(this.cuL.wSC))
        {
          this.mAJ.setImageResource(2131231980);
          if (!paramBoolean) {}
        }
        else
        {
          this.mAJ.setImageResource(2131231980);
          if (paramBoolean) {
            h.bO(getContext(), getString(2131299004));
          }
        }
      }
      else if (this.mxX.bwp())
      {
        this.mAJ.setImageResource(2131231980);
        if (paramBoolean) {
          h.bO(getContext(), getString(2131299679));
        }
      }
      else
      {
        if ((this.mxX.isDownloading()) || (this.mxX.bwo()))
        {
          this.mAJ.setVisibility(8);
          this.mAK.setVisibility(0);
          c localc = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(this.cuL.mBq);
          if (localc != null) {
            this.mAK.setProgress((int)localc.getProgress());
          }
          for (;;)
          {
            this.mAM.setVisibility(0);
            AppMethodBeat.o(74429);
            return;
            this.mAK.setProgress(0);
          }
        }
        ab.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        this.mAJ.setImageResource(2131231980);
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(74430);
    ab.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.mxX.field_localId) });
    paramString = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.mxX.field_localId);
    if (paramString == null)
    {
      ab.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(74430);
      return;
    }
    this.mxX = paramString;
    this.cuL = com.tencent.mm.plugin.fav.a.b.c(paramString);
    paramString = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(this.cuL.mBq);
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(74430);
      return;
      if (this.mAb)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().NP(this.cuL.mBq).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.mxX, this.cuL, true);
          this.mAb = true;
        }
        ab.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.mAb) });
        bool = this.mAb;
      }
    }
    al.ae(this.mAQ);
    al.p(this.mAQ, 500L);
    AppMethodBeat.o(74430);
  }
  
  protected final MMLoadScrollView bxU()
  {
    AppMethodBeat.i(74424);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131824115);
    AppMethodBeat.o(74424);
    return localMMLoadScrollView;
  }
  
  public final void d(c paramc)
  {
    AppMethodBeat.i(74431);
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      ab.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(74431);
      return;
    }
    ab.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[] { this.cuL.mBq, paramc.field_dataId, Integer.valueOf(paramc.field_offset), Integer.valueOf(paramc.field_totalLen), Integer.valueOf(paramc.field_status), Integer.valueOf(paramc.field_type) });
    if (paramc.field_offset > paramc.field_totalLen)
    {
      ab.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
      if (1 != paramc.field_type) {
        break label229;
      }
    }
    label229:
    for (paramc.field_status = 2;; paramc.field_status = 4)
    {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(paramc, new String[0]);
      if (paramc.field_type == 0) {
        com.tencent.mm.plugin.fav.a.b.a(paramc);
      }
      if (paramc.field_type == 1) {
        com.tencent.mm.plugin.fav.a.b.b(paramc);
      }
      if (paramc.field_dataId.equals(this.cuL.mBq))
      {
        int i = (int)paramc.getProgress();
        this.mAK.post(new FavoriteSightDetailUI.6(this, i));
      }
      AppMethodBeat.o(74431);
      return;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969573;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74432);
    if ((paramInt1 == 1) && (-1 == paramInt2))
    {
      String str;
      label29:
      Object localObject;
      label87:
      m.d locald;
      if (paramIntent == null)
      {
        str = null;
        if (paramIntent != null) {
          break label148;
        }
        paramIntent = null;
        localObject = new FavoriteSightDetailUI.7(this, h.b(getContext(), getString(2131299734), false, null));
        i.a(getContext(), str, paramIntent, this.mxX, (Runnable)localObject);
        boolean bool = t.lA(str);
        if (!bool) {
          break label159;
        }
        paramIntent = m.c.mtN;
        localObject = this.mxX;
        locald = m.d.mtQ;
        if (!bool) {
          break label166;
        }
      }
      label148:
      label159:
      label166:
      for (paramInt1 = n.nv(str);; paramInt1 = 0)
      {
        com.tencent.mm.plugin.fav.a.m.a(paramIntent, (com.tencent.mm.plugin.fav.a.g)localObject, locald, paramInt1);
        com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131299674));
        AppMethodBeat.o(74432);
        return;
        str = paramIntent.getStringExtra("Select_Conv_User");
        break;
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label29;
        paramIntent = m.c.mtM;
        break label87;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74432);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74425);
    f.m(this);
    super.onCreate(paramBundle);
    this.mAN = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.mxX = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.mAN);
    if (this.mxX == null)
    {
      ab.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.mAN) });
      finish();
      AppMethodBeat.o(74425);
      return;
    }
    F(this.mxX);
    com.tencent.mm.plugin.fav.a.m.w(this.mxX);
    a.a(this, this.mxX);
    this.cuL = com.tencent.mm.plugin.fav.a.b.c(this.mxX);
    this.mAJ = ((ImageView)findViewById(2131820996));
    this.mAK = ((MMPinProgressBtn)findViewById(2131822192));
    this.mAI = findViewById(2131824117);
    this.mAL = ((VideoPlayerTextureView)findViewById(2131821436));
    this.mAM = ((ImageView)findViewById(2131822189));
    this.mAI.setOnClickListener(new FavoriteSightDetailUI.1(this));
    this.mAL.setVideoCallback(new FavoriteSightDetailUI.2(this));
    setMMTitle(getString(2131299687));
    setBackBtn(new FavoriteSightDetailUI.3(this));
    addIconOptionMenu(0, 2131304317, 2130839668, new FavoriteSightDetailUI.4(this));
    if (!e.cN(com.tencent.mm.plugin.fav.a.b.c(this.cuL))) {
      if (!bo.isNullOrNil(this.cuL.fgM)) {
        com.tencent.mm.plugin.fav.a.b.a(this.mxX, this.cuL);
      }
    }
    do
    {
      hD(false);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().add(this);
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(this);
      f.n(this);
      AppMethodBeat.o(74425);
      return;
      paramBundle = l.a(this.cuL, this.mxX);
    } while (paramBundle == null);
    int i = paramBundle.getWidth();
    int j = paramBundle.getHeight();
    DisplayMetrics localDisplayMetrics;
    float f;
    ViewGroup.LayoutParams localLayoutParams;
    if (!this.mAR)
    {
      this.mAR = true;
      localDisplayMetrics = this.mAI.getResources().getDisplayMetrics();
      f = localDisplayMetrics.density;
      localLayoutParams = this.mAI.getLayoutParams();
      if (localLayoutParams != null) {
        break label462;
      }
      ab.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
    }
    for (;;)
    {
      this.mAM.setImageBitmap(paramBundle);
      this.mAM.setVisibility(0);
      break;
      label462:
      localLayoutParams.width = (localDisplayMetrics.widthPixels - (int)(f * 36.0F + 0.5F));
      localLayoutParams.height = (j * localLayoutParams.width / i);
      this.mAI.setLayoutParams(localLayoutParams);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74426);
    if (this.mAL != null)
    {
      this.mAL.setVideoCallback(null);
      this.mAL.stop();
    }
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().remove(this);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(this);
    super.onDestroy();
    AppMethodBeat.o(74426);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74428);
    if (this.mAL != null) {
      this.mAL.stop();
    }
    super.onPause();
    AppMethodBeat.o(74428);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74427);
    super.onResume();
    if (this.mAL != null)
    {
      if (this.mAO) {
        break label40;
      }
      byf();
    }
    for (;;)
    {
      this.mAO = false;
      AppMethodBeat.o(74427);
      return;
      label40:
      if (!this.mAL.isPlaying()) {
        this.mAL.start();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI
 * JD-Core Version:    0.7.0.1
 */