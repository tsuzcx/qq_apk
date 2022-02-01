package com.tencent.mm.plugin.card.ui.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.d.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public abstract class h
  implements ab
{
  protected MMActivity oDq;
  protected g oVa;
  
  public h(g paramg, MMActivity paramMMActivity)
  {
    this.oVa = paramg;
    this.oDq = paramMMActivity;
  }
  
  public abstract boolean bZH();
  
  public abstract boolean bZI();
  
  public void c(ViewGroup paramViewGroup, final com.tencent.mm.plugin.card.base.b paramb)
  {
    Object localObject1;
    Object localObject2;
    if (bZH())
    {
      localObject1 = (TextView)paramViewGroup.findViewById(2131298408);
      localObject2 = this.oVa.code;
      if ((!paramb.bUW()) && ((bu.isNullOrNil((String)localObject2)) || (((String)localObject2).length() > 40))) {
        break label299;
      }
      ((TextView)localObject1).setText(n.aaf((String)localObject2));
      if (paramb.bUR())
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(113672);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
            if (paramAnonymousView.getId() == 2131298408)
            {
              q.KG(paramb.bVd().code);
              com.tencent.mm.ui.base.h.cm(h.this.oDq, p.getString(2131755702));
            }
            a.a(false, this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(113672);
            return false;
          }
        });
        this.oVa.d(c.oWb);
      }
    }
    else if (bZI())
    {
      localObject1 = (LinearLayout)paramViewGroup.findViewById(2131298395);
      if ((paramb == null) || (paramb.bVc() == null) || (paramb.bVc().GkB == null) || (bu.isNullOrNil(paramb.bVc().GkB.title))) {
        break label321;
      }
      paramViewGroup.findViewById(2131298387).setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = paramb.bVc().GkB;
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131298397);
      localTextView.setText(((aai)localObject2).title);
      String str = paramb.bVc().hDr;
      if (!bu.isNullOrNil(str)) {
        localTextView.setTextColor(l.ZY(str));
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131298396);
      localObject2 = ((aai)localObject2).oEq;
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
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (paramb.bUV())
          {
            paramAnonymousView = new j.b();
            com.tencent.mm.plugin.card.d.b.a(h.this.oVa.oDq, paramAnonymousView.oEe, paramAnonymousView.oEf, false, paramb);
          }
          for (;;)
          {
            t.finish();
            a.a(this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeViewController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113673);
            return;
            paramAnonymousView = paramb.bVc().GkB;
            if ((paramAnonymousView != null) && (!bu.isNullOrNil(paramAnonymousView.GjK)) && (!bu.isNullOrNil(paramAnonymousView.GjJ)))
            {
              int i;
              if (h.this.oDq.getIntent() != null)
              {
                i = h.this.oDq.getIntent().getIntExtra("key_from_scene", 3);
                label171:
                if (h.this.oDq.getIntent() == null) {
                  break label282;
                }
              }
              label282:
              for (int j = h.this.oDq.getIntent().getIntExtra("key_from_appbrand_type", 0);; j = 0)
              {
                com.tencent.mm.plugin.card.d.b.a(paramb.bVg(), paramAnonymousView, i, j);
                com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(20), paramb.bVg(), paramb.bVh(), "", paramAnonymousView.title });
                break;
                i = 3;
                break label171;
              }
            }
            if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
            {
              localObject = l.Z(paramAnonymousView.url, paramAnonymousView.GkZ);
              com.tencent.mm.plugin.card.d.b.a(h.this.oVa.oDq, (String)localObject, 1);
              com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(9), paramb.bVg(), paramb.bVh(), "", paramAnonymousView.title });
              if (l.a(paramAnonymousView, paramb.bVg()))
              {
                l.aad(paramb.bVg());
                com.tencent.mm.plugin.card.d.b.b(h.this.oVa.oDq, paramb.bVc().oFG);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h
 * JD-Core Version:    0.7.0.1
 */