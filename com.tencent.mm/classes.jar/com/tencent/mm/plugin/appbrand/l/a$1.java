package com.tencent.mm.plugin.appbrand.l;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import com.tencent.mm.ae.a.b;
import com.tencent.mm.h.b.a.aw;
import com.tencent.mm.h.b.a.aw.a;
import com.tencent.mm.h.b.a.aw.b;
import com.tencent.mm.h.b.a.aw.c;
import com.tencent.mm.h.b.a.aw.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  a$1(a parama, com.tencent.mm.ae.a.a parama1, String paramString1, int paramInt, long paramLong, String paramString2) {}
  
  public final void onClickImp(View paramView)
  {
    y.i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { this.gPF.content, this.gPF.username, this.gPF.path, this.gPG });
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("stat_scene", this.egz);
    ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(this.eos));
    ((Bundle)localObject1).putString("stat_chat_talker_username", this.gPG);
    ((Bundle)localObject1).putString("stat_send_msg_user", this.gPH);
    Object localObject3 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject3).scene = 1088;
    ((AppBrandStatObject)localObject3).bFv = "";
    ((AppBrandStatObject)localObject3).caB = f.g(((AppBrandStatObject)localObject3).scene, (Bundle)localObject1);
    ((AppBrandStatObject)localObject3).caC = f.h(((AppBrandStatObject)localObject3).scene, (Bundle)localObject1);
    Object localObject2 = "";
    localObject1 = localObject2;
    if (this.gPF.path != null)
    {
      localObject1 = localObject2;
      if (this.gPF.path.length() > 0)
      {
        localObject4 = Base64.decode(this.gPF.path, 2);
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = new String((byte[])localObject4);
        }
      }
    }
    ((d)g.r(d.class)).a(paramView.getContext(), this.gPF.username, null, this.gPF.type, 0, (String)localObject1, (AppBrandStatObject)localObject3);
    Object localObject4 = ((k)g.r(k.class)).jv(this.gPF.dTX);
    paramView = aw.c.cqr;
    localObject3 = aw.d.cqv;
    localObject2 = paramView;
    localObject1 = localObject3;
    if (localObject4 != null)
    {
      if (((b)localObject4).field_msgState == 1)
      {
        paramView = aw.c.cqt;
        if (((b)localObject4).field_btnState != 2) {
          break label468;
        }
        localObject1 = aw.d.cqx;
        localObject2 = paramView;
      }
    }
    else
    {
      label331:
      localObject3 = new aw();
      ((aw)localObject3).ckG = this.gPF.appId;
      ((aw)localObject3).cpZ = this.gPF.path;
      ((aw)localObject3).cqb = this.gPF.path;
      ((aw)localObject3).cqc = this.gPG;
      if (!this.gPG.toLowerCase().endsWith("@chatroom")) {
        break label499;
      }
    }
    label468:
    label499:
    for (paramView = aw.b.cqo;; paramView = aw.b.cqp)
    {
      ((aw)localObject3).cqd = paramView;
      ((aw)localObject3).cqe = aw.a.cql;
      ((aw)localObject3).cic = 0L;
      ((aw)localObject3).cqf = "";
      paramView = ((aw)localObject3).ve();
      paramView.cqg = ((aw.c)localObject2);
      paramView.cqh = ((aw.d)localObject1);
      paramView.QX();
      return;
      if (((b)localObject4).field_msgState != 0) {
        break;
      }
      paramView = aw.c.cqs;
      break;
      if (((b)localObject4).field_btnState != 0)
      {
        localObject2 = paramView;
        localObject1 = localObject3;
        if (((b)localObject4).field_btnState != 1) {
          break label331;
        }
      }
      localObject1 = aw.d.cqw;
      localObject2 = paramView;
      break label331;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.a.1
 * JD-Core Version:    0.7.0.1
 */