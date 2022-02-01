package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.List;

public final class e
{
  private static MMHandler ljQ;
  
  static
  {
    AppMethodBeat.i(5566);
    ljQ = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(5566);
  }
  
  public static c a(c paramc, afa paramafa)
  {
    if (paramafa != null)
    {
      paramc.field_brandFlag = paramafa.mVM;
      paramc.field_brandIconURL = paramafa.mVP;
      paramc.field_brandInfo = paramafa.mVO;
      paramc.field_extInfo = paramafa.mVN;
    }
    return paramc;
  }
  
  public static void a(ImageView paramImageView, as paramas, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5565);
    if ((!paramBoolean) && (d.rk(paramas.field_type)))
    {
      a.b.d(paramImageView, paramas.field_username);
      AppMethodBeat.o(5565);
      return;
    }
    paramas = new c.a();
    paramas.lRP = d.d.brand_default_head;
    paramas.lRC = true;
    paramas.kPz = true;
    q.bml().a(paramString, paramImageView, paramas.bmL());
    AppMethodBeat.o(5565);
  }
  
  public static Spanned b(Context paramContext, String paramString, List<String> paramList)
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
    paramContext = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(paramString, paramList));
    if ((paramContext.BIp instanceof Spannable))
    {
      paramContext = (Spannable)paramContext.BIp;
      AppMethodBeat.o(5563);
      return paramContext;
    }
    paramContext = new SpannableString(paramContext.BIp);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e
 * JD-Core Version:    0.7.0.1
 */