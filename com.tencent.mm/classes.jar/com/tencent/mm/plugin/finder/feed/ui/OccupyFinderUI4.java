package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getShareData", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setShareData", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "tipsMask", "Landroid/view/View;", "getTipsMask", "()Landroid/view/View;", "setTipsMask", "(Landroid/view/View;)V", "wording", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "back", "", "checkPermission", "", "dealShare", "getLayoutId", "", "hasExtStatusFlag", "flag", "", "initMaskView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showTipsDialog", "showTipsToast", "plugin-finder_release"})
public final class OccupyFinderUI4
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private String dQx;
  private DialogInterface.OnCancelListener kke;
  com.tencent.mm.ui.base.q loadingDialog;
  View ueH;
  public dxx ueI;
  
  public OccupyFinderUI4()
  {
    AppMethodBeat.i(245736);
    this.TAG = "Finder.FinderSharePostUI";
    String str = MMApplicationContext.getContext().getString(2131756029);
    p.g(str, "MMApplicationContext.get…ing(R.string.app_waiting)");
    this.dQx = str;
    AppMethodBeat.o(245736);
  }
  
  private final void IU(final int paramInt)
  {
    AppMethodBeat.i(245735);
    d.h((kotlin.g.a.a)new g(this, paramInt));
    AppMethodBeat.o(245735);
  }
  
  private final void back()
  {
    AppMethodBeat.i(245734);
    d.h((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(245734);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245740);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245740);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245739);
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
    AppMethodBeat.o(245739);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494631;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int k = 0;
    AppMethodBeat.i(245733);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    this.ueH = findViewById(2131304502);
    paramBundle = (TextView)findViewById(2131300811);
    p.g(paramBundle, "titleTv");
    e.n(paramBundle);
    paramBundle = (TextView)findViewById(2131300810);
    p.g(paramBundle, "okBtn");
    e.n(paramBundle);
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    this.kke = ((DialogInterface.OnCancelListener)new d(this));
    this.loadingDialog = com.tencent.mm.ui.base.q.a((Context)getContext(), (CharSequence)this.dQx, true, 0, this.kke);
    paramBundle = (com.tencent.mm.bw.a)new dxx();
    byte[] arrayOfByte = getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE");
    try
    {
      paramBundle.parseFrom(arrayOfByte);
      paramBundle = (dxx)paramBundle;
      if (paramBundle != null)
      {
        this.ueI = paramBundle;
        bool = ((aj)g.ah(aj.class)).showFinderEntry();
        if ((z.aUd() & 0x0) != 0L)
        {
          i = 1;
          if (i != 0) {
            break label335;
          }
          j = 1;
          paramBundle = y.vXH;
          i = y.dCL();
          paramBundle = c.vCb;
          switch (((Number)c.dsH().value()).intValue())
          {
          default: 
            if (!bool)
            {
              IU(2131760568);
              i = k;
              if (i == 0) {
                break label407;
              }
              d.i((kotlin.g.a.a)new e(this));
              AppMethodBeat.o(245733);
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
        int i = 0;
        continue;
        label335:
        int j = 0;
        continue;
        boolean bool = false;
        continue;
        i = 1;
        continue;
        j = 0;
        continue;
        if (j == 0)
        {
          d.h((kotlin.g.a.a)new f(this));
          i = k;
        }
        else if (i == 1)
        {
          IU(2131760571);
          i = k;
        }
        else
        {
          i = 1;
        }
      }
      back();
      label407:
      AppMethodBeat.o(245733);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setTipsMask(View paramView)
  {
    this.ueH = paramView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(OccupyFinderUI4 paramOccupyFinderUI4)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(OccupyFinderUI4 paramOccupyFinderUI4, String paramString1, int paramInt, String paramString2, z.f paramf, String paramString3, String paramString4)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(OccupyFinderUI4 paramOccupyFinderUI4) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245728);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4$initMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      OccupyFinderUI4.a(this.ueJ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4$initMaskView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245728);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(OccupyFinderUI4 paramOccupyFinderUI4) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(245729);
      OccupyFinderUI4.a(this.ueJ);
      AppMethodBeat.o(245729);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(OccupyFinderUI4 paramOccupyFinderUI4)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(OccupyFinderUI4 paramOccupyFinderUI4)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(OccupyFinderUI4 paramOccupyFinderUI4, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI4
 * JD-Core Version:    0.7.0.1
 */