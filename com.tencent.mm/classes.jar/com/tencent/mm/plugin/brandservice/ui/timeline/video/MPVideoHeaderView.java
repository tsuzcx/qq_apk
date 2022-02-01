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
import com.tencent.mm.ak.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "writeCommentLayout", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWriteCommentLayout", "layout", "showHaoKanView", "update", "plugin-brandservice_release"})
public final class MPVideoHeaderView
  extends RelativeLayout
{
  private final String TAG;
  private ImageView fuj;
  private com.tencent.mm.ai.v mYN;
  private x niI;
  private boolean njY;
  private b njZ;
  private LinearLayout nka;
  private TextView nkb;
  private MMNeat7extView nkc;
  private MMNeat7extView nkd;
  private View nke;
  private View nkf;
  private TextView nkg;
  private TextView nkh;
  private TextView nki;
  private TextView nkj;
  private View nkk;
  private TextView nkl;
  private ImageView nkm;
  private View nkn;
  private n nko;
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
    this.nka = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131297374);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_avatar_iv)");
    this.fuj = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297396);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_nick_name_tv)");
    this.nkb = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297405);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_title_tv)");
    this.nkc = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297388);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_tv)");
    this.nkd = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297387);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_show_more_layout)");
    this.nke = paramAttributeSet;
    paramAttributeSet = findViewById(2131297386);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_layout)");
    this.nkf = paramAttributeSet;
    paramAttributeSet = findViewById(2131297403);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_time_tv)");
    this.timeTv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297400);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_read_count_tv)");
    this.nkg = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297391);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_tv)");
    this.nkh = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297390);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_count_tv)");
    this.nki = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297393);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_malicious_tips)");
    this.nkj = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297409);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_layout)");
    this.nkk = paramAttributeSet;
    paramAttributeSet = findViewById(2131297410);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
    this.nkl = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297408);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_icon)");
    this.nkm = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297392);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.biz_video_header_data_layout)");
    this.nkn = paramAttributeSet;
    paramAttributeSet = this.nkc.getPaint();
    d.g.b.k.g(paramAttributeSet, "tp");
    paramAttributeSet.setFakeBoldText(true);
    this.nka.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7254);
        if ((MPVideoHeaderView.e(this.nkp).gGB & 0x1) != 0)
        {
          ad.w(MPVideoHeaderView.g(this.nkp), "not allow jump to profile " + MPVideoHeaderView.e(this.nkp).gGB);
          AppMethodBeat.o(7254);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", MPVideoHeaderView.c(this.nkp));
        paramAnonymousView.putExtra("Contact_Scene", 152);
        com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        AppMethodBeat.o(7254);
      }
    });
    AppMethodBeat.o(7263);
  }
  
  public final void setMaliciousInfo(bol parambol)
  {
    AppMethodBeat.i(7259);
    d.g.b.k.h(parambol, "info");
    this.nkj.setVisibility(0);
    this.nkj.setText((CharSequence)parambol.DLQ);
    AppMethodBeat.o(7259);
  }
  
  public final void setOriginInfo(final ew paramew)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(7260);
    d.g.b.k.h(paramew, "info");
    Object localObject3 = this.mYN;
    if (localObject3 == null) {
      d.g.b.k.aPZ("readerItem");
    }
    ((com.tencent.mm.ai.v)localObject3).title = paramew.title;
    localObject3 = this.mYN;
    if (localObject3 == null) {
      d.g.b.k.aPZ("readerItem");
    }
    ((com.tencent.mm.ai.v)localObject3).gKF = paramew.gKF;
    a.b.d(this.fuj, this.talker);
    paramew = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramew, "MMKernel.service(IMessengerStorage::class.java)");
    paramew = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramew).apM().aHY(this.talker);
    if ((paramew == null) || (paramew.ZV() <= 0))
    {
      paramew = this.niI;
      if (paramew == null) {
        d.g.b.k.aPZ("msgInfo");
      }
      if (paramew != null)
      {
        paramew = paramew.gKv;
        localObject3 = this.fuj;
        localObject1 = this.niI;
        if (localObject1 == null) {
          d.g.b.k.aPZ("msgInfo");
        }
        if (localObject1 == null) {
          break label551;
        }
        localObject1 = ((x)localObject1).SI();
        label185:
        ((ImageView)localObject3).setTag(localObject1);
        localObject3 = new WeakReference(this.fuj);
        ar.b localb = ar.a.arF();
        x localx = this.niI;
        if (localx == null) {
          d.g.b.k.aPZ("msgInfo");
        }
        localObject1 = localObject2;
        if (localx != null) {
          localObject1 = localx.SI();
        }
        localb.a((String)localObject1, "", (ar.b.a)new a((WeakReference)localObject3));
      }
    }
    for (;;)
    {
      paramew = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)(paramew + "  "), this.nkb.getTextSize());
      localObject1 = getContext();
      d.g.b.k.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2131231290);
      int i = (int)this.nkb.getTextSize();
      ((Drawable)localObject1).setBounds(0, 0, i / 2, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.nkb.setText(TextUtils.concat(new CharSequence[] { (CharSequence)paramew, (CharSequence)localObject2 }));
      paramew = this.timeTv;
      localObject1 = getContext();
      localObject2 = this.niI;
      if (localObject2 == null) {
        d.g.b.k.aPZ("msgInfo");
      }
      paramew.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.f((Context)localObject1, ((x)localObject2).gKx.time * 1000L));
      paramew = this.mYN;
      if (paramew == null) {
        d.g.b.k.aPZ("readerItem");
      }
      if (bt.isNullOrNil(paramew.gKF)) {
        this.nkf.setVisibility(8);
      }
      label551:
      label606:
      label867:
      for (;;)
      {
        paramew = this.nkc;
        localObject1 = this.niI;
        if (localObject1 == null) {
          d.g.b.k.aPZ("msgInfo");
        }
        paramew.aq((CharSequence)((x)localObject1).gKx.title);
        AppMethodBeat.o(7260);
        return;
        paramew = null;
        break;
        localObject1 = null;
        break label185;
        if (!paramew.ZJ()) {
          aq.n((Runnable)new b(this, paramew), 200L);
        }
        paramew = this.niI;
        if (paramew == null) {
          d.g.b.k.aPZ("msgInfo");
        }
        if (paramew != null)
        {
          paramew = paramew.SI();
          localObject2 = com.tencent.mm.model.v.sh(paramew);
          if (!bt.kU((String)localObject2, this.talker)) {
            break label869;
          }
          paramew = this.niI;
          if (paramew == null) {
            d.g.b.k.aPZ("msgInfo");
          }
          if (paramew == null) {
            break label694;
          }
        }
        for (paramew = paramew.gKv;; paramew = null)
        {
          if (bt.isNullOrNil(paramew)) {
            break label869;
          }
          localObject2 = this.niI;
          if (localObject2 == null) {
            d.g.b.k.aPZ("msgInfo");
          }
          paramew = (ew)localObject1;
          if (localObject2 == null) {
            break;
          }
          paramew = ((x)localObject2).gKv;
          break;
          paramew = null;
          break label606;
        }
        this.nkf.setVisibility(0);
        paramew = this.nkd;
        localObject1 = this.mYN;
        if (localObject1 == null) {
          d.g.b.k.aPZ("readerItem");
        }
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        paramew.aq((CharSequence)((com.tencent.mm.ai.v)localObject1).gKF);
        i = com.tencent.mm.cd.a.hV(getContext());
        int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 32);
        paramew = this.nkd.ki(i - j, 2147483647);
        if (paramew != null) {}
        for (i = paramew.fkV();; i = 0)
        {
          if (i <= 4) {
            break label867;
          }
          float f = this.nkd.getTextSize();
          this.nkd.a(TextUtils.TruncateAt.END, f);
          this.nke.setMinimumHeight((int)f);
          this.nke.setVisibility(0);
          this.nkd.setMaxLines(4);
          this.nkf.setOnClickListener((View.OnClickListener)new c(this));
          break;
        }
      }
      label694:
      label869:
      paramew = (ew)localObject2;
    }
  }
  
  public final void setWow(final lv paramlv)
  {
    AppMethodBeat.i(7261);
    d.g.b.k.h(paramlv, "appMsgStat");
    if (paramlv.CIr != 1)
    {
      this.nkh.setVisibility(8);
      this.nki.setVisibility(8);
      AppMethodBeat.o(7261);
      return;
    }
    this.nkh.setVisibility(0);
    this.nki.setVisibility(0);
    int i;
    String str;
    Object localObject1;
    Object localObject2;
    if (paramlv.CIq == 1)
    {
      this.nkh.setTextColor(getResources().getColor(2131100014));
      this.nki.setTextColor(getResources().getColor(2131100014));
      i = 2131231317;
      str = getContext().getString(2131756653);
      if (paramlv.CIp <= 0) {
        break label362;
      }
      this.nki.setVisibility(0);
      localObject1 = this.nki;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.J((Context)localObject2, paramlv.CIp)));
    }
    for (;;)
    {
      localObject1 = getContext();
      d.g.b.k.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(i);
      i = (int)(this.nkb.getTextSize() * 1.3D);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.nkh.setText(TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ", (CharSequence)str }));
      this.nkh.setOnClickListener((View.OnClickListener)new d(this, paramlv));
      AppMethodBeat.o(7261);
      return;
      this.nkh.setTextColor(getResources().getColor(2131100016));
      this.nki.setTextColor(getResources().getColor(2131100016));
      i = 2131231316;
      break;
      label362:
      this.nki.setText((CharSequence)"");
      this.nki.setVisibility(4);
    }
  }
  
  public final void setWriteCommentLayout(n paramn)
  {
    AppMethodBeat.i(7262);
    d.g.b.k.h(paramn, "layout");
    this.nko = paramn;
    AppMethodBeat.o(7262);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class a
    implements ar.b.a
  {
    a(WeakReference paramWeakReference) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(7255);
      ImageView localImageView = (ImageView)this.nkq.get();
      if (localImageView == null)
      {
        AppMethodBeat.o(7255);
        return;
      }
      d.g.b.k.g(localImageView, "weakReference.get() ?: return@GetContactCallBack");
      Object localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).apM().aHY(paramString);
      if ((localObject1 == null) || (((af)localObject1).ZV() <= 0))
      {
        AppMethodBeat.o(7255);
        return;
      }
      if ((localImageView.getTag() instanceof String))
      {
        p.auH().vP(paramString);
        Object localObject2 = localImageView.getTag();
        if (localObject2 == null)
        {
          paramString = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(7255);
          throw paramString;
        }
        if (bt.kU((String)localObject2, paramString))
        {
          localObject2 = p.auF().we(paramString);
          if ((localObject2 != null) && (!bt.isNullOrNil(((i)localObject2).auy())))
          {
            e.a(localImageView, (af)localObject1, ((i)localObject2).auy(), true);
            AppMethodBeat.o(7255);
            return;
          }
          a.b.d(localImageView, paramString);
        }
      }
      AppMethodBeat.o(7255);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MPVideoHeaderView paramMPVideoHeaderView, af paramaf) {}
    
    public final void run()
    {
      AppMethodBeat.i(7256);
      if (c.vL(MPVideoHeaderView.c(this.nkp)) == null)
      {
        i locali = p.auF().we(MPVideoHeaderView.c(this.nkp));
        if ((locali != null) && (!bt.isNullOrNil(locali.auy()))) {
          e.a(MPVideoHeaderView.d(this.nkp), paramew, locali.auy(), true);
        }
      }
      AppMethodBeat.o(7256);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(MPVideoHeaderView paramMPVideoHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7257);
      MPVideoHeaderView.a(this.nkp).setVisibility(8);
      MPVideoHeaderView.b(this.nkp).setMaxLines(2147483647);
      MPVideoHeaderView.b(this.nkp).requestLayout();
      AppMethodBeat.o(7257);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(MPVideoHeaderView paramMPVideoHeaderView, lv paramlv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7258);
      if (paramlv.CIq == 1)
      {
        MPVideoHeaderView.e(this.nkp).aB(2, "");
        AppMethodBeat.o(7258);
        return;
      }
      MPVideoHeaderView.e(this.nkp).aB(1, "");
      MPVideoHeaderView.f(this.nkp);
      AppMethodBeat.o(7258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView
 * JD-Core Version:    0.7.0.1
 */