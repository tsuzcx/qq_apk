package com.tencent.mm.plugin.cast.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.util.d;
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
import com.tencent.mm.plugin.cast.c.a.e;
import com.tencent.mm.plugin.cast.service.ScreenCastForegroundService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/ui/ScreenCastActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCREEN_CAST_REQUEST_CODE", "", "connectingLoadingIv", "Landroid/widget/ProgressBar;", "mDetailTv", "Landroid/widget/TextView;", "mIsBindVoipForegroundService", "", "mStartBtn", "Landroid/widget/Button;", "mStartBtnBg", "Landroid/view/View;", "mTitle", "pcStatus", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "phoneStatus", "retryTimes", "bindScreenCastForegroundIfNeed", "", "data", "Landroid/content/Intent;", "resultCode", "getLayoutId", "initBtnListener", "initView", "onActivityResult", "requestCode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onScreenCastEventResponse", "status", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;", "requestPermissionList", "retryTcpConnect", "simulateHome", "startScreenRecording", "stopScreenRecording", "switchIconStatus", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScreenCastActivity
  extends MMActivity
  implements com.tencent.mm.am.h
{
  public static final ScreenCastActivity.a wNW;
  private int oQk;
  private TextView pIp;
  private Button wNX;
  private View wNY;
  private WeImageView wNZ;
  private WeImageView wOa;
  private TextView wOb;
  private ProgressBar wOc;
  private final int wOd = 1000;
  private boolean wOe;
  
  static
  {
    AppMethodBeat.i(274265);
    wNW = new ScreenCastActivity.a((byte)0);
    AppMethodBeat.o(274265);
  }
  
  private final void IU(int paramInt)
  {
    AppMethodBeat.i(274120);
    Log.i("MicroMsg.ScreenCastActivity", kotlin.g.b.s.X("switchIconStatus status is ", Integer.valueOf(paramInt)));
    com.tencent.threadpool.h.ahAA.bk(new ScreenCastActivity..ExternalSyntheticLambda10(this, paramInt));
    AppMethodBeat.o(274120);
  }
  
  private static final void a(ScreenCastActivity paramScreenCastActivity, int paramInt)
  {
    AppMethodBeat.i(274191);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramScreenCastActivity.dpB();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(274191);
      return;
      Object localObject = paramScreenCastActivity.wNZ;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      localObject = paramScreenCastActivity.wOa;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = paramScreenCastActivity.wOa;
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.icons_outlined_wifi, Color.parseColor("#1AAD19")));
      }
      localObject = paramScreenCastActivity.wOa;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(Color.parseColor("#1AAD19"));
      }
      localObject = paramScreenCastActivity.wOc;
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(0);
      }
      localObject = paramScreenCastActivity.pIp;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = paramScreenCastActivity.pIp;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMg));
      }
      localObject = paramScreenCastActivity.wNX;
      if (localObject != null) {
        ((Button)localObject).setVisibility(8);
      }
      paramScreenCastActivity = paramScreenCastActivity.wNY;
      if (paramScreenCastActivity != null) {
        paramScreenCastActivity.setVisibility(8);
      }
      paramScreenCastActivity = com.tencent.mm.plugin.cast.f.a.wNt;
      com.tencent.mm.plugin.cast.f.a.dpu();
      AppMethodBeat.o(274191);
      return;
      localObject = paramScreenCastActivity.wNZ;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      localObject = paramScreenCastActivity.wOa;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = paramScreenCastActivity.wOa;
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.icons_outlined_wifi, Color.parseColor("#1AAD19")));
      }
      localObject = paramScreenCastActivity.wOa;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(Color.parseColor("#1AAD19"));
      }
      localObject = paramScreenCastActivity.wOc;
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
      localObject = paramScreenCastActivity.pIp;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = paramScreenCastActivity.pIp;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMn));
      }
      localObject = paramScreenCastActivity.wNX;
      if (localObject != null) {
        ((Button)localObject).setVisibility(0);
      }
      localObject = paramScreenCastActivity.wNY;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = paramScreenCastActivity.wNX;
      if (localObject != null) {
        ((Button)localObject).setText((CharSequence)paramScreenCastActivity.getString(b.g.wMo));
      }
      localObject = paramScreenCastActivity.wNX;
      if (localObject != null) {
        ((Button)localObject).setTextColor(paramScreenCastActivity.getResources().getColor(b.b.BG_0));
      }
      localObject = paramScreenCastActivity.wNX;
      if (localObject != null)
      {
        ((Button)localObject).setBackground(paramScreenCastActivity.getDrawable(b.c.btn_solid_green));
        AppMethodBeat.o(274191);
        return;
        localObject = paramScreenCastActivity.wNZ;
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = paramScreenCastActivity.wNZ;
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.pc_connect_succ, Color.parseColor("#1AAD19")));
        }
        localObject = paramScreenCastActivity.wNZ;
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#1AAD19"));
        }
        localObject = paramScreenCastActivity.wOa;
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = paramScreenCastActivity.wOa;
        if (localObject != null) {
          ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.icons_outlined_wifi, Color.parseColor("#1AAD19")));
        }
        localObject = paramScreenCastActivity.wOa;
        if (localObject != null) {
          ((WeImageView)localObject).setIconColor(Color.parseColor("#1AAD19"));
        }
        localObject = paramScreenCastActivity.wOc;
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
        localObject = paramScreenCastActivity.pIp;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = paramScreenCastActivity.pIp;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMl));
        }
        localObject = paramScreenCastActivity.wNX;
        if (localObject != null) {
          ((Button)localObject).setVisibility(0);
        }
        localObject = paramScreenCastActivity.wNY;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = paramScreenCastActivity.wNX;
        if (localObject != null) {
          ((Button)localObject).setText((CharSequence)paramScreenCastActivity.getString(b.g.wMp));
        }
        localObject = paramScreenCastActivity.wNX;
        if (localObject != null) {
          ((Button)localObject).setTextColor(paramScreenCastActivity.getResources().getColor(b.b.Brand));
        }
        localObject = paramScreenCastActivity.wNX;
        if (localObject != null)
        {
          ((Button)localObject).setBackground(paramScreenCastActivity.getDrawable(b.c.btn_solid_white));
          AppMethodBeat.o(274191);
          return;
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
          }
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
          }
          localObject = paramScreenCastActivity.wOa;
          if (localObject != null) {
            ((WeImageView)localObject).setVisibility(8);
          }
          localObject = paramScreenCastActivity.wOc;
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(8);
          }
          localObject = paramScreenCastActivity.pIp;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.pIp;
          if (localObject != null) {
            ((TextView)localObject).setText((CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMb));
          }
          localObject = paramScreenCastActivity.wNX;
          if (localObject != null) {
            ((Button)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.wNY;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.wNX;
          if (localObject != null) {
            ((Button)localObject).setText((CharSequence)paramScreenCastActivity.getString(b.g.wMj));
          }
          paramScreenCastActivity = com.tencent.mm.plugin.cast.f.a.wNt;
          com.tencent.mm.plugin.cast.f.a.dps();
          AppMethodBeat.o(274191);
          return;
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
          }
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
          }
          localObject = paramScreenCastActivity.wOa;
          if (localObject != null) {
            ((WeImageView)localObject).setVisibility(8);
          }
          localObject = paramScreenCastActivity.wOc;
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(8);
          }
          localObject = paramScreenCastActivity.pIp;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.pIp;
          if (localObject != null) {
            ((TextView)localObject).setText((CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMc));
          }
          localObject = paramScreenCastActivity.wNX;
          if (localObject != null) {
            ((Button)localObject).setVisibility(8);
          }
          paramScreenCastActivity = paramScreenCastActivity.wNY;
          if (paramScreenCastActivity != null) {
            paramScreenCastActivity.setVisibility(8);
          }
          paramScreenCastActivity = com.tencent.mm.plugin.cast.f.a.wNt;
          com.tencent.mm.plugin.cast.f.a.dpr();
          AppMethodBeat.o(274191);
          return;
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
          }
          localObject = paramScreenCastActivity.wNZ;
          if (localObject != null) {
            ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
          }
          localObject = paramScreenCastActivity.wOa;
          if (localObject != null) {
            ((WeImageView)localObject).setVisibility(8);
          }
          localObject = paramScreenCastActivity.wOc;
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(8);
          }
          localObject = paramScreenCastActivity.pIp;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.pIp;
          if (localObject != null) {
            ((TextView)localObject).setText((CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMh));
          }
          localObject = paramScreenCastActivity.wNX;
          if (localObject != null) {
            ((Button)localObject).setVisibility(0);
          }
          localObject = paramScreenCastActivity.wNY;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          localObject = com.tencent.mm.plugin.cast.f.a.wNt;
          com.tencent.mm.plugin.cast.f.a.dpz();
          localObject = paramScreenCastActivity.wNX;
          if (localObject != null) {
            ((Button)localObject).setText((CharSequence)paramScreenCastActivity.getString(b.g.wMk));
          }
          localObject = paramScreenCastActivity.wNX;
          if (localObject != null)
          {
            ((Button)localObject).setOnClickListener(new ScreenCastActivity..ExternalSyntheticLambda5(paramScreenCastActivity));
            AppMethodBeat.o(274191);
            return;
            localObject = paramScreenCastActivity.wNZ;
            if (localObject != null) {
              ((WeImageView)localObject).setVisibility(0);
            }
            localObject = paramScreenCastActivity.wNZ;
            if (localObject != null) {
              ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
            }
            localObject = paramScreenCastActivity.wNZ;
            if (localObject != null) {
              ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
            }
            localObject = paramScreenCastActivity.wOa;
            if (localObject != null) {
              ((WeImageView)localObject).setVisibility(8);
            }
            localObject = paramScreenCastActivity.wOc;
            if (localObject != null) {
              ((ProgressBar)localObject).setVisibility(8);
            }
            localObject = paramScreenCastActivity.pIp;
            if (localObject != null) {
              ((TextView)localObject).setVisibility(0);
            }
            localObject = paramScreenCastActivity.pIp;
            if (localObject != null) {
              ((TextView)localObject).setText((CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMi));
            }
            localObject = paramScreenCastActivity.wNX;
            if (localObject != null) {
              ((Button)localObject).setVisibility(0);
            }
            localObject = paramScreenCastActivity.wNY;
            if (localObject != null) {
              ((View)localObject).setVisibility(0);
            }
            localObject = com.tencent.mm.plugin.cast.f.a.wNt;
            com.tencent.mm.plugin.cast.f.a.dpz();
            localObject = paramScreenCastActivity.wNX;
            if (localObject != null) {
              ((Button)localObject).setText((CharSequence)paramScreenCastActivity.getString(b.g.wMk));
            }
            localObject = paramScreenCastActivity.wNX;
            if (localObject != null)
            {
              ((Button)localObject).setOnClickListener(new ScreenCastActivity..ExternalSyntheticLambda2(paramScreenCastActivity));
              AppMethodBeat.o(274191);
              return;
              localObject = paramScreenCastActivity.wNZ;
              if (localObject != null) {
                ((WeImageView)localObject).setVisibility(0);
              }
              localObject = paramScreenCastActivity.wNZ;
              if (localObject != null) {
                ((WeImageView)localObject).setImageDrawable(bb.m((Context)paramScreenCastActivity.getContext(), b.f.on_error_info, Color.parseColor("#FA5151")));
              }
              localObject = paramScreenCastActivity.wNZ;
              if (localObject != null) {
                ((WeImageView)localObject).setIconColor(Color.parseColor("#FA5151"));
              }
              localObject = paramScreenCastActivity.wOa;
              if (localObject != null) {
                ((WeImageView)localObject).setVisibility(8);
              }
              localObject = paramScreenCastActivity.wOc;
              if (localObject != null) {
                ((ProgressBar)localObject).setVisibility(8);
              }
              localObject = paramScreenCastActivity.pIp;
              if (localObject != null) {
                ((TextView)localObject).setVisibility(0);
              }
              localObject = paramScreenCastActivity.pIp;
              if (localObject != null) {
                ((TextView)localObject).setText((CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMd));
              }
              localObject = paramScreenCastActivity.wNX;
              if (localObject != null) {
                ((Button)localObject).setVisibility(0);
              }
              localObject = paramScreenCastActivity.wNY;
              if (localObject != null) {
                ((View)localObject).setVisibility(0);
              }
              localObject = paramScreenCastActivity.wNX;
              if (localObject != null) {
                ((Button)localObject).setText((CharSequence)paramScreenCastActivity.getString(b.g.wMj));
              }
              paramScreenCastActivity = com.tencent.mm.plugin.cast.f.a.wNt;
              com.tencent.mm.plugin.cast.f.a.dpt();
            }
          }
        }
      }
    }
  }
  
  private static final void a(ScreenCastActivity paramScreenCastActivity, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(274153);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramDialogInterface.dismiss();
    paramScreenCastActivity.finish();
    AppMethodBeat.o(274153);
  }
  
  private static final void a(ScreenCastActivity paramScreenCastActivity, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(274207);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    if (paramMenuItem.getItemId() == 0)
    {
      paramScreenCastActivity.dpE();
      paramScreenCastActivity.initView();
    }
    AppMethodBeat.o(274207);
  }
  
  private static final void a(ScreenCastActivity paramScreenCastActivity, View paramView)
  {
    AppMethodBeat.i(274164);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramScreenCastActivity.finish();
    AppMethodBeat.o(274164);
  }
  
  private static final void a(ScreenCastActivity paramScreenCastActivity, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(274197);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    params.a(0, paramScreenCastActivity.getResources().getColor(b.b.red), (CharSequence)paramScreenCastActivity.getResources().getString(b.g.wMp));
    AppMethodBeat.o(274197);
  }
  
  private static final void b(ScreenCastActivity paramScreenCastActivity, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(274159);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramDialogInterface.dismiss();
    paramScreenCastActivity.finish();
    AppMethodBeat.o(274159);
  }
  
  private static final void b(ScreenCastActivity paramScreenCastActivity, View paramView)
  {
    AppMethodBeat.i(274169);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramScreenCastActivity.finish();
    AppMethodBeat.o(274169);
  }
  
  private static final void c(ScreenCastActivity paramScreenCastActivity, View paramView)
  {
    AppMethodBeat.i(274216);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramScreenCastActivity.finish();
    AppMethodBeat.o(274216);
  }
  
  private static final void d(ScreenCastActivity paramScreenCastActivity, View paramView)
  {
    AppMethodBeat.i(274223);
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramScreenCastActivity.finish();
    AppMethodBeat.o(274223);
  }
  
  private final void dpB()
  {
    AppMethodBeat.i(274128);
    Object localObject = this.wNX;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(new ScreenCastActivity..ExternalSyntheticLambda7(this));
    }
    localObject = findViewById(b.d.wLW);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new ScreenCastActivity..ExternalSyntheticLambda4(this));
    }
    AppMethodBeat.o(274128);
  }
  
  private final boolean dpC()
  {
    AppMethodBeat.i(274133);
    if (com.tencent.mm.pluginsdk.permission.b.a((Activity)this, new String[] { "android.permission.RECORD_AUDIO" }, 148, ""))
    {
      AppMethodBeat.o(274133);
      return true;
    }
    AppMethodBeat.o(274133);
    return false;
  }
  
  private final void dpD()
  {
    AppMethodBeat.i(274143);
    if (dpC())
    {
      Object localObject = PluginCast.wLM;
      localObject = PluginCast.a.dpb();
      if (localObject != null) {
        ((com.tencent.mm.plugin.cast.c.a)localObject).ae((kotlin.g.a.b)new c(this));
      }
    }
    AppMethodBeat.o(274143);
  }
  
  private final void dpE()
  {
    AppMethodBeat.i(274148);
    stopService(new Intent((Context)this, ScreenCastForegroundService.class));
    this.wOe = false;
    Object localObject = PluginCast.wLM;
    localObject = PluginCast.a.dpb();
    if (localObject != null) {
      ((com.tencent.mm.plugin.cast.c.a)localObject).stopRecord();
    }
    AppMethodBeat.o(274148);
  }
  
  private static final void e(ScreenCastActivity paramScreenCastActivity, View paramView)
  {
    int j = 0;
    AppMethodBeat.i(274241);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramScreenCastActivity);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/ui/ScreenCastActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramView = PluginCast.wLM;
    paramView = PluginCast.a.dpb();
    int i;
    if (paramView != null)
    {
      paramView = paramView.wNb;
      if (paramView != null) {
        break label168;
      }
      i = -1;
      switch (i)
      {
      case 2: 
      default: 
        paramView = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.dpn();
        paramScreenCastActivity.dpD();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/cast/ui/ScreenCastActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274241);
      return;
      label168:
      i = b.$EnumSwitchMapping$0[paramView.ordinal()];
      break;
      paramView = new f((Context)paramScreenCastActivity, 1, true);
      paramView.Vtg = new ScreenCastActivity..ExternalSyntheticLambda8(paramScreenCastActivity);
      paramView.GAC = new ScreenCastActivity..ExternalSyntheticLambda9(paramScreenCastActivity);
      paramView.dDn();
      continue;
      paramView = paramScreenCastActivity.wNX;
      if (paramView != null) {
        paramView.setText((CharSequence)paramScreenCastActivity.getString(b.g.wMk));
      }
      paramView = paramScreenCastActivity.wNX;
      if (paramView != null)
      {
        paramView.setOnClickListener(new ScreenCastActivity..ExternalSyntheticLambda6(paramScreenCastActivity));
        continue;
        paramView = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.dpo();
        paramScreenCastActivity.oQk += 1;
        i = j;
        label344:
        label358:
        label365:
        String str;
        if (paramScreenCastActivity.oQk < 5)
        {
          paramView = PluginCast.wLM;
          localObject2 = PluginCast.a.dpb();
          if (localObject2 != null)
          {
            Log.i("MicroMsg.ScreenCastManager", kotlin.g.b.s.X("retryConnect ", ((com.tencent.mm.plugin.cast.c.a)localObject2).wMM));
            localObject1 = ((com.tencent.mm.plugin.cast.c.a)localObject2).wMM;
            if (localObject1 != null) {
              break label526;
            }
            paramView = null;
            if ((paramView == null) || (((com.tencent.mm.plugin.cast.a.b)localObject1).wMv == null)) {
              break label535;
            }
            i = 1;
            if (i == 0) {
              break label540;
            }
            paramView = (View)localObject1;
            if (paramView != null)
            {
              Log.i("MicroMsg.ScreenCastManager", "remote pc addr: " + paramView.wMv + ':' + paramView.wMw + "local phone is " + com.tencent.mm.plugin.cast.h.b.dpG());
              localObject1 = ((com.tencent.mm.plugin.cast.c.a)localObject2).wNa;
              if (localObject1 != null)
              {
                str = paramView.wMv;
                kotlin.g.b.s.checkNotNull(str);
                paramView = paramView.wMw;
                if (paramView != null) {
                  break label545;
                }
              }
            }
          }
        }
        label526:
        label535:
        label540:
        label545:
        for (i = 0;; i = paramView.intValue())
        {
          ((com.tencent.mm.plugin.cast.g.b)localObject1).a(str, i, (com.tencent.mm.plugin.cast.g.a)new a.e((com.tencent.mm.plugin.cast.c.a)localObject2));
          i = 1;
          if (i != 0) {
            break label553;
          }
          paramView = paramScreenCastActivity.wNX;
          if (paramView != null) {
            paramView.setText((CharSequence)paramScreenCastActivity.getString(b.g.wMk));
          }
          paramView = paramScreenCastActivity.wNX;
          if (paramView == null) {
            break;
          }
          paramView.setOnClickListener(new ScreenCastActivity..ExternalSyntheticLambda3(paramScreenCastActivity));
          break;
          paramView = ((com.tencent.mm.plugin.cast.a.b)localObject1).wMw;
          break label344;
          i = 0;
          break label358;
          paramView = null;
          break label365;
        }
        label553:
        Log.i("MicroMsg.ScreenCastActivity", "error happened");
      }
    }
  }
  
  private static final void f(ScreenCastActivity paramScreenCastActivity, View paramView)
  {
    AppMethodBeat.i(274247);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramScreenCastActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/cast/ui/ScreenCastActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramScreenCastActivity, "this$0");
    paramScreenCastActivity.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/cast/ui/ScreenCastActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274247);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.e.wMa;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(274321);
    super.initView();
    this.wNZ = ((WeImageView)findViewById(b.d.wLU));
    this.wOa = ((WeImageView)findViewById(b.d.wLV));
    this.wOc = ((ProgressBar)findViewById(b.d.wLT));
    this.wNX = ((Button)findViewById(b.d.wLX));
    this.wNY = ((View)findViewById(b.d.wLY));
    this.wOb = ((TextView)findViewById(b.d.detail_tv));
    this.pIp = ((TextView)findViewById(b.d.fYg));
    dpB();
    Object localObject1 = PluginCast.wLM;
    localObject1 = PluginCast.a.dpb();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label325;
      }
      switch (b.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = PluginCast.wLM;
        localObject1 = PluginCast.a.dpb();
        if ((localObject1 == null) || (((com.tencent.mm.plugin.cast.c.a)localObject1).wMU)) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label313;
      }
      localObject1 = this.pIp;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)getString(b.g.wMn));
      }
      IU(3);
      AppMethodBeat.o(274321);
      return;
      localObject1 = ((com.tencent.mm.plugin.cast.c.a)localObject1).wNb;
      break;
      IU(4);
      AppMethodBeat.o(274321);
      return;
      IU(3);
      dpE();
      AppMethodBeat.o(274321);
      return;
      Log.i("MicroMsg.ScreenCastActivity", "trans to pc ERROR");
      IU(5);
      AppMethodBeat.o(274321);
      return;
      Log.i("MicroMsg.ScreenCastActivity", "trans to pc timeout");
      IU(2);
      AppMethodBeat.o(274321);
      return;
    }
    label313:
    IU(4);
    AppMethodBeat.o(274321);
    return;
    label325:
    localObject1 = PluginCast.wLM;
    localObject1 = PluginCast.a.dpb();
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = PluginCast.wLM;
      localObject3 = PluginCast.a.dpb();
      if (localObject3 != null) {
        break label401;
      }
    }
    for (;;)
    {
      if (kotlin.g.b.s.p(localObject1, localObject2)) {
        break label422;
      }
      IU(6);
      dpE();
      AppMethodBeat.o(274321);
      return;
      localObject1 = ((com.tencent.mm.plugin.cast.c.a)localObject1).wMM;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.cast.a.b)localObject1).wMy;
      break;
      label401:
      localObject3 = ((com.tencent.mm.plugin.cast.c.a)localObject3).wMM;
      if (localObject3 != null) {
        localObject2 = ((com.tencent.mm.plugin.cast.a.b)localObject3).wMz;
      }
    }
    label422:
    IU(3);
    AppMethodBeat.o(274321);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(274325);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.wOd)
    {
      Object localObject;
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          this.wOe = false;
          localObject = PluginCast.wLM;
          localObject = PluginCast.a.dpb();
          if (localObject != null) {
            ((com.tencent.mm.plugin.cast.c.a)localObject).wMU = true;
          }
          Log.printInfoStack("MicroMsg.ScreenCastActivity", "bindScreenCastForegroundIfNeed", new Object[0]);
          if (!this.wOe)
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
              if (!d.rb(26)) {
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
                if (d.rb(26))
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
              this.wOe = true;
            }
            initView();
            Log.i("MicroMsg.ScreenCastActivity", "Started screen recording");
            AppMethodBeat.o(274325);
            return;
            MMApplicationContext.getContext().startService((Intent)localObject);
          }
        }
      }
      else
      {
        Log.i("MicroMsg.ScreenCastActivity", "User cancelled");
        paramIntent = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.dpp();
        paramIntent = PluginCast.wLM;
        paramIntent = PluginCast.a.dpb();
        if (paramIntent != null) {
          paramIntent.wMU = false;
        }
        paramIntent = PluginCast.wLM;
        paramIntent = PluginCast.a.dpb();
        if (paramIntent != null) {
          paramIntent.stopRecord();
        }
        initView();
      }
    }
    AppMethodBeat.o(274325);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(274320);
    super.onCreate(paramBundle);
    paramBundle = z.bAW();
    kotlin.g.b.s.s(paramBundle, "getMyFinderUsername()");
    int i;
    if (((CharSequence)paramBundle).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label158;
      }
      paramBundle = new e.a((Context)getContext());
      paramBundle.bDw(getContext().getString(b.g.wMf));
      paramBundle.NC(false);
      paramBundle.aER(b.g.wMk).c(new ScreenCastActivity..ExternalSyntheticLambda0(this));
      paramBundle.jHH().show();
      paramBundle = com.tencent.mm.plugin.cast.f.a.wNt;
      com.tencent.mm.plugin.cast.f.a.dpk();
    }
    for (;;)
    {
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      setActionbarColor(getResources().getColor(b.b.BG_2));
      overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
      AppMethodBeat.o(274320);
      return;
      i = 0;
      break;
      label158:
      paramBundle = com.tencent.mm.plugin.cast.h.e.wOn;
      if (com.tencent.mm.plugin.cast.h.e.dpL())
      {
        paramBundle = new e.a((Context)getContext());
        paramBundle.bDw(getContext().getString(b.g.wMe));
        paramBundle.NC(false);
        paramBundle.aER(b.g.wMk).c(new ScreenCastActivity..ExternalSyntheticLambda1(this));
        paramBundle.jHH().show();
      }
      else
      {
        paramBundle = PluginCast.wLM;
        paramBundle = PluginCast.a.dpb();
        if (paramBundle == null) {}
        for (paramBundle = null;; paramBundle = paramBundle.wMM)
        {
          if (paramBundle != null) {
            break label266;
          }
          finish();
          break;
        }
        label266:
        paramBundle = com.tencent.mm.plugin.cast.f.a.wNt;
        com.tencent.mm.plugin.cast.f.a.dpj();
        initView();
      }
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 1;
    AppMethodBeat.i(274326);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt == this.wOd)
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
        dpD();
      }
      AppMethodBeat.o(274326);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/cast/transportclient/connection/Status;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.cast.g.a.b, ah>
  {
    c(ScreenCastActivity paramScreenCastActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.ui.ScreenCastActivity
 * JD-Core Version:    0.7.0.1
 */