package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  String luk;
  private Context mContext;
  String mTitle;
  private View mView;
  private TextView sUt;
  private ImageView xaN;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64187);
    this.mView = null;
    this.sUt = null;
    this.xaN = null;
    this.luk = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(a.g.collect_pay_info_preference);
    AppMethodBeat.o(64187);
  }
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(293654);
    this.mView = null;
    this.sUt = null;
    this.xaN = null;
    this.luk = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(paramInt);
    AppMethodBeat.o(293654);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
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
    this.sUt = ((TextView)paramView.findViewById(16908310));
    this.xaN = ((ImageView)paramView.findViewById(a.f.collect_payer_avatar));
    this.sUt.setText(p.b(this.mContext, this.mTitle, this.sUt.getTextSize()));
    if (!Util.isNullOrNil(this.luk))
    {
      this.xaN.setVisibility(0);
      h.baF();
      paramView = ((n)h.ax(n.class)).bzA().bxv(this.luk);
      if ((paramView == null) || ((int)paramView.maN <= 0))
      {
        Log.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
        final long l = Util.nowMilliSecond();
        az.a.okP.a(this.luk, "", new az.b.a()
        {
          public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(64186);
            if (paramAnonymousBoolean)
            {
              Log.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
              com.tencent.mm.modelavatar.d.aS(paramAnonymousString, 3);
              q.bFG().LB(paramAnonymousString);
            }
            for (;;)
            {
              a.b.g(c.a(c.this), c.b(c.this));
              AppMethodBeat.o(64186);
              return;
              Log.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
            }
          }
        });
        AppMethodBeat.o(64190);
        return;
      }
      a.b.g(this.xaN, this.luk);
      AppMethodBeat.o(64190);
      return;
    }
    this.xaN.setVisibility(8);
    AppMethodBeat.o(64190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c
 * JD-Core Version:    0.7.0.1
 */