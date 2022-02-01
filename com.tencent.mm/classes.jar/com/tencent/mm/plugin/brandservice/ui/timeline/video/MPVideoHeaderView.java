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
import com.tencent.mm.ai.x;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "writeCommentLayout", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWriteCommentLayout", "layout", "showHaoKanView", "update", "plugin-brandservice_release"})
public final class MPVideoHeaderView
  extends RelativeLayout
{
  private final String TAG;
  private ImageView fRd;
  private com.tencent.mm.ai.v ocq;
  private x ooh;
  private TextView opA;
  private MMNeat7extView opB;
  private MMNeat7extView opC;
  private View opD;
  private View opE;
  private TextView opF;
  private TextView opG;
  private TextView opH;
  private TextView opI;
  private View opJ;
  private TextView opK;
  private ImageView opL;
  private View opM;
  private n opN;
  private boolean opx;
  private b opy;
  private LinearLayout opz;
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
    this.opz = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131297374);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_avatar_iv)");
    this.fRd = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297396);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_nick_name_tv)");
    this.opA = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297405);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_title_tv)");
    this.opB = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297388);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_tv)");
    this.opC = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297387);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_show_more_layout)");
    this.opD = paramAttributeSet;
    paramAttributeSet = findViewById(2131297386);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_layout)");
    this.opE = paramAttributeSet;
    paramAttributeSet = findViewById(2131297403);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_time_tv)");
    this.timeTv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297400);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_read_count_tv)");
    this.opF = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297391);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_tv)");
    this.opG = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297390);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_count_tv)");
    this.opH = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297393);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_malicious_tips)");
    this.opI = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297409);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_layout)");
    this.opJ = paramAttributeSet;
    paramAttributeSet = findViewById(2131297410);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
    this.opK = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297408);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_icon)");
    this.opL = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297392);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_header_data_layout)");
    this.opM = paramAttributeSet;
    paramAttributeSet = this.opB.getPaint();
    d.g.b.p.g(paramAttributeSet, "tp");
    paramAttributeSet.setFakeBoldText(true);
    this.opz.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7254);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((MPVideoHeaderView.e(this.opO).hzl & 0x1) != 0)
        {
          ad.w(MPVideoHeaderView.g(this.opO), "not allow jump to profile " + MPVideoHeaderView.e(this.opO).hzl);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(7254);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", MPVideoHeaderView.c(this.opO));
        paramAnonymousView.putExtra("Contact_Scene", 152);
        com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7254);
      }
    });
    AppMethodBeat.o(7263);
  }
  
  public final void setMaliciousInfo(bxp parambxp)
  {
    AppMethodBeat.i(7259);
    d.g.b.p.h(parambxp, "info");
    this.opI.setVisibility(0);
    this.opI.setText((CharSequence)parambxp.GRG);
    AppMethodBeat.o(7259);
  }
  
  public final void setOriginInfo(final fc paramfc)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(7260);
    d.g.b.p.h(paramfc, "info");
    Object localObject3 = this.ocq;
    if (localObject3 == null) {
      d.g.b.p.bcb("readerItem");
    }
    ((com.tencent.mm.ai.v)localObject3).title = paramfc.title;
    localObject3 = this.ocq;
    if (localObject3 == null) {
      d.g.b.p.bcb("readerItem");
    }
    ((com.tencent.mm.ai.v)localObject3).hDo = paramfc.hDo;
    a.b.d(this.fRd, this.talker);
    paramfc = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(paramfc, "MMKernel.service(IMessengerStorage::class.java)");
    paramfc = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramfc).azp().Bf(this.talker);
    if ((paramfc == null) || (paramfc.adt() <= 0))
    {
      paramfc = this.ooh;
      if (paramfc == null) {
        d.g.b.p.bcb("msgInfo");
      }
      if (paramfc != null)
      {
        paramfc = paramfc.hDe;
        localObject3 = this.fRd;
        localObject1 = this.ooh;
        if (localObject1 == null) {
          d.g.b.p.bcb("msgInfo");
        }
        if (localObject1 == null) {
          break label551;
        }
        localObject1 = ((x)localObject1).VS();
        label185:
        ((ImageView)localObject3).setTag(localObject1);
        localObject3 = new WeakReference(this.fRd);
        as.b localb = as.a.aBA();
        x localx = this.ooh;
        if (localx == null) {
          d.g.b.p.bcb("msgInfo");
        }
        localObject1 = localObject2;
        if (localx != null) {
          localObject1 = localx.VS();
        }
        localb.a((String)localObject1, "", (as.b.a)new MPVideoHeaderView.a((WeakReference)localObject3));
      }
    }
    for (;;)
    {
      paramfc = k.b(getContext(), (CharSequence)(paramfc + "  "), this.opA.getTextSize());
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2131231290);
      int i = (int)this.opA.getTextSize();
      ((Drawable)localObject1).setBounds(0, 0, i / 2, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.opA.setText(TextUtils.concat(new CharSequence[] { (CharSequence)paramfc, (CharSequence)localObject2 }));
      paramfc = this.timeTv;
      localObject1 = getContext();
      localObject2 = this.ooh;
      if (localObject2 == null) {
        d.g.b.p.bcb("msgInfo");
      }
      paramfc.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.f((Context)localObject1, ((x)localObject2).hDg.time * 1000L));
      paramfc = this.ocq;
      if (paramfc == null) {
        d.g.b.p.bcb("readerItem");
      }
      if (bt.isNullOrNil(paramfc.hDo)) {
        this.opE.setVisibility(8);
      }
      label551:
      label606:
      label867:
      for (;;)
      {
        paramfc = this.opB;
        localObject1 = this.ooh;
        if (localObject1 == null) {
          d.g.b.p.bcb("msgInfo");
        }
        paramfc.ar((CharSequence)((x)localObject1).hDg.title);
        AppMethodBeat.o(7260);
        return;
        paramfc = null;
        break;
        localObject1 = null;
        break label185;
        if (!paramfc.adh()) {
          aq.o((Runnable)new b(this, paramfc), 200L);
        }
        paramfc = this.ooh;
        if (paramfc == null) {
          d.g.b.p.bcb("msgInfo");
        }
        if (paramfc != null)
        {
          paramfc = paramfc.VS();
          localObject2 = com.tencent.mm.model.v.zf(paramfc);
          if (!bt.lQ((String)localObject2, this.talker)) {
            break label869;
          }
          paramfc = this.ooh;
          if (paramfc == null) {
            d.g.b.p.bcb("msgInfo");
          }
          if (paramfc == null) {
            break label694;
          }
        }
        for (paramfc = paramfc.hDe;; paramfc = null)
        {
          if (bt.isNullOrNil(paramfc)) {
            break label869;
          }
          localObject2 = this.ooh;
          if (localObject2 == null) {
            d.g.b.p.bcb("msgInfo");
          }
          paramfc = (fc)localObject1;
          if (localObject2 == null) {
            break;
          }
          paramfc = ((x)localObject2).hDe;
          break;
          paramfc = null;
          break label606;
        }
        this.opE.setVisibility(0);
        paramfc = this.opC;
        localObject1 = this.ocq;
        if (localObject1 == null) {
          d.g.b.p.bcb("readerItem");
        }
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        paramfc.ar((CharSequence)((com.tencent.mm.ai.v)localObject1).hDo);
        i = com.tencent.mm.cc.a.ip(getContext());
        int j = com.tencent.mm.cc.a.fromDPToPix(getContext(), 32);
        paramfc = this.opC.kK(i - j, 2147483647);
        if (paramfc != null) {}
        for (i = paramfc.fSB();; i = 0)
        {
          if (i <= 4) {
            break label867;
          }
          float f = this.opC.getTextSize();
          this.opC.a(TextUtils.TruncateAt.END, f);
          this.opD.setMinimumHeight((int)f);
          this.opD.setVisibility(0);
          this.opC.setMaxLines(4);
          this.opE.setOnClickListener((View.OnClickListener)new c(this));
          break;
        }
      }
      label694:
      label869:
      paramfc = (fc)localObject2;
    }
  }
  
  public final void setWow(final mr parammr)
  {
    AppMethodBeat.i(7261);
    d.g.b.p.h(parammr, "appMsgStat");
    if (parammr.FGC != 1)
    {
      this.opG.setVisibility(8);
      this.opH.setVisibility(8);
      AppMethodBeat.o(7261);
      return;
    }
    this.opG.setVisibility(0);
    this.opH.setVisibility(0);
    int i;
    String str;
    Object localObject1;
    Object localObject2;
    if (parammr.FGB == 1)
    {
      this.opG.setTextColor(getResources().getColor(2131100014));
      this.opH.setTextColor(getResources().getColor(2131100014));
      i = 2131231317;
      str = getContext().getString(2131756653);
      if (parammr.FGA <= 0) {
        break label362;
      }
      this.opH.setVisibility(0);
      localObject1 = this.opH;
      localObject2 = getContext();
      d.g.b.p.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.O((Context)localObject2, parammr.FGA)));
    }
    for (;;)
    {
      localObject1 = getContext();
      d.g.b.p.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(i);
      i = (int)(this.opA.getTextSize() * 1.3D);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.opG.setText(TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ", (CharSequence)str }));
      this.opG.setOnClickListener((View.OnClickListener)new d(this, parammr));
      AppMethodBeat.o(7261);
      return;
      this.opG.setTextColor(getResources().getColor(2131100016));
      this.opH.setTextColor(getResources().getColor(2131100016));
      i = 2131231316;
      break;
      label362:
      this.opH.setText((CharSequence)"");
      this.opH.setVisibility(4);
    }
  }
  
  public final void setWriteCommentLayout(n paramn)
  {
    AppMethodBeat.i(7262);
    d.g.b.p.h(paramn, "layout");
    this.opN = paramn;
    AppMethodBeat.o(7262);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MPVideoHeaderView paramMPVideoHeaderView, am paramam) {}
    
    public final void run()
    {
      AppMethodBeat.i(7256);
      if (c.CQ(MPVideoHeaderView.c(this.opO)) == null)
      {
        i locali = com.tencent.mm.ak.p.aEx().Dj(MPVideoHeaderView.c(this.opO));
        if ((locali != null) && (!bt.isNullOrNil(locali.aEr()))) {
          com.tencent.mm.plugin.brandservice.b.d.a(MPVideoHeaderView.d(this.opO), paramfc, locali.aEr(), true);
        }
      }
      AppMethodBeat.o(7256);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(MPVideoHeaderView paramMPVideoHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7257);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      MPVideoHeaderView.a(this.opO).setVisibility(8);
      MPVideoHeaderView.b(this.opO).setMaxLines(2147483647);
      MPVideoHeaderView.b(this.opO).requestLayout();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7257);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(MPVideoHeaderView paramMPVideoHeaderView, mr parammr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setWow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (parammr.FGB == 1) {
        MPVideoHeaderView.e(this.opO).aF(2, "");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setWow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7258);
        return;
        MPVideoHeaderView.e(this.opO).aF(1, "");
        MPVideoHeaderView.f(this.opO);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView
 * JD-Core Version:    0.7.0.1
 */