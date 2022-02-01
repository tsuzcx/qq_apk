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
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class FavoriteImgDetailUI
  extends BaseFavDetailReportUI
  implements q
{
  private View.OnClickListener dig;
  private int displayWidth;
  private ScanCodeSheetItemLogic oxq;
  private g wJa;
  private IListener wKS;
  private LinearLayout wOG;
  private HashMap<String, a> wOH;
  private Bitmap wOI;
  private boolean wOJ;
  private View.OnLongClickListener wOt;
  
  public FavoriteImgDetailUI()
  {
    AppMethodBeat.i(107190);
    this.displayWidth = 0;
    this.wOH = new HashMap();
    this.wOJ = true;
    this.dig = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107184);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_detail_info_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId);
        ((Intent)localObject).putExtra("key_detail_data_id", ((anm)paramAnonymousView.getTag()).fEa);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject);
        paramAnonymousView = FavoriteImgDetailUI.this.wNU;
        paramAnonymousView.wGt += 1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107184);
      }
    };
    this.wOt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        paramAnonymousView = (anm)paramAnonymousView.getTag();
        paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(paramAnonymousView.fEa);
        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, paramAnonymousView);
        if (!paramAnonymousView.wOX) {
          FavoriteImgDetailUI.b(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107185);
        return true;
      }
    };
    this.wKS = new IListener() {};
    AppMethodBeat.o(107190);
  }
  
  private void a(final a parama)
  {
    AppMethodBeat.i(107197);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107183);
        Bitmap localBitmap2 = com.tencent.mm.plugin.fav.ui.o.a(parama.fDI, FavoriteImgDetailUI.b(FavoriteImgDetailUI.this), false);
        final Bitmap localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          Log.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
          localBitmap1 = FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, parama.fDI);
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107181);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.9.this.wOL, localBitmap1);
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
    p.a(paramContext, paramString1, new p.a()
    {
      public final void bT(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(231208);
        Toast.makeText(this.val$context, this.val$context.getString(s.i.cropimage_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymousString2) }), 1).show();
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(230472);
            String str = u.buc(paramAnonymousString2);
            v localv = v.mEG;
            v.bV(str, FavoriteImgDetailUI.3.this.wKZ);
            AppMethodBeat.o(230472);
          }
        });
        AppMethodBeat.o(231208);
      }
      
      public final void bU(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(231210);
        Toast.makeText(this.val$context, paramString2, 1).show();
        AppMethodBeat.o(231210);
      }
    });
    AppMethodBeat.o(164100);
  }
  
  private void dlJ()
  {
    AppMethodBeat.i(107195);
    this.displayWidth = (ar.au(getContext()).x - getResources().getDimensionPixelOffset(s.c.FavDetailPadding) * 2);
    this.displayWidth = Math.max(this.displayWidth, 0);
    Log.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[] { Integer.valueOf(this.displayWidth) });
    AppMethodBeat.o(107195);
  }
  
  private Bitmap n(anm paramanm)
  {
    boolean bool = true;
    AppMethodBeat.i(107199);
    paramanm = com.tencent.mm.plugin.fav.ui.o.a(paramanm, this.wJa);
    if (paramanm != null) {}
    for (;;)
    {
      Log.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", new Object[] { Boolean.valueOf(bool) });
      if (paramanm == null) {
        break;
      }
      AppMethodBeat.o(107199);
      return paramanm;
      bool = false;
    }
    if (this.wOI == null) {
      this.wOI = com.tencent.mm.compatible.f.a.decodeResource(getResources(), s.h.fav_list_img_default);
    }
    paramanm = this.wOI;
    AppMethodBeat.o(107199);
    return paramanm;
  }
  
  protected final MMLoadScrollView dly()
  {
    AppMethodBeat.i(107191);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(s.e.scroll_view);
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
    paramc = (a)this.wOH.get(paramc.field_dataId);
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(107200);
  }
  
  public int getLayoutId()
  {
    return s.f.favorite_img_detail_ui;
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
      if (k.v(this.wJa))
      {
        com.tencent.mm.ui.base.h.cO(getContext(), getString(s.i.Fav_NotDownload_CannotForward));
        AppMethodBeat.o(107201);
        return;
      }
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      String str2 = paramIntent.getStringExtra("custom_send_text");
      Log.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[] { str1 });
      final s locals = com.tencent.mm.ui.base.h.a(getContext(), getString(s.i.favorite_forward_tips), false, null);
      l.a(getContext(), str1, str2, this.wJa, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164097);
          locals.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.r(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(s.i.fav_finish_sent));
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
    dlJ();
    paramConfiguration = this.wOH.entrySet().iterator();
    while (paramConfiguration.hasNext()) {
      a((a)((Map.Entry)paramConfiguration.next()).getValue());
    }
    AppMethodBeat.o(107196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107192);
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    dlJ();
    this.wOG = ((LinearLayout)findViewById(s.e.fav_img_container));
    final long l = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.wJa = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(l);
    if (this.wJa == null)
    {
      finish();
      AppMethodBeat.o(107192);
      return;
    }
    H(this.wJa);
    paramBundle = this.wJa.field_favProto.syG.iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      final anm localanm = (anm)paramBundle.next();
      Log.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[] { Integer.valueOf(i), localanm.fEa });
      a locala = new a((byte)0);
      locala.fDI = localanm;
      final ImageView localImageView = new ImageView(getContext());
      final int j = getResources().getDimensionPixelSize(s.c.SmallPadding);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = j;
      }
      this.wOG.addView(localImageView, localLayoutParams);
      localImageView.setTag(localanm);
      j /= 2;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(j, j, j, j);
      localImageView.setMinimumWidth(com.tencent.mm.ci.a.fromDPToPix(getContext(), 50));
      localImageView.setMinimumHeight(com.tencent.mm.ci.a.fromDPToPix(getContext(), 50));
      localImageView.setImageResource(s.h.fav_list_img_default);
      localImageView.setOnClickListener(this.dig);
      localImageView.setOnLongClickListener(this.wOt);
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
            paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(localanm.fEa);
            Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo scanImage locationInWindow: %s, %s, imageWidth: %s, imageHeight: %s, touch: %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(paramAnonymousView.wPb), Integer.valueOf(paramAnonymousView.wPc), Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
            paramAnonymousView = n.a(localImageView, paramAnonymousMotionEvent.getRawX() - localObject[0] - j, paramAnonymousMotionEvent.getRawY() - localObject[1] - j, paramAnonymousView.wPb, paramAnonymousView.wPc);
            localObject = ad.beh().I("basescanui@datacenter", true);
            if (paramAnonymousView != null)
            {
              ((ad.b)localObject).k("key_basescanui_touch_normalize_x", Float.valueOf(paramAnonymousView.x));
              ((ad.b)localObject).k("key_basescanui_touch_normalize_y", Float.valueOf(paramAnonymousView.y));
            }
            else
            {
              Log.e("MicroMsg.FavoriteImgDetailUI", "alvinluo get touchCoordinate is invalid");
              ((ad.b)localObject).k("key_basescanui_screen_position", Boolean.TRUE);
              ((ad.b)localObject).k("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
              ((ad.b)localObject).k("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
            }
          }
        }
      });
      locala.fDJ = localImageView;
      this.wOH.put(localanm.fEa, locala);
      a(locala);
      if (localanm.SyU != 0) {
        this.wOJ = false;
      }
      i += 1;
    }
    setMMTitle(getString(s.i.favorite_detail));
    a.a(this, this.wJa);
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
    addIconOptionMenu(0, s.i.top_item_desc_more, s.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107179);
        paramAnonymousMenuItem = new e(FavoriteImgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
          {
            AppMethodBeat.i(107175);
            if (FavoriteImgDetailUI.a(FavoriteImgDetailUI.this)) {
              paramAnonymous2o.d(2, FavoriteImgDetailUI.this.getString(s.i.favorite_share_with_friend));
            }
            paramAnonymous2o.d(3, FavoriteImgDetailUI.this.getString(s.i.favorite_save_as_note));
            paramAnonymous2o.d(0, FavoriteImgDetailUI.this.getString(s.i.favorite_edit_tag_tips));
            paramAnonymous2o.d(1, FavoriteImgDetailUI.this.getContext().getString(s.i.app_delete));
            AppMethodBeat.o(107175);
          }
        };
        paramAnonymousMenuItem.ODU = new q.g()
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
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.wNU;
              paramAnonymous2MenuItem.wGx += 1;
              AppMethodBeat.o(107178);
              return;
              com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(s.i.app_delete_tips), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107177);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(s.i.app_delete_tips), false, null);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107176);
                      FavoriteImgDetailUI.this.wNU.wGy = true;
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
              com.tencent.mm.by.c.d(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
              com.tencent.mm.plugin.fav.a.h.y(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, 1);
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.wNU;
              paramAnonymous2MenuItem.wGu += 1;
              AppMethodBeat.o(107178);
              return;
              j.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.7.this.wOP, FavoriteImgDetailUI.this.wNU);
            }
          }
        };
        paramAnonymousMenuItem.eik();
        AppMethodBeat.o(107179);
        return true;
      }
    });
    com.tencent.mm.pluginsdk.h.s(this);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(this);
    EventCenter.instance.addListener(this.wKS);
    this.oxq = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
    {
      public final void aAx(String paramAnonymousString)
      {
        AppMethodBeat.i(107180);
        Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo onFetchedCodeInfo codeStr: %s", new Object[] { paramAnonymousString });
        Object localObject = null;
        Iterator localIterator = FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).values().iterator();
        if (localIterator.hasNext())
        {
          FavoriteImgDetailUI.a locala = (FavoriteImgDetailUI.a)localIterator.next();
          if (!paramAnonymousString.equals(locala.wOY)) {
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
          if ((localObject.wOW != null) && (localObject.wOW.isShowing())) {
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
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(this);
    EventCenter.instance.removeListener(this.wKS);
    super.onDestroy();
    AppMethodBeat.o(107194);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107193);
    super.onResume();
    Iterator localIterator = this.wOH.entrySet().iterator();
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
    anm fDI;
    ImageView fDJ;
    int fys;
    int fyt;
    e wOW;
    boolean wOX;
    String wOY;
    boolean wOZ;
    boolean wPa;
    int wPb;
    int wPc;
    
    private a()
    {
      AppMethodBeat.i(107189);
      this.wOW = new e(FavoriteImgDetailUI.this.getContext(), 1, false);
      this.wOX = false;
      this.wOY = null;
      this.fys = 0;
      this.fyt = 0;
      this.wOZ = false;
      this.wPb = 0;
      this.wPc = 0;
      AppMethodBeat.o(107189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI
 * JD-Core Version:    0.7.0.1
 */