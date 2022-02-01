package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.ah.x;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "writeCommentLayout", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWriteCommentLayout", "layout", "showHaoKanView", "update", "plugin-brandservice_release"})
public final class MPVideoHeaderView
  extends RelativeLayout
{
  private final String TAG;
  private ImageView fTj;
  private v oif;
  private x otY;
  private TextView ovA;
  private View ovB;
  private TextView ovC;
  private ImageView ovD;
  private View ovE;
  private n ovF;
  private boolean ovp;
  private b ovq;
  private LinearLayout ovr;
  private TextView ovs;
  private MMNeat7extView ovt;
  private MMNeat7extView ovu;
  private View ovv;
  private View ovw;
  private TextView ovx;
  private TextView ovy;
  private TextView ovz;
  private String talker;
  private TextView timeTv;
  
  public MPVideoHeaderView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7263);
    this.TAG = "MicroMsg.MPVideoHeaderView";
    this.talker = "";
    View.inflate(paramContext, 2131494954, (ViewGroup)this);
    paramAttributeSet = findViewById(2131297375);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_avatar_layout)");
    this.ovr = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131297374);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_avatar_iv)");
    this.fTj = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297396);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_nick_name_tv)");
    this.ovs = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297405);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_title_tv)");
    this.ovt = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297388);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_tv)");
    this.ovu = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297387);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_show_more_layout)");
    this.ovv = paramAttributeSet;
    paramAttributeSet = findViewById(2131297386);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_layout)");
    this.ovw = paramAttributeSet;
    paramAttributeSet = findViewById(2131297403);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_time_tv)");
    this.timeTv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297400);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_read_count_tv)");
    this.ovx = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297391);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_tv)");
    this.ovy = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297390);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_count_tv)");
    this.ovz = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297393);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_malicious_tips)");
    this.ovA = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297409);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_layout)");
    this.ovB = paramAttributeSet;
    paramAttributeSet = findViewById(2131297410);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
    this.ovC = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297408);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_icon)");
    this.ovD = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297392);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_header_data_layout)");
    this.ovE = paramAttributeSet;
    paramAttributeSet = this.ovt.getPaint();
    d.g.b.p.g(paramAttributeSet, "tp");
    paramAttributeSet.setFakeBoldText(true);
    this.ovr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7254);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((MPVideoHeaderView.e(this.ovG).hBZ & 0x1) != 0)
        {
          ae.w(MPVideoHeaderView.g(this.ovG), "not allow jump to profile " + MPVideoHeaderView.e(this.ovG).hBZ);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(7254);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", MPVideoHeaderView.c(this.ovG));
        paramAnonymousView.putExtra("Contact_Scene", 152);
        com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7254);
      }
    });
    AppMethodBeat.o(7263);
  }
  
  public final void setMaliciousInfo(byj parambyj)
  {
    AppMethodBeat.i(7259);
    d.g.b.p.h(parambyj, "info");
    this.ovA.setVisibility(0);
    this.ovA.setText((CharSequence)parambyj.Hlh);
    AppMethodBeat.o(7259);
  }
  
  public final void setOriginInfo(final fc paramfc)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(7260);
    d.g.b.p.h(paramfc, "info");
    Object localObject3 = this.oif;
    if (localObject3 == null) {
      d.g.b.p.bdF("readerItem");
    }
    ((v)localObject3).title = paramfc.title;
    localObject3 = this.oif;
    if (localObject3 == null) {
      d.g.b.p.bdF("readerItem");
    }
    ((v)localObject3).hGg = paramfc.hGg;
    a.b.d(this.fTj, this.talker);
    paramfc = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(paramfc, "MMKernel.service(IMessengerStorage::class.java)");
    paramfc = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramfc).azF().BH(this.talker);
    if ((paramfc == null) || (paramfc.adE() <= 0))
    {
      paramfc = this.otY;
      if (paramfc == null) {
        d.g.b.p.bdF("msgInfo");
      }
      if (paramfc != null)
      {
        paramfc = paramfc.hFW;
        localObject3 = this.fTj;
        localObject1 = this.otY;
        if (localObject1 == null) {
          d.g.b.p.bdF("msgInfo");
        }
        if (localObject1 == null) {
          break label551;
        }
        localObject1 = ((x)localObject1).Wa();
        label185:
        ((ImageView)localObject3).setTag(localObject1);
        localObject3 = new WeakReference(this.fTj);
        au.b localb = au.a.aBQ();
        x localx = this.otY;
        if (localx == null) {
          d.g.b.p.bdF("msgInfo");
        }
        localObject1 = localObject2;
        if (localx != null) {
          localObject1 = localx.Wa();
        }
        localb.a((String)localObject1, "", (au.b.a)new MPVideoHeaderView.a((WeakReference)localObject3));
      }
    }
    for (;;)
    {
      paramfc = k.b(getContext(), (CharSequence)(paramfc + "  "), this.ovs.getTextSize());
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2131231290);
      int i = (int)this.ovs.getTextSize();
      ((Drawable)localObject1).setBounds(0, 0, i / 2, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.ovs.setText(TextUtils.concat(new CharSequence[] { (CharSequence)paramfc, (CharSequence)localObject2 }));
      paramfc = this.timeTv;
      localObject1 = getContext();
      localObject2 = this.otY;
      if (localObject2 == null) {
        d.g.b.p.bdF("msgInfo");
      }
      paramfc.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.f((Context)localObject1, ((x)localObject2).hFY.time * 1000L));
      paramfc = this.oif;
      if (paramfc == null) {
        d.g.b.p.bdF("readerItem");
      }
      if (bu.isNullOrNil(paramfc.hGg)) {
        this.ovw.setVisibility(8);
      }
      label551:
      label606:
      label867:
      for (;;)
      {
        paramfc = this.ovt;
        localObject1 = this.otY;
        if (localObject1 == null) {
          d.g.b.p.bdF("msgInfo");
        }
        paramfc.aq((CharSequence)((x)localObject1).hFY.title);
        AppMethodBeat.o(7260);
        return;
        paramfc = null;
        break;
        localObject1 = null;
        break label185;
        if (!paramfc.ads()) {
          ar.o((Runnable)new b(this, paramfc), 200L);
        }
        paramfc = this.otY;
        if (paramfc == null) {
          d.g.b.p.bdF("msgInfo");
        }
        if (paramfc != null)
        {
          paramfc = paramfc.Wa();
          localObject2 = w.zP(paramfc);
          if (!bu.lX((String)localObject2, this.talker)) {
            break label869;
          }
          paramfc = this.otY;
          if (paramfc == null) {
            d.g.b.p.bdF("msgInfo");
          }
          if (paramfc == null) {
            break label694;
          }
        }
        for (paramfc = paramfc.hFW;; paramfc = null)
        {
          if (bu.isNullOrNil(paramfc)) {
            break label869;
          }
          localObject2 = this.otY;
          if (localObject2 == null) {
            d.g.b.p.bdF("msgInfo");
          }
          paramfc = (fc)localObject1;
          if (localObject2 == null) {
            break;
          }
          paramfc = ((x)localObject2).hFW;
          break;
          paramfc = null;
          break label606;
        }
        this.ovw.setVisibility(0);
        paramfc = this.ovu;
        localObject1 = this.oif;
        if (localObject1 == null) {
          d.g.b.p.bdF("readerItem");
        }
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        paramfc.aq((CharSequence)((v)localObject1).hGg);
        i = com.tencent.mm.cb.a.iu(getContext());
        int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
        paramfc = this.ovu.kR(i - j, 2147483647);
        if (paramfc != null) {}
        for (i = paramfc.fXb();; i = 0)
        {
          if (i <= 4) {
            break label867;
          }
          float f = this.ovu.getTextSize();
          this.ovu.a(TextUtils.TruncateAt.END, f);
          this.ovv.setMinimumHeight((int)f);
          this.ovv.setVisibility(0);
          this.ovu.setMaxLines(4);
          this.ovw.setOnClickListener((View.OnClickListener)new c(this));
          break;
        }
      }
      label694:
      label869:
      paramfc = (fc)localObject2;
    }
  }
  
  public final void setWow(final mt parammt)
  {
    AppMethodBeat.i(7261);
    d.g.b.p.h(parammt, "appMsgStat");
    if (parammt.FYY != 1)
    {
      this.ovy.setVisibility(8);
      this.ovz.setVisibility(8);
      AppMethodBeat.o(7261);
      return;
    }
    this.ovy.setVisibility(0);
    this.ovz.setVisibility(0);
    int i;
    String str;
    Object localObject1;
    Object localObject2;
    if (parammt.FYX == 1)
    {
      this.ovy.setTextColor(getResources().getColor(2131100014));
      this.ovz.setTextColor(getResources().getColor(2131100014));
      i = 2131231317;
      str = getContext().getString(2131756653);
      if (parammt.FYW <= 0) {
        break label362;
      }
      this.ovz.setVisibility(0);
      localObject1 = this.ovz;
      localObject2 = getContext();
      d.g.b.p.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.O((Context)localObject2, parammt.FYW)));
    }
    for (;;)
    {
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(i);
      i = (int)(this.ovs.getTextSize() * 1.3D);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.ovy.setText(TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ", (CharSequence)str }));
      this.ovy.setOnClickListener((View.OnClickListener)new d(this, parammt));
      AppMethodBeat.o(7261);
      return;
      this.ovy.setTextColor(getResources().getColor(2131100016));
      this.ovz.setTextColor(getResources().getColor(2131100016));
      i = 2131231316;
      break;
      label362:
      this.ovz.setText((CharSequence)"");
      this.ovz.setVisibility(4);
    }
  }
  
  public final void setWriteCommentLayout(n paramn)
  {
    AppMethodBeat.i(7262);
    d.g.b.p.h(paramn, "layout");
    this.ovF = paramn;
    AppMethodBeat.o(7262);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MPVideoHeaderView paramMPVideoHeaderView, an paraman) {}
    
    public final void run()
    {
      AppMethodBeat.i(7256);
      if (c.Ds(MPVideoHeaderView.c(this.ovG)) == null)
      {
        i locali = com.tencent.mm.aj.p.aEN().DL(MPVideoHeaderView.c(this.ovG));
        if ((locali != null) && (!bu.isNullOrNil(locali.aEH()))) {
          com.tencent.mm.plugin.brandservice.b.d.a(MPVideoHeaderView.d(this.ovG), paramfc, locali.aEH(), true);
        }
      }
      AppMethodBeat.o(7256);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(MPVideoHeaderView paramMPVideoHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7257);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      MPVideoHeaderView.a(this.ovG).setVisibility(8);
      MPVideoHeaderView.b(this.ovG).setMaxLines(2147483647);
      MPVideoHeaderView.b(this.ovG).requestLayout();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7257);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(MPVideoHeaderView paramMPVideoHeaderView, mt parammt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setWow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (parammt.FYX == 1) {
        MPVideoHeaderView.e(this.ovG).aE(2, "");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setWow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7258);
        return;
        MPVideoHeaderView.e(this.ovG).aE(1, "");
        MPVideoHeaderView.f(this.ovG);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView
 * JD-Core Version:    0.7.0.1
 */