package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Set;

public final class v
  extends l
{
  MMNeat7extView nDE;
  private LinearLayout nDF;
  TextView nDm;
  
  public final void a(int paramInt1, final com.tencent.mm.ah.v paramv, t paramt, int paramInt2, u paramu, int paramInt3)
  {
    boolean bool1 = true;
    AppMethodBeat.i(6061);
    super.a(paramInt1, paramv, paramt, paramInt2, paramu, paramInt3);
    paramt.GCa = e.TA(paramt.field_talker);
    Object localObject1;
    if (bs.isNullOrNil(paramv.title))
    {
      this.nDE.setVisibility(8);
      paramInt3 = com.tencent.mm.cc.a.ig(this.mContext);
      int i = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 72);
      localObject1 = this.nDE.kv(paramInt3 - i, 2147483647);
      if (localObject1 == null) {
        break label409;
      }
    }
    label403:
    label409:
    for (paramInt3 = ((com.tencent.neattextview.textview.layout.a)localObject1).fBm();; paramInt3 = 0)
    {
      localObject1 = (LinearLayout.LayoutParams)this.nDE.getLayoutParams();
      Object localObject2 = (LinearLayout.LayoutParams)this.nDF.getLayoutParams();
      if (paramInt3 <= 3)
      {
        this.nDm.setVisibility(8);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.nDF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).gravity = 17;
        this.nDE.setMaxLines(3);
        this.nDE.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.nCN.setBackgroundResource(2131231256);
        a(this, paramt, paramv);
        localObject1 = this.nCM;
        localObject2 = this.nCN;
        if (paramInt1 <= 1) {
          break label403;
        }
      }
      for (;;)
      {
        ((c)localObject1).a(paramv, paramt, paramInt2, paramu, (View)localObject2, bool1, 0);
        AppMethodBeat.o(6061);
        return;
        this.nDE.setVisibility(0);
        this.nDE.ar(k.g(this.mContext, paramv.title, (int)this.nDE.getTextSize()));
        break;
        boolean bool2 = this.nCM.nzy.contains(paramv);
        this.nDm.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 48;
        this.nDF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 12);
        ((LinearLayout.LayoutParams)localObject1).gravity = 8388627;
        if (bool2)
        {
          this.nDE.setMaxLines(2147483647);
          this.nDm.setText(2131756619);
        }
        for (;;)
        {
          this.nDm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6059);
              if (v.this.nCM.nzy.contains(paramv))
              {
                v.this.nDE.setMaxLines(3);
                v.this.nDm.setText(2131756620);
                v.this.nCM.nzy.remove(paramv);
                AppMethodBeat.o(6059);
                return;
              }
              v.this.nDE.setMaxLines(2147483647);
              v.this.nDm.setText(2131756619);
              v.this.nCM.nzy.add(paramv);
              AppMethodBeat.o(6059);
            }
          });
          break;
          this.nDE.setMaxLines(3);
          this.nDm.setText(2131756620);
        }
        bool1 = false;
      }
    }
  }
  
  public final void a(View paramView, c paramc)
  {
    AppMethodBeat.i(6060);
    super.a(paramView, paramc);
    if (this.nBh != null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramc = (ViewStub)paramView.findViewById(2131306454);
    if (paramc == null)
    {
      AppMethodBeat.o(6060);
      return;
    }
    paramc.inflate();
    this.nBh = paramView.findViewById(2131298109);
    this.nCN = paramView.findViewById(2131298110);
    bKk();
    this.nDE = ((MMNeat7extView)paramView.findViewById(2131297361));
    this.nDE.setOnTouchListener(new g(this.nDE, new n(this.nDE.getContext())));
    this.nDm = ((TextView)paramView.findViewById(2131297362));
    this.nDF = ((LinearLayout)paramView.findViewById(2131305733));
    AppMethodBeat.o(6060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.v
 * JD-Core Version:    0.7.0.1
 */