package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.b.d;
import com.tencent.mm.vending.g.d.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class FavoriteImgDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.p
{
  private int aDy;
  private View.OnClickListener bTw;
  private View.OnLongClickListener mAd;
  private LinearLayout mAq;
  private com.tencent.mm.plugin.fav.a.g mAr;
  private HashMap<String, a> mAs;
  private Bitmap mAt;
  private boolean mAu;
  private com.tencent.mm.sdk.b.c mwt;
  
  public FavoriteImgDetailUI()
  {
    AppMethodBeat.i(74392);
    this.aDy = 0;
    this.mAs = new HashMap();
    this.mAu = true;
    this.bTw = new FavoriteImgDetailUI.8(this);
    this.mAd = new FavoriteImgDetailUI.9(this);
    this.mwt = new FavoriteImgDetailUI.4(this);
    AppMethodBeat.o(74392);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(74399);
    com.tencent.mm.kernel.g.RO().ac(new FavoriteImgDetailUI.7(this, parama));
    AppMethodBeat.o(74399);
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(74400);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
      AppMethodBeat.o(74400);
      return;
    }
    if (!com.tencent.mm.platformtools.q.a(paramString1, paramContext, 2131298889)) {
      Toast.makeText(paramContext, paramString2, 1).show();
    }
    AppMethodBeat.o(74400);
  }
  
  private void bye()
  {
    AppMethodBeat.i(74397);
    if (ah.getResources() != null) {}
    for (DisplayMetrics localDisplayMetrics = ah.getResources().getDisplayMetrics();; localDisplayMetrics = getResources().getDisplayMetrics())
    {
      this.aDy = (localDisplayMetrics.widthPixels - getResources().getDimensionPixelOffset(2131427648) * 2);
      this.aDy = Math.max(this.aDy, 0);
      ab.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[] { Integer.valueOf(this.aDy) });
      AppMethodBeat.o(74397);
      return;
    }
  }
  
  private Bitmap l(aca paramaca)
  {
    boolean bool = true;
    AppMethodBeat.i(74401);
    paramaca = l.a(paramaca, this.mAr);
    if (paramaca != null) {}
    for (;;)
    {
      ab.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", new Object[] { Boolean.valueOf(bool) });
      if (paramaca == null) {
        break;
      }
      AppMethodBeat.o(74401);
      return paramaca;
      bool = false;
    }
    if (this.mAt == null) {
      this.mAt = com.tencent.mm.compatible.g.a.decodeResource(getResources(), 2131231298);
    }
    paramaca = this.mAt;
    AppMethodBeat.o(74401);
    return paramaca;
  }
  
  protected final MMLoadScrollView bxU()
  {
    AppMethodBeat.i(74393);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131824115);
    AppMethodBeat.o(74393);
    return localMMLoadScrollView;
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(74402);
    if ((paramc == null) || (!paramc.isFinished()))
    {
      AppMethodBeat.o(74402);
      return;
    }
    ab.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[] { paramc.field_dataId });
    paramc = (a)this.mAs.get(paramc.field_dataId);
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(74402);
  }
  
  public int getLayoutId()
  {
    return 2130969570;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74403);
    if (1 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(74403);
        return;
      }
      new k();
      if (k.u(this.mAr))
      {
        h.bO(getContext(), getString(2131296330));
        AppMethodBeat.o(74403);
        return;
      }
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      String str2 = paramIntent.getStringExtra("custom_send_text");
      ab.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[] { str1 });
      com.tencent.mm.ui.base.p localp = h.b(getContext(), getString(2131299734), false, null);
      i.a(getContext(), str1, str2, this.mAr, new FavoriteImgDetailUI.3(this, localp));
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74403);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(74398);
    super.onConfigurationChanged(paramConfiguration);
    bye();
    paramConfiguration = this.mAs.entrySet().iterator();
    while (paramConfiguration.hasNext()) {
      a((a)((Map.Entry)paramConfiguration.next()).getValue());
    }
    AppMethodBeat.o(74398);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74394);
    f.m(this);
    super.onCreate(paramBundle);
    bye();
    this.mAq = ((LinearLayout)findViewById(2131824116));
    long l = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.mAr = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(l);
    if (this.mAr == null)
    {
      finish();
      AppMethodBeat.o(74394);
      return;
    }
    F(this.mAr);
    paramBundle = this.mAr.field_favProto.wVc.iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      aca localaca = (aca)paramBundle.next();
      ab.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[] { Integer.valueOf(i), localaca.mBq });
      a locala = new a((byte)0);
      locala.cuL = localaca;
      ImageView localImageView = new ImageView(getContext());
      int j = getResources().getDimensionPixelSize(2131427854);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = j;
      }
      this.mAq.addView(localImageView, localLayoutParams);
      localImageView.setTag(localaca);
      j /= 2;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(j, j, j, j);
      localImageView.setMinimumWidth(com.tencent.mm.cb.a.fromDPToPix(getContext(), 50));
      localImageView.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 50));
      localImageView.setImageResource(2131231298);
      localImageView.setOnClickListener(this.bTw);
      localImageView.setOnLongClickListener(this.mAd);
      localImageView.setOnTouchListener(new FavoriteImgDetailUI.2(this));
      locala.cuM = localImageView;
      this.mAs.put(localaca.mBq, locala);
      a(locala);
      if (localaca.wTK != 0) {
        this.mAu = false;
      }
      i += 1;
    }
    setMMTitle(getString(2131299687));
    a.a(this, this.mAr);
    setBackBtn(new FavoriteImgDetailUI.1(this));
    addIconOptionMenu(0, 2131304317, 2131230740, new FavoriteImgDetailUI.6(this, l));
    f.n(this);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.mwt);
    AppMethodBeat.o(74394);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74396);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(this);
    com.tencent.mm.sdk.b.a.ymk.d(this.mwt);
    super.onDestroy();
    AppMethodBeat.o(74396);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74395);
    super.onResume();
    Iterator localIterator = this.mAs.entrySet().iterator();
    while (localIterator.hasNext()) {
      a((a)((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(74395);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    int cpE;
    int cpF;
    aca cuL;
    ImageView cuM;
    d mAF;
    boolean mAG;
    String mAH;
    String mwB;
    String mwC;
    
    private a()
    {
      AppMethodBeat.i(74391);
      this.mAF = new d(FavoriteImgDetailUI.this.getContext(), 1, false);
      this.mAG = false;
      this.mAH = null;
      this.cpE = 0;
      this.cpF = 0;
      AppMethodBeat.o(74391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI
 * JD-Core Version:    0.7.0.1
 */