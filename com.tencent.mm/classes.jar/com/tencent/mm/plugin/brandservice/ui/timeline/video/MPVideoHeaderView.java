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
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "writeCommentLayout", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWriteCommentLayout", "layout", "showHaoKanView", "update", "plugin-brandservice_release"})
public final class MPVideoHeaderView
  extends RelativeLayout
{
  private final String TAG;
  private ImageView gyr;
  private x pHv;
  private boolean pIK;
  private b pIL;
  private LinearLayout pIM;
  private TextView pIN;
  private MMNeat7extView pIO;
  private MMNeat7extView pIP;
  private View pIQ;
  private View pIR;
  private TextView pIS;
  private TextView pIT;
  private TextView pIU;
  private TextView pIV;
  private View pIW;
  private TextView pIX;
  private ImageView pIY;
  private View pIZ;
  private n pJa;
  private v ptH;
  private String talker;
  private TextView timeTv;
  
  public MPVideoHeaderView(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7263);
    this.TAG = "MicroMsg.MPVideoHeaderView";
    this.talker = "";
    View.inflate(paramContext, 2131495697, (ViewGroup)this);
    paramAttributeSet = findViewById(2131297593);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_avatar_layout)");
    this.pIM = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131297592);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_avatar_iv)");
    this.gyr = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297614);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_nick_name_tv)");
    this.pIN = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297623);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_title_tv)");
    this.pIO = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297606);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_tv)");
    this.pIP = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297605);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_show_more_layout)");
    this.pIQ = paramAttributeSet;
    paramAttributeSet = findViewById(2131297604);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_desc_layout)");
    this.pIR = paramAttributeSet;
    paramAttributeSet = findViewById(2131297621);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_time_tv)");
    this.timeTv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297618);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_read_count_tv)");
    this.pIS = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297609);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_tv)");
    this.pIT = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297608);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_haokan_count_tv)");
    this.pIU = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297611);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_malicious_tips)");
    this.pIV = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297627);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_layout)");
    this.pIW = paramAttributeSet;
    paramAttributeSet = findViewById(2131297628);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
    this.pIX = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297626);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_icon)");
    this.pIY = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131297610);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.biz_video_header_data_layout)");
    this.pIZ = paramAttributeSet;
    paramAttributeSet = this.pIO.getPaint();
    kotlin.g.b.p.g(paramAttributeSet, "tp");
    paramAttributeSet.setFakeBoldText(true);
    this.pIM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7254);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((MPVideoHeaderView.e(this.pJb).iwg & 0x1) != 0)
        {
          Log.w(MPVideoHeaderView.g(this.pJb), "not allow jump to profile " + MPVideoHeaderView.e(this.pJb).iwg);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(7254);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", MPVideoHeaderView.c(this.pJb));
        paramAnonymousView.putExtra("Contact_Scene", 152);
        com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7254);
      }
    });
    AppMethodBeat.o(7263);
  }
  
  public final void setMaliciousInfo(cmb paramcmb)
  {
    AppMethodBeat.i(7259);
    kotlin.g.b.p.h(paramcmb, "info");
    this.pIV.setVisibility(0);
    this.pIV.setText((CharSequence)paramcmb.Mrt);
    AppMethodBeat.o(7259);
  }
  
  public final void setOriginInfo(final fp paramfp)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(7260);
    kotlin.g.b.p.h(paramfp, "info");
    Object localObject3 = this.ptH;
    if (localObject3 == null) {
      kotlin.g.b.p.btv("readerItem");
    }
    ((v)localObject3).title = paramfp.title;
    localObject3 = this.ptH;
    if (localObject3 == null) {
      kotlin.g.b.p.btv("readerItem");
    }
    ((v)localObject3).iAq = paramfp.iAq;
    a.b.d(this.gyr, this.talker);
    paramfp = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(paramfp, "MMKernel.service(IMessengerStorage::class.java)");
    paramfp = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramfp).aSN().Kn(this.talker);
    if ((paramfp == null) || (paramfp.arH() <= 0))
    {
      paramfp = this.pHv;
      if (paramfp == null) {
        kotlin.g.b.p.btv("msgInfo");
      }
      if (paramfp != null)
      {
        paramfp = paramfp.iAg;
        localObject3 = this.gyr;
        localObject1 = this.pHv;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("msgInfo");
        }
        if (localObject1 == null) {
          break label551;
        }
        localObject1 = ((x)localObject1).ajO();
        label185:
        ((ImageView)localObject3).setTag(localObject1);
        localObject3 = new WeakReference(this.gyr);
        ay.b localb = ay.a.aVo();
        x localx = this.pHv;
        if (localx == null) {
          kotlin.g.b.p.btv("msgInfo");
        }
        localObject1 = localObject2;
        if (localx != null) {
          localObject1 = localx.ajO();
        }
        localb.a((String)localObject1, "", (ay.b.a)new MPVideoHeaderView.a((WeakReference)localObject3));
      }
    }
    for (;;)
    {
      paramfp = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)(paramfp + "  "), this.pIN.getTextSize());
      localObject1 = getContext();
      kotlin.g.b.p.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2131231353);
      int i = (int)this.pIN.getTextSize();
      ((Drawable)localObject1).setBounds(0, 0, i / 2, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.pIN.setText(TextUtils.concat(new CharSequence[] { (CharSequence)paramfp, (CharSequence)localObject2 }));
      paramfp = this.timeTv;
      localObject1 = getContext();
      localObject2 = this.pHv;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("msgInfo");
      }
      paramfp.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.f((Context)localObject1, ((x)localObject2).iAi.time * 1000L));
      paramfp = this.ptH;
      if (paramfp == null) {
        kotlin.g.b.p.btv("readerItem");
      }
      if (Util.isNullOrNil(paramfp.iAq)) {
        this.pIR.setVisibility(8);
      }
      label551:
      label606:
      label867:
      for (;;)
      {
        paramfp = this.pIO;
        localObject1 = this.pHv;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("msgInfo");
        }
        paramfp.aw((CharSequence)((x)localObject1).iAi.title);
        AppMethodBeat.o(7260);
        return;
        paramfp = null;
        break;
        localObject1 = null;
        break label185;
        if (!paramfp.arv()) {
          MMHandlerThread.postToMainThreadDelayed((Runnable)new b(this, paramfp), 200L);
        }
        paramfp = this.pHv;
        if (paramfp == null) {
          kotlin.g.b.p.btv("msgInfo");
        }
        if (paramfp != null)
        {
          paramfp = paramfp.ajO();
          localObject2 = aa.getDisplayName(paramfp);
          if (!Util.isEqual((String)localObject2, this.talker)) {
            break label869;
          }
          paramfp = this.pHv;
          if (paramfp == null) {
            kotlin.g.b.p.btv("msgInfo");
          }
          if (paramfp == null) {
            break label694;
          }
        }
        for (paramfp = paramfp.iAg;; paramfp = null)
        {
          if (Util.isNullOrNil(paramfp)) {
            break label869;
          }
          localObject2 = this.pHv;
          if (localObject2 == null) {
            kotlin.g.b.p.btv("msgInfo");
          }
          paramfp = (fp)localObject1;
          if (localObject2 == null) {
            break;
          }
          paramfp = ((x)localObject2).iAg;
          break;
          paramfp = null;
          break label606;
        }
        this.pIR.setVisibility(0);
        paramfp = this.pIP;
        localObject1 = this.ptH;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("readerItem");
        }
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        paramfp.aw((CharSequence)((v)localObject1).iAq);
        i = com.tencent.mm.cb.a.jn(getContext());
        int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
        paramfp = this.pIP.mq(i - j, 2147483647);
        if (paramfp != null) {}
        for (i = paramfp.hiG();; i = 0)
        {
          if (i <= 4) {
            break label867;
          }
          float f = this.pIP.getTextSize();
          this.pIP.a(TextUtils.TruncateAt.END, f);
          this.pIQ.setMinimumHeight((int)f);
          this.pIQ.setVisibility(0);
          this.pIP.setMaxLines(4);
          this.pIR.setOnClickListener((View.OnClickListener)new c(this));
          break;
        }
      }
      label694:
      label869:
      paramfp = (fp)localObject2;
    }
  }
  
  public final void setWow(final nl paramnl)
  {
    AppMethodBeat.i(7261);
    kotlin.g.b.p.h(paramnl, "appMsgStat");
    if (paramnl.KST != 1)
    {
      this.pIT.setVisibility(8);
      this.pIU.setVisibility(8);
      AppMethodBeat.o(7261);
      return;
    }
    this.pIT.setVisibility(0);
    this.pIU.setVisibility(0);
    int i;
    String str;
    Object localObject1;
    Object localObject2;
    if (paramnl.KSS == 1)
    {
      this.pIT.setTextColor(getResources().getColor(2131100039));
      this.pIU.setTextColor(getResources().getColor(2131100039));
      i = 2131231380;
      str = getContext().getString(2131756808);
      kotlin.g.b.p.g(str, "context.getString(R.string.biz_video_haokan)");
      if (paramnl.KSR <= 0) {
        break label369;
      }
      this.pIU.setVisibility(0);
      localObject1 = this.pIU;
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.T((Context)localObject2, paramnl.KSR)));
    }
    for (;;)
    {
      localObject1 = getContext();
      kotlin.g.b.p.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(i);
      i = (int)(this.pIN.getTextSize() * 1.3D);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.pIT.setText(TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ", (CharSequence)str }));
      this.pIT.setOnClickListener((View.OnClickListener)new d(this, paramnl));
      AppMethodBeat.o(7261);
      return;
      this.pIT.setTextColor(getResources().getColor(2131100041));
      this.pIU.setTextColor(getResources().getColor(2131100041));
      i = 2131231379;
      break;
      label369:
      this.pIU.setText((CharSequence)"");
      this.pIU.setVisibility(4);
    }
  }
  
  public final void setWriteCommentLayout(n paramn)
  {
    AppMethodBeat.i(7262);
    kotlin.g.b.p.h(paramn, "layout");
    this.pJa = paramn;
    AppMethodBeat.o(7262);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MPVideoHeaderView paramMPVideoHeaderView, as paramas) {}
    
    public final void run()
    {
      AppMethodBeat.i(7256);
      if (com.tencent.mm.aj.c.Mc(MPVideoHeaderView.c(this.pJb)) == null)
      {
        i locali = com.tencent.mm.aj.p.aYB().Mx(MPVideoHeaderView.c(this.pJb));
        if ((locali != null) && (!Util.isNullOrNil(locali.aYu()))) {
          d.a(MPVideoHeaderView.d(this.pJb), paramfp, locali.aYu(), true);
        }
      }
      AppMethodBeat.o(7256);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(MPVideoHeaderView paramMPVideoHeaderView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7257);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      MPVideoHeaderView.a(this.pJb).setVisibility(8);
      MPVideoHeaderView.b(this.pJb).setMaxLines(2147483647);
      MPVideoHeaderView.b(this.pJb).requestLayout();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7257);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(MPVideoHeaderView paramMPVideoHeaderView, nl paramnl) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setWow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (paramnl.KSS == 1) {
        MPVideoHeaderView.e(this.pJb).aJ(2, "");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView$setWow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7258);
        return;
        MPVideoHeaderView.e(this.pJb).aJ(1, "");
        MPVideoHeaderView.f(this.pJb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView
 * JD-Core Version:    0.7.0.1
 */