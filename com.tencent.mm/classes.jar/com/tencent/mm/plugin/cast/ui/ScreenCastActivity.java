package com.tencent.mm.plugin.cast.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.cast.PluginCast;
import com.tencent.mm.plugin.cast.PluginCast.a;
import com.tencent.mm.plugin.cast.b.a;
import com.tencent.mm.plugin.cast.b.b;
import com.tencent.mm.plugin.cast.b.c;
import com.tencent.mm.plugin.cast.b.d;
import com.tencent.mm.plugin.cast.b.e;
import com.tencent.mm.plugin.cast.b.f;
import com.tencent.mm.plugin.cast.b.g;
import com.tencent.mm.plugin.cast.service.ScreenCastForegroundService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/ui/ScreenCastActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCREEN_CAST_REQUEST_CODE", "", "connectingLoadingIv", "Landroid/widget/ProgressBar;", "mDetailTv", "Landroid/widget/TextView;", "mIsBindVoipForegroundService", "", "mStartBtn", "Landroid/widget/Button;", "mStartBtnBg", "Landroid/view/View;", "mTitle", "pcStatus", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "phoneStatus", "retryTimes", "bindScreenCastForegroundIfNeed", "", "data", "Landroid/content/Intent;", "resultCode", "getLayoutId", "initBtnListener", "initView", "onActivityResult", "requestCode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onScreenCastEventResponse", "status", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "requestPermissionList", "retryTcpConnect", "simulateHome", "startScreenRecording", "stopScreenRecording", "switchIconStatus", "Companion", "plugin-cast_release"})
public final class ScreenCastActivity
  extends MMActivity
  implements com.tencent.mm.an.i
{
  public static final ScreenCastActivity.a tKL;
  private HashMap _$_findViewCache;
  private int lXi;
  private TextView mLH;
  private Button tKD;
  private View tKE;
  private WeImageView tKF;
  private WeImageView tKG;
  private TextView tKH;
  private ProgressBar tKI;
  private final int tKJ = 1000;
  private boolean tKK;
  
  static
  {
    AppMethodBeat.i(189768);
    tKL = new ScreenCastActivity.a((byte)0);
    AppMethodBeat.o(189768);
  }
  
  private final void Ir(final int paramInt)
  {
    AppMethodBeat.i(189732);
    Log.i("MicroMsg.ScreenCastActivity", "switchIconStatus status is ".concat(String.valueOf(paramInt)));
    h.ZvG.bc((Runnable)new g(this, paramInt));
    AppMethodBeat.o(189732);
  }
  
  private final void cLV()
  {
    AppMethodBeat.i(189733);
    Object localObject = this.tKD;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener((View.OnClickListener)new c(this));
    }
    localObject = findViewById(b.d.tIo);
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(189733);
      return;
    }
    AppMethodBeat.o(189733);
  }
  
  private final boolean cLW()
  {
    AppMethodBeat.i(189750);
    if (com.tencent.mm.pluginsdk.permission.b.a((Activity)this, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE" }, 148, "", ""))
    {
      AppMethodBeat.o(189750);
      return true;
    }
    AppMethodBeat.o(189750);
    return false;
  }
  
  private final void cLX()
  {
    AppMethodBeat.i(189758);
    if (cLW())
    {
      Object localObject = PluginCast.tIg;
      localObject = PluginCast.a.cLu();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.cast.d.a)localObject).C((kotlin.g.a.b)new f(this));
        AppMethodBeat.o(189758);
        return;
      }
    }
    AppMethodBeat.o(189758);
  }
  
  private final void cLY()
  {
    AppMethodBeat.i(189763);
    stopService(new Intent((Context)this, ScreenCastForegroundService.class));
    this.tKK = false;
    Object localObject = PluginCast.tIg;
    localObject = PluginCast.a.cLu();
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.cast.d.a)localObject).stopRecord();
      AppMethodBeat.o(189763);
      return;
    }
    AppMethodBeat.o(189763);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(189793);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(189793);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(189791);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(189791);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.e.tIs;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(189729);
    super.initView();
    this.tKF = ((WeImageView)_$_findCachedViewById(b.d.tIm));
    this.tKG = ((WeImageView)_$_findCachedViewById(b.d.tIn));
    this.tKI = ((ProgressBar)_$_findCachedViewById(b.d.tIl));
    this.tKD = ((Button)_$_findCachedViewById(b.d.tIp));
    this.tKE = ((View)_$_findCachedViewById(b.d.tIq));
    this.tKH = ((TextView)_$_findCachedViewById(b.d.detail_tv));
    this.mLH = ((TextView)_$_findCachedViewById(b.d.dVJ));
    cLV();
    Object localObject1 = PluginCast.tIg;
    localObject1 = PluginCast.a.cLu();
    if (localObject1 != null) {
      localObject1 = ((com.tencent.mm.plugin.cast.d.a)localObject1).tJy;
    }
    while (localObject1 != null) {
      switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = PluginCast.tIg;
        localObject1 = PluginCast.a.cLu();
        if ((localObject1 != null) && (!((com.tencent.mm.plugin.cast.d.a)localObject1).tJr))
        {
          localObject1 = this.mLH;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)getString(b.g.tIF));
          }
          Ir(3);
          AppMethodBeat.o(189729);
          return;
          localObject1 = null;
        }
        break;
      case 1: 
        Ir(4);
        AppMethodBeat.o(189729);
        return;
      case 2: 
        Ir(3);
        cLY();
        AppMethodBeat.o(189729);
        return;
      case 3: 
        Log.i("MicroMsg.ScreenCastActivity", "trans to pc ERROR");
        Ir(5);
        AppMethodBeat.o(189729);
        return;
      case 4: 
        Log.i("MicroMsg.ScreenCastActivity", "trans to pc timeout");
        Ir(2);
        AppMethodBeat.o(189729);
        return;
        Ir(4);
        AppMethodBeat.o(189729);
        return;
      }
    }
    localObject1 = PluginCast.tIg;
    localObject1 = PluginCast.a.cLu();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.cast.d.a)localObject1).tJj;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((com.tencent.mm.plugin.cast.b.b)localObject1).tIR;; localObject1 = null)
    {
      Object localObject2 = PluginCast.tIg;
      Object localObject4 = PluginCast.a.cLu();
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.cast.d.a)localObject4).tJj;
        localObject2 = localObject3;
        if (localObject4 != null) {
          localObject2 = ((com.tencent.mm.plugin.cast.b.b)localObject4).tIS;
        }
      }
      if (!(p.h(localObject1, localObject2) ^ true)) {
        break;
      }
      Ir(6);
      cLY();
      AppMethodBeat.o(189729);
      return;
    }
    Ir(3);
    AppMethodBeat.o(189729);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(189747);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.tKJ)
    {
      if (paramInt2 == -1)
      {
        Object localObject;
        if (paramIntent != null)
        {
          this.tKK = false;
          localObject = PluginCast.tIg;
          localObject = PluginCast.a.cLu();
          if (localObject != null) {
            ((com.tencent.mm.plugin.cast.d.a)localObject).tJr = true;
          }
          Log.printInfoStack("MicroMsg.ScreenCastActivity", "bindScreenCastForegroundIfNeed", new Object[0]);
          if (!this.tKK)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("code", paramInt2);
            ((Intent)localObject).putExtra("data", (Parcelable)paramIntent);
            ((Intent)localObject).setClass(MMApplicationContext.getContext(), ScreenCastForegroundService.class);
          }
          for (;;)
          {
            try
            {
              if (!com.tencent.mm.compatible.util.d.qV(26)) {
                continue;
              }
              MMApplicationContext.getContext().startForegroundService((Intent)localObject);
              paramInt1 = 1;
            }
            catch (Exception paramIntent)
            {
              Log.printErrStackTrace("MicroMsg.ScreenCastActivity", (Throwable)paramIntent, "using start service to bindVoipForegroundIfNeed error: %s", new Object[] { paramIntent.getMessage() });
              try
              {
                if (com.tencent.mm.compatible.util.d.qV(26))
                {
                  MMApplicationContext.getContext().startForegroundService((Intent)localObject);
                  paramInt1 = 0;
                  continue;
                }
                MMApplicationContext.getContext().startService((Intent)localObject);
                paramInt1 = 0;
              }
              catch (Exception paramIntent)
              {
                Log.printErrStackTrace("MicroMsg.ScreenCastActivity", (Throwable)paramIntent, "using start foreground service to bindVoipForegroundIfNeed error: %s", new Object[] { paramIntent.getMessage() });
                paramInt1 = 0;
              }
              continue;
            }
            if (paramInt1 != 0) {
              this.tKK = true;
            }
            initView();
            Log.i("MicroMsg.ScreenCastActivity", "Started screen recording");
            AppMethodBeat.o(189747);
            return;
            MMApplicationContext.getContext().startService((Intent)localObject);
          }
        }
        AppMethodBeat.o(189747);
        return;
      }
      Log.i("MicroMsg.ScreenCastActivity", "User cancelled");
      paramIntent = com.tencent.mm.plugin.cast.g.a.tKa;
      com.tencent.mm.plugin.cast.g.a.cLJ();
      paramIntent = PluginCast.tIg;
      paramIntent = PluginCast.a.cLu();
      if (paramIntent != null) {
        paramIntent.tJr = false;
      }
      paramIntent = PluginCast.tIg;
      paramIntent = PluginCast.a.cLu();
      if (paramIntent != null) {
        paramIntent.stopRecord();
      }
      initView();
    }
    AppMethodBeat.o(189747);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(189714);
    super.onCreate(paramBundle);
    paramBundle = z.bdh();
    p.j(paramBundle, "ConfigStorageLogic.getMyFinderUsername()");
    int i;
    if (((CharSequence)paramBundle).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label161;
      }
      paramBundle = new d.a((Context)getContext());
      paramBundle.bBd(getContext().getString(b.g.tIx));
      paramBundle.HG(false);
      paramBundle.ayj(b.g.tIC).c((DialogInterface.OnClickListener)new d(this));
      paramBundle.icu().show();
      paramBundle = com.tencent.mm.plugin.cast.g.a.tKa;
      com.tencent.mm.plugin.cast.g.a.cLE();
    }
    for (;;)
    {
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      setActionbarColor(getResources().getColor(b.b.BG_2));
      overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
      AppMethodBeat.o(189714);
      return;
      i = 0;
      break;
      label161:
      paramBundle = com.tencent.mm.plugin.cast.i.e.tKY;
      if (com.tencent.mm.plugin.cast.i.e.cMh())
      {
        paramBundle = new d.a((Context)getContext());
        paramBundle.bBd(getContext().getString(b.g.tIw));
        paramBundle.HG(false);
        paramBundle.ayj(b.g.tIC).c((DialogInterface.OnClickListener)new e(this));
        paramBundle.icu().show();
      }
      else
      {
        paramBundle = PluginCast.tIg;
        paramBundle = PluginCast.a.cLu();
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.tJj;; paramBundle = null)
        {
          if (paramBundle != null) {
            break label272;
          }
          finish();
          break;
        }
        label272:
        paramBundle = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLD();
        initView();
      }
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 1;
    AppMethodBeat.i(189753);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt == this.tKJ)
    {
      if (paramArrayOfInt.length != 0) {
        break label73;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label78;
      }
    }
    label73:
    label78:
    for (paramInt = i;; paramInt = 0)
    {
      if ((paramInt != 0) && (paramArrayOfInt[0] == 0)) {
        cLX();
      }
      AppMethodBeat.o(189753);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$2$1"})
  static final class b
    implements View.OnClickListener
  {
    b(ScreenCastActivity paramScreenCastActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(189392);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.tKN.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(189392);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ScreenCastActivity paramScreenCastActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190607);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = PluginCast.tIg;
      paramView = PluginCast.a.cLu();
      if (paramView != null)
      {
        paramView = paramView.tJy;
        if (paramView != null) {
          break label87;
        }
        paramView = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLH();
        ScreenCastActivity.j(this.tKN);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190607);
        return;
        label87:
        switch (a.jLJ[paramView.ordinal()])
        {
        case 2: 
        default: 
          break;
        case 1: 
          paramView = new com.tencent.mm.ui.widget.a.e((Context)this.tKN, 1, true);
          paramView.a((q.f)new a(this));
          paramView.a((q.g)new b(this));
          paramView.eik();
          break;
        case 3: 
          paramView = ScreenCastActivity.f(this.tKN);
          if (paramView != null) {
            paramView.setText((CharSequence)this.tKN.getString(b.g.tIC));
          }
          paramView = ScreenCastActivity.f(this.tKN);
          if (paramView != null) {
            paramView.setOnClickListener((View.OnClickListener)new c(this));
          }
          break;
        case 4: 
        case 5: 
          paramView = com.tencent.mm.plugin.cast.g.a.tKa;
          com.tencent.mm.plugin.cast.g.a.cLI();
          if (!ScreenCastActivity.i(this.tKN))
          {
            paramView = ScreenCastActivity.f(this.tKN);
            if (paramView != null) {
              paramView.setText((CharSequence)this.tKN.getString(b.g.tIC));
            }
            paramView = ScreenCastActivity.f(this.tKN);
            if (paramView != null) {
              paramView.setOnClickListener((View.OnClickListener)new d(this));
            }
          }
          else
          {
            Log.i("MicroMsg.ScreenCastActivity", "error happened");
          }
          break;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1$1$1"})
    static final class a
      implements q.f
    {
      a(ScreenCastActivity.c paramc) {}
      
      public final void onCreateMMMenu(o paramo)
      {
        AppMethodBeat.i(190320);
        paramo.a(0, this.tKO.tKN.getResources().getColor(b.b.red), (CharSequence)this.tKO.tKN.getResources().getString(b.g.tIH));
        AppMethodBeat.o(190320);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1$1$2"})
    static final class b
      implements q.g
    {
      b(ScreenCastActivity.c paramc) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(190720);
        p.j(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(190720);
          return;
          ScreenCastActivity.h(this.tKO.tKN);
          this.tKO.tKN.initView();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1$1$3"})
    static final class c
      implements View.OnClickListener
    {
      c(ScreenCastActivity.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(190565);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1$$special$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.tKO.tKN.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1$$special$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190565);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1$1$4"})
    static final class d
      implements View.OnClickListener
    {
      d(ScreenCastActivity.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(190345);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1$$special$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.tKO.tKN.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$initBtnListener$1$$special$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190345);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(ScreenCastActivity paramScreenCastActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(190313);
      paramDialogInterface.dismiss();
      this.tKN.finish();
      AppMethodBeat.o(190313);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(ScreenCastActivity paramScreenCastActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(189609);
      paramDialogInterface.dismiss();
      this.tKN.finish();
      AppMethodBeat.o(189609);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.cast.h.a.b, x>
  {
    f(ScreenCastActivity paramScreenCastActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ScreenCastActivity paramScreenCastActivity, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(190795);
      ScreenCastActivity.a(this.tKN);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(190795);
        return;
        Object localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.icons_outlined_wifi, Color.parseColor("#1AAD19")));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#1AAD19"));
        }
        localObject = ScreenCastActivity.d(this.tKN);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tKN.getResources().getString(b.g.tIy));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.g(this.tKN);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        localObject = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLO();
        AppMethodBeat.o(190795);
        return;
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.icons_outlined_wifi, Color.parseColor("#1AAD19")));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#1AAD19"));
        }
        localObject = ScreenCastActivity.d(this.tKN);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tKN.getResources().getString(b.g.tIF));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.g(this.tKN);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setText((CharSequence)this.tKN.getString(b.g.tIG));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setTextColor(this.tKN.getResources().getColor(b.b.BG_0));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null)
        {
          ((Button)localObject).setBackground(this.tKN.getDrawable(b.c.btn_solid_green));
          AppMethodBeat.o(190795);
          return;
        }
        AppMethodBeat.o(190795);
        return;
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.pc_connect_succ, Color.parseColor("#1AAD19")));
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#1AAD19"));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.icons_outlined_wifi, Color.parseColor("#1AAD19")));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#1AAD19"));
        }
        localObject = ScreenCastActivity.d(this.tKN);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tKN.getResources().getString(b.g.tID));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.g(this.tKN);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setText((CharSequence)this.tKN.getString(b.g.tIH));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setTextColor(this.tKN.getResources().getColor(b.b.Brand));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null)
        {
          ((Button)localObject).setBackground(this.tKN.getDrawable(b.c.btn_solid_white));
          AppMethodBeat.o(190795);
          return;
        }
        AppMethodBeat.o(190795);
        return;
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.d(this.tKN);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tKN.getResources().getString(b.g.tIt));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.g(this.tKN);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setText((CharSequence)this.tKN.getString(b.g.tIB));
        }
        localObject = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLM();
        AppMethodBeat.o(190795);
        return;
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.d(this.tKN);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tKN.getResources().getString(b.g.tIu));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.g(this.tKN);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        localObject = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLL();
        AppMethodBeat.o(190795);
        return;
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.d(this.tKN);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tKN.getResources().getString(b.g.tIz));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.g(this.tKN);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLT();
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setText((CharSequence)this.tKN.getString(b.g.tIC));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null)
        {
          ((Button)localObject).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(189506);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/ui/ScreenCastActivity$switchIconStatus$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              this.tKP.tKN.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$switchIconStatus$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(189506);
            }
          });
          AppMethodBeat.o(190795);
          return;
        }
        AppMethodBeat.o(190795);
        return;
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.d(this.tKN);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tKN.getResources().getString(b.g.tIA));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.g(this.tKN);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLT();
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setText((CharSequence)this.tKN.getString(b.g.tIC));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null)
        {
          ((Button)localObject).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(190828);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/ui/ScreenCastActivity$switchIconStatus$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              this.tKP.tKN.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/cast/ui/ScreenCastActivity$switchIconStatus$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(190828);
            }
          });
          AppMethodBeat.o(190795);
          return;
        }
        AppMethodBeat.o(190795);
        return;
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(au.o((Context)this.tKN.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
        }
        localObject = ScreenCastActivity.b(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
        }
        localObject = ScreenCastActivity.c(this.tKN);
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.d(this.tKN);
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.e(this.tKN);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.tKN.getResources().getString(b.g.tIv));
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.g(this.tKN);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = ScreenCastActivity.f(this.tKN);
        if (localObject != null) {
          ((Button)localObject).setText((CharSequence)this.tKN.getString(b.g.tIB));
        }
        localObject = com.tencent.mm.plugin.cast.g.a.tKa;
        com.tencent.mm.plugin.cast.g.a.cLN();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.ui.ScreenCastActivity
 * JD-Core Version:    0.7.0.1
 */