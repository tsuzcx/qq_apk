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
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.af.q;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

public class c
  implements l
{
  private static SpannableString a(Context paramContext, int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(47710);
    if (paramBitmap == null) {
      if (paramInt == 1) {
        paramInt = ba.h.spannable_wxa_game_link_logo;
      }
    }
    for (paramContext = paramContext.getResources().getDrawable(paramInt);; paramContext = new BitmapDrawable(paramContext.getResources(), paramBitmap))
    {
      paramContext.setBounds(0, 0, q.DD(16), q.DD(16));
      paramContext = new com.tencent.mm.plugin.appbrand.widget.j.b(paramContext);
      paramBitmap = new SpannableString("@ ");
      paramBitmap.setSpan(paramContext, 0, 1, 33);
      AppMethodBeat.o(47710);
      return paramBitmap;
      paramInt = ba.h.spannable_app_brand_link_logo;
      break;
    }
  }
  
  public final CharSequence a(String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(47709);
    final com.tencent.mm.message.c.c localc = com.tencent.mm.message.c.c.Hu(paramString);
    if (localc == null)
    {
      Log.e("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent is null, err");
      AppMethodBeat.o(47709);
      return "";
    }
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      Log.w("MicroMsg.WxaSubscribeMsgService", "context is null");
      AppMethodBeat.o(47709);
      return null;
    }
    paramString = localc.content;
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
      AppMethodBeat.o(47709);
      return null;
    }
    Object localObject = paramBundle.getString("conv_talker_username");
    final int i = paramBundle.getInt("scene");
    final long l = paramBundle.getLong("msg_sever_id");
    String str = paramBundle.getString("send_msg_username");
    paramBundle = new SpannableString(paramString);
    paramBundle.setSpan(new a(localc)
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(47706);
        Log.i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { localc.content, localc.username, localc.path, this.tlF });
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("stat_scene", i);
        ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(l));
        ((Bundle)localObject).putString("stat_chat_talker_username", this.tlF);
        ((Bundle)localObject).putString("stat_send_msg_user", this.tlG);
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1088;
        localAppBrandStatObject.hzx = "";
        localAppBrandStatObject.icZ = n.o(localAppBrandStatObject.scene, (Bundle)localObject);
        localAppBrandStatObject.ida = n.p(localAppBrandStatObject.scene, (Bundle)localObject);
        String str = "";
        localObject = str;
        if (localc.path != null)
        {
          localObject = str;
          if (localc.path.length() > 0)
          {
            byte[] arrayOfByte = Base64.decode(localc.path, 2);
            localObject = str;
            if (arrayOfByte != null) {
              localObject = new String(arrayOfByte);
            }
          }
        }
        ((t)h.ax(t.class)).a(paramAnonymousView.getContext(), localc.username, null, localc.type, 0, (String)localObject, localAppBrandStatObject);
        ((s)h.ax(s.class)).a(localc.username, new c.1.1(this));
        AppMethodBeat.o(47706);
      }
    }, paramString.indexOf(localc.title), paramString.indexOf(localc.title) + localc.title.length(), 17);
    Log.i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", new Object[] { Integer.valueOf(localc.nVT) });
    if (localc.nVT == 1)
    {
      AppMethodBeat.o(47709);
      return paramBundle;
    }
    paramString = ((s)h.ax(s.class)).Xy(localc.username);
    if (paramString != null) {}
    for (paramString = paramString.field_brandIconURL;; paramString = "")
    {
      localObject = com.tencent.mm.modelappbrand.a.b.bEY().a(paramString, null);
      if (localObject != null) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
      {
        public final void bFg() {}
        
        public final void bFh() {}
        
        public final String key()
        {
          AppMethodBeat.i(47708);
          String str = c.class.getSimpleName();
          AppMethodBeat.o(47708);
          return str;
        }
        
        public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(47707);
          NeatTextView localNeatTextView = (NeatTextView)paramWeakReference1.get();
          Object localObject = (Context)paramWeakReference.get();
          if ((localObject != null) && (localNeatTextView != null))
          {
            paramAnonymousBitmap = new BitmapDrawable(((Context)localObject).getResources(), paramAnonymousBitmap);
            paramAnonymousBitmap.setBounds(0, 0, q.DD(16), q.DD(16));
            paramAnonymousBitmap = new com.tencent.mm.plugin.appbrand.widget.j.b(paramAnonymousBitmap);
            localObject = new SpannableString("@ ");
            ((SpannableString)localObject).setSpan(paramAnonymousBitmap, 0, 1, 33);
            localNeatTextView.aZ(TextUtils.concat(new CharSequence[] { localObject, paramBundle }));
            localNeatTextView.invalidate();
          }
          AppMethodBeat.o(47707);
        }
      }, paramString, null);
      paramString = TextUtils.concat(new CharSequence[] { a(localContext, localc.nVU, null), paramBundle });
      AppMethodBeat.o(47709);
      return paramString;
    }
    paramString = TextUtils.concat(new CharSequence[] { a(localContext, localc.nVU, (Bitmap)localObject), paramBundle });
    AppMethodBeat.o(47709);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.c
 * JD-Core Version:    0.7.0.1
 */