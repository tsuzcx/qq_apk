package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Set;

public final class v
  extends l
{
  TextView naO;
  MMNeat7extView nbg;
  private LinearLayout nbh;
  
  public final void a(int paramInt1, final com.tencent.mm.ai.v paramv, s params, int paramInt2, u paramu, int paramInt3)
  {
    boolean bool1 = true;
    AppMethodBeat.i(6061);
    super.a(paramInt1, paramv, params, paramInt2, paramu, paramInt3);
    params.Feq = e.Pp(params.field_talker);
    Object localObject1;
    if (bt.isNullOrNil(paramv.title))
    {
      this.nbg.setVisibility(8);
      paramInt3 = com.tencent.mm.cd.a.hV(this.mContext);
      int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 72);
      localObject1 = this.nbg.ki(paramInt3 - i, 2147483647);
      if (localObject1 == null) {
        break label409;
      }
    }
    label403:
    label409:
    for (paramInt3 = ((com.tencent.neattextview.textview.layout.a)localObject1).fkV();; paramInt3 = 0)
    {
      localObject1 = (LinearLayout.LayoutParams)this.nbg.getLayoutParams();
      Object localObject2 = (LinearLayout.LayoutParams)this.nbh.getLayoutParams();
      if (paramInt3 <= 3)
      {
        this.naO.setVisibility(8);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.nbh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).gravity = 17;
        this.nbg.setMaxLines(3);
        this.nbg.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.nap.setBackgroundResource(2131231256);
        a(this, params, paramv);
        localObject1 = this.nao;
        localObject2 = this.nap;
        if (paramInt1 <= 1) {
          break label403;
        }
      }
      for (;;)
      {
        ((c)localObject1).a(paramv, params, paramInt2, paramu, (View)localObject2, bool1, 0);
        AppMethodBeat.o(6061);
        return;
        this.nbg.setVisibility(0);
        this.nbg.aq(k.f(this.mContext, paramv.title, (int)this.nbg.getTextSize()));
        break;
        boolean bool2 = this.nao.mWZ.contains(paramv);
        this.naO.setVisibility(0);
        ((LinearLayout.LayoutParams)localObject2).gravity = 48;
        this.nbh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12);
        ((LinearLayout.LayoutParams)localObject1).gravity = 8388627;
        if (bool2)
        {
          this.nbg.setMaxLines(2147483647);
          this.naO.setText(2131756619);
        }
        for (;;)
        {
          this.naO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(6059);
              if (v.this.nao.mWZ.contains(paramv))
              {
                v.this.nbg.setMaxLines(3);
                v.this.naO.setText(2131756620);
                v.this.nao.mWZ.remove(paramv);
                AppMethodBeat.o(6059);
                return;
              }
              v.this.nbg.setMaxLines(2147483647);
              v.this.naO.setText(2131756619);
              v.this.nao.mWZ.add(paramv);
              AppMethodBeat.o(6059);
            }
          });
          break;
          this.nbg.setMaxLines(3);
          this.naO.setText(2131756620);
        }
        bool1 = false;
      }
    }
  }
  
  public final void a(View paramView, c paramc)
  {
    AppMethodBeat.i(6060);
    super.a(paramView, paramc);
    if (this.mYI != null)
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
    this.mYI = paramView.findViewById(2131298109);
    this.nap = paramView.findViewById(2131298110);
    bDb();
    this.nbg = ((MMNeat7extView)paramView.findViewById(2131297361));
    this.nbg.setOnTouchListener(new g(this.nbg, new n(this.nbg.getContext())));
    this.naO = ((TextView)paramView.findViewById(2131297362));
    this.nbh = ((LinearLayout)paramView.findViewById(2131305733));
    AppMethodBeat.o(6060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.v
 * JD-Core Version:    0.7.0.1
 */