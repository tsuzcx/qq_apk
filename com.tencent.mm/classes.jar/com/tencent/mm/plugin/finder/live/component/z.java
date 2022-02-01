package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cv;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "mAuthView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getMAuthView", "()Landroid/widget/ImageView;", "mAuthView$delegate", "Lkotlin/Lazy;", "mAvatarView", "getMAvatarView", "mAvatarView$delegate", "mDescView", "Landroid/widget/TextView;", "getMDescView", "()Landroid/widget/TextView;", "mDescView$delegate", "mNameView", "getMNameView", "mNameView$delegate", "mQrCodeRootView", "Landroid/view/View;", "getMQrCodeRootView", "()Landroid/view/View;", "mQrCodeRootView$delegate", "mQrCodeView", "getMQrCodeView", "mQrCodeView$delegate", "mTimeView", "getMTimeView", "mTimeView$delegate", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "doExportImg", "", "filePath", "", "doScene", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getLayoutId", "", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onQrCodeFailed", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showOrDimissLoading", "show", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "Companion", "plugin-finder_release"})
public final class z
  extends UIComponent
  implements com.tencent.mm.an.i
{
  private static final String ycq = "KEY_FINDER_LIVE_NOTICE_QR_CONTACT";
  private static final String ycr = "KEY_FINDER_LIVE_NOTICE_QR_INFO";
  public static final a ycs;
  private com.tencent.mm.plugin.finder.api.i contact;
  s oTk;
  private bbh xUD;
  private final f ycj;
  private final f yck;
  private final f ycl;
  private final f ycm;
  private final f ycn;
  private final f yco;
  private final f ycp;
  
  static
  {
    AppMethodBeat.i(291151);
    ycs = new a((byte)0);
    ycq = "KEY_FINDER_LIVE_NOTICE_QR_CONTACT";
    ycr = "KEY_FINDER_LIVE_NOTICE_QR_INFO";
    AppMethodBeat.o(291151);
  }
  
  public z(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291150);
    this.ycj = g.ar((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.yck = g.ar((kotlin.g.a.a)new g(paramAppCompatActivity));
    this.ycl = g.ar((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.ycm = g.ar((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.ycn = g.ar((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.yco = g.ar((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.ycp = g.ar((kotlin.g.a.a)new h(paramAppCompatActivity));
    AppMethodBeat.o(291150);
  }
  
  private final void a(final boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(291149);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new l(this, paramBoolean, paramOnCancelListener));
    AppMethodBeat.o(291149);
  }
  
  private final TextView dxH()
  {
    AppMethodBeat.i(291144);
    TextView localTextView = (TextView)this.ycm.getValue();
    AppMethodBeat.o(291144);
    return localTextView;
  }
  
  private final void dxI()
  {
    AppMethodBeat.i(291148);
    w.w((Context)getActivity(), getActivity().getResources().getString(b.j.finder_live_notice_qrcode_failed_toast), b.i.icons_filled_close);
    getActivity().finish();
    AppMethodBeat.o(291148);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_notice_qr_code_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291145);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getStringExtra(ycq);
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      this.contact = d.a.aAK(paramBundle);
    }
    paramBundle = getActivity().getIntent().getByteArrayExtra(ycr);
    if (paramBundle != null)
    {
      this.xUD = new bbh();
      localObject1 = this.xUD;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      ((bbh)localObject1).parseFrom(paramBundle);
    }
    paramBundle = this.contact;
    int i;
    if (paramBundle != null) {
      if (((CharSequence)paramBundle.getUsername()).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label515;
        }
        label118:
        if (paramBundle == null) {
          break label520;
        }
        localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject1 = com.tencent.mm.plugin.finder.loader.t.dJh();
        Object localObject2 = new e(paramBundle.Mm());
        Object localObject3 = (ImageView)this.ycj.getValue();
        kotlin.g.b.p.j(localObject3, "mAvatarView");
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
        localObject1 = (TextView)this.yck.getValue();
        kotlin.g.b.p.j(localObject1, "mNameView");
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)paramBundle.getNickname()));
        localObject1 = aj.AGc;
        localObject1 = (ImageView)this.ycl.getValue();
        kotlin.g.b.p.j(localObject1, "mAuthView");
        aj.a((ImageView)localObject1, paramBundle.field_authInfo);
        label260:
        paramBundle = this.xUD;
        if (paramBundle == null) {
          break label582;
        }
        localObject1 = paramBundle.fwt;
        if (localObject1 == null) {
          break label538;
        }
        if (((CharSequence)localObject1).length() <= 0) {
          break label533;
        }
        i = 1;
        label292:
        if (i != 1) {
          break label538;
        }
        i = 1;
        label299:
        if (i == 0) {
          break label543;
        }
        label303:
        if (paramBundle == null) {
          break label582;
        }
        localObject1 = paramBundle.SNb;
        if (localObject1 == null) {
          break label558;
        }
        kotlin.g.b.p.j(localObject1, "it");
        if (((CharSequence)localObject1).length() <= 0) {
          break label548;
        }
        i = 1;
        label337:
        if (i == 0) {
          break label553;
        }
        label341:
        if (localObject1 == null) {
          break label558;
        }
        localObject2 = dxH();
        kotlin.g.b.p.j(localObject2, "mDescView");
        ((TextView)localObject2).setVisibility(0);
        localObject2 = dxH();
        kotlin.g.b.p.j(localObject2, "mDescView");
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)localObject1));
        label401:
        localObject1 = (TextView)this.ycn.getValue();
        kotlin.g.b.p.j(localObject1, "mTimeView");
        localObject2 = getActivity().getResources();
        i = b.j.finder_live_notice_qrcode_time_desc;
        localObject3 = aj.AGc;
        ((TextView)localObject1).setText((CharSequence)((Resources)localObject2).getString(i, new Object[] { aj.Nj(paramBundle.fod * 1000L) }));
      }
    }
    for (;;)
    {
      h.aGY().a(4214, (com.tencent.mm.an.i)this);
      getRootView().post((Runnable)new k(this));
      AppMethodBeat.o(291145);
      return;
      i = 0;
      break;
      label515:
      paramBundle = null;
      break label118;
      label520:
      ((z)this).getActivity().finish();
      break label260;
      label533:
      i = 0;
      break label292;
      label538:
      i = 0;
      break label299;
      label543:
      paramBundle = null;
      break label303;
      label548:
      i = 0;
      break label337;
      label553:
      localObject1 = null;
      break label341;
      label558:
      localObject1 = ((z)this).dxH();
      kotlin.g.b.p.j(localObject1, "mDescView");
      ((TextView)localObject1).setVisibility(8);
      break label401;
      label582:
      ((z)this).getActivity().finish();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291146);
    super.onDestroy();
    h.aGY().b(4214, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(291146);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    Object localObject1 = null;
    AppMethodBeat.i(291147);
    a(false, null);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof cv)))
    {
      Object localObject2 = ((cv)paramq).dph();
      paramString = ((cv)paramq).dph().SNf;
      if (paramString != null) {}
      for (paramString = paramString.UH;; paramString = null)
      {
        paramString = BitmapUtil.decodeByteArray(paramString);
        Log.i("SimpleUIComponent", "qrcode url " + ((bbj)localObject2).RND);
        paramq = paramString;
        if (paramString == null)
        {
          if (!Util.isNullOrNil(((bbj)localObject2).RND))
          {
            localObject2 = ((bbj)localObject2).RND;
            kotlin.g.b.p.j(localObject2, "resp.QRCodeUrl");
            paramString = this.contact;
            if (paramString != null)
            {
              paramq = paramString.getUsername();
              paramString = paramq;
              if (paramq != null) {}
            }
            else
            {
              paramString = "";
            }
            paramString = com.tencent.mm.am.d.Tx(paramString);
            kotlin.g.b.p.j(paramString, "avatarBitmap");
            paramString = BitmapUtil.getRoundedCornerBitmap(paramString, false, 0.5F * paramString.getWidth());
            float f = aw.aZ((Context)getActivity(), b.d.Edge_7A);
            kotlin.g.b.p.j(paramString, "tempBitmap");
            f = f * 1.0F / paramString.getWidth();
            paramString = BitmapUtil.createLayerBitmap(BitmapUtil.rotateAndScale(paramString, 0.0F, f, f), BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(b.e.finder_round_avatar_bg)), true);
            paramString = com.tencent.mm.cf.a.a.b((Context)getActivity(), paramString, (String)localObject2);
          }
          paramq = x.aazN;
          paramq = paramString;
        }
        if (paramq != null)
        {
          ((ImageView)this.yco.getValue()).setImageBitmap(paramq);
          paramq = BitmapUtil.getBitmapFromView((View)this.ycp.getValue());
          paramString = localObject1;
          if (paramq != null)
          {
            paramString = av.AJz;
            paramString = av.egq();
            BitmapUtil.saveBitmapToImage(paramq, 80, Bitmap.CompressFormat.JPEG, paramString, true);
            com.tencent.mm.platformtools.p.a((Context)getActivity(), paramString, (p.a)new b(this));
            paramString = x.aazN;
          }
          if (paramString != null) {}
        }
        else
        {
          ((z)this).dxI();
          paramString = x.aazN;
        }
        AppMethodBeat.o(291147);
        return;
      }
    }
    dxI();
    AppMethodBeat.o(291147);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC$Companion;", "", "()V", "KEY_FINDER_LIVE_NOTICE_QR_CONTACT_USERNAME", "", "getKEY_FINDER_LIVE_NOTICE_QR_CONTACT_USERNAME", "()Ljava/lang/String;", "KEY_FINDER_LIVE_NOTICE_QR_INFO", "getKEY_FINDER_LIVE_NOTICE_QR_INFO", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"})
  public static final class b
    implements p.a
  {
    public final void bT(String paramString1, String paramString2)
    {
      AppMethodBeat.i(290690);
      kotlin.g.b.p.k(paramString1, "srcPath");
      kotlin.g.b.p.k(paramString2, "destPath");
      w.w((Context)this.yct.getActivity(), this.yct.getActivity().getResources().getString(b.j.finder_live_notice_qrcode_save_suc_toast), b.i.icons_filled_done);
      this.yct.getActivity().finish();
      AppMethodBeat.o(290690);
    }
    
    public final void bU(String paramString1, String paramString2)
    {
      AppMethodBeat.i(290691);
      kotlin.g.b.p.k(paramString1, "srcPath");
      kotlin.g.b.p.k(paramString2, "destPath");
      w.w((Context)this.yct.getActivity(), this.yct.getActivity().getResources().getString(b.j.finder_live_notice_qrcode_save_failed_toast), b.i.icons_filled_close);
      this.yct.getActivity().finish();
      AppMethodBeat.o(290691);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC$doScene$1", "Landroid/content/DialogInterface$OnCancelListener;", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "plugin-finder_release"})
  public static final class c
    implements DialogInterface.OnCancelListener
  {
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(291517);
      this.yct.getActivity().finish();
      AppMethodBeat.o(291517);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(z paramz) {}
    
    public final void run()
    {
      AppMethodBeat.i(286922);
      z.a(this.yct);
      AppMethodBeat.o(286922);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    l(z paramz, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.z
 * JD-Core Version:    0.7.0.1
 */