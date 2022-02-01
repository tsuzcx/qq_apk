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
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  String foE;
  private TextView lfN;
  private Context mContext;
  String mTitle;
  private View mView;
  private ImageView ozi;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64187);
    this.mView = null;
    this.lfN = null;
    this.ozi = null;
    this.foE = null;
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
    this.lfN = null;
    this.ozi = null;
    this.foE = null;
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
    this.lfN = ((TextView)paramView.findViewById(16908310));
    this.ozi = ((ImageView)paramView.findViewById(2131298480));
    this.lfN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, this.mTitle, this.lfN.getTextSize()));
    if (!bs.isNullOrNil(this.foE))
    {
      this.ozi.setVisibility(0);
      g.agS();
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNs(this.foE);
      if ((paramView == null) || ((int)paramView.fLJ <= 0))
      {
        ac.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
        final long l = bs.eWj();
        ar.a.hnw.a(this.foE, "", new ar.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(64186);
            if (paramAnonymousBoolean)
            {
              ac.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bs.eWj() - l) + " ms");
              com.tencent.mm.aj.c.ag(paramAnonymousString, 3);
              p.aBy().zV(paramAnonymousString);
            }
            for (;;)
            {
              a.b.c(c.a(c.this), c.b(c.this));
              AppMethodBeat.o(64186);
              return;
              ac.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
            }
          }
        });
        AppMethodBeat.o(64190);
        return;
      }
      a.b.c(this.ozi, this.foE);
      AppMethodBeat.o(64190);
      return;
    }
    this.ozi.setVisibility(8);
    AppMethodBeat.o(64190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c
 * JD-Core Version:    0.7.0.1
 */