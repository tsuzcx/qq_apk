package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.content.Context;
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
import com.tencent.mm.af.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "avatarIv", "Landroid/widget/ImageView;", "avatarLayout", "Landroid/widget/LinearLayout;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "dataLayout", "Landroid/view/View;", "descLayout", "descMoreLayout", "descTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "haoKanTv", "Landroid/widget/TextView;", "haokanCountTv", "haokanTipsIcon", "haokanTipsLayout", "haokanTipsShareTv", "maliciousTipsTv", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "needShowHaokanView", "", "nicknameTv", "readCountTv", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "talker", "timeTv", "titleTv", "writeCommentLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;", "initAvatarNickName", "", "initData", "initView", "onAppMsgLike", "setDesc", "setMaliciousInfo", "info", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setOriginInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgExtBaseAppMsgInfo;", "setWow", "setWriteCommentLayout", "layout", "showHaoKanView", "update", "plugin-brandservice_release"})
public final class MPVideoHeaderView
  extends RelativeLayout
{
  private final String TAG;
  private ImageView ehv;
  private com.tencent.mm.af.s jXm;
  private b jXn;
  private q kfw;
  private boolean kgE;
  private LinearLayout kgF;
  private TextView kgG;
  private MMNeat7extView kgH;
  private MMNeat7extView kgI;
  private View kgJ;
  private View kgK;
  private TextView kgL;
  private TextView kgM;
  private TextView kgN;
  private TextView kgO;
  private View kgP;
  private TextView kgQ;
  private ImageView kgR;
  private View kgS;
  private MPWriteCommentLayout kgv;
  private String talker;
  private TextView timeTv;
  
  public MPVideoHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(15266);
    this.TAG = "MicroMsg.MPVideoHeaderView";
    this.talker = "";
    View.inflate(paramContext, 2130970310, (ViewGroup)this);
    paramAttributeSet = findViewById(2131826361);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_avatar_layout)");
    this.kgF = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131826342);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_avatar_iv)");
    this.ehv = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826362);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_nick_name_tv)");
    this.kgG = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826364);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_title_tv)");
    this.kgH = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826367);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_desc_tv)");
    this.kgI = ((MMNeat7extView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826368);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_desc_show_more_layout)");
    this.kgJ = paramAttributeSet;
    paramAttributeSet = findViewById(2131826366);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_desc_layout)");
    this.kgK = paramAttributeSet;
    paramAttributeSet = findViewById(2131826370);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_time_tv)");
    this.timeTv = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826371);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_read_count_tv)");
    this.kgL = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826373);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_haokan_tv)");
    this.kgM = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826372);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_haokan_count_tv)");
    this.kgN = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826365);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_malicious_tips)");
    this.kgO = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826374);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_layout)");
    this.kgP = paramAttributeSet;
    paramAttributeSet = findViewById(2131826377);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_vi…_write_wow_tips_share_tv)");
    this.kgQ = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826375);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_write_wow_tips_icon)");
    this.kgR = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131826369);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.biz_video_header_data_layout)");
    this.kgS = paramAttributeSet;
    paramAttributeSet = this.kgH.getPaint();
    a.f.b.j.p(paramAttributeSet, "tp");
    paramAttributeSet.setFakeBoldText(true);
    this.kgF.setOnClickListener((View.OnClickListener)new MPVideoHeaderView.1(this, paramContext));
    AppMethodBeat.o(15266);
  }
  
  public final void setMaliciousInfo(bca parambca)
  {
    AppMethodBeat.i(15257);
    a.f.b.j.q(parambca, "info");
    this.kgO.setVisibility(0);
    this.kgO.setText((CharSequence)parambca.xrf);
    AppMethodBeat.o(15257);
  }
  
  public final void setOriginInfo(ei paramei)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(15258);
    a.f.b.j.q(paramei, "info");
    Object localObject3 = this.kfw;
    if (localObject3 == null) {
      a.f.b.j.ays("readerItem");
    }
    ((q)localObject3).title = paramei.title;
    localObject3 = this.kfw;
    if (localObject3 == null) {
      a.f.b.j.ays("readerItem");
    }
    ((q)localObject3).fjL = paramei.fjL;
    a.b.s(this.ehv, this.talker);
    paramei = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(paramei, "MMKernel.service(IMessengerStorage::class.java)");
    paramei = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramei).YA().arw(this.talker);
    if ((paramei == null) || (paramei.Od() <= 0))
    {
      paramei = this.jXm;
      if (paramei == null) {
        a.f.b.j.ays("msgInfo");
      }
      if (paramei != null)
      {
        paramei = paramei.fjB;
        localObject3 = this.ehv;
        localObject1 = this.jXm;
        if (localObject1 == null) {
          a.f.b.j.ays("msgInfo");
        }
        if (localObject1 == null) {
          break label551;
        }
        localObject1 = ((com.tencent.mm.af.s)localObject1).HD();
        label185:
        ((ImageView)localObject3).setTag(localObject1);
        localObject3 = new WeakReference(this.ehv);
        ao.b localb = ao.a.aaj();
        com.tencent.mm.af.s locals = this.jXm;
        if (locals == null) {
          a.f.b.j.ays("msgInfo");
        }
        localObject1 = localObject2;
        if (locals != null) {
          localObject1 = locals.HD();
        }
        localb.a((String)localObject1, "", (ao.b.a)new MPVideoHeaderView.a((WeakReference)localObject3));
      }
    }
    for (;;)
    {
      paramei = com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), (CharSequence)(paramei + "  "), this.kgG.getTextSize());
      localObject1 = getContext();
      a.f.b.j.p(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2130837987);
      int i = (int)this.kgG.getTextSize();
      ((Drawable)localObject1).setBounds(0, 0, i / 2, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.kgG.setText(TextUtils.concat(new CharSequence[] { (CharSequence)paramei, (CharSequence)localObject2 }));
      paramei = this.timeTv;
      localObject1 = getContext();
      localObject2 = this.jXm;
      if (localObject2 == null) {
        a.f.b.j.ays("msgInfo");
      }
      paramei.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.e((Context)localObject1, ((com.tencent.mm.af.s)localObject2).fjD.time * 1000L));
      paramei = this.kfw;
      if (paramei == null) {
        a.f.b.j.ays("readerItem");
      }
      if (bo.isNullOrNil(paramei.fjL)) {
        this.kgK.setVisibility(8);
      }
      label551:
      label606:
      label864:
      for (;;)
      {
        paramei = this.kgH;
        localObject1 = this.jXm;
        if (localObject1 == null) {
          a.f.b.j.ays("msgInfo");
        }
        paramei.af((CharSequence)((com.tencent.mm.af.s)localObject1).fjD.title);
        AppMethodBeat.o(15258);
        return;
        paramei = null;
        break;
        localObject1 = null;
        break label185;
        if (!paramei.NT()) {
          al.p((Runnable)new MPVideoHeaderView.b(this, paramei), 200L);
        }
        paramei = this.jXm;
        if (paramei == null) {
          a.f.b.j.ays("msgInfo");
        }
        if (paramei != null)
        {
          paramei = paramei.HD();
          localObject2 = com.tencent.mm.model.s.nE(paramei);
          if (!bo.isEqual((String)localObject2, this.talker)) {
            break label866;
          }
          paramei = this.jXm;
          if (paramei == null) {
            a.f.b.j.ays("msgInfo");
          }
          if (paramei == null) {
            break label694;
          }
        }
        for (paramei = paramei.fjB;; paramei = null)
        {
          if (bo.isNullOrNil(paramei)) {
            break label866;
          }
          localObject2 = this.jXm;
          if (localObject2 == null) {
            a.f.b.j.ays("msgInfo");
          }
          paramei = (ei)localObject1;
          if (localObject2 == null) {
            break;
          }
          paramei = ((com.tencent.mm.af.s)localObject2).fjB;
          break;
          paramei = null;
          break label606;
        }
        this.kgK.setVisibility(0);
        paramei = this.kgI;
        localObject1 = this.kfw;
        if (localObject1 == null) {
          a.f.b.j.ays("readerItem");
        }
        if (localObject1 == null) {
          a.f.b.j.ebi();
        }
        paramei.af((CharSequence)((q)localObject1).fjL);
        i = com.tencent.mm.cb.a.gw(getContext());
        int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
        paramei = this.kgI.Sa(i - j);
        if (paramei != null) {}
        for (i = paramei.dTo();; i = 0)
        {
          if (i <= 4) {
            break label864;
          }
          float f = this.kgI.getTextSize();
          this.kgI.a(TextUtils.TruncateAt.END, f);
          this.kgJ.setMinimumHeight((int)f);
          this.kgJ.setVisibility(0);
          this.kgI.setMaxLines(4);
          this.kgK.setOnClickListener((View.OnClickListener)new MPVideoHeaderView.c(this));
          break;
        }
      }
      label694:
      label866:
      paramei = (ei)localObject2;
    }
  }
  
  public final void setWow(kh paramkh)
  {
    AppMethodBeat.i(15263);
    a.f.b.j.q(paramkh, "appMsgStat");
    if (paramkh.wxK != 1)
    {
      this.kgM.setVisibility(8);
      this.kgN.setVisibility(8);
      AppMethodBeat.o(15263);
      return;
    }
    this.kgM.setVisibility(0);
    this.kgN.setVisibility(0);
    int i;
    String str;
    Object localObject1;
    Object localObject2;
    if (paramkh.wxJ == 1)
    {
      this.kgM.setTextColor(getResources().getColor(2131689760));
      this.kgN.setTextColor(getResources().getColor(2131689760));
      i = 2130838010;
      str = getContext().getString(2131297733);
      if (paramkh.wxI <= 0) {
        break label362;
      }
      this.kgN.setVisibility(0);
      localObject1 = this.kgN;
      localObject2 = getContext();
      a.f.b.j.p(localObject2, "context");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(e.H((Context)localObject2, paramkh.wxI)));
    }
    for (;;)
    {
      localObject1 = getContext();
      a.f.b.j.p(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getDrawable(i);
      i = (int)(this.kgG.getTextSize() * 1.3D);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new com.tencent.mm.ui.widget.a((Drawable)localObject1);
      localObject2 = new SpannableString((CharSequence)"@");
      ((SpannableString)localObject2).setSpan(localObject1, 0, 1, 33);
      this.kgM.setText(TextUtils.concat(new CharSequence[] { (CharSequence)localObject2, (CharSequence)" ", (CharSequence)str }));
      this.kgM.setOnClickListener((View.OnClickListener)new MPVideoHeaderView.d(this, paramkh));
      AppMethodBeat.o(15263);
      return;
      this.kgM.setTextColor(getResources().getColor(2131689762));
      this.kgN.setTextColor(getResources().getColor(2131689762));
      i = 2130838009;
      break;
      label362:
      this.kgN.setText((CharSequence)"");
      this.kgN.setVisibility(4);
    }
  }
  
  public final void setWriteCommentLayout(MPWriteCommentLayout paramMPWriteCommentLayout)
  {
    AppMethodBeat.i(152886);
    a.f.b.j.q(paramMPWriteCommentLayout, "layout");
    this.kgv = paramMPWriteCommentLayout;
    AppMethodBeat.o(152886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoHeaderView
 * JD-Core Version:    0.7.0.1
 */