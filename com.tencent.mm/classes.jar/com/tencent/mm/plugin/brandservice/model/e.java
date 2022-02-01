package com.tencent.mm.plugin.brandservice.model;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.util.List;

public final class e
{
  private static MMHandler nOB;
  
  static
  {
    AppMethodBeat.i(5566);
    nOB = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(5566);
  }
  
  public static c a(c paramc, ahm paramahm)
  {
    if (paramahm != null)
    {
      paramc.field_brandFlag = paramahm.pSt;
      paramc.field_brandIconURL = paramahm.pSw;
      paramc.field_brandInfo = paramahm.pSv;
      paramc.field_extInfo = paramahm.pSu;
    }
    return paramc;
  }
  
  public static void a(ImageView paramImageView, au paramau, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5565);
    if ((!paramBoolean) && (d.rs(paramau.field_type)))
    {
      a.b.h(paramImageView, paramau.field_username);
      AppMethodBeat.o(5565);
      return;
    }
    paramau = new c.a();
    paramau.oKB = d.d.brand_default_head;
    paramau.oKo = true;
    paramau.nrc = true;
    r.bKe().a(paramString, paramImageView, paramau.bKx());
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
    paramContext = f.a(paramString, paramList);
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
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.e
 * JD-Core Version:    0.7.0.1
 */