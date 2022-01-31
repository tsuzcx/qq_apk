package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.sh;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class a
{
  private static ah dPu = new ah(Looper.getMainLooper());
  
  public static com.tencent.mm.ai.d a(com.tencent.mm.ai.d paramd, sh paramsh)
  {
    if (paramsh != null)
    {
      paramd.field_brandFlag = paramsh.ffv;
      paramd.field_brandIconURL = paramsh.ffy;
      paramd.field_brandInfo = paramsh.ffx;
      paramd.field_extInfo = paramsh.ffw;
    }
    return paramd;
  }
  
  public static void a(ImageView paramImageView, ad paramad, String paramString)
  {
    if (com.tencent.mm.n.a.gR(paramad.field_type))
    {
      a.b.n(paramImageView, paramad.field_username);
      return;
    }
    paramad = new c.a();
    paramad.ery = b.c.brand_default_head;
    paramad.ere = true;
    paramad.erD = true;
    o.ON().a(paramString, paramImageView, paramad.OV());
  }
  
  public static Spanned b(Context paramContext, String paramString, List<String> paramList)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    if ((paramContext == null) || (paramList == null)) {
      return new SpannableString(paramString);
    }
    paramContext = f.a(com.tencent.mm.plugin.fts.a.a.d.a(paramString, paramList));
    if ((paramContext.kwz instanceof Spannable)) {
      return (Spannable)paramContext.kwz;
    }
    return new SpannableString(paramContext.kwz);
  }
  
  public static boolean b(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (paramTextView == null) {
      return false;
    }
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramTextView.setVisibility(8);
      return false;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramCharSequence);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.a
 * JD-Core Version:    0.7.0.1
 */