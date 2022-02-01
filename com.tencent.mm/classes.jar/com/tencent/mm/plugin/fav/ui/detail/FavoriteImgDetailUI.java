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
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.pu;
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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
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
  private int aZC;
  private View.OnClickListener cBW;
  private ScanCodeSheetItemLogic kYG;
  private com.tencent.mm.plugin.fav.a.g qKW;
  private com.tencent.mm.sdk.b.c qMM;
  private View.OnLongClickListener qQj;
  private LinearLayout qQw;
  private HashMap<String, a> qQx;
  private Bitmap qQy;
  private boolean qQz;
  
  public FavoriteImgDetailUI()
  {
    AppMethodBeat.i(107190);
    this.aZC = 0;
    this.qQx = new HashMap();
    this.qQz = true;
    this.cBW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107184);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_detail_info_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId);
        localIntent.putExtra("key_detail_data_id", ((agx)paramAnonymousView.getTag()).dhw);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavImgGalleryUI", localIntent);
        paramAnonymousView = FavoriteImgDetailUI.this.qPM;
        paramAnonymousView.qIx += 1;
        AppMethodBeat.o(107184);
      }
    };
    this.qQj = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107185);
        paramAnonymousView = (agx)paramAnonymousView.getTag();
        paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(paramAnonymousView.dhw);
        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, paramAnonymousView);
        if (!paramAnonymousView.qQL) {
          FavoriteImgDetailUI.b(paramAnonymousView);
        }
        AppMethodBeat.o(107185);
        return true;
      }
    };
    this.qMM = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(107190);
  }
  
  private void a(final a parama)
  {
    AppMethodBeat.i(107197);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107183);
        Bitmap localBitmap2 = o.a(parama.dhe, FavoriteImgDetailUI.b(FavoriteImgDetailUI.this), false);
        final Bitmap localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          ac.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
          localBitmap1 = FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, parama.dhe);
        }
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107181);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.9.this.qQB, localBitmap1);
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
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
      AppMethodBeat.o(164100);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, paramString1, new p.a()
    {
      public final void bD(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(209486);
        Toast.makeText(this.val$context, this.val$context.getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.aLU(paramAnonymousString2) }), 1).show();
        com.tencent.e.h.JZN.aS(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209485);
            String str = com.tencent.mm.vfs.i.aKe(paramAnonymousString2);
            v localv = v.iuG;
            v.bF(str, FavoriteImgDetailUI.3.this.qMS);
            AppMethodBeat.o(209485);
          }
        });
        AppMethodBeat.o(209486);
      }
      
      public final void bE(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(209487);
        Toast.makeText(this.val$context, paramString2, 1).show();
        AppMethodBeat.o(209487);
      }
    });
    AppMethodBeat.o(164100);
  }
  
  private void crn()
  {
    AppMethodBeat.i(107195);
    if (ai.getResources() != null) {}
    for (DisplayMetrics localDisplayMetrics = ai.getResources().getDisplayMetrics();; localDisplayMetrics = getResources().getDisplayMetrics())
    {
      this.aZC = (localDisplayMetrics.widthPixels - getResources().getDimensionPixelOffset(2131165353) * 2);
      this.aZC = Math.max(this.aZC, 0);
      ac.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[] { Integer.valueOf(this.aZC) });
      AppMethodBeat.o(107195);
      return;
    }
  }
  
  private Bitmap n(agx paramagx)
  {
    boolean bool = true;
    AppMethodBeat.i(107199);
    paramagx = o.a(paramagx, this.qKW);
    if (paramagx != null) {}
    for (;;)
    {
      ac.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", new Object[] { Boolean.valueOf(bool) });
      if (paramagx == null) {
        break;
      }
      AppMethodBeat.o(107199);
      return paramagx;
      bool = false;
    }
    if (this.qQy == null) {
      this.qQy = com.tencent.mm.compatible.e.a.decodeResource(getResources(), 2131690142);
    }
    paramagx = this.qQy;
    AppMethodBeat.o(107199);
    return paramagx;
  }
  
  protected final MMLoadScrollView crc()
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
    ac.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[] { paramc.field_dataId });
    paramc = (a)this.qQx.get(paramc.field_dataId);
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
      if (k.v(this.qKW))
      {
        com.tencent.mm.ui.base.h.cg(getContext(), getString(2131755010));
        AppMethodBeat.o(107201);
        return;
      }
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      String str2 = paramIntent.getStringExtra("custom_send_text");
      ac.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[] { str1 });
      final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
      com.tencent.mm.plugin.fav.ui.l.a(getContext(), str1, str2, this.qKW, new Runnable()
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
    crn();
    paramConfiguration = this.qQx.entrySet().iterator();
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
    crn();
    this.qQw = ((LinearLayout)findViewById(2131299802));
    final long l = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.qKW = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(l);
    if (this.qKW == null)
    {
      finish();
      AppMethodBeat.o(107192);
      return;
    }
    H(this.qKW);
    paramBundle = this.qKW.field_favProto.nxC.iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      agx localagx = (agx)paramBundle.next();
      ac.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[] { Integer.valueOf(i), localagx.dhw });
      a locala = new a((byte)0);
      locala.dhe = localagx;
      ImageView localImageView = new ImageView(getContext());
      int j = getResources().getDimensionPixelSize(2131165568);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = j;
      }
      this.qQw.addView(localImageView, localLayoutParams);
      localImageView.setTag(localagx);
      j /= 2;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(j, j, j, j);
      localImageView.setMinimumWidth(com.tencent.mm.cc.a.fromDPToPix(getContext(), 50));
      localImageView.setMinimumHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 50));
      localImageView.setImageResource(2131690142);
      localImageView.setOnClickListener(this.cBW);
      localImageView.setOnLongClickListener(this.qQj);
      localImageView.setOnTouchListener(new FavoriteImgDetailUI.4(this));
      locala.dhf = localImageView;
      this.qQx.put(localagx.dhw, locala);
      a(locala);
      if (localagx.EAn != 0) {
        this.qQz = false;
      }
      i += 1;
    }
    setMMTitle(getString(2131758856));
    a.a(this, this.qKW);
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
        paramAnonymousMenuItem.ISu = new n.c()
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
        paramAnonymousMenuItem.ISv = new n.d()
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
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.qPM;
              paramAnonymous2MenuItem.qIB += 1;
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
                      FavoriteImgDetailUI.this.qPM.qIC = true;
                      paramAnonymous3DialogInterface.dismiss();
                      ac.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId) });
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
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.qPM;
              paramAnonymous2MenuItem.qIy += 1;
              AppMethodBeat.o(107178);
              return;
              j.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.7.this.qQD, FavoriteImgDetailUI.this.qPM);
            }
          }
        };
        paramAnonymousMenuItem.cED();
        AppMethodBeat.o(107179);
        return true;
      }
    });
    com.tencent.mm.pluginsdk.g.p(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
    com.tencent.mm.sdk.b.a.GpY.c(this.qMM);
    this.kYG = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
    {
      public final void ada(String paramAnonymousString)
      {
        AppMethodBeat.i(107180);
        Object localObject = null;
        Iterator localIterator = FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).values().iterator();
        if (localIterator.hasNext())
        {
          FavoriteImgDetailUI.a locala = (FavoriteImgDetailUI.a)localIterator.next();
          if (!paramAnonymousString.equals(locala.qQM)) {
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
          if ((localObject.qQK != null) && (localObject.qQK.isShowing())) {
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
    com.tencent.mm.sdk.b.a.GpY.d(this.qMM);
    super.onDestroy();
    AppMethodBeat.o(107194);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107193);
    super.onResume();
    Iterator localIterator = this.qQx.entrySet().iterator();
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
    int dbX;
    int dbY;
    agx dhe;
    ImageView dhf;
    e qQK;
    boolean qQL;
    String qQM;
    boolean qQN;
    boolean qQO;
    
    private a()
    {
      AppMethodBeat.i(107189);
      this.qQK = new e(FavoriteImgDetailUI.this.getContext(), 1, false);
      this.qQL = false;
      this.qQM = null;
      this.dbX = 0;
      this.dbY = 0;
      this.qQN = false;
      AppMethodBeat.o(107189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI
 * JD-Core Version:    0.7.0.1
 */