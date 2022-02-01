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
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  String goe;
  private Context mContext;
  private TextView mPa;
  String mTitle;
  private View mView;
  private ImageView qyu;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64187);
    this.mView = null;
    this.mPa = null;
    this.qyu = null;
    this.goe = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(2131493681);
    AppMethodBeat.o(64187);
  }
  
  public c(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(64188);
    this.mView = null;
    this.mPa = null;
    this.qyu = null;
    this.goe = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(2131493680);
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
    this.mPa = ((TextView)paramView.findViewById(16908310));
    this.qyu = ((ImageView)paramView.findViewById(2131298899));
    this.mPa.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, this.mTitle, this.mPa.getTextSize()));
    if (!Util.isNullOrNil(this.goe))
    {
      this.qyu.setVisibility(0);
      g.aAi();
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(this.goe);
      if ((paramView == null) || ((int)paramView.gMZ <= 0))
      {
        Log.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
        final long l = Util.nowMilliSecond();
        ay.a.iDq.a(this.goe, "", new ay.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(64186);
            if (paramAnonymousBoolean)
            {
              Log.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
              com.tencent.mm.aj.c.ap(paramAnonymousString, 3);
              p.aYD().Mg(paramAnonymousString);
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
      a.b.c(this.qyu, this.goe);
      AppMethodBeat.o(64190);
      return;
    }
    this.qyu.setVisibility(8);
    AppMethodBeat.o(64190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c
 * JD-Core Version:    0.7.0.1
 */