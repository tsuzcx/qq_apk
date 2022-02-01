package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;

public class n
{
  public TextView fAz;
  public ImageView fuY;
  public Context mContext;
  public TextView nBF;
  public View nBh;
  public c nCM;
  public View nCN;
  public View nCO;
  public View nCP;
  private View.OnClickListener nCu;
  
  public n()
  {
    AppMethodBeat.i(6020);
    this.nCu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6019);
        long l = ((a)g.ab(a.class)).dx(paramAnonymousView);
        paramAnonymousView = af.aDc().Ax(l);
        if (paramAnonymousView != null)
        {
          n.this.nCM.nzw.d(paramAnonymousView, 4);
          AppMethodBeat.o(6019);
          return;
        }
        ac.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        AppMethodBeat.o(6019);
      }
    };
    AppMethodBeat.o(6020);
  }
  
  public static void W(View paramView, int paramInt)
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
  
  public void a(ImageView paramImageView, t paramt, int paramInt, String paramString)
  {
    AppMethodBeat.i(6027);
    ((a)g.ab(a.class)).a(paramImageView, paramt.field_msgId, paramString, paramt.field_content, paramInt);
    paramImageView.setOnClickListener(this.nCu);
    AppMethodBeat.o(6027);
  }
  
  public void a(t paramt, v paramv, View paramView, TextView paramTextView, int paramInt) {}
  
  public final boolean a(View paramView, TextView paramTextView, t paramt, v paramv)
  {
    AppMethodBeat.i(6026);
    if ((paramv == null) || (bs.isNullOrNil(paramv.url)))
    {
      paramView.setVisibility(8);
      a(paramt, paramv, paramView, paramTextView, 0);
      AppMethodBeat.o(6026);
      return false;
    }
    p localp = ((b)g.ab(b.class)).Th(paramv.url);
    String str2 = "";
    String str1;
    if ((localp != null) && (localp.hkO != null) && (!bs.isNullOrNil(localp.hkO.hkM))) {
      str1 = localp.hkO.hkM;
    }
    while (!bs.isNullOrNil(str1))
    {
      paramView.setVisibility(0);
      paramTextView.setText(str1);
      a(paramt, paramv, paramView, paramTextView, localp.hkP.hkJ);
      AppMethodBeat.o(6026);
      return true;
      str1 = str2;
      if (localp != null)
      {
        str1 = str2;
        if (localp.hkP != null)
        {
          str1 = str2;
          if (!bs.isNullOrNil(localp.hkP.hkI)) {
            str1 = localp.hkP.hkI;
          }
        }
      }
    }
    paramView.setVisibility(8);
    a(paramt, paramv, paramView, paramTextView, 0);
    AppMethodBeat.o(6026);
    return false;
  }
  
  public final boolean a(l paraml, t paramt, v paramv)
  {
    AppMethodBeat.i(6025);
    boolean bool = a(paraml.nCp, paraml.nCq, paramt, paramv);
    AppMethodBeat.o(6025);
    return bool;
  }
  
  public final void b(Context paramContext, c paramc)
  {
    this.mContext = paramContext;
    this.nCM = paramc;
  }
  
  public void bKj()
  {
    AppMethodBeat.i(6022);
    if (this.nBh == null)
    {
      AppMethodBeat.o(6022);
      return;
    }
    this.fuY = ((ImageView)this.nBh.findViewById(2131297008));
    this.nBF = ((TextView)this.nBh.findViewById(2131302860));
    this.nCP = this.nBh.findViewById(2131297371);
    this.fAz = ((TextView)this.nBh.findViewById(2131305822));
    this.nCO = this.nBh.findViewById(2131297276);
    AppMethodBeat.o(6022);
  }
  
  public void dC(View paramView)
  {
    AppMethodBeat.i(6023);
    W(paramView, c.nyY);
    AppMethodBeat.o(6023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.n
 * JD-Core Version:    0.7.0.1
 */