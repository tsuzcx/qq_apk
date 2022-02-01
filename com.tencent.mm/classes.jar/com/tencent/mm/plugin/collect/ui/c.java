package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  String fGM;
  private TextView lCL;
  private Context mContext;
  String mTitle;
  private View mView;
  private ImageView pcD;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64187);
    this.mView = null;
    this.lCL = null;
    this.pcD = null;
    this.fGM = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(2131493565);
    AppMethodBeat.o(64187);
  }
  
  public c(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(64188);
    this.mView = null;
    this.lCL = null;
    this.pcD = null;
    this.fGM = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(2131493564);
    AppMethodBeat.o(64188);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64189);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(64189);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(64190);
    super.onBindView(paramView);
    this.lCL = ((TextView)paramView.findViewById(16908310));
    this.pcD = ((ImageView)paramView.findViewById(2131298480));
    this.lCL.setText(k.b(this.mContext, this.mTitle, this.lCL.getTextSize()));
    if (!bt.isNullOrNil(this.fGM))
    {
      this.pcD.setVisibility(0);
      g.ajD();
      paramView = ((l)g.ab(l.class)).azp().aTk(this.fGM);
      if ((paramView == null) || ((int)paramView.gfj <= 0))
      {
        ad.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
        final long l = bt.flT();
        as.a.hFO.a(this.fGM, "", new as.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(64186);
            if (paramAnonymousBoolean)
            {
              ad.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bt.flT() - l) + " ms");
              com.tencent.mm.ak.c.ak(paramAnonymousString, 3);
              p.aEz().CU(paramAnonymousString);
            }
            for (;;)
            {
              a.b.c(c.a(c.this), c.b(c.this));
              AppMethodBeat.o(64186);
              return;
              ad.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
            }
          }
        });
        AppMethodBeat.o(64190);
        return;
      }
      a.b.c(this.pcD, this.fGM);
      AppMethodBeat.o(64190);
      return;
    }
    this.pcD.setVisibility(8);
    AppMethodBeat.o(64190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c
 * JD-Core Version:    0.7.0.1
 */