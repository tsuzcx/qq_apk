package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.am.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  String iSn;
  private Context mContext;
  String mTitle;
  private View mView;
  private TextView pPT;
  private ImageView tXu;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64187);
    this.mView = null;
    this.pPT = null;
    this.tXu = null;
    this.iSn = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(a.g.collect_pay_info_preference);
    AppMethodBeat.o(64187);
  }
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(269452);
    this.mView = null;
    this.pPT = null;
    this.tXu = null;
    this.iSn = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(paramInt);
    AppMethodBeat.o(269452);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    this.pPT = ((TextView)paramView.findViewById(16908310));
    this.tXu = ((ImageView)paramView.findViewById(a.f.collect_payer_avatar));
    this.pPT.setText(l.b(this.mContext, this.mTitle, this.pPT.getTextSize()));
    if (!Util.isNullOrNil(this.iSn))
    {
      this.tXu.setVisibility(0);
      h.aHH();
      paramView = ((n)h.ae(n.class)).bbL().bwh(this.iSn);
      if ((paramView == null) || ((int)paramView.jxt <= 0))
      {
        Log.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
        final long l = Util.nowMilliSecond();
        az.a.ltq.a(this.iSn, "", new az.b.a()
        {
          public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(64186);
            if (paramAnonymousBoolean)
            {
              Log.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
              com.tencent.mm.am.d.aH(paramAnonymousString, 3);
              q.bhR().TB(paramAnonymousString);
            }
            for (;;)
            {
              a.b.c(c.a(c.this), c.b(c.this));
              AppMethodBeat.o(64186);
              return;
              Log.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
            }
          }
        });
        AppMethodBeat.o(64190);
        return;
      }
      a.b.c(this.tXu, this.iSn);
      AppMethodBeat.o(64190);
      return;
    }
    this.tXu.setVisibility(8);
    AppMethodBeat.o(64190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c
 * JD-Core Version:    0.7.0.1
 */