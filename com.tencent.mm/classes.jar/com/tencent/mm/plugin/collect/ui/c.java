package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  String eaX;
  private TextView iJG;
  private ImageView kPy;
  private Context mContext;
  String mTitle;
  private View mView;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41324);
    this.mView = null;
    this.iJG = null;
    this.kPy = null;
    this.eaX = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(2130969183);
    AppMethodBeat.o(41324);
  }
  
  public c(Context paramContext, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(41325);
    this.mView = null;
    this.iJG = null;
    this.kPy = null;
    this.eaX = null;
    this.mTitle = null;
    this.mContext = null;
    this.mContext = paramContext;
    setLayoutResource(2130969182);
    AppMethodBeat.o(41325);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41326);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(41326);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(41327);
    super.onBindView(paramView);
    this.iJG = ((TextView)paramView.findViewById(16908310));
    this.kPy = ((ImageView)paramView.findViewById(2131822958));
    this.iJG.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, this.mTitle, this.iJG.getTextSize()));
    if (!bo.isNullOrNil(this.eaX))
    {
      this.kPy.setVisibility(0);
      g.RM();
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arv(this.eaX);
      if ((paramView == null) || ((int)paramView.euF <= 0))
      {
        ab.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
        long l = bo.aoy();
        ao.a.flI.a(this.eaX, "", new c.1(this, l));
        AppMethodBeat.o(41327);
        return;
      }
      a.b.c(this.kPy, this.eaX);
      AppMethodBeat.o(41327);
      return;
    }
    this.kPy.setVisibility(8);
    AppMethodBeat.o(41327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c
 * JD-Core Version:    0.7.0.1
 */