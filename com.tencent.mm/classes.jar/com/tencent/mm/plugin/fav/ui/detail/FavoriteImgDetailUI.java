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
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.s;
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
  private View.OnClickListener dec;
  private int displayWidth;
  private ScanCodeSheetItemLogic mHu;
  private com.tencent.mm.plugin.fav.a.g tcP;
  private IListener teF;
  private View.OnLongClickListener tib;
  private LinearLayout tip;
  private HashMap<String, a> tiq;
  private Bitmap tir;
  private boolean tis;
  
  public FavoriteImgDetailUI()
  {
    AppMethodBeat.i(107190);
    this.displayWidth = 0;
    this.tiq = new HashMap();
    this.tis = true;
    this.dec = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107184);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_detail_info_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId);
        ((Intent)localObject).putExtra("key_detail_data_id", ((aml)paramAnonymousView.getTag()).dLl);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject);
        paramAnonymousView = FavoriteImgDetailUI.this.thD;
        paramAnonymousView.taq += 1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107184);
      }
    };
    this.tib = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        paramAnonymousView = (aml)paramAnonymousView.getTag();
        paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(paramAnonymousView.dLl);
        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, paramAnonymousView);
        if (!paramAnonymousView.tiG) {
          FavoriteImgDetailUI.b(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107185);
        return true;
      }
    };
    this.teF = new IListener() {};
    AppMethodBeat.o(107190);
  }
  
  private void a(final a parama)
  {
    AppMethodBeat.i(107197);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107183);
        Bitmap localBitmap2 = o.a(parama.dKT, FavoriteImgDetailUI.b(FavoriteImgDetailUI.this), false);
        final Bitmap localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          Log.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
          localBitmap1 = FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, parama.dKT);
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107181);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.9.this.tiu, localBitmap1);
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
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
      AppMethodBeat.o(164100);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, paramString1, new p.a()
    {
      public final void bP(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(235334);
        Toast.makeText(this.val$context, this.val$context.getString(2131758218, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymousString2) }), 1).show();
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235333);
            String str = s.bhK(paramAnonymousString2);
            v localv = v.jNy;
            v.bR(str, FavoriteImgDetailUI.3.this.teL);
            AppMethodBeat.o(235333);
          }
        });
        AppMethodBeat.o(235334);
      }
      
      public final void bQ(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(235335);
        Toast.makeText(this.val$context, paramString2, 1).show();
        AppMethodBeat.o(235335);
      }
    });
    AppMethodBeat.o(164100);
  }
  
  private void cWC()
  {
    AppMethodBeat.i(107195);
    if (getResources() != null) {}
    for (DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();; localDisplayMetrics = MMApplicationContext.getResources().getDisplayMetrics())
    {
      this.displayWidth = (localDisplayMetrics.widthPixels - getResources().getDimensionPixelOffset(2131165364) * 2);
      this.displayWidth = Math.max(this.displayWidth, 0);
      Log.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[] { Integer.valueOf(this.displayWidth) });
      AppMethodBeat.o(107195);
      return;
    }
  }
  
  private Bitmap n(aml paramaml)
  {
    boolean bool = true;
    AppMethodBeat.i(107199);
    paramaml = o.a(paramaml, this.tcP);
    if (paramaml != null) {}
    for (;;)
    {
      Log.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", new Object[] { Boolean.valueOf(bool) });
      if (paramaml == null) {
        break;
      }
      AppMethodBeat.o(107199);
      return paramaml;
      bool = false;
    }
    if (this.tir == null) {
      this.tir = com.tencent.mm.compatible.f.a.decodeResource(getResources(), 2131690179);
    }
    paramaml = this.tir;
    AppMethodBeat.o(107199);
    return paramaml;
  }
  
  protected final MMLoadScrollView cWr()
  {
    AppMethodBeat.i(107191);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131307339);
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
    Log.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[] { paramc.field_dataId });
    paramc = (a)this.tiq.get(paramc.field_dataId);
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(107200);
  }
  
  public int getLayoutId()
  {
    return 2131494158;
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
      if (k.v(this.tcP))
      {
        com.tencent.mm.ui.base.h.cD(getContext(), getString(2131755011));
        AppMethodBeat.o(107201);
        return;
      }
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      String str2 = paramIntent.getStringExtra("custom_send_text");
      Log.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[] { str1 });
      final com.tencent.mm.ui.base.q localq = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
      l.a(getContext(), str1, str2, this.tcP, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164097);
          localq.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.r(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(2131759157));
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
    cWC();
    paramConfiguration = this.tiq.entrySet().iterator();
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
    cWC();
    this.tip = ((LinearLayout)findViewById(2131300477));
    final long l = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.tcP = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l);
    if (this.tcP == null)
    {
      finish();
      AppMethodBeat.o(107192);
      return;
    }
    H(this.tcP);
    paramBundle = this.tcP.field_favProto.ppH.iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      final aml localaml = (aml)paramBundle.next();
      Log.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[] { Integer.valueOf(i), localaml.dLl });
      a locala = new a((byte)0);
      locala.dKT = localaml;
      final ImageView localImageView = new ImageView(getContext());
      final int j = getResources().getDimensionPixelSize(2131165586);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = j;
      }
      this.tip.addView(localImageView, localLayoutParams);
      localImageView.setTag(localaml);
      j /= 2;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(j, j, j, j);
      localImageView.setMinimumWidth(com.tencent.mm.cb.a.fromDPToPix(getContext(), 50));
      localImageView.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 50));
      localImageView.setImageResource(2131690179);
      localImageView.setOnClickListener(this.dec);
      localImageView.setOnLongClickListener(this.tib);
      localImageView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(164096);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(164096);
            return false;
            Object localObject = new int[2];
            paramAnonymousView.getLocationInWindow((int[])localObject);
            paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(localaml.dLl);
            Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo scanImage locationInWindow: %s, %s, imageWidth: %s, imageHeight: %s, touch: %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(paramAnonymousView.tiK), Integer.valueOf(paramAnonymousView.tiL), Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
            paramAnonymousView = com.tencent.mm.plugin.scanner.util.m.a(localImageView, paramAnonymousMotionEvent.getRawX() - localObject[0] - j, paramAnonymousMotionEvent.getRawY() - localObject[1] - j, paramAnonymousView.tiK, paramAnonymousView.tiL);
            localObject = ad.aVe().G("basescanui@datacenter", true);
            if (paramAnonymousView != null)
            {
              ((ad.b)localObject).l("key_basescanui_touch_normalize_x", Float.valueOf(paramAnonymousView.x));
              ((ad.b)localObject).l("key_basescanui_touch_normalize_y", Float.valueOf(paramAnonymousView.y));
            }
            else
            {
              Log.e("MicroMsg.FavoriteImgDetailUI", "alvinluo get touchCoordinate is invalid");
              ((ad.b)localObject).l("key_basescanui_screen_position", Boolean.TRUE);
              ((ad.b)localObject).l("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
              ((ad.b)localObject).l("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
            }
          }
        }
      });
      locala.dKU = localImageView;
      this.tiq.put(localaml.dLl, locala);
      a(locala);
      if (localaml.Lwv != 0) {
        this.tis = false;
      }
      i += 1;
    }
    setMMTitle(getString(2131759179));
    a.a(this, this.tcP);
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
    addIconOptionMenu(0, 2131766795, 2131689495, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107179);
        paramAnonymousMenuItem = new e(FavoriteImgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
          {
            AppMethodBeat.i(107175);
            if (FavoriteImgDetailUI.a(FavoriteImgDetailUI.this)) {
              paramAnonymous2m.d(2, FavoriteImgDetailUI.this.getString(2131759326));
            }
            paramAnonymous2m.d(3, FavoriteImgDetailUI.this.getString(2131759313));
            paramAnonymous2m.d(0, FavoriteImgDetailUI.this.getString(2131759199));
            paramAnonymous2m.d(1, FavoriteImgDetailUI.this.getContext().getString(2131755778));
            AppMethodBeat.o(107175);
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
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
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.thD;
              paramAnonymous2MenuItem.tau += 1;
              AppMethodBeat.o(107178);
              return;
              com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(2131755780), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107177);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(2131755780), false, null);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107176);
                      FavoriteImgDetailUI.this.thD.tav = true;
                      paramAnonymous3DialogInterface.dismiss();
                      Log.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId) });
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
              com.tencent.mm.br.c.c(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
              com.tencent.mm.plugin.fav.a.h.w(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, 1);
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.thD;
              paramAnonymous2MenuItem.tar += 1;
              AppMethodBeat.o(107178);
              return;
              j.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.7.this.tiy, FavoriteImgDetailUI.this.thD);
            }
          }
        };
        paramAnonymousMenuItem.dGm();
        AppMethodBeat.o(107179);
        return true;
      }
    });
    com.tencent.mm.pluginsdk.h.r(this);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(this);
    EventCenter.instance.addListener(this.teF);
    this.mHu = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
    {
      public final void asu(String paramAnonymousString)
      {
        AppMethodBeat.i(107180);
        Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo onFetchedCodeInfo codeStr: %s", new Object[] { paramAnonymousString });
        Object localObject = null;
        Iterator localIterator = FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).values().iterator();
        if (localIterator.hasNext())
        {
          FavoriteImgDetailUI.a locala = (FavoriteImgDetailUI.a)localIterator.next();
          if (!paramAnonymousString.equals(locala.tiH)) {
            break label117;
          }
          localObject = locala;
        }
        label117:
        for (;;)
        {
          break;
          if (localObject == null)
          {
            AppMethodBeat.o(107180);
            return;
          }
          if ((localObject.tiF != null) && (localObject.tiF.isShowing())) {
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
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(this);
    EventCenter.instance.removeListener(this.teF);
    super.onDestroy();
    AppMethodBeat.o(107194);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107193);
    super.onResume();
    Iterator localIterator = this.tiq.entrySet().iterator();
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
    int dFL;
    int dFM;
    aml dKT;
    ImageView dKU;
    e tiF;
    boolean tiG;
    String tiH;
    boolean tiI;
    boolean tiJ;
    int tiK;
    int tiL;
    
    private a()
    {
      AppMethodBeat.i(107189);
      this.tiF = new e(FavoriteImgDetailUI.this.getContext(), 1, false);
      this.tiG = false;
      this.tiH = null;
      this.dFL = 0;
      this.dFM = 0;
      this.tiI = false;
      this.tiK = 0;
      this.tiL = 0;
      AppMethodBeat.o(107189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI
 * JD-Core Version:    0.7.0.1
 */