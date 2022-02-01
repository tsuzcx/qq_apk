package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ab;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.f;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSharePostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fromOpenSdk", "", "getFromOpenSdk", "()Z", "setFromOpenSdk", "(Z)V", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getShareData", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setShareData", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "tipsMask", "Landroid/view/View;", "getTipsMask", "()Landroid/view/View;", "setTipsMask", "(Landroid/view/View;)V", "wording", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "back", "", "checkPermission", "dealShare", "fallback", "errcode", "", "errMsg", "businessType", "appid", "getLayoutId", "getReportTag", "hasExtStatusFlag", "flag", "", "initMaskView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showTipsDialog", "showTipsToast", "plugin-finder_release"})
public final class FinderSharePostUI
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  s loadingDialog;
  private DialogInterface.OnCancelListener nbU;
  private String wording;
  View xSk;
  public ehy xSl;
  private boolean xSm;
  
  public FinderSharePostUI()
  {
    AppMethodBeat.i(239498);
    this.TAG = "Finder.FinderSharePostUI";
    String str = MMApplicationContext.getContext().getString(b.j.app_waiting);
    p.j(str, "MMApplicationContext.get…ing(R.string.app_waiting)");
    this.wording = str;
    AppMethodBeat.o(239498);
  }
  
  private final void MQ(final int paramInt)
  {
    AppMethodBeat.i(239488);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramInt));
    AppMethodBeat.o(239488);
  }
  
  private final void ckA()
  {
    AppMethodBeat.i(239487);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(239487);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(239517);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(239517);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(239514);
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
    AppMethodBeat.o(239514);
    return localView1;
  }
  
  public final ehy dvW()
  {
    AppMethodBeat.i(239480);
    ehy localehy = this.xSl;
    if (localehy == null) {
      p.bGy("shareData");
    }
    AppMethodBeat.o(239480);
    return localehy;
  }
  
  public final String dvl()
  {
    return this.TAG;
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(239491);
    p.k(paramString1, "errMsg");
    Log.i(this.TAG, "fallback errcode:" + paramInt + ", " + paramString1 + ", " + paramString3);
    if (!this.xSm)
    {
      ab localab = ab.AEA;
      ab.e(paramInt, paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(239491);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_share_post_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int m = 0;
    AppMethodBeat.i(239484);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    this.xSk = findViewById(b.f.mask_finder_entrance_hide_tips);
    paramBundle = (TextView)findViewById(b.f.finder_entrance_hide_tips_title);
    p.j(paramBundle, "titleTv");
    f.i(paramBundle);
    paramBundle = (TextView)findViewById(b.f.finder_entrance_hide_tips_btn);
    p.j(paramBundle, "okBtn");
    f.i(paramBundle);
    paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    this.nbU = ((DialogInterface.OnCancelListener)new e(this));
    this.loadingDialog = s.a((Context)getContext(), (CharSequence)this.wording, true, 0, this.nbU);
    paramBundle = (com.tencent.mm.cd.a)new ehy();
    byte[] arrayOfByte = getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE");
    try
    {
      paramBundle.parseFrom(arrayOfByte);
      paramBundle = (ehy)paramBundle;
      if (paramBundle != null)
      {
        this.xSl = paramBundle;
        paramBundle = this.xSl;
        if (paramBundle == null) {
          p.bGy("shareData");
        }
        paramBundle = paramBundle.UjV;
        if (paramBundle != null)
        {
          bool = paramBundle.xSm;
          this.xSm = bool;
          bool = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry();
          if ((z.bde() & 0x0) == 0L) {
            break label432;
          }
          i = 1;
          if (i != 0) {
            break label437;
          }
          j = 1;
          paramBundle = aj.AGc;
          i = aj.eei();
          paramBundle = com.tencent.mm.kernel.h.ae(ae.class);
          p.j(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
          if (!((ae)paramBundle).dYT())
          {
            paramBundle = com.tencent.mm.kernel.h.ae(ae.class);
            p.j(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((ae)paramBundle).dYV()) {
              break label442;
            }
          }
          k = 1;
          paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
          switch (((Number)com.tencent.mm.plugin.finder.storage.d.dTZ().aSr()).intValue())
          {
          default: 
            if (!bool)
            {
              MQ(b.j.finder_share_post_tips1);
              i = m;
              if (i == 0) {
                break label580;
              }
              com.tencent.mm.ae.d.h((kotlin.g.a.a)new f(this));
              AppMethodBeat.o(239484);
            }
            break;
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
        continue;
        boolean bool = false;
        continue;
        label432:
        int i = 0;
        continue;
        label437:
        int j = 0;
        continue;
        label442:
        int k = 0;
        continue;
        bool = false;
        continue;
        i = 1;
        continue;
        j = 0;
        continue;
        k = 1;
        continue;
        if (j == 0)
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this));
          i = m;
        }
        else if (i == 1)
        {
          MQ(b.j.finder_share_post_tips2);
          i = m;
        }
        else if (k != 0)
        {
          paramBundle = this.loadingDialog;
          if (paramBundle != null) {
            paramBundle.dismiss();
          }
          com.tencent.mm.ui.base.h.a((Context)getContext(), getResources().getString(b.j.finder_teen_mode_title_enable), "", false, (DialogInterface.OnClickListener)new b(this));
          i = m;
        }
        else
        {
          i = 1;
        }
      }
      ckA();
      label580:
      AppMethodBeat.o(239484);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setTipsMask(View paramView)
  {
    this.xSk = paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(FinderSharePostUI paramFinderSharePostUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(FinderSharePostUI paramFinderSharePostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(287680);
      paramDialogInterface = this.xSn.dvW().UjV;
      if (paramDialogInterface != null)
      {
        localObject = paramDialogInterface.businessType;
        paramDialogInterface = (DialogInterface)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramDialogInterface = "";
      }
      p.j(paramDialogInterface, "shareData.sdkPost?.businessType ?: \"\"");
      Object localObject = this.xSn.dvW().UjV;
      if (localObject != null)
      {
        String str = ((ead)localObject).appid;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      p.j(localObject, "shareData.sdkPost?.appid ?: \"\"");
      this.xSn.e(-6, "teenmode", paramDialogInterface, (String)localObject);
      this.xSn.finish();
      AppMethodBeat.o(287680);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(FinderSharePostUI paramFinderSharePostUI, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, aa.a parama, aa.f paramf, String paramString6, String paramString7)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSharePostUI paramFinderSharePostUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277371);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSharePostUI$initMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderSharePostUI.a(this.xSn);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSharePostUI$initMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277371);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(FinderSharePostUI paramFinderSharePostUI) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(264040);
      FinderSharePostUI.a(this.xSn);
      AppMethodBeat.o(264040);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(FinderSharePostUI paramFinderSharePostUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(FinderSharePostUI paramFinderSharePostUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(FinderSharePostUI paramFinderSharePostUI, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSharePostUI
 * JD-Core Version:    0.7.0.1
 */