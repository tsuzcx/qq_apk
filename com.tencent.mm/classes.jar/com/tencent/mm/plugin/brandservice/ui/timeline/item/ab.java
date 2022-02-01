package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public final class ab
  extends ai
{
  public View mrE;
  public TextView sEY;
  public View sEZ;
  public View sFZ;
  public View sFa;
  public View sFb;
  public TextView sFc;
  public MMNeat7extView sFd;
  public TextView sGa;
  public MMNeat7extView sGb;
  
  public ab(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(265602);
    super.a(paramContext, paramb);
    AppMethodBeat.o(265602);
  }
  
  public final View b(final z paramz, final int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(265603);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 2L, 1L, false);
    Object localObject1 = this.mContext;
    if (this.sEi == null)
    {
      this.sEi = ((ViewStub)paramView2.findViewById(d.e.stw)).inflate();
      cAQ();
      this.sEY = ((TextView)this.sEi.findViewById(d.e.sqj));
      this.sEZ = this.sEi.findViewById(d.e.close_layout);
      this.sFa = this.sEi.findViewById(d.e.close_iv);
      this.sFb = this.sEi.findViewById(d.e.sqh);
      this.sFc = ((TextView)this.sEi.findViewById(d.e.sqi));
      this.sFd = ((MMNeat7extView)this.sEi.findViewById(d.e.spV));
      this.mrE = this.sEi.findViewById(d.e.sqg);
      this.sFZ = this.sEi.findViewById(d.e.spR);
      this.sGa = ((TextView)this.sEi.findViewById(d.e.spS));
      this.sGb = ((MMNeat7extView)this.sEi.findViewById(d.e.spT));
      ((WeImageView)this.sEi.findViewById(d.e.sse)).setIconColor(((Context)localObject1).getResources().getColor(d.b.BW_0_Alpha_0_9));
    }
    this.sEi.setVisibility(0);
    paramView2 = paramz.hwK();
    if ((paramView2 == null) || (paramView2.Usy == null))
    {
      paramView1.setVisibility(8);
      AppMethodBeat.o(265603);
      return paramView1;
    }
    paramView1.setVisibility(0);
    this.sEY.setText(paramView2.SwE);
    this.sEX.getPaint().setFakeBoldText(true);
    localObject1 = this.iZG;
    Object localObject2 = paramView2.Usy.RRW;
    c.a locala = new c.a();
    locala.lRS = d.d.brand_default_head;
    locala.lRC = true;
    locala.kPz = true;
    q.bml().a((String)localObject2, (ImageView)localObject1, locala.bmL());
    this.sEX.setText(paramView2.Usy.rWI);
    this.sFc.setText(paramView2.Usy.UsA);
    this.sFd.aL(paramView2.Usy.mVB);
    localObject1 = paramView2.Usy.UserName;
    localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject1);
    if ((localObject2 == null) || ((int)((d)localObject2).jxt <= 0)) {
      az.a.ltq.a((String)localObject1, "", null);
    }
    this.sFb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(266487);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = ab.this;
        localObject = this.iXG;
        eqg localeqg = paramz.hwL();
        if (localeqg == null) {
          Log.w("MicroMsg.BizTimeLineItem", "viewContactProfile wrapper is null");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266487);
          return;
          Intent localIntent = new Intent();
          localIntent.putExtra("Contact_User", (String)localObject);
          localIntent.putExtra("Contact_Scene", 160);
          localIntent.putExtra("KBizRecCardId", localeqg.Uaw);
          localIntent.putExtra("force_get_contact", true);
          localIntent.putExtra("key_use_new_contact_profile", true);
          com.tencent.mm.by.c.b(paramAnonymousView.mContext, "profile", ".ui.ContactInfoUI", localIntent);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 3L, 1L, false);
          paramAnonymousView.sHf.szZ.a((String)localObject, 0L, 0, 13, 0, localeqg.Uaw, true, 0);
        }
      }
    });
    if ((paramView2.RXM != null) && (paramView2.RXM.get(0) != null) && ((((eqc)paramView2.RXM.get(0)).RIs & 0x1) == 0))
    {
      localObject1 = (eqc)paramView2.RXM.get(0);
      this.sFZ.setVisibility(0);
      this.mrE.setVisibility(0);
      this.sGa.setText(paramView2.RXL);
      this.sGb.aL(((eqc)localObject1).fwr);
      this.sFZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(267081);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          paramAnonymousView = ab.this;
          localObject1 = paramz;
          Object localObject3 = this.sGd;
          if ((localObject3 == null) || (((z)localObject1).hwK() == null) || (((z)localObject1).hwK().Usy == null))
          {
            Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(267081);
            return;
          }
          eqd localeqd = ((z)localObject1).hwK().Usy;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 4L, 1L, false);
          Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { ((eqc)localObject3).RTk });
          Intent localIntent = new Intent();
          Object localObject2 = m.e(((eqc)localObject3).RTk, 138, 10000, 0);
          localIntent.putExtra("rawUrl", (String)localObject2);
          localIntent.putExtra("geta8key_scene", 56);
          localIntent.putExtra("geta8key_username", localeqd.UserName);
          localIntent.putExtra("srcUsername", localeqd.UserName);
          localIntent.putExtra("srcDisplayname", localeqd.rWI);
          localIntent.putExtra("prePublishId", "rec_card");
          localIntent.putExtra("KPublisherId", "rec_card");
          if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramAnonymousView.mContext, (String)localObject2, ((eqc)localObject3).lpx, 138, 10000, localIntent))) {
            Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
          }
          for (;;)
          {
            localObject3 = ((z)localObject1).hwL();
            int j;
            int i;
            if (localObject3 != null)
            {
              j = 0;
              i = j;
            }
            try
            {
              localObject2 = Uri.parse((String)localObject2);
              i = j;
              j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
              i = j;
              l = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
              i = j;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                long l = 0L;
              }
            }
            paramAnonymousView.sHf.szZ.a(((z)localObject1).field_talker, l, i, 15, 0, ((eqg)localObject3).Uaw, true, 0);
            paramAnonymousView.sHf.b((z)localObject1, 0);
            break;
            com.tencent.mm.by.c.b(paramAnonymousView.mContext, "webview", ".ui.tools.WebViewUI", localIntent);
          }
        }
      });
      this.sFb.setBackgroundResource(d.d.spF);
      if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (!Util.isNullOrNil(((eqc)localObject1).RTk)))
      {
        Log.d("MicroMsg.BizTimeLineItem", "preload %s", new Object[] { ((eqc)localObject1).RTk });
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(((eqc)localObject1).RTk, ((eqc)localObject1).lpx, 90, new Object[0]);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.brandservice.ui.b.c.x(paramz);
      localObject1 = paramz.hwL();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(265603);
      return paramView1;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 6L, 1L, false);
      this.mrE.setVisibility(8);
      this.sFZ.setVisibility(8);
      this.sFb.setBackgroundResource(d.d.spE);
    }
    localObject2 = paramView2.Usz;
    int i;
    if (localObject2 == null)
    {
      Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
      i = 0;
      if ((i != 0) || (!Util.isNullOrNil(((eqg)localObject1).UsE))) {
        break label922;
      }
      Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = %s", new Object[] { paramView2.Usy.rWI });
      this.sEZ.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(265603);
      return paramView1;
      if (((eqf)localObject2).UsC == null)
      {
        Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
        i = 0;
        break;
      }
      if (((eqf)localObject2).UsC.RXG != 1)
      {
        Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
        i = 0;
        break;
      }
      if (Util.isNullOrNil(((eqf)localObject2).UsC.RXF))
      {
        Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
        i = 0;
        break;
      }
      i = 1;
      break;
      label922:
      Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = %s", new Object[] { paramView2.Usy.rWI });
      this.sEZ.setVisibility(0);
      this.sEZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(266969);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = ab.this;
          localObject = ab.this.sFa;
          z localz = paramz;
          int j = paramInt;
          eqg localeqg = localz.hwL();
          if (localeqg == null) {
            Log.w("MicroMsg.BizTimeLineItem", "onUnLikeClick wrapper is null");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(266969);
            return;
            paramAnonymousView.sHf.szZ.a(localz.hwK().Usy.UserName, 0L, 0, 16, 0, localeqg.Uaw, true, 0);
            int i = 0;
            if ((localeqg.UsD == null) || (localeqg.UsD.Usz == null) || (localeqg.UsD.Usz.UsC == null) || (Util.isNullOrNil(localeqg.UsD.Usz.UsC.RXF))) {
              i = 1;
            }
            if ((Util.isNullOrNil(localeqg.UsE)) && (i != 0)) {
              Log.w("MicroMsg.BizTimeLineItem", "onUnLikeClick negativeFeedbackReason is null");
            } else {
              ((b)new b(((View)localObject).getContext(), localz, paramAnonymousView.sHf, j).iM((View)localObject)).show();
            }
          }
        }
      });
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(265604);
    if (this.sEi != null) {
      this.sEi.setVisibility(8);
    }
    AppMethodBeat.o(265604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ab
 * JD-Core Version:    0.7.0.1
 */