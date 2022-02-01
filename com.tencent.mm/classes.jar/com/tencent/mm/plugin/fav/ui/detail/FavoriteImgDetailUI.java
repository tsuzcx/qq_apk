package com.tencent.mm.plugin.fav.ui.detail;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class FavoriteImgDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.q
{
  private g Afv;
  private IListener Ahp;
  private View.OnLongClickListener AkV;
  private LinearLayout Ali;
  private HashMap<String, a> Alj;
  private Bitmap Alk;
  private boolean Alm;
  private int displayWidth;
  private View.OnClickListener fhU;
  private ScanCodeSheetItemLogic rAP;
  
  public FavoriteImgDetailUI()
  {
    AppMethodBeat.i(107190);
    this.displayWidth = 0;
    this.Alj = new HashMap();
    this.Alm = true;
    this.fhU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107184);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_detail_info_id", FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId);
        ((Intent)localObject).putExtra("key_detail_data_id", ((arf)paramAnonymousView.getTag()).hIQ);
        com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavImgGalleryUI", (Intent)localObject);
        paramAnonymousView = FavoriteImgDetailUI.this.Akw;
        paramAnonymousView.AcC += 1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107184);
      }
    };
    this.AkV = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        paramAnonymousView = (arf)paramAnonymousView.getTag();
        paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(paramAnonymousView.hIQ);
        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, paramAnonymousView);
        if (!paramAnonymousView.AlA) {
          FavoriteImgDetailUI.b(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107185);
        return true;
      }
    };
    this.Ahp = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(107190);
  }
  
  private void a(final a parama)
  {
    AppMethodBeat.i(107197);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107183);
        Bitmap localBitmap2 = FavoriteImageServer.a(parama.hIy, FavoriteImgDetailUI.b(FavoriteImgDetailUI.this), false);
        final Bitmap localBitmap1 = localBitmap2;
        if (localBitmap2 == null)
        {
          Log.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
          localBitmap1 = FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, parama.hIy);
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107181);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.8.this.Alo, localBitmap1);
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
    ExportFileUtil.a(paramContext, paramString1, new ExportFileUtil.a()
    {
      public final void cg(String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(274462);
        Toast.makeText(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(q.i.cropimage_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymousString2) }), 1).show();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(274454);
            String str = com.tencent.mm.vfs.y.bub(paramAnonymousString2);
            com.tencent.mm.platformtools.s locals = com.tencent.mm.platformtools.s.pBi;
            com.tencent.mm.platformtools.s.ci(str, FavoriteImgDetailUI.3.this.Ahw);
            AppMethodBeat.o(274454);
          }
        });
        AppMethodBeat.o(274462);
      }
      
      public final void ch(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(274463);
        Toast.makeText(FavoriteImgDetailUI.this, paramString2, 1).show();
        AppMethodBeat.o(274463);
      }
    });
    AppMethodBeat.o(164100);
  }
  
  private void dSz()
  {
    AppMethodBeat.i(107195);
    Point localPoint = aw.bf(getContext());
    if (localPoint != null) {}
    for (int i = localPoint.x;; i = com.tencent.mm.cd.a.ms(getContext()))
    {
      this.displayWidth = (i - getResources().getDimensionPixelOffset(q.c.FavDetailPadding) * 2);
      this.displayWidth = Math.max(this.displayWidth, 0);
      Log.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[] { Integer.valueOf(this.displayWidth) });
      AppMethodBeat.o(107195);
      return;
    }
  }
  
  private Bitmap n(arf paramarf)
  {
    boolean bool = true;
    AppMethodBeat.i(107199);
    paramarf = FavoriteImageServer.a(paramarf, this.Afv);
    if (paramarf != null) {}
    for (;;)
    {
      Log.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", new Object[] { Boolean.valueOf(bool) });
      if (paramarf == null) {
        break;
      }
      AppMethodBeat.o(107199);
      return paramarf;
      bool = false;
    }
    if (this.Alk == null) {
      this.Alk = com.tencent.mm.compatible.f.a.decodeResource(getResources(), q.h.fav_list_img_default);
    }
    paramarf = this.Alk;
    AppMethodBeat.o(107199);
    return paramarf;
  }
  
  protected final MMLoadScrollView dSo()
  {
    AppMethodBeat.i(107191);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(q.e.scroll_view);
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
    paramc = (a)this.Alj.get(paramc.field_dataId);
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(107200);
  }
  
  public int getLayoutId()
  {
    return q.f.favorite_img_detail_ui;
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
      new com.tencent.mm.plugin.fav.a.k();
      if (com.tencent.mm.plugin.fav.a.k.v(this.Afv))
      {
        com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.Fav_NotDownload_CannotForward));
        AppMethodBeat.o(107201);
        return;
      }
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      String str2 = paramIntent.getStringExtra("custom_send_text");
      Log.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[] { str1 });
      final w localw = com.tencent.mm.ui.base.k.a(getContext(), getString(q.i.favorite_forward_tips), false, null);
      l.a(getContext(), str1, str2, this.Afv, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164097);
          localw.dismiss();
          com.tencent.mm.ui.widget.snackbar.b.u(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(q.i.fav_finish_sent));
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
    dSz();
    paramConfiguration = this.Alj.entrySet().iterator();
    while (paramConfiguration.hasNext()) {
      a((a)((Map.Entry)paramConfiguration.next()).getValue());
    }
    AppMethodBeat.o(107196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107192);
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    dSz();
    this.Ali = ((LinearLayout)findViewById(q.e.fav_img_container));
    final long l = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.Afv = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(l);
    if (this.Afv == null)
    {
      finish();
      AppMethodBeat.o(107192);
      return;
    }
    H(this.Afv);
    paramBundle = this.Afv.field_favProto.vEn.iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      final arf localarf = (arf)paramBundle.next();
      Log.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[] { Integer.valueOf(i), localarf.hIQ });
      a locala = new a((byte)0);
      locala.hIy = localarf;
      final ImageView localImageView = new ImageView(getContext());
      final int j = getResources().getDimensionPixelSize(q.c.SmallPadding);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = j;
      }
      this.Ali.addView(localImageView, localLayoutParams);
      localImageView.setTag(localarf);
      j /= 2;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(j, j, j, j);
      localImageView.setMinimumWidth(com.tencent.mm.cd.a.fromDPToPix(getContext(), 50));
      localImageView.setMinimumHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 50));
      localImageView.setImageResource(q.h.fav_list_img_default);
      localImageView.setOnClickListener(this.fhU);
      localImageView.setOnLongClickListener(this.AkV);
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
            paramAnonymousView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).get(localarf.hIQ);
            Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo scanImage locationInWindow: %s, %s, imageWidth: %s, imageHeight: %s, touch: %s, %s", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(paramAnonymousView.AlD), Integer.valueOf(paramAnonymousView.AlE), Float.valueOf(paramAnonymousMotionEvent.getRawX()), Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
            paramAnonymousView = p.a(localImageView, paramAnonymousMotionEvent.getRawX() - localObject[0] - j, paramAnonymousMotionEvent.getRawY() - localObject[1] - j, paramAnonymousView.AlD, paramAnonymousView.AlE);
            localObject = ad.bCb().M("basescanui@datacenter", true);
            if (paramAnonymousView != null)
            {
              ((ad.b)localObject).q("key_basescanui_touch_normalize_x", Float.valueOf(paramAnonymousView.x));
              ((ad.b)localObject).q("key_basescanui_touch_normalize_y", Float.valueOf(paramAnonymousView.y));
            }
            else
            {
              Log.e("MicroMsg.FavoriteImgDetailUI", "alvinluo get touchCoordinate is invalid");
              ((ad.b)localObject).q("key_basescanui_screen_position", Boolean.TRUE);
              ((ad.b)localObject).q("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
              ((ad.b)localObject).q("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
            }
          }
        }
      });
      locala.hIz = localImageView;
      this.Alj.put(localarf.hIQ, locala);
      a(locala);
      if (localarf.ZzM != 0) {
        this.Alm = false;
      }
      i += 1;
    }
    setMMTitle(getString(q.i.favorite_detail));
    a.a(this, this.Afv);
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
    addIconOptionMenu(0, q.i.top_item_desc_more, q.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107179);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(FavoriteImgDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
          {
            AppMethodBeat.i(107175);
            if (FavoriteImgDetailUI.a(FavoriteImgDetailUI.this)) {
              paramAnonymous2s.c(2, FavoriteImgDetailUI.this.getString(q.i.favorite_share_with_friend));
            }
            paramAnonymous2s.c(3, FavoriteImgDetailUI.this.getString(q.i.favorite_save_as_note));
            paramAnonymous2s.c(0, FavoriteImgDetailUI.this.getString(q.i.favorite_edit_tag_tips));
            paramAnonymous2s.c(1, FavoriteImgDetailUI.this.getContext().getString(q.i.app_delete));
            AppMethodBeat.o(107175);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
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
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.Akw;
              paramAnonymous2MenuItem.AcG += 1;
              AppMethodBeat.o(107178);
              return;
              com.tencent.mm.ui.base.k.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(q.i.app_delete_tips), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107177);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.k.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(q.i.app_delete_tips), false, null);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107176);
                      FavoriteImgDetailUI.this.Akw.AcH = true;
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
              com.tencent.mm.br.c.d(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
              com.tencent.mm.plugin.fav.a.h.I(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this).field_localId, 1);
              paramAnonymous2MenuItem = FavoriteImgDetailUI.this.Akw;
              paramAnonymous2MenuItem.AcD += 1;
              AppMethodBeat.o(107178);
              return;
              j.a(FavoriteImgDetailUI.this, FavoriteImgDetailUI.6.this.Als, FavoriteImgDetailUI.this.Akw);
            }
          }
        };
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(107179);
        return true;
      }
    });
    com.tencent.mm.pluginsdk.h.x(this);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(this);
    this.Ahp.alive();
    this.rAP = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b()
    {
      public final void auF(String paramAnonymousString)
      {
        AppMethodBeat.i(107180);
        Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo onFetchedCodeInfo codeStr: %s", new Object[] { paramAnonymousString });
        Object localObject = null;
        Iterator localIterator = FavoriteImgDetailUI.c(FavoriteImgDetailUI.this).values().iterator();
        if (localIterator.hasNext())
        {
          FavoriteImgDetailUI.a locala = (FavoriteImgDetailUI.a)localIterator.next();
          if (!paramAnonymousString.equals(locala.hHY)) {
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
          if ((localObject.Alz != null) && (localObject.Alz.isShowing())) {
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
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(this);
    this.Ahp.dead();
    super.onDestroy();
    AppMethodBeat.o(107194);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107193);
    super.onResume();
    Iterator localIterator = this.Alj.entrySet().iterator();
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
    boolean AlA;
    boolean AlB;
    boolean AlC;
    int AlD;
    int AlE;
    com.tencent.mm.ui.widget.a.f Alz;
    int hDb;
    int hDc;
    String hHY;
    arf hIy;
    ImageView hIz;
    
    private a()
    {
      AppMethodBeat.i(107189);
      this.Alz = new com.tencent.mm.ui.widget.a.f(FavoriteImgDetailUI.this.getContext(), 1, false);
      this.AlA = false;
      this.hHY = null;
      this.hDb = 0;
      this.hDc = 0;
      this.AlB = false;
      this.AlD = 0;
      this.AlE = 0;
      AppMethodBeat.o(107189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI
 * JD-Core Version:    0.7.0.1
 */