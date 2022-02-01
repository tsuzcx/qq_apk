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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
      paramContext.setBounds(0, 0, com.tencent.mm.plugin.appbrand.y.o.vP(16), com.tencent.mm.plugin.appbrand.y.o.vP(16));
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
    final com.tencent.mm.ah.a.b localb = com.tencent.mm.ah.a.b.zk(paramString);
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      ae.w("MicroMsg.WxaSubscribeMsgService", "context is null");
      AppMethodBeat.o(47709);
      return null;
    }
    paramString = localb.content;
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
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
        ae.i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { localb.content, localb.username, localb.path, this.lYE });
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("stat_scene", i);
        ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(l));
        ((Bundle)localObject).putString("stat_chat_talker_username", this.lYE);
        ((Bundle)localObject).putString("stat_send_msg_user", this.lYF);
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1088;
        localAppBrandStatObject.dlj = "";
        localAppBrandStatObject.dLf = com.tencent.mm.plugin.appbrand.report.l.l(localAppBrandStatObject.scene, (Bundle)localObject);
        localAppBrandStatObject.dLg = com.tencent.mm.plugin.appbrand.report.l.m(localAppBrandStatObject.scene, (Bundle)localObject);
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
        ((p)g.ab(p.class)).a(paramAnonymousView.getContext(), localb.username, null, localb.type, 0, (String)localObject, localAppBrandStatObject);
        ((com.tencent.mm.plugin.appbrand.service.o)g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).a(localb.username, new c.1.1(this));
        AppMethodBeat.o(47706);
      }
    }, paramString.indexOf(localb.title), paramString.indexOf(localb.title) + localb.title.length(), 17);
    ae.i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", new Object[] { Integer.valueOf(localb.hGU) });
    if (localb.hGU == 1)
    {
      AppMethodBeat.o(47709);
      return paramBundle;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.o)g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(localb.username);
    if (paramString != null) {}
    for (paramString = paramString.field_brandIconURL;; paramString = "")
    {
      localObject = com.tencent.mm.modelappbrand.a.b.aEl().a(paramString, null);
      if (localObject != null) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
      {
        public final String BN()
        {
          AppMethodBeat.i(47708);
          String str = c.class.getSimpleName();
          AppMethodBeat.o(47708);
          return str;
        }
        
        public final void F(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(47707);
          NeatTextView localNeatTextView = (NeatTextView)paramWeakReference1.get();
          Object localObject = (Context)paramWeakReference.get();
          if ((localObject != null) && (localNeatTextView != null))
          {
            paramAnonymousBitmap = new BitmapDrawable(((Context)localObject).getResources(), paramAnonymousBitmap);
            paramAnonymousBitmap.setBounds(0, 0, com.tencent.mm.plugin.appbrand.y.o.vP(16), com.tencent.mm.plugin.appbrand.y.o.vP(16));
            paramAnonymousBitmap = new com.tencent.mm.plugin.appbrand.widget.g.b(paramAnonymousBitmap);
            localObject = new SpannableString("@ ");
            ((SpannableString)localObject).setSpan(paramAnonymousBitmap, 0, 1, 33);
            localNeatTextView.aq(TextUtils.concat(new CharSequence[] { localObject, paramBundle }));
            localNeatTextView.invalidate();
          }
          AppMethodBeat.o(47707);
        }
        
        public final void aEt() {}
        
        public final void ox() {}
      }, paramString, null);
      paramString = TextUtils.concat(new CharSequence[] { a(localContext, localb.hGV, null), paramBundle });
      AppMethodBeat.o(47709);
      return paramString;
    }
    paramString = TextUtils.concat(new CharSequence[] { a(localContext, localb.hGV, (Bitmap)localObject), paramBundle });
    AppMethodBeat.o(47709);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.c
 * JD-Core Version:    0.7.0.1
 */