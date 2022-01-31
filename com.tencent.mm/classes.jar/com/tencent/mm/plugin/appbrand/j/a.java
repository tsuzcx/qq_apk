package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

public class a
  implements j
{
  private static SpannableString a(Context paramContext, int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(132269);
    if (paramBitmap == null) {
      if (paramInt == 1) {
        paramInt = 2131232059;
      }
    }
    for (paramContext = paramContext.getResources().getDrawable(paramInt);; paramContext = new BitmapDrawable(paramContext.getResources(), paramBitmap))
    {
      paramContext.setBounds(0, 0, o.aNT(), o.aNT());
      paramContext = new com.tencent.mm.plugin.appbrand.widget.h.b(paramContext);
      paramBitmap = new SpannableString("@ ");
      paramBitmap.setSpan(paramContext, 0, 1, 33);
      AppMethodBeat.o(132269);
      return paramBitmap;
      paramInt = 2131232058;
      break;
    }
  }
  
  public final CharSequence a(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(132268);
    com.tencent.mm.af.a.a locala = com.tencent.mm.af.a.a.ne(paramString);
    Context localContext = (Context)paramWeakReference.get();
    if (localContext == null)
    {
      ab.w("MicroMsg.WxaSubscribeMsgService", "context is null");
      AppMethodBeat.o(132268);
      return null;
    }
    paramString = locala.content;
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.WxaSubscribeMsgService", "content is null, return");
      AppMethodBeat.o(132268);
      return null;
    }
    Object localObject = paramBundle.getString("conv_talker_username");
    int i = paramBundle.getInt("scene");
    long l = paramBundle.getLong("msg_sever_id");
    String str = paramBundle.getString("send_msg_username");
    paramBundle = new SpannableString(paramString);
    paramBundle.setSpan(new a.1(this, locala, (String)localObject, i, l, str), paramString.indexOf(locala.title), paramString.indexOf(locala.title) + locala.title.length(), 17);
    ab.i("MicroMsg.WxaSubscribeMsgService", "wxaSubscribeSysContent.forbids:%d", new Object[] { Integer.valueOf(locala.fki) });
    if (locala.fki == 1)
    {
      AppMethodBeat.o(132268);
      return paramBundle;
    }
    paramString = ((i)g.E(i.class)).Ae(locala.username);
    if (paramString != null) {}
    for (paramString = paramString.field_brandIconURL;; paramString = "")
    {
      localObject = com.tencent.mm.modelappbrand.a.b.acD().a(paramString, null);
      if (localObject != null) {
        break;
      }
      com.tencent.mm.modelappbrand.a.b.acD().a(new a.2(this, paramWeakReference1, paramWeakReference, paramBundle), paramString, null);
      paramString = TextUtils.concat(new CharSequence[] { a(localContext, locala.fkj, null), paramBundle });
      AppMethodBeat.o(132268);
      return paramString;
    }
    paramString = TextUtils.concat(new CharSequence[] { a(localContext, locala.fkj, (Bitmap)localObject), paramBundle });
    AppMethodBeat.o(132268);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a
 * JD-Core Version:    0.7.0.1
 */