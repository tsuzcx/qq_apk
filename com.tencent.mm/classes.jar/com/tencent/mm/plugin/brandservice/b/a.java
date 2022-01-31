package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class a
{
  private static ak feT;
  
  static
  {
    AppMethodBeat.i(13825);
    feT = new ak(Looper.getMainLooper());
    AppMethodBeat.o(13825);
  }
  
  public static com.tencent.mm.aj.d a(com.tencent.mm.aj.d paramd, wd paramwd)
  {
    if (paramwd != null)
    {
      paramd.field_brandFlag = paramwd.gxd;
      paramd.field_brandIconURL = paramwd.gxg;
      paramd.field_brandInfo = paramwd.gxf;
      paramd.field_extInfo = paramwd.gxe;
    }
    return paramd;
  }
  
  public static void a(ImageView paramImageView, ad paramad, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13824);
    if ((!paramBoolean) && (com.tencent.mm.n.a.je(paramad.field_type)))
    {
      a.b.s(paramImageView, paramad.field_username);
      AppMethodBeat.o(13824);
      return;
    }
    paramad = new c.a();
    paramad.eOa = 2130838028;
    paramad.eNL = true;
    paramad.eOk = true;
    o.ahG().a(paramString, paramImageView, paramad.ahY());
    AppMethodBeat.o(13824);
  }
  
  public static Spanned b(Context paramContext, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(13822);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(13822);
      return null;
    }
    if ((paramContext == null) || (paramList == null))
    {
      paramContext = new SpannableString(paramString);
      AppMethodBeat.o(13822);
      return paramContext;
    }
    paramContext = f.a(com.tencent.mm.plugin.fts.a.a.d.a(paramString, paramList));
    if ((paramContext.mSp instanceof Spannable))
    {
      paramContext = (Spannable)paramContext.mSp;
      AppMethodBeat.o(13822);
      return paramContext;
    }
    paramContext = new SpannableString(paramContext.mSp);
    AppMethodBeat.o(13822);
    return paramContext;
  }
  
  public static boolean b(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(13823);
    if (paramTextView == null)
    {
      AppMethodBeat.o(13823);
      return false;
    }
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramTextView.setVisibility(8);
      AppMethodBeat.o(13823);
      return false;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramCharSequence);
    AppMethodBeat.o(13823);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.a
 * JD-Core Version:    0.7.0.1
 */