package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.c.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public abstract class h
  implements ab
{
  protected g nId;
  protected MMActivity nqt;
  
  public h(g paramg, MMActivity paramMMActivity)
  {
    this.nId = paramg;
    this.nqt = paramMMActivity;
  }
  
  public abstract boolean bMC();
  
  public abstract boolean bMD();
  
  public void c(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    Object localObject1;
    Object localObject2;
    if (bMC())
    {
      localObject1 = (TextView)paramViewGroup.findViewById(2131298408);
      localObject2 = this.nId.code;
      if ((!paramb.bHP()) && ((bt.isNullOrNil((String)localObject2)) || (((String)localObject2).length() > 40))) {
        break label299;
      }
      ((TextView)localObject1).setText(n.Rt((String)localObject2));
      if (paramb.bHK())
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113672);
            if (paramAnonymousView.getId() == 2131298408)
            {
              q.CP(paramb.bHW().code);
              com.tencent.mm.ui.base.h.cf(h.this.nqt, p.getString(2131755702));
            }
            AppMethodBeat.o(113672);
            return false;
          }
        });
        this.nId.d(c.nJe);
      }
    }
    else if (bMD())
    {
      localObject1 = (LinearLayout)paramViewGroup.findViewById(2131298395);
      if ((paramb == null) || (paramb.bHV() == null) || (paramb.bHV().CSi == null) || (bt.isNullOrNil(paramb.bHV().CSi.title))) {
        break label321;
      }
      paramViewGroup.findViewById(2131298387).setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramb.bHV().CSi;
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131298397);
      localTextView.setText(((xo)localObject2).title);
      String str = paramb.bHV().gHT;
      if (!bt.isNullOrNil(str)) {
        localTextView.setTextColor(l.Rm(str));
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131298396);
      localObject2 = ((xo)localObject2).nrt;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label308;
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setText((CharSequence)localObject2);
        paramViewGroup.setVisibility(0);
      }
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113673);
          if (paramb.bHO())
          {
            paramAnonymousView = new j.b();
            com.tencent.mm.plugin.card.d.b.a(h.this.nId.nqt, paramAnonymousView.nrh, paramAnonymousView.nri, false, paramb);
          }
          for (;;)
          {
            t.finish();
            AppMethodBeat.o(113673);
            return;
            paramAnonymousView = paramb.bHV().CSi;
            if ((paramAnonymousView != null) && (!bt.isNullOrNil(paramAnonymousView.CRr)) && (!bt.isNullOrNil(paramAnonymousView.CRq)))
            {
              int i;
              if (h.this.nqt.getIntent() != null)
              {
                i = h.this.nqt.getIntent().getIntExtra("key_from_scene", 3);
                label127:
                if (h.this.nqt.getIntent() == null) {
                  break label238;
                }
              }
              label238:
              for (int j = h.this.nqt.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
              {
                com.tencent.mm.plugin.card.d.b.a(paramb.bHZ(), paramAnonymousView, i, j);
                com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(20), paramb.bHZ(), paramb.bIa(), "", paramAnonymousView.title });
                break;
                i = 3;
                break label127;
              }
            }
            if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
            {
              String str = l.R(paramAnonymousView.url, paramAnonymousView.CSH);
              com.tencent.mm.plugin.card.d.b.a(h.this.nId.nqt, str, 1);
              com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(9), paramb.bHZ(), paramb.bIa(), "", paramAnonymousView.title });
              if (l.a(paramAnonymousView, paramb.bHZ()))
              {
                l.Rr(paramb.bHZ());
                com.tencent.mm.plugin.card.d.b.b(h.this.nId.nqt, paramb.bHV().nsK);
              }
            }
          }
        }
      });
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      label299:
      ((TextView)localObject1).setVisibility(8);
      break;
      label308:
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(8);
      }
    }
    label321:
    ((LinearLayout)localObject1).setVisibility(8);
  }
  
  public boolean g(com.tencent.mm.plugin.card.base.b paramb)
  {
    return true;
  }
  
  public void n(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h
 * JD-Core Version:    0.7.0.1
 */