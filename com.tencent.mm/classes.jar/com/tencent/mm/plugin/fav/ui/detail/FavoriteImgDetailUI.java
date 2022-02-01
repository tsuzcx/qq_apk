package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class FavoriteImgDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.p
{
  private int aYQ;
  private View.OnClickListener cEO;
  private ScanCodeSheetItemLogic kxs;
  private com.tencent.mm.plugin.fav.a.g qcq;
  private com.tencent.mm.sdk.b.c qej;
  private View.OnLongClickListener qhH;
  private LinearLayout qhU;
  private HashMap<String, a> qhV;
  private Bitmap qhW;
  private boolean qhX;
  
  public FavoriteImgDetailUI()
  {
    AppMethodBeat.i(107190);
    this.aYQ = 0;
    this.qhV = new HashMap();
    this.qhX = true;
    this.cEO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107184);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_detail_info_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId);
        localIntent.putExtra("key_detail_data_id", ((afy)paramAnonymousView.getTag()).dkb);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavImgGalleryUI", localIntent);
        paramAnonymousView = FavoriteImgDetailUI.this.qhk;
        paramAnonymousView.pZQ += 1;
        AppMethodBeat.o(107184);
      }
    };
    this.qhH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107185);
        paramAnonymousView = (afy)paramAnonymousView.getTag();
        paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(paramAnonymousView.dkb);
        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, paramAnonymousView);
        if (!paramAnonymousView.qij) {
          FavoriteImgDetailUI.b(paramAnonymousView);
        }
        AppMethodBeat.o(107185);
        return true;
      }
    };
    this.qej = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(107190);
  }
  
  private void a(final a parama)
  {
    AppMethodBeat.i(107197);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107183);
        Bitmap localBitmap2 = o.a(parama.djJ, FavoriteImgDetailUI.b(FavoriteImgDetailUI.this), false);
        final Bitmap localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          ad.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
          localBitmap1 = FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, parama.djJ);
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107181);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.9.this.qhZ, localBitmap1);
            AppMethodBeat.o(107181);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(107182);
            String str = super.toString() + "|renderView";
            AppMethodBeat.o(107182);
            return str;
          }
        });
        AppMethodBeat.o(107183);
      }
    });
    AppMethodBeat.o(107197);
  }
  
  public static void a(String paramString1, final String paramString2, Context paramContext, final String paramString3)
  {
    AppMethodBeat.i(164100);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
      AppMethodBeat.o(164100);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, paramString1, new p.a()
    {
      public final void bv(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(186919);
        Toast.makeText(this.val$context, this.val$context.getString(2131757969, new Object[] { paramAnonymousString2 }), 1).show();
        com.tencent.e.h.Iye.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186918);
            String str = com.tencent.mm.vfs.i.aEN(paramAnonymousString2);
            v localv = v.hUC;
            v.bx(str, FavoriteImgDetailUI.3.this.qep);
            AppMethodBeat.o(186918);
          }
        });
        AppMethodBeat.o(186919);
      }
      
      public final void bw(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(186920);
        Toast.makeText(this.val$context, paramString2, 1).show();
        AppMethodBeat.o(186920);
      }
    });
    AppMethodBeat.o(164100);
  }
  
  private void cjG()
  {
    AppMethodBeat.i(107195);
    if (aj.getResources() != null) {}
    for (DisplayMetrics localDisplayMetrics = aj.getResources().getDisplayMetrics();; localDisplayMetrics = getResources().getDisplayMetrics())
    {
      this.aYQ = (localDisplayMetrics.widthPixels - getResources().getDimensionPixelOffset(2131165353) * 2);
      this.aYQ = Math.max(this.aYQ, 0);
      ad.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[] { Integer.valueOf(this.aYQ) });
      AppMethodBeat.o(107195);
      return;
    }
  }
  
  private Bitmap n(afy paramafy)
  {
    boolean bool = true;
    AppMethodBeat.i(107199);
    paramafy = o.a(paramafy, this.qcq);
    if (paramafy != null) {}
    for (;;)
    {
      ad.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", new Object[] { Boolean.valueOf(bool) });
      if (paramafy == null) {
        break;
      }
      AppMethodBeat.o(107199);
      return paramafy;
      bool = false;
    }
    if (this.qhW == null) {
      this.qhW = com.tencent.mm.compatible.e.a.decodeResource(getResources(), 2131690142);
    }
    paramafy = this.qhW;
    AppMethodBeat.o(107199);
    return paramafy;
  }
  
  protected final MMLoadScrollView cjv()
  {
    AppMethodBeat.i(107191);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131304376);
    AppMethodBeat.o(107191);
    return localMMLoadScrollView;
  }
  
  public final void e(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(107200);
    if ((paramc == null) || (!paramc.isFinished()))
    {
      AppMethodBeat.o(107200);
      return;
    }
    ad.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[] { paramc.field_dataId });
    paramc = (a)this.qhV.get(paramc.field_dataId);
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(107200);
  }
  
  public int getLayoutId()
  {
    return 2131493988;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107201);
    if (1 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(107201);
        return;
      }
      new k();
      if (k.v(this.qcq))
      {
        com.tencent.mm.ui.base.h.cf(getContext(), getString(2131755010));
        AppMethodBeat.o(107201);
        return;
      }
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      String str2 = paramIntent.getStringExtra("custom_send_text");
      ad.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[] { str1 });
      final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      com.tencent.mm.plugin.fav.ui.l.a(getContext(), str1, str2, this.qcq, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164097);
          localp.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.n(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(2131758834));
          AppMethodBeat.o(164097);
        }
      });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107201);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(107196);
    super.onConfigurationChanged(paramConfiguration);
    cjG();
    paramConfiguration = this.qhV.entrySet().iterator();
    while (paramConfiguration.hasNext()) {
      a((a)((Map.Entry)paramConfiguration.next()).getValue());
    }
    AppMethodBeat.o(107196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107192);
    com.tencent.mm.pluginsdk.g.o(this);
    super.onCreate(paramBundle);
    cjG();
    this.qhU = ((LinearLayout)findViewById(2131299802));
    final long l = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.qcq = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(l);
    if (this.qcq == null)
    {
      finish();
      AppMethodBeat.o(107192);
      return;
    }
    H(this.qcq);
    paramBundle = this.qcq.field_favProto.mVb.iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      afy localafy = (afy)paramBundle.next();
      ad.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[] { Integer.valueOf(i), localafy.dkb });
      a locala = new a((byte)0);
      locala.djJ = localafy;
      ImageView localImageView = new ImageView(getContext());
      int j = getResources().getDimensionPixelSize(2131165568);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = j;
      }
      this.qhU.addView(localImageView, localLayoutParams);
      localImageView.setTag(localafy);
      j /= 2;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(j, j, j, j);
      localImageView.setMinimumWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 50));
      localImageView.setMinimumHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 50));
      localImageView.setImageResource(2131690142);
      localImageView.setOnClickListener(this.cEO);
      localImageView.setOnLongClickListener(this.qhH);
      localImageView.setOnTouchListener(new FavoriteImgDetailUI.4(this));
      locala.djK = localImageView;
      this.qhV.put(localafy.dkb, locala);
      a(locala);
      if (localafy.Dhh != 0) {
        this.qhX = false;
      }
      i += 1;
    }
    setMMTitle(getString(2131758856));
    a.a(this, this.qcq);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107170);
        FavoriteImgDetailUI.this.finish();
        AppMethodBeat.o(107170);
        return true;
      }
    });
    addIconOptionMenu(0, 2131764451, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107179);
        paramAnonymousMenuItem = new e(FavoriteImgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(107175);
            if (FavoriteImgDetailUI.a(FavoriteImgDetailUI.this)) {
              paramAnonymous2l.c(2, FavoriteImgDetailUI.this.getString(2131759001));
            }
            paramAnonymous2l.c(3, FavoriteImgDetailUI.this.getString(2131758988));
            paramAnonymous2l.c(0, FavoriteImgDetailUI.this.getString(2131758875));
            paramAnonymous2l.c(1, FavoriteImgDetailUI.this.getContext().getString(2131755707));
            AppMethodBeat.o(107175);
          }
        };
        paramAnonymousMenuItem.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(107178);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(107178);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
              paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId);
              com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.qhk;
              paramAnonymous2MenuItem.pZU += 1;
              AppMethodBeat.o(107178);
              return;
              com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107177);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(2131755709), false, null);
                  com.tencent.mm.plugin.fav.a.b.a(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107176);
                      FavoriteImgDetailUI.this.qhk.pZV = true;
                      paramAnonymous3DialogInterface.dismiss();
                      ad.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId) });
                      FavoriteImgDetailUI.this.finish();
                      AppMethodBeat.o(107176);
                    }
                  });
                  AppMethodBeat.o(107177);
                }
              }, null);
              AppMethodBeat.o(107178);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId);
              d.c(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
              com.tencent.mm.plugin.fav.a.h.i(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, 1, 0);
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.qhk;
              paramAnonymous2MenuItem.pZR += 1;
              AppMethodBeat.o(107178);
              return;
              j.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.7.this.qib, FavoriteImgDetailUI.this.qhk);
            }
          }
        };
        paramAnonymousMenuItem.csG();
        AppMethodBeat.o(107179);
        return true;
      }
    });
    com.tencent.mm.pluginsdk.g.p(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    com.tencent.mm.sdk.b.a.ESL.c(this.qej);
    this.kxs = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
    {
      public final void YE(String paramAnonymousString)
      {
        AppMethodBeat.i(107180);
        Object localObject = null;
        Iterator localIterator = FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).values().iterator();
        if (localIterator.hasNext())
        {
          FavoriteImgDetailUI.a locala = (FavoriteImgDetailUI.a)localIterator.next();
          if (!paramAnonymousString.equals(locala.qik)) {
            break label102;
          }
          localObject = locala;
        }
        label102:
        for (;;)
        {
          break;
          if (localObject == null)
          {
            AppMethodBeat.o(107180);
            return;
          }
          if ((localObject.qii != null) && (localObject.qii.isShowing())) {
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, localObject);
          }
          AppMethodBeat.o(107180);
          return;
        }
      }
    });
    AppMethodBeat.o(107192);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107194);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(this);
    com.tencent.mm.sdk.b.a.ESL.d(this.qej);
    super.onDestroy();
    AppMethodBeat.o(107194);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107193);
    super.onResume();
    Iterator localIterator = this.qhV.entrySet().iterator();
    while (localIterator.hasNext()) {
      a((a)((Map.Entry)localIterator.next()).getValue());
    }
    AppMethodBeat.o(107193);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    int deB;
    int deC;
    afy djJ;
    ImageView djK;
    e qii;
    boolean qij;
    String qik;
    boolean qil;
    boolean qim;
    
    private a()
    {
      AppMethodBeat.i(107189);
      this.qii = new e(FavoriteImgDetailUI.this.getContext(), 1, false);
      this.qij = false;
      this.qik = null;
      this.deB = 0;
      this.deC = 0;
      this.qil = false;
      AppMethodBeat.o(107189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI
 * JD-Core Version:    0.7.0.1
 */