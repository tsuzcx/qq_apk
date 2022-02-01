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
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import java.util.List;

public final class e
{
  private static ap gFd;
  
  static
  {
    AppMethodBeat.i(5566);
    gFd = new ap(Looper.getMainLooper());
    AppMethodBeat.o(5566);
  }
  
  public static c a(c paramc, zi paramzi)
  {
    if (paramzi != null)
    {
      paramc.field_brandFlag = paramzi.ika;
      paramc.field_brandIconURL = paramzi.ikd;
      paramc.field_brandInfo = paramzi.ikc;
      paramc.field_extInfo = paramzi.ikb;
    }
    return paramc;
  }
  
  public static void a(ImageView paramImageView, af paramaf, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5565);
    if ((!paramBoolean) && (b.ls(paramaf.field_type)))
    {
      a.b.d(paramImageView, paramaf.field_username);
      AppMethodBeat.o(5565);
      return;
    }
    paramaf = new c.a();
    paramaf.hkf = 2131231342;
    paramaf.hjT = true;
    paramaf.gkG = true;
    o.ayJ().a(paramString, paramImageView, paramaf.azc());
    AppMethodBeat.o(5565);
  }
  
  public static Spanned b(Context paramContext, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(5563);
    if (bt.isNullOrNil(paramString))
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
    if ((paramContext.rpj instanceof Spannable))
    {
      paramContext = (Spannable)paramContext.rpj;
      AppMethodBeat.o(5563);
      return paramContext;
    }
    paramContext = new SpannableString(paramContext.rpj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e
 * JD-Core Version:    0.7.0.1
 */