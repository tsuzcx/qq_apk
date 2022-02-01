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
import com.tencent.mm.ah.x;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "writeCommentLayout", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWriteCommentLayout", "layout", "showHaoKanView", "update", "plugin-brandservice_release"})
public final class MPVideoHeaderView
  extends RelativeLayout
{
  private final String TAG;
  private ImageView fxQ;
  private com.tencent.mm.ah.v nBm;
  private x nLB;
  private boolean nMR;
  private b nMS;
  private LinearLayout nMT;
  private TextView nMU;
  private MMNeat7extView nMV;
  private MMNeat7extView nMW;
  private View nMX;
  private View nMY;
  private TextView nMZ;
  private TextView nNa;
  private TextView nNb;
  private TextView nNc;
  private View nNd;
  private TextView nNe;
  private ImageView nNf;
  private View nNg;
  private n nNh;
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
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_avatar_layout)");
    this.nMT = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131297374);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_avatar_iv)");
    this.fxQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297396);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_nick_name_tv)");
    this.nMU = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297405);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_title_tv)");
    this.nMV = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297388);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_tv)");
    this.nMW = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297387);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_show_more_layout)");
    this.nMX = paramAttributeSet;
    paramAttributeSet = findViewById(2131297386);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_layout)");
    this.nMY = paramAttributeSet;
    paramAttributeSet = findViewById(2131297403);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_time_tv)");
    this.timeTv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297400);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_read_count_tv)");
    this.nMZ = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297391);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_tv)");
    this.nNa = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297390);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_count_tv)");
    this.nNb = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297393);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_malicious_tips)");
    this.nNc = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297409);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_layout)");
    this.nNd = paramAttributeSet;
    paramAttributeSet = findViewById(2131297410);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
    this.nNe = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297408);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_icon)");
    this.nNf = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297392);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_header_data_layout)");
    this.nNg = paramAttributeSet;
    paramAttributeSet = this.nMV.getPaint();
    d.g.b.k.g(paramAttributeSet, "tp");
    paramAttributeSet.setFakeBoldText(true);
    this.nMT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7254);
        if ((MPVideoHeaderView.e(this.nNi).hhc & 0x1) != 0)
        {
          ac.w(MPVideoHeaderView.g(this.nNi), "not allow jump to profile " + MPVideoHeaderView.e(this.nNi).hhc);
          AppMethodBeat.o(7254);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", MPVideoHeaderView.c(this.nNi));
        paramAnonymousView.putExtra("Contact_Scene", 152);
        com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        AppMethodBeat.o(7254);
      }
    });
    AppMethodBeat.o(7263);
  }
  
  public final void setMaliciousInfo(btb parambtb)
  {
    AppMethodBeat.i(7259);
    d.g.b.k.h(parambtb, "info");
    this.nNc.setVisibility(0);
    this.nNc.setText((CharSequence)parambtb.Fif);
    AppMethodBeat.o(7259);
  }
  
  public final void setOriginInfo(final ey paramey)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(7260);
    d.g.b.k.h(paramey, "info");
    Object localObject3 = this.nBm;
    if (localObject3 == null) {
      d.g.b.k.aVY("readerItem");
    }
    ((com.tencent.mm.ah.v)localObject3).title = paramey.title;
    localObject3 = this.nBm;
    if (localObject3 == null) {
      d.g.b.k.aVY("readerItem");
    }
    ((com.tencent.mm.ah.v)localObject3).hlf = paramey.hlf;
    a.b.d(this.fxQ, this.talker);
    paramey = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramey, "MMKernel.service(IMessengerStorage::class.java)");
    paramey = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramey).awB().aNt(this.talker);
    if ((paramey == null) || (paramey.aaQ() <= 0))
    {
      paramey = this.nLB;
      if (paramey == null) {
        d.g.b.k.aVY("msgInfo");
      }
      if (paramey != null)
      {
        paramey = paramey.hkV;
        localObject3 = this.fxQ;
        localObject1 = this.nLB;
        if (localObject1 == null) {
          d.g.b.k.aVY("msgInfo");
        }
        if (localObject1 == null) {
          break label551;
        }
        localObject1 = ((x)localObject1).TC();
        label185:
        ((ImageView)localObject3).setTag(localObject1);
        localObject3 = new WeakReference(this.fxQ);
        ar.b localb = ar.a.ayw();
        x localx = this.nLB;
        if (localx == null) {
          d.g.b.k.aVY("msgInfo");
        }
        localObject1 = localObject2;
        if (localx != null) {
          localObject1 = localx.TC();
        }
        localb.a((String)localObject1, "", (ar.b.a)new a((WeakReference)localObject3));
      }
    }
    for (;;)
    {
      paramey = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)(paramey + "  "), this.nMU.getTextSize());
      localObject1 = getContext();
      d.g.b.k.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2131231290);
      int i = (int)this.nMU.getTextSize();
      ((Drawable)localObject1).setBounds(0, 0, i / 2, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.nMU.setText(TextUtils.concat(new CharSequence[] { (CharSequence)paramey, (CharSequence)localObject2 }));
      paramey = this.timeTv;
      localObject1 = getContext();
      localObject2 = this.nLB;
      if (localObject2 == null) {
        d.g.b.k.aVY("msgInfo");
      }
      paramey.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.f((Context)localObject1, ((x)localObject2).hkX.time * 1000L));
      paramey = this.nBm;
      if (paramey == null) {
        d.g.b.k.aVY("readerItem");
      }
      if (bs.isNullOrNil(paramey.hlf)) {
        this.nMY.setVisibility(8);
      }
      label551:
      label606:
      label867:
      for (;;)
      {
        paramey = this.nMV;
        localObject1 = this.nLB;
        if (localObject1 == null) {
          d.g.b.k.aVY("msgInfo");
        }
        paramey.ar((CharSequence)((x)localObject1).hkX.title);
        AppMethodBeat.o(7260);
        return;
        paramey = null;
        break;
        localObject1 = null;
        break label185;
        if (!paramey.aaE()) {
          ap.n((Runnable)new b(this, paramey), 200L);
        }
        paramey = this.nLB;
        if (paramey == null) {
          d.g.b.k.aVY("msgInfo");
        }
        if (paramey != null)
        {
          paramey = paramey.TC();
          localObject2 = com.tencent.mm.model.v.wk(paramey);
          if (!bs.lr((String)localObject2, this.talker)) {
            break label869;
          }
          paramey = this.nLB;
          if (paramey == null) {
            d.g.b.k.aVY("msgInfo");
          }
          if (paramey == null) {
            break label694;
          }
        }
        for (paramey = paramey.hkV;; paramey = null)
        {
          if (bs.isNullOrNil(paramey)) {
            break label869;
          }
          localObject2 = this.nLB;
          if (localObject2 == null) {
            d.g.b.k.aVY("msgInfo");
          }
          paramey = (ey)localObject1;
          if (localObject2 == null) {
            break;
          }
          paramey = ((x)localObject2).hkV;
          break;
          paramey = null;
          break label606;
        }
        this.nMY.setVisibility(0);
        paramey = this.nMW;
        localObject1 = this.nBm;
        if (localObject1 == null) {
          d.g.b.k.aVY("readerItem");
        }
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        paramey.ar((CharSequence)((com.tencent.mm.ah.v)localObject1).hlf);
        i = com.tencent.mm.cc.a.ig(getContext());
        int j = com.tencent.mm.cc.a.fromDPToPix(getContext(), 32);
        paramey = this.nMW.kv(i - j, 2147483647);
        if (paramey != null) {}
        for (i = paramey.fBm();; i = 0)
        {
          if (i <= 4) {
            break label867;
          }
          float f = this.nMW.getTextSize();
          this.nMW.a(TextUtils.TruncateAt.END, f);
          this.nMX.setMinimumHeight((int)f);
          this.nMX.setVisibility(0);
          this.nMW.setMaxLines(4);
          this.nMY.setOnClickListener((View.OnClickListener)new c(this));
          break;
        }
      }
      label694:
      label869:
      paramey = (ey)localObject2;
    }
  }
  
  public final void setWow(final mc parammc)
  {
    AppMethodBeat.i(7261);
    d.g.b.k.h(parammc, "appMsgStat");
    if (parammc.EaT != 1)
    {
      this.nNa.setVisibility(8);
      this.nNb.setVisibility(8);
      AppMethodBeat.o(7261);
      return;
    }
    this.nNa.setVisibility(0);
    this.nNb.setVisibility(0);
    int i;
    String str;
    Object localObject1;
    Object localObject2;
    if (parammc.EaS == 1)
    {
      this.nNa.setTextColor(getResources().getColor(2131100014));
      this.nNb.setTextColor(getResources().getColor(2131100014));
      i = 2131231317;
      str = getContext().getString(2131756653);
      if (parammc.EaR <= 0) {
        break label362;
      }
      this.nNb.setVisibility(0);
      localObject1 = this.nNb;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.N((Context)localObject2, parammc.EaR)));
    }
    for (;;)
    {
      localObject1 = getContext();
      d.g.b.k.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(i);
      i = (int)(this.nMU.getTextSize() * 1.3D);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.nNa.setText(TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ", (CharSequence)str }));
      this.nNa.setOnClickListener((View.OnClickListener)new d(this, parammc));
      AppMethodBeat.o(7261);
      return;
      this.nNa.setTextColor(getResources().getColor(2131100016));
      this.nNb.setTextColor(getResources().getColor(2131100016));
      i = 2131231316;
      break;
      label362:
      this.nNb.setText((CharSequence)"");
      this.nNb.setVisibility(4);
    }
  }
  
  public final void setWriteCommentLayout(n paramn)
  {
    AppMethodBeat.i(7262);
    d.g.b.k.h(paramn, "layout");
    this.nNh = paramn;
    AppMethodBeat.o(7262);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class a
    implements ar.b.a
  {
    a(WeakReference paramWeakReference) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(7255);
      ImageView localImageView = (ImageView)this.nNj.get();
      if (localImageView == null)
      {
        AppMethodBeat.o(7255);
        return;
      }
      d.g.b.k.g(localImageView, "weakReference.get() ?: return@GetContactCallBack");
      Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).awB().aNt(paramString);
      if ((localObject1 == null) || (((ai)localObject1).aaQ() <= 0))
      {
        AppMethodBeat.o(7255);
        return;
      }
      if ((localImageView.getTag() instanceof String))
      {
        p.aBy().zV(paramString);
        Object localObject2 = localImageView.getTag();
        if (localObject2 == null)
        {
          paramString = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(7255);
          throw paramString;
        }
        if (bs.lr((String)localObject2, paramString))
        {
          localObject2 = p.aBw().Ak(paramString);
          if ((localObject2 != null) && (!bs.isNullOrNil(((i)localObject2).aBp())))
          {
            com.tencent.mm.plugin.brandservice.b.d.a(localImageView, (ai)localObject1, ((i)localObject2).aBp(), true);
            AppMethodBeat.o(7255);
            return;
          }
          a.b.d(localImageView, paramString);
        }
      }
      AppMethodBeat.o(7255);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MPVideoHeaderView paramMPVideoHeaderView, ai paramai) {}
    
    public final void run()
    {
      AppMethodBeat.i(7256);
      if (c.zR(MPVideoHeaderView.c(this.nNi)) == null)
      {
        i locali = p.aBw().Ak(MPVideoHeaderView.c(this.nNi));
        if ((locali != null) && (!bs.isNullOrNil(locali.aBp()))) {
          com.tencent.mm.plugin.brandservice.b.d.a(MPVideoHeaderView.d(this.nNi), paramey, locali.aBp(), true);
        }
      }
      AppMethodBeat.o(7256);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(MPVideoHeaderView paramMPVideoHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7257);
      MPVideoHeaderView.a(this.nNi).setVisibility(8);
      MPVideoHeaderView.b(this.nNi).setMaxLines(2147483647);
      MPVideoHeaderView.b(this.nNi).requestLayout();
      AppMethodBeat.o(7257);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(MPVideoHeaderView paramMPVideoHeaderView, mc parammc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7258);
      if (parammc.EaS == 1)
      {
        MPVideoHeaderView.e(this.nNi).aC(2, "");
        AppMethodBeat.o(7258);
        return;
      }
      MPVideoHeaderView.e(this.nNi).aC(1, "");
      MPVideoHeaderView.f(this.nNi);
      AppMethodBeat.o(7258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView
 * JD-Core Version:    0.7.0.1
 */