package com.tencent.mm.plugin.appbrand.message;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.g.b.a.jo.a;
import com.tencent.mm.g.b.a.jo.b;
import com.tencent.mm.g.b.a.jo.c;
import com.tencent.mm.g.b.a.jo.d;
import com.tencent.mm.g.b.a.jo.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

public class c
  implements com.tencent.mm.modelappbrand.l
{
  private static SpannableString a(Context paramContext, int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(47710);
    if (paramBitmap == null) {
      if (paramInt == 1) {
        paramInt = 2131691252;
      }
    }
    for (paramContext = paramContext.getResources().getDrawable(paramInt);; paramContext = new BitmapDrawable(paramContext.getResources(), paramBitmap))
    {
      paramContext.setBounds(0, 0, com.tencent.mm.plugin.appbrand.z.o.vK(16), com.tencent.mm.plugin.appbrand.z.o.vK(16));
      paramContext = new com.tencent.mm.plugin.appbrand.widget.g.b(paramContext);
      paramBitmap = new SpannableString("@ ");
      paramBitmap.setSpan(paramContext, 0, 1, 33);
      AppMethodBeat.o(47710);
      return paramBitmap;
      paramInt = 2131691249;
      break;
    }
  }
  
  public final CharSequence a(String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(47709);
    final com.tencent.mm.ai.a.b localb = com.tencent.mm.ai.a.b.yA(paramString);
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      ad.w("MicroMsg.WxaSubscribeMsgService", "context is null");
      AppMethodBeat.o(47709);
      return null;
    }
    paramString = localb.content;
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
      AppMethodBeat.o(47709);
      return null;
    }
    Object localObject = paramBundle.getString("conv_talker_username");
    final int i = paramBundle.getInt("scene");
    final long l = paramBundle.getLong("msg_sever_id");
    String str = paramBundle.getString("send_msg_username");
    paramBundle = new SpannableString(paramString);
    paramBundle.setSpan(new a()
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(47706);
        ad.i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { localb.content, localb.username, localb.path, this.lUb });
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("stat_scene", i);
        ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(l));
        ((Bundle)localObject).putString("stat_chat_talker_username", this.lUb);
        ((Bundle)localObject).putString("stat_send_msg_user", this.lUc);
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1088;
        localAppBrandStatObject.dkh = "";
        localAppBrandStatObject.dJQ = com.tencent.mm.plugin.appbrand.report.l.l(localAppBrandStatObject.scene, (Bundle)localObject);
        localAppBrandStatObject.dJR = com.tencent.mm.plugin.appbrand.report.l.m(localAppBrandStatObject.scene, (Bundle)localObject);
        String str = "";
        localObject = str;
        if (localb.path != null)
        {
          localObject = str;
          if (localb.path.length() > 0)
          {
            byte[] arrayOfByte = Base64.decode(localb.path, 2);
            localObject = str;
            if (arrayOfByte != null) {
              localObject = new String(arrayOfByte);
            }
          }
        }
        ((com.tencent.mm.plugin.appbrand.service.o)g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).a(paramAnonymousView.getContext(), localb.username, null, localb.type, 0, (String)localObject, localAppBrandStatObject);
        ((n)g.ab(n.class)).a(localb.username, new n.a()
        {
          public final void b(WxaAttributes paramAnonymous2WxaAttributes)
          {
            AppMethodBeat.i(47705);
            com.tencent.mm.ai.a.c localc = ((m)g.ab(m.class)).Cd(c.1.this.lUa.cmu);
            Object localObject1 = jo.d.eBO;
            jo.e locale2 = jo.e.eBS;
            Object localObject2 = localObject1;
            jo.e locale1 = locale2;
            label81:
            int i;
            if (localc != null)
            {
              if (localc.field_msgState == 1)
              {
                localObject1 = jo.d.eBQ;
                if (localc.field_btnState != 2) {
                  break label248;
                }
                locale1 = jo.e.eBU;
                localObject2 = localObject1;
              }
            }
            else
            {
              if (paramAnonymous2WxaAttributes.bel() != null) {
                break label283;
              }
              i = 0;
              label90:
              localObject1 = new jo().sd(c.1.this.lUa.appId).se(c.1.this.lUa.path).sf(c.1.this.lUa.path).sg(c.1.this.lUb);
              if (!c.1.this.lUb.toLowerCase().endsWith("@chatroom")) {
                break label294;
              }
            }
            label283:
            label294:
            for (paramAnonymous2WxaAttributes = jo.c.eBL;; paramAnonymous2WxaAttributes = jo.c.eBM)
            {
              ((jo)localObject1).eBr = paramAnonymous2WxaAttributes;
              ((jo)localObject1).eBs = jo.b.eBI;
              ((jo)localObject1).dVd = 0L;
              paramAnonymous2WxaAttributes = ((jo)localObject1).sh("");
              paramAnonymous2WxaAttributes.eBw = jo.a.jT(i + 1000);
              paramAnonymous2WxaAttributes = paramAnonymous2WxaAttributes.Vs();
              paramAnonymous2WxaAttributes.eBu = localObject2;
              paramAnonymous2WxaAttributes.eBv = locale1;
              paramAnonymous2WxaAttributes.aLk();
              AppMethodBeat.o(47705);
              return;
              if (localc.field_msgState != 0) {
                break;
              }
              localObject1 = jo.d.eBP;
              break;
              label248:
              if (localc.field_btnState != 0)
              {
                localObject2 = localObject1;
                locale1 = locale2;
                if (localc.field_btnState != 1) {
                  break label81;
                }
              }
              locale1 = jo.e.eBT;
              localObject2 = localObject1;
              break label81;
              i = paramAnonymous2WxaAttributes.bel().cQN;
              break label90;
            }
          }
        });
        AppMethodBeat.o(47706);
      }
    }, paramString.indexOf(localb.title), paramString.indexOf(localb.title) + localb.title.length(), 17);
    ad.i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", new Object[] { Integer.valueOf(localb.hEc) });
    if (localb.hEc == 1)
    {
      AppMethodBeat.o(47709);
      return paramBundle;
    }
    paramString = ((n)g.ab(n.class)).Nt(localb.username);
    if (paramString != null) {}
    for (paramString = paramString.field_brandIconURL;; paramString = "")
    {
      localObject = com.tencent.mm.modelappbrand.a.b.aDV().a(paramString, null);
      if (localObject != null) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
      {
        public final String BM()
        {
          AppMethodBeat.i(47708);
          String str = c.class.getSimpleName();
          AppMethodBeat.o(47708);
          return str;
        }
        
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(47707);
          NeatTextView localNeatTextView = (NeatTextView)paramWeakReference1.get();
          Object localObject = (Context)paramWeakReference.get();
          if ((localObject != null) && (localNeatTextView != null))
          {
            paramAnonymousBitmap = new BitmapDrawable(((Context)localObject).getResources(), paramAnonymousBitmap);
            paramAnonymousBitmap.setBounds(0, 0, com.tencent.mm.plugin.appbrand.z.o.vK(16), com.tencent.mm.plugin.appbrand.z.o.vK(16));
            paramAnonymousBitmap = new com.tencent.mm.plugin.appbrand.widget.g.b(paramAnonymousBitmap);
            localObject = new SpannableString("@ ");
            ((SpannableString)localObject).setSpan(paramAnonymousBitmap, 0, 1, 33);
            localNeatTextView.ar(TextUtils.concat(new CharSequence[] { localObject, paramBundle }));
            localNeatTextView.invalidate();
          }
          AppMethodBeat.o(47707);
        }
        
        public final void aEd() {}
        
        public final void ox() {}
      }, paramString, null);
      paramString = TextUtils.concat(new CharSequence[] { a(localContext, localb.hEd, null), paramBundle });
      AppMethodBeat.o(47709);
      return paramString;
    }
    paramString = TextUtils.concat(new CharSequence[] { a(localContext, localb.hEd, (Bitmap)localObject), paramBundle });
    AppMethodBeat.o(47709);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.c
 * JD-Core Version:    0.7.0.1
 */