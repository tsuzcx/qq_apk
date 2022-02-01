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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private int bjX;
  private View.OnClickListener cNE;
  private ScanCodeSheetItemLogic lAg;
  private com.tencent.mm.plugin.fav.a.g rDk;
  private com.tencent.mm.sdk.b.c rFa;
  private LinearLayout rIH;
  private HashMap<String, a> rII;
  private Bitmap rIJ;
  private boolean rIK;
  private View.OnLongClickListener rIu;
  
  public FavoriteImgDetailUI()
  {
    AppMethodBeat.i(107190);
    this.bjX = 0;
    this.rII = new HashMap();
    this.rIK = true;
    this.cNE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107184);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_detail_info_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId);
        ((Intent)localObject).putExtra("key_detail_data_id", ((ajx)paramAnonymousView.getTag()).dua);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject);
        paramAnonymousView = FavoriteImgDetailUI.this.rHW;
        paramAnonymousView.rAL += 1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107184);
      }
    };
    this.rIu = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        paramAnonymousView = (ajx)paramAnonymousView.getTag();
        paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(paramAnonymousView.dua);
        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, paramAnonymousView);
        if (!paramAnonymousView.rIW) {
          FavoriteImgDetailUI.b(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107185);
        return true;
      }
    };
    this.rFa = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(107190);
  }
  
  private void a(final a parama)
  {
    AppMethodBeat.i(107197);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107183);
        Bitmap localBitmap2 = com.tencent.mm.plugin.fav.ui.o.a(parama.dtI, FavoriteImgDetailUI.b(FavoriteImgDetailUI.this), false);
        final Bitmap localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          ae.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
          localBitmap1 = FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, parama.dtI);
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107181);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.9.this.rIM, localBitmap1);
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
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
      AppMethodBeat.o(164100);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, paramString1, new p.a()
    {
      public final void bF(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(191072);
        Toast.makeText(this.val$context, this.val$context.getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.aSY(paramAnonymousString2) }), 1).show();
        com.tencent.e.h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191071);
            String str = com.tencent.mm.vfs.o.aRh(paramAnonymousString2);
            v localv = v.iQD;
            v.bH(str, FavoriteImgDetailUI.3.this.rFg);
            AppMethodBeat.o(191071);
          }
        });
        AppMethodBeat.o(191072);
      }
      
      public final void bG(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(191073);
        Toast.makeText(this.val$context, paramString2, 1).show();
        AppMethodBeat.o(191073);
      }
    });
    AppMethodBeat.o(164100);
  }
  
  private void cyz()
  {
    AppMethodBeat.i(107195);
    if (ak.getResources() != null) {}
    for (DisplayMetrics localDisplayMetrics = ak.getResources().getDisplayMetrics();; localDisplayMetrics = getResources().getDisplayMetrics())
    {
      this.bjX = (localDisplayMetrics.widthPixels - getResources().getDimensionPixelOffset(2131165353) * 2);
      this.bjX = Math.max(this.bjX, 0);
      ae.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[] { Integer.valueOf(this.bjX) });
      AppMethodBeat.o(107195);
      return;
    }
  }
  
  private Bitmap n(ajx paramajx)
  {
    boolean bool = true;
    AppMethodBeat.i(107199);
    paramajx = com.tencent.mm.plugin.fav.ui.o.a(paramajx, this.rDk);
    if (paramajx != null) {}
    for (;;)
    {
      ae.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", new Object[] { Boolean.valueOf(bool) });
      if (paramajx == null) {
        break;
      }
      AppMethodBeat.o(107199);
      return paramajx;
      bool = false;
    }
    if (this.rIJ == null) {
      this.rIJ = com.tencent.mm.compatible.e.a.decodeResource(getResources(), 2131690142);
    }
    paramajx = this.rIJ;
    AppMethodBeat.o(107199);
    return paramajx;
  }
  
  protected final MMLoadScrollView cyn()
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
    ae.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[] { paramc.field_dataId });
    paramc = (a)this.rII.get(paramc.field_dataId);
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
      if (k.v(this.rDk))
      {
        com.tencent.mm.ui.base.h.cm(getContext(), getString(2131755010));
        AppMethodBeat.o(107201);
        return;
      }
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      String str2 = paramIntent.getStringExtra("custom_send_text");
      ae.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[] { str1 });
      final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      com.tencent.mm.plugin.fav.ui.l.a(getContext(), str1, str2, this.rDk, new Runnable()
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
    cyz();
    paramConfiguration = this.rII.entrySet().iterator();
    while (paramConfiguration.hasNext()) {
      a((a)((Map.Entry)paramConfiguration.next()).getValue());
    }
    AppMethodBeat.o(107196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107192);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    cyz();
    this.rIH = ((LinearLayout)findViewById(2131299802));
    final long l = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.rDk = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(l);
    if (this.rDk == null)
    {
      finish();
      AppMethodBeat.o(107192);
      return;
    }
    H(this.rDk);
    paramBundle = this.rDk.field_favProto.oeJ.iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      ajx localajx = (ajx)paramBundle.next();
      ae.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[] { Integer.valueOf(i), localajx.dua });
      a locala = new a((byte)0);
      locala.dtI = localajx;
      ImageView localImageView = new ImageView(getContext());
      int j = getResources().getDimensionPixelSize(2131165568);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = j;
      }
      this.rIH.addView(localImageView, localLayoutParams);
      localImageView.setTag(localajx);
      j /= 2;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(j, j, j, j);
      localImageView.setMinimumWidth(com.tencent.mm.cb.a.fromDPToPix(getContext(), 50));
      localImageView.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 50));
      localImageView.setImageResource(2131690142);
      localImageView.setOnClickListener(this.cNE);
      localImageView.setOnLongClickListener(this.rIu);
      localImageView.setOnTouchListener(new FavoriteImgDetailUI.4(this));
      locala.dtJ = localImageView;
      this.rII.put(localajx.dua, locala);
      a(locala);
      if (localajx.GAI != 0) {
        this.rIK = false;
      }
      i += 1;
    }
    setMMTitle(getString(2131758856));
    a.a(this, this.rDk);
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
        paramAnonymousMenuItem.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(107175);
            if (FavoriteImgDetailUI.a(FavoriteImgDetailUI.this)) {
              paramAnonymous2l.d(2, FavoriteImgDetailUI.this.getString(2131759001));
            }
            paramAnonymous2l.d(3, FavoriteImgDetailUI.this.getString(2131758988));
            paramAnonymous2l.d(0, FavoriteImgDetailUI.this.getString(2131758875));
            paramAnonymous2l.d(1, FavoriteImgDetailUI.this.getContext().getString(2131755707));
            AppMethodBeat.o(107175);
          }
        };
        paramAnonymousMenuItem.LfT = new n.e()
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
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.rHW;
              paramAnonymous2MenuItem.rAP += 1;
              AppMethodBeat.o(107178);
              return;
              com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107177);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(2131755709), false, null);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107176);
                      FavoriteImgDetailUI.this.rHW.rAQ = true;
                      paramAnonymous3DialogInterface.dismiss();
                      ae.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId) });
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
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.rHW;
              paramAnonymous2MenuItem.rAM += 1;
              AppMethodBeat.o(107178);
              return;
              j.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.7.this.rIO, FavoriteImgDetailUI.this.rHW);
            }
          }
        };
        paramAnonymousMenuItem.cPF();
        AppMethodBeat.o(107179);
        return true;
      }
    });
    com.tencent.mm.pluginsdk.h.r(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    com.tencent.mm.sdk.b.a.IvT.c(this.rFa);
    this.lAg = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
    {
      public final void ahM(String paramAnonymousString)
      {
        AppMethodBeat.i(107180);
        Object localObject = null;
        Iterator localIterator = FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).values().iterator();
        if (localIterator.hasNext())
        {
          FavoriteImgDetailUI.a locala = (FavoriteImgDetailUI.a)localIterator.next();
          if (!paramAnonymousString.equals(locala.rIX)) {
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
          if ((localObject.rIV != null) && (localObject.rIV.isShowing())) {
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
    com.tencent.mm.sdk.b.a.IvT.d(this.rFa);
    super.onDestroy();
    AppMethodBeat.o(107194);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107193);
    super.onResume();
    Iterator localIterator = this.rII.entrySet().iterator();
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
    int dov;
    int dow;
    ajx dtI;
    ImageView dtJ;
    e rIV;
    boolean rIW;
    String rIX;
    boolean rIY;
    boolean rIZ;
    
    private a()
    {
      AppMethodBeat.i(107189);
      this.rIV = new e(FavoriteImgDetailUI.this.getContext(), 1, false);
      this.rIW = false;
      this.rIX = null;
      this.dov = 0;
      this.dow = 0;
      this.rIY = false;
      AppMethodBeat.o(107189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI
 * JD-Core Version:    0.7.0.1
 */