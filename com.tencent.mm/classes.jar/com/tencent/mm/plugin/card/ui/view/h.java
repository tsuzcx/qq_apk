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
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public abstract class h
  implements ab
{
  protected MMActivity nTt;
  protected g old;
  
  public h(g paramg, MMActivity paramMMActivity)
  {
    this.old = paramg;
    this.nTt = paramMMActivity;
  }
  
  public abstract boolean bTN();
  
  public abstract boolean bTO();
  
  public void c(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    Object localObject1;
    Object localObject2;
    if (bTN())
    {
      localObject1 = (TextView)paramViewGroup.findViewById(2131298408);
      localObject2 = this.old.code;
      if ((!paramb.bPc()) && ((bs.isNullOrNil((String)localObject2)) || (((String)localObject2).length() > 40))) {
        break label299;
      }
      ((TextView)localObject1).setText(n.VF((String)localObject2));
      if (paramb.bOX())
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113672);
            if (paramAnonymousView.getId() == 2131298408)
            {
              q.GS(paramb.bPj().code);
              com.tencent.mm.ui.base.h.cg(h.this.nTt, p.getString(2131755702));
            }
            AppMethodBeat.o(113672);
            return false;
          }
        });
        this.old.d(c.ome);
      }
    }
    else if (bTO())
    {
      localObject1 = (LinearLayout)paramViewGroup.findViewById(2131298395);
      if ((paramb == null) || (paramb.bPi() == null) || (paramb.bPi().EkT == null) || (bs.isNullOrNil(paramb.bPi().EkT.title))) {
        break label321;
      }
      paramViewGroup.findViewById(2131298387).setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramb.bPi().EkT;
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131298397);
      localTextView.setText(((yg)localObject2).title);
      String str = paramb.bPi().hiu;
      if (!bs.isNullOrNil(str)) {
        localTextView.setTextColor(l.Vy(str));
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131298396);
      localObject2 = ((yg)localObject2).nUt;
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
          if (paramb.bPb())
          {
            paramAnonymousView = new j.b();
            com.tencent.mm.plugin.card.d.b.a(h.this.old.nTt, paramAnonymousView.nUh, paramAnonymousView.nUi, false, paramb);
          }
          for (;;)
          {
            t.finish();
            AppMethodBeat.o(113673);
            return;
            paramAnonymousView = paramb.bPi().EkT;
            if ((paramAnonymousView != null) && (!bs.isNullOrNil(paramAnonymousView.Ekc)) && (!bs.isNullOrNil(paramAnonymousView.Ekb)))
            {
              int i;
              if (h.this.nTt.getIntent() != null)
              {
                i = h.this.nTt.getIntent().getIntExtra("key_from_scene", 3);
                label127:
                if (h.this.nTt.getIntent() == null) {
                  break label238;
                }
              }
              label238:
              for (int j = h.this.nTt.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
              {
                com.tencent.mm.plugin.card.d.b.a(paramb.bPm(), paramAnonymousView, i, j);
                com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(20), paramb.bPm(), paramb.bPn(), "", paramAnonymousView.title });
                break;
                i = 3;
                break label127;
              }
            }
            if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
            {
              String str = l.S(paramAnonymousView.url, paramAnonymousView.Els);
              com.tencent.mm.plugin.card.d.b.a(h.this.old.nTt, str, 1);
              com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(9), paramb.bPm(), paramb.bPn(), "", paramAnonymousView.title });
              if (l.a(paramAnonymousView, paramb.bPm()))
              {
                l.VD(paramb.bPm());
                com.tencent.mm.plugin.card.d.b.b(h.this.old.nTt, paramb.bPi().nVK);
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