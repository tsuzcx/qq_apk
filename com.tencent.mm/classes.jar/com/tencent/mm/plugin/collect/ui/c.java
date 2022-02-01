package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  String fIQ;
  private TextView lHk;
  private Context mContext;
  String mTitle;
  private View mView;
  private ImageView pjj;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64187);
    this.mView = null;
    this.lHk = null;
    this.pjj = null;
    this.fIQ = null;
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
    this.lHk = null;
    this.pjj = null;
    this.fIQ = null;
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
    this.lHk = ((TextView)paramView.findViewById(16908310));
    this.pjj = ((ImageView)paramView.findViewById(2131298480));
    this.lHk.setText(k.b(this.mContext, this.mTitle, this.lHk.getTextSize()));
    if (!bu.isNullOrNil(this.fIQ))
    {
      this.pjj.setVisibility(0);
      g.ajS();
      paramView = ((l)g.ab(l.class)).azF().aUL(this.fIQ);
      if ((paramView == null) || ((int)paramView.ght <= 0))
      {
        ae.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
        final long l = bu.fpO();
        au.a.hIG.a(this.fIQ, "", new au.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(64186);
            if (paramAnonymousBoolean)
            {
              ae.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bu.fpO() - l) + " ms");
              com.tencent.mm.aj.c.al(paramAnonymousString, 3);
              p.aEP().Dw(paramAnonymousString);
            }
            for (;;)
            {
              a.b.c(c.a(c.this), c.b(c.this));
              AppMethodBeat.o(64186);
              return;
              ae.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
            }
          }
        });
        AppMethodBeat.o(64190);
        return;
      }
      a.b.c(this.pjj, this.fIQ);
      AppMethodBeat.o(64190);
      return;
    }
    this.pjj.setVisibility(8);
    AppMethodBeat.o(64190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c
 * JD-Core Version:    0.7.0.1
 */