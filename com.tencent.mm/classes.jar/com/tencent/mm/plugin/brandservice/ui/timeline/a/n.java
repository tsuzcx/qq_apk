package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;

public class n
{
  public ImageView frr;
  public TextView fwS;
  public Context mContext;
  public View mYI;
  private View.OnClickListener mZW;
  public TextView mZh;
  public c nao;
  public View nap;
  public View naq;
  public View nar;
  
  public n()
  {
    AppMethodBeat.i(6020);
    this.mZW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6019);
        long l = ((a)g.ab(a.class)).dv(paramAnonymousView);
        paramAnonymousView = af.awk().vU(l);
        if (paramAnonymousView != null)
        {
          n.this.nao.mWX.c(paramAnonymousView, 4);
          AppMethodBeat.o(6019);
          return;
        }
        ad.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        AppMethodBeat.o(6019);
      }
    };
    AppMethodBeat.o(6020);
  }
  
  public static void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(6024);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6024);
  }
  
  public void a(View paramView, c paramc)
  {
    AppMethodBeat.i(6021);
    b(paramView.getContext(), paramc);
    AppMethodBeat.o(6021);
  }
  
  public void a(ImageView paramImageView, s params, int paramInt, String paramString)
  {
    AppMethodBeat.i(6027);
    ((a)g.ab(a.class)).a(paramImageView, params.field_msgId, paramString, params.field_content, paramInt);
    paramImageView.setOnClickListener(this.mZW);
    AppMethodBeat.o(6027);
  }
  
  public void a(s params, v paramv, View paramView, TextView paramTextView, int paramInt) {}
  
  public final boolean a(View paramView, TextView paramTextView, s params, v paramv)
  {
    AppMethodBeat.i(6026);
    if ((paramv == null) || (bt.isNullOrNil(paramv.url)))
    {
      paramView.setVisibility(8);
      a(params, paramv, paramView, paramTextView, 0);
      AppMethodBeat.o(6026);
      return false;
    }
    p localp = ((b)g.ab(b.class)).OX(paramv.url);
    String str2 = "";
    String str1;
    if ((localp != null) && (localp.gKo != null) && (!bt.isNullOrNil(localp.gKo.gKm))) {
      str1 = localp.gKo.gKm;
    }
    while (!bt.isNullOrNil(str1))
    {
      paramView.setVisibility(0);
      paramTextView.setText(str1);
      a(params, paramv, paramView, paramTextView, localp.gKp.gKj);
      AppMethodBeat.o(6026);
      return true;
      str1 = str2;
      if (localp != null)
      {
        str1 = str2;
        if (localp.gKp != null)
        {
          str1 = str2;
          if (!bt.isNullOrNil(localp.gKp.gKi)) {
            str1 = localp.gKp.gKi;
          }
        }
      }
    }
    paramView.setVisibility(8);
    a(params, paramv, paramView, paramTextView, 0);
    AppMethodBeat.o(6026);
    return false;
  }
  
  public final boolean a(l paraml, s params, v paramv)
  {
    AppMethodBeat.i(6025);
    boolean bool = a(paraml.mZR, paraml.mZS, params, paramv);
    AppMethodBeat.o(6025);
    return bool;
  }
  
  public final void b(Context paramContext, c paramc)
  {
    this.mContext = paramContext;
    this.nao = paramc;
  }
  
  public void bDa()
  {
    AppMethodBeat.i(6022);
    if (this.mYI == null)
    {
      AppMethodBeat.o(6022);
      return;
    }
    this.frr = ((ImageView)this.mYI.findViewById(2131297008));
    this.mZh = ((TextView)this.mYI.findViewById(2131302860));
    this.nar = this.mYI.findViewById(2131297371);
    this.fwS = ((TextView)this.mYI.findViewById(2131305822));
    this.naq = this.mYI.findViewById(2131297276);
    AppMethodBeat.o(6022);
  }
  
  public void dA(View paramView)
  {
    AppMethodBeat.i(6023);
    V(paramView, c.mWz);
    AppMethodBeat.o(6023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.n
 * JD-Core Version:    0.7.0.1
 */