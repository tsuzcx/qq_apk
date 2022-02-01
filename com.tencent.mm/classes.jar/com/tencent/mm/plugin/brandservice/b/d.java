package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.List;

public final class d
{
  private static MMHandler iuH;
  
  static
  {
    AppMethodBeat.i(5566);
    iuH = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(5566);
  }
  
  public static com.tencent.mm.api.c a(com.tencent.mm.api.c paramc, aer paramaer)
  {
    if (paramaer != null)
    {
      paramc.field_brandFlag = paramaer.kem;
      paramc.field_brandIconURL = paramaer.kep;
      paramc.field_brandInfo = paramaer.keo;
      paramc.field_extInfo = paramaer.ken;
    }
    return paramc;
  }
  
  public static void a(ImageView paramImageView, as paramas, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5565);
    if ((!paramBoolean) && (com.tencent.mm.contact.c.oR(paramas.field_type)))
    {
      a.b.d(paramImageView, paramas.field_username);
      AppMethodBeat.o(5565);
      return;
    }
    paramas = new c.a();
    paramas.jbq = 2131231405;
    paramas.jbe = true;
    paramas.iaT = true;
    q.bcV().a(paramString, paramImageView, paramas.bdv());
    AppMethodBeat.o(5565);
  }
  
  public static Spanned c(Context paramContext, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(5563);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(5563);
      return null;
    }
    if ((paramContext == null) || (paramList == null))
    {
      paramContext = new SpannableString(paramString);
      AppMethodBeat.o(5563);
      return paramContext;
    }
    paramContext = com.tencent.mm.plugin.fts.a.f.a(e.a(paramString, paramList));
    if ((paramContext.wWu instanceof Spannable))
    {
      paramContext = (Spannable)paramContext.wWu;
      AppMethodBeat.o(5563);
      return paramContext;
    }
    paramContext = new SpannableString(paramContext.wWu);
    AppMethodBeat.o(5563);
    return paramContext;
  }
  
  public static boolean c(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(5564);
    if (paramTextView == null)
    {
      AppMethodBeat.o(5564);
      return false;
    }
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramTextView.setVisibility(8);
      AppMethodBeat.o(5564);
      return false;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramCharSequence);
    AppMethodBeat.o(5564);
    return true;
  }
  
  public static class a
  {
    public ImageView gvv;
    public String iconUrl;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.d
 * JD-Core Version:    0.7.0.1
 */