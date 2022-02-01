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
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import java.util.List;

public final class d
{
  private static ao hfE;
  
  static
  {
    AppMethodBeat.i(5566);
    hfE = new ao(Looper.getMainLooper());
    AppMethodBeat.o(5566);
  }
  
  public static c a(c paramc, aag paramaag)
  {
    if (paramaag != null)
    {
      paramc.field_brandFlag = paramaag.iKh;
      paramc.field_brandIconURL = paramaag.iKk;
      paramc.field_brandInfo = paramaag.iKj;
      paramc.field_extInfo = paramaag.iKi;
    }
    return paramc;
  }
  
  public static void a(ImageView paramImageView, ai paramai, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5565);
    if ((!paramBoolean) && (b.ln(paramai.field_type)))
    {
      a.b.d(paramImageView, paramai.field_username);
      AppMethodBeat.o(5565);
      return;
    }
    paramai = new c.a();
    paramai.hKI = 2131231342;
    paramai.hKw = true;
    paramai.gLt = true;
    o.aFB().a(paramString, paramImageView, paramai.aFT());
    AppMethodBeat.o(5565);
  }
  
  public static Spanned b(Context paramContext, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(5563);
    if (bs.isNullOrNil(paramString))
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
    if ((paramContext.syd instanceof Spannable))
    {
      paramContext = (Spannable)paramContext.syd;
      AppMethodBeat.o(5563);
      return paramContext;
    }
    paramContext = new SpannableString(paramContext.syd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.d
 * JD-Core Version:    0.7.0.1
 */