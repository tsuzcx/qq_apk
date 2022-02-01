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
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public final class aa
  extends ag
{
  public View jBI;
  public TextView pvH;
  public View pvI;
  public View pvJ;
  public View pvK;
  public TextView pvL;
  public MMNeat7extView pvM;
  public View pwD;
  public TextView pwE;
  public MMNeat7extView pwF;
  
  public aa(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(194967);
    super.a(paramContext, paramb);
    AppMethodBeat.o(194967);
  }
  
  public final View b(final z paramz, final int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(194968);
    h.CyF.idkeyStat(1149L, 2L, 1L, false);
    Object localObject1 = this.mContext;
    if (this.puO == null)
    {
      this.puO = ((ViewStub)paramView2.findViewById(2131309884)).inflate();
      cne();
      this.pvH = ((TextView)this.puO.findViewById(2131297500));
      this.pvI = this.puO.findViewById(2131298783);
      this.pvJ = this.puO.findViewById(2131298782);
      this.pvK = this.puO.findViewById(2131297498);
      this.pvL = ((TextView)this.puO.findViewById(2131297499));
      this.pvM = ((MMNeat7extView)this.puO.findViewById(2131297486));
      this.jBI = this.puO.findViewById(2131297497);
      this.pwD = this.puO.findViewById(2131297482);
      this.pwE = ((TextView)this.puO.findViewById(2131297483));
      this.pwF = ((MMNeat7extView)this.puO.findViewById(2131297484));
      ((WeImageView)this.puO.findViewById(2131305223)).setIconColor(((Context)localObject1).getResources().getColor(2131099669));
    }
    this.puO.setVisibility(0);
    paramView2 = paramz.gAC();
    if ((paramView2 == null) || (paramView2.NfT == null))
    {
      paramView1.setVisibility(8);
      AppMethodBeat.o(194968);
      return paramView1;
    }
    paramView1.setVisibility(0);
    this.pvH.setText(paramView2.Lug);
    this.pvG.getPaint().setFakeBoldText(true);
    localObject1 = this.gvv;
    Object localObject2 = paramView2.NfT.KQY;
    c.a locala = new c.a();
    locala.jbt = 2131231405;
    locala.jbe = true;
    locala.iaT = true;
    q.bcV().a((String)localObject2, (ImageView)localObject1, locala.bdv());
    this.pvG.setText(paramView2.NfT.oUJ);
    this.pvL.setText(paramView2.NfT.NfV);
    this.pvM.aw(paramView2.NfT.keb);
    localObject1 = paramView2.NfT.UserName;
    localObject2 = ((l)g.af(l.class)).aSN().Kn((String)localObject1);
    if ((localObject2 == null) || ((int)((com.tencent.mm.contact.c)localObject2).gMZ <= 0)) {
      ay.a.iDq.a((String)localObject1, "", null);
    }
    this.pvK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194964);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = aa.this;
        localObject = this.gtu;
        ege localege = paramz.gAD();
        if (localege == null) {
          Log.w("MicroMsg.BizTimeLineItem", "viewContactProfile wrapper is null");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194964);
          return;
          Intent localIntent = new Intent();
          localIntent.putExtra("Contact_User", (String)localObject);
          localIntent.putExtra("Contact_Scene", 160);
          localIntent.putExtra("KBizRecCardId", localege.MOC);
          localIntent.putExtra("force_get_contact", true);
          localIntent.putExtra("key_use_new_contact_profile", true);
          com.tencent.mm.br.c.b(paramAnonymousView.mContext, "profile", ".ui.ContactInfoUI", localIntent);
          h.CyF.idkeyStat(1149L, 3L, 1L, false);
          paramAnonymousView.pxE.pqZ.a((String)localObject, 0L, 0, 13, 0, localege.MOC, true, 0);
        }
      }
    });
    if ((paramView2.KWy != null) && (paramView2.KWy.get(0) != null) && ((((ega)paramView2.KWy.get(0)).KHa & 0x1) == 0))
    {
      localObject1 = (ega)paramView2.KWy.get(0);
      this.pwD.setVisibility(0);
      this.jBI.setVisibility(0);
      this.pwE.setText(paramView2.KWx);
      this.pwF.aw(((ega)localObject1).Title);
      this.pwD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194965);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
          localObject1 = aa.this;
          z localz = paramz;
          ega localega = this.pwH;
          if ((localega == null) || (localz.gAC() == null) || (localz.gAC().NfT == null))
          {
            Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194965);
            return;
          }
          Object localObject3 = localz.gAC().NfT;
          h.CyF.idkeyStat(1149L, 4L, 1L, false);
          Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { localega.KSj });
          Intent localIntent = new Intent();
          Object localObject2 = m.d(localega.KSj, 138, 10000, 0);
          localIntent.putExtra("rawUrl", (String)localObject2);
          localIntent.putExtra("geta8key_scene", 56);
          localIntent.putExtra("geta8key_username", ((egb)localObject3).UserName);
          localIntent.putExtra("srcUsername", ((egb)localObject3).UserName);
          localIntent.putExtra("srcDisplayname", ((egb)localObject3).oUJ);
          localIntent.putExtra("prePublishId", "rec_card");
          localIntent.putExtra("KPublisherId", "rec_card");
          int i;
          int j;
          if ((localega.iAb == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()))
          {
            localIntent.putExtra(e.b.OyQ, 138);
            localIntent.putExtra(e.b.OyR, 10000);
            localIntent.putExtra("biz_video_session_id", ab.getSessionId());
            x localx = new x();
            localx.iAh = localIntent.getStringExtra("KPublisherId");
            localx.dHc = ((egb)localObject3).UserName;
            localx.iAg = ((egb)localObject3).oUJ;
            localx.iAi.url = ((String)localObject2);
            localx.iAi.title = localega.Title;
            localx.iAi.iAq = localega.KSh;
            localx.iAi.iAo = localega.KSl;
            localx.iAi.type = localega.iAb;
            localx.iAi.time = localega.CreateTime;
            localx.iAi.iAs = localega.KSx;
            localx.iAi.videoWidth = localega.KSv;
            localx.iAi.videoHeight = localega.KSw;
            localx.iAi.vid = localega.KSu;
            localx.t(localIntent);
            Log.i("MicroMsg.BizTimeLineItem", "jump to native video");
            localObject3 = new int[2];
            if (paramAnonymousView != null)
            {
              i = paramAnonymousView.getWidth();
              j = paramAnonymousView.getHeight();
              paramAnonymousView.getLocationInWindow((int[])localObject3);
              localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", localObject3[0]).putExtra("img_gallery_top", localObject3[1]);
            }
            localIntent.addFlags(268435456);
          }
          if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(((aa)localObject1).mContext, (String)localObject2, localega.iAb, 138, 10000, localIntent))) {
            Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
          }
          for (;;)
          {
            paramAnonymousView = localz.gAD();
            if (paramAnonymousView != null)
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
            ((aa)localObject1).pxE.pqZ.a(localz.field_talker, l, i, 15, 0, paramAnonymousView.MOC, true, 0);
            ((aa)localObject1).pxE.b(localz, 0);
            break;
            com.tencent.mm.br.c.b(((aa)localObject1).mContext, "webview", ".ui.tools.WebViewUI", localIntent);
          }
        }
      });
      this.pvK.setBackgroundResource(2131231322);
      if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (!Util.isNullOrNil(((ega)localObject1).KSj)))
      {
        Log.d("MicroMsg.BizTimeLineItem", "preload %s", new Object[] { ((ega)localObject1).KSj });
        ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(((ega)localObject1).KSj, ((ega)localObject1).iAb, 90, new Object[0]);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.brandservice.ui.b.c.x(paramz);
      localObject1 = paramz.gAD();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(194968);
      return paramView1;
      h.CyF.idkeyStat(1149L, 6L, 1L, false);
      this.jBI.setVisibility(8);
      this.pwD.setVisibility(8);
      this.pvK.setBackgroundResource(2131231316);
    }
    localObject2 = paramView2.NfU;
    int i;
    if (localObject2 == null)
    {
      Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
      i = 0;
      if ((i != 0) || (!Util.isNullOrNil(((ege)localObject1).NfZ))) {
        break label907;
      }
      Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = %s", new Object[] { paramView2.NfT.oUJ });
      this.pvI.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(194968);
      return paramView1;
      if (((egd)localObject2).NfX == null)
      {
        Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
        i = 0;
        break;
      }
      if (((egd)localObject2).NfX.KWs != 1)
      {
        Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
        i = 0;
        break;
      }
      if (Util.isNullOrNil(((egd)localObject2).NfX.KWr))
      {
        Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
        i = 0;
        break;
      }
      i = 1;
      break;
      label907:
      Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = %s", new Object[] { paramView2.NfT.oUJ });
      this.pvI.setVisibility(0);
      this.pvI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194966);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = aa.this;
          localObject = aa.this.pvJ;
          z localz = paramz;
          int j = paramInt;
          ege localege = localz.gAD();
          if (localege == null) {
            Log.w("MicroMsg.BizTimeLineItem", "onUnLikeClick wrapper is null");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardOld$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194966);
            return;
            paramAnonymousView.pxE.pqZ.a(localz.gAC().NfT.UserName, 0L, 0, 16, 0, localege.MOC, true, 0);
            int i = 0;
            if ((localege.NfY == null) || (localege.NfY.NfU == null) || (localege.NfY.NfU.NfX == null) || (Util.isNullOrNil(localege.NfY.NfU.NfX.KWr))) {
              i = 1;
            }
            if ((Util.isNullOrNil(localege.NfZ)) && (i != 0)) {
              Log.w("MicroMsg.BizTimeLineItem", "onUnLikeClick negativeFeedbackReason is null");
            } else {
              ((b)new b(((View)localObject).getContext(), localz, paramAnonymousView.pxE, j).hw((View)localObject)).show();
            }
          }
        }
      });
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(194969);
    if (this.puO != null) {
      this.puO.setVisibility(8);
    }
    AppMethodBeat.o(194969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.aa
 * JD-Core Version:    0.7.0.1
 */