package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.exdevice.g.b.a.d;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/SportRankUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "handleRankRecordView", "", "info", "Lcom/tencent/mm/plugin/exdevice/rank/storage/info/ExdeviceRankInfo;", "holder", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$ExdeviceRankHolder;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.mvvmbase.a
{
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(274748);
    AppMethodBeat.o(274748);
  }
  
  private static final void b(TextView paramTextView, ImageView paramImageView, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(274754);
    kotlin.g.b.s.u(paramTextView, "$nickNameTV");
    kotlin.g.b.s.u(paramImageView, "$iconIV");
    if (paramWxaAttributes != null) {
      com.tencent.threadpool.h.ahAA.bk(new f..ExternalSyntheticLambda1(paramTextView, paramWxaAttributes, paramImageView));
    }
    AppMethodBeat.o(274754);
  }
  
  private static final void b(TextView paramTextView, WxaAttributes paramWxaAttributes, ImageView paramImageView)
  {
    AppMethodBeat.i(274751);
    kotlin.g.b.s.u(paramTextView, "$nickNameTV");
    kotlin.g.b.s.u(paramImageView, "$iconIV");
    paramTextView.setText((CharSequence)paramWxaAttributes.field_nickname);
    paramTextView = new c.a();
    paramTextView.nrc = true;
    paramTextView.oKo = true;
    paramTextView = paramTextView.bKx();
    r.bKe().a(paramWxaAttributes.field_smallHeadURL, paramImageView, paramTextView);
    AppMethodBeat.o(274751);
  }
  
  public final void a(d paramd, b.b paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(274763);
    fhc localfhc;
    if ((paramd != null) && (paramb != null))
    {
      localfhc = paramd.field_sportRecord;
      if (localfhc != null) {
        break label47;
      }
    }
    label47:
    label75:
    TextView localTextView;
    label240:
    label244:
    for (;;)
    {
      if (localObject == null) {
        paramb.yCa.setVisibility(8);
      }
      AppMethodBeat.o(274763);
      return;
      int i;
      if ((localfhc.abHH == 0) || (localfhc.abHH == 1) || (localfhc.abHH == 2))
      {
        i = 1;
        if (i == 0) {
          break label240;
        }
      }
      for (;;)
      {
        if (localfhc == null) {
          break label244;
        }
        paramb.yCa.setVisibility(0);
        localTextView = paramb.yCc;
        kotlin.g.b.s.s(localTextView, "holder.appBrandNickNameTV");
        paramb.yCd.setText((CharSequence)paramd.field_sportRecord.abHD);
        paramb.yCe.setText((CharSequence)String.valueOf(paramd.field_sportRecord.abHE));
        paramb.yCf.setText((CharSequence)paramd.field_sportRecord.abHF);
        localObject = paramb.yCb;
        kotlin.g.b.s.s(localObject, "holder.appBrandIconIV");
        if (localfhc.abHH != 0) {
          break label288;
        }
        if (kotlin.g.b.s.p("21f9d636b41b25be", paramd.field_sportRecord.appId)) {
          break label246;
        }
        ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).b(paramd.field_sportRecord.appId, new f..ExternalSyntheticLambda0(localTextView, (ImageView)localObject));
        localObject = paramb.yCa;
        break;
        i = 0;
        break label75;
        localfhc = null;
      }
    }
    label246:
    localTextView.setText(R.l.gWv);
    ((ImageView)localObject).setImageResource(R.k.icons_outlined_apple_watch);
    ((ImageView)localObject).setColorFilter(com.tencent.mm.cd.a.w((Context)getContext(), R.e.Purple_100));
    for (;;)
    {
      localObject = ah.aiuX;
      break;
      label288:
      if (localfhc.abHH == 1)
      {
        localTextView.setText((CharSequence)paramd.field_sportRecord.appName);
        paramd = new c.a();
        paramd.oKn = true;
        paramd.oKp = true;
        paramd.nrc = true;
        paramd = paramd.bKx();
        r.bKe().a(localfhc.phA, (ImageView)localObject, paramd);
      }
      else if (localfhc.abHH == 2)
      {
        Log.i("SimpleUIComponent", "handleRankRecordView: sportRecord.recordSourceType == SportProfileUIC.RECORD_SOURCE_TYPE_WINTER_OLYMPIC ");
        localTextView.setText(R.l.gHf);
        ((ImageView)localObject).setImageResource(R.k.rank_torch);
        paramb.yCd.setText((CharSequence)"");
        paramb.yCe.setText((CharSequence)"");
        paramb.yCf.setText((CharSequence)"");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.f
 * JD-Core Version:    0.7.0.1
 */