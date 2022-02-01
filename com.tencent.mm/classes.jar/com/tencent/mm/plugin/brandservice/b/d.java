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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import java.util.List;

public final class d
{
  private static aq hAA;
  
  static
  {
    AppMethodBeat.i(5566);
    hAA = new aq(Looper.getMainLooper());
    AppMethodBeat.o(5566);
  }
  
  public static com.tencent.mm.api.c a(com.tencent.mm.api.c paramc, acp paramacp)
  {
    if (paramacp != null)
    {
      paramc.field_brandFlag = paramacp.jgj;
      paramc.field_brandIconURL = paramacp.jgm;
      paramc.field_brandInfo = paramacp.jgl;
      paramc.field_extInfo = paramacp.jgk;
    }
    return paramc;
  }
  
  public static void a(ImageView paramImageView, an paraman, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5565);
    if ((!paramBoolean) && (com.tencent.mm.contact.c.lO(paraman.field_type)))
    {
      a.b.d(paramImageView, paraman.field_username);
      AppMethodBeat.o(5565);
      return;
    }
    paraman = new c.a();
    paraman.igv = 2131231342;
    paraman.igj = true;
    paraman.hhW = true;
    q.aJb().a(paramString, paramImageView, paraman.aJu());
    AppMethodBeat.o(5565);
  }
  
  public static Spanned c(Context paramContext, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(5563);
    if (bu.isNullOrNil(paramString))
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
    if ((paramContext.tFv instanceof Spannable))
    {
      paramContext = (Spannable)paramContext.tFv;
      AppMethodBeat.o(5563);
      return paramContext;
    }
    paramContext = new SpannableString(paramContext.tFv);
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
    public ImageView fQl;
    public String iconUrl;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.d
 * JD-Core Version:    0.7.0.1
 */